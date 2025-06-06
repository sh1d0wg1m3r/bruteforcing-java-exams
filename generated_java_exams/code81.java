/*
 * Exam Question #81
 * Generated on: 2025-05-11 22:10:19
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Subject:** Advanced Java Programming
 * **Task Title:** Simple Task Scheduler and History System
 * 
 * **Problem Description:**
 * 
 * Design and implement a Java program for a simple task scheduling system. The system should allow users to add tasks, process the next task in the queue, view the current task queue, and view a history of completed tasks.
 * 
 * Your solution must demonstrate proficiency in using core Java collections, input handling, control flow, and exception handling.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with private fields for `description` (String) and `priority` (String, e.g., "High", "Medium", "Low"). Include a constructor, public getter methods for the fields, and a `toString()` method that returns a formatted string representation of the task (e.g., "Task: [Description] (Priority: [Priority])").
 * 
 * 2.  **Task Scheduler Class:** Create a `TaskScheduler` class that manages the tasks.
 *     *   It must contain a private field `taskQueue` of type `java.util.Queue<Task>` to hold tasks awaiting processing.
 *     *   It must contain a private field `completedTasks` of type `java.util.List<Task>` to store tasks that have been processed. You must initialize this field using `java.util.ArrayList`.
 *     *   Implement the following public methods:
 *         *   `addTask(String description, String priority)`: Creates a new `Task` object and adds it to the `taskQueue`. Include basic validation: description cannot be empty, and priority should be one of "High", "Medium", or "Low". If validation fails, print an error message to `System.err` and do not add the task. Otherwise, print a success message to `System.out`.
 *         *   `processNextTask()`: Removes the next task from the front of the `taskQueue`. If the queue is empty, print an error message to `System.err`. If a task is successfully removed, add it to the `completedTasks` list and print a success message to `System.out` including the task details.
 *         *   `viewQueue()`: Prints the details of all tasks currently in the `taskQueue` to `System.out`, in order. If the queue is empty, print a message indicating that.
 *         *   `viewCompletedTasks()`: Prints the details of all tasks in the `completedTasks` list to `System.out`. If the list is empty, print a message indicating that.
 *         *   `run()`: This method should contain the main application loop. It interacts with the user via `Scanner`, displays a menu, reads user commands, and calls the appropriate methods based on the command.
 * 
 * 3.  **User Interface (in `run()` method):**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Display a menu with options: `add` (add task), `process` (process next task), `view_queue` (view pending tasks), `view_history` (view completed tasks), `exit` (quit the program).
 *     *   Use a `switch` statement to handle the different user commands.
 *     *   Prompt the user for necessary information (description, priority) when adding a task.
 * 
 * 4.  **Error Handling:**
 *     *   Use `System.err` exclusively for printing error messages (e.g., invalid input, empty queue).
 *     *   Use `System.out` for all other output (menu, prompts, success messages, list displays).
 *     *   Implement class-wide exception handling using a `try-catch` block within the `run()` method's main loop to catch potential runtime errors during command processing and print a generic error message to `System.err`.
 * 
 * 5.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful names for variables, methods, and classes.
 *     *   Include appropriate comments (Javadoc for classes/methods, inline for complex logic if any).
 *     *   Ensure clean code structure and formatting.
 * 
 * **Example Interaction:**
 * 
 * ```
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: add
 * Enter task description: Write exam question
 * Enter task priority (High/Medium/Low): High
 * Task added: Task: Write exam question (Priority: High)
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: add
 * Enter task description: Grade exams
 * Enter task priority (High/Medium/Low): Medium
 * Task added: Task: Grade exams (Priority: Medium)
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: view_queue
 * Pending Tasks:
 * 1. Task: Write exam question (Priority: High)
 * 2. Task: Grade exams (Priority: Medium)
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: process
 * Processing task: Task: Write exam question (Priority: High)
 * Task completed and moved to history.
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit          : Exit the program
 * ---------------------------
 * Enter command: view_queue
 * Pending Tasks:
 * 1. Task: Grade exams (Priority: Medium)
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: view_history
 * Completed Tasks:
 * 1. Task: Write exam question (Priority: High)
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: process
 * Processing task: Task: Grade exams (Priority: Medium)
 * Task completed and moved to history.
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: process
 * Error: Task queue is empty. No task to process.
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: view_history
 * Completed Tasks:
 * 1. Task: Write exam question (Priority: High)
 * 2. Task: Grade exams (Priority: Medium)
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: invalid_command
 * Error: Invalid command. Please try again.
 * 
 * --- Task Scheduler Menu ---
 * add          : Add a new task
 * process      : Process the next task
 * view_queue   : View pending tasks
 * view_history : View completed tasks
 * exit         : Exit the program
 * ---------------------------
 * Enter command: exit
 * Exiting Task Scheduler.
 * ```
 * 
 * **Note:** Pay close attention to using the specified types (`Queue`, `List`, `ArrayList`) and output streams (`System.out`, `System.err`).
 *
 * EXPLANATION:
 * The provided solution implements a simple task scheduling system demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Task` Class:** This is a basic Plain Old Java Object (POJO) representing a task. It follows encapsulation principles with private fields (`description`, `priority`) and public getter methods. The `toString()` method provides a convenient way to print task information.
 * 
 * 2.  **`TaskScheduler` Class:** This is the core class managing the system state and operations.
 *     *   **`Queue<Task> taskQueue`:** A `java.util.Queue` is used to store tasks awaiting processing. The `LinkedList` class is a common implementation of the `Queue` interface, providing FIFO (First-In, First-Out) behavior suitable for a processing queue. Tasks are added using `offer()` and removed using `poll()`.
 *     *   **`List<Task> completedTasks`:** A `java.util.List` is used to store tasks after they have been processed. The `ArrayList` class is used for the concrete implementation, providing dynamic resizing and efficient element access by index, which is suitable for maintaining a history. Using the `List` interface for the variable declaration is a good practice, allowing flexibility to change the underlying implementation later if needed.
 *     *   **`addTask(String description, String priority)`:** This method demonstrates input validation. It checks if the description is empty and if the priority is one of the expected values ("High", "Medium", "Low"), performing case-insensitive comparison for priority. It uses `System.err` for validation errors and `System.out` for success messages. Valid tasks are added to the `taskQueue` using `offer()`.
 *     *   **`processNextTask()`:** This method handles removing and completing a task. It first checks if the `taskQueue` is empty using `isEmpty()`. If empty, it prints an error to `System.err`. If not empty, it uses `poll()` to retrieve and remove the head of the queue, adds the retrieved task to the `completedTasks` list, and prints status messages to `System.out`.
 *     *   **`viewQueue()`:** This method iterates through the `taskQueue` to display its contents. It creates a temporary `ArrayList` from the queue to easily iterate and display tasks with indices without modifying the queue itself. Output goes to `System.out`.
 *     *   **`viewCompletedTasks()`:** This method iterates through the `completedTasks` `List` and prints each completed task to `System.out`.
 *     *   **`run()`:** This is the main application loop.
 *         *   It initializes a `Scanner` for user input.
 *         *   It contains a `while` loop that continues until the `running` flag is set to `false` (by the "exit" command).
 *         *   Inside the loop, it prints the menu using a helper method `printMenu()` and reads the user's command using `scanner.nextLine()`. The command is trimmed and converted to lowercase for case-insensitive comparison.
 *         *   A `switch` statement is used to handle the different command strings, directing execution to the appropriate methods (`addTask`, `processNextTask`, `viewQueue`, `viewCompletedTasks`).
 *         *   The "add" case demonstrates reading multiple lines of input using `scanner.nextLine()` for the description and priority.
 *         *   The "exit" case sets the `running` flag to `false`.
 *         *   The `default` case in the `switch` handles invalid commands, printing an error to `System.err`.
 *         *   **Class-wide Exception Handling:** The entire `while` loop within `run()` is wrapped in a `try-catch(Exception e)` block. This provides a safety net to catch any unexpected runtime exceptions that might occur during the execution of the commands or input processing, preventing the program from crashing abruptly. A generic error message is printed to `System.err`.
 *         *   A `finally` block ensures that the `Scanner` is closed when the loop finishes or if an exception occurs, releasing system resources.
 * 
 * 3.  **Input/Output Streams:** `System.out` is used for all standard output, prompts, menus, and success messages as required. `System.err` is strictly used for error messages, such as invalid input or attempting to process an empty queue.
 * 
 * 4.  **Best Practices:** The code adheres to best practices by using private fields, public methods (encapsulation), descriptive naming, Javadoc comments, inline comments where necessary, basic input validation, and structured error handling with `try-catch` and `System.err`. Using interfaces (`Queue`, `List`) where appropriate promotes flexibility.
 * 
 * This solution effectively combines various fundamental and intermediate Java concepts to build a functional, albeit simple, application, fulfilling all the requirements of the exam question.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Locale; // Recommended for case-insensitive comparison

/**
 * Represents a single task with a description and priority.
 */
