/*
 * Exam Question #1018
 * Generated on: 2025-05-12 17:13:31
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Task Management System
 * 
 * **Scenario:**
 * 
 * You are developing a simple command-line Task Management System for a small team. The system needs to keep track of tasks, allowing users to add new tasks, view all tasks, identify the next task to work on, mark tasks as complete, and remove tasks. Each task has a unique ID, a description, a priority level (High, Medium, Low), and a status (Pending, Completed).
 * 
 * The system uses two main data structures: a comprehensive list containing all tasks created, and a queue representing tasks that are currently pending and ready for processing. When a task is added, it is placed in both the master list and the processing queue. When a task is marked complete or removed, it should be updated in the master list and also removed from the processing queue if it was still there.
 * 
 * Your solution must be a single Java file and demonstrate a solid understanding of core Java concepts, including collections, enums, exception handling, and basic I/O.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use `java.util.List` (specifically `java.util.ArrayList`) to store *all* tasks in the system.
 *     *   Use `java.util.Queue` (specifically `java.util.LinkedList` which implements `Queue`) to manage tasks that are pending and ready for processing (FIFO order for tasks entering the queue).
 * 
 * 2.  **Classes and Enums:**
 *     *   Create a `Task` class with private fields: `id` (int, unique, auto-generated), `description` (String), `priority` (enum), and `status` (enum). Include a constructor, public getters, and a `markComplete()` method. Override `equals()` and `hashCode()` based on the unique task ID to facilitate removal from collections.
 *     *   Create a `Priority` enum (HIGH, MEDIUM, LOW).
 *     *   Create a `Status` enum (PENDING, COMPLETED).
 *     *   Create a `TaskManager` class to encapsulate the task list and processing queue. This class should contain the methods for managing tasks.
 *     *   Create a main application class (`TaskManagementApp`) with the `main` method to handle user interaction.
 * 
 * 3.  **TaskManager Methods:**
 *     *   `addTask(String description, Priority priority)`: Creates a new `Task`, adds it to the main task list and the processing queue.
 *     *   `listAllTasks()`: Prints details of all tasks in the main list.
 *     *   `processNextTask()`: Peeks at (views without removing) the task at the head of the processing queue and prints its details. Print a message if the queue is empty.
 *     *   `markTaskComplete(int taskId)`: Finds the task by ID, updates its status to `COMPLETED`, and removes it from the processing queue if present. Must handle the case where the task ID is not found.
 *     *   `removeTask(int taskId)`: Finds the task by ID, removes it from the main task list, and removes it from the processing queue if present. Must handle the case where the task ID is not found.
 *     *   `listPendingQueue()`: Prints details of all tasks currently in the processing queue.
 * 
 * 4.  **User Interface:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Implement a command-line menu loop in the `main` method with options corresponding to the `TaskManager` methods (Add, List All, Process Next, Mark Complete, Remove, List Pending Queue, Exit).
 *     *   Use a `switch` statement to handle the menu choices.
 * 
 * 5.  **Error Handling:**
 *     *   Implement a custom exception, `TaskNotFoundException`, for cases where a requested task ID does not exist.
 *     *   Use `try-catch` blocks in the `main` method to handle potential exceptions, including `TaskNotFoundException`, `NumberFormatException` (for invalid integer input), and potentially `IllegalArgumentException` (for invalid enum input).
 *     *   Print error messages to `System.err`.
 *     *   Print normal output (menu, prompts, task details, success messages) to `System.out`.
 * 
 * 6.  **Best Practices:**
 *     *   Employ proper encapsulation (private fields, public methods/getters).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for methods).
 *     *   Perform basic input validation (e.g., for priority string).
 *     *   Ensure resources like `Scanner` are properly closed.
 *     *   Structure the code cleanly within the single file (e.g., using static nested classes for Task, Enums, TaskManager).
 * 
 * **Expected Output:**
 * 
 * The program should display a menu and respond to user input by performing the requested task operations. Output should be clear and informative, using `System.out` for normal flow and `System.err` for errors. Refer to the example interaction flow provided in the thought process for a general idea of the expected user experience.
 * 
 * ```
 * --- Task Management Menu ---
 * 1. Add New Task
 * 2. List All Tasks
 * 3. Process Next Task (Queue)
 * 4. Mark Task Complete
 * 5. Remove Task
 * 6. List Pending Queue
 * 7. Exit
 * Enter your choice: <user input>
 * ... (system output or error)
 * ```
 *
 * EXPLANATION:
 * The provided solution implements a simple Task Management System adhering to all specified requirements.
 * 
 * 1.  **Data Structures (`Queue`, `ArrayList`, `List`):**
 *     *   `TaskManager` uses `private List<Task> allTasks = new ArrayList<>();` to store all tasks ever created. `ArrayList` is a concrete implementation of the `List` interface, fulfilling both `List` and `ArrayList` requirements.
 *     *   `TaskManager` uses `private Queue<Task> pendingProcessingQueue = new LinkedList<>();` to store tasks that are currently considered pending and ready for processing. `LinkedList` implements the `Queue` interface, satisfying the `Queue` requirement. Tasks are added to this queue when created and removed when marked complete or removed from the system.
 * 
 * 2.  **Classes and Enums:**
 *     *   `TaskNotFoundException`: A custom checked exception is defined to signal when a task ID provided by the user does not correspond to any existing task.
 *     *   `Priority` and `Status`: These are implemented as `enum` types, providing type-safe constant values for task priority and status.
 *     *   `Task`: This class encapsulates task data (`id`, `description`, `priority`, `status`). It includes a static counter (`nextId`) to ensure unique IDs for each new task. The `markComplete()` method changes the task's status. Crucially, `equals()` and `hashCode()` are overridden based on the unique `id`. This is essential because methods like `List.remove(Object)` and `Queue.remove(Object)` rely on the `equals()` method to find and remove the correct object instance.
 *     *   `TaskManager`: This class holds the `allTasks` list and `pendingProcessingQueue`. It contains methods (`addTask`, `listAllTasks`, `processNextTask`, `markTaskComplete`, `removeTask`, `listPendingQueue`) that operate on these collections, encapsulating the system's core logic. A private helper method `findTaskById` is used internally.
 *     *   `TaskManagementApp`: This is the main class containing the `main` method. It initializes the `Scanner` and `TaskManager`, runs the main application loop, displays the menu, reads user input, and directs the flow based on the user's choice.
 * 
 * 3.  **TaskManager Methods:**
 *     *   Each method in `TaskManager` performs its specific function as described, interacting with `allTasks` and `pendingProcessingQueue`. `addTask` uses `offer` to add to the queue. `processNextTask` uses `peek` to view the head of the queue without removing it. `markTaskComplete` and `removeTask` use the `remove(Object)` method of `LinkedList` and `ArrayList` respectively, leveraging the overridden `equals()` method in `Task`.
 * 
 * 4.  **User Interface (`Scanner`, `switch`):**
 *     *   A `Scanner` is used in `main` to read input from `System.in`. `scanner.nextLine()` is used consistently after both string and integer inputs to consume the newline character, preventing input issues.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   A `switch` statement branches the execution based on the integer choice entered by the user, calling the corresponding `TaskManager` method.
 * 
 * 5.  **Error Handling (`System.err`, `try-catch`):**
 *     *   A broad `try-catch` block wraps the core logic inside the `while` loop in `main`. This provides "class-wide" exception handling for the main application flow.
 *     *   Specific `catch` blocks handle `NumberFormatException` (for invalid integer input when reading choices or task IDs), `TaskNotFoundException` (thrown by `TaskManager` methods), and a general `Exception` for any other unexpected errors.
 *     *   Error messages are printed to `System.err`, while normal output and prompts go to `System.out`.
 *     *   Input validation for `Priority` is done using `Priority.valueOf()`, catching the `IllegalArgumentException` if the input string doesn't match an enum constant.
 * 
 * 6.  **Best Practices:**
 *     *   Fields in `Task` and `TaskManager` are `private`, accessed via `public` methods where necessary, ensuring encapsulation.
 *     *   Method and variable names are descriptive (e.g., `pendingProcessingQueue`, `markTaskComplete`, `findTaskById`).
 *     *   Basic Javadoc comments explain the purpose of classes and public methods.
 *     *   Input validation for numbers and enums is included.
 *     *   The `Scanner` resource is closed using `scanner.close()` when the main loop finishes.
 *     *   The code is structured within a single file using `static` nested classes for `TaskNotFoundException`, `Priority`, `Status`, `Task`, and `TaskManager`, which is a common approach for self-contained exam solutions.
 * 
 * This solution effectively demonstrates the required Java components and concepts within a practical, well-structured, and error-handled application.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Objects; // Required for Objects.equals/hashCode in Java 7+

public class TaskManagementApp {

    // Custom exception for task not found
    static class TaskNotFoundException extends Exception {
        public TaskNotFoundException(String message) {
            super(message);
        }
    }

    // Enum for task priority
    enum Priority {
        HIGH, MEDIUM, LOW
    }

    // Enum for task status
    enum Status {
        PENDING, COMPLETED
    }

    // Task class definition
    static class Task {
        private static int nextId = 1;
        private int id;
        private String description;
        private Priority priority;
        private Status status;

        public Task(String description, Priority priority) {
            this.id = nextId++;
            this.description = description;
            this.priority = priority;
            this.status = Status.PENDING;
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

        // Method to mark task as complete
        public void markComplete() {
            this.status = Status.COMPLETED;
        }

        @Override
        public String toString() {
            return "[Task ID: " + id + ", Desc: " + description + ", Priority: " + priority + ", Status: " + status + "]";
        }

        // Override equals and hashCode for reliable removal from Queue/List by object reference
        // Based on ID as it's unique
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Task task = (Task) o;
            return id == task.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    // TaskManager class definition
    static class TaskManager {
        private List<Task> allTasks;
        private Queue<Task> pendingProcessingQueue;

        public TaskManager() {
            this.allTasks = new ArrayList<>();
            this.pendingProcessingQueue = new LinkedList<>(); // Use LinkedList as a Queue
        }

        /**
         * Adds a new task to the system.
         * @param description The task description.
         * @param priority The task priority.
         */
        public void addTask(String description, Priority priority) {
            Task newTask = new Task(description, priority);
            allTasks.add(newTask);
            // Add to queue for processing.
            pendingProcessingQueue.offer(newTask); // offer is preferred over add for capacity-constrained queues, but works fine here
            System.out.println("Task added with ID: " + newTask.getId());
        }

        /**
         * Lists all tasks currently in the system.
         */
        public void listAllTasks() {
            if (allTasks.isEmpty()) {
                System.out.println("No tasks in the system.");
                return;
            }
            System.out.println("All Tasks:");
            for (Task task : allTasks) {
                System.out.println(task);
            }
        }

        /**
         * Peeks at the next task in the processing queue without removing it.
         */
        public void processNextTask() {
            Task nextTask = pendingProcessingQueue.peek();
            if (nextTask == null) {
                System.out.println("No tasks in the pending processing queue.");
            } else {
                System.out.println("Next task to process: " + nextTask);
            }
        }

        /**
         * Marks a task as complete by its ID and removes it from the processing queue.
         * @param taskId The ID of the task to mark complete.
         * @throws TaskNotFoundException if the task ID is not found.
         */
        public void markTaskComplete(int taskId) throws TaskNotFoundException {
            Task taskToComplete = findTaskById(taskId);

            if (taskToComplete == null) {
                throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
            }

            if (taskToComplete.getStatus() == Status.COMPLETED) {
                System.out.println("Task " + taskId + " is already completed.");
                return;
            }

            taskToComplete.markComplete();
            // Remove from the processing queue if it was there.
            // LinkedList.remove(Object) uses the equals() method to find the element.
            boolean removedFromQueue = pendingProcessingQueue.remove(taskToComplete);
            if (removedFromQueue) {
                 System.out.println("Task " + taskId + " marked as COMPLETE and removed from pending queue.");
            } else {
                 System.out.println("Task " + taskId + " marked as COMPLETE (was not in pending queue).");
            }
        }

        /**
         * Removes a task from the system by its ID.
         * @param taskId The ID of the task to remove.
         * @throws TaskNotFoundException if the task ID is not found.
         */
        public void removeTask(int taskId) throws TaskNotFoundException {
            Task taskToRemove = findTaskById(taskId);

            if (taskToRemove == null) {
                throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
            }

            // Remove from all tasks list. ArrayList.remove(Object) uses equals().
            allTasks.remove(taskToRemove);

            // Remove from the processing queue if it was there.
            pendingProcessingQueue.remove(taskToRemove);

            System.out.println("Task " + taskId + " removed.");
        }

        /**
         * Lists tasks currently in the pending processing queue.
         */
        public void listPendingQueue() {
            if (pendingProcessingQueue.isEmpty()) {
                System.out.println("Pending processing queue is empty.");
                return;
            }
            System.out.println("Pending Tasks Queue:");
            // Iterate through the queue without removing elements
            for (Task task : pendingProcessingQueue) {
                System.out.println(task);
            }
        }

        /**
         * Helper method to find a task by its ID in the allTasks list.
         * @param taskId The ID to search for.
         * @return The Task object if found, otherwise null.
         */
        private Task findTaskById(int taskId) {
            // Linear search is necessary as we are using a List
            for (Task task : allTasks) {
                if (task.getId() == taskId) {
                    return task;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        boolean running = true;

        while (running) {
            printMenu();

            // Use a single try-catch block around the core logic for class-wide handling
            try {
                System.out.print("Enter your choice: ");
                // Read the entire line to avoid issues with nextInt() and subsequent nextLine()
                String choiceString = scanner.nextLine();
                int choice = Integer.parseInt(choiceString); // This can throw NumberFormatException

                switch (choice) {
                    case 1: // Add New Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter priority (HIGH, MEDIUM, LOW): ");
                        String priorityString = scanner.nextLine().trim().toUpperCase();
                        try {
                            Priority priority = Priority.valueOf(priorityString);
                            taskManager.addTask(description, priority);
                        } catch (IllegalArgumentException e) {
                            // Specific catch for invalid priority string
                            System.err.println("Error: Invalid priority entered. Please use HIGH, MEDIUM, or LOW.");
                        }
                        break;

                    case 2: // List All Tasks
                        taskManager.listAllTasks();
                        break;

                    case 3: // Process Next Task (Queue)
                        taskManager.processNextTask();
                        break;

                    case 4: // Mark Task Complete
                        System.out.print("Enter Task ID to mark complete: ");
                        String completeIdString = scanner.nextLine();
                        int completeTaskId = Integer.parseInt(completeIdString); // Can throw NumberFormatException
                        taskManager.markTaskComplete(completeTaskId); // Can throw TaskNotFoundException
                        break;

                    case 5: // Remove Task
                        System.out.print("Enter Task ID to remove: ");
                        String removeIdString = scanner.nextLine();
                        int removeTaskId = Integer.parseInt(removeIdString); // Can throw NumberFormatException
                        taskManager.removeTask(removeTaskId); // Can throw TaskNotFoundException
                        break;

                    case 6: // List Pending Queue
                        taskManager.listPendingQueue();
                        break;

                    case 7: // Exit
                        running = false;
                        System.out.println("Exiting Task Management System.");
                        break;

                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (NumberFormatException e) {
                // Handle invalid integer input for menu choice or task ID
                System.err.println("Error: Invalid input. Please enter a valid number.");
            } catch (TaskNotFoundException e) {
                // Handle specific task not found errors from TaskManager methods
                System.err.println("Error: " + e.getMessage());
            } catch (Exception e) {
                // Catch any other unexpected errors during the loop iteration
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for detailed debugging stack trace
            }
            System.out.println(); // Add a blank line for readability between interactions
        }

        scanner.close(); // Close the scanner resource when done
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Task Management Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. List All Tasks");
        System.out.println("3. Process Next Task (Queue)");
        System.out.println("4. Mark Task Complete");
        System.out.println("5. Remove Task");
        System.out.println("6. List Pending Queue");
        System.out.println("7. Exit");
    }
}
