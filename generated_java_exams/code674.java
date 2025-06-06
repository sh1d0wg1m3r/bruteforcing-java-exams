/*
 * Exam Question #674
 * Generated on: 2025-05-12 16:24:06
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Library Book Request Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified system for managing book requests in a library. When a book is not immediately available, a user can place a request. These requests are processed by library staff in the order they are received. The system needs to manage a queue of pending requests and keep a history of requests that have been processed.
 * 
 * **Your Task:**
 * 
 * Implement a Java application that simulates this library book request system. The application should provide a command-line interface for users (simulating library staff) to interact with the system.
 * 
 * **Requirements:**
 * 
 * 1.  **Classes:**
 *     *   Create a `Book` class with private fields for `title` and `author`, a constructor, and appropriate getter methods.
 *     *   Create a `BookRequest` class with private fields for `userId`, `requestedBook` (an instance of `Book`), `requestTimestamp` (use `long` for milliseconds since epoch), and `processed` (boolean). Include a constructor, getter methods, and a setter for `processed`.
 *     *   Create a `LibraryRequestSystem` class that manages the request queue and history.
 * 
 * 2.  **Data Structures:**
 *     *   The `LibraryRequestSystem` class must use a `java.util.Queue<BookRequest>` to store pending requests.
 *     *   The `LibraryRequestSystem` class must use a `java.util.List<BookRequest>` (specifically an `java.util.ArrayList`) to store the history of processed requests. Declare the history variable using the `List` interface.
 * 
 * 3.  **Functionality (within `LibraryRequestSystem`):**
 *     *   **Add Request:** Allow adding a new book request to the pending queue. This should take `userId`, `bookTitle`, and `bookAuthor` as input. Create `Book` and `BookRequest` objects and add the request to the queue.
 *     *   **Process Next Request:** Remove the oldest request from the pending queue, mark it as processed, and move it to the processed history list. Handle the case where the queue is empty.
 *     *   **View Pending Requests:** Display all requests currently in the pending queue in order. Handle the case where the queue is empty.
 *     *   **View Processed History:** Display all requests that have been processed. Handle the case where the history is empty.
 *     *   **Exit:** Terminate the application.
 * 
 * 4.  **User Interface:**
 *     *   Use `java.util.Scanner` to get input from the user via the console.
 *     *   Present a menu of options (Add Request, Process Next, View Pending, View History, Exit).
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Use `System.out` for displaying the menu, prompts, successful operation messages, and list contents.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, processing an empty queue).
 * 
 * 5.  **Error Handling & Best Practices:**
 *     *   Implement input validation for adding requests (e.g., check if user ID, title, or author are empty). Report validation errors using `System.err`.
 *     *   Implement class-wide exception handling using a `try-catch` block within the main application loop (`run` method or similar) to catch unexpected errors and report them using `System.err`.
 *     *   Adhere to Java best practices:
 *         *   Proper encapsulation (private fields, public methods).
 *         *   Meaningful variable and method names.
 *         *   Appropriate comments and documentation (Javadocs are a plus, but clear inline comments suffice for an exam).
 *         *   Clean code structure.
 * 
 * **Expected Output:**
 * 
 * The application should run interactively, presenting a menu, accepting input, performing actions, and displaying results or errors to the console using `System.out` and `System.err` as specified.
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * --- Library Request System Menu ---
 * 1. Add Book Request
 * 2. Process Next Request
 * 3. View Pending Requests
 * 4. View Processed History
 * 5. Exit
 * Enter your choice: 1
 * Enter User ID: user123
 * Enter Book Title: The Hitchhiker's Guide to the Galaxy
 * Enter Book Author: Douglas Adams
 * Request added successfully.
 * 
 * --- Library Request System Menu ---
 * ...
 * Enter your choice: 3
 * --- Pending Requests ---
 * Request by user123 for 'The Hitchhiker's Guide to the Galaxy' by Douglas Adams (Requested: <timestamp>)
 * --- End of Pending Requests ---
 * 
 * --- Library Request System Menu ---
 * ...
 * Enter your choice: 2
 * Processing request by user123 for 'The Hitchhiker's Guide to the Galaxy'.
 * Request processed successfully.
 * 
 * --- Library Request System Menu ---
 * ...
 * Enter your choice: 4
 * --- Processed History ---
 * Request by user123 for 'The Hitchhiker's Guide to the Galaxy' by Douglas Adams (Requested: <timestamp>, Processed: true)
 * --- End of Processed History ---
 * 
 * --- Library Request System Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Library Request System.
 * ```
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation of all required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`).
 * *   Correct logic for managing the request queue (FIFO) and history.
 * *   Proper handling of empty queue/history scenarios.
 * *   Effective input validation and error reporting via `System.err`.
 * *   Implementation of class-wide exception handling.
 * *   Adherence to best practices (encapsulation, naming, comments).
 * *   Code clarity and structure.
 * 
 * **Time Limit:** 45-60 minutes.
 *
 * EXPLANATION:
 * This solution implements a `LibraryRequestSystem` that manages book requests using a queue and a list, fulfilling all the requirements of the problem.
 * 
 * 1.  **Classes:**
 *     *   `Book`: A simple Plain Old Java Object (POJO) with `title` and `author`, demonstrating basic encapsulation with private fields and public getters.
 *     *   `BookRequest`: Represents a request, linking a user (`userId`) to a `Book`. It includes a timestamp and a status (`processed`). It also uses encapsulation.
 *     *   `LibraryRequestSystem`: The main class orchestrating the system. It holds the core data structures and business logic.
 * 
 * 2.  **Data Structures:**
 *     *   `Queue<BookRequest> pendingRequests`: Implemented using `java.util.LinkedList`. `LinkedList` is a common class that implements the `Queue` interface, providing FIFO (First-In, First-Out) behavior suitable for processing requests in order. Methods like `offer()` (add) and `poll()` (remove and return head) are used.
 *     *   `List<BookRequest> processedRequestsHistory`: Declared using the `java.util.List` interface and instantiated as a `java.util.ArrayList`. This demonstrates polymorphism and the common practice of programming to interfaces. `ArrayList` is suitable for storing a historical list where elements are added and iterated over.
 * 
 * 3.  **Functionality:**
 *     *   `addRequest`: Creates `Book` and `BookRequest` objects and adds them to the `pendingRequests` queue using `offer()`. Includes basic validation for input strings.
 *     *   `processNextRequest`: Checks if the queue is empty. If not, it uses `poll()` to get and remove the head of the queue, updates its `processed` status, and adds it to the `processedRequestsHistory` list using `add()`.
 *     *   `displayPendingRequests`: Iterates through the `pendingRequests` queue using an enhanced for loop (which uses an iterator internally) to display its contents without removing elements.
 *     *   `displayProcessedHistory`: Iterates through the `processedRequestsHistory` list using an enhanced for loop to display its contents.
 *     *   `run`: Contains the main application loop, displaying the menu and handling user input.
 * 
 * 4.  **User Interface:**
 *     *   `Scanner`: Used to read integer choices and string inputs from `System.in`. `scanner.nextLine()` is used after `scanner.nextInt()` to consume the leftover newline character.
 *     *   `switch`: Controls the flow based on the user's integer choice, directing execution to the appropriate method (`addRequest`, `processNextRequest`, etc.).
 *     *   `System.out`: Used for all standard output, including the menu, prompts, success messages, and the contents of the lists/queue.
 *     *   `System.err`: Used specifically for error messages, such as invalid menu choices, input validation failures, and messages from the catch blocks.
 * 
 * 5.  **Error Handling & Best Practices:**
 *     *   **Input Validation:** The `addRequest` method explicitly checks if `userId`, `bookTitle`, or `bookAuthor` are null or empty after trimming whitespace. Errors are reported via `System.err`.
 *     *   **Class-wide Exception Handling:** A `try-catch(Exception e)` block wraps the core logic within the `run` method's `while` loop. This catches any unhandled `Exception` that might occur during execution (like `InputMismatchException` if the user enters text instead of a number for the menu choice, or other unexpected runtime errors), prevents the program from crashing, and reports the error message and stack trace to `System.err`. A specific `catch` for `InputMismatchException` is included for clearer error messaging in that common case.
 *     *   **Encapsulation:** All data fields in `Book` and `BookRequest` are `private`, accessed only through public methods. `LibraryRequestSystem`'s data structures are also `private`.
 *     *   **Meaningful Names:** Variables (`pendingRequests`, `processedRequestsHistory`, `userId`, `requestedBook`), methods (`addRequest`, `processNextRequest`, `displayPendingRequests`, `run`), and classes (`Book`, `BookRequest`, `LibraryRequestSystem`) have names reflecting their purpose.
 *     *   **Comments:** Javadoc-style comments are used for classes and methods, explaining their purpose, parameters, and return values. Inline comments clarify specific logic points.
 *     *   **Clean Code Structure:** The code is divided into logical classes, methods are focused on single responsibilities, and indentation/formatting is consistent. The `main` method is simple, just creating an instance and starting the `run` loop. The `scanner` is closed upon exiting the `run` method.
 * 
 * This solution effectively demonstrates the required Java concepts and best practices within a practical, albeit simplified, application scenario.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Date; // Using Date for timestamp formatting in toString

// Represents a book
class Book {
    private String title;
    private String author;

    /**
     * Constructs a Book object.
     * @param title The title of the book.
     * @param author The author of the book.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Gets the title of the book.
     * @return The book title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     * @return The book author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Provides a string representation of the Book.
     * @return Formatted string of the book details.
     */
    @Override
    public String toString() {
        return "'" + title + "' by " + author;
    }
}

