/*
 * Exam Question #811
 * Generated on: 2025-05-12 16:44:36
 * Generated by: Account 2
 * 
 * QUESTION:
 * Welcome, student! Your task is to develop a command-line application for a simple Technical Support Ticket Management System. This system will help manage support requests by allowing users to add new tickets to a queue, process tickets in a first-in, first-out manner, and view the status of tickets.
 * 
 * You must implement the following features and adhere to the specified Java concepts and best practices:
 * 
 * **Requirements:**
 * 
 * 1.  **SupportTicket Class:** Create a class `SupportTicket` to represent a single support request. It should have private fields for a unique `ticketId` (automatically generated), `description` (String), and `status` (String, e.g., "Open", "Closed"). Include a constructor and appropriate public getter methods. Add a method `setStatus(String status)` and override `toString()` for easy printing.
 * 2.  **SupportSystem Class:** Create a class `SupportSystem` to manage collections of tickets.
 *     *   Use a `java.util.Queue<SupportTicket>` to store tickets that are currently open and waiting for processing (FIFO order).
 *     *   Use a `java.util.ArrayList<SupportTicket>` to store tickets that have been processed. Declare the variable using the `java.util.List` interface type (`List<SupportTicket>`).
 *     *   Implement methods:
 *         *   `addTicket(String description)`: Creates a new `SupportTicket` and adds it to the queue. Include basic validation (e.g., description not empty).
 *         *   `processNextTicket()`: Removes the next ticket from the queue, changes its status to "Closed", and adds it to the processed list. This method must throw a `java.util.NoSuchElementException` if the queue is empty.
 *         *   `viewOpenTickets()`: Prints details of all tickets currently in the queue.
 *         *   `viewProcessedTickets()`: Prints details of all tickets in the processed list.
 * 3.  **Command-Line Interface:** Create a main application class (`SupportSystemApp` or similar) with a `main` method.
 *     *   Use `java.util.Scanner` to read user commands from the console.
 *     *   Implement a menu-driven interface with the following commands:
 *         *   `a`: Add a new ticket (prompts for description).
 *         *   `p`: Process the next ticket.
 *         *   `v`: View tickets (prompts for 'open' or 'processed').
 *         *   `q`: Quit the application.
 *     *   Use a `switch` statement to handle the different commands.
 * 4.  **Output Streams:**
 *     *   Use `System.out` for all normal output, including the menu, prompts, success messages, and ticket details when viewing.
 *     *   Use `System.err` exclusively for displaying error messages (e.g., "Invalid command", "No tickets to process", "Invalid input").
 * 5.  **Exception Handling:** Implement class-wide exception handling using `try-catch` blocks in the main application loop to gracefully handle potential errors during user interaction or command execution. Specifically catch the `NoSuchElementException` from `processNextTicket`.
 * 6.  **Best Practices:**
 *     *   Ensure proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Add comments and documentation (e.g., Javadoc) where appropriate.
 *     *   Implement input validation as specified.
 *     *   Close the `Scanner` resource when the application exits.
 * 
 * **Expected Interaction Flow:**
 * 
 * The application should display a menu, prompt for a command, execute the command, and repeat until the 'q' command is entered. Error messages should be clearly distinguishable using `System.err`.
 * 
 * Example (user input shown in `>`):
 * ```
 * Welcome to the Technical Support Ticket System!
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > a
 * Enter ticket description: > Printer not working
 * Ticket added: Ticket [ID=1, Status=Open, Description='Printer not working']
 * 
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > a
 * Enter ticket description: > Cannot connect to VPN
 * Ticket added: Ticket [ID=2, Status=Open, Description='Cannot connect to VPN']
 * 
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > v
 * View (open/processed): > open
 * 
 * --- Open Tickets ---
 * Ticket [ID=1, Status=Open, Description='Printer not working']
 * Ticket [ID=2, Status=Open, Description='Cannot connect to VPN']
 * --------------------
 * 
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > p
 * Ticket processed: Ticket [ID=1, Status=Closed, Description='Printer not working']
 * 
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > v
 * View (open/processed): > processed
 * 
 * --- Processed Tickets ---
 * Ticket [ID=1, Status=Closed, Description='Printer not working']
 * -------------------------
 * 
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > p
 * Ticket processed: Ticket [ID=2, Status=Closed, Description='Cannot connect to VPN']
 * 
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > p
 * Error processing ticket: No open tickets to process.
 * 
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > x
 * Invalid command. Please use 'a', 'p', 'v', or 'q'.
 * 
 * --- Menu ---
 * a: Add Ticket
 * p: Process Next Ticket
 * v: View Tickets
 * q: Quit
 * ------------
 * Enter command: > q
 * Exiting system. Goodbye!
 * ```
 * 
 * Your solution should be provided as a single Java code file.
 *
 * EXPLANATION:
 * This solution implements a simple command-line Technical Support Ticket System, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`SupportTicket` Class:**
 *     *   Encapsulates ticket data (`ticketId`, `description`, `status`) using private fields and public getters.
 *     *   Uses a static `AtomicInteger` (`count`) to generate unique, sequential ticket IDs automatically upon ticket creation. This is a thread-safe way to manage a counter, although for this single-threaded application, a simple `int` counter would also suffice.
 *     *   Provides a `setStatus` method to change the ticket's status and overrides `toString` for convenient printing of ticket details.
 * 
 * 2.  **`SupportSystem` Class:**
 *     *   Manages the collections of tickets:
 *         *   `ticketQueue`: A `java.util.Queue` (implemented using `java.util.LinkedList`) is used to store open tickets. The `Queue` interface ensures FIFO (First-In, First-Out) behavior, which is appropriate for a support ticket queue where the oldest tickets are processed first. `offer()` is used to add tickets to the end, and `poll()` is used to remove tickets from the front.
 *         *   `processedTickets`: A `java.util.ArrayList` is used to store tickets once they are processed. The variable is declared using the `java.util.List` interface (`List<SupportTicket> processedTickets`), demonstrating polymorphism. `ArrayList` is suitable for storing processed items, allowing easy iteration and adding elements.
 *     *   Includes methods (`addTicket`, `processNextTicket`, `viewOpenTickets`, `viewProcessedTickets`) that encapsulate the system's core logic.
 *     *   `processNextTicket()` explicitly throws `NoSuchElementException` if the queue is empty, fulfilling a requirement for specific exception handling.
 * 
 * 3.  **`SupportSystemApp` Class (Main Application):**
 *     *   Contains the `main` method, serving as the application's entry point and command-line interface handler.
 *     *   Uses `java.util.Scanner` to read user input from the console (`System.in`). `nextLine()` is used to read entire lines for commands and descriptions.
 *     *   A `while` loop keeps the application running until the user chooses to quit.
 *     *   A `switch` statement processes the user's command ('a', 'p', 'v', 'q'), directing the flow to the appropriate `SupportSystem` method or action.
 *     *   Includes a `printMenu` helper method using `System.out` to display the available commands.
 * 
 * 4.  **Output Streams (`System.out` and `System.err`):**
 *     *   `System.out` is used for all standard output: the welcome message, the menu, prompts for input, confirmation messages (ticket added, ticket processed), and the lists of tickets when viewing.
 *     *   `System.err` is strictly used for error messages: invalid commands, errors during processing (like an empty queue), and invalid input for sub-commands (like view type). This separation helps distinguish normal program output from errors.
 * 
 * 5.  **Exception Handling (`try-catch`):**
 *     *   A broad `try-catch(Exception e)` block wraps the main command-processing logic within the `while` loop. This serves as the "class-wide" exception handler, catching any unexpected errors that might occur during command execution and printing an error message using `System.err`.
 *     *   A nested `try-catch(NoSuchElementException e)` block specifically surrounds the call to `system.processNextTicket()`. This demonstrates catching a specific, anticipated exception (attempting to process a ticket from an empty queue) and providing a user-friendly error message using `System.err`.
 * 
 * 6.  **Best Practices:**
 *     *   **Encapsulation:** Clearly demonstrated by the `SupportTicket` class and the separation of concerns between `SupportTicket`, `SupportSystem`, and `SupportSystemApp`.
 *     *   **Meaningful Names:** Classes, methods, and variables have names that reflect their purpose (e.g., `ticketQueue`, `processNextTicket`, `processedTickets`).
 *     *   **Comments and Documentation:** Javadoc comments are included for classes and methods, explaining their purpose, parameters, and potential exceptions. Inline comments clarify specific logic.
 *     *   **Input Validation:** Basic validation is performed for the ticket description (not empty) and the view type ('open' or 'processed').
 *     *   **Error Handling:** Robust error handling is implemented using exceptions and `System.err` for error messages.
 *     *   **Resource Management:** The `Scanner` object is closed using `scanner.close()` when the application loop finishes, releasing the system resource.
 * 
 * This solution effectively utilizes all specified Java components within a practical scenario, demonstrates best practices, and incorporates proper error handling, fulfilling the requirements of the complex exam task.
 */

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger; // For unique ID generation

