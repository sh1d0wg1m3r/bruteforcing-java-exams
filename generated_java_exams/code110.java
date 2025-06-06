/*
 * Exam Question #110
 * Generated on: 2025-05-11 22:15:54
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Package Processing Center Simulation
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a Java program to simulate the operations of a small package processing center. The center receives packages, queues them for processing in the order they arrive, and maintains a record of all packages that have been successfully processed. The system must be interactive, allowing users to manage packages via a command-line interface.
 * 
 * **Requirements:**
 * 
 * 1.  **Package Class:** Create a class named `Package` to represent a single package. It must have the following private fields:
 *     *   `id` (String): A unique identifier for the package.
 *     *   `destination` (String): The package's delivery destination.
 *     *   `weight` (double): The weight of the package in kilograms.
 *     *   `status` (String): Represents the current state, e.g., "Waiting", "Processed".
 *     *   Implement a constructor that initializes these fields and sets the initial status to "Waiting". Include basic validation in the constructor: `id` and `destination` cannot be null or empty, `weight` must be positive.
 *     *   Provide public getter methods for all fields.
 *     *   Include a public method `setStatus(String status)` to update the package's status.
 *     *   Override the `toString()` method to provide a clear string representation of the package's details.
 * 
 * 2.  **Processing System Class:** Create a class named `PackageProcessingSystem` (or similar) to manage the collection of packages. This class must contain:
 *     *   A private field using the `java.util.Queue` interface (specifically implemented by `java.util.LinkedList`) to store packages waiting to be processed in a FIFO (First-In, First-Out) manner.
 *     *   A private field using the `java.util.List` interface (specifically implemented by `java.util.ArrayList`) to store packages that have been processed.
 *     *   A private field for a `java.util.Scanner` object to handle user input.
 *     *   Implement the following public methods:
 *         *   `addPackage()`: Prompts the user for package details (ID, destination, weight) using the `Scanner`. Creates a new `Package` object and adds it to the processing queue. Handle potential input errors.
 *         *   `processNextPackage()`: Removes the package at the front of the processing queue. Updates its status to "Processed" and adds it to the list of processed packages. If the queue is empty, inform the user.
 *         *   `findPackage()`: Prompts the user for a Package ID. Searches both the processing queue and the processed list for a package with the matching ID (case-insensitive comparison is acceptable). Report whether the package was found and its current status and details.
 *         *   `displayProcessingQueue()`: Prints the details of all packages currently in the processing queue without removing them.
 *         *   `displayProcessedPackages()`: Prints the details of all packages in the processed list.
 *         *   `run()`: This method should contain the main application loop. It should repeatedly display a menu of options (Add Package, Process Next, Find, Display Queue, Display Processed, Exit) and use a `switch` statement to execute the corresponding method based on the user's integer input.
 * 
 * 3.  **Input/Output and Error Handling:**
 *     *   Use `java.util.Scanner` for all user input.
 *     *   Use `System.out` for displaying the menu, successful operations, and package lists/queue contents.
 *     *   Use `System.err` for displaying all error messages, such as invalid input, package validation failures, or attempts to process from an empty queue (though informing the user of an empty queue might also be done via `System.out` depending on your design choice, but validation/input errors *must* use `System.err`).
 *     *   Implement comprehensive exception handling using `try-catch` blocks. Specifically, handle:
 *         *   `java.util.InputMismatchException` when the user enters non-integer input for the menu choice or non-numeric input for weight.
 *         *   `java.lang.IllegalArgumentException` thrown by the `Package` constructor due to invalid package details.
 *         *   `java.util.NoSuchElementException` if attempting to remove an element from an empty queue (e.g., using `queue.remove()`).
 *         *   Include a general `try-catch` block around the main loop in the `run()` method to catch any other unexpected runtime exceptions and print an error message along with the stack trace to `System.err`.
 *     *   Ensure the `Scanner` resource is closed properly when the application exits (e.g., in a `finally` block or using try-with-resources if appropriate for the structure).
 * 
 * 4.  **Best Practices:**
 *     *   Adhere to proper encapsulation principles (private fields, public methods).
 *     *   Use clear, descriptive names for classes, variables, and methods.
 *     *   Include appropriate comments and Javadoc documentation for clarity.
 *     *   Implement input validation as described in requirement 1 and 3.
 *     *   Structure the code logically with separate classes for `Package` and the system management.
 * 
 * **Expected Output:**
 * 
 * The program should continuously display a menu and prompt for user input. Based on the input, it should perform the requested action, printing results or errors to the appropriate stream (`System.out` or `System.err`). When displaying lists or the queue, number the items for readability. Exit gracefully when the user selects the exit option, confirming the exit and closing resources.
 * 
 * **Example Interaction Flow (Illustrative):**
 * 
 * ```
 * --- Package Processing System Menu ---
 * 1. Add New Package
 * 2. Process Next Package
 * 3. Find Package by ID
 * 4. Display Processing Queue
 * 5. Display Processed Packages
 * 0. Exit
 * ------------------------------------
 * Enter your choice: 1
 * --- Add New Package ---
 * Enter Package ID: ABC123
 * Enter Destination: London
 * Enter Weight (kg): 10.5
 * Package added to processing queue: Package [ID=ABC123, Dest=London, Weight=10.5kg, Status=Waiting]
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: 4
 * --- Packages in Processing Queue (1) ---
 * 1. Package [ID=ABC123, Dest=London, Weight=10.5kg, Status=Waiting]
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: 2
 * --- Processing Next Package ---
 * Successfully processed package: Package [ID=ABC123, Dest=London, Weight=10.5kg, Status=Processed]
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: 4
 * --- Packages in Processing Queue (0) ---
 * Queue is empty.
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: 5
 * --- Processed Packages (1) ---
 * 1. Package [ID=ABC123, Dest=London, Weight=10.5kg, Status=Processed]
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: 3
 * --- Find Package by ID ---
 * Enter Package ID to search: ABC123
 * Found (Processed): Package [ID=ABC123, Dest=London, Weight=10.5kg, Status=Processed]
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: 3
 * --- Find Package by ID ---
 * Enter Package ID to search: XYZ789
 * Package with ID 'XYZ789' not found.
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: invalid_input
 * Error: Invalid input. Please enter a number.
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: 1
 * --- Add New Package ---
 * Enter Package ID:
 * Error adding package: Package ID cannot be empty.
 * 
 * --- Package Processing System Menu ---
 * ...
 * Enter your choice: 0
 * Exiting Package Processing System. Goodbye!
 * Scanner closed.
 * ```
 * 
 * This task requires integrating multiple core Java concepts and data structures while implementing robust error handling and adhering to object-oriented design principles.
 *
 * EXPLANATION:
 * This solution implements the `Package Processing Center Simulation` task by leveraging the required Java components and adhering to best practices.
 * 
 * 1.  **`Package` Class:**
 *     *   This class serves as a simple Plain Old Java Object (POJO) representing a package.
 *     *   It uses `private` fields (`id`, `destination`, `weight`, `status`) to enforce encapsulation.
 *     *   The constructor performs basic input validation (`id`, `destination` not empty, `weight` positive) and throws `IllegalArgumentException` if validation fails, demonstrating defensive programming.
 *     *   Public getter methods provide controlled access to the package's state.
 *     *   A `setStatus` method allows controlled modification of the status.
 *     *   `toString()` is overridden for convenient printing of package details.
 * 
 * 2.  **`PackageProcessingSystem` Class:**
 *     *   This is the main class managing the system's state and operations.
 *     *   It declares `processingQueue` using the `Queue` interface and instantiates it as a `LinkedList`. `Queue` is appropriate here because packages are processed in the order they arrive (FIFO). `LinkedList` is a common `Queue` implementation.
 *     *   It declares `processedPackages` using the `List` interface and instantiates it as an `ArrayList`. `List` and `ArrayList` are suitable for storing processed items where order matters (implicitly by adding order) and random access/iteration is needed.
 *     *   A `Scanner` is used for all console input.
 *     *   Methods like `addPackage`, `processNextPackage`, `findPackage`, `displayProcessingQueue`, and `displayProcessedPackages` encapsulate the core logic, interacting with the data structures and the user.
 * 
 * 3.  **User Interface and `switch`:**
 *     *   The `run()` method contains the main application loop (`while (choice != 0)`).
 *     *   Inside the loop, a menu is printed, and user input is read using the `Scanner`.
 *     *   A `switch` statement is used to direct the program flow based on the integer `choice`, calling the appropriate method for each menu option. The `default` case handles invalid integer inputs.
 * 
 * 4.  **Input/Output and `System.err` / `System.out`:**
 *     *   `System.out.println()` is used for standard output, including the menu, prompts, successful operation confirmations, and displaying the contents of the queue and list.
 *     *   `System.err.println()` is specifically used for printing error messages, making them distinct from normal output. This is used for invalid input errors (`InputMismatchException`), package validation errors (`IllegalArgumentException`), and unexpected runtime errors.
 * 
 * 5.  **Exception Handling with `try-catch`:**
 *     *   Specific `try-catch` blocks are used within methods where predictable exceptions might occur:
 *         *   In `addPackage`, `try-catch` handles `InputMismatchException` (for non-numeric weight) and `IllegalArgumentException` (from the `Package` constructor validation).
 *         *   In `processNextPackage`, `try-catch` handles `NoSuchElementException`, which is thrown by `processingQueue.remove()` if the queue is empty. This is a graceful way to handle this specific condition.
 *         *   In `run`, an inner `try-catch` handles `InputMismatchException` specifically for the menu choice input, preventing the program from crashing or entering an infinite loop on invalid non-integer input.
 *     *   A broader `try-catch (Exception e)` block wraps the main `while` loop in `run()`. This is a class-wide (or rather, method-scope covering the main logic loop) exception handler that catches any *other* unexpected runtime exceptions that might bubble up, printing a generic error message and the stack trace to `System.err` for debugging.
 *     *   A `finally` block in `run()` ensures that the `Scanner` resource is closed, preventing resource leaks, regardless of whether the `try` block completes normally or an exception is caught.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation is demonstrated in the `Package` class and by making the data structure fields (`processingQueue`, `processedPackages`, `scanner`) private in `PackageProcessingSystem`.
 *     *   Method and variable names are descriptive (e.g., `addPackage`, `processingQueue`, `packageToProcess`).
 *     *   Comments and Javadoc are included to explain the purpose of classes, methods, and key logic sections.
 *     *   Input validation is performed both in the `Package` constructor and when reading user input in methods like `addPackage` and `findPackage`.
 *     *   The code is structured into logical classes, separating the data representation (`Package`) from the system logic (`PackageProcessingSystem`).
 * 
 * This solution effectively demonstrates the required components and best practices in the context of a practical simulation, providing a challenging but solvable task for students to showcase their understanding of core and advanced Java concepts.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Represents a package with ID, destination, weight, and status.
 * Includes validation and encapsulation.
 */
