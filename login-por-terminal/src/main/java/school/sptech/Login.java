package school.sptech;

import java.util.List;

public class Login extends Usuarios{
    private String login;
    private String senha;

    public void setLogin(String login){
        this.login = login;
    }
    public String getLogin(){
        return this.login;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getSenha(){
        return this.senha;
    }

    public boolean checkLogin(){

        List<List<String>> usersList = getList();

        boolean isInList = false;

        for(List<String> subList: usersList){

            if(subList.get(0).equals(this.login)
                    && subList.get(1).equals(this.senha)){
                isInList = true;
            }

        }

        if(isInList){
            return true;
        }else{
            return false;
        }

    }
}
