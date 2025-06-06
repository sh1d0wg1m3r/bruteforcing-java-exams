/*
 * Exam Question #653
 * Generated on: 2025-05-12 16:20:29
 * Generated by: Account 1
 * 
 * QUESTION:
 * **Advanced Java Programming Exam Task: Warehouse Order Processing System**
 * 
 * You are tasked with developing a simple simulated Warehouse Order Processing System in Java. This system will manage incoming customer orders, process them in a first-in, first-out manner, and keep track of completed orders. Your solution must demonstrate a strong understanding of fundamental Java data structures, control flow, input/output, exception handling, and object-oriented principles.
 * 
 * **System Requirements:**
 * 
 * 1.  **Order Representation:** Create a class named `Order` to represent a customer order.
 *     *   It should have private fields for `orderId` (an integer), `customerName` (String), and `items` (a `List` of Strings representing item names).
 *     *   Provide a constructor to initialize these fields.
 *     *   Include public getter methods for all fields (`getOrderId()`, `getCustomerName()`, `getItems()`).
 *     *   Override the `toString()` method to provide a clear string representation of the order.
 * 
 * 2.  **Warehouse System:** Create a class named `WarehouseSystem` to manage the orders.
 *     *   It must contain a `Queue<Order>` to hold orders waiting to be processed.
 *     *   It must contain a `List<Order>` (specifically using `ArrayList`) to hold orders that have been processed.
 *     *   It should have a private field `nextOrderId` (an integer, starting from 1) to generate unique order IDs.
 *     *   Implement the following public methods:
 *         *   `addOrder(Scanner scanner)`:
 *             *   Prompts the user to enter the customer name and a comma-separated list of item names.
 *             *   Uses the provided `Scanner` object for input.
 *             *   Performs basic input validation: customer name cannot be empty, and at least one item must be entered. If validation fails, print an error message using `System.err` and do *not* add the order.
 *             *   If input is valid, create a new `Order` object with a unique `orderId` (incrementing `nextOrderId`), the customer name, and the list of items.
 *             *   Add the new `Order` to the pending orders `Queue`.
 *             *   Print a confirmation message to `System.out`.
 *             *   Handle potential exceptions during input reading or parsing (e.g., if input format is unexpected, although Scanner is generally robust for strings).
 *         *   `processNextOrder()`:
 *             *   Attempt to retrieve and remove the next order from the pending orders `Queue`.
 *             *   If the queue is empty, print an informative message to `System.out` and do nothing further.
 *             *   If an order is retrieved, simulate processing (e.g., print a message indicating processing) and add the order to the processed orders `List`.
 *             *   Print a confirmation message to `System.out` including the processed order's details.
 *         *   `viewProcessedOrders()`:
 *             *   Iterate through the processed orders `List`.
 *             *   If the list is empty, print an informative message to `System.out`.
 *             *   If the list is not empty, print a header and then details of each processed order using its `toString()` method to `System.out`.
 *         *   `run()`:
 *             *   This method will contain the main application loop.
 *             *   Use a `Scanner` object to read user commands from `System.in`.
 *             *   Present a menu to the user with options:
 *                 1. Add New Order
 *                 2. Process Next Order
 *                 3. View Processed Orders
 *                 4. Exit
 *             *   Read the user's choice.
 *             *   Use a `switch` statement to handle the user's choice, calling the appropriate method (`addOrder`, `processNextOrder`, `viewProcessedOrders`).
 *             *   If the user enters an invalid menu option, print an error message using `System.err`.
 *             *   The loop should continue until the user chooses the Exit option.
 *             *   Implement class-wide exception handling using a `try-catch` block that wraps the main loop within the `run()` method. Catch a general `Exception` and print an error message using `System.err` if an unexpected error occurs during the system's operation.
 *             *   Ensure the `Scanner` is closed when the application exits.
 * 
 * **Required Components Checklist:**
 * 
 * *   [ ] `java.util.Queue`
 * *   [ ] `java.util.ArrayList`
 * *   [ ] `java.util.List` interface
 * *   [ ] `java.util.Scanner`
 * *   [ ] `switch` statement
 * *   [ ] `System.err`
 * *   [ ] `System.out`
 * *   [ ] Class-wide `try-catch` block
 * 
 * **Best Practices:**
 * 
 * *   Proper encapsulation (private fields, public getters/methods).
 * *   Meaningful variable and method names.
 * *   Appropriate comments and documentation (Javadocs are a plus but not strictly required for this exam, inline comments explaining complex logic are sufficient).
 * *   Input validation.
 * *   Proper error handling (`System.err`, try-catch).
 * *   Clean code structure (separate classes, clear method responsibilities).
 * 
 * **Expected Output:**
 * 
 * The system should interact with the user via the console.
 * *   Menu prompts and normal operation messages should go to `System.out`.
 * *   Input validation errors and unexpected runtime errors caught by the main `try-catch` should go to `System.err`.
 * *   Processed order details should be clearly formatted.
 * 
 * Your solution should consist of the `Order` class and the `WarehouseSystem` class. Include a `main` method in `WarehouseSystem` to create an instance and call its `run()` method.
 * 
 * ```java
 * // Place your Order class code here
 * 
 * // Place your WarehouseSystem class code here
 * ```
 * 
 * **Evaluation:**
 * 
 * Your solution will be evaluated on:
 * *   Correct usage of all required components.
 * *   Correct implementation of the system logic (adding, processing, viewing orders).
 * *   Robust input validation and error handling.
 * *   Adherence to best practices (encapsulation, naming, comments).
 * *   Code clarity and structure.
 * 
 * Good luck!
 *
 * EXPLANATION:
 * This solution implements a simple Warehouse Order Processing System demonstrating the required Java concepts.
 * 
 * 1.  **`Order` Class:**
 *     *   Represents a single order with encapsulation (private fields `orderId`, `customerName`, `items`).
 *     *   Uses a `List<String>` for items, specifically creating a defensive copy in the constructor and getter to prevent external modification of the internal list state.
 *     *   Provides a clear `toString()` method for easy printing.
 * 
 * 2.  **`WarehouseSystem` Class:**
 *     *   **Data Structures:**
 *         *   Uses a `Queue<Order>` (`pendingOrders`) implemented by `LinkedList` to store orders waiting for processing. `Queue` is appropriate here because orders are processed in the order they are received (FIFO - First-In, First-Out). `offer()` is used for adding and `poll()` for removing, which are standard `Queue` operations that handle capacity constraints gracefully (though not critical in this simple unbounded example).
 *         *   Uses a `List<Order>` (`processedOrders`) implemented by `ArrayList` to store orders once they have been processed. `ArrayList` is suitable for storing and iterating over a collection of processed items where order matters (chronological processing order) and random access might be useful (though not used extensively here). The `List` interface provides the contract, and `ArrayList` is the concrete implementation.
 *     *   **State:** `nextOrderId` is a private field to ensure each new order gets a unique, incrementing ID.
 *     *   **`addOrder(Scanner scanner)`:**
 *         *   Takes `Scanner` as an argument, demonstrating how to pass and use an external resource.
 *         *   Reads customer name and item list.
 *         *   Performs input validation for empty name and empty item list using `if` conditions.
 *         *   Uses `System.err.println()` to output validation error messages, clearly separating them from normal output.
 *         *   Parses the comma-separated item string into a `List<String>` using `split()` and `Arrays.asList()`, followed by trimming whitespace and removing empty entries.
 *         *   Creates a new `Order` object.
 *         *   Adds the order to the `pendingOrders` queue using `offer()`.
 *         *   Prints success messages to `System.out.println()`.
 *     *   **`processNextOrder()`:**
 *         *   Uses `pendingOrders.poll()` to get and remove the head of the queue.
 *         *   Checks if the result is `null` (indicating an empty queue) and prints an appropriate message to `System.out`.
 *         *   If an order is retrieved, it simulates processing and adds the order to the `processedOrders` `List` using `add()`.
 *         *   Prints confirmation messages to `System.out`.
 *     *   **`viewProcessedOrders()`:**
 *         *   Checks if the `processedOrders` `List` is empty and prints a message if it is.
 *         *   If not empty, it iterates through the `List` (using a standard `for` loop with index, but enhanced for loop is also possible) and prints each `Order`'s `toString()` representation to `System.out`.
 *     *   **`run()`:**
 *         *   This is the main control method.
 *         *   Initializes a `Scanner` for user input.
 *         *   **Class-Wide Exception Handling:** A `try-catch(Exception e)` block wraps the entire `while` loop. This demonstrates catching unexpected runtime errors that might occur anywhere within the main interaction flow (e.g., issues with I/O, unexpected null pointers *not* handled by specific checks). Error details, including the stack trace, are printed to `System.err` using `e.printStackTrace(System.err)`.
 *         *   **Control Flow:** A `while` loop continues until the user chooses to exit.
 *         *   **`switch` Statement:** Used to process the user's integer choice from the menu, directing execution to the appropriate method (`addOrder`, `processNextOrder`, `viewProcessedOrders`, or exit). Includes a `default` case for invalid numeric input.
 *         *   **Input Handling:** Reads the integer choice using `scanner.nextInt()` and correctly consumes the remaining newline character using `scanner.nextLine()` to prevent issues in subsequent `nextLine()` calls in `addOrder`. Includes basic validation to ensure the input is an integer before attempting to read it.
 *         *   **Resource Management:** The `finally` block ensures the `Scanner` resource is closed when the `try` block finishes (either normally or due to an exception), preventing resource leaks.
 *     *   **`main` Method:** The entry point of the application, creating a `WarehouseSystem` instance and calling its `run()` method.
 * 
 * This solution effectively integrates all required components into a practical scenario, demonstrates object-oriented principles, handles user input, manages state using appropriate data structures, and includes basic error handling and input validation as specified.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays; // To easily convert comma-separated string to List

// Represents a customer order
class Order {
    private final int orderId;
    private final String customerName;
    private final List<String> items;

    /**
     * Constructs a new Order.
     * @param orderId The unique identifier for the order.
     * @param customerName The name of the customer.
     * @param items A list of item names included in the order.
     */
    public Order(int orderId, String customerName, List<String> items) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.items = new ArrayList<>(items); // Create a defensive copy
    }

    // --- Getters ---
    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<String> getItems() {
        return new ArrayList<>(items); // Return a defensive copy
    }

    @Override
    public String toString() {
        return "Order [ID=" + orderId +
               ", Customer='" + customerName + '\'' +
               ", Items=" + items +
               ']';
    }
}

