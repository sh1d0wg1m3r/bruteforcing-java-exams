/*
 * Exam Question #36
 * Generated on: 2025-05-11 21:53:46
 * 
 * QUESTION:
 * **Java Programming Exam Task: Task Dispatcher System**
 * 
 * You are tasked with creating a simple command-line based Task Dispatcher system in Java. This system will manage a queue of tasks that need processing and maintain a list of tasks that have been completed.
 * 
 * Your solution must demonstrate a solid understanding of fundamental and intermediate Java concepts, including collection types, user input handling, flow control, and exception management.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` with the following private attributes:
 *     *   `id` (int): A unique identifier for the task.
 *     *   `description` (String): A brief description of the task.
 *     *   Provide a constructor, public getter methods for both attributes, and a `toString()` method that returns a formatted string like "Task [ID: <id>, Description: <description>]".
 * 
 * 2.  **Task Dispatcher Logic:** Create a class named `TaskDispatcher` that manages the tasks. It must have the following private attributes:
 *     *   A `Queue<Task>` to hold tasks that are pending processing. Use a concrete implementation like `java.util.LinkedList`.
 *     *   A `List<Task>` to hold tasks that have been completed. Use a concrete implementation like `java.util.ArrayList`.
 *     *   An integer counter to generate unique task IDs, starting from 1.
 * 
 * 3.  **Task Dispatcher Functionality:** The `TaskDispatcher` class must provide the following public methods:
 *     *   `addTask(String description)`: Creates a new `Task` object with the next available ID and the given description, and adds it to the pending tasks queue. Increment the task ID counter.
 *     *   `processNextTask()`: Removes the task from the front of the pending tasks queue and adds it to the completed tasks list. If the pending queue is empty, report an error.
 *     *   `viewPendingTasks()`: Prints the details of all tasks currently in the pending queue. If the queue is empty, report that there are no pending tasks.
 *     *   `viewCompletedTasks()`: Prints the details of all tasks currently in the completed tasks list. If the list is empty, report that no tasks have been completed yet.
 *     *   `run()`: This method should contain the main application loop. It should display a menu to the user and handle user input using `java.util.Scanner`. The loop should continue until the user chooses to exit.
 * 
 * 4.  **User Interface and Flow Control:**
 *     *   The `run()` method should display a menu with options:
 *         1.  Add New Task
 *         2.  Process Next Pending Task
 *         3.  View Pending Tasks
 *         4.  View Completed Tasks
 *         5.  Exit
 *     *   Use a `switch` statement in the `run()` method to handle the user's menu choice.
 *     *   Validate user input. If the user enters a non-integer or an invalid menu option, display an error message and prompt again.
 * 
 * 5.  **Error Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks within the `run()` method to gracefully handle potential issues, such as invalid input format when reading the menu choice.
 *     *   Use `System.err.println()` to print error messages (e.g., invalid input, attempting to process an empty queue).
 *     *   Use `System.out.println()` for all other output (menu, prompts, task lists, success messages).
 * 
 * 6.  **Best Practices:**
 *     *   Apply proper encapsulation by making attributes private and providing public methods for interaction.
 *     *   Use meaningful names for classes, variables, and methods.
 *     *   Include appropriate comments or Javadoc to explain the code.
 *     *   Ensure clean code structure.
 * 
 * **Expected Output Examples:**
 * 
 * *   **Menu Display:**
 *     ```
 *     --- Task Dispatcher Menu ---
 *     1. Add New Task
 *     2. Process Next Pending Task
 *     3. View Pending Tasks
 *     4. View Completed Tasks
 *     5. Exit
 *     Enter your choice:
 *     ```
 * *   **Adding a Task:**
 *     ```
 *     Enter task description: Prepare exam question
 *     Task added: Task [ID: 1, Description: Prepare exam question]
 *     ```
 * *   **Viewing Pending Tasks (non-empty):**
 *     ```
 *     --- Pending Tasks ---
 *     Task [ID: 1, Description: Prepare exam question]
 *     Task [ID: 2, Description: Grade assignments]
 *     ---------------------
 *     ```
 * *   **Viewing Pending Tasks (empty):**
 *     ```
 *     No pending tasks.
 *     ```
 * *   **Processing a Task:**
 *     ```
 *     Processing task: Task [ID: 1, Description: Prepare exam question]
 *     Task processed successfully.
 *     ```
 * *   **Processing a Task (empty queue):**
 *     ```
 *     Error: No pending tasks to process.
 *     ```
 * *   **Viewing Completed Tasks (non-empty):**
 *     ```
 *     --- Completed Tasks ---
 *     Task [ID: 1, Description: Prepare exam question]
 *     -----------------------
 *     ```
 * *   **Viewing Completed Tasks (empty):**
 *     ```
 *     No tasks completed yet.
 *     ```
 * *   **Invalid Input:**
 *     ```
 *     Invalid input. Please enter a number between 1 and 5.
 *     ```
 * *   **Exiting:**
 *     ```
 *     Exiting Task Dispatcher. Goodbye!
 *     ```
 * 
 * Your solution should be a single Java file containing the `Task` class and the `TaskDispatcher` class with a `main` method to start the application.
 * 
 * ```java
 * // Your code goes here
 * ```
 *
 * EXPLANATION:
 * The solution implements a Task Dispatcher system as required, demonstrating the practical use of various Java constructs.
 * 
 * 1.  **`Task` Class:**
 *     *   This class serves as a simple Plain Old Java Object (POJO) to represent a task.
 *     *   It has private fields (`id`, `description`) ensuring encapsulation.
 *     *   Public getter methods provide controlled access to the data.
 *     *   The `toString()` method provides a convenient formatted string representation for printing, adhering to the requirement.
 * 
 * 2.  **`TaskDispatcher` Class:**
 *     *   This is the main class that orchestrates the task management.
 *     *   **`Queue<Task> pendingTasks`**: A `LinkedList` is used here, implemented as a `Queue`. This is appropriate because a queue naturally models pending items where tasks are added to the rear (`offer`) and processed from the front (`poll`).
 *     *   **`List<Task> completedTasks`**: An `ArrayList` is used, declared with the `List` interface. This is suitable for storing completed tasks where order might be relevant for viewing, and random access (though not explicitly used here) is efficient. Using the `List` interface for declaration promotes flexibility.
 *     *   **`private int nextTaskId`**: A simple counter to ensure each task gets a unique ID.
 *     *   **`private final Scanner scanner`**: Used for reading user input from the console. Declared as `final` because the reference won't change.
 * 
 * 3.  **Functionality Methods:**
 *     *   **`addTask(String description)`**: Creates a `Task`, assigns the `nextTaskId`, adds it to the `pendingTasks` queue using `offer()`, and increments the ID counter. Includes basic validation for the description.
 *     *   **`processNextTask()`**: Uses `poll()` to retrieve and remove the task at the head of the `pendingTasks` queue. `poll()` returns `null` if the queue is empty, which is handled to display an error message using `System.err`. If a task is retrieved, it's added to the `completedTasks` list.
 *     *   **`viewPendingTasks()`**: Iterates through the `pendingTasks` queue using an enhanced for loop (which doesn't remove elements) and prints each task. Checks if the queue is empty first.
 *     *   **`viewCompletedTasks()`**: Iterates through the `completedTasks` list and prints each task. Checks if the list is empty first.
 *     *   **`displayMenu()`**: A helper method to print the user menu using `System.out`.
 *     *   **`run()`**: Contains the core application loop.
 * 
 * 4.  **User Interface and Flow Control (`run()` method):**
 *     *   A `while` loop continues until the user enters '5' to exit.
 *     *   Inside the loop, the menu is displayed, and user input is read using `scanner.nextInt()`.
 *     *   `scanner.nextLine()` is called immediately after `nextInt()` to consume the leftover newline character, preventing issues in subsequent `scanner.nextLine()` calls (like reading the task description).
 *     *   A `switch` statement is used to direct execution based on the user's integer choice. Each case calls the appropriate `TaskDispatcher` method.
 *     *   The `default` case in the `switch` handles invalid integer choices within the expected range (1-5) but outside the valid options, printing an error to `System.err`.
 * 
 * 5.  **Error Handling:**
 *     *   A `try-catch` block wraps the core logic within the `run()` loop.
 *     *   `catch (InputMismatchException e)` specifically handles cases where the user enters non-integer input when the program expects an integer (for the menu choice). An error message is printed to `System.err`, and `scanner.next()` is called to consume the invalid token from the input stream, preventing an infinite loop.
 *     *   A general `catch (Exception e)` is included as a fallback for any other unexpected runtime errors, demonstrating robustness.
 *     *   Error messages for operations like processing an empty queue or providing an empty task description are handled within their respective methods and printed using `System.err.println()`, as required.
 *     *   `System.out.println()` is used for all normal output, including the menu, prompts, and task listings.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation is used in both `Task` and `TaskDispatcher` classes.
 *     *   Meaningful names like `pendingTasks`, `completedTasks`, `processNextTask`, `viewPendingTasks` are used.
 *     *   Basic comments and Javadoc-style comments are included to explain the purpose of classes and methods.
 *     *   The code is structured into logical methods within the `TaskDispatcher` class.
 *     *   Input validation (checking for empty description, handling `InputMismatchException`) and error handling (checking for empty queue/list before processing/viewing) are implemented.
 *     *   The `Scanner` resource is closed when the application exits.
 * 
 * This solution effectively utilizes all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) in a cohesive, practical scenario, demonstrating good object-oriented design and error management practices suitable for an advanced exam task.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single task with an ID and description.
 */
