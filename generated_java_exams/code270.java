/*
 * Exam Question #270
 * Generated on: 2025-05-11 22:47:32
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam: Service Desk Task Manager
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified Service Desk application. This application manages incoming service requests (tasks) that need to be processed. Requests are handled in the order they are received (First-In, First-Out), but the system also needs to keep a record of completed tasks. The application should be interactive, allowing a user (the service desk agent) to add new tasks, process the next pending task, and view lists of both pending and completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following private fields:
 *     *   `int id`: A unique identifier for the task.
 *     *   `String description`: A brief description of the task.
 *     *   `String type`: The type of service request (e.g., "Software Issue", "Hardware Request", "Network Problem").
 *     *   `String status`: The current status (e.g., "PENDING", "COMPLETED").
 *     *   Include a constructor, public getter methods for all fields, and a meaningful `toString()` method.
 * 
 * 2.  **Task Management:** Create a `TaskManager` class that encapsulates the logic for managing tasks. This class must use:
 *     *   A `java.util.Queue<Task>` to store pending tasks. Tasks should be added to the queue and processed from the head of the queue.
 *     *   A `java.util.List<Task>` (instantiated as `java.util.ArrayList<Task>`) to store completed tasks.
 *     *   Implement the following public methods:
 *         *   `addTask(String description, String type)`: Creates a new `Task` with a unique ID, sets its status to "PENDING", and adds it to the pending tasks queue.
 *         *   `processNextTask()`: Retrieves and removes the next task from the pending queue, updates its status to "COMPLETED", and adds it to the completed tasks list. If the queue is empty, it should indicate an error.
 *         *   `listPendingTasks()`: Returns a `List<Task>` containing all tasks currently in the pending queue.
 *         *   `listCompletedTasks()`: Returns the `List<Task>` containing all completed tasks.
 * 
 * 3.  **User Interface:** Create a main application class (e.g., `ServiceDeskApp`) with a `main` method that provides a command-line interface using `java.util.Scanner`.
 *     *   Display a menu of options: "add", "process", "list pending", "list completed", "exit".
 *     *   Use a `switch` statement to handle user input and call the appropriate methods on the `TaskManager`.
 *     *   Prompt the user for necessary input (description, type) when adding a task.
 *     *   Use `System.out` for displaying the menu, task details, and success messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid command, attempting to process an empty queue).
 * 
 * 4.  **Error Handling:**
 *     *   Implement input validation for user commands (handle invalid menu options).
 *     *   Implement error handling in `processNextTask()` when the pending queue is empty. This should be clearly communicated to the user via `System.err`.
 *     *   Implement class-wide exception handling using a `try-catch` block in the `main` method to gracefully handle unexpected errors during the program's execution (e.g., issues with Scanner input parsing, although using `nextLine()` followed by parsing is safer). The `try-catch` should ideally wrap the main interaction loop.
 * 
 * 5.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and JavaDocs.
 *     *   Ensure proper encapsulation in the `Task` and `TaskManager` classes.
 *     *   Structure the code logically into classes.
 *     *   Close the `Scanner` resource when the application exits.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively. Example flow:
 * 
 * ```
 * Service Desk Task Manager
 * Menu: add, process, list pending, list completed, exit
 * Enter command: add
 * Enter task description: Fix printer in room 101
 * Enter task type: Hardware Request
 * Task 1 added: Fix printer in room 101 (Hardware Request)
 * 
 * Enter command: add
 * Enter task description: Install software on new laptop
 * Enter task type: Software Issue
 * Task 2 added: Install software on new laptop (Software Issue)
 * 
 * Enter command: list pending
 * Pending Tasks:
 * Task ID: 1, Description: Fix printer in room 101, Type: Hardware Request, Status: PENDING
 * Task ID: 2, Description: Install software on new laptop, Type: Software Issue, Status: PENDING
 * 
 * Enter command: process
 * Processing task: Task ID: 1, Description: Fix printer in room 101, Type: Hardware Request, Status: PENDING
 * Task 1 completed.
 * 
 * Enter command: list pending
 * Pending Tasks:
 * Task ID: 2, Description: Install software on new laptop, Type: Software Issue, Status: PENDING
 * 
 * Enter command: list completed
 * Completed Tasks:
 * Task ID: 1, Description: Fix printer in room 101, Type: Hardware Request, Status: COMPLETED
 * 
 * Enter command: process
 * Processing task: Task ID: 2, Description: Install software on new laptop, Type: Software Issue, Status: PENDING
 * Task 2 completed.
 * 
 * Enter command: process
 * Error: No tasks in the pending queue to process.
 * 
 * Enter command: exit
 * Exiting Service Desk Task Manager. Goodbye!
 * ```
 * 
 * **Note:** The unique task ID should be automatically generated by the `TaskManager`.
 *
 * EXPLANATION:
 * The solution implements a simple Service Desk Task Manager application demonstrating the required Java concepts.
 * 
 * 1.  **`Task` Class:** This class serves as a simple Plain Old Java Object (POJO) representing a task. It has private fields (`id`, `description`, `type`, `status`) to enforce encapsulation. Public getter methods provide access to the task's data, and a `setStatus` method allows controlled modification of the status. The `toString()` method provides a convenient way to print task details.
 * 
 * 2.  **`TaskManager` Class:** This is the core logic class.
 *     *   It uses a `java.util.Queue<Task>` (`pendingTasks`) implemented by `java.util.LinkedList` to manage tasks awaiting processing. The Queue interface guarantees FIFO behavior, which is appropriate for processing tasks in the order they are received. `offer()` is used for adding, and `poll()` for retrieving and removing the head.
 *     *   It uses a `java.util.List<Task>` (`completedTasks`) implemented by `java.util.ArrayList` to store tasks after they have been processed. The List interface provides ordered storage and easy iteration over completed tasks.
 *     *   `addTask`: Creates a new `Task` instance, assigns a unique ID using `nextTaskId++`, sets the initial status to "PENDING", and adds it to the `pendingTasks` queue using `offer()`. Includes basic validation for description and type.
 *     *   `processNextTask`: Checks if the `pendingTasks` queue is empty. If not, it uses `poll()` to get the next task, updates its status to "COMPLETED", and adds it to the `completedTasks` list using `add()`. If the queue *is* empty, it throws a custom `EmptyQueueException`.
 *     *   `listPendingTasks`: Returns a `List` view of the current items in the `pendingTasks` queue. A new `ArrayList` is created from the queue to avoid exposing the internal queue structure directly, adhering to good practice.
 *     *   `listCompletedTasks`: Returns the `completedTasks` `List`.
 * 
 * 3.  **`ServiceDeskApp` Class:** This is the main entry point of the application.
 *     *   It creates instances of `TaskManager` and `Scanner`.
 *     *   The main application loop runs within a `try-catch` block, fulfilling the requirement for class-wide exception handling. This block catches `Exception`, providing a basic level of robustness against unexpected runtime issues.
 *     *   Inside the loop, a menu is displayed using `System.out`.
 *     *   `scanner.nextLine()` reads the user's command. Using `nextLine()` is generally safer than `nextInt()` or `nextDouble()` when mixing line-based and token-based input, as it consumes the entire line, preventing leftover newline characters from causing issues in subsequent reads. The input is trimmed and converted to lowercase for easier comparison.
 *     *   A `switch` statement is used to direct control based on the user's command. This fulfills the `switch` requirement.
 *     *   Each case calls the appropriate `TaskManager` method.
 *     *   The "process" case specifically includes a nested `try-catch` block to handle the `EmptyQueueException` thrown by `processNextTask()`, printing the error message to `System.err` as required.
 *     *   The "list pending" and "list completed" cases retrieve the respective `List` from the `TaskManager` and iterate through it, printing task details using `System.out`. The use of `List<Task>` for the return type and iteration fulfills the `List` interface requirement.
 *     *   The `default` case in the `switch` handles invalid commands, printing an error message to `System.err`.
 *     *   The `exit` command sets a flag to terminate the loop.
 *     *   A `finally` block is used to ensure the `Scanner` resource is closed properly, releasing system resources.
 * 
 * **Demonstrated Concepts:**
 * 
 * *   **Object-Oriented Programming:** Using classes (`Task`, `TaskManager`, `ServiceDeskApp`) with encapsulation (private fields, public methods).
 * *   **Data Structures:** Practical application of `Queue` (FIFO for pending tasks) and `List` (ordered storage for completed tasks), using `LinkedList` and `ArrayList` implementations respectively.
 * *   **Interfaces:** Using the `List` interface type for variables and method return types (`List<Task> pending`, `List<Task> completed`, `listPendingTasks()` returning `List<Task>`).
 * *   **User Input:** Reading input from the console using `Scanner`.
 * *   **Control Flow:** Using a `switch` statement for multi-way branching based on user command. Using a `while` loop for continuous operation.
 * *   **Input/Output:** Using `System.out` for standard information and `System.err` for error messages.
 * *   **Error Handling:** Implementing input validation (basic checks in `addTask`, invalid command handling in `switch`), specific error handling for an empty queue using a custom exception and a `try-catch`, and a general `try-catch` wrapping the main execution loop for robustness.
 * *   **Best Practices:** Meaningful names, comments/JavaDocs, resource management (closing `Scanner`).
 * 
 * This solution effectively integrates all the required components into a cohesive, practical application, demonstrating intermediate to advanced Java programming skills.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Represents a single service task
class Task {
    private final int id;
    private final String description;
    private final String type;
    private String status; // Status can change

    /**
     * Constructs a new Task.
     * @param id The unique ID of the task.
     * @param description The description of the task.
     * @param type The type of the task.
     */
    public Task(int id, String description, String type) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.status = "PENDING"; // Default status
    }

    // --- Getters ---
    public int getId() {
        return id;
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

    // --- Setter (only for status change) ---
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Task.
     * @return A formatted string showing task details.
     */
    @Override
    public String toString() {
        return String.format("Task ID: %d, Description: %s, Type: %s, Status: %s",
                             id, description, type, status);
    }
}

