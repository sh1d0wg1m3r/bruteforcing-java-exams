/*
 * Exam Question #490
 * Generated on: 2025-05-11 23:18:47
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Warehouse Management System Simulation**
 * 
 * You are tasked with developing a simplified Warehouse Management System. The system needs to track inventory, manage incoming shipment orders, and process these orders based on item availability.
 * 
 * **Requirements:**
 * 
 * 1.  **Inventory:** Maintain a list of items currently in the warehouse. Each item should have an ID (String), Name (String), and Quantity (int).
 * 2.  **Shipment Orders:** Manage a queue of pending shipment orders. Each order requests specific quantities of one or more items. Orders must be processed in the order they are received (FIFO).
 * 3.  **User Interface:** Provide a command-line interface using `java.util.Scanner` to interact with the system.
 * 4.  **Commands:** The system should support the following commands:
 *     *   `ADD_ITEM <itemId> <itemName> <quantity>`: Adds a new item to inventory or updates the quantity if the item already exists. Quantity must be positive.
 *     *   `PLACE_ORDER <itemId1>:<quantity1> [<itemId2>:<quantity2> ...]`: Creates a new shipment order for the specified items and quantities and adds it to the order queue. Quantities must be positive.
 *     *   `PROCESS_ORDER`: Attempts to process the next order in the queue. An order can only be processed if *all* requested items are available in sufficient quantity in the inventory. If successful, the items are deducted from inventory, and the order is removed from the queue. If unsuccessful (due to insufficient stock for *any* item), the order remains in the queue, and an error message is displayed.
 *     *   `VIEW_INVENTORY`: Displays the current list of items and their quantities in the inventory.
 *     *   `VIEW_QUEUE`: Displays the current orders waiting in the shipment queue.
 *     *   `EXIT`: Terminates the program.
 * 5.  **Error Handling:**
 *     *   Use `System.err` to print error messages (e.g., invalid command format, invalid quantity, item not found during order placement, insufficient stock during processing).
 *     *   Use `System.out` for all normal output (command prompts, success messages, inventory/queue views).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle unexpected issues during command processing (e.g., incorrect input types from Scanner).
 * 6.  **Data Structures:**
 *     *   Use `java.util.Queue` for the shipment order queue.
 *     *   Use `java.util.ArrayList` as the underlying implementation for the inventory, accessed via the `java.util.List` interface.
 * 7.  **Control Flow:** Use a `switch` statement to handle different user commands.
 * 8.  **Best Practices:**
 *     *   Implement proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadocs where applicable, inline comments for complex logic).
 *     *   Validate user input where necessary (e.g., positive quantities, valid command format).
 *     *   Ensure clean code structure.
 * 
 * **Expected Output:**
 * 
 * *   Command prompts and normal information should go to `System.out`.
 * *   Error messages (invalid input, insufficient stock, etc.) should go to `System.err`.
 * *   `VIEW_INVENTORY` should list items with ID, Name, and Quantity.
 * *   `VIEW_QUEUE` should list orders in the queue, perhaps showing the items requested in each.
 * *   `PROCESS_ORDER` success should print a confirmation to `System.out`. Failure should print an error to `System.err` explaining why.
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * Enter command: ADD_ITEM A1 ItemA 100
 * Item A1 (ItemA) added/updated with quantity 100.
 * 
 * Enter command: ADD_ITEM B2 ItemB 50
 * Item B2 (ItemB) added/updated with quantity 50.
 * 
 * Enter command: VIEW_INVENTORY
 * Inventory:
 * ID: A1, Name: ItemA, Quantity: 100
 * ID: B2, Name: ItemB, Quantity: 50
 * 
 * Enter command: PLACE_ORDER A1:10 B2:20
 * Order 1 placed with items: {A1=10, B2=20}.
 * 
 * Enter command: PLACE_ORDER A1:120
 * Order 2 placed with items: {A1=120}.
 * 
 * Enter command: VIEW_QUEUE
 * Order Queue:
 * Order 1: {A1=10, B2=20}
 * Order 2: {A1=120}
 * 
 * Enter command: PROCESS_ORDER
 * Processing Order 1...
 * Order 1 processed successfully. Inventory updated.
 * 
 * Enter command: VIEW_INVENTORY
 * Inventory:
 * ID: A1, Name: ItemA, Quantity: 90
 * ID: B2, Name: ItemB, Quantity: 30
 * 
 * Enter command: PROCESS_ORDER
 * Processing Order 2...
 * Error processing Order 2: Insufficient stock for item A1. Required: 120, Available: 90. Order remains in queue.
 * 
 * Enter command: VIEW_QUEUE
 * Order Queue:
 * Order 2: {A1=120}
 * 
 * Enter command: EXIT
 * Exiting Warehouse Management System.
 * ```
 * 
 * Implement the `WarehouseManagementSystem` class with the required functionality.
 *
 * EXPLANATION:
 * The provided solution implements a basic Warehouse Management System simulation, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `WarehouseItem`: A simple class to represent an item with encapsulated fields (`itemId`, `itemName`, `quantity`), getters, a setter for quantity, and a `toString` method. Includes basic validation in the constructor and setter.
 *     *   `ShipmentOrder`: Represents an order containing a `Map` of item IDs to requested quantities. It includes a simple static counter to generate unique order IDs and provides encapsulated access to its data. Includes basic validation for positive quantities.
 *     *   `WarehouseManagementSystem`: The main class that orchestrates the system logic. It holds the inventory (`List<WarehouseItem>`) and the order queue (`Queue<ShipmentOrder>`). It contains methods for each command (`addItemToInventory`, `placeOrder`, `processNextOrder`, `viewInventory`, `viewOrderQueue`) and a `run` method for the main command loop.
 * 
 * 2.  **Required Components Usage:**
 *     *   `Queue (java.util.Queue)`: The `orderQueue` is declared as `Queue<ShipmentOrder>` and implemented using `java.util.LinkedList`. `offer()` is used to add orders, `peek()` is used to view the next order without removing it, and `poll()` is used to remove and retrieve the order after successful processing. This fulfills the FIFO requirement.
 *     *   `ArrayList (java.util.ArrayList)`: The `inventory` is initialized as `new ArrayList<>()`.
 *     *   `List interface (java.util.List)`: The `inventory` is declared as `List<WarehouseItem>`, demonstrating programming to the interface rather than the specific implementation (`ArrayList`).
 *     *   `Scanner for user input (java.util.Scanner)`: A `Scanner` object reads user commands from `System.in` line by line.
 *     *   `Switch statement`: The `run` method uses a `switch` statement on the command string (`parts[0].toUpperCase()`) to direct execution to the appropriate logic block.
 *     *   `System.err for error messages`: `System.err.println()` is used specifically for printing error messages related to invalid input, command format issues, item not found, or insufficient stock during order processing.
 *     *   `System.out for normal output`: `System.out.println()` is used for command prompts, success messages, and displaying the inventory and order queue status.
 *     *   Class-wide exception handling with `try-catch`: A large `try-catch(Exception e)` block is placed around the core logic within the `while` loop in the `run` method. This catches potential `NumberFormatException` during parsing, potential `InputMismatchException` from `Scanner` (though less likely with `nextLine`), and any other unexpected runtime exceptions that might occur during command execution, preventing the program from crashing and providing an error message via `System.err`. More specific catches like `NumberFormatException` are also included for clearer error messages.
 * 
 * 3.  **Logic and Flow:**
 *     *   The `run` method continuously reads commands until "EXIT" is entered.
 *     *   The `switch` statement dispatches based on the command.
 *     *   `ADD_ITEM`: Parses arguments, finds the item by ID. If found, updates quantity. If not, creates a new `WarehouseItem` and adds it to the `inventory List`. Includes validation for positive quantity and uses `System.err` for errors.
 *     *   `PLACE_ORDER`: Parses arguments to build a `Map<String, Integer>` of items and quantities. Creates a `ShipmentOrder` and adds it to the `orderQueue Queue` using `offer()`. Includes basic format and quantity validation.
 *     *   `PROCESS_ORDER`: Uses `peek()` to look at the next order. If an order exists, it first iterates through the items requested in the order and checks against the `inventory List` using `findItemById()`. This check is "all or nothing" - if any item is missing or has insufficient stock, the `canProcess` flag is set to `false`. If `canProcess` is true after checking all items, `poll()` removes the order from the queue, and the inventory quantities are updated. If `canProcess` is false, an error message is printed to `System.err`, and the order remains in the queue.
 *     *   `VIEW_INVENTORY`: Iterates through the `inventory List` and prints each `WarehouseItem`.
 *     *   `VIEW_QUEUE`: Iterates through the `orderQueue Queue` (which is possible because `LinkedList` implements `Iterable`) and prints each `ShipmentOrder`.
 * 
 * 4.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `WarehouseItem`, `ShipmentOrder`, and `WarehouseManagementSystem` are `private`. Access and modification are done through `public` methods.
 *     *   **Meaningful Names:** Variables (`itemId`, `itemsToShip`, `orderQueue`), methods (`addItemToInventory`, `processNextOrder`), and classes are named descriptively.
 *     *   **Comments and Documentation:** Javadoc comments are included for classes and public methods. Inline comments explain specific logic blocks (like the two-step process in `processNextOrder`).
 *     *   **Input Validation:** Quantities are checked to be positive. Command argument counts and formats are checked. Error messages for invalid input go to `System.err`.
 *     *   **Error Handling:** `try-catch` handles parsing and unexpected errors. Specific checks handle business logic errors (insufficient stock, empty queue, invalid command format), reporting them via `System.err`.
 *     *   **Clean Code:** The code is structured into logical methods, separating concerns (input handling in `run`, core logic in other methods).
 * 
 * This solution effectively combines the required Java components in a practical scenario, demonstrating understanding of data structures, control flow, object-oriented principles, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Represents an item in the warehouse inventory.
 */
