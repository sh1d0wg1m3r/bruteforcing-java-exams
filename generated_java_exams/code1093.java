/*
 * Exam Question #1093
 * Generated on: 2025-05-12 17:23:45
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Task Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application that simulates a task processing system. The system allows users to add new tasks to a queue, process the next task available in the queue, and view lists of both pending and completed tasks. The system must handle user input, manage task states, and provide robust error handling.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that fulfills the following requirements:
 * 
 * 1.  **Task Representation:** Create a class (e.g., `Task`) to represent a task. Each task should have:
 *     *   A unique integer ID.
 *     *   A description (String).
 *     *   A status (e.g., "Pending", "Completed").
 * 
 * 2.  **Task Management System:** Create a class (e.g., `TaskProcessor`) that manages the tasks. This class should:
 *     *   Maintain a collection of pending tasks using a `java.util.Queue`. Tasks are processed in the order they are added (FIFO).
 *     *   Maintain a collection of completed tasks using a `java.util.ArrayList`.
 *     *   Provide methods to:
 *         *   Add a new task to the pending queue.
 *         *   Process the next task from the pending queue, change its status to "Completed", and move it to the completed tasks list. This method should handle the case where the queue is empty.
 *         *   Retrieve a list of pending tasks.
 *         *   Retrieve a list of completed tasks.
 * 
 * 3.  **User Interface:** Implement a command-line interface using `java.util.Scanner`. The system should repeatedly prompt the user for commands until an "exit" command is entered. The supported commands are:
 *     *   `add <description>`: Adds a new task with the given description to the pending queue.
 *     *   `process`: Processes the next task from the pending queue.
 *     *   `view pending`: Displays all tasks currently in the pending queue.
 *     *   `view completed`: Displays all tasks that have been completed.
 *     *   `exit`: Terminates the program.
 * 
 * 4.  **Control Flow:** Use a `switch` statement to handle the different user commands.
 * 
 * 5.  **Input Validation and Error Handling:**
 *     *   Validate user input for commands and arguments (e.g., check if the description is provided for the `add` command).
 *     *   Use `System.err` to print error messages (e.g., invalid command, missing arguments, attempting to process when the queue is empty).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime issues, especially related to input processing or unexpected states.
 * 
 * 6.  **Output:**
 *     *   Use `System.out` for normal program output (prompts, task lists, success messages).
 *     *   Format task output clearly (e.g., `[ID] Status: Description`).
 * 
 * 7.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc).
 *     *   Ensure clean code structure.
 *     *   Declare variables and method return types using interfaces where appropriate (e.g., `List` instead of `ArrayList` in method signatures).
 * 
 * **Required Java Components (MUST use ALL):**
 * 
 * *   `java.util.Queue`
 * *   `java.util.ArrayList`
 * *   `java.util.List` (as a type declaration)
 * *   `java.util.Scanner`
 * *   `switch` statement
 * *   `System.err`
 * *   `System.out`
 * *   `try-catch` blocks (for class-wide exception handling)
 * 
 * **Expected Output Examples:**
 * 
 * ```
 * Task Processing System
 * Enter command (add <description>, process, view pending, view completed, exit): add Buy groceries
 * Task added: [1] Status: Pending - Buy groceries
 * Enter command (add <description>, process, view pending, view completed, exit): add Pay bills
 * Task added: [2] Status: Pending - Pay bills
 * Enter command (add <description>, process, view pending, view completed, exit): view pending
 * --- Pending Tasks ---
 * [1] Status: Pending - Buy groceries
 * [2] Status: Pending - Pay bills
 * ---------------------
 * Enter command (add <description>, process, view pending, view completed, exit): process
 * Processed task: [1] Status: Completed - Buy groceries
 * Enter command (add <description>, process, view pending, view completed, exit): view pending
 * --- Pending Tasks ---
 * [2] Status: Pending - Pay bills
 * ---------------------
 * Enter command (add <description>, process, view pending, view completed, exit): view completed
 * --- Completed Tasks ---
 * [1] Status: Completed - Buy groceries
 * -----------------------
 * Enter command (add <description>, process, view pending, view completed, exit): process
 * Processed task: [2] Status: Completed - Pay bills
 * Enter command (add <description>, process, view pending, view completed, exit): process
 * System.err: No tasks in the queue to process.
 * Enter command (add <description>, process, view pending, view completed, exit): view pending
 * --- Pending Tasks ---
 * (Queue is empty)
 * ---------------------
 * Enter command (add <description>, process, view pending, view completed, exit): invalid command
 * System.err: Unknown command: invalid command
 * Enter command (add <description>, process, view pending, view completed, exit): add
 * System.err: Usage: add <description>
 * Enter command (add <description>, process, view pending, view completed, exit): exit
 * Exiting Task Processing System.
 * ```
 * 
 * **Constraint:** Solve this problem using the required Java components and best practices within a single cohesive program structure.
 *
 * EXPLANATION:
 * This solution implements the Task Processing System as described, using all the required Java components and adhering to best practices.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents a single task with `id`, `description`, and `status`.
 *     *   Uses private fields and public getters for encapsulation.
 *     *   Includes a `setStatus` method to allow controlled state changes.
 *     *   Provides a useful `toString()` method for easy display.
 * 
 * 2.  **`TaskProcessor` Class:**
 *     *   Manages the core logic of the system.
 *     *   `pendingTasksQueue`: Declared as `Queue<Task>` and initialized with `LinkedList`. `Queue` is used because tasks need to be processed in the order they were added (FIFO - First-In, First-Out). `LinkedList` is a common class that implements the `Queue` interface. Methods like `offer()` (add) and `poll()` (retrieve and remove) are used, which are standard `Queue` operations suitable for this FIFO behavior.
 *     *   `completedTasksList`: Declared as `List<Task>` and initialized with `ArrayList`. `List` is used as the interface type, promoting flexibility. `ArrayList` is a dynamic array suitable for storing completed tasks where order might matter but random access is also efficient.
 *     *   `nextTaskId`: A simple counter to ensure each task gets a unique ID.
 *     *   Methods like `addTask`, `processNextTask`, `getPendingTasks`, `getCompletedTasks` encapsulate the system's operations. `getPendingTasks` and `getCompletedTasks` return `List<Task>`, using the interface type. Note that `getPendingTasks` creates a new `ArrayList` from the queue content to avoid exposing the internal `Queue` structure directly, while `getCompletedTasks` uses `Collections.unmodifiableList` to prevent external modification of the completed list.
 * 
 * 3.  **`TaskSystemApp` Class (Main Execution):**
 *     *   Contains the `main` method, the entry point of the application.
 *     *   `Scanner`: Used to read user input from the console (`System.in`).
 *     *   **Class-wide `try-catch`:** The entire main logic is wrapped in a `try-catch` block. This acts as a safety net, catching any unexpected exception that might occur anywhere within the application's main loop and printing a critical error message to `System.err` before the program potentially terminates.
 *     *   **Command Loop:** A `while(running)` loop keeps the application alive until the user enters the "exit" command.
 *     *   **Input Processing:** `scanner.nextLine()` reads the full line of input. `trim()` removes leading/trailing whitespace. `split(" ", 2)` splits the input into at most two parts: the command and the rest of the line (treated as the description for "add").
 *     *   **`switch` Statement:** The `switch` statement on the command string directs the program flow to the appropriate logic for "add", "process", "view", or "exit". The `default` case handles unknown commands.
 *     *   **Inner `try-catch`:** A `try-catch` block is placed *inside* the loop, specifically around the `switch` statement and its logic. This is a more granular approach to catch exceptions that might occur *during* the processing of a single command (e.g., `ArrayIndexOutOfBoundsException` if the `parts` array doesn't have enough elements when accessing `parts[1]`, or other exceptions within the processor methods). This allows the program to report the specific command error to `System.err` and continue running for the next command, rather than crashing.
 *     *   **Input Validation:** Simple checks are performed for the `add` and `view` commands to ensure required arguments are present. Error messages for invalid usage are printed to `System.err`.
 *     *   **Error Reporting:** `System.err.println()` is used consistently for displaying error messages related to invalid input, missing arguments, or system state issues (like processing an empty queue).
 *     *   **Normal Output:** `System.out.println()` is used for prompts, success messages, and displaying task lists.
 *     *   **Resource Management:** `scanner.close()` is called to release the system resource held by the `Scanner` when the program exits.
 * 
 * This solution effectively demonstrates the required components and concepts by building a functional, albeit simple, task management system with appropriate error handling and structure.
 */

