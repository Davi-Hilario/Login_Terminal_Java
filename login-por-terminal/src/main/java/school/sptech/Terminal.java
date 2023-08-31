package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Terminal extends Colors {
    private String error = "\033[1;31m";
    private String sucess = "\033[1;32m";
    private String warning = "\033[1;33m";
    private String primary = "\033[1;34m";
    private String secundary = "\033[1;37m";
    private String aqua = "\033[1;36m";

    private void clear(){
        System.out.println("\n\n\n");
    }
    private void drawLine(){
        System.out.println(colorize(this.aqua, "========================"));
    }

    private void drawHeader(){
        drawLine();
        System.out.println(colorize(this.primary, "\tLOGIN NO SISTEMA"));
        drawLine();
    }

    private void drawForm(){

        Scanner teclado = new Scanner(System.in);

        System.out.print(colorize(this.primary, "Login: "));
        String login = teclado.nextLine();

        System.out.print(colorize(this.primary, "Senha: "));
        String senha = teclado.nextLine();

        drawLine();

        logIn(login, senha);

    }

    private void logIn(String login, String senha){
        Login usuario = new Login();
        Pessoa userData = usuario.checkLogin(login, senha);

        if(userData != null){
            this.acessGranted(userData);
        }else{
            this.acessDenied();
        }
    }

    public void init(){
        this.drawHeader();
        this.drawForm();
    }

    private void acessDenied(){
        System.out.println(colorize(this.error, "Acesso Negado!"));
        this.clear();
        this.init();
    }

    private void acessGranted(Pessoa data){

        System.out.println(colorize(this.sucess, "Acesso Autorizado!"));
        this.clear();

        if(data.isAdmin()){
            callAdminOptions();
        }else{
            callFuncOptions();
        }
    }

}
