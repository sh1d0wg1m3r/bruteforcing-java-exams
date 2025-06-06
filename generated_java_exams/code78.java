/*
 * Exam Question #78
 * Generated on: 2025-05-11 22:09:57
 * Generated by: Account 4
 * 
 * QUESTION:
 * **Java Programming Exam Task: Simple Team Task Manager**
 * 
 * **Scenario:**
 * You are tasked with developing a simple command-line application for a small team to manage their tasks. Tasks are initially placed in a queue to be processed in a FIFO (First-In, First-Out) manner. Once a task is processed, it is moved to a list of completed tasks.
 * 
 * **Requirements:**
 * 1.  **Task Representation:** Create a class named `Task` with the following attributes:
 *     *   `id` (an integer, unique identifier)
 *     *   `description` (a String)
 *     *   `status` (a String, e.g., "PENDING", "COMPLETED")
 *     *   Implement appropriate getters and methods (e.g., a method to mark the task as completed). Ensure proper encapsulation.
 * 
 * 2.  **Task Management:** Create a class named `TaskManager` responsible for managing the tasks.
 *     *   It must use a `java.util.Queue<Task>` to store pending tasks.
 *     *   It must use a `java.util.List<Task>` (implemented by `java.util.ArrayList`) to store completed tasks.
 *     *   Implement methods:
 *         *   `addTask(String description)`: Creates a new `Task` with a unique ID, sets its status to "PENDING", and adds it to the pending task queue.
 *         *   `processNextTask()`: Retrieves and removes the next task from the pending queue, marks its status as "COMPLETED", and adds it to the completed tasks list. This method should return the completed `Task` object, or `null` if the pending queue is empty.
 *         *   `getPendingTasks()`: Returns a `List` view of the tasks currently in the pending queue.
 *         *   `getCompletedTasks()`: Returns the `List` of completed tasks.
 * 
 * 3.  **User Interface:** Implement a command-line interface in a `main` method (e.g., in a separate class like `TaskApp`) using `java.util.Scanner` for user input. The program should present a menu and accept commands.
 *     *   Supported commands: `add`, `process`, `view_pending`, `view_completed`, `exit`.
 *     *   Use a `switch` statement to handle the different commands.
 *     *   Prompt the user for necessary input (e.g., task description for the `add` command).
 * 
 * 4.  **Output and Error Handling:**
 *     *   Use `System.out` for normal program output (menu, task details, success messages).
 *     *   Use `System.err` to display error messages (e.g., invalid command, attempting to process when the queue is empty, invalid input like an empty description).
 *     *   Implement input validation (e.g., ensure task description is not empty).
 *     *   Implement class-wide exception handling using `try-catch` blocks in the `main` method to catch and report unexpected errors gracefully using `System.err`.
 * 
 * 5.  **Best Practices:**
 *     *   Follow Java coding conventions.
 *     *   Use meaningful variable and method names.
 *     *   Add comments and basic documentation (e.g., Javadoc for classes/methods).
 *     *   Ensure proper encapsulation (`private` fields, `public` methods).
 * 
 * **Execution Flow and Expected Output:**
 * The program should start, display a menu, and wait for user input. Based on the input, it should perform the requested action, display results or errors, and loop until the user enters `exit`.
 * 
 * Example Interaction:
 * ```
 * --- Task Manager Menu ---
 * add - Add a new task
 * process - Process the next pending task
 * view_pending - View all pending tasks
 * view_completed - View all completed tasks
 * exit - Exit the application
 * Enter command: add
 * Enter task description: Implement Task class
 * Task added with ID 1.
 * Enter command: add
 * Enter task description: Create TaskManager
 * Task added with ID 2.
 * Enter command: view_pending
 * Pending Tasks:
 * [Task ID: 1, Description: Implement Task class, Status: PENDING]
 * [Task ID: 2, Description: Create TaskManager, Status: PENDING]
 * Enter command: process
 * Processed task: [Task ID: 1, Description: Implement Task class, Status: COMPLETED]
 * Enter command: view_pending
 * Pending Tasks:
 * [Task ID: 2, Description: Create TaskManager, Status: PENDING]
 * Enter command: view_completed
 * Completed Tasks:
 * [Task ID: 1, Description: Implement Task class, Status: COMPLETED]
 * Enter command: process
 * Processed task: [Task ID: 2, Description: Create TaskManager, Status: COMPLETED]
 * Enter command: process
 * Error: No pending tasks to process.
 * Enter command: view_completed
 * Completed Tasks:
 * [Task ID: 1, Description: Implement Task class, Status: COMPLETED]
 * [Task ID: 2, Description: Create TaskManager, Status: COMPLETED]
 * Enter command: invalid_command
 * Error: Unknown command. Please try again.
 * Enter command: exit
 * Exiting Task Manager.
 * ```
 * 
 * Your solution should provide the complete Java code for the `Task`, `TaskManager`, and the main application class (e.g., `TaskApp`).
 *
 * EXPLANATION:
 * The solution implements a simple task management system demonstrating the required Java concepts.
 * 
 * 1.  **`Task` Class:** This class represents a single task. It has `private` fields (`id`, `description`, `status`) demonstrating encapsulation. Public getter methods provide controlled access to the data. The `markAsCompleted()` method modifies the internal status. The `toString()` method provides a convenient way to print task details.
 * 
 * 2.  **`TaskManager` Class:** This class manages the collections of tasks.
 *     *   `pendingTasks`: Declared as `Queue<Task>` and implemented using `LinkedList`. `LinkedList` is a common choice for implementing `Queue` in Java as it efficiently supports the necessary FIFO operations (`offer` for adding, `poll` for removing from the head).
 *     *   `completedTasks`: Declared as `List<Task>` and implemented using `ArrayList`. `ArrayList` is suitable here as completed tasks are stored and iterated over, and random access isn't a primary requirement, but efficient storage and retrieval are needed.
 *     *   `nextTaskId`: A simple counter to ensure unique IDs for new tasks.
 *     *   `addTask()`: Creates a new `Task` object and uses `pendingTasks.offer()` to add it to the end of the queue. It includes input validation for the description and throws an `IllegalArgumentException` if it's invalid.
 *     *   `processNextTask()`: Uses `pendingTasks.poll()` to retrieve and remove the task at the head of the queue. If the queue is empty, `poll()` returns `null`, which is handled by returning `null` from the method. If a task is retrieved, its status is updated, and it's added to the `completedTasks` list using `completedTasks.add()`.
 *     *   `getPendingTasks()` and `getCompletedTasks()`: These methods return `List` views of the respective collections. Using `Collections.unmodifiableList(new ArrayList<>(...))` creates a new `ArrayList` from the collection and then wraps it in an unmodifiable list. This is a good practice to prevent external code from modifying the internal state of the `TaskManager`'s collections directly, adhering to encapsulation principles.
 * 
 * 3.  **`TaskApp` Class (Main Method):**
 *     *   This class contains the `main` method, which is the application's entry point.
 *     *   It creates instances of `TaskManager` and `Scanner`.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   `printMenu()` displays the available commands using `System.out`.
 *     *   `scanner.nextLine()` reads the user's command.
 *     *   A `switch` statement is used to determine which command was entered and execute the corresponding logic. This fulfills the `switch` requirement for flow control.
 *     *   Each case calls the appropriate `TaskManager` method.
 *     *   Input validation for the `add` command is handled by a `try-catch` block specifically for `IllegalArgumentException` around the `addTask` call, printing the error message to `System.err`.
 *     *   The `process` command checks the return value of `processNextTask()` and prints an error to `System.err` if it's `null` (indicating an empty queue).
 *     *   The `view_pending` and `view_completed` commands retrieve the task lists and iterate through them, printing each task using `System.out`. They also handle the case where the lists are empty.
 *     *   The `default` case in the `switch` handles unknown commands, printing an error to `System.err`.
 *     *   The entire command processing loop within the `main` method is wrapped in a `try-catch (Exception e)` block. This demonstrates "class-wide exception handling" for the primary execution flow of the application, catching any unexpected runtime errors and printing a general error message and the stack trace to `System.err`.
 *     *   A `finally` block ensures the `Scanner` is closed, releasing system resources.
 * 
 * This solution effectively integrates all required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical, object-oriented structure, adhering to best practices like encapsulation, meaningful names, and basic error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Collections; // For unmodifiable list

/**
 * Represents a single task with an ID, description, and status.
 */
