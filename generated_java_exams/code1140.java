/*
 * Exam Question #1140
 * Generated on: 2025-05-12 17:30:24
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam: Priority Task Executor System
 * 
 * **Objective:** Design and implement a simple console-based system to manage and execute tasks with different priorities. This system should allow users to add tasks to a pending queue, process the next task, and view both pending and completed tasks.
 * 
 * **Scenario:** You are building a backend process simulator. Tasks arrive and are placed in a queue. A processor picks tasks from the queue one by one. The system needs to keep track of what's waiting and what's done.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class `Task` with private fields for `name` (String) and `priority` (String, e.g., "High", "Medium", "Low"). Include a constructor and public getter methods.
 * 2.  **Task Executor Class:** Create a class `TaskExecutor` that manages the task processing.
 *     *   It must use a `Queue<Task>` to store tasks that are waiting to be processed.
 *     *   It must use a `List<Task>` (specifically an `ArrayList<Task>`) to store tasks that have been completed.
 *     *   It must use a `Scanner` to read user input from the console.
 *     *   Include a `run()` method that contains the main application loop.
 * 3.  **Functionality:** The `TaskExecutor` should provide the following operations via a command-line menu:
 *     *   **Add Task:** Prompt the user for the task name and priority. Create a `Task` object and add it to the pending tasks queue. Validate that the task name is not empty and the priority is one of "High", "Medium", or "Low". If validation fails, print an error message to `System.err` and do not add the task.
 *     *   **Process Next Task:** Take the next task from the pending tasks queue. If the queue is empty, print an error message to `System.err`. If a task is retrieved, move it to the completed tasks list and print a success message to `System.out`.
 *     *   **View Pending Tasks:** Display all tasks currently in the pending queue. Print "No pending tasks." if the queue is empty.
 *     *   **View Completed Tasks:** Display all tasks currently in the completed list. Print "No completed tasks." if the list is empty.
 *     *   **Exit:** Terminate the program.
 * 4.  **User Interface:** Present a menu of options to the user. Use a `switch` statement to handle the user's command selection.
 * 5.  **Error Handling:**
 *     *   Use `System.err` for all error messages (e.g., invalid input, trying to process from an empty queue).
 *     *   Use `System.out` for all normal output (menu, prompts, success messages, task listings).
 *     *   Implement class-wide exception handling using `try-catch` blocks within the `run()` method to gracefully handle unexpected errors during execution (e.g., issues with input reading or other runtime problems). Print a generic error message to `System.err` if an uncaught exception occurs within the main loop.
 * 6.  **Best Practices:**
 *     *   Use appropriate variable and method names.
 *     *   Include basic comments where necessary.
 *     *   Ensure proper encapsulation for the `Task` class.
 *     *   Close the `Scanner` resource when the program exits.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu like this:
 * ```
 * Task Executor Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 
 * ```
 * Based on the user's choice, the program should perform the requested action, printing appropriate messages to `System.out` or `System.err`.
 * 
 * *   Adding a valid task: Prompts, then success message.
 * *   Adding an invalid task: Prompts, then error message on `System.err`.
 * *   Processing when queue is empty: Error message on `System.err`.
 * *   Processing when queue has tasks: Success message on `System.out`.
 * *   Viewing empty lists/queues: "No [pending/completed] tasks." on `System.out`.
 * *   Viewing non-empty lists/queues: List of tasks on `System.out`.
 * *   Entering invalid menu option: Error message on `System.err`.
 * *   Unexpected runtime error: Generic error message on `System.err` from the `try-catch`.
 * 
 * Your solution should be a single `.java` file containing both the `Task` and `TaskExecutor` classes (with the `main` method in `TaskExecutor`).
 *
 * EXPLANATION:
 * This solution implements a simple Task Executor system demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Task Class:** A basic POJO (`Task`) is created with private fields `name` and `priority`, a constructor, and public getters, ensuring encapsulation. The `toString()` method is overridden for easy printing.
 * 2.  **TaskExecutor Class:** This is the core class managing the application state and logic.
 *     *   **`Queue<Task> pendingTasks`**: Declared using the `Queue` interface and initialized with a `LinkedList`. This structure is used to hold tasks waiting for processing, naturally supporting FIFO (First-In, First-Out) behavior which is typical for processing queues.
 *     *   **`List<Task> completedTasks`**: Declared using the `List` interface and initialized with an `ArrayList`. This structure stores tasks after they have been processed, allowing easy storage and retrieval of the completed items.
 *     *   **`Scanner scanner`**: Used to read user input from `System.in`. It's initialized in the constructor.
 *     *   **`displayMenu()`**: A private helper method to print the menu options to `System.out`.
 *     *   **`addTask()`**: Prompts the user for task details. It performs input validation for both the task name (must not be empty) and priority (must be one of the specified values). Error messages for invalid input are printed to `System.err`. Valid tasks are created and added to the `pendingTasks` queue using the `add()` method. Success messages are printed to `System.out`.
 *     *   **`processNextTask()`**: Uses the `poll()` method of the `Queue` to retrieve and remove the head of the `pendingTasks` queue. If `poll()` returns `null` (meaning the queue is empty), an error is printed to `System.err`. Otherwise, the retrieved task is added to the `completedTasks` list using `add()`, and a success message is printed to `System.out`.
 *     *   **`viewPendingTasks()`**: Checks if `pendingTasks` is empty. If not, it iterates through the queue (using an enhanced for loop, which doesn't remove elements) and prints each task to `System.out`.
 *     *   **`viewCompletedTasks()`**: Checks if `completedTasks` is empty. If not, it iterates through the list and prints each task to `System.out`.
 *     *   **`run()`**: This is the main application loop.
 *         *   It uses a `while` loop to keep the program running until the user chooses to exit (option 5).
 *         *   The core logic within the loop is wrapped in a `try-catch` block (`try { ... } catch (InputMismatchException e) { ... }`). This handles potential `InputMismatchException` if the user enters non-integer input for the menu choice. The invalid input is consumed using `scanner.nextLine()` to prevent an infinite loop.
 *         *   A `switch` statement is used to handle the different menu choices, calling the appropriate private methods (`addTask`, `processNextTask`, etc.). An error message is printed to `System.err` for invalid menu numbers.
 *         *   The *entire* `while` loop (and the inner `try-catch`) is enclosed in an outer `try-catch` block (`try { ... } catch (Exception e) { ... }`). This provides the "class-wide" exception handling, catching any other unexpected `Exception` that might occur during the program's execution within the `run` method. A generic error message and stack trace are printed to `System.err`.
 *         *   A `finally` block is used to ensure that the `Scanner` resource is closed properly regardless of whether the loop finishes normally or an exception occurs.
 *     *   **`main()`**: The entry point of the program. It creates an instance of `TaskExecutor` and calls its `run()` method.
 * 
 * This solution effectively uses all the required components in a practical scenario, demonstrates input validation, proper error reporting via `System.err`, standard output via `System.out`, and includes basic exception handling and resource management, fulfilling the requirements of a challenging exam task.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single task with a name and priority.
 */
