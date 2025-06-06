/*
 * Exam Question #350
 * Generated on: 2025-05-11 22:58:59
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Print Job Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application to manage print jobs in a small office. The system should handle print jobs by placing them in a queue, processing them one by one in the order they were received, and maintaining a history of completed jobs.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that fulfills the following requirements:
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to represent the waiting print jobs. Jobs should be processed in First-In, First-Out (FIFO) order.
 *     *   Use a `java.util.ArrayList` to store the history of completed print jobs.
 *     *   Declare variables holding the completed jobs using the `java.util.List` interface.
 * 
 * 2.  **User Interface:**
 *     *   Provide a command-line menu using `System.out` for the user to interact with the system. The menu should include options to:
 *         *   Add a new print job.
 *         *   Process the next job in the queue.
 *         *   View the current job queue.
 *         *   View the history of completed jobs.
 *         *   Exit the application.
 *     *   Use `java.util.Scanner` to read user input (menu choices and job details).
 * 
 * 3.  **Functionality:**
 *     *   **Add Job:** Prompt the user for the size (e.g., number of pages) of the new job. Create a `PrintJob` object (you'll need to define this class) with a unique ID and the specified size. Add the job to the queue. Validate that the job size is a positive integer; use `System.err` for validation errors.
 *     *   **Process Job:** Remove the next job from the head of the queue. If the queue is empty, inform the user using `System.out`. If a job is processed, move it to the list of completed jobs and confirm processing using `System.out`.
 *     *   **View Queue:** Display the jobs currently waiting in the queue using `System.out`. If the queue is empty, indicate this.
 *     *   **View History:** Display the list of completed jobs using `System.out`. If no jobs are completed, indicate this.
 *     *   **Exit:** Terminate the application.
 * 
 * 4.  **Error Handling:**
 *     *   Implement class-wide exception handling using a `try-catch` block around the main application loop to catch unexpected errors.
 *     *   Handle specific input errors (e.g., non-integer input for menu choice or job size) using `try-catch` and `System.err` to inform the user without crashing the application.
 *     *   Use `System.err` for all error messages and `System.out` for normal output (menu, prompts, status updates, list contents).
 * 
 * 5.  **Best Practices:**
 *     *   Design a separate class `PrintJob` to represent a print job with private fields (ID, size) and public getter methods. Include a `toString()` method for easy printing.
 *     *   Design a main class (e.g., `PrintJobManager`) that encapsulates the queue, completed jobs list, and scanner as private fields.
 *     *   Implement each menu option as a separate private method within the main class.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and basic documentation (e.g., Javadoc comments for classes and public methods).
 *     *   Use a `switch` statement to handle the different menu options based on user input.
 * 
 * **Expected Output:**
 * 
 * The output should be interactive, guiding the user through the options. Examples:
 * 
 * *   Adding a job:
 *     ```
 *     --- Print Job Management System ---
 *     ... menu ...
 *     Enter your choice: 1
 *     Enter job size (number of pages): 15
 *     Job added to queue: Job ID: 1, Size: 15 pages
 *     ```
 * *   Adding invalid job size:
 *     ```
 *     Enter job size (number of pages): -5
 *     Error: Job size must be positive.
 *     ```
 * *   Adding non-numeric input:
 *     ```
 *     Enter your choice: abc
 *     Error: Invalid input. Please enter a number.
 *     ```
 * *   Processing job when queue is empty:
 *     ```
 *     Enter your choice: 2
 *     The job queue is empty. No jobs to process.
 *     ```
 * *   Processing a job:
 *     ```
 *     Enter your choice: 2
 *     Processed job: Job ID: 1, Size: 15 pages
 *     ```
 * *   Viewing queue:
 *     ```
 *     Enter your choice: 3
 * 
 *     --- Current Job Queue ---
 *     1. Job ID: 2, Size: 20 pages
 *     2. Job ID: 3, Size: 5 pages
 *     -------------------------
 *     ```
 * *   Viewing history:
 *     ```
 *     Enter your choice: 4
 * 
 *     --- Completed Jobs History ---
 *     1. Job ID: 1, Size: 15 pages
 *     ----------------------------
 *     ```
 * 
 * Your solution should be a single Java file containing the `PrintJob` class and the main class with the `main` method.
 *
 * EXPLANATION:
 * This solution implements a `PrintJobManager` class that simulates a basic print job queuing system, fulfilling all the requirements of the exam task.
 * 
 * 1.  **`PrintJob` Class:**
 *     *   A simple class `PrintJob` is created to represent individual print jobs.
 *     *   It has private fields `id` (unique identifier) and `size` (number of pages).
 *     *   A static counter `nextId` ensures each new job gets a unique, sequential ID.
 *     *   Public getter methods (`getId`, `getSize`) provide controlled access to the data, adhering to encapsulation.
 *     *   A `toString()` method is overridden for easy printing of job details.
 * 
 * 2.  **`PrintJobManager` Class:**
 *     *   This is the main class containing the system logic.
 *     *   **Data Structures:**
 *         *   `private Queue<PrintJob> jobQueue;`: Declared using the `Queue` interface and initialized with `new LinkedList<>()`. `LinkedList` is a common implementation of `Queue` that provides FIFO behavior suitable for a job queue.
 *         *   `private List<PrintJob> completedJobs;`: Declared using the `List` interface and initialized with `new ArrayList<>()`. `ArrayList` is used to store the history of completed jobs in the order they were finished.
 *     *   **Scanner:**
 *         *   `private Scanner scanner;`: An instance of `Scanner` is used for all user input throughout the application.
 *     *   **Encapsulation:** All data members (`jobQueue`, `completedJobs`, `scanner`) are private. Methods are private where they are internal helpers (`displayMenu`, `addJob`, `processNextJob`, `viewQueue`, `viewHistory`) and public for the main entry point (`runSystem`) and the application start (`main`).
 *     *   **Methods:**
 *         *   `displayMenu()`: Prints the menu options to `System.out`.
 *         *   `addJob()`: Prompts for job size. Uses `scanner.nextInt()`. Includes validation to ensure size is positive, reporting errors via `System.err`. Creates a `PrintJob` and adds it to the `jobQueue` using `offer()`, which is the preferred method for adding to a queue. Includes a `try-catch` for `InputMismatchException` if the user enters non-integer input for the size.
 *         *   `processNextJob()`: Checks if the `jobQueue` is empty. If not, it uses `jobQueue.poll()` to retrieve and remove the job at the head of the queue. This job is then added to the `completedJobs` `ArrayList`. Status messages are printed to `System.out`.
 *         *   `viewQueue()`: Iterates through the `jobQueue` (without removing elements) and prints each job's details to `System.out`.
 *         *   `viewHistory()`: Iterates through the `completedJobs` `ArrayList` and prints each completed job's details to `System.out`.
 *         *   `runSystem()`: This method contains the main application loop (`while(running)`). It repeatedly displays the menu, reads the user's choice using `scanner.nextInt()`, consumes the leftover newline with `scanner.nextLine()`, and uses a `switch` statement to call the appropriate method based on the choice.
 *     *   **Error Handling:**
 *         *   A `try-catch (Exception e)` block wraps the entire `while` loop in `runSystem()`. This serves as the "class-wide" exception handling, catching any unhandled exceptions that might occur within the loop or called methods and preventing the program from crashing abruptly. It prints a critical error message to `System.err` and the stack trace.
 *         *   Specific `try-catch (InputMismatchException e)` blocks are used within `runSystem()` (around reading the menu choice) and `addJob()` (around reading job size) to handle cases where the user enters non-integer input. `System.err` is used for these specific input errors, and `scanner.nextLine()` or `scanner.next()` is called within the catch block to consume the invalid input and prevent an infinite loop.
 *         *   Input validation for positive job size is done with an `if` statement, reporting the error via `System.err`.
 *         *   Cases where the queue or history list is empty are handled with `if` checks, printing informative messages to `System.out`.
 *         *   A `finally` block in `runSystem()` ensures that the `Scanner` resource is closed when the application exits, preventing resource leaks.
 *     *   **Switch Statement:** Used effectively in `runSystem()` to direct program flow based on the user's menu choice.
 *     *   **`main` Method:** The standard entry point. It simply creates an instance of `PrintJobManager` and calls its `runSystem()` method to start the application.
 * 
 * This solution demonstrates the practical use of `Queue` for managing ordered tasks, `List` and `ArrayList` for storing collections, `Scanner` for user interaction, `switch` for menu control, and robust error handling using `try-catch` blocks and directed output (`System.out` vs. `System.err`), all while adhering to good object-oriented design principles like encapsulation.
 */

