/*
 * Exam Question #675
 * Generated on: 2025-05-12 16:24:08
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Task Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application that simulates a task processing system. The system manages tasks that are submitted, queued for processing, and then processed one by one. The system needs to keep a history of all tasks that have been processed, noting whether they were completed successfully or failed.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class. Each task should have:
 *     *   A unique integer ID.
 *     *   A String description.
 *     *   A status. Use an enum `TaskStatus` with states like `PENDING`, `PROCESSING`, `COMPLETED`, and `FAILED`.
 *     *   Implement appropriate constructors, getters, and potentially a method to update the status. Ensure fields are private and accessed via public methods (encapsulation).
 * 
 * 2.  **Task Processing Logic:** Create a `TaskProcessor` class that manages the task queue and the history. This class should contain:
 *     *   A `Queue<Task>` to hold tasks waiting to be processed. Use a suitable implementation like `java.util.LinkedList`.
 *     *   A `List<Task>` to store the history of processed tasks (both completed and failed). Use `java.util.ArrayList` as the implementation.
 *     *   A counter to generate unique task IDs.
 *     *   Methods to:
 *         *   `addTask(String description)`: Creates a new `Task` with a unique ID and `PENDING` status and adds it to the queue.
 *         *   `processNextTask(Scanner scanner)`: Retrieves the next task from the queue. Changes its status to `PROCESSING`. Simulates processing by asking the user if the task succeeded (e.g., "Did Task [ID] succeed? (Y/N)"). Based on valid user input ('Y' or 'N'), update the task status to `COMPLETED` or `FAILED`. Then, move the task from the processing stage (or implicitly from the queue via poll) to the processed history list. Handle cases where the queue is empty or the user provides invalid input during the success/failure prompt.
 *         *   `viewQueue()`: Displays the details of all tasks currently in the waiting queue without removing them.
 *         *   `viewHistory()`: Displays the details of all tasks in the processed history list.
 *         *   `run()`: The main application loop method. It should display a menu, read user commands using `Scanner`, and use a `switch` statement to call the appropriate methods based on the command. This method should also contain the primary exception handling mechanism.
 * 
 * 3.  **User Interface:** Implement a command-line interface in the `run()` method of `TaskProcessor` with the following menu options:
 *     *   `A`: Add New Task
 *     *   `P`: Process Next Task
 *     *   `Q`: View Task Queue
 *     *   `H`: View Processed History
 *     *   `E`: Exit
 * 
 * 4.  **Required Java Components:** Your solution **must** explicitly use all of the following:
 *     *   `java.util.Queue`
 *     *   `java.util.ArrayList`
 *     *   `java.util.List` interface (e.g., declare your history list as `List<Task>`)
 *     *   `java.util.Scanner` for user input
 *     *   A `switch` statement for flow control (specifically for handling menu commands)
 *     *   `System.err` for displaying error messages (e.g., invalid command, queue empty, invalid input during processing prompt)
 *     *   `System.out` for displaying normal output (menu, prompts, task details, history)
 *     *   Class-wide or method-level exception handling using `try-catch` blocks to handle potential runtime issues during the execution of commands (e.g., unexpected input issues).
 * 
 * 5.  **Best Practices:**
 *     *   Adhere to encapsulation principles (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Implement input validation where necessary (e.g., checking for empty queue, validating Y/N input).
 *     *   Implement proper error handling using `System.err` and `try-catch`.
 *     *   Maintain a clean and readable code structure.
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept single-character commands (case-insensitive is a good practice, but not strictly required if you specify case-sensitive), and perform the requested action. Output for viewing tasks should list task ID, description, and status. Error messages should be distinctively printed using `System.err`.
 * 
 * ```
 * --- Task Processing System Menu ---
 * A: Add New Task
 * P: Process Next Task
 * Q: View Task Queue
 * H: View Processed History
 * E: Exit
 * -----------------------------------
 * Enter command:
 * ```
 * 
 * (Example interaction for adding a task)
 * ```
 * Enter command: A
 * Enter task description: Clean the room
 * Task 1 "Clean the room" added to queue.
 * ```
 * 
 * (Example interaction for processing a task)
 * ```
 * Enter command: P
 * Processing Task 1 "Clean the room"...
 * Did Task 1 succeed? (Y/N): Y
 * Task 1 completed.
 * ```
 * 
 * (Example interaction for processing a failing task)
 * ```
 * Enter command: P
 * Processing Task 2 "Write report"...
 * Did Task 2 succeed? (Y/N): N
 * Task 2 failed.
 * ```
 * 
 * (Example interaction for viewing queue)
 * ```
 * Enter command: Q
 * --- Task Queue ---
 * Task 3 [PENDING]: Buy groceries
 * --------------------
 * ```
 * 
 * (Example interaction for viewing history)
 * ```
 * Enter command: H
 * --- Processed History ---
 * Task 1 [COMPLETED]: Clean the room
 * Task 2 [FAILED]: Write report
 * -------------------------
 * ```
 * 
 * (Example interaction for processing with empty queue)
 * ```
 * Enter command: P
 * Error: The task queue is empty. No tasks to process.
 * ```
 * 
 * (Example interaction for invalid command)
 * ```
 * Enter command: X
 * Error: Invalid command. Please try again.
 * ```
 * 
 * Your solution should be a complete, runnable Java program.
 *
 * EXPLANATION:
 * The provided solution implements a simple task processing system as described in the exam question, demonstrating the required Java concepts and best practices.
 * 
 * **Key Components and Concepts Demonstrated:**
 * 
 * 1.  **`java.util.Queue`**: The `taskQueue` field in the `TaskProcessor` class is declared as a `Queue<Task>` and initialized with a `java.util.LinkedList`. This correctly uses the `Queue` interface to manage tasks waiting for processing, utilizing methods like `offer()` to add tasks and `poll()` to retrieve and remove the next task.
 * 2.  **`java.util.ArrayList`**: The `processedHistory` field is initialized as a `java.util.ArrayList<Task>`. This provides a dynamic array implementation suitable for storing the history of tasks.
 * 3.  **`java.util.List` interface**: The `processedHistory` field is declared using the `List<Task>` interface (`private List<Task> processedHistory;`), adhering to the principle of programming to interfaces rather than concrete implementations where appropriate.
 * 4.  **`java.util.Scanner`**: A `Scanner` object is created in the `main` method and passed to the `TaskProcessor` constructor. It is used within the `addTask` and `processNextTask` methods, as well as the main `run` loop, to read user input from `System.in`.
 * 5.  **`switch` statement**: The `run()` method in `TaskProcessor` uses a `switch` statement to efficiently dispatch control based on the user's single-character command ('A', 'P', 'Q', 'H', 'E').
 * 6.  **`System.err`**: `System.err.println()` is used specifically for printing error messages, such as when an invalid command is entered, the queue is empty during a process request, or invalid input is given during the success/failure prompt. This distinguishes error output from normal program output.
 * 7.  **`System.out`**: `System.out.println()` and `System.out.print()` are used for all normal program output, including the menu, prompts, task details when viewing the queue or history, and success messages.
 * 8.  **Class-wide exception handling with `try-catch`**: The `run()` method, which contains the main application loop and command processing logic, is wrapped in a `try-catch(Exception e)` block. This provides a broad safety net to catch unexpected runtime errors that might occur during the execution of any command, preventing the program from crashing abruptly and printing an informative (though generic) error message to `System.err`. Specific input validation errors (like invalid Y/N) are handled more granularly within the `processNextTask` method using loops and `System.err`. The `Task` constructor also includes specific `IllegalArgumentException` handling for invalid descriptions.
 * 9.  **Encapsulation**: The `Task` class has private fields (`id`, `description`, `status`) and provides public getter methods (`getId`, `getDescription`, `getStatus`) and a public setter (`setStatus`) for controlled access. The `TaskProcessor` class also keeps its internal state (`taskQueue`, `processedHistory`, `nextTaskId`, `scanner`) private.
 * 10. **Meaningful Names**: Variables (`taskQueue`, `processedHistory`, `nextTaskId`, `description`, `commandChar`), methods (`addTask`, `processNextTask`, `viewQueue`, `viewHistory`, `run`, `printMenu`), and the enum (`TaskStatus`) have names that clearly indicate their purpose.
 * 11. **Comments and Documentation**: Javadoc comments are included for classes and methods, explaining their purpose, parameters, and return values. Inline comments are used where necessary to clarify specific logic.
 * 12. **Input Validation**: The `addTask` method checks for null or empty descriptions. The `processNextTask` method checks if the queue is empty before attempting to process. The input loop within `processNextTask` validates the user's Y/N response, reprompting until valid input is received. The `run` method checks for empty command input.
 * 13. **Error Handling**: Errors like empty queue, invalid commands, and invalid processing input are explicitly checked and reported using `System.err`. The `try-catch` in `run()` handles more general runtime errors.
 * 14. **Clean Code Structure**: The code is organized into logical classes (`TaskStatus`, `Task`, `TaskProcessor`, `TaskApp`) with clear responsibilities. The main application logic is contained within the `run()` method of `TaskProcessor`, separating it from the `main` entry point.
 * 
 * This solution effectively integrates all the required Java components into a practical, albeit simplified, real-world scenario, demonstrating a solid understanding of core Java programming concepts and best practices suitable for an advanced exam task.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Enum to represent the status of a task
enum TaskStatus {
    PENDING,
    PROCESSING, // Optional: Could be used briefly if simulation was longer
    COMPLETED,
    FAILED
}

// Class to represent a single task
class Task {
    private int id;
    private String description;
    private TaskStatus status;

    /**
     * Constructs a new Task.
     * @param id The unique identifier for the task.
     * @param description A brief description of the task.
     */
    public Task(int id, String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty.");
        }
        this.id = id;
        this.description = description;
        this.status = TaskStatus.PENDING; // Tasks start in PENDING state
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // --- Setter for Status ---
    public void setStatus(TaskStatus status) {
        if (status == null) {
             throw new IllegalArgumentException("Task status cannot be null.");
        }
        this.status = status;
    }

    /**
     * Provides a string representation of the Task.
     * @return Formatted string including ID, status, and description.
     */
    @Override
    public String toString() {
        return String.format("Task %d [%s]: %s", id, status, description);
    }
}

