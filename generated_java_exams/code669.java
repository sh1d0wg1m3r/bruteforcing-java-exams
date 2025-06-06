/*
 * Exam Question #669
 * Generated on: 2025-05-12 16:22:52
 * Generated by: Account 4
 * 
 * QUESTION:
 * **Java Programming Exam Task: Package Sorting and Delivery Simulation**
 * 
 * You are tasked with developing a simple console-based application to simulate a package sorting and preparation facility. The system receives packages, sorts them (in this simplified model, sorting just means processing the next package), and places them into a queue for delivery. The system should allow users to add packages, process the next package, and view the status of packages in different stages.
 * 
 * **Requirements:**
 * 
 * 1.  **Package Representation:** Create a `Package` class with private fields for `packageId` (String), `destination` (String), and `weightKg` (double). Include a constructor and public getter methods for these fields. Override the `toString()` method for easy printing of package details.
 * 2.  **Sorting Station:** Create a `SortingStation` class that manages the package flow.
 *     *   It must have a private `Queue<Package>` to hold incoming packages (`incomingPackages`).
 *     *   It must have a private `Queue<Package>` to hold packages ready for delivery (`deliveryQueue`).
 *     *   It must have a private `List<Package>` (using `ArrayList`) to store all packages that have been processed/sorted (`processedPackages`).
 *     *   Implement public methods:
 *         *   `addPackage(Package pkg)`: Adds a package to the `incomingPackages` queue.
 *         *   `sortNextPackage()`: Takes the next package from `incomingPackages`, adds it to the `processedPackages` list, and then adds it to the `deliveryQueue`. This method should handle the case where `incomingPackages` is empty.
 *         *   `getIncomingPackages()`: Returns the `incomingPackages` queue (or a view/copy).
 *         *   `getDeliveryQueue()`: Returns the `deliveryQueue` queue (or a view/copy).
 *         *   `getProcessedPackages()`: Returns the `processedPackages` list (or a view/copy).
 * 3.  **Main Application (`PackageSortingApp`):**
 *     *   Use `java.util.Scanner` to get user input from the console.
 *     *   Implement a main loop that presents a menu of options to the user:
 *         *   1. Add New Package
 *         *   2. Sort Next Incoming Package
 *         *   3. View Incoming Packages
 *         *   4. View Delivery Queue
 *         *   5. View All Processed Packages
 *         *   6. Exit
 *     *   Use a `switch` statement to handle the user's choice.
 *     *   Implement input validation:
 *         *   When adding a package, ensure `weightKg` is a positive value. If not, print an error message using `System.err` and do not add the package.
 *         *   Handle non-numeric input gracefully using `try-catch` blocks when reading numeric values. Print an error message using `System.err`.
 *     *   Use `System.out` for menu display, prompts, and displaying package information.
 *     *   Use `System.err` for all error messages (input validation failures, attempting to sort when the incoming queue is empty, general unexpected errors).
 *     *   Implement comprehensive exception handling using `try-catch` blocks. A class-wide `try-catch` around the main application loop or significant sections of it is required to catch potential unexpected runtime exceptions and print error details to `System.err`. Ensure the `Scanner` is closed properly.
 *     *   Ensure proper encapsulation (private fields, public methods) and use meaningful names for variables, methods, and classes.
 *     *   Include appropriate comments and basic documentation.
 * 
 * **Required Java Components (MUST use ALL):**
 * 
 * *   `java.util.Queue`
 * *   `java.util.ArrayList`
 * *   `java.util.List` (used as the type for `processedPackages`)
 * *   `java.util.Scanner`
 * *   `switch` statement
 * *   `System.err`
 * *   `System.out`
 * *   Class-wide exception handling with `try-catch` blocks
 * 
 * **Expected Output:**
 * 
 * The application should run interactively, displaying a menu, prompting for input based on the user's choice, and providing feedback or displaying package information. Error messages should go to `System.err`.
 * 
 * Example Interaction Flow:
 * 
 * ```
 * Package Sorting Facility Menu:
 * 1. Add New Package
 * 2. Sort Next Incoming Package
 * 3. View Incoming Packages
 * 4. View Delivery Queue
 * 5. View All Processed Packages
 * 6. Exit
 * Enter your choice: 1
 * Enter Package ID: P001
 * Enter Destination: City A
 * Enter Weight (kg): 5.2
 * Package P001 added to incoming queue.
 * 
 * Package Sorting Facility Menu:
 * ...
 * Enter your choice: 1
 * Enter Package ID: P002
 * Enter Destination: City B
 * Enter Weight (kg): -1.0
 * Error: Weight must be positive. Package not added.
 * 
 * Package Sorting Facility Menu:
 * ...
 * Enter your choice: 2
 * Sorting next package...
 * Package P001 sorted and moved to delivery queue.
 * 
 * Package Sorting Facility Menu:
 * ...
 * Enter your choice: 3
 * Incoming Packages (Queue):
 * []
 * 
 * Package Sorting Facility Menu:
 * ...
 * Enter your choice: 4
 * Delivery Queue (Queue):
 * [Package{id='P001', destination='City A', weight=5.2}]
 * 
 * Package Sorting Facility Menu:
 * ...
 * Enter your choice: 5
 * All Processed Packages (List):
 * [Package{id='P001', destination='City A', weight=5.2}]
 * 
 * Package Sorting Facility Menu:
 * ...
 * Enter your choice: 2
 * Sorting next package...
 * Error: No packages in the incoming queue to sort.
 * 
 * Package Sorting Facility Menu:
 * ...
 * Enter your choice: invalid_input
 * Error: Invalid input. Please enter a number.
 * 
 * Package Sorting Facility Menu:
 * ...
 * Enter your choice: 6
 * Exiting application.
 * ```
 * 
 * Your solution should be provided as complete, compilable Java code.
 *
 * EXPLANATION:
 * This solution implements the package sorting simulation according to the requirements, demonstrating the use of all specified Java components and best practices.
 * 
 * 1.  **`Package` Class:**
 *     *   Represents a package with private fields (`packageId`, `destination`, `weightKg`) ensuring encapsulation.
 *     *   The constructor performs basic input validation (non-empty strings, positive weight) and throws `IllegalArgumentException` for invalid data. This demonstrates using exceptions for invalid state creation.
 *     *   Public getters provide controlled access to the data.
 *     *   `toString()` is overridden for convenient printing of package details.
 * 
 * 2.  **`SortingStation` Class:**
 *     *   Manages the package workflow using three collections:
 *         *   `incomingPackages`: A `Queue<Package>` (implemented using `LinkedList`) for packages waiting to be sorted. `Queue` is suitable here because packages are processed in the order they arrive (FIFO - First-In, First-Out).
 *         *   `deliveryQueue`: Another `Queue<Package>` (implemented using `LinkedList`) for packages ready for delivery. Again, FIFO processing is implied.
 *         *   `processedPackages`: A `List<Package>` (implemented using `ArrayList`) to keep a record of all packages that have gone through the sorting step. `List` is suitable for storing an ordered collection of processed items, and `ArrayList` is a common, efficient implementation for general-purpose lists.
 *     *   `addPackage()` uses `offer()` to add to the `incomingPackages` queue.
 *     *   `sortNextPackage()` uses `poll()` to retrieve and remove the head of the `incomingPackages` queue. It checks if `poll()` returned `null` (meaning the queue was empty) and prints an error to `System.err` if so. If a package is retrieved, it's added to both `processedPackages` (the `List`) and `deliveryQueue` (the `Queue`).
 *     *   Getter methods provide access to the collection objects.
 * 
 * 3.  **`PackageSortingApp` Class:**
 *     *   Contains the `main` method, which is the entry point.
 *     *   A `Scanner` is used to read user input from `System.in`.
 *     *   The `runSimulation()` method contains the main application loop.
 *     *   **Class-wide Exception Handling:** The `try-catch(Exception e)` block in `main()` wraps the call to `runSimulation()`. This provides a top-level safety net to catch any unhandled runtime exceptions that might occur anywhere within the simulation logic and print them to `System.err`. The `finally` block ensures the `Scanner` is always closed, preventing resource leaks.
 *     *   `printMenu()` displays the options using `System.out`.
 *     *   `getUserChoice()` reads the user's integer input. It includes a `try-catch(InputMismatchException e)` specifically to handle cases where the user enters non-numeric input when an integer is expected. An error is printed to `System.err`, and the invalid input is consumed using `scanner.next()` to prevent an infinite loop.
 *     *   The `switch` statement in `runSimulation()` directs the program flow based on the valid user choice.
 *     *   `addNewPackage()` handles option 1. It prompts for package details.
 *         *   It uses `try-catch(InputMismatchException e)` for reading the double weight, printing errors to `System.err`.
 *         *   It uses `try-catch(IllegalArgumentException e)` around the `new Package(...)` constructor call. This catches the specific validation exceptions thrown by the `Package` constructor and prints the error message to `System.err`.
 *     *   `viewIncomingPackages()`, `viewDeliveryQueue()`, and `viewAllProcessedPackages()` retrieve the respective collections from the `SortingStation` and print their contents to `System.out`. They check if the collections are empty before printing.
 * 
 * **Key Concepts Demonstrated:**
 * 
 * *   **Collections Framework:** Practical use of `Queue` (FIFO behavior for processing order) and `List` (`ArrayList` for storing a collection of processed items).
 * *   **Encapsulation:** `Package` and `SortingStation` classes use private fields and public methods.
 * *   **Input Handling:** Using `Scanner` for interactive input.
 * *   **Control Flow:** Using `switch` for multi-way branching based on user input.
 * *   **Error Handling:**
 *     *   Specific `try-catch` blocks for handling `InputMismatchException` during numeric input.
 *     *   Catching custom `IllegalArgumentException` from the `Package` constructor for input validation.
 *     *   Checking for specific error conditions within methods (e.g., empty incoming queue in `sortNextPackage()`) and reporting errors via `System.err`.
 *     *   A broad `try-catch(Exception e)` wrapping the main execution flow (`runSimulation()`) demonstrates class-wide exception handling for unexpected errors, printing stack traces to `System.err`.
 * *   **Output Streams:** Correctly using `System.out` for normal program output and `System.err` for error messages.
 * *   **Object-Oriented Design:** Breaking the problem into logical classes (`Package`, `SortingStation`, `PackageSortingApp`).
 * 
 * This solution effectively integrates the required components into a functional simulation, showcasing understanding of fundamental Java concepts, collection types, error management, and basic application structure.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a package with ID, destination, and weight.
class Package {
    private String packageId;
    private String destination;
    private double weightKg;

    // Constructor
    public Package(String packageId, String destination, double weightKg) {
        if (packageId == null || packageId.trim().isEmpty() || destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Package ID and Destination cannot be null or empty.");
        }
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        this.packageId = packageId.trim();
        this.destination = destination.trim();
        this.weightKg = weightKg;
    }

    // Getters
    public String getPackageId() {
        return packageId;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeightKg() {
        return weightKg;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Package{id='" + packageId + "', destination='" + destination + "', weight=" + weightKg + "}";
    }
}

// Manages the flow of packages through incoming, processing, and delivery stages.
class SortingStation {
    private Queue<Package> incomingPackages;
    private Queue<Package> deliveryQueue;
    private List<Package> processedPackages; // Uses ArrayList

    // Constructor
    public SortingStation() {
        // Using LinkedList as a Queue implementation
        this.incomingPackages = new LinkedList<>();
        this.deliveryQueue = new LinkedList<>();
        // Using ArrayList as a List implementation
        this.processedPackages = new ArrayList<>();
    }

    /**
     * Adds a package to the incoming queue.
     * @param pkg The package to add.
     */
    public void addPackage(Package pkg) {
        if (pkg != null) {
            incomingPackages.offer(pkg); // offer is generally preferred over add for queues (returns boolean)
        } else {
            System.err.println("Error: Cannot add a null package.");
        }
    }

    /**
     * Processes the next package from the incoming queue.
     * Moves it to processedPackages list and deliveryQueue.
     * @return true if a package was sorted, false if incoming queue was empty.
     */
    public boolean sortNextPackage() {
        Package pkg = incomingPackages.poll(); // poll removes and returns the head, or null if empty
        if (pkg != null) {
            processedPackages.add(pkg);
            deliveryQueue.offer(pkg);
            System.out.println("Package " + pkg.getPackageId() + " sorted and moved to delivery queue.");
            return true;
        } else {
            System.err.println("Error: No packages in the incoming queue to sort.");
            return false;
        }
    }

    /**
     * Returns the incoming packages queue.
     * Note: Returning the direct reference allows external modification.
     * For a real system, returning a copy or unmodifiable view is better practice.
     * For this exam, returning the reference is acceptable to demonstrate usage.
     */
    public Queue<Package> getIncomingPackages() {
        return incomingPackages;
    }

    /**
     * Returns the delivery queue.
     */
    public Queue<Package> getDeliveryQueue() {
        return deliveryQueue;
    }

    /**
     * Returns the list of all processed packages.
     */
    public List<Package> getProcessedPackages() {
        return processedPackages;
    }
}

