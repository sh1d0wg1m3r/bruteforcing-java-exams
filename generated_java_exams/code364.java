/*
 * Exam Question #364
 * Generated on: 2025-05-11 23:00:47
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Restaurant Order Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified command-line application for managing orders in a small restaurant. The system should allow staff to view the menu, place new orders, process the next pending order, and view lists of pending and completed orders.
 * 
 * Your solution must demonstrate a strong understanding of fundamental Java data structures, control flow, input/output, exception handling, and object-oriented principles.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to manage pending orders in a First-In, First-Out (FIFO) manner.
 *     *   Use a `java.util.ArrayList` to store the restaurant's menu items.
 *     *   Use the `java.util.List` interface type where appropriate (e.g., for method parameters or variables holding collections that could potentially be other List implementations).
 * 
 * 2.  **Input/Output:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Use `System.out` for displaying the menu, order details, status messages, and the main application menu.
 *     *   Use `System.err` to display error messages (e.g., invalid input, attempting to process an empty queue).
 * 
 * 3.  **Control Flow:**
 *     *   Use a `switch` statement to handle the different menu options selected by the user.
 *     *   Use a loop to keep the application running until the user chooses to exit.
 * 
 * 4.  **Object-Oriented Design:**
 *     *   Create appropriate classes to represent `MenuItem` (with name and price) and `Order` (with a unique ID, a list of ordered `MenuItem`s, and a status like "Pending" or "Completed").
 *     *   Create a main class (e.g., `RestaurantSystem`) that manages the `Queue`, `ArrayList`, and application logic.
 *     *   Apply proper encapsulation: make data fields private and provide public methods for interaction.
 * 
 * 5.  **Error Handling:**
 *     *   Implement robust input validation for user choices and order details (e.g., checking for non-numeric input when expecting numbers, ensuring menu item indices are valid).
 *     *   Use `try-catch` blocks for exception handling, particularly around input operations that might fail (like parsing integers) or operations on collections that might throw exceptions (like accessing invalid indices). Ensure a class-wide approach to error handling, meaning the main operational methods within your `RestaurantSystem` class should handle exceptions gracefully.
 * 
 * 6.  **Best Practices:**
 *     *   Use meaningful names for classes, variables, and methods.
 *     *   Include comments to explain complex logic or the purpose of classes/methods.
 *     *   Ensure the `Scanner` resource is properly closed.
 * 
 * **Application Functionality:**
 * 
 * The application should present a menu with options:
 * 
 * 1.  Display Menu
 * 2.  Place New Order
 * 3.  Process Next Order
 * 4.  View Pending Orders
 * 5.  View Completed Orders
 * 6.  Exit
 * 
 * *   **Display Menu:** Show the list of menu items with their index/number, name, and price.
 * *   **Place New Order:**
 *     *   Display the menu to the user.
 *     *   Prompt the user to enter the item number and quantity for each item they want to add to the order. Allow multiple items per order.
 *     *   Input should continue until the user enters a specific value (e.g., 0) to finish the order.
 *     *   Create an `Order` object with the selected items and add it to the pending orders `Queue`.
 *     *   Handle cases where the user enters invalid item numbers or non-numeric input.
 * *   **Process Next Order:**
 *     *   Check if the pending orders `Queue` is empty.
 *     *   If not empty, remove the next order from the `Queue`, mark it as "Completed", and move it to a list of completed orders.
 *     *   If the queue is empty, display an appropriate message using `System.err`.
 * *   **View Pending Orders:** Display details of all orders currently in the pending `Queue`.
 * *   **View Completed Orders:** Display details of all orders that have been processed.
 * *   **Exit:** Terminate the application.
 * 
 * **Expected Output:**
 * 
 * *   Clear menu prompts and messages using `System.out`.
 * *   Formatted display of the menu, pending orders, and completed orders using `System.out`.
 * *   Error messages for invalid operations or input using `System.err`.
 * 
 * Your solution should be a single Java file containing all necessary classes.
 *
 * EXPLANATION:
 * This solution implements a simple Restaurant Order Management System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `MenuItem`: A simple class to hold the `name` and `price` of a menu item. Uses private fields and public getter methods for encapsulation.
 *     *   `Order`: Represents a customer order. It has an auto-generated `orderId`, a `List<MenuItem>` to store the items ordered (using the `List` interface type), and a `status`. It includes a `getTotal()` method and an informative `toString()`. Uses private fields and public methods/getters/setters.
 *     *   `RestaurantSystem`: The main class that orchestrates the application. It holds the core data structures (`menuItems`, `pendingOrders`, `completedOrders`) and contains the methods for the application's operations.
 * 
 * 2.  **Data Structures:**
 *     *   `menuItems`: An `ArrayList<MenuItem>` is used. `ArrayList` is suitable here because we need to store a dynamic list of menu items and access them by index when a user places an order. The variable is declared using the `List` interface type (`List<MenuItem> menuItems`), demonstrating the principle of programming to interfaces.
 *     *   `pendingOrders`: A `Queue<Order>` implemented by `LinkedList<Order>` is used. `LinkedList` is a good choice for implementing a `Queue` as adding to the end (`offer`) and removing from the beginning (`poll`) are efficient operations (O(1)). The `Queue` interface ensures FIFO behavior for processing orders. The variable is declared using the `Queue` interface type (`Queue<Order> pendingOrders`).
 *     *   `completedOrders`: An `ArrayList<Order>` is used to store orders once they are processed. `ArrayList` is suitable here as we primarily add to the end and iterate through the list to view completed orders. The variable is declared using the `List` interface type (`List<Order> completedOrders`).
 * 
 * 3.  **Input/Output:**
 *     *   A `Scanner` object (`scanner`) is used to read input from `System.in`. The `run()` method uses a try-with-resources block (`try (Scanner mainScanner = new Scanner(System.in))`) to ensure the scanner is automatically closed when the application exits or an exception occurs in the `run` method.
 *     *   `System.out.println()` and `System.out.print()` are used for displaying the main menu, sub-menus, order details, success messages, and general information.
 *     *   `System.err.println()` is specifically used for displaying error messages, such as invalid menu choices, invalid input format during order placement, or attempting to process an order when the queue is empty. This helps distinguish errors from normal application output.
 * 
 * 4.  **Control Flow:**
 *     *   The `run()` method contains a `while (choice != 6)` loop that keeps the application running until the user selects the "Exit" option (choice 6).
 *     *   Inside the loop, after displaying the menu and reading the user's choice, a `switch (choice)` statement is used to direct the program flow to the appropriate method (`displayMenu`, `placeOrder`, `processNextOrder`, etc.) based on the user's input.
 * 
 * 5.  **Error Handling:**
 *     *   **Input Validation:** Before attempting to use user input, checks are performed. For menu choices, the `switch` statement handles valid options, and a `default` case catches invalid numbers. For order placement, the code checks if the entered item number is within the valid range of the menu indices (`itemChoice < 1 || itemChoice > menuItems.size()`).
 *     *   **`InputMismatchException`:** A `try-catch` block is used around the `scanner.nextInt()` calls (specifically, the `hasNextInt()` check followed by `nextInt()` combined with consuming the rest of the line and catching `InputMismatchException` as a safeguard) to handle cases where the user enters non-integer input when a number is expected. An error message is printed to `System.err`, and the invalid input is consumed (`scanner.next()` or `scanner.nextLine()`) to prevent an infinite loop.
 *     *   **`IndexOutOfBoundsException`:** Although explicit index validation is done, a `try-catch` for `IndexOutOfBoundsException` is included in `placeOrder` as a defensive measure if there were a logic error in index calculation.
 *     *   **Queue Operations:** The `processNextOrder()` method uses `pendingOrders.poll()`. `poll()` is preferred over `remove()` because it returns `null` if the queue is empty, allowing for a graceful check (`if (nextOrder == null)`) and an error message via `System.err`, rather than throwing a `NoSuchElementException`.
 *     *   **Class-wide Exception Handling:** `try-catch` blocks are placed within the methods (`placeOrder`, `run`) where specific exceptions are likely to occur (input parsing, list access, general unexpected errors in the main loop). This localizes the error handling to the relevant operation. A general `catch (Exception e)` is included in `run` and `placeOrder` to catch any other unexpected runtime exceptions, printing an error and a stack trace for debugging.
 * 
 * 6.  **Best Practices:**
 *     *   **Encapsulation:** Class fields (`name`, `price`, `orderId`, `items`, `status`, `menuItems`, `pendingOrders`, `completedOrders`, `scanner`) are `private`, and access is provided via public methods (`get...`, `set...`, `run`, `placeOrder`, etc.).
 *     *   **Meaningful Names:** Variables like `menuItems`, `pendingOrders`, `itemChoice`, `currentOrderItems` are descriptive. Methods like `displayMenu`, `placeOrder`, `processNextOrder` clearly indicate their purpose.
 *     *   **Comments:** Javadoc-style comments explain the purpose of classes and methods. Inline comments clarify specific logic points.
 *     *   **Clean Code:** The code is organized into logical methods, separating concerns (displaying, placing, processing, viewing). Indentation and formatting follow standard Java conventions.
 * 
 * This solution effectively integrates all required components into a functional, albeit simple, application demonstrating key Java programming concepts suitable for an advanced exam task.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single menu item.
 */
