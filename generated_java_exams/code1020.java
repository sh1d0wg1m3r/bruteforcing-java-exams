/*
 * Exam Question #1020
 * Generated on: 2025-05-12 17:13:52
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Print Job Scheduler
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application that simulates a print job scheduler. The application should manage a queue of pending print jobs and keep a list of completed jobs. Users interact with the system via a menu to add new jobs, process the next available job, view pending jobs, or view completed jobs.
 * 
 * **Requirements:**
 * 
 * Your solution must be a single Java application containing at least two classes (`PrintJob` and `PrintScheduler`) and must demonstrate the use of ALL the following Java components:
 * 
 * 1.  **`java.util.Queue`**: To store pending print jobs in a First-In, First-Out (FIFO) manner.
 * 2.  **`java.util.ArrayList`**: To store completed print jobs.
 * 3.  **`java.util.List` interface**: Used as a type reference for the completed jobs list.
 * 4.  **`java.util.Scanner`**: To read user input from the console.
 * 5.  **`switch` statement**: To handle different user menu choices.
 * 6.  **`System.err`**: To output error messages (e.g., invalid input, no jobs to process).
 * 7.  **`System.out`**: To output normal messages (menu, prompts, job details, success messages).
 * 8.  **Class-wide exception handling with `try-catch` blocks**: Implement a main `try-catch` block around the core application loop to catch unexpected runtime exceptions, and also handle specific expected exceptions (like input errors) where appropriate.
 * 
 * **Implementation Details:**
 * 
 * *   Create a `PrintJob` class with private fields for `id` (unique identifier), `fileName` (String), `pages` (int), and `status` (e.g., an Enum `JobStatus`). Include a constructor, getters, a method to mark the job as completed, and a `toString()` method. Generate unique IDs automatically for each job.
 * *   Create a `PrintScheduler` class containing the `main` method and methods to manage the print jobs.
 * *   The `PrintScheduler` should have private fields for the pending job queue and the completed jobs list.
 * *   The main loop in `PrintScheduler` should display a menu and process user input using a `switch` statement.
 * *   **Menu Options:**
 *     1.  **Add New Print Job:** Prompt the user for the file name and number of pages. Validate that the number of pages is positive. Create a `PrintJob` object and add it to the pending queue. Handle non-integer input for pages using `Scanner` and `try-catch`.
 *     2.  **Process Next Job:** Take the next job from the front of the pending queue. If the queue is empty, print an error message to `System.err`. If a job is processed, mark its status as completed and move it to the completed jobs list. Print a success message to `System.out`.
 *     3.  **View Pending Jobs:** Display all jobs currently in the pending queue in their current order. If the queue is empty, print a message to `System.out`.
 *     4.  **View Completed Jobs:** Display all jobs in the completed jobs list. If the list is empty, print a message to `System.out`. Use the `List` interface type when referencing the completed jobs collection.
 *     5.  **Exit:** Terminate the application loop.
 * *   Handle invalid menu choices by printing an error message to `System.err`.
 * *   Implement robust input validation and error handling using `try-catch` blocks for `Scanner` input errors (`InputMismatchException`).
 * *   Implement the class-wide `try-catch` in the main execution method (`run` or `main` loop) to catch any other unforeseen exceptions, printing a general error message to `System.err`.
 * *   Follow best practices: meaningful variable/method names, proper encapsulation, basic comments.
 * 
 * **Expected Output:**
 * 
 * Your program should produce output similar to the following examples:
 * 
 * *   **Initial state/Menu:** Display the menu options.
 * *   **Adding a job:**
 *     ```
 *     --- Add New Print Job ---
 *     Enter file name: document.txt
 *     Enter number of pages: 15
 *     Print job added: Job [ID=1, File='document.txt', Pages=15, Status=PENDING]
 *     ```
 * *   **Adding a job with invalid pages:**
 *     ```
 *     --- Add New Print Job ---
 *     Enter file name: report.pdf
 *     Enter number of pages: -5
 *     Number of pages must be positive.
 *     Enter number of pages: zero
 *     Invalid input. Please enter a valid number for pages.
 *     Enter number of pages: 20
 *     Print job added: Job [ID=2, File='report.pdf', Pages=20, Status=PENDING]
 *     ```
 * *   **Viewing Pending Jobs:**
 *     ```
 *     --- Pending Jobs ---
 *     1. Job [ID=1, File='document.txt', Pages=15, Status=PENDING]
 *     2. Job [ID=2, File='report.pdf', Pages=20, Status=PENDING]
 *     ```
 *     (Or "No pending jobs." if empty)
 * *   **Processing Next Job:**
 *     ```
 *     --- Process Next Job ---
 *     Processing job: 1 ('document.txt')
 *     Job 1 marked as completed.
 *     ```
 * *   **Processing Next Job (when empty):**
 *     ```
 *     --- Process Next Job ---
 *     No pending jobs to process. // Output to System.err
 *     ```
 * *   **Viewing Completed Jobs:**
 *     ```
 *     --- Completed Jobs ---
 *     1. Job [ID=1, File='document.txt', Pages=15, Status=COMPLETED]
 *     ```
 *     (Or "No completed jobs." if empty)
 * *   **Invalid Menu Choice:**
 *     ```
 *     Invalid choice. Please enter a number between 1 and 5. // Output to System.err
 *     ```
 * *   **Exiting:**
 *     ```
 *     Exiting Print Scheduler. Goodbye!
 *     ```
 * *   **Unexpected Error:** If a major unexpected error occurs (e.g., simulated `NullPointerException` in a place it shouldn't happen), the class-wide catch should print:
 *     ```
 *     An unexpected error occurred: <error message> // Output to System.err
 *     <stack trace> // Output to System.err
 *     ```
 * 
 * Your solution should be robust enough to handle common user input errors gracefully and manage the job queues correctly.
 *
 * EXPLANATION:
 * The provided solution implements a simple Print Job Scheduler application demonstrating the required Java concepts and best practices.
 * 
 * **Key Components and Concepts Demonstrated:**
 * 
 * 1.  **`java.util.Queue`**: The `pendingJobs` field is declared as a `Queue<PrintJob>` and initialized with a `LinkedList`. This correctly models the FIFO nature of a print queue, where jobs are processed in the order they are added. The `offer()` method is used to add jobs, and `poll()` is used to retrieve and remove the next job, handling the empty case gracefully by returning `null`.
 * 2.  **`java.util.ArrayList`**: The `completedJobs` field is declared and initialized as an `ArrayList<PrintJob>`. This is suitable for storing completed jobs where order might be relevant (insertion order) and random access (though not explicitly used heavily here) is possible, but primarily serving as a dynamic list to hold items.
 * 3.  **`java.util.List` interface**: In the `viewCompletedJobs()` method, the `completedJobs` ArrayList is assigned to a variable `completedList` of type `List<PrintJob>`. This demonstrates programming to the interface rather than the concrete implementation (`ArrayList`), which is a core OOP principle promoting flexibility.
 * 4.  **`java.util.Scanner`**: The `scanner` field is used throughout the `run()` and `addJob()` methods to read user input from `System.in`. Methods like `nextInt()` and `nextLine()` are used to capture different types of input.
 * 5.  **`switch` statement**: The `switch (choice)` statement in the `run()` method is used to direct the program flow based on the user's numerical menu selection, efficiently handling the different command options.
 * 6.  **`System.err`**: Used specifically for outputting error messages, such as when an invalid menu choice is entered, invalid input is provided for pages, or when attempting to process a job from an empty queue. This separates error output from standard application messages.
 * 7.  **`System.out`**: Used for all standard application output, including displaying the menu, prompts for input, confirmation messages for added/processed jobs, and listing pending or completed jobs.
 * 8.  **Class-wide exception handling with `try-catch`**:
 *     *   A large `try-catch(Exception e)` block wraps the main `while` loop in the `run()` method. This serves as a fallback, catching any unexpected `Exception` that might occur during the program's execution, printing a generic error message and the stack trace to `System.err`.
 *     *   More specific `try-catch(InputMismatchException e)` blocks are used within the `run()` (for menu choice) and `addJob()` (for pages) methods to handle non-integer input from the `Scanner`, printing specific error messages to `System.err` and consuming the invalid input to prevent infinite loops.
 * 9.  **`PrintJob` Class**: Encapsulates the data and behavior related to a single print job (ID, file name, pages, status). It uses a static `AtomicInteger` to ensure unique IDs for each job instance created.
 * 10. **Best Practices**:
 *     *   **Encapsulation**: Fields in `PrintJob` and `PrintScheduler` are `private`. Access is provided via public/private methods as needed.
 *     *   **Meaningful Names**: Variable names (`pendingJobs`, `completedJobs`, `fileName`, `pages`, `jobToProcess`), method names (`addJob`, `processNextJob`, `viewPendingJobs`), and class/enum names (`PrintJob`, `PrintScheduler`, `JobStatus`) are descriptive.
 *     *   **Comments**: Basic comments are included to explain the purpose of classes, methods, and key code sections.
 *     *   **Input Validation**: The `addJob` method explicitly checks if the entered number of pages is positive and loops until valid input is received.
 *     *   **Error Handling**: Specific exceptions (`InputMismatchException`) are caught and handled near the source of the error. Empty queue conditions are checked before attempting to poll. `System.err` is used for error output.
 *     *   **Clean Code Structure**: The code is organized into logical methods, making it readable and maintainable. The `PrintJob` class separates job data/logic from the scheduler logic.
 * 
 * The solution effectively combines these elements to create a functional, albeit simple, command-line application that manages print jobs according to the specified requirements. It demonstrates understanding of core collection types, input handling, flow control, and exception management in Java.
 */

