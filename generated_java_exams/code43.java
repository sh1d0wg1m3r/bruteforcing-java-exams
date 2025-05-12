/*
 * Exam Question #43
 * Generated on: 2025-05-11 22:01:46
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Team Task Management System
 * 
 * **Objective:** Design and implement a simple console-based Task Management System for a small team. This system should allow users to add, view, and complete tasks, with special handling for high-priority tasks.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class to represent a single task. Each task should have:
 *     *   A unique integer ID (automatically generated).
 *     *   A description (String).
 *     *   A priority level (e.g., HIGH, MEDIUM, LOW). Use an `enum` for priority.
 *     *   A status indicating if it's completed (boolean).
 *     *   Implement appropriate constructors, getters, and a method to mark the task as completed. Override `toString()` for easy printing.
 * 
 * 2.  **Task Management Logic:** Create a `TaskManager` class that will manage collections of tasks. It must internally use:
 *     *   A `java.util.ArrayList` to store a master list of *all* tasks created.
 *     *   A `java.util.Queue` (specifically, use `java.util.LinkedList` as the implementation) to hold tasks marked as HIGH priority that are not yet completed.
 *     *   A `java.util.ArrayList` to store completed tasks.
 *     *   Ensure fields are private and accessed via public methods.
 * 
 * 3.  **User Interface:** Implement a console-based interface in the `main` method of the `TaskManager` class using `java.util.Scanner` for user input. The interface should present a menu with options:
 *     *   1. Add New Task
 *     *   2. Complete Task by ID
 *     *   3. View All Tasks
 *     *   4. View High Priority Queue
 *     *   5. View Completed Tasks
 *     *   6. Exit
 * 
 * 4.  **Functionality Details:**
 *     *   **Add Task:** Prompt for description and priority (accepting "HIGH", "MEDIUM", "LOW"). Create a `Task` object. Add it to the master list (`ArrayList`). If the priority is HIGH, also add it to the high-priority queue (`Queue`).
 *     *   **Complete Task:** Prompt for the Task ID. Find the task in the master list. If found and not already completed, mark it as completed using the `Task` object's method. Add the completed task to the completed tasks list (`ArrayList`). If the task was in the high-priority queue, remove it from the queue. Handle cases where the ID is not found or the task is already completed.
 *     *   **View All Tasks:** Display details of all tasks from the master list (`ArrayList`).
 *     *   **View High Priority Queue:** Display details of tasks currently in the high-priority queue (`Queue`). Do *not* remove elements from the queue when viewing.
 *     *   **View Completed Tasks:** Display details of tasks from the completed tasks list (`ArrayList`).
 * 
 * 5.  **Control Flow:** Use a `switch` statement in the main loop to handle the user's menu choice.
 * 
 * 6.  **Error Handling:**
 *     *   Use `System.err` to print error messages (e.g., invalid menu choice, task not found, invalid priority input, non-numeric input).
 *     *   Implement input validation for user inputs (e.g., ensuring numeric input where expected, valid priority string).
 *     *   Include class-wide exception handling by wrapping the main program loop (in the `main` method) with a `try-catch` block to catch potential unexpected exceptions.
 * 
 * 7.  **Best Practices:** Adhere to good coding practices, including:
 *     *   Proper encapsulation.
 *     *   Meaningful variable and method names.
 *     *   Basic comments explaining key parts.
 *     *   Clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively in the console, displaying the menu, prompting for input, and providing output (task details, confirmation messages, or error messages) based on user actions. Error messages should go to `System.err`. Successful operations and informational messages should go to `System.out`.
 * 
 * Example Interaction Snippet:
 * ```
 * --- Task Management Menu ---
 * 1. Add New Task
 * ... (menu options) ...
 * --------------------------
 * Enter your choice: 1
 * Enter task description: Fix bug in login
 * Enter priority (HIGH, MEDIUM, LOW): HIGH
 * Task added: Task [ID=1, Desc='Fix bug in login', Priority=HIGH, Completed=false]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 1
 * Enter task description: Write documentation
 * Enter priority (HIGH, MEDIUM, LOW): LOW
 * Task added: Task [ID=2, Desc='Write documentation', Priority=LOW, Completed=false]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 4
 * --- High Priority Tasks Queue ---
 * Task [ID=1, Desc='Fix bug in login', Priority=HIGH, Completed=false]
 * ---------------------------------
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * Enter Task ID to complete: 1
 * Task completed: Task [ID=1, Desc='Fix bug in login', Priority=HIGH, Completed=true]
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 4
 * --- High Priority Tasks Queue ---
 * High priority queue is empty.
 * ---------------------------------
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 5
 * --- Completed Tasks ---
 * Task [ID=1, Desc='Fix bug in login', Priority=HIGH, Completed=true]
 * -----------------------
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: abc
 * Invalid input. Please enter a number.
 * 
 * --- Task Management Menu ---
 * ...
 * Enter your choice: 2
 * Enter Task ID to complete: 99
 * Error: Task with ID 99 not found.
 * ```
 * 
 * Your solution should be a single `.java` file containing the `Task` class and the `TaskManager` class with the `main` method.
 *
 * EXPLANATION:
 * The provided solution implements a console-based Task Management System demonstrating the required Java concepts and best practices.
 * 
 * **Key Components and Concepts:**
 * 
 * 1.  **`Task` Class:**
 *     *   Represents individual tasks with `id`, `description`, `priority` (using an `enum`), and `isCompleted` status.
 *     *   A static counter `nextId` ensures unique IDs for each task instance.
 *     *   Includes standard getters and a `markCompleted` method for encapsulation.
 *     *   Overrides `toString()` for convenient display.
 *     *   Overrides `equals()` and `hashCode()` based on the task ID. This is crucial for correctly using methods like `Queue.remove(Object)` which rely on object equality.
 * 
 * 2.  **`TaskManager` Class:**
 *     *   Manages the collections of tasks: `allTasks` (`ArrayList` typed as `List`), `highPriorityQueue` (`LinkedList` typed as `Queue`), and `completedTasks` (`ArrayList` typed as `List`). Using the interface types (`List`, `Queue`) for the fields promotes good design practices, allowing for potential changes in the underlying implementation later without affecting the public interface.
 *     *   `addTask`: Creates a new `Task`, adds it to `allTasks`. If it's HIGH priority, it's also added to `highPriorityQueue` using `offer()`. Includes input validation for the description.
 *     *   `completeTask`: Finds the task by ID using a helper method `findTaskById`. Validates if the task exists and is not already completed. Marks the task as completed, adds it to `completedTasks`, and importantly, removes it from `highPriorityQueue` if it was there.
 *     *   `findTaskById`: A private helper method demonstrating linear search through the `allTasks` list.
 *     *   `getAllTasks`, `getHighPriorityTasks`, `getCompletedTasks`: Public methods to provide access to the task collections, returning the appropriate interface types (`List` or `Queue`). Note that returning the direct collection reference allows external modification, but for this exam scope, it fulfills the requirement. In a production system, returning copies or unmodifiable views might be preferred.
 * 
 * 3.  **`main` Method and User Interface:**
 *     *   Located within the `TaskManager` class as requested, serving as the application entry point.
 *     *   Uses `java.util.Scanner` to read user input from the console.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   `displayMenu()` is a helper method to print the options.
 *     *   A `switch` statement processes the user's numeric choice, directing execution to the relevant logic for adding, completing, or viewing tasks.
 * 
 * 4.  **Collection Usage:**
 *     *   `ArrayList`: Used for `allTasks` (master list) and `completedTasks`. `ArrayList` provides efficient random access and dynamic resizing, suitable for storing and iterating through all tasks or completed tasks.
 *     *   `Queue`: Used for `highPriorityQueue`, implemented by `LinkedList`. `Queue` methods like `offer()` (add to end) and `remove(Object)` (remove a specific element) are used. The enhanced `for` loop is used to iterate through the queue elements for viewing without removing them, respecting the queue's intended usage pattern while allowing inspection.
 * 
 * 5.  **Error Handling:**
 *     *   `System.err`: Used extensively to output error messages for invalid inputs (non-numeric choice/ID, invalid priority) or logical errors (task not found, task already completed).
 *     *   Input Validation: Input for menu choice and task ID is read as a `String` first, then parsed within a `try-catch` block catching `NumberFormatException`. Priority input is converted to uppercase and parsed as an `enum` value within a `try-catch` catching `IllegalArgumentException`. Empty task descriptions are checked explicitly.
 *     *   Class-wide `try-catch`: The entire `while` loop in `main` is wrapped in a `try-catch(Exception e)`. This demonstrates catching any unexpected runtime exceptions that might occur during the main execution flow, printing an error message to `System.err` and the stack trace for debugging. A `finally` block ensures the `Scanner` is closed.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation is maintained by keeping fields private and providing public methods for interaction.
 *     *   Variable and method names are descriptive (`addTask`, `highPriorityQueue`, `taskId`, etc.).
 *     *   Basic comments are included to explain the purpose of classes, methods, and key code blocks.
 *     *   Code is structured logically with separate classes for `Task` and `TaskManager`, and the `main` method handling the user interface interaction.
 * 
 * This solution effectively combines the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, demonstrating understanding of data structures, object-oriented principles, user input handling, and robust error management.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException; // Although reading line first handles this better

// Class representing a single task
class Task {
    private static int nextId = 1; // Static counter for unique IDs
    private int id;
    private String description;
    private Priority priority;
    private boolean isCompleted;

    // Enum for task priority levels
    enum Priority {
        HIGH, MEDIUM, LOW
    }

    // Constructor
    public Task(String description, Priority priority) {
        this.id = nextId++; // Assign unique ID and increment counter
        this.description = description;
        this.priority = priority;
        this.isCompleted = false; // Tasks start as not completed
    }

    // Getters for task properties
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Method to mark the task as completed
    public void markCompleted() {
        this.isCompleted = true;
    }

    // Override toString() for easy printing of task details
    @Override
    public String toString() {
        return "Task [ID=" + id + ", Desc='" + description + "', Priority=" + priority + ", Completed=" + isCompleted + "]";
    }

    // Override equals() and hashCode() - good practice when objects are stored in collections and might be searched/removed
    // Needed specifically for Queue.remove(Object) to work correctly based on Task ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id; // Tasks are equal if their IDs are the same
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

// Class managing collections of tasks and operations
public class TaskManager {
    // Private fields using required collection types and interfaces
    private List<Task> allTasks; // Master list of all tasks (using List interface, implemented by ArrayList)
    private Queue<Task> highPriorityQueue; // Queue for high priority tasks (using Queue interface, implemented by LinkedList)
    private List<Task> completedTasks; // List for completed tasks (using List interface, implemented by ArrayList)

    // Constructor
    public TaskManager() {
        this.allTasks = new ArrayList<>();
        this.highPriorityQueue = new LinkedList<>(); // LinkedList implements Queue
        this.completedTasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the system.
     * @param description The task description.
     * @param priority The task priority.
     */
    public void addTask(String description, Task.Priority priority) {
        // Input validation: check if description is null or empty
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Task description cannot be empty.");
            return; // Exit method if validation fails
        }

        Task newTask = new Task(description.trim(), priority); // Create new Task object
        allTasks.add(newTask); // Add to the master list

        // If priority is HIGH, add to the high priority queue
        if (priority == Task.Priority.HIGH) {
            highPriorityQueue.offer(newTask); // offer() is preferred over add() for queues
        }

        System.out.println("Task added: " + newTask.toString());
    }

    /**
     * Marks a task as completed given its ID.
     * @param taskId The ID of the task to complete.
     */
    public void completeTask(int taskId) {
        Task taskToComplete = findTaskById(taskId); // Find the task by ID

        // Handle case where task is not found
        if (taskToComplete == null) {
            System.err.println("Error: Task with ID " + taskId + " not found.");
            return;
        }

        // Handle case where task is already completed
        if (taskToComplete.isCompleted()) {
            System.err.println("Error: Task with ID " + taskId + " is already completed.");
            return;
        }

        taskToComplete.markCompleted(); // Mark the task as completed
        completedTasks.add(taskToComplete); // Add to the completed tasks list

        // If the task was high priority, remove it from the queue
        if (taskToComplete.getPriority() == Task.Priority.HIGH) {
             highPriorityQueue.remove(taskToComplete); // Remove the specific Task object from the queue
        }

        System.out.println("Task completed: " + taskToComplete.toString());
    }

    /**
     * Helper method to find a task by its ID in the master list.
     * @param taskId The ID to search for.
     * @return The Task object if found, otherwise null.
     */
    private Task findTaskById(int taskId) {
        // Iterate through the master list to find the task
        for (Task task : allTasks) {
            if (task.getId() == taskId) {
                return task; // Return the task if ID matches
            }
        }
        return null; // Return null if no task with the given ID is found
    }

    // Public methods to access task collections (returning interface types)

    /**
     * Returns the master list of all tasks.
     * @return A List containing all tasks.
     */
    public List<Task> getAllTasks() {
        return allTasks; // Return the internal list
    }

    /**
     * Returns the queue of high priority tasks.
     * @return A Queue containing high priority tasks.
     */
    public Queue<Task> getHighPriorityTasks() {
        return highPriorityQueue; // Return the internal queue
    }

    /**
     * Returns the list of completed tasks.
     * @return A List containing completed tasks.
     */
    public List<Task> getCompletedTasks() {
        return completedTasks; // Return the internal list
    }

    // Main method for program execution and user interaction
    public static void main(String[] args) {
        TaskManager manager = new TaskManager(); // Create a TaskManager instance
        Scanner scanner = new Scanner(System.in); // Create a Scanner for input
        boolean running = true; // Flag to keep the program running

        // Class-wide exception handling: Wrap the main execution loop
        try {
            while (running) { // Main program loop
                displayMenu(); // Display the menu
                System.out.print("Enter your choice: ");
                String choiceInput = scanner.nextLine(); // Read user input as a line

                int choice = -1; // Default value for invalid choice
                try {
                    // Attempt to parse the input string to an integer
                    choice = Integer.parseInt(choiceInput);
                } catch (NumberFormatException e) {
                    // Handle non-numeric input gracefully
                    System.err.println("Invalid input. Please enter a number.");
                    continue; // Skip the rest of the loop body and show menu again
                }

                // Switch statement to handle different menu options
                switch (choice) {
                    case 1: // Add New Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                        String priorityString = scanner.nextLine().toUpperCase(); // Read priority and convert to uppercase

                        try {
                            // Attempt to convert the input string to a Priority enum
                            Task.Priority priority = Task.Priority.valueOf(priorityString);
                            manager.addTask(description, priority); // Call TaskManager method to add task
                        } catch (IllegalArgumentException e) {
                            // Handle invalid priority string input
                            System.err.println("Invalid priority entered. Please use HIGH, MEDIUM, or LOW.");
                        }
                        break; // End of case 1

                    case 2: // Complete Task by ID
                        System.out.print("Enter Task ID to complete: ");
                        String taskIdInput = scanner.nextLine(); // Read Task ID input as a line

                        try {
                            // Attempt to parse the Task ID input string to an integer
                            int taskId = Integer.parseInt(taskIdInput);
                            manager.completeTask(taskId); // Call TaskManager method to complete task
                        } catch (NumberFormatException e) {
                            // Handle non-numeric Task ID input
                            System.err.println("Invalid Task ID. Please enter a number.");
                        }
                        break; // End of case 2

                    case 3: // View All Tasks
                        System.out.println("\n--- All Tasks ---");
                        List<Task> all = manager.getAllTasks(); // Get the list of all tasks
                        if (all.isEmpty()) {
                            System.out.println("No tasks available.");
                        } else {
                            // Iterate and print each task
                            for (Task task : all) {
                                System.out.println(task);
                            }
                        }
                        System.out.println("-----------------");
                        break; // End of case 3

                    case 4: // View High Priority Queue
                         System.out.println("\n--- High Priority Tasks Queue ---");
                         Queue<Task> highPriority = manager.getHighPriorityTasks(); // Get the high priority queue
                         if (highPriority.isEmpty()) {
                             System.out.println("High priority queue is empty.");
                         } else {
                             // Iterate through the queue without removing elements (using enhanced for loop)
                             for (Task task : highPriority) {
                                 System.out.println(task);
                             }
                         }
                         System.out.println("---------------------------------");
                         break; // End of case 4

                    case 5: // View Completed Tasks
                         System.out.println("\n--- Completed Tasks ---");
                         List<Task> completed = manager.getCompletedTasks(); // Get the list of completed tasks
                         if (completed.isEmpty()) {
                             System.out.println("No tasks completed yet.");
                         } else {
                             // Iterate and print each completed task
                             for (Task task : completed) {
                                 System.out.println(task);
                             }
                         }
                         System.out.println("-----------------------");
                         break; // End of case 5

                    case 6: // Exit
                        System.out.println("Exiting Task Management System. Goodbye!");
                        running = false; // Set running flag to false to exit the loop
                        break; // End of case 6

                    default:
                        // Handle invalid menu choices (numbers outside 1-6)
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                }
                System.out.println(); // Print a newline for better readability between menu cycles
            }
        } catch (Exception e) {
            // Class-wide catch block for any unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to standard error
        } finally {
            // Ensure the scanner is closed when the program exits or encounters an error
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Displays the main menu options to the console.
     */
    private static void displayMenu() {
        System.out.println("--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. Complete Task by ID");
        System.out.println("3. View All Tasks");
        System.out.println("4. View High Priority Queue");
        System.out.println("5. View Completed Tasks");
        System.out.println("6. Exit");
        System.out.println("--------------------------");
    }
}
