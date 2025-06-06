/*
 * Exam Question #937
 * Generated on: 2025-05-12 17:02:13
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Restaurant Order Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application for a small restaurant to manage customer orders. The system needs to handle a predefined menu, allow placing new orders (which can contain multiple items), process orders in the order they were received, and display the current state of pending orders.
 * 
 * **Requirements:**
 * 
 * 1.  **Menu:** The system should have a predefined menu of items with names and prices. Use an `ArrayList` to store these menu items, accessed via the `List` interface.
 * 2.  **Orders:** Each order should have a unique sequential order number and contain a list of items ordered. Orders should be processed in a First-In, First-Out (FIFO) manner. Use a `Queue` to manage the pending orders.
 * 3.  **User Interface:** Implement a command-line interface using `Scanner` to interact with the user. The user should be presented with a menu of options.
 * 4.  **Functionality:**
 *     *   **View Menu:** Display the list of available menu items with their IDs and prices.
 *     *   **Place New Order:**
 *         *   Prompt the user to enter the ID of a menu item.
 *         *   Allow the user to add multiple items to a single order until they indicate they are finished.
 *         *   Validate that the entered item ID is valid (exists in the menu).
 *         *   Create a new `Order` object containing the selected items.
 *         *   Add the new order to the pending order queue.
 *         *   Assign a unique, incrementing order number to each new order.
 *         *   Display a confirmation message with the order number and total price.
 *     *   **Complete Next Order:**
 *         *   Remove the next order from the front of the queue (the one that has been waiting the longest).
 *         *   If the queue is empty, display an error message.
 *         *   If an order is completed, display the order number that was completed.
 *     *   **View Order Queue:** Display the order numbers of all pending orders currently in the queue, from the front (next to be completed) to the back.
 *     *   **Exit:** Terminate the application.
 * 5.  **Control Flow:** Use a `switch` statement to handle the different user commands.
 * 6.  **Error Handling:**
 *     *   Use `try-catch` blocks to handle potential exceptions, particularly for invalid user input (e.g., non-numeric input when expecting a number, entering an invalid menu item ID).
 *     *   Use `System.err` to print error messages (e.g., invalid input, queue empty when trying to complete).
 *     *   Use `System.out` for all normal output (menu display, prompts, confirmations, queue status, completed order notifications).
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Implement proper encapsulation (private fields, public methods).
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Perform input validation where necessary.
 * 
 * **Class Structure:**
 * 
 * You should create at least the following classes:
 * *   `MenuItem`: Represents an item on the menu (e.g., name, price).
 * *   `Order`: Represents a customer order (e.g., order number, list of `MenuItem`s, calculate total).
 * *   `RestaurantManager`: Contains the `main` method and manages the menu (`List<MenuItem>`) and the order queue (`Queue<Order>`).
 * 
 * **Expected Output:**
 * 
 * The output should be clear and follow the interactions described above. Error messages should go to `System.err`.
 * 
 * **Example Interaction (Illustrative):**
 * 
 * ```
 * Restaurant Order Management System
 * 1. View Menu
 * 2. Place New Order
 * 3. Complete Next Order
 * 4. View Order Queue
 * 5. Exit
 * Enter your choice: 1
 * --- Menu ---
 * ID: 1, Burger: $5.99
 * ID: 2, Fries: $2.49
 * ID: 3, Soda: $1.99
 * ------------
 * Enter your choice: 2
 * --- Place New Order ---
 * Enter Menu Item ID (or 0 to finish order): 1
 * Added: Burger
 * Enter Menu Item ID (or 0 to finish order): 2
 * Added: Fries
 * Enter Menu Item ID (or 0 to finish order): 0
 * Order #1 placed. Total: $8.48
 * ------------
 * Enter your choice: 2
 * --- Place New Order ---
 * Enter Menu Item ID (or 0 to finish order): 3
 * Added: Soda
 * Enter Menu Item ID (or 0 to finish order): 99 // Invalid input
 * Error: Invalid menu item ID. Please try again.
 * Enter Menu Item ID (or 0 to finish order): 1
 * Added: Burger
 * Enter Menu Item ID (or 0 to finish order): 0
 * Order #2 placed. Total: $7.98
 * ------------
 * Enter your choice: 4
 * --- Pending Orders (Order #) ---
 * 1 -> 2
 * ------------
 * Enter your choice: 3
 * Completed Order #1
 * ------------
 * Enter your choice: 4
 * --- Pending Orders (Order #) ---
 * 2
 * ------------
 * Enter your choice: 3
 * Completed Order #2
 * ------------
 * Enter your choice: 3
 * Error: No orders in the queue to complete.
 * Enter your choice: abc // Invalid input type
 * Error: Invalid input. Please enter a number.
 * Enter your choice: 5
 * Exiting system.
 * ```
 * 
 * **Constraints:**
 * 
 * *   Focus on implementing the core logic using the required components.
 * *   Keep the menu simple (a few items).
 * *   Error handling should focus on the input parsing and the "queue empty" condition for completing orders.
 * 
 * **Assessment:**
 * 
 * Your solution will be assessed on:
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch`.
 * *   Correct implementation of the required functionality.
 * *   Adherence to best practices (encapsulation, naming, comments, input validation).
 * *   Robustness of error handling.
 * *   Code clarity and structure.
 *
 * EXPLANATION:
 * This solution implements a simple restaurant order management system using the required Java components and best practices.
 * 
 * 1.  **`MenuItem` Class:** A simple class representing an item with an ID, name, and price. It uses private fields and public getters for encapsulation. The `toString()` method provides a formatted string for display.
 * 
 * 2.  **`Order` Class:** Represents a customer order.
 *     *   It uses a static `orderCounter` to generate unique sequential order numbers, demonstrating a simple way to handle unique identifiers.
 *     *   It holds a `List<MenuItem>` named `items` to store the items in the order. This uses the `List` interface type declaration, but the actual object created is an `ArrayList`, fulfilling that requirement.
 *     *   The `addItem()` method adds a `MenuItem` to the `items` list.
 *     *   `calculateTotal()` iterates through the `items` list to sum the prices.
 *     *   `toString()` provides a formatted summary of the order.
 * 
 * 3.  **`RestaurantManager` Class:** This is the main class containing the application logic.
 *     *   **Fields:**
 *         *   `menuItems`: Declared as `List<MenuItem>` and initialized with an `ArrayList<MenuItem>`. This holds the restaurant's menu.
 *         *   `orderQueue`: Declared as `Queue<Order>` and initialized with a `LinkedList<Order>`. `LinkedList` is a common implementation of the `Queue` interface suitable for this FIFO order processing.
 *         *   `scanner`: A `Scanner` object for reading user input from `System.in`.
 *     *   **Constructor:** Initializes the `menuItems` list with some sample data and creates the `orderQueue` and `scanner`.
 *     *   **`displayMenu()`:** Iterates through the `menuItems` (the `ArrayList` referenced by the `List` variable) and prints each item using its `toString()` method. Uses `System.out`.
 *     *   **`findMenuItemById()`:** A helper method that iterates through the `menuItems` list to find an item by its unique ID.
 *     *   **`placeNewOrder()`:**
 *         *   Creates a new `Order` object.
 *         *   Enters a loop to allow adding multiple items.
 *         *   Uses `scanner.nextLine()` to read input as a string, which is safer than `nextInt()` when mixing with `nextLine()`.
 *         *   Uses `Integer.parseInt()` to convert the input string to an integer. This is a potential source of `NumberFormatException`, which is caught by a `try-catch` block.
 *         *   Calls `findMenuItemById()` to validate the input ID against the `menuItems` list.
 *         *   If the ID is valid, the corresponding `MenuItem` is added to the `currentOrder`'s list.
 *         *   If the ID is invalid or parsing fails, an error message is printed to `System.err`.
 *         *   When the user enters '0' and the order is not empty, the loop breaks.
 *         *   The completed `currentOrder` is added to the `orderQueue` using `offer()`.
 *         *   A confirmation message with the order number and total price is printed to `System.out`.
 *     *   **`completeNextOrder()`:**
 *         *   Uses `orderQueue.poll()` to retrieve and remove the element at the front of the queue. `poll()` is used because it returns `null` if the queue is empty, which is handled gracefully.
 *         *   If `poll()` returns an `Order`, its completion is reported to `System.out`.
 *         *   If `poll()` returns `null` (queue was empty), an error is reported to `System.err`.
 *     *   **`viewOrderQueue()`:**
 *         *   Checks if the `orderQueue` is empty.
 *         *   If not empty, it iterates through the `orderQueue` using an enhanced for loop (which uses the queue's iterator) to print the order numbers without removing them.
 *         *   Output is printed to `System.out`.
 *     *   **`displayMainMenu()`:** Prints the menu options to `System.out`.
 *     *   **`main()` Method:**
 *         *   Creates a `RestaurantManager` instance.
 *         *   Enters a `while(running)` loop for the main application cycle.
 *         *   Calls `displayMainMenu()`.
 *         *   Reads the user's choice using `scanner.nextLine()`.
 *         *   Uses a `try-catch` block around `Integer.parseInt()` to handle `NumberFormatException` if the user enters non-numeric input. This demonstrates class-wide exception handling for input parsing. A general `catch (Exception e)` is included as a fallback for other potential unexpected errors, printing to `System.err`.
 *         *   Uses a `switch` statement on the parsed integer choice to call the appropriate manager methods or set `running` to `false` for exit.
 *         *   A `default` case in the `switch` handles invalid numeric choices, printing an error to `System.err`.
 *         *   The `scanner` is closed when the loop finishes.
 * 
 * This solution effectively combines the required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical, encapsulated, and error-handled structure, demonstrating advanced understanding of Java programming concepts.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a menu item in the restaurant.
 */
