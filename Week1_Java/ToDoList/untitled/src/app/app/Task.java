package app;

import app.Sorting.SortByDATE;

import java.time.LocalDate;
import java.util.Arrays;

public class Task {

    private static int counter = 0;
    private int starCount = 0;
    private int id;
    private String description;
    private boolean status;
    private LocalDate dueDate;
    private String taskType;
    private String[] sub_tasks;

    //Initiating the constructor/task
    public Task() {
        this.id = counter++;
        this.status = false;
    }




    // Parameterized constructor to initialize Task
    public Task(int id, String description, LocalDate dueDate, String taskType, String[] sub_tasks) {
        this.starCount = 0; // Default value
        this.id = ++counter;
        this.description = description;
        this.status = false; // Default value
        this.dueDate = dueDate;
        this.taskType = taskType;
        this.sub_tasks = new String[]{Arrays.toString(sub_tasks)};
    }

    public Task(int id, String description, boolean status, LocalDate dueDate, String taskType, String[] sub_tasks) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
        this.taskType = taskType;
        this.sub_tasks = new String[]{Arrays.toString(sub_tasks)};
    }

    public Task(int id, String description, LocalDate dueDate, String taskType) {
        this.id = ++counter;
        this.description = description;
        this.dueDate  = dueDate;
        this.taskType = taskType;
    }

    //start-point
    public void incrementStarCount(){
        this.starCount++;
    }
    public int getStarCount() {
        return starCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setStatus(boolean status) {
            this.status = status;
    }

//    public void setDueDate(LocalDate dueDate) {
//        this.dueDate = dueDate;
//    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean getStatus() {
        return status;
    }

    public String[] getSub_tasks() {
        return sub_tasks;
    }

    public void setSub_tasks(String[] sub_tasks) {
        this.sub_tasks = sub_tasks;
    }

    @Override
    public String toString() {
//        return id + ", " + description + ", " + SortByDATE.convertDateToString(dueDate, "dd-MM-yyyy") + ", " + taskType + ", " + subTasks + ", " + (status ? "completed" : "incomplete");

        return id +"," + description +"," + SortByDATE.convertDateToString(dueDate,"dd-MM-yyyy")+ "," + taskType+ "," +Arrays.toString(sub_tasks) ;
    }
}