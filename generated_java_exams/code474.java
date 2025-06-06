/*
 * Exam Question #474
 * Generated on: 2025-05-11 23:16:20
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Data Processing Queue System
 * 
 * **Objective:** Design and implement a console-based system to manage a queue of data processing requests. This task requires demonstrating proficiency in using core Java collections, input handling, control flow, and exception handling.
 * 
 * **Scenario:** You are building a simplified backend system that receives data processing requests. These requests arrive and are placed into a queue to be processed sequentially. The system allows users to add new requests, process the next request in line, view the current requests waiting in the queue, or view requests that have already been processed.
 * 
 * **Requirements:**
 * 
 * 1.  **`ProcessingRequest` Class:**
 *     *   Create a class named `ProcessingRequest` to represent a single processing request.
 *     *   It must have private fields: `requestId` (an integer, auto-generated), `requestType` (a String, e.g., "ANALYTICS", "REPORT"), and `requestData` (a String representing the data payload).
 *     *   Implement a constructor to initialize `requestType` and `requestData`.
 *     *   Provide public getter methods for all fields.
 *     *   Override the `toString()` method to provide a user-friendly representation of the request.
 * 
 * 2.  **`ProcessingQueueSystem` Class:**
 *     *   Create a class named `ProcessingQueueSystem` to manage the queue and processed requests.
 *     *   It must use a `java.util.Queue<ProcessingRequest>` (specifically, use `java.util.LinkedList` as the concrete implementation but declare the field as `Queue`) to hold incoming requests.
 *     *   It must use a `java.util.List<ProcessingRequest>` (specifically, use `java.util.ArrayList` as the concrete implementation but declare the field as `List`) to store requests after they have been processed.
 *     *   Use a private static variable to generate unique `requestId` values.
 *     *   Use a `java.util.Scanner` for reading user input from the console.
 *     *   Implement a main application loop that presents a menu to the user and processes their choice using a `switch` statement.
 *     *   **Menu Options:**
 *         *   `1. Add New Request`: Prompts the user for request type and data, creates a `ProcessingRequest` object, and adds it to the queue.
 *         *   `2. Process Next Request`: Removes the next request from the front of the queue, simulates processing (e.g., print a message), and adds it to the list of processed requests. If the queue is empty, report an error.
 *         *   `3. View Pending Requests`: Displays all requests currently in the queue without removing them. If the queue is empty, report that.
 *         *   `4. View Processed Requests`: Displays all requests that have been processed. If the list is empty, report that.
 *         *   `5. Exit`: Terminates the program.
 *     *   Use `System.out` for displaying the menu, prompts, confirmation messages, and request details.
 *     *   Use `System.err` for displaying error messages (e.g., attempting to process from an empty queue, invalid menu input).
 * 
 * 3.  **Exception Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks within the `ProcessingQueueSystem` class, particularly around the main application loop and input reading, to gracefully handle potential issues like invalid user input (e.g., entering text when a number is expected).
 *     *   Handle the specific case of trying to process from an empty queue.
 * 
 * 4.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes and methods).
 *     *   Validate user input where necessary (e.g., menu choice).
 *     *   Ensure the `Scanner` resource is properly managed (closed when done).
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, displaying a menu, accepting numerical input for choices, and printing relevant output or error messages based on the operation.
 * 
 * ```
 * --- Data Processing Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Pending Requests
 * 4. View Processed Requests
 * 5. Exit
 * Enter your choice:
 * ```
 * 
 * (Example interaction after adding and processing requests)
 * 
 * ```
 * Enter your choice: 3
 * --- Pending Requests ---
 * [ID: 1, Type: ANALYTICS, Data: Sales Data Q3]
 * [ID: 3, Type: REPORT, Data: Quarterly Summary]
 * -------------------------
 * 
 * Enter your choice: 4
 * --- Processed Requests ---
 * [ID: 0, Type: SETUP, Data: System Initialization]
 * [ID: 2, Type: ARCHIVE, Data: Old Logs 2022]
 * --------------------------
 * 
 * Enter your choice: 2
 * Processing request: [ID: 1, Type: ANALYTICS, Data: Sales Data Q3]
 * Request processed and moved to processed list.
 * 
 * Enter your choice: 2
 * Processing request: [ID: 3, Type: REPORT, Data: Quarterly Summary]
 * Request processed and moved to processed list.
 * 
 * Enter your choice: 2
 * Error: No pending requests in the queue.
 * ```
 * 
 * **Constraint Checklist:**
 * *   [ ] Uses `java.util.Queue`
 * *   [ ] Uses `java.util.ArrayList`
 * *   [ ] Uses `java.util.List` interface
 * *   [ ] Uses `java.util.Scanner`
 * *   [ ] Uses `switch` statement
 * *   [ ] Uses `System.err`
 * *   [ ] Uses `System.out`
 * *   [ ] Uses class-wide `try-catch`
 * *   [ ] `ProcessingRequest` class created
 * *   [ ] `ProcessingQueueSystem` class created
 * *   [ ] Encapsulation used
 * *   [ ] Meaningful names used
 * *   [ ] Comments/Documentation included
 * *   [ ] Input validation performed
 * *   [ ] Proper error handling implemented
 * *   [ ] Clean code structure
 * 
 * **Time Estimate:** 45-60 minutes
 *
 * EXPLANATION:
 * The solution implements a `ProcessingQueueSystem` that manages data processing requests using the required Java components and follows best practices.
 * 
 * 1.  **`ProcessingRequest` Class:**
 *     *   This class models the individual data requests.
 *     *   It uses `private final` fields (`requestId`, `requestType`, `requestData`) to ensure immutability after creation, demonstrating encapsulation.
 *     *   A `static int nextId` ensures each request gets a unique, sequential ID.
 *     *   Public getters provide controlled access to the data.
 *     *   The overridden `toString()` method provides a clean representation for printing.
 * 
 * 2.  **`ProcessingQueueSystem` Class:**
 *     *   This is the main class containing the application logic.
 *     *   **`Queue<ProcessingRequest> requestQueue`**: Declared as `Queue` (interface) but instantiated as `LinkedList` (concrete implementation). This holds requests waiting to be processed, following the FIFO (First-In, First-Out) principle inherent to queues. `offer()` is used for adding, and `poll()` for removing from the head.
 *     *   **`List<ProcessingRequest> processedRequests`**: Declared as `List` (interface) but instantiated as `ArrayList` (concrete implementation). This stores requests after they have been processed. `ArrayList` is suitable here as we might need to iterate or potentially access elements by index (though not strictly required by the prompt, it's a common use case for processed items).
 *     *   **`Scanner scanner`**: Used to read input from `System.in`. It's initialized in the constructor.
 *     *   **`displayMenu()`**: Prints the interactive menu options to `System.out`.
 *     *   **`addRequest()`**: Reads request details from the user using `scanner.nextLine()`, creates a `ProcessingRequest` object, and adds it to the `requestQueue` using `offer()`. Includes basic input validation for empty strings.
 *     *   **`processNextRequest()`**: Uses `requestQueue.poll()` to retrieve and remove the head of the queue. If `poll()` returns `null` (meaning the queue is empty), an error is printed to `System.err`. Otherwise, the request is added to the `processedRequests` list.
 *     *   **`viewPendingRequests()`**: Iterates through the `requestQueue` to display its contents without removing elements. This is achieved by creating a temporary `ArrayList` from the queue's contents, allowing safe iteration. Output is sent to `System.out`. Handles the empty queue case with an informative message.
 *     *   **`viewProcessedRequests()`**: Iterates through the `processedRequests` `List` and prints each processed request to `System.out`. Handles the empty list case.
 *     *   **`run()`**: Contains the main application loop (`while (choice != 5)`). It repeatedly displays the menu, reads the user's choice using `scanner.nextInt()`, and uses a `switch` statement to execute the corresponding action method (`addRequest`, `processNextRequest`, etc.). `scanner.nextLine()` is called after `scanner.nextInt()` to consume the leftover newline character, preventing issues in subsequent `nextLine()` calls.
 *     *   **Exception Handling (`try-catch`)**:
 *         *   A specific `try-catch(InputMismatchException e)` is placed around the `scanner.nextInt()` call within the loop. This handles cases where the user enters non-integer input for the menu choice, prints an error to `System.err`, consumes the invalid input using `scanner.nextLine()`, and allows the loop to continue.
 *         *   A broader `try-catch(Exception e)` wraps the entire `while` loop in the `run()` method. This serves as a class-wide handler for any other unexpected runtime exceptions that might occur within the application logic, printing an error to `System.err` and the stack trace for debugging.
 *         *   The `finally` block ensures `scanner.close()` is called when the `run()` method exits (either normally or due to an exception), releasing the system resource.
 *     *   **`main()`**: The entry point of the program, which simply creates an instance of `ProcessingQueueSystem` and calls its `run()` method.
 * 
 * This solution effectively demonstrates the required components and best practices by building a functional, interactive system that manages data processing requests, handling both normal operations and potential errors gracefully.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single data processing request.
 */
