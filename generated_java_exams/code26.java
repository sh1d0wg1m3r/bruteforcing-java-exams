/*
 * Exam Question #26
 * Generated on: 2025-05-11 21:45:35
 * 
 * QUESTION:
 * **Problem Title: Support Ticket Management System**
 * 
 * You are tasked with developing a simple console-based application to manage support tickets. The system should allow users to add new tickets, process the next available ticket, view pending tickets, and view resolved tickets.
 * 
 * Your solution must adhere to the following requirements:
 * 
 * 1.  **Ticket Representation:** Create a class `SupportTicket` with private fields for a unique integer `id` and a `String description`. Include a constructor and public getter methods for these fields. Override the `toString()` method to provide a user-friendly representation of the ticket (e.g., "Ticket #ID: Description").
 * 2.  **System Management:** Create a class `SupportSystem` that manages the tickets.
 *     *   It must use a `java.util.Queue` to store pending support tickets. Tickets should be processed in the order they are added (FIFO).
 *     *   It must use a `java.util.List` (specifically, an `ArrayList`) to store resolved support tickets.
 *     *   It should maintain a counter for assigning unique ticket IDs.
 *     *   Implement the following public methods:
 *         *   `addTicket(String description)`: Creates a new `SupportTicket` with the next available ID and the given description, and adds it to the pending queue.
 *         *   `processNextTicket()`: Removes the ticket at the front of the pending queue and adds it to the resolved list. This method should return the processed `SupportTicket` or indicate if no tickets were pending.
 *         *   `viewPendingTickets()`: Prints all tickets currently in the pending queue to `System.out`.
 *         *   `viewResolvedTickets()`: Prints all tickets currently in the resolved list to `System.out`.
 * 3.  **User Interface:** Implement a main class (e.g., `SupportApp`) with a `main` method to interact with the user via the console.
 *     *   Use `java.util.Scanner` to read user input.
 *     *   Display a menu of options:
 *         1.  Add New Ticket
 *         2.  Process Next Ticket
 *         3.  View Pending Tickets
 *         4.  View Resolved Tickets
 *         5.  Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Implement input validation for menu choices (ensure it's a valid integer within the range).
 *     *   Handle potential errors gracefully.
 * 4.  **Error Handling & Output:**
 *     *   Use `System.out` for displaying the menu, prompts, ticket information, and success messages.
 *     *   Use `System.err` for printing error messages (e.g., invalid menu choice, trying to process a ticket when none are pending, invalid input format).
 *     *   Implement class-wide exception handling (e.g., wrapping the main application loop or significant logic within a `try-catch` block) to catch unexpected runtime issues, particularly related to input processing. Handle `InputMismatchException` specifically if the user enters non-integer input for the menu choice.
 * 5.  **Best Practices:** Ensure proper encapsulation, meaningful names, appropriate comments, and clean code structure.
 * 
 * **Expected Output Examples:**
 * 
 * *   When adding a ticket:
 *     ```
 *     Enter ticket description: Printer not working
 *     Ticket #1 added to the pending queue.
 *     ```
 * *   When viewing pending tickets (with tickets 1 and 2 added):
 *     ```
 *     --- Pending Tickets ---
 *     Ticket #1: Printer not working
 *     Ticket #2: Software crash
 *     -----------------------
 *     ```
 * *   When processing a ticket (when tickets are pending):
 *     ```
 *     Processing next ticket...
 *     Ticket #1: Printer not working has been resolved.
 *     ```
 * *   When processing a ticket (when none are pending):
 *     ```
 *     No pending tickets to process.
 *     ```
 * *   When viewing resolved tickets (after processing ticket 1):
 *     ```
 *     --- Resolved Tickets ---
 *     Ticket #1: Printer not working
 *     ------------------------
 *     ```
 * *   When entering invalid menu input:
 *     ```
 *     Invalid input. Please enter a number.
 *     ```
 *     (This message should go to `System.err`)
 * *   When entering an invalid menu number:
 *     ```
 *     Invalid choice. Please enter a number between 1 and 5.
 *     ```
 *     (This message should go to `System.err`)
 * 
 * Develop the complete Java code for this system.
 *
 * EXPLANATION:
 * The provided solution implements a simple Support Ticket Management System using the required Java components and best practices.
 * 
 * 1.  **`SupportTicket` Class:** This class is a simple Plain Old Java Object (POJO) representing a ticket. It demonstrates **encapsulation** by keeping `id` and `description` private and providing public getter methods. The `toString()` method provides a convenient way to print ticket details.
 * 
 * 2.  **`SupportSystem` Class:** This is the core class managing the system's state.
 *     *   It uses a `Queue<SupportTicket>` (`LinkedList` implementation) for `pendingTickets`, correctly modeling the FIFO nature of processing support tickets.
 *     *   It uses a `List<SupportTicket>` (`ArrayList` implementation) for `resolvedTickets`, suitable for storing processed items in a dynamic list.
 *     *   `nextTicketId` is a private field, demonstrating **encapsulation**.
 *     *   `addTicket` uses `offer()` (a common Queue method) to add elements. It includes basic input validation for the description.
 *     *   `processNextTicket` uses `poll()` (a common Queue method) to retrieve and remove the head of the queue. It handles the case where the queue is empty by checking the return value of `poll()` (which is `null` if empty).
 *     *   `viewPendingTickets` and `viewResolvedTickets` iterate through the collections to print their contents. Iterating directly over the `Queue` with a for-each loop is safe as it doesn't remove elements.
 * 
 * 3.  **`SupportApp` Class (Main Application):**
 *     *   The `main` method drives the application flow.
 *     *   A `Scanner` is used for all user input.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   The `printMenu()` method encapsulates the menu display logic.
 *     *   A `switch` statement is used to branch execution based on the user's valid integer choice, fulfilling the `switch` requirement.
 *     *   **Exception Handling:**
 *         *   A `try-catch(InputMismatchException)` block specifically handles cases where the user enters non-integer input for the menu choice. It prints an error to `System.err` and consumes the invalid input using `scanner.next()` to prevent an infinite loop caused by the scanner repeatedly trying to read the same invalid token as an integer.
 *         *   A `finally` block after the `InputMismatchException` catch ensures `scanner.nextLine()` is called to consume any leftover newline character, which is crucial before reading subsequent line-based input (like the ticket description).
 *         *   A broader `try-catch(Exception e)` block wraps the main `while` loop. This demonstrates **class-wide exception handling** by providing a safety net for any other unexpected runtime exceptions that might occur within the main application logic. Error details are printed to `System.err`, including a stack trace for debugging purposes.
 *         *   A `finally` block outside the main loop ensures the `Scanner` is closed when the application exits, whether normally or due to an exception.
 *     *   **Output:** `System.out` is used for standard application output (menu, prompts, ticket details, success messages). `System.err` is correctly used for printing error messages (invalid input, invalid choice).
 * 
 * This solution effectively demonstrates the required Java components, follows best practices like encapsulation and clear naming, and includes robust input validation and error handling, making it a challenging yet solvable exam task.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a single support ticket
class SupportTicket {
    private int id;
    private String description;

    /**
     * Constructs a new SupportTicket.
     * @param id The unique ID for the ticket.
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
     * Returns a string representation of the ticket.
     * @return String representation of the ticket.
     */
    @Override
    public String toString() {
        return "Ticket #" + id + ": " + description;
    }
}

