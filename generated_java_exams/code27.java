/*
 * Exam Question #27
 * Generated on: 2025-05-11 21:46:22
 * 
 * QUESTION:
 * **Java Programming Exam Task: Advanced Task Processing System**
 * 
 * **Problem Description:**
 * 
 * You are tasked with building a simple command-line based system to manage and process tasks. The system should allow users to add new tasks to a queue, process the next task in the queue, view the tasks currently waiting, and view a history of tasks that have been completed.
 * 
 * The system must adhere to the following requirements:
 * 
 * 1.  **Task Representation:** Create a `Task` class with private fields for a unique integer `id`, a `String` `description`, and a `String` `status` (e.g., "PENDING", "COMPLETED"). Include a constructor and public getter methods for these fields. Add a method `markCompleted()` that changes the task's status to "COMPLETED".
 * 2.  **System Structure:** Create a class named `TaskProcessorSystem` that manages the task queue and history.
 * 3.  **Data Structures:**
 *     *   Use a `java.util.Queue` (specifically, a `java.util.LinkedList` implementation) to hold tasks waiting to be processed. Tasks should be processed in First-In, First-Out (FIFO) order.
 *     *   Use a `java.util.List` (specifically, a `java.util.ArrayList` implementation) to store tasks after they have been processed.
 * 4.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Implement a menu-driven interface with the following options:
 *         1.  Add New Task: Prompts the user for a task description and adds a new `Task` object with a unique ID and "PENDING" status to the processing queue.
 *         2.  Process Next Task: Removes the task at the front of the queue, marks its status as "COMPLETED", and adds it to the completed history list. If the queue is empty, display an appropriate error message.
 *         3.  View Current Queue: Displays all tasks currently in the processing queue in their current order. Indicate if the queue is empty.
 *         4.  View Completed History: Displays all tasks in the completed history list. Indicate if the history is empty.
 *         5.  Exit: Terminates the program.
 *     *   Use a `switch` statement to handle the user's menu selection.
 * 5.  **Output:**
 *     *   Use `System.out.println` for all normal output (menu, prompts, task details, success messages).
 *     *   Use `System.err.println` for all error messages (e.g., invalid menu choice, queue empty for processing, invalid input type).
 * 6.  **Error Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks within the main execution loop to catch potential issues, particularly related to user input (e.g., non-integer input when expecting an integer). The system should recover gracefully from input errors and continue running.
 *     *   Validate user input where necessary (e.g., ensure task description is not empty).
 * 7.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Ensure clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, accept user input, perform the requested action, and display relevant output or error messages. The output for viewing the queue and history should clearly list the tasks with their ID, description, and status. Error messages should be distinct (using `System.err`).
 * 
 * Example interaction flow:
 * 
 * ```
 * --- Task Processor Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Current Queue
 * 4. View Completed History
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Write exam question
 * Task added: 1
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: 1
 * Enter task description: Create solution code
 * Task added: 2
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: 3
 * 
 * --- Current Task Queue ---
 * 1. [ID:1] Write exam question (PENDING)
 * 2. [ID:2] Create solution code (PENDING)
 * --------------------------
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: 2
 * Processing Task 1: Write exam question
 * Task 1 completed and moved to history.
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: 3
 * 
 * --- Current Task Queue ---
 * 1. [ID:2] Create solution code (PENDING)
 * --------------------------
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: 4
 * 
 * --- Completed Task History ---
 * 1. [ID:1] Write exam question (COMPLETED)
 * ----------------------------
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number.
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: 2
 * Processing Task 2: Create solution code
 * Task 2 completed and moved to history.
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: 2
 * Error: No tasks in the queue to process.
 * 
 * --- Task Processor Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Task Processor. Goodbye!
 * ```
 * 
 * Your solution should consist of the complete Java code for the `Task` and `TaskProcessorSystem` classes, demonstrating correct usage of all required components and adherence to best practices.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`.
 * *   Correct usage of `System.out` and `System.err`.
 * *   Effective implementation of `try-catch` for error handling, especially input validation.
 * *   Proper encapsulation and code structure.
 * *   Meaningful naming and comments.
 * *   Correct implementation of task adding, processing, and viewing logic.
 * *   Handling of edge cases (e.g., empty queue/history).
 *
 * EXPLANATION:
 * This solution implements a simple Task Processing System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Task` Class:**
 *     *   Encapsulates task data (`id`, `description`, `status`) using private fields.
 *     *   Provides public getter methods (`getId`, `getDescription`, `getStatus`) for controlled access.
 *     *   Includes a `markCompleted` method to change the task status, demonstrating object behavior.
 *     *   Overrides `toString()` for easy printing of task details.
 * 
 * 2.  **`TaskProcessorSystem` Class:**
 *     *   **Data Structures:**
 *         *   `processingQueue`: Declared as `Queue<Task>` and initialized with `new LinkedList<>()`. This adheres to the requirement of using `Queue` and an implementation (`LinkedList`) suitable for FIFO operations (add to end, remove from front).
 *         *   `completedHistory`: Declared as `List<Task>` and initialized with `new ArrayList<>()`. This adheres to the requirement of using the `List` interface and an implementation (`ArrayList`) suitable for storing a dynamic list of completed items.
 *     *   **`Scanner`:** An instance is created to read user input from `System.in`. It's closed in the `finally` block of the `run` method to release system resources.
 *     *   **`nextTaskId`:** A simple counter to generate unique IDs for new tasks.
 *     *   **Methods:**
 *         *   `addTask(String description)`: Creates a new `Task` object and adds it to the `processingQueue` using `offer()`. Includes basic validation for the description.
 *         *   `processNextTask()`: Uses `poll()` to retrieve and remove the next task from the `processingQueue`. It checks if the result is `null` (queue is empty) and uses `System.err` for the error message. If a task is retrieved, its `markCompleted()` method is called, and the task is added to the `completedHistory` list.
 *         *   `viewQueue()`: Iterates through the `processingQueue` using an enhanced for loop (which doesn't remove elements) and prints each task's details. Checks for an empty queue.
 *         *   `viewHistory()`: Iterates through the `completedHistory` list and prints each task's details. Checks for an empty history.
 *         *   `displayMenu()`: A helper method to print the menu options using `System.out`.
 *     *   **`run()` Method:**
 *         *   Contains the main application loop (`while(running)`).
 *         *   **Class-wide Exception Handling:** A large `try-catch` block wraps the core logic within the `while` loop. This demonstrates handling exceptions that might occur during the program's execution.
 *         *   **Input Handling & Validation:**
 *             *   Inside the main `try` block, there's a nested `try-catch` specifically for reading the menu choice (`scanner.nextInt()`).
 *             *   `InputMismatchException` is caught if the user enters non-integer input. An error message is printed using `System.err`, and `scanner.nextLine()` is called to consume the invalid input line, preventing an infinite loop. `continue` skips to the next loop iteration, redisplaying the menu.
 *             *   Other potential `Scanner` exceptions (`NoSuchElementException`, `IllegalStateException`) are also caught.
 *             *   A general `catch (Exception e)` block is included outside the nested input-specific catch. This serves as a broader catch for any other unexpected runtime errors that might occur within the `try` block, fulfilling the "class-wide" requirement by catching exceptions at the main operational level.
 *         *   **`switch` Statement:** Used to direct program flow based on the valid user input (`choice`), calling the appropriate methods for each menu option.
 *         *   **`finally` Block:** Ensures the `scanner` is closed when the `try` block is exited (either normally or due to an exception), which is important for resource management.
 *     *   **`main()` Method:** The entry point of the application, creating a `TaskProcessorSystem` instance and calling its `run()` method to start the system.
 * 
 * This solution effectively integrates all required Java components within a practical scenario, demonstrating proper object-oriented design, data structure usage, user interaction handling, and robust error management.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Represents a single task with an ID, description, and status.
 */
