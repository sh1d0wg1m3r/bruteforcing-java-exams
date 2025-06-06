/*
 * Exam Question #519
 * Generated on: 2025-05-11 23:23:26
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Package Delivery Service Simulation
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified simulation of a package delivery service's processing workflow. Packages arrive and are placed into a queue awaiting processing. Once processed, they are moved to a list of delivered packages. The system needs to handle adding packages, processing the next available package, and displaying the status of packages in the queue and those already delivered.
 * 
 * **Task:**
 * 
 * Implement a Java program that simulates this package delivery system. Your solution must adhere to the following requirements and best practices.
 * 
 * **Requirements:**
 * 
 * 1.  **Package Representation:** Create a class named `Package` with private fields: `packageId` (int), `destinationZone` (String), and `weight` (double). Include a constructor and a `toString()` method that provides a clear representation of a package.
 * 2.  **Delivery Service Management:** Create a class named `DeliveryService` that manages the package workflow.
 *     *   It must use a `java.util.Queue<Package>` to hold packages waiting for processing.
 *     *   It must use a `java.util.ArrayList<Package>` to hold packages that have been successfully processed (delivered).
 *     *   It must use a `java.util.List<String>` to store a predefined set of valid destination zones (e.g., "North", "South", "East", "West").
 *     *   Implement methods within `DeliveryService`:
 *         *   `addPackage(int id, String zone, double weight)`: Adds a new package to the processing queue after validation.
 *         *   `processNextPackage()`: Removes the next package from the queue and adds it to the delivered list.
 *         *   `displayProcessingQueue()`: Prints the details of all packages currently in the processing queue.
 *         *   `displayDeliveredPackages()`: Prints the details of all packages in the delivered list.
 * 3.  **User Interface:** Implement a text-based menu in the `main` method of a separate class (e.g., `DeliveryServiceApp` or `Main`) using `java.util.Scanner` for user input. The menu should offer the following options:
 *     *   1. Add Package
 *     *   2. Process Next Package
 *     *   3. View Processing Queue
 *     *   4. View Delivered Packages
 *     *   0. Exit
 * 4.  **Control Flow:** Use a `switch` statement to handle the user's menu selection.
 * 5.  **Input Validation:**
 *     *   In the `addPackage` method, validate that the package ID and weight are positive numbers, and the destination zone is one of the valid zones defined in the `DeliveryService`.
 *     *   Use `System.err` to print error messages for invalid input.
 * 6.  **Error Handling:**
 *     *   In `processNextPackage`, check if the processing queue is empty before attempting to process. If empty, print an error message using `System.err`.
 *     *   Implement class-wide exception handling (or wrap the main application loop/critical input sections) using `try-catch` blocks to gracefully handle potential runtime errors, such as the user entering non-numeric input when a number is expected (`java.util.InputMismatchException`). Print error details using `System.err`. Ensure the `Scanner` is closed properly.
 * 7.  **Output:** Use `System.out` for displaying the menu, prompts, success messages, and the contents of the queues/lists.
 * 8.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Maintain a clean and readable code structure.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, accept user input to perform actions, print informative messages to `System.out` for successful operations and status displays, and print error messages to `System.err` for validation failures or operational errors (like processing from an empty queue or invalid input type). The program should continue running until the user selects the Exit option and should handle input errors gracefully without crashing.
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * --- Package Delivery Service ---
 * 
 * Select an option:
 * 1. Add Package
 * 2. Process Next Package
 * 3. View Processing Queue
 * 4. View Delivered Packages
 * 0. Exit
 * Enter your choice: 1
 * 
 * --- Add New Package ---
 * Enter Package ID: 101
 * Enter Destination Zone: North
 * Enter Weight (kg): 5.5
 * Package 101 added to the processing queue.
 * 
 * Select an option:
 * ...
 * Enter your choice: 1
 * --- Add New Package ---
 * Enter Package ID: 102
 * Enter Destination Zone: South
 * Enter Weight (kg): 10.0
 * Package 102 added to the processing queue.
 * 
 * Select an option:
 * ...
 * Enter your choice: 3
 * 
 * --- Processing Queue ---
 * 1. Package [ID=101, Zone='North', Weight=5.50 kg]
 * 2. Package [ID=102, Zone='South', Weight=10.00 kg]
 * ------------------------
 * 
 * Select an option:
 * ...
 * Enter your choice: 2
 * 
 * --- Process Next Package ---
 * Package 101 processed and moved to delivered.
 * 
 * Select an option:
 * ...
 * Enter your choice: 3
 * 
 * --- Processing Queue ---
 * 1. Package [ID=102, Zone='South', Weight=10.00 kg]
 * ------------------------
 * 
 * Select an option:
 * ...
 * Enter your choice: 4
 * 
 * --- Delivered Packages ---
 * 1. Package [ID=101, Zone='North', Weight=5.50 kg]
 * --------------------------
 * 
 * Select an option:
 * ...
 * Enter your choice: 1
 * --- Add New Package ---
 * Enter Package ID: -5
 * Error: Package ID must be positive.
 * 
 * Select an option:
 * ...
 * Enter your choice: 5
 * Error: Invalid choice. Please enter a number from the menu.
 * 
 * Select an option:
 * ...
 * Enter your choice: two
 * Invalid input. Please enter a number.
 * 
 * Select an option:
 * ...
 * Enter your choice: 0
 * Exiting Package Delivery Service. Goodbye!
 * Scanner closed.
 * ```
 *
 * EXPLANATION:
 * This solution implements a simple Package Delivery Service simulation, demonstrating the required Java concepts and best practices.
 * 
 * **1. Class Structure and Encapsulation:**
 * - The code is organized into three classes: `Package`, `DeliveryService`, and `DeliveryServiceApp`.
 * - `Package` is a simple Plain Old Java Object (POJO) representing a package. Its fields (`packageId`, `destinationZone`, `weight`) are `private`, adhering to encapsulation. Public getter methods are provided. The `toString()` method offers a convenient string representation.
 * - `DeliveryService` encapsulates the core logic and data structures (`processingQueue`, `deliveredPackages`, `validZones`). Its fields are `private`, and public methods (`addPackage`, `processNextPackage`, etc.) provide controlled access and manipulation of the data.
 * - `DeliveryServiceApp` (or `Main`) contains the `main` method, handling the user interface, menu loop, and interaction with the `DeliveryService`. This separates concerns, making the code modular.
 * 
 * **2. Data Structures:**
 * - `java.util.Queue<Package>` (`processingQueue`): A `LinkedList` is used as a concrete implementation of the `Queue` interface. The `Queue` is appropriate here because packages are processed in a First-In, First-Out (FIFO) manner. `offer()` is used to add elements (non-blocking add), and `poll()` is used to remove and retrieve the head of the queue.
 * - `java.util.ArrayList<Package>` (`deliveredPackages`): An `ArrayList` is used to store packages after they have been processed. `ArrayList` provides dynamic array capabilities, suitable for storing and accessing delivered packages by index or iterating through them.
 * - `java.util.List<String>` (`validZones`): A `List` is used to store the predefined valid destination zones. `Arrays.asList()` creates an immutable `List` for simplicity, ensuring the valid zones are not accidentally modified during execution.
 * 
 * **3. User Interaction and Control Flow:**
 * - `java.util.Scanner`: Used in `DeliveryServiceApp` to read user input from the console for menu choices and package details.
 * - `switch` statement: Used in the `main` method to efficiently direct the program flow based on the user's numeric menu selection.
 * 
 * **4. Input Validation and Error Handling:**
 * - `System.err`: Used consistently to print error messages. This includes validation errors in `addPackage` (negative ID/weight, invalid zone), operational errors in `processNextPackage` (empty queue), and input parsing errors caught in `main` (`InputMismatchException`). Using `System.err` differentiates error output from normal program output (`System.out`).
 * - Input Validation in `addPackage`: Checks if `id` and `weight` are positive and if the `zone` is present in the `validZones` list (case-insensitively). It returns `false` and prints an error to `System.err` if validation fails.
 * - Empty Queue Handling: `processNextPackage` checks `processingQueue.isEmpty()` before calling `poll()`. If true, it prints an error to `System.err` and returns `false`.
 * - `try-catch` blocks:
 *     - A specific `try-catch(InputMismatchException)` is used when reading integer or double input from the `Scanner` (both for the menu choice and package details). This catches errors if the user enters non-numeric text when a number is expected. The invalid input is consumed (`scanner.next()` or `scanner.nextLine()`) to prevent an infinite loop, and an error message is printed to `System.err`.
 *     - A broader `try-catch(Exception e)` wraps the entire `while` loop in the `main` method. This serves as a "class-wide" or top-level handler for any other unexpected runtime exceptions that might occur, preventing the program from crashing abruptly. It prints the exception message and stack trace to `System.err`.
 * - `finally` block: Used to ensure the `Scanner` resource is closed properly, even if exceptions occur or the loop terminates.
 * 
 * **5. Output:**
 * - `System.out`: Used for displaying the menu, prompts for input, success messages (e.g., "Package added..."), and the formatted contents of the queues/lists when display options are chosen.
 * 
 * **6. Best Practices:**
 * - Meaningful names like `processingQueue`, `deliveredPackages`, `addPackage`, `displayProcessingQueue` make the code's purpose clear.
 * - Comments and basic Javadoc are included for classes and methods, explaining their roles and parameters.
 * - The code structure is clean, with separate classes for different responsibilities and methods performing specific tasks.
 * 
 * This solution effectively integrates the required Java components within a practical simulation context, demonstrating understanding of collections, object-oriented principles, user input handling, and robust error management.
 */

