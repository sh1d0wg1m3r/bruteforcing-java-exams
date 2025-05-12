/*
 * Exam Question #14
 * Generated on: 2025-05-11 21:34:13
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Office Task Management System
 * 
 * **Scenario:**
 * 
 * Your company needs a simple command-line application to manage office tasks. Tasks arrive and need to be processed in a specific order (first-in, first-out), and completed tasks should be archived. The system should allow users to add new tasks, process the next available task, view pending tasks, and view completed tasks. The system must be robust, handling invalid user input and potential operational errors gracefully.
 * 
 * **Task Requirements:**
 * 
 * Implement a Java program named `TaskManagementSystem` that fulfills the following requirements:
 * 
 * 1.  **Task Representation:** Create a class `Task` that represents a single task. It should have private fields for:
 *     *   A unique integer ID (automatically assigned by the system).
 *     *   A String description.
 *     *   A `Priority` (use an enum: `HIGH`, `MEDIUM`, `LOW`).
 *     *   A String status (e.g., "Pending", "Completed").
 *     *   Include a constructor, appropriate getters, and a method to update the status. Implement a `toString()` method for easy printing.
 * 
 * 2.  **Data Structures:**
 *     *   Maintain a collection of pending tasks using a `java.util.Queue`. Tasks should be processed in the order they are added.
 *     *   Maintain a collection of completed tasks using a `java.util.ArrayList`. Declare this variable using the `java.util.List` interface type.
 * 
 * 3.  **User Interface:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user:
 *         1.  Add New Task
 *         2.  Process Next Task
 *         3.  View Pending Tasks
 *         4.  View Completed Tasks
 *         0.  Exit
 *     *   Use a `switch` statement to handle the user's choice.
 * 
 * 4.  **Functionality:**
 *     *   **Add New Task:** Prompt the user for a description and priority (input as "HIGH", "MEDIUM", or "LOW"). Create a new `Task` object with a unique ID, set its status to "Pending", and add it to the pending tasks queue.
 *     *   **Process Next Task:** Take the task from the front of the pending tasks queue. If a task is retrieved, update its status to "Completed" and move it to the completed tasks list. If the queue is empty, inform the user.
 *     *   **View Pending Tasks:** Display all tasks currently in the pending queue in their current order.
 *     *   **View Completed Tasks:** Display all tasks in the completed list.
 *     *   **Exit:** Terminate the program.
 * 
 * 5.  **Error Handling and Input Validation:**
 *     *   Use `System.err.println()` to print error messages (e.g., invalid menu choice, invalid priority input, attempting to process from an empty queue).
 *     *   Use `System.out.println()` for normal output (menu, prompts, success messages, task details).
 *     *   Implement input validation for user choices (must be a number corresponding to a menu option).
 *     *   Implement validation for task priority input (must match one of the enum values). Handle invalid priority input gracefully using a `try-catch` block around the enum parsing.
 *     *   Implement class-wide exception handling using a `try-catch` block that wraps the main user interaction loop or core processing logic to catch unexpected runtime errors and prevent the program from crashing abruptly.
 * 
 * 6.  **Best Practices:**
 *     *   Follow proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments where necessary.
 *     *   Ensure resource cleanup (e.g., closing the `Scanner`).
 * 
 * **Expected Output:**
 * 
 * The program should interact with the user via the console. Example interaction might look like this (user input is bold):
 * 
 * ```
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. Process Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 0. Exit
 * ----------------------------
 * Enter your choice: **1**
 * 
 * --- Add New Task ---
 * Enter task description: **Write report**
 * Enter task priority (HIGH, MEDIUM, LOW): **HIGH**
 * Task added: Task [ID=1, Desc='Write report', Priority=HIGH, Status=Pending]
 * 
 * --- Task Management Menu ---
 * 1. Add New Task
 * ... (menu repeats)
 * Enter your choice: **1**
 * 
 * --- Add New Task ---
 * Enter task description: **Schedule meeting**
 * Enter task priority (HIGH, MEDIUM, LOW): **medium**
 * Task added: Task [ID=2, Desc='Schedule meeting', Priority=MEDIUM, Status=Pending]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **3**
 * 
 * --- Pending Tasks ---
 * 1. Task [ID=1, Desc='Write report', Priority=HIGH, Status=Pending]
 * 2. Task [ID=2, Desc='Schedule meeting', Priority=MEDIUM, Status=Pending]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **2**
 * 
 * --- Process Next Task ---
 * Task processed: Task [ID=1, Desc='Write report', Priority=HIGH, Status=Completed]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **3**
 * 
 * --- Pending Tasks ---
 * 1. Task [ID=2, Desc='Schedule meeting', Priority=MEDIUM, Status=Pending]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **4**
 * 
 * --- Completed Tasks ---
 * 1. Task [ID=1, Desc='Write report', Priority=HIGH, Status=Completed]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **2**
 * 
 * --- Process Next Task ---
 * Task processed: Task [ID=2, Desc='Schedule meeting', Priority=MEDIUM, Status=Completed]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **2**
 * 
 * --- Process Next Task ---
 * No pending tasks to process.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **99**
 * Invalid choice. Please try again.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **add**
 * Invalid input. Please enter a number.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **1**
 * 
 * --- Add New Task ---
 * Enter task description: **Test invalid priority**
 * Enter task priority (HIGH, MEDIUM, LOW): **URGENT**
 * Error: Invalid priority entered. Task not added.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: **0**
 * Exiting Task Management System. Goodbye!
 * ```
 * 
 * Your solution must be a single Java file containing all necessary classes and the `main` method.
 *
 * EXPLANATION:
 * This solution implements a simple Office Task Management System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Priority` Enum: Defines the possible priority levels for tasks, providing type safety and readability over using raw strings.
 *     *   `Task` Class: Encapsulates the data for a single task (ID, description, priority, status). It uses private fields, public getters, a setter for status, and overrides `toString()` for convenient printing.
 *     *   `TaskManagementSystem` Class: Contains the core logic and data structures. It holds the collections of tasks and the main application loop.
 * 
 * 2.  **Data Structures:**
 *     *   `Queue<Task> pendingTasks`: A `LinkedList` is used as an implementation of the `Queue` interface. This is suitable for pending tasks because new tasks are added to the end (`offer`), and tasks are processed from the beginning (`poll`), adhering to the First-In, First-Out (FIFO) principle.
 *     *   `List<Task> completedTasks`: An `ArrayList` is used as an implementation of the `List` interface. This is suitable for completed tasks as they are added sequentially, and we might want to access or iterate over them by index or simply maintain an ordered list. Declaring it as `List` promotes good practice by programming to the interface.
 * 
 * 3.  **User Interaction and Control Flow:**
 *     *   `Scanner`: An instance of `Scanner` reads user input from `System.in`. `scanner.nextLine()` is used to read entire lines, which helps avoid common pitfalls with mixed `nextInt()`/`nextLine()` calls.
 *     *   `printMenu()`: A helper method displays the available options.
 *     *   `runSystem()`: This method contains the main application loop (`while (choice != 0)`).
 *     *   `switch` statement: Used within the loop to direct execution based on the user's numeric choice, calling the appropriate methods (`addTask`, `processNextTask`, etc.).
 * 
 * 4.  **Functionality Implementation:**
 *     *   `addTask()`: Prompts for description and priority. It uses `Priority.valueOf()` to convert the user's string input into a `Priority` enum value. A counter (`nextTaskId`) ensures unique IDs. New tasks are added to the `pendingTasks` queue using `offer()`.
 *     *   `processNextTask()`: Uses `pendingTasks.poll()` to retrieve and remove the head of the queue. `poll()` is safer than `remove()` as it returns `null` if the queue is empty, allowing for graceful handling. The processed task's status is updated, and it's added to the `completedTasks` list.
 *     *   `viewPendingTasks()` and `viewCompletedTasks()`: These methods iterate through the respective collections and print the details of each task using the `Task` class's `toString()` method.
 * 
 * 5.  **Error Handling and Validation:**
 *     *   `System.err`: Used specifically for printing error messages, distinguishing them from standard output.
 *     *   Input Validation (Choice): A `try-catch (NumberFormatException)` block is wrapped around `Integer.parseInt(scanner.nextLine())` in `runSystem`. This catches cases where the user enters non-numeric input for the menu choice, printing an error to `System.err` and preventing a program crash.
 *     *   Input Validation (Priority): A `try-catch (IllegalArgumentException)` block is wrapped around `Priority.valueOf(priorityInput)` in `addTask()`. The `valueOf()` method throws this exception if the input string does not match any enum constant name. Catching it allows the system to inform the user of the invalid priority and skip adding the task, rather than crashing.
 *     *   Empty Queue Handling: `processNextTask()` checks if `pendingTasks.poll()` returns `null`, indicating an empty queue, and prints an informative message to `System.err`.
 *     *   Class-Wide Exception Handling: A general `try-catch (Exception e)` block surrounds the main `while` loop in `runSystem()`. This serves as a catch-all for any other unexpected runtime exceptions that might occur during the execution of the loop or the methods it calls, preventing the program from terminating abruptly and providing a basic error message to `System.err`.
 *     *   Resource Cleanup: A `finally` block in `runSystem()` ensures that the `Scanner` is closed regardless of whether the loop finishes normally or an exception is caught, releasing system resources.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation is maintained in both `Task` and `TaskManagementSystem` classes.
 *     *   Variable and method names are descriptive (e.g., `pendingTasks`, `processNextTask`).
 *     *   Comments explain key parts of the code.
 *     *   Input validation is performed before processing user commands or data.
 * 
 * This solution effectively uses all required Java components in a practical scenario, demonstrates robust error handling and input validation, and follows key object-oriented programming principles and best practices.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.lang.IllegalArgumentException; // Required for enum valueOf errors
import java.util.InputMismatchException; // Although not strictly needed with nextLine() + parseInt(), good to know

// Enum for Task Priority
enum Priority {
    HIGH, MEDIUM, LOW
}

// Task Class
class Task {
    private int id;
    private String description;
    private Priority priority;
    private String status; // e.g., "Pending", "Completed"

    /**
     * Constructs a new Task.
     * @param id The unique ID for the task.
     * @param description A brief description of the task.
     * @param priority The priority level of the task.
     */
    public Task(int id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = "Pending"; // Default status upon creation
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    // --- Setter for status ---
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the Task.
     * @return Formatted string including ID, Description, Priority, and Status.
     */
    @Override
    public String toString() {
        return "Task [ID=" + id + ", Desc='" + description + "', Priority=" + priority + ", Status=" + status + "]";
    }
}

