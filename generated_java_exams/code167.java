/*
 * Exam Question #167
 * Generated on: 2025-05-11 22:24:56
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Print Job Management System
 * 
 * **Objective:** Design and implement a simplified command-line based Print Job Management System. This system will simulate managing a queue of print jobs submitted by users.
 * 
 * **Scenario:**
 * You are tasked with creating a program that manages print jobs for a server. Print jobs are submitted with a document name and the number of pages. Jobs are processed in the order they are submitted (First-In, First-Out). The system should allow users to submit jobs, view the list of pending jobs, and process the next job in the queue.
 * 
 * **Requirements:**
 * 
 * 1.  **PrintJob Class:** Create a class `PrintJob` to represent a single print job. It should have:
 *     *   A unique integer ID.
 *     *   A string for the document name.
 *     *   An integer for the number of pages.
 *     *   A constructor to initialize these fields.
 *     *   Getter methods for all fields.
 *     *   A `toString()` method that provides a user-friendly representation of the job (e.g., "Job ID: [ID], Doc: [Name], Pages: [Pages]").
 *     *   All fields must be private (encapsulation).
 * 
 * 2.  **PrintManager Class:** Create a class `PrintManager` to manage the collection of print jobs. It should:
 *     *   Use a `java.util.Queue<PrintJob>` to store pending print jobs.
 *     *   Maintain a counter to generate unique job IDs.
 *     *   Have a method `submitJob(String documentName, int pages)`:
 *         *   Creates a new `PrintJob` with a unique ID.
 *         *   Adds the job to the queue.
 *         *   Prints a success message to `System.out`.
 *     *   Have a method `processNextJob()`:
 *         *   Removes the job at the front of the queue.
 *         *   If the queue is not empty, prints a message to `System.out` indicating which job is being processed.
 *         *   If the queue is empty, prints an error message to `System.err`.
 *     *   Have a method `getPendingJobs()`:
 *         *   Returns a `java.util.List<PrintJob>` containing all jobs currently in the queue. The order in the list should reflect the order in the queue. This method should *not* remove jobs from the queue. Use a `java.util.ArrayList` to construct this list from the queue's contents.
 * 
 * 3.  **Command-Line Interface (CLI):** Implement a main program that interacts with the user via the console using `java.util.Scanner`. The program should present a menu of options and process user commands in a loop until the user chooses to exit.
 *     *   The program should support the following commands:
 *         *   `submit <document_name> <pages>`: Submits a new print job. Example: `submit Report 15`.
 *         *   `list`: Displays all pending jobs in the queue.
 *         *   `process`: Processes the next job in the queue.
 *         *   `exit`: Terminates the program.
 *         *   Any other input should be treated as an invalid command.
 * 
 * 4.  **Input Validation & Error Handling:**
 *     *   Validate user input for the `submit` command:
 *         *   Ensure both document name and pages arguments are provided.
 *         *   Ensure the pages argument is a positive integer. Handle `NumberFormatException` if the pages argument is not a valid integer.
 *     *   Use `System.err` to print all error messages (e.g., invalid command, missing arguments, invalid page count, processing empty queue).
 *     *   Use `System.out` for all normal output (prompts, success messages, job listings).
 *     *   Implement **class-wide exception handling** using `try-catch` blocks to gracefully handle unexpected errors during the main execution loop.
 * 
 * 5.  **Required Java Components:** Your solution MUST use ALL of the following:
 *     *   `java.util.Queue`
 *     *   `java.util.ArrayList`
 *     *   `java.util.List`
 *     *   `java.util.Scanner`
 *     *   `switch` statement
 *     *   `System.err`
 *     *   `System.out`
 *     *   Class-wide `try-catch` blocks
 * 
 * 6.  **Best Practices:**
 *     *   Employ proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadocs where applicable).
 *     *   Structure the code cleanly into logical classes.
 * 
 * **Expected Output:**
 * The output should guide the user with prompts and display results or errors clearly.
 * Example Interaction:
 * ```
 * Print Job Management System
 * Enter command (submit <name> <pages>, list, process, exit):
 * > submit DocumentA 10
 * Job submitted: Job ID: 1, Doc: DocumentA, Pages: 10
 * Enter command (submit <name> <pages>, list, process, exit):
 * > submit Presentation 25
 * Job submitted: Job ID: 2, Doc: Presentation, Pages: 25
 * Enter command (submit <name> <pages>, list, process, exit):
 * > list
 * Pending Jobs:
 * Job ID: 1, Doc: DocumentA, Pages: 10
 * Job ID: 2, Doc: Presentation, Pages: 25
 * Enter command (submit <name> <pages>, list, process, exit):
 * > process
 * Processing job: Job ID: 1, Doc: DocumentA, Pages: 10
 * Enter command (submit <name> <pages>, list, process, exit):
 * > list
 * Pending Jobs:
 * Job ID: 2, Doc: Presentation, Pages: 25
 * Enter command (submit <name> <pages>, list, process, exit):
 * > process
 * Processing job: Job ID: 2, Doc: Presentation, Pages: 25
 * Enter command (submit <name> <pages>, list, process, exit):
 * > process
 * Error: No jobs in the queue to process.
 * Enter command (submit <name> <pages>, list, process, exit):
 * > submit InvalidJob Five
 * Error: Invalid number of pages. Please enter a positive integer.
 * Enter command (submit <name> <pages>, list, process, exit):
 * > submit AnotherDoc -5
 * Error: Number of pages must be positive.
 * Enter command (submit <name> <pages>, list, process, exit):
 * > invalid_command
 * Error: Unknown command. Type 'submit', 'list', 'process', or 'exit'.
 * Enter command (submit <name> <pages>, list, process, exit):
 * > exit
 * Exiting Print Job Management System.
 * ```
 * 
 * Your solution should be provided as a single block of code representing the complete program (you can include multiple classes within the same file for this exam).
 *
 * EXPLANATION:
 * This solution implements a simplified Print Job Management System CLI, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`PrintJob` Class:** This class serves as a simple data structure following encapsulation principles. It holds the `id`, `documentName`, and `pages` as private fields and provides public getter methods. The `toString()` method provides a convenient way to display job details.
 * 
 * 2.  **`PrintManager` Class:** This class manages the core logic.
 *     *   It uses a `java.util.Queue<PrintJob>`, specifically a `LinkedList` implementation, to store jobs in a FIFO manner. `LinkedList` is a common choice for implementing `Queue` in Java.
 *     *   `nextJobId` ensures unique IDs for submitted jobs.
 *     *   `submitJob` creates a `PrintJob` and adds it to the queue using `offer()`.
 *     *   `processNextJob` removes and returns the head of the queue using `poll()`. It checks if `poll()` returned `null` to determine if the queue was empty, printing an appropriate message to `System.out` or `System.err`.
 *     *   `getPendingJobs` demonstrates converting the contents of a `Queue` to a `java.util.List`. It iterates through the `jobQueue` and adds each `PrintJob` to a new `java.util.ArrayList`. This provides a snapshot of the queue's contents without modifying the queue itself, fulfilling the requirement to use `ArrayList` and `List`.
 * 
 * 3.  **`PrintSystemCLI` Class (Main):**
 *     *   This class contains the `main` method which drives the command-line interface.
 *     *   A `Scanner` is used to read user input from `System.in`.
 *     *   A `while(running)` loop keeps the program active until the user enters the `exit` command.
 *     *   **Class-wide Exception Handling:** The main `while` loop is wrapped in a `try-catch(Exception e)` block. This demonstrates catching unexpected errors that might occur during the execution of command processing, preventing the program from crashing abruptly and printing the error details to `System.err`. A `finally` block ensures the `Scanner` is closed.
 *     *   User input is read, trimmed, and split into command parts.
 *     *   A `switch` statement is used to dispatch based on the first part of the command line.
 *     *   **Input Validation & Error Handling:**
 *         *   Inside the `submit` case, it checks if the correct number of arguments is provided.
 *         *   It attempts to parse the pages argument as an integer within a nested `try-catch(NumberFormatException e)` block, printing an error to `System.err` if parsing fails.
 *         *   It validates that the parsed page count is positive, printing an error to `System.err` if not.
 *         *   `System.out` is used for successful messages and job listings.
 *         *   `System.err` is used for all validation and processing errors.
 *     *   The `list` case calls `getPendingJobs` and iterates through the returned `List` (an `ArrayList`) to print job details to `System.out`.
 *     *   The `process` case calls `printManager.processNextJob()`.
 *     *   The `exit` case sets the `running` flag to `false` to terminate the loop.
 *     *   The `default` case in the `switch` handles unknown commands, printing an error to `System.err`.
 * 
 * This solution effectively integrates all the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, demonstrating proper object-oriented design, input validation, and error handling.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Represents a single print job with a unique ID, document name, and page count.
 */
