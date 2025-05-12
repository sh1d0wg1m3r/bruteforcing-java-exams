/*
 * Exam Question #22
 * Generated on: 2025-05-11 21:41:17
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment Management System
 * 
 * **Objective:** Develop a simplified console-based hospital appointment management system that demonstrates proficiency in core Java concepts, including data structures, user input handling, flow control, and exception handling.
 * 
 * **Scenario:** You need to create a system that allows registering patients and scheduling appointments. Patients are added to a list, and appointments are managed in a queue.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a list of registered patients. Use `java.util.List` as the interface type and `java.util.ArrayList` as the concrete implementation.
 *     *   Maintain a queue of scheduled appointments. Use `java.util.Queue` as the interface type. A suitable concrete implementation (like `java.util.LinkedList` or `java.util.ArrayDeque`) can be chosen, but the variable must be declared as `Queue`.
 * 
 * 2.  **Classes:**
 *     *   Create a `Patient` class with private fields: `id` (int) and `name` (String). Include a constructor and public getter methods. The `id` should be unique (a simple static counter can be used for generation).
 *     *   Create an `Appointment` class with private fields: `patientId` (int) and `details` (String). Include a constructor and public getter methods.
 *     *   Create a main class (e.g., `HospitalSystem`) that contains the `List<Patient>` and `Queue<Appointment>`. This class will handle the system logic and user interaction.
 * 
 * 3.  **Functionality (Implemented in the main class):**
 *     *   **Add Patient:** Prompt the user for the patient's name. Create a new `Patient` object with a unique ID and add it to the patient list. Print the new patient's ID and name.
 *     *   **Schedule Appointment:** Prompt the user for the patient ID and appointment details. Find the patient in the list by ID. If the patient is found, create an `Appointment` object and add it to the appointment queue. If the patient is not found, print an error message to `System.err`.
 *     *   **View Patients:** Display the list of all registered patients (ID and name) to `System.out`.
 *     *   **View Appointments:** Display the current appointment queue (patient ID and details) to `System.out`. Do *not* remove appointments from the queue when viewing.
 *     *   **Process Next Appointment:** Remove the next appointment from the front of the queue. If the queue is empty, print an error message to `System.err`. If an appointment is processed, print its details to `System.out` and attempt to find the corresponding patient in the list by ID and print their name (for confirmation). Handle the case where the patient might theoretically not be found (though the system design should ideally prevent this).
 *     *   **Exit:** Terminate the program.
 * 
 * 4.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user.
 *     *   Use a `switch` statement to handle the different user commands based on their input.
 *     *   The system should run in a loop until the user chooses to exit.
 * 
 * 5.  **Error Handling and Best Practices:**
 *     *   Implement class-wide exception handling using `try-catch` blocks. Wrap the main command processing loop in a `try-catch` to catch unexpected errors. Handle specific potential errors (e.g., `NumberFormatException` for invalid ID input) where appropriate, potentially using nested `try-catch` or specific exception types.
 *     *   Use `System.err.println()` for all error messages (e.g., patient not found, queue empty, invalid input).
 *     *   Use `System.out.println()` for all normal output (menu, prompts, success messages, lists, processed appointments).
 *     *   Implement input validation where necessary (e.g., checking if a patient ID exists).
 *     *   Follow Java coding conventions: meaningful names, proper indentation, comments where needed, encapsulation (private fields, public methods).
 * 
 * **Expected Output:**
 * 
 * The program should display a menu and respond to user commands. Examples:
 * 
 * ```
 * --- Hospital System Menu ---
 * 1. Add Patient
 * 2. Schedule Appointment
 * 3. View Patients
 * 4. View Appointments
 * 5. Process Next Appointment
 * 6. Exit
 * Enter your choice: 1
 * Enter patient name: Alice
 * Patient added: ID=1, Name=Alice
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 1
 * Enter patient name: Bob
 * Patient added: ID=2, Name=Bob
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 3
 * --- Registered Patients ---
 * ID: 1, Name: Alice
 * ID: 2, Name: Bob
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 2
 * Enter patient ID: 1
 * Enter appointment details: Checkup
 * Appointment scheduled for patient ID 1.
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 2
 * Enter patient ID: 99
 * Enter appointment details: Follow up
 * Error: Patient with ID 99 not found.
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 4
 * --- Scheduled Appointments ---
 * Patient ID: 1, Details: Checkup
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 5
 * Processing appointment: Patient ID: 1, Details: Checkup. Patient Name: Alice
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 5
 * Error: Appointment queue is empty.
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 6
 * Exiting system.
 * ```
 * 
 * **Evaluation:** Your solution will be evaluated based on correctness, adherence to all requirements (especially the use of the specified components), code quality, error handling robustness, and demonstration of understanding of the concepts involved.
 *
 * EXPLANATION:
 * This solution implements a simple hospital appointment management system based on the provided requirements.
 * 
 * 1.  **Class Structure:**
 *     *   `Patient`: A simple class to hold patient data (`id`, `name`). It uses a static counter (`nextId`) to ensure unique IDs for each new patient. Encapsulation is maintained with private fields and public getters.
 *     *   `Appointment`: A simple class to hold appointment data (`patientId`, `details`). Encapsulation is maintained with private fields and public getters.
 *     *   `PatientNotFoundException`: A custom checked exception used specifically when a patient is searched for by ID but not found in the list. This improves error clarity compared to using a generic exception.
 *     *   `HospitalSystem`: The main class containing the core logic. It holds the system's data structures (`patientList` and `appointmentQueue`) and the `Scanner` for input.
 * 
 * 2.  **Data Structures:**
 *     *   `patientList`: Declared as `List<Patient>` and initialized as `new ArrayList<>()`. `ArrayList` is suitable here as we need to store a dynamic collection of patients and access them by index or iterate through them. Searching by ID requires iteration.
 *     *   `appointmentQueue`: Declared as `Queue<Appointment>` and initialized as `new LinkedList<>()`. `LinkedList` implements the `Queue` interface and provides the necessary FIFO (First-In, First-Out) behavior for appointments. `offer()` is used for adding (safer than `add` in queues as it doesn't throw an exception if capacity-restricted, though not relevant here) and `poll()` for removing the head (safer than `remove` as it returns `null` if the queue is empty).
 * 
 * 3.  **User Interaction and Flow Control:**
 *     *   A `Scanner` object reads input from `System.in`.
 *     *   The `run()` method contains the main application loop (`while(running)`).
 *     *   Inside the loop, a menu is displayed, and user input is read.
 *     *   Input validation is performed to ensure the choice is a valid integer. A `try-catch` block handles `NumberFormatException`.
 *     *   A `switch` statement is used to direct execution based on the user's integer choice, fulfilling the flow control requirement.
 * 
 * 4.  **Functionality Implementation:**
 *     *   `addPatient()`: Reads the name, creates a `Patient` object, and adds it to the `patientList`. Basic validation for empty name is included.
 *     *   `scheduleAppointment()`: Reads patient ID and details. It includes a `try-catch` for `NumberFormatException` when parsing the ID. It calls `findPatientById()` to validate the patient's existence. If found, a new `Appointment` is created and added to the `appointmentQueue` using `offer()`. If `findPatientById()` throws `PatientNotFoundException`, the catch block prints an error to `System.err`.
 *     *   `findPatientById()`: This helper method iterates through the `patientList` to find a patient by ID. It throws the custom `PatientNotFoundException` if the patient is not found, demonstrating specific exception usage.
 *     *   `viewPatients()`: Iterates through the `patientList` and prints each patient's details to `System.out`.
 *     *   `viewAppointments()`: Iterates through the `appointmentQueue` to print details. To avoid removing elements while viewing, it creates a temporary `ArrayList` from the queue for iteration. This is a common pattern for viewing queue contents without modifying the queue.
 *     *   `processNextAppointment()`: Uses `appointmentQueue.poll()` to retrieve and remove the next appointment. It checks if the result is `null` to handle an empty queue, printing an error to `System.err`. If an appointment is retrieved, it prints its details to `System.out` and then attempts to find the corresponding patient using `findPatientById()`, wrapping this call in a `try-catch` for `PatientNotFoundException`.
 * 
 * 5.  **Error Handling:**
 *     *   **`System.err`:** Used exclusively for printing error messages (invalid input, patient not found, queue empty).
 *     *   **`System.out`:** Used exclusively for printing normal output (menu, prompts, success messages, lists, processed items).
 *     *   **`try-catch`:**
 *         *   Specific `try-catch(NumberFormatException)` blocks handle invalid integer input when reading choices and patient IDs.
 *         *   A `try-catch(PatientNotFoundException)` block handles the case where a patient ID entered for scheduling or processing is not found.
 *         *   A large `try-catch(Exception e)` block surrounds the entire `while` loop in the `run()` method. This fulfills the "class-wide exception handling" requirement by catching any uncaught exceptions that might occur during the execution of any command within the loop, preventing the program from crashing unexpectedly and providing a general error message.
 *     *   **Input Validation:** Checks for empty patient names and appointment details, and validates patient IDs against the existing list.
 * 
 * 6.  **Best Practices:**
 *     *   Private fields and public getters (`Patient`, `Appointment`).
 *     *   Meaningful variable names (`patientList`, `appointmentQueue`, `nextAppointment`).
 *     *   Meaningful method names (`addPatient`, `scheduleAppointment`, `processNextAppointment`).
 *     *   Comments explaining the purpose of methods and complex parts.
 *     *   Use of interfaces (`List`, `Queue`) for variable declarations where appropriate.
 *     *   Closing the `Scanner` in a `finally` block to prevent resource leaks.
 * 
 * This solution effectively integrates all required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) into a functional program that simulates a real-world scenario, demonstrating a solid understanding of these core Java concepts and best practices.
 */

