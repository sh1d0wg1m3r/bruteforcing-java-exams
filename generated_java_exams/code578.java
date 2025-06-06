/*
 * Exam Question #578
 * Generated on: 2025-05-12 16:09:49
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Warehouse Order Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple console-based application to simulate a basic order management system for a warehouse. Orders arrive and are placed in a queue to await processing. Once an order is processed, it is moved to a list of completed orders. The system should allow users to interact with the order queue and completed orders list through a menu interface.
 * 
 * **Task:**
 * 
 * Implement a Java program that models this warehouse order management system.
 * 
 * **Requirements:**
 * 
 * 1.  **Order Representation:** Create a class `Order` with private fields for `orderId` (an integer) and `description` (a String). Include a constructor and public getter methods for these fields. Override the `toString()` method to provide a readable representation of an Order.
 * 2.  **Warehouse Management:** Create a class `Warehouse` that manages the orders.
 *     *   It must have a private field `pendingOrders` of type `Queue<Order>` to store orders awaiting processing. Use a concrete implementation like `java.util.LinkedList`.
 *     *   It must have a private field `completedOrders` declared as `List<Order>` and initialized with an instance of `java.util.ArrayList<Order>`.
 *     *   Include public methods:
 *         *   `addOrder(Order order)`: Adds an order to the `pendingOrders` queue.
 *         *   `processNextOrder()`: Removes the next order from the `pendingOrders` queue and adds it to the `completedOrders` list. If the queue is empty, print an appropriate error message to `System.err`.
 *         *   `getPendingOrders()`: Returns a `List<Order>` representation of the current orders in the `pendingOrders` queue (do not return the internal queue object directly, convert its contents to a `List`).
 *         *   `getCompletedOrders()`: Returns the `List<Order>` of completed orders.
 * 3.  **User Interface:** Create a main class (e.g., `WarehouseApp`) with a `main` method that provides a menu-driven interface using `java.util.Scanner` for user input. The menu options should be:
 *     1.  Add New Order
 *     2.  Process Next Order
 *     3.  View Pending Orders
 *     4.  View Completed Orders
 *     5.  Exit
 * 4.  **Flow Control:** Use a `switch` statement to handle the user's menu choice.
 * 5.  **Output:**
 *     *   Use `System.out.println()` for displaying the menu, successful actions, and listing orders.
 *     *   Use `System.err.println()` for displaying error messages (e.g., invalid input, attempting to process an empty queue).
 * 6.  **Exception Handling:** Implement robust error handling using `try-catch` blocks. Specifically:
 *     *   Handle `NumberFormatException` when reading integer input (like menu choice or Order ID).
 *     *   Include a general `catch (Exception e)` block in the main loop to catch any unexpected runtime errors and print an error message to `System.err`.
 * 7.  **Best Practices:**
 *     *   Follow proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments to explain code sections.
 *     *   Validate user input where necessary (e.g., ensure Order ID is a valid integer).
 * 
 * **Example Interaction Flow (User Input in Bold):**
 * 
 * ```
 * Warehouse Order Management System
 * Menu:
 * 1. Add New Order
 * 2. Process Next Order
 * 3. View Pending Orders
 * 4. View Completed Orders
 * 5. Exit
 * Enter your choice: **1**
 * Enter Order ID (integer): **101**
 * Enter Order Description: **Laptop shipment**
 * Order 101 added to the queue.
 * 
 * Menu:
 * ...
 * Enter your choice: **1**
 * Enter Order ID (integer): **102**
 * Enter Order Description: **Monitor delivery**
 * Order 102 added to the queue.
 * 
 * Menu:
 * ...
 * Enter your choice: **3**
 * --- Pending Orders ---
 * Order ID: 101, Description: Laptop shipment
 * Order ID: 102, Description: Monitor delivery
 * ----------------------
 * 
 * Menu:
 * ...
 * Enter your choice: **2**
 * Successfully processed order: 101
 * 
 * Menu:
 * ...
 * Enter your choice: **3**
 * --- Pending Orders ---
 * Order ID: 102, Description: Monitor delivery
 * ----------------------
 * 
 * Menu:
 * ...
 * Enter your choice: **4**
 * --- Completed Orders ---
 * Order ID: 101, Description: Laptop shipment
 * ----------------------
 * 
 * Menu:
 * ...
 * Enter your choice: **2**
 * Successfully processed order: 102
 * 
 * Menu:
 * ...
 * Enter your choice: **2**
 * Error: No pending orders to process.
 * 
 * Menu:
 * ...
 * Enter your choice: **4**
 * --- Completed Orders ---
 * Order ID: 101, Description: Laptop shipment
 * Order ID: 102, Description: Monitor delivery
 * ----------------------
 * 
 * Menu:
 * ...
 * Enter your choice: **6**
 * Error: Invalid menu choice. Please enter a number between 1 and 5.
 * 
 * Menu:
 * ...
 * Enter your choice: **exit**
 * Error: Invalid input. Please enter a number.
 * 
 * Menu:
 * ...
 * Enter your choice: **5**
 * Exiting Warehouse System. Goodbye!
 * ```
 * 
 * Your solution must be a complete, runnable Java program demonstrating the effective use of all specified components and adhering to best practices.
 * 
 * **Expected Output:**
 * 
 * The output should match the example interaction flow, displaying the menu, order details, and error messages correctly on `System.out` or `System.err` as required.
 *
 * EXPLANATION:
 * This solution implements the Warehouse Order Management System following the requirements.
 * 
 * 1.  **`Order` Class:** A simple POJO (Plain Old Java Object) representing an order with an ID and description, adhering to encapsulation with private fields and public getters. The `toString()` method provides a convenient way to print order details.
 * 
 * 2.  **`Warehouse` Class:**
 *     *   It uses a `Queue<Order>` named `pendingOrders` (implemented with `LinkedList`) to store orders in a First-In, First-Out (FIFO) manner, simulating an order queue.
 *     *   It uses a `List<Order>` named `completedOrders` (implemented with `ArrayList`) to store processed orders. This demonstrates declaring a variable using the `List` interface while instantiating it with a concrete `ArrayList`.
 *     *   `addOrder()`: Simple method to add an order to the `pendingOrders` queue using `queue.add()`.
 *     *   `processNextOrder()`: Checks if the `pendingOrders` queue is empty. If not, it uses `queue.poll()` to remove and retrieve the head of the queue and `list.add()` to add it to the `completedOrders` list. If the queue is empty, it prints an error to `System.err`.
 *     *   `getPendingOrders()`: This method demonstrates converting the elements from the `pendingOrders` queue into a new `ArrayList` and returning it as a `List`. This fulfills the requirement of using `ArrayList` and returning a `List` representation of the queue's contents without exposing the internal queue directly.
 *     *   `getCompletedOrders()`: This method simply returns the internal `completedOrders` list (which is an `ArrayList`), satisfying the requirement to return a `List` and use `ArrayList` for storage.
 * 
 * 3.  **`WarehouseApp` Class:**
 *     *   The `main` method drives the application.
 *     *   A `Scanner` is used to read user input from the console. `scanner.nextLine()` followed by `Integer.parseInt()` is used for reading integers to avoid common issues with `scanner.nextInt()` leaving newline characters.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   The menu is displayed, and user input is read.
 *     *   A `try-catch (NumberFormatException)` block specifically handles cases where the user enters non-integer input for the menu choice, printing an error to `System.err` and continuing the loop.
 *     *   A `switch` statement directs the program flow based on the user's valid integer choice.
 *     *   Each case in the `switch` performs the corresponding action by calling methods on the `Warehouse` object.
 *     *   Cases 1 (Add Order) includes a nested `try-catch` to handle potential `NumberFormatException` if the user enters non-integer input for the Order ID.
 *     *   Cases 3 and 4 retrieve the lists of orders from the `Warehouse` and iterate through them, printing details using `System.out.println()`. They also handle the case where the lists are empty.
 *     *   Case 5 sets the `running` flag to `false` to exit the loop.
 *     *   The `default` case of the `switch` handles invalid integer choices, printing an error to `System.err`.
 *     *   A general `catch (Exception e)` block is included around the main processing logic within the loop to catch any other unexpected runtime exceptions that might occur, printing an error message to `System.err`.
 *     *   The `Scanner` is closed outside the loop to release system resources.
 *     *   A separate `printMenu()` helper method improves code organization.
 * 
 * **Demonstration of Required Components:**
 * 
 * *   `Queue`: Used for `pendingOrders` (`LinkedList` implementation).
 * *   `ArrayList`: Used for `completedOrders` initialization and within `getPendingOrders()` to create a `List` from the queue contents.
 * *   `List`: Used as the type for the `completedOrders` field and as the return type for `getPendingOrders()` and `getCompletedOrders()`.
 * *   `Scanner`: Used in `main` to read user input.
 * *   `switch`: Used in `main` to process menu choices.
 * *   `System.err`: Used for error messages (invalid input, empty queue processing).
 * *   `System.out`: Used for normal output (menu, confirmations, listing orders).
 * *   `try-catch`: Used in `main` to handle `NumberFormatException` for input and a general `Exception` catch for robustness.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** `Order` and `Warehouse` fields are private with public accessors/mutators where needed.
 * *   **Naming:** Variables and methods have descriptive names (`pendingOrders`, `processNextOrder`, `addOrder`, etc.).
 * *   **Comments:** Javadoc-style comments explain the purpose of classes and methods, and inline comments explain specific code logic.
 * *   **Input Validation:** Input for menu choice and Order ID is validated using `try-catch`.
 * *   **Error Handling:** Specific errors (`NumberFormatException`, empty queue) are handled and reported to `System.err`. A general catch provides a fallback.
 * *   **Clean Code Structure:** The code is divided into logical classes (`Order`, `Warehouse`, `WarehouseApp`), and the `main` method is structured clearly with a loop and switch.
 * 
 * This solution effectively combines the required Java components in a practical scenario, demonstrating understanding of collection interfaces, concrete implementations, basic input/output, control flow, and exception handling, suitable for an advanced introductory or intermediate Java exam.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Represents a single order in the warehouse system
class Order {
    private int orderId;
    private String description;

    /**
     * Constructs a new Order.
     * @param orderId The unique identifier for the order.
     * @param description A brief description of the order contents.
     */
    public Order(int orderId, String description) {
        this.orderId = orderId;
        this.description = description;
    }

    // Getter for orderId
    public int getOrderId() {
        return orderId;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    /**
     * Provides a string representation of the Order.
     * @return A formatted string including Order ID and description.
     */
    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Description: " + description;
    }
}

