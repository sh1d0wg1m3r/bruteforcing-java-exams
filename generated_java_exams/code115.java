/*
 * Exam Question #115
 * Generated on: 2025-05-11 22:16:38
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Priority Task Scheduler
 * 
 * **Objective:** Design and implement a simple command-line application for managing tasks with different priority levels. This task requires you to demonstrate your understanding of core Java collections, control flow, exception handling, and object-oriented design principles.
 * 
 * **Scenario:** You are building the backend logic for a basic task management system. Users can add new tasks, view tasks currently pending completion, view tasks that have been completed, and mark pending tasks as completed. Tasks have a description and a priority level (High, Medium, Low).
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a class `Task` to represent a single task. It should have:
 *     *   A unique integer ID (automatically generated).
 *     *   A `String` description.
 *     *   A `Priority` enum (High, Medium, Low).
 *     *   A `Status` enum (PENDING, COMPLETED).
 *     *   Appropriate private fields and public getter methods.
 *     *   Override `toString()` for easy display.
 *     *   Override `equals()` and `hashCode()` based on the task ID to facilitate removal from collections.
 * 2.  **Task Scheduler Logic:** Create a class `TaskScheduler` that manages the tasks. It should have:
 *     *   A `Queue<Task>` to hold tasks that are currently `PENDING`.
 *     *   An `ArrayList<Task>` to hold tasks that have been `COMPLETED`.
 *     *   An `ArrayList<Task>` to keep a record of *all* tasks ever created (useful for lookup by ID).
 *     *   A mechanism to generate unique task IDs.
 *     *   Public methods for the following operations:
 *         *   `addTask(String description, Priority priority)`: Creates a new `Task`, assigns a unique ID, sets status to `PENDING`, adds it to the `allTasks` list and the `pendingTasks` queue.
 *         *   `viewPendingTasks()`: Returns a `List<Task>` of tasks currently in the `pendingTasks` queue. The returned list should be sorted by priority (High > Medium > Low).
 *         *   `viewCompletedTasks()`: Returns a `List<Task>` of tasks currently in the `completedTasks` list.
 *         *   `completeTask(int taskId)`: Finds the task with the given ID in the `pendingTasks` queue, removes it, changes its status to `COMPLETED`, and adds it to the `completedTasks` list. This method should handle cases where the task ID is not found or the task is not in the pending state.
 *     *   All methods should use appropriate encapsulation.
 * 3.  **User Interface (Main Method):** Implement the main application logic in a `main` method.
 *     *   Use a `Scanner` to read user input from the console.
 *     *   Present a menu of options to the user (Add Task, View Pending, View Completed, Complete Task, Exit).
 *     *   Use a `switch` statement to handle the user's choice.
 *     *   Implement input validation for user choices (e.g., menu option, priority level, task ID).
 *     *   Use `System.out` for displaying the menu, task lists, and success messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, task not found/pending).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors (e.g., `InputMismatchException`, unexpected errors). A general `try-catch` around the main loop is recommended.
 * 4.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include comments or Javadoc where necessary to explain complex logic.
 *     *   Ensure proper resource management (e.g., closing the `Scanner`).
 * 
 * **Example Interaction Flow:**
 * 
 * ```
 * Task Scheduler Menu:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View Completed Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Write exam question
 * Enter priority (HIGH, MEDIUM, LOW): HIGH
 * Task added with ID: 1
 * 
 * Task Scheduler Menu:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View Completed Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice: 1
 * Enter task description: Grade exams
 * Enter priority (MEDIUM): MEDIUM
 * Task added with ID: 2
 * 
 * Task Scheduler Menu:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View Completed Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice: 2
 * --- Pending Tasks (Sorted by Priority) ---
 * [ID: 1, Priority: HIGH, Status: PENDING] Write exam question
 * [ID: 2, Priority: MEDIUM, Status: PENDING] Grade exams
 * -------------------------------------------
 * 
 * Task Scheduler Menu:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View Completed Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice: 4
 * Enter task ID to complete: 1
 * Task ID 1 marked as COMPLETED.
 * 
 * Task Scheduler Menu:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View Completed Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice: 2
 * --- Pending Tasks (Sorted by Priority) ---
 * [ID: 2, Priority: MEDIUM, Status: PENDING] Grade exams
 * -------------------------------------------
 * 
 * Task Scheduler Menu:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View Completed Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice: 3
 * --- Completed Tasks ---
 * [ID: 1, Priority: HIGH, Status: COMPLETED] Write exam question
 * -----------------------
 * 
 * Task Scheduler Menu:
 * 1. Add Task
 * 2. View Pending Tasks
 * 3. View Completed Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice: 4
 * Enter task ID to complete: 1
 * Error: Task with ID 1 is not currently pending or does not exist.
 * 
 * Task Scheduler Menu:
 * ...
 * Enter your choice: 6
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * 
 * Task Scheduler Menu:
 * ...
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number.
 * 
 * Task Scheduler Menu:
 * ...
 * Enter your choice: 5
 * Exiting Task Scheduler.
 * ```
 * 
 * **Evaluation:** Your solution will be evaluated based on correctness, adherence to requirements (including the use of all specified components), code quality, error handling, and overall design.
 *
 * EXPLANATION:
 * This solution implements the Priority Task Scheduler application, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Task Representation (`Task` class):**
 *     *   The `Task` class encapsulates the data for a single task (ID, description, priority, status).
 *     *   It uses private fields and public getters, adhering to encapsulation.
 *     *   `Priority` and `Status` are implemented as enums, providing type safety and readability.
 *     *   `toString()` is overridden for convenient printing of task details.
 *     *   `equals()` and `hashCode()` are overridden based on the unique `id`. This is crucial for methods like `Queue.remove()` to correctly identify and remove the intended task object from the queue based on its ID.
 * 
 * 2.  **Task Scheduler Logic (`TaskScheduler` class):**
 *     *   **Collections:**
 *         *   `pendingTasks`: A `Queue<Task>` implemented using `LinkedList`. This collection holds tasks that are waiting to be completed. `Queue` methods like `offer()` (add) and `remove()` are used.
 *         *   `completedTasks`: An `ArrayList<Task>` implementing the `List<Task>` interface. This stores tasks that have been marked as completed.
 *         *   `allTasks`: An `ArrayList<Task>` implementing the `List<Task>` interface. This list serves as a central registry of all tasks created, allowing lookup by ID regardless of their current status (pending or completed).
 *     *   **`addTask`:** Creates a new `Task` with a unique ID (incrementing `nextTaskId`), adds it to `allTasks`, and offers it to the `pendingTasks` queue.
 *     *   **`viewPendingTasks`:** Retrieves tasks from the `pendingTasks` queue. Since a standard `Queue` doesn't guarantee order, the tasks are copied into a temporary `ArrayList` and then sorted using a custom `Comparator` to order them by `Priority` (HIGH > MEDIUM > LOW) before being returned as a `List`. This fulfills the requirement of returning a `List` and demonstrates sorting.
 *     *   **`viewCompletedTasks`:** Simply returns a copy of the `completedTasks` `ArrayList` as a `List`.
 *     *   **`completeTask`:** Iterates through the `pendingTasks` queue to find the task by its ID. If found, it's removed from the queue using `queue.remove(taskToComplete)` (which relies on the overridden `equals`/`hashCode`), its status is updated, and it's added to `completedTasks`. It includes error handling:
 *         *   If the task is not found in the `pendingTasks` queue: it checks if the task ID exists at all in `allTasks`. Based on this check, it prints a specific error message using `System.err` indicating whether the task ID was invalid or if the task was already completed.
 *     *   Encapsulation is maintained with private fields and public methods.
 * 
 * 3.  **User Interface (`main` method in `TaskSchedulerApp`):**
 *     *   A `Scanner` is used to read input from `System.in`.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   A `switch` statement handles the different menu options provided to the user.
 *     *   **Input Validation:**
 *         *   The `try-catch (InputMismatchException)` around `scanner.nextInt()` handles cases where the user enters non-integer input for menu choices or task IDs.
 *         *   Validation is done for the task ID being positive.
 *         *   A loop and `try-catch (IllegalArgumentException)` are used to validate the priority input string against the `Priority` enum values.
 *         *   `scanner.nextLine()` is used appropriately after `scanner.nextInt()` to consume the leftover newline character.
 *     *   **Output:** `System.out.println()` is used for displaying the menu, task lists, and success messages. `System.err.println()` is used exclusively for error messages as required.
 *     *   **Exception Handling:**
 *         *   Specific `try-catch` blocks handle expected errors like `InputMismatchException` during input reading.
 *         *   A general `try-catch (Exception e)` block wraps the main `while` loop. This provides class-wide exception handling, catching any unexpected runtime errors that might occur during the application's execution and preventing the program from crashing abruptly. It prints an error message and the stack trace using `System.err`.
 *         *   A `finally` block ensures the `Scanner` is closed, releasing system resources.
 * 
 * 4.  **Best Practices:**
 *     *   Meaningful names (`pendingTasks`, `completeTask`, `viewPendingTasks`, `nextTaskId`, etc.) are used throughout the code.
 *     *   Comments and Javadoc are included for classes and methods, explaining their purpose and behavior.
 *     *   The code is structured into separate classes (`Task`, `TaskScheduler`, `TaskSchedulerApp`), promoting modularity and readability.
 * 
 * This solution effectively combines the required Java components within a practical scenario, demonstrating proper object-oriented design, collection usage, control flow, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Comparator;
import java.util.NoSuchElementException; // Specific exception for Scanner issues

// Enum for Task Priority
enum Priority {
    HIGH, MEDIUM, LOW
}

// Enum for Task Status
enum Status {
    PENDING, COMPLETED
}

// Represents a single task
class Task {
    private int id;
    private String description;
    private Priority priority;
    private Status status;

    public Task(int id, String description, Priority priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = Status.PENDING; // New tasks are always pending
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    // Setter for status (used when completing a task)
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Priority: " + priority + ", Status: " + status + "] " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id; // Equality based on unique ID
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

// Manages the collection of tasks
class TaskScheduler {
    private Queue<Task> pendingTasks;
    private List<Task> completedTasks; // Using ArrayList, which implements List
    private List<Task> allTasks; // Using ArrayList, which implements List
    private int nextTaskId;

    public TaskScheduler() {
        // Using LinkedList as a Queue implementation
        this.pendingTasks = new LinkedList<>();
        this.completedTasks = new ArrayList<>();
        this.allTasks = new ArrayList<>();
        this.nextTaskId = 1; // Start task IDs from 1
    }

    /**
     * Adds a new task to the scheduler.
     *
     * @param description The description of the task.
     * @param priority    The priority of the task.
     * @return The newly created Task object.
     */
    public Task addTask(String description, Priority priority) {
        Task newTask = new Task(nextTaskId++, description, priority);
        allTasks.add(newTask); // Keep track of all tasks
        pendingTasks.offer(newTask); // Add to the pending queue
        return newTask;
    }

    /**
     * Returns a list of pending tasks, sorted by priority (HIGH > MEDIUM > LOW).
     *
     * @return A List of pending Tasks.
     */
    public List<Task> viewPendingTasks() {
        // Convert queue to list for sorting
        List<Task> pendingList = new ArrayList<>(pendingTasks);

        // Sort by priority: HIGH first, then MEDIUM, then LOW
        pendingList.sort(Comparator.comparing(Task::getPriority, (p1, p2) -> {
            if (p1 == Priority.HIGH && p2 != Priority.HIGH) return -1;
            if (p1 == Priority.MEDIUM && p2 == Priority.LOW) return -1;
            if (p1 == p2) return 0;
            return 1; // p1 is lower priority than p2
        }));

        return pendingList;
    }

    /**
     * Returns a list of completed tasks.
     *
     * @return A List of completed Tasks.
     */
    public List<Task> viewCompletedTasks() {
        return new ArrayList<>(completedTasks); // Return a copy to prevent external modification
    }

    /**
     * Marks a pending task as completed.
     *
     * @param taskId The ID of the task to complete.
     * @return true if the task was successfully completed, false otherwise.
     */
    public boolean completeTask(int taskId) {
        // Find the task in the pending queue by iterating
        Task taskToComplete = null;
        for (Task task : pendingTasks) {
            if (task.getId() == taskId) {
                taskToComplete = task;
                break; // Found the task
            }
        }

        if (taskToComplete != null) {
            // Remove from pending queue
            pendingTasks.remove(taskToComplete); // Uses Task.equals() based on ID

            // Update status and move to completed list
            taskToComplete.setStatus(Status.COMPLETED);
            completedTasks.add(taskToComplete);
            return true; // Task successfully completed
        } else {
            // Check if the task exists at all (maybe already completed)
            boolean existsInAll = allTasks.stream().anyMatch(task -> task.getId() == taskId);
            if (existsInAll) {
                 // Task exists, but wasn't in pending queue
                 System.err.println("Error: Task with ID " + taskId + " is not currently pending (it might be completed or an invalid ID).");
            } else {
                 System.err.println("Error: Task with ID " + taskId + " not found.");
            }
            return false; // Task not found or not pending
        }
    }
}

