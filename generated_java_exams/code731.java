/*
 * Exam Question #731
 * Generated on: 2025-05-12 16:32:37
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam: Project Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application for managing tasks within a small project team. The system needs to keep track of all tasks created, allow marking tasks as ready for work, process tasks from a ready queue, and display task lists.
 * 
 * **Requirements:**
 * 
 * Implement a Java application that fulfills the following requirements:
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following attributes:
 *     *   `id` (int): Unique identifier for the task.
 *     *   `description` (String): A brief description of the task.
 *     *   `priority` (enum: `TaskPriority` - HIGH, MEDIUM, LOW): The priority level of the task.
 *     *   `status` (enum: `TaskStatus` - PENDING, READY, COMPLETED): The current status of the task.
 *     *   Implement proper encapsulation (private fields, public getters).
 *     *   Provide a meaningful `toString()` method for displaying task details.
 * 
 * 2.  **Task Management Logic:** Create a `TaskManager` class responsible for managing the collections of tasks.
 *     *   Maintain a collection of *all* tasks ever created. This collection **must** be an `ArrayList` declared using the `List` interface (`List<Task> allTasks = new ArrayList<>();`).
 *     *   Maintain a collection of tasks that are currently marked as `READY` and are waiting to be processed. This collection **must** be a `Queue` (`Queue<Task> readyTasksQueue`). Use `java.util.LinkedList` as the implementation class for the `Queue`.
 *     *   Implement the following methods in `TaskManager`:
 *         *   `addTask(String description, TaskPriority priority)`: Creates a new `Task` with `PENDING` status, adds it to the `allTasks` list, and returns the new task's ID.
 *         *   `markTaskReady(int taskId)`: Finds the task by ID in `allTasks`. If found and its status is `PENDING`, change its status to `READY` and add it to the `readyTasksQueue`. Throw appropriate custom exceptions if the task is not found or is not in the `PENDING` status.
 *         *   `processNextReadyTask()`: Removes the task at the front of the `readyTasksQueue`. Finds this task in `allTasks` (the reference should be the same) and changes its status to `COMPLETED`. Return the completed `Task` object. Throw a custom exception if the `readyTasksQueue` is empty.
 *         *   `getAllTasks()`: Returns a `List` containing all tasks managed by the system.
 *         *   `getReadyTasksInQueue()`: Returns a `List` containing the tasks currently in the `readyTasksQueue` (in queue order).
 * 
 * 3.  **User Interface:** Create a `Main` class with a `main` method to interact with the user via the console.
 *     *   Use `java.util.Scanner` to read user input.
 *     *   Present a menu of options to the user:
 *         1.  Add New Task
 *         2.  Mark Task Ready
 *         3.  Process Next Ready Task
 *         4.  List All Tasks
 *         5.  List Ready Tasks
 *         6.  Exit
 *     *   Use a `switch` statement to handle the user's command selection.
 *     *   Use `System.out` for displaying the menu, prompts, successful operation messages, and task lists.
 *     *   Use `System.err` for displaying error messages.
 * 
 * 4.  **Error Handling:**
 *     *   Implement custom exception classes for specific business logic errors (e.g., `TaskNotFoundException`, `InvalidTaskStatusException`, `NoReadyTasksException`).
 *     *   Implement class-wide exception handling in the `main` method using `try-catch` blocks to catch potential exceptions (including your custom exceptions and standard exceptions like `NumberFormatException` for invalid input) and print informative error messages to `System.err`.
 *     *   Implement input validation (e.g., validating priority string input).
 * 
 * 5.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadoc).
 *     *   Ensure proper encapsulation.
 *     *   Structure the code into appropriate classes and enums.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt for input based on the selected option, perform the requested action, and print results or error messages.
 * 
 * Example flow:
 * ```
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Mark Task Ready
 * 3. Process Next Ready Task
 * 4. List All Tasks
 * 5. List Ready Tasks
 * 6. Exit
 * Enter your choice: 1
 * Enter task description: Implement login feature
 * Enter priority (HIGH, MEDIUM, LOW): HIGH
 * Task added with ID 1.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 4
 * All Tasks:
 * Task ID: 1, Description: Implement login feature, Priority: HIGH, Status: PENDING
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * Enter task ID to mark ready: 1
 * Task 1 marked as READY.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 5
 * Ready Tasks Queue:
 * Task ID: 1, Description: Implement login feature, Priority: HIGH, Status: READY
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 3
 * Processing task ID 1...
 * Task ID: 1, Description: Implement login feature, Priority: HIGH, Status: COMPLETED
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 5
 * Ready Tasks Queue is empty.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 4
 * All Tasks:
 * Task ID: 1, Description: Implement login feature, Priority: HIGH, Status: COMPLETED
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 7
 * Error: Invalid command. Please enter a number between 1 and 6.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * Enter task ID to mark ready: 99
 * Error: Task with ID 99 not found.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 3
 * Error: No tasks are currently ready for processing.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 6
 * Exiting Task Management System.
 * ```
 *
 * EXPLANATION:
 * This solution implements a simple task management system demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Task Representation (`Task`, `TaskStatus`, `TaskPriority`):**
 *     *   The `Task` class is a simple Plain Old Java Object (POJO) with private fields (`id`, `description`, `priority`, `status`) and public getters, adhering to encapsulation. A `toString()` method provides a clear representation of a task.
 *     *   `TaskStatus` and `TaskPriority` are implemented as enums, providing type safety and clearly defining the possible states and priorities. The `TaskPriority` enum includes a static `fromString` helper method with validation to parse user input strings into enum values, throwing `IllegalArgumentException` for invalid input.
 * 
 * 2.  **Task Management Logic (`TaskManager`):**
 *     *   `TaskManager` holds two main collections:
 *         *   `allTasks`: Declared as `List<Task>` and initialized with `new ArrayList<>()`. This list maintains a record of every task created in the system. Using the `List` interface allows flexibility if a different `List` implementation were needed later, while `ArrayList` provides efficient random access needed for finding tasks by ID (though the current `findTaskById` is linear search, suitable for this scale).
 *         *   `readyTasksQueue`: Declared as `Queue<Task>` and initialized with `new LinkedList<>()`. `LinkedList` implements the `Queue` interface, providing FIFO (First-In, First-Out) behavior suitable for processing tasks in the order they become ready. The `Queue` methods `offer()` (for adding) and `poll()` (for removing/retrieving) are used.
 *     *   `addTask`: Creates a new task with a unique ID and `PENDING` status and adds it only to the `allTasks` list.
 *     *   `findTaskById`: A private helper method to locate a task in the `allTasks` list, returning an `Optional` to handle the case where the task is not found.
 *     *   `markTaskReady`: Uses `findTaskById`. Validates the task exists (`TaskNotFoundException`) and is in `PENDING` status (`InvalidTaskStatusException`). If valid, it updates the task's status to `READY` and adds the task object reference to the `readyTasksQueue`.
 *     *   `processNextReadyTask`: Uses `readyTasksQueue.poll()` to get the next task. If `poll()` returns `null`, it means the queue is empty, and a `NoReadyTasksException` is thrown. Otherwise, it updates the status of the retrieved task object to `COMPLETED`. Since the object in the queue is a reference to the object in `allTasks`, updating its status modifies the task in the master list as well.
 *     *   `getAllTasks` and `getReadyTasksInQueue`: Return copies of the internal collections as `List`s to prevent external code from directly modifying the `TaskManager`'s internal state.
 * 
 * 3.  **User Interface (`Main`):**
 *     *   The `main` method in the `Main` class handles user interaction.
 *     *   A `Scanner` object reads input from `System.in`.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   `printMenu()` displays options using `System.out`.
 *     *   User input is read and parsed.
 *     *   A `switch` statement directs execution based on the user's numerical choice. Each case calls the appropriate `TaskManager` method and prints success messages to `System.out`.
 *     *   The `default` case in the `switch` handles invalid command numbers and prints an error using `System.err`.
 * 
 * 4.  **Error Handling (`try-catch`, Custom Exceptions, `System.err`):**
 *     *   Custom exceptions (`TaskNotFoundException`, `InvalidTaskStatusException`, `NoReadyTasksException`) are defined to signal specific application errors clearly.
 *     *   The core command processing loop in `main` is wrapped in a large `try-catch` block. This demonstrates "class-wide" handling by catching exceptions thrown by the `TaskManager` methods or input parsing (`NumberFormatException`, `IllegalArgumentException`).
 *     *   Specific `catch` blocks handle expected custom exceptions and input format errors, printing informative messages using `System.err`. A general `catch(Exception e)` is included as a fallback for any unexpected errors, printing the message and stack trace (to `System.err`) for debugging.
 *     *   Input validation for the priority string is done within the `TaskPriority.fromString` method, throwing `IllegalArgumentException`, which is caught in `main`.
 * 
 * 5.  **Best Practices:**
 *     *   Meaningful names are used for classes, enums, variables, and methods (`TaskManager`, `readyTasksQueue`, `markTaskReady`, `processNextReadyTask`).
 *     *   Javadoc comments are included for classes and public methods, explaining their purpose and parameters/return values/exceptions.
 *     *   Encapsulation is maintained in the `Task` class.
 *     *   The code is structured logically into separate files/classes for different responsibilities.
 * 
 * This solution effectively uses all required components in a cohesive manner to simulate a practical task management workflow, demonstrating advanced Java concepts like collections (`List`, `Queue`, `ArrayList`, `LinkedList`), enums, custom exceptions, input handling, and structured error management.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Optional; // Used for finding task by ID cleanly

// Enum for Task Status
enum TaskStatus {
    PENDING, READY, COMPLETED
}

// Enum for Task Priority
enum TaskPriority {
    HIGH, MEDIUM, LOW;

    /**
     * Parses a string into a TaskPriority enum, case-insensitive.
     * Throws IllegalArgumentException if the string does not match any priority.
     * @param priorityString The string to parse.
     * @return The corresponding TaskPriority enum.
     */
    public static TaskPriority fromString(String priorityString) {
        for (TaskPriority priority : TaskPriority.values()) {
            if (priority.name().equalsIgnoreCase(priorityString)) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid priority: " + priorityString + ". Use HIGH, MEDIUM, or LOW.");
    }
}

