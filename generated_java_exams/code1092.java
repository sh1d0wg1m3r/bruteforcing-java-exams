/*
 * Exam Question #1092
 * Generated on: 2025-05-12 17:23:42
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple, command-line-based Task Management System. This system should allow users to add tasks with different priority levels and process them based on priority. High-priority tasks should always be processed before medium or low-priority tasks. The system must also keep a record of completed tasks.
 * 
 * **System Requirements:**
 * 
 * 1.  **Task Representation:** Create a class `Task` to represent a task. Each task should have:
 *     *   A unique integer `taskId` (assigned automatically by the system, starting from 1).
 *     *   A `String description`.
 *     *   A `TaskPriority` enum indicating its priority (`HIGH`, `MEDIUM`, `LOW`).
 * 2.  **Priority Levels:** Define an enum `TaskPriority` with the values `HIGH`, `MEDIUM`, `LOW`.
 * 3.  **Task Queues:** The system must maintain two queues:
 *     *   A queue for `HIGH` priority tasks.
 *     *   A queue for `MEDIUM` and `LOW` priority tasks.
 *     Use the `java.util.Queue` interface, implemented using `java.util.LinkedList` or similar appropriate class.
 * 4.  **Completed Tasks:** Maintain a list of completed tasks. Use the `java.util.List` interface, implemented using `java.util.ArrayList`.
 * 5.  **User Interaction:** The system should present a menu-driven interface using `java.util.Scanner` for user input. The menu options should include:
 *     *   Add New Task
 *     *   Process Next Task
 *     *   View Pending Tasks (show tasks in both queues)
 *     *   View Completed Tasks
 *     *   Exit
 * 6.  **Processing Logic:** When "Process Next Task" is selected:
 *     *   Always check the `HIGH` priority queue first. If it's not empty, remove and process a task from there.
 *     *   If the `HIGH` priority queue is empty, check the other queue. If it's not empty, remove and process a task from there.
 *     *   "Processing" a task simply means removing it from the queue and adding it to the list of completed tasks.
 *     *   If both queues are empty, inform the user.
 * 7.  **Input Validation:**
 *     *   Validate user menu choices.
 *     *   Validate task priority input (e.g., accept "HIGH", "MEDIUM", "LOW" case-insensitively).
 *     *   Validate task description (should not be empty).
 * 8.  **Error Handling:**
 *     *   Use `try-catch` blocks to handle potential exceptions, such as invalid number format for menu input or attempting to process from empty queues (though the processing logic should ideally prevent explicit exceptions for empty queues by checking first). Implement class-wide exception handling for the main interaction loop.
 *     *   Use `System.err.println()` for displaying error messages (e.g., invalid input, processing error).
 *     *   Use `System.out.println()` for displaying menu, successful operations, and task information.
 * 9.  **Flow Control:** Use a `switch` statement to handle the main menu options.
 * 10. **Best Practices:** Adhere to Java best practices:
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (Javadoc is a plus).
 *     *   Clean code structure.
 * 
 * **Expected Output:**
 * 
 * The system should display a menu, prompt for input, and provide feedback based on the selected operation. Examples:
 * 
 * *   Adding a task: "Task [ID] added with priority [Priority]."
 * *   Processing a task: "Processed Task [ID]: [Description] (Priority: [Priority])."
 * *   Processing with empty queues: "No tasks pending."
 * *   Viewing queues: List tasks in high priority queue, then in the other queue.
 * *   Viewing completed: List tasks in the completed list.
 * *   Invalid input: Display an error message using `System.err`.
 * 
 * **Deliverables:**
 * 
 * Provide the complete Java code for the Task Management System, including the `TaskPriority` enum, `Task` class, and the main class containing the system logic and user interaction loop.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation and usage of all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `Switch`, `System.err`, `System.out`, `try-catch`).
 * *   Correct implementation of the task management logic (priority-based processing, completed list).
 * *   Effective use of best practices (encapsulation, naming, comments, validation).
 * *   Robust error handling.
 * *   Clean and well-structured code.
 *
 * EXPLANATION:
 * This solution implements the Task Management System as requested, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **`TaskPriority` Enum:** Defines the possible priority levels for tasks (`HIGH`, `MEDIUM`, `LOW`). Includes a static helper method `fromString` for robust, case-insensitive conversion from user string input.
 * 2.  **`Task` Class:** Encapsulates the data for a single task (`taskId`, `description`, `priority`). Includes a constructor with basic validation for description and priority, getters for accessing the private fields, and an overridden `toString()` method for easy printing. The `taskId` is generated sequentially by the `TaskManagementSystem`.
 * 3.  **`TaskManagementSystem` Class:** This is the core class managing the system state and logic.
 *     *   **Fields:**
 *         *   `highPriorityQueue`: A `Queue<Task>` (implemented using `LinkedList`) for high-priority tasks.
 *         *   `otherPriorityQueue`: A `Queue<Task>` (implemented using `LinkedList`) for medium and low-priority tasks.
 *         *   `completedTasks`: A `List<Task>` (implemented using `ArrayList`) to store tasks after they are processed.
 *         *   `nextTaskId`: An integer to keep track of the next available task ID.
 *         *   `scanner`: A `Scanner` object for reading user input.
 *     *   **Constructor:** Initializes the queues, the completed tasks list, the task ID counter, and the `Scanner`.
 *     *   **`addTask()`:** Prompts the user for task description and priority. Performs input validation for both. Uses the `TaskPriority.fromString()` helper. If input is valid, creates a `Task` object (which might throw an `IllegalArgumentException` if validation in the `Task` constructor fails) and adds it to the appropriate queue (`highPriorityQueue` or `otherPriorityQueue`) using `offer()`. `offer()` is generally preferred over `add()` in queues as it handles capacity-constrained queues more gracefully (though `LinkedList` is not capacity-constrained).
 *     *   **`processNextTask()`:** Implements the core processing logic. It first checks if `highPriorityQueue` is empty. If not, it removes a task using `poll()` (which removes and returns the head, or `null` if empty). If the high-priority queue is empty, it checks `otherPriorityQueue` and polls from there. The processed task (if any) is then added to the `completedTasks` list. Informative messages are printed to `System.out`.
 *     *   **`viewPendingTasks()`:** Iterates through both queues to display their contents without removing elements. It checks if queues are empty and prints appropriate messages. Iteration over `Queue` uses its `Iterator`.
 *     *   **`viewCompletedTasks()`:** Iterates through the `completedTasks` `ArrayList` and prints each completed task.
 *     *   **`displayMenu()`:** A private helper method to print the interactive menu to `System.out`.
 *     *   **`main()`:** The entry point of the application.
 *         *   Creates an instance of `TaskManagementSystem`.
 *         *   Contains a `boolean running` flag to control the main loop.
 *         *   **Class-wide `try-catch`:** The entire `while` loop is wrapped in a `try-catch(Exception e)` block. This provides a top-level safety net for any unexpected runtime errors that might occur within the main execution flow, preventing the program from crashing abruptly. It prints the error message and stack trace to `System.err`.
 *         *   **Inner `try-catch` for Input:** Inside the loop, a nested `try-catch(NumberFormatException)` is used specifically for parsing the user's menu choice. This handles non-numeric input gracefully, prints an error to `System.err`, and uses `continue` to restart the loop, prompting the user again.
 *         *   **`switch` Statement:** Handles the user's valid menu choice, calling the corresponding method in the `TaskManagementSystem` instance.
 *         *   **`finally` Block:** Ensures that the `scanner.close()` method is called when the `try` block is exited, either normally or due to an exception. This is important for resource management.
 * 
 * **Best Practices Demonstrated:**
 * 
 * *   **Encapsulation:** Fields in `Task` and `TaskManagementSystem` are `private`, accessed via public methods where necessary.
 * *   **Meaningful Names:** Variables, methods, and classes have descriptive names (e.g., `highPriorityQueue`, `processNextTask`, `viewCompletedTasks`).
 * *   **Comments/Documentation:** Javadoc-style comments explain the purpose of classes and methods. Inline comments clarify specific logic points.
 * *   **Input Validation:** Checks for empty description, valid priority string, and numeric menu input are performed.
 * *   **Error Handling:** Specific `try-catch` for `NumberFormatException`, a general `try-catch` for the main loop, and checks for empty queues before polling prevent common errors. `System.err` is used for error output.
 * *   **Clean Code Structure:** The code is divided into logical classes (`TaskPriority`, `Task`, `TaskManagementSystem`) and methods, improving readability and maintainability.
 * 
 * This solution effectively combines various Java constructs to build a functional and robust system, addressing the complexity required for the exam task.
 */

