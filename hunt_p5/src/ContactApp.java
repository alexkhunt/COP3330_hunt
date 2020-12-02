import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp{
    public static ContactList list = new ContactList();

    public ContactApp(){
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
                        "5) save the current list\n" +
                        "6) quit to the main menu\n"
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
                listMenuChoice = 7;
            }
            switch(listMenuChoice) {
                case 1:
                    ContactList.displayContactList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    if(list.getSize() <= 0){
                        System.out.println("no contacts to edit");
                        break;
                    }else{
                        editItem();
                    }
                    break;
                case 4:
                    if(list.getSize() > 0) {
                        removeItem();
                    }else{
                        System.out.println("no contacts to remove");
                    }
                    break;
                case 5:
                    if(list.getSize() > 0) {
                        saveItems();
                    }else{
                        System.out.println("no tasks to save");
                    }
                    break;
                case 6: break;
                default:
                    System.out.println("Invalid operation, please enter a number between 1-6\n");
                    break;
            }
        }while(listMenuChoice != 6);
    }

    private static void createList(){
        list = new ContactList();
        System.out.println("new task list has been created");
    }

    private static void loadList() {
        Scanner file = new Scanner(System.in);
        System.out.println("Enter the filename to load:");
        String fileName = file.nextLine();

        list = new ContactList();
        list.listLoader(fileName);

        System.out.println("contact list has been loaded\n");
    }

    private static void addItem(){
        Scanner input = new Scanner(System.in);

        System.out.print("First name: ");
        String firstName = input.nextLine();

        System.out.print("Last name: ");
        String lastName = input.nextLine();

        System.out.print("Phone number (xxx-xxx-xxxx): ");
        String phoneNumber = input.nextLine();

        System.out.print("Email address (x@y.z): ");
        String emailAddress = input.nextLine();

        if(firstName.isBlank() == true && lastName.isBlank() == true
           && phoneNumber.isBlank() == true && emailAddress.isBlank() == true){
            System.out.println("WARNING: no contact data entered, contact not saved");
        }else{
            new ContactItem(firstName, lastName, phoneNumber, emailAddress);
        }
    }

    private static void editItem(){
        Scanner editInput = new Scanner(System.in);
        ContactList.displayContactList();
        System.out.print("\nWhich contact will you edit? ");
        try{
            int itemToEdit = editInput.nextInt();
            editInput.nextLine();

            System.out.printf("Enter a new first name for contact %d: ", itemToEdit);
            String newFirstName = editInput.nextLine();
            System.out.printf("Enter a new last name for contact %d: ", itemToEdit);
            String newLastName = editInput.nextLine();
            System.out.printf("Enter a new phone number (xxx-xxx-xxxx) for contact %d: ", itemToEdit);
            String newPhoneNumber = editInput.nextLine();
            System.out.printf("Enter a new email address (x@y.z) for contact %d: ", itemToEdit);
            String newEmailAddress = editInput.nextLine();

            ContactList.editContactItem(newFirstName, newLastName, newPhoneNumber, newEmailAddress, itemToEdit);
        }catch(InputMismatchException ex) {
            System.out.println("Invalid input");
        }
    }

    private static void removeItem(){
        Scanner deleteInput = new Scanner(System.in);
        ContactList.displayContactList();
        System.out.println("\nWhich contact will you remove? ");
        try{
            int itemToDelete = deleteInput.nextInt();
            ContactList.removeContact(itemToDelete);
        }catch(InputMismatchException ex){
            System.out.println("Invalid input");
        }
    }

    private static void saveItems(){
        Scanner saveFileName = new Scanner(System.in);
        System.out.println("Enter the filename to save as: ");
        String newFileName = saveFileName.next();
        try{
            list.saveContactList(newFileName);
            System.out.println("contact list has been saved");
        }catch(Exception ex){
            System.out.println("Invalid filename, file not saved");
        }
    }
}

