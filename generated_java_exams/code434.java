/*
 * Exam Question #434
 * Generated on: 2025-05-11 23:10:43
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Help Desk Ticket Management System
 * 
 * **Objective:**
 * 
 * Design and implement a simple command-line Help Desk Ticket Management System. The system should allow users to add new support tickets, process the oldest pending ticket, view the list of pending tickets, and view the list of resolved tickets. This task requires demonstrating proficiency in using fundamental Java data structures, control flow, and error handling.
 * 
 * **Requirements:**
 * 
 * 1.  **Ticket Representation:** Create a class named `Ticket` to represent a support ticket. Each `Ticket` must have:
 *     *   A unique integer `id`.
 *     *   A `String` `description` of the issue.
 *     *   A `String` `status` (e.g., "OPEN", "RESOLVED").
 *     *   Implement appropriate constructors, getters, and a `toString()` method for easy display. Ensure fields are private.
 * 
 * 2.  **System Management:** Create a class named `HelpDeskSystem` to manage the tickets. This class must contain:
 *     *   A `Queue<Ticket>` to hold tickets that are currently pending/open. Use a concrete implementation like `java.util.LinkedList`.
 *     *   A `List<Ticket>` to hold tickets that have been resolved. Use a concrete implementation like `java.util.ArrayList`.
 *     *   A mechanism to generate unique ticket IDs (e.g., a counter).
 *     *   Methods for the following operations:
 *         *   `addTicket(String description)`: Creates a new `Ticket` with a unique ID, sets its status to "OPEN", and adds it to the pending queue.
 *         *   `processNextTicket()`: Removes the oldest ticket from the pending queue, sets its status to "RESOLVED", and adds it to the resolved list. If the queue is empty, it should indicate an error.
 *         *   `viewOpenTickets()`: Displays all tickets currently in the pending queue.
 *         *   `viewResolvedTickets()`: Displays all tickets in the resolved list.
 * 
 * 3.  **User Interface:** Implement a command-line interface in a `main` method (either within `HelpDeskSystem` or a separate class). The interface should:
 *     *   Present a menu of options to the user (Add Ticket, Process Ticket, View Open, View Resolved, Exit).
 *     *   Read user input using `java.util.Scanner`.
 *     *   Use a `switch` statement to handle the different menu options.
 *     *   Loop continuously until the user chooses to exit.
 * 
 * 4.  **Error Handling:**
 *     *   Use `System.err` to print error messages (e.g., when trying to process a ticket from an empty queue, or for invalid user input).
 *     *   Use `System.out` for all normal output (menu, prompts, success messages, ticket listings).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle unexpected issues during user interaction (e.g., non-integer input if you were parsing numbers, though switching on String input is safer for the menu). Wrap the main user interaction loop or critical sections with `try-catch`.
 * 
 * 5.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and basic documentation (e.g., Javadoc for classes/methods).
 *     *   Ensure proper encapsulation (private fields).
 *     *   Include basic input validation where applicable (e.g., checking if description is empty, though not strictly required by components list, it's good practice). Check if queue is empty before processing.
 * 
 * **Required Components Checklist:**
 * 
 * *   [ ] `java.util.Queue`
 * *   [ ] `java.util.ArrayList`
 * *   [ ] `java.util.List`
 * *   [ ] `java.util.Scanner`
 * *   [ ] `switch` statement
 * *   [ ] `System.err`
 * *   [ ] `System.out`
 * *   [ ] `try-catch` blocks
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, accept user input, perform the requested actions, and provide feedback (success or error messages) using the appropriate output streams. Ticket listings should clearly show ID, description, and status.
 * 
 * ---
 * 
 * **Example Interaction Flow:**
 * 
 * ```
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 1
 * Enter ticket description: My printer isn't working.
 * Ticket #1 added.
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 1
 * Enter ticket description: Software installation failed.
 * Ticket #2 added.
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 3
 * --- Open Tickets ---
 * [ID: 1, Description: My printer isn't working., Status: OPEN]
 * [ID: 2, Description: Software installation failed., Status: OPEN]
 * --------------------
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 2
 * Processing ticket #1: My printer isn't working.
 * Ticket #1 resolved.
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 3
 * --- Open Tickets ---
 * [ID: 2, Description: Software installation failed., Status: OPEN]
 * --------------------
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 4
 * --- Resolved Tickets ---
 * [ID: 1, Description: My printer isn't working., Status: RESOLVED]
 * ----------------------
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 2
 * Processing ticket #2: Software installation failed.
 * Ticket #2 resolved.
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 2
 * Error: No tickets currently in the queue to process.
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 6
 * Error: Invalid option. Please try again.
 * 
 * Help Desk Menu:
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Open Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter option: 5
 * Exiting Help Desk System.
 * ```
 *
 * EXPLANATION:
 * The provided solution implements a simple Help Desk Ticket Management System as requested, demonstrating the use of all specified Java components and following best practices.
 * 
 * **Key Components and Concepts Demonstrated:**
 * 
 * 1.  **`Ticket` Class:**
 *     *   Represents the data structure for a single ticket with `id`, `description`, and `status`.
 *     *   Uses `private` fields for encapsulation, ensuring data is accessed and modified only through public methods (getters and a setter for status).
 *     *   The `toString()` method provides a convenient way to display ticket information.
 * 
 * 2.  **`HelpDeskSystem` Class:**
 *     *   This is the main class managing the ticket system.
 *     *   **`java.util.Queue<Ticket> openTickets`**: A `Queue` (implemented using `LinkedList`) is used for open tickets. This naturally models a First-In, First-Out (FIFO) processing order, where the oldest ticket added is the next one to be processed. Methods like `offer()` (to add) and `poll()` (to remove the head) are used.
 *     *   **`java.util.List<Ticket> resolvedTickets`**: A `List` (implemented using `ArrayList`) is used to store tickets once they are resolved. An `ArrayList` is suitable here as we just need to store and potentially iterate through the resolved tickets; order of addition is maintained, and random access isn't a primary requirement, but `ArrayList` is a common and efficient choice for a dynamic list.
 *     *   **`nextTicketId`**: A simple integer counter to generate unique IDs for new tickets, incremented each time a ticket is added.
 *     *   **Methods (`addTicket`, `processNextTicket`, `viewOpenTickets`, `viewResolvedTickets`)**: These methods encapsulate the core logic of the system, operating on the `openTickets` queue and `resolvedTickets` list. They demonstrate how to add, remove, and iterate through elements in these collections. `processNextTicket` includes a check for an empty queue before attempting `poll()`.
 * 
 * 3.  **User Interface (`run` method):**
 *     *   **`java.util.Scanner`**: Used to read user input from the console (`System.in`). `scanner.nextLine()` is used to read entire lines, which is generally safer than `nextInt()` or `nextDouble()` after `nextLine()` calls due to how the scanner cursor works.
 *     *   **`switch` statement**: Controls the program flow based on the user's menu choice. Each `case` corresponds to a menu option, calling the appropriate `HelpDeskSystem` method. The `default` case handles invalid input.
 *     *   The `while(running)` loop keeps the system active until the user chooses to exit.
 * 
 * 4.  **Error Handling:**
 *     *   **`System.err`**: Used specifically for printing error messages (e.g., "No tickets currently in the queue to process.", "Invalid option.", errors caught by the `try-catch`). This is good practice to separate errors from standard output.
 *     *   **`System.out`**: Used for all normal program output, including the menu, prompts, success messages, and listing tickets.
 *     *   **`try-catch` blocks**: A `try-catch(Exception e)` block wraps the main `while` loop in the `run()` method. This provides class-wide exception handling for the user interaction process. If any unexpected exception occurs during the execution of the menu loop (e.g., issues with input/output, though less likely with this simple design), it will be caught, an error message printed to `System.err`, and the program can potentially continue or exit gracefully depending on the exception and desired behavior (here it just prints the error and continues the loop). A `finally` block ensures the `Scanner` is closed to release system resources. Basic input validation (checking for empty description) is also included in `addTicket`.
 * 
 * 5.  **Best Practices:**
 *     *   Meaningful names (`openTickets`, `processNextTicket`, `description`).
 *     *   Basic Javadoc comments explain the purpose of classes and methods.
 *     *   Private fields enforce encapsulation.
 *     *   The code is structured into logical methods within the `HelpDeskSystem` class.
 * 
 * This solution effectively integrates the required Java components into a functional, albeit simple, application, demonstrating key programming concepts like data structures, control flow, user interaction, and error handling in a practical context.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a single support ticket in the help desk system.
 */
