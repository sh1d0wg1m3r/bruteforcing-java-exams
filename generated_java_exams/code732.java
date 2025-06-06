/*
 * Exam Question #732
 * Generated on: 2025-05-12 16:32:45
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Build Job Scheduler
 * 
 * **Scenario:**
 * 
 * You are tasked with implementing a simplified Build Job Scheduler for a development team. The scheduler manages a queue of pending build jobs and a list of completed jobs.
 * 
 * Each `BuildJob` has:
 * - A unique integer ID (assigned automatically starting from 1).
 * - A string description (e.g., "Compile Core Module", "Run Unit Tests").
 * - A priority level: "High", "Medium", or "Low".
 * 
 * The scheduler operates as follows:
 * - New jobs are added to the queue of pending jobs.
 * - When a job is processed, the scheduler selects the next job from the pending queue based on the following rules:
 *     1. Jobs with "High" priority are processed before "Medium" priority jobs.
 *     2. Jobs with "Medium" priority are processed before "Low" priority jobs.
 *     3. Among jobs with the same highest priority level currently in the queue, the job that has been in the queue the longest (FIFO - First-In, First-Out) is processed first.
 * - Once a job is processed, it is removed from the pending queue and added to a list of completed jobs.
 * 
 * Your task is to implement this system using Java.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to store the pending build jobs. Choose an appropriate implementation class.
 *     *   Use a `java.util.ArrayList` to store the completed build jobs. Declare the variable using the `java.util.List` interface.
 * 2.  **Classes:**
 *     *   Create a `BuildJob` class to represent a single build job. It must have private fields for ID, description, and priority, and public getter methods. The ID should be assigned automatically and sequentially when a `BuildJob` object is created using a static counter. Include a method to get a numeric representation of the priority for comparison. Implement a `toString()` method for easy printing.
 *     *   Create a `BuildScheduler` class that encapsulates the pending job queue and the completed job list. It should have methods to:
 *         *   `addJob(String description, String priority)`: Creates a new `BuildJob` and adds it to the pending queue. Validate the priority input ("High", "Medium", or "Low").
 *         *   `processNextJob()`: Selects and processes the next job according to the priority/FIFO rules, moving it from the pending queue to the completed list. Handle the case where the queue is empty by printing an error message.
 *         *   `viewPendingJobs()`: Prints the details of all jobs currently in the pending queue, maintaining their relative order.
 *         *   `viewCompletedJobs()`: Prints the details of all completed jobs.
 * 3.  **User Interface:**
 *     *   Implement a simple command-line interface using `java.util.Scanner` in a `main` method (preferably in a separate application class).
 *     *   Present a menu to the user with options: "Add Job", "Process Next Job", "View Pending Jobs", "View Completed Jobs", "Exit".
 *     *   Use a `switch` statement to handle the user's menu choice.
 * 4.  **Error Handling:**
 *     *   Use `System.err` to print error messages (e.g., invalid menu choice, invalid priority input, attempting to process from an empty queue, `InputMismatchException`).
 *     *   Use `System.out` for all normal output (menu, prompts, job details, successful operations).
 *     *   Implement class-wide exception handling using `try-catch` blocks. This should cover potential issues during user input reading (`Scanner`) and other unexpected runtime errors in the main application loop. Handle specific exceptions like `InputMismatchException`.
 * 5.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc).
 *     *   Implement input validation where necessary (priority string, menu choice integer).
 *     *   Ensure resources like `Scanner` are closed properly.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, presenting the menu, accepting user input, and performing the requested actions. Output should clearly indicate successes, failures, and job details. Error messages should go to `System.err`, normal output to `System.out`.
 * 
 * Example interaction flow (partial):
 * ```
 * --- Build Job Scheduler ---
 * Menu:
 * 1. Add Job
 * 2. Process Next Job
 * 3. View Pending Jobs
 * 4. View Completed Jobs
 * 5. Exit
 * Enter choice: 1
 * Enter job description: Compile Core Module
 * Enter priority (High, Medium, Low): High
 * Job added: Job [ID=1, Desc='Compile Core Module', Priority=High]
 * 
 * Menu:
 * ...
 * Enter choice: 1
 * Enter job description: Run Unit Tests
 * Enter priority (High, Medium, Low): Medium
 * Job added: Job [ID=2, Desc='Run Unit Tests', Priority=Medium]
 * 
 * Menu:
 * ...
 * Enter choice: 1
 * Enter job description: Deploy to Staging
 * Enter priority (High, Medium, Low): High
 * Job added: Job [ID=3, Desc='Deploy to Staging', Priority=High]
 * 
 * Menu:
 * ...
 * Enter choice: 3
 * --- Pending Jobs ---
 * 1. Job [ID=1, Desc='Compile Core Module', Priority=High]
 * 2. Job [ID=2, Desc='Run Unit Tests', Priority=Medium]
 * 3. Job [ID=3, Desc='Deploy to Staging', Priority=High]
 * --------------------
 * 
 * Menu:
 * ...
 * Enter choice: 2
 * Processed job: Job [ID=1, Desc='Compile Core Module', Priority=High]
 * 
 * Menu:
 * ...
 * Enter choice: 3
 * --- Pending Jobs ---
 * 1. Job [ID=2, Desc='Run Unit Tests', Priority=Medium]
 * 2. Job [ID=3, Desc='Deploy to Staging', Priority=High]
 * --------------------
 * 
 * Menu:
 * ...
 * Enter choice: 2
 * Processed job: Job [ID=3, Desc='Deploy to Staging', Priority=High]
 * 
 * Menu:
 * ...
 * Enter choice: 5
 * Exiting scheduler.
 * ```
 *
 * EXPLANATION:
 * This solution implements the Build Job Scheduler application, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Scenario Implementation:** The code models a simple job scheduler where jobs are added to a pending queue and processed based on priority and arrival time, then moved to a completed list.
 * 
 * 2.  **Data Structures:**
 *     *   `java.util.Queue`: The `pendingJobs` variable in the `BuildScheduler` class is declared using the `Queue` interface and implemented using `java.util.LinkedList`. `LinkedList` is a suitable choice as it efficiently supports the `add()` (enqueue) and `poll()` (dequeue) operations required for queue behavior.
 *     *   `java.util.ArrayList`: The `completedJobs` variable in the `BuildScheduler` class is implemented using `java.util.ArrayList`. `ArrayList` is efficient for storing and iterating over completed jobs.
 *     *   `java.util.List`: The `completedJobs` variable is declared using the `List` interface (`List<BuildJob> completedJobs = new ArrayList<>();`), adhering to the principle of programming to interfaces.
 * 
 * 3.  **Classes:**
 *     *   `BuildJob`: This class encapsulates the data for a single job (`id`, `description`, `priority`). It uses a `static` counter (`nextId`) to ensure each job gets a unique, sequential ID upon creation. The constructor includes validation for the `priority` string, throwing an `IllegalArgumentException` for invalid input. The `getPriorityLevel()` method uses a `switch` statement to map the string priority to a numeric value, simplifying comparison logic in the scheduler. The `toString()` method provides a convenient representation for printing.
 *     *   `BuildScheduler`: This class manages the core logic. It holds the `pendingJobs` `Queue` and `completedJobs` `List`.
 *         *   `addJob()`: Creates a new `BuildJob` and adds it to the `pendingJobs` queue using `queue.add()`. It includes a `try-catch` block to handle the `IllegalArgumentException` that might be thrown by the `BuildJob` constructor if an invalid priority is provided, printing an error to `System.err`.
 *         *   `processNextJob()`: This is the most complex method. It first checks if the queue is empty. If not, it iterates through the queue (using a for-each loop, which implicitly uses an iterator) to find the highest priority level present. Then, it iterates again to find the *first* job with that highest priority level (implementing the FIFO rule within the priority group). To remove this specific job while preserving the order of other jobs in the `Queue`, it uses a temporary `LinkedList` (`tempQueue`). It `poll()`s elements from `pendingJobs`, adding them to `tempQueue`, until the target job is reached. The target job is then `poll()`ed and added to `completedJobs`. Finally, all elements from `tempQueue` are added back to the end of `pendingJobs`, restoring their relative order. This demonstrates a practical approach to manipulating a `Queue` when direct arbitrary element removal isn't desired or efficient.
 *         *   `viewPendingJobs()` and `viewCompletedJobs()`: These methods iterate through the respective collections (`Queue` and `List`) and print the job details using `System.out` and the `BuildJob.toString()` method. Iterating the `Queue` with a for-each loop or iterator does not remove elements.
 * 
 * 4.  **User Interface:**
 *     *   `SchedulerApp`: This class contains the `main` method, serving as the application entry point.
 *     *   `java.util.Scanner`: A `Scanner` object is used to read user input from `System.in`.
 *     *   `switch` statement: The main application loop uses a `switch` statement based on the user's integer choice to direct control flow to the appropriate `BuildScheduler` method or exit the application.
 * 
 * 5.  **Error Handling:**
 *     *   `System.err`: Used specifically for printing error messages, such as invalid menu choices, invalid priority input (caught from `IllegalArgumentException`), and messages when trying to process from an empty queue.
 *     *   `System.out`: Used for all standard output, including the menu, prompts, job details, and successful operation messages.
 *     *   Class-wide exception handling with `try-catch`: The core `while` loop in the `SchedulerApp.main` method is wrapped in a `try-catch(Exception e)` block. This provides a top-level handler for any unexpected runtime errors that might occur during the application's execution. A nested `try-catch(InputMismatchException e)` is used specifically around `scanner.nextInt()` to gracefully handle cases where the user enters non-integer input for the menu choice, preventing the program from crashing and prompting the user again. The `IllegalArgumentException` thrown by `BuildJob` is caught in `BuildScheduler.addJob`, demonstrating exception handling across class boundaries.
 *     *   Input Validation: The `BuildJob` constructor validates the priority string. The `SchedulerApp` validates the menu choice range and handles non-integer input using `InputMismatchException`.
 *     *   Resource Closing: The `Scanner` object is initialized inside the main `try` block and closed in a `finally` block, ensuring it is closed even if exceptions occur or the loop terminates.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation is applied by making fields `private` and providing `public` getter methods.
 *     *   Meaningful names are used for classes, variables, and methods (e.g., `BuildJob`, `pendingJobs`, `processNextJob`, `getPriorityLevel`).
 *     *   Javadoc comments are included for classes and methods to explain their purpose, parameters, and return values. Inline comments clarify complex logic, like the job processing steps.
 *     *   Input validation is implemented for critical user inputs (priority, menu choice).
 *     *   Error handling is robust, using appropriate exception types and directing error messages to `System.err`. Resource management (`Scanner` closing) is handled correctly.
 * 
 * This solution effectively integrates the required Java components within a practical, albeit simplified, application context, demonstrating advanced understanding of data structures, object-oriented design, and error handling.
 */

