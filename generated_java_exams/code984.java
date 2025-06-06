/*
 * Exam Question #984
 * Generated on: 2025-05-12 17:08:43
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Java Programming Exam Task: Production Line Simulator**
 * 
 * **Problem Description:**
 * 
 * You are tasked with creating a simplified simulation of a manufacturing production line. The production line processes "Work Items". Each Work Item has a unique integer ID and a String representing its Type (e.g., "Assembly", "Testing", "Packaging").
 * 
 * Work Items arrive and are placed into a queue to await processing. The production line processes items one by one from the front of the queue. Once an item is processed, it is moved to a list of completed items.
 * 
 * Your program should provide a command-line interface for a user to interact with the production line.
 * 
 * **Requirements:**
 * 
 * 1.  **WorkItem Class:** Create a class `WorkItem` with private fields for `id` (int) and `type` (String). Include a constructor, public getter methods for both fields, and a meaningful `toString()` method.
 * 2.  **ProductionLine Class:** Create a class `ProductionLine` that manages the work items.
 *     *   It must have a private `Queue<WorkItem>` to hold items waiting to be processed. Use a concrete implementation like `LinkedList`.
 *     *   It must have a private `List<WorkItem>` (declared as `List`, instantiated as `ArrayList`) to hold completed items.
 *     *   Implement the following public methods:
 *         *   `addItem(WorkItem item)`: Adds a `WorkItem` to the waiting queue.
 *         *   `processNextItem()`: Removes the next `WorkItem` from the queue, adds it to the completed list, and returns the processed item. If the queue is empty, it should indicate an error condition (you can return `null` or throw a custom exception, but for this problem, returning `null` and handling it in the main loop is acceptable).
 *         *   `getWaitingQueue()`: Returns an unmodifiable view or a copy of the waiting queue (to prevent external modification). For simplicity in this exam, returning the queue reference is acceptable if you document the risk, but returning a new list containing queue elements is better practice. Let's require returning a new `ArrayList` containing the elements.
 *         *   `getCompletedItems()`: Returns an unmodifiable view or a copy of the completed list. Return a new `ArrayList` containing the elements.
 *         *   `getWaitingQueueSize()`: Returns the number of items in the waiting queue.
 *         *   `getCompletedCount()`: Returns the number of items in the completed list.
 * 3.  **Main Program (`ProductionLineSimulator`):**
 *     *   Create a class `ProductionLineSimulator` with a `main` method.
 *     *   Instantiate a `ProductionLine` object and a `Scanner` object.
 *     *   Implement a menu-driven loop that presents the following options to the user:
 *         1.  Add New Work Item
 *         2.  Process Next Work Item
 *         3.  View Waiting Queue
 *         4.  View Completed Items
 *         5.  View Status (Queue size and Completed count)
 *         6.  Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   **Input Handling & Validation:**
 *         *   When adding an item, prompt for ID and Type.
 *         *   Validate that the ID is a positive integer. If not, use `System.err` to report the error and do not add the item.
 *         *   Validate that the Type is not empty or just whitespace. If invalid, use `System.err` and do not add the item.
 *         *   Handle potential `InputMismatchException` if the user enters non-integer input for the menu choice or item ID. Use a `try-catch` block around the input reading, report the error using `System.err`, clear the invalid input from the scanner, and continue the loop.
 *     *   **Error Handling:**
 *         *   If the user chooses to process an item but the queue is empty, use `System.err` to report "Waiting queue is empty. No items to process."
 *         *   Use `System.err` for any other critical errors or invalid operations.
 *         *   Use `System.out` for menu display, prompts, successful operations, and viewing item lists.
 *     *   **Class-wide Exception Handling:** Wrap the main program loop (or the core logic within `main`) in a `try-catch` block to catch unexpected runtime exceptions and print an error message using `System.err` before exiting.
 *     *   **Best Practices:**
 *         *   Use meaningful variable and method names.
 *         *   Include basic comments (like Javadoc for classes/methods).
 *         *   Ensure proper encapsulation in `WorkItem` and `ProductionLine`.
 *         *   Maintain clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should display the menu, accept user input, perform the requested action, and display appropriate messages using `System.out` for success/information and `System.err` for errors/warnings.
 * 
 * Example Interaction Snippet:
 * 
 * ```
 * --- Production Line Menu ---
 * 1. Add New Work Item
 * 2. Process Next Work Item
 * 3. View Waiting Queue
 * 4. View Completed Items
 * 5. View Status
 * 6. Exit
 * Enter your choice: 1
 * Enter Work Item ID: 101
 * Enter Work Item Type: Assembly
 * Work Item 101 (Assembly) added to the queue.
 * 
 * Enter your choice: 1
 * Enter Work Item ID: 102
 * Enter Work Item Type: Testing
 * Work Item 102 (Testing) added to the queue.
 * 
 * Enter your choice: 3
 * --- Waiting Queue ---
 * ID: 101, Type: Assembly
 * ID: 102, Type: Testing
 * ---------------------
 * 
 * Enter your choice: 2
 * Processing item: ID: 101, Type: Assembly
 * Item 101 processed and moved to completed.
 * 
 * Enter your choice: 3
 * --- Waiting Queue ---
 * ID: 102, Type: Testing
 * ---------------------
 * 
 * Enter your choice: 4
 * --- Completed Items ---
 * ID: 101, Type: Assembly
 * -----------------------
 * 
 * Enter your choice: 2
 * Processing item: ID: 102, Type: Testing
 * Item 102 processed and moved to completed.
 * 
 * Enter your choice: 2
 * System.err: Waiting queue is empty. No items to process.
 * 
 * Enter your choice: 5
 * --- Production Line Status ---
 * Waiting Queue Size: 0
 * Completed Items Count: 2
 * ------------------------------
 * 
 * Enter your choice: 6
 * Exiting Production Line Simulator.
 * ```
 * 
 * **Assessment:**
 * 
 * Your solution will be assessed on:
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`.
 * *   Adherence to object-oriented principles (encapsulation).
 * *   Input validation and error handling.
 * *   Code clarity, structure, and comments.
 * *   Correct implementation of the production line logic.
 *
 * EXPLANATION:
 * This solution implements a `ProductionLineSimulator` that manages `WorkItem` objects using a queue and a list, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`WorkItem` Class:**
 *     *   Encapsulates `id` and `type` as private fields.
 *     *   Provides a constructor with input validation (`IllegalArgumentException`) for positive ID and non-empty type.
 *     *   Includes public getters and a descriptive `toString()` method.
 * 
 * 2.  **`ProductionLine` Class:**
 *     *   Uses a private `Queue<WorkItem>` (`LinkedList` implementation) for waiting items. The `Queue` interface is ideal here because items are processed in FIFO (First-In, First-Out) order (`add` and `poll`).
 *     *   Uses a private `List<WorkItem>` (`ArrayList` implementation) for completed items. `ArrayList` is suitable for storing and iterating through completed items. The variable is declared as `List` to program to the interface, which is a good practice.
 *     *   `addItem()`: Uses `Queue.add()` to enqueue a new item.
 *     *   `processNextItem()`: Uses `Queue.poll()` to remove and return the head of the queue. `poll()` returns `null` if the queue is empty, which is handled in the calling code. If successful, the item is added to the `completedItems` `ArrayList`.
 *     *   `getWaitingQueue()` and `getCompletedItems()`: Return *new* `ArrayList` instances containing the elements from the internal collections. This prevents external code from directly modifying the internal `waitingQueue` or `completedItems` list, adhering to good encapsulation.
 *     *   `getWaitingQueueSize()` and `getCompletedCount()`: Provide simple access to the sizes of the collections.
 * 
 * 3.  **`ProductionLineSimulator` Class (`main`):**
 *     *   Contains the `main` method which is the entry point.
 *     *   Instantiates `ProductionLine` and `Scanner`.
 *     *   **Class-wide Exception Handling:** The core `runSimulation()` method call is wrapped in a `try-catch(Exception e)` block in `main`. This serves as a safety net for any unexpected runtime exceptions that might occur anywhere within the simulation logic, printing an error to `System.err` and the stack trace.
 *     *   `runSimulation()`: Implements the main program loop.
 *     *   **`switch` statement:** Used to dispatch execution based on the user's menu choice, covering the different operations.
 *     *   **`Scanner` and Input Handling:** Reads integer choices and String inputs.
 *     *   **Input Validation (`try-catch`):**
 *         *   A `try-catch (InputMismatchException)` block is specifically used *within* the main loop to catch cases where the user enters non-integer input for the menu choice. It prints an error to `System.err` and, importantly, calls `scanner.nextLine()` to clear the invalid input from the scanner's buffer, preventing an infinite loop.
 *         *   Input for `WorkItem` ID is also handled with a `try-catch(InputMismatchException)` in `addNewWorkItem()`.
 *         *   Validation for positive ID and non-empty Type is done within the `WorkItem` constructor, throwing `IllegalArgumentException`, which is caught in `addNewWorkItem()` and reported using `System.err`.
 *     *   **Error Handling (`System.err`, `System.out`):**
 *         *   `System.out.println()` is used for the menu, user prompts, successful operation messages, and displaying the contents of the queues/lists.
 *         *   `System.err.println()` is used for error messages: invalid menu choices, invalid input formats, validation errors from `WorkItem` constructor, and the specific case of trying to process an item when the queue is empty.
 *     *   **Method Breakdown:** The logic for each menu option is broken down into separate, well-named private methods (`addNewWorkItem`, `processNextWorkItem`, etc.) for better organization and readability.
 *     *   **Resource Management:** The `Scanner` is closed in a `finally` block to ensure it's released properly.
 * 
 * This solution effectively combines data structures (`Queue`, `List`, `ArrayList`), control flow (`switch`, loops), I/O (`Scanner`, `System.out`, `System.err`), and exception handling (`try-catch`) within a structured, object-oriented design, fulfilling all the requirements of the problem.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList; // Common implementation for Queue
import java.util.Scanner;
import java.util.InputMismatchException; // For handling non-integer input
import java.util.Collections; // For unmodifiable lists

/**
 * Represents a single work item in the production line.
 */
