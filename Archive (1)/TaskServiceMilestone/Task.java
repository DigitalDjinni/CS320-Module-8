public class Task {
    
    private final String taskID; 
    private String name;         
    private String description;

    // Constructor
    public Task(String taskID, String name, String description) {
        if (taskID == null || taskID.length() > 10) {
            throw new IllegalArgumentException("Invalid taskID");
        }
        this.taskID = taskID;
        setName(name); 
        setDescription(description);
    }

    // Getters and Setters
    public String getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.description = description;
    }
}
