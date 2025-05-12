/*
 * Exam Question #35
 * Generated on: 2025-05-11 21:52:28
 * 
 * QUESTION:
 * ## Java Programming Exam: Advanced Support Ticket Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified support ticket management system for a software company. The system needs to handle incoming support requests, queue them for processing, and allow agents to pick up and resolve tickets in the order they were received.
 * 
 * **Requirements:**
 * 
 * 1.  **System Functionality:**
 *     *   **Add New Ticket:** Allows users to submit a new support ticket with a description. Tickets should be assigned a unique ID automatically and added to a waiting queue.
 *     *   **Process Next Ticket:** Allows a support agent to take the next available ticket from the front of the queue. The system should report which ticket was processed. If the queue is empty, it should indicate that.
 *     *   **View Pending Tickets:** Display all tickets currently in the waiting queue, showing their ID and description.
 *     *   **View Available Agents:** Display a list of support agents available to process tickets. (For simplicity, agents are just names in this system).
 *     *   **Exit:** Terminate the application.
 * 
 * 2.  **Technical Constraints:**
 *     *   You **must** use the following Java components:
 *         *   `java.util.Queue` to manage the waiting line of support tickets.
 *         *   `java.util.ArrayList` to store the list of available support agents.
 *         *   `java.util.List` as the type declaration for the agent list variable (using `ArrayList` as the implementation).
 *         *   `java.util.Scanner` to read user input from the console for menu choices and ticket descriptions.
 *         *   `switch` statement to handle the main menu options.
 *         *   `System.err` for printing error messages (e.g., invalid input, attempting to process an empty queue).
 *         *   `System.out` for all normal output (menu, prompts, success messages, ticket/agent lists).
 *         *   Class-wide exception handling using `try-catch` blocks to manage potential runtime issues, especially around user input and queue operations.
 * 
 * 3.  **Design and Best Practices:**
 *     *   Create separate classes where appropriate (e.g., a `SupportTicket` class and a main system class).
 *     *   Implement proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments (Javadoc for classes/methods, inline comments for complex logic).
 *     *   Implement basic input validation (e.g., handle non-integer input for menu, ensure ticket description is not empty).
 *     *   Handle the case of processing a ticket when the queue is empty gracefully using `System.err`.
 *     *   Ensure clean code structure and formatting.
 * 
 * **Expected Output:**
 * 
 * The program should present a menu loop to the user. Based on the user's integer input, it performs the requested action. Output should be clear, indicating success or failure, and using `System.out` for normal information and `System.err` for errors.
 * 
 * Example interaction flow:
 * 
 * ```
 * --- Support Ticket System Menu ---
 * 1. Add New Ticket
 * 2. Process Next Ticket
 * 3. View Pending Tickets
 * 4. View Available Agents
 * 5. Exit
 * Enter your choice: 1
 * Enter ticket description: Printer not working
 * 
 * Ticket added successfully. ID: 1
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 1
 * Enter ticket description: Software crash on startup
 * 
 * Ticket added successfully. ID: 2
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 3
 * 
 * Pending Tickets:
 * [ID: 1, Description: Printer not working]
 * [ID: 2, Description: Software crash on startup]
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * 
 * Processing ticket: [ID: 1, Description: Printer not working]
 * Processed by an agent.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * 
 * Processing ticket: [ID: 2, Description: Software crash on startup]
 * Processed by an agent.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 2
 * System.err: Error: No tickets currently in the queue.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 6
 * System.err: Error: Invalid menu choice. Please enter a number between 1 and 5.
 * 
 * --- Support Ticket System Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Support Ticket System.
 * ```
 * 
 * **Task:**
 * 
 * Write the complete Java code for this Support Ticket Management System, adhering to all requirements and constraints.
 *
 * EXPLANATION:
 * This solution implements the `Support Ticket Management System` as described, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`SupportTicket` Class:**
 *     *   This class encapsulates the data for a single ticket: a unique `id` and a `description`.
 *     *   A `static int nextTicketId` ensures each new ticket gets a unique, sequential ID.
 *     *   It follows encapsulation principles with private fields and public getter methods.
 *     *   The `toString()` method provides a convenient way to display ticket information.
 * 
 * 2.  **`SupportSystem` Class:**
 *     *   This is the main class managing the system logic.
 *     *   **`Queue<SupportTicket> ticketQueue`**: A `Queue` (implemented using `LinkedList`) is used to store `SupportTicket` objects. The `Queue` interface naturally supports the First-In, First-Out (FIFO) behavior required for processing tickets in the order they are received. `offer()` is used for adding (enqueueing), and `poll()` is used for retrieving and removing the head (dequeueing).
 *     *   **`List<String> agentList`**: A `List` (implemented using `ArrayList`) is used to store the names of available support agents. Using the `List` interface for the variable type promotes flexibility if a different `List` implementation were needed later.
 *     *   **`addTicket(String description)`**: Creates a new `SupportTicket` and adds it to the `ticketQueue` using `offer()`. Includes basic validation to ensure the description is not empty.
 *     *   **`processNextTicket()`**: Checks if the `ticketQueue` is empty. If not, it removes the next ticket using `poll()` and prints its details, simulating processing. If the queue is empty, it prints an error message to `System.err`.
 *     *   **`viewPendingTickets()`**: Iterates through the `ticketQueue` using a for-each loop to display all tickets without removing them.
 *     *   **`viewAvailableAgents()`**: Iterates through the `agentList` to display the names of the agents.
 *     *   **`displayMenu()`**: A helper method to print the menu options to `System.out`.
 *     *   **`run()`**: This method contains the main application loop.
 *         *   It uses a `Scanner` to read user input from `System.in`.
 *         *   The core logic is wrapped in a `while(running)` loop.
 *         *   **`try-catch` blocks**:
 *             *   An inner `try-catch (InputMismatchException e)` specifically handles cases where the user enters non-integer input for the menu choice. It prints an error to `System.err` and consumes the invalid input from the scanner to prevent an infinite loop.
 *             *   An outer `try-catch (Exception e)` catches any other unexpected exceptions that might occur during the execution of the menu options, printing a general error to `System.err`. This provides robust, class-wide exception handling for the main execution flow.
 *         *   A `switch` statement processes the valid integer menu choice, calling the appropriate method (`addTicket`, `processNextTicket`, etc.).
 *         *   The `default` case in the `switch` handles integer inputs that are outside the valid menu range (1-5), printing an error to `System.err`.
 *     *   **`main(String[] args)`**: The entry point of the program, which creates an instance of `SupportSystem` and calls its `run()` method to start the application.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Fields in both classes are `private`, accessed via public methods.
 *     *   **Naming:** Variable names (`ticketQueue`, `agentList`, `nextTicketId`) and method names (`addTicket`, `processNextTicket`, `viewPendingTickets`, `run`) are descriptive.
 *     *   **Comments:** Javadoc comments explain the purpose of classes and methods. Inline comments clarify specific logic (like the static counter or scanner input handling).
 *     *   **Input Validation:** Checks for empty ticket descriptions and handles non-integer/out-of-range menu inputs.
 *     *   **Error Handling:** Uses `System.err` for all error messages (invalid input, empty queue operation, unexpected exceptions) and `try-catch` for managing exceptions.
 *     *   **Clean Code:** The code is divided into logical classes and methods, making it readable and maintainable.
 * 
 * This solution effectively integrates all the required Java components within a practical scenario, demonstrating a solid understanding of fundamental data structures, control flow, object-oriented principles, and error handling in Java.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single support ticket.
 */
