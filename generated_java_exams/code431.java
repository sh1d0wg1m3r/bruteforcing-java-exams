/*
 * Exam Question #431
 * Generated on: 2025-05-11 23:10:07
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Print Queue Management System
 * 
 * **Objective:** Design and implement a console-based Print Queue Management System that simulates adding, processing, listing, and canceling print jobs. This task requires demonstrating proficiency in using various Java collection types, handling user input, implementing control flow, managing errors, and adhering to object-oriented principles.
 * 
 * **Scenario:** You are building a simplified backend system for a print server. Print jobs arrive and are held in a queue until the printer is ready to process them. Users can interact with the system via commands to manage their print jobs.
 * 
 * **Requirements:**
 * 
 * 1.  **PrintJob Class:** Create a class `PrintJob` with private fields for `jobId` (int, unique identifier), `fileName` (String), and `pages` (int). Include a constructor, public getter methods for all fields, and a meaningful `toString()` method. Implement `equals()` and `hashCode()` based on `jobId`.
 * 
 * 2.  **PrintQueueManager Class:** Create a class `PrintQueueManager` responsible for managing the print jobs.
 *     *   It must use a `java.util.Queue<PrintJob>` as its internal data structure to hold pending print jobs. Use `java.util.LinkedList` as the concrete implementation which also implements `List`.
 *     *   Maintain a mechanism to generate unique `jobId`s (e.g., a simple counter).
 *     *   Implement the following public methods:
 *         *   `addJob(String fileName, int pages)`: Creates a new `PrintJob`, assigns a unique ID, and adds it to the queue. Returns the created `PrintJob` or its ID.
 *         *   `processNextJob()`: Removes and returns the next job from the front of the queue (FIFO). Returns `null` if the queue is empty.
 *         *   `listAllJobs()`: Returns a `java.util.List<PrintJob>` containing all jobs currently in the queue, in queue order. Use `java.util.ArrayList` as the concrete implementation for the returned list.
 *         *   `cancelJob(int jobId)`: Removes the job with the specified `jobId` from the queue. Returns `true` if a job with the ID was found and removed, `false` otherwise. This method must correctly handle removing an element from the `Queue` (consider using an `Iterator` for safe removal).
 * 
 * 3.  **PrintQueueApp Class (Main Application):**
 *     *   This class will contain the `main` method and the main application logic.
 *     *   Use `java.util.Scanner` to read user commands from the console.
 *     *   Implement a command loop that continuously prompts the user for input until an "exit" command is given.
 *     *   Use a `switch` statement to handle different commands:
 *         *   `add <filename> <pages>`: Reads filename and pages, calls `manager.addJob()`. Pages must be a positive integer. Filename must not be empty.
 *         *   `process`: Calls `manager.processNextJob()`.
 *         *   `list`: Calls `manager.listAllJobs()` and prints the details of all jobs in the returned `List`.
 *         *   `cancel <jobId>`: Reads jobId, calls `manager.cancelJob()`. JobId must be a positive integer.
 *         *   `exit`: Terminates the application.
 *     *   Implement input validation for commands and their arguments (e.g., checking number of arguments, ensuring pages/jobId are positive integers).
 *     *   Use `System.out` for displaying the menu, successful operations, and the list of jobs.
 *     *   Use `System.err` for displaying all error messages (e.g., invalid command, invalid input format, queue empty, job not found).
 *     *   Implement **class-wide exception handling** using `try-catch` blocks to gracefully handle potential errors during execution, such as `NumberFormatException` for invalid integer input or unexpected runtime issues.
 * 
 * 4.  **General Requirements:**
 *     *   Ensure proper encapsulation (private fields, public methods) in all classes.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes and methods).
 *     *   Adhere to clean code structure.
 * 
 * **Required Java Components Checklist:**
 * 
 * *   `java.util.Queue`: Yes
 * *   `java.util.ArrayList`: Yes
 * *   `java.util.List`: Yes (as return type of `listAllJobs`)
 * *   `java.util.Scanner`: Yes
 * *   `switch` statement: Yes
 * *   `System.err`: Yes
 * *   `System.out`: Yes
 * *   Class-wide exception handling with `try-catch`: Yes
 * 
 * **Expected Interaction (Example):**
 * 
 * ```
 * --- Print Queue Management System ---
 * Available commands: add <filename> <pages>, process, list, cancel <jobId>, exit
 * Enter command: add report.pdf 10
 * Job added: Job ID: 1, File: report.pdf, Pages: 10
 * 
 * Available commands: add image.png 5
 * Job added: Job ID: 2, File: image.png, Pages: 5
 * 
 * Available commands: list
 * Pending Jobs:
 * Job ID: 1, File: report.pdf, Pages: 10
 * Job ID: 2, File: image.png, Pages: 5
 * 
 * Available commands: process
 * Processing job: Job ID: 1, File: report.pdf, Pages: 10
 * 
 * Available commands: list
 * Pending Jobs:
 * Job ID: 2, File: image.png, Pages: 5
 * 
 * Available commands: cancel 2
 * Job ID 2 cancelled.
 * 
 * Available commands: list
 * No jobs in the queue.
 * 
 * Available commands: process
 * Error: Print queue is empty.
 * 
 * Available commands: cancel 99
 * Error: Job with ID 99 not found.
 * 
 * Available commands: add doc.txt abc
 * Error: Invalid number format for pages.
 * 
 * Available commands: add
 * Error: Invalid number of arguments for 'add' command. Usage: add <filename> <pages>
 * 
 * Available commands: invalid_command
 * Error: Unknown command.
 * 
 * Available commands: exit
 * Exiting system.
 * ```
 * 
 * **Submission:** Provide the complete Java code for all necessary classes (`PrintJob`, `PrintQueueManager`, `PrintQueueApp`).
 *
 * EXPLANATION:
 * This solution implements a basic Print Queue Management System as requested, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **`PrintJob` Class:**
 *     *   Represents a single print job with `jobId`, `fileName`, and `pages`.
 *     *   Fields are `private` for encapsulation.
 *     *   Public getters provide controlled access to the data.
 *     *   The constructor includes basic validation (`jobId > 0`, `fileName` not empty, `pages > 0`) and throws `IllegalArgumentException`, promoting robust object creation.
 *     *   `toString()` provides a user-friendly representation.
 *     *   `equals()` and `hashCode()` are overridden based on `jobId`, which is crucial for correctly identifying and removing jobs from collections like `LinkedList` when using methods that rely on object equality (though `cancelJob` uses iterator removal by ID match, having `equals` and `hashCode` based on the unique ID is generally good practice for such objects).
 * 
 * 2.  **`PrintQueueManager` Class:**
 *     *   Manages the collection of `PrintJob` objects.
 *     *   Uses a `Queue<PrintJob>` called `printQueue`. The concrete implementation is `LinkedList`, which is suitable because it implements `Queue` (for FIFO operations like `offer` and `poll`) and also provides an `Iterator` that supports safe element removal during iteration, which is needed for the `cancelJob` method.
 *     *   `nextJobId` is a simple counter ensuring unique IDs for new jobs.
 *     *   `addJob(String fileName, int pages)`: Creates a `PrintJob` (which validates input), adds it to the end of the queue using `offer()`, and increments the ID counter.
 *     *   `processNextJob()`: Uses `poll()` to retrieve and remove the job at the head of the queue. Returns `null` if the queue is empty, which the caller handles.
 *     *   `listAllJobs()`: Iterates through the `printQueue` and copies each `PrintJob` into a new `ArrayList<PrintJob>`. This demonstrates using an `ArrayList` and returning a `List` interface type, providing a snapshot of the queue contents without exposing or modifying the internal queue structure directly.
 *     *   `cancelJob(int jobId)`: This is a key method demonstrating iteration and removal from a `Queue` implementation. It obtains an `Iterator` from the `printQueue`. It then iterates through the jobs, checking if the current job's ID matches the target `jobId`. If a match is found, `iterator.remove()` is called. Using the iterator's `remove()` method is the correct and safe way to remove elements from a collection while iterating over it, avoiding `ConcurrentModificationException`.
 * 
 * 3.  **`PrintQueueApp` Class:**
 *     *   Contains the `main` method, serving as the application entry point.
 *     *   Uses `Scanner` to read lines of input from `System.in`.
 *     *   The `run()` method contains the main application loop.
 *     *   **Class-wide Exception Handling:** The core of the `run()` method (the `while` loop) is wrapped in a `try-catch(Exception e)`. This outer block catches any unhandled exceptions that might occur during the application's runtime, printing a critical error message to `System.err` and ensuring the `scanner` is closed in the `finally` block.
 *     *   **Command Handling:** Inside the loop, user input is split, and a `switch` statement on the command string directs execution to specific handler methods (`handleAddCommand`, `handleProcessCommand`, etc.).
 *     *   **Specific Exception Handling & Validation:** Each command handler method includes logic for:
 *         *   Checking the correct number of arguments (`parts.length`). An `IllegalArgumentException` is thrown for incorrect usage.
 *         *   Parsing integer arguments (`pages`, `jobId`). This operation is wrapped in a `try-catch(NumberFormatException)` within the `run` method's inner `try` block to catch invalid number inputs.
 *         *   Additional validation (e.g., `jobId > 0`, `pages > 0`, `fileName` not empty) is done either directly in the handler or delegated to the `PrintJob` constructor/manager methods which throw `IllegalArgumentException`. These are also caught by the inner `try-catch` block in `run`.
 *         *   Error messages for validation failures or command issues are printed to `System.err`.
 *     *   **Output:** Success messages, the menu, and the job list are printed to `System.out`.
 *     *   `System.err` is used exclusively for error reporting, distinguishing it from normal program output.
 *     *   The `exit` command terminates the `run()` method, leading to the `finally` block where the `Scanner` is closed.
 * 
 * This solution effectively integrates `Queue`, `List`, `ArrayList`, `Scanner`, `switch`, `System.out`, `System.err`, and `try-catch` blocks in a practical, object-oriented design, demonstrating advanced Java concepts like collection manipulation, iteration with removal, input handling, and structured error management.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Objects; // For Objects.hash and Objects.equals

/**
 * Represents a single print job.
 */
