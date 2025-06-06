/*
 * Exam Question #470
 * Generated on: 2025-05-11 23:15:55
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Technical Support Request Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simple technical support system. The system should manage incoming support requests using a queue and maintain a list of available support agents. Users interact with the system via a command-line interface to add new requests, process requests, view the queue, and view agents.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to store incoming support requests. Requests should be processed in First-In, First-Out (FIFO) order.
 *     *   Use a `java.util.ArrayList` to store available support agents.
 *     *   Declare the agent collection using the `java.util.List` interface type.
 * 
 * 2.  **Classes:**
 *     *   Create a `SupportRequest` class to represent a support ticket. It should have fields for a unique request ID (integer, auto-generated), a description (String), and a status (e.g., "Pending", "Processing", "Completed").
 *     *   Create a `SupportAgent` class with fields for an agent ID (integer) and a name (String).
 *     *   Create a main class (e.g., `SupportSystem`) that contains the `main` method and manages the queue and the list of agents.
 * 
 * 3.  **Functionality:**
 *     *   **Add Request:** Allow the user to input a description for a new support request. Create a `SupportRequest` object with a unique ID and "Pending" status, and add it to the queue.
 *     *   **Process Next Request:** Take the next request from the front of the queue. Simulate processing (e.g., change status to "Processing", print details, conceptually assign to an agent - you don't need complex agent assignment logic, just mention it). Remove the request from the queue. Handle the case where the queue is empty.
 *     *   **View Queue:** Display all requests currently in the queue, showing their ID and description.
 *     *   **View Agents:** Display all available support agents.
 *     *   **Exit:** Terminate the program.
 * 
 * 4.  **User Interface:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user (Add Request, Process Request, View Queue, View Agents, Exit).
 *     *   Use a `switch` statement to handle the user's menu selection.
 *     *   Use `System.out` for normal output (menu, request/agent lists, confirmation messages).
 *     *   Use `System.err` for error messages (e.g., invalid input, queue is empty when processing).
 * 
 * 5.  **Error Handling and Best Practices:**
 *     *   Implement input validation for menu choices (ensure it's an integer within the valid range).
 *     *   Handle potential exceptions, such as `InputMismatchException` when reading integer input.
 *     *   Use a class-wide `try-catch` block in the main interaction loop to catch unexpected runtime errors gracefully.
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Ensure resources like `Scanner` are closed properly.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt for input, and produce output corresponding to the chosen action. Error messages should be printed to standard error (`System.err`).
 * 
 * Example Interaction Snippet:
 * 
 * ```
 * --- Support System Menu ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Pending Queue
 * 4. View Available Agents
 * 5. Exit
 * Enter your choice: 1
 * Enter request description: Printer not working
 * Request 1 added to queue.
 * 
 * --- Support System Menu ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Pending Queue
 * 4. View Available Agents
 * 5. Exit
 * Enter your choice: 1
 * Enter request description: Software installation issue
 * Request 2 added to queue.
 * 
 * --- Support System Menu ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Pending Queue
 * 4. View Available Agents
 * 5. Exit
 * Enter your choice: 3
 * --- Pending Requests ---
 * ID: 1, Description: Printer not working
 * ID: 2, Description: Software installation issue
 * 
 * --- Support System Menu ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Pending Queue
 * 4. View Available Agents
 * 5. Exit
 * Enter your choice: 2
 * Processing request ID: 1 (Printer not working). Assigned to an agent.
 * Request 1 processed and removed from queue.
 * 
 * --- Support System Menu ---
 * ... (and so on)
 * ```
 * 
 * **Time Limit:** 45-60 minutes
 * 
 * Write the complete Java code for this system.
 *
 * EXPLANATION:
 * This solution implements a simple technical support request management system, fulfilling all the requirements of the exam task.
 * 
 * 1.  **Data Structures:**
 *     *   A `Queue<SupportRequest>` named `requestQueue` is used to store pending support requests. `LinkedList` is chosen as the concrete implementation because it efficiently supports the queue operations (`add`/ `offer` for adding to the end, `poll`/`remove` for removing from the front, `peek`/`element` for viewing the front). This adheres to the FIFO requirement.
 *     *   A `List<SupportAgent>` named `availableAgents` is used to store the support agents. `ArrayList` is chosen as the concrete implementation, suitable for storing and iterating over a collection of agents. The variable is declared using the `List` interface type, demonstrating polymorphism and good practice.
 * 
 * 2.  **Classes:**
 *     *   `SupportRequest`: A simple inner class with private fields (`requestId`, `description`, `status`) and public getter methods, demonstrating encapsulation. It includes a `toString()` method for easy printing.
 *     *   `SupportAgent`: Another simple inner class with private fields (`agentId`, `name`) and public getter methods, also demonstrating encapsulation. It includes a `toString()` method.
 *     *   `SupportSystem`: The main class containing the application logic. It holds instances of the queue and list, the `nextRequestId` counter, and methods for the system's operations. The `main` method creates a `SupportSystem` object and calls its `run` method.
 * 
 * 3.  **Functionality:**
 *     *   `addRequest(String description)`: Takes a description, generates a unique ID using `nextRequestId++`, creates a `SupportRequest` object, and adds it to the `requestQueue` using `queue.add()`. Includes basic input validation for the description.
 *     *   `processNextRequest()`: Checks if the queue is empty using `requestQueue.isEmpty()`. If not empty, it retrieves and removes the head of the queue using `requestQueue.poll()`. It then prints a message simulating the processing and assignment. If the queue is empty, an error message is printed to `System.err`.
 *     *   `viewQueue()`: Iterates through the `requestQueue` using an enhanced for loop. This allows viewing the elements without removing them, as required. It prints the details of each request.
 *     *   `viewAgents()`: Iterates through the `availableAgents` list and prints the details of each agent.
 *     *   `run()`: Contains the main application loop. It repeatedly displays the menu, reads user input, and uses a `switch` statement to dispatch the call to the appropriate method based on the user's choice. The loop continues until the user chooses option 5 (Exit).
 * 
 * 4.  **User Interface:**
 *     *   `Scanner`: An instance of `Scanner` is used to read input from `System.in`. It's created before the loop and closed in the `finally` block.
 *     *   Menu and `switch`: The `displayMenu()` method prints the options. The `run()` method reads the integer choice and uses a `switch` statement to execute the corresponding code block. A `default` case handles invalid integer inputs outside the range 1-5.
 *     *   `System.out` and `System.err`: `System.out.println` is used for the menu, confirmations, and listing items. `System.err.println` is specifically used for printing error messages (e.g., empty queue, invalid input type, invalid choice number).
 * 
 * 5.  **Error Handling and Best Practices:**
 *     *   **Input Validation:** The code checks if the request description is empty or null in `addRequest`. The `switch` statement handles integer choices outside the valid range (1-5).
 *     *   **`InputMismatchException`:** A `try-catch` block is specifically placed around `scanner.nextInt()` within the main loop. If the user enters non-integer input, this block catches the exception, prints an error to `System.err`, and consumes the invalid input using `scanner.nextLine()` to prevent an infinite loop.
 *     *   **Class-wide `try-catch`:** The entire `while` loop within the `run()` method is wrapped in a broad `try-catch(Exception e)`. This serves as a safety net to catch any other unexpected runtime exceptions that might occur during the execution of the core logic, printing an error message and the stack trace to `System.err`.
 *     *   **Encapsulation:** Private fields and public methods are used in the inner classes and the main class.
 *     *   **Naming:** Variable and method names are descriptive (e.g., `requestQueue`, `processNextRequest`, `availableAgents`).
 *     *   **Comments/Documentation:** Javadoc comments are included for classes and key methods, explaining their purpose.
 *     *   **Resource Management:** The `Scanner` is closed in a `finally` block to ensure it's always closed, even if exceptions occur.
 * 
 * This solution effectively integrates the required Java components into a practical, menu-driven application, demonstrating understanding of data structures, object-oriented programming, user interaction, and robust error handling.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Main class for the Technical Support Request Management System.
 * Manages the queue of support requests and the list of agents.
 */
