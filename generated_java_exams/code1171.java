/*
 * Exam Question #1171
 * Generated on: 2025-05-12 17:34:45
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Advanced Java Programming Exam Task: Print Job Management System**
 * 
 * Design and implement a simple console-based Print Job Management System. The system should allow users to add new print jobs to a queue, process the next job in the queue, and view the list of pending and completed jobs.
 * 
 * Your solution must demonstrate proficiency in core Java concepts and utilize the following specific components:
 * 
 * 1.  **`java.util.Queue`**: To manage the pending print jobs.
 * 2.  **`java.util.ArrayList`**: To store the history of completed print jobs.
 * 3.  **`java.util.List` interface**: Declare the completed jobs collection using this interface.
 * 4.  **`java.util.Scanner`**: To read user input from the console.
 * 5.  **`switch` statement**: To handle the main menu options.
 * 6.  **`System.err`**: To output error messages (e.g., invalid input, queue empty).
 * 7.  **`System.out`**: To output normal messages (menu, prompts, confirmations, job details).
 * 8.  **Class-wide exception handling with `try-catch` blocks**: Implement robust error handling, including specific input validation catches and a broader catch for unexpected issues within the main application loop.
 * 
 * **Requirements:**
 * 
 * *   Create a `PrintJob` class with private fields for `jobId` (int), `jobName` (String), and `pageCount` (int). Include a constructor, getters for all fields, and an appropriate `toString()` method.
 * *   Create a `PrintManager` class that encapsulates the print queue (`Queue<PrintJob>`) and the completed jobs list (`List<PrintJob>`). Use an `ArrayList` for the list implementation.
 * *   The `PrintManager` should have methods:
 *     *   `addJob(String jobName, int pageCount)`: Adds a new job to the queue, assigning a unique auto-incrementing ID. Validate that `pageCount` is positive; throw an `IllegalArgumentException` if not.
 *     *   `processNextJob()`: Removes the job at the front of the queue and adds it to the completed jobs list. Return the processed job, or `null` if the queue is empty. Print an error using `System.err` if the queue is empty.
 *     *   `getPrintQueue()`: Returns the current queue (for viewing).
 *     *   `getCompletedJobs()`: Returns the list of completed jobs (for viewing).
 * *   Create a main class (`PrintSystem`) with a `main` method that:
 *     *   Initializes a `Scanner` and a `PrintManager`.
 *     *   Presents a menu of options to the user (Add Job, Process Next, View Queue, View Completed, Exit).
 *     *   Uses a loop to repeatedly display the menu and process user input until the user chooses to exit.
 *     *   Uses a `switch` statement to handle the user's menu choice.
 *     *   **For 'Add Job'**: Prompt for job name and page count. Use `try-catch` to handle `InputMismatchException` for non-numeric input and catch the `IllegalArgumentException` from `addJob` for invalid page count. Print appropriate messages using `System.err` for errors and `System.out` for success.
 *     *   **For 'Process Next Job'**: Call the `PrintManager` method. The manager handles the empty queue error message via `System.err`.
 *     *   **For 'View Queue' and 'View Completed'**: Retrieve the collections from the manager and iterate through them, printing job details using `System.out`. Print a message if the collection is empty.
 *     *   **For 'Exit'**: Terminate the program gracefully.
 *     *   Handle invalid menu choices using `System.err`.
 *     *   Implement a top-level `try-catch` block around the main loop in the `main` method to catch any unexpected exceptions that might occur, demonstrating class-wide exception handling. Ensure the `Scanner` is closed in a `finally` block.
 * 
 * **Expected Output:**
 * 
 * The system should interact with the user via the console, printing menus, prompts, confirmations, job details, and error messages using the specified streams (`System.out` and `System.err`). The flow should match the menu options and job processing logic.
 * 
 * Example Interaction Snippet:
 * 
 * ```
 * --- Print Job Management System ---
 * Choose an action:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 1
 * 
 * --- Add New Job ---
 * Enter job name: Report
 * Enter number of pages: 15
 * Job added: Job #1 - 'Report' (15 pages)
 * 
 * Choose an action:
 * ... menu ...
 * Enter your choice: 1
 * 
 * --- Add New Job ---
 * Enter job name: Presentation
 * Enter number of pages: -5
 * Error: Page count must be positive.
 * 
 * Choose an action:
 * ... menu ...
 * Enter your choice: 2
 * 
 * --- Processing Next Job ---
 * Job processed: Job #1 - 'Report' (15 pages)
 * 
 * Choose an action:
 * ... menu ...
 * Enter your choice: 2
 * 
 * --- Processing Next Job ---
 * Error: Print queue is empty. No jobs to process.
 * 
 * Choose an action:
 * ... menu ...
 * Enter your choice: 4
 * 
 * --- Completed Jobs ---
 * 1. Job #1 - 'Report' (15 pages)
 * 
 * Choose an action:
 * ... menu ...
 * Enter your choice: 6
 * Invalid choice. Please enter a number between 1 and 5.
 * 
 * Choose an action:
 * ... menu ...
 * Enter your choice: abc
 * Invalid input. Please enter a number.
 * 
 * Choose an action:
 * ... menu ...
 * Enter your choice: 5
 * Exiting Print Job Management System. Goodbye!
 * Scanner closed.
 * ```
 *
 * EXPLANATION:
 * This solution implements a `Print Job Management System` using the required Java components and best practices.
 * 
 * 1.  **`PrintJob` Class**: This simple class encapsulates the data for a single print job (`jobId`, `jobName`, `pageCount`). It follows encapsulation principles with private fields and public getters. The `toString()` method provides a convenient way to display job information.
 * 
 * 2.  **`PrintManager` Class**: This class acts as the core logic handler.
 *     *   It uses a `java.util.Queue<PrintJob>` (`printQueue`) to store jobs waiting to be processed. A `LinkedList` is used as the concrete implementation because it efficiently supports queue operations (`add`, `poll`).
 *     *   It uses a `java.util.List<PrintJob>` (`completedJobs`) to store jobs that have finished processing. An `ArrayList` is used as the concrete implementation, which is suitable for storing and iterating over a history. The variable is declared using the `List` interface, promoting good design practice by programming to the interface.
 *     *   The `addJob` method demonstrates input validation by throwing an `IllegalArgumentException` if the page count is not positive. It assigns a unique ID using a simple counter (`nextJobId`).
 *     *   The `processNextJob` method uses `queue.poll()` to retrieve and remove the head of the queue. It checks if the result is `null` (meaning the queue was empty) and prints an error message using `System.err`. If successful, it adds the job to the `completedJobs` list.
 *     *   `getPrintQueue` and `getCompletedJobs` provide access to the internal collections for viewing.
 * 
 * 3.  **`PrintSystem` Class (Main)**: This class handles the user interface and application flow.
 *     *   A `java.util.Scanner` is used to read input from `System.in`.
 *     *   A `PrintManager` instance is created to manage the jobs.
 *     *   A `while` loop runs the main application cycle.
 *     *   Inside the loop, a menu is printed using `System.out`.
 *     *   A `switch` statement is used to direct the program flow based on the user's numeric choice.
 *     *   **`try-catch` blocks**:
 *         *   A `try-catch (InputMismatchException)` block specifically handles cases where the user enters non-numeric input when a number is expected (for menu choice or page count). This prevents the program from crashing and prompts the user to try again. `scanner.nextLine()` is crucial within the catch block to consume the invalid input and prevent an infinite loop.
 *         *   The 'Add Job' case includes a `try-catch (IllegalArgumentException)` to catch the validation error thrown by `PrintManager.addJob` when a non-positive page count is entered. Error messages for both `InputMismatchException` and `IllegalArgumentException` are printed using `System.err`.
 *         *   A top-level `try-catch (Exception)` block wraps the main `while` loop. This demonstrates "class-wide" or application-level exception handling, catching any unexpected runtime exceptions that might occur within the loop's logic and weren't specifically caught lower down. It prints a general error message and the stack trace using `System.err`.
 *     *   **`System.err` vs. `System.out`**: `System.err` is used exclusively for error messages (invalid input, empty queue, invalid menu choice, unexpected errors), while `System.out` is used for all normal program output (menu, prompts, confirmations, job listings).
 *     *   **`finally` block**: A `finally` block is used in the `main` method to ensure that the `scanner.close()` method is called, releasing the system resource, regardless of whether the `try` block completes normally or an exception is caught.
 * 
 * The solution combines object-oriented design (separate classes for job and manager), collection management (`Queue` for processing order, `List/ArrayList` for history), user interaction (`Scanner`, `System.out`), flow control (`switch`, `while`), and robust error handling (`try-catch`, `System.err`, input validation). It effectively demonstrates the required advanced Java concepts in a practical scenario.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a print job with an ID, name, and page count.
 */
