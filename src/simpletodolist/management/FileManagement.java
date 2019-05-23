package simpletodolist.management;

import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FileManagement {
    private File file;

    public FileManagement(File file) {
        this.file = file;
    }
    
    public List<String> readToDoList() throws FileNotFoundException {
        Scanner r = new Scanner(this.file);
        List<String> toDoList = new ArrayList<String>();
        
        while (r.hasNextLine()) {
            String line = r.nextLine();
            toDoList.add(line);
        }
        
        r.close();
        return toDoList;
    }
    
    public void writeToDoList(List<String> toDoList) throws IOException {
        FileWriter w = new FileWriter(this.file);
        for (String line : toDoList) {
            w.write(line + "\n");
        }
        w.close();
    }
    
    public void writeToDoList(String toDo) throws IOException {
        FileWriter w = new FileWriter(this.file);
        w.append(toDo);
        w.close();
    }
    
    
}
