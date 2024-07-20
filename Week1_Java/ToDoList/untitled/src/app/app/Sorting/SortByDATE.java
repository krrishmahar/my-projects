package app.Sorting;

import app.Features.Task.TaskManager;
import app.Task;
import app.ToDoList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class SortByDATE extends TaskManager {

    public static LocalDate parseDate(String pattern, String dueDate) {
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern(pattern);
        LocalDate localDate = LocalDate.parse(dueDate, formatter);
        return localDate;
    }

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
        public int compare(Map.Entry<String, Task> task1, Map.Entry<String, Task> task2) {
            LocalDate dueDateFirstTask = task1.getValue().getDueDate();
            LocalDate dueDateSecondTask = task2.getValue().getDueDate();
            return dueDateFirstTask.compareTo(dueDateSecondTask);
        }
    });

    if (!entries.isEmpty()) {
        System.out.println("Tasks successfully sorted");
    }else {
        System.out.println("Your list is empty, add tasks first then sort it (>_<)!! ");
    }

    }


    /*isValid() will check the validity of String by creating a formatter of required pattern
    * meaning date(30th June) is converted into pattern(06-30) and localDate parse value into that pattern
    * and further changed into String datatype and check if it is valid by .equals()*/

    public static boolean isValid(String pattern, String value){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate localDate =  LocalDate.parse(value, formatter);
            String result = localDate.format(formatter);
            return result.equals(value);
        } catch (DateTimeParseException e) {
        }
        return false;
    }


//    public static String convertDateToString(LocalDate date, String format) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
//        String result = null;
//        try {
//            result = date.format(formatter);
//
//        } catch (DateTimeParseException e) {
//
//        }
//        return result;
//    }

    public static String convertDateToString(LocalDate date, String format) {
        if (date == null) {
            return ""; // or any other default value or error handling mechanism you prefer
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String result = null;
        try {
            result = date.format(formatter);
        } catch (DateTimeParseException e) {
            // Handle parsing exception if needed
        }
        return result;
    }


    /*changes Date into String*/
//    public static String convertDateToString(LocalDate date, String format) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
//        String result = null;
//        try {
//            result = date.format(formatter);
//        } catch (DateTimeParseException e) {
//
//        }
//        return result;
//    }

}
