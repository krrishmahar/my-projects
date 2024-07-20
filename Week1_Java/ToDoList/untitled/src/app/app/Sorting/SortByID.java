package app.Sorting;

import app.Features.Task.TaskManager;
import app.Task;
import app.ToDoList;

import java.util.*;

public class SortByID extends TaskManager {

    @Override
    public void showActionInfo() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public String readInput() {
        throw new UnsupportedOperationException("The requested operation is not supported.");
    }

    @Override
    public void execute(String command) {
        List<Map.Entry<String, Task>> entries = new ArrayList<>(ToDoList.tasks.entrySet());
        entries.sort(new Comparator<Map.Entry<String, Task>>() {
            @Override
            public int compare(Map.Entry<String, Task> firstTask, Map.Entry<String, Task> secondTask) {
                int firstProject = firstTask.getValue().getId();
                int secondProject = secondTask.getValue().getId();

                return Integer.compare(firstProject, secondProject);
            }
        });

        ToDoList.tasks.clear();
        entries.forEach(entry -> {
            ToDoList.tasks.put(entry.getKey(), entry.getValue());
        });

        if (!entries.isEmpty()) {
            System.out.println("Tasks successfully sorted");
        }else {
            System.out.println("Your list is empty, add tasks first then sort it (>_<)!! ");
        }
    }
}