public class SupportSystem {

    // --- Inner Classes ---

    /**
     * Represents a support request (ticket).
     */
    private static class SupportRequest {
        private int requestId;
        private String description;
        private String status;

        /**
         * Constructs a new SupportRequest.
         * @param requestId The unique ID for the request.
         * @param description The description of the issue.
         */
        public SupportRequest(int requestId, String description) {
            this.requestId = requestId;
            this.description = description;
            this.status = "Pending"; // Initial status
        }

        // Getters
        public int getRequestId() {
            return requestId;
        }

        public String getDescription() {
            return description;
        }

        public String getStatus() {
            return status;
        }

        // Setter for status (if needed for processing simulation)
        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "ID: " + requestId + ", Description: " + description + ", Status: " + status;
        }
    }

    /**
     * Represents a support agent.
     */
    private static class SupportAgent {
        private int agentId;
        private String name;

        /**
         * Constructs a new SupportAgent.
         * @param agentId The unique ID for the agent.
         * @param name The name of the agent.
         */
        public SupportAgent(int agentId, String name) {
            this.agentId = agentId;
            this.name = name;
        }

        // Getters
        public int getAgentId() {
            return agentId;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Agent ID: " + agentId + ", Name: " + name;
        }
    }

    // --- SupportSystem Fields ---

    private Queue<SupportRequest> requestQueue;
    private List<SupportAgent> availableAgents;
    private int nextRequestId; // Counter for generating unique request IDs

    // --- Constructor ---

    /**
     * Constructs the SupportSystem, initializing queues and agents.
     */
    public SupportSystem() {
        this.requestQueue = new LinkedList<>(); // LinkedList implements Queue
        this.availableAgents = new ArrayList<>(); // ArrayList implements List
        this.nextRequestId = 1; // Start request IDs from 1

        // Add some initial agents
        availableAgents.add(new SupportAgent(101, "Alice"));
        availableAgents.add(new SupportAgent(102, "Bob"));
        availableAgents.add(new SupportAgent(103, "Charlie"));
    }

    // --- Core Functionality Methods ---

    /**
     * Adds a new support request to the queue.
     * @param description The description of the issue.
     */
    public void addRequest(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Request description cannot be empty.");
            return;
        }
        SupportRequest newRequest = new SupportRequest(nextRequestId++, description.trim());
        requestQueue.add(newRequest);
        System.out.println("Request " + newRequest.getRequestId() + " added to queue.");
    }

    /**
     * Processes the next request from the queue (FIFO).
     * Removes the request and simulates assignment to an agent.
     */
    public void processNextRequest() {
        // Check if the queue is empty before polling
        if (requestQueue.isEmpty()) {
            System.err.println("Error: The request queue is currently empty. No requests to process.");
            return;
        }

        // poll() retrieves and removes the head of the queue, returns null if empty
        // We already checked for empty, so it won't return null here.
        SupportRequest requestToProcess = requestQueue.poll();

        // Simulate processing and assignment
        if (requestToProcess != null) {
            requestToProcess.setStatus("Processing"); // Update status (optional simulation)
            // In a real system, you'd assign an agent based on availability etc.
            // For this simulation, we just state it's assigned.
            System.out.println("Processing request ID: " + requestToProcess.getRequestId() +
                               " (" + requestToProcess.getDescription() + "). Assigned to an agent.");
            System.out.println("Request " + requestToProcess.getRequestId() + " processed and removed from queue.");
        }
    }

    /**
     * Displays all pending requests in the queue.
     */
    public void viewQueue() {
        if (requestQueue.isEmpty()) {
            System.out.println("The pending request queue is empty.");
            return;
        }
        System.out.println("--- Pending Requests ---");
        // Iterate through the queue without removing elements
        for (SupportRequest request : requestQueue) {
            System.out.println(request);
        }
        System.out.println("------------------------");
    }

    /**
     * Displays all available support agents.
     */
    public void viewAgents() {
        if (availableAgents.isEmpty()) {
            System.out.println("No support agents available.");
            return;
        }
        System.out.println("--- Available Agents ---");
        for (SupportAgent agent : availableAgents) {
            System.out.println(agent);
        }
        System.out.println("------------------------");
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Support System Menu ---");
        System.out.println("1. Add New Request");
        System.out.println("2. Process Next Request");
        System.out.println("3. View Pending Queue");
        System.out.println("4. View Available Agents");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop, handling user interaction.
     * Includes class-wide exception handling.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1; // Use -1 to indicate no valid choice yet

        // Class-wide try-catch for the main interaction loop
        try {
            while (choice != 5) {
                displayMenu();

                try {
                    choice = scanner.nextInt(); // Read integer choice
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    // Use switch statement for menu control
                    switch (choice) {
                        case 1:
                            System.out.print("Enter request description: ");
                            String description = scanner.nextLine();
                            addRequest(description);
                            break;
                        case 2:
                            processNextRequest();
                            break;
                        case 3:
                            viewQueue();
                            break;
                        case 4:
                            viewAgents();
                            break;
                        case 5:
                            System.out.println("Exiting Support System. Goodbye!");
                            break;
                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    // Handles non-integer input for menu choice
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to stay in the loop
                }
                // No specific catch for NoSuchElementException needed here as poll() handles empty queue.
                // Other runtime exceptions would be caught by the outer try-catch.
            }
        } catch (Exception e) {
            // Broad catch for any unexpected runtime errors during the main loop
            System.err.println("\nAn unexpected system error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed even if an exception occurs or loop finishes
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed.");
            }
        }
    }

    // --- Main Method ---

    /**
     * Entry point of the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SupportSystem system = new SupportSystem();
        system.run(); // Start the main application loop
    }
}
