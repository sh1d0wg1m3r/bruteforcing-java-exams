/*
 * Exam Question #816
 * Generated on: 2025-05-12 16:45:22
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Exam Question: Software Build Management System**
 * 
 * You are tasked with developing a simplified software build management system for a development team. This system should allow users to submit build requests for different projects and versions, manage a queue of pending builds that are processed in a First-In, First-Out (FIFO) manner, and maintain a comprehensive history of all submitted requests.
 * 
 * Your solution must be a command-line application implemented in Java.
 * 
 * **Requirements:**
 * 
 * 1.  **`BuildRequest` Class:** Create a class named `BuildRequest` to represent a single build request. It should have private fields for `projectName` (String) and `version` (String). Implement a constructor to initialize these fields and public getter methods. Include appropriate input validation in the constructor (e.g., project name and version should not be null or empty strings) and throw an `IllegalArgumentException` if validation fails. Override the `toString()` method for easy printing. Ensure proper encapsulation.
 * 
 * 2.  **`BuildManager` Class:** Create a class named `BuildManager` responsible for managing the build requests.
 *     *   It must use a `java.util.Queue<BuildRequest>` to store pending build requests. Use a suitable implementation like `java.util.LinkedList`.
 *     *   It must use a `java.util.List<BuildRequest>` (specifically an `java.util.ArrayList`) to store a history of *all* submitted build requests.
 *     *   Implement a public method `submitBuildRequest(String projectName, String version)` that creates a `BuildRequest` object (handling potential `IllegalArgumentException` from the constructor), adds it to both the history `List` and the pending `Queue`, and prints a confirmation message to `System.out`.
 *     *   Implement a public method `processNextBuild()` that retrieves and removes the oldest `BuildRequest` from the pending `Queue`. If the queue is empty, it should throw an `IllegalStateException`. If successful, it should print a message indicating which request was processed to `System.out`.
 *     *   Implement public methods `getPendingBuilds()` and `getAllSubmittedBuilds()`. Both methods should return a `java.util.List<BuildRequest>` representing the current pending queue and the complete history, respectively. Return a copy of the internal collection to maintain encapsulation (e.g., `return new ArrayList<>(internalCollection);`).
 * 
 * 3.  **Main Application Class (`BuildSystem`):** Create a class named `BuildSystem` with a `main` method that serves as the application's entry point.
 *     *   Instantiate `BuildManager` and `java.util.Scanner` to read user input from `System.in`.
 *     *   Implement a main application loop that repeatedly:
 *         *   Displays a menu of options to the user using `System.out`:
 *             *   1. Submit new build request
 *             *   2. Process next build
 *             *   3. View pending builds
 *             *   4. View all submitted builds
 *             *   0. Exit
 *         *   Reads the user's choice using `Scanner`. Handle cases where the input is not an integer.
 *         *   Uses a `switch` statement to execute the chosen action by calling the appropriate `BuildManager` method(s).
 *     *   **Class-wide Exception Handling:** Wrap the core logic within the main application loop (reading input, switch statement, calling manager methods) inside a `try-catch` block. This block should catch `InputMismatchException` (for non-integer input), `IllegalArgumentException` (from `BuildRequest` or `BuildManager`), `IllegalStateException` (from `BuildManager`), and a general `Exception` for unexpected errors. All caught exceptions should print an informative error message to `System.err`.
 *     *   For invalid menu choices (valid integer but not 0-4), print an error message to `System.err`.
 *     *   For viewing empty lists/queue, print an informative message to `System.out`.
 *     *   Ensure the `Scanner` resource is closed when the application exits.
 * 
 * 4.  **Best Practices:** Adhere to best practices, including meaningful variable and method names, appropriate comments (including Javadoc for public elements), and clean code structure.
 * 
 * **Expected Output:**
 * 
 * *   Successful operations (submission, processing, viewing non-empty lists/queue, exit message) should be printed to `System.out`.
 * *   Error messages (invalid input type, invalid request details, processing empty queue, invalid menu option) should be printed to `System.err`.
 * *   Listing pending builds should show them in the order they were submitted.
 * *   Listing all submitted builds should show them in the order they were submitted.
 * 
 * Demonstrate your understanding of collections, interfaces, exception handling, input/output streams, and basic application structure in Java.
 *
 * EXPLANATION:
 * This solution implements a simplified Build Management System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Structure:** The code is organized into three classes:
 *     *   `BuildRequest`: An object representing the data for a single build request, demonstrating encapsulation with private fields and public getters. Input validation is performed in the constructor using an `IllegalArgumentException`.
 *     *   `BuildManager`: Manages the collections (`Queue` and `List`) and the core logic for submitting and processing builds. It holds the state of the system.
 *     *   `BuildSystem`: Contains the `main` method, handles user interaction via `Scanner`, controls the application flow with a `switch` statement, and implements the central exception handling using a `try-catch` block around the main loop.
 * 
 * 2.  **Required Components Usage:**
 *     *   **`Queue`**: The `BuildManager` uses `private Queue<BuildRequest> pendingBuilds = new LinkedList<>();`. `LinkedList` is chosen because it efficiently implements the `Queue` interface, providing fast additions to the tail (`offer()`) and removals from the head (`poll()`), suitable for a FIFO build queue.
 *     *   **`ArrayList`**: The `BuildManager` uses `private List<BuildRequest> submittedHistory = new ArrayList<>();`. `ArrayList` is used for the history because it provides efficient storage and retrieval by index, which is often useful for viewing or accessing historical data.
 *     *   **`List` interface**: The `java.util.List` interface is used as the return type for `BuildManager.getPendingBuilds()` and `BuildManager.getAllSubmittedBuilds()`. This promotes good design by programming to an interface rather than a concrete implementation. The `BuildSystem` class also uses the `List` interface when receiving the data returned by these methods (`List<BuildRequest> pending = buildManager.getPendingBuilds();`). This demonstrates using the interface in the client code.
 *     *   **`Scanner`**: The `BuildSystem` class uses `java.util.Scanner` (`private Scanner scanner = new Scanner(System.in);`) to read user input from the console for menu choices and build request details (`hasNextInt()`, `nextInt()`, `nextLine()`). It also includes logic to consume the newline character left by `nextInt()`.
 *     *   **`Switch` statement**: The `BuildSystem.run()` method uses a `switch (choice)` statement to direct the program flow based on the user's menu selection, calling the appropriate private helper methods.
 *     *   **`System.err`**: `System.err.println()` is used in the `catch` blocks within the `BuildSystem.run()` method and in the `default` case of the `switch` statement to output error messages, separating them from normal application output.
 *     *   **`System.out`**: `System.out.println()` and `System.out.print()` are used throughout the `BuildSystem` and `BuildManager` classes for displaying the menu, prompting for input, confirming successful operations (submission, processing), and listing the contents of the pending queue and history list.
 *     *   **Class-wide `try-catch`**: The main `while` loop in `BuildSystem.run()` is wrapped in a comprehensive `try-catch` block. This demonstrates centralizing error handling for the interactive part of the application. It catches specific exceptions like `InputMismatchException` (for invalid input type), `IllegalArgumentException` (for validation errors in `BuildRequest` or `BuildManager`), and `IllegalStateException` (for operational errors like processing an empty queue), as well as a general `Exception` to catch any other unexpected runtime issues. Error messages are printed to `System.err`.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `BuildRequest` and `BuildManager` are private. Access is controlled via public methods. Importantly, `getPendingBuilds()` and `getAllSubmittedBuilds()` return *copies* (`new ArrayList<>(...)`) of the internal collections. This prevents external code from modifying the internal state of the `BuildManager` directly, upholding encapsulation.
 *     *   **Meaningful Names:** Class names, variable names (`pendingBuilds`, `submittedHistory`, `projectName`, `choice`), and method names (`submitBuildRequest`, `processNextBuild`, `viewPendingBuilds`) are descriptive.
 *     *   **Comments and Documentation:** Javadoc comments are provided for public classes, constructors, and methods, explaining their purpose, parameters, return values, and exceptions. Inline comments clarify specific logic points (like consuming the newline after `nextInt()`).
 *     *   **Input Validation:** Basic validation for non-empty strings is performed in the `BuildRequest` constructor. The `BuildSystem` explicitly checks for non-integer input using `scanner.hasNextInt()` before attempting to read an integer, preventing `InputMismatchException` from crashing the loop abruptly and allowing for a clean error message.
 *     *   **Error Handling:** Specific exceptions are used (`IllegalArgumentException`, `IllegalStateException`, `InputMismatchException`) to signal different types of errors. These are caught in the `BuildSystem`'s main `try-catch` block, providing user-friendly error messages via `System.err`. A general `Exception` catch is included as a fallback for unexpected issues, printing the stack trace for debugging.
 *     *   **Clean Code Structure:** The code is divided into logical units (classes) with clear responsibilities. Methods are relatively focused.
 * 
 * This solution effectively integrates the required components into a functional, well-structured, and robust command-line application, suitable for demonstrating advanced Java understanding.
 */