// Manages the collection of pending and resolved support tickets
class SupportSystem {
    // Queue to hold tickets waiting to be processed (FIFO)
    private Queue<SupportTicket> pendingTickets;
    // List to hold tickets that have been resolved
    private List<SupportTicket> resolvedTickets;
    // Counter for generating unique ticket IDs
    private int nextTicketId;

    /**
     * Constructs a new SupportSystem, initializing collections and ID counter.
     */
    public SupportSystem() {
        this.pendingTickets = new LinkedList<>(); // LinkedList implements Queue
        this.resolvedTickets = new ArrayList<>(); // ArrayList implements List
        this.nextTicketId = 1;
    }

    /**
     * Adds a new support ticket to the pending queue.
     * @param description The description of the new ticket.
     */
    public void addTicket(String description) {
        if (description == null || description.trim().isEmpty()) {
             // Basic validation: description shouldn't be empty
             System.err.println("Error: Ticket description cannot be empty.");
             return;
        }
        SupportTicket newTicket = new SupportTicket(nextTicketId++, description.trim());
        pendingTickets.offer(newTicket); // offer is preferred over add for queues
        System.out.println("Ticket #" + newTicket.getId() + " added to the pending queue.");
    }

    /**
     * Processes the next available ticket from the pending queue.
     * Moves the ticket from pending to resolved list.
     * @return The processed SupportTicket, or null if no tickets were pending.
     */
    public SupportTicket processNextTicket() {
        SupportTicket processedTicket = pendingTickets.poll(); // poll retrieves and removes the head
        if (processedTicket != null) {
            resolvedTickets.add(processedTicket);
            System.out.println("Processing next ticket...");
            return processedTicket;
        } else {
            return null; // Indicate no ticket was processed
        }
    }

