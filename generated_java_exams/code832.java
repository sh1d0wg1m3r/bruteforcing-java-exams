/*
 * Exam Question #832
 * Generated on: 2025-05-12 16:47:50
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Automated Package Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified backend system for a logistics company to manage packages awaiting dispatch. The system needs to keep track of packages, process them for delivery, and maintain a history of all packages handled.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this package processing system. Your solution must adhere to the following requirements:
 * 
 * 1.  **Functionality:**
 *     *   Allow adding new packages to a waiting queue. Each package should have a unique ID and a destination.
 *     *   Allow dispatching the next package from the waiting queue. When a package is dispatched, it should be removed from the queue and its status updated in the system's history.
 *     *   Allow viewing all packages currently in the waiting queue without removing them.
 *     *   Allow viewing a complete history of all packages ever added to the system, including their current status (waiting or dispatched).
 *     *   Allow searching for a specific package in the history by its ID.
 *     *   Provide a menu-driven interface for the user to interact with the system.
 * 
 * 2.  **Required Java Components:** Your solution **must** explicitly use and demonstrate understanding of the following:
 *     *   `java.util.Queue` (as the type for the waiting queue)
 *     *   `java.util.ArrayList` (as the concrete implementation for the package history)
 *     *   `java.util.List` (as the interface type for the package history variable)
 *     *   `java.util.Scanner` for reading user input from the console.
 *     *   `switch` statement for handling the menu options.
 *     *   `System.err` for outputting all error messages (e.g., invalid input, queue empty, package not found error).
 *     *   `System.out` for outputting all normal messages (menu, prompts, success messages, package listings).
 *     *   Class-wide exception handling using `try-catch` blocks to manage potential runtime errors (e.g., invalid input format, issues with data structure operations).
 * 
 * 3.  **Best Practices:**
 *     *   Implement proper encapsulation using `private` fields and `public` methods.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc).
 *     *   Implement input validation (e.g., ensuring package ID/destination are not empty, handling non-numeric input for menu choices).
 *     *   Implement proper error handling for operational issues (e.g., trying to dispatch from an empty queue) and unexpected errors.
 *     *   Structure your code cleanly (e.g., separate concerns into classes like `Package` and `PackageProcessingSystem`).
 * 
 * **User Interaction:**
 * 
 * The program should present a menu like this:
 * 
 * ```
 * --- Package Processing System ---
 * Select an option:
 * 1. Add New Package
 * 2. Dispatch Next Package
 * 3. View Waiting Queue
 * 4. View Package History
 * 5. Find Package by ID
 * 6. Exit
 * Enter your choice:
 * ```
 * 
 * Based on the user's numeric input, the corresponding action should be performed. Invalid choices or inputs should be handled gracefully with error messages printed to `System.err`.
 * 
 * **Expected Output:**
 * 
 * *   Success messages, menu, prompts, and package listings should go to `System.out`.
 * *   All error messages resulting from invalid input, operational failures (like dispatching from an empty queue), or exceptions should go to `System.err`.
 * 
 * **Submission:**
 * 
 * Provide the complete Java code for the solution. You may include multiple classes in a single file for this exam task.
 *
 * EXPLANATION:
 * This solution implements the `Automated Package Processing System` using the required Java components and best practices.
 * 
 * 1.  **`Package` Class:**
 *     *   Represents a single package with `packageId`, `destination`, and `status` (`WAITING` or `DISPATCHED`).
 *     *   Fields are `private` demonstrating encapsulation.
 *     *   Public getters provide access to the fields.
 *     *   A `setStatus` method allows changing the package's state.
 *     *   The constructor includes basic input validation for ID and destination, throwing `IllegalArgumentException` if they are null or empty. This exception is caught in the `addPackage` method.
 *     *   `toString()` provides a convenient string representation for printing.
 *     *   `equals()` and `hashCode()` are overridden based on `packageId` to correctly identify unique packages, especially when searching the history list.
 * 
 * 2.  **`PackageProcessingSystem` Class:**
 *     *   This is the main class managing the system logic.
 *     *   It holds two key data structures as `private` fields:
 *         *   `waitingQueue`: Declared as `Queue<Package>` and instantiated as `LinkedList<Package>`. `LinkedList` is a common implementation of the `Queue` interface, providing FIFO (First-In, First-Out) behavior suitable for a waiting queue. Methods like `offer()` (add to tail) and `poll()` (remove from head) are used.
 *         *   `packageHistory`: Declared as `List<Package>` and instantiated as `ArrayList<Package>`. This list keeps a record of all packages ever added, allowing for viewing history and searching. `ArrayList` is a standard dynamic array implementation of the `List` interface.
 *     *   A `Scanner` instance is managed within the class for reading user input throughout the application lifecycle. It's closed in a `finally` block to release system resources.
 *     *   **`addPackage(String id, String dest)`:**
 *         *   Takes package details as input.
 *         *   Uses a `try-catch` block to handle potential `IllegalArgumentException` from the `Package` constructor (input validation).
 *         *   Includes a check to prevent adding packages with duplicate IDs by streaming and checking against the `packageHistory` list.
 *         *   If valid and unique, creates a `Package` object and adds it to both the `waitingQueue` (using `offer`) and the `packageHistory` list (using `add`).
 *         *   Prints success or error messages to `System.out` or `System.err` respectively.
 *     *   **`dispatchNextPackage()`:**
 *         *   Checks if the `waitingQueue` is empty using `isEmpty()`. If so, prints an error to `System.err` and returns. This is a common and preferred way to handle expected empty collections rather than relying on exceptions like `NoSuchElementException` from `remove()`.
 *         *   If the queue is not empty, it uses `waitingQueue.poll()` to retrieve and remove the next package. `poll()` is safer than `remove()` as it returns `null` if the queue is empty (though we already checked).
 *         *   It then iterates through the `packageHistory` list to find the corresponding package by ID and updates its status to "DISPATCHED" using the `setStatus` method.
 *         *   Prints success or warning messages to `System.out` or `System.err`.
 *     *   **`viewWaitingQueue()`:** Iterates through the `waitingQueue` (using `forEach` or an iterator) and prints each package's details using `System.out`, without removing elements. Handles the empty case.
 *     *   **`viewPackageHistory()`:** Iterates through the `packageHistory` list and prints details of all packages using `System.out`. Handles the empty case.
 *     *   **`findPackageInHistory(String packageId)`:** Takes an ID, validates it, iterates through the `packageHistory` list to find a matching package, and prints its details or a "not found" message to `System.out`. Uses `System.err` for validation errors.
 *     *   **`startSystem()`:**
 *         *   Contains the main application loop and user interaction logic.
 *         *   A `try-catch(Exception e)` block wraps the main `while` loop. This provides "class-wide" exception handling as a fallback for any unexpected runtime errors that might occur within the loop's execution and are not handled by more specific catches. Error details are printed to `System.err`, including a stack trace for debugging.
 *         *   Inside the loop, it prints the menu using `System.out`.
 *         *   It reads user input using `scanner.nextLine()`.
 *         *   A nested `try-catch(NumberFormatException e)` block is used specifically to handle cases where the user input for the menu choice is not a valid integer. The error is printed to `System.err`, and the loop continues.
 *         *   A `switch` statement is used to direct the program flow based on the valid integer choice, calling the appropriate methods.
 *         *   The `default` case in the `switch` handles invalid numeric choices, printing an error to `System.err`.
 *         *   A `finally` block ensures the `scanner` is closed before the method (and thus the application) exits, regardless of whether an exception occurred.
 *     *   **`main(String[] args)`:** The entry point of the application. It creates an instance of `PackageProcessingSystem` and calls its `startSystem()` method.
 * 
 * This solution effectively integrates the required data structures and control flow mechanisms, demonstrates input validation, error handling using both `System.out`/`System.err` and `try-catch` blocks (specific and general), and follows key object-oriented principles like encapsulation. The scenario provides a practical context for using these concepts together.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Represents a package in the delivery system.
 * Follows encapsulation best practices.
 */
