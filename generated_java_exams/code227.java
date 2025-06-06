/*
 * Exam Question #227
 * Generated on: 2025-05-11 22:35:27
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Java Programming Exam Task: Warehouse Picking System**
 * 
 * **Scenario:**
 * You are tasked with creating a simplified console-based application to simulate a warehouse picking system. The system manages a list of inventory items and processes customer orders from a queue. Orders are picked one at a time based on their arrival time (FIFO).
 * 
 * **Requirements:**
 * 
 * 1.  **Core Entities:**
 *     *   `Item`: Represents a product in the warehouse. Should have properties: `itemId` (String), `name` (String), and `stock` (int).
 *     *   `OrderItem`: Represents a specific item and quantity requested within a customer order. Should have properties: `itemId` (String) and `quantity` (int).
 *     *   `Order`: Represents a customer order. Should have properties: `orderId` (String) and a collection of `OrderItem`s.
 *     *   `Warehouse`: Manages the overall state, including the inventory and the order queue.
 * 
 * 2.  **Functionality:**
 *     *   **Add Item to Inventory:** Allow the user to add new items to the warehouse inventory. Validate that the `itemId` is unique and the initial `stock` is positive.
 *     *   **Display Inventory:** Show a list of all items in the inventory with their current stock levels.
 *     *   **Add Order to Queue:** Allow the user to create a new order by specifying an `orderId` and a list of items/quantities (`OrderItem`s). Validate that the `orderId` is unique in the queue and that all requested item IDs exist in the inventory (do NOT check stock levels at this stage). Add the valid order to the end of the processing queue.
 *     *   **Display Order Queue:** Show the list of orders currently waiting to be processed in the queue, in their current order.
 *     *   **Process Next Order:** Take the order at the front of the queue. For this order:
 *         *   Check if sufficient stock is available for *all* `OrderItem`s in the order.
 *         *   If sufficient stock for all items: Decrement the stock for each item in the inventory according to the order's quantities. Remove the order from the front of the queue. Print a success message using `System.out`.
 *         *   If insufficient stock for *any* item: Print an error message using `System.err` indicating the issue (e.g., which item failed). The order *remains* at the front of the queue (or is moved to the end, specify which in your design - moving to the end is a common pattern for failed processing, let's use that). Do NOT decrement any stock.
 *     *   **Exit:** Terminate the program.
 * 
 * 3.  **Implementation Requirements:**
 *     *   Must use `java.util.Queue` for the order processing queue (e.g., implemented by `LinkedList`).
 *     *   Must use `java.util.ArrayList` for storing the inventory items.
 *     *   Must use the `java.util.List` interface as the type declaration for the inventory and for the list of items within an `Order`.
 *     *   Must use `java.util.Scanner` to get user input from the console.
 *     *   Must use a `switch` statement for the main menu flow control.
 *     *   Must use `System.err` for displaying error messages (e.g., invalid input, item/order not found, insufficient stock).
 *     *   Must use `System.out` for displaying normal output (menu, prompts, success messages, inventory/queue listings).
 *     *   Must include class-wide exception handling using `try-catch` blocks (at least one broad catch in the main loop, plus specific catches for expected issues like invalid input format).
 * 
 * 4.  **Best Practices:**
 *     *   Implement proper encapsulation using private fields and public methods (getters, setters where necessary).
 *     *   Use meaningful variable, method, and class names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Perform input validation (check for empty strings, non-positive numbers, duplicate IDs).
 *     *   Handle errors gracefully, informing the user via `System.err`.
 *     *   Structure your code clearly into separate classes (can be in a single file for the exam).
 * 
 * **Expected Output:**
 * The program should present a menu to the user. Based on user input, it should perform the requested action, displaying appropriate messages (`System.out` for success/information, `System.err` for errors). Displaying inventory and the order queue should list the current state clearly. Processing an order should indicate success or failure and show the updated inventory/queue if successful.
 * 
 * Example Interaction Flow:
 * ```
 * --- Simple Warehouse Picking System ---
 * 
 * --- Menu ---
 * 1. Add Item to Inventory
 * 2. Display Inventory
 * 3. Add Order to Queue
 * 4. Display Order Queue
 * 5. Process Next Order
 * 0. Exit
 * ------------
 * Enter your choice: 1
 * --- Add Item ---
 * Enter Item ID: ITEM001
 * Enter Item Name: Laptop
 * Enter Initial Stock: 10
 * Item 'Laptop' (ID: ITEM001) added to inventory with stock 10.
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 1
 * --- Add Item ---
 * Enter Item ID: ITEM002
 * Enter Item Name: Mouse
 * Enter Initial Stock: 50
 * Item 'Mouse' (ID: ITEM002) added to inventory with stock 50.
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 2
 * --- Current Inventory ---
 * Item [ID=ITEM001, Name=Laptop, Stock=10]
 * Item [ID=ITEM002, Name=Mouse, Stock=50]
 * -------------------------
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 3
 * --- Add Order ---
 * Enter Order ID: ORD001
 * Add item to order (or type 'done'):
 *   Enter Item ID: ITEM001
 *   Enter Quantity: 2
 *   Item 'ITEM001' (Qty: 2) added to order.
 * Add item to order (or type 'done'):
 *   Enter Item ID: ITEM002
 *   Enter Quantity: 5
 *   Item 'ITEM002' (Qty: 5) added to order.
 * Add item to order (or type 'done'):
 *   Enter Item ID: done
 * Order 'ORD001' added to the processing queue.
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 4
 * --- Order Queue ---
 * Position 1: Order [ID=ORD001]
 *   - Item ID: ITEM001, Quantity: 2
 *   - Item ID: ITEM002, Quantity: 5
 * 
 * -------------------
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 5
 * Attempting to process Order ID: ORD001
 * Order 'ORD001' successfully processed and fulfilled.
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 2
 * --- Current Inventory ---
 * Item [ID=ITEM001, Name=Laptop, Stock=8]
 * Item [ID=ITEM002, Name=Mouse, Stock=45]
 * -------------------------
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 3
 * --- Add Order ---
 * Enter Order ID: ORD002
 * Add item to order (or type 'done'):
 *   Enter Item ID: ITEM001
 *   Enter Quantity: 10  <-- Requesting more than available
 *   Item 'ITEM001' (Qty: 10) added to order.
 * Add item to order (or type 'done'):
 *   Enter Item ID: done
 * Order 'ORD002' added to the processing queue.
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 5
 * Attempting to process Order ID: ORD002
 * Error:   Insufficient stock for Item ID 'ITEM001'. Required: 10, Available: 8
 * Error: Order 'ORD002' could not be fulfilled due to insufficient stock. Re-queueing.
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 4
 * --- Order Queue ---
 * Position 1: Order [ID=ORD002]
 *   - Item ID: ITEM001, Quantity: 10
 * 
 * -------------------
 * ... (continue with other options)
 * Enter your choice: 0
 * Exiting Warehouse System. Goodbye!
 * System terminated.
 * ```
 * 
 * This task requires integrating multiple core Java concepts and libraries to build a functional, albeit simple, system with proper error handling and data management.
 *
 * EXPLANATION:
 * The provided solution implements the Warehouse Picking System as described in the exam question, demonstrating the required Java concepts and best practices.
 * 
 * **Key Concepts and Implementation Details:**
 * 
 * 1.  **Object-Oriented Design:** The problem is broken down into logical classes: `Item`, `OrderItem`, `Order`, and `Warehouse`. The `WarehouseSystem` class contains the `main` method and handles user interaction, delegating core logic to the `Warehouse` instance. This follows good encapsulation principles, keeping data (private fields) and behavior (public methods) together within classes.
 * 
 * 2.  **Collections (`List`, `ArrayList`, `Queue`, `LinkedList`):**
 *     *   `List<Item> inventory = new ArrayList<>();`: An `ArrayList` is used to store `Item` objects, providing dynamic resizing and efficient access by index or iteration. It's declared using the `List` interface type, promoting flexibility.
 *     *   `Queue<Order> orderQueue = new LinkedList<>();`: A `LinkedList` is used to implement the `Queue` interface for managing customer orders. `LinkedList` is suitable for queue operations (`offer` to add to the end, `poll` to remove from the front) as it provides efficient insertions and removals at its ends.
 *     *   `List<OrderItem> items;` in the `Order` class: An `ArrayList` is used internally (`new ArrayList<>(items)`) to store the `OrderItem`s for a specific order, declared using the `List` interface.
 * 
 * 3.  **User Input (`Scanner`):** A `Scanner` object reads input from `System.in`. Separate `scanner.nextLine()` calls are used after `scanner.nextInt()` to consume the leftover newline character, preventing input issues in subsequent `nextLine()` calls.
 * 
 * 4.  **Flow Control (`switch`):** A `switch` statement in the `main` method handles the user's menu selection, directing the program flow to the appropriate action (adding item, displaying inventory, etc.).
 * 
 * 5.  **Output Streams (`System.out`, `System.err`):**
 *     *   `System.out.println(...)`: Used for displaying the menu, prompts, successful operations (item/order added, order processed successfully), and the contents of the inventory and order queue.
 *     *   `System.err.println(...)`: Used exclusively for reporting errors, such as invalid input, duplicate IDs, items not found, insufficient stock, or attempting operations on empty collections. This clearly distinguishes error messages from normal output.
 * 
 * 6.  **Exception Handling (`try-catch`):**
 *     *   A broad `try-catch(Exception e)` block wraps the main application loop in `main`. This provides a class-wide safety net to catch any unexpected runtime exceptions, print an error message and stack trace to `System.err`, and gracefully terminate the program.
 *     *   Specific `try-catch(InputMismatchException e)` blocks are used when reading integer input (`scanner.nextInt()`) to handle cases where the user enters non-numeric text. This prevents the program from crashing and allows it to prompt the user again after displaying an error on `System.err`.
 *     *   Input validation (checking for null, empty strings, positive numbers) is performed before attempting operations, preventing potential exceptions or incorrect logic flows.
 * 
 * 7.  **Warehouse Logic (`processNextOrder`):**
 *     *   The `processNextOrder` method is the core logic for fulfilling orders. It uses `orderQueue.poll()` to retrieve and remove the next order from the queue.
 *     *   It calls `checkStock` to verify if all items in the order can be fulfilled. `checkStock` iterates through the `OrderItem`s, finds the corresponding `Item` in the `inventory` list using the `findItemById` helper, and compares quantities. It reports specific stock issues using `System.err`.
 *     *   If `checkStock` returns `true`, the `decrementStock` helper updates the inventory levels, and the order remains removed from the queue (as `poll` already did that).
 *     *   If `checkStock` returns `false`, the order could not be fulfilled. An error message is printed to `System.err`, and the order is added back to the end of the queue using `orderQueue.offer(orderToProcess)`, adhering to the requirement of re-queueing failed orders.
 * 
 * 8.  **Input Validation and Error Handling:** Methods like `addItem`, `addOrder`, `addItemToInventory`, and `addOrderToQueue` include checks for invalid or missing input (empty strings, non-positive numbers) and business logic errors (duplicate IDs, item not found). Error messages are printed using `System.err`, and the operation is typically aborted for that specific input.
 * 
 * 9.  **Best Practices:**
 *     *   Private fields and public methods (`getters`, `setStock`) ensure data is accessed and modified in a controlled manner.
 *     *   Method and variable names are descriptive (e.g., `addItemToInventory`, `orderQueue`, `checkStock`).
 *     *   Comments explain the purpose of classes, methods, and complex logic sections.
 *     *   The code is structured logically with helper methods (`findItemById`, `checkStock`, `decrementStock`) to improve readability and maintainability.
 * 
 * This solution effectively combines the required Java components within a practical scenario, demonstrating competence in data structures, object-oriented programming, user interaction, and robust error handling.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException; // Although peek/poll handle this, good to know

/**
 * Represents a product item in the warehouse inventory.
 */