// BuildRequest.java
package com.example.buildsystem;

import java.util.Objects; // Good practice for equals/hashCode, though not strictly required by prompt

/**
 * Represents a single build request with project name and version.
 */
public class BuildRequest {
    private String projectName;
    private String version;

    /**
     * Constructs a new BuildRequest.
     * @param projectName The name of the project.
     * @param version The version of the build.
     * @throws IllegalArgumentException if project name or version is null or empty.
     */
    public BuildRequest(String projectName, String version) {
        // Input validation
        if (projectName == null || projectName.trim().isEmpty()) {
            throw new IllegalArgumentException("Project name cannot be null or empty.");
        }
        if (version == null || version.trim().isEmpty()) {
            throw new IllegalArgumentException("Version cannot be null or empty.");
        }
        this.projectName = projectName.trim();
        this.version = version.trim();
    }

    /**
     * Gets the project name.
     * @return The project name.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Gets the version.
     * @return The version.
     */
    public String getVersion() {
        return version;
    }

    /**
     * Returns a string representation of the build request.
     * @return A formatted string representing the build request.
     */
    @Override
    public String toString() {
        return "BuildRequest [Project='" + projectName + "', Version='" + version + "']";
    }

    // Optional: Add equals and hashCode based on projectName and version for better object handling
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuildRequest that = (BuildRequest) o;
        return Objects.equals(projectName, that.projectName) &&
               Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, version);
    }
}
```
```java
// BuildManager.java
package com.example.buildsystem;