class Ticket {
    private int id;
    private String description;
    private String status; // e.g., "OPEN", "RESOLVED"

    /**
     * Constructs a new Ticket.
     *
     * @param id The unique identifier for the ticket.
     * @param description The description of the issue.
     */
    public Ticket(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "OPEN"; // New tickets are open by default
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

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the Ticket.
     *
     * @return String representation of the ticket.
     */
    @Override
    public String toString() {
        return "[ID: " + id + ", Description: " + description + ", Status: " + status + "]";
    }
}

/**
 * Manages the collection of help desk tickets.
 */
public class HelpDeskSystem {
    // Queue to hold tickets that are pending/open (FIFO)
    private Queue<Ticket> openTickets;
    // List to hold tickets that have been resolved
    private List<Ticket> resolvedTickets;
    // Counter for generating unique ticket IDs
    private int nextTicketId;

    /**
     * Constructs a new HelpDeskSystem.
     */
    public HelpDeskSystem() {
        // Use LinkedList as a Queue implementation
        this.openTickets = new LinkedList<>();
        // Use ArrayList as a List implementation
        this.resolvedTickets = new ArrayList<>();
        this.nextTicketId = 1; // Start ID from 1
    }

    /**
     * Adds a new ticket to the system.
     *
     * @param description The description of the issue for the new ticket.
     */
    public void addTicket(String description) {
        if (description == null || description.trim().isEmpty()) {
             System.err.println("Error: Ticket description cannot be empty.");
             return;
        }
        Ticket newTicket = new Ticket(nextTicketId++, description.trim());
        openTickets.offer(newTicket); // offer() is preferred for queues, returns false if fails (rare for LinkedList)
        System.out.println("Ticket #" + newTicket.getId() + " added.");
    }

