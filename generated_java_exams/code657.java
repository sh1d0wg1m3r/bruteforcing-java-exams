/*
 * Exam Question #657
 * Generated on: 2025-05-12 16:20:54
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Java Programming Exam Task: Print Job Management System**
 * 
 * **Problem Description:**
 * 
 * Design and implement a simple console-based Print Job Management system. The system should simulate submitting print jobs to a queue, processing them one by one, and keeping a record of completed jobs. The system should interact with the user through a command-line interface.
 * 
 * **Requirements:**
 * 
 * 1.  **PrintJob Class:** Create a class named `PrintJob` to represent a single print job. It should have:
 *     *   A unique integer `jobId`.
 *     *   A `String` `fileName`.
 *     *   An integer `pages`.
 *     *   A constructor to initialize these fields.
 *     *   Getter methods for all fields.
 *     *   A meaningful `toString()` method for displaying job details.
 * 
 * 2.  **PrintManager Class:** Create a class named `PrintManager` to manage the print jobs. It should contain:
 *     *   A `java.util.Queue<PrintJob>` to hold jobs waiting to be processed (pending jobs).
 *     *   A `java.util.List<PrintJob>` (implemented using `java.util.ArrayList`) to store jobs that have been completed.
 *     *   A mechanism to generate unique `jobId` values (e.g., a counter).
 *     *   Methods for the following operations:
 *         *   `submitJob(String fileName, int pages)`: Creates a new `PrintJob` with a unique ID and adds it to the pending queue. Should validate that `pages` is a positive integer.
 *         *   `processNextJob()`: Removes the next job from the pending queue and adds it to the completed list. Should handle the case where the queue is empty.
 *         *   `viewPendingJobs()`: Displays all jobs currently in the pending queue without removing them.
 *         *   `viewCompletedJobs()`: Displays all jobs in the completed list.
 *         *   `clearCompletedJobs()`: Clears the list of completed jobs.
 * 
 * 3.  **Main Execution:** Implement a `main` method (within `PrintManager` or a separate class) that:
 *     *   Uses `java.util.Scanner` to read user commands from the console.
 *     *   Implements a command loop that continuously prompts the user for input until an "exit" command is given.
 *     *   Uses a `switch` statement to handle different commands.
 *     *   Calls the appropriate methods of the `PrintManager` based on the user command.
 * 
 * 4.  **User Commands:** Support the following commands (case-insensitive for the command name):
 *     *   `submit <fileName> <pages>`: e.g., `submit document.pdf 10`
 *     *   `process`: Processes the next job.
 *     *   `view_pending`: Lists pending jobs.
 *     *   `view_completed`: Lists completed jobs.
 *     *   `clear_completed`: Clears completed jobs.
 *     *   `exit`: Terminates the program.
 * 
 * 5.  **Output and Error Handling:**
 *     *   Use `System.out` for normal output, prompts, and displaying job lists.
 *     *   Use `System.err` to display error messages (e.g., invalid command format, invalid page number, attempting to process from an empty queue).
 *     *   Implement input validation (e.g., pages must be > 0).
 *     *   Implement class-wide exception handling using `try-catch` blocks to make the program robust against potential runtime errors, especially around user input parsing (`Scanner`) and operations that might fail (like processing an empty queue, although this specific case can be handled with a check, wrapping operations in try-catch demonstrates robustness). A `try-catch` block should wrap the main command processing loop to catch unexpected errors.
 * 
 * 6.  **Best Practices:**
 *     *   Follow proper encapsulation (private fields, public methods).
 *     *   Use meaningful names for classes, variables, and methods.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Structure the code cleanly.
 * 
 * **Expected Output Examples:**
 * 
 * ```
 * Enter command: submit report.docx 5
 * Job 1 (report.docx, 5 pages) submitted.
 * 
 * Enter command: submit image.png 1
 * Job 2 (image.png, 1 pages) submitted.
 * 
 * Enter command: view_pending
 * Pending Jobs:
 * Job 1 (report.docx, 5 pages)
 * Job 2 (image.png, 1 pages)
 * 
 * Enter command: process
 * Processing Job 1 (report.docx, 5 pages)... Completed.
 * 
 * Enter command: view_pending
 * Pending Jobs:
 * Job 2 (image.png, 1 pages)
 * 
 * Enter command: view_completed
 * Completed Jobs:
 * Job 1 (report.docx, 5 pages)
 * 
 * Enter command: process
 * Processing Job 2 (image.png, 1 pages)... Completed.
 * 
 * Enter command: process
 * Error: No pending jobs to process.
 * 
 * Enter command: view_completed
 * Completed Jobs:
 * Job 1 (report.docx, 5 pages)
 * Job 2 (image.png, 1 pages)
 * 
 * Enter command: clear_completed
 * Completed jobs list cleared.
 * 
 * Enter command: view_completed
 * Completed Jobs:
 * (none)
 * 
 * Enter command: submit test.txt -3
 * Error: Pages must be a positive integer.
 * 
 * Enter command: submit bad_command
 * Error: Invalid submit command format. Use 'submit <fileName> <pages>'.
 * 
 * Enter command: unknown_command
 * Error: Unknown command.
 * 
 * Enter command: exit
 * Exiting Print Job Manager.
 * ```
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`.
 * *   Correct implementation of `PrintJob` and `PrintManager` classes.
 * *   Accurate handling of user commands and system logic.
 * *   Effective input validation and error reporting using `System.err`.
 * *   Robustness provided by `try-catch` exception handling.
 * *   Adherence to best practices (encapsulation, naming, comments, structure).
 *
 * EXPLANATION:
 * The provided solution implements a simple console-based Print Job Management System, fulfilling all the requirements of the exam task.
 * 
 * 1.  **PrintJob Class:** This class is a simple Plain Old Java Object (POJO) that encapsulates the data for a single print job: `jobId`, `fileName`, and `pages`. It uses `private final` fields for encapsulation and provides public getter methods. The `toString()` method is overridden for easy printing of job details.
 * 
 * 2.  **PrintManager Class:** This is the core class managing the print jobs.
 *     *   It uses a `java.util.Queue<PrintJob>` (`pendingJobs`) implemented by `java.util.LinkedList`. The `Queue` naturally supports the FIFO (First-In, First-Out) behavior required for a job queue (`offer` to add, `poll` to remove from the head).
 *     *   It uses a `java.util.List<PrintJob>` (`completedJobs`) implemented by `java.util.ArrayList`. The `List` is suitable for storing completed jobs in the order they finished and allows easy iteration for viewing.
 *     *   A `nextJobId` counter ensures each submitted job gets a unique ID.
 *     *   Methods like `submitJob`, `processNextJob`, `viewPendingJobs`, `viewCompletedJobs`, and `clearCompletedJobs` implement the required system operations, demonstrating proper encapsulation by operating on the private collection fields.
 *     *   Input validation for `pages` is performed within `submitJob`.
 * 
 * 3.  **Main Execution (`main` method):**
 *     *   The `main` method orchestrates the system. It creates a `PrintManager` instance and a `java.util.Scanner` to read user input.
 *     *   A `while(true)` loop runs continuously until the "exit" command breaks it.
 *     *   User input lines are read, trimmed, and split to extract the command and its arguments.
 *     *   A `switch` statement is used to dispatch control based on the command string, calling the appropriate `PrintManager` methods. This demonstrates the use of `switch` for flow control based on string input.
 * 
 * 4.  **User Commands:** The `switch` statement correctly handles the specified commands (`submit`, `process`, `view_pending`, `view_completed`, `clear_completed`, `exit`), parsing arguments where necessary (`submit`). Basic validation for the number of arguments for each command is included.
 * 
 * 5.  **Output and Error Handling:**
 *     *   `System.out.println()` is used for displaying prompts, successful actions (job submitted, processed, cleared), and lists of jobs.
 *     *   `System.err.println()` is used for reporting errors, such as invalid command formats, invalid page numbers during submission, or attempting to process from an empty queue. This correctly directs error output to the standard error stream.
 *     *   **Class-wide exception handling:** A `try-catch(Exception e)` block wraps the entire `while` loop in the `main` method. This provides a top-level safety net to catch any unexpected runtime exceptions that might occur during the execution of commands within the loop.
 *     *   **Specific exception handling:** A `try-catch(NumberFormatException e)` is used specifically within the "submit" command handling to gracefully deal with cases where the user provides non-integer input for the `pages` argument.
 *     *   The `processNextJob` method explicitly checks if the `pendingJobs` queue is empty (`poll()` returns `null`) before attempting to process, preventing a `NullPointerException` and using `System.err` to report the specific error condition.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation is maintained with private fields and public methods in `PrintJob` and `PrintManager`.
 *     *   Variable and method names are descriptive (e.g., `pendingJobs`, `processNextJob`, `fileName`).
 *     *   Basic comments and Javadoc-style comments are included to explain the purpose of classes, fields, and methods.
 *     *   The code is structured logically into two classes, separating data (`PrintJob`) from management logic (`PrintManager`).
 * 
 * This solution effectively demonstrates the required Java components and best practices within a practical scenario, providing a solid foundation for evaluating a student's understanding of these concepts.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException; // Although reading lines and parsing is safer

/**
 * Represents a single print job with a unique ID, file name, and number of pages.
 */
