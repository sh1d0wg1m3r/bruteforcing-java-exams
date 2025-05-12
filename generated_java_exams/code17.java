/*
 * Exam Question #17
 * Generated on: 2025-05-11 21:36:56
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified command-line Task Management System. This system should allow users to add new tasks, view tasks currently requiring attention, view a history of all tasks ever created, and mark tasks as completed.
 * 
 * The system should prioritize tasks in a "First-In, First-Out" manner for processing, but also maintain a complete record of all tasks.
 * 
 * **Requirements:**
 * 
 * Implement a Java program consisting of at least two classes: `Task` and `TaskManager`.
 * 
 * 1.  **`Task` Class:**
 *     *   Represent a single task.
 *     *   Must have private fields for a unique integer `taskId`, a `String description`, and a boolean `isCompleted`.
 *     *   Provide a constructor to initialize `taskId` and `description`. `isCompleted` should default to `false`.
 *     *   Include public getter methods for all fields.
 *     *   Include a public method `markComplete()` that sets `isCompleted` to `true`.
 *     *   Override the `toString()` method to provide a user-friendly representation of the task (including its ID, description, and status).
 *     *   Implement basic input validation in the constructor (e.g., description not null or empty).
 * 
 * 2.  **`TaskManager` Class:**
 *     *   Manage the collection of tasks.
 *     *   Must use a `java.util.Queue` to store tasks that are currently pending (need to be worked on). When a task is added, it goes into this queue. When a task is completed, it is removed from this queue. Use `java.util.LinkedList` as the implementation for the `Queue` to facilitate removing elements by ID.
 *     *   Must use a `java.util.List` (implemented by `java.util.ArrayList`) to store a history of *all* tasks ever created, including completed ones. When a task is added, it is added to this list. When a task is completed, its status in this list should be updated.
 *     *   Maintain a counter to generate unique task IDs starting from 1.
 *     *   Implement the following public methods:
 *         *   `addTask(String description)`: Creates a new `Task`, adds it to both the history list and the pending queue, and assigns it the next unique ID.
 *         *   `viewPendingTasks()`: Displays tasks currently in the pending queue in their FIFO order without removing them. Indicate if the queue is empty.
 *         *   `viewAllTasks()`: Displays all tasks in the history list, regardless of status. Indicate if the history is empty.
 *         *   `completeTask(int taskId)`: Finds the task with the given `taskId` in the *pending* queue, removes it from the pending queue, and updates its `isCompleted` status to `true` in the history list. If the task ID is not found in the pending queue, or if it was already completed (checked via history), print an appropriate error message.
 *     *   Implement a `run()` method that contains the main application loop:
 *         *   Display a menu with options: Add Task, View Pending, View All, Complete Task, Exit.
 *         *   Use `java.util.Scanner` to read user input for commands and task details.
 *         *   Use a `switch` statement to handle the different menu options.
 *         *   Call the appropriate `TaskManager` methods based on user input.
 *         *   The main loop (within the `run` method) must have **class-wide exception handling** using `try-catch` blocks to gracefully handle unexpected errors during the program's execution. Specifically handle `InputMismatchException` for reading numbers and a general `Exception` for other potential issues, printing error messages to `System.err`. Normal output should go to `System.out`.
 *         *   Ensure the `Scanner` is closed when the program exits.
 * 
 * **Best Practices:**
 * 
 * *   Use appropriate access modifiers (`private`, `public`).
 * *   Use meaningful variable and method names.
 * *   Include comments and basic documentation (Javadocs are a plus).
 * *   Perform input validation where necessary (e.g., task description, task ID for completion).
 * *   Provide clear messages to the user for successful operations and errors.
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept numeric input for commands, and print task details or status messages based on the user's actions. Error messages should be clearly distinguishable (e.g., printed to `System.err`).
 * 
 * Example interaction:
 * ```
 * --- Task Manager ---
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 1
 * Enter task description: Write exam question
 * Task added successfully: Task ID: 1, Description: "Write exam question", Status: Pending
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 1
 * Enter task description: Grade submissions
 * Task added successfully: Task ID: 2, Description: "Grade submissions", Status: Pending
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 2
 * --- Pending Tasks ---
 * Task ID: 1, Description: "Write exam question", Status: Pending
 * Task ID: 2, Description: "Grade submissions", Status: Pending
 * ---------------------
 * 2 pending task(s) listed.
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 4
 * Enter Task ID to complete: 1
 * Task ID 1 found and removed from pending queue.
 * Task ID 1 marked as completed in history.
 * Task ID 1 successfully completed.
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 2
 * --- Pending Tasks ---
 * Task ID: 2, Description: "Grade submissions", Status: Pending
 * ---------------------
 * 1 pending task(s) listed.
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 3
 * --- All Tasks (History) ---
 * Task ID: 1, Description: "Write exam question", Status: Completed
 * Task ID: 2, Description: "Grade submissions", Status: Pending
 * -------------------------
 * 2 total task(s) listed.
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 4
 * Enter Task ID to complete: 5
 * Error: Task ID 5 not found in the pending tasks queue.
 * Error: Task ID 5 does not exist in the system.
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 4
 * Enter Task ID to complete: 1
 * Error: Task ID 1 not found in the pending tasks queue.
 * Error: Task ID 1 is already marked as completed.
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: abc
 * Invalid input. Please enter a number.
 * An unexpected error occurred: null (or similar message from scanner consuming invalid input)
 * 
 * Please choose an option:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View All Tasks
 * 4. Complete Task
 * 0. Exit
 * Enter command: 0
 * Exiting Task Manager. Goodbye!
 * ```
 * 
 * Your solution should be a single Java file containing all necessary classes.
 *
 * EXPLANATION:
 * This solution implements a basic Task Management System demonstrating the required Java concepts.
 * 
 * 1.  **`Task` Class:** This is a simple Plain Old Java Object (POJO) representing a task. It encapsulates the task's data (`taskId`, `description`, `isCompleted`) using `private` fields and provides `public` methods (`getTaskId`, `getDescription`, `isCompleted`, `markComplete`) to interact with its state, adhering to encapsulation principles. The constructor includes basic validation for the description. The `toString()` method is overridden for easy printing. `equals` and `hashCode` are included for robust collection handling, although direct ID lookup is primarily used here.
 * 
 * 2.  **`TaskManager` Class:** This class manages the collections of `Task` objects and the user interaction loop.
 *     *   **Collections:**
 *         *   `pendingTasks`: Declared as `Queue<Task>` and implemented using `LinkedList<Task>`. `Queue` enforces the FIFO behavior (tasks are added with `offer` and would typically be processed with `poll` or `peek`, although `poll` isn't used in this specific command structure). `LinkedList` is chosen because it implements `Queue` and also allows iteration and removal of elements by criteria (like ID) using an `Iterator`, which is necessary for the `completeTask` functionality as tasks aren't always completed in strict FIFO order in this command-driven model.
 *         *   `taskHistory`: Declared as `List<Task>` and implemented using `ArrayList<Task>`. This list stores every task ever created, acting as a complete record. `ArrayList` is suitable for general storage and iteration.
 *     *   **`addTask`:** Creates a new `Task` with a unique ID, adds it to both `taskHistory` (using `add`) and `pendingTasks` (using `offer`), and increments the ID counter. Includes `try-catch` for `IllegalArgumentException` from the `Task` constructor and a general `Exception`.
 *     *   **`viewPendingTasks`:** Iterates through the `pendingTasks` queue using a simple `for-each` loop. This iterates without removing elements, fulfilling the requirement to view the queue's contents.
 *     *   **`viewAllTasks`:** Iterates through the `taskHistory` list using a `for-each` loop to display all tasks.
 *     *   **`completeTask`:** This method demonstrates interaction between the two collections. It iterates through the `pendingTasks` queue using an `Iterator` to safely find and remove the task by its `taskId`. If found, it then iterates through the `taskHistory` list to find the *same* task (by ID) and calls `markComplete()` on it. Error handling checks if the task was found in pending, if the ID exists at all, and if the task was already completed, printing messages to `System.err`.
 *     *   **`run` Method:** This method contains the main loop for the command-line interface.
 *         *   It uses a `Scanner` to read user input.
 *         *   A `while(running)` loop keeps the program active until the user chooses to exit.
 *         *   A `switch` statement is used to dispatch actions based on the numeric command entered by the user, calling the appropriate `TaskManager` methods.
 *         *   **Exception Handling:**
 *             *   An inner `try-catch (InputMismatchException e)` specifically handles cases where the user enters non-numeric input when a number is expected (for the command or task ID). It prints an error to `System.err` and consumes the invalid input from the scanner to prevent an infinite loop.
 *             *   An inner `try-catch (Exception e)` around the core `switch` block acts as a general catch-all for any other unexpected runtime exceptions that might occur during command processing. It prints the error message to `System.err`.
 *             *   An outer `try-catch (Exception mainLoopException)` around the entire `while` loop fulfills the "class-wide" requirement, catching any exceptions that might occur outside the specific command handling, such as issues with the `Scanner` itself or loop control, printing to `System.err`.
 *         *   A `finally` block ensures the `Scanner` resource is closed when the `run` method exits (either normally or due to an exception).
 *     *   **`main` Method:** The entry point of the program, which simply creates a `TaskManager` instance and calls its `run()` method.
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, while adhering to best practices like encapsulation, clear naming, and robust error handling. The `completeTask` method, in particular, requires careful handling of finding and removing elements from a `Queue` and updating elements in a `List`, which is a good test of collection manipulation skills.
 */

