/*
 * Exam Question #1001
 * Generated on: 2025-05-12 17:11:12
 * Generated by: Account 2
 * 
 * QUESTION:
 * **Java Programming Exam Task: Production Line Simulation**
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified simulation of a multi-stage production line. Items (Tasks) enter the line, pass through a sequence of distinct processing stages (e.g., Assembly, Quality Control, Packaging), and finally exit as completed products.
 * 
 * The system needs to manage tasks waiting in a buffer between stages and tasks currently being processed at a specific active stage.
 * 
 * **Functionality:**
 * 
 * Your program should provide a command-line interface allowing the user to:
 * 
 * 1.  **Add a new Task:** Introduce a new item into the production line. Initially, tasks are ready for the first stage.
 * 2.  **Set Active Stage:** Choose which stage of the production line is currently operational. When a stage becomes active, any tasks waiting in the inter-stage buffer that are ready for this stage are moved to a dedicated processing area for this stage.
 * 3.  **Process Task at Active Stage:** Select a specific task from the active stage's processing area by its ID and simulate its processing. After processing, the task becomes ready for the next stage or is marked as completed if it was the last stage. Processed tasks are moved back to the inter-stage buffer (if more stages remain) or to a completed list.
 * 4.  **View Production Status:** Display the current active stage, the number of tasks waiting in the inter-stage buffer, the tasks currently at the active stage's processing area, and a list of completed tasks.
 * 5.  **Exit:** Terminate the program.
 * 
 * **Implementation Requirements:**
 * 
 * 1.  **Task Class:** Create a `Task` class to represent an item on the production line. It should encapsulate properties like a unique ID, name, and the index of the *next* stage it is ready for.
 * 2.  **ProductionLineManager Class:** Create a `ProductionLineManager` class to manage the production line state. It must contain:
 *     *   A `Queue<Task>` to represent the inter-stage buffer where tasks wait between stages.
 *     *   A `List<Task>` (implemented by `ArrayList`) to hold tasks currently at the active stage's processing area.
 *     *   A `List<Task>` (implemented by `ArrayList`) to store tasks that have completed all stages.
 *     *   A defined sequence of stage names (e.g., using a `List<String>`).
 *     *   An integer representing the index of the currently active stage.
 * 3.  **Main Program Flow:**
 *     *   Use `java.util.Scanner` to read user commands and input.
 *     *   Implement the main command loop using a `switch` statement to handle different user actions.
 *     *   Use `System.out` for displaying menus, status information, and successful operation messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, task not found, queue empty).
 *     *   Implement class-wide exception handling using a `try-catch` block wrapping the main operational loop to catch unexpected errors and print them to `System.err`.
 * 4.  **Best Practices:**
 *     *   Employ proper encapsulation (private fields, public getter/setter methods where necessary).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and Javadoc documentation.
 *     *   Perform input validation (e.g., check for valid stage indices, positive task IDs, non-empty names).
 *     *   Handle cases like processing an empty queue or trying to process a non-existent task gracefully using error messages via `System.err`.
 * 
 * **Production Stages:**
 * 
 * Define the stages as: "Assembly", "Quality Check", "Packaging". Tasks start ready for "Assembly" (index 0).
 * 
 * **Expected Output:**
 * 
 * *   A menu of options should be displayed.
 * *   Status updates should show the current active stage, buffer size, tasks at the active stage, and completed tasks list.
 * *   Error messages should be informative and printed to standard error.
 * *   Successful operations should be confirmed via standard output.
 * 
 * **Example Interaction Snippet (Illustrative):**
 * 
 * ```
 * Production Line Menu:
 * 1. Add Task
 * 2. Set Active Stage
 * 3. Process Task at Active Stage
 * 4. View Status
 * 5. Exit
 * Enter command: 1
 * Enter Task ID: 101
 * Enter Task Name: Widget A
 * Task 101 (Widget A) added, ready for Assembly.
 * 
 * Enter command: 4
 * --- Production Status ---
 * Active Stage: Not Set
 * Inter-Stage Buffer: 1 task(s)
 * Tasks at Active Stage: 0 task(s)
 * Completed Tasks: 0 task(s)
 * -------------------------
 * 
 * Enter command: 2
 * Available Stages:
 * 0: Assembly
 * 1: Quality Check
 * 2: Packaging
 * Enter stage index to activate: 0
 * Active stage set to: Assembly.
 * Moved 1 task(s) from buffer to Assembly processing area.
 * 
 * Enter command: 4
 * --- Production Status ---
 * Active Stage: Assembly
 * Inter-Stage Buffer: 0 task(s)
 * Tasks at Active Stage: 1 task(s) [Task ID: 101, Name: Widget A, Ready for Stage: Assembly]
 * Completed Tasks: 0 task(s)
 * -------------------------
 * 
 * Enter command: 3
 * Enter Task ID to process at Assembly: 101
 * Processing Task 101 (Widget A) at Assembly.
 * Task 101 processed at Assembly, now ready for Quality Check.
 * 
 * Enter command: 4
 * --- Production Status ---
 * Active Stage: Assembly
 * Inter-Stage Buffer: 1 task(s)
 * Tasks at Active Stage: 0 task(s)
 * Completed Tasks: 0 task(s)
 * -------------------------
 * ```
 *
 * EXPLANATION:
 * The solution implements a simple production line simulation demonstrating the required Java concepts.
 * 
 * 1.  **Task Class:** A simple class `Task` encapsulates the data for each item: `id`, `name`, and `readyForStageIndex`. The `readyForStageIndex` tracks which stage the task is waiting to enter next. It provides standard getters and a method `advanceStage()` to increment the index when a stage is completed.
 * 
 * 2.  **ProductionLineManager Class:** This is the core class managing the simulation state.
 *     *   `interStageBuffer`: A `Queue<Task>` (implemented using `LinkedList`) acts as a buffer for tasks that have completed a stage and are waiting to be moved to the *next* appropriate processing area. New tasks are initially added here, ready for the first stage (index 0).
 *     *   `currentStationProcessingArea`: A `List<Task>` (implemented using `ArrayList`) holds tasks that have been moved from the buffer and are now available for processing at the `activeStageIndex`. Using a `List` here allows easy iteration and removal by finding the task by ID, even though the conceptual flow might be FIFO within the buffer.
 *     *   `completedTasks`: A `List<Task>` (implemented using `ArrayList`) stores tasks that have successfully passed through all defined stages.
 *     *   `stageSequence`: An `ArrayList<String>` defines the names and order of the production stages.
 *     *   `activeStageIndex`: An integer tracking which stage index is currently active for processing.
 * 
 *     *   **Methods:**
 *         *   `addTask`: Creates a new `Task` and adds it to the `interStageBuffer`. Includes validation for ID and name, and checks for duplicate IDs across all collections.
 *         *   `setActiveStage`: Takes a stage index, validates it, sets `activeStageIndex`, clears the `currentStationProcessingArea`, and iterates through the `interStageBuffer` to move tasks that are ready for the newly active stage into the `currentStationProcessingArea`. It uses an `Iterator` to safely remove elements from the queue while iterating.
 *         *   `processTaskAtActiveStage`: Takes a task ID, finds the task in the `currentStationProcessingArea`, removes it, increments its `readyForStageIndex`. If the task has completed all stages (`readyForStageIndex` equals or exceeds the number of stages), it's moved to `completedTasks`. Otherwise, it's added back to the `interStageBuffer` to await being moved to the next stage's processing area when that stage becomes active. Includes checks if a stage is active and if the task exists in the current processing area.
 *         *   `viewStatus`: Prints the state of the simulation, including the active stage, the size and contents of the buffer and processing area, and the list of completed tasks.
 *         *   Helper methods like `findTaskById`, `getStageName`, `getActiveStageName`, and `displayStages` support the main logic and status display.
 * 
 * 3.  **ProductionLineSimulation (Main Class):**
 *     *   The `main` method contains the program's entry point and main loop.
 *     *   It initializes the `ProductionLineManager` and `Scanner`.
 *     *   A `while(running)` loop keeps the program active until the user chooses to exit.
 *     *   A `switch` statement handles the user's command input, directing execution to the appropriate `ProductionLineManager` method or control logic.
 *     *   **Class-wide Exception Handling:** A `try-catch (Exception e)` block wraps the entire `while` loop. This ensures that *any* unhandled exception occurring within the command processing loop or the manager methods will be caught at this top level, preventing the program from crashing and printing an error message (including stack trace for debugging) to `System.err`.
 *     *   **Input Validation and Error Handling:** Specific `try-catch` blocks are also used within the `switch` cases (e.g., for `NumberFormatException` during integer parsing) to handle anticipated errors gracefully and print user-friendly messages to `System.err`. `IllegalArgumentException` and `IllegalStateException` are thrown by `ProductionLineManager` methods for business logic errors (like invalid input values or trying to perform an action when the state is incorrect) and caught in the `main` method to print messages to `System.err`.
 *     *   `System.out` is used for the menu, prompts, successful operation confirmations, and status display. `System.err` is exclusively used for all error reporting.
 * 
 * This solution effectively integrates all required Java components within a practical simulation, demonstrating object-oriented design, state management using different collection types (`Queue`, `List`/`ArrayList`), user interaction, flow control, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Represents a single task/item moving through the production line.
 */
