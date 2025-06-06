/*
 * Exam Question #1046
 * Generated on: 2025-05-12 17:17:21
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Priority Task Scheduler
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line based Priority Task Scheduler. The system should allow users to add new tasks with descriptions and priority levels, view existing tasks, and mark tasks as completed. The scheduler should manage tasks efficiently, using appropriate data structures to simulate a real-world workflow where some high-priority tasks might be immediately ready for processing.
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:** Create a `Task` class with attributes: `id` (unique integer, auto-generated), `description` (String), `priority` (enum: `LOW`, `MEDIUM`, `HIGH`), and `status` (enum: `PENDING`, `COMPLETED`).
 * 2.  **Priority Levels:** Define an enum `Priority` with constants `LOW`, `MEDIUM`, `HIGH`.
 * 3.  **Task Status:** Define an enum `TaskStatus` with constants `PENDING`, `COMPLETED`.
 * 4.  **Task Management:** Create a `TaskScheduler` class responsible for managing tasks.
 *     *   It must use a `List<Task>` (implemented with `ArrayList`) to store *all* tasks added to the system.
 *     *   It must use a `Queue<Task>` (implemented with a suitable `Queue` implementation like `LinkedList`) to hold a small number of *high-priority pending* tasks that are "ready for immediate attention". Let's say the queue has a maximum capacity (e.g., 3).
 *     *   Implement methods:
 *         *   `addTask(String description, Priority priority)`: Adds a new task with a unique ID. If the priority is `HIGH` and the "ready queue" is not full, add the task to both the `List` and the `Queue`. Otherwise, just add it to the `List`. Return the newly created `Task`.
 *         *   `viewAllTasks()`: Returns the `List` of all tasks.
 *         *   `viewReadyTasks()`: Returns a `List` containing tasks currently in the "ready queue".
 *         *   `completeTask(int taskId)`: Finds the task by ID. If found and `PENDING`, mark its status as `COMPLETED`. If the task was in the "ready queue", remove it from the queue. Return `true` if completion was successful, `false` otherwise (e.g., task not found, already completed).
 * 5.  **User Interface:** Implement a command-line interface in a `main` method.
 *     *   Use `Scanner` to get user input.
 *     *   Display a menu with options: Add Task, View All Tasks, View Ready Tasks, Complete Task, Exit.
 *     *   Use a `switch` statement to handle menu selection.
 *     *   Implement input validation (e.g., for priority, task ID).
 * 6.  **Error Handling:**
 *     *   Use `try-catch` blocks to handle potential exceptions (e.g., `InputMismatchException` for invalid number input, custom exceptions for business logic errors if you choose to implement them, or simply return `false`/print errors). A broad `try-catch` around the main interaction loop is required.
 *     *   Use `System.err` to print error messages (e.g., invalid menu choice, invalid task ID, task not found/already completed).
 *     *   Use `System.out` for the menu, prompts, and successful operation messages/task listings.
 * 7.  **Best Practices:**
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (JavaDocs).
 *     *   Clean code structure (separate classes for Task, Scheduler, App).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept user input, perform the requested operations, and display results or error messages. Task lists should be printed clearly.
 * 
 * ```
 * --- Task Scheduler Menu ---
 * 1. Add New Task
 * 2. View All Tasks
 * 3. View Ready Tasks
 * 4. Complete Task
 * 5. Exit
 * Enter your choice:
 * ```
 * 
 * (Example interaction)
 * 
 * ```
 * Enter task description: Write report
 * Enter priority (LOW, MEDIUM, HIGH): HIGH
 * Task added: ID=1, Description=Write report, Priority=HIGH, Status=PENDING
 * 
 * --- Task Scheduler Menu ---
 * ...
 * Enter your choice: 3
 * Ready Tasks:
 * [ID=1, Description=Write report, Priority=HIGH, Status=PENDING]
 * 
 * --- Task Scheduler Menu ---
 * ...
 * Enter your choice: 1
 * Enter task description: Prepare presentation
 * Enter priority (LOW, MEDIUM, HIGH): MEDIUM
 * Task added: ID=2, Description=Prepare presentation, Priority=MEDIUM, Status=PENDING
 * 
 * --- Task Scheduler Menu ---
 * ...
 * Enter your choice: 2
 * All Tasks:
 * [ID=1, Description=Write report, Priority=HIGH, Status=PENDING]
 * [ID=2, Description=Prepare presentation, Priority=MEDIUM, Status=PENDING]
 * 
 * --- Task Scheduler Menu ---
 * ...
 * Enter your choice: 4
 * Enter task ID to complete: 1
 * Task ID 1 completed successfully.
 * 
 * --- Task Scheduler Menu ---
 * ...
 * Enter your choice: 3
 * Ready Tasks:
 * []
 * 
 * --- Task Scheduler Menu ---
 * ...
 * Enter your choice: 4
 * Enter task ID to complete: 1
 * System.err: Error: Task with ID 1 not found or already completed.
 * 
 * --- Task Scheduler Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Task Scheduler.
 * ```
 * 
 * **Constraints:**
 * 
 * *   Use `java.util.Queue`, `java.util.ArrayList`, `java.util.List`, `java.util.Scanner`, `switch`, `System.err`, `System.out`, and class-wide `try-catch` as specified.
 * *   The "ready queue" should have a small, fixed capacity (e.g., 3).
 *
 * EXPLANATION:
 * This solution implements the Priority Task Scheduler as requested, utilizing all the required Java components and following best practices.
 * 
 * 1.  **`Task` Class:** This class is a simple Plain Old Java Object (POJO) representing a task. It has private fields (`id`, `description`, `priority`, `status`) demonstrating encapsulation. Static `nextId` ensures unique IDs for each task. Getters and a setter for status are provided. `toString()`, `equals()`, and `hashCode()` are overridden for convenient printing and comparison, although `equals`/`hashCode` are primarily based on the unique `id`.
 * 
 * 2.  **`Priority` and `TaskStatus` Enums:** These enums define the possible states for task priority and completion status, making the code more readable and preventing invalid string inputs for these attributes.
 * 
 * 3.  **`TaskScheduler` Class:** This is the core class managing the tasks.
 *     *   **`List<Task> allTasks = new ArrayList<>();`**: An `ArrayList` is used, declared with the `List` interface type. This list holds *all* tasks ever added to the system. `ArrayList` is suitable here for storing a dynamic collection where elements might be added and accessed by index or iterated over.
 *     *   **`Queue<Task> readyTasksQueue = new LinkedList<>();`**: A `LinkedList` is used, declared with the `Queue` interface type. This queue specifically holds `HIGH` priority tasks that are considered "ready for immediate attention". `LinkedList` is a common implementation for `Queue` in `java.util`. The queue has a fixed capacity (`READY_QUEUE_CAPACITY`) to simulate a limited pool of tasks being actively focused on.
 *     *   **`addTask(String description, Priority priority)`**: Creates a new `Task`. It's always added to `allTasks`. If the priority is `HIGH` and the `readyTasksQueue` is not full, the task is also added to the queue using `offer()`. `offer()` is generally preferred over `add()` for queues as it returns `false` if the element cannot be added (relevant for bounded queues), whereas `add()` might throw an exception.
 *     *   **`viewAllTasks()`**: Returns the `allTasks` list. `Collections.unmodifiableList()` is used as a best practice to prevent external code from modifying the internal list directly.
 *     *   **`viewReadyTasks()`**: Returns a new `ArrayList` populated with the elements from the `readyTasksQueue`. This effectively gives a snapshot of the queue's contents without exposing the queue object itself.
 *     *   **`completeTask(int taskId)`**: This method demonstrates interaction between the `List` and the `Queue`. It first attempts to find the task in the `readyTasksQueue` using an `Iterator`. If found and pending, it's removed from the queue using `iterator.remove()`. It then searches `allTasks` to find the task (necessary if it wasn't in the queue or if we need to verify its status/update it in the main list). If the task is found and its status is `PENDING`, its status is updated to `COMPLETED`. It returns `true` on success and `false` if the task isn't found or is already completed.
 * 
 * 4.  **`TaskSchedulerApp` Class (`main` method):**
 *     *   **`Scanner scanner = new Scanner(System.in);`**: Used to read input from the console.
 *     *   **`try-catch` Block:** A large `try-catch` block wraps the main `while` loop. This provides class-wide exception handling, catching any unexpected errors during the program's execution and printing an error message and stack trace to `System.err`. A `finally` block ensures the `Scanner` is closed.
 *     *   **Menu and `switch`:** A `while` loop keeps the application running until the user chooses to exit. Inside the loop, `printMenu()` displays options. User input is read using `scanner.nextInt()` for the choice, followed by `scanner.nextLine()` to consume the leftover newline character (a common pitfall with `Scanner`). A `switch` statement directs the program flow based on the user's numeric choice.
 *     *   **Input Validation and `System.err`:**
 *         *   Within the `switch` cases, `try-catch` blocks handle specific input issues, like `InputMismatchException` when the user enters non-numeric input where a number is expected (e.g., for menu choice or task ID).
 *         *   When adding a task, a loop validates the priority input against the `Priority` enum using `Priority.valueOf()` and catches `IllegalArgumentException` if the input doesn't match.
 *         *   Error messages for invalid input, invalid choices, or failed operations (like completing a non-existent task) are printed to `System.err` to distinguish them from normal program output.
 *     *   **`System.out`:** Used for printing the menu, prompts, successful operation messages, and task listings.
 * 
 * This solution demonstrates the required components working together in a practical context. The `List` stores the complete record, the `Queue` provides a specific view/workflow for high-priority items, the `Scanner` and `switch` handle user interaction, and `try-catch` with `System.err` provides robust error handling. Encapsulation, clear naming, and comments contribute to code quality.
 */

