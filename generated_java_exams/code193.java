/*
 * Exam Question #193
 * Generated on: 2025-05-11 22:29:26
 * Generated by: Account 1
 * 
 * QUESTION:
 * **Advanced Java Programming Exam Task: Print Queue Management System**
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple command-line application to simulate a print queue management system. The system should allow users to submit print jobs, process the next job in the queue, view the list of pending jobs, and view the history of completed jobs.
 * 
 * A print job is defined by a unique ID (a string) and the number of pages (an integer). Jobs are processed in the order they are submitted (First-In, First-Out).
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `Queue` to store print jobs that are waiting to be processed.
 *     *   Use a `List` (specifically, an `ArrayList` implementation) to store print jobs that have been completed.
 * 
 * 2.  **Core Functionality:**
 *     *   **Submit Job:** Prompt the user for a Job ID and the number of pages. Create a new `PrintJob` object and add it to the pending jobs queue.
 *     *   **Process Next Job:** Take the next job from the front of the pending queue, simulate processing it (print a message), and move it to the completed jobs list. Handle the case where the queue is empty.
 *     *   **View Pending Queue:** Display the details of all jobs currently waiting in the queue, in order. Handle the case where the queue is empty.
 *     *   **View Completed History:** Display the details of all jobs that have been processed. Handle the case where the history is empty.
 *     *   **Exit:** Terminate the application.
 * 
 * 3.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a clear menu of options to the user (Submit, Process, View Queue, View History, Exit).
 *     *   Use a `switch` statement to handle the user's menu selection.
 * 
 * 4.  **Output:**
 *     *   Use `System.out` for all normal output (menu, prompts, job details, success messages).
 *     *   Use `System.err` for all error messages (invalid input, queue empty when processing, history empty when viewing, general unexpected errors).
 * 
 * 5.  **Error Handling & Validation:**
 *     *   Implement input validation: Ensure the number of pages for a job is a positive integer. If not, display an error using `System.err` and do not submit the job.
 *     *   Implement robust exception handling:
 *         *   Use `try-catch` blocks to handle potential errors during user input parsing (e.g., `NumberFormatException`).
 *         *   Implement a **class-wide** `try-catch` block around the main application loop to catch any unexpected exceptions and prevent the program from crashing abruptly, printing an error message to `System.err`.
 * 
 * 6.  **Object-Oriented Design:**
 *     *   Create a `PrintJob` class with private fields (`jobId`, `pages`), a constructor, and public getter methods. Override `toString()` for easy printing.
 *     *   Create a `PrintQueueManager` class that encapsulates the `Queue` and `List` data structures and contains the methods for managing the print jobs.
 * 
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments to explain code sections.
 *     *   Ensure proper encapsulation (private fields, public methods where necessary).
 *     *   Close the `Scanner` when the application exits.
 * 
 * **Expected Output Format:**
 * 
 * *   Menu is displayed clearly.
 * *   Prompts for input are clear.
 * *   Job details are printed using the `PrintJob`'s `toString()` method.
 * *   Success messages (e.g., "Job submitted", "Job processed") are printed to `System.out`.
 * *   Error messages (e.g., "Invalid number of pages", "Queue is empty", "Invalid choice", "An unexpected error occurred") are printed to `System.err`.
 * 
 * **Constraint Checklist:**
 * 
 * *   [ ] Use `java.util.Queue`
 * *   [ ] Use `java.util.ArrayList`
 * *   [ ] Use `java.util.List` interface type (for completed jobs)
 * *   [ ] Use `java.util.Scanner`
 * *   [ ] Use `switch` statement
 * *   [ ] Use `System.err` for errors
 * *   [ ] Use `System.out` for normal output
 * *   [ ] Class-wide `try-catch`
 * *   [ ] Proper encapsulation (`PrintJob`, `PrintQueueManager`)
 * *   [ ] Meaningful names
 * *   [ ] Comments/Documentation
 * *   [ ] Input validation (pages > 0)
 * *   [ ] Proper error handling (parsing, empty queue/list, general)
 * *   [ ] Clean code structure
 * *   [ ] Simulates a real-world scenario (print queue)
 * 
 * Good luck!
 *
 * EXPLANATION:
 * This solution implements a `PrintQueueManager` class that simulates a basic print queue system, fulfilling all the requirements of the exam task.
 * 
 * 1.  **`PrintJob` Class:** This simple class encapsulates the data for a single print job (`jobId` and `pages`). Fields are `private` for encapsulation. The constructor includes input validation for `pages`, throwing an `IllegalArgumentException` if the page count is non-positive, which is caught later in the `submitJob` method. The `toString()` method provides a convenient way to display job information.
 * 
 * 2.  **`PrintQueueManager` Class:**
 *     *   **Data Structures:**
 *         *   `pendingJobs`: Declared as `Queue<PrintJob>` and initialized with `new LinkedList<>()`. This correctly uses the `Queue` interface type while using a concrete `LinkedList` implementation, which is suitable for queue operations (`offer` for adding, `poll` for removing from the head).
 *         *   `completedJobs`: Declared as `List<PrintJob>` and initialized with `new ArrayList<>()`. This uses the `List` interface type, demonstrating good practice, while using the `ArrayList` implementation for dynamic storage of completed jobs.
 *     *   **`Scanner`:** An instance of `Scanner` is created to read user input. It's a class member so it can be used across different methods. It's closed in the `finally` block of the `start` method to release system resources.
 *     *   **`start()` Method:** This method contains the main application loop (`while(running)`).
 *         *   It calls `displayMenu()` to show options.
 *         *   It reads the user's choice using `scanner.nextLine()` to avoid common issues with `nextInt()` followed by `nextLine()`.
 *         *   A nested `try-catch` attempts to parse the input string into an integer. A `NumberFormatException` is anticipated here.
 *         *   The `switch` statement handles the parsed integer choice, calling the appropriate private methods for each option. The `default` case handles invalid integer inputs or non-integer inputs that caused a `NumberFormatException`.
 *         *   **Class-wide `try-catch`:** The entire `while` loop and initial setup within the `start` method are wrapped in a `try-catch(Exception e)` block. This serves as the class-wide handler, catching any unexpected runtime exceptions that might occur *anywhere* within the main execution flow and printing an error to `System.err` before the program potentially terminates or attempts to continue if possible.
 *         *   **`finally` Block:** Ensures `scanner.close()` is called regardless of whether an exception occurred or the loop exited normally.
 *     *   **`submitJob()`:** Prompts for Job ID and pages. It reads the page count as a string and uses `Integer.parseInt()` within a `try-catch` block to handle potential `NumberFormatException`. It also wraps the `PrintJob` constructor call in the same `try-catch` to catch the `IllegalArgumentException` thrown if pages <= 0. Error messages are printed to `System.err`. If successful, the job is added to `pendingJobs` using `offer()`.
 *     *   **`processNextJob()`:** Uses `pendingJobs.poll()` to get and remove the next job. It checks if the result is `null` (meaning the queue was empty) and prints an error to `System.err` if so. Otherwise, it prints a processing message to `System.out` and adds the job to `completedJobs` using `add()`.
 *     *   **`viewPendingQueue()` and `viewCompletedHistory()`:** These methods check if the respective data structure is empty, printing an error to `System.err` if it is. Otherwise, they iterate through the collection (using enhanced for loops) and print each job's details using its `toString()` method to `System.out`. Iterating the `Queue` directly provides a snapshot without removing elements.
 *     *   **`displayMenu()`:** A simple helper method to print the menu options to `System.out`.
 *     *   **`main()`:** The entry point creates an instance of `PrintQueueManager` and calls its `start()` method.
 * 
 * This solution effectively demonstrates the required Java components and best practices in a practical scenario, including structured error handling with both specific and class-wide `try-catch` blocks and appropriate use of `System.out` and `System.err`.
 */