class Item {
    private String itemId;
    private String name;
    private int stock;

    /**
     * Constructs a new Item.
     * @param itemId Unique identifier for the item.
     * @param name Name of the item.
     * @param stock Initial stock quantity.
     */
    public Item(String itemId, String name, int stock) {
        this.itemId = itemId;
        this.name = name;
        this.stock = stock;
    }

    // Getters
    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public int getStock() { return stock; }

    // Setter for stock (needed to update inventory levels)
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "Item [ID=" + itemId + ", Name=" + name + ", Stock=" + stock + "]";
    }
}

/**
 * Represents a specific item and its requested quantity within a customer order.
 */
class OrderItem {
    private String itemId;
    private int quantity;

    /**
     * Constructs a new OrderItem.
     * @param itemId The ID of the item.
     * @param quantity The requested quantity.
     */
    public OrderItem(String itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    // Getters
    public String getItemId() { return itemId; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "  - Item ID: " + itemId + ", Quantity: " + quantity;
    }
}

/**
 * Represents a customer order containing multiple items.
 */
class Order {
    private String orderId;
    private List<OrderItem> items; // Use List interface

    /**
     * Constructs a new Order.
     * @param orderId Unique identifier for the order.
     * @param items List of OrderItems in the order.
     */
    public Order(String orderId, List<OrderItem> items) {
        this.orderId = orderId;
        // Create a new ArrayList from the provided list to ensure encapsulation
        this.items = new ArrayList<>(items);
    }

