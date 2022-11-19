package banco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Specula
 */
public class Conexao {

    private JdbcTemplate connectionLocal;

    private JdbcTemplate connectionNuvem;

    public Conexao() {

        BasicDataSource dataSource = new BasicDataSource();

        dataSource​.setDriverClassName("com.mysql.cj.jdbc.Driver");

         dataSource​.setUrl("jdbc:mysql://172.31.16.213:3306/specula");
        dataSource​.setUrl("jdbc:mysql://localhost:3306/specula");

        dataSource​.setUsername("root");

        // dataSource​.setPassword("urubu100");
        dataSource​.setPassword("#Gf53187038875");

        BasicDataSource dataSourceAzure = new BasicDataSource();

        dataSourceAzure.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        dataSourceAzure.setUrl("jdbc:sqlserver://specula.database.windows.net:1433;database=specula");

        dataSourceAzure.setUsername("specula@specula");

        dataSourceAzure.setPassword("#Gfgrupo3");

        this.connectionNuvem = new JdbcTemplate(dataSourceAzure);

        this.connectionLocal = new JdbcTemplate(dataSource);

    }

    public JdbcTemplate getConnectionLocal() {

        return connectionLocal;

    }

    public JdbcTemplate getConnectionNuvem() {
        return connectionNuvem;
    }

}