class Package {
    private String packageId;
    private String destination;
    private String status; // e.g., "WAITING", "DISPATCHED"

    /**
     * Constructs a new Package.
     * Status is initialized to "WAITING".
     *
     * @param packageId   The unique identifier for the package.
     * @param destination The destination address for the package.
     * @throws IllegalArgumentException if packageId or destination is null or empty.
     */
    public Package(String packageId, String destination) {
        if (packageId == null || packageId.trim().isEmpty()) {
            throw new IllegalArgumentException("Package ID cannot be null or empty.");
        }
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be null or empty.");
        }
        this.packageId = packageId.trim();
        this.destination = destination.trim();
        this.status = "WAITING"; // Default status
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

    // Setter for status
    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
             System.err.println("Warning: Attempted to set package status to null or empty. Status unchanged.");
             return;
        }
        this.status = status.trim().toUpperCase(); // Standardize status
    }

    @Override
    public String toString() {
        return "Package [ID=" + packageId + ", Destination=" + destination + ", Status=" + status + "]";
    }

    // Override equals and hashCode based on packageId for easy searching/comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(packageId, aPackage.packageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packageId);
    }
}

/**
 * Manages the processing and history of packages.
 * Uses a Queue for packages awaiting dispatch and a List for package history.
 * Contains the main application logic and user interaction.
 */
