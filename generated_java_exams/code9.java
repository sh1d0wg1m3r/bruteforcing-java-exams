/*
 * Exam Question #9
 * Generated on: 2025-05-11 21:30:20
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Objective:** Design and implement a simple command-line based Task Management System that allows users to add tasks, view pending tasks, process the next task, and view completed tasks. This task is designed to test your understanding and practical application of core Java collections, control flow, user input handling, and exception management.
 * 
 * **Scenario:** You are building a simplified system for managing tasks in a small team. Tasks arrive and are placed in a queue for processing. Once a task is processed, it is moved to a list of completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:**
 *     *   Create a `Task` class with the following private fields:
 *         *   `String description`: A brief description of the task.
 *         *   `int priority`: An integer representing the task's priority (e.g., 1 for High, 2 for Medium, 3 for Low).
 *     *   Include a constructor to initialize these fields.
 *     *   Provide public getter methods for both fields.
 *     *   Override the `toString()` method to provide a user-friendly representation of the task (e.g., "Task: [Description] (Priority: [Priority])").
 * 
 * 2.  **Task Management Logic:**
 *     *   Create a `TaskManager` class.
 *     *   This class must maintain two private collections:
 *         *   A `Queue<Task>` to store tasks that are pending processing. Use a suitable implementation of the `Queue` interface.
 *         *   A `List<Task>` to store tasks that have been completed. Use a suitable implementation of the `List` interface.
 *     *   Implement the following public methods in `TaskManager`:
 *         *   `addTask(String description, int priority)`: Adds a new `Task` to the pending queue. **Validate the priority:** it must be between 1 and 3 (inclusive). If invalid, print an error message to `System.err` and do not add the task.
 *         *   `processNextTask()`: Removes the task from the front of the pending queue, prints a success message to `System.out`, and adds it to the completed tasks list. If the pending queue is empty, print an error message to `System.err`.
 *         *   `displayPendingTasks()`: Prints all tasks currently in the pending queue to `System.out`, in the order they would be processed. Indicate if the queue is empty.
 *         *   `displayCompletedTasks()`: Prints all tasks currently in the completed tasks list to `System.out`. Indicate if the list is empty.
 * 
 * 3.  **User Interface:**
 *     *   Implement a `main` method (can be in a separate class or within `TaskManager`) that provides a command-line interface.
 *     *   Use `java.util.Scanner` to read user input.
 *     *   Present a menu with the following options:
 *         1.  Add New Task
 *         2.  View Pending Tasks
 *         3.  Process Next Task
 *         4.  View Completed Tasks
 *         5.  Exit
 *     *   Use a `switch` statement to handle the user's choice.
 *     *   The program should loop, presenting the menu until the user chooses to exit.
 * 
 * 4.  **Error Handling:**
 *     *   Implement robust input validation for the priority when adding a task (as specified in Requirement 2).
 *     *   Handle the case where the user tries to process a task when the pending queue is empty (as specified in Requirement 2).
 *     *   Use `try-catch` blocks to handle potential exceptions during user input (e.g., `InputMismatchException` if the user enters non-integer input where an integer is expected, like priority or menu choice). Print error messages to `System.err` and guide the user to re-enter valid input.
 *     *   Use `System.out` for normal program output (menu, task lists, success messages).
 *     *   Use `System.err` for all error messages.
 * 
 * 5.  **Best Practices:**
 *     *   Follow principles of encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments to explain complex logic or important sections.
 *     *   Maintain a clean and readable code structure.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt for user input, and display relevant information or error messages based on the user's actions. Examples:
 * 
 * ```
 * Task Management Menu:
 * 1. Add New Task
 * 2. View Pending Tasks
 * 3. Process Next Task
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Implement feature X
 * Enter task priority (1-3): 1
 * Task added successfully.
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 2
 * --- Pending Tasks ---
 * Task: Implement feature X (Priority: 1)
 * ---------------------
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 3
 * Processed task: Task: Implement feature X (Priority: 1)
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 4
 * --- Completed Tasks ---
 * Task: Implement feature X (Priority: 1)
 * -----------------------
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 3
 * Error: No tasks in the pending queue to process.
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: invalid
 * Error: Invalid input. Please enter a number between 1 and 5.
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 5
 * Exiting Task Management System.
 * ```
 * 
 * Your solution should be a single Java file containing all necessary classes.
 *
 * EXPLANATION:
 * This solution implements a simple Task Management System fulfilling all the specified requirements.
 * 
 * 1.  **`Task` Class:** This class serves as a simple Plain Old Java Object (POJO) to represent a task. It encapsulates the `description` (String) and `priority` (int) fields using the `private` access modifier, providing public getter methods (`getDescription`, `getPriority`) for controlled access. The `toString()` method is overridden to provide a convenient way to print task details.
 * 
 * 2.  **`TaskManager` Class:** This class is the core of the system's logic.
 *     *   It uses a `Queue<Task>` (`pendingTasks`) implemented by `LinkedList` to store tasks waiting to be processed. The `Queue` interface naturally supports the FIFO (First-In, First-Out) behavior required for processing tasks in the order they are added (unless priority-based processing was implemented, which wasn't a requirement here).
 *     *   It uses a `List<Task>` (`completedTasks`) implemented by `ArrayList` to store tasks after they are processed. `ArrayList` is suitable here as completed tasks are simply added and potentially viewed sequentially; no specific ordering or fast removal from the middle is needed.
 *     *   The `addTask` method demonstrates input validation by checking if the provided `priority` is within the acceptable range (1-3). If not, it prints an error to `System.err` and prevents the task from being added.
 *     *   The `processNextTask` method uses `pendingTasks.poll()` to retrieve and remove the head of the queue. It checks if `poll()` returned `null` (indicating an empty queue) and prints an error to `System.err` if so. Otherwise, it adds the processed task to the `completedTasks` list and prints a success message to `System.out`.
 *     *   `displayPendingTasks` and `displayCompletedTasks` methods iterate through their respective collections and print the details of each task using the `Task` class's `toString()` method. They also handle the case where the collections are empty.
 * 
 * 3.  **`TaskManagementSystem` (Main Class):**
 *     *   The `main` method sets up the user interface loop.
 *     *   A `Scanner` is used to read input from `System.in`.
 *     *   A `while` loop keeps the program running until the user chooses to exit.
 *     *   A `printMenu` helper method displays the available options.
 *     *   A `switch` statement is used to direct the program flow based on the user's integer input for the menu choice. This clearly separates the logic for each command.
 * 
 * 4.  **Error Handling:**
 *     *   Input validation for priority is done within the `addTask` method.
 *     *   Handling of processing an empty queue is done within the `processNextTask` method by checking the return value of `poll()`.
 *     *   `try-catch` blocks are used to handle `InputMismatchException` which occurs if the user enters non-integer input when an integer is expected (for menu choice or priority). The `catch` block prints an error message to `System.err` and, importantly, consumes the invalid input line using `scanner.nextLine()` to prevent an infinite loop caused by the scanner repeatedly trying to parse the same invalid token.
 *     *   A general `catch (Exception e)` is included in the main loop to catch any other unexpected runtime errors, printing a generic error message to `System.err` and the stack trace for debugging.
 *     *   `System.out` is used for all successful operations and informational messages (menu, task lists). `System.err` is strictly used for error conditions.
 * 
 * 5.  **Best Practices:**
 *     *   Encapsulation is demonstrated by making fields private and providing public methods.
 *     *   Variable and method names (`pendingTasks`, `processNextTask`, `displayCompletedTasks`, etc.) are descriptive.
 *     *   Comments explain the purpose of classes, methods, and important logic sections.
 *     *   The code is structured into logical classes (`Task`, `TaskManager`) and the main execution flow is clear in `main`.
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, demonstrating good object-oriented design principles, input handling, and error management.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a single task with description and priority
class Task {
    private String description;
    private int priority;

    /**
     * Constructs a new Task.
     * @param description The description of the task.
     * @param priority The priority of the task (1-3).
     */
    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
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
     * Provides a user-friendly string representation of the task.
     * @return String representation of the task.
     */
    @Override
    public String toString() {
        return "Task: " + description + " (Priority: " + priority + ")";
    }
}

