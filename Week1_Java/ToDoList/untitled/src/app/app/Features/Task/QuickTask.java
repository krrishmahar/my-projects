package app.Features.Task;

import app.Sorting.SortByDATE;
import app.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class QuickTask extends Task implements TaskInterface {

    private static int counter = 0;
    private int id;
    private String description;
    private boolean status;
    private LocalDate dueDate;
    private String taskType;

    //Initiating the first quick start
//    public QuickTask(String description) {
//        super();
//        this.id = ++counter;
//        this.description = description;
//        this.status = false;
//    }

    //Initiating the first quick start
    public QuickTask(String description) {
        super(); // Call the Task constructor to initialize id and status
        this.description = description;
        this.taskType = "quick";
    }

    public QuickTask(int id, String description, LocalDate dueDate, String taskType) {
        super(id,description,dueDate,taskType); // Call the Task constructor to initialize id and status
        this.description = description;
        this.dueDate = dueDate;
        this.taskType = "quick";
        this.id = ++counter;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean status() {
        return status;
    }

    @Override
    public void markAsComplete() {
        this.status = true;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

//        return id + ". " + description + (status ? " [complete]" : "" + "\t\t\t"+ df.format(dueDate));

        return id +"," + description +","+ (status ? "completed" : "incomplete") + "," + SortByDATE.convertDateToString(dueDate,"dd-MM-yyyy");

    }

    @Override
    public String getTaskType() {
        return taskType;
    }

    @Override
    public LocalDate dueDate() {
        return dueDate;
    }


    @Override
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public void setTaskType(String taskType) {
        this.taskType = "quick";
    } //Ensuring the task type is always "quick"

}
