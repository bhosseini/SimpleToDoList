package simpletodolist.ui;

import java.util.Scanner;
import simpletodolist.management.ListOperations;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import simpletodolist.management.FileManagement;

public class UserInterface2 {
    private Scanner r;
    private List<ListOperations> operations;
    private List<String> toDoList;
    private File file;
    private FileManagement manager;

    public UserInterface2(Scanner reader, File file) 
    throws FileNotFoundException {
        this.operations = new ArrayList<ListOperations>();
        this.r = reader;
        
        this.file = file;
        this.manager = new FileManagement(this.file);
        this.toDoList = this.manager.readToDoList();
        
    }

    public void addConfig(ListOperations operation) {
        this.operations.add(operation);
    }

    private void printMenu() {
        System.out.print("Commands:   |   ");
        for (int i = 0; i < this.operations.size(); i++) {

            String name = operations.get(i).getName();
            System.out.print("[" + (i + 1) + "] " + name + "   |   ");

            if (i + 1 == this.operations.size()) {
                System.out.println("[" + (i + 2) + "] Quit   |");
            }
        }
        System.out.println();
    }

    private void printToDoList() {
        if (this.toDoList.isEmpty()) {
            System.out.println("Nothing to do!\n");
        } else {
            for (int i = 0; i < this.toDoList.size(); i++) {
                System.out.println("To do:");
                System.out.println((i + 1) + ") " + this.toDoList.get(i));
                System.out.println();
            }
        }
    }

    private void executeOperation(String command) {
        int index = Integer.parseInt(command);

        ListOperations selected = this.operations.get(index - 1);
        selected.execute(r, toDoList);
    }

    public void run() throws IOException {
        Scanner r = new Scanner(System.in);

        while (true) {
            this.printToDoList();
            this.printMenu();
            
            System.out.print(">> ");
            String command = r.nextLine();

            if (command.equals("3")) {
                this.manager.writeToDoList(this.toDoList);
                break;
            }

            executeOperation(command);
            System.out.println("");
        }
    }

}
