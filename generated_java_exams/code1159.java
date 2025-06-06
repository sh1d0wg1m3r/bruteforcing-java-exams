/*
 * Exam Question #1159
 * Generated on: 2025-05-12 17:33:02
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: HelpDesk Support Queue Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified command-line application to manage a customer support queue for a HelpDesk. Customers contact the HelpDesk with issues and are placed into a waiting queue. Support agents process these requests one by one from the front of the queue. Once a customer's issue is resolved, their record is moved to a history log. The system should allow operators to add new customers, resolve the next waiting customer, and view the current waiting queue and the history of resolved issues.
 * 
 * **Requirements:**
 * 
 * 1.  **`Customer` Class:** Create a class named `Customer`.
 *     *   It should have private fields: `id` (int), `name` (String), and `issue` (String).
 *     *   Implement a constructor that accepts name and issue. The `id` should be automatically assigned sequentially, starting from 1, for each new customer created.
 *     *   Include public getter methods for all fields.
 *     *   Override the `toString()` method to provide a readable representation of the customer (e.g., "ID: X, Name: Y, Issue: Z").
 * 
 * 2.  **`HelpDeskQueueManager` Class:** Create a class named `HelpDeskQueueManager` that contains the main application logic.
 *     *   It must use a `java.util.Queue<Customer>` to represent the waiting line of customers. Choose an appropriate implementation (e.g., `LinkedList` or `ArrayDeque`).
 *     *   It must use a `java.util.List<Customer>` (specifically, instantiate it as a `java.util.ArrayList`) to store the history of resolved customers.
 *     *   It must use a `java.util.Scanner` to read user commands from standard input (`System.in`).
 *     *   Implement a method (e.g., `run()`) that contains the main application loop. This loop should continuously read commands until an "EXIT" command is received.
 *     *   Use a `switch` statement within the main loop to process different user commands.
 *     *   Use `System.out` for displaying prompts, successful operation messages, and listing the contents of the queue and history.
 *     *   Use `System.err` for displaying error messages (e.g., invalid command format, attempting to resolve an empty queue).
 *     *   Implement **class-wide exception handling** using a `try-catch` block that wraps the main command processing loop within the `run()` method. This block should catch general `Exception` or more specific exceptions if appropriate for potential runtime issues not covered by specific error checks (like input format errors). Print an error message to `System.err` if an exception occurs.
 *     *   Ensure the `Scanner` resource is properly closed when the application exits.
 * 
 * 3.  **Commands:** The system should recognize and process the following commands entered by the user (commands should be case-insensitive):
 *     *   `ADD <name> <issue description>`: Creates a new `Customer` object with the given name and issue, assigns the next available ID, and adds it to the *end* of the waiting queue. The issue description can contain spaces.
 *     *   `RESOLVE`: Removes the customer from the *front* of the waiting queue. If successful, this customer object is then added to the *end* of the resolved history list. If the queue is empty, print an error message to `System.err`.
 *     *   `LIST_QUEUE`: Prints the details of all customers currently in the waiting queue, in their current order. If the queue is empty, print "Queue is empty."
 *     *   `LIST_HISTORY`: Prints the details of all customers in the resolved history list, in the order they were resolved. If the history is empty, print "History is empty."
 *     *   `EXIT`: Prints an exit message and terminates the application.
 * 
 * 4.  **Input Validation & Error Handling:**
 *     *   Validate the input for the `ADD` command to ensure both name and issue description are provided. Use `System.err` for validation errors.
 *     *   Handle the case where `RESOLVE` is called on an empty queue using `System.err`.
 *     *   The `try-catch` block should handle unexpected runtime errors during the main loop.
 * 
 * 5.  **Best Practices:**
 *     *   Adhere to encapsulation principles (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include comments or Javadoc where appropriate to explain complex parts.
 *     *   Structure the code logically.
 * 
 * **Expected Output Example:**
 * 
 * ```
 * HelpDesk Queue Manager Started.
 * Commands: ADD <name> <issue>, RESOLVE, LIST_QUEUE, LIST_HISTORY, EXIT
 * > ADD Alice Printer not working
 * Added customer to queue: ID: 1, Name: Alice, Issue: Printer not working
 * > ADD Bob Cannot connect to network
 * Added customer to queue: ID: 2, Name: Bob, Issue: Cannot connect to network
 * > LIST_QUEUE
 * --- Current Queue ---
 * 1. ID: 1, Name: Alice, Issue: Printer not working
 * 2. ID: 2, Name: Bob, Issue: Cannot connect to network
 * ---------------------
 * > RESOLVE
 * Resolved customer from queue: ID: 1, Name: Alice, Issue: Printer not working
 * > LIST_QUEUE
 * --- Current Queue ---
 * 1. ID: 2, Name: Bob, Issue: Cannot connect to network
 * ---------------------
 * > LIST_HISTORY
 * --- Resolved History ---
 * 1. ID: 1, Name: Alice, Issue: Printer not working
 * ----------------------
 * > RESOLVE
 * Resolved customer from queue: ID: 2, Name: Bob, Issue: Cannot connect to network
 * > RESOLVE
 * Error: No customers in the queue to resolve.
 * > LIST_QUEUE
 * --- Current Queue ---
 * Queue is empty.
 * ---------------------
 * > LIST_HISTORY
 * --- Resolved History ---
 * 1. ID: 1, Name: Alice, Issue: Printer not working
 * 2. ID: 2, Name: Bob, Issue: Cannot connect to network
 * ----------------------
 * > ADD Charlie Software installation failed
 * Added customer to queue: ID: 3, Name: Charlie, Issue: Software installation failed
 * > LIST_QUEUE
 * --- Current Queue ---
 * 1. ID: 3, Name: Charlie, Issue: Software installation failed
 * ---------------------
 * > UNKNOWN_COMMAND
 * Error: Unknown command. Type ADD, RESOLVE, LIST_QUEUE, LIST_HISTORY, or EXIT.
 * > EXIT
 * Exiting HelpDesk Queue Manager.
 * ```
 * 
 * **Instructions:**
 * 
 * Write the complete Java code for the `Customer` and `HelpDeskQueueManager` classes in a single file. Ensure it compiles and runs as described.
 *
 * EXPLANATION:
 * This solution implements a basic HelpDesk queue management system as described in the problem statement, incorporating all the required Java components and best practices.
 * 
 * 1.  **`Customer` Class:** This is a simple Plain Old Java Object (POJO) representing a customer request. It encapsulates the customer's unique `id`, `name`, and `issue`. The `toString()` method provides a convenient way to display customer information. The ID is managed sequentially by the `HelpDeskQueueManager` upon creation.
 * 
 * 2.  **`HelpDeskQueueManager` Class:** This class holds the core logic and state of the application.
 *     *   **`Queue<Customer> waitingQueue`**: A `LinkedList` is used here as it efficiently supports the `Queue` operations required: adding elements to the tail (`offer()`) and removing elements from the head (`poll()`). This models the FIFO (First-In, First-Out) nature of a waiting queue.
 *     *   **`List<Customer> resolvedHistory`**: An `ArrayList` is used as required. This list stores customers after they have been processed. `ArrayList` is suitable for storing a dynamic collection where elements are added sequentially (`add()`) and potentially iterated over.
 *     *   **`Scanner scanner`**: Used to read user input from the console line by line.
 *     *   **`nextCustomerId`**: A simple integer counter to ensure each new customer gets a unique, sequential ID.
 *     *   **`run()` Method**: This method contains the main application loop (`while(true)`). It prompts the user for input, reads the line, parses the command, and uses a `switch` statement to delegate processing to appropriate handler methods.
 *     *   **`try-catch` Block**: A `try-catch(Exception e)` block is placed around the entire `while` loop in `run()`. This provides the required class-wide exception handling, catching any unexpected runtime errors that might occur during the processing of commands and printing a general error message to `System.err`.
 *     *   **`switch` Statement**: The `switch` statement processes the uppercase version of the user's command, directing the flow to the relevant handler method (`handleAddCommand`, `handleResolveCommand`, etc.). A `default` case handles unknown commands.
 *     *   **`System.out` and `System.err`**: `System.out` is used for normal program output, prompts, successful messages, and listing data. `System.err` is strictly used for displaying error conditions, such as invalid input format or attempting an operation on an empty collection.
 *     *   **Handler Methods (`handleAddCommand`, `handleResolveCommand`, `handleListQueueCommand`, `handleListHistoryCommand`)**: These private methods encapsulate the logic for each specific command, improving code organization and readability.
 *         *   `handleAddCommand` uses `split(" ", 2)` to correctly separate the command (`ADD`), the name, and the rest of the line as the issue, even if the issue contains spaces. It includes input validation to check if both name and issue parts are present. `waitingQueue.offer()` adds the new customer.
 *         *   `handleResolveCommand` uses `waitingQueue.poll()` to remove the head of the queue. It checks if the result is `null` to handle the empty queue case, printing an error to `System.err`. If successful, the customer is added to `resolvedHistory.add()`.
 *         *   `handleListQueueCommand` and `handleListHistoryCommand` iterate through the respective collections and print their contents. They check if the collections are empty before iterating.
 *     *   **Resource Management**: The `scanner.close()` call is placed in a `finally` block to ensure the `Scanner` resource is released when the `try` block (and thus the main loop) is exited, either normally or due to an exception.
 *     *   **`main` Method**: This is the entry point of the application. It creates an instance of `HelpDeskQueueManager` and calls its `run()` method.
 * 
 * This solution effectively demonstrates the use of `Queue`, `List` (`ArrayList`), `Scanner`, `switch`, `System.out`, `System.err`, and `try-catch` in a practical scenario, while adhering to object-oriented principles and error handling best practices.
 */

