package aplicacao;

import alerta.SlackAlert;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import banco.Conexao;
import log.Logs;
import banco.Maquina;
import banco.UsuarioMaquina;

import static java.lang.Thread.sleep;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

public class TelaLogi extends javax.swing.JFrame {

    public TelaLogi() {

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaLogi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaLogi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaLogi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaLogi.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        inputSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PerCount = new javax.swing.JLabel();
        progress = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(39, 41, 50));

        jPanel1.setBackground(new java.awt.Color(39, 41, 50));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(223, 41, 53));
        jLabel1.setText("LOGIN");

        inputEmail.setBackground(new java.awt.Color(71, 69, 69));
        inputEmail.setForeground(new java.awt.Color(255, 255, 255));
        inputEmail.setText(" Entre com seu nome");
        inputEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(223, 41, 53)));
        inputEmail.setDoubleBuffered(true);
        inputEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputEmailFocusLost(evt);
            }
        });
        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(223, 41, 53));
        btnLogin.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.setBorder(null);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        inputSenha.setBackground(new java.awt.Color(71, 69, 69));
        inputSenha.setForeground(new java.awt.Color(255, 255, 255));
        inputSenha.setText(" Entre com sua identificacao");
        inputSenha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(223, 41, 53)));
        inputSenha.setEchoChar('\u0000');
        inputSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inputSenhaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inputSenhaFocusLost(evt);
            }
        });
        inputSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSenhaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Indentificação");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/imglogin.png"))); // NOI18N

        PerCount.setBackground(new java.awt.Color(255, 255, 255));
        PerCount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PerCount.setForeground(new java.awt.Color(255, 255, 255));
        PerCount.setText("‎ ");

        progress.setBackground(new java.awt.Color(71, 69, 69));
        progress.setForeground(new java.awt.Color(223, 41, 53));
        progress.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(inputSenha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(inputEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(157, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(151, 151, 151))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(145, 145, 145))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(PerCount)
                                .addGap(203, 203, 203)))))
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PerCount))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(180, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inputEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputEmailFocusGained
        if (inputEmail.getText().equals(" Entre com seu nome")) {
            inputEmail.setText("");
            inputEmail.setForeground(new java.awt.Color(255, 255, 255));
        }
    }//GEN-LAST:event_inputEmailFocusGained

    private void inputEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputEmailFocusLost
        if (inputEmail.getText().equals("")) {
            inputEmail.setText(" Entre com seu nome");
            inputEmail.setForeground(new java.awt.Color(211, 211, 211));
        }
    }//GEN-LAST:event_inputEmailFocusLost

    private void inputSenhaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSenhaFocusGained
        // TODO add your handling code here:
        if (inputSenha.getText().equals(" Entre com sua identificacao")) {
            inputSenha.setText("");
            inputSenha.setEchoChar('\u2022');
            inputSenha.setForeground(new java.awt.Color(255, 255, 255));

        }
    }//GEN-LAST:event_inputSenhaFocusGained

    private void inputSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inputSenhaFocusLost
        if (inputSenha.getText().equals("")) {
            inputSenha.setText(" Entre com sua identificacao");
            inputSenha.setEchoChar('\u0000');
            inputSenha.setForeground(new java.awt.Color(211, 211, 211));

        }
    }//GEN-LAST:event_inputSenhaFocusLost

    private void inputSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSenhaActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed

        new Thread() {
            public void run() {

                for (int i = 0; i < 150; i += 5) {
                    try {
                        sleep(40);
                        progress.setValue(i);

                    } catch (InterruptedException ex) {

                    }

                }

                progress.setValue(0);

            }

        }.start();

        Conexao conexao = new Conexao();
        JdbcTemplate bancoLocal = conexao.getConnectionLocal();
        JdbcTemplate bancoAzure = conexao.getConnectionNuvem();
        Looca looca = new Looca();

        String nomeUsuarioMaquina = inputEmail.getText();
        String identificacaoUsuario = inputSenha.getText();

        Boolean userExiste = false;
        Integer idUser = 0;
        List<UsuarioMaquina> usuarios = bancoLocal.query("SELECT * FROM usuario_maquina ", new BeanPropertyRowMapper<>(UsuarioMaquina.class));

        for (UsuarioMaquina usuario : usuarios) {

            if (usuario.getNome_usuario_maquina().equals(nomeUsuarioMaquina) && usuario.getIdentificacao_usuario().equals(identificacaoUsuario)) {

                userExiste = true;

                Logs.escreverTexto("/home/kauan.mendes/Área de Trabalho/ProjetoPI/javaCurrentVersion/testeArquivo", "\n Login Realizado com Sucesso!"
                        + "\n Data e hora: ");

                System.out.println("Seja muito bem vindo a nossa aplicação " + nomeUsuarioMaquina + "!\n\nDados e métricas da maquina abaixo\n");
                idUser = usuario.getId_usuario_maquina();

            }

        }

        Maquina maquinaSave = new Maquina();

        if (userExiste == true) {

            Integer fkMaquina = 0;
            List<Maquina> maquinas = bancoLocal.query("SELECT *  FROM maquina", new BeanPropertyRowMapper<>(Maquina.class));

            for (int i = 0; i < maquinas.size(); i++) {

                if (Objects.equals(maquinas.get(i).getFk_usuario_maquina(), idUser)) {

                    fkMaquina = maquinas.get(i).getId_maquina();
                    maquinaSave.setId_maquina(fkMaquina);

                }

            }

            if (idUser == fkMaquina) {

                maquinaSave.setId_maquina(fkMaquina);
                Sistema sistema = looca.getSistema();
                Processador processador = looca.getProcessador();
                Memoria memoria = looca.getMemoria();
                DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();

                JOptionPane.showMessageDialog(null, "Usuário logou\nBem vindo! " + nomeUsuarioMaquina);

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        if (memoria.getEmUso() > 3) {

                            SlackAlert.sendMessageToSlack("Alerta! a maquina esta com o id" + processador.getId() + " do usuario " + nomeUsuarioMaquina + " Esta apresentando problemas na memoria.");

                        }
                        if (processador.getFrequencia() > 4) {

                            SlackAlert.sendMessageToSlack("Alerta! O uso da processador esta muito alto, seu computador irá travar");

                        }
                        if (memoria.getDisponivel() > 2.5) {

                            SlackAlert.sendMessageToSlack("Alerta! Resta pouca memoria, seu computador irá travar");
                        }

                    }
                }, 0, 3000);

