/*
 * Exam Question #16
 * Generated on: 2025-05-11 21:35:55
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Tech Support Request Management System
 * 
 * **Objective:** Design and implement a command-line based Tech Support Request Management System demonstrating advanced Java concepts, including various collection types, control flow, and error handling.
 * 
 * **Scenario:**
 * You are building a simplified system for managing technical support requests. Customer requests are added to a queue. Technicians can view the queue and pick up the next available request. Once a technician picks up a request, it's marked as "In Progress". Technicians can then mark the request as "Resolved". The system should maintain a history of resolved requests.
 * 
 * **Requirements:**
 * 1.  **Classes:**
 *     *   `SupportRequest`: Represents a single support request. It should have a unique integer ID, a String description, and a status. Use an `enum` for the status (e.g., `PENDING`, `IN_PROGRESS`, `RESOLVED`). Fields must be private with public getters.
 *     *   `SupportSystemManager`: Manages the collections of requests.
 *         *   It must use a `java.util.Queue` (e.g., `LinkedList`) to store pending requests.
 *         *   It must use a `java.util.List` (implemented by `java.util.ArrayList`) to store requests currently being worked on (`IN_PROGRESS`).
 *         *   It must use a `java.util.List` (implemented by `java.util.ArrayList`) to store resolved requests.
 *         *   Include methods for:
 *             *   Submitting a new request (adds to the pending queue).
 *             *   Viewing pending requests.
 *             *   Picking up the next pending request (removes from pending queue, adds to in-progress list, updates status).
 *             *   Resolving an in-progress request by its ID (removes from in-progress list, adds to resolved list, updates status).
 *             *   Viewing resolved requests.
 *         *   Manage unique request IDs using an internal counter.
 *         *   Implement proper encapsulation (private fields, public methods).
 *     *   `TechSupportApp`: Contains the `main` method and handles user interaction via the command line.
 *         *   Use `java.util.Scanner` to read user input.
 *         *   Implement a menu-driven interface with options for:
 *             1.  Submit New Request
 *             2.  View Pending Requests
 *             3.  Pick Up Next Request
 *             4.  Resolve Request
 *             5.  View Resolved Requests
 *             6.  Exit
 *         *   Use a `switch` statement to process the user's menu choice.
 *         *   Display menu, prompts, and successful operation messages using `System.out`.
 *         *   Display error messages and warnings using `System.err`.
 *         *   Implement **class-wide exception handling** in the `TechSupportApp`'s `main` method using a `try-catch` block to catch any unhandled exceptions during the application's execution loop. Additionally, handle specific expected errors (like invalid input format) gracefully.
 * 
 * 2.  **Data Structures & Control Flow:**
 *     *   Explicitly use `java.util.Queue`, `java.util.ArrayList`, and `java.util.List`.
 *     *   Use `switch` for menu handling.
 *     *   Use loops (`while`, `for` or enhanced `for`) for processing collections.
 * 
 * 3.  **Error Handling & Validation:**
 *     *   Validate user input for menu choices and request IDs (e.g., ensure they are numbers). Handle `NumberFormatException`.
 *     *   Handle cases like trying to pick up a request when the queue is empty.
 *     *   Handle cases like trying to resolve a request that doesn't exist or isn't in the "In Progress" list.
 *     *   Use `System.err` for all error output.
 *     *   Implement the class-wide `try-catch` in `TechSupportApp`.
 * 
 * 4.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Add comments or JavaDocs where necessary to explain complex parts.
 *     *   Ensure code is well-formatted and readable.
 * 
 * **Expected Output:**
 * The program should present a menu, accept user input, perform actions, and display results or errors.
 * 
 * *   Submitting a request should confirm submission and show the new request ID.
 * *   Viewing pending requests should list requests in the order they were submitted.
 * *   Picking up a request should show the details of the request moved to "In Progress".
 * *   Resolving a request should confirm resolution or report if the ID was invalid/not in progress.
 * *   Viewing resolved requests should list completed requests.
 * *   Error messages should be printed to `System.err`.
 * *   An unexpected error should be caught by the main `try-catch` and reported to `System.err`.
 * 
 * **Time Limit:** Approximately 45-60 minutes.
 * 
 * ---
 *
 * EXPLANATION:
 * This solution implements the Tech Support Request Management System as described in the problem statement, utilizing all the required Java components and adhering to best practices.
 * 
 * 1.  **`SupportRequest` Class:**
 *     *   An `enum Status` is used to define the possible states of a request (`PENDING`, `IN_PROGRESS`, `RESOLVED`), making the status explicit and type-safe.
 *     *   The `SupportRequest` class encapsulates the data for a request (ID, description, status) with private fields and public getters. A `setStatus` method is provided for controlled state changes by the manager.
 *     *   A `toString()` method provides a convenient string representation for printing.
 * 
 * 2.  **`SupportSystemManager` Class:**
 *     *   This class acts as the central controller for managing requests.
 *     *   `pendingRequests`: A `java.util.Queue` (specifically `java.util.LinkedList`) is used. The `Queue` interface is ideal for managing items in a waiting line where items are added to one end (`offer`) and removed from the other (`poll`).
 *     *   `inProgressRequests`: A `java.util.List` (specifically `java.util.ArrayList`) is used. This list holds requests that have been picked up by technicians and are actively being worked on. `ArrayList` provides efficient access and modification by index or object.
 *     *   `resolvedRequests`: A `java.util.List` (specifically `java.util.ArrayList`) is used. This list stores requests that have been completed.
 *     *   `nextRequestId`: A simple integer counter ensures each request gets a unique ID.
 *     *   Methods like `submitRequest`, `pickupNextRequest`, and `resolveRequest` manage the flow of requests between these collections and update their status, demonstrating practical use of the collection operations (`offer`, `poll`, `add`, `remove`, iteration). The `resolveRequest` method uses an `Iterator` to safely remove an element from the `inProgressRequests` list while iterating, which is a standard pattern.
 * 
 * 3.  **`TechSupportApp` Class:**
 *     *   Contains the `main` method, the entry point of the application.
 *     *   A `java.util.Scanner` is used to read input from the console (`System.in`). `scanner.nextLine()` is used consistently to avoid common pitfalls with `nextInt()` and `nextLine()`.
 *     *   A `SupportSystemManager` instance is created to handle the core logic.
 *     *   A `while(true)` loop runs the main application cycle, displaying the menu and processing user input until the user chooses to exit.
 *     *   Input for the menu choice is read as a `String` and then parsed into an `int` inside a `try-catch` block specifically for `NumberFormatException`. This ensures that non-numeric input for the menu doesn't crash the program and provides a specific error message using `System.err`.
 *     *   A `switch` statement is used to direct the program flow based on the validated integer choice, calling the appropriate methods on the `SupportSystemManager`.
 *     *   `System.out` is used for all standard output, including the menu, prompts, successful action confirmations, and listing requests.
 *     *   `System.err` is used for all error messages, such as invalid input, empty queues, or requests not found.
 *     *   **Class-wide Exception Handling:** The entire `while` loop in the `main` method is wrapped in a `try-catch (Exception e)` block. This fulfills the requirement for class-wide exception handling, catching any unexpected runtime exceptions that might occur during the execution of the application's main logic and printing an error message and stack trace to `System.err`. Specific anticipated input errors (`NumberFormatException`) are handled more locally for better user feedback, but the broad `catch` provides a safety net for other potential issues.
 *     *   The "Exit" option closes the `Scanner` and uses `return` to terminate the `main` method gracefully.
 * 
 * **Key Concepts Demonstrated:**
 * 
 * *   **Object-Oriented Programming:** Use of classes (`SupportRequest`, `SupportSystemManager`, `TechSupportApp`) with encapsulation.
 * *   **Enums:** Using `enum` for defining a fixed set of states (`Status`).
 * *   **Collections Framework:** Practical application of `Queue` (`LinkedList`) for managing a waiting line and `List` (`ArrayList`) for dynamic lists of objects, showing appropriate use cases for each.
 * *   **Control Flow:** Use of `while` loop for the main application cycle and `switch` statement for multi-way branching based on user input.
 * *   **Input/Output:** Using `Scanner` for console input, `System.out` for standard output, and `System.err` for error output.
 * *   **Error Handling:** Implementation of `try-catch` blocks for handling expected errors (`NumberFormatException`) and a broader `try-catch` for class-wide unexpected exceptions. Input validation is performed before attempting operations.
 * *   **Data Management:** Simple state management of requests (`PENDING`, `IN_PROGRESS`, `RESOLVED`) and movement between different collections.
 * 
 * This solution effectively combines multiple core Java concepts in a practical, albeit simplified, application, providing a good test of a student's understanding of these topics.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator; // Needed for safe removal while iterating if implemented that way

// Enum for request status
enum Status {
    PENDING,
    IN_PROGRESS,
    RESOLVED
}

// Represents a single support request
class SupportRequest {
    private int id;
    private String description;
    private Status status;

    public SupportRequest(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = Status.PENDING; // New requests are pending by default
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    // Method to update status (used by manager)
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request [ID=" + id + ", Status=" + status + ", Description='" + description + "']";
    }
}

// Manages the collections of support requests
class SupportSystemManager {
    // Queue for requests waiting to be picked up
    private Queue<SupportRequest> pendingRequests;
    // List for requests currently being worked on
    private List<SupportRequest> inProgressRequests;
    // List for requests that have been resolved
    private List<SupportRequest> resolvedRequests;

    private int nextRequestId; // Counter for unique request IDs

    public SupportSystemManager() {
        this.pendingRequests = new LinkedList<>(); // LinkedList implements Queue
        this.inProgressRequests = new ArrayList<>(); // ArrayList implements List
        this.resolvedRequests = new ArrayList<>();   // ArrayList implements List
        this.nextRequestId = 1; // Start IDs from 1
    }

    /**
     * Submits a new support request to the pending queue.
     * @param description The description of the request.
     * @return The newly created SupportRequest object.
     */
    public SupportRequest submitRequest(String description) {
        SupportRequest newRequest = new SupportRequest(nextRequestId++, description);
        pendingRequests.offer(newRequest); // Add to the end of the queue
        return newRequest;
    }

    /**
     * Returns the queue of pending requests.
     * Note: Returning the collection directly is acceptable for exam simplicity,
     * but in production, consider returning an unmodifiable view or copy.
     */
    public Queue<SupportRequest> getPendingRequests() {
        return pendingRequests;
    }

    /**
     * Picks up the next available request from the pending queue.
     * Moves the request to the in-progress list and updates its status.
     * @return The picked-up request, or null if the pending queue is empty.
     */
    public SupportRequest pickupNextRequest() {
        SupportRequest nextRequest = pendingRequests.poll(); // Get and remove the head of the queue
        if (nextRequest != null) {
            nextRequest.setStatus(Status.IN_PROGRESS);
            inProgressRequests.add(nextRequest); // Add to the in-progress list
        }
        return nextRequest;
    }

    /**
     * Resolves a request that is currently in the in-progress list.
     * Finds the request by ID, moves it to the resolved list, and updates its status.
     * @param requestId The ID of the request to resolve.
     * @return true if the request was found and resolved, false otherwise.
     */
    public boolean resolveRequest(int requestId) {
        SupportRequest requestToResolve = null;
        // Iterate through in-progress requests to find the one with the matching ID
        Iterator<SupportRequest> iterator = inProgressRequests.iterator();
        while (iterator.hasNext()) {
            SupportRequest req = iterator.next();
            if (req.getId() == requestId) {
                requestToResolve = req;
                iterator.remove(); // Safely remove the element using the iterator
                break;
            }
        }

        if (requestToResolve != null) {
            requestToResolve.setStatus(Status.RESOLVED);
            resolvedRequests.add(requestToResolve); // Add to the resolved list
            return true; // Successfully resolved
        } else {
            // Request with the given ID was not found in the in-progress list
            return false;
        }
    }

    /**
     * Returns the list of resolved requests.
     * Note: Returning the collection directly is acceptable for exam simplicity.
     */
    public List<SupportRequest> getResolvedRequests() {
        return resolvedRequests;
    }
}

