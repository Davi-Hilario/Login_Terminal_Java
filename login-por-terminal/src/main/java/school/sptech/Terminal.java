package school.sptech;

import java.util.Scanner;


public class Terminal extends Colors{

    private final Login login = new Login();
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

        logIn(login, senha);

    }

    private void logIn(String login, String senha){
        Pessoa userData = this.login.checkLogin(login, senha);

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
        System.out.println(setTextError("Acesso Negado!"));
        this.clear();
        this.init();
    }

    private void acessGranted(Pessoa data){

        System.out.println(setTextSucess("Acesso Autorizado!"));
        this.clear();

        if(data.isAdmin()){
            callAdminOptions();
        }else{
            callFuncOptions();
        }
    }

    private void callAdminOptions(){

        int option;
        Scanner teclado = new Scanner(System.in);

        System.out.println(setTextPrimary("""
                O que você quer fazer?
                [1] - Sair
                [2] - Configurar Usuários
                """));
        do {
            System.out.print(setTextAqua("Sua opção >>> "));
            option = teclado.nextInt();
        }while(option < 1 || option > 2);

        switch (option) {
            case 1 -> System.out.println("Saindo da Aplicação!");
            case 2 -> callAdminMenu();
        }

    }

    private void callAdminMenu(){

        int option;

        Scanner teclado = new Scanner(System.in);

        System.out.println(setTextPrimary("""
                \n
                Configurações de Usuários
                Escolha uma opção:
                [1] - Voltar ao Menu
                [2] - Cadastrar novo Usuario
                [3] - Ver lista de Usuários
                [4] - Deslogar
                """));
        do {
            System.out.print(setTextAqua("Sua opção >>> "));
            option = teclado.nextInt();
        }while(option < 1 || option > 4);

        switch (option){
            case 1 -> callAdminOptions();
            case 2 -> insertUserMenu();
            case 3 -> consultUserMenu();
            case 4 -> init();

        }
    }

    private void insertUserMenu(){

        String login;
        String senha;
        boolean cargo;
        String resp;

        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("Novo Login >>> ");
            login = teclado.next();

            System.out.print("Nova Senha >>> ");
            senha = teclado.next();

            System.out.print("É Administrador? >>> ");
            cargo = teclado.nextBoolean();

            this.login.listAllUsers.add(new Pessoa(login, senha, cargo));

            System.out.println(setTextSucess("Usuário Cadastrado!"));

            System.out.print(setTextAqua("\nGostaria de Cadastrar Outro Usuário? [S ou N] >>> "));

            resp = teclado.next();

        }while(resp.equalsIgnoreCase("S"));

        callAdminMenu();
    }

    private void consultUserMenu(){

        int option;
        int index;

        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < this.login.listAllUsers.size(); i++){
            System.out.println(setTextWarning(String.format(
                    """
                    {ID: %d; Nome: %s; Senha: %s; Cargo: %s;}""",
                    i+1,
                    this.login.listAllUsers.get(i).getLogin(),
                    this.login.listAllUsers.get(i).getSenha(),
                    this.login.listAllUsers.get(i).isAdmin()?"Admin":"Analista")));
        }

        System.out.println(setTextPrimary("""
                \n
                O Que Quer Fazer Agora?
                Escolha uma opção:
                [1] - Voltar
                [2] - Excluir Usuário
                [3] - Alterar Usuário
                """));
        do {
            System.out.print(setTextAqua("Sua opção >>> "));
            option = teclado.nextInt();
        }while(option < 1 || option > 3);

        switch (option){
            case 1 -> callAdminMenu();
            case 2 ->{

                do{
                    System.out.print("Digite o ID para Excluir >>> ");
                    index = teclado.nextInt();
                }while(index > this.login.listAllUsers.size() || index < 0);

                deleteUserMenu(index);
            }
            case 3->{
                do{
                    System.out.print("Digite o ID para Alterar >>> ");
                    index = teclado.nextInt();
                    alterUserMenu(index);
                }while(index > this.login.listAllUsers.size() || index < 0);
            }

        }
    }

    private void deleteUserMenu(int index){

        Pessoa user = this.login.listAllUsers.get(index - 1);

        System.out.println(setTextSucess(
                String.format(
                        ("Usuário %s Removido com Sucesso!"), user.getLogin())));

        this.login.listAllUsers.remove(index - 1);

        consultUserMenu();
    }

    private void alterUserMenu(int index){

        String newLogin;
        String newPassword;

        Pessoa user = this.login.listAllUsers.get(index - 1);
        Scanner teclado = new Scanner(System.in);

        System.out.print("Novo Login >>> ");
        newLogin = teclado.next();

        System.out.print("Nova Senha >>> ");
        newPassword = teclado.next();

        System.out.println(setTextSucess("Usuário atualizado com sucesso!"));

        user.setLogin(newLogin);
        user.setSenha(newPassword);

        consultUserMenu();

    }
    private void callFuncOptions(){

        int option;
        Scanner teclado = new Scanner(System.in);

        System.out.println(setTextPrimary("""
                O que você quer fazer?
                [1] - Sair
                [2] - Verificar Informações do Sistema
                """));
        do {
            System.out.print(setTextAqua("Sua opção >>> "));
            option = teclado.nextInt();
        }while(option < 1 || option > 2);

        switch (option) {
            case 1 -> System.out.println("Saindo da Aplicação!");
            case 2 -> showSystemInfo();
        }
    }

    private void showSystemInfo(){

        int option;

        Scanner teclado = new Scanner(System.in);
        SystemInfo sys = new SystemInfo();

        System.out.println(sys);

        do {
            System.out.print(setTextAqua("Digite [0] para Voltar >>> "));
            option = teclado.nextInt();
        }while(option != 0);

        callFuncOptions();
    }

}
