import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactItemTest {

    @Test
    public void creationFailsWithAllBlankValues(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("", "", "", "");
        assertEquals(null, data.getFirstName());
        assertEquals(0, test.getSize());
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "");
        assertEquals("first", data.getFirstName());
        assertEquals(1, test.getSize());
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("", "last", "123-456-7891", "a@b.c");
        assertEquals("last", data.getLastName());
        assertEquals(1, test.getSize());
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "", "123-456-7891", "a@b.c");
        assertEquals("first", data.getFirstName());
        assertEquals(1, test.getSize());
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "", "a@b.c");
        assertEquals("first", data.getFirstName());
        assertEquals(1, test.getSize());
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "a@b.c");
        assertEquals("first", data.getFirstName());
        assertEquals("last", data.getLastName());
        assertEquals("123-456-7891", data.getPhoneNumber());
        assertEquals("a@b.c", data.getEmailAddress());
        assertEquals(1, test.getSize());
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("", "", "", "", 0);
        assertEquals("first", data.getFirstName());
        assertEquals("last", data.getLastName());
        assertEquals("123-456-7891", data.getPhoneNumber());
        assertEquals("no@thank.s", data.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first", "last", "123-456-7891", "", 0);
        assertEquals("first", data.getFirstName());
        assertEquals("last", data.getLastName());
        assertEquals("123-456-7891", data.getPhoneNumber());
        assertEquals("", data.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("", "last", "123-456-7891", "no@thank.s", 0);
        assertEquals("", data.getFirstName());
        assertEquals("last", data.getLastName());
        assertEquals("123-456-7891", data.getPhoneNumber());
        assertEquals("no@thank.s", data.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first", "", "123-456-7891", "no@thank.s", 0);
        assertEquals("first", data.getFirstName());
        assertEquals("", data.getLastName());
        assertEquals("123-456-7891", data.getPhoneNumber());
        assertEquals("no@thank.s", data.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first", "last", "", "no@thank.s", 0);
        assertEquals("first", data.getFirstName());
        assertEquals("last", data.getLastName());
        assertEquals("", data.getPhoneNumber());
        assertEquals("no@thank.s", data.getEmailAddress());
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList test = new ContactList();
        ContactItem data = new ContactItem("first", "last", "123-456-7891", "no@thank.s");
        test.editContactItem("first2", "last2", "555-555-5555", "ayyyy.gm.co", 0);
        assertEquals("first2", data.getFirstName());
        assertEquals("last2", data.getLastName());
        assertEquals("555-555-5555", data.getPhoneNumber());
        assertEquals("ayyyy.gm.co", data.getEmailAddress());
    }
}