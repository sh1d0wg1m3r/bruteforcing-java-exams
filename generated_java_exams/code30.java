/*
 * Exam Question #30
 * Generated on: 2025-05-11 21:48:43
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam: Technical Support Queue System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple technical support queue management system for a small IT department. The system should allow users (acting as support staff) to manage incoming support requests. Requests arrive and are processed in a First-In, First-Out (FIFO) manner. Completed requests are moved to a separate list for archiving.
 * 
 * The system should provide a command-line interface with the following options:
 * 1.  **Add New Request:** Prompts the user for a description of the support issue and adds it to the queue of pending requests. Each request should have a unique ID.
 * 2.  **Process Next Request:** Takes the oldest request from the queue, marks it as completed, and moves it to a list of completed requests. If the queue is empty, it should report an error.
 * 3.  **View Queue Status:** Displays the number of pending requests and lists their IDs and descriptions. Also displays the total number of completed requests.
 * 4.  **Exit:** Terminates the application.
 * 
 * **Technical Requirements:**
 * 
 * Your solution must be a single Java program contained within one or two `.java` files. It must utilize **ALL** of the following Java components and concepts:
 * 
 * *   `java.util.Queue`: To manage the pending support requests in FIFO order.
 * *   `java.util.ArrayList`: To store the completed support requests.
 * *   `java.util.List`: Declare the variable holding completed requests using the `List` interface type.
 * *   `java.util.Scanner`: To read user input from the console (menu choices and request descriptions).
 * *   `switch` statement: To handle the different menu options.
 * *   `System.err`: To print error messages (e.g., attempting to process an empty queue, invalid input).
 * *   `System.out`: To print normal output (menu, prompts, success messages, status).
 * *   Class-wide exception handling: Implement `try-catch` blocks to gracefully handle potential runtime errors, particularly around user input.
 * 
 * **Best Practices Requirements:**
 * 
 * *   **Encapsulation:** If you create a class for `SupportRequest`, its fields must be private with public getter methods.
 * *   **Meaningful Names:** Use clear and descriptive names for variables, methods, and classes.
 * *   **Comments:** Include appropriate comments (including Javadoc for classes/methods) to explain the code's purpose and logic.
 * *   **Input Validation:** Validate user input where necessary (e.g., ensure menu choice is a valid number within the range, handle non-numeric input).
 * *   **Error Handling:** Implement robust error handling for operations that might fail (like processing an empty queue).
 * *   **Clean Code Structure:** Organize your code logically.
 * 
 * **Expected Output:**
 * 
 * The system should present a menu loop. Output should be informative, clearly indicating the action taken or the system's status. Error messages should be distinct (using `System.err`).
 * 
 * Example Interaction:
 * 
 * ```
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 1
 * Enter request description: Printer not working
 * Request 1 added to queue.
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 1
 * Enter request description: Email configuration help
 * Request 2 added to queue.
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 3
 * --- Queue Status ---
 * Pending Requests: 2
 *   ID: 1, Description: Printer not working
 *   ID: 2, Description: Email configuration help
 * Completed Requests: 0
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 2
 * Processing request ID: 1, Description: Printer not working
 * Request 1 completed.
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 3
 * --- Queue Status ---
 * Pending Requests: 1
 *   ID: 2, Description: Email configuration help
 * Completed Requests: 1
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 2
 * Processing request ID: 2, Description: Email configuration help
 * Request 2 completed.
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 2
 * Error: The support queue is currently empty.
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 5
 * Error: Invalid choice. Please enter a number between 1 and 4.
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: exit
 * Error: Invalid input. Please enter a number.
 * 
 * --- Support Queue System ---
 * 1. Add New Request
 * 2. Process Next Request
 * 3. View Queue Status
 * 4. Exit
 * Enter choice: 4
 * Exiting Support Queue System.
 * ```
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation of all required functionalities.
 * *   Proper use and demonstration of ALL required Java components.
 * *   Adherence to best practices (encapsulation, naming, comments, validation, error handling).
 * *   Clean and readable code.
 * *   Correct handling of edge cases (e.g., empty queue, invalid input).
 * 
 * **Note:** You can implement the `SupportRequest` class either as a separate file or as a static nested class within your main class for this exam.
 *
 * EXPLANATION:
 * The provided solution implements a simple Technical Support Queue System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`SupportRequest` Class:**
 *     *   This class represents a single support request.
 *     *   It has private fields (`id`, `description`, `status`) enforcing **encapsulation**.
 *     *   Public getter methods (`getId`, `getDescription`, `getStatus`) provide controlled access to the data.
 *     *   A `markCompleted()` method changes the status.
 *     *   A `toString()` method provides a convenient string representation for printing.
 *     *   This adheres to best practices for object design.
 * 
 * 2.  **`SupportQueueSystem` Class:**
 *     *   This is the main class containing the application logic.
 *     *   **`Queue<SupportRequest> pendingRequestsQueue`**: Declared as a `Queue` interface type and initialized with `LinkedList`. This is used to store requests waiting to be processed, ensuring **FIFO** (First-In, First-Out) order, which is the core behavior of a queue. `offer()` is used to add elements (safer in capacity-constrained queues, but works like `add()` here), and `poll()` is used to retrieve and remove the head of the queue.
 *     *   **`List<SupportRequest> completedRequestsList`**: Declared as a `List` interface type and initialized with `ArrayList`. This stores requests once they have been processed. Using the `List` interface demonstrates polymorphism and good practice. `add()` is used to add elements.
 *     *   **`Scanner scanner`**: An instance of `Scanner` is used to read input from `System.in` (the console).
 *     *   **`nextRequestId`**: An integer counter to assign unique IDs to each new request.
 *     *   **`displayMenu()`**: A helper method to print the menu options to `System.out`.
 *     *   **`addNewRequest()`**: Reads the description from the user, creates a `SupportRequest` object with a new ID, and adds it to the `pendingRequestsQueue` using `offer()`. Prints a success message to `System.out`. Includes basic validation for empty description.
 *     *   **`processNextRequest()`**: Checks if the `pendingRequestsQueue` is empty using `isEmpty()`. If empty, it prints an error message to **`System.err`**. If not empty, it removes the next request using `poll()`, calls its `markCompleted()` method, adds it to the `completedRequestsList`, and prints success messages to `System.out`. This demonstrates error handling for an invalid operation.
 *     *   **`viewQueueStatus()`**: Prints the size of both collections using `size()`. It iterates through the `pendingRequestsQueue` to list the pending requests (using a for-each loop, which does not remove elements) and prints the total count of `completedRequestsList`. Output goes to `System.out`.
 *     *   **`run()`**: This method contains the main application loop (`while(running)`).
 *         *   Inside the loop, it calls `displayMenu()`.
 *         *   It uses a **`try-catch`** block around `scanner.nextInt()` to handle potential `InputMismatchException` if the user enters non-integer input. If caught, it prints an error to **`System.err`** and consumes the invalid input using `scanner.next()` to prevent an infinite loop. A general `Exception` catch is also included for robustness. This fulfills the requirement for class-wide exception handling.
 *         *   A **`switch`** statement is used to control the program flow based on the valid integer input received from the user.
 *         *   Each `case` corresponds to a menu option, calling the appropriate method (`addNewRequest`, `processNextRequest`, `viewQueueStatus`) or setting `running` to `false` for the Exit option.
 *         *   The `default` case in the `switch` handles invalid integer choices (outside the 1-4 range) and prints an error to **`System.err`**. This provides input validation for the menu choice.
 *         *   The `scanner.close()` call ensures resources are released when the application exits.
 *     *   **`main()`**: The entry point of the program, which creates an instance of `SupportQueueSystem` and calls its `run()` method.
 * 
 * This solution effectively integrates all required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, while adhering to best practices like encapsulation, meaningful names, comments, input validation, and error handling.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single support request in the system.
 */
