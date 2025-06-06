/*
 * Exam Question #312
 * Generated on: 2025-05-11 22:53:33
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam: Task Management System
 * 
 * **Objective:** Design and implement a simple command-line based task management system. The system should allow users to add new tasks, process the next pending task, and view pending and completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following attributes:
 *     *   `id` (int): A unique identifier for the task, automatically generated.
 *     *   `description` (String): A brief description of the task.
 *     *   `status` (enum `TaskStatus`): Represents the current state of the task (e.g., `PENDING`, `COMPLETED`).
 *     *   Include appropriate getters and a `toString()` method for easy display.
 * 
 * 2.  **Task Management Logic:** Create a `TaskProcessor` class responsible for managing the tasks. This class should use:
 *     *   A `java.util.Queue<Task>` to store tasks that are pending processing (FIFO - First-In, First-Out).
 *     *   A `java.util.List<Task>` (specifically, use `java.util.ArrayList<Task>`) to store tasks that have been completed.
 *     *   Include methods:
 *         *   `addTask(String description)`: Creates a new `Task` with a unique ID, `PENDING` status, and adds it to the pending queue. Validate that the description is not empty or null.
 *         *   `processNextTask()`: Removes the task from the front of the pending queue, changes its status to `COMPLETED`, and adds it to the completed list. This method should handle the case where the pending queue is empty.
 *         *   `getPendingTasks()`: Returns a `List<Task>` view of the tasks currently in the pending queue (without removing them).
 *         *   `getCompletedTasks()`: Returns the `List<Task>` of completed tasks.
 * 
 * 3.  **User Interface (Main Class):** Create a `Main` class with a `main` method to interact with the user via the console.
 *     *   Use `java.util.Scanner` to read user input.
 *     *   Implement a command loop that presents the user with options:
 *         *   `add`: Add a new task.
 *         *   `process`: Process the next pending task.
 *         *   `view pending`: Display all pending tasks.
 *         *   `view completed`: Display all completed tasks.
 *         *   `exit`: Terminate the program.
 *     *   Use a `switch` statement to handle different user commands.
 *     *   Use `System.out` for displaying the menu, prompts, and task lists.
 *     *   Use `System.err` for displaying error messages (e.g., invalid command, empty description, no tasks to process).
 *     *   Implement comprehensive exception handling using `try-catch` blocks within the main loop to gracefully handle:
 *         *   `java.util.InputMismatchException` if the user enters input of the wrong type (though Scanner with `nextLine` then parsing is safer, catch potential issues).
 *         *   Specific exceptions thrown by `TaskProcessor` methods (e.g., if `processNextTask` is called on an empty queue).
 *         *   General exceptions as a fallback.
 *     *   Ensure the `Scanner` is closed when the program exits.
 * 
 * 4.  **Best Practices:**
 *     *   Use proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Add comments where necessary to explain complex logic.
 *     *   Include input validation as specified.
 *     *   Ensure error messages are informative and printed to `System.err`.
 * 
 * **Expected Output:**
 * 
 * The program should start, display a menu, and respond to user commands. Examples:
 * 
 * ```
 * --- Task Management Menu ---
 * add - Add new task
 * process - Process next pending task
 * view pending - View pending tasks
 * view completed - View completed tasks
 * exit - Exit program
 * ----------------------------
 * Enter command: add
 * Enter task description: Write exam question
 * Task added with ID 1.
 * Enter command: add
 * Enter task description: Create solution code
 * Task added with ID 2.
 * Enter command: view pending
 * Pending Tasks:
 * ID: 1, Description: Write exam question, Status: PENDING
 * ID: 2, Description: Create solution code, Status: PENDING
 * Enter command: process
 * Task ID 1 processed.
 * Enter command: view completed
 * Completed Tasks:
 * ID: 1, Description: Write exam question, Status: COMPLETED
 * Enter command: process
 * Task ID 2 processed.
 * Enter command: view pending
 * Pending Tasks:
 * Enter command: process
 * Error: No tasks in the pending queue to process.
 * Enter command: exit
 * Exiting program.
 * ```
 * *(Note: Error messages should go to System.err, while normal output goes to System.out)*
 * 
 * **Evaluation:** Your solution will be evaluated based on correctness, adherence to all requirements (including the use of specified components), code structure, best practices, and robust error handling.
 *
 * EXPLANATION:
 * This solution implements a basic task management system demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`TaskStatus` Enum:** A simple enum defines the possible states of a task, making the code more readable and preventing invalid status values.
 * 2.  **`Task` Class:** This is a simple Plain Old Java Object (POJO) representing a task.
 *     *   It has `private` fields (`id`, `description`, `status`) for encapsulation.
 *     *   The constructor takes `id` and `description`, setting the initial status to `PENDING`. It includes input validation for the description, throwing an `IllegalArgumentException` if it's invalid.
 *     *   Public getter methods provide access to the task's attributes.
 *     *   A package-private `setStatus` method is included, allowing only classes within the same package (like `TaskProcessor`) to change the status, maintaining control.
 *     *   `toString()` provides a convenient way to display task information.
 * 3.  **`TaskProcessingException`:** A custom exception class is created to specifically signal errors related to task processing logic, such as trying to process a task when none are available. This makes the error handling in `main` more specific and readable.
 * 4.  **`TaskProcessor` Class:** This class encapsulates the core logic of managing tasks.
 *     *   It uses a `java.util.Queue<Task>` (`pendingTasks`) implemented by `java.util.LinkedList` to maintain tasks in a FIFO order.
 *     *   It uses a `java.util.List<Task>` (`completedTasks`) implemented by `java.util.ArrayList` to store tasks once they are finished.
 *     *   `nextTaskId` is a simple counter to generate unique task IDs.
 *     *   `addTask(String description)`: Creates a new `Task` and adds it to the `pendingTasks` queue using `offer()`. It relies on the `Task` constructor for description validation.
 *     *   `processNextTask()`: Uses `poll()` to retrieve and remove the head of the `pendingTasks` queue. If `poll()` returns `null` (meaning the queue was empty), it throws the custom `TaskProcessingException`. Otherwise, it updates the task's status and adds it to the `completedTasks` list.
 *     *   `getPendingTasks()` and `getCompletedTasks()`: These methods return copies or unmodifiable views of the internal lists. This prevents external code from directly manipulating the processor's internal state (e.g., adding/removing tasks from the queue or list directly), upholding encapsulation.
 * 5.  **`TaskManagementSystem` (Main Class):**
 *     *   Contains the `main` method, which is the entry point of the application.
 *     *   A `Scanner` is initialized to read input from `System.in`.
 *     *   A `TaskProcessor` instance is created.
 *     *   A `while` loop keeps the program running until the user chooses to exit.
 *     *   Inside the loop:
 *         *   The menu is printed using `System.out`.
 *         *   User input is read using `scanner.nextLine()`.
 *         *   A `try-catch` block surrounds the core command processing logic. This is crucial for handling potential errors gracefully without crashing the program.
 *         *   A `switch` statement handles the different commands entered by the user.
 *         *   Each `case` calls the appropriate method on the `TaskProcessor` or handles the exit logic.
 *         *   `System.out` is used for successful operations and information display.
 *         *   The `catch` blocks handle specific exceptions (`IllegalArgumentException` from validation, `TaskProcessingException` from processing errors) and a general `Exception` as a fallback. Error messages are printed to `System.err` as required.
 *     *   Finally, `scanner.close()` is called outside the loop but within the main method to release system resources when the program finishes.
 * 
 * This solution effectively uses all the required Java components in a cohesive, practical scenario, following best practices for object-oriented design, input handling, and error management.
 */

