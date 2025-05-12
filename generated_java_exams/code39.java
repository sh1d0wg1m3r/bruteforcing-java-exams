/*
 * Exam Question #39
 * Generated on: 2025-05-11 21:56:45
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple command-line based system for managing tasks. The system should allow users to add new tasks, process the next available task, view tasks that are waiting to be processed, and view tasks that have already been processed (either successfully completed or failed). The system should be robust, handling user input and potential task processing errors gracefully.
 * 
 * **Functional Requirements:**
 * 
 * 1.  **Add Task:** Allow the user to add a new task by providing a description. New tasks are added to a waiting queue.
 * 2.  **Process Next Task:** Take the next task from the waiting queue and simulate processing it. Task processing might occasionally fail.
 * 3.  **View Pending Tasks:** Display all tasks currently in the waiting queue.
 * 4.  **View Processed Tasks:** Display all tasks that have been processed, indicating whether they were completed or failed.
 * 5.  **Exit:** Terminate the program.
 * 
 * **Technical Requirements:**
 * 
 * Your solution MUST adhere to the following:
 * 
 * 1.  Utilize `java.util.Queue` to store tasks waiting for processing.
 * 2.  Utilize `java.util.ArrayList` to store tasks that have been processed (completed or failed).
 * 3.  Utilize `java.util.List` as the type declaration for the collection storing processed tasks.
 * 4.  Use `java.util.Scanner` to read user input from the console.
 * 5.  Employ a `switch` statement to handle the user's menu choices.
 * 6.  Use `System.err` exclusively for displaying error messages (e.g., invalid input, task processing failure).
 * 7.  Use `System.out` for all other output (menu, task details, success messages).
 * 8.  Implement class-wide exception handling using `try-catch` blocks to manage potential issues during input reading or task processing.
 * 
 * **Design and Best Practices:**
 * 
 * *   Create separate classes where appropriate (e.g., a `Task` class and a `TaskScheduler` class).
 * *   Implement proper encapsulation (private fields, public methods).
 * *   Use meaningful variable and method names.
 * *   Include basic input validation (e.g., ensuring task description is not empty, menu choice is valid).
 * *   Provide appropriate comments and documentation (e.g., Javadoc for classes and methods).
 * *   Structure the code cleanly.
 * 
 * **Task Processing Simulation:**
 * 
 * For the "Process Next Task" functionality, simulate processing. You can, for instance, have a small chance (e.g., 20%) that processing a task will "fail". If it fails, catch a custom or standard exception and mark the task as failed. Otherwise, mark it as completed.
 * 
 * **User Interface:**
 * 
 * The system should present a menu like this:
 * 
 * ```
 * Task Management System Menu:
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Processed Tasks
 * 5. Exit
 * Enter your choice:
 * ```
 * 
 * **Expected Output:**
 * 
 * *   Adding a task should confirm the task was added.
 * *   Processing a task should indicate which task was processed and whether it succeeded or failed. If the queue is empty, it should report that.
 * *   Viewing pending tasks should list them in the order they would be processed.
 * *   Viewing processed tasks should list them with their final status (Completed/Failed).
 * *   Invalid input should result in an error message on `System.err`.
 * *   Processing failure should be reported on `System.out` with details and an error message on `System.err` indicating the failure reason (simulated).
 * 
 * **Evaluation:**
 * 
 * Your solution will be evaluated on:
 * *   Correct implementation and usage of all required Java components.
 * *   Adherence to functional and technical requirements.
 * *   Quality of code design, encapsulation, naming, and documentation.
 * *   Effectiveness of input validation and error handling.
 * *   Clarity and correctness of output.
 * 
 * **Time Limit:** Approximately 45-60 minutes.
 *
 * EXPLANATION:
 * The solution implements a simple command-line Task Management System, demonstrating the required Java concepts.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents a single task with an auto-generated `id`, a `description`, and a `status` (using an `enum` `TaskStatus`).
 *     *   Uses a static counter `nextId` for unique IDs, demonstrating a simple class-level variable usage.
 *     *   The constructor includes basic input validation for the description, throwing an `IllegalArgumentException`.
 *     *   The `process()` method simulates work and has a chance of throwing a `TaskProcessingException` to demonstrate handling specific failure scenarios.
 *     *   Includes standard getters and a `toString()` method for easy representation.
 * 
 * 2.  **`TaskScheduler` Class:**
 *     *   This is the main class that orchestrates the system.
 *     *   It holds the tasks in two collections:
 *         *   `taskQueue`: Declared as `Queue<Task>` and instantiated as `LinkedList<Task>`. `Queue` is used because tasks are processed in FIFO (First-In, First-Out) order using `offer()` to add and `poll()` to remove/retrieve.
 *         *   `processedTasks`: Declared as `List<Task>` and instantiated as `ArrayList<Task>`. `List` is used as the interface type to adhere to the requirement, while `ArrayList` provides the concrete implementation for storing processed tasks (order matters for viewing history, and random access/iteration is common).
 *     *   `scanner`: An instance of `Scanner` is used for reading user input throughout the application's lifecycle, managed within the `TaskScheduler` instance.
 *     *   **`addTask()`:** Reads the task description from the user. It uses a `try-catch` block to handle the `IllegalArgumentException` from the `Task` constructor if the description is invalid, printing the error to `System.err`. Valid tasks are added to the `taskQueue` using `offer()`.
 *     *   **`processNextTask()`:** Uses `taskQueue.poll()` to get the next task. If the queue is empty (`poll()` returns `null`), it informs the user. Otherwise, it calls the task's `process()` method within a `try-catch` block.
 *         *   If `process()` succeeds, the task status is set to `COMPLETED`, and the task is added to the `processedTasks` list.
 *         *   If `process()` throws `TaskProcessingException`, the task status is set to `FAILED`, added to `processedTasks`, a success message is printed to `System.out` (reporting the failure), and the specific failure reason is printed to `System.err`.
 *         *   A general `catch (Exception e)` is included to handle any other unexpected errors during processing, marking the task as `FAILED` and reporting the details to `System.err`.
 *     *   **`viewPendingTasks()`:** Iterates through the `taskQueue` (without removing elements) and prints each pending task to `System.out`.
 *     *   **`viewProcessedTasks()`:** Iterates through the `processedTasks` `List` and prints each completed or failed task to `System.out`.
 *     *   **`displayMenu()`:** A helper method to print the menu options to `System.out`.
 *     *   **`run()`:** This is the main application loop. It repeatedly displays the menu, reads user input using the `scanner`, and uses a `switch` statement to delegate the action based on the user's choice.
 *         *   Input reading is wrapped in a `try-catch` block to handle potential non-integer input, reporting the error to `System.err` and consuming the invalid input using `scanner.nextLine()`.
 *         *   The `switch` statement handles cases 1-5, calling the appropriate methods. A `default` case handles invalid numeric choices, printing an error to `System.err`.
 *         *   A broader `catch (Exception e)` is included around the switch logic to catch any unexpected runtime errors that might occur within the menu loop itself, reporting them to `System.err`.
 *     *   **`main()`:** The entry point of the program, which creates a `TaskScheduler` instance and calls its `run()` method. The `scanner` is closed when the `run` method finishes (when the user chooses option 5).
 * 
 * **Usage of Required Components:**
 * 
 * *   `Queue`: `taskQueue` is a `Queue` (implemented by `LinkedList`) storing pending tasks. `offer()` and `poll()` methods are used.
 * *   `ArrayList`: `processedTasks` is instantiated as `ArrayList`.
 * *   `List`: `processedTasks` is declared using the `List` interface type.
 * *   `Scanner`: Used in `TaskScheduler` to read user input in the `run()` and `addTask()` methods.
 * *   `Switch statement`: Used in the `run()` method to navigate the menu options.
 * *   `System.err`: Used exclusively for printing error messages (invalid input, task processing failures, unexpected exceptions).
 * *   `System.out`: Used for all normal output (menu, prompts, task details, success/failure notifications).
 * *   `try-catch`: Used in `addTask()` for input validation exceptions, in `processNextTask()` for simulated task processing exceptions (`TaskProcessingException` and general `Exception`), and in `run()` to handle potential input errors and unexpected errors during the main loop execution. Exception handling is present across multiple methods, demonstrating class-wide handling.
 * 
 * This solution provides a clear structure, uses appropriate data structures for the problem domain, demonstrates input validation and robust error handling using `try-catch` and appropriate output streams (`System.out`, `System.err`), and adheres to good programming practices like encapsulation and meaningful naming.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random; // For simulating task failure

// Custom exception for simulating task processing failure
class TaskProcessingException extends Exception {
    public TaskProcessingException(String message) {
        super(message);
    }
}

// Enum to represent task status
enum TaskStatus {
    PENDING,
    COMPLETED,
    FAILED
}

// Represents a single task
class Task {
    private static int nextId = 1; // For unique task IDs
    private int id;
    private String description;
    private TaskStatus status;

    public Task(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        this.id = nextId++;
        this.description = description.trim();
        this.status = TaskStatus.PENDING;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    // Simulate task processing - might throw an exception
    public void process() throws TaskProcessingException {
        Random random = new Random();
        // Simulate a 20% chance of failure
        if (random.nextDouble() < 0.2) {
            throw new TaskProcessingException("Simulated processing failure for task ID " + id);
        }
        // If successful, status will be set to COMPLETED by the scheduler
    }

    @Override
    public String toString() {
        return "Task [ID=" + id + ", Desc='" + description + "', Status=" + status + "]";
    }
}

// Manages the task queue and processed tasks
class TaskScheduler {
    private Queue<Task> taskQueue;
    private List<Task> processedTasks; // Using List interface, implemented by ArrayList
    private Scanner scanner;

    public TaskScheduler() {
        this.taskQueue = new LinkedList<>(); // LinkedList implements Queue
        this.processedTasks = new ArrayList<>(); // ArrayList implements List
        this.scanner = new Scanner(System.in);
    }

    // Adds a new task to the queue
    public void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        try {
            Task newTask = new Task(description);
            taskQueue.offer(newTask); // offer is preferred over add for queues (returns boolean)
            System.out.println("Task added: " + newTask.getDescription());
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding task: " + e.getMessage());
        } catch (Exception e) {
             System.err.println("An unexpected error occurred while adding task: " + e.getMessage());
        }
    }

    // Processes the next task in the queue
    public void processNextTask() {
        Task taskToProcess = taskQueue.poll(); // poll retrieves and removes the head of the queue
        if (taskToProcess == null) {
            System.out.println("No tasks in the queue to process.");
            return;
        }

        System.out.println("Processing task: " + taskToProcess.getDescription() + " (ID: " + taskToProcess.getId() + ")");
        try {
            taskToProcess.process(); // Simulate processing
            taskToProcess.setStatus(TaskStatus.COMPLETED);
            processedTasks.add(taskToProcess);
            System.out.println("Task ID " + taskToProcess.getId() + " processed successfully.");
        } catch (TaskProcessingException e) {
            taskToProcess.setStatus(TaskStatus.FAILED);
            processedTasks.add(taskToProcess);
            System.out.println("Task ID " + taskToProcess.getId() + " processing failed.");
            System.err.println("Failure reason: " + e.getMessage()); // Use System.err for the error detail
        } catch (Exception e) {
            taskToProcess.setStatus(TaskStatus.FAILED); // Mark as failed on unexpected errors too
            processedTasks.add(taskToProcess);
            System.out.println("An unexpected error occurred during processing for Task ID " + taskToProcess.getId() + ".");
             System.err.println("Error details: " + e.getMessage()); // Use System.err for the error detail
        }
    }

    // Displays tasks currently in the queue
    public void viewPendingTasks() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks are currently pending.");
            return;
        }
        System.out.println("--- Pending Tasks ---");
        // Iterate without removing elements
        taskQueue.forEach(System.out::println);
        System.out.println("---------------------");
    }

    // Displays tasks that have been processed
    public void viewProcessedTasks() {
        if (processedTasks.isEmpty()) {
            System.out.println("No tasks have been processed yet.");
            return;
        }
        System.out.println("--- Processed Tasks ---");
        processedTasks.forEach(System.out::println);
        System.out.println("-----------------------");
    }

    // Displays the main menu
    private void displayMenu() {
        System.out.println("\nTask Management System Menu:");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Processed Tasks");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Main application loop
    public void run() {
        int choice = -1;
        while (choice != 5) {
            displayMenu();
            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } else {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume invalid input
                    continue; // Skip the switch and loop again
                }

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
                        viewProcessedTasks();
                        break;
                    case 5:
                        System.out.println("Exiting Task Management System. Goodbye!");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                // Catch any unexpected exceptions during the menu interaction loop
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // Depending on the error, you might want to consume line or take other recovery steps
                // For a simple exam scenario, just reporting might be sufficient.
                // e.printStackTrace(); // Uncomment for debugging
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    // Main method to start the application
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.run();
    }
}
