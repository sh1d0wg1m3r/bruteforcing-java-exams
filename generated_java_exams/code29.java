/*
 * Exam Question #29
 * Generated on: 2025-05-11 21:47:56
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Resource Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple text-based application to simulate a Resource Management System. This system handles tasks submitted by users, processes them in the order they were received, and keeps a record of completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` to represent a task. Each task must have:
 *     *   A unique integer ID.
 *     *   A String type (e.g., "CPU", "IO", "Network").
 *     *   A String description.
 *     *   A String status (e.g., "Waiting", "Completed").
 *     *   Proper encapsulation (private fields, public getters, a setter for status).
 *     *   A constructor to initialize ID, type, and description.
 *     *   A `toString()` method for easy display.
 * 
 * 2.  **Resource Manager:** Create a class named `ResourceManager` that manages the tasks. It must contain:
 *     *   A `java.util.Queue<Task>` to hold tasks that are waiting to be processed. Use a suitable implementation (e.g., `java.util.LinkedList`).
 *     *   A `java.util.List<Task>` (using `java.util.ArrayList` as the implementation) to store tasks that have been completed.
 *     *   A mechanism to generate unique task IDs (starting from 1).
 *     *   Methods for:
 *         *   `submitTask(String type, String description)`: Creates a new `Task` with a unique ID and adds it to the waiting queue.
 *         *   `processNextTask()`: Removes the next task from the waiting queue, changes its status to "Completed", and adds it to the completed tasks list. If the queue is empty, it should indicate that no tasks are waiting.
 *         *   `viewWaitingTasks()`: Displays the details of all tasks currently in the waiting queue.
 *         *   `viewCompletedTasks()`: Displays the details of all tasks in the completed tasks list.
 * 
 * 3.  **User Interface:** Implement a text-based user interface in the `ResourceManager` class (perhaps in a `run` method or the `main` method) using `java.util.Scanner` to interact with the user. The interface should present a menu with the following options:
 *     *   1. Submit New Task
 *     *   2. Process Next Task
 *     *   3. View Waiting Tasks
 *     *   4. View Completed Tasks
 *     *   5. Exit
 * 
 * 4.  **Control Flow:** Use a `switch` statement to handle the user's menu choice.
 * 
 * 5.  **Output:**
 *     *   Use `System.out` for displaying the menu, prompts, task details, and success messages.
 *     *   Use `System.err` for displaying error messages, such as invalid menu choices, input validation failures, or issues during task processing (e.g., trying to process a task when the queue is empty).
 * 
 * 6.  **Error Handling:** Implement class-wide exception handling using a `try-catch` block that wraps the main user interaction loop or the core logic of the `run` method to catch unexpected runtime exceptions. Also, include specific input validation (e.g., ensuring menu input is an integer, checking if task type/description are empty) and handle these using conditional checks and `System.err`.
 * 
 * 7.  **Best Practices:** Adhere to good programming practices, including:
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (e.g., Javadoc).
 *     *   Clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively. Users select options from a menu. Output will vary based on user input. Examples:
 * 
 * ```
 * --- Resource Management System ---
 * 1. Submit New Task
 * 2. Process Next Task
 * 3. View Waiting Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task type: CPU
 * Enter task description: Run complex calculation
 * Task submitted: Task ID: 1, Type: CPU, Description: Run complex calculation, Status: Waiting
 * 
 * --- Resource Management System ---
 * ...
 * Enter your choice: 2
 * Processing task: Task ID: 1, Type: CPU, Description: Run complex calculation, Status: Waiting
 * Task ID 1 completed.
 * 
 * --- Resource Management System ---
 * ...
 * Enter your choice: 3
 * Waiting Tasks:
 * (Empty)
 * 
 * --- Resource Management System ---
 * ...
 * Enter your choice: 4
 * Completed Tasks:
 * Task ID: 1, Type: CPU, Description: Run complex calculation, Status: Completed
 * 
 * --- Resource Management System ---
 * ...
 * Enter your choice: 6
 * Error: Invalid choice. Please enter a number between 1 and 5. (Printed to System.err)
 * 
 * --- Resource Management System ---
 * ...
 * Enter your choice: 5
 * Exiting Resource Management System.
 * ```
 * 
 * Your solution should provide the complete Java code for the `Task` and `ResourceManager` classes, including a `main` method to start the application.
 * 
 * **Constraint:** You MUST use `java.util.Queue`, `java.util.ArrayList`, `java.util.List`, `java.util.Scanner`, a `switch` statement, `System.err`, `System.out`, and class-wide `try-catch` blocks as specified.
 *
 * EXPLANATION:
 * The solution implements a simple Resource Management System as requested, demonstrating the use of various core Java concepts and best practices.
 * 
 * **Key Components and Their Usage:**
 * 
 * 1.  **`java.util.Queue`**: The `waitingTasks` field is declared as a `Queue<Task>`. A `java.util.LinkedList` is used as the concrete implementation because it efficiently supports queue operations (`offer` to add at the end, `poll` to remove from the front). It naturally represents tasks waiting in a first-in, first-out (FIFO) manner.
 * 2.  **`java.util.ArrayList`**: The `completedTasks` field is implemented using `ArrayList`. This is suitable for storing completed tasks as a dynamic list where elements can be added, and iterated over, without requiring FIFO access.
 * 3.  **`java.util.List`**: The `completedTasks` field is declared using the `List` interface (`private List<Task> completedTasks;`), demonstrating the principle of programming to an interface rather than a specific implementation (`ArrayList`).
 * 4.  **`java.util.Scanner`**: A `Scanner` object is used to read user input from `System.in`. It's used to read integer choices and string inputs for task details.
 * 5.  **`switch` statement**: The main interactive loop uses a `switch` statement based on the user's integer menu choice to direct the program flow to the appropriate `ResourceManager` method (`submitTask`, `processNextTask`, `viewWaitingTasks`, `viewCompletedTasks`) or to exit.
 * 6.  **`System.err`**: Used specifically for printing error messages, such as when the user enters an invalid menu choice, provides empty task details, or enters non-integer input where an integer is expected. This separates error output from normal program output (`System.out`).
 * 7.  **`System.out`**: Used for all standard program output, including displaying the menu, prompts for input, details of tasks, queue contents, completed task list contents, and success messages.
 * 8.  **Class-wide `try-catch`**: A `try-catch(Exception e)` block is wrapped around the main `while` loop within the `run()` method. This provides a broad safety net to catch any unexpected runtime exceptions that might occur during the execution of the interactive loop, preventing the program from crashing abruptly and printing a generic error message to `System.err`. A `finally` block ensures the `Scanner` is closed regardless of whether an exception occurred or the loop exited normally.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** The `Task` class fields (`taskId`, `taskType`, `description`, `status`) and `ResourceManager` fields (`waitingTasks`, `completedTasks`, `nextTaskId`, `scanner`) are declared as `private`, with public getter methods (`getTaskId`, etc.) and a specific setter (`setStatus`) provided where necessary, controlling access to the internal state.
 * *   **Meaningful Names:** Variable names (`waitingTasks`, `completedTasks`, `nextTaskId`, `taskToProcess`) and method names (`submitTask`, `processNextTask`, `viewWaitingTasks`, `printMenu`) are descriptive and clearly indicate their purpose.
 * *   **Appropriate Comments and Documentation:** Javadoc comments are used for classes and methods, explaining their purpose, parameters, and return values. Inline comments are used for specific logic points.
 * *   **Input Validation:** Before creating a `Task`, the `submitTask` method checks if the provided `type` or `description` strings are null or empty/whitespace. The `run` method checks if the next scanner input is an integer before reading it, handling `InputMismatchException` implicitly by checking `hasNextInt()` and consuming the invalid input. Error messages for validation failures are printed to `System.err`.
 * *   **Error Handling:** Specific conditions like an empty waiting queue in `processNextTask` are checked, and informative messages are printed to `System.out`. Invalid menu choices are caught by the `default` case in the `switch` and reported to `System.err`. The broad `try-catch` handles unexpected exceptions.
 * *   **Clean Code Structure:** The code is organized into two classes (`Task` and `ResourceManager`) with distinct responsibilities. Methods are focused on single tasks. The `run` method encapsulates the user interaction logic, keeping the `main` method simple. The menu printing is extracted into a separate private method (`printMenu`).
 * 
 * This solution effectively combines the required Java components within a practical scenario, demonstrating understanding of data structures, control flow, object-oriented principles, and robust error handling.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a task managed by the Resource Management System.
 */
