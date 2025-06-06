/*
 * Exam Question #213
 * Generated on: 2025-05-11 22:32:53
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Java Programming Exam Task: Cafe Order Management System**
 * 
 * **Scenario:**
 * A small cafe needs a simple console-based system to manage customer orders. The system should allow staff to view the menu, take new orders, process the next order in the queue, and view pending orders.
 * 
 * **Your Task:**
 * Implement a Java program that simulates this cafe order management system. Your solution must adhere to the following requirements:
 * 
 * 1.  **Menu Definition:** Create a predefined menu with several items, each having an ID, name, and price. Store this menu using an `ArrayList` assigned to a `List` interface variable.
 * 2.  **Order Management:** Use a `Queue` to hold incoming customer orders. Orders should be processed in a First-In, First-Out (FIFO) manner.
 * 3.  **Order Structure:** Define a class `Order` to represent a customer order. An `Order` should contain an order ID (a simple counter is fine) and a list of `MenuItem` objects selected by the customer.
 * 4.  **Menu Items Structure:** Define a class `MenuItem` to represent an item on the menu, with fields for ID, name, and price.
 * 5.  **User Interface:**
 *     *   Present a main menu to the user with options:
 *         1.  Add New Order
 *         2.  Process Next Order
 *         3.  View Pending Orders
 *         4.  View Menu
 *         5.  Exit
 *     *   Use `Scanner` to read the user's menu choice and order details.
 *     *   Use a `switch` statement to handle the user's selection.
 *     *   Use `System.out` for displaying the menu, prompts, order details, and system status.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, queue empty).
 * 6.  **Functionality:**
 *     *   **Add New Order:** Prompt the user to enter the IDs of the menu items they want to add to the order. Allow adding multiple items until the user enters a specific sentinel value (e.g., 0). Validate that the entered item IDs exist in the menu. Create an `Order` object with the selected items and add it to the `Queue`.
 *     *   **Process Next Order:** Remove and display the order at the front of the `Queue`. If the `Queue` is empty, display an error message.
 *     *   **View Pending Orders:** Display the details of all orders currently in the `Queue` without removing them. If the `Queue` is empty, display a message indicating so.
 *     *   **View Menu:** Display the list of available menu items with their IDs, names, and prices.
 *     *   **Exit:** Terminate the program.
 * 7.  **Error Handling:** Implement robust error handling:
 *     *   Catch `NumberFormatException` or similar input errors when reading integer inputs (menu choice, item IDs).
 *     *   Handle cases where the user tries to process an order when the queue is empty.
 *     *   Validate menu item IDs entered by the user.
 *     *   Use a `try-catch` block around the main operation loop or specific risky operations to demonstrate class-wide or method-level exception handling.
 * 8.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Implement proper encapsulation (private fields, public getters/setters where necessary, though getters should suffice for `MenuItem` and `Order`).
 *     *   Add comments to explain complex logic or class/method purpose.
 *     *   Structure your code into appropriate classes (`MenuItem`, `Order`, and the main class managing the system).
 * 
 * **Expected Output:**
 * The program should run interactively, displaying the main menu, responding to user input, and providing appropriate output or error messages based on the selected action. Examples:
 * 
 * *   Selecting '4' should display the menu.
 * *   Selecting '1' should prompt for item IDs and confirm when an order is added.
 * *   Selecting '2' should display the processed order or an error if the queue is empty.
 * *   Selecting '3' should list pending orders or state the queue is empty.
 * *   Entering invalid input (e.g., text for a number) should result in an error message and allow the user to continue.
 * 
 * Implement the complete Java code for this system.
 *
 * EXPLANATION:
 * This solution implements a simple Cafe Order Management System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `MenuItem`: A simple Plain Old Java Object (POJO) representing a menu item with encapsulated `id`, `name`, and `price`. It provides public getters and a `toString` method for easy display.
 *     *   `Order`: Represents a customer order. It contains a unique `orderId` (generated using a static counter), a `List<MenuItem>` to hold the items in the order, and calculates the `totalCost`. It also uses encapsulation and provides getters and a `toString` method.
 *     *   `CafeOrderManager`: The main class that orchestrates the system. It holds the `menuItems` (as a `List` implemented by `ArrayList`) and the `orderQueue` (as a `Queue` implemented by `LinkedList`). It contains methods for each menu option and the main `run` loop.
 * 
 * 2.  **Required Components Usage:**
 *     *   `Queue`: The `orderQueue` is declared as `Queue<Order>` and initialized with `new LinkedList<>()`. The `add()` method is used to add new orders, and `poll()` is used to retrieve and remove the next order for processing. The `isEmpty()` method checks if the queue has orders. The `for (Order order : orderQueue)` loop demonstrates iterating over the `Queue` (which is `Iterable`) to view pending orders without removing them.
 *     *   `ArrayList`: The `menuItems` list is initialized as `new ArrayList<>()`. It is used to store the `MenuItem` objects. `ArrayList` is also used internally within the `Order` class to store the `List<MenuItem>` for that specific order.
 *     *   `List interface`: The `menuItems` variable is declared as `List<MenuItem>`, demonstrating programming to the interface rather than the specific implementation (`ArrayList`). The `Order` class also uses `List<MenuItem>` for its `items` field.
 *     *   `Scanner`: A `Scanner` object `scanner` is used to read user input from `System.in`. `scanner.nextLine()` is used to read entire lines to avoid issues with leftover newlines and to facilitate `NumberFormatException` handling via `Integer.parseInt()`.
 *     *   `Switch statement`: A `switch` statement in the `run()` method handles the different menu choices entered by the user, directing the flow to the appropriate method (`addNewOrder`, `processNextOrder`, etc.).
 *     *   `System.err`: Used specifically for displaying error messages, such as invalid menu choices, input parsing errors, or attempting to process an empty queue.
 *     *   `System.out`: Used for all standard output, including the main menu, prompts, displaying the menu, confirming actions, and showing order details.
 *     *   `Class-wide exception handling with try-catch`: The `run()` method contains a `try-catch` block that wraps the core logic of reading the user's main menu choice and calling the corresponding method. This block catches `NumberFormatException` specifically for invalid integer input on the main menu and a general `Exception` for any other unexpected runtime errors within that scope, fulfilling the requirement for exception handling covering a section of the class's operations. Additionally, specific checks (e.g., `orderQueue.isEmpty()`, `findMenuItemById` returning null) handle known error conditions gracefully.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `MenuItem` and `Order` are `private`, with `public` getter methods provided for accessing data.
 *     *   **Meaningful Names:** Variable names (`menuItems`, `orderQueue`, `selectedItem`, `currentOrderItems`) and method names (`initializeMenu`, `addNewOrder`, `processNextOrder`, `viewPendingOrders`, `findMenuItemById`) clearly indicate their purpose.
 *     *   **Comments:** Javadoc-style comments explain the purpose of classes and methods. Inline comments clarify specific logic.
 *     *   **Input Validation:** The code checks if entered item IDs exist in the menu (`findMenuItemById`). It also handles non-numeric input for both the main menu choice and item IDs using `try-catch` blocks around `Integer.parseInt()`.
 *     *   **Proper Error Handling:** Specific error messages are provided using `System.err` for different failure conditions (invalid choice, empty queue, invalid item ID, non-numeric input). The `try-catch` in `run()` provides a safety net.
 *     *   **Clean Code Structure:** The logic is separated into distinct methods (`addNewOrder`, `processNextOrder`, etc.), making the code modular and easier to understand.
 * 
 * This solution effectively integrates the required Java components into a practical scenario, demonstrating understanding of data structures (`List`, `Queue`), control flow (`switch`, `while`), user interaction (`Scanner`), object-oriented principles (classes, encapsulation), and error management (`try-catch`, `System.err`).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException; // Useful for nextInt, but we'll use nextLine and parse for NumberFormatException

// Represents an item on the cafe menu
class MenuItem {
    private int id;
    private String name;
    private double price;

    /**
     * Constructs a new MenuItem.
     * @param id The unique ID of the menu item.
     * @param name The name of the menu item.
     * @param price The price of the menu item.
     */
    public MenuItem(int id, String name, double price) {
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
        return String.format("%d: %s (%.2f)", id, name, price);
    }
}

