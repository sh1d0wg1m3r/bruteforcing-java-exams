/*
 * Exam Question #56
 * Generated on: 2025-05-11 22:06:28
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Simple Task Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple command-line Task Management System for a small team. The system should allow users to add new tasks, complete the oldest pending task, view pending tasks, and view completed tasks.
 * 
 * Tasks should be processed in a First-In, First-Out (FIFO) manner. Completed tasks should be archived.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to store tasks that are pending completion.
 *     *   Use a `java.util.ArrayList` to store tasks that have been completed.
 *     *   Declare the completed tasks storage using the `java.util.List` interface type.
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user commands from the console (`System.in`).
 *     *   The system should accept the following commands (case-insensitive, but output should be consistent):
 *         *   `add <description>`: Adds a new task with the given description to the pending queue.
 *         *   `complete`: Marks the oldest pending task as completed and moves it from the pending queue to the completed list.
 *         *   `view pending`: Displays all tasks currently in the pending queue, in the order they will be processed.
 *         *   `view completed`: Displays all tasks currently in the completed list.
 *         *   `exit`: Terminates the program.
 * 3.  **Control Flow:**
 *     *   Use a `switch` statement to handle the different user commands. A nested `switch` may be necessary depending on your command parsing strategy (e.g., for the `view` command).
 * 4.  **Output:**
 *     *   Use `System.out` for normal program output (prompts, task information, confirmation messages).
 *     *   Use `System.err` for displaying error messages (e.g., invalid command, task description empty, no tasks to complete).
 * 5.  **Error Handling:**
 *     *   Implement input validation (e.g., checking if task description is empty). Report validation errors using `System.err`.
 *     *   Implement class-wide exception handling using `try-catch` blocks within the main command processing loop to catch unexpected runtime errors.
 *     *   Handle cases where commands cannot be executed (e.g., trying to complete a task when the pending queue is empty) and report them using `System.err`.
 * 6.  **Object-Oriented Design:**
 *     *   Create a `Task` class to represent a single task. It should store at least a description and perhaps a timestamp of creation (for realism, though not strictly required for FIFO). Use private fields and public getters. Implement a meaningful `toString()` method.
 *     *   Create a `TaskManager` class that encapsulates the `pendingTasks` queue and `completedTasks` list. It should contain methods for adding, completing, and viewing tasks, as well as the main command processing loop (`run` method).
 *     *   Create a `Main` class with the `main` method to start the application by creating a `TaskManager` instance and calling its `run` method.
 * 7.  **Best Practices:**
 *     *   Follow Java coding conventions.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and basic documentation (e.g., Javadoc for classes/methods).
 * 
 * **Expected Output Structure:**
 * 
 * The output should guide the user, show task operations, and report errors clearly.
 * 
 * ```
 * --- Simple Task Manager ---
 * Commands: add <description>, complete, view pending, view completed, exit
 * 
 * Enter command: add Buy groceries
 * Task added: "Buy groceries"
 * 
 * Enter command: add Walk the dog
 * Task added: "Walk the dog"
 * 
 * Enter command: view pending
 * --- Pending Tasks ---
 * 1. Buy groceries (created at YYYY-MM-DD HH:MM:SS)
 * 2. Walk the dog (created at YYYY-MM-DD HH:MM:SS)
 * ---------------------
 * 
 * Enter command: complete
 * Completed task: "Buy groceries"
 * 
 * Enter command: view completed
 * --- Completed Tasks ---
 * 1. Buy groceries (created at YYYY-MM-DD HH:MM:SS)
 * -----------------------
 * 
 * Enter command: complete
 * Completed task: "Walk the dog"
 * 
 * Enter command: complete
 * Info: No pending tasks to complete.
 * 
 * Enter command: view pending
 * No pending tasks.
 * 
 * Enter command: invalid command
 * Error: Unknown command. Please try again.
 * 
 * Enter command: add
 * Error: Usage: add <description>
 * 
 * Enter command: add
 * Error: Task description cannot be empty.
 * 
 * Enter command: exit
 * Exiting Task Manager.
 * ```
 * *(Timestamp format may vary based on implementation)*
 * 
 * Implement the Java code for the `Task`, `TaskManager`, and `Main` classes to meet these requirements.
 *
 * EXPLANATION:
 * This solution implements a simple command-line Task Management System, demonstrating the required Java concepts in a practical scenario.
 * 
 * **Structure:**
 * The application is divided into three classes:
 * 1.  `Task`: Represents a single task object, holding its description and creation timestamp. It provides getters and a `toString()` method for easy display. Basic validation is included in the constructor.
 * 2.  `TaskManager`: This is the core class that manages the task data structures and handles the application logic, including user interaction.
 * 3.  `Main`: Contains the `main` method, which serves as the application's entry point. It simply creates a `TaskManager` instance and starts its `run` method.
 * 
 * **Required Component Usage:**
 * 
 * *   **`Queue` (`java.util.Queue`)**: The `pendingTasks` field in `TaskManager` is declared as `Queue<Task>` and initialized with a `LinkedList`. A `Queue` is used because tasks are processed in the order they are added (FIFO). The `offer()` method is used for adding tasks, and `poll()` is used for retrieving and removing the next task to be completed.
 * *   **`ArrayList` (`java.util.ArrayList`)**: The `completedTasks` field is initialized with an `ArrayList`. `ArrayList` is suitable here as it provides a dynamic list to store completed tasks, and their order of completion is maintained simply by adding them to the end of the list.
 * *   **`List` interface (`java.util.List`)**: The `completedTasks` field is explicitly declared using the `List<Task>` interface type, demonstrating the principle of programming to interfaces rather than concrete implementations.
 * *   **`Scanner` (`java.util.Scanner`)**: Used in the `TaskManager.run()` method to read command lines entered by the user via `System.in`. A `try-with-resources` block is used to ensure the `Scanner` is properly closed.
 * *   **`Switch` statement**: Used prominently in the `TaskManager.run()` method to determine which action to perform based on the user's command (`add`, `complete`, `view`, `exit`). A nested `switch` is used to handle the different types of views (`pending` or `completed`) requested by the user.
 * *   **`System.err`**: Used to output error messages, such as invalid commands, incorrect command usage, empty task descriptions, or attempts to complete a task when the pending queue is empty. This distinguishes error output from normal program information.
 * *   **`System.out`**: Used for standard program output, including the welcome message, command prompts, confirmations when tasks are added or completed, and displaying the lists of pending and completed tasks.
 * *   **Class-wide exception handling with `try-catch`**: The main command processing loop within `TaskManager.run()` is wrapped in a `try-catch` block (`catch (Exception e)`). This block is designed to catch any unexpected runtime exceptions that might occur during the processing of a command, preventing the program from crashing and reporting a general error message to `System.err`. Specific methods like `addTask` and `completeNextTask` also include smaller `try-catch` blocks for more localized error handling (though the main loop catch is the primary handler for the user interaction phase). The `Task` constructor throws `IllegalArgumentException` for invalid input, which is handled defensively by `addTask`.
 * 
 * **Logic and Control Flow:**
 * 
 * The `TaskManager.run()` method contains the main application loop. It repeatedly:
 * 1.  Prompts the user for input using `System.out.print`.
 * 2.  Reads the entire line of input using `scanner.nextLine()`.
 * 3.  Trims leading/trailing whitespace and checks if the input is empty.
 * 4.  Splits the input line into parts (command and argument) using `split(" ", 2)`.
 * 5.  Uses the outer `switch` statement on the first part (the command) to direct execution.
 * 6.  Inside each case:
 *     *   **`add`**: Validates if a description is provided (`parts.length < 2`). If so, it extracts the description and calls `addTask()`. `addTask` performs further validation for emptiness and creates/adds the task, printing confirmation or an error to `System.err`.
 *     *   **`complete`**: Calls `completeNextTask()`, which attempts to `poll()` the queue. It prints a success message to `System.out` or an info message to `System.err` if the queue is empty.
 *     *   **`view`**: Validates if a view type is provided. Uses a *nested* `switch` statement on the second part (`viewType`) to call either `viewPendingTasks()` or `viewCompletedTasks()`. Invalid view types result in an error to `System.err`.
 *     *   **`exit`**: Sets a flag to terminate the loop and prints an exit message.
 *     *   **`default`**: Catches any unknown commands and prints an error to `System.err`.
 * 7.  The entire command processing logic inside the loop is wrapped in a `try-catch(Exception e)` block to catch unexpected errors during execution and report them gracefully to `System.err`. Specific `NoSuchElementException` and `IllegalStateException` catches are included for robustness with `Scanner`.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Task data is private within the `Task` class. Task management logic and data structures are private within `TaskManager`.
 * *   **Meaningful Names:** Variables and methods like `pendingTasks`, `completeNextTask`, `viewCompletedTasks`, `commandLine`, `description` are descriptive.
 * *   **Comments and Documentation:** Javadoc comments are provided for classes and key methods explaining their purpose, parameters, and return values (or exceptions).
 * *   **Input Validation:** Checks for empty command lines, missing arguments for commands like `add` and `view`, and empty task descriptions are performed explicitly, with errors directed to `System.err`.
 * *   **Error Handling:** A multi-layered approach is used: validation errors print to `System.err` and often cause a method to return early; logic errors (like completing an empty queue) also print informative messages to `System.err`; unexpected runtime errors are caught by the general `try-catch` block in the `run` loop.
 * *   **Clean Structure:** The separation into `Task`, `TaskManager`, and `Main` classes promotes modularity and organization. The `run` method centralizes the main application loop and command handling. Using `try-with-resources` for the `Scanner` ensures proper resource management.
 * 
 * This solution effectively integrates the required Java components to build a functional, albeit simple, application while adhering to best practices for structure, readability, and error handling.
 */

