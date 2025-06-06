/*
 * Exam Question #787
 * Generated on: 2025-05-12 16:40:40
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Java Programming Exam Task: Advanced Print Job Scheduler**
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified simulation of a print server's job scheduler. The system should manage print jobs submitted by users, process them in the order they were received, and keep a history of completed jobs.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that fulfills the following requirements:
 * 
 * 1.  **Print Job Representation:** Create a class `PrintJob` to represent a print job. It should have:
 *     *   A unique integer ID (auto-generated).
 *     *   A `String` for the file name.
 *     *   A `String` for the current status (e.g., "Pending", "Processing", "Completed").
 *     *   Appropriate private fields and public getter methods.
 * 
 * 2.  **Print Scheduler:** Create a class `PrintScheduler` that manages the print jobs. It must contain:
 *     *   A `Queue<PrintJob>` to hold jobs waiting to be processed.
 *     *   A `List<PrintJob>` (specifically using an `ArrayList` implementation but referenced by the `List` interface) to store completed jobs.
 *     *   A counter for generating unique job IDs.
 *     *   Methods for the following operations:
 *         *   `addJob(String fileName)`: Creates a new `PrintJob` with status "Pending", assigns a unique ID, and adds it to the pending queue.
 *         *   `processNextJob()`: Removes the job at the front of the pending queue. If a job is removed, update its status to "Completed" and add it to the completed jobs list. If the queue is empty, report an error.
 *         *   `viewPendingJobs()`: Displays all jobs currently in the pending queue, showing their ID, file name, and status.
 *         *   `viewCompletedJobs()`: Displays all jobs in the completed jobs list, showing their ID, file name, and status.
 * 
 * 3.  **User Interface (in `main` method):**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user:
 *         1.  Add Print Job
 *         2.  Process Next Job
 *         3.  View Pending Jobs
 *         4.  View Completed Jobs
 *         5.  Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Implement a loop that continues until the user chooses to exit.
 * 
 * 4.  **Error Handling and Output:**
 *     *   Use `System.err` to print error messages (e.g., "Queue is empty, no job to process.", "Invalid menu choice.", "Invalid input for file name.").
 *     *   Use `System.out` for all normal output (menu, job details, confirmation messages).
 *     *   Implement **class-wide exception handling** in the `main` method's main loop using a `try-catch` block to catch potential unexpected exceptions during the program's execution (e.g., input errors, though specific input validation is also required).
 * 
 * 5.  **Input Validation:** Validate user input where necessary (e.g., ensure menu choice is a valid integer within the range).
 * 
 * 6.  **Best Practices:**
 *     *   Follow proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments (Javadoc is encouraged) and documentation.
 *     *   Maintain a clean code structure.
 * 
 * **Expected Output:**
 * 
 * The program should interact with the user via the console. Examples of output include:
 * 
 * *   Displaying the menu.
 * *   Confirming when a job is added or processed.
 * *   Listing pending and completed jobs with their details.
 * *   Printing error messages to `System.err` when operations fail or input is invalid.
 * 
 * **Constraints:**
 * 
 * *   You must use `java.util.Queue`, `java.util.ArrayList`, `java.util.List`, `java.util.Scanner`, `switch`, `System.err`, `System.out`, and class-wide `try-catch`.
 * *   The `List` storing completed jobs must be declared using the `List` interface type, even though the implementation is `ArrayList`.
 *
 * EXPLANATION:
 * This solution implements a basic print job scheduler simulation using the required Java components and best practices.
 * 
 * 1.  **`PrintJob` Class:**
 *     *   This class is a simple Plain Old Java Object (POJO) representing a print job.
 *     *   It encapsulates the `id`, `fileName`, and `status` as private fields.
 *     *   Public getter methods (`getId`, `getFileName`, `getStatus`) provide controlled access to the data.
 *     *   A public setter (`setStatus`) is provided to allow the scheduler to update the job's status.
 *     *   The `toString()` method provides a convenient string representation for printing job details.
 * 
 * 2.  **`PrintScheduler` Class:**
 *     *   This is the core class managing the job flow.
 *     *   It uses a `java.util.Queue<PrintJob>` (`pendingJobsQueue`) to store jobs waiting to be processed. The `LinkedList` class is used as it implements the `Queue` interface and is suitable for this purpose (efficient additions to the end and removals from the front).
 *     *   It uses a `java.util.List<PrintJob>` (`completedJobsList`) to store jobs that have finished processing. Crucially, it is declared as a `List` but instantiated as an `ArrayList`, demonstrating the use of the interface type. `ArrayList` is suitable here for storing a dynamic list of completed items where random access or iteration is needed.
 *     *   `jobIdCounter` is a simple integer to generate unique IDs for each new job.
 *     *   The `addJob` method creates a `PrintJob` and adds it to the `pendingJobsQueue` using `offer()`. It includes basic input validation for the file name.
 *     *   The `processNextJob` method retrieves and removes the head of the queue using `poll()`. If `poll()` returns `null`, it means the queue was empty, and an error is printed to `System.err`. Otherwise, the job's status is updated, and it's added to the `completedJobsList`.
 *     *   `viewPendingJobs` and `viewCompletedJobs` iterate through their respective collections and print the details of each job using the `forEach` loop and the `PrintJob`'s `toString()` method. They also check if the lists are empty and print appropriate messages.
 * 
 * 3.  **`PrintSchedulerApp` Class (`main` method):**
 *     *   This class contains the `main` method, serving as the application's entry point and user interface.
 *     *   A `Scanner` is used to read input from `System.in`.
 *     *   A `PrintScheduler` object is instantiated.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   Inside the loop, a menu is displayed using `System.out`.
 *     *   Input validation checks if the next input is an integer before reading it. If not, an error is printed to `System.err`, the invalid input is consumed, and the loop continues.
 *     *   A `switch` statement handles the valid integer menu choice, calling the appropriate methods in the `PrintScheduler`. The `default` case handles integer inputs that are outside the valid menu range, printing an error to `System.err`.
 *     *   **Class-wide Exception Handling:** The entire `while` loop (and the `Scanner` initialization) is wrapped in a `try-catch(Exception e)` block. This demonstrates catching any unexpected runtime exceptions that might occur within the main application logic, printing an error message to `System.err`. While specific error handling is done for input validation and empty queue, this broad catch acts as a safety net for unforeseen issues.
 *     *   A `finally` block ensures the `Scanner` is closed, releasing system resources.
 * 
 * 4.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `PrintJob` and `PrintScheduler` are private, accessed via public methods.
 *     *   **Naming:** Variable and method names are descriptive (e.g., `pendingJobsQueue`, `processNextJob`, `fileName`).
 *     *   **Comments:** Javadoc comments are included for classes and methods explaining their purpose and parameters.
 *     *   **Input Validation:** Checks are performed for empty file names and valid integer menu choices.
 *     *   **Error Handling:** `System.err` is used for errors, `System.out` for normal flow. Specific checks (empty queue, invalid input) are handled, and a general `try-catch` is present in `main`.
 *     *   **Code Structure:** The code is divided into logical classes (`PrintJob`, `PrintScheduler`, `PrintSchedulerApp`) with clear responsibilities.
 * 
 * This solution effectively integrates all the required Java components in a practical scenario, demonstrating core concepts like collection usage (Queue and List/ArrayList), user interaction, flow control (`switch`, loops), encapsulation, and robust error handling.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single print job with an ID, file name, and status.
 */
