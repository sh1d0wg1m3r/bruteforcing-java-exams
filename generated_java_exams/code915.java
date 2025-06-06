/*
 * Exam Question #915
 * Generated on: 2025-05-12 16:58:59
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simple command-line application that simulates a basic task processing system. The system should allow users to add new tasks to a queue, process the next task in the queue, and view the status of all tasks that have been added to the system.
 * 
 * **Requirements:**
 * 
 * Implement a Java application that fulfills the following requirements:
 * 
 * 1.  **Task Representation:** Create a `Task` class to represent a unit of work. Each task should have:
 *     *   A unique integer ID.
 *     *   A description (String).
 *     *   A status (e.g., PENDING, PROCESSING, COMPLETED, FAILED). Use an `enum` for the status.
 * 2.  **Task Management:** Create a main class (e.g., `TaskProcessorSystem`) that manages the tasks. This class must maintain:
 *     *   A queue of tasks that are waiting to be processed.
 *     *   A list of all tasks that have been added to the system (both pending and processed).
 * 3.  **Functionality:** The system must provide the following operations via a command-line menu:
 *     *   **Add Task:** Prompt the user for a task description and add a new task with status `PENDING` to the queue and the list of all tasks. Assign a unique ID sequentially.
 *     *   **Process Next Task:** Take the next task from the *queue*, simulate processing (e.g., change its status to `PROCESSING`, then randomly to `COMPLETED` or `FAILED`), and update the task's status in the list of all tasks. If the queue is empty, report an error.
 *     *   **View All Tasks:** Display the ID, description, and status of *all* tasks ever added to the system (those in the list).
 *     *   **Exit:** Terminate the program.
 * 4.  **Required Java Components:** Your solution MUST use ALL of the following Java components:
 *     *   `java.util.Queue`
 *     *   `java.util.ArrayList`
 *     *   `java.util.List` (used as a type)
 *     *   `java.util.Scanner` for user input
 *     *   `switch` statement for menu navigation
 *     *   `System.err` for error messages
 *     *   `System.out` for normal output (menu, prompts, task status)
 *     *   Class-wide exception handling using `try-catch` blocks (at least one prominent `try-catch` covering a significant part of the program's execution, e.g., the main loop or critical operation).
 * 5.  **Best Practices:** Adhere to best practices including:
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (basic Javadoc or inline comments).
 *     *   Input validation (e.g., handle non-integer menu input, check for empty task description).
 *     *   Proper error handling (using `System.err` for errors).
 *     *   Clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should present a menu to the user. Based on the user's input, it should perform the corresponding action. Output should be clear, indicating the result of each operation or displaying task information. Error messages should be printed to `System.err`.
 * 
 * Example interaction:
 * 
 * ```
 * Task Processing System Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View All Tasks
 * 4. Exit
 * Enter choice: 1
 * Enter task description: Clean the room
 * Task added: ID 1, Description: Clean the room, Status: PENDING
 * 
 * Task Processing System Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View All Tasks
 * 4. Exit
 * Enter choice: 1
 * Enter task description: Buy groceries
 * Task added: ID 2, Description: Buy groceries, Status: PENDING
 * 
 * Task Processing System Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View All Tasks
 * 4. Exit
 * Enter choice: 2
 * Processing task: ID 1, Description: Clean the room... Status updated to COMPLETED.
 * 
 * Task Processing System Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View All Tasks
 * 4. Exit
 * Enter choice: 3
 * --- All Tasks ---
 * ID: 1, Description: Clean the room, Status: COMPLETED
 * ID: 2, Description: Buy groceries, Status: PENDING
 * --- End of Tasks ---
 * 
 * Task Processing System Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View All Tasks
 * 4. Exit
 * Enter choice: 5
 * Invalid choice. Please enter a number between 1 and 4.
 * 
 * Task Processing System Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View All Tasks
 * 4. Exit
 * Enter choice: 2
 * Processing task: ID 2, Description: Buy groceries... Status updated to FAILED.
 * 
 * Task Processing System Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View All Tasks
 * 4. Exit
 * Enter choice: 2
 * Error: Task queue is empty. Cannot process.
 * 
 * Task Processing System Menu:
 * 1. Add Task
 * 2. Process Next Task
 * 3. View All Tasks
 * 4. Exit
 * Enter choice: 4
 * Exiting Task Processing System.
 * ```
 * 
 * Implement the complete Java code for this system.
 *
 * EXPLANATION:
 * This solution implements the Task Processing System as required, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **Task Representation (`Task` class and `TaskStatus` enum):**
 *     *   The `Task` class encapsulates the data for a single task (ID, description, status). Fields are `private` following encapsulation principles.
 *     *   Getters are provided for accessing the task's properties. A setter is included for `status` to allow modification during processing.
 *     *   A `toString()` method is overridden for easy printing of task details.
 *     *   The `TaskStatus` enum clearly defines the possible states a task can be in, improving code readability and preventing invalid status values.
 * 
 * 2.  **Task Management (`TaskProcessorSystem` class):**
 *     *   This is the main class containing the system's logic.
 *     *   `taskQueue` (`Queue<Task>`): A `LinkedList` instance is used here. `LinkedList` implements the `Queue` interface, providing `offer()` (add to end) and `poll()` (remove from front) methods suitable for queue operations. This holds tasks awaiting processing.
 *     *   `allTasks` (`List<Task>`): An `ArrayList` instance is used here. `ArrayList` implements the `List` interface. This list stores a reference to *every* task created, regardless of its current status or whether it's still in the queue. This allows viewing all tasks ever added.
 *     *   `nextTaskId`: A simple integer counter ensures each task gets a unique ID.
 *     *   `scanner`: An instance of `Scanner` is used to read user input from the console.
 *     *   `random`: Used to simulate the success/failure outcome of task processing.
 * 
 * 3.  **Functionality Implementation:**
 *     *   `addTask(String description)`: Creates a new `Task` object, adds it to both the `taskQueue` (for processing) and the `allTasks` list (for viewing history). It increments `nextTaskId` and performs basic input validation on the description.
 *     *   `processNextTask()`: Uses `taskQueue.poll()` to retrieve and *remove* the next task from the front of the queue. It checks if the queue is empty using the result of `poll()` (which returns `null` if empty) before attempting to process. It simulates processing by updating the task's status based on a random outcome. Since the `Task` object in `allTasks` is the *same instance* as the one removed from the queue, updating its status modifies the object visible in the `allTasks` list.
 *     *   `viewAllTasks()`: Iterates through the `allTasks` list and prints the details of each task using its `toString()` method.
 *     *   `displayMenu()`: A helper method to print the user menu to `System.out`.
 *     *   `runSystem()`: Contains the main application loop. It repeatedly displays the menu, reads user input, and dispatches the appropriate action using a `switch` statement.
 * 
 * 4.  **Required Component Usage:**
 *     *   `Queue`: Used for `taskQueue` (`LinkedList` implementation).
 *     *   `ArrayList`: Used for `allTasks` list.
 *     *   `List`: Used as the declared type for `allTasks` (`List<Task> allTasks`).
 *     *   `Scanner`: Used in `runSystem` to read user input.
 *     *   `switch`: Used in `runSystem` for menu navigation.
 *     *   `System.err`: Used for printing error messages (invalid input, empty queue, unexpected exceptions).
 *     *   `System.out`: Used for printing the menu, prompts, task confirmations, and the list of tasks.
 *     *   `try-catch`: A broad `try-catch(Exception e)` block wraps the main `while` loop in `runSystem`, providing class-wide handling for unexpected runtime errors. A specific `try-catch(NumberFormatException)` is used inside the loop to handle non-integer input gracefully. A `finally` block ensures the `Scanner` is closed. The `processNextTask` method handles the empty queue case with an `if` check after `poll()` returns `null`, which is a common and idiomatic way to handle this specific queue condition, rather than relying on `remove()` which throws an exception.
 * 
 * 5.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Task` and `TaskProcessorSystem` are private. Access is controlled via public methods.
 *     *   **Naming:** Variable and method names are descriptive (e.g., `taskQueue`, `processNextTask`, `viewAllTasks`).
 *     *   **Comments/Documentation:** Basic Javadoc comments are provided for classes and methods, and inline comments explain key logic.
 *     *   **Input Validation:** Checks for empty task description and non-integer menu input are included.
 *     *   **Error Handling:** Specific error conditions (empty queue, invalid input) are checked, and errors are reported using `System.err`. A general `try-catch` handles unexpected exceptions.
 *     *   **Clean Structure:** The code is divided into logical classes (`TaskStatus`, `Task`, `TaskProcessorSystem`) with clear responsibilities. The main loop in `runSystem` is structured cleanly.
 * 
 * This solution effectively combines the required Java components within a practical scenario, demonstrating understanding of data structures, control flow, error handling, and object-oriented principles.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// Enum for Task Status
enum TaskStatus {
    PENDING,
    PROCESSING,
    COMPLETED,
    FAILED
}

// Represents a single Task
class Task {
    private int id;
    private String description;
    private TaskStatus status;

    /**
     * Constructs a new Task.
     * @param id The unique ID of the task.
     * @param description A brief description of the task.
     */
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = TaskStatus.PENDING; // New tasks start as PENDING
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

    // Setter for status (allows updating task status)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Description: %s, Status: %s", id, description, status);
    }
}

