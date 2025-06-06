/*
 * Exam Question #418
 * Generated on: 2025-05-11 23:08:19
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Document Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simple console-based system to manage documents for processing. Documents arrive and are placed in a queue. An operator can then process the next document from the queue, moving it to an archive. The system should allow viewing both the pending queue and the archived documents.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this document processing system. Your solution must adhere to the following:
 * 
 * 1.  **Core Functionality:**
 *     *   Allow users to add a new document to a processing queue. Each document should have a unique ID (String), a name (String), and a priority (integer).
 *     *   Allow users to process the next document from the front of the queue, moving it to an archived list.
 *     *   Allow users to view all documents currently in the processing queue.
 *     *   Allow users to view all documents currently in the archived list.
 *     *   Provide a menu-driven interface for the user to interact with the system.
 *     *   Allow the user to exit the system.
 * 
 * 2.  **Required Java Components:** Your solution MUST use ALL of the following:
 *     *   `java.util.Queue` (interface)
 *     *   `java.util.ArrayList` (concrete class)
 *     *   `java.util.List` (interface) - `ArrayList` should be referenced via the `List` interface.
 *     *   `java.util.Scanner` for user input.
 *     *   `switch` statement for handling menu options.
 *     *   `System.err` for displaying error messages (e.g., invalid input, processing errors).
 *     *   `System.out` for displaying normal output (menu, prompts, success messages, list contents).
 *     *   Class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors during the main execution loop.
 * 
 * 3.  **Best Practices:**
 *     *   Implement proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments explaining key parts of the code.
 *     *   Implement input validation (e.g., ensuring required fields are not empty, priority is a valid number).
 *     *   Implement proper error handling for operations (e.g., attempting to process an empty queue, invalid user input).
 *     *   Maintain a clean and readable code structure.
 * 
 * **Implementation Details:**
 * 
 * *   Create a `Document` class to represent a document with its properties (ID, name, priority).
 * *   Create a `DocumentProcessor` class that manages the queue and the archive list, handles user interaction, and implements the required operations.
 * *   The main logic should reside in the `DocumentProcessor` class, likely within a `run()` method called from `main`.
 * 
 * **Menu Options:**
 * 
 * 1.  Add New Document
 * 2.  Process Next Document
 * 3.  View Processing Queue
 * 4.  View Archived Documents
 * 0.  Exit
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt for user input, and display appropriate messages or lists based on the user's choice. Error messages should be clearly distinguishable using `System.err`.
 * 
 * **Example Interaction Flow (Illustrative):**
 * 
 * ```
 * --- Document Processing System ---
 * --- Menu ---
 * 1. Add New Document
 * 2. Process Next Document
 * 3. View Processing Queue
 * 4. View Archived Documents
 * 0. Exit
 * ------------
 * Enter your choice: 1
 * --- Add New Document ---
 * Enter Document ID: doc1
 * Enter Document Name: Report A
 * Enter Priority (integer): 5
 * Document added to processing queue: Document [ID=doc1, Name=Report A, Priority=5]
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 1
 * --- Add New Document ---
 * Enter Document ID: doc2
 * Enter Document Name: Memo B
 * Enter Priority (integer): 10
 * Document added to processing queue: Document [ID=doc2, Name=Memo B, Priority=10]
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 3
 * --- Processing Queue ---
 * 1. Document [ID=doc1, Name=Report A, Priority=5]
 * 2. Document [ID=doc2, Name=Memo B, Priority=10]
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 2
 * --- Process Next Document ---
 * Processed and archived document: Document [ID=doc1, Name=Report A, Priority=5]
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 3
 * --- Processing Queue ---
 * 1. Document [ID=doc2, Name=Memo B, Priority=10]
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 4
 * --- Archived Documents ---
 * 1. Document [ID=doc1, Name=Report A, Priority=5]
 * 
 * --- Menu ---
 * ...
 * Enter your choice: 0
 * Exiting system. Goodbye!
 * ```
 * 
 * This task requires you to integrate several fundamental Java concepts and data structures while applying good programming practices.
 *
 * EXPLANATION:
 * This solution implements a simple Document Processing System using the required Java components and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Document` class: A simple POJO (Plain Old Java Object) representing a document. It encapsulates the document's properties (`id`, `name`, `priority`) using private fields and provides public getter methods. The constructor includes basic validation to ensure data integrity upon object creation, throwing `IllegalArgumentException` for invalid inputs.
 *     *   `DocumentProcessor` class: This is the main class that orchestrates the system. It holds the core data structures (`processingQueue` and `archivedDocuments`) and contains methods for the system's operations (`addDocument`, `processNextDocument`, `viewProcessingQueue`, `viewArchivedDocuments`, `run`).
 * 
 * 2.  **Data Structures:**
 *     *   `processingQueue`: Declared as `Queue<Document>` and initialized with `new LinkedList<>()`. `LinkedList` is a common class that implements the `Queue` interface, providing FIFO (First-In, First-Out) behavior suitable for a processing queue where documents are processed in the order they arrive. `offer()` is used to add elements (preferred over `add()` in queue contexts), and `poll()` is used to retrieve and remove the head of the queue.
 *     *   `archivedDocuments`: Declared as `List<Document>` and initialized with `new ArrayList<>()`. `ArrayList` is a resizable array implementation of the `List` interface, suitable for storing the processed documents in a list where order is maintained and elements can be easily iterated over. `add()` is used to append processed documents.
 * 
 * 3.  **User Interaction and Flow Control:**
 *     *   `Scanner`: Used to read input from `System.in` for menu choices and document details. `nextLine()` is used consistently after reading numbers to avoid issues with leftover newline characters.
 *     *   `displayMenu()`: A private helper method to print the available options to `System.out`.
 *     *   `run()`: The main loop of the application. It repeatedly displays the menu, reads the user's choice, and uses a `switch` statement to dispatch the call to the appropriate method based on the choice. The loop continues until the user enters `0` to exit.
 *     *   `switch` statement: Effectively handles the branching logic based on the integer menu choice, directing execution to the specific operation requested by the user.
 * 
 * 4.  **Error Handling:**
 *     *   **Input Validation:** The `Document` constructor validates its input parameters (`id`, `name`, `priority`) and throws `IllegalArgumentException` if they are invalid. The `addDocument` method handles `NumberFormatException` if the priority input cannot be parsed as an integer.
 *     *   **Specific Operation Handling:** The `processNextDocument` method explicitly checks if the `processingQueue` is `isEmpty()` before attempting to `poll()`, preventing potential errors or exceptions related to operating on an empty collection. User-friendly messages are printed to `System.out` in this case.
 *     *   **Class-wide Exception Handling (`try-catch`):** A `try-catch` block is wrapped around the core logic inside the `run()` loop (specifically around the parsing of the choice and the `switch` statement). This block catches common exceptions like `NumberFormatException` (if the user enters non-numeric input for the menu choice), `IllegalArgumentException` (propagated from the `addDocument` method or `Document` constructor), `NoSuchElementException` (which could potentially occur if `remove()` was used on an empty queue, though `poll()` is safer), and a general `Exception` to catch any other unforeseen runtime errors. Error messages are printed to `System.err` to distinguish them from normal output. This structure ensures that an error in one operation doesn't necessarily crash the entire application loop.
 * 
 * 5.  **Output:**
 *     *   `System.out`: Used for printing the menu, prompts, successful operation messages, and the contents of the queue and archive lists.
 *     *   `System.err`: Used exclusively for printing error messages, making them stand out to the user.
 * 
 * 6.  **Best Practices Applied:**
 *     *   Encapsulation is demonstrated in the `Document` class and the private fields/methods of `DocumentProcessor`.
 *     *   Method and variable names are descriptive (e.g., `processingQueue`, `archivedDocuments`, `addDocument`).
 *     *   Basic comments explain the purpose of classes, fields, and methods.
 *     *   Input validation and specific error handling are implemented for operations like adding and processing documents.
 *     *   The code is structured into logical methods, improving readability and maintainability.
 * 
 * This solution effectively demonstrates the use of the required Java components in a practical scenario, incorporating essential programming practices like encapsulation, validation, and robust error handling.
 */

