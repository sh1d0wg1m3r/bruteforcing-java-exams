/*
 * Exam Question #355
 * Generated on: 2025-05-11 22:59:36
 * Generated by: Account 4
 * 
 * QUESTION:
 * **Subject:** Advanced Java Programming
 * **Task Title:** Project Task Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple command-line application for managing tasks within a project. The system should allow users to add new tasks, mark existing tasks as complete, view all tasks, and view only the tasks that are currently pending.
 * 
 * Each task should have a unique identifier, a description, a priority level (High, Medium, Low), and a status (Pending, Completed).
 * 
 * The application must be interactive, prompting the user for actions via a menu.
 * 
 * **Specific Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with appropriate fields (`taskId`, `description`, `priority`, `status`), a constructor, and getter methods. Include a mechanism to generate unique task IDs (e.g., a simple counter). Override the `toString()` method for easy display.
 * 2.  **Project Management Logic:** Create a `ProjectManager` class to handle the collection of tasks and the management logic.
 *     *   It should internally maintain *two* collections:
 *         *   A `List` (specifically an `ArrayList`) to store *all* tasks ever created.
 *         *   A `Queue` (use a `LinkedList` that implements `Queue`) to store only the tasks that are currently in a "Pending" status, potentially ordered by the order they became pending or were added.
 *     *   Implement the following methods in `ProjectManager`:
 *         *   `addTask(String description, String priority)`: Creates a new `Task`, adds it to both the `allTasks` list and the `pendingTasksQueue`. Validate the priority input (only "High", "Medium", "Low" allowed, case-insensitive). Default status is "Pending".
 *         *   `completeTask(int taskId)`: Finds the task by ID in the `allTasks` list. If found and its status is "Pending", update its status to "Completed" and remove it from the `pendingTasksQueue`. Handle cases where the task is not found or is already completed.
 *         *   `viewAllTasks()`: Prints details of all tasks stored in the `allTasks` list.
 *         *   `viewPendingTasks()`: Prints details of all tasks currently in the `pendingTasksQueue`.
 * 3.  **User Interface:** Create a `Main` class with a `main` method to handle user interaction.
 *     *   Display a menu with options: Add Task, Complete Task, View All Tasks, View Pending Tasks, Exit.
 *     *   Use `Scanner` to read user input for menu choices and task details.
 *     *   Use a `switch` statement to process the user's menu choice.
 *     *   Call the appropriate `ProjectManager` methods based on the user's selection.
 * 4.  **Error Handling and Output:**
 *     *   Use `System.out` for menu display, prompts, successful operation messages, and task lists.
 *     *   Use `System.err` to display error messages (e.g., invalid menu choice, invalid priority during task creation, task not found/already completed during completion).
 *     *   Implement robust input validation (e.g., ensuring task ID input is an integer).
 *     *   Include class-wide exception handling in the `Main` class (e.g., a `try-catch` block around the main application loop) to gracefully handle unexpected runtime errors.
 * 5.  **Best Practices:**
 *     *   Use private fields and public methods for encapsulation.
 *     *   Use meaningful variable and method names.
 *     *   Add comments to explain complex logic or class purpose.
 *     *   Ensure proper resource management (e.g., closing the `Scanner`).
 * 
 * **Expected Output:**
 * 
 * The application should run interactively. Example flow:
 * 
 * ```
 * --- Project Task Management ---
 * 1. Add Task
 * 2. Complete Task
 * 3. View All Tasks
 * 4. View Pending Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Design Database Schema
 * Enter priority (High, Medium, Low): High
 * Task added successfully!
 * 
 * --- Project Task Management ---
 * 1. Add Task
 * 2. Complete Task
 * 3. View All Tasks
 * 4. View Pending Tasks
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Implement API Endpoints
 * Enter priority (High, Medium, Low): Medium
 * Task added successfully!
 * 
 * --- Project Task Management ---
 * 1. Add Task
 * 2. Complete Task
 * 3. View All Tasks
 * 4. View Pending Tasks
 * 5. Exit
 * Enter your choice: 4
 * Pending Tasks:
 * Task ID: 1, Description: Design Database Schema, Priority: High, Status: Pending
 * Task ID: 2, Description: Implement API Endpoints, Priority: Medium, Status: Pending
 * 
 * --- Project Task Management ---
 * 1. Add Task
 * 2. Complete Task
 * 3. View All Tasks
 * 4. View Pending Tasks
 * 5. Exit
 * Enter your choice: 2
 * Enter Task ID to complete: 1
 * Task 1 marked as Completed.
 * 
 * --- Project Task Management ---
 * 1. Add Task
 * 2. Complete Task
 * 3. View All Tasks
 * 4. View Pending Tasks
 * 5. Exit
 * Enter your choice: 4
 * Pending Tasks:
 * Task ID: 2, Description: Implement API Endpoints, Priority: Medium, Status: Pending
 * 
 * --- Project Task Management ---
 * 1. Add Task
 * 2. Complete Task
 * 3. View All Tasks
 * 4. View Pending Tasks
 * 5. Exit
 * Enter your choice: 3
 * All Tasks:
 * Task ID: 1, Description: Design Database Schema, Priority: High, Status: Completed
 * Task ID: 2, Description: Implement API Endpoints, Priority: Medium, Status: Pending
 * 
 * --- Project Task Management ---
 * 1. Add Task
 * 2. Complete Task
 * 3. View All Tasks
 * 4. View Pending Tasks
 * 5. Exit
 * Enter your choice: 5
 * Exiting Task Management System.
 * ```
 * 
 * Error messages should be printed to `System.err`.
 * 
 * ```
 * --- Project Task Management ---
 * ...
 * Enter your choice: 1
 * Enter task description: Write Documentation
 * Enter priority (High, Medium, Low): Urgent
 * Error: Invalid priority. Please use High, Medium, or Low.
 * ```
 * 
 * ```
 * --- Project Task Management ---
 * ...
 * Enter your choice: 2
 * Enter Task ID to complete: 99
 * Error: Task with ID 99 not found.
 * ```
 * 
 * ```
 * --- Project Task Management ---
 * ...
 * Enter your choice: 2
 * Enter Task ID to complete: 2
 * Task 2 marked as Completed.
 * 
 * --- Project Task Management ---
 * ...
 * Enter your choice: 2
 * Enter Task ID to complete: 2
 * Error: Task with ID 2 is already completed.
 * ```
 * 
 * Your solution should be a single Java file containing all necessary classes.
 *
 * EXPLANATION:
 * This solution implements a simple command-line Project Task Management System demonstrating the required Java concepts.
 * 
 * 1.  **Task Class:**
 *     *   Represents individual tasks with `taskId`, `description`, `priority`, and `status`.
 *     *   `taskId` is generated automatically using a static counter (`nextTaskId`) ensuring uniqueness for each new task instance.
 *     *   Encapsulation is used with private fields and public getters.
 *     *   `toString()` provides a convenient string representation for printing.
 *     *   `equals()` and `hashCode()` are overridden based on `taskId`. This is crucial because the `Queue.remove(Object)` method used in `completeTask` relies on the `equals()` method to find and remove the correct task object from the queue.
 * 
 * 2.  **ProjectManager Class:**
 *     *   Acts as the central controller for managing tasks.
 *     *   Uses a `List<Task>` (`ArrayList`) named `allTasks` to keep a persistent record of *all* tasks created, regardless of their status. `ArrayList` provides efficient random access and iteration for viewing all tasks.
 *     *   Uses a `Queue<Task>` (`LinkedList`) named `pendingTasksQueue` specifically to manage tasks that are currently "Pending". `LinkedList` implements the `Queue` interface, providing methods like `offer()` to add to the end and `remove()` to remove a specific element. While a `Queue` typically processes elements from the head (`poll()`), here it's used more like a collection of pending items where specific items are removed upon completion, demonstrating `Queue`'s `remove(Object)` capability in addition to its typical usage.
 *     *   `addTask`: Creates a `Task` object, adds it to `allTasks`, and `offer()`s it to the `pendingTasksQueue`. Includes input validation for the `priority` field, printing an error to `System.err` if invalid.
 *     *   `completeTask`: Iterates through `allTasks` to find the task by ID. It checks if the task exists and is pending before updating the status. It then uses `pendingTasksQueue.remove(taskToComplete)` to remove the task from the queue. This removal relies on the `equals()` method implemented in the `Task` class. Error messages for task not found or already completed are printed to `System.err`.
 *     *   `viewAllTasks`: Iterates through the `allTasks` list and prints each task's details using its `toString()` method.
 *     *   `viewPendingTasks`: Iterates through the `pendingTasksQueue` and prints each pending task. Iteration is done directly or using an iterator, as simply viewing doesn't require `poll()`.
 * 
 * 3.  **ProjectTaskApp (Main Class):**
 *     *   Contains the `main` method, the entry point of the application.
 *     *   Initializes a `Scanner` for user input and a `ProjectManager` instance.
 *     *   The main application loop runs until the user chooses to exit.
 *     *   A `switch` statement is used to handle the different menu options, calling the appropriate methods in the `ProjectManager`.
 *     *   Input validation is performed for the menu choice itself (ensuring it's an integer) and handled by `ProjectManager` for task details like priority. Error messages for invalid input or menu choices are printed to `System.err`.
 *     *   `System.out` is used for printing the menu, prompts, successful messages, and task lists.
 *     *   **Class-wide Exception Handling:** A `try-catch(Exception e)` block is wrapped around the *entire* main `while` loop. This demonstrates a robust way to catch any unexpected runtime exception that might occur within the application's core logic and print an error message (including the stack trace to `System.err`) before the application potentially terminates. A `finally` block ensures the `Scanner` resource is closed properly.
 *     *   Proper `Scanner` usage includes consuming the newline character after reading integers (`scanner.nextInt()`) using `scanner.nextLine()` to prevent issues with subsequent `nextLine()` calls.
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) into a practical, albeit simple, task management system, demonstrating best practices like encapsulation, input validation, and error handling. The use of both `ArrayList` and `Queue` for different purposes (`allTasks` vs. `pendingTasks`) showcases their distinct roles in managing collections.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Locale; // For case-insensitive priority check

// Represents a single task
class Task {
    private int taskId;
    private String description;
    private String priority; // High, Medium, Low
    private String status;   // Pending, Completed

    private static int nextTaskId = 1; // For generating unique IDs

    public Task(String description, String priority) {
        this.taskId = nextTaskId++;
        this.description = description;
        this.priority = priority;
        this.status = "Pending"; // Default status
    }

    // Getters
    public int getTaskId() {
        return taskId;
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

    // Setter for status (used by ProjectManager)
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Task ID: %d, Description: %s, Priority: %s, Status: %s",
                taskId, description, priority, status);
    }

    // Override equals and hashCode based on taskId for easier removal from Queue
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(taskId);
    }
}

// Manages the collection and operations on tasks
class ProjectManager {
    private List<Task> allTasks;       // Stores all tasks ever created (using ArrayList)
    private Queue<Task> pendingTasksQueue; // Stores tasks that are currently pending (using LinkedList as Queue)

    public ProjectManager() {
        allTasks = new ArrayList<>();
        pendingTasksQueue = new LinkedList<>();
    }

    /**
     * Adds a new task to the system.
     *
     * @param description The task description.
     * @param priority    The task priority (High, Medium, Low).
     * @return The newly created Task object, or null if priority is invalid.
     */
    public Task addTask(String description, String priority) {
        // Validate priority
        String lowerPriority = priority.toLowerCase(Locale.US);
        if (!lowerPriority.equals("high") && !lowerPriority.equals("medium") && !lowerPriority.equals("low")) {
            System.err.println("Error: Invalid priority. Please use High, Medium, or Low.");
            return null; // Indicate failure
        }

        // Create task with validated priority (preserving original case if needed, or normalize)
        // Let's normalize to capitalize first letter for consistency in display
        String normalizedPriority = priority.substring(0, 1).toUpperCase() + priority.substring(1).toLowerCase();

        Task newTask = new Task(description, normalizedPriority);
        allTasks.add(newTask);
        pendingTasksQueue.offer(newTask); // Add to the end of the pending queue
        System.out.println("Task added successfully!");
        return newTask; // Return the added task
    }

    /**
     * Marks a task as completed.
     *
     * @param taskId The ID of the task to complete.
     * @return true if the task was successfully completed, false otherwise.
     */
    public boolean completeTask(int taskId) {
        // Find the task in the allTasks list
        Task taskToComplete = null;
        for (Task task : allTasks) {
            if (task.getTaskId() == taskId) {
                taskToComplete = task;
                break;
            }
        }

        if (taskToComplete == null) {
            System.err.println("Error: Task with ID " + taskId + " not found.");
            return false;
        }

        if (taskToComplete.getStatus().equals("Completed")) {
            System.err.println("Error: Task with ID " + taskId + " is already completed.");
            return false;
        }

        // Update status
        taskToComplete.setStatus("Completed");

        // Remove from the pending tasks queue
        // Queue.remove(Object) relies on the equals() method of Task
        boolean removedFromQueue = pendingTasksQueue.remove(taskToComplete);

        if (removedFromQueue) {
             System.out.println("Task " + taskId + " marked as Completed.");
        } else {
             // This case should ideally not happen if logic is correct, but good for debugging
             System.err.println("Warning: Task " + taskId + " marked completed but was not found in the pending queue.");
        }

        return true;
    }

    /**
     * Prints all tasks in the system.
     */
    public void viewAllTasks() {
        System.out.println("\nAll Tasks:");
        if (allTasks.isEmpty()) {
            System.out.println("No tasks in the system.");
        } else {
            for (Task task : allTasks) {
                System.out.println(task);
            }
        }
    }

    /**
     * Prints all tasks currently in the pending queue.
     */
    public void viewPendingTasks() {
        System.out.println("\nPending Tasks:");
        if (pendingTasksQueue.isEmpty()) {
            System.out.println("No pending tasks.");
        } else {
            // Iterate through the queue without removing elements (peek or iterator)
            // Using iterator is simpler for printing all
            for (Task task : pendingTasksQueue) {
                 System.out.println(task);
            }
            // Alternatively, using peek and poll repeatedly (less efficient for just viewing)
            // Queue<Task> tempQueue = new LinkedList<>();
            // while (!pendingTasksQueue.isEmpty()) {
            //     Task task = pendingTasksQueue.poll();
            //     System.out.println(task);
            //     tempQueue.offer(task);
            // }
            // pendingTasksQueue.addAll(tempQueue); // Put them back
        }
    }
}

