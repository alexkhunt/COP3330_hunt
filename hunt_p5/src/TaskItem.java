import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class TaskItem{
    private String title;
    private String description;
    private String date;
    private Boolean completed;

    public TaskItem(String title, String description, String date){
        if(title.isBlank() == false){
            setTitle(title);
        }else{
            System.out.println("WARNING: title must be at least 1 character long; task not created");
            return;
        }
        setDescription(description);
        if(isDateValid(date) == true) {
            setDate(date);
        }else{
            System.out.println("WARNING: invalid due date; task not created");
            return;
        }
        setUncompleted();
        TaskList.addTaskItem(this);
    }

    public TaskItem(String title, String description, String date, Boolean completed){
        if(title.isBlank() == false){
            setTitle(title);
        }else{
            System.out.println("WARNING: title must be at least 1 character long; task not created");
            return;
        }
        setDescription(description);
        if(isDateValid(date) == true) {
            setDate(date);
        }else{
            System.out.println("WARNING: invalid due date; task not created");
            return;
        }
        if(completed == false){
            setUncompleted();
        }
        if(completed == true){
            setCompleted();
        }

        TaskList.addTaskItem(this);
    }

    public String setTitle(String title){
        if(title.length() > 0)
            this.title = title;
        else
            System.out.println("Name must be at least one character, name not updated");
        return "Name must be at least one character, name not updated";
    }

    public String getTitle(){
        return this.title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }

    public String setDate(String date){
        if(isDateValid(date) == true) {
            this.date = date;
            return null;
        }else {
            System.out.println("invalid due date; due date not updated");
            return "invalid due date; due date not updated";
        }
    }

    public String getDate(){
        return this.date;
    }

    public void setCompleted(){
        this.completed = true;
    }

    public void setUncompleted(){
        this.completed = false;
    }

    public Boolean getCompleted(){
        return this.completed;
    }

    public boolean isDateValid(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(false);
        try{
            format.parse(date.trim());
        }catch (ParseException ex) {
            return false;
        }
        try {
            Date date1 = format.parse(date);
            Date date2 = format.parse(String.valueOf(LocalDate.now()));
            if(date1.compareTo(date2) < 0)
                return false;
        }catch (ParseException e) {
            return false;
        }
        return true;
    }
}