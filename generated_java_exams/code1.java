/*
 * Exam Question #1
 * Generated on: 2025-05-11 21:12:02
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Manufacturing Process Manager
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified Process Management System for a small manufacturing line. The system should manage tasks that need to be processed sequentially. Tasks arrive and are placed in a waiting queue. A worker can pick up the next task from the queue to start processing it. Once processing is complete, the task is marked as finished and moved to a list of completed tasks. The system should provide a command-line interface for interaction.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use `java.util.Queue` to manage tasks waiting to be processed.
 *     *   Use `java.util.ArrayList` to store tasks that have been completed.
 *     *   Declare the completed tasks collection using the `java.util.List` interface.
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Implement a menu-driven interface with the following options:
 *         1.  Add New Task: Prompt the user for a task description and add it to the waiting queue.
 *         2.  Start Next Task: Remove the next task from the queue and mark it as "IN_PROGRESS". Only one task can be in progress at a time.
 *         3.  Complete Current Task: Mark the task currently "IN_PROGRESS" as "COMPLETED" and move it to the list of completed tasks.
 *         4.  View Task Queue: Display all tasks currently in the waiting queue without removing them.
 *         5.  View Completed Tasks: Display all tasks that have been completed.
 *         6.  Exit: Terminate the program.
 * 3.  **Control Flow:**
 *     *   Use a `switch` statement to handle the user's menu choice.
 * 4.  **Output:**
 *     *   Use `System.out.println()` for normal output (menu, prompts, task details, success messages).
 *     *   Use `System.err.println()` for error messages (e.g., invalid input, trying to start a task when one is already in progress, trying to complete a task when none is in progress, trying to start a task when the queue is empty).
 * 5.  **Exception Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle unexpected runtime errors during the main execution loop.
 *     *   Specifically handle `InputMismatchException` when reading integer input.
 * 6.  **Task Representation:**
 *     *   Create a `Task` class with private fields for a unique ID (auto-generated), description, and status (e.g., "QUEUED", "IN_PROGRESS", "COMPLETED"). Provide appropriate public methods (getters, setters, constructor, `toString`).
 * 7.  **Best Practices:**
 *     *   Implement proper encapsulation (private fields, public methods) in the `Task` and the main management class.
 *     *   Use meaningful variable and method names.
 *     *   Include basic comments or JavaDocs for clarity.
 *     *   Implement input validation (e.g., check for empty task description, handle non-integer input for menu choice).
 *     *   Ensure proper resource management (e.g., close the `Scanner`).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept user input, perform the requested actions, and print relevant messages to `System.out` or `System.err` based on the outcome. Example interaction snippets might look like:
 * 
 * ```
 * --- Process Management System ---
 * 1. Add New Task
 * ...
 * Enter your choice: 1
 * Enter task description: Calibrate Machine A
 * Added task to queue: Calibrate Machine A
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: 4
 * --- Task Queue ---
 * Task [ID=1, Description='Calibrate Machine A', Status='QUEUED']
 * ------------------
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: 2
 * Started processing task: Calibrate Machine A (ID: 1)
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: 2
 * Error: A task is already in progress (ID: 1). Complete it first.
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: 3
 * Completed task: Calibrate Machine A (ID: 1)
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: 5
 * --- Completed Tasks ---
 * Task [ID=1, Description='Calibrate Machine A', Status='COMPLETED']
 * -----------------------
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: 3
 * Error: No task is currently in progress to complete.
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: 7
 * Invalid choice. Please enter a number between 1 and 6.
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: abc
 * Invalid input. Please enter a number.
 * 
 * --- Process Management System ---
 * ...
 * Enter your choice: 6
 * Exiting Process Management System. Goodbye!
 * ```
 * 
 * Your solution should be a complete, runnable Java program.
 *
 * EXPLANATION:
 * The solution implements a `ProcessManager` class that simulates a basic manufacturing process queue.
 * 
 * 1.  **`Task` Class:** Represents the data structure for a single task. It includes `id`, `description`, and `status`. A static counter `nextId` ensures unique IDs. Encapsulation is achieved by making fields private and providing public getters and setters. The `toString()` method provides a convenient way to print task details.
 * 
 * 2.  **`ProcessManager` Class:**
 *     *   **Data Structures:**
 *         *   `taskQueue`: A `Queue<Task>` implemented using `LinkedList`. Tasks are added to the queue when created (`offer`) and removed from the head when processing starts (`poll`).
 *         *   `completedTasks`: A `List<Task>` implemented using `ArrayList`. Completed tasks are moved from the `currentTask` slot to this list (`add`).
 *         *   `currentTask`: A `Task` reference to hold the single task currently being processed. This is `null` when no task is in progress.
 *     *   **`Scanner`:** An instance of `Scanner` is used to read user input from `System.in`. It is initialized in the constructor and closed in the `finally` block of the `run` method to release system resources.
 *     *   **Methods:**
 *         *   `addTask(String description)`: Creates a new `Task` and adds it to the `taskQueue` using `offer`. Includes basic validation for the description.
 *         *   `startNextTask()`: Checks if a task is already in progress. If not, it attempts to `poll` the next task from `taskQueue`. If successful, it sets the `currentTask` and updates its status. If the queue is empty or a task is already in progress, an error message is printed to `System.err`.
 *         *   `completeCurrentTask()`: Checks if a `currentTask` exists. If so, it updates its status to "COMPLETED", adds it to the `completedTasks` list, and sets `currentTask` to `null`. If no task is in progress, an error message is printed to `System.err`.
 *         *   `viewQueue()`: Iterates through the `taskQueue` using `forEach` (or a standard loop) to print the details of waiting tasks without removing them.
 *         *   `viewCompletedTasks()`: Iterates through the `completedTasks` list using a standard enhanced for loop to print the details of finished tasks.
 *         *   `displayMenu()`: A private helper method to print the menu options to `System.out`.
 *     *   **`run()` Method:** This is the main execution loop of the system.
 *         *   It contains a `while` loop that continues until the user chooses to exit.
 *         *   **Class-wide Exception Handling:** The entire `while` loop is wrapped in a `try-catch(Exception e)` block. This handles any unexpected runtime exception that might occur within the loop's execution, printing an error message to `System.err` and the stack trace before potentially terminating the program (or exiting the loop if the exception is caught).
 *         *   **Input Handling & Validation:** Inside the loop, there's a specific `try-catch(InputMismatchException e)` block around reading the integer choice. This specifically catches cases where the user enters non-integer input, prints an error to `System.err`, consumes the invalid input using `scanner.nextLine()`, and uses `continue` to restart the loop iteration, preventing a crash.
 *         *   **`switch` Statement:** The user's valid integer choice is processed using a `switch` statement, directing control to the appropriate method calls.
 *         *   **Error Messages:** State checks within methods (`startNextTask`, `completeCurrentTask`, `addTask`) print specific error messages to `System.err` when operations cannot be performed (e.g., queue empty, task in progress).
 *         *   **`finally` Block:** A `finally` block ensures that `scanner.close()` is called when the `try` block is exited, whether normally (by choosing exit) or due to an exception, releasing the system resource.
 * 
 * 3.  **`main` Method:** The standard entry point that creates an instance of `ProcessManager` and calls its `run()` method to start the system.
 * 
 * This solution effectively demonstrates the use of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and robust exception handling within a practical, encapsulated class structure, fulfilling all the requirements of the problem.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single task in the manufacturing process.
 */
