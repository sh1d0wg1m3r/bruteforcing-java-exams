/*
 * Exam Question #64
 * Generated on: 2025-05-11 22:07:40
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simple console-based system to manage and process tasks. The system should allow users to add new tasks to a queue, process tasks from the queue, view the tasks currently waiting in the queue, and view a history of tasks that have already been processed.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that fulfills the following requirements:
 * 
 * 1.  **Task Representation:** Create a simple class (e.g., `Task`) to represent a task. Each task should have:
 *     *   A unique integer ID.
 *     *   A String description.
 *     *   A status (e.g., PENDING, PROCESSED). An `enum` for status is recommended but not strictly required if a String or int is used consistently.
 * 2.  **System Core:** Create a main class (e.g., `TaskProcessingSystem`) that manages the tasks. This class must contain:
 *     *   A `Queue` to hold tasks that are waiting to be processed.
 *     *   A `List` to store tasks that have been processed. Use an `ArrayList` as the concrete implementation for this `List`.
 *     *   A mechanism to generate unique task IDs.
 * 3.  **User Interface:** The system should provide a console-based menu with the following options:
 *     *   `1. Add New Task`: Prompt the user for a task description and add a new task with a unique ID and PENDING status to the task queue.
 *     *   `2. Process Next Task`: Take the next task from the front of the queue, change its status to PROCESSED, and move it to the processed history list. If the queue is empty, report an error.
 *     *   `3. View Task Queue`: Display the details (ID, description, status) of all tasks currently in the waiting queue.
 *     *   `4. View Processed History`: Display the details (ID, description, status) of all tasks in the processed history.
 *     *   `5. Exit`: Terminate the program.
 * 4.  **Implementation Details:**
 *     *   Use `java.util.Queue` for the task queue. You can use a concrete implementation like `java.util.LinkedList`.
 *     *   Use `java.util.ArrayList` to implement the `java.util.List` for the processed history.
 *     *   Use `java.util.Scanner` to read user input for menu choices and task descriptions.
 *     *   Use a `switch` statement to handle the different menu options.
 *     *   Use `System.out` for displaying the menu, task details, and successful operation messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid menu choice, trying to process from an empty queue, general unexpected errors).
 *     *   Implement class-wide exception handling. The main program loop reading user input and processing commands should be wrapped in a `try-catch` block to catch potential unexpected exceptions during execution and report them using `System.err`.
 * 5.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (basic Javadoc style is sufficient).
 *     *   Implement input validation for the menu choice (ensure it's a valid integer within the range of options). Handle non-integer input gracefully.
 *     *   Ensure proper error handling as specified using `System.err`.
 *     *   Structure the code logically into classes and methods.
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept user input, and display output based on the chosen option. Examples:
 * 
 * *   Adding a task: `Task added with ID: 1`
 * *   Processing a task: `Processed task ID: 1 - [Description] - Status: PROCESSED`
 * *   Processing from empty queue: `Error: The task queue is empty.` (using `System.err`)
 * *   Viewing queue/history: Lists of tasks with ID, description, and status.
 * *   Invalid menu input: `Error: Invalid input. Please enter a number between 1 and 5.` (using `System.err`)
 * *   Unexpected error: `An unexpected error occurred: [Error Message]` (using `System.err`)
 * 
 * Your solution must be a single Java file containing all necessary classes.
 * 
 * **Deliverables:**
 * 
 * Submit the complete Java source code for the Task Processing System.
 *
 * EXPLANATION:
 * The provided solution implements a `TaskProcessingSystem` that manages tasks using a queue for pending items and a list for processed items, fulfilling all the requirements of the exam question.
 * 
 * 1.  **Task Representation:** The `Task` class is a simple Plain Old Java Object (POJO) with `id`, `description`, and `status` fields. An `enum` `TaskStatus` is used for clarity and type safety for the status. Getters and a setter for status are provided, demonstrating encapsulation. The `toString()` method provides a convenient way to display task information.
 * 
 * 2.  **System Core:** The `TaskProcessingSystem` class holds the core logic.
 *     *   `taskQueue`: Declared as `Queue<Task>` and initialized with `new LinkedList<>()`. `LinkedList` is a common implementation of the `Queue` interface and is suitable here. It holds `Task` objects waiting to be processed.
 *     *   `processedHistory`: Declared as `List<Task>` and initialized with `new ArrayList<>()`. This demonstrates using the `List` interface type while using the concrete `ArrayList` implementation. It stores `Task` objects after they have been processed.
 *     *   `nextTaskId`: A private integer counter initialized to 1, used to assign unique IDs to new tasks.
 *     *   `scanner`: A `Scanner` object is created as a class member to manage user input throughout the `run` method.
 * 
 * 3.  **User Interface & Flow Control:**
 *     *   The `run()` method contains the main application loop.
 *     *   `displayMenu()` is a helper method to print the menu options to `System.out`.
 *     *   Inside the `run` loop, `scanner.hasNextInt()` is used for robust input validation before attempting to read the integer menu choice, preventing `InputMismatchException` for non-integer inputs.
 *     *   A `switch` statement is used to direct the program flow based on the user's valid integer choice, calling the appropriate methods (`addTask`, `processNextTask`, `viewTaskQueue`, `viewProcessedHistory`).
 *     *   The `default` case in the `switch` handles invalid integer inputs (numbers outside 1-5), printing an error message to `System.err`.
 * 
 * 4.  **Implementation Details & Required Components Usage:**
 *     *   `Queue`: Used with `taskQueue.offer()` to add tasks and `taskQueue.poll()` to retrieve and remove the next task. `poll()` is used because it gracefully returns `null` if the queue is empty, which is handled by an `if` check. `taskQueue.isEmpty()` is used to check if the queue is empty before processing or viewing.
 *     *   `ArrayList` and `List`: `processedHistory` is an `ArrayList`, demonstrating its use as a concrete implementation of the `List` interface. Tasks are added to it using `processedHistory.add()`. `processedHistory.isEmpty()` is used for checking if the history is empty.
 *     *   `Scanner`: Used to read both integer menu choices (`scanner.nextInt()`) and String task descriptions (`scanner.nextLine()`). `scanner.nextLine()` is called after `scanner.nextInt()` to consume the leftover newline character.
 *     *   `Switch statement`: Explicitly used in the `run()` method to handle the menu options.
 *     *   `System.err`: Used specifically for printing error messages, such as invalid input, empty queue when processing, empty task description, and unexpected general errors.
 *     *   `System.out`: Used for all normal output, including the menu, task details, and success messages.
 *     *   `try-catch`: The main `while` loop in `run()` is wrapped in a `try-catch(Exception e)` block. This provides class-wide exception handling, catching any unhandled runtime exceptions that might occur within the loop's execution and printing an error message and stack trace to `System.err`. A specific `catch(InputMismatchException e)` was initially included but the `hasNextInt` check makes it less critical; the broader `Exception` catch handles it anyway. A `finally` block ensures the `Scanner` is closed.
 * 
 * 5.  **Best Practices:**
 *     *   **Encapsulation:** `taskQueue`, `processedHistory`, `nextTaskId`, and `scanner` are private fields. Access and modification are done through public methods.
 *     *   **Meaningful Names:** Class names (`Task`, `TaskProcessingSystem`), variable names (`taskQueue`, `processedHistory`, `nextTaskId`, `description`, `choice`), and method names (`addTask`, `processNextTask`, `viewTaskQueue`, `viewProcessedHistory`, `displayMenu`, `run`) are descriptive.
 *     *   **Comments and Documentation:** Basic Javadoc-style comments explain the purpose of classes, methods, and key variables. Inline comments explain specific logic points.
 *     *   **Input Validation:** Checks are performed to ensure the menu input is an integer and within the valid range. Task description is checked for being empty. Error messages are printed to `System.err` for invalid inputs.
 *     *   **Error Handling:** Specific operational errors (empty queue, invalid input) are caught and reported using `System.err`. A general `try-catch` handles unexpected errors at the system level, also reporting to `System.err`.
 *     *   **Clean Code Structure:** The code is organized into logical classes (`Task`, `TaskProcessingSystem`). The main logic is separated into methods (`addTask`, `processNextTask`, etc.) and the `run` method orchestrates the interaction.
 * 
 * This solution effectively demonstrates the required Java concepts and best practices within a practical, albeit simplified, application scenario.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Enum to represent task status
enum TaskStatus {
    PENDING,
    PROCESSED
}

// Class to represent a single task
class Task {
    private int id;
    private String description;
    private TaskStatus status;

    /**
     * Constructs a new Task.
     * @param id The unique ID for the task.
     * @param description The description of the task.
     */
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = TaskStatus.PENDING; // New tasks are always PENDING
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

    // Setter for status (used when processing)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Task.
     * @return String representation of the task.
     */
    @Override
    public String toString() {
        return "ID: " + id + " - " + description + " - Status: " + status;
    }
}

