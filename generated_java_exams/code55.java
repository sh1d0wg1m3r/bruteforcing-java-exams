/*
 * Exam Question #55
 * Generated on: 2025-05-11 22:06:15
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: IT Service Request Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified IT service request management system for a small company. The system should allow users (support staff) to manage incoming service requests from clients. Requests arrive and are placed in a queue to be processed in the order they are received. Once a request is processed, it is moved to a list of completed requests.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that fulfills the following requirements:
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to hold *pending* service requests.
 *     *   Use a `java.util.ArrayList` to hold *completed* service requests.
 *     *   Declare the variable for completed requests using the `java.util.List` interface.
 * 
 * 2.  **Classes:**
 *     *   Create a `ServiceRequest` class to represent a single request. It should have:
 *         *   `id` (int): Unique identifier for the request.
 *         *   `description` (String): A brief description of the issue.
 *         *   `type` (String): The type of request (e.g., "Software", "Hardware", "Network").
 *         *   `status` (String): The current status ("Pending" or "Completed").
 *         *   Private fields with public getter methods.
 *         *   A method `markCompleted()` to change the status to "Completed".
 *         *   A constructor to initialize `id`, `description`, and `type`, setting the initial status to "Pending".
 *         *   Override `toString()` for easy printing of request details.
 *     *   Create a `RequestManager` class to manage the collections of requests. It should have:
 *         *   Private fields for the pending queue and completed list.
 *         *   A counter for the next request ID.
 *         *   A constructor to initialize the collections and the ID counter.
 *         *   A public method `addRequest(String description, String type)`: Creates a `ServiceRequest`, assigns a unique ID, and adds it to the pending queue.
 *         *   A public method `processNextRequest()`: Removes the next request from the pending queue, marks it as completed, and adds it to the completed list. It should return the processed request or `null` if the queue is empty.
 *         *   A public method `listPendingRequests()`: Prints details of all requests currently in the pending queue.
 *         *   A public method `listCompletedRequests()`: Prints details of all requests currently in the completed list.
 *         *   A public method, perhaps `startSystem(Scanner scanner)`, that contains the main application loop, displaying a menu and handling user interaction.
 * 
 * 3.  **User Interaction:**
 *     *   Use `java.util.Scanner` to get input from the user (support staff).
 *     *   Present a menu with options:
 *         1.  Add New Request
 *         2.  Process Next Request
 *         3.  List Pending Requests
 *         4.  List Completed Requests
 *         5.  Exit
 *     *   Use a `switch` statement to handle the different menu options.
 * 
 * 4.  **Error Handling and Output:**
 *     *   Use `System.out.println()` for displaying the menu, request details, and success messages.
 *     *   Use `System.err.println()` for displaying error messages (e.g., invalid menu input, attempting to process a request when the queue is empty).
 *     *   Implement input validation for menu choices.
 *     *   Include a class-wide exception handling mechanism (a `try-catch` block) in the main part of your program (e.g., around the main application loop) to catch any unexpected runtime exceptions.
 * 
 * 5.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Add appropriate comments and documentation (JavaDocs are encouraged).
 *     *   Ensure clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, presenting a menu. Based on user input, it should perform the requested action and print relevant information or error messages.
 * 
 * Example Interaction Flow:
 * 
 * ```
 * IT Service Request Management System
 * Menu:
 * 1. Add New Request
 * 2. Process Next Request
 * 3. List Pending Requests
 * 4. List Completed Requests
 * 5. Exit
 * Enter your choice: 1
 * Enter request description: Printer not working
 * Enter request type (Software, Hardware, Network): Hardware
 * Request added with ID: 1
 * 
 * Menu:
 * ...
 * Enter your choice: 1
 * Enter request description: Software installation failed
 * Enter request type (Software, Hardware, Network): Software
 * Request added with ID: 2
 * 
 * Menu:
 * ...
 * Enter your choice: 3
 * --- Pending Requests ---
 * Request ID: 1, Description: Printer not working, Type: Hardware, Status: Pending
 * Request ID: 2, Description: Software installation failed, Type: Software, Status: Pending
 * ------------------------
 * 
 * Menu:
 * ...
 * Enter your choice: 2
 * Processing request ID: 1
 * Request ID 1 processed and marked completed.
 * 
 * Menu:
 * ...
 * Enter your choice: 3
 * --- Pending Requests ---
 * Request ID: 2, Description: Software installation failed, Type: Software, Status: Pending
 * ------------------------
 * 
 * Menu:
 * ...
 * Enter your choice: 4
 * --- Completed Requests ---
 * Request ID: 1, Description: Printer not working, Type: Hardware, Status: Completed
 * --------------------------
 * 
 * Menu:
 * ...
 * Enter your choice: 6
 * Invalid choice. Please enter a number between 1 and 5.
 * 
 * Menu:
 * ...
 * Enter your choice: 2
 * Processing next request...
 * Request ID 2 processed and marked completed.
 * 
 * Menu:
 * ...
 * Enter your choice: 2
 * Processing next request...
 * Error: No pending requests to process.
 * 
 * Menu:
 * ...
 * Enter your choice: 5
 * Exiting system.
 * ```
 * 
 * **Constraint:** Ensure *all* listed required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, class-wide `try-catch`) are used in your solution.
 * 
 * **Time Allotment:** This task is designed to be completed within approximately 45-60 minutes.
 *
 * EXPLANATION:
 * This solution implements the IT Service Request Management System as described in the problem statement, utilizing all the required Java components and adhering to best practices.
 * 
 * 1.  **`ServiceRequest` Class:**
 *     *   Represents a single request with `id`, `description`, `type`, and `status`.
 *     *   Fields are `private` adhering to encapsulation.
 *     *   `public` getter methods provide controlled access to the data.
 *     *   `markCompleted()` is a simple method demonstrating state change.
 *     *   `toString()` is overridden for convenient printing of request details.
 * 
 * 2.  **`RequestManager` Class:**
 *     *   Manages the core logic and data collections.
 *     *   `pendingRequests`: Declared as `Queue<ServiceRequest>` and instantiated as `LinkedList`. `LinkedList` is a common choice for implementing `Queue` in Java due to its efficient add/remove operations at both ends. Requests are added using `offer()` and removed using `poll()`, maintaining FIFO (First-In, First-Out) order.
 *     *   `completedRequests`: Declared as `List<ServiceRequest>` and instantiated as `ArrayList`. `ArrayList` is suitable for storing completed requests as they are typically accessed by index or iterated through, and modifications (adding completed requests) are efficient enough for this scenario. The declaration using the `List` interface demonstrates polymorphism and good practice.
 *     *   `nextRequestId`: A simple counter ensures each request gets a unique ID.
 *     *   `addRequest()`: Creates a new `ServiceRequest` and adds it to the `pendingRequests` queue.
 *     *   `processNextRequest()`: Uses `poll()` to get and remove the head of the queue. It checks if `poll()` returned `null` (meaning the queue was empty) and uses `System.err` for the error message. If a request is retrieved, its `markCompleted()` method is called, and it's added to the `completedRequests` list.
 *     *   `listPendingRequests()` and `listCompletedRequests()`: Iterate through their respective collections and print the details of each request using the `toString()` method.
 *     *   `startSystem()`: This method contains the main application loop. It repeatedly prints the menu, gets user input using the `Scanner`, and uses a `switch` statement to dispatch the action based on the `choice`.
 * 
 * 3.  **`Main` Class (`ServiceSystemMain`):**
 *     *   The `main` method is the entry point.
 *     *   It creates a `Scanner` object, wrapped in a `try-with-resources` statement to ensure it's closed automatically.
 *     *   It creates a `RequestManager` instance.
 *     *   It calls `manager.startSystem(scanner)` to begin the interactive part of the program.
 *     *   A `try-catch(Exception e)` block is placed around the `startSystem` call within `main`. This serves as the "class-wide exception handling" requirement, catching any unexpected `Exception` that might escape the `startSystem` method's internal handling.
 * 
 * 4.  **Input Handling and Validation:**
 *     *   `Scanner` is used to read integer choices and string inputs.
 *     *   A `try-catch(InputMismatchException e)` is included within the `startSystem` loop's `try` block to specifically handle cases where the user enters non-integer input for the menu choice. It prints an error using `System.err` and consumes the invalid input to prevent an infinite loop.
 *     *   The `switch` statement's `default` case handles valid integer inputs that are outside the expected range (1-5), printing an error via `System.err`.
 * 
 * 5.  **Output:**
 *     *   `System.out.println()` is used for normal program output: menu display, success messages, and listing requests.
 *     *   `System.err.println()` is used exclusively for error messages: invalid menu input, `InputMismatchException`, and trying to process an empty queue.
 * 
 * 6.  **Exception Handling:**
 *     *   Specific handling for `InputMismatchException` is done within the `startSystem` loop.
 *     *   A general `catch (Exception e)` is included in the `startSystem` loop to catch other potential runtime exceptions during the execution of menu options.
 *     *   The `try-catch(Exception e)` block in the `main` method provides the final layer of "class-wide" handling for any exceptions not caught internally by `startSystem`.
 * 
 * This solution demonstrates the practical application of fundamental Java data structures, control flow, object-oriented principles (encapsulation), and robust error handling techniques, fulfilling all the requirements of the challenging exam task.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single IT service request.
 */
