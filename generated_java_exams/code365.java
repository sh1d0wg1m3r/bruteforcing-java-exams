/*
 * Exam Question #365
 * Generated on: 2025-05-11 23:00:51
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Advanced Print Job Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a command-line application to manage a simple print job queue. The system should allow users to add new print jobs, process the next job in the queue, view waiting jobs, and view completed/cancelled jobs. The system must be robust, handling user input errors and operational issues gracefully.
 * 
 * **Requirements:**
 * 
 * Implement a Java application that meets the following criteria:
 * 
 * 1.  **Core Functionality:**
 *     *   Add a new print job to a waiting queue. Each job should have a unique ID (sequential), a file name, and the number of pages. New jobs are added to the end of the waiting queue.
 *     *   Process the next print job: Remove the job from the front of the waiting queue and simulate its completion by moving it to a list of finished jobs.
 *     *   List all jobs currently waiting in the queue.
 *     *   List all jobs that have been finished (processed) or potentially cancelled (for simplicity, we'll just list 'finished' jobs in this task).
 *     *   Exit the application.
 * 
 * 2.  **Required Java Components:** Your solution *must* utilize **ALL** of the following Java components:
 *     *   `java.util.Queue` (for the waiting print jobs)
 *     *   `java.util.ArrayList` (used as the implementation for the list of finished jobs)
 *     *   `java.util.List` (declare the finished jobs collection using this interface)
 *     *   `java.util.Scanner` (for reading user input from the console)
 *     *   `switch` statement (for handling user menu choices)
 *     *   `System.err` (for printing error messages)
 *     *   `System.out` (for printing normal output like menus, job details, confirmations)
 *     *   Class-wide exception handling using `try-catch` blocks (specifically, handle potential issues like invalid input and trying to process an empty queue).
 * 
 * 3.  **Best Practices:**
 *     *   Implement proper encapsulation (private fields, public methods) for your classes.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments (especially Javadoc for classes and methods) and documentation.
 *     *   Perform input validation (e.g., number of pages must be positive).
 *     *   Implement robust error handling for operational issues (e.g., attempting to process a job when the queue is empty) and user input errors.
 *     *   Maintain a clean code structure with separate classes for different concerns (e.g., a `PrintJob` class and a `PrintManager` class).
 * 
 * **Implementation Details:**
 * 
 * *   Create a `PrintJob` class to represent a single print job.
 * *   Create a `PrintManager` class to manage the queue and list of jobs. This class should contain the `Queue` and `List` instances.
 * *   Create a main application class (e.g., `PrintSystemApp`) with a `main` method that interacts with the user via `Scanner` and uses a `switch` statement to call methods on the `PrintManager`.
 * *   The main application loop should include a `try-catch` block to handle potential exceptions that might occur during execution. Specific operations (like reading integer input or processing an empty queue) should also have appropriate error handling using `try-catch` and `System.err`.
 * *   When processing the next job, if the queue is empty, print an error message to `System.err` and do not crash.
 * *   When adding a job, if the page count is invalid (e.g., non-positive), print an error message to `System.err` and do not add the job.
 * *   Handle non-integer input gracefully when the system expects a number (e.g., for menu choice or page count).
 * 
 * **Expected Output:**
 * 
 * The application should present a menu to the user. Based on user input, it should perform the requested action and provide feedback via `System.out` or `System.err`.
 * 
 * ```
 * --- Print Job Management System ---
 * 1. Add New Job
 * 2. Process Next Job
 * 3. List Waiting Jobs
 * 4. List Finished Jobs
 * 5. Exit
 * Enter your choice: [user input]
 * 
 * // Example interactions:
 * 
 * // Adding a job
 * Enter file name: document.pdf
 * Enter number of pages: 15
 * Job added: Job ID 1 - document.pdf (15 pages)
 * 
 * // Adding a job with invalid pages
 * Enter file name: report.docx
 * Enter number of pages: -5
 * Error: Number of pages must be positive. Job not added.
 * 
 * // Processing a job
 * Processing job: Job ID 1 - document.pdf (15 pages)
 * Job ID 1 finished.
 * 
 * // Processing with empty queue
 * Processing next job...
 * Error: No jobs waiting in the queue.
 * 
 * // Listing waiting jobs
 * --- Waiting Jobs ---
 * [List of jobs or "No jobs waiting."]
 * 
 * // Listing finished jobs
 * --- Finished Jobs ---
 * [List of jobs or "No jobs finished."]
 * ```
 * 
 * Your code should be well-structured, easy to read, and correctly implement all specified requirements.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`.
 * *   Effective use of `try-catch` for error handling (input validation, operational errors, general exceptions).
 * *   Adherence to object-oriented principles (encapsulation).
 * *   Code clarity, readability, and documentation.
 * *   Correct implementation of core functionality and error handling logic.
 * 
 * Good luck!
 *
 * EXPLANATION:
 * This solution implements the Print Job Management System as required, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **`PrintJob` Class:**
 *     *   Encapsulates the data for a single print job (`jobId`, `fileName`, `pageCount`).
 *     *   Uses a static counter (`nextJobId`) to ensure unique IDs for each job instance.
 *     *   The constructor includes input validation for `pageCount`, throwing an `IllegalArgumentException` if it's not positive. This is a good practice for validating data upon object creation.
 *     *   Provides public getter methods for accessing job details.
 *     *   Overrides `toString()` for easy printing of job information.
 * 
 * 2.  **`PrintManager` Class:**
 *     *   Manages the collections of jobs:
 *         *   `waitingQueue`: Declared as `Queue<PrintJob>` and instantiated as `LinkedList<PrintJob>`. `LinkedList` is a common implementation for `Queue` when you need FIFO behavior. `Queue` methods like `offer()` (add) and `poll()` (retrieve and remove) are used.
 *         *   `finishedJobs`: Declared as `List<PrintJob>` and instantiated as `ArrayList<PrintJob>`. `ArrayList` is a standard resizable array implementation of the `List` interface, suitable for storing completed items.
 *     *   Provides methods for adding a job (`addJob`), processing the next job (`processNextJob`), and retrieving lists of jobs (`getWaitingJobs`, `getFinishedJobs`).
 *     *   `processNextJob()` uses `waitingQueue.poll()`. If `poll()` returns `null` (meaning the queue was empty), it throws an `IllegalStateException`, which is then caught in the `main` method.
 *     *   `getWaitingJobs()` and `getFinishedJobs()` return *new* `ArrayList` instances containing the current jobs. This is a defensive programming technique to prevent external code from modifying the internal state of the `PrintManager`'s collections directly.
 * 
 * 3.  **`PrintSystemApp` Class (Main Application):**
 *     *   Contains the `main` method where execution begins.
 *     *   Initializes `PrintManager` and `Scanner`.
 *     *   Uses a `while` loop (`running`) to keep the application active until the user chooses to exit.
 *     *   **`Scanner`:** Used to read user input for menu choices, file names, and page counts.
 *     *   **`switch` statement:** Controls the main application flow based on the integer choice entered by the user. Each case corresponds to a menu option, calling the appropriate `PrintManager` method or handling the exit logic.
 *     *   **`try-catch` Blocks:**
 *         *   A large `try-catch (Exception e)` block wraps the main `while` loop. This serves as a class-wide handler for any unexpected exceptions that might propagate up, preventing the application from crashing abruptly. It prints the error to `System.err` and includes a stack trace for debugging.
 *         *   Specific `try-catch` blocks are used for input validation:
 *             *   Around `scanner.nextInt()` for the menu choice: Catches `InputMismatchException` if the user enters non-integer input. It prints an error to `System.err`, consumes the invalid input using `scanner.next()`, and continues the loop.
 *             *   Around `scanner.nextInt()` for the page count: Also catches `InputMismatchException`.
 *         *   A `try-catch` block is used when creating a `PrintJob` to catch the `IllegalArgumentException` thrown by the `PrintJob` constructor if the page count is invalid. This error is printed to `System.err`.
 *         *   A `try-catch` block surrounds the call to `manager.processNextJob()` in case 2. It catches the `IllegalStateException` thrown by the `PrintManager` when the queue is empty and prints a user-friendly error message to `System.err`.
 *     *   **`System.out`:** Used for printing the menu, confirmations of job additions, processing messages, and lists of jobs.
 *     *   **`System.err`:** Used exclusively for printing error messages related to invalid input or operational failures (like processing an empty queue).
 *     *   `scanner.nextLine()` calls are strategically placed after `scanner.nextInt()` to consume the leftover newline character, preventing issues with subsequent `scanner.nextLine()` calls.
 *     *   A `finally` block is used within the main `try-catch` to ensure the `scanner` is closed when the application exits or an unexpected error occurs.
 * 
 * This solution effectively integrates the required Java components within a practical scenario, demonstrating proper object-oriented design, input validation, and comprehensive error handling using `try-catch` blocks targeting different levels of potential failure.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single print job with details like ID, file name, and page count.
 */