// Task.java
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single task with a description and creation timestamp.
 */
public class Task {
    private String description;
    private long creationTimestamp; // Milliseconds since epoch

    // DateTimeFormatter is thread-safe, can be static final
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                                                         .withZone(ZoneId.systemDefault());

    /**
     * Constructs a new Task.
     *
     * @param description The description of the task. Must not be null or empty.
     * @throws IllegalArgumentException if the description is null or empty.
     */
    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
             throw new IllegalArgumentException("Task description cannot be empty.");
        }
        this.description = description.trim();
        this.creationTimestamp = Instant.now().toEpochMilli();
    }

    /**
     * Gets the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the creation timestamp of the task in milliseconds since the epoch.
     *
     * @return The creation timestamp.
     */
    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    /**
     * Gets the formatted creation time string.
     *
     * @return A formatted string representing the creation time.
     */
    public String getFormattedCreationTime() {
         return FORMATTER.format(Instant.ofEpochMilli(creationTimestamp));
    }

    /**
     * Returns a string representation of the Task.
     *
     * @return A formatted string including description and creation time.
     */
    @Override
    public String toString() {
        return String.format("%s (created at %s)", description, getFormattedCreationTime());
    }
}

// TaskManager.java
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.NoSuchElementException; // Added for potential Scanner issues, though not strictly required by prompt

