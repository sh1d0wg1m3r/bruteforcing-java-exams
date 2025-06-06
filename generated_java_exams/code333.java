/*
 * Exam Question #333
 * Generated on: 2025-05-11 22:56:40
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Print Job Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified Print Job Management System for a small office. The system needs to manage a queue of print jobs waiting to be processed and keep a record of completed jobs. Users should be able to add new jobs, process the next job in the queue, view the current queue, view the history of completed jobs, and exit the system.
 * 
 * **Requirements:**
 * 
 * 1.  **Core Data Structures:**
 *     *   Use a `java.util.Queue` to represent the waiting print jobs. Jobs should be processed in a First-In, First-Out (FIFO) manner.
 *     *   Use a `java.util.ArrayList` to store the history of completed print jobs.
 *     *   Declare the completed jobs history using the `java.util.List` interface type.
 * 
 * 2.  **PrintJob Class:**
 *     *   Create a class named `PrintJob` to represent a single print job.
 *     *   It should have private fields: `jobId` (an integer, automatically generated), `fileName` (String), and `pages` (integer).
 *     *   Provide a public constructor to initialize `fileName` and `pages`. The `jobId` should be assigned internally (e.g., using a static counter or passed from the manager).
 *     *   Provide public getter methods for `jobId`, `fileName`, and `pages`.
 *     *   Override the `toString()` method to provide a user-friendly representation of a job (e.g., "Job ID: X, File: Y, Pages: Z").
 * 
 * 3.  **PrintManager Class:**
 *     *   Create a class named `PrintManager` to handle the print queue and completed jobs.
 *     *   It should have private fields: a `Queue<PrintJob>` for the waiting queue and a `List<PrintJob>` for completed jobs.
 *     *   Include a private counter for generating unique job IDs.
 *     *   Provide a public constructor to initialize the queue and the list.
 *     *   Implement the following public methods:
 *         *   `addJob(String fileName, int pages)`: Creates a new `PrintJob` with a unique ID and adds it to the waiting queue. Validate that `pages` is a positive integer. If not, print an error using `System.err` and do not add the job.
 *         *   `processNextJob()`: Removes the job at the front of the queue, adds it to the completed jobs list, and prints a success message using `System.out`. If the queue is empty, print an error message using `System.err`.
 *         *   `viewPrintQueue()`: Prints the details of all jobs currently in the waiting queue using `System.out`. If the queue is empty, print a message indicating that.
 *         *   `viewCompletedJobs()`: Prints the details of all jobs in the completed jobs history using `System.out`. If the history is empty, print a message indicating that.
 *         *   Include any necessary helper methods (e.g., for getting queue size, history size).
 * 
 * 4.  **Main Application Class (`PrintSystem`):**
 *     *   Create a class named `PrintSystem` with a `main` method.
 *     *   Inside `main`, create a `Scanner` object for reading user input and a `PrintManager` object.
 *     *   Implement a loop that presents the user with a menu of options:
 *         1.  Add New Print Job
 *         2.  Process Next Job
 *         3.  View Print Queue
 *         4.  View Completed Jobs
 *         5.  Exit
 *     *   Use a `switch` statement to handle the user's choice.
 *     *   For option 1, prompt the user for the file name and number of pages, then call `printManager.addJob()`. Handle potential non-integer input for pages using `try-catch` and print an error using `System.err`.
 *     *   For options 2, 3, and 4, call the corresponding `printManager` methods.
 *     *   For option 5, exit the loop.
 *     *   Include a default case in the `switch` statement for invalid menu choices, printing an error using `System.err`.
 *     *   Implement robust exception handling (`try-catch` blocks) around user input reading and critical operations to prevent the program from crashing. Handle specific exceptions like `InputMismatchException` and general `Exception`. Print error details to `System.err`.
 *     *   Ensure proper use of `System.out` for normal output (menu, prompts, success messages, job lists) and `System.err` for error messages.
 *     *   Close the `Scanner` resource properly.
 * 
 * 5.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include comments to explain complex logic.
 *     *   Ensure proper encapsulation (private fields, public methods).
 *     *   Validate user input where necessary.
 * 
 * **Expected Output:**
 * 
 * The program should interact with the user via the console, displaying a menu, prompting for input, and printing status or job details. Error messages for invalid input or operations should go to `System.err`.
 * 
 * ```
 * --- Print Job Management System ---
 * Menu:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 1
 * Enter file name: report.pdf
 * Enter number of pages: 15
 * Job added: Job ID: 1, File: report.pdf, Pages: 15
 * 
 * --- Print Job Management System ---
 * Menu:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 3
 * --- Current Print Queue ---
 * Job ID: 1, File: report.pdf, Pages: 15
 * 
 * --- Print Job Management System ---
 * Menu:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 2
 * Processing job: Job ID: 1, File: report.pdf, Pages: 15
 * Job processed successfully.
 * 
 * --- Print Job Management System ---
 * Menu:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 3
 * --- Current Print Queue ---
 * Queue is empty.
 * 
 * --- Print Job Management System ---
 * Menu:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 4
 * --- Completed Jobs History ---
 * Job ID: 1, File: report.pdf, Pages: 15
 * 
 * --- Print Job Management System ---
 * Menu:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: invalid
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * 
 * --- Print Job Management System ---
 * Menu:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 1
 * Enter file name: presentation.pptx
 * Enter number of pages: -5
 * Error: Number of pages must be positive. Job not added.
 * 
 * --- Print Job Management System ---
 * Menu:
 * 1. Add New Print Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 5
 * Exiting Print Job Management System.
 * ```
 * (Note: Error messages like "Error: Invalid choice..." or "Error: Number of pages..." should appear on System.err)
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation and usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch`.
 * *   Proper class design (`PrintJob`, `PrintManager`) with encapsulation.
 * *   Effective handling of user input and validation.
 * *   Appropriate error handling and reporting using `System.err`.
 * *   Clear and correct output formatting using `System.out`.
 * *   Code readability, comments, and adherence to best practices.
 * 
 * This task requires integrating multiple core Java concepts to build a functional system, simulating a real-world scenario with user interaction and error handling.
 *
 * EXPLANATION:
 * This solution implements a Print Job Management System demonstrating the required Java concepts.
 * 
 * **1. PrintJob Class:**
 * *   This class is a simple Plain Old Java Object (POJO) representing a data entity.
 * *   It uses `private` fields (`jobId`, `fileName`, `pages`) to enforce encapsulation.
 * *   Public getter methods provide controlled access to the data.
 * *   The `toString()` method is overridden for easy printing of job details.
 * 
 * **2. PrintManager Class:**
 * *   This class encapsulates the core logic of the system.
 * *   `private Queue<PrintJob> printQueue`: A `LinkedList` is used to implement the `Queue` interface, providing FIFO behavior for waiting jobs.
 * *   `private List<PrintJob> completedJobs`: An `ArrayList` is used to store completed jobs, and it's declared using the `List` interface type, demonstrating polymorphism and good practice.
 * *   `private int nextJobId`: A simple counter to ensure unique IDs for each job.
 * *   `addJob(String fileName, int pages)`: Creates a `PrintJob` and adds it to the `printQueue` using `queue.add()`. Includes input validation for `pages`, printing an error to `System.err` if invalid.
 * *   `processNextJob()`: Uses `queue.poll()` to retrieve and remove the head of the queue. If the queue is empty, `poll()` returns `null`, which is handled by checking `queue.isEmpty()` first, printing an error to `System.err`. The processed job is then added to the `completedJobs` list using `list.add()`.
 * *   `viewPrintQueue()` and `viewCompletedJobs()`: Iterate through the respective collections (`queue` and `list`) and print details using `System.out`. They check if the collections are empty before attempting to iterate. `printQueue.forEach()` iterates without removing elements from the queue.
 * 
 * **3. PrintSystem Class (Main Application):**
 * *   The `main` method drives the application.
 * *   `Scanner scanner = new Scanner(System.in)`: Used to read input from the console. It's placed within a try-with-resources block to ensure it's automatically closed, preventing resource leaks.
 * *   `PrintManager printManager = new PrintManager()`: An instance of the manager is created.
 * *   A `while(running)` loop keeps the application running until the user chooses to exit.
 * *   `displayMenu()`: A helper method to print the menu options to `System.out`.
 * *   `try-catch` blocks are used for exception handling:
 *     *   An inner `try-catch(InputMismatchException e)` specifically handles cases where the user enters non-integer input when a number is expected (e.g., for menu choice or pages). An error is printed to `System.err`, and `scanner.nextLine()` is called to consume the invalid input, preventing an infinite loop.
 *     *   A general `catch(Exception e)` is included to catch any other unexpected runtime errors that might occur within the loop, printing a generic error message to `System.err`.
 *     *   The outer `try-catch` around the `Scanner` initialization handles potential issues during setup.
 * *   `scanner.nextInt()` reads an integer, and `scanner.nextLine()` is called immediately after in cases where `nextInt()` is used, to consume the leftover newline character before the next call to `scanner.nextLine()`.
 * *   A `switch(choice)` statement is used for flow control, directing the program based on the valid integer input received from the user. Each case calls the appropriate method in the `PrintManager`.
 * *   `System.out.println()` is used for all normal output, including the menu, prompts, confirmation messages, and job lists.
 * *   `System.err.println()` is used exclusively for printing error messages, making them distinguishable from normal output.
 * 
 * This solution effectively integrates the required Java components within a structured, object-oriented design, handles user interaction, performs input validation, and includes basic error handling, fulfilling the requirements of the complex exam task.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a single print job
class PrintJob {
    private int jobId;
    private String fileName;
    private int pages;

    /**
     * Constructs a new PrintJob.
     * @param jobId The unique ID for the job.
     * @param fileName The name of the file to print.
     * @param pages The number of pages in the file.
     */
    public PrintJob(int jobId, String fileName, int pages) {
        this.jobId = jobId;
        this.fileName = fileName;
        this.pages = pages;
    }

    // Getters for job properties
    public int getJobId() {
        return jobId;
    }

    public String getFileName() {
        return fileName;
    }

    public int getPages() {
        return pages;
    }

    /**
     * Provides a string representation of the PrintJob.
     * @return Formatted string describing the job.
     */
    @Override
    public String toString() {
        return "Job ID: " + jobId + ", File: " + fileName + ", Pages: " + pages;
    }
}

