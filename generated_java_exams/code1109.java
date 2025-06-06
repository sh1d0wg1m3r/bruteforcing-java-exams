/*
 * Exam Question #1109
 * Generated on: 2025-05-12 17:26:01
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Help Desk Ticket Management System
 * 
 * **Objective:** Design and implement a command-line application for a simplified Help Desk system. The system will manage incoming support tickets, allowing agents to process them in order.
 * 
 * **Scenario:** Incoming support requests are treated as tickets and are prioritized based on arrival time (First-In, First-Out). Agents can view the next ticket, process it (resolve it), and view lists of pending and resolved tickets.
 * 
 * **Requirements:**
 * 
 * 1.  **Core Functionality:** Implement a command-line interface with the following menu options:
 *     *   **1. Add New Ticket:** Prompt the user for a ticket description. Create a new ticket with a unique, sequential ID (starting from 1) and add it to the queue of pending tickets.
 *     *   **2. View Next Pending Ticket:** Display the details of the ticket that is next in line to be processed (at the front of the queue) without removing it.
 *     *   **3. Process Next Ticket:** Remove the ticket from the front of the pending queue and move it to a list of resolved tickets. Display the processed ticket's details.
 *     *   **4. View All Pending Tickets:** Display the details of all tickets currently in the pending queue, in their processing order.
 *     *   **5. View All Resolved Tickets:** Display the details of all tickets that have been processed/resolved.
 *     *   **0. Exit:** Terminate the application.
 * 
 * 2.  **Required Java Components:** Your solution **must** utilize ALL of the following Java components from the standard library:
 *     *   `java.util.Queue`: To manage the collection of pending tickets, ensuring FIFO order.
 *     *   `java.util.ArrayList`: To store the collection of resolved tickets.
 *     *   `java.util.List`: Declare the variable holding resolved tickets using the `List` interface type.
 *     *   `java.util.Scanner`: To read user input from the console for menu choices and ticket descriptions.
 *     *   `switch` statement: To handle the different menu options selected by the user.
 *     *   `System.err`: To display error messages (e.g., attempting to process/view from an empty queue/list, invalid input).
 *     *   `System.out`: To display the menu, prompts, success messages, and normal output (ticket details).
 *     *   Class-wide exception handling with `try-catch` blocks: Implement exception handling within the main operational method of your system class to catch and manage potential runtime errors, such as invalid input format.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Design appropriate classes (e.g., `Ticket`, `HelpDeskSystem`) with private fields and public methods to control access and maintain data integrity.
 *     *   **Meaningful Names:** Use clear and descriptive names for classes, variables, and methods.
 *     *   **Documentation:** Include basic comments or Javadoc to explain the purpose of classes and key methods.
 *     *   **Input Validation:** Validate user input where necessary (e.g., ensure a ticket description is provided, handle non-numeric menu input).
 *     *   **Error Handling:** Gracefully handle scenarios where operations cannot be performed (e.g., trying to process a ticket when the pending queue is empty).
 *     *   **Clean Code Structure:** Organize your code into logical classes and methods.
 * 
 * **Expected Output Behavior:**
 * 
 * *   The system should repeatedly display the menu and prompt for a choice until '0' is entered.
 * *   Adding a ticket should confirm the action.
 * *   Attempts to view or process tickets when the pending queue is empty should result in an informative error message printed to `System.err`.
 * *   Viewing resolved tickets when the list is empty should also print an informative message.
 * *   Invalid menu choices (non-numeric input or numbers outside the valid range) should be handled, displaying an error message on `System.err`, and the menu should be redisplayed.
 * *   All normal output (menu, prompts, ticket lists, success messages) should be printed to `System.out`.
 * 
 * **Constraints:**
 * 
 * *   The application is single-threaded.
 * *   Data does not need to persist after the application exits.
 * 
 * Your solution should consist of one or more Java files containing the complete code for the Help Desk system.
 *
 * EXPLANATION:
 * This solution implements the Help Desk Ticket Management System as required, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Ticket` class: A simple class representing a ticket with private fields (`id`, `description`) and public getter methods, demonstrating encapsulation. The `toString()` method provides a convenient way to display ticket information.
 *     *   `HelpDeskSystem` class: This is the main class managing the system logic. It contains the collections for tickets and the methods for performing operations. Encapsulation is used for the `pendingTickets`, `resolvedTickets`, and `nextTicketId` fields.
 *     *   `Main` class: A simple class with the `main` method to create an instance of `HelpDeskSystem` and start its execution loop.
 * 
 * 2.  **Collection Usage:**
 *     *   `java.util.Queue<Ticket> pendingTickets`: A `LinkedList` is used to implement the `Queue` interface. This correctly models the FIFO nature of pending tickets, where tickets are added to the back (`offer`) and processed from the front (`poll`). `peek()` is used to view the next ticket without removal.
 *     *   `java.util.List<Ticket> resolvedTickets`: An `ArrayList` is used to implement the `List` interface. This stores resolved tickets, allowing easy addition (`add`) and iteration. The variable is declared using the `List` interface type as required.
 * 
 * 3.  **User Interaction and Control Flow:**
 *     *   `java.util.Scanner`: Used in the `run()` method to read user input for menu choices and ticket descriptions from `System.in`.
 *     *   `switch` statement: Controls the flow of the program based on the user's numeric menu choice within the `run()` method's main loop.
 *     *   `System.out`: Used for printing the menu, prompts, success messages, and displaying the lists of tickets.
 *     *   `System.err`: Used specifically for printing error messages, such as invalid menu input or attempts to perform operations on empty queues/lists.
 * 
 * 4.  **Exception Handling:**
 *     *   `try-catch` blocks: The `run()` method contains a main `try-catch` block that wraps the entire operational loop. This serves as the "class-wide" exception handling for the main execution flow, catching any unexpected `Exception`.
 *     *   Nested `try-catch (InputMismatchException e)`: Inside the main loop, a specific `try-catch` block handles `InputMismatchException`, which occurs if the user enters non-integer input when a number is expected by `scanner.nextInt()`. This prevents the program from crashing and allows it to inform the user and continue. The `scanner.nextLine()` call within the catch block is crucial to consume the invalid input and prevent an infinite loop.
 *     *   `finally` block: Ensures that the `Scanner` resource is closed when the `run()` method finishes, whether normally or due to an exception.
 * 
 * 5.  **Input Validation and Error Handling:**
 *     *   In `addTicket`, the description is checked to ensure it's not null or empty using `if` statements, printing an error to `System.err` if invalid.
 *     *   Methods like `viewNextPendingTicket`, `processNextTicket`, `viewAllPendingTickets`, and `viewAllResolvedTickets` check if their respective collections are empty (`peek() == null`, `poll() == null`, `isEmpty()`) before attempting operations or printing, outputting informative messages to `System.out` or `System.err` as appropriate.
 *     *   The `switch` statement's `default` case handles valid integer inputs that do not correspond to a menu option, printing an error to `System.err`.
 * 
 * 6.  **Best Practices Implementation:**
 *     *   Private fields and public methods demonstrate proper encapsulation in both `Ticket` and `HelpDeskSystem`.
 *     *   Variable and method names (`pendingTickets`, `processNextTicket`, `viewAllResolvedTickets`, `nextTicketId`) are descriptive.
 *     *   Basic Javadoc and inline comments explain the purpose of classes, methods, and key logic sections.
 *     *   The code is structured logically into separate classes, enhancing readability and maintainability.
 * 
 * This solution effectively integrates the required Java components within a practical scenario, showcasing understanding of collection types, control flow, input handling, and robust error management in Java.
 */

