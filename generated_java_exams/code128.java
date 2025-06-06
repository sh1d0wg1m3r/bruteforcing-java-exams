/*
 * Exam Question #128
 * Generated on: 2025-05-11 22:18:42
 * Generated by: Account 2
 * 
 * QUESTION:
 * **Java Programming Exam Task: Advanced Task Management System**
 * 
 * **Problem Description:**
 * 
 * You are required to develop a console-based Task Management System. This system will allow users to add new tasks, process the next available task, and view all tasks currently in the system. The system should prioritize tasks for processing in the order they were added (First-In, First-Out).
 * 
 * **System Requirements:**
 * 
 * 1.  **Task Representation:** Create a class `Task` to represent a single task. Each task must have:
 *     *   A unique integer ID.
 *     *   A description (String).
 *     *   A status (String, e.g., "PENDING", "COMPLETED").
 * 2.  **Task Management Logic:** Create a class `TaskManager` responsible for managing tasks. This class must:
 *     *   Maintain a collection of all tasks added to the system.
 *     *   Maintain a queue of tasks that are ready for processing.
 *     *   Provide methods to:
 *         *   `addTask(String description)`: Creates a new `Task` with a unique ID, adds it to the collection of all tasks, and adds it to the processing queue.
 *         *   `processNextTask()`: Retrieves the next task from the processing queue, updates its status to "COMPLETED", and prints a success message. If the queue is empty, it should report an error.
 *         *   `listAllTasks()`: Displays details (ID, Description, Status) of all tasks ever added to the system.
 * 3.  **User Interface:** Implement a simple console interface in a main class (e.g., `TaskManagementApp`). This interface should:
 *     *   Present a menu of options to the user (Add Task, Process Task, List Tasks, Exit).
 *     *   Read user input using `java.util.Scanner`.
 *     *   Use a `switch` statement to handle the different menu options.
 *     *   Loop until the user chooses to exit.
 * 4.  **Error Handling & Validation:**
 *     *   Use `System.err` to display error messages (e.g., invalid menu choice, trying to process an empty queue, invalid task description input).
 *     *   Use `System.out` for all normal output (menu, prompts, task details, success messages).
 *     *   Implement input validation (e.g., ensure task description is not empty, handle non-numeric input for menu choice gracefully).
 *     *   Implement class-wide exception handling using `try-catch` blocks to manage potential runtime errors within the main application loop.
 * 
 * **Required Java Components:**
 * 
 * Your solution **must** use and demonstrate understanding of the following Java components:
 * 
 * *   `java.util.Queue` (specifically for the processing queue)
 * *   `java.util.ArrayList` (as the concrete implementation for storing all tasks)
 * *   `java.util.List` (as the interface type for the collection of all tasks)
 * *   `java.util.Scanner`
 * *   `switch` statement
 * *   `System.err`
 * *   `System.out`
 * *   `try-catch` blocks for exception handling
 * 
 * **Best Practices:**
 * 
 * *   Apply proper encapsulation (private fields, public methods).
 * *   Use meaningful variable and method names.
 * *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 * *   Ensure clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt for input, and perform actions based on the user's choice. Example interactions:
 * 
 * ```
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 1
 * Enter task description: Write exam question
 * Task added successfully with ID 1.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 1
 * Enter task description: Grade student papers
 * Task added successfully with ID 2.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 3
 * --- All Tasks ---
 * ID: 1, Description: Write exam question, Status: PENDING
 * ID: 2, Description: Grade student papers, Status: PENDING
 * --- End of Tasks ---
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 2
 * Processing task ID 1: Write exam question. Status updated to COMPLETED.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 3
 * --- All Tasks ---
 * ID: 1, Description: Write exam question, Status: COMPLETED
 * ID: 2, Description: Grade student papers, Status: PENDING
 * --- End of Tasks ---
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 5
 * Invalid choice. Please enter a number between 1 and 4.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 2
 * Processing task ID 2: Grade student papers. Status updated to COMPLETED.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 2
 * Error: No tasks in the processing queue.
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. List All Tasks
 * 4. Exit
 * Enter your choice: 4
 * Exiting Task Management System.
 * ```
 * 
 * Your solution should be a single `.java` file containing all necessary classes.
 *
 * EXPLANATION:
 * This solution implements a simple Task Management System demonstrating the required Java concepts.
 * 
 * 1.  **Task Class:** Represents the data structure for a task with `taskId`, `description`, and `status`. Encapsulation is used by making fields `private` and providing `public` getters and a setter. The constructor includes basic validation for the description. `toString()` provides a convenient way to display task information.
 * 2.  **TaskManager Class:** This class orchestrates the task management logic.
 *     *   It uses a `List<Task>` variable named `allTasks`, initialized with `new ArrayList<>()`. This fulfills the requirement of using `List` as the interface type and `ArrayList` as the concrete implementation for storing all tasks.
 *     *   It uses a `Queue<Task>` variable named `processingQueue`, initialized with `new LinkedList<>()`. `LinkedList` is a common implementation of the `Queue` interface, satisfying the requirement to use `Queue`. This queue manages tasks in a First-In, First-Out manner for processing.
 *     *   `nextTaskId` is used to generate unique IDs for new tasks.
 *     *   `addTask(String description)`: Creates a `Task` object. It adds the task to *both* `allTasks` (for the complete history/listing) and `processingQueue` (making it available for processing). It includes a `try-catch` block to handle potential `IllegalArgumentException` from the `Task` constructor or other unforeseen issues during addition.
 *     *   `processNextTask()`: Checks if the `processingQueue` is empty. If not, it uses `processingQueue.poll()` to retrieve and remove the task at the head of the queue. It then updates the status of this task (the reference in `allTasks` is the same object, so the status change is reflected there too). If the queue is empty, it prints an error to `System.err`.
 *     *   `listAllTasks()`: Iterates through the `allTasks` `List` and prints the details of each task using its `toString()` method.
 * 3.  **TaskManagementApp Class (Main):**
 *     *   The `main` method serves as the application's entry point and user interface.
 *     *   A `Scanner` is used to read user input from the console.
 *     *   A `TaskManager` instance is created to handle the task logic.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   Inside the loop, a menu is displayed using `System.out`.
 *     *   User input is read using `scanner.nextLine()`.
 *     *   A `try-catch` block is used around the input parsing and `switch` statement. This demonstrates class-wide exception handling, specifically catching `NumberFormatException` if the user enters non-numeric input for the menu choice, and a general `Exception` for any other unexpected errors that might occur during an iteration. Error messages for exceptions are printed to `System.err`.
 *     *   A `switch` statement handles the user's choice:
 *         *   Cases 1, 2, and 3 call the corresponding methods in the `TaskManager`.
 *         *   Case 4 sets the `running` flag to `false` to exit the loop.
 *         *   The `default` case handles invalid integer inputs, printing an error to `System.err`.
 *     *   Input validation for the task description is implicitly handled by the `Task` constructor and the `try-catch` in `addTask`.
 *     *   Finally, the `Scanner` is closed outside the loop when the application exits.
 * 
 * This solution effectively integrates all the required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) into a functional, albeit simple, task management system, adhering to best practices like encapsulation, meaningful names, and basic error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Represents a single task with an ID, description, and status.
 */