import java.util.Queue;
import java.util.LinkedList; // Common Queue implementation
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; // To return unmodifiable list view

// 1. TaskStatus Enum
enum TaskStatus {
    PENDING,
    COMPLETED
}

// 2. Task Class
class Task {
    private int id;
    private String description;
    private TaskStatus status;

    public Task(int id, String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty.");
        }
        this.id = id;
        this.description = description.trim();
        this.status = TaskStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // Method to change status (used internally by TaskProcessor)
    void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Description: %s, Status: %s", id, description, status);
    }
}

// Custom Exception for TaskProcessor
class TaskProcessingException extends Exception {
    public TaskProcessingException(String message) {
        super(message);
    }
}

// 3. TaskProcessor Class
class TaskProcessor {
    private Queue<Task> pendingTasks;
    private List<Task> completedTasks;
    private int nextTaskId;

    public TaskProcessor() {
        this.pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>(); // ArrayList implements List
        this.nextTaskId = 1;
    }

    /**
     * Adds a new task to the pending queue.
     *
     * @param description The description of the task.
     * @return The newly created Task object.
     * @throws IllegalArgumentException if the description is null or empty.
     */
    public Task addTask(String description) throws IllegalArgumentException {
        Task newTask = new Task(nextTaskId++, description);
        pendingTasks.offer(newTask); // offer is generally preferred over add for queues
        return newTask;
    }