// Manages the collection of tasks, using a Queue for pending and a List for completed.
class TaskManager {
    // Queue to hold tasks waiting to be processed (FIFO)
    private Queue<Task> pendingTasks;
    // List to hold tasks that have been completed
    private List<Task> completedTasks;
    // Counter for generating unique task IDs
    private int nextTaskId;

    /**
     * Constructs a new TaskManager, initializing the task collections.
     */
    public TaskManager() {
        // Use LinkedList as an implementation of Queue for FIFO behavior
        this.pendingTasks = new LinkedList<>();
        // Use ArrayList as an implementation of List for storing completed tasks
        this.completedTasks = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the pending queue.
     * @param description The description of the task.
     * @param type The type of the task.
     */
    public void addTask(String description, String type) {
        // Basic validation
        if (description == null || description.trim().isEmpty() || type == null || type.trim().isEmpty()) {
             System.err.println("Error: Task description and type cannot be empty.");
             return; // Do not add task if invalid
        }
        Task newTask = new Task(nextTaskId++, description.trim(), type.trim());
        pendingTasks.offer(newTask); // offer() is generally preferred over add() for queues as it returns false instead of throwing exception if capacity limited (not an issue here)
        System.out.println("Task " + newTask.getId() + " added: " + newTask.getDescription() + " (" + newTask.getType() + ")");
    }

    /**
     * Processes the next task in the pending queue.
     * Moves the task from the pending queue to the completed list.
     * @throws EmptyQueueException if there are no tasks in the pending queue.
     */
    public void processNextTask() throws EmptyQueueException {
        // Check if the queue is empty before attempting to poll
        if (pendingTasks.isEmpty()) {
            // Throw a custom exception or a standard one, or handle internally
            // Let's use a custom message output via System.err as per requirement 3 & 4
            // Or throw an exception to be caught by the caller (main method)
            // Let's throw a custom exception for better structure
            throw new EmptyQueueException("No tasks in the pending queue to process.");
        }

        Task taskToProcess = pendingTasks.poll(); // Retrieve and remove the head of the queue
        System.out.println("Processing task: " + taskToProcess);
        taskToProcess.setStatus("COMPLETED"); // Update status
        completedTasks.add(taskToProcess); // Add to completed list
        System.out.println("Task " + taskToProcess.getId() + " completed.");
    }

    /**
     * Returns a list of tasks currently in the pending queue.
     * Note: Returns a new ArrayList to prevent external modification of the internal queue.
     * @return A List of pending tasks.
     */
    public List<Task> listPendingTasks() {
        // Return a copy to protect the internal queue state
        return new ArrayList<>(pendingTasks);
    }

    /**
     * Returns a list of completed tasks.
     * @return A List of completed tasks.
     */
    public List<Task> listCompletedTasks() {
        // Returning the internal list is acceptable here as it's a record,
        // but returning a copy is often safer depending on requirements.
        // For this exam, returning the internal list is fine.
        return completedTasks;
    }
}

// Custom exception for demonstrating exception handling when queue is empty
class EmptyQueueException extends Exception {
    public EmptyQueueException(String message) {
        super(message);
    }
}

// Main application class with user interface and exception handling
public class ServiceDeskApp {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Service Desk Task Manager");

