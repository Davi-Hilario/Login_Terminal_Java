package school.sptech;

public class Pessoa {
    private String login;
    private String senha;
    private boolean admin;

    public Pessoa(String login, String senha, boolean admin) {
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }

    public String getLogin() {
        return this.login;
    }

    public String getSenha() {
        return this.senha;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
