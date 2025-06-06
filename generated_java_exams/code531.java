/*
 * Exam Question #531
 * Generated on: 2025-05-11 23:25:39
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Task Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with building a simple console-based Task Management System. This system should allow users to add new tasks, view tasks that are pending completion, view tasks that have been completed, and mark the next pending task as completed. The system should handle user input and manage the flow of tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class `Task` with a private field `description` (String) and a unique integer `id`. Provide a constructor and a public getter for the description and ID.
 * 2.  **Task Management Logic:** Create a class `TaskManager` to manage the tasks.
 *     *   It must use a `java.util.Queue` to store tasks that are pending completion (tasks should be processed in the order they are added - FIFO).
 *     *   It must use a `java.util.ArrayList` to store tasks that have been completed.
 *     *   Provide methods:
 *         *   `addTask(String description)`: Creates a new `Task` with a unique ID and adds it to the pending queue.
 *         *   `completeNextTask()`: Removes the next task from the pending queue and moves it to the completed list. This method should return the completed `Task` object or indicate failure if the queue is empty.
 *         *   `getPendingTasks()`: Returns a `java.util.List` view or copy of the tasks currently in the pending queue.
 *         *   `getCompletedTasks()`: Returns the `java.util.List` of completed tasks.
 * 3.  **User Interface:** Create a main class (e.g., `TaskApp`) with a `main` method to interact with the user via the console.
 *     *   Use `java.util.Scanner` to read user input.
 *     *   Present a menu of options to the user:
 *         1.  Add New Task
 *         2.  Complete Next Task
 *         3.  View Pending Tasks
 *         4.  View Completed Tasks
 *         5.  Exit
 *     *   Use a `switch` statement to process the user's menu selection.
 *     *   Use `System.out` for displaying the menu, task lists, and success messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid menu choice, trying to complete a task when the queue is empty, invalid input format).
 * 4.  **Error Handling:** Implement robust error handling.
 *     *   Use `try-catch` blocks to handle potential exceptions, such as `java.util.InputMismatchException` if the user enters non-integer input for the menu choice, or potential issues when operating on collections (though `Queue.poll()` is safer than `remove()`). A general `try-catch(Exception e)` around the main application loop should demonstrate "class-wide" handling of unexpected errors.
 *     *   Validate user input where necessary (e.g., task description should not be empty).
 * 5.  **Best Practices:**
 *     *   Implement proper encapsulation (private fields, public methods/getters).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadocs are encouraged).
 *     *   Ensure the code structure is clean and organized into appropriate classes.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively. When the user selects an option, it should perform the corresponding action and provide feedback.
 * 
 * *   Adding a task: Prompt for description, confirm addition.
 * *   Completing a task: If pending tasks exist, show which task was completed. If not, show an error message.
 * *   Viewing pending tasks: List tasks from the queue. Indicate if the queue is empty.
 * *   Viewing completed tasks: List tasks from the list. Indicate if the list is empty.
 * *   Invalid input/errors: Print descriptive error messages to `System.err`.
 * *   Exit: Terminate the program gracefully.
 * 
 * Example Interaction Snippet:
 * 
 * ```
 * Task Management Menu:
 * 1. Add New Task
 * 2. Complete Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Buy groceries
 * Task "Buy groceries" added with ID 1.
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 3
 * Pending Tasks:
 * ID 1: Buy groceries
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 2
 * Completed task: ID 1: Buy groceries
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 3
 * Pending Tasks: (None)
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 2
 * Error: No pending tasks to complete.
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 6
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * 
 * Task Management Menu:
 * ...
 * Enter your choice: 5
 * Exiting Task Management System.
 * ```
 * 
 * Your solution should provide the complete Java code for the `Task`, `TaskManager`, and `TaskApp` classes.
 *
 * EXPLANATION:
 * This solution implements a simple Task Management System demonstrating the required Java concepts.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents a single task with a `description` and a unique `id`.
 *     *   Uses a `static int nextId` to automatically assign unique IDs starting from 1.
 *     *   Fields are `private` and `final` (for immutability after creation).
 *     *   Provides `public` getter methods (`getId`, `getDescription`) adhering to encapsulation.
 *     *   Overrides `toString()` for easy printing of task details.
 * 
 * 2.  **`TaskManager` Class:**
 *     *   Manages two collections:
 *         *   `pendingTasks`: Declared as `Queue<Task>` and initialized with `new LinkedList<>()`. A `Queue` is used to ensure tasks are processed in First-In, First-Out (FIFO) order, which is typical for pending task queues. `LinkedList` is a common implementation of the `Queue` interface.
 *         *   `completedTasks`: Declared as `List<Task>` and initialized with `new ArrayList<>()`. An `ArrayList` is used for completed tasks, providing dynamic resizing and easy iteration over the completed items. Declaring it as `List` demonstrates the use of the interface.
 *     *   `addTask(String description)`: Creates a new `Task` and adds it to the `pendingTasks` queue using `offer()`. `offer()` is preferred over `add()` in capacity-constrained queues, though `LinkedList` is not capacity-constrained; it's good practice. Includes basic validation for the description.
 *     *   `completeNextTask()`: Uses `pendingTasks.poll()` to retrieve and remove the head of the queue. `poll()` is safe as it returns `null` if the queue is empty, avoiding exceptions like `NoSuchElementException` that `remove()` would throw. If a task is retrieved, it's added to the `completedTasks` list.
 *     *   `getPendingTasks()`: Returns a *new* `ArrayList` containing the elements from the `pendingTasks` queue. This is done to protect the internal `Queue` from external modification, adhering to encapsulation principles. The return type is `List`, fulfilling that requirement.
 *     *   `getCompletedTasks()`: Returns the internal `completedTasks` `ArrayList`. Since `ArrayList` implements `List`, the return type is `List`, satisfying the requirement and allowing the caller to iterate over the completed tasks.
 * 
 * 3.  **`TaskApp` Class:**
 *     *   Contains the `main` method, serving as the application entry point.
 *     *   Uses a `Scanner` (`java.util.Scanner`) to read input from `System.in`.
 *     *   The `run()` method contains the main application loop.
 *     *   A `displayMenu()` method is used to print options to `System.out`.
 *     *   User input for the menu choice is read using `scanner.nextInt()`.
 *     *   A `switch` statement controls the program flow based on the user's integer choice. Each case corresponds to a menu option, calling the appropriate `TaskManager` method.
 *     *   **Error Handling:**
 *         *   A specific `try-catch(InputMismatchException e)` block is used within the loop to handle cases where the user enters non-integer input for the menu choice, printing an error to `System.err` and consuming the invalid input to prevent an infinite loop.
 *         *   When completing a task, the return value of `taskManager.completeNextTask()` is checked. If it's `null`, an error message is printed to `System.err`.
 *         *   An outer `try-catch(Exception e)` block surrounds the main `while` loop in the `run()` method. This provides "class-wide" exception handling, catching any unexpected runtime exceptions that might occur during execution and printing an error message and stack trace to `System.err`.
 *         *   A `finally` block ensures the `Scanner` is closed when the `run()` method exits (either normally or due to an exception).
 *     *   **Output:** `System.out.println` is used for displaying the menu, success messages, and task lists. `System.err.println` is used exclusively for error messages (invalid input, empty queue error, unexpected exceptions).
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical task management scenario, while adhering to best practices like encapsulation, meaningful names, and error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single task with a description and a unique ID.
 */