class Task {
    private int id;
    private String name;
    private int readyForStageIndex; // Index of the *next* stage this task is ready for

    /**
     * Constructs a new Task.
     * @param id The unique identifier for the task.
     * @param name The name of the task.
     * @param initialStageIndex The index of the first stage this task is ready for.
     */
    public Task(int id, String name, int initialStageIndex) {
        this.id = id;
        this.name = name;
        this.readyForStageIndex = initialStageIndex;
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReadyForStageIndex() {
        return readyForStageIndex;
    }

    // --- Setters / Updaters ---
    /**
     * Advances the task to the next stage.
     */
    public void advanceStage() {
        this.readyForStageIndex++;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Name: " + name;
    }
}

/**
 * Manages the flow of tasks through the production line stages.
 */
class ProductionLineManager {
    private Queue<Task> interStageBuffer; // Tasks waiting between stages
    private List<Task> currentStationProcessingArea; // Tasks ready at the active stage
    private List<Task> completedTasks; // Tasks that finished all stages
    private List<String> stageSequence; // The defined order of stages
    private int activeStageIndex = -1; // Index of the currently active stage (-1 means no stage active)

    /**
     * Constructs a ProductionLineManager with defined stages.
     * @param stageNames An array of strings representing the stage names in order.
     */
    public ProductionLineManager(String[] stageNames) {
        this.interStageBuffer = new LinkedList<>(); // LinkedList is a common Queue implementation
        this.currentStationProcessingArea = new ArrayList<>(); // ArrayList for dynamic size list
        this.completedTasks = new ArrayList<>(); // ArrayList for completed tasks
        this.stageSequence = new ArrayList<>(List.of(stageNames)); // Initialize stage sequence
    }

