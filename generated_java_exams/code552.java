/*
 * Exam Question #552
 * Generated on: 2025-05-11 23:28:36
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Service Request Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simple command-line application to manage service requests (like IT support tickets). The system should allow users to add new requests, process the oldest pending request, view pending requests, and view completed requests.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `Queue` to store service requests that are waiting to be processed.
 *     *   Use an `ArrayList` (referenced by the `List` interface) to store service requests that have been completed.
 * 2.  **Request Representation:**
 *     *   Create a `ServiceRequest` class with private fields for `id` (integer), `description` (String), and `status` (String, e.g., "Pending", "Completed").
 *     *   Implement a constructor, appropriate getters, and a method to update the status (e.g., `markAsCompleted()`).
 *     *   Override the `toString()` method to provide a user-friendly representation of a request.
 * 3.  **Request Management Logic:**
 *     *   Create a `RequestManager` class.
 *     *   This class should hold the `Queue` of pending requests and the `List` of completed requests as private fields.
 *     *   Implement methods:
 *         *   `addRequest(String description)`: Creates a new `ServiceRequest` with a unique ID (starting from 1), sets its status to "Pending", and adds it to the pending queue. Print a confirmation message to `System.out`.
 *         *   `processNextRequest()`: Removes the oldest request from the pending queue, updates its status to "Completed", and adds it to the completed list. If the queue is empty, print an error message to `System.err`. Otherwise, print a success message to `System.out`.
 *         *   `viewPendingRequests()`: Prints all requests currently in the pending queue to `System.out`. If the queue is empty, print a message indicating that.
 *         *   `viewCompletedRequests()`: Prints all requests in the completed list to `System.out`. If the list is empty, print a message indicating that.
 * 4.  **User Interface:**
 *     *   Create a main class (e.g., `ServiceRequestApp`) with a `main` method.
 *     *   In the `main` method, create an instance of `RequestManager`.
 *     *   Implement a command-line menu loop using `Scanner` to get user input.
 *     *   The menu should offer options: "add", "process", "view pending", "view completed", "exit".
 *     *   Use a `switch` statement to handle the user's chosen command.
 *     *   Call the appropriate `RequestManager` methods based on the command.
 *     *   For the "add" command, prompt the user for the request description.
 * 5.  **Error Handling & Output:**
 *     *   Use `System.out` for all normal output (menu, prompts, success messages, list contents).
 *     *   Use `System.err` specifically for error messages (e.g., trying to process an empty queue).
 *     *   Implement class-wide exception handling (e.g., using a `try-catch` block around the main command processing loop) to catch unexpected errors and print an error message to `System.err` before exiting or continuing. Ensure the `Scanner` resource is properly managed (closed).
 * 6.  **Best Practices:**
 *     *   Employ proper encapsulation (`private` fields, `public` methods).
 *     *   Use meaningful variable and method names.
 *     *   Include brief comments where necessary to explain complex logic.
 *     *   Ensure clean code structure and formatting.
 *     *   Include basic input validation (e.g., handling invalid menu commands).
 * 
 * **Expected Interaction:**
 * 
 * The program should present a menu, accept commands, perform the requested action, print output/errors, and repeat until the user enters "exit".
 * 
 * ```
 * Service Request Management System
 * Menu: add, process, view pending, view completed, exit
 * Enter command: add
 * Enter request description: My computer is slow
 * Request 1 added: My computer is slow [Pending]
 * Enter command: add
 * Enter request description: Printer needs ink
 * Request 2 added: Printer needs ink [Pending]
 * Enter command: view pending
 * Pending Requests:
 * ID: 1, Description: My computer is slow, Status: Pending
 * ID: 2, Description: Printer needs ink, Status: Pending
 * Enter command: process
 * Processing request 1: My computer is slow
 * Request 1 marked as Completed.
 * Enter command: view pending
 * Pending Requests:
 * ID: 2, Description: Printer needs ink, Status: Pending
 * Enter command: view completed
 * Completed Requests:
 * ID: 1, Description: My computer is slow, Status: Completed
 * Enter command: process
 * Processing request 2: Printer needs ink
 * Request 2 marked as Completed.
 * Enter command: process
 * Error: No pending requests to process.
 * Enter command: view pending
 * No pending requests.
 * Enter command: view completed
 * Completed Requests:
 * ID: 1, Description: My computer is slow, Status: Completed
 * ID: 2, Description: Printer needs ink, Status: Completed
 * Enter command: invalid_command
 * Error: Invalid command. Please try again.
 * Enter command: exit
 * Exiting system.
 * ```
 * 
 * **Evaluation:**
 * 
 * Your solution will be evaluated based on:
 * *   Correct implementation and usage of all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`).
 * *   Correctness of the service request management logic.
 * *   Adherence to best practices (encapsulation, naming, comments, structure).
 * *   Proper input handling and error reporting.
 * *   Clear and correct output format.
 *
 * EXPLANATION:
 * The provided solution implements a simple Service Request Management System as requested, demonstrating the use of various core Java concepts and best practices.
 * 
 * 1.  **`ServiceRequest` Class:** This class encapsulates the data for a single request. It has private fields (`id`, `description`, `status`), a constructor, getters, and a `markAsCompleted` method, adhering to encapsulation principles. The `toString()` method provides a convenient way to print request details.
 * 
 * 2.  **`RequestManager` Class:** This class manages the collections of requests.
 *     *   It uses a `Queue<ServiceRequest>` (`pendingRequests`) implemented by `LinkedList`. The `Queue` is suitable for pending requests because they are processed in a First-In, First-Out (FIFO) order, naturally handled by `offer()` (add) and `poll()` (remove and retrieve).
 *     *   It uses a `List<ServiceRequest>` (`completedRequests`) implemented by `ArrayList`. The `List` is suitable for completed requests as they are stored for historical viewing, and an `ArrayList` provides efficient storage and iteration.
 *     *   `nextRequestId` is a simple counter for generating unique IDs.
 *     *   Methods like `addRequest`, `processNextRequest`, `viewPendingRequests`, and `viewCompletedRequests` implement the core logic, interacting with the collections.
 * 
 * 3.  **Core Logic Implementation:**
 *     *   `addRequest`: Creates a new `ServiceRequest` and adds it to the `pendingRequests` queue using `offer()`.
 *     *   `processNextRequest`: Uses `poll()` to get and remove the head of the `pendingRequests` queue. It checks if `poll()` returned `null` (indicating an empty queue) and handles this case by printing an error to `System.err`. If a request is retrieved, its status is updated, and it's added to the `completedRequests` list.
 *     *   `viewPendingRequests` and `viewCompletedRequests`: Iterate through the respective collections (Queue and List) and print the details of each request using the `toString()` method. They also handle the case where the collections are empty.
 * 
 * 4.  **User Interface (`RequestManager.run()`):**
 *     *   A `Scanner` is used to read user input from the console.
 *     *   A `while` loop keeps the application running until the "exit" command is entered.
 *     *   User input is read using `scanner.nextLine()`, trimmed, and converted to lowercase for case-insensitive command matching.
 *     *   A `switch` statement is used to direct the flow based on the user's command, calling the appropriate `RequestManager` methods.
 *     *   The `default` case in the `switch` handles invalid commands, printing an error to `System.err`.
 *     *   Basic input validation is included for the "add" command to ensure the description is not empty.
 * 
 * 5.  **Error Handling and Output:**
 *     *   `System.out` is used for all standard output: menu display, prompts, success messages, and listing request details.
 *     *   `System.err` is specifically used for error conditions, such as attempting to process a request when the queue is empty or entering an invalid command.
 *     *   A `try-catch(Exception e)` block is wrapped around the main command processing `while` loop within the `run` method. This demonstrates class-wide exception handling, catching any unexpected runtime exceptions that might occur during command execution and printing an error message to `System.err`.
 *     *   The `Scanner` resource is managed using a `try-with-resources` block (`try (Scanner scanner = new Scanner(System.in))`), ensuring that the scanner is automatically closed when the `try` block is exited (either normally or due to an exception), preventing resource leaks.
 * 
 * 6.  **Best Practices:**
 *     *   Private fields and public methods ensure proper encapsulation.
 *     *   Variable names (`pendingRequests`, `completedRequests`, `nextRequestId`, `description`, `command`) and method names (`addRequest`, `processNextRequest`, `viewPendingRequests`, `run`) are meaningful and descriptive.
 *     *   Comments are included to explain the purpose of classes and methods.
 *     *   The code is structured into logical classes (`ServiceRequest`, `RequestManager`, `ServiceRequestApp`).
 * 
 * This solution effectively integrates the required Java components into a practical, albeit simple, application, demonstrating understanding of data structures, object-oriented programming, user interaction, and error handling.
 */

