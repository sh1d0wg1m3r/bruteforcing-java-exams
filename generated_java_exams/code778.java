/*
 * Exam Question #778
 * Generated on: 2025-05-12 16:39:28
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Agile Task Board Simulator
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a command-line application in Java that simulates a simplified Agile task board for a small development team. The system will manage development tasks, moving them through different stages: from a general backlog, to a queue of tasks ready for development, and finally marking them as completed.
 * 
 * Your solution must demonstrate a strong understanding of fundamental Java data structures, control flow, user interaction, and exception handling.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` to represent an individual development task. It should have the following private fields:
 *     *   `id` (int): A unique identifier for the task.
 *     *   `description` (String): A brief description of the task.
 *     *   `status` (String): The current status of the task (e.g., "TODO", "READY", "DONE").
 *     *   Include a constructor to initialize `id` and `description`, setting the initial status to "TODO".
 *     *   Provide public getter methods for all fields.
 *     *   Provide a public method `setStatus(String status)` to update the task's status.
 *     *   Override the `toString()` method to provide a user-friendly representation of the task (e.g., "ID: [id], Description: [description], Status: [status]").
 * 
 * 2.  **Task Board Management:** Create a class named `TaskBoardSimulator` which will contain the main logic of the application.
 *     *   It must manage the task backlog using a `java.util.ArrayList`. Declare the backlog using the `java.util.List` interface type: `private List<Task> backlog;`.
 *     *   It must manage tasks ready for development using a `java.util.Queue`. Declare the ready queue using the `java.util.Queue` interface type: `private Queue<Task> readyQueue;`.
 *     *   It should maintain a counter to generate unique integer IDs for new tasks, starting from 1.
 *     *   It must use a `java.util.Scanner` to read user input from `System.in`.
 * 
 * 3.  **User Interface and Flow:** The application should present a menu-driven interface to the user with the following options:
 *     *   **1. Add New Task to Backlog:** Prompt the user for a task description. Create a new `Task` object with a unique ID and "TODO" status, and add it to the `backlog`.
 *     *   **2. Move Task to Ready Queue:** Prompt the user for a task ID. Find the task with the given ID in the `backlog`. If found, remove it from the `backlog`, change its status to "READY", and add it to the `readyQueue`. If the task is not found in the backlog, display an error.
 *     *   **3. Process Next Task:** Take the next task from the front of the `readyQueue`. If the queue is not empty, change the task's status to "DONE" and print its details. The task should be removed from the queue. If the queue is empty, display an error.
 *     *   **4. List All Tasks:** Display all tasks currently present in the `backlog` and then all tasks in the `readyQueue`. Clearly label which list each task belongs to.
 *     *   **5. Exit:** Terminate the application.
 * 
 * 4.  **Control Flow:** Implement the menu selection logic using a `switch` statement. The main application loop should continue until the user chooses to exit.
 * 
 * 5.  **Input/Output:**
 *     *   Use `Scanner` to read all user input.
 *     *   Use `System.out.println` for displaying the menu, prompts, task details, and success messages.
 *     *   Use `System.err.println` for displaying all error messages (e.g., invalid menu choice, task not found, queue empty, invalid input format).
 * 
 * 6.  **Exception Handling:** Implement class-wide exception handling using `try-catch` blocks within the main application loop or controlling method (e.g., a `run()` method in `TaskBoardSimulator`). This should gracefully handle potential runtime errors such as `NumberFormatException` if the user enters non-integer input for menu choices or task IDs. Other unexpected errors should also be caught and reported using `System.err`.
 * 
 * 7.  **Best Practices:**
 *     *   Adhere to proper encapsulation principles.
 *     *   Use meaningful names for variables, methods, and classes.
 *     *   Include appropriate comments and documentation (e.g., Javadoc-style comments for classes and methods).
 *     *   Implement basic input validation where necessary (e.g., checking if input is a valid number, checking if a task exists before attempting to move it, checking if the queue is empty before processing).
 *     *   Structure your code clearly into logical units (classes and methods).
 * 
 * **Expected Output:**
 * 
 * Your program should run interactively from the command line, guiding the user through the available options and providing feedback. An example interaction flow is provided in the problem description above, demonstrating adding tasks, listing tasks, moving a task, processing a task, handling an empty queue, and handling a task not found error. The exact formatting of task listings is flexible but must clearly distinguish backlog and ready queue and show task details.
 * 
 * **Evaluation Criteria:**
 * 
 * Your solution will be evaluated on:
 * *   Correct implementation and usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, and `System.out`.
 * *   Effective use of `try-catch` for class-wide exception handling.
 * *   Adherence to the specified requirements for each menu option.
 * *   Correct handling of edge cases (e.g., empty queue, task not found, invalid input).
 * *   Quality of code structure, encapsulation, naming, and documentation.
 * *   Clarity and correctness of output.
 *
 * EXPLANATION:
 * This solution implements the `Agile Task Board Simulator` as required, demonstrating the use of various Java concepts and best practices.
 * 
 * 1.  **`Task` Class:** This class serves as a simple Plain Old Java Object (POJO) representing a task. It encapsulates the task's state (`id`, `description`, `status`) with private fields and provides public getters and a setter for the status, adhering to encapsulation principles. The `toString()` method provides a convenient way to print task details.
 * 
 * 2.  **`TaskBoardSimulator` Class:** This is the main class containing the application logic.
 *     *   **Data Structures:** It correctly uses a `List<Task>` (instantiated as `ArrayList`) for the `backlog`, which allows easy addition and removal of tasks by index or object. It uses a `Queue<Task>` (instantiated as `LinkedList`) for the `readyQueue`, which is appropriate for processing tasks in a First-In, First-Out (FIFO) manner using methods like `offer()` (to add) and `poll()` (to retrieve and remove the head).
 *     *   **State Management:** `nextTaskId` ensures unique IDs are generated for new tasks.
 *     *   **`Scanner`:** A `Scanner` object is initialized to read user input from the console. Using `scanner.nextLine()` and then parsing is generally safer than `nextInt()` or similar methods, as it consumes the whole line, preventing newline characters from interfering with subsequent reads.
 * 
 * 3.  **User Interface and Flow:**
 *     *   The `displayMenu()` method prints the available options.
 *     *   The `run()` method contains the main application loop (`while (choice != 5)`).
 *     *   Inside the loop, it displays the menu, reads user input, and uses a `switch` statement to direct execution to the appropriate method (`addTaskToBacklog`, `moveTaskToReadyQueue`, `processNextTask`, `listAllTasks`) based on the user's integer choice.
 *     *   A `default` case in the `switch` handles invalid integer inputs outside the 1-5 range, printing an error using `System.err`.
 * 
 * 4.  **Method Implementations:**
 *     *   `addTaskToBacklog()`: Prompts for description, creates a new `Task` with the next ID, adds it to the `backlog` list, and increments the ID counter. Includes basic validation for empty description.
 *     *   `moveTaskToReadyQueue()`: Prompts for an ID, iterates through the `backlog` to find the task. If found, it removes the task from the `backlog`, updates its status, and adds it to the `readyQueue` using `offer()`. It prints a success message or an error message using `System.err` if the task is not found. It includes a `try-catch` specifically to detect `NumberFormatException` during ID parsing, which is then allowed to propagate to the main `run()` loop's handler.
 *     *   `processNextTask()`: Uses `readyQueue.poll()` to get and remove the next task. `poll()` is used because it returns `null` if the queue is empty, allowing for graceful handling of the empty queue case with an error message on `System.err`. If a task is retrieved, its status is updated and details printed.
 *     *   `listAllTasks()`: Iterates through both the `backlog` (using an enhanced for loop) and the `readyQueue` (also using an enhanced for loop, which iterates without removing elements) and prints the details of each task using their `toString()` method. It checks if each list is empty and prints a corresponding message if so.
 * 
 * 5.  **Exception Handling:**
 *     *   The `run()` method features a prominent `try-catch` block that wraps the input reading (`Integer.parseInt(inputLine)`) and the entire `switch` statement. This design implements "class-wide" handling as required.
 *     *   `NumberFormatException` is specifically caught to handle cases where the user's input for the menu choice or task ID is not a valid integer. An error message is printed to `System.err`.
 *     *   A general `catch (Exception e)` is included as a fallback to catch any other unexpected runtime errors that might occur within the loop, printing a generic error message and the exception's message to `System.err`.
 * 
 * 6.  **Best Practices:** The code demonstrates meaningful variable and method names, uses private fields with public accessors, includes Javadoc-style comments for classes and methods, and implements basic input validation (checking for empty description, checking if task exists, checking if queue is empty). The structure separates concerns into the `Task` class and the `TaskBoardSimulator` class with well-defined methods. `System.out` is used for normal output and `System.err` for error reporting.
 * 
 * This solution effectively integrates the required Java components into a practical simulation, requiring students to manage data across different structures, handle user interaction, and implement robust error management.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Represents a single task in the task board.
 */
