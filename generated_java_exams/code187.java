/*
 * Exam Question #187
 * Generated on: 2025-05-11 22:28:25
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Print Job Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application to simulate a print job management system. The system should allow users to submit print jobs, view the queue of waiting jobs, process the next job, and view a history of completed jobs.
 * 
 * **Requirements:**
 * 
 * Implement a Java program consisting of at least two classes: `PrintJob` and `PrintJobManager`.
 * 
 * 1.  **`PrintJob` Class:**
 *     *   Represent a single print job.
 *     *   Must have private fields: `jobId` (int, unique identifier), `description` (String), and `priority` (int).
 *     *   Provide a constructor to initialize these fields.
 *     *   Include public getter methods for all fields.
 *     *   Override the `toString()` method to provide a user-friendly representation of the print job (e.g., "Job ID: [id], Description: [desc], Priority: [prio]").
 * 
 * 2.  **`PrintJobManager` Class:**
 *     *   Manage the print jobs.
 *     *   Must use a `java.util.Queue<PrintJob>` to store jobs waiting to be processed.
 *     *   Must use a `java.util.List<PrintJob>` (specifically an `ArrayList`) to store completed jobs.
 *     *   Maintain a counter for assigning unique `jobId`s.
 *     *   Implement the following functionalities via a command-line menu driven by a `java.util.Scanner`:
 *         *   **1. Submit New Job:**
 *             *   Prompt the user for a job description (String).
 *             *   Prompt the user for a priority level (integer).
 *             *   Validate the priority: it must be a positive integer (> 0). If invalid, print an error message to `System.err` and do not add the job.
 *             *   Create a new `PrintJob` object with a unique ID and the provided details.
 *             *   Add the new job to the print queue.
 *             *   Print a success message to `System.out`.
 *         *   **2. Process Next Job:**
 *             *   Attempt to remove and process the job at the front of the queue.
 *             *   If the queue is empty, print an error message to `System.err`.
 *             *   If a job is successfully processed, remove it from the queue, add it to the list of completed jobs, and print a success message including the processed job's details to `System.out`.
 *         *   **3. View Print Queue:**
 *             *   Display the details of all jobs currently in the queue to `System.out`.
 *             *   If the queue is empty, print a message indicating that the queue is empty to `System.out`.
 *         *   **4. View Completed Jobs:**
 *             *   Display the details of all jobs in the completed jobs list to `System.out`.
 *             *   If the list is empty, print a message indicating that no jobs have been completed yet to `System.out`.
 *         *   **5. Exit:** Terminate the program.
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Implement class-wide exception handling using `try-catch` blocks, specifically to handle potential `InputMismatchException` when reading integer inputs from the `Scanner` (e.g., menu choice, job priority) and any other unexpected errors. Print error messages to `System.err`.
 *     *   Use `System.out` for all normal output (menu, prompts, success messages, list/queue contents).
 *     *   Use `System.err` exclusively for error messages (invalid input, empty queue processing, general exceptions).
 * 
 * **General Requirements:**
 * 
 * *   Adhere to Java best practices:
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (Javadocs for classes/methods are encouraged but not strictly required if code is clear).
 *     *   Clean code structure.
 * *   The program should run continuously, presenting the menu after each operation until the user chooses to exit.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt for input based on the selection, and provide output/error messages as specified. Example interactions might look like:
 * 
 * ```
 * --- Print Job Manager Menu ---
 * 1. Submit New Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 1
 * Enter job description: Report for meeting
 * Enter priority (positive integer): 5
 * Job submitted: Job ID: 1, Description: Report for meeting, Priority: 5
 * 
 * --- Print Job Manager Menu ---
 * 1. Submit New Job
 * 2. Process Next Job
 * 3. View Print Queue
 * 4. View Completed Jobs
 * 5. Exit
 * Enter your choice: 3
 * --- Print Queue ---
 * Job ID: 1, Description: Report for meeting, Priority: 5
 * 
 * --- Print Job Manager Menu ---
 * ...
 * Enter your choice: 2
 * Processing job: Job ID: 1, Description: Report for meeting, Priority: 5
 * Job ID 1 completed.
 * 
 * --- Print Job Manager Menu ---
 * ...
 * Enter your choice: 2
 * Error: The print queue is empty. No job to process.
 * ```
 * *(Note: Error messages should go to System.err)*
 * 
 * Your solution should be a single `.java` file containing both classes or separate files if preferred, but provide the complete code.
 *
 * EXPLANATION:
 * This solution implements a `PrintJobManager` system as described in the problem statement, effectively utilizing all required Java components and adhering to best practices.
 * 
 * 1.  **`PrintJob` Class:** This class is a simple Plain Old Java Object (POJO) representing a print job. It encapsulates the job's data (`jobId`, `description`, `priority`) using private fields and provides public getter methods. The `toString()` method is overridden for easy printing of job details.
 * 
 * 2.  **`PrintJobManager` Class:** This is the core class managing the system logic.
 *     *   **Data Structures:** It correctly uses a `java.util.Queue<PrintJob>` (`LinkedList` implementation) for the `printQueue` to manage jobs in a First-In, First-Out (FIFO) manner (or similar depending on Queue implementation, but `LinkedList` works as a Queue). It uses a `java.util.List<PrintJob>` (`ArrayList` implementation) for `completedJobs` to store processed jobs.
 *     *   **`Scanner`:** A `Scanner` instance is created once and used throughout the `run` method and helper methods (`submitNewJob`) to read user input from the console. It's closed when the application exits.
 *     *   **`nextJobId`:** An integer counter ensures that each submitted job gets a unique ID.
 *     *   **Menu and `switch`:** The `run` method displays a menu (`displayMenu`) and uses a `while` loop to keep the application running until the user chooses to exit. A `switch` statement handles the user's integer choice, directing execution to the appropriate method (`submitNewJob`, `processNextJob`, etc.).
 *     *   **`submitNewJob` Method:** Prompts for and reads the job description and priority. It includes input validation for the priority (must be positive) and uses a `try-catch` block specifically around reading the priority integer to handle `InputMismatchException` if the user enters non-numeric input. After successful input and validation, a new `PrintJob` is created and added to the `printQueue` using `add()`.
 *     *   **`processNextJob` Method:** Checks if the `printQueue` is empty using `isEmpty()`. If empty, it prints an error to `System.err`. If not empty, it uses `poll()` to remove the job from the front of the queue and then adds it to the `completedJobs` list using `add()`.
 *     *   **`viewPrintQueue` and `viewCompletedJobs` Methods:** These methods iterate through the respective collections (`printQueue` and `completedJobs`) and print the details of each job using the `PrintJob`'s `toString()` method. They also handle the case where the collections are empty. Iterating the `Queue` is done safely using `forEach` or an iterator without removing elements.
 *     *   **Exception Handling (`try-catch`):** The main `run` loop incorporates a `try-catch` block.
 *         *   It catches `InputMismatchException` specifically when reading the main menu choice using `scanner.nextInt()`. This prevents the program from crashing if the user enters text instead of a number. Inside the catch block, an error message is printed to `System.err`, and `scanner.nextLine()` is called to consume the invalid input line, preventing an infinite loop.
 *         *   A general `catch (Exception e)` is included to catch any other unexpected runtime errors that might occur, printing their message to `System.err`.
 *         *   Additionally, the `submitNewJob` method has its own `try-catch` for reading the priority integer, demonstrating localized input validation error handling.
 *     *   **`System.out` and `System.err`:** Normal output (menu, prompts, success messages, list/queue contents) is directed to `System.out`. All error messages (invalid input, empty queue, general exceptions) are directed to `System.err` as required.
 *     *   **Best Practices:** The code uses meaningful names for variables and methods. Fields are private with public getters (`PrintJob`). The `Scanner` is managed correctly. The logic is separated into distinct methods for clarity. Comments explain the purpose of classes and methods.
 * 
 * This solution demonstrates a solid understanding of basic data structures (`Queue`, `List`/`ArrayList`), user input handling (`Scanner`), control flow (`switch`, loops), object-oriented principles (encapsulation, classes), and essential error handling techniques (`try-catch`, input validation, `System.err`).
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a single print job
class PrintJob {
    private int jobId;
    private String description;
    private int priority;

    /**
     * Constructs a new PrintJob.
     * @param jobId The unique identifier for the job.
     * @param description A description of the job.
     * @param priority The priority level of the job (positive integer).
     */
    public PrintJob(int jobId, String description, int priority) {
        this.jobId = jobId;
        this.description = description;
        this.priority = priority;
    }

    // --- Getters ---
    public int getJobId() {
        return jobId;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * Returns a string representation of the PrintJob.
     * @return Formatted string including job details.
     */
    @Override
    public String toString() {
        return "Job ID: " + jobId + ", Description: " + description + ", Priority: " + priority;
    }
}