// Manages the collection of pending and completed tasks
class TaskManager {
    // Queue for tasks waiting to be processed (FIFO)
    private Queue<Task> pendingTasks;
    // List for tasks that have been completed
    private List<Task> completedTasks;

    /**
     * Constructs a new TaskManager, initializing the task collections.
     */
    public TaskManager() {
        // LinkedList is a common implementation of Queue
        this.pendingTasks = new LinkedList<>();
        // ArrayList is a common implementation of List
        this.completedTasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the pending queue after validating priority.
     * @param description The task description.
     * @param priority The task priority.
     */
    public void addTask(String description, int priority) {
        // Validate priority range
        if (priority < 1 || priority > 3) {
            System.err.println("Error: Invalid priority. Priority must be between 1 and 3.");
            return; // Do not add the task
        }
        Task newTask = new Task(description, priority);
        pendingTasks.offer(newTask); // offer() is preferred over add() for capacity-constrained queues, though LinkedList is not capacity-constrained. It's good practice.
        System.out.println("Task added successfully.");
    }

    /**
     * Processes the next task in the queue.
     * Removes the task from pending and adds it to completed.
     */
    public void processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // poll() retrieves and removes the head, returns null if empty

        if (taskToProcess == null) {
            System.err.println("Error: No tasks in the pending queue to process.");
        } else {
            completedTasks.add(taskToProcess);
            System.out.println("Processed task: " + taskToProcess);
        }
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    public void displayPendingTasks() {
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
     * Displays all tasks currently in the completed tasks list.
     */
    public void displayCompletedTasks() {
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
}

// Main class to run the Task Management System
public class TaskManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean running = true;

        System.out.println("Welcome to the Task Management System!");

        // Main application loop
        while (running) {
            printMenu();

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt(); // Read integer choice
                scanner.nextLine(); // Consume newline left-over after nextInt()

                // Use a switch statement to handle user options
                switch (choice) {
                    case 1: // Add New Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();

                        int priority = -1; // Default invalid value
                        boolean validPriorityInput = false;
                        // Loop for valid priority input
                        while (!validPriorityInput) {
                            System.out.print("Enter task priority (1-3): ");
                            try {
                                priority = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                validPriorityInput = true; // Input is an integer
                            } catch (InputMismatchException e) {
                                System.err.println("Error: Invalid input. Please enter a number for priority.");
                                scanner.nextLine(); // Consume the invalid input line
                            }
                        }
                        // addTask handles priority validation (1-3)
                        taskManager.addTask(description, priority);
                        break;

                    case 2: // View Pending Tasks
                        taskManager.displayPendingTasks();
                        break;

                    case 3: // Process Next Task
                        taskManager.processNextTask();
                        break;

                    case 4: // View Completed Tasks
                        taskManager.displayCompletedTasks();
                        break;

                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting Task Management System.");
                        break;

                    default: // Invalid menu choice
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input for the main menu choice
                System.err.println("Error: Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // Consume the invalid input line to prevent infinite loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging
            }
            System.out.println(); // Add a blank line for readability
        }

        scanner.close(); // Close the scanner when the program exits
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("Task Management Menu:");
        System.out.println("1. Add New Task");
        System.out.println("2. View Pending Tasks");
        System.out.println("3. Process Next Task");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
    }
}
