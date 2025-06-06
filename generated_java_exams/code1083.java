/*
 * Exam Question #1083
 * Generated on: 2025-05-12 17:22:36
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Support Ticket Management System
 * 
 * **Objective:** Implement a simple console-based Support Ticket Management System that allows users to add new tickets, process pending tickets, and view the status of tickets. This task requires you to demonstrate proficiency in using fundamental Java collections, user input handling, control flow, and exception management.
 * 
 * **Scenario:** You are building a backend system for a small support team. Incoming support requests (tickets) are added to a queue for agents to pick up. Once a ticket is processed, it is moved to a list of completed tickets.
 * 
 * **Requirements:**
 * 
 * 1.  **SupportTicket Class:** Create a simple class `SupportTicket` with private fields for `id` (int) and `description` (String). Include a constructor and public getter methods for these fields. Override the `toString()` method to provide a user-friendly representation of a ticket (e.g., "Ticket [ID=X, Description='...']").
 * 2.  **SupportSystem Class:** Create a class `SupportSystem` that manages the tickets.
 *     *   It must have a private field `pendingTickets` of type `java.util.Queue<SupportTicket>` to store tickets awaiting processing. Use `java.util.LinkedList` as the concrete implementation.
 *     *   It must have a private field `completedTickets` of type `java.util.List<SupportTicket>` to store tickets that have been processed. Use `java.util.ArrayList` as the concrete implementation.
 *     *   Include a private field `nextTicketId` (int) to generate unique ticket IDs starting from 1.
 *     *   Implement the following public methods:
 *         *   `addTicket(String description)`: Creates a new `SupportTicket` with the next available ID and the provided description, and adds it to the `pendingTickets` queue. Validate that the description is not empty or null; if invalid, print an error to `System.err` and do not add the ticket. Print a success message to `System.out` if added.
 *         *   `processNextTicket()`: Removes the ticket at the front of the `pendingTickets` queue and adds it to the `completedTickets` list. Print a message to `System.out` indicating which ticket is being processed and another when it's marked as completed. If the queue is empty, print a message to `System.out` indicating that there are no tickets to process.
 *         *   `viewPendingTickets()`: Displays all tickets currently in the `pendingTickets` queue. Print a header and then each ticket's details using its `toString()` method. If the queue is empty, print a message to `System.out` indicating so.
 *         *   `viewCompletedTickets()`: Displays all tickets in the `completedTickets` list. Print a header and then each ticket's details. If the list is empty, print a message to `System.out` indicating so.
 * 3.  **Main Class (containing `main` method):**
 *     *   Instantiate the `SupportSystem` and a `java.util.Scanner` for user input.
 *     *   Implement a menu-driven interface using a loop that continues until the user chooses to exit.
 *     *   Use a `switch` statement to handle the user's menu choice (Add Ticket, Process Ticket, View Pending, View Completed, Exit).
 *     *   Prompt the user for input using `System.out`.
 *     *   Handle potential `InputMismatchException` when reading the menu choice; if caught, print an error to `System.err` and prompt again.
 *     *   Implement **class-wide exception handling** by wrapping the main application loop (the `while` loop) in a `try-catch` block to catch any unexpected `Exception` and print an error message to `System.err`. Ensure the `Scanner` is closed in a `finally` block.
 * 4.  **General Requirements:**
 *     *   Use `System.out` for all normal program output (menus, prompts, success messages, ticket lists).
 *     *   Use `System.err` for all error messages (invalid input, empty description, unexpected errors).
 *     *   Employ proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for methods).
 *     *   Ensure robust input validation and error handling as specified.
 * 
 * **Menu Options:**
 * 
 * 1.  Add New Ticket
 * 2.  Process Next Ticket
 * 3.  View Pending Tickets
 * 4.  View Completed Tickets
 * 5.  Exit
 * 
 * **Expected Output:** The program should display the menu, accept user input, and perform the requested actions, printing relevant messages and ticket details to the console using `System.out` and error messages to `System.err`.
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * --- Support Ticket System Menu ---
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Pending Tickets
 * 4. View Completed Tickets
 * 5. Exit
 * Enter your choice: 1
 * Enter ticket description: Printer not working
 * Ticket added: Ticket [ID=1, Description='Printer not working']
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 1
 * Enter ticket description: Email configuration issue
 * Ticket added: Ticket [ID=2, Description='Email configuration issue']
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tickets ---
 * Ticket [ID=1, Description='Printer not working']
 * Ticket [ID=2, Description='Email configuration issue']
 * -----------------------
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * Processing ticket: Ticket [ID=1, Description='Printer not working']
 * Ticket 1 marked as completed.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tickets ---
 * Ticket [ID=2, Description='Email configuration issue']
 * -----------------------
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 4
 * --- Completed Tickets ---
 * Ticket [ID=1, Description='Printer not working']
 * -------------------------
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Support Ticket System. Goodbye!
 * Scanner closed.
 * ```
 * 
 * ```
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 1
 * Enter ticket description:
 * Error: Ticket description cannot be empty.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * No pending tickets to process.
 * ```
 * 
 * You must provide the complete, runnable Java code for this system.
 *
 * EXPLANATION:
 * The provided solution implements a basic Support Ticket Management System as described in the exam question, demonstrating the required Java concepts and best practices.
 * 
 * **Key Concepts Demonstrated:**
 * 
 * 1.  **`java.util.Queue`:** The `pendingTickets` field in `SupportSystem` is declared as a `Queue`. This correctly models the "waiting line" behavior where tickets are processed in the order they are received (First-In, First-Out). `LinkedList` is used as the concrete implementation, which is a common choice for queues. The `offer()` method is used for adding elements, and `poll()` is used for removing and retrieving the head of the queue, which gracefully handles an empty queue by returning `null`.
 * 2.  **`java.util.ArrayList`:** The `completedTickets` field is implemented using `ArrayList`. `ArrayList` is suitable here because completed tickets are simply stored and iterated over; there's no specific requirement for fast insertions/deletions from the middle or FIFO/LIFO access patterns once they are completed. An `ArrayList` is also used temporarily in `viewPendingTickets()` to create a snapshot of the queue for iteration without modifying the queue itself.
 * 3.  **`java.util.List`:** The `completedTickets` field is declared using the `List` interface type (`List<SupportTicket> completedTickets`). This is a best practice as it promotes flexibility; the underlying implementation could be changed (e.g., to `LinkedList` or `Vector`) without affecting the code that uses the `completedTickets` list, as long as only `List` interface methods are called.
 * 4.  **`java.util.Scanner`:** Used in the `main` method to read user input from `System.in`. It's used to read both integer choices (`nextInt()`) and string descriptions (`nextLine()`). Proper handling of the newline character left by `nextInt()` is included (`scanner.nextLine();` after reading the integer). The `Scanner` is closed in the `finally` block to release the system resource.
 * 5.  **`switch` statement:** Used in the `main` method to control the flow of the program based on the user's menu choice, directing execution to the appropriate `SupportSystem` method or the exit logic.
 * 6.  **`System.err`:** Used specifically for printing error messages, such as invalid menu input (`InputMismatchException`), invalid ticket descriptions (empty/null), and unexpected runtime errors caught by the main `try-catch` block. This separates error output from normal program output (`System.out`).
 * 7.  **`System.out`:** Used for all standard program output, including displaying the menu, prompting the user for input, printing success messages for adding/processing tickets, and listing the details of pending and completed tickets.
 * 8.  **Class-wide exception handling with `try-catch`:** The main `while` loop in the `main` method is wrapped in a `try-catch(Exception e)` block. This provides a top-level handler for any unexpected runtime errors that might occur during the execution of the application logic, preventing the program from crashing abruptly and printing an informative error message to `System.err`. A specific `try-catch(InputMismatchException)` is also used within the loop to handle non-integer input for the menu choice, allowing the program to recover from this specific common input error. The `finally` block ensures the `Scanner` is closed.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** The `SupportTicket` class fields (`id`, `description`) and `SupportSystem` fields (`pendingTickets`, `completedTickets`, `nextTicketId`) are declared as `private`. Access is provided through public methods (`getId`, `getDescription`, `addTicket`, `processNextTicket`, etc.), controlling how the internal state is modified or accessed.
 * *   **Meaningful Names:** Class names (`SupportTicket`, `SupportSystem`, `SupportTicketSystem`), variable names (`pendingTickets`, `completedTickets`, `nextTicketId`, `description`, `choice`), and method names (`addTicket`, `processNextTicket`, `viewPendingTickets`, `viewCompletedTickets`) are descriptive and clearly indicate their purpose.
 * *   **Comments and Documentation:** Javadoc comments are used for classes and public methods, explaining their purpose, parameters, and return values. Inline comments are used for specific logic points (e.g., consuming newline, handling empty queue).
 * *   **Input Validation:** The `addTicket` method explicitly checks if the provided description is null or empty after trimming whitespace, using `System.err` for feedback. The `main` method handles `InputMismatchException` for menu input validation.
 * *   **Proper Error Handling:** Specific errors like invalid input are handled with targeted `catch` blocks and informative messages to `System.err`. General unexpected errors are caught by the outer `try-catch`. Empty collections are checked before attempting operations (`poll`, iteration) to prevent errors and provide user-friendly messages.
 * *   **Clean Code Structure:** The code is organized into logical classes (`SupportTicket` for data, `SupportSystem` for business logic, `SupportTicketSystem` for application entry point and UI interaction). Methods are focused on single responsibilities.
 * 
 * This solution effectively integrates the required components into a functional and well-structured program that simulates a practical scenario, meeting the complexity and best practice requirements of the exam task.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single support ticket with an ID and description.
 */