import java.util.Queue;
import java.util.LinkedList; // Common Queue implementation
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException; // For Scanner errors
import java.util.concurrent.atomic.AtomicInteger; // For unique job IDs

// Class representing a single print job
class PrintJob {
    // Static counter for generating unique job IDs
    private static final AtomicInteger jobCounter = new AtomicInteger(0);

    private int id;
    private String fileName;
    private int pages;
    private JobStatus status;

    // Enum to represent the status of a print job
    enum JobStatus {
        PENDING,
        COMPLETED
    }

    /**
     * Constructs a new PrintJob.
     * @param fileName The name of the file to print.
     * @param pages The number of pages in the file.
     */
    public PrintJob(String fileName, int pages) {
        // Increment and get the next unique ID
        this.id = jobCounter.incrementAndGet();
        this.fileName = fileName;
        this.pages = pages;
        this.status = JobStatus.PENDING; // New jobs start as PENDING
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public int getPages() {
        return pages;
    }

    public JobStatus getStatus() {
        return status;
    }

    /**
     * Marks the job's status as COMPLETED.
     */
    public void markCompleted() {
        this.status = JobStatus.COMPLETED;
    }

    /**
     * Provides a string representation of the PrintJob.
     * @return A formatted string describing the job.
     */
    @Override
    public String toString() {
        return "Job [ID=" + id + ", File='" + fileName + "', Pages=" + pages + ", Status=" + status + "]";
    }
}

// Main class for the Print Job Scheduler application
public class PrintScheduler {