// Manages the queue of pending orders and the list of completed orders
class Warehouse {
    // Queue to hold orders awaiting processing
    private Queue<Order> pendingOrders;
    // List to hold orders that have been processed
    private List<Order> completedOrders; // Declared as List

    /**
     * Constructs a new Warehouse instance, initializing order collections.
     */
    public Warehouse() {
        // Use LinkedList as a concrete implementation for Queue
        pendingOrders = new LinkedList<>();
        // Use ArrayList as a concrete implementation for List
        completedOrders = new ArrayList<>(); // Initialized with ArrayList
    }

    /**
     * Adds a new order to the pending orders queue.
     * @param order The order to add.
     */
    public void addOrder(Order order) {
        pendingOrders.add(order);
        System.out.println("Order " + order.getOrderId() + " added to the queue.");
    }

    /**
     * Processes the next order from the pending queue.
     * Removes it from the queue and adds it to the completed list.
     * Prints an error if the queue is empty.
     */
    public void processNextOrder() {
        if (pendingOrders.isEmpty()) {
            System.err.println("Error: No pending orders to process.");
        } else {
            Order processedOrder = pendingOrders.poll(); // Remove from queue
            completedOrders.add(processedOrder); // Add to completed list
            System.out.println("Successfully processed order: " + processedOrder.getOrderId());
        }
    }

