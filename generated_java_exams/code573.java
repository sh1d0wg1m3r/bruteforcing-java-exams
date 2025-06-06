/*
 * Exam Question #573
 * Generated on: 2025-05-11 23:31:18
 * Generated by: Account 4
 * 
 * QUESTION:
 * **Task Processing System Simulation**
 * 
 * **Scenario:** You are tasked with building a simplified system to manage and process tasks. Tasks are added to a queue to be processed sequentially in a First-In, First-Out (FIFO) manner. Once a task is processed (either successfully completed or failed), it is moved to a history list for review. The system should allow users to interact via a console menu.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task`. This class should have the following private fields:
 *     *   `id`: A unique integer ID for each task (automatically generated).
 *     *   `description`: A `String` describing the task.
 *     *   `status`: A `String` representing the current status of the task (e.g., "Pending", "Processing", "Completed", "Failed"). Initialize to "Pending".
 *     *   `result`: A `String` message detailing the outcome of processing (e.g., "Processed successfully.", "Failed: [Reason]"). Initialize to an empty string.
 *     *   Include a constructor, public getter methods for all fields, and public setter methods for `status` and `result`. Ensure proper encapsulation.
 * 
 * 2.  **Data Structures:**
 *     *   Maintain a collection of tasks waiting to be processed using a `java.util.Queue<Task>`.
 *     *   Maintain a history of all processed tasks (both completed and failed) using a `java.util.List<Task>`. Declare the variable using the `List` interface but instantiate it using `java.util.ArrayList`.
 * 
 * 3.  **User Interface:** Implement a console-based menu using `java.util.Scanner` for user input. The menu should offer the following options:
 *     *   1. Add New Task
 *     *   2. Process Next Task
 *     *   3. View Pending Tasks Queue
 *     *   4. View Processed Tasks History
 *     *   5. Exit
 * 
 * 4.  **Functionality:**
 *     *   **Add Task:** Prompt the user for a task description. Create a `Task` object and add it to the pending queue. Implement input validation to ensure the description is not empty or just whitespace.
 *     *   **Process Task:** Remove the next task from the *front* of the pending queue. Simulate a processing operation (e.g., using `Thread.sleep` for a short duration). Introduce a chance for the processing to *fail* (e.g., using `java.util.Random` to throw a simulated exception). Update the task's status and result message based on the outcome. Add the processed task to the history list *regardless* of success or failure. Handle the case where the pending queue is empty gracefully.
 *     *   **View Pending:** Display the tasks currently in the pending queue without removing them. Show the task ID and description.
 *     *   **View Processed:** Display the details (ID, description, status, result) of all tasks in the history list.
 *     *   **Exit:** Terminate the program.
 * 
 * 5.  **Control Flow:** Use a `switch` statement to handle the user's menu selection.
 * 
 * 6.  **Output:** Use `java.lang.System.out` for normal program output (menu, prompts, success messages, task details, list/queue contents). Use `java.lang.System.err` for displaying error messages (e.g., invalid input, empty description error, processing failure details, messages from caught exceptions).
 * 
 * 7.  **Error Handling:**
 *     *   Implement input validation as specified in functionality.
 *     *   Use `try-catch` blocks to handle potential exceptions during task processing (specifically, catch the simulated failure exception and `InterruptedException` if using `Thread.sleep`).
 *     *   Implement a broad `try-catch` block around the main application loop (e.g., the `while(true)` loop driven by the menu) for class-wide exception handling of any unexpected runtime errors that might occur. Ensure the `Scanner` is closed properly in a `finally` block or similar mechanism.
 * 
 * 8.  **Best Practices:** Ensure proper encapsulation (private fields, public methods), meaningful variable and method names, appropriate comments and documentation (basic comments explaining key parts are sufficient for an exam), clean code structure (separate methods for different actions), and robust error handling.
 * 
 * **Expected Output Structure:**
 * The program should display a menu, accept user input, perform actions, and print relevant information. Errors should be printed to `System.err`.
 * 
 * Example Interaction Flow:
 * 
 * ```
 * --- Task Processing System ---
 * 
 * Select an action:
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks Queue
 * 4. View Processed Tasks History
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Prepare exam question
 * 
 * Task added: Task [ID=1, Desc='Prepare exam question', Status='Pending']
 * 
 * Select an action:
 * ... menu ...
 * Enter your choice: 1
 * Enter task description: Review student submissions
 * 
 * Task added: Task [ID=2, Desc='Review student submissions', Status='Pending']
 * 
 * Select an action:
 * ... menu ...
 * Enter your choice: 3
 * 
 * --- Pending Tasks ---
 * 1. Prepare exam question (ID: 1)
 * 2. Review student submissions (ID: 2)
 * ---------------------
 * 
 * Select an action:
 * ... menu ...
 * Enter your choice: 2
 * Processing task: Prepare exam question (ID: 1)
 * Task ID 1 completed. // Or System.err.println("Task processing failed for ID 1: Simulated failure reason.")
 * 
 * Select an action:
 * ... menu ...
 * Enter your choice: 4
 * 
 * --- Processed Tasks History ---
 * ID: 1, Desc: 'Prepare exam question', Status: Completed, Result: Processed successfully.
 * -----------------------------
 * 
 * Select an action:
 * ... menu ...
 * Enter your choice: 2
 * Processing task: Review student submissions (ID: 2)
 * Task processing failed for ID 2: Simulated processing error! // Printed to System.err
 * 
 * Select an action:
 * ... menu ...
 * Enter your choice: 4
 * 
 * --- Processed Tasks History ---
 * ID: 1, Desc: 'Prepare exam question', Status: Completed, Result: Processed successfully.
 * ID: 2, Desc: 'Review student submissions', Status: Failed, Result: Failed: Simulated processing error!
 * -----------------------------
 * 
 * Select an action:
 * ... menu ...
 * Enter your choice: invalid_input
 * Error: Invalid input. Please enter a number. // Printed to System.err
 * 
 * Select an action:
 * ... menu ...
 * Enter your choice: 5
 * Exiting Task Processing System. Goodbye!
 * ```
 * 
 * Implement the Java code for this Task Processing System.
 *
 * EXPLANATION:
 * This solution implements the `Task Processing System` as described in the exam question, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents individual tasks with `id`, `description`, `status`, and `result` fields, all declared as `private` to ensure encapsulation.
 *     *   A static counter `nextId` is used to automatically assign unique IDs to new tasks.
 *     *   Public getter methods (`getId`, `getDescription`, `getStatus`, `getResult`) provide read access to the task's state.
 *     *   Public setter methods (`setStatus`, `setResult`) allow controlled modification of the task's processing state.
 *     *   A `toString()` method is provided for easy printing of task information.
 * 
 * 2.  **`TaskProcessor` Class:**
 *     *   This is the main class managing the system.
 *     *   **Data Structures:**
 *         *   `pendingTasks`: Declared as `Queue<Task>` and instantiated as `LinkedList<Task>`. `LinkedList` is a common implementation of the `Queue` interface, providing FIFO behavior suitable for a processing queue. Methods like `offer()` (add to end) and `poll()` (remove from front) are used correctly.
 *         *   `processedTasks`: Declared as `List<Task>` and instantiated as `ArrayList<Task>`. This demonstrates using the `List` interface while utilizing the dynamic array capabilities of `ArrayList` to store the history of processed tasks.
 *     *   **`Scanner`:** A `Scanner` object is used to read user input from the console (`System.in`). It's initialized once in the constructor.
 *     *   **`Random`:** Used in `processNextTask` to simulate random success or failure outcomes.
 *     *   **Methods:**
 *         *   `addTask()`: Reads a line from the scanner, validates it, creates a new `Task` object, and adds it to the `pendingTasks` queue using `offer()`.
 *         *   `processNextTask()`: Checks if the queue is empty. If not, it removes the next task using `poll()`. It then enters a `try-catch-finally` block to simulate processing:
 *             *   `Thread.sleep()` simulates work time. `TimeUnit.MILLISECONDS.sleep()` is used for clarity.
 *             *   A random check determines if processing succeeds or fails.
 *             *   If it fails, a `RuntimeException` is explicitly thrown to simulate an error scenario that needs catching.
 *             *   The `catch (InterruptedException e)` block handles potential interruptions during `Thread.sleep`.
 *             *   The `catch (RuntimeException e)` block specifically catches the simulated failure exception.
 *             *   Both success and failure branches update the task's status and result.
 *             *   The `finally` block ensures that the processed task is added to the `processedTasks` list using `add()`, regardless of whether processing succeeded, failed, or was interrupted.
 *         *   `viewPendingTasks()`: Iterates through the `pendingTasks` queue using an enhanced for loop. This iteration does *not* remove elements from the queue, allowing the user to view the queue's current state.
 *         *   `viewProcessedTasks()`: Iterates through the `processedTasks` list and prints the details of each task.
 *         *   `printMenu()`: A helper method to display the menu options.
 *         *   `run()`: Contains the main application loop (`while(true)`). It calls `printMenu()`, reads user input, and uses a `switch` statement to dispatch to the appropriate method based on the user's choice.
 *     *   **Input Validation:** The `addTask` method checks if the description is empty or whitespace. The `run` method uses a `try-catch(NumberFormatException)` block specifically to handle non-integer input for the menu choice, printing an error to `System.err` and continuing the loop.
 *     *   **Error Handling (`try-catch`):**
 *         *   Specific `try-catch` blocks are used within `processNextTask` to handle `InterruptedException` and the simulated `RuntimeException`. Error messages are printed to `System.err`.
 *         *   A broad `try-catch(Exception e)` block is wrapped around the main `while(true)` loop in the `run()` method. This serves as class-wide exception handling, catching any unhandled exceptions that might occur during the program's execution and printing an error message and stack trace to `System.err`.
 *         *   A `finally` block in `run()` ensures the `Scanner` resource is closed when the `run()` method exits, whether normally (option 5) or due to an uncaught exception.
 *     *   **Output:** `System.out.println()` is used for standard informational messages, while `System.err.println()` is used exclusively for error messages, as required.
 *     *   **Best Practices:** The code uses meaningful variable and method names, follows encapsulation principles, includes basic comments, and structures the logic into distinct methods.
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) into a cohesive, functional program that simulates a real-world task processing workflow, while adhering to good programming practices and demonstrating robust error handling.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit; // For Thread.sleep

/**
 * Represents a single task in the processing system.
 * Follows encapsulation best practices.
 */