class Task {
    private static int nextId = 1; // Static counter for unique task IDs
    private int id;
    private String description;
    private String status; // e.g., "QUEUED", "IN_PROGRESS", "COMPLETED"

    /**
     * Constructs a new Task with a description.
     * ID is automatically generated and status is set to QUEUED.
     * @param description The description of the task.
     */
    public Task(String description) {
        this.id = nextId++;
        this.description = description;
        this.status = "QUEUED"; // Initial status
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

    // --- Setter ---
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Task.
     * @return A formatted string detailing the task.
     */
    @Override
    public String toString() {
        return "Task [ID=" + id + ", Description='" + description + "', Status='" + status + "']";
    }
}

/**
 * Manages the manufacturing process tasks using a queue and a list.
 */
public class ProcessManager {

    private Queue<Task> taskQueue; // Queue for tasks waiting to be processed
    private List<Task> completedTasks; // List for completed tasks (declared as List, implemented by ArrayList)
    private Task currentTask; // Task currently being processed
    private Scanner scanner; // Scanner for user input

    /**
     * Constructs a new ProcessManager, initializing data structures and scanner.
     */
    public ProcessManager() {
        this.taskQueue = new LinkedList<>(); // LinkedList is a common implementation of Queue
        this.completedTasks = new ArrayList<>(); // ArrayList is a common implementation of List
        this.currentTask = null; // No task initially in progress
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task to the waiting queue.
     * @param description The description of the task.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }
        Task newTask = new Task(description.trim());
        // offer() is preferred over add() in queues as it returns false on failure
        // rather than throwing an exception in capacity-constrained queues.
        taskQueue.offer(newTask);
        System.out.println("Added task to queue: " + newTask.getDescription());
    }

