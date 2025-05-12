/*
 * Exam Question #34
 * Generated on: 2025-05-11 21:51:45
 * 
 * QUESTION:
 * ## Java Programming Exam Task: E-commerce Order Processing Simulation
 * 
 * **Scenario:**
 * 
 * You are tasked with creating a simplified simulation of an e-commerce order processing system. The system receives incoming orders, places them in a queue for processing, and then processes them one by one based on availability. Processed orders are moved to a 'completed' list, while orders that fail processing (e.g., product not found) are moved to a 'failed' list.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this system with the following features:
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a queue of incoming orders waiting to be processed.
 *     *   Maintain a list of available products (pre-populated).
 *     *   Maintain a list of successfully processed orders.
 *     *   Maintain a list of failed orders.
 * 
 * 2.  **Functionality (Menu-Driven):** The program should present a menu to the user with the following options:
 *     *   Add a new order to the queue (requires Product ID and Quantity).
 *     *   Process the next order from the queue.
 *     *   View current incoming orders queue.
 *     *   View successfully processed orders.
 *     *   View failed orders.
 *     *   View available products.
 *     *   Exit.
 * 
 * 3.  **Order Processing Logic:**
 *     *   When "Process next order" is selected, take the order at the front of the incoming queue.
 *     *   Validate the order: Check if the requested Product ID exists in the list of available products. (For simplicity, assume unlimited stock, only product existence matters).
 *     *   If validation succeeds, move the order from the queue to the successfully processed orders list. Print a success message to `System.out`.
 *     *   If validation fails (product not found), move the order from the queue to the failed orders list. Print an error message to `System.err`.
 *     *   If the incoming queue is empty, print a message indicating this to `System.out`.
 * 
 * 4.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input for menu choices and order details.
 *     *   Use a `switch` statement to handle the main menu options.
 *     *   Implement input validation for menu choices and order details (e.g., ensure integers are entered, check for non-negative quantities). Use `System.err` for invalid input messages.
 * 
 * 5.  **Error Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks. Specifically, handle potential `InputMismatchException` when reading integer input from the `Scanner`. If caught, print an informative message to `System.err` and clear the invalid input.
 *     *   Handle cases where the queue is empty when processing.
 * 
 * 6.  **Output:**
 *     *   Use `System.out` for displaying the menu, system status, queue contents, processed orders, failed orders, product list, and success messages.
 *     *   Use `System.err` for displaying error messages (invalid input, processing failures).
 * 
 * 7.  **Object-Oriented Design:**
 *     *   Create separate classes for `Product` and `Order` with appropriate private fields and public getters (encapsulation).
 *     *   Create a main class (e.g., `OrderProcessingSystem`) that encapsulates the system's state (the queue and lists) and logic (adding, processing, viewing).
 * 
 * 8.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and basic documentation (e.g., Javadoc for classes/methods).
 *     *   Structure the code cleanly.
 * 
 * **Initial State:**
 * 
 * The system should start with a pre-populated list of available products (e.g., Product ID 1: "Laptop", Product ID 2: "Keyboard", Product ID 3: "Mouse"). The incoming order queue, processed orders list, and failed orders list should initially be empty.
 * 
 * **Expected Output:**
 * 
 * The program should run continuously, presenting the menu until the user chooses to exit. Output should clearly indicate the result of each operation (order added, order processed successfully/failed, queue/list contents displayed). Error messages should be distinguishable using `System.err`.
 * 
 * ---
 * 
 * **Example Interaction Flow (Illustrative):**
 * 
 * ```
 * --- E-commerce Order Processing System ---
 * 1. Add New Order
 * 2. Process Next Order
 * 3. View Incoming Orders
 * 4. View Processed Orders
 * 5. View Failed Orders
 * 6. View Available Products
 * 7. Exit
 * Enter your choice: 1
 * Enter Product ID: 1
 * Enter Quantity: 2
 * Order O1 added to queue.
 * 
 * --- E-commerce Order Processing System ---
 * ...
 * Enter your choice: 1
 * Enter Product ID: 99  <-- Invalid Product
 * Enter Quantity: 1
 * Order O2 added to queue.
 * 
 * --- E-commerce Order Processing System ---
 * ...
 * Enter your choice: 3
 * Incoming Orders Queue: [Order{id=O1, productId=1, quantity=2}, Order{id=O2, productId=99, quantity=1}]
 * 
 * --- E-commerce Order Processing System ---
 * ...
 * Enter your choice: 2
 * Processing Order O1...
 * Order O1 processed successfully.
 * 
 * --- E-commerce Order Processing System ---
 * ...
 * Enter your choice: 2
 * Processing Order O2...
 * Error processing Order O2: Product with ID 99 not found.
 * Order O2 moved to failed orders.
 * 
 * --- E-commerce Order Processing System ---
 * ...
 * Enter your choice: 4
 * Processed Orders: [Order{id=O1, productId=1, quantity=2}]
 * 
 * --- E-commerce Order Processing System ---
 * ...
 * Enter your choice: 5
 * Failed Orders: [Order{id=O2, productId=99, quantity=1}]
 * 
 * --- E-commerce Order Processing System ---
 * ...
 * Enter your choice: 7
 * Exiting system.
 * ```
 * 
 * **Evaluation:**
 * 
 * Your solution will be evaluated based on:
 * *   Correct usage of all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`).
 * *   Adherence to the specified functionality and logic.
 * *   Implementation of input validation and error handling.
 * *   Proper object-oriented design (encapsulation).
 * *   Code clarity, structure, and comments.
 * 
 * ---
 * **Note:** You only need to provide the complete Java code solution within the `[SOLUTION_CODE]` tags and the explanation within the `[EXPLANATION]` tags. Do not include package declarations unless necessary for clarity (assume a single default package or similar simple structure for the exam).
 *
 * EXPLANATION:
 * ` tags. Do not include package declarations unless necessary for clarity (assume a single default package or similar simple structure for the exam).
 * 
 * [END_EXAM_QUESTION]
 * 
 * [SOLUTION_CODE]
 * ```java
 * import java.util.ArrayList;
 * import java.util.LinkedList;
 * import java.util.List;
 * import java.util.Queue;
 * import java.util.Scanner;
 * import java.util.InputMismatchException;
 * 
 * /**
 *  * Represents a product available in the system.
 *  */
 * class Product {
 *     private int id;
 *     private String name;
 * 
 *     /**
 *      * Constructs a Product object.
 *      * @param id The unique ID of the product.
 *      * @param name The name of the product.
 *      */
 *     public Product(int id, String name) {
 *         this.id = id;
 *         this.name = name;
 *     }
 * 
 *     /**
 *      * Gets the product ID.
 *      * @return The product ID.
 *      */
 *     public int getId() {
 *         return id;
 *     }
 * 
 *     /**
 *      * Gets the product name.
 *      * @return The product name.
 *      */
 *     public String getName() {
 *         return name;
 *     }
 * 
 *     @Override
 *     public String toString() {
 *         return "Product{id=" + id + ", name='" + name + "'}";
 *     }
 * }
 * 
 * /**
 *  * Represents an order placed by a customer.
 *  */
 * class Order {
 *     private String id; // Using String for unique ID like O1, O2 etc.
 *     private int productId;
 *     private int quantity;
 * 
 *     /**
 *      * Constructs an Order object.
 *      * @param id The unique ID of the order.
 *      * @param productId The ID of the product ordered.
 *      * @param quantity The quantity of the product ordered.
 *      */
 *     public Order(String id, int productId, int quantity) {
 *         this.id = id;
 *         this.productId = productId;
 *         this.quantity = quantity;
 *     }
 * 
 *     /**
 *      * Gets the order ID.
 *      * @return The order ID.
 *      */
 *     public String getId() {
 *         return id;
 *     }
 * 
 *     /**
 *      * Gets the product ID for this order.
 *      * @return The product ID.
 *      */
 *     public int getProductId() {
 *         return productId;
 *     }
 * 
 *     /**
 *      * Gets the quantity for this order.
 *      * @return The quantity.
 *      */
 *     public int getQuantity() {
 *         return quantity;
 *     }
 * 
 *     @Override
 *     public String toString() {
 *         return "Order{id=" + id + ", productId=" + productId + ", quantity=" + quantity + "}";
 *     }
 * }
 * 
 * /**
 *  * Manages the order processing flow including incoming orders,
 *  * available products, processed orders, and failed orders.
 *  */
 * public class OrderProcessingSystem {
 * 
 *     // Using LinkedList as a Queue implementation
 *     private Queue<Order> incomingOrders = new LinkedList<>();
 *     // Using ArrayList for lists of products and processed/failed orders
 *     private List<Product> availableProducts = new ArrayList<>();
 *     private List<Order> processedOrders = new ArrayList<>();
 *     private List<Order> failedOrders = new ArrayList<>();
 * 
 *     private int orderCounter = 1; // To generate unique order IDs (O1, O2, ...)
 * 
 *     /**
 *      * Constructs the OrderProcessingSystem and initializes available products.
 *      */
 *     public OrderProcessingSystem() {
 *         // Pre-populate available products
 *         availableProducts.add(new Product(1, "Laptop"));
 *         availableProducts.add(new Product(2, "Keyboard"));
 *         availableProducts.add(new Product(3, "Mouse"));
 *         System.out.println("System initialized with products.");
 *     }
 * 
 *     /**
 *      * Adds a new order to the incoming orders queue.
 *      * Performs basic validation on input.
 *      * @param productId The ID of the product ordered.
 *      * @param quantity The quantity ordered.
 *      */
 *     public void addOrder(int productId, int quantity) {
 *         if (productId <= 0 || quantity <= 0) {
 *             System.err.println("Error: Product ID and Quantity must be positive integers.");
 *             return;
 *         }
 * 
 *         // Optional: Check if product exists before adding?
 *         // For this problem, we validate during processing, so adding any order is allowed initially.
 * 
 *         String orderId = "O" + orderCounter++;
 *         Order newOrder = new Order(orderId, productId, quantity);
 *         incomingOrders.offer(newOrder); // Use offer for queue
 *         System.out.println("Order " + orderId + " added to queue.");
 *     }
 * 
 *     /**
 *      * Processes the next order from the incoming queue.
 *      * Validates the product and moves the order to processed or failed list.
 *      */
 *     public void processNextOrder() {
 *         Order orderToProcess = incomingOrders.poll(); // Use poll to retrieve and remove
 * 
 *         if (orderToProcess == null) {
 *             System.out.println("No incoming orders to process.");
 *             return;
 *         }
 * 
 *         System.out.println("Processing Order " + orderToProcess.getId() + "...");
 * 
 *         // Validate product existence
 *         Product product = findProductById(orderToProcess.getProductId());
 * 
 *         if (product != null) {
 *             // Product found, process successfully
 *             processedOrders.add(orderToProcess);
 *             System.out.println("Order " + orderToProcess.getId() + " processed successfully.");
 *         } else {
 *             // Product not found, processing fails
 *             failedOrders.add(orderToProcess);
 *             System.err.println("Error processing Order " + orderToProcess.getId() + ": Product with ID " + orderToProcess.getProductId() + " not found.");
 *             System.err.println("Order " + orderToProcess.getId() + " moved to failed orders.");
 *         }
 *     }
 * 
 *     /**
 *      * Displays the current contents of the incoming orders queue.
 *      */
 *     public void viewIncomingOrders() {
 *         System.out.println("\n--- Incoming Orders Queue ---");
 *         if (incomingOrders.isEmpty()) {
 *             System.out.println("Queue is empty.");
 *         } else {
 *             // Iterate through the queue without removing elements
 *             // LinkedList's toString gives a good representation
 *             System.out.println(incomingOrders);
 *         }
 *         System.out.println("-----------------------------");
 *     }
 * 
 *     /**
 *      * Displays the list of successfully processed orders.
 *      */
 *     public void viewProcessedOrders() {
 *         System.out.println("\n--- Processed Orders ---");
 *         if (processedOrders.isEmpty()) {
 *             System.out.println("No orders have been processed successfully yet.");
 *         } else {
 *             for (Order order : processedOrders) { // Iterate through List
 *                 System.out.println(order);
 *             }
 *         }
 *         System.out.println("------------------------");
 *     }
 * 
 *     /**
 *      * Displays the list of failed orders.
 *      */
 *     public void viewFailedOrders() {
 *         System.out.println("\n--- Failed Orders ---");
 *         if (failedOrders.isEmpty()) {
 *             System.out.println("No orders have failed processing yet.");
 *         } else {
 *             for (Order order : failedOrders) { // Iterate through List
 *                 System.out.println(order);
 *             }
 *         }
 *         System.out.println("---------------------");
 *     }
 * 
 *     /**
 *      * Displays the list of available products.
 *      */
 *     public void viewAvailableProducts() {
 *         System.out.println("\n--- Available Products ---");
 *         if (availableProducts.isEmpty()) {
 *             System.out.println("No products available.");
 *         } else {
 *             for (Product product : availableProducts) { // Iterate through List
 *                 System.out.println(product);
 *             }
 *         }
 *         System.out.println("--------------------------");
 *     }
 * 
 *     /**
 *      * Helper method to find a product by its ID in the available products list.
 *      * @param productId The ID of the product to find.
 *      * @return The Product object if found, otherwise null.
 *      */
 *     private Product findProductById(int productId) {
 *         for (Product product : availableProducts) {
 *             if (product.getId() == productId) {
 *                 return product;
 *             }
 *         }
 *         return null; // Product not found
 *     }
 * 
 *     /**
 *      * The main method to run the Order Processing System simulation.
 *      * Includes the main menu loop, Scanner handling, switch statement, and try-catch.
 *      */
 *     public static void main(String[] args) {
 *         OrderProcessingSystem system = new OrderProcessingSystem();
 *         Scanner scanner = new Scanner(System.in);
 *         boolean running = true;
 * 
 *         // Class-wide exception handling for the main operational loop
 *         try {
 *             while (running) {
 *                 printMenu();
 * 
 *                 int choice = -1;
 *                 try {
 *                     System.out.print("Enter your choice: ");
 *                     choice = scanner.nextInt();
 *                 } catch (InputMismatchException e) {
 *                     System.err.println("Invalid input. Please enter a number.");
 *                     scanner.next(); // Consume the invalid input
 *                     continue; // Skip the rest of the loop and show menu again
 *                 }
 * 
 *                 // Consume the rest of the line after reading the integer
 *                 scanner.nextLine();
 * 
 *                 switch (choice) {
 *                     case 1: // Add New Order
 *                         try {
 *                             System.out.print("Enter Product ID: ");
 *                             int productId = scanner.nextInt();
 *                             System.out.print("Enter Quantity: ");
 *                             int quantity = scanner.nextInt();
 *                             scanner.nextLine(); // Consume newline
 *                             system.addOrder(productId, quantity);
 *                         } catch (InputMismatchException e) {
 *                             System.err.println("Invalid input for Product ID or Quantity. Please enter numbers.");
 *                             scanner.next(); // Consume invalid input if any remains before nextLine
 *                             scanner.nextLine(); // Consume the rest of the line
 *                         }
 *                         break;
 *                     case 2: // Process Next Order
 *                         system.processNextOrder();
 *                         break;
 *                     case 3: // View Incoming Orders
 *                         system.viewIncomingOrders();
 *                         break;
 *                     case 4: // View Processed Orders
 *                         system.viewProcessedOrders();
 *                         break;
 *                     case 5: // View Failed Orders
 *                         system.viewFailedOrders();
 *                         break;
 *                     case 6: // View Available Products
 *                         system.viewAvailableProducts();
 *                         break;
 *                     case 7: // Exit
 *                         running = false;
 *                         System.out.println("Exiting system.");
 *                         break;
 *                     default:
 *                         System.err.println("Invalid choice. Please enter a number between 1 and 7.");
 *                 }
 *                 System.out.println(); // Add a newline for better readability
 *             }
 *         } catch (Exception e) {
 *             // Catch any unexpected exceptions during the main loop
 *             System.err.println("An unexpected error occurred: " + e.getMessage());
 *             e.printStackTrace(System.err); // Print stack trace to System.err
 *         } finally {
 *             // Ensure scanner is closed
 *             scanner.close();
 *             System.out.println("Scanner closed.");
 *         }
 *     }
 * 
 *     /**
 *      * Prints the main menu options to the console.
 *      */
 *     private static void printMenu() {
 *         System.out.println("--- E-commerce Order Processing System ---");
 *         System.out.println("1. Add New Order");
 *         System.out.println("2. Process Next Order");
 *         System.out.println("3. View Incoming Orders");
 *         System.out.println("4. View Processed Orders");
 *         System.out.println("5. View Failed Orders");
 *         System.out.println("6. View Available Products");
 *         System.out.println("7. Exit");
 *         System.out.println("------------------------------------------");
 *     }
 * }
 * ```
 * [END_SOLUTION_CODE]
 * 
 * [EXPLANATION]
 * The provided solution implements the E-commerce Order Processing System simulation as described in the exam question, demonstrating the required Java concepts and best practices.
 * 
 * **Core Structure:**
 * 
 * 1.  **`Product` Class:** A simple POJO (Plain Old Java Object) representing a product with `id` and `name`. It uses private fields and public getters for encapsulation and overrides `toString()` for easy printing.
 * 2.  **`Order` Class:** A simple POJO representing an order with a unique `id`, `productId`, and `quantity`. It also uses private fields, public getters, and overrides `toString()`.
 * 3.  **`OrderProcessingSystem` Class:** This is the main class that orchestrates the simulation.
 *     *   It holds the system's state using class-level instance variables:
 *         *   `incomingOrders`: Declared as `Queue<Order>` and initialized with `new LinkedList<>()`. This correctly uses the `Queue` interface and an `ArrayList` implementation (`LinkedList` is a common `Queue` implementation that also implements `List`, but we use it here specifically for its queue behavior).
 *         *   `availableProducts`: Declared as `List<Product>` and initialized with `new ArrayList<>()`. This uses the `List` interface and the `ArrayList` implementation.
 *         *   `processedOrders`: Declared as `List<Order>` and initialized with `new ArrayList<>()`. Uses the `List` interface and `ArrayList`.
 *         *   `failedOrders`: Declared as `List<Order>` and initialized with `new ArrayList<>()`. Uses the `List` interface and `ArrayList`.
 *     *   It has a constructor that initializes the data structures and pre-populates the `availableProducts` list.
 *     *   It contains methods for each menu option (`addOrder`, `processNextOrder`, `viewIncomingOrders`, `viewProcessedOrders`, `viewFailedOrders`, `viewAvailableProducts`) and a helper method (`findProductById`).
 *     *   It includes a `main` method to run the simulation loop, handle user input, and manage the system's lifecycle.
 * 
 * **Required Component Usage:**
 * 
 * 1.  **`Queue` (`java.util.Queue`):** Used for `incomingOrders`. Orders are added using `offer()` and removed for processing using `poll()`. `isEmpty()` is used to check if the queue has orders.
 * 2.  **`ArrayList` (`java.util.ArrayList`):** Used as the concrete implementation for `availableProducts`, `processedOrders`, and `failedOrders`.
 * 3.  **`List` interface (`java.util.List`):** Used as the declared type for `availableProducts`, `processedOrders`, and `failedOrders`. This demonstrates programming to interfaces, a key OOP principle.
 * 4.  **`Scanner` (`java.util.Scanner`):** Used in the `main` method to read user input from `System.in` for menu choices and order details. `nextInt()` is used for numbers, `nextLine()` to consume remaining input.
 * 5.  **`switch` statement:** Used in the `main` method to control the program flow based on the user's menu choice. Includes a `default` case for invalid options.
 * 6.  **`System.err`:** Used to print error messages, specifically for invalid user input (`InputMismatchException`) and for order processing failures (product not found).
 * 7.  **`System.out`:** Used for all standard output, including the menu, system status messages, contents of queues and lists, and success messages.
 * 8.  **`try-catch` blocks:**
 *     *   A large `try-catch` block wraps the main `while(running)` loop in the `main` method, providing "class-wide" exception handling for unexpected errors during the program's execution.
 *     *   Nested `try-catch` blocks are used specifically around `scanner.nextInt()` calls within the `main` loop to handle `InputMismatchException` when the user enters non-integer input. This prevents the program from crashing and allows it to recover by printing an error and prompting again.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** `Product` and `Order` classes have private fields with public getters. The `OrderProcessingSystem` class encapsulates its data structures and logic.
 * *   **Meaningful Names:** Variables (`incomingOrders`, `processedOrders`, `availableProducts`, `orderCounter`, `productId`, `quantity`, `choice`, `running`, etc.) and methods (`addOrder`, `processNextOrder`, `viewIncomingOrders`, `findProductById`, `printMenu`) are named descriptively.
 * *   **Comments and Documentation:** Javadoc comments are included for classes and public methods, explaining their purpose. Inline comments clarify specific logic points.
 * *   **Input Validation:** Basic validation is performed when adding an order (positive ID/quantity) and robust validation for menu input using `try-catch` and `InputMismatchException` handling.
 * *   **Error Handling:** `try-catch` is used for input errors and general unexpected exceptions. `System.err` is used consistently for error output. The `processNextOrder` method explicitly handles the case where the product is not found.
 * *   **Clean Code Structure:** The code is organized into logical classes. The `main` method handles the user interaction loop, delegating the actual system operations to methods within the `OrderProcessingSystem` instance. Helper methods (`findProductById`, `printMenu`) improve readability.
 * 
 * This solution effectively integrates the required Java components into a practical simulation, demonstrating understanding of data structures, control flow, object-oriented principles, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a product available in the system.
 */
class Product {
    private int id;
    private String name;

    /**
     * Constructs a Product object.
     * @param id The unique ID of the product.
     * @param name The name of the product.
     */
    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the product ID.
     * @return The product ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the product name.
     * @return The product name.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "'}";
    }
}

/**
 * Represents an order placed by a customer.
 */
class Order {
    private String id; // Using String for unique ID like O1, O2 etc.
    private int productId;
    private int quantity;

    /**
     * Constructs an Order object.
     * @param id The unique ID of the order.
     * @param productId The ID of the product ordered.
     * @param quantity The quantity of the product ordered.
     */
    public Order(String id, int productId, int quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    /**
     * Gets the order ID.
     * @return The order ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the product ID for this order.
     * @return The product ID.
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Gets the quantity for this order.
     * @return The quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", productId=" + productId + ", quantity=" + quantity + "}";
    }
}

/**
 * Manages the order processing flow including incoming orders,
 * available products, processed orders, and failed orders.
 */
public class OrderProcessingSystem {

    // Using LinkedList as a Queue implementation
    private Queue<Order> incomingOrders = new LinkedList<>();
    // Using ArrayList for lists of products and processed/failed orders
    private List<Product> availableProducts = new ArrayList<>();
    private List<Order> processedOrders = new ArrayList<>();
    private List<Order> failedOrders = new ArrayList<>();

    private int orderCounter = 1; // To generate unique order IDs (O1, O2, ...)

    /**
     * Constructs the OrderProcessingSystem and initializes available products.
     */
    public OrderProcessingSystem() {
        // Pre-populate available products
        availableProducts.add(new Product(1, "Laptop"));
        availableProducts.add(new Product(2, "Keyboard"));
        availableProducts.add(new Product(3, "Mouse"));
        System.out.println("System initialized with products.");
    }

    /**
     * Adds a new order to the incoming orders queue.
     * Performs basic validation on input.
     * @param productId The ID of the product ordered.
     * @param quantity The quantity ordered.
     */
    public void addOrder(int productId, int quantity) {
        if (productId <= 0 || quantity <= 0) {
            System.err.println("Error: Product ID and Quantity must be positive integers.");
            return;
        }

        // Optional: Check if product exists before adding?
        // For this problem, we validate during processing, so adding any order is allowed initially.

        String orderId = "O" + orderCounter++;
        Order newOrder = new Order(orderId, productId, quantity);
        incomingOrders.offer(newOrder); // Use offer for queue
        System.out.println("Order " + orderId + " added to queue.");
    }

    /**
     * Processes the next order from the incoming queue.
     * Validates the product and moves the order to processed or failed list.
     */
    public void processNextOrder() {
        Order orderToProcess = incomingOrders.poll(); // Use poll to retrieve and remove

        if (orderToProcess == null) {
            System.out.println("No incoming orders to process.");
            return;
        }

        System.out.println("Processing Order " + orderToProcess.getId() + "...");

        // Validate product existence
        Product product = findProductById(orderToProcess.getProductId());

        if (product != null) {
            // Product found, process successfully
            processedOrders.add(orderToProcess);
            System.out.println("Order " + orderToProcess.getId() + " processed successfully.");
        } else {
            // Product not found, processing fails
            failedOrders.add(orderToProcess);
            System.err.println("Error processing Order " + orderToProcess.getId() + ": Product with ID " + orderToProcess.getProductId() + " not found.");
            System.err.println("Order " + orderToProcess.getId() + " moved to failed orders.");
        }
    }

    /**
     * Displays the current contents of the incoming orders queue.
     */
    public void viewIncomingOrders() {
        System.out.println("\n--- Incoming Orders Queue ---");
        if (incomingOrders.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            // LinkedList's toString gives a good representation
            System.out.println(incomingOrders);
        }
        System.out.println("-----------------------------");
    }

    /**
     * Displays the list of successfully processed orders.
     */
    public void viewProcessedOrders() {
        System.out.println("\n--- Processed Orders ---");
        if (processedOrders.isEmpty()) {
            System.out.println("No orders have been processed successfully yet.");
        } else {
            for (Order order : processedOrders) { // Iterate through List
                System.out.println(order);
            }
        }
        System.out.println("------------------------");
    }

    /**
     * Displays the list of failed orders.
     */
    public void viewFailedOrders() {
        System.out.println("\n--- Failed Orders ---");
        if (failedOrders.isEmpty()) {
            System.out.println("No orders have failed processing yet.");
        } else {
            for (Order order : failedOrders) { // Iterate through List
                System.out.println(order);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Displays the list of available products.
     */
    public void viewAvailableProducts() {
        System.out.println("\n--- Available Products ---");
        if (availableProducts.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product product : availableProducts) { // Iterate through List
                System.out.println(product);
            }
        }
        System.out.println("--------------------------");
    }

    /**
     * Helper method to find a product by its ID in the available products list.
     * @param productId The ID of the product to find.
     * @return The Product object if found, otherwise null.
     */
    private Product findProductById(int productId) {
        for (Product product : availableProducts) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }

    /**
     * The main method to run the Order Processing System simulation.
     * Includes the main menu loop, Scanner handling, switch statement, and try-catch.
     */
    public static void main(String[] args) {
        OrderProcessingSystem system = new OrderProcessingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling for the main operational loop
        try {
            while (running) {
                printMenu();

                int choice = -1;
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Skip the rest of the loop and show menu again
                }

                // Consume the rest of the line after reading the integer
                scanner.nextLine();

                switch (choice) {
                    case 1: // Add New Order
                        try {
                            System.out.print("Enter Product ID: ");
                            int productId = scanner.nextInt();
                            System.out.print("Enter Quantity: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            system.addOrder(productId, quantity);
                        } catch (InputMismatchException e) {
                            System.err.println("Invalid input for Product ID or Quantity. Please enter numbers.");
                            scanner.next(); // Consume invalid input if any remains before nextLine
                            scanner.nextLine(); // Consume the rest of the line
                        }
                        break;
                    case 2: // Process Next Order
                        system.processNextOrder();
                        break;
                    case 3: // View Incoming Orders
                        system.viewIncomingOrders();
                        break;
                    case 4: // View Processed Orders
                        system.viewProcessedOrders();
                        break;
                    case 5: // View Failed Orders
                        system.viewFailedOrders();
                        break;
                    case 6: // View Available Products
                        system.viewAvailableProducts();
                        break;
                    case 7: // Exit
                        running = false;
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 7.");
                }
                System.out.println(); // Add a newline for better readability
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure scanner is closed
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- E-commerce Order Processing System ---");
        System.out.println("1. Add New Order");
        System.out.println("2. Process Next Order");
        System.out.println("3. View Incoming Orders");
        System.out.println("4. View Processed Orders");
        System.out.println("5. View Failed Orders");
        System.out.println("6. View Available Products");
        System.out.println("7. Exit");
        System.out.println("------------------------------------------");
    }
}
