/*
 * Exam Question #1004
 * Generated on: 2025-05-12 17:11:27
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Package Delivery Hub Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified management system for a small package delivery hub. The hub receives packages, processes them in the order they arrive, and then makes them ready for delivery. The system needs to track packages and allow basic operations.
 * 
 * **Requirements:**
 * 
 * Develop a Java console application that simulates this package flow. Your solution must adhere to the following:
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to hold incoming packages that are waiting to be processed (First-In, First-Out).
 *     *   Use a `java.util.List` (specifically instantiated as a `java.util.ArrayList`) to store packages that have been processed and are ready for delivery.
 * 
 * 2.  **Package Representation:**
 *     *   Create a `Package` class with private fields for `trackingNumber` (String), `destinationAddress` (String), `weight` (double), and `status` (String, e.g., "Pending", "Ready for Delivery").
 *     *   Include a constructor, public getter methods for all fields, and a public setter method for the `status`.
 *     *   Implement a meaningful `toString()` method for easy printing.
 *     *   Include basic validation in the constructor (e.g., tracking number/address not empty, weight positive) throwing `IllegalArgumentException`.
 * 
 * 3.  **Delivery Hub Logic:**
 *     *   Create a main class (e.g., `DeliveryHub`) that contains the `main` method and manages the collections.
 *     *   Implement the following functionalities via a menu-driven interface using `java.util.Scanner` for user input:
 *         *   **Add New Incoming Package:** Prompt the user for package details (tracking number, destination, weight). Create a `Package` object and add it to the pending processing queue.
 *         *   **Process Next Pending Package:** Take the next package from the pending queue, change its status to "Ready for Delivery", and add it to the ready-for-delivery list. Handle the case where the pending queue is empty.
 *         *   **View Pending Packages:** Display all packages currently in the pending processing queue without removing them.
 *         *   **View Ready for Delivery Packages:** Display all packages currently in the ready-for-delivery list.
 *         *   **Search Package by Tracking Number:** Prompt the user for a tracking number and search for the package in *both* the pending queue and the ready list. Display the package details if found, otherwise indicate it was not found.
 *         *   **Exit:** Terminate the program.
 * 
 * 4.  **Flow Control:**
 *     *   Use a `switch` statement in the main loop to handle the user's menu selection.
 * 
 * 5.  **Input/Output:**
 *     *   Use `System.out` for displaying the menu, prompts, confirmations, and package lists/details.
 *     *   Use `System.err` for displaying all error messages (e.g., invalid input, operation on empty queue, package not found during search if treated as an error condition, or exceptions).
 * 
 * 6.  **Exception Handling:**
 *     *   Implement robust error handling using `try-catch` blocks.
 *     *   Catch `NumberFormatException` for weight input.
 *     *   Catch `IllegalArgumentException` from the `Package` constructor.
 *     *   Handle potential exceptions when operating on empty collections (though checking size first is also good practice).
 *     *   Include a general `try-catch` block around the main application loop in the `main` method for class-wide exception handling.
 *     *   Ensure the `Scanner` resource is properly closed using a `finally` block or try-with-resources (though `finally` is explicitly requested for the exam context).
 * 
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments to explain complex parts.
 *     *   Follow proper encapsulation principles.
 *     *   Validate user input where necessary (e.g., non-empty strings, positive weight).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept user input, perform the requested operations, and display results or error messages clearly using the specified output streams (`System.out` or `System.err`).
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * --- Delivery Hub Menu ---
 * 1. Add New Incoming Package
 * ...
 * 6. Exit
 * Enter your choice: 1
 * 
 * --- Add New Package ---
 * Enter Tracking Number: TN123
 * Enter Destination Address: 123 Main St
 * Enter Weight (in kg): 5.5
 * Package added to pending queue: TN123
 * -----------------------
 * 
 * --- Delivery Hub Menu ---
 * ...
 * Enter your choice: 2
 * 
 * --- Process Next Package ---
 * Processed package: TN123. Moved to Ready for Delivery.
 * --------------------------
 * 
 * --- Delivery Hub Menu ---
 * ...
 * Enter your choice: 3
 * 
 * --- Pending Packages ---
 * No packages currently pending processing.
 * ------------------------
 * 
 * --- Delivery Hub Menu ---
 * ...
 * Enter your choice: 4
 * 
 * --- Ready for Delivery Packages ---
 * Total ready: 1
 * 1. Package [Tracking=TN123, Dest=123 Main St, Weight=5.5 kg, Status=Ready for Delivery]
 * ---------------------------------
 * 
 * --- Delivery Hub Menu ---
 * ...
 * Enter your choice: 5
 * 
 * --- Search Package ---
 * Enter Tracking Number to search: TN123
 * Package found: Package [Tracking=TN123, Dest=123 Main St, Weight=5.5 kg, Status=Ready for Delivery]
 * ----------------------
 * 
 * --- Delivery Hub Menu ---
 * ...
 * Enter your choice: 7  // Invalid choice
 * Invalid choice. Please enter a number between 1 and 6. // Output to System.err
 * 
 * --- Delivery Hub Menu ---
 * ...
 * Enter your choice: 1
 * 
 * --- Add New Package ---
 * Enter Tracking Number: TN456
 * Enter Destination Address: 456 Oak Ave
 * Enter Weight (in kg): abc // Invalid input
 * Error: Invalid weight format. Please enter a number. // Output to System.err
 * -----------------------
 * ...
 * ```
 *
 * EXPLANATION:
 * The provided solution implements a `Package Delivery Hub Management System` meeting all specified requirements.
 * 
 * **Key Concepts Demonstrated:**
 * 
 * 1.  **`java.util.Queue`:** The `pendingProcessingQueue` is declared as a `Queue<Package>` and instantiated using `LinkedList`. This correctly models the FIFO (First-In, First-Out) nature of packages waiting to be processed. `offer()` is used for adding packages, and `poll()` is used for retrieving and removing the next package to be processed.
 * 2.  **`java.util.List` and `java.util.ArrayList`:** The `readyForDeliveryList` is declared using the `List` interface (`List<Package>`) and instantiated as an `ArrayList`. This demonstrates programming to an interface and using a common, dynamic array implementation for storing processed items where order is maintained and elements can be easily accessed by index or iterated over.
 * 3.  **`java.util.Scanner`:** Used in the `main` method and passed to helper methods (`addPackage`, `searchPackage`) to read user input from the console for menu choices and package details.
 * 4.  **`switch` statement:** The `switch` statement in the `main` loop is used for flow control, directing the program to execute the correct method based on the user's menu selection.
 * 5.  **`System.err`:** Used specifically for outputting error messages, such as invalid input formats, validation failures, operations on empty collections (when indicating a failure), and unexpected exceptions. This separates error output from normal program output (`System.out`).
 * 6.  **`System.out`:** Used for all standard program output, including displaying the menu, prompts for input, confirmations of successful operations, and listing package details.
 * 7.  **Class-wide Exception Handling (`try-catch`)**: A large `try-catch(Exception e)` block is placed around the main `while` loop in the `main` method. This serves as a top-level handler to catch any unexpected exceptions that might occur during the execution of the program's core logic, preventing the program from crashing abruptly and providing a fallback error message.
 * 8.  **Specific Exception Handling (`try-catch`)**: More specific `try-catch` blocks are used within methods like `addPackage` (catching `NumberFormatException` for weight and `IllegalArgumentException` from the `Package` constructor) and `processNextPackage` (catching potential errors during collection operations, though the `isEmpty` check is primary). This allows for handling known potential issues gracefully and providing user-friendly error messages.
 * 9.  **`finally` block**: A `finally` block is used in the `main` method to ensure the `Scanner` resource is closed regardless of whether an exception occurred or the loop finished normally.
 * 10. **`Package` Class:** Demonstrates object-oriented principles with private fields, public getters/setters (for status), a constructor for initialization, and a `toString()` method for representation. Input validation is performed within the constructor, throwing `IllegalArgumentException` for invalid data. `equals` and `hashCode` are overridden based on the tracking number for reliable searching.
 * 11. **Best Practices:**
 *     *   **Encapsulation:** Fields in `Package` and the collections in `DeliveryHub` are private.
 *     *   **Meaningful Names:** Variable and method names clearly indicate their purpose (e.g., `pendingProcessingQueue`, `processNextPackage`, `trackingNumber`).
 *     *   **Input Validation:** Checks are performed for empty strings and positive weight.
 *     *   **Error Handling:** Multiple layers of `try-catch` are used, directing errors to `System.err`.
 *     *   **Clean Structure:** The logic is separated into a `Package` class and a `DeliveryHub` class with distinct methods for each operation.
 * 
 * The solution effectively integrates these components to create a functional, albeit simplified, simulation of a real-world package management process, demonstrating a solid understanding of core and advanced Java concepts required for the exam.
 */