class MenuItem {
    private int id;
    private String name;
    private double price;

    /**
     * Constructs a MenuItem.
     * @param id The unique ID of the item.
     * @param name The name of the item.
     * @param price The price of the item.
     */
    public MenuItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // --- Getters ---
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
        return String.format("ID: %d, %s: $%.2f", id, name, price);
    }
}

/**
 * Represents a customer order containing multiple menu items.
 */
class Order {
    private static int orderCounter = 0; // Static counter for unique order numbers
    private int orderNumber;
    private List<MenuItem> items; // Using List interface for items

    /**
     * Constructs an empty Order with a unique number.
     */
    public Order() {
        orderCounter++;
        this.orderNumber = orderCounter;
        this.items = new ArrayList<>(); // Using ArrayList implementation
    }

    /**
     * Adds a menu item to the order.
     * @param item The MenuItem to add.
     */
    public void addItem(MenuItem item) {
        items.add(item);
    }

    /**
     * Calculates the total price of the order.
     * @return The total price.
     */
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // --- Getters ---
    public int getOrderNumber() {
        return orderNumber;
    }

    public List<MenuItem> getItems() {
        return items; // Return the list of items
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderNumber).append(" (Total: $").append(String.format("%.2f", calculateTotal())).append(")\n");
        for (MenuItem item : items) {
            sb.append("  - ").append(item.getName()).append("\n");
        }
        return sb.toString();
    }
}

