/*
 * Exam Question #192
 * Generated on: 2025-05-11 22:29:15
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Enterprise Print Job Scheduler Simulation
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified command-line simulation of an enterprise print job scheduler. The system should allow users to add new print jobs to a queue, process jobs one by one from the front of the queue, view the list of pending jobs, and view a history of completed jobs. The system needs to be robust, handling user input and potential operational issues gracefully.
 * 
 * **Task:**
 * 
 * Implement a Java application that simulates this print job scheduler. Your solution must adhere to the following requirements and demonstrate advanced Java programming concepts.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use `java.util.Queue` to manage the pending print jobs. Jobs should be processed in First-In, First-Out (FIFO) order.
 *     *   Use `java.util.ArrayList` to store the history of completed print jobs.
 *     *   Utilize the `java.util.List` interface type when declaring the history collection.
 * 
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user commands and input from the console.
 *     *   Implement a command-line interface with a menu of options:
 *         *   `1`: Add New Print Job
 *         *   `2`: Process Next Print Job
 *         *   `3`: View Pending Job Queue
 *         *   `4`: View Completed Job History
 *         *   `5`: Exit
 *     *   Use a `switch` statement to handle the user's command selection.
 * 
 * 3.  **Output and Error Handling:**
 *     *   Use `System.out` for displaying the menu, success messages, and the contents of the queue and history.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, trying to process an empty queue).
 *     *   Implement class-wide exception handling using `try-catch` blocks in the main application logic to catch unexpected runtime errors. Specific operational errors (like empty queue) should be handled with `if` checks and `System.err`.
 * 
 * 4.  **Object-Oriented Design:**
 *     *   Create a `PrintJob` class to represent a single print job. It should include attributes like a unique job ID, document name, number of pages, and status (e.g., PENDING, COMPLETED). Use an enum for the job status.
 *     *   Create a `PrintManager` class that encapsulates the `Queue` and `List` collections and provides methods for managing print jobs (adding, processing, viewing).
 *     *   Ensure proper encapsulation (private fields, public methods/getters).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 * 
 * 5.  **Input Validation:**
 *     *   Validate user input where necessary (e.g., ensure the number of pages for a new job is a positive integer).
 * 
 * 6.  **Clean Code:**
 *     *   Structure your code logically into separate classes.
 *     *   Maintain a clean and readable code style.
 * 
 * **Expected Behavior:**
 * 
 * *   The application should start, display the menu, and wait for user input.
 * *   Selecting '1' should prompt for document name and pages, create a `PrintJob`, add it to the queue, and confirm the addition.
 * *   Selecting '2' should remove the job at the front of the queue, mark it as completed, add it to the history, and confirm processing. If the queue is empty, it should print an error to `System.err`.
 * *   Selecting '3' should display the details of all jobs currently in the pending queue.
 * *   Selecting '4' should display the details of all jobs in the completed history.
 * *   Selecting '5' should terminate the application gracefully.
 * *   Invalid menu choices or invalid data input (e.g., non-integer pages) should be handled, printing an error to `System.err`, and the application loop should continue.
 * *   Any unexpected runtime exceptions should be caught by the main `try-catch` block, printing a generic error message to `System.err` before potentially exiting or continuing depending on the error type.
 * 
 * **Example Interaction (Illustrative):**
 * 
 * ```
 * --- Print Job Scheduler Menu ---
 * 1. Add New Print Job
 * 2. Process Next Print Job
 * 3. View Pending Job Queue
 * 4. View Completed Job History
 * 5. Exit
 * Enter your choice: 1
 * Enter document name: Report.pdf
 * Enter number of pages: 15
 * Job 1 added: Report.pdf (15 pages, PENDING)
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 1
 * Enter document name: Presentation.pptx
 * Enter number of pages: 30
 * Job 2 added: Presentation.pptx (30 pages, PENDING)
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 3
 * Pending Jobs:
 * Job 1: Report.pdf (15 pages, PENDING)
 * Job 2: Presentation.pptx (30 pages, PENDING)
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 2
 * Processing job: Job 1: Report.pdf (15 pages, PENDING)
 * Job 1 completed.
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 3
 * Pending Jobs:
 * Job 2: Presentation.pptx (30 pages, PENDING)
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 4
 * Completed Jobs:
 * Job 1: Report.pdf (15 pages, COMPLETED)
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 2
 * Processing job: Job 2: Presentation.pptx (30 pages, PENDING)
 * Job 2 completed.
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 2
 * Error: No pending jobs to process. // Output to System.err
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 6
 * Error: Invalid choice. Please enter a number between 1 and 5. // Output to System.err
 * 
 * --- Print Job Scheduler Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Print Job Scheduler.
 * ```
 * 
 * Implement the complete Java code for this simulation.
 *
 * EXPLANATION:
 * This solution implements a command-line Print Job Scheduler simulation, demonstrating the required Java concepts and best practices.
 * 
 * **Solution Approach:**
 * 
 * The system is structured into three main parts:
 * 1.  `JobStatus` enum: Defines the possible states of a print job.
 * 2.  `PrintJob` class: Represents an individual print job with its attributes and state.
 * 3.  `PrintManager` class: Manages the collections of pending and completed jobs and provides the core logic for adding, processing, and viewing jobs.
 * 4.  `PrinterSystemApp` class: Contains the `main` method, handles user interaction via the `Scanner`, uses a `switch` statement to direct control based on user input, and orchestrates calls to the `PrintManager`.
 * 
 * **Required Components Usage:**
 * 
 * *   **`Queue` (java.util.Queue):** The `PrintManager` class uses a `Queue<PrintJob>` (`jobQueue`) implemented by `java.util.LinkedList`. This correctly models the FIFO nature of a print queue, where jobs are added to the end (`offer`) and removed from the front (`poll`).
 * *   **`ArrayList` (java.util.ArrayList):** The `PrintManager` class uses an `ArrayList<PrintJob>` (`completedJobs`) to store jobs after they have been processed. `ArrayList` is suitable for storing a dynamic list of items where elements are added and iterated over.
 * *   **`List` interface (java.util.List):** The `completedJobs` collection in `PrintManager` is declared using the `List<PrintJob>` interface type (`List<PrintJob> completedJobs = new ArrayList<>();`). This demonstrates programming to an interface, which is a key best practice for flexibility.
 * *   **`Scanner` (java.util.Scanner):** The `PrinterSystemApp` class uses a `Scanner` object to read user input from `System.in`, including integer choices and string values for document names and page counts.
 * *   **`Switch` statement:** The `main` method in `PrinterSystemApp` uses a `switch` statement to determine the action to perform based on the user's numeric menu choice.
 * *   **`System.err`:** Used in `PrinterSystemApp` to output error messages, such as invalid menu choices, invalid input data (non-positive pages, non-integer input), and attempting to process a job when the queue is empty.
 * *   **`System.out`:** Used in `PrinterSystemApp` to display the menu, confirmation messages for successful operations (job added, job completed), and the formatted lists of pending and completed jobs retrieved from the `PrintManager`.
 * *   **Class-wide exception handling (`try-catch`):** The main `while` loop in the `main` method of `PrinterSystemApp` is wrapped in a `try-catch(Exception e)` block. This provides a safety net for catching any unexpected runtime exceptions that might occur during the program's execution, demonstrating class-wide handling. More specific expected errors (like `InputMismatchException` for reading integers or an empty queue condition) are also handled, using `System.err` for feedback. A `finally` block ensures the `Scanner` is closed.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Fields in `PrintJob` and `PrintManager` are `private`, with public getter methods provided where necessary (`PrintJob`). The internal data structures (`jobQueue`, `completedJobs`) are managed solely by the `PrintManager`'s public methods, hiding the implementation details from the main application class.
 * *   **Meaningful Names:** Class names (`PrintJob`, `PrintManager`, `PrinterSystemApp`), variable names (`jobQueue`, `completedJobs`, `documentName`, `pages`, `nextJobId`), method names (`addJob`, `processNextJob`, `viewQueue`, `viewHistory`, `displayMenu`), and enum constants (`PENDING`, `COMPLETED`) are descriptive and indicate their purpose.
 * *   **Comments and Documentation:** Javadoc comments are provided for classes and key methods, explaining their purpose, parameters, and return values. Inline comments are used to clarify specific logic points.
 * *   **Input Validation:** The code explicitly checks if the entered number of pages is positive. It also handles `InputMismatchException` when reading integer input, prompting the user to re-enter valid data.
 * *   **Proper Error Handling:** Different types of errors are handled differently:
 *     *   Operational errors (empty queue, non-positive pages, invalid menu choice) are checked with `if`/`switch` and reported to `System.err`.
 *     *   Input format errors (`InputMismatchException`) are caught specifically during `Scanner` operations.
 *     *   Any other unexpected `Exception` is caught by the outer `try-catch` block in `main`.
 * *   **Clean Code Structure:** The code is divided into logical units (enum, classes) with clear responsibilities. The `main` method focuses on the application loop and user interaction, delegating core job management tasks to the `PrintManager`. The menu display is extracted into a separate private method.
 * 
 * **Control Flow and Exception Handling:**
 * 
 * The `main` method runs a `while(running)` loop. Inside the loop, a `try-catch` block specifically handles `InputMismatchException` during the initial menu choice reading to prevent the program from crashing on non-integer input and to clear the invalid input from the scanner buffer. The main `switch` statement then directs execution based on a valid integer choice. Each case calls the appropriate `PrintManager` method or handles the exit command. Specific operational checks (like `printManager.processNextJob() == null`) are performed to detect and report expected error conditions to `System.err`. The outer `try-catch(Exception e)` block acts as a global handler for any other exceptions that might occur within the loop, providing a final layer of robustness. The `finally` block ensures the `Scanner` resource is closed.
 * 
 * This solution effectively combines data structures, object-oriented principles, user interaction, and robust error handling to simulate a practical system, fulfilling all the requirements of the task.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

// Enum to represent the status of a print job
enum JobStatus {
    PENDING,
    PROCESSING, // Although processing is simulated instantly, this status could be used in a more complex system
    COMPLETED
}

/**
 * Represents a single print job with details and status.
 */
