/*
 * Exam Question #1015
 * Generated on: 2025-05-12 17:13:07
 * Generated by: Account 1
 * 
 * QUESTION:
 * **Subject:** Advanced Java Programming
 * **Task:** Implement a Priority Task Management System
 * 
 * **Scenario:**
 * You are tasked with building a simple command-line application for managing tasks based on priority. The system should allow users to add tasks with a description and priority level, process the next task based on its priority, view pending tasks, and view completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following attributes:
 *     *   A unique integer ID (automatically generated or assigned sequentially).
 *     *   A `String` description.
 *     *   A priority level (e.g., HIGH, MEDIUM, LOW). Use an `enum` for priority.
 *     *   A status (e.g., PENDING, COMPLETED). Use an `enum` for status.
 *     *   Implement the `Comparable` interface for the `Task` class to allow sorting/ordering based on priority (HIGH > MEDIUM > LOW). Tasks with the same priority can be ordered by ID (earlier ID comes first).
 *     *   Provide appropriate constructors, getters, and a `toString()` method for easy display.
 * 
 * 2.  **Task Management System:** Create a `TaskManager` class that manages the tasks.
 *     *   It should hold pending tasks in a queue that processes based on priority.
 *     *   It should hold completed tasks in a list.
 *     *   Use a `Scanner` to interact with the user via the console.
 *     *   Implement the following functionalities via a menu-driven interface:
 *         *   **Add New Task:** Prompt the user for task description and priority. Create a `Task` object and add it to the pending tasks queue. Validate user input for priority.
 *         *   **Process Next Task:** Remove the highest-priority task from the pending queue, update its status to COMPLETED, and move it to the completed tasks list. Handle the case where the queue is empty.
 *         *   **View Pending Tasks:** Display all tasks currently in the pending queue, ordered by priority (highest first).
 *         *   **View Completed Tasks:** Display all tasks in the completed tasks list.
 *         *   **Exit:** Terminate the program.
 * 
 * 3.  **Java Component Usage:** Your solution MUST explicitly use ALL of the following Java components:
 *     *   `java.util.Queue` (specifically `java.util.PriorityQueue` is recommended for priority-based processing)
 *     *   `java.util.ArrayList`
 *     *   `java.util.List` interface (use `List` as the type for completed tasks)
 *     *   `java.util.Scanner`
 *     *   `switch` statement (for the main menu)
 *     *   `System.err` (for displaying error messages)
 *     *   `System.out` (for displaying menu, prompts, and normal output)
 *     *   Class-wide exception handling with `try-catch` blocks (wrap the main execution loop or critical operations in a `try-catch`).
 * 
 * 4.  **Best Practices:**
 *     *   Use proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Implement robust input validation (e.g., handling non-integer menu input, invalid priority input, empty description).
 *     *   Implement proper error handling (e.g., attempting to process from an empty queue).
 *     *   Ensure clean code structure.
 * 
 * **Execution:**
 * The program should start by displaying a menu. The user selects an option by entering a number. The program performs the requested action and then displays the menu again until the user chooses to exit.
 * 
 * **Example Interaction (Illustrative):**
 * 
 * ```
 * --- Task Management System ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Finish report
 * Enter priority (HIGH, MEDIUM, LOW): HIGH
 * Task added successfully!
 * 
 * --- Task Management System ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Schedule meeting
 * Enter priority (HIGH, MEDIUM, LOW): MEDIUM
 * Task added successfully!
 * 
 * --- Task Management System ---
 * ...
 * Enter your choice: 3
 * --- Pending Tasks ---
 * [Task #1] HIGH: Finish report (PENDING)
 * [Task #2] MEDIUM: Schedule meeting (PENDING)
 * 
 * --- Task Management System ---
 * ...
 * Enter your choice: 2
 * Processing task: [Task #1] HIGH: Finish report (PENDING)
 * Task processed and completed!
 * 
 * --- Task Management System ---
 * ...
 * Enter your choice: 4
 * --- Completed Tasks ---
 * [Task #1] HIGH: Finish report (COMPLETED)
 * 
 * --- Task Management System ---
 * ...
 * Enter your choice: 5
 * Exiting Task Management System.
 * ```
 * 
 * Your solution should be provided as a single `.java` file containing all necessary classes and the `main` method.
 *
 * EXPLANATION:
 * This solution implements a simple priority-based task management system using the specified Java components.
 * 
 * **Key Components and Concepts Demonstrated:**
 * 
 * 1.  **`java.util.Queue` (`PriorityQueue`)**: The `pendingTasks` variable is declared as a `Queue` and instantiated as a `PriorityQueue`. `PriorityQueue` is a specific implementation of `Queue` that orders elements according to their natural ordering (defined by the `compareTo` method) or by a `Comparator`. In this case, `Task` implements `Comparable`, making `PriorityQueue` automatically manage the tasks based on priority, ensuring that `poll()` always retrieves the highest-priority task.
 * 2.  **`java.util.ArrayList`**: The `completedTasks` variable is instantiated as an `ArrayList`. `ArrayList` is used as a dynamic array to store completed tasks. It provides efficient random access and allows tasks to be added sequentially as they are completed.
 * 3.  **`java.util.List` interface**: The `completedTasks` variable is declared using the `List` interface (`List<Task> completedTasks = new ArrayList<>();`). This demonstrates programming to interfaces, which is a best practice promoting flexibility and allowing easy switching to other `List` implementations if needed.
 * 4.  **`java.util.Scanner`**: A `Scanner` object is used to read user input from `System.in` for menu choices, task descriptions, and priorities. Input validation is performed to handle cases like non-integer input or invalid priority strings.
 * 5.  **`switch` statement**: A `switch` statement is used in the `run()` method to control the program flow based on the user's menu choice, directing execution to the appropriate method (`addTask`, `processNextTask`, etc.).
 * 6.  **`System.err`**: `System.err.println()` is used specifically for displaying error messages, such as invalid menu choices, invalid priority input, empty task descriptions, or attempting to process tasks when the queue is empty. This separates error output from normal program output (`System.out`).
 * 7.  **`System.out`**: `System.out.println()` is used for all normal program output, including displaying the menu, prompts for input, success messages, and listing tasks.
 * 8.  **Class-wide exception handling with `try-catch`**: The `run()` method, which contains the main application loop, is wrapped in a `try-catch(Exception e)` block. This fulfills the requirement for class-wide exception handling, ensuring that if any unexpected exception occurs during the program's execution within the loop, it is caught, an error message is printed to `System.err`, and the stack trace is shown before the program potentially terminates (though the `finally` block ensures the scanner is closed). More specific exception handling (`InputMismatchException` for `Scanner` input) is also done within the loop for graceful recovery from common input errors.
 * 9.  **Task Class (`Comparable`)**: The `Task` class encapsulates the task data (ID, description, priority, status). It implements the `Comparable<Task>` interface and provides a `compareTo` method. This method defines the natural order for `Task` objects, sorting first by priority (descending: HIGH > MEDIUM > LOW) and then by ID (ascending) for ties. This is crucial for the `PriorityQueue` to function correctly according to the priority rules.
 * 10. **Enums (`Priority`, `TaskStatus`)**: Enums are used for `Priority` and `TaskStatus` to represent a fixed set of constants, improving code readability and preventing invalid values. The `Priority` enum includes a `level` attribute and a static `fromString` method for parsing user input.
 * 11. **Encapsulation**: All fields in the `Task` and `TaskManager` classes are declared as `private`, and public getter methods are provided where access is necessary, adhering to encapsulation principles. A setter is provided for `TaskStatus` as it changes during processing.
 * 12. **Input Validation and Error Handling**: The `addTask` method validates that the description is not empty and that the entered priority string is valid using the `Priority.fromString` method with a `try-catch` block for `IllegalArgumentException`. The main loop handles `InputMismatchException` from `Scanner`. The `processNextTask` method checks if the `pendingTasks` queue is empty before attempting to poll, preventing a `NullPointerException` and providing a user-friendly error message via `System.err`.
 * 13. **Code Structure and Documentation**: The code is organized into logical classes (`Task`, `Priority`, `TaskStatus`, `TaskManager`). Methods have clear, descriptive names. Basic Javadoc comments are included for classes and key methods. The `viewPendingTasks` method demonstrates how to correctly display the *current* state of the `PriorityQueue` ordered by priority by copying its elements to an `ArrayList` and sorting it, as the `PriorityQueue`'s iterator does not guarantee order.
 * 
 * This solution effectively integrates all required components within a practical scenario, demonstrating understanding of data structures, object-oriented principles, input/output handling, and exception management in Java.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Comparator;

/**
 * Enum representing task priority levels.
 */