class Task {
    private int taskId;
    private String description;
    private String status; // e.g., "PENDING", "COMPLETED"

    /**
     * Constructs a new Task.
     * @param taskId The unique identifier for the task.
     * @param description The description of the task.
     */
    public Task(int taskId, String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        this.taskId = taskId;
        this.description = description.trim();
        this.status = "PENDING"; // Default status
    }

    // --- Getters ---
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // --- Setter ---
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Task.
     * @return A formatted string showing task details.
     */
    @Override
    public String toString() {
        return "ID: " + taskId + ", Description: " + description + ", Status: " + status;
    }
}

/**
 * Manages a collection of tasks and a processing queue.
 */
class TaskManager {
    // List to hold all tasks ever added to the system (using ArrayList as concrete implementation)
    private List<Task> allTasks;
    // Queue to hold tasks ready for processing (using LinkedList as concrete implementation)
    private Queue<Task> processingQueue;
    private int nextTaskId; // Counter for generating unique task IDs

    /**
     * Constructs a new TaskManager.
     */
    public TaskManager() {
        this.allTasks = new ArrayList<>(); // Required use of ArrayList
        this.processingQueue = new LinkedList<>(); // LinkedList implements Queue
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the system.
     * @param description The description of the task to add.
     */
    public void addTask(String description) {
        try {
            Task newTask = new Task(nextTaskId, description);
            allTasks.add(newTask); // Add to the list of all tasks
            processingQueue.offer(newTask); // Add to the processing queue (FIFO)
            System.out.println("Task added successfully with ID " + newTask.getTaskId() + ".");
            nextTaskId++; // Increment for the next task
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding task: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions during task creation/addition
            System.err.println("An unexpected error occurred while adding the task: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    /**
     * Processes the next task in the queue.
     */
    public void processNextTask() {
        if (processingQueue.isEmpty()) {
            System.err.println("Error: No tasks in the processing queue.");
            return;
        }

        // Retrieve the next task from the head of the queue
        Task taskToProcess = processingQueue.poll();

        if (taskToProcess != null) {
            // Update the status of the task (it's already in allTasks list by reference)
            taskToProcess.setStatus("COMPLETED");
            System.out.println("Processing task ID " + taskToProcess.getTaskId() + ": " + taskToProcess.getDescription() + ". Status updated to COMPLETED.");
        } else {
             // Should not happen if isEmpry() check passes, but good defensive programming
             System.err.println("An internal error occurred: Failed to retrieve task from queue.");
        }
    }

    /**
     * Lists all tasks currently in the system.
     */
    public void listAllTasks() {
        if (allTasks.isEmpty()) {
            System.out.println("No tasks have been added yet.");
            return;
        }

        System.out.println("--- All Tasks ---");
        // Iterate through the list of all tasks and print their details
        for (Task task : allTasks) {
            System.out.println(task); // Uses Task's toString() method
        }
        System.out.println("--- End of Tasks ---");
    }
}

/**
 * Main application class for the Task Management System.
 * Handles user interaction and menu processing.
 */
public class TaskManagementApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        boolean running = true;

        System.out.println("--- Welcome to Task Management System ---");

        // Main application loop
        while (running) {
            printMenu(); // Display menu
            System.out.print("Enter your choice: ");

            String input = scanner.nextLine(); // Read user input as a line

            // Use try-catch for robust input handling, specifically NumberFormatException
            try {
                int choice = Integer.parseInt(input); // Attempt to parse input as integer

                // Use switch statement for menu option handling
                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        manager.addTask(description); // Call TaskManager method
                        break;
                    case 2:
                        manager.processNextTask(); // Call TaskManager method
                        break;
                    case 3:
                        manager.listAllTasks(); // Call TaskManager method
                        break;
                    case 4:
                        running = false; // Set flag to exit loop
                        System.out.println("Exiting Task Management System.");
                        break;
                    default:
                        // Handle invalid integer choices
                        System.err.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                // Handle non-integer input
                System.err.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                // Catch any other unexpected exceptions during the loop iteration
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging
            }
            System.out.println(); // Add a newline for better readability between iterations
        }

        scanner.close(); // Close the scanner when done
        System.out.println("Goodbye!");
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. List All Tasks");
        System.out.println("4. Exit");
    }
}
