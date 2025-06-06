/*
 * Exam Question #460
 * Generated on: 2025-05-11 23:14:46
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a command-line application for a simple task management system. The system should allow users to add tasks with a description and priority, process the next task waiting, and view lists of pending and completed tasks.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that fulfills the following requirements:
 * 
 * 1.  **Task Representation:**
 *     *   Create a class named `Task` to represent a task.
 *     *   The `Task` class must have private fields for `taskId` (an integer, unique identifier), `description` (String), `priority` (using an `enum`), and `status` (using an `enum`).
 *     *   Define an `enum` named `Priority` with values `LOW`, `MEDIUM`, `HIGH`.
 *     *   Define an `enum` named `Status` with values `PENDING`, `COMPLETED`.
 *     *   Implement a constructor for `Task` and appropriate getter methods. Include a method to update the task's status.
 *     *   Override the `toString()` method to provide a user-friendly representation of a task.
 * 
 * 2.  **Task Scheduler Logic:**
 *     *   Create a class named `TaskScheduler` responsible for managing tasks.
 *     *   Inside `TaskScheduler`, use a `java.util.Queue` to store tasks that are waiting to be processed. Specifically, use `java.util.LinkedList` as the implementation for the `Queue`.
 *     *   Inside `TaskScheduler`, use a `java.util.List` to store tasks that have been completed. Specifically, use `java.util.ArrayList` as the implementation for the `List`.
 *     *   Implement a mechanism to generate unique `taskId`s (e.g., a counter).
 *     *   Implement a method `addTask(String description, Priority priority)` that creates a new `Task` and adds it to the pending queue.
 *     *   Implement a method `processNextTask()` that retrieves the next task from the pending queue (using the `Queue`'s standard removal method), updates its status to `COMPLETED`, and adds it to the completed tasks list. If the pending queue is empty, it should report an error.
 *     *   Implement a method `getPendingTasks()` that returns a `java.util.List` containing the tasks currently in the pending queue.
 *     *   Implement a method `getCompletedTasks()` that returns the `java.util.List` containing the completed tasks.
 * 
 * 3.  **User Interface and Application Flow:**
 *     *   In the `main` method of your application class (e.g., `TaskManagerApp`), implement a command-line interface.
 *     *   Use `java.util.Scanner` to read user input for menu choices and task details.
 *     *   Display a menu with options: Add New Task, Process Next Task, View Pending Tasks, View Completed Tasks, Exit.
 *     *   Use a `switch` statement to handle the different menu options based on user input.
 *     *   Use `System.out` for displaying the menu, prompts, task lists, and success messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid menu choice, invalid task priority input, attempting to process a task when the queue is empty).
 * 
 * 4.  **Error Handling and Validation:**
 *     *   Implement input validation for the menu choice to ensure it's a valid number within the menu range. Handle `InputMismatchException` if the user enters non-numeric input.
 *     *   Implement input validation for the task priority to ensure the user enters one of the valid `Priority` enum names (case-insensitive, but store as enum). Handle `IllegalArgumentException` if the input string does not match an enum constant.
 *     *   Implement a check in `processNextTask()` to handle the case where the pending queue is empty. Report this specific error using `System.err`.
 *     *   Implement class-wide exception handling using a `try-catch` block in or around the `main` method's core logic loop to catch any unexpected runtime exceptions and print an error message to `System.err`. Ensure the `Scanner` is closed properly.
 * 
 * 5.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc-style comments for methods).
 *     *   Structure your code into logical classes.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively. Examples of interaction include:
 * - Displaying the menu.
 * - Prompting for task details and confirming task addition.
 * - Processing a task and confirming completion.
 * - Displaying pending and completed task lists.
 * - Reporting errors for invalid input or actions (like processing an empty queue) using `System.err`.
 * - Handling non-numeric input gracefully.
 * - Exiting the application.
 * 
 * Demonstrate adding a few tasks, viewing them, processing one, viewing again, processing until empty, and attempting to process when empty.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct usage of `Queue` (`LinkedList`), `ArrayList`, and `List`.
 * *   Correct implementation of the `Task` and `TaskScheduler` classes with proper encapsulation.
 * *   Correct implementation of the menu-driven interface using `Scanner` and `switch`.
 * *   Effective use of `System.out` and `System.err` for appropriate output types.
 * *   Robust error handling, including input validation (`InputMismatchException`, `IllegalArgumentException`) and handling the empty queue scenario, reported via `System.err`.
 * *   Class-wide exception handling demonstrated with `try-catch`.
 * *   Adherence to best practices (naming, comments, structure).
 *
 * EXPLANATION:
 * This solution implements a simple command-line Task Management System, demonstrating the required Java concepts in a cohesive application.
 * 
 * 1.  **`Task` Class:**
 *     *   Represents the data structure for a task.
 *     *   Uses private fields (`taskId`, `description`, `priority`, `status`) for encapsulation.
 *     *   `Priority` and `Status` are implemented as `enum`s, providing type safety and clear representation of possible states.
 *     *   Includes a constructor to initialize tasks and getter methods. A `setStatus` method allows updating the task's state upon processing.
 *     *   The `toString()` method provides a readable format for printing task details using `String.format`.
 * 
 * 2.  **`TaskScheduler` Class:**
 *     *   Manages the collection and processing of tasks, separating logic from the UI.
 *     *   `pendingTasks`: Declared as `Queue<Task>` and instantiated as `LinkedList<Task>`. This fulfills the requirement of using `Queue` and `LinkedList`. `Queue` methods like `offer()` (add) and `poll()` (retrieve and remove head) are used, demonstrating standard queue operations.
 *     *   `completedTasks`: Declared as `List<Task>` and instantiated as `ArrayList<Task>`. This fulfills the requirement of using `List` and `ArrayList`. Processed tasks are added to this list using `add()`.
 *     *   `nextTaskId`: A simple integer counter ensures unique IDs for tasks.
 *     *   `addTask()`: Creates a new `Task` object and adds it to the `pendingTasks` queue.
 *     *   `processNextTask()`: Checks if `pendingTasks` is empty *before* polling. If empty, it prints an error to `System.err` and returns, demonstrating error handling for an invalid operation state. If not empty, it removes the task from the queue (`poll()`), updates its status, and adds it to the `completedTasks` list.
 *     *   `getPendingTasks()`: Returns a `List<Task>`. It creates a *new* `ArrayList` from the `pendingTasks` queue's elements. This is a common pattern to provide a `List` view of a collection without exposing the internal queue structure directly and fulfills the requirement of using `ArrayList` in conjunction with the `Queue`'s contents.
 *     *   `getCompletedTasks()`: Returns the internal `completedTasks` `ArrayList` directly as a `List`.
 * 
 * 3.  **`TaskManagerApp` Class (`main` and helper methods):**
 *     *   Contains the `main` method, the entry point of the application.
 *     *   Uses a `Scanner` (`java.util.Scanner`) to read user input from the console.
 *     *   The `run()` method contains the main application loop (`while(running)`), which repeatedly prints the menu and processes user input.
 *     *   A `switch` statement is used to direct the program flow based on the integer choice entered by the user, directly addressing this requirement.
 *     *   `System.out` is used for all standard output: the menu, prompts, successful actions, and task listings.
 *     *   `System.err` is used specifically for error messages: invalid menu choices, invalid priority input, and the error when trying to process an empty queue.
 * 
 * 4.  **Error Handling and Validation:**
 *     *   **InputMismatchException:** A `try-catch` block around `scanner.nextInt()` in the `run()` method handles cases where the user enters non-numeric input for the menu choice. An error message is printed to `System.err`, the invalid input is consumed (`scanner.nextLine()`), and the loop continues, prompting the user again.
 *     *   **IllegalArgumentException:** A `try-catch` block in the `addTaskAction()` method handles the conversion of the priority string input to the `Priority` enum using `Priority.valueOf()`. If the string doesn't match an enum constant, `IllegalArgumentException` is caught, an error message is printed to `System.err`, and the user is prompted to re-enter the priority.
 *     *   **Empty Queue:** The `processNextTask()` method explicitly checks `pendingTasks.isEmpty()` and prints an error message to `System.err` if true, demonstrating handling of a specific application state error.
 *     *   **Class-wide Exception Handling:** The `main` method wraps the call to `run()` in a `try-catch(Exception e)` block. This catches any unhandled runtime exceptions that might occur within the `run()` method or its called methods. It prints a generic error message and the stack trace to `System.err`, providing debugging information while preventing the program from crashing abruptly.
 *     *   **Scanner Closing:** The `finally` block in `main` ensures that the `scanner` object is closed, releasing system resources, regardless of whether an exception occurred or the program exited normally. Additional catches for `NoSuchElementException` and `IllegalStateException` are added to input reading loops to handle potential issues with the scanner state itself.
 * 
 * 5.  **Best Practices:**
 *     *   **Encapsulation:** Achieved by making fields private and providing public methods for interaction.
 *     *   **Meaningful Names:** Classes, methods, variables, and enums have names that clearly indicate their purpose (e.g., `TaskScheduler`, `processNextTask`, `pendingTasks`, `Priority.HIGH`).
 *     *   **Comments and Documentation:** Javadoc-style comments explain the purpose of classes and methods, and inline comments clarify specific code sections.
 *     *   **Clean Structure:** The code is divided into logical units (`Task`, `TaskScheduler`, `TaskManagerApp`) with clear responsibilities. Helper methods like `addTaskAction`, `viewPendingTasksAction`, `printMenu`, and `run` break down the main application logic into manageable parts.
 * 
 * This solution effectively integrates all the required Java components while simulating a practical scenario and adhering to good programming practices, making it a suitable task for evaluating advanced Java understanding.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException; // Added for Scanner handling

// Enum for task priority
enum Priority {
    LOW, MEDIUM, HIGH
}

// Enum for task status
enum Status {
    PENDING, COMPLETED
}

/**
 * Represents a single task in the task management system.
 */