// Main application class handling user interaction
public class TechSupportApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupportSystemManager manager = new SupportSystemManager();

        System.out.println("--- Tech Support Request Management System ---");

        // Class-wide exception handling for the main application loop
        try {
            while (true) {
                printMenu();
                System.out.print("Enter your choice: ");

                String input = scanner.nextLine();
                int choice = -1; // Default invalid choice

                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    continue; // Skip to the next iteration of the loop
                }

                // Use switch statement for flow control based on user choice
                switch (choice) {
                    case 1: // Submit New Request
                        System.out.print("Enter request description: ");
                        String description = scanner.nextLine();
                        if (description == null || description.trim().isEmpty()) {
                            System.err.println("Description cannot be empty.");
                        } else {
                            SupportRequest newReq = manager.submitRequest(description.trim());
                            System.out.println("Request submitted: " + newReq);
                        }
                        break;

                    case 2: // View Pending Requests
                        Queue<SupportRequest> pending = manager.getPendingRequests();
                        if (pending.isEmpty()) {
                            System.out.println("No pending requests.");
                        } else {
                            System.out.println("--- Pending Requests ---");
                            // Iterate through the queue without removing elements
                            for (SupportRequest req : pending) {
                                System.out.println(req);
                            }
                            System.out.println("------------------------");
                        }
                        break;

                    case 3: // Pick Up Next Request
                        SupportRequest pickedUpRequest = manager.pickupNextRequest();
                        if (pickedUpRequest != null) {
                            System.out.println("Picked up next request: " + pickedUpRequest);
                        } else {
                            System.err.println("No pending requests to pick up.");
                        }
                        break;

                    case 4: // Resolve Request
                        System.out.print("Enter the ID of the request to resolve (must be in progress): ");
                        String idInput = scanner.nextLine();
                        int requestIdToResolve = -1;
                        try {
                            requestIdToResolve = Integer.parseInt(idInput);
                        } catch (NumberFormatException e) {
                            System.err.println("Invalid ID format. Please enter a number.");
                            break; // Stay in the main loop, but don't try to resolve
                        }

                        boolean resolved = manager.resolveRequest(requestIdToResolve);
                        if (resolved) {
                            System.out.println("Request ID " + requestIdToResolve + " resolved successfully.");
                        } else {
                            System.err.println("Request ID " + requestIdToResolve + " not found in the in-progress list.");
                        }
                        break;

                    case 5: // View Resolved Requests
                        List<SupportRequest> resolvedList = manager.getResolvedRequests();
                        if (resolvedList.isEmpty()) {
                            System.out.println("No requests have been resolved yet.");
                        } else {
                            System.out.println("--- Resolved Requests ---");
                            // Iterate through the list
                            for (SupportRequest req : resolvedList) {
                                System.out.println(req);
                            }
                            System.out.println("-------------------------");
                        }
                        break;

                    case 6: // Exit
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close(); // Close the scanner
                        return; // Exit the main method

                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                        break;
                }
                System.out.println(); // Print a newline for better readability between actions
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions
            System.err.println("\nAn unexpected application error occurred:");
            e.printStackTrace(System.err); // Print stack trace to standard error
        } finally {
             // Ensure scanner is closed even if an unexpected exception occurs
             // This catch block is technically inside the try, so finally is better here.
             // But closing in the exit case is sufficient for this simple app.
             // Let's add a check here just in case.
             if (scanner != null) {
                 // scanner.close(); // Closing in 'exit' case is fine. Avoid double close.
             }
        }
    }

    // Helper method to print the menu
    private static void printMenu() {
        System.out.println("Choose an action:");
        System.out.println("1. Submit New Request");
        System.out.println("2. View Pending Requests");
        System.out.println("3. Pick Up Next Request");
        System.out.println("4. Resolve Request");
        System.out.println("5. View Resolved Requests");
        System.out.println("6. Exit");
    }
}
