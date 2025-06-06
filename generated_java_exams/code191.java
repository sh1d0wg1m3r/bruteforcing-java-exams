/*
 * Exam Question #191
 * Generated on: 2025-05-11 22:29:09
 * Generated by: Account 4
 * 
 * QUESTION:
 * **Advanced Java Programming Exam: Manufacturing Process Simulation**
 * 
 * **Scenario:**
 * You are tasked with creating a simplified simulation of a manufacturing process line. Items enter a queue to be processed. A worker (simulated by a command) takes the next item from the queue, processes it, and moves it to a list of finished items. The system should allow adding new items, processing the next item in line, listing all items (pending and finished), and exiting.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a queue of items waiting to be processed. Use `java.util.Queue`.
 *     *   Maintain a list of items that have been processed. Use `java.util.List` interface for declaration and `java.util.ArrayList` for instantiation.
 * 2.  **Classes:**
 *     *   Create an `Item` class representing an item on the manufacturing line. It should have:
 *         *   A unique integer ID.
 *         *   A String name.
 *         *   A status (e.g., PENDING, PROCESSING, FINISHED). Use an `enum` for status.
 *         *   Appropriate private fields and public getter methods.
 *         *   A method to change its status (e.g., `markAsProcessing()`, `markAsFinished()`). Ensure status transitions are logical (e.g., can't go from FINISHED back to PENDING).
 *         *   A `toString()` method for easy printing of item details.
 *     *   Create a `ProcessManager` class to manage the queue and list. It should have:
 *         *   Private fields for the pending items queue and finished items list.
 *         *   A mechanism to generate unique item IDs.
 *         *   A method `addItem(String name)`: Creates a new `Item` with PENDING status and adds it to the pending queue. Validate that the item name is not empty or null.
 *         *   A method `processNextItem()`: Takes the next item from the pending queue (if any), changes its status to FINISHED, and moves it to the finished items list. If the queue is empty, it should report an error.
 *         *   A method `listAllItems()`: Prints the details of all items currently in the pending queue and all items in the finished list. Also, report the total count in each list.
 *         *   Appropriate accessors (getters) if needed (e.g., for counts).
 * 3.  **User Interface:**
 *     *   Use `java.util.Scanner` to get user input from the console.
 *     *   Implement a command-line interface with the following options:
 *         *   `1`: Add New Item
 *         *   `2`: Process Next Item
 *         *   `3`: List All Items
 *         *   `4`: Exit
 *     *   Use a `switch` statement to handle the different user commands.
 * 4.  **Error Handling and Output:**
 *     *   Use `System.out` for normal program output (menu, item details, success messages).
 *     *   Use `System.err` for error messages (e.g., invalid input, processing queue empty, invalid status transition).
 *     *   Implement class-wide exception handling using `try-catch` blocks, specifically around the main user interaction loop, to catch unexpected errors and print informative messages to `System.err`.
 *     *   Implement input validation (e.g., check if user enters a valid command number, check if item name is provided).
 * 5.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Include comments where necessary to explain complex logic.
 *     *   Ensure resources like `Scanner` are closed properly.
 * 
 * **Expected Interaction:**
 * 
 * The program should display a menu, prompt for input, and perform the requested action.
 * Example flow:
 * ```
 * Manufacturing Process Simulation
 * Menu:
 * 1. Add New Item
 * 2. Process Next Item
 * 3. List All Items
 * 4. Exit
 * Enter command: 1
 * Enter item name: Widget A
 * Item 'Widget A' added with ID 1.
 * 
 * Enter command: 1
 * Enter item name: Gadget B
 * Item 'Gadget B' added with ID 2.
 * 
 * Enter command: 3
 * --- Pending Items (2) ---
 * ID: 1, Name: Widget A, Status: PENDING
 * ID: 2, Name: Gadget B, Status: PENDING
 * --- Finished Items (0) ---
 * 
 * Enter command: 2
 * Processing next item...
 * Item ID 1 processed and moved to finished.
 * 
 * Enter command: 3
 * --- Pending Items (1) ---
 * ID: 2, Name: Gadget B, Status: PENDING
 * --- Finished Items (1) ---
 * ID: 1, Name: Widget A, Status: FINISHED
 * 
 * Enter command: 2
 * Processing next item...
 * Item ID 2 processed and moved to finished.
 * 
 * Enter command: 2
 * Processing next item...
 * Error: No items in the pending queue to process.
 * 
 * Enter command: 3
 * --- Pending Items (0) ---
 * --- Finished Items (2) ---
 * ID: 1, Name: Widget A, Status: FINISHED
 * ID: 2, Name: Gadget B, Status: FINISHED
 * 
 * Enter command: 5
 * Error: Invalid command. Please enter 1, 2, 3, or 4.
 * 
 * Enter command: 4
 * Exiting simulation.
 * ```
 * 
 * Your solution should be a single Java file containing all necessary classes and the main method.
 * 
 * **Evaluation:**
 * Your solution will be evaluated on correctness, adherence to all requirements (especially the use of specified Java components), code quality, error handling, and proper output.
 *
 * EXPLANATION:
 * This solution implements a simplified manufacturing process simulation demonstrating the required Java concepts.
 * 
 * 1.  **`ItemStatus` Enum:** Defines the possible states of an item (`PENDING`, `PROCESSING`, `FINISHED`), improving code readability and preventing invalid status assignments.
 * 2.  **`Item` Class:**
 *     *   Encapsulates item data (`id`, `name`, `status`) using private fields and public getters.
 *     *   The constructor validates the item name, throwing an `IllegalArgumentException` if it's invalid.
 *     *   `markAsFinished()` provides a controlled way to change status, including a check to prevent marking an already finished item.
 *     *   `toString()` provides a convenient string representation for printing.
 * 3.  **`ProcessManager` Class:**
 *     *   Holds the core data structures: `pendingItems` (a `Queue` implemented by `LinkedList`) and `finishedItems` (a `List` declared as `List` and instantiated as `ArrayList`). This fulfills the requirements for using both `Queue`, `ArrayList`, and the `List` interface.
 *     *   `nextItemId` is a simple counter for generating unique IDs, demonstrating state management within the class.
 *     *   `addItem()` creates an `Item` and adds it to the `pendingItems` queue using `offer()`. It includes a `try-catch` specifically for the `IllegalArgumentException` that the `Item` constructor might throw for invalid names, reporting the error to `System.err`.
 *     *   `processNextItem()` uses `poll()` to retrieve and remove the next item from the `pendingItems` queue. It checks if the queue was empty and prints an error to `System.err` if so. If an item is retrieved, it's marked as finished and added to the `finishedItems` list. A `try-catch` block is included here to handle potential `IllegalStateException` from `markAsFinished` or other unexpected errors during the processing step, directing output to `System.err`.
 *     *   `listAllItems()` iterates through both the `pendingItems` queue and `finishedItems` list, printing the details of each item using their `toString()` method. It also reports the counts for each list.
 * 4.  **`ManufacturingSimulation` Class (Main Class):**
 *     *   Contains the `main` method where execution begins.
 *     *   Initializes a `Scanner` for user input and a `ProcessManager` instance.
 *     *   The main application logic runs inside a `while(true)` loop for continuous command processing.
 *     *   **Class-wide Exception Handling:** The entire `while` loop is wrapped in a `try-catch(Exception e)`. This demonstrates catching any unexpected runtime exceptions that might occur within the main command processing flow (though specific errors like invalid input or empty queue are handled more granularly). Any caught exception prints a general error message and the stack trace to `System.err`.
 *     *   **Input Handling:** Inside the loop, a `try-catch(NumberFormatException)` is used specifically for reading the command number. This handles cases where the user enters non-numeric input, preventing the program from crashing and printing an error to `System.err`.
 *     *   **Flow Control:** A `switch` statement is used to direct execution based on the valid integer command entered by the user, fulfilling the requirement for using `switch`.
 *     *   **Output:** `System.out.println` is used for the menu, prompts, success messages, and item listings. `System.err.println` is used exclusively for error messages, as required.
 *     *   **Resource Management:** A `finally` block ensures that the `Scanner` is closed when the program exits (either normally via command 4 or due to an uncaught exception).
 * 
 * This solution effectively combines data structures (`Queue`, `List`, `ArrayList`), object-oriented principles (encapsulation, classes), control flow (`switch`, loops), input/output (`Scanner`, `System.out`, `System.err`), and robust error handling (`try-catch`, input validation) to simulate a practical scenario.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Enum for item status
enum ItemStatus {
    PENDING,
    PROCESSING, // Although items move quickly, this state could be used in a more complex sim
    FINISHED
}

// Represents an item in the manufacturing process
class Item {
    private int id;
    private String name;
    private ItemStatus status;

    /**
     * Constructs a new Item.
     * @param id The unique ID for the item.
     * @param name The name of the item.
     */
    public Item(int id, String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        this.id = id;
        this.name = name.trim();
        this.status = ItemStatus.PENDING; // Initially, items are pending
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ItemStatus getStatus() {
        return status;
    }

    /**
     * Marks the item as finished.
     * @throws IllegalStateException if the item is already finished.
     */
    public void markAsFinished() {
        if (this.status == ItemStatus.FINISHED) {
            throw new IllegalStateException("Item ID " + id + " is already finished.");
        }
        this.status = ItemStatus.FINISHED;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Status: " + status;
    }
}