class ServiceRequest {
    private int id;
    private String description;
    private String type;
    private String status;

    /**
     * Constructs a new ServiceRequest.
     *
     * @param id The unique identifier for the request.
     * @param description A brief description of the issue.
     * @param type The type of request (e.g., "Software", "Hardware").
     */
    public ServiceRequest(int id, String description, String type) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.status = "Pending"; // Initial status
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Marks the request status as "Completed".
     */
    public void markCompleted() {
        this.status = "Completed";
    }

    /**
     * Provides a string representation of the ServiceRequest.
     *
     * @return Formatted string detailing the request.
     */
    @Override
    public String toString() {
        return String.format("Request ID: %d, Description: %s, Type: %s, Status: %s",
                             id, description, type, status);
    }
}

/**
 * Manages the collection of pending and completed service requests.
 */
class RequestManager {
    private Queue<ServiceRequest> pendingRequests;
    private List<ServiceRequest> completedRequests; // Declared using List interface
    private int nextRequestId;

    /**
     * Constructs a new RequestManager, initializing collections and ID counter.
     */
    public RequestManager() {
        // Using LinkedList as it implements the Queue interface
        this.pendingRequests = new LinkedList<>();
        // Using ArrayList for completed requests
        this.completedRequests = new ArrayList<>();
        this.nextRequestId = 1; // Start IDs from 1
    }