class Task {
    private int id;
    private String description;
    private String status; // e.g., "PENDING", "COMPLETED"

    /**
     * Constructs a new Task.
     * @param id The unique identifier for the task.
     * @param description The description of the task.
     */
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "PENDING";
    }

    /**
     * Gets the task ID.
     * @return The task ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the task description.
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the current status of the task.
     * @return The task status ("PENDING" or "COMPLETED").
     */
    public String getStatus() {
        return status;
    }

    /**
     * Marks the task as completed.
     */
    public void markAsCompleted() {
        this.status = "COMPLETED";
    }

    /**
     * Returns a string representation of the task.
     * @return A formatted string describing the task.
     */
    @Override
    public String toString() {
        return "[Task ID: " + id + ", Description: " + description + ", Status: " + status + "]";
    }
}

/**
 * Manages a collection of tasks, separating them into pending and completed lists.
 */
class TaskManager {
    private Queue<Task> pendingTasks;
    private List<Task> completedTasks;
    private int nextTaskId;

    /**
     * Constructs a new TaskManager.
     * Initializes the pending queue, completed list, and task ID counter.
     */
    public TaskManager() {
        // LinkedList implements Queue, suitable for FIFO operations
        this.pendingTasks = new LinkedList<>();
        // ArrayList implements List, suitable for storing completed items
        this.completedTasks = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the pending queue.
     * @param description The description of the new task.
     * @throws IllegalArgumentException if the description is null or empty.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        Task newTask = new Task(nextTaskId++, description.trim());
        pendingTasks.offer(newTask); // offer is preferred over add for queues (returns false if fails)
        System.out.println("Task added with ID " + newTask.getId() + ".");
    }