class PrintJob {
    private final int jobId;
    private final String fileName;
    private final int pages;

    /**
     * Constructs a new PrintJob.
     * @param jobId The unique identifier for the job.
     * @param fileName The name of the file to print.
     * @param pages The number of pages in the file.
     */
    public PrintJob(int jobId, String fileName, int pages) {
        if (jobId <= 0) {
            throw new IllegalArgumentException("Job ID must be positive.");
        }
        if (fileName == null || fileName.trim().isEmpty()) {
            throw new IllegalArgumentException("File name cannot be empty.");
        }
        if (pages <= 0) {
            throw new IllegalArgumentException("Number of pages must be positive.");
        }
        this.jobId = jobId;
        this.fileName = fileName.trim();
        this.pages = pages;
    }

    // --- Getters ---
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
     * @return A formatted string describing the job.
     */
    @Override
    public String toString() {
        return "Job ID: " + jobId + ", File: " + fileName + ", Pages: " + pages;
    }

    /**
     * Compares this PrintJob to another object for equality based on jobId.
     * @param o The object to compare with.
     * @return true if the objects are equal (same jobId), false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrintJob printJob = (PrintJob) o;
        return jobId == printJob.jobId;
    }

    /**
     * Returns a hash code value for the PrintJob based on jobId.
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(jobId);
    }
}

/**
 * Manages a queue of print jobs.
 */
class PrintQueueManager {
    // Use LinkedList which implements both Queue and List, allowing iteration for cancel
    private Queue<PrintJob> printQueue;
    private int nextJobId; // Counter for unique job IDs