    /**
     * Adds a new task to the production line. Initially placed in the buffer.
     * @param id The ID of the task.
     * @param name The name of the task.
     * @return The added Task object.
     * @throws IllegalArgumentException if task ID is not positive or name is empty.
     * @throws IllegalStateException if a task with the same ID already exists.
     */
    public Task addTask(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Task ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty.");
        }

        // Check for duplicate ID across all lists
        if (findTaskById(id) != null) {
             throw new IllegalStateException("Task with ID " + id + " already exists.");
        }


        Task newTask = new Task(id, name, 0); // New tasks are ready for the first stage (index 0)
        interStageBuffer.offer(newTask); // Add to the end of the buffer queue
        return newTask;
    }

    /**
     * Sets the active stage and moves tasks from the buffer to the processing area.
     * @param stageIndex The index of the stage to activate.
     * @throws IllegalArgumentException if the stage index is invalid.
     */
    public void setActiveStage(int stageIndex) {
        if (stageIndex < 0 || stageIndex >= stageSequence.size()) {
            throw new IllegalArgumentException("Invalid stage index: " + stageIndex);
        }
        this.activeStageIndex = stageIndex;
        this.currentStationProcessingArea.clear(); // Clear previous stage's tasks

        // Move tasks from buffer that are ready for this stage to the processing area
        Iterator<Task> bufferIterator = interStageBuffer.iterator();
        List<Task> movedTasks = new ArrayList<>();
        while (bufferIterator.hasNext()) {
            Task task = bufferIterator.next();
            if (task.getReadyForStageIndex() == activeStageIndex) {
                movedTasks.add(task);
                bufferIterator.remove(); // Remove from the buffer
            }
        }
        currentStationProcessingArea.addAll(movedTasks); // Add to the processing area
        System.out.println("Active stage set to: " + getActiveStageName() + ".");
        System.out.println("Moved " + movedTasks.size() + " task(s) from buffer to " + getActiveStageName() + " processing area.");
    }

