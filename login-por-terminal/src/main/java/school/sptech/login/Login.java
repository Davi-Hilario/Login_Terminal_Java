package school.sptech.login;

public class Login{

    private int id_login;
    private int fk_usuario;
    private String login;
    private String senha;

    public Login() {

    }

    public Login(int id_login, int fk_usuario, String login, String senha) {
        this.id_login = id_login;
        this.fk_usuario = fk_usuario;
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
