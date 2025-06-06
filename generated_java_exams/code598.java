/*
 * Exam Question #598
 * Generated on: 2025-05-12 16:12:51
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam: Project Task Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simple Project Task Management system. The system should allow users to define tasks, track their status, and manage dependencies between tasks. Tasks can only be processed if all their dependencies are completed. The system will maintain a list of all defined tasks and a separate queue of tasks that are ready to be processed (i.e., their dependencies are met and they are pending).
 * 
 * **Requirements:**
 * 
 * 1.  **Task Representation:**
 *     *   Create a `Task` class with the following attributes:
 *         *   `id` (String): Unique identifier for the task (e.g., "T1", "T2").
 *         *   `description` (String): A brief description of the task.
 *         *   `priority` (int): An integer representing priority (e.g., 1 for high, 5 for low).
 *         *   `status` (enum `TaskStatus`): The current status of the task (e.g., `PENDING`, `IN_PROGRESS`, `COMPLETED`).
 *         *   `dependencies` (`List<String>`): A list of task IDs that must be completed before this task can be processed.
 *     *   Implement proper encapsulation (private fields, public getters/setters where necessary).
 *     *   Include a constructor to initialize tasks.
 *     *   Add a method `isReadyToProcess(List<Task> allTasks)` that checks if the task's status is `PENDING` and all its dependencies are marked as `COMPLETED` in the provided list of all tasks.
 * 
 * 2.  **Task Management System:**
 *     *   Create a `ProjectScheduler` class to manage the tasks.
 *     *   This class must contain:
 *         *   A `List<Task>` to store all tasks defined in the system. Use `ArrayList` as the concrete implementation.
 *         *   A `Queue<Task>` to store tasks that are currently ready to be processed (status is `PENDING` and dependencies met). Use `LinkedList` or `ArrayDeque` as the concrete implementation for the `Queue`.
 *     *   Implement the following methods in `ProjectScheduler`:
 *         *   `addTask(Task task)`: Adds a new task to the list of all tasks.
 *         *   `viewAllTasks()`: Prints details of all tasks currently in the system.
 *         *   `processReadyTasks()`:
 *             *   This method should check all `PENDING` tasks in the `List<Task>`.
 *             *   For each pending task, call its `isReadyToProcess` method.
 *             *   If a task is ready, add it to the `Queue<Task>`.
 *             *   Then, process tasks from the `Queue`:
 *                 *   Dequeue a task.
 *                 *   Change its status from `PENDING` to `IN_PROGRESS`, print a message.
 *                 *   Immediately change its status from `IN_PROGRESS` to `COMPLETED`, print a message. (Simulating quick processing for the exam).
 *             *   After processing all tasks initially in the queue, check *all* tasks again to see if any *new* tasks have become ready due to completions and add them to the queue for potential processing in the *next* call to this method (or add them and process immediately if time permits, but checking and adding is sufficient for this requirement).
 *         *   `findTaskById(String taskId)`: A helper method to find a task in the `List<Task>` by its ID. Return the `Task` object or `null` if not found.
 * 
 * 3.  **User Interaction:**
 *     *   In the `main` method (or a separate class like `SchedulerApp`), create a `ProjectScheduler` instance.
 *     *   Use `Scanner` to get user input from the console.
 *     *   Implement a command-line interface with a menu using a `switch` statement:
 *         *   `add`: Prompt for task ID, description, priority, and comma-separated dependency IDs. Create a `Task` object and add it using `scheduler.addTask()`.
 *         *   `view`: Call `scheduler.viewAllTasks()`.
 *         *   `process`: Call `scheduler.processReadyTasks()`.
 *         *   `exit`: Terminate the program.
 *     *   Handle invalid commands gracefully.
 * 
 * 4.  **Error Handling & Output:**
 *     *   Use `System.out.println()` for normal program output (menu, task details, success messages).
 *     *   Use `System.err.println()` for error messages (e.g., invalid input format, task not found when specifying dependencies, non-numeric priority).
 *     *   Implement class-wide exception handling using `try-catch` blocks, particularly around user input processing (e.g., `Scanner` operations, parsing integers).
 * 
 * 5.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Add comments to explain complex logic.
 *     *   Ensure proper input validation (e.g., priority is a number, dependencies exist).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu. User interactions should lead to tasks being added, viewed, and processed according to dependencies. Error messages should be printed to standard error.
 * 
 * ```
 * Project Task Scheduler Menu:
 * 1. Add Task
 * 2. View All Tasks
 * 3. Process Ready Tasks
 * 4. Exit
 * Enter command (add, view, process, exit):
 * ```
 * 
 * (Example interaction - user adds tasks, views, processes)
 * 
 * ```
 * Enter command (add, view, process, exit): add
 * Enter Task ID: T1
 * Enter Description: Write report
 * Enter Priority (1-5): 3
 * Enter Dependency IDs (comma-separated, or none): none
 * Task T1 added.
 * 
 * Enter command (add, view, process, exit): add
 * Enter Task ID: T2
 * Enter Description: Review report
 * Enter Priority (1-5): 2
 * Enter Dependency IDs (comma-separated, or none): T1
 * Task T2 added.
 * 
 * Enter command (add, view, process, exit): view
 * --- All Tasks ---
 * ID: T1, Desc: Write report, Pri: 3, Status: PENDING, Deps: []
 * ID: T2, Desc: Review report, Pri: 2, Status: PENDING, Deps: [T1]
 * --- End of Tasks ---
 * 
 * Enter command (add, view, process, exit): process
 * Checking for ready tasks...
 * Task T1 is ready. Adding to queue.
 * Processing queue...
 * Processing Task: T1 (Write report) - Status: IN_PROGRESS
 * Processing Task: T1 (Write report) - Status: COMPLETED
 * Queue empty. Checking for newly ready tasks...
 * Task T2 is now ready.
 * Process cycle complete.
 * 
 * Enter command (add, view, process, exit): view
 * --- All Tasks ---
 * ID: T1, Desc: Write report, Pri: 3, Status: COMPLETED, Deps: []
 * ID: T2, Desc: Review report, Pri: 2, Status: PENDING, Deps: [T1] // Note: T2 is ready, but will be processed on the *next* 'process' call based on the logic described.
 * --- End of Tasks ---
 * 
 * Enter command (add, view, process, exit): process
 * Checking for ready tasks...
 * Task T2 is ready. Adding to queue.
 * Processing queue...
 * Processing Task: T2 (Review report) - Status: IN_PROGRESS
 * Processing Task: T2 (Review report) - Status: COMPLETED
 * Queue empty. Checking for newly ready tasks...
 * Process cycle complete.
 * 
 * Enter command (add, view, process, exit): exit
 * Exiting scheduler.
 * ```
 * 
 * **Constraint Checklist:**
 * 
 * 1.  Queue (java.util.Queue): YES
 * 2.  ArrayList (java.util.ArrayList): YES
 * 3.  List interface (java.util.List): YES
 * 4.  Scanner for user input (java.util.Scanner): YES
 * 5.  Switch statement for flow control: YES
 * 6.  System.err for error messages: YES
 * 7.  System.out for normal output: YES
 * 8.  Class-wide exception handling with try-catch blocks: YES
 * 
 * This task requires you to integrate multiple core Java concepts to build a functional system. Pay close attention to data structures, object-oriented design, input handling, and error management.
 *
 * EXPLANATION:
 * This solution implements a simple Project Task Management system demonstrating the required Java concepts.
 * 
 * 1.  **Task Class:**
 *     *   Defines the structure for a task with `id`, `description`, `priority`, `status` (using an `enum`), and a `List<String>` for `dependencies`.
 *     *   Uses private fields and public getters for encapsulation. A public setter is provided for `status` as it needs to be changed by the scheduler.
 *     *   The `isReadyToProcess` method is crucial. It checks if the task is currently `PENDING` and then iterates through its list of dependency IDs. For each dependency ID, it finds the corresponding `Task` object in the provided list of *all* tasks and verifies that its status is `COMPLETED`. It uses a helper `findTaskById` method within the `Task` class for this lookup.
 * 
 * 2.  **ProjectScheduler Class:**
 *     *   Acts as the central manager.
 *     *   It holds an `ArrayList<Task>` named `allTasks` to keep track of every task ever added. `ArrayList` is suitable here for storing and iterating over a dynamic collection of tasks.
 *     *   It holds a `Queue<Task>` named `readyQueue` (implemented using `LinkedList`) to manage tasks that are eligible to be processed. The `Queue` interface and its implementations are ideal for FIFO (First-In, First-Out) processing order, which is typical for task queues. `offer()` is used to add to the queue, and `poll()` is used to retrieve and remove the head.
 *     *   `addTask`: Adds a new task to `allTasks` after performing basic validation (checking for duplicate IDs and ensuring dependency IDs exist in the system).
 *     *   `viewAllTasks`: Iterates through `allTasks` and prints their details.
 *     *   `processReadyTasks`: This method orchestrates the core logic:
 *         *   It first iterates through `allTasks` to find any `PENDING` tasks that are now `isReadyToProcess` and adds them to the `readyQueue`. It checks if the task is already in the queue to avoid duplicates if the method is called repeatedly.
 *         *   It then enters a loop that continues as long as the `readyQueue` is not empty. In each iteration, it `poll`s a task, simulates processing by changing its status to `IN_PROGRESS` and then immediately to `COMPLETED`.
 *         *   After processing the queue, it performs another check of all tasks to see if any new tasks have become ready *because* tasks were just completed. This informs the user which tasks will be added to the queue in the *next* processing cycle.
 * 
 * 3.  **SchedulerApp (Main Class):**
 *     *   Contains the `main` method where execution begins.
 *     *   Creates a `ProjectScheduler` and a `Scanner` for user input.
 *     *   Implements a main loop that continues until the user chooses to exit.
 *     *   A `switch` statement is used to handle different user commands (`add`, `view`, `process`, `exit`). This fulfills the requirement for using a switch statement for flow control based on user input.
 *     *   **User Input and Validation:** The `add` case prompts for task details. It uses `Integer.parseInt` to convert the priority input to an integer and includes a `try-catch` block specifically for `NumberFormatException` and `InputMismatchException` to handle non-numeric or out-of-range priority input, printing errors to `System.err`. Dependency IDs are read as a comma-separated string and split into a `List<String>`.
 *     *   **Error Handling:** A `try-catch(Exception e)` block wraps the main `switch` statement. This provides a class-wide mechanism to catch any unexpected exceptions that might occur during the command processing loop, printing an error message to `System.err`. Specific error messages (like unknown command, task not found, dependency not found) are also printed to `System.err`.
 *     *   `System.out.println()` is used for the menu, prompts, successful additions, task listings, and processing messages, adhering to the requirement for normal output.
 * 
 * 4.  **Best Practices:**
 *     *   Meaningful names (`Task`, `ProjectScheduler`, `allTasks`, `readyQueue`, `processReadyTasks`, `isReadyToProcess`).
 *     *   Comments explain the purpose of classes, methods, and key logic sections.
 *     *   Input validation is present for task ID (non-empty), priority (numeric and range), and dependency existence.
 *     *   Encapsulation is used in the `Task` class.
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical, object-oriented structure to solve the problem of managing and processing tasks with dependencies.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

// Enum for task status
enum TaskStatus {
    PENDING, IN_PROGRESS, COMPLETED
}

// Represents a single task
class Task {
    private String id;
    private String description;
    private int priority;
    private TaskStatus status;
    private List<String> dependencies; // List of task IDs

    // Constructor
    public Task(String id, String description, int priority, List<String> dependencies) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = TaskStatus.PENDING; // New tasks start as PENDING
        this.dependencies = dependencies;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public List<String> getDependencies() {
        return dependencies;
    }

    // Setter for status (used internally by scheduler)
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    /**
     * Checks if this task is ready to be processed.
     * A task is ready if its status is PENDING and all its dependencies are COMPLETED.
     *
     * @param allTasks The list of all tasks in the system to check dependencies against.
     * @return true if the task is ready for processing, false otherwise.
     */
    public boolean isReadyToProcess(List<Task> allTasks) {
        if (this.status != TaskStatus.PENDING) {
            return false; // Only PENDING tasks can be ready
        }

        if (this.dependencies == null || this.dependencies.isEmpty()) {
            return true; // No dependencies, so ready if PENDING
        }

        // Check if all dependencies are completed
        for (String depId : this.dependencies) {
            Task dependencyTask = findTaskById(depId, allTasks);
            if (dependencyTask == null) {
                // This case indicates an invalid dependency ID was added.
                // For this problem, we might treat this as "not ready" or
                // ideally, validate dependencies on add. Assuming validation
                // happens or we treat missing as "not completed".
                System.err.println("Error: Dependency task ID '" + depId + "' not found for task '" + this.id + "'.");
                return false; // Dependency not found or not completed
            }
            if (dependencyTask.getStatus() != TaskStatus.COMPLETED) {
                return false; // Dependency is not yet completed
            }
        }

        return true; // All dependencies are completed and status is PENDING
    }

    // Helper method to find a task by ID within a list
    private Task findTaskById(String taskId, List<Task> allTasks) {
        for (Task task : allTasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null; // Task not found
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Desc: %s, Pri: %d, Status: %s, Deps: %s",
                id, description, priority, status, dependencies);
    }
}

