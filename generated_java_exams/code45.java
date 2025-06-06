/*
 * Exam Question #45
 * Generated on: 2025-05-11 22:04:30
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam: Event Task Management System
 * 
 * **Scenario:** You are tasked with developing a simplified task management system for a small event. The system needs to handle tasks that are newly created (pending) and tasks that are actively being managed (in progress or completed).
 * 
 * **Problem Description:**
 * 
 * Implement a Java console application that allows users to manage event tasks. The system should support the following operations via a menu:
 * 
 * 1.  **Add New Task:** Allows the user to add a new task description. New tasks are initially placed in a *pending* state.
 * 2.  **View Pending Tasks:** Displays all tasks currently in the pending state.
 * 3.  **Process Next Pending Task:** Takes the oldest task from the pending state, moves it to the main list of tasks, and prompts the user to set its initial active status (e.g., "In Progress").
 * 4.  **View All Tasks:** Displays all tasks that have been moved from the pending state to the main list, along with their current status.
 * 5.  **Update Task Status:** Allows the user to select a task by its ID from the main list and update its status (e.g., "Done", "Blocked").
 * 6.  **Exit:** Terminates the application.
 * 
 * **Technical Requirements:**
 * 
 * Your solution must adhere to the following technical constraints and demonstrate advanced Java programming concepts:
 * 
 * 1.  **Data Structures:**
 *     *   Use `java.util.Queue` to manage tasks in the pending state (FIFO order).
 *     *   Use `java.util.ArrayList` to store all tasks that have been moved out of the pending state.
 *     *   Refer to the `ArrayList` using the `java.util.List` interface type where appropriate (e.g., method parameters, return types, field declarations).
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console (menu choices, task descriptions, task IDs, status updates).
 * 3.  **Control Flow:**
 *     *   Use a `switch` statement to handle the main menu options.
 * 4.  **Output:**
 *     *   Use `System.out.println()` for displaying the menu, task lists, and success messages.
 *     *   Use `System.err.println()` for displaying error messages (e.g., invalid input, task not found, no pending tasks).
 * 5.  **Error Handling:**
 *     *   Implement robust error handling using `try-catch` blocks. This should include handling potential issues like:
 *         *   `InputMismatchException` or `NumberFormatException` when reading numbers.
 *         *   Attempting to process a pending task when the queue is empty.
 *         *   Attempting to update a task that does not exist (invalid ID).
 *     *   Implement class-wide exception handling for unexpected errors within the main program loop.
 * 6.  **Class Design:**
 *     *   Create a `Task` class to represent a single task. It should have fields for a unique ID, description, and status.
 *     *   Use appropriate encapsulation (`private` fields, `public` methods like getters/setters or a constructor).
 *     *   Consider using an `enum` for task status for type safety.
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include comments or JavaDocs to explain complex parts of the code.
 *     *   Perform input validation where necessary (e.g., checking if a task ID is valid).
 *     *   Ensure resources like `Scanner` are properly closed.
 * 
 * **Expected Output:**
 * 
 * The program should present a clear menu, prompt the user for input based on their selection, display task information formatted clearly, and output error messages to the standard error stream.
 * 
 * **Example Interaction Flow (Illustrative):**
 * 
 * ```
 * --- Event Task Management ---
 * 1. Add New Task
 * 2. View Pending Tasks
 * 3. Process Next Pending Task
 * 4. View All Tasks
 * 5. Update Task Status
 * 6. Exit
 * Enter your choice: 1
 * Enter task description: Book venue
 * Task added successfully. ID: 1
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 1
 * Enter task description: Send invitations
 * Task added successfully. ID: 2
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 2
 * Pending Tasks:
 * ID: 1, Description: Book venue, Status: PENDING
 * ID: 2, Description: Send invitations, Status: PENDING
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 3
 * Processing task: ID: 1, Description: Book venue
 * Enter initial status (e.g., In Progress, Assigned): In Progress
 * Task 1 moved to main list and status updated to In Progress.
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 4
 * All Tasks:
 * ID: 1, Description: Book venue, Status: IN_PROGRESS
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 5
 * Enter task ID to update: 1
 * Enter new status (e.g., Done, Blocked): Done
 * Task 1 status updated to DONE.
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 4
 * All Tasks:
 * ID: 1, Description: Book venue, Status: DONE
 * ID: 2, Description: Send invitations, Status: PENDING (Note: This would appear under "View Pending Tasks" in the actual output, but shown here for context that it's still in the system)
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 5
 * Enter task ID to update: 99
 * Error: Task with ID 99 not found.
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 3
 * Processing task: ID: 2, Description: Send invitations
 * Enter initial status (e.g., In Progress, Assigned): Assigned
 * Task 2 moved to main list and status updated to ASSIGNED.
 * 
 * --- Event Task Management ---
 * ...
 * Enter your choice: 6
 * Exiting system.
 * ```
 * 
 * **Constraints:**
 * *   The solution must be a single `.java` file or multiple files compiled together, demonstrating a cohesive application.
 * *   Focus on the core logic and required components; a fully persistent storage solution is not necessary (data can be lost on exit).
 * *   The time limit for this task is 45-60 minutes.
 * 
 * Implement the Java code for this system.
 *
 * EXPLANATION:
 * This solution implements the Event Task Management System as required, demonstrating the use of all specified Java components and following best practices.
 * 
 * 1.  **Task Class and TaskStatus Enum:**
 *     *   The `TaskStatus` enum provides a type-safe way to represent the possible states of a task (`PENDING`, `IN_PROGRESS`, `ASSIGNED`, `DONE`, `BLOCKED`).
 *     *   The `Task` class encapsulates the data for a single task: a unique `id`, `description`, and `status`. It uses `private` fields and `public` getter methods. A `setStatus` method allows controlled updates to the status. The `toString()` method provides a convenient way to display task information.
 * 
 * 2.  **Data Structures (`Queue`, `List`, `ArrayList`):**
 *     *   `private Queue<Task> pendingTasks = new LinkedList<>();`: A `LinkedList` is used because it implements the `Queue` interface and provides efficient FIFO operations (`offer` to add, `poll` to remove from the head). This queue holds tasks that have just been added but not yet moved to the active management list.
 *     *   `private List<Task> allTasks = new ArrayList<>();`: An `ArrayList` is used to store tasks that have been processed from the pending queue and are now actively managed. It is declared using the `List` interface type, which is a good practice for flexibility. This list allows for easy iteration and access to tasks by index or via searching.
 * 
 * 3.  **User Input (`Scanner`):**
 *     *   `private Scanner scanner = new Scanner(System.in);`: A `Scanner` object is created to read input from the standard input stream (`System.in`). It's a class field to be used across different methods.
 *     *   `scanner.nextLine()` is used after `scanner.nextInt()` to consume the leftover newline character, preventing issues in subsequent `nextLine()` calls.
 *     *   The `finally` block in `run()` ensures `scanner.close()` is called when the application exits, releasing system resources.
 * 
 * 4.  **Control Flow (`switch`):**
 *     *   The `run()` method contains the main application loop. Inside the loop, a `switch` statement is used to direct execution based on the user's integer choice from the menu.
 * 
 * 5.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` is used for displaying the menu, task details, and confirmation messages, which are considered normal application output.
 *     *   `System.err.println()` is specifically used for displaying error messages, such as invalid menu choices, invalid task IDs, or attempts to perform actions on empty queues/lists. This separates error information from standard output.
 * 
 * 6.  **Error Handling (`try-catch`):**
 *     *   **Class-wide `try-catch`:** The main `while` loop in `run()` is wrapped in a `try-catch(Exception e)` block. This catches any unhandled exceptions that might occur during the execution of the chosen menu option, preventing the program from crashing and printing an error message to `System.err`.
 *     *   **Specific `try-catch`:**
 *         *   `InputMismatchException` is caught when reading the menu choice and the task ID to handle cases where the user enters non-integer input.
 *         *   `IllegalArgumentException` is caught in `getTaskStatusFromInput` when the user enters a status string that doesn't match any `TaskStatus` enum value.
 *     *   **Logical Error Handling:** `if` statements are used to check for conditions like empty queues (`pendingTasks.isEmpty()`) or lists (`allTasks.isEmpty()`) before attempting operations like `poll()` or updating tasks. Attempts to perform actions under these conditions result in informative error messages printed to `System.err`. The `findTaskById` helper method returns `null` if a task isn't found, which is then checked in `updateTaskStatus` to report an error. Input validation is also performed for task descriptions and status strings.
 * 
 * 7.  **Core Logic Implementation:**
 *     *   **Add Task:** Creates a `Task` object with a unique ID (generated by incrementing `taskIdCounter`) and adds it to the `pendingTasks` queue using `offer()`.
 *     *   **View Pending:** Iterates through the `pendingTasks` queue using an enhanced `for` loop (which does *not* remove elements) and prints each task.
 *     *   **Process Pending:** Uses `pendingTasks.poll()` to retrieve and remove the oldest task from the queue. It then adds this task to the `allTasks` list and prompts the user for its initial active status using the `getTaskStatusFromInput` helper method for validation.
 *     *   **View All:** Iterates through the `allTasks` list and prints each task.
 *     *   **Update Status:** Prompts for a task ID, uses the `findTaskById` helper to locate the task in `allTasks`, and if found, prompts for a new status using the validated input helper `getTaskStatusFromInput` before updating the task's status.
 * 
 * 8.  **Helper Methods:**
 *     *   `printMenu()`: Encapsulates the logic for displaying the menu.
 *     *   `findTaskById(int id)`: Searches the `allTasks` list for a task with the given ID.
 *     *   `getTaskStatusFromInput(String promptMessage)`: Handles the loop for prompting and validating user input for task status against the `TaskStatus` enum.
 *     *   `getValidStatusesString()`: Generates a helpful string listing valid status options for the user.
 * 
 * This solution effectively integrates the required components into a functional, well-structured, and robust console application for managing event tasks, suitable for an advanced Java programming exam.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Enum for Task Status
enum TaskStatus {
    PENDING,
    IN_PROGRESS,
    ASSIGNED,
    DONE,
    BLOCKED
}

// Task Class
class Task {
    private int id;
    private String description;
    private TaskStatus status;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = TaskStatus.PENDING; // New tasks are pending
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // Setter for status (used after processing from pending)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Description: %s, Status: %s", id, description, status);
    }
}

// Main Event Task Management System Class
public class EventTaskSystem {

    // Use List interface for the main task list
    private List<Task> allTasks;
    // Use Queue for pending tasks
    private Queue<Task> pendingTasks;
    private Scanner scanner;
    private int taskIdCounter; // Counter for generating unique task IDs

    public EventTaskSystem() {
        // Initialize data structures
        allTasks = new ArrayList<>();
        pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        scanner = new Scanner(System.in);
        taskIdCounter = 0; // Start IDs from 0 or 1
    }

    // --- Core System Operations ---

    /**
     * Runs the main application loop, displaying the menu and processing user input.
     */
    public void run() {
        int choice = -1;
        System.out.println("--- Event Task Management ---");

        // Class-wide exception handling for the main loop
        try {
            while (choice != 6) {
                printMenu();
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    // Use switch statement for menu navigation
                    switch (choice) {
                        case 1:
                            addTask();
                            break;
                        case 2:
                            viewPendingTasks();
                            break;
                        case 3:
                            processNextPendingTask();
                            break;
                        case 4:
                            viewAllTasks();
                            break;
                        case 5:
                            updateTaskStatus();
                            break;
                        case 6:
                            System.out.println("Exiting system.");
                            break;
                        default:
                            // Use System.err for invalid menu choices
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 6.");
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input for menu choice
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to prevent exiting
                } catch (Exception e) {
                    // Catch any other unexpected errors during operation
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    e.printStackTrace(System.err); // Print stack trace to stderr for debugging
                }
                System.out.println(); // Add a blank line for readability
            }
        } finally {
            // Ensure scanner is closed when the application exits
            scanner.close();
        }
    }

    /**
     * Adds a new task to the pending queue.
     */
    private void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        if (description == null || description.trim().isEmpty()) {
             System.err.println("Error: Task description cannot be empty.");
             return;
        }

        taskIdCounter++; // Generate next unique ID
        Task newTask = new Task(taskIdCounter, description.trim());
        pendingTasks.offer(newTask); // Add to the end of the queue

        System.out.println("Task added successfully. ID: " + newTask.getId());
    }

    /**
     * Displays all tasks currently in the pending queue.
     */
    private void viewPendingTasks() {
        if (pendingTasks.isEmpty()) {
            System.out.println("No tasks currently pending.");
        } else {
            System.out.println("Pending Tasks:");
            // Iterate through the queue without removing elements
            for (Task task : pendingTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Processes the next task from the pending queue, moves it to the main list,
     * and prompts for an initial active status.
     */
    private void processNextPendingTask() {
        if (pendingTasks.isEmpty()) {
            // Use System.err for error condition
            System.err.println("Error: No tasks in the pending queue to process.");
            return;
        }

        // Retrieve and remove the head of the queue (FIFO)
        Task taskToProcess = pendingTasks.poll();
        System.out.println("Processing task: " + taskToProcess);

        TaskStatus initialStatus = getTaskStatusFromInput("Enter initial status (e.g., " + getValidStatusesString() + "): ");

        // Update status and add to the main list
        taskToProcess.setStatus(initialStatus);
        allTasks.add(taskToProcess); // Add to the main list

        System.out.println("Task " + taskToProcess.getId() + " moved to main list and status updated to " + initialStatus + ".");
    }

    /**
     * Displays all tasks in the main task list.
     */
    private void viewAllTasks() {
        if (allTasks.isEmpty()) {
            System.out.println("No tasks in the main list.");
        } else {
            System.out.println("All Tasks:");
            for (Task task : allTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Updates the status of a task in the main task list by ID.
     */
    private void updateTaskStatus() {
        if (allTasks.isEmpty()) {
            System.err.println("Error: No tasks in the main list to update.");
            return;
        }

        System.out.print("Enter task ID to update: ");
        try {
            int taskId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Find the task by ID in the main list
            Task taskToUpdate = findTaskById(taskId);

            if (taskToUpdate == null) {
                // Use System.err for task not found error
                System.err.println("Error: Task with ID " + taskId + " not found.");
                return;
            }

            System.out.println("Current status for Task " + taskId + ": " + taskToUpdate.getStatus());
            TaskStatus newStatus = getTaskStatusFromInput("Enter new status (e.g., " + getValidStatusesString() + "): ");

            // Update the status
            taskToUpdate.setStatus(newStatus);
            System.out.println("Task " + taskId + " status updated to " + newStatus + ".");

        } catch (InputMismatchException e) {
            // Handle non-integer input for task ID
            System.err.println("Error: Invalid input for task ID. Please enter a number.");
            scanner.nextLine(); // Consume invalid input
        }
    }

    // --- Helper Methods ---

    /**
     * Prints the main menu options to System.out.
     */
    private void printMenu() {
        System.out.println("\n--- Event Task Management ---");
        System.out.println("1. Add New Task");
        System.out.println("2. View Pending Tasks");
        System.out.println("3. Process Next Pending Task");
        System.out.println("4. View All Tasks");
        System.out.println("5. Update Task Status");
        System.out.println("6. Exit");
    }

    /**
     * Finds a task in the main list by its ID.
     * @param id The ID of the task to find.
     * @return The Task object if found, otherwise null.
     */
    private Task findTaskById(int id) {
        // Iterate through the List to find the task
        for (Task task : allTasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null; // Task not found
    }

    /**
     * Prompts the user for a task status and validates the input against TaskStatus enum values.
     * Keeps prompting until valid input is received.
     * @param promptMessage The message to display to the user.
     * @return The validated TaskStatus enum value.
     */
    private TaskStatus getTaskStatusFromInput(String promptMessage) {
        TaskStatus status = null;
        while (status == null) {
            System.out.print(promptMessage);
            String inputStatus = scanner.nextLine().trim().toUpperCase();
            try {
                status = TaskStatus.valueOf(inputStatus);
                if (status == TaskStatus.PENDING) {
                    // Prevent setting status back to PENDING via manual update
                     System.err.println("Error: Cannot set status to PENDING manually. Please choose another status.");
                     status = null; // Reset status to keep looping
                }
            } catch (IllegalArgumentException e) {
                // Handle invalid status string input
                System.err.println("Error: Invalid status. Please enter one of: " + getValidStatusesString());
            }
        }
        return status;
    }

    /**
     * Returns a comma-separated string of valid TaskStatus enum names (excluding PENDING).
     * @return String of valid statuses.
     */
    private String getValidStatusesString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (TaskStatus status : TaskStatus.values()) {
            if (status != TaskStatus.PENDING) { // PENDING is only for initial state
                 if (!first) {
                     sb.append(", ");
                 }
                 sb.append(status.name());
                 first = false;
            }
        }
        return sb.toString();
    }


    // --- Main Method ---

    public static void main(String[] args) {
        // Create an instance of the system and run it
        EventTaskSystem system = new EventTaskSystem();
        system.run();
    }
}