// Class representing a single Support Ticket
class SupportTicket {
    private static final AtomicInteger count = new AtomicInteger(0); // Static counter for unique IDs
    private final int ticketId; // final because ID doesn't change
    private String description;
    private String status; // e.g., "Open", "Processing", "Closed"

    /**
     * Constructs a new SupportTicket.
     * Assigns a unique ID and sets initial status to "Open".
     * @param description The description of the support issue.
     */
    public SupportTicket(String description) {
        this.ticketId = count.incrementAndGet(); // Get unique ID
        this.description = description;
        this.status = "Open"; // Initial status
    }

    // Getters
    public int getTicketId() {
        return ticketId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the ticket.
     * @param status The new status (e.g., "Closed").
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket [ID=" + ticketId + ", Status=" + status + ", Description='" + description + "']";
    }
}

// Class managing the Support Tickets
class SupportSystem {
    private Queue<SupportTicket> ticketQueue; // Tickets waiting for processing (Open)
    private List<SupportTicket> processedTickets; // Tickets that have been processed (Closed)

    /**
     * Constructs a new SupportSystem, initializing the ticket collections.
     */
    public SupportSystem() {
        // Use LinkedList as a concrete implementation of Queue
        this.ticketQueue = new LinkedList<>();
        // Use ArrayList as a concrete implementation of List
        this.processedTickets = new ArrayList<>();
    }