class WorkItem {
    private int id;
    private String type;

    /**
     * Constructs a new WorkItem.
     * @param id The unique identifier for the item. Must be positive.
     * @param type The type of work required for the item. Cannot be null or empty.
     */
    public WorkItem(int id, String type) {
        if (id <= 0) {
            throw new IllegalArgumentException("Work Item ID must be positive.");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Work Item Type cannot be null or empty.");
        }
        this.id = id;
        this.type = type.trim(); // Trim whitespace
    }

    /**
     * Gets the ID of the work item.
     * @return The item ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the type of the work item.
     * @return The item type.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns a string representation of the WorkItem.
     * @return A formatted string showing the item's ID and Type.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Type: " + type;
    }
}

/**
 * Simulates a production line managing a queue of waiting items
 * and a list of completed items.
 */
class ProductionLine {
    private Queue<WorkItem> waitingQueue;
    private List<WorkItem> completedItems; // Declared as List, instantiated as ArrayList

    /**
     * Constructs a new ProductionLine with empty queues and lists.
     */
    public ProductionLine() {
        waitingQueue = new LinkedList<>(); // LinkedList is a common Queue implementation
        completedItems = new ArrayList<>(); // Instantiated as ArrayList
    }

    /**
     * Adds a work item to the waiting queue.
     * @param item The WorkItem to add.
     */
    public void addItem(WorkItem item) {
        if (item != null) {
            waitingQueue.add(item);
        }
    }

