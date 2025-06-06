/*
 * Exam Question #661
 * Generated on: 2025-05-12 16:21:58
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Customer Support Ticket System Simulation
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified simulation of a customer support ticket system. The system should allow users (simulating support agents) to manage incoming support requests. New tickets arrive and are placed in a queue for processing. Agents can then process the next available ticket from the queue. Resolved tickets are archived.
 * 
 * Your solution must be a single Java application that runs from a `main` method. It should present a menu to the user and perform actions based on their input.
 * 
 * **Core Functionality:**
 * 
 * 1.  **Submit New Ticket:** Allows a user to enter a description for a new support ticket. The system assigns a unique ID and adds it to the queue of pending tickets.
 * 2.  **Process Next Ticket:** Removes the next ticket from the pending queue, marks it as resolved, and moves it to a list of resolved tickets. If the queue is empty, it should report that there are no tickets to process.
 * 3.  **View Pending Tickets:** Displays all tickets currently in the pending queue, in the order they will be processed.
 * 4.  **View Resolved Tickets:** Displays all tickets that have been processed and resolved.
 * 5.  **Exit:** Terminates the application.
 * 
 * **Technical Requirements:**
 * 
 * Your Java code must demonstrate proficiency in using the following Java components:
 * 
 * *   `java.util.Queue`: To manage the incoming support tickets in a First-In, First-Out (FIFO) manner.
 * *   `java.util.ArrayList`: To store the resolved tickets.
 * *   `java.util.List`: Use `List` as the declared type for the collection holding resolved tickets.
 * *   `java.util.Scanner`: To read user input from the console (menu choices and ticket descriptions).
 * *   `switch` statement: To handle the different menu options selected by the user.
 * *   `System.err`: To output error messages (e.g., invalid menu input, attempting to process from an empty queue).
 * *   `System.out`: To output normal messages (menu, ticket details, confirmations).
 * *   Class-wide exception handling: Use `try-catch` blocks to handle potential exceptions, particularly around user input operations that might fail (e.g., entering non-integer input for a menu option).
 * 
 * **Best Practices & Code Quality:**
 * 
 * *   **Encapsulation:** Design a `Ticket` class with private fields (`id`, `description`, `status`) and public getter methods. The support system logic should be within a separate class (`SupportTicketSystem`) managing the collections internally.
 * *   **Meaningful Names:** Use clear and descriptive names for variables, methods, and classes.
 * *   **Comments & Documentation:** Include appropriate comments (inline and/or Javadoc) to explain complex logic or the purpose of classes/methods.
 * *   **Input Validation:** Validate user input where necessary (e.g., ensure ticket description is not empty, handle non-integer menu input gracefully).
 * *   **Error Handling:** Implement robust error handling for scenarios like an empty queue or invalid input.
 * *   **Clean Code Structure:** Organize your code logically into classes and methods.
 * 
 * **Expected Output:**
 * 
 * The program should present a clear menu, prompt the user for input, and display appropriate messages and ticket information based on the chosen action. Error messages should go to `System.err`.
 * 
 * Example Interaction Snippet:
 * 
 * ```
 * --- Support Ticket System Menu ---
 * 1. Submit New Ticket
 * 2. Process Next Ticket
 * 3. View Pending Tickets
 * 4. View Resolved Tickets
 * 5. Exit
 * Enter your choice: 1
 * Enter ticket description: My internet is down.
 * Ticket 1 submitted successfully.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tickets ---
 * ID: 1, Description: My internet is down., Status: PENDING
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * Processing ticket 1: My internet is down.
 * Ticket 1 resolved.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tickets ---
 * No pending tickets.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 4
 * --- Resolved Tickets ---
 * ID: 1, Description: My internet is down., Status: RESOLVED
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: abc
 * Invalid input. Please enter a number.
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * System.err: No pending tickets to process.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Support Ticket System.
 * ```
 * 
 * Implement the complete Java code for this system.
 *
 * EXPLANATION:
 * This solution implements a basic customer support ticket system, demonstrating the required Java concepts in a practical scenario.
 * 
 * 1.  **Class Structure:**
 *     *   `Ticket` class: Encapsulates the data for a single ticket (ID, description, status). It uses private fields and public getters for proper encapsulation. An enum `TicketStatus` is used for clarity and type safety regarding the ticket state.
 *     *   `SupportTicketSystem` class: Contains the core logic for managing tickets. It holds the `pendingTickets` queue and the `resolvedTickets` list. It includes methods for each operation (submit, process, view pending, view resolved) and a `run` method to handle the main application loop and user interaction.
 * 
 * 2.  **Data Structures:**
 *     *   `Queue<Ticket> pendingTickets`: A `LinkedList` is used here because it implements the `Queue` interface and is efficient for adding elements to the end (`offer`) and removing elements from the beginning (`poll`), which is exactly what's needed for a FIFO ticket queue.
 *     *   `List<Ticket> resolvedTickets`: An `ArrayList` is used to store resolved tickets. It's declared as `List<Ticket>` to demonstrate programming against the interface rather than the concrete implementation, promoting flexibility. `ArrayList` is suitable here as we primarily add resolved tickets and iterate through them, and random access isn't a performance critical requirement in this simple example.
 * 
 * 3.  **User Input (`Scanner`) and Control Flow (`switch`):**
 *     *   A `Scanner` object reads user input from `System.in`.
 *     *   The `run` method contains a `while` loop that continues until the user chooses to exit (option 5).
 *     *   Inside the loop, a `switch` statement directs the program flow to the appropriate method based on the user's integer input. This clearly separates the handling logic for each menu option.
 * 
 * 4.  **Error Handling (`try-catch`, `System.err`):**
 *     *   A `try-catch` block is wrapped around the input reading (`scanner.nextInt()`) and the `switch` statement within the `run` method. This is crucial for handling `InputMismatchException` if the user enters non-integer text when prompted for a menu choice.
 *     *   Other potential issues, like attempting to process a ticket when the queue is empty, are handled using conditional checks (`pendingTickets.poll() != null`) and reported using `System.err.println()`.
 *     *   A general `catch (Exception e)` is included as a fallback for any other unexpected runtime errors, printing the error message and stack trace to `System.err`.
 *     *   Input validation for the ticket description (checking if it's empty) is also performed in the `submitTicket` method, reporting an error to `System.err`.
 * 
 * 5.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` is used for all normal program output, including the menu, confirmations, and ticket details.
 *     *   `System.err.println()` is strictly used for displaying error messages, as required.
 * 
 * 6.  **Best Practices:**
 *     *   **Encapsulation:** Demonstrated by the `Ticket` class and the private collections within `SupportTicketSystem`.
 *     *   **Meaningful Names:** Variables like `pendingTickets`, `resolvedTickets`, `nextTicketId`, methods like `submitTicket`, `processNextTicket`, and the `TicketStatus` enum are clearly named.
 *     *   **Comments:** Javadoc-style comments explain the purpose of classes and methods, and inline comments clarify specific logic (like consuming the newline after `nextInt()`).
 *     *   **Input Validation & Error Handling:** As described above, these are implemented to make the system more robust.
 *     *   **Clean Code:** The code is organized into logical units (classes, methods) and the `run` method clearly orchestrates the main loop and user interaction.
 * 
 * This solution effectively integrates all the required Java components and demonstrates key programming concepts suitable for an advanced exam task.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents the status of a support ticket.
 */
