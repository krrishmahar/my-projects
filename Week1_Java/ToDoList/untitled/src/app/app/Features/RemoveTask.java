package app.Features;

import app.Features.Task.TaskManager;
import app.Task;
import app.ToDoList;


import java.util.Scanner;

public class RemoveTask extends TaskManager {
    /**
     * This method purpose is to act as a user guide
     * on how removing a task is done and how it should be used for the user
     */
    @Override
    public void showActionInfo() {
        System.out.println("");
        System.out.println("To remove a task, enter ID and press ENTER");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    @Override
    public String readInput() {
        while (true){
            System.out.println("");
            System.out.println("Enter ID: ");
            Scanner in = new Scanner(System.in);

            try {
                String userInput = in.nextLine();
                int userInputAsNum = Integer.parseInt(userInput);
                if (userInputAsNum != 0){
                    Task task = ToDoList.tasks.get(userInput);
                    if (task != null){
                        return userInput;
                    }else {
                        System.out.println("ID doesn't exist, try another ID: ");
                    }
                } else {
                    return userInput;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid ID or 0 to RETURN");
            }

        }
    }

    @Override
    public void execute(String command) {
        ToDoList.tasks.remove(command);
        System.out.println("ID: " + command + ", was successfully removed...");
    }
}
