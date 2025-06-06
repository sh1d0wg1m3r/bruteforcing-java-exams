/*
 * Exam Question #1081
 * Generated on: 2025-05-12 17:22:25
 * Generated by: Account 3
 * 
 * QUESTION:
 * Subject: Advanced Java Programming
 * Topic: Data Structures, Control Flow, Exception Handling, I/O
 * 
 * **Problem Title:** Support Ticket Management System
 * 
 * **Description:**
 * You are tasked with building a simple command-line application for managing support tickets. The system should allow users (simulated via console input) to add new tickets, view tickets waiting for processing, process the next ticket in line, and view tickets that have been resolved.
 * 
 * The system should prioritize tickets based on the order they were received (First-In, First-Out). Resolved tickets should be stored separately.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to store new tickets waiting to be processed.
 *     *   Use a `java.util.List` (implemented by `java.util.ArrayList`) to store resolved tickets.
 *     *   Create a `Ticket` class with private fields for ID, description, and status (e.g., "NEW", "RESOLVED"). Include appropriate getters and a method to update the status. Assign unique IDs to tickets as they are created (a simple static counter is sufficient).
 * 
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user.
 *     *   Implement the following menu options:
 *         *   **1. Add New Ticket:** Prompt the user for a ticket description. Create a new `Ticket` object and add it to the new tickets queue.
 *         *   **2. View New Tickets Queue:** Display all tickets currently in the queue without removing them. Indicate if the queue is empty.
 *         *   **3. Process Next Ticket:** Take the oldest ticket from the new tickets queue, update its status to "RESOLVED", and move it to the resolved tickets list. Indicate if there are no tickets to process.
 *         *   **4. View Resolved Tickets:** Display all tickets in the resolved tickets list. Indicate if the list is empty.
 *         *   **5. Exit:** Terminate the program.
 * 
 * 3.  **Control Flow:**
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Use a loop to keep the program running until the user chooses to exit.
 * 
 * 4.  **Input/Output:**
 *     *   Use `System.out` for displaying the menu, prompts, success messages, and ticket details.
 *     *   Use `System.err` for displaying error messages (e.g., invalid menu choice, attempting to process when the queue is empty, invalid input type).
 * 
 * 5.  **Exception Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors, such as invalid input format from the `Scanner`. Ensure the program doesn't crash on invalid input and provides informative error messages using `System.err`.
 * 
 * 6.  **Best Practices:**
 *     *   Follow proper encapsulation principles (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Perform basic input validation (e.g., check if the ticket description is empty).
 *     *   Ensure resources like the `Scanner` are closed properly.
 * 
 * **Expected Output:**
 * The program should run interactively, displaying a menu, accepting user input, and providing output based on the chosen action. Error messages should be distinct (using `System.err`).
 * 
 * *Example Interaction Snippet:*
 * ```
 * --- Support System Menu ---
 * 1. Add New Ticket
 * ...
 * 5. Exit
 * ---------------------------
 * Enter your choice: 1
 * Enter ticket description: Printer not working
 * Ticket added: 1
 * --- Support System Menu ---
 * ...
 * Enter your choice: 2
 * --- New Tickets Queue ---
 * 1. Ticket{ID=1, Status='NEW', Description='Printer not working'}
 * -------------------------
 * --- Support System Menu ---
 * ...
 * Enter your choice: 3
 * --- Processing Next Ticket ---
 * Processed ticket: 1
 * ----------------------------
 * --- Support System Menu ---
 * ...
 * Enter your choice: 4
 * --- Resolved Tickets ---
 * 1. Ticket{ID=1, Status='RESOLVED', Description='Printer not working'}
 * ------------------------
 * --- Support System Menu ---
 * ...
 * Enter your choice: invalid
 * Invalid input. Please enter a number.
 * --- Support System Menu ---
 * ...
 * Enter your choice: 3
 * --- Processing Next Ticket ---
 * Error: No new tickets to process.
 * ----------------------------
 * ```
 *
 * EXPLANATION:
 * This solution implements a simple command-line Support Ticket Management System demonstrating the required Java concepts.
 * 
 * 1.  **`Ticket` Class:**
 *     *   Represents a single support ticket with an auto-generated ID (`static int nextId`), a description, and a status.
 *     *   Uses private fields and public getter methods, adhering to encapsulation.
 *     *   Includes a `toString()` method for easy printing of ticket details.
 * 
 * 2.  **`SupportSystem` Class:**
 *     *   This is the main class managing the system's state and logic.
 *     *   **Data Structures:**
 *         *   `private Queue<Ticket> newTicketsQueue;`: A `Queue` is used to store new tickets. `LinkedList` is a common implementation of `Queue` that provides FIFO behavior. `offer()` is used to add elements (non-blocking if queue is bounded, safe here), and `poll()` is used to remove elements from the head (returns `null` if empty, avoiding exceptions).
 *         *   `private List<Ticket> resolvedTicketsList;`: A `List` is used to store tickets after they have been processed. `ArrayList` is chosen as a concrete implementation, providing dynamic array capabilities.
 *     *   **Constructor:** Initializes the `Queue`, `List`, and `Scanner`.
 *     *   **Methods:**
 *         *   `addTicket(String description)`: Creates a new `Ticket` and adds it to the `newTicketsQueue` using `offer()`. Includes basic validation to ensure the description is not empty.
 *         *   `viewNewTickets()`: Iterates through the `newTicketsQueue` using a for-each loop to display tickets without removing them. Checks if the queue is empty.
 *         *   `processNextTicket()`: Uses `newTicketsQueue.poll()` to get the next ticket. If `poll()` returns `null` (queue is empty), it prints an error to `System.err`. Otherwise, it updates the ticket's status to "RESOLVED" and adds it to the `resolvedTicketsList`.
 *         *   `viewResolvedTickets()`: Iterates through the `resolvedTicketsList` to display resolved tickets. Checks if the list is empty.
 *         *   `printMenu()`: A helper method to display the user menu using `System.out`.
 *         *   `run()`: Contains the main application loop.
 *             *   It uses a `while` loop (`running` flag) to continue until the user chooses to exit.
 *             *   **Exception Handling:** The core of the `run()` method's loop is wrapped in a `try-catch` block.
 *                 *   A specific `catch (InputMismatchException e)` handles cases where the user enters non-integer input for the menu choice. It prints an error to `System.err` and consumes the invalid input using `scanner.nextLine()` to prevent an infinite loop.
 *                 *   A general `catch (Exception e)` is included as a fallback for any other unexpected runtime errors that might occur within the loop, fulfilling the "class-wide exception handling" requirement by wrapping the main operational logic. Error details are printed to `System.err`.
 *             *   A `finally` block ensures the `scanner` resource is closed regardless of whether an exception occurred or the loop finished normally.
 *             *   **Control Flow:** A `switch` statement is used inside the loop to direct the program's flow based on the validated user choice, calling the appropriate methods (`addTicket`, `viewNewTickets`, etc.).
 *     *   **`main` Method:** The entry point of the application. It creates an instance of `SupportSystem` and calls its `run()` method to start the interactive loop.
 * 
 * This solution effectively integrates `Queue`, `List` (implemented by `ArrayList`), `Scanner`, `switch`, `System.out`, `System.err`, and `try-catch` exception handling within a practical, structured program, demonstrating advanced understanding of core Java concepts and best practices like encapsulation, meaningful naming, and error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a support ticket in the system.
 */