import java.util.*;

// Enum for Task Priority
enum Priority {
    LOW, MEDIUM, HIGH
}

// Enum for Task Status
enum TaskStatus {
    PENDING, COMPLETED
}

// Represents a single Task
class Task {
    private int id;
    private String description;
    private Priority priority;
    private TaskStatus status;

    // Static counter for unique task IDs
    private static int nextId = 1;

    /**
     * Constructs a new Task.
     * @param description The task description.
     * @param priority The task priority.
     */
    public Task(String description, Priority priority) {
        this.id = nextId++;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING;
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    // --- Setter for Status ---
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "[ID=" + id + ", Description=" + description + ", Priority=" + priority + ", Status=" + status + "]";
    }

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

// Manages the collection of tasks
class TaskScheduler {
    private List<Task> allTasks;
    private Queue<Task> readyTasksQueue; // Queue for high-priority tasks ready for attention
    private final int READY_QUEUE_CAPACITY = 3; // Fixed capacity for the ready queue

    /**
     * Constructs a new TaskScheduler.
     */
    public TaskScheduler() {
        // Use ArrayList for the main list of all tasks
        this.allTasks = new ArrayList<>();
        // Use LinkedList as the Queue implementation for ready tasks
        this.readyTasksQueue = new LinkedList<>();
    }