// Class to manage the task queue and processed history
class TaskProcessor {
    private Queue<Task> taskQueue;
    private List<Task> processedHistory;
    private int nextTaskId;
    private Scanner scanner;

    /**
     * Constructs a TaskProcessor.
     * Initializes the queue, history list, and task ID counter.
     * @param scanner The Scanner instance to use for user input.
     */
    public TaskProcessor(Scanner scanner) {
        // Using LinkedList as an implementation of Queue
        this.taskQueue = new LinkedList<>();
        // Using ArrayList as an implementation of List
        this.processedHistory = new ArrayList<>();
        this.nextTaskId = 1;
        this.scanner = scanner; // Using the provided scanner
    }

    /**
     * Adds a new task to the waiting queue.
     * Prompts the user for the task description.
     */
    public void addTask() {
        System.out.print("Enter task description: ");
        // Read the entire line for description
        String description = scanner.nextLine();

        try {
            Task newTask = new Task(nextTaskId++, description);
            taskQueue.offer(newTask); // offer() is preferred over add() for queues
            System.out.println("Task " + newTask.getId() + " \"" + newTask.getDescription() + "\" added to queue.");
        } catch (IllegalArgumentException e) {
            // Handle cases where description is invalid
            System.err.println("Error adding task: " + e.getMessage());
            // Decrement nextTaskId if task creation failed after incrementing
            nextTaskId--;
        }
    }

