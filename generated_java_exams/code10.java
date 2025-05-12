/*
 * Exam Question #10
 * Generated on: 2025-05-11 21:31:11
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Task Management System
 * 
 * **Objective:** Design and implement a command-line based Task Management System for a small team. The system should allow users to add tasks, manage their status by moving them to an active queue, complete tasks from the active queue, and view tasks based on their status. This task requires demonstrating proficiency in using various Java collections and control structures, along with robust error handling.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with private fields for `id` (auto-generated integer), `description` (String), `priority` (String, e.g., "High", "Medium", "Low"), and `status` (String, e.g., "Pending", "Active", "Completed"). Include a constructor, appropriate getters, and a setter for the status. Override `toString()` for easy printing.
 * 2.  **Task Management Logic:** Create a `TaskManager` class with the following private fields:
 *     *   `List<Task> allTasks`: To store all tasks ever created. Use `java.util.ArrayList` as the implementation.
 *     *   `Queue<Task> activeTasksQueue`: To store tasks currently being worked on. Use `java.util.Queue` interface and `java.util.LinkedList` as the implementation.
 *     *   An integer counter for generating unique task IDs.
 * 3.  **Functionality:** Implement the following public methods in the `TaskManager` class:
 *     *   `addTask(String description, String priority)`: Creates a new `Task` with status "Pending", adds it to `allTasks`. Validate the priority string (only "High", "Medium", "Low" allowed).
 *     *   `moveTaskToActive(int taskId)`: Finds the task by ID in `allTasks`. If found and its status is "Pending", change its status to "Active" and add it to `activeTasksQueue`. Throw a custom exception (`TaskManagementException`) if the task is not found, or if its status is not "Pending".
 *     *   `completeTask(int taskId)`: Finds the task by ID in `activeTasksQueue`. If found, remove it from the queue, find the corresponding task in `allTasks`, and change its status to "Completed". Throw a custom exception (`TaskManagementException`) if the task is not found in the `activeTasksQueue`.
 *     *   `viewAllTasks()`: Prints details of all tasks from `allTasks`.
 *     *   `viewActiveTasks()`: Prints details of all tasks currently in `activeTasksQueue`.
 *     *   `viewCompletedTasks()`: Prints details of all tasks from `allTasks` whose status is "Completed".
 * 4.  **User Interface:** Implement a simple command-line interface in a `Main` class or the `TaskManager` class's `main` method using `java.util.Scanner` to interact with the user.
 *     *   Display a menu of options (Add Task, View All, View Active, View Completed, Move to Active, Complete Task, Exit).
 *     *   Read user input using `Scanner`.
 *     *   Use a `switch` statement to handle different menu options.
 * 5.  **Error Handling:**
 *     *   Create a custom exception class `TaskManagementException`.
 *     *   Use `try-catch` blocks to handle potential errors:
 *         *   Input validation errors (e.g., non-integer input for ID, invalid priority string).
 *         *   Errors thrown by `TaskManager` methods (`TaskManagementException`).
 *     *   Print error messages using `System.err`.
 *     *   Use a class-wide or method-level `try-catch` block to catch unexpected exceptions during program execution.
 * 6.  **Output:**
 *     *   Use `System.out` for menu display, task lists, and success messages.
 *     *   Use `System.err` for all error messages.
 * 7.  **Best Practices:**
 *     *   Use appropriate access modifiers (`private`, `public`) for encapsulation.
 *     *   Use meaningful variable and method names.
 *     *   Include basic comments explaining complex logic or purpose.
 *     *   Ensure the `Scanner` is properly closed.
 *     *   Declare collection variables using interface types (`List`, `Queue`).
 * 
 * **Expected Output:**
 * The program should start by displaying the menu. Based on user input, it should perform the requested action, print the results or status messages to `System.out`, and print error messages to `System.err` if any issues occur (e.g., invalid input, task not found, invalid task status for an operation).
 * 
 * **Example Interaction Snippet (Illustrative):**
 * 
 * ```
 * --- Task Management System ---
 * 1. Add Task
 * 2. View All Tasks
 * 3. View Active Tasks
 * 4. View Completed Tasks
 * 5. Move Task to Active
 * 6. Complete Task
 * 7. Exit
 * Enter option: 1
 * Enter task description: Implement login feature
 * Enter priority (High/Medium/Low): High
 * Task added successfully! ID: 1
 * 
 * --- Task Management System ---
 * ...
 * Enter option: 2
 * --- All Tasks ---
 * ID: 1, Description: Implement login feature, Priority: High, Status: Pending
 * 
 * --- Task Management System ---
 * ...
 * Enter option: 5
 * Enter Task ID to move to active: 1
 * Task 1 moved to active.
 * 
 * --- Task Management System ---
 * ...
 * Enter option: 3
 * --- Active Tasks ---
 * ID: 1, Description: Implement login feature, Priority: High, Status: Active
 * 
 * --- Task Management System ---
 * ...
 * Enter option: 6
 * Enter Task ID to complete: 1
 * Task 1 completed.
 * 
 * --- Task Management System ---
 * ...
 * Enter option: 4
 * --- Completed Tasks ---
 * ID: 1, Description: Implement login feature, Priority: High, Status: Completed
 * 
 * --- Task Management System ---
 * ...
 * Enter option: 5
 * Enter Task ID to move to active: 99
 * Error: Task with ID 99 not found. (Printed to System.err)
 * 
 * --- Task Management System ---
 * ...
 * Enter option: 6
 * Enter Task ID to complete: abc
 * Invalid input. Please enter a number for Task ID. (Printed to System.err)
 * ```
 * 
 * Implement the complete Java code for this system.
 *
 * EXPLANATION:
 * This solution implements the Task Management System as described, utilizing all required Java components and adhering to best practices.
 * 
 * 1.  **Task Class:** The `Task` class encapsulates task data (`id`, `description`, `priority`, `status`) with private fields and public getters. The status can be updated via `setStatus()`. `toString()` provides a convenient way to print task details. `equals()` and `hashCode()` are overridden based on `id`, which is good practice when using objects in collections like `Queue` if you need to search or remove specific instances.
 * 
 * 2.  **TaskManager Class:**
 *     *   It uses a `List<Task>` (`allTasks`) implemented by `ArrayList` to keep track of every task created. `ArrayList` is suitable here for storing and iterating through a potentially large number of tasks, allowing easy lookup by iterating or using a helper method.
 *     *   It uses a `Queue<Task>` (`activeTasksQueue`) implemented by `LinkedList`. `Queue` is ideal for managing tasks that are actively being worked on, as they are typically processed in a First-In, First-Out (FIFO) manner (though our `completeTask` allows completing any task in the queue by ID, deviating slightly from strict FIFO but fitting the scenario). `offer()` is used to add tasks to the queue, and `removeIf()` is used for removal during completion.
 *     *   `nextTaskId` ensures unique IDs for new tasks.
 *     *   Methods like `addTask`, `moveTaskToActive`, and `completeTask` manage the state transitions of tasks and their movement between the `allTasks` list and the `activeTasksQueue`.
 *     *   Helper methods like `findTaskById` and `isValidPriority` improve code organization and readability.
 * 
 * 3.  **User Interface (main method in TaskManager):**
 *     *   A `Scanner` is used to read user input from the console.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   A `switch` statement is used for clear and efficient handling of the different menu options provided by the user.
 * 
 * 4.  **Error Handling:**
 *     *   A custom exception `TaskManagementException` is defined to signal specific errors related to task operations (e.g., task not found, invalid status).
 *     *   `try-catch` blocks are used extensively:
 *         *   An outer `try-catch` block wraps the main `while` loop to catch any unexpected exceptions that might occur during execution, preventing the program from crashing abruptly.
 *         *   Nested `try-catch` blocks within the `switch` cases handle specific anticipated errors:
 *             *   `InputMismatchException` is caught when `scanner.nextInt()` fails to read an integer, ensuring the program doesn't crash and prompts the user correctly. `scanner.nextLine()` is crucial after `nextInt()` to consume the leftover newline character.
 *             *   `TaskManagementException` is caught when `TaskManager` methods indicate a business logic error (like trying to move a completed task or complete a non-active task).
 *     *   `System.err.println()` is used exclusively for printing error messages, distinguishing them from normal program output.
 * 
 * 5.  **Output:** `System.out.println()` is used for displaying the menu, task lists, and success messages, providing clear feedback to the user.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation is maintained by making fields private and providing controlled access via public methods.
 *     *   Variable and method names are descriptive (e.g., `activeTasksQueue`, `moveTaskToActive`).
 *     *   Comments explain the purpose of methods and complex parts.
 *     *   The `Scanner` is closed in a `finally` block to release system resources.
 *     *   Collection variables are declared using interface types (`List`, `Queue`), promoting flexibility.
 * 
 * This solution demonstrates the practical application of the required Java concepts in building a functional system with proper structure, input handling, and error management, fulfilling the requirements of a challenging exam task.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Custom Exception for Task Management errors
class TaskManagementException extends Exception {
    public TaskManagementException(String message) {
        super(message);
    }
}

// Represents a single task
class Task {
    private int id;
    private String description;
    private String priority; // High, Medium, Low
    private String status; // Pending, Active, Completed

    public Task(int id, String description, String priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = "Pending"; // Default status
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Description: " + description +
               ", Priority: " + priority + ", Status: " + status;
    }

    // Override equals and hashCode for Queue operations (optional but good practice)
    // Useful if you need to search/remove by Task object instance in Queue
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

// Manages collections of tasks and operations
class TaskManager {
    // Using List interface for all tasks, implemented by ArrayList
    private List<Task> allTasks;
    // Using Queue interface for active tasks, implemented by LinkedList
    private Queue<Task> activeTasksQueue;
    private int nextTaskId;

    public TaskManager() {
        this.allTasks = new ArrayList<>();
        this.activeTasksQueue = new LinkedList<>();
        this.nextTaskId = 1;
    }

    /**
     * Adds a new task to the system.
     *
     * @param description The task description.
     * @param priority    The task priority (High, Medium, Low).
     * @throws TaskManagementException if the priority is invalid.
     */
    public void addTask(String description, String priority) throws TaskManagementException {
        if (!isValidPriority(priority)) {
            throw new TaskManagementException("Invalid priority: " + priority + ". Must be High, Medium, or Low.");
        }
        Task newTask = new Task(nextTaskId++, description, priority);
        allTasks.add(newTask);
        System.out.println("Task added successfully! ID: " + newTask.getId());
    }

    /**
     * Moves a pending task to the active queue.
     *
     * @param taskId The ID of the task to move.
     * @throws TaskManagementException if the task is not found or not in Pending status.
     */
    public void moveTaskToActive(int taskId) throws TaskManagementException {
        Task taskToMove = findTaskById(taskId, allTasks);

        if (taskToMove == null) {
            throw new TaskManagementException("Task with ID " + taskId + " not found.");
        }

        if (!"Pending".equals(taskToMove.getStatus())) {
            throw new TaskManagementException("Task with ID " + taskId + " is not in Pending status (current status: " + taskToMove.getStatus() + ").");
        }

        taskToMove.setStatus("Active");
        activeTasksQueue.offer(taskToMove); // Add to the end of the queue
    }

    /**
     * Completes a task from the active queue.
     *
     * @param taskId The ID of the task to complete.
     * @throws TaskManagementException if the task is not found in the active queue.
     */
    public void completeTask(int taskId) throws TaskManagementException {
        // Find and remove from the active queue
        boolean removedFromQueue = activeTasksQueue.removeIf(task -> task.getId() == taskId);

        if (!removedFromQueue) {
            throw new TaskManagementException("Task with ID " + taskId + " not found in the active queue.");
        }

        // Find the corresponding task in allTasks and update status
        Task completedTask = findTaskById(taskId, allTasks);
        // This should not be null if removedFromQueue is true, but good practice to check
        if (completedTask != null) {
            completedTask.setStatus("Completed");
        } else {
             // This is an inconsistent state, log or handle appropriately
             System.err.println("Warning: Completed task ID " + taskId + " found in queue but not in allTasks list.");
        }
    }

    /**
     * Prints all tasks in the system.
     */
    public void viewAllTasks() {
        System.out.println("--- All Tasks ---");
        if (allTasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        for (Task task : allTasks) {
            System.out.println(task);
        }
    }

    /**
     * Prints tasks currently in the active queue.
     */
    public void viewActiveTasks() {
        System.out.println("--- Active Tasks ---");
        if (activeTasksQueue.isEmpty()) {
            System.out.println("No tasks currently active.");
            return;
        }
        // Iterate without removing from the queue
        for (Task task : activeTasksQueue) {
            System.out.println(task);
        }
    }

    /**
     * Prints tasks that have been completed.
     */
    public void viewCompletedTasks() {
        System.out.println("--- Completed Tasks ---");
        List<Task> completed = new ArrayList<>();
        for (Task task : allTasks) {
            if ("Completed".equals(task.getStatus())) {
                completed.add(task);
            }
        }

        if (completed.isEmpty()) {
            System.out.println("No tasks completed yet.");
            return;
        }
        for (Task task : completed) {
            System.out.println(task);
        }
    }

    // Helper method to find a task by ID in a given list
    private Task findTaskById(int taskId, List<Task> taskList) {
        for (Task task : taskList) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null; // Task not found
    }

    // Helper method to validate priority string
    private boolean isValidPriority(String priority) {
        return "High".equalsIgnoreCase(priority) ||
               "Medium".equalsIgnoreCase(priority) ||
               "Low".equalsIgnoreCase(priority);
    }

    // Main method for the command-line interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();

        // Class-wide exception handling wrapper
        try {
            boolean running = true;
            while (running) {
                printMenu();

                try {
                    System.out.print("Enter option: ");
                    int option = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Use switch statement for menu navigation
                    switch (option) {
                        case 1: // Add Task
                            System.out.print("Enter task description: ");
                            String description = scanner.nextLine();
                            System.out.print("Enter priority (High/Medium/Low): ");
                            String priority = scanner.nextLine();
                            try {
                                manager.addTask(description, priority);
                            } catch (TaskManagementException e) {
                                System.err.println("Error: " + e.getMessage());
                            }
                            break;
                        case 2: // View All Tasks
                            manager.viewAllTasks();
                            break;
                        case 3: // View Active Tasks
                            manager.viewActiveTasks();
                            break;
                        case 4: // View Completed Tasks
                            manager.viewCompletedTasks();
                            break;
                        case 5: // Move Task to Active
                            System.out.print("Enter Task ID to move to active: ");
                            try {
                                int taskIdToActivate = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                manager.moveTaskToActive(taskIdToActivate);
                                System.out.println("Task " + taskIdToActivate + " moved to active.");
                            } catch (InputMismatchException e) {
                                System.err.println("Invalid input. Please enter a number for Task ID.");
                                scanner.nextLine(); // Consume the invalid input
                            } catch (TaskManagementException e) {
                                System.err.println("Error: " + e.getMessage());
                            }
                            break;
                        case 6: // Complete Task
                            System.out.print("Enter Task ID to complete: ");
                            try {
                                int taskIdToComplete = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                manager.completeTask(taskIdToComplete);
                                System.out.println("Task " + taskIdToComplete + " completed.");
                            } catch (InputMismatchException e) {
                                System.err.println("Invalid input. Please enter a number for Task ID.");
                                scanner.nextLine(); // Consume the invalid input
                            } catch (TaskManagementException e) {
                                System.err.println("Error: " + e.getMessage());
                            }
                            break;
                        case 7: // Exit
                            running = false;
                            System.out.println("Exiting Task Management System. Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number for the menu option.");
                    scanner.nextLine(); // Consume the invalid input
                }
                System.out.println(); // Add a newline for better readability between operations
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main loop execution
            System.err.println("An unexpected error occurred during program execution: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging unexpected errors
        } finally {
            // Ensure scanner is closed
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    // Prints the main menu
    private static void printMenu() {
        System.out.println("--- Task Management System ---");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. View Active Tasks");
        System.out.println("4. View Completed Tasks");
        System.out.println("5. Move Task to Active");
        System.out.println("6. Complete Task");
        System.out.println("7. Exit");
    }
}
