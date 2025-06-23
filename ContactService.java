import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private final List<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        for (Contact c : contactList) {
            if (c.getContactID().equals(contact.getContactID())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }
        contactList.add(contact);
    }

    public void deleteContact(String contactID) {
        contactList.removeIf(c -> c.getContactID().equals(contactID));
    }

    public void updateFirstName(String contactID, String firstName) {
        for (Contact c : contactList) {
            if (c.getContactID().equals(contactID)) {
                c.setFirstName(firstName);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updateLastName(String contactID, String lastName) {
        for (Contact c : contactList) {
            if (c.getContactID().equals(contactID)) {
                c.setLastName(lastName);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updatePhone(String contactID, String phone) {
        for (Contact c : contactList) {
            if (c.getContactID().equals(contactID)) {
                c.setPhone(phone);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public void updateAddress(String contactID, String address) {
        for (Contact c : contactList) {
            if (c.getContactID().equals(contactID)) {
                c.setAddress(address);
                return;
            }
        }
        throw new IllegalArgumentException("Contact not found");
    }

    public Contact getContact(String contactID) {
        for (Contact c : contactList) {
            if (c.getContactID().equals(contactID)) {
                return c;
            }
        }
        return null;
    }
}
