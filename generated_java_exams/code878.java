/*
 * Exam Question #878
 * Generated on: 2025-05-12 16:54:05
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Event Ticket Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified backend system for managing ticket requests for a popular event with a limited number of tickets. Potential attendees submit ticket requests, which are processed in the order they are received. The system must track available tickets, fulfill requests if tickets are available, and keep a record of all processed requests.
 * 
 * **Your Task:**
 * 
 * Implement a Java program that simulates this system. The program should provide a command-line interface for interacting with the system.
 * 
 * **System Requirements:**
 * 
 * 1.  **TicketRequest Class:** Create a class `TicketRequest` to represent a single request. It should store:
 *     *   Requester's name (String)
 *     *   Number of tickets requested (int)
 *     *   A status indicating if the request has been processed (boolean)
 *     *   A status indicating if the request was successfully fulfilled (boolean)
 *     *   Use appropriate encapsulation (private fields, public getters). Include a method to mark the request as processed and fulfilled/rejected.
 * 
 * 2.  **EventManager Class:** Create a class `EventManager` to manage the ticket requests and available tickets. It should contain:
 *     *   A **Queue** to hold incoming `TicketRequest` objects waiting to be processed.
 *     *   A **List** (implemented using **ArrayList**) to store all `TicketRequest` objects once they have been processed (whether fulfilled or rejected).
 *     *   An integer variable to track the number of available tickets.
 *     *   A constructor to initialize the available tickets and the data structures.
 *     *   A method to add a new request to the waiting queue. This method should include input validation for the number of tickets requested (must be positive).
 *     *   A method to process the next request from the queue. This method should:
 *         *   Dequeue the next request.
 *         *   Check if enough tickets are available.
 *         *   If available: Mark the request as processed and fulfilled, decrement the available tickets, and add the request to the processed list.
 *         *   If not available: Mark the request as processed but *not* fulfilled, and add the request to the processed list.
 *         *   Handle the case where the queue is empty.
 *     *   A method to display all processed requests, indicating whether each was fulfilled or rejected.
 *     *   A method to display the current number of available tickets.
 * 
 * 3.  **Main Program Logic:** In the `main` method (or a separate main class), create an instance of `EventManager`. Implement a command-line menu using a **Scanner** to get user input. The menu should offer the following options:
 *     *   Add New Ticket Request
 *     *   Process Next Request
 *     *   View Processed Requests
 *     *   View Available Tickets
 *     *   Exit
 * 
 * 4.  **Flow Control and Error Handling:**
 *     *   Use a **switch** statement to handle the different menu options.
 *     *   Use **System.out** for all normal output (menu, successful operations, request details).
 *     *   Use **System.err** for displaying error messages (e.g., invalid menu choice, invalid ticket amount, no requests to process).
 *     *   Implement **try-catch** blocks to handle potential exceptions, particularly when reading user input (e.g., non-integer input when expecting a number). Error handling should be robust enough to prevent the program from crashing due to invalid input or operational issues (like trying to process from an empty queue).
 * 
 * **Initial State:**
 * 
 * The system should start with a predefined number of available tickets (e.g., 100).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu and respond to user input. Examples:
 * *   Adding a request: Prompt for name and ticket count, confirm addition to queue.
 * *   Processing: Indicate which request is being processed and whether it was fulfilled or rejected, along with the new available ticket count. If the queue is empty, print an error.
 * *   Viewing processed: List all processed requests with their status.
 * *   Viewing available: Print the current count.
 * *   Invalid input (menu or ticket count): Print an error message using `System.err`.
 * *   Non-integer input: Print an error message using `System.err` and handle gracefully.
 * 
 * **Constraints & Best Practices:**
 * 
 * *   Adhere to the required Java components listed above.
 * *   Follow best practices for code structure, naming conventions, comments (Javadoc where appropriate), and encapsulation.
 * *   Ensure proper input validation and error handling as described.
 * 
 * **Time Estimate:** 45-60 minutes
 * 
 * ```java
 * // Your code will go here
 * ```
 * 
 * **Good luck!**
 *
 * EXPLANATION:
 * This solution implements the `Event Ticket Management System` as described in the exam question, incorporating all the required Java components and adhering to best practices.
 * 
 * 1.  **`TicketRequest` Class:**
 *     *   Represents a single request with private fields (`requesterName`, `requestedTickets`, `isProcessed`, `isFulfilled`) for encapsulation.
 *     *   Provides public getters to access the data.
 *     *   Includes `markFulfilled()` and `markRejected()` methods to update the processing and fulfillment status, demonstrating controlled modification of internal state.
 *     *   The `toString()` method provides a convenient way to display request details.
 * 
 * 2.  **`EventManager` Class:**
 *     *   **Data Structures:**
 *         *   `requestQueue`: Declared as `Queue<TicketRequest>` and initialized with `new LinkedList<>()`. The `Queue` interface ensures FIFO behavior for incoming requests, and `LinkedList` is a common, efficient implementation for this use case.
 *         *   `processedRequests`: Declared as `List<TicketRequest>` and initialized with `new ArrayList<>()`. This demonstrates using the `List` interface while utilizing the concrete `ArrayList` implementation, which is suitable for storing and iterating over the processed requests.
 *         *   `availableTickets`: An integer tracking the remaining tickets.
 *     *   **Constructor:** Initializes the data structures and the initial number of available tickets, including basic validation for the initial ticket count.
 *     *   **`addRequest(String name, int tickets)`:** Takes requester name and ticket count, performs input validation (non-empty name, positive ticket count), creates a `TicketRequest` object, and adds it to the `requestQueue` using `offer()`. `offer()` is generally preferred over `add()` for queues as it returns `false` if the element cannot be added immediately (though for `LinkedList`, it behaves like `add()`).
 *     *   **`processNextRequest()`:**
 *         *   Checks if the `requestQueue` is empty using `isEmpty()`. If so, it prints an error to `System.err` and returns.
 *         *   Uses `requestQueue.poll()` to retrieve and remove the next request from the head of the queue.
 *         *   Compares the `requestedTickets` with `availableTickets`.
 *         *   If sufficient tickets are available, it updates `availableTickets`, calls `markFulfilled()` on the request, and adds it to the `processedRequests` list.
 *         *   If not, it calls `markRejected()` and adds it to the `processedRequests` list.
 *         *   Prints status updates to `System.out`.
 *     *   **`viewProcessedRequests()`:** Iterates through the `processedRequests` list (accessed via the `List` interface reference) and prints the details of each processed request using its `toString()` method to `System.out`. Handles the case where the list is empty.
 *     *   **`viewAvailableTickets()`:** Prints the current count of `availableTickets` to `System.out`.
 * 
 * 3.  **Main Program Logic (`main` method in `EventManager`):**
 *     *   Creates a `Scanner` object for user input.
 *     *   Creates an `EventManager` instance.
 *     *   Enters a `while(running)` loop to keep the program alive until the user chooses to exit.
 *     *   Calls `printMenu()` to display options.
 *     *   Uses a `try-catch` block specifically around `scanner.nextInt()` to handle `InputMismatchException` if the user enters non-integer input for the menu choice. This prevents the program from crashing and prompts the user again after consuming the invalid input. A general `catch` is also included for other unexpected issues during input reading.
 *     *   A `switch` statement is used to direct the program flow based on the valid menu choice, calling the appropriate methods of the `EventManager`.
 *     *   Input for adding requests (name, tickets) is read within the corresponding case, with a nested `try-catch` for the ticket count input to handle potential `InputMismatchException` there as well.
 *     *   `System.out` is used for the menu, prompts, and successful operation messages.
 *     *   `System.err` is used for invalid menu choices, invalid ticket request amounts, and the "No requests in queue" message.
 *     *   A final `try-catch` block surrounds the main `while` loop to catch any unhandled exceptions that might occur elsewhere in the loop, providing a last-resort error message before exiting.
 *     *   A `finally` block ensures the `Scanner` is closed when the program exits, regardless of how it exits (normally or due to an exception).
 * 
 * **Best Practices Demonstrated:**
 * 
 * *   **Encapsulation:** Private fields and public methods in `TicketRequest` and `EventManager`.
 * *   **Meaningful Names:** Classes, methods, and variables have descriptive names (`TicketRequest`, `processNextRequest`, `availableTickets`).
 * *   **Comments and Documentation:** Javadoc comments explain the purpose of classes and methods. Inline comments clarify specific code sections.
 * *   **Input Validation:** Checks for positive ticket counts and non-empty names before creating a request.
 * *   **Error Handling:** Uses `try-catch` for input parsing (`InputMismatchException`) and general unexpected errors. Specific error conditions (empty queue, invalid input values) are checked and reported using `System.err`.
 * *   **Clean Code Structure:** The logic is divided into well-defined classes and methods, making the code organized and readable. The `main` method focuses on the user interface and interaction, delegating core logic to the `EventManager`.
 * *   **Interface Usage:** Using `List<TicketRequest>` for `processedRequests` instead of directly `ArrayList<TicketRequest>` demonstrates programming to an interface.
 * 
 * This solution effectively combines the required Java components within a practical scenario, showcasing fundamental object-oriented principles and robust error handling.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException; // Specific exception for non-integer input

/**
 * Represents a single ticket request for an event.
 */
