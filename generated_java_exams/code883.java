/*
 * Exam Question #883
 * Generated on: 2025-05-12 16:54:39
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Warehouse Inventory and Backorder Management
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified warehouse inventory management system. The system needs to handle incoming shipments, process customer orders, manage backorders for items that are out of stock, and provide status reports.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this system. Your program must meet the following technical requirements:
 * 
 * 1.  **Data Structures:**
 *     *   Maintain the main inventory using a `List` of `Product` objects (specifically, use `ArrayList` for implementation).
 *     *   Manage backordered customer orders using a `Queue` of `Order` objects.
 * 2.  **Classes:**
 *     *   Create a `Product` class with private fields for `productId` (String), `productName` (String), and `quantityInStock` (int). Include a constructor and public getter and setter methods (encapsulation).
 *     *   Create an `Order` class with private fields for `orderId` (String), `productId` (String), and `quantityOrdered` (int). Include a constructor and public getter methods.
 *     *   Create a `WarehouseManagementSystem` class containing the `main` method and the core logic. This class should hold instances of the inventory `List` and backorder `Queue`.
 * 3.  **Functionality (via a user-friendly text-based menu):**
 *     *   **1. Add/Update Inventory:** Allow the user to input product details (ID, Name, Quantity). If the product ID already exists, update the quantity by adding the new quantity. If it's a new product ID, add it to the inventory. Input quantity must be positive.
 *     *   **2. Process Customer Order:** Allow the user to input order details (Order ID, Product ID, Quantity).
 *         *   If the product exists and there is sufficient stock, decrease the inventory quantity and print a success message.
 *         *   If the product exists but there is *insufficient* stock, print a message indicating insufficient stock and add the `Order` to the backorder `Queue`.
 *         *   If the product ID does not exist in the inventory, print an error message using `System.err`. Input quantity must be positive.
 *     *   **3. Process Backorders:** Attempt to fulfill orders currently in the backorder `Queue`. Iterate through the queue. For each order, check if the required product is now in stock with sufficient quantity.
 *         *   If sufficient stock is available: Fulfill the order (decrease inventory), remove the order from the queue, and print a fulfillment success message.
 *         *   If insufficient stock: Print a message indicating the backorder is still pending due to low stock. The order should remain in the queue for future processing attempts.
 *     *   **4. Display Inventory:** Print a list of all products in the inventory with their current quantities.
 *     *   **5. Display Backorders:** Print a list of all orders currently in the backorder queue.
 *     *   **6. Exit:** Terminate the program.
 * 4.  **Control Flow:**
 *     *   Use a `while` loop for the main menu to keep the program running until the user chooses to exit.
 *     *   Use a `switch` statement to handle the user's menu selection.
 * 5.  **Input/Output:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Use `System.out.println()` for normal output messages (menu, status, success).
 *     *   Use `System.err.println()` for error messages (invalid input, product not found, etc.).
 * 6.  **Error Handling:**
 *     *   Implement robust input validation (e.g., ensuring quantities are positive integers, handling non-numeric input gracefully).
 *     *   Use `try-catch` blocks for exception handling, particularly around user input operations that might throw exceptions (like `InputMismatchException`). Consider wrapping the main interaction loop in a `try-catch` for general exceptions, or handle specific input errors within the input reading logic.
 * 
 * **Instructions:**
 * 
 * Write the complete Java code for the `Product`, `Order`, and `WarehouseManagementSystem` classes. Ensure your code is well-structured, uses meaningful variable names, includes comments where necessary, and adheres to the requirements listed above.
 * 
 * **Expected Output Examples:**
 * 
 * *   Adding a new product: `Product P001 added: Widget (Quantity: 100)`
 * *   Adding to existing product: `Quantity updated for P001: Widget (New Quantity: 150)`
 * *   Processing a successful order: `Order O101 fulfilled for P001: Widget (Quantity: 10). Remaining stock: 140`
 * *   Processing an order with insufficient stock: `Insufficient stock for P002: Gadget. Required: 20, Available: 10. Order O102 added to backorder queue.`
 * *   Product not found during order processing: `Error: Product P003 not found in inventory.` (Printed to `System.err`)
 * *   Processing backorders (fulfilled): `Backorder O102 fulfilled for P002: Gadget (Quantity: 20). Remaining stock: 0`
 * *   Processing backorders (still pending): `Backorder O103 for P004: Thingy (Quantity: 5) still pending due to insufficient stock. Required: 5, Available: 3.`
 * *   Invalid input: `Error: Invalid input. Please enter a number.` (Printed to `System.err`)
 * 
 * ```java
 * // Your code goes here
 * ```
 *
 * EXPLANATION:
 * This solution implements a `WarehouseManagementSystem` that simulates basic inventory and backorder handling, fulfilling all the requirements of the exam question.
 * 
 * 1.  **Class Structure:**
 *     *   `Product` class encapsulates product details (`productId`, `productName`, `quantityInStock`) with private fields and public getter/setter methods, demonstrating encapsulation.
 *     *   `Order` class encapsulates order details (`orderId`, `productId`, `quantityOrdered`) similarly.
 *     *   `WarehouseManagementSystem` is the main class holding the application logic and the data structures.
 * 
 * 2.  **Data Structures:**
 *     *   `private List<Product> inventory = new ArrayList<>();`: An `ArrayList` is used to store `Product` objects. It's declared using the `List` interface type, promoting good practice. `ArrayList` provides efficient random access and dynamic resizing needed for managing inventory items.
 *     *   `private Queue<Order> backorders = new LinkedList<>();`: A `LinkedList` is used to implement the `Queue` interface for storing `Order` objects that couldn't be fulfilled immediately. `Queue`'s FIFO (First-In, First-Out) nature is suitable for processing backorders in the order they were received. `offer()` is used to add to the tail, and `poll()` is used to remove from the head.
 * 
 * 3.  **Functionality Implementation:**
 *     *   A `while` loop in the `run()` method keeps the application running until the user chooses to exit.
 *     *   A `switch` statement is used within the loop to direct execution based on the user's menu choice, fulfilling the requirement for flow control.
 *     *   Methods like `addOrUpdateInventory`, `processCustomerOrder`, `processBackorders`, `displayInventory`, and `displayBackorders` implement the core business logic.
 *     *   `findProductById` is a private helper method demonstrating modularity.
 * 
 * 4.  **Input/Output:**
 *     *   `java.util.Scanner` is used to read user input for menu choices, product details, and order details.
 *     *   `System.out.println()` is used for printing the menu, successful operations, and status displays (inventory, backorders).
 *     *   `System.err.println()` is used specifically for printing error messages, such as invalid input or product not found errors, as required.
 * 
 * 5.  **Error Handling and Input Validation:**
 *     *   Input validation loops (`while (quantity < 0)`) with `try-catch(InputMismatchException)` blocks are used when reading numeric input (quantity, choice) to handle cases where the user enters non-numeric data or negative quantities, printing errors to `System.err` and prompting the user again.
 *     *   The `scanner.nextLine()` calls after `scanner.nextInt()` are crucial to consume the leftover newline character, preventing issues with subsequent `scanner.nextLine()` calls reading empty strings.
 *     *   A `try-catch` block wraps the main `while` loop in the `run()` method to catch any unexpected exceptions that might occur during the program's execution, demonstrating class-wide exception handling. A `finally` block ensures the `Scanner` is closed when the program terminates, releasing system resources. Specific error conditions like "Product not found" or "Insufficient stock" are handled with informative messages.
 * 
 * 6.  **Best Practices:**
 *     *   Meaningful variable and method names (`inventory`, `backorders`, `addOrUpdateInventory`, `findProductById`).
 *     *   Encapsulation in `Product` and `Order` classes.
 *     *   Comments are included to explain key parts of the code.
 *     *   Using interfaces (`List`, `Queue`) where appropriate.
 * 
 * The `processBackorders` method demonstrates a robust way to handle processing a queue while potentially re-queueing items. It polls all items, processes them, and then adds back only those that could not be fulfilled, ensuring that new inventory added can potentially fulfill previously pending orders in subsequent runs of this function.
 * 
 * This solution effectively integrates all the required Java components within a practical scenario, showcasing advanced concepts like data structure selection, object-oriented design, input validation, and exception handling.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList is a common Queue implementation
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a product in the warehouse inventory
class Product {
    private String productId;
    private String productName;
    private int quantityInStock;

    public Product(String productId, String productName, int quantityInStock) {
        this.productId = productId;
        this.productName = productName;
        this.quantityInStock = quantityInStock;
    }

    // Getters
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    // Setter for quantity (used when adding stock or fulfilling orders)
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantityInStock;
    }
}

// Represents a customer order
class Order {
    private String orderId;
    private String productId;
    private int quantityOrdered;

    public Order(String orderId, String productId, int quantityOrdered) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantityOrdered = quantityOrdered;
    }

    // Getters
    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Product ID: " + productId + ", Quantity: " + quantityOrdered;
    }
}

// Main class for managing the warehouse system
public class WarehouseManagementSystem {

    // Using List interface, implemented by ArrayList for inventory
    private List<Product> inventory;
    // Using Queue interface, implemented by LinkedList for backorders
    private Queue<Order> backorders;
    private Scanner scanner;

    public WarehouseManagementSystem() {
        inventory = new ArrayList<>();
        backorders = new LinkedList<>(); // LinkedList is a common implementation for Queue
        scanner = new Scanner(System.in);
    }

    // --- Core Operations ---

    // Adds new product or updates quantity of existing product
    public void addOrUpdateInventory() {
        System.out.println("\n--- Add/Update Inventory ---");
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        int quantity = -1;
        while (quantity < 0) {
            try {
                System.out.print("Enter Quantity to add: ");
                quantity = scanner.nextInt();
                if (quantity < 0) {
                    System.err.println("Error: Quantity cannot be negative. Please enter a positive number.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number for quantity.");
                scanner.next(); // Consume the invalid input
                quantity = -1; // Reset quantity to stay in loop
            } finally {
                 // Consume the rest of the line after reading int, important for next nextLine()
                 if (quantity >= 0) { // Only consume if int was successfully read or error handled
                     scanner.nextLine();
                 }
            }
        }


        Product existingProduct = findProductById(productId);

        if (existingProduct != null) {
            // Product exists, update quantity
            existingProduct.setQuantityInStock(existingProduct.getQuantityInStock() + quantity);
            System.out.println("Quantity updated for " + existingProduct.getProductId() + ": " + existingProduct.getProductName() + " (New Quantity: " + existingProduct.getQuantityInStock() + ")");
        } else {
            // New product
            Product newProduct = new Product(productId, productName, quantity);
            inventory.add(newProduct);
            System.out.println("New product added: " + newProduct.getProductId() + ": " + newProduct.getProductName() + " (Quantity: " + newProduct.getQuantityInStock() + ")");
        }
    }

    // Processes a customer order
    public void processCustomerOrder() {
        System.out.println("\n--- Process Customer Order ---");
        System.out.print("Enter Order ID: ");
        String orderId = scanner.nextLine();
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();

        int quantity = -1;
         while (quantity < 0) {
            try {
                System.out.print("Enter Quantity ordered: ");
                quantity = scanner.nextInt();
                 if (quantity < 0) {
                    System.err.println("Error: Quantity cannot be negative. Please enter a positive number.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number for quantity.");
                scanner.next(); // Consume the invalid input
                quantity = -1; // Reset quantity
            } finally {
                 if (quantity >= 0) {
                     scanner.nextLine(); // Consume newline
                 }
            }
        }


        Product product = findProductById(productId);

        if (product == null) {
            System.err.println("Error: Product " + productId + " not found in inventory.");
        } else {
            if (product.getQuantityInStock() >= quantity) {
                // Sufficient stock
                product.setQuantityInStock(product.getQuantityInStock() - quantity);
                System.out.println("Order " + orderId + " fulfilled for " + product.getProductId() + ": " + product.getProductName() + " (Quantity: " + quantity + "). Remaining stock: " + product.getQuantityInStock());
            } else {
                // Insufficient stock, add to backorders
                System.out.println("Insufficient stock for " + product.getProductId() + ": " + product.getProductName() + ". Required: " + quantity + ", Available: " + product.getQuantityInStock() + ". Order " + orderId + " added to backorder queue.");
                Order backorder = new Order(orderId, productId, quantity);
                backorders.offer(backorder); // Use offer for adding to queue
            }
        }
    }

    // Attempts to fulfill backordered items
    public void processBackorders() {
        System.out.println("\n--- Processing Backorders ---");
        if (backorders.isEmpty()) {
            System.out.println("No backorders to process.");
            return;
        }

        // Use a temporary list to hold orders that could not be fulfilled
        // This is necessary because we might remove elements from the queue while iterating
        List<Order> pendingBackorders = new ArrayList<>();

        System.out.println("Attempting to fulfill " + backorders.size() + " backorder(s)...");

        // Process orders one by one from the head of the queue
        while (!backorders.isEmpty()) {
            Order currentOrder = backorders.poll(); // Remove from head

            Product product = findProductById(currentOrder.getProductId());

            if (product == null) {
                 // This case shouldn't happen if products are only removed via fulfilling orders,
                 // but handle defensively.
                 System.err.println("Warning: Product " + currentOrder.getProductId() + " for backorder " + currentOrder.getOrderId() + " not found in inventory. Removing backorder.");
                 // Don't add back to pendingBackorders
            } else {
                if (product.getQuantityInStock() >= currentOrder.getQuantityOrdered()) {
                    // Sufficient stock now, fulfill the backorder
                    product.setQuantityInStock(product.getQuantityInStock() - currentOrder.getQuantityOrdered());
                    System.out.println("Backorder " + currentOrder.getOrderId() + " fulfilled for " + product.getProductId() + ": " + product.getProductName() + " (Quantity: " + currentOrder.getQuantityOrdered() + "). Remaining stock: " + product.getQuantityInStock());
                } else {
                    // Still insufficient stock, add back to the temporary list
                    System.out.println("Backorder " + currentOrder.getOrderId() + " for " + product.getProductId() + ": " + product.getProductName() + " (Quantity: " + currentOrder.getQuantityOrdered() + ") still pending due to insufficient stock. Required: " + currentOrder.getQuantityOrdered() + ", Available: " + product.getQuantityInStock() + ".");
                    pendingBackorders.add(currentOrder);
                }
            }
        }

        // Re-queue any orders that were not fulfilled
        if (!pendingBackorders.isEmpty()) {
             System.out.println("Re-queueing " + pendingBackorders.size() + " pending backorder(s).");
             for(Order order : pendingBackorders) {
                 backorders.offer(order);
             }
        }
         System.out.println("--- Backorder Processing Complete ---");
    }


    // Displays current inventory
    public void displayInventory() {
        System.out.println("\n--- Current Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product product : inventory) {
                System.out.println(product);
            }
        }
         System.out.println("-------------------------");
    }

    // Displays current backorders
    public void displayBackorders() {
        System.out.println("\n--- Current Backorders ---");
        if (backorders.isEmpty()) {
            System.out.println("No backorders currently.");
        } else {
            // Peeking allows viewing without removing
            for (Order order : backorders) {
                System.out.println(order);
            }
        }
         System.out.println("------------------------");
    }

    // Helper method to find a product by its ID
    private Product findProductById(String productId) {
        for (Product product : inventory) {
            if (product.getProductId().equalsIgnoreCase(productId)) {
                return product;
            }
        }
        return null; // Product not found
    }

    // --- Main Application Loop ---

    public void run() {
        int choice = -1;

        // Class-wide try-catch for general exceptions during runtime
        try {
            while (choice != 6) {
                printMenu();
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over after reading int

                    switch (choice) {
                        case 1:
                            addOrUpdateInventory();
                            break;
                        case 2:
                            processCustomerOrder();
                            break;
                        case 3:
                            processBackorders();
                            break;
                        case 4:
                            displayInventory();
                            break;
                        case 5:
                            displayBackorders();
                            break;
                        case 6:
                            System.out.println("Exiting Warehouse Management System. Goodbye!");
                            break;
                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 6.");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number for your choice.");
                    scanner.next(); // Consume the invalid input
                    choice = -1; // Reset choice to prevent loop termination
                } catch (Exception e) {
                    // Catch any unexpected exceptions during an operation
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    e.printStackTrace(); // Print stack trace for debugging
                }
            }
        } finally {
            // Ensure the scanner is closed when the program exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Prints the main menu options
    private void printMenu() {
        System.out.println("\n--- Warehouse Management Menu ---");
        System.out.println("1. Add/Update Inventory");
        System.out.println("2. Process Customer Order");
        System.out.println("3. Process Backorders");
        System.out.println("4. Display Inventory");
        System.out.println("5. Display Backorders");
        System.out.println("6. Exit");
        System.out.println("---------------------------------");
    }

    // Main method to start the application
    public static void main(String[] args) {
        WarehouseManagementSystem system = new WarehouseManagementSystem();
        system.run();
    }
}
