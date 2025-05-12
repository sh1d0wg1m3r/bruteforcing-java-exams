/*
 * Exam Question #32
 * Generated on: 2025-05-11 21:50:12
 * 
 * QUESTION:
 * **Java Programming Exam - Advanced Concepts**
 * 
 * **Task:** Design and implement a simplified **Logistics Warehouse Processing Simulation**.
 * 
 * Your program should simulate items arriving at a warehouse, being placed in a queue for processing (inspection/packing), and then being processed by available stations. The simulation should be interactive, allowing a user to manage the flow of items.
 * 
 * **Requirements:**
 * 
 * 1.  **Core Functionality:**
 *     *   Items arrive and are added to an `incomingItemsQueue`. Each item should have a unique ID and a name.
 *     *   Items are processed from the front of the `incomingItemsQueue`. Processing an item removes it from the queue.
 *     *   The user should be able to view the current status: the items waiting in the queue and the available processing stations.
 *     *   The simulation should run interactively via a menu.
 * 
 * 2.  **Required Java Components:**
 *     *   `java.util.Queue`: Must be used for the `incomingItemsQueue`.
 *     *   `java.util.ArrayList`: Must be used to store the list of `processingStations`.
 *     *   `java.util.List`: The `processingStations` variable must be declared using the `List` interface type.
 *     *   `java.util.Scanner`: Must be used to get user input (menu choices, item names, etc.).
 *     *   `switch` statement: Must be used to handle the main menu options.
 *     *   `System.err`: Must be used exclusively for printing error messages (e.g., invalid input, trying to process an empty queue).
 *     *   `System.out`: Must be used for all normal output (menu, prompts, status, success messages).
 *     *   Class-wide Exception Handling: Use `try-catch` blocks to handle potential exceptions, particularly around user input and queue operations. A single main `try-catch` block wrapping the core simulation loop is required, in addition to specific checks where necessary (e.g., empty queue).
 * 
 * 3.  **Implementation Details & Best Practices:**
 *     *   Create a separate class `WarehouseItem` to represent items. It should have private fields (`itemId`, `itemName`, `status`), a constructor, and public getter methods. Include a `toString()` method for easy printing.
 *     *   Create a main class (e.g., `WarehouseSimulation`) to manage the simulation logic.
 *     *   Use private fields for the queue, list of stations, and scanner within the simulation class.
 *     *   Implement methods for each action (add item, process item, view status, display menu).
 *     *   Use meaningful variable and method names.
 *     *   Include basic input validation (e.g., ensuring menu choice is an integer within range).
 *     *   Add comments to explain key parts of the code.
 *     *   Ensure the `Scanner` is properly closed.
 * 
 * **Menu Options:**
 * 
 * 1.  Add Incoming Item
 * 2.  Process Next Item
 * 3.  View Warehouse Status
 * 4.  Exit
 * 
 * **Expected Output:**
 * 
 * *   Menu displayed clearly using `System.out`.
 * *   Prompts for input using `System.out`.
 * *   Successful actions confirmed using `System.out`.
 * *   Warehouse status (queue contents, station list) displayed using `System.out`.
 * *   Error messages (invalid input, queue empty, etc.) printed exclusively to `System.err`.
 * *   Program exits cleanly when 'Exit' is chosen.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct usage of all required Java components.
 * *   Adherence to the problem requirements and functionality.
 * *   Implementation of best practices (encapsulation, naming, comments, clean code).
 * *   Proper input validation and error handling using `try-catch` and `System.err`.
 * *   Clear and correct output formatting (`System.out` vs. `System.err`).
 * *   Code structure and readability.
 * 
 * **Time Estimate:** 45-60 minutes.
 *
 * EXPLANATION:
 * This solution implements a simple warehouse processing simulation demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`WarehouseItem` Class:**
 *     *   Represents the data structure for items.
 *     *   Uses `private` fields (`itemId`, `itemName`, `status`) for encapsulation.
 *     *   Provides `public` getter methods.
 *     *   Includes a `toString()` method for convenient printing of item details.
 * 
 * 2.  **`WarehouseSimulation` Class:**
 *     *   Manages the core simulation logic.
 *     *   **Required Data Structures:**
 *         *   `private Queue<WarehouseItem> incomingItemsQueue;`: Declared as `Queue` interface, initialized with `LinkedList` which implements `Queue`. This correctly uses `Queue` for FIFO (First-In, First-Out) behavior, where items are processed in the order they arrive. `offer()` is used to add items and `poll()` to remove from the head.
 *         *   `private List<String> processingStations;`: Declared as `List` interface, initialized with `ArrayList`. This demonstrates using the `List` interface type while implementing with `ArrayList`, suitable for storing a dynamic collection of station names.
 *     *   **`Scanner`:** `private Scanner scanner;` is initialized to read user input from `System.in`. It's used across different methods (`addIncomingItem`, `runSimulation`). The `finally` block in `runSimulation` ensures `scanner.close()` is called to release system resources.
 *     *   **Menu and `switch`:** The `runSimulation` method contains the main loop. `displayMenu()` prints options to `System.out`. User input is read, and a `switch` statement directs execution to the appropriate method (`addIncomingItem`, `processNextItem`, `viewWarehouseStatus`) based on the user's integer choice. The `default` case handles invalid menu numbers.
 *     *   **`System.out` and `System.err`:**
 *         *   `System.out` is used for all standard output: displaying the menu, prompts, success messages, and warehouse status.
 *         *   `System.err` is strictly used for error messages, such as invalid user input or attempting to process items when the queue is empty. This separates normal program flow information from errors.
 *     *   **Exception Handling (`try-catch`) and Input Validation:**
 *         *   A large `try-catch(Exception e)` block wraps the main `while` loop in `runSimulation`. This provides a class-wide catch for any unexpected runtime errors during the simulation.
 *         *   More specific input validation is implemented before reading the integer menu choice using `scanner.hasNextInt()` and consuming invalid input with `scanner.next()`. This handles `InputMismatchException` gracefully for the menu choice.
 *         *   Within `addIncomingItem`, a check is added to ensure the item name is not empty.
 *         *   Within `processNextItem`, `incomingItemsQueue.isEmpty()` is checked *before* calling `poll()` to prevent a `NoSuchElementException` and provide a user-friendly error message via `System.err`.
 *     *   **Best Practices:**
 *         *   **Encapsulation:** Fields are private, access is through public methods.
 *         *   **Naming:** Variables (`incomingItemsQueue`, `processingStations`, `nextItemId`), methods (`runSimulation`, `addIncomingItem`, `processNextItem`, `viewWarehouseStatus`), and classes (`WarehouseItem`, `WarehouseSimulation`) have clear, descriptive names.
 *         *   **Comments:** Javadoc-style comments explain the purpose of classes and methods, and inline comments clarify specific logic.
 *         *   **Clean Code:** Methods are relatively short and focused on a single task. The code is structured logically.
 * 
 * This solution effectively combines the required Java components within a practical scenario, demonstrating understanding of data structures, control flow, user interaction, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents an item in the warehouse
class WarehouseItem {
    private int itemId;
    private String itemName;
    private String status; // e.g., "Waiting", "Processed"

    // Constructor
    public WarehouseItem(int itemId, String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.status = "Waiting"; // Initial status
    }

    // Getters
    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getStatus() {
        return status;
    }

    // Setter for status (if needed, but for this problem, removal from queue implies processing)
    public void setStatus(String status) {
        this.status = status;
    }

    // String representation of the item
    @Override
    public String toString() {
        return "Item [ID=" + itemId + ", Name='" + itemName + "', Status='" + status + "']";
    }
}

// Main class for the warehouse simulation
public class WarehouseSimulation {

    // Required Data Structures
    private Queue<WarehouseItem> incomingItemsQueue;
    private List<String> processingStations;
    private Scanner scanner;

    // Counter for generating unique item IDs
    private static int nextItemId = 1;

    // Constructor
    public WarehouseSimulation() {
        // Initialize the queue using LinkedList (implements Queue)
        incomingItemsQueue = new LinkedList<>();
        // Initialize the list of processing stations using ArrayList
        processingStations = new ArrayList<>();
        // Add some default processing stations
        processingStations.add("Station A");
        processingStations.add("Station B");
        processingStations.add("Station C");

        // Initialize the scanner
        scanner = new Scanner(System.in);
    }

    // Displays the main menu
    private void displayMenu() {
        System.out.println("\n--- Warehouse Simulation Menu ---");
        System.out.println("1. Add Incoming Item");
        System.out.println("2. Process Next Item");
        System.out.println("3. View Warehouse Status");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    // Adds a new item to the incoming queue
    private void addIncomingItem() {
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        if (itemName == null || itemName.trim().isEmpty()) {
            System.err.println("Error: Item name cannot be empty.");
            return;
        }

        WarehouseItem newItem = new WarehouseItem(nextItemId++, itemName.trim());
        incomingItemsQueue.offer(newItem); // offer is generally preferred over add for queues
        System.out.println(newItem.getItemName() + " (ID: " + newItem.getItemId() + ") added to the incoming queue.");
    }

    // Processes the next item from the queue
    private void processNextItem() {
        if (incomingItemsQueue.isEmpty()) {
            System.err.println("Error: The incoming queue is empty. No items to process.");
            return;
        }

        // Poll the next item from the queue (removes and returns the head)
        WarehouseItem itemToProcess = incomingItemsQueue.poll();

        // In a real scenario, you might assign it to a station,
        // but for this simulation, simply removing from queue signifies processing
        System.out.println("Processing item: " + itemToProcess.getItemName() + " (ID: " + itemToProcess.getItemId() + ")");
        // itemToProcess.setStatus("Processed"); // Could update status if item was moved to another list
        System.out.println("Item ID " + itemToProcess.getItemId() + " successfully processed.");
    }

    // Views the current status of the queue and stations
    private void viewWarehouseStatus() {
        System.out.println("\n--- Current Warehouse Status ---");

        // Display Incoming Queue Status
        System.out.println("Incoming Items Queue (" + incomingItemsQueue.size() + " items):");
        if (incomingItemsQueue.isEmpty()) {
            System.out.println("  Queue is empty.");
        } else {
            // Iterate through the queue without removing elements (using peek or iterator)
            int index = 1;
            for (WarehouseItem item : incomingItemsQueue) {
                System.out.println("  " + index++ + ". " + item);
            }
        }

        // Display Processing Stations
        System.out.println("\nProcessing Stations (" + processingStations.size() + "):");
        if (processingStations.isEmpty()) {
            System.out.println("  No processing stations defined.");
        } else {
            for (String station : processingStations) {
                System.out.println("  - " + station);
            }
        }
        System.out.println("--------------------------------");
    }

    // Runs the main simulation loop
    public void runSimulation() {
        int choice = -1;
        // Class-wide exception handling for the main loop
        try {
            while (choice != 4) {
                displayMenu();

                // Input validation loop for menu choice
                while (!scanner.hasNextInt()) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the non-integer input
                    displayMenu(); // Redisplay menu
                }
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading the integer

                // Use switch statement for menu control
                switch (choice) {
                    case 1:
                        addIncomingItem();
                        break;
                    case 2:
                        processNextItem();
                        break;
                    case 3:
                        viewWarehouseStatus();
                        break;
                    case 4:
                        System.out.println("Exiting Warehouse Simulation. Goodbye!");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        } catch (InputMismatchException e) {
            // This catch is less likely with the input validation loop above,
            // but good practice for robustness, catching unexpected scanner issues.
            System.err.println("A serious input error occurred: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions during simulation execution
            System.err.println("An unexpected error occurred during simulation: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure the scanner is closed regardless of how the loop exits
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Scanner closed."); // Indicate closure
        }
    }

    // Main method to start the simulation
    public static void main(String[] args) {
        WarehouseSimulation simulation = new WarehouseSimulation();
        simulation.runSimulation();
    }
}
