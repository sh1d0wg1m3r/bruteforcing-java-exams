/*
 * Exam Question #379
 * Generated on: 2025-05-11 23:02:34
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Advanced Java Programming Exam: Simple Task Scheduler Simulation**
 * 
 * **Problem Description:**
 * You are tasked with building a command-line application that simulates a simple task scheduler. The scheduler should allow users to add new tasks, process the next pending task, view the list of pending tasks, and view a history of completed tasks.
 * 
 * **Requirements:**
 * Implement a Java application with the following features:
 * 1.  **Task Representation:** Create a `Task` class to represent a task. Each task should have a description (String) and a status (e.g., boolean indicating if it's completed). Use appropriate encapsulation (private fields, public methods).
 * 2.  **Task Management:**
 *     *   Pending tasks must be stored in a **`java.util.Queue`** to process them in a First-In, First-Out (FIFO) manner.
 *     *   Completed tasks must be moved from the queue to a history stored in a **`java.util.List`** (specifically using a **`java.util.ArrayList`** implementation).
 * 3.  **User Interface:** The application should interact with the user via the command line using **`java.util.Scanner`**.
 * 4.  **Commands:** Implement the following commands using a **`switch`** statement:
 *     *   `add <description>`: Adds a new task with the given description to the queue of pending tasks.
 *     *   `process`: Takes the next task from the front of the queue, marks it as completed, and moves it to the list of completed tasks.
 *     *   `list_pending`: Displays all tasks currently in the pending queue.
 *     *   `list_completed`: Displays all tasks in the completed tasks history list.
 *     *   `exit`: Terminates the application.
 * 5.  **Error Handling and Input Validation:**
 *     *   Validate user input for the `add` command (e.g., ensure description is not empty or just whitespace).
 *     *   Handle cases where the `process` command is issued but there are no pending tasks. Report this error using **`System.err`**.
 *     *   Report unknown commands using **`System.err`**.
 *     *   Implement **class-wide exception handling** using a **`try-catch`** block around the main application loop (`run` method or equivalent) to catch any unexpected runtime errors and prevent abrupt termination.
 * 6.  **Output:** Use **`System.out`** for all normal output (prompts, success messages, task lists, exit message).
 * 7.  **Best Practices:** Adhere to object-oriented principles (encapsulation), use meaningful variable and method names, include basic comments where necessary, and structure your code cleanly into appropriate classes.
 * 
 * **Expected Behavior:**
 * -   When `add Task description here` is entered, the task should be added to the pending queue, and a confirmation message printed to `System.out`. If `<description>` is empty or only whitespace, an error message should be printed to `System.err`.
 * -   When `process` is entered, the oldest pending task (the one at the front of the queue) should be moved to completed, and a confirmation printed to `System.out`. If the queue is empty, an error message "Error: No pending tasks to process." should be printed to `System.err`.
 * -   When `list_pending` is entered, all tasks currently in the queue should be listed to `System.out`, showing their status (PENDING). If the queue is empty, indicate "No pending tasks." to `System.out`.
 * -   When `list_completed` is entered, all tasks in the completed list should be listed to `System.out`, showing their status (COMPLETED). If the list is empty, indicate "No completed tasks." to `System.out`.
 * -   When `exit` is entered, the application should print an exit message to `System.out` and terminate gracefully.
 * -   Any command not recognized should result in an error message "Error: Unknown command..." printed to `System.err`.
 * -   Any unexpected runtime error occurring during the main command processing loop should be caught by the class-wide `try-catch` block, print an error message to `System.err` (e.g., "An unexpected error occurred: ..."), and ideally allow the program to continue running the loop if possible, or terminate gracefully after reporting.
 * 
 * **Deliverables:**
 * -   Complete Java code for the `Task` class and the main application class (`SimpleTaskScheduler`).
 * -   The code should compile and run from a standard Java environment, providing the interactive command-line interface described.
 * 
 * **Evaluation Criteria:**
 * -   Correct usage and integration of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch`.
 * -   Correct implementation of task management logic (FIFO queue, completed list).
 * -   Proper handling of user commands via `switch`.
 * -   Robust error handling and input validation as specified.
 * -   Adherence to best practices (encapsulation, naming, structure).
 * -   Code clarity and readability.
 *
 * EXPLANATION:
 * This solution implements a simple command-line task scheduler, demonstrating the required Java concepts and best practices.
 * 
 * **Key Components and Concepts Demonstrated:**
 * 
 * 1.  **`Task` Class:** Represents the data structure for a single task, holding its `description` and `completed` status. It uses **encapsulation** by making fields `private` and providing `public` getter methods (`getDescription`, `isCompleted`) and a method to change state (`markCompleted`). The `toString()` method provides a convenient way to display task information.
 * 
 * 2.  **`SimpleTaskScheduler` Class:** This is the main class managing the task flow.
 *     *   **`Queue<Task> pendingTasks`**: Declared as a `Queue` interface type and initialized with `LinkedList`. This correctly uses `Queue` for managing tasks in a FIFO manner, ensuring that the oldest task added is the next one to be processed.
 *     *   **`List<Task> completedTasks`**: Declared as a `List` interface type and initialized with `ArrayList`. This demonstrates using the `List` interface while employing a concrete `ArrayList` implementation for storing the history of completed tasks. `ArrayList` is suitable here as we primarily need to add and list elements.
 *     *   **`Scanner scanner`**: Used to read user input from `System.in`, fulfilling the requirement for user interaction via the command line.
 *     *   **`addTask(String description)`**: Adds a new `Task` object to the `pendingTasks` queue using `offer()`. It includes **input validation** to check for empty or whitespace-only descriptions and reports errors using **`System.err`**. Success messages are printed to **`System.out`**.
 *     *   **`processNextTask()`**: Removes the next task from the `pendingTasks` queue using `poll()`. `poll()` is used because it returns `null` if the queue is empty, allowing for graceful handling of the empty queue case. The retrieved task is marked completed and added to the `completedTasks` list. If the queue is empty, an error is reported to **`System.err`**. Success messages are printed to **`System.out`**.
 *     *   **`listPendingTasks()`**: Iterates through the `pendingTasks` queue (without removing elements) and prints each task using **`System.out`**. It checks if the queue is empty and prints an appropriate message.
 *     *   **`listCompletedTasks()`**: Iterates through the `completedTasks` list and prints each task using **`System.out`**. It checks if the list is empty and prints an appropriate message.
 *     *   **`run()`**: Contains the main application loop.
 *         *   It uses a `while` loop (`while(running)`) to keep the application running until the user types 'exit'.
 *         *   User input is read using the `scanner`.
 *         *   The input line is split into command and arguments.
 *         *   A **`switch`** statement is used to direct control flow based on the command entered by the user, fulfilling the requirement for `switch` usage.
 *         *   The `default` case in the `switch` handles unknown commands, reporting them to **`System.err`**.
 *         *   **Class-wide exception handling** is implemented by wrapping the entire `while` loop within a **`try-catch(Exception e)`** block. This catches any unexpected runtime exceptions that might occur during command processing, preventing the program from crashing abruptly and reporting the error via **`System.err`**.
 *         *   A `finally` block ensures the `scanner` is closed when the `run` method exits, whether normally or due to an exception, which is good resource management.
 *     *   **`main(String[] args)`**: The entry point of the application, which creates a `SimpleTaskScheduler` instance and calls its `run()` method.
 * 
 * **Best Practices:**
 * -   **Meaningful Names:** Variables like `pendingTasks`, `completedTasks`, `description`, `processNextTask`, etc., clearly indicate their purpose.
 * -   **Encapsulation:** The `Task` class properly hides its internal state.
 * -   **Input Validation:** The `addTask` method validates the description input.
 * -   **Error Handling:** Specific error conditions (empty queue, invalid input, unknown command, general unexpected errors) are checked and reported appropriately using `System.err`.
 * -   **Output Separation:** `System.out` is used for normal information and prompts, while `System.err` is reserved for error messages, which is standard practice.
 * -   **Code Structure:** The code is organized into two classes (`Task` and `SimpleTaskScheduler`) with clear responsibilities. The `run` method encapsulates the main application logic.
 * 
 * This solution effectively integrates all required components into a functional and robust application, demonstrating a solid understanding of fundamental and intermediate Java programming concepts.
 */