// Custom Exception for Task Not Found
class TaskNotFoundException extends Exception {
    public TaskNotFoundException(int taskId) {
        super("Task with ID " + taskId + " not found.");
    }
}

// Custom Exception for Invalid Task Status
class InvalidTaskStatusException extends Exception {
    public InvalidTaskStatusException(int taskId, TaskStatus currentStatus, TaskStatus requiredStatus) {
        super("Task with ID " + taskId + " has status " + currentStatus + ", but required status is " + requiredStatus + ".");
    }
    public InvalidTaskStatusException(int taskId, TaskStatus currentStatus, String requiredStatuses) {
         super("Task with ID " + taskId + " has status " + currentStatus + ", but required status is one of: " + requiredStatuses + ".");
    }
}

// Custom Exception for No Ready Tasks
class NoReadyTasksException extends Exception {
    public NoReadyTasksException() {
        super("No tasks are currently ready for processing.");
    }
}


// Task Class
class Task {
    private int id;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;

    /**
     * Constructs a new Task.
     * @param id The unique ID for the task.
     * @param description The task description.
     * @param priority The task priority.
     */
    public Task(int id, String description, TaskPriority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING; // New tasks start as PENDING
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // Setter for status (used by TaskManager)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Task ID: %d, Description: %s, Priority: %s, Status: %s",
                             id, description, priority, status);
    }
}

