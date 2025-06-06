/*
 * Exam Question #1027
 * Generated on: 2025-05-12 17:14:51
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Resource Allocation and Task Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple system to manage tasks that require processing by a limited pool of resources (e.g., servers, machines). Tasks arrive and are placed in a waiting queue. When a processing resource becomes available, it takes the next task from the queue and begins processing it. Once processing is complete, the task is moved to a completed list. The system needs to allow users to add new tasks, initiate processing of the next available task, mark a processing task as complete, and view the current status of all tasks.
 * 
 * **Your Task:**
 * 
 * Implement a Java program that simulates this resource allocation and task processing system. Your solution must adhere to the following requirements:
 * 
 * 1.  **Task Representation:** Create a `Task` class to represent a single task. It should have attributes for a unique `id`, a `description`, and a `status` (e.g., PENDING, PROCESSING, COMPLETED). Use an `enum` for the task status.
 * 2.  **System Management:** Create a `ResourceAllocationSystem` class that manages the tasks. This class will contain the main logic and the collections holding the tasks.
 * 3.  **Collections:**
 *     *   Use a `java.util.Queue` (specifically, a `LinkedList` implementing `Queue`) to store tasks that are waiting to be processed.
 *     *   Use a `java.util.ArrayList` to store tasks that are currently being processed.
 *     *   Use a `java.util.ArrayList` to store tasks that have been completed.
 *     *   When declaring variables for the processing and completed task lists, use the `java.util.List` interface type (e.g., `List<Task> processingTasks`).
 * 4.  **Resource Limit:** The system should have a configurable maximum number of tasks that can be processed concurrently.
 * 5.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user commands from the console.
 *     *   Implement a command-line interface with the following options:
 *         *   `add <description>`: Adds a new task with the given description to the waiting queue. The system should automatically assign a unique ID.
 *         *   `process`: Attempts to move the next task from the waiting queue to the processing list, provided there is a resource available (i.e., the number of currently processing tasks is less than the maximum allowed).
 *         *   `complete <taskId>`: Marks the task with the given ID as completed. This task must currently be in the processing list. It should then be moved to the completed list.
 *         *   `status`: Displays the current state of the system: the tasks in the waiting queue, the tasks being processed, and the tasks completed.
 *         *   `exit`: Terminates the program.
 *     *   Use a `switch` statement to handle the different user commands.
 * 6.  **Output and Error Handling:**
 *     *   Use `System.out` for normal messages, menus, and status displays.
 *     *   Use `System.err` to report error conditions (e.g., invalid command, missing task description, queue is empty when trying to process, no resources available, task ID not found for completion).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential issues during program execution (e.g., invalid input format for task ID).
 * 7.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods) in the `Task` class.
 *     *   Use meaningful names for variables, methods, and classes.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Implement input validation where necessary (e.g., task description not empty, task ID is a valid integer).
 *     *   Structure your code cleanly.
 * 
 * **Input Format:**
 * 
 * Commands will be entered on a single line.
 * *   `add <description>`: `description` can be multiple words.
 * *   `complete <taskId>`: `taskId` is an integer.
 * 
 * **Expected Output:**
 * 
 * *   Display a menu of options upon starting.
 * *   Acknowledge successful operations (e.g., "Task added with ID X").
 * *   Report errors using `System.err`.
 * *   The `status` command should clearly list tasks under "Waiting Queue", "Processing", and "Completed" sections, showing task ID, description, and status.
 * 
 * **Example Interaction (Illustrative):**
 * 
 * ```
 * Resource Allocation System
 * Max concurrent processors: 3
 * Commands: add <description>, process, complete <taskId>, status, exit
 * 
 * Enter command: add Process Data Batch A
 * Task added with ID 1.
 * 
 * Enter command: add Generate Report
 * Task added with ID 2.
 * 
 * Enter command: status
 * --- System Status ---
 * Waiting Queue:
 * [ID: 1, Description: Process Data Batch A, Status: PENDING]
 * [ID: 2, Description: Generate Report, Status: PENDING]
 * Processing:
 * (Empty)
 * Completed:
 * (Empty)
 * ---------------------
 * 
 * Enter command: process
 * Processing task ID 1: Process Data Batch A
 * 
 * Enter command: process
 * Processing task ID 2: Generate Report
 * 
 * Enter command: process
 * System.err: No free processors available. Max concurrent: 3
 * 
 * Enter command: status
 * --- System Status ---
 * Waiting Queue:
 * (Empty)
 * Processing:
 * [ID: 1, Description: Process Data Batch A, Status: PROCESSING]
 * [ID: 2, Description: Generate Report, Status: PROCESSING]
 * Completed:
 * (Empty)
 * ---------------------
 * 
 * Enter command: complete 1
 * Task ID 1 marked as COMPLETED.
 * 
 * Enter command: status
 * --- System Status ---
 * Waiting Queue:
 * (Empty)
 * Processing:
 * [ID: 2, Description: Generate Report, Status: PROCESSING]
 * Completed:
 * [ID: 1, Description: Process Data Batch A, Status: COMPLETED]
 * ---------------------
 * 
 * Enter command: exit
 * Exiting system.
 * ```
 * 
 * **Constraints:**
 * 
 * *   Your solution must use ALL the components listed in Requirement 1.
 * *   Implement the specified command interface.
 * *   Handle edge cases like empty queues, full processors, invalid task IDs, and invalid input formats.
 * 
 * This task requires you to integrate various core Java concepts to build a functional system. Good luck!
 *
 * EXPLANATION:
 * This solution implements the `ResourceAllocationSystem` as described, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Task` Class and `TaskStatus` Enum:**
 *     *   The `Task` class encapsulates task data (`id`, `description`, `status`). Fields are `private`, accessed via public getter methods (`getId`, `getDescription`, `getStatus`). A `setStatus` method is provided for the system to update the task's state.
 *     *   The constructor includes input validation for the description, throwing an `IllegalArgumentException` if it's null or empty.
 *     *   A `toString()` method provides a convenient way to print task details.
 *     *   The `TaskStatus` enum clearly defines the possible states of a task (`PENDING`, `PROCESSING`, `COMPLETED`), making the code more readable and preventing invalid status values.
 * 
 * 2.  **`ResourceAllocationSystem` Class:**
 *     *   This class contains the core logic and the collections.
 *     *   `private` fields are used for the collections (`taskQueue`, `processingTasks`, `completedTasks`), `nextTaskId`, `maxConcurrentProcessors`, and the `Scanner`.
 *     *   `taskQueue` is declared as `Queue<Task>` and initialized with a `LinkedList`, fulfilling the requirement to use `Queue` and `LinkedList`. `Queue`'s `offer()` (add) and `poll()` (retrieve and remove) methods are used, which are standard practice for queue operations.
 *     *   `processingTasks` and `completedTasks` are declared as `List<Task>` and initialized with `ArrayList`, fulfilling the requirement to use `List` and `ArrayList`. `ArrayList` is suitable here for dynamically adding and removing tasks from these lists.
 *     *   The `maxConcurrentProcessors` is a `final` field set in the constructor, enforcing the resource limit.
 * 
 * 3.  **Methods and Logic:**
 *     *   `addTask(String description)`: Creates a new `Task` object with a unique ID (`nextTaskId++`) and adds it to the `taskQueue` using `offer()`. Includes a `try-catch` block to handle potential `IllegalArgumentException` from the `Task` constructor's validation.
 *     *   `processNextTask()`: Checks if there are available processors (`processingTasks.size() < maxConcurrentProcessors`). If so, it attempts to get the next task from the `taskQueue` using `poll()`. If a task is retrieved, its status is updated to `PROCESSING`, and it's moved to the `processingTasks` list. Appropriate error messages are printed to `System.err` if the queue is empty or no processors are free.
 *     *   `completeTask(int taskId)`: Iterates through the `processingTasks` list using an `Iterator` to find the task with the matching ID. Using an `Iterator`'s `remove()` method is the safe way to remove elements while iterating over a collection in Java. If the task is found, it's removed from `processingTasks`, its status is updated to `COMPLETED`, and it's added to the `completedTasks` list. An error message is printed to `System.err` if the task is not found in the processing list.
 *     *   `viewStatus()`: Prints the contents of all three collections (`taskQueue`, `processingTasks`, `completedTasks`) to `System.out`, providing a clear overview of the system's state. It checks if lists are empty and prints a placeholder message.
 *     *   `run()`: This method contains the main application loop. It displays the menu, reads user input using `Scanner`, and uses a `switch` statement to dispatch commands.
 *     *   `main(String[] args)`: The entry point of the program, creates an instance of `ResourceAllocationSystem` and calls its `run()` method. Includes a `try-catch` block to handle potential issues during system initialization.
 * 
 * 4.  **User Input (`Scanner`) and Command Handling (`Switch`):**
 *     *   A `Scanner` is used to read entire lines of input (`scanner.nextLine()`).
 *     *   Input lines are split to separate the command from its arguments.
 *     *   A `switch` statement on the command string directs execution to the appropriate method (`addTask`, `processNextTask`, `completeTask`, `viewStatus`, `exit`).
 *     *   Input validation for the `complete` command checks if an argument is provided and attempts to parse it as an integer, handling `NumberFormatException` with a `try-catch` block specific to that operation.
 * 
 * 5.  **Error Handling (`System.err`, `try-catch`):**
 *     *   `System.err.println()` is used for all error messages (e.g., invalid commands, queue empty, task not found, invalid input format).
 *     *   A `try-catch (Exception e)` block is placed around the main command processing logic within the `run()` loop. This provides class-wide exception handling, catching any unexpected runtime exceptions that might occur during command execution and preventing the program from crashing abruptly. Specific error handling for `NumberFormatException` in the `complete` command demonstrates handling expected input errors. The `addTask` method also has a `try-catch` for its specific validation exception.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation is used in the `Task` class.
 *     *   Variable and method names are descriptive (`taskQueue`, `processNextTask`, `completeTask`, etc.).
 *     *   Comments explain the purpose of classes and methods (Javadoc style).
 *     *   Input validation is performed for task descriptions and task IDs.
 *     *   Error handling is implemented using both `System.err` for user-level errors and `try-catch` for program errors.
 *     *   The code is structured into logical methods and classes, making it maintainable. The `Scanner` is closed when the program exits.
 * 
 * This solution effectively integrates the required Java components within a practical scenario, demonstrating understanding of data structures, object-oriented principles, input/output, control flow, and error handling.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

// Enum for Task Status
enum TaskStatus {
    PENDING,
    PROCESSING,
    COMPLETED
}

// Represents a single task in the system
class Task {
    private int id;
    private String description;
    private TaskStatus status;

    /**
     * Constructs a new Task.
     * @param id The unique ID for the task.
     * @param description A brief description of the task.
     */
    public Task(int id, String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty.");
        }
        this.id = id;
        this.description = description.trim();
        this.status = TaskStatus.PENDING;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // Setter for status (used by the system, not directly by user)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Description: " + description + ", Status: " + status + "]";
    }
}

