/*
 * Exam Question #834
 * Generated on: 2025-05-12 16:48:11
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Restaurant Order Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified Restaurant Order Management System. The system should allow staff to view the menu, take new customer orders, process orders in the order they were received, and view the queue of pending orders.
 * 
 * The system should be interactive, using a command-line interface for input and output. It must handle basic errors gracefully.
 * 
 * **Core Functionality Requirements:**
 * 
 * 1.  **Menu Management (Pre-defined):** The system should have a fixed menu of items with an ID, name, and price. This menu should be initialized when the system starts.
 * 2.  **Order Creation:** Staff should be able to create a new order. An order consists of one or more menu items with specified quantities. The system should prompt the user for item IDs and quantities, allowing multiple items per order. Input validation is required to ensure the item ID exists and the quantity is positive.
 * 3.  **Order Queuing:** New orders, once completed by the staff member, should be added to a queue for processing. Orders must be processed in the order they were received (FIFO - First-In, First-Out).
 * 4.  **Order Processing:** Staff should be able to process the next order in the queue. Processing an order involves removing it from the queue and displaying its details, including the total cost. If the queue is empty, the system should indicate this error.
 * 5.  **View Queue:** Staff should be able to view all orders currently waiting in the queue without removing them.
 * 6.  **User Interface:** Provide a simple menu-driven interface using numbers for different actions (e.g., 1 for View Menu, 2 for Add Order, 3 for Process Next Order, 4 for View Queue, 5 for Exit).
 * 7.  **Error Handling:**
 *     *   Handle invalid menu choices in the main menu.
 *     *   Handle non-numeric input when expecting numbers (e.g., for menu choice, item ID, quantity).
 *     *   Handle cases where an invalid item ID is entered during order creation.
 *     *   Handle the case where there are no orders to process.
 *     *   Use `System.err` for error messages and `System.out` for normal output and prompts.
 *     *   Implement class-wide exception handling using `try-catch` blocks where appropriate, especially around user input operations.
 * 
 * **Specific Java Component Requirements:**
 * 
 * Your solution *must* demonstrate the proper use of **ALL** of the following Java components:
 * 
 * *   `java.util.Queue`
 * *   `java.util.ArrayList`
 * *   `java.util.List` (used as an interface type)
 * *   `java.util.Scanner` for user input
 * *   `switch` statement for the main menu flow control
 * *   `System.err` for error messages
 * *   `System.out` for normal output and prompts
 * *   Class-wide exception handling with `try-catch` blocks
 * 
 * **Code Structure and Best Practices:**
 * 
 * *   Use separate classes for `MenuItem`, `OrderItem`, and `Order` to model the data.
 * *   Use a main class (e.g., `RestaurantOrderSystem`) to manage the menu, the order queue, and the user interaction loop.
 * *   Implement proper encapsulation (private fields, public getters/methods).
 * *   Use meaningful variable and method names.
 * *   Include comments to explain complex logic.
 * *   Ensure input validation is robust.
 * 
 * **Expected Output:**
 * 
 * The system should display a main menu, respond to user input, display information (menu, queue, processed orders) clearly, and print errors to the standard error stream.
 * 
 * Example Interaction Snippet (Illustrative):
 * 
 * ```
 * --- Restaurant Order Management ---
 * 1. View Menu
 * 2. Add New Order
 * 3. Process Next Order
 * 4. View Order Queue
 * 5. Exit
 * Enter choice: 1
 * --- Menu ---
 * ID: 1, Name: Burger, Price: $5.99
 * ID: 2, Name: Fries, Price: $2.49
 * ID: 3, Name: Soda, Price: $1.99
 * --- End Menu ---
 * Enter choice: 2
 * --- Add New Order ---
 * Enter customer name (optional): John Doe
 * Adding items to order...
 * Enter Menu Item ID (or 0 to finish): 1
 * Enter quantity: 2
 * Item added: Burger (x2)
 * Add another item? (y/n): y
 * Enter Menu Item ID (or 0 to finish): 3
 * Enter quantity: 3
 * Item added: Soda (x3)
 * Add another item? (y/n): n
 * Order #1 created and added to queue. Total: $17.95
 * Enter choice: 4
 * --- Pending Orders ---
 * Order #1 (John Doe): 2 x Burger, 3 x Soda (Total: $17.95)
 * --- End Queue ---
 * Enter choice: 3
 * Processing next order...
 * --- Processed Order #1 (John Doe) ---
 * Items:
 *   Burger x 2 ($11.98)
 *   Soda x 3 ($5.97)
 * Total: $17.95
 * --- End Processed Order ---
 * Enter choice: 3
 * Error: No orders in the queue to process.
 * Enter choice: 5
 * Exiting system. Goodbye!
 * ```
 * 
 * **Assessment Criteria:**
 * 
 * *   Correct implementation of all required Java components.
 * *   Accuracy of business logic (order creation, queuing, processing, total calculation).
 * *   Effectiveness of input validation and error handling using `try-catch` and `System.err`.
 * *   Adherence to code structure and best practices (encapsulation, naming, comments).
 * *   Clarity and correctness of output.
 * 
 * **Time Limit:** 45-60 minutes
 * 
 * **Note:** You do not need to persist data to files or databases. The system can run in memory.
 *
 * EXPLANATION:
 * This solution implements the Restaurant Order Management System as required, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `MenuItem`: A simple class to hold the properties of a menu item (`id`, `name`, `price`). Uses encapsulation with private fields and public getters. Includes a `toString()` for easy display.
 *     *   `OrderItem`: Represents a specific item *within* an order, linking a `MenuItem` to a `quantity`. Calculates the line total. Uses encapsulation and `toString()`.
 *     *   `Order`: Represents a complete customer order. Contains a unique `orderId`, a `List` of `OrderItem`s (using `ArrayList` for implementation), and an optional `customerName`. It provides methods to add items and calculate the total order cost. Uses encapsulation and overrides `toString()` and provides `toDetailedString()` for different output needs. It uses a static counter for order IDs, demonstrating a simple way to generate unique identifiers.
 *     *   `RestaurantOrderSystem`: The main orchestrator class. It holds the `menu` (as a `List<MenuItem>`, implemented by `ArrayList`) and the `orderQueue` (as a `Queue<Order>`, implemented by `LinkedList`). It manages user interaction via `Scanner` and controls the flow using a `switch` statement within a loop.
 * 
 * 2.  **Required Components Usage:**
 *     *   `java.util.Queue`: Used for `orderQueue` (`Queue<Order> orderQueue = new LinkedList<>();`). New orders are added using `offer()`, and orders are processed and removed using `poll()`. The `viewOrderQueue()` method iterates over the queue without removing elements.
 *     *   `java.util.ArrayList`: Used to implement the `List` interface for both the `menu` (`List<MenuItem> menu = new ArrayList<>();`) and the list of items within an `Order` (`private List<OrderItem> items; ... this.items = new ArrayList<>();`).
 *     *   `java.util.List`: Used as the interface type for declaring the `menu` and the `items` list within the `Order` class (`List<MenuItem> menu;`, `List<OrderItem> items;`). This demonstrates programming to the interface.
 *     *   `java.util.Scanner`: Used in the `RestaurantOrderSystem` class (`private Scanner scanner;`) to read user input from `System.in`.
 *     *   `switch`: Used in the `run()` method to handle the main menu choices (View Menu, Add Order, Process Order, View Queue, Exit).
 *     *   `System.err`: Used specifically for printing error messages, such as invalid menu choices, invalid input types (`InputMismatchException`), invalid item IDs, invalid quantities, and when trying to process an empty queue.
 *     *   `System.out`: Used for all normal output, including the main menu, the restaurant menu display, prompts for user input, confirmations (item added, order created), and the details of processed orders.
 *     *   `Class-wide exception handling with try-catch blocks`:
 *         *   A `try-catch(InputMismatchException)` block is used around `scanner.nextInt()` calls within the `run()` method (for the main menu choice) and within the `addOrder()` method (for item ID and quantity) to catch non-numeric input.
 *         *   A general `try-catch(Exception)` block is included in the main loop within `run()` to catch any unexpected runtime errors that might occur during operation processing.
 *         *   A `try-catch(Exception)` is also used within the `addOrder` loop to handle potential issues during item input, providing robustness.
 *         *   A `finally` block is used in `run()` to ensure the `Scanner` is closed when the application terminates, regardless of how it exits (normal or via exception).
 * 
 * 3.  **Input Validation and Error Handling:**
 *     *   In `run()`, the `switch` statement handles valid choices, and the `default` case handles invalid numbers. `InputMismatchException` is caught for non-integer input.
 *     *   In `addOrder()`, a loop allows adding multiple items.
 *         *   Input for item ID and quantity uses `try-catch(InputMismatchException)` to handle non-numeric input. If caught, an error is printed to `System.err`, and `scanner.nextLine()` is called to clear the invalid input from the buffer, preventing an infinite loop.
 *         *   The entered item ID is validated against the existing `menu` using the `findMenuItemById()` helper method. If not found, an error is printed to `System.err`.
 *         *   The entered quantity is validated to ensure it's greater than 0. If not, an error is printed to `System.err`.
 *     *   In `processNextOrder()`, `orderQueue.poll()` is checked. If it returns `null` (meaning the queue was empty), an error message is printed to `System.err`.
 * 
 * 4.  **Best Practices:**
 *     *   **Encapsulation:** All data fields in `MenuItem`, `OrderItem`, `Order`, and `RestaurantOrderSystem` are `private`. Public getter methods are provided where necessary to access data.
 *     *   **Meaningful Names:** Classes (`MenuItem`, `Order`, `RestaurantOrderSystem`), variables (`orderQueue`, `menu`, `customerName`, `quantity`), and methods (`displayMenu`, `addOrder`, `processNextOrder`, `findMenuItemById`) have descriptive names.
 *     *   **Comments:** Javadoc-style comments explain the purpose of classes and key methods. Inline comments explain specific logic steps, especially in `addOrder` and the `try-catch` blocks.
 *     *   **Clean Code:** Logic is separated into distinct methods (`addOrder`, `processNextOrder`, `viewOrderQueue`). The `run()` method provides a clear loop for the main program flow. The use of `scanner.nextLine()` after reading numbers is crucial for correct input handling when mixing `nextInt()`/`nextDouble()` with `nextLine()`.
 * 
 * This solution effectively integrates the required Java components into a practical scenario, demonstrating understanding of data structures (`List`, `Queue`), object-oriented design (multiple classes with relationships), user interaction (`Scanner`, `switch`), and robust error handling (`try-catch`, `System.err`).
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue and List
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a single item on the restaurant menu
class MenuItem {
    private int id;
    private String name;
    private double price;

    public MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

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
        return "ID: " + id + ", Name: " + name + ", Price: $" + String.format("%.2f", price);
    }
}

// Represents a specific item and quantity within a customer order
class OrderItem {
    private MenuItem menuItem;
    private int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    // Calculate the total cost for this specific item line
    public double getLineTotal() {
        return menuItem.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + " x " + menuItem.getName() + " ($" + String.format("%.2f", getLineTotal()) + ")";
    }
}

// Represents a complete customer order
class Order {
    private static int nextOrderIdCounter = 1; // Static counter for unique order IDs
    private int orderId;
    private List<OrderItem> items; // Using List interface
    private String customerName; // Optional

    public Order(String customerName) {
        this.orderId = nextOrderIdCounter++;
        this.items = new ArrayList<>(); // Using ArrayList implementation
        this.customerName = customerName;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return items; // Return the list of order items
    }

    public String getCustomerName() {
        return customerName;
    }

    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }

    // Calculate the total cost for the entire order
    public double getTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getLineTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderId);
        if (customerName != null && !customerName.trim().isEmpty()) {
            sb.append(" (").append(customerName).append(")");
        }
        sb.append(" (Total: $").append(String.format("%.2f", getTotal())).append(")");
        return sb.toString();
    }

    // Detailed string for processing
    public String toDetailedString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Processed Order #").append(orderId);
        if (customerName != null && !customerName.trim().isEmpty()) {
            sb.append(" (").append(customerName).append(")");
        }
        sb.append(" ---\n");
        sb.append("Items:\n");
        for (OrderItem item : items) {
            sb.append("  ").append(item.toString()).append("\n");
        }
        sb.append("Total: $").append(String.format("%.2f", getTotal())).append("\n");
        sb.append("--- End Processed Order ---");
        return sb.toString();
    }
}

// Main class managing the restaurant system
public class RestaurantOrderSystem {
    private List<MenuItem> menu; // Using List interface
    private Queue<Order> orderQueue; // Using Queue interface
    private Scanner scanner;

    public RestaurantOrderSystem() {
        // Initialize menu using ArrayList
        menu = new ArrayList<>();
        menu.add(new MenuItem(1, "Burger", 5.99));
        menu.add(new MenuItem(2, "Fries", 2.49));
        menu.add(new MenuItem(3, "Soda", 1.99));
        menu.add(new MenuItem(4, "Pizza Slice", 3.50));
        menu.add(new MenuItem(5, "Salad", 6.75));

        // Initialize order queue using LinkedList (which implements Queue)
        orderQueue = new LinkedList<>();

        scanner = new Scanner(System.in);
    }

    // Helper method to find a menu item by its ID
    private MenuItem findMenuItemById(int id) {
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Return null if not found
    }

    // Display the restaurant menu
    private void displayMenu() {
        System.out.println("--- Menu ---");
        for (MenuItem item : menu) {
            System.out.println(item);
        }
        System.out.println("--- End Menu ---");
    }

    // Add a new order to the queue
    private void addOrder() {
        System.out.println("--- Add New Order ---");
        System.out.print("Enter customer name (optional, press Enter to skip): ");
        String customerName = scanner.nextLine(); // Use nextLine to get potentially empty or spaced names

        Order newOrder = new Order(customerName);
        boolean addingItems = true;

        while (addingItems) {
            displayMenu(); // Show menu to help staff
            System.out.println("Adding items to order...");

            try {
                System.out.print("Enter Menu Item ID (or 0 to finish): ");
                int itemId = scanner.nextInt();

                if (itemId == 0) {
                    addingItems = false; // Finish adding items
                    // Consume the rest of the line after reading int
                    scanner.nextLine();
                    continue; // Skip to the next iteration condition check
                }

                MenuItem selectedItem = findMenuItemById(itemId);

                if (selectedItem == null) {
                    System.err.println("Error: Invalid Menu Item ID. Please try again.");
                    // Consume the rest of the line after reading int
                    scanner.nextLine();
                    continue; // Ask for item ID again
                }

                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();

                if (quantity <= 0) {
                    System.err.println("Error: Quantity must be positive. Please try again.");
                    // Consume the rest of the line after reading int
                    scanner.nextLine();
                    continue; // Ask for quantity again
                }

                // Consume the rest of the line after reading int before nextLine()
                scanner.nextLine();

                OrderItem orderItem = new OrderItem(selectedItem, quantity);
                newOrder.addOrderItem(orderItem);
                System.out.println("Item added: " + selectedItem.getName() + " (x" + quantity + ")");

                // Ask if staff wants to add more items
                System.out.print("Add another item? (y/n): ");
                String response = scanner.nextLine().trim().toLowerCase();
                if (!response.equals("y")) {
                    addingItems = false;
                }

            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions during item adding
                System.err.println("An unexpected error occurred while adding item: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to err
                scanner.nextLine(); // Attempt to clear input
                addingItems = false; // Exit item adding loop on unexpected error
            }
        } // End while(addingItems)

        if (!newOrder.getItems().isEmpty()) {
            orderQueue.offer(newOrder); // Add the completed order to the queue
            System.out.println("Order #" + newOrder.getOrderId() + " created and added to queue. Total: $" + String.format("%.2f", newOrder.getTotal()));
        } else {
            System.out.println("No items added. Order cancelled.");
        }
        System.out.println("--- End Add New Order ---");
    }

    // Process the next order from the queue
    private void processNextOrder() {
        System.out.println("Processing next order...");
        Order nextOrder = orderQueue.poll(); // Retrieve and remove the head of the queue

        if (nextOrder == null) {
            System.err.println("Error: No orders in the queue to process.");
        } else {
            System.out.println(nextOrder.toDetailedString());
        }
    }

    // View all orders currently in the queue
    private void viewOrderQueue() {
        System.out.println("--- Pending Orders ---");
        if (orderQueue.isEmpty()) {
            System.out.println("The order queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            int position = 1;
            for (Order order : orderQueue) {
                System.out.println(position++ + ". " + order);
            }
        }
        System.out.println("--- End Queue ---");
    }

    // Display the main system menu
    private void displayMainMenu() {
        System.out.println("\n--- Restaurant Order Management ---");
        System.out.println("1. View Menu");
        System.out.println("2. Add New Order");
        System.out.println("3. Process Next Order");
        System.out.println("4. View Order Queue");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    // Main loop to run the system
    public void run() {
        int choice = -1;

        // Class-wide try-catch for the main application loop
        try {
            while (choice != 5) {
                displayMainMenu();

                try {
                    choice = scanner.nextInt();
                    // Consume the newline character left by nextInt()
                    scanner.nextLine();

                    // Use switch statement for flow control
                    switch (choice) {
                        case 1:
                            displayMenu();
                            break;
                        case 2:
                            addOrder();
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
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    choice = -1; // Reset choice to stay in the loop
                } catch (Exception e) {
                    // Catch any other unexpected exceptions within the loop
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    e.printStackTrace(System.err); // Print stack trace to err
                    // Decide whether to exit or try to continue based on severity
                    // For this exam, we can continue the loop
                }
            }
        } finally {
            // Ensure scanner is closed when the application exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        RestaurantOrderSystem system = new RestaurantOrderSystem();
        system.run();
    }
}