    /**
     * Prints all tickets currently in the pending queue.
     */
    public void viewPendingTickets() {
        System.out.println("--- Pending Tickets ---");
        if (pendingTickets.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            // Iterate through the queue without removing elements
            for (SupportTicket ticket : pendingTickets) {
                System.out.println(ticket);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Prints all tickets currently in the resolved list.
     */
    public void viewResolvedTickets() {
        System.out.println("--- Resolved Tickets ---");
        if (resolvedTickets.isEmpty()) {
            System.out.println("No resolved tickets.");
        } else {
            for (SupportTicket ticket : resolvedTickets) {
                System.out.println(ticket);
            }
        }
        System.out.println("------------------------");
    }
}

// Main application class for user interaction
public class SupportApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupportSystem system = new SupportSystem();
        boolean running = true;

        System.out.println("Welcome to the Support Ticket Management System!");

        // Class-wide exception handling around the main application loop
        try {
            while (running) {
                printMenu();

                int choice = -1; // Initialize with an invalid value
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt(); // Read integer input
                } catch (InputMismatchException e) {
                    // Handle non-integer input specifically
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip to the next iteration of the while loop
                } finally {
                    // Consume the rest of the line after reading the number
                    // This is important if the next input is a line (like description)
                     scanner.nextLine();
                }

                // Use a switch statement for menu options
                switch (choice) {
                    case 1: // Add New Ticket
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();
                        system.addTicket(description);
                        break;
                    case 2: // Process Next Ticket
                        SupportTicket processed = system.processNextTicket();
                        if (processed != null) {
                            System.out.println(processed + " has been resolved.");
                        } else {
                            System.out.println("No pending tickets to process.");
                        }
                        break;
                    case 3: // View Pending Tickets
                        system.viewPendingTickets();
                        break;
                    case 4: // View Resolved Tickets
                        system.viewResolvedTickets();
                        break;
                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting Support Ticket Management System. Goodbye!");
                        break;
                    default: // Invalid choice
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                System.out.println(); // Add a blank line for better readability
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed
            scanner.close();
            System.out.println("Scanner closed."); // Optional: Confirmation message
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Menu ---");
        System.out.println("1. Add New Ticket");
        System.out.println("2. Process Next Ticket");
        System.out.println("3. View Pending Tickets");
        System.out.println("4. View Resolved Tickets");
        System.out.println("5. Exit");
        System.out.println("------------");
    }
}
