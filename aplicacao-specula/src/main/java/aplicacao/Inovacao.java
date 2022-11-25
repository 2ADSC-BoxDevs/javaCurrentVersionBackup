package aplicacao;

import banco.Consultas;
import banco.Insercao;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author kauan.mendes
 */
public class Inovacao {

    static final Runtime run = Runtime.getRuntime();
    static Process pro;
    static BufferedReader read;
    Consultas cs = new Consultas();
    Insercao ins = new Insercao();

    public void desligar(Integer id_maquina, String sistema_operacional) {
        boolean isDesligar = cs.desligarMaquina(id_maquina);

        if (isDesligar) {
            String[] cmds = {
                "cmd /c start cmd.exe",
                "shutdown /r"
            };

            ins.reiniciarMaquina(id_maquina);

            try {

                if (sistema_operacional.equals("Ubuntu")) {
                    pro = run.exec("sudo shutdown -r now");
                    System.out.println("Vamos reiniciar sua maquina");
                } else {
                    pro = run.exec(String.join("& ", cmds));
                }
                read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
                read.readLine();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