// Manages the collection of tasks and the processing queue
class ProjectScheduler {
    private List<Task> allTasks;
    private Queue<Task> readyQueue;

    // Constructor
    public ProjectScheduler() {
        this.allTasks = new ArrayList<>(); // Use ArrayList for all tasks
        this.readyQueue = new LinkedList<>(); // Use LinkedList for the queue
    }

    /**
     * Adds a new task to the scheduler.
     * Performs basic validation, including checking if dependency IDs exist.
     *
     * @param task The task to add.
     */
    public void addTask(Task task) {
        // Basic validation: Check for duplicate ID
        if (findTaskById(task.getId()) != null) {
            System.err.println("Error: Task with ID '" + task.getId() + "' already exists.");
            return;
        }

        // Validate dependencies exist
        if (task.getDependencies() != null) {
            for (String depId : task.getDependencies()) {
                if (findTaskById(depId) == null) {
                    System.err.println("Error: Dependency task ID '" + depId + "' not found for task '" + task.getId() + "'. Task not added.");
                    return; // Prevent adding task with non-existent dependency
                }
            }
        }

        this.allTasks.add(task);
        System.out.println("Task " + task.getId() + " added.");
    }

    /**
     * Prints details of all tasks in the system.
     */
    public void viewAllTasks() {
        System.out.println("--- All Tasks ---");
        if (allTasks.isEmpty()) {
            System.out.println("No tasks defined yet.");
        } else {
            for (Task task : allTasks) {
                System.out.println(task);
            }
        }
        System.out.println("--- End of Tasks ---");
    }

