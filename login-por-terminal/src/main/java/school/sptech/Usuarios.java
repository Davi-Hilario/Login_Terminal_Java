package school.sptech;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuarios {
    private List<List<String>> listAllUsers = new ArrayList<>();
    private List<String> listSingleUser = new ArrayList<>();

    private void clearArray(){

        List<String> copy = new ArrayList<>(this.listSingleUser);

        this.listAllUsers.add(copy);
        this.listSingleUser.clear();

    }
    public void addUsers(){

        this.listSingleUser.add("Joao123");
        this.listSingleUser.add("jojo123");
        clearArray();

        this.listSingleUser.add("davi123");
        this.listSingleUser.add("dada123");
        clearArray();

        this.listSingleUser.add("Maria123");
        this.listSingleUser.add("malu123");
        clearArray();

        this.listSingleUser.add("Sofia123");
        this.listSingleUser.add("soso123");
        clearArray();

        this.listSingleUser.add("Marcos123");
        this.listSingleUser.add("fenix123");
        clearArray();
    }

    public List<List<String>> getList(){
        this.addUsers();
        return this.listAllUsers;
    }
}
