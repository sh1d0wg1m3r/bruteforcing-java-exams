/*
 * Exam Question #1148
 * Generated on: 2025-05-12 17:31:34
 * Generated by: Account 4
 * 
 * QUESTION:
 * **Java Programming Exam: Advanced Job Processing System**
 * 
 * **Problem Description:**
 * 
 * You are tasked with building a simple Job Processing System. This system will manage a queue of pending jobs, process them one by one, and keep track of completed and failed jobs. The system should be interactive, allowing a user to add new jobs, process the next job in the queue, and view the status of jobs.
 * 
 * **Requirements:**
 * 
 * 1.  **Job Representation:** Create a `Job` class to represent a task. Each job must have:
 *     *   A unique integer ID.
 *     *   A description (String).
 *     *   A status (e.g., PENDING, PROCESSING, COMPLETED, FAILED). You can use an `enum` for status.
 *     *   Implement proper encapsulation (private fields, public getters/setters where necessary).
 *     *   Override `toString()` for easy display.
 * 
 * 2.  **Job Processing Logic:** Create a class (e.g., `JobProcessor`) that manages the jobs. This class must use:
 *     *   A `java.util.Queue` to hold jobs waiting to be processed (PENDING).
 *     *   A `java.util.List` (specifically implemented as `java.util.ArrayList`) to hold jobs that have been successfully processed (COMPLETED). Declare the variable using the `List` interface.
 *     *   Another `java.util.List` (specifically implemented as `java.util.ArrayList`) to hold jobs that failed during processing (FAILED). Declare the variable using the `List` interface.
 *     *   Methods for:
 *         *   Adding a new job to the pending queue. Assign a unique ID automatically.
 *         *   Processing the next job from the pending queue.
 *         *   Viewing all pending jobs.
 *         *   Viewing all completed jobs.
 *         *   Viewing all failed jobs.
 * 
 * 3.  **User Interface:** Implement a command-line interface using `java.util.Scanner` in your `main` method. The user should be presented with a menu of options:
 *     *   Add New Job
 *     *   Process Next Job
 *     *   View Pending Jobs
 *     *   View Completed Jobs
 *     *   View Failed Jobs
 *     *   Exit
 * 
 * 4.  **Control Flow:** Use a `switch` statement to handle the user's menu choice.
 * 
 * 5.  **Input Validation & Error Handling:**
 *     *   Validate user input for menu choices (handle non-integer input or out-of-range choices).
 *     *   Handle the case where the user tries to process a job but the pending queue is empty.
 *     *   Simulate a potential processing failure for a job (e.g., randomly, or based on description). If processing fails, move the job to the failed list.
 *     *   Use `System.err` to print error messages (e.g., invalid input, cannot process because queue is empty, processing failed).
 *     *   Use `System.out` for normal output (menu, prompts, successful operations, job listings).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle unexpected errors during the program's execution, particularly around the main input loop or critical operations.
 * 
 * 6.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc).
 *     *   Maintain a clean code structure.
 * 
 * **Simulated Processing:** When processing a job, change its status to `PROCESSING`. Then, simulate some work. If the work is "successful" (e.g., 80% chance), change status to `COMPLETED` and move to the completed list. If it "fails" (e.g., 20% chance), change status to `FAILED` and move to the failed list. In either case, remove it from the pending queue.
 * 
 * **Expected Output:**
 * 
 * The program should repeatedly display a menu, prompt for user input, and perform the requested action, printing relevant information or error messages to the console (`System.out` or `System.err`). Job listings should clearly show the job ID, description, and status.
 * 
 * **Example Interaction Flow:**
 * 
 * ```
 * Job Processing System Menu:
 * 1. Add New Job
 * 2. Process Next Job
 * 3. View Pending Jobs
 * 4. View Completed Jobs
 * 5. View Failed Jobs
 * 6. Exit
 * Enter your choice: 1
 * Enter job description: Process important data
 * Job added with ID 1.
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 1
 * Enter job description: Clean temporary files
 * Job added with ID 2.
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 3
 * Pending Jobs:
 * [ID: 1, Description: Process important data, Status: PENDING]
 * [ID: 2, Description: Clean temporary files, Status: PENDING]
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 2
 * Processing job ID 1...
 * Job ID 1 completed successfully.
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 2
 * Processing job ID 2...
 * Job processing for ID 2 failed.
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 3
 * Pending Jobs:
 * (No pending jobs)
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 4
 * Completed Jobs:
 * [ID: 1, Description: Process important data, Status: COMPLETED]
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 5
 * Failed Jobs:
 * [ID: 2, Description: Clean temporary files, Status: FAILED]
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 2
 * Error: No jobs in the pending queue to process.
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 7
 * Error: Invalid choice. Please enter a number between 1 and 6.
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: Exit
 * Error: Invalid choice. Please enter a number between 1 and 6.
 * 
 * Job Processing System Menu:
 * ...
 * Enter your choice: 6
 * Exiting Job Processing System.
 * ```
 * 
 * Your solution should be a single `.java` file containing all necessary classes.
 *
 * EXPLANATION:
 * This solution implements a simple Job Processing System demonstrating the required Java concepts.
 * 
 * 1.  **Job Class:**
 *     *   The `Job` class encapsulates the data for a single job: `jobId`, `description`, and `status`.
 *     *   An `enum`, `JobStatus`, is used for status, providing type safety and readability.
 *     *   Fields are `private` adhering to encapsulation. Public getters provide controlled access. A `setStatus` method allows changing the job's state.
 *     *   `toString()` is overridden for easy printing of job details.
 * 
 * 2.  **JobProcessor Class:**
 *     *   This class manages the collections of jobs and the processing logic.
 *     *   `pendingJobs` is declared as a `Queue<Job>` and implemented using `LinkedList`, which is a common choice for queue operations (FIFO - First-In, First-Out). `offer()` is used for adding and `poll()` for removing from the head.
 *     *   `completedJobs` and `failedJobs` are declared using the `List<Job>` interface and implemented using `ArrayList`. This demonstrates using the interface type for variable declaration while using a concrete implementation. `ArrayList` is suitable here as we primarily add to and iterate over these lists.
 *     *   `nextJobId` is a private field to automatically generate unique IDs for new jobs.
 *     *   `addJob`: Creates a new `Job` object, assigns the next available ID, and adds it to the `pendingJobs` queue using `offer()`. Basic validation for empty description is included.
 *     *   `processNextJob`: Uses `poll()` to get and remove the next job from `pendingJobs`. It checks if the queue was empty. It simulates processing (including a brief `Thread.sleep` and a random success/failure check). Based on the outcome, it updates the job's status and adds it to either `completedJobs` or `failedJobs`.
 *     *   `view...Jobs`: These methods iterate through the respective collections and print the details of each job using the `Job` class's `toString()` method. They check if the lists/queue are empty first.
 * 
 * 3.  **Main Class (`AdvancedJobSystem`) and User Interface:**
 *     *   The `main` method in `AdvancedJobSystem` sets up the `Scanner` for input and the `JobProcessor`.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   `Scanner` reads user input for the menu choice and job description.
 *     *   **Input Validation:** It checks if the input is an integer using `scanner.hasNextInt()` and handles non-integer input by printing an error to `System.err` and consuming the invalid token.
 *     *   **Switch Statement:** A `switch` statement handles the different menu options, calling the appropriate methods in the `JobProcessor`. The `default` case handles invalid integer choices.
 *     *   **System.out and System.err:** `System.out.println` is used for the menu, prompts, and successful operation messages. `System.err.println` is used specifically for error messages like invalid input, empty queue processing attempts, and simulated processing failures.
 *     *   **Class-wide Exception Handling:** The main `while` loop containing the core application logic (reading input, processing choice) is wrapped in a `try-catch(Exception e)` block. This demonstrates handling unexpected runtime exceptions that might occur anywhere within that loop. The `catch` block prints an error message and the stack trace to `System.err`. A `finally` block ensures the `Scanner` is closed, which is good practice for resource management.
 * 
 * 4.  **Best Practices:**
 *     *   Variable names (`pendingJobs`, `completedJobs`, `nextJobId`) and method names (`addJob`, `processNextJob`, `viewPendingJobs`) are descriptive.
 *     *   Javadoc comments explain the purpose of classes, constructors, and methods.
 *     *   Inline comments clarify specific logic points (e.g., using `offer`/`poll`, consuming newline).
 *     *   The code is structured logically with separate classes for `Job`, `JobProcessor`, and the main application entry point.
 * 
 * This solution effectively utilizes all required components in a cohesive system, simulates a practical scenario with state changes and potential failures, and incorporates essential programming practices like encapsulation, validation, and error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Random; // For simulating processing failure

// Enum for Job Status
enum JobStatus {
    PENDING,
    PROCESSING,
    COMPLETED,
    FAILED
}

// Class to represent a Job
class Job {
    private int jobId;
    private String description;
    private JobStatus status;

    /**
     * Constructs a new Job with a given ID and description.
     * Initial status is PENDING.
     * @param jobId The unique ID for the job.
     * @param description A brief description of the job.
     */
    public Job(int jobId, String description) {
        this.jobId = jobId;
        this.description = description;
        this.status = JobStatus.PENDING;
    }

    // --- Getters ---
    public int getJobId() {
        return jobId;
    }

    public String getDescription() {
        return description;
    }

    public JobStatus getStatus() {
        return status;
    }

    // --- Setter for Status ---
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the Job.
     * @return String representation including ID, description, and status.
     */
    @Override
    public String toString() {
        return "[ID: " + jobId + ", Description: " + description + ", Status: " + status + "]";
    }
}

