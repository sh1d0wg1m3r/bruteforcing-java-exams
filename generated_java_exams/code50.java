/*
 * Exam Question #50
 * Generated on: 2025-05-11 22:05:22
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam: Advanced Task Management System
 * 
 * **Problem Description:**
 * 
 * Design and implement a simple command-line Task Management System in Java. The system should allow users to add new tasks to a processing queue, process the next task in the queue, and view a history of all tasks that have been completed.
 * 
 * **Requirements:**
 * 
 * 1.  **Core Functionality:**
 *     *   **Add Task:** Allow the user to input a description for a new task and add it to a queue of pending tasks.
 *     *   **Process Task:** Take the next task from the queue, mark it as completed, and move it to a list of completed tasks.
 *     *   **View Completed:** Display all tasks that have been processed and moved to the completed list.
 *     *   **Exit:** Allow the user to terminate the application.
 * 
 * 2.  **Required Java Components:** Your solution *must* demonstrate the correct usage of **ALL** of the following Java components:
 *     *   `java.util.Queue` (used for the pending tasks)
 *     *   `java.util.ArrayList` (used as the concrete implementation for the completed tasks list)
 *     *   `java.util.List` (used as the interface type when declaring the completed tasks list)
 *     *   `java.util.Scanner` (used to read user input from the console)
 *     *   `switch` statement (used to handle different user commands)
 *     *   `System.err` (used exclusively for printing error messages)
 *     *   `System.out` (used for all normal output, including prompts, success messages, and task listings)
 *     *   `try-catch` blocks (used for robust error handling within the class methods, particularly around operations that might fail unexpectedly or due to invalid state).
 * 
 * 3.  **Best Practices:**
 *     *   Implement proper encapsulation using private fields and public methods.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes and methods).
 *     *   Implement input validation (e.g., ensure task description is not empty).
 *     *   Handle errors gracefully (e.g., attempting to process a task when the queue is empty, unknown commands).
 *     *   Structure the code cleanly into appropriate classes and methods.
 * 
 * **Expected Output:**
 * 
 * The system should interact with the user via the console.
 * 
 * *   Prompts for commands should be clear.
 * *   Adding a task should confirm success.
 * *   Processing a task should indicate which task was processed.
 * *   Viewing completed tasks should list them clearly.
 * *   Error conditions (e.g., empty queue on process, empty description on add, unknown command) must print messages to `System.err`.
 * *   Normal messages and listings must print to `System.out`.
 * 
 * **Example Interaction Snippet (Illustrative):**
 * 
 * ```
 * Task Management System
 * Enter command (add, process, view, exit):
 * > add
 * Enter task description: Write exam question
 * Task added: "Write exam question"
 * > add
 * Enter task description: Create solution code
 * Task added: "Create solution code"
 * > process
 * Processed task: "Write exam question"
 * > view
 * Completed Tasks:
 * - [COMPLETED] Write exam question
 * > process
 * Processed task: "Create solution code"
 * > process
 * Error: No tasks in the queue to process.
 * > view
 * Completed Tasks:
 * - [COMPLETED] Write exam question
 * - [COMPLETED] Create solution code
 * > unknown_command
 * Error: Unknown command. Use add, process, view, or exit.
 * > exit
 * Exiting system.
 * ```
 * 
 * Your solution should consist of at least two classes: a `Task` class and a `TaskManagementSystem` class containing the main logic and the `main` method.
 *
 * EXPLANATION:
 * This solution implements a simple Task Management System as required by the exam question, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **Solution Approach:**
 *     *   The system is structured into two classes: `Task` to represent individual tasks and `TaskManagementSystem` to manage the collection of tasks and handle user interaction.
 *     *   Pending tasks are stored in a `Queue` because they need to be processed in the order they were added (First-In, First-Out). `LinkedList` is used as a common implementation of the `Queue` interface.
 *     *   Completed tasks are stored in a `List` because we need to maintain a history, and `ArrayList` is a suitable dynamic array implementation for this purpose. The variable is declared using the `List` interface type (`List<Task> completedTasks = new ArrayList<>();`), adhering to the principle of programming to interfaces.
 *     *   User interaction is handled via the console using `Scanner`.
 *     *   A command loop in the `run()` method continuously prompts the user for input.
 *     *   A `switch` statement is used to direct execution based on the user's command ("add", "process", "view", "exit").
 *     *   Error messages are printed to `System.err`, while all other output goes to `System.out`.
 *     *   Exception handling using `try-catch` is implemented to manage potential runtime issues gracefully.
 * 
 * 2.  **Usage of Required Components:**
 *     *   **`Queue`:** The `taskQueue` is declared as `Queue<Task>` and initialized with a `LinkedList`. `offer()` is used to add tasks to the queue, and `poll()` is used to remove and retrieve the next task for processing.
 *     *   **`ArrayList`:** The `completedTasks` list is initialized using `new ArrayList<>()`.
 *     *   **`List`:** The `completedTasks` variable is declared using the `List<Task>` interface type (`List<Task> completedTasks;`), demonstrating polymorphism and good design principles.
 *     *   **`Scanner`:** An instance of `Scanner` is created to read lines of input from `System.in`. It is used in the `run()` method to read commands and in the `addTask()` method to read the task description. The `Scanner` is closed in a `finally` block to prevent resource leaks.
 *     *   **`switch` statement:** Located in the `run()` method, it is used to select the appropriate action (`add`, `process`, `view`, `exit`) based on the user's command string.
 *     *   **`System.err`:** Used in the `addTask()` method for empty description errors, in `processNextTask()` for the empty queue error, and in the `run()` method's `default` case for unknown commands and within the inner `catch` block for unexpected runtime errors.
 *     *   **`System.out`:** Used for all other output: the welcome message, prompts (`> `, "Enter task description: "), success messages ("Task added...", "Processed task..."), and the listing of completed tasks.
 *     *   **`try-catch` blocks:**
 *         *   An outer `try-finally` block in `run()` ensures the `scanner.close()` method is always called, releasing the system resource.
 *         *   An inner `try-catch(Exception e)` block within the `while` loop in `run()` wraps the `switch` statement. This block catches any unexpected runtime exception that might occur during the execution of the code for a specific command, prints an error to `System.err`, and allows the system loop to continue, preventing the application from crashing due to an unforeseen issue during a single command's execution. This fulfills the requirement for "class-wide exception handling" by providing a general safety net for the core operational loop of the system class.
 * 
 * 3.  **Best Practices Applied:**
 *     *   **Encapsulation:** Fields (`description`, `status` in `Task`; `taskQueue`, `completedTasks`, `scanner` in `TaskManagementSystem`) are declared as `private`. Access and modification are controlled via public methods (getters, setters, operational methods like `addTask`, `processNextTask`).
 *     *   **Meaningful Names:** Variable and method names (`taskQueue`, `completedTasks`, `processNextTask`, `viewCompletedTasks`, `description`, `status`) clearly indicate their purpose.
 *     *   **Comments and Documentation:** Javadoc comments are provided for classes and public methods explaining their purpose, parameters, and return values. Inline comments explain specific implementation details where necessary.
 *     *   **Input Validation:** The `addTask()` method explicitly checks if the provided description is null or empty after trimming whitespace, printing an error to `System.err` if invalid.
 *     *   **Error Handling:**
 *         *   Specific expected errors (empty queue for processing, empty description for adding, unknown command) are checked using `if` conditions or the `switch default` case and reported clearly to `System.err`.
 *         *   Unexpected runtime errors during command execution are caught by the inner `try-catch` in `run()` and reported to `System.err`.
 *         *   Resource management (`Scanner` closure) is handled using `finally`.
 *     *   **Clean Code Structure:** The logic is divided into a `Task` class and a `TaskManagementSystem` class with well-defined methods for each operation, making the code organized and readable.
 * 
 * This solution effectively integrates the required components within a practical scenario, demonstrating understanding of core Java concepts, data structures, and error handling principles suitable for an advanced exam task.
 */

