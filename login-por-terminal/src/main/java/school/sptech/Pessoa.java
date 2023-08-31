package school.sptech;

public class Pessoa {
    private final String login;
    private final String senha;
    private final boolean admin;

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
}