// Represents a user's request for a book
class BookRequest {
    private String userId;
    private Book requestedBook;
    private long requestTimestamp; // Milliseconds since epoch
    private boolean processed;

    /**
     * Constructs a BookRequest object.
     * @param userId The ID of the user making the request.
     * @param requestedBook The Book object being requested.
     */
    public BookRequest(String userId, Book requestedBook) {
        this.userId = userId;
        this.requestedBook = requestedBook;
        this.requestTimestamp = System.currentTimeMillis(); // Record creation time
        this.processed = false; // Initially not processed
    }

    /**
     * Gets the user ID associated with the request.
     * @return The user ID.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Gets the Book object requested.
     * @return The requested Book.
     */
    public Book getRequestedBook() {
        return requestedBook;
    }

    /**
     * Gets the timestamp when the request was created.
     * @return The request timestamp in milliseconds.
     */
    public long getRequestTimestamp() {
        return requestTimestamp;
    }

    /**
     * Checks if the request has been processed.
     * @return true if processed, false otherwise.
     */
    public boolean isProcessed() {
        return processed;
    }

    /**
     * Sets the processed status of the request.
     * @param processed The new processed status.
     */
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    /**
     * Provides a string representation of the BookRequest.
     * Includes processed status for history display.
     * @return Formatted string of the request details.
     */
    @Override
    public String toString() {
        // Using Date for a more readable timestamp format
        Date requestDate = new Date(requestTimestamp);
        String status = processed ? ", Processed: true" : "";
        return "Request by " + userId + " for " + requestedBook.toString() +
               " (Requested: " + requestDate + status + ")";
    }
}