class PrintJob {
    private int jobId;
    private String jobName;
    private int pageCount;

    /**
     * Constructs a new PrintJob.
     * @param jobId The unique ID for the job.
     * @param jobName The name of the job.
     * @param pageCount The number of pages in the job.
     */
    public PrintJob(int jobId, String jobName, int pageCount) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.pageCount = pageCount;
    }

    // Getters for accessing private fields
    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public int getPageCount() {
        return pageCount;
    }

    /**
     * Returns a string representation of the print job.
     * @return Formatted string describing the job.
     */
    @Override
    public String toString() {
        return "Job #" + jobId + " - '" + jobName + "' (" + pageCount + " pages)";
    }
}

/**
 * Manages the queue of pending print jobs and a list of completed jobs.
 */
class PrintManager {
    private Queue<PrintJob> printQueue; // Queue for pending jobs
    private List<PrintJob> completedJobs; // List for completed jobs
    private int nextJobId; // Counter for assigning unique job IDs

    /**
     * Constructs a new PrintManager, initializing the queue and list.
     */
    public PrintManager() {
        // LinkedList is a common implementation of the Queue interface
        this.printQueue = new LinkedList<>();
        // ArrayList is a common implementation of the List interface
        this.completedJobs = new ArrayList<>();
        this.nextJobId = 1; // Start job IDs from 1
    }