import java.util.Queue;
import java.util.LinkedList; // Common Queue implementation
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays; // To easily create the zones list
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single package with its details.
 */
class Package {
    private int packageId;
    private String destinationZone;
    private double weight;

    /**
     * Constructs a new Package object.
     *
     * @param packageId       The unique identifier for the package.
     * @param destinationZone The destination zone for the package.
     * @param weight          The weight of the package in kilograms.
     */
    public Package(int packageId, String destinationZone, double weight) {
        this.packageId = packageId;
        this.destinationZone = destinationZone;
        this.weight = weight;
    }

    // Getters (Included for completeness, though not strictly required by problem display logic)
    public int getPackageId() { return packageId; }
    public String getDestinationZone() { return destinationZone; }
    public double getWeight() { return weight; }


    /**
     * Returns a string representation of the Package object.
     *
     * @return A formatted string including package ID, zone, and weight.
     */
    @Override
    public String toString() {
        return "Package [ID=" + packageId + ", Zone='" + destinationZone + "', Weight=" + String.format("%.2f", weight) + " kg]";
    }
}

/**
 * Manages the package processing workflow using queues and lists.
 */
class DeliveryService {
    private Queue<Package> processingQueue;
    private ArrayList<Package> deliveredPackages;
    private List<String> validZones;

