/*
 * Exam Question #228
 * Generated on: 2025-05-11 22:35:42
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Objective:** Design and implement a console-based Task Management System that simulates adding tasks to a queue for processing, processing tasks, and tracking completed tasks. This task is designed to test your understanding and practical application of fundamental Java data structures, control flow, and error handling.
 * 
 * **Scenario:** You are building a simple backend system for managing tasks that arrive and need to be processed sequentially.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:**
 *     *   Create a class named `Task` to represent a single task.
 *     *   It must have private fields: `taskId` (an integer, unique identifier) and `description` (a String).
 *     *   Include a public constructor `Task(int taskId, String description)`.
 *     *   Include public getter methods `getTaskId()` and `getDescription()`.
 *     *   Override the `toString()` method to provide a user-friendly string representation (e.g., "Task ID: X - Description").
 *     *   The constructor must validate that the `description` is not null or empty after trimming whitespace. If invalid, throw an `IllegalArgumentException`.
 * 
 * 2.  **Task Processing System:**
 *     *   Create a class named `TaskProcessorSystem` to manage the task queue and completed tasks.
 *     *   It must have private fields:
 *         *   A `java.util.Queue<Task>` to store tasks waiting to be processed. Use an appropriate concrete implementation like `java.util.LinkedList`.
 *         *   A `java.util.List<Task>` to store tasks that have been successfully processed. Use `java.util.ArrayList`.
 *         *   An integer to keep track of the next available task ID, starting from 1.
 *     *   Include a public constructor to initialize the queue, list, and task ID counter.
 *     *   Implement the following public methods:
 *         *   `void addTask(String description)`: Creates a new `Task` object with the next available ID and the provided description. Adds the task to the processing queue. If the `Task` constructor throws an `IllegalArgumentException` (due to invalid description), catch it and print an error message to `System.err`. On successful addition, print a confirmation message to `System.out`.
 *         *   `void processNextTask()`: Removes the next task from the front of the queue. If the queue is empty, print a message to `System.out`. If a task is retrieved:
 *             *   Print a message indicating which task is being processed to `System.out`.
 *             *   **Simulate Processing:** Introduce a random chance (e.g., 20%) that processing might "fail". If it fails, throw a `RuntimeException` with a descriptive message (e.g., "Simulated processing failure for Task ID X").
 *             *   Wrap the simulated processing logic in a `try-catch` block.
 *             *   If processing succeeds (no exception), add the task to the list of completed tasks and print a success message to `System.out`.
 *             *   If processing fails (catches the `RuntimeException`), print an error message to `System.err`. The failed task is discarded in this simulation.
 *         *   `java.util.List<Task> getQueueTasks()`: Returns an unmodifiable `java.util.List` containing the tasks currently in the processing queue.
 *         *   `java.util.List<Task> getCompletedTasks()`: Returns an unmodifiable `java.util.List` containing the tasks in the completed history.
 * 
 * 3.  **Main Application:**
 *     *   Create a main class (e.g., `ExamTaskProcessor`) with a `public static void main(String[] args)` method.
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Implement a menu-driven interface using a `switch` statement within a loop, offering the following options:
 *         1.  Add Task
 *         2.  Process Next Task
 *         3.  View Queue
 *         4.  View History
 *         5.  Exit
 *     *   Use `System.out` for displaying the menu, prompts, and normal output (task listings, success messages, empty queue/history messages, exit message).
 *     *   Use `System.err` for displaying all error messages (invalid menu input, invalid task descriptions caught from `addTask`, processing failures caught from `processNextTask`).
 *     *   Implement **class-wide exception handling** in the `main` method using a `try-catch` block that wraps the main application loop. This block should catch general `Exception` or `RuntimeException` to handle any unexpected errors during execution, printing an error message to `System.err`. Include a `finally` block to ensure the `Scanner` is closed.
 *     *   Handle `InputMismatchException` specifically when reading the menu choice, printing an error to `System.err` and consuming the invalid input before continuing the loop.
 *     *   For options 3 and 4, call the respective `getQueueTasks()` or `getCompletedTasks()` methods and iterate through the returned `List` to print the tasks to `System.out`.
 * 
 * 4.  **Best Practices:**
 *     *   Employ proper encapsulation (private fields, public methods).
 *     *   Use meaningful names for classes, methods, and variables.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes and methods).
 *     *   Ensure robust input validation and error handling as specified.
 *     *   Maintain a clean and readable code structure.
 * 
 * **Expected Output:**
 * The program should run interactively, presenting a menu and responding to user input. Output should clearly distinguish between normal messages (`System.out`) and error messages (`System.err`). Example interactions for adding, processing (success and failure), and viewing lists should match the descriptions above.
 * 
 * **Time Limit:** This task is designed to be completed within 45-60 minutes.
 *
 * EXPLANATION:
 * The provided solution implements the Task Management System as described in the exam question, demonstrating the required Java concepts and best practices.
 * 
 * **Key Components Used and Demonstrated:**
 * 
 * 1.  **`java.util.Queue`**: The `TaskProcessorSystem` class uses a `Queue<Task>` (`taskQueue`) implemented by `java.util.LinkedList`. Tasks are added using `offer()` and removed for processing using `poll()`, respecting the First-In, First-Out (FIFO) nature of a queue.
 * 2.  **`java.util.ArrayList`**: The `TaskProcessorSystem` class uses an `ArrayList<Task>` (`completedTasks`) to store tasks that have been successfully processed. `ArrayList` is also used in `getQueueTasks()` to create a copy of the queue's contents before returning it as a `List`.
 * 3.  **`java.util.List`**: The `getQueueTasks()` and `getCompletedTasks()` methods in `TaskProcessorSystem` are declared to return `java.util.List<Task>`. This demonstrates programming to the interface, providing flexibility for future changes in the underlying implementation within the `TaskProcessorSystem` while maintaining a stable public API. The `main` method receives and iterates over these `List` objects.
 * 4.  **`java.util.Scanner`**: The `main` method in `ExamTaskProcessor` uses a `Scanner` to read user input from `System.in` for menu choices and task descriptions.
 * 5.  **`switch` statement**: The `main` method uses a `switch` statement to control the program flow based on the user's menu choice, directing execution to the appropriate logic for adding, processing, viewing, or exiting.
 * 6.  **`System.err`**: Used throughout the code for printing error messages, including:
 *     *   Validation errors when adding a task (caught `IllegalArgumentException`).
 *     *   Simulated processing failures (caught `RuntimeException`).
 *     *   Invalid menu input (caught `InputMismatchException`).
 *     *   Any unexpected top-level errors caught by the class-wide handler in `main`.
 * 7.  **`System.out`**: Used for all standard output, such as displaying the menu, prompts, confirmation messages for adding tasks, messages about task processing status (start, success, queue empty), and listing the tasks in the queue and history.
 * 8.  **Class-wide exception handling with `try-catch`**:
 *     *   In `ExamTaskProcessor.main`, a large `try-catch(Exception e)` block wraps the entire `while` loop. This acts as a top-level handler for any unexpected runtime errors that might occur within the main application flow, preventing the program from crashing abruptly and providing a final error message using `System.err`. A `finally` block ensures resource cleanup (closing the `Scanner`).
 *     *   Specific `try-catch(InputMismatchException e)` is used within the loop to handle non-integer input gracefully.
 *     *   In `TaskProcessorSystem`, `addTask` uses `try-catch` to handle `IllegalArgumentException` from the `Task` constructor.
 *     *   In `TaskProcessorSystem`, `processNextTask` uses `try-catch` to handle the simulated `RuntimeException` for processing failures.
 * 
 * **Best Practices Demonstrated:**
 * 
 * *   **Encapsulation:** The `Task` and `TaskProcessorSystem` classes encapsulate their data (private fields) and expose functionality through public methods (`getTaskId`, `getDescription`, `addTask`, `processNextTask`, etc.). The `TaskProcessorSystem` internal data structures (`taskQueue`, `completedTasks`) are private.
 * *   **Meaningful Names:** Classes (`Task`, `TaskProcessorSystem`, `ExamTaskProcessor`), methods (`addTask`, `processNextTask`, `getQueueTasks`, `printMenu`), and variables (`taskId`, `description`, `taskQueue`, `completedTasks`, `nextTaskId`, `choice`) have descriptive names.
 * *   **Comments and Documentation:** Javadoc comments are provided for classes and key methods explaining their purpose, parameters, and return values. Inline comments clarify specific logic, such as the random failure simulation.
 * *   **Input Validation:** The `Task` constructor validates the description. The `main` method handles non-integer input for menu choices.
 * *   **Error Handling:** Multiple `try-catch` blocks handle specific potential errors (validation, processing failure, input mismatch) and a general `try-catch` handles unexpected errors. `System.err` is consistently used for error output.
 * *   **Clean Code Structure:** The code is divided into three logical classes (`Task`, `TaskProcessorSystem`, `ExamTaskProcessor`), each with a single responsibility, promoting modularity and readability. Methods are relatively small and focused. Returning unmodifiable lists from getter methods prevents external modification of the internal state.
 * 
 * This solution effectively integrates the required components into a functional simulation, demonstrating a solid understanding of core Java programming concepts and best practices for building robust applications.
 */

