/*
 * Exam Question #1030
 * Generated on: 2025-05-12 17:15:14
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Priority Task Manager System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple command-line application for managing tasks based on their priority. The system should allow users to add new tasks, process the highest priority pending task, and view lists of tasks.
 * 
 * Each task has:
 * *   A description (String)
 * *   A priority level (High, Medium, Low)
 * *   A status (Pending, Completed)
 * 
 * The system should prioritize tasks as follows: High priority tasks are processed before Medium, and Medium before Low. Tasks with the same priority should be processed in the order they were added (though the `PriorityQueue` doesn't strictly guarantee FIFO for equal elements, for this problem, processing *any* of the highest priority tasks is acceptable).
 * 
 * **Required Functionality:**
 * 
 * 1.  **Add Task:** Prompt the user for a task description and priority (High, Medium, or Low). Create a new task with status "Pending" and add it to the system.
 * 2.  **Process Next Task:** Find the highest priority pending task, change its status to "Completed", and move it to a list of completed tasks. If no pending tasks exist, inform the user.
 * 3.  **View Pending Tasks:** Display all tasks currently in the pending state, ordered by priority.
 * 4.  **View Completed Tasks:** Display all tasks that have been marked as completed.
 * 5.  **View All Tasks:** Display both pending and completed tasks.
 * 6.  **Exit:** Terminate the application.
 * 
 * **Technical Requirements:**
 * 
 * Your solution must explicitly use and demonstrate understanding of the following Java components:
 * 
 * *   `java.util.Queue` (specifically, use `java.util.PriorityQueue` for pending tasks)
 * *   `java.util.ArrayList`
 * *   `java.util.List` interface (declare variables using `List`)
 * *   `java.util.Scanner` for all user input
 * *   `switch` statement for handling the main menu options
 * *   `System.err` for displaying error messages (e.g., invalid input, attempting to process when no tasks are pending)
 * *   `System.out` for displaying the menu, task information, and success messages
 * *   Class-wide exception handling using `try-catch` blocks to manage potential runtime errors (e.g., invalid input format).
 * 
 * **Best Practices Requirements:**
 * 
 * *   Implement proper encapsulation (private fields, public methods).
 * *   Use meaningful variable and method names.
 * *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 * *   Validate user input where necessary (e.g., priority level).
 * *   Handle errors gracefully using `System.err` and informative messages.
 * *   Structure your code into appropriate classes (`Task`, `TaskManagementSystem`, and a main application class).
 * 
 * **Example Interaction (partial):**
 * 
 * ```
 * --- Task Manager Menu ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. View All Tasks
 * 6. Exit
 * Enter your choice: 1
 * Enter task description: Write exam question
 * Enter priority (HIGH, MEDIUM, LOW): HIGH
 * Task added: Write exam question [HIGH, PENDING]
 * 
 * --- Task Manager Menu ---
 * 1. Add Task
 * ...
 * Enter your choice: 1
 * Enter task description: Grade assignments
 * Enter priority (HIGH, MEDIUM, LOW): MEDIUM
 * Task added: Grade assignments [MEDIUM, PENDING]
 * 
 * --- Task Manager Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tasks ---
 * Write exam question [HIGH, PENDING]
 * Grade assignments [MEDIUM, PENDING]
 * 
 * --- Task Manager Menu ---
 * ...
 * Enter your choice: 2
 * Processing next task...
 * Task completed: Write exam question [HIGH, COMPLETED]
 * 
 * --- Task Manager Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tasks ---
 * Grade assignments [MEDIUM, PENDING]
 * 
 * --- Task Manager Menu ---
 * ...
 * Enter your choice: 4
 * --- Completed Tasks ---
 * Write exam question [HIGH, COMPLETED]
 * 
 * --- Task Manager Menu ---
 * ...
 * Enter your choice: 7
 * Error: Invalid choice. Please enter a number between 1 and 6.
 * 
 * --- Task Manager Menu ---
 * ...
 * Enter your choice: 2
 * Processing next task...
 * Task completed: Grade assignments [MEDIUM, COMPLETED]
 * 
 * --- Task Manager Menu ---
 * ...
 * Enter your choice: 2
 * Processing next task...
 * System.err: No pending tasks to process.
 * 
 * --- Task Manager Menu ---
 * ...
 * Enter your choice: 6
 * Exiting Task Manager.
 * ```
 * 
 * **Deliverable:**
 * 
 * Provide the complete Java code for the application, including all necessary classes.
 *
 * EXPLANATION:
 * This solution implements a simple command-line Priority Task Manager system demonstrating the required Java concepts and best practices.
 * 
 * **Key Components and Concepts Demonstrated:**
 * 
 * 1.  **`java.util.Queue` (`PriorityQueue`)**: The `pendingTasks` field in `TaskManagementSystem` is declared as a `Queue` and instantiated as a `PriorityQueue`. This structure automatically orders tasks based on their "priority" as defined by the `compareTo` method in the `Task` class. The `processNextTask` method uses `pendingTasks.poll()` to retrieve and remove the highest priority task efficiently.
 * 2.  **`java.util.ArrayList`**: The `completedTasks` field in `TaskManagementSystem` is instantiated as an `ArrayList` to store tasks once they are completed. `ArrayList` is suitable here as completed tasks don't require priority-based ordering for storage or retrieval in this scenario.
 * 3.  **`java.util.List` interface**: The `completedTasks` field is declared using the `List` interface (`List<Task> completedTasks`), demonstrating polymorphism and programming to interfaces.
 * 4.  **`java.util.Scanner`**: A `Scanner` object is used in the `main` method (`PriorityTaskManagerApp`) to read user input from the console for menu choices and task details. A `try-with-resources` block ensures the scanner is closed properly.
 * 5.  **`switch` statement**: The `main` method uses a `switch` statement to handle the different integer choices entered by the user from the main menu, directing the program flow to the corresponding actions.
 * 6.  **`System.err`**: Error messages, such as invalid menu choices, invalid priority input, or attempting to process a task when none are pending, are printed to `System.err`. This visually distinguishes error output from normal program output.
 * 7.  **`System.out`**: Normal program output, including the menu, task details, and success messages, is printed to `System.out`.
 * 8.  **Class-wide exception handling (`try-catch`)**:
 *     *   A main `try-catch` block in `main` wraps the core application loop to catch potential unexpected exceptions during the program's execution.
 *     *   A specific `try-catch` block inside the loop handles `InputMismatchException` from `Scanner` when the user enters non-integer input for the menu choice.
 *     *   A nested `try-catch` block handles `IllegalArgumentException` when the user enters an invalid priority string for a new task.
 * 9.  **Encapsulation**: The `Task` and `TaskManagementSystem` classes have private fields (`description`, `priority`, `status`, `pendingTasks`, `completedTasks`) and public methods (`get...`, `set...`, `addTask`, `processNextTask`, etc.) to control access and manage internal state.
 * 10. **Meaningful Names**: Variable names (`description`, `priorityInput`, `pendingTasks`), method names (`addTask`, `processNextTask`, `viewPendingTasks`), and enum values (`HIGH`, `MEDIUM`, `PENDING`) are descriptive and indicate their purpose.
 * 11. **Comments and Documentation**: Javadoc comments are provided for classes and methods explaining their purpose, parameters, and return values. Inline comments clarify specific logic, such as the `Priority` enum's `compareTo` method or the temporary list for viewing pending tasks.
 * 12. **Input Validation**: The code validates the user's menu choice (checking if it's within the valid range 1-6) and validates the priority input string by attempting to parse it into the `Priority` enum, catching `IllegalArgumentException` on failure.
 * 13. **Error Handling**: Errors are caught using `try-catch`, informative messages are printed to `System.err`, and in the case of `InputMismatchException`, the invalid input is consumed (`scanner.nextLine()`) to prevent infinite loops.
 * 14. **Clean Code Structure**: The code is divided into logical classes (`Task`, `TaskManagementSystem`, `PriorityTaskManagerApp`), each with a specific responsibility. The `main` method orchestrates the application flow, the `TaskManagementSystem` manages the data structures and core logic, and `Task` represents the data entity. Helper methods like `printMenu` improve readability.
 * 
 * The `Task` class implements `Comparable<Task>` to define the ordering used by `PriorityQueue`. The `compareTo` method in `Task` delegates to the `compareTo` method in the `Priority` enum, which is customized to ensure `HIGH` is considered "less than" `MEDIUM` and `LOW` (as `PriorityQueue` is a min-heap, the "smallest" element is at the head).
 * 
 * When viewing pending tasks, a new `ArrayList` is created from the `PriorityQueue`. This is necessary because iterating directly over a `PriorityQueue` does *not* guarantee iteration order. Sorting this temporary list ensures the pending tasks are displayed in the correct priority order without modifying the original `PriorityQueue`.
 * 
 * The `processNextTask` method uses `poll()` which returns `null` if the queue is empty, allowing for graceful handling of the "No pending tasks" scenario.
 * 
 * Overall, the solution effectively integrates the required Java components to build a functional, albeit simple, task management system, adhering to standard practices for robustness and maintainability.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Comparator;

// Enum for Task Priority
enum Priority {
    HIGH, MEDIUM, LOW;

    // Custom order for PriorityQueue (HIGH > MEDIUM > LOW)
    // PriorityQueue is a min-heap by default, so we want HIGH to be the "smallest"
    // This means HIGH should have a lower value in comparison.
    public int compareTo(Priority other) {
        return Integer.compare(other.ordinal(), this.ordinal()); // Reverse natural order
    }
}

// Enum for Task Status
enum Status {
    PENDING, COMPLETED
}

/**
 * Represents a single task with description, priority, and status.
 * Implements Comparable to work with PriorityQueue based on priority.
 */
