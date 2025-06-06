/*
 * Exam Question #981
 * Generated on: 2025-05-12 17:08:12
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified command-line based Task Management System. This system will allow users to add new tasks, process the next waiting task, and view tasks that are waiting or have been completed.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class `Task` to represent a task. Each task should have:
 *     *   A unique name (String).
 *     *   A priority (String, e.g., "High", "Medium", "Low").
 *     *   A status (String, e.g., "Waiting", "Processing", "Completed").
 *     *   Implement appropriate encapsulation (private fields, public getters).
 *     *   Provide a constructor to initialize name and priority, setting the initial status to "Waiting".
 *     *   Include a method `updateStatus(String newStatus)` to change the task's status.
 *     *   Override the `toString()` method to provide a user-friendly representation of the task (e.g., "Task: [Name], Priority: [Priority], Status: [Status]").
 * 
 * 2.  **Task Management Logic:** Create a class `TaskManager` that will manage the tasks. This class should:
 *     *   Maintain a collection of tasks that are waiting to be processed. Use a `java.util.Queue` for this, as tasks should be processed in the order they are added (FIFO - First-In, First-Out), unless a task is currently being processed.
 *     *   Maintain a collection of tasks that have been completed. Use a `java.util.ArrayList` for this.
 *     *   Use the `java.util.List` interface when referring to the completed tasks collection where appropriate (e.g., in method signatures or variable declarations).
 *     *   Implement the following public methods:
 *         *   `addTask(String name, String priority)`: Creates a new `Task` object and adds it to the waiting queue. Implement input validation: if the priority is not "High", "Medium", or "Low", print an error message to `System.err` and do not add the task.
 *         *   `processNextTask()`: Removes the task from the front of the waiting queue. If the queue is empty, print a message to `System.out` indicating no tasks are waiting. If a task is retrieved:
 *             *   Change its status to "Processing". Print a message to `System.out` indicating which task is being processed.
 *             *   (Simulate processing - no actual work needed, just print the message).
 *             *   Change its status to "Completed". Add the task to the completed tasks list. Print a message to `System.out` indicating which task is completed.
 *         *   `viewWaitingTasks()`: Print all tasks currently in the waiting queue to `System.out`. If the queue is empty, print a message indicating no tasks are waiting.
 *         *   `viewCompletedTasks()`: Print all tasks currently in the completed tasks list to `System.out`. If the list is empty, print a message indicating no tasks are completed.
 *         *   `run()`: This method will contain the main application loop. It should:
 *             *   Use `java.util.Scanner` to read user commands from `System.in`.
 *             *   Present a menu of options to the user (e.g., "add", "process", "view waiting", "view completed", "exit").
 *             *   Use a `switch` statement to handle the user's command.
 *             *   For the "add" command, prompt the user for task name and priority.
 *             *   Implement class-wide exception handling using `try-catch` blocks within the `run` method to catch potential runtime errors during command processing (e.g., issues with input). Any caught exception should be printed to `System.err` along with a generic error message.
 *             *   The loop should continue until the user enters the "exit" command.
 * 
 * 3.  **Main Method:** Include a `main` method (either in `TaskManager` or a separate class) to create a `TaskManager` instance and call its `run()` method.
 * 
 * 4.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include comments explaining the purpose of classes, methods, and complex logic.
 *     *   Ensure proper encapsulation.
 *     *   Handle invalid user input gracefully (e.g., unknown commands, invalid priority).
 *     *   Use `System.out` for normal program output and `System.err` for error messages.
 * 
 * **Expected Interaction (Example):**
 * 
 * ```
 * --- Task Management System ---
 * Commands: add, process, view waiting, view completed, exit
 * Enter command: add
 * Enter task name: Buy groceries
 * Enter task priority (High, Medium, Low): High
 * Task 'Buy groceries' added with priority High.
 * 
 * Enter command: add
 * Enter task name: Pay bills
 * Enter task priority (High, Medium, Low): Medium
 * Task 'Pay bills' added with priority Medium.
 * 
 * Enter command: view waiting
 * Waiting Tasks:
 * Task: Buy groceries, Priority: High, Status: Waiting
 * Task: Pay bills, Priority: Medium, Status: Waiting
 * 
 * Enter command: process
 * Processing task: Task: Buy groceries, Priority: High, Status: Waiting
 * Task completed: Task: Buy groceries, Priority: High, Status: Completed
 * 
 * Enter command: view completed
 * Completed Tasks:
 * Task: Buy groceries, Priority: High, Status: Completed
 * 
 * Enter command: process
 * Processing task: Task: Pay bills, Priority: Medium, Status: Waiting
 * Task completed: Task: Pay bills, Priority: Medium, Status: Completed
 * 
 * Enter command: process
 * No tasks waiting to be processed.
 * 
 * Enter command: view waiting
 * No tasks waiting.
 * 
 * Enter command: view completed
 * Completed Tasks:
 * Task: Buy groceries, Priority: High, Status: Completed
 * Task: Pay bills, Priority: Medium, Status: Completed
 * 
 * Enter command: exit
 * Exiting Task Management System.
 * ```
 * 
 * **Evaluation:**
 * 
 * Your solution will be evaluated based on:
 * *   Correct implementation and usage of all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`).
 * *   Adherence to the specified requirements for the `Task` and `TaskManager` classes.
 * *   Correct program flow and command handling.
 * *   Effective input validation and error handling using `System.err` and `try-catch`.
 * *   Application of best practices (encapsulation, naming, comments).
 * *   Clarity and readability of the code.
 *
 * EXPLANATION:
 * The provided solution implements a simple command-line Task Management System, demonstrating the required Java concepts and best practices.
 * 
 * **Class Structure:**
 * 
 * 1.  **`Task` Class:**
 *     *   This class encapsulates the data for a single task: `name`, `priority`, and `status`.
 *     *   Private fields enforce encapsulation.
 *     *   Public getters provide controlled access to the task's properties.
 *     *   The constructor initializes a new task with a name and priority, setting the initial status to "Waiting".
 *     *   `updateStatus` allows changing the task's state.
 *     *   `toString()` provides a convenient way to print task details.
 * 
 * 2.  **`TaskManager` Class:**
 *     *   This class manages the collections of tasks.
 *     *   `waitingTasks`: A `Queue<Task>` (implemented using `LinkedList`) holds tasks that are waiting to be processed. The `Queue` interface is used because tasks are processed in the order they are added (FIFO). `offer()` is used for adding tasks, and `poll()` for retrieving and removing the head.
 *     *   `completedTasks`: A `List<Task>` (implemented using `ArrayList`) stores tasks once they are finished. The `List` interface is used for the variable declaration, demonstrating the use of the interface type. `ArrayList` is suitable here as we primarily add and iterate through completed tasks.
 *     *   `addTask(String name, String priority)`: Handles creating a new `Task` and adding it to the `waitingTasks` queue. It includes input validation for the priority string. Invalid priorities result in an error message printed to `System.err` and the task not being added.
 *     *   `processNextTask()`: Implements the core processing logic. It uses `waitingTasks.poll()` to get the next task. It checks if the queue is empty and prints a message if so. Otherwise, it updates the task's status, simulates processing (via print statements), updates the status again, and adds the task to the `completedTasks` list using `completedTasks.add()`.
 *     *   `viewWaitingTasks()`: Iterates through the `waitingTasks` queue to print each task's details. It checks for an empty queue.
 *     *   `viewCompletedTasks()`: Iterates through the `completedTasks` list to print each task's details. It checks for an empty list.
 *     *   `run()`: This is the main method orchestrating the user interaction.
 *         *   It uses `Scanner` to read input from `System.in`.
 *         *   A `while` loop continues until the "exit" command is given.
 *         *   A `switch` statement efficiently handles different user commands ("add", "process", "view waiting", "view completed", "exit").
 *         *   **Class-wide Exception Handling:** A `try-catch` block wraps the main `while` loop. This allows catching any unexpected `Exception` that might occur during the execution of commands (e.g., NullPointerException if logic errors existed, though less likely in this simple case, but good practice for robustness). Caught exceptions are reported to `System.err`.
 *         *   The `finally` block ensures the `Scanner` is closed regardless of whether the loop finishes normally or an exception occurs.
 *     *   `main(String[] args)`: The entry point of the application, creating a `TaskManager` instance and calling `run()`.
 * 
 * **Required Components Usage:**
 * 
 * *   `java.util.Queue`: Used for `waitingTasks` (`LinkedList` implementation). Demonstrates FIFO behavior with `offer()` and `poll()`.
 * *   `java.util.ArrayList`: Used for `completedTasks` (`ArrayList` implementation). Demonstrates dynamic list management with `add()` and iteration.
 * *   `java.util.List`: Used as the type declaration for the `completedTasks` variable, showcasing programming to the interface.
 * *   `java.util.Scanner`: Used in the `run()` method to read user input from the console (`System.in`).
 * *   `switch` statement: Used in the `run()` method to dispatch actions based on the user's command string.
 * *   `System.err`: Used to print error messages, specifically for invalid priority input in `addTask` and for catching unexpected exceptions in the `run` method's `catch` block.
 * *   `System.out`: Used for all normal program output, including prompts, confirmations, task listings, and informational messages (like "No tasks waiting").
 * *   `try-catch` blocks: Implemented in the `run()` method to provide class-wide exception handling for the main application loop, catching potential runtime errors and reporting them via `System.err`.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Private fields and public methods in the `Task` class.
 * *   **Meaningful Names:** `waitingTasks`, `completedTasks`, `addTask`, `processNextTask`, `viewWaitingTasks`, etc. are descriptive.
 * *   **Comments:** Javadoc-style comments explain the purpose of classes and methods, and inline comments clarify logic.
 * *   **Input Validation:** Explicit check for valid priority strings in `addTask`.
 * *   **Error Handling:** Invalid input is handled with `System.err`. Unexpected errors in the main loop are caught and reported via `System.err`. Empty collections are handled gracefully with informational messages to `System.out`.
 * *   **Clean Code Structure:** The code is divided into logical classes (`Task`, `TaskManager`), and methods within `TaskManager` handle specific operations.
 * 
 * This solution effectively integrates all required components within a practical scenario, adhering to best practices and demonstrating advanced understanding of Java collections, control flow, and error handling.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Represents a single task in the system
class Task {
    private String name;
    private String priority; // e.g., "High", "Medium", "Low"
    private String status;   // e.g., "Waiting", "Processing", "Completed"

    /**
     * Constructs a new Task.
     *
     * @param name The name of the task.
     * @param priority The priority of the task ("High", "Medium", or "Low").
     */
    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.status = "Waiting"; // Initial status
    }

    // --- Getters ---
    public String getName() {
        return name;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the task.
     *
     * @param newStatus The new status to set ("Waiting", "Processing", or "Completed").
     */
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Task: [" + name + "], Priority: [" + priority + "], Status: [" + status + "]";
    }
}

