/*
 * Exam Question #6
 * Generated on: 2025-05-11 21:24:36
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Simple Task Management System
 * 
 * **Objective:** Design and implement a command-line application for managing a simple list of tasks. The application should simulate a basic workflow where tasks are added to a queue for processing and then moved to a list of completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` to represent a single task.
 *     *   It must have private fields: `description` (String) and `type` (String).
 *     *   The `type` field should represent the task category (e.g., "Urgent", "Regular", "Low").
 *     *   Include a constructor to initialize these fields.
 *     *   Provide public getter methods for both fields.
 *     *   Override the `toString()` method to provide a user-friendly string representation of the task (e.g., `[Type] Description`).
 * 
 * 2.  **Task Processor:** Create a class named `TaskProcessor` that will manage the task queue and completed list.
 *     *   It must have a private field of type `java.util.Queue<Task>` to store pending tasks. Use `java.util.LinkedList` as the implementation.
 *     *   It must have a private field of type `java.util.List<Task>` to store completed tasks. Use `java.util.ArrayList` as the implementation, but declare the field using the `List` interface type.
 *     *   It must have a private field of type `java.util.Scanner` for reading user input.
 *     *   Implement a constructor to initialize these fields.
 * 
 * 3.  **Application Logic:** Implement the core application logic within a public method `run()` in the `TaskProcessor` class. This method should:
 *     *   Display a menu of options to the user:
 *         1.  Add New Task
 *         2.  Process Next Task
 *         3.  View Pending Tasks
 *         4.  View Completed Tasks
 *         5.  Exit
 *     *   Use a loop to repeatedly display the menu and read the user's choice until the "Exit" option is selected.
 *     *   Use a `switch` statement to handle the different menu options.
 * 
 * 4.  **Menu Option Implementations:**
 *     *   **Add New Task:**
 *         *   Prompt the user for the task description.
 *         *   Prompt the user for the task type. Validate that the entered type is one of the allowed types ("Urgent", "Regular", "Low"). If not, display an error using `System.err` and re-prompt until a valid type is entered.
 *         *   Create a new `Task` object and add it to the pending task queue.
 *         *   Display a confirmation message using `System.out`.
 *     *   **Process Next Task:**
 *         *   Attempt to retrieve and remove the next task from the pending queue.
 *         *   If the queue is empty, display an error message using `System.err`.
 *         *   If a task is retrieved, add it to the completed tasks list and display a success message using `System.out`.
 *     *   **View Pending Tasks:**
 *         *   Iterate through and display all tasks currently in the pending queue using `System.out`. Do *not* remove tasks from the queue.
 *         *   If the queue is empty, display a message using `System.out`.
 *     *   **View Completed Tasks:**
 *         *   Iterate through and display all tasks in the completed tasks list using `System.out`.
 *         *   If the list is empty, display a message using `System.out`.
 *     *   **Exit:** Terminate the application loop.
 * 
 * 5.  **Error Handling:**
 *     *   Implement **class-wide exception handling** using `try-catch` block(s) within the `run()` method's main loop to catch potential exceptions, specifically `java.util.InputMismatchException` if the user enters non-integer input for the menu choice.
 *     *   Display informative error messages to the user using `System.err` when exceptions occur or when invalid operations are attempted (like processing an empty queue).
 *     *   Ensure the program recovers gracefully from input errors and continues to display the menu.
 * 
 * 6.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Apply proper encapsulation (private fields, public/private methods).
 *     *   Include basic comments to explain complex logic if necessary.
 *     *   Ensure proper input validation for menu choices and task types.
 *     *   Use `System.out` for normal output and `System.err` for error messages as specified.
 * 
 * 7.  **Main Method:** Include a `main` method in the `TaskProcessor` class to create an instance of `TaskProcessor` and call its `run()` method to start the application.
 * 
 * **Expected Output:**
 * 
 * The program should present a clear menu, respond to user choices, display task lists, and output errors appropriately on `System.err` when invalid actions or inputs occur. The output should be easy to read and understand.
 * 
 * ```
 * --- Task Processor Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter choice: <user input>
 * ... (program output based on choice)
 * ```
 * 
 * *(Error messages like "Invalid choice...", "No tasks in the queue...", "Invalid task type..." should appear on System.err)*
 *
 * EXPLANATION:
 * The provided solution implements a simple command-line task management system, fulfilling all the requirements of the exam task.
 * 
 * **Key Concepts Demonstrated:**
 * 
 * 1.  **`Task` Class:** A basic class demonstrating encapsulation with private fields (`description`, `type`) and public getter methods. The `toString()` method provides a custom representation, and basic validation is included in the constructor.
 * 2.  **`TaskProcessor` Class:** This is the main controller class.
 *     *   **`Queue` (`LinkedList`)**: The `taskQueue` is declared as a `Queue<Task>` and initialized as a `LinkedList`. This correctly uses the `Queue` interface for its FIFO (First-In, First-Out) behavior, appropriate for processing tasks in the order they are added. `offer()` is used for adding tasks and `poll()` for removing the head, both standard `Queue` operations that handle potential capacity issues (though not strictly necessary with `LinkedList`).
 *     *   **`List` (`ArrayList`)**: The `completedTasks` is declared as a `List<Task>` and initialized as an `ArrayList`. This demonstrates programming to the `List` interface, which is a best practice, while using `ArrayList` for its dynamic array implementation suitable for storing completed items.
 *     *   **`Scanner`**: Used in the `TaskProcessor` constructor and within methods (`addTask`, `run`) to read user input from `System.in`. Proper handling of the newline character after `nextInt()` is crucial (`scanner.nextLine()`).
 *     *   **`Switch` Statement**: Used in the `run()` method to direct execution based on the user's integer menu choice, providing clear control flow for the menu system.
 *     *   **`System.out` and `System.err`**: `System.out` is used for all standard output (menu, prompts, task lists, success messages), while `System.err` is specifically used for displaying error messages (invalid menu choice, invalid task type, processing empty queue, input type mismatch). This adheres to the standard practice of separating normal output from error output.
 *     *   **Class-wide Exception Handling (`try-catch`)**: A `try-catch` block is wrapped around the core logic *within* the `run()` method's main loop. This allows the program to catch exceptions that might occur during a single iteration, such as `InputMismatchException` when the user enters non-integer input for the menu choice. The `catch` block for `InputMismatchException` includes `scanner.nextLine()` to consume the invalid input and prevent an infinite loop. A general `catch (Exception e)` is also included to handle any other unforeseen runtime errors gracefully, printing an error message to `System.err`.
 *     *   **Encapsulation**: Fields in both `Task` and `TaskProcessor` are `private`, and access is controlled through public methods (`getters`, operational methods like `addTask`, `processNextTask`, `run`). Helper methods like `displayMenu` are made `private`.
 *     *   **Input Validation**: The `addTask` method explicitly validates the task type entered by the user in a loop until a valid type ("Urgent", "Regular", "Low") is provided. The `run` method implicitly validates the menu choice via the `switch` statement's `default` case and explicitly handles non-integer input via the `try-catch` block.
 *     *   **Error Handling Logic**: Specific conditions like an empty queue during `processNextTask` are checked, and appropriate error messages are printed to `System.err`.
 *     *   **Meaningful Names**: Variable names (`taskQueue`, `completedTasks`, `description`, `type`, `choice`) and method names (`addTask`, `processNextTask`, `viewQueue`, `viewCompletedTasks`, `run`) clearly indicate their purpose.
 *     *   **Clean Structure**: The code is organized into two classes with distinct responsibilities. Methods are kept relatively short and focused on a single task. Basic comments explain the purpose of classes and key methods.
 * 
 * This solution effectively demonstrates the required Java components and best practices in a practical, albeit simplified, task management scenario, making it a suitable challenging exam question.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a single task with a description and type.
class Task {
    private String description;
    private String type; // e.g., "Urgent", "Regular", "Low"

    /**
     * Constructs a new Task.
     * @param description The description of the task.
     * @param type The type or category of the task.
     */
    public Task(String description, String type) {
        // Basic validation for non-null/empty description and type
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        if (type == null || type.trim().isEmpty()) {
             throw new IllegalArgumentException("Task type cannot be empty.");
        }
        this.description = description.trim();
        this.type = type.trim();
    }

    /**
     * Gets the description of the task.
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the type of the task.
     * @return The task type.
     */
    public String getType() {
        return type;
    }

    /**
     * Provides a string representation of the task.
     * @return A formatted string for the task.
     */
    @Override
    public String toString() {
        return "[" + type + "] " + description;
    }
}

