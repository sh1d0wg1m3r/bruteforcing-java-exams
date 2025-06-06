/*
 * Exam Question #179
 * Generated on: 2025-05-11 22:26:55
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line task management system. The system should allow users to add tasks to a backlog, schedule tasks from the backlog to a ready queue for processing, execute the next task in the ready queue, and view tasks in different states (backlog, ready, completed).
 * 
 * Tasks have a name, a unique ID, a priority (High, Medium, Low), and a status (Backlog, Ready, Completed). Tasks are initially added to the backlog. From the backlog, a task can be moved to the ready queue. The system should process tasks from the ready queue in a First-In, First-Out (FIFO) manner. Once a task is executed, it moves to a list of completed tasks.
 * 
 * Your implementation must demonstrate advanced understanding of Java concepts, including collections, enums, custom exceptions, and user interaction handling.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with private fields for `id` (int), `name` (String), `priority` (an enum `Priority`), and `status` (an enum `TaskStatus`). Include a constructor, getters for all fields, and a method to update the status (controlled by the `TaskManager`). Implement a `toString()` method for easy printing.
 * 2.  **Priority and Status Enums:** Define two enums: `Priority` (with values HIGH, MEDIUM, LOW) and `TaskStatus` (with values BACKLOG, READY, COMPLETED).
 * 3.  **Task Management Logic:** Create a `TaskManager` class responsible for managing the tasks.
 *     *   It must use a `java.util.List` (specifically `ArrayList`) to store tasks in the backlog.
 *     *   It must use a `java.util.Queue` (specifically `LinkedList` which implements `Queue`) to store tasks ready for execution. Tasks should be added to the queue when scheduled and removed from the head when executed.
 *     *   It must use another `java.util.List` (specifically `ArrayList`) to store completed tasks.
 *     *   Implement methods in `TaskManager` for:
 *         *   `addTaskToBacklog(String name, Priority priority)`: Creates a new `Task` with a unique ID and adds it to the backlog.
 *         *   `scheduleTask(int taskId)`: Finds a task by ID in the backlog, removes it, changes its status to READY, and adds it to the ready queue.
 *         *   `executeNextTask()`: Takes the task from the head of the ready queue, changes its status to COMPLETED, and adds it to the completed tasks list.
 *         *   Methods to retrieve the lists/queue for display (`getBacklog()`, `getReadyQueue()`, `getCompleted()`).
 * 4.  **User Interface:** Create a main class (e.g., `TaskApp`) with a `main` method.
 *     *   Use `java.util.Scanner` to read user commands from the console.
 *     *   Use a `switch` statement to handle different user commands (e.g., "add", "schedule", "execute", "list backlog", "list ready", "list completed", "exit").
 *     *   Prompt the user for necessary input (task name, priority, task ID).
 * 5.  **Error Handling:**
 *     *   Implement input validation (e.g., ensuring task name is not empty, priority is valid, task ID is a number). Use `System.err` to report invalid input or command errors.
 *     *   Define custom checked exceptions (e.g., `TaskNotFoundException`, `TaskOperationException`) for errors like trying to schedule a non-existent task, scheduling a task not in the backlog, or executing from an empty queue.
 *     *   Use `try-catch` blocks in the `main` method to handle these custom exceptions, as well as potential `InputMismatchException` or `NumberFormatException` during input parsing. Report caught errors to `System.err`. Demonstrate a form of "class-wide" or main loop exception handling.
 * 6.  **Best Practices:**
 *     *   Employ proper encapsulation (private fields, public/package-private methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments or documentation for key classes and methods.
 *     *   Ensure `Scanner` is closed properly.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, presenting a menu of commands. Based on user input, it should perform the requested operation, print status messages to `System.out`, and print error messages to `System.err`.
 * 
 * Example interaction:
 * ```
 * --- Simple Task Management System ---
 * Available commands:
 *   add          - Add a new task to the backlog
 *   schedule     - Move a task from backlog to ready queue by ID
 *   execute      - Execute the next task from the ready queue
 *   list backlog - List tasks in the backlog
 *   list ready   - List tasks in the ready queue
 *   list completed - List completed tasks
 *   exit         - Exit the application
 * Enter command: add
 * Enter task name: Design Database
 * Enter priority (HIGH, MEDIUM, LOW): HIGH
 * Added to backlog: Task [ID=1, Name='Design Database', Priority=HIGH, Status=BACKLOG]
 * 
 * Enter command: add
 * Enter task name: Implement Login
 * Enter priority (HIGH, MEDIUM, LOW): MEDIUM
 * Added to backlog: Task [ID=2, Name='Implement Login', Priority=MEDIUM, Status=BACKLOG]
 * 
 * Enter command: list backlog
 * --- Backlog Tasks ---
 * Task [ID=1, Name='Design Database', Priority=HIGH, Status=BACKLOG]
 * Task [ID=2, Name='Implement Login', Priority=MEDIUM, Status=BACKLOG]
 * ---------------------
 * 
 * Enter command: schedule
 * Enter ID of task to schedule: 1
 * Scheduled to ready queue: Task [ID=1, Name='Design Database', Priority=HIGH, Status=READY]
 * 
 * Enter command: list ready
 * --- Ready Queue Tasks ---
 * Task [ID=1, Name='Design Database', Priority=HIGH, Status=READY]
 * -------------------------
 * 
 * Enter command: execute
 * Executed and moved to completed: Task [ID=1, Name='Design Database', Priority=HIGH, Status=COMPLETED]
 * 
 * Enter command: list completed
 * --- Completed Tasks ---
 * Task [ID=1, Name='Design Database', Priority=HIGH, Status=COMPLETED]
 * -----------------------
 * 
 * Enter command: execute
 * Operation Error: Ready queue is empty. No tasks to execute.
 * 
 * Enter command: exit
 * Exiting Task Management System. Goodbye!
 * ```
 * 
 * Your solution should be provided as a single block of Java code containing all necessary classes and enums.
 *
 * EXPLANATION:
 * This solution implements a simple task management system demonstrating the required Java concepts.
 * 
 * 1.  **Enums (`Priority`, `TaskStatus`):** Enums are used to represent fixed sets of constants, making the code more readable and preventing invalid values for priority and status.
 * 2.  **`Task` Class:** A simple Plain Old Java Object (POJO) representing a task. It encapsulates task data (`id`, `name`, `priority`, `status`) with private fields and public getters. A package-private setter `setStatus` allows the `TaskManager` to control state transitions. Input validation is included in the constructor using `IllegalArgumentException`.
 * 3.  **Custom Exceptions (`TaskOperationException`, `TaskNotFoundException`):** Checked exceptions are defined to signal specific error conditions that the caller (`TaskApp`) must explicitly handle. `TaskNotFoundException` extends `TaskOperationException`, demonstrating a simple exception hierarchy.
 * 4.  **`TaskManager` Class:** This class contains the core logic and manages the task collections:
 *     *   `backlog`: An `ArrayList<Task>` is used to store tasks waiting to be scheduled. `ArrayList` is suitable here as we might need to iterate or remove elements by ID.
 *     *   `readyQueue`: A `LinkedList<Task>` is used, typed as a `Queue<Task>`. `LinkedList` implements the `Queue` interface and provides the FIFO behavior needed for processing tasks in order (`offer` to add to the tail, `poll` to remove from the head).
 *     *   `completedTasks`: An `ArrayList<Task>` stores tasks after execution.
 *     *   Methods like `addTaskToBacklog`, `scheduleTask`, and `executeNextTask` encapsulate the state changes and movement of tasks between collections. `scheduleTask` and `executeNextTask` are declared to throw the custom checked exceptions, forcing the caller to handle them. A private helper `findTaskInBacklog` demonstrates searching within the list. Getters return copies of the lists for better encapsulation, while the queue is returned directly for simplicity in this exam context (with a comment noting the production best practice).
 * 5.  **`TaskApp` Class (`main` method):** This class provides the command-line interface.
 *     *   `Scanner`: Used to read user input line by line (`nextLine()`) to avoid common pitfalls with `nextInt()` or `nextDouble()`.
 *     *   `switch` statement: Controls the flow based on the user's command string, directing execution to appropriate private methods.
 *     *   **Error Handling:**
 *         *   Input validation for priority string is done directly in `addTask` using `Priority.valueOf` within a `try-catch`.
 *         *   Input validation for the task ID string is done in `scheduleTask` using `Integer.parseInt` within a `try-catch` block in the `run` method, catching `NumberFormatException`.
 *         *   The main `run` method contains a `try-catch` block *inside* the `while(true)` loop. This block wraps the `switch` statement and the calls to the private command-handling methods (`addTask`, `scheduleTask`, etc.). This demonstrates handling exceptions (custom checked exceptions like `TaskNotFoundException`, `TaskOperationException`, as well as runtime exceptions like `IllegalArgumentException` and input parsing errors) that occur during command execution, allowing the loop to continue for the next command instead of crashing the application. Errors are reported using `System.err`.
 *         *   A `try-finally` block around the main `while(true)` loop ensures that the `Scanner` resource is closed when the application exits via the "exit" command's `return` statement.
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, demonstrating object-oriented design, collection management, and robust error handling.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 1. Priority Enum
enum Priority {
    HIGH, MEDIUM, LOW
}

// 2. TaskStatus Enum
enum TaskStatus {
    BACKLOG, READY, COMPLETED
}

// 3. Custom Exception for Task Operations
class TaskOperationException extends Exception {
    public TaskOperationException(String message) {
        super(message);
    }
}

// 4. Custom Exception for Task Not Found
class TaskNotFoundException extends TaskOperationException {
    public TaskNotFoundException(int taskId) {
        super("Task with ID " + taskId + " not found.");
    }
}

// 5. Task Class
class Task {
    private int id;
    private String name;
    private Priority priority;
    private TaskStatus status;

    public Task(int id, String name, Priority priority) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be null or empty.");
        }
        if (priority == null) {
            throw new IllegalArgumentException("Task priority cannot be null.");
        }
        this.id = id;
        this.name = name.trim();
        this.priority = priority;
        this.status = TaskStatus.BACKLOG; // Default status
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public Priority getPriority() { return priority; }
    public TaskStatus getStatus() { return status; }

    // Setter for status (controlled by TaskManager)
    void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Task [ID=%d, Name='%s', Priority=%s, Status=%s]",
                             id, name, priority, status);
    }
}

// 6. TaskManager Class
class TaskManager {
    private List<Task> backlog = new ArrayList<>(); // Use ArrayList for backlog
    private Queue<Task> readyQueue = new LinkedList<>(); // Use LinkedList implementing Queue for ready queue (FIFO)
    private List<Task> completedTasks = new ArrayList<>(); // Use ArrayList for completed tasks
    private int nextTaskId = 1; // Counter for unique task IDs

    /**
     * Adds a new task to the backlog.
     * @param name The name of the task.
     * @param priority The priority of the task.
     * @throws IllegalArgumentException if name or priority is invalid.
     */
    public void addTaskToBacklog(String name, Priority priority) {
        // Task constructor handles basic validation (name, priority not null/empty)
        Task newTask = new Task(nextTaskId++, name, priority);
        backlog.add(newTask);
        System.out.println("Added to backlog: " + newTask);
    }

    /**
     * Schedules a task from the backlog to the ready queue.
     * Finds the task by ID, removes it from backlog, updates status, and adds to ready queue.
     * @param taskId The ID of the task to schedule.
     * @throws TaskNotFoundException if the task ID does not exist in the backlog.
     * @throws TaskOperationException if the task is not in BACKLOG status.
     */
    public void scheduleTask(int taskId) throws TaskNotFoundException, TaskOperationException {
        Task taskToSchedule = findTaskInBacklog(taskId); // This method throws TaskNotFoundException

        if (taskToSchedule.getStatus() != TaskStatus.BACKLOG) {
            throw new TaskOperationException("Task " + taskId + " is not in BACKLOG status (Current status: " + taskToSchedule.getStatus() + ").");
        }

        // Remove from backlog using object reference
        boolean removed = backlog.remove(taskToSchedule);
        if (!removed) {
             // This case is unlikely if findTaskInBacklog succeeded, but good practice
             throw new TaskOperationException("Failed to remove task " + taskId + " from backlog during scheduling.");
        }

        taskToSchedule.setStatus(TaskStatus.READY);
        readyQueue.offer(taskToSchedule); // Add to the end of the queue (FIFO)
        System.out.println("Scheduled to ready queue: " + taskToSchedule);
    }

    /**
     * Executes the next task from the ready queue (FIFO).
     * Takes the task from the head, updates status, and moves it to completed tasks.
     * @throws TaskOperationException if the ready queue is empty.
     */
    public void executeNextTask() throws TaskOperationException {
        Task taskToExecute = readyQueue.poll(); // Get and remove the head of the queue

        if (taskToExecute == null) {
            throw new TaskOperationException("Ready queue is empty. No tasks to execute.");
        }

        taskToExecute.setStatus(TaskStatus.COMPLETED);
        completedTasks.add(taskToExecute);
        System.out.println("Executed and moved to completed: " + taskToExecute);
    }

    /**
     * Gets a copy of the list of tasks in the backlog.
     * @return A new ArrayList containing tasks from the backlog.
     */
    public List<Task> getBacklog() {
        return new ArrayList<>(backlog); // Return a copy for encapsulation
    }

     /**
     * Gets the queue of tasks ready for execution.
     * Note: Returning the actual Queue reference here for exam simplicity,
     * in production code, returning an unmodifiable view or iterating
     * and copying would be better for encapsulation.
     * @return The Queue of tasks ready for execution.
     */
    public Queue<Task> getReadyQueue() {
        return readyQueue; // Consider returning Collections.unmodifiableQueue(readyQueue)
    }

    /**
     * Gets a copy of the list of completed tasks.
     * @return A new ArrayList containing completed tasks.
     */
    public List<Task> getCompletedTasks() {
         return new ArrayList<>(completedTasks); // Return a copy for encapsulation
    }

    /**
     * Finds a task in the backlog by its ID. Private helper method.
     * @param taskId The ID of the task to find.
     * @return The Task object.
     * @throws TaskNotFoundException if the task is not found in the backlog.
     */
    private Task findTaskInBacklog(int taskId) throws TaskNotFoundException {
        for (Task task : backlog) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        throw new TaskNotFoundException(taskId);
    }
}