/**
 * Manages the restaurant's menu and order queue.
 */
public class RestaurantManager {

    private List<MenuItem> menuItems; // Using List interface
    private Queue<Order> orderQueue; // Using Queue interface
    private Scanner scanner;

    /**
     * Constructs a RestaurantManager, initializing the menu and queue.
     */
    public RestaurantManager() {
        // Initialize menu using ArrayList
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(1, "Burger", 5.99));
        menuItems.add(new MenuItem(2, "Fries", 2.49));
        menuItems.add(new MenuItem(3, "Soda", 1.99));
        menuItems.add(new MenuItem(4, "Pizza Slice", 3.50));
        menuItems.add(new MenuItem(5, "Salad", 4.50));

        // Initialize order queue using LinkedList as a Queue implementation
        orderQueue = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the menu items.
     */
    private void displayMenu() {
        System.out.println("\n--- Menu ---");
        // Iterate through the List of MenuItems
        for (MenuItem item : menuItems) {
            System.out.println(item); // Uses MenuItem's toString()
        }
        System.out.println("------------");
    }

    /**
     * Finds a MenuItem by its ID.
     * @param id The ID to search for.
     * @return The MenuItem object, or null if not found.
     */
    private MenuItem findMenuItemById(int id) {
        // Iterate through the List to find the item
        for (MenuItem item : menuItems) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Item not found
    }