class TicketRequest {
    private String requesterName;
    private int requestedTickets;
    private boolean isProcessed;
    private boolean isFulfilled;

    /**
     * Constructs a new TicketRequest.
     *
     * @param requesterName The name of the person requesting tickets.
     * @param requestedTickets The number of tickets requested.
     */
    public TicketRequest(String requesterName, int requestedTickets) {
        this.requesterName = requesterName;
        this.requestedTickets = requestedTickets;
        this.isProcessed = false;
        this.isFulfilled = false;
    }

    // --- Getters ---
    public String getRequesterName() {
        return requesterName;
    }

    public int getRequestedTickets() {
        return requestedTickets;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    // --- Methods to update status ---

    /**
     * Marks the request as processed and fulfilled.
     */
    public void markFulfilled() {
        this.isProcessed = true;
        this.isFulfilled = true;
    }

    /**
     * Marks the request as processed but not fulfilled.
     */
    public void markRejected() {
        this.isProcessed = true;
        this.isFulfilled = false;
    }

    @Override
    public String toString() {
        return "Request [Name: " + requesterName +
               ", Tickets: " + requestedTickets +
               ", Status: " + (isProcessed ? (isFulfilled ? "Fulfilled" : "Rejected") : "Pending") + "]";
    }
}

/**
 * Manages the event ticket requests and available tickets.
 */
class EventManager {
    private Queue<TicketRequest> requestQueue;
    private List<TicketRequest> processedRequests;
    private int availableTickets;

