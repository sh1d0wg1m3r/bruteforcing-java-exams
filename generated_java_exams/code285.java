/*
 * Exam Question #285
 * Generated on: 2025-05-11 22:49:36
 * Generated by: Account 4
 * 
 * QUESTION:
 * **Java Programming Exam Task: Automated Task Processing System Simulation**
 * 
 * **Problem Description:**
 * 
 * You are tasked with creating a simple simulation of an automated task processing system. The system manages a queue of tasks waiting to be processed and a history of completed tasks. Users interact with the system via a console menu.
 * 
 * Each **Task** has the following attributes:
 * - A unique integer ID.
 * - A String description of the task.
 * - A String status (e.g., "PENDING", "COMPLETED").
 * 
 * The system should maintain:
 * - A **queue** of tasks that are currently waiting to be processed. Tasks are processed in the order they are submitted (FIFO - First-In, First-Out).
 * - A **list** of tasks that have been successfully processed.
 * 
 * The system should provide the following operations via a console menu:
 * 1.  **Submit New Task:** Prompt the user for a task description. Assign a unique ID automatically (starting from 1). Add the task to the waiting queue with "PENDING" status.
 * 2.  **Process Next Task:** Take the task from the front of the waiting queue. If a task is retrieved, change its status to "COMPLETED" and move it to the completed tasks list. If the queue is empty, report an error.
 * 3.  **View Pending Tasks Queue:** Display all tasks currently in the waiting queue, in order.
 * 4.  **View Completed Tasks History:** Display all tasks in the completed tasks list.
 * 5.  **Exit:** Terminate the application.
 * 
 * **Technical Requirements:**
 * 
 * Your solution must demonstrate proficiency in core Java concepts and adhere to best practices. Specifically, your implementation **must** use all of the following Java components:
 * 
 * -   `java.util.Queue` (use an implementation like `LinkedList`) for the waiting tasks.
 * -   `java.util.ArrayList` for the completed tasks history.
 * -   `java.util.List` interface (declare the completed tasks history using the `List` interface type).
 * -   `java.util.Scanner` for reading user input from the console.
 * -   `switch` statement to handle the main menu options.
 * -   `System.err` for printing error messages (e.g., invalid input, queue empty).
 * -   `System.out` for printing all normal output (menu, prompts, task details, success messages).
 * -   Class-wide exception handling using `try-catch` blocks to manage potential issues like invalid input format (e.g., non-integer input for menu choice).
 * 
 * **Best Practices Requirements:**
 * 
 * -   Implement the `Task` as a separate class with private fields and public methods (encapsulation).
 * -   Use meaningful names for variables, methods, and classes.
 * -   Include comments where necessary to explain complex logic.
 * -   Validate user input where applicable (e.g., menu choice).
 * -   Handle potential errors gracefully (e.g., attempting to process from an empty queue).
 * -   Structure the code logically with appropriate methods.
 * 
 * **Expected Output Format:**
 * 
 * -   Menu should be clearly displayed.
 * -   Prompts for input should be clear.
 * -   Task details should be displayed in a readable format (e.g., "Task ID: [ID], Description: [Description], Status: [Status]").
 * -   Error messages should be distinct (using `System.err`).
 * -   Success messages should confirm operations.
 * -   When viewing queues/lists, indicate if they are empty.
 * 
 * **Evaluation Criteria:**
 * 
 * -   Correctness of implementation based on problem description.
 * -   Proper usage of all required Java components.
 * -   Adherence to best practices (encapsulation, naming, comments, structure).
 * -   Robustness through input validation and exception handling.
 * -   Clarity and readability of the code.
 * 
 * Good luck!
 *
 * EXPLANATION:
 * This solution implements a simple Task Processing System simulation using the required Java components and best practices.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents the data structure for a task.
 *     *   Uses private fields (`taskId`, `description`, `status`) to enforce encapsulation.
 *     *   Provides public getter methods and a setter for the status.
 *     *   Overrides `toString()` for convenient printing of task details.
 * 
 * 2.  **`TaskProcessingSystem` Class:**
 *     *   **`Queue<Task> pendingTasks`**: Declared as a `Queue` interface type and initialized with a `LinkedList`. This correctly models a waiting line where tasks are added to the end (`offer`) and removed from the front (`poll`).
 *     *   **`List<Task> completedTasks`**: Declared as a `List` interface type and initialized with an `ArrayList`. This stores the history of processed tasks, allowing easy addition (`add`) and iteration.
 *     *   **`Scanner scanner`**: Used to read user input from `System.in`.
 *     *   **`nextTaskId`**: An integer counter to ensure unique IDs for new tasks.
 *     *   **`displayMenu()`**: Prints the interactive menu options to `System.out`.
 *     *   **`submitNewTask()`**:
 *         *   Prompts the user for a description using `System.out`.
 *         *   Reads the input using the `scanner`.
 *         *   Includes basic input validation for the description.
 *         *   Creates a new `Task` object with the next available ID and "PENDING" status.
 *         *   Adds the new task to the `pendingTasks` queue using `offer()`.
 *         *   Confirms submission using `System.out`.
 *     *   **`processNextTask()`**:
 *         *   Attempts to retrieve and remove the head of the `pendingTasks` queue using `poll()`.
 *         *   Checks if the result is `null` (meaning the queue was empty).
 *         *   If `null`, prints an error message to `System.err`.
 *         *   If a task is retrieved, updates its status to "COMPLETED" using the setter and adds it to the `completedTasks` list using `add()`.
 *         *   Confirms processing using `System.out`.
 *     *   **`viewPendingTasks()`**:
 *         *   Prints a header to `System.out`.
 *         *   Checks if the `pendingTasks` queue is empty and prints a message to `System.out` if it is.
 *         *   If not empty, iterates through the queue using `forEach` (which doesn't remove elements) and prints each task's `toString()` representation to `System.out`.
 *     *   **`viewCompletedTasks()`**:
 *         *   Prints a header to `System.out`.
 *         *   Checks if the `completedTasks` list is empty and prints a message to `System.out` if it is.
 *         *   If not empty, iterates through the list using `forEach` and prints each task's `toString()` representation to `System.out`.
 *     *   **`main()` method**:
 *         *   Creates an instance of `TaskProcessingSystem`.
 *         *   Contains the main application loop (`while (choice != 5)`).
 *         *   **`try-catch` blocks**:
 *             *   An outer `try-finally` block ensures the `Scanner` is closed upon exiting.
 *             *   An inner `try-catch` block specifically handles `InputMismatchException` that occurs if the user enters non-integer input when prompted for the menu choice. It prints an error to `System.err` and consumes the invalid input using `scanner.next()` to prevent an infinite loop.
 *             *   A general `catch (Exception e)` is included to catch any other unexpected runtime errors within the loop, printing details to `System.err`.
 *         *   **`switch` statement**: Used inside the inner `try` block to direct execution based on the valid integer `choice` read from the user. Each case calls the corresponding method. The `default` case handles valid integer inputs that are not between 1 and 5, printing an error to `System.err`.
 * 
 * This solution effectively integrates all required components in a practical context, demonstrates proper object-oriented design principles (encapsulation), handles user interaction and potential errors, and uses `System.out` and `System.err` appropriately.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a single task in the system
class Task {
    private int taskId;
    private String description;
    private String status;

    // Constructor
    public Task(int taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = "PENDING"; // Default status
    }

    // Getters
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // Setter for status (used when processing)
    public void setStatus(String status) {
        this.status = status;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Description: \"" + description + "\", Status: " + status;
    }
}

// Main class managing the task processing system
public class TaskProcessingSystem {

    private Queue<Task> pendingTasks; // Queue for tasks waiting to be processed
    private List<Task> completedTasks; // List for tasks that have been processed
    private int nextTaskId; // Counter for assigning unique task IDs
    private Scanner scanner; // Scanner for user input

    // Constructor
    public TaskProcessingSystem() {
        this.pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>(); // ArrayList implements List
        this.nextTaskId = 1; // Start task IDs from 1
        this.scanner = new Scanner(System.in);
    }

    // Method to display the main menu
    private void displayMenu() {
        System.out.println("\n--- Task Processing System Menu ---");
        System.out.println("1. Submit New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks Queue");
        System.out.println("4. View Completed Tasks History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to submit a new task
    private void submitNewTask() {
        System.out.print("Enter task description: ");
        scanner.nextLine(); // Consume the newline character left by previous nextInt()
        String description = scanner.nextLine();

        if (description == null || description.trim().isEmpty()) {
            System.err.println("Task description cannot be empty.");
            return;
        }

        Task newTask = new Task(nextTaskId++, description.trim());
        pendingTasks.offer(newTask); // Add task to the end of the queue
        System.out.println("Task submitted successfully: " + newTask);
    }

    // Method to process the next task from the queue
    private void processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // Retrieve and remove the head of the queue

        if (taskToProcess == null) {
            System.err.println("No tasks in the pending queue to process.");
        } else {
            taskToProcess.setStatus("COMPLETED"); // Update status
            completedTasks.add(taskToProcess); // Add to completed list
            System.out.println("Task processed: " + taskToProcess);
        }
    }

    // Method to view tasks in the pending queue
    private void viewPendingTasks() {
        System.out.println("\n--- Pending Tasks Queue ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("The pending tasks queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            pendingTasks.forEach(System.out::println);
        }
    }

    // Method to view tasks in the completed history list
    private void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks History ---");
        if (completedTasks.isEmpty()) {
            System.out.println("The completed tasks history is empty.");
        } else {
            // Iterate through the list
            completedTasks.forEach(System.out::println);
        }
    }

    // Main method to run the system
    public static void main(String[] args) {
        TaskProcessingSystem system = new TaskProcessingSystem();
        int choice = 0;

        // Main application loop with class-wide exception handling
        try {
            while (choice != 5) {
                system.displayMenu();

                try {
                    choice = system.scanner.nextInt(); // Read user choice

                    // Use switch statement for menu navigation
                    switch (choice) {
                        case 1:
                            system.submitNewTask();
                            break;
                        case 2:
                            system.processNextTask();
                            break;
                        case 3:
                            system.viewPendingTasks();
                            break;
                        case 4:
                            system.viewCompletedTasks();
                            break;
                        case 5:
                            System.out.println("Exiting Task Processing System. Goodbye!");
                            break;
                        default:
                            System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input
                    System.err.println("Invalid input. Please enter a number.");
                    system.scanner.next(); // Consume the invalid input to prevent infinite loop
                } catch (Exception e) {
                    // Catch any other unexpected exceptions during an operation
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    e.printStackTrace(System.err); // Print stack trace to error stream
                }
            }
        } finally {
            // Ensure scanner is closed when the application exits
            if (system.scanner != null) {
                system.scanner.close();
            }
        }
    }
}
