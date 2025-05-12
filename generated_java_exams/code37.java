/*
 * Exam Question #37
 * Generated on: 2025-05-11 21:55:10
 * 
 * QUESTION:
 * ## Java Programming Exam: Advanced Task Processing System
 * 
 * **Problem Description:**
 * 
 * You are tasked with building a simple, command-line based Task Processing System. This system should manage a queue of pending tasks, allow users to add new tasks of different types, process tasks individually or in bulk, and view a history of processed tasks.
 * 
 * The system must handle different types of tasks, such as "File Processing", "Database Query", and "Send Notification". Each task should have a unique ID and a description. When a task is processed, its `execute` method is called, which simulates work. For demonstration purposes, task execution might sometimes fail (e.g., simulate a file not found or a database connection error).
 * 
 * Your implementation must demonstrate a strong understanding of Java collections, control flow, input/output, and exception handling.
 * 
 * **System Functionality:**
 * 
 * 1.  **Add Task:** Allows the user to add a new task to the pending queue. The user should specify the task type ("FILE", "DB", "NOTIFY") and a description. The system should assign a unique ID (e.g., sequential number). Invalid task types should be rejected.
 * 2.  **Process Next Task:** Dequeues and processes the next task from the front of the queue. If the queue is empty, an appropriate message should be displayed. Task execution should be wrapped in error handling; successful tasks and failed tasks should be moved to a history list.
 * 3.  **Process All Tasks:** Processes all tasks currently in the pending queue by repeatedly calling "Process Next Task" until the queue is empty.
 * 4.  **View History:** Displays a list of all tasks that have been processed (successfully or failed), showing their ID, type, description, and status (Completed/Failed).
 * 5.  **Exit:** Terminates the program.
 * 
 * **Technical Requirements:**
 * 
 * 1.  Use `java.util.Queue` to store pending tasks. A `LinkedList` is a suitable implementation.
 * 2.  Use `java.util.ArrayList` to store the history of processed tasks.
 * 3.  Use `java.util.List` interface for the history list variable declaration (`List<Task> history = new ArrayList<>();`).
 * 4.  Use `java.util.Scanner` to read user commands and task details from standard input (`System.in`).
 * 5.  Use a `switch` statement to handle different user commands.
 * 6.  Use `System.err` to print error messages (e.g., invalid command, task processing failure, invalid input).
 * 7.  Use `System.out` to print normal output (e.g., prompts, task added confirmation, processing messages, history list).
 * 8.  Implement class-wide exception handling using `try-catch` blocks to gracefully handle unexpected runtime errors during the program's execution loop. Additionally, use `try-catch` specifically around task execution to handle potential task-specific failures.
 * 9.  Design task types using inheritance or interfaces. Create concrete classes for "File Processing", "Database Query", and "Send Notification" tasks. The `execute()` method for these tasks should print a message indicating processing and *may* randomly throw an exception to simulate failure.
 * 10. Adhere to best practices:
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (Javadoc is a plus).
 *     *   Input validation (e.g., valid command, valid task type).
 *     *   Proper error handling (catch specific exceptions, use `System.err`).
 *     *   Clean code structure (separate concerns into classes and methods).
 * 
 * **Input Format:**
 * 
 * The program should prompt the user for a command. Commands are single words (case-insensitive):
 * *   `ADD`
 * *   `PROCESS_NEXT`
 * *   `PROCESS_ALL`
 * *   `HISTORY`
 * *   `EXIT`
 * 
 * If the command is `ADD`, the program should then prompt for the task type (`FILE`, `DB`, `NOTIFY`) and a description on separate lines.
 * 
 * **Output Format:**
 * 
 * *   Prompts for commands: `Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): `
 * *   Prompts for task details: `Enter task type (FILE, DB, NOTIFY): `, `Enter task description: `
 * *   Task added confirmation: `Task <ID> (<Type>) added to queue.`
 * *   Processing start: `Processing task <ID> (<Type>)...`
 * *   Task completed successfully: `Task <ID> completed successfully.`
 * *   Task failed: `Task <ID> failed: <Error Message>` (printed to `System.err`)
 * *   Queue empty message: `Task queue is empty.`
 * *   History header: `--- Task History ---`
 * *   History entry: `Task <ID> (<Type>): "<Description>" - Status: <Status> (<Details if failed>)`
 * *   Invalid command: `Error: Invalid command. Please try again.` (printed to `System.err`)
 * *   Invalid task type: `Error: Invalid task type. Please use FILE, DB, or NOTIFY.` (printed to `System.err`)
 * *   General unexpected error: `An unexpected error occurred: <Error Message>` (printed to `System.err`)
 * *   Exit message: `Exiting Task Processor. Goodbye!`
 * 
 * **Example Interaction (illustrative):**
 * 
 * ```
 * Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): ADD
 * Enter task type (FILE, DB, NOTIFY): FILE
 * Enter task description: Process report.csv
 * Task 1 (FILE) added to queue.
 * Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): ADD
 * Enter task type (FILE, DB, NOTIFY): DB
 * Enter task description: Update user status
 * Task 2 (DB) added to queue.
 * Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): PROCESS_NEXT
 * Processing task 1 (FILE)...
 * Task 1 completed successfully.
 * Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): HISTORY
 * --- Task History ---
 * Task 1 (FILE): "Process report.csv" - Status: Completed
 * Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): PROCESS_ALL
 * Processing task 2 (DB)...
 * Task 2 completed successfully.
 * Task queue is empty.
 * Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): HISTORY
 * --- Task History ---
 * Task 1 (FILE): "Process report.csv" - Status: Completed
 * Task 2 (DB): "Update user status" - Status: Completed
 * Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): EXIT
 * Exiting Task Processor. Goodbye!
 * ```
 * 
 * **Note:** The random failure simulation means your output might show tasks failing.
 * 
 * Your solution should be a single Java file containing all necessary classes.
 *
 * EXPLANATION:
 * This solution implements a Task Processing System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Task`: An abstract base class defining common properties (id, type, description, status) and the abstract `execute()` method. This promotes code reuse and allows treating different task types polymorphically.
 *     *   `TaskStatus`: An enum to clearly represent the state of a task (PENDING, COMPLETED, FAILED).
 *     *   `TaskExecutionException`: A custom exception class used by tasks to signal specific execution failures.
 *     *   `FileProcessingTask`, `DatabaseQueryTask`, `SendNotificationTask`: Concrete subclasses of `Task`, each implementing the `execute()` method with type-specific behavior and a simulated random chance of throwing `TaskExecutionException`.
 *     *   `TaskProcessor`: The main class containing the application logic. It holds the `Queue` and `List`, manages user interaction via `Scanner`, and orchestrates task processing.
 * 
 * 2.  **Collection Usage:**
 *     *   `Queue<Task> pendingTasksQueue = new LinkedList<>();`: A `LinkedList` is used here as a concrete implementation of the `Queue` interface to store tasks waiting to be processed. `offer()` is used for adding and `poll()` for removing elements, respecting the FIFO (First-In, First-Out) nature of a queue.
 *     *   `List<Task> processedTaskHistory = new ArrayList<>();`: An `ArrayList` is used as a concrete implementation of the `List` interface to store tasks after they have been processed (either successfully or failed). `List` is used for the variable type for good practice, allowing flexibility to change the underlying implementation later if needed. `add()` is used to append tasks to the history.
 * 
 * 3.  **Input/Output and Control Flow:**
 *     *   `Scanner scanner = new Scanner(System.in);`: Used to read user commands and task details from the console.
 *     *   `System.out.println()`: Used for printing prompts, confirmations, processing messages, and the task history to standard output.
 *     *   `System.err.println()`: Used specifically for printing error messages, ensuring they are directed to the standard error stream, which is good practice for separating normal output from errors.
 *     *   `switch (command)`: The main command loop uses a `switch` statement to dispatch execution based on the user's input command (ADD, PROCESS_NEXT, etc.), providing clear and readable control flow. Inner `switch` is also used in `addTask` to create the correct task object based on type.
 * 
 * 4.  **Exception Handling:**
 *     *   **Specific Task Execution Handling:** Inside the `processNextTask()` method, the call `taskToProcess.execute()` is wrapped in a `try-catch (TaskExecutionException e)` block. This specifically catches errors thrown by the task's execution logic, allowing the system to mark the task as failed with the specific reason provided by the exception. A general `catch (Exception e)` is also included to handle any other unexpected runtime errors during execution simulation.
 *     *   **Class-wide Handling:** The `run()` method's main `while(running)` loop is wrapped in a `try-catch (Exception e)` block. This serves as a top-level, class-wide error handler for the core execution flow. If any unhandled exception occurs within the command processing loop (e.g., an issue with Scanner, an unexpected null pointer not caught elsewhere), it will be caught here, preventing the program from crashing abruptly and printing the error to `System.err`. A `finally` block ensures the `Scanner` is closed.
 * 
 * 5.  **Best Practices:**
 *     *   **Encapsulation:** Class fields (`pendingTasksQueue`, `processedTaskHistory`, `id`, `description`, etc.) are declared `private`. Public methods (`run`, `addTask`, `processNextTask`, etc.) provide controlled access to the system's state and functionality. Getters are provided in the `Task` class.
 *     *   **Naming:** Variable names (`pendingTasksQueue`, `processedTaskHistory`, `taskToProcess`, `failureReason`) and method names (`addTask`, `processNextTask`, `viewHistory`, `execute`) are descriptive and follow Java conventions.
 *     *   **Comments:** Javadoc-style comments explain the purpose of classes and methods. Inline comments clarify specific logic points.
 *     *   **Input Validation:** The `addTask` method validates the task type input using a `switch` statement. The `processNextTask` and `processAllTasks` methods check if the queue is empty before attempting to process. The main loop's `switch` handles invalid command inputs with a `default` case and an error message.
 *     *   **Error Handling:** Errors are handled at different levels: specific task execution errors (`TaskExecutionException`), general unexpected task errors, and top-level errors in the main loop. `System.err` is consistently used for error output.
 *     *   **Clean Code:** The code is structured into logical classes and methods, separating concerns (Task definition, Task types, Task processing logic). Methods are relatively short and focused on a single responsibility.
 * 
 * This solution effectively integrates all required components into a functional system, demonstrating advanced concepts like polymorphism, custom exceptions, and layered error handling within a practical simulation.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// Abstract base class for tasks
abstract class Task {
    private static int nextId = 1;
    private int id;
    private String type;
    private String description;
    private TaskStatus status;
    private String failureReason;

    public Task(String type, String description) {
        this.id = nextId++;
        this.type = type;
        this.description = description;
        this.status = TaskStatus.PENDING; // Initially pending
    }

    // Abstract method to be implemented by concrete task types
    public abstract void execute() throws TaskExecutionException;

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    // Setters for status
    public void setCompleted() {
        this.status = TaskStatus.COMPLETED;
        this.failureReason = null; // Clear failure reason on completion
    }

    public void setFailed(String reason) {
        this.status = TaskStatus.FAILED;
        this.failureReason = reason;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Task ").append(id).append(" (").append(type).append("): \"").append(description).append("\" - Status: ").append(status);
        if (status == TaskStatus.FAILED && failureReason != null) {
            sb.append(" (").append(failureReason).append(")");
        }
        return sb.toString();
    }
}

// Enum for task status
enum TaskStatus {
    PENDING,
    COMPLETED,
    FAILED
}

// Custom exception for task execution errors
class TaskExecutionException extends Exception {
    public TaskExecutionException(String message) {
        super(message);
    }
}

// Concrete Task Type: File Processing
class FileProcessingTask extends Task {
    private static final Random random = new Random();

    public FileProcessingTask(String description) {
        super("FILE", description);
    }

    @Override
    public void execute() throws TaskExecutionException {
        System.out.println("Executing File Processing task: " + getDescription());
        // Simulate work and potential failure
        if (random.nextDouble() < 0.2) { // 20% chance of failure
            throw new TaskExecutionException("Simulated file access error.");
        }
        // Simulate successful completion
        try {
            Thread.sleep(100); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TaskExecutionException("File processing interrupted.");
        }
    }
}

// Concrete Task Type: Database Query
class DatabaseQueryTask extends Task {
    private static final Random random = new Random();

    public DatabaseQueryTask(String description) {
        super("DB", description);
    }

    @Override
    public void execute() throws TaskExecutionException {
        System.out.println("Executing Database Query task: " + getDescription());
        // Simulate work and potential failure
         if (random.nextDouble() < 0.3) { // 30% chance of failure
            throw new TaskExecutionException("Simulated database connection error.");
        }
        // Simulate successful completion
         try {
            Thread.sleep(150); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TaskExecutionException("Database query interrupted.");
        }
    }
}

// Concrete Task Type: Send Notification
class SendNotificationTask extends Task {
     private static final Random random = new Random();

    public SendNotificationTask(String description) {
        super("NOTIFY", description);
    }

    @Override
    public void execute() throws TaskExecutionException {
        System.out.println("Executing Send Notification task: " + getDescription());
        // Simulate work and potential failure
         if (random.nextDouble() < 0.1) { // 10% chance of failure
            throw new TaskExecutionException("Simulated network error sending notification.");
        }
        // Simulate successful completion
         try {
            Thread.sleep(50); // Simulate processing time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TaskExecutionException("Notification sending interrupted.");
        }
    }
}


// Main class managing the task processing system
public class TaskProcessor {

    private Queue<Task> pendingTasksQueue;
    private List<Task> processedTaskHistory; // Using List interface, implemented by ArrayList
    private Scanner scanner;
    private boolean running;

    public TaskProcessor() {
        this.pendingTasksQueue = new LinkedList<>(); // LinkedList implements Queue
        this.processedTaskHistory = new ArrayList<>(); // ArrayList implements List
        this.scanner = new Scanner(System.in);
        this.running = true;
    }

    /**
     * Runs the main loop of the Task Processor system.
     * Includes class-wide exception handling.
     */
    public void run() {
        System.out.println("Task Processor System started.");

        // Class-wide try-catch for the main execution loop
        try {
            while (running) {
                System.out.print("Enter command (ADD, PROCESS_NEXT, PROCESS_ALL, HISTORY, EXIT): ");
                String command = scanner.nextLine().trim().toUpperCase();

                // Use switch for command handling
                switch (command) {
                    case "ADD":
                        addTask();
                        break;
                    case "PROCESS_NEXT":
                        processNextTask();
                        break;
                    case "PROCESS_ALL":
                        processAllTasks();
                        break;
                    case "HISTORY":
                        viewHistory();
                        break;
                    case "EXIT":
                        running = false;
                        System.out.println("Exiting Task Processor. Goodbye!");
                        break;
                    default:
                        // Error for invalid command
                        System.err.println("Error: Invalid command. Please try again.");
                        break;
                }
                System.out.println(); // Add a blank line for readability
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions during the main loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
             // Ensure scanner is closed even if an exception occurs
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Task Processor System stopped.");
        }
    }

    /**
     * Handles adding a new task based on user input.
     */
    private void addTask() {
        System.out.print("Enter task type (FILE, DB, NOTIFY): ");
        String type = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();

        Task newTask = null;
        // Use switch to create the correct task type
        switch (type) {
            case "FILE":
                newTask = new FileProcessingTask(description);
                break;
            case "DB":
                newTask = new DatabaseQueryTask(description);
                break;
            case "NOTIFY":
                newTask = new SendNotificationTask(description);
                break;
            default:
                // Error for invalid task type
                System.err.println("Error: Invalid task type. Please use FILE, DB, or NOTIFY.");
                return; // Exit method if type is invalid
        }

        pendingTasksQueue.offer(newTask); // Add task to the queue
        System.out.println("Task " + newTask.getId() + " (" + newTask.getType() + ") added to queue.");
    }

    /**
     * Processes the next task from the queue.
     * Includes specific try-catch for task execution.
     */
    private void processNextTask() {
        Task taskToProcess = pendingTasksQueue.poll(); // Get and remove task from queue

        if (taskToProcess == null) {
            // Message if queue is empty
            System.out.println("Task queue is empty.");
            return;
        }

        System.out.println("Processing task " + taskToProcess.getId() + " (" + taskToProcess.getType() + ")...");

        // Specific try-catch block for task execution
        try {
            taskToProcess.execute(); // Execute the task
            taskToProcess.setCompleted(); // Mark as completed on success
            System.out.println("Task " + taskToProcess.getId() + " completed successfully.");
        } catch (TaskExecutionException e) {
            // Catch specific task execution failures
            taskToProcess.setFailed(e.getMessage()); // Mark as failed with reason
            System.err.println("Task " + taskToProcess.getId() + " failed: " + e.getMessage()); // Print error to System.err
        } catch (Exception e) {
             // Catch any other unexpected exceptions during execution
             taskToProcess.setFailed("Unexpected error: " + e.getMessage());
             System.err.println("Task " + taskToProcess.getId() + " failed with unexpected error: " + e.getMessage());
             e.printStackTrace(System.err); // Print stack trace for debugging
        } finally {
            // Ensure task is added to history regardless of success or failure
            processedTaskHistory.add(taskToProcess);
        }
    }

    /**
     * Processes all tasks currently in the queue.
     */
    private void processAllTasks() {
        if (pendingTasksQueue.isEmpty()) {
            System.out.println("Task queue is already empty.");
            return;
        }
        System.out.println("Processing all pending tasks...");
        // Loop and process until the queue is empty
        while (!pendingTasksQueue.isEmpty()) {
            processNextTask(); // Calls the method with specific error handling
        }
        System.out.println("Finished processing all pending tasks.");
    }

    /**
     * Displays the history of processed tasks.
     */
    private void viewHistory() {
        System.out.println("--- Task History ---");
        if (processedTaskHistory.isEmpty()) {
            System.out.println("No tasks have been processed yet.");
        } else {
            // Iterate through the history list and print details
            for (Task task : processedTaskHistory) {
                System.out.println(task); // Task's toString() method provides formatted output
            }
        }
        System.out.println("--------------------");
    }

    // Main method to start the application
    public static void main(String[] args) {
        TaskProcessor processor = new TaskProcessor();
        processor.run(); // Start the main processing loop
    }
}