import java.util.LinkedList; // LinkedList implements Queue
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections; // For unmodifiable list

/**
 * Represents a single task in the system.
 */
class Task {
    private int id;
    private String description;
    private String status; // "Pending" or "Completed"

    /**
     * Constructs a new Task.
     * @param id The unique ID for the task.
     * @param description A brief description of the task.
     */
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Pending"; // New tasks start as Pending
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // --- Setter for status ---
    public void setStatus(String status) {
        // Basic validation could be added here if needed
        this.status = status;
    }

    /**
     * Returns a string representation of the task.
     * @return Formatted string: [ID] Status: Description
     */
    @Override
    public String toString() {
        return "[" + id + "] Status: " + status + " - " + description;
    }
}

/**
 * Manages the queue of pending tasks and list of completed tasks.
 */
class TaskProcessor {
    // Queue for tasks waiting to be processed (FIFO)
    private Queue<Task> pendingTasksQueue;
    // List for tasks that have been completed
    private List<Task> completedTasksList;
    // Counter for generating unique task IDs
    private int nextTaskId;

    /**
     * Constructs a new TaskProcessor.
     */
    public TaskProcessor() {
        // LinkedList is a common implementation of Queue
        this.pendingTasksQueue = new LinkedList<>();
        // ArrayList is a common implementation of List
        this.completedTasksList = new ArrayList<>();
        this.nextTaskId = 1; // Start IDs from 1
    }