    /**
     * Identifies tasks ready for processing and processes them from the queue.
     */
    public void processReadyTasks() {
        System.out.println("Checking for ready tasks...");

        // First pass: Identify and add newly ready PENDING tasks to the queue
        // Iterate through all tasks to find those that became ready since last check
        for (Task task : allTasks) {
            if (task.getStatus() == TaskStatus.PENDING && !readyQueue.contains(task) && task.isReadyToProcess(allTasks)) {
                 // Check if already in queue to avoid duplicates if processReadyTasks is called multiple times
                readyQueue.offer(task); // Add to the end of the queue
                System.out.println("Task " + task.getId() + " is ready. Adding to queue.");
            }
        }

        System.out.println("Processing queue...");
        if (readyQueue.isEmpty()) {
            System.out.println("No tasks in the ready queue.");
        } else {
            // Process tasks currently in the queue
            while (!readyQueue.isEmpty()) {
                Task taskToProcess = readyQueue.poll(); // Get and remove the head of the queue

                // Simulate processing
                System.out.println("Processing Task: " + taskToProcess.getId() + " (" + taskToProcess.getDescription() + ") - Status: IN_PROGRESS");
                taskToProcess.setStatus(TaskStatus.IN_PROGRESS);

                // Simulate completion immediately after starting
                System.out.println("Processing Task: " + taskToProcess.getId() + " (" + taskToProcess.getDescription() + ") - Status: COMPLETED");
                taskToProcess.setStatus(TaskStatus.COMPLETED);
            }
            System.out.println("Queue empty.");
        }

        // Second pass (optional but good): Re-check if any *new* tasks became ready
        // due to the just-completed tasks. These will be processed in the *next*
        // call to processReadyTasks or could be added to queue now depending on desired behavior.
        // The current logic adds them to the queue in the *next* check phase.
        System.out.println("Checking for newly ready tasks...");
        boolean foundNewlyReady = false;
         for (Task task : allTasks) {
            if (task.getStatus() == TaskStatus.PENDING && task.isReadyToProcess(allTasks)) {
                // If a task is now ready but wasn't processed (because it wasn't added to the queue yet)
                // This message indicates it *will* be added in the next process cycle's first pass.
                 if (!readyQueue.contains(task)) { // Only mention if not already queued for next round
                     System.out.println("Task " + task.getId() + " is now ready.");
                     foundNewlyReady = true;
                 }
            }
        }
        if(!foundNewlyReady && readyQueue.isEmpty() && allTasks.stream().anyMatch(t -> t.getStatus() == TaskStatus.PENDING)){
             System.out.println("No new tasks became ready in this cycle.");
        }


        System.out.println("Process cycle complete.");
    }