import java.util.Queue;
import java.util.LinkedList; // A common Queue implementation
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.NoSuchElementException; // Useful for queue operations like .remove() if used

/**
 * Represents a single document with ID, name, and priority.
 */
class Document {
    private String id;
    private String name;
    private int priority;

    /**
     * Constructs a new Document.
     *
     * @param id The unique identifier for the document.
     * @param name The name of the document.
     * @param priority The processing priority (lower number could mean higher priority, or vice versa; definition is flexible).
     * @throws IllegalArgumentException if id or name are null/empty, or priority is negative.
     */
    public Document(String id, String name, int priority) {
        // Input validation within the constructor
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Document ID cannot be empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Document name cannot be empty.");
        }
        if (priority < 0) {
             throw new IllegalArgumentException("Document priority cannot be negative.");
        }
        this.id = id.trim();
        this.name = name.trim();
        this.priority = priority;
    }

    // Getters for accessing private fields
    public String getId() { return id; }
    public String getName() { return name; }
    public int getPriority() { return priority; }

    /**
     * Provides a string representation of the Document.
     * @return Formatted string describing the document.
     */
    @Override
    public String toString() {
        return "Document [ID=" + id + ", Name=" + name + ", Priority=" + priority + "]";
    }
}

/**
 * Manages the processing and archiving of documents.
 * Provides a menu-driven interface for user interaction.
 */
