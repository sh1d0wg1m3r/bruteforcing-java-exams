/*
 * Exam Question #742
 * Generated on: 2025-05-12 16:34:15
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Problem Description:**
 * 
 * You are required to develop a simple command-line based Task Management System for a small development team. This system will allow users to manage tasks through a text-based interface. The system should prioritize tasks and track their status through different stages.
 * 
 * Each task in the system must have the following attributes:
 * - A unique integer ID (assigned automatically by the system).
 * - A name (String).
 * - A description (String).
 * - A priority (HIGH, MEDIUM, or LOW).
 * - A status (PENDING, IN_PROGRESS, or COMPLETED).
 * 
 * The system should support the following operations:
 * 1.  **Add New Task:** Create a new task with a name, description, and priority. Newly added tasks are always in the `PENDING` status.
 * 2.  **Pick Up Next Pending Task:** Retrieve the pending task with the highest priority. If multiple tasks have the same highest priority, any one of them can be picked up. The status of the picked-up task changes to `IN_PROGRESS`.
 * 3.  **Complete Task:** Mark a specific task (identified by its ID) as `COMPLETED`. This operation is only valid if the task is currently in the `IN_PROGRESS` status.
 * 4.  **List Tasks:** Display tasks based on their status (All, Pending, In Progress, Completed).
 * 
 * Your solution must strictly adhere to the following technical requirements and demonstrate best practices:
 * 
 * **Required Java Components:**
 * -   `java.util.Queue`: Must be used to manage the tasks that are in the `PENDING` state, ensuring tasks are processed based on priority. `java.util.PriorityQueue` is a suitable implementation that fulfills the priority requirement and the `Queue` interface requirement.
 * -   `java.util.ArrayList`: Must be used to maintain a comprehensive list of all tasks created in the system, regardless of their status.
 * -   `java.util.List` interface: Must be used as a type declaration for variables or method return types where appropriate, particularly when working with collections of tasks returned from listing operations.
 * -   `java.util.Scanner`: Must be used to read user input from the console (`System.in`) for menu choices and task details.
 * -   `switch` statement: Must be used to control the program flow based on the user's menu selection.
 * -   `System.err`: Must be used exclusively for printing error messages (e.g., invalid input, operation failures).
 * -   `System.out`: Must be used for all normal output (menu display, prompts, success messages, task listings).
 * -   Class-wide exception handling with `try-catch` blocks: Implement exception handling to manage potential runtime errors, especially around user input processing (`Scanner`). Use `try-catch` blocks to gracefully handle errors and prevent the program from crashing.
 * 
 * **Best Practices:**
 * -   **Encapsulation:** Design classes with private fields and public methods (getters, setters where necessary).
 * -   **Meaningful Names:** Use descriptive names for classes, variables, methods, and enums.
 * -   **Comments and Documentation:** Include comments to explain complex logic and Javadoc for class and method descriptions.
 * -   **Input Validation:** Validate user input to ensure it is in the expected format and within acceptable ranges (e.g., valid menu choice, valid priority string, valid task ID).
 * -   **Proper Error Handling:** Implement checks before performing operations (e.g., checking if a task exists, checking task status before completing) and use `System.err` for reporting failures.
 * -   **Clean Code Structure:** Organize the code into logical classes and methods.
 * 
 * **User Interface:**
 * 
 * The program should display a menu upon startup and after each operation (unless exiting):
 * 
 * ```
 * Task Management System
 * ------------------------
 * 1. Add New Task
 * 2. Pick Up Next Pending Task
 * 3. Complete Task
 * 4. List All Tasks
 * 5. List Pending Tasks
 * 6. List In Progress Tasks
 * 7. List Completed Tasks
 * 8. Exit
 * Enter your choice:
 * ```
 * 
 * The program should then prompt for necessary details based on the user's choice.
 * 
 * **Expected Output:**
 * 
 * -   Successful operations should print informative messages to `System.out`.
 * -   Listing operations should print the details of the relevant tasks to `System.out`. If no tasks match, print a message indicating that.
 * -   Invalid inputs or failed operations (e.g., trying to complete a non-existent task, picking up from an empty queue) must print clear error messages to `System.err`.
 * 
 * Your solution should be provided as a single block of Java code.
 *
 * EXPLANATION:
 * This solution implements a simple command-line Task Management System using the required Java components and best practices.
 * 
 * **Design Overview:**
 * The system is structured into several classes and enums for clarity and organization:
 * 1.  `TaskStatus` and `TaskPriority` enums: Define the possible states and priority levels for tasks, making the code more readable and preventing invalid values. `TaskPriority` includes a level for comparison logic.
 * 2.  `Task` class: Represents a single task with its attributes (ID, name, description, priority, status). It follows encapsulation principles with private fields and public getters. It implements `Comparable<Task>` to allow `PriorityQueue` to order tasks based on priority, and overrides `equals`/`hashCode` based on the unique ID.
 * 3.  `TaskManager` class: Acts as the core logic handler. It manages the collections of tasks (`pendingTasksQueue` and `allTasksList`) and provides methods for the main task operations (add, pickup, complete, list). This class encapsulates the data management logic.
 * 4.  `TaskApp` class: Contains the `main` method and handles the user interface. It sets up the `Scanner` and `TaskManager`, runs the main application loop, displays the menu, reads user input, and calls the appropriate `TaskManager` methods based on the user's choice.
 * 
 * **Required Components Usage:**
 * -   `java.util.Queue`: The `pendingTasksQueue` in `TaskManager` is declared as a `Queue` interface type and instantiated as a `PriorityQueue`. `PriorityQueue` automatically orders elements based on their natural ordering (defined by `Task.compareTo`), ensuring that the highest priority tasks are retrieved first when using `poll()`.
 * -   `java.util.ArrayList`: The `allTasksList` in `TaskManager` is instantiated as an `ArrayList`. This list serves as a comprehensive record of all tasks ever created, allowing lookup by ID and iteration for listing operations. The `listTasks` method also uses `ArrayList` to create and return filtered lists of tasks.
 * -   `java.util.List` interface: The `allTasksList` is declared as a `List<Task>`. The `TaskManager.listTasks` method returns `List<Task>`, and the `TaskApp.listTasks` method receives and uses this `List` interface type. This demonstrates programming to the interface.
 * -   `java.util.Scanner`: An instance of `Scanner` is used in the `TaskApp` class (`scanner` field) to read input from `System.in` for menu choices and task details.
 * -   `switch` statement: The main application loop in `TaskApp.run()` uses a `switch` statement on the integer `choice` read from the user to dispatch control to the appropriate handler method (e.g., `addTask`, `pickupTask`).
 * -   `System.err`: Used in `TaskManager.completeTask` to report specific failure reasons (task not found, wrong status) and in `TaskApp.run` and `TaskApp.completeTask` to report input validation errors (`InputMismatchException`) and other unexpected exceptions. `System.err` is reserved strictly for error messages.
 * -   `System.out`: Used for all standard output, including printing the menu, prompts for input, success messages (task added, task picked up, task completed), and the formatted details of tasks when listing.
 * -   `try-catch` blocks: A `try-catch` block is wrapped around the core logic within the main application loop in `TaskApp.run()` to catch potential `InputMismatchException` (if the user enters non-integer input for the menu choice) and a general `Exception` for any other unforeseen errors. Another `try-catch` is used specifically in `TaskApp.completeTask` to handle `InputMismatchException` when reading the task ID. This provides robust, class-wide exception handling for the interactive part of the application.
 * 
 * **Best Practices Implementation:**
 * -   **Encapsulation:** Fields in `Task` and `TaskManager` are private, with controlled access via public methods.
 * -   **Meaningful Names:** Names like `pendingTasksQueue`, `allTasksList`, `addTask`, `pickupTask`, `TaskPriority.HIGH`, `TaskStatus.IN_PROGRESS` are descriptive and indicate their purpose.
 * -   **Comments and Documentation:** Javadoc comments explain the purpose of classes and methods, and inline comments clarify specific logic points (e.g., `compareTo` logic, Scanner newline consumption).
 * -   **Input Validation:** The code checks if the menu choice is within the valid range (1-8), uses `TaskPriority.fromString` to validate the priority input string, and uses `try-catch` to handle cases where integer input is expected but non-integer is provided (`InputMismatchException`).
 * -   **Proper Error Handling:** Specific checks are performed in `TaskManager.completeTask` *before* attempting to complete a task to ensure it exists and is in the correct status. These specific errors are reported via `System.err`. `System.err` is also used for input validation errors caught by `try-catch`.
 * -   **Clean Code Structure:** The logic is separated into distinct classes and methods, making the code modular and easier to understand and maintain. The main application logic in `TaskApp` focuses on UI and delegation, while `TaskManager` handles the data and business rules.
 * 
 * This solution effectively integrates the required Java components into a practical scenario, demonstrating key concepts like data structure selection, object-oriented design, input/output handling, control flow, and robust error management, making it suitable for a challenging exam task.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Objects;

// Enum for Task Status
enum TaskStatus {
    PENDING, IN_PROGRESS, COMPLETED
}

// Enum for Task Priority
enum TaskPriority {
    HIGH(3), MEDIUM(2), LOW(1);

    private final int level;

    TaskPriority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    /**
     * Converts a string to a TaskPriority enum, ignoring case.
     * @param text The string to convert.
     * @return The corresponding TaskPriority enum, or null if not found.
     */
    public static TaskPriority fromString(String text) {
        if (text == null) return null;
        for (TaskPriority p : TaskPriority.values()) {
            if (p.name().equalsIgnoreCase(text)) {
                return p;
            }
        }
        return null;
    }
}

