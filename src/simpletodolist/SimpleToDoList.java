
package simpletodolist;

import simpletodolist.management.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import simpletodolist.ui.*;

public class SimpleToDoList {

    public static void main(String[] args) throws FileNotFoundException, 
            IOException {
        Scanner reader = new Scanner(System.in);
        
        File file = new File("src/simpletodolist/todo.txt");
        FileManagement manager = new FileManagement(file);
        
        List<String> toDo = manager.readToDoList();
        
        UserInterface2 ui = new UserInterface2(reader, file);
        ui.addConfig(new Add());
        ui.addConfig(new Remove());
        ui.run();
        
        
    }
    
}
