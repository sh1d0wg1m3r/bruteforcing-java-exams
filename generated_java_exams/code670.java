/*
 * Exam Question #670
 * Generated on: 2025-05-12 16:23:08
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Java Programming Exam Task: Hospital Patient Queue Management**
 * 
 * You are tasked with developing a simple console-based application to manage a patient waiting queue and track completed appointments for a hospital department. This system should allow staff to add new patients, call the next patient from the queue, and view both the current waiting list and the history of completed appointments.
 * 
 * Your solution must demonstrate proficiency in using fundamental Java data structures and control flow mechanisms, adhering to good programming practices.
 * 
 * **Requirements:**
 * 
 * 1.  **Patient Representation:** Create a `Patient` class with private fields for `patientId` (String) and `name` (String). Include a constructor, public getter methods for both fields, and a `toString()` method that provides a clear representation of the patient (e.g., "Patient ID: [ID], Name: [Name]").
 * 2.  **Queue Management:** Implement a class, `HospitalQueueManager`, that manages the patient flow.
 *     *   It must use a `java.util.Queue` (specifically, you can use `java.util.LinkedList` as it implements `Queue`) to hold patients currently waiting.
 *     *   It must use a `java.util.List` (specifically, `java.util.ArrayList`) to store patients whose appointments have been completed.
 *     *   Declare these data structures as private fields.
 * 3.  **Core Functionality:** The `HospitalQueueManager` class must provide the following public methods:
 *     *   `addPatient(Patient patient)`: Adds a patient to the waiting queue. Include basic validation (e.g., patient object is not null).
 *     *   `callNextPatient()`: Removes the patient at the front of the waiting queue and adds them to the completed appointments list. It should return the patient object that was called, or `null` if the queue was empty.
 *     *   `viewWaitingQueue()`: Prints the details of all patients currently in the waiting queue to `System.out`. Indicate if the queue is empty.
 *     *   `viewCompletedAppointments()`: Prints the details of all patients in the completed appointments list to `System.out`. Indicate if the list is empty.
 *     *   `runSystem(Scanner scanner)`: This method should contain the main application loop. It will:
 *         *   Display a menu of options to the user using `System.out`.
 *         *   Read user input using the provided `Scanner`.
 *         *   Use a `switch` statement to process the user's choice.
 *         *   Implement the logic for each menu option by calling the appropriate methods (`addPatient`, `callNextPatient`, etc.).
 *         *   Handle user input for adding a new patient (ID and name). Include basic validation (e.g., ID and name should not be empty).
 *         *   Use `System.err` to display error messages (e.g., invalid menu choice, attempting to call next patient from an empty queue, invalid patient input).
 *         *   The loop should continue until the user chooses to exit.
 * 4.  **User Interface (within `runSystem`):**
 *     *   Present a menu with options: 1) Add New Patient, 2) Call Next Patient, 3) View Waiting Queue, 4) View Completed Appointments, 5) Exit.
 *     *   Prompt the user for input.
 * 5.  **Exception Handling:**
 *     *   Implement class-wide exception handling in the `main` method using a `try-catch` block that wraps the call to `runSystem`. This block should catch general `Exception` and print an error message along with the exception details to `System.err` if an unhandled error occurs.
 *     *   Handle specific errors within `runSystem` (e.g., using `System.err` for invalid user input or logical errors like an empty queue).
 * 6.  **Best Practices:**
 *     *   Use appropriate access modifiers (private for fields, public for main methods).
 *     *   Choose meaningful variable and method names.
 *     *   Add comments where necessary to explain complex logic.
 *     *   Ensure the `Scanner` resource is properly closed.
 * 
 * **Expected Output Structure:**
 * 
 * The program should interact with the user via the console, displaying the menu, prompts, and results. Error messages should be clearly distinguishable using `System.err`.
 * 
 * ```
 * --- Hospital Queue Management ---
 * 1. Add New Patient
 * 2. Call Next Patient
 * 3. View Waiting Queue
 * 4. View Completed Appointments
 * 5. Exit
 * Enter your choice:
 * ```
 * 
 * (Example interaction for adding a patient)
 * ```
 * Enter patient ID: P101
 * Enter patient name: Alice Smith
 * Patient P101 (Alice Smith) added to the queue.
 * ```
 * 
 * (Example interaction for calling next patient)
 * ```
 * Calling next patient...
 * Patient P101 (Alice Smith) called. Added to completed list.
 * ```
 * 
 * (Example interaction with empty queue)
 * ```
 * Calling next patient...
 * Error: Waiting queue is empty. No patient to call.
 * ```
 * 
 * (Example interaction with invalid input)
 * ```
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number between 1 and 5.
 * ```
 * 
 * (Example interaction with viewing queues)
 * ```
 * --- Waiting Queue ---
 * 1. Patient ID: P102, Name: Bob Johnson
 * --- End Waiting Queue ---
 * 
 * --- Completed Appointments ---
 * 1. Patient ID: P101, Name: Alice Smith
 * --- End Completed Appointments ---
 * ```
 * 
 * Your solution should be contained within a single file for submission convenience in an exam setting.
 *
 * EXPLANATION:
 * This solution provides a console-based simulation of a hospital patient queue management system, fulfilling all the requirements of the exam task.
 * 
 * 1.  **`Patient` Class:** A simple class representing a patient with encapsulated `patientId` and `name`. It includes a constructor with basic validation to ensure ID and name are not empty, getter methods, and an overridden `toString()` method for easy printing.
 * 
 * 2.  **`HospitalQueueManager` Class:**
 *     *   It uses a `Queue<Patient>` named `waitingQueue`, implemented by `LinkedList`, to manage patients in a First-In, First-Out (FIFO) manner. `LinkedList` is chosen because it implements both `Queue` and `List`, although we only use its `Queue` capabilities for the waiting list.
 *     *   It uses a `List<Patient>` named `completedAppointments`, implemented by `ArrayList`, to store the history of patients who have been processed.
 *     *   **`addPatient`:** Takes a `Patient` object and adds it to the `waitingQueue` using `offer()`, which is the standard method for adding to a queue.
 *     *   **`callNextPatient`:** Uses `poll()` to retrieve and remove the head of the `waitingQueue`. `poll()` is suitable here because it returns `null` if the queue is empty, allowing for graceful handling of that case, rather than throwing an exception like `remove()`. If a patient is retrieved, they are added to the `completedAppointments` list.
 *     *   **`viewWaitingQueue` and `viewCompletedAppointments`:** These methods iterate through their respective collections (`Queue` and `List`) and print patient details to `System.out`. They check for emptiness before iterating.
 *     *   **`runSystem`:** This method contains the main loop. It displays a menu, reads user input using the `Scanner`, and uses a `switch` statement to direct execution based on the user's choice.
 *         *   **Input Handling:** It reads input as a String first and then attempts to parse it to an integer within a `try-catch` block. This handles `NumberFormatException` if the user enters non-numeric input, printing an error to `System.err`.
 *         *   **Switch Statement:** Handles the 5 menu options. Cases 1-4 call the corresponding manager methods. Case 5 sets the `running` flag to false, exiting the loop. The `default` case handles invalid numeric input, printing an error to `System.err`.
 *         *   **Patient Creation Validation:** Inside case 1, a nested `try-catch` handles potential `IllegalArgumentException` thrown by the `Patient` constructor if the user enters empty ID or name.
 *         *   **Empty Queue Handling:** The `callNextPatient` method itself handles the empty queue case and prints an error to `System.err`.
 * 
 * 3.  **Main Class (`HospitalApp`):**
 *     *   The `main` method is the entry point.
 *     *   It uses a `try-with-resources` block to ensure the `Scanner` is automatically closed when the block is exited, preventing resource leaks.
 *     *   It creates an instance of `HospitalQueueManager`.
 *     *   The call to `manager.runSystem(scanner)` is wrapped in a `try-catch(Exception e)`. This fulfills the "class-wide exception handling" requirement by catching any unexpected `Exception` that might propagate up from the `runSystem` method or other parts of the application logic, printing the error details to `System.err`.
 * 
 * 4.  **Best Practices & Requirements Compliance:**
 *     *   **Encapsulation:** Fields in `Patient` and `HospitalQueueManager` are private.
 *     *   **Meaningful Names:** Classes, methods, and variables have descriptive names.
 *     *   **Comments/Documentation:** Javadoc comments explain the purpose of classes and methods, and inline comments clarify specific logic points.
 *     *   **Input Validation:** Basic checks for non-empty strings for patient data and numeric input for menu choice are included.
 *     *   **Error Handling:** `System.err` is used for all error messages (invalid input, empty queue, unexpected exceptions). `try-catch` blocks handle specific parsing errors and a general catch block in `main` handles broader issues.
 *     *   **`Queue` and `List`:** Both are used as required, `Queue` for FIFO waiting list and `List` for history.
 *     *   **`Scanner`, `switch`, `System.err`, `System.out`:** All are used as specified.
 * 
 * This solution demonstrates the ability to integrate multiple core Java concepts and data structures into a functional program, handle user interaction, and implement basic error management, making it a suitable challenge for an intermediate to advanced Java exam.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// Represents a patient with an ID and name
class Patient {
    private String patientId;
    private String name;

    /**
     * Constructs a new Patient.
     * @param patientId The unique ID of the patient.
     * @param name The name of the patient.
     */
    public Patient(String patientId, String name) {
        // Basic validation
        if (patientId == null || patientId.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient ID cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty.");
        }
        this.patientId = patientId.trim();
        this.name = name.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the patient.
     * @return String representation.
     */
    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + name;
    }
}