    /**
     * Constructs a DeliveryService, initializing collections and valid zones.
     */
    public DeliveryService() {
        // Use LinkedList as a concrete implementation of Queue
        processingQueue = new LinkedList<>();
        // Use ArrayList for the list of delivered packages
        deliveredPackages = new ArrayList<>();
        // Use List interface with an immutable list of valid zones
        validZones = Arrays.asList("North", "South", "East", "West", "Central");
        System.out.println("Delivery Service initialized with valid zones: " + validZones);
    }

    /**
     * Adds a new package to the processing queue after validating its details.
     *
     * @param id     The package ID.
     * @param zone   The destination zone.
     * @param weight The package weight.
     * @return true if the package was added successfully, false otherwise.
     */
    public boolean addPackage(int id, String zone, double weight) {
        // Input Validation
        if (id <= 0) {
            System.err.println("Error: Package ID must be positive.");
            return false;
        }
        if (weight <= 0) {
            System.err.println("Error: Package weight must be positive.");
            return false;
        }
        // Case-insensitive zone check
        boolean zoneIsValid = false;
        for(String validZone : validZones) {
            if (validZone.equalsIgnoreCase(zone)) {
                zoneIsValid = true;
                // Use the canonical zone name if found
                zone = validZone;
                break;
            }
        }
        if (!zoneIsValid) {
            System.err.println("Error: Invalid destination zone: '" + zone + "'. Valid zones are: " + validZones);
            return false;
        }

        Package newPackage = new Package(id, zone, weight);
        // Add the package to the end of the processing queue
        processingQueue.offer(newPackage);
        System.out.println("Package " + id + " added to the processing queue.");
        return true;
    }

