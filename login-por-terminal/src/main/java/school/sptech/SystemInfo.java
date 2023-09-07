package school.sptech;
import java.lang.management.ManagementFactory;

public class SystemInfo extends Colors{

    private final Runtime rt;

    public SystemInfo() {
        this.rt = Runtime.getRuntime();
    }

    // OS Information -------------------------

    private String getOSName(){
        return setTextAqua(System.getProperty("os.name"));
    }

    private String getOSVersion(){
        return setTextAqua(System.getProperty("os.version"));
    }

    private String getOSArch(){
        return setTextAqua(System.getProperty("os.arch"));
    }

    // Memory Information -------------------------

    private String getFreeMemory(){
        return setTextAqua(rt.freeMemory() / 1048576 + "MB");
    }

    private String getTotalMemory(){
        return setTextAqua(rt.totalMemory() / 1048576 + "MB");
    }

    private String getMaxMemory(){
        return setTextAqua(rt.maxMemory() / 1048576 + "MB");
    }

    // Cores Information -------------------------

    private String getAvaibleProcessors(){
        return setTextAqua(String.valueOf(rt.availableProcessors()));
    }

    // Physical Memory Information -------------------------

    private String getPhysicalMemory(){
        return setTextAqua(Math.floor((((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalMemorySize()) / Math.pow(10,9)) + "GB");
    }

    @Override
    public String toString() {
        return  setTextSucess("\n Informações do Sistema Operacional") + setTextPrimary("") +
                "\n     Sistema Operacional: " + getOSName() + setTextPrimary("") +
                "\n     Versão do SO: " + getOSVersion() + setTextPrimary("") +
                "\n     Arquitetura do SO: " + getOSArch() + setTextPrimary("") +
                setTextSucess("\n\n Informações da Memória: ") + setTextPrimary("") +
                "\n     Memória Total: " + getTotalMemory() + setTextPrimary("") +
                "\n     Memória Disponível: " + getFreeMemory() + setTextPrimary("") +
                "\n     Memória Máxima: " + getMaxMemory() + setTextPrimary("") +
                "\n     Memória Física: " + getPhysicalMemory() + setTextPrimary("") +
                setTextSucess("\n\n Informações do Processador: ") + setTextPrimary("") +
                "\n     Núcleos do Processador: " + getAvaibleProcessors();
    }
}