import java.util.Queue;
import java.util.LinkedList; // A common Queue implementation
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

// Represents a single service request
class ServiceRequest {
    private int id;
    private String description;
    private String status; // e.g., "Pending", "Completed"

    public ServiceRequest(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Pending"; // New requests are always pending
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // Method to update status
    public void markAsCompleted() {
        this.status = "Completed";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Description: " + description + ", Status: " + status;
    }
}

// Manages the collection of service requests
class RequestManager {
    // Queue for requests waiting to be processed (FIFO)
    private Queue<ServiceRequest> pendingRequests;
    // List for requests that have been completed
    private List<ServiceRequest> completedRequests;
    // Counter for generating unique request IDs
    private int nextRequestId;

    public RequestManager() {
        // Initialize collections
        this.pendingRequests = new LinkedList<>(); // LinkedList implements Queue
        this.completedRequests = new ArrayList<>(); // ArrayList implements List
        this.nextRequestId = 1; // Start IDs from 1
    }

    /**
     * Adds a new service request to the pending queue.
     * @param description The description of the request.
     */
    public void addRequest(String description) {
        ServiceRequest newRequest = new ServiceRequest(nextRequestId++, description);
        pendingRequests.offer(newRequest); // offer is preferred over add for queues
        System.out.println("Request " + newRequest.getId() + " added: " + description + " [" + newRequest.getStatus() + "]");
    }

