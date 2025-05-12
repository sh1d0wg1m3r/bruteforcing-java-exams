/*
 * Exam Question #11
 * Generated on: 2025-05-11 21:31:52
 * 
 * QUESTION:
 * **Task Management System**
 * 
 * You are tasked with developing a simple command-line Task Management System for a small team. The system should allow users to add new tasks, process the next pending task, and view lists of pending and completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` to represent individual tasks. Each task should have:
 *     *   A unique integer ID.
 *     *   A description (String).
 *     *   A status (e.g., PENDING, COMPLETED). Use an `enum` for the status.
 *     *   Implement appropriate encapsulation (private fields, public getters).
 *     *   Override `toString()` to provide a user-friendly representation of the task.
 * 
 * 2.  **Task Management Logic:** Create a class named `TaskManagementSystem` that manages the tasks. This class should:
 *     *   Maintain a collection of tasks that are waiting to be processed. This collection *must* be a `java.util.Queue`.
 *     *   Maintain a collection of tasks that have been completed. This collection *must* be a `java.util.List` implemented by `java.util.ArrayList`.
 *     *   Use a counter to generate unique task IDs.
 *     *   Provide methods for:
 *         *   `addTask(String description)`: Creates a new `Task` with status PENDING and adds it to the pending task queue. Validate that the description is not empty or null.
 *         *   `processNextTask()`: Removes the next task from the pending queue, changes its status to COMPLETED, and adds it to the completed tasks list. Handle the case where there are no pending tasks.
 *         *   `viewPendingTasks()`: Displays all tasks currently in the pending queue.
 *         *   `viewCompletedTasks()`: Displays all tasks currently in the completed list.
 * 
 * 3.  **User Interface:** Implement a command-line interface in the `main` method (or a separate `run` method called from `main`) that interacts with the user using `java.util.Scanner`. The system should accept the following commands:
 *     *   `add`: Prompts the user for a task description and adds the task.
 *     *   `process`: Processes the next pending task.
 *     *   `view pending`: Displays pending tasks.
 *     *   `view completed`: Displays completed tasks.
 *     *   `exit`: Exits the application.
 * 
 * 4.  **Required Java Components:** Your solution *must* explicitly use and demonstrate understanding of:
 *     *   `java.util.Queue`
 *     *   `java.util.ArrayList`
 *     *   `java.util.List` (declared as the type for the completed tasks collection)
 *     *   `java.util.Scanner` for user input.
 *     *   `switch` statement for command processing.
 *     *   `System.err` for displaying error messages (e.g., invalid input, trying to process an empty queue).
 *     *   `System.out` for displaying normal output (prompts, task lists, success messages).
 *     *   Class-wide exception handling using `try-catch` blocks to catch potential unexpected runtime errors during command processing.
 * 
 * 5.  **Best Practices:** Adhere to standard Java best practices, including:
 *     *   Meaningful variable and method names.
 *     *   Proper indentation and code formatting.
 *     *   Basic input validation (e.g., non-empty task description).
 *     *   Comments where necessary to explain logic.
 * 
 * **Expected Output Format:**
 * 
 * The output should be clear and informative.
 * *   Menu prompts should use `System.out`.
 * *   Task lists should be clearly formatted using `System.out`.
 * *   Success messages should use `System.out`.
 * *   Error messages (like "Description cannot be empty", "No pending tasks", "Invalid command", or unexpected errors) *must* use `System.err`.
 * 
 * Example interaction:
 * 
 * ```
 * Task Management System
 * Enter command (add, process, view pending, view completed, exit): add
 * Enter task description: Write report
 * Task added with ID 1.
 * Enter command (add, process, view pending, view completed, exit): add
 * Enter task description: Review code
 * Task added with ID 2.
 * Enter command (add, process, view pending, view completed, exit): view pending
 * --- Pending Tasks ---
 * [ID: 1, Description: Write report, Status: PENDING]
 * [ID: 2, Description: Review code, Status: PENDING]
 * ---------------------
 * Enter command (add, process, view pending, view completed, exit): process
 * Processing task ID 1: Write report
 * Task ID 1 completed.
 * Enter command (add, process, view pending, view completed, exit): view pending
 * --- Pending Tasks ---
 * [ID: 2, Description: Review code, Status: PENDING]
 * ---------------------
 * Enter command (add, process, view pending, view completed, exit): view completed
 * --- Completed Tasks ---
 * [ID: 1, Description: Write report, Status: COMPLETED]
 * -----------------------
 * Enter command (add, process, view pending, view completed, exit): process
 * Processing task ID 2: Review code
 * Task ID 2 completed.
 * Enter command (add, process, view pending, view completed, exit): process
 * No pending tasks to process.
 * Enter command (add, process, view pending, view completed, exit): view pending
 * --- Pending Tasks ---
 * No pending tasks.
 * ---------------------
 * Enter command (add, process, view pending, view completed, exit): view completed
 * --- Completed Tasks ---
 * [ID: 1, Description: Write report, Status: COMPLETED]
 * [ID: 2, Description: Review code, Status: COMPLETED]
 * -----------------------
 * Enter command (add, process, view pending, view completed, exit): invalid_command
 * Error: Invalid command. Use add, process, view pending, view completed, or exit.
 * Enter command (add, process, view pending, view completed, exit): exit
 * Exiting Task Management System.
 * ```
 * 
 * Your solution should compile and run, demonstrating all the required features.
 *
 * EXPLANATION:
 * This solution implements a simple command-line Task Management System as required by the problem description, demonstrating the use of all specified Java components and best practices.
 * 
 * 1.  **`Task` Class:**
 *     *   Defines the structure of a task with `id`, `description`, and `status`.
 *     *   An `enum TaskStatus` is used for the task status, providing type safety and readability.
 *     *   Fields are `private` and accessed via public getters, adhering to encapsulation principles.
 *     *   The `toString()` method is overridden for convenient printing of task details.
 * 
 * 2.  **`TaskManagementSystem` Class:**
 *     *   **`Queue<Task> pendingTasks`**: A `LinkedList` is used to implement the `Queue` interface. This is appropriate for managing pending tasks because a queue processes elements in a First-In, First-Out (FIFO) order, which naturally fits the idea of processing the "next" task. `offer()` is used for adding tasks, and `poll()` for removing and retrieving the head, handling the empty case gracefully.
 *     *   **`List<Task> completedTasks`**: An `ArrayList` is used to implement the `List` interface. This is suitable for storing completed tasks as we might need to iterate through them or potentially access them by index (though not strictly required by this problem, `ArrayList` is a common and efficient `List` implementation).
 *     *   **`nextTaskId`**: An integer counter ensures unique IDs for each new task.
 *     *   **`addTask(String description)`**: Takes a description, validates it, creates a new `Task` with the next available ID and `PENDING` status, and adds it to the `pendingTasks` queue using `offer()`. Uses `System.err` for the validation error and `System.out` for success messages.
 *     *   **`processNextTask()`**: Uses `pendingTasks.poll()` to get and remove the next task. If `poll()` returns `null` (meaning the queue is empty), an error message is printed to `System.err`. Otherwise, the task's status is updated to `COMPLETED`, and it's added to the `completedTasks` list. `System.out` is used for status updates.
 *     *   **`viewPendingTasks()`**: Iterates through the `pendingTasks` queue using a for-each loop (which doesn't remove elements) and prints each task to `System.out`. Checks for emptiness and prints a message if the queue is empty.
 *     *   **`viewCompletedTasks()`**: Iterates through the `completedTasks` list and prints each task to `System.out`. Checks for emptiness.
 *     *   **`run()`**: Contains the main application loop.
 * 
 * 3.  **User Interface (`run()` method):**
 *     *   **`Scanner scanner = new Scanner(System.in);`**: Used to read user input from the console.
 *     *   A `while(true)` loop keeps the system running until the user explicitly enters the "exit" command.
 *     *   **`System.out.print(...)`**: Used to display prompts to the user.
 *     *   **`scanner.nextLine().trim().toLowerCase()`**: Reads the entire line of input, removes leading/trailing whitespace, and converts it to lowercase for case-insensitive command matching.
 *     *   **`switch (command)`**: Controls the program flow based on the user's command. Each case calls the appropriate method in `TaskManagementSystem`.
 *     *   **`default` case**: Handles invalid commands by printing an error message to `System.err`.
 *     *   **`exit` case**: Prints a goodbye message, closes the `Scanner` resource, and uses `return` to exit the `run` method, ending the program.
 * 
 * 4.  **Exception Handling:**
 *     *   A `try-catch (Exception e)` block is wrapped around the core command processing logic inside the `while` loop in the `run()` method. This demonstrates class-wide exception handling. While this specific implementation might not throw many checked exceptions, this structure is crucial for catching unexpected runtime errors (like `NullPointerException` if a bug were introduced elsewhere) and preventing the program from crashing abruptly. Error details are printed to `System.err`.
 * 
 * 5.  **Input Validation and Error Reporting:**
 *     *   The `addTask` method checks if the description is null or empty and uses `System.err` for the error.
 *     *   The `processNextTask`, `viewPendingTasks`, and `viewCompletedTasks` methods check if their respective collections are empty before attempting operations or listing, providing informative messages via `System.err` or `System.out`.
 *     *   Invalid commands in the `switch` statement result in an error message to `System.err`.
 * 
 * 6.  **Best Practices:**
 *     *   Variable and method names are descriptive (e.g., `pendingTasks`, `processNextTask`, `viewCompletedTasks`).
 *     *   Code is structured into classes and methods, improving organization and readability.
 *     *   Basic comments explain the purpose of classes, methods, and data structures.
 *     *   Encapsulation is used in the `Task` class.
 * 
 * This solution effectively combines the required Java features to build a functional, albeit simple, task management system, demonstrating a solid understanding of fundamental data structures, control flow, user interaction, and error handling in Java.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Enum for Task Status
enum TaskStatus {
    PENDING,
    COMPLETED
}

// Class to represent a Task
class Task {
    private int id;
    private String description;
    private TaskStatus status;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = TaskStatus.PENDING; // New tasks are always PENDING
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // Setter for status (used when processing)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Description: " + description + ", Status: " + status + "]";
    }
}

// Class to manage Tasks
class TaskManagementSystem {
    // Use Queue for pending tasks (FIFO)
    private Queue<Task> pendingTasks;
    // Use List (ArrayList) for completed tasks
    private List<Task> completedTasks;
    private int nextTaskId;

    public TaskManagementSystem() {
        // LinkedList implements Queue
        this.pendingTasks = new LinkedList<>();
        // ArrayList implements List
        this.completedTasks = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the pending queue.
     * @param description The description of the task.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }
        Task newTask = new Task(nextTaskId++, description.trim());
        pendingTasks.offer(newTask); // offer is generally preferred over add for queues
        System.out.println("Task added with ID " + newTask.getId() + ".");
    }

    /**
     * Processes the next task in the pending queue, moving it to completed.
     */
    public void processNextTask() {
        // poll() retrieves and removes the head of the queue, returns null if empty
        Task taskToProcess = pendingTasks.poll();

        if (taskToProcess == null) {
            System.err.println("No pending tasks to process.");
        } else {
            System.out.println("Processing task ID " + taskToProcess.getId() + ": " + taskToProcess.getDescription());
            taskToProcess.setStatus(TaskStatus.COMPLETED);
            completedTasks.add(taskToProcess);
            System.out.println("Task ID " + taskToProcess.getId() + " completed.");
        }
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    public void viewPendingTasks() {
        System.out.println("--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            // Iterate through the queue without removing elements
            for (Task task : pendingTasks) {
                System.out.println(task);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Displays all tasks currently in the completed list.
     */
    public void viewCompletedTasks() {
        System.out.println("--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Runs the main command-line interface loop.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Task Management System");
        String command;

        while (true) {
            System.out.print("Enter command (add, process, view pending, view completed, exit): ");
            command = scanner.nextLine().trim().toLowerCase(); // Read command, trim whitespace, convert to lowercase

            // Use try-catch for general exception handling around command processing
            try {
                switch (command) {
                    case "add":
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        addTask(description);
                        break;
                    case "process":
                        processNextTask();
                        break;
                    case "view pending":
                        viewPendingTasks();
                        break;
                    case "view completed":
                        viewCompletedTasks();
                        break;
                    case "exit":
                        System.out.println("Exiting Task Management System.");
                        scanner.close();
                        return; // Exit the run method and terminate the program
                    default:
                        System.err.println("Error: Invalid command. Use add, process, view pending, view completed, or exit.");
                        break;
                }
            } catch (Exception e) {
                // Catch any unexpected exceptions during command execution
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // Optionally print stack trace for debugging during development/testing
                // e.printStackTrace(System.err);
            }
            System.out.println(); // Add a blank line for better readability between commands
        }
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        system.run();
    }
}