class Task {
    private static int nextId = 1; // Automatically generate unique IDs
    private int id;
    private String description;
    private String status; // e.g., "Pending", "Processing", "Completed", "Failed"
    private String result; // Details about processing outcome

    /**
     * Constructs a new Task with a given description.
     * ID is automatically assigned, status is set to "Pending".
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.id = nextId++;
        this.description = description;
        this.status = "Pending";
        this.result = ""; // Initialize with empty result
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public String getResult() {
        return result;
    }

    // --- Setters ---
    public void setStatus(String status) {
        this.status = status;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * Provides a string representation of the task.
     *
     * @return A string describing the task.
     */
    @Override
    public String toString() {
        return "Task [ID=" + id + ", Desc='" + description + "', Status='" + status + "']";
    }
}

/**
 * Manages the task queue and processing history.
 * Includes user interaction via console.
 */
public class TaskProcessor {

    // Use Queue interface, implement with LinkedList for FIFO
    private Queue<Task> pendingTasks;
    // Use List interface, implement with ArrayList for dynamic storage
    private List<Task> processedTasks;
    private Scanner scanner;
    private Random random; // To simulate processing success/failure

    /**
     * Constructs a new TaskProcessor, initializing data structures and resources.
     */
    public TaskProcessor() {
        pendingTasks = new LinkedList<>();
        processedTasks = new ArrayList<>(); // ArrayList implements List
        scanner = new Scanner(System.in);
        random = new Random();
    }