class PrintJob {
    private int id;
    private String documentName;
    private int pages;

    /**
     * Constructs a new PrintJob.
     * @param id The unique ID for the job.
     * @param documentName The name of the document.
     * @param pages The number of pages to print.
     */
    public PrintJob(int id, String documentName, int pages) {
        this.id = id;
        this.documentName = documentName;
        this.pages = pages;
    }

    /**
     * Gets the job ID.
     * @return The job ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the document name.
     * @return The document name.
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Gets the number of pages.
     * @return The number of pages.
     */
    public int getPages() {
        return pages;
    }

    /**
     * Provides a string representation of the PrintJob.
     * @return Formatted string representing the job.
     */
    @Override
    public String toString() {
        return "Job ID: " + id + ", Doc: " + documentName + ", Pages: " + pages;
    }
}

/**
 * Manages a queue of print jobs.
 */
class PrintManager {
    private Queue<PrintJob> jobQueue;
    private int nextJobId;

    /**
     * Constructs a new PrintManager, initializing the job queue and ID counter.
     */
    public PrintManager() {
        // LinkedList is a common implementation of Queue
        jobQueue = new LinkedList<>();
        nextJobId = 1; // Start job IDs from 1
    }

    /**
     * Submits a new print job to the queue.
     * @param documentName The name of the document.
     * @param pages The number of pages.
     */
    public void submitJob(String documentName, int pages) {
        PrintJob newJob = new PrintJob(nextJobId++, documentName, pages);
        jobQueue.offer(newJob); // offer is preferred over add in queues as it handles capacity limits
        System.out.println("Job submitted: " + newJob);
    }

