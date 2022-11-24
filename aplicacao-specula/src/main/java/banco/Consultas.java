




 package banco;

import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;


 // @author kauan.mendes
  
  
public class Consultas {

    Conexao connection = new Conexao();
    JdbcTemplate con = connection.getConnectionLocal();

    public boolean desligarMaquina(Integer id_maquina) {
        try {
            Map<String, Object> registro = con.queryForMap(
                    "select * from maquina where id_maquina = ? and  isActivade = 'd';", id_maquina);

            return registro.size() > 1;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }

    }



}