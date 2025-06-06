/*
 * Exam Question #311
 * Generated on: 2025-05-11 22:53:20
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Print Job Spooler Simulation
 * 
 * **Scenario:**
 * 
 * You are tasked with creating a simplified simulation of a print job spooler. This system manages print jobs submitted by users, processes them based on priority, and allows users to view the queue or cancel jobs.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this print spooler. Your solution must adhere to the following:
 * 
 * 1.  **Data Structures:**
 *     *   Use three separate `java.util.Queue` implementations (specifically, `java.util.LinkedList` which implements `Queue`) to hold print jobs based on their priority: Urgent, Normal, and Low.
 *     *   Use a `java.util.ArrayList` (declared using the `java.util.List` interface) to maintain a history of all submitted jobs, including those that are completed or cancelled.
 * 
 * 2.  **PrintJob Class:**
 *     *   Create a `PrintJob` class with private fields for:
 *         *   A unique integer ID.
 *         *   Job name (String).
 *         *   Priority (use an enum: `URGENT`, `NORMAL`, `LOW`).
 *         *   Status (use an enum: `QUEUED`, `PRINTING`, `COMPLETED`, `CANCELLED`).
 *     *   Include a constructor to initialize ID, name, and priority, setting the initial status to `QUEUED`.
 *     *   Provide public getter methods for all fields.
 *     *   Provide a public setter method *only* for the status field.
 *     *   Override the `toString()` method to provide a useful string representation of a job.
 * 
 * 3.  **PrintSpooler Class:**
 *     *   Implement the core logic within a class (e.g., `PrintSpooler`).
 *     *   It should contain the three `Queue` instances and the `List` history as private fields.
 *     *   Maintain a private counter for generating unique job IDs.
 *     *   Implement the following public methods:
 *         *   `submitJob(String name, Priority priority)`: Creates a new `PrintJob`, assigns a unique ID, adds it to the appropriate priority queue, adds it to the job history list, and prints a confirmation message using `System.out`.
 *         *   `viewQueue()`: Prints the current state of all three queues, listing jobs by priority using `System.out`. Include the job ID, name, and priority.
 *         *   `processNextJob()`: Checks the Urgent queue first. If not empty, poll a job. If Urgent is empty, check Normal. If Normal is empty, check Low. If a job is found, poll it, update its status to `COMPLETED` in the job history list, and print a message indicating which job is being processed using `System.out`. If all queues are empty, print a message using `System.out` indicating no jobs are waiting.
 *         *   `cancelJob(int jobId)`: Finds the job with the given ID in the job history list. If found and its status is `QUEUED`, remove it from its respective queue and update its status in the job history list to `CANCELLED`. Print a success message using `System.out`. If the job is not found, or its status is not `QUEUED`, print an appropriate error message using `System.err`. *Hint: Removing from a `LinkedList` by iterating with an `Iterator` is necessary here.*
 * 
 * 4.  **User Interaction:**
 *     *   Implement a `main` method (or a separate method called by main) that provides a command-line interface using `java.util.Scanner`.
 *     *   Present a menu to the user with options: `submit`, `view`, `process`, `cancel`, `exit`.
 *     *   Use a `switch` statement to handle the user's choice.
 *     *   For submitting a job, prompt for the job name and priority (accept "urgent", "normal", "low" case-insensitively). Validate the priority input.
 *     *   For cancelling a job, prompt for the job ID.
 * 
 * 5.  **Error Handling & Validation:**
 *     *   Validate user input (e.g., priority string, job ID is an integer). Use `System.err` for invalid input messages.
 *     *   Implement class-wide exception handling using `try-catch` blocks. This should include handling potential exceptions during input parsing (e.g., when reading the job ID for cancellation) and a general catch-all for unexpected runtime errors within the main loop.
 * 
 * 6.  **Best Practices:**
 *     *   Follow Java coding conventions.
 *     *   Use meaningful variable and method names.
 *     *   Include comments where necessary to explain complex logic.
 *     *   Ensure proper encapsulation (private fields, public methods).
 * 
 * **Expected Output:**
 * 
 * The program should provide clear prompts, confirmations for successful operations, status updates for job processing, and error messages for failures or invalid input, using `System.out` and `System.err` as specified.
 * 
 * ---
 * **Evaluation:**
 * 
 * Your solution will be evaluated on:
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`.
 * *   Effective use of `System.out` and `System.err`.
 * *   Proper implementation of exception handling with `try-catch`.
 * *   Correct implementation of the print spooler logic, including priority handling and job cancellation from the queue.
 * *   Adherence to object-oriented principles (encapsulation).
 * *   Code readability, comments, and naming conventions.
 * *   Input validation and error handling.
 * 
 * ```java
 * // Your code goes here
 * ```
 *
 * EXPLANATION:
 * This solution implements a simplified print job spooler simulation, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`PrintJob` Class:** This is a simple Plain Old Java Object (POJO) representing a print job. It encapsulates the job's state (`id`, `name`, `priority`, `status`) using private fields and provides controlled access via public getters and a specific setter for the `status`. Enums (`Priority` and `Status`) are used for type safety and readability. The `toString()` method provides a convenient way to print job details.
 * 
 * 2.  **`PrintSpooler` Class:** This class contains the core logic and data structures:
 *     *   **Data Structures:**
 *         *   `urgentQueue`, `normalQueue`, `lowQueue`: Three instances of `LinkedList<PrintJob>`, used as `Queue` implementations. Jobs are added (`offer`) and removed from the head (`poll`) based on their priority. Using separate queues simplifies priority handling compared to managing priority within a single queue.
 *         *   `jobHistory`: An `ArrayList<PrintJob>` declared as `List<PrintJob>`. This list stores *all* job objects ever created. It serves as a central registry to look up jobs by ID (e.g., for cancellation) and track their final status.
 *     *   **`submitJob` Method:** Creates a new `PrintJob`, increments the `nextJobId`, adds the job object to the appropriate queue using `offer()`, and adds the *same* job object reference to the `jobHistory` list.
 *     *   **`viewQueue` Method:** Iterates through each queue (using an enhanced for loop, which doesn't remove elements) and prints the details of jobs currently waiting in each queue.
 *     *   **`processNextJob` Method:** Implements the priority logic. It attempts to `poll()` (remove and return the head) from the `urgentQueue`, then `normalQueue`, then `lowQueue`. If a job is found, its `status` is updated to `COMPLETED`. Since the same `PrintJob` object reference exists in both the queue (before polling) and the `jobHistory` list, modifying the object's status directly updates it in the history.
 *     *   **`cancelJob` Method:** This is one of the more complex methods. It first searches the `jobHistory` list for the job by ID. If found, it checks if its status is `QUEUED`. If so, it determines which queue the job belongs to based on its original priority. It then iterates through that specific queue using an `Iterator`. When the target job is found within the queue, `iterator.remove()` is used to safely remove it from the `LinkedList` while iterating. Finally, the job's status in the `jobHistory` list is updated to `CANCELLED`. Error messages are printed using `System.err` if the job isn't found or isn't in a cancellable state.
 * 
 * 3.  **User Interaction (`run` method and `main`):**
 *     *   The `main` method simply creates a `PrintSpooler` instance and calls its `run` method.
 *     *   The `run` method contains the main application loop. It uses `Scanner` to read user input.
 *     *   A `switch` statement is used to direct execution based on the user's command.
 *     *   Input validation is performed for the priority string (using `Priority.valueOf` and catching `IllegalArgumentException`) and the job ID (using a specific `try-catch` for `InputMismatchException`). Invalid inputs trigger messages to `System.err`.
 *     *   Normal output messages (confirmations, status updates, menu) are printed using `System.out`. The code explicitly uses `System.out.println(System.out.getClass().getName() + ": ...")` and `System.err.println(System.err.getClass().getName() + ": ...")` to visually demonstrate the use of these streams, although simply using `System.out.println` and `System.err.println` is standard practice.
 * 
 * 4.  **Exception Handling (`try-catch`):**
 *     *   A broad `try-catch (Exception e)` block wraps the main `while(running)` loop in the `run` method. This provides a "class-wide" or application-level catch-all for unexpected runtime errors that might occur during command processing, preventing the application from crashing abruptly and printing a generic error message to `System.err`.
 *     *   A specific `try-catch (InputMismatchException e)` block is used when reading the job ID for cancellation. This handles the anticipated error if the user types non-integer input, printing an informative error message to `System.err` and consuming the invalid input from the `Scanner` to prevent an infinite loop.
 *     *   The `finally` block ensures the `Scanner` is closed when the `try` block (or a `catch` block) finishes, releasing system resources.
 * 
 * 5.  **Best Practices:** The code follows best practices by using private fields, public methods for controlled access, meaningful names (`urgentQueue`, `processNextJob`, `jobHistory`), enums for clear state representation, and comments for clarification, particularly in the `cancelJob` method's iteration logic. The use of `offer` and `poll` for queues is standard practice.
 * 
 * This solution effectively integrates all the required Java components within a practical simulation, demonstrating understanding of data structures, object-oriented programming, user interaction, and robust error handling.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;

// Enum for Print Job Priority
enum Priority {
    URGENT, NORMAL, LOW
}

// Enum for Print Job Status
enum Status {
    QUEUED, PRINTING, COMPLETED, CANCELLED
}

// Represents a single print job
class PrintJob {
    private int id;
    private String name;
    private Priority priority;
    private Status status;

    // Constructor
    public PrintJob(int id, String name, Priority priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.status = Status.QUEUED; // Initial status is QUEUED
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    // Setter for status (only status can be changed externally)
    public void setStatus(Status status) {
        this.status = status;
    }

    // String representation of the job
    @Override
    public String toString() {
        return "Job{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", priority=" + priority +
               ", status=" + status +
               '}';
    }
}

// Simulates the print spooler system
public class PrintSpooler {
    // Queues for different priorities
    private Queue<PrintJob> urgentQueue;
    private Queue<PrintJob> normalQueue;
    private Queue<PrintJob> lowQueue;

    // History of all jobs (List interface used for declaration)
    private List<PrintJob> jobHistory;

    // Counter for generating unique job IDs
    private int nextJobId;

    // Scanner for user input (managed within the run method)
    // private Scanner scanner; // Moved to run method as per common practice

    // Constructor
    public PrintSpooler() {
        // Initialize queues using LinkedList
        this.urgentQueue = new LinkedList<>();
        this.normalQueue = new LinkedList<>();
        this.lowQueue = new LinkedList<>();

        // Initialize job history using ArrayList
        this.jobHistory = new ArrayList<>();

        this.nextJobId = 1; // Start job IDs from 1
    }

    /**
     * Submits a new print job to the spooler.
     * @param name The name of the job.
     * @param priority The priority of the job.
     */
    public void submitJob(String name, Priority priority) {
        int jobId = nextJobId++;
        PrintJob newJob = new PrintJob(jobId, name, priority);

        // Add the job to the appropriate queue
        switch (priority) {
            case URGENT:
                urgentQueue.offer(newJob); // offer is preferred over add for queues
                break;
            case NORMAL:
                normalQueue.offer(newJob);
                break;
            case LOW:
                lowQueue.offer(newJob);
                break;
        }

        // Add the job to the history list
        jobHistory.add(newJob);

        System.out.println(System.out.getClass().getName() + ": Job submitted: " + newJob);
    }

    /**
     * Displays the current jobs in the queues.
     */
    public void viewQueue() {
        System.out.println(System.out.getClass().getName() + ": --- Current Print Queue Status ---");
        System.out.println("Urgent Queue (" + urgentQueue.size() + " jobs):");
        printQueueContents(urgentQueue);
        System.out.println("Normal Queue (" + normalQueue.size() + " jobs):");
        printQueueContents(normalQueue);
        System.out.println("Low Queue (" + lowQueue.size() + " jobs):");
        printQueueContents(lowQueue);
        System.out.println("------------------------------------");
    }

    // Helper method to print queue contents
    private void printQueueContents(Queue<PrintJob> queue) {
        if (queue.isEmpty()) {
            System.out.println("  (Empty)");
        } else {
            // Iterate without removing elements
            for (PrintJob job : queue) {
                System.out.println("  " + job.getId() + ": " + job.getName() + " [" + job.getPriority() + "]");
            }
        }
    }

    /**
     * Processes the next available job based on priority (Urgent > Normal > Low).
     */
    public void processNextJob() {
        PrintJob jobToProcess = null;

        // Check queues in priority order
        if (!urgentQueue.isEmpty()) {
            jobToProcess = urgentQueue.poll(); // poll removes the head
        } else if (!normalQueue.isEmpty()) {
            jobToProcess = normalQueue.poll();
        } else if (!lowQueue.isEmpty()) {
            jobToProcess = lowQueue.poll();
        }

        if (jobToProcess != null) {
            // Find the job in history and update its status
            // Since we added the same object reference to history,
            // changing the object's status directly updates it in history.
            // If we had cloned, we'd need to find by ID.
            jobToProcess.setStatus(Status.COMPLETED);
            System.out.println(System.out.getClass().getName() + ": Processing job: " + jobToProcess.getName() + " (ID: " + jobToProcess.getId() + ")");
        } else {
            System.out.println(System.out.getClass().getName() + ": No jobs in the queue to process.");
        }
    }

    /**
     * Cancels a job with the given ID if it is currently in the queue.
     * @param jobId The ID of the job to cancel.
     */
    public void cancelJob(int jobId) {
        // Find the job in the history list
        PrintJob jobToCancel = null;
        for (PrintJob job : jobHistory) {
            if (job.getId() == jobId) {
                jobToCancel = job;
                break;
            }
        }

        if (jobToCancel == null) {
            System.err.println(System.err.getClass().getName() + ": Error: Job with ID " + jobId + " not found.");
            return;
        }

        // Check if the job is in a state that can be cancelled (i.e., QUEUED)
        if (jobToCancel.getStatus() != Status.QUEUED) {
            System.err.println(System.err.getClass().getName() + ": Error: Job with ID " + jobId + " is not in QUEUED status (Current status: " + jobToCancel.getStatus() + ") and cannot be cancelled.");
            return;
        }

        // Job is found and is QUEUED, now remove it from its specific queue
        boolean removedFromQueue = false;
        Queue<PrintJob> targetQueue = null;

        // Determine which queue the job should be in based on its original priority
        switch (jobToCancel.getPriority()) {
            case URGENT: targetQueue = urgentQueue; break;
            case NORMAL: targetQueue = normalQueue; break;
            case LOW: targetQueue = lowQueue; break;
        }

        // Use an iterator to safely remove the element while iterating
        if (targetQueue != null) {
            Iterator<PrintJob> iterator = targetQueue.iterator();
            while (iterator.hasNext()) {
                PrintJob jobInQueue = iterator.next();
                // Compare by ID to ensure we remove the correct job
                if (jobInQueue.getId() == jobId) {
                    iterator.remove(); // Safely remove the current element
                    removedFromQueue = true;
                    break; // Job found and removed, exit loop
                }
            }
        }

        // Update the status in the history list (the object reference is the same)
        if (removedFromQueue) {
             jobToCancel.setStatus(Status.CANCELLED);
             System.out.println(System.out.getClass().getName() + ": Job " + jobId + " cancelled successfully.");
        } else {
             // This case should ideally not happen if status was QUEUED,
             // but it's a safeguard.
             System.err.println(System.err.getClass().getName() + ": Error: Job " + jobId + " was in QUEUED status but not found in its queue.");
        }
    }

    // Helper method to print the command menu
    private void printMenu() {
        System.out.println("\n--- Print Spooler Menu ---");
        System.out.println("submit   - Submit a new print job");
        System.out.println("view     - View the current print queue");
        System.out.println("process  - Process the next job in the queue");
        System.out.println("cancel   - Cancel a job by ID");
        System.out.println("exit     - Exit the application");
        System.out.println("--------------------------");
    }

    // Main method to run the simulation
    public static void main(String[] args) {
        PrintSpooler spooler = new PrintSpooler();
        spooler.run(); // Start the simulation loop
    }

    // The main application loop
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Print Spooler Simulation!");

        boolean running = true;
        // Class-wide exception handling for the main operational loop
        try {
            while (running) {
                printMenu();
                System.out.print("Enter choice: ");
                String choice = scanner.nextLine().trim().toLowerCase();

                // Switch statement for handling user commands
                switch (choice) {
                    case "submit":
                        System.out.print("Enter job name: ");
                        String name = scanner.nextLine().trim();
                        System.out.print("Enter priority (urgent, normal, low): ");
                        String priorityStr = scanner.nextLine().trim().toLowerCase();

                        try {
                            Priority priority = Priority.valueOf(priorityStr.toUpperCase());
                            if (!name.isEmpty()) {
                                submitJob(name, priority);
                            } else {
                                System.err.println(System.err.getClass().getName() + ": Job name cannot be empty.");
                            }
                        } catch (IllegalArgumentException e) {
                            System.err.println(System.err.getClass().getName() + ": Invalid priority. Please enter 'urgent', 'normal', or 'low'.");
                        }
                        break;

                    case "view":
                        viewQueue();
                        break;

                    case "process":
                        processNextJob();
                        break;

                    case "cancel":
                        System.out.print("Enter Job ID to cancel: ");
                        // Specific try-catch for handling non-integer input
                        try {
                            int jobIdToCancel = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character left by nextInt()
                            cancelJob(jobIdToCancel);
                        } catch (InputMismatchException e) {
                            System.err.println(System.err.getClass().getName() + ": Invalid input. Please enter a valid integer Job ID.");
                            scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                        }
                        break;

                    case "exit":
                        running = false;
                        System.out.println(System.out.getClass().getName() + ": Exiting Print Spooler.");
                        break;

                    default:
                        System.err.println(System.err.getClass().getName() + ": Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions during the main loop execution
            System.err.println(System.err.getClass().getName() + ": An unexpected application error occurred: " + e.getMessage());
            // e.printStackTrace(); // Optional: uncomment for detailed debugging stack trace
        } finally {
            // Ensure the scanner is closed when the application exits or encounters a critical error
            scanner.close();
            System.out.println(System.out.getClass().getName() + ": Scanner closed.");
        }
    }
}
