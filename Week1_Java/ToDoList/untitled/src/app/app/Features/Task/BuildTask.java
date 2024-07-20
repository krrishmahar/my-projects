package app.Features.Task;
import app.Sorting.SortByDATE;
import app.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class BuildTask extends Task implements TaskInterface {

    private static int counter = 0;
    private int id;
    private String description;
    private boolean status;
    private LocalDate dueDate;
    private String taskType;
    private String[] sub_task;

    public BuildTask(String description, String[] sub_task) {
        super();
        this.id = ++counter;
        this.description = description;
        this.sub_task = sub_task;
        this.status = false;
    }

    public BuildTask(int id, String description, LocalDate dueDate, String taskType, String[] sub_task) {
        super(id,description,dueDate,taskType,sub_task);
        this.id = ++counter;
        this.description = description;
        this.status = false;
        this.dueDate = dueDate;
        this.taskType = "extra";
        this.sub_task = sub_task;


//        Task task = new Task(description,dueDate,taskType,sub_task);
//        task.setId(id);
//        task.incrementStarCount();
    }



    @Override
    public String toString() {
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//        String formattedDate = (dueDate != null) ? df.format(dueDate) : "No due date";
//        String formattedSubTasks = (sub_task != null) ? Arrays.toString(sub_task) : "No sub-tasks";

//        return id + ", " + description + ", " + (status ? "completed" : "incomplete") + ", " + formattedDate + ", " + formattedSubTasks;
//          return id +"," + description +","+ (status ? "completed" : "incomplete") + "," + SortByDATE.convertDateToString(dueDate,"dd-MM-yyyy")+ "," + Arrays.toString(sub_task) ;
          return id  + description+ status + SortByDATE.convertDateToString(dueDate,"dd-MM-yyyy")+ Arrays.toString(sub_task);

    }


//    @Override
//    public String toString() {
//        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//
////        return id +"," + description +","+ (status ? "completed" : "incomplete") + "," + df.format(dueDate)+ "," + Arrays.toString(sub_task) ;
//        return id + description + (status ? "completed" : "incomplete") + df.format(dueDate) + Arrays.toString(sub_task);
//
////        else use StringBuilder for complex stuff since it's more efficient.
////        {
////            StringBuilder sb = new StringBuilder();
////            sb.append(id).append(", ").append(description).append(status ? " [complete]" : "incomplete..").append("\t\t\t").append(df.format(dueDate)).append("\nSub Tasks:");
////            for (String step : sub_task) {
////                sb.append("\n- ").append(step);
////            }
////            return sb.toString();
////        }
//
//    }

    @Override
    public LocalDate dueDate() {
        return dueDate;
    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    //allowing editing in task desc
    @Override
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public void setTaskType(String taskType) {
        this.taskType = "extra";
    }
    @Override
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    //special setter for completed task
    @Override
    public void markAsComplete() {
        this.status = true;
    }

    @Override
    public boolean status() {
        return true;
    }

}