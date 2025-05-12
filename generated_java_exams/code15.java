/*
 * Exam Question #15
 * Generated on: 2025-05-11 21:34:54
 * 
 * QUESTION:
 * **Advanced Java Programming Exam: Help Desk Task Processor**
 * 
 * **Problem Description:**
 * 
 * Design and implement a Java application that simulates a basic Help Desk Task Processor. The system should allow users to add new support tasks (tickets) to a queue, process the next task in the queue, and view the status of pending and processed tasks.
 * 
 * Your solution must demonstrate advanced Java programming concepts and utilize specific components as listed below.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following private fields:
 *     *   `taskId` (String): A unique identifier for the task.
 *     *   `description` (String): A brief description of the task.
 *     *   `type` (String): The type of task (e.g., "BUG", "FEATURE_REQUEST", "SUPPORT").
 *     *   `status` (String): The current status of the task (e.g., "PENDING", "PROCESSING", "COMPLETED", "FAILED").
 *     *   Include a constructor, public getter methods for all fields, and a method `updateStatus(String newStatus)` to change the task's status. Override the `toString()` method for easy printing of task details.
 * 
 * 2.  **Task Processor Logic:** Create a `TaskProcessor` class with the following functionalities:
 *     *   Use a `java.util.Queue<Task>` (specifically, you can use `LinkedList` which implements `Queue`) to hold tasks that are waiting to be processed.
 *     *   Use a `java.util.List<Task>` (specifically, use `java.util.ArrayList` and declare it as `List<Task>`) to store tasks that have been processed.
 *     *   Implement a method `addTask(String taskId, String description, String type)`:
 *         *   Validate that `taskId`, `description`, and `type` are not null or empty.
 *         *   Validate that `type` is one of the allowed types ("BUG", "FEATURE_REQUEST", "SUPPORT"). If not, throw an `IllegalArgumentException` or print an error.
 *         *   Create a new `Task` object with initial status "PENDING".
 *         *   Add the new task to the task queue.
 *         *   Print a success message using `System.out`.
 *     *   Implement a method `processNextTask()`:
 *         *   Attempt to retrieve and remove the next task from the queue.
 *         *   If the queue is empty, print an error message to `System.err` and return.
 *         *   If a task is retrieved, update its status to "PROCESSING" (or "COMPLETED" directly for simplicity in this simulation).
 *         *   Add the processed task to the list of processed tasks.
 *         *   Print a success message using `System.out`.
 *     *   Implement a method `viewPendingTasks()`:
 *         *   Print the details of all tasks currently in the queue. If the queue is empty, print a message indicating so. Use `System.out`.
 *     *   Implement a method `viewProcessedTasks()`:
 *         *   Print the details of all tasks in the processed tasks list. If the list is empty, print a message indicating so. Use `System.out`.
 * 
 * 3.  **User Interface (Main Application):**
 *     *   In your `main` method (or a dedicated application class), use a `java.util.Scanner` to get user input from the console.
 *     *   Implement a loop that continuously prompts the user for commands: `add`, `process`, `view_pending`, `view_processed`, `exit`.
 *     *   Use a `switch` statement to handle the different user commands.
 *     *   For the `add` command, prompt the user for the task ID, description, and type.
 *     *   For the `process`, `view_pending`, `view_processed`, and `exit` commands, simply call the corresponding methods in the `TaskProcessor`.
 *     *   Handle invalid commands by printing an error message to `System.err`.
 *     *   Implement class-wide exception handling using `try-catch` blocks within the main application loop to catch potential errors (e.g., `IllegalArgumentException` from `addTask`, or unexpected runtime errors) and print informative error messages to `System.err`.
 * 
 * 4.  **Constraints & Best Practices:**
 *     *   Use `java.util.Queue`, `java.util.ArrayList`, `java.util.List`, `java.util.Scanner`, `switch`, `System.err`, `System.out`.
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadoc is a plus).
 *     *   Implement input validation for task creation.
 *     *   Handle errors gracefully using `System.err` and `try-catch`.
 *     *   Ensure clean code structure.
 * 
 * **Expected Output:**
 * 
 * The application should provide clear prompts for user input and print informative messages indicating the result of each operation (task added, task processed, queue status, processed tasks list). Error messages (e.g., invalid input, processing empty queue) should be printed to standard error (`System.err`).
 * 
 * Example interaction flow:
 * 
 * ```
 * Enter command (add, process, view_pending, view_processed, exit): add
 * Enter Task ID: T001
 * Enter Description: User cannot login
 * Enter Type (BUG, FEATURE_REQUEST, SUPPORT): SUPPORT
 * Task T001 added to the queue.
 * 
 * Enter command (add, process, view_pending, view_processed, exit): add
 * Enter Task ID: T002
 * Enter Description: Implement dark mode
 * Enter Type (BUG, FEATURE_REQUEST, SUPPORT): FEATURE_REQUEST
 * Task T002 added to the queue.
 * 
 * Enter command (add, process, view_pending, view_processed, exit): view_pending
 * Pending Tasks:
 * Task{taskId='T001', description='User cannot login', type='SUPPORT', status='PENDING'}
 * Task{taskId='T002', description='Implement dark mode', type='FEATURE_REQUEST', status='PENDING'}
 * 
 * Enter command (add, process, view_pending, view_processed, exit): process
 * Processing task: Task{taskId='T001', description='User cannot login', type='SUPPORT', status='COMPLETED'}
 * Task T001 processed and moved to completed list.
 * 
 * Enter command (add, process, view_pending, view_processed, exit): view_processed
 * Processed Tasks:
 * Task{taskId='T001', description='User cannot login', type='SUPPORT', status='COMPLETED'}
 * 
 * Enter command (add, process, view_pending, view_processed, exit): process
 * Processing task: Task{taskId='T002', description='Implement dark mode', type='FEATURE_REQUEST', status='COMPLETED'}
 * Task T002 processed and moved to completed list.
 * 
 * Enter command (add, process, view_pending, view_processed, exit): process
 * Error: The task queue is empty. No task to process.
 * 
 * Enter command (add, process, view_pending, view_processed, exit): exit
 * Exiting Task Processor.
 * ```
 * 
 * **Grading Criteria:**
 * 
 * *   Correct usage of all specified Java components.
 * *   Correct implementation of `Task` and `TaskProcessor` classes with proper encapsulation.
 * *   Accurate logic for adding, processing, and viewing tasks.
 * *   Effective use of `switch` for command handling.
 * *   Robust input validation and error handling using `try-catch` and `System.err`.
 * *   Clear and informative output using `System.out`.
 * *   Adherence to best practices (naming, comments, code structure).
 *
 * EXPLANATION:
 * This solution implements a simple Help Desk Task Processor system using the required Java components and best practices.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents a single task with `taskId`, `description`, `type`, and `status`.
 *     *   Fields are `private` for encapsulation.
 *     *   Public getter methods provide controlled access to task data.
 *     *   The constructor includes basic input validation for task details, throwing `IllegalArgumentException` for invalid inputs. This demonstrates responsible data handling at the object creation level.
 *     *   `updateStatus` method allows changing the task's state.
 *     *   `toString()` provides a convenient way to print task details.
 * 
 * 2.  **`TaskProcessor` Class:**
 *     *   Manages the collection of tasks using a `Queue<Task>` (`taskQueue`) for pending tasks and a `List<Task>` (`processedTasks`) for completed tasks. `LinkedList` is used as a concrete implementation of `Queue`, and `ArrayList` for `List`.
 *     *   `addTask`: Creates a new `Task` object (leveraging the `Task` class's validation) and adds it to the `taskQueue` using `offer()`. `offer()` is preferred over `add()` for bounded queues as it doesn't throw an exception if the queue is full, but for the unbounded `LinkedList`, both work similarly.
 *     *   `processNextTask`: Uses `poll()` to retrieve and remove the head of the `taskQueue`. `poll()` returns `null` if the queue is empty, which is handled gracefully by printing an error to `System.err`. If a task is retrieved, its status is updated, and it's added to the `processedTasks` list.
 *     *   `viewPendingTasks`: Iterates through the `taskQueue` (without removing elements) to print pending tasks. Checks for emptiness first.
 *     *   `viewProcessedTasks`: Iterates through the `processedTasks` list to print completed tasks. Checks for emptiness first.
 *     *   All methods use `System.out` for normal output and `System.err` for errors (like trying to process an empty queue).
 * 
 * 3.  **`HelpDeskApp` Class (Main Application):**
 *     *   The `main` method orchestrates the application flow.
 *     *   A `Scanner` is used to read user commands and input from `System.in`.
 *     *   A `while` loop keeps the application running until the user chooses to `exit`.
 *     *   A `switch` statement efficiently handles the different user commands (`add`, `process`, `view_pending`, `view_processed`, `exit`).
 *     *   Input validation for the `add` command is delegated to the `Task` constructor and the `TaskProcessor.addTask` method, with `try-catch` blocks specifically around calls that might throw `IllegalArgumentException`.
 *     *   A broad `try-catch` block wraps the main processing loop. This demonstrates class-wide exception handling, catching any unexpected `Exception` that might occur during the application's execution and preventing the program from crashing abruptly. Error messages from these catches are printed to `System.err`.
 *     *   A `finally` block ensures the `Scanner` is closed when the application terminates, releasing system resources.
 * 
 * This solution effectively integrates `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch` blocks within a structured, object-oriented design that simulates a practical scenario. It emphasizes input validation, error handling, and clean code principles.
 */

