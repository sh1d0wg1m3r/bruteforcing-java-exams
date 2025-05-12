/*
 * Exam Question #25
 * Generated on: 2025-05-11 21:44:58
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Technical Support Ticket System
 * 
 * **Objective:** Design and implement a simple console-based technical support ticket system that manages incoming support requests. This task requires you to apply core Java concepts including collections, control flow, user input handling, and exception management.
 * 
 * **Scenario:**
 * 
 * You are building the core logic for a technical support system. Incoming support requests (tickets) are added to a queue to be processed in the order they are received. Once a ticket is processed, it is moved to a list of completed tickets. Users should be able to interact with the system via a command-line interface to add new tickets, process the next pending ticket, view pending tickets, view processed tickets, and search for a ticket by its ID.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to store incoming (pending) support tickets.
 *     *   Use a `java.util.ArrayList` to store processed support tickets.
 *     *   Use the `java.util.List` interface type when declaring the processed tickets collection variable.
 * 
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user.
 * 
 * 3.  **Control Flow:**
 *     *   Use a `switch` statement to handle the different menu options selected by the user.
 * 
 * 4.  **Output:**
 *     *   Use `System.out.println()` for displaying the menu, system status, ticket details, and confirmation messages.
 *     *   Use `System.err.println()` for displaying error messages (e.g., invalid input, empty queue, ticket not found).
 * 
 * 5.  **Exception Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks within the main application class (`ExamTicketSystem`). This should catch potential runtime errors during user interaction (like invalid number format) or unexpected issues.
 *     *   Additionally, implement specific checks and error reporting (using `System.err`) for operational issues like attempting to process a ticket when the queue is empty or searching for a non-existent ticket.
 * 
 * 6.  **Object-Oriented Design:**
 *     *   Create a `SupportTicket` class with private fields for `id`, `description`, and `status` (e.g., "Pending", "Processed"). Implement appropriate public getter methods. The `id` should be automatically generated and unique for each ticket.
 *     *   Create a `TicketSystem` class to manage the `Queue` and `List`. This class should have public methods for adding a ticket, processing the next ticket, retrieving pending tickets, retrieving processed tickets, and finding a ticket by ID.
 *     *   Ensure proper encapsulation (private fields, public methods).
 * 
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include comments or Javadoc to explain the purpose of classes and methods.
 *     *   Validate user input where appropriate (e.g., ensuring ticket description is not empty, handling non-integer input for choices/IDs).
 *     *   Ensure the application can be cleanly exited.
 * 
 * **Menu Options:**
 * 
 * 1.  Add New Ticket
 * 2.  Process Next Ticket
 * 3.  List Pending Tickets
 * 4.  List Processed Tickets
 * 5.  Search Ticket by ID
 * 6.  Exit
 * 
 * **Expected Output:**
 * 
 * The program should display the menu, prompt for user input, and provide feedback based on the chosen action. Error messages should be clearly distinguishable using `System.err`. Listing options should display the tickets with their ID, description, and status.
 * 
 * **Example Interaction (Illustrative):**
 * 
 * ```
 * --- Support Ticket System Menu ---
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. List Pending Tickets
 * 4. List Processed Tickets
 * 5. Search Ticket by ID
 * 6. Exit
 * Enter your choice: 1
 * Enter ticket description: Printer not working
 * Ticket 1 added.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 1
 * Enter ticket description: Cannot connect to WiFi
 * Ticket 2 added.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tickets ---
 * [ID: 1, Description: Printer not working, Status: Pending]
 * [ID: 2, Description: Cannot connect to WiFi, Status: Pending]
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * Processed ticket: [ID: 1, Description: Printer not working, Status: Processed]
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Tickets ---
 * [ID: 2, Description: Cannot connect to WiFi, Status: Pending]
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 4
 * --- Processed Tickets ---
 * [ID: 1, Description: Printer not working, Status: Processed]
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 5
 * Enter Ticket ID to search: 2
 * Found Ticket: [ID: 2, Description: Cannot connect to WiFi, Status: Pending]
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 5
 * Enter Ticket ID to search: 99
 * Error: Ticket with ID 99 not found.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 7
 * Error: Invalid menu choice. Please enter a number between 1 and 6.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: exit
 * Error: Invalid input. Please enter a number.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 6
 * Exiting Support Ticket System.
 * ```
 * 
 * Your solution should provide the complete, runnable Java code for this system.
 *
 * EXPLANATION:
 * This solution implements a simple technical support ticket system, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`SupportTicket` Class:**
 *     *   Represents a single ticket with an auto-generated `id`, `description`, and `status`.
 *     *   Uses a `static int nextId` to ensure each new ticket gets a unique, sequential ID.
 *     *   Provides a constructor to create new tickets (initially "Pending") and a `markAsProcessed()` method to change the status.
 *     *   Includes a `toString()` method for easy printing of ticket details.
 *     *   Fields are `private` and accessed via public getters, adhering to encapsulation.
 * 
 * 2.  **`TicketSystem` Class:**
 *     *   Acts as the manager for the tickets.
 *     *   Uses `java.util.Queue<SupportTicket> pendingTickets` (implemented with `LinkedList`) to hold tickets awaiting processing, naturally supporting FIFO order.
 *     *   Uses `java.util.List<SupportTicket> processedTickets` (implemented with `ArrayList`) to store tickets once they are completed. Note the use of the `List` interface type for the variable declaration, fulfilling that requirement.
 *     *   `addNewTicket(String description)`: Creates a new `SupportTicket` and adds it to the `pendingTickets` queue using `offer()`. Includes basic input validation for the description and throws `IllegalArgumentException` if it's invalid.
 *     *   `processNextTicket()`: Uses `poll()` to retrieve and remove the head of the `pendingTickets` queue. If a ticket is retrieved, its status is updated, and it's added to the `processedTickets` list. Returns the processed ticket or `null` if the queue was empty, allowing the caller (`main`) to handle the "no tickets" scenario.
 *     *   `getPendingTickets()` and `getProcessedTickets()`: Provide access to the ticket lists. `getPendingTickets()` returns a *copy* of the queue's contents as a `List` to prevent external code from modifying the queue's structure directly, while `getProcessedTickets()` returns the direct `ArrayList` reference.
 *     *   `findTicketById(int id)`: Iterates through both the pending queue and the processed list to find a ticket by its ID. Returns the matching ticket or `null` if not found.
 * 
 * 3.  **`ExamTicketSystem` Class (Main Application):**
 *     *   Contains the `main` method, which is the entry point of the application.
 *     *   Uses `java.util.Scanner` to read input from `System.in`.
 *     *   Creates an instance of `TicketSystem`.
 *     *   The main application logic runs inside a `while(running)` loop, which is itself wrapped in a `try-catch(Exception e)` block. This fulfills the "class-wide exception handling" requirement by catching any unexpected exceptions that might propagate up.
 *     *   Inside the loop, it displays the menu using `System.out`.
 *     *   Reads the user's menu choice using `scanner.nextLine()`.
 *     *   A specific `try-catch(NumberFormatException e)` block is used immediately after reading the input to handle cases where the user enters non-numeric input for the menu choice. An error is printed to `System.err`, and the loop continues.
 *     *   A `switch` statement is used to process the valid integer choice, directing execution to the appropriate logic for each menu option.
 *     *   Each case within the `switch` calls the relevant method(s) in the `TicketSystem` instance.
 *     *   Input validation is done before calling `addNewTicket`.
 *     *   The return values of `processNextTicket()` and `findTicketById()` are checked (`!= null`) to determine if the operation was successful (ticket processed/found) or if an error condition occurred (empty queue/ticket not found). Error messages for these operational issues are printed to `System.err`.
 *     *   Specific `try-catch` blocks are used for `Integer.parseInt` when searching by ID to handle non-numeric ID input.
 *     *   The `Exit` option sets the `running` flag to `false`, terminating the loop.
 *     *   A `finally` block is used to ensure the `Scanner` resource is closed, regardless of whether the loop completes normally or an unexpected exception is caught.
 *     *   All normal output (menu, confirmations, lists) goes to `System.out`, while error messages go to `System.err`, as required.
 * 
 * This solution effectively integrates all the specified components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical, object-oriented design, demonstrating input validation, error handling, and clear code structure suitable for an advanced programming exam.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.NoSuchElementException; // Optional: if choosing to throw this instead of returning null

/**
 * Represents a single support ticket in the system.
 */
