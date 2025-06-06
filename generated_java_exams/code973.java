/*
 * Exam Question #973
 * Generated on: 2025-05-12 17:07:11
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Warehouse Order Processing System**
 * 
 * You are tasked with developing a simplified system for managing inventory and processing customer orders in a small warehouse. The system should handle incoming orders in the sequence they are received and update inventory levels upon successful processing.
 * 
 * **System Requirements:**
 * 
 * 1.  **Inventory Management:**
 *     *   Maintain a list of products in the warehouse. Each product has a unique ID (String), a name (String), and a current quantity (int).
 *     *   Allow adding new products or updating the quantity of existing products.
 * 
 * 2.  **Order Management:**
 *     *   Maintain a queue of incoming customer orders. Orders should be processed in a First-In, First-Out (FIFO) manner.
 *     *   Each order has a unique Order ID (String) and contains a list of items requested. Each item specifies a Product ID and the quantity requested.
 *     *   Allow adding new orders to the queue.
 * 
 * 3.  **Order Processing:**
 *     *   Implement a mechanism to process the next order from the front of the queue.
 *     *   To process an order:
 *         *   Check if all requested products exist in the inventory.
 *         *   Check if there is sufficient stock for *each* requested item in the order.
 *         *   If *all* checks pass for *all* items in the order, deduct the requested quantities from the inventory, remove the order from the queue, and report successful processing.
 *         *   If *any* check fails (product not found, insufficient stock for *any* item), the *entire* order cannot be fulfilled. The order should be removed from the queue, inventory should remain unchanged for this order, and an error message detailing the reason should be reported.
 * 
 * 4.  **User Interaction:**
 *     *   The system should run interactively, accepting commands from the user via the console.
 *     *   Supported commands:
 *         *   `add_product <product_id> <product_name> <quantity>`: Adds or updates a product in inventory. If the product ID exists, its quantity is updated (added to existing quantity). If not, a new product is added. Quantity must be non-negative.
 *         *   `add_order <order_id> <product_id1> <quantity1> [<product_id2> <quantity2> ...]`: Adds a new order to the processing queue. The order details follow the order ID, listing product ID and quantity pairs. At least one item must be in the order. Quantities must be positive.
 *         *   `process_order`: Processes the next order from the front of the queue.
 *         *   `view_inventory`: Displays the current inventory of all products.
 *         *   `view_queue`: Displays the Order IDs of orders currently waiting in the processing queue.
 *         *   `exit`: Terminates the program.
 * 
 * **Technical Requirements:**
 * 
 * *   Use `java.util.Queue` for the order queue.
 * *   Use `java.util.ArrayList` to store the product inventory.
 * *   Use `java.util.List` interface type where appropriate (e.g., for method parameters or variable declarations).
 * *   Use `java.util.Scanner` to read user input from `System.in`.
 * *   Use a `switch` statement to handle different user commands.
 * *   Use `System.err.println()` for all error messages (e.g., invalid input format, insufficient stock, order queue empty).
 * *   Use `System.out.println()` for normal output (e.g., success messages, inventory list, queue contents).
 * *   Implement class-wide exception handling using `try-catch` blocks, particularly around the main command processing loop, to catch unexpected runtime errors during input parsing or processing.
 * *   Adhere to best practices:
 *     *   Proper encapsulation (private fields, public methods/constructors).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (Javadocs where applicable).
 *     *   Input validation (e.g., checking numeric formats, non-negative quantities, sufficient arguments for commands).
 *     *   Proper error handling as specified.
 *     *   Clean code structure (e.g., separate classes for Product, Order, Warehouse logic).
 * 
 * **Expected Output Format:**
 * 
 * *   `view_inventory`:
 *     ```
 *     Inventory:
 *     Product ID: <id>, Name: <name>, Quantity: <quantity>
 *     ...
 *     ```
 * *   `view_queue`:
 *     ```
 *     Order Queue:
 *     <order_id1>
 *     <order_id2>
 *     ...
 *     (Queue is empty) - if no orders
 *     ```
 * *   `add_product` success: `Product <id> added/updated successfully.`
 * *   `add_order` success: `Order <id> added to the queue.`
 * *   `process_order` success: `Order <id> processed successfully.`
 * *   `process_order` failure: Error message printed to `System.err` detailing the failure (e.g., `Error processing order <id>: Insufficient stock for product <product_id>.`).
 * *   Error messages for invalid commands or input should go to `System.err`.
 * 
 * Implement the complete Java code for this system.
 *
 * EXPLANATION:
 * This solution implements a simplified Warehouse Order Processing System demonstrating the required Java concepts.
 * 
 * 1.  **Class Structure:**
 *     *   `Product`: Encapsulates product data (ID, name, quantity) with private fields and public methods (`getId`, `getName`, `getQuantity`, `addQuantity`, `deductQuantity`). Includes basic validation in the constructor and methods.
 *     *   `OrderItem`: Represents a single line item within an order (product ID, quantity requested). Private fields and public getters. Includes validation.
 *     *   `Order`: Represents a customer order (order ID, list of `OrderItem`s). Uses `List<OrderItem>` to hold the items. Includes validation and returns a copy of the items list for encapsulation.
 *     *   `Warehouse`: The core logic class. It holds the `List<Product> inventory` (implemented by `ArrayList`) and the `Queue<Order> orderQueue` (implemented by `LinkedList`). It contains methods for `addProduct`, `addOrder`, `processNextOrder`, `viewInventory`, and `viewQueue`. This class manages the state and operations of the warehouse.
 *     *   `WarehouseSystem`: Contains the `main` method, handling user interaction via `Scanner` and directing commands to the `Warehouse` instance.
 * 
 * 2.  **Required Component Usage:**
 *     *   `Queue`: The `orderQueue` in the `Warehouse` class is declared as `Queue<Order>` and instantiated as `LinkedList<Order>`. `offer()` is used to add orders, `peek()` to look at the next order without removing, and `poll()` to remove the order after processing. This correctly implements FIFO order processing.
 *     *   `ArrayList`: The `inventory` in the `Warehouse` class is declared as `List<Product>` and instantiated as `ArrayList<Product>`. `ArrayList` is suitable here for storing and iterating through products, allowing efficient access and modification. The `Order` class also uses `ArrayList` internally to store its `OrderItem`s.
 *     *   `List interface`: Used for declaring the `inventory` field (`List<Product>`) and the `items` field within the `Order` class (`List<OrderItem>`). It's also used as the type for the `items` parameter in `Warehouse.addOrder` and `Order` constructor, promoting flexibility.
 *     *   `Scanner`: Used in the `main` method (`WarehouseSystem`) to read command lines from `System.in`.
 *     *   `Switch statement`: Used in the `main` method to parse the user's command string and execute the corresponding logic (`add_product`, `add_order`, `process_order`, `view_inventory`, `view_queue`, `exit`).
 *     *   `System.err`: Used extensively throughout the code to print error messages, such as invalid input formats, insufficient arguments, product not found, insufficient stock, or an empty queue.
 *     *   `System.out`: Used for printing normal output, including success messages (product added/updated, order added/processed), inventory listing, and the order queue contents.
 *     *   `try-catch`:
 *         *   A large `try-catch (Exception e)` block wraps the main command processing loop in `WarehouseSystem.main`. This provides "class-wide" handling by catching any unexpected runtime exceptions that might occur during command parsing or execution within the loop, preventing the program from crashing abruptly. It prints an error to `System.err` and the stack trace.
 *         *   Smaller `try-catch` blocks are used within command handlers (e.g., `add_product`, `add_order`) to specifically catch `NumberFormatException` during integer parsing or `IllegalArgumentException` thrown by constructors/methods due to invalid data (like negative quantities or empty strings), reporting these specific errors to `System.err`.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Private fields and public methods/constructors are used in `Product`, `OrderItem`, and `Order`. The `Warehouse` class manages its internal `inventory` and `orderQueue` via public methods.
 *     *   **Naming:** Variable names (`productId`, `orderQueue`), method names (`addProduct`, `processNextOrder`), and class names (`Product`, `Warehouse`) are meaningful and describe their purpose.
 *     *   **Comments/Documentation:** Javadoc-style comments are used for class and method descriptions, explaining their purpose, parameters, and behavior. Inline comments clarify specific logic points.
 *     *   **Input Validation:** Checks are performed for command argument counts (`parts.length`), numeric format (`Integer.parseInt` with `try-catch`), non-negative/positive quantities, and non-empty IDs/names.
 *     *   **Error Handling:** Specific error messages are printed to `System.err` for different failure conditions (invalid input, empty queue, insufficient stock, product not found). The order processing logic checks *all* items before attempting to deduct stock, ensuring inventory is only updated if the *entire* order can be fulfilled.
 *     *   **Clean Code Structure:** The code is divided into logical classes. The `main` method focuses on input handling and dispatching to the `Warehouse` object. The `Warehouse` class contains the core business logic.
 * 
 * This solution effectively integrates the required Java components into a practical scenario, demonstrating understanding of data structures, object-oriented principles, user interaction, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator; // Needed for safe removal during processing check

// Represents a product in the warehouse inventory
class Product {
    private String id;
    private String name;
    private int quantity;

    public Product(String id, String name, int quantity) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Product quantity cannot be negative.");
        }
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to add cannot be negative.");
        }
        this.quantity += quantity;
    }

    public void deductQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to deduct cannot be negative.");
        }
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("Insufficient stock.");
        }
        this.quantity -= quantity;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Quantity: " + quantity;
    }
}

// Represents an item within an order
class OrderItem {
    private String productId;
    private int quantity;

    public OrderItem(String productId, int quantity) {
        if (productId == null || productId.trim().isEmpty()) {
            throw new IllegalArgumentException("Product ID in OrderItem cannot be null or empty.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity in OrderItem must be positive.");
        }
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Represents a customer order
class Order {
    private String orderId;
    private List<OrderItem> items; // Using List interface

    public Order(String orderId, List<OrderItem> items) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty.");
        }
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item.");
        }
        this.orderId = orderId;
        // Create a defensive copy of the items list
        this.items = new ArrayList<>(items); // Using ArrayList implementation
    }

    public String getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        // Return a read-only view or a copy to maintain encapsulation
        return new ArrayList<>(items); // Returning a copy
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order ID: ").append(orderId).append("\nItems:\n");
        for (OrderItem item : items) {
            sb.append("  - Product ID: ").append(item.getProductId()).append(", Quantity: ").append(item.getQuantity()).append("\n");
        }
        return sb.toString();
    }
}

// Manages the warehouse inventory and order processing queue
class Warehouse {
    private List<Product> inventory; // Using List interface, implemented by ArrayList
    private Queue<Order> orderQueue; // Using Queue interface, implemented by LinkedList

    public Warehouse() {
        this.inventory = new ArrayList<>(); // Using ArrayList
        this.orderQueue = new LinkedList<>(); // Using LinkedList
    }

    /**
     * Adds a product or updates its quantity in the inventory.
     *
     * @param id Product ID.
     * @param name Product name.
     * @param quantity Quantity to add.
     */
    public void addProduct(String id, String name, int quantity) {
        if (quantity < 0) {
            System.err.println("Error: Cannot add negative quantity for product " + id + ".");
            return;
        }
        // Check if product already exists
        Product existingProduct = findProductById(id);
        if (existingProduct != null) {
            existingProduct.addQuantity(quantity); // Use the Product's method
            System.out.println("Product " + id + " updated successfully.");
        } else {
            try {
                Product newProduct = new Product(id, name, quantity);
                inventory.add(newProduct); // Add to ArrayList
                System.out.println("Product " + id + " added successfully.");
            } catch (IllegalArgumentException e) {
                System.err.println("Error adding product: " + e.getMessage());
            }
        }
    }

    /**
     * Finds a product by its ID in the inventory.
     *
     * @param id Product ID.
     * @return The Product object or null if not found.
     */
    private Product findProductById(String id) {
        for (Product product : inventory) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Adds a new order to the processing queue.
     *
     * @param orderId The unique ID for the order.
     * @param items The list of items in the order.
     */
    public void addOrder(String orderId, List<OrderItem> items) {
        try {
            Order newOrder = new Order(orderId, items);
            orderQueue.offer(newOrder); // Add to the Queue
            System.out.println("Order " + orderId + " added to the queue.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding order: " + e.getMessage());
        }
    }

    /**
     * Processes the next order from the queue.
     * Checks stock and deducts if sufficient, otherwise reports error.
     */
    public void processNextOrder() {
        Order orderToProcess = orderQueue.peek(); // Peek to check without removing

        if (orderToProcess == null) {
            System.err.println("Error: Order queue is empty. Nothing to process.");
            return;
        }

        String orderId = orderToProcess.getOrderId();
        System.out.println("Attempting to process order " + orderId + "...");

        // First, check if all items can be fulfilled
        boolean canFulfill = true;
        String failureReason = "";

        for (OrderItem item : orderToProcess.getItems()) {
            Product product = findProductById(item.getProductId());
            if (product == null) {
                canFulfill = false;
                failureReason = "Product " + item.getProductId() + " not found in inventory.";
                break; // Stop checking this order
            }
            if (product.getQuantity() < item.getQuantity()) {
                canFulfill = false;
                failureReason = "Insufficient stock for product " + item.getProductId() + ". Requested: " + item.getQuantity() + ", Available: " + product.getQuantity();
                break; // Stop checking this order
            }
        }

        // If all items can be fulfilled, deduct quantities
        if (canFulfill) {
            try {
                for (OrderItem item : orderToProcess.getItems()) {
                    Product product = findProductById(item.getProductId());
                    // This should not be null based on the check above, but defensive coding is good
                    if (product != null) {
                        product.deductQuantity(item.getQuantity()); // Use Product's method
                    }
                }
                orderQueue.poll(); // Remove from the Queue now that it's processed
                System.out.println("Order " + orderId + " processed successfully.");
            } catch (IllegalArgumentException e) {
                 // This catch is primarily for deductQuantity throwing insufficient stock,
                 // which should ideally be caught by the canFulfill check, but kept for robustness.
                 System.err.println("Internal Error processing order " + orderId + ": " + e.getMessage());
                 orderQueue.poll(); // Still remove the problematic order to prevent infinite loops
            }
        } else {
            // If not all items can be fulfilled, report error and remove order
            System.err.println("Error processing order " + orderId + ": " + failureReason);
            orderQueue.poll(); // Remove from the Queue as it cannot be processed currently
        }
    }

    /**
     * Displays the current inventory levels.
     */
    public void viewInventory() {
        System.out.println("Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("(Inventory is empty)");
        } else {
            // Using Iterator for safe traversal if needed, but simple for-each is fine here
            for (Product product : inventory) {
                System.out.println(product); // Product's toString() is used
            }
        }
    }

    /**
     * Displays the Order IDs of orders waiting in the queue.
     */
    public void viewQueue() {
        System.out.println("Order Queue:");
        if (orderQueue.isEmpty()) {
            System.out.println("(Queue is empty)");
        } else {
            // Iterate through the queue without removing elements
            // Using Iterator is a common way to traverse collections
            Iterator<Order> iterator = orderQueue.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().getOrderId());
            }
        }
    }
}

