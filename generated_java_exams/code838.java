/*
 * Exam Question #838
 * Generated on: 2025-05-12 16:48:47
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Objective:** Design and implement a console-based Task Management System that demonstrates a strong understanding of core Java data structures, control flow, user interaction, and error handling.
 * 
 * **Scenario:** You are building a simple system to manage a list of tasks. New tasks are added to a queue to await processing. Once a task is processed, it is moved to a list of completed tasks. The system provides a menu interface for user interaction.
 * 
 * **Requirements:**
 * 
 * Your solution must utilize **ALL** of the following Java components:
 * 
 * 1.  `java.util.Queue`: To store tasks that are pending processing, ensuring they are processed in the order they were added (First-In, First-Out).
 * 2.  `java.util.ArrayList`: As a concrete implementation of the `List` interface to store tasks that have been completed.
 * 3.  `java.util.List`: Declare your completed tasks collection using the `List` interface type.
 * 4.  `java.util.Scanner`: To read user input from the console for menu selection and task details.
 * 5.  `switch` statement: To navigate the different menu options.
 * 6.  `System.err`: To display all error messages (e.g., invalid input, attempting an operation on an empty collection).
 * 7.  `System.out`: To display normal output (menu, prompts, success messages, task lists).
 * 8.  Class-wide exception handling with `try-catch` blocks: To gracefully handle potential runtime errors, particularly related to user input.
 * 
 * **Implementation Details & Best Practices:**
 * 
 * *   Create a `Task` class to represent a single task. This class should have private fields for the task description (String) and its completion status (boolean). Provide a constructor, public getter methods, and a method to mark the task as completed. Implement a `toString()` method for easy display.
 * *   Create a main class (e.g., `TaskManagementSystem`) containing the `main` method. This class will manage the `Queue` of pending tasks and the `List` of completed tasks.
 * *   Implement methods within the main class for each menu option: adding a task, processing the next task, viewing pending tasks, and viewing completed tasks.
 * *   Ensure proper encapsulation: collections and internal state should be private.
 * *   Use meaningful variable and method names.
 * *   Include appropriate comments and documentation (e.g., Javadoc for classes and methods).
 * *   Implement input validation: Handle cases where the user enters non-numeric input for menu choices, or attempts to add a task with an empty description.
 * *   Implement proper error handling: Display informative error messages using `System.err` when operations cannot be performed (e.g., processing from an empty queue) or when input is invalid. Use `try-catch` around the main input loop to handle exceptions like `InputMismatchException`.
 * 
 * **Menu Options:**
 * 
 * 1.  **Add New Task:** Prompts the user for a task description and adds a new `Task` object to the pending queue.
 * 2.  **Process Next Pending Task:** Removes the task from the front of the pending queue, marks it as completed, and adds it to the completed list. If the pending queue is empty, display an error message on `System.err`.
 * 3.  **View Pending Tasks:** Displays all tasks currently in the pending queue, in the order they will be processed.
 * 4.  **View Completed Tasks:** Displays all tasks currently in the completed list.
 * 5.  **Exit:** Terminates the application.
 * 
 * **Expected Output:**
 * 
 * The system should interact with the user via the console, displaying a menu, prompts, and task lists. Error messages should be clearly distinguishable using `System.err`. The flow should match the example interaction provided in the problem description planning phase (see thought block above for an example).
 * 
 * Your solution should be a single, complete Java program file.
 *
 * EXPLANATION:
 * This solution implements a simple Task Management System satisfying all the specified requirements.
 * 
 * 1.  **Data Structures (`Queue`, `List`, `ArrayList`):**
 *     *   A `java.util.Queue<Task>` named `pendingTasks` is used to hold tasks awaiting processing. `java.util.LinkedList` is chosen as the concrete implementation because it efficiently supports the necessary queue operations (`offer` to add to the end, `poll` to remove from the front).
 *     *   A `java.util.List<Task>` named `completedTasks` is used to store tasks once they are finished. `java.util.ArrayList` is used as the concrete implementation, suitable for storing and iterating over completed items.
 * 
 * 2.  **User Interaction (`Scanner`, `switch`):**
 *     *   A `java.util.Scanner` object is used to read input from `System.in`. It reads the user's menu choice (`nextInt()`) and task descriptions (`nextLine()`). Note the necessary `scanner.nextLine()` call after `nextInt()` to consume the leftover newline character.
 *     *   A `switch` statement in the `run()` method efficiently directs the program flow based on the integer input received for the menu choice, executing the corresponding task management operation.
 * 
 * 3.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` and `System.out.print()` are used for all standard output: displaying the menu, prompting for input, confirming successful operations (like adding or processing a task), and listing pending or completed tasks.
 *     *   `System.err.println()` is exclusively used for displaying error messages, such as when an invalid menu choice is entered, when non-integer input is provided, when a task description is empty, or when attempting to process a task from an empty queue. This clearly separates error output from normal program output.
 * 
 * 4.  **Error Handling (`try-catch`, Input Validation):**
 *     *   A primary `try-catch` block wraps the core menu loop logic within the `run()` method. This block specifically catches `InputMismatchException`, which occurs if the user enters non-integer input when an integer (the menu choice) is expected. It also includes a general `catch (Exception e)` to handle any other unforeseen runtime errors that might occur during the loop's execution, printing an error message to `System.err`.
 *     *   Inside the `addTask` method, a `try-catch` block is used to handle the `IllegalArgumentException` that the `Task` constructor throws if the provided description is null or empty. This demonstrates handling exceptions originating from object creation logic.
 *     *   Input validation is performed for the menu choice (checked in the `switch`'s `default` case and by the `InputMismatchException` handler) and for the task description (validated in the `Task` constructor).
 *     *   The `processNextTask()` method explicitly checks if `pendingTasks.isEmpty()` before attempting to `poll()`, preventing errors and printing a specific message to `System.err` if the queue is empty.
 * 
 * 5.  **Object-Oriented Design & Best Practices:**
 *     *   A separate `Task` class encapsulates the data (description, completion status) and behavior (marking as completed) related to a single task. Fields are private, and access/modification is via public methods (getters and `markAsCompleted`). The `toString()` method provides a user-friendly representation.
 *     *   The `TaskManagementSystem` class manages the overall application state (`pendingTasks`, `completedTasks`, `scanner`) and logic. Its collections are private, accessed and modified only through its public methods (`addTask`, `processNextTask`, `viewPendingTasks`, `viewCompletedTasks`, `run`).
 *     *   Variable names (`pendingTasks`, `completedTasks`, `description`, `isCompleted`, `choice`) and method names (`addTask`, `processNextTask`, `viewPendingTasks`, `displayMenu`, `run`) are descriptive and indicate their purpose.
 *     *   Javadoc comments are included for classes and methods, explaining their purpose, parameters, and return values or exceptions. Inline comments explain specific logic points (like consuming the newline after `nextInt()`).
 *     *   The code is structured logically, with the main application loop in `run()` and helper methods for specific operations and menu display. Resources like the `Scanner` are closed when no longer needed.
 * 
 * This solution effectively integrates the required Java components into a functional, well-structured, and robust application, demonstrating advanced concepts like appropriate data structure selection, exception handling strategies, and adherence to object-oriented principles and best practices.
 */