import java.util.Queue;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.ArrayList; // ArrayList implements List
import java.util.Scanner;
import java.util.InputMismatchException; // For handling non-integer input
import java.util.Iterator; // For safe removal while iterating queue

/**
 * Represents a single task with a unique ID, description, and completion status.
 */
class Task {
    private int taskId;
    private String description;
    private boolean isCompleted;

    /**
     * Constructs a new Task.
     * @param taskId The unique ID for the task.
     * @param description A brief description of the task.
     * @throws IllegalArgumentException if taskId is negative or description is null/empty.
     */
    public Task(int taskId, String description) {
        if (taskId < 0) {
            throw new IllegalArgumentException("Task ID cannot be negative.");
        }
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        this.taskId = taskId;
        this.description = description.trim();
        this.isCompleted = false; // Tasks start as not completed
    }

    // --- Getters ---
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // --- Methods ---
    /**
     * Marks the task as completed.
     */
    public void markComplete() {
        this.isCompleted = true;
    }

    /**
     * Provides a string representation of the task.
     * @return A formatted string showing task ID, description, and status.
     */
    @Override
    public String toString() {
        return String.format("Task ID: %d, Description: \"%s\", Status: %s",
                             taskId, description, isCompleted ? "Completed" : "Pending");
    }

    // Optional: equals and hashCode based on taskId for robustness in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(taskId);
    }
}