class PrintJob {
    private int id;
    private String documentName;
    private int pages;
    private JobStatus status;

    /**
     * Constructs a new PrintJob.
     *
     * @param id The unique identifier for the job.
     * @param documentName The name of the document.
     * @param pages The number of pages in the document.
     */
    public PrintJob(int id, String documentName, int pages) {
        this.id = id;
        this.documentName = documentName;
        this.pages = pages;
        this.status = JobStatus.PENDING; // New jobs start as PENDING
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public int getPages() {
        return pages;
    }

    public JobStatus getStatus() {
        return status;
    }

    // --- Setter for status (used by PrintManager) ---
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the PrintJob.
     *
     * @return A formatted string describing the job.
     */
    @Override
    public String toString() {
        return String.format("Job %d: %s (%d pages, %s)",
                             id, documentName, pages, status);
    }
}

/**
 * Manages the queue of pending print jobs and the history of completed jobs.
 */
class PrintManager {
    private Queue<PrintJob> jobQueue;
    private List<PrintJob> completedJobs;
    private int nextJobId; // Counter for unique job IDs

    /**
     * Constructs a new PrintManager.
     */
    public PrintManager() {
        // LinkedList is a common implementation for Queue
        this.jobQueue = new LinkedList<>();
        // ArrayList is used for history, declared with List interface
        this.completedJobs = new ArrayList<>();
        this.nextJobId = 1; // Start job IDs from 1
    }

