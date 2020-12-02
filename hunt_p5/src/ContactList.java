import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ContactList {
    static List<ContactItem> contacts;

    public ContactList(){
        this.contacts = new ArrayList<>();
    }

    public static void listLoader(String filename){
        List<ContactItem> backup = contacts;

        contacts = new ArrayList<>();
        try(Scanner input = new Scanner(Paths.get(filename))){
            String header = input.nextLine();
            if(header.equalsIgnoreCase("contacts")){
                while(input.hasNext()){
                    String firstName = input.nextLine();
                    String lastName = input.nextLine();
                    String phoneNumber = input.nextLine();
                    String emailAddress = input.nextLine();
                    ContactItem item = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
                }
            }else{
                contacts = backup;
                throw new InputMismatchException("WARNING: filename is not a valid contact list; no data loaded");
            }
        }catch(FileNotFoundException e){
            contacts = backup;
            throw new IllegalArgumentException("WARNING: contact file not found; no contact list loaded");
        }catch(IOException e){
            contacts = backup;
            throw new IllegalArgumentException("WARNING: error loading contact data; no contact list loaded");
        }
    }

    public static void displayContactList(){
        System.out.println("Current Contacts");
        System.out.println("-------------\n");
        for(int i = 0; i < contacts.size(); i++) {
            ContactItem data = contacts.get(i);
            System.out.println(i + ") Name: " + data.getFirstName() + " " + data.getLastName() + "\nPhone: " + data.getPhoneNumber() + "\nEmail: " + data.getEmailAddress());
        }
    }

    public static void addContactItem(ContactItem data){
        contacts.add(data);
    }

    public static void editContactItem(String newFirstName, String newLastName, String newPhoneNumber, String newEmailAddress, int index){
        if(newFirstName.isBlank() == true && newLastName.isBlank() == true
                && newPhoneNumber.isBlank() == true && newEmailAddress.isBlank() == true) {
            System.out.println("WARNING: contacts can not be blank, contact not edited");
            return;
        }
        if((index >= 0) && (index < contacts.size())) {
            contacts.get(index).setFirstName(newFirstName);
            contacts.get(index).setLastName(newLastName);
            contacts.get(index).setPhoneNumber(newPhoneNumber);
            contacts.get(index).setEmailAddress(newEmailAddress);
        }else{
            System.out.println("Invalid index, no changes made");
            return;
        }
    }

    public static String removeContact(int index){
        if((index >= 0) && (index < contacts.size())){
            contacts.remove(index);
            return null;
        }else{
            System.out.println("Invalid index, no contact deleted");
            return "Invalid index, no contact deleted";
        }
    }

    public static void saveContactList(String filename){
        try (Formatter output = new Formatter(filename)){
            output.format("contacts%n");
            for(ContactItem item : contacts){
                output.format("%s%n", item.getFirstName());
                output.format("%s%n", item.getLastName());
                output.format("%s%n", item.getPhoneNumber());
                output.format("%s%n", item.getEmailAddress());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static int getSize(){
        return contacts.size();
    }

    public static String getFirstName(int index){
        if((index >= 0) && (index < contacts.size())){
            return contacts.get(index).getFirstName();
        }else{
            return "Out of bounds exception";
        }
    }

    public static String getLastName(int index){
        if((index >= 0) && (index < contacts.size())){
            return contacts.get(index).getLastName();
        }else{
            return "Out of bounds exception";
        }
    }

    public static String getPhoneNumber(int index){
        if((index >= 0) && (index < contacts.size())){
            return contacts.get(index).getPhoneNumber();
        }else{
            return "Out of bounds exception";
        }
    }

    public static String getEmailAddress(int index){
        if((index >= 0) && (index < contacts.size())){
            return contacts.get(index).getEmailAddress();
        }else{
            return "Out of bounds exception";
        }
    }
}
