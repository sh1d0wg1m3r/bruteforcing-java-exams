/*
 * Exam Question #103
 * Generated on: 2025-05-11 22:14:49
 * Generated by: Account 2
 * 
 * QUESTION:
 * **Java Programming Exam Task: Document Processing Simulation System**
 * 
 * **Scenario:**
 * You are tasked with building a simple simulation of a document processing system. Documents arrive and are placed in a queue to await processing. A 'processor' component takes documents from the queue one at a time, attempts to process them, and then moves them to a history list, indicating whether processing was successful or failed. The system should be interactive, allowing a user to add new documents, trigger the processing of the next document, view the current processing queue, and view the history of processed documents.
 * 
 * **Requirements:**
 * 
 * 1.  **Implement a `Document` Class:**
 *     *   Create a class named `Document` with private fields: `id` (int), `name` (String), and `status` (an enum `ProcessingStatus`).
 *     *   Create an enum `ProcessingStatus` with values: `PENDING`, `PROCESSED`, `FAILED`.
 *     *   The `Document` constructor should accept `id` and `name` and initialize the status to `PENDING`.
 *     *   Provide public getter methods for `id`, `name`, and `status`.
 *     *   Provide a public setter method for `status` (needed during processing).
 *     *   Override the `toString()` method to provide a meaningful string representation of a Document (e.g., "Doc [ID=..., Name='...', Status=...]").
 * 
 * 2.  **Implement a Main Application Class (`DocumentProcessorApp`):**
 *     *   This class will contain the main logic and data structures.
 *     *   Use a `java.util.Queue<Document>` to represent the queue of documents waiting for processing. Initialize it using `java.util.LinkedList` (which implements `Queue`).
 *     *   Use a `java.util.List<Document>` to store the history of processed and failed documents. Initialize it using `java.util.ArrayList`.
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Implement a main application loop that displays a menu of options to the user:
 *         1.  Add Document to Queue
 *         2.  Process Next Document
 *         3.  View Processing Queue
 *         4.  View Processed History
 *         5.  Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Implement separate private methods for each menu option's logic (e.g., `addDocument()`, `processNextDocument()`, `viewProcessingQueue()`, `viewProcessedHistory()`).
 * 
 * 3.  **Functionality Details:**
 *     *   **Add Document:** Prompt the user for a Document ID (integer) and Name (String). Create a new `Document` object and add it to the processing queue. Include basic validation (e.g., check if name is empty).
 *     *   **Process Next Document:**
 *         *   Retrieve and remove the next document from the head of the processing queue.
 *         *   If the queue is empty, inform the user using `System.out`.
 *         *   If a document is retrieved, simulate processing. For this simulation, assume processing is successful if the Document ID is even, and fails if the Document ID is odd.
 *         *   Update the document's status (`PROCESSED` or `FAILED`) using the setter.
 *         *   Add the processed document (regardless of success/failure) to the processed history list.
 *         *   Print the outcome of the processing (success or failure) to `System.out` or `System.err` appropriately.
 *     *   **View Processing Queue:** Print the details of all documents currently in the queue without removing them. If the queue is empty, state so.
 *     *   **View Processed History:** Print the details of all documents in the history list. If the history is empty, state so.
 * 
 * 4.  **Error Handling:**
 *     *   Use `System.err` to print error messages (e.g., invalid menu choice, invalid input when adding a document, errors during simulated processing).
 *     *   Implement class-wide exception handling using `try-catch` blocks. Specifically, handle potential `InputMismatchException` when reading integer input from the `Scanner` and general `Exception` for unexpected issues in methods like `addDocument` or `processNextDocument`. Ensure the scanner input stream is handled correctly after an `InputMismatchException`.
 * 
 * 5.  **Best Practices:**
 *     *   Use appropriate access modifiers (`private`, `public`).
 *     *   Use meaningful variable and method names.
 *     *   Add basic comments where necessary to explain complex logic (though the structure should be clear).
 *     *   Ensure resources like the `Scanner` are closed when the application exits.
 * 
 * **Expected Output:**
 * The program should run interactively, presenting a menu. Based on user input, it should perform the requested action, print relevant information to `System.out`, and print error messages to `System.err`.
 * 
 * ```
 * --- Document Processor Menu ---
 * 1. Add Document to Queue
 * 2. Process Next Document
 * 3. View Processing Queue
 * 4. View Processed History
 * 5. Exit
 * Enter your choice: 1
 * Enter Document ID: 101
 * Enter Document Name: Report A
 * Document added to queue: Doc [ID=101, Name='Report A', Status=PENDING]
 * 
 * --- Document Processor Menu ---
 * 1. Add Document to Queue
 * 2. Process Next Document
 * 3. View Processing Queue
 * 4. View Processed History
 * 5. Exit
 * Enter your choice: 3
 * 
 * --- Current Processing Queue ---
 * Doc [ID=101, Name='Report A', Status=PENDING]
 * 
 * --- Document Processor Menu ---
 * ... (user enters 2) ...
 * Processing document: Report A (ID: 101)
 * Simulating processing for ID 101...
 * Document processing failed. // Or System.err.println(...)
 * ... (user enters 4) ...
 * 
 * --- Processed Document History ---
 * Doc [ID=101, Name='Report A', Status=FAILED]
 * 
 * ... (user enters invalid input) ...
 * Error: Invalid input. Please enter a number. // Printed to System.err
 * ...
 * ```
 *
 * EXPLANATION:
 * The provided solution implements a `Document Processing Simulation System` meeting all specified requirements.
 * 
 * 1.  **`Document` Class:**
 *     *   Represents the data model for a document with `id`, `name`, and `status`.
 *     *   Uses the `ProcessingStatus` enum for clear status representation (`PENDING`, `PROCESSED`, `FAILED`).
 *     *   Employs encapsulation with private fields and public getters/setters.
 *     *   Overrides `toString()` for easy printing of document details.
 * 
 * 2.  **`DocumentProcessorApp` Class:**
 *     *   This is the main class containing the application logic.
 *     *   **`Queue<Document> processingQueue`:** A `LinkedList` is used to implement the `Queue` interface. This structure naturally supports First-In, First-Out (FIFO) behavior, suitable for a processing queue where documents are processed in the order they are added. `offer()` is used for adding and `poll()` for retrieving and removing elements.
 *     *   **`List<Document> processedHistory`:** An `ArrayList` is used to implement the `List` interface. This provides a dynamic array to store documents after they have been processed, allowing easy iteration and storage of the history. `add()` is used to append documents.
 *     *   **`Scanner scanner`:** Used to read user input from `System.in`. It's initialized once and closed when the application exits.
 *     *   **Main Loop (`run()` method):** A `while` loop keeps the application running until the user chooses to exit.
 *     *   **`switch` Statement:** The `switch` statement in the `run` method effectively handles different menu choices, directing the program flow to the corresponding methods (`addDocument`, `processNextDocument`, etc.).
 *     *   **`displayMenu()`:** A simple helper method to print the available options to `System.out`.
 *     *   **`addDocument()`:** Prompts for document details, creates a `Document` object, and adds it to the `processingQueue` using `offer()`. Includes basic validation for the document name and uses a `try-catch` block to handle `InputMismatchException` if the user enters non-integer input for the ID. `scanner.nextLine()` is correctly used after `nextInt()` and within the catch block to consume newline characters and invalid input, preventing scanner issues.
 *     *   **`processNextDocument()`:** Retrieves the next document from the queue using `poll()`. Checks if the queue is empty. Calls `simulateProcessing()` to determine success/failure. Updates the document's status using `setStatus()`. Adds the document to the `processedHistory` list. Uses `System.err` for the processing failure message. Includes a `try-catch` block for general exceptions during the process.
 *     *   **`simulateProcessing()`:** Contains the simple logic for simulating processing (even ID = success, odd ID = failure). Includes an optional `Thread.sleep` to mimic work being done.
 *     *   **`viewProcessingQueue()`:** Iterates through the `processingQueue` using an enhanced for loop (which does not remove elements) and prints each document's details to `System.out`. Checks if the queue is empty.
 *     *   **`viewProcessedHistory()`:** Iterates through the `processedHistory` `List` and prints each document's details to `System.out`. Checks if the history is empty.
 * 
 * 3.  **Error Handling and `System.err`:**
 *     *   `try-catch` blocks are strategically placed in `run()`, `addDocument()`, and `processNextDocument()` to handle potential runtime errors like `InputMismatchException` (for invalid user input) and general `Exception` for unexpected issues.
 *     *   `System.err.println()` is used specifically for printing error messages, distinguishing them from normal application output (`System.out.println()`). This is used for invalid menu choices, input validation errors, processing failures, and caught exceptions.
 * 
 * 4.  **Best Practices:**
 *     *   Private fields and public methods demonstrate proper encapsulation.
 *     *   Method and variable names are descriptive (e.g., `processingQueue`, `processNextDocument`, `viewProcessedHistory`).
 *     *   Basic comments explain the purpose of classes, methods, and key code sections.
 *     *   Input validation checks for empty names and handles invalid input types.
 *     *   The `Scanner` is closed when the application exits.
 *     *   The code is structured into logical methods, making it more readable and maintainable.
 * 
 * This solution effectively integrates `Queue`, `ArrayList` (as `List`), `Scanner`, `switch`, `System.out`, `System.err`, and `try-catch` blocks within a practical, simulated scenario, demonstrating advanced Java programming concepts and best practices.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Enum to represent the processing status of a document
enum ProcessingStatus {
    PENDING, PROCESSED, FAILED
}

// Represents a document in the system
class Document {
    private int id;
    private String name;
    private ProcessingStatus status;

    /**
     * Constructs a new Document.
     * @param id The unique identifier for the document.
     * @param name The name or title of the document.
     */
    public Document(int id, String name) {
        this.id = id;
        this.name = name;
        this.status = ProcessingStatus.PENDING; // Documents start as PENDING
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProcessingStatus getStatus() {
        return status;
    }

    // --- Setter (used by the processor) ---
    /**
     * Sets the processing status of the document.
     * @param status The new status (PROCESSED or FAILED).
     */
    public void setStatus(ProcessingStatus status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Document.
     * @return A formatted string showing ID, Name, and Status.
     */
    @Override
    public String toString() {
        return "Doc [ID=" + id + ", Name='" + name + "', Status=" + status + "]";
    }
}

// Main application class for the Document Processing Simulation
public class DocumentProcessorApp {

    // Queue for documents waiting to be processed
    private Queue<Document> processingQueue;
    // List to store documents after processing (history)
    private List<Document> processedHistory;
    // Scanner for reading user input
    private Scanner scanner;

    /**
     * Constructs the DocumentProcessorApp, initializing data structures and scanner.
     */
    public DocumentProcessorApp() {
        // LinkedList implements the Queue interface, suitable for FIFO
        processingQueue = new LinkedList<>();
        // ArrayList implements the List interface, suitable for dynamic history storage
        processedHistory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Document Processor Menu ---");
        System.out.println("1. Add Document to Queue");
        System.out.println("2. Process Next Document");
        System.out.println("3. View Processing Queue");
        System.out.println("4. View Processed History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles adding a new document to the processing queue based on user input.
     * Includes input validation and exception handling.
     */
    private void addDocument() {
        try {
            System.out.print("Enter Document ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            System.out.print("Enter Document Name: ");
            String name = scanner.nextLine();

            // Basic validation for document name
            if (name == null || name.trim().isEmpty()) {
                System.err.println("Error: Document name cannot be empty.");
                return; // Exit method on validation failure
            }

            // Create and add the new document to the queue
            Document newDoc = new Document(id, name.trim());
            processingQueue.offer(newDoc); // offer() is preferred over add() for queues as it handles capacity limits (though LinkedList is unbounded)
            System.out.println("Document added to queue: " + newDoc);

        } catch (InputMismatchException e) {
            // Handle cases where the user enters non-integer input for ID
            System.err.println("Error: Invalid input. Please enter a valid integer for Document ID.");
            scanner.nextLine(); // IMPORTANT: Consume the invalid input to prevent infinite loop
        } catch (Exception e) {
            // Catch any other unexpected errors during document addition
            System.err.println("An unexpected error occurred while adding document: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for detailed debugging
        }
    }

    /**
     * Handles processing the next document from the queue.
     * Simulates processing success/failure and moves the document to history.
     * Includes queue state check and exception handling.
     */
    private void processNextDocument() {
        try {
            // Retrieve and remove the head of the queue. poll() returns null if queue is empty.
            Document docToProcess = processingQueue.poll();

            if (docToProcess == null) {
                System.out.println("Processing queue is empty. No documents to process.");
                return; // Exit if queue is empty
            }

            System.out.println("Processing document: " + docToProcess.getName() + " (ID: " + docToProcess.getId() + ")");

            // Simulate processing logic: Success if ID is even, Failure if ID is odd
            boolean success = simulateProcessing(docToProcess);

            if (success) {
                docToProcess.setStatus(ProcessingStatus.PROCESSED);
                System.out.println("Document processed successfully.");
            } else {
                docToProcess.setStatus(ProcessingStatus.FAILED);
                System.err.println("Document processing failed."); // Use System.err for failure message
            }

            // Add the document to the history list regardless of processing outcome
            processedHistory.add(docToProcess);

        } catch (Exception e) {
            // Catch any unexpected errors during processing
            System.err.println("An unexpected error occurred during document processing: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for detailed debugging
        }
    }

    /**
     * Simulates the processing logic for a document.
     * In a real system, this would be complex business logic.
     * @param doc The document to simulate processing for.
     * @return true if processing is simulated as successful, false otherwise.
     */
    private boolean simulateProcessing(Document doc) {
        System.out.println("Simulating processing for ID " + doc.getId() + "...");
        // Simulate a small delay to make it feel more realistic (optional)
        try {
            Thread.sleep(300); // Sleep for 300 milliseconds
        } catch (InterruptedException e) {
            // Restore the interrupted status
            Thread.currentThread().interrupt();
            System.err.println("Processing simulation interrupted.");
        }
        // Simple rule: even IDs succeed, odd IDs fail
        return doc.getId() % 2 == 0;
    }

    /**
     * Displays the documents currently in the processing queue.
     */
    private void viewProcessingQueue() {
        System.out.println("\n--- Current Processing Queue ---");
        if (processingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate over the queue without removing elements (using enhanced for loop)
            for (Document doc : processingQueue) {
                System.out.println(doc);
            }
        }
    }

    /**
     * Displays the history of processed (and failed) documents.
     */
    private void viewProcessedHistory() {
        System.out.println("\n--- Processed Document History ---");
        if (processedHistory.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            // Iterate over the history list
            for (Document doc : processedHistory) {
                System.out.println(doc);
            }
        }
    }

    /**
     * The main method that runs the application loop.
     * Handles user input and dispatches to appropriate methods using a switch statement.
     * Includes exception handling for the main loop input.
     */
    public void run() {
        int choice = -1; // Initialize choice to a non-exit value

        // Main application loop continues until user chooses to exit (option 5)
        while (choice != 5) {
            displayMenu(); // Show menu options

            try {
                // Read user's menu choice
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Process the user's choice using a switch statement
                switch (choice) {
                    case 1:
                        addDocument(); // Call method to add a document
                        break;
                    case 2:
                        processNextDocument(); // Call method to process next document
                        break;
                    case 3:
                        viewProcessingQueue(); // Call method to view queue
                        break;
                    case 4:
                        viewProcessedHistory(); // Call method to view history
                        break;
                    case 5:
                        System.out.println("Exiting Document Processor. Goodbye!"); // Exit message
                        break;
                    default:
                        // Handle invalid integer input for menu choice
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handle cases where the user enters non-integer input for menu choice
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // IMPORTANT: Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to ensure the loop continues after error
            } catch (Exception e) {
                 // Catch any other unexpected errors in the main loop
                 System.err.println("An unexpected error occurred in the main loop: " + e.getMessage());
                 // e.printStackTrace(); // Uncomment for detailed debugging
                 choice = -1; // Reset choice to ensure the loop continues after error
            }
        }

        // Close the scanner when the application exits
        scanner.close();
    }

    /**
     * The entry point of the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create an instance of the application and run it
        DocumentProcessorApp app = new DocumentProcessorApp();
        app.run();
    }
}