class WarehouseItem {
    private String itemId;
    private String itemName;
    private int quantity;

    public WarehouseItem(String itemId, String itemName, int quantity) {
        if (itemId == null || itemId.trim().isEmpty() || itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item ID and Name cannot be empty.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.itemId = itemId.trim();
        this.itemName = itemName.trim();
        this.quantity = quantity;
    }

    // Getters
    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity (used when adding/updating inventory or processing orders)
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID: " + itemId + ", Name: " + itemName + ", Quantity: " + quantity;
    }
}

/**
 * Represents a shipment order requesting specific items.
 */
class ShipmentOrder {
    private static int nextOrderId = 1; // Simple counter for unique order IDs
    private int orderId;
    private Map<String, Integer> itemsToShip; // Map of itemId -> quantity

    public ShipmentOrder(Map<String, Integer> itemsToShip) {
        if (itemsToShip == null || itemsToShip.isEmpty()) {
            throw new IllegalArgumentException("Order must contain items.");
        }
        // Validate quantities are positive
        for (int quantity : itemsToShip.values()) {
            if (quantity <= 0) {
                throw new IllegalArgumentException("Order quantities must be positive.");
            }
        }
        this.orderId = nextOrderId++;
        this.itemsToShip = new HashMap<>(itemsToShip); // Create a defensive copy
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public Map<String, Integer> getItemsToShip() {
        return new HashMap<>(itemsToShip); // Return a defensive copy
    }

    @Override
    public String toString() {
        return "Order " + orderId + ": " + itemsToShip;
    }
}

/**
 * Manages the warehouse inventory and shipment order processing.
 */
public class WarehouseManagementSystem {

