
package simpletodolist.ui;

import java.util.Scanner;
import simpletodolist.management.ListOperations;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private Scanner r;
    private List<ListOperations> operations;
    private List<String> list;

    public UserInterface(Scanner reader, List<String> list) {
        this.operations = new ArrayList<ListOperations>();
        this.r = reader;
        this.list = list;
    }
    
    public void addConfig(ListOperations operation) {
        this.operations.add(operation);
    }
    
    private void printMenu() {
        System.out.print("Commands:");
        for (int i = 0; i < this.operations.size(); i++) {
            String name = operations.get(i).getName();
            System.out.println("\t[" + (i + 1) + "]: " + name);
        }
        System.out.println("\n");
    }
    
    private void executeOperation(String command) {
        int index = Integer.parseInt(command);
        
        ListOperations selected = this.operations.get(index - 1);
        selected.execute(r, list);        
    }
    
    public void run() {
        Scanner r = new Scanner(System.in);
        
        this.printMenu();
        while (true) {
            System.out.print(">> ");
            String command = r.nextLine();
            
            if (command.equals("0")) {
                break;
            }
            
            executeOperation(command);
            System.out.println("");
        }
    }
}

