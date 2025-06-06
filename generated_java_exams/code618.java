/*
 * Exam Question #618
 * Generated on: 2025-05-12 16:15:35
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Document Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified command-line application for managing documents that need processing. The system should allow users to submit new documents, process the next available document in a queue, view documents awaiting processing, and view documents that have been completed.
 * 
 * Your solution must demonstrate a strong understanding of core Java concepts and collections, adhering to best practices for structure, encapsulation, and error handling.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a collection of documents awaiting processing using `java.util.Queue`. Documents must be processed in the order they were submitted (First-In, First-Out). Use a suitable concrete implementation of `Queue`.
 *     *   Maintain a collection of completed documents using `java.util.List`. Use `java.util.ArrayList` as the concrete implementation.
 * 2.  **Document Class:**
 *     *   Create a class named `Document` with the following private fields:
 *         *   `id` (int): A unique identifier for the document.
 *         *   `type` (String): The type of document (e.g., "Report", "Invoice", "Other").
 *         *   `content` (String): A brief description or content of the document.
 *     *   Implement a constructor to initialize these fields.
 *     *   Provide public getter methods for all fields.
 *     *   Override the `toString()` method to return a formatted string representation of the `Document` object (e.g., "Document [ID=1, Type='Report', Content='Monthly data summary']").
 * 3.  **Document Processing System Class:**
 *     *   Create a main class (e.g., `DocumentProcessingSystem`) that contains the `Queue` and `List` instances as private member variables.
 *     *   Implement methods for the system's operations:
 *         *   A method to add a new document to the pending queue. It should automatically assign a unique ID (starting from 1 and incrementing).
 *         *   A method to process the next document: remove the document from the head of the pending queue, simulate processing (e.g., print a message), and add it to the completed list. This method must handle the case where the pending queue is empty.
 *         *   Methods to view the documents in the pending queue and the completed list. These methods should display the documents using their `toString()` representation.
 * 4.  **User Interface:**
 *     *   Implement a simple text-based menu using `java.util.Scanner` in the `main` method. The menu should offer the following options:
 *         1.  Submit New Document
 *         2.  Process Next Document
 *         3.  View Pending Documents
 *         4.  View Completed Documents
 *         5.  Exit
 *     *   Use a `switch` statement to direct the program flow based on the user's menu choice.
 *     *   The menu loop should continue until the user chooses to exit.
 * 5.  **Input/Output:**
 *     *   Use `System.out` for all standard output, including the menu, prompts, success messages, and document lists.
 *     *   Use `System.err` to display error messages.
 * 6.  **Error Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks within the `main` method's menu loop. This block should catch potential `InputMismatchException` when reading integer input and any other unexpected runtime exceptions.
 *     *   The method for processing the next document must explicitly check if the pending queue is empty. If it is, it should report an error message using `System.err` instead of attempting to process.
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Include basic comments or Javadoc for clarity.
 *     *   Ensure the code is well-formatted and readable.
 * 
 * **Expected Output:**
 * 
 * The program should interact with the user via the console, presenting a menu and responding to choices.
 * - Submitting a document should confirm the action and show the assigned ID.
 * - Processing should indicate which document was processed or report an error if the queue is empty (via `System.err`).
 * - Viewing lists should display documents or indicate the list is empty.
 * - Invalid menu input should result in an error message on `System.err` and the menu should reappear.
 * - The program should exit cleanly when the user chooses option 5.
 * 
 * Your solution should be a single Java file containing both the `Document` and `DocumentProcessingSystem` classes (or inner classes if preferred, but separate top-level classes are fine).
 *
 * EXPLANATION:
 * This solution implements a simple Document Processing System as required by the exam task. It effectively utilizes the specified Java components to simulate a real-world queue-based processing flow.
 * 
 * 1.  **`Document` Class:**
 *     *   This class serves as a simple Plain Old Java Object (POJO) to represent a document.
 *     *   It has `private` fields (`id`, `type`, `content`) ensuring encapsulation.
 *     *   Public getter methods (`getId`, `getType`, `getContent`) provide controlled access to the data.
 *     *   The `toString()` method is overridden to provide a convenient, readable representation when printing `Document` objects.
 * 
 * 2.  **`DocumentProcessingSystem` Class:**
 *     *   This is the main class orchestrating the system.
 *     *   It holds the two core collections as `private` members: `pendingDocumentsQueue` (declared as `Queue<Document>`, implemented with `LinkedList`) and `completedDocumentsList` (declared as `List<Document>`, implemented with `ArrayList`). Using the interface types (`Queue`, `List`) for declarations is good practice, allowing flexibility in choosing concrete implementations.
 *     *   `pendingDocumentsQueue`: A `Queue` is used here because documents are processed in the order they arrive (FIFO), which is the primary characteristic of a queue. `LinkedList` is a common and efficient implementation for queue operations (`add`, `poll`, `peek`).
 *     *   `completedDocumentsList`: An `ArrayList` is used here as it's a simple, dynamic list suitable for storing completed items where order of completion is relevant, and random access isn't a primary concern (though `ArrayList` supports it efficiently).
 *     *   `nextDocumentId`: A simple counter to ensure each submitted document gets a unique ID.
 *     *   **`submitDocument(String type, String content)`:** Creates a new `Document` object, assigns the next ID, and adds it to the `pendingDocumentsQueue` using the `add()` method. Includes basic input validation for type and content.
 *     *   **`processNextDocument()`:**
 *         *   Crucially, it checks if the `pendingDocumentsQueue` is `isEmpty()`.
 *         *   If empty, it prints an error message to `System.err` and returns, fulfilling the requirement to handle this specific error case using `System.err`.
 *         *   If not empty, it uses `pendingDocumentsQueue.poll()` to retrieve and remove the document at the head of the queue.
 *         *   The removed document is then added to the `completedDocumentsList` using `add()`.
 *         *   Success messages are printed to `System.out`.
 *     *   **`viewPendingDocuments()` and `viewCompletedDocuments()`:** These methods iterate through the respective collections (`pendingDocumentsQueue` and `completedDocumentsList`) and print each `Document`'s `toString()` representation to `System.out`. They also check if the collections are empty and print a corresponding message. Iterating over the `Queue` using an enhanced for loop or iterator does not remove elements, which is the desired behavior for viewing.
 *     *   **`printMenu()`:** A helper method to display the menu options using `System.out`.
 *     *   **`main(String[] args)`:**
 *         *   This is the entry point of the application.
 *         *   It creates an instance of `DocumentProcessingSystem` and a `Scanner` for user input.
 *         *   It contains the main application loop (`while(running)`).
 *         *   **`Scanner` and Input Handling:** `Scanner` is used to read user input. `scanner.nextInt()` reads the integer menu choice, and `scanner.nextLine()` is used immediately after to consume the leftover newline character, preventing issues with subsequent `nextLine()` calls when reading strings.
 *         *   **`try-catch` for Class-wide Exception Handling:** The entire core logic within the `while` loop is wrapped in a `try-catch` block. This block serves as the class-wide exception handler for the main execution flow.
 *             *   `catch (InputMismatchException e)` specifically handles cases where the user enters non-integer input for the menu choice. It prints an error to `System.err` and, importantly, calls `scanner.nextLine()` to clear the invalid input from the scanner's buffer, preventing an infinite loop.
 *             *   `catch (Exception e)` is a general catch block to handle any other unexpected runtime exceptions that might occur within the loop, demonstrating a fallback for unforeseen errors. It prints a generic error message and the exception's message to `System.err`.
 *         *   **`switch` Statement:** The user's valid menu choice is processed using a `switch` statement, directing execution to the appropriate system method (`submitDocument`, `processNextDocument`, etc.) or handling the exit condition. The `default` case handles valid integer inputs that are outside the expected menu range (1-5).
 *         *   `System.out` is used for all standard interactive output.
 *         *   `System.err` is used exclusively for error reporting (invalid input, empty queue processing error).
 *         *   The `scanner` is closed before the program exits to release system resources.
 * 
 * This solution effectively combines collection management (`Queue`, `List`/`ArrayList`), object-oriented principles (encapsulation in `Document`), user interaction (`Scanner`, `switch`), and robust error handling (`try-catch`, `System.err`) as required, demonstrating an advanced understanding of these Java concepts.
 */