    /**
     * Processes the next item from the waiting queue.
     * Removes the item from the queue and adds it to the completed list.
     * @return The processed WorkItem, or null if the queue was empty.
     */
    public WorkItem processNextItem() {
        WorkItem itemToProcess = waitingQueue.poll(); // poll() returns null if queue is empty
        if (itemToProcess != null) {
            completedItems.add(itemToProcess);
            return itemToProcess;
        }
        return null; // Indicate no item was processed
    }

    /**
     * Gets a list of items currently in the waiting queue.
     * Returns a new list to protect the internal queue.
     * @return A List of WorkItems in the waiting queue.
     */
    public List<WorkItem> getWaitingQueue() {
        // Return a new ArrayList containing all elements from the queue
        // This prevents external modification of the internal queue structure
        return new ArrayList<>(waitingQueue);
    }

    /**
     * Gets a list of items that have been completed.
     * Returns a new list to protect the internal completed list.
     * @return A List of completed WorkItems.
     */
    public List<WorkItem> getCompletedItems() {
        // Return a new ArrayList containing all elements from the completed list
        // This prevents external modification of the internal list
        return new ArrayList<>(completedItems);
    }

    /**
     * Gets the number of items currently in the waiting queue.
     * @return The size of the waiting queue.
     */
    public int getWaitingQueueSize() {
        return waitingQueue.size();
    }