/**
 * Manages a collection of tasks, allowing adding, viewing, and completing tasks.
 * Uses a Queue for pending tasks (FIFO) and a List for all tasks (history).
 * Includes a command-line interface with menu and exception handling.
 */
class TaskManager {
    // Queue to store tasks currently in the queue for processing (FIFO)
    private Queue<Task> pendingTasks;
    // List to store all tasks ever created (history)
    private List<Task> taskHistory;
    // Counter for assigning unique task IDs
    private int nextTaskId;

    /**
     * Constructs a new TaskManager, initializing task collections and ID counter.
     */
    public TaskManager() {
        // Use LinkedList as it implements Queue and allows iteration/removal by ID
        this.pendingTasks = new LinkedList<>();
        // Use ArrayList as it implements List for general storage/history
        this.taskHistory = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the system.
     * The task is added to both the history list and the pending queue.
     * @param description The description of the new task.
     */
    public void addTask(String description) {
        try {
            Task newTask = new Task(nextTaskId, description);
            taskHistory.add(newTask);     // Add to history list
            pendingTasks.offer(newTask);  // Add to pending queue (offer is safer than add)
            System.out.println("Task added successfully: " + newTask.toString());
            nextTaskId++; // Increment ID counter
        } catch (IllegalArgumentException e) {
            // Handle validation errors from Task constructor
            System.err.println("Error adding task: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions during task creation/addition
            System.err.println("An unexpected error occurred while adding task: " + e.getMessage());
            // e.printStackTrace(System.err); // Uncomment for debugging
        }
    }

    /**
     * Displays all tasks currently in the pending queue (FIFO order).
     * Does not remove tasks from the queue.
     */
    public void viewPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }

        // Iterate through the queue without removing elements
        int count = 0;
        for (Task task : pendingTasks) {
            System.out.println(task.toString());
            count++;
        }
        System.out.println("---------------------");
        System.out.println(count + " pending task(s) listed.");
    }

    /**
     * Displays all tasks ever created, including completed ones.
     */
    public void viewAllTasks() {
        System.out.println("\n--- All Tasks (History) ---");
        if (taskHistory.isEmpty()) {
            System.out.println("No tasks created yet.");
            return;
        }

        // Iterate through the history list
        for (Task task : taskHistory) {
            System.out.println(task.toString());
        }
        System.out.println("-------------------------");
        System.out.println(taskHistory.size() + " total task(s) listed.");
    }

