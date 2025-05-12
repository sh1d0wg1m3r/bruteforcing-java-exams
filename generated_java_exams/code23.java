/*
 * Exam Question #23
 * Generated on: 2025-05-11 21:42:18
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Simple Task Management System
 * 
 * **Objective:** Develop a command-line application that simulates a basic task management system. The system should allow users to add new tasks, complete the oldest pending task, and view both pending and completed tasks.
 * 
 * Your solution must demonstrate proficiency in using core Java collections, I/O, control flow, and exception handling by incorporating *all* the specific Java components listed below.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a simple class named `Task` to represent a task. Each task should have:
 *     *   A unique integer ID, automatically assigned starting from 1.
 *     *   A `String` description of the task.
 *     *   Proper encapsulation (private fields, public getter methods).
 *     *   A `toString()` method for easy printing.
 *     *   Input validation in the constructor to ensure the description is not null or empty.
 * 
 * 2.  **Pending Tasks:** Use a `java.util.Queue` to store tasks that are waiting to be processed. The system should process tasks in the order they were added (First-In, First-Out - FIFO). Use `java.util.LinkedList` as the concrete implementation for the `Queue`.
 * 
 * 3.  **Completed Tasks:** Use a `java.util.List` to store tasks that have been completed. This list should maintain the order in which tasks were completed. Use `java.util.ArrayList` as the concrete implementation for the `List`.
 * 
 * 4.  **User Interface:** Implement a command-line interface using `java.util.Scanner` to read user input for menu choices and task descriptions.
 * 
 * 5.  **Menu System:** Present a clear menu of options to the user:
 *     *   1. Add New Task
 *     *   2. Complete Next Task
 *     *   3. View Pending Tasks
 *     *   4. View Completed Tasks
 *     *   0. Exit
 *     Use a `switch` statement to direct the program flow based on the user's menu selection.
 * 
 * 6.  **Output Streams:**
 *     *   Use `System.out` for displaying the menu, task information (when adding, completing, or viewing), and informational messages (like program exit).
 *     *   Use `System.err` to display error messages (e.g., invalid menu choice, attempting to complete a task when the queue is empty, invalid task description input).
 * 
 * 7.  **Exception Handling:** Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors. Specifically, catch `java.util.InputMismatchException` if the user enters non-integer input when a number is expected for the menu choice. Also handle potential exceptions related to input validation or queue operations (though using `poll()` can help avoid `NoSuchElementException`).
 * 
 * 8.  **Best Practices:**
 *     *   Employ meaningful variable and method names.
 *     *   Include appropriate comments to explain complex parts or logic.
 *     *   Ensure proper resource management (e.g., close the `Scanner`).
 *     *   Structure your code logically, potentially using separate methods for each menu option.
 * 
 * **Expected Interaction Flow (Example):**
 * 
 * ```
 * --- Task Management System ---
 * 1. Add New Task
 * 2. Complete Next Task
 * 3. View Pending Tasks
 * 4. View Completed Tasks
 * 0. Exit
 * ----------------------------
 * Enter your choice: 1
 * Enter task description: Buy groceries
 * Task added: Task [ID: 1] - Buy groceries
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: 1
 * Enter task description: Walk the dog
 * Task added: Task [ID: 2] - Walk the dog
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: 3
 * --- Pending Tasks ---
 * [Task [ID: 1] - Buy groceries, Task [ID: 2] - Walk the dog]
 * ---------------------
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: 2
 * Completed task: Task [ID: 1] - Buy groceries
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: 3
 * --- Pending Tasks ---
 * [Task [ID: 2] - Walk the dog]
 * ---------------------
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: 4
 * --- Completed Tasks ---
 * 1. Task [ID: 1] - Buy groceries
 * -----------------------
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: 2
 * Completed task: Task [ID: 2] - Walk the dog
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: 2
 * No pending tasks to complete. (Printed to System.err)
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: abc
 * Invalid input. Please enter a number. (Printed to System.err)
 * 
 * --- Task Management System ---
 * ... (menu again) ...
 * Enter your choice: 0
 * Exiting Task Management System.
 * ```
 * 
 * Provide the complete Java code for your solution, including the `Task` class and the main application logic class.
 * 
 * **Evaluation Criteria:** Correctness of implementation, adherence to all specified requirements (especially the use of required components), code structure and readability, proper error handling and input validation, and use of best practices.
 *
 * EXPLANATION:
 * This solution implements a simple Task Management System adhering to all the specified requirements.
 * 
 * 1.  **`Task` Class:** A private static inner class `Task` is defined to encapsulate task data (ID and description). It includes a static counter (`nextId`) to ensure unique IDs are assigned automatically. The constructor validates the input description, throwing an `IllegalArgumentException` if it's invalid. Getters provide access to the private fields, and `toString()` provides a convenient representation for printing. Encapsulation is maintained by making fields private.
 * 
 * 2.  **Collections (`Queue`, `List`, `ArrayList`, `LinkedList`):**
 *     *   A `Queue<Task>` named `pendingTasks` is declared and initialized with a `LinkedList` instance. `LinkedList` is a common implementation for `Queue` and naturally supports FIFO behavior. The `offer()` method is used to add tasks, and `poll()` is used to retrieve and remove the head of the queue (the oldest task).
 *     *   A `List<Task>` named `completedTasks` is declared and initialized with an `ArrayList` instance. `ArrayList` is a suitable implementation for `List` when you need to store elements in order and access them by index, as done when viewing completed tasks.
 * 
 * 3.  **`Scanner`:** A `Scanner` object is used to read input from `System.in`. It's initialized once in the constructor and closed when the application exits in the `run()` method.
 * 
 * 4.  **`switch` Statement:** The `run()` method contains the main application loop. Inside the loop, after reading the user's integer choice, a `switch` statement is used to execute the corresponding method (`addTask`, `completeNextTask`, `viewPendingTasks`, `viewCompletedTasks`) or exit the application.
 * 
 * 5.  **Output Streams (`System.out`, `System.err`):**
 *     *   `System.out.println()` and `System.out.print()` are used for standard output, including displaying the menu, confirming actions (task added, task completed), and showing the contents of the task lists/queue.
 *     *   `System.err.println()` is used specifically for error messages, such as indicating an invalid menu choice, reporting that there are no pending tasks to complete, or displaying errors from task description validation or input parsing.
 * 
 * 6.  **Exception Handling (`try-catch`):**
 *     *   The `run()` method uses a `try-catch` block around the code that reads the user's menu choice and executes the corresponding action.
 *     *   It specifically catches `InputMismatchException`, which occurs if the user enters non-integer text when `scanner.nextInt()` is called. The `catch` block prints an error message to `System.err` and consumes the invalid input line using `scanner.nextLine()` to prevent an infinite loop.
 *     *   A general `catch (Exception e)` is included as a fallback for any other unexpected runtime errors, printing a generic error message to `System.err`.
 *     *   The `addTask()` method includes a `try-catch` block to handle the `IllegalArgumentException` that the `Task` constructor might throw if the description is invalid.
 * 
 * 7.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Task` and `TaskManager` are private, accessed via public methods where necessary.
 *     *   **Meaningful Names:** Variables (`pendingTasks`, `completedTasks`, `description`, `choice`), methods (`addTask`, `completeNextTask`, `displayMenu`, `run`), and the class names are descriptive.
 *     *   **Comments:** Javadoc comments explain the purpose of classes and methods, and inline comments clarify specific logic (like consuming the newline after `nextInt`).
 *     *   **Input Validation:** The `Task` constructor validates the description. The `run` method handles `InputMismatchException` for menu input. `poll()` is used on the queue to safely handle the empty case without throwing an exception.
 *     *   **Error Handling:** Errors are reported via `System.err`, and exceptions are caught and handled gracefully.
 *     *   **Code Structure:** The code is organized into a `Task` class (as an inner static class for self-containment) and a `TaskManager` class containing the main application logic and the `main` method. Private helper methods are used for specific actions (adding, completing, viewing tasks, displaying menu).
 * 
 * This solution effectively demonstrates the use of the required Java components in a cohesive and practical application, incorporating fundamental software engineering principles like modularity, encapsulation, and robust error handling.
 */

