/*
 * Exam Question #607
 * Generated on: 2025-05-12 16:14:10
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Java Programming Exam Task: E-commerce Order Fulfillment System**
 * 
 * You are tasked with developing a simplified backend system for managing product inventory and processing customer orders for an e-commerce platform. The system should allow an administrator to view products, place new orders, process pending orders, and view the order queue.
 * 
 * Your solution must be written in Java and adhere to the following requirements:
 * 
 * 1.  **Data Structures:**
 *     *   Use `java.util.List` (implemented by `java.util.ArrayList`) to store the product inventory.
 *     *   Use `java.util.Queue` (implemented by a suitable class like `java.util.LinkedList`) to manage pending customer orders in a First-In, First-Out (FIFO) manner.
 * 
 * 2.  **Input/Output:**
 *     *   Use `java.util.Scanner` to read user input from the console (e.g., menu choices, order details).
 *     *   Use `System.out` for displaying normal output (menus, product lists, successful actions, order details).
 *     *   Use `System.err` for displaying error messages (invalid input, product not found, empty queue, etc.).
 * 
 * 3.  **Control Flow:**
 *     *   Implement a main application loop that presents a menu to the user.
 *     *   Use a `switch` statement to handle the user's menu selection.
 * 
 * 4.  **Error Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors, especially related to user input parsing (`Scanner`).
 *     *   Provide specific error messages using `System.err` for common issues like non-numeric input, invalid menu choices, placing orders for non-existent products, or attempting to process/view an empty queue.
 * 
 * 5.  **Object-Oriented Design & Best Practices:**
 *     *   Create separate classes for `Product` and `Order` with appropriate private fields and public getter methods (encapsulation).
 *     *   Implement the core logic within a main system class (e.g., `OrderFulfillmentSystem`).
 *     *   Use meaningful variable and method names.
 *     *   Include basic comments or Javadoc to explain key parts of the code.
 *     *   Implement input validation within the `placeOrder` functionality (e.g., check if product ID exists, quantity is positive).
 * 
 * **Functionality Details:**
 * 
 * *   **Initialize:** The system should start with a pre-defined list of products in the inventory (`List<Product>`). The order queue (`Queue<Order>`) should start empty.
 * *   **Menu Options:**
 *     1.  **View Products:** Display the list of all available products from the inventory.
 *     2.  **Place Order:**
 *         *   Prompt the user to enter a Product ID and quantity.
 *         *   Validate that the input is numeric.
 *         *   Validate that the entered Product ID exists in the inventory.
 *         *   Validate that the quantity is a positive number.
 *         *   If valid, create a new `Order` object (assign a unique order ID, perhaps sequentially) and add it to the `pendingOrders` queue.
 *         *   Print a success message (`System.out`).
 *         *   If invalid input or product not found, print an error message (`System.err`).
 *     3.  **Process Next Order:**
 *         *   Check if the `pendingOrders` queue is empty. If so, print an error (`System.err`).
 *         *   If not empty, remove the order at the front of the queue (`Queue.poll()`) and display its details as being processed (`System.out`).
 *     4.  **View Order Queue:**
 *         *   Check if the `pendingOrders` queue is empty. If so, print an error (`System.err`).
 *         *   If not empty, display the details of all orders currently in the queue without removing them.
 *     5.  **Exit:** Terminate the application.
 * 
 * **Expected Output Structure:**
 * 
 * *   Menu is displayed repeatedly until 'Exit' is chosen.
 * *   User prompts for input.
 * *   Output related to successful actions (viewing, placing, processing) goes to `System.out`.
 * *   Output related to errors (invalid input, empty queue, product not found) goes to `System.err`.
 * 
 * Design and implement the Java code for this system.
 *
 * EXPLANATION:
 * The provided solution implements a basic E-commerce Order Fulfillment System, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure and Encapsulation:**
 *     *   `Product` and `Order` classes are simple Plain Old Java Objects (POJOs) representing the core entities. They have private fields (`id`, `name`, `price`, `orderId`, `productId`, `quantity`) and public getter methods (`getId`, `getName`, etc.), adhering to encapsulation principles. The `Order` class uses a static counter to generate simple unique `orderId`s.
 *     *   `OrderFulfillmentSystem` is the main class orchestrating the system logic. It holds the data structures (`inventory` and `pendingOrders`) and the operational methods (`displayProducts`, `placeOrder`, `processNextOrder`, `viewOrderQueue`, `run`). Its fields are also private.
 * 
 * 2.  **Data Structures (`List`/`ArrayList` and `Queue`/`LinkedList`):**
 *     *   `List<Product> inventory = new ArrayList<>();`: An `ArrayList` is used to store the `Product` objects. `ArrayList` provides dynamic resizing and efficient random access (though we primarily iterate), suitable for managing a list of products. The type is declared as `List` to program to the interface, which is a best practice.
 *     *   `Queue<Order> pendingOrders = new LinkedList<>();`: A `LinkedList` is used to implement the `Queue` interface for managing orders. A `Queue` is appropriate here because orders are typically processed in the order they are received (FIFO). `LinkedList` is a common and efficient implementation for `Queue` operations like `offer()` (add to end) and `poll()` (remove from front). The type is declared as `Queue` to program to the interface.
 * 
 * 3.  **Input Handling (`Scanner`) and Control Flow (`Switch`):**
 *     *   `Scanner scanner = new Scanner(System.in);`: A `Scanner` object reads input from the standard input stream (`System.in`).
 *     *   `displayMenu()`: Prints the available options to `System.out`.
 *     *   The `run()` method contains a `while` loop that continues until the user chooses to exit.
 *     *   `switch (choice)`: A `switch` statement directs the program flow based on the integer input received from the user, calling the appropriate method for each menu option.
 * 
 * 4.  **Error Handling (`System.err`, `try-catch`):**
 *     *   `System.out` is used for standard output like displaying the menu, product lists, and success messages.
 *     *   `System.err` is used specifically for printing error messages, making them distinct from normal output. This is used for invalid input, empty queues, product not found, etc.
 *     *   `try-catch` blocks are strategically placed:
 *         *   An inner `try-catch(InputMismatchException)` block within `run()` handles cases where the user enters non-integer input for the main menu choice. It catches the specific exception thrown by `scanner.nextInt()` and prints an error to `System.err`. `scanner.nextLine()` is called within the catch block to consume the invalid input line, preventing an infinite loop.
 *         *   Another `try-catch(InputMismatchException)` block is used in `placeOrder()` to handle non-integer input when asking for product ID and quantity. It functions similarly to the one in `run()`.
 *         *   A general `catch(Exception e)` block is included in the main `run()` loop. This provides class-wide exception handling, catching any unexpected exceptions that might occur during the execution of the selected menu option and were not handled by more specific `try-catch` blocks. It prints a general error message to `System.err`.
 *     *   Input validation (checking if product exists, quantity is positive) is performed in `placeOrder()` using `if` statements, and error messages are printed to `System.err`.
 *     *   Methods like `processNextOrder()` and `viewOrderQueue()` check if the queue is empty before attempting operations and print error messages to `System.err` if it is.
 * 
 * 5.  **Method Implementation:**
 *     *   `initializeInventory()`: Populates the `inventory` list with sample `Product` objects.
 *     *   `displayProducts()`: Iterates through the `inventory` list and prints product details.
 *     *   `placeOrder()`: Guides the user to place an order, reads and validates input, searches the `inventory` list for the product, creates an `Order` object, and adds it to the `pendingOrders` queue using `offer()`.
 *     *   `processNextOrder()`: Uses `poll()` to retrieve and remove the head element from the `pendingOrders` queue, simulating processing.
 *     *   `viewOrderQueue()`: Iterates through the `pendingOrders` queue using a for-each loop (which uses an iterator) to display its contents without removing elements.
 * 
 * This solution effectively integrates all the required Java components within a practical scenario, demonstrating understanding of data structures, control flow, error handling, and object-oriented principles.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException; // Specific exception for Scanner type mismatches

// Class representing a Product in the inventory
class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters for product details
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + String.format("%.2f", price);
    }
}

// Class representing a Customer Order
class Order {
    private static int orderCounter = 0; // Static counter for unique order IDs
    private int orderId;
    private int productId;
    private int quantity;

    public Order(int productId, int quantity) {
        this.orderId = ++orderCounter; // Assign unique ID upon creation
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters for order details
    public int getOrderId() { return orderId; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return "Order #" + orderId + " [Product ID: " + productId + ", Quantity: " + quantity + "]";
    }
}

// Main system class managing inventory and orders
public class OrderFulfillmentSystem {

    private List<Product> inventory; // Inventory stored in a List (ArrayList implementation)
    private Queue<Order> pendingOrders; // Orders waiting for processing (Queue implementation)
    private Scanner scanner; // Scanner for user input

    // Constructor: Initializes inventory, queue, and scanner
    public OrderFulfillmentSystem() {
        // Use ArrayList for inventory
        inventory = new ArrayList<>();
        // Use LinkedList as it implements both Queue and List, suitable for a queue
        pendingOrders = new LinkedList<>();
        scanner = new Scanner(System.in);
        initializeInventory(); // Populate initial products
    }

    // Populates the inventory with some sample products
    private void initializeInventory() {
        inventory.add(new Product(101, "Laptop", 1200.00));
        inventory.add(new Product(102, "Keyboard", 75.00));
        inventory.add(new Product(103, "Mouse", 25.50));
        inventory.add(new Product(104, "Monitor", 300.00));
        System.out.println("Inventory initialized with " + inventory.size() + " products.");
    }

    // Displays the list of available products
    private void displayProducts() {
        System.out.println("\n--- Available Products ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            // Iterate through the List and print each product
            for (Product product : inventory) {
                System.out.println(product); // Product.toString() is called implicitly
            }
        }
        System.out.println("--------------------------");
    }

    // Handles placing a new order based on user input
    private void placeOrder() {
        System.out.println("\n--- Place New Order ---");
        displayProducts(); // Show products to help user choose

        int productId = -1;
        int quantity = -1;

        // Try-catch block for handling potential input errors (non-numeric)
        try {
            System.out.print("Enter Product ID to order: ");
            productId = scanner.nextInt();

            System.out.print("Enter quantity: ");
            quantity = scanner.nextInt();

            // Consume the rest of the line after reading integers to prevent issues
            scanner.nextLine();

        } catch (InputMismatchException e) {
            // Specific catch for non-integer input from Scanner
            System.err.println("Error: Invalid input. Please enter numeric values for ID and quantity.");
            scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            return; // Exit the method on input error
        } catch (Exception e) {
             // Catch any other unexpected issues during input reading
             System.err.println("An unexpected error occurred during input reading: " + e.getMessage());
             scanner.nextLine(); // Consume line just in case
             return;
        }

        // Validate quantity
        if (quantity <= 0) {
            System.err.println("Error: Quantity must be positive.");
            return; // Exit the method on validation failure
        }

        // Find the product in the inventory List
        Product orderedProduct = null;
        for (Product product : inventory) {
            if (product.getId() == productId) {
                orderedProduct = product;
                break; // Found the product, exit loop
            }
        }

        // Validate product existence
        if (orderedProduct == null) {
            System.err.println("Error: Product with ID " + productId + " not found in inventory.");
            return; // Exit the method if product not found
        }

        // Create and add the order to the pendingOrders Queue
        Order newOrder = new Order(productId, quantity);
        pendingOrders.offer(newOrder); // offer() is used to add to the end of the queue
        System.out.println("Order #" + newOrder.getOrderId() + " placed successfully for " + quantity + " of Product ID " + productId + ".");
    }

    // Processes the next order from the front of the queue
    private void processNextOrder() {
        System.out.println("\n--- Process Next Order ---");
        // Check if the queue is empty
        if (pendingOrders.isEmpty()) {
            System.err.println("No pending orders in the queue to process.");
            return;
        }

        // Get and remove the head of the queue using poll()
        Order orderToProcess = pendingOrders.poll();
        System.out.println("Processing " + orderToProcess + "...");
        // In a real system, this would involve updating inventory, payment processing, etc.
        System.out.println("Order #" + orderToProcess.getOrderId() + " processed successfully.");
    }

    // Displays all orders currently waiting in the queue
    private void viewOrderQueue() {
        System.out.println("\n--- Pending Order Queue ---");
        // Check if the queue is empty
        if (pendingOrders.isEmpty()) {
            System.err.println("The order queue is empty.");
            return;
        }

        // Iterate through the queue without removing elements
        int count = 1;
        // Using a for-each loop (which uses an iterator internally) to traverse the Queue
        for (Order order : pendingOrders) {
            System.out.println(count++ + ". " + order); // Order.toString() is called implicitly
        }
        System.out.println("---------------------------");
    }

    // Displays the main menu options
    private void displayMenu() {
        System.out.println("\n--- E-commerce Order Fulfillment System ---");
        System.out.println("1. View Products");
        System.out.println("2. Place Order");
        System.out.println("3. Process Next Order");
        System.out.println("4. View Order Queue");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Main application loop and class-wide exception handling
    public void run() {
        int choice = -1;
        // Loop until the user chooses to exit (option 5)
        while (choice != 5) {
            displayMenu();
            try {
                // Inner try-catch specifically for reading the menu choice to handle non-integer input
                try {
                     choice = scanner.nextInt();
                     // Consume the newline character left by nextInt()
                     scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number corresponding to the menu options.");
                    scanner.nextLine(); // Consume the invalid line to prevent infinite loop
                    choice = -1; // Reset choice to an invalid value to continue the loop
                    continue; // Skip the switch statement for this iteration
                }

                // Switch statement to handle valid menu choices
                switch (choice) {
                    case 1:
                        displayProducts();
                        break;
                    case 2:
                        placeOrder(); // This method has its own specific try-catch for order details
                        break;
                    case 3:
                        processNextOrder();
                        break;
                    case 4:
                        viewOrderQueue();
                        break;
                    case 5:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        // Handle choices that are integers but not in the menu range
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (Exception e) {
                // Class-wide exception handling for any unexpected errors during the main loop
                // This catches exceptions not handled by the more specific try-catch blocks
                System.err.println("An unexpected system error occurred: " + e.getMessage());
                // Optional: e.printStackTrace(); // Uncomment for detailed debugging
                // Depending on the error, you might choose to exit or attempt to continue.
                // For this example, the loop continues after an unexpected error.
            }
        }
        scanner.close(); // Close the scanner resource when the application exits
    }

    // Main method to start the application
    public static void main(String[] args) {
        OrderFulfillmentSystem system = new OrderFulfillmentSystem();
        system.run(); // Start the main application loop
    }
}