class Task {
    private static int nextId = 1; // Static counter for unique IDs
    private final int id;
    private final String description;

    /**
     * Constructs a new Task.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.id = nextId++; // Assign unique ID and increment counter
        this.description = description;
    }

    /**
     * Gets the task ID.
     * @return The unique task ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the task description.
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "ID " + id + ": " + description;
    }
}

/**
 * Manages collections of pending and completed tasks.
 */
class TaskManager {
    // Using LinkedList as a Queue implementation for pending tasks (FIFO)
    private final Queue<Task> pendingTasks;
    // Using ArrayList for completed tasks
    private final List<Task> completedTasks;

    /**
     * Constructs a TaskManager with empty task lists.
     */
    public TaskManager() {
        this.pendingTasks = new LinkedList<>(); // Queue interface, LinkedList implementation
        this.completedTasks = new ArrayList<>(); // List interface, ArrayList implementation
    }

    /**
     * Adds a new task to the pending queue.
     *
     * @param description The description of the task to add.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }
        Task newTask = new Task(description.trim());
        pendingTasks.offer(newTask); // Use offer() which is safer than add()
        System.out.println("Task \"" + newTask.getDescription() + "\" added with ID " + newTask.getId() + ".");
    }

    /**
     * Completes the next task from the pending queue.
     *
     * @return The completed Task, or null if the pending queue was empty.
     */
    public Task completeNextTask() {
        Task completedTask = pendingTasks.poll(); // Use poll() which returns null if empty
        if (completedTask != null) {
            completedTasks.add(completedTask);
            return completedTask;
        } else {
            return null; // Indicate no task was completed
        }
    }

    /**
     * Gets a list of tasks currently in the pending queue.
     * Returns a new ArrayList to maintain encapsulation.
     *
     * @return A List of pending tasks.
     */
    public List<Task> getPendingTasks() {
        // Return a copy to prevent external modification of the internal queue
        return new ArrayList<>(pendingTasks);
    }

    /**
     * Gets a list of tasks that have been completed.
     *
     * @return A List of completed tasks.
     */
    public List<Task> getCompletedTasks() {
        // ArrayList already implements List, can return directly
        return completedTasks;
    }
}

/**
 * Main application class for the Task Management System.
 * Handles user interaction and drives the TaskManager.
 */
public class TaskApp {

    private TaskManager taskManager;
    private Scanner scanner;

    /**
     * Constructs the TaskApp, initializing the TaskManager and Scanner.
     */
    public TaskApp() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\nTask Management Menu:");
        System.out.println("1. Add New Task");
        System.out.println("2. Complete Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop.
     */
    public void run() {
        boolean running = true;
        // Class-wide exception handling for unexpected errors
        try {
            while (running) {
                displayMenu();
                int choice = -1;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip to the next iteration
                }

                // Use switch statement for flow control based on user choice
                switch (choice) {
                    case 1: // Add New Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        taskManager.addTask(description);
                        break;
                    case 2: // Complete Next Task
                        Task completed = taskManager.completeNextTask();
                        if (completed != null) {
                            System.out.println("Completed task: " + completed);
                        } else {
                            System.err.println("Error: No pending tasks to complete.");
                        }
                        break;
                    case 3: // View Pending Tasks
                        List<Task> pending = taskManager.getPendingTasks();
                        if (pending.isEmpty()) {
                            System.out.println("Pending Tasks: (None)");
                        } else {
                            System.out.println("Pending Tasks:");
                            for (Task task : pending) {
                                System.out.println(task);
                            }
                        }
                        break;
                    case 4: // View Completed Tasks
                        List<Task> completedList = taskManager.getCompletedTasks();
                        if (completedList.isEmpty()) {
                            System.out.println("Completed Tasks: (None)");
                        } else {
                            System.out.println("Completed Tasks:");
                            for (Task task : completedList) {
                                System.out.println(task);
                            }
                        }
                        break;
                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting Task Management System.");
                        break;
                    default: // Invalid choice
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskApp app = new TaskApp();
        app.run();
    }
}