class MenuItem {
    private String name;
    private double price;

    /**
     * Constructs a MenuItem.
     * @param name The name of the menu item.
     * @param price The price of the menu item.
     */
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (%.2f)", name, price);
    }
}

/**
 * Represents a customer order.
 */
class Order {
    private static int nextOrderId = 1; // To generate unique order IDs
    private int orderId;
    private List<MenuItem> items; // Using List interface
    private String status; // e.g., "Pending", "Completed"

    /**
     * Constructs an Order with a list of items.
     * @param items The list of menu items in the order.
     */
    public Order(List<MenuItem> items) {
        this.orderId = nextOrderId++;
        this.items = new ArrayList<>(items); // Use ArrayList internally, but List interface type
        this.status = "Pending";
    }

    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return items; // Return List interface type
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderId).append(" [").append(status).append("] - Total: ").append(String.format("%.2f", getTotal())).append("\n");
        sb.append("  Items:\n");
        for (MenuItem item : items) {
            sb.append("    - ").append(item.getName()).append(" (").append(String.format("%.2f", item.getPrice())).append(")\n");
        }
        return sb.toString();
    }
}

/**
 * Manages the restaurant's menu, pending orders queue, and completed orders list.
 */
public class RestaurantSystem {

    private List<MenuItem> menuItems; // Using List interface type, implemented by ArrayList
    private Queue<Order> pendingOrders; // Using Queue interface type, implemented by LinkedList
    private List<Order> completedOrders; // Using List interface type, implemented by ArrayList
    private Scanner scanner; // Scanner for user input