import java.util.LinkedList; // LinkedList implements Queue and List
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;

// Represents a package in the delivery hub
class Package {
    private String trackingNumber;
    private String destinationAddress;
    private double weight;
    private String status; // e.g., "Pending", "Ready for Delivery"

    // Constructor with input validation
    public Package(String trackingNumber, String destinationAddress, double weight) {
        if (trackingNumber == null || trackingNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Tracking number cannot be empty.");
        }
        if (destinationAddress == null || destinationAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination address cannot be empty.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        this.trackingNumber = trackingNumber.trim();
        this.destinationAddress = destinationAddress.trim();
        this.weight = weight;
        this.status = "Pending"; // Initial status
    }

    // Getters for package properties
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public double getWeight() {
        return weight;
    }

    public String getStatus() {
        return status;
    }

    // Setter to update package status
    public void setStatus(String status) {
        this.status = status;
    }

    // String representation of the package
    @Override
    public String toString() {
        return "Package [Tracking=" + trackingNumber + ", Dest=" + destinationAddress + ", Weight=" + weight + " kg, Status=" + status + "]";
    }

    // equals and hashCode based on tracking number for easy searching/comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return Objects.equals(trackingNumber.toLowerCase(), aPackage.trackingNumber.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(trackingNumber.toLowerCase());
    }
}