// Manages the task queue and completed tasks list.
public class TaskProcessor {
    // Queue for tasks waiting to be processed
    private Queue<Task> taskQueue;
    // List for tasks that have been completed
    private List<Task> completedTasks;
    // Scanner for reading user input
    private Scanner scanner;

    /**
     * Constructs a new TaskProcessor, initializing the queue, list, and scanner.
     */
    public TaskProcessor() {
        // Use LinkedList as an implementation of Queue
        taskQueue = new LinkedList<>();
        // Use ArrayList as an implementation of List
        completedTasks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Processor Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Handles the process of adding a new task based on user input.
     */
    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        String type;
        // Loop until a valid task type is entered
        while (true) {
            System.out.print("Enter task type (Urgent, Regular, Low): ");
            type = scanner.nextLine().trim();
            // Validate the task type (case-insensitive comparison)
            if (type.equalsIgnoreCase("Urgent") || type.equalsIgnoreCase("Regular") || type.equalsIgnoreCase("Low")) {
                break; // Valid type, exit loop
            } else {
                System.err.println("Invalid task type. Please enter Urgent, Regular, or Low.");
            }
        }

        try {
            // Create the task object and add it to the queue
            Task newTask = new Task(description, type);
            taskQueue.offer(newTask); // offer() is safe for capacity-constrained queues, but standard practice
            System.out.println("Task added to queue: " + newTask);
        } catch (IllegalArgumentException e) {
            // Catch potential errors from Task constructor validation
            System.err.println("Error creating task: " + e.getMessage());
        }
    }

