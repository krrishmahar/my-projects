package app.Features;

import app.Features.Task.TaskManager;
import app.Task;
import app.ToDoList;

import java.util.Scanner;

public class MarkAsComplete extends TaskManager {

    @Override
    public void showActionInfo() {
        System.out.println("");
        System.out.println("To mark a task as completed, enter ID and press ENTER: ");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {
    while (true){
        System.out.println("");
        System.out.println("Enter the task id: ");
        Scanner in = new Scanner(System.in);

        try {
            String userInput = in.nextLine();
            int userInputAsNum = Integer.parseInt(userInput);
            if (userInputAsNum != 0){
                Task task = ToDoList.tasks.get(userInput);
                if (task != null) {
                    return userInput;
                } else {
                    System.out.println("There is no task with this ID, try again: ");
                }
            } else {
                return userInput;
            }
        }catch (Exception e){
            System.out.println("Enter a valid ID or 0 to RETURN");
        }
    }
    }

    @Override
    public void execute(String command) {
    ToDoList.tasks.get(command).setStatus(Boolean.parseBoolean("completed"));
        Task task = new Task();
        task.incrementStarCount();
        System.out.println("Status is set as Completed for the task with ID: " + command);
        System.out.println(".......................");
        System.out.println("Great! You have earned a ⭐, my friend");
        task.incrementStarCount();
    }
}