/*
 * Exam Question #1071
 * Generated on: 2025-05-12 17:20:50
 * Generated by: Account 2
 * 
 * QUESTION:
 * **Advanced Java Programming Exam: Support Ticket System**
 * 
 * **Problem Description:**
 * 
 * You are tasked with building a simplified Support Ticket System simulation. The system should allow users to submit support tickets, and "agents" (simulated by the system) to process these tickets in the order they were received. The system needs to keep track of pending tickets and completed tickets.
 * 
 * Your solution must demonstrate a solid understanding of core Java collections, input handling, control flow, and exception management.
 * 
 * **Requirements:**
 * 
 * 1.  **Ticket Representation:** Create a `SupportTicket` class with the following:
 *     *   A unique integer ID (automatically generated, starting from 1).
 *     *   A `String` description of the issue.
 *     *   A `TicketStatus` enum (PENDING, COMPLETED).
 *     *   Appropriate private fields and public getter methods.
 *     *   A method to mark the ticket as completed.
 *     *   An informative `toString()` method.
 * 2.  **System Core:** Create a `TicketSystem` class with the following:
 *     *   A `Queue` to hold tickets that are currently pending processing (FIFO order). Use `java.util.Queue`.
 *     *   An `ArrayList` to store tickets that have been processed and marked as completed. Use `java.util.ArrayList`.
 *     *   A method `submitTicket(String description)`: Creates a new `SupportTicket` and adds it to the pending queue.
 *     *   A method `processNextTicket()`: Removes the next ticket from the pending queue, marks it as `COMPLETED`, and adds it to the completed list. If the queue is empty, it should indicate that no tickets were processed.
 *     *   A method `getPendingTickets()`: Returns a `List` (using `java.util.List` interface) containing the tickets currently in the pending queue. The original queue should remain unchanged.
 *     *   A method `getCompletedTickets()`: Returns a `List` (using `java.util.List` interface) containing the tickets in the completed list.
 * 3.  **User Interface:** Create a `Main` class with a `main` method to provide a simple text-based interface using `Scanner`. The interface should present a menu with the following options:
 *     *   1. Submit New Ticket
 *     *   2. Process Next Ticket
 *     *   3. View Pending Tickets
 *     *   4. View Completed Tickets
 *     *   0. Exit
 * 4.  **Control Flow:** Use a `switch` statement in the `main` method to handle the user's menu selection.
 * 5.  **Input Handling:** Use `Scanner` to read user input for menu choices and ticket descriptions.
 * 6.  **Error Handling:**
 *     *   Implement input validation: Ensure the ticket description is not empty or just whitespace. If invalid, print an error message.
 *     *   Handle non-integer input for the menu choice using a `try-catch` block in the `main` method. Print an error message using `System.err.println()` and clear the invalid input from the scanner.
 *     *   If the user tries to process a ticket when the pending queue is empty, print a message to `System.out.println()`.
 *     *   If there are no pending or completed tickets to view, print appropriate messages to `System.out.println()`.
 * 7.  **Output:**
 *     *   Use `System.out.println()` for menu display, successful operations, and lists of tickets.
 *     *   Use `System.err.println()` for error messages related to invalid input or potential system issues (like a theoretical processing failure, though the simulation is simple).
 * 8.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadoc is encouraged but basic inline comments are acceptable).
 *     *   Ensure resources like `Scanner` are closed properly.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, accept user input, perform the requested action, and provide feedback. Examples:
 * 
 * ```
 * --- Support Ticket System Menu ---
 * 1. Submit New Ticket
 * 2. Process Next Ticket
 * 3. View Pending Tickets
 * 4. View Completed Tickets
 * 0. Exit
 * Enter your choice: 1
 * Enter ticket description: My printer is not working.
 * Ticket submitted successfully. Ticket ID: 1
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * Processing ticket: [ID: 1, Description: My printer is not working., Status: PENDING]
 * Ticket 1 marked as COMPLETED.
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
 * --- Completed Tickets ---
 * [ID: 1, Description: My printer is not working., Status: COMPLETED]
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: abc
 * Invalid input. Please enter a number.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * No tickets in the pending queue to process.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 0
 * Exiting system.
 * ```
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation of all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`).
 * *   Correct implementation of the Support Ticket System logic (submitting, processing, viewing).
 * *   Effective use of encapsulation and meaningful names.
 * *   Robust input validation and error handling as specified.
 * *   Clear and correct output formatting.
 * *   Adherence to best practices.
 *
 * EXPLANATION:
 * This solution implements a simple Support Ticket System, fulfilling all the requirements of the exam question.
 * 
 * 1.  **`SupportTicket` Class:**
 *     *   Represents a single ticket with `id`, `description`, and `status`.
 *     *   A `static int nextId` ensures each ticket gets a unique, sequential ID.
 *     *   `TicketStatus` enum provides clear, type-safe status values (`PENDING`, `COMPLETED`).
 *     *   Encapsulation is used with private fields and public getter methods.
 *     *   `markCompleted()` modifies the status, controlled internally by the `TicketSystem`.
 *     *   `toString()` provides a user-friendly representation of the ticket object.
 * 
 * 2.  **`TicketSystem` Class:**
 *     *   Uses a `java.util.Queue<SupportTicket>` (`LinkedList` implementation) for `pendingTickets`. The `Queue` interface guarantees FIFO behavior, which is appropriate for processing tickets in the order they are submitted. `offer()` is used for adding, and `poll()` for removing, adhering to standard queue operations.
 *     *   Uses a `java.util.ArrayList<SupportTicket>` for `completedTickets`. `ArrayList` is suitable for storing and accessing completed items randomly if needed, though here it's primarily used for iteration.
 *     *   `submitTicket()` creates a new ticket and adds it to the `pendingTickets` queue.
 *     *   `processNextTicket()` uses `poll()` to get the head of the queue. If `poll()` returns `null`, it means the queue was empty, and an appropriate message is printed to `System.out`. Otherwise, the ticket's status is updated, and it's added to the `completedTickets` `ArrayList`.
 *     *   `getPendingTickets()` and `getCompletedTickets()` methods return the ticket collections using the `java.util.List` interface. This demonstrates programming to an interface. Importantly, `getPendingTickets()` returns a *copy* of the queue's contents in a new `ArrayList` to prevent external modification of the internal queue structure. `getCompletedTickets()` returns an `unmodifiableList` wrapper for the same reason of protecting internal state.
 * 
 * 3.  **`Main` Class:**
 *     *   Contains the `main` method, the entry point of the application.
 *     *   A `java.util.Scanner` is used to read user input from the console. It is properly closed at the end.
 *     *   A `while` loop keeps the menu running until the user chooses to exit.
 *     *   The `switch` statement effectively handles the different menu options, directing the flow based on the user's integer input.
 *     *   **Input Validation:**
 *         *   For ticket submission, `description.trim().isEmpty()` checks if the entered description is empty or contains only whitespace. An error message is printed to `System.err` if invalid.
 *         *   For menu choice, a `try-catch (java.util.InputMismatchException e)` block is wrapped around `scanner.nextInt()`. This handles cases where the user enters non-integer input. An error message is printed to `System.err`, and `scanner.nextLine()` is called within the catch block to consume the invalid input line, preventing an infinite loop.
 *     *   **Error/Status Output:**
 *         *   `System.out.println()` is used for standard messages like the menu, successful operations, and lists of tickets.
 *         *   `System.err.println()` is specifically used for error messages resulting from invalid user input (non-integer choice, empty description).
 *     *   Messages for empty queues/lists when viewing or processing are printed to `System.out` as they indicate the *state* of the system, not an *error* in processing.
 *     *   A general `catch (Exception e)` is included as a fallback for any other unexpected errors, printing a message to `System.err`.
 *     *   The `printMenu()` helper method keeps the `main` method cleaner.
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, demonstrating encapsulation, meaningful naming, input validation, and error handling, making it a suitable challenging exam question. The use of `List` interface for return types and the distinction between `System.out` and `System.err` showcase attention to detail and best practices.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Collections; // Used for unmodifiable list

// Represents the status of a support ticket
enum TicketStatus {
    PENDING,
    COMPLETED
}

// Represents a single support ticket
class SupportTicket {
    private static int nextId = 1; // Static counter for unique IDs

    private int id;
    private String description;
    private TicketStatus status;

    /**
     * Constructs a new SupportTicket with PENDING status.
     * @param description The description of the issue.
     */
    public SupportTicket(String description) {
        this.id = nextId++;
        this.description = description;
        this.status = TicketStatus.PENDING;
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

    /**
     * Marks the ticket status as COMPLETED.
     */
    public void markCompleted() {
        this.status = TicketStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return "[ID: " + id + ", Description: " + description + ", Status: " + status + "]";
    }
}

