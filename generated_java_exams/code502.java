/*
 * Exam Question #502
 * Generated on: 2025-05-11 23:20:54
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Clinic Management System
 * 
 * **Objective:** Design and implement a simple command-line application to simulate the patient flow in a hospital clinic's waiting room. The system should manage patients waiting to be seen and keep a record of patients who have completed their appointment.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to represent the waiting list of patients. Patients should be processed in a First-In, First-Out (FIFO) manner.
 *     *   Use a `java.util.List` (specifically, a `java.util.ArrayList`) to store the history of patients who have already been seen.
 * 
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user commands and patient details from the console.
 *     *   Implement a command-line interface with the following commands:
 *         *   `add`: Add a new patient to the waiting queue. The system should prompt for the patient's name and a numeric patient ID.
 *         *   `call`: Call the next patient from the front of the waiting queue. This patient is removed from the queue and added to the list of seen patients.
 *         *   `wait`: Display the current list of patients in the waiting queue.
 *         *   `seen`: Display the list of patients who have already been seen.
 *         *   `exit`: Terminate the application.
 * 
 * 3.  **Flow Control:**
 *     *   Use a `switch` statement to process the different user commands.
 * 
 * 4.  **Output:**
 *     *   Use `System.out` for displaying the menu, prompts, successful operation messages, and the contents of the waiting and seen lists.
 *     *   Use `System.err` to display error messages (e.g., invalid command, invalid input format for patient ID, attempting to call a patient when the waiting queue is empty).
 * 
 * 5.  **Error Handling:**
 *     *   Implement robust error handling using `try-catch` blocks.
 *     *   Include "class-wide exception handling" within the main application logic (e.g., wrapping the command processing loop).
 *     *   Handle potential `NumberFormatException` if the user enters non-numeric input for the patient ID.
 *     *   Define and use a custom exception class, `EmptyQueueException`, which should be thrown by the operation that calls the next patient if the queue is empty. Catch this exception and print an informative error message to `System.err`.
 *     *   Handle invalid command inputs.
 * 
 * 6.  **Best Practices:**
 *     *   Design a `Patient` class with private fields (`name`, `patientId`) and public getter methods (encapsulation). Include a `toString()` method for easy printing.
 *     *   Design a separate class (e.g., `ClinicManagement`) to encapsulate the logic for managing the queue and the seen patients list. This class should contain the `Queue` and `List` instances and methods for adding, calling, and retrieving lists.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and Javadoc documentation for classes and public methods.
 *     *   Perform basic input validation (e.g., in the `Patient` constructor or when adding).
 *     *   Ensure the `Scanner` resource is closed upon exiting.
 * 
 * **Expected Output Structure:**
 * 
 * ```
 * Welcome message
 * Menu displayed
 * Prompt for command
 * ... user interaction ...
 * Menu displayed (after each successful or failed operation)
 * ...
 * Error messages go to System.err
 * Normal output goes to System.out
 * ...
 * Exit message
 * ```
 * 
 * Your solution should consist of the Java code for all necessary classes (`Patient`, `ClinicManagement`, `EmptyQueueException`, and the main class with the `main` method) and a brief explanation of the design and how the requirements are met.
 * 
 * **Evaluation Criteria:** Correctness of implementation, adherence to all specified requirements (use of Queue, List, Scanner, switch, System.err, System.out, try-catch, custom exception), proper error handling, code structure and best practices (encapsulation, naming, comments, validation), and clarity of the explanation.
 *
 * EXPLANATION:
 * The provided solution implements a simple Hospital Clinic Management System command-line application, fulfilling all the specified requirements.
 * 
 * 1.  **Data Structures:**
 *     *   A `java.util.Queue<Patient>` named `waitingQueue` is used within the `ClinicManagement` class, implemented specifically using `java.util.LinkedList`. `LinkedList` is a common implementation of the `Queue` interface suitable for this scenario as it efficiently supports adding to the end (`offer`) and removing from the beginning (`poll`), maintaining the FIFO order required for a waiting queue.
 *     *   A `java.util.List<Patient>` named `seenPatients` is used, implemented as a `java.util.ArrayList`. `ArrayList` is suitable for storing the history of seen patients as it provides dynamic resizing and efficient access/iteration, which is sufficient for displaying the list. The `List` interface is used for the variable declaration and method return types (`getWaitingList`, `getSeenPatients`) to promote flexibility and adherence to best practices.
 * 
 * 2.  **User Interaction:**
 *     *   A `java.util.Scanner` object is created in the `main` method of `HospitalSystem` to read user input from `System.in`.
 *     *   The `main` method contains a `while(true)` loop that continuously prompts the user for commands until the 'exit' command is entered.
 *     *   Commands are read using `scanner.nextLine()`, trimmed, and converted to lower case for case-insensitive input handling.
 * 
 * 3.  **Flow Control:**
 *     *   A `switch` statement is used inside the main loop to direct execution based on the user's command string (`"add"`, `"call"`, `"wait"`, `"seen"`, `"exit"`). A `default` case handles invalid commands.
 * 
 * 4.  **Output:**
 *     *   `System.out.println()` and `System.out.print()` are used for displaying the menu, prompts, success messages (e.g., "Patient added."), and listing the contents of the waiting queue and seen patients list.
 *     *   `System.err.println()` is exclusively used for displaying error messages, directing them to the standard error stream as required.
 * 
 * 5.  **Error Handling:**
 *     *   **`try-catch` Blocks:** `try-catch` blocks are used at multiple levels.
 *         *   The main `while` loop in `HospitalSystem.main` is wrapped in a `try-catch (Exception e)` block. This serves as the "class-wide exception handling" for the primary operational part of the `HospitalSystem` class, catching any unexpected exceptions that might propagate up during command processing.
 *         *   Within the `add` case, a specific `try-catch (NumberFormatException e)` is used around `Integer.parseInt(scanner.nextLine())` to catch errors when the user inputs non-numeric text for the patient ID, providing a user-friendly error message to `System.err`. An `IllegalArgumentException` is also caught in the 'add' case, which is thrown by the `Patient` constructor if the name is empty or ID is non-positive.
 *         *   Within the `call` case, a specific `try-catch (EmptyQueueException e)` is used to handle the situation where `clinic.callNextPatient()` is called when the queue is empty.
 *     *   **Custom Exception (`EmptyQueueException`):** A custom exception class `EmptyQueueException` is defined, extending `java.lang.Exception`. The `ClinicManagement.callNextPatient()` method explicitly checks if the queue is empty (`nextPatient == null` after `poll()`) and throws this custom exception when necessary.
 *     *   **Input Validation:** Basic validation is performed in the `Patient` constructor (name not empty, ID positive). The ID parsing in the `add` command handles the numeric format validation. Invalid commands are handled by the `default` case in the `switch`.
 * 
 * 6.  **Best Practices:**
 *     *   **Encapsulation:** The `Patient` class has private fields (`name`, `patientId`) and public getter methods. The `ClinicManagement` class encapsulates the `waitingQueue` and `seenPatients` collections, providing public methods (`addPatient`, `callNextPatient`, `getWaitingList`, `getSeenPatients`) to interact with the data structures, hiding the internal implementation details. The `getWaitingList` and `getSeenPatients` methods return copies (`new ArrayList<>(...)`) of the internal collections to prevent external code from directly modifying the state of the queue or list.
 *     *   **Meaningful Names:** Classes (`Patient`, `ClinicManagement`, `HospitalSystem`, `EmptyQueueException`), variables (`waitingQueue`, `seenPatients`, `command`, `name`, `patientId`), and methods (`addPatient`, `callNextPatient`, `getWaitingList`, `displayMenu`) have names that clearly indicate their purpose.
 *     *   **Comments and Documentation:** Javadoc comments are included for classes and public methods explaining their purpose, parameters, return values, and exceptions thrown. Inline comments are used where necessary for clarity.
 *     *   **Clean Code Structure:** The logic is separated into distinct classes (`Patient` for data, `ClinicManagement` for business logic, `HospitalSystem` for the user interface/application entry point), promoting modularity.
 *     *   **Resource Management:** The `Scanner` object is explicitly closed using `scanner.close()` before the application exits to release the underlying system resource.
 * 
 * The combination of these elements creates a robust, well-structured, and maintainable solution that effectively demonstrates advanced understanding of core Java concepts, data structures, error handling, and object-oriented principles within a practical scenario.
 */

