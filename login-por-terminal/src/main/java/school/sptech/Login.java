package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Login{

    protected List<Pessoa> listAllUsers = new ArrayList<>();

    public Login() {
        this.listAllUsers.add(new Pessoa("adm", "adm", true));
        this.listAllUsers.add(new Pessoa("teste", "teste", false));
        this.listAllUsers.add(new Pessoa("marise", "urubu100", true));
    }

    public Pessoa checkLogin(String login, String senha){
        for(Pessoa item:this.listAllUsers){
            if(item.getLogin().equals(login) && item.getSenha().equals(senha)){
                return item;
            }
        }
        return null;
    }
}
