import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskApp{
    public static TaskList list = new TaskList();

    public TaskApp(){
        int mainMenuChoice = 0;

        do{
            Scanner sMain = new Scanner(System.in);
            printMainMenu();
            try{
                int mainSelection = sMain.nextInt();
                mainMenuChoice = mainSelection;
            }
            catch(InputMismatchException e) {
                sMain.nextLine();
                mainMenuChoice = 4;
            }
            switch(mainMenuChoice){
                case 1:
                    createList();
                    listMenu();
                    break;
                case 2:
                    loadList();
                    listMenu();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid input, please enter a number between 1 and 3\n");
                    break;
            }
        }while(mainMenuChoice != 3);
    }

    public static void printMainMenu() {
        System.out.println(
                "Main Menu\n" +
                        "---------\n\n" +
                        "1) create a new list\n" +
                        "2) load an existing list\n" +
                        "3) quit\n"
        );
    }

    public static void printListOperationMenu() {
        System.out.println(
                "List Operation Menu\n" +
                        "---------\n\n" +
                        "1) view the list\n" +
                        "2) add an item\n" +
                        "3) edit an item\n" +
                        "4) remove an item\n" +
                        "5) mark an item as completed\n" +
                        "6) unmark an item as completed\n" +
                        "7) save the current list\n" +
                        "8) quit to the main menu\n"
        );
    }

    private static void listMenu(){
        int listMenuChoice;
        do{
            Scanner sList = new Scanner(System.in);
            printListOperationMenu();
            try {
                listMenuChoice = sList.nextInt();
            }catch(InputMismatchException e){
                sList.nextLine();
                listMenuChoice = 9;
            }
            switch(listMenuChoice) {
                case 1:
                    TaskList.displayTaskList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    if(list.getSize() <= 0){
                        System.out.println("no tasks to edit");
                        break;
                    }else{
                        editItem();
                    }
                    break;
                case 4:
                    if(list.getSize() > 0) {
                        removeItem();
                    }else{
                        System.out.println("no tasks to remove");
                    }
                    break;
                case 5:
                    if(list.getSize() > 0) {
                        markComplete();
                    }else{
                        System.out.println("no tasks to mark");
                    }
                    break;
                case 6:
                    if(list.getSize() > 0) {
                        unmarkComplete();
                    }else{
                        System.out.println("no tasks to unmark");
                    }
                    break;
                case 7:
                    if(list.getSize() > 0) {
                        saveItems();
                    }else{
                        System.out.println("no tasks to save");
                    }
                    break;
                case 8: break;
                default:
                    System.out.println("Invalid operation, please enter a number between 1-8\n");
                    break;
            }
        }while(listMenuChoice != 8);
    }

    private static void createList(){
        list = new TaskList();
        System.out.println("new task list has been created");
    }

    private static void loadList() {
        Scanner file = new Scanner(System.in);
        System.out.println("Enter the filename to load:");
        String fileName = file.nextLine();

        list = new TaskList();
        list.listLoader(fileName);

        System.out.println("task list has been loaded\n");
    }

    private static void addItem(){
        Scanner input = new Scanner(System.in);

        System.out.print("Task title: ");
        String title = input.nextLine();

        System.out.print("Task description: ");
        String description = input.nextLine();

        System.out.print("Task due date (YYYY-MM-DD):");
        String date = input.nextLine();

        new TaskItem(title, description, date);
    }

    private static void editItem(){
        Scanner editInput = new Scanner(System.in);
        TaskList.displayTaskList();
        System.out.print("\nWhich task will you edit? ");
        try{
            int itemToEdit = editInput.nextInt();
            editInput.nextLine();
            System.out.printf("Enter a new title for task %d: ", itemToEdit);
            String newTitle = editInput.nextLine();
            System.out.printf("Enter a new description for task %d: ", itemToEdit);
            String newDescription = editInput.nextLine();
            System.out.printf("Enter a new task due date (YYYY-MM-DD) for task %d: ", itemToEdit);
            String newDate = editInput.nextLine();
            TaskList.editTaskItem(newTitle, newDescription, newDate, itemToEdit);
        }catch(InputMismatchException ex) {
            System.out.println("Invalid input");
        }
    }

    private static void removeItem(){
        Scanner deleteInput = new Scanner(System.in);
        TaskList.displayTaskList();
        System.out.println("\nWhich task will you remove? ");
        try{
            int itemToDelete = deleteInput.nextInt();
            TaskList.removeTaskItem(itemToDelete);
        }catch(InputMismatchException ex){
            System.out.println("Invalid input");
        }
    }

    private static void markComplete(){
        Scanner completedInput = new Scanner(System.in);
        TaskList.displayIncompleteTasks();
        System.out.println("\nWhich task will you mark as completed? ");
        try{
            int completedItem = completedInput.nextInt();
            TaskList.markItemCompleted(completedItem);
        }catch(InputMismatchException ex){
            System.out.println("Invalid input");
        }
    }

    private static void unmarkComplete(){
        Scanner uncompletedInput = new Scanner(System.in);
        TaskList.displayCompleteTasks();
        System.out.println("\nWhich task will you unmark as completed? ");
        try{
            int uncompletedItem = uncompletedInput.nextInt();
            TaskList.markItemUncompleted(uncompletedItem);
        }catch(InputMismatchException ex){
            System.out.println("Invalid input");
        }
    }

    private static void saveItems(){
        Scanner saveFileName = new Scanner(System.in);
        System.out.println("Enter the filename to save as: ");
        String newFileName = saveFileName.next();
        try{
            list.saveTaskList(newFileName);
            System.out.println("task list has been saved");
        }catch(Exception ex){
            System.out.println("Invalid filename, file not saved");
        }
    }
}
