/*
 * Exam Question #1007
 * Generated on: 2025-05-12 17:11:55
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam: Advanced Task Management System
 * 
 * **Objective:** Implement a command-line application to manage tasks through different stages: Backlog, Processing, and Completed. This task requires demonstrating proficiency in using various Java collection types, user input handling, control flow structures, and robust error management.
 * 
 * **System Description:**
 * 
 * The Task Management System will track tasks for a small team. Tasks originate in a Backlog, move to a Processing Queue when work begins, and finally end up in a Completed list.
 * 
 * **Task Structure:** Each task should have a unique integer ID, a description (String), and a status (String: "Backlog", "Processing", or "Completed").
 * 
 * **System Components:**
 * 
 * 1.  **Backlog:** A list holding tasks that are waiting to be assigned. New tasks are added here.
 * 2.  **Processing Queue:** A queue holding tasks that are currently being worked on. Tasks are moved here from the Backlog and processed in a First-In, First-Out (FIFO) manner.
 * 3.  **Completed:** A list holding tasks that have been finished.
 * 
 * **Commands:** The application should accept the following commands from the user:
 * 
 * *   `add <description>`: Creates a new task with the given description and adds it to the Backlog. A unique ID should be assigned automatically.
 * *   `assign`: Moves the oldest task from the Backlog to the Processing Queue.
 * *   `complete`: Moves the oldest task from the Processing Queue to the Completed list.
 * *   `view <list_type>`: Displays tasks from the specified list. `<list_type>` can be "backlog", "processing", or "completed".
 * *   `exit`: Terminates the application.
 * 
 * **Requirements:**
 * 
 * 1.  Use `java.util.Queue` for the Processing Queue.
 * 2.  Use `java.util.ArrayList` for the Backlog and Completed lists.
 * 3.  Use `java.util.List` as the interface type when declaring variables that hold the `ArrayList` instances.
 * 4.  Use `java.util.Scanner` to read user input from the console.
 * 5.  Use a `switch` statement to handle the different user commands.
 * 6.  Use `System.err` to print error messages (e.g., invalid command, attempting to assign from an empty backlog, attempting to complete from an empty queue).
 * 7.  Use `System.out` for all normal output (menu, task lists, success messages).
 * 8.  Implement class-wide exception handling using `try-catch` blocks to gracefully handle unexpected errors during the command processing loop.
 * 9.  Follow best practices:
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (Javadocs are a plus, but clear inline comments are sufficient).
 *     *   Input validation (check for valid commands, valid `list_type`).
 *     *   Proper error handling for empty collections when assigning/completing.
 *     *   Clean code structure (e.g., separate classes for Task and TaskManager).
 * 
 * **Expected Output Format (for `view` command):**
 * 
 * For each task in the requested list, print a line like:
 * `[ID] [Status] Description: <description>`
 * 
 * Example:
 * `[1] Backlog Description: Write exam question`
 * `[5] Processing Description: Grade student papers`
 * `[2] Completed Description: Attend department meeting`
 * 
 * **Error Message Examples:**
 * 
 * *   If the command is not recognized: `Error: Unknown command. Type 'help' for available commands.` (You can add a help command or just list commands on startup).
 * *   If `assign` is called with an empty backlog: `Error: Backlog is empty. Cannot assign tasks.`
 * *   If `complete` is called with an empty processing queue: `Error: Processing queue is empty. Cannot complete tasks.`
 * *   If `view` is called with an invalid list type: `Error: Invalid list type. Use 'backlog', 'processing', or 'completed'.`
 * *   Any other unexpected error during command processing should be caught and printed to `System.err`.
 * 
 * **Constraints:**
 * *   Assume task descriptions can contain spaces.
 * *   Task IDs should start from 1 and be unique.
 * 
 * **Deliverables:**
 * 
 * Provide the complete Java source code for the Task Management System.
 * 
 * **Evaluation:**
 * 
 * Your solution will be evaluated based on:
 * *   Correctness of implementation according to the requirements.
 * *   Proper usage of all specified Java components.
 * *   Adherence to best practices (encapsulation, naming, comments, clean structure).
 * *   Effectiveness of input validation and error handling.
 * *   Readability and maintainability of the code.
 * 
 * Good luck!
 *
 * EXPLANATION:
 * The provided solution implements a simple command-line Task Management System according to the exam question requirements.
 * 
 * **Core Components and Their Usage:**
 * 
 * 1.  **`Task` Class:** A simple Plain Old Java Object (POJO) representing a task with `id`, `description`, and `status`. It includes a constructor, getters, a setter for status, and an overridden `toString()` method for easy printing. This demonstrates encapsulation.
 * 
 * 2.  **`TaskManager` Class:** This class holds and manages the three collections representing the task stages.
 *     *   `private List<Task> backlog;`: Declared as `List` interface, instantiated as `ArrayList`. This holds tasks waiting to be processed. `ArrayList` is suitable for adding to the end and removing from the beginning (though removing from the beginning is O(n), for a simple system it's acceptable; a `LinkedList` could also be used here if removals from the front were frequent and performance-critical).
 *     *   `private Queue<Task> processingQueue;`: Declared as `Queue` interface, instantiated as `LinkedList`. `LinkedList` is a common class that implements both `List` and `Queue`, making it a flexible choice. `Queue` is used here because tasks are processed in the order they are assigned (FIFO). `offer()` is used for adding and `poll()` for removing, which are standard `Queue` operations designed to handle capacity constraints (though not strictly necessary with `LinkedList`, it's good practice).
 *     *   `private List<Task> completedTasks;`: Declared as `List` interface, instantiated as `ArrayList`. This holds completed tasks. `ArrayList` is suitable as completed tasks are likely only added and viewed, not removed or processed further.
 *     *   `private int taskIdCounter;`: Used to generate unique IDs for new tasks.
 *     *   Methods like `addTask`, `assignTask`, `completeTask`, and `viewTasks` encapsulate the logic for manipulating these collections and task states.
 * 
 * 3.  **`TaskManagementSystem` Class (Main):**
 *     *   Contains the `main` method, the entry point of the application.
 *     *   `Scanner scanner = new Scanner(System.in);`: Used to read lines of input from the console (`System.in`).
 *     *   `TaskManager taskManager = new TaskManager();`: An instance of the manager class is created to hold the system's state.
 *     *   **Command Loop and `switch`:** A `while(running)` loop continuously reads user input. The input line is split to extract the command and any arguments. A `switch` statement is used to direct execution based on the command (`add`, `assign`, `complete`, `view`, `exit`, default). This fulfills the `switch` requirement for flow control.
 *     *   **Input Validation:** Basic validation is performed for commands requiring arguments (`add`, `view`) and for the `view` command's argument (`listType`) within the `TaskManager.viewTasks` method.
 *     *   **`System.out` and `System.err`:** `System.out.println` is used for printing the menu, successful actions, and task lists. `System.err.println` is used for printing error messages, such as unknown commands, missing arguments, or attempts to perform actions on empty collections.
 *     *   **`try-catch` for Exception Handling:** A `try-catch(Exception e)` block is wrapped around the main `while` loop in the `main` method. This demonstrates class-wide exception handling. If any unexpected `Exception` occurs during the processing of commands (e.g., issues with input or other unforeseen runtime errors), it will be caught, an error message will be printed to `System.err`, including the stack trace, and the program will attempt to terminate gracefully (the `finally` block ensures the scanner is closed). This fulfills the class-wide `try-catch` requirement.
 *     *   **Error Handling for Collections:** The `assignTask` and `completeTask` methods explicitly check if the `backlog` or `processingQueue` are empty before attempting to remove elements. If they are empty, an appropriate error message is printed to `System.err`, fulfilling the specific error handling requirements for these operations.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Fields in `Task` and `TaskManager` are private, accessed via public methods.
 * *   **Meaningful Names:** Variables (`backlog`, `processingQueue`, `taskIdCounter`), classes (`Task`, `TaskManager`), and methods (`addTask`, `assignTask`, `completeTask`, `viewTasks`) have names that clearly indicate their purpose.
 * *   **Comments and Documentation:** Javadoc-style comments are used for classes and methods, explaining their purpose and parameters. Inline comments clarify specific logic where needed.
 * *   **Input Validation:** Checks are included for command arguments and list types.
 * *   **Proper Error Handling:** Specific error messages are provided for different failure conditions, and a general `try-catch` handles unexpected runtime issues. `System.err` is used appropriately.
 * *   **Clean Code Structure:** The code is divided into logical classes (`Task`, `TaskManager`, `Main`), making it modular and easier to understand. The `main` method focuses on user interaction, delegating task management logic to the `TaskManager`.
 * 
 * This solution effectively integrates all required components into a functional command-line application, demonstrating a solid understanding of fundamental and intermediate Java concepts.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList can implement both List and Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException; // Although we read strings, good practice to know

/**
 * Represents a single task in the system.
 */