/**
 * Manages a collection of pending and completed tasks.
 * Handles user interaction via a command-line interface.
 */
public class TaskManager {
    private Queue<Task> pendingTasks;
    private List<Task> completedTasks;

    /**
     * Constructs a new TaskManager, initializing the task queues and lists.
     */
    public TaskManager() {
        this.pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>(); // ArrayList implements List
    }

    /**
     * Adds a new task to the pending queue.
     * Validates the task description before creation.
     *
     * @param description The description of the task.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return; // Validation failed
        }
        try {
            Task newTask = new Task(description.trim());
            // offer is generally preferred over add for queues as it handles capacity limits gracefully,
            // though LinkedList is unbounded. It's good practice with Queue interface.
            pendingTasks.offer(newTask);
            System.out.println("Task added: \"" + newTask.getDescription() + "\"");
        } catch (IllegalArgumentException e) {
             // This catch block is mostly defensive as addTask validates first,
             // but catches potential issues from Task constructor.
             System.err.println("Error creating task: " + e.getMessage());
        } catch (Exception e) {
             // Catch any other unexpected errors during task creation/adding
             System.err.println("An unexpected error occurred while adding task: " + e.getMessage());
             // e.printStackTrace(); // Uncomment for debugging
        }
    }

    /**
     * Completes the next task in the pending queue (FIFO) and moves it to the completed list.
     * Reports an error if there are no pending tasks.
     */
    public void completeNextTask() {
        try {
            // poll() retrieves and removes the head of the queue, or returns null if the queue is empty.
            Task completedTask = pendingTasks.poll();
            if (completedTask == null) {
                System.err.println("Info: No pending tasks to complete.");
            } else {
                completedTasks.add(completedTask); // Add to the completed list
                System.out.println("Completed task: \"" + completedTask.getDescription() + "\"");
            }
        } catch (Exception e) {
             // Catch any unexpected errors during task completion
             System.err.println("An unexpected error occurred while completing task: " + e.getMessage());
             // e.printStackTrace(); // Uncomment for debugging
        }
    }