    /**
     * Processes the next request in the pending queue.
     * Moves the request from pending to completed list.
     */
    public void processNextRequest() {
        ServiceRequest requestToProcess = pendingRequests.poll(); // Retrieves and removes the head of the queue

        if (requestToProcess == null) {
            // Use System.err for error messages
            System.err.println("Error: No pending requests to process.");
        } else {
            System.out.println("Processing request " + requestToProcess.getId() + ": " + requestToProcess.getDescription());
            requestToProcess.markAsCompleted(); // Update status
            completedRequests.add(requestToProcess); // Add to completed list
            System.out.println("Request " + requestToProcess.getId() + " marked as Completed.");
        }
    }

    /**
     * Displays all pending service requests.
     */
    public void viewPendingRequests() {
        System.out.println("Pending Requests:");
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            // Iterate through the queue without removing elements
            for (ServiceRequest request : pendingRequests) {
                System.out.println(request); // Uses ServiceRequest.toString()
            }
        }
    }

    /**
     * Displays all completed service requests.
     */
    public void viewCompletedRequests() {
        System.out.println("Completed Requests:");
        if (completedRequests.isEmpty()) {
            System.out.println("No completed requests.");
        } else {
            // Iterate through the list
            for (ServiceRequest request : completedRequests) {
                System.out.println(request); // Uses ServiceRequest.toString()
            }
        }
    }

    /**
     * Runs the main application loop, handling user input.
     */
    public void run() {
        System.out.println("Service Request Management System");
        // Use try-with-resources to ensure the Scanner is closed
        try (Scanner scanner = new Scanner(System.in)) {
            String command;
            // Class-wide exception handling around the main loop
            try {
                while (true) {
                    System.out.println("\nMenu: add, process, view pending, view completed, exit");
                    System.out.print("Enter command: ");
                    command = scanner.nextLine().trim().toLowerCase(); // Read command, trim whitespace, convert to lowercase

                    // Use a switch statement for command handling
                    switch (command) {
                        case "add":
                            System.out.print("Enter request description: ");
                            String description = scanner.nextLine().trim();
                            if (!description.isEmpty()) {
                                addRequest(description);
                            } else {
                                System.err.println("Error: Description cannot be empty.");
                            }
                            break;
                        case "process":
                            processNextRequest();
                            break;
                        case "view pending":
                            viewPendingRequests();
                            break;
                        case "view completed":
                            viewCompletedRequests();
                            break;
                        case "exit":
                            System.out.println("Exiting system.");
                            return; // Exit the run method and thus the program
                        default:
                            // Handle invalid commands using System.err
                            System.err.println("Error: Invalid command. Please try again.");
                            break;
                    }
                }
            } catch (Exception e) {
                // Catch any unexpected exceptions during the loop
                System.err.println("\nAn unexpected error occurred: " + e.getMessage());
                // Optionally print stack trace for debugging during development, but maybe not in a final exam output
                // e.printStackTrace(System.err);
            }
        } // Scanner is automatically closed here by try-with-resources
    }
}

// Main class to start the application
public class ServiceRequestApp {
    public static void main(String[] args) {
        RequestManager manager = new RequestManager();
        manager.run(); // Start the application loop
    }
}
