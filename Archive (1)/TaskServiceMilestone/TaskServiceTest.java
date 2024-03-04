import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    // Tests that a new contact can be successfully added to the TaskService
    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        service.addTask(new Task("0002", "Second Task", "A Secnod Task"));
        assertNotNull(service.getTask("0002"));
        assertEquals("0002", service.getTask("0002").getTaskID());
        assertEquals("Second Task", service.getTask("0002").getName());
        assertEquals("A Secnod Task", service.getTask("0002").getDescription());
    }

    // Tests that adding a duplicate task ID to the TaskService throws an
    // IllegalArgumentException
    @Test
    public void testAddDuplicateContactID() {
        TaskService service = new TaskService();
        Task task1 = new Task("0002", "Second Task", "A Secnod Task");
        service.addTask(task1);

        Task task2 = new Task("0002", "Next Task", "Complete After First Task");
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
    }

    // Verification that the contact is deleted correctly
    @Test
    public void testDeleteContact() {
        TaskService service = new TaskService();
        service.addTask(new Task("0002", "Second Task", "A Secnod Task"));
        service.deleteTask("0002");
        assertNull(service.getTask("0002"));
    }

    // Verification that taskName is updated correctly
    @Test
    public void testUpdateTaskName(){
        TaskService service = new TaskService();
        service.addTask(new Task("0002", "Second Task", "A Secnod Task"));

        service.updateTaskName("0002", "New Task");
        assertEquals("New Task", service.getTask("0002").getName());
    }

    // Verification that taskDescription is updated correctly
    @Test
    public void testUpdateTaskDescription(){
        TaskService service = new TaskService();
        service.addTask(new Task("0002", "Second Task", "A Secnod Task"));

        service.updateTaskDescription("0002", "This is a new task");
        assertEquals("This is a new task", service.getTask("0002").getDescription());
    }

    // Verification that taskName and taskDescription are updated correctly
    @Test
    public void testUpdateTaskNameAndDescription(){
        TaskService service = new TaskService();
        service.addTask(new Task("0002", "Second Task", "A Secnod Task"));

        service.updateTask("0002", "Another Task", "Never Enough Tasks So Heres Another");
        assertEquals("Another Task", service.getTask("0002").getName());
        assertEquals("Never Enough Tasks So Heres Another", service.getTask("0002").getDescription());
    }
}