    /**
     * Adds a new print job to the queue.
     * Assigns a unique ID and increments the counter.
     * @param jobName The name of the job.
     * @param pageCount The number of pages. Must be positive.
     * @return The assigned job ID.
     * @throws IllegalArgumentException if pageCount is not positive.
     */
    public int addJob(String jobName, int pageCount) {
        if (pageCount <= 0) {
            // Use IllegalArgumentException for invalid arguments
            throw new IllegalArgumentException("Page count must be positive.");
        }
        PrintJob newJob = new PrintJob(nextJobId, jobName, pageCount);
        printQueue.add(newJob); // Add job to the end of the queue
        System.out.println("Job added: " + newJob); // Confirmation output
        return nextJobId++; // Increment ID for the next job
    }

    /**
     * Processes (removes) the next job from the front of the queue.
     * Adds the processed job to the completed jobs list.
     * @return The processed PrintJob, or null if the queue was empty.
     */
    public PrintJob processNextJob() {
        PrintJob processedJob = printQueue.poll(); // poll() removes and returns the head, or null if empty
        if (processedJob != null) {
            completedJobs.add(processedJob); // Add to the list of completed jobs
            System.out.println("Job processed: " + processedJob); // Confirmation output
        } else {
            // Use System.err for error message when queue is empty
            System.err.println("Error: Print queue is empty. No jobs to process.");
        }
        return processedJob;
    }