class Task {
    private int taskId;
    private String description;
    private Priority priority;
    private Status status;

    /**
     * Constructs a new Task.
     * @param taskId The unique identifier for the task.
     * @param description A brief description of the task.
     * @param priority The priority level of the task.
     */
    public Task(int taskId, String description, Priority priority) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.status = Status.PENDING; // Tasks are initially pending
    }

    // --- Getters ---
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    /**
     * Sets the status of the task.
     * @param status The new status for the task.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Task object.
     * @return Formatted string displaying task details.
     */
    @Override
    public String toString() {
        return String.format("Task ID: %d, Description: \"%s\", Priority: %s, Status: %s",
                             taskId, description, priority, status);
    }
}

/**
 * Manages the collection of tasks, including pending and completed tasks.
 */
class TaskScheduler {
    // Required: Use Queue and LinkedList for pending tasks
    private Queue<Task> pendingTasks;
    // Required: Use List and ArrayList for completed tasks
    private List<Task> completedTasks;
    private int nextTaskId; // Counter for generating unique task IDs

    /**
     * Constructs a new TaskScheduler, initializing task collections.
     */
    public TaskScheduler() {
        this.pendingTasks = new LinkedList<>();
        this.completedTasks = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the pending tasks queue.
     * @param description The task description.
     * @param priority The task priority.
     */
    public void addTask(String description, Priority priority) {
        Task newTask = new Task(nextTaskId++, description, priority);
        pendingTasks.offer(newTask); // Add task to the queue using offer
        System.out.println("Successfully added: " + newTask); // Required: System.out
    }

    /**
     * Processes the next task from the pending queue (FIFO).
     * Moves the processed task to the completed list.
     * Reports an error using System.err if the queue is empty.
     */
    public void processNextTask() {
        // Check if the queue is empty before attempting to process
        if (pendingTasks.isEmpty()) {
            System.err.println("Error: No pending tasks to process."); // Required: System.err
            return;
        }

        Task taskToProcess = pendingTasks.poll(); // Get and remove the head of the queue
        taskToProcess.setStatus(Status.COMPLETED); // Update status
        completedTasks.add(taskToProcess); // Add to completed list

        System.out.println("Successfully processed: " + taskToProcess); // Required: System.out
    }

    /**
     * Returns a List containing the tasks currently in the pending queue.
     * Returns a new ArrayList copy to avoid external modification of the queue.
     * @return A List of pending Task objects. Required: Return type List.
     */
    public List<Task> getPendingTasks() {
        // Return a new ArrayList containing the elements from the queue
        // This uses ArrayList to hold the elements from the Queue, fulfilling the requirement
        return new ArrayList<>(pendingTasks); // Required: Use List as return type and ArrayList
    }

    /**
     * Returns a List containing the completed tasks.
     * @return A List of completed Task objects. Required: Return type List.
     */
    public List<Task> getCompletedTasks() {
        return completedTasks; // Returns the internal ArrayList (which implements List)
    }
}

/**
 * Main application class for the Task Management System.
 * Handles user interaction, menu display, and delegates tasks to TaskScheduler.
 */
public class TaskManagerApp {