import java.util.Queue;
import java.util.LinkedList; // Common Queue implementation
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

// Represents a single task in the system
class Task {
    private String taskId;
    private String description;
    private String type; // e.g., BUG, FEATURE_REQUEST, SUPPORT
    private String status; // e.g., PENDING, PROCESSING, COMPLETED, FAILED

    // Allowed task types
    private static final List<String> ALLOWED_TYPES = Arrays.asList("BUG", "FEATURE_REQUEST", "SUPPORT");

    /**
     * Constructs a new Task.
     *
     * @param taskId The unique identifier for the task.
     * @param description A brief description of the task.
     * @param type The type of task. Must be one of ALLOWED_TYPES.
     * @throws IllegalArgumentException if taskId, description, or type are invalid.
     */
    public Task(String taskId, String description, String type) {
        if (taskId == null || taskId.trim().isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty.");
        }
        if (type == null || type.trim().isEmpty() || !ALLOWED_TYPES.contains(type.toUpperCase())) {
            throw new IllegalArgumentException("Invalid task type: " + type + ". Allowed types are: " + ALLOWED_TYPES);
        }

        this.taskId = taskId.trim();
        this.description = description.trim();
        this.type = type.trim().toUpperCase();
        this.status = "PENDING"; // Initial status
    }