// Task.java
package com.example.tasksystem;

import java.util.Objects;

/**
 * Represents a single task with a unique ID and description.
 */
public class Task {
    private final int taskId;
    private final String description;

    /**
     * Constructs a new Task.
     *
     * @param taskId      The unique identifier for the task.
     * @param description The description of the task.
     * @throws IllegalArgumentException if the description is null or empty.
     */
    public Task(int taskId, String description) {
        // Input validation for description
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be null or empty.");
        }
        this.taskId = taskId;
        this.description = description.trim();
    }

    /**
     * Gets the unique ID of the task.
     * @return The task ID.
     */
    public int getTaskId() {
        return taskId;
    }

    /**
     * Gets the description of the task.
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Provides a user-friendly string representation of the task.
     * @return String representation of the task.
     */
    @Override
    public String toString() {
        return "Task ID: " + taskId + " - " + description;
    }

    // Optional: hashCode and equals if tasks need to be compared or stored in sets/maps
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}

// TaskProcessorSystem.java
package com.example.tasksystem;

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Manages the task processing queue and completed task history.
 */
public class TaskProcessorSystem {
    // Using LinkedList as a Queue implementation
    private final Queue<Task> taskQueue;
    // Using ArrayList as a List implementation for completed tasks
    private final List<Task> completedTasks;
    private int nextTaskId; // Counter for assigning unique task IDs
    private final Random random; // For simulating processing failure