import java.util.Queue;
import java.util.LinkedList; // Common implementation of Queue
import java.util.List;
import java.util.ArrayList; // Common implementation of List
import java.util.Scanner;
import java.util.InputMismatchException; // For handling non-integer input

/**
 * Represents a single Help Desk Ticket.
 * Encapsulates ticket ID and description.
 */
class Ticket {
    private int id;
    private String description;

    /**
     * Constructs a new Ticket.
     * @param id The unique identifier for the ticket.
     * @param description The description of the issue.
     */
    public Ticket(int id, String description) {
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
     * Provides a string representation of the Ticket.
     * @return Formatted string including ID and description.
     */
    @Override
    public String toString() {
        return "Ticket [ID=" + id + ", Description='" + description + "']";
    }
}

/**
 * Manages the Help Desk System, including pending and resolved tickets.
 * Provides a command-line interface for interaction.
 */
public class HelpDeskSystem {
    // Use Queue for pending tickets (FIFO)
    private Queue<Ticket> pendingTickets;
    // Use List interface and ArrayList for resolved tickets
    private List<Ticket> resolvedTickets;
    // Counter for assigning unique ticket IDs
    private int nextTicketId;

    /**
     * Constructs a new HelpDeskSystem, initializing collections and ticket counter.
     */
    public HelpDeskSystem() {
        this.pendingTickets = new LinkedList<>(); // LinkedList implements Queue
        this.resolvedTickets = new ArrayList<>(); // ArrayList implements List
        this.nextTicketId = 1; // Start ticket IDs from 1
    }