    // --- Getters ---
    public String getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the task.
     *
     * @param newStatus The new status.
     */
    public void updateStatus(String newStatus) {
        if (newStatus != null && !newStatus.trim().isEmpty()) {
            this.status = newStatus.trim().toUpperCase();
        } else {
            System.err.println("Warning: Attempted to set null or empty status for task " + taskId);
        }
    }

    @Override
    public String toString() {
        return "Task{" +
               "taskId='" + taskId + '\'' +
               ", description='" + description + '\'' +
               ", type='" + type + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}

// Manages the queue and processing of tasks
class TaskProcessor {
    // Queue for tasks waiting to be processed
    private Queue<Task> taskQueue;
    // List for tasks that have been processed
    private List<Task> processedTasks;

    /**
     * Constructs a new TaskProcessor.
     */
    public TaskProcessor() {
        this.taskQueue = new LinkedList<>(); // LinkedList implements Queue
        this.processedTasks = new ArrayList<>(); // ArrayList implements List
    }

    /**
     * Adds a new task to the processing queue.
     *
     * @param taskId The ID of the task.
     * @param description The description of the task.
     * @param type The type of the task.
     * @throws IllegalArgumentException if task details are invalid.
     */
    public void addTask(String taskId, String description, String type) {
        // Task constructor handles validation and throws IllegalArgumentException
        Task newTask = new Task(taskId, description, type);
        taskQueue.offer(newTask); // offer is safer than add, returns false on failure but queue is unbounded
        System.out.println("Task " + taskId + " added to the queue.");
    }

    /**
     * Processes the next task in the queue.
     */
    public void processNextTask() {
        Task taskToProcess = taskQueue.poll(); // Retrieve and remove the head of the queue

        if (taskToProcess == null) {
            System.err.println("Error: The task queue is empty. No task to process.");
            return;
        }

        // Simulate processing - update status
        System.out.println("Processing task: " + taskToProcess);
        taskToProcess.updateStatus("COMPLETED"); // For simplicity, directly mark as completed

        processedTasks.add(taskToProcess); // Add to the list of processed tasks
        System.out.println("Task " + taskToProcess.getTaskId() + " processed and moved to completed list.");
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    public void viewPendingTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("The task queue is empty.");
            return;
        }

        System.out.println("Pending Tasks:");
        // Iterate without removing elements
        for (Task task : taskQueue) {
            System.out.println(task);
        }
    }

    /**
     * Displays all tasks that have been processed.
     */
    public void viewProcessedTasks() {
        if (processedTasks.isEmpty()) {
            System.out.println("No tasks have been processed yet.");
            return;
        }

        System.out.println("Processed Tasks:");
        for (Task task : processedTasks) {
            System.out.println(task);
        }
    }
}

// Main application class to handle user interaction
public class HelpDeskApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskProcessor processor = new TaskProcessor();
        boolean running = true;

        System.out.println("--- Help Desk Task Processor ---");

        // Class-wide exception handling for the main application loop
        try {
            while (running) {
                System.out.print("\nEnter command (add, process, view_pending, view_processed, exit): ");
                String command = scanner.nextLine().trim().toLowerCase();

                switch (command) {
                    case "add":
                        System.out.print("Enter Task ID: ");
                        String id = scanner.nextLine().trim();
                        System.out.print("Enter Description: ");
                        String description = scanner.nextLine().trim();
                        System.out.print("Enter Type (BUG, FEATURE_REQUEST, SUPPORT): ");
                        String type = scanner.nextLine().trim();
                        try {
                            processor.addTask(id, description, type);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Input Error: " + e.getMessage());
                        } catch (Exception e) {
                             System.err.println("An unexpected error occurred while adding task: " + e.getMessage());
                        }
                        break;

                    case "process":
                         try {
                            processor.processNextTask();
                         } catch (Exception e) {
                             System.err.println("An unexpected error occurred while processing task: " + e.getMessage());
                         }
                        break;

                    case "view_pending":
                        processor.viewPendingTasks();
                        break;

                    case "view_processed":
                        processor.viewProcessedTasks();
                        break;

                    case "exit":
                        running = false;
                        System.out.println("Exiting Task Processor.");
                        break;

                    default:
                        System.err.println("Unknown command. Please use add, process, view_pending, view_processed, or exit.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exception not handled elsewhere
            System.err.println("An unexpected fatal error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging unexpected errors
        } finally {
            scanner.close(); // Close the scanner when the application exits
        }
    }
}