// Main Task Management System Class
public class TaskManagementSystem {

    // Use Queue for pending tasks (FIFO)
    private Queue<Task> pendingTasks;
    // Use List for completed tasks (ordered collection)
    private List<Task> completedTasks;
    private int nextTaskId; // Counter for assigning unique task IDs
    private Scanner scanner; // Scanner for user input

    /**
     * Constructs a new TaskManagementSystem.
     * Initializes the task collections and scanner.
     */
    public TaskManagementSystem() {
        // LinkedList is a common implementation of Queue
        pendingTasks = new LinkedList<>();
        // ArrayList is a common implementation of List
        completedTasks = new ArrayList<>();
        nextTaskId = 1; // Task IDs start from 1
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a new task based on user input.
     * Prompts for description and priority. Handles invalid priority input.
     */
    public void addTask() {
        System.out.println("\n--- Add New Task ---");
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        // Basic validation for description
        if (description.trim().isEmpty()) {
             System.err.println("Error: Task description cannot be empty. Task not added.");
             return; // Stop adding the task
        }

        System.out.print("Enter task priority (HIGH, MEDIUM, LOW): ");
        String priorityInput = scanner.nextLine().trim().toUpperCase(); // Read, trim, and convert to uppercase

        Priority priority = null;
        // Use try-catch for robust enum parsing
        try {
            priority = Priority.valueOf(priorityInput);
        } catch (IllegalArgumentException e) {
            // Catch the exception if the input string doesn't match an enum constant
            System.err.println("Error: Invalid priority '" + priorityInput + "' entered. Task not added.");
            return; // Exit the method if priority is invalid
        }

        // Create and add the new task to the pending queue
        Task newTask = new Task(nextTaskId++, description, priority);
        pendingTasks.offer(newTask); // offer() is preferred over add() for queues as it doesn't throw exception if capacity is full
        System.out.println("Task added: " + newTask.toString());
    }

    /**
     * Processes the next task from the pending queue.
     * Removes the task from the queue, updates status, and adds to completed list.
     */
    public void processNextTask() {
        System.out.println("\n--- Process Next Task ---");
        // poll() retrieves and removes the head of the queue, returns null if empty
        Task taskToProcess = pendingTasks.poll();

        if (taskToProcess == null) {
            // Use System.err as this is a message about an action failing
            System.err.println("No pending tasks to process.");
        } else {
            taskToProcess.setStatus("Completed"); // Update task status
            completedTasks.add(taskToProcess); // Add to the completed list
            System.out.println("Task processed: " + taskToProcess.toString());
        }
    }

    /**
     * Displays all tasks currently in the pending tasks queue.
     */
    public void viewPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            // Iterate over the queue without removing elements
            // LinkedList iteration order matches queue order
            int count = 1;
            for (Task task : pendingTasks) {
                System.out.println(count++ + ". " + task.toString());
            }
        }
    }

    /**
     * Displays all tasks currently in the completed tasks list.
     */
    public void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            // Iterate over the list
            for (int i = 0; i < completedTasks.size(); i++) {
                System.out.println((i + 1) + ". " + completedTasks.get(i).toString());
            }
        }
    }

    /**
     * Runs the main loop of the Task Management System.
     * Handles user input and command dispatch using a switch statement.
     * Includes class-wide exception handling.
     */
    public void runSystem() {
        int choice = -1; // Initialize choice to a non-menu value

        // Class-wide exception handling around the main operational loop
        try {
            while (choice != 0) {
                printMenu();
                System.out.print("Enter your choice: ");

                // Use try-catch for Scanner input parsing to handle non-integer input
                try {
                    // Read the entire line to consume newline character and parse
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    // Use System.err for input format errors
                    System.err.println("Invalid input. Please enter a number.");
                    choice = -1; // Reset choice to continue loop and show menu again
                    continue; // Skip the rest of the loop body for this iteration
                }

                // Switch statement to handle user commands
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
                        viewCompletedTasks();
                        break;
                    case 0:
                        System.out.println("Exiting Task Management System. Goodbye!");
                        break;
                    default:
                        // Use System.err for invalid command errors
                        System.err.println("Invalid choice. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            // Generic catch block for any other unexpected runtime exceptions
            System.err.println("\nAn unexpected system error occurred!");
            System.err.println("Error details: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for detailed debugging stack trace
        } finally {
             // Ensure the scanner resource is closed when the program exits or errors
             if (scanner != null) {
                 scanner.close();
                 System.out.println("Scanner closed."); // Optional confirmation
             }
        }
    }

    /**
     * Helper method to print the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("\n--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Process Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
    }

    /**
     * Main method to start the Task Management System application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of the system and run it
        TaskManagementSystem system = new TaskManagementSystem();
        system.runSystem();
    }
}
