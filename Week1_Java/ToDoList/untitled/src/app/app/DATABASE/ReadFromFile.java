package app.DATABASE;

import app.Features.Task.BuildTask;
import app.Features.Task.QuickTask;
import app.Features.Task.TaskManager;
import app.Sorting.SortByDATE;
import app.Task;
import app.ToDoList;

import java.io.FileNotFoundException;
import java.util.*;

public class ReadFromFile extends TaskManager {
    @Override
    public void showActionInfo() {
        System.out.println();
        System.out.println("Please enter path to read:");
        System.out.println();
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {
        while (true) {
            System.out.println();
//            System.out.print("path:");

//            Scanner scan = new Scanner(System.in);
//            String userInput = scan.nextLine();

            return "path: ";
        }
    }

    @Override
    public void execute(String command) {

        try {
            Scanner in = new Scanner(System.in);
//            System.out.println("Press 0 to exit");
            String file = in.nextLine();
            while (!file.equals("0")) {
//                if (in.hasNext("0")) break;
                String[] parts = file.split(",");
                Task task;
                if (parts.length <= 4) {
                    task = new QuickTask(Integer.parseInt(parts[0]), parts[1], SortByDATE.parseDate("dd-MM-yyyy", parts[2]), parts[3]);
                } else {
                    String[] subTasks = parts.length >= 4 ? parts[4].split("|") : new String[0];
                    task = new BuildTask(Integer.parseInt(parts[0]), parts[1], SortByDATE.parseDate("dd-MM-yyyy", parts[2]), parts[3], subTasks);
                }

                if (ToDoList.tasks.get(parts[0]) != null) {
                    ToDoList.tasks.replace(parts[0], task);
                } else {
                    ToDoList.tasks.put(parts[0], task);
                }
            }
//            in.close();
            System.out.println("Tasks are being read!");
        }catch (Exception e){
            System.out.println("Path or file do not exist...");
        }
    }
}
