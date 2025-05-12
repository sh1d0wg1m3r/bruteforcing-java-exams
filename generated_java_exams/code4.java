/*
 * Exam Question #4
 * Generated on: 2025-05-11 21:21:56
 * 
 * QUESTION:
 * **Subject:** Advanced Java Programming
 * **Topic:** Data Structures, Collections, Exception Handling, and I/O
 * **Duration:** 60 minutes
 * 
 * **Task:** Develop a Java program that simulates a basic "Task Processing System". This system manages tasks that are added to a queue for processing and moved to a list upon completion.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` with the following attributes:
 *     *   `taskId` (an integer, automatically generated and unique)
 *     *   `description` (a String)
 *     *   `creationTime` (a `long` representing the system time when the task was created)
 *     *   Implement a constructor, getter methods for all attributes, and override the `toString()` method to provide a user-friendly representation of a task.
 * 
 * 2.  **Task Management System:** Create a class named `TaskProcessor` that manages the tasks. It must contain:
 *     *   A `Queue<Task>` to hold tasks waiting to be processed (pending tasks).
 *     *   A `List<Task>` (using `ArrayList`) to hold tasks that have been processed (completed tasks).
 *     *   A private static counter to generate unique task IDs.
 *     *   A method `addTask(String description)`: Creates a new `Task` object and adds it to the pending task queue.
 *     *   A method `processNextTask()`: Removes the next task from the pending queue, adds it to the completed tasks list, and returns the processed task. If the queue is empty, it should indicate an error condition (e.g., return `null` or throw a custom exception - for this problem, returning `null` and handling it in the main loop is sufficient).
 *     *   A method `getPendingTasks()`: Returns a view or copy of the pending task queue (it's acceptable to return the queue reference for this exam).
 *     *   A method `getCompletedTasks()`: Returns a view or copy of the completed tasks list (it's acceptable to return the list reference for this exam).
 * 
 * 3.  **User Interface:** Create a `Main` class with a `main` method to interact with the `TaskProcessor`.
 *     *   Use a `Scanner` to read user commands from the console.
 *     *   Present a menu of options to the user:
 *         *   Add Task
 *         *   Process Next Task
 *         *   View Pending Tasks
 *         *   View Completed Tasks
 *         *   Exit
 *     *   Use a `switch` statement to handle the user's choice.
 *     *   Implement input validation for user choices and task descriptions (e.g., ensure description is not empty).
 *     *   Use `System.out` for displaying the menu, prompts, task details, and successful operations.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, queue is empty when processing).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential issues (e.g., unexpected input format, general runtime errors). The main command loop should be robust.
 * 
 * 4.  **Constraints and Best Practices:**
 *     *   Adhere to Java coding conventions.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments (especially Javadoc for classes and methods).
 *     *   Ensure proper encapsulation (private fields, public methods).
 *     *   The program should run until the user chooses to exit.
 * 
 * **Example Interaction:**
 * 
 * ```
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Implement login feature
 * Task added: Task ID: 1, Description: Implement login feature, Created: <timestamp>
 * 
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Write unit tests
 * Task added: Task ID: 2, Description: Write unit tests, Created: <timestamp>
 * 
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 3
 * Pending Tasks (Queue):
 * Task ID: 1, Description: Implement login feature, Created: <timestamp>
 * Task ID: 2, Description: Write unit tests, Created: <timestamp>
 * 
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 2
 * Processing next task...
 * Task processed: Task ID: 1, Description: Implement login feature, Created: <timestamp>
 * 
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 3
 * Pending Tasks (Queue):
 * Task ID: 2, Description: Write unit tests, Created: <timestamp>
 * 
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 4
 * Completed Tasks (List):
 * Task ID: 1, Description: Implement login feature, Created: <timestamp>
 * 
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 2
 * Processing next task...
 * Task processed: Task ID: 2, Description: Write unit tests, Created: <timestamp>
 * 
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 2
 * Processing next task...
 * System.err: Error: No tasks in the queue to process.
 * 
 * --- Task Processing System ---
 * 1. Add Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 5
 * Exiting Task Processing System.
 * ```
 * 
 * Your solution should consist of the `Task`, `TaskProcessor`, and `Main` classes.
 *
 * EXPLANATION:
 * This solution implements a basic Task Processing System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents the data structure for a single task.
 *     *   Fields (`taskId`, `description`, `creationTime`) are `private` to enforce encapsulation.
 *     *   The constructor initializes these fields.
 *     *   Public getter methods provide controlled access to the data.
 *     *   `toString()` is overridden for easy printing of task details.
 * 
 * 2.  **`TaskProcessor` Class:**
 *     *   Manages the collections of tasks.
 *     *   Uses a `Queue<Task>` (`LinkedList` implementation) for `pendingTasks`. The `Queue` interface guarantees FIFO order, suitable for processing tasks in the order they were added. `offer()` is used for adding, which is safer than `add()` in capacity-constrained queues (though `LinkedList` doesn't have this issue, `offer` is idiomatic). `poll()` is used for retrieving and removing, returning `null` if the queue is empty, which simplifies error checking.
 *     *   Uses a `List<Task>` (`ArrayList` implementation) for `completedTasks`. The `List` interface allows storing processed tasks in order of completion and provides easy iteration. `ArrayList` is a common and efficient list implementation.
 *     *   `taskIdCounter` is a `static` variable to ensure unique IDs across all tasks created by this processor instance.
 *     *   `addTask()` creates a new `Task` and adds it to the `pendingTasks` queue using `offer()`.
 *     *   `processNextTask()` removes the head of the `pendingTasks` queue using `poll()`. If `poll()` returns `null` (meaning the queue was empty), it prints an error to `System.err`. Otherwise, it adds the task to the `completedTasks` list.
 *     *   `getPendingTasks()` and `getCompletedTasks()` provide access to the underlying collections.
 * 
 * 3.  **`Main` Class:**
 *     *   Contains the `main` method, the program's entry point.
 *     *   An instance of `TaskProcessor` is created to manage tasks.
 *     *   A `Scanner` is used to read user input from the console.
 *     *   A `boolean` flag (`running`) controls the main program loop.
 *     *   The main operational logic is wrapped in a `try-catch(Exception e)` block. This provides a general safety net for unexpected runtime errors anywhere within the loop, fulfilling the requirement for class-wide exception handling.
 *     *   Inside the loop, `displayMenu()` shows options.
 *     *   An inner `try-catch(InputMismatchException e)` block specifically handles cases where the user enters non-integer input for the menu choice, preventing a crash and infinite loop by consuming the invalid input.
 *     *   A `switch` statement directs program flow based on the valid user choice, calling appropriate methods on the `TaskProcessor`.
 *     *   **Input Validation:**
 *         *   For choice '1' (Add Task), it checks if the entered description is empty using `trim().isEmpty()` before adding the task. An error message is printed to `System.err` if empty.
 *         *   The inner `try-catch` handles non-integer input for the menu choice.
 *     *   **Output:**
 *         *   `System.out` is used for the menu, prompts, successful operation messages, and listing tasks.
 *         *   `System.err` is used for displaying error messages, as required (invalid choice, empty description, no tasks to process, input mismatch, unexpected general exception).
 *     *   The `finally` block ensures the `Scanner` is closed when the program exits, releasing system resources.
 * 
 * This solution effectively integrates the required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, demonstrating object-oriented design principles (encapsulation) and robust error handling.
 */