// 7. Main Application Class
class TaskApp {

    private TaskManager taskManager = new TaskManager();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TaskApp app = new TaskApp();
        app.run();
    }

    public void run() {
        printWelcomeMessage();

        // Class-wide or main loop exception handling using try-finally
        // to ensure scanner closure and try-catch inside the loop
        // to handle command-specific errors without crashing the app.
        try {
            while (true) {
                printMenu();
                System.out.print("Enter command: ");
                String command = scanner.nextLine().trim().toLowerCase();

                // try-catch block around the command processing logic
                // to catch specific exceptions thrown by TaskManager or input parsing
                try {
                    switch (command) {
                        case "add":
                            addTask();
                            break;
                        case "schedule":
                            scheduleTask();
                            break;
                        case "execute":
                            executeNextTask();
                            break;
                        case "list backlog":
                            listBacklog();
                            break;
                        case "list ready":
                            listReadyQueue();
                            break;
                        case "list completed":
                            listCompletedTasks();
                            break;
                        case "exit":
                            System.out.println("Exiting Task Management System. Goodbye!");
                            return; // Exit the run method
                        default:
                            System.err.println("Error: Unknown command. Please try again.");
                            break;
                    }
                } catch (InputMismatchException e) {
                     // Caught when Integer.parseInt fails or similar format issues
                     System.err.println("Input Error: Invalid format. " + e.getMessage());
                     // No need to consume line here as scanner.nextLine() is used everywhere
                } catch (NumberFormatException e) {
                     // Explicitly catch NumberFormatException from parseInt
                     System.err.println("Input Error: Invalid number format. Please enter a valid number.");
                } catch (IllegalArgumentException e) {
                     // Caught from Task constructor or invalid Priority enum value
                     System.err.println("Validation Error: " + e.getMessage());
                } catch (TaskNotFoundException e) {
                    // Caught when scheduleTask cannot find the task
                    System.err.println("Operation Error: " + e.getMessage());
                } catch (TaskOperationException e) {
                    // Caught for other task operation issues (e.g., wrong status, empty queue)
                    System.err.println("Operation Error: " + e.getMessage());
                } catch (Exception e) {
                    // Catch any other unexpected exceptions
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    e.printStackTrace(); // Print stack trace for debugging
                }
                System.out.println(); // Add a newline for better readability between commands
            }
        } finally {
            // Ensure scanner is closed when the application exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private void printWelcomeMessage() {
        System.out.println("--- Simple Task Management System ---");
    }

    private void printMenu() {
        System.out.println("Available commands:");
        System.out.println("  add          - Add a new task to the backlog");
        System.out.println("  schedule     - Move a task from backlog to ready queue by ID");
        System.out.println("  execute      - Execute the next task from the ready queue");
        System.out.println("  list backlog - List tasks in the backlog");
        System.out.println("  list ready   - List tasks in the ready queue");
        System.out.println("  list completed - List completed tasks");
        System.out.println("  exit         - Exit the application");
    }

    private void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
        String priorityStr = scanner.nextLine().trim().toUpperCase();
        Priority priority;
        try {
            priority = Priority.valueOf(priorityStr);
        } catch (IllegalArgumentException e) {
            // Catch error if Priority.valueOf fails
            System.err.println("Input Error: Invalid priority entered. Please use HIGH, MEDIUM, or LOW.");
            return; // Exit the method
        }

        // TaskManager.addTaskToBacklog might throw IllegalArgumentException (e.g., empty name)
        taskManager.addTaskToBacklog(name, priority);
    }

    // These methods declare the checked exceptions they might throw,
    // which are then caught in the main run loop's try-catch block.
    private void scheduleTask() throws TaskNotFoundException, TaskOperationException, NumberFormatException {
        System.out.print("Enter ID of task to schedule: ");
        String idStr = scanner.nextLine().trim();
        int taskId;
        // Validate input format before calling TaskManager
        taskId = Integer.parseInt(idStr); // Throws NumberFormatException if not a valid integer

        taskManager.scheduleTask(taskId); // This method throws checked exceptions
    }

    private void executeNextTask() throws TaskOperationException {
        taskManager.executeNextTask(); // This method throws checked exceptions
    }

    private void listBacklog() {
        List<Task> backlog = taskManager.getBacklog();
        System.out.println("--- Backlog Tasks ---");
        if (backlog.isEmpty()) {
            System.out.println("No tasks in backlog.");
        } else {
            for (Task task : backlog) {
                System.out.println(task);
            }
        }
        System.out.println("---------------------");
    }

    private void listReadyQueue() {
        Queue<Task> readyQueue = taskManager.getReadyQueue();
        System.out.println("--- Ready Queue Tasks ---");
        if (readyQueue.isEmpty()) {
            System.out.println("No tasks in ready queue.");
        } else {
             // Iterate through the queue for display without removing elements
             for (Task task : readyQueue) {
                 System.out.println(task);
             }
        }
         System.out.println("-------------------------");
    }

    private void listCompletedTasks() {
        List<Task> completedTasks = taskManager.getCompletedTasks();
        System.out.println("--- Completed Tasks ---");
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