import java.util.Queue;
import java.util.LinkedList; // Concrete implementation for Queue
import java.util.List;
import java.util.ArrayList; // Concrete implementation for List
import java.util.Scanner;
import java.util.InputMismatchException; // Specific exception for input

public class TaskManager {

    // Inner static class to represent a Task
    private static class Task {
        private static int nextId = 1; // Static counter for unique IDs
        private int id;
        private String description;

        /**
         * Constructs a new Task with a description and auto-generated ID.
         * @param description The description of the task.
         * @throws IllegalArgumentException if the description is null or empty.
         */
        public Task(String description) {
            if (description == null || description.trim().isEmpty()) {
                throw new IllegalArgumentException("Task description cannot be empty.");
            }
            this.id = nextId++;
            this.description = description.trim();
        }

        // Getter for task ID
        public int getId() {
            return id;
        }

        // Getter for task description
        public String getDescription() {
            return description;
        }

        /**
         * Returns a string representation of the Task.
         * @return Formatted string for the task.
         */
        @Override
        public String toString() {
            return "Task [ID: " + id + "] - " + description;
        }
    }

    // Queue to hold tasks that are pending completion (FIFO)
    private Queue<Task> pendingTasks;
    // List to hold tasks that have been completed (ordered by completion time)
    private List<Task> completedTasks;
    // Scanner for reading user input
    private Scanner scanner;