public class TaskSchedulerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        boolean running = true;

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                printMenu();

                int choice = -1;
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                } catch (java.util.InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    continue; // Skip to the next loop iteration
                } catch (NoSuchElementException e) {
                     System.err.println("Error reading input. Exiting.");
                     running = false;
                     continue;
                }


                // Use switch statement for menu navigation
                switch (choice) {
                    case 1: // Add Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();

                        Priority priority = null;
                        while (priority == null) {
                            System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                            String priorityString = scanner.nextLine().trim().toUpperCase();
                            try {
                                priority = Priority.valueOf(priorityString);
                            } catch (IllegalArgumentException e) {
                                System.err.println("Error: Invalid priority. Please enter HIGH, MEDIUM, or LOW.");
                            }
                        }
                        Task newTask = scheduler.addTask(description, priority);
                        System.out.println("Task added with ID: " + newTask.getId());
                        break;

                    case 2: // View Pending Tasks
                        List<Task> pendingTasks = scheduler.viewPendingTasks();
                        System.out.println("--- Pending Tasks (Sorted by Priority) ---");
                        if (pendingTasks.isEmpty()) {
                            System.out.println("No pending tasks.");
                        } else {
                            for (Task task : pendingTasks) {
                                System.out.println(task);
                            }
                        }
                        System.out.println("-------------------------------------------");
                        break;

                    case 3: // View Completed Tasks
                        List<Task> completedTasks = scheduler.viewCompletedTasks();
                        System.out.println("--- Completed Tasks ---");
                        if (completedTasks.isEmpty()) {
                            System.out.println("No completed tasks.");
                        } else {
                            for (Task task : completedTasks) {
                                System.out.println(task);
                            }
                        }
                        System.out.println("-----------------------");
                        break;

                    case 4: // Complete Task
                        System.out.print("Enter task ID to complete: ");
                        int taskIdToComplete = -1;
                         try {
                            taskIdToComplete = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            if (taskIdToComplete <= 0) {
                                System.err.println("Error: Task ID must be a positive number.");
                                continue; // Skip to next iteration
                            }

                            boolean success = scheduler.completeTask(taskIdToComplete);
                            if (success) {
                                System.out.println("Task ID " + taskIdToComplete + " marked as COMPLETED.");
                            }
                            // Error message is printed inside completeTask method if it returns false

                         } catch (java.util.InputMismatchException e) {
                            System.err.println("Error: Invalid input. Please enter a valid task ID (a number).");
                            scanner.nextLine(); // Consume invalid input
                         }
                        break;

                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting Task Scheduler.");
                        break;

                    default: // Invalid choice
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                System.out.println(); // Add a blank line for readability
            }
        } catch (Exception e) {
            // General catch-all for unexpected errors
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("Task Scheduler Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. View Pending Tasks");
        System.out.println("3. View Completed Tasks");
        System.out.println("4. Complete Task");
        System.out.println("5. Exit");
    }
}
