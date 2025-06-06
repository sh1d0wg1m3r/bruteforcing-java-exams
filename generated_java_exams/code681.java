/*
 * Exam Question #681
 * Generated on: 2025-05-12 16:24:47
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Supply Chain Order Processing Simulation
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified simulation of an order processing system for a small supply chain. The system should manage a catalog of available products and a queue of incoming customer orders. Your program will allow a user (simulating an administrator) to interact with the system via a command-line interface.
 * 
 * **Requirements:**
 * 
 * 1.  **Product Catalog:** Maintain a list of available products. Each product should have a unique ID (integer), a name (string), and a price (double). Initialize the system with at least 3 predefined products.
 * 2.  **Order Queue:** Manage incoming customer orders using a queue. Each order will consist of one or more items, where each item specifies a product ID and the quantity ordered.
 * 3.  **User Interface:** Provide a menu-driven command-line interface using `Scanner`. The menu options should include:
 *     *   View Product Catalog
 *     *   Place New Order
 *     *   Process Next Order
 *     *   View Order Queue
 *     *   Exit
 * 4.  **Functionality Details:**
 *     *   **View Product Catalog:** Display the list of available products with their details (ID, Name, Price).
 *     *   **Place New Order:**
 *         *   Prompt the user to enter details for a new order. An order can contain multiple items.
 *         *   For each item, prompt for the Product ID and Quantity.
 *         *   Validate that the entered Product ID exists in the catalog. If not, report an error and skip this item or the order.
 *         *   Validate that the Quantity is a positive integer (> 0). If not, report an error and skip this item.
 *         *   If an item is valid, add it to the current order being built.
 *         *   Allow the user to add multiple items to a single order before finalizing it.
 *         *   Once the user indicates the order is complete, add the created order object to the order queue.
 *     *   **Process Next Order:**
 *         *   Remove the next order from the front of the queue.
 *         *   If the queue is empty, report an error.
 *         *   If an order is successfully retrieved, display its contents (items with product names and quantities) and indicate that it has been processed.
 *     *   **View Order Queue:** Display the contents of the current order queue without removing elements. Show how many orders are in the queue and a summary of each order (e.g., number of items, or the items themselves).
 *     *   **Exit:** Terminate the program.
 * 5.  **Java Component Usage:** Your solution *must* explicitly use the following Java components:
 *     *   `java.util.Queue`
 *     *   `java.util.ArrayList`
 *     *   `java.util.List` (used as an interface type)
 *     *   `java.util.Scanner`
 *     *   `switch` statement
 *     *   `System.err` (for error messages)
 *     *   `System.out` (for normal output and prompts)
 *     *   Class-wide exception handling using `try-catch` blocks (at least covering the main interaction loop).
 * 6.  **Best Practices:**
 *     *   Implement proper encapsulation (private fields, public getters/methods) for classes like `Product` and `Order`.
 *     *   Use meaningful names for variables, methods, and classes.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Implement robust input validation as described above.
 *     *   Provide clear error handling using `System.err`.
 *     *   Structure the code logically.
 * 
 * **Expected Output:**
 * 
 * The program should present a clear menu. User interactions should be prompted via `System.out`. Successful operations (viewing lists, placing orders, processing orders) should use `System.out`. Error conditions (invalid input, empty queue) *must* be reported using `System.err`.
 * 
 * Example interaction flow:
 * 
 * ```
 * Supply Chain Order Processing System
 * 
 * Menu:
 * 1. View Product Catalog
 * 2. Place New Order
 * 3. Process Next Order
 * 4. View Order Queue
 * 5. Exit
 * Enter your choice: 1
 * 
 * --- Product Catalog ---
 * ID: 101, Name: Laptop, Price: 1200.00
 * ID: 102, Name: Keyboard, Price: 75.00
 * ID: 103, Name: Mouse, Price: 25.00
 * -----------------------
 * 
 * Menu:
 * ...
 * Enter your choice: 2
 * 
 * --- Place New Order ---
 * Enter Product ID (or 0 to finish order): 101
 * Enter Quantity: 2
 * Item added: Laptop (x2)
 * Enter Product ID (or 0 to finish order): 105
 * Error: Product with ID 105 not found.
 * Enter Product ID (or 0 to finish order): 102
 * Enter Quantity: -5
 * Error: Quantity must be positive.
 * Enter Product ID (or 0 to finish order): 102
 * Enter Quantity: 1
 * Item added: Keyboard (x1)
 * Enter Product ID (or 0 to finish order): 0
 * Order placed successfully! Order ID: [Some ID]
 * 
 * Menu:
 * ...
 * Enter your choice: 4
 * 
 * --- Current Order Queue ---
 * Queue Size: 1
 * Order [Some ID]: 2 items
 *   - Laptop (x2)
 *   - Keyboard (x1)
 * -------------------------
 * 
 * Menu:
 * ...
 * Enter your choice: 3
 * 
 * --- Process Next Order ---
 * Processing Order [Some ID]:
 *   - Laptop (x2)
 *   - Keyboard (x1)
 * Order processed successfully!
 * --------------------------
 * 
 * Menu:
 * ...
 * Enter your choice: 3
 * Error: Order queue is empty. No orders to process.
 * 
 * Menu:
 * ...
 * Enter your choice: 5
 * Exiting system.
 * ```
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation of all required functionalities.
 * *   Proper and mandatory use of all specified Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`).
 * *   Adherence to best practices (encapsulation, naming, comments, validation, error handling, code structure).
 * *   Handling of edge cases (empty queue, invalid input).
 * 
 * **Time Allotment:** 45-60 minutes
 *
 * EXPLANATION:
 * This solution implements a basic supply chain order processing system using the required Java components and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Product`: A simple POJO (Plain Old Java Object) class to hold product data (`id`, `name`, `price`). It includes a constructor and public getter methods for encapsulation.
 *     *   `OrderItem`: Represents a single line item within an order, storing the `productId` and `quantity`.
 *     *   `Order`: Represents a customer order, containing a unique `orderId` and a `List` of `OrderItem`s. It uses a static counter (`nextOrderId`) to generate unique IDs and provides a getter for the items list, returning a copy to maintain encapsulation.
 *     *   `SupplyChainOrderProcessingSystem`: The main class that orchestrates the system. It holds the product catalog (`productCatalog`) and the order queue (`orderQueue`), and contains the main application logic.
 * 
 * 2.  **Required Component Usage:**
 *     *   `java.util.List`: The `productCatalog` is declared as `List<Product>`, demonstrating the use of the interface.
 *     *   `java.util.ArrayList`: The `productCatalog` is instantiated as an `ArrayList`, providing the concrete implementation for the list of products. `ArrayList` is also used within the `Order` class to store `OrderItem`s and within the `placeNewOrder` method to build the list of items for a new order.
 *     *   `java.util.Queue`: The `orderQueue` is declared as `Queue<Order>`, demonstrating the use of the queue interface.
 *     *   `java.util.LinkedList`: The `orderQueue` is instantiated as a `LinkedList`, which is a common implementation for the `Queue` interface, suitable for adding to the end (`offer`) and removing from the front (`poll`).
 *     *   `java.util.Scanner`: Used in the `run()` method to read user input from `System.in` for menu choices and order details.
 *     *   `switch` statement: Used in the `run()` method to handle the different menu options selected by the user.
 *     *   `System.out`: Used extensively for displaying the menu, product catalog, queue contents, prompts, and success messages.
 *     *   `System.err`: Used specifically for reporting error conditions, such as invalid menu choices, product not found, invalid quantity, or attempting to process an order when the queue is empty.
 *     *   `try-catch`: A `try-catch` block is wrapped around the core logic within the `run()` method's `do-while` loop. This provides class-wide exception handling, primarily to catch `InputMismatchException` if the user enters non-numeric input where an integer is expected (like the menu choice or quantity/ID). An inner `try-catch` is also used within `placeNewOrder` for similar input validation during order creation. A general `Exception` catch is included as a fallback for unexpected runtime issues.
 * 
 * 3.  **Functionality Implementation:**
 *     *   **Initialization:** The `initializeCatalog()` method populates the `productCatalog` `ArrayList`.
 *     *   **View Catalog:** `viewProductCatalog()` iterates through the `productCatalog` `List` and prints each `Product` using its `toString()` method.
 *     *   **Place Order:** `placeNewOrder()` uses a loop to allow adding multiple `OrderItem`s. It uses `scanner.nextInt()` and `scanner.nextLine()` carefully to handle integer input followed by line breaks. Input validation checks if the product ID exists (`findProductById`) and if the quantity is positive. Valid items are added to a temporary `ArrayList<OrderItem>`. Once the user enters 0 for the product ID, a new `Order` object is created from the temporary list and added to the `orderQueue` using `offer()`.
 *     *   **Process Order:** `processNextOrder()` uses `orderQueue.poll()` to get and remove the next order. It checks if `poll()` returned `null` (indicating an empty queue) and prints an error to `System.err` if so. Otherwise, it iterates through the order's items and prints them to `System.out`.
 *     *   **View Queue:** `viewOrderQueue()` checks if the queue is empty. If not, it iterates through the `orderQueue` using a for-each loop. This loop iterates over the elements without removing them, allowing the contents to be viewed. It prints a summary of each order and its items.
 *     *   **Main Loop:** The `run()` method contains the main `do-while` loop that displays the menu, reads user input, and uses the `switch` statement to call the appropriate action method.
 * 
 * 4.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Product`, `OrderItem`, and `Order` are private, accessed via public getters.
 *     *   **Naming:** Class, method, and variable names are descriptive (e.g., `productCatalog`, `orderQueue`, `placeNewOrder`, `findProductById`).
 *     *   **Comments:** Javadoc comments are provided for classes and key methods. Inline comments explain specific logic sections.
 *     *   **Input Validation:** Explicit checks for product existence and positive quantity are performed during order placement. `InputMismatchException` is caught for non-numeric input.
 *     *   **Error Handling:** `System.err` is used for error messages. `try-catch` blocks handle potential exceptions gracefully, preventing the program from crashing on invalid input or unexpected issues. The main loop's `try-catch` ensures that even if an error occurs within an action, the menu is displayed again (after reporting the error).
 *     *   **Code Structure:** The code is organized into logical classes and methods, separating concerns (data representation in `Product`, `OrderItem`, `Order`, and system logic in `SupplyChainOrderProcessingSystem`).
 * 
 * This solution effectively demonstrates the required Java concepts in a practical, interactive scenario, including managing collections (`List`, `ArrayList`, `Queue`), handling user input (`Scanner`, `switch`), implementing error handling (`try-catch`, `System.err`), and following object-oriented principles (encapsulation).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a product in the catalog.
 */
