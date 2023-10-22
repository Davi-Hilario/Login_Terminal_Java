package school.sptech;

import school.sptech.login.Login;
import school.sptech.model.LoginModel;
import java.util.Scanner;
import com.github.britooo.looca.api.core.Looca;



public class Terminal extends Colors{

    private LoginModel model = new LoginModel();
    private void clear(){
        System.out.println("\n\n\n");
    }
    private void drawLine(){
        System.out.println(setTextAqua("========================"));
    }

    private void drawHeader(){
        drawLine();
        System.out.println(setTextPrimary("\tLOGIN NO SISTEMA"));
        drawLine();
    }

    private void drawForm(){

        Scanner teclado = new Scanner(System.in);

        System.out.print(setTextPrimary("Login: "));
        String login = teclado.nextLine();

        System.out.print(setTextPrimary("Senha: "));
        String senha = teclado.nextLine();

        drawLine();

        if (model.entrar(login, senha)){
            acessGranted();
        } else {
            acessDenied();;
        }

    }

    public void init(){
        this.drawHeader();
        this.drawForm();
    }

    private void acessDenied(){
        System.out.println(setTextError("Acesso Negado!"));
        this.clear();
        this.init();
    }

    private void acessGranted(){

        System.out.println(setTextSucess("Acesso Autorizado!"));
        this.clear();

        callAdminOptions();
    }

    private void callAdminOptions(){

        int option;
        Scanner teclado = new Scanner(System.in);

        System.out.println(setTextPrimary("""
                O que você quer fazer?
                [1] - Sair
                [2] - Visualizar Informações
                """));
        do {
            System.out.print(setTextAqua("Sua opção >>> "));
            option = teclado.nextInt();
        }while(option < 1 || option > 2);

        switch (option) {
            case 1 -> System.out.println("Saindo da Aplicação!");
            case 2 -> visualizarInformacoesSistema();
        }
    }

    public void visualizarInformacoesSistema(){
        Looca lucas = new Looca();
        System.out.println(lucas.getSistema());
        System.out.println(lucas.getMemoria());
        System.out.println(lucas.getRede());
        System.out.println(lucas.getProcessador());
        System.out.println(lucas.getGrupoDeDiscos());

        callAdminOptions();
    }

}