    /**
     * Constructs a new TaskProcessorSystem.
     */
    public TaskProcessorSystem() {
        this.taskQueue = new LinkedList<>();
        this.completedTasks = new ArrayList<>();
        this.nextTaskId = 1;
        this.random = new Random(); // Initialize randomizer
    }

    /**
     * Adds a new task to the processing queue.
     * Handles validation errors from Task constructor.
     *
     * @param description The description of the task.
     */
    public void addTask(String description) {
        // Use a try-catch block to handle potential IllegalArgumentException from Task constructor
        try {
            Task newTask = new Task(nextTaskId, description); // Create task
            taskQueue.offer(newTask); // Add task to the end of the queue
            System.out.println("Task added: " + newTask);
            nextTaskId++; // Increment ID only on successful task creation and addition
        } catch (IllegalArgumentException e) {
            // Catch validation errors and print to System.err
            System.err.println("ERROR adding task: " + e.getMessage());
        } catch (Exception e) {
             // Catch any other unexpected errors during task creation/adding
             System.err.println("An unexpected error occurred while adding task: " + e.getMessage());
             // Optionally log e.printStackTrace() for debugging in a real system
        }
    }

    /**
     * Processes the next task from the queue.
     * Simulates processing success or failure using a random chance.
     */
    public void processNextTask() {
        // Use poll() to retrieve and remove the head of the queue, returns null if empty
        Task taskToProcess = taskQueue.poll();

        if (taskToProcess == null) {
            System.out.println("Task queue is empty. Nothing to process.");
            return; // Exit method if queue is empty
        }

        System.out.println("Processing Task ID: " + taskToProcess.getTaskId() + " - " + taskToProcess.getDescription() + "...");

        // Use a try-catch block to handle simulated processing failures
        try {
            // Simulate a chance of failure (e.g., 20%)
            if (random.nextDouble() < 0.2) {
                // Throw a RuntimeException to simulate a processing error
                throw new RuntimeException("Simulated processing failure for Task ID " + taskToProcess.getTaskId());
            }

            // Simulate some work duration (optional, not strictly required by prompt)
            // try { Thread.sleep(50); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); }

            // If processing is successful, add task to completed list
            completedTasks.add(taskToProcess);
            System.out.println("Task ID: " + taskToProcess.getTaskId() + " processed successfully.");

        } catch (RuntimeException e) {
            // Catch the simulated processing failure and print to System.err
            System.err.println("ERROR during task processing: " + e.getMessage());
            // In this simulation, failed tasks are not re-queued or saved.
        } catch (Exception e) {
             // Catch any other unexpected errors during processing
             System.err.println("An unexpected error occurred while processing task: " + e.getMessage());
             // Optionally log e.printStackTrace() for debugging
        }
    }