// Main application class
public class ProjectTaskApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProjectManager projectManager = new ProjectManager();
        boolean running = true;

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                printMenu();
                System.out.print("Enter your choice: ");

                // Input validation for menu choice
                int choice = -1;
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Skip to the next loop iteration
                }
                scanner.nextLine(); // Consume the newline character after reading int

                // Use switch for menu control
                switch (choice) {
                    case 1: // Add Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter priority (High, Medium, Low): ");
                        String priority = scanner.nextLine();
                        // addTask handles its own validation and error messages
                        projectManager.addTask(description, priority);
                        break;

                    case 2: // Complete Task
                        System.out.print("Enter Task ID to complete: ");
                        int taskIdToComplete = -1;
                        if (scanner.hasNextInt()) {
                             taskIdToComplete = scanner.nextInt();
                             scanner.nextLine(); // Consume newline
                             projectManager.completeTask(taskIdToComplete);
                        } else {
                            System.err.println("Error: Invalid input. Please enter a number for Task ID.");
                            scanner.next(); // Consume invalid input
                            scanner.nextLine(); // Consume rest of line
                        }
                        break;

                    case 3: // View All Tasks
                        projectManager.viewAllTasks();
                        break;

                    case 4: // View Pending Tasks
                        projectManager.viewPendingTasks();
                        break;

                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting Task Management System.");
                        break;

                    default: // Invalid choice
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
                System.out.println(); // Add a newline for better readability between interactions
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions
            System.err.println("\nAn unexpected error occurred:");
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
             // Ensure scanner is closed even if an exception occurs
             if (scanner != null) {
                 scanner.close();
             }
        }
    }

    // Helper method to print the menu
    private static void printMenu() {
        System.out.println("--- Project Task Management ---");
        System.out.println("1. Add Task");
        System.out.println("2. Complete Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. View Pending Tasks");
        System.out.println("5. Exit");
    }
}
