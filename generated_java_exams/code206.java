/*
 * Exam Question #206
 * Generated on: 2025-05-11 22:31:45
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Team Task Management System
 * 
 * **Objective:** Design and implement a simple console-based Task Management System for a small team. The system should allow users to add tasks, view pending tasks, view all tasks (including completed ones), mark tasks as completed, and exit. This task requires demonstrating proficiency in using various core Java collections and control flow structures, along with robust error handling and adherence to best practices.
 * 
 * **System Requirements:**
 * 
 * 1.  **Task Representation:** Each task must have a unique integer ID, a description (String), and a status (pending or completed).
 * 2.  **Task Storage:**
 *     *   Maintain a master list of *all* tasks created, identified by their unique ID. This list should allow easy lookup by ID.
 *     *   Maintain a separate collection representing tasks that are currently *pending*. When a task is added, it is pending. When it is marked complete, it is removed from the pending collection. The pending collection should conceptually represent tasks waiting for attention.
 * 3.  **User Interface:** Provide a simple text-based menu in the console for the user to interact with the system.
 * 4.  **Functionality:**
 *     *   **Add Task:** Prompt the user for a task description. Create a new task with a unique ID and pending status, add it to both the master list and the pending collection.
 *     *   **View Pending Tasks:** Display all tasks that are currently in the pending collection.
 *     *   **View All Tasks:** Display all tasks ever created, including both pending and completed ones.
 *     *   **Complete Task:** Prompt the user for a task ID. Find the task by ID. If found and pending, mark it as completed and remove it from the pending collection. Handle cases where the ID is not found or the task is already completed.
 *     *   **Exit:** Terminate the application.
 * 
 * **Technical Requirements:**
 * 
 * Your solution *must* use the following Java components:
 * 
 * *   `java.util.Queue`: To manage the collection of *pending* task IDs. When a task is completed, its ID must be removed from this queue.
 * *   `java.util.ArrayList`: As the concrete implementation for the master list of *all* tasks.
 * *   `java.util.List`: Use the `List` interface type when declaring the variable for the master list, demonstrating polymorphism.
 * *   `java.util.Scanner`: To read user input from the console.
 * *   `switch` statement: To handle the main menu options.
 * *   `System.err`: To output error messages (e.g., invalid input, task not found).
 * *   `System.out`: To output normal messages (menu, task details, success messages).
 * *   Class-wide exception handling with `try-catch` blocks: Implement exception handling that wraps the main application loop or core logic to gracefully handle potential runtime issues, particularly input errors.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Create a `Task` class with private fields and public methods (getters, `markComplete`). The main management class should also use private fields for its collections and scanner.
 * *   **Meaningful Names:** Use descriptive names for classes, variables, and methods.
 * *   **Comments:** Include comments where necessary to explain complex logic or the purpose of classes/methods.
 * *   **Input Validation:** Validate user input (e.g., ensure task description is not empty, handle non-integer input when expecting numbers).
 * *   **Proper Error Handling:** Use `System.err` for errors and provide informative messages. Handle exceptions appropriately.
 * *   **Clean Code Structure:** Organize code logically into classes and methods.
 * 
 * **Expected Output:**
 * 
 * The system should present a menu, accept user input, and display information or error messages based on the selected action. Task lists should clearly show the task ID, description, and status.
 * 
 * ```
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice:
 * ```
 * 
 * Example interaction for adding a task:
 * ```
 * Enter task description: Implement login feature
 * Task 1 added.
 * ```
 * 
 * Example interaction for viewing pending tasks:
 * ```
 * --- Pending Tasks ---
 * [ID: 1, Description: Implement login feature, Status: Pending]
 * ```
 * 
 * Example interaction for completing a task:
 * ```
 * Enter Task ID to complete: 1
 * Task 1 marked as completed.
 * ```
 * 
 * Example interaction with errors:
 * ```
 * Enter Task ID to complete: 99 // Non-existent ID
 * Error: Task with ID 99 not found.
 * Enter your choice: abc // Invalid input type
 * Error: Invalid input. Please enter a number.
 * ```
 * 
 * Your solution should be a single `.java` file containing the necessary classes.
 *
 * EXPLANATION:
 * The solution implements a simple Task Management System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Task` Class:** This class encapsulates the data for a single task: `id`, `description`, and `isCompleted`. It follows encapsulation principles with private fields and public getter methods. The `markComplete()` method provides controlled modification of the task's status. Input validation for the description is included in the constructor, throwing an `IllegalArgumentException` for empty input. The `toString()` method provides a convenient way to display task details.
 * 
 * 2.  **`TaskManager` Class:** This is the main class containing the application logic.
 *     *   **Collections:**
 *         *   `List<Task> allTasks = new ArrayList<>();`: Declares a `List` variable initialized with an `ArrayList`. This list serves as the master repository of all tasks ever created. Using `List` as the type demonstrates the use of the interface. `ArrayList` provides efficient random access, which is useful for potentially finding tasks by index (though we find by ID here by iterating).
 *         *   `Queue<Integer> pendingTaskIdsQueue = new LinkedList<>();`: Declares a `Queue` variable initialized with a `LinkedList`. The `Queue` is used to hold the IDs of tasks that are currently pending. A `Queue` is suitable here to represent tasks conceptually waiting in line, although the "complete by ID" functionality means we don't strictly process them FIFO using `poll()`. Instead, we add (`offer`) IDs when tasks are created and remove (`remove(Object)`) IDs when tasks are completed. `LinkedList` is a common implementation of `Queue` that supports efficient additions/removals from ends and also provides the `remove(Object)` method needed to remove a specific ID.
 *     *   **`Scanner`:** A `Scanner` object is used to read user input from `System.in`. It's declared as a private field and initialized in the constructor. A `closeScanner()` method is provided to release the resource, called in the `finally` block.
 *     *   **`nextTaskId`:** An integer counter ensures each task gets a unique ID.
 *     *   **`run()` Method:** This method contains the main application loop (`while(running)`).
 *         *   **Class-wide `try-catch`:** A `try-catch` block wraps the entire `while` loop. This fulfills the requirement for class-wide exception handling. It specifically catches `InputMismatchException` which can occur if the user enters non-integer input when the `scanner.nextInt()` is expected (like for menu choice or task ID). It also includes a general `catch (Exception e)` to handle any other unforeseen runtime errors, printing the message and stack trace to `System.err`. The `finally` block ensures the scanner is closed upon exiting the `try` block (whether normally or due to an exception).
 *         *   **Input Consumption:** After `scanner.nextInt()`, `scanner.nextLine()` is called. This is crucial to consume the leftover newline character, preventing issues with subsequent `scanner.nextLine()` calls in methods like `addTask`. This is handled within the `try-catch` block for `nextInt` to ensure it runs even if `nextInt` throws an exception.
 *         *   **`switch` Statement:** Inside the loop, a `switch` statement is used to direct execution based on the user's menu choice, fulfilling that requirement.
 *         *   `System.out` and `System.err`: `System.out.println()` is used for the menu, task listings, and success messages. `System.err.println()` is used for displaying error conditions like invalid choices, task not found, or input errors caught by the `try-catch`.
 *     *   **`addTask()`:** Prompts for a description, creates a `Task` object, adds it to `allTasks`, and adds its ID to `pendingTaskIdsQueue` using `offer()`. Includes a `try-catch` specifically for the `IllegalArgumentException` from the `Task` constructor's validation.
 *     *   **`viewPendingTasks()`:** Iterates through the `pendingTaskIdsQueue`. For each task ID in the queue, it uses the `findTaskById()` helper method to retrieve the full `Task` object from `allTasks` and prints its details. This shows how the `Queue` is used to keep track of *which* tasks are pending, while `allTasks` holds the task data.
 *     *   **`viewAllTasks()`:** Iterates through the `allTasks` list (which is an `ArrayList` used via the `List` interface) and prints every task.
 *     *   **`completeTask()`:** Prompts for a task ID. It includes a `try-catch` specifically for reading the integer ID to handle `InputMismatchException` locally before the main class-wide catch. It uses `findTaskById()` to locate the task. If found and pending, it calls `task.markComplete()` and then removes the task's ID from the `pendingTaskIdsQueue` using `pendingTaskIdsQueue.remove(Integer.valueOf(taskIdToComplete))`. Using `Integer.valueOf()` ensures we call the `remove(Object)` method (which removes the first occurrence of the specified element by value) rather than `remove(int index)` (which would remove by position). Error messages for not found or already completed tasks are printed to `System.err` or `System.out` respectively.
 *     *   **`findTaskById()`:** A private helper method that iterates through `allTasks` to find a task by its ID.
 *     *   **`main()` Method:** The entry point of the application, creating a `TaskManager` instance and calling its `run()` method.
 * 
 * This solution effectively integrates all the required Java components within a practical scenario, demonstrating collection usage, control flow (`switch`, loops), input handling (`Scanner`), robust error handling (`try-catch`, `System.err`), and adherence to object-oriented principles (encapsulation).
 */

