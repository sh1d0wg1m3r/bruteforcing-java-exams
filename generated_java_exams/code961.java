/*
 * Exam Question #961
 * Generated on: 2025-05-12 17:05:44
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Warehouse Package Processing System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified system for managing packages in a warehouse. Packages arrive and are placed in a queue for processing. When a package is processed, its weight is validated, and if valid, it is moved from the processing queue to a specific holding area corresponding to its destination zone. The system should allow warehouse staff to add new packages, process the next package in the queue, view the current processing queue, and view the packages waiting in a specific holding area.
 * 
 * **Requirements:**
 * 
 * 1.  **Package Representation:** Create a `Package` class to represent a package. It should have private fields for `packageId` (String), `weightKg` (double), and `destinationZone` (String). Include a constructor and public getter methods for these fields (encapsulation).
 * 2.  **Warehouse System:** Create a `Warehouse` class to manage the package flow. This class should contain:
 *     *   A `Queue<Package>` to store packages waiting to be processed (`processingQueue`).
 *     *   A `Map<String, List<Package>>` to store packages in different holding areas, where the key is the destination zone (String) and the value is a `List<Package>` (using `ArrayList` implementation).
 *     *   A `Scanner` instance for handling user input within the main execution loop.
 * 3.  **Core Functionality:** Implement the following methods in the `Warehouse` class:
 *     *   `addPackage(String packageId, double weightKg, String destinationZone)`: Adds a new `Package` object to the `processingQueue`. Perform basic validation (ID not empty, weight positive, zone valid).
 *     *   `processNextPackage()`: Takes the next package from the `processingQueue`. Validates its weight (e.g., maximum allowed weight is 50 kg). If valid, removes it from the queue and adds it to the appropriate `List` in the `holdingAreas` map based on its `destinationZone`. If the zone doesn't exist in the map yet, create a new `ArrayList` for it. If the queue is empty or the package weight is invalid, report an error.
 *     *   `viewProcessingQueue()`: Displays the contents of the `processingQueue`.
 *     *   `viewHoldingArea(String zone)`: Displays the contents of the `List` associated with the given `zone` in `holdingAreas`.
 *     *   `isValidZone(String zone)`: A helper method to check if a given zone string is one of the allowed zones (e.g., "A", "B", "C", "D").
 * 4.  **User Interface:** Implement a simple command-line interface using a loop and a `switch` statement to handle user commands:
 *     *   `1: Add Package` (Prompts for ID, weight, zone)
 *     *   `2: Process Next Package`
 *     *   `3: View Processing Queue`
 *     *   `4: View Holding Area` (Prompts for zone)
 *     *   `5: Exit`
 * 5.  **Input Handling:** Use `java.util.Scanner` to read user input for menu choices and package details.
 * 6.  **Error Handling:**
 *     *   Use `System.err.println()` to print error messages (e.g., invalid input, processing empty queue, invalid zone).
 *     *   Use `System.out.println()` for normal output (menu, successful operations, list contents).
 *     *   Implement **class-wide** exception handling using a `try-catch` block around the main user interaction loop or the core processing logic within the `Warehouse` class's execution method to catch unexpected runtime exceptions.
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include comments where necessary to explain complex logic.
 *     *   Ensure proper encapsulation in the `Package` class.
 * 
 * **Allowed Zones:** "A", "B", "C", "D"
 * **Maximum Allowed Package Weight:** 50.0 kg
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept user input, perform the requested actions, print results to `System.out`, and print errors to `System.err`. Example interactions might look like:
 * 
 * ```
 * Warehouse Package Processing System
 * Menu:
 * 1: Add Package
 * 2: Process Next Package
 * 3: View Processing Queue
 * 4: View Holding Area
 * 5: Exit
 * Enter choice: 1
 * Enter Package ID: P101
 * Enter Weight (kg): 15.5
 * Enter Destination Zone (A, B, C, D): A
 * Package P101 added to processing queue.
 * 
 * Enter choice: 1
 * Enter Package ID: P102
 * Enter Weight (kg): 60.0
 * Enter Destination Zone (A, B, C, D): B
 * Package P102 added to processing queue.
 * 
 * Enter choice: 3
 * Processing Queue:
 * Package [ID: P101, Weight: 15.5kg, Zone: A]
 * Package [ID: P102, Weight: 60.0kg, Zone: B]
 * 
 * Enter choice: 2
 * Processing package P101...
 * Package P101 (15.5kg) processed and moved to holding area A.
 * 
 * Enter choice: 2
 * Processing package P102...
 * Error: Package P102 exceeds maximum allowed weight (50.0kg). Not moved to holding area.
 * 
 * Enter choice: 4
 * Enter Zone to view: A
 * Holding Area A:
 * Package [ID: P101, Weight: 15.5kg, Zone: A]
 * 
 * Enter choice: 4
 * Enter Zone to view: B
 * Holding Area B:
 * (empty)
 * 
 * Enter choice: 4
 * Enter Zone to view: Z
 * Error: Invalid zone: Z. Allowed zones are A, B, C, D.
 * 
 * Enter choice: 5
 * Exiting system.
 * ```
 * 
 * Your solution should compile and run, demonstrating the use of all required components and handling the specified logic and errors.
 *
 * EXPLANATION:
 * This solution implements the `Warehouse Package Processing System` as described in the exam question, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Package` Class:**
 *     *   This class serves as a simple data structure using encapsulation.
 *     *   Private fields (`packageId`, `weightKg`, `destinationZone`) protect the internal state.
 *     *   Public getter methods (`getPackageId`, `getWeightKg`, `getDestinationZone`) provide controlled access to the data.
 *     *   The constructor includes basic validation for non-empty ID/zone and positive weight, throwing `IllegalArgumentException` if validation fails.
 *     *   The `toString()` method is overridden for convenient printing of `Package` objects.
 * 
 * 2.  **`Warehouse` Class:**
 *     *   This is the main class managing the system logic.
 *     *   `processingQueue`: A `java.util.Queue` is used, specifically a `LinkedList` implementation. A queue is ideal here because packages are processed in the order they arrive (FIFO - First-In, First-Out). `offer()` is used to add to the tail, `peek()` to view the head, and `poll()` to remove the head.
 *     *   `holdingAreas`: A `java.util.Map` (`HashMap`) is used to map destination zones (String keys) to their respective holding areas. The values are `java.util.List` (specifically `ArrayList` implementations). This structure allows efficient lookup of the holding area for a given zone. `ArrayList` is suitable for the holding areas as we might need to iterate or just store packages, and random access isn't a primary requirement, but it works well. The use of `List` as the map value type demonstrates polymorphism.
 *     *   `allowedZones`: A `Set` (`HashSet`) is used to store the valid destination zones. Using a `Set` provides efficient O(1) average time complexity for checking if a zone is valid (`contains()` method).
 *     *   `MAX_WEIGHT_KG`: A constant for the maximum allowed package weight, promoting readability and easy modification.
 * 
 * 3.  **Core Functionality Methods:**
 *     *   `addPackage()`: Creates a `Package` object. It includes input validation (using the `Package` constructor's validation and `isValidZone`) and adds the package to the `processingQueue` using `offer()`. Error messages are printed to `System.err`.
 *     *   `processNextPackage()`:
 *         *   Checks if the `processingQueue` is empty.
 *         *   Uses `peek()` to look at the next package without removing it yet.
 *         *   Validates the package's weight against `MAX_WEIGHT_KG`. If invalid, an error is printed to `System.err`, and the package is removed using `poll()`.
 *         *   If the weight is valid, it retrieves the appropriate `List` from `holdingAreas` based on the package's zone. If the list doesn't exist (though initialized in the constructor, defensive programming is good), it creates a new `ArrayList`.
 *         *   The package is added to the zone's `List`.
 *         *   Finally, the package is removed from the `processingQueue` using `poll()`.
 *         *   Success/error messages are printed to `System.out` or `System.err`.
 *     *   `viewProcessingQueue()`: Iterates through the `processingQueue` (using an enhanced for loop, which doesn't remove elements) and prints each `Package` using its `toString()` method. Prints "(empty)" if the queue is empty.
 *     *   `viewHoldingArea()`: Validates the input zone using `isValidZone()`. If valid, it retrieves the corresponding `List` from `holdingAreas` and iterates through it, printing each `Package`. Prints "(empty)" if the list is empty or the zone is not found (though `isValidZone` handles the latter). Error messages for invalid zones go to `System.err`.
 *     *   `isValidZone()`: A private helper method using the `allowedZones` `Set` for efficient validation. Converts the input zone to uppercase for case-insensitive comparison.
 * 
 * 4.  **User Interface (`run` method):**
 *     *   The `run` method contains the main application loop.
 *     *   A `Scanner` is initialized to read input from `System.in`.
 *     *   A `while` loop keeps the system running until the user chooses to exit.
 *     *   A `switch` statement handles the user's menu choice, directing execution to the appropriate methods (`addPackage`, `processNextPackage`, etc.).
 *     *   Input validation for the menu choice (checking if it's an integer) and package details (weight) is performed, printing errors to `System.err`.
 * 
 * 5.  **Error Handling:**
 *     *   Specific error conditions (empty queue, invalid weight, invalid zone, invalid menu input) are checked explicitly, and informative messages are printed to `System.err.println()`.
 *     *   `System.out.println()` is used for all successful operations, menu display, and list contents.
 *     *   **Class-wide Exception Handling:** The entire `while` loop within the `run` method is wrapped in a `try-catch(Exception e)` block. This demonstrates catching any unexpected runtime exceptions that might occur within the core application logic, preventing the program from crashing abruptly. The caught exception's message and stack trace are printed to `System.err`. A `finally` block ensures the `Scanner` is closed.
 * 
 * 6.  **Best Practices:**
 *     *   Meaningful names (`processingQueue`, `holdingAreas`, `processNextPackage`, `weightKg`, `destinationZone`).
 *     *   Comments explaining the purpose of classes, methods, and key logic sections.
 *     *   Encapsulation in the `Package` class.
 *     *   Input validation at various points (`addPackage`, `viewHoldingArea`, menu choice parsing).
 *     *   Use of constants (`MAX_WEIGHT_KG`).
 * 
 * This solution effectively integrates `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch` blocks within a practical, object-oriented design, fulfilling all requirements of the complex exam task.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

// Represents a package in the warehouse
class Package {
    private String packageId;
    private double weightKg;
    private String destinationZone;

    // Constructor
    public Package(String packageId, double weightKg, String destinationZone) {
        // Basic validation during construction
        if (packageId == null || packageId.trim().isEmpty()) {
            throw new IllegalArgumentException("Package ID cannot be null or empty.");
        }
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be positive.");
        }
        if (destinationZone == null || destinationZone.trim().isEmpty()) {
             throw new IllegalArgumentException("Destination zone cannot be null or empty.");
        }

        this.packageId = packageId.trim();
        this.weightKg = weightKg;
        this.destinationZone = destinationZone.trim().toUpperCase(); // Store zone in uppercase
    }

    // Public getter methods
    public String getPackageId() {
        return packageId;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDestinationZone() {
        return destinationZone;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "Package [ID: " + packageId + ", Weight: " + weightKg + "kg, Zone: " + destinationZone + "]";
    }
}

// Manages package processing and holding areas
class Warehouse {
    private Queue<Package> processingQueue;
    private Map<String, List<Package>> holdingAreas;
    private Set<String> allowedZones; // Using a Set for efficient zone validation
    private static final double MAX_WEIGHT_KG = 50.0; // Max allowed weight

    // Constructor
    public Warehouse() {
        this.processingQueue = new LinkedList<>(); // LinkedList implements Queue
        this.holdingAreas = new HashMap<>();
        this.allowedZones = new HashSet<>();
        allowedZones.add("A");
        allowedZones.add("B");
        allowedZones.add("C");
        allowedZones.add("D");

        // Initialize holding areas for known zones (optional, but good practice)
        for(String zone : allowedZones) {
            holdingAreas.put(zone, new ArrayList<>()); // ArrayList implements List
        }
    }

    /**
     * Adds a new package to the processing queue.
     * Performs basic validation before adding.
     */
    public void addPackage(String packageId, double weightKg, String destinationZone) {
        try {
            Package newPackage = new Package(packageId, weightKg, destinationZone);
            if (!isValidZone(newPackage.getDestinationZone())) {
                 System.err.println("Error: Invalid destination zone '" + newPackage.getDestinationZone() + "'. Package not added.");
                 return; // Stop if zone is invalid
            }
            processingQueue.offer(newPackage); // Use offer for adding to queue
            System.out.println("Package " + newPackage.getPackageId() + " added to processing queue.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding package: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected exceptions during package creation/adding
            System.err.println("An unexpected error occurred while adding package: " + e.getMessage());
        }
    }

    /**
     * Processes the next package from the queue.
     * Validates weight and moves to holding area if valid.
     */
    public void processNextPackage() {
        if (processingQueue.isEmpty()) {
            System.err.println("Error: Processing queue is empty. No packages to process.");
            return;
        }

        Package packageToProcess = processingQueue.peek(); // Use peek to look at the head without removing
        System.out.println("Processing package " + packageToProcess.getPackageId() + "...");

        if (packageToProcess.getWeightKg() > MAX_WEIGHT_KG) {
            System.err.println("Error: Package " + packageToProcess.getPackageId() + " exceeds maximum allowed weight (" + MAX_WEIGHT_KG + "kg). Not moved to holding area.");
            processingQueue.poll(); // Remove the package even if invalid weight, as it's processed
            return;
        }

        String zone = packageToProcess.getDestinationZone();
        if (!isValidZone(zone)) {
             // This case should ideally not happen if addPackage validates zones,
             // but defensive programming is good.
             System.err.println("Error: Package " + packageToProcess.getPackageId() + " has an invalid destination zone '" + zone + "'. Not moved to holding area.");
             processingQueue.poll(); // Remove invalid package
             return;
        }

        // Get or create the holding area list for the zone
        List<Package> zoneHoldingArea = holdingAreas.get(zone);
        if (zoneHoldingArea == null) {
             // Should not happen if initialized, but handle defensively
             zoneHoldingArea = new ArrayList<>();
             holdingAreas.put(zone, zoneHoldingArea);
        }

        zoneHoldingArea.add(packageToProcess); // Add to the holding area list
        processingQueue.poll(); // Remove from the processing queue (after successful handling)

        System.out.println("Package " + packageToProcess.getPackageId() + " (" + packageToProcess.getWeightKg() + "kg) processed and moved to holding area " + zone + ".");
    }

    /**
     * Displays all packages currently in the processing queue.
     */
    public void viewProcessingQueue() {
        System.out.println("Processing Queue:");
        if (processingQueue.isEmpty()) {
            System.out.println("(empty)");
        } else {
            // Iterate without removing elements
            for (Package p : processingQueue) {
                System.out.println(p);
            }
        }
    }

    /**
     * Displays all packages in a specific holding area.
     * Validates the zone before displaying.
     */
    public void viewHoldingArea(String zone) {
        String upperZone = zone.trim().toUpperCase();
        if (!isValidZone(upperZone)) {
            System.err.println("Error: Invalid zone: " + zone + ". Allowed zones are " + String.join(", ", allowedZones) + ".");
            return;
        }

        System.out.println("Holding Area " + upperZone + ":");
        List<Package> zoneHoldingArea = holdingAreas.get(upperZone);
        if (zoneHoldingArea == null || zoneHoldingArea.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (Package p : zoneHoldingArea) {
                System.out.println(p);
            }
        }
    }

    /**
     * Checks if a given zone string is one of the allowed zones.
     * @param zone The zone string to check.
     * @return true if the zone is allowed, false otherwise.
     */
    private boolean isValidZone(String zone) {
        return allowedZones.contains(zone.trim().toUpperCase());
    }

    /**
     * Runs the main application loop with user interaction.
     * Includes class-wide try-catch for unexpected errors.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                printMenu();
                System.out.print("Enter choice: ");

                int choice = -1;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    continue; // Skip to next iteration
                }

                switch (choice) {
                    case 1: // Add Package
                        System.out.print("Enter Package ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Weight (kg): ");
                        double weight = -1;
                        try {
                            weight = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Invalid weight input. Please enter a number.");
                            break; // Stay in the loop, but finish this case
                        }
                        System.out.print("Enter Destination Zone (" + String.join(", ", allowedZones) + "): ");
                        String zone = scanner.nextLine();
                        addPackage(id, weight, zone);
                        break;

                    case 2: // Process Next Package
                        processNextPackage();
                        break;

                    case 3: // View Processing Queue
                        viewProcessingQueue();
                        break;

                    case 4: // View Holding Area
                        System.out.print("Enter Zone to view (" + String.join(", ", allowedZones) + "): ");
                        String viewZone = scanner.nextLine();
                        viewHoldingArea(viewZone);
                        break;

                    case 5: // Exit
                        running = false;
                        System.out.println("Exiting system.");
                        break;

                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                System.out.println(); // Add a newline for spacing
            }
        } catch (Exception e) {
            // This catches any uncaught exceptions that bubble up from the switch cases
            // or the loop itself, demonstrating class-wide handling.
            System.err.println("An unexpected critical error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
             // Ensure scanner is closed
             if (scanner != null) {
                 scanner.close();
             }
        }
    }

    // Prints the main menu options
    private void printMenu() {
        System.out.println("Warehouse Package Processing System");
        System.out.println("Menu:");
        System.out.println("1: Add Package");
        System.out.println("2: Process Next Package");
        System.out.println("3: View Processing Queue");
        System.out.println("4: View Holding Area");
        System.out.println("5: Exit");
    }

    // Main method to start the application
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        warehouse.run();
    }
}
