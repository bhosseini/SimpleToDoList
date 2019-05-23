package simpletodolist.management;

import java.util.Scanner;
import java.util.List;

public class Add extends ListOperations {

    public Add() {
        super("Add");
    }
    
    @Override
    public void execute(Scanner r, List<String> list) {
        System.out.print("Add an item: ");
        String toDo = r.nextLine();
        list.add(toDo);
    }
}
