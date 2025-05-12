/*
 * Exam Question #31
 * Generated on: 2025-05-11 21:49:30
 * 
 * QUESTION:
 * **Java Programming Advanced Exam Task: Job Processing System**
 * 
 * You are tasked with developing a simple Job Processing System. This system will manage a queue of jobs waiting to be processed and maintain a list of jobs that have been completed or failed. The system should be interactive, allowing a user to add new jobs, process the next job in the queue, and view the lists of pending and processed jobs.
 * 
 * **System Requirements:**
 * 
 * 1.  **Job Representation:**
 *     *   Create a class `Job` to represent a single processing task.
 *     *   Each `Job` must have:
 *         *   A unique integer `jobId`.
 *         *   A `JobType` (use an enum: `TYPE_A`, `TYPE_B`, `TYPE_C`).
 *         *   A `JobStatus` (use an enum: `PENDING`, `PROCESSING`, `COMPLETED`, `FAILED`).
 *     *   Implement proper encapsulation (private fields, public getters).
 *     *   Provide a meaningful `toString()` method for easy display.
 * 
 * 2.  **Job Scheduler:**
 *     *   Create a class `JobScheduler` to manage the jobs.
 *     *   It must maintain:
 *         *   A `Queue<Job>` to hold jobs that are waiting (`PENDING` status).
 *         *   A `List<Job>` (implemented using `ArrayList`) to hold jobs that have been processed (`COMPLETED` or `FAILED` status).
 *     *   Implement the following methods:
 *         *   `addJob(JobType type)`: Creates a new `Job` with a unique ID and `PENDING` status, and adds it to the pending queue.
 *         *   `processNextJob()`: Takes the next job from the pending queue. Simulates processing (e.g., print a message). Updates the job's status (`COMPLETED` or `FAILED`). Moves the job from the pending queue to the processed list. Handle the case where the queue is empty. Introduce a small random chance (e.g., 20%) for a job to `FAIL` instead of `COMPLETE`. This method should ideally throw an exception if processing fails critically (e.g., `QueueEmptyException` or `ProcessingFailedException`).
 *         *   `getPendingJobs()`: Returns a `List<Job>` containing all jobs currently in the pending queue (without removing them).
 *         *   `getProcessedJobs()`: Returns a `List<Job>` containing all jobs currently in the processed list.
 * 
 * 3.  **User Interface:**
 *     *   Create a main class (e.g., `JobSchedulerApp`) with a `main` method.
 *     *   Use `Scanner` to get user input from the console.
 *     *   Present a menu to the user with options:
 *         1.  Add New Job
 *         2.  Process Next Job
 *         3.  List Pending Jobs
 *         4.  List Processed Jobs
 *         5.  Exit
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Implement a loop that continues until the user chooses to exit.
 * 
 * 4.  **Error Handling and Output:**
 *     *   Use `System.out` for displaying the menu, prompts, successful operations, and job lists.
 *     *   Use `System.err` for displaying error messages (e.g., invalid menu choice, invalid job type input, attempting to process when the queue is empty, processing failure).
 *     *   Implement robust exception handling using `try-catch` blocks.
 *         *   Handle potential `InputMismatchException` when reading user input.
 *         *   Handle exceptions thrown by `JobScheduler` methods (e.g., from `processNextJob`).
 *         *   Include a general `try-catch(Exception e)` block around the main application loop to catch any unexpected errors and prevent the program from crashing abruptly, demonstrating class-wide handling (though more specific catches are preferred in production).
 * 
 * 5.  **Best Practices:**
 *     *   Use meaningful names for classes, methods, variables, and enums.
 *     *   Add comments where necessary to explain complex logic.
 *     *   Ensure proper indentation and code formatting.
 *     *   Validate user input where appropriate (e.g., ensure menu choice is a valid number, ensure job type input matches enum values).
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt for input, and perform actions based on the input. Output should clearly indicate success or failure of operations and display job details when listing. Error messages should go to `System.err`.
 * 
 * ```
 * Job Scheduler Menu:
 * 1. Add New Job
 * 2. Process Next Job
 * 3. List Pending Jobs
 * 4. List Processed Jobs
 * 5. Exit
 * Enter your choice:
 * ```
 * 
 * *(Example interaction)*
 * ```
 * Enter your choice: 1
 * Enter job type (TYPE_A, TYPE_B, TYPE_C): TYPE_A
 * Job added: Job{id=1, type=TYPE_A, status=PENDING}
 * 
 * Enter your choice: 1
 * Enter job type (TYPE_A, TYPE_B, TYPE_C): TYPE_B
 * Job added: Job{id=2, type=TYPE_B, status=PENDING}
 * 
 * Enter your choice: 3
 * --- Pending Jobs ---
 * Job{id=1, type=TYPE_A, status=PENDING}
 * Job{id=2, type=TYPE_B, status=PENDING}
 * --------------------
 * 
 * Enter your choice: 2
 * Processing Job{id=1, type=TYPE_A, status=PROCESSING}...
 * Job{id=1, type=TYPE_A, status=COMPLETED} moved to processed list.
 * 
 * Enter your choice: 2
 * Processing Job{id=2, type=TYPE_B, status=PROCESSING}...
 * Job{id=2, type=TYPE_B, status=FAILED} moved to processed list. (Example of failure)
 * 
 * Enter your choice: 4
 * --- Processed Jobs ---
 * Job{id=1, type=TYPE_A, status=COMPLETED}
 * Job{id=2, type=TYPE_B, status=FAILED}
 * ----------------------
 * 
 * Enter your choice: 2
 * System.err: Error: No jobs in the pending queue to process.
 * 
 * Enter your choice: 6
 * System.err: Error: Invalid menu choice. Please enter a number between 1 and 5.
 * 
 * Enter your choice: 5
 * Exiting Job Scheduler.
 * ```
 * 
 * Implement the complete Java code for this system.
 *
 * EXPLANATION:
 * This solution implements a simple Job Processing System demonstrating the required Java concepts and best practices.
 * 
 * **Core Components Used:**
 * 
 * 1.  **`Queue` (`java.util.Queue`)**: The `JobScheduler` class uses a `Queue<Job>` (`pendingJobsQueue`) implemented by `java.util.LinkedList`. This correctly models the "waiting jobs" scenario where jobs are processed in First-In, First-Out (FIFO) order. `offer()` is used to add jobs, and `poll()` is used to retrieve and remove the next job.
 * 2.  **`ArrayList` (`java.util.ArrayList`)**: The `JobScheduler` uses an `ArrayList<Job>` (`processedJobsList`) to store jobs after they have been processed (either completed or failed). `ArrayList` is suitable here as we need a dynamic list to add processed jobs to and iterate over to display.
 * 3.  **`List` interface (`java.util.List`)**: The `getPendingJobs()` and `getProcessedJobs()` methods in `JobScheduler` are declared to return `List<Job>`. This adheres to the principle of programming to interfaces, making the code more flexible if the underlying implementation (`ArrayList` or `LinkedList`) were to change in the future. In `JobSchedulerApp`, the returned collections are also received as `List<Job>`, demonstrating the use of the interface type.
 * 4.  **`Scanner` (`java.util.Scanner`)**: The `JobSchedulerApp` class uses `Scanner` to read user input from `System.in` for menu choices and job types.
 * 5.  **`Switch` statement**: The `run()` method in `JobSchedulerApp` uses a `switch` statement to direct the program flow based on the user's integer input for the menu choice.
 * 6.  **`System.err`**: Used in `JobSchedulerApp` to print error messages, such as invalid menu choices, invalid job types, empty queue conditions caught by exceptions, and unexpected system errors. This separates error output from normal program output (`System.out`).
 * 7.  **`System.out`**: Used for all normal program output, including the menu, prompts, success messages (job added, job completed), and listing job details.
 * 8.  **`try-catch` blocks**:
 *     *   A custom exception `JobProcessingException` is defined for errors specific to job processing (like an empty queue).
 *     *   The `processNextJob()` method throws `JobProcessingException`.
 *     *   The `run()` method in `JobSchedulerApp` contains `try-catch` blocks:
 *         *   An inner `try-catch` specifically handles `InputMismatchException` during menu choice input, clearing the scanner buffer to prevent infinite loops.
 *         *   It also catches `JobProcessingException` thrown by `processJob()`.
 *         *   An outer `try-catch(Exception e)` block wraps the main `while` loop. This demonstrates catching potential unexpected exceptions that might occur during the application's execution, providing a form of "class-wide" or rather, "main execution flow" exception handling as requested, although specific catches are generally preferred. The `finally` block ensures the `Scanner` is closed.
 * 
 * **Best Practices Demonstrated:**
 * 
 * *   **Encapsulation:** The `Job` class has private fields (`jobId`, `jobType`, `status`) and public getter methods. The `status` has a controlled setter. The `JobScheduler`'s internal data structures (`pendingJobsQueue`, `processedJobsList`) are private.
 * *   **Meaningful Names:** Classes (`Job`, `JobScheduler`, `JobSchedulerApp`), methods (`addJob`, `processNextJob`, `getPendingJobs`), variables (`pendingJobsQueue`, `processedJobsList`, `nextJobId`), and enums (`JobType`, `JobStatus`) have names that clearly indicate their purpose.
 * *   **Comments and Documentation:** Javadoc comments are included for classes and methods, explaining their purpose and parameters/return values. Inline comments explain specific logic details.
 * *   **Input Validation:** The `addNewJob` method validates the user's job type input against the `JobType` enum using `JobType.valueOf()` within a `try-catch` block. The main loop handles invalid integer input for the menu choice using `InputMismatchException`.
 * *   **Error Handling:** Errors like invalid input, empty queue processing, and simulated processing failures are explicitly handled, and informative messages are printed to `System.err`. Custom exceptions are used for specific error conditions.
 * *   **Clean Code Structure:** The code is organized into logical classes (`Job` for data, `JobScheduler` for business logic, `JobSchedulerApp` for UI/application flow). Methods are relatively small and focused on a single task.
 * 
 * This solution effectively combines the required Java components within a practical scenario, demonstrating understanding of data structures, object-oriented principles, user input handling, and robust error management.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

// Enum for Job Type
enum JobType {
    TYPE_A, TYPE_B, TYPE_C
}

// Enum for Job Status
enum JobStatus {
    PENDING, PROCESSING, COMPLETED, FAILED
}

// Custom Exception for Job Processing Errors
class JobProcessingException extends Exception {
    public JobProcessingException(String message) {
        super(message);
    }
}

/**
 * Represents a single processing job.
 */
