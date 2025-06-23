import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("001", "Do Homework", "Finish math and science homework");
        service.addTask(task);
        assertEquals("Do Homework", service.getTask("001").getName());
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("002", "Walk Dog", "Take the dog out for a walk");
        service.addTask(task);
        service.deleteTask("002");
        assertNull(service.getTask("002"));
    }

    @Test
    public void testUpdateName() {
        TaskService service = new TaskService();
        Task task = new Task("003", "Old Name", "Task description");
        service.addTask(task);
        service.updateName("003", "New Name");
        assertEquals("New Name", service.getTask("003").getName());
    }

    @Test
    public void testUpdateDescription() {
        TaskService service = new TaskService();
        Task task = new Task("004", "Task Name", "Old Description");
        service.addTask(task);
        service.updateDescription("004", "New Description");
        assertEquals("New Description", service.getTask("004").getDescription());
    }
}