    /**
     * Marks a task as completed by its ID.
     * The task is removed from the pending queue and marked as completed in the history list.
     * @param taskId The ID of the task to complete.
     */
    public void completeTask(int taskId) {
        boolean foundAndRemovedFromPending = false;

        // 1. Find and remove the task from the pending queue using an Iterator for safe removal
        Iterator<Task> pendingIterator = pendingTasks.iterator();
        while (pendingIterator.hasNext()) {
            Task task = pendingIterator.next();
            if (task.getTaskId() == taskId) {
                pendingIterator.remove(); // Safely remove from queue
                foundAndRemovedFromPending = true;
                System.out.println("Task ID " + taskId + " found and removed from pending queue.");
                break; // Found the task, exit loop
            }
        }

        if (!foundAndRemovedFromPending) {
            // Task was not in the pending queue. Check history to give a more specific error.
            boolean existsInHistory = false;
            for(Task task : taskHistory) {
                if (task.getTaskId() == taskId) {
                    existsInHistory = true;
                    if(task.isCompleted()) {
                         System.err.println("Error: Task ID " + taskId + " is already marked as completed.");
                    } else {
                         // This case implies a logic error or unexpected state: task is in history,
                         // not completed, but also not in the pending queue.
                         System.err.println("Internal Warning: Task ID " + taskId + " exists in history but not pending queue and is not completed. Cannot complete.");
                    }
                    break; // Found in history, no need to check further
                }
            }
            if (!existsInHistory) {
                 // Task ID was not found in history at all.
                 System.err.println("Error: Task ID " + taskId + " does not exist in the system.");
            }
            return; // Exit the method if not found in pending
        }

        // 2. Find the corresponding task in the history list and mark it as completed
        boolean updatedInHistory = false;
        for (Task task : taskHistory) {
            if (task.getTaskId() == taskId) {
                task.markComplete(); // Mark as completed
                updatedInHistory = true;
                System.out.println("Task ID " + taskId + " marked as completed in history.");
                break; // Found and updated in history
            }
        }

        // This check is a safeguard. If a task was removed from pending, it MUST be in history.
        if (!updatedInHistory) {
             System.err.println("Internal Warning: Task ID " + taskId + " was removed from pending but not found in history to update status.");
        }

        System.out.println("Task ID " + taskId + " successfully completed.");
    }

    /**
     * Prints the available menu options to the console.
     */
    private void printMenu() {
        System.out.println("\nPlease choose an option:");
        System.out.println("1. Add Task");
        System.out.println("2. View Pending Tasks");
        System.out.println("3. View All Tasks");
        System.out.println("4. Complete Task");
        System.out.println("0. Exit");
    }

    /**
     * Runs the main interactive loop for the Task Manager.
     * Handles user input and dispatches commands using a switch statement.
     * Includes class-wide exception handling.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Task Manager ---");

        // Class-wide exception handling around the main application loop
        try {
            while (running) {
                printMenu();

                // Inner try-catch for handling exceptions within the command processing loop
                try {
                    System.out.print("Enter command: ");
                    int command = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    // Use switch statement for command handling
                    switch (command) {
                        case 1: // Add Task
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine();
                            addTask(description);
                            break;
                        case 2: // View Pending Tasks
                            viewPendingTasks();
                            break;
                        case 3: // View All Tasks
                            viewAllTasks();
                            break;
                        case 4: // Complete Task
                            System.out.print("Enter Task ID to complete: ");
                            int taskIdToComplete = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            completeTask(taskIdToComplete);
                            break;
                        case 0: // Exit
                            System.out.println("Exiting Task Manager. Goodbye!");
                            running = false;
                            break;
                        default:
                            // Handle invalid numeric commands
                            System.out.println("Invalid command. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    // Handle cases where user enters non-integer input for command or task ID
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
                } catch (Exception e) {
                    // Catch any other unexpected exceptions during command processing
                    // This acts as a safety net for errors not specifically caught
                    System.err.println("An unexpected error occurred during command processing: " + e.getMessage());
                    // e.printStackTrace(System.err); // Uncomment for debugging
                }
            }
        } catch (Exception mainLoopException) {
             // This outer catch block handles critical exceptions that might occur outside
             // the normal command processing flow, e.g., issues with scanner initialization
             // or other fundamental problems.
             System.err.println("A critical error occurred in the main TaskManager loop: " + mainLoopException.getMessage());
             // mainLoopException.printStackTrace(System.err); // Uncomment for debugging
        } finally {
            // Ensure the scanner resource is closed properly
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Scanner closed."); // Optional: confirm cleanup
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run();
    }
}
