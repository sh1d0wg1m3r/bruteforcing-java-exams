/*
 * Exam Question #203
 * Generated on: 2025-05-11 22:31:26
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Resource-Aware Task Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified system to manage and process tasks that require a certain amount of computational resources. The system has a fixed pool of available resources. Tasks are added to a pending list, then loaded into a processing queue if sufficient resources are available, and finally processed from the queue.
 * 
 * **Task Definition:**
 * 
 * A `Task` object should represent a unit of work and have the following attributes:
 * *   `id`: A unique integer identifier.
 * *   `description`: A string describing the task.
 * *   `requiredResourceUnits`: An integer representing the number of resource units this task needs to be processed.
 * 
 * **System Components:**
 * 
 * The system should manage tasks using the following structures:
 * *   A list (`List<Task>`) to hold tasks that have been added but not yet moved to the processing queue (`pendingTasks`).
 * *   A queue (`Queue<Task>`) to hold tasks that are ready for processing, provided resources are available (`processingQueue`). Tasks should be processed in the order they were added to this queue (FIFO).
 * *   A list (`List<Task>`) to hold tasks that have been successfully processed (`completedTasks`).
 * *   An integer variable representing the current number of `availableResourceUnits`. The system starts with a predefined maximum number of resources.
 * 
 * **User Interface (Console-Based):**
 * 
 * The system should present a menu to the user with the following options:
 * 1.  **Add New Task:** Prompts the user for task description and required resource units. Creates a `Task` object and adds it to the `pendingTasks` list. Assign a unique ID automatically.
 * 2.  **Load Tasks to Queue:** Attempts to move tasks from the `pendingTasks` list to the `processingQueue`. Tasks are moved *only if* the `availableResourceUnits` is greater than or equal to the task's `requiredResourceUnits`. If a task is moved, the `availableResourceUnits` should be decreased by the task's requirement. Tasks that cannot be loaded remain in `pendingTasks`. This operation should iterate through `pendingTasks` and attempt to load *all* eligible tasks.
 * 3.  **Process Next Task:** Removes the next task from the `processingQueue` (if not empty), simulates processing (e.g., print a message), adds the task to the `completedTasks` list, and increases `availableResourceUnits` by the task's requirement.
 * 4.  **View System Status:** Displays the current `availableResourceUnits`, the list of `pendingTasks` (ID, description, resources), the tasks currently in the `processingQueue` (ID, description, resources), and the list of `completedTasks` (ID, description, resources).
 * 5.  **Exit:** Terminates the program.
 * 
 * **Requirements:**
 * 
 * Your solution must demonstrate advanced understanding of Java concepts by fulfilling all the following requirements:
 * 
 * 1.  Use `java.util.Queue` for the `processingQueue`.
 * 2.  Use `java.util.ArrayList` for `pendingTasks` and `completedTasks`.
 * 3.  Declare `pendingTasks` and `completedTasks` using the `java.util.List` interface type.
 * 4.  Use `java.util.Scanner` to read user input for menu choices and task details.
 * 5.  Use a `switch` statement to handle the user's menu selection.
 * 6.  Use `System.err` to display error messages (e.g., invalid input, trying to process an empty queue, insufficient resources during loading).
 * 7.  Use `System.out` for displaying the menu, prompts, system status, and successful operation messages.
 * 8.  Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors (e.g., non-integer input where an integer is expected). A single `try-catch` block around the main application loop is acceptable for demonstrating this.
 * 9.  Implement proper encapsulation for the `Task` class and the main system class (private fields, public methods).
 * 10. Use meaningful variable and method names.
 * 11. Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 * 12. Implement input validation (e.g., ensuring resource units are positive integers).
 * 13. Ensure proper error handling for specific scenarios (e.g., attempting to process from an empty queue, insufficient resources).
 * 14. Structure the code cleanly with separate classes where appropriate.
 * 
 * **Initial State:**
 * 
 * The system should start with a maximum of **10** `availableResourceUnits`.
 * 
 * **Expected Output:**
 * 
 * The system should print a menu, respond to user input, display status clearly, and use `System.err` for errors. Example interactions might look like:
 * 
 * ```
 * --- Task Processing System Menu ---
 * 1. Add New Task
 * 2. Load Tasks to Queue
 * 3. Process Next Task
 * 4. View System Status
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Data Analysis
 * Enter required resource units: 5
 * Task added: Task ID 1 - Data Analysis (Req: 5)
 * 
 * --- Task Processing System Menu ---
 * ...
 * Enter your choice: 1
 * Enter task description: Report Generation
 * Enter required resource units: 7
 * Task added: Task ID 2 - Report Generation (Req: 7)
 * 
 * --- Task Processing System Menu ---
 * ...
 * Enter your choice: 4
 * --- System Status ---
 * Available Resources: 10
 * Pending Tasks:
 *   ID 1 - Data Analysis (Req: 5)
 *   ID 2 - Report Generation (Req: 7)
 * Processing Queue: []
 * Completed Tasks: []
 * 
 * --- Task Processing System Menu ---
 * ...
 * Enter your choice: 2
 * Attempting to load tasks from pending...
 * Task ID 1 loaded to queue. Resources remaining: 5
 * Task ID 2 requires 7 resources, only 5 available. Keeping in pending.
 * Loading complete.
 * 
 * --- Task Processing System Menu ---
 * ...
 * Enter your choice: 4
 * --- System Status ---
 * Available Resources: 5
 * Pending Tasks:
 *   ID 2 - Report Generation (Req: 7)
 * Processing Queue: [Task ID 1 - Data Analysis (Req: 5)]
 * Completed Tasks: []
 * 
 * --- Task Processing System Menu ---
 * ...
 * Enter your choice: 3
 * Processing task from queue: Task ID 1 - Data Analysis (Req: 5)
 * Task ID 1 completed. Resources released. Available Resources: 10
 * 
 * --- Task Processing System Menu ---
 * ...
 * Enter your choice: 4
 * --- System Status ---
 * Available Resources: 10
 * Pending Tasks:
 *   ID 2 - Report Generation (Req: 7)
 * Processing Queue: []
 * Completed Tasks:
 *   ID 1 - Data Analysis (Req: 5)
 * 
 * --- Task Processing System Menu ---
 * ...
 * Enter your choice: 3
 * System.err: Error: Processing queue is empty.
 * 
 * --- Task Processing System Menu ---
 * ...
 * Enter your choice: 5
 * Exiting system.
 * ```
 * 
 * Implement the Java code to fulfill these requirements.
 *
 * EXPLANATION:
 * The provided solution implements a `TaskProcessingSystem` that simulates resource-aware task management using the required Java components and best practices.
 * 
 * **Key Concepts Demonstrated:**
 * 
 * 1.  **Object-Oriented Programming:** The problem is modeled using two classes: `Task` (representing the data for a task) and `TaskProcessingSystem` (managing the system's state and operations). Encapsulation is used with private fields and public getter methods in `Task`, and private fields with public/private methods in `TaskProcessingSystem`.
 * 2.  **Data Structures (`java.util`):**
 *     *   `java.util.Queue`: The `processingQueue` is implemented using `java.util.LinkedList`, which is a common class that implements the `Queue` interface. This ensures tasks are processed in FIFO order using methods like `offer()` (to add) and `poll()` (to remove from the front).
 *     *   `java.util.ArrayList`: `pendingTasks` and `completedTasks` are implemented using `java.util.ArrayList`, providing dynamic, ordered lists for storing tasks that are waiting or finished.
 *     *   `java.util.List`: `pendingTasks` and `completedTasks` are declared using the `List` interface type (`List<Task>`). This demonstrates programming to interfaces, making the code more flexible if a different `List` implementation were needed later.
 * 3.  **User Input (`java.util.Scanner`):** The `Scanner` class is used in the `run()` and `addTask()` methods to read integer and string input from the console.
 * 4.  **Control Flow (`switch`):** A `switch` statement in the `run()` method is used to direct the program's execution based on the user's integer menu choice, providing a clear and readable way to handle multiple options.
 * 5.  **Output Streams (`System.out`, `System.err`):**
 *     *   `System.out.println()` is used for standard output, such as displaying the menu, prompts, status updates, and success messages.
 *     *   `System.err.println()` is used specifically for displaying error messages, making them distinguishable from normal output, which is good practice for console applications.
 * 6.  **Exception Handling (`try-catch`):**
 *     *   A `try-catch(InputMismatchException)` block is used around the `scanner.nextInt()` calls in `run()` and `addTask()` to catch errors when the user enters non-integer input where an integer is expected. This prevents the program from crashing.
 *     *   A general `try-catch(Exception e)` block wraps the main `while` loop in the `run()` method. This provides class-wide exception handling, catching any unhandled exceptions that might occur during the execution of the menu options and preventing the program from terminating abruptly. The error message and stack trace are printed to `System.err`.
 * 7.  **Input Validation:** The `addTask()` method explicitly checks if `requiredResourceUnits` is positive, prompting the user again and using `System.err` if the input is invalid. The `processNextTask()` method checks if the `processingQueue` is empty before attempting to poll, preventing a `NullPointerException` or unexpected behavior and reporting the error via `System.err`. The `loadTasksToQueue()` method checks against `availableResourceUnits` before moving a task.
 * 8.  **Error Handling:** Specific error conditions like an empty queue or insufficient resources are checked for, and informative messages are printed to `System.err`.
 * 9.  **Code Structure and Best Practices:**
 *     *   Meaningful names are used for classes (`Task`, `TaskProcessingSystem`), variables (`pendingTasks`, `availableResourceUnits`, `nextTaskId`), and methods (`addTask`, `loadTasksToQueue`, `processNextTask`, `viewStatus`, `run`).
 *     *   Javadoc comments explain the purpose of classes and methods. Inline comments clarify specific logic where needed (e.g., consuming newline characters from `Scanner`).
 *     *   The code is organized logically with separate methods for each menu action, improving readability and maintainability.
 *     *   An `Iterator` is used in `loadTasksToQueue()` to safely remove elements from the `pendingTasks` list while iterating, avoiding `ConcurrentModificationException`.
 *     *   The `Scanner` is closed when the program exits.
 * 
 * This solution effectively combines the required Java components within a practical scenario, demonstrating proper handling of data structures, user interaction, control flow, and robust error management.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue and List
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;
import java.util.InputMismatchException;

/**
 * Represents a single task with ID, description, and resource requirements.
 */
