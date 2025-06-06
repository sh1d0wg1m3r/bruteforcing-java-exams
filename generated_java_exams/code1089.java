/*
 * Exam Question #1089
 * Generated on: 2025-05-12 17:23:19
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Team Task Queue Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple console-based application to help a small team manage their tasks. The system should allow users to add new tasks, process the next task in a queue, and view lists of pending and completed tasks.
 * 
 * **Requirements:**
 * 
 * Implement a Java application that fulfills the following requirements:
 * 
 * 1.  **Task Representation:** Create a class named `Task` with the following private fields:
 *     *   `description` (String): A brief description of the task.
 *     *   `priority` (int): An integer representing the task's priority (e.g., 1 for highest, 5 for lowest).
 *     *   `assignee` (String): The person assigned to the task.
 *     *   Include a constructor, public getter methods for all fields, and an appropriate `toString()` method to display task information.
 * 
 * 2.  **Task Management System:** Create a class named `TaskManager` that orchestrates the application logic.
 *     *   It must use a `java.util.Queue<Task>` to store tasks that are pending processing. Use a `java.util.LinkedList` which implements the `Queue` interface.
 *     *   It must use a `java.util.List<Task>` to store tasks that have been completed. Use a `java.util.ArrayList` which implements the `List` interface.
 *     *   It must use `java.util.Scanner` to read user input from the console.
 * 
 * 3.  **Console Menu:** Implement a main application loop within the `TaskManager` class (e.g., in a `run()` method) that presents the following menu to the user:
 *     ```
 *     --- Task Management Menu ---
 *     1. Add New Task
 *     2. Process Next Task
 *     3. View Pending Tasks
 *     4. View Completed Tasks
 *     5. Exit
 *     Enter your choice: 
 *     ```
 *     Use a `switch` statement to handle the user's menu choice.
 * 
 * 4.  **Menu Option Implementation:**
 *     *   **Add New Task:**
 *         *   Prompt the user for task description, priority, and assignee.
 *         *   Validate the priority input: It must be an integer between 1 and 5 (inclusive). If invalid, display an error message using `System.err` and do not add the task.
 *         *   If input is valid, create a `Task` object and add it to the pending tasks queue.
 *         *   Display a success message using `System.out`.
 *     *   **Process Next Task:**
 *         *   Attempt to retrieve and remove the next task from the pending tasks queue.
 *         *   If the queue is empty, display an error message using `System.err`.
 *         *   If a task is retrieved, add it to the completed tasks list and display a success message using `System.out`, showing the processed task details.
 *     *   **View Pending Tasks:**
 *         *   Iterate through and display all tasks currently in the pending tasks queue using `System.out`. If the queue is empty, display an appropriate message using `System.out`.
 *     *   **View Completed Tasks:**
 *         *   Iterate through and display all tasks currently in the completed tasks list using `System.out`. If the list is empty, display an appropriate message using `System.out`.
 *     *   **Exit:** Terminate the program.
 * 
 * 5.  **Error Handling:**
 *     *   Use `System.err` for all error messages (e.g., invalid menu choice, invalid task priority, attempting to process task when queue is empty).
 *     *   Use `System.out` for all normal output (menu, prompts, success messages, task details, list contents).
 *     *   Implement **class-wide exception handling** using a `try-catch` block within the main application loop (`run` method) to catch potential unexpected exceptions (like `InputMismatchException` if the user enters non-numeric input when a number is expected) and report them gracefully using `System.err`. Ensure the scanner state is handled correctly after an input error.
 * 
 * 6.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Ensure clean code structure.
 * 
 * **Expected Output (Example Interactions):**
 * 
 * ```
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Implement Task Class
 * Enter priority (1-5): 1
 * Enter assignee: Alice
 * Task added: Task{description='Implement Task Class', priority=1, assignee='Alice'}
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Design Menu
 * Enter priority (1-5): 6
 * ERROR: Invalid priority. Priority must be between 1 and 5. Task not added.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 3
 * --- Pending Tasks ---
 * Task{description='Implement Task Class', priority=1, assignee='Alice'}
 * ---------------------
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 2
 * Processed task: Task{description='Implement Task Class', priority=1, assignee='Alice'}
 * Task moved to completed.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 3
 * --- Pending Tasks ---
 * No pending tasks.
 * ---------------------
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 4
 * --- Completed Tasks ---
 * Task{description='Implement Task Class', priority=1, assignee='Alice'}
 * -----------------------
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 2
 * ERROR: No pending tasks to process.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: abc
 * ERROR: Invalid input. Please enter a number.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 5
 * Exiting Task Management System.
 * ```
 * 
 * Your solution should include the `Task` class and the `TaskManager` class (with a `main` method to start the application).
 *
 * EXPLANATION:
 * This solution implements the `Team Task Queue Management System` as required, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **`Task` Class:** A simple POJO (Plain Old Java Object) representing a task. It has private fields (`description`, `priority`, `assignee`), a constructor, public getters, and an overridden `toString()` method for easy printing. This follows encapsulation principles.
 * 
 * 2.  **`TaskManager` Class:** This is the core class managing the application logic.
 *     *   **`pendingTasks`:** Declared as `Queue<Task>` and initialized with a `LinkedList`. `LinkedList` implements the `Queue` interface, providing FIFO (First-In, First-Out) behavior suitable for processing tasks in the order they are added (or a similar queue-based logic). We use `offer()` to add tasks and `poll()` to retrieve and remove the head of the queue, which is safer than `add()` and `remove()` as they throw exceptions on capacity issues or empty queue, respectively, while `offer()` and `poll()` return `boolean`/`null`.
 *     *   **`completedTasks`:** Declared as `List<Task>` and initialized with an `ArrayList`. `ArrayList` is a common implementation of the `List` interface, suitable for storing the history of completed tasks in the order they were finished.
 *     *   **`scanner`:** An instance of `Scanner` is used to read input from `System.in`. It's initialized in the constructor and closed when the application exits.
 * 
 * 3.  **`run()` Method:** This method contains the main application loop (`while(running)`).
 *     *   It repeatedly displays the menu using `displayMenu()`.
 *     *   It reads the user's integer choice using `scanner.nextInt()`.
 *     *   Crucially, `scanner.nextLine()` is called immediately after `scanner.nextInt()` to consume the newline character left in the input buffer. This prevents issues with subsequent `scanner.nextLine()` calls in `addNewTask()`.
 *     *   **Class-wide Exception Handling:** The core logic inside the `while` loop is wrapped in a `try-catch (Exception e)` block. This catches any unexpected runtime errors that might occur during the execution of the menu options. A specific `catch (InputMismatchException e)` is included before the general `Exception` catch to handle cases where the user enters non-numeric input for the menu choice. In case of `InputMismatchException`, an error message is printed to `System.err`, and `scanner.next()` is called to consume the invalid token, preventing an infinite loop. The general `catch` block prints a generic error message to `System.err`.
 * 
 * 4.  **`switch` Statement:** Inside the `run()` method's `try` block, a `switch` statement is used to direct control flow based on the user's integer choice, calling the appropriate private methods (`addNewTask`, `processNextTask`, etc.). The `default` case handles invalid integer choices, printing an error to `System.err`.
 * 
 * 5.  **Menu Option Methods:**
 *     *   **`addNewTask()`:** Prompts for task details. It includes a `while` loop and a `try-catch` block specifically for reading and validating the integer priority input (1-5). If the input is not an integer (`InputMismatchException`) or is outside the valid range, an error is printed to `System.err`, and the loop continues until valid priority is entered. After getting valid input, a `Task` object is created and added to `pendingTasks` using `offer()`. Success is reported via `System.out`.
 *     *   **`processNextTask()`:** Uses `pendingTasks.poll()` to get and remove the next task. If `poll()` returns `null` (queue is empty), an error is printed to `System.err`. Otherwise, the task is added to `completedTasks` and success is reported via `System.out`.
 *     *   **`viewPendingTasks()`:** Iterates through the `pendingTasks` queue using an enhanced for loop and prints each task using `System.out`. Checks if the queue is empty.
 *     *   **`viewCompletedTasks()`:** Iterates through the `completedTasks` list using an enhanced for loop and prints each task using `System.out`. Checks if the list is empty.
 * 
 * 6.  **Input/Output:** `System.out.println()` and `System.out.print()` are used for all normal messages, prompts, and displaying task information. `System.err.println()` is used exclusively for error conditions as required.
 * 
 * 7.  **Best Practices:** The code uses meaningful names (`pendingTasks`, `addNewTask`, `processNextTask`), follows encapsulation with private fields and public getters, includes Javadoc comments for classes and methods, and has a clear structure with separate methods for distinct functionalities. The `Scanner` is closed upon program exit.
 * 
 * This solution effectively integrates `Queue`, `ArrayList` (`List`), `Scanner`, `switch`, `System.out`, `System.err`, and `try-catch` exception handling within a practical, structured program, fulfilling all requirements of the complex exam task.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single task with description, priority, and assignee.
 */
