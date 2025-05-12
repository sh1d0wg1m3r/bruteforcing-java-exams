/*
 * Exam Question #20
 * Generated on: 2025-05-11 21:39:55
 * 
 * QUESTION:
 * **Java Programming Exam: Package Processing Center Simulation**
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified simulation of a package processing center. Packages arrive, are placed in an incoming queue, processed one by one, and then moved to a list of processed packages. The simulation should allow a user to interact with the system through a command-line interface.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to represent the incoming packages waiting to be processed.
 *     *   Use a `java.util.ArrayList` to store packages after they have been processed.
 *     *   Declare the variable holding the processed packages using the `java.util.List` interface type.
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user commands and package details from standard input.
 * 3.  **Control Flow:**
 *     *   Use a `switch` statement to handle different user commands.
 * 4.  **Output:**
 *     *   Use `System.out` for displaying menus, successful operations, and package information.
 *     *   Use `System.err` for displaying error messages (e.g., invalid commands, empty queue operations, invalid input).
 * 5.  **Error Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks within the main operational loop of the system to handle unexpected issues during command processing.
 *     *   Implement specific input validation where necessary (e.g., ensuring a package exists before processing, validating command input).
 * 6.  **Classes:**
 *     *   Create a `Package` class with private fields for `packageId` (String), `destination` (String), and `status` (String, e.g., "WAITING", "PROCESSED", "REJECTED"). Include a constructor, getters, and a method to update the status. Include a meaningful `toString()` method.
 *     *   Create a `ProcessingCenter` class that manages the `Queue` and `List`. This class should contain methods for adding packages, processing the next package, viewing the queue, viewing processed packages, and a main method or run loop to handle user interaction.
 * 7.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments explaining the code.
 *     *   Ensure clean code structure.
 * 
 * **Functionality Details:**
 * 
 * *   **Add Package:** Prompt the user for a package ID and destination, create a `Package` object with status "WAITING", and add it to the incoming queue.
 * *   **Process Next Package:** Take the next package from the front of the queue. If the queue is empty, print an error to `System.err`. If a package is retrieved, simulate processing by asking the user for the processing result ('P' for Processed, 'R' for Rejected). Use a `switch` or if/else to handle the result, update the package's status accordingly, and move the package to the `processedPackages` list. Handle invalid processing input.
 * *   **View Queue:** Display the details of all packages currently in the incoming queue using `System.out`.
 * *   **View Processed:** Display the details of all packages in the processed packages list using `System.out`.
 * *   **Exit:** Terminate the program.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu of options to the user. Based on the user's input, it should perform the requested action, displaying success messages or package details to `System.out` and error messages to `System.err`.
 * 
 * **Example Interaction (Illustrative):**
 * 
 * ```
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 1
 * Enter Package ID: PKG001
 * Enter Destination: Zone A
 * Package PKG001 added to queue.
 * 
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 1
 * Enter Package ID: PKG002
 * Enter Destination: Zone B
 * Package PKG002 added to queue.
 * 
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 3
 * Incoming Queue:
 * [PKG001, Destination: Zone A, Status: WAITING]
 * [PKG002, Destination: Zone B, Status: WAITING]
 * 
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 2
 * Processing package: [PKG001, Destination: Zone A, Status: WAITING]
 * Enter processing result (P for Processed, R for Rejected): P
 * Package PKG001 status updated to PROCESSED.
 * 
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 4
 * Processed Packages:
 * [PKG001, Destination: Zone A, Status: PROCESSED]
 * 
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 2
 * Processing package: [PKG002, Destination: Zone B, Status: WAITING]
 * Enter processing result (P for Processed, R for Rejected): X
 * Invalid processing result. Package PKG002 status remains WAITING and moved to processed list.
 * Package PKG002 status updated to WAITING (due to invalid input).
 * 
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 4
 * Processed Packages:
 * [PKG001, Destination: Zone A, Status: PROCESSED]
 * [PKG002, Destination: Zone B, Status: WAITING]
 * 
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 6
 * Error: Invalid command. Please enter a number between 1 and 5.
 * 
 * --- Package Processing Center ---
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Incoming Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter command: 5
 * Exiting Processing Center.
 * ```
 * 
 * Your solution must adhere strictly to all requirements listed above.
 *
 * EXPLANATION:
 * This solution simulates a package processing center, demonstrating the required Java concepts in a practical context.
 * 
 * 1.  **`Package` Class:**
 *     *   Represents individual packages with `packageId`, `destination`, and `status`.
 *     *   Uses private fields and public getters for encapsulation.
 *     *   Includes a constructor with basic validation for ID and destination, throwing `IllegalArgumentException` if validation fails.
 *     *   The `setStatus` method includes a basic check for null/empty input and converts status to uppercase for consistency. It also prints a warning to `System.err` for invalid status strings.
 *     *   The `toString()` method provides a clear representation of a package object for printing.
 * 
 * 2.  **`ProcessingCenter` Class:**
 *     *   **Data Structures:**
 *         *   `incomingQueue`: Declared as `Queue<Package>` and initialized with `new LinkedList<>()`. `Queue` ensures FIFO (First-In, First-Out) order, simulating packages arriving and being processed in sequence. `LinkedList` is a common implementation suitable here as it supports efficient additions and removals from both ends.
 *         *   `processedPackages`: Declared as `List<Package>` and initialized with `new ArrayList<>()`. Using the `List` interface type is a best practice, allowing flexibility to change the underlying implementation (e.g., to `LinkedList` or `Vector`) later without changing the code that uses the `List` methods. `ArrayList` is suitable for storing processed items, providing fast random access (though not used extensively here) and dynamic resizing.
 *     *   **`Scanner`:** An instance of `Scanner` is created in the constructor to read user input from `System.in`. It's closed when the `run` loop exits.
 *     *   **Methods:**
 *         *   `addPackage()`: Prompts for package details, creates a `Package` object, and adds it to the `incomingQueue` using `offer()`. It includes a `try-catch` to handle `IllegalArgumentException` thrown by the `Package` constructor, printing the error to `System.err`.
 *         *   `processNextPackage()`:
 *             *   Checks if the `incomingQueue` is empty and prints an error to `System.err` if it is.
 *             *   Uses `poll()` to retrieve and remove the next package from the queue.
 *             *   Simulates processing by asking for user input ('P'/'R').
 *             *   Uses a `switch` statement to handle the user's input, updating the package status using the `setStatus` method. Invalid input is handled in the `default` case, printing a message to `System.err`.
 *             *   Adds the processed package (regardless of its final status) to the `processedPackages` list.
 *         *   `viewQueue()`: Iterates through the `incomingQueue` using an enhanced for loop (which does not remove elements) and prints each package's details to `System.out`.
 *         *   `viewProcessedPackages()`: Iterates through the `processedPackages` list and prints each package's details to `System.out`.
 *         *   `displayMenu()`: A private helper method to print the menu options to `System.out`.
 *         *   `run()`: This is the main execution method.
 *             *   It contains the primary loop that continues until the user chooses to exit (command 5).
 *             *   Inside the loop, it displays the menu and reads the user's command.
 *             *   A `try-catch (InputMismatchException e)` block is used specifically to handle cases where the user enters non-integer input for the command, printing an error to `System.err` and consuming the invalid input line to prevent an infinite loop.
 *             *   A broader `try-catch (Exception e)` block wraps the entire command processing logic within the loop. This serves as the "class-wide" exception handling, catching any other unexpected runtime exceptions that might occur during the execution of the chosen command (e.g., null pointer exceptions, index out of bounds, etc., although the specific methods are designed to minimize these). It prints the error message and stack trace to `System.err`.
 *             *   A `switch` statement dispatches control based on the valid integer command, calling the appropriate methods. The `default` case handles valid integer inputs that don't correspond to a command, printing an error to `System.err`.
 *     *   **`main` Method:** Creates an instance of `ProcessingCenter` and calls its `run()` method to start the application.
 * 
 * This solution effectively integrates all required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) while adhering to best practices like encapsulation, clear naming, and basic error handling, simulating a realistic workflow.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a package in the processing center
class Package {
    private String packageId;
    private String destination;
    private String status; // e.g., "WAITING", "PROCESSED", "REJECTED"

    // Constructor
    public Package(String packageId, String destination) {
        if (packageId == null || packageId.trim().isEmpty()) {
            throw new IllegalArgumentException("Package ID cannot be null or empty.");
        }
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty.");
        }
        this.packageId = packageId.trim();
        this.destination = destination.trim();
        this.status = "WAITING"; // Initial status
    }

    // Getters
    public String getPackageId() {
        return packageId;
    }

    public String getDestination() {
        return destination;
    }

    public String getStatus() {
        return status;
    }

    // Setter for status with basic validation
    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
             System.err.println("Warning: Attempted to set package status to null or empty string.");
             return; // Or throw an exception
        }
        String upperStatus = status.trim().toUpperCase();
        // Basic validation for common statuses, could be more robust
        if (upperStatus.equals("WAITING") || upperStatus.equals("PROCESSED") || upperStatus.equals("REJECTED") || upperStatus.equals("PROCESSING")) {
             this.status = upperStatus;
        } else {
            System.err.println("Warning: Attempted to set invalid package status: " + status);
            // Optionally set to a default or error status
            // this.status = "UNKNOWN_STATUS";
        }
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "[" + packageId + ", Destination: " + destination + ", Status: " + status + "]";
    }
}

// Manages the package processing flow
class ProcessingCenter {
    // Use Queue for incoming packages (FIFO)
    private Queue<Package> incomingQueue;
    // Use List for processed packages, declared with interface type
    private List<Package> processedPackages;
    private Scanner scanner;

    // Constructor
    public ProcessingCenter() {
        // LinkedList is a common implementation of Queue
        this.incomingQueue = new LinkedList<>();
        // ArrayList is a common implementation of List
        this.processedPackages = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new package to the incoming queue.
     */
    public void addPackage() {
        System.out.print("Enter Package ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        try {
            Package newPackage = new Package(id, destination);
            incomingQueue.offer(newPackage); // offer is preferred over add for queues as it doesn't throw exception on capacity limits (though LinkedList is unbounded)
            System.out.println("Package " + newPackage.getPackageId() + " added to queue.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding package: " + e.getMessage());
        }
    }

    /**
     * Processes the next package in the queue.
     * Moves the package to the processed list after handling.
     */
    public void processNextPackage() {
        // Check if the queue is empty
        if (incomingQueue.isEmpty()) {
            System.err.println("Error: Incoming queue is empty. No packages to process.");
            return;
        }

        // Retrieve the next package from the queue
        Package packageToProcess = incomingQueue.poll(); // poll returns null if queue is empty, but we already checked

        System.out.println("Processing package: " + packageToProcess);
        packageToProcess.setStatus("PROCESSING"); // Optional: indicate it's being processed

        System.out.print("Enter processing result (P for Processed, R for Rejected): ");
        String resultInput = scanner.nextLine().trim().toUpperCase();

        // Use switch to handle processing result
        switch (resultInput) {
            case "P":
                packageToProcess.setStatus("PROCESSED");
                System.out.println("Package " + packageToProcess.getPackageId() + " status updated to PROCESSED.");
                break;
            case "R":
                packageToProcess.setStatus("REJECTED");
                System.out.println("Package " + packageToProcess.getPackageId() + " status updated to REJECTED.");
                break;
            default:
                System.err.println("Invalid processing result '" + resultInput + "'. Package status remains " + packageToProcess.getStatus() + ".");
                // Keep current status, or set to an error status if desired
                // packageToProcess.setStatus("PROCESSING_ERROR"); // Example
                break;
        }

        // Move the package to the processed list regardless of the processing outcome
        processedPackages.add(packageToProcess);
    }

    /**
     * Displays the contents of the incoming queue.
     */
    public void viewQueue() {
        System.out.println("Incoming Queue:");
        if (incomingQueue.isEmpty()) {
            System.out.println("  Queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            for (Package pkg : incomingQueue) {
                System.out.println("  " + pkg);
            }
        }
    }

    /**
     * Displays the contents of the processed packages list.
     */
    public void viewProcessedPackages() {
        System.out.println("Processed Packages:");
        if (processedPackages.isEmpty()) {
            System.out.println("  No packages have been processed yet.");
        } else {
            // Iterate through the list
            for (Package pkg : processedPackages) {
                System.out.println("  " + pkg);
            }
        }
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Package Processing Center ---");
        System.out.println("1. Add Package");
        System.out.println("2. Process Next Package");
        System.out.println("3. View Incoming Queue");
        System.out.println("4. View Processed Packages");
        System.out.println("5. Exit");
        System.out.print("Enter command: ");
    }

    /**
     * The main operational loop for the processing center.
     * Includes class-wide exception handling.
     */
    public void run() {
        int command = 0;
        while (command != 5) {
            displayMenu();
            try {
                // Read command as an integer
                command = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Use switch for command handling
                switch (command) {
                    case 1:
                        addPackage();
                        break;
                    case 2:
                        processNextPackage();
                        break;
                    case 3:
                        viewQueue();
                        break;
                    case 4:
                        viewProcessedPackages();
                        break;
                    case 5:
                        System.out.println("Exiting Processing Center.");
                        break;
                    default:
                        System.err.println("Error: Invalid command. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Handles cases where the user enters non-integer input for the command
                System.err.println("Error: Invalid input. Please enter a number for the command.");
                scanner.nextLine(); // Consume the invalid input line to prevent infinite loop
                command = 0; // Reset command to stay in loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions during command execution
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to error stream for debugging
                // Optionally, decide if the program should exit or try to continue
                // For this simulation, we'll let it continue
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    // Main method to start the simulation
    public static void main(String[] args) {
        ProcessingCenter center = new ProcessingCenter();
        center.run();
    }
}