/**
 * Main class for the Task Processing System.
 * Manages a queue of pending tasks and a list of processed tasks.
 */
public class TaskProcessingSystem {
    private Queue<Task> taskQueue; // Queue for tasks waiting to be processed
    private List<Task> processedHistory; // List for tasks that have been processed
    private int nextTaskId; // Counter for generating unique task IDs
    private Scanner scanner; // Scanner for user input

    /**
     * Constructs a new TaskProcessingSystem.
     * Initializes the queue, history list, and task ID counter.
     */
    public TaskProcessingSystem() {
        this.taskQueue = new LinkedList<>(); // LinkedList implements Queue
        this.processedHistory = new ArrayList<>(); // ArrayList implements List
        this.nextTaskId = 1; // Start task IDs from 1
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task to the task queue.
     * @param description The description of the new task.
     */
    public void addTask(String description) {
        Task newTask = new Task(nextTaskId++, description);
        taskQueue.offer(newTask); // offer() is preferred over add() for queues as it doesn't throw exception on failure
        System.out.println("Task added: " + newTask.toString());
    }

    /**
     * Processes the next task from the queue.
     * Moves the task to the processed history.
     */
    public void processNextTask() {
        Task taskToProcess = taskQueue.poll(); // poll() retrieves and removes the head, returns null if empty
        if (taskToProcess != null) {
            taskToProcess.setStatus(TaskStatus.PROCESSED);
            processedHistory.add(taskToProcess);
            System.out.println("Processed task: " + taskToProcess.toString());
        } else {
            System.err.println("Error: The task queue is empty. No tasks to process.");
        }
    }

    /**
     * Displays all tasks currently in the waiting queue.
     */
    public void viewTaskQueue() {
        System.out.println("\n--- Task Queue ---");
        if (taskQueue.isEmpty()) {
            System.out.println("The task queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            for (Task task : taskQueue) {
                System.out.println(task.toString());
            }
        }
        System.out.println("------------------\n");
    }

    /**
     * Displays all tasks in the processed history.
     */
    public void viewProcessedHistory() {
        System.out.println("\n--- Processed History ---");
        if (processedHistory.isEmpty()) {
            System.out.println("The processed history is empty.");
        } else {
            for (Task task : processedHistory) {
                System.out.println(task.toString());
            }
        }
        System.out.println("-------------------------\n");
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("Task Processing System Menu:");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Task Queue");
        System.out.println("4. View Processed History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main loop of the Task Processing System.
     * Handles user input and calls appropriate methods.
     */
    public void run() {
        int choice = -1; // Initialize choice outside the loop

        // Class-wide exception handling for the main interaction loop
        try {
            while (choice != 5) {
                displayMenu();
                try {
                    // Input validation for menu choice
                    if (scanner.hasNextInt()) {
                        choice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                    } else {
                        System.err.println("Error: Invalid input. Please enter a number.");
                        scanner.nextLine(); // Consume the invalid input
                        choice = -1; // Reset choice to ensure loop continues and shows menu again
                        continue; // Skip the switch and go to the next iteration
                    }

                    // Switch statement for flow control
                    switch (choice) {
                        case 1:
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine();
                            if (description == null || description.trim().isEmpty()) {
                                System.err.println("Error: Task description cannot be empty.");
                            } else {
                                addTask(description);
                            }
                            break;
                        case 2:
                            processNextTask();
                            break;
                        case 3:
                            viewTaskQueue();
                            break;
                        case 4:
                            viewProcessedHistory();
                            break;
                        case 5:
                            System.out.println("Exiting Task Processing System. Goodbye!");
                            break;
                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    // This specific catch is mostly handled by the hasNextInt check now,
                    // but kept as an example of specific input handling.
                    System.err.println("Error: Invalid input type. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                }
                // Pause slightly or wait for user acknowledgement if needed, skipped for simplicity
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions during execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to standard error
        } finally {
            // Ensure the scanner is closed when the program exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskProcessingSystem system = new TaskProcessingSystem();
        system.run();
    }
}
