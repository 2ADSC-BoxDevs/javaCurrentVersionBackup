/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacao;

import alerta.SlackAlert;
import banco.Conexao;
import banco.Empresa;
import banco.Maquina;
import banco.UsuarioMaquina;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import log.Logs;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author joao.barbosa
 */
public class Cli {

  private static String nomeUsuarioMaquina;      
  private static String identificacaoUsuario; 
  
  
    public static void main(String[] args) {
       
        Scanner leitor= new Scanner(System.in);
        
      
        
        
        
        
        
        Conexao conexao = new Conexao();
        JdbcTemplate bancoLocal = conexao.getConnectionLocal();
        JdbcTemplate bancoAzure = conexao.getConnectionNuvem();
        Looca looca = new Looca();
        Inovacao innovation = new Inovacao();
        
          Boolean logado=true;
          
        
       String nome;
         String identi;
        Boolean userExiste = false;
        Integer idUser = 0;
        Integer idEmpresa = 0;
        List<Empresa> empresas = bancoAzure.query("SELECT * FROM empresa ", new BeanPropertyRowMapper<>(Empresa.class));
        List<UsuarioMaquina> usuarios = bancoAzure.query("SELECT * FROM usuario_maquina ", new BeanPropertyRowMapper<>(UsuarioMaquina.class));
     
        while(logado){
         System.out.println("Entre com seu nome: \n");
        nome= leitor.nextLine();
        System.out.println("Entre com sua identificacao: \n");
        identi= leitor.nextLine();

       nomeUsuarioMaquina  = nome;
       identificacaoUsuario  = identi;
        String msgErro;
        
        for (UsuarioMaquina usuario : usuarios) {

            if (usuario.getNome_usuario_maquina().equals(nomeUsuarioMaquina) && usuario.getIdentificacao_usuario().equals(identificacaoUsuario)) {

                userExiste = true;
               

                Logs.escreverTexto("logs/testeArquivo", "\n Login Realizado com Sucesso!"
                        + "\n Data e hora: ");

                System.out.println("Seja muito bem vindo a nossa aplicação " + nomeUsuarioMaquina + "!\n\nDados e métricas da maquina abaixo\n");

                idUser = usuario.getId_usuario_maquina();
                
                
                //Pega o id da empresa
        for (Empresa empresa : empresas) {

            idEmpresa = empresa.getId_empresa();

        }

        Maquina maquinaSave = new Maquina();

        if (userExiste == true) {

            Integer fkMaquina = 0;
            List<Maquina> maquinas = bancoAzure.query("SELECT *  FROM maquina", new BeanPropertyRowMapper<>(Maquina.class));

            for (int i = 0; i < maquinas.size(); i++) {

                if (Objects.equals(maquinas.get(i).getFk_usuario_maquina(), idUser)) {

                    fkMaquina = maquinas.get(i).getId_maquina();
                    maquinaSave.setId_maquina(fkMaquina);

                }

            }
            System.out.println(idUser);
            System.out.println(fkMaquina);
            if (idUser == fkMaquina) {

                
                maquinaSave.setId_maquina(fkMaquina);
                Sistema sistema = looca.getSistema();
                Processador processador = looca.getProcessador();
                Memoria memoria = looca.getMemoria();

                
                
                Long totalDisco= looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
                
               
                
                Long discoEmUso = (looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() - looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel()) / 1000000000; //valor usado - x

                
              
                
                
                Long porcentagemDisco= discoEmUso*100/totalDisco;
                 
                Long utilizado = (memoria.getEmUso() / 1000000000) * 100 / (memoria.getTotal() / 1000000000);

                Long disponivel = 100 - utilizado;


                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        if (utilizado >= 6) {

                            SlackAlert.sendMessageToSlack("Alerta! a maquina com o id" + processador.getId() + " do usuario " + nomeUsuarioMaquina + " Esta apresentando problemas, o uso da memoria esta muito acima do normal.");

                            Logs.escreverTexto("logs/alertas_uso", "\n Memoria RAM está sobrecarregada"
                                    + "\n Data e hora: ");

                        }
                        if (processador.getUso() > 20.0) {

                            SlackAlert.sendMessageToSlack("Alerta! a maquina com o id" + processador.getId() + " do usuario " + nomeUsuarioMaquina + " Esta apresentando problemas, o uso da processador esta muito alto, o computador pode travar.");

                            Logs.escreverTexto("logs/alertas_uso", "\n Processador está sobrecarregado"
                                    + "\n Data e hora: ");

                        }
                        if (disponivel < 3) {

                            SlackAlert.sendMessageToSlack("Alerta! a maquina com o id" + processador.getId() + " do usuario " + nomeUsuarioMaquina + " Esta apresentando problemas, Resta pouca memoria, seu computador pode travar");

                            Logs.escreverTexto("logs/alertas_uso", "\n Memoria RAM está sobrecarregada"
                                    + "\n Data e hora: ");
                        }

                    }
                }, 0, 7000);

//             função SetInterval
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        Long utilizado = (memoria.getEmUso() / 1000000000) * 100 / (memoria.getTotal() / 1000000000);

                        Long disponivel = 100 - utilizado;

                        innovation.desligar(maquinaSave.getId_maquina(), sistema.getSistemaOperacional());

//                        String insert = "Insert into historico_maquina values (null,?,?,?,?,?,now());";
//                        bancoLocal.update(insert, maquinaSave.getId_maquina(), sistema.getSistemaOperacional(), utilizado, disponivel, processador.getUso());
//                        System.out.println("Inserindo informações no banco local");
                        String insertAzure = "Insert into historico_maquina (fk_maquina,sistema_operacional,memoriaRam_emUso,memoriaRam_disponivel,processador_emUso,discoEmUso) values (?,?,?,?,?,?)";
                        bancoAzure.update(insertAzure, maquinaSave.getId_maquina(), sistema.getSistemaOperacional(), utilizado, disponivel, processador.getUso(),porcentagemDisco );
                        System.out.println("Inserindo informações no banco na Nuvem");
                    }
                }, 0, 6000);

            } else {

                Processador processador = looca.getProcessador();
                Memoria memoria = looca.getMemoria();
                Sistema sistema = looca.getSistema();
                DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
                Long capacidade = memoria.getTotal() / 1000000000;
                Long capacidadeDisco = grupoDeDiscos.getTamanhoTotal() / 1000000000;

//                JOptionPane.showMessageDialog(this, "Usuario não tem maquina. \n Cadastramos essa no banco  \nAperte no botão novamente para rodar.");

//                String insertMaquina = "insert into maquina (fk_empresa,fk_usuario_maquina,isActive,codigo_patrimonio,cpu_detalhe,ram_detalhe,disco_detalhe) values (?,?,?,?,?,?,?)";
//                bancoLocal.update(insertMaquina, idEmpresa, idUser, 1, processador.getId(), processador.getNumeroCpusFisicas(), capacidade, capacidadeDisco);
                String insertAzure = "Insert into maquina (fk_empresa,fk_usuario_maquina, isActive,codigo_patrimonio,cpu_detalhe,ram_detalhe,disco_detalhe,sistema_operacional) values (?,?,'sim',?,?,?,?,?)";
                bancoAzure.update(insertAzure, idEmpresa, idUser, processador.getId(), processador.getNumeroCpusFisicas(), capacidade, capacidadeDisco, sistema.getSistemaOperacional());
            }
        } else {

//            JOptionPane.showMessageDialog(this, "Usuário não encontrado\nVerifique seus dados e tente novamente ");


}
        
                
                
                
                
                logado=false;
            } else {
               
                         
                           

                
            }
            

        }
        msgErro = "Nome ou indentificação errados, tente novamente";
                             System.out.println(msgErro);
                             Logs.escreverTexto("logs/testeArquivo", "\n Falha ao realizar login!"
                        + "\n Data e hora: ");
         
}
        
        
       
        
    }
    
   
}