class Task implements Comparable<Task> {
    private String description;
    private Priority priority;
    private Status status;

    /**
     * Constructs a new Task.
     * @param description The task description.
     * @param priority The priority level of the task.
     */
    public Task(String description, Priority priority) {
        this.description = description;
        this.priority = priority;
        this.status = Status.PENDING; // Tasks start as PENDING
    }

    // --- Getters ---
    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    // --- Setters (for status change) ---
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Compares tasks based on their priority.
     * Used by PriorityQueue. Higher priority tasks come first.
     * @param other The task to compare with.
     * @return A negative integer, zero, or a positive integer as this task
     *         is less than, equal to, or greater than the specified task.
     */
    @Override
    public int compareTo(Task other) {
        // Use the compareTo method defined in the Priority enum
        return this.priority.compareTo(other.priority);
    }

    /**
     * Provides a string representation of the task.
     * @return A formatted string showing task details.
     */
    @Override
    public String toString() {
        return description + " [" + priority + ", " + status + "]";
    }
}

/**
 * Manages a collection of tasks, separating pending (using PriorityQueue)
 * and completed tasks (using ArrayList).
 */
class TaskManagementSystem {
    // Pending tasks stored in a PriorityQueue, ordered by Task's compareTo (priority)
    private Queue<Task> pendingTasks;
    // Completed tasks stored in a List
    private List<Task> completedTasks;