class PrintJob {
    private int id;
    private String fileName;
    private String status;

    /**
     * Constructs a new PrintJob.
     *
     * @param id The unique ID for the job.
     * @param fileName The name of the file to be printed.
     * @param status The initial status of the job (e.g., "Pending").
     */
    public PrintJob(int id, String fileName, String status) {
        this.id = id;
        this.fileName = fileName;
        this.status = status;
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public String getStatus() {
        return status;
    }

    // --- Setter for status (allows status updates) ---
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Job ID: " + id + ", File: " + fileName + ", Status: " + status;
    }
}

/**
 * Manages a queue of pending print jobs and a list of completed jobs.
 */
class PrintScheduler {
    private Queue<PrintJob> pendingJobsQueue;
    private List<PrintJob> completedJobsList; // Using List interface, implemented by ArrayList
    private int jobIdCounter;

    /**
     * Constructs a new PrintScheduler, initializing the queues and counter.
     */
    public PrintScheduler() {
        this.pendingJobsQueue = new LinkedList<>(); // LinkedList implements Queue
        this.completedJobsList = new ArrayList<>(); // ArrayList implements List
        this.jobIdCounter = 0;
    }

    /**
     * Adds a new print job to the pending queue.
     *
     * @param fileName The name of the file for the new job.
     */
    public void addJob(String fileName) {
        if (fileName == null || fileName.trim().isEmpty()) {
            System.err.println("Error: File name cannot be empty.");
            return;
        }
        jobIdCounter++;
        PrintJob newJob = new PrintJob(jobIdCounter, fileName.trim(), "Pending");
        pendingJobsQueue.offer(newJob); // offer is preferred over add for capacity-constrained queues, though LinkedList is not
        System.out.println("Job added: " + newJob);
    }

