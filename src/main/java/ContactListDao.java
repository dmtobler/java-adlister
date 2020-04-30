import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ContactListDao implements Contacts {

    // We need a List variable to hold all the Contacts
    private List<Contact> contacts = new ArrayList<>();

    // List all the contacts (List<Contact>)
    @Override
    public List<Contact> getContacts() {
        return contacts;
    };

    // Method for saving contacts
    // Will essentially get the length of the List<Contact> and +1
    @Override
    public long saveContact(Contact contact) {
        // Check to see if this is the first contact, and if so, add 1
        if(contact.getId() == 0) {
            // If we're setting up a contact that hasn't been assigned an ID (so it must have been constructed using just 'first', 'last', and 'phone' - NO ID, then we want to generate an ID and set it for this contact.
            contact.setId(contacts.size() + 1);
            contacts.add(contact);
        } else {
            // We already have the correct ID coming from my mySQL table , so let's just set that contact in the ArrayList (contacts) with the ID that was passed in
            contacts.set((int) contact.getId(), contact);
        }

        // Return the ID of the newly saved contact
        return contact.getId();
    };

    // Method for deleting contacts
    @Override
    public void deleteContactById(long id) {
        // Don't need a return vale
            // [1] -> John Smith
            // [2] -> Dax Smith
            // [3] -> Webb Smith
            // [4] -> 1337 Smith

        // Do a .remove on the passed in ID to remove that contact from the ArrayList
        contacts.remove((int) id - 1);
    }

    // Method for getting a contact by their ID
    @Override
    public Contact getContactById(long id) {
        return contacts.get((int) id - 1);
    }

    // Let's test our our DAO to ensure everything is working properly
    public static void main(String[] args) {
        Contacts contactsDao = new ContactListDao();

        // test the getContacts() method
        System.out.println("\n=== Testing getContacts()");
        List<Contact> allContacts = contactsDao.getContacts();
    }
}