class Task {
    private int id;
    private String description;
    private String status; // e.g., "TODO", "READY", "DONE"

    /**
     * Constructs a new Task.
     * @param id The unique identifier for the task.
     * @param description A brief description of the task.
     */
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "TODO"; // Initial status
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the task.
     * @param status The new status (e.g., "READY", "DONE").
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Description: " + description + ", Status: " + status;
    }
}

/**
 * Simulates a simple Agile Task Board.
 * Manages tasks in a backlog (List) and a ready queue (Queue).
 * Handles user interaction and task lifecycle.
 */
public class TaskBoardSimulator {
    // Using List interface type for backlog, instantiated as ArrayList
    private List<Task> backlog;
    // Using Queue interface type for readyQueue, instantiated as LinkedList
    private Queue<Task> readyQueue;
    private int nextTaskId; // Counter for unique task IDs
    private Scanner scanner; // Scanner for user input

    /**
     * Constructs a new TaskBoardSimulator.
     * Initializes the backlog, ready queue, task ID counter, and scanner.
     */
    public TaskBoardSimulator() {
        this.backlog = new ArrayList<>();
        this.readyQueue = new LinkedList<>(); // LinkedList implements Queue
        this.nextTaskId = 1; // Start task IDs from 1
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("--- Task Board Menu ---");
        System.out.println("1. Add New Task to Backlog");
        System.out.println("2. Move Task to Ready Queue");
        System.out.println("3. Process Next Task");
        System.out.println("4. List All Tasks");
        System.out.println("5. Exit");
        System.out.println("-----------------------");
    }