import java.util.Queue;
import java.util.LinkedList; // A common implementation of Queue
import java.util.List;
import java.util.ArrayList; // A common implementation of List
import java.util.Scanner;

// Represents a single task with a description and completion status.
class Task {
    private String description;
    private boolean completed;

    /**
     * Constructs a new Task.
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.completed = false; // Tasks are initially not completed
    }

    /**
     * Gets the description of the task.
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Checks if the task is completed.
     * @return true if the task is completed, false otherwise.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Marks the task as completed.
     */
    public void markCompleted() {
        this.completed = true;
    }

    /**
     * Provides a string representation of the task, including its status.
     * @return Formatted string showing task status and description.
     */
    @Override
    public String toString() {
        return "[" + (completed ? "COMPLETED" : "PENDING") + "] " + description;
    }
}

// Manages a queue of pending tasks and a list of completed tasks.
public class SimpleTaskScheduler {
    private Queue<Task> pendingTasks; // Queue for FIFO processing
    private List<Task> completedTasks; // List for history of completed tasks
    private Scanner scanner; // Scanner for reading user input

    /**
     * Constructs a SimpleTaskScheduler, initializing the task collections and scanner.
     */
    public SimpleTaskScheduler() {
        this.pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>(); // ArrayList implements List
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task to the pending queue.
     * Performs input validation for the description.
     * @param description The description of the task to add.
     */
    public void addTask(String description) {
        // Input validation: check if description is null, empty, or only whitespace
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return; // Exit method if validation fails
        }
        Task newTask = new Task(description.trim());
        pendingTasks.offer(newTask); // offer is recommended for queues, adds to the tail
        System.out.println("Task added: \"" + description.trim() + "\""); // Use System.out for success
    }