class PrintJob {
    private static int nextJobId = 1; // Static counter for unique job IDs

    private final int jobId;
    private final String fileName;
    private final int pageCount;

    /**
     * Constructs a new PrintJob.
     *
     * @param fileName The name of the file to print.
     * @param pageCount The number of pages in the file.
     * @throws IllegalArgumentException if pageCount is not positive.
     */
    public PrintJob(String fileName, int pageCount) {
        if (pageCount <= 0) {
            throw new IllegalArgumentException("Number of pages must be positive.");
        }
        this.jobId = nextJobId++;
        this.fileName = fileName;
        this.pageCount = pageCount;
    }

    // --- Getters ---

    /**
     * Gets the unique ID of the print job.
     * @return The job ID.
     */
    public int getJobId() {
        return jobId;
    }

    /**
     * Gets the file name associated with the print job.
     * @return The file name.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Gets the number of pages in the print job.
     * @return The page count.
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Provides a string representation of the PrintJob.
     * @return A formatted string describing the job.
     */
    @Override
    public String toString() {
        return "Job ID " + jobId + " - " + fileName + " (" + pageCount + " pages)";
    }
}

/**
 * Manages the queue of waiting print jobs and a list of finished jobs.
 */
class PrintManager {
    // Use Queue interface, implemented by LinkedList for FIFO behavior
    private final Queue<PrintJob> waitingQueue;

