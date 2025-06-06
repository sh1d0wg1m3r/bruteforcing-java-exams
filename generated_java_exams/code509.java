/*
 * Exam Question #509
 * Generated on: 2025-05-11 23:22:03
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam: Package Processing Simulation
 * 
 * **Objective:** Design and implement a Java program that simulates a simple package processing center. The system should manage packages waiting to be processed and those that have been processed, using appropriate data structures and control flow mechanisms.
 * 
 * **Scenario:** Packages arrive at a processing center and are placed in a queue. Workers process packages one by one from the front of the queue. Once processed, the package's status is updated, and it's moved to a list of completed packages for tracking.
 * 
 * **Requirements:**
 * 
 * 1.  **Package Class:** Create a class named `Package` with the following attributes:
 *     *   `packageId` (String): A unique identifier for the package.
 *     *   `description` (String): A brief description of the package contents.
 *     *   `status` (String): The current status of the package (e.g., "Pending", "Processed").
 *     *   Implement a constructor, appropriate getter methods, and a `toString()` method to display package details. Ensure fields are `private`.
 * 
 * 2.  **Package Processing System:** Create a main class (e.g., `PackageProcessor`) that manages the package flow. It must contain:
 *     *   A `Queue<Package>` to hold packages waiting for processing. Use an appropriate implementation like `LinkedList`.
 *     *   A `List<Package>` to hold packages that have been processed. Use an appropriate implementation like `ArrayList`.
 *     *   A `Scanner` object for reading user input from the console.
 *     *   Methods to perform the following operations based on user interaction:
 *         *   **Add Package:** Prompt the user for package ID and description. Create a new `Package` object with status "Pending" and add it to the processing queue. Implement input validation to ensure ID and description are not empty. If validation fails, print an error message to `System.err` and do not add the package.
 *         *   **Process Next Package:** Take the package at the front of the processing queue. If the queue is not empty, update its status to "Processed" and move it to the list of processed packages. If the queue is empty, print an error message to `System.err`.
 *         *   **View Processing Queue:** Display details of all packages currently in the processing queue, in order. If the queue is empty, print a message indicating so.
 *         *   **View Processed Packages:** Display details of all packages in the list of processed packages. If the list is empty, print a message indicating so.
 *     *   A main loop that presents a menu to the user with options for the above operations and an option to exit.
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential errors, such as invalid input format when reading menu options or issues during collection operations (though explicit collection errors are less likely with proper checks). Print error details to `System.err`.
 * 
 * 3.  **Input/Output:**
 *     *   Use `System.out` for displaying the menu, prompts, and successful operation results.
 *     *   Use `System.err` for displaying all error messages (input validation failures, empty queue processing attempts, general exceptions).
 * 
 * 4.  **Best Practices:**
 *     *   Follow proper encapsulation principles.
 *     *   Use meaningful names for classes, variables, and methods.
 *     *   Include comments where necessary to explain complex logic.
 *     *   Ensure proper resource management (e.g., closing the `Scanner`).
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, displaying a menu like this:
 * 
 * ```
 * --- Package Processing Center ---
 * 1. Add New Package
 * 2. Process Next Package
 * 3. View Processing Queue
 * 4. View Processed Packages
 * 5. Exit
 * Enter your choice: 
 * ```
 * 
 * Based on the user's choice, the program should perform the corresponding action, printing appropriate messages to `System.out` for success or `System.err` for errors. Example interactions:
 * 
 * *   Adding a package: Prompts for ID and description, confirms addition.
 * *   Adding with empty ID/description: Prints error to `System.err`.
 * *   Processing an empty queue: Prints error to `System.err`.
 * *   Processing a package: Confirms processing and package ID.
 * *   Viewing queues/lists: Prints details of packages or "Queue/List is empty." message.
 * 
 * Your solution should be a single Java file containing the `Package` class and the main `PackageProcessor` class with the `main` method.
 * 
 * **Evaluation:** Your solution will be evaluated on correctness, adherence to all requirements (including the use of specified components), code structure, error handling, and best practices.
 *
 * EXPLANATION:
 * The provided solution implements the `Package Processing Simulation` as required, demonstrating the use of various Java concepts and best practices.
 * 
 * 1.  **`Package` Class:**
 *     *   This class models the core entity. It has private fields (`packageId`, `description`, `status`) ensuring encapsulation.
 *     *   A constructor initializes these fields.
 *     *   Getter methods provide controlled access to the data. A setter is provided only for the `status` as it's the only field that changes after creation during the processing flow.
 *     *   The `toString()` method provides a convenient way to display package information.
 * 
 * 2.  **`PackageProcessor` Class:**
 *     *   This is the main class orchestrating the simulation.
 *     *   **Data Structures:**
 *         *   `processingQueue`: Declared as `Queue<Package>` and instantiated as `LinkedList<Package>`. `Queue` is ideal here because packages are processed in the order they arrive (FIFO - First-In, First-Out). `LinkedList` is a common implementation of `Queue`.
 *         *   `processedPackages`: Declared as `List<Package>` and instantiated as `ArrayList<Package>`. `List` is suitable for storing processed items where order might be maintained or random access could be needed (though not used extensively here). `ArrayList` is a common, dynamic array-based implementation. Using the `List` interface for declaration demonstrates polymorphism.
 *     *   **`Scanner`:** An instance is created to read user input from `System.in`. The `try-with-resources` block in the `run` method ensures the scanner is automatically closed, preventing resource leaks.
 *     *   **Methods:**
 *         *   `displayMenu()`: A helper method to print the menu options.
 *         *   `addPackage()`: Prompts for package details, performs basic input validation (checking if ID/description are empty using `trim()` and `isEmpty()`), creates a `Package` object, and adds it to the `processingQueue` using `offer()`. `offer()` is preferred over `add()` for queues as it handles capacity-constrained queues gracefully (though `LinkedList` is unbounded).
 *         *   `processNextPackage()`: Checks if the `processingQueue` is empty using `isEmpty()`. If not, it uses `poll()` to retrieve and remove the package at the head of the queue. It updates the package's status and adds it to the `processedPackages` list using `add()`. An error message is printed to `System.err` if the queue is empty.
 *         *   `viewProcessingQueue()`: Iterates through the `processingQueue` (using `forEach`) to display its contents. It prints a message if the queue is empty.
 *         *   `viewProcessedPackages()`: Iterates through the `processedPackages` list (using `forEach`) to display its contents. It prints a message if the list is empty.
 *         *   `run()`: This method contains the main application loop (`while (choice != 5)`). It repeatedly displays the menu, reads the user's choice, and uses a `switch` statement to call the appropriate method.
 *     *   **Exception Handling:**
 *         *   A `try-catch` block is wrapped around the core logic inside the `while` loop in the `run()` method.
 *         *   `NumberFormatException`: Specifically catches errors if the user's menu input cannot be parsed into an integer. An error message is printed to `System.err`.
 *         *   A general `Exception` catch-all is included to handle any other unexpected runtime errors that might occur during the execution of the chosen operation. This provides robustness, preventing the program from crashing unexpectedly. Error messages are printed to `System.err`.
 *     *   **Input/Output:** `System.out` is used for standard messages (menu, prompts, success). `System.err` is strictly used for error reporting as required.
 *     *   **Best Practices:** The code uses meaningful variable and method names, includes basic comments, and follows encapsulation principles in the `Package` class. The `try-with-resources` for `Scanner` is a good practice for resource management.
 * 
 * 3.  **`main` Method:**
 *     *   The standard entry point of the application. It creates an instance of `PackageProcessor` and calls its `run()` method to start the simulation.
 * 
 * This solution effectively integrates the required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical scenario, demonstrating key object-oriented programming concepts and error handling techniques expected in a challenging Java exam.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a package in the processing system.
 */
