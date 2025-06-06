/*
 * Exam Question #585
 * Generated on: 2025-05-12 16:10:56
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Advanced Task Processing System
 * 
 * **Objective:** Design and implement a simple console-based Task Processing System that manages tasks in a queue for processing and stores completed tasks in a list. This task requires demonstrating proficiency in using core Java collections, input handling, control flow, and exception handling.
 * 
 * **Scenario:** You are building a backend system for managing simple tasks. Tasks are added to a queue and processed in a First-In, First-Out (FIFO) manner. Once processed, they are moved to a list of completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following attributes:
 *     *   `taskId` (int): A unique identifier for the task.
 *     *   `description` (String): A brief description of the task.
 *     *   `status` (`TaskStatus` enum): The current status of the task (e.g., PENDING, COMPLETED).
 *     *   Implement appropriate constructors, getters, and a method to mark the task as completed. Ensure proper encapsulation.
 * 
 * 2.  **Task Status:** Create an enum `TaskStatus` with at least two states: `PENDING` and `COMPLETED`.
 * 
 * 3.  **Task Management System:** Create a class `TaskManagementSystem` that will orchestrate the system.
 *     *   It must maintain a `Queue<Task>` to hold tasks that are waiting to be processed. Use a concrete implementation like `LinkedList`.
 *     *   It must maintain a `List<Task>` to hold tasks that have been completed. Use a concrete implementation like `ArrayList`.
 *     *   It must use a `Scanner` to read user input from the console.
 *     *   Implement the following functionalities via a menu:
 *         *   **Add New Task:** Prompt the user for a task description, create a new `Task` object with a unique ID and `PENDING` status, and add it to the pending tasks queue.
 *         *   **Process Next Task:** Remove the task at the front of the pending tasks queue, change its status to `COMPLETED`, and add it to the completed tasks list. If the queue is empty, display an appropriate message using `System.err`.
 *         *   **List Pending Tasks:** Display all tasks currently in the pending tasks queue. If the queue is empty, display an appropriate message using `System.out`.
 *         *   **List Completed Tasks:** Display all tasks currently in the completed tasks list. If the list is empty, display an appropriate message using `System.out`.
 *         *   **Exit:** Terminate the program.
 * 
 * 4.  **Control Flow:** Use a `switch` statement to handle the user's menu selection.
 * 
 * 5.  **Input/Output:**
 *     *   Use `System.out` for displaying the menu, prompts, task details, and success messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, attempting to process from an empty queue).
 * 
 * 6.  **Exception Handling:** Implement class-wide exception handling using `try-catch` blocks within the main loop or methods that handle user input and potentially problematic operations (like parsing input or accessing collections). Catch specific exceptions like `java.util.InputMismatchException` for invalid menu input and provide user-friendly error messages using `System.err`. Include a general `catch (Exception e)` as a fallback for unexpected errors, reporting the error via `System.err`.
 * 
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Provide appropriate comments and documentation (e.g., Javadoc for classes and methods).
 *     *   Ensure proper encapsulation in the `Task` class and `TaskManagementSystem`.
 *     *   Implement basic input validation (e.g., checking if menu input is an integer).
 *     *   Structure the code logically with separate classes and methods for different functionalities.
 * 
 * **Expected Output:** The program should present a menu, accept user input, perform the requested action, and display results or error messages clearly using `System.out` or `System.err` as required. Example interactions:
 * 
 * ```
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List Pending Tasks
 * 4. List Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Write exam question
 * Task added: Task{id=1, description='Write exam question', status=PENDING}
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * Processing task: Task{id=1, description='Write exam question', status=PENDING}
 * Task 1 completed and moved.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tasks ---
 * No pending tasks.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 4
 * --- Completed Tasks ---
 * Task{id=1, description='Write exam question', status=COMPLETED}
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * Error: No tasks in the pending queue to process.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number between 1 and 5.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Task Management System.
 * ```
 * 
 * Your solution should be a single Java file containing all necessary classes and the `main` method.
 *
 * EXPLANATION:
 * This solution implements a simple console-based Task Management System, fulfilling all the requirements of the exam question.
 * 
 * 1.  **`TaskStatus` Enum:** Defines the possible states (`PENDING`, `COMPLETED`) for a task, providing type safety and readability compared to using simple strings or integers for status.
 * 
 * 2.  **`Task` Class:**
 *     *   Represents a single task with `taskId`, `description`, and `status`.
 *     *   Fields are `private` for encapsulation.
 *     *   Provides `public` getters to access the data.
 *     *   The constructor initializes a new task with `PENDING` status.
 *     *   `markAsCompleted()` is a simple method to change the status.
 *     *   `toString()` is overridden for easy printing of task details.
 * 
 * 3.  **`TaskManagementSystem` Class:**
 *     *   **Collections:**
 *         *   `pendingTasks`: A `Queue<Task>` is used, specifically a `LinkedList`. This correctly models the FIFO requirement for tasks waiting to be processed. `offer()` is used to add tasks to the end, and `poll()` is used to remove tasks from the front.
 *         *   `completedTasks`: A `List<Task>` is used, implemented by `ArrayList`. This is suitable for storing completed tasks where order might be less critical (though `ArrayList` maintains insertion order) and allows easy iteration.
 *     *   **`Scanner`:** A `Scanner` instance reads input from `System.in`. It's closed when the program exits (`scanner.close()`). Note the use of `scanner.nextLine()` after `scanner.nextInt()` to consume the leftover newline character, preventing issues in subsequent `nextLine()` calls.
 *     *   **`nextTaskId`:** A simple counter to assign unique IDs to new tasks.
 *     *   **Methods:**
 *         *   `displayMenu()`: Prints the user options.
 *         *   `addNewTask()`: Reads description, creates a `Task`, increments the ID counter, and adds the task to the `pendingTasks` queue using `offer()`. Includes basic validation for empty descriptions.
 *         *   `processNextTask()`: Uses `poll()` to get and remove the head of the queue. It checks if `poll()` returned `null` (indicating an empty queue) and reports an error using `System.err`. If a task is retrieved, its status is updated, and it's added to the `completedTasks` list.
 *         *   `listPendingTasks()`: Iterates through the `pendingTasks` queue using an enhanced for loop (which uses the queue's iterator) and prints each task. Checks if the queue is empty and prints a message using `System.out`.
 *         *   `listCompletedTasks()`: Iterates through the `completedTasks` list and prints each task. Checks if the list is empty and prints a message using `System.out`.
 *         *   `run()`: Contains the main program loop. It repeatedly displays the menu, reads user input, and uses a `switch` statement to call the appropriate method based on the user's choice.
 *     *   **Exception Handling:**
 *         *   The `run()` method contains a `try-catch` block that wraps the input reading (`scanner.nextInt()`) and the `switch` statement.
 *         *   `catch (InputMismatchException e)` specifically handles cases where the user enters non-integer input for the menu choice. It prints an error message to `System.err` and consumes the invalid input using `scanner.next()` to prevent an infinite loop.
 *         *   `catch (Exception e)` acts as a general fallback for any other unexpected runtime errors, printing a generic error message to `System.err`.
 *     *   **`main()` Method:** The entry point of the program. It creates an instance of `TaskManagementSystem` and calls the `run()` method to start the system.
 * 
 * 4.  **Control Flow (`switch`):** The `switch` statement in the `run()` method effectively directs the program flow based on the user's valid menu choice. The `default` case handles invalid numeric input within the expected range (after `InputMismatchException` is handled).
 * 
 * 5.  **Input/Output (`System.out`, `System.err`):** `System.out` is used for standard program messages, prompts, and successful output (task listings). `System.err` is specifically used for reporting error conditions, such as invalid user input or attempting an operation on an empty collection where elements are expected.
 * 
 * 6.  **Best Practices:** The code follows best practices with clear naming, encapsulation, basic input validation, separation of concerns into classes and methods, and use of comments/Javadoc.
 * 
 * This solution demonstrates a cohesive use of the required Java components within a practical scenario, incorporating essential concepts like collections, enums, input handling, control flow, and robust exception handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Enum to represent the status of a task
enum TaskStatus {
    PENDING,
    COMPLETED
}

// Represents a single task in the system
class Task {
    private int taskId;
    private String description;
    private TaskStatus status;

    /**
     * Constructs a new Task with a given ID and description, initially PENDING.
     * @param taskId The unique identifier for the task.
     * @param description The description of the task.
     */
    public Task(int taskId, String description) {
        this.taskId = taskId;
        this.description = description;
        this.status = TaskStatus.PENDING; // Tasks are pending by default
    }

    // --- Getters ---
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    /**
     * Marks the task as completed.
     */
    public void markAsCompleted() {
        this.status = TaskStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return "Task{id=" + taskId + ", description='" + description + "', status=" + status + '}';
    }
}