import java.util.Queue;
import java.util.LinkedList; // A common implementation of Queue
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a document in the processing system.
 */
class Document { // Using default package visibility for simplicity in a single-file solution
    private int id;
    private String type;
    private String content;

    /**
     * Constructs a new Document.
     * @param id The unique ID of the document.
     * @param type The type of the document (e.g., "Report", "Invoice").
     * @param content The content or description of the document.
     */
    public Document(int id, String type, String content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    /**
     * Provides a string representation of the document.
     * @return A formatted string describing the document.
     */
    @Override
    public String toString() {
        // Simple representation for display
        return "Document [ID=" + id + ", Type='" + type + "', Content='" + content + "']";
    }
}

/**
 * Manages the queue and processing of documents.
 */
public class DocumentProcessingSystem {
    private Queue<Document> pendingDocumentsQueue;
    private List<Document> completedDocumentsList;
    private int nextDocumentId; // To generate unique IDs

    /**
     * Constructs a new DocumentProcessingSystem.
     * Initializes the pending queue and completed list.
     */
    public DocumentProcessingSystem() {
        pendingDocumentsQueue = new LinkedList<>(); // LinkedList implements Queue
        completedDocumentsList = new ArrayList<>();
        nextDocumentId = 1;
    }

    /**
     * Submits a new document to the pending queue.
     * Assigns a unique ID to the document.
     * @param type The type of the document.
     * @param content The content of the document.
     */
    public void submitDocument(String type, String content) {
        // Basic validation
        if (type == null || type.trim().isEmpty() || content == null || content.trim().isEmpty()) {
            System.err.println("Error: Document type and content cannot be empty.");
            return;
        }
        Document newDoc = new Document(nextDocumentId++, type.trim(), content.trim());
        pendingDocumentsQueue.add(newDoc);
        System.out.println("Document submitted: ID " + newDoc.getId());
    }