    /**
     * Handles placing a new order based on user input.
     */
    private void placeNewOrder() {
        System.out.println("\n--- Place New Order ---");
        Order currentOrder = new Order(); // Create a new empty order

        while (true) {
            System.out.print("Enter Menu Item ID (or 0 to finish order): ");
            try {
                int itemId = Integer.parseInt(scanner.nextLine()); // Read line and parse

                if (itemId == 0) {
                    if (currentOrder.getItems().isEmpty()) {
                        System.err.println("Error: Order is empty. Please add at least one item.");
                    } else {
                        break; // Finish order
                    }
                } else {
                    MenuItem selectedItem = findMenuItemById(itemId);
                    if (selectedItem != null) {
                        currentOrder.addItem(selectedItem);
                        System.out.println("Added: " + selectedItem.getName());
                    } else {
                        System.err.println("Error: Invalid menu item ID. Please try again."); // Error output
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Error: Invalid input. Please enter a number."); // Error output
            }
        }

        // Add the completed order to the queue
        orderQueue.offer(currentOrder); // offer() is preferred over add() for capacity-constrained queues (though LinkedList is not)

        System.out.printf("Order #%d placed. Total: $%.2f%n",
                currentOrder.getOrderNumber(), currentOrder.calculateTotal()); // Normal output
        System.out.println("------------");
    }

    /**
     * Completes the next order in the queue.
     */
    private void completeNextOrder() {
        System.out.println("\n--- Complete Next Order ---");
        // Poll the next order from the front of the Queue
        Order completedOrder = orderQueue.poll(); // poll() returns null if queue is empty

        if (completedOrder != null) {
            System.out.println("Completed Order #" + completedOrder.getOrderNumber()); // Normal output
        } else {
            System.err.println("Error: No orders in the queue to complete."); // Error output
        }
        System.out.println("------------");
    }

    /**
     * Displays the order numbers currently in the queue.
     */
    private void viewOrderQueue() {
        System.out.println("\n--- Pending Orders (Order #) ---");
        if (orderQueue.isEmpty()) {
            System.out.println("Queue is empty."); // Normal output
        } else {
            // Iterate through the Queue elements (peek() or iterator)
            // Using iterator to display all without removing
            boolean first = true;
            for (Order order : orderQueue) {
                if (!first) {
                    System.out.print(" -> ");
                }
                System.out.print(order.getOrderNumber()); // Normal output
                first = false;
            }
            System.out.println(); // Newline after listing orders
        }
        System.out.println("------------");
    }

    /**
     * Displays the main menu options.
     */
    private void displayMainMenu() {
        System.out.println("\nRestaurant Order Management System");
        System.out.println("1. View Menu");
        System.out.println("2. Place New Order");
        System.out.println("3. Complete Next Order");
        System.out.println("4. View Order Queue");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * The main method to run the restaurant manager application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        RestaurantManager manager = new RestaurantManager();
        boolean running = true;

        while (running) {
            manager.displayMainMenu();
            String inputLine = manager.scanner.nextLine(); // Read the whole line

            // Class-wide exception handling for input parsing
            try {
                int choice = Integer.parseInt(inputLine);

                // Use switch statement for control flow
                switch (choice) {
                    case 1:
                        manager.displayMenu();
                        break;
                    case 2:
                        manager.placeNewOrder();
                        break;
                    case 3:
                        manager.completeNextOrder();
                        break;
                    case 4:
                        manager.viewOrderQueue();
                        break;
                    case 5:
                        System.out.println("Exiting system."); // Normal output
                        running = false;
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5."); // Error output
                }
            } catch (NumberFormatException e) {
                // Catch exception if input is not a valid integer
                System.err.println("Error: Invalid input. Please enter a number."); // Error output
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage()); // Error output
                e.printStackTrace(System.err); // Print stack trace to standard error
            }
        }

        // Close the scanner when done
        manager.scanner.close();
    }
}