    /**
     * Retrieves a list of all pending orders currently in the queue.
     * @return A List containing the pending orders. Returns an empty list if no orders are pending.
     */
    public List<Order> getPendingOrders() {
        // Convert the queue contents to an ArrayList for easy viewing
        return new ArrayList<>(pendingOrders); // Uses ArrayList to create the list
    }

    /**
     * Retrieves the list of all completed orders.
     * @return The List containing the completed orders. Returns an empty list if no orders are completed.
     */
    public List<Order> getCompletedOrders() {
        return completedOrders; // Returns the List (which is an ArrayList)
    }
}

// Main application class for the Warehouse Order Management System
public class WarehouseApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Warehouse warehouse = new Warehouse();
        boolean running = true;

        System.out.println("Warehouse Order Management System");

        // Main application loop
        while (running) {
            printMenu();
            int choice = -1; // Default to an invalid choice

            // Try-catch block for reading integer input for menu choice
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine()); // Read line and parse to avoid issues with nextInt() and newline
            } catch (NumberFormatException e) {
                // Handle non-integer input for menu choice
                System.err.println("Error: Invalid input. Please enter a number.");
                continue; // Skip to the next iteration of the loop
            } catch (Exception e) {
                 // General catch for any other unexpected input issues
                 System.err.println("An unexpected input error occurred: " + e.getMessage());
                 continue;
            }

            // Switch statement to handle the chosen menu option
            switch (choice) {
                case 1: // Add New Order
                    try {
                        System.out.print("Enter Order ID (integer): ");
                        int orderId = Integer.parseInt(scanner.nextLine()); // Read and parse ID

                        System.out.print("Enter Order Description: ");
                        String description = scanner.nextLine(); // Read description

                        Order newOrder = new Order(orderId, description);
                        warehouse.addOrder(newOrder); // Add order via Warehouse method
                    } catch (NumberFormatException e) {
                        // Handle non-integer input for Order ID
                        System.err.println("Error: Invalid Order ID format. Please enter an integer.");
                    } catch (Exception e) {
                         // General catch for any other unexpected errors during order creation
                         System.err.println("An unexpected error occurred while adding order: " + e.getMessage());
                    }
                    break;

                case 2: // Process Next Order
                    warehouse.processNextOrder(); // Process order via Warehouse method
                    break;

                case 3: // View Pending Orders
                    List<Order> pending = warehouse.getPendingOrders(); // Get pending orders as a List
                    if (pending.isEmpty()) {
                        System.out.println("--- No Pending Orders ---");
                    } else {
                        System.out.println("--- Pending Orders ---");
                        // Iterate and print using System.out
                        for (Order order : pending) {
                            System.out.println(order);
                        }
                        System.out.println("----------------------");
                    }
                    break;

                case 4: // View Completed Orders
                    List<Order> completed = warehouse.getCompletedOrders(); // Get completed orders as a List
                    if (completed.isEmpty()) {
                         System.out.println("--- No Completed Orders ---");
                    } else {
                        System.out.println("--- Completed Orders ---");
                        // Iterate and print using System.out
                        for (Order order : completed) {
                            System.out.println(order);
                        }
                        System.out.println("----------------------");
                    }
                    break;

                case 5: // Exit
                    running = false; // Set loop condition to false to exit
                    System.out.println("Exiting Warehouse System. Goodbye!");
                    break;

                default: // Invalid choice
                    System.err.println("Error: Invalid menu choice. Please enter a number between 1 and 5.");
                    break;
            }
            System.out.println(); // Print a newline for better readability between interactions
        }

        scanner.close(); // Close the scanner resource
    }

    // Helper method to print the menu options
    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add New Order");
        System.out.println("2. Process Next Order");
        System.out.println("3. View Pending Orders");
        System.out.println("4. View Completed Orders");
        System.out.println("5. Exit");
    }
}
