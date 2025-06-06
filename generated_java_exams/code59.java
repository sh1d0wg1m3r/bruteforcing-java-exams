/*
 * Exam Question #59
 * Generated on: 2025-05-11 22:06:59
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Technical Support Ticket Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified technical support ticket management system. The system needs to handle incoming support requests, assign them to agents, and track their resolution. This system will be console-based for this exam.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this system with the following features:
 * 
 * 1.  **Ticket Representation:** Create a `Ticket` class with the following private fields:
 *     *   `ticketId` (an integer, automatically generated and unique for each new ticket)
 *     *   `description` (a String describing the issue)
 *     *   `status` (a String, e.g., "Waiting", "Assigned", "Resolved")
 *     *   Include a constructor, getter methods for all fields, and a method to update the status.
 * 
 * 2.  **System Logic:** Implement a main class (e.g., `SupportSystem`) with the following functionality accessible via a console menu:
 *     *   **Add New Ticket:** Prompt the user for a ticket description, create a new `Ticket` object with status "Waiting", and add it to a collection of waiting tickets.
 *     *   **Assign Next Waiting Ticket:** If there are waiting tickets, remove the oldest one from the waiting collection, change its status to "Assigned", and add it to a collection of assigned tickets. If no tickets are waiting, report an error.
 *     *   **Resolve Assigned Ticket:** Prompt the user for a ticket ID. Search the assigned tickets collection for the ticket with the matching ID. If found, change its status to "Resolved" and remove it from the assigned tickets collection. If not found, report an error.
 *     *   **View Waiting Tickets:** Display all tickets currently in the waiting collection.
 *     *   **View Assigned Tickets:** Display all tickets currently in the assigned collection.
 *     *   **Exit:** Terminate the program.
 * 
 * 3.  **Component Usage:** Your solution **must** use ALL of the following Java components:
 *     *   `java.util.Queue`: To store tickets that are waiting to be assigned (First-In, First-Out order).
 *     *   `java.util.ArrayList`: As the concrete implementation for the collection of assigned tickets.
 *     *   `java.util.List`: As the interface type for the collection of assigned tickets variable.
 *     *   `java.util.Scanner`: To handle user input from the console.
 *     *   `switch` statement: To control the flow based on the user's menu choice.
 *     *   `System.err`: To output error messages (e.g., invalid input, ticket not found, queue empty).
 *     *   `System.out`: To output normal messages (menu, prompts, success messages, ticket details).
 *     *   Class-wide exception handling with `try-catch` blocks: To catch and handle potential exceptions during program execution.
 * 
 * 4.  **Best Practices:** Adhere to the following best practices:
 *     *   **Encapsulation:** `Ticket` class fields should be private with public accessors/mutators where appropriate.
 *     *   **Meaningful Names:** Use descriptive names for classes, variables, and methods.
 *     *   **Comments and Documentation:** Include comments to explain complex logic and document classes/methods briefly (Javadoc is a plus).
 *     *   **Input Validation:** Validate user input where necessary (e.g., ensuring menu choice is a number, checking if ticket ID exists).
 *     *   **Proper Error Handling:** Handle potential issues gracefully using `if` conditions, `try-catch`, and `System.err`.
 *     *   **Clean Code Structure:** Organize your code logically.
 * 
 * **Expected Output:**
 * 
 * Your program should present a menu and respond to user input. Error messages should go to `System.err`, and normal output to `System.out`.
 * 
 * Example interaction flow:
 * 
 * ```
 * --- Technical Support System ---
 * 
 * Select an option:
 * 1. Add New Ticket
 * 2. Assign Next Waiting Ticket
 * 3. Resolve Assigned Ticket
 * 4. View Waiting Tickets
 * 5. View Assigned Tickets
 * 6. Exit
 * Enter choice: 1
 * Enter ticket description: Printer not working
 * Ticket added: 1001
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 1
 * Enter ticket description: Software crash
 * Ticket added: 1002
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 4
 * 
 * --- Waiting Tickets ---
 * Ticket{id=1001, description='Printer not working', status='Waiting'}
 * Ticket{id=1002, description='Software crash', status='Waiting'}
 * -----------------------
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 2
 * Assigned ticket: 1001
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 4
 * 
 * --- Waiting Tickets ---
 * Ticket{id=1002, description='Software crash', status='Waiting'}
 * -----------------------
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 5
 * 
 * --- Assigned Tickets ---
 * Ticket{id=1001, description='Printer not working', status='Assigned'}
 * ------------------------
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 3
 * Enter Ticket ID to resolve: 1001
 * Ticket resolved: 1001
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 5
 * 
 * --- Assigned Tickets ---
 * No tickets currently assigned.
 * ------------------------
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 3
 * Enter Ticket ID to resolve: 9999
 * Ticket with ID 9999 not found in assigned tickets.
 * 
 * Select an option:
 * ... (menu repeats) ...
 * Enter choice: 6
 * Exiting system. Goodbye!
 * ```
 * 
 * Your solution should be a single `.java` file containing all necessary classes.
 * 
 * **Time Estimate:** 45-60 minutes.
 * 
 * **Evaluation:** Your solution will be evaluated based on correctness, adherence to all requirements (including component usage and best practices), code clarity, and error handling.
 *
 * EXPLANATION:
 * This solution implements a simplified technical support ticket management system, fulfilling all the requirements of the exam task.
 * 
 * 1.  **`Ticket` Class:**
 *     *   Represents a single support ticket with a unique ID, description, and status.
 *     *   Uses a `static` variable `nextId` to ensure each new ticket gets a unique, sequential ID starting from 1001.
 *     *   Fields (`ticketId`, `description`, `status`) are `private` demonstrating encapsulation.
 *     *   Includes public getter methods and a `setStatus` method for controlled access and modification.
 *     *   The `toString()` method provides a convenient way to print ticket information.
 * 
 * 2.  **`SupportSystem` Class:**
 *     *   Contains the main logic and manages the collections of tickets.
 *     *   `waitingTickets`: Declared as `Queue<Ticket>` and implemented using `LinkedList`. This correctly models the FIFO nature of a waiting line for tickets. `offer()` is used to add (enqueue), and `poll()` is used to remove (dequeue) the next ticket.
 *     *   `assignedTickets`: Declared as `List<Ticket>` and implemented using `ArrayList`. This allows for easy storage and iteration of currently assigned tickets. Using the `List` interface for the variable (`List<Ticket>`) while instantiating with `ArrayList` (`new ArrayList<>()`) demonstrates polymorphism and good practice. `add()` is used to add, and an `Iterator` is used for safe removal during iteration in the `resolveTicket` method.
 *     *   `scanner`: An instance of `Scanner` is used to read user input from `System.in`.
 *     *   **`run()` Method:** This is the main entry point for the system's interactive loop.
 *         *   It contains a `while(running)` loop that continues until the user chooses to exit.
 *         *   It includes a **class-wide `try-catch(Exception e)` block** wrapping the main loop. This handles any unexpected runtime exceptions that might occur within the system's operations, printing an error message to `System.err`. A `finally` block ensures the `scanner` is closed regardless of whether an exception occurred or the loop exited normally.
 *         *   A **`switch` statement** is used inside the loop to direct execution based on the integer choice returned by `getUserChoice()`.
 *     *   **Helper Methods (`printMenu`, `getUserChoice`, `addTicket`, `assignNextTicket`, `resolveTicket`, `viewWaitingTickets`, `viewAssignedTickets`):** These methods break down the system's functionality into smaller, manageable units, improving code readability and organization.
 *     *   **Input Validation:**
 *         *   `getUserChoice()` uses a `while` loop and `scanner.hasNextInt()` to ensure the user enters a valid integer for the menu choice, printing an error to `System.err` if not.
 *         *   `addTicket()` checks if the entered description is empty or null using `trim().isEmpty()`.
 *         *   `assignNextTicket()` checks if the `waitingTickets` queue is empty before attempting to poll from it, preventing errors and informing the user via `System.err`.
 *         *   `resolveTicket()` validates that the entered ticket ID is an integer and then iterates through the `assignedTickets` list to find the matching ID. It reports to `System.err` if the ID is not found in the assigned list.
 *     *   **Error Handling:** Specific error conditions (invalid menu choice, empty queue, ticket not found) are handled with conditional checks (`if`, `while`) and reported to `System.err`. The general `try-catch` in `run()` provides a fallback for unhandled exceptions.
 *     *   **Output:** `System.out.println()` is used for displaying the menu, prompts, success messages, and the contents of the ticket collections. `System.err.println()` is strictly used for error messages as required.
 * 
 * This solution effectively demonstrates the use of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch` in a practical, albeit simplified, application while adhering to core Java best practices. The complexity is appropriate for an exam setting, requiring careful handling of collections and user input with validation and error reporting.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Represents a technical support ticket.
 */