    /**
     * Processes the next task in the queue, moving it to the completed list.
     */
    private void processNextTask() {
        // Retrieve and remove the head of the queue. poll() returns null if queue is empty.
        Task nextTask = taskQueue.poll();
        if (nextTask != null) {
            completedTasks.add(nextTask);
            System.out.println("Processed task: " + nextTask);
        } else {
            // Error message if the queue is empty
            System.err.println("No tasks in the queue to process.");
        }
    }

    /**
     * Displays all tasks currently in the pending queue without removing them.
     */
    private void viewQueue() {
        System.out.println("\n--- Pending Tasks ---");
        if (taskQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate over the queue elements
            int index = 1;
            for (Task task : taskQueue) {
                System.out.println(index++ + ". " + task);
            }
        }
    }

    /**
     * Displays all tasks that have been moved to the completed list.
     */
    private void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks have been completed yet.");
        } else {
            // Iterate over the list elements
            int index = 1;
            for (Task task : completedTasks) {
                System.out.println(index++ + ". " + task);
            }
        }
    }

    /**
     * Runs the main application loop, handling user interaction and menu choices.
     * Includes class-wide exception handling for the main loop.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                // Read user choice (expecting an integer)
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Process the user's choice using a switch statement
                switch (choice) {
                    case 1:
                        addTask(); // Call method to add a task
                        break;
                    case 2:
                        processNextTask(); // Call method to process the next task
                        break;
                    case 3:
                        viewQueue(); // Call method to view pending tasks
                        break;
                    case 4:
                        viewCompletedTasks(); // Call method to view completed tasks
                        break;
                    case 5:
                        System.out.println("Exiting Task Processor. Goodbye!");
                        running = false; // Set flag to exit the loop
                        break;
                    default:
                        // Handle invalid integer input for menu choice
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catch exception if user enters non-integer input for menu choice
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // IMPORTANT: Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions during an operation within the loop
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // Optional: e.printStackTrace(System.err); // For debugging
            }
        }
        // Close the scanner when the application exits
        scanner.close();
    }

    /**
     * The main method to start the Task Processor application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskProcessor processor = new TaskProcessor();
        processor.run(); // Start the main application loop
    }
}