    /**
     * Gets the number of items that have been completed.
     * @return The count of completed items.
     */
    public int getCompletedCount() {
        return completedItems.size();
    }
}

/**
 * Main class to simulate the Production Line interaction.
 */
public class ProductionLineSimulator {

    private static Scanner scanner = new Scanner(System.in);
    private static ProductionLine productionLine = new ProductionLine();

    public static void main(String[] args) {
        // Class-wide exception handling for unexpected errors
        try {
            runSimulation();
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed even if an exception occurs
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Runs the main simulation loop, presenting the menu and handling user input.
     */
    private static void runSimulation() {
        int choice = -1;
        while (choice != 6) {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1:
                        addNewWorkItem();
                        break;
                    case 2:
                        processNextWorkItem();
                        break;
                    case 3:
                        viewWaitingQueue();
                        break;
                    case 4:
                        viewCompletedItems();
                        break;
                    case 5:
                        viewStatus();
                        break;
                    case 6:
                        System.out.println("Exiting Production Line Simulator.");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                // Handle non-integer input specifically
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input line to prevent infinite loop
                choice = -1; // Reset choice to avoid unintended switch case execution
            } catch (IllegalArgumentException e) {
                 // Catch exceptions from WorkItem constructor validation
                 System.err.println("Error creating work item: " + e.getMessage());
            }
            System.out.println(); // Add a blank line for readability
        }
    }

    /**
     * Handles adding a new work item based on user input.
     */
    private static void addNewWorkItem() {
        System.out.print("Enter Work Item ID: ");
        int id;
        try {
            id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
        } catch (InputMismatchException e) {
            System.err.println("Invalid input for ID. Please enter an integer.");
            scanner.nextLine(); // Consume the invalid input
            return; // Exit method
        }

        System.out.print("Enter Work Item Type: ");
        String type = scanner.nextLine();

        try {
            WorkItem newItem = new WorkItem(id, type);
            productionLine.addItem(newItem);
            System.out.println("Work Item " + newItem.getId() + " (" + newItem.getType() + ") added to the queue.");
        } catch (IllegalArgumentException e) {
            // Catch validation errors from WorkItem constructor
            System.err.println("Error adding item: " + e.getMessage());
        }
    }

    /**
     * Handles processing the next item from the queue.
     */
    private static void processNextWorkItem() {
        WorkItem processedItem = productionLine.processNextItem();
        if (processedItem != null) {
            System.out.println("Processing item: " + processedItem);
            System.out.println("Item " + processedItem.getId() + " processed and moved to completed.");
        } else {
            System.err.println("Waiting queue is empty. No items to process.");
        }
    }

    /**
     * Displays the items currently in the waiting queue.
     */
    private static void viewWaitingQueue() {
        List<WorkItem> waiting = productionLine.getWaitingQueue(); // Get a copy
        System.out.println("--- Waiting Queue ---");
        if (waiting.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (WorkItem item : waiting) {
                System.out.println(item);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Displays the items that have been completed.
     */
    private static void viewCompletedItems() {
        List<WorkItem> completed = productionLine.getCompletedItems(); // Get a copy
        System.out.println("--- Completed Items ---");
        if (completed.isEmpty()) {
            System.out.println("No items completed yet.");
        } else {
            for (WorkItem item : completed) {
                System.out.println(item);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Displays the current status of the production line (queue size and completed count).
     */
    private static void viewStatus() {
        System.out.println("--- Production Line Status ---");
        System.out.println("Waiting Queue Size: " + productionLine.getWaitingQueueSize());
        System.out.println("Completed Items Count: " + productionLine.getCompletedCount());
        System.out.println("------------------------------");
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Production Line Menu ---");
        System.out.println("1. Add New Work Item");
        System.out.println("2. Process Next Work Item");
        System.out.println("3. View Waiting Queue");
        System.out.println("4. View Completed Items");
        System.out.println("5. View Status");
        System.out.println("6. Exit");
        System.out.println("----------------------------");
    }
}
