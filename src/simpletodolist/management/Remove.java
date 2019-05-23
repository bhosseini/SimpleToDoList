package simpletodolist.management;

import java.util.Scanner;
import java.util.List;

public class Remove extends ListOperations {

    public Remove() {
        super("Remove");
    }
    
    @Override
    public void execute(Scanner r, List<String> list) {
        System.out.print("Remove item # ");
        int response = Integer.parseInt(r.nextLine()) - 1;
        list.remove(response);
    }
    
    
}