class Product {
    private int id;
    private String name;
    private double price;

    /**
     * Constructs a Product object.
     * @param id The unique product ID.
     * @param name The product name.
     * @param price The product price.
     */
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + String.format("%.2f", price);
    }
}

/**
 * Represents an item within an order.
 */
class OrderItem {
    private int productId;
    private int quantity;

    /**
     * Constructs an OrderItem.
     * @param productId The ID of the product being ordered.
     * @param quantity The quantity of the product.
     */
    public OrderItem(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    // No toString here, as it's typically formatted within the Order.
}

/**
 * Represents a customer order.
 */
class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private List<OrderItem> items;

    /**
     * Constructs an Order with a list of items.
     * Assigns a unique order ID.
     * @param items The list of items in the order.
     */
    public Order(List<OrderItem> items) {
        this.orderId = nextOrderId++;
        this.items = new ArrayList<>(items); // Defensive copy
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items); // Return a copy to prevent external modification
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Items: " + items.size();
    }
}

/**
 * Main class for the Supply Chain Order Processing System.
 * Manages product catalog and order queue.
 */
public class SupplyChainOrderProcessingSystem {

    private List<Product> productCatalog; // Using List interface
    private Queue<Order> orderQueue;     // Using Queue interface
    private Scanner scanner;

