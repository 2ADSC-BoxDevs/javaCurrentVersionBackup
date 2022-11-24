package banco;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author kauan.mendes
 */
public class Insercao {

    Conexao connection = new Conexao();
    JdbcTemplate con = connection.getConnectionLocal();

    public void reiniciarMaquina(Integer id_maquina) {

        con.update("UPDATE maquina set isActivade = '1' WHERE id_maquina = ?;",
                 id_maquina);
    }

}