    /**
     * Constructs an EventManager with a specified number of initial tickets.
     *
     * @param initialTickets The starting number of available tickets.
     */
    public EventManager(int initialTickets) {
        if (initialTickets < 0) {
            System.err.println("Warning: Initial tickets cannot be negative. Setting to 0.");
            this.availableTickets = 0;
        } else {
            this.availableTickets = initialTickets;
        }
        this.requestQueue = new LinkedList<>(); // LinkedList is a common Queue implementation
        this.processedRequests = new ArrayList<>();
        System.out.println("Event Manager initialized with " + this.availableTickets + " available tickets.");
    }

    /**
     * Adds a new ticket request to the queue.
     *
     * @param name The name of the requester.
     * @param tickets The number of tickets requested.
     */
    public void addRequest(String name, int tickets) {
        // Input validation
        if (name == null || name.trim().isEmpty()) {
            System.err.println("Error: Requester name cannot be empty.");
            return;
        }
        if (tickets <= 0) {
            System.err.println("Error: Number of tickets requested must be positive.");
            return;
        }

        TicketRequest newRequest = new TicketRequest(name.trim(), tickets);
        requestQueue.offer(newRequest); // offer is preferred over add for queues
        System.out.println("Request for " + tickets + " ticket(s) by " + name.trim() + " added to queue.");
    }

