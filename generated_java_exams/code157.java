/*
 * Exam Question #157
 * Generated on: 2025-05-11 22:23:08
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Clinic Patient Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified patient management system for a small clinic. The system should allow clinic staff to perform basic operations like registering new patients, checking patients in upon arrival, and simulating the scheduling of the next available patient from the check-in queue.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a list of *all* registered patients.
 *     *   Maintain a queue of patients who have checked in and are waiting to be scheduled.
 * 2.  **Functionality:**
 *     *   **Add New Patient:** Register a new patient by collecting their ID, name, and age. Patient IDs must be unique (though for simplicity in this exam, you don't need to enforce uniqueness rigorously; just add the patient).
 *     *   **Check In Patient:** Find a registered patient by their ID and add them to the check-in queue. A patient can only be checked in once.
 *     *   **Schedule Next Patient:** Take the next patient from the check-in queue and simulate scheduling them (e.g., by printing a confirmation message).
 *     *   **List Patients:** Display all registered patients and all patients currently in the check-in queue.
 *     *   **Exit:** Terminate the program.
 * 3.  **User Interface:**
 *     *   Present a menu of options to the user (Add Patient, Check In, Schedule Next, List Patients, Exit).
 *     *   Use `Scanner` to read user input for menu choices and patient details.
 * 4.  **Required Java Components:**
 *     *   `java.util.Queue` (for the check-in queue)
 *     *   `java.util.ArrayList` (for the list of registered patients)
 *     *   `java.util.List` interface (used in variable declarations)
 *     *   `java.util.Scanner` (for input)
 *     *   `switch` statement (for menu handling)
 *     *   `System.err` (for error messages, e.g., patient not found, queue empty)
 *     *   `System.out` (for normal output, menu, confirmations, lists)
 * 5.  **Error Handling:**
 *     *   Implement input validation where appropriate (e.g., ensuring age is a positive number, handling non-integer input for menu choices or ID).
 *     *   Use `try-catch` blocks for handling potential exceptions (e.g., `NumberFormatException` for input parsing, general `Exception` for unexpected errors). A class-wide `try-catch` around the main application loop is required.
 *     *   Handle specific scenarios like trying to check in a non-existent patient, checking in a patient already checked in, or scheduling from an empty queue using `if/else` and `System.err`.
 * 6.  **Best Practices:**
 *     *   Use proper encapsulation (private fields, public methods/getters).
 *     *   Use meaningful variable and method names.
 *     *   Include basic comments to explain the code.
 *     *   Maintain a clean code structure with separate methods for different functionalities.
 * 
 * **Expected Output:**
 * 
 * The program should repeatedly display a menu and process user input until the 'Exit' option is chosen. Output should include confirmations for successful operations, lists of patients, and error messages using `System.err` when issues occur.
 * 
 * ```
 * --- Clinic Management System ---
 * 1. Add New Patient
 * 2. Check In Patient
 * 3. Schedule Next Patient
 * 4. List Patients
 * 5. Exit
 * Enter your choice: 
 * ```
 * 
 * (Example interaction after adding a patient, checking them in, and listing)
 * 
 * ```
 * --- Clinic Management System ---
 * 1. Add New Patient
 * 2. Check In Patient
 * 3. Schedule Next Patient
 * 4. List Patients
 * 5. Exit
 * Enter your choice: 1
 * Enter patient ID: 101
 * Enter patient name: Alice Smith
 * Enter patient age: 35
 * Patient 101 (Alice Smith) registered successfully.
 * 
 * --- Clinic Management System ---
 * ...
 * Enter your choice: 2
 * Enter patient ID to check in: 101
 * Patient 101 (Alice Smith) checked in.
 * 
 * --- Clinic Management System ---
 * ...
 * Enter your choice: 4
 * --- Registered Patients ---
 * ID: 101, Name: Alice Smith, Age: 35
 * --- Checked-In Patients ---
 * ID: 101, Name: Alice Smith, Age: 35
 * 
 * --- Clinic Management System ---
 * ...
 * Enter your choice: 3
 * Scheduling next patient from queue...
 * Scheduled: ID: 101, Name: Alice Smith, Age: 35
 * 
 * --- Clinic Management System ---
 * ...
 * Enter your choice: 3
 * Scheduling next patient from queue...
 * System.err: Check-in queue is empty. No patient to schedule.
 * 
 * --- Clinic Management System ---
 * ...
 * Enter your choice: 5
 * Exiting system.
 * ```
 * 
 * Your solution should be a single Java file containing the necessary classes.
 *
 * EXPLANATION:
 * The provided solution implements a simplified clinic patient management system demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Patient` Class:**
 *     *   This class represents a patient with private fields (`id`, `name`, `age`, `checkedIn`) ensuring encapsulation.
 *     *   It includes a constructor to initialize patient data and public getter methods (`getId`, `getName`, `getAge`, `isCheckedIn`) to access the data.
 *     *   A setter (`setCheckedIn`) is added to update the patient's check-in status.
 *     *   `toString()` is overridden for convenient printing of patient details.
 * 
 * 2.  **`ClinicScheduler` Class:**
 *     *   This is the main class containing the application logic.
 *     *   **Data Structures:**
 *         *   `private List<Patient> registeredPatients;`: Declared using the `List` interface and initialized with an `ArrayList`. This list stores all patients ever registered. `ArrayList` is suitable for storing and iterating through a collection of objects where element access by index is needed (though not heavily used in this specific iteration, `ArrayList` is a common choice for dynamic lists).
 *         *   `private Queue<Patient> checkInQueue;`: Declared using the `Queue` interface and initialized with a `LinkedList`. `LinkedList` is a common implementation of `Queue`. A queue is used here to manage patients in a First-In, First-Out (FIFO) manner, simulating the check-in and scheduling process. Patients are added to the back (`offer`) and removed from the front (`poll`).
 *     *   **`Scanner`:** `private Scanner scanner;` is used for reading user input from the console. It's initialized in the constructor and closed in a `finally` block in `main` to ensure resource management.
 *     *   **`main` Method:** The entry point of the application. It creates an instance of `ClinicScheduler` and calls the `run()` method within a class-wide `try-catch` block. This outer `try-catch` handles any unexpected exceptions that might escape other methods, printing the error to `System.err` and ensuring the `scanner` is closed via the `finally` block.
 *     *   **`run` Method:** Contains the main application loop (`while (choice != 5)`). It repeatedly prints the menu, prompts for user input, and calls `processChoice`.
 *         *   It includes input validation (`scanner.hasNextInt()`) to prevent `InputMismatchException` if the user enters non-integer input for the menu choice.
 *         *   A `try-catch` block wraps the input reading and `processChoice` call to catch potential `InputMismatchException` (though primarily handled by `hasNextInt`) or other exceptions during choice processing, directing errors to `System.err`.
 *     *   **`printMenu` Method:** A simple helper to display the menu options using `System.out`.
 *     *   **`processChoice` Method:** Uses a `switch` statement to direct execution based on the user's integer choice, calling the appropriate private method for each operation. A `default` case handles invalid menu numbers, printing an error to `System.err`.
 *     *   **`addNewPatient` Method:**
 *         *   Prompts the user for patient details using `System.out`.
 *         *   Uses a `try-catch` block specifically for handling `InputMismatchException` during the reading of integer inputs (ID and age).
 *         *   Includes basic validation to ensure age is positive, printing an error to `System.err` if invalid.
 *         *   Creates a `Patient` object and adds it to the `registeredPatients` `ArrayList`.
 *         *   Prints a success message to `System.out`.
 *     *   **`checkInPatient` Method:**
 *         *   Prompts for the patient ID to check in.
 *         *   Uses a `try-catch` for `InputMismatchException`.
 *         *   Calls `findPatientById` to locate the patient in the `registeredPatients` list.
 *         *   Uses `if/else` statements to handle the cases where the patient is not found (`System.err`) or is already checked in (`System.err`).
 *         *   If found and not checked in, the patient is added to the `checkInQueue` using `offer()` (a `Queue` method that adds to the tail and returns `true` or `false` depending on success, safer than `add()` which throws an exception if the queue is full, though `LinkedList` doesn't have a capacity limit). The patient's `checkedIn` status is updated. A success message is printed to `System.out`.
 *     *   **`scheduleNextPatient` Method:**
 *         *   Prints a message indicating the action to `System.out`.
 *         *   Uses `checkInQueue.poll()` to retrieve and remove the patient at the head of the queue. `poll()` returns `null` if the queue is empty, making it suitable for checking without throwing an exception.
 *         *   An `if` statement checks if `poll()` returned `null`. If so, an error message is printed to `System.err`.
 *         *   Otherwise, the scheduled patient's details are printed to `System.out`.
 *     *   **`listPatients` Method:**
 *         *   Iterates through the `registeredPatients` `ArrayList` and prints each patient's details using `System.out`.
 *         *   Iterates through the `checkInQueue` (using a simple for-each loop, which is possible with `LinkedList`) and prints each checked-in patient's details using `System.out`.
 *         *   Includes checks for empty lists/queue and prints appropriate messages.
 *     *   **`findPatientById` Method:** A private helper method that iterates through the `registeredPatients` `ArrayList` to find a patient by their ID. Returns the `Patient` object if found, otherwise returns `null`.
 *     *   **`closeScanner` Method:** A public method to close the `Scanner` resource, called from the `finally` block in `main`.
 * 
 * This solution effectively integrates all the required Java components within a practical scenario, demonstrating input handling, flow control (`switch`), data structure usage (`ArrayList`, `Queue`, `List`), encapsulation, and error handling (`try-catch`, `System.err`, input validation).
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a patient in the system
class Patient {
    private int id;
    private String name;
    private int age;
    private boolean checkedIn; // Added to track check-in status

    // Constructor
    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.checkedIn = false; // Initially not checked in
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    // Setter for checkedIn status
    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

// The main clinic management system class
public class ClinicScheduler {

    // Use List interface for flexibility, implemented by ArrayList
    private List<Patient> registeredPatients;

    // Use Queue interface for check-in queue, implemented by LinkedList
    private Queue<Patient> checkInQueue;

    private Scanner scanner;

    // Constructor
    public ClinicScheduler() {
        // Initialize data structures
        registeredPatients = new ArrayList<>();
        checkInQueue = new LinkedList<>(); // LinkedList is a common Queue implementation
        scanner = new Scanner(System.in);
    }

    // Main method to run the application
    public static void main(String[] args) {
        ClinicScheduler system = new ClinicScheduler();
        // Class-wide try-catch for the main application loop
        try {
            system.run();
        } catch (Exception e) {
            // Catch any unhandled exception during execution
            System.err.println("An unexpected error occurred:");
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
             // Ensure scanner is closed even if an exception occurs
             system.closeScanner();
        }
    }

    // The main application loop
    public void run() {
        int choice = -1;
        while (choice != 5) {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                // Input validation for menu choice
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    processChoice(choice);
                } else {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    choice = -1; // Reset choice to stay in loop
                }
            } catch (InputMismatchException e) {
                 // This catch block is technically redundant due to hasNextInt(),
                 // but included to show specific input mismatch handling if needed elsewhere.
                 System.err.println("Invalid input type. Please enter a number.");
                 scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) {
                // Catch any other exception within the loop's processing
                System.err.println("An error occurred during processing:");
                e.printStackTrace(System.err);
            }
            System.out.println(); // Add a newline for better readability between operations
        }
        System.out.println("Exiting system.");
    }

    // Prints the main menu
    private void printMenu() {
        System.out.println("--- Clinic Management System ---");
        System.out.println("1. Add New Patient");
        System.out.println("2. Check In Patient");
        System.out.println("3. Schedule Next Patient");
        System.out.println("4. List Patients");
        System.out.println("5. Exit");
    }

    // Processes the user's menu choice using a switch statement
    private void processChoice(int choice) {
        switch (choice) {
            case 1:
                addNewPatient();
                break;
            case 2:
                checkInPatient();
                break;
            case 3:
                scheduleNextPatient();
                break;
            case 4:
                listPatients();
                break;
            case 5:
                // Handled by the while loop condition
                break;
            default:
                System.err.println("Invalid choice. Please enter a number between 1 and 5.");
        }
    }

    // Adds a new patient to the registered list
    private void addNewPatient() {
        System.out.print("Enter patient ID: ");
        // Use try-catch for potential NumberFormatException
        try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter patient name: ");
            String name = scanner.nextLine();
            System.out.print("Enter patient age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Basic input validation for age
            if (age <= 0) {
                System.err.println("Error: Age must be a positive number.");
                return; // Exit method if age is invalid
            }

            // For exam simplicity, we don't strictly check for duplicate IDs here,
            // just add the new patient. A real system would need robust ID management.
            Patient newPatient = new Patient(id, name, age);
            registeredPatients.add(newPatient);
            System.out.println("Patient " + id + " (" + name + ") registered successfully.");

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter numbers for ID and age.");
            scanner.nextLine(); // Consume the invalid input line
        } catch (Exception e) {
             System.err.println("An error occurred while adding patient:");
             e.printStackTrace(System.err);
        }
    }

    // Checks in a patient and adds them to the queue
    private void checkInPatient() {
        System.out.print("Enter patient ID to check in: ");
         try {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Find the patient in the registered list
            Patient patientToFind = findPatientById(id);

            if (patientToFind == null) {
                System.err.println("Error: Patient with ID " + id + " not found in registered list.");
            } else if (patientToFind.isCheckedIn()) {
                 System.err.println("Error: Patient with ID " + id + " is already checked in.");
            }
            else {
                // Add patient to the queue and update their status
                checkInQueue.offer(patientToFind); // offer() is safer than add() for queues
                patientToFind.setCheckedIn(true);
                System.out.println("Patient " + id + " (" + patientToFind.getName() + ") checked in.");
            }

        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number for patient ID.");
            scanner.nextLine(); // Consume the invalid input line
        } catch (Exception e) {
             System.err.println("An error occurred while checking in patient:");
             e.printStackTrace(System.err);
        }
    }

    // Schedules the next patient from the queue
    private void scheduleNextPatient() {
        System.out.println("Scheduling next patient from queue...");
        // Use poll() to retrieve and remove the head of the queue, returns null if empty
        Patient nextPatient = checkInQueue.poll();

        if (nextPatient == null) {
            System.err.println("Check-in queue is empty. No patient to schedule.");
        } else {
            // Simulate scheduling by printing details
            System.out.println("Scheduled: " + nextPatient);
            // In a real system, you might move this patient to a 'scheduled' list
            // and potentially reset their checkedIn status if they leave the clinic.
            // For this exam, we just remove them from the queue.
        }
    }

    // Lists all registered patients and patients in the check-in queue
    private void listPatients() {
        System.out.println("--- Registered Patients ---");
        if (registeredPatients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient patient : registeredPatients) {
                System.out.println(patient);
            }
        }

        System.out.println("--- Checked-In Patients ---");
        if (checkInQueue.isEmpty()) {
            System.out.println("No patients currently checked in.");
        } else {
            // Iterate through the queue without removing elements (using checkInQueue)
            // or iterate through a copy if removal isn't desired during listing.
            // Simple iteration here:
             for (Patient patient : checkInQueue) {
                 System.out.println(patient);
             }
            // Note: Iterating a Queue might depend on implementation, but LinkedList supports it.
        }
    }

    // Helper method to find a patient by ID in the registered list
    private Patient findPatientById(int id) {
        for (Patient patient : registeredPatients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null; // Patient not found
    }

    // Method to close the scanner resource
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
