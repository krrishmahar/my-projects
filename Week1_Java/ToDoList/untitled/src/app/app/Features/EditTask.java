package app.Features;

import app.Features.Task.TaskManager;
import app.Sorting.SortByDATE;
import app.ToDoList;


import javax.swing.*;
import java.util.Scanner;

public class EditTask extends TaskManager {

    /**
     * This method purpose is to act as a user guide
     * on how editing a task should be used for the user
     */
    @Override
    public void showActionInfo() {
        System.out.println("");
        System.out.println("to update a task, follow the instructions and press ENTER: ");
        System.out.println("ID, Description, Due_date('MM-dd'), Task_type, Sub_task, set Status");
        System.out.println("ID here represent the ID of the task where an update will occur");
        System.out.println("<>ID cannot be changed</>");
        System.out.println("insert a (-) when an update is not needed to that specific parameter");
        System.out.println("");
        System.out.println("Enter 0 to RETURN");
    }

    /**
     * In this overridden method reside the implementation of
     * how this program read user's input by using a scanner inside a while loop
     * and then checking multiple points to ensure a successful performance
     * <p>
     * it will check against components completion
     * ID existence
     * validity of date
     * and if the user correctly followed instructions
     *
     * @return userInput user's inserted information
     */
    @Override
    public String readInput() {
        while (true) {
            System.out.println("");
            System.out.println("Enter the Information.");
            Scanner in = new Scanner(System.in);
            String userInput = in.nextLine();

            if (!userInput.equals(0)) {
                String[] parts = userInput.split(",");
                if (parts.length <= 6) {
                    boolean DateValidationRequired = true;
                    if (parts[2].equals("-")) {
                        DateValidationRequired = false;
                    }

                    boolean isDateValid = true;
                    if (DateValidationRequired) {
                        isDateValid = SortByDATE.isValid("dd-MM-yyyy", parts[2]);
                    }

                    if (isDateValid) {
                        if (ToDoList.tasks.get(parts[0]) != null) {
                            return userInput;
                        } else {
                            System.out.println("ID doesn't exist, try again: ");
                        }
                    } else {
                        System.out.println("Please follow instructions or enter 0 to RETURN");
                    }
                } else {
                    return userInput;
                }
            }
        }
    }



    @Override
    public void execute(String command) {
    String[] parts = command.split(",");

    boolean isTaskEdited = false;
        if (!parts[1].equals("-")) {
            ToDoList.tasks.get(parts[0]).setDescription(parts[1]);
            isTaskEdited = true;
        }

        if (!parts[2].equals("-")) {
            ToDoList.tasks.get(parts[0]).setDueDate(SortByDATE.parseDate("dd-MM-yyyy", parts[2]));
            isTaskEdited = true;
        }

        if (!parts[3].equals("-")) {
            ToDoList.tasks.get(parts[0]).setTaskType(parts[3]);
            isTaskEdited = true;
        }
        if (!parts[4].equals("-")){
            ToDoList.tasks.get(parts[0]).setSub_tasks(new String[]{parts[4]});
            isTaskEdited = true;
        }

        //More work required!!
        if (parts.length >=5) {
            if (!parts[5].equals("-")) {
                ToDoList.tasks.get(parts[0]).setStatus((parts[5].equalsIgnoreCase("complete")));
                isTaskEdited = true;
            }
        }
        if (isTaskEdited) {
            System.out.println("Tasks successfully updated!!");
        } else {
            System.out.println("No change was applied...");
        }

    }
}
