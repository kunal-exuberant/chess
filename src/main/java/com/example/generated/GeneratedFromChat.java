import java.util.ArrayList;
import java.util.List;

// Task interface
interface Task {
    void execute();
}

// Concrete Task implementation
class PrintTask implements Task {
    private String message;

    public PrintTask(String message) {
        this.message = message;
    }

    @Override
    public void execute() {
        System.out.println(message);
    }
}

// Workflow Manager
class WorkflowManager {
    private List<Task> tasks;

    public WorkflowManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Executing the task");

    }

    public void executeWorkflow() {
        for (Task task : tasks) {
            task.execute();
        }
    }
}

// Main class to demonstrate the workflow manager
public class WorkflowDemo {
    public static void main(String[] args) {
        WorkflowManager workflowManager = new WorkflowManager();

        // Adding tasks to the workflow
        workflowManager.addTask(new PrintTask("Task 1: Start Workflow"));
        workflowManager.addTask(new PrintTask("Task 2: Process Data"));
        workflowManager.addTask(new PrintTask("Task 3: End Workflow"));

        // Execute the workflow
        workflowManager.executeWorkflow();
    }
}