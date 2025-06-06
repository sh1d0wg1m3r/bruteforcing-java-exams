/*
 * Exam Question #970
 * Generated on: 2025-05-12 17:06:43
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: IT Support Ticket Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified IT support ticket management system for a small department. The system should allow users to add new support tickets, add technicians, process the next available ticket (assigning it to an available technician and marking it as completed), and view the current status of the system.
 * 
 * The system needs to manage tickets waiting for support, a pool of available technicians, and a list of tickets that have been successfully completed.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to store tickets that are waiting to be processed.
 *     *   Use a `java.util.ArrayList` to store available technicians.
 *     *   Use a `java.util.List` (declared as `List<Ticket>`) to store completed tickets.
 * 
 * 2.  **Classes:**
 *     *   Create a `Ticket` class with private fields for `id` (integer), `description` (String), and `priority` (String - e.g., "High", "Medium", "Low"), and `status` (String - e.g., "Waiting", "Completed"). Include a constructor and public getter methods.
 *     *   Create a `Technician` class with private fields for `id` (integer) and `name` (String). Include a constructor and public getter methods.
 *     *   Create a `TicketManager` class that encapsulates the data structures (`Queue`, `ArrayList`, `List`) and provides methods for the system's operations.
 * 
 * 3.  **Functionality (in `TicketManager`):**
 *     *   `addTicket(String description, String priority)`: Creates a new `Ticket` with a unique ID (you can use a simple counter) and "Waiting" status, and adds it to the waiting queue.
 *     *   `addTechnician(String name)`: Creates a new `Technician` with a unique ID and adds them to the list of available technicians.
 *     *   `processNextTicket()`:
 *         *   Checks if there are tickets in the waiting queue AND if there are available technicians.
 *         *   If both are available, it removes the next ticket from the queue, assigns it conceptually to the first available technician (for simplicity, just removes the tech from the available list temporarily or conceptually), updates the ticket's status to "Completed", and moves the ticket to the completed tickets list.
 *         *   If no tickets are waiting, print a message.
 *         *   If no technicians are available, print a message.
 *     *   `displayStatus()`: Prints the number of waiting tickets, the number of available technicians, and lists the completed tickets (ID and description).
 * 
 * 4.  **User Interface (in `main` method):**
 *     *   Use `java.util.Scanner` to get user input from the console.
 *     *   Present a menu with options:
 *         1.  Add New Ticket
 *         2.  Add New Technician
 *         3.  Process Next Ticket
 *         4.  View System Status
 *         5.  Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Implement input validation for menu choices (must be an integer within the valid range). If invalid input is detected, print an error message using `System.err`.
 *     *   Implement input validation for ticket priority (e.g., accept "High", "Medium", "Low" - case-insensitive). If invalid, print an error using `System.err` and do not add the ticket.
 * 
 * 5.  **Error Handling:**
 *     *   Use `try-catch` blocks to handle potential exceptions, particularly around user input parsing (e.g., `InputMismatchException`). Implement class-wide exception handling by wrapping the main application loop in a `try-catch` block to catch unexpected runtime errors.
 *     *   Use `System.err` for all error messages (invalid input, processing errors like no tech/no ticket).
 *     *   Use `System.out` for all normal output (menu, prompts, status updates, success messages).
 * 
 * 6.  **Best Practices:**
 *     *   Use private fields and public methods for encapsulation.
 *     *   Use meaningful names for variables, methods, and classes.
 *     *   Include appropriate comments to explain complex logic.
 *     *   Ensure clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should interact with the user via the console, displaying a menu, prompting for input, and providing feedback based on the chosen action. Error messages should go to `System.err`, and normal output to `System.out`.
 * 
 * Example interaction flow:
 * 
 * ```
 * IT Support Ticket Management System
 * -----------------------------------
 * 1. Add New Ticket
 * 2. Add New Technician
 * 3. Process Next Ticket
 * 4. View System Status
 * 5. Exit
 * Enter your choice: 1
 * Enter ticket description: Printer not working
 * Enter ticket priority (High, Medium, Low): High
 * Ticket added with ID: 1
 * 
 * IT Support Ticket Management System
 * -----------------------------------
 * ... (menu)
 * Enter your choice: 2
 * Enter technician name: Alice
 * Technician added with ID: 1
 * 
 * IT Support Ticket Management System
 * -----------------------------------
 * ... (menu)
 * Enter your choice: 3
 * Processing ticket...
 * Ticket ID 1 processed by Technician ID 1.
 * 
 * IT Support Ticket Management System
 * -----------------------------------
 * ... (menu)
 * Enter your choice: 4
 * --- System Status ---
 * Waiting Tickets: 0
 * Available Technicians: 0
 * Completed Tickets:
 * - ID: 1, Description: Printer not working
 * ---------------------
 * 
 * IT Support Ticket Management System
 * -----------------------------------
 * ... (menu)
 * Enter your choice: 6
 * Invalid choice. Please enter a number between 1 and 5.
 * 
 * IT Support Ticket Management System
 * -----------------------------------
 * ... (menu)
 * Enter your choice: 3
 * System.err: No technicians available or no tickets waiting. Cannot process ticket.
 * 
 * IT Support Ticket Management System
 * -----------------------------------
 * ... (menu)
 * Enter your choice: 5
 * Exiting system.
 * ```
 * 
 * Your solution should provide the complete Java code for this system.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`.
 * *   Correct implementation of the required functionality.
 * *   Adherence to object-oriented principles (encapsulation).
 * *   Meaningful naming and code structure.
 * *   Proper input validation and error handling.
 * *   Clear and correct output.
 *
 * EXPLANATION:
 * This solution implements a basic IT Support Ticket Management System, demonstrating the required Java concepts.
 * 
 * 1.  **Scenario and Structure:** The system is built around managing `Ticket` and `Technician` objects within a `TicketManager`. The `main` method in `SupportSystem` provides the user interface.
 * 2.  **Required Components Usage:**
 *     *   `Queue (java.util.Queue)`: The `waitingTickets` field in `TicketManager` is declared as `Queue<Ticket>` and instantiated as `new LinkedList<>()`. `LinkedList` is a common implementation of `Queue` that provides FIFO behavior. Methods like `offer()` (to add) and `poll()` (to remove from the head) are used.
 *     *   `ArrayList (java.util.ArrayList)`: The `availableTechnicians` field is declared and instantiated as `ArrayList<Technician>`, providing a dynamic array to store technicians.
 *     *   `List interface (java.util.List)`: The `completedTickets` field is declared as `List<Ticket>` and instantiated as `new ArrayList<>()`. This demonstrates programming to the interface.
 *     *   `Scanner (java.util.Scanner)`: Used in the `main` method to read user input from `System.in`.
 *     *   `Switch statement`: Used in the `main` loop to control the flow of execution based on the user's menu choice.
 *     *   `System.err`: Used for printing error messages, such as invalid input or when processing fails due to no tickets/technicians.
 *     *   `System.out`: Used for all normal output, including the menu, prompts, success messages, and status display.
 *     *   `Class-wide exception handling with try-catch`: The main `while` loop in the `main` method is wrapped in a `try-catch` block to catch any unexpected runtime exceptions that might occur during the program's execution. A specific `try-catch` is also used around `scanner.nextInt()` to handle `InputMismatchException` for invalid non-integer input, demonstrating more localized error handling as well. A `finally` block ensures the scanner is closed.
 * 3.  **Classes and Encapsulation:**
 *     *   `Ticket` and `Technician` classes encapsulate their data (ID, description/name, priority/status) using `private` fields and provide `public` getter methods. `Ticket` also has a `setStatus` setter.
 *     *   `TicketManager` encapsulates the core data structures (`waitingTickets`, `availableTechnicians`, `completedTickets`) and the logic for managing them. Its fields are private, and operations are exposed through public methods (`addTicket`, `addTechnician`, `processNextTicket`, `displayStatus`).
 * 4.  **Functionality Implementation:**
 *     *   Unique IDs are generated using simple counters (`nextTicketId`, `nextTechnicianId`).
 *     *   `addTicket` includes basic validation for priority string.
 *     *   `processNextTicket` checks for necessary conditions (tickets waiting, technicians available) before attempting to process. It uses `waitingTickets.poll()` to get and remove the next ticket and moves it to `completedTickets`.
 *     *   `displayStatus` provides a summary of the current state of the queues and lists.
 * 5.  **Input Validation and Error Handling:**
 *     *   The `main` method explicitly handles `InputMismatchException` when reading the integer menu choice.
 *     *   The `addTicket` method validates the priority string input.
 *     *   `processNextTicket` checks for empty queues/lists and prints informative error messages using `System.err`.
 *     *   The main `try-catch` block provides a safety net for unexpected errors.
 * 6.  **Best Practices:** Meaningful names are used (e.g., `waitingTickets`, `processNextTicket`). Comments explain the purpose of methods and key parts of the code. The code is structured into logical classes. Programming to the `List` interface is used for `completedTickets`.
 * 
 * This solution effectively integrates all the required components into a cohesive, albeit simplified, application demonstrating fundamental and intermediate Java programming skills, including object-oriented design, data structure usage, user interaction, and error handling.
 */