    // Getters
    public String getOrderId() { return orderId; }
    public List<OrderItem> getItems() { return items; } // Return reference to internal list for simplicity in exam context

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order [ID=").append(orderId).append("]\n");
        if (items != null) {
            for (OrderItem item : items) {
                sb.append(item.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}

/**
 * Manages the warehouse inventory and the order processing queue.
 */
class Warehouse {
    // Use ArrayList implementing List for inventory
    private List<Item> inventory = new ArrayList<>();
    // Use LinkedList implementing Queue for the order queue
    private Queue<Order> orderQueue = new LinkedList<>();

    /**
     * Adds a new item to the inventory.
     * Validates item ID uniqueness and initial stock.
     * @param itemId Unique identifier for the item.
     * @param name Name of the item.
     * @param stock Initial stock quantity.
     */
    public void addItem(String itemId, String name, int stock) {
        if (itemId == null || itemId.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            System.err.println("Error: Item ID and Name cannot be empty.");
            return;
        }
        if (stock <= 0) {
             System.err.println("Error: Initial stock must be positive.");
             return;
        }
        if (findItemById(itemId) != null) {
            System.err.println("Error: Item with ID '" + itemId.trim() + "' already exists.");
            return;
        }

        inventory.add(new Item(itemId.trim(), name.trim(), stock));
        System.out.println("Item '" + name.trim() + "' (ID: " + itemId.trim() + ") added to inventory with stock " + stock + ".");
    }

    /**
     * Displays the current inventory.
     */
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("\n--- Current Inventory ---");
        for (Item item : inventory) {
            System.out.println(item);
        }
        System.out.println("-------------------------");
    }

    /**
     * Adds a new customer order to the processing queue.
     * Validates order ID uniqueness and checks if requested items exist in inventory.
     * Does NOT check stock levels at this stage.
     * @param orderId Unique identifier for the order.
     * @param items List of OrderItems in the order.
     */
    public void addOrder(String orderId, List<OrderItem> items) {
         if (orderId == null || orderId.trim().isEmpty()) {
             System.err.println("Error: Order ID cannot be empty.");
             return;
         }
         if (items == null || items.isEmpty()) {
             System.err.println("Error: Order must contain items.");
             return;
         }

        // Check for duplicate order ID in the queue
        boolean orderIdExists = false;
        for (Order order : orderQueue) { // Iterate through queue elements
            if (order.getOrderId().equals(orderId.trim())) {
                orderIdExists = true;
                break;
            }
        }
        if (orderIdExists) {
            System.err.println("Error: Order with ID '" + orderId.trim() + "' is already in the queue.");
            return;
        }

        // Validate all items in the order exist in inventory and quantities are positive
        for (OrderItem orderItem : items) {
            if (orderItem.getQuantity() <= 0) {
                 System.err.println("Error: Quantity for item ID '" + orderItem.getItemId() + "' must be positive. Order not added.");
                 return; // Reject the whole order if any quantity is invalid
            }
            if (findItemById(orderItem.getItemId()) == null) {
                System.err.println("Error: Item with ID '" + orderItem.getItemId() + "' requested in order '" + orderId.trim() + "' does not exist in inventory. Order not added.");
                return; // Reject the whole order if any item is not found
            }
        }

        orderQueue.offer(new Order(orderId.trim(), items)); // Add to the end of the queue
        System.out.println("Order '" + orderId.trim() + "' added to the processing queue.");
    }

    /**
     * Displays the current orders waiting in the processing queue.
     */
    public void displayOrderQueue() {
        if (orderQueue.isEmpty()) {
            System.out.println("Order queue is empty.");
            return;
        }
        System.out.println("\n--- Order Queue ---");
        // Iterate through queue elements without removing them
        int index = 1;
        for (Order order : orderQueue) {
            System.out.println("Position " + index++ + ": " + order);
        }
        System.out.println("-------------------");
    }

    /**
     * Processes the next order in the queue.
     * Attempts to poll the order, checks stock, decrements if sufficient, or re-queues if insufficient.
     */
    public void processNextOrder() {
        Order orderToProcess = orderQueue.poll(); // Attempt to remove from the front

        if (orderToProcess == null) {
            System.err.println("Error: Order queue is empty. No orders to process.");
            return;
        }

        System.out.println("\nAttempting to process Order ID: " + orderToProcess.getOrderId());

        if (checkStock(orderToProcess)) {
            // Sufficient stock, process the order
            decrementStock(orderToProcess);
            // Order is already removed by poll()
            System.out.println("Order '" + orderToProcess.getOrderId() + "' successfully processed and fulfilled.");
        } else {
            // Insufficient stock for at least one item
            // checkStock already printed specific item errors via System.err
            System.err.println("Order '" + orderToProcess.getOrderId() + "' could not be fulfilled due to insufficient stock. Re-queueing.");
            orderQueue.offer(orderToProcess); // Add back to the end of the queue
        }
    }

    /**
     * Helper method to find an item in the inventory by its ID.
     * @param itemId The ID of the item to find.
     * @return The Item object if found, null otherwise.
     */
    private Item findItemById(String itemId) {
        if (itemId == null) return null;
        for (Item item : inventory) {
            if (item.getItemId().equals(itemId.trim())) {
                return item;
            }
        }
        return null;
    }

    /**
     * Helper method to check if sufficient stock exists for all items in an order.
     * Prints error messages using System.err if stock is insufficient for any item.
     * @param order The order to check.
     * @return true if sufficient stock exists for all items, false otherwise.
     */
    private boolean checkStock(Order order) {
        if (order == null || order.getItems() == null) return false; // Should not happen with proper order creation

        boolean allStockAvailable = true;
        for (OrderItem orderItem : order.getItems()) {
            Item inventoryItem = findItemById(orderItem.getItemId());
            // Item existence validated during addOrder, this check is a safeguard.
            if (inventoryItem == null) {
                 System.err.println("Internal Error: Item '" + orderItem.getItemId() + "' in order '" + order.getOrderId() + "' not found in inventory during stock check.");
                 allStockAvailable = false; // Indicate failure but continue checking others for full report
                 continue;
            }
            if (inventoryItem.getStock() < orderItem.getQuantity()) {
                System.err.println("  Insufficient stock for Item ID '" + orderItem.getItemId() + "'. Required: " + orderItem.getQuantity() + ", Available: " + inventoryItem.getStock());
                allStockAvailable = false; // Indicate failure
            }
        }
        return allStockAvailable; // Return overall result
    }

    /**
     * Helper method to decrement stock for all items in a successfully processed order.
     * Assumes checkStock(order) returned true before calling this.
     * @param order The order for which to decrement stock.
     */
    private void decrementStock(Order order) {
        if (order == null || order.getItems() == null) return;

        for (OrderItem orderItem : order.getItems()) {
            Item inventoryItem = findItemById(orderItem.getItemId());
            // Should always be found and have sufficient stock based on checkStock pre-condition
             if (inventoryItem != null) {
                inventoryItem.setStock(inventoryItem.getStock() - orderItem.getQuantity());
            }
        }
    }
}

/**
 * Main class for the Warehouse Picking System application.
 * Handles user interaction and the main application loop.
 */
public class WarehouseSystem {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        // Scanner should ideally be closed in a finally block
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Simple Warehouse Picking System ---");

        // Class-wide exception handling for the main application loop
        try {
            boolean running = true;
            while (running) {
                printMenu();
                System.out.print("Enter your choice: ");
                int choice = -1;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                } catch (InputMismatchException e) {
                    // Handle non-integer input specifically
                    System.err.println("Invalid input. Please enter a number from the menu.");
                    scanner.nextLine(); // Consume the invalid input line to prevent infinite loop
                    continue; // Skip the rest of the loop iteration and show menu again
                }

                // Switch statement for main menu flow control
                switch (choice) {
                    case 1: // Add Item to Inventory
                        addItemToInventory(scanner, warehouse);
                        break;
                    case 2: // Display Inventory
                        warehouse.displayInventory();
                        break;
                    case 3: // Add Order to Queue
                        addOrderToQueue(scanner, warehouse);
                        break;
                    case 4: // Display Order Queue
                        warehouse.displayOrderQueue();
                        break;
                    case 5: // Process Next Order
                        warehouse.processNextOrder();
                        break;
                    case 0: // Exit
                        System.out.println("Exiting Warehouse System. Goodbye!");
                        running = false;
                        break;
                    default:
                        // Handle choices outside the defined range
                        System.err.println("Invalid choice. Please enter a number from the menu.");
                }
                 System.out.println(); // Add a blank line for better readability between actions
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions during the main loop execution
            System.err.println("\nAn unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to the error stream for debugging
        } finally {
            // Ensure the scanner resource is closed properly
            if (scanner != null) {
                scanner.close();
            }
             System.out.println("System terminated.");
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add Item to Inventory");
        System.out.println("2. Display Inventory");
        System.out.println("3. Add Order to Queue");
        System.out.println("4. Display Order Queue");
        System.out.println("5. Process Next Order");
        System.out.println("0. Exit");
        System.out.println("------------");
    }

    /**
     * Handles user input for adding an item and calls the warehouse method.
     * @param scanner The Scanner object for input.
     * @param warehouse The Warehouse instance.
     */
    private static void addItemToInventory(Scanner scanner, Warehouse warehouse) {
        System.out.println("\n--- Add Item ---");
        System.out.print("Enter Item ID: ");
        String id = scanner.nextLine(); // Read full line
        System.out.print("Enter Item Name: ");
        String name = scanner.nextLine(); // Read full line
        int stock = -1;
        System.out.print("Enter Initial Stock: ");
        try {
            stock = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            // Pass potentially untrimmed input to warehouse method for validation
            warehouse.addItem(id, name, stock);
        } catch (InputMismatchException e) {
            System.err.println("Invalid input for stock. Please enter a whole number.");
            scanner.nextLine(); // Consume invalid input line
        }
    }

    /**
     * Handles user input for creating an order and adds it to the warehouse queue.
     * Allows adding multiple items to a single order.
     * @param scanner The Scanner object for input.
     * @param warehouse The Warehouse instance.
     */
    private static void addOrderToQueue(Scanner scanner, Warehouse warehouse) {
        System.out.println("\n--- Add Order ---");
        System.out.print("Enter Order ID: ");
        String orderId = scanner.nextLine(); // Read full line

        List<OrderItem> items = new ArrayList<>(); // Use ArrayList implementing List
        boolean addingItems = true;
        while(addingItems) {
            System.out.println("Add item to order (or type 'done' for Item ID):");
            System.out.print("  Enter Item ID: ");
            String itemId = scanner.nextLine(); // Read full line
            if (itemId.trim().equalsIgnoreCase("done")) {
                addingItems = false;
                break;
            }

            int quantity = -1;
            System.out.print("  Enter Quantity: ");
            try {
                quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Basic quantity validation here, more thorough validation in Warehouse.addOrder
                if (quantity > 0) {
                    items.add(new OrderItem(itemId.trim(), quantity));
                    System.out.println("  Item '" + itemId.trim() + "' (Qty: " + quantity + ") added to order build list.");
                } else {
                    System.err.println("  Error: Quantity must be positive. Item not added to order build list.");
                }

            } catch (InputMismatchException e) {
                System.err.println("  Invalid input for quantity. Please enter a whole number. Item not added to order build list.");
                scanner.nextLine(); // Consume invalid input
            }
        }

        // Only attempt to add the order if at least one item was successfully added to the list
        if (!items.isEmpty()) {
            // Pass potentially untrimmed orderId to warehouse method for validation
            warehouse.addOrder(orderId, items);
        } else {
             System.err.println("Order creation cancelled or no valid items were added to the order.");
        }
    }
}