// Manages the print queue and completed jobs history
class PrintManager {
    private Queue<PrintJob> printQueue;
    private List<PrintJob> completedJobs; // Using List interface type
    private int nextJobId; // Counter for unique job IDs

    /**
     * Constructs a new PrintManager.
     */
    public PrintManager() {
        // Initialize the queue using LinkedList
        this.printQueue = new LinkedList<>();
        // Initialize the completed jobs list using ArrayList
        this.completedJobs = new ArrayList<>();
        this.nextJobId = 1; // Start job IDs from 1
    }

    /**
     * Adds a new print job to the queue.
     * @param fileName The name of the file.
     * @param pages The number of pages.
     */
    public void addJob(String fileName, int pages) {
        if (pages <= 0) {
            System.err.println("Error: Number of pages must be positive. Job not added.");
            return;
        }
        PrintJob newJob = new PrintJob(nextJobId++, fileName, pages);
        printQueue.add(newJob);
        System.out.println("Job added: " + newJob);
    }

    /**
     * Processes the next job in the queue (FIFO).
     */
    public void processNextJob() {
        if (printQueue.isEmpty()) {
            System.err.println("Error: Print queue is empty. Cannot process job.");
            return;
        }
        PrintJob processedJob = printQueue.poll(); // Remove and retrieve the head of the queue
        if (processedJob != null) {
            completedJobs.add(processedJob); // Add to completed list
            System.out.println("Processing job: " + processedJob);
            System.out.println("Job processed successfully.");
        }
        // Note: poll() returns null if queue is empty, but we already checked isEmpty(),
        // so processedJob should not be null here in a correct flow.
    }