    private static TaskScheduler scheduler = new TaskScheduler();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Main entry point of the application.
     * Implements class-wide exception handling.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Required: Class-wide exception handling (wrapping the main logic loop)
        try {
            run(); // Delegate the main application logic to a separate method
        } catch (Exception e) {
            // Catch any unexpected exceptions during execution
            System.err.println("An unexpected error occurred during application execution:"); // Required: System.err
            // Use printStackTrace with System.err as argument
            e.printStackTrace(System.err);
        } finally {
            // Ensure the scanner is closed properly
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Application finished."); // Indicate final state
        }
    }

    /**
     * Contains the main application loop, menu display, and user input handling.
     */
    private static void run() {
        boolean running = true;
        while (running) {
            printMenu();

            int choice = -1;
            // Required: Input validation for menu choice using try-catch
            try {
                System.out.print("Enter your choice: "); // Required: System.out
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number corresponding to the menu option."); // Required: System.err
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                continue; // Skip the rest of the loop iteration and show menu again
            } catch (NoSuchElementException | IllegalStateException e) {
                 // Handle potential issues with scanner like being closed
                 System.err.println("Error reading input. Exiting."); // Required: System.err
                 running = false; // Stop the loop
                 continue; // Exit current loop iteration
            }


            // Required: Use switch statement for flow control
            switch (choice) {
                case 1:
                    addTaskAction();
                    break;
                case 2:
                    scheduler.processNextTask(); // This method handles its own empty queue error
                    break;
                case 3:
                    viewPendingTasksAction();
                    break;
                case 4:
                    viewCompletedTasksAction();
                    break;
                case 5:
                    System.out.println("Exiting Task Management System. Goodbye!"); // Required: System.out
                    running = false; // Set flag to exit loop
                    break;
                default:
                    System.err.println("Invalid choice. Please enter a number between 1 and 5."); // Required: System.err
            }
            System.out.println(); // Add a newline for better separation between interactions
        }
    }