class SupportTicket {
    private static int nextId = 1; // Static counter for unique ticket IDs

    private int id;
    private String description;
    private String status; // e.g., "Pending", "Processed"

    /**
     * Constructs a new SupportTicket with a unique ID and initial status "Pending".
     *
     * @param description The description of the support issue.
     */
    public SupportTicket(String description) {
        this.id = nextId++; // Assign unique ID and increment counter
        this.description = description;
        this.status = "Pending";
    }

    // --- Getters ---
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
     * Marks the ticket status as "Processed".
     */
    public void markAsProcessed() {
        this.status = "Processed";
    }

    /**
     * Provides a string representation of the ticket.
     *
     * @return String representation including ID, description, and status.
     */
    @Override
    public String toString() {
        return "[ID: " + id + ", Description: " + description + ", Status: " + status + "]";
    }
}

/**
 * Manages the collection of support tickets, separating them into pending and processed.
 */
class TicketSystem {
    private Queue<SupportTicket> pendingTickets;
    private List<SupportTicket> processedTickets; // Using List interface type

    /**
     * Constructs a new TicketSystem, initializing the pending and processed ticket collections.
     */
    public TicketSystem() {
        // LinkedList is a common implementation for Queue
        this.pendingTickets = new LinkedList<>();
        // ArrayList is a common implementation for List
        this.processedTickets = new ArrayList<>();
    }