class Package {
    private String packageId;
    private String description;
    private String status; // e.g., "Pending", "Processed"

    /**
     * Constructs a new Package.
     * @param packageId The unique identifier for the package.
     * @param description A brief description of the package.
     * @param status The initial status of the package.
     */
    public Package(String packageId, String description, String status) {
        this.packageId = packageId;
        this.description = description;
        this.status = status;
    }

    // Getters
    public String getPackageId() {
        return packageId;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // Setter for status (as it changes during processing)
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the package.
     * @return A formatted string with package details.
     */
    @Override
    public String toString() {
        return "Package [ID=" + packageId + ", Description='" + description + "', Status=" + status + "]";
    }
}

/**
 * Simulates a package processing center managing packages in a queue and a processed list.
 */
public class PackageProcessor {

    private Queue<Package> processingQueue;
    private List<Package> processedPackages;
    private Scanner scanner;

    /**
     * Constructs a new PackageProcessor system.
     */
    public PackageProcessor() {
        // Use LinkedList as a Queue implementation
        this.processingQueue = new LinkedList<>();
        // Use ArrayList as a List implementation
        this.processedPackages = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Package Processing Center ---");
        System.out.println("1. Add New Package");
        System.out.println("2. Process Next Package");
        System.out.println("3. View Processing Queue");
        System.out.println("4. View Processed Packages");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new package to the processing queue based on user input.
     * Includes input validation.
     */
    private void addPackage() {
        System.out.println("\n--- Add New Package ---");
        System.out.print("Enter Package ID: ");
        String id = scanner.nextLine().trim(); // Use nextLine() for potential spaces, then trim
        System.out.print("Enter Description: ");
        String description = scanner.nextLine().trim();

        // Input validation
        if (id.isEmpty() || description.isEmpty()) {
            System.err.println("Error: Package ID and Description cannot be empty.");
            return; // Exit the method if validation fails
        }

        // Check for duplicate ID in pending queue (optional but good practice)
        // For simplicity, we won't add this check here to keep it within exam scope/time.
        // A more robust system might check both queues.

        Package newPackage = new Package(id, description, "Pending");
        processingQueue.offer(newPackage); // offer is generally preferred over add for queues
        System.out.println("Package '" + id + "' added to the processing queue.");
    }

    /**
     * Processes the next package from the queue.
     * Moves the processed package to the processed list.
     */
    private void processNextPackage() {
        System.out.println("\n--- Process Next Package ---");
        if (processingQueue.isEmpty()) {
            System.err.println("Error: Processing queue is empty. No packages to process.");
            return;
        }

        Package packageToProcess = processingQueue.poll(); // poll removes and returns the head
        if (packageToProcess != null) { // poll returns null if empty, but we checked isEmpty()
            packageToProcess.setStatus("Processed");
            processedPackages.add(packageToProcess);
            System.out.println("Package '" + packageToProcess.getPackageId() + "' processed and moved to processed list.");
        }
    }

    /**
     * Displays all packages currently in the processing queue.
     */
    private void viewProcessingQueue() {
        System.out.println("\n--- Processing Queue ---");
        if (processingQueue.isEmpty()) {
            System.out.println("The processing queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            processingQueue.forEach(System.out::println);
        }
    }

    /**
     * Displays all packages that have been processed.
     */
    private void viewProcessedPackages() {
        System.out.println("\n--- Processed Packages ---");
        if (processedPackages.isEmpty()) {
            System.out.println("The processed packages list is empty.");
        } else {
            // Iterate through the list
            processedPackages.forEach(System.out::println);
        }
    }

    /**
     * Runs the main application loop, handling user interaction.
     */
    public void run() {
        int choice = 0;
        // Use a try-with-resources block for the scanner for automatic closing
        try (Scanner scanner = new Scanner(System.in)) {
            this.scanner = scanner; // Assign the new scanner to the class field

            while (choice != 5) {
                displayMenu();
                try {
                    // Read the entire line first, then attempt to parse as int
                    String inputLine = scanner.nextLine();
                    choice = Integer.parseInt(inputLine);

                    // Use switch statement for menu navigation
                    switch (choice) {
                        case 1:
                            addPackage();
                            break;
                        case 2:
                            processNextPackage();
                            break;
                        case 3:
                            viewProcessingQueue();
                            break;
                        case 4:
                            viewProcessedPackages();
                            break;
                        case 5:
                            System.out.println("Exiting Package Processing Center. Goodbye!");
                            break;
                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (NumberFormatException e) {
                    // Handles cases where input is not a valid integer
                    System.err.println("Error: Invalid input. Please enter a number.");
                    choice = 0; // Reset choice to stay in loop
                } catch (Exception e) {
                    // Catch any other unexpected exceptions during operation execution
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    // e.printStackTrace(); // Uncomment for detailed debugging
                    choice = 0; // Reset choice to stay in loop
                }
            }
        } finally {
             // The try-with-resources handles closing the scanner automatically.
             // If not using try-with-resources, scanner.close() would go here.
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        PackageProcessor processor = new PackageProcessor();
        processor.run();
    }
}