// Manages the hospital patient queue and completed appointments
class HospitalQueueManager {
    // Queue to hold patients currently waiting. LinkedList implements Queue.
    private Queue<Patient> waitingQueue;
    // List to hold patients whose appointments are completed.
    private List<Patient> completedAppointments;

    /**
     * Constructs a new HospitalQueueManager.
     * Initializes the waiting queue and completed appointments list.
     */
    public HospitalQueueManager() {
        this.waitingQueue = new LinkedList<>(); // Using LinkedList as it implements Queue
        this.completedAppointments = new ArrayList<>(); // Using ArrayList for completed list
    }

    /**
     * Adds a patient to the waiting queue.
     * @param patient The patient to add.
     */
    public void addPatient(Patient patient) {
        if (patient != null) {
            waitingQueue.offer(patient); // offer is preferred over add in queues as it doesn't throw exception on capacity issues (though LinkedList is unbounded)
            System.out.println("Patient " + patient.getPatientId() + " (" + patient.getName() + ") added to the queue.");
        } else {
            System.err.println("Error: Cannot add a null patient.");
        }
    }

    /**
     * Calls the next patient from the waiting queue.
     * Removes the patient from the queue and adds to completed list.
     * @return The patient called, or null if the queue is empty.
     */
    public Patient callNextPatient() {
        System.out.println("Calling next patient...");
        Patient nextPatient = waitingQueue.poll(); // poll retrieves and removes the head, returns null if empty

        if (nextPatient != null) {
            completedAppointments.add(nextPatient);
            System.out.println("Patient " + nextPatient.getPatientId() + " (" + nextPatient.getName() + ") called. Added to completed list.");
            return nextPatient;
        } else {
            System.err.println("Error: Waiting queue is empty. No patient to call.");
            return null;
        }
    }

