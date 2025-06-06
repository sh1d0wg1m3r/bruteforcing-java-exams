/*
 * Exam Question #168
 * Generated on: 2025-05-11 22:25:02
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Java Programming Exam: Restaurant Order Management System**
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified order management system for a small restaurant. The system should allow staff to display the menu, place new customer orders, process the next order waiting in the kitchen queue, and view the current orders in the queue.
 * 
 * Your solution must adhere to the following requirements:
 * 
 * 1.  **Core Functionality:**
 *     *   Maintain a list of menu items. Each item has a unique ID, name, and price.
 *     *   Maintain a queue of customer orders. Each order consists of a list of menu items selected by the customer. Orders are processed in a First-In, First-Out (FIFO) manner.
 *     *   Provide a command-line interface for user interaction.
 * 
 * 2.  **User Interface:**
 *     *   The program should present a menu of actions to the user:
 *         1.  Display Menu
 *         2.  Place New Order
 *         3.  Process Next Order
 *         4.  View Order Queue Status
 *         5.  Exit
 *     *   Use `System.out` for displaying the menu, order details, and status messages.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, empty queue, item not found).
 * 
 * 3.  **Implementation Details:**
 *     *   Use `java.util.Queue` to manage the waiting orders. A `LinkedList` is a suitable concrete implementation.
 *     *   Use `java.util.ArrayList` to store the list of menu items and the items within an order.
 *     *   Use the `java.util.List` interface type for declaring variables that hold lists (e.g., the menu list, the list of items in an order).
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Use a `switch` statement to handle the different user menu choices.
 *     *   Implement robust exception handling using `try-catch` blocks, specifically to handle non-numeric user input errors (`NumberFormatException`). Also handle cases like trying to process an empty queue.
 * 
 * 4.  **Code Structure and Best Practices:**
 *     *   Create separate classes for `MenuItem`, `Order`, and `RestaurantSystem`.
 *     *   Use proper encapsulation (private fields, public getters/setters where necessary, public methods for operations).
 *     *   Use meaningful names for variables, methods, and classes.
 *     *   Include comments to explain complex logic or class purpose.
 *     *   Validate user input (e.g., ensuring menu choices are within range, item IDs exist).
 *     *   Handle errors gracefully using `System.err`.
 * 
 * **Scenario Flow (Place New Order):**
 * 
 * When the user selects "Place New Order":
 * 1.  Display the menu.
 * 2.  Prompt the user to enter the ID of an item to add to the order.
 * 3.  The user should be able to enter multiple item IDs.
 * 4.  Provide a way for the user to indicate they have finished adding items (e.g., entering `0`).
 * 5.  Validate each entered item ID. If an ID is invalid, print an error to `System.err` and allow the user to continue adding other items.
 * 6.  If the order contains at least one item, create an `Order` object and add it to the order queue.
 * 7.  If the user finishes without adding any items, do not add an empty order to the queue.
 * 
 * **Scenario Flow (Process Next Order):**
 * 
 * When the user selects "Process Next Order":
 * 1.  Attempt to remove the next order from the queue.
 * 2.  If the queue is empty, print an error message to `System.err`.
 * 3.  If an order is successfully processed, print a confirmation message to `System.out`, potentially listing the items in the processed order.
 * 
 * **Scenario Flow (View Order Queue Status):**
 * 
 * When the user selects "View Order Queue Status":
 * 1.  Print the current number of orders waiting in the queue to `System.out`.
 * 2.  If the queue is not empty, you may optionally peek at the next order without removing it (e.g., print its ID or a summary). Printing just the size is sufficient to meet requirements.
 * 
 * **Initial Setup:**
 * 
 * *   Initialize the `RestaurantSystem` with a few sample `MenuItem`s.
 * 
 * **Expected Output:**
 * 
 * The program should interact with the user via the console, displaying menus, prompts, order details, and error messages as described. Example interactions might look like:
 * 
 * ```
 * --- Restaurant System Menu ---
 * 1. Display Menu
 * 2. Place New Order
 * 3. Process Next Order
 * 4. View Order Queue Status
 * 5. Exit
 * Enter choice: 1
 * --- Menu ---
 * ID: 101, Name: Burger, Price: $8.99
 * ID: 102, Name: Fries, Price: $3.49
 * ID: 103, Name: Soda, Price: $1.99
 * ----------------------------
 * Enter choice: 2
 * --- Placing New Order ---
 * Enter item ID (0 to finish): 101
 * Added: Burger
 * Enter item ID (0 to finish): 103
 * Added: Soda
 * Enter item ID (0 to finish): 999
 * Error: Item with ID 999 not found.
 * Enter item ID (0 to finish): 0
 * Order #1 placed with 2 items.
 * --- Restaurant System Menu ---
 * ...
 * Enter choice: 4
 * Order Queue Status: 1 order(s) waiting.
 * --- Restaurant System Menu ---
 * ...
 * Enter choice: 3
 * Processing Order #1...
 * Processed Order #1 with items: [Burger, Soda]
 * --- Restaurant System Menu ---
 * ...
 * Enter choice: 4
 * Order Queue Status: 0 order(s) waiting.
 * --- Restaurant System Menu ---
 * ...
 * Enter choice: 3
 * Error: No orders in the queue to process.
 * --- Restaurant System Menu ---
 * ...
 * Enter choice: 6
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * --- Restaurant System Menu ---
 * ...
 * Enter choice: exit
 * Error: Invalid input. Please enter a number.
 * --- Restaurant System Menu ---
 * ...
 * Enter choice: 5
 * Exiting system.
 * ```
 * 
 * **Task:**
 * 
 * Write the complete Java code for the `MenuItem`, `Order`, and `RestaurantSystem` classes to implement the described functionality, ensuring all requirements are met.
 * 
 * **Evaluation:**
 * 
 * Your solution will be evaluated based on:
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch`.
 * *   Correct implementation of the restaurant system logic.
 * *   Adherence to object-oriented principles (encapsulation).
 * *   Input validation and error handling.
 * *   Code clarity, comments, and formatting.
 *
 * EXPLANATION:
 * This solution implements a simplified restaurant order management system using the required Java components and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `MenuItem`: A simple class encapsulating the data for a menu item (`id`, `name`, `price`). It uses private fields and public getters for encapsulation.
 *     *   `Order`: Represents a customer's order. It contains a unique `orderId` and a `List` of `MenuItem`s. It uses an `ArrayList` internally to store the items, demonstrating the use of both the `List` interface and the `ArrayList` concrete class. It has methods to add items and check if the order is empty.
 *     *   `RestaurantSystem`: This is the main class that orchestrates the system. It holds the `menu` (as a `List<MenuItem>`) and the `orderQueue` (as a `Queue<Order>`). It contains methods corresponding to the user's menu choices and the main `run` loop.
 * 
 * 2.  **Required Components Usage:**
 *     *   `java.util.Queue`: The `orderQueue` is declared as a `Queue<Order>` and initialized with a `LinkedList`. Orders are added using `offer()` in `placeNewOrder` and removed using `poll()` in `processNextOrder`. `peek()` is used in `viewOrderQueueStatus` to inspect the next element without removal.
 *     *   `java.util.ArrayList`: Used to initialize the `menu` list in `RestaurantSystem` and internally by the `Order` class to store the `items`.
 *     *   `java.util.List`: Used as the type declaration for the `menu` field in `RestaurantSystem` and the `items` field in the `Order` class, promoting interface-based programming.
 *     *   `java.util.Scanner`: An instance is created in `RestaurantSystem`'s constructor and used in the `run` method (for main menu input) and `placeNewOrder` (for item ID input) to read from `System.in`. The scanner is closed upon exiting.
 *     *   `switch` statement: Used in the `run` method to direct program flow based on the user's main menu choice.
 *     *   `System.err`: Used to print error messages for invalid main menu choices, invalid item IDs during order placement, non-numeric input, and attempting to process an empty queue.
 *     *   `System.out`: Used for all normal output, including displaying the main menu, the restaurant menu, confirmation messages for placing and processing orders, and the queue status.
 *     *   `try-catch` blocks:
 *         *   A `try-catch(NumberFormatException)` is used in the `run` method to handle cases where the user enters non-integer input for the main menu choice.
 *         *   A `try-catch(NumberFormatException)` is also used within the `placeNewOrder` method to handle non-integer input when prompting for item IDs.
 *         *   While `poll()` and `peek()` on an empty queue return `null` (which is handled with `if` checks), using `try-catch` for `NumberFormatException` around user input parsing directly addresses the requirement for class-wide exception handling in a practical scenario involving user input. A general `catch(Exception e)` is also included in the main loop for robustness against unforeseen errors.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Private fields (`id`, `name`, `price` in `MenuItem`; `orderId`, `items` in `Order`; `menu`, `orderQueue`, `scanner` in `RestaurantSystem`) are accessed via public methods (getters, `addMenuItem`, `placeNewOrder`, etc.).
 *     *   **Meaningful Names:** Class names (`MenuItem`, `Order`, `RestaurantSystem`), variable names (`menu`, `orderQueue`, `itemId`, `selectedItem`), and method names (`displayMenu`, `placeNewOrder`, `processNextOrder`, `findMenuItemById`) are descriptive.
 *     *   **Comments:** Javadoc comments explain the purpose of classes and methods, and inline comments explain specific logic points.
 *     *   **Input Validation:** Checks are performed to ensure menu choices are within the expected range (via `switch` `default`) and that entered item IDs exist in the menu (`findMenuItemById`). Non-numeric input is handled via `try-catch`.
 *     *   **Error Handling:** Error conditions (invalid input, item not found, empty queue) are explicitly checked and reported to `System.err`.
 *     *   **Clean Code Structure:** The code is divided into logical classes, and methods are reasonably sized, each responsible for a specific task. The main `run` method provides a clear loop for interaction.
 * 
 * This solution effectively integrates all required components within a practical and challenging scenario, demonstrating key Java programming concepts and best practices suitable for an advanced exam.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.NoSuchElementException; // Although poll is safer, let's show try-catch with a queue method if possible, or rely on input parsing. Input parsing is sufficient.

/**
 * Represents a single menu item in the restaurant.
 */
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
        return name; // Simplified representation for order display
    }
}

