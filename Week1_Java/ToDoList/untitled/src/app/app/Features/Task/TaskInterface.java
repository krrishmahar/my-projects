package app.Features.Task;

import java.time.LocalDate;

public interface TaskInterface {



        int getId();
        String getDescription();
        boolean status();
        String getTaskType();
        LocalDate dueDate();
//        String taskType();

    void markAsComplete();
    void setDueDate(LocalDate dueDate);
    void setTaskType(String taskType);
    void setDescription(String description);

        @Override
        String toString();
}
