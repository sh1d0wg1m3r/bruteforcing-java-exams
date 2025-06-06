/*
 * Exam Question #813
 * Generated on: 2025-05-12 16:44:56
 * Generated by: Account 1
 * 
 * QUESTION:
 * **Java Programming Exam Task: Clinic Patient Management System**
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple command-line application for managing patients in a small clinic. The system needs to keep track of all registered patients and manage a waiting queue for patients who are ready to be seen by a doctor.
 * 
 * Your solution must adhere to the following requirements:
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a list of *all registered patients*. This list should allow easy searching by patient ID.
 *     *   Maintain a *waiting queue* for patients who have arrived and are waiting to be seen. Patients should be seen in the order they arrive (First-In, First-Out).
 * 2.  **Functionality:** Implement the following commands via a command-line interface:
 *     *   **Register Patient (R):** Register a new patient with a unique ID (positive integer) and name (non-empty string).
 *     *   **Add to Queue (Q):** Add a *registered* patient to the waiting queue using their ID. A patient can only be in the queue once at any given time.
 *     *   **See Next Patient (S):** Remove and display the patient at the front of the waiting queue.
 *     *   **List All Registered (LA):** Display details of all registered patients.
 *     *   **List Waiting (LW):** Display details of all patients currently in the waiting queue.
 *     *   **Exit (E):** Terminate the application.
 * 3.  **Implementation Details:**
 *     *   You *must* use `java.util.Queue` for the waiting list (e.g., implemented by `LinkedList`).
 *     *   You *must* use `java.util.ArrayList` as the underlying implementation for storing all registered patients.
 *     *   You *must* declare the collection for registered patients using the `java.util.List` interface (`List<Patient>`).
 *     *   User input *must* be handled using `java.util.Scanner`.
 *     *   The main command processing logic *must* use a `switch` statement.
 *     *   Normal program output (menus, success messages, lists) *must* go to `System.out`.
 *     *   Error messages (invalid input format, patient not found, queue empty, duplicate ID, etc.) *must* go to `System.err`.
 *     *   Implement class-wide exception handling using a `try-catch` block in the main application loop to catch any unexpected runtime errors.
 * 4.  **Best Practices:**
 *     *   Design appropriate classes (`Patient`, `Clinic`, etc.) with proper encapsulation (private fields, public methods).
 *     *   Use meaningful names for variables, methods, and classes.
 *     *   Include comments and basic JavaDocs to explain your code.
 *     *   Implement input validation (e.g., positive integer IDs, non-empty names, correct command format).
 *     *   Handle specific error conditions gracefully (e.g., attempting to queue a non-existent patient, seeing next when queue is empty).
 *     *   Ensure resources like `Scanner` are properly closed (e.g., using try-with-resources).
 * 
 * **Expected Output Structure:**
 * 
 * The application should present a menu and prompt the user for commands. Output for successful operations and lists should go to standard output, while errors should be printed to standard error.
 * 
 * Example interaction:
 * ```
 * --- Clinic Management System ---
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > R
 * Enter Patient ID (positive integer): 101
 * Enter Patient Name: Alice
 * Success: Patient registered successfully (ID: 101, Name: Alice).
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > R
 * Enter Patient ID (positive integer): 102
 * Enter Patient Name: Bob
 * Success: Patient registered successfully (ID: 102, Name: Bob).
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > R
 * Enter Patient ID (positive integer): 101
 * Enter Patient Name: Alice
 * Error: Patient with ID 101 already exists.
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > Q
 * Enter Patient ID to add to waiting queue (positive integer): 101
 * Success: Patient ID 101 added to waiting queue.
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > Q
 * Enter Patient ID to add to waiting queue (positive integer): 999
 * Error: Patient with ID 999 not found in registered patients.
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > LW
 * --- Waiting Queue (1) ---
 * 1. ID: 101, Name: Alice
 * ---------------------
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > S
 * Success: Now seeing patient: Alice (ID: 101).
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > S
 * Info: No patients in the waiting queue.
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > LA
 * --- All Registered Patients (2) ---
 * 1. ID: 101, Name: Alice
 * 2. ID: 102, Name: Bob
 * ------------------------------------
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > INVALID
 * Error: Invalid command 'INVALID'. Please try again.
 * 
 * Enter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):
 * > E
 * Exiting Clinic Management System. Goodbye!
 * Application terminated.
 * ```
 * 
 * You should provide the complete, runnable Java code for this system, including separate files if you use multiple classes (e.g., `Patient.java`, `Clinic.java`, `ClinicApp.java`). Assume they are in the same default package or a single package like `clinic`.
 *
 * EXPLANATION:
 * This solution provides a command-line application for managing clinic patients, demonstrating the required Java concepts.
 * 
 * 1.  **Class Structure:**
 *     *   `Patient` class: Represents a patient with private fields for `id`, `name`, and `isWaiting`. It includes a constructor with basic validation, public getters, a package-private setter for `isWaiting` (controlled by `Clinic`), and overridden `equals()` and `hashCode()` based on the unique ID for proper comparison and collection handling. `toString()` provides a useful representation.
 *     *   `Clinic` class: Manages the core data structures. It uses a `List<Patient>` (`ArrayList` implementation) called `registeredPatients` to store all patients, allowing iteration and searching. It uses a `Queue<Patient>` (`LinkedList` implementation) called `waitingQueue` to manage the FIFO waiting list. Methods like `registerPatient`, `addPatientToWaitingQueue`, and `seeNextPatient` encapsulate the logic for modifying these structures and patient states. Helper method `findPatientById` keeps the logic clean.
 *     *   `ClinicApp` class: Contains the `main` method, serving as the application's entry point and user interface handler. It initializes the `Clinic` and `Scanner`, runs the command loop, reads user input, and calls the appropriate methods in the `Clinic` class based on the command.
 * 
 * 2.  **Data Structures Usage:**
 *     *   `List<Patient> registeredPatients = new ArrayList<>();`: Demonstrates the use of the `List` interface with an `ArrayList` implementation for storing a dynamic collection of all patients. `ArrayList` is suitable here as it provides flexibility in size and allows iteration to find patients by ID.
 *     *   `Queue<Patient> waitingQueue = new LinkedList<>();`: Demonstrates the use of the `Queue` interface. `LinkedList` is a common and effective implementation for a queue, providing efficient addition (`offer`) to the tail and removal (`poll`) from the head, fulfilling the FIFO requirement for a waiting line.
 * 
 * 3.  **User Interaction and Control Flow:**
 *     *   `Scanner scanner = new Scanner(System.in);`: Handles reading input from the standard input stream. Reading full lines (`nextLine()`) is used to avoid issues with leftover newlines after reading numbers.
 *     *   `switch (command)`: Processes the user's input command string, directing execution to the corresponding block of code for each supported command ('R', 'Q', 'S', 'LA', 'LW', 'E'). The `default` case handles invalid commands.
 *     *   `while (true)`: Creates the main application loop that continues until the 'E' command is entered, which uses `return` to exit the `main` method.
 * 
 * 4.  **Error Handling and Output:**
 *     *   `System.out`: Used for standard program output, including the command menu, confirmation messages for successful operations, and the formatted lists of patients.
 *     *   `System.err`: Used exclusively for printing error messages, ensuring they are distinguishable from normal output. This includes messages for invalid command format, `NumberFormatException` during ID parsing, duplicate patient IDs, attempting operations on non-existent patients, and queue-specific errors (like trying to see a patient when the queue is empty).
 *     *   `try-catch` blocks:
 *         *   Specific `try-catch(NumberFormatException)` blocks are used within the 'R' and 'Q' command handling to catch errors if the user enters non-integer input when an ID is expected.
 *         *   A general `try-catch(Exception e)` block wraps the entire `while` loop in the `main` method. This fulfills the "class-wide exception handling" requirement by catching any other unexpected runtime exceptions that might occur during the execution of the application's core logic, printing an error message using `System.err`, and preventing the program from crashing completely.
 *     *   Input Validation: Checks are performed in `ClinicApp` (e.g., ID > 0, name not empty) and `Clinic` (e.g., duplicate ID, patient exists, patient already waiting) to validate user input and the state of the system before performing operations.
 * 
 * 5.  **Best Practices:**
 *     *   The code is structured into logical classes with clear responsibilities, adhering to object-oriented principles like encapsulation.
 *     *   Variable and method names are descriptive and follow Java conventions.
 *     *   Basic Javadoc and inline comments explain the purpose of code elements.
 *     *   Input validation and specific error messages provide helpful feedback to the user.
 *     *   Using `try-with-resources` for the `Scanner` ensures that the resource is properly closed when the program exits or an error occurs.
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) into a functional and well-structured application, demonstrating a solid understanding of core Java programming concepts and best practices suitable for an advanced exam task.
 */