import java.util.*;

// Enum for task priority levels
enum TaskPriority {
    HIGH, MEDIUM, LOW;

    // Helper method to get priority from string, case-insensitive
    public static TaskPriority fromString(String priorityStr) {
        if (priorityStr == null) {
            return null;
        }
        try {
            return TaskPriority.valueOf(priorityStr.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // Return null for invalid strings
        }
    }
}

// Class to represent a task
class Task {
    private int taskId;
    private String description;
    private TaskPriority priority;

    public Task(int taskId, String description, TaskPriority priority) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        if (priority == null) {
            throw new IllegalArgumentException("Task priority cannot be null.");
        }
        this.taskId = taskId;
        this.description = description.trim();
        this.priority = priority;
    }

    // Getters
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return String.format("Task %d: \"%s\" (Priority: %s)", taskId, description, priority);
    }
}

// Main system class
public class TaskManagementSystem {
    private Queue<Task> highPriorityQueue;
    private Queue<Task> otherPriorityQueue; // For MEDIUM and LOW
    private List<Task> completedTasks;
    private int nextTaskId;
    private Scanner scanner;

    public TaskManagementSystem() {
        this.highPriorityQueue = new LinkedList<>();
        this.otherPriorityQueue = new LinkedList<>();
        this.completedTasks = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
        this.scanner = new Scanner(System.in);
    }