    /**
     * Adds a new ticket to the queue of open tickets.
     * Performs basic validation on description.
     * @param description The description for the new ticket.
     */
    public void addTicket(String description) {
        if (description == null || description.trim().isEmpty()) {
            // Use System.err for validation errors
            System.err.println("Error: Ticket description cannot be empty.");
            return;
        }
        SupportTicket newTicket = new SupportTicket(description.trim());
        // offer is preferred over add for queues as it handles capacity-constrained queues gracefully (though LinkedList is not capacity-constrained)
        ticketQueue.offer(newTicket);
        System.out.println("Ticket added: " + newTicket); // Normal output
    }

    /**
     * Processes the next ticket in the queue (FIFO).
     * Removes the ticket from the queue, updates its status to "Closed", and adds it to the processed list.
     * @throws NoSuchElementException if the ticket queue is empty, indicating no ticket is available to process.
     */
    public void processNextTicket() throws NoSuchElementException {
        // poll() retrieves and removes the head of the queue, returns null if empty.
        // We'll check for null and throw NoSuchElementException as required for error handling demonstration.
        SupportTicket ticketToProcess = ticketQueue.poll();
        if (ticketToProcess == null) {
            // Throwing a specific exception for the calling code (main) to catch
            throw new NoSuchElementException("No open tickets to process.");
        }
        ticketToProcess.setStatus("Closed"); // Update status
        processedTickets.add(ticketToProcess); // Add to processed list
        System.out.println("Ticket processed: " + ticketToProcess); // Normal output
    }