class Task {
    private int id;
    private String description;
    private String status; // e.g., "PENDING", "COMPLETED"

    /**
     * Constructs a new Task.
     *
     * @param id          The unique ID of the task.
     * @param description The description of the task.
     * @param status      The initial status of the task (e.g., "PENDING").
     */
    public Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    // --- Getters ---

    /**
     * Gets the unique ID of the task.
     *
     * @return The task ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the current status of the task.
     *
     * @return The task status ("PENDING" or "COMPLETED").
     */
    public String getStatus() {
        return status;
    }

    /**
     * Marks the task as completed.
     */
    public void markCompleted() {
        this.status = "COMPLETED";
    }

    /**
     * Provides a string representation of the task.
     *
     * @return A formatted string for the task.
     */
    @Override
    public String toString() {
        return "[ID:" + id + "] " + description + " (" + status + ")";
    }
}

/**
 * Manages a queue of tasks to be processed and a history of completed tasks.
 * Provides a command-line interface for interaction.
 */
public class TaskProcessorSystem {
    private Queue<Task> processingQueue;
    private List<Task> completedHistory;
    private Scanner scanner;
    private int nextTaskId; // To generate unique IDs for tasks

    /**
     * Constructs a new TaskProcessorSystem, initializing the queue, history,
     * scanner, and task ID counter.
     */
    public TaskProcessorSystem() {
        // Use LinkedList as an implementation of Queue for FIFO behavior
        processingQueue = new LinkedList<>();
        // Use ArrayList as an implementation of List for storing history
        completedHistory = new ArrayList<>();
        scanner = new Scanner(System.in);
        nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the processing queue.
     *
     * @param description The description of the task.
     */
    public void addTask(String description) {
        // Input validation: Ensure description is not null or empty
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }
        Task newTask = new Task(nextTaskId++, description.trim(), "PENDING");
        processingQueue.offer(newTask); // offer is the preferred way to add to a queue
        System.out.println("Task added: " + newTask.getId());
    }