class Job {
    private int jobId;
    private JobType jobType;
    private JobStatus status;

    /**
     * Constructs a new Job.
     * @param jobId The unique ID of the job.
     * @param jobType The type of the job.
     */
    public Job(int jobId, JobType jobType) {
        this.jobId = jobId;
        this.jobType = jobType;
        this.status = JobStatus.PENDING; // New jobs start as PENDING
    }

    // Getters
    public int getJobId() {
        return jobId;
    }

    public JobType getJobType() {
        return jobType;
    }

    public JobStatus getStatus() {
        return status;
    }

    // Setter for status (controlled access)
    public void setStatus(JobStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Job{id=" + jobId + ", type=" + jobType + ", status=" + status + '}';
    }
}

/**
 * Manages the queue of pending jobs and the list of processed jobs.
 */
class JobScheduler {
    private Queue<Job> pendingJobsQueue;
    private List<Job> processedJobsList;
    private int nextJobId;
    private Random random; // For simulating processing outcome

    /**
     * Constructs a new JobScheduler.
     */
    public JobScheduler() {
        this.pendingJobsQueue = new LinkedList<>(); // LinkedList implements Queue
        this.processedJobsList = new ArrayList<>();
        this.nextJobId = 1; // Start job IDs from 1
        this.random = new Random();
    }