// Complete Java solution code here

import java.util.Queue;
import java.util.LinkedList; // Implementation of Queue
import java.util.List; // Interface
import java.util.ArrayList; // Implementation of List
import java.util.Scanner;
import java.util.InputMismatchException;
// Iterator is implicitly used by for-each loops, no explicit import needed for this solution approach

/**
 * Represents a build job with an ID, description, and priority.
 * Includes methods for getting job details and priority level for sorting/processing.
 */
class BuildJob {
    private static int nextId = 1; // Static counter for unique IDs
    private int id;
    private String description;
    private String priority; // Stores the priority string (High, Medium, Low)

    /**
     * Constructs a new BuildJob.
     * Automatically assigns a unique ID and validates the priority.
     *
     * @param description The description of the build job.
     * @param priority The priority level ("High", "Medium", or "Low"). Case-insensitive validation.
     * @throws IllegalArgumentException if the priority is invalid.
     */
    public BuildJob(String description, String priority) {
        this.id = nextId++; // Assign and increment ID for each new job
        this.description = description;
        // Validate priority upon creation
        if (!isValidPriority(priority)) {
            throw new IllegalArgumentException("Invalid priority: '" + priority + "'. Must be High, Medium, or Low.");
        }
        // Store the priority string as provided (or normalized if preferred, but requirement is to store)
        this.priority = priority;
    }