// Manages the queue of pending items and the list of finished items
class ProcessManager {
    private Queue<Item> pendingItems;
    private List<Item> finishedItems;
    private int nextItemId; // Counter for generating unique IDs

    /**
     * Constructs a new ProcessManager.
     */
    public ProcessManager() {
        this.pendingItems = new LinkedList<>(); // LinkedList implements Queue
        this.finishedItems = new ArrayList<>(); // ArrayList implements List
        this.nextItemId = 1; // Start ID generation from 1
    }

    /**
     * Adds a new item to the pending queue.
     * @param itemName The name of the item to add.
     * @throws IllegalArgumentException if the item name is null or empty.
     */
    public void addItem(String itemName) {
        try {
            Item newItem = new Item(nextItemId, itemName);
            pendingItems.offer(newItem); // offer is preferred over add in queues
            System.out.println("Item '" + newItem.getName() + "' added with ID " + newItem.getId() + ".");
            nextItemId++; // Increment for the next item
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding item: " + e.getMessage());
        }
    }

    /**
     * Processes the next item from the pending queue and moves it to the finished list.
     */
    public void processNextItem() {
        System.out.println("Processing next item...");
        Item itemToProcess = pendingItems.poll(); // Retrieves and removes the head of this queue

        if (itemToProcess == null) {
            System.err.println("Error: No items in the pending queue to process.");
            return;
        }

        try {
            // In a real simulation, processing would take time, status might change to PROCESSING first.
            // For this problem, we simulate instant processing to FINISHED.
            itemToProcess.markAsFinished();
            finishedItems.add(itemToProcess);
            System.out.println("Item ID " + itemToProcess.getId() + " processed and moved to finished.");
        } catch (IllegalStateException e) {
             // This case should ideally not happen with the current logic, but good practice to catch
             System.err.println("Processing error for item ID " + itemToProcess.getId() + ": " + e.getMessage());
             // Optionally, decide what to do with the item (e.g., put it back?)
        } catch (Exception e) {
            System.err.println("An unexpected error occurred during processing item ID " + itemToProcess.getId() + ": " + e.getMessage());
             // Handle other potential exceptions during processing
        }
    }