class SupportTicket {
    private int id;
    private String description;

    /**
     * Constructs a new SupportTicket.
     * @param id The unique ID of the ticket.
     * @param description The description of the issue.
     */
    public SupportTicket(int id, String description) {
        this.id = id;
        this.description = description;
    }

    /**
     * Gets the ticket ID.
     * @return The ticket ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the ticket description.
     * @return The ticket description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Provides a string representation of the ticket.
     * @return A formatted string for the ticket.
     */
    @Override
    public String toString() {
        return "Ticket [ID=" + id + ", Description='" + description + "']";
    }
}

/**
 * Manages the collection of support tickets, including pending and completed queues/lists.
 */
class SupportSystem {
    // Queue to hold tickets waiting to be processed (FIFO)
    private Queue<SupportTicket> pendingTickets;
    // List to hold tickets that have been processed
    private List<SupportTicket> completedTickets; // Using List interface type
    // Counter for generating unique ticket IDs
    private int nextTicketId;

    /**
     * Constructs a new SupportSystem, initializing the ticket collections.
     */
    public SupportSystem() {
        // Use LinkedList as a concrete implementation for Queue
        this.pendingTickets = new LinkedList<>();
        // Use ArrayList as a concrete implementation for List
        this.completedTickets = new ArrayList<>();
        this.nextTicketId = 1;
    }

