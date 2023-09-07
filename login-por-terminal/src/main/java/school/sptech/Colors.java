package school.sptech;

public class Colors {

    public String setTextPrimary(String message){
        String primary = "\033[1;34m";
        return primary + message;
    }

    public String setTextAqua(String message){
        String aqua = "\033[1;36m";
        return aqua + message;
    }

    public String setTextSucess(String message){
        String sucess = "\033[1;32m";
        return sucess + message;
    }

    public String setTextWarning(String message){
        String warning = "\033[1;33m";
        return warning + message;
    }

    public String setTextError(String message){
        String error = "\033[1;31m";
        return error + message;
    }

}