import java.util.Queue;
import java.util.LinkedList; // Common Queue implementation
import java.util.List;
import java.util.ArrayList; // Common List implementation
import java.util.Scanner;
import java.util.InputMismatchException; // Useful for specific input issues

// Represents a single print job
class PrintJob {
    private String jobId;
    private int pages;

    /**
     * Constructs a new PrintJob.
     *
     * @param jobId The unique identifier for the job.
     * @param pages The number of pages in the job. Must be positive.
     * @throws IllegalArgumentException if pages is not positive.
     */
    public PrintJob(String jobId, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Number of pages must be positive.");
        }
        this.jobId = jobId;
        this.pages = pages;
    }

    public String getJobId() {
        return jobId;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId + ", Pages: " + pages;
    }
}

// Manages the print queue and completed jobs history
public class PrintQueueManager {
    // Queue for jobs waiting to be processed (FIFO)
    private Queue<PrintJob> pendingJobs;
    // List for jobs that have been completed
    private List<PrintJob> completedJobs;
    // Scanner for user input
    private Scanner scanner;

    /**
     * Constructs a new PrintQueueManager.
     * Initializes the queue, list, and scanner.
     */
    public PrintQueueManager() {
        // Use LinkedList as a Queue implementation
        this.pendingJobs = new LinkedList<>();
        // Use ArrayList as a List implementation for history
        this.completedJobs = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Starts the main application loop, handling user interaction.
     * Includes class-wide exception handling.
     */
    public void start() {
        boolean running = true;
        System.out.println("--- Print Queue Management System ---");

        // Class-wide try-catch block to catch unexpected exceptions
        try {
            while (running) {
                displayMenu();
                System.out.print("Enter your choice: ");

                // Read the entire line to avoid issues with nextInt() and nextLine()
                String choiceStr = scanner.nextLine();
                int choice = -1; // Default invalid choice

                try {
                    choice = Integer.parseInt(choiceStr);
                } catch (NumberFormatException e) {
                    // Handled by the switch's default case
                }

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1:
                        submitJob();
                        break;
                    case 2:
                        processNextJob();
                        break;
                    case 3:
                        viewPendingQueue();
                        break;
                    case 4:
                        viewCompletedHistory();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                System.out.println(); // Add a newline for better readability
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions during runtime
            System.err.println("An unexpected system error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
            // Ensure the scanner is closed when the application exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Displays the main menu options to the console.
     */
    private void displayMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Submit New Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. View Pending Queue");
        System.out.println("4. View Completed History");
        System.out.println("5. Exit");
    }

    /**
     * Prompts the user for job details and adds a new job to the queue.
     * Includes input validation and specific exception handling for parsing.
     */
    private void submitJob() {
        System.out.println("--- Submit New Job ---");
        System.out.print("Enter Job ID: ");
        String jobId = scanner.nextLine();

        System.out.print("Enter Number of Pages: ");
        String pagesStr = scanner.nextLine();
        int pages = -1; // Default invalid value

        try {
            pages = Integer.parseInt(pagesStr);
            // Input validation for pages
            PrintJob newJob = new PrintJob(jobId, pages); // PrintJob constructor validates pages > 0
            pendingJobs.offer(newJob); // Add job to the queue
            System.out.println("Job '" + jobId + "' submitted successfully.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format for pages. Please enter an integer.");
        } catch (IllegalArgumentException e) {
            // Catches the exception thrown by PrintJob constructor for pages <= 0
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
             // Catch any other unexpected exception during submission
             System.err.println("An error occurred during job submission: " + e.getMessage());
             e.printStackTrace(System.err);
        }
    }

    /**
     * Processes the next job from the pending queue and moves it to history.
     * Handles the case where the queue is empty.
     */
    private void processNextJob() {
        System.out.println("--- Process Next Job ---");
        PrintJob jobToProcess = pendingJobs.poll(); // Retrieve and remove the head of the queue

        if (jobToProcess != null) {
            System.out.println("Processing: " + jobToProcess);
            completedJobs.add(jobToProcess); // Add to the completed list
            System.out.println("Job '" + jobToProcess.getJobId() + "' completed.");
        } else {
            System.err.println("Error: The pending queue is empty. No jobs to process.");
        }
    }

    /**
     * Displays all jobs currently in the pending queue.
     * Handles the case where the queue is empty.
     */
    private void viewPendingQueue() {
        System.out.println("--- Pending Print Queue ---");
        if (pendingJobs.isEmpty()) {
            System.err.println("The pending queue is currently empty.");
        } else {
            // Iterate through the queue without removing elements
            int index = 1;
            for (PrintJob job : pendingJobs) {
                System.out.println(index++ + ". " + job);
            }
        }
    }

    /**
     * Displays all jobs in the completed history list.
     * Handles the case where the history is empty.
     */
    private void viewCompletedHistory() {
        System.out.println("--- Completed Jobs History ---");
        if (completedJobs.isEmpty()) {
            System.err.println("The completed jobs history is currently empty.");
        } else {
            // Iterate through the list
            int index = 1;
            for (PrintJob job : completedJobs) {
                System.out.println(index++ + ". " + job);
            }
        }
    }

    /**
     * Main method to run the PrintQueueManager application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        PrintQueueManager manager = new PrintQueueManager();
        manager.start();
    }
}