class Ticket {
    private static int nextId = 1; // Static counter for unique IDs

    private int id;
    private String description;
    private String status; // e.g., "NEW", "RESOLVED"

    /**
     * Constructs a new Ticket.
     * @param description The description of the issue.
     */
    public Ticket(String description) {
        this.id = nextId++; // Assign ID and increment counter
        this.description = description;
        this.status = "NEW"; // Initial status
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the ticket.
     * @param status The new status (e.g., "RESOLVED").
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
               "ID=" + id +
               ", Status='" + status + '\'' +
               ", Description='" + description + '\'' +
               '}';
    }
}

/**
 * Manages support tickets using a queue for new tickets and a list for resolved tickets.
 */
public class SupportSystem {
    private Queue<Ticket> newTicketsQueue;
    private List<Ticket> resolvedTicketsList;
    private Scanner scanner;

    /**
     * Constructs a new SupportSystem.
     */
    public SupportSystem() {
        // Initialize data structures
        newTicketsQueue = new LinkedList<>(); // LinkedList is a common Queue implementation
        resolvedTicketsList = new ArrayList<>(); // ArrayList implements List
        scanner = new Scanner(System.in); // Initialize scanner
    }

    /**
     * Adds a new ticket to the queue.
     * Performs input validation for the description.
     * @param description The description of the issue.
     */
    public void addTicket(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Ticket description cannot be empty.");
            return;
        }
        Ticket newTicket = new Ticket(description.trim());
        newTicketsQueue.offer(newTicket); // offer() is preferred over add() for queues
        System.out.println("Ticket added: " + newTicket.getId());
    }

    /**
     * Displays all tickets currently in the new tickets queue without removing them.
     */
    public void viewNewTickets() {
        System.out.println("\n--- New Tickets Queue ---");
        if (newTicketsQueue.isEmpty()) {
            System.out.println("No new tickets in the queue.");
        } else {
            // Iterate without removing elements
            int index = 1;
            for (Ticket ticket : newTicketsQueue) {
                System.out.println(index++ + ". " + ticket);
            }
        }
        System.out.println("-------------------------\n");
    }

    /**
     * Processes the next ticket in the queue (moves it to resolved).
     * Handles the case where the queue is empty.
     */
    public void processNextTicket() {
        System.out.println("\n--- Processing Next Ticket ---");
        Ticket nextTicket = newTicketsQueue.poll(); // poll() retrieves and removes the head, returns null if queue is empty
        if (nextTicket == null) {
            System.err.println("Error: No new tickets to process.");
        } else {
            nextTicket.setStatus("RESOLVED"); // Update status
            resolvedTicketsList.add(nextTicket); // Add to resolved list
            System.out.println("Processed ticket: " + nextTicket.getId());
        }
        System.out.println("----------------------------\n");
    }

    /**
     * Displays all resolved tickets.
     */
    public void viewResolvedTickets() {
        System.out.println("\n--- Resolved Tickets ---");
        if (resolvedTicketsList.isEmpty()) {
            System.out.println("No tickets have been resolved yet.");
        } else {
            int index = 1;
            for (Ticket ticket : resolvedTicketsList) {
                System.out.println(index++ + ". " + ticket);
            }
        }
        System.out.println("------------------------\n");
    }

    /**
     * Runs the main interactive support system loop.
     * Includes class-wide exception handling for input and general errors.
     */
    public void run() {
        boolean running = true;

        // Class-wide exception handling around the main operational loop
        try {
            while (running) {
                printMenu();

                System.out.print("Enter your choice: ");
                int choice;
                try {
                    // Attempt to read integer input
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                } catch (InputMismatchException e) {
                    // Handle non-integer input specifically
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop and show menu again
                }

                // Use switch statement for flow control based on valid integer choice
                switch (choice) {
                    case 1:
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();
                        addTicket(description);
                        break;
                    case 2:
                        viewNewTickets();
                        break;
                    case 3:
                        processNextTicket();
                        break;
                    case 4:
                        viewResolvedTickets();
                        break;
                    case 5:
                        System.out.println("Exiting Support System. Goodbye!");
                        running = false;
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main loop execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(); // Optional: print stack trace for debugging in development
        } finally {
            // Ensure scanner is closed when the program exits or encounters a major error
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("--- Support System Menu ---");
        System.out.println("1. Add New Ticket");
        System.out.println("2. View New Tickets Queue");
        System.out.println("3. Process Next Ticket");
        System.out.println("4. View Resolved Tickets");
        System.out.println("5. Exit");
        System.out.println("---------------------------");
    }

    /**
     * Main method to start the Support System application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SupportSystem system = new SupportSystem();
        system.run();
    }
}