// Class to manage Job processing
class JobProcessor {
    private Queue<Job> pendingJobs;
    private List<Job> completedJobs; // Declared as List, implemented as ArrayList
    private List<Job> failedJobs;    // Declared as List, implemented as ArrayList
    private int nextJobId;
    private Random random; // For simulating failure

    /**
     * Constructs a new JobProcessor, initializing job queues and lists.
     */
    public JobProcessor() {
        // Use LinkedList as a common Queue implementation
        this.pendingJobs = new LinkedList<>();
        this.completedJobs = new ArrayList<>(); // Using ArrayList implementation
        this.failedJobs = new ArrayList<>();    // Using ArrayList implementation
        this.nextJobId = 1; // Start job IDs from 1
        this.random = new Random();
    }

    /**
     * Adds a new job to the pending queue.
     * @param description The description of the job.
     */
    public void addJob(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.err.println("Error: Job description cannot be empty.");
            return;
        }
        Job newJob = new Job(nextJobId++, description.trim());
        pendingJobs.offer(newJob); // offer is preferred over add in queues
        System.out.println("Job added with ID " + newJob.getJobId() + ".");
    }

    /**
     * Processes the next job from the pending queue.
     * Simulates processing and moves job to completed or failed list.
     */
    public void processNextJob() {
        Job jobToProcess = pendingJobs.poll(); // Retrieves and removes the head of this queue

        if (jobToProcess == null) {
            System.err.println("Error: No jobs in the pending queue to process.");
            return;
        }

        System.out.println("Processing job ID " + jobToProcess.getJobId() + "...");
        jobToProcess.setStatus(JobStatus.PROCESSING);

        // Simulate processing time/work (optional, can be just status change)
        try {
            Thread.sleep(500); // Simulate work duration
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupt status
            System.err.println("Processing interrupted for job ID " + jobToProcess.getJobId());
            jobToProcess.setStatus(JobStatus.FAILED);
            failedJobs.add(jobToProcess);
            return; // Exit method on interruption
        }

        // Simulate success or failure (e.g., 80% success chance)
        if (random.nextDouble() < 0.8) { // 80% chance of success
            jobToProcess.setStatus(JobStatus.COMPLETED);
            completedJobs.add(jobToProcess);
            System.out.println("Job ID " + jobToProcess.getJobId() + " completed successfully.");
        } else { // 20% chance of failure
            jobToProcess.setStatus(JobStatus.FAILED);
            failedJobs.add(jobToProcess);
            System.err.println("Job processing for ID " + jobToProcess.getJobId() + " failed.");
        }
    }

    /**
     * Displays all jobs currently in the pending queue.
     */
    public void viewPendingJobs() {
        System.out.println("\n--- Pending Jobs ---");
        if (pendingJobs.isEmpty()) {
            System.out.println("(No pending jobs)");
        } else {
            // Iterate without removing from the queue
            for (Job job : pendingJobs) {
                System.out.println(job);
            }
        }
        System.out.println("--------------------");
    }

    /**
     * Displays all jobs that have been completed.
     */
    public void viewCompletedJobs() {
        System.out.println("\n--- Completed Jobs ---");
        if (completedJobs.isEmpty()) {
            System.out.println("(No completed jobs)");
        } else {
            for (Job job : completedJobs) {
                System.out.println(job);
            }
        }
        System.out.println("--------------------");
    }

    /**
     * Displays all jobs that have failed.
     */
    public void viewFailedJobs() {
        System.out.println("\n--- Failed Jobs ---");
        if (failedJobs.isEmpty()) {
            System.out.println("(No failed jobs)");
        } else {
            for (Job job : failedJobs) {
                System.out.println(job);
            }
        }
        System.out.println("--------------------");
    }
}

// Main class to run the application
public class AdvancedJobSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JobProcessor processor = new JobProcessor();
        boolean running = true;

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                printMenu();
                System.out.print("Enter your choice: ");

                int choice = -1; // Default invalid choice
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                } else {
                    // Handle non-integer input
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Skip to next iteration
                }
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Use a switch statement for flow control
                switch (choice) {
                    case 1:
                        System.out.print("Enter job description: ");
                        String description = scanner.nextLine();
                        processor.addJob(description);
                        break;
                    case 2:
                        processor.processNextJob();
                        break;
                    case 3:
                        processor.viewPendingJobs();
                        break;
                    case 4:
                        processor.viewCompletedJobs();
                        break;
                    case 5:
                        processor.viewFailedJobs();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting Job Processing System.");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 6.");
                        break;
                }
                System.out.println(); // Add a blank line for readability
            }
        } catch (Exception e) {
            // Generic catch-all for unexpected errors during execution
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
        System.out.println("Job Processing System Menu:");
        System.out.println("1. Add New Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. View Pending Jobs");
        System.out.println("4. View Completed Jobs");
        System.out.println("5. View Failed Jobs");
        System.out.println("6. Exit");
    }
}
