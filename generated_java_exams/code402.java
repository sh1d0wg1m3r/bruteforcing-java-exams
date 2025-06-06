/*
 * Exam Question #402
 * Generated on: 2025-05-11 23:05:48
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified command-line application for managing patient appointments in a small hospital. The system needs to handle patient registration, manage waiting queues for doctors, and facilitate calling patients for their appointments.
 * 
 * **Requirements:**
 * 
 * 1.  **Core Functionality:**
 *     *   **Patient Registration:** Allow registering new patients with a unique ID and name.
 *     *   **View Patients:** Display a list of all registered patients.
 *     *   **Add to Waiting Queue:** Allow adding a registered patient to a specific doctor's waiting queue. Patients are added to the end of the queue.
 *     *   **Call Next Patient:** For a given doctor, retrieve (and remove) the patient at the front of their waiting queue, simulating the start of an appointment.
 *     *   **View Doctor's Queue:** Display the list of patients currently waiting in a specific doctor's queue.
 *     *   **Exit:** Terminate the application.
 * 
 * 2.  **Data Structures:**
 *     *   Use `java.util.ArrayList` (via the `java.util.List` interface) to store the list of all registered patients and a list of available doctors.
 *     *   Use `java.util.Queue` (specifically `java.util.LinkedList` which implements `Queue`) to manage the waiting list for *each* doctor. A suitable structure like a `Map` could be used to associate doctors with their respective queues.
 * 
 * 3.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu of options to the user.
 *     *   Use a `switch` statement to process the user's menu choice.
 * 
 * 4.  **Output:**
 *     *   Use `System.out` for displaying the menu, successful operation messages, patient lists, and queue contents.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, patient not found, doctor not found, queue empty).
 * 
 * 5.  **Error Handling:**
 *     *   Implement robust input validation (e.g., ensuring numeric input where expected, checking if patient/doctor IDs exist).
 *     *   Use `try-catch` blocks to handle potential exceptions, such as `InputMismatchException` for invalid input format, or custom logic to handle operational errors (like trying to call from an empty queue). Demonstrate exception handling that covers a significant portion of the application's runtime logic (e.g., around the main input loop).
 * 
 * 6.  **Object-Oriented Design:**
 *     *   Create separate classes for `Patient` and `Doctor` with appropriate private fields and public getter methods.
 *     *   Create a main class (e.g., `HospitalSystem`) that manages the lists of patients, doctors, and the doctor queues. This class should contain the main application logic and the `main` method.
 *     *   Apply proper encapsulation (private fields, public methods) and meaningful names.
 *     *   Include basic comments or JavaDocs for clarity.
 * 
 * **Initial Data:**
 * 
 * The system should be initialized with at least two doctors and a few pre-registered patients.
 * 
 * **Example Interaction Flow (Illustrative):**
 * 
 * ```
 * *** Hospital Appointment System ***
 * 1. Register Patient
 * 2. View All Patients
 * 3. Add Patient to Doctor's Queue
 * 4. Call Next Patient for Doctor
 * 5. View Doctor's Queue
 * 6. Exit
 * Enter your choice: 3
 * Enter Patient ID: 101
 * Enter Doctor ID: 201
 * Patient ID 101 added to Doctor ID 201's queue.
 * 
 * Enter your choice: 5
 * Enter Doctor ID: 201
 * Queue for Doctor ID 201 (Dr. Smith):
 * - Patient ID: 101, Name: Alice
 * - Patient ID: 103, Name: Charlie
 * 
 * Enter your choice: 4
 * Enter Doctor ID: 201
 * Calling next patient for Doctor ID 201 (Dr. Smith)...
 * Patient ID: 101, Name: Alice is now seeing Dr. Smith.
 * 
 * Enter your choice: 5
 * Enter Doctor ID: 201
 * Queue for Doctor ID 201 (Dr. Smith):
 * - Patient ID: 103, Name: Charlie
 * 
 * Enter your choice: 6
 * Exiting Hospital Appointment System.
 * ```
 * 
 * **Evaluation:**
 * 
 * Your solution will be evaluated based on:
 * *   Correct implementation of all required functionalities.
 * *   Effective use of `Queue`, `ArrayList`/`List`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch`.
 * *   Adherence to object-oriented principles and best practices (encapsulation, naming, comments).
 * *   Robust error handling and input validation.
 * *   Code clarity and structure.
 * 
 * **Deliverable:**
 * 
 * Provide the complete, single Java source file for the application.
 *
 * EXPLANATION:
 * This solution implements a basic hospital appointment system demonstrating the required Java concepts.
 * 
 * **Structure:**
 * -   `Patient` class: Simple POJO (Plain Old Java Object) representing a patient with `id` and `name`.
 * -   `Doctor` class: Simple POJO representing a doctor with `id`, `name`, and `specialty`.
 * -   `HospitalSystem` class: Contains the main logic. It holds lists of all patients and doctors, and a map to manage the waiting queue (`Queue`) for each doctor. The `main` method resides here, creating an instance and running the system.
 * 
 * **Required Components Usage:**
 * 
 * 1.  **`Queue` (from `java.util.Queue`):** Used to manage the waiting list for each doctor. `java.util.LinkedList` is used as the concrete implementation because it efficiently supports the `Queue` operations (`offer` to add to the tail, `poll` to remove from the head, `peek` to view the head). A `Map<Integer, Queue<Patient>>` (`doctorQueues`) is used to associate each doctor's ID with their specific waiting queue.
 * 2.  **`ArrayList` (from `java.util.ArrayList`):** Used to store the master list of all registered `patients` and the list of available `doctors`.
 * 3.  **`List` interface (from `java.util.List`):** The `patients` and `doctors` fields are declared using the `List` interface type (`private List<Patient> patients;`, `private List<Doctor> doctors;`), promoting good practice by programming to the interface rather than the concrete implementation.
 * 4.  **`Scanner` for user input (from `java.util.Scanner`):** An instance of `Scanner` is created in the `runSystem` method to read user input from `System.in` for menu choices and operation parameters (patient/doctor IDs, patient name).
 * 5.  **`Switch` statement for flow control:** A `switch` statement in the `runSystem` method is used to handle the user's menu selection, directing the program flow to the appropriate operation based on the integer input.
 * 6.  **`System.err` for error messages:** Used throughout the `HospitalSystem` class to print error messages to the standard error stream when invalid operations are attempted (e.g., patient/doctor not found, queue is empty, invalid input format).
 * 7.  **`System.out` for normal output:** Used for displaying the menu, prompts for input, successful operation confirmations, and listing patients or queue contents.
 * 8.  **Class-wide exception handling with `try-catch` blocks:** The main `while` loop in the `runSystem` method, which drives the application's user interaction, is wrapped in a `try-catch` block. This demonstrates handling potential exceptions that might occur during the execution of the main application logic, such as `InputMismatchException` if the user enters non-numeric input where an integer is expected, or other unexpected runtime errors (`Exception`). A `finally` block ensures the `Scanner` is closed. Specific `hasNextInt()` checks are also used within the loop for more targeted input validation before attempting to read, preventing `InputMismatchException` in many cases, but the surrounding `try-catch` provides a fallback for less predictable errors.
 * 
 * **Best Practices:**
 * 
 * -   **Encapsulation:** Fields in `Patient`, `Doctor`, and `HospitalSystem` are declared `private`, and access is provided through `public` getter methods (or methods that perform operations like `addPatient`, `callNextPatientFromQueue`).
 * -   **Meaningful Names:** Classes (`Patient`, `Doctor`, `HospitalSystem`), variables (`patients`, `doctors`, `doctorQueues`, `nextPatientId`, `patientIdForQueue`), and methods (`addPatient`, `findDoctorById`, `callNextPatientFromQueue`, `displayMenu`) have names that clearly indicate their purpose.
 * -   **Comments and Documentation:** Basic comments explain the purpose of classes, fields, and methods. JavaDocs are used for method descriptions.
 * -   **Input Validation:** Checks are performed before processing input, such as checking if the entered menu choice is within the valid range, verifying if patient/doctor IDs exist using `findPatientById` and `findDoctorById`, and using `hasNextInt()` to check for non-numeric input before reading with `nextInt()`. Patient names are also validated for emptiness.
 * -   **Proper Error Handling:** Specific error messages are printed to `System.err` for various failure conditions. The `try-catch` block handles unexpected errors gracefully, preventing the program from crashing immediately and providing some diagnostic output (`printStackTrace`).
 * -   **Clean Code Structure:** The code is organized into classes with clear responsibilities. Methods are relatively short and focused on a single task. The `runSystem` method orchestrates the main loop and calls other methods to perform specific actions. Initial data is set up in a dedicated `initializeData` method.
 * 
 * This solution effectively integrates the required Java components into a functional program that simulates a real-world scenario, while adhering to important programming principles and demonstrating robust error handling.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// Represents a Patient
class Patient {
    private int id;
    private String name;

    public Patient(int id, String name) {
        this.id = id;
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
        return "Patient ID: " + id + ", Name: " + name;
    }
}

// Represents a Doctor
class Doctor {
    private int id;
    private String name;
    private String specialty;

    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Specialty: " + specialty;
    }
}

// Main class managing the hospital system
public class HospitalSystem {
    // Use List interface, implemented by ArrayList
    private List<Patient> patients;
    private List<Doctor> doctors;
    // Map doctors to their waiting queues using Queue interface
    private Map<Integer, Queue<Patient>> doctorQueues;
    private int nextPatientId = 101; // Simple auto-incrementing ID

    public HospitalSystem() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        doctorQueues = new HashMap<>();
        initializeData();
    }

    // Initialize with some sample data
    private void initializeData() {
        // Add Doctors
        Doctor doc1 = new Doctor(201, "Dr. Smith", "Cardiology");
        Doctor doc2 = new Doctor(202, "Dr. Jones", "Pediatrics");
        doctors.add(doc1);
        doctors.add(doc2);

        // Initialize queues for doctors
        doctorQueues.put(doc1.getId(), new LinkedList<>()); // LinkedList implements Queue
        doctorQueues.put(doc2.getId(), new LinkedList<>());

        // Add Patients
        addPatient("Alice");
        addPatient("Bob");
        addPatient("Charlie");

        // Add some patients to queues initially
        addPatientToDoctorQueue(101, 201); // Alice to Dr. Smith
        addPatientToDoctorQueue(103, 201); // Charlie to Dr. Smith
        addPatientToDoctorQueue(102, 202); // Bob to Dr. Jones
    }

    // --- Core System Operations ---

    /**
     * Registers a new patient.
     * @param name The name of the patient.
     */
    public void addPatient(String name) {
        Patient newPatient = new Patient(nextPatientId++, name);
        patients.add(newPatient);
        System.out.println("Registered: " + newPatient);
    }

    /**
     * Finds a patient by their ID.
     * @param patientId The ID of the patient to find.
     * @return The Patient object if found, null otherwise.
     */
    private Patient findPatientById(int patientId) {
        for (Patient p : patients) {
            if (p.getId() == patientId) {
                return p;
            }
        }
        return null;
    }

    /**
     * Finds a doctor by their ID.
     * @param doctorId The ID of the doctor to find.
     * @return The Doctor object if found, null otherwise.
     */
    private Doctor findDoctorById(int doctorId) {
        for (Doctor d : doctors) {
            if (d.getId() == doctorId) {
                return d;
            }
        }
        return null;
    }

    /**
     * Adds a patient to a doctor's waiting queue.
     * @param patientId The ID of the patient.
     * @param doctorId The ID of the doctor.
     */
    public void addPatientToDoctorQueue(int patientId, int doctorId) {
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.err.println("Error: Patient with ID " + patientId + " not found.");
            return;
        }

        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.err.println("Error: Doctor with ID " + doctorId + " not found.");
            return;
        }

        Queue<Patient> queue = doctorQueues.get(doctorId);
        if (queue == null) {
            // This should not happen if initialization is correct, but good practice
            System.err.println("Error: Queue not found for Doctor ID " + doctorId + ".");
            return;
        }

        if (queue.contains(patient)) {
             System.err.println("Error: Patient ID " + patientId + " is already in Doctor ID " + doctorId + "'s queue.");
             return;
        }


        queue.offer(patient); // offer adds to the end of the queue
        System.out.println("Patient ID " + patientId + " added to Doctor ID " + doctorId + "'s queue.");
    }

    /**
     * Calls the next patient from a doctor's queue.
     * @param doctorId The ID of the doctor.
     */
    public void callNextPatientFromQueue(int doctorId) {
        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.err.println("Error: Doctor with ID " + doctorId + " not found.");
            return;
        }

        Queue<Patient> queue = doctorQueues.get(doctorId);
        if (queue == null) {
             System.err.println("Error: Queue not found for Doctor ID " + doctorId + ".");
             return;
        }

        System.out.println("Calling next patient for Doctor ID " + doctorId + " (" + doctor.getName() + ")...");
        Patient nextPatient = queue.poll(); // poll retrieves and removes the head of the queue

        if (nextPatient == null) {
            System.err.println("Error: Doctor ID " + doctorId + "'s queue is empty.");
        } else {
            System.out.println(nextPatient + " is now seeing " + doctor.getName() + ".");
        }
    }

    /**
     * Displays all registered patients.
     */
    public void viewAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        System.out.println("\n--- All Registered Patients ---");
        for (Patient p : patients) {
            System.out.println(p);
        }
        System.out.println("-----------------------------");
    }

    /**
     * Displays the waiting queue for a specific doctor.
     * @param doctorId The ID of the doctor.
     */
    public void viewDoctorQueue(int doctorId) {
        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.err.println("Error: Doctor with ID " + doctorId + " not found.");
            return;
        }

        Queue<Patient> queue = doctorQueues.get(doctorId);
         if (queue == null) {
             System.err.println("Error: Queue not found for Doctor ID " + doctorId + ".");
             return;
        }

        System.out.println("\n--- Queue for Doctor ID " + doctorId + " (" + doctor.getName() + ") ---");
        if (queue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Iterate without removing
            for (Patient p : queue) {
                System.out.println("- " + p);
            }
        }
        System.out.println("-------------------------------------------");
    }

     /**
     * Displays available doctors.
     */
    private void displayDoctors() {
         System.out.println("\n--- Available Doctors ---");
         if(doctors.isEmpty()) {
             System.out.println("No doctors available.");
         } else {
            for(Doctor d : doctors) {
                System.out.println(d);
            }
         }
         System.out.println("-------------------------");
    }

    /**
     * Displays the main menu.
     */
    private void displayMenu() {
        System.out.println("\n*** Hospital Appointment System ***");
        System.out.println("1. Register Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Patient to Doctor's Queue");
        System.out.println("4. Call Next Patient for Doctor");
        System.out.println("5. View Doctor's Queue");
        System.out.println("6. View Available Doctors"); // Added for convenience
        System.out.println("7. Exit"); // Exit option
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop.
     */
    public void runSystem() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Class-wide exception handling around the main operational loop
        try {
            while (choice != 7) { // Loop until user chooses Exit (option 7)
                displayMenu();

                // Input validation for menu choice
                if (!scanner.hasNextInt()) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Skip to the next iteration
                }

                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading int

                // Switch statement for flow control
                switch (choice) {
                    case 1:
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine();
                        if (name == null || name.trim().isEmpty()) {
                             System.err.println("Error: Patient name cannot be empty.");
                        } else {
                             addPatient(name);
                        }
                        break;
                    case 2:
                        viewAllPatients();
                        break;
                    case 3:
                        displayDoctors(); // Show doctors first
                        System.out.print("Enter Patient ID to add to queue: ");
                         if (!scanner.hasNextInt()) {
                            System.err.println("Invalid input. Please enter a numeric Patient ID.");
                            scanner.next();
                            break;
                        }
                        int patientIdForQueue = scanner.nextInt();
                        System.out.print("Enter Doctor ID for queue: ");
                         if (!scanner.hasNextInt()) {
                            System.err.println("Invalid input. Please enter a numeric Doctor ID.");
                            scanner.next();
                             scanner.nextLine(); // Consume remaining input
                            break;
                        }
                        int doctorIdForQueue = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        addPatientToDoctorQueue(patientIdForQueue, doctorIdForQueue);
                        break;
                    case 4:
                         displayDoctors(); // Show doctors first
                        System.out.print("Enter Doctor ID to call next patient: ");
                         if (!scanner.hasNextInt()) {
                            System.err.println("Invalid input. Please enter a numeric Doctor ID.");
                            scanner.next();
                             scanner.nextLine(); // Consume remaining input
                            break;
                        }
                        int doctorIdForCall = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        callNextPatientFromQueue(doctorIdForCall);
                        break;
                    case 5:
                         displayDoctors(); // Show doctors first
                        System.out.print("Enter Doctor ID to view queue: ");
                         if (!scanner.hasNextInt()) {
                            System.err.println("Invalid input. Please enter a numeric Doctor ID.");
                            scanner.next();
                             scanner.nextLine(); // Consume remaining input
                            break;
                        }
                        int doctorIdForView = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        viewDoctorQueue(doctorIdForView);
                        break;
                    case 6:
                        displayDoctors();
                        break;
                    case 7:
                        System.out.println("Exiting Hospital Appointment System.");
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            }
        } catch (InputMismatchException e) {
            // Catches non-integer input specifically if not handled by hasNextInt checks
            System.err.println("A serious input error occurred. Please restart the application.");
            e.printStackTrace(System.err); // Print stack trace to System.err
        } catch (Exception e) {
            // General catch-all for any other unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure scanner is closed regardless of how the loop exits or exceptions occur
            scanner.close();
        }
    }

    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        system.runSystem();
    }
}