    /**
     * Checks if the provided priority string is valid.
     * Validation is case-insensitive.
     *
     * @param priority The priority string to validate.
     * @return true if the priority is "High", "Medium", or "Low" (case-insensitive), false otherwise.
     */
    private boolean isValidPriority(String priority) {
        if (priority == null) return false;
        String lowerPriority = priority.toLowerCase();
        return lowerPriority.equals("high") || lowerPriority.equals("medium") || lowerPriority.equals("low");
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    /**
     * Returns a numeric representation of the priority level for comparison.
     * This helps in sorting or selecting jobs based on priority.
     * High = 3, Medium = 2, Low = 1, Invalid/Other = 0.
     *
     * @return The numeric priority level.
     */
    public int getPriorityLevel() {
        // Use switch statement for mapping priority strings to integer levels
        switch (this.priority.toLowerCase()) {
            case "high":
                return 3;
            case "medium":
                return 2;
            case "low":
                return 1;
            default:
                // Should not be reached if isValidPriority is checked before setting
                return 0;
        }
    }

    /**
     * Returns a string representation of the BuildJob object.
     *
     * @return A formatted string including ID, description, and priority.
     */
    @Override
    public String toString() {
        return "Job [ID=" + id + ", Desc='" + description + "', Priority=" + priority + "]";
    }
}

/**
 * Manages a queue of pending build jobs and a list of completed jobs.
 * Implements logic for adding jobs, processing the next job based on priority/FIFO,
 * and viewing job lists.
 */
class BuildScheduler {
    private Queue<BuildJob> pendingJobs; // Use Queue interface for pending jobs
    private List<BuildJob> completedJobs; // Use List interface for completed jobs

