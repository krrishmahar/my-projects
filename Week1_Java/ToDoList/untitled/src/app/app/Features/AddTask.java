package app.Features;

import app.Features.Task.BuildTask;
import app.Features.Task.QuickTask;
import app.Features.Task.TaskManager;
import app.Sorting.SortByDATE;
import app.Task;
import app.ToDoList;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class AddTask extends TaskManager {
    @Override
    public void showActionInfo() {
        System.out.println();
        System.out.println("To add a new task, please follow the instructions(typo) below and press ENTER:");
        System.out.println("Add Id, Description, Due_date('dd-MM-yyyy'), Task_type(quick / extra) and Sub_Task(extra).");
        System.out.println();
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {

        while (true){
            System.out.println();
            System.out.println("Enter Information:\n");
            System.out.println("Add Id, Description, Due_date('dd-MM-yyyy'), Task_type(quick / extra) and Sub_Task(seperate by |).");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals("0")){
                String[] parts = userInput.split(",");
                if (parts.length >= 4){
                    //adding CHECKS:
                    if (SortByDATE.isValid("dd-MM-yyyy", parts[2])){
                        if (ToDoList.tasks.get(parts[0]) == null){
                            return userInput;
                        }else {
                            System.out.println("A task with this ID already exists, try again :( ");
                        }
                    }else {
                        System.out.println("The date entered is invalid, try again :( ");
                    }
                }else {
                    System.out.println("Please follow instructions, try again :( ");
                }
            }else {
                return userInput;
            }
        }
    }

    @Override
    public void execute(String command) {
        String[] parts = command.split(",");
        String id = parts[0];
        String description = parts[1];
        String dueDate = parts[2];
        String taskType = parts[3];
        String[] subTasks = parts.length > 4 ? parts[4].split("|") : new String[0];

        Task tasks;
        if (taskType.equalsIgnoreCase("quick")) {
            tasks = new QuickTask(Integer.parseInt(id), description, SortByDATE.parseDate("dd-MM-yyyy", dueDate), taskType);
            tasks.setDescription(description);
            tasks.setStatus(false);
            tasks.setId(Integer.parseInt(id));

        } else if (taskType.equalsIgnoreCase("extra")) {
            tasks = new BuildTask(Integer.parseInt(id), description,SortByDATE.parseDate("dd-MM-yyyy", dueDate), taskType, subTasks);

        } else {
            System.out.println("Invalid task type. Task not added.");
            return;
        }

        ToDoList.tasks.put(id, tasks);
        System.out.println("Task successfully added!");
    }

}