// Represents a customer order
class Order {
    private static int orderCounter = 0; // To generate unique order IDs
    private int orderId;
    private List<MenuItem> items;
    private double totalCost;

    /**
     * Constructs a new Order.
     * @param items The list of menu items included in the order.
     */
    public Order(List<MenuItem> items) {
        this.orderId = ++orderCounter;
        this.items = new ArrayList<>(items); // Create a copy to ensure immutability
        calculateTotalCost();
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return new ArrayList<>(items); // Return a copy to prevent external modification
    }

    public double getTotalCost() {
        return totalCost;
    }

    /**
     * Calculates the total cost of the order based on the items.
     */
    private void calculateTotalCost() {
        this.totalCost = 0;
        for (MenuItem item : items) {
            this.totalCost += item.getPrice();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderId).append(" (Total: $").append(String.format("%.2f", totalCost)).append(")\n");
        sb.append("  Items:\n");
        for (MenuItem item : items) {
            sb.append("    - ").append(item.getName()).append(" ($").append(String.format("%.2f", item.getPrice())).append(")\n");
        }
        return sb.toString();
    }
}

// Main class managing the cafe order system
public class CafeOrderManager {

    // Using List interface for menuItems, implemented by ArrayList
    private List<MenuItem> menuItems;
    // Using Queue interface for orderQueue, implemented by LinkedList
    private Queue<Order> orderQueue;
    private Scanner scanner;