import java.util.*;

// Represents a single task
class Task {
    private int id;
    private String description;
    private boolean isCompleted;

    // Constructor
    public Task(int id, String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        this.id = id;
        this.description = description.trim();
        this.isCompleted = false; // Tasks are pending by default
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark the task as complete
    public void markComplete() {
        this.isCompleted = true;
    }

    // String representation for displaying task details
    @Override
    public String toString() {
        return "[ID: " + id + ", Description: " + description + ", Status: " + (isCompleted ? "Completed" : "Pending") + "]";
    }
}

// Manages the collection of tasks
public class TaskManager {

    // Master list of all tasks (uses List interface, implemented by ArrayList)
    private List<Task> allTasks;
    // Queue of pending task IDs (uses Queue interface, implemented by LinkedList)
    private Queue<Integer> pendingTaskIdsQueue;
    private int nextTaskId; // Counter for generating unique task IDs
    private Scanner scanner; // Scanner for user input

    // Constructor
    public TaskManager() {
        // Initialize collections and scanner
        allTasks = new ArrayList<>();
        pendingTaskIdsQueue = new LinkedList<>(); // LinkedList implements Queue
        nextTaskId = 1; // Start task IDs from 1
        scanner = new Scanner(System.in);
    }

    // Main application loop
    public void run() {
        boolean running = true;

        // Class-wide try-catch block wrapping the main loop
        try {
            while (running) {
                displayMenu();
                System.out.print("Enter your choice: ");

                // Read user choice, handle potential InputMismatchException
                int choice = -1; // Default to an invalid choice
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop iteration
                } finally {
                     // Consume the newline character left by nextInt()
                     // This needs to be done regardless of exception for nextLine() calls later
                     if (scanner.hasNextLine()) {
                        scanner.nextLine();
                     }
                }


                // Switch statement to handle menu options
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        viewPendingTasks();
                        break;
                    case 3:
                        viewAllTasks();
                        break;
                    case 4:
                        completeTask();
                        break;
                    case 5:
                        running = false; // Set flag to exit loop
                        System.out.println("Exiting Task Management System.");
                        break;
                    default:
                        // Handle invalid choice
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
                System.out.println(); // Add a newline for better readability between actions
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions during execution
            System.err.println("An unexpected application error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure scanner is closed when the application exits
            closeScanner();
        }
    }

    // Displays the main menu
    private void displayMenu() {
        System.out.println("--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. View Pending Tasks");
        System.out.println("3. View All Tasks");
        System.out.println("4. Complete Task");
        System.out.println("5. Exit");
    }

    // Adds a new task based on user input
    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        try {
            // Create a new task
            Task newTask = new Task(nextTaskId, description);

            // Add to the master list
            allTasks.add(newTask);
            // Add the task ID to the pending queue
            pendingTaskIdsQueue.offer(newTask.getId()); // offer is good practice for queues

            System.out.println("Task " + newTask.getId() + " added.");
            nextTaskId++; // Increment for the next task
        } catch (IllegalArgumentException e) {
            // Handle validation error from Task constructor
            System.err.println("Error adding task: " + e.getMessage());
        }
    }

