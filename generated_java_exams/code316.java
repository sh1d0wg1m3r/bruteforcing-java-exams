/*
 * Exam Question #316
 * Generated on: 2025-05-11 22:53:53
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Software Task Processing System Simulation
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple simulation of a software task processing system. The system manages a queue of pending tasks and a list of completed tasks. Users can interact with the system via a command-line interface to add new tasks, process the next task in the queue, view pending tasks, or view completed tasks.
 * 
 * Each task has a name, a priority (represented as a string: "HIGH", "MEDIUM", "LOW"), and an estimated duration in minutes (a positive integer). Tasks are processed from the front of the pending queue (First-In, First-Out).
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class `Task` to represent a software task. It should have private fields for task name (`String`), priority (`String`), and duration (`int`). Include a constructor and public getter methods for these fields.
 * 2.  **System Core:** Create a class `TaskProcessorSystem` to manage the task processing. This class must contain:
 *     *   A `java.util.Queue<Task>` to hold tasks waiting to be processed.
 *     *   A `java.util.List<Task>` (implemented using `java.util.ArrayList`) to store tasks that have been completed.
 * 3.  **Functionality:** Implement the following methods within `TaskProcessorSystem`:
 *     *   `addTask(String name, String priority, int duration)`: Adds a new task to the pending queue after validating the input.
 *     *   `processNextTask()`: Removes and "processes" the next task from the pending queue. If the queue is empty, it should report that. Processed tasks are moved to the completed list.
 *     *   `viewPendingTasks()`: Displays all tasks currently in the pending queue without removing them.
 *     *   `viewCompletedTasks()`: Displays all tasks in the completed list.
 *     *   `runSystem()`: Contains the main application loop, presenting a menu to the user and handling their input.
 * 4.  **User Interface:**
 *     *   Use `java.util.Scanner` to read user input from the console in the `runSystem` method.
 *     *   Present a clear menu with options (e.g., Add Task, Process Task, View Pending, View Completed, Exit).
 *     *   Use a `switch` statement in `runSystem` to handle the different menu options.
 * 5.  **Input Validation:**
 *     *   When adding a task, validate that the name is not empty, the priority is one of "HIGH", "MEDIUM", or "LOW" (case-insensitive), and the duration is a positive integer (> 0).
 *     *   If input is invalid, display an error message using `System.err` and do not add the task.
 * 6.  **Output:**
 *     *   Use `System.out` for all normal output (menu, prompts, task details, success messages).
 *     *   Use `System.err` for all error messages (invalid input, unexpected issues).
 * 7.  **Error Handling:**
 *     *   Implement **class-wide** exception handling using `try-catch` blocks within the `TaskProcessorSystem` class, particularly around the main loop in `runSystem`, to catch unexpected runtime exceptions and display a generic error message using `System.err`.
 *     *   Handle specific input errors during task creation and report them via `System.err`.
 * 8.  **Best Practices:**
 *     *   Use appropriate data types.
 *     *   Employ meaningful variable and method names.
 *     *   Include comments and basic documentation (e.g., Javadoc comments for classes and methods).
 *     *   Ensure proper encapsulation (private fields, public getters/methods).
 *     *   Format output clearly.
 * 
 * **Menu Options:**
 * 
 * 1.  Add New Task
 * 2.  Process Next Task
 * 3.  View Pending Tasks
 * 4.  View Completed Tasks
 * 5.  Exit
 * 
 * **Expected Output Format:**
 * 
 * *   Menu and prompts should be clear.
 * *   Task details should be displayed clearly (e.g., "Task: [Name], Priority: [Priority], Duration: [Duration] minutes").
 * *   Error messages should go to `System.err`.
 * *   Normal messages (success, empty queue) should go to `System.out`.
 * 
 * **Example Interaction Flow:**
 * 
 * ```
 * --- Task Processor System ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task name: Design UI
 * Enter priority (HIGH, MEDIUM, LOW): HIGH
 * Enter duration in minutes: 60
 * Task 'Design UI' added to the queue.
 * 
 * --- Task Processor System ---
 * ...
 * Enter your choice: 1
 * Enter task name:
 * Enter priority (HIGH, MEDIUM, LOW): MEDIUM
 * Enter duration in minutes: 30
 * Error: Task name cannot be empty. (This should go to System.err)
 * 
 * --- Task Processor System ---
 * ...
 * Enter your choice: 3
 * Pending Tasks:
 * Task: Design UI, Priority: HIGH, Duration: 60 minutes
 * 
 * --- Task Processor System ---
 * ...
 * Enter your choice: 2
 * Processing task: Design UI
 * Task 'Design UI' completed.
 * 
 * --- Task Processor System ---
 * ...
 * Enter your choice: 3
 * Pending Tasks:
 * (Queue is empty)
 * 
 * --- Task Processor System ---
 * ...
 * Enter your choice: 4
 * Completed Tasks:
 * Task: Design UI, Priority: HIGH, Duration: 60 minutes
 * 
 * --- Task Processor System ---
 * ...
 * Enter your choice: 5
 * Exiting system.
 * ```
 * 
 * Implement the necessary classes and the main execution logic in a single file for submission, ensuring all requirements are met.
 *
 * EXPLANATION:
 * The provided solution implements a simple Software Task Processing System, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Task` Class:**
 *     *   This class serves as a simple Plain Old Java Object (POJO) to model a task.
 *     *   It has `private` fields (`name`, `priority`, `duration`) ensuring encapsulation.
 *     *   `public` getter methods provide controlled access to the task's attributes.
 *     *   A constructor is used for creating `Task` instances.
 *     *   `toString()` is overridden for easy printing of task details.
 * 
 * 2.  **`TaskProcessorSystem` Class:**
 *     *   This is the core class managing the system state and logic.
 *     *   `pendingTasks`: A `Queue<Task>` is used here, specifically implemented by `LinkedList`. A `Queue` is the perfect data structure for managing tasks in a First-In, First-Out (FIFO) manner, as required for processing the "next" task.
 *     *   `completedTasks`: An `ArrayList<Task>` is used here, which implements the `List<Task>` interface. An `ArrayList` is suitable for storing completed tasks as it allows dynamic resizing and easy iteration for viewing.
 *     *   `scanner`: A `Scanner` object is used to read input from `System.in`. It's initialized once in the constructor and closed upon exiting the `runSystem` method.
 *     *   `addTask(String name, String priority, int duration)`:
 *         *   This method first performs input validation for the task name, priority string, and duration.
 *         *   `System.err.println()` is used to output validation error messages, fulfilling the requirement to use `System.err` for errors.
 *         *   If validation passes, a new `Task` object is created and added to the `pendingTasks` queue using `queue.add()`.
 *         *   `System.out.println()` is used for success messages.
 *     *   `processNextTask()`:
 *         *   Checks if the `pendingTasks` queue is empty.
 *         *   If not empty, it uses `queue.poll()` to retrieve and remove the task at the front of the queue.
 *         *   It simulates processing by printing messages to `System.out`.
 *         *   The processed task is then added to the `completedTasks` `ArrayList` using `list.add()`.
 *         *   A `try-catch` block is included around the processing simulation. While the simulation itself is simple and unlikely to throw an exception, this demonstrates how to handle potential errors that might occur during actual task execution in a real-world scenario.
 *     *   `viewPendingTasks()`:
 *         *   Iterates through the `pendingTasks` queue using an enhanced for loop (which uses the queue's iterator). This allows viewing elements without removing them.
 *         *   Prints task details using `System.out.println()`.
 *     *   `viewCompletedTasks()`:
 *         *   Iterates through the `completedTasks` `ArrayList`.
 *         *   Prints task details using `System.out.println()`.
 *     *   `runSystem()`:
 *         *   Contains the main application loop (`while (choice != 5)`).
 *         *   `printMenu()` displays the options using `System.out`.
 *         *   Reads the user's choice using `scanner.nextInt()` and handles potential `InputMismatchException` or other input errors by checking `scanner.hasNextInt()` and consuming invalid input, printing errors to `System.err`.
 *         *   A `switch` statement is used to direct execution based on the user's valid choice, calling the appropriate methods (`addTask`, `processNextTask`, etc.). This fulfills the requirement for using a `switch` statement.
 *         *   **Class-wide Exception Handling:** A large `try-catch (Exception e)` block wraps the core logic inside the `while` loop. This demonstrates catching unexpected runtime exceptions that might occur during any step of the user interaction or method calls within the loop, printing a generic error message to `System.err`.
 *         *   The `scanner` is closed when the loop exits (user chooses option 5).
 *     *   `main(String[] args)`: The entry point of the application, creating an instance of `TaskProcessorSystem` and calling `runSystem()` to start the interaction.
 * 
 * This solution effectively utilizes all the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) in a practical scenario, adhering to best practices like encapsulation, meaningful names, and basic error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Represents a software task with a name, priority, and duration.
 */