class Task {
    private int taskId;
    private String taskType;
    private String description;
    private String status; // e.g., "Waiting", "Completed"

    /**
     * Constructs a new Task.
     *
     * @param taskId      The unique ID of the task.
     * @param taskType    The type of the task (e.g., "CPU", "IO").
     * @param description A description of the task.
     */
    public Task(int taskId, String taskType, String description) {
        this.taskId = taskId;
        this.taskType = taskType;
        this.description = description;
        this.status = "Waiting"; // Tasks start in Waiting status
    }

    // --- Getters ---
    public int getTaskId() {
        return taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // --- Setter for status ---
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Task.
     *
     * @return A formatted string detailing the task's properties.
     */
    @Override
    public String toString() {
        return String.format("Task ID: %d, Type: %s, Description: %s, Status: %s",
                             taskId, taskType, description, status);
    }
}

/**
 * Manages tasks using a waiting queue and a completed list.
 */
public class ResourceManager {
    // Queue for tasks waiting to be processed
    private Queue<Task> waitingTasks;
    // List for tasks that have been completed
    private List<Task> completedTasks;
    // Counter for generating unique task IDs
    private int nextTaskId;
    // Scanner for user input
    private Scanner scanner;

    /**
     * Constructs a new ResourceManager.
     * Initializes the waiting queue, completed list, and task ID counter.
     */
    public ResourceManager() {
        this.waitingTasks = new LinkedList<>(); // Using LinkedList as a Queue implementation
        this.completedTasks = new ArrayList<>(); // Using ArrayList as a List implementation
        this.nextTaskId = 1;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Submits a new task to the waiting queue.
     *
     * @param type        The type of the task.
     * @param description A description of the task.
     * @return The created Task object.
     */
    public Task submitTask(String type, String description) {
        // Basic input validation
        if (type == null || type.trim().isEmpty()) {
            System.err.println("Error: Task type cannot be empty.");
            return null;
        }
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return null;
        }

        Task newTask = new Task(nextTaskId++, type.trim(), description.trim());
        waitingTasks.offer(newTask); // Add task to the end of the queue
        System.out.println("Task submitted: " + newTask);
        return newTask;
    }