    /**
     * Constructs a new TaskManager, initializing collections and scanner.
     */
    public TaskManager() {
        pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        completedTasks = new ArrayList<>(); // ArrayList implements List
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Task Management System ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Complete Next Task");
        System.out.println("3. View Pending Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("0. Exit");
        System.out.println("----------------------------");
    }

    /**
     * Prompts the user for a task description and adds a new task to the pending queue.
     */
    private void addTask() {
        System.out.print("Enter task description: ");
        // Read the whole line for the description
        String description = scanner.nextLine();
        try {
            Task newTask = new Task(description);
            // offer() is the preferred way to add to a Queue, returns boolean
            if (pendingTasks.offer(newTask)) {
                 System.out.println("Task added: " + newTask);
            } else {
                 // This case is unlikely with LinkedList unless memory is exhausted
                 System.err.println("Failed to add task due to internal error.");
            }
        } catch (IllegalArgumentException e) {
            // Catch the exception thrown by the Task constructor for invalid description
            System.err.println("Error adding task: " + e.getMessage());
        }
    }

    /**
     * Completes the next task in the pending queue (FIFO).
     * Removes the task from pending and adds it to completed.
     */
    private void completeNextTask() {
        // poll() retrieves and removes the head of the queue, returns null if empty
        Task completedTask = pendingTasks.poll();
        if (completedTask != null) {
            completedTasks.add(completedTask);
            System.out.println("Completed task: " + completedTask);
        } else {
            // Print error if the queue was empty
            System.err.println("No pending tasks to complete.");
        }
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    private void viewPendingTasks() {
        System.out.println("\n--- Pending Tasks ---");
        if (pendingTasks.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            // Queue's toString() method provides a simple way to view contents
            System.out.println(pendingTasks);

            // Alternative: Iterate through the queue without removing elements
            /*
            int i = 1;
            for (Task task : pendingTasks) {
                System.out.println(i++ + ". " + task);
            }
            */
        }
        System.out.println("---------------------");
    }

    /**
     * Displays all tasks that have been completed.
     */
    private void viewCompletedTasks() {
        System.out.println("\n--- Completed Tasks ---");
        if (completedTasks.isEmpty()) {
            System.out.println("No completed tasks.");
        } else {
            // Iterate through the list and print each completed task
            for (int i = 0; i < completedTasks.size(); i++) {
                System.out.println((i + 1) + ". " + completedTasks.get(i));
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * The main application loop that displays the menu and processes user input.
     * Includes exception handling for input errors.
     */
    public void run() {
        int choice = -1; // Initialize choice to a non-exit value
        while (choice != 0) {
            displayMenu();
            try {
                System.out.print("Enter your choice: ");
                // Read the integer choice
                choice = scanner.nextInt();
                // Consume the leftover newline character after reading the integer
                scanner.nextLine();

                // Use a switch statement to handle menu options
                switch (choice) {
                    case 1:
                        addTask();
                        break;
                    case 2:
                        completeNextTask();
                        break;
                    case 3:
                        viewPendingTasks();
                        break;
                    case 4:
                        viewCompletedTasks();
                        break;
                    case 0:
                        System.out.println("Exiting Task Management System.");
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Invalid choice. Please enter a number from 0 to 4.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input specifically
                System.err.println("Invalid input. Please enter a number.");
                // Consume the invalid input line to prevent an infinite loop
                scanner.nextLine();
                choice = -1; // Reset choice to ensure the loop continues if 0 was entered before the error
            } catch (Exception e) {
                 // Catch any other unexpected runtime exceptions during processing
                 System.err.println("An unexpected error occurred: " + e.getMessage());
                 // For debugging purposes in an exam, a stack trace might be added:
                 // e.printStackTrace();
                 choice = -1; // Attempt to reset choice and continue the loop
            }
            // Add a blank line for better readability between menu interactions
            System.out.println();
        }
        // Close the scanner resource when the application exits
        scanner.close();
    }

    /**
     * The entry point of the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        TaskManager app = new TaskManager();
        app.run();
    }
}