    /**
     * Processes the next ticket request from the queue.
     */
    public void processNextRequest() {
        if (requestQueue.isEmpty()) {
            System.err.println("No requests in the queue to process.");
            return;
        }

        TicketRequest currentRequest = requestQueue.poll(); // Get and remove the head of the queue
        System.out.println("Processing request from " + currentRequest.getRequesterName() + " for " + currentRequest.getRequestedTickets() + " ticket(s)...");

        if (availableTickets >= currentRequest.getRequestedTickets()) {
            // Fulfill the request
            availableTickets -= currentRequest.getRequestedTickets();
            currentRequest.markFulfilled();
            processedRequests.add(currentRequest);
            System.out.println("Request fulfilled. " + currentRequest.getRequestedTickets() + " ticket(s) allocated.");
        } else {
            // Reject the request
            currentRequest.markRejected();
            processedRequests.add(currentRequest);
            System.out.println("Request rejected. Not enough tickets available.");
        }
        System.out.println("Available tickets remaining: " + availableTickets);
    }

    /**
     * Displays all processed ticket requests.
     */
    public void viewProcessedRequests() {
        if (processedRequests.isEmpty()) {
            System.out.println("No requests have been processed yet.");
            return;
        }

        System.out.println("\n--- Processed Requests ---");
        // Using List interface reference
        List<TicketRequest> processedList = processedRequests;
        for (int i = 0; i < processedList.size(); i++) {
            TicketRequest req = processedList.get(i);
            System.out.println((i + 1) + ". " + req.toString());
        }
        System.out.println("--------------------------");
    }

    /**
     * Displays the current number of available tickets.
     */
    public void viewAvailableTickets() {
        System.out.println("Current available tickets: " + availableTickets);
    }

    /**
     * Main method to run the Event Ticket Management System.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager manager = new EventManager(100); // Initialize with 100 tickets
        boolean running = true;

        // Class-wide/main loop try-catch for general exceptions,
        // though specific InputMismatchException is handled within the loop.
        try {
            while (running) {
                printMenu();
                int choice = -1; // Default invalid choice

                // Input handling for menu choice
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    // Consume the newline character left by nextInt()
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop iteration
                } catch (Exception e) {
                    // Catch any other unexpected exceptions during input
                    System.err.println("An unexpected error occurred during input: " + e.getMessage());
                    e.printStackTrace();
                    running = false; // Exit on unexpected error
                    break;
                }

                // Use switch statement for menu actions
                switch (choice) {
                    case 1: // Add New Ticket Request
                        System.out.print("Enter requester name: ");
                        String name = scanner.nextLine();
                        int tickets = -1;
                        try {
                            System.out.print("Enter number of tickets requested: ");
                            tickets = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            manager.addRequest(name, tickets);
                        } catch (InputMismatchException e) {
                            System.err.println("Invalid input. Please enter a valid number for tickets.");
                            scanner.nextLine(); // Consume invalid input
                        } catch (Exception e) {
                             System.err.println("An error occurred while adding request: " + e.getMessage());
                        }
                        break;

                    case 2: // Process Next Request
                        manager.processNextRequest();
                        break;

                    case 3: // View Processed Requests
                        manager.viewProcessedRequests();
                        break;

                    case 4: // View Available Tickets
                        manager.viewAvailableTickets();
                        break;

                    case 5: // Exit
                        System.out.println("Exiting Event Ticket Management System. Goodbye!");
                        running = false;
                        break;

                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                System.out.println(); // Add a newline for better readability
            }
        } catch (Exception e) {
            // General catch for any unhandled exceptions in the main loop
            System.err.println("An unrecoverable error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure scanner is closed
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("--- Event Ticket Management Menu ---");
        System.out.println("1. Add New Ticket Request");
        System.out.println("2. Process Next Request");
        System.out.println("3. View Processed Requests");
        System.out.println("4. View Available Tickets");
        System.out.println("5. Exit");
        System.out.println("------------------------------------");
    }
}