import java.util.Queue;
import java.util.LinkedList; // Concrete implementation for Queue
import java.util.List;
import java.util.ArrayList; // Concrete implementation for List
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single task in the system.
 * Encapsulates task description and completion status.
 */
class Task { // Using default package for simplicity in single-file exam answer
    private String description;
    private boolean isCompleted;

    /**
     * Constructs a new Task.
     * Validates that the description is not null or empty.
     *
     * @param description The description of the task.
     * @throws IllegalArgumentException if the description is null or empty.
     */
    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        this.description = description.trim();
        this.isCompleted = false; // Initially not completed
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
     * @return true if completed, false otherwise.
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Marks the task as completed.
     */
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    /**
     * Returns a string representation of the task,
     * indicating its completion status.
     * @return String representation including description and status.
     */
    @Override
    public String toString() {
        return "[" + (isCompleted ? "X" : " ") + "] " + description;
    }
}

/**
 * Manages a collection of tasks, separating them into pending (Queue)
 * and completed (List). Provides a menu-driven interface for user interaction.
 * Includes class-wide exception handling.
 */
public class TaskManagementSystem {

    // Use LinkedList as a concrete implementation for the Queue interface
    private Queue<Task> pendingTasks;

    // Use ArrayList as a concrete implementation for the List interface
    private List<Task> completedTasks;