/**
 * Represents a customer order containing a list of menu items.
 */
class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private List<MenuItem> items;

    /**
     * Constructs a new Order.
     */
    public Order() {
        this.orderId = nextOrderId++;
        // Using ArrayList as a concrete implementation of List for storing items
        this.items = new ArrayList<>();
    }

    /**
     * Adds a menu item to this order.
     * @param item The MenuItem to add.
     */
    public void addMenuItem(MenuItem item) {
        if (item != null) {
            this.items.add(item);
        }
    }

    // Getters
    public int getOrderId() {
        return orderId;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    /**
     * Checks if the order is empty.
     * @return true if the order contains no items, false otherwise.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public String toString() {
        // Basic string representation of the order
        return "Order #" + orderId + " with " + items.size() + " items: " + items;
    }
}

/**
 * Manages the restaurant's menu and the order queue.
 */
public class RestaurantSystem {
    // Using List interface for the menu
    private List<MenuItem> menu;
    // Using Queue interface for the order queue, implemented by LinkedList
    private Queue<Order> orderQueue;
    private Scanner scanner;

    /**
     * Constructs the RestaurantSystem, initializing the menu and order queue.
     */
    public RestaurantSystem() {
        // Initializing menu using ArrayList
        menu = new ArrayList<>();
        initializeMenu();

        // Initializing order queue using LinkedList
        orderQueue = new LinkedList<>();

        // Initializing scanner for user input
        scanner = new Scanner(System.in);
    }

    /**
     * Populates the menu with some sample items.
     */
    private void initializeMenu() {
        menu.add(new MenuItem(101, "Burger", 8.99));
        menu.add(new MenuItem(102, "Fries", 3.49));
        menu.add(new MenuItem(103, "Soda", 1.99));
        menu.add(new MenuItem(104, "Pizza Slice", 4.50));
        menu.add(new MenuItem(105, "Salad", 7.00));
    }

    /**
     * Displays the current menu to the console.
     */
    private void displayMenu() {
        System.out.println("\n--- Menu ---");
        if (menu.isEmpty()) {
            System.out.println("Menu is currently empty.");
        } else {
            for (MenuItem item : menu) {
                System.out.printf("ID: %d, Name: %s, Price: $%.2f%n",
                        item.getId(), item.getName(), item.getPrice());
            }
        }
        System.out.println("------------");
    }

    /**
     * Finds a MenuItem by its ID.
     * @param id The ID of the item to find.
     * @return The MenuItem object if found, null otherwise.
     */
    private MenuItem findMenuItemById(int id) {
        for (MenuItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null; // Item not found
    }

    /**
     * Handles the process of placing a new order based on user input.
     */
    private void placeNewOrder() {
        System.out.println("\n--- Placing New Order ---");
        Order currentOrder = new Order(); // Create a new empty order

        displayMenu(); // Show menu to help user select items

        while (true) {
            System.out.print("Enter item ID to add (0 to finish): ");
            String input = scanner.nextLine();
            int itemId;

            // Use try-catch for input validation (NumberFormatException)
            try {
                itemId = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // Use System.err for error messages
                System.err.println("Error: Invalid input. Please enter a number.");
                continue; // Ask for input again
            }

            if (itemId == 0) {
                break; // User wants to finish the order
            }

            MenuItem selectedItem = findMenuItemById(itemId);

            if (selectedItem != null) {
                currentOrder.addMenuItem(selectedItem);
                System.out.println("Added: " + selectedItem.getName());
            } else {
                // Use System.err for error messages
                System.err.println("Error: Item with ID " + itemId + " not found.");
            }
        }

        // After finishing item selection
        if (!currentOrder.isEmpty()) {
            orderQueue.offer(currentOrder); // Add the completed order to the queue
            System.out.println("Order #" + currentOrder.getOrderId() + " placed with " +
                               currentOrder.getItems().size() + " item(s).");
        } else {
            System.out.println("No items added. Order not placed.");
        }
    }

    /**
     * Processes (removes) the next order from the queue.
     */
    private void processNextOrder() {
        System.out.println("\n--- Processing Next Order ---");
        // Use poll() which returns null if queue is empty, safer than remove() which throws exception
        Order processedOrder = orderQueue.poll();

        if (processedOrder != null) {
            System.out.println("Processing " + processedOrder); // Order.toString() provides details
        } else {
            // Use System.err for error messages when queue is empty
            System.err.println("Error: No orders in the queue to process.");
        }
    }

    /**
     * Views the current status of the order queue.
     */
    private void viewOrderQueueStatus() {
        System.out.println("\n--- Order Queue Status ---");
        int queueSize = orderQueue.size();
        System.out.println("Order Queue Size: " + queueSize + " order(s) waiting.");

        // Optionally, peek at the next order without removing it
        if (queueSize > 0) {
             Order nextOrder = orderQueue.peek(); // peek() returns null if queue is empty
             if(nextOrder != null) {
                 System.out.println("Next order to be processed: Order #" + nextOrder.getOrderId() + " (" + nextOrder.getItems().size() + " items)");
             }
        }
        System.out.println("--------------------------");
    }

    /**
     * Displays the main system menu to the user.
     */
    private void displayMainMenu() {
        System.out.println("\n--- Restaurant System Menu ---");
        System.out.println("1. Display Menu");
        System.out.println("2. Place New Order");
        System.out.println("3. Process Next Order");
        System.out.println("4. View Order Queue Status");
        System.out.println("5. Exit");
        System.out.println("----------------------------");
    }

    /**
     * Runs the main application loop.
     */
    public void run() {
        int choice = -1; // Initialize with a value that won't match any case
        while (choice != 5) {
            displayMainMenu();
            System.out.print("Enter choice: ");
            String input = scanner.nextLine();

            // Class-wide exception handling for main menu input
            try {
                choice = Integer.parseInt(input);

                // Use switch statement for flow control based on user choice
                switch (choice) {
                    case 1:
                        displayMenu();
                        break;
                    case 2:
                        placeNewOrder();
                        break;
                    case 3:
                        processNextOrder();
                        break;
                    case 4:
                        viewOrderQueueStatus();
                        break;
                    case 5:
                        System.out.println("Exiting system.");
                        break;
                    default:
                        // Use System.err for invalid choices
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
            } catch (NumberFormatException e) {
                // Catch non-integer input for the main menu choice
                System.err.println("Error: Invalid input. Please enter a number.");
                // choice remains -1, loop continues
            } catch (Exception e) {
                 // Catch any other unexpected exceptions during operation
                 System.err.println("An unexpected error occurred: " + e.getMessage());
                 // e.printStackTrace(); // Uncomment for debugging
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the restaurant system.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        RestaurantSystem system = new RestaurantSystem();
        system.run();
    }
}