// Manages the collection of support tickets
class TicketSystem {
    // Queue for tickets waiting to be processed (FIFO)
    private Queue<SupportTicket> pendingTickets;
    // List for tickets that have been completed
    private List<SupportTicket> completedTickets;

    /**
     * Constructs a new TicketSystem.
     */
    public TicketSystem() {
        // LinkedList implements Queue and is suitable for FIFO
        this.pendingTickets = new LinkedList<>();
        // ArrayList is suitable for storing completed items
        this.completedTickets = new ArrayList<>();
    }

    /**
     * Submits a new ticket to the pending queue.
     * @param description The description of the new ticket.
     */
    public void submitTicket(String description) {
        SupportTicket newTicket = new SupportTicket(description);
        // offer() is generally preferred over add() for queues as it returns false on failure
        if (pendingTickets.offer(newTicket)) {
            System.out.println("Ticket submitted successfully. Ticket ID: " + newTicket.getId());
        } else {
            // This case is rare with LinkedList unless memory is exhausted
            System.err.println("Failed to submit ticket. Queue might be full.");
        }
    }

    /**
     * Processes the next ticket from the pending queue.
     * Marks it as completed and moves it to the completed list.
     * @return The processed ticket, or null if the queue was empty.
     */
    public SupportTicket processNextTicket() {
        // poll() retrieves and removes the head of the queue, returns null if empty
        SupportTicket ticketToProcess = pendingTickets.poll();

        if (ticketToProcess != null) {
            System.out.println("Processing ticket: " + ticketToProcess);
            ticketToProcess.markCompleted();
            completedTickets.add(ticketToProcess);
            System.out.println("Ticket " + ticketToProcess.getId() + " marked as COMPLETED.");
            return ticketToProcess;
        } else {
            System.out.println("No tickets in the pending queue to process.");
            return null;
        }
    }

