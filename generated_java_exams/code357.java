/*
 * Exam Question #357
 * Generated on: 2025-05-11 22:59:47
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Technical Support Ticket Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application to manage technical support tickets. The system should handle incoming tickets, allow a technician to process one ticket at a time, and archive completed tickets.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this system with the following features:
 * 
 * 1.  **Ticket Representation:** Create a `Ticket` class with the following attributes:
 *     *   `ticketId` (int): A unique identifier for each ticket, automatically generated by the system.
 *     *   `description` (String): A brief description of the issue.
 *     *   `priority` (int): An integer representing the urgency (e.g., 1 for highest, 5 for lowest).
 *     *   `status` (enum `Status`): An enumeration with states like `PENDING`, `PROCESSING`, `COMPLETED`.
 * 
 * 2.  **System Management:** Create a `SupportSystem` class that manages the ticket collections and processing logic. It should contain:
 *     *   A `Queue<Ticket>` to hold tickets that are waiting to be processed (`pendingTickets`).
 *     *   A `List<Ticket>` (specifically an `ArrayList`) to store tickets that have been completed (`completedTickets`).
 *     *   A `Ticket` variable to hold the ticket currently being processed (`currentlyProcessingTicket`).
 *     *   Methods for:
 *         *   Adding a new ticket to the pending queue.
 *         *   Moving the next ticket from the pending queue to `currentlyProcessingTicket`.
 *         *   Completing the `currentlyProcessingTicket` and moving it to the completed list.
 *         *   Viewing all pending tickets.
 *         *   Viewing all completed tickets.
 * 
 * 3.  **User Interface:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user.
 *     *   Use a `switch` statement to handle the user's menu choice.
 * 
 * 4.  **Output and Error Handling:**
 *     *   Use `System.out` for displaying the menu, status updates, and ticket lists.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, queue is empty, no ticket being processed).
 *     *   Implement input validation for priority (e.g., ensure it's a positive integer within a reasonable range, like 1-5).
 *     *   Implement **class-wide exception handling** using a `try-catch` block around the main program loop in the `main` method to catch unexpected errors and provide a graceful exit or error report.
 * 
 * 5.  **Java Concepts & Best Practices:**
 *     *   Ensure all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `Switch`, `System.err`, `System.out`, `try-catch`) are used as specified.
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadocs are a plus but not strictly required for all methods within the exam timeframe - focus on clarity).
 *     *   Structure your code into logical classes.
 * 
 * **Menu Options:**
 * 
 * 1.  Add New Ticket
 * 2.  Process Next Ticket
 * 3.  Complete Current Ticket
 * 4.  View Pending Tickets
 * 5.  View Completed Tickets
 * 6.  Exit
 * 
 * **Expected Interaction:**
 * 
 * The program should start, display the menu, and wait for user input. Based on the input, it performs the requested action, displays results or errors, and loops back to the menu until the user chooses to exit.
 * 
 * Example flow:
 * ```
 * --- Support Ticket System ---
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. Complete Current Ticket
 * 4. View Pending Tickets
 * 5. View Completed Tickets
 * 6. Exit
 * Enter your choice: 1
 * Enter ticket description: Printer not working
 * Enter priority (1-5): 3
 * Ticket #1 added with priority 3.
 * 
 * --- Support Ticket System ---
 * ... (menu again)
 * Enter your choice: 1
 * Enter ticket description: Network connectivity issue
 * Enter priority (1-5): 1
 * Ticket #2 added with priority 1.
 * 
 * --- Support Ticket System ---
 * ... (menu again)
 * Enter your choice: 4
 * --- Pending Tickets ---
 * Ticket #1 (Priority: 3): Printer not working [PENDING]
 * Ticket #2 (Priority: 1): Network connectivity issue [PENDING]
 * 
 * --- Support Ticket System ---
 * ... (menu again)
 * Enter your choice: 2
 * Processing ticket #1 (Priority: 3): Printer not working
 * 
 * --- Support Ticket System ---
 * ... (menu again)
 * Enter your choice: 2
 * Error: A ticket is already being processed.
 * ... (Error message on System.err)
 * 
 * --- Support Ticket System ---
 * ... (menu again)
 * Enter your choice: 3
 * Ticket #1 completed.
 * 
 * --- Support Ticket System ---
 * ... (menu again)
 * Enter your choice: 5
 * --- Completed Tickets ---
 * Ticket #1 (Priority: 3): Printer not working [COMPLETED]
 * 
 * --- Support Ticket System ---
 * ... (menu again)
 * Enter your choice: 6
 * Exiting system.
 * ```
 * 
 * Your solution should compile and run correctly, demonstrating the usage of all specified Java components and adhering to best practices.
 * 
 * **Time Allotment:** 45-60 minutes.
 *
 * EXPLANATION:
 * This solution implements a simple Technical Support Ticket Management System as described in the exam question, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Status` Enum:** Defines the possible states of a ticket (`PENDING`, `PROCESSING`, `COMPLETED`), providing clear and type-safe status values.
 * 
 * 2.  **`Ticket` Class:** Represents a single ticket with `ticketId`, `description`, `priority`, and `status`.
 *     *   It uses private fields and public getter methods (`getTicketId`, `getDescription`, `getPriority`, `getStatus`) to enforce encapsulation.
 *     *   A setter (`setStatus`) is provided to allow updating the ticket's state.
 *     *   The constructor initializes a new ticket with a unique ID, description, priority, and sets its initial status to `PENDING`.
 *     *   The `toString()` method provides a convenient formatted string representation for printing ticket details.
 * 
 * 3.  **`SupportSystem` Class:** Manages the overall system logic and ticket collections.
 *     *   `private Queue<Ticket> pendingTickets;`: A `LinkedList` is used here because it implements the `Queue` interface and is suitable for adding to the end and removing from the beginning (FIFO - First-In, First-Out), which is typical for a waiting queue.
 *     *   `private List<Ticket> completedTickets;`: An `ArrayList` is used here, accessed via the `List` interface. `ArrayList` is efficient for storing and iterating over completed items, where order and access by index might be useful later (though not strictly required by this problem, it's a common use case for a list).
 *     *   `private Ticket currentlyProcessingTicket;`: Holds the single ticket a technician is actively working on. This adds a state management layer.
 *     *   `private int nextTicketId;`: Manages the generation of unique ticket IDs.
 *     *   **`addTicket()`:** Creates a new `Ticket` object and adds it to the `pendingTickets` queue using `offer()`. Increments the ID counter.
 *     *   **`processNextTicket()`:** Checks if a ticket is already being processed or if the pending queue is empty. If a ticket is available, it's retrieved using `poll()` (which removes it from the queue), its status is updated, and it's assigned to `currentlyProcessingTicket`. Error messages are printed to `System.err` for invalid states.
 *     *   **`completeProcessing()`:** Checks if a ticket is currently being processed. If so, it updates the status to `COMPLETED`, adds the ticket to the `completedTickets` list, and clears `currentlyProcessingTicket`. Error messages are printed to `System.err`.
 *     *   **`viewPendingTickets()`:** Iterates through the `pendingTickets` queue (using an enhanced for loop, which internally uses an iterator without removing elements) and prints each ticket's details to `System.out`.
 *     *   **`viewCompletedTickets()`:** Iterates through the `completedTickets` list and prints each ticket's details to `System.out`.
 *     *   **`viewCurrentTicket()`:** Displays the details of the ticket currently being processed, if any.
 *     *   **`displayMenu()`:** Prints the user options to `System.out`.
 * 
 * 4.  **`ExamQuestion` Class (Main Entry Point):**
 *     *   Contains the `main` method where the application execution begins.
 *     *   A `Scanner` is initialized to read user input.
 *     *   A `SupportSystem` object is created to manage the system state.
 *     *   The main application logic runs inside a `while(running)` loop.
 *     *   **Input Handling:**
 *         *   The `displayMenu()` is called, and the program waits for an integer choice using `scanner.nextInt()`.
 *         *   A `try-catch (InputMismatchException)` block specifically handles non-integer input for the menu choice, printing an error to `System.err` and consuming the invalid input using `scanner.next()` to prevent an infinite loop.
 *         *   `scanner.nextLine()` is called after `scanner.nextInt()` (and `scanner.next()`) to consume the leftover newline character, preventing issues with subsequent `scanner.nextLine()` calls for description input.
 *         *   Input validation for the ticket priority is implemented in a `while` loop within the `case 1` block, ensuring the user enters an integer between 1 and 5, also handling `InputMismatchException`.
 *     *   **`switch` Statement:** Directs the program flow based on the valid user choice, calling the appropriate method in the `SupportSystem` object. A `default` case handles invalid menu numbers.
 *     *   **Class-wide Exception Handling:** The entire `while(running)` loop is wrapped in a `try-catch (Exception e)` block. This demonstrates catching any unhandled exception that might occur within the loop's execution. While specific exception handling within methods is generally preferred, this structure fulfills the requirement of "class-wide" handling in the main execution flow. It prints a generic error message and the exception's message to `System.err`.
 *     *   **`finally` Block:** Ensures the `Scanner` is closed when the main `try` block is exited, whether normally (user chooses exit) or due to an exception, preventing resource leaks.
 * 
 * This solution effectively combines the required Java components (`Queue` via `LinkedList`, `List` via `ArrayList`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical, object-oriented structure, demonstrating encapsulation, input validation, and basic error handling, suitable for evaluating advanced Java understanding.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

// Enum for ticket status
enum Status {
    PENDING,
    PROCESSING,
    COMPLETED
}

// Represents a single support ticket
class Ticket {
    private int ticketId;
    private String description;
    private int priority;
    private Status status;

    /**
     * Constructs a new Ticket.
     * @param ticketId The unique ID for the ticket.
     * @param description The description of the issue.
     * @param priority The priority level (e.g., 1-5).
     */
    public Ticket(int ticketId, String description, int priority) {
        this.ticketId = ticketId;
        this.description = description;
        this.priority = priority;
        this.status = Status.PENDING; // New tickets are always pending
    }

    // --- Getters ---
    public int getTicketId() {
        return ticketId;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    // --- Setters ---
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the ticket.
     * @return Formatted string detailing the ticket.
     */
    @Override
    public String toString() {
        return String.format("Ticket #%d (Priority: %d): %s [%s]",
                             ticketId, priority, description, status);
    }
}