    /**
     * Prints the details of all patients in the waiting queue.
     */
    public void viewWaitingQueue() {
        System.out.println("--- Waiting Queue ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting queue is currently empty.");
        } else {
            // Iterate without removing elements
            int index = 1;
            for (Patient patient : waitingQueue) {
                System.out.println(index++ + ". " + patient);
            }
        }
        System.out.println("--- End Waiting Queue ---");
    }

    /**
     * Prints the details of all patients in the completed appointments list.
     */
    public void viewCompletedAppointments() {
        System.out.println("--- Completed Appointments ---");
        if (completedAppointments.isEmpty()) {
            System.out.println("No appointments have been completed yet.");
        } else {
            int index = 1;
            for (Patient patient : completedAppointments) {
                System.out.println(index++ + ". " + patient);
            }
        }
        System.out.println("--- End Completed Appointments ---");
    }

    /**
     * Runs the main interactive system loop.
     * @param scanner The Scanner object for reading user input.
     */
    public void runSystem(Scanner scanner) {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                String input = scanner.nextLine();
                int choice = Integer.parseInt(input);

                switch (choice) {
                    case 1: // Add New Patient
                        System.out.print("Enter patient ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine();
                        try {
                            Patient newPatient = new Patient(id, name);
                            addPatient(newPatient);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error creating patient: " + e.getMessage());
                        }
                        break;
                    case 2: // Call Next Patient
                        callNextPatient();
                        break;
                    case 3: // View Waiting Queue
                        viewWaitingQueue();
                        break;
                    case 4: // View Completed Appointments
                        viewCompletedAppointments();
                        break;
                    case 5: // Exit
                        System.out.println("Exiting Hospital Queue Management System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number between 1 and 5.");
            } catch (Exception e) {
                // Catch any other unexpected exceptions during command processing
                System.err.println("An unexpected error occurred during command processing: " + e.getMessage());
                // e.printStackTrace(System.err); // Uncomment for detailed debugging
            }
            System.out.println(); // Add a newline for better readability between operations
        }
    }

    // Displays the main menu
    private void displayMenu() {
        System.out.println("--- Hospital Queue Management ---");
        System.out.println("1. Add New Patient");
        System.out.println("2. Call Next Patient");
        System.out.println("3. View Waiting Queue");
        System.out.println("4. View Completed Appointments");
        System.out.println("5. Exit");
    }
}

// Main class to run the application
public class HospitalApp {

    public static void main(String[] args) {
        // Use try-with-resources to ensure the Scanner is closed
        try (Scanner scanner = new Scanner(System.in)) {
            HospitalQueueManager manager = new HospitalQueueManager();
            // Wrap the system execution in a try-catch for class-wide handling
            try {
                manager.runSystem(scanner);
            } catch (Exception e) {
                // Catch any unhandled exceptions from the runSystem method
                System.err.println("\nAn unrecoverable error occurred:");
                e.printStackTrace(System.err);
            }
        } catch (Exception e) {
            // Catch potential errors during Scanner initialization or closing
             System.err.println("\nAn error occurred during application setup or shutdown:");
             e.printStackTrace(System.err);
        }
    }
}
