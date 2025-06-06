/*
 * Exam Question #77
 * Generated on: 2025-05-11 22:09:37
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Project Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application to manage tasks for a small project team. The system needs to keep track of all tasks, distinguishing between high-priority and normal-priority tasks. High-priority tasks should be processed in the order they were added.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` that represents a single task. Each `Task` must have:
 *     *   A private `String` field for the task description.
 *     *   A private `enum` field for the task priority. Define an `enum` called `Priority` with two values: `HIGH` and `NORMAL`.
 *     *   A constructor to initialize the description and priority.
 *     *   Public getter methods for the description and priority.
 *     *   Override the `toString()` method to provide a user-friendly string representation of the task (e.g., "[HIGH] Complete documentation").
 * 
 * 2.  **Task Manager:** Create a class named `TaskManager` that will manage the tasks. This class must:
 *     *   Contain a private field to store *all* tasks added to the system. This field must be declared using the `java.util.List` interface and initialized with a `java.util.ArrayList`.
 *     *   Contain a private field to store only the *high-priority* tasks awaiting processing. This field must be declared using the `java.util.Queue` interface and initialized with a `java.util.LinkedList` (which implements `Queue`). High-priority tasks should be processed in First-In, First-Out (FIFO) order.
 *     *   Contain a private `java.util.Scanner` field for reading user input.
 *     *   Implement a public method, e.g., `run()`, that provides a menu-driven interface to the user via the console. The menu should offer the following options:
 *         1.  **Add Task:** Prompt the user to enter a task description and priority (as a string "HIGH" or "NORMAL"). Create a `Task` object. Add the task to the main task list. If the priority is `HIGH`, also add it to the high-priority queue.
 *         2.  **View All Tasks:** Display all tasks currently stored in the main task list, along with their index number (starting from 1).
 *         3.  **Process High Priority Task:** Remove and display the task at the head of the high-priority queue. If the queue is empty, display an appropriate error message.
 *         4.  **Exit:** Terminate the program.
 *     *   Use a `switch` statement within the `run()` method to handle the user's menu choice.
 *     *   Use `System.out` for printing the menu, prompts, successful operation messages, and task lists.
 *     *   Use `System.err` for printing all error messages (e.g., invalid menu choice, invalid priority input, attempting to process from an empty high-priority queue).
 *     *   Implement robust exception handling using `try-catch` blocks within the `TaskManager` class to gracefully handle potential issues such as:
 *         *   `InputMismatchException` when the user enters non-integer input for the menu choice.
 *         *   `IllegalArgumentException` if the user enters an invalid string for the task priority.
 *         *   Any other unexpected runtime errors.
 *     *   Ensure proper resource management, particularly closing the `Scanner` when the program exits.
 *     *   Adhere to Java best practices: proper encapsulation (private fields, public methods), meaningful variable and method names, appropriate comments and documentation (basic level is sufficient for exam), input validation, proper error handling, and clean code structure.
 * 
 * 3.  **Main Class:** Create a main class (e.g., `ExamTask`) with a `main` method that instantiates `TaskManager` and calls its `run()` method to start the application.
 * 
 * **Expected Output:**
 * 
 * Your program should provide an interactive command-line interface. Examples of expected interactions include:
 * 
 * *   Displaying the menu.
 * *   Prompting for input.
 * *   Adding tasks with different priorities.
 * *   Viewing the full list of tasks.
 * *   Attempting to process a high-priority task when the queue is empty (should print an error to `System.err`).
 * *   Successfully processing a high-priority task (should print a message to `System.out`).
 * *   Handling invalid integer input for menu choices (should print an error to `System.err`).
 * *   Handling invalid priority string input when adding a task (should print an error to `System.err`).
 * *   Exiting the program cleanly.
 * 
 * **Note:** The entire solution code (all classes) should be provided within a single code block for submission.
 *
 * EXPLANATION:
 * This solution provides a simple command-line Task Management System as required by the problem. It demonstrates the use of various core Java concepts and collections.
 * 
 * 1.  **`Priority` Enum:** Defines the two possible priority levels for tasks (`HIGH` and `NORMAL`), making the code more readable and preventing invalid priority values.
 * 
 * 2.  **`Task` Class:**
 *     *   Encapsulates the data for a single task (`description` and `priority`) using private fields.
 *     *   Provides a constructor for creating `Task` objects.
 *     *   Includes public getter methods (`getDescription`, `getPriority`) to access the private data.
 *     *   Overrides `toString()` to provide a clear string representation, which is useful for printing task details.
 * 
 * 3.  **`TaskManager` Class:**
 *     *   Manages the collections of tasks and the user interaction logic.
 *     *   **Collections:**
 *         *   `allTasks`: Declared as `List<Task>` and initialized with `ArrayList<Task>`. This list stores *all* tasks added, allowing easy iteration and viewing of the complete list. `ArrayList` provides dynamic resizing and efficient access by index.
 *         *   `highPriorityQueue`: Declared as `Queue<Task>` and initialized with `LinkedList<Task>`. `LinkedList` implements the `Queue` interface, providing FIFO behavior. This queue is specifically used to manage high-priority tasks that need processing in order of submission. The `Queue` interface methods (`offer`, `poll`) are used for adding and removing elements from the head.
 *     *   **`Scanner`:** An instance is used to read input from `System.in`. It's a private field and is closed when the application exits to release system resources.
 *     *   **`addTask(String description, Priority priority)`:** Creates a new `Task` object. It's added to `allTasks` unconditionally. If the priority is `HIGH`, it's also added to the `highPriorityQueue` using `offer()`.
 *     *   **`viewAllTasks()`:** Iterates through the `allTasks` `List` using a standard `for` loop with an index to display each task along with its list number. It checks if the list is empty before attempting to print.
 *     *   **`processNextHighPriorityTask()`:** Uses `highPriorityQueue.poll()` to retrieve and remove the task at the front of the queue. `poll()` is preferred over `remove()` or `element()` here because it returns `null` if the queue is empty, allowing for a graceful check without throwing an exception. An error message is printed to `System.err` if the queue is empty. Otherwise, the processed task is printed to `System.out`.
 *     *   **`printMenu()`:** A helper method to display the available options to the user.
 *     *   **`run()`:** This is the main control loop of the application.
 *         *   It displays the menu, reads the user's choice using the `Scanner`.
 *         *   A `switch` statement directs the program flow based on the user's integer input.
 *         *   **Exception Handling:**
 *             *   A large `try-catch` block wraps the core logic inside the `while` loop.
 *             *   It specifically catches `InputMismatchException` if the user enters non-integer input for the menu choice. In this case, an error is printed to `System.err`, and `scanner.nextLine()` is called to consume the invalid input from the buffer, preventing an infinite loop.
 *             *   Inside the "Add Task" case, a nested `try-catch` block handles `IllegalArgumentException`. This exception is thrown by `Priority.valueOf(priorityStr)` if the input string doesn't match "HIGH" or "NORMAL". An error message is printed to `System.err`.
 *             *   A general `catch (Exception e)` block is included as a fallback to catch any other unexpected runtime errors, printing an error message and the stack trace to `System.err` for debugging.
 *         *   The loop continues until the user enters '4' to exit.
 *         *   Finally, `scanner.close()` is called to release the system resource associated with the `Scanner`.
 *     *   **Best Practices:** The code uses private fields, public methods for interaction, meaningful names (`allTasks`, `highPriorityQueue`, `addTask`), comments explaining key parts, and separates concerns into different methods. Input validation (checking for valid integer, valid priority string) and error handling (`try-catch`, `System.err`) are implemented.
 * 
 * 4.  **`ExamTask` Class:**
 *     *   Contains the standard `main` method, the entry point of the application.
 *     *   It simply creates an instance of `TaskManager` and calls its `run()` method to start the interactive session.
 * 
 * This solution effectively integrates `List` (`ArrayList`), `Queue` (`LinkedList`), `Scanner`, `switch`, `System.out`, `System.err`, and `try-catch` blocks within a practical, menu-driven application, fulfilling all the requirements of the complex exam task.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Enum for Task Priority
enum Priority {
    HIGH, NORMAL
}

// Class representing a single Task
class Task {
    private String description;
    private Priority priority;

    /**
     * Constructs a new Task.
     * @param description The description of the task.
     * @param priority The priority of the task (HIGH or NORMAL).
     */
    public Task(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
    }

    /**
     * Gets the description of the task.
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the priority of the task.
     * @return The task priority.
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Returns a string representation of the task.
     * @return Formatted string including priority and description.
     */
    @Override
    public String toString() {
        return "[" + priority + "] " + description;
    }
}