class Task {
    private String name;
    private String priority; // Using String as requested, could be enum for better practice
    private int duration;

    /**
     * Constructs a new Task.
     *
     * @param name The name of the task.
     * @param priority The priority of the task (e.g., "HIGH", "MEDIUM", "LOW").
     * @param duration The estimated duration in minutes.
     */
    public Task(String name, String priority, int duration) {
        this.name = name;
        this.priority = priority;
        this.duration = duration;
    }

    /**
     * Gets the task name.
     * @return The task name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the task priority.
     * @return The task priority.
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Gets the task duration.
     * @return The task duration in minutes.
     */
    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Task: " + name + ", Priority: " + priority + ", Duration: " + duration + " minutes";
    }
}

/**
 * Manages a queue of pending tasks and a list of completed tasks.
 */
public class TaskProcessorSystem { // Changed class name to match file name convention

    private Queue<Task> pendingTasks;
    private List<Task> completedTasks;
    private Scanner scanner;

    /**
     * Constructs a new TaskProcessorSystem.
     */
    public TaskProcessorSystem() {
        this.pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>(); // ArrayList implements List
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task to the pending queue after validation.
     *
     * @param name The name of the task.
     * @param priority The priority string ("HIGH", "MEDIUM", "LOW").
     * @param duration The duration in minutes.
     */
    public void addTask(String name, String priority, int duration) {
        // Input Validation
        if (name == null || name.trim().isEmpty()) {
            System.err.println("Error: Task name cannot be empty.");
            return;
        }
        String upperPriority = priority != null ? priority.toUpperCase() : "";
        if (!upperPriority.equals("HIGH") && !upperPriority.equals("MEDIUM") && !upperPriority.equals("LOW")) {
            System.err.println("Error: Invalid priority. Must be HIGH, MEDIUM, or LOW.");
            return;
        }
        if (duration <= 0) {
            System.err.println("Error: Duration must be a positive integer.");
            return;
        }

        Task newTask = new Task(name.trim(), upperPriority, duration);
        pendingTasks.add(newTask);
        System.out.println("Task '" + newTask.getName() + "' added to the queue.");
    }

    /**
     * Processes the next task from the pending queue.
     */
    public void processNextTask() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks to process.");
            return;
        }

