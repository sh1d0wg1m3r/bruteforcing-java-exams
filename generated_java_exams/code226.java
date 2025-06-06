/*
 * Exam Question #226
 * Generated on: 2025-05-11 22:35:23
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Java Programming Exam Task: Advanced Print Job Management System**
 * 
 * You are tasked with developing a simplified Print Job Management System. This system will manage a queue of print jobs waiting to be processed and maintain a history of completed jobs. The system should be interactive, allowing users to add new jobs, process the next job in the queue, and view the status of waiting and completed jobs.
 * 
 * Your solution must demonstrate advanced Java programming skills by adhering to the following requirements:
 * 
 * 1.  **Core Components:**
 *     *   Use `java.util.Queue` to represent the waiting print jobs.
 *     *   Use `java.util.ArrayList` declared as `java.util.List` to store completed print jobs.
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Implement a `switch` statement to handle different user commands.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, processing errors).
 *     *   Use `System.out` for displaying the menu, prompts, job details, and success messages.
 * 
 * 2.  **System Design:**
 *     *   Create a class `PrintJob` to represent a single print job. This class should encapsulate job details like a unique ID, file name, number of pages, and current status (e.g., "Waiting", "Completed").
 *     *   Create a class `PrintManager` that contains the `Queue` of waiting jobs and the `List` of completed jobs. This class should handle the logic for adding, processing, and listing jobs.
 *     *   The main application logic should reside in a separate class (e.g., `PrintSystemApp`) with a `main` method that instantiates `PrintManager` and runs the interactive loop.
 * 
 * 3.  **Functionality:**
 *     *   **Add Job:** Prompt the user for a file name and the number of pages. Create a `PrintJob` object and add it to the waiting queue. Assign a unique, auto-incrementing ID to each job.
 *     *   **Process Next Job:** Take the job at the front of the waiting queue, update its status to "Completed", and move it to the list of completed jobs. If the queue is empty, inform the user.
 *     *   **List Waiting Jobs:** Display details of all jobs currently in the waiting queue.
 *     *   **List Completed Jobs:** Display details of all jobs in the completed jobs list.
 *     *   **Exit:** Terminate the program.
 * 
 * 4.  **Error Handling and Input Validation:**
 *     *   Implement input validation for the number of pages (must be a positive integer). Use `System.err` for invalid input messages.
 *     *   Handle potential exceptions during user input (e.g., non-integer input when an integer is expected) using `try-catch` blocks.
 *     *   Implement class-wide exception handling (a broad `try-catch` around the main interaction loop) to catch any unexpected runtime errors and report them using `System.err`.
 *     *   Handle the case where the user tries to process a job when the queue is empty gracefully.
 * 
 * 5.  **Best Practices:**
 *     *   Use proper encapsulation (`private` fields, `public` methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Ensure clean code structure and formatting.
 * 
 * **Expected Output:**
 * 
 * The program should present a menu of options. Based on user input, it should perform the requested action, providing feedback using `System.out` for normal operations and `System.err` for errors.
 * 
 * Example interaction flow:
 * 
 * ```
 * Print Job Management Menu:
 * 1. Add New Job
 * 2. Process Next Job
 * 3. List Waiting Jobs
 * 4. List Completed Jobs
 * 5. Exit
 * Enter your choice: 1
 * Enter file name: document.pdf
 * Enter number of pages: 15
 * Job 1 (document.pdf, 15 pages) added to queue.
 * 
 * Print Job Management Menu:
 * 1. Add New Job
 * 2. Process Next Job
 * 3. List Waiting Jobs
 * 4. List Completed Jobs
 * 5. Exit
 * Enter your choice: 3
 * --- Waiting Jobs ---
 * Job ID: 1, File: document.pdf, Pages: 15, Status: Waiting
 * 
 * Print Job Management Menu:
 * 1. Add New Job
 * 2. Process Next Job
 * 3. List Waiting Jobs
 * 4. List Completed Jobs
 * 5. Exit
 * Enter your choice: 2
 * Processing job 1 (document.pdf, 15 pages)...
 * Job 1 completed.
 * 
 * Print Job Management Menu:
 * 1. Add New Job
 * 2. Process Next Job
 * 3. List Waiting Jobs
 * 4. List Completed Jobs
 * 5. Exit
 * Enter your choice: 3
 * --- Waiting Jobs ---
 * (Queue is empty)
 * 
 * Print Job Management Menu:
 * 1. Add New Job
 * 2. Process Next Job
 * 3. List Waiting Jobs
 * 4. List Completed Jobs
 * 5. Exit
 * Enter your choice: 4
 * --- Completed Jobs ---
 * Job ID: 1, File: document.pdf, Pages: 15, Status: Completed
 * 
 * Print Job Management Menu:
 * 1. Add New Job
 * 2. Process Next Job
 * 3. List Waiting Jobs
 * 4. List Completed Jobs
 * 5. Exit
 * Enter your choice: 1
 * Enter file name: report.docx
 * Enter number of pages: -5
 * Error: Number of pages must be positive. Job not added.
 * 
 * Print Job Management Menu:
 * ... (etc.)
 * ```
 * 
 * Your solution should consist of the `PrintJob`, `PrintManager`, and `PrintSystemApp` classes (or similar structure) in a single code block.
 *
 * EXPLANATION:
 * This solution implements a Print Job Management System using the required Java components and best practices.
 * 
 * 1.  **`PrintJob` Class:**
 *     *   Encapsulates the data for a single print job (`jobId`, `fileName`, `pages`, `status`) using `private` fields.
 *     *   Provides `public` getters to access the data.
 *     *   Includes a `public` setter for `status`, allowing the manager to update it.
 *     *   The `toString()` method provides a convenient way to display job information.
 * 
 * 2.  **`PrintManager` Class:**
 *     *   Holds the core data structures: a `Queue<PrintJob>` named `printQueue` (implemented using `LinkedList` which is a common `Queue` implementation) for jobs waiting to be processed, and a `List<PrintJob>` named `completedJobs` (implemented using `ArrayList`) for jobs that are finished.
 *     *   `nextJobId` is a private field to ensure unique IDs are assigned to new jobs.
 *     *   **`addJob(String fileName, int pages)`:** Creates a `PrintJob` instance, assigns the next available ID, and adds it to the `printQueue` using `offer()`. It includes input validation for `pages > 0`, printing an error to `System.err` if invalid and returning `false`.
 *     *   **`processNextJob()`:** Uses `printQueue.poll()` to retrieve and remove the job at the head of the queue. If the queue is empty, `poll()` returns `null`, which is handled gracefully with a message to `System.out`. Otherwise, the job's status is updated, and it's added to the `completedJobs` list.
 *     *   **`listWaitingJobs()` and `listCompletedJobs()`:** Iterate through the respective collections (`printQueue` and `completedJobs`) and print the details of each job using their `toString()` methods. They also handle the case where the lists are empty.
 *     *   **`displayMenu()`:** A private helper method to print the user options to `System.out`.
 *     *   **`run()`:** This is the main interactive method.
 *         *   It contains the main loop (`while(running)`).
 *         *   A `Scanner` is used for reading user input.
 *         *   The core of the interaction is a `switch` statement based on the user's numerical choice.
 *         *   Each case calls the appropriate `PrintManager` method (`addJob`, `processNextJob`, etc.).
 *         *   **Input Validation & Exception Handling:**
 *             *   A `try-catch(InputMismatchException)` is specifically used when reading integer input (`scanner.nextInt()`) to catch cases where the user enters non-numeric text. An error is printed to `System.err`, and the invalid input is consumed (`scanner.nextLine()`) to prevent an infinite loop.
 *             *   The `addJob` method performs validation for the number of pages.
 *             *   A broad `try-catch(Exception e)` wraps the entire `while` loop in `run()`. This provides *class-wide exception handling*, catching any unexpected runtime errors that might occur within the loop and printing an error message to `System.err`.
 *         *   A `finally` block ensures the `Scanner` resource is closed when the `run()` method exits (either normally or due to an exception). Using `try-with-resources` could also be an option if the `Scanner` was declared within the `try` block, but wrapping the entire loop makes the broad exception handling clearer.
 * 
 * 3.  **`PrintSystemApp` Class:**
 *     *   Contains the standard `main` method.
 *     *   Its sole purpose is to create an instance of `PrintManager` and call its `run()` method to start the interactive application.
 * 
 * This solution effectively uses a `Queue` for managing a processing order (FIFO - First-In, First-Out) and a `List` for storing a history of items, demonstrating their typical use cases. It incorporates user interaction via `Scanner` and `switch`, uses `System.out` and `System.err` appropriately, and includes robust error handling with specific input validation and a general catch-all `try-catch` for the main operational loop, fulfilling all requirements.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single print job with its details and status.
 */
