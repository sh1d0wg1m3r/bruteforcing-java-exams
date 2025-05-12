/*
 * Exam Question #38
 * Generated on: 2025-05-11 21:56:07
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Customer Service Request Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simple console-based system to manage customer service requests for a small team. When a request arrives, it's placed in a waiting queue. Agents can then take the next request from the queue to work on it. Once they finish, they mark the request as completed. The system should maintain a history of all requests, regardless of their current status.
 * 
 * **Requirements:**
 * 
 * 1.  **`RequestStatus` Enum:** Create a simple enum `RequestStatus` with values `WAITING`, `IN_PROGRESS`, and `COMPLETED`.
 * 2.  **`Request` Class:**
 *     *   Implement a class named `Request`.
 *     *   It must have private fields: `id` (int), `description` (String), and `status` (`RequestStatus`).
 *     *   The constructor should initialize the description and set the initial status to `WAITING`. The ID should be assigned externally (e.g., by the manager).
 *     *   Provide public getter methods for all fields (`getId`, `getDescription`, `getStatus`).
 *     *   Provide a public setter method `setStatus(RequestStatus status)` to update the request's status.
 *     *   Override the `toString()` method to provide a clear string representation of the request (e.g., "ID: [id], Desc: [description], Status: [status]").
 *     *   Ensure proper encapsulation (private fields, public methods).
 * 3.  **`RequestManager` Class:**
 *     *   Implement a class named `RequestManager`.
 *     *   It must use a `java.util.Queue<Request>` (specifically, a `java.util.LinkedList` implementation) named `waitingRequests` to store requests that are currently waiting to be assigned.
 *     *   It must use a `java.util.List<Request>` (specifically, a `java.util.ArrayList` implementation) named `allRequests` to store *all* requests created in the system (waiting, in-progress, and completed).
 *     *   Include a private field `nextRequestId` (int) initialized to 1, used to assign unique sequential IDs to new requests.
 *     *   Implement the following public methods:
 *         *   `addRequest(String description)`: Creates a new `Request` object with the next available ID and provided description. Sets its status to `WAITING`. Adds the *same* `Request` object reference to both `waitingRequests` queue and `allRequests` list. Increments `nextRequestId`.
 *         *   `takeNextRequest()`: Removes the request at the front of the `waitingRequests` queue using `poll()`. If a request is successfully removed (queue was not empty), find the *corresponding* `Request` object in the `allRequests` list (or directly update the status of the polled object, as they are the same reference) and update its status to `IN_PROGRESS`. Return the `Request` object that was taken, or `null` if the `waitingRequests` queue was empty.
 *         *   `completeRequest(int id)`: Searches the `allRequests` list for a request with the given ID. If found and its current status is `IN_PROGRESS`, update its status to `COMPLETED`. Return `true` if a request was found and successfully completed, `false` otherwise (request not found, or found but not in `IN_PROGRESS` status).
 *         *   `getAllRequests()`: Returns the `allRequests` list.
 *         *   `getWaitingRequests()`: Returns the `waitingRequests` queue.
 *     *   Ensure proper encapsulation.
 * 4.  **`ServiceSystem` Class (Main Class):**
 *     *   Implement a class named `ServiceSystem` with a `main` method.
 *     *   Use `java.util.Scanner` to get user input from the console.
 *     *   Create an instance of `RequestManager`.
 *     *   Implement a main loop that continuously displays a menu to the user with the following options:
 *         1.  Add New Request
 *         2.  Take Next Waiting Request
 *         3.  Complete Request by ID
 *         4.  View All Requests
 *         5.  View Waiting Requests
 *         6.  Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Use `System.out` to display the menu, prompts, and successful operation messages (e.g., "Request added successfully", "Taken request: ...", listing request details).
 *     *   Use `System.err` to display error messages (e.g., "Invalid menu choice", "No waiting requests to take", "Request with ID [id] not found or not in IN_PROGRESS status").
 *     *   Implement class-wide exception handling using `try-catch` blocks around the user input reading and processing within the main loop to gracefully handle potential errors like non-numeric input (`NumberFormatException`) or other unexpected issues.
 *     *   Ensure input validation (e.g., checking if the input for menu choice is an integer).
 * 
 * **Expected Output:**
 * 
 * The program should start, display the menu, and respond to user input. Adding requests should show a success message. Taking a request should show which request was taken or an error if none are waiting. Completing a request should confirm completion or report an error if the ID is invalid or status is wrong. Viewing options should list the details of the relevant requests. Invalid input or operations should result in error messages printed to `System.err`. The program should exit cleanly when the 'Exit' option is chosen.
 * 
 * **Constraints:**
 * 
 * You MUST use the following Java components as specified:
 * *   `java.util.Queue`
 * *   `java.util.ArrayList`
 * *   `java.util.List` (as the type for `allRequests`)
 * *   `java.util.Scanner`
 * *   `switch` statement
 * *   `System.err`
 * *   `System.out`
 * *   Class-wide `try-catch` blocks
 *
 * EXPLANATION:
 * This solution implements a simple Customer Service Request Management System as described in the exam question, demonstrating the required Java concepts.
 * 
 * 1.  **`RequestStatus` Enum:** A basic enum is used to define the possible states of a request, providing type safety and readability compared to using raw strings or integers for status.
 * 2.  **`Request` Class:** This class encapsulates the data for a single request (`id`, `description`, `status`). Private fields and public getter/setter methods ensure proper encapsulation. The `toString()` method provides a convenient way to display request details.
 * 3.  **`RequestManager` Class:**
 *     *   It uses a `Queue<Request>` (`waitingRequests`) implemented by `LinkedList` to manage the flow of requests needing attention, adhering to the FIFO principle for `poll()`.
 *     *   It uses a `List<Request>` (`allRequests`) implemented by `ArrayList` to maintain a history of all requests created in the system, allowing easy iteration and lookup (though lookup by ID involves a linear scan in this simple implementation).
 *     *   The `addRequest` method creates a new `Request` object and adds the *same object reference* to both the queue and the list. This is crucial because when a request's status is updated (e.g., from `WAITING` to `IN_PROGRESS`), the change is reflected in the *single* `Request` object, which is referenced by both collections.
 *     *   `takeNextRequest` uses `waitingRequests.poll()` to remove the head of the queue. If successful, it updates the status of the *polled object* directly, which automatically updates the status in the `allRequests` list as well since it's the same object.
 *     *   `completeRequest` iterates through the `allRequests` list to find the request by ID. This demonstrates the use of the `List` for lookup. It includes validation to ensure the request exists and is in the `IN_PROGRESS` status before marking it `COMPLETED`. Error messages are printed to `System.err`.
 *     *   `getAllRequests` and `getWaitingRequests` provide access to the underlying collections for viewing purposes.
 * 4.  **`ServiceSystem` Class (Main):**
 *     *   The `main` method drives the application using a `Scanner` to interact with the user via the console.
 *     *   A `while(true)` loop creates the main application loop.
 *     *   A `try-catch` block wraps the core logic inside the loop. This provides "class-wide" exception handling for the main execution flow, catching potential errors like `NumberFormatException` during input parsing or other unexpected exceptions.
 *     *   Input validation for the menu choice is done by attempting to parse the input string and catching `NumberFormatException`, printing an error to `System.err`.
 *     *   A `switch` statement is used to dispatch actions based on the validated user choice, calling the appropriate methods in the `RequestManager`.
 *     *   `System.out` is used for displaying the menu, prompts, successful action confirmations, and request listings.
 *     *   `System.err` is used specifically for printing error messages, separating them from normal output, which is a good practice for console applications.
 *     *   The "View Waiting Requests" case demonstrates iterating over the `Queue` using an enhanced for loop, which allows viewing elements without removing them (unlike methods like `poll()`).
 *     *   The "Exit" case closes the `Scanner` resource and uses `return` to terminate the `main` method and thus the program.
 * 
 * This solution effectively integrates all the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) into a practical, albeit simple, application while adhering to best practices like encapsulation, meaningful names, and error handling. The use of the same `Request` object reference in both the `Queue` and `List` is a key design point that leverages object identity.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 1. RequestStatus Enum
enum RequestStatus {
    WAITING,
    IN_PROGRESS,
    COMPLETED
}

// 2. Request Class
class Request {
    private int id;
    private String description;
    private RequestStatus status;

    // Constructor
    public Request(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = RequestStatus.WAITING; // Initial status
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public RequestStatus getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "ID: " + id + ", Desc: \"" + description + "\", Status: " + status;
    }
}

// 3. RequestManager Class
class RequestManager {
    // Required components: Queue and List (ArrayList implementation)
    private Queue<Request> waitingRequests;
    private List<Request> allRequests;
    private int nextRequestId; // For assigning unique IDs

    // Constructor
    public RequestManager() {
        // Use LinkedList for Queue implementation as required
        this.waitingRequests = new LinkedList<>();
        // Use ArrayList for List implementation as required
        this.allRequests = new ArrayList<>();
        this.nextRequestId = 1; // Start IDs from 1
    }

    /**
     * Adds a new request to the system.
     * @param description The description of the request.
     */
    public void addRequest(String description) {
        // Create a new Request object
        Request newRequest = new Request(nextRequestId++, description);

        // Add the same request object reference to both collections
        waitingRequests.offer(newRequest); // Add to the end of the waiting queue
        allRequests.add(newRequest);     // Add to the end of the all requests list

        System.out.println(System.lineSeparator() + "-> Request added successfully: " + newRequest.toString());
    }

    /**
     * Takes the next waiting request from the queue and marks it as in progress.
     * @return The Request object that was taken, or null if no requests are waiting.
     */
    public Request takeNextRequest() {
        // Remove the head of the queue
        Request nextWaiting = waitingRequests.poll();

        if (nextWaiting != null) {
            // The polled object is the same reference in allRequests, update its status directly.
            nextWaiting.setStatus(RequestStatus.IN_PROGRESS);
            return nextWaiting;
        } else {
            // Queue was empty
            return null;
        }
    }

    /**
     * Completes a request by its ID.
     * @param id The ID of the request to complete.
     * @return true if the request was found and successfully completed, false otherwise.
     */
    public boolean completeRequest(int id) {
        // Iterate through all requests to find the one with the matching ID
        for (Request req : allRequests) {
            if (req.getId() == id) {
                // Found the request
                if (req.getStatus() == RequestStatus.IN_PROGRESS) {
                    // Request is in progress, mark as completed
                    req.setStatus(RequestStatus.COMPLETED);
                    System.out.println(System.lineSeparator() + "-> Request ID " + id + " marked as COMPLETED.");
                    return true;
                } else {
                    // Request found, but not in IN_PROGRESS status
                    System.err.println(System.lineSeparator() + "-> Error: Request ID " + id + " is not in IN_PROGRESS status. Current status: " + req.getStatus());
                    return false;
                }
            }
        }
        // Request with the given ID was not found
        System.err.println(System.lineSeparator() + "-> Error: Request with ID " + id + " not found.");
        return false;
    }

    /**
     * Returns the list of all requests.
     * @return The List of all requests.
     */
    public List<Request> getAllRequests() {
        return allRequests;
    }

    /**
     * Returns the queue of waiting requests.
     * @return The Queue of waiting requests.
     */
    public Queue<Request> getWaitingRequests() {
        return waitingRequests;
    }
}

