/*
 * Exam Question #359
 * Generated on: 2025-05-11 23:00:03
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simple Task Management System for processing different types of work items. The system should allow users to add new tasks to a queue, process the next task from the queue, and view the list of pending and completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following attributes:
 *     *   `id` (unique integer, assigned by the system)
 *     *   `type` (character, e.g., 'A', 'B', 'C')
 *     *   `priority` (integer, higher number means higher priority - though the queue processing will be FIFO in this simplified version)
 *     *   `description` (String)
 *     *   Implement appropriate constructors, getters, and a `toString()` method.
 * 
 * 2.  **Task Management Logic:** Create a `TaskManager` class responsible for managing the tasks. It should internally use:
 *     *   A `java.util.Queue` to hold tasks that are waiting to be processed (pending tasks).
 *     *   A `java.util.List` (specifically, a `java.util.ArrayList`) to store tasks that have been processed (completed tasks).
 *     *   Maintain a counter for assigning unique task IDs.
 * 
 * 3.  **Functionality:** The system should provide the following operations via a command-line interface:
 *     *   **Add Task:** Prompt the user for task type, priority, and description. Create a `Task` object and add it to the pending queue. Validate input (e.g., task type is a single character, priority is an integer).
 *     *   **Process Next Task:** Take the task at the front of the pending queue, remove it, and move it to the completed tasks list. Report which task was processed. Handle the case where the queue is empty.
 *     *   **View Pending Tasks:** Display all tasks currently in the pending queue.
 *     *   **View Completed Tasks:** Display all tasks that have been processed.
 *     *   **Exit:** Terminate the program.
 * 
 * 4.  **User Interface:** Use `java.util.Scanner` to read user input for menu choices and task details. Present a clear menu using `System.out`.
 * 
 * 5.  **Control Flow:** Use a `switch` statement to handle the different menu options.
 * 
 * 6.  **Error Handling:**
 *     *   Implement input validation for task details (type, priority). Use `System.err` to print specific error messages for invalid input (e.g., "Invalid task type. Please enter a single character.", "Invalid priority. Please enter an integer.").
 *     *   Use `System.err` to report errors during operations, such as trying to process a task when the queue is empty ("No pending tasks to process.").
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors (e.g., `InputMismatchException` when reading priority) and prevent the program from crashing.
 * 
 * 7.  **Best Practices:**
 *     *   Use private fields and public methods (encapsulation).
 *     *   Use meaningful variable and method names.
 *     *   Include comments where necessary to explain complex logic.
 *     *   Structure the code into appropriate classes (`Task`, `TaskManager`, and a main application class).
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt for input based on the user's choice, and print relevant output or error messages.
 * 
 * *   Menu and normal output should use `System.out`.
 * *   Error messages (invalid input, empty queue processing) should use `System.err`.
 * 
 * Example Interaction Flow:
 * 
 * ```
 * --- Task Management Menu ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task type (e.g., A, B): A
 * Enter priority (integer): 5
 * Enter description: Implement login feature
 * Task added: Task{id=1, type=A, priority=5, description='Implement login feature'}
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 1
 * Enter task type (e.g., A, B): B
 * Enter priority (integer): 3
 * Enter description: Fix styling bug
 * Task added: Task{id=2, type=B, priority=3, description='Fix styling bug'}
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tasks ---
 * Task{id=1, type=A, priority=5, description='Implement login feature'}
 * Task{id=2, type=B, priority=3, description='Fix styling bug'}
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * Processing task: Task{id=1, type=A, priority=5, description='Implement login feature'}
 * Task processed.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tasks ---
 * Task{id=2, type=B, priority=3, description='Fix styling bug'}
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 4
 * --- Completed Tasks ---
 * Task{id=1, type=A, priority=5, description='Implement login feature'}
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * Processing task: Task{id=2, type=B, priority=3, description='Fix styling bug'}
 * Task processed.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 4
 * --- Completed Tasks ---
 * Task{id=1, type=A, priority=5, description='Implement login feature'}
 * Task{id=2, type=B, priority=3, description='Fix styling bug'}
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * No pending tasks to process. (This should be printed to System.err)
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Task Management System.
 * ```
 * 
 * **Constraint:** You must use ALL the Java components listed in the general requirements: `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`.
 *
 * EXPLANATION:
 * This solution implements a simple Task Management System demonstrating the required Java concepts.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents a single task with `id`, `type`, `priority`, and `description`.
 *     *   Uses private fields and public getters for encapsulation.
 *     *   Includes a `toString()` method for easy printing of task details.
 * 
 * 2.  **`TaskManager` Class:**
 *     *   Manages the state of the system: pending and completed tasks.
 *     *   Uses a `Queue<Task>` (`LinkedList` implementation) for `pendingTasks`. `Queue` methods like `offer()` (add) and `poll()` (retrieve and remove from head) are used, adhering to the FIFO nature of a queue.
 *     *   Uses a `List<Task>` (`ArrayList` implementation) for `completedTasks`. `ArrayList` methods like `add()` are used.
 *     *   Maintains `nextTaskId` to ensure unique IDs.
 *     *   `addTask()`: Creates a new `Task` object and adds it to the `pendingTasks` queue.
 *     *   `processNextTask()`: Uses `poll()` to get the next task from the queue. If `poll()` returns `null` (queue is empty), it prints an error to `System.err`. Otherwise, it adds the task to the `completedTasks` list.
 *     *   `getPendingTasks()`: Returns a `List` view of the current pending tasks. It creates a *new* `ArrayList` from the `Queue` elements (`new ArrayList<>(pendingTasks)`) to avoid exposing the internal `Queue` directly, while still fulfilling the requirement of returning a `List`.
 *     *   `getCompletedTasks()`: Returns the internal `completedTasks` list, which is already a `List` (specifically an `ArrayList`).
 *     *   Uses `System.err` in `processNextTask` for the "No pending tasks" error message.
 * 
 * 3.  **`TaskProcessingApp` Class:**
 *     *   Contains the `main` method, serving as the application entry point.
 *     *   Uses `java.util.Scanner` to read user input from `System.in`.
 *     *   The core logic is within a `while(running)` loop.
 *     *   A `switch` statement is used to direct execution based on the user's menu choice.
 *     *   `System.out` is used for displaying the menu, task details, and success messages.
 *     *   `System.err` is used for error messages, including invalid menu choices, invalid input during task creation (type, priority, empty description), and the "No pending tasks" message (delegated to `TaskManager`).
 *     *   **Exception Handling:**
 *         *   A `try-catch(InputMismatchException)` block is used specifically around reading the main menu choice to catch non-integer input.
 *         *   Another nested `try-catch(InputMismatchException)` is used when reading the task priority to handle non-integer input for priority.
 *         *   A broader `catch (Exception e)` block is placed around the main logic within the `while` loop (specifically, the `switch` statement and input reading leading up to it). This demonstrates "class-wide exception handling" by catching unexpected exceptions that might occur during the execution of the main loop's body, printing an error to `System.err`, and allowing the loop to continue, preventing the program from crashing due to unhandled runtime errors. `e.printStackTrace(System.err)` is used to print the stack trace to the error stream for debugging.
 *     *   Input validation is performed for task type (single character), priority (handled by `InputMismatchException` catch), and description (not empty). Error messages for validation failures are printed to `System.err`.
 *     *   Proper resource management is shown by closing the `Scanner` when the application exits.
 * 
 * This solution effectively integrates all required components within a practical scenario, demonstrates proper object-oriented design principles (encapsulation, separation of concerns), and includes robust input validation and error handling using `try-catch` and `System.err`.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single task in the system.
 */