    /**
     * Adds a new task to the scheduler.
     * If the task is HIGH priority and the ready queue is not full,
     * it's also added to the ready queue.
     * @param description The task description.
     * @param priority The task priority.
     * @return The newly created Task.
     */
    public Task addTask(String description, Priority priority) {
        Task newTask = new Task(description, priority);
        allTasks.add(newTask); // Always add to the main list

        // If high priority and queue has space, add to ready queue
        if (priority == Priority.HIGH && readyTasksQueue.size() < READY_QUEUE_CAPACITY) {
            readyTasksQueue.offer(newTask); // offer() is safer than add() for bounded queues (though LinkedList isn't strictly bounded, good practice)
        }

        return newTask;
    }

    /**
     * Returns an unmodifiable list of all tasks.
     * @return A List of all tasks.
     */
    public List<Task> viewAllTasks() {
        // Return a copy or unmodifiable list to prevent external modification
        return Collections.unmodifiableList(allTasks);
    }

    /**
     * Returns a list of tasks currently in the ready queue.
     * @return A List of tasks in the ready queue.
     */
    public List<Task> viewReadyTasks() {
        // Convert queue to list for viewing
        return new ArrayList<>(readyTasksQueue);
    }

    /**
     * Completes a task by its ID.
     * Removes the task from the ready queue if it was there.
     * @param taskId The ID of the task to complete.
     * @return true if the task was found and completed, false otherwise.
     */
    public boolean completeTask(int taskId) {
        Task taskToComplete = null;

        // First, check if the task is in the ready queue (more efficient for these tasks)
        // We need to iterate to find by ID, as Queue doesn't have direct get(id)
        Iterator<Task> queueIterator = readyTasksQueue.iterator();
        while (queueIterator.hasNext()) {
            Task task = queueIterator.next();
            if (task.getId() == taskId) {
                taskToComplete = task;
                // Remove from queue immediately if found and pending
                if (task.getStatus() == TaskStatus.PENDING) {
                     queueIterator.remove(); // Safely remove using iterator
                }
                break; // Found it, no need to continue queue iteration
            }
        }

        // If not found in queue or if it was found but already completed in queue,
        // search the main list. This also handles tasks that were never in the queue.
        if (taskToComplete == null || taskToComplete.getStatus() != TaskStatus.PENDING) {
             for (Task task : allTasks) {
                if (task.getId() == taskId) {
                    taskToComplete = task;
                    break; // Found in main list
                }
            }
        }


        // Process completion if task was found and is pending
        if (taskToComplete != null && taskToComplete.getStatus() == TaskStatus.PENDING) {
            taskToComplete.setStatus(TaskStatus.COMPLETED);
            // If it was in the queue, we already removed it via iterator.
            // If it wasn't in the queue, no need to remove from queue.
            return true; // Successfully completed
        } else {
            return false; // Task not found or already completed
        }
    }