class PrintJob {
    private final int jobId;
    private final String fileName;
    private final int pages;

    /**
     * Constructs a new PrintJob.
     * @param jobId The unique identifier for the job.
     * @param fileName The name of the file to print.
     * @param pages The number of pages in the file.
     */
    public PrintJob(int jobId, String fileName, int pages) {
        this.jobId = jobId;
        this.fileName = fileName;
        this.pages = pages;
    }

    /**
     * Gets the job ID.
     * @return The job ID.
     */
    public int getJobId() {
        return jobId;
    }

    /**
     * Gets the file name.
     * @return The file name.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Gets the number of pages.
     * @return The number of pages.
     */
    public int getPages() {
        return pages;
    }

    /**
     * Returns a string representation of the PrintJob.
     * @return A formatted string describing the print job.
     */
    @Override
    public String toString() {
        return "Job " + jobId + " (" + fileName + ", " + pages + " pages)";
    }
}

/**
 * Manages a queue of pending print jobs and a list of completed jobs.
 */
public class PrintManager {
    // Queue for jobs waiting to be processed (FIFO)
    private final Queue<PrintJob> pendingJobs;
    // List for jobs that have been completed
    private final List<PrintJob> completedJobs;
    // Counter for generating unique job IDs
    private int nextJobId;