    /**
     * Processes the next document from the pending queue.
     * Removes it from the queue and adds it to the completed list.
     * Reports an error if the queue is empty.
     */
    public void processNextDocument() {
        if (pendingDocumentsQueue.isEmpty()) {
            // Use System.err as required for errors
            System.err.println("Error: No documents in the pending queue to process.");
            return; // Exit method on error
        }

        Document docToProcess = pendingDocumentsQueue.poll(); // Removes and returns the head
        completedDocumentsList.add(docToProcess);
        System.out.println("Processing document: ID " + docToProcess.getId() + ", Type: " + docToProcess.getType());
        // Simulate processing work (optional)
        // try { Thread.sleep(500); } catch (InterruptedException e) {}
        System.out.println("Document ID " + docToProcess.getId() + " processed and moved to completed.");
    }

    /**
     * Displays all documents currently in the pending queue without removing them.
     */
    public void viewPendingDocuments() {
        if (pendingDocumentsQueue.isEmpty()) {
            System.out.println("No documents currently in the pending queue.");
            return;
        }
        System.out.println("\n--- Pending Documents ---");
        int count = 1;
        // Iterate through the queue using enhanced for loop (doesn't remove elements)
        for (Document doc : pendingDocumentsQueue) {
            System.out.println(count++ + ". " + doc); // Document.toString() is used here
        }
        System.out.println("-------------------------");
    }

    /**
     * Displays all documents that have been completed.
     */
    public void viewCompletedDocuments() {
         if (completedDocumentsList.isEmpty()) {
            System.out.println("No documents have been completed yet.");
            return;
        }
        System.out.println("\n--- Completed Documents ---");
        int count = 1;
        // Iterate through the list
        for (Document doc : completedDocumentsList) {
            System.out.println(count++ + ". " + doc); // Document.toString() is used here
        }
        System.out.println("---------------------------");
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\n--- Document Processing System Menu ---");
        System.out.println("1. Submit New Document");
        System.out.println("2. Process Next Document");
        System.out.println("3. View Pending Documents");
        System.out.println("4. View Completed Documents");
        System.out.println("5. Exit");
        System.out.println("---------------------------------------");
    }

    /**
     * The main method to run the document processing system.
     * Handles user interaction and menu navigation.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        DocumentProcessingSystem system = new DocumentProcessingSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("--- Welcome to the Document Processing System ---");

        // Main application loop with class-wide exception handling
        while (running) {
            printMenu();
            int choice = -1; // Initialize choice to an invalid value

            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1: // Submit Document
                        System.out.print("Enter document type: ");
                        String type = scanner.nextLine();
                        System.out.print("Enter document content: ");
                        String content = scanner.nextLine();
                        system.submitDocument(type, content);
                        break;
                    case 2: // Process Next Document
                        system.processNextDocument();
                        break;
                    case 3: // View Pending Documents
                        system.viewPendingDocuments();
                        break;
                    case 4: // View Completed Documents
                        system.viewCompletedDocuments();
                        break;
                    case 5: // Exit
                        System.out.println("Exiting Document Processing System. Goodbye!");
                        running = false;
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handle non-integer input specifically
                System.err.println("Invalid input. Please enter a number for your choice.");
                scanner.nextLine(); // IMPORTANT: Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                 // Catch any other unexpected exceptions during the loop
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(System.err); // Uncomment for detailed debugging stack trace
            }
            System.out.println(); // Add a blank line for better readability between operations
        }

        scanner.close(); // Close the scanner when the program exits
    }
}