    /**
     * Helper method to find a task by ID in the list of all tasks.
     *
     * @param taskId The ID of the task to find.
     * @return The Task object or null if not found.
     */
    private Task findTaskById(String taskId) {
        for (Task task : allTasks) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null; // Task not found
    }
}

// Main class to run the application
public class SchedulerApp {

    public static void main(String[] args) {
        ProjectScheduler scheduler = new ProjectScheduler();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Project Task Scheduler Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. Process Ready Tasks");
        System.out.println("4. Exit");

        boolean running = true;
        while (running) {
            System.out.print("Enter command (add, view, process, exit): ");
            String command = scanner.nextLine().trim().toLowerCase();

            try { // Class-wide exception handling for the main loop commands

                switch (command) {
                    case "add":
                        System.out.print("Enter Task ID: ");
                        String id = scanner.nextLine().trim();

                        // Basic ID validation
                        if (id.isEmpty()) {
                             System.err.println("Error: Task ID cannot be empty.");
                             break;
                        }

                        System.out.print("Enter Description: ");
                        String description = scanner.nextLine().trim();

                        int priority = -1;
                        System.out.print("Enter Priority (1-5): ");
                        try {
                            priority = Integer.parseInt(scanner.nextLine().trim());
                            if (priority < 1 || priority > 5) {
                                throw new InputMismatchException("Priority must be between 1 and 5.");
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid priority format. Please enter a number.");
                            break; // Exit case, loop continues
                        } catch (InputMismatchException e) {
                             System.err.println("Error: " + e.getMessage());
                             break; // Exit case, loop continues
                        }


                        System.out.print("Enter Dependency IDs (comma-separated, or none): ");
                        String depInput = scanner.nextLine().trim();
                        List<String> dependencies = new ArrayList<>();
                        if (!depInput.equalsIgnoreCase("none") && !depInput.isEmpty()) {
                            dependencies = new ArrayList<>(Arrays.asList(depInput.split(",")));
                            // Trim whitespace from each dependency ID
                            dependencies.replaceAll(String::trim);
                        }

                        Task newTask = new Task(id, description, priority, dependencies);
                        scheduler.addTask(newTask);
                        break;

                    case "view":
                        scheduler.viewAllTasks();
                        break;

                    case "process":
                        scheduler.processReadyTasks();
                        break;

                    case "exit":
                        System.out.println("Exiting scheduler.");
                        running = false;
                        break;

                    default:
                        System.err.println("Error: Unknown command. Please use 'add', 'view', 'process', or 'exit'.");
                        break;
                }

            } catch (Exception e) {
                // Catch any unexpected exceptions during command processing
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for detailed debugging
            }
        }

        scanner.close();
    }
}