    /**
     * Processes a task at the currently active stage.
     * @param taskId The ID of the task to process.
     * @throws IllegalStateException if no stage is active, or if the task is not found
     *                               in the current station's processing area.
     */
    public void processTaskAtActiveStage(int taskId) {
        if (activeStageIndex == -1) {
            throw new IllegalStateException("No active stage set. Cannot process tasks.");
        }

        Task taskToProcess = null;
        Iterator<Task> processingAreaIterator = currentStationProcessingArea.iterator();
        while (processingAreaIterator.hasNext()) {
            Task task = processingAreaIterator.next();
            if (task.getId() == taskId) {
                taskToProcess = task;
                processingAreaIterator.remove(); // Remove from processing area
                break;
            }
        }

        if (taskToProcess == null) {
             throw new IllegalStateException("Task with ID " + taskId + " not found at the " + getActiveStageName() + " processing area.");
        }

        System.out.println("Processing " + taskToProcess + " at " + getActiveStageName() + ".");
        taskToProcess.advanceStage(); // Mark as ready for the next stage

        if (taskToProcess.getReadyForStageIndex() >= stageSequence.size()) {
            // Task has completed all stages
            completedTasks.add(taskToProcess);
            System.out.println(taskToProcess + " processed at " + getActiveStageName() + ", completed all stages.");
        } else {
            // Task needs to go to the next stage, put back in buffer
            interStageBuffer.offer(taskToProcess);
            System.out.println(taskToProcess + " processed at " + getActiveStageName() + ", now ready for " + getStageName(taskToProcess.getReadyForStageIndex()) + ".");
        }
    }