    /**
     * Processes the next task from the pending queue.
     * Moves the task from pending to completed state.
     * @return The completed Task object, or null if the pending queue was empty.
     */
    public Task processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // poll retrieves and removes the head, returns null if empty
        if (taskToProcess != null) {
            taskToProcess.markAsCompleted();
            completedTasks.add(taskToProcess);
            return taskToProcess;
        }
        return null; // Indicate no task was processed
    }

    /**
     * Gets an unmodifiable list of pending tasks.
     * @return A List containing the pending tasks.
     */
    public List<Task> getPendingTasks() {
        // Return an unmodifiable list to prevent external modification of the queue
        return Collections.unmodifiableList(new ArrayList<>(pendingTasks));
    }

    /**
     * Gets an unmodifiable list of completed tasks.
     * @return A List containing the completed tasks.
     */
    public List<Task> getCompletedTasks() {
        // Return an unmodifiable list to prevent external modification
        return Collections.unmodifiableList(completedTasks);
    }
}

/**
 * Main application class for the Simple Team Task Manager.
 * Handles user interaction and command processing.
 */
public class TaskApp {

    /**
     * Displays the main menu options to the user.
     */
    private static void printMenu() {
        System.out.println("\n--- Task Manager Menu ---");
        System.out.println("add - Add a new task");
        System.out.println("process - Process the next pending task");
        System.out.println("view_pending - View all pending tasks");
        System.out.println("view_completed - View all completed tasks");
        System.out.println("exit - Exit the application");
        System.out.print("Enter command: ");
    }

    /**
     * The main entry point of the Task Manager application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling for the main application loop
        try {
            while (running) {
                printMenu();
                String command = scanner.nextLine().trim().toLowerCase();

                switch (command) {
                    case "add":
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        try {
                            taskManager.addTask(description);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case "process":
                        Task completedTask = taskManager.processNextTask();
                        if (completedTask != null) {
                            System.out.println("Processed task: " + completedTask);
                        } else {
                            System.err.println("Error: No pending tasks to process.");
                        }
                        break;

                    case "view_pending":
                        List<Task> pending = taskManager.getPendingTasks();
                        System.out.println("Pending Tasks:");
                        if (pending.isEmpty()) {
                            System.out.println("No pending tasks.");
                        } else {
                            for (Task task : pending) {
                                System.out.println(task);
                            }
                        }
                        break;

                    case "view_completed":
                        List<Task> completed = taskManager.getCompletedTasks();
                        System.out.println("Completed Tasks:");
                        if (completed.isEmpty()) {
                            System.out.println("No completed tasks.");
                        } else {
                            for (Task task : completed) {
                                System.out.println(task);
                            }
                        }
                        break;

                    case "exit":
                        running = false;
                        System.out.println("Exiting Task Manager.");
                        break;

                    default:
                        System.err.println("Error: Unknown command. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to stderr for debugging
        } finally {
            // Ensure the scanner is closed
            scanner.close();
        }
    }
}