    private Scanner scanner; // Scanner for user input

    /**
     * Constructs a new TaskManagementSystem, initializing collections and scanner.
     */
    public TaskManagementSystem() {
        pendingTasks = new LinkedList<>(); // Initialize Queue
        completedTasks = new ArrayList<>(); // Initialize List
        scanner = new Scanner(System.in); // Initialize Scanner
    }

    /**
     * Adds a new task to the pending queue.
     * Handles potential errors during Task creation (e.g., empty description).
     *
     * @param description The description of the task.
     */
    public void addTask(String description) {
        try {
            Task newTask = new Task(description);
            pendingTasks.offer(newTask); // Use offer() for adding to queue (safe add)
            System.out.println("Task added: \"" + description + "\"");
        } catch (IllegalArgumentException e) {
            // Catch exception from Task constructor for invalid description
            System.err.println("Error adding task: " + e.getMessage());
        }
    }

    /**
     * Processes the next task in the pending queue (FIFO).
     * Removes the task from pending, marks it complete, and adds to completed list.
     * Displays an error on System.err if the pending queue is empty.
     */
    public void processNextTask() {
        if (pendingTasks.isEmpty()) {
            System.err.println("Error: No pending tasks to process.");
            return; // Exit method if queue is empty
        }

        // poll() retrieves and removes the head of the queue, returns null if empty
        Task nextTask = pendingTasks.poll();

        if (nextTask != null) {
            nextTask.markAsCompleted();
            completedTasks.add(nextTask);
            System.out.println("Processed task: \"" + nextTask.getDescription() + "\"");
        } else {
            // This case should ideally not be reached due to the isEmpty check,
            // but handles the theoretical null return of poll() defensively.
             System.err.println("Internal error: Failed to retrieve task from queue.");
        }
    }

    /**
     * Displays all pending tasks currently in the queue.
     * Iterates without removing elements.
     */
    public void viewPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            int index = 1;
            // Iterating directly is fine for viewing elements in order
            for (Task task : pendingTasks) {
                System.out.println(index++ + ". " + task);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Displays all completed tasks currently in the list.
     * Iterates through the list.
     */
    public void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            int index = 1;
            for (Task task : completedTasks) {
                System.out.println(index++ + ". " + task);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Pending Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main task management application loop.
     * Contains the primary try-catch block for class-wide exception handling,
     * particularly for user input errors.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = -1; // Default invalid choice

            // Try-catch block for handling potential exceptions during input and processing
            try {
                // Read integer input for menu choice
                choice = scanner.nextInt();
                // Consume the newline character left by nextInt()
                scanner.nextLine();

                // Use switch statement to perform actions based on user choice
                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        addTask(description); // Call method to add task
                        break;
                    case 2:
                        processNextTask(); // Call method to process next task
                        break;
                    case 3:
                        viewPendingTasks(); // Call method to view pending tasks
                        break;
                    case 4:
                        viewCompletedTasks(); // Call method to view completed tasks
                        break;
                    case 5:
                        System.out.println("Exiting Task Management System. Goodbye!");
                        running = false; // Set flag to exit the loop
                        break;
                    default:
                        // Handle choices outside the expected range (1-5)
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handle the specific case where the user enters non-integer input
                System.err.println("Invalid input. Please enter a number.");
                // Consume the invalid input from the scanner to prevent an infinite loop
                scanner.next();
            } catch (Exception e) {
                 // Catch any other unexpected exceptions that might occur within the loop
                 // This provides a layer of robustness for unforeseen issues.
                 System.err.println("An unexpected error occurred: " + e.getMessage());
                 // For debugging, e.printStackTrace() could be added here.
            }
        }
        // Close the scanner resource when the application exits
        scanner.close();
    }

    /**
     * Main method, the entry point of the application.
     * Creates a TaskManagementSystem instance and starts the run loop.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        system.run(); // Start the application loop
    }
}