// Manages a collection of tasks using queues and lists
public class TaskManager {

    // Queue for tasks waiting to be processed (FIFO)
    private Queue<Task> waitingTasks;

    // List for tasks that have been completed
    private List<Task> completedTasks; // Using List interface for variable declaration

    /**
     * Constructs a new TaskManager, initializing the task collections.
     */
    public TaskManager() {
        waitingTasks = new LinkedList<>(); // LinkedList implements Queue
        completedTasks = new ArrayList<>(); // ArrayList implements List
    }

    /**
     * Adds a new task to the waiting queue.
     * Validates the priority before adding.
     *
     * @param name The name of the task.
     * @param priority The priority of the task ("High", "Medium", or "Low").
     */
    public void addTask(String name, String priority) {
        // Input validation for priority
        if (!priority.equalsIgnoreCase("High") &&
            !priority.equalsIgnoreCase("Medium") &&
            !priority.equalsIgnoreCase("Low")) {
            System.err.println("Error: Invalid priority '" + priority + "'. Task not added. Please use High, Medium, or Low.");
            return; // Do not add the task
        }

        Task newTask = new Task(name, priority);
        waitingTasks.offer(newTask); // offer is preferred over add for queues (returns false on failure)
        System.out.println("Task '" + name + "' added with priority " + priority + ".");
    }

