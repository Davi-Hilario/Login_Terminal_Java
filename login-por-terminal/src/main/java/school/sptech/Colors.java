package school.sptech;

public class Colors {
    protected String colorize(String firstColor, String string){
        return firstColor + string;
    }

    protected String colorize(String firstColor, String string, String secondColor){
        return firstColor + string + secondColor;
    }
}