class ProcessingRequest {
    private static int nextId = 0; // Static counter for unique IDs

    private final int requestId;
    private final String requestType;
    private final String requestData;

    /**
     * Constructs a new ProcessingRequest with a unique ID.
     * @param requestType The type of processing requested (e.g., "ANALYTICS").
     * @param requestData The data payload for the request.
     */
    public ProcessingRequest(String requestType, String requestData) {
        this.requestId = nextId++; // Assign unique ID and increment counter
        this.requestType = requestType;
        this.requestData = requestData;
    }

    // --- Getters ---
    public int getRequestId() {
        return requestId;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getRequestData() {
        return requestData;
    }

    /**
     * Provides a string representation of the request.
     * @return A formatted string describing the request.
     */
    @Override
    public String toString() {
        return "[ID: " + requestId + ", Type: " + requestType + ", Data: " + requestData + "]";
    }
}

/**
 * Manages the queue of processing requests and a list of processed requests.
 */
public class ProcessingQueueSystem {
    private final Queue<ProcessingRequest> requestQueue; // Pending requests
    private final List<ProcessingRequest> processedRequests; // Completed requests
    private final Scanner scanner; // For reading user input

    /**
     * Constructs a new ProcessingQueueSystem, initializing the queue, list, and scanner.
     */
    public ProcessingQueueSystem() {
        // Use LinkedList as the concrete implementation for Queue
        this.requestQueue = new LinkedList<>();
        // Use ArrayList as the concrete implementation for List
        this.processedRequests = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Data Processing Queue System ---");
        System.out.println("1. Add New Request");
        System.out.println("2. Process Next Request");
        System.out.println("3. View Pending Requests");
        System.out.println("4. View Processed Requests");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new processing request to the queue based on user input.
     */
    private void addRequest() {
        System.out.print("Enter Request Type (e.g., ANALYTICS, REPORT): ");
        String type = scanner.nextLine();
        System.out.print("Enter Request Data: ");
        String data = scanner.nextLine();

        if (type == null || type.trim().isEmpty() || data == null || data.trim().isEmpty()) {
            System.err.println("Error: Request type and data cannot be empty.");
            return;
        }

        ProcessingRequest newRequest = new ProcessingRequest(type.trim(), data.trim());
        requestQueue.offer(newRequest); // offer is preferred over add for queues
        System.out.println("Request added to queue: " + newRequest);
    }

    /**
     * Processes the next request from the front of the queue.
     * Removes the request from the queue and adds it to the processed list.
     */
    private void processNextRequest() {
        ProcessingRequest nextRequest = requestQueue.poll(); // Retrieves and removes the head of the queue

        if (nextRequest == null) {
            System.err.println("Error: No pending requests in the queue.");
        } else {
            System.out.println("Processing request: " + nextRequest);
            // Simulate processing...
            processedRequests.add(nextRequest);
            System.out.println("Request processed and moved to processed list.");
        }
    }

    /**
     * Displays all requests currently waiting in the queue.
     */
    private void viewPendingRequests() {
        if (requestQueue.isEmpty()) {
            System.out.println("--- Pending Requests ---");
            System.out.println("The pending queue is empty.");
            System.out.println("------------------------");
        } else {
            System.out.println("--- Pending Requests ---");
            // Iterate over the queue without removing elements
            // A common way is to convert to a temporary list or iterate using an iterator
            // Converting to a list is simpler for just printing
            List<ProcessingRequest> pendingList = new ArrayList<>(requestQueue);
            for (ProcessingRequest request : pendingList) {
                System.out.println(request);
            }
            System.out.println("------------------------");
        }
    }

    /**
     * Displays all requests that have been processed.
     */
    private void viewProcessedRequests() {
        if (processedRequests.isEmpty()) {
            System.out.println("--- Processed Requests ---");
            System.out.println("No requests have been processed yet.");
            System.out.println("--------------------------");
        } else {
            System.out.println("--- Processed Requests ---");
            for (ProcessingRequest request : processedRequests) {
                System.out.println(request);
            }
            System.out.println("--------------------------");
        }
    }

    /**
     * Runs the main application loop.
     * Includes class-wide exception handling.
     */
    public void run() {
        int choice = -1;

        // Class-wide try-catch block for general exceptions during execution
        try {
            while (choice != 5) {
                displayMenu();

                // Specific try-catch for handling input mismatch errors
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character after reading int

                    switch (choice) {
                        case 1:
                            addRequest();
                            break;
                        case 2:
                            processNextRequest();
                            break;
                        case 3:
                            viewPendingRequests();
                            break;
                        case 4:
                            viewProcessedRequests();
                            break;
                        case 5:
                            System.out.println("Exiting system. Goodbye!");
                            break;
                        default:
                            System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to stay in the loop
                }
            }
        } catch (Exception e) {
            // Catch-all for any unexpected exceptions during the main loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed when the application exits
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ProcessingQueueSystem system = new ProcessingQueueSystem();
        system.run();
    }
}