// Manages the queue of pending requests and history of processed requests
public class LibraryRequestSystem {
    private Queue<BookRequest> pendingRequests;
    private List<BookRequest> processedRequestsHistory; // Declared as List, implemented by ArrayList
    private Scanner scanner;

    /**
     * Constructs a LibraryRequestSystem.
     * Initializes the queue and history list, and the scanner.
     */
    public LibraryRequestSystem() {
        this.pendingRequests = new LinkedList<>(); // LinkedList implements Queue
        this.processedRequestsHistory = new ArrayList<>(); // ArrayList implements List
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new book request to the pending queue.
     * Performs basic input validation.
     * @param userId The ID of the user.
     * @param bookTitle The title of the book.
     * @param bookAuthor The author of the book.
     */
    public void addRequest(String userId, String bookTitle, String bookAuthor) {
        // Input validation
        if (userId == null || userId.trim().isEmpty()) {
            System.err.println("Error: User ID cannot be empty.");
            return;
        }
        if (bookTitle == null || bookTitle.trim().isEmpty()) {
            System.err.println("Error: Book title cannot be empty.");
            return;
        }
        if (bookAuthor == null || bookAuthor.trim().isEmpty()) {
            System.err.println("Error: Book author cannot be empty.");
            return;
        }

        Book book = new Book(bookTitle.trim(), bookAuthor.trim());
        BookRequest request = new BookRequest(userId.trim(), book);
        pendingRequests.offer(request); // Use offer for adding to queue
        System.out.println("Request added successfully.");
    }

    /**
     * Processes the next request in the queue (FIFO).
     * Removes it from the queue, marks as processed, and adds to history.
     * Handles the case of an empty queue.
     */
    public void processNextRequest() {
        if (pendingRequests.isEmpty()) {
            System.out.println("No pending requests to process.");
        } else {
            BookRequest processedRequest = pendingRequests.poll(); // Remove head of queue
            processedRequest.setProcessed(true);
            processedRequestsHistory.add(processedRequest); // Add to history list
            System.out.println("Processing request by " + processedRequest.getUserId() +
                               " for '" + processedRequest.getRequestedBook().getTitle() + "'.");
            System.out.println("Request processed successfully.");
        }
    }

    /**
     * Displays all requests currently in the pending queue.
     * Handles the case of an empty queue.
     */
    public void displayPendingRequests() {
        System.out.println("\n--- Pending Requests ---");
        if (pendingRequests.isEmpty()) {
            System.out.println("Pending requests queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            for (BookRequest request : pendingRequests) {
                System.out.println(request);
            }
        }
        System.out.println("--- End of Pending Requests ---");
    }

    /**
     * Displays all requests in the processed history list.
     * Handles the case of an empty history.
     */
    public void displayProcessedHistory() {
        System.out.println("\n--- Processed History ---");
        if (processedRequestsHistory.isEmpty()) {
            System.out.println("Processed requests history is empty.");
        } else {
            // Iterate through the list
            for (BookRequest request : processedRequestsHistory) {
                System.out.println(request);
            }
        }
        System.out.println("--- End of Processed History ---");
    }

    /**
     * Runs the main application loop, displaying the menu and handling user input.
     * Includes class-wide exception handling.
     */
    public void run() {
        boolean running = true;
        while (running) {
            // Class-wide exception handling for unexpected errors
            try {
                printMenu();
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        System.out.print("Enter User ID: ");
                        String userId = scanner.nextLine();
                        System.out.print("Enter Book Title: ");
                        String bookTitle = scanner.nextLine();
                        System.out.print("Enter Book Author: ");
                        String bookAuthor = scanner.nextLine();
                        addRequest(userId, bookTitle, bookAuthor);
                        break;
                    case 2:
                        processNextRequest();
                        break;
                    case 3:
                        displayPendingRequests();
                        break;
                    case 4:
                        displayProcessedHistory();
                        break;
                    case 5:
                        System.out.println("Exiting Library Request System.");
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handles cases where user enters non-integer for choice
                System.err.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input to prevent infinite loop
            } catch (Exception e) {
                // Generic catch-all for other unexpected runtime exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to error stream
            }
            System.out.println(); // Add a newline for better readability between iterations
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("--- Library Request System Menu ---");
        System.out.println("1. Add Book Request");
        System.out.println("2. Process Next Request");
        System.out.println("3. View Pending Requests");
        System.out.println("4. View Processed History");
        System.out.println("5. Exit");
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        LibraryRequestSystem system = new LibraryRequestSystem();
        system.run();
    }
}