    /**
     * Constructs a new PrintManager.
     * Initializes the pending and completed job collections and the job ID counter.
     */
    public PrintManager() {
        // Using LinkedList as an implementation of Queue
        this.pendingJobs = new LinkedList<>();
        // Using ArrayList as an implementation of List
        this.completedJobs = new ArrayList<>();
        this.nextJobId = 1; // Start job IDs from 1
    }

    /**
     * Submits a new print job to the pending queue.
     * Validates the number of pages.
     * @param fileName The name of the file.
     * @param pages The number of pages.
     * @return true if the job was submitted successfully, false otherwise.
     */
    public boolean submitJob(String fileName, int pages) {
        if (pages <= 0) {
            System.err.println("Error: Pages must be a positive integer.");
            return false;
        }
        PrintJob newJob = new PrintJob(nextJobId++, fileName, pages);
        pendingJobs.offer(newJob); // offer is generally preferred over add for queues as it returns false on failure
        System.out.println(newJob + " submitted.");
        return true;
    }

    /**
     * Processes the next job from the pending queue, moving it to the completed list.
     * Handles the case where the pending queue is empty.
     */
    public void processNextJob() {
        PrintJob jobToProcess = pendingJobs.poll(); // Retrieves and removes the head of the queue
        if (jobToProcess != null) {
            completedJobs.add(jobToProcess);
            System.out.println("Processing " + jobToProcess + "... Completed.");
        } else {
            System.err.println("Error: No pending jobs to process.");
        }
    }