    /**
     * Processes the oldest ticket in the queue.
     * Removes it from the open queue, sets status to RESOLVED, and adds to resolved list.
     */
    public void processNextTicket() {
        // poll() retrieves and removes the head of the queue, returns null if queue is empty
        Ticket ticketToProcess = openTickets.poll();

        if (ticketToProcess == null) {
            System.err.println("Error: No tickets currently in the queue to process.");
        } else {
            System.out.println("Processing ticket #" + ticketToProcess.getId() + ": " + ticketToProcess.getDescription());
            ticketToProcess.setStatus("RESOLVED");
            resolvedTickets.add(ticketToProcess);
            System.out.println("Ticket #" + ticketToProcess.getId() + " resolved.");
        }
    }

    /**
     * Displays all tickets currently in the open queue.
     */
    public void viewOpenTickets() {
        System.out.println("--- Open Tickets ---");
        if (openTickets.isEmpty()) {
            System.out.println("No open tickets.");
        } else {
            // Iterate over the queue without removing elements
            for (Ticket ticket : openTickets) {
                System.out.println(ticket);
            }
        }
        System.out.println("--------------------");
    }

    /**
     * Displays all tickets that have been resolved.
     */
    public void viewResolvedTickets() {
        System.out.println("--- Resolved Tickets ---");
        if (resolvedTickets.isEmpty()) {
            System.out.println("No resolved tickets.");
        } else {
            // Iterate over the list
            for (Ticket ticket : resolvedTickets) {
                System.out.println(ticket);
            }
        }
        System.out.println("----------------------");
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\nHelp Desk Menu:");
        System.out.println("1. Add New Ticket");
        System.out.println("2. Process Next Ticket");
        System.out.println("3. View Open Tickets");
        System.out.println("4. View Resolved Tickets");
        System.out.println("5. Exit");
        System.out.print("Enter option: ");
    }

    /**
     * Runs the main interactive loop for the Help Desk System.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling for the main interaction loop
        try {
            while (running) {
                displayMenu();
                String option = scanner.nextLine(); // Read the whole line to avoid issues with nextInt()

                // Use a switch statement for menu navigation
                switch (option) {
                    case "1":
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();
                        addTicket(description);
                        break;
                    case "2":
                        processNextTicket();
                        break;
                    case "3":
                        viewOpenTickets();
                        break;
                    case "4":
                        viewResolvedTickets();
                        break;
                    case "5":
                        System.out.println("Exiting Help Desk System.");
                        running = false; // Set flag to exit loop
                        break;
                    default:
                        // Handle invalid input
                        System.err.println("Error: Invalid option. Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // Optionally print stack trace for debugging during development/testing
            // e.printStackTrace(System.err);
        } finally {
            // Ensure the scanner is closed regardless of how the loop exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Main method to start the Help Desk System application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HelpDeskSystem system = new HelpDeskSystem();
        system.run(); // Start the main interactive loop
    }
}