    /**
     * Displays all currently open tickets in the queue.
     */
    public void viewOpenTickets() {
        System.out.println("\n--- Open Tickets ---"); // Normal output
        if (ticketQueue.isEmpty()) {
            System.out.println("No open tickets currently."); // Normal output
        } else {
            // Iterate over the queue elements without removing them
            ticketQueue.forEach(System.out::println); // Normal output
        }
        System.out.println("--------------------"); // Normal output
    }

    /**
     * Displays all tickets that have been processed.
     */
    public void viewProcessedTickets() {
        System.out.println("\n--- Processed Tickets ---"); // Normal output
        if (processedTickets.isEmpty()) {
            System.out.println("No tickets have been processed yet."); // Normal output
        } else {
            // Iterate over the list elements
            processedTickets.forEach(System.out::println); // Normal output
        }
        System.out.println("-------------------------"); // Normal output
    }
}

// Main application class to handle user interaction
public class SupportSystemApp {
    public static void main(String[] args) {
        // Scanner for reading user input from the console
        Scanner scanner = new Scanner(System.in);
        // Instance of the SupportSystem to manage tickets
        SupportSystem system = new SupportSystem();

        System.out.println("Welcome to the Technical Support Ticket System!"); // Normal output

        boolean running = true;
        // Main application loop
        while (running) {
            printMenu(); // Display available commands

            // Use a try-catch block for class-wide exception handling within the loop
            // This catches potential issues during command processing or unexpected errors
            try {
                System.out.print("Enter command: "); // Normal output
                // Read the entire line and trim whitespace, convert to lowercase for case-insensitivity
                String command = scanner.nextLine().trim().toLowerCase();

                // Use a switch statement to handle different commands
                switch (command) {
                    case "a": // Add Ticket
                        System.out.print("Enter ticket description: "); // Normal output
                        String description = scanner.nextLine();
                        // Call the method to add a ticket. addTicket handles its own basic validation/error output.
                        system.addTicket(description);
                        break;

                    case "p": // Process Next Ticket
                        // Use a nested try-catch specifically for the process operation
                        // This catches the NoSuchElementException thrown by processNextTicket
                        try {
                            system.processNextTicket();
                        } catch (NoSuchElementException e) {
                            // Use System.err for error messages related to operation failure
                            System.err.println("Error processing ticket: " + e.getMessage());
                        }
                        break;

                    case "v": // View Tickets
                        System.out.print("View (open/processed): "); // Normal output
                        String viewType = scanner.nextLine().trim().toLowerCase();
                        // Use equals() for string comparison to avoid NullPointerException
                        if ("open".equals(viewType)) {
                            system.viewOpenTickets();
                        } else if ("processed".equals(viewType)) {
                            system.viewProcessedTickets();
                        } else {
                            // Use System.err for invalid input related to the command
                            System.err.println("Invalid view type. Please enter 'open' or 'processed'.");
                        }
                        break;

                    case "q": // Quit
                        System.out.println("Exiting system. Goodbye!"); // Normal output
                        running = false; // Set flag to exit loop
                        break;

                    default:
                        // Handle unrecognized commands using System.err
                        System.err.println("Invalid command. Please use 'a', 'p', 'v', or 'q'.");
                        break;
                }
            } catch (Exception e) {
                // This outer catch block catches any unexpected exceptions that might occur
                // within the command processing logic. It serves as the "class-wide" handler.
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // For Scanner methods other than nextLine(), you might need to consume the invalid input here.
            }
            System.out.println(); // Add a blank line after each command cycle for clarity
        }

        // Close the scanner resource when the application exits
        scanner.close();
    }

    /**
     * Prints the main menu options to the console using System.out.
     */
    private static void printMenu() {
        System.out.println("--- Menu ---");
        System.out.println("a: Add Ticket");
        System.out.println("p: Process Next Ticket");
        System.out.println("v: View Tickets");
        System.out.println("q: Quit");
        System.out.println("------------");
    }
}