// Manages the warehouse order processing
public class WarehouseSystem {

    private final Queue<Order> pendingOrders;
    private final List<Order> processedOrders;
    private int nextOrderId;

    /**
     * Constructs a new WarehouseSystem.
     */
    public WarehouseSystem() {
        this.pendingOrders = new LinkedList<>(); // LinkedList is a common Queue implementation
        this.processedOrders = new ArrayList<>(); // ArrayList for processed orders list
        this.nextOrderId = 1;
    }

    /**
     * Adds a new order based on user input.
     * @param scanner The Scanner object to read user input.
     */
    public void addOrder(Scanner scanner) {
        System.out.println("\n--- Add New Order ---");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine().trim();

        if (customerName.isEmpty()) {
            System.err.println("Error: Customer name cannot be empty.");
            return; // Exit method if validation fails
        }

        System.out.print("Enter items (comma-separated): ");
        String itemsInput = scanner.nextLine().trim();

        if (itemsInput.isEmpty()) {
            System.err.println("Error: Item list cannot be empty.");
            return; // Exit method if validation fails
        }

        // Split items input by comma and trim whitespace from each item
        List<String> items = new ArrayList<>(Arrays.asList(itemsInput.split(",")));
        items.removeIf(String::trim); // Remove any empty strings resulting from split (e.g., trailing comma)
        items.replaceAll(String::trim); // Trim whitespace from valid item names

        if (items.isEmpty()) {
             System.err.println("Error: No valid items entered after parsing.");
             return; // Exit method if validation fails
        }


        // Create the new order
        Order newOrder = new Order(nextOrderId++, customerName, items);

        // Add to the pending orders queue
        pendingOrders.offer(newOrder); // offer is generally preferred over add for queues

        System.out.println("Order added successfully: " + newOrder.toString());
    }