    // Use List interface, implemented by ArrayList for dynamic storage of finished jobs
    private final List<PrintJob> finishedJobs;

    /**
     * Constructs a new PrintManager with empty queues/lists.
     */
    public PrintManager() {
        this.waitingQueue = new LinkedList<>(); // LinkedList implements Queue
        this.finishedJobs = new ArrayList<>(); // ArrayList implements List
    }

    /**
     * Adds a new print job to the waiting queue.
     *
     * @param job The PrintJob to add.
     */
    public void addJob(PrintJob job) {
        waitingQueue.offer(job); // offer() is preferred over add() as it doesn't throw exception if queue is full (though LinkedList won't be full)
        System.out.println("Job added: " + job);
    }

    /**
     * Processes the next job in the waiting queue.
     * Removes the job from the queue and adds it to the finished jobs list.
     *
     * @return The processed PrintJob.
     * @throws IllegalStateException if the waiting queue is empty.
     */
    public PrintJob processNextJob() {
        PrintJob job = waitingQueue.poll(); // poll() retrieves and removes the head of the queue, returns null if empty
        if (job == null) {
            throw new IllegalStateException("No jobs waiting in the queue.");
        }
        System.out.println("Processing job: " + job);
        finishedJobs.add(job);
        System.out.println(job.getJobId() + " finished.");
        return job;
    }

