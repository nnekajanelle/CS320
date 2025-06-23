import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testValidTask() {
        Task task = new Task("001", "Groceries", "Buy fruits and veggies");
        assertEquals("001", task.getTaskID());
        assertEquals("Groceries", task.getName());
        assertEquals("Buy fruits and veggies", task.getDescription());
    }

    @Test
    public void testSetName() {
        Task task = new Task("002", "Old Name", "Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("003", "Name", "Old Description");
        task.setDescription("Updated Description");
        assertEquals("Updated Description", task.getDescription());
    }

    @Test
    public void testInvalidTaskID() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Description");
        });
        assertEquals("Invalid task ID", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Name", "Description"); // 11 characters
        });
        assertEquals("Invalid task ID", exception.getMessage());
    }

    @Test
    public void testInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Task("004", null, "Description");
        });
        assertEquals("Invalid task name", exception.getMessage());

        exception = assertThrows(IllegalArgumentException