class SupportRequest {
    private int id;
    private String description;
    private String status; // e.g., "Pending", "Completed"

    /**
     * Constructs a new SupportRequest.
     * @param id The unique identifier for the request.
     * @param description The description of the support issue.
     */
    public SupportRequest(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Pending"; // Newly created requests are pending
    }

    // --- Getters (Encapsulation) ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Marks the request as completed.
     */
    public void markCompleted() {
        this.status = "Completed";
    }

    /**
     * Provides a string representation of the request.
     * @return A formatted string showing the request ID and description.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Description: " + description;
    }
}

/**
 * Manages the technical support queue system.
 * Demonstrates the use of Queue, List, ArrayList, Scanner, switch,
 * System.err, System.out, and try-catch for exception handling.
 */
public class SupportQueueSystem {

    // Use Queue for FIFO pending requests
    private Queue<SupportRequest> pendingRequestsQueue;
    // Use List/ArrayList for completed requests
    private List<SupportRequest> completedRequestsList;
    private Scanner scanner;
    private int nextRequestId; // Counter for unique request IDs

    /**
     * Constructs a new SupportQueueSystem.
     * Initializes the queue, list, scanner, and request ID counter.
     */
    public SupportQueueSystem() {
        // Initialize Queue using LinkedList implementation
        this.pendingRequestsQueue = new LinkedList<>();
        // Initialize List using ArrayList implementation
        this.completedRequestsList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.nextRequestId = 1; // Start request IDs from 1
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Support Queue System ---");
        System.out.println("1. Add New Request");
        System.out.println("2. Process Next Request");
        System.out.println("3. View Queue Status");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Adds a new support request to the queue.
     * Prompts the user for the request description.
     */
    private void addNewRequest() {
        System.out.print("Enter request description: ");
        // Consume the newline character left by nextInt()
        scanner.nextLine();
        String description = scanner.nextLine();

        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Request description cannot be empty.");
            return;
        }

        SupportRequest newRequest = new SupportRequest(nextRequestId++, description);
        pendingRequestsQueue.offer(newRequest); // offer() is preferred over add() for capacity-constrained queues, but works here too
        System.out.println("Request " + newRequest.getId() + " added to queue.");
    }