// Task Manager Class
class TaskManager {
    // Use ArrayList declared as List interface
    private List<Task> allTasks = new ArrayList<>();
    // Use LinkedList as implementation for Queue interface
    private Queue<Task> readyTasksQueue = new LinkedList<>();
    private int nextTaskId = 1; // Counter for unique task IDs

    /**
     * Adds a new task to the system.
     * @param description The task description.
     * @param priority The task priority.
     * @return The ID of the newly added task.
     */
    public int addTask(String description, TaskPriority priority) {
        int taskId = nextTaskId++;
        Task newTask = new Task(taskId, description, priority);
        allTasks.add(newTask);
        return taskId;
    }

    /**
     * Finds a task by its ID.
     * @param taskId The ID of the task to find.
     * @return An Optional containing the Task if found, otherwise empty.
     */
    private Optional<Task> findTaskById(int taskId) {
        for (Task task : allTasks) {
            if (task.getId() == taskId) {
                return Optional.of(task);
            }
        }
        return Optional.empty();
    }

    /**
     * Marks a task as READY and adds it to the ready queue.
     * @param taskId The ID of the task to mark ready.
     * @throws TaskNotFoundException if the task ID does not exist.
     * @throws InvalidTaskStatusException if the task is not in PENDING status.
     */
    public void markTaskReady(int taskId) throws TaskNotFoundException, InvalidTaskStatusException {
        Optional<Task> taskOptional = findTaskById(taskId);

        if (!taskOptional.isPresent()) {
            throw new TaskNotFoundException(taskId);
        }

        Task task = taskOptional.get();

        if (task.getStatus() != TaskStatus.PENDING) {
            throw new InvalidTaskStatusException(taskId, task.getStatus(), TaskStatus.PENDING);
        }

        task.setStatus(TaskStatus.READY);
        readyTasksQueue.offer(task); // offer is safer than add, returns false on failure but queue is unbounded
    }