class Task {
    private int id;
    private String description;
    private String status; // e.g., "Backlog", "Processing", "Completed"

    public Task(int id, String description, String status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + status + " Description: " + description;
    }
}

/**
 * Manages the collections of tasks (Backlog, Processing Queue, Completed).
 */
class TaskManager {
    private List<Task> backlog;
    private Queue<Task> processingQueue;
    private List<Task> completedTasks;
    private int taskIdCounter;

    public TaskManager() {
        this.backlog = new ArrayList<>();
        // LinkedList is a common Queue implementation
        this.processingQueue = new LinkedList<>();
        this.completedTasks = new ArrayList<>();
        this.taskIdCounter = 0;
    }

    /**
     * Adds a new task to the backlog.
     * @param description The description of the task.
     */
    public void addTask(String description) {
        taskIdCounter++;
        Task newTask = new Task(taskIdCounter, description, "Backlog");
        backlog.add(newTask);
        System.out.println("Task added to backlog: " + newTask);
    }

    /**
     * Moves the oldest task from the backlog to the processing queue.
     * Handles the case where the backlog is empty.
     */
    public void assignTask() {
        if (backlog.isEmpty()) {
            System.err.println("Error: Backlog is empty. Cannot assign tasks.");
            return;
        }

        // Take the first task from the backlog (index 0)
        Task taskToAssign = backlog.remove(0);
        taskToAssign.setStatus("Processing");
        processingQueue.offer(taskToAssign); // offer is preferred for queues
        System.out.println("Task assigned to processing: " + taskToAssign);
    }

