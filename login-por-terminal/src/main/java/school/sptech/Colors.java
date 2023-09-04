package school.sptech;

public class Colors {

    protected String error = "\033[1;31m";
    protected String sucess = "\033[1;32m";
    protected String warning = "\033[1;33m";
    protected String primary = "\033[1;34m";
    protected String secundary = "\033[1;37m";
    protected String aqua = "\033[1;36m";
    protected String colorize(String firstColor, String string){
        return firstColor + string;
    }

    protected String colorize(String firstColor, String string, String secondColor){
        return firstColor + string + secondColor;
    }
}