    /**
     * Processes the next task from the queue (FIFO).
     * Removes the task, marks it completed, and adds it to history.
     */
    public void processNextTask() {
        // poll retrieves and removes the head of the queue, returns null if empty
        Task taskToProcess = processingQueue.poll();
        if (taskToProcess == null) {
            // Use System.err for error message
            System.err.println("Error: No tasks in the queue to process.");
            return;
        }
        // Simulate processing and update status
        System.out.println("Processing Task " + taskToProcess.getId() + ": " + taskToProcess.getDescription());
        taskToProcess.markCompleted(); // Mark the task as completed
        completedHistory.add(taskToProcess); // Add to the history list
        System.out.println("Task " + taskToProcess.getId() + " completed and moved to history.");
    }

    /**
     * Displays all tasks currently in the processing queue.
     */
    public void viewQueue() {
        System.out.println("\n--- Current Task Queue ---");
        if (processingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            int index = 1;
            for (Task task : processingQueue) {
                System.out.println(index++ + ". " + task); // Using Task's toString()
            }
        }
        System.out.println("--------------------------");
    }

    /**
     * Displays all tasks in the completed history.
     */
    public void viewHistory() {
        System.out.println("\n--- Completed Task History ---");
        if (completedHistory.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            // Iterate through the history list
            int index = 1;
            for (Task task : completedHistory) {
                System.out.println(index++ + ". " + task); // Using Task's toString()
            }
        }
        System.out.println("----------------------------");
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Processor Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Current Queue");
        System.out.println("4. View Completed History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop, handling user interaction and menu choices.
     * Includes class-wide exception handling for input and general errors.
     */
    public void run() {
        boolean running = true;
        // Class-wide try-catch block wrapping the main operational loop
        try {
            while (running) {
                displayMenu();
                int choice = -1; // Initialize choice to an invalid value

                try {
                    // Attempt to read integer input for menu choice
                    choice = scanner.nextInt();
                    // Consume the newline character left by nextInt()
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    // Handle non-integer input error
                    System.err.println("Error: Invalid input. Please enter a number.");
                    // Consume the invalid input to prevent infinite loop
                    scanner.nextLine();
                    // Continue to the next iteration to display the menu again
                    continue;
                } catch (NoSuchElementException | IllegalStateException e) {
                     // Handle potential errors if scanner is closed or input is exhausted unexpectedly
                     System.err.println("Error reading input: " + e.getMessage());
                     running = false; // Exit the loop on critical scanner error
                     break; // Exit switch and loop
                }


                // Use switch statement for menu control
                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        // Read the full line for the description
                        String description = scanner.nextLine();
                        addTask(description); // Method includes validation
                        break;
                    case 2:
                        processNextTask();
                        break;
                    case 3:
                        viewQueue();
                        break;
                    case 4:
                        viewHistory();
                        break;
                    case 5:
                        System.out.println("Exiting Task Processor. Goodbye!");
                        running = false; // Set flag to exit loop
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // General catch block for any other unexpected runtime exceptions
            // This provides a form of class-wide handling for errors not specific to input
            System.err.println("An unexpected system error occurred: " + e.getMessage());
            // Optionally print stack trace for debugging: e.printStackTrace();
        } finally {
            // Ensure scanner is closed when the application exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * The main method to start the Task Processor System.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskProcessorSystem system = new TaskProcessorSystem();
        system.run(); // Start the main application loop
    }
}