enum Priority {
    HIGH(3), MEDIUM(2), LOW(1);

    private final int level;

    Priority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    /**
     * Parses a string input into a Priority enum.
     * Case-insensitive.
     *
     * @param input The string to parse.
     * @return The corresponding Priority enum.
     * @throws IllegalArgumentException if the input string does not match any priority level.
     */
    public static Priority fromString(String input) {
        for (Priority p : values()) {
            if (p.name().equalsIgnoreCase(input)) {
                return p;
            }
        }
        throw new IllegalArgumentException("Invalid priority: " + input);
    }
}

/**
 * Enum representing task status.
 */
enum TaskStatus {
    PENDING, COMPLETED
}

/**
 * Represents a single task in the system.
 * Implements Comparable for priority-based sorting.
 */
class Task implements Comparable<Task> {
    private static int nextId = 1; // For unique task IDs
    private int id;
    private String description;
    private Priority priority;
    private TaskStatus status;

    /**
     * Constructs a new Task with an auto-generated ID and PENDING status.
     *
     * @param description The task description.
     * @param priority    The task priority.
     */
    public Task(String description, Priority priority) {
        this.id = nextId++;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // Setter for status (used when processing)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     * Compares this task with another task based on priority and then ID.
     * Higher priority comes first. For the same priority, lower ID comes first.
     * This is designed for PriorityQueue which is a min-heap, so we reverse the natural order
     * to get the highest priority when polling.
     *
     * @param other The task to compare to.
     * @return A negative integer, zero, or a positive integer as this task is
     *         less than, equal to, or greater than the specified task.
     */
    @Override
    public int compareTo(Task other) {
        // Compare by priority level (higher level = higher priority, comes first in min-heap if reversed)
        int priorityComparison = Integer.compare(other.priority.getLevel(), this.priority.getLevel());
        if (priorityComparison != 0) {
            return priorityComparison; // Sort by priority descending
        }
        // If priorities are the same, sort by ID ascending (lower ID comes first)
        return Integer.compare(this.id, other.id);
    }

    /**
     * Returns a string representation of the task.
     */
    @Override
    public String toString() {
        return String.format("[Task #%d] %s: %s (%s)",
                id, priority.name(), description, status.name());
    }
}

/**
 * Manages a collection of tasks, handling adding, processing, and viewing.
 */
public class TaskManager {

