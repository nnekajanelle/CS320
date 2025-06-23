import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testValidContact() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("123", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    public void testSetFirstName() {
        Contact contact = new Contact("124", "Jane", "Doe", "0987654321", "456 Elm St");
        contact.setFirstName("Alice");
        assertEquals("Alice", contact.getFirstName());
    }

    @Test
    public void testSetLastName() {
        Contact contact = new Contact("125", "Tom", "Smith", "1122334455", "789 Oak St");
        contact.setLastName("Brown");
        assertEquals("Brown", contact.getLastName());
    }

    @Test
    public void testSetPhone() {
        Contact contact = new Contact("126", "Mike", "Taylor", "1112223333", "321 Pine St");
        contact.setPhone("9998887777");
        assertEquals("9998887777", contact.getPhone());
    }

    @Test
    public void testSetAddress() {
        Contact contact = new Contact("127", "Lily", "White", "4445556666", "Old Address");
        contact.setAddress("New Address 123");
        assertEquals("New Address 123", contact.getAddress());
    }

    @Test
    public void testInvalidContactID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid contact ID", exception.getMessage());
    }

    @Test
    public void testInvalidFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("128", null, "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("128", "FirstnameTooLong", "Doe", "1234567890", "123 Main St");
        });
        assertEquals("Invalid first name", exception.getMessage());
    }

    @Test
    public void testInvalidLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("129", "John", null, "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("129", "John", "LastnameTooLong", "1234567890", "123 Main St");
        });
        assertEquals("Invalid last name", exception.getMessage());
    }

    @Test
    public void testInvalidPhone() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("130", "John", "Doe", null, "123 Main St");
        });
        assertEquals("Phone number must be exactly 10 digits", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("130", "John", "Doe", "12345", "123 Main St");
        });
        assertEquals("Phone number must be exactly 10 digits", exception.getMessage());
    }

    @Test
    public void testInvalidAddress() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("131", "John", "Doe", "1234567890", null);
        });
        assertEquals("Invalid address", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("131", "John", "Doe", "1234567890", "This address is way too long to be accepted as valid input");
        });
        assertEquals("Invalid address", exception.getMessage());
    }
}