public class DocumentProcessor {
    // Queue to hold documents waiting for processing (FIFO)
    private Queue<Document> processingQueue;
    // List to hold documents that have been processed
    private List<Document> archivedDocuments;
    // Scanner for reading user input from the console
    private Scanner scanner;

    /**
     * Constructs a new DocumentProcessor, initializing the queue, archive, and scanner.
     */
    public DocumentProcessor() {
        // Use LinkedList as a concrete implementation of Queue
        this.processingQueue = new LinkedList<>();
        // Use ArrayList as a concrete implementation of List
        this.archivedDocuments = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the main application loop, displaying the menu and handling user input.
     * Includes class-wide exception handling for robustness.
     */
    public void run() {
        System.out.println("--- Document Processing System ---");
        int choice = -1; // Initialize choice to a non-exit value

        // Main application loop
        while (choice != 0) {
            displayMenu();
            System.out.print("Enter your choice: ");

            // Class-wide exception handling block around the core command processing
            try {
                // Read the entire line to consume the newline character
                String inputLine = scanner.nextLine();
                choice = Integer.parseInt(inputLine); // Attempt to parse input as an integer

                // Use switch statement for flow control based on user choice
                switch (choice) {
                    case 1:
                        addDocument(); // Call method to add a document
                        break;
                    case 2:
                        processNextDocument(); // Call method to process the next document
                        break;
                    case 3:
                        viewProcessingQueue(); // Call method to view the queue
                        break;
                    case 4:
                        viewArchivedDocuments(); // Call method to view the archive
                        break;
                    case 0:
                        System.out.println("Exiting system. Goodbye!"); // Exit message
                        break;
                    default:
                        // Handle choices outside the defined range
                        System.err.println("Invalid choice. Please enter a number between 0 and 4.");
                }
            } catch (NumberFormatException e) {
                // Catch errors when input is not a valid integer
                System.err.println("Invalid input format. Please enter a number for your choice.");
            } catch (IllegalArgumentException e) {
                 // Catch validation errors thrown by Document constructor or other methods
                 System.err.println("Operation failed due to invalid data: " + e.getMessage());
            } catch (NoSuchElementException e) {
                 // Catch errors if trying to remove from an empty queue (e.g., using remove() instead of poll())
                 System.err.println("Operation failed: Processing queue is empty.");
            } catch (Exception e) {
                 // Catch any other unexpected runtime exceptions
                 System.err.println("An unexpected error occurred: " + e.getMessage());
                 // Optional: e.printStackTrace(); // Uncomment for detailed debugging
            }
            System.out.println(); // Add a newline for better readability between menu cycles
        }

        scanner.close(); // Close the scanner when the application exits
    }

    /**
     * Displays the main menu options to the console.
     */
    private void displayMenu() {
        System.out.println("--- Menu ---");
        System.out.println("1. Add New Document");
        System.out.println("2. Process Next Document");
        System.out.println("3. View Processing Queue");
        System.out.println("4. View Archived Documents");
        System.out.println("0. Exit");
        System.out.println("------------");
    }

    /**
     * Prompts the user for document details, creates a Document object,
     * and adds it to the processing queue. Includes input validation.
     */
    private void addDocument() {
        System.out.println("--- Add New Document ---");
        try {
            System.out.print("Enter Document ID: ");
            String id = scanner.nextLine(); // Read ID
            System.out.print("Enter Document Name: ");
            String name = scanner.nextLine(); // Read Name
            System.out.print("Enter Priority (integer): ");
            String priorityInput = scanner.nextLine(); // Read priority as string first

            // Validate and parse priority input
            int priority = Integer.parseInt(priorityInput); // Can throw NumberFormatException

            // Create new Document object (constructor includes validation for ID/Name/Priority value)
            Document newDoc = new Document(id, name, priority);

            // Add the document to the tail of the processing queue
            processingQueue.offer(newDoc); // offer() is generally safer than add() in capacity-constrained queues, but works here too
            System.out.println("Document added to processing queue: " + newDoc);

        } catch (NumberFormatException e) {
            // Specific error for non-integer priority input
            System.err.println("Invalid priority input. Please enter an integer.");
        } catch (IllegalArgumentException e) {
            // Specific error for validation issues caught by Document constructor
            System.err.println("Input validation failed: " + e.getMessage());
        } catch (Exception e) {
             // Catch any other unexpected errors during addition
             System.err.println("An unexpected error occurred while adding document: " + e.getMessage());
        }
    }

    /**
     * Removes the document at the head of the processing queue,
     * and adds it to the archived documents list. Handles empty queue.
     */
    private void processNextDocument() {
        System.out.println("--- Process Next Document ---");
        // Check if the queue is empty before attempting to process
        if (processingQueue.isEmpty()) {
            System.out.println("Processing queue is empty. Nothing to process.");
            return; // Exit the method if queue is empty
        }

        // Retrieve and remove the head of the queue
        Document processedDoc = processingQueue.poll(); // poll() returns null if queue is empty, but we already checked

        if (processedDoc != null) {
            // Add the processed document to the archived list
            archivedDocuments.add(processedDoc);
            System.out.println("Processed and archived document: " + processedDoc);
        } else {
             // This case should ideally not be reached due to the isEmpty() check,
             // but serves as a safeguard if poll() somehow returned null unexpectedly.
             System.err.println("Failed to retrieve document from queue for processing.");
        }
    }

    /**
     * Displays the contents of the processing queue without removing elements.
     */
    private void viewProcessingQueue() {
        System.out.println("--- Processing Queue ---");
        if (processingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
            return; // Exit the method if queue is empty
        }

        // Iterate through the queue using an enhanced for loop
        int index = 1;
        for (Document doc : processingQueue) {
            System.out.println(index++ + ". " + doc);
        }
    }

    /**
     * Displays the contents of the archived documents list.
     */
    private void viewArchivedDocuments() {
        System.out.println("--- Archived Documents ---");
        if (archivedDocuments.isEmpty()) {
            System.out.println("Archive is empty.");
            return; // Exit the method if archive is empty
        }

        // Iterate through the list using an enhanced for loop
        int index = 1;
        for (Document doc : archivedDocuments) {
            System.out.println(index++ + ". " + doc);
        }
    }

    /**
     * The main method, entry point of the application.
     * Creates a DocumentProcessor instance and calls its run method.
     */
    public static void main(String[] args) {
        DocumentProcessor processor = new DocumentProcessor();
        processor.run(); // Start the application
    }
}