    /**
     * Processes the next task from the queue.
     * Simulates processing and moves the task to history.
     */
    public void processNextTask() {
        // Check if the queue is empty before attempting to process
        if (taskQueue.isEmpty()) {
            System.err.println("Error: The task queue is empty. No tasks to process.");
            return;
        }

        // Retrieve the next task from the queue
        Task taskToProcess = taskQueue.poll(); // poll() retrieves and removes the head of the queue

        System.out.println("Processing " + taskToProcess + "...");

        // Simulate processing success/failure based on user input
        TaskStatus finalStatus = TaskStatus.FAILED; // Assume failure by default
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Did Task " + taskToProcess.getId() + " succeed? (Y/N): ");
            // Read the next input line and get the first character
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() >= 1) {
                char choice = input.charAt(0);
                if (choice == 'Y') {
                    finalStatus = TaskStatus.COMPLETED;
                    validInput = true;
                } else if (choice == 'N') {
                    finalStatus = TaskStatus.FAILED;
                    validInput = true;
                } else {
                    // Invalid character input
                    System.err.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
                }
            } else {
                 // Empty input line
                 System.err.println("Invalid input. Please enter 'Y' for Yes or 'N' for No.");
            }
        }

        // Update task status and add to history
        taskToProcess.setStatus(finalStatus);
        processedHistory.add(taskToProcess);
        System.out.println("Task " + taskToProcess.getId() + " " + finalStatus.toString().toLowerCase() + ".");
    }

    /**
     * Displays all tasks currently in the waiting queue.
     */
    public void viewQueue() {
        System.out.println("--- Task Queue ---");
        if (taskQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            for (Task task : taskQueue) {
                System.out.println(task);
            }
        }
        System.out.println("--------------------");
    }

    /**
     * Displays the history of all processed tasks.
     */
    public void viewHistory() {
        System.out.println("--- Processed History ---");
        if (processedHistory.isEmpty()) {
            System.out.println("The history is empty.");
        } else {
            // Iterate through the history list
            for (Task task : processedHistory) {
                System.out.println(task);
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * Runs the main application loop, handling user commands.
     * Includes a try-catch block for general exception handling.
     */
    public void run() {
        String command;
        // Use try-with-resources for Scanner if created here, but it's passed in,
        // so we don't close it here as it might close System.in
        // try (Scanner scanner = new Scanner(System.in)) { // If scanner was local
        while (true) {
            printMenu();
            System.out.print("Enter command: ");

            // Use a try-catch block to handle potential exceptions during command processing
            try {
                // Read the command line and get the first character, handle empty input
                command = scanner.nextLine().trim().toUpperCase();
                if (command.isEmpty()) {
                    System.err.println("Error: No command entered.");
                    continue; // Skip to next loop iteration
                }

                char commandChar = command.charAt(0);

                // Use a switch statement to process the command
                switch (commandChar) {
                    case 'A':
                        addTask();
                        break;
                    case 'P':
                        processNextTask();
                        break;
                    case 'Q':
                        viewQueue();
                        break;
                    case 'H':
                        viewHistory();
                        break;
                    case 'E':
                        System.out.println("Exiting Task Processing System. Goodbye!");
                        return; // Exit the run method, ending the program
                    default:
                        // Handle invalid commands
                        System.err.println("Error: Invalid command. Please try again.");
                        break;
                }
            } catch (Exception e) {
                // Catch any unexpected runtime exceptions during command execution
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging if needed
            }
            System.out.println(); // Add a newline for better readability between commands
        }
        // } // Closing try-with-resources if scanner was local
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("--- Task Processing System Menu ---");
        System.out.println("A: Add New Task");
        System.out.println("P: Process Next Task");
        System.out.println("Q: View Task Queue");
        System.out.println("H: View Processed History");
        System.out.println("E: Exit");
        System.out.println("-----------------------------------");
    }
}

// Main class to start the application
public class TaskApp {
    public static void main(String[] args) {
        // Create a single Scanner instance for the application
        Scanner scanner = new Scanner(System.in);
        // Create the TaskProcessor instance, passing the scanner
        TaskProcessor processor = new TaskProcessor(scanner);

        // Run the main application loop
        processor.run();

        // Close the scanner when the application exits
        scanner.close();
    }
}