// Manages the task queue, processing, and completion
public class ResourceAllocationSystem {

    private Queue<Task> taskQueue;
    private List<Task> processingTasks;
    private List<Task> completedTasks;
    private int nextTaskId;
    private final int maxConcurrentProcessors;
    private Scanner scanner;

    /**
     * Constructs the ResourceAllocationSystem.
     * @param maxConcurrentProcessors The maximum number of tasks that can be processed at once.
     */
    public ResourceAllocationSystem(int maxConcurrentProcessors) {
        if (maxConcurrentProcessors <= 0) {
             throw new IllegalArgumentException("Maximum concurrent processors must be positive.");
        }
        this.taskQueue = new LinkedList<>(); // Using LinkedList as a Queue
        this.processingTasks = new ArrayList<>(); // Using ArrayList as a List
        this.completedTasks = new ArrayList<>(); // Using ArrayList as a List
        this.nextTaskId = 1;
        this.maxConcurrentProcessors = maxConcurrentProcessors;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task to the waiting queue.
     * @param description The description of the task.
     */
    public void addTask(String description) {
        try {
            Task newTask = new Task(nextTaskId++, description);
            taskQueue.offer(newTask); // offer is preferred over add for queues
            System.out.println("Task added with ID " + newTask.getId() + ".");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding task: " + e.getMessage());
        } catch (Exception e) {
             System.err.println("An unexpected error occurred while adding task: " + e.getMessage());
        }
    }

    /**
     * Attempts to move the next task from the queue to processing.
     */
    public void processNextTask() {
        if (processingTasks.size() >= maxConcurrentProcessors) {
            System.err.println("No free processors available. Max concurrent: " + maxConcurrentProcessors);
            return;
        }

        Task taskToProcess = taskQueue.poll(); // poll retrieves and removes the head of the queue
        if (taskToProcess == null) {
            System.err.println("Task queue is empty. No tasks to process.");
            return;
        }

        taskToProcess.setStatus(TaskStatus.PROCESSING);
        processingTasks.add(taskToProcess);
        System.out.println("Processing task ID " + taskToProcess.getId() + ": " + taskToProcess.getDescription());
    }

    /**
     * Marks a task currently in processing as completed.
     * @param taskId The ID of the task to complete.
     */
    public void completeTask(int taskId) {
        Task taskToComplete = null;
        Iterator<Task> iterator = processingTasks.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == taskId) {
                taskToComplete = task;
                iterator.remove(); // Safely remove from processingTasks
                break;
            }
        }