import java.util.ArrayList;
import java.util.LinkedList; // A common implementation of Queue
import java.util.List;
import java.util.Queue; // The interface

/**
 * Manages build requests, maintaining a queue of pending builds and a history of all submissions.
 */
public class BuildManager {
    // Use Queue interface, implemented by LinkedList for FIFO behavior
    private Queue<BuildRequest> pendingBuilds;
    // Use List interface, implemented by ArrayList for dynamic array behavior (history)
    private List<BuildRequest> submittedHistory;

    /**
     * Constructs a new BuildManager, initializing the queue and history list.
     */
    public BuildManager() {
        this.pendingBuilds = new LinkedList<>();
        this.submittedHistory = new ArrayList<>();
    }

    /**
     * Submits a new build request. Adds it to both the history and the pending queue.
     * Input validation for project name and version is done in the BuildRequest constructor.
     * @param projectName The name of the project.
     * @param version The version of the build.
     * @throws IllegalArgumentException if project name or version is invalid (propagated from BuildRequest).
     */
    public void submitBuildRequest(String projectName, String version) {
        // BuildRequest constructor validates input and throws IllegalArgumentException if needed
        BuildRequest request = new BuildRequest(projectName, version);
        pendingBuilds.offer(request); // offer() adds to the end of the queue. Returns true/false.
        submittedHistory.add(request); // add() adds to the end of the history list.
        System.out.println("Successfully submitted build request: " + request); // Use System.out for confirmation
    }