    // Views tasks that are currently pending
    private void viewPendingTasks() {
        System.out.println("--- Pending Tasks ---");
        if (pendingTaskIdsQueue.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }

        // Iterate through the queue of pending task IDs
        // Note: Iterating a Queue does not remove elements
        for (Integer taskId : pendingTaskIdsQueue) {
            // Find the actual Task object in the master list using the ID
            Task task = findTaskById(taskId);
            // Should not be null if logic is correct, but good defensive programming
            if (task != null && !task.isCompleted()) {
                 System.out.println(task);
            }
             // If task is null or completed, it shouldn't be in the pendingTaskIdsQueue anyway,
             // but this loop ensures we only print pending ones found via the queue.
        }
    }

    // Views all tasks, including completed ones
    private void viewAllTasks() {
        System.out.println("--- All Tasks ---");
        if (allTasks.isEmpty()) {
            System.out.println("No tasks created yet.");
            return;
        }

        // Iterate through the master list (ArrayList/List)
        for (Task task : allTasks) {
            System.out.println(task);
        }
    }

    // Marks a task as completed based on user-provided ID
    private void completeTask() {
        System.out.print("Enter Task ID to complete: ");
        int taskIdToComplete = -1;

        // Handle potential InputMismatchException for ID input
        try {
            taskIdToComplete = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter a valid number for Task ID.");
            scanner.nextLine(); // Consume the invalid input
            return; // Exit the method
        } finally {
            // Consume the newline character left by nextInt()
             if (scanner.hasNextLine()) {
                scanner.nextLine();
             }
        }


        // Find the task in the master list
        Task taskToComplete = findTaskById(taskIdToComplete);

        // Validate if task was found
        if (taskToComplete == null) {
            System.err.println("Error: Task with ID " + taskIdToComplete + " not found.");
            return;
        }

        // Check if the task is already completed
        if (taskToComplete.isCompleted()) {
            System.out.println("Task " + taskIdToComplete + " is already completed.");
            return;
        }

        // Mark the task as complete
        taskToComplete.markComplete();

        // Remove the task ID from the pending queue
        // Use remove(Object) with Integer.valueOf to remove by value, not index
        boolean removedFromQueue = pendingTaskIdsQueue.remove(Integer.valueOf(taskIdToComplete));

        if (removedFromQueue) {
            System.out.println("Task " + taskIdToComplete + " marked as completed.");
        } else {
             // This case indicates a logic error where a pending task ID wasn't in the queue
             System.err.println("Warning: Task " + taskIdToComplete + " was marked complete, but its ID was not found in the pending queue.");
        }
    }

    // Helper method to find a task by its ID in the master list
    private Task findTaskById(int id) {
        // Iterate through the master list (ArrayList/List)
        for (Task task : allTasks) {
            if (task.getId() == id) {
                return task; // Return the task if ID matches
            }
        }
        return null; // Return null if no task with the given ID is found
    }

    // Closes the scanner resource
    private void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run();
    }
}