    /**
     * Processes (simulates printing) the next job in the queue.
     * Removes the job from the queue.
     */
    public void processNextJob() {
        PrintJob jobToProcess = jobQueue.poll(); // poll removes the head of the queue
        if (jobToProcess != null) {
            System.out.println("Processing job: " + jobToProcess);
        } else {
            System.err.println("Error: No jobs in the queue to process.");
        }
    }

    /**
     * Gets a list of all pending jobs currently in the queue without removing them.
     * @return A List of PrintJob objects representing the pending jobs.
     */
    public List<PrintJob> getPendingJobs() {
        // Create an ArrayList to hold the jobs for listing
        List<PrintJob> pendingList = new ArrayList<>();
        // Iterate over the queue elements and add them to the list
        // This does not remove elements from the queue
        for (PrintJob job : jobQueue) {
            pendingList.add(job);
        }
        return pendingList;
    }
}

/**
 * Main class for the Print Job Management System CLI.
 */
public class PrintSystemCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintManager printManager = new PrintManager();
        boolean running = true;

        System.out.println("Print Job Management System");

        // Class-wide exception handling for the main command loop
        try {
            while (running) {
                System.out.println("Enter command (submit <name> <pages>, list, process, exit):");
                System.out.print("> ");

                String commandLine = scanner.nextLine().trim();
                // Split the command line into parts
                String[] parts = commandLine.split("\\s+");
                String command = parts.length > 0 ? parts[0].toLowerCase() : "";

                // Use switch statement for command processing
                switch (command) {
                    case "submit":
                        // Expected format: submit <document_name> <pages>
                        if (parts.length < 3) {
                            System.err.println("Error: Submit command requires document name and pages.");
                            System.err.println("Usage: submit <document_name> <pages>");
                        } else {
                            String docName = parts[1];
                            // Reconstruct document name if it had spaces (simple approach: join all parts after command)
                            // A more robust solution would handle quoted names, but this is sufficient for the exam
                            if (parts.length > 3) {
                                StringJoiner sj = new StringJoiner(" ");
                                for(int i = 1; i < parts.length - 1; i++) {
                                    sj.add(parts[i]);
                                }
                                docName = sj.toString();
                            }
                            String pagesStr = parts[parts.length - 1]; // Last part is pages

                            try {
                                int pages = Integer.parseInt(pagesStr);
                                if (pages <= 0) {
                                    System.err.println("Error: Number of pages must be positive.");
                                } else {
                                    printManager.submitJob(docName, pages);
                                }
                            } catch (NumberFormatException e) {
                                System.err.println("Error: Invalid number of pages. Please enter a positive integer.");
                            }
                        }
                        break;

                    case "list":
                        List<PrintJob> pendingJobs = printManager.getPendingJobs();
                        if (pendingJobs.isEmpty()) {
                            System.out.println("No pending jobs.");
                        } else {
                            System.out.println("Pending Jobs:");
                            for (PrintJob job : pendingJobs) {
                                System.out.println(job);
                            }
                        }
                        break;

                    case "process":
                        printManager.processNextJob();
                        break;

                    case "exit":
                        running = false;
                        System.out.println("Exiting Print Job Management System.");
                        break;

                    case "": // Handle empty input line
                        break;

                    default:
                        System.err.println("Error: Unknown command. Type 'submit', 'list', 'process', or 'exit'.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the execution loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to understand the error
        } finally {
            // Ensure the scanner is closed
            scanner.close();
        }
    }
}