import java.util.Queue;
import java.util.LinkedList; // Common implementation for Queue
import java.util.List;
import java.util.ArrayList; // Common implementation for List
import java.util.Scanner;
import java.util.InputMismatchException; // Although not strictly needed for nextLine, good practice if parsing numbers

/**
 * Represents a single task with a description and status.
 */
class Task {
    private String description;
    private String status; // e.g., "PENDING", "COMPLETED"

    /**
     * Constructs a new Task.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.status = "PENDING"; // Tasks start as pending
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
     * Gets the current status of the task.
     *
     * @return The task status ("PENDING" or "COMPLETED").
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the task.
     *
     * @param status The new status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the task.
     *
     * @return A formatted string showing the task status and description.
     */
    @Override
    public String toString() {
        return "[" + status + "] " + description;
    }
}

/**
 * Manages a queue of pending tasks and a list of completed tasks.
 * Provides a command-line interface for interaction.
 */
public class TaskManagementSystem {
    private Queue<Task> taskQueue; // Queue for tasks awaiting processing
    private List<Task> completedTasks; // List for tasks that have been processed
    private Scanner scanner; // Scanner for reading user input

    /**
     * Constructs a new TaskManagementSystem.
     * Initializes the task queue, completed tasks list, and scanner.
     */
    public TaskManagementSystem() {
        // Using LinkedList as an implementation of Queue
        this.taskQueue = new LinkedList<>();
        // Using ArrayList as an implementation of List for completed tasks
        this.completedTasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task to the pending queue.
     * Performs input validation for the task description.
     *
     * @param description The description of the task to add.
     */
    public void addTask(String description) {
        // Input validation: Check if description is empty or just whitespace
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return; // Exit the method if input is invalid
        }

        Task newTask = new Task(description.trim());
        taskQueue.offer(newTask); // offer() is generally preferred over add() for queues as it doesn't throw exception if queue is full (though LinkedList doesn't have a fixed size)
        System.out.println("Task added: \"" + newTask.getDescription() + "\"");
    }