        if (taskToComplete == null) {
            System.err.println("Task ID " + taskId + " not found in the processing list.");
            return;
        }

        taskToComplete.setStatus(TaskStatus.COMPLETED);
        completedTasks.add(taskToComplete);
        System.out.println("Task ID " + taskId + " marked as COMPLETED.");
    }

    /**
     * Displays the current status of all task lists.
     */
    public void viewStatus() {
        System.out.println("\n--- System Status ---");

        System.out.println("Waiting Queue:");
        if (taskQueue.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            for (Task task : taskQueue) {
                System.out.println(task);
            }
        }

        System.out.println("Processing:");
        if (processingTasks.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            for (Task task : processingTasks) {
                System.out.println(task);
            }
        }

        System.out.println("Completed:");
        if (completedTasks.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
        System.out.println("---------------------\n");
    }

    /**
     * Runs the main command loop for the system.
     */
    public void run() {
        System.out.println("Resource Allocation System");
        System.out.println("Max concurrent processors: " + maxConcurrentProcessors);
        System.out.println("Commands: add <description>, process, complete <taskId>, status, exit");

        boolean running = true;
        while (running) {
            System.out.print("\nEnter command: ");
            String inputLine = scanner.nextLine().trim();

            if (inputLine.isEmpty()) {
                continue; // Ignore empty lines
            }

            String[] parts = inputLine.split(" ", 2); // Split into command and argument part
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : "";

            try { // Class-wide exception handling for the command processing loop
                switch (command) {
                    case "add":
                        addTask(argument);
                        break;
                    case "process":
                        processNextTask();
                        break;
                    case "complete":
                        if (argument.isEmpty()) {
                            System.err.println("Error: complete command requires a task ID.");
                        } else {
                            try {
                                int taskId = Integer.parseInt(argument);
                                completeTask(taskId);
                            } catch (NumberFormatException e) {
                                System.err.println("Error: Invalid task ID format. Please enter a number.");
                            }
                        }
                        break;
                    case "status":
                        viewStatus();
                        break;
                    case "exit":
                        running = false;
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Unknown command: " + command);
                        System.out.println("Commands: add <description>, process, complete <taskId>, status, exit");
                }
            } catch (Exception e) {
                // Catch any unexpected exceptions during command execution
                System.err.println("An unexpected error occurred during command execution: " + e.getMessage());
                e.printStackTrace(); // Optional: Print stack trace for debugging in exam context
            }
        }
        scanner.close(); // Close the scanner when done
    }

    public static void main(String[] args) {
        // Instantiate the system with a maximum of 3 concurrent processors
        try {
            ResourceAllocationSystem system = new ResourceAllocationSystem(3);
            system.run();
        } catch (IllegalArgumentException e) {
             System.err.println("System initialization error: " + e.getMessage());
        } catch (Exception e) {
             System.err.println("An unexpected error occurred during system startup: " + e.getMessage());
             e.printStackTrace();
        }
    }
}
