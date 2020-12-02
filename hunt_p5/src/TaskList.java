import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class TaskList{
    static List<TaskItem> tasks;

    public TaskList(){
        this.tasks = new ArrayList<>();
    }

    public static void listLoader(String filename){
        List<TaskItem> backup = tasks;

        tasks = new ArrayList<>();
        try(Scanner input = new Scanner(Paths.get(filename))){
            String header = input.nextLine();
            if(header.equalsIgnoreCase("tasks")){
                while(input.hasNext()){
                    String dueDate = input.nextLine();
                    String title = input.nextLine();
                    String description = input.nextLine();
                    String complete = input.nextLine();
                    if (complete.equalsIgnoreCase("complete")) {
                        TaskItem item = new TaskItem(title, description, dueDate, true);
                    }else{
                        TaskItem item = new TaskItem(title, description, dueDate, false);
                    }
                }
            }else{
                tasks = backup;
                throw new InputMismatchException("WARNING: filename is not a valid task list; no data loaded");
            }
        }catch(FileNotFoundException e){
            tasks = backup;
            throw new IllegalArgumentException("WARNING: task file not found; no task list loaded");
        }catch(IOException e){
            tasks = backup;
            throw new IllegalArgumentException("WARNING: error loading task data; no task list loaded");
        }
    }


    public static void displayTaskList(){
        System.out.println("Current Tasks");
        System.out.println("-------------\n");
        for(int i = 0; i < tasks.size(); i++) {
            TaskItem data = tasks.get(i);
            if (data.getCompleted() == true) {
                System.out.println(i + ") *** " + "[" + data.getDate() + "] " + data.getTitle() + ": " + data.getDescription());
            } else {
                System.out.println(i + ") " + "[" + data.getDate() + "] " + data.getTitle() + ": " + data.getDescription());
            }
        }
    }

    public static void displayIncompleteTasks(){
        System.out.println("Uncompleted Tasks");
        System.out.println("-------------\n");
        for(int i = 0; i < tasks.size(); i++) {
            TaskItem data = tasks.get(i);
            if (data.getCompleted() == false)
                System.out.println(i + ") " + "[" + data.getDate() + "] " + data.getTitle() + ": " + data.getDescription());
        }
    }

    public static void displayCompleteTasks(){
        System.out.println("Completed Tasks");
        System.out.println("-------------\n");
        for(int i = 0; i < tasks.size(); i++) {
            TaskItem data = tasks.get(i);
            if (data.getCompleted() == true)
                System.out.println(i + ") " + "[" + data.getDate() + "] " + data.getTitle() + ": " + data.getDescription());
        }
    }

    public static void addTaskItem(TaskItem data){
        tasks.add(data);
    }

    public static void editTaskItem(String newTitle, String newDescription, String newDate, int index){
        if((index >= 0) && (index < tasks.size())) {
            tasks.get(index).setTitle(newTitle);
            tasks.get(index).setDescription(newDescription);
            tasks.get(index).setDate(newDate);
        }else{
            System.out.println("Invalid index, no changes made");
            return;
        }
    }

    public static String removeTaskItem(int index){
        if((index >= 0) && (index < tasks.size())){
            tasks.remove(index);
            return null;
        }else{
            System.out.println("Invalid index, no item deleted");
            return "Invalid index, no item deleted";
        }
    }

    public static void saveTaskList(String filename){
        try (Formatter output = new Formatter(filename)){
            output.format("tasks%n");
            for(TaskItem item : tasks){
                output.format("%s%n", item.getDate());
                output.format("%s%n", item.getTitle());
                output.format("%s%n", item.getDescription());
                if(item.getCompleted() == true){
                    output.format("complete%n");
                }else{
                    output.format("incomplete%n");
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void markItemCompleted(int index){
        if((index >= 0) && (index < tasks.size())){
            tasks.get(index).setCompleted();
        }else{
            System.out.println("Invalid index, no item marked");
            return;
        }
    }

    public static void markItemUncompleted(int index){
        if((index >= 0) && (index < tasks.size())){
            tasks.get(index).setUncompleted();
        }else{
            System.out.println("Invalid index, no item unmarked");
            return;
        }
    }

    public static int getSize(){
        return tasks.size();
    }

    public static String getDescription(int index){
        if((index >= 0) && (index < tasks.size())){
            return tasks.get(index).getDescription();
        }else{
            return "Out of bounds exception";
        }
    }

    public static String getDueDate(int index){
        if((index >= 0) && (index < tasks.size())){
            return tasks.get(index).getDate();
        }else{
            return "Out of bounds exception";
        }
    }

    public static String getTitle(int index){
        if((index >= 0) && (index < tasks.size())){
            return tasks.get(index).getTitle();
        }else{
            return "Out of bounds exception";
        }
    }

    public static Boolean getCompleted(int index){
        if((index >= 0) && (index < tasks.size())) {
            return tasks.get(index).getCompleted();
        }else {
            return null;
        }
    }
}