    /**
     * Constructs the CafeOrderManager and initializes the menu and order queue.
     */
    public CafeOrderManager() {
        menuItems = new ArrayList<>();
        orderQueue = new LinkedList<>(); // LinkedList implements Queue
        scanner = new Scanner(System.in);
        initializeMenu();
    }

    /**
     * Initializes the predefined menu items.
     */
    private void initializeMenu() {
        menuItems.add(new MenuItem(101, "Espresso", 2.50));
        menuItems.add(new MenuItem(102, "Latte", 3.75));
        menuItems.add(new MenuItem(103, "Cappuccino", 3.75));
        menuItems.add(new MenuItem(201, "Croissant", 3.00));
        menuItems.add(new MenuItem(202, "Muffin", 2.75));
        menuItems.add(new MenuItem(301, "Orange Juice", 3.50));
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMainMenu() {
        System.out.println("\n--- Cafe Order Management ---");
        System.out.println("1. Add New Order");
        System.out.println("2. Process Next Order");
        System.out.println("3. View Pending Orders");
        System.out.println("4. View Menu");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Finds a MenuItem by its ID.
     * @param id The ID of the menu item to find.
     * @return The MenuItem object if found, otherwise null.
     */
    private MenuItem findMenuItemById(int id) {
        for (MenuItem item : menuItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Item not found
    }

    /**
     * Handles the process of adding a new order based on user input.
     */
    private void addNewOrder() {
        List<MenuItem> currentOrderItems = new ArrayList<>();
        System.out.println("\n--- Add New Order ---");
        System.out.println("Enter item IDs to add to the order (enter 0 to finish):");

        while (true) {
            System.out.print("Enter item ID (or 0 to finish): ");
            String input = scanner.nextLine();
            int itemId;

            try {
                itemId = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number.");
                continue; // Ask for input again
            }

            if (itemId == 0) {
                if (currentOrderItems.isEmpty()) {
                    System.out.println("No items added to the order. Order cancelled.");
                    return; // Exit the add order process
                }
                break; // Finish adding items
            }

            MenuItem selectedItem = findMenuItemById(itemId);
            if (selectedItem != null) {
                currentOrderItems.add(selectedItem);
                System.out.println(selectedItem.getName() + " added to order.");
            } else {
                System.err.println("Invalid item ID: " + itemId + ". Item not found on the menu.");
            }
        }

        Order newOrder = new Order(currentOrderItems);
        orderQueue.add(newOrder); // Add the new order to the queue
        System.out.println("\nOrder #" + newOrder.getOrderId() + " added to the queue.");
        System.out.println("Total items in order: " + currentOrderItems.size());
    }

    /**
     * Processes the next order from the queue.
     */
    private void processNextOrder() {
        System.out.println("\n--- Process Next Order ---");
        if (orderQueue.isEmpty()) {
            System.err.println("The order queue is currently empty. No orders to process.");
        } else {
            Order processedOrder = orderQueue.poll(); // Retrieves and removes the head of the queue
            System.out.println("Processing " + processedOrder.toString());
            System.out.println("Order #" + processedOrder.getOrderId() + " processed successfully.");
        }
    }

    /**
     * Displays all pending orders in the queue without removing them.
     */
    private void viewPendingOrders() {
        System.out.println("\n--- Pending Orders ---");
        if (orderQueue.isEmpty()) {
            System.out.println("The order queue is currently empty.");
        } else {
            // Iterate through the queue without removing elements
            int count = 0;
            for (Order order : orderQueue) { // Queue is Iterable
                System.out.println(order.toString());
                count++;
            }
            System.out.println("Total pending orders: " + count);
        }
    }

    /**
     * Displays the available menu items.
     */
    private void viewMenu() {
        System.out.println("\n--- Cafe Menu ---");
        if (menuItems.isEmpty()) {
            System.out.println("Menu is not available.");
        } else {
            for (MenuItem item : menuItems) {
                System.out.println(item); // Uses MenuItem's toString()
            }
        }
    }

    /**
     * Runs the main application loop.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            String choiceInput = scanner.nextLine();

            // Class-wide or method-level exception handling
            try {
                int choice = Integer.parseInt(choiceInput);

                switch (choice) {
                    case 1:
                        addNewOrder();
                        break;
                    case 2:
                        processNextOrder();
                        break;
                    case 3:
                        viewPendingOrders();
                        break;
                    case 4:
                        viewMenu();
                        break;
                    case 5:
                        System.out.println("Exiting Cafe Order Management. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                // Catch non-integer input for the main menu choice
                System.err.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging
            }
        }
        scanner.close(); // Close the scanner when done
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        CafeOrderManager manager = new CafeOrderManager();
        manager.run();
    }
}