    /**
     * Adds a new job to the pending queue.
     * @param type The type of the job to add.
     * @return The newly created Job object.
     */
    public Job addJob(JobType type) {
        Job newJob = new Job(nextJobId++, type);
        pendingJobsQueue.offer(newJob); // Use offer for adding to queue
        return newJob;
    }

    /**
     * Processes the next job in the pending queue.
     * Moves the job to the processed list after updating status.
     * @throws JobProcessingException if the queue is empty or processing fails.
     */
    public void processNextJob() throws JobProcessingException {
        if (pendingJobsQueue.isEmpty()) {
            throw new JobProcessingException("No jobs in the pending queue to process.");
        }

        Job currentJob = pendingJobsQueue.poll(); // Get and remove the head of the queue
        System.out.println("Processing " + currentJob + "...");
        currentJob.setStatus(JobStatus.PROCESSING); // Optional: Set status to PROCESSING temporarily

        // Simulate processing and random outcome
        try {
            // Simulate some work (optional, for realism)
            // Thread.sleep(500);

            // 20% chance of failure
            if (random.nextInt(100) < 20) {
                currentJob.setStatus(JobStatus.FAILED);
                System.err.println("Job " + currentJob.getJobId() + " processing FAILED.");
                // Could throw a more specific exception here if needed
            } else {
                currentJob.setStatus(JobStatus.COMPLETED);
                System.out.println("Job " + currentJob.getJobId() + " processing COMPLETED.");
            }

        } catch (Exception e) {
            // Catch any unexpected errors during simulated processing
            currentJob.setStatus(JobStatus.FAILED);
            processedJobsList.add(currentJob); // Still move to processed list
            throw new JobProcessingException("Error during processing job " + currentJob.getJobId() + ": " + e.getMessage());
        } finally {
             // Ensure job is moved to processed list regardless of outcome
             // Unless the initial poll failed (handled by the initial check)
             if (currentJob.getStatus() == JobStatus.COMPLETED || currentJob.getStatus() == JobStatus.FAILED) {
                 processedJobsList.add(currentJob);
                 System.out.println(currentJob + " moved to processed list.");
             } else {
                 // This case should ideally not happen if logic is correct,
                 // but as a safeguard:
                 System.err.println("Warning: Job " + currentJob.getJobId() + " finished processing with status " + currentJob.getStatus());
                 processedJobsList.add(currentJob);
             }
        }
    }