    /**
     * Processes the next task in the pending queue.
     * Moves the task from pending to completed list.
     *
     * @throws TaskProcessingException if the pending queue is empty.
     */
    public void processNextTask() throws TaskProcessingException {
        Task taskToProcess = pendingTasks.poll(); // poll retrieves and removes the head of the queue

        if (taskToProcess == null) {
            throw new TaskProcessingException("No tasks in the pending queue to process.");
        }

        taskToProcess.setStatus(TaskStatus.COMPLETED);
        completedTasks.add(taskToProcess);
        System.out.println("Task ID " + taskToProcess.getId() + " processed.");
    }

    /**
     * Gets an unmodifiable view of the pending tasks queue.
     *
     * @return A List containing pending tasks.
     */
    public List<Task> getPendingTasks() {
        // Return a new ArrayList or an unmodifiable list to prevent external modification
        return new ArrayList<>(pendingTasks);
        // Alternative: return Collections.unmodifiableList(new ArrayList<>(pendingTasks));
    }

    /**
     * Gets an unmodifiable view of the completed tasks list.
     *
     * @return A List containing completed tasks.
     */
    public List<Task> getCompletedTasks() {
        // Return an unmodifiable list to prevent external modification
        return Collections.unmodifiableList(completedTasks);
    }
}

// 4. Main Class
public class TaskManagementSystem {

    private static void printMenu() {
        System.out.println("\n--- Task Management Menu ---");
        System.out.println("add - Add new task");
        System.out.println("process - Process next pending task");
        System.out.println("view pending - View pending tasks");
        System.out.println("view completed - View completed tasks");
        System.out.println("exit - Exit program");
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskProcessor processor = new TaskProcessor();
        boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim().toLowerCase();

            try {
                switch (command) {
                    case "add":
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        Task addedTask = processor.addTask(description);
                        System.out.println("Task added with ID " + addedTask.getId() + ".");
                        break;

                    case "process":
                        processor.processNextTask();
                        break;

                    case "view pending":
                        List<Task> pending = processor.getPendingTasks();
                        System.out.println("Pending Tasks:");
                        if (pending.isEmpty()) {
                            System.out.println("(No pending tasks)");
                        } else {
                            for (Task task : pending) {
                                System.out.println(task);
                            }
                        }
                        break;

                    case "view completed":
                        List<Task> completed = processor.getCompletedTasks();
                        System.out.println("Completed Tasks:");
                        if (completed.isEmpty()) {
                            System.out.println("(No completed tasks)");
                        } else {
                            for (Task task : completed) {
                                System.out.println(task);
                            }
                        }
                        break;

                    case "exit":
                        running = false;
                        System.out.println("Exiting program.");
                        break;

                    default:
                        System.err.println("Error: Invalid command. Please try again.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                // Catches errors from Task constructor/addTask validation
                System.err.println("Input Error: " + e.getMessage());
            } catch (TaskProcessingException e) {
                // Catches errors specific to task processing (like empty queue)
                System.err.println("Processing Error: " + e.getMessage());
            } catch (Exception e) {
                // General catch-all for unexpected errors
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging
            }
        }

        scanner.close();
    }
}