    /**
     * Processes the next build request from the pending queue.
     * Removes the request from the head of the queue.
     * @return The BuildRequest that was processed.
     * @throws IllegalStateException if the pending build queue is empty.
     */
    public BuildRequest processNextBuild() {
        BuildRequest nextRequest = pendingBuilds.poll(); // poll() retrieves and removes the head, returns null if queue is empty
        if (nextRequest == null) {
            // Throw an exception if there's nothing to process
            throw new IllegalStateException("No pending build requests to process.");
        }
        System.out.println("Processing build request: " + nextRequest); // Use System.out for processing message
        // In a real application, actual build logic would be invoked here.
        return nextRequest;
    }

    /**
     * Gets a list of all currently pending build requests.
     * Returns a copy to prevent external modification of the internal queue.
     * @return A List of pending BuildRequest objects.
     */
    public List<BuildRequest> getPendingBuilds() {
        // Return a new ArrayList containing elements from the queue.
        // This uses the List interface as the return type, fulfilling a requirement.
        return new ArrayList<>(pendingBuilds);
    }

    /**
     * Gets a list of all build requests ever submitted.
     * Returns a copy to prevent external modification of the internal history list.
     * @return A List of all submitted BuildRequest objects.
     */
    public List<BuildRequest> getAllSubmittedBuilds() {
        // Return a new ArrayList containing elements from the history list.
        // This uses the List interface as the return type, fulfilling a requirement.
        return new ArrayList<>(submittedHistory);
    }
}
```
```java
// BuildSystem.java
package com.example.buildsystem;

import java.util.InputMismatchException;
import java.util.List; // Use List interface for type hinting when receiving lists
import java.util.Scanner; // For user input

/**
 * Main application class for the Build Management System.
 * Handles user interaction and orchestrates operations via BuildManager.
 * Demonstrates use of Scanner, switch, System.out, System.err, and try-catch.
 */
public class BuildSystem {

    private BuildManager buildManager;
    private Scanner scanner;

    /**
     * Constructs a new BuildSystem, initializing the BuildManager and Scanner.
     */
    public BuildSystem() {
        this.buildManager = new BuildManager();
        // Scanner reads from standard input
        this.scanner = new Scanner(System.in);
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        BuildSystem system = new BuildSystem();
        system.run();
    }

    /**
     * Runs the main application loop, displaying menus and processing user input.
     * Includes class-wide exception handling using try-catch blocks.
     */
    public void run() {
        System.out.println("--- Build Management System ---");
        int choice = -1; // Initialize choice to a non-exit value

        // Main application loop with class-wide try-catch block
        // This try-catch handles various exceptions that might occur during the interaction loop
        while (choice != 0) {
            try {
                displayMenu();
                System.out.print("Enter your choice: ");

                // Validate if the next input is an integer before reading it
                if (!scanner.hasNextInt()) {
                    String invalidInput = scanner.next(); // Consume the non-integer input
                    // Throw InputMismatchException for non-integer input, caught below
                    throw new InputMismatchException("Invalid input: '" + invalidInput + "'. Please enter a number.");
                }

                choice = scanner.nextInt(); // Read the integer choice
                scanner.nextLine(); // Consume the newline character left by nextInt() to prevent issues with next nextLine()

                // Use switch statement for menu navigation based on user choice
                switch (choice) {
                    case 1:
                        submitBuildRequest(); // Handles submitting a new request
                        break;
                    case 2:
                        processNextBuild(); // Handles processing the next request from the queue
                        break;
                    case 3:
                        viewPendingBuilds(); // Handles viewing the pending queue
                        break;
                    case 4:
                        viewAllSubmittedBuilds(); // Handles viewing the history list
                        break;
                    case 0:
                        System.out.println("Exiting Build Management System. Goodbye!"); // Use System.out for exit message
                        break;
                    default:
                        // Handle invalid integer choices using System.err
                        System.err.println("Invalid choice. Please enter a number between 0 and 4.");
                        break;
                }
            } catch (InputMismatchException e) {
                // Catch specific exception for invalid input type (e.g., non-integer where integer is expected)
                System.err.println("Input Error: " + e.getMessage()); // Use System.err for error messages
                // The invalid input was already consumed by scanner.next(), so no need for scanner.nextLine() here again
            } catch (IllegalArgumentException e) {
                // Catch specific exception for invalid request details (e.g., empty strings for project/version)
                System.err.println("Submission Error: " + e.getMessage()); // Use System.err for error messages
            } catch (IllegalStateException e) {
                // Catch specific exception for invalid operations (e.g., trying to process a build when the queue is empty)
                System.err.println("Operation Error: " + e.getMessage()); // Use System.err for error messages
            } catch (Exception e) {
                // Catch any other unexpected exceptions that might occur
                System.err.println("An unexpected system error occurred: " + e.getMessage()); // Use System.err for error messages
                e.printStackTrace(System.err); // Print stack trace to System.err for debugging unexpected errors
            }
            System.out.println(); // Print a newline for better separation between menu interactions
        }

        scanner.close(); // Close the scanner resource when the application exits to prevent resource leaks
    }