    /**
     * Starts processing the next task from the queue.
     * Moves task from queue to 'in progress' state.
     */
    public void startNextTask() {
        if (currentTask != null) {
            System.err.println("Error: A task is already in progress (ID: " + currentTask.getId() + "). Complete it first.");
            return;
        }

        // poll() retrieves and removes the head of the queue, returns null if empty
        Task nextTask = taskQueue.poll();
        if (nextTask == null) {
            System.err.println("Error: The task queue is empty. No tasks to start.");
            return;
        }

        currentTask = nextTask;
        currentTask.setStatus("IN_PROGRESS");
        System.out.println("Started processing task: " + currentTask.getDescription() + " (ID: " + currentTask.getId() + ")");
    }

    /**
     * Marks the current task as completed and moves it to the completed list.
     */
    public void completeCurrentTask() {
        if (currentTask == null) {
            System.err.println("Error: No task is currently in progress to complete.");
            return;
        }

        currentTask.setStatus("COMPLETED");
        completedTasks.add(currentTask); // Add to the list of completed tasks
        System.out.println("Completed task: " + currentTask.getDescription() + " (ID: " + currentTask.getId() + ")");
        currentTask = null; // Clear the current task slot
    }

    /**
     * Displays all tasks currently in the waiting queue.
     */
    public void viewQueue() {
        System.out.println("\n--- Task Queue ---");
        if (taskQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            // Using forEach with lambda/method reference for concise printing
            taskQueue.forEach(System.out::println);
        }
        System.out.println("------------------\n");
    }

    /**
     * Displays all tasks that have been completed.
     */
    public void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks have been completed yet.");
        } else {
            // Iterate through the list
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
        System.out.println("-----------------------\n");
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Process Management System ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Start Next Task");
        System.out.println("3. Complete Current Task");
        System.out.println("4. View Task Queue");
        System.out.println("5. View Completed Tasks");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * The main method to run the process management system.
     * Contains the main loop and class-wide exception handling.
     */
    public void run() {
        boolean exit = false;

        // Class-wide exception handling wrapping the core execution loop
        try {
            while (!exit) {
                displayMenu();
                int choice = -1; // Default invalid choice

                // Specific try-catch for handling non-integer input
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop and show menu again
                }

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        addTask(description);
                        break;
                    case 2:
                        startNextTask();
                        break;
                    case 3:
                        completeCurrentTask();
                        break;
                    case 4:
                        viewQueue();
                        break;
                    case 5:
                        viewCompletedTasks();
                        break;
                    case 6:
                        System.out.println("Exiting Process Management System. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            }
        } catch (Exception e) {
            // Catch any other unexpected runtime exceptions during the process flow
            System.err.println("An unexpected error occurred during system operation: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging unexpected errors
        } finally {
            // Ensure the scanner resource is closed when the program terminates
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed.");
            }
        }
    }

    /**
     * The entry point of the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ProcessManager manager = new ProcessManager();
        manager.run(); // Start the process management system
    }
}
