/*
 * Exam Question #826
 * Generated on: 2025-05-12 16:46:50
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Task Management System
 * 
 * **Scenario:** You are tasked with building a simplified task management system. The system should allow users to add new tasks, process the next task in a queue, and view lists of both pending and processed tasks. This system needs to demonstrate your understanding of core Java collections, I/O, control flow, and exception handling in a practical context.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` with private fields for a unique task ID (an integer) and a task description (a String). Include a constructor and public getter methods for these fields. Override the `toString()` method to provide a user-friendly representation of a task (e.g., "Task [ID=X, Description='...']").
 * 2.  **Task Processing Logic:** Create a class named `TaskProcessor`.
 *     *   This class must manage two collections:
 *         *   A queue (`java.util.Queue`) to hold tasks that are waiting to be processed.
 *         *   A list (`java.util.List`, specifically implemented using `java.util.ArrayList`) to store tasks that have been processed.
 *     *   Include the following public methods:
 *         *   `addTask(String description)`: Creates a new `Task` object with a unique ID (incrementing for each new task) and the given description, then adds it to the pending task queue. Print a confirmation message to `System.out` showing the added task. Implement input validation: if the description is empty or null, print an error to `System.err` and do not add the task.
 *         *   `processNextTask()`: Removes the next task from the head of the pending queue and adds it to the processed tasks list. Print a confirmation message to `System.out` showing the processed task. Implement error handling: if the pending queue is empty, print an error message to `System.err` and do not attempt to process.
 *         *   `getPendingTasks()`: Returns a `List` containing all tasks currently in the pending queue.
 *         *   `getProcessedTasks()`: Returns a `List` containing all tasks that have been processed.
 *     *   Ensure proper encapsulation by keeping collection fields private and returning copies or immutable views of the lists to prevent external modification (returning new `ArrayList` instances containing the current elements is acceptable for this problem).
 * 3.  **User Interface:** Create a main application class (e.g., `TaskSystemApp`) with a `main` method.
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Implement a command-line interface that presents a menu and accepts numerical commands:
 *         1.  Add New Task: Prompt the user for a task description and call the appropriate `TaskProcessor` method.
 *         2.  Process Next Task: Call the `TaskProcessor` method to process the next task.
 *         3.  View Pending Tasks: Retrieve and display all tasks in the pending queue in order.
 *         4.  View Processed Tasks: Retrieve and display all tasks that have been processed.
 *         5.  Exit: Terminate the application.
 *     *   Use a `switch` statement to handle the different user commands based on the numerical input.
 *     *   Print command prompts, menu, confirmation messages, and task lists to `System.out`.
 *     *   Print all error messages (input validation failures, empty queue processing attempts, invalid commands, unexpected errors) to `System.err`.
 * 4.  **Exception Handling:** Implement robust exception handling using `try-catch` blocks.
 *     *   Handle potential errors during user input reading, specifically `InputMismatchException` if the user enters non-integer input for a command.
 *     *   Include at least one `try-catch` block that demonstrates handling exceptions at a broader scope (e.g., wrapping the main application loop or critical sections of the command processing logic) to catch unexpected runtime errors.
 * 5.  **Code Quality:** Adhere to best practices:
 *     *   Use meaningful variable and method names (`pendingTasks`, `processNextTask`, etc.).
 *     *   Include appropriate comments and documentation (e.g., Javadocs for classes and methods).
 *     *   Ensure input validation where necessary (task description, command input).
 *     *   Structure your code logically into classes and methods.
 * 
 * **Required Java Components:** Your solution *must* explicitly use and demonstrate the functionality of ALL of the following:
 * *   `java.util.Queue`
 * *   `java.util.ArrayList`
 * *   `java.util.List` interface
 * *   `java.util.Scanner`
 * *   `switch` statement
 * *   `System.err`
 * *   `System.out`
 * *   Class-wide exception handling with `try-catch` blocks
 * 
 * **Example Interaction Flow:**
 * 
 * ```
 * --- Task Management System ---
 * Commands:
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Processed Tasks
 * 5. Exit
 * 
 * Enter command (number): 1
 * Enter task description: Write exam question
 * Added: Task [ID=1, Description='Write exam question']
 * 
 * Enter command (number): 1
 * Enter task description: Create solution code
 * Added: Task [ID=2, Description='Create solution code']
 * 
 * Enter command (number): 3
 * 
 * --- Pending Tasks ---
 * 1. Task [ID=1, Description='Write exam question']
 * 2. Task [ID=2, Description='Create solution code']
 * ---------------------
 * 
 * Enter command (number): 2
 * Processed: Task [ID=1, Description='Write exam question']
 * 
 * Enter command (number): 3
 * 
 * --- Pending Tasks ---
 * 1. Task [ID=2, Description='Create solution code']
 * ---------------------
 * 
 * Enter command (number): 4
 * 
 * --- Processed Tasks ---
 * Task [ID=1, Description='Write exam question']
 * -----------------------
 * 
 * Enter command (number): 2
 * Processed: Task [ID=2, Description='Create solution code']
 * 
 * Enter command (number): 2
 * Error: No tasks in the pending queue to process.
 * 
 * Enter command (number): 4
 * 
 * --- Processed Tasks ---
 * Task [ID=1, Description='Write exam question']
 * Task [ID=2, Description='Create solution code']
 * -----------------------
 * 
 * Enter command (number): invalid_input
 * Error: Invalid input. Please enter a number.
 * Commands:
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Processed Tasks
 * 5. Exit
 * 
 * Enter command (number): 9
 * Error: Invalid command. Please enter a number between 1 and 5.
 * Commands:
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Processed Tasks
 * 5. Exit
 * 
 * Enter command (number): 5
 * Exiting Task Management System. Goodbye!
 * ```
 * 
 * Your solution should consist of the complete Java code for the required classes within a single code block, followed by a brief explanation.
 *
 * EXPLANATION:
 * The provided solution implements a simple Task Management System as requested, demonstrating the use of all required Java components and adhering to best practices.
 * 
 * 1.  **`Task` Class:** This is a basic Plain Old Java Object (POJO) representing a task. It encapsulates the task's `id` and `description` with private fields and provides public getter methods. The `toString()` method is overridden for easy printing.
 * 2.  **`TaskProcessor` Class:** This class manages the core logic.
 *     *   It uses a `Queue<Task>` named `pendingTasks` (implemented with `LinkedList`) to store tasks waiting to be processed, respecting the FIFO (First-In, First-Out) nature of a queue.
 *     *   It uses a `List<Task>` named `processedTasks` (implemented with `ArrayList`) to store completed tasks. Using the `List` interface for the field demonstrates polymorphism, while `ArrayList` is used for the concrete implementation, fulfilling both requirements.
 *     *   `addTask`: Takes a description, creates a new `Task` with an auto-incrementing ID, validates the description (using `System.err` for errors), and adds it to the `pendingTasks` queue using `offer()`.
 *     *   `processNextTask`: Checks if the `pendingTasks` queue is empty. If so, it prints an error to `System.err`. Otherwise, it removes the next task using `poll()` and adds it to the `processedTasks` list.
 *     *   `getPendingTasks` and `getProcessedTasks`: These methods return *new* `ArrayList` instances containing the current elements from the internal collections. This is a common way to provide access to the data while protecting the internal state from external modification, demonstrating encapsulation.
 * 3.  **`TaskSystemApp` Class:** This class contains the `main` method and handles user interaction.
 *     *   A `Scanner` is used within a `try-with-resources` block to read input from `System.in`, ensuring the scanner is closed properly.
 *     *   A `while` loop runs the main application cycle until the user chooses to exit.
 *     *   Inside the loop, user input for the command number is read.
 *     *   A `switch` statement is used to dispatch actions based on the command number, calling the appropriate methods of the `TaskProcessor` or handling application exit.
 *     *   `System.out` is used for displaying the menu, prompts, confirmation messages, and task lists.
 *     *   `System.err` is used for displaying all error conditions: invalid command number, empty queue processing attempt (handled in `TaskProcessor`), and input errors.
 * 4.  **Exception Handling:**
 *     *   An inner `try-catch` block is placed around the command reading and processing logic within the `while` loop. This block specifically catches `InputMismatchException` for invalid integer input and a general `Exception` to catch any other unexpected runtime errors during command execution, printing them to `System.err`. This demonstrates handling exceptions at the scope of processing a single command.
 *     *   An outer `try-catch` block wraps the entire `main` method body (including the `Scanner` initialization and the main loop). This catches potential critical errors that might occur during setup or teardown, demonstrating class-wide or broader scope exception handling.
 * 5.  **Code Quality:** The code uses meaningful variable names (`pendingTasks`, `processedTasks`, `nextTaskId`, `command`, `description`), includes Javadoc comments for classes and methods, implements input validation (empty description, integer command), and is structured into logical classes.
 * 
 * This solution effectively integrates `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch` blocks to create a functional and robust command-line application, fulfilling all requirements of the complex exam task.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Represents a single task in the system.
 */