    /**
     * Adds a new service request to the pending queue.
     *
     * @param description The description of the request.
     * @param type The type of the request.
     */
    public void addRequest(String description, String type) {
        ServiceRequest newRequest = new ServiceRequest(nextRequestId++, description, type);
        pendingRequests.offer(newRequest); // offer is generally preferred over add for queues
        System.out.println("Request added with ID: " + newRequest.getId());
    }

    /**
     * Processes the next request in the pending queue.
     *
     * @return The processed ServiceRequest, or null if the queue was empty.
     */
    public ServiceRequest processNextRequest() {
        System.out.println("Processing next request...");
        ServiceRequest requestToProcess = pendingRequests.poll(); // poll returns null if queue is empty

        if (requestToProcess != null) {
            requestToProcess.markCompleted();
            completedRequests.add(requestToProcess);
            System.out.println("Request ID " + requestToProcess.getId() + " processed and marked completed.");
        } else {
            System.err.println("Error: No pending requests to process.");
        }
        return requestToProcess;
    }

    /**
     * Lists all pending service requests.
     */
    public void listPendingRequests() {
        System.out.println("--- Pending Requests ---");
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending requests.");
        } else {
            // Iterating through the queue without removing elements
            for (ServiceRequest request : pendingRequests) {
                System.out.println(request);
            }
        }
        System.out.println("------------------------");
    }

    /**
     * Lists all completed service requests.
     */
    public void listCompletedRequests() {
        System.out.println("--- Completed Requests ---");
        if (completedRequests.isEmpty()) {
            System.out.println("No completed requests.");
        } else {
            for (ServiceRequest request : completedRequests) {
                System.out.println(request);
            }
        }
        System.out.println("--------------------------");
    }

    /**
     * Starts the main interactive loop for the Request Management System.
     *
     * @param scanner The Scanner object for user input.
     */
    public void startSystem(Scanner scanner) {
        int choice = -1;
        while (choice != 5) {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        System.out.print("Enter request description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter request type (e.g., Software, Hardware, Network): ");
                        String type = scanner.nextLine();
                        addRequest(description, type);
                        break;
                    case 2:
                        processNextRequest();
                        break;
                    case 3:
                        listPendingRequests();
                        break;
                    case 4:
                        listCompletedRequests();
                        break;
                    case 5:
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = -1; // Reset choice to stay in loop
            } catch (Exception e) {
                // Class-wide exception handling
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Optional: print stack trace for debugging
            }
            System.out.println(); // Add a newline for better readability between operations
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("IT Service Request Management System");
        System.out.println("Menu:");
        System.out.println("1. Add New Request");
        System.out.println("2. Process Next Request");
        System.out.println("3. List Pending Requests");
        System.out.println("4. List Completed Requests");
        System.out.println("5. Exit");
    }
}

/**
 * Main class to run the IT Service Request Management System.
 */
public class ServiceSystemMain {

    public static void main(String[] args) {
        // Use try-with-resources to ensure scanner is closed
        try (Scanner scanner = new Scanner(System.in)) {
            RequestManager manager = new RequestManager();
            manager.startSystem(scanner);
        } catch (Exception e) {
            // This catch block handles exceptions that might occur outside the startSystem loop
            // or propagate up from within if not caught lower down.
            // It fulfills the "class-wide exception handling" requirement.
            System.err.println("A critical error occurred during system operation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