    /**
     * Adds a new print job to the pending queue.
     *
     * @param documentName The name of the document.
     * @param pages The number of pages.
     * @return The PrintJob object that was added.
     */
    public PrintJob addJob(String documentName, int pages) {
        PrintJob newJob = new PrintJob(nextJobId++, documentName, pages);
        jobQueue.offer(newJob); // offer is preferred over add for capacity-constrained queues, though LinkedList is not capacity-constrained. It's good practice.
        return newJob;
    }

    /**
     * Processes the next job in the queue.
     * Removes the job from the queue, updates its status, and adds it to history.
     *
     * @return The completed PrintJob, or null if the queue was empty.
     */
    public PrintJob processNextJob() {
        PrintJob jobToProcess = jobQueue.poll(); // poll retrieves and removes the head of the queue, returns null if empty
        if (jobToProcess != null) {
            // Simulate processing
            System.out.println("Processing job: " + jobToProcess);
            jobToProcess.setStatus(JobStatus.COMPLETED);
            completedJobs.add(jobToProcess);
            return jobToProcess;
        } else {
            return null; // Queue was empty
        }
    }

    /**
     * Displays the current pending job queue.
     */
    public void viewQueue() {
        System.out.println("--- Pending Jobs ---");
        if (jobQueue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            for (PrintJob job : jobQueue) {
                System.out.println(job);
            }
        }
    }