    /**
     * Constructs the RestaurantSystem and initializes data structures.
     */
    public RestaurantSystem() {
        // Use ArrayList for menu as we access by index and iterate
        menuItems = new ArrayList<>();
        // Use LinkedList for Queue as it's efficient for add/remove from ends
        pendingOrders = new LinkedList<>();
        // Use ArrayList for completed orders as we iterate and maybe access by index later
        completedOrders = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Initialize the menu
        initializeMenu();
    }

    /**
     * Populates the initial menu items.
     */
    private void initializeMenu() {
        menuItems.add(new MenuItem("Burger", 8.99));
        menuItems.add(new MenuItem("Pizza", 12.50));
        menuItems.add(new MenuItem("Salad", 7.25));
        menuItems.add(new MenuItem("Fries", 3.50));
        menuItems.add(new MenuItem("Soda", 1.99));
    }

    /**
     * Displays the main application menu to the user.
     */
    private void displayMainMenu() {
        System.out.println("\n--- Restaurant Order System ---");
        System.out.println("1. Display Menu");
        System.out.println("2. Place New Order");
        System.out.println("3. Process Next Order");
        System.out.println("4. View Pending Orders");
        System.out.println("5. View Completed Orders");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Displays the restaurant menu with indices.
     */
    private void displayMenu() {
        System.out.println("\n--- Menu ---");
        if (menuItems.isEmpty()) {
            System.out.println("Menu is currently empty.");
            return;
        }
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
        System.out.println("------------");
    }

    /**
     * Allows the user to place a new order by selecting items from the menu.
     * Includes input validation and exception handling.
     */
    private void placeOrder() {
        System.out.println("\n--- Place New Order ---");
        List<MenuItem> currentOrderItems = new ArrayList<>();
        int itemChoice = -1;

        displayMenu();
        System.out.println("Enter item number to add to order (0 to finish):");

        // Use try-catch for input reading loop
        try {
            while (true) {
                System.out.print("Enter item number (0 to finish): ");
                // Use hasNextInt to check type before reading
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue;
                }
                itemChoice = scanner.nextInt();

                if (itemChoice == 0) {
                    break; // Finish order
                }

                // Validate item choice index
                if (itemChoice < 1 || itemChoice > menuItems.size()) {
                    System.err.println("Invalid item number. Please choose from the menu (1-" + menuItems.size() + ").");
                    continue;
                }

                // Get the selected item
                MenuItem selectedItem = menuItems.get(itemChoice - 1);

                // Add the item to the current order list
                currentOrderItems.add(selectedItem);
                System.out.println(selectedItem.getName() + " added to order.");
            }

            // After loop, check if any items were added
            if (currentOrderItems.isEmpty()) {
                System.out.println("No items added to the order.");
            } else {
                Order newOrder = new Order(currentOrderItems);
                pendingOrders.offer(newOrder); // Add to the end of the queue
                System.out.println("Order #" + newOrder.getOrderId() + " placed successfully.");
                System.out.println(newOrder); // Display the placed order details
            }

        } catch (InputMismatchException e) {
            // This catch is primarily for the initial hasNextInt check failure,
            // though the loop structure handles it by consuming. Good practice
            // to have a general catch if unexpected issues arise within the block.
             System.err.println("An unexpected input error occurred: " + e.getMessage());
             scanner.next(); // Consume potentially problematic input
        } catch (IndexOutOfBoundsException e) {
             // This catch should ideally not be hit due to explicit index validation,
             // but included for robustness.
             System.err.println("Internal error: Invalid menu item index accessed. " + e.getMessage());
        } catch (Exception e) {
             // Catch any other unexpected exceptions
             System.err.println("An unexpected error occurred while placing the order: " + e.getMessage());
             e.printStackTrace(); // Print stack trace for debugging
        }
    }