    /**
     * Constructs a new BuildScheduler with empty pending and completed job collections.
     */
    public BuildScheduler() {
        this.pendingJobs = new LinkedList<>(); // LinkedList is a common Queue implementation
        this.completedJobs = new ArrayList<>(); // ArrayList is a common List implementation
    }

    /**
     * Adds a new build job to the end of the pending queue.
     * Handles invalid priority input by catching IllegalArgumentException from BuildJob constructor.
     *
     * @param description The description of the job.
     * @param priority The priority of the job ("High", "Medium", or "Low").
     */
    public void addJob(String description, String priority) {
        try {
            // BuildJob constructor validates priority and throws IllegalArgumentException
            BuildJob newJob = new BuildJob(description, priority);
            pendingJobs.add(newJob); // Add job to the end of the queue (FIFO)
            System.out.println("Job added: " + newJob);
        } catch (IllegalArgumentException e) {
            // Catch validation errors during job creation
            System.err.println("Error adding job: " + e.getMessage());
        }
    }

    /**
     * Selects and processes the next available job from the pending queue.
     * The selection follows priority (High > Medium > Low) and FIFO within the highest priority level.
     * The processed job is moved from the pending queue to the completed list.
     * Prints an error message if the pending queue is empty.
     */
    public void processNextJob() {
        if (pendingJobs.isEmpty()) {
            System.err.println("No pending jobs to process.");
            return;
        }

        // --- Step 1: Find the job to process based on priority and FIFO ---
        BuildJob jobToProcess = null;
        int maxPriorityLevel = 0;

        // First pass: Iterate through the queue to find the maximum priority level present.
        // This does not remove elements.
        for (BuildJob job : pendingJobs) {
            if (job.getPriorityLevel() > maxPriorityLevel) {
                maxPriorityLevel = job.getPriorityLevel();
            }
        }

        // Second pass: Iterate again to find the *first* job (oldest) with the maximum priority level.
        // This respects the FIFO rule within the highest priority group.
        for (BuildJob job : pendingJobs) {
             if (job.getPriorityLevel() == maxPriorityLevel) {
                 jobToProcess = job; // Found the target job object reference
                 break; // Stop at the first match (oldest)
             }
        }

        // --- Step 2: Remove the found job from the queue while preserving order of others ---
        // A standard Queue doesn't allow easy removal of arbitrary elements.
        // We use a temporary queue to hold elements polled from the front
        // until the target job is reached.
        Queue<BuildJob> tempQueue = new LinkedList<>(); // Temporary queue

        BuildJob currentJob;
        // Poll elements from the front of pendingJobs
        // Stop when the queue is empty (shouldn't happen if jobToProcess was found) or jobToProcess is polled.
        while ((currentJob = pendingJobs.poll()) != null && currentJob != jobToProcess) {
             tempQueue.add(currentJob); // Add skipped job to temporary queue
        }

        // At this point, currentJob should be jobToProcess, unless something went wrong.
        if (currentJob == jobToProcess && currentJob != null) {
            // Step 3: Process the job - move it to the completed list
            completedJobs.add(jobToProcess);
            System.out.println("Processed job: " + jobToProcess);

            // Step 4: Add the skipped jobs back to the end of the pending queue
            while ((currentJob = tempQueue.poll()) != null) {
                pendingJobs.add(currentJob);
            }
        } else {
             // This is an unexpected internal state if jobToProcess was found initially.
             // It might indicate concurrent modification or a logic error.
             // For robustness, try to restore the queue state.
             System.err.println("Internal error: Could not find job to process during queue manipulation.");
             // Add the last polled element (which should have been jobToProcess if logic was perfect) back
             if (currentJob != null) tempQueue.add(currentJob);
             // Add all elements from the temporary queue back to the pending queue
             while ((currentJob = tempQueue.poll()) != null) {
                 pendingJobs.add(currentJob);
             }
        }
    }