    // Inventory stored as a List of WarehouseItem objects
    private List<WarehouseItem> inventory;

    // Shipment orders stored in a Queue for FIFO processing
    private Queue<ShipmentOrder> orderQueue;

    private Scanner scanner;

    /**
     * Constructs a new WarehouseManagementSystem.
     */
    public WarehouseManagementSystem() {
        // Use ArrayList for inventory, accessed via List interface
        this.inventory = new ArrayList<>();
        // Use LinkedList as a Queue implementation for orders
        this.orderQueue = new LinkedList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new item to inventory or updates an existing one.
     *
     * @param itemId   The ID of the item.
     * @param itemName The name of the item.
     * @param quantity The quantity to add/set.
     */
    public void addItemToInventory(String itemId, String itemName, int quantity) {
        if (quantity <= 0) {
            System.err.println("Error: Quantity must be positive.");
            return;
        }

        // Check if item already exists
        WarehouseItem existingItem = findItemById(itemId);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            System.out.println("Item " + itemId + " (" + itemName + ") quantity updated to " + existingItem.getQuantity() + ".");
        } else {
            try {
                WarehouseItem newItem = new WarehouseItem(itemId, itemName, quantity);
                inventory.add(newItem);
                System.out.println("Item " + itemId + " (" + itemName + ") added with quantity " + quantity + ".");
            } catch (IllegalArgumentException e) {
                System.err.println("Error adding item: " + e.getMessage());
            }
        }
    }