// Main class to run the warehouse system
public class WarehouseSystem {

    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Scanner scanner = new Scanner(System.in); // Using Scanner for input

        System.out.println("Warehouse Order Processing System");
        System.out.println("Available commands: add_product, add_order, process_order, view_inventory, view_queue, exit");

        // Class-wide exception handling around the main loop
        try {
            while (true) {
                System.out.print("> ");
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                String command = parts[0].toLowerCase();

                // Using switch statement for command handling
                switch (command) {
                    case "add_product":
                        if (parts.length == 4) {
                            String productId = parts[1];
                            String productName = parts[2];
                            try {
                                int quantity = Integer.parseInt(parts[3]);
                                warehouse.addProduct(productId, productName, quantity);
                            } catch (NumberFormatException e) {
                                System.err.println("Error: Invalid quantity format. Please enter an integer.");
                            } catch (IllegalArgumentException e) {
                                System.err.println("Error adding product: " + e.getMessage());
                            }
                        } else {
                            System.err.println("Error: Invalid arguments for add_product. Usage: add_product <product_id> <product_name> <quantity>");
                        }
                        break;

                    case "add_order":
                        // add_order <order_id> <product_id1> <quantity1> [<product_id2> <quantity2> ...]
                        if (parts.length >= 4 && (parts.length - 2) % 2 == 0) {
                            String orderId = parts[1];
                            List<OrderItem> items = new ArrayList<>(); // Using ArrayList
                            boolean parseError = false;
                            for (int i = 2; i < parts.length; i += 2) {
                                try {
                                    String productId = parts[i];
                                    int quantity = Integer.parseInt(parts[i + 1]);
                                    if (quantity <= 0) {
                                        System.err.println("Error: Order item quantity must be positive.");
                                        parseError = true;
                                        break;
                                    }
                                    items.add(new OrderItem(productId, quantity));
                                } catch (NumberFormatException e) {
                                    System.err.println("Error: Invalid quantity format for order item. Please enter integers.");
                                    parseError = true;
                                    break;
                                } catch (IllegalArgumentException e) {
                                    System.err.println("Error creating order item: " + e.getMessage());
                                    parseError = true;
                                    break;
                                }
                            }

                            if (!parseError && !items.isEmpty()) {
                                warehouse.addOrder(orderId, items);
                            } else if (!parseError && items.isEmpty()) {
                                System.err.println("Error: An order must contain at least one item.");
                            }

                        } else {
                            System.err.println("Error: Invalid arguments for add_order. Usage: add_order <order_id> <product_id1> <quantity1> [<product_id2> <quantity2> ...]");
                        }
                        break;

                    case "process_order":
                        if (parts.length == 1) {
                            warehouse.processNextOrder();
                        } else {
                            System.err.println("Error: process_order command takes no arguments.");
                        }
                        break;

                    case "view_inventory":
                        if (parts.length == 1) {
                            warehouse.viewInventory();
                        } else {
                            System.err.println("Error: view_inventory command takes no arguments.");
                        }
                        break;

                    case "view_queue":
                        if (parts.length == 1) {
                            warehouse.viewQueue();
                        } else {
                            System.err.println("Error: view_queue command takes no arguments.");
                        }
                        break;

                    case "exit":
                        System.out.println("Exiting system.");
                        scanner.close(); // Close the scanner
                        return; // Exit the program

                    default:
                        System.err.println("Error: Unknown command. Type 'exit' to quit.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions during the loop execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed even if an exception occurs
            if (scanner != null) {
                 scanner.close();
            }
        }
    }
}