enum TicketStatus {
    PENDING,
    RESOLVED
}

/**
 * Represents a single support ticket.
 */
class Ticket {
    private int id;
    private String description;
    private TicketStatus status;

    /**
     * Constructs a new Ticket.
     * @param id The unique ID of the ticket.
     * @param description The description of the issue.
     */
    public Ticket(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = TicketStatus.PENDING; // New tickets are always pending
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public TicketStatus getStatus() {
        return status;
    }

    // --- Setter (for status change) ---
    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Description: " + description + ", Status: " + status;
    }
}

/**
 * Manages the collection of support tickets, including pending and resolved queues/lists.
 */
class SupportTicketSystem {
    // Using LinkedList as a Queue implementation
    private Queue<Ticket> pendingTickets;
    // Using ArrayList to store resolved tickets, declared as List interface
    private List<Ticket> resolvedTickets;
    private int nextTicketId; // Counter for unique ticket IDs

    /**
     * Constructs a new SupportTicketSystem.
     */
    public SupportTicketSystem() {
        this.pendingTickets = new LinkedList<>(); // LinkedList implements Queue
        this.resolvedTickets = new ArrayList<>(); // ArrayList implements List
        this.nextTicketId = 1; // Start ticket IDs from 1
    }

    /**
     * Submits a new ticket to the pending queue.
     * @param description The description of the ticket.
     */
    public void submitTicket(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Ticket description cannot be empty.");
            return;
        }
        Ticket newTicket = new Ticket(nextTicketId++, description.trim());
        pendingTickets.offer(newTicket); // offer is preferred over add for queues
        System.out.println("Ticket " + newTicket.getId() + " submitted successfully.");
    }

    /**
     * Processes the next ticket from the pending queue.
     * Moves the ticket to the resolved list.
     */
    public void processNextTicket() {
        // poll() retrieves and removes the head of the queue, returns null if empty
        Ticket ticketToProcess = pendingTickets.poll();

        if (ticketToProcess != null) {
            System.out.println("Processing ticket " + ticketToProcess.getId() + ": " + ticketToProcess.getDescription());
            ticketToProcess.setStatus(TicketStatus.RESOLVED);
            resolvedTickets.add(ticketToProcess);
            System.out.println("Ticket " + ticketToProcess.getId() + " resolved.");
        } else {
            System.err.println("No pending tickets to process.");
        }
    }

    /**
     * Displays all tickets currently in the pending queue.
     */
    public void viewPendingTickets() {
        System.out.println("--- Pending Tickets ---");
        if (pendingTickets.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            // Iterate through the queue without removing elements
            for (Ticket ticket : pendingTickets) {
                System.out.println(ticket);
            }
        }
    }

    /**
     * Displays all tickets that have been processed and resolved.
     */
    public void viewResolvedTickets() {
        System.out.println("--- Resolved Tickets ---");
        if (resolvedTickets.isEmpty()) {
            System.out.println("No resolved tickets.");
        } else {
            // Iterate through the list
            for (Ticket ticket : resolvedTickets) {
                System.out.println(ticket);
            }
        }
    }

    /**
     * Runs the main application loop, handling user interaction.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 5) {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt(); // Read integer input
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Use switch statement for flow control based on user choice
                switch (choice) {
                    case 1:
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();
                        submitTicket(description);
                        break;
                    case 2:
                        processNextTicket();
                        break;
                    case 3:
                        viewPendingTickets();
                        break;
                    case 4:
                        viewResolvedTickets();
                        break;
                    case 5:
                        System.out.println("Exiting Support Ticket System.");
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input specifically
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to stay in the loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to error stream
            }
            System.out.println(); // Add a blank line for readability
        }

        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("--- Support Ticket System Menu ---");
        System.out.println("1. Submit New Ticket");
        System.out.println("2. Process Next Ticket");
        System.out.println("3. View Pending Tickets");
        System.out.println("4. View Resolved Tickets");
        System.out.println("5. Exit");
    }

    /**
     * Main method to start the application.
     */
    public static void main(String[] args) {
        SupportTicketSystem system = new SupportTicketSystem();
        system.run();
    }
}