    /**
     * Lists all items currently in the pending queue and finished list.
     */
    public void listAllItems() {
        System.out.println("\n--- Pending Items (" + pendingItems.size() + ") ---");
        if (pendingItems.isEmpty()) {
            System.out.println("No pending items.");
        } else {
            // Iterating over a Queue does not remove elements
            for (Item item : pendingItems) {
                System.out.println(item);
            }
        }

        System.out.println("\n--- Finished Items (" + finishedItems.size() + ") ---");
        if (finishedItems.isEmpty()) {
            System.out.println("No finished items.");
        } else {
            for (Item item : finishedItems) {
                System.out.println(item);
            }
        }
        System.out.println(); // Add a newline for better formatting
    }

    // Getters for counts (optional, but good for listing summary)
    public int getPendingCount() {
        return pendingItems.size();
    }

    public int getFinishedCount() {
        return finishedItems.size();
    }
}

// Main class to run the simulation
public class ManufacturingSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcessManager manager = new ProcessManager();

        System.out.println("Manufacturing Process Simulation");

        // Class-wide exception handling for the main loop
        try {
            while (true) {
                printMenu();
                System.out.print("Enter command: ");

                int command = -1; // Default invalid command

                // Use another try-catch for input reading specifically
                try {
                    command = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    continue; // Skip to next loop iteration
                }

                // Use switch statement for flow control based on command
                switch (command) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        manager.addItem(itemName); // addItem handles its own validation errors
                        break;
                    case 2:
                        manager.processNextItem(); // processNextItem handles its own errors (queue empty)
                        break;
                    case 3:
                        manager.listAllItems();
                        break;
                    case 4:
                        System.out.println("Exiting simulation.");
                        return; // Exit the main method, ending the program
                    default:
                        System.err.println("Error: Invalid command. Please enter 1, 2, 3, or 4.");
                        break; // Continue loop after invalid command
                }
                System.out.println(); // Add a newline after each action for clarity
            }
        } catch (Exception e) {
            // Catch any other unexpected runtime exceptions in the main loop
            System.err.println("An unexpected system error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
            // Ensure scanner is closed even if an exception occurs
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add New Item");
        System.out.println("2. Process Next Item");
        System.out.println("3. List All Items");
        System.out.println("4. Exit");
    }
}
