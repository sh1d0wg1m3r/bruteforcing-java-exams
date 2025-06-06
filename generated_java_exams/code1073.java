/*
 * Exam Question #1073
 * Generated on: 2025-05-12 17:21:16
 * Generated by: Account 1
 * 
 * QUESTION:
 * **Java Programming Exam Task: Priority Task Management System**
 * 
 * You are tasked with developing a simple console-based Priority Task Management system. This system will allow users to add tasks with different priorities and process high-priority tasks.
 * 
 * Your solution must demonstrate proficiency in core Java concepts, including collections, input handling, control flow, and exception management.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class (can be a static inner class) with the following attributes:
 *     *   `description` (String): The description of the task.
 *     *   `priority` (String): The priority of the task, must be either "HIGH" or "LOW".
 *     *   Implement a constructor, appropriate getters, and a `toString()` method that clearly displays the task (e.g., `[PRIORITY] Description`).
 * 
 * 2.  **Task Manager Logic:** Create a `TaskManager` class that manages the tasks. It should use the following data structures:
 *     *   A `java.util.Queue<Task>` to store high-priority tasks. When a task is added, if it's high priority, it should be added to this queue. When processing, the task at the front of the queue is removed.
 *     *   A `java.util.List<Task>` (using `java.util.ArrayList`) to store low-priority tasks. Low-priority tasks are simply added to this list. Processing only applies to high-priority tasks in this system.
 * 
 * 3.  **User Interaction:** The `TaskManager` class should contain a `run()` method that implements a console-based user interface using `java.util.Scanner`. The system should present a menu with the following options:
 *     *   1. Add New Task
 *     *   2. Process Next High Priority Task
 *     *   3. View All High Priority Tasks
 *     *   4. View All Low Priority Tasks
 *     *   5. Exit
 * 
 * 4.  **Core Functionality:**
 *     *   **Add New Task:** Prompt the user for the task description and priority (HIGH/LOW). Add the task to the appropriate collection based on priority.
 *     *   **Process Next High Priority Task:** Remove and display the task at the front of the high-priority queue.
 *     *   **View All High Priority Tasks:** Display all tasks currently in the high-priority queue without removing them.
 *     *   **View All Low Priority Tasks:** Display all tasks currently in the low-priority list.
 * 
 * 5.  **Required Java Components Usage:** Ensure your solution explicitly uses ALL of the following:
 *     *   `java.util.Queue`
 *     *   `java.util.ArrayList`
 *     *   `java.util.List` (declared as the interface type)
 *     *   `java.util.Scanner` (for user input)
 *     *   `switch` statement (for menu navigation)
 *     *   `System.err` (for displaying error messages)
 *     *   `System.out` (for displaying normal output, menu, task lists, success messages)
 *     *   Class-wide exception handling with `try-catch` blocks (e.g., around the main interaction loop or critical operations).
 * 
 * 6.  **Best Practices:**
 *     *   Implement proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments for complex parts.
 *     *   Implement input validation (e.g., check for empty task description, invalid priority, non-numeric menu choice). Report validation errors using `System.err`.
 *     *   Implement proper error handling (e.g., attempting to process a task when the queue is empty). Report these errors using `System.err`.
 *     *   Structure the code cleanly.
 *     *   Ensure the `Scanner` resource is closed properly.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, presenting a menu, accepting user input, performing the requested actions, and displaying results or error messages. Example interactions might look like:
 * 
 * ```
 * Task Manager System
 * 1. Add New Task
 * 2. Process Next High Priority Task
 * 3. View All High Priority Tasks
 * 4. View All Low Priority Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Write exam question
 * Enter priority (HIGH/LOW): HIGH
 * High priority task added: Write exam question
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 1
 * Enter task description: Grade exams
 * Enter priority (HIGH/LOW): LOW
 * Low priority task added: Grade exams
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 3
 * --- High Priority Tasks ---
 * 1. [HIGH] Write exam question
 * ---------------------------
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 4
 * --- Low Priority Backlog ---
 * 1. [LOW] Grade exams
 * ----------------------------
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 2
 * Processing task: Write exam question (Priority: HIGH)
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 3
 * No high-priority tasks in the queue.
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 2
 * No high-priority tasks to process.
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: invalid
 * Invalid input. Please enter a number.
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 1
 * Enter task description:
 * Enter priority (HIGH/LOW): HIGH
 * Error: Task description cannot be empty.
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 1
 * Enter task description: Test system
 * Enter priority (HIGH/LOW): URGENT
 * Error: Invalid priority. Use 'HIGH' or 'LOW'.
 * 
 * 1. Add New Task
 * ...
 * Enter your choice: 5
 * Exiting Task Manager. Goodbye!
 * Scanner closed.
 * ```
 * 
 * Your solution should be provided as a single Java file containing the `TaskManager` class and the `Task` class (as a static inner class or separate class if preferred, but single file is fine for exam).
 *
 * EXPLANATION:
 * This solution implements a simple Priority Task Management system demonstrating the required Java concepts.
 * 
 * 1.  **`Task` Class:** A private static inner class `Task` is used to encapsulate the data for each task (description and priority). It includes a constructor with basic validation for description and priority, getters for accessing the data, and an overridden `toString()` method for easy printing. Using a static inner class is appropriate here as a `Task` doesn't need access to the `TaskManager`'s instance members.
 * 
 * 2.  **`TaskManager` Class:** This is the main class containing the application logic.
 *     *   **Data Structures:** It uses a `java.util.Queue<Task>` (`highPriorityQueue`) implemented by `java.util.LinkedList` for high-priority tasks (FIFO behavior) and a `java.util.List<Task>` (`lowPriorityBacklog`) implemented by `java.util.ArrayList` for low-priority tasks. Using the `List` interface type for `lowPriorityBacklog` fulfills that requirement.
 *     *   **`Scanner`:** A `java.util.Scanner` is used for reading user input from the console. It's managed using a try-with-resources block in the `run()` method to ensure it's automatically closed, preventing resource leaks.
 *     *   **`run()` Method:** This method contains the main application loop.
 *         *   It displays a menu using `System.out`.
 *         *   It reads the user's choice using the `Scanner`.
 *         *   **Input Validation:** It includes a check (`scanner.hasNextInt()`) to ensure the user enters a number for the menu choice, consuming invalid input and printing an error to `System.err`. It also consumes the leftover newline character after reading the integer choice (`scanner.nextLine()`).
 *         *   **`switch` Statement:** A `switch` statement is used to direct the program flow based on the user's valid menu choice.
 *         *   **`try-catch` Blocks:**
 *             *   An inner `try-catch` block is placed around the `switch` statement's body to catch any unexpected runtime exceptions that might occur during the execution of the chosen operation (e.g., a bug in a method).
 *             *   An outer `try-catch` block is placed around the entire `while` loop and scanner initialization within the `run()` method. This serves as the "class-wide" exception handling, catching critical errors that might prevent the main loop from starting or continuing. Both catch blocks print error messages to `System.err`.
 *         *   **`finally` Block:** Although the try-with-resources handles the `Scanner` closure, a `finally` block (or just a statement after the try-with-resources) can be used for final cleanup messages or actions.
 *     *   **Helper Methods (`addTask`, `processNextHighPriorityTask`, `viewHighPriorityTasks`, `viewLowPriorityTasks`):** These private methods encapsulate the specific logic for each menu option.
 *         *   `addTask` validates the input description and priority by delegating to the `Task` constructor's validation. It uses `queue.offer()` for adding to the queue (safer than `add()`) and `list.add()` for the list. It reports errors via `System.err`.
 *         *   `processNextHighPriorityTask` uses `queue.poll()` to remove and retrieve the head of the queue, handling the case where the queue is empty by checking for a `null` result and reporting to `System.err`.
 *         *   `viewHighPriorityTasks` and `viewLowPriorityTasks` iterate over their respective collections (`Queue` and `List`) using enhanced for loops to display the tasks. They check if the collections are empty and print informative messages using `System.out` or `System.err` as appropriate (informational messages about empty lists go to `System.out`, errors about failed operations due to emptiness go to `System.err`).
 * 
 * 3.  **Error Handling and Validation:**
 *     *   Input validation for the menu choice prevents `InputMismatchException`.
 *     *   Validation for task description and priority is done in the `Task` constructor (throwing `IllegalArgumentException`) and handled in the `addTask` method, printing errors to `System.err`.
 *     *   Operations on potentially empty collections (`highPriorityQueue.poll()`) are checked, and error messages are printed to `System.err` if the operation cannot be performed.
 *     *   The layered `try-catch` structure in `run()` provides robust error handling, catching both predictable issues within operations (handled by checks and specific `catch` blocks or reported by methods) and unpredictable runtime exceptions.
 * 
 * 4.  **Best Practices:** The code uses private fields and public methods (`run`, `main`) for encapsulation, meaningful names, comments explaining the purpose of classes and methods, and standard Java collection practices. `System.out` is used for normal program output (menu, task lists, success messages), while `System.err` is reserved for reporting errors and warnings.
 * 
 * This solution effectively combines the required Java components and best practices to create a functional and robust console application within a practical task management context.
 */