    /**
     * Gets an unmodifiable list of tasks currently waiting in the queue.
     * Returns a new list containing the queue elements to prevent external modification.
     *
     * @return An unmodifiable List of tasks in the queue.
     */
    public List<Task> getQueueTasks() {
        // Create a new ArrayList from the queue elements
        List<Task> queueList = new ArrayList<>(taskQueue);
        // Return an unmodifiable view of the list
        return Collections.unmodifiableList(queueList);
    }

    /**
     * Gets an unmodifiable list of tasks that have been successfully completed.
     *
     * @return An unmodifiable List of completed tasks.
     */
    public List<Task> getCompletedTasks() {
        // Return an unmodifiable view of the completed tasks list
        return Collections.unmodifiableList(completedTasks);
    }

    /**
     * Checks if the task queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isQueueEmpty() {
        return taskQueue.isEmpty();
    }
}

// ExamTaskProcessor.java
package com.example.tasksystem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the console-based Task Management System.
 * Handles user interaction and orchestrates the system.
 */
public class ExamTaskProcessor {

    /**
     * The main entry point of the application.
     * Implements the menu loop and handles user input and top-level exceptions.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Use Scanner for reading console input
        Scanner scanner = new Scanner(System.in);
        TaskProcessorSystem system = new TaskProcessorSystem();
        boolean running = true;

        // Class-wide exception handling: Wrap the main application loop
        try {
            while (running) {
                printMenu(); // Display menu options
                int choice = -1;

                // Specific try-catch for reading integer input to handle non-numeric input
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt(); // Read integer choice
                    scanner.nextLine(); // Consume the rest of the line (newline character)

                } catch (InputMismatchException e) {
                    // Handle case where input is not an integer
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop body and show menu again
                }

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        system.addTask(description); // Call system method to add task
                        break;
                    case 2:
                        system.processNextTask(); // Call system method to process task
                        break;
                    case 3:
                        System.out.println("\n--- Current Task Queue ---");
                        // Retrieve tasks from the queue using getQueueTasks (returns List)
                        List<Task> queueTasks = system.getQueueTasks();
                        if (queueTasks.isEmpty()) {
                            System.out.println("Queue is empty.");
                        } else {
                            // Iterate and print tasks from the List
                            queueTasks.forEach(System.out::println);
                        }
                        System.out.println("--------------------------");
                        break;
                    case 4:
                        System.out.println("\n--- Completed Task History ---");
                        // Retrieve completed tasks using getCompletedTasks (returns List)
                        List<Task> completedTasks = system.getCompletedTasks();
                         if (completedTasks.isEmpty()) {
                            System.out.println("History is empty.");
                        } else {
                            // Iterate and print tasks from the List
                            completedTasks.forEach(System.out::println);
                        }
                        System.out.println("----------------------------");
                        break;
                    case 5:
                        running = false; // Set flag to exit the loop
                        System.out.println("Exiting Task Management System.");
                        break;
                    default:
                        // Handle invalid menu choice (number outside 1-5)
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                System.out.println(); // Add a newline for better readability between menu cycles
            }
        } catch (Exception e) {
            // Catch any unexpected runtime errors that weren't handled by specific catches
            // This serves as the class-wide or application-wide exception handler
            System.err.println("\nAn unexpected system error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging unexpected critical errors
        } finally {
            // Ensure resources like Scanner are closed properly
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed.");
            }
        }
    }

    /**
     * Prints the main menu options to the console using System.out.
     */
    private static void printMenu() {
        System.out.println("--- Task Management Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Queue");
        System.out.println("4. View History");
        System.out.println("5. Exit");
    }
}