// File: clinic/Patient.java
package clinic;

import java.util.Objects;

/**
 * Represents a patient in the clinic system.
 */
public class Patient {
    private int id;
    private String name;
    private boolean isWaiting; // True if currently in the waiting queue

    /**
     * Constructs a new Patient.
     * @param id The unique patient ID.
     * @param name The patient's name.
     * @throws IllegalArgumentException if id is not positive or name is empty.
     */
    public Patient(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("Patient ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
             throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        this.id = id;
        this.name = name.trim();
        this.isWaiting = false; // Initially not waiting
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isWaiting() {
        return isWaiting;
    }

    // Setter for waiting status (package-private access is sufficient as only Clinic modifies this)
    void setWaiting(boolean waiting) {
        isWaiting = waiting;
    }

    /**
     * Patients are equal if their IDs are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return id == patient.id;
    }

    /**
     * Hash code based on patient ID.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * String representation of the patient.
     */
    @Override
    public String toString() {
        return "Patient{" +
               "ID=" + id +
               ", Name='" + name + '\'' +
               ", Waiting=" + isWaiting +
               '}';
    }
}
```

```java
// File: clinic/Clinic.java
package clinic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Manages registered patients and the waiting queue.
 */
public class Clinic {
    // Use List interface, implemented by ArrayList for easy searching/storage
    private List<Patient> registeredPatients;

    // Use Queue interface, implemented by LinkedList for FIFO behavior
    private Queue<Patient> waitingQueue;

    /**
     * Constructs a new Clinic instance.
     */
    public Clinic() {
        this.registeredPatients = new ArrayList<>();
        this.waitingQueue = new LinkedList<>(); // LinkedList is a common Queue implementation
    }

    /**
     * Registers a new patient.
     * Checks if a patient with the same ID already exists.
     * Creates and adds the patient if validation passes.
     * Assumes basic ID > 0 and non-empty name validation is done by the caller or Patient constructor.
     * @param id The patient ID.
     * @param name The patient name.
     * @return true if registration was successful, false if ID already exists.
     */
    public boolean registerPatient(int id, String name) {
        // Check for duplicate ID first
        if (findPatientById(id) != null) {
            return false; // Patient with this ID already exists
        }

        // Create patient object - constructor handles basic validation (ID > 0, name not empty)
        Patient newPatient = new Patient(id, name); // Potential IllegalArgumentException handled by caller
        registeredPatients.add(newPatient);
        return true; // Registration successful
    }

    /**
     * Finds a patient by their ID in the registered patients list.
     * @param id The patient ID to search for.
     * @return The Patient object if found, null otherwise.
     */
    private Patient findPatientById(int id) {
        // Iterate through the list to find the patient by ID
        for (Patient patient : registeredPatients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null; // Patient not found
    }

    /**
     * Adds a registered patient to the waiting queue.
     * @param id The ID of the patient to add to the queue.
     * @return 1 if added successfully, 0 if patient not registered, -1 if already waiting.
     */
    public int addPatientToWaitingQueue(int id) {
        Patient patient = findPatientById(id);

        if (patient == null) {
            return 0; // Patient not registered
        }

        if (patient.isWaiting()) {
            return -1; // Patient is already in the waiting queue
        }

        // Add to queue and update patient's waiting status
        waitingQueue.offer(patient); // offer() is preferred over add() as it returns false on failure (though rare with LinkedList)
        patient.setWaiting(true); // Update the state of the patient object in the registered list and queue
        return 1; // Successfully added to queue
    }

    /**
     * Processes the next patient in the waiting queue (FIFO).
     * Removes the patient from the queue and updates their status.
     * @return The next Patient to be seen, or null if the queue is empty.
     */
    public Patient seeNextPatient() {
        Patient nextPatient = waitingQueue.poll(); // poll() retrieves and removes the head of the queue, returns null if empty

        if (nextPatient != null) {
            nextPatient.setWaiting(false); // Patient is no longer waiting
            // The Patient object removed from the queue is the same instance
            // as in the registeredPatients list, so updating its state is reflected everywhere.
        }
        return nextPatient;
    }

    /**
     * Lists all patients currently registered in the clinic.
     * Prints to System.out.
     */
    public void listAllRegisteredPatients() {
        if (registeredPatients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        System.out.println("\n--- All Registered Patients (" + registeredPatients.size() + ") ---");
        // Using classic for loop with index for numbered list
        for (int i = 0; i < registeredPatients.size(); i++) {
            Patient patient = registeredPatients.get(i);
            System.out.println((i + 1) + ". ID: " + patient.getId() + ", Name: " + patient.getName() + (patient.isWaiting() ? " (Waiting)" : ""));
        }
        System.out.println("------------------------------------");
    }

    /**
     * Lists all patients currently in the waiting queue.
     * Prints to System.out.
     */
    public void listWaitingPatients() {
         if (waitingQueue.isEmpty()) {
            System.out.println("The waiting queue is empty.");
            return;
        }
        System.out.println("\n--- Waiting Queue (" + waitingQueue.size() + ") ---");
        // Iterating through a Queue doesn't remove elements
        int i = 0;
        for (Patient patient : waitingQueue) {
            System.out.println((i + 1) + ". ID: " + patient.getId() + ", Name: " + patient.getName());
            i++;
        }
        System.out.println("---------------------");
    }
}
```

```java
// File: clinic/ClinicApp.java
package clinic;

import java.util.Scanner;
import java.lang.NumberFormatException; // Explicitly import if desired, though in java.lang

/**
 * Main application class for the Clinic Management System.
 * Handles user interaction via command line.
 */
public class ClinicApp {

    public static void main(String[] args) {
        // Using try-with-resources ensures the Scanner is closed automatically
        try (Scanner scanner = new Scanner(System.in)) {
            Clinic clinic = new Clinic();
            String command;

            System.out.println("--- Clinic Management System ---");

            // This try-catch block wraps the entire command processing loop,
            // providing class-wide exception handling for the main application logic.
            try {
                 while (true) {
                    // Display menu
                    System.out.println("\nEnter command (R: Register Patient, Q: Add to Queue, S: See Next Patient, LA: List All Registered, LW: List Waiting Queue, E: Exit):");
                    System.out.print("> "); // Prompt for input
                    command = scanner.nextLine().trim().toUpperCase(); // Read command, trim whitespace, convert to uppercase

                    // Use switch statement for command processing
                    switch (command) {
                        case "R": // Register Patient
                            System.out.print("Enter Patient ID (positive integer): ");
                            String idStrR = scanner.nextLine();
                            System.out.print("Enter Patient Name: ");
                            String nameR = scanner.nextLine();
                            try {
                                int idR = Integer.parseInt(idStrR);
                                // Input validation for ID and Name before calling Clinic method
                                if (idR <= 0) {
                                     System.err.println("Error: Patient ID must be a positive integer.");
                                     break; // Exit this switch case
                                }
                                if (nameR == null || nameR.trim().isEmpty()) {
                                     System.err.println("Error: Patient name cannot be empty.");
                                     break; // Exit this switch case
                                }
                                // Call clinic method - Patient constructor might throw IAE, but caught here by Exception
                                // Or handle IAE specifically if desired, but general Exception catch is sufficient per requirements.
                                if (clinic.registerPatient(idR, nameR)) {
                                    System.out.println("Success: Patient registered successfully (ID: " + idR + ", Name: " + nameR.trim() + ").");
                                } else {
                                    System.err.println("Error: Patient with ID " + idR + " already exists.");
                                }
                            } catch (NumberFormatException e) {
                                System.err.println("Error: Invalid ID format for registration. Please enter a valid integer.");
                            } catch (IllegalArgumentException e) {
                                // Catch validation errors from Patient constructor if any escape initial checks
                                System.err.println("Registration validation error: " + e.getMessage());
                            }
                            break;

                        case "Q": // Add to Waiting Queue
                            System.out.print("Enter Patient ID to add to waiting queue (positive integer): ");
                            String idStrQ = scanner.nextLine();
                            try {
                                int idQ = Integer.parseInt(idStrQ);
                                // Input validation for ID
                                 if (idQ <= 0) {
                                     System.err.println("Error: Patient ID must be a positive integer.");
                                     break; // Exit this switch case
                                }
                                int queueResult = clinic.addPatientToWaitingQueue(idQ);
                                if (queueResult == 1) {
                                    System.out.println("Success: Patient ID " + idQ + " added to waiting queue.");
                                } else if (queueResult == 0) {
                                     System.err.println("Error: Patient with ID " + idQ + " not found in registered patients.");
                                } else if (queueResult == -1) {
                                     System.err.println("Error: Patient with ID " + idQ + " is already in the waiting queue.");
                                }
                            } catch (NumberFormatException e) {
                                System.err.println("Error: Invalid ID format for queueing. Please enter a valid integer.");
                            }
                            break;

                        case "S": // See Next Patient
                            Patient nextPatient = clinic.seeNextPatient();
                            if (nextPatient != null) {
                                System.out.println("Success: Now seeing patient: " + nextPatient.getName() + " (ID: " + nextPatient.getId() + ").");
                            } else {
                                System.out.println("Info: No patients in the waiting queue.");
                            }
                            break;

                        case "LA": // List All Registered Patients
                            clinic.listAllRegisteredPatients();
                            break;

                        case "LW": // List Waiting Queue
                            clinic.listWaitingPatients();
                            break;

                        case "E": // Exit
                            System.out.println("Exiting Clinic Management System. Goodbye!");
                            return; // Exit the main method

                        default: // Invalid command
                            System.err.println("Error: Invalid command '" + command + "'. Please try again.");
                    }
                }
            } catch (Exception e) {
                // This catches any uncaught exception that occurs within the while loop.
                // This fulfills the "class-wide exception handling" requirement for the main logic.
                System.err.println("\nAn unexpected system error occurred during operation: " + e.getMessage());
                // For debugging, you might print the stack trace:
                // e.printStackTrace();
            }

        } // Scanner is automatically closed here by try-with-resources
        System.out.println("Application terminated."); // Reached if main loop breaks or returns
    }
}