    /**
     * Processes the next order from the pending queue.
     * Handles empty queue case using System.err.
     */
    private void processNextOrder() {
        System.out.println("\n--- Process Next Order ---");
        // Use poll() which returns null if queue is empty
        Order nextOrder = pendingOrders.poll();

        if (nextOrder == null) {
            System.err.println("No pending orders to process.");
        } else {
            nextOrder.setStatus("Completed");
            completedOrders.add(nextOrder); // Add to the completed list
            System.out.println("Order #" + nextOrder.getOrderId() + " processed.");
            System.out.println(nextOrder); // Display the processed order details
        }
    }

    /**
     * Displays all pending orders from the queue.
     */
    private void viewPendingOrders() {
        System.out.println("\n--- Pending Orders ---");
        if (pendingOrders.isEmpty()) {
            System.out.println("No orders currently pending.");
        } else {
            // Iterate through the queue without removing elements
            for (Order order : pendingOrders) {
                System.out.println(order);
            }
        }
    }

    /**
     * Displays all completed orders from the list.
     */
    private void viewCompletedOrders() {
        System.out.println("\n--- Completed Orders ---");
        if (completedOrders.isEmpty()) {
            System.out.println("No orders have been completed yet.");
        } else {
            // Iterate through the list
            for (Order order : completedOrders) {
                System.out.println(order);
            }
        }
    }

    /**
     * Runs the main application loop.
     * Uses a switch statement for menu navigation.
     * Includes try-catch for the main input loop.
     */
    public void run() {
        int choice = -1;
        // try-with-resources ensures scanner is closed
        try (Scanner mainScanner = new Scanner(System.in)) {
             // Assign the local scanner to the class field
             this.scanner = mainScanner;

            while (choice != 6) {
                displayMainMenu();
                try {
                    // Read the user's choice
                    if (!scanner.hasNextInt()) {
                         System.err.println("Invalid input. Please enter a number between 1 and 6.");
                         scanner.next(); // Consume the invalid input
                         continue; // Skip the rest of the loop and show menu again
                    }
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character after reading the integer

                    // Process the user's choice using a switch statement
                    switch (choice) {
                        case 1:
                            displayMenu();
                            break;
                        case 2:
                            placeOrder();
                            break;
                        case 3:
                            processNextOrder();
                            break;
                        case 4:
                            viewPendingOrders();
                            break;
                        case 5:
                            viewCompletedOrders();
                            break;
                        case 6:
                            System.out.println("Exiting Restaurant Order System. Goodbye!");
                            break;
                        default:
                            System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                            break;
                    }
                } catch (InputMismatchException e) {
                     // This catch block is less likely to be hit now due to hasNextInt check,
                     // but remains as a safeguard.
                     System.err.println("Invalid input. Please enter a number.");
                     scanner.next(); // Consume the invalid input
                } catch (Exception e) {
                     // Catch any other unexpected exceptions during the main loop execution
                     System.err.println("An unexpected error occurred: " + e.getMessage());
                     e.printStackTrace(); // Print stack trace for debugging
                }
            }
        } // Scanner is automatically closed here by try-with-resources
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        RestaurantSystem system = new RestaurantSystem();
        system.run();
    }
}