    /**
     * Adds a new ticket to the pending queue.
     * Validates that the description is not empty.
     * @param description The description of the ticket issue.
     */
    public void addTicket(String description) {
        // Input validation
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Ticket description cannot be empty.");
            return;
        }
        Ticket newTicket = new Ticket(nextTicketId++, description.trim());
        pendingTickets.offer(newTicket); // offer is preferred over add for queues
        System.out.println("Ticket added: " + newTicket);
    }

    /**
     * Displays the next ticket in the pending queue without removing it.
     * Handles the case where the queue is empty.
     */
    public void viewNextPendingTicket() {
        Ticket nextTicket = pendingTickets.peek(); // peek returns null if empty
        if (nextTicket == null) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("Next pending ticket: " + nextTicket);
        }
    }

    /**
     * Processes the next ticket in the pending queue, removing it and moving it to the resolved list.
     * Handles the case where the queue is empty.
     */
    public void processNextTicket() {
        Ticket processedTicket = pendingTickets.poll(); // poll returns null if empty
        if (processedTicket == null) {
            System.err.println("Error: No pending tickets to process.");
        } else {
            resolvedTickets.add(processedTicket);
            System.out.println("Processed ticket: " + processedTicket);
        }
    }

    /**
     * Displays all tickets currently in the pending queue.
     * Handles the case where the queue is empty.
     */
    public void viewAllPendingTickets() {
        if (pendingTickets.isEmpty()) {
            System.out.println("No pending tickets.");
        } else {
            System.out.println("--- Pending Tickets ---");
            // Iterate through the queue without removing elements
            int count = 1;
            for (Ticket ticket : pendingTickets) {
                System.out.println(count++ + ". " + ticket);
            }
            System.out.println("-----------------------");
        }
    }

    /**
     * Displays all tickets that have been resolved.
     * Handles the case where the list is empty.
     */
    public void viewAllResolvedTickets() {
        if (resolvedTickets.isEmpty()) {
            System.out.println("No resolved tickets.");
        } else {
            System.out.println("--- Resolved Tickets ---");
            // Iterate through the list
            for (int i = 0; i < resolvedTickets.size(); i++) {
                System.out.println((i + 1) + ". " + resolvedTickets.get(i));
            }
            System.out.println("------------------------");
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("\n--- Help Desk Menu ---");
        System.out.println("1. Add New Ticket");
        System.out.println("2. View Next Pending Ticket");
        System.out.println("3. Process Next Ticket");
        System.out.println("4. View All Pending Tickets");
        System.out.println("5. View All Resolved Tickets");
        System.out.println("0. Exit");
        System.out.println("----------------------");
    }

    /**
     * Runs the main interactive loop for the Help Desk System.
     * Includes class-wide exception handling for user input and operations.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Class-wide exception handling for the main operational loop
        try {
            while (choice != 0) {
                printMenu();
                System.out.print("Enter your choice: ");

                try {
                    // Read integer input for menu choice
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    // Using switch statement for flow control based on user choice
                    switch (choice) {
                        case 1: // Add ticket
                            System.out.print("Enter ticket description: ");
                            String description = scanner.nextLine();
                            addTicket(description);
                            break;
                        case 2: // View next pending
                            viewNextPendingTicket();
                            break;
                        case 3: // Process next
                            processNextTicket();
                            break;
                        case 4: // View all pending
                            viewAllPendingTickets();
                            break;
                        case 5: // View all resolved
                            viewAllResolvedTickets();
                            break;
                        case 0: // Exit
                            System.out.println("Exiting Help Desk System. Goodbye!");
                            break;
                        default:
                            // Handle choices outside the valid range
                            System.err.println("Invalid choice. Please enter a number between 0 and 5.");
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input specifically
                    System.err.println("Invalid input. Please enter a number corresponding to the menu option.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to ensure loop continues if input was invalid
                }
                // Add a small pause or newline for better readability between operations, unless exiting
                if (choice != 0) {
                     System.out.println();
                }
            }
        } catch (Exception e) {
            // General catch-all for any other unexpected errors during the run cycle
            System.err.println("An unexpected system error occurred: " + e.getMessage());
            // In a real application, you might want to log the full stack trace:
            // e.printStackTrace();
        } finally {
            // Ensure the scanner resource is closed when the system exits or an unhandled exception occurs
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Main method to start the Help Desk System.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HelpDeskSystem system = new HelpDeskSystem();
        system.run(); // Start the main application loop
    }
}
