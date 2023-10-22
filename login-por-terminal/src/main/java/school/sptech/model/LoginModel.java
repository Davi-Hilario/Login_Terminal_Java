package school.sptech.model;

import school.sptech.conexao.Config;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import school.sptech.login.Login;

import java.util.List;

public class LoginModel {
    private Config con;
    private JdbcTemplate conexao;

    public LoginModel() {
        this.con = new Config();
        this.conexao = con.iniciarConexao();
    }

    public boolean entrar(String login, String senha){

        boolean usuarioExiste;
        List<Login> retorno = conexao.query("SELECT * FROM Eyes_On_Server.Login where login = ? and senha = ?",
                new BeanPropertyRowMapper<>(Login.class), login, senha);

        if (retorno.isEmpty()){
            usuarioExiste = false;
        } else{
            usuarioExiste = true;
        }

        return usuarioExiste;
    }
}