    /**
     * Processes the next task in the ready queue by marking it as COMPLETED.
     * @return The completed Task object.
     * @throws NoReadyTasksException if the ready queue is empty.
     */
    public Task processNextReadyTask() throws NoReadyTasksException {
        Task taskToProcess = readyTasksQueue.poll(); // poll returns null if queue is empty

        if (taskToProcess == null) {
            throw new NoReadyTasksException();
        }

        // Since the Task object in the queue is the same reference as in allTasks,
        // changing its status here updates the object in the allTasks list as well.
        taskToProcess.setStatus(TaskStatus.COMPLETED);

        return taskToProcess;
    }

    /**
     * Gets an unmodifiable list of all tasks.
     * @return A List of all tasks.
     */
    public List<Task> getAllTasks() {
        // Return a copy to prevent external modification of the internal list
        return new ArrayList<>(allTasks);
    }

    /**
     * Gets a list of tasks currently in the ready queue, in queue order.
     * @return A List of tasks in the ready queue.
     */
    public List<Task> getReadyTasksInQueue() {
        // Return a copy of the queue elements as a list
        return new ArrayList<>(readyTasksQueue);
    }
}

// Main Application Class
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean running = true;

        // Class-wide exception handling for the main command loop
        while (running) {
            try {
                printMenu();
                System.out.print("Enter your choice: ");
                String choiceInput = scanner.nextLine();
                int choice = Integer.parseInt(choiceInput); // Potential NumberFormatException

                // Switch statement for flow control
                switch (choice) {
                    case 1: // Add New Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                        String priorityString = scanner.nextLine();
                        TaskPriority priority = TaskPriority.fromString(priorityString); // Potential IllegalArgumentException
                        int newTaskId = taskManager.addTask(description, priority);
                        System.out.println("Task added with ID " + newTaskId + ".");
                        break;

                    case 2: // Mark Task Ready
                        System.out.print("Enter task ID to mark ready: ");
                        String taskIdReadyInput = scanner.nextLine();
                        int taskIdReady = Integer.parseInt(taskIdReadyInput); // Potential NumberFormatException
                        taskManager.markTaskReady(taskIdReady); // Potential TaskNotFoundException, InvalidTaskStatusException
                        System.out.println("Task " + taskIdReady + " marked as READY.");
                        break;

                    case 3: // Process Next Ready Task
                        System.out.println("Processing next task...");
                        Task completedTask = taskManager.processNextReadyTask(); // Potential NoReadyTasksException
                        System.out.println("Processed: " + completedTask);
                        break;

                    case 4: // List All Tasks
                        List<Task> allTasks = taskManager.getAllTasks(); // Use List interface
                        System.out.println("\n--- All Tasks ---");
                        if (allTasks.isEmpty()) {
                            System.out.println("No tasks available.");
                        } else {
                            for (Task task : allTasks) {
                                System.out.println(task); // Uses Task's toString()
                            }
                        }
                        System.out.println("-----------------");
                        break;

                    case 5: // List Ready Tasks
                        List<Task> readyTasks = taskManager.getReadyTasksInQueue(); // Use List interface
                        System.out.println("\n--- Ready Tasks Queue ---");
                        if (readyTasks.isEmpty()) {
                            System.out.println("Ready Tasks Queue is empty.");
                        } else {
                            // Iterate and print tasks from the list derived from the queue
                            for (Task task : readyTasks) {
                                System.out.println(task); // Uses Task's toString()
                            }
                        }
                        System.out.println("-------------------------");
                        break;

                    case 6: // Exit
                        running = false;
                        System.out.println("Exiting Task Management System.");
                        break;

                    default:
                        System.err.println("Invalid command. Please enter a number between 1 and 6."); // Use System.err
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid input. Please enter a number."); // Use System.err
            } catch (IllegalArgumentException e) { // Catches invalid priority string
                 System.err.println("Error: " + e.getMessage()); // Use System.err
            } catch (TaskNotFoundException | InvalidTaskStatusException | NoReadyTasksException e) {
                System.err.println("Error: " + e.getMessage()); // Use System.err for custom errors
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage()); // Use System.err
                e.printStackTrace(System.err); // Print stack trace to System.err for debugging
            }
            System.out.println(); // Add a newline for better readability between operations
        }

        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Mark Task Ready");
        System.out.println("3. Process Next Ready Task");
        System.out.println("4. List All Tasks");
        System.out.println("5. List Ready Tasks");
        System.out.println("6. Exit");
        System.out.println("--------------------------");
    }
}