    /**
     * Adds a new task to the pending queue.
     * @param description The description of the task.
     */
    public void addTask(String description) {
        Task newTask = new Task(nextTaskId++, description);
        pendingTasksQueue.offer(newTask); // offer is preferred over add for queues
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task from the pending queue.
     * Moves the task to the completed list upon successful processing.
     * @return The processed Task, or null if the queue was empty.
     */
    public Task processNextTask() {
        Task taskToProcess = pendingTasksQueue.poll(); // poll retrieves and removes the head of the queue
        if (taskToProcess != null) {
            taskToProcess.setStatus("Completed");
            completedTasksList.add(taskToProcess);
            return taskToProcess;
        } else {
            return null; // Indicate no task was processed
        }
    }

    /**
     * Gets an unmodifiable list of pending tasks.
     * @return A List of pending tasks.
     */
    public List<Task> getPendingTasks() {
        // Return a new list or unmodifiable view to prevent external modification of the internal queue state
        // Converting queue to list for display purposes
        return new ArrayList<>(pendingTasksQueue);
    }

    /**
     * Gets an unmodifiable list of completed tasks.
     * @return A List of completed tasks.
     */
    public List<Task> getCompletedTasks() {
        // Return an unmodifiable list to prevent external modification
        return Collections.unmodifiableList(completedTasksList);
    }

    /**
     * Checks if the pending task queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isPendingQueueEmpty() {
        return pendingTasksQueue.isEmpty();
    }
}

/**
 * Main class to run the Task Processing System.
 * Handles user input and orchestrates TaskProcessor operations.
 */
public class TaskSystemApp {

    public static void main(String[] args) {
        // Class-wide try-catch block to catch unexpected exceptions during execution
        try {
            TaskProcessor processor = new TaskProcessor();
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            System.out.println("Task Processing System");

            while (running) {
                System.out.print("Enter command (add <description>, process, view pending, view completed, exit): ");
                // Use nextLine() to read the whole line including spaces
                String inputLine = scanner.nextLine().trim();
                String[] parts = inputLine.split(" ", 2); // Split into command and potentially description

                String command = parts[0].toLowerCase(); // Case-insensitive command matching

                // Use a try-catch block around the switch to catch potential exceptions
                // within command processing (e.g., array index out of bounds if parts[1] is accessed incorrectly)
                try {
                    switch (command) {
                        case "add":
                            if (parts.length > 1 && !parts[1].trim().isEmpty()) {
                                String description = parts[1].trim();
                                processor.addTask(description);
                            } else {
                                System.err.println("Usage: add <description>");
                            }
                            break;

                        case "process":
                            Task processedTask = processor.processNextTask();
                            if (processedTask != null) {
                                System.out.println("Processed task: " + processedTask);
                            } else {
                                System.err.println("No tasks in the queue to process.");
                            }
                            break;

                        case "view":
                            if (parts.length > 1) {
                                String viewType = parts[1].toLowerCase();
                                if (viewType.equals("pending")) {
                                    List<Task> pending = processor.getPendingTasks();
                                    System.out.println("--- Pending Tasks ---");
                                    if (pending.isEmpty()) {
                                        System.out.println("(Queue is empty)");
                                    } else {
                                        for (Task task : pending) {
                                            System.out.println(task);
                                        }
                                    }
                                    System.out.println("---------------------");
                                } else if (viewType.equals("completed")) {
                                    List<Task> completed = processor.getCompletedTasks();
                                    System.out.println("--- Completed Tasks ---");
                                    if (completed.isEmpty()) {
                                        System.out.println("(No completed tasks)");
                                    } else {
                                        for (Task task : completed) {
                                            System.out.println(task);
                                        }
                                    }
                                    System.out.println("-----------------------");
                                } else {
                                    System.err.println("Invalid view type. Use 'pending' or 'completed'.");
                                }
                            } else {
                                System.err.println("Usage: view <pending|completed>");
                            }
                            break;

                        case "exit":
                            running = false;
                            System.out.println("Exiting Task Processing System.");
                            break;

                        default:
                            System.err.println("Unknown command: " + command);
                            break;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Catches errors like accessing parts[1] when only command is given
                    System.err.println("Error processing command arguments: " + e.getMessage());
                    // Optionally print stack trace for debugging during development
                    // e.printStackTrace(System.err);
                } catch (Exception e) {
                    // Catch any other unexpected exceptions during command execution
                    System.err.println("An unexpected error occurred during command execution: " + e.getMessage());
                    // Optionally print stack trace for debugging during development
                    // e.printStackTrace(System.err);
                }
            }

            scanner.close(); // Close the scanner resource

        } catch (Exception e) {
            // This catches any exception that escapes the inner try-catch,
            // providing a last-resort error message before the program terminates.
            System.err.println("A critical error occurred that caused the system to stop: " + e.getMessage());
            // e.printStackTrace(System.err); // Uncomment for detailed error tracing
        }
    }
}