// Manages the collections and logic of the support system
class SupportSystem {
    private Queue<Ticket> pendingTickets;
    private List<Ticket> completedTickets; // Use ArrayList for completed
    private Ticket currentlyProcessingTicket;
    private int nextTicketId; // Counter for generating unique IDs

    /**
     * Constructs a new SupportSystem.
     */
    public SupportSystem() {
        // LinkedList is a common implementation for Queue
        this.pendingTickets = new LinkedList<>();
        // ArrayList is a common implementation for List
        this.completedTickets = new ArrayList<>();
        this.currentlyProcessingTicket = null; // No ticket being processed initially
        this.nextTicketId = 1; // Start ticket IDs from 1
    }

    /**
     * Adds a new ticket to the pending queue.
     * @param description The description of the issue.
     * @param priority The priority level (1-5).
     */
    public void addTicket(String description, int priority) {
        Ticket newTicket = new Ticket(nextTicketId++, description, priority);
        pendingTickets.offer(newTicket); // Use offer() for Queue
        System.out.println("Ticket #" + newTicket.getTicketId() + " added with priority " + newTicket.getPriority() + ".");
    }

    /**
     * Moves the next ticket from the pending queue to be processed.
     */
    public void processNextTicket() {
        if (currentlyProcessingTicket != null) {
            System.err.println("Error: A ticket is already being processed.");
            return;
        }

        // Use peek() to check without removing, then poll() to remove
        Ticket nextTicket = pendingTickets.peek();

        if (nextTicket == null) {
            System.err.println("Error: No pending tickets to process.");
            return;
        }

        // If we reached here, a ticket is available. Poll it.
        currentlyProcessingTicket = pendingTickets.poll();
        currentlyProcessingTicket.setStatus(Status.PROCESSING);
        System.out.println("Processing " + currentlyProcessingTicket + ".");
    }