    /**
     * Displays all tasks currently in the pending queue in processing order.
     */
    public void viewPendingTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }
        System.out.println("--- Pending Tasks ---");
        int index = 1;
        // Iterating over a Queue using a for-each loop (or iterator) allows viewing
        // elements in the order they would be polled without removing them.
        for (Task task : pendingTasks) {
            System.out.println(index++ + ". " + task); // Task's toString() is used
        }
        System.out.println("---------------------");
    }

    /**
     * Displays all tasks currently in the completed list.
     */
    public void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
            return;
        }
        System.out.println("--- Completed Tasks ---");
        int index = 1;
        for (Task task : completedTasks) {
            System.out.println(index++ + ". " + task); // Task's toString() is used
        }
        System.out.println("-----------------------");
    }

    /**
     * Runs the main command loop for the Task Manager.
     * Uses Scanner for input, switch statements for command processing,
     * and try-catch for handling potential exceptions during input or processing.
     */
    public void run() {
        // Use try-with-resources for Scanner to ensure it's closed automatically
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;

            System.out.println("--- Simple Task Manager ---");
            System.out.println("Commands: add <description>, complete, view pending, view completed, exit");

            while (running) {
                System.out.print("\nEnter command: "); // Use print instead of println for prompt

                try {
                    String commandLine = scanner.nextLine().trim();
                    if (commandLine.isEmpty()) {
                        System.err.println("Error: Command cannot be empty.");
                        continue; // Prompt again
                    }

                    // Split the command line into the command and its argument (if any)
                    String[] parts = commandLine.split(" ", 2);
                    String command = parts[0].toLowerCase(); // Process the command part

                    // Use switch for the main command flow control
                    switch (command) {
                        case "add":
                            // Check if description part exists
                            if (parts.length < 2) {
                                System.err.println("Error: Usage: add <description>");
                            } else {
                                String description = parts[1].trim();
                                addTask(description); // addTask handles empty description validation internally
                            }
                            break;
                        case "complete":
                            completeNextTask();
                            break;
                        case "view":
                            // Handle the 'view' command which requires a second argument
                            if (parts.length < 2) {
                                System.err.println("Error: Usage: view pending or view completed");
                            } else {
                                String viewType = parts[1].toLowerCase();
                                // Use a nested switch for the view type
                                switch (viewType) {
                                    case "pending":
                                        viewPendingTasks();
                                        break;
                                    case "completed":
                                        viewCompletedTasks();
                                        break;
                                    default:
                                        System.err.println("Error: Invalid view type. Use 'pending' or 'completed'.");
                                }
                            }
                            break;
                        case "exit":
                            running = false;
                            System.out.println("Exiting Task Manager.");
                            break;
                        default:
                            // Handle unknown commands
                            System.err.println("Error: Unknown command. Please try again.");
                    }
                } catch (NoSuchElementException e) {
                     // This might happen if the input stream is closed unexpectedly
                     System.err.println("Error: Input stream closed unexpectedly.");
                     running = false; // Exit loop on fatal input error
                } catch (IllegalStateException e) {
                     // This might happen if the scanner is used after being closed
                     System.err.println("Error: Scanner is closed.");
                     running = false; // Exit loop on fatal scanner state error
                } catch (Exception e) {
                    // Catch any other unexpected runtime exceptions during command processing
                    System.err.println("An unexpected internal error occurred: " + e.getMessage());
                    // e.printStackTrace(); // Uncomment for debugging to see the stack trace
                }
            }
        } // Scanner is automatically closed here by try-with-resources
    }
}

// Main.java
/**
 * The entry point for the Simple Task Management System application.
 */
public class Main {
    /**
     * The main method that starts the Task Manager.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run(); // Start the task manager's command loop
    }
}