class Task {
    private int id;
    private String description;
    // private long timestamp; // Optional: creation time

    /**
     * Constructs a new Task.
     * @param id The unique ID of the task.
     * @param description A brief description of the task.
     */
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        // this.timestamp = System.currentTimeMillis();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    /*
    public long getTimestamp() {
        return timestamp;
    }
    */

    /**
     * Provides a user-friendly string representation of the Task.
     * @return A string representation of the task.
     */
    @Override
    public String toString() {
        return "Task [ID=" + id + ", Description='" + description + "']";
    }
}

/**
 * Manages a queue of pending tasks and a list of processed tasks.
 */
class TaskProcessor {
    private Queue<Task> pendingTasks;
    private List<Task> processedTasks; // Use List interface, implemented by ArrayList
    private int nextTaskId;

    /**
     * Constructs a new TaskProcessor, initializing the task queues and lists.
     */
    public TaskProcessor() {
        // Use LinkedList as a Queue implementation
        this.pendingTasks = new LinkedList<>();
        // Use ArrayList as a List implementation
        this.processedTasks = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the pending queue.
     * Implements input validation for the description.
     * @param description The description of the task.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }
        Task newTask = new Task(nextTaskId++, description.trim());
        pendingTasks.offer(newTask); // offer is generally preferred over add for queues
        System.out.println("Added: " + newTask);
    }

    /**
     * Processes the next task from the pending queue.
     * Removes the task from the queue and adds it to the processed list.
     * Handles the case where the pending queue is empty.
     * @return The task that was processed, or null if the queue was empty.
     */
    public Task processNextTask() {
        // Check if queue is empty before processing
        if (pendingTasks.isEmpty()) {
            System.err.println("Error: No tasks in the pending queue to process.");
            return null;
        }
        // poll() retrieves and removes the head of the queue, returns null if empty (already checked)
        Task processedTask = pendingTasks.poll();
        if (processedTask != null) { // Should not be null due to isEmpty check, but good practice
            processedTasks.add(processedTask);
            System.out.println("Processed: " + processedTask);
        }
        return processedTask;
    }

    /**
     * Gets a copy of the pending tasks queue as a List.
     * Returns a new ArrayList to maintain encapsulation.
     * @return A List containing the pending tasks.
     */
    public List<Task> getPendingTasks() {
        // Return a copy to maintain encapsulation
        return new ArrayList<>(pendingTasks);
    }

    /**
     * Gets a copy of the processed tasks list.
     * Returns a new ArrayList to maintain encapsulation.
     * @return A List containing the processed tasks.
     */
    public List<Task> getProcessedTasks() {
        // Return a copy to maintain encapsulation
        return new ArrayList<>(processedTasks);
    }
}

