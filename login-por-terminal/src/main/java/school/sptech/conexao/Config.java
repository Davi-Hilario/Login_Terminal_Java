package school.sptech.conexao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import io.github.cdimascio.dotenv.Dotenv;


public class Config {
     private JdbcTemplate conexao;
     // private Dotenv dotenv;

     public Config(){
        // dotenv = Dotenv.load();
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Eyes_On_Server");
        dataSource.setUsername("");
        dataSource.setPassword("");

        conexao = new JdbcTemplate(dataSource);

     }

     public JdbcTemplate iniciarConexao(){
         return conexao;
     }
}
