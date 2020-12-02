import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactListTest {
    @Test
    public void addingContactItemsIncreasesSize(){
        ContactList test = new ContactList();
        int x = test.getSize();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        int y = test.getSize();
        assertTrue(y > x);
    }

    @Test
    public void editingContactItemChangesValues(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 0);
        assertEquals("first2", data.getFirstName());
        assertEquals("last2", data.getLastName());
        assertEquals("555-555-5555", data.getPhoneNumber());
        assertEquals("nope@at.all", data.getEmailAddress());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("", "", "", "", 0);
        assertEquals("first", data.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("", "last2", "555-555-5555", "nope@at.all", 0);
        assertEquals("", data.getFirstName());
        assertEquals("last2", data.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "", "555-555-5555", "nope@at.all", 0);
        assertEquals("", data.getLastName());
        assertEquals("first2", data.getFirstName());
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "", "nope@at.all", 0);
        assertEquals("", data.getPhoneNumber());
        assertEquals("last2", data.getLastName());
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "", 0);
        assertEquals("", data.getEmailAddress());
        assertEquals("last2", data.getLastName());
    }

    @Test
    public void editingContactFirstNameChangesValue(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 0);
        assertEquals("first2", data.getFirstName());
    }

    @Test
    public void editingContactItemFirstNameFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 1);
        assertEquals("first", data.getFirstName());
    }

    @Test
    public void editingContactLastNameChangesValue(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 0);
        assertEquals("last2", data.getLastName());
    }

    @Test
    public void editingContactItemLastNameFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 1);
        assertEquals("last", data.getLastName());
    }

    @Test
    public void editingContactItemPhoneNumberChangesValue(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 0);
        assertEquals("555-555-5555", data.getPhoneNumber());
    }

    @Test
    public void editingContactItemPhoneNumberFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 1);
        assertEquals("123-456-7891", data.getPhoneNumber());
    }

    @Test
    public void editingContactItemEmailAddressChangesValue(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 0);
        assertEquals("nope@at.all", data.getEmailAddress());
    }

    @Test
    public void editingContactItemEmailAddressFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "nope@at.all", 1);
        assertEquals("no@thank.s", data.getEmailAddress());
    }

    @Test
    public void gettingContactItemFirstNameFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        assertEquals("Out of bounds exception", test.getFirstName(1));
    }

    @Test
    public void gettingContactItemFirstNameSucceedsWithValidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        assertEquals("first", test.getFirstName(0));
    }

    @Test
    public void gettingContactItemLastNameFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        assertEquals("Out of bounds exception", test.getLastName(1));
    }

    @Test
    public void gettingContactItemLastNameSucceedsWithValidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        assertEquals("last", test.getLastName(0));
    }

    @Test
    public void gettingContactItemPhoneNumberFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        assertEquals("Out of bounds exception", test.getPhoneNumber(1));
    }

    @Test
    public void gettingContactItemPhoneNumberSucceedsWithValidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        assertEquals("123-456-7891", test.getPhoneNumber(0));
    }

    @Test
    public void gettingContactItemEmailAddressFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        assertEquals("Out of bounds exception", test.getEmailAddress(1));
    }

    @Test
    public void gettingContactItemEmailAddressSucceedsWithValidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        assertEquals("no@thank.s", test.getEmailAddress(0));
    }

    @Test
    public void newContactListIsEmpty(){
        ContactList test = new ContactList();
        assertEquals(0, test.getSize());
    }

    @Test
    public void removingContactItemsDecreasesSize(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        ContactItem data2 = new ContactItem("first2", "last2", "555-555-5555", "a@b.c");
        int y = test.getSize();
        test.removeContact(1);
        int x = test.getSize();
        assertTrue(y > x);
    }

    @Test
    public void removingContactItemsFailsWithInvalidIndex(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        ContactItem data2 = new ContactItem("first2", "last2", "555-555-5555", "a@b.c");
        assertEquals("Invalid index, no contact deleted", test.removeContact(3));
    }

    @Test
    public void savedContactListCanBeLoaded(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.saveContactList("contacts.txt");
        test.listLoader("contacts.txt");
        assertEquals("first", test.getFirstName(0));
    }



}