    /**
     * Displays the history of completed jobs.
     */
    public void viewHistory() {
        System.out.println("--- Completed Jobs History ---");
        if (completedJobs.isEmpty()) {
            System.out.println("No jobs have been completed yet.");
        } else {
            // Iterate through the list
            for (PrintJob job : completedJobs) {
                System.out.println(job);
            }
        }
    }
}

/**
 * Main application class for the Print Job Scheduler Simulation.
 * Handles user interaction and orchestrates the PrintManager.
 */
public class PrinterSystemApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintManager printManager = new PrintManager();
        boolean running = true;

        // Class-wide exception handling for unexpected errors
        try {
            while (running) {
                displayMenu();
                int choice = -1;
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    // Consume the newline character left by nextInt()
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop and show menu again
                }

                // Switch statement for command handling
                switch (choice) {
                    case 1: // Add New Print Job
                        System.out.print("Enter document name: ");
                        String docName = scanner.nextLine();

                        int pages = -1;
                        boolean validPages = false;
                        while (!validPages) {
                            System.out.print("Enter number of pages: ");
                            try {
                                pages = scanner.nextInt();
                                scanner.nextLine(); // Consume newline
                                if (pages > 0) {
                                    validPages = true;
                                } else {
                                    System.err.println("Error: Number of pages must be positive.");
                                }
                            } catch (InputMismatchException e) {
                                System.err.println("Error: Invalid input for pages. Please enter an integer.");
                                scanner.nextLine(); // Consume invalid input
                            }
                        }
                        PrintJob addedJob = printManager.addJob(docName, pages);
                        System.out.println("Job " + addedJob.getId() + " added: " + addedJob.getDocumentName() +
                                           " (" + addedJob.getPages() + " pages, " + addedJob.getStatus() + ")");
                        break;

                    case 2: // Process Next Print Job
                        PrintJob processedJob = printManager.processNextJob();
                        if (processedJob != null) {
                            System.out.println("Job " + processedJob.getId() + " completed.");
                        } else {
                            // Specific error handling for empty queue
                            System.err.println("Error: No pending jobs to process.");
                        }
                        break;

                    case 3: // View Pending Job Queue
                        printManager.viewQueue();
                        break;

                    case 4: // View Completed Job History
                        printManager.viewHistory();
                        break;

                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting Print Job Scheduler.");
                        break;

                    default: // Invalid choice
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
                System.out.println(); // Add a blank line for better readability
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions that weren't specifically handled
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for debugging purposes
        } finally {
            // Ensure scanner is closed even if an exception occurs
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Displays the main menu options to the console.
     */
    private static void displayMenu() {
        System.out.println("--- Print Job Scheduler Menu ---");
        System.out.println("1. Add New Print Job");
        System.out.println("2. Process Next Print Job");
        System.out.println("3. View Pending Job Queue");
        System.out.println("4. View Completed Job History");
        System.out.println("5. Exit");
    }
}
