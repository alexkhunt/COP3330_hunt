public class ContactItem{
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;

    public ContactItem(String firstName, String lastName, String phoneNumber, String emailAddress){
        if(firstName.isBlank() == true && lastName.isBlank() == true
                && phoneNumber.isBlank() == true && emailAddress.isBlank() == true){
            System.out.println("WARNING: attempt to create invalid contact, all values can not be blank");
            return;
        }
        setFirstName(firstName);
        setLastName(lastName);
        setPhoneNumber(phoneNumber);
        setEmailAddress(emailAddress);
        ContactList.addContactItem(this);
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setEmailAddress(String emailAddress){
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress(){
        return this.emailAddress;
    }
}