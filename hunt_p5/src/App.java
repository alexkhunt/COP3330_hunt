import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select Your Application");
            System.out.println("-----------------------");
            System.out.println();
            System.out.println("1) task list");
            System.out.println("2) contact list");
            System.out.println("3) quit");
            Scanner scan = new Scanner(System.in);
            String menuChoice = scan.next();
            if(menuChoice.contains("1")){
                TaskApp tasks = new TaskApp();
            }else if(menuChoice.contains("2")){
                ContactApp contacts = new ContactApp();
            }else if(menuChoice.contains("3")){
                break;
            }else{
                System.out.println("Invalid input");
            }
        }

    }
}