    /**
     * Processes the next package in the queue, moving it to the delivered list.
     *
     * @return true if a package was processed, false if the queue was empty.
     */
    public boolean processNextPackage() {
        // Check if the queue is empty before processing
        if (processingQueue.isEmpty()) {
            System.err.println("Error: Processing queue is empty. No packages to process.");
            return false;
        }
        // Remove and retrieve the head of the queue
        Package processedPackage = processingQueue.poll();
        // Add the processed package to the delivered list
        deliveredPackages.add(processedPackage);
        System.out.println("Package " + processedPackage.getPackageId() + " processed and moved to delivered.");
        return true;
    }

    /**
     * Displays the details of all packages currently in the processing queue.
     */
    public void displayProcessingQueue() {
        System.out.println("\n--- Processing Queue ---");
        if (processingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            int index = 1;
            for (Package p : processingQueue) {
                System.out.println(index++ + ". " + p);
            }
        }
        System.out.println("------------------------");
    }

    /**
     * Displays the details of all packages in the delivered list.
     */
    public void displayDeliveredPackages() {
        System.out.println("\n--- Delivered Packages ---");
        if (deliveredPackages.isEmpty()) {
            System.out.println("No packages delivered yet.");
        } else {
            // Iterate through the ArrayList
            for (int i = 0; i < deliveredPackages.size(); i++) {
                System.out.println((i + 1) + ". " + deliveredPackages.get(i));
            }
        }
        System.out.println("--------------------------");
    }
}

/**
 * Main application class for the Package Delivery Service simulation.
 * Handles user interaction and menu driven operations.
 */
public class DeliveryServiceApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DeliveryService service = new DeliveryService();
        boolean running = true;

        System.out.println("--- Package Delivery Service ---");

        // Class-wide exception handling using try-catch around the main loop
        try {
            while (running) {
                printMenu();
                System.out.print("Enter your choice: ");

                int choice = -1;
                try {
                    // Handle potential non-integer input for the menu choice
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop iteration
                } finally {
                    // Consume the newline character left by nextInt() or next()
                    // This is crucial before reading lines later
                     scanner.nextLine();
                }


                // Use switch statement for menu navigation
                switch (choice) {
                    case 1: // Add Package
                        System.out.println("\n--- Add New Package ---");
                        int id = -1;
                        double weight = -1;
                        String zone = "";

                        // Use try-catch for input validation within the add package process
                        try {
                            System.out.print("Enter Package ID: ");
                            id = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            System.out.print("Enter Destination Zone: ");
                            zone = scanner.nextLine();

                            System.out.print("Enter Weight (kg): ");
                            weight = scanner.nextDouble();
                            scanner.nextLine(); // Consume newline

                            service.addPackage(id, zone, weight);

                        } catch (InputMismatchException e) {
                            System.err.println("Invalid input type. Please enter correct numeric values for ID and Weight.");
                            scanner.nextLine(); // Consume the rest of the line to prevent infinite loop
                        }
                        break;

                    case 2: // Process Next Package
                        System.out.println("\n--- Process Next Package ---");
                        service.processNextPackage();
                        break;

                    case 3: // View Processing Queue
                        service.displayProcessingQueue();
                        break;

                    case 4: // View Delivered Packages
                        service.displayDeliveredPackages();
                        break;

                    case 0: // Exit
                        System.out.println("Exiting Package Delivery Service. Goodbye!");
                        running = false;
                        break;

                    default:
                        // Handle invalid menu numbers
                        System.err.println("Invalid choice. Please enter a number from the menu.");
                }
            }
        } catch (Exception e) {
            // Catch any other unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to standard error stream
        } finally {
            // Ensure the scanner is closed when the program exits or encounters an error
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed.");
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Add Package");
        System.out.println("2. Process Next Package");
        System.out.println("3. View Processing Queue");
        System.out.println("4. View Delivered Packages");
        System.out.println("0. Exit");
    }
}