import java.util.Queue;
import java.util.LinkedList; // Common implementation for Queue
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale; // Good practice for case-insensitive comparison

/**
 * A simple Priority Task Management System.
 * Manages tasks with HIGH or LOW priority using a Queue for high priority
 * and a List for low priority.
 */
public class TaskManager {

    // --- Required Data Structures ---
    private Queue<Task> highPriorityQueue;
    private List<Task> lowPriorityBacklog;

    // --- Required Input Component ---
    private Scanner scanner;

    /**
     * Static inner class representing a Task.
     * Encapsulates task details.
     */
    private static class Task {
        private String description;
        private String priority; // "HIGH" or "LOW"

        /**
         * Constructs a new Task.
         * @param description The task description.
         * @param priority The task priority ("HIGH" or "LOW").
         * @throws IllegalArgumentException if description is null/empty or priority is invalid.
         */
        public Task(String description, String priority) {
            if (description == null || description.trim().isEmpty()) {
                throw new IllegalArgumentException("Task description cannot be empty.");
            }
            String upperPriority = priority.toUpperCase(Locale.US); // Use Locale.US for consistent casing
            if (!upperPriority.equals("HIGH") && !upperPriority.equals("LOW")) {
                 throw new IllegalArgumentException("Invalid priority: " + priority + ". Use 'HIGH' or 'LOW'.");
            }
            this.description = description.trim();
            this.priority = upperPriority;
        }