    /**
     * Displays all jobs currently in the pending queue.
     */
    public void viewPendingJobs() {
        System.out.println("Pending Jobs:");
        if (pendingJobs.isEmpty()) {
            System.out.println("(none)");
        } else {
            // Iterate through the queue without removing elements
            for (PrintJob job : pendingJobs) {
                System.out.println(job);
            }
        }
    }

    /**
     * Displays all jobs in the completed list.
     */
    public void viewCompletedJobs() {
        System.out.println("Completed Jobs:");
        if (completedJobs.isEmpty()) {
            System.out.println("(none)");
        } else {
            // Iterate through the list
            for (PrintJob job : completedJobs) {
                System.out.println(job);
            }
        }
    }

    /**
     * Clears the list of completed jobs.
     */
    public void clearCompletedJobs() {
        completedJobs.clear();
        System.out.println("Completed jobs list cleared.");
    }

    /**
     * Main method to run the Print Job Management System.
     * Handles user input and command processing.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintManager manager = new PrintManager();

        System.out.println("Print Job Management System");
        System.out.println("Commands: submit <file> <pages>, process, view_pending, view_completed, clear_completed, exit");

        // Class-wide try-catch block wrapping the main command loop
        try {
            while (true) {
                System.out.print("\nEnter command: ");
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] parts = line.split(" ");
                String command = parts[0].toLowerCase();

                // Use switch statement for command handling
                switch (command) {
                    case "submit":
                        if (parts.length == 3) {
                            String fileName = parts[1];
                            try {
                                int pages = Integer.parseInt(parts[2]);
                                manager.submitJob(fileName, pages);
                            } catch (NumberFormatException e) {
                                System.err.println("Error: Invalid number format for pages.");
                            }
                        } else {
                            System.err.println("Error: Invalid submit command format. Use 'submit <fileName> <pages>'.");
                        }
                        break;

                    case "process":
                        if (parts.length == 1) {
                            manager.processNextJob();
                        } else {
                             System.err.println("Error: Invalid process command format. Use 'process'.");
                        }
                        break;

                    case "view_pending":
                         if (parts.length == 1) {
                            manager.viewPendingJobs();
                        } else {
                             System.err.println("Error: Invalid view_pending command format. Use 'view_pending'.");
                        }
                        break;

                    case "view_completed":
                         if (parts.length == 1) {
                            manager.viewCompletedJobs();
                        } else {
                             System.err.println("Error: Invalid view_completed command format. Use 'view_completed'.");
                        }
                        break;

                    case "clear_completed":
                         if (parts.length == 1) {
                            manager.clearCompletedJobs();
                        } else {
                             System.err.println("Error: Invalid clear_completed command format. Use 'clear_completed'.");
                        }
                        break;

                    case "exit":
                        if (parts.length == 1) {
                            System.out.println("Exiting Print Job Manager.");
                            return; // Exit the main method
                        } else {
                             System.err.println("Error: Invalid exit command format. Use 'exit'.");
                        }
                        break;

                    default:
                        System.err.println("Error: Unknown command.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the command loop
            System.err.println("An unexpected system error occurred: " + e.getMessage());
            // In a real application, you might log this error instead of printing stack trace
            // e.printStackTrace();
        } finally {
            // Ensure the scanner is closed when the program exits or an unexpected error occurs
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}