    /**
     * Processes the next order from the pending queue.
     */
    public void processNextOrder() {
        System.out.println("\n--- Processing Next Order ---");
        Order orderToProcess = pendingOrders.poll(); // poll retrieves and removes the head

        if (orderToProcess == null) {
            System.out.println("No pending orders to process.");
        } else {
            // Simulate processing
            System.out.println("Processing order: " + orderToProcess.getOrderId() + " for " + orderToProcess.getCustomerName());

            // Add to the processed orders list
            processedOrders.add(orderToProcess);

            System.out.println("Order processed and moved to completed list: " + orderToProcess.toString());
        }
    }

    /**
     * Displays all processed orders.
     */
    public void viewProcessedOrders() {
        System.out.println("\n--- Processed Orders ---");
        if (processedOrders.isEmpty()) {
            System.out.println("No orders have been processed yet.");
        } else {
            System.out.println("Total processed orders: " + processedOrders.size());
            for (int i = 0; i < processedOrders.size(); i++) {
                 Order order = processedOrders.get(i);
                 // Using List index here is fine for display, but iteration is also common
                 System.out.println((i + 1) + ". " + order.toString());
            }
        }
    }

    /**
     * Runs the main application loop.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);

        // Class-wide exception handling using try-catch around the main loop
        try {
            int choice = -1;
            while (choice != 4) {
                printMenu();
                System.out.print("Enter your choice: ");

                // Input validation for choice
                if (!scanner.hasNextInt()) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Go back to the start of the loop
                }

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Using switch statement for menu control
                switch (choice) {
                    case 1:
                        addOrder(scanner);
                        break;
                    case 2:
                        processNextOrder();
                        break;
                    case 3:
                        viewProcessedOrders();
                        break;
                    case 4:
                        System.out.println("Exiting Warehouse Order Processing System. Goodbye!");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions during the system's operation
            System.err.println("\nAn unexpected error occurred during system operation:");
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure scanner is closed regardless of how the try block exits
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    /**
     * Prints the main menu options.
     */
    private void printMenu() {
        System.out.println("\n--- Warehouse System Menu ---");
        System.out.println("1. Add New Order");
        System.out.println("2. Process Next Order");
        System.out.println("3. View Processed Orders");
        System.out.println("4. Exit");
        System.out.println("-----------------------------");
    }

    // Main method to start the application
    public static void main(String[] args) {
        WarehouseSystem system = new WarehouseSystem();
        system.run();
    }
}
