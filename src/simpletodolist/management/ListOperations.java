package simpletodolist.management;

import java.util.Scanner;
import java.util.List;

public abstract class ListOperations {
    private String name;

    public ListOperations(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    public abstract void execute(Scanner reader, List<String> list);
    
}