    /**
     * Processes the oldest request in the queue.
     * Removes it from the queue, marks it completed, and moves it to the completed list.
     */
    private void processNextRequest() {
        if (pendingRequestsQueue.isEmpty()) {
            System.err.println("Error: The support queue is currently empty.");
        } else {
            SupportRequest requestToProcess = pendingRequestsQueue.poll(); // poll() retrieves and removes the head
            System.out.println("Processing request " + requestToProcess.toString());
            requestToProcess.markCompleted();
            completedRequestsList.add(requestToProcess);
            System.out.println("Request " + requestToProcess.getId() + " completed.");
        }
    }

    /**
     * Displays the current status of the pending and completed requests.
     */
    private void viewQueueStatus() {
        System.out.println("\n--- Queue Status ---");
        System.out.println("Pending Requests: " + pendingRequestsQueue.size());
        if (!pendingRequestsQueue.isEmpty()) {
            // Iterate through the queue without removing elements
            for (SupportRequest request : pendingRequestsQueue) {
                System.out.println("  " + request.toString());
            }
        }
        System.out.println("Completed Requests: " + completedRequestsList.size());
        // Optional: Print completed requests as well
        // if (!completedRequestsList.isEmpty()) {
        //     System.out.println("--- Completed Requests ---");
        //     for (SupportRequest request : completedRequestsList) {
        //         System.out.println("  " + request.toString());
        //     }
        // }
    }

    /**
     * Starts the main application loop.
     * Handles user input and dispatches to appropriate methods using a switch statement.
     * Includes try-catch for robust input handling.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = -1; // Default invalid choice

            // --- Class-wide exception handling for input ---
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
                continue; // Skip the rest of the loop iteration
            } catch (Exception e) {
                // Catch any other unexpected errors during input reading
                System.err.println("An unexpected error occurred while reading input: " + e.getMessage());
                // Depending on the error, might need to consume or exit
                // For simplicity, we'll just continue here, but real-world might need more
                continue;
            }

            // --- Switch statement for flow control ---
            switch (choice) {
                case 1:
                    addNewRequest();
                    break;
                case 2:
                    processNextRequest();
                    break;
                case 3:
                    viewQueueStatus();
                    break;
                case 4:
                    running = false; // Exit the loop
                    System.out.println("Exiting Support Queue System.");
                    break;
                default:
                    // Input validation for choice range
                    System.err.println("Error: Invalid choice. Please enter a number between 1 and 4.");
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SupportQueueSystem system = new SupportQueueSystem();
        system.run();
    }
}
