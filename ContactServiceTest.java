import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        assertEquals("John", service.getContact("123").getFirstName());
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.deleteContact("123");
        assertNull(service.getContact("123"));
    }

    @Test
    public void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("123", "Jane");
        assertEquals("Jane", service.getContact("123").getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateLastName("123", "Smith");
        assertEquals("Smith", service.getContact("123").getLastName());
    }

    @Test
    public void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updatePhone("123", "0987654321");
        assertEquals("0987654321", service.getContact("123").getPhone());
    }

    @Test
    public void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        service.addContact(contact);
        service.updateAddress("123", "456 Oak St");
        assertEquals("456 Oak St", service.getContact("123").getAddress());
    }
}
