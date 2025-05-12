/*
 * Exam Question #13
 * Generated on: 2025-05-11 21:33:17
 * 
 * QUESTION:
 * **Project Task Processor System**
 * 
 * You are tasked with developing a simple command-line application for managing tasks within a small project team. The system should allow users to add new tasks, process the next pending task, view pending tasks, and view completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following attributes:
 *     *   `taskId` (int): A unique identifier for the task.
 *     *   `description` (String): A brief description of the task.
 *     *   `status` (enum or String): The current status of the task (e.g., "Pending", "Completed"). Use a String for simplicity in this exercise.
 *     *   The class should have a constructor and public getter methods for its attributes. Override the `toString()` method for easy printing of task details.
 * 
 * 2.  **Task Management Logic:** Create a `TaskProcessor` class responsible for managing the collections of tasks.
 *     *   It must maintain a collection of tasks that are waiting to be processed. This collection *must* be a `java.util.Queue`.
 *     *   It must maintain a collection of tasks that have been completed. This collection *must* be declared as a `java.util.List` and implemented using `java.util.ArrayList`.
 *     *   Implement the following public methods:
 *         *   `addTask(String description)`: Creates a new `Task` with a unique ID, sets its status to "Pending", and adds it to the pending task queue.
 *         *   `processNextTask()`: Retrieves the next task from the pending queue, changes its status to "Completed", and moves it to the completed tasks list. If there are no pending tasks, it should indicate this condition without crashing.
 *         *   `viewPendingTasks()`: Prints the details of all tasks currently in the pending queue.
 *         *   `viewCompletedTasks()`: Prints the details of all tasks currently in the completed tasks list.
 * 
 * 3.  **User Interface:** Create a main application class (e.g., `ProjectTaskProcessorApp`) with a `main` method.
 *     *   Use `java.util.Scanner` to get user input from the console.
 *     *   Present a menu to the user with options:
 *         1. Add New Task
 *         2. Process Next Task
 *         3. View Pending Tasks
 *         4. View Completed Tasks
 *         5. Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   The application should run in a loop until the user chooses to exit.
 * 
 * 4.  **Error Handling:**
 *     *   Implement input validation for the menu choice (ensure it's an integer within the valid range).
 *     *   Implement class-wide exception handling in the main application loop using a `try-catch` block to catch potential `InputMismatchException` (if the user enters non-integer input) or other unexpected errors during a loop iteration. Display an informative error message using `System.err`.
 *     *   Handle the case where `processNextTask()` is called when the pending queue is empty. Report this condition using `System.err`.
 *     *   Handle the case where a user tries to add a task with an empty description, reporting the error using `System.err`.
 * 
 * 5.  **Best Practices:**
 *     *   Use proper encapsulation (private fields, public methods/getters).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (briefly explain classes and methods).
 *     *   Use `System.out` for normal output (menu, prompts, task lists) and `System.err` for error messages.
 * 
 * **Expected Output:**
 * 
 * *   The program should display a menu upon starting and after each operation (except exit).
 * *   Adding a task should confirm the task was added.
 * *   Processing a task should indicate which task was processed or report if the queue is empty.
 * *   Viewing tasks should list them with their ID, description, and status, or indicate if the list is empty.
 * *   Invalid menu input or other errors should be reported to `System.err`.
 * *   Exiting the program should terminate the application.
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * Project Task Processor Menu:
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Implement login feature
 * 
 * Task added: Task [id=1, description=Implement login feature, status=Pending]
 * 
 * Project Task Processor Menu:
 * ...
 * Enter your choice: 1
 * Enter task description: Design database schema
 * 
 * Task added: Task [id=2, description=Design database schema, status=Pending]
 * 
 * Project Task Processor Menu:
 * ...
 * Enter your choice: 3
 * 
 * --- Pending Tasks ---
 * Task [id=1, description=Implement login feature, status=Pending]
 * Task [id=2, description=Design database schema, status=Pending]
 * ---------------------
 * 
 * Project Task Processor Menu:
 * ...
 * Enter your choice: 2
 * 
 * Processed task: Task [id=1, description=Implement login feature, status=Completed]
 * 
 * Project Task Processor Menu:
 * ...
 * Enter your choice: 3
 * 
 * --- Pending Tasks ---
 * Task [id=2, description=Design database schema, status=Pending]
 * ---------------------
 * 
 * Project Task Processor Menu:
 * ...
 * Enter your choice: 4
 * 
 * --- Completed Tasks ---
 * Task [id=1, description=Implement login feature, status=Completed]
 * -----------------------
 * 
 * Project Task Processor Menu:
 * ...
 * Enter your choice: 9
 * Invalid choice. Please enter a number between 1 and 5.
 * 
 * Project Task Processor Menu:
 * ...
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number.
 * 
 * Project Task Processor Menu:
 * ...
 * Enter your choice: 5
 * Exiting Task Processor. Goodbye!
 * ```
 *
 * EXPLANATION:
 * This solution implements a simple Project Task Processor system, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Task` Class:** This class is a simple Plain Old Java Object (POJO) representing a task. It has private fields (`taskId`, `description`, `status`) and public getter methods, adhering to encapsulation principles. The `setStatus` method allows changing the task's state when it's processed. The `toString()` method is overridden for convenient printing of task details.
 * 
 * 2.  **`TaskProcessor` Class:** This class encapsulates the core logic for managing tasks.
 *     *   It uses a `Queue<Task>` (`pendingTasks`) implemented by `LinkedList` to store tasks waiting to be done. A `Queue` is appropriate here because tasks are processed in the order they are added (First-In, First-Out - FIFO).
 *     *   It uses a `List<Task>` (`completedTasks`) declared using the `List` interface and implemented by `ArrayList` to store finished tasks. `ArrayList` provides dynamic resizing and efficient element access, suitable for storing completed items. Using the `List` interface for the variable type is a good practice demonstrating polymorphism.
 *     *   `nextTaskId` is a simple counter to ensure each task gets a unique ID.
 *     *   `addTask`: Creates a new `Task` object and uses `pendingTasks.offer()` to add it to the end of the queue. `offer()` is safer than `add()` as it doesn't throw an exception if the queue is capacity-constrained (though `LinkedList` is not). Input validation ensures the description is not empty.
 *     *   `processNextTask`: Uses `pendingTasks.poll()` to retrieve and remove the task at the front of the queue. `poll()` returns `null` if the queue is empty, which is checked to provide an informative error message using `System.err` instead of crashing. If a task is retrieved, its status is updated, and it's added to the `completedTasks` list.
 *     *   `viewPendingTasks`: Iterates through the `pendingTasks` queue using an enhanced for loop. This allows viewing elements without removing them. It checks if the queue is empty before iterating. Output is directed to `System.out`.
 *     *   `viewCompletedTasks`: Iterates through the `completedTasks` `ArrayList`. It checks if the list is empty. Output is directed to `System.out`.
 * 
 * 3.  **`ProjectTaskProcessorApp` Class:** This is the main entry point of the application.
 *     *   It uses `Scanner` to read input from `System.in`.
 *     *   The application runs in a `while(running)` loop.
 *     *   Inside the loop, a menu is displayed using `System.out`.
 *     *   **Class-wide Exception Handling:** A `try-catch` block wraps the input reading (`scanner.nextInt()`) and the `switch` statement execution.
 *         *   It specifically catches `InputMismatchException` if the user enters non-integer input for the menu choice, prints an error to `System.err`, and consumes the invalid input from the scanner buffer (`scanner.nextLine()`) to prevent an infinite loop.
 *         *   A general `catch (Exception e)` is included as a fallback to catch any other unexpected runtime errors that might occur during the processing of a single loop iteration, printing a generic error message to `System.err`.
 *     *   **`switch` Statement:** Controls the program flow based on the user's valid menu choice, calling the appropriate methods on the `TaskProcessor` object.
 *     *   Option 5 sets `running` to `false`, exiting the loop and terminating the program.
 *     *   A `default` case in the `switch` handles valid integer inputs that are outside the menu range, printing an error to `System.err`.
 *     *   `scanner.close()` is called after the loop exits to release system resources.
 * 
 * 4.  **Best Practices:**
 *     *   **Encapsulation:** `Task` and `TaskProcessor` demonstrate proper encapsulation with private fields and public methods.
 *     *   **Naming:** Clear and descriptive names are used for classes, methods, and variables (e.g., `pendingTasks`, `processNextTask`, `description`).
 *     *   **Comments:** Javadoc-style comments explain the purpose of classes and key methods. Inline comments clarify specific implementation details.
 *     *   **Input Validation:** The `addTask` method validates the description, and the main loop handles invalid menu input types and ranges.
 *     *   **Error Handling:** Specific error messages are provided for empty queue processing, invalid task descriptions, and invalid user input. `System.err` is correctly used for these messages.
 *     *   **Output:** `System.out` is used for all normal program output, prompts, and results.
 * 
 * This solution effectively integrates all required components (`Queue`, `ArrayList`, `List`, `Scanner`, `Switch`, `System.err`, `System.out`, `try-catch`) within a practical, menu-driven application, demonstrating understanding of data structures, object-oriented principles, flow control, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a single task with ID, description, and status.
class Task {
    private int taskId;
    private String description;
    private String status; // Using String for simplicity as requested

    // Constructor
    public Task(int taskId, String description, String status) {
        this.taskId = taskId;
        this.description = description;
        this.status = status;
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
        return "Task [id=" + taskId + ", description=" + description + ", status=" + status + "]";
    }
}

// Manages the collections of pending and completed tasks.
class TaskProcessor {
    // Use Queue for pending tasks (FIFO)
    private Queue<Task> pendingTasks;
    // Use List/ArrayList for completed tasks
    private List<Task> completedTasks;
    private int nextTaskId; // Counter for generating unique task IDs

    // Constructor
    public TaskProcessor() {
        this.pendingTasks = new LinkedList<>(); // LinkedList is a common Queue implementation
        this.completedTasks = new ArrayList<>(); // ArrayList implements List
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the pending queue.
     *
     * @param description The description of the new task.
     * @return The newly created Task object, or null if description is invalid.
     */
    public Task addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return null;
        }
        Task newTask = new Task(nextTaskId++, description.trim(), "Pending");
        pendingTasks.offer(newTask); // offer is generally preferred over add for queues
        return newTask;
    }

    /**
     * Processes the next task in the pending queue.
     * Moves the task to the completed list after changing its status.
     *
     * @return The processed Task object, or null if no tasks were pending.
     */
    public Task processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // poll retrieves and removes, returns null if empty
        if (taskToProcess == null) {
            System.err.println("Error: No tasks currently pending to process.");
            return null;
        }
        taskToProcess.setStatus("Completed");
        completedTasks.add(taskToProcess);
        return taskToProcess;
    }

    /**
     * Prints all tasks currently in the pending queue.
     */
    public void viewPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            // Iterate through the queue without removing elements
            for (Task task : pendingTasks) {
                System.out.println(task);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Prints all tasks currently in the completed tasks list.
     */
    public void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
        System.out.println("-----------------------");
    }
}

// Main application class with user interface.
public class ProjectTaskProcessorApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskProcessor processor = new TaskProcessor();
        boolean running = true;

        System.out.println("Welcome to Project Task Processor!");

        while (running) {
            displayMenu();
            int choice = -1; // Default invalid choice

            // Class-wide exception handling for the main loop iteration
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt(); // Read integer choice
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Switch statement for menu navigation
                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        Task addedTask = processor.addTask(description);
                        if (addedTask != null) {
                            System.out.println("\nTask added: " + addedTask);
                        }
                        break;
                    case 2:
                        Task processedTask = processor.processNextTask();
                        if (processedTask != null) {
                            System.out.println("\nProcessed task: " + processedTask);
                        }
                        break;
                    case 3:
                        processor.viewPendingTasks();
                        break;
                    case 4:
                        processor.viewCompletedTasks();
                        break;
                    case 5:
                        running = false; // Exit the loop
                        System.out.println("Exiting Task Processor. Goodbye!");
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handle non-integer input
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging
            }
            System.out.println(); // Add a newline for better readability between iterations
        }

        scanner.close(); // Close the scanner when exiting
    }

    // Helper method to display the menu
    private static void displayMenu() {
        System.out.println("Project Task Processor Menu:");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
    }
}