    /**
     * Displays the current status of the production line.
     */
    public void viewStatus() {
        System.out.println("--- Production Status ---");
        System.out.println("Active Stage: " + (activeStageIndex == -1 ? "Not Set" : getActiveStageName()));
        System.out.println("Inter-Stage Buffer: " + interStageBuffer.size() + " task(s)");
        if (!interStageBuffer.isEmpty()) {
             System.out.println("  Waiting in Buffer:");
             for (Task task : interStageBuffer) {
                 System.out.println("    " + task + " (Ready for: " + getStageName(task.getReadyForStageIndex()) + ")");
             }
        }

        System.out.println("Tasks at Active Stage (" + (activeStageIndex == -1 ? "N/A" : getActiveStageName()) + "): " + currentStationProcessingArea.size() + " task(s)");
        if (!currentStationProcessingArea.isEmpty()) {
            System.out.println("  At Processing Area:");
            for (Task task : currentStationProcessingArea) {
                System.out.println("    " + task + " (Ready for: " + getStageName(task.getReadyForStageIndex()) + ")");
            }
        }


        System.out.println("Completed Tasks: " + completedTasks.size() + " task(s)");
        if (!completedTasks.isEmpty()) {
            System.out.println("  Completed List:");
            for (Task task : completedTasks) {
                System.out.println("    " + task);
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * Finds a task by its ID across all collections.
     * @param id The ID to search for.
     * @return The Task object if found, otherwise null.
     */
    private Task findTaskById(int id) {
        for (Task task : interStageBuffer) {
            if (task.getId() == id) return task;
        }
        for (Task task : currentStationProcessingArea) {
            if (task.getId() == id) return task;
        }
        for (Task task : completedTasks) {
            if (task.getId() == id) return task;
        }
        return null;
    }


    /**
     * Gets the name of a stage by its index.
     * @param index The stage index.
     * @return The stage name.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    public String getStageName(int index) {
        if (index < 0 || index >= stageSequence.size()) {
             // Should not happen if logic is correct, but good for safety/debugging
             return "Invalid Stage Index " + index;
        }
        return stageSequence.get(index);
    }

    /**
     * Gets the name of the currently active stage.
     * @return The active stage name, or "Not Set".
     */
    public String getActiveStageName() {
        return activeStageIndex == -1 ? "Not Set" : getStageName(activeStageIndex);
    }

    /**
     * Gets the total number of stages.
     * @return The number of stages.
     */
    public int getTotalStages() {
        return stageSequence.size();
    }

    /**
     * Displays the available stages with their indices.
     */
    public void displayStages() {
        System.out.println("Available Stages:");
        for (int i = 0; i < stageSequence.size(); i++) {
            System.out.println(i + ": " + stageSequence.get(i));
        }
    }
}

/**
 * Main class for the Production Line Simulation program.
 */
public class ProductionLineSimulation {

    public static void main(String[] args) {
        // Class-wide exception handling
        try {
            String[] stages = {"Assembly", "Quality Check", "Packaging"};
            ProductionLineManager manager = new ProductionLineManager(stages);
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            System.out.println("--- Production Line Simulation ---");

            while (running) {
                printMenu();
                System.out.print("Enter command: ");
                String command = scanner.nextLine();

                // Using switch for flow control
                switch (command) {
                    case "1": // Add Task
                        try {
                            System.out.print("Enter Task ID: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            System.out.print("Enter Task Name: ");
                            String name = scanner.nextLine();
                            Task addedTask = manager.addTask(id, name);
                            System.out.println(addedTask + " added, ready for " + manager.getStageName(0) + ".");
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid Task ID. Please enter a number.");
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case "2": // Set Active Stage
                        manager.displayStages();
                        System.out.print("Enter stage index to activate: ");
                        try {
                            int stageIndex = Integer.parseInt(scanner.nextLine());
                            manager.setActiveStage(stageIndex);
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid stage index. Please enter a number.");
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case "3": // Process Task at Active Stage
                        if (manager.activeStageIndex == -1) {
                             System.err.println("Error: No active stage set. Use command 2 first.");
                             break;
                        }
                        System.out.print("Enter Task ID to process at " + manager.getActiveStageName() + ": ");
                        try {
                            int taskId = Integer.parseInt(scanner.nextLine());
                            manager.processTaskAtActiveStage(taskId);
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid Task ID. Please enter a number.");
                        } catch (IllegalStateException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case "4": // View Status
                        manager.viewStatus();
                        break;

                    case "5": // Exit
                        running = false;
                        System.out.println("Exiting simulation.");
                        break;

                    default:
                        System.err.println("Error: Unknown command. Please try again.");
                }
                System.out.println(); // Add a newline for better readability
            }

            scanner.close();

        } catch (Exception e) {
            // Catch any unexpected exceptions at the top level
            System.err.println("An unexpected error occurred:");
            e.printStackTrace(System.err); // Print stack trace to stderr
        }
    }

    /**
     * Prints the main menu options to standard output.
     */
    private static void printMenu() {
        System.out.println("Production Line Menu:");
        System.out.println("1. Add Task");
        System.out.println("2. Set Active Stage");
        System.out.println("3. Process Task at Active Stage");
        System.out.println("4. View Status");
        System.out.println("5. Exit");
    }
}