class PrintJob {
    private int jobId;
    private String fileName;
    private int pages;
    private String status;

    /**
     * Constructs a new PrintJob.
     *
     * @param jobId    The unique ID of the job.
     * @param fileName The name of the file to print.
     * @param pages    The number of pages in the file.
     */
    public PrintJob(int jobId, String fileName, int pages) {
        this.jobId = jobId;
        this.fileName = fileName;
        this.pages = pages;
        this.status = "Waiting"; // Initial status
    }

    // --- Getters ---
    public int getJobId() {
        return jobId;
    }

    public String getFileName() {
        return fileName;
    }

    public int getPages() {
        return pages;
    }

    public String getStatus() {
        return status;
    }

    // --- Setter ---
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the print job.
     *
     * @return A formatted string describing the job.
     */
    @Override
    public String toString() {
        return String.format("Job ID: %d, File: %s, Pages: %d, Status: %s",
                             jobId, fileName, pages, status);
    }
}

/**
 * Manages the queue of waiting print jobs and a list of completed jobs.
 */
class PrintManager {
    private Queue<PrintJob> printQueue;
    private List<PrintJob> completedJobs;
    private int nextJobId;

    /**
     * Constructs a new PrintManager.
     * Initializes the job queue, completed jobs list, and job ID counter.
     */
    public PrintManager() {
        this.printQueue = new LinkedList<>(); // LinkedList implements Queue
        this.completedJobs = new ArrayList<>();
        this.nextJobId = 1; // Start job IDs from 1
    }