// Class managing tasks
class TaskManager {
    // List to store all tasks (uses ArrayList implementing List)
    private List<Task> allTasks;
    // Queue to store high priority tasks for FIFO processing (uses LinkedList implementing Queue)
    private Queue<Task> highPriorityQueue;
    // Scanner for user input
    private Scanner scanner;

    /**
     * Constructs a TaskManager, initializing collections and scanner.
     */
    public TaskManager() {
        allTasks = new ArrayList<>();
        highPriorityQueue = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task to the system.
     * Adds to allTasks list and conditionally to highPriorityQueue.
     * @param description The task description.
     * @param priority The task priority.
     */
    private void addTask(String description, Priority priority) {
        Task newTask = new Task(description, priority);
        allTasks.add(newTask); // Add to the list of all tasks
        if (priority == Priority.HIGH) {
            highPriorityQueue.offer(newTask); // Add to the high priority queue if HIGH
        }
        System.out.println("Task added: " + newTask);
    }

    /**
     * Displays all tasks currently in the system.
     */
    private void viewAllTasks() {
        if (allTasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n--- All Tasks ---");
            // Iterate and print tasks with their index
            for (int i = 0; i < allTasks.size(); i++) {
                System.out.println((i + 1) + ". " + allTasks.get(i));
            }
            System.out.println("-----------------");
        }
    }

    /**
     * Processes (removes and displays) the next high priority task from the queue.
     * Prints an error to System.err if the queue is empty.
     */
    private void processNextHighPriorityTask() {
        // Use poll() which returns null if queue is empty, avoiding exception
        Task taskToProcess = highPriorityQueue.poll();
        if (taskToProcess == null) {
            System.err.println("Error: No high priority tasks in the queue to process.");
        } else {
            System.out.println("Processing high priority task: " + taskToProcess);
            // In a real system, you might move this to a 'completed' list or similar
        }
    }

    /**
     * Prints the main menu to the console.
     */
    private void printMenu() {
        System.out.println("\n--- Task Manager Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Process High Priority Task");
        System.out.println("4. Exit");
        System.out.println("-------------------------");
    }

    /**
     * Runs the main application loop, handling user input and menu choices.
     * Includes comprehensive exception handling.
     */
    public void run() {
        int choice = -1;
        // Loop until the user chooses to exit (option 4)
        while (choice != 4) {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt(); // Read integer choice
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1: // Add Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter priority (HIGH/NORMAL): ");
                        String priorityStr = scanner.nextLine().trim().toUpperCase(); // Read priority string, trim, convert to uppercase

                        try {
                            // Attempt to convert string to Priority enum
                            Priority priority = Priority.valueOf(priorityStr);
                            addTask(description, priority); // Call method to add task
                        } catch (IllegalArgumentException e) {
                            // Catch if the entered string does not match an enum constant
                            System.err.println("Error: Invalid priority entered. Please enter HIGH or NORMAL.");
                        }
                        break;

                    case 2: // View All Tasks
                        viewAllTasks(); // Call method to view tasks
                        break;

                    case 3: // Process High Priority Task
                        processNextHighPriorityTask(); // Call method to process queue
                        break;

                    case 4: // Exit
                        System.out.println("Exiting Task Manager. Goodbye!");
                        break;

                    default:
                        // Handle choices outside the valid range 1-4
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                // Handle non-integer input for the menu choice
                System.err.println("Error: Invalid input. Please enter a number for the menu choice.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to an invalid value to continue the loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions during execution
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to stderr for debugging
            }
            System.out.println(); // Add a blank line for better readability between interactions
        }
        scanner.close(); // Close the scanner when the program exits
    }
}

// Main class to start the application
public class ExamTask {
    public static void main(String[] args) {
        // Create an instance of TaskManager and run the application
        TaskManager manager = new TaskManager();
        manager.run();
    }
}