    /**
     * Processes the next task from the pending queue.
     * Moves the task to the completed list after processing.
     * Handles the case where the queue is empty.
     */
    public void processNextTask() {
        // Check if the queue is empty before attempting to poll
        if (taskQueue.isEmpty()) {
            System.err.println("Error: No tasks in the queue to process.");
            return; // Exit the method if queue is empty
        }

        // Use poll() to retrieve and remove the head of the queue.
        // poll() returns null if the queue is empty, but we've already checked.
        Task taskToProcess = taskQueue.poll();

        // Defensive check, though poll() should return a task here
        if (taskToProcess != null) {
            taskToProcess.setStatus("COMPLETED"); // Mark the task as completed
            completedTasks.add(taskToProcess); // Add to the completed list
            System.out.println("Processed task: \"" + taskToProcess.getDescription() + "\"");
        } else {
             // This case should ideally not be reached due to the isEmpty() check
             System.err.println("Internal error: Failed to retrieve task from queue.");
        }
    }

    /**
     * Displays all tasks currently in the completed tasks list.
     * Handles the case where the completed list is empty.
     */
    public void viewCompletedTasks() {
        // Check if the completed list is empty
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks have been completed yet.");
            return; // Exit the method if list is empty
        }

        System.out.println("Completed Tasks:");
        // Iterate through the completed tasks list and print each one
        for (int i = 0; i < completedTasks.size(); i++) {
             Task task = completedTasks.get(i);
             System.out.println("- " + task); // Task.toString() is automatically called
        }
        // Alternative using enhanced for loop:
        // for (Task task : completedTasks) {
        //     System.out.println("- " + task);
        // }
    }

    /**
     * Closes the scanner resource.
     * Important to prevent resource leaks.
     */
    private void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    /**
     * Runs the main command-line interface loop for the Task Management System.
     * Handles user input and dispatches commands using a switch statement.
     * Includes class-wide exception handling.
     */
    public void run() {
        System.out.println("Task Management System");
        System.out.println("Enter command (add, process, view, exit):");

        // Outer try-finally block to ensure scanner is closed
        try {
            // Main loop to keep the system running until 'exit' is entered
            while (true) {
                System.out.print("> ");
                String command = scanner.nextLine().trim().toLowerCase();

                // Inner try-catch block to handle potential exceptions during command execution
                // This provides "class-wide" handling for unexpected runtime errors
                try {
                    // Use switch statement to process user commands
                    switch (command) {
                        case "add":
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine(); // Read the whole line for description
                            addTask(description); // Call method to add task
                            break;
                        case "process":
                            processNextTask(); // Call method to process task
                            break;
                        case "view":
                            viewCompletedTasks(); // Call method to view completed tasks
                            break;
                        case "exit":
                            System.out.println("Exiting system.");
                            return; // Exit the run method and terminate the program
                        default:
                            // Handle unknown commands by printing an error to System.err
                            System.err.println("Error: Unknown command. Use add, process, view, or exit.");
                    }
                } catch (Exception e) {
                    // Catch any unexpected exception that occurs within the switch cases
                    // Print the error message to System.err
                    System.err.println("An unexpected error occurred during command execution: " + e.getMessage());
                    // Optionally print stack trace for debugging purposes
                    // e.printStackTrace(System.err);
                }
            }
        } finally {
            // Ensure the scanner is closed when the run method exits, either normally or due to an exception
            closeScanner();
        }
    }

    /**
     * The main method to start the Task Management System.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of the TaskManagementSystem and run it
        TaskManagementSystem system = new TaskManagementSystem();
        system.run();
    }
}