import java.util.Queue;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Class representing a support ticket
class Ticket {
    private int id;
    private String description;
    private String priority;
    private String status; // e.g., "Waiting", "Completed"

    public Ticket(int id, String description, String priority) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.status = "Waiting"; // New tickets start as Waiting
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    // Setter to update status (used when processing)
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Description: " + description + ", Priority: " + priority + ", Status: " + status;
    }
}

// Class representing a technician
class Technician {
    private int id;
    private String name;

    public Technician(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

// Class managing the tickets and technicians
class TicketManager {
    // Use Queue for waiting tickets (FIFO)
    private Queue<Ticket> waitingTickets;
    // Use ArrayList for available technicians
    private ArrayList<Technician> availableTechnicians;
    // Use List interface for completed tickets
    private List<Ticket> completedTickets;

    private int nextTicketId = 1;
    private int nextTechnicianId = 1;

    public TicketManager() {
        // Instantiate the required data structures
        this.waitingTickets = new LinkedList<>(); // LinkedList implements Queue
        this.availableTechnicians = new ArrayList<>();
        this.completedTickets = new ArrayList<>(); // ArrayList implements List
    }

    /**
     * Adds a new ticket to the waiting queue.
     * @param description The ticket description.
     * @param priority The ticket priority (High, Medium, Low).
     * @return true if ticket was added, false otherwise (e.g., invalid priority).
     */
    public boolean addTicket(String description, String priority) {
        // Validate priority
        String lowerPriority = priority.toLowerCase();
        if (!lowerPriority.equals("high") && !lowerPriority.equals("medium") && !lowerPriority.equals("low")) {
            System.err.println("Error: Invalid priority. Please enter High, Medium, or Low.");
            return false;
        }

        Ticket newTicket = new Ticket(nextTicketId++, description, priority);
        waitingTickets.offer(newTicket); // offer is preferred over add for queues
        System.out.println("Ticket added with ID: " + newTicket.getId());
        return true;
    }

    /**
     * Adds a new technician to the available pool.
     * @param name The technician's name.
     */
    public void addTechnician(String name) {
        Technician newTechnician = new Technician(nextTechnicianId++, name);
        availableTechnicians.add(newTechnician);
        System.out.println("Technician added with ID: " + newTechnician.getId());
    }

    /**
     * Processes the next ticket in the queue using an available technician.
     */
    public void processNextTicket() {
        // Check if there are tickets AND technicians
        if (waitingTickets.isEmpty()) {
            System.err.println("No tickets waiting to be processed.");
            return;
        }

        if (availableTechnicians.isEmpty()) {
            System.err.println("No technicians available to process tickets.");
            return;
        }

        System.out.println("Processing next ticket...");

        // Get the next ticket from the queue (without removing yet)
        Ticket ticketToProcess = waitingTickets.peek();

        // Get the first available technician (for simplicity, just take one conceptually)
        // In a real system, the technician might become "Busy" here.
        // For this simple model, we just assume they are used and remain available
        // or perhaps remove them temporarily if we had a "Busy" state.
        // Let's just use the first one found for the message.
        Technician processingTechnician = availableTechnicians.get(0);

        // Remove the ticket from the waiting queue
        ticketToProcess = waitingTickets.poll(); // poll removes and returns the head

        // Update ticket status and add to completed list
        ticketToProcess.setStatus("Completed");
        completedTickets.add(ticketToProcess);

        System.out.println("Ticket ID " + ticketToProcess.getId() + " processed by Technician ID " + processingTechnician.getId() + " (" + processingTechnician.getName() + ").");
    }

    /**
     * Displays the current status of the system.
     */
    public void displayStatus() {
        System.out.println("\n--- System Status ---");

        System.out.println("Waiting Tickets: " + waitingTickets.size());
        // Optional: List waiting tickets (can be many, so size is often enough)
        // System.out.println("  Details: " + waitingTickets);

        System.out.println("Available Technicians: " + availableTechnicians.size());
        // Optional: List available technicians
        // System.out.println("  Details: " + availableTechnicians);


        System.out.println("Completed Tickets: " + completedTickets.size());
        if (!completedTickets.isEmpty()) {
            for (Ticket ticket : completedTickets) {
                System.out.println("- " + ticket.toString());
            }
        }
        System.out.println("---------------------\n");
    }
}

// Main class to run the application
public class SupportSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketManager manager = new TicketManager();
        boolean running = true;

        // Class-wide exception handling for the main application loop
        try {
            while (running) {
                printMenu();
                System.out.print("Enter your choice: ");

                int choice = -1;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Skip the rest of the loop and show menu again
                } finally {
                     // Consume the newline character left by nextInt() or next()
                     // This is important before reading the next line with nextLine()
                     scanner.nextLine();
                }


                // Use a switch statement for menu control
                switch (choice) {
                    case 1: // Add New Ticket
                        System.out.print("Enter ticket description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter ticket priority (High, Medium, Low): ");
                        String priority = scanner.nextLine();
                        manager.addTicket(description, priority); // addTicket handles its own validation message
                        break;
                    case 2: // Add New Technician
                        System.out.print("Enter technician name: ");
                        String techName = scanner.nextLine();
                        manager.addTechnician(techName);
                        break;
                    case 3: // Process Next Ticket
                        manager.processNextTicket(); // processNextTicket handles its own status messages
                        break;
                    case 4: // View System Status
                        manager.displayStatus();
                        break;
                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting system.");
                        break;
                    default: // Invalid choice
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Prints the main menu to the console.
     */
    private static void printMenu() {
        System.out.println("\nIT Support Ticket Management System");
        System.out.println("-----------------------------------");
        System.out.println("1. Add New Ticket");
        System.out.println("2. Add New Technician");
        System.out.println("3. Process Next Ticket");
        System.out.println("4. View System Status");
        System.out.println("5. Exit");
    }
}