    /**
     * Adds a new ticket to the pending queue.
     *
     * @param description The description for the new ticket.
     * @return The newly created SupportTicket object.
     * @throws IllegalArgumentException if the description is null or empty.
     */
    public SupportTicket addNewTicket(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket description cannot be empty.");
        }
        SupportTicket newTicket = new SupportTicket(description.trim());
        pendingTickets.offer(newTicket); // offer is generally preferred over add for queues
        return newTicket;
    }

    /**
     * Processes the next ticket in the pending queue.
     * Moves the ticket from pending to processed and updates its status.
     *
     * @return The processed SupportTicket, or null if the pending queue is empty.
     */
    public SupportTicket processNextTicket() {
        SupportTicket nextTicket = pendingTickets.poll(); // poll returns null if queue is empty
        if (nextTicket != null) {
            nextTicket.markAsProcessed();
            processedTickets.add(nextTicket);
        }
        return nextTicket;
    }

    /**
     * Retrieves the list of pending tickets.
     *
     * @return A List view of the pending tickets (the actual Queue content).
     */
    public List<SupportTicket> getPendingTickets() {
        // Return a new ArrayList containing elements from the queue for easier iteration if needed,
        // or just return the queue reference if iteration logic is handled by caller.
        // Returning a new list prevents external modification of the internal queue structure directly
        // while still allowing iteration. For this exam, returning a snapshot as a List is fine.
         return new ArrayList<>(pendingTickets); // Return a copy for safety
    }

     /**
     * Retrieves the list of processed tickets.
     *
     * @return The List of processed tickets.
     */
    public List<SupportTicket> getProcessedTickets() {
        return processedTickets; // Return the direct list reference
    }


    /**
     * Finds a ticket by its ID in either the pending or processed lists.
     *
     * @param id The ID of the ticket to search for.
     * @return The found SupportTicket, or null if no ticket with the given ID exists.
     */
    public SupportTicket findTicketById(int id) {
        // Search pending tickets
        for (SupportTicket ticket : pendingTickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        // Search processed tickets
        for (SupportTicket ticket : processedTickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null; // Ticket not found
    }
}

/**
 * Main application class for the Support Ticket System console interface.
 * Handles user interaction, menu display, and delegates operations to TicketSystem.
 */
public class ExamTicketSystem {

    private static void displayMenu() {
        System.out.println("\n--- Support Ticket System Menu ---");
        System.out.println("1. Add New Ticket");
        System.out.println("2. Process Next Ticket");
        System.out.println("3. List Pending Tickets");
        System.out.println("4. List Processed Tickets");
        System.out.println("5. Search Ticket by ID");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketSystem ticketSystem = new TicketSystem();
        boolean running = true;

        // Class-wide exception handling around the main application loop
        try {
            while (running) {
                displayMenu();
                String input = scanner.nextLine();
                int choice = -1; // Default invalid choice

                // Specific exception handling for input parsing
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    continue; // Skip to next loop iteration
                }

                // Switch statement for flow control based on valid integer input
                switch (choice) {
                    case 1: // Add New Ticket
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();
                        try {
                            SupportTicket addedTicket = ticketSystem.addNewTicket(description);
                            System.out.println("Ticket " + addedTicket.getId() + " added.");
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case 2: // Process Next Ticket
                        SupportTicket processedTicket = ticketSystem.processNextTicket();
                        if (processedTicket != null) {
                            System.out.println("Processed ticket: " + processedTicket);
                        } else {
                            System.err.println("Error: No pending tickets to process.");
                        }
                        break;

                    case 3: // List Pending Tickets
                        List<SupportTicket> pending = ticketSystem.getPendingTickets();
                        System.out.println("--- Pending Tickets ---");
                        if (pending.isEmpty()) {
                            System.out.println("No pending tickets.");
                        } else {
                            for (SupportTicket ticket : pending) {
                                System.out.println(ticket);
                            }
                        }
                        break;

                    case 4: // List Processed Tickets
                        List<SupportTicket> processed = ticketSystem.getProcessedTickets();
                        System.out.println("--- Processed Tickets ---");
                        if (processed.isEmpty()) {
                            System.out.println("No processed tickets.");
                        } else {
                            for (SupportTicket ticket : processed) {
                                System.out.println(ticket);
                            }
                        }
                        break;

                    case 5: // Search Ticket by ID
                        System.out.print("Enter Ticket ID to search: ");
                        String idInput = scanner.nextLine();
                        try {
                            int searchId = Integer.parseInt(idInput);
                            SupportTicket foundTicket = ticketSystem.findTicketById(searchId);
                            if (foundTicket != null) {
                                System.out.println("Found Ticket: " + foundTicket);
                            } else {
                                System.err.println("Error: Ticket with ID " + searchId + " not found.");
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid ID format. Please enter a number.");
                        }
                        break;

                    case 6: // Exit
                        System.out.println("Exiting Support Ticket System.");
                        running = false; // Set flag to exit the loop
                        break;

                    default: // Invalid choice
                        System.err.println("Error: Invalid menu choice. Please enter a number between 1 and 6.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions that weren't handled specifically
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for debugging detailed stack trace
        } finally {
             // Ensure scanner is closed even if an exception occurs
            scanner.close();
            System.out.println("Scanner closed."); // Optional confirmation
        }
    }
}