    /**
     * Returns a list of tickets currently in the pending queue.
     * Does not remove tickets from the queue.
     * @return A List of pending tickets. Returns an empty list if queue is empty.
     */
    public List<SupportTicket> getPendingTickets() {
        // Create a new ArrayList from the queue's elements to return a List view
        // without exposing the internal Queue implementation or allowing modification
        // of the queue via the returned list.
        return new ArrayList<>(pendingTickets);
    }

    /**
     * Returns a list of tickets that have been completed.
     * @return A List of completed tickets. Returns an empty list if no tickets are completed.
     */
    public List<SupportTicket> getCompletedTickets() {
        // Returning the internal list directly is acceptable here,
        // but returning an unmodifiable list is safer practice.
        return Collections.unmodifiableList(completedTickets);
    }
}

// Main class for the Support Ticket System interface
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketSystem ticketSystem = new TicketSystem();
        boolean running = true;

        System.out.println("--- Welcome to the Support Ticket System ---");

        // Class-wide exception handling for Scanner input
        while (running) {
            printMenu();
            int choice = -1; // Default invalid choice

            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt(); // May throw InputMismatchException
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Use a switch statement for menu control
                switch (choice) {
                    case 1: // Submit New Ticket
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine().trim(); // Read line and trim whitespace

                        // Input validation for description
                        if (description.isEmpty()) {
                            System.err.println("Error: Ticket description cannot be empty.");
                        } else {
                            ticketSystem.submitTicket(description);
                        }
                        break;

                    case 2: // Process Next Ticket
                        ticketSystem.processNextTicket();
                        break;

                    case 3: // View Pending Tickets
                        List<SupportTicket> pending = ticketSystem.getPendingTickets(); // Use List interface
                        System.out.println("--- Pending Tickets ---");
                        if (pending.isEmpty()) {
                            System.out.println("No pending tickets.");
                        } else {
                            // Iterate and print using the List
                            for (SupportTicket ticket : pending) {
                                System.out.println(ticket);
                            }
                        }
                        break;

                    case 4: // View Completed Tickets
                        List<SupportTicket> completed = ticketSystem.getCompletedTickets(); // Use List interface
                        System.out.println("--- Completed Tickets ---");
                        if (completed.isEmpty()) {
                            System.out.println("No completed tickets.");
                        } else {
                            // Iterate and print using the List
                            for (SupportTicket ticket : completed) {
                                System.out.println(ticket);
                            }
                        }
                        break;

                    case 0: // Exit
                        System.out.println("Exiting system.");
                        running = false;
                        break;

                    default: // Invalid choice
                        System.err.println("Invalid choice. Please enter a number between 0 and 4.");
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                // Handle non-integer input for menu choice
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input line to prevent infinite loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging
            }

            System.out.println(); // Add a blank line for readability
        }

        scanner.close(); // Close the scanner resource
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Support Ticket System Menu ---");
        System.out.println("1. Submit New Ticket");
        System.out.println("2. Process Next Ticket");
        System.out.println("3. View Pending Tickets");
        System.out.println("4. View Completed Tickets");
        System.out.println("0. Exit");
    }
}