        public String getDescription() {
            return description;
        }

        public String getPriority() {
            return priority;
        }

        /**
         * Provides a string representation of the task.
         * @return Formatted string: [PRIORITY] Description.
         */
        @Override
        public String toString() {
            return "[" + priority + "] " + description;
        }
    }

    /**
     * Constructs a new TaskManager, initializing the collections.
     */
    public TaskManager() {
        // Initialize required collections
        this.highPriorityQueue = new LinkedList<>(); // LinkedList implements Queue
        this.lowPriorityBacklog = new ArrayList<>(); // ArrayList implements List
        // Scanner is initialized in the run method using try-with-resources for safety
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Manager Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next High Priority Task");
        System.out.println("3. View All High Priority Tasks");
        System.out.println("4. View All Low Priority Tasks");
        System.out.println("5. Exit");
        System.out.println("-------------------------");
    }

    /**
     * Adds a new task to the appropriate collection based on priority.
     * Performs basic input validation.
     * @param description The task description.
     * @param priority The task priority string.
     */
    private void addTask(String description, String priority) {
        try {
            Task newTask = new Task(description, priority); // Task constructor validates description and priority

            if (newTask.getPriority().equals("HIGH")) {
                // offer() is generally preferred over add() for queues as it handles capacity restrictions (though LinkedList doesn't have them)
                if (highPriorityQueue.offer(newTask)) {
                    System.out.println("Successfully added high priority task: " + newTask.getDescription());
                } else {
                    // This case is unlikely with LinkedList but good practice
                    System.err.println("Failed to add high priority task (queue might be full).");
                }
            } else { // Priority is LOW
                lowPriorityBacklog.add(newTask);
                System.out.println("Successfully added low priority task: " + newTask.getDescription());
            }
        } catch (IllegalArgumentException e) {
            // Catch validation errors from Task constructor
            System.err.println("Error adding task: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected errors during task creation/addition
            System.err.println("An unexpected error occurred while adding task: " + e.getMessage());
        }
    }

    /**
     * Processes (removes) the next task from the high-priority queue.
     */
    private void processNextHighPriorityTask() {
        // poll() is preferred over remove() as it returns null if the queue is empty
        Task processedTask = highPriorityQueue.poll();

        if (processedTask == null) {
            System.err.println("No high-priority tasks to process.");
        } else {
            System.out.println("Processing task: " + processedTask.getDescription() + " (Priority: " + processedTask.getPriority() + ")");
            // In a real system, you might move this to a 'completed' list here
        }
    }

    /**
     * Displays all tasks currently in the high-priority queue without removing them.
     */
    private void viewHighPriorityTasks() {
        if (highPriorityQueue.isEmpty()) {
            System.out.println("No high-priority tasks in the queue.");
        } else {
            System.out.println("--- High Priority Tasks ---");
            // Iterating over a Queue using a for-each loop is possible and does not remove elements
            int index = 1;
            for (Task task : highPriorityQueue) {
                System.out.println(index++ + ". " + task); // Task.toString() is called implicitly
            }
            System.out.println("---------------------------");
        }
    }

    /**
     * Displays all tasks currently in the low-priority backlog list.
     */
    private void viewLowPriorityTasks() {
        if (lowPriorityBacklog.isEmpty()) {
            System.out.println("No low-priority tasks in the backlog.");
        } else {
            System.out.println("--- Low Priority Backlog ---");
            int index = 1;
            for (Task task : lowPriorityBacklog) {
                System.out.println(index++ + ". " + task); // Task.toString() is called implicitly
            }
            System.out.println("----------------------------");
        }
    }

    /**
     * Runs the main interactive loop of the Task Manager system.
     * Includes input handling, menu navigation using a switch statement,
     * and class-wide exception handling.
     */
    public void run() {
        // Using try-with-resources ensures the scanner is closed automatically
        try (Scanner inputScanner = new Scanner(System.in)) {
            this.scanner = inputScanner; // Assign to the class field

            System.out.println("--- Welcome to the Task Manager System ---");

            int choice = -1; // Initialize choice outside the loop

            // Main interaction loop
            while (choice != 5) {
                displayMenu();
                System.out.print("Enter your choice: ");

                // --- Input Validation for Menu Choice ---
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid input. Please enter a number corresponding to the menu options.");
                    scanner.next(); // Consume the invalid input (e.g., a string)
                    continue; // Skip the rest of the loop and show menu again
                }

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // --- Class-wide Exception Handling (around the core operations) ---
                try {
                    // --- Switch statement for menu navigation ---
                    switch (choice) {
                        case 1: // Add Task
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine();
                            System.out.print("Enter priority (HIGH/LOW): ");
                            String priority = scanner.nextLine(); // Case-insensitive check handled in addTask/Task constructor
                            addTask(description, priority);
                            break;
                        case 2: // Process High Priority Task
                            processNextHighPriorityTask();
                            break;
                        case 3: // View High Priority Tasks
                            viewHighPriorityTasks();
                            break;
                        case 4: // View Low Priority Tasks
                            viewLowPriorityTasks();
                            break;
                        case 5: // Exit
                            System.out.println("Exiting Task Manager. Goodbye!");
                            break;
                        default:
                            // Handle choices outside the valid range (1-5)
                            System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (Exception e) {
                    // This catch block handles any unexpected runtime exceptions
                    // that might occur within the switch cases, preventing the program from crashing.
                    System.err.println("An unexpected error occurred during operation: " + e.getMessage());
                    // Optionally print stack trace for debugging: e.printStackTrace();
                }
                System.out.println(); // Add a blank line for better readability between interactions
            }

        } catch (Exception e) {
            // This outer catch block handles exceptions that might occur during the setup
            // of the scanner or the main loop initialization itself.
            System.err.println("A critical system error occurred: " + e.getMessage());
            // e.printStackTrace();
        } finally {
             // The try-with-resources for scanner handles closing, but a final message is good.
             // The scanner variable 'inputScanner' is only in scope within the try block.
             // The class field 'this.scanner' might still hold a reference if needed elsewhere,
             // but with try-with-resources, the resource itself is managed.
             // Let's add a final confirmation message.
             System.out.println("System shutdown complete.");
        }
    }

    /**
     * Main method to start the Task Manager application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run();
    }
}