//             função SetInterval
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        String insert = "Insert into historico_maquina values (null,?,?,?,?,?,now())";
                        bancoLocal.update(insert, maquinaSave.getId_maquina(), sistema.getSistemaOperacional(), memoria.getEmUso(), memoria.getDisponivel(), processador.getUso());
                        System.out.println("Inserindo informações no banco local");

//                        String insertAzure = "Insert into historico_maquina (fk_maquina,sistema_operacional,memoria_em_uso,memoria_disponivel,processador_em_uso) values (?,?,?,?,?)";
//                        bancoAzure.update(insertAzure, maquinaSave.getId_maquina(), sistema.getSistemaOperacional(), memoria.getEmUso(), memoria.getDisponivel(), processador.getUso());
//                        System.out.println("Inserindo informações no banco na Nuvem");

                    }
                }, 0, 6000);

            } else {

                Logs.escreverTexto("/home/kauan.mendes/Área de Trabalho/ProjetoPI/javaCurrentVersion/testeArquivo", "\n Falha no login!" + "\n Data e hora: ");
                Processador processador = looca.getProcessador();
                Memoria memoria = looca.getMemoria();
                DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
                JOptionPane.showMessageDialog(this, "Usuario não tem maquina. \n Cadastramos essa no banco  \nAperte no botão novamente para rodar.");

                String insertMaquina = "insert into maquina (fk_empresa,fk_usuario_maquina,isActivade,codigo_patrimonio,cpu_detalhe,ram_detalhe,disco_detalhe) values (1,?,?,?,?,?,?)";
                bancoLocal.update(insertMaquina, idUser, "ativo", processador.getId(), processador.getNumeroCpusFisicas(), memoria.getTotal(), grupoDeDiscos.getTamanhoTotal());

//                String insertAzure = "Insert into maquina (fk_empresa,fk_usuario_maquina, isActivade,codigo_patrimonio,cpu_detalhe,ram_detalhe,disco_detalhe) values (1,1,?,?,?,?,?)";
//                bancoAzure.update(insertAzure, "ativo", processador.getId(), processador.getNumeroCpusFisicas(), memoria.getTotal(), grupoDeDiscos.getTamanhoTotal());

            }
        } else {

            JOptionPane.showMessageDialog(this, "Usuário não encontrado\nVerifique seus dados e tente novamente ");
        }

    }//GEN-LAST:event_btnLoginActionPerformed


    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        btnLogin.setBackground(new java.awt.Color(39, 41, 50));
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        btnLogin.setBackground(new java.awt.Color(223, 41, 53));

    }//GEN-LAST:event_btnLoginMouseExited

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputEmailActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaLogi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaLogi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaLogi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaLogi().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PerCount;
    private javax.swing.JButton btnLogin;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar progress;
    // End of variables declaration//GEN-END:variables
}