class SupportTicket {
    private static int nextTicketId = 1; // Static counter for unique IDs
    private int id;
    private String description;

    /**
     * Constructs a new SupportTicket with a unique ID.
     * @param description The description of the support issue.
     */
    public SupportTicket(String description) {
        this.id = nextTicketId++;
        this.description = description;
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Provides a string representation of the SupportTicket.
     * @return A formatted string including ticket ID and description.
     */
    @Override
    public String toString() {
        return "[ID: " + id + ", Description: " + description + "]";
    }
}

/**
 * Manages the support ticket queue and available agents.
 */
public class SupportSystem {

    private Queue<SupportTicket> ticketQueue; // Queue to hold pending tickets
    private List<String> agentList; // List to hold available agent names

    /**
     * Constructs a new SupportSystem, initializing the queue and agent list.
     */
    public SupportSystem() {
        // Use LinkedList as an implementation of Queue
        this.ticketQueue = new LinkedList<>();
        // Use ArrayList as an implementation of List
        this.agentList = new ArrayList<>();
        // Add some initial agents
        agentList.add("Alice");
        agentList.add("Bob");
        agentList.add("Charlie");
    }

    /**
     * Adds a new ticket to the end of the queue.
     * @param description The description for the new ticket.
     */
    public void addTicket(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Ticket description cannot be empty.");
            return;
        }
        SupportTicket newTicket = new SupportTicket(description.trim());
        ticketQueue.offer(newTicket); // offer() is generally preferred over add() for capacity-constrained queues, though LinkedList is not capacity-constrained. It's good practice.
        System.out.println("\nTicket added successfully. ID: " + newTicket.getId());
    }