    /**
     * Processes the next job in the pending queue.
     * Moves the job from pending to completed list upon success.
     */
    public void processNextJob() {
        PrintJob jobToProcess = pendingJobsQueue.poll(); // poll returns null if queue is empty
        if (jobToProcess != null) {
            System.out.println("Processing job: " + jobToProcess.getFileName() + " (ID: " + jobToProcess.getId() + ")");
            // Simulate processing...
            jobToProcess.setStatus("Completed");
            completedJobsList.add(jobToProcess);
            System.out.println("Job completed and moved to history: " + jobToProcess.getId());
        } else {
            System.err.println("Error: Pending jobs queue is empty. No job to process.");
        }
    }

    /**
     * Displays all jobs currently in the pending queue.
     */
    public void viewPendingJobs() {
        System.out.println("\n--- Pending Jobs ---");
        if (pendingJobsQueue.isEmpty()) {
            System.out.println("No jobs currently pending.");
        } else {
            // Iterate without removing elements
            pendingJobsQueue.forEach(System.out::println);
        }
        System.out.println("--------------------");
    }

    /**
     * Displays all jobs in the completed jobs history.
     */
    public void viewCompletedJobs() {
        System.out.println("\n--- Completed Jobs History ---");
        if (completedJobsList.isEmpty()) {
            System.out.println("No jobs in history yet.");
        } else {
            completedJobsList.forEach(System.out::println);
        }
        System.out.println("----------------------------");
    }
}

/**
 * Main class to run the Print Job Scheduler simulation.
 * Contains the user interface and class-wide exception handling.
 */
public class PrintSchedulerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintScheduler scheduler = new PrintScheduler();
        boolean running = true;

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                System.out.println("\n--- Print Scheduler Menu ---");
                System.out.println("1. Add Print Job");
                System.out.println("2. Process Next Job");
                System.out.println("3. View Pending Jobs");
                System.out.println("4. View Completed Jobs");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = -1;
                // Input validation for menu choice
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } else {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    continue; // Skip to the next loop iteration
                }

                // Use switch statement for flow control
                switch (choice) {
                    case 1:
                        System.out.print("Enter file name to add: ");
                        String fileName = scanner.nextLine();
                        scheduler.addJob(fileName);
                        break;
                    case 2:
                        scheduler.processNextJob();
                        break;
                    case 3:
                        scheduler.viewPendingJobs();
                        break;
                    case 4:
                        scheduler.viewCompletedJobs();
                        break;
                    case 5:
                        System.out.println("Exiting Print Scheduler. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (Exception e) {
            // Class-wide catch for any unexpected exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // e.printStackTrace(); // Uncomment for debugging if needed
        } finally {
            // Ensure scanner is closed
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}