    /**
     * Returns a list of jobs currently in the pending queue.
     * Note: This returns a snapshot and does not remove jobs from the queue.
     * @return A List of pending Jobs.
     */
    public List<Job> getPendingJobs() {
        // Create a new list from the queue elements to avoid modifying the queue
        return new ArrayList<>(pendingJobsQueue);
    }

    /**
     * Returns a list of jobs that have been processed.
     * @return A List of processed Jobs.
     */
    public List<Job> getProcessedJobs() {
        // Return a copy to prevent external modification of the internal list
        return new ArrayList<>(processedJobsList);
    }

    /**
     * Checks if the pending queue is empty.
     * @return true if the pending queue is empty, false otherwise.
     */
    public boolean isPendingQueueEmpty() {
        return pendingJobsQueue.isEmpty();
    }
}

/**
 * Main application class for the Job Scheduler system.
 * Handles user interaction and overall application flow.
 */
public class JobSchedulerApp {

    private JobScheduler scheduler;
    private Scanner scanner;

    public JobSchedulerApp() {
        scheduler = new JobScheduler();
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\nJob Scheduler Menu:");
        System.out.println("1. Add New Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. List Pending Jobs");
        System.out.println("4. List Processed Jobs");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop.
     * Includes main try-catch block for overall error handling.
     */
    public void run() {
        int choice = -1;
        // Class-wide exception handling for the main application loop
        try {
            while (choice != 5) {
                displayMenu();
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over

                    // Switch statement for flow control
                    switch (choice) {
                        case 1:
                            addNewJob();
                            break;
                        case 2:
                            processJob();
                            break;
                        case 3:
                            listPendingJobs();
                            break;
                        case 4:
                            listProcessedJobs();
                            break;
                        case 5:
                            System.out.println("Exiting Job Scheduler.");
                            break;
                        default:
                            System.err.println("Error: Invalid menu choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to stay in loop
                } catch (JobProcessingException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main loop execution
            System.err.println("An unexpected system error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging in exam context
        } finally {
            // Ensure scanner is closed
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Handles adding a new job based on user input.
     */
    private void addNewJob() {
        System.out.print("Enter job type (TYPE_A, TYPE_B, TYPE_C): ");
        String typeInput = scanner.nextLine().trim().toUpperCase();
        try {
            JobType jobType = JobType.valueOf(typeInput);
            Job addedJob = scheduler.addJob(jobType);
            System.out.println("Job added: " + addedJob);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid job type entered. Please use TYPE_A, TYPE_B, or TYPE_C.");
        }
    }

    /**
     * Handles processing the next job in the queue.
     */
    private void processJob() throws JobProcessingException {
         scheduler.processNextJob(); // This method throws JobProcessingException
    }

    /**
     * Handles listing pending jobs.
     */
    private void listPendingJobs() {
        List<Job> pending = scheduler.getPendingJobs(); // Use List interface
        if (pending.isEmpty()) {
            System.out.println("No jobs currently pending.");
        } else {
            System.out.println("--- Pending Jobs ---");
            for (Job job : pending) {
                System.out.println(job);
            }
            System.out.println("--------------------");
        }
    }

    /**
     * Handles listing processed jobs.
     */
    private void listProcessedJobs() {
        List<Job> processed = scheduler.getProcessedJobs(); // Use List interface
        if (processed.isEmpty()) {
            System.out.println("No jobs have been processed yet.");
        } else {
            System.out.println("--- Processed Jobs ---");
            for (Job job : processed) {
                System.out.println(job);
            }
            System.out.println("----------------------");
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        JobSchedulerApp app = new JobSchedulerApp();
        app.run();
    }
}
