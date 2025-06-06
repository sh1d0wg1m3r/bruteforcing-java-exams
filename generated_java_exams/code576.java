/*
 * Exam Question #576
 * Generated on: 2025-05-12 16:09:47
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Simple Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a command-line application for a small team to manage their tasks. The system should allow users to add new tasks, view tasks that are pending, mark pending tasks as completed, and view the list of completed tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class named `Task` to represent a single task. It should have private fields for a unique integer `id`, a `String` `description`, and a status (using an enum `TaskStatus` with values `PENDING` and `COMPLETED`). Include a constructor and appropriate public getter/setter methods following encapsulation principles.
 * 2.  **Task Management:** Create a class named `TaskManager` responsible for managing the collection of tasks.
 *     *   It must use a `java.util.Queue<Task>` to store tasks that are currently pending. The queue should represent the order in which tasks are conceptually waiting.
 *     *   It must use a `java.util.List<Task>` to store tasks that have been marked as completed. This list should be implemented using `java.util.ArrayList`.
 *     *   Implement methods within `TaskManager` for:
 *         *   `addTask(String description)`: Creates a new `Task` with a unique ID and `PENDING` status, and adds it to the pending queue.
 *         *   `getPendingTasks()`: Returns a `List<Task>` representing the current pending tasks (without removing them from the queue). This requires iterating through the queue.
 *         *   `completeTask(int taskId)`: Finds the task with the given ID in the *pending* queue, removes it from the queue, sets its status to `COMPLETED`, and adds it to the completed tasks list. This is a critical part requiring careful manipulation of the queue to find and remove an arbitrary element while preserving the order of other elements. If the task ID is not found in the pending queue, it should indicate an error.
 *         *   `getCompletedTasks()`: Returns the `List<Task>` of completed tasks.
 * 3.  **User Interface:** Create a main class (e.g., `TaskApp`) with a `main` method to handle the user interaction.
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user (Add Task, View Pending, Complete Task, View Completed, Exit).
 *     *   Use a `switch` statement to handle the user's menu selection.
 *     *   The application should loop, displaying the menu and processing commands until the user chooses to exit.
 * 4.  **Error Handling & Output:**
 *     *   Implement input validation (e.g., check if a valid integer is entered for task ID).
 *     *   Use `System.err.println()` to print error messages (e.g., invalid input, task not found).
 *     *   Use `System.out.println()` for all normal output (menu, prompts, task details, success messages).
 *     *   Implement **class-wide exception handling** using `try-catch` blocks around the main application logic loop in the `TaskApp` class to catch potential unexpected errors during operation and print a generic error message to `System.err`.
 * 5.  **Best Practices:** Adhere to Java best practices, including:
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation where necessary (e.g., explaining the queue manipulation).
 *     *   Clean code structure with separate classes for different concerns.
 * 
 * **Expected Output:**
 * 
 * The application should display a clear menu, prompt the user for input, display task lists clearly formatted (e.g., "ID: [id], Description: [description]"), indicate successful operations, and print error messages to the standard error stream (`System.err`) when issues occur (like invalid input or trying to complete a non-existent task).
 * 
 * **Challenge Focus:** The core challenge is implementing the `completeTask` method efficiently and correctly using `Queue` operations to find and remove an element that is not necessarily at the head, while maintaining the integrity and order of the remaining elements in the queue.
 *
 * EXPLANATION:
 * This solution implements a simple task management system as required, demonstrating the use of the specified Java components and best practices.
 * 
 * 1.  **`Task` Class:** A simple POJO representing a task with `id`, `description`, and `status`. It uses an enum `TaskStatus` for clarity and enforces encapsulation with private fields and public getters/setters.
 * 
 * 2.  **`TaskStatus` Enum:** Defines the possible states of a task (`PENDING`, `COMPLETED`), making the code more readable and preventing invalid status values.
 * 
 * 3.  **`TaskManager` Class:**
 *     *   Manages the collections of tasks.
 *     *   `pendingTasks`: Declared as `Queue<Task>` and instantiated as `LinkedList<Task>`. `LinkedList` is a common implementation of the `Queue` interface. Tasks are added using `offer()`.
 *     *   `completedTasks`: Declared as `List<Task>` and instantiated as `ArrayList<Task>`. Completed tasks are added to this list.
 *     *   `addTask(String description)`: Creates a new `Task` with a unique ID (`nextTaskId++`) and adds it to the `pendingTasks` queue using `offer()`. Includes basic input validation for the description.
 *     *   `getPendingTasks()`: Returns a `List` containing the pending tasks. Since `Queue` doesn't allow direct iteration without removal easily for a simple view, it creates a *new* `ArrayList` by copying the elements from the queue's current state. This fulfills the requirement of returning a `List` and viewing queue contents non-destructively.
 *     *   `completeTask(int taskId)`: This is the core challenging method. It iterates through the `pendingTasks` queue. For each task, it `poll()`s (removes from the head). If the task's ID matches the target `taskId`, it's stored aside (`taskToComplete`). If it doesn't match, the task is temporarily stored in a `tempQueue`. After iterating through the entire `pendingTasks` queue, the tasks from the `tempQueue` are `offer()`ed back into `pendingTasks`, preserving their original relative order. Finally, if `taskToComplete` was found, its status is updated, and it's added to the `completedTasks` list. If `taskToComplete` is still null after searching, it means the ID wasn't found in the pending queue, and an `IllegalArgumentException` is thrown.
 *     *   `getCompletedTasks()`: Returns the `completedTasks` `List`.
 * 
 * 4.  **`TaskApp` Class:**
 *     *   Contains the `main` method, the entry point of the application.
 *     *   Initializes `Scanner` for input and `TaskManager`.
 *     *   The main application logic runs inside a `while(running)` loop.
 *     *   **Class-wide Exception Handling:** The entire `while` loop (representing the main application flow) is wrapped in a `try-catch(Exception e)` block. This catches any unexpected exceptions that might occur during the program's execution and prints a generic error message and stack trace to `System.err`, fulfilling the "class-wide" handling requirement. A `finally` block ensures the `Scanner` is closed.
 *     *   Inside the loop, a menu is printed using `System.out.println()`.
 *     *   User input is read using `scanner.nextInt()` for the choice, followed by `scanner.nextLine()` to consume the leftover newline character.
 *     *   **Input Validation & Specific Error Handling:** A nested `try-catch(InputMismatchException e)` block specifically handles non-integer input for the menu choice or task ID, printing an error message to `System.err` and consuming the invalid input line to prevent an infinite loop. `IllegalArgumentException` thrown by `TaskManager` methods (e.g., for empty description or task not found) is also caught and its message printed to `System.err`.
 *     *   A `switch` statement processes the user's valid integer choice, calling the appropriate methods on the `taskManager`.
 *     *   `System.out.println()` is used for all normal messages, prompts, and task list displays.
 * 
 * This solution effectively integrates all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, demonstrating proper object-oriented design, error handling, and the specific challenge of manipulating a `Queue` to remove an element by criteria.
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
    COMPLETED
}

// Task Class (POJO)
class Task {
    private int id;
    private String description;
    private TaskStatus status;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = TaskStatus.PENDING; // New tasks are always pending
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

    // Setter (only for status in this simplified model)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Description: " + description + ", Status: " + status;
    }
}

// Task Manager Class
class TaskManager {
    // Using Queue for pending tasks
    private Queue<Task> pendingTasks;
    // Using List (implemented by ArrayList) for completed tasks
    private List<Task> completedTasks;
    private int nextTaskId; // Counter for unique task IDs

    public TaskManager() {
        this.pendingTasks = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>(); // ArrayList implements List
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the pending queue.
     * @param description The description of the task.
     */
    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Task description cannot be empty.");
        }
        Task newTask = new Task(nextTaskId++, description.trim());
        pendingTasks.offer(newTask); // Add to the end of the queue
        System.out.println("Task added: " + newTask.getDescription() + " (ID: " + newTask.getId() + ")");
    }

    /**
     * Returns a list of all pending tasks without removing them from the queue.
     * @return A List of pending tasks.
     */
    public List<Task> getPendingTasks() {
        // To get a list without removing, iterate over the queue elements
        // and add them to a new list.
        List<Task> currentPending = new ArrayList<>(pendingTasks); // Efficient way to copy elements
        return currentPending;
    }

    /**
     * Finds and completes a task by its ID from the pending queue.
     * This involves iterating through the queue, removing the task,
     * and re-adding subsequent tasks back to the queue.
     * @param taskId The ID of the task to complete.
     * @throws IllegalArgumentException if the task ID is not found in the pending queue.
     */
    public void completeTask(int taskId) {
        Task taskToComplete = null;
        // Use a temporary queue to hold tasks that come after the one being completed
        Queue<Task> tempQueue = new LinkedList<>();

        // Iterate through the pending queue
        while (!pendingTasks.isEmpty()) {
            Task currentTask = pendingTasks.poll(); // Remove from the head
            if (currentTask.getId() == taskId) {
                taskToComplete = currentTask; // Found the task to complete
            } else {
                tempQueue.offer(currentTask); // Add other tasks to the temporary queue
            }
        }

        // Restore tasks from the temporary queue back to the original pending queue
        while (!tempQueue.isEmpty()) {
            pendingTasks.offer(tempQueue.poll()); // Add back to the end
        }

        // Process the task if found
        if (taskToComplete != null) {
            if (taskToComplete.getStatus() == TaskStatus.COMPLETED) {
                 // This case shouldn't happen if we only search pendingTasks,
                 // but good practice to check if status was mutable elsewhere.
                 // However, based on requirements, we only search pending.
                 // So this check is technically not needed if completeTask only operates on pending.
                 // Let's refine: the exception should be thrown if not found in PENDING.
                 // If it *was* found but was already completed, it implies logic error elsewhere.
                 // The current logic correctly throws if not found in the pending queue.
            }
            taskToComplete.setStatus(TaskStatus.COMPLETED); // Update status
            completedTasks.add(taskToComplete); // Add to the completed list
            System.out.println("Task ID " + taskId + " marked as completed.");
        } else {
            // Task with the given ID was not found in the pending queue
            throw new IllegalArgumentException("Error: Task with ID " + taskId + " not found in pending tasks.");
        }
    }

    /**
     * Returns the list of completed tasks.
     * @return A List of completed tasks.
     */
    public List<Task> getCompletedTasks() {
        return completedTasks;
    }
}