    /**
     * Adds a new support ticket to the pending queue.
     * Validates the description before adding.
     * @param description The description of the ticket.
     * @return true if the ticket was successfully added, false otherwise.
     */
    public boolean addTicket(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Ticket description cannot be empty.");
            return false;
        }
        // Trim whitespace from description
        String cleanedDescription = description.trim();
        SupportTicket newTicket = new SupportTicket(nextTicketId++, cleanedDescription);
        // offer() is generally preferred over add() for queues as it handles capacity-constrained queues gracefully
        pendingTickets.offer(newTicket);
        System.out.println("Ticket added: " + newTicket);
        return true;
    }

    /**
     * Processes the next ticket in the pending queue.
     * Removes it from the queue and adds it to the completed list.
     */
    public void processNextTicket() {
        // poll() retrieves and removes the head of the queue, returning null if empty
        SupportTicket ticketToProcess = pendingTickets.poll();
        if (ticketToProcess == null) {
            System.out.println("No pending tickets to process.");
        } else {
            System.out.println("Processing ticket: " + ticketToProcess);
            completedTickets.add(ticketToProcess); // Add to the end of the completed list
            System.out.println("Ticket " + ticketToProcess.getId() + " marked as completed.");
        }
    }

    /**
     * Displays all tickets currently in the pending queue.
     * Iterates through the queue without removing elements.
     */
    public void viewPendingTickets() {
        if (pendingTickets.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("--- Pending Tickets ---");
            // To display without removing, we can iterate or convert to a List
            // Converting to List is simple for display purposes
            List<SupportTicket> pendingListForView = new ArrayList<>(pendingTickets); // Create ArrayList from Queue
            for (SupportTicket ticket : pendingListForView) {
                System.out.println(ticket);
            }
            System.out.println("-----------------------");
        }
    }

    /**
     * Displays all tickets in the completed list.
     */
    public void viewCompletedTickets() {
        if (completedTickets.isEmpty()) {
            System.out.println("No completed tickets.");
        } else {
            System.out.println("--- Completed Tickets ---");
            // Iterate directly over the List
            for (SupportTicket ticket : completedTickets) { // Using List interface type for iteration
                System.out.println(ticket);
            }
            System.out.println("-------------------------");
        }
    }
}

/**
 * Main class to run the Support Ticket Management System.
 * Handles user interaction and drives the application logic.
 */
public class SupportTicketSystem {

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Use Scanner for reading user input from the console
        Scanner scanner = new Scanner(System.in);
        SupportSystem system = new SupportSystem();
        boolean running = true;

        // Class-wide exception handling wrapping the main application loop
        try {
            while (running) {
                System.out.println("\n--- Support Ticket System Menu ---");
                System.out.println("1. Add New Ticket");
                System.out.println("2. Process Next Ticket");
                System.out.println("3. View Pending Tickets");
                System.out.println("4. View Completed Tickets");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = -1;
                try {
                    // Read integer input for menu choice
                    choice = scanner.nextInt();
                    // Consume the leftover newline character after reading the integer
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    // Handle non-integer input specifically
                    System.err.println("Error: Invalid input. Please enter a number.");
                    // Consume the invalid input to prevent an infinite loop
                    scanner.nextLine();
                    continue; // Skip the rest of the loop and show menu again
                }

                // Use switch statement to handle different menu options
                switch (choice) {
                    case 1:
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();
                        system.addTicket(description); // addTicket handles validation internally
                        break;
                    case 2:
                        system.processNextTicket();
                        break;
                    case 3:
                        system.viewPendingTickets();
                        break;
                    case 4:
                        system.viewCompletedTickets();
                        break;
                    case 5:
                        System.out.println("Exiting Support Ticket System. Goodbye!");
                        running = false; // Set running to false to exit the loop
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // Catch any other unexpected runtime exceptions during the main loop execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // Optional: e.printStackTrace(); // Uncomment for detailed debugging information
        } finally {
            // Ensure the scanner resource is closed regardless of whether an exception occurred
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed."); // Confirmation message
            }
        }
    }
}