import java.util.Queue;
import java.util.LinkedList; // Common Queue implementation
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single task in the system.
 */
class Task {
    private final int taskId;
    private final String description;
    private final long creationTime;

    /**
     * Constructs a new Task.
     * @param taskId The unique ID of the task.
     * @param description A brief description of the task.
     * @param creationTime The system time when the task was created.
     */
    public Task(int taskId, String description, long creationTime) {
        this.taskId = taskId;
        this.description = description;
        this.creationTime = creationTime;
    }

    // --- Getters ---

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public long getCreationTime() {
        return creationTime;
    }

    /**
     * Provides a string representation of the Task.
     * @return A formatted string including task ID, description, and creation time.
     */
    @Override
    public String toString() {
        // Simple representation, could format time better for a real app
        return "Task ID: " + taskId + ", Description: " + description + ", Created: " + creationTime;
    }
}

/**
 * Manages the queue of pending tasks and the list of completed tasks.
 */
class TaskProcessor {
    // Use LinkedList as a common implementation for Queue
    private final Queue<Task> pendingTasks;
    // Use ArrayList as a common implementation for List
    private final List<Task> completedTasks;
    private static int taskIdCounter = 0; // Static counter for unique IDs

    /**
     * Constructs a new TaskProcessor.
     * Initializes the pending and completed task collections.
     */
    public TaskProcessor() {
        this.pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>(); // ArrayList implements List
    }