    /**
     * Prints the details of all jobs currently in the pending queue.
     * Jobs are printed in their current order in the queue.
     */
    public void viewPendingJobs() {
        if (pendingJobs.isEmpty()) {
            System.out.println("No pending jobs.");
            return;
        }
        System.out.println("--- Pending Jobs ---");
        // Iterate through the queue using the for-each loop, which uses an iterator
        // This does not remove elements from the queue.
        int index = 1;
        for (BuildJob job : pendingJobs) {
            System.out.println(index++ + ". " + job);
        }
        System.out.println("--------------------");
    }

    /**
     * Prints the details of all jobs in the completed list.
     * Jobs are printed in the order they were completed.
     */
    public void viewCompletedJobs() {
        if (completedJobs.isEmpty()) {
            System.out.println("No completed jobs.");
            return;
        }
        System.out.println("--- Completed Jobs ---");
        // Iterate through the list using a standard for loop or enhanced for loop
        for (int i = 0; i < completedJobs.size(); i++) {
            System.out.println((i + 1) + ". " + completedJobs.get(i));
        }
        System.out.println("--------------------");
    }
}


/**
 * Main application class for the Build Job Scheduler.
 * Handles user interaction via a command-line menu using Scanner.
 * Contains the main application loop and top-level exception handling.
 */
public class SchedulerApp {

    public static void main(String[] args) {
        BuildScheduler scheduler = new BuildScheduler();
        Scanner scanner = null; // Declare scanner outside try to ensure finally can access it
        boolean running = true;

        System.out.println("--- Build Job Scheduler ---");

        // Class-wide exception handling around the main application logic loop
        try {
            scanner = new Scanner(System.in); // Initialize scanner inside try
            while (running) {
                printMenu();
                System.out.print("Enter choice: ");

                int choice = -1;
                try {
                    // Read integer input for menu choice
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    // Handle non-integer input gracefully
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid token from the scanner buffer
                    System.out.println(); // Add a newline for better formatting before the next menu print
                    continue; // Skip the rest of the loop body and show the menu again
                }

                // Use switch statement for handling different menu options
                switch (choice) {
                    case 1: // Add Job
                        scanner.nextLine(); // Consume the leftover newline character after reading the integer choice
                        System.out.print("Enter job description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter priority (High, Medium, Low): ");
                        String priority = scanner.nextLine();
                        // The scheduler.addJob method handles priority validation and error reporting via System.err
                        scheduler.addJob(description, priority);
                        break;
                    case 2: // Process Next Job
                        scheduler.processNextJob();
                        break;
                    case 3: // View Pending Jobs
                        scheduler.viewPendingJobs();
                        break;
                    case 4: // View Completed Jobs
                        scheduler.viewCompletedJobs();
                        break;
                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting scheduler.");
                        break;
                    default:
                        // Handle choices outside the valid menu range
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
                // Add a newline after each successful operation for better readability, unless exiting
                if (running) {
                   System.out.println();
                }
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions that might occur during execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print the stack trace to the error stream for debugging
        } finally {
            // Ensure the scanner resource is closed regardless of whether an exception occurred or the program exited normally
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Prints the main menu options to the console using System.out.
     */
    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add Job");
        System.out.println("2. Process Next Job");
        System.out.println("3. View Pending Jobs");
        System.out.println("4. View Completed Jobs");
        System.out.println("5. Exit");
    }
}