// Manages the package flow in the delivery hub
public class DeliveryHub {

    // Queue for packages waiting to be processed (FIFO)
    private Queue<Package> pendingProcessingQueue;
    // List for packages ready for delivery
    private List<Package> readyForDeliveryList;

    // Constructor to initialize collections
    public DeliveryHub() {
        // LinkedList is a common implementation for Queue
        pendingProcessingQueue = new LinkedList<>();
        // ArrayList is a common implementation for List
        readyForDeliveryList = new ArrayList<>();
    }

    // Method to add a new package received at the hub
    public void addPackage(Scanner scanner) {
        System.out.println("\n--- Add New Package ---");
        try {
            System.out.print("Enter Tracking Number: ");
            String trackingNumber = scanner.nextLine();

            System.out.print("Enter Destination Address: ");
            String destinationAddress = scanner.nextLine();

            System.out.print("Enter Weight (in kg): ");
            double weight = Double.parseDouble(scanner.nextLine()); // Potential NumberFormatException

            // Create Package object; constructor handles basic validation (empty strings, positive weight)
            Package newPackage = new Package(trackingNumber, destinationAddress, weight);

            // Check if package with same tracking number already exists (optional but good practice)
            if (findPackageByTrackingNumber(trackingNumber) != null) {
                 System.err.println("Error: Package with tracking number '" + trackingNumber + "' already exists.");
                 System.out.println("-----------------------");
                 return; // Exit method if package exists
            }


            pendingProcessingQueue.offer(newPackage); // Add to the end of the queue
            System.out.println("Package added to pending queue: " + newPackage.getTrackingNumber());

        } catch (NumberFormatException e) {
            // Catch specific exception for invalid number format input
            System.err.println("Error: Invalid weight format. Please enter a number.");
        } catch (IllegalArgumentException e) {
            // Catch exceptions thrown by Package constructor for invalid data
            System.err.println("Error adding package: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions during the process
            System.err.println("An unexpected error occurred while adding package: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream for debugging
        }
        System.out.println("-----------------------");
    }

    // Method to process the next package from the pending queue
    public void processNextPackage() {
        System.out.println("\n--- Process Next Package ---");
        try {
            // poll() retrieves and removes the head of the queue, returns null if queue is empty
            Package packageToProcess = pendingProcessingQueue.poll();

            if (packageToProcess == null) {
                System.out.println("No packages in the pending queue to process.");
                // Using System.err for indicating an operational failure condition
                System.err.println("Operation failed: Pending queue is empty.");
            } else {
                packageToProcess.setStatus("Ready for Delivery"); // Update status
                readyForDeliveryList.add(packageToProcess); // Add to the ready list
                System.out.println("Processed package: " + packageToProcess.getTrackingNumber() + ". Moved to Ready for Delivery.");
            }
        } catch (Exception e) {
             // Catch any unexpected error during processing
            System.err.println("An unexpected error occurred while processing package: " + e.getMessage());
            e.printStackTrace(System.err);
        }
        System.out.println("--------------------------");
    }

    // Method to view all packages currently in the pending queue
    public void viewPendingPackages() {
        System.out.println("\n--- Pending Packages ---");
        if (pendingProcessingQueue.isEmpty()) {
            System.out.println("No packages currently pending processing.");
        } else {
            System.out.println("Total pending: " + pendingProcessingQueue.size());
            int index = 1;
            // Iterate through the queue elements without removing them
            for (Package pkg : pendingProcessingQueue) {
                System.out.println(index++ + ". " + pkg);
            }
        }
        System.out.println("------------------------");
    }

    // Method to view all packages currently ready for delivery
    public void viewReadyPackages() {
        System.out.println("\n--- Ready for Delivery Packages ---");
        if (readyForDeliveryList.isEmpty()) {
            System.out.println("No packages currently ready for delivery.");
        } else {
            System.out.println("Total ready: " + readyForDeliveryList.size());
            // Iterate through the list elements
            for (int i = 0; i < readyForDeliveryList.size(); i++) {
                System.out.println((i + 1) + ". " + readyForDeliveryList.get(i));
            }
        }
        System.out.println("---------------------------------");
    }

    // Helper method to find a package by tracking number in either collection
    private Package findPackageByTrackingNumber(String trackingNumberToFind) {
        if (trackingNumberToFind == null || trackingNumberToFind.trim().isEmpty()) {
            return null; // Cannot search for empty tracking number
        }
        String searchKey = trackingNumberToFind.trim().toLowerCase();

        // Search in pending queue
        for (Package pkg : pendingProcessingQueue) {
            if (pkg.getTrackingNumber().toLowerCase().equals(searchKey)) {
                return pkg;
            }
        }

        // If not found in pending, search in ready list
        for (Package pkg : readyForDeliveryList) {
             if (pkg.getTrackingNumber().toLowerCase().equals(searchKey)) {
                return pkg;
            }
        }
        return null; // Package not found
    }


    // Method to search for a package based on user input
    public void searchPackage(Scanner scanner) {
        System.out.println("\n--- Search Package ---");
        System.out.print("Enter Tracking Number to search: ");
        String trackingNumberToFind = scanner.nextLine();

        if (trackingNumberToFind == null || trackingNumberToFind.trim().isEmpty()) {
            System.err.println("Error: Tracking number cannot be empty for search.");
            System.out.println("----------------------");
            return;
        }

        Package foundPackage = findPackageByTrackingNumber(trackingNumberToFind);

        if (foundPackage != null) {
            System.out.println("Package found: " + foundPackage);
        } else {
            System.out.println("Package with tracking number '" + trackingNumberToFind.trim() + "' not found.");
        }
        System.out.println("----------------------");
    }


    // Method to display the main menu options
    private void displayMenu() {
        System.out.println("\n--- Delivery Hub Menu ---");
        System.out.println("1. Add New Incoming Package");
        System.out.println("2. Process Next Pending Package");
        System.out.println("3. View Pending Packages");
        System.out.println("4. View Ready for Delivery Packages");
        System.out.println("5. Search Package by Tracking Number");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Main method to run the application
    public static void main(String[] args) {
        DeliveryHub hub = new DeliveryHub();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling block around the main application loop
        try {
            while (running) {
                hub.displayMenu();
                int choice = -1; // Default invalid choice

                try {
                    // Read user choice, handles potential non-integer input
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    // Specific catch for invalid number input for menu choice
                    System.err.println("Invalid input. Please enter a number.");
                    continue; // Skip the rest of the loop body and show menu again
                }

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1:
                        hub.addPackage(scanner);
                        break;
                    case 2:
                        hub.processNextPackage();
                        break;
                    case 3:
                        hub.viewPendingPackages();
                        break;
                    case 4:
                        hub.viewReadyPackages();
                        break;
                    case 5:
                        hub.searchPackage(scanner);
                        break;
                    case 6:
                        System.out.println("Exiting Delivery Hub System. Goodbye!");
                        running = false; // Set flag to exit loop
                        break;
                    default:
                        // Handle choices outside the valid range
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exception that might occur during the application lifecycle
            System.err.println("\nAn unrecoverable error occurred. System shutting down.");
            e.printStackTrace(System.err); // Print stack trace to error stream for debugging
        } finally {
            // Ensure resources like Scanner are closed properly
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed.");
            }
        }
    }
}