// Manages the print job queue and completed jobs list
public class PrintJobManager {
    // Queue for jobs waiting to be processed
    private Queue<PrintJob> printQueue;
    // List for jobs that have been completed
    private List<PrintJob> completedJobs;
    // Counter for assigning unique job IDs
    private int nextJobId;
    // Scanner for reading user input
    private Scanner scanner;

    /**
     * Constructs a new PrintJobManager.
     * Initializes the queue, list, job ID counter, and scanner.
     */
    public PrintJobManager() {
        this.printQueue = new LinkedList<>(); // LinkedList implements Queue
        this.completedJobs = new ArrayList<>(); // ArrayList implements List
        this.nextJobId = 1;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options to the console.
     */
    private void displayMenu() {
        System.out.println("\n--- Print Job Manager Menu ---");
        System.out.println("1. Submit New Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. View Print Queue");
        System.out.println("4. View Completed Jobs");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Submits a new print job based on user input.
     * Handles input for description and priority, validates priority,
     * and adds the job to the queue.
     */
    private void submitNewJob() {
        System.out.print("Enter job description: ");
        String description = scanner.nextLine();

        int priority = -1; // Use -1 as an invalid initial value
        System.out.print("Enter priority (positive integer): ");
        try {
            priority = scanner.nextInt();
            // Consume the rest of the line after reading the integer
            scanner.nextLine(); 
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input for priority. Please enter a positive integer.");
            // Consume the invalid input to prevent infinite loop
            scanner.nextLine(); 
            return; // Exit the method if input is invalid
        }

        // Validate priority
        if (priority <= 0) {
            System.err.println("Error: Priority must be a positive integer (> 0).");
            return; // Exit the method if validation fails
        }

        // Create and add the job
        PrintJob newJob = new PrintJob(nextJobId++, description, priority);
        printQueue.add(newJob);
        System.out.println("Job submitted: " + newJob);
    }

    /**
     * Processes the next job in the queue.
     * Removes the job from the front of the queue and adds it to the completed list.
     * Handles the case where the queue is empty.
     */
    private void processNextJob() {
        if (printQueue.isEmpty()) {
            System.err.println("Error: The print queue is empty. No job to process.");
            return;
        }

        PrintJob processedJob = printQueue.poll(); // Removes and returns the head of the queue
        completedJobs.add(processedJob); // Add to the list of completed jobs
        System.out.println("Processing job: " + processedJob);
        System.out.println("Job ID " + processedJob.getJobId() + " completed.");
    }

    /**
     * Displays the current jobs in the print queue.
     */
    private void viewPrintQueue() {
        System.out.println("\n--- Print Queue ---");
        if (printQueue.isEmpty()) {
            System.out.println("The print queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            printQueue.forEach(System.out::println);
        }
    }

    /**
     * Displays the list of completed jobs.
     */
    private void viewCompletedJobs() {
        System.out.println("\n--- Completed Jobs ---");
        if (completedJobs.isEmpty()) {
            System.out.println("No jobs have been completed yet.");
        } else {
            // Iterate through the list
            completedJobs.forEach(System.out::println);
        }
    }

    /**
     * Runs the main application loop, handling user interaction.
     * Includes try-catch blocks for robust input handling.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();

            try {
                int choice = scanner.nextInt();
                // Consume the newline character left by nextInt()
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        submitNewJob();
                        break;
                    case 2:
                        processNextJob();
                        break;
                    case 3:
                        viewPrintQueue();
                        break;
                    case 4:
                        viewCompletedJobs();
                        break;
                    case 5:
                        System.out.println("Exiting Print Job Manager. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handles non-integer input for the menu choice
                System.err.println("Error: Invalid input. Please enter a number.");
                // Consume the invalid input to prevent infinite loop
                scanner.nextLine(); 
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // Optional: e.printStackTrace(); for debugging
            }
        }
        // Close the scanner when the application exits
        scanner.close();
    }

    /**
     * Main method to start the Print Job Manager application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        PrintJobManager manager = new PrintJobManager();
        manager.run();
    }
}