// Main Application Class
public class TaskApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean running = true;

        // Class-wide exception handling around the main application loop
        try {
            while (running) {
                printMenu();
                int choice = -1;
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input line
                    continue; // Skip to next iteration
                }

                switch (choice) {
                    case 1: // Add Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        try {
                            taskManager.addTask(description);
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 2: // View Pending Tasks
                        List<Task> pending = taskManager.getPendingTasks();
                        if (pending.isEmpty()) {
                            System.out.println("No pending tasks.");
                        } else {
                            System.out.println("\n--- Pending Tasks ---");
                            for (Task task : pending) {
                                System.out.println(task.toString());
                            }
                            System.out.println("---------------------");
                        }
                        break;

                    case 3: // Complete Task
                        System.out.print("Enter ID of task to complete: ");
                        int taskIdToComplete = -1;
                        try {
                            taskIdToComplete = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            taskManager.completeTask(taskIdToComplete);
                        } catch (InputMismatchException e) {
                            System.err.println("Invalid input. Please enter a valid task ID (number).");
                            scanner.nextLine(); // Consume invalid input
                        } catch (IllegalArgumentException e) {
                            System.err.println(e.getMessage()); // Task not found error
                        }
                        break;

                    case 4: // View Completed Tasks
                        List<Task> completed = taskManager.getCompletedTasks();
                        if (completed.isEmpty()) {
                            System.out.println("No completed tasks.");
                        } else {
                            System.out.println("\n--- Completed Tasks ---");
                            for (Task task : completed) {
                                System.out.println(task.toString());
                            }
                            System.out.println("-----------------------");
                        }
                        break;

                    case 0: // Exit
                        System.out.println("Exiting Task Management System. Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                System.out.println(); // Add a blank line for readability
            }
        } catch (Exception e) {
            // Generic catch-all for unexpected errors in the main loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to stderr
        } finally {
            scanner.close(); // Ensure scanner is closed
            System.out.println("Application terminated.");
        }
    }

    private static void printMenu() {
        System.out.println("--- Task Management Menu ---");
        System.out.println("1. Add Task");
        System.out.println("2. View Pending Tasks");
        System.out.println("3. Complete Task");
        System.out.println("4. View Completed Tasks");
        System.out.println("0. Exit");
        System.out.println("--------------------------");
    }
}