// EmptyQueueException.java
/**
 * Custom exception thrown when attempting to perform an operation on an empty queue.
 */
public class EmptyQueueException extends Exception {
    /**
     * Constructs an EmptyQueueException with a default detail message.
     */
    public EmptyQueueException() {
        super("Operation failed: The queue is empty.");
    }

    /**
     * Constructs an EmptyQueueException with the specified detail message.
     * @param message The detail message.
     */
    public EmptyQueueException(String message) {
        super(message);
    }
}
```

```java
// Patient.java
/**
 * Represents a patient in the hospital clinic system.
 */
public class Patient {
    private String name;
    private int patientId;

    /**
     * Constructs a new Patient object.
     * @param name The name of the patient.
     * @param patientId The unique ID of the patient.
     * @throws IllegalArgumentException if patient name is empty or ID is non-positive.
     */
    public Patient(String name, int patientId) {
        // Basic validation
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        if (patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must be positive.");
        }
        this.name = name.trim();
        this.patientId = patientId;
    }

    /**
     * Gets the patient's name.
     * @return The patient's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the patient's ID.
     * @return The patient's ID.
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Returns a string representation of the Patient.
     * @return A string in the format "Name (ID: patientId)".
     */
    @Override
    public String toString() {
        return name + " (ID: " + patientId + ")";
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * Equality is based on the patient ID.
     * @param o The reference object with which to compare.
     * @return true if this object is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return patientId == patient.patientId;
    }

