import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private Map<String, Task> tasks;

    public TaskService(){
        tasks = new HashMap<>();
    }

    // Add a task
    public void addTask(Task task){
        if (tasks.containsKey(task.getTaskID())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskID(), task);
    }

    // Delete a task
    public void deleteTask(String taskID) {
        if (!tasks.containsKey(taskID)) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        tasks.remove(taskID);
    }

    // Update a task's name and description
    public void updateTask(String taskID, String newName, String newDescription) {
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        task.setName(newName);
        task.setDescription(newDescription);
    }

    public void updateTaskName(String taskID, String newName){
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        task.setName(newName);
    }

    public void updateTaskDescription(String taskID, String newDescription){
        Task task = tasks.get(taskID);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist");
        }
        task.setDescription(newDescription);
    }

    // Retrieves a task object by its taskID
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}