    /**
     * Finds a WarehouseItem in the inventory by its ID.
     *
     * @param itemId The ID of the item to find.
     * @return The WarehouseItem if found, otherwise null.
     */
    private WarehouseItem findItemById(String itemId) {
        for (WarehouseItem item : inventory) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Places a new shipment order and adds it to the queue.
     *
     * @param itemsToShip A map of item IDs and quantities for the order.
     */
    public void placeOrder(Map<String, Integer> itemsToShip) {
        if (itemsToShip.isEmpty()) {
            System.err.println("Error: Cannot place an empty order.");
            return;
        }

        // Basic validation: check if items in order exist in inventory (optional but good practice)
        // For this problem, we'll allow placing orders for non-existent items,
        // and the check will happen during processing.
        try {
            ShipmentOrder newOrder = new ShipmentOrder(itemsToShip);
            orderQueue.offer(newOrder); // Add to the end of the queue
            System.out.println("Order " + newOrder.getOrderId() + " placed with items: " + itemsToShip + ".");
        } catch (IllegalArgumentException e) {
             System.err.println("Error placing order: " + e.getMessage());
        }
    }

    /**
     * Attempts to process the next order in the queue (FIFO).
     * Checks inventory first before processing.
     */
    public void processNextOrder() {
        // Use peek() to look at the head without removing it
        ShipmentOrder nextOrder = orderQueue.peek();

        if (nextOrder == null) {
            System.out.println("No pending orders in the queue.");
            return;
        }

        System.out.println("Processing Order " + nextOrder.getOrderId() + "...");

        // Step 1: Check if all items in the order are available in sufficient quantity
        Map<String, Integer> itemsRequested = nextOrder.getItemsToShip();
        boolean canProcess = true;
        String failureReason = "";

        for (Map.Entry<String, Integer> entry : itemsRequested.entrySet()) {
            String itemId = entry.getKey();
            int requestedQuantity = entry.getValue();

            WarehouseItem itemInInventory = findItemById(itemId);

            if (itemInInventory == null) {
                canProcess = false;
                failureReason = "Item " + itemId + " not found in inventory.";
                break; // Stop checking, order cannot be processed
            }

            if (itemInInventory.getQuantity() < requestedQuantity) {
                canProcess = false;
                failureReason = "Insufficient stock for item " + itemId + ". Required: " + requestedQuantity + ", Available: " + itemInInventory.getQuantity() + ".";
                break; // Stop checking, order cannot be processed
            }
        }

        // Step 2: Process or fail based on the check
        if (canProcess) {
            // Remove the order from the queue using poll()
            orderQueue.poll();

            // Update inventory quantities
            for (Map.Entry<String, Integer> entry : itemsRequested.entrySet()) {
                String itemId = entry.getKey();
                int requestedQuantity = entry.getValue();

                WarehouseItem itemInInventory = findItemById(itemId);
                // This should not be null based on the check above, but defensive coding is good
                if (itemInInventory != null) {
                    itemInInventory.setQuantity(itemInInventory.getQuantity() - requestedQuantity);
                }
            }
            System.out.println("Order " + nextOrder.getOrderId() + " processed successfully. Inventory updated.");
        } else {
            // Order remains in the queue
            System.err.println("Error processing Order " + nextOrder.getOrderId() + ": " + failureReason + " Order remains in queue.");
        }
    }

    /**
     * Displays the current inventory status.
     */
    public void viewInventory() {
        System.out.println("Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("  Inventory is empty.");
        } else {
            for (WarehouseItem item : inventory) {
                System.out.println("  " + item);
            }
        }
    }

    /**
     * Displays the current orders in the queue.
     */
    public void viewOrderQueue() {
        System.out.println("Order Queue:");
        if (orderQueue.isEmpty()) {
            System.out.println("  Order queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            for (ShipmentOrder order : orderQueue) {
                System.out.println("  " + order);
            }
        }
    }

    /**
     * Runs the main command-line interface loop.
     * Includes class-wide exception handling.
     */
    public void run() {
        System.out.println("Warehouse Management System started. Enter commands (ADD_ITEM, PLACE_ORDER, PROCESS_ORDER, VIEW_INVENTORY, VIEW_QUEUE, EXIT).");

        boolean running = true;
        while (running) {
            System.out.print("\nEnter command: ");
            String inputLine = scanner.nextLine().trim();
            String[] parts = inputLine.split("\\s+"); // Split by one or more spaces
            String command = parts[0].toUpperCase();

            // Class-wide exception handling for the command processing loop
            try {
                switch (command) {
                    case "ADD_ITEM":
                        if (parts.length == 4) {
                            String itemId = parts[1];
                            String itemName = parts[2];
                            int quantity = Integer.parseInt(parts[3]);
                            addItemToInventory(itemId, itemName, quantity);
                        } else {
                            System.err.println("Error: Invalid ADD_ITEM command format. Usage: ADD_ITEM <itemId> <itemName> <quantity>");
                        }
                        break;

                    case "PLACE_ORDER":
                        if (parts.length >= 2) {
                            Map<String, Integer> itemsToShip = new HashMap<>();
                            boolean validOrderItems = true;
                            for (int i = 1; i < parts.length; i++) {
                                String[] itemParts = parts[i].split(":");
                                if (itemParts.length == 2) {
                                    String itemId = itemParts[0];
                                    try {
                                        int quantity = Integer.parseInt(itemParts[1]);
                                        if (quantity <= 0) {
                                             System.err.println("Error: Invalid quantity for item " + itemId + ". Quantity must be positive.");
                                             validOrderItems = false;
                                             break;
                                        }
                                        itemsToShip.put(itemId, quantity);
                                    } catch (NumberFormatException e) {
                                        System.err.println("Error: Invalid quantity format for item " + itemId + ".");
                                        validOrderItems = false;
                                        break;
                                    }
                                } else {
                                    System.err.println("Error: Invalid item format in PLACE_ORDER. Use itemId:quantity.");
                                    validOrderItems = false;
                                    break;
                                }
                            }
                            if (validOrderItems && !itemsToShip.isEmpty()) {
                                placeOrder(itemsToShip);
                            } else if (itemsToShip.isEmpty() && validOrderItems) {
                                System.err.println("Error: PLACE_ORDER command must specify at least one item.");
                            }

                        } else {
                            System.err.println("Error: Invalid PLACE_ORDER command format. Usage: PLACE_ORDER <itemId1>:<quantity1> [<itemId2>:<quantity2> ...]");
                        }
                        break;

                    case "PROCESS_ORDER":
                        if (parts.length == 1) {
                            processNextOrder();
                        } else {
                            System.err.println("Error: PROCESS_ORDER command takes no arguments.");
                        }
                        break;

                    case "VIEW_INVENTORY":
                        if (parts.length == 1) {
                            viewInventory();
                        } else {
                            System.err.println("Error: VIEW_INVENTORY command takes no arguments.");
                        }
                        break;

                    case "VIEW_QUEUE":
                        if (parts.length == 1) {
                            viewOrderQueue();
                        } else {
                            System.err.println("Error: VIEW_QUEUE command takes no arguments.");
                        }
                        break;

                    case "EXIT":
                        if (parts.length == 1) {
                            running = false;
                            System.out.println("Exiting Warehouse Management System.");
                        } else {
                            System.err.println("Error: EXIT command takes no arguments.");
                        }
                        break;

                    default:
                        System.err.println("Error: Unknown command '" + command + "'.");
                        break;
                }
            } catch (NumberFormatException e) {
                // Catch errors from Integer.parseInt
                System.err.println("Error: Invalid number format provided. " + e.getMessage());
            } catch (InputMismatchException e) {
                 // Catch potential Scanner issues (less likely with nextLine but good practice)
                 System.err.println("Error: Invalid input type. " + e.getMessage());
                 scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions during command processing
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging in exam context
            }
        }

        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the Warehouse Management System.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        WarehouseManagementSystem system = new WarehouseManagementSystem();
        system.run();
    }
}