    /**
     * Returns a hash code value for the object.
     * The hash code is based on the patient ID.
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(patientId);
    }
}
```

```java
// ClinicManagement.java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Manages the patient flow in a hospital clinic, using a waiting queue
 * and a list of seen patients.
 * Adheres to encapsulation principles.
 */
public class ClinicManagement {
    // Use Queue interface, implement with LinkedList for FIFO
    private Queue<Patient> waitingQueue; // Patients waiting to be seen

    // Use List interface, implement with ArrayList for storing seen history
    private List<Patient> seenPatients;   // Patients who have been seen

    /**
     * Constructs a new ClinicManagement system.
     * Initializes the waiting queue and the seen patients list.
     */
    public ClinicManagement() {
        this.waitingQueue = new LinkedList<>(); // LinkedList implements Queue
        this.seenPatients = new ArrayList<>();  // ArrayList implements List
    }

    /**
     * Adds a new patient to the waiting queue.
     * Creates a Patient object and adds it to the end of the queue.
     * @param name The name of the patient.
     * @param patientId The ID of the patient.
     * @throws IllegalArgumentException if patient name is empty or ID is non-positive (delegated from Patient constructor).
     */
    public void addPatient(String name, int patientId) {
        // Patient constructor handles basic validation and can throw IllegalArgumentException
        Patient newPatient = new Patient(name, patientId);
        waitingQueue.offer(newPatient); // offer is preferred over add for queues, adds to the tail
    }

    /**
     * Calls the next patient from the front of the waiting queue.
     * The patient is removed from the waiting queue and added to the seen patients list.
     * @return The patient who was called.
     * @throws EmptyQueueException if the waiting queue is empty when attempting to call.
     */
    public Patient callNextPatient() throws EmptyQueueException {
        // poll() retrieves and removes the head of this queue, or returns null if this queue is empty.
        Patient nextPatient = waitingQueue.poll();

        if (nextPatient == null) {
            // Throw custom exception if the queue was empty
            throw new EmptyQueueException("Waiting queue is currently empty. Cannot call the next patient.");
        }

        // Add the called patient to the history list
        seenPatients.add(nextPatient);
        return nextPatient;
    }

    /**
     * Gets a list of patients currently in the waiting queue.
     * Returns a new ArrayList containing the elements from the queue
     * to provide a snapshot and prevent external modification of the internal queue state.
     * @return A List of waiting patients. Returns an empty list if the queue is empty.
     */
    public List<Patient> getWaitingList() {
        // Return a copy to maintain encapsulation
        return new ArrayList<>(waitingQueue);
    }

    /**
     * Gets a list of patients who have already been seen.
     * Returns a new ArrayList containing the elements from the seen list
     * to provide a snapshot and prevent external modification of the internal list state.
     * @return A List of seen patients. Returns an empty list if no patients have been seen.
     */
    public List<Patient> getSeenPatients() {
        // Return a copy to maintain encapsulation
        return new ArrayList<>(seenPatients);
    }
}
```

```java
// HospitalSystem.java
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Main application class for the Hospital Clinic Management System.
 * Handles user interaction via the console, processes commands, and manages exceptions.
 */
public class HospitalSystem {