    /**
     * Constructs a new PrintQueueManager.
     */
    public PrintQueueManager() {
        this.printQueue = new LinkedList<>();
        this.nextJobId = 1; // Start job IDs from 1
    }

    /**
     * Adds a new print job to the queue.
     * @param fileName The name of the file.
     * @param pages The number of pages.
     * @return The newly created PrintJob.
     * @throws IllegalArgumentException if fileName or pages are invalid.
     */
    public PrintJob addJob(String fileName, int pages) {
        // PrintJob constructor handles validation and throws IllegalArgumentException
        PrintJob newJob = new PrintJob(nextJobId, fileName, pages);
        printQueue.offer(newJob); // offer is generally preferred over add for queues
        nextJobId++; // Increment for the next job
        return newJob;
    }

    /**
     * Processes (removes) the next job from the queue.
     * @return The processed PrintJob, or null if the queue is empty.
     */
    public PrintJob processNextJob() {
        return printQueue.poll(); // poll removes and returns the head, or null if empty
    }

    /**
     * Returns a list of all jobs currently in the queue.
     * The list is a snapshot and does not modify the queue.
     * @return A List of PrintJob objects in queue order.
     */
    public List<PrintJob> listAllJobs() {
        List<PrintJob> jobsList = new ArrayList<>();
        // Iterate over the queue and add jobs to the ArrayList
        // The iteration order of LinkedList (used as Queue) is insertion order
        for (PrintJob job : printQueue) {
            jobsList.add(job);
        }
        return jobsList;
    }

    /**
     * Cancels a specific job by its ID.
     * Iterates through the queue to find and remove the job.
     * @param jobId The ID of the job to cancel.
     * @return true if a job with the ID was found and removed, false otherwise.
     */
    public boolean cancelJob(int jobId) {
        // Use an Iterator for safe removal while iterating
        Iterator<PrintJob> iterator = printQueue.iterator();
        while (iterator.hasNext()) {
            PrintJob job = iterator.next();
            if (job.getJobId() == jobId) {
                iterator.remove(); // Safely remove the current element
                return true; // Job found and removed
            }
        }
        return false; // Job with given ID not found
    }
}

/**
 * Main application class for the Print Queue Management System.
 * Handles user interaction, command parsing, and calls to the PrintQueueManager.
 * Demonstrates Scanner, switch, System.out/err, and try-catch handling.
 */
public class PrintQueueApp {
    private PrintQueueManager manager;
    private Scanner scanner;