class Package {
    private String id;
    private String destination;
    private double weight;
    private String status; // e.g., "Waiting", "Processed"

    /**
     * Constructs a new Package object.
     *
     * @param id The unique package identifier.
     * @param destination The package destination.
     * @param weight The package weight in kg.
     * @throws IllegalArgumentException if id, destination are empty/null or weight is non-positive.
     */
    public Package(String id, String destination, double weight) {
        // Input validation
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Package ID cannot be empty.");
        }
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be empty.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }

        this.id = id.trim();
        this.destination = destination.trim();
        this.weight = weight;
        this.status = "Waiting"; // Initial status
    }

    // --- Getters ---
    public String getId() {
        return id;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    // --- Setter for status ---
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Provides a string representation of the Package object.
     * @return Formatted string of package details.
     */
    @Override
    public String toString() {
        return "Package [ID=" + id + ", Dest=" + destination + ", Weight=" + weight + "kg, Status=" + status + "]";
    }
}

/**
 * Manages the package processing system, including queue and processed list.
 * Handles user interaction and error handling.
 */
public class PackageProcessingSystem {

    // Use Queue interface, implemented by LinkedList for FIFO
    private Queue<Package> processingQueue;
    // Use List interface, implemented by ArrayList for dynamic processed storage
    private List<Package> processedPackages;
    private Scanner scanner;