    /**
     * Displays the available commands menu to the user.
     * Output is directed to System.out.
     */
    private static void displayMenu() {
        System.out.println("\n--- Hospital Clinic System Menu ---");
        System.out.println("add  : Add a new patient to the waiting queue");
        System.out.println("call : Call the next patient from the queue");
        System.out.println("wait : Display the current waiting queue");
        System.out.println("seen : Display the list of patients already seen");
        System.out.println("exit : Exit the application");
        System.out.println("-----------------------------------");
    }

    /**
     * Main method to run the Hospital Clinic Management System.
     * Initializes the system, handles the user input loop, and processes commands.
     * Includes class-wide exception handling for the main operational loop.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ClinicManagement clinic = new ClinicManagement();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Hospital Clinic Management System!");

        // Main application loop for user interaction and command processing
        // Includes class-wide try-catch block to handle potential exceptions
        while (true) {
            displayMenu();
            System.out.print("Enter command: ");
            String command = scanner.nextLine().trim().toLowerCase(); // Read entire line, trim whitespace, convert to lower case

            try {
                // Use switch statement for command-based flow control
                switch (command) {
                    case "add":
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine(); // Read patient name
                        System.out.print("Enter patient ID (number): ");
                        try {
                            int id = Integer.parseInt(scanner.nextLine()); // Read ID as line, then parse to int
                            clinic.addPatient(name, id); // Add patient via ClinicManagement
                            System.out.println("Success: Patient '" + name + "' (ID: " + id + ") added to waiting queue.");
                        } catch (NumberFormatException e) {
                            // Handle specific error if ID is not a valid number
                            System.err.println("Error: Invalid input for Patient ID. Please enter a valid number.");
                        } catch (IllegalArgumentException e) {
                            // Handle specific error if Patient constructor validation fails (e.g., empty name, non-positive ID)
                             System.err.println("Error: Invalid patient data. " + e.getMessage());
                        }
                        break; // End of 'add' case

                    case "call":
                        try {
                            // Attempt to call the next patient
                            Patient calledPatient = clinic.callNextPatient();
                            System.out.println("Success: Called next patient: " + calledPatient);
                        } catch (EmptyQueueException e) {
                            // Handle specific custom exception if queue is empty
                            System.err.println("Error: " + e.getMessage());
                        }
                        break; // End of 'call' case

                    case "wait":
                        // Get and display the waiting list
                        List<Patient> waitingList = clinic.getWaitingList();
                        System.out.println("\n--- Current Waiting Queue ---");
                        if (waitingList.isEmpty()) {
                            System.out.println("The waiting queue is currently empty.");
                        } else {
                            // Iterate and print each patient in the waiting list using System.out
                            waitingList.forEach(System.out::println);
                        }
                        System.out.println("-----------------------------\n");
                        break; // End of 'wait' case

                    case "seen":
                        // Get and display the seen patients list
                        List<Patient> seenList = clinic.getSeenPatients();
                        System.out.println("\n--- Patients Already Seen ---");
                        if (seenList.isEmpty()) {
                            System.out.println("No patients have been seen yet.");
                        } else {
                             // Iterate and print each patient in the seen list using System.out
                            seenList.forEach(System.out::println);
                        }
                        System.out.println("-----------------------------\n");
                        break; // End of 'seen' case

                    case "exit":
                        // Exit the application
                        System.out.println("Exiting Hospital Clinic Management System. Goodbye!");
                        scanner.close(); // Close the scanner resource to prevent resource leaks
                        return; // Terminate the main method and thus the application

                    default:
                        // Handle unknown or invalid commands
                        System.err.println("Error: Unknown command '" + command + "'. Please use add, call, wait, seen, or exit.");
                        break; // Continue the loop to prompt for the next command
                }
            } catch (Exception e) {
                // Generic catch block for any other unexpected exceptions during command processing.
                // This provides class-wide handling for the main loop's operations.
                System.err.println("An unexpected error occurred during command execution: " + e.getMessage());
                // e.printStackTrace(); // Uncomment this line during development for debugging detailed stack traces
            }
        }
    }
}