class Task {
    private int id;
    private char type;
    private int priority;
    private String description;

    /**
     * Constructs a new Task.
     * @param id The unique ID of the task.
     * @param type The type of the task (e.g., 'A', 'B').
     * @param priority The priority of the task.
     * @param description A brief description of the task.
     */
    public Task(int id, char type, int priority, String description) {
        this.id = id;
        this.type = type;
        this.priority = priority;
        this.description = description;
    }

    // Getters for task attributes
    public int getId() {
        return id;
    }

    public char getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of the Task.
     * @return A formatted string describing the task.
     */
    @Override
    public String toString() {
        return "Task{" +
               "id=" + id +
               ", type=" + type +
               ", priority=" + priority +
               ", description='" + description + '\'' +
               '}';
    }
}

/**
 * Manages the collection of pending and completed tasks.
 */
class TaskManager {
    // Queue for tasks waiting to be processed (FIFO)
    private Queue<Task> pendingTasks;
    // List for tasks that have been processed
    private List<Task> completedTasks;
    // Counter for assigning unique task IDs
    private int nextTaskId;

    /**
     * Constructs a new TaskManager.
     */
    public TaskManager() {
        // LinkedList is a common implementation for Queue
        this.pendingTasks = new LinkedList<>();
        // ArrayList is a common implementation for List
        this.completedTasks = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the pending queue.
     * Assigns a unique ID to the task.
     * @param type The type of the task.
     * @param priority The priority of the task.
     * @param description The description of the task.
     */
    public void addTask(char type, int priority, String description) {
        Task newTask = new Task(nextTaskId++, type, priority, description);
        pendingTasks.offer(newTask); // offer() is preferred over add() for capacity-constrained queues (though LinkedList is not)
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task from the pending queue.
     * Removes the task from pending and adds it to completed.
     * @return The processed Task object, or null if the queue was empty.
     */
    public Task processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // poll() retrieves and removes the head, returns null if queue is empty
        if (taskToProcess != null) {
            System.out.println("Processing task: " + taskToProcess);
            completedTasks.add(taskToProcess);
            System.out.println("Task processed.");
        } else {
            // Use System.err for error message as required
            System.err.println("No pending tasks to process.");
        }
        return taskToProcess;
    }

    /**
     * Gets a list of tasks currently in the pending queue.
     * Returns a new ArrayList to avoid exposing the internal Queue directly.
     * @return A List of pending tasks.
     */
    public List<Task> getPendingTasks() {
        // Create a new List containing elements from the queue
        // This fulfills the requirement to use List interface and ArrayList
        return new ArrayList<>(pendingTasks);
    }

    /**
     * Gets a list of tasks that have been completed.
     * @return A List of completed tasks.
     */
    public List<Task> getCompletedTasks() {
        // Return the internal completedTasks list (it's already an ArrayList)
        return completedTasks;
    }

    /**
     * Checks if the pending task queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isQueueEmpty() {
        return pendingTasks.isEmpty();
    }

    /**
     * Checks if the completed tasks list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isCompletedListEmpty() {
        return completedTasks.isEmpty();
    }
}

/**
 * Main application class for the Task Management System.
 * Handles user interaction and orchestrates TaskManager operations.
 */
public class TaskProcessingApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean running = true;

        System.out.println("--- Task Management System ---");

        // Main application loop
        while (running) {
            printMenu();

            // Use try-catch for robust input handling within the loop
            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                // Consume the newline character left by nextInt()
                scanner.nextLine();

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1: // Add Task
                        System.out.print("Enter task type (e.g., A, B): ");
                        String typeInput = scanner.nextLine().trim();
                        if (typeInput.length() != 1) {
                            // Use System.err for validation errors
                            System.err.println("Invalid task type. Please enter a single character.");
                            break; // Skip to the next loop iteration
                        }
                        char taskType = typeInput.charAt(0);

                        System.out.print("Enter priority (integer): ");
                        int taskPriority;
                        try {
                            taskPriority = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                        } catch (InputMismatchException e) {
                            // Use System.err for input type errors
                            System.err.println("Invalid priority. Please enter an integer.");
                            scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                            break; // Skip to the next loop iteration
                        }

                        System.out.print("Enter description: ");
                        String taskDescription = scanner.nextLine().trim();
                        if (taskDescription.isEmpty()) {
                            // Use System.err for validation errors
                            System.err.println("Description cannot be empty.");
                            break; // Skip to the next loop iteration
                        }

                        taskManager.addTask(taskType, taskPriority, taskDescription);
                        break;

                    case 2: // Process Next Task
                        taskManager.processNextTask();
                        break;

                    case 3: // View Pending Tasks
                        List<Task> pending = taskManager.getPendingTasks();
                        // Use List interface reference
                        if (pending.isEmpty()) {
                            System.out.println("No pending tasks.");
                        } else {
                            System.out.println("--- Pending Tasks ---");
                            for (Task task : pending) {
                                System.out.println(task); // Uses Task's toString()
                            }
                        }
                        break;

                    case 4: // View Completed Tasks
                        List<Task> completed = taskManager.getCompletedTasks();
                         // Use List interface reference
                        if (completed.isEmpty()) {
                            System.out.println("No completed tasks.");
                        } else {
                            System.out.println("--- Completed Tasks ---");
                            for (Task task : completed) {
                                System.out.println(task); // Uses Task's toString()
                            }
                        }
                        break;

                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting Task Management System.");
                        break;

                    default: // Invalid choice
                        // Use System.err for invalid menu choice
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input for the main menu choice
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                // Broad catch for unexpected errors within the loop, demonstrating class-wide handling
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to error stream
                // The loop continues, allowing the user to try again
            }
            System.out.println(); // Add a newline for better readability between operations
        }

        scanner.close(); // Close the scanner when done
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Task Management Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
    }
}