class Task {
    private String description;
    private String priority;

    /**
     * Constructs a new Task.
     * @param description The description of the task.
     * @param priority The priority of the task (e.g., "High", "Medium", "Low").
     */
    public Task(String description, String priority) {
        this.description = description;
        this.priority = priority;
    }

    /**
     * Gets the task description.
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the task priority.
     * @return The priority.
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Returns a string representation of the task.
     * @return Formatted string for the task.
     */
    @Override
    public String toString() {
        return "Task: " + description + " (Priority: " + priority + ")";
    }
}

/**
 * Manages a queue of tasks and a history of completed tasks.
 */
public class TaskScheduler {
    private Queue<Task> taskQueue;
    private List<Task> completedTasks;

    /**
     * Constructs a new TaskScheduler.
     * Initializes the task queue and completed tasks list.
     */
    public TaskScheduler() {
        // Use LinkedList as an implementation of Queue
        this.taskQueue = new LinkedList<>();
        // Use ArrayList as an implementation of List
        this.completedTasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the queue after validation.
     * @param description The description of the task.
     * @param priority The priority of the task (High, Medium, Low).
     */
    public void addTask(String description, String priority) {
        // Input validation
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return;
        }

        // Normalize priority input for case-insensitive comparison
        String normalizedPriority = priority != null ? priority.trim().toLowerCase(Locale.US) : "";
        boolean validPriority = normalizedPriority.equals("high") ||
                                normalizedPriority.equals("medium") ||
                                normalizedPriority.equals("low");

        if (!validPriority) {
            System.err.println("Error: Invalid priority. Please use 'High', 'Medium', or 'Low'.");
            return;
        }

        // Create task and add to queue
        Task newTask = new Task(description.trim(), priority.trim());
        taskQueue.offer(newTask); // offer is preferred over add for bounded queues, but works fine here
        System.out.println("Task added: " + newTask);
    }

    /**
     * Processes (removes) the next task from the queue and moves it to history.
     */
    public void processNextTask() {
        if (taskQueue.isEmpty()) {
            System.err.println("Error: Task queue is empty. No task to process.");
            return;
        }

        // poll() retrieves and removes the head of the queue, returns null if empty
        // We already checked for empty, so poll() will return a Task
        Task processedTask = taskQueue.poll();

        completedTasks.add(processedTask);
        System.out.println("Processing task: " + processedTask);
        System.out.println("Task completed and moved to history.");
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    public void viewQueue() {
        if (taskQueue.isEmpty()) {
            System.out.println("Pending Tasks: Queue is empty.");
            return;
        }

        System.out.println("Pending Tasks:");
        // Iterate without removing elements. Convert to List for easy indexed access.
        List<Task> pendingList = new ArrayList<>(taskQueue);
        for (int i = 0; i < pendingList.size(); i++) {
            System.out.println((i + 1) + ". " + pendingList.get(i));
        }
    }

    /**
     * Displays all tasks in the completed tasks history.
     */
    public void viewCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("Completed Tasks: History is empty.");
            return;
        }

        System.out.println("Completed Tasks:");
        for (int i = 0; i < completedTasks.size(); i++) {
            System.out.println((i + 1) + ". " + completedTasks.get(i));
        }
    }

    /**
     * Runs the main application loop, handling user input and commands.
     * Includes class-wide exception handling.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling around the main application loop
        try {
            while (running) {
                printMenu();
                System.out.print("Enter command: ");
                String command = scanner.nextLine().trim().toLowerCase(Locale.US); // Read command and normalize

                switch (command) {
                    case "add":
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine(); // Read description
                        System.out.print("Enter task priority (High/Medium/Low): ");
                        String priority = scanner.nextLine(); // Read priority
                        addTask(description, priority); // Call method
                        break;

                    case "process":
                        processNextTask(); // Call method
                        break;

                    case "view_queue":
                        viewQueue(); // Call method
                        break;

                    case "view_history":
                        viewCompletedTasks(); // Call method
                        break;

                    case "exit":
                        running = false; // Set flag to exit loop
                        System.out.println("Exiting Task Scheduler.");
                        break;

                    default:
                        System.err.println("Error: Invalid command. Please try again."); // Invalid command error
                        break;
                }
                System.out.println(); // Add a newline for better readability between commands
            }
        } catch (Exception e) {
            // Generic catch-all for unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // Optionally print stack trace for debugging during development/testing
            // e.printStackTrace(System.err);
        } finally {
            // Ensure scanner is closed regardless of exceptions
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Prints the main menu options to System.out.
     */
    private void printMenu() {
        System.out.println("--- Task Scheduler Menu ---");
        System.out.println("add          : Add a new task");
        System.out.println("process      : Process the next task");
        System.out.println("view_queue   : View pending tasks");
        System.out.println("view_history : View completed tasks");
        System.out.println("exit         : Exit the program");
        System.out.println("---------------------------");
    }

    /**
     * Main method to start the Task Scheduler application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.run(); // Start the main application loop
    }
}