    /**
     * Constructs a new TaskManagementSystem.
     */
    public TaskManagementSystem() {
        this.pendingTasks = new PriorityQueue<>();
        this.completedTasks = new ArrayList<>(); // Using ArrayList implementing List
    }

    /**
     * Adds a new task to the system.
     * @param description The description of the task.
     * @param priority The priority of the task.
     */
    public void addTask(String description, Priority priority) {
        Task newTask = new Task(description, priority);
        pendingTasks.offer(newTask); // offer is preferred over add for queues
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next highest priority pending task.
     * Changes its status to COMPLETED and moves it to the completed tasks list.
     * @return The task that was processed, or null if no pending tasks existed.
     */
    public Task processNextTask() {
        Task nextTask = pendingTasks.poll(); // Retrieves and removes the head of the queue
        if (nextTask != null) {
            nextTask.setStatus(Status.COMPLETED);
            completedTasks.add(nextTask);
            System.out.println("Task completed: " + nextTask);
            return nextTask;
        } else {
            System.err.println("No pending tasks to process.");
            return null;
        }
    }

    /**
     * Displays all tasks currently in the pending state.
     */
    public void viewPendingTasks() {
        System.out.println("--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            // Create a temporary list to display pending tasks sorted by priority
            // without draining the original queue.
            List<Task> sortedPending = new ArrayList<>(pendingTasks);
            // PriorityQueue's iterator does not guarantee order, so we sort the list
            // Use the same comparator logic as the PriorityQueue
            sortedPending.sort(Comparator.naturalOrder()); // Task implements Comparable

            for (Task task : sortedPending) {
                System.out.println(task);
            }
        }
    }

    /**
     * Displays all tasks that have been marked as completed.
     */
    public void viewCompletedTasks() {
        System.out.println("--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Displays all tasks in the system (both pending and completed).
     */
    public void viewAllTasks() {
        System.out.println("--- All Tasks ---");
        viewPendingTasks(); // Reuse existing method for pending
        System.out.println("-------------------"); // Separator
        viewCompletedTasks(); // Reuse existing method for completed
    }
}

/**
 * Main application class for the Priority Task Manager System.
 * Handles user interaction and menu driven control.
 */
public class PriorityTaskManagerApp {

    public static void main(String[] args) {
        // Use try-with-resources for Scanner to ensure it's closed
        try (Scanner scanner = new Scanner(System.in)) {
            TaskManagementSystem taskSystem = new TaskManagementSystem();
            boolean running = true;

            // Main application loop
            while (running) {
                printMenu();

                try {
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    // Switch statement for menu navigation
                    switch (choice) {
                        case 1: // Add Task
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine();
                            System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                            String priorityInput = scanner.nextLine().toUpperCase();
                            try {
                                Priority priority = Priority.valueOf(priorityInput);
                                taskSystem.addTask(description, priority);
                            } catch (IllegalArgumentException e) {
                                System.err.println("Error: Invalid priority level. Please enter HIGH, MEDIUM, or LOW.");
                            }
                            break;

                        case 2: // Process Next Task
                            System.out.println("Processing next task...");
                            taskSystem.processNextTask();
                            break;

                        case 3: // View Pending Tasks
                            taskSystem.viewPendingTasks();
                            break;

                        case 4: // View Completed Tasks
                            taskSystem.viewCompletedTasks();
                            break;

                        case 5: // View All Tasks
                            taskSystem.viewAllTasks();
                            break;

                        case 6: // Exit
                            running = false;
                            System.out.println("Exiting Task Manager.");
                            break;

                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 6.");
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input for menu choice
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                } catch (Exception e) {
                    // Catch any other unexpected exceptions during command processing
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    e.printStackTrace(); // Print stack trace for debugging
                }
                System.out.println(); // Add a blank line for readability
            }
        } catch (Exception e) {
            // Catch exceptions related to Scanner initialization or closing
            System.err.println("An error occurred while setting up the application: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Task Manager Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. View All Tasks");
        System.out.println("6. Exit");
    }
}