    /**
     * Processes the next task in the waiting queue.
     * Moves the task from waiting to completed list.
     */
    public void processNextTask() {
        Task taskToProcess = waitingTasks.poll(); // poll retrieves and removes the head of the queue

        if (taskToProcess == null) {
            System.out.println("No tasks waiting to be processed.");
            return;
        }

        // Simulate processing
        taskToProcess.updateStatus("Processing");
        System.out.println("Processing task: " + taskToProcess);

        // Simulate completion
        taskToProcess.updateStatus("Completed");
        completedTasks.add(taskToProcess);
        System.out.println("Task completed: " + taskToProcess);
    }

    /**
     * Displays all tasks currently in the waiting queue.
     */
    public void viewWaitingTasks() {
        if (waitingTasks.isEmpty()) {
            System.out.println("No tasks waiting.");
            return;
        }
        System.out.println("--- Waiting Tasks ---");
        // Iterate through the queue without removing elements
        for (Task task : waitingTasks) {
            System.out.println(task);
        }
    }

    /**
     * Displays all tasks currently in the completed tasks list.
     */
    public void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks completed.");
            return;
        }
        System.out.println("--- Completed Tasks ---");
        // Iterate through the list
        for (Task task : completedTasks) {
            System.out.println(task);
        }
    }

    /**
     * Runs the main application loop, handling user commands.
     * Includes class-wide exception handling.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("--- Task Management System ---");

        // Main application loop with class-wide exception handling
        try {
            while (true) {
                System.out.println("\nCommands: add, process, view waiting, view completed, exit");
                System.out.print("Enter command: ");
                command = scanner.nextLine().trim().toLowerCase();

                // Use switch statement for command handling
                switch (command) {
                    case "add":
                        System.out.print("Enter task name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter task priority (High, Medium, Low): ");
                        String priority = scanner.nextLine().trim();
                        addTask(name, priority);
                        break;

                    case "process":
                        processNextTask();
                        break;

                    case "view waiting":
                        viewWaitingTasks();
                        break;

                    case "view completed":
                        viewCompletedTasks();
                        break;

                    case "exit":
                        System.out.println("Exiting Task Management System.");
                        scanner.close(); // Close the scanner
                        return; // Exit the run method

                    default:
                        System.out.println("Unknown command. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // Optional: e.printStackTrace(); for debugging
        } finally {
            // Ensure scanner is closed even if an exception occurs before the exit command
            if (scanner != null) {
                 scanner.close();
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run();
    }
}
