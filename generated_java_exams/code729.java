/*
 * Exam Question #729
 * Generated on: 2025-05-12 16:32:09
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Customer Service Queue Simulation
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application to simulate a customer service desk queue. Customers arrive and join a waiting line. Service agents process customers one by one from the front of the line. The system needs to keep track of customers currently waiting and those who have been served.
 * 
 * **Task:**
 * 
 * Implement a Java program that simulates this customer service queue system. The program should be menu-driven, allowing an operator to perform the following actions:
 * 
 * 1.  **Add Customer:** Add a new customer (identified by name) to the end of the waiting queue.
 * 2.  **Serve Next Customer:** Remove the customer from the front of the waiting queue and add them to a list of served customers.
 * 3.  **View Waiting Queue:** Display the names of all customers currently in the waiting queue, in order.
 * 4.  **View Served Customers:** Display the names of all customers who have been served.
 * 5.  **Exit:** Terminate the program.
 * 
 * **Requirements:**
 * 
 * Your solution must adhere to the following requirements:
 * 
 * *   Use the `java.util.Queue` interface and a concrete implementation (e.g., `LinkedList`) for the waiting queue.
 * *   Use the `java.util.List` interface and a concrete implementation (e.g., `ArrayList`) for the list of served customers.
 * *   Use `java.util.Scanner` to read user input for menu choices and customer names.
 * *   Use a `switch` statement to handle the different menu options.
 * *   Use `System.err` to display error messages (e.g., trying to serve from an empty queue, invalid input).
 * *   Use `System.out` for displaying the menu, prompts, success messages, and list contents.
 * *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors, particularly related to user input (e.g., entering non-numeric input for menu choices).
 * *   Employ best practices:
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (briefly explaining methods and key logic).
 *     *   Basic input validation (e.g., ensuring customer name is not empty).
 *     *   Clear and informative output.
 * 
 * **Expected Output:**
 * 
 * The program should present a menu to the user, prompt for input, and display results or errors based on the chosen action. Example interactions:
 * 
 * ```
 * --- Customer Service Queue System ---
 * 
 * Select an option:
 * 1. Add Customer to Queue
 * 2. Serve Next Customer
 * 3. View Waiting Queue
 * 4. View Served Customers
 * 5. Exit
 * Enter choice: 1
 * Enter customer name: Alice
 * Alice added to the waiting queue.
 * 
 * Select an option:
 * ... (menu repeats)
 * Enter choice: 1
 * Enter customer name: Bob
 * Bob added to the waiting queue.
 * 
 * Select an option:
 * ...
 * Enter choice: 3
 * 
 * --- Waiting Queue ---
 * 1. Alice
 * 2. Bob
 * ---------------------
 * 
 * Select an option:
 * ...
 * Enter choice: 2
 * Served customer: Alice
 * 
 * Select an option:
 * ...
 * Enter choice: 3
 * 
 * --- Waiting Queue ---
 * 1. Bob
 * ---------------------
 * 
 * Select an option:
 * ...
 * Enter choice: 4
 * 
 * --- Served Customers ---
 * 1. Alice
 * ----------------------
 * 
 * Select an option:
 * ...
 * Enter choice: 2
 * Served customer: Bob
 * 
 * Select an option:
 * ...
 * Enter choice: 4
 * 
 * --- Served Customers ---
 * 1. Alice
 * 2. Bob
 * ----------------------
 * 
 * Select an option:
 * ...
 * Enter choice: 2
 * Error: The waiting queue is empty. No customers to serve. (This should be printed to System.err)
 * 
 * Select an option:
 * ...
 * Enter choice: 9
 * Invalid choice. Please enter a number between 1 and 5. (This should be printed to System.err)
 * 
 * Select an option:
 * ...
 * Enter choice: abc
 * Invalid input. Please enter a number. (This should be printed to System.err)
 * 
 * Select an option:
 * ...
 * Enter choice: 5
 * Exiting system. Goodbye!
 * ```
 * 
 * You should implement the `CustomerServiceSystem` class and its `main` method to achieve this functionality.
 *
 * EXPLANATION:
 * This solution implements the `CustomerServiceSystem` class to manage a waiting queue and a list of served customers, fulfilling all the requirements of the exam task.
 * 
 * 1.  **Data Structures (`Queue`, `List`, `ArrayList`):**
 *     *   `waitingQueue` is declared as `Queue<String>` and initialized with a `LinkedList`. The `Queue` interface is used because we need FIFO (First-In, First-Out) behavior: customers are added to the end (`offer`) and removed from the front (`poll`). `LinkedList` is a common implementation that efficiently supports these operations.
 *     *   `servedCustomers` is declared as `List<String>` and initialized with an `ArrayList`. The `List` interface is suitable for storing a collection of served customers where the order of serving is maintained, and we might want to iterate or access them later. `ArrayList` provides dynamic resizing and efficient element access.
 * 
 * 2.  **User Input (`Scanner`):**
 *     *   A `Scanner` object is created in the `main` method to read input from `System.in`. It's used to read the user's menu choice (an integer) and the customer's name (a string). The `scanner.nextLine()` call after `scanner.nextInt()` is crucial to consume the leftover newline character, preventing issues in subsequent `nextLine()` calls.
 * 
 * 3.  **Control Flow (`switch`):**
 *     *   A `switch` statement in the `main` method is used to direct the program's flow based on the integer menu choice provided by the user. Each `case` corresponds to a specific action (Add, Serve, View Waiting, View Served, Exit), calling the appropriate method of the `CustomerServiceSystem` instance.
 * 
 * 4.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` is used for all standard output, including displaying the menu, prompts, success messages, and the contents of the queues/lists.
 *     *   `System.err.println()` is specifically used for displaying error messages, such as when the waiting queue is empty during a serve attempt, when the user enters an invalid menu option number, or when the input type is incorrect. This separates error output from normal program output.
 * 
 * 5.  **Exception Handling (`try-catch`):**
 *     *   The main `while` loop in the `main` method, which handles reading user input and processing commands, is wrapped in a `try-catch` block.
 *     *   A specific `catch (InputMismatchException e)` block is included to handle the scenario where the user enters text or non-integer input when an integer (the menu choice) is expected by `scanner.nextInt()`. This prevents the program from crashing and allows it to print an informative error message using `System.err` and recover by consuming the invalid input.
 *     *   A general `catch (Exception e)` block is included as a form of "class-wide" handling within the main execution loop, catching any other unexpected runtime errors that might occur during the processing of a command. This makes the program more robust against unforeseen issues.
 * 
 * 6.  **Best Practices:**
 *     *   **Encapsulation:** The `waitingQueue` and `servedCustomers` are declared as `private` fields within the `CustomerServiceSystem` class, preventing direct external access. Public methods (`addCustomer`, `serveNextCustomer`, etc.) provide controlled access and manipulation of these data structures.
 *     *   **Meaningful Names:** Variables (`waitingQueue`, `servedCustomers`, `choice`, `name`, `running`), methods (`addCustomer`, `serveNextCustomer`, `viewWaitingQueue`, `viewServedCustomers`), and the class name (`CustomerServiceSystem`) are clearly named, reflecting their purpose.
 *     *   **Comments:** Basic comments explain the purpose of the class, fields, constructor, and methods, enhancing code readability.
 *     *   **Input Validation:** The `addCustomer` method includes a check to ensure the customer name is not `null` or empty after trimming whitespace. The `serveNextCustomer` method checks if the queue is empty before attempting to poll. The `switch` statement has a `default` case for invalid numeric choices.
 *     *   **Error Handling:** Specific error messages are printed to `System.err` for different failure conditions (empty queue, invalid input type, invalid menu number). The `try-catch` blocks prevent crashes due to input errors.
 *     *   **Clean Structure:** The code is organized into a class with dedicated methods for each operation, making the `main` method clean and focused on the application loop and input handling. The `Scanner` is closed at the end.
 * 
 * This solution effectively demonstrates the required Java concepts in a practical, interactive application, incorporating essential programming practices like encapsulation, validation, and error handling.
 */