/**
 * Main application class for the Task Management System.
 * Handles user interaction and orchestrates the TaskProcessor.
 * Demonstrates Scanner, switch, System.out, System.err, and try-catch.
 */
public class TaskSystemApp {

    /**
     * Main method to run the Task Management System application.
     * Manages user input and command dispatch.
     * Includes class-wide exception handling.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Scanner needs to be closed, use try-with-resources for automatic closing
        try (Scanner scanner = new Scanner(System.in)) {
            TaskProcessor processor = new TaskProcessor();
            boolean running = true;

            System.out.println("--- Task Management System ---");
            printMenu();

            // Main application loop
            while (running) {
                System.out.print("\nEnter command (number): ");
                try {
                    // Read user input as an integer command
                    int command = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading int

                    // Use a switch statement for command processing
                    switch (command) {
                        case 1: // Add Task
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine();
                            processor.addTask(description);
                            break;

                        case 2: // Process Next Task
                            processor.processNextTask();
                            break;

                        case 3: // View Pending Tasks
                            List<Task> pending = processor.getPendingTasks();
                            System.out.println("\n--- Pending Tasks ---");
                            if (pending.isEmpty()) {
                                System.out.println("No pending tasks.");
                            } else {
                                // Demonstrate iterating through the List
                                for (int i = 0; i < pending.size(); i++) {
                                    // Access elements using List index
                                    System.out.println((i + 1) + ". " + pending.get(i));
                                }
                            }
                            System.out.println("---------------------");
                            break;

                        case 4: // View Processed Tasks
                            List<Task> processed = processor.getProcessedTasks();
                            System.out.println("\n--- Processed Tasks ---");
                            if (processed.isEmpty()) {
                                System.out.println("No processed tasks.");
                            } else {
                                // Demonstrate iterating through the List using enhanced for loop
                                for (Task task : processed) {
                                    System.out.println(task);
                                }
                            }
                            System.out.println("-----------------------");
                            break;

                        case 5: // Exit
                            System.out.println("Exiting Task Management System. Goodbye!");
                            running = false;
                            break;

                        default:
                            // Handle invalid command numbers using System.err
                            System.err.println("Error: Invalid command. Please enter a number between 1 and 5.");
                            printMenu(); // Show menu again on invalid command
                            break;
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input for command using System.err
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                    printMenu(); // Show menu again on input error
                } catch (Exception e) {
                    // General catch block for any unexpected errors during command processing
                    // This demonstrates class-wide or method-level exception handling within the loop
                    System.err.println("An unexpected error occurred during command processing: " + e.getMessage());
                    // e.printStackTrace(); // Optional: Uncomment for debugging detailed stack trace
                }
            }

        } catch (Exception e) {
            // Outer catch block for errors during Scanner initialization or other critical issues outside the loop
            System.err.println("A critical error occurred during system startup or shutdown: " + e.getMessage());
            // e.printStackTrace(); // Optional: Uncomment for debugging detailed stack trace
        }
    }

    /**
     * Prints the command menu to the console using System.out.
     */
    private static void printMenu() {
        System.out.println("\nCommands:");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Processed Tasks");
        System.out.println("5. Exit");
    }
}