    /**
     * Marks the currently processing ticket as completed and moves it to the completed list.
     */
    public void completeProcessing() {
        if (currentlyProcessingTicket == null) {
            System.err.println("Error: No ticket currently being processed.");
            return;
        }

        currentlyProcessingTicket.setStatus(Status.COMPLETED);
        completedTickets.add(currentlyProcessingTicket); // Add to completed list
        System.out.println("Ticket #" + currentlyProcessingTicket.getTicketId() + " completed.");
        currentlyProcessingTicket = null; // No ticket being processed anymore
    }

    /**
     * Displays all tickets currently in the pending queue.
     */
    public void viewPendingTickets() {
        System.out.println("--- Pending Tickets ---");
        if (pendingTickets.isEmpty()) {
            System.out.println("No tickets currently pending.");
        } else {
            // Iterate through the queue without removing elements
            for (Ticket ticket : pendingTickets) {
                System.out.println(ticket);
            }
        }
        System.out.println("-----------------------");
    }

    /**
     * Displays all tickets that have been completed.
     */
    public void viewCompletedTickets() {
        System.out.println("--- Completed Tickets ---");
        if (completedTickets.isEmpty()) {
            System.out.println("No tickets have been completed yet.");
        } else {
            // Iterate through the list
            for (Ticket ticket : completedTickets) {
                System.out.println(ticket);
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * Displays the ticket currently being processed, if any.
     */
    public void viewCurrentTicket() {
         if (currentlyProcessingTicket != null) {
             System.out.println("--- Currently Processing ---");
             System.out.println(currentlyProcessingTicket);
             System.out.println("--------------------------");
         } else {
             System.out.println("No ticket currently being processed.");
         }
    }

    /**
     * Displays the main menu options.
     */
    public void displayMenu() {
        System.out.println("\n--- Support Ticket System ---");
        System.out.println("1. Add New Ticket");
        System.out.println("2. Process Next Ticket");
        System.out.println("3. Complete Current Ticket");
        System.out.println("4. View Pending Tickets");
        System.out.println("5. View Completed Tickets");
        System.out.println("6. View Current Ticket"); // Added for completeness
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }
}

// Main class to run the application
public class ExamQuestion { // Renamed from main to ExamQuestion as requested by user prompt formatting implicitly
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupportSystem system = new SupportSystem();
        boolean running = true;

        // Class-wide exception handling for the main application loop
        try {
            while (running) {
                system.displayMenu();
                int choice = -1;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop and show menu again
                } finally {
                     scanner.nextLine(); // Consume the newline character left by nextInt()
                }


                switch (choice) {
                    case 1: // Add New Ticket
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();

                        int priority = -1;
                        boolean validPriority = false;
                        while (!validPriority) {
                            System.out.print("Enter priority (1-5): ");
                            try {
                                priority = scanner.nextInt();
                                if (priority >= 1 && priority <= 5) {
                                    validPriority = true;
                                } else {
                                    System.err.println("Error: Priority must be between 1 and 5.");
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Error: Invalid input. Please enter a number for priority.");
                                scanner.next(); // Consume invalid input
                            } finally {
                                scanner.nextLine(); // Consume newline
                            }
                        }
                        system.addTicket(description, priority);
                        break;

                    case 2: // Process Next Ticket
                        system.processNextTicket();
                        break;

                    case 3: // Complete Current Ticket
                        system.completeProcessing();
                        break;

                    case 4: // View Pending Tickets
                        system.viewPendingTickets();
                        break;

                    case 5: // View Completed Tickets
                        system.viewCompletedTickets();
                        break;

                    case 6: // View Current Ticket
                         system.viewCurrentTicket();
                         break;

                    case 7: // Exit
                        running = false;
                        System.out.println("Exiting system.");
                        break;

                    default:
                        System.err.println("Error: Invalid choice. Please enter a number from the menu.");
                }
            }
        } catch (Exception e) {
            // Class-wide catch for any unexpected errors during execution
            System.err.println("\nAn unexpected system error occurred!");
            System.err.println("Error details: " + e.getMessage());
            // Optionally print stack trace for debugging during development/testing
            // e.printStackTrace(System.err);
            System.err.println("System is shutting down due to error.");
        } finally {
             // Ensure scanner is closed regardless of how the loop exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