    /**
     * Adds a new task based on user input to the pending queue.
     * Includes input validation.
     */
    public void addTask() {
        System.out.println("Enter task description:");
        String description = scanner.nextLine();

        // Input validation for description
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }

        Task newTask = new Task(description.trim());
        pendingTasks.offer(newTask); // offer() is preferred for adding to queue
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes the next task from the pending queue.
     * Simulates work and potential failure, updates task status, and moves to history.
     */
    public void processNextTask() {
        // Check if the queue is empty
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks to process.");
            return;
        }

        // Retrieve and remove the head of the queue
        Task taskToProcess = pendingTasks.poll(); // poll() is preferred for removing from queue

        System.out.println("Processing task: " + taskToProcess.getDescription() + " (ID: " + taskToProcess.getId() + ")");
        taskToProcess.setStatus("Processing"); // Update status while processing

        // Simulate processing logic with potential failure
        try {
            // Simulate some work time
            TimeUnit.MILLISECONDS.sleep(700); // Using TimeUnit is cleaner than raw Thread.sleep

            // Simulate success (70% chance) or failure (30% chance)
            if (random.nextDouble() < 0.7) { // 70% chance of success
                taskToProcess.setStatus("Completed");
                taskToProcess.setResult("Processed successfully.");
                System.out.println("Task ID " + taskToProcess.getId() + " completed successfully.");
            } else {
                // Simulate a processing failure by throwing an exception
                throw new RuntimeException("Simulated processing error!");
            }
        } catch (InterruptedException e) {
            // Handle interruption during sleep
            System.err.println("Task processing interrupted for ID " + taskToProcess.getId() + ": " + e.getMessage());
            taskToProcess.setStatus("Failed");
            taskToProcess.setResult("Failed: Processing interrupted.");
            // Restore interrupt flag
            Thread.currentThread().interrupt();
        } catch (RuntimeException e) {
            // Handle the simulated processing failure exception
            System.err.println("Task processing failed for ID " + taskToProcess.getId() + ": " + e.getMessage());
            taskToProcess.setStatus("Failed");
            taskToProcess.setResult("Failed: " + e.getMessage());
        } finally {
            // Always add the task to the processed history list
            processedTasks.add(taskToProcess);
        }
    }

    /**
     * Displays all tasks currently in the pending queue without removing them.
     */
    public void viewPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No tasks in the queue.");
        } else {
            // Iterate through the queue using an enhanced for loop (does not remove elements)
            int index = 1;
            for (Task task : pendingTasks) {
                System.out.println(index++ + ". " + task.getDescription() + " (ID: " + task.getId() + ")");
            }
        }
        System.out.println("---------------------\n");
    }

    /**
     * Displays the history of all tasks that have been processed.
     */
    public void viewProcessedTasks() {
        System.out.println("\n--- Processed Tasks History ---");
        if (processedTasks.isEmpty()) {
            System.out.println("No tasks have been processed yet.");
        } else {
            // Iterate through the list
            for (Task task : processedTasks) {
                System.out.println("ID: " + task.getId() + ", Desc: '" + task.getDescription() + "', Status: " + task.getStatus() + ", Result: " + task.getResult());
            }
        }
        System.out.println("-----------------------------\n");
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("\nSelect an action:");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks Queue");
        System.out.println("4. View Processed Tasks History");
        System.out.println("5. Exit");
    }

    /**
     * Runs the main application loop, handling user interaction.
     * Includes class-wide exception handling.
     */
    public void run() {
        System.out.println("--- Task Processing System ---");

        // Class-wide exception handling: Catch any unexpected errors during the main loop
        try {
            while (true) {
                printMenu();
                int choice = -1;

                // Specific try-catch for input parsing
                try {
                    System.out.print("Enter your choice: ");
                    // Use nextLine() and parse to avoid issues with newline characters
                    String input = scanner.nextLine();
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    continue; // Skip the rest of the loop and show menu again
                }

                // Use switch statement for menu navigation
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
                        System.out.println("Exiting Task Processing System. Goodbye!");
                        return; // Exit the run method
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // This catches any unexpected exception that wasn't handled by more specific catch blocks
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // Optionally print stack trace for debugging unexpected errors
            e.printStackTrace(System.err);
        } finally {
            // Ensure the scanner resource is closed when the program exits (normally or due to exception)
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Scanner closed."); // Indicate resource cleanup
        }
    }

    /**
     * Main method to start the Task Processing System.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskProcessor processor = new TaskProcessor();
        processor.run();
    }
}