    /**
     * Gets an unmodifiable list of jobs currently waiting in the queue.
     *
     * @return A List of waiting PrintJobs.
     */
    public List<PrintJob> getWaitingJobs() {
        // Return a copy or unmodifiable list to prevent external modification
        return new ArrayList<>(waitingQueue); // Create a new ArrayList from the queue elements
    }

    /**
     * Gets an unmodifiable list of jobs that have been finished.
     *
     * @return A List of finished PrintJobs.
     */
    public List<PrintJob> getFinishedJobs() {
        // Return an unmodifiable list
        return new ArrayList<>(finishedJobs); // Return a copy
    }

    /**
     * Checks if the waiting queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isWaitingQueueEmpty() {
        return waitingQueue.isEmpty();
    }

    /**
     * Checks if the finished jobs list is empty.
     * @return true if the list is empty, false otherwise.
     */
    public boolean isFinishedJobsEmpty() {
        return finishedJobs.isEmpty();
    }
}

/**
 * Main application class for the Print Job Management System.
 * Handles user interaction and orchestrates the PrintManager.
 */
public class PrintSystemApp {

    public static void main(String[] args) {
        PrintManager manager = new PrintManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide try-catch for general unexpected errors during execution
        try {
            while (running) {
                printMenu();
                System.out.print("Enter your choice: ");

                int choice = -1;
                // try-catch for reading integer choice
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop and show menu again
                } finally {
                    scanner.nextLine(); // Consume the newline character left by nextInt()
                }


                // Switch statement for flow control based on user choice
                switch (choice) {
                    case 1: // Add New Job
                        System.out.print("Enter file name: ");
                        String fileName = scanner.nextLine();
                        int pageCount = -1;
                        System.out.print("Enter number of pages: ");

                        // try-catch for reading integer page count
                        try {
                            pageCount = scanner.nextInt();
                            // Input validation using the PrintJob constructor's exception
                            PrintJob newJob = new PrintJob(fileName, pageCount);
                            manager.addJob(newJob);
                        } catch (InputMismatchException e) {
                            System.err.println("Error: Invalid input for page count. Please enter a number.");
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error: " + e.getMessage() + " Job not added.");
                        } finally {
                             scanner.nextLine(); // Consume the newline character
                        }
                        break;

                    case 2: // Process Next Job
                        System.out.println("Processing next job...");
                        // try-catch for processing job (handles empty queue)
                        try {
                            manager.processNextJob();
                        } catch (IllegalStateException e) {
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;

                    case 3: // List Waiting Jobs
                        System.out.println("\n--- Waiting Jobs ---");
                        List<PrintJob> waiting = manager.getWaitingJobs();
                        if (waiting.isEmpty()) {
                            System.out.println("No jobs waiting.");
                        } else {
                            for (PrintJob job : waiting) {
                                System.out.println(job);
                            }
                        }
                        System.out.println("--------------------");
                        break;

                    case 4: // List Finished Jobs
                        System.out.println("\n--- Finished Jobs ---");
                        List<PrintJob> finished = manager.getFinishedJobs();
                        if (finished.isEmpty()) {
                            System.out.println("No jobs finished.");
                        } else {
                            for (PrintJob job : finished) {
                                System.out.println(job);
                            }
                        }
                        System.out.println("---------------------");
                        break;

                    case 5: // Exit
                        System.out.println("Exiting Print Job Management System. Goodbye!");
                        running = false;
                        break;

                    default: // Invalid choice
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
            // Ensure scanner is closed
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\n--- Print Job Management System ---");
        System.out.println("1. Add New Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. List Waiting Jobs");
        System.out.println("4. List Finished Jobs");
        System.out.println("5. Exit");
    }
}