    /**
     * Finds a task by its ID in the allTasks list.
     * (Helper method, not strictly required by prompt but useful)
     */
    private Task findTaskById(int taskId) {
         for (Task task : allTasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null; // Not found
    }
}

// Main application class
public class TaskSchedulerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        // Class-wide exception handling for the main loop
        try {
            boolean running = true;
            while (running) {
                printMenu();
                System.out.print("Enter your choice: ");

                int choice = -1;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input line
                    continue; // Skip to the next loop iteration
                }

                // Use a switch statement for menu navigation
                switch (choice) {
                    case 1: // Add New Task
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();

                        Priority priority = null;
                        while (priority == null) {
                            System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
                            String priorityString = scanner.nextLine().trim().toUpperCase();
                            try {
                                priority = Priority.valueOf(priorityString);
                            } catch (IllegalArgumentException e) {
                                System.err.println("Invalid priority. Please enter LOW, MEDIUM, or HIGH.");
                            }
                        }

                        Task addedTask = scheduler.addTask(description, priority);
                        System.out.println("Task added: " + addedTask);
                        break;

                    case 2: // View All Tasks
                        List<Task> allTasks = scheduler.viewAllTasks();
                        System.out.println("\n--- All Tasks ---");
                        if (allTasks.isEmpty()) {
                            System.out.println("No tasks added yet.");
                        } else {
                            for (Task task : allTasks) {
                                System.out.println(task);
                            }
                        }
                        System.out.println("-----------------");
                        break;

                    case 3: // View Ready Tasks
                        List<Task> readyTasks = scheduler.viewReadyTasks();
                        System.out.println("\n--- Ready Tasks (High Priority, Immediate Attention) ---");
                        if (readyTasks.isEmpty()) {
                            System.out.println("No tasks currently ready for attention.");
                        } else {
                             for (Task task : readyTasks) {
                                System.out.println(task);
                            }
                        }
                         System.out.println("-------------------------------------------------------");
                        break;

                    case 4: // Complete Task
                        System.out.print("Enter task ID to complete: ");
                        int taskIdToComplete = -1;
                         try {
                            taskIdToComplete = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                        } catch (InputMismatchException e) {
                            System.err.println("Invalid input. Please enter a valid task ID (number).");
                            scanner.nextLine(); // Consume the invalid input line
                            continue; // Skip to the next loop iteration
                        }

                        boolean completed = scheduler.completeTask(taskIdToComplete);
                        if (completed) {
                            System.out.println("Task ID " + taskIdToComplete + " completed successfully.");
                        } else {
                            System.err.println("Error: Task with ID " + taskIdToComplete + " not found or already completed.");
                        }
                        break;

                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting Task Scheduler.");
                        break;

                    default: // Invalid choice
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
                System.out.println(); // Add a newline for spacing
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions at the top level
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed
            scanner.close();
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Task Scheduler Menu ---");
        System.out.println("1. Add New Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. View Ready Tasks");
        System.out.println("4. Complete Task");
        System.out.println("5. Exit");
    }
}