    /**
     * Constructs a new PrintQueueApp.
     */
    public PrintQueueApp() {
        this.manager = new PrintQueueManager();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the available commands menu.
     */
    private void displayMenu() {
        System.out.println("Available commands: add <filename> <pages>, process, list, cancel <jobId>, exit");
    }

    /**
     * Runs the main application loop.
     * Includes class-wide exception handling.
     */
    public void run() {
        System.out.println("--- Print Queue Management System ---");

        // Class-wide exception handling wrapping the main loop
        try {
            while (true) {
                displayMenu();
                System.out.print("Enter command: ");
                String inputLine = scanner.nextLine().trim();

                if (inputLine.isEmpty()) {
                    System.err.println("Error: No command entered.");
                    System.out.println(); // Add a newline for readability
                    continue; // Skip to next iteration
                }

                String[] parts = inputLine.split("\\s+");
                String command = parts[0].toLowerCase();

                // Specific try-catch for handling errors within command execution
                try {
                    switch (command) {
                        case "add":
                            handleAddCommand(parts);
                            break;
                        case "process":
                            handleProcessCommand();
                            break;
                        case "list":
                            handleListCommand();
                            break;
                        case "cancel":
                            handleCancelCommand(parts);
                            break;
                        case "exit":
                            System.out.println("Exiting system.");
                            return; // Exit the run method
                        default:
                            System.err.println("Error: Unknown command.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid number format in input. Please ensure pages/job ID are integers.");
                } catch (IllegalArgumentException e) {
                    // Catch validation errors thrown by PrintJob constructor or manager methods
                    System.err.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    // Catch any other unexpected runtime exceptions during command handling
                    System.err.println("An unexpected error occurred during command execution: " + e.getMessage());
                    // Optional: e.printStackTrace(System.err); // Uncomment for debugging
                }
                System.out.println(); // Add a newline for readability after each command
            }
        } catch (Exception e) {
            // Catch any critical exceptions outside the command processing loop (e.g., Scanner issues)
            System.err.println("A critical system error occurred: " + e.getMessage());
            // Optional: e.printStackTrace(System.err); // Uncomment for debugging
        } finally {
            // Ensure the scanner is closed when the application exits or a critical error occurs
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Handles the 'add' command.
     * @param parts The command parts split by space.
     * @throws IllegalArgumentException if command arguments are invalid.
     * @throws NumberFormatException if pages argument is not an integer.
     */
    private void handleAddCommand(String[] parts) {
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid number of arguments for 'add' command. Usage: add <filename> <pages>");
        }
        String fileName = parts[1];
        int pages = Integer.parseInt(parts[2]); // Potential NumberFormatException

        // Manager's addJob method will validate fileName and pages > 0
        PrintJob addedJob = manager.addJob(fileName, pages);
        System.out.println("Job added: " + addedJob);
    }

    /**
     * Handles the 'process' command.
     */
    private void handleProcessCommand() {
        PrintJob processedJob = manager.processNextJob();
        if (processedJob == null) {
            System.err.println("Error: Print queue is empty. No jobs to process.");
        } else {
            System.out.println("Processing job: " + processedJob);
            // Simulate printing...
        }
    }

    /**
     * Handles the 'list' command.
     */
    private void handleListCommand() {
        List<PrintJob> jobs = manager.listAllJobs();
        if (jobs.isEmpty()) {
            System.out.println("No jobs in the queue.");
        } else {
            System.out.println("Pending Jobs:");
            for (PrintJob job : jobs) {
                System.out.println(job);
            }
        }
    }

    /**
     * Handles the 'cancel' command.
     * @param parts The command parts split by space.
     * @throws IllegalArgumentException if command arguments are invalid.
     * @throws NumberFormatException if jobId argument is not an integer.
     */
    private void handleCancelCommand(String[] parts) {
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid number of arguments for 'cancel' command. Usage: cancel <jobId>");
        }
        int jobId = Integer.parseInt(parts[1]); // Potential NumberFormatException

        if (jobId <= 0) {
             throw new IllegalArgumentException("Job ID must be positive.");
        }

        boolean cancelled = manager.cancelJob(jobId);
        if (cancelled) {
            System.out.println("Job ID " + jobId + " cancelled.");
        } else {
            System.err.println("Error: Job with ID " + jobId + " not found.");
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        PrintQueueApp app = new PrintQueueApp();
        app.run();
    }
}