class Task {
    private final int id;
    private final String description;

    /**
     * Constructs a new Task.
     * @param id The unique identifier for the task.
     * @param description The description of the task.
     */
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Gets the task ID.
     * @return The task ID.
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

    /**
     * Returns a string representation of the Task.
     * @return Formatted string for the task.
     */
    @Override
    public String toString() {
        return "Task [ID: " + id + ", Description: " + description + "]";
    }
}

/**
 * Manages pending and completed tasks using a queue and a list.
 */
public class TaskDispatcher {
    private final Queue<Task> pendingTasks;
    private final List<Task> completedTasks;
    private int nextTaskId;
    private final Scanner scanner;

    /**
     * Constructs a new TaskDispatcher.
     * Initializes the pending tasks queue, completed tasks list,
     * task ID counter, and scanner.
     */
    public TaskDispatcher() {
        this.pendingTasks = new LinkedList<>(); // Use LinkedList as Queue implementation
        this.completedTasks = new ArrayList<>(); // Use ArrayList as List implementation
        this.nextTaskId = 1;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task to the pending tasks queue.
     * @param description The description for the new task.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }
        Task newTask = new Task(nextTaskId++, description.trim());
        pendingTasks.offer(newTask); // offer is preferred over add for capacity-restricted queues, but fine here
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task in the pending queue by moving it to the completed list.
     */
    public void processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // Retrieves and removes the head of the queue
        if (taskToProcess != null) {
            System.out.println("Processing task: " + taskToProcess);
            completedTasks.add(taskToProcess);
            System.out.println("Task processed successfully.");
        } else {
            System.err.println("Error: No pending tasks to process.");
        }
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    public void viewPendingTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            System.out.println("--- Pending Tasks ---");
            // Iterate through the queue without removing elements
            for (Task task : pendingTasks) {
                System.out.println(task);
            }
            System.out.println("---------------------");
        }
    }

    /**
     * Displays all tasks currently in the completed list.
     */
    public void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks completed yet.");
        } else {
            System.out.println("--- Completed Tasks ---");
            for (Task task : completedTasks) {
                System.out.println(task);
            }
            System.out.println("-----------------------");
        }
    }

    /**
     * Displays the main menu.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Dispatcher Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Pending Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop, handling user input and menu choices.
     */
    public void run() {
        int choice = -1;
        while (choice != 5) {
            try {
                displayMenu();
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        addTask(description);
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
                        System.out.println("Exiting Task Dispatcher. Goodbye!");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to stay in loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the Task Dispatcher application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskDispatcher dispatcher = new TaskDispatcher();
        dispatcher.run();
    }
}
