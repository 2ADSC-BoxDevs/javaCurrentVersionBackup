package banco;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author kauan.mendes
 */
public class Insercao {

    Conexao connection = new Conexao();
    JdbcTemplate con = connection.getConnectionLocal();
    JdbcTemplate conAzu = connection.getConnectionNuvem();

    public void reiniciarMaquina(Integer id_maquina) {

//        con.update("UPDATE maquina set isActive = 'sim' WHERE id_maquina = ?;",
//                id_maquina);

        conAzu.update("UPDATE maquina set isActive = 'sim' WHERE id_maquina = ?;",
                 id_maquina);

    }

}