class Ticket {
    // Static counter for unique ticket IDs
    private static int nextId = 1001;

    private int ticketId;
    private String description;
    private String status; // e.g., "Waiting", "Assigned", "Resolved"

    /**
     * Constructs a new Ticket with a description.
     * ID is auto-generated, status is initially "Waiting".
     * @param description The description of the technical issue.
     */
    public Ticket(String description) {
        this.ticketId = nextId++;
        this.description = description;
        this.status = "Waiting";
    }

    // --- Getters ---
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
     * Updates the status of the ticket.
     * @param status The new status (e.g., "Assigned", "Resolved").
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Ticket object.
     */
    @Override
    public String toString() {
        return "Ticket{" +
               "id=" + ticketId +
               ", description='" + description + '\'' +
               ", status='" + status + '\'' +
               '}';
    }
}

/**
 * Manages the technical support ticket system.
 */
public class SupportSystem {

    // Queue to hold tickets waiting to be assigned (FIFO)
    private Queue<Ticket> waitingTickets;

    // List to hold tickets currently assigned to agents (using List interface, implemented by ArrayList)
    private List<Ticket> assignedTickets;

    // Scanner for reading user input
    private Scanner scanner;

    /**
     * Constructs a new SupportSystem, initializing collections and scanner.
     */
    public SupportSystem() {
        // Use LinkedList as a Queue implementation
        waitingTickets = new LinkedList<>();
        // Use ArrayList as a List implementation for assigned tickets
        assignedTickets = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Runs the main loop of the support system, displaying the menu and processing user choices.
     * Includes class-wide exception handling.
     */
    public void run() {
        System.out.println("--- Technical Support System ---");
        boolean running = true;

        // Class-wide exception handling block
        try {
            while (running) {
                printMenu();
                int choice = getUserChoice();

                // Switch statement for menu navigation
                switch (choice) {
                    case 1:
                        addTicket();
                        break;
                    case 2:
                        assignNextTicket();
                        break;
                    case 3:
                        resolveTicket();
                        break;
                    case 4:
                        viewWaitingTickets();
                        break;
                    case 5:
                        viewAssignedTickets();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        // Invalid choice handled by System.err
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            }
        } catch (Exception e) {
            // Catch and report any unexpected exceptions to System.err
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(System.err); // Uncomment for detailed debugging
        } finally {
            // Ensure the scanner is closed when the system exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Prints the main menu options to System.out.
     */
    private void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Add New Ticket");
        System.out.println("2. Assign Next Waiting Ticket");
        System.out.println("3. Resolve Assigned Ticket");
        System.out.println("4. View Waiting Tickets");
        System.out.println("5. View Assigned Tickets");
        System.out.println("6. Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Reads the user's menu choice from System.in with input validation.
     * @return The valid integer choice entered by the user.
     */
    private int getUserChoice() {
        // Validate that the input is an integer
        while (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input to prevent infinite loop
            System.out.print("Enter choice: ");
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left after nextInt()
        return choice;
    }

    /**
     * Adds a new ticket to the waiting queue based on user input.
     */
    private void addTicket() {
        System.out.print("Enter ticket description: ");
        String description = scanner.nextLine();

        // Input validation: Check if description is empty
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Ticket description cannot be empty.");
            return; // Exit method if description is invalid
        }

        Ticket newTicket = new Ticket(description.trim());
        waitingTickets.offer(newTicket); // Add ticket to the end of the queue
        System.out.println("Ticket added: " + newTicket.getTicketId());
    }

    /**
     * Assigns the next waiting ticket to the assigned list.
     */
    private void assignNextTicket() {
        // Input validation: Check if the waiting queue is empty
        if (waitingTickets.isEmpty()) {
            System.err.println("No tickets waiting to be assigned.");
            return; // Exit method if queue is empty
        }

        Ticket ticketToAssign = waitingTickets.poll(); // Remove the head of the queue
        ticketToAssign.setStatus("Assigned");
        assignedTickets.add(ticketToAssign); // Add ticket to the assigned list
        System.out.println("Assigned ticket: " + ticketToAssign.getTicketId());
    }

    /**
     * Resolves a ticket from the assigned list based on user-provided ID.
     */
    private void resolveTicket() {
        System.out.print("Enter Ticket ID to resolve: ");

        // Input validation: Ensure the input is an integer
        while (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Please enter a valid Ticket ID (number).");
            scanner.next(); // Consume invalid input
            System.out.print("Enter Ticket ID to resolve: ");
        }
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        boolean found = false;
        // Iterate through assigned tickets to find and remove the ticket
        // Using Iterator for safe removal while iterating
        Iterator<Ticket> iterator = assignedTickets.iterator();
        while (iterator.hasNext()) {
            Ticket ticket = iterator.next();
            if (ticket.getTicketId() == ticketId) {
                ticket.setStatus("Resolved");
                System.out.println("Ticket resolved: " + ticketId);
                iterator.remove(); // Safely remove the current ticket from the list
                found = true;
                break; // Exit the loop once the ticket is found and removed
            }
        }

        // Error handling: Report if the ticket was not found in the assigned list
        if (!found) {
            System.err.println("Ticket with ID " + ticketId + " not found in assigned tickets.");
        }
    }

    /**
     * Displays all tickets currently in the waiting queue.
     */
    private void viewWaitingTickets() {
        System.out.println("\n--- Waiting Tickets ---");
        if (waitingTickets.isEmpty()) {
            System.out.println("No tickets currently waiting.");
        } else {
            // Iterate through the queue without removing elements
            for (Ticket ticket : waitingTickets) {
                System.out.println(ticket);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Displays all tickets currently in the assigned list.
     */
    private void viewAssignedTickets() {
        System.out.println("\n--- Assigned Tickets ---");
        if (assignedTickets.isEmpty()) {
            System.out.println("No tickets currently assigned.");
        } else {
            // Iterate through the list
            for (Ticket ticket : assignedTickets) {
                System.out.println(ticket);
            }
        }
        System.out.println("------------------------");
    }

    /**
     * The main method to start the Support System application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SupportSystem system = new SupportSystem();
        system.run(); // Start the system's main loop
    }
}