    /**
     * Displays the main menu options to the user using System.out.
     */
    private void displayMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Submit new build request");
        System.out.println("2. Process next build");
        System.out.println("3. View pending builds");
        System.out.println("4. View all submitted builds");
        System.out.println("0. Exit");
    }

    /**
     * Prompts the user for build request details using Scanner and submits it via BuildManager.
     * Potential IllegalArgumentException thrown by BuildManager/BuildRequest is handled by the try-catch in run().
     */
    private void submitBuildRequest() {
        System.out.print("Enter project name: ");
        String projectName = scanner.nextLine();
        System.out.print("Enter version: ");
        String version = scanner.nextLine();

        // Call BuildManager method. Validation is done inside BuildManager/BuildRequest,
        // and exceptions thrown are caught in the run() method's try-catch block.
        buildManager.submitBuildRequest(projectName, version);
    }

    /**
     * Calls BuildManager to process the next build request.
     * Potential IllegalStateException thrown by BuildManager is handled by the try-catch in run().
     */
    private void processNextBuild() {
        // Call BuildManager method. Potential IllegalStateException is caught in the run() method's try-catch.
        buildManager.processNextBuild();
    }

    /**
     * Retrieves and displays the list of pending build requests using System.out.
     * Uses the List interface to receive the data from BuildManager.
     */
    private void viewPendingBuilds() {
        // Get the list of pending builds using the List interface as the type
        List<BuildRequest> pending = buildManager.getPendingBuilds();
        if (pending.isEmpty()) {
            System.out.println("No pending build requests."); // Use System.out
        } else {
            System.out.println("--- Pending Build Requests ---"); // Use System.out
            // Iterate and print using List methods (size(), get()).
            // This list is an ArrayList copy of the queue's contents.
            for (int i = 0; i < pending.size(); i++) {
                System.out.println((i + 1) + ". " + pending.get(i)); // Use System.out
            }
            System.out.println("----------------------------"); // Use System.out
        }
    }

    /**
     * Retrieves and displays the history of all submitted build requests using System.out.
     * Uses the List interface to receive the data from BuildManager.
     */
    private void viewAllSubmittedBuilds() {
        // Get the list of all submitted builds using the List interface as the type
        List<BuildRequest> history = buildManager.getAllSubmittedBuilds();
        if (history.isEmpty()) {
            System.out.println("No build requests have been submitted yet."); // Use System.out
        } else {
            System.out.println("--- All Submitted Build Requests ---"); // Use System.out
            // Iterate and print using List methods (size(), get()).
            // This list is an ArrayList copy of the history list.
            for (int i = 0; i < history.size(); i++) {
                System.out.println((i + 1) + ". " + history.get(i)); // Use System.out
            }
            System.out.println("----------------------------------"); // Use System.out
        }
    }
}