class Task {
    private int id;
    private String description;
    private int requiredResourceUnits;

    /**
     * Constructs a new Task.
     *
     * @param id The unique identifier for the task.
     * @param description The description of the task.
     * @param requiredResourceUnits The resources required to process the task.
     */
    public Task(int id, String description, int requiredResourceUnits) {
        this.id = id;
        this.description = description;
        this.requiredResourceUnits = requiredResourceUnits;
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getRequiredResourceUnits() {
        return requiredResourceUnits;
    }

    /**
     * Provides a string representation of the Task.
     * @return String representation.
     */
    @Override
    public String toString() {
        return "ID " + id + " - " + description + " (Req: " + requiredResourceUnits + ")";
    }
}

/**
 * Manages the task processing system with resource allocation.
 */
public class TaskProcessingSystem {
    private List<Task> pendingTasks;
    private Queue<Task> processingQueue;
    private List<Task> completedTasks;
    private int availableResourceUnits;
    private static final int MAX_RESOURCES = 10; // Initial and maximum resources
    private int nextTaskId;
    private Scanner scanner;

    /**
     * Constructs the TaskProcessingSystem.
     * Initializes lists, queue, resources, and task ID counter.
     */
    public TaskProcessingSystem() {
        this.pendingTasks = new ArrayList<>();
        this.processingQueue = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>();
        this.availableResourceUnits = MAX_RESOURCES;
        this.nextTaskId = 1;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Processing System Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Load Tasks to Queue");
        System.out.println("3. Process Next Task");
        System.out.println("4. View System Status");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new task based on user input.
     * Handles input validation for resource units.
     */
    private void addTask() {
        System.out.print("Enter task description: ");
        scanner.nextLine(); // Consume newline left by previous nextInt/nextDouble
        String description = scanner.nextLine();

        int requiredResources = -1;
        while (requiredResources <= 0) {
            System.out.print("Enter required resource units: ");
            try {
                requiredResources = scanner.nextInt();
                if (requiredResources <= 0) {
                    System.err.println("Error: Resource units must be a positive integer.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number for resource units.");
                scanner.next(); // Consume the invalid input
            } finally {
                 // Consume the rest of the line if nextInt was successful
                 if (requiredResources > 0) scanner.nextLine();
            }
        }


        Task newTask = new Task(nextTaskId++, description, requiredResources);
        pendingTasks.add(newTask);
        System.out.println("Task added: " + newTask);
    }

    /**
     * Attempts to move tasks from pendingTasks to processingQueue
     * based on available resources.
     */
    private void loadTasksToQueue() {
        System.out.println("Attempting to load tasks from pending...");
        Iterator<Task> iterator = pendingTasks.iterator();
        int tasksLoadedCount = 0;

        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (availableResourceUnits >= task.getRequiredResourceUnits()) {
                processingQueue.offer(task); // Add to queue
                availableResourceUnits -= task.getRequiredResourceUnits(); // Decrease resources
                iterator.remove(); // Remove from pending list
                System.out.println("Task " + task.getId() + " loaded to queue. Resources remaining: " + availableResourceUnits);
                tasksLoadedCount++;
            } else {
                System.out.println("Task " + task.getId() + " requires " + task.getRequiredResourceUnits() +
                                   " resources, only " + availableResourceUnits + " available. Keeping in pending.");
            }
        }

        if (tasksLoadedCount == 0) {
            System.out.println("No tasks could be loaded to the queue.");
        }
        System.out.println("Loading complete.");
    }

    /**
     * Processes the next task from the processingQueue.
     * Releases resources upon completion.
     */
    private void processNextTask() {
        if (processingQueue.isEmpty()) {
            System.err.println("Error: Processing queue is empty. No tasks to process.");
            return;
        }

        Task taskToProcess = processingQueue.poll(); // Get and remove from queue
        System.out.println("Processing task from queue: " + taskToProcess);

        // Simulate processing...
        completedTasks.add(taskToProcess); // Add to completed list
        availableResourceUnits += taskToProcess.getRequiredResourceUnits(); // Release resources

        System.out.println("Task " + taskToProcess.getId() + " completed. Resources released. Available Resources: " + availableResourceUnits);
    }

    /**
     * Displays the current state of the system: resources, pending, queue, and completed tasks.
     */
    private void viewStatus() {
        System.out.println("\n--- System Status ---");
        System.out.println("Available Resources: " + availableResourceUnits);

        System.out.println("Pending Tasks:");
        if (pendingTasks.isEmpty()) {
            System.out.println("  (None)");
        } else {
            for (Task task : pendingTasks) {
                System.out.println("  " + task);
            }
        }

        System.out.println("Processing Queue: " + processingQueue); // Queue's toString is often useful

        System.out.println("Completed Tasks:");
        if (completedTasks.isEmpty()) {
            System.out.println("  (None)");
        } else {
            for (Task task : completedTasks) {
                System.out.println("  " + task);
            }
        }
    }

    /**
     * Runs the main application loop, displaying the menu and handling user input.
     * Includes class-wide exception handling.
     */
    public void run() {
        int choice = -1;
        while (choice != 5) {
            displayMenu();
            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        loadTasksToQueue();
                        break;
                    case 3:
                        processNextTask();
                        break;
                    case 4:
                        viewStatus();
                        break;
                    case 5:
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number for your choice.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to stay in the loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions during operation
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging
            }
        }
        scanner.close(); // Close the scanner when exiting
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