    /**
     * Adds a new task to the backlog based on user input.
     * Prompts for description and creates a Task object.
     */
    private void addTaskToBacklog() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        if (description == null || description.trim().isEmpty()) {
             System.err.println("Task description cannot be empty.");
             return;
        }
        Task newTask = new Task(nextTaskId++, description);
        backlog.add(newTask);
        System.out.println("Task " + newTask.getId() + " added to backlog.");
    }

    /**
     * Finds a task in the backlog by its ID and moves it to the ready queue.
     * Prompts user for Task ID.
     */
    private void moveTaskToReadyQueue() {
        System.out.print("Enter Task ID to move to Ready Queue: ");
        try {
            int taskId = Integer.parseInt(scanner.nextLine());

            Task taskToMove = null;
            // Find the task in the backlog by ID
            // Use an iterator or index-based loop for safe removal
            int taskIndex = -1;
            for (int i = 0; i < backlog.size(); i++) {
                if (backlog.get(i).getId() == taskId) {
                    taskToMove = backlog.get(i);
                    taskIndex = i;
                    break;
                }
            }

            if (taskToMove != null) {
                backlog.remove(taskIndex); // Remove from backlog
                taskToMove.setStatus("READY"); // Update status
                readyQueue.offer(taskToMove); // Add to ready queue using offer (safe add)
                System.out.println("Task " + taskId + " moved to ready queue.");
            } else {
                // Task not found in the backlog
                System.err.println("Task with ID " + taskId + " not found in backlog.");
            }

        } catch (NumberFormatException e) {
            // This exception is caught by the class-wide handler in run()
            // Re-throwing it or letting it propagate fulfills the requirement.
            throw new NumberFormatException("Invalid input format for Task ID.");
        } catch (Exception e) {
             // Catch any other unexpected errors during the move process
             System.err.println("An unexpected error occurred while moving task: " + e.getMessage());
             // Let the class-wide handler in run() potentially catch this too,
             // or handle specific exceptions here if needed.
        }
    }

    /**
     * Processes the next task from the ready queue.
     * Takes the task at the front, updates status, and removes it.
     */
    private void processNextTask() {
        System.out.println("Processing task from Ready Queue...");
        Task taskToProcess = readyQueue.poll(); // poll() retrieves and removes the head, returns null if empty

        if (taskToProcess != null) {
            taskToProcess.setStatus("DONE"); // Update status
            System.out.println("Task Processed: " + taskToProcess);
            // The task is already removed from the queue by poll()
        } else {
            // Queue is empty, cannot process
            System.err.println("Ready Queue is empty. Cannot process task.");
        }
    }

    /**
     * Lists all tasks currently in the backlog and the ready queue.
     */
    private void listAllTasks() {
        System.out.println("--- Backlog Tasks ---");
        if (backlog.isEmpty()) {
            System.out.println("(Backlog is empty)");
        } else {
            // Iterate and print tasks in the backlog
            for (Task task : backlog) {
                System.out.println(task);
            }
        }

        System.out.println("--- Ready Queue Tasks ---");
        if (readyQueue.isEmpty()) {
            System.out.println("(Ready Queue is empty)");
        } else {
            // Iterate and print tasks in the ready queue
            // Iterating over a Queue does not remove elements
            for (Task task : readyQueue) {
                System.out.println(task);
            }
        }
    }

    /**
     * Runs the main application loop, handling user input and choices.
     * Includes class-wide exception handling using a try-catch block
     * around the core logic within the loop.
     */
    public void run() {
        int choice = -1; // Initialize choice to a non-menu value

        // Main loop continues until the user enters '5' to exit
        while (choice != 5) {
            displayMenu(); // Show menu options
            try {
                System.out.print("Enter your choice: ");
                // Read the entire line to handle potential non-integer input gracefully
                String inputLine = scanner.nextLine();
                // Attempt to parse the input string into an integer
                choice = Integer.parseInt(inputLine);

                // Use a switch statement to execute actions based on user choice
                switch (choice) {
                    case 1:
                        addTaskToBacklog(); // Call method to add a task
                        break;
                    case 2:
                        moveTaskToReadyQueue(); // Call method to move a task
                        break;
                    case 3:
                        processNextTask(); // Call method to process a task
                        break;
                    case 4:
                        listAllTasks(); // Call method to list tasks
                        break;
                    case 5:
                        System.out.println("Exiting simulator. Goodbye!"); // Exit message
                        break;
                    default:
                        // Handle cases where the integer input is not between 1 and 5
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                // Catch specific exception for invalid integer parsing
                System.err.println("Invalid input. Please enter a number for the menu choice or Task ID.");
                // choice remains the previous value or -1, loop continues
            } catch (Exception e) {
                // Catch any other unexpected runtime exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Optional: print stack trace for debugging purposes
            }
            System.out.println(); // Add a newline for better formatting between menu iterations
        }
        scanner.close(); // Close the scanner resource when the application exits
    }

    /**
     * Main method to start the Task Board Simulator application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskBoardSimulator simulator = new TaskBoardSimulator();
        simulator.run(); // Start the main simulation loop
    }
}