    /**
     * Handles the logic for adding a new task based on user input.
     * Includes input validation for task priority.
     */
    private static void addTaskAction() {
        System.out.print("Enter task description: "); // Required: System.out
        String description = scanner.nextLine();

        Priority priority = null;
        boolean validPriority = false;
        // Loop until valid priority is entered
        while (!validPriority) {
            System.out.print("Enter priority (LOW, MEDIUM, HIGH): "); // Required: System.out
            String priorityString = scanner.nextLine().trim().toUpperCase(); // Read input, trim, and convert to uppercase

            // Required: Input validation for priority using try-catch
            try {
                priority = Priority.valueOf(priorityString); // Convert string to enum
                validPriority = true; // If conversion is successful, priority is valid
            } catch (IllegalArgumentException e) {
                System.err.println("Invalid priority. Please enter LOW, MEDIUM, or HIGH."); // Required: System.err
            } catch (NoSuchElementException | IllegalStateException e) {
                 System.err.println("Error reading priority input. Aborting task addition."); // Required: System.err
                 return; // Exit this method
            }
        }

        scheduler.addTask(description, priority); // Delegate to TaskScheduler
    }

    /**
     * Handles the logic for viewing pending tasks.
     */
    private static void viewPendingTasksAction() {
        List<Task> pending = scheduler.getPendingTasks(); // Required: Use List
        if (pending.isEmpty()) {
            System.out.println("No pending tasks."); // Required: System.out
        } else {
            System.out.println("--- Pending Tasks ---"); // Required: System.out
            for (Task task : pending) {
                System.out.println(task); // Required: System.out
            }
            System.out.println("---------------------"); // Required: System.out
        }
    }

    /**
     * Handles the logic for viewing completed tasks.
     */
    private static void viewCompletedTasksAction() {
        List<Task> completed = scheduler.getCompletedTasks(); // Required: Use List
        if (completed.isEmpty()) {
            System.out.println("No completed tasks."); // Required: System.out
        } else {
            System.out.println("--- Completed Tasks ---"); // Required: System.out
            for (Task task : completed) {
                System.out.println(task); // Required: System.out
            }
            System.out.println("-----------------------"); // Required: System.out
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Task Management Menu ---"); // Required: System.out
        System.out.println("1. Add New Task"); // Required: System.out
        System.out.println("2. Process Next Task"); // Required: System.out
        System.out.println("3. View Pending Tasks"); // Required: System.out
        System.out.println("4. View Completed Tasks"); // Required: System.out
        System.out.println("5. Exit"); // Required: System.out
        System.out.println("----------------------------"); // Required: System.out
    }
}