    /**
     * Adds a new task to the pending queue.
     * Automatically generates a unique ID and sets creation time.
     * @param description The description for the new task.
     */
    public void addTask(String description) {
        int newTaskId = ++taskIdCounter; // Increment and get the new ID
        long currentTime = System.currentTimeMillis();
        Task newTask = new Task(newTaskId, description, currentTime);
        pendingTasks.offer(newTask); // offer is preferred over add as it doesn't throw exception on capacity limits (though LinkedList is unbounded)
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task from the pending queue.
     * Removes the task from pending and adds it to completed.
     * @return The processed Task, or null if the queue was empty.
     */
    public Task processNextTask() {
        System.out.println("Processing next task...");
        Task nextTask = pendingTasks.poll(); // poll returns null if queue is empty
        if (nextTask != null) {
            completedTasks.add(nextTask);
            System.out.println("Task processed: " + nextTask);
        } else {
            // Using System.err as required for error messages
            System.err.println("Error: No tasks in the queue to process.");
        }
        return nextTask;
    }

    /**
     * Gets the queue of pending tasks.
     * @return The Queue of tasks waiting to be processed.
     */
    public Queue<Task> getPendingTasks() {
        return pendingTasks;
    }

    /**
     * Gets the list of completed tasks.
     * @return The List of tasks that have been processed.
     */
    public List<Task> getCompletedTasks() {
        return completedTasks;
    }
}

/**
 * Main class to run the Task Processing System simulation.
 * Handles user interaction and calls methods on TaskProcessor.
 */
public class Main {

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("\n--- Task Processing System ---");
        System.out.println("1. Add Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Main entry point of the program.
     * Initializes the system and runs the main command loop.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskProcessor processor = new TaskProcessor();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling for the main operational loop
        try {
            while (running) {
                displayMenu();

                // Inner try-catch for handling input issues specifically
                try {
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading int

                    // Switch statement for flow control based on user choice
                    switch (choice) {
                        case 1:
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine().trim(); // Trim whitespace
                            if (description.isEmpty()) {
                                System.err.println("Error: Task description cannot be empty.");
                            } else {
                                processor.addTask(description);
                            }
                            break;
                        case 2:
                            processor.processNextTask(); // Method handles its own error output
                            break;
                        case 3:
                            System.out.println("Pending Tasks (Queue):");
                            Queue<Task> pending = processor.getPendingTasks();
                            if (pending.isEmpty()) {
                                System.out.println("  No pending tasks.");
                            } else {
                                // Iterate through the queue without removing elements
                                for (Task task : pending) {
                                    System.out.println("  " + task);
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Completed Tasks (List):");
                            List<Task> completed = processor.getCompletedTasks();
                             if (completed.isEmpty()) {
                                System.out.println("  No completed tasks.");
                            } else {
                                // Iterate through the list
                                for (Task task : completed) {
                                    System.out.println("  " + task);
                                }
                            }
                            break;
                        case 5:
                            running = false; // Set flag to exit the loop
                            System.out.println("Exiting Task Processing System.");
                            break;
                        default:
                            // Using System.err as required for error messages
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    // Handle cases where the user enters non-integer input for the choice
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                }
            }
        } catch (Exception e) {
            // General catch for any unexpected runtime errors during the main loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure the scanner is closed when the program exits
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}