    /**
     * Processes the next task from the pending queue.
     * If the queue is not empty, removes the head, marks it completed, and adds to completed tasks.
     * Reports an error to System.err if the queue is empty.
     */
    public void processNextTask() {
        Task nextTask = pendingTasks.poll(); // poll retrieves and removes the head, returns null if empty

        if (nextTask != null) {
            nextTask.markCompleted(); // Mark the task as completed
            completedTasks.add(nextTask); // Add the completed task to the history list
            System.out.println("Processed task: \"" + nextTask.getDescription() + "\""); // Use System.out for success
        } else {
            System.err.println("Error: No pending tasks to process."); // Use System.err for error
        }
    }

    /**
     * Lists all tasks currently in the pending queue.
     * Prints task details to System.out.
     */
    public void listPendingTasks() {
        System.out.println("--- Pending Tasks ---"); // Use System.out for normal output
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks."); // Use System.out for normal output
        } else {
            // Iterate through the queue without removing elements to list them
            int index = 1;
            for (Task task : pendingTasks) {
                System.out.println(index++ + ". " + task); // Task's toString handles formatting
            }
        }
        System.out.println("---------------------"); // Use System.out for normal output
    }

    /**
     * Lists all tasks in the completed tasks history list.
     * Prints task details to System.out.
     */
    public void listCompletedTasks() {
        System.out.println("--- Completed Tasks ---"); // Use System.out for normal output
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks."); // Use System.out for normal output
        } else {
            // Iterate through the list to display completed tasks
            int index = 1;
            for (Task task : completedTasks) {
                System.out.println(index++ + ". " + task); // Task's toString handles formatting
            }
        }
        System.out.println("-----------------------"); // Use System.out for normal output
    }

    /**
     * Runs the main application loop, handling user commands.
     * Includes class-wide exception handling for robustness.
     */
    public void run() {
        System.out.println("Simple Task Scheduler");
        System.out.println("Available commands: add <description>, process, list_pending, list_completed, exit");

        boolean running = true;
        // Class-wide exception handling for the main application loop
        try {
            while (running) {
                System.out.print("> "); // Prompt user for input
                String inputLine = scanner.nextLine().trim(); // Read input line and trim whitespace

                if (inputLine.isEmpty()) {
                    continue; // Ignore empty input lines
                }

                // Split input into command and potential arguments (max 2 parts: command and rest of line)
                String[] parts = inputLine.split(" ", 2);
                String command = parts[0].toLowerCase(); // Get command and convert to lowercase

                // Use switch statement to handle different commands
                switch (command) {
                    case "add":
                        // Check if description argument is provided
                        if (parts.length < 2) {
                            System.err.println("Error: 'add' command requires a task description."); // Use System.err for error
                        } else {
                            addTask(parts[1]); // Call method to add task
                        }
                        break; // End of 'add' case

                    case "process":
                        processNextTask(); // Call method to process next task
                        break; // End of 'process' case

                    case "list_pending":
                        listPendingTasks(); // Call method to list pending tasks
                        break; // End of 'list_pending' case

                    case "list_completed":
                        listCompletedTasks(); // Call method to list completed tasks
                        break; // End of 'list_completed' case

                    case "exit":
                        running = false; // Set flag to exit the loop
                        System.out.println("Exiting scheduler. Goodbye!"); // Use System.out for normal output
                        break; // End of 'exit' case

                    default:
                        // Handle unknown commands
                        System.err.println("Error: Unknown command. Please use add, process, list_pending, list_completed, or exit."); // Use System.err for error
                        break; // End of default case
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exception that occurs during the main loop execution
            // This provides class-wide exception handling as required.
            System.err.println("An unexpected error occurred: " + e.getMessage()); // Report error using System.err
            // Optional: e.printStackTrace(); // Uncomment for detailed debugging stack trace
        } finally {
            // Ensure the scanner is closed when the application finishes or an exception occurs
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed."); // Indicate scanner closed (optional)
            }
        }
    }

    /**
     * The main method to start the Simple Task Scheduler application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SimpleTaskScheduler scheduler = new SimpleTaskScheduler();
        scheduler.run(); // Start the main application loop
    }
}