// Main application class to run the package sorting simulation.
public class PackageSortingApp {

    private static SortingStation sortingStation = new SortingStation();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Class-wide exception handling for the main application loop
        try {
            runSimulation();
        } catch (Exception e) {
            System.err.println("An unexpected application error occurred:");
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure scanner is closed regardless of exceptions
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed. Exiting application.");
            }
        }
    }

    private static void runSimulation() {
        int choice;
        do {
            printMenu();
            choice = getUserChoice();

            // Use switch statement for flow control based on user choice
            switch (choice) {
                case 1:
                    addNewPackage();
                    break;
                case 2:
                    sortingStation.sortNextPackage();
                    break;
                case 3:
                    viewIncomingPackages();
                    break;
                case 4:
                    viewDeliveryQueue();
                    break;
                case 5:
                    viewAllProcessedPackages();
                    break;
                case 6:
                    System.out.println("Exiting application.");
                    break;
                default:
                    // Handled by getUserChoice validation, but included for completeness
                    System.err.println("Invalid choice. Please enter a number between 1 and 6.");
            }
            System.out.println(); // Add a newline for better readability between actions

        } while (choice != 6);
    }

    private static void printMenu() {
        System.out.println("--- Package Sorting Facility Menu ---");
        System.out.println("1. Add New Package");
        System.out.println("2. Sort Next Incoming Package");
        System.out.println("3. View Incoming Packages");
        System.out.println("4. View Delivery Queue");
        System.out.println("5. View All Processed Packages");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        // Exception handling for scanner input
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter a number.");
            scanner.next(); // Consume the invalid input to prevent infinite loop
            return -1; // Return a value that won't match a valid case
        }
    }

    private static void addNewPackage() {
        // Consume the newline left by nextInt()
        scanner.nextLine();

        System.out.print("Enter Package ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();

        double weight = -1; // Initialize with an invalid value
        System.out.print("Enter Weight (kg): ");
        // Exception handling for double input
        try {
            weight = scanner.nextDouble();
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input for weight. Please enter a number.");
            scanner.next(); // Consume the invalid input
            return; // Exit method if input is invalid
        } finally {
             // Consume the newline left by nextDouble() or scanner.next()
             scanner.nextLine();
        }


        // Input validation using try-catch with custom exception in Package constructor
        try {
            Package newPackage = new Package(id, destination, weight);
            sortingStation.addPackage(newPackage);
            System.out.println("Package " + newPackage.getPackageId() + " added to incoming queue.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void viewIncomingPackages() {
        Queue<Package> incoming = sortingStation.getIncomingPackages();
        System.out.println("--- Incoming Packages (Queue) ---");
        if (incoming.isEmpty()) {
            System.out.println("No packages in the incoming queue.");
        } else {
            // Iterate without removing elements
            System.out.println(incoming); // LinkedList's toString is suitable
        }
    }

    private static void viewDeliveryQueue() {
        Queue<Package> delivery = sortingStation.getDeliveryQueue();
        System.out.println("--- Delivery Queue (Queue) ---");
         if (delivery.isEmpty()) {
            System.out.println("No packages in the delivery queue.");
        } else {
             System.out.println(delivery); // LinkedList's toString is suitable
        }
    }

    private static void viewAllProcessedPackages() {
        List<Package> processed = sortingStation.getProcessedPackages();
        System.out.println("--- All Processed Packages (List) ---");
         if (processed.isEmpty()) {
            System.out.println("No packages have been processed yet.");
        } else {
            // ArrayList's toString is suitable
            System.out.println(processed);
        }
    }
}
