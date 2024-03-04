import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    // Test the creation of a Task object with valid parameters
    @Test
    public void createTaskTest() {
        Task task = new Task("0001", "First Task", "First Task On The List");
        assertNotNull(task);
        assertEquals("0001", task.getTaskID());
        assertEquals("First Task", task.getName());
        assertEquals("First Task On The List", task.getDescription());
    }

    // IllegalArgumentException is thrown when task ID is null
    @Test
    public void InvalidTaskID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task", "Basic Task");
        });
    }

    // IllegalArgumentException is thrown when task ID is too long
    @Test
    public void InvalidTaskIDTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("012345678910", "Task", "Basic Task");
        });
    }

    // IllegalArgumentException is thrown when task name is null
    @Test
    public void InvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("0001", null, "Basic Task");
        });
    }

    // IllegalArgumentException is thrown when task name is too long
    @Test
    public void InvalidTaskNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("0001", "This is a super long name for a first task", "Basic Task");
        });
    }

    // IllegalArgumentException is thrown when task description is null
    @Test
    public void InvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("0001", "Task", null);
        });
    }

    // IllegalArgumentException is thrown when task description is too long
    @Test
    public void InvalidTaskDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("0001", "Task",
                    "This is the longest task description that ever existed for this task. Sure some tasks may have had longer descriptions but never this task. This task liked simple things but for some reason has the longest description EVERRRR!!!!!");
        });
    }

}