    // Queue to hold pending tasks, ordered by priority
    private Queue<Task> pendingTasks;
    // List to hold completed tasks
    private List<Task> completedTasks;
    // Scanner for user input
    private Scanner scanner;

    /**
     * Constructs a new TaskManager.
     */
    public TaskManager() {
        // Use PriorityQueue for automatic priority ordering
        // The compareTo method in Task defines the order (highest priority first)
        this.pendingTasks = new PriorityQueue<>();
        this.completedTasks = new ArrayList<>(); // Use ArrayList for completed tasks storage
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Management System ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new task based on user input.
     */
    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }

        Priority priority = null;
        while (priority == null) {
            System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
            String priorityInput = scanner.nextLine().trim();
            try {
                priority = Priority.fromString(priorityInput);
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage() + ". Please enter HIGH, MEDIUM, or LOW.");
            }
        }

        Task newTask = new Task(description, priority);
        pendingTasks.offer(newTask); // offer() is preferred over add() for capacity-constrained queues, though PriorityQueue is not bounded
        System.out.println("Task added successfully!");
    }

    /**
     * Processes the next highest-priority task from the pending queue.
     */
    private void processNextTask() {
        Task taskToProcess = pendingTasks.poll(); // Retrieves and removes the head (highest priority) of the queue

        if (taskToProcess == null) {
            System.err.println("No pending tasks to process.");
        } else {
            System.out.println("Processing task: " + taskToProcess);
            taskToProcess.setStatus(TaskStatus.COMPLETED);
            completedTasks.add(taskToProcess); // Add to the List of completed tasks
            System.out.println("Task processed and completed!");
        }
    }

    /**
     * Displays all tasks currently in the pending queue.
     * Creates a temporary list to sort for display without affecting the queue order.
     */
    private void viewPendingTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }

        System.out.println("--- Pending Tasks ---");
        // To display pending tasks sorted by priority, we need to iterate.
        // PriorityQueue iterator does NOT guarantee order.
        // So, we copy to a list and sort for display purposes.
        List<Task> sortedPendingTasks = new ArrayList<>(pendingTasks);
        // Sort using the Task's natural ordering (defined by compareTo)
        sortedPendingTasks.sort(Comparator.naturalOrder());

        for (Task task : sortedPendingTasks) {
            System.out.println(task);
        }
    }

    /**
     * Displays all tasks in the completed tasks list.
     */
    private void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
            return;
        }

        System.out.println("--- Completed Tasks ---");
        // completedTasks is already a List (ArrayList), so we can iterate directly
        for (Task task : completedTasks) {
            System.out.println(task);
        }
    }

    /**
     * Runs the main task management system loop.
     * Includes class-wide exception handling.
     */
    public void run() {
        int choice = -1;

        // Class-wide exception handling wrapping the main loop
        try {
            while (choice != 5) {
                displayMenu();
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    // Switch statement for flow control
                    switch (choice) {
                        case 1:
                            addTask();
                            break;
                        case 2:
                            processNextTask();
                            break;
                        case 3:
                            viewPendingTasks();
                            break;
                        case 4:
                            viewCompletedTasks();
                            break;
                        case 5:
                            System.out.println("Exiting Task Management System.");
                            break;
                        default:
                            System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to stay in the loop
                }
                // Add a small pause or prompt to continue if needed, for better user experience
                // System.out.println("\nPress Enter to continue...");
                // scanner.nextLine();
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main execution
            System.err.println("\nAn unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Main method to start the application.
     */
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run();
    }
}