        Task taskToProcess = pendingTasks.poll(); // Remove from front of queue
        System.out.println("Processing task: " + taskToProcess.getName());

        // Simulate processing (can add a delay or complex logic here)
        try {
            // In a real system, this would be actual work.
            // We'll simulate success for this example.
            System.out.println("Task '" + taskToProcess.getName() + "' completed.");
            completedTasks.add(taskToProcess); // Add to completed list
        } catch (Exception e) {
            // Example of catching an unexpected error during processing
            System.err.println("An unexpected error occurred while processing task '" + taskToProcess.getName() + "': " + e.getMessage());
            // Optionally, decide whether to requeue the task or mark it as failed
        }
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    public void viewPendingTasks() {
        System.out.println("Pending Tasks:");
        if (pendingTasks.isEmpty()) {
            System.out.println("(Queue is empty)");
        } else {
            // Iterate through the queue without removing elements
            for (Task task : pendingTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Displays all tasks in the completed list.
     */
    public void viewCompletedTasks() {
        System.out.println("Completed Tasks:");
        if (completedTasks.isEmpty()) {
            System.out.println("(No tasks completed yet)");
        } else {
            for (Task task : completedTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Runs the main system loop, handling user interaction.
     */
    public void runSystem() {
        int choice = -1;
        while (choice != 5) {
            // Class-wide exception handling for the main loop
            try {
                printMenu();
                System.out.print("Enter your choice: ");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                } else {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    continue; // Skip to next iteration
                }

                // Switch statement for flow control
                switch (choice) {
                    case 1:
                        System.out.print("Enter task name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                        String priority = scanner.nextLine();
                        System.out.print("Enter duration in minutes: ");
                        int duration = -1;
                        if (scanner.hasNextInt()) {
                            duration = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                        } else {
                            System.err.println("Error: Invalid duration. Please enter an integer.");
                            scanner.nextLine(); // Consume the invalid input
                            // Continue to the next iteration after error, addTask will handle duration <= 0
                        }
                        addTask(name, priority, duration);
                        break;
                    case 2:
                        processNextTask();
                        break;
                    case 3:
                        viewPendingTasks();
                        break;
                    case 4:
                        viewCompletedTasks();
                        break;
                    case 5:
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                // Catch any unexpected runtime exceptions in the loop
                System.err.println("An unexpected system error occurred: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging (optional in final exam)
                // Decide if the loop should continue or exit on unexpected error
                // For this example, we'll let it continue.
            }
            System.out.println(); // Add a blank line for readability
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("--- Task Processor System ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Exit");
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