class Task {
    private String name;
    private String priority; // e.g., "High", "Medium", "Low"

    /**
     * Constructs a new Task.
     * @param name The name of the task.
     * @param priority The priority of the task.
     */
    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
    }

    /**
     * Gets the name of the task.
     * @return The task name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the priority of the task.
     * @return The task priority.
     */
    public String getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority='" + priority + "'}";
    }
}

/**
 * Manages a queue of pending tasks and a list of completed tasks.
 * Provides a console interface for interaction.
 */
public class TaskExecutor {

    private Queue<Task> pendingTasks;
    private List<Task> completedTasks;
    private Scanner scanner;

    /**
     * Constructs a TaskExecutor, initializing the task queues and scanner.
     */
    public TaskExecutor() {
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
        System.out.println("\nTask Executor Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new task based on user input.
     * Validates input before adding the task.
     */
    private void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.err.println("Error: Task name cannot be empty.");
            return;
        }

        System.out.print("Enter priority (High, Medium, Low): ");
        String priority = scanner.nextLine().trim();

        // Basic priority validation
        if (!priority.equalsIgnoreCase("High") &&
            !priority.equalsIgnoreCase("Medium") &&
            !priority.equalsIgnoreCase("Low")) {
            System.err.println("Error: Invalid priority. Please enter High, Medium, or Low.");
            return;
        }

        Task newTask = new Task(name, priority);
        pendingTasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task from the pending queue.
     * Moves the task to the completed list.
     */
    private void processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // Retrieves and removes the head of the queue

        if (taskToProcess == null) {
            System.err.println("Error: No pending tasks to process.");
        } else {
            completedTasks.add(taskToProcess);
            System.out.println("Processed task: " + taskToProcess);
        }
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    private void viewPendingTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            System.out.println("Pending Tasks:");
            // Iterate through the queue without removing elements
            for (Task task : pendingTasks) {
                System.out.println("- " + task);
            }
        }
    }

    /**
     * Displays all tasks currently in the completed list.
     */
    private void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            System.out.println("Completed Tasks:");
            // Iterate through the list
            for (Task task : completedTasks) {
                System.out.println("- " + task);
            }
        }
    }

    /**
     * Runs the main task executor application loop.
     * Includes class-wide exception handling.
     */
    public void run() {
        int choice = 0;
        // Class-wide exception handling for the main execution loop
        try {
            while (choice != 5) {
                displayMenu();
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    switch (choice) {
                        case 1:
                            addTask();
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
                            System.out.println("Exiting Task Executor. Goodbye!");
                            break;
                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = 0; // Reset choice to continue loop
                }
            }
        } catch (Exception e) {
            // Catch any other unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to stderr for debugging
        } finally {
            // Ensure the scanner is closed when the program exits the run loop
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Scanner closed."); // Optional: indicate scanner closure
        }
    }

    /**
     * Main method to start the Task Executor application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskExecutor executor = new TaskExecutor();
        executor.run();
    }
}