import java.util.ArrayList;
import java.util.LinkedList; // A common Queue implementation
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.NoSuchElementException; // For Queue.element/remove if used, though poll is safer

// Custom exception for patient not found
class PatientNotFoundException extends Exception {
    public PatientNotFoundException(String message) {
        super(message);
    }
}

// Patient class
class Patient {
    private static int nextId = 1; // Static counter for unique IDs
    private int id;
    private String name;

    public Patient(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

// Appointment class
class Appointment {
    private int patientId;
    private String details;

    public Appointment(int patientId, String details) {
        this.patientId = patientId;
        this.details = details;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Details: " + details;
    }
}

// Main Hospital System class
public class HospitalSystem {

    private List<Patient> patientList;
    private Queue<Appointment> appointmentQueue;
    private Scanner scanner;

    public HospitalSystem() {
        // Use List interface, implement with ArrayList
        patientList = new ArrayList<>();
        // Use Queue interface, implement with LinkedList (or ArrayDeque)
        appointmentQueue = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options.
     */
    private void displayMenu() {
        System.out.println("\n--- Hospital System Menu ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Schedule Appointment");
        System.out.println("3. View Patients");
        System.out.println("4. View Appointments");
        System.out.println("5. Process Next Appointment");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new patient to the system.
     */
    private void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        if (name == null || name.trim().isEmpty()) {
             System.err.println("Error: Patient name cannot be empty.");
             return;
        }
        Patient newPatient = new Patient(name.trim());
        patientList.add(newPatient);
        System.out.println("Patient added: " + newPatient);
    }

    /**
     * Schedules a new appointment for a registered patient.
     * Handles PatientNotFoundException.
     */
    private void scheduleAppointment() {
        System.out.print("Enter patient ID: ");
        int patientId;
        try {
            patientId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid patient ID format. Please enter a number.");
            return;
        }

        System.out.print("Enter appointment details: ");
        String details = scanner.nextLine();
        if (details == null || details.trim().isEmpty()) {
             System.err.println("Error: Appointment details cannot be empty.");
             return;
        }

        try {
            // Find patient - demonstrates list search and potential exception
            findPatientById(patientId); // Just check existence, don't need the object here
            Appointment newAppointment = new Appointment(patientId, details.trim());
            appointmentQueue.offer(newAppointment); // offer is safer than add in queues
            System.out.println("Appointment scheduled for patient ID " + patientId + ".");
        } catch (PatientNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Finds a patient by their ID.
     * @param id The ID of the patient to find.
     * @return The Patient object if found.
     * @throws PatientNotFoundException if no patient with the given ID exists.
     */
    private Patient findPatientById(int id) throws PatientNotFoundException {
        for (Patient patient : patientList) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        throw new PatientNotFoundException("Patient with ID " + id + " not found.");
    }


    /**
     * Displays all registered patients.
     */
    private void viewPatients() {
        System.out.println("--- Registered Patients ---");
        if (patientList.isEmpty()) {
            System.out.println("No patients registered yet.");
        } else {
            for (Patient patient : patientList) {
                System.out.println(patient);
            }
        }
    }

    /**
     * Displays all scheduled appointments without removing them from the queue.
     */
    private void viewAppointments() {
        System.out.println("--- Scheduled Appointments ---");
        if (appointmentQueue.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            // Iterate through the queue without removing elements
            // This can be done by converting to a List or using an iterator
            // Converting to List is often simpler for printing
            List<Appointment> appointmentList = new ArrayList<>(appointmentQueue);
            for (Appointment appointment : appointmentList) {
                System.out.println(appointment);
            }
        }
    }

    /**
     * Processes (removes and displays) the next appointment in the queue.
     * Handles Queue empty case and PatientNotFoundException.
     */
    private void processNextAppointment() {
        Appointment nextAppointment = appointmentQueue.poll(); // poll is safer, returns null if empty

        if (nextAppointment == null) {
            System.err.println("Error: Appointment queue is empty.");
        } else {
            System.out.println("Processing appointment: " + nextAppointment);
            try {
                // Find the patient to display their name
                Patient patient = findPatientById(nextAppointment.getPatientId());
                System.out.println("Corresponding Patient Name: " + patient.getName());
            } catch (PatientNotFoundException e) {
                // This case should ideally not happen if scheduling validates patient existence,
                // but handling it makes the processing robust.
                System.err.println("Warning: Could not find patient for processed appointment ID " + nextAppointment.getPatientId() + ".");
            }
        }
    }

    /**
     * Runs the main system loop.
     * Implements class-wide exception handling.
     */
    public void run() {
        boolean running = true;
        // Class-wide exception handling around the main loop
        try {
            while (running) {
                displayMenu();
                String choiceStr = scanner.nextLine();
                int choice;

                try {
                    choice = Integer.parseInt(choiceStr);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid input. Please enter a number between 1 and 6.");
                    continue; // Skip to the next iteration of the loop
                }

                // Switch statement for flow control
                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        scheduleAppointment();
                        break;
                    case 3:
                        viewPatients();
                        break;
                    case 4:
                        viewAppointments();
                        break;
                    case 5:
                        processNextAppointment();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 6.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions
            System.err.println("An unexpected error occurred:");
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure the scanner is closed
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        system.run();
    }
}
