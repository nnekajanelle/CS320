import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private final List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        for (Task t : taskList) {
            if (t.getTaskID().equals(task.getTaskID())) {
                throw new IllegalArgumentException("Task ID already exists");
            }
        }
        taskList.add(task);
    }

    public void deleteTask(String taskID) {
        taskList.removeIf(t -> t.getTaskID().equals(taskID));
    }

    public void updateName(String taskID, String name) {
        for (Task t : taskList) {
            if (t.getTaskID().equals(taskID)) {
                t.setName(name);
                return;
            }
        }
        throw new IllegalArgumentException("Task not found");
    }

    public void updateDescription(String taskID, String description) {
        for (Task t : taskList) {
            if (t.getTaskID().equals(taskID)) {
                t.setDescription(description);
                return;
            }
        }
        throw new IllegalArgumentException("Task not found");
    }

    public Task getTask(String taskID) {
        for (Task t : taskList) {
            if (t.getTaskID().equals(taskID)) {
                return t;
            }
        }
        return null;
    }
}