// Main class to manage tasks and user interaction
public class TaskProcessorSystem {

    private Queue<Task> taskQueue; // Tasks waiting to be processed
    private List<Task> allTasks; // All tasks ever added
    private int nextTaskId; // Counter for unique task IDs
    private Scanner scanner; // For user input
    private Random random; // To simulate processing outcome

    /**
     * Constructs the TaskProcessorSystem.
     */
    public TaskProcessorSystem() {
        this.taskQueue = new LinkedList<>(); // LinkedList implements Queue
        this.allTasks = new ArrayList<>(); // ArrayList implements List
        this.nextTaskId = 1; // Start task IDs from 1
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    /**
     * Adds a new task to the system.
     * @param description The description of the task.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }
        Task newTask = new Task(nextTaskId++, description.trim());
        taskQueue.offer(newTask); // Add to the end of the queue
        allTasks.add(newTask); // Add to the list of all tasks
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task from the queue.
     * Simulates processing and updates task status.
     */
    public void processNextTask() {
        Task taskToProcess = taskQueue.poll(); // Get and remove the head of the queue

        if (taskToProcess == null) {
            System.err.println("Error: Task queue is empty. Cannot process.");
            return;
        }

        System.out.println("Processing task: " + taskToProcess.getDescription() + "...");
        taskToProcess.setStatus(TaskStatus.PROCESSING); // Mark as processing (optional step for simulation)

        // Simulate processing outcome: 80% success, 20% failure
        if (random.nextDouble() < 0.8) {
            taskToProcess.setStatus(TaskStatus.COMPLETED);
            System.out.println("Status updated to COMPLETED.");
        } else {
            taskToProcess.setStatus(TaskStatus.FAILED);
            System.out.println("Status updated to FAILED.");
        }
        // Note: The task is already removed from the queue by poll().
        // Its status is updated in the 'allTasks' list because both taskQueue and allTasks
        // initially held references to the same Task object.
    }

    /**
     * Displays the status of all tasks ever added to the system.
     */
    public void viewAllTasks() {
        System.out.println("--- All Tasks ---");
        if (allTasks.isEmpty()) {
            System.out.println("No tasks have been added yet.");
        } else {
            for (Task task : allTasks) {
                System.out.println(task);
            }
        }
        System.out.println("--- End of Tasks ---");
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\nTask Processing System Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Runs the main loop of the Task Processing System.
     * Handles user input and dispatches actions.
     */
    public void runSystem() {
        boolean running = true;

        // Class-wide try-catch block for the main system loop
        try {
            while (running) {
                displayMenu();

                int choice = -1;
                try {
                    choice = Integer.parseInt(scanner.nextLine()); // Read entire line
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    continue; // Skip to the next loop iteration
                }

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        addTask(description);
                        break;
                    case 2:
                        processNextTask();
                        break;
                    case 3:
                        viewAllTasks();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Exiting Task Processing System.");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
            // Ensure scanner is closed even if an exception occurs or system exits
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed.");
            }
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskProcessorSystem system = new TaskProcessorSystem();
        system.runSystem();
    }
}