import java.util.Queue;
import java.util.LinkedList; // A common Queue implementation
import java.util.List;
import java.util.ArrayList; // Required implementation for history
import java.util.Scanner;
import java.util.Arrays; // Useful for splitting input

/**
 * Represents a customer with a support issue.
 */
class Customer {
    private int id;
    private String name;
    private String issue;

    /**
     * Constructs a new Customer.
     * ID is assigned by the HelpDeskQueueManager.
     * @param id The unique ID for the customer.
     * @param name The name of the customer.
     * @param issue The description of the customer's issue.
     */
    public Customer(int id, String name, String issue) {
        this.id = id;
        this.name = name;
        this.issue = issue;
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIssue() {
        return issue;
    }

    /**
     * Provides a string representation of the Customer.
     * @return A formatted string including ID, Name, and Issue.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Issue: " + issue;
    }
}

/**
 * Manages the HelpDesk support queue and resolved customer history.
 */
public class HelpDeskQueueManager {

    // --- Fields ---
    private Queue<Customer> waitingQueue; // Queue for customers awaiting support
    private List<Customer> resolvedHistory; // List for customers whose issues are resolved
    private Scanner scanner; // Scanner for reading user input
    private int nextCustomerId; // Counter for assigning unique customer IDs

    /**
     * Constructs a new HelpDeskQueueManager.
     * Initializes the queue, history list, scanner, and customer ID counter.
     */
    public HelpDeskQueueManager() {
        waitingQueue = new LinkedList<>(); // Using LinkedList as a Queue implementation
        resolvedHistory = new ArrayList<>(); // Required to use ArrayList for history
        scanner = new Scanner(System.in);
        nextCustomerId = 1; // Start customer IDs from 1
    }

    /**
     * Runs the main application loop, processing user commands.
     * Includes class-wide exception handling for the loop.
     */
    public void run() {
        System.out.println("HelpDesk Queue Manager Started.");
        System.out.println("Commands: ADD <name> <issue>, RESOLVE, LIST_QUEUE, LIST_HISTORY, EXIT");

        // --- Class-wide exception handling for the main operational loop ---
        try {
            while (true) {
                System.out.print("> ");
                String inputLine = scanner.nextLine().trim(); // Read entire line and trim whitespace

                if (inputLine.isEmpty()) {
                    continue; // Skip empty lines
                }

                // Split input into command and arguments (split only on the first space)
                String[] parts = inputLine.split(" ", 2);
                String command = parts[0].toUpperCase(); // Get command and convert to uppercase
                String args = parts.length > 1 ? parts[1] : ""; // Get arguments string

                // --- Process commands using a switch statement ---
                switch (command) {
                    case "ADD":
                        handleAddCommand(args);
                        break;
                    case "RESOLVE":
                        handleResolveCommand();
                        break;
                    case "LIST_QUEUE":
                        handleListQueueCommand();
                        break;
                    case "LIST_HISTORY":
                        handleListHistoryCommand();
                        break;
                    case "EXIT":
                        System.out.println("Exiting HelpDesk Queue Manager.");
                        return; // Exit the run method to terminate the program
                    default:
                        // Handle unknown commands
                        System.err.println("Error: Unknown command. Type ADD, RESOLVE, LIST_QUEUE, LIST_HISTORY, or EXIT.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions during the loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // Optional: e.printStackTrace(); for detailed debugging
        } finally {
             // Ensure the scanner resource is closed
             if (scanner != null) {
                 scanner.close();
             }
        }
    }

    /**
     * Handles the ADD command.
     * Parses arguments, creates a Customer, and adds it to the queue.
     * @param args The argument string following the ADD command.
     */
    private void handleAddCommand(String args) {
        // Split arguments into name and issue description (split only on the first space in args)
        String[] parts = args.split(" ", 2);
        if (parts.length < 2) {
            // Input validation: check if both name and issue are provided
            System.err.println("Error: ADD command requires a name and an issue. Usage: ADD <name> <issue>");
            return;
        }
        String name = parts[0];
        String issue = parts[1];

        // Create a new customer with the next available ID
        Customer newCustomer = new Customer(nextCustomerId++, name, issue);
        // Add the new customer to the end of the waiting queue
        waitingQueue.offer(newCustomer); // offer() is generally preferred for queues

        System.out.println("Added customer to queue: " + newCustomer);
    }

    /**
     * Handles the RESOLVE command.
     * Removes the next customer from the queue and adds them to history.
     */
    private void handleResolveCommand() {
        // Remove the customer from the front of the waiting queue
        Customer resolvedCustomer = waitingQueue.poll(); // poll() returns null if queue is empty

        if (resolvedCustomer != null) {
            // Add the resolved customer to the end of the history list
            resolvedHistory.add(resolvedCustomer);
            System.out.println("Resolved customer from queue: " + resolvedCustomer);
        } else {
            // Error handling for empty queue
            System.err.println("Error: No customers in the queue to resolve.");
        }
    }

    /**
     * Handles the LIST_QUEUE command.
     * Prints the details of all customers currently in the waiting queue.
     */
    private void handleListQueueCommand() {
        System.out.println("--- Current Queue ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate through the queue and print each customer
            // Iteration order for Queue is typically FIFO (insertion order)
            int i = 1;
            for (Customer customer : waitingQueue) {
                System.out.println(i++ + ". " + customer);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Handles the LIST_HISTORY command.
     * Prints the details of all customers in the resolved history list.
     */
    private void handleListHistoryCommand() {
        System.out.println("--- Resolved History ---");
        if (resolvedHistory.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            // Iterate through the history list and print each customer
            // ArrayList iteration order is insertion order
            int i = 1;
            for (Customer customer : resolvedHistory) {
                System.out.println(i++ + ". " + customer);
            }
        }
        System.out.println("----------------------");
    }

    /**
     * Main method to start the HelpDesk Queue Manager application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HelpDeskQueueManager manager = new HelpDeskQueueManager();
        manager.run(); // Start the application loop
    }
}