import java.util.Queue;
import java.util.LinkedList; // A common implementation for Queue
import java.util.List;
import java.util.ArrayList; // A common implementation for List
import java.util.Scanner;
import java.util.InputMismatchException; // Specific exception for Scanner type mismatches

/**
 * A simple system to simulate a customer service queue.
 * Manages waiting customers in a queue and tracks served customers in a list.
 */
public class CustomerServiceSystem {

    // Queue to hold customers waiting for service (FIFO - First-In, First-Out)
    private Queue<String> waitingQueue;

    // List to hold customers who have been served
    private List<String> servedCustomers;

    /**
     * Constructor initializes the waiting queue and served customers list.
     */
    public CustomerServiceSystem() {
        // Using LinkedList as a Queue implementation
        waitingQueue = new LinkedList<>();
        // Using ArrayList as a List implementation
        servedCustomers = new ArrayList<>();
    }

    /**
     * Adds a new customer to the end of the waiting queue.
     * Performs basic validation to ensure the name is not empty.
     * @param name The name of the customer to add.
     */
    public void addCustomer(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.err.println("Error: Customer name cannot be empty.");
            return;
        }
        String trimmedName = name.trim();
        waitingQueue.offer(trimmedName); // offer() is the preferred way to add to a Queue
        System.out.println(trimmedName + " added to the waiting queue.");
    }

    /**
     * Serves the next customer from the front of the waiting queue.
     * The served customer is moved to the list of served customers.
     * Handles the case where the waiting queue is empty.
     */
    public void serveNextCustomer() {
        if (waitingQueue.isEmpty()) {
            System.err.println("Error: The waiting queue is empty. No customers to serve.");
            return;
        }
        // poll() retrieves and removes the head of the queue, returns null if empty (handled by the if check)
        String customer = waitingQueue.poll();
        servedCustomers.add(customer);
        System.out.println("Served customer: " + customer);
    }

    /**
     * Displays the names of all customers currently in the waiting queue.
     */
    public void viewWaitingQueue() {
        System.out.println("\n--- Waiting Queue ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            int i = 1;
            for (String customer : waitingQueue) {
                System.out.println(i++ + ". " + customer);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Displays the names of all customers who have been served.
     */
    public void viewServedCustomers() {
        System.out.println("\n--- Served Customers ---");
        if (servedCustomers.isEmpty()) {
            System.out.println("No customers have been served yet.");
        } else {
            // Iterate through the list
            int i = 1;
            for (String customer : servedCustomers) {
                System.out.println(i++ + ". " + customer);
            }
        }
        System.out.println("----------------------");
    }

    /**
     * Main method to run the Customer Service Queue System.
     * Provides a menu-driven interface for the operator.
     * Includes exception handling for robust input processing.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Scanner for reading user input from the console
        Scanner scanner = new Scanner(System.in);
        // Create an instance of the system
        CustomerServiceSystem system = new CustomerServiceSystem();
        boolean running = true; // Control the main application loop

        System.out.println("--- Customer Service Queue System ---");

        // Main application loop
        while (running) {
            // Display the menu options
            System.out.println("\nSelect an option:");
            System.out.println("1. Add Customer to Queue");
            System.out.println("2. Serve Next Customer");
            System.out.println("3. View Waiting Queue");
            System.out.println("4. View Served Customers");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            // Use try-catch for class-wide exception handling, specifically for input
            try {
                // Read the integer choice from the user
                int choice = scanner.nextInt();
                // Consume the leftover newline character after reading the integer
                scanner.nextLine();

                // Use a switch statement to handle different menu options
                switch (choice) {
                    case 1:
                        System.out.print("Enter customer name: ");
                        String name = scanner.nextLine();
                        system.addCustomer(name); // Call method to add customer
                        break;
                    case 2:
                        system.serveNextCustomer(); // Call method to serve customer
                        break;
                    case 3:
                        system.viewWaitingQueue(); // Call method to view queue
                        break;
                    case 4:
                        system.viewServedCustomers(); // Call method to view served list
                        break;
                    case 5:
                        System.out.println("Exiting system. Goodbye!");
                        running = false; // Set running to false to exit the loop
                        break;
                    default:
                        // Handle invalid integer choices
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handle cases where the user enters non-integer input for the choice
                System.err.println("Invalid input. Please enter a number.");
                // Consume the invalid input to prevent an infinite loop
                scanner.nextLine();
            } catch (Exception e) {
                // Catch any other unexpected runtime exceptions during the loop iteration
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // In a real application, you might log the exception: e.printStackTrace();
            }
        }

        // Close the scanner resource when the program exits
        scanner.close();
    }
}
