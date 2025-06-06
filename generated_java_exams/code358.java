/*
 * Exam Question #358
 * Generated on: 2025-05-11 23:00:01
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Java Programming Exam: Package Sorting Hub Simulation
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified simulation of a package sorting hub. Packages arrive, are placed in an incoming queue, processed one by one, and then sorted into specific zones based on their destination. The system should allow adding new packages, processing the next package in the queue, and viewing the packages currently sorted in each zone.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `Queue<Package>` to represent the incoming packages waiting to be processed.
 *     *   Use `List<Package>` (implemented as `ArrayList<Package>`) to store packages sorted into different destination zones (e.g., Zone A, Zone B, Zone C). You should have a separate list for each zone.
 * 
 * 2.  **Classes:**
 *     *   Create a `Package` class with private fields for `packageId` (String), `destinationZone` (String, e.g., "A", "B", "C"), and `weightKg` (double). Include a constructor and public getter methods for these fields.
 *     *   Create a `SortingHub` class that manages the incoming queue and the sorted lists. This class should have methods for:
 *         *   Adding a package to the incoming queue.
 *         *   Processing the next package from the queue and adding it to the correct zone list.
 *         *   Viewing the packages currently in each sorted zone list.
 *         *   A method to run the main simulation loop (menu, input handling).
 * 
 * 3.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user (e.g., Add Package, Process Package, View Sorted Packages, Exit).
 *     *   Use a `switch` statement to handle the user's choice from the menu.
 * 
 * 4.  **Output and Error Handling:**
 *     *   Use `System.out` for normal program output (menu, prompts, success messages, displaying sorted packages).
 *     *   Use `System.err` to print error messages (e.g., invalid input, trying to process from an empty queue).
 *     *   Implement input validation:
 *         *   Package ID should not be empty.
 *         *   Destination zone should be one of the valid zones (e.g., "A", "B", "C").
 *         *   Weight should be a positive number.
 *     *   Implement exception handling:
 *         *   Use `try-catch` blocks within the `SortingHub` class (or its methods) to handle potential runtime errors, particularly around input parsing or unexpected conditions. A broad `catch (Exception e)` at a high level is acceptable for this simulation's main loop, along with more specific checks for input validation.
 * 
 * 5.  **Best Practices:**
 *     *   Adhere to proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include basic comments or Javadoc explaining the purpose of classes and methods.
 *     *   Ensure clean code structure.
 * 
 * **Valid Destination Zones:** For this simulation, the valid zones are "A", "B", and "C". Input should be case-insensitive (e.g., "a" or "A" should be accepted for Zone A).
 * 
 * **Expected Output/Interaction:**
 * 
 * The program should repeatedly display a menu, prompt for user input, and perform the requested action, printing appropriate messages to `System.out` or `System.err`.
 * 
 * ```
 * --- Sorting Hub Menu ---
 * 1. Add Package to Queue
 * 2. Process Next Package
 * 3. View Sorted Packages
 * 4. Exit
 * Enter your choice: 1
 * Enter Package ID: PKG001
 * Enter Destination Zone (A, B, C): A
 * Enter Weight (kg): 5.5
 * Package PKG001 added to the incoming queue.
 * 
 * --- Sorting Hub Menu ---
 * ...
 * Enter your choice: 2
 * Processing package from queue...
 * Package PKG001 (Zone A, 5.5 kg) processed and moved to Zone A.
 * 
 * --- Sorting Hub Menu ---
 * ...
 * Enter your choice: 3
 * --- Sorted Packages (Zone A) ---
 * ID: PKG001, Zone: A, Weight: 5.5 kg
 * --- Sorted Packages (Zone B) ---
 * (Empty)
 * --- Sorted Packages (Zone C) ---
 * (Empty)
 * 
 * --- Sorting Hub Menu ---
 * ...
 * Enter your choice: 2
 * Processing package from queue...
 * Error: The incoming queue is empty. No packages to process.
 * 
 * --- Sorting Hub Menu ---
 * ...
 * Enter your choice: 1
 * Enter Package ID:
 * Error: Package ID cannot be empty.
 * ```
 * 
 * Your task is to write the complete Java code for this simulation.
 *
 * EXPLANATION:
 * This solution implements a simplified package sorting hub simulation, demonstrating the required Java concepts.
 * 
 * 1.  **`Package` Class:** A simple Plain Old Java Object (POJO) representing a package. It has `private` fields (`packageId`, `destinationZone`, `weightKg`) and `public` getter methods, adhering to encapsulation principles. The `toString()` method provides a convenient way to print package details.
 * 
 * 2.  **`SortingHub` Class:** This is the main class managing the simulation logic and data structures.
 *     *   **Data Structures:**
 *         *   `incomingQueue`: Declared as `Queue<Package>` and initialized with `new LinkedList<>()`. `LinkedList` is a common implementation of the `Queue` interface, suitable for adding to the end and removing from the front (`offer`/`add` and `poll`/`remove`). This correctly uses the `Queue` interface.
 *         *   `zoneAPackages`, `zoneBPackages`, `zoneCPackages`: Declared as `List<Package>` and initialized with `new ArrayList<>()`. This demonstrates using the `List` interface while implementing it with `ArrayList`, fulfilling the requirement to use both. `ArrayList` is suitable here for storing sorted packages where access by index or iteration is common.
 *     *   **Constructor:** Initializes the queue, lists, and the `Scanner` object for user input.
 *     *   **`addPackage()` Method:**
 *         *   Prompts the user for package details using the `Scanner`.
 *         *   Includes input validation: checks for empty ID, validates the zone against allowed values ("A", "B", "C" - case-insensitive), and ensures weight is a positive number.
 *         *   Uses `System.err` to report validation errors.
 *         *   Uses a `try-catch` block specifically around the `Double.parseDouble()` call to handle `NumberFormatException` if the user enters non-numeric input for weight.
 *         *   If input is valid, creates a `Package` object and adds it to the `incomingQueue` using the `add()` method.
 *         *   Uses `System.out` for successful addition messages.
 *     *   **`processNextPackage()` Method:**
 *         *   Checks if the `incomingQueue` is empty. If so, prints an error to `System.err` and returns.
 *         *   Uses `incomingQueue.poll()` to retrieve and remove the next package from the front of the queue. This is the standard way to process items from a queue.
 *         *   Uses a `switch` statement on the package's destination zone to determine which sorted list (`zoneAPackages`, `zoneBPackages`, or `zoneCPackages`) the package should be added to. This fulfills the `switch` statement requirement.
 *         *   Adds the processed package to the appropriate `List` using the `add()` method.
 *         *   Uses `System.out` to confirm the processing and sorting action.
 *     *   **`viewSortedPackages()` Method:**
 *         *   Iterates through each zone's `List`.
 *         *   Calls a helper method `displayPackageList` to print the contents of each list.
 *         *   Uses `System.out` for headers and package details.
 *     *   **`displayPackageList()` Method:** A private helper method to avoid code duplication when displaying the contents of the lists. It checks if the list is empty or iterates through it, printing each `Package` object's `toString()` representation.
 *     *   **`runSimulation()` Method:**
 *         *   Contains the main application loop (`while (choice != 4)`).
 *         *   Prints the menu using `printMenu()`.
 *         *   Reads user input using `scanner.nextLine()`.
 *         *   Includes a `try-catch` block around the main loop (`catch (Exception e)`) to demonstrate class-wide or high-level exception handling for unexpected errors. More specific `try-catch` (like the one in `addPackage` for parsing) is also used where appropriate.
 *         *   Parses the user's input string to an integer, handling potential `NumberFormatException` by setting `choice` to an invalid value, which is then caught by the `default` case of the switch.
 *         *   Uses a `switch` statement to call the appropriate method based on the user's valid choice (1-4).
 *         *   The `finally` block ensures the `Scanner` is closed when the simulation loop exits or if an unexpected exception occurs, which is good resource management practice.
 *     *   **`printMenu()` Method:** A private helper method to display the user menu clearly using `System.out`.
 *     *   **`main()` Method:** The entry point of the application. It creates an instance of `SortingHub` and calls `runSimulation()` to start the program.
 * 
 * This solution effectively integrates all the required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, following best practices like encapsulation, meaningful names, and basic error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException; // Specific exception for Scanner issues

// Represents a package to be sorted and shipped
class Package {
    private String packageId;
    private String destinationZone;
    private double weightKg;

    public Package(String packageId, String destinationZone, double weightKg) {
        this.packageId = packageId;
        this.destinationZone = destinationZone;
        this.weightKg = weightKg;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getDestinationZone() {
        return destinationZone;
    }

    public double getWeightKg() {
        return weightKg;
    }

    @Override
    public String toString() {
        return "ID: " + packageId + ", Zone: " + destinationZone + ", Weight: " + weightKg + " kg";
    }
}

// Manages the package sorting operations
public class SortingHub { // Changed class name to SortingHub as requested in scenario

    private Queue<Package> incomingQueue;
    private List<Package> zoneAPackages;
    private List<Package> zoneBPackages;
    private List<Package> zoneCPackages;
    private Scanner scanner;

    public SortingHub() {
        // LinkedList is a common implementation for Queue
        incomingQueue = new LinkedList<>();
        // ArrayList is a common implementation for List
        zoneAPackages = new ArrayList<>();
        zoneBPackages = new ArrayList<>();
        zoneCPackages = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a new package to the incoming queue after validating input.
     */
    public void addPackage() {
        System.out.print("Enter Package ID: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.err.println("Error: Package ID cannot be empty.");
            return;
        }

        System.out.print("Enter Destination Zone (A, B, C): ");
        String zone = scanner.nextLine().trim().toUpperCase();

        if (!zone.equals("A") && !zone.equals("B") && !zone.equals("C")) {
            System.err.println("Error: Invalid destination zone. Must be A, B, or C.");
            return;
        }

        System.out.print("Enter Weight (kg): ");
        double weight;
        try {
            weight = Double.parseDouble(scanner.nextLine().trim());
            if (weight <= 0) {
                System.err.println("Error: Weight must be a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid weight format. Please enter a number.");
            return;
        }

        Package newPackage = new Package(id, zone, weight);
        incomingQueue.add(newPackage);
        System.out.println("Package " + id + " added to the incoming queue.");
    }

    /**
     * Processes the next package from the incoming queue and sorts it.
     */
    public void processNextPackage() {
        System.out.println("Processing package from queue...");
        if (incomingQueue.isEmpty()) {
            System.err.println("Error: The incoming queue is empty. No packages to process.");
            return;
        }

        Package packageToProcess = incomingQueue.poll(); // Get and remove the head of the queue

        String zone = packageToProcess.getDestinationZone();
        switch (zone) {
            case "A":
                zoneAPackages.add(packageToProcess);
                break;
            case "B":
                zoneBPackages.add(packageToProcess);
                break;
            case "C":
                zoneCPackages.add(packageToProcess);
                break;
            // Defensive case, should not be reached with input validation
            default:
                System.err.println("Error: Processed package with unknown zone: " + zone);
                // Optionally re-add to a rejection list or handle differently
                break;
        }
        System.out.println("Package " + packageToProcess.getPackageId() + " (Zone " + zone + ", " + packageToProcess.getWeightKg() + " kg) processed and moved to Zone " + zone + ".");
    }

    /**
     * Displays packages currently sorted into each zone.
     */
    public void viewSortedPackages() {
        System.out.println("--- Sorted Packages (Zone A) ---");
        displayPackageList(zoneAPackages);

        System.out.println("--- Sorted Packages (Zone B) ---");
        displayPackageList(zoneBPackages);

        System.out.println("--- Sorted Packages (Zone C) ---");
        displayPackageList(zoneCPackages);
    }

    /**
     * Helper method to display packages in a list.
     * @param packageList The list of packages to display.
     */
    private void displayPackageList(List<Package> packageList) {
        if (packageList.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            for (Package pkg : packageList) {
                System.out.println(pkg);
            }
        }
    }

    /**
     * Runs the main simulation loop, displaying menu and handling user input.
     */
    public void runSimulation() {
        int choice = -1; // Initialize with a value that won't match any menu option

        // Class-wide exception handling for the main loop
        try {
            while (choice != 4) {
                printMenu();
                System.out.print("Enter your choice: ");

                // Use hasNextLine and nextLine to avoid issues with nextInt and newline
                if (scanner.hasNextLine()) {
                     String inputLine = scanner.nextLine();
                     try {
                        choice = Integer.parseInt(inputLine.trim());
                     } catch (NumberFormatException e) {
                         choice = -1; // Indicate invalid input
                     }
                } else {
                    // Handle potential end-of-input scenario
                    System.err.println("Error: No more input available. Exiting.");
                    break;
                }


                // Use a switch statement for flow control
                switch (choice) {
                    case 1:
                        addPackage();
                        break;
                    case 2:
                        processNextPackage();
                        break;
                    case 3:
                        viewSortedPackages();
                        break;
                    case 4:
                        System.out.println("Exiting Sorting Hub simulation. Goodbye!");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
                System.out.println(); // Add a newline for better readability between actions
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main loop
            System.err.println("An unexpected error occurred during simulation:");
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure scanner is closed
            if (scanner != null) {
                scanner.close();
                System.out.println("Scanner closed.");
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("--- Sorting Hub Menu ---");
        System.out.println("1. Add Package to Queue");
        System.out.println("2. Process Next Package");
        System.out.println("3. View Sorted Packages");
        System.out.println("4. Exit");
    }

    // Main method to start the simulation
    public static void main(String[] args) {
        SortingHub hub = new SortingHub();
        hub.runSimulation();
    }
}