    /**
     * Gets the current print queue.
     * @return The Queue of PrintJob objects currently waiting.
     */
    public Queue<PrintJob> getPrintQueue() {
        return printQueue; // Return the queue object
    }

    /**
     * Gets the list of completed print jobs.
     * @return The List of PrintJob objects that have been processed.
     */
    public List<PrintJob> getCompletedJobs() {
        return completedJobs; // Return the list object
    }
}

/**
 * Main class for the Print Job Management System.
 * Handles user interaction and orchestrates the PrintManager.
 */
public class PrintSystem {

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\n--- Print Job Management System ---");
        System.out.println("Choose an action:");
        System.out.println("1. Add New Print Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. View Print Queue");
        System.out.println("4. View Completed Jobs");
        System.out.println("5. Exit");
    }

    /**
     * The main entry point for the Print Job Management System.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintManager manager = new PrintManager();
        boolean running = true;

        // Class-wide exception handling: Catching unexpected errors in the main loop
        try {
            while (running) {
                printMenu();
                int choice = -1; // Default invalid choice

                // Specific try-catch for reading menu choice
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                } catch (InputMismatchException e) {
                    // Handle non-integer input for menu choice
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input line to prevent infinite loop
                    continue; // Skip the rest of the loop iteration and show menu again
                }

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1: // Add Job
                        System.out.println("\n--- Add New Job ---");
                        System.out.print("Enter job name: ");
                        String jobName = scanner.nextLine();

                        // Specific try-catch for reading page count
                        try {
                            System.out.print("Enter number of pages: ");
                            int pageCount = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            // Call manager method, which might throw IllegalArgumentException
                            manager.addJob(jobName, pageCount);

                        } catch (InputMismatchException e) {
                            // Handle non-integer input for page count
                            System.err.println("Error: Invalid input for page count. Please enter a number.");
                            scanner.nextLine(); // Consume invalid input
                        } catch (IllegalArgumentException e) {
                            // Handle validation error from PrintManager
                            System.err.println("Error: " + e.getMessage());
                        } catch (Exception e) {
                            // Catch any other unexpected errors during job adding
                            System.err.println("An unexpected error occurred while adding job: " + e.getMessage());
                            // e.printStackTrace(); // Uncomment for debugging
                        }
                        break;

                    case 2: // Process Next Job
                        System.out.println("\n--- Processing Next Job ---");
                        // PrintManager.processNextJob() already prints messages including errors via System.err
                        manager.processNextJob();
                        break;

                    case 3: // View Queue
                        System.out.println("\n--- Current Print Queue ---");
                        Queue<PrintJob> queue = manager.getPrintQueue();
                        if (queue.isEmpty()) {
                            System.out.println("The print queue is empty.");
                        } else {
                            // Iterate through the queue without removing elements
                            int i = 1;
                            for (PrintJob job : queue) {
                                System.out.println(i++ + ". " + job);
                            }
                        }
                        break;

                    case 4: // View Completed Jobs
                        System.out.println("\n--- Completed Jobs ---");
                        List<PrintJob> completed = manager.getCompletedJobs();
                        if (completed.isEmpty()) {
                            System.out.println("No jobs have been completed yet.");
                        } else {
                            // Iterate through the list
                            int i = 1;
                            for (PrintJob job : completed) {
                                System.out.println(i++ + ". " + job);
                            }
                        }
                        break;

                    case 5: // Exit
                        System.out.println("Exiting Print Job Management System. Goodbye!");
                        running = false; // Set flag to exit loop
                        break;

                    default: // Handle invalid menu numbers
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
            }
        } catch (Exception mainLoopException) {
            // This broad catch handles any uncaught exceptions that might occur
            // within the main application logic loop, providing a final safety net.
            System.err.println("\nAn unrecoverable error occurred in the system:");
            mainLoopException.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure the scanner resource is closed regardless of how the loop exits
            scanner.close();
            System.out.println("Scanner closed."); // Confirmation
        }
    }
}