class Task {
    private String description;
    private int priority;
    private String assignee;

    /**
     * Constructs a new Task.
     * @param description The task description.
     * @param priority The task priority (1-5).
     * @param assignee The task assignee.
     */
    public Task(String description, int priority, String assignee) {
        this.description = description;
        this.priority = priority;
        this.assignee = assignee;
    }

    /**
     * Gets the task description.
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the task priority.
     * @return The priority.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Gets the task assignee.
     * @return The assignee.
     */
    public String getAssignee() {
        return assignee;
    }

    @Override
    public String toString() {
        return "Task{" +
               "description='" + description + '\'' +
               ", priority=" + priority +
               ", assignee='" + assignee + '\'' +
               '}';
    }
}

/**
 * Manages a queue of pending tasks and a list of completed tasks.
 * Provides a console interface for task management.
 */
public class TaskManager {
    private Queue<Task> pendingTasks;
    private List<Task> completedTasks;
    private Scanner scanner;

    /**
     * Constructs a TaskManager, initializing task collections and scanner.
     */
    public TaskManager() {
        // Use LinkedList as an implementation of Queue
        this.pendingTasks = new LinkedList<>();
        // Use ArrayList as an implementation of List
        this.completedTasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new task based on user input.
     * Handles input validation for priority.
     */
    private void addNewTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        int priority = -1;
        boolean validPriority = false;
        while (!validPriority) {
            System.out.print("Enter priority (1-5): ");
            try {
                priority = scanner.nextInt();
                if (priority >= 1 && priority <= 5) {
                    validPriority = true;
                } else {
                    System.err.println("ERROR: Invalid priority. Priority must be between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.err.println("ERROR: Invalid input. Please enter an integer for priority.");
                scanner.next(); // Consume the invalid input
            } finally {
                 // Consume the rest of the line after reading the integer
                 // This is important whether nextInt() succeeded or failed
                 if (scanner.hasNextLine()) {
                     scanner.nextLine();
                 }
            }
        }


        System.out.print("Enter assignee: ");
        String assignee = scanner.nextLine();

        Task newTask = new Task(description, priority, assignee);
        pendingTasks.offer(newTask); // offer is generally preferred over add for capacity-constrained queues, though LinkedList is not capacity-constrained
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task from the pending queue and moves it to completed list.
     * Handles empty queue case.
     */
    private void processNextTask() {
        Task nextTask = pendingTasks.poll(); // poll retrieves and removes, returns null if queue is empty

        if (nextTask == null) {
            System.err.println("ERROR: No pending tasks to process.");
        } else {
            completedTasks.add(nextTask);
            System.out.println("Processed task: " + nextTask);
            System.out.println("Task moved to completed.");
        }
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    private void viewPendingTasks() {
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
    private void viewCompletedTasks() {
        System.out.println("--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            // Iterate through the list
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Runs the main task management application loop.
     * Includes class-wide exception handling.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = -1; // Initialize choice outside try block

            try {
                choice = scanner.nextInt();
                // Consume the rest of the line after reading the integer choice
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addNewTask();
                        break;
                    case 2:
                        processNextTask();
                        break;
                    case 3:
                        viewPendingTasks();
                        break;
                    case 4:
                        viewCompletedTasks();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting Task Management System.");
                        break;
                    default:
                        System.err.println("ERROR: Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catches non-integer input for menu choice
                System.err.println("ERROR: Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                // General catch block for any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging details
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the Task Management application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run();
    }
}