    /**
     * Displays the current jobs in the waiting queue.
     */
    public void viewPrintQueue() {
        System.out.println("--- Current Print Queue ---");
        if (printQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            printQueue.forEach(System.out::println);
        }
    }

    /**
     * Displays the history of completed jobs.
     */
    public void viewCompletedJobs() {
        System.out.println("--- Completed Jobs History ---");
        if (completedJobs.isEmpty()) {
            System.out.println("No jobs completed yet.");
        } else {
            // Iterate through the completed jobs list
            completedJobs.forEach(System.out::println);
        }
    }

    /**
     * Gets the current number of jobs in the queue.
     * @return The number of jobs waiting.
     */
    public int getQueueSize() {
        return printQueue.size();
    }

    /**
     * Gets the current number of completed jobs.
     * @return The number of completed jobs.
     */
    public int getCompletedCount() {
        return completedJobs.size();
    }
}

// Main application class
public class PrintSystem {

    public static void main(String[] args) {
        // Use try-with-resources for the Scanner to ensure it's closed
        try (Scanner scanner = new Scanner(System.in)) {
            PrintManager printManager = new PrintManager();
            boolean running = true;

            System.out.println("--- Print Job Management System ---");

            while (running) {
                displayMenu();
                System.out.print("Enter your choice: ");

                int choice = -1; // Default invalid choice

                try {
                    // Attempt to read an integer choice
                    choice = scanner.nextInt();
                    // Consume the newline character left by nextInt()
                    scanner.nextLine();

                    // Use switch statement for main menu flow control
                    switch (choice) {
                        case 1: // Add New Print Job
                            System.out.print("Enter file name: ");
                            String fileName = scanner.nextLine();
                            System.out.print("Enter number of pages: ");
                            int pages = scanner.nextInt();
                            // Consume newline after reading pages
                            scanner.nextLine();
                            printManager.addJob(fileName, pages);
                            break;
                        case 2: // Process Next Job
                            printManager.processNextJob();
                            break;
                        case 3: // View Print Queue
                            printManager.viewPrintQueue();
                            break;
                        case 4: // View Completed Jobs
                            printManager.viewCompletedJobs();
                            break;
                        case 5: // Exit
                            running = false;
                            System.out.println("Exiting Print Job Management System.");
                            break;
                        default: // Invalid choice
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                            break;
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input for the menu choice or pages
                    System.err.println("Error: Invalid input. Please enter a number.");
                    // Consume the invalid input to prevent an infinite loop
                    scanner.nextLine();
                } catch (Exception e) {
                    // Catch any other unexpected exceptions
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    // e.printStackTrace(System.err); // Optional: for debugging
                }
                System.out.println(); // Add a newline for better readability between cycles
            }

        } catch (Exception e) {
            // Catch any exception during Scanner initialization or closure
            System.err.println("An error occurred while setting up the system: " + e.getMessage());
            // e.printStackTrace(System.err); // Optional: for debugging
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add New Print Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. View Print Queue");
        System.out.println("4. View Completed Jobs");
        System.out.println("5. Exit");
    }
}