    // Queue to hold jobs that are waiting to be printed (FIFO)
    private Queue<PrintJob> pendingJobs;
    // List to hold jobs that have been completed
    private List<PrintJob> completedJobs;
    // Scanner for reading user input
    private Scanner scanner;

    /**
     * Constructs a new PrintScheduler, initializing the job queues and scanner.
     */
    public PrintScheduler() {
        // LinkedList is a common implementation of the Queue interface
        this.pendingJobs = new LinkedList<>();
        // ArrayList is a common implementation of the List interface
        this.completedJobs = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the main application loop and handles user interaction.
     * Includes class-wide exception handling.
     */
    public void run() {
        System.out.println("--- Print Job Scheduler ---");

        // Class-wide exception handling for unexpected errors during runtime
        try {
            int choice = -1; // Initialize choice outside the loop
            // Loop until the user chooses to exit (option 5)
            while (choice != 5) {
                displayMenu();
                System.out.print("Enter your choice: ");

                // Specific exception handling for user input errors within the loop
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    // Use switch statement to handle different menu options
                    switch (choice) {
                        case 1:
                            addJob();
                            break;
                        case 2:
                            processNextJob();
                            break;
                        case 3:
                            viewPendingJobs();
                            break;
                        case 4:
                            viewCompletedJobs();
                            break;
                        case 5:
                            System.out.println("Exiting Print Scheduler. Goodbye!");
                            break;
                        default:
                            // Handle invalid menu numbers
                            System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input for menu choice
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to ensure loop continues
                }
                System.out.println(); // Add a blank line for better readability between interactions
            }
        } catch (Exception e) {
            // Catch any other unexpected runtime exceptions that might occur
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // Print the stack trace to the error stream for debugging
            e.printStackTrace(System.err);
        } finally {
            // Ensure the scanner is closed when the application exits or encounters a major error
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add New Print Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. View Pending Jobs");
        System.out.println("4. View Completed Jobs");
        System.out.println("5. Exit");
    }

    /**
     * Prompts the user for job details, validates input, creates a PrintJob,
     * and adds it to the pending queue.
     */
    private void addJob() {
        System.out.println("--- Add New Print Job ---");
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine(); // Read the whole line for file name

        int pages = -1;
        boolean validPages = false;
        // Loop until a valid positive integer for pages is entered
        while (!validPages) {
            System.out.print("Enter number of pages: ");
            try {
                pages = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                // Validate that the number of pages is positive
                if (pages > 0) {
                    validPages = true; // Input is valid, exit loop
                } else {
                    // Handle non-positive page count
                    System.err.println("Number of pages must be positive.");
                }
            } catch (InputMismatchException e) {
                // Handle non-integer input for pages
                System.err.println("Invalid input. Please enter a valid number for pages.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        // Create the new print job object
        PrintJob newJob = new PrintJob(fileName, pages);
        // Add the job to the pending queue. offer() is generally preferred
        // over add() for queues as it returns false if the operation fails
        // (e.g., bounded queue is full), though LinkedList is unbounded.
        pendingJobs.offer(newJob);
        System.out.println("Print job added: " + newJob);
    }

    /**
     * Processes the next job in the pending queue (if any).
     * Removes the job from pending, marks it completed, and adds it to completed list.
     */
    private void processNextJob() {
        System.out.println("--- Process Next Job ---");
        // poll() retrieves and removes the head of the queue, returning null if empty
        PrintJob jobToProcess = pendingJobs.poll();

        if (jobToProcess != null) {
            // Simulate processing the job
            System.out.println("Processing job: " + jobToProcess.getId() + " ('" + jobToProcess.getFileName() + "')");
            jobToProcess.markCompleted(); // Change status
            completedJobs.add(jobToProcess); // Move to completed list
            System.out.println("Job " + jobToProcess.getId() + " marked as completed.");
        } else {
            // Handle case where the queue is empty
            System.err.println("No pending jobs to process.");
        }
        // No specific exception handling needed here for poll() as it returns null on empty.
        // A catch(Exception e) is already present in run() for unexpected errors.
    }

    /**
     * Displays all jobs currently in the pending queue.
     */
    private void viewPendingJobs() {
        System.out.println("--- Pending Jobs ---");
        if (pendingJobs.isEmpty()) {
            System.out.println("No pending jobs.");
        } else {
            // Iterate through the queue without removing elements
            // The iterator of LinkedList (used here) returns elements in FIFO order
            int count = 1;
            for (PrintJob job : pendingJobs) {
                System.out.println(count + ". " + job);
                count++;
            }
        }
    }

    /**
     * Displays all jobs currently in the completed jobs list.
     * Demonstrates using the List interface type.
     */
    private void viewCompletedJobs() {
        System.out.println("--- Completed Jobs ---");
        // Referencing the ArrayList using the List interface type
        List<PrintJob> completedList = this.completedJobs;

        if (completedList.isEmpty()) {
            System.out.println("No completed jobs.");
        } else {
            // Iterate through the list using a traditional for loop for indexing
            for (int i = 0; i < completedList.size(); i++) {
                System.out.println((i + 1) + ". " + completedList.get(i));
            }
        }
    }

    /**
     * The main entry point of the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        PrintScheduler scheduler = new PrintScheduler();
        scheduler.run(); // Start the scheduler's main loop
    }
}
