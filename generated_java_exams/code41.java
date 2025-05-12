/*
 * Exam Question #41
 * Generated on: 2025-05-11 21:59:15
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Task Scheduler Simulation
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified command-line Task Scheduler application. This application should allow users to add new tasks to a queue for processing, process the next task in the queue, list pending tasks, and view a history of completed tasks.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this Task Scheduler. Your solution must adhere to the following:
 * 
 * 1.  **Task Representation:** Create a `Task` class with the following private fields:
 *     *   `taskId` (an integer, automatically generated and unique)
 *     *   `description` (a String)
 *     *   `priority` (an integer, lower number indicates higher priority - e.g., 1 is highest)
 *     *   `status` (use an enum `Status` with values `PENDING` and `COMPLETED`)
 *     *   Provide a constructor and public getter methods for all fields.
 * 
 * 2.  **Task Scheduler Logic:** Create a `TaskScheduler` class that manages the tasks. It must contain:
 *     *   A `java.util.Queue<Task>` to hold tasks that are waiting to be processed (`pendingTasks`).
 *     *   A `java.util.List<Task>` implemented using `java.util.ArrayList<Task>` to store tasks that have been completed (`completedTasks`).
 *     *   A private counter for generating unique task IDs.
 *     *   Public methods for the following operations:
 *         *   `addTask(String description, int priority)`: Creates a new `Task` with status `PENDING`, assigns a unique ID, and adds it to the `pendingTasks` queue. Include validation for priority (e.g., must be positive).
 *         *   `processNextTask()`: Removes the task from the front of the `pendingTasks` queue, changes its status to `COMPLETED`, and adds it to the `completedTasks` list. Handle the case where the queue is empty.
 *         *   `listPendingTasks()`: Prints details of all tasks currently in the `pendingTasks` queue.
 *         *   `listCompletedTasks()`: Prints details of all tasks in the `completedTasks` list.
 *         *   `run()`: This method should contain the main application loop, interacting with the user via the console.
 * 
 * 3.  **User Interface (in `run()` method):**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user:
 *         *   `A`: Add New Task
 *         *   `P`: Process Next Task
 *         *   `L`: List Pending Tasks
 *         *   `C`: List Completed Tasks
 *         *   `E`: Exit
 *     *   Use a `switch` statement to handle the user's choice.
 *     *   Prompt the user for necessary information (description, priority) when adding a task.
 * 
 * 4.  **Error Handling and Output:**
 *     *   Use `System.out` for displaying the menu, task details, and success messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid menu choice, invalid priority input, trying to process from an empty queue).
 *     *   Implement class-wide exception handling using `try-catch` blocks within the `run()` method to gracefully handle potential issues during user interaction or task processing.
 * 
 * 5.  **Best Practices:**
 *     *   Apply proper encapsulation (`private` fields, `public` methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (JavaDocs are a plus but not strictly required for every single method in an exam setting, focus on clarity).
 *     *   Perform input validation where necessary (e.g., priority value, menu choice).
 *     *   Ensure the `Scanner` resource is properly closed.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively. Examples of expected output for different operations:
 * 
 * *   **Menu Display:**
 *     ```
 *     Task Scheduler Menu:
 *     A - Add New Task
 *     P - Process Next Task
 *     L - List Pending Tasks
 *     C - List Completed Tasks
 *     E - Exit
 *     Enter your choice:
 *     ```
 * *   **Adding Task (Successful):**
 *     ```
 *     Enter task description: Buy groceries
 *     Enter task priority (e.g., 1 for high): 2
 *     Task added successfully! ID: 1, Description: Buy groceries, Priority: 2
 *     ```
 * *   **Adding Task (Invalid Priority):**
 *     ```
 *     Enter task description: Call bank
 *     Enter task priority (e.g., 1 for high): zero
 *     Error: Invalid priority. Please enter a positive integer.
 *     ```
 * *   **Processing Task (Successful):**
 *     ```
 *     Processing task: ID: 1, Description: Buy groceries, Priority: 2
 *     Task ID 1 marked as COMPLETED.
 *     ```
 * *   **Processing Task (Empty Queue):**
 *     ```
 *     Error: No tasks in the pending queue to process.
 *     ```
 * *   **Listing Pending Tasks:**
 *     ```
 *     --- Pending Tasks ---
 *     ID: 2, Description: Call bank, Priority: 1
 *     ---------------------
 *     ```
 * *   **Listing Completed Tasks:**
 *     ```
 *     --- Completed Tasks ---
 *     ID: 1, Description: Buy groceries, Priority: 2, Status: COMPLETED
 *     -----------------------
 *     ```
 * 
 * Your solution should be a single Java file containing all necessary classes and the main method to start the application.
 *
 * EXPLANATION:
 * This solution implements the `Task Scheduler` as requested, demonstrating the use of all required Java components and best practices.
 * 
 * 1.  **Task Class:**
 *     *   Represents a single task with `taskId`, `description`, `priority`, and `status`.
 *     *   `taskId` is generated automatically by the `TaskScheduler`.
 *     *   An `enum Status` is used for clarity and type safety for the task's state.
 *     *   Encapsulation is maintained with `private` fields and `public` getters. A setter is provided for `status` as it changes during processing.
 *     *   The constructor includes basic validation for `priority`.
 *     *   `toString()` provides a convenient way to print task details.
 * 
 * 2.  **TaskScheduler Class:**
 *     *   Manages the collection of tasks.
 *     *   `pendingTasks`: A `Queue<Task>` is used (`LinkedList` is a common implementation) because tasks are processed in a FIFO (First-In, First-Out) manner, which aligns perfectly with a queue's behavior (add to end, remove from front).
 *     *   `completedTasks`: A `List<Task>` is used (`ArrayList` is the concrete implementation) to store completed tasks. A `List` allows easy storage and iteration over the history without needing queue-like removal behavior.
 *     *   `taskIdCounter`: A simple integer counter ensures unique IDs for each task.
 *     *   `addTask()`: Creates a `Task` object and adds it to the `pendingTasks` queue using `queue.add()`. It includes a `try-catch` block to handle potential `IllegalArgumentException` from the `Task` constructor if the priority is invalid.
 *     *   `processNextTask()`: Checks if the queue is empty. If not, it uses `queue.poll()` to get and remove the next task, updates its status, and adds it to the `completedTasks` list. `poll()` is used as it returns `null` for an empty queue, allowing a clean check, although the `isEmpty()` check precedes it.
 *     *   `listPendingTasks()` and `listCompletedTasks()`: Iterate through their respective collections (`Queue` and `List`) using enhanced for loops and print task details using the `Task` class's `toString()` method.
 * 
 * 3.  **User Interface (`run()` method):**
 *     *   `Scanner`: Used to read input from `System.in`. A `try-with-resources` block ensures the `Scanner` is automatically closed, preventing resource leaks.
 *     *   Menu: A simple text menu is displayed using `System.out`.
 *     *   `while` loop: Keeps the application running until the user chooses to exit (`E`).
 *     *   `switch` statement: Processes the user's command, calling the appropriate `TaskScheduler` method.
 *     *   Input Validation: Specifically, when adding a task, `scanner.hasNextInt()` and `scanner.nextInt()` are used to validate that the priority entered is an integer. If not, an error is printed to `System.err`, and the invalid input is consumed using `scanner.nextLine()` to prevent an infinite loop.
 * 
 * 4.  **Error Handling and Output:**
 *     *   `System.out`: Used for all standard messages (menu, success messages, task lists).
 *     *   `System.err`: Used exclusively for error messages (invalid choice, empty queue, invalid priority, unexpected exceptions).
 *     *   Class-wide `try-catch`: The main command processing loop within the `run()` method is wrapped in a `try-catch(Exception e)` block. This demonstrates a class-wide approach to catch any unexpected runtime exceptions that might occur during the execution of a command, preventing the program from crashing and providing a basic error message. Specific input validation errors (like invalid priority format) are handled more locally within the `switch` case for better context. An outer `try-catch` handles potential issues with `Scanner` initialization itself.
 * 
 * 5.  **Best Practices:**
 *     *   **Encapsulation:** Private fields and public methods are used consistently.
 *     *   **Naming:** Variable names like `pendingTasks`, `completedTasks`, `taskIdCounter`, `description`, `priority` are descriptive. Method names like `addTask`, `processNextTask`, `listPendingTasks` are clear.
 *     *   **Comments:** Basic comments explain the purpose of classes, methods, and key logic sections.
 *     *   **Input Validation:** Priority input is checked for being a positive integer. Invalid menu choices are handled.
 *     *   **Error Handling:** Specific error messages are provided for common issues (empty queue, invalid input). A general catch-all handles unexpected exceptions.
 *     *   **Clean Code Structure:** The code is divided into logical classes (`Status`, `Task`, `TaskScheduler`). The `run()` method orchestrates the user interaction, keeping the core scheduler logic separate in dedicated methods.
 * 
 * This solution effectively integrates the required Java components into a practical, interactive program while demonstrating robust error handling and adherence to good programming practices.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

// Enum for Task Status
enum Status {
    PENDING,
    COMPLETED
}

// Task Class
class Task {
    private int taskId;
    private String description;
    private int priority;
    private Status status;

    public Task(int taskId, String description, int priority) {
        if (priority <= 0) {
            throw new IllegalArgumentException("Priority must be a positive integer.");
        }
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.status = Status.PENDING; // New tasks are always pending
    }

    // Getters
    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    // Setter for status (used by scheduler when processing)
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + taskId + ", Description: " + description + ", Priority: " + priority + (status == Status.COMPLETED ? ", Status: " + status : "");
    }
}

// Task Scheduler Class
class TaskScheduler {
    private Queue<Task> pendingTasks;
    private List<Task> completedTasks;
    private int taskIdCounter;

    public TaskScheduler() {
        // Using LinkedList as it implements the Queue interface
        this.pendingTasks = new LinkedList<>();
        // Using ArrayList as a concrete implementation of the List interface
        this.completedTasks = new ArrayList<>();
        this.taskIdCounter = 0;
    }

    // Method to add a new task
    public void addTask(String description, int priority) {
        try {
            taskIdCounter++;
            Task newTask = new Task(taskIdCounter, description, priority);
            pendingTasks.add(newTask); // Add task to the queue
            System.out.println("Task added successfully! " + newTask);
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding task: " + e.getMessage());
            // Decrement counter if task creation failed due to invalid priority
            taskIdCounter--;
        }
    }

    // Method to process the next task in the queue
    public void processNextTask() {
        if (pendingTasks.isEmpty()) {
            System.err.println("Error: No tasks in the pending queue to process.");
            return;
        }

        // Use poll() to retrieve and remove the head of the queue, returns null if empty
        // Although we checked isEmpty(), poll() is generally safer than remove()
        Task taskToProcess = pendingTasks.poll();

        if (taskToProcess != null) {
            System.out.println("Processing task: " + taskToProcess);
            taskToProcess.setStatus(Status.COMPLETED); // Change status
            completedTasks.add(taskToProcess); // Add to completed list
            System.out.println("Task ID " + taskToProcess.getTaskId() + " marked as COMPLETED.");
        }
        // If poll returned null, it implies a race condition or logic error after isEmpty() check,
        // but with a single thread and the check, it should not happen.
    }

    // Method to list pending tasks
    public void listPendingTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }
        System.out.println("--- Pending Tasks ---");
        // Iterate through the queue without removing elements
        for (Task task : pendingTasks) {
            System.out.println(task);
        }
        System.out.println("---------------------");
    }

    // Method to list completed tasks
    public void listCompletedTasks() {
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
            return;
        }
        System.out.println("--- Completed Tasks ---");
        // Iterate through the list
        for (Task task : completedTasks) {
            System.out.println(task);
        }
        System.out.println("-----------------------");
    }

    // Main application loop
    public void run() {
        // Use try-with-resources for Scanner to ensure it's closed
        try (Scanner scanner = new Scanner(System.in)) {
            String choice = "";
            while (!choice.equalsIgnoreCase("E")) {
                displayMenu();
                System.out.print("Enter your choice: ");

                // Class-wide exception handling for the main loop operations
                try {
                    choice = scanner.nextLine().trim();

                    // Use switch statement for flow control based on user input
                    switch (choice.toUpperCase()) {
                        case "A": // Add Task
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine();
                            int priority = -1;
                            System.out.print("Enter task priority (e.g., 1 for high): ");
                            // Validate priority input
                            if (scanner.hasNextInt()) {
                                priority = scanner.nextInt();
                                // Consume the rest of the line after reading int
                                scanner.nextLine();
                                addTask(description, priority);
                            } else {
                                System.err.println("Error: Invalid priority. Please enter a positive integer.");
                                // Consume the invalid input to prevent infinite loop
                                scanner.nextLine();
                            }
                            break;

                        case "P": // Process Task
                            processNextTask();
                            break;

                        case "L": // List Pending Tasks
                            listPendingTasks();
                            break;

                        case "C": // List Completed Tasks
                            listCompletedTasks();
                            break;

                        case "E": // Exit
                            System.out.println("Exiting Task Scheduler. Goodbye!");
                            break;

                        default: // Invalid Choice
                            System.err.println("Error: Invalid choice. Please try again.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    // This catch is less likely with nextLine() followed by hasNextInt()/nextInt(),
                    // but good practice to show handling input mismatches if reading types directly.
                    System.err.println("Input error. Please check your input format.");
                    scanner.nextLine(); // Consume the invalid input
                } catch (Exception e) {
                    // Catch any other unexpected exceptions during command processing
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    // e.printStackTrace(); // Uncomment for debugging detailed stack trace
                }
                System.out.println(); // Add a newline for better readability between commands
            }
        } catch (Exception e) {
             // Catch any exceptions related to Scanner initialization or try-with-resources
             System.err.println("An error occurred during application startup or shutdown: " + e.getMessage());
        }
    }

    // Helper method to display the menu
    private void displayMenu() {
        System.out.println("Task Scheduler Menu:");
        System.out.println("A - Add New Task");
        System.out.println("P - Process Next Task");
        System.out.println("L - List Pending Tasks");
        System.out.println("C - List Completed Tasks");
        System.out.println("E - Exit");
    }

    // Main method to start the application
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.run(); // Start the main application loop
    }
}
