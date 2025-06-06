/*
 * Exam Question #493
 * Generated on: 2025-05-11 23:19:32
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Objective:** Design and implement a command-line based Task Management System that allows users to add, view, and process tasks with different priorities and statuses. The system should demonstrate proficiency in using core Java data structures, control flow, exception handling, and object-oriented principles.
 * 
 * **Scenario:** You are building a simple internal tool for a team to manage their work tasks. Tasks can have different priorities and move through different statuses. High-priority tasks are automatically added to a processing queue, but users can also manually add any task to this queue for immediate attention.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following attributes:
 *     *   `id` (int): Unique identifier for the task.
 *     *   `description` (String): A brief description of the task.
 *     *   `priority` (enum `TaskPriority`): Can be `HIGH`, `MEDIUM`, or `LOW`.
 *     *   `status` (enum `TaskStatus`): Can be `PENDING`, `IN_PROGRESS`, `COMPLETED`, `CANCELLED`.
 *     *   The `Task` class must follow proper encapsulation (private fields, public getters).
 *     *   Include a method to update the task's status.
 *     *   Override `toString()` to provide a clear representation of the task.
 * 
 * 2.  **Task Management Logic:** Create a `TaskManager` class that manages the collection of tasks and the processing queue.
 *     *   Maintain a `List` (specifically using `ArrayList`) to store *all* tasks created in the system.
 *     *   Maintain a `Queue` (specifically using `java.util.Queue`, e.g., `LinkedList` implementing `Queue`) for tasks waiting to be processed.
 *     *   Implement the following functionalities as public methods:
 *         *   `addTask(String description, TaskPriority priority)`: Creates a new `Task`, assigns a unique ID, adds it to the main list. If the priority is `HIGH`, also adds it to the processing queue.
 *         *   `viewAllTasks()`: Displays details of all tasks in the system.
 *         *   `viewProcessingQueue()`: Displays details of tasks currently in the processing queue.
 *         *   `processNextTask()`: Retrieves and removes the next task from the *processing queue*. If the queue is empty, report an error. If successful, update the status of the *processed task* in the main task list to `IN_PROGRESS` and report which task is being processed.
 *         *   `changeTaskStatus(int taskId, TaskStatus newStatus)`: Finds the task by ID in the main list and updates its status. If the task is not found, report an error.
 *         *   `addExistingTaskToQueue(int taskId)`: Finds the task by ID in the main list and adds it to the *end* of the processing queue, regardless of its priority. If the task is not found or is already in the queue, report an error.
 * 
 * 3.  **User Interface:** Create a `Main` class with a `main` method to provide a command-line interface.
 *     *   Use `java.util.Scanner` to read user input.
 *     *   Present a menu of options to the user:
 *         1.  Add New Task
 *         2.  View All Tasks
 *         3.  View Processing Queue
 *         4.  Process Next Task from Queue
 *         5.  Change Task Status
 *         6.  Add Existing Task to Queue
 *         0.  Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Implement input validation for task priority, status, and task ID. Handle cases where the user enters non-numeric input for menu choices or IDs.
 *     *   Use `System.out` for displaying the menu, task information, and success messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, task not found, queue empty).
 * 
 * 4.  **Exception Handling:** Implement class-wide exception handling using `try-catch` blocks in the `main` method to catch potential runtime errors during user input processing or operation execution. Specific operational errors (like queue empty or task not found) should ideally be handled within the `TaskManager` methods using `System.err` without necessarily throwing exceptions that need catching in `main`, but the `main` method's `try-catch` should act as a safety net for unexpected issues (like `NumberFormatException` from parsing input).
 * 
 * 5.  **Best Practices:**
 *     *   Employ meaningful variable and method names.
 *     *   Include appropriate comments and documentation (JavaDocs).
 *     *   Structure the code into logical classes.
 *     *   Ensure proper resource management (close the `Scanner`).
 * 
 * **Expected Output:**
 * 
 * The program should run interactively. Users select options from a menu. Output should clearly indicate the result of each operation (e.g., "Task added successfully", "Processing queue is empty", "Task with ID X not found"). Error messages should be distinct (using `System.err`).
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * --- Task Management System ---
 * 1. Add New Task
 * 2. View All Tasks
 * 3. View Processing Queue
 * 4. Process Next Task from Queue
 * 5. Change Task Status
 * 6. Add Existing Task to Queue
 * 0. Exit
 * Enter your choice: 1
 * Enter task description: Fix critical bug
 * Enter priority (HIGH, MEDIUM, LOW): HIGH
 * Task added successfully! (ID: 1)
 * 
 * --- Task Management System ---
 * ... menu ...
 * Enter your choice: 3
 * --- Processing Queue ---
 * [ID: 1, Description: Fix critical bug, Priority: HIGH, Status: PENDING]
 * 
 * --- Task Management System ---
 * ... menu ...
 * Enter your choice: 4
 * Processing task: ID: 1, Description: Fix critical bug, Priority: HIGH, Status: PENDING
 * Task ID 1 status updated to IN_PROGRESS.
 * 
 * --- Task Management System ---
 * ... menu ...
 * Enter your choice: 3
 * --- Processing Queue ---
 * (Queue is empty)
 * 
 * --- Task Management System ---
 * ... menu ...
 * Enter your choice: 4
 * Error: Processing queue is empty.
 * 
 * --- Task Management System ---
 * ... menu ...
 * Enter your choice: 5
 * Enter task ID to change status: 1
 * Enter new status (PENDING, IN_PROGRESS, COMPLETED, CANCELLED): COMPLETED
 * Task ID 1 status updated to COMPLETED.
 * 
 * --- Task Management System ---
 * ... menu ...
 * Enter your choice: 2
 * --- All Tasks ---
 * [ID: 1, Description: Fix critical bug, Priority: HIGH, Status: COMPLETED]
 * 
 * --- Task Management System ---
 * ... menu ...
 * Enter your choice: 0
 * Exiting Task Management System. Goodbye!
 * ```
 *
 * EXPLANATION:
 * The provided solution implements a command-line Task Management System demonstrating the required Java concepts.
 * 
 * 1.  **Task Class:** Represents a single task with `id`, `description`, `priority`, and `status`. It uses enums (`TaskPriority`, `TaskStatus`) for type safety and readability. Encapsulation is maintained with private fields and public getters. The `setStatus` method allows controlled modification of the status. `toString` provides a user-friendly representation. `equals` and `hashCode` are overridden based on the unique `id` to correctly check if a task object reference is present in the `processingQueue` using `contains()` and `remove()`.
 * 
 * 2.  **TaskManager Class:** This class is the core of the system logic.
 *     *   `allTasks`: A `List<Task>` is declared and initialized as an `ArrayList<Task>`. This list holds references to *all* tasks created in the system, serving as the primary storage.
 *     *   `processingQueue`: A `Queue<Task>` is declared and initialized as a `LinkedList<Task>`. `LinkedList` is chosen because it implements the `Queue` interface and provides efficient `offer()` (add to end) and `poll()` (remove from front) operations suitable for a processing queue. This queue holds references to tasks that are ready to be processed.
 *     *   `nextTaskId`: An integer counter ensures each new task gets a unique ID.
 *     *   `addTask()`: Creates a new `Task` object and adds it to `allTasks`. If the task's priority is `HIGH`, it's also added to the `processingQueue` using `offer()`.
 *     *   `viewAllTasks()`: Iterates through the `allTasks` list and prints each task's details.
 *     *   `viewProcessingQueue()`: Iterates through the `processingQueue` and prints each task's details *without* removing them.
 *     *   `processNextTask()`: Uses `processingQueue.poll()` to get and remove the task at the head of the queue. It checks if the result is `null` (queue was empty) and reports an error using `System.err`. If a task is retrieved, it finds the *same task object* in the `allTasks` list (since both the list and queue hold references to the same objects) and updates its status to `IN_PROGRESS`.
 *     *   `changeTaskStatus()`: Finds the task by ID in `allTasks` using the helper method `findTaskById`. If found, it updates the task's status. It also includes logic to remove the task from the `processingQueue` if its status changes to `COMPLETED` or `CANCELLED`, ensuring the queue doesn't hold finished tasks.
 *     *   `addExistingTaskToQueue()`: Finds the task by ID in `allTasks`. If found and not already in the queue (checked using `processingQueue.contains()`), it adds the task to the end of the queue using `offer()`. Errors are reported via `System.err` if the task isn't found or is already queued.
 *     *   `findTaskById()`: A private helper method demonstrating encapsulation, used internally by `TaskManager` methods to locate tasks in the `allTasks` list.
 * 
 * 3.  **Main Class (TaskManagementSystem):**
 *     *   The `main` method sets up the `Scanner` for input and creates a `TaskManager` instance.
 *     *   A `while(true)` loop runs the main application until the user chooses to exit.
 *     *   Inside the loop, `printMenu()` displays the options.
 *     *   User input is read using `scanner.nextLine()`.
 *     *   A `try-catch` block surrounds the core logic within the loop. This provides class-wide exception handling, catching potential `NumberFormatException` if the user enters non-numeric input for the main menu choice, or other unexpected runtime exceptions.
 *     *   The parsed integer choice is used in a `switch` statement to direct the program flow to the appropriate `TaskManager` method or the exit logic.
 *     *   Input validation for priority and status strings is done by attempting to use `TaskPriority.valueOf()` and `TaskStatus.valueOf()`. If this fails (due to an invalid string), an `IllegalArgumentException` is caught, and an error message is printed using `System.err`.
 *     *   Input validation for task IDs is done by attempting to parse the input string to an integer using `Integer.parseInt()`. A `NumberFormatException` is caught if the input is not a valid number, and an error message is printed using `System.err`.
 *     *   `System.out` is used for normal informational output (menu, task details, success messages).
 *     *   `System.err` is used specifically for error messages, making them distinct in the output.
 *     *   The `Scanner` is closed before the program exits to release system resources, demonstrating proper resource management.
 * 
 * 4.  **Required Components Usage:**
 *     *   `Queue`: Used for `processingQueue` (`LinkedList` implements `Queue`). `offer()`, `poll()`, `contains()` methods are used.
 *     *   `ArrayList`: Used for `allTasks`.
 *     *   `List interface`: `allTasks` is declared as `List<Task>`.
 *     *   `Scanner`: Used in `main` to read user input from `System.in`.
 *     *   `Switch statement`: Used in `main` to handle menu choices.
 *     *   `System.err`: Used throughout for reporting errors.
 *     *   `System.out`: Used throughout for normal output.
 *     *   Class-wide exception handling: The main `try-catch` block in `main` covers the core operation loop. Specific input parsing errors (`NumberFormatException`, `IllegalArgumentException`) are handled within the `try` block's specific operations.
 * 
 * 5.  **Best Practices:** The code is structured into three logical classes (`Task`, `TaskManager`, `TaskManagementSystem`). Fields are private, methods are public where necessary, and helper methods (`findTaskById`, `printMenu`) are private. Variable and method names are descriptive. Basic JavaDocs and comments are included. Input validation and error handling are implemented for expected issues (invalid input, task not found, queue empty) and a general `try-catch` is present for unexpected errors.
 * 
 * This solution effectively combines the required Java components within a practical scenario, demonstrating advanced understanding of data structures, object-oriented design, control flow, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator; // Added for checking if task is in queue

// Enum for Task Priority
enum TaskPriority {
    HIGH, MEDIUM, LOW
}

// Enum for Task Status
enum TaskStatus {
    PENDING, IN_PROGRESS, COMPLETED, CANCELLED
}

// Represents a single task
class Task {
    private int id;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;

    /**
     * Constructs a new Task.
     * @param id The unique identifier for the task.
     * @param description The description of the task.
     * @param priority The priority of the task.
     */
    public Task(int id, String description, TaskPriority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING; // Default status
    }

    // --- Getters ---
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

    /**
     * Updates the status of the task.
     * @param status The new status for the task.
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Description: " + description +
               ", Priority: " + priority + ", Status: " + status + "]";
    }

    // Added equals and hashCode for checking if a task is in the queue
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

// Manages the collection of tasks and the processing queue
class TaskManager {
    // Using List interface and ArrayList implementation
    private List<Task> allTasks = new ArrayList<>();
    // Using Queue interface and LinkedList implementation
    private Queue<Task> processingQueue = new LinkedList<>();
    private int nextTaskId = 1; // Counter for unique task IDs

    /**
     * Adds a new task to the system.
     * High priority tasks are also added to the processing queue.
     * @param description The description of the task.
     * @param priority The priority of the task.
     */
    public void addTask(String description, TaskPriority priority) {
        Task newTask = new Task(nextTaskId++, description, priority);
        allTasks.add(newTask);
        if (priority == TaskPriority.HIGH) {
            processingQueue.offer(newTask); // offer is safer than add for capacity-constrained queues, but fine here
            System.out.println("Task added successfully! (ID: " + newTask.getId() + ") - Also added to processing queue.");
        } else {
            System.out.println("Task added successfully! (ID: " + newTask.getId() + ")");
        }
    }

    /**
     * Displays all tasks in the system.
     */
    public void viewAllTasks() {
        System.out.println("--- All Tasks ---");
        if (allTasks.isEmpty()) {
            System.out.println("(No tasks in the system)");
        } else {
            for (Task task : allTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Displays tasks currently in the processing queue.
     */
    public void viewProcessingQueue() {
        System.out.println("--- Processing Queue ---");
        if (processingQueue.isEmpty()) {
            System.out.println("(Queue is empty)");
        } else {
            // Iterate without removing elements
            for (Task task : processingQueue) {
                System.out.println(task);
            }
        }
    }

    /**
     * Processes the next task from the processing queue.
     * Updates the task's status in the main list.
     */
    public void processNextTask() {
        Task taskToProcess = processingQueue.poll(); // Retrieves and removes the head of the queue
        if (taskToProcess == null) {
            System.err.println("Error: Processing queue is empty. Nothing to process.");
        } else {
            System.out.println("Processing task: " + taskToProcess);
            // Find the task in the main list and update its status
            Task taskInAllTasks = findTaskById(taskToProcess.getId());
            if (taskInAllTasks != null) {
                taskInAllTasks.setStatus(TaskStatus.IN_PROGRESS);
                System.out.println("Task ID " + taskToProcess.getId() + " status updated to " + TaskStatus.IN_PROGRESS + ".");
            } else {
                // This case should ideally not happen if logic is correct, but good for robustness
                System.err.println("Error: Processed task ID " + taskToProcess.getId() + " not found in the main task list.");
            }
        }
    }

    /**
     * Changes the status of a task by its ID.
     * @param taskId The ID of the task to update.
     * @param newStatus The new status for the task.
     */
    public void changeTaskStatus(int taskId, TaskStatus newStatus) {
        Task task = findTaskById(taskId);
        if (task == null) {
            System.err.println("Error: Task with ID " + taskId + " not found.");
        } else {
            task.setStatus(newStatus);
            System.out.println("Task ID " + taskId + " status updated to " + newStatus + ".");
            // Optional: If task was in queue and status is COMPLETED/CANCELLED, remove from queue
            if ((newStatus == TaskStatus.COMPLETED || newStatus == TaskStatus.CANCELLED) && processingQueue.contains(task)) {
                 processingQueue.remove(task);
                 System.out.println("Task ID " + taskId + " removed from processing queue due to status change.");
            }
        }
    }

    /**
     * Adds an existing task to the processing queue by its ID.
     * @param taskId The ID of the task to add to the queue.
     */
    public void addExistingTaskToQueue(int taskId) {
        Task task = findTaskById(taskId);
        if (task == null) {
            System.err.println("Error: Task with ID " + taskId + " not found.");
        } else {
            // Check if the task is already in the queue
            if (processingQueue.contains(task)) { // Requires Task.equals() and hashCode() based on ID
                 System.err.println("Error: Task with ID " + taskId + " is already in the processing queue.");
            } else {
                 processingQueue.offer(task);
                 System.out.println("Task ID " + taskId + " added to the processing queue.");
            }
        }
    }

    /**
     * Helper method to find a task by its ID in the main list.
     * @param taskId The ID to search for.
     * @return The Task object if found, otherwise null.
     */
    private Task findTaskById(int taskId) {
        for (Task task : allTasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null; // Task not found
    }
}

// Main class for the command-line interface
public class TaskManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        System.out.println("--- Task Management System ---");

        while (true) {
            printMenu();

            try {
                System.out.print("Enter your choice: ");
                String choiceString = scanner.nextLine();
                int choice = Integer.parseInt(choiceString);

                // Using switch statement for flow control
                switch (choice) {
                    case 1: // Add New Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                        String priorityString = scanner.nextLine().toUpperCase();
                        try {
                            TaskPriority priority = TaskPriority.valueOf(priorityString);
                            taskManager.addTask(description, priority);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error: Invalid priority entered. Please use HIGH, MEDIUM, or LOW.");
                        }
                        break;

                    case 2: // View All Tasks
                        taskManager.viewAllTasks();
                        break;

                    case 3: // View Processing Queue
                        taskManager.viewProcessingQueue();
                        break;

                    case 4: // Process Next Task from Queue
                        taskManager.processNextTask();
                        break;

                    case 5: // Change Task Status
                        System.out.print("Enter task ID to change status: ");
                        String idString = scanner.nextLine();
                        try {
                            int taskId = Integer.parseInt(idString);
                            System.out.print("Enter new status (PENDING, IN_PROGRESS, COMPLETED, CANCELLED): ");
                            String statusString = scanner.nextLine().toUpperCase();
                            try {
                                TaskStatus newStatus = TaskStatus.valueOf(statusString);
                                taskManager.changeTaskStatus(taskId, newStatus);
                            } catch (IllegalArgumentException e) {
                                System.err.println("Error: Invalid status entered. Please use PENDING, IN_PROGRESS, COMPLETED, or CANCELLED.");
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid task ID. Please enter a number.");
                        }
                        break;

                    case 6: // Add Existing Task to Queue
                        System.out.print("Enter task ID to add to processing queue: ");
                        String queueIdString = scanner.nextLine();
                        try {
                            int taskId = Integer.parseInt(queueIdString);
                            taskManager.addExistingTaskToQueue(taskId);
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid task ID. Please enter a number.");
                        }
                        break;

                    case 0: // Exit
                        System.out.println("Exiting Task Management System. Goodbye!");
                        scanner.close(); // Proper resource management
                        return; // Exit the main method and program

                    default: // Invalid choice
                        System.err.println("Error: Invalid choice. Please enter a number between 0 and 6.");
                        break;
                }

            } catch (NumberFormatException e) {
                // Catching errors if user enters non-integer for the main menu choice
                System.err.println("Error: Invalid input. Please enter a number for your choice.");
            } catch (Exception e) {
                // Catching any other unexpected errors
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging if needed
            }
            System.out.println(); // Add a newline for better readability between operations
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Task Management System Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. View Processing Queue");
        System.out.println("4. Process Next Task from Queue");
        System.out.println("5. Change Task Status");
        System.out.println("6. Add Existing Task to Queue");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------");
    }
}
