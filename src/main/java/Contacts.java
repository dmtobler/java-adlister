import java.util.List;

// This is our interface for our Contact bean (to be implemented by our DAO)
public interface Contacts {

    // List all the contacts (List<Contact>)
    List<Contact> getContacts();

    // Method for saving contacts
    // Will essentially get the length of the List<Contact> and +1
    long saveContact(Contact contact);

    // Method for deleting contacts
    void deleteContactById(long id);

    // Method for getting a contact by their ID
    Contact getContactById(long id);
}