// 4. ServiceSystem Class (Main Class)
public class ServiceSystem {

    public static void main(String[] args) {
        // Required component: Scanner for user input
        Scanner scanner = new Scanner(System.in);
        RequestManager manager = new RequestManager();

        // Main application loop
        while (true) {
            // Required component: System.out for normal output (menu, prompts)
            System.out.println(System.lineSeparator() + "--- Service Request System Menu ---");
            System.out.println("1. Add New Request");
            System.out.println("2. Take Next Waiting Request");
            System.println("3. Complete Request by ID");
            System.out.println("4. View All Requests");
            System.out.println("5. View Waiting Requests");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            // Required component: Class-wide exception handling with try-catch
            try {
                // Read user input line to handle potential non-integer input gracefully
                String input = scanner.nextLine();
                int choice;

                // Required component: Input validation
                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    // Required component: System.err for error messages
                    System.err.println(System.lineSeparator() + "-> Error: Invalid input. Please enter a number.");
                    continue; // Skip the rest of the loop and show menu again
                }

                // Required component: Switch statement for flow control
                switch (choice) {
                    case 1: // Add New Request
                        System.out.print("Enter request description: ");
                        String description = scanner.nextLine();
                        if (description == null || description.trim().isEmpty()) {
                             System.err.println(System.lineSeparator() + "-> Error: Description cannot be empty.");
                        } else {
                            manager.addRequest(description.trim());
                        }
                        break;

                    case 2: // Take Next Waiting Request
                        System.out.println(System.lineSeparator() + "Attempting to take next waiting request...");
                        Request takenRequest = manager.takeNextRequest();
                        if (takenRequest != null) {
                            System.out.println("-> Taken request: " + takenRequest.toString());
                        } else {
                            // Required component: System.err for error messages
                            System.err.println("-> Error: No waiting requests available.");
                        }
                        break;

                    case 3: // Complete Request by ID
                        System.out.print("Enter ID of request to complete: ");
                        String idInput = scanner.nextLine();
                        try {
                            int idToComplete = Integer.parseInt(idInput);
                            manager.completeRequest(idToComplete);
                        } catch (NumberFormatException e) {
                            // Required component: System.err for error messages
                            System.err.println(System.lineSeparator() + "-> Error: Invalid ID format. Please enter a number.");
                        }
                        break;

                    case 4: // View All Requests
                        System.out.println(System.lineSeparator() + "--- All Requests ---");
                        List<Request> all = manager.getAllRequests();
                        if (all.isEmpty()) {
                            System.out.println("No requests in the system yet.");
                        } else {
                            for (Request req : all) {
                                System.out.println(req.toString());
                            }
                        }
                        break;

                    case 5: // View Waiting Requests
                        System.out.println(System.lineSeparator() + "--- Waiting Requests ---");
                        Queue<Request> waiting = manager.getWaitingRequests();
                        if (waiting.isEmpty()) {
                            System.out.println("No requests currently waiting.");
                        } else {
                            // Iterate through the queue without removing elements
                            for (Request req : waiting) {
                                System.out.println(req.toString());
                            }
                        }
                        break;

                    case 6: // Exit
                        System.out.println(System.lineSeparator() + "Exiting system. Goodbye!");
                        scanner.close(); // Close the scanner
                        return; // Exit the main method

                    default:
                        // Required component: System.err for error messages
                        System.err.println(System.lineSeparator() + "-> Error: Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (Exception e) {
                // General exception handling for unexpected errors
                // Required component: System.err for error messages
                System.err.println(System.lineSeparator() + "-> An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to error stream
            }
        }
    }
}