    /**
     * Constructs a new PackageProcessingSystem.
     * Initializes the queue, list, and scanner.
     */
    public PackageProcessingSystem() {
        this.processingQueue = new LinkedList<>();
        this.processedPackages = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts user for package details and adds a new package to the processing queue.
     * Handles input errors and package validation errors.
     */
    public void addPackage() {
        System.out.println("\n--- Add New Package ---");
        try {
            System.out.print("Enter Package ID: ");
            String id = scanner.nextLine();
            System.out.print("Enter Destination: ");
            String destination = scanner.nextLine();
            System.out.print("Enter Weight (kg): ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character left by nextDouble()

            Package newPackage = new Package(id, destination, weight);
            processingQueue.offer(newPackage); // Use offer as it's generally preferred for queues
            System.out.println("Package added to processing queue: " + newPackage);

        } catch (InputMismatchException e) {
            // Handles non-numeric input for weight
            System.err.println("Error: Invalid input for weight. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input line to prevent infinite loop
        } catch (IllegalArgumentException e) {
            // Handles validation errors from Package constructor
            System.err.println("Error adding package: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected errors during the add process
             System.err.println("An unexpected error occurred while adding package: " + e.getMessage());
        }
    }

    /**
     * Processes the next package from the queue (FIFO).
     * Moves the processed package to the processed list.
     * Handles the case of an empty queue.
     */
    public void processNextPackage() {
        System.out.println("\n--- Processing Next Package ---");
        try {
            // Use remove() which throws NoSuchElementException if queue is empty
            Package packageToProcess = processingQueue.remove();
            packageToProcess.setStatus("Processed");
            processedPackages.add(packageToProcess);
            System.out.println("Successfully processed package: " + packageToProcess);
        } catch (NoSuchElementException e) {
            // Inform the user if the queue is empty, not a critical error
            System.out.println("No packages in the processing queue to process.");
        } catch (Exception e) {
            // Catch any other unexpected errors during the processing step
             System.err.println("An unexpected error occurred during package processing: " + e.getMessage());
        }
    }

    /**
     * Finds a package by its ID in either the processing queue or the processed list.
     * Reports the finding and package details.
     */
    public void findPackage() {
        System.out.println("\n--- Find Package by ID ---");
        System.out.print("Enter Package ID to search: ");
        String searchId = scanner.nextLine();

        if (searchId == null || searchId.trim().isEmpty()) {
            System.err.println("Error: Package ID cannot be empty for search.");
            return;
        }
        searchId = searchId.trim();

        // Search in processing queue
        for (Package pkg : processingQueue) {
            if (pkg.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Found in queue: " + pkg);
                return; // Found, exit method
            }
        }

        // Search in processed list
        for (Package pkg : processedPackages) {
            if (pkg.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Found (Processed): " + pkg);
                return; // Found, exit method
            }
        }

        // If loop finishes without finding
        System.out.println("Package with ID '" + searchId + "' not found.");
    }

    /**
     * Displays all packages currently in the processing queue.
     */
    public void displayProcessingQueue() {
        System.out.println("\n--- Packages in Processing Queue (" + processingQueue.size() + ") ---");
        if (processingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            int index = 1;
            for (Package pkg : processingQueue) {
                System.out.println(index++ + ". " + pkg);
            }
        }
    }

    /**
     * Displays all packages that have been processed.
     */
    public void displayProcessedPackages() {
        System.out.println("\n--- Processed Packages (" + processedPackages.size() + ") ---");
        if (processedPackages.isEmpty()) {
            System.out.println("No packages have been processed yet.");
        } else {
            // Iterate through the list
            for (int i = 0; i < processedPackages.size(); i++) {
                System.out.println((i + 1) + ". " + processedPackages.get(i));
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("\n--- Package Processing System Menu ---");
        System.out.println("1. Add New Package");
        System.out.println("2. Process Next Package");
        System.out.println("3. Find Package by ID");
        System.out.println("4. Display Processing Queue");
        System.out.println("5. Display Processed Packages");
        System.out.println("0. Exit");
        System.out.println("------------------------------------");
    }

    /**
     * Runs the main application loop, handling user input and menu navigation.
     * Includes a general try-catch for unexpected errors and ensures scanner closure.
     */
    public void run() {
        int choice = -1;

        // Main try-catch block to handle unexpected errors during the application lifecycle
        try {
            while (choice != 0) {
                printMenu();
                System.out.print("Enter your choice: ");

                try {
                    // Inner try-catch for input-specific issues within the loop
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline left by nextInt()

                    // Use a switch statement for menu navigation
                    switch (choice) {
                        case 1:
                            addPackage();
                            break;
                        case 2:
                            processNextPackage();
                            break;
                        case 3:
                            findPackage();
                            break;
                        case 4:
                            displayProcessingQueue();
                            break;
                        case 5:
                            displayProcessedPackages();
                            break;
                        case 0:
                            System.out.println("Exiting Package Processing System. Goodbye!");
                            break;
                        default:
                            // Handle choices outside the defined range
                            System.err.println("Invalid choice. Please enter a number between 0 and 5.");
                    }
                } catch (InputMismatchException e) {
                    // Handles cases where user input for choice is not an integer
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to ensure loop continues and menu is shown again
                }
                // Add a blank line for better readability between menu iterations
                System.out.println();
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions that might occur outside the specific method catches
            System.err.println("An unrecoverable error occurred during system execution: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream for debugging
        } finally {
            // Ensure the scanner resource is closed regardless of how the try block exits
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed.");
            }
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        PackageProcessingSystem system = new PackageProcessingSystem();
        system.run();
    }
}
