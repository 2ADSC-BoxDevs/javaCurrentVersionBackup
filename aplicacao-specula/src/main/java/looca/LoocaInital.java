/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package looca;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import java.io.IOException;

/**
 *
 * @author kauan.mendes
 */
public class LoocaInital {

    Double usoProcessador = 0.0;
    Long emUsoRAM = 00000000000L;//
    Long disponivelRAM = 00000000000L;//
    String idTotem = "";//
    Long memoriaRAMTotal = 0000000000L;//

    public Long getMemoriaRAMTotal() {
        return memoriaRAMTotal;
    }

    public String getIdTotem() {
        return idTotem;
    }

    public Double getUsoProcessador() {
        return usoProcessador;
    }

    public Long getEmUsoRAM() {
        return emUsoRAM;
    }

    public Long getDisponivelRAM() {
        return disponivelRAM;
    }

    // https://github.com/Britooo/looca-api/blob/main/README.md
    Looca looca = new Looca();

    //sistema
    Sistema sistema = looca.getSistema();
    Sistema loopSistema = looca.getSistema();
    Memoria memoria = looca.getMemoria();
    Memoria loopMemoria = looca.getMemoria();
    Processador processador = looca.getProcessador();
    Processador loopProcessador = looca.getProcessador();
    Temperatura loopTemperatura = looca.getTemperatura();




    void dadosSistema() {
        sistema.getSistemaOperacional();
        //sistema.getFabricante();
        //sistema.getArquitetura();
        //sistema.getPermissao();

        System.out.println(sistema);
    }

    void loopDadosSistema() {
        loopSistema.getInicializado();
        System.out.println(loopSistema);
    }

    //memoria
    void dadosMemoria() {
        memoriaRAMTotal = (memoria.getTotal());

        System.out.println(memoria);
    }

    void loopDadosMemoria() {
        emUsoRAM = loopMemoria.getEmUso();
        System.out.println(emUsoRAM);
        disponivelRAM = loopMemoria.getDisponivel();
//        disponivelRAM = Double.longBitsToDouble(loopMemoria.getDisponivel());

        System.out.println(loopMemoria);
    }

    //Processador
    void dadosProcessador() {
        //processador.getFabricante();
        //processador.getNome();
        idTotem = processador.getId();
        //processador.getIdentificador();
        //processador.getMicroarquitetura();
        //processador.getFrequencia();
        //processador.getNumeroPacotesFisicos();
        //processador.getNumeroCpusFisicas();
        //processador.getNumeroCpusLogicas();

        System.out.println(processador);
    }

    void loopDadosProcessador() {

        usoProcessador = loopProcessador.getUso();

        System.out.println(loopProcessador);

        System.out.println(loopMemoria);
    }

    //Temperatura
    void loopDadosTemperatura() {
        loopTemperatura.getTemperatura();

        System.out.println(loopTemperatura);
    }

    public void pegarDados() {
        dadosSistema();
        dadosMemoria();
        dadosProcessador();

     
    }

    public void loopPegarDados() throws IOException, InterruptedException {
        loopDadosSistema();
        loopDadosMemoria();
        loopDadosProcessador();
        loopDadosTemperatura();

    }
}