        // Class-wide exception handling wrapping the main execution loop
        try {
            while (running) {
                System.out.println("\nMenu: add, process, list pending, list completed, exit");
                System.out.print("Enter command: ");
                String command = scanner.nextLine().trim().toLowerCase(); // Read command and normalize

                // Use switch statement for command handling
                switch (command) {
                    case "add":
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter task type: ");
                        String type = scanner.nextLine();
                        manager.addTask(description, type); // Validation is inside TaskManager
                        break;

                    case "process":
                        try {
                            manager.processNextTask();
                        } catch (EmptyQueueException e) {
                            // Catch the specific exception thrown by TaskManager
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case "list pending":
                        List<Task> pending = manager.listPendingTasks(); // Get the list of pending tasks
                        System.out.println("Pending Tasks:");
                        if (pending.isEmpty()) {
                            System.out.println("No pending tasks.");
                        } else {
                            // Iterate and print using List interface methods
                            for (Task task : pending) {
                                System.out.println(task); // Task's toString() is used here
                            }
                        }
                        break;

                    case "list completed":
                        List<Task> completed = manager.listCompletedTasks(); // Get the list of completed tasks
                        System.out.println("Completed Tasks:");
                        if (completed.isEmpty()) {
                            System.out.println("No completed tasks.");
                        } else {
                            // Iterate and print using List interface methods
                            for (Task task : completed) {
                                System.out.println(task); // Task's toString() is used here
                            }
                        }
                        break;

                    case "exit":
                        running = false; // Set flag to exit loop
                        System.out.println("Exiting Service Desk Task Manager. Goodbye!");
                        break;

                    default:
                        // Handle invalid commands
                        System.err.println("Error: Invalid command. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions during execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging in exam context
        } finally {
            // Ensure scanner is closed regardless of how the try block exits
            scanner.close();
            System.out.println("Scanner closed."); // Optional: Confirmation
        }
    }
}