    /**
     * Processes the next task from the waiting queue.
     * Moves the task to the completed list upon successful processing.
     */
    public void processNextTask() {
        if (waitingTasks.isEmpty()) {
            System.out.println("No tasks in the waiting queue.");
            return;
        }

        Task taskToProcess = waitingTasks.poll(); // Get and remove the head of the queue
        System.out.println("Processing task: " + taskToProcess);

        // Simulate processing by changing status and moving to completed list
        taskToProcess.setStatus("Completed");
        completedTasks.add(taskToProcess); // Add task to the completed list

        System.out.println("Task ID " + taskToProcess.getTaskId() + " completed.");
    }

    /**
     * Displays all tasks currently in the waiting queue.
     */
    public void viewWaitingTasks() {
        System.out.println("\n--- Waiting Tasks ---");
        if (waitingTasks.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            // Iterate through the queue without removing elements
            for (Task task : waitingTasks) {
                System.out.println(task);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Displays all tasks in the completed tasks list.
     */
    public void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            // Iterate through the list
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Runs the main interactive loop for the Resource Manager system.
     * Includes class-wide exception handling.
     */
    public void run() {
        int choice = -1;

        // Class-wide exception handling wrapping the main loop
        try {
            while (choice != 5) {
                printMenu();
                System.out.print("Enter your choice: ");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } else {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    continue; // Skip the switch and loop again
                }

                // Use switch statement for flow control
                switch (choice) {
                    case 1:
                        System.out.print("Enter task type: ");
                        String type = scanner.nextLine();
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        submitTask(type, description);
                        break;
                    case 2:
                        processNextTask();
                        break;
                    case 3:
                        viewWaitingTasks();
                        break;
                    case 4:
                        viewCompletedTasks();
                        break;
                    case 5:
                        System.out.println("Exiting Resource Management System.");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                System.out.println(); // Add a newline for better readability between actions

            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for debugging stack trace
        } finally {
            // Ensure scanner is closed
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("--- Resource Management System ---");
        System.out.println("1. Submit New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Waiting Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
        System.out.println("----------------------------------");
    }

    /**
     * Main method to start the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ResourceManager manager = new ResourceManager();
        manager.run();
    }
}