// The main system class for managing tasks
public class TaskManagementSystem {

    private Queue<Task> pendingTasks; // Queue for tasks waiting to be processed (FIFO)
    private List<Task> completedTasks; // List for tasks that have been completed
    private Scanner scanner;           // Scanner for reading user input
    private int nextTaskId;            // Counter for assigning unique task IDs

    /**
     * Constructs a new TaskManagementSystem, initializing collections and scanner.
     */
    public TaskManagementSystem() {
        // Use LinkedList as a Queue implementation
        this.pendingTasks = new LinkedList<>();
        // Use ArrayList as a List implementation
        this.completedTasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. List Pending Tasks");
        System.out.println("4. List Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new task based on user input.
     */
    private void addNewTask() {
        System.out.print("Enter task description: ");
        // Consume the newline character left by previous input (if any)
        scanner.nextLine(); // This is important if the previous input was a number
        String description = scanner.nextLine();

        if (description == null || description.trim().isEmpty()) {
             System.err.println("Error: Task description cannot be empty.");
             return;
        }

        Task newTask = new Task(nextTaskId++, description.trim());
        pendingTasks.offer(newTask); // Add task to the end of the queue
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task in the pending queue.
     * Removes it from the queue, marks it completed, and adds it to the completed list.
     */
    private void processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // Retrieve and remove the head of the queue

        if (taskToProcess == null) {
            System.err.println("Error: No tasks in the pending queue to process.");
        } else {
            System.out.println("Processing task: " + taskToProcess);
            taskToProcess.markAsCompleted(); // Mark task as completed
            completedTasks.add(taskToProcess); // Add to the list of completed tasks
            System.out.println("Task " + taskToProcess.getTaskId() + " completed and moved.");
        }
    }

    /**
     * Lists all tasks currently in the pending queue.
     */
    private void listPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            // Iterate through the queue without removing elements
            for (Task task : pendingTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Lists all tasks currently in the completed list.
     */
    private void listCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            // Iterate through the list
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Runs the main loop of the Task Management System.
     * Handles user interaction and delegates to appropriate methods.
     * Includes class-wide exception handling.
     */
    public void run() {
        int choice = -1;
        while (choice != 5) {
            displayMenu();
            try {
                // Attempt to read the integer choice
                choice = scanner.nextInt();

                // Use switch for menu control
                switch (choice) {
                    case 1:
                        addNewTask();
                        break;
                    case 2:
                        processNextTask();
                        break;
                    case 3:
                        listPendingTasks();
                        break;
                    case 4:
                        listCompletedTasks();
                        break;
                    case 5:
                        System.out.println("Exiting Task Management System.");
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input specifically
                System.err.println("Error: Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to stay in the loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // Optionally print stack trace for debugging during development:
                // e.printStackTrace(System.err);
                choice = -1; // Reset choice to stay in the loop
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * The main method to start the Task Management System.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        system.run();
    }
}
