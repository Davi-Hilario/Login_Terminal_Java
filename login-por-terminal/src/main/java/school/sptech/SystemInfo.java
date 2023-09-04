package school.sptech;
import java.lang.management.ManagementFactory;
public class SystemInfo extends Colors{
    private final Runtime rt;

    public SystemInfo() {
        this.rt = Runtime.getRuntime();
    }

    // OS Information -------------------------

    private String getOSName(){
        return System.getProperty("os.name");
    }

    private String getOSVersion(){
        return System.getProperty("os.version");
    }

    private String getOSArch(){
        return System.getProperty("os.arch");
    }

    // Memory Information -------------------------

    private String getFreeMemory(){
        return rt.freeMemory() / 1048576 + "MB";
    }

    private String getTotalMemory(){
        return rt.totalMemory() / 1048576 + "MB";
    }

    private String getMaxMemory(){
        return rt.maxMemory() / 1048576 + "MB";
    }

    // Cores Information -------------------------

    private String getAvaibleProcessors(){
        return String.valueOf(rt.availableProcessors());
    }

    // Physical Memory Information -------------------------

    private String getPhysicalMemory(){
        return String.valueOf(((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalMemorySize());
    }

    @Override
    public String toString() {
        return  colorize(super.primary,"\n  Informações do Sistema Operacional", super.sucess) +
                "\n     Sistema Operacional: " + colorize(super.aqua,getOSName(), super.sucess) +
                "\n     Versão do SO: " + colorize(super.aqua,getOSVersion(), super.sucess) +
                "\n     Arquitetura do SO: " + colorize(super.aqua,getOSArch(), super.primary) +
                colorize(super.primary,"\n\n Informações da Memória: ",super.sucess) +
                "\n     Memória Total: " + colorize(super.aqua,getTotalMemory(), super.sucess) +
                "\n     Memória Disponível: " + colorize(super.aqua,getFreeMemory(), super.sucess) +
                "\n     Memória Máxima: " + colorize(super.aqua,getMaxMemory(), super.sucess) +
                "\n     Memória Física: " + colorize(super.aqua,getPhysicalMemory(), super.primary) +
                colorize(super.primary,"\n\n Informações do Processador: ", super.sucess) +
                "\n     Núcleos do Processador: " + colorize(super.aqua,getAvaibleProcessors(), super.sucess);
    }
}