    // Method to add a new task
    public void addTask() {
        System.out.println("\n--- Add New Task ---");
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        if (description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }

        System.out.print("Enter task priority (HIGH, MEDIUM, LOW): ");
        String priorityStr = scanner.nextLine();
        TaskPriority priority = TaskPriority.fromString(priorityStr);

        if (priority == null) {
            System.err.println("Error: Invalid priority entered. Please use HIGH, MEDIUM, or LOW.");
            return;
        }

        try {
            Task newTask = new Task(nextTaskId++, description, priority);
            if (priority == TaskPriority.HIGH) {
                highPriorityQueue.offer(newTask); // offer is preferred over add in queues
            } else {
                otherPriorityQueue.offer(newTask);
            }
            System.out.println("Task " + newTask.getTaskId() + " added with priority " + priority + ".");
        } catch (IllegalArgumentException e) {
             // This catch block primarily handles issues during Task object creation
             System.err.println("Error creating task: " + e.getMessage());
        }
    }

    // Method to process the next task based on priority
    public void processNextTask() {
        System.out.println("\n--- Processing Task ---");
        Task taskToProcess = null;

        if (!highPriorityQueue.isEmpty()) {
            taskToProcess = highPriorityQueue.poll(); // poll returns null if empty
        } else if (!otherPriorityQueue.isEmpty()) {
            taskToProcess = otherPriorityQueue.poll();
        }

        if (taskToProcess != null) {
            completedTasks.add(taskToProcess);
            System.out.println("Processed: " + taskToProcess);
        } else {
            System.out.println("No tasks pending.");
        }
    }

    // Method to view tasks currently in queues
    public void viewPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        if (highPriorityQueue.isEmpty() && otherPriorityQueue.isEmpty()) {
            System.out.println("No tasks in queues.");
            return;
        }

        System.out.println("High Priority Queue:");
        if (highPriorityQueue.isEmpty()) {
            System.out.println("  (Empty)");
        } else {
            // Iterating without removing using peek and iteration
            int index = 1;
            for (Task task : highPriorityQueue) {
                 System.out.println("  " + index++ + ". " + task);
            }
        }

        System.out.println("\nOther Priority Queue (Medium/Low):");
        if (otherPriorityQueue.isEmpty()) {
            System.out.println("  (Empty)");
        } else {
            int index = 1;
            for (Task task : otherPriorityQueue) {
                System.out.println("  " + index++ + ". " + task);
            }
        }
    }

    // Method to view completed tasks
    public void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks completed yet.");
            return;
        }

        for (int i = 0; i < completedTasks.size(); i++) {
            System.out.println((i + 1) + ". " + completedTasks.get(i));
        }
    }

    // Method to display the main menu
    private void displayMenu() {
        System.out.println("\n--- Task Management System Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Main method to run the system
    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();
        boolean running = true;

        // Class-wide exception handling for the main interaction loop
        try {
            while (running) {
                system.displayMenu();
                int choice = -1;
                try {
                    choice = Integer.parseInt(system.scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    continue; // Skip to next loop iteration
                }

                switch (choice) {
                    case 1:
                        system.addTask();
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
                        System.out.println("Exiting Task Management System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main loop execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace for debugging
        } finally {
            // Ensure the scanner is closed regardless of how the loop ends
            system.scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}