// Represents a single Task
class Task implements Comparable<Task> {
    private int id;
    private String name;
    private String description;
    private TaskPriority priority;
    private TaskStatus status;

    /**
     * Constructs a new Task.
     * @param id Unique task ID.
     * @param name Task name.
     * @param description Task description.
     * @param priority Task priority.
     */
    public Task(int id, String name, String description, TaskPriority priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING; // New tasks start as PENDING
    }

    // Getters for task attributes
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public TaskPriority getPriority() { return priority; }
    public TaskStatus getStatus() { return status; }

    /**
     * Sets the status of the task.
     * @param status The new status.
     */
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Priority: %s, Status: %s",
                             id, name, priority, status);
    }

    /**
     * Compares tasks based on priority level for use in PriorityQueue.
     * Higher priority tasks (higher level) come first (return negative).
     * @param other The task to compare against.
     * @return A negative integer, zero, or a positive integer as this task
     *         is higher priority than, equal to, or lower priority than the specified task.
     */
    @Override
    public int compareTo(Task other) {
        // Compare in reverse order of level to get highest priority first
        return Integer.compare(other.priority.level, this.priority.level);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id; // Tasks are considered equal if their IDs match
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// Manages the collection of tasks
class TaskManager {
    // Queue for tasks that are currently PENDING, ordered by priority
    private Queue<Task> pendingTasksQueue;
    // List to hold all tasks created in the system
    private List<Task> allTasksList;
    // Counter to generate unique task IDs
    private int nextTaskId;

    /**
     * Constructs a new TaskManager.
     */
    public TaskManager() {
        // PriorityQueue uses the Task class's compareTo method
        this.pendingTasksQueue = new PriorityQueue<>();
        this.allTasksList = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the system.
     * It is added to the comprehensive list and the pending queue.
     * @param name Task name.
     * @param description Task description.
     * @param priority Task priority.
     * @return The newly created Task object.
     */
    public Task addTask(String name, String description, TaskPriority priority) {
        int taskId = nextTaskId++;
        Task newTask = new Task(taskId, name, description, priority);
        allTasksList.add(newTask); // Add to the list of all tasks
        pendingTasksQueue.offer(newTask); // Add to the pending queue
        return newTask;
    }

    /**
     * Retrieves and removes the highest priority task from the pending queue.
     * If successful, the task's status is updated to IN_PROGRESS.
     * @return The Task object that was picked up, or null if the pending queue is empty.
     */
    public Task pickupTask() {
        Task task = pendingTasksQueue.poll(); // Get and remove the head (highest priority)
        if (task != null) {
            // Update the status of the task object retrieved from the queue.
            // Since the object in allTasksList is the same instance, its status is also updated.
            task.setStatus(TaskStatus.IN_PROGRESS);
        }
        return task;
    }

    /**
     * Marks a task as COMPLETED if it exists and is in the IN_PROGRESS status.
     * @param taskId The ID of the task to complete.
     * @return true if the task was successfully completed, false otherwise.
     *         Error messages are printed to System.err by this method.
     */
    public boolean completeTask(int taskId) {
        // Find the task in the list of all tasks
        Task taskToComplete = findTaskById(taskId);

        if (taskToComplete == null) {
            System.err.println("Error: Task with ID " + taskId + " not found.");
            return false;
        }

        if (taskToComplete.getStatus() != TaskStatus.IN_PROGRESS) {
            System.err.println("Error: Task with ID " + taskId + " is not IN_PROGRESS (Status: " + taskToComplete.getStatus() + ").");
            return false;
        }

        // Update status to COMPLETED
        taskToComplete.setStatus(TaskStatus.COMPLETED);
        return true;
    }

    /**
     * Finds a task by its ID in the allTasksList.
     * @param taskId The ID to search for.
     * @return The Task object if found, null otherwise.
     */
    private Task findTaskById(int taskId) {
        for (Task task : allTasksList) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    /**
     * Returns a list of tasks filtered by status.
     * @param statusFilter The status to filter by, or null to return all tasks.
     * @return A List of Task objects matching the filter. Returns an empty list if none match.
     */
    public List<Task> listTasks(TaskStatus statusFilter) {
        // Use ArrayList to create a new list implementing the List interface
        List<Task> filteredList = new ArrayList<>();
        if (statusFilter == null) {
            // Add all tasks if no filter is specified
            filteredList.addAll(allTasksList);
        } else {
            // Iterate and add tasks matching the status filter
            for (Task task : allTasksList) {
                if (task.getStatus() == statusFilter) {
                    filteredList.add(task);
                }
            }
        }
        return filteredList; // Return the list
    }
}

// Main application class handling user interaction
public class TaskApp {

    private TaskManager taskManager;
    private Scanner scanner;

    /**
     * Constructs the TaskApp, initializing TaskManager and Scanner.
     */
    public TaskApp() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
    }

    /**
     * Runs the main application loop, displaying the menu and processing user commands.
     * Includes class-wide try-catch for general exception handling.
     */
    public void run() {
        System.out.println("Task Management System");
        System.out.println("------------------------");

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                switch (choice) {
                    case 1: // Add New Task
                        addTask();
                        break;
                    case 2: // Pick Up Next Pending Task
                        pickupTask();
                        break;
                    case 3: // Complete Task
                        completeTask();
                        break;
                    case 4: // List All Tasks
                        listTasks(null); // null filter lists all tasks
                        break;
                    case 5: // List Pending Tasks
                        listTasks(TaskStatus.PENDING);
                        break;
                    case 6: // List In Progress Tasks
                        listTasks(TaskStatus.IN_PROGRESS);
                        break;
                    case 7: // List Completed Tasks
                        listTasks(TaskStatus.COMPLETED);
                        break;
                    case 8: // Exit
                        running = false;
                        System.out.println("Exiting Task Management System.");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 8.");
                }
            } catch (InputMismatchException e) {
                // Handles cases where non-integer input is given for the menu choice
                System.err.println("Error: Invalid input. Please enter a number for your choice.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions during the loop execution
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging if needed
            }
            System.out.println(); // Add a blank line for better readability between operations
        }

        scanner.close(); // Close the scanner when the application exits
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("1. Add New Task");
        System.out.println("2. Pick Up Next Pending Task");
        System.out.println("3. Complete Task");
        System.out.println("4. List All Tasks");
        System.out.println("5. List Pending Tasks");
        System.out.println("6. List In Progress Tasks");
        System.out.println("7. List Completed Tasks");
        System.out.println("8. Exit");
    }

    /**
     * Handles the user interaction for adding a new task.
     * Prompts for name, description, and priority. Validates priority input.
     */
    private void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
        String priorityString = scanner.nextLine();

        TaskPriority priority = TaskPriority.fromString(priorityString);

        if (priority == null) {
            System.err.println("Error: Invalid priority. Please enter HIGH, MEDIUM, or LOW.");
            return; // Stop the add operation if priority is invalid
        }

        Task newTask = taskManager.addTask(name, description, priority);
        System.out.println("Task added with ID: " + newTask.getId());
    }

    /**
     * Handles the user interaction for picking up the next pending task.
     */
    private void pickupTask() {
        Task task = taskManager.pickupTask();
        if (task != null) {
            System.out.println("Picked up task: " + task);
        } else {
            System.out.println("No pending tasks to pick up.");
        }
    }

    /**
     * Handles the user interaction for completing a task.
     * Prompts for task ID and validates input format.
     */
    private void completeTask() {
        System.out.print("Enter task ID to complete: ");
        try {
            int taskId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // TaskManager.completeTask prints specific error messages if validation fails
            boolean success = taskManager.completeTask(taskId);
            if (success) {
                System.out.println("Task ID " + taskId + " marked as COMPLETED.");
            }
        } catch (InputMismatchException e) {
            // Handles cases where non-integer input is given for the task ID
            System.err.println("Error: Invalid input. Please enter a number for the task ID.");
            scanner.nextLine(); // Consume the invalid input
        }
    }

    /**
     * Handles the user interaction for listing tasks.
     * Calls TaskManager to get the list based on filter and prints them.
     * @param statusFilter The status to filter by, or null for all tasks.
     */
    private void listTasks(TaskStatus statusFilter) {
        // Call TaskManager method which returns a List
        List<Task> tasksToList = taskManager.listTasks(statusFilter);

        String title = "--- ";
        if (statusFilter == null) title += "All Tasks";
        else title += statusFilter.name() + " Tasks";
        title += " ---";
        System.out.println(title);

        if (tasksToList.isEmpty()) {
            System.out.println("(No tasks found)");
        } else {
            for (Task task : tasksToList) {
                System.out.println(task);
            }
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskApp app = new TaskApp();
        app.run();
    }
}