    /**
     * Adds a new print job to the waiting queue.
     *
     * @param fileName The name of the file.
     * @param pages    The number of pages.
     * @return true if the job was added successfully, false otherwise (e.g., invalid pages).
     */
    public boolean addJob(String fileName, int pages) {
        if (pages <= 0) {
            System.err.println("Error: Number of pages must be positive. Job not added.");
            return false;
        }
        PrintJob newJob = new PrintJob(nextJobId++, fileName, pages);
        printQueue.offer(newJob); // offer is preferred over add in queues as it doesn't throw exception on capacity limits (though LinkedList is unbounded)
        System.out.println("Job " + newJob.getJobId() + " (" + fileName + ", " + pages + " pages) added to queue.");
        return true;
    }

    /**
     * Processes the next job in the queue, moving it to the completed list.
     */
    public void processNextJob() {
        PrintJob jobToProcess = printQueue.poll(); // poll returns null if queue is empty

        if (jobToProcess == null) {
            System.out.println("No jobs in the waiting queue to process.");
        } else {
            System.out.println("Processing job " + jobToProcess.getJobId() + " (" + jobToProcess.getFileName() + ", " + jobToProcess.getPages() + " pages)...");
            jobToProcess.setStatus("Completed");
            completedJobs.add(jobToProcess);
            System.out.println("Job " + jobToProcess.getJobId() + " completed.");
        }
    }

    /**
     * Lists all jobs currently in the waiting queue.
     */
    public void listWaitingJobs() {
        System.out.println("--- Waiting Jobs ---");
        if (printQueue.isEmpty()) {
            System.out.println("(Queue is empty)");
        } else {
            // Iterate through the queue without removing elements
            for (PrintJob job : printQueue) {
                System.out.println(job);
            }
        }
    }

    /**
     * Lists all jobs that have been completed.
     */
    public void listCompletedJobs() {
        System.out.println("--- Completed Jobs ---");
        if (completedJobs.isEmpty()) {
            System.out.println("(No completed jobs yet)");
        } else {
            for (PrintJob job : completedJobs) {
                System.out.println(job);
            }
        }
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\nPrint Job Management Menu:");
        System.out.println("1. Add New Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. List Waiting Jobs");
        System.out.println("4. List Completed Jobs");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main interactive loop for the Print Job Management System.
     * Handles user input and calls appropriate PrintManager methods.
     * Includes class-wide exception handling.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                displayMenu();

                int choice = -1;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    continue; // Skip to the next loop iteration
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter file name: ");
                        String fileName = scanner.nextLine();
                        int pages = -1;
                        try {
                            System.out.print("Enter number of pages: ");
                            pages = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            addJob(fileName, pages); // addJob has its own validation for pages > 0
                        } catch (InputMismatchException e) {
                            System.err.println("Error: Invalid input for pages. Please enter an integer.");
                            scanner.nextLine(); // Consume the invalid input
                        }
                        break;
                    case 2:
                        processNextJob();
                        break;
                    case 3:
                        listWaitingJobs();
                        break;
                    case 4:
                        listCompletedJobs();
                        break;
                    case 5:
                        System.out.println("Exiting Print Job Management System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions during execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for detailed debugging stack trace
        } finally {
            // Ensure the scanner is closed when the application exits
            scanner.close();
            System.out.println("Scanner closed."); // Optional: confirmation
        }
    }
}

/**
 * Main application class to start the Print Job Management System.
 */
public class PrintSystemApp {
    public static void main(String[] args) {
        PrintManager manager = new PrintManager();
        manager.run(); // Start the interactive system
    }
}
