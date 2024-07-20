package app;

import app.DATABASE.ReadFromFile;
import app.DATABASE.SaveTaskToFile;
import app.Features.Task.TaskManager;
import app.Features.*;
import app.Sorting.SortByDATE;
import app.Sorting.SortByID;

import java.util.*;


/**
 * This class is part of the TodoList Application.
 * <p>
 * ToDolIST is the main entity where all classes and
 * features are connected and implemented.
 */
public class ToDoList {

    public static Map<String, Task> tasks = new LinkedHashMap<>();
    public static boolean applicationRunning = true;

    public void start() {
        showApplicationTitle();
        while (ToDoList.applicationRunning) {
            showAvailableActions();
            int actionNum = readAction();
            executeAction(actionNum);
        }
    }


    private void executeAction(int actionNum) {
        TaskManager action;
        switch (actionNum) {
            case TaskManager.ADD_TASK:
                action = new AddTask();
                action.showActionInfo();
                String command = action.readInput();
                if (!command.equals("0")) {
                    action.execute(command);
                    break;
                }

            case TaskManager.EDIT_TASK:
                if (!tasks.isEmpty()) {
                    action = new EditTask();
                    action.showActionInfo();
                    String editCommand = action.readInput();
                    if (!editCommand.equals("0"))
                        action.execute(editCommand);
                } else {
                    System.out.println("Your list is empty, add tasks first (>_<)! ");
                }
                break;

            case TaskManager.REMOVE_TASK:
                if (!tasks.isEmpty()) {
                    action = new RemoveTask();
                    action.showActionInfo();
                    String id = action.readInput();
                    if (!id.equals("0"))
                        action.execute(id);
                } else {
                    System.out.println("Your list is empty, add tasks first (>_<)! ");
                }
                break;

            case TaskManager.MARK_AS_COMPLETE:
                if (!tasks.isEmpty()) {
                    action = new MarkAsComplete();
                    action.showActionInfo();
                    String id = action.readInput();
                    if (!id.equals("0"))
                        action.execute(id);
                } else {
                    System.out.println("Your List is empty, add tasks first (>_<)! ");
                }
                break;

            case TaskManager.DISPLAY:
                if (!tasks.isEmpty()) {
                    action = new Display();
                    action.showActionInfo();
                    Scanner input = new Scanner(System.in);
                    action.execute(input.nextLine());
                } else {
                    System.out.println("Your list is empty, add tasks first (>_<)! ");
                }
                break;

            case TaskManager.DISPLAY_ALL:
                if (!tasks.isEmpty()) {
                    action = new DisplayAll();
                    action.showActionInfo();
                    action.execute(null);
                } else {
                    System.out.println("Your list is empty, add tasks first (>_<)! ");
                }
                break;

            case TaskManager.SORT_BY_DATE:
                action = new SortByDATE();
                action.execute(null);
                break;

            case TaskManager.SORT_BY_ID:
                action = new SortByID();
                action.execute(null);
                break;

            case TaskManager.SAVE_TO_FILE:
                if (!tasks.isEmpty()) {
                    action = new SaveTaskToFile();
                    action.showActionInfo();
                    String path = action.readInput();
                    if (!path.equals("0"))
                        action.execute(path);
                } else {
                    System.out.println("There are no tasks to be saved!");
                }
                break;

            case TaskManager.READ_FILE:
                action = new ReadFromFile();
                action.showActionInfo();
                String path = action.readInput();
                if (!path.equals("0"))
                    action.execute(path);
                break;

            case TaskManager.EXIT:
                applicationRunning = false;
                break;

        }
    }

    private void showAvailableActions() {
        System.out.println("");
        System.out.println("1. Add a task");
        System.out.println("2. Edit task");
        System.out.println("3. Remove task ");
        System.out.println("4. Mark task as done");
        System.out.println("5. Display tasks");
        System.out.println("6. Display all tasks");
        System.out.println("7. Sort tasks by date");
        System.out.println("8. sort tasks by id");
        System.out.println("9. save tasks to file");
        System.out.println("10. read from file");
        System.out.println("11. Exit");
        System.out.println("");
    }

    private void showApplicationTitle() {
        System.out.println("To DO List Application");
        System.out.println("-----------------------");
    }

    public int readAction() {
        List<Integer> availableActions = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        while (true) {
            try {
                System.out.print("Enter action: ");
                Scanner scan = new Scanner(System.in);

                String action = scan.nextLine();
                if (availableActions.contains(Integer.parseInt(action))) {
                    return Integer.parseInt(action);
                } else if (action.equals("\n")) {
                    continue;
                } else {
                    System.out.println("Please enter a valid action from the list: ");
                }
            } catch (Exception e) {
                System.out.println("Action must be a number...");

            }
        }
    }
}