    /**
     * Constructs the system, initializes catalog and queue.
     */
    public SupplyChainOrderProcessingSystem() {
        productCatalog = new ArrayList<>(); // Using ArrayList implementation
        orderQueue = new LinkedList<>();   // Using LinkedList implementation for Queue
        scanner = new Scanner(System.in);
        initializeCatalog();
    }

    /**
     * Populates the product catalog with initial products.
     */
    private void initializeCatalog() {
        productCatalog.add(new Product(101, "Laptop", 1200.00));
        productCatalog.add(new Product(102, "Keyboard", 75.00));
        productCatalog.add(new Product(103, "Mouse", 25.00));
        productCatalog.add(new Product(104, "Monitor", 300.00));
    }

    /**
     * Finds a product by its ID.
     * @param productId The ID to search for.
     * @return The Product object if found, null otherwise.
     */
    private Product findProductById(int productId) {
        for (Product product : productCatalog) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\nSupply Chain Order Processing System");
        System.out.println("\nMenu:");
        System.out.println("1. View Product Catalog");
        System.out.println("2. Place New Order");
        System.out.println("3. Process Next Order");
        System.out.println("4. View Order Queue");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles the "View Product Catalog" action.
     */
    private void viewProductCatalog() {
        System.out.println("\n--- Product Catalog ---");
        if (productCatalog.isEmpty()) {
            System.out.println("Catalog is empty.");
        } else {
            for (Product product : productCatalog) {
                System.out.println(product);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Handles the "Place New Order" action.
     */
    private void placeNewOrder() {
        System.out.println("\n--- Place New Order ---");
        List<OrderItem> items = new ArrayList<>();
        int productId;

        while (true) {
            System.out.print("Enter Product ID (or 0 to finish order): ");
            try {
                productId = scanner.nextInt();
                if (productId == 0) {
                    break; // Finish order
                }

                Product product = findProductById(productId);
                if (product == null) {
                    System.err.println("Error: Product with ID " + productId + " not found.");
                    continue; // Ask for next item
                }

                System.out.print("Enter Quantity: ");
                int quantity = scanner.nextInt();

                if (quantity <= 0) {
                    System.err.println("Error: Quantity must be positive.");
                    continue; // Ask for next item
                }

                items.add(new OrderItem(productId, quantity));
                System.out.println("Item added: " + product.getName() + " (x" + quantity + ")");

            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            } catch (Exception e) {
                System.err.println("An unexpected error occurred while adding item: " + e.getMessage());
                // Optionally consume line or handle differently
            }
        }

        if (items.isEmpty()) {
            System.out.println("No items added to the order. Order not placed.");
        } else {
            Order newOrder = new Order(items);
            orderQueue.offer(newOrder); // Add order to the queue
            System.out.println("Order placed successfully! " + newOrder);
        }
        System.out.println("-----------------------");
    }

    /**
     * Handles the "Process Next Order" action.
     */
    private void processNextOrder() {
        System.out.println("\n--- Process Next Order ---");
        Order orderToProcess = orderQueue.poll(); // Retrieve and remove the head of the queue

        if (orderToProcess == null) {
            System.err.println("Error: Order queue is empty. No orders to process.");
        } else {
            System.out.println("Processing " + orderToProcess + ":");
            for (OrderItem item : orderToProcess.getItems()) {
                Product product = findProductById(item.getProductId());
                String productName = (product != null) ? product.getName() : "Unknown Product";
                System.out.println("  - " + productName + " (x" + item.getQuantity() + ")");
            }
            System.out.println("Order processed successfully!");
        }
        System.out.println("--------------------------");
    }

    /**
     * Handles the "View Order Queue" action.
     */
    private void viewOrderQueue() {
        System.out.println("\n--- Current Order Queue ---");
        if (orderQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue Size: " + orderQueue.size());
            // Iterate through the queue without removing elements
            int orderIndex = 1;
            for (Order order : orderQueue) {
                System.out.println(orderIndex + ". " + order);
                // Optionally print items for each order (can be verbose for large queues)
                // For simplicity, we'll just show summary unless asked to be detailed
                 System.out.println("   Items:");
                 for (OrderItem item : order.getItems()) {
                     Product product = findProductById(item.getProductId());
                     String productName = (product != null) ? product.getName() : "Unknown Product";
                     System.out.println("     - " + productName + " (x" + item.getQuantity() + ")");
                 }
                orderIndex++;
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * Runs the main application loop.
     */
    public void run() {
        int choice;
        do {
            displayMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                // Class-wide exception handling around the switch logic
                try {
                    switch (choice) {
                        case 1:
                            viewProductCatalog();
                            break;
                        case 2:
                            placeNewOrder();
                            break;
                        case 3:
                            processNextOrder();
                            break;
                        case 4:
                            viewOrderQueue();
                            break;
                        case 5:
                            System.out.println("Exiting system.");
                            break;
                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (Exception e) {
                     // Catch any unexpected errors within the switch cases
                     System.err.println("An unexpected error occurred during operation: " + e.getMessage());
                     e.printStackTrace(); // Optional: print stack trace for debugging
                }

            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number for your choice.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
                choice = 0; // Set choice to 0 to continue the loop
            } catch (Exception e) {
                 // Catch any other top-level exceptions
                 System.err.println("A critical error occurred: " + e.getMessage());
                 e.printStackTrace(); // Optional: print stack trace
                 choice = 5; // Attempt to exit gracefully
            }

        } while (choice != 5);

        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SupplyChainOrderProcessingSystem system = new SupplyChainOrderProcessingSystem();
        system.run();
    }
}