public class PackageProcessingSystem {

    private Queue<Package> waitingQueue;
    private List<Package> packageHistory; // Using List interface, implementation is ArrayList
    private Scanner scanner; // Scanner for user input

    /**
     * Constructs a new PackageProcessingSystem.
     * Initializes the waiting queue (LinkedList) and package history (ArrayList).
     */
    public PackageProcessingSystem() {
        waitingQueue = new LinkedList<>(); // LinkedList implements Queue
        packageHistory = new ArrayList<>(); // ArrayList implements List
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a new package to the system.
     * The package is added to both the waiting queue and the history list.
     * Performs basic validation and error handling.
     *
     * @param packageId   The ID of the package.
     * @param destination The destination of the package.
     */
    public void addPackage(String packageId, String destination) {
        try {
            // Package constructor performs basic validation (null/empty check)
            Package newPackage = new Package(packageId, destination);

            // Check if package ID already exists in history (basic uniqueness check)
            boolean exists = packageHistory.stream().anyMatch(p -> p.getPackageId().equals(newPackage.getPackageId()));
            if (exists) {
                 System.err.println("Error: Package with ID '" + packageId + "' already exists in history.");
                 return; // Do not add if ID exists
            }

            waitingQueue.offer(newPackage); // Add to the end of the queue. offer is safer than add (returns false on failure)
            packageHistory.add(newPackage); // Add to history
            System.out.println("Package added successfully: " + newPackage.getPackageId());

        } catch (IllegalArgumentException e) {
            // Handles validation errors from Package constructor
            System.err.println("Error adding package: " + e.getMessage());
        } catch (Exception e) {
            // Fallback for any other unexpected error during package creation/addition
            System.err.println("An unexpected error occurred while adding the package: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace for debugging
        }
    }

    /**
     * Dispatches the next package from the waiting queue.
     * The package is removed from the queue and its status in the history is updated.
     * Handles the case where the queue is empty.
     */
    public void dispatchNextPackage() {
        if (waitingQueue.isEmpty()) {
            System.err.println("Error: Waiting queue is empty. No packages to dispatch.");
            return;
        }

        try {
            Package dispatchedPackage = waitingQueue.poll(); // Get and remove the head of the queue. poll is safer than remove (returns null if empty)

            if (dispatchedPackage != null) {
                // Find the corresponding package in the history list and update its status
                boolean foundInHistory = false;
                for (Package p : packageHistory) {
                    if (p.getPackageId().equals(dispatchedPackage.getPackageId())) {
                        p.setStatus("DISPATCHED");
                        foundInHistory = true;
                        break; // Found and updated, exit loop
                    }
                }

                if (foundInHistory) {
                     System.out.println("Package dispatched successfully: " + dispatchedPackage.getPackageId());
                } else {
                     // This case should ideally not happen if package was added correctly to history
                     System.err.println("Warning: Dispatched package " + dispatchedPackage.getPackageId() + " not found in history to update status.");
                }

            } else {
                // Should technically not be reached if isEmpty() check passes and poll() returns null,
                // but included for robustness. poll() on an empty queue returns null, not throws exception.
                 System.err.println("Error: Failed to retrieve package from queue (poll returned null unexpectedly).");
            }
        } catch (Exception e) {
             // Catch any other potential runtime errors during dispatch process
             System.err.println("An unexpected error occurred during dispatch: " + e.getMessage());
             e.printStackTrace(System.err); // Print stack trace for debugging
        }
    }

    /**
     * Displays all packages currently in the waiting queue.
     */
    public void viewWaitingQueue() {
        System.out.println("\n--- Waiting Queue ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            // LinkedList iterator provides elements in insertion order (FIFO)
            waitingQueue.forEach(System.out::println);
        }
        System.out.println("---------------------\n");
    }

    /**
     * Displays the history of all packages processed by the system.
     */
    public void viewPackageHistory() {
        System.out.println("\n--- Package History ---");
        if (packageHistory.isEmpty()) {
            System.out.println("History is empty.");
        } else {
            // Iterate through the history list (ArrayList)
            packageHistory.forEach(System.out::println);
        }
        System.out.println("-----------------------\n");
    }

    /**
     * Finds and displays a package from the history by its ID.
     * Handles case where ID is empty or package is not found.
     *
     * @param packageId The ID of the package to find.
     */
    public void findPackageInHistory(String packageId) {
         if (packageId == null || packageId.trim().isEmpty()) {
             System.err.println("Error: Package ID for search cannot be empty.");
             return;
         }
         String searchId = packageId.trim();
         System.out.println("\n--- Searching for Package ID: " + searchId + " ---");
         Package foundPackage = null;
         // Search the list (ArrayList)
         for (Package p : packageHistory) {
             if (p.getPackageId().equals(searchId)) {
                 foundPackage = p;
                 break; // Found it, stop searching
             }
         }

         if (foundPackage != null) {
             System.out.println("Found: " + foundPackage);
         } else {
             System.out.println("Package with ID '" + searchId + "' not found in history.");
         }
         System.out.println("---------------------------\n");
    }

    /**
     * Starts the package processing system interactive console.
     * Handles user input and directs operations via a menu using a switch statement.
     * Includes class-wide exception handling around the main loop and specific handling for input parsing.
     */
    public void startSystem() {
        int choice = -1;
        System.out.println("--- Welcome to Package Processing System ---");

        // Class-wide exception handling using try-catch around the main loop.
        // This acts as a final fallback for unexpected errors in the loop structure or method calls not handled internally.
        try {
            while (choice != 6) {
                printMenu();

                System.out.print("Enter your choice: ");
                String input = scanner.nextLine();

                try {
                    // Specific exception handling for parsing user input
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    choice = -1; // Reset choice to prevent unintended case matching
                    continue; // Skip the switch and go to the next iteration
                }

                // Use switch for menu navigation
                switch (choice) {
                    case 1:
                        System.out.print("Enter Package ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Destination: ");
                        String dest = scanner.nextLine();
                        addPackage(id, dest); // addPackage has its own try-catch for validation
                        break;
                    case 2:
                        dispatchNextPackage(); // dispatchNextPackage has its own checks and try-catch
                        break;
                    case 3:
                        viewWaitingQueue();
                        break;
                    case 4:
                        viewPackageHistory();
                        break;
                    case 5:
                        System.out.print("Enter Package ID to find: ");
                        String searchId = scanner.nextLine();
                        findPackageInHistory(searchId); // findPackageInHistory has its own validation
                        break;
                    case 6:
                        System.out.println("Exiting System. Goodbye!");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                }
                System.out.println(); // Add a newline for better formatting between actions
            }
        } catch (Exception e) {
            // General catch-all for any unexpected exceptions not handled elsewhere
            System.err.println("An unexpected system error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace for debugging to error stream
        } finally {
            // Ensure scanner is closed when the system exits (either normally or via exception)
            if (scanner != null) {
                scanner.close();
                // System.out.println("Scanner closed."); // Optional confirmation
            }
        }
    }

    /**
     * Prints the main menu options to the console using System.out.
     */
    private void printMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Add New Package");
        System.out.println("2. Dispatch Next Package");
        System.out.println("3. View Waiting Queue");
        System.out.println("4. View Package History");
        System.out.println("5. Find Package by ID");
        System.out.println("6. Exit");
    }

    /**
     * Main method to start the application.
     * Creates an instance of PackageProcessingSystem and calls startSystem().
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        PackageProcessingSystem system = new PackageProcessingSystem();
        system.startSystem();
    }
}
