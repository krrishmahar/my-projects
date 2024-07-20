package app.Features;

import app.Features.Task.TaskManager;
import app.Sorting.SortByDATE;
import app.Task;
import app.ToDoList;

import java.util.ArrayList;
import java.util.Arrays;

public class Display extends TaskManager {
    @Override
    public void showActionInfo() {
        System.out.println();
        System.out.println("Enter the task ID to display: ");
    }
    @Override
    public String readInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }
    @Override
    public void execute(String index) {

        Task task = ToDoList.tasks.get(index);
        if (task != null){
            System.out.println("ID: " + task.getId() + ", Description: " + task.getDescription() + ", Due Date: "
                    + SortByDATE.convertDateToString(task.getDueDate(), "dd-MM-yyyy") + ", Status: "
                    + (task.getStatus() ? "Completed" : "Incomplete") + " Task type: " + task.getTaskType());
            System.out.println("Sub-task: ");
            // Split the subtasks string by '\n' and print each subtask
            String[] subTasksArray = (task.getSub_tasks() != null? task.getSub_tasks(): new String[]{"No Sub Task assigned"});
            if (task.getSub_tasks() == null ){
                System.out.println("No Sub Task assigned");
            }else {
                try {
                    ArrayList<String> list = new ArrayList<>(Arrays.asList(subTasksArray));
                    System.out.println(list);
                    System.out.println();
                    System.out.println();
                    for (String subTask : subTasksArray) {
                        System.out.println("- " + subTask);
                    }
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }else {
            System.out.println("Task ID " + index + " not found.");
        }
    }
}