    /**
     * Moves the oldest task from the processing queue to the completed list.
     * Handles the case where the processing queue is empty.
     */
    public void completeTask() {
        // poll() retrieves and removes the head of the queue, returns null if empty
        Task taskToComplete = processingQueue.poll();

        if (taskToComplete == null) {
            System.err.println("Error: Processing queue is empty. Cannot complete tasks.");
            return;
        }

        taskToComplete.setStatus("Completed");
        completedTasks.add(taskToComplete);
        System.out.println("Task completed: " + taskToComplete);
    }

    /**
     * Displays tasks from the specified list type.
     * @param listType The type of list to view ("backlog", "processing", "completed").
     * @return true if the list type was valid, false otherwise.
     */
    public boolean viewTasks(String listType) {
        System.out.println("\n--- " + listType.toUpperCase() + " ---");
        switch (listType.toLowerCase()) {
            case "backlog":
                if (backlog.isEmpty()) {
                    System.out.println("Backlog is empty.");
                } else {
                    for (Task task : backlog) {
                        System.out.println(task);
                    }
                }
                break;
            case "processing":
                // Iterating over a queue without removing elements
                if (processingQueue.isEmpty()) {
                    System.out.println("Processing queue is empty.");
                } else {
                     // Convert queue to a temporary list for easy iteration if needed,
                     // or iterate directly using the queue's iterator.
                     // Direct iteration is fine and doesn't remove elements.
                     for (Task task : processingQueue) {
                         System.out.println(task);
                     }
                }
                break;
            case "completed":
                if (completedTasks.isEmpty()) {
                    System.out.println("Completed tasks list is empty.");
                } else {
                    for (Task task : completedTasks) {
                        System.out.println(task);
                    }
                }
                break;
            default:
                System.err.println("Error: Invalid list type. Use 'backlog', 'processing', or 'completed'.");
                return false; // Indicate invalid type
        }
        System.out.println("-------------------");
        return true; // Indicate valid type processed
    }
}

/**
 * Main class for the Task Management System application.
 * Handles user interaction and command processing.
 */
public class TaskManagementSystem {

    private static void printMenu() {
        System.out.println("\n--- Task Management Menu ---");
        System.out.println("add <description> - Add a new task");
        System.out.println("assign            - Assign next task from backlog to processing");
        System.out.println("complete          - Complete next task from processing queue");
        System.out.println("view <list_type>  - View tasks (backlog, processing, completed)");
        System.out.println("exit              - Exit the application");
        System.out.println("--------------------------");
        System.out.print("Enter command: ");
    }

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Task Management System started.");
        printMenu();

        // Class-wide exception handling for the main command loop
        try {
            while (running) {
                String inputLine = scanner.nextLine().trim();
                if (inputLine.isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] parts = inputLine.split(" ", 2); // Split into command and argument part
                String command = parts[0].toLowerCase();

                switch (command) {
                    case "add":
                        if (parts.length > 1) {
                            String description = parts[1].trim();
                            if (!description.isEmpty()) {
                                taskManager.addTask(description);
                            } else {
                                System.err.println("Error: Add command requires a description.");
                            }
                        } else {
                            System.err.println("Error: Add command requires a description.");
                        }
                        break;
                    case "assign":
                        if (parts.length == 1) {
                            taskManager.assignTask();
                        } else {
                             System.err.println("Error: Assign command does not take arguments.");
                        }
                        break;
                    case "complete":
                         if (parts.length == 1) {
                            taskManager.completeTask();
                         } else {
                             System.err.println("Error: Complete command does not take arguments.");
                         }
                        break;
                    case "view":
                        if (parts.length > 1) {
                            String listType = parts[1].trim();
                            taskManager.viewTasks(listType);
                        } else {
                            System.err.println("Error: View command requires a list type (backlog, processing, completed).");
                        }
                        break;
                    case "exit":
                        running = false;
                        System.out.println("Exiting Task Management System. Goodbye!");
                        break;
                    default:
                        System.err.println("Error: Unknown command '" + command + "'.");
                        printMenu(); // Show menu again on unknown command
                        break;
                }
                // Re-print menu after processing a command, unless exiting
                if(running) {
                     printMenu();
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the command loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
            // Ensure scanner is closed
            scanner.close();
        }
    }
}