    /**
     * Processes the next ticket from the front of the queue.
     * Removes the ticket and simulates processing by an agent.
     */
    public void processNextTicket() {
        if (ticketQueue.isEmpty()) {
            System.err.println("Error: No tickets currently in the queue.");
            return;
        }

        // poll() retrieves and removes the head of the queue, returns null if empty (checked above)
        SupportTicket processedTicket = ticketQueue.poll();
        System.out.println("\nProcessing ticket: " + processedTicket);

        // Simulate processing by an agent (simple pick from list for demonstration)
        // In a real system, agent assignment would be more complex.
        if (!agentList.isEmpty()) {
             // For simplicity, just state it's processed by *an* agent without picking a specific one
             System.out.println("Processed by an agent.");
        } else {
             System.out.println("Processed (no agents listed).");
        }
    }

    /**
     * Displays all tickets currently waiting in the queue without removing them.
     */
    public void viewPendingTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("\nNo tickets currently in the queue.");
            return;
        }

        System.out.println("\nPending Tickets:");
        // Iterate through the queue elements without removing them
        for (SupportTicket ticket : ticketQueue) {
            System.out.println(ticket);
        }
    }

    /**
     * Displays the list of available support agents.
     */
    public void viewAvailableAgents() {
        System.out.println("\nAvailable Agents:");
        if (agentList.isEmpty()) {
            System.out.println("No agents listed.");
        } else {
            for (String agent : agentList) {
                System.out.println("- " + agent);
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Support Ticket System Menu ---");
        System.out.println("1. Add New Ticket");
        System.out.println("2. Process Next Ticket");
        System.out.println("3. View Pending Tickets");
        System.out.println("4. View Available Agents");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop, handling user input and menu actions.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();

            try {
                // Read user input for menu choice
                int choice = scanner.nextInt();
                // Consume the newline character left by nextInt()
                scanner.nextLine();

                // Use a switch statement for menu control
                switch (choice) {
                    case 1:
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();
                        addTicket(description);
                        break;
                    case 2:
                        processNextTicket();
                        break;
                    case 3:
                        viewPendingTickets();
                        break;
                    case 4:
                        viewAvailableAgents();
                        break;
                    case 5:
                        System.out.println("Exiting Support Ticket System.");
                        running = false;
                        break;
                    default:
                        // Handle invalid integer input within the valid range
                        System.err.println("Error: Invalid menu choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input
                System.err.println("Error: Invalid input. Please enter a number.");
                // Consume the invalid input to prevent an infinite loop
                scanner.next();
                // Consume the newline character after the invalid input
                scanner.nextLine();

            } catch (Exception e) {
                // Catch any other unexpected exceptions during the loop
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to System.err for debugging
            }
        }

        scanner.close(); // Close the scanner when exiting
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