import java.util.Queue;
import java.util.LinkedList; // A common implementation of Queue
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single print job with a unique ID and size.
 */
class PrintJob {
    private static int nextId = 1; // Static counter for unique job IDs
    private int id;
    private int size; // Number of pages

    /**
     * Constructs a new PrintJob with a given size and assigns a unique ID.
     * @param size The number of pages in the print job. Must be positive.
     */
    public PrintJob(int size) {
        this.id = nextId++;
        this.size = size;
    }

    /**
     * Gets the unique ID of the print job.
     * @return The job ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the size (number of pages) of the print job.
     * @return The job size.
     */
    public int getSize() {
        return size;
    }

    /**
     * Provides a string representation of the print job.
     * @return A string describing the job ID and size.
     */
    @Override
    public String toString() {
        return "Job ID: " + id + ", Size: " + size + " pages";
    }
}

/**
 * Manages a queue of print jobs and a history of completed jobs.
 */
public class PrintJobManager {
    private Queue<PrintJob> jobQueue; // Queue for waiting jobs
    private List<PrintJob> completedJobs; // List for completed jobs
    private Scanner scanner; // Scanner for user input

    /**
     * Constructs a new PrintJobManager, initializing the queue, list, and scanner.
     */
    public PrintJobManager() {
        jobQueue = new LinkedList<>(); // LinkedList implements Queue
        completedJobs = new ArrayList<>(); // ArrayList implements List
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Print Job Management System ---");
        System.out.println("1. Add New Print Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. View Job Queue");
        System.out.println("4. View Completed Jobs History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Prompts the user for job size, creates a PrintJob, and adds it to the queue.
     * Handles invalid input and non-positive job size.
     */
    private void addJob() {
        try {
            System.out.print("Enter job size (number of pages): ");
            int size = scanner.nextInt();
            if (size <= 0) {
                System.err.println("Error: Job size must be positive.");
                return; // Exit the method if size is invalid
            }
            PrintJob newJob = new PrintJob(size);
            jobQueue.offer(newJob); // Use offer() for queues, returns false if unable to add (rare for LinkedList)
            System.out.println("Job added to queue: " + newJob);
        } catch (InputMismatchException e) {
            // Catch non-integer input specifically for job size
            System.err.println("Error: Invalid input. Please enter a number for job size.");
            scanner.next(); // Consume the invalid input to prevent infinite loop
        } catch (Exception e) {
            // Catch any other unexpected errors during job addition
            System.err.println("An unexpected error occurred while adding a job: " + e.getMessage());
        }
    }

    /**
     * Processes the next job at the head of the queue.
     * Removes the job from the queue and adds it to the completed jobs history.
     * Handles the case where the queue is empty.
     */
    private void processNextJob() {
        if (jobQueue.isEmpty()) {
            System.out.println("The job queue is empty. No jobs to process.");
        } else {
            PrintJob processedJob = jobQueue.poll(); // poll() retrieves and removes the head of the queue, returns null if empty
            completedJobs.add(processedJob); // Add the processed job to the history list
            System.out.println("Processed job: " + processedJob);
        }
    }

    /**
     * Displays the current jobs waiting in the queue without removing them.
     * Shows the jobs in their processing order.
     */
    private void viewQueue() {
        System.out.println("\n--- Current Job Queue ---");
        if (jobQueue.isEmpty()) {
            System.out.println("The job queue is empty.");
        } else {
            // Iterate through the queue elements. The order is maintained.
            int index = 1;
            for (PrintJob job : jobQueue) {
                System.out.println(index++ + ". " + job);
            }
        }
        System.out.println("-------------------------");
    }

    /**
     * Displays the history of all jobs that have been processed.
     */
    private void viewHistory() {
        System.out.println("\n--- Completed Jobs History ---");
        if (completedJobs.isEmpty()) {
            System.out.println("No jobs have been completed yet.");
        } else {
            // Iterate through the list of completed jobs
            for (int i = 0; i < completedJobs.size(); i++) {
                System.out.println((i + 1) + ". " + completedJobs.get(i));
            }
        }
        System.out.println("----------------------------");
    }

    /**
     * Runs the main application loop, displaying the menu and handling user input.
     * Includes the class-wide exception handling block.
     */
    public void runSystem() {
        boolean running = true;
        try { // Class-wide try block for the main application loop
            while (running) {
                displayMenu();
                try {
                    // Read user choice, handling potential non-integer input
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    // Use switch statement for menu navigation
                    switch (choice) {
                        case 1:
                            addJob();
                            break;
                        case 2:
                            processNextJob();
                            break;
                        case 3:
                            viewQueue();
                            break;
                        case 4:
                            viewHistory();
                            break;
                        case 5:
                            System.out.println("Exiting Print Job Management System. Goodbye!");
                            running = false; // Set flag to exit the loop
                            break;
                        default:
                            // Handle choices outside the valid range
                            System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    // Catch non-integer input specifically for the menu choice
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                }
                // Note: Other potential exceptions within methods are handled locally or bubble up
            }
        } catch (Exception e) { // Catch any other unexpected exception in the main system loop
            System.err.println("A critical error occurred in the system: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging critical errors
        } finally {
            // Ensure the scanner resource is closed when the application exits
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Scanner closed."); // Optional: Confirmation message
        }
    }

    /**
     * The entry point of the application.
     * Creates a PrintJobManager instance and starts the system.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        PrintJobManager manager = new PrintJobManager();
        manager.runSystem();
    }
}
