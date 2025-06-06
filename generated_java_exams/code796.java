/*
 * Exam Question #796
 * Generated on: 2025-05-12 16:42:09
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment & Waiting List System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified Hospital Appointment System. The system needs to manage doctors, patients, scheduled appointments, and a waiting list for patients who couldn't get an immediate appointment with their requested doctor.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that simulates this system with the following features:
 * 
 * 1.  **Data Management:**
 *     *   Maintain lists of `Doctor` objects and `Patient` objects.
 *     *   Maintain a list of `Appointment` objects.
 *     *   Maintain a waiting list for patients seeking appointments with specific doctors. This waiting list should function as a queue.
 * 
 * 2.  **Core Functionality (via a text-based menu):**
 *     *   **Add Doctor:** Allow adding new doctors with unique IDs, names, and specialties.
 *     *   **Add Patient:** Allow adding new patients with unique IDs and names.
 *     *   **Book Appointment:**
 *         *   Prompt for Patient ID and Doctor ID.
 *         *   Validate that both the patient and doctor exist.
 *         *   Assume a doctor can only handle a *maximum* of 3 appointments at any given time for simplicity.
 *         *   If the doctor has less than 3 existing appointments, create and add a new `Appointment` with status "Booked".
 *         *   If the doctor already has 3 appointments, add the patient's request to a waiting list specifically for that doctor. The waiting list should store the *Patient ID*.
 *     *   **View Doctors:** Display all registered doctors.
 *     *   **View Patients:** Display all registered patients.
 *     *   **View Appointments:** Display all scheduled appointments.
 *     *   **View Waiting List for Doctor:** Prompt for Doctor ID and display the Patient IDs currently in the waiting list for that doctor.
 *     *   **Exit:** Terminate the program.
 * 
 * 3.  **Technical Constraints & Requirements:**
 *     *   You **must** use **ALL** of the following Java components:
 *         *   `java.util.Queue` (for the waiting list)
 *         *   `java.util.ArrayList` (for storing doctors, patients, appointments)
 *         *   `java.util.List` interface (use it for method parameters/return types where appropriate, e.g., returning a list of doctors)
 *         *   `java.util.Scanner` (for all user input)
 *         *   `switch` statement (for handling the main menu options)
 *         *   `System.err` (for displaying *all* error messages, e.g., invalid input, ID not found, booking failed)
 *         *   `System.out` (for displaying *all* normal output, e.g., menu, prompts, lists, success messages)
 *         *   Class-wide exception handling using `try-catch` blocks. Implement a main `try-catch` block around the program's core loop to catch unexpected errors. Also, handle specific expected exceptions like input errors (`InputMismatchException`) within relevant sections.
 *     *   Implement proper encapsulation (private fields, public getters/setters where necessary, public methods for operations).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments explaining complex logic or class purpose.
 *     *   Implement input validation (e.g., checking for non-negative IDs, non-empty names/specialties, checking if IDs exist before booking).
 *     *   Structure your code into appropriate classes (`Doctor`, `Patient`, `Appointment`, and a main `HospitalSystem` class).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu to the user. Based on user input, it should perform the requested action, displaying results or error messages accordingly. Errors should be printed to `System.err`, and normal output/prompts to `System.out`.
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * --- Hospital System Menu ---
 * 1. Add Doctor
 * 2. Add Patient
 * 3. Book Appointment
 * 4. View Doctors
 * 5. View Patients
 * 6. View Appointments
 * 7. View Waiting List for Doctor
 * 8. Exit
 * Enter your choice: 1
 * Enter Doctor ID: 101
 * Enter Doctor Name: Dr. Smith
 * Enter Doctor Specialty: Cardiology
 * Doctor added successfully.
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 3
 * Enter Patient ID: 1
 * Enter Doctor ID: 101
 * Appointment booked successfully for Patient 1 with Doctor 101.
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 3
 * Enter Patient ID: 2
 * Enter Doctor ID: 101
 * Doctor 101 is fully booked. Patient 2 added to waiting list for Dr. Smith.
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 7
 * Enter Doctor ID: 101
 * Waiting list for Doctor 101 (Cardiology):
 * Patient ID: 2
 * 
 * --- Hospital System Menu ---
 * ...
 * Enter your choice: 8
 * Exiting system.
 * ```
 * 
 * Your solution should be a single Java file containing all necessary classes.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correctness and completeness of the implementation according to the requirements.
 * *   Effective use of all specified Java components.
 * *   Adherence to best practices (encapsulation, naming, comments, clean code).
 * *   Robustness through input validation and exception handling (`try-catch` and `System.err`).
 * *   Logical flow and structure.
 * 
 * ```java
 * // Your solution code will go here
 * ```
 *
 * EXPLANATION:
 * This solution implements the requested Hospital Appointment & Waiting List System, demonstrating the required Java concepts.
 * 
 * **Class Structure:**
 * 
 * *   `Doctor`, `Patient`, and `Appointment` classes are simple Plain Old Java Objects (POJOs) representing the core entities. They have private fields, a constructor, and public getters for encapsulation. `toString()` methods are included for easy printing.
 * *   `HospitalSystem` is the main class containing the application logic. It holds the collections (`ArrayList`s and `Map` of `Queue`s) and the `Scanner`.
 * 
 * **Required Components Usage:**
 * 
 * 1.  **`java.util.Queue`:** Used in the `doctorWaitingLists` `Map`. Each key (Doctor ID) maps to a `Queue<Integer>` (a `LinkedList` instance, as `LinkedList` implements `Queue`) storing the IDs of patients waiting for that specific doctor. The `offer()` method is used to add patients to the waiting list during booking if the doctor is full. The waiting list is iterated using a `for-each` loop (which internally uses an iterator) in `viewWaitingListForDoctor` to display contents without removing elements.
 * 2.  **`java.util.ArrayList`:** Used to store the main lists of `doctors`, `patients`, and `appointments`. `ArrayList` is suitable here for dynamic resizing and efficient access by index (though we primarily iterate or search).
 * 3.  **`java.util.List` interface:** Used in the `displayList` helper method's parameter (`List<T> items`). This demonstrates polymorphism – the method can accept any object that implements the `List` interface, such as our `ArrayList` instances (`doctors`, `patients`, `appointments`).
 * 4.  **`java.util.Scanner`:** An instance is created in the `HospitalSystem` constructor and used throughout the class to read user input from `System.in`. It's closed in a `finally` block to release resources.
 * 5.  **`switch` statement:** Used in the `run()` method to handle the different menu choices entered by the user, directing the program flow to the appropriate method (`addDoctor`, `addPatient`, etc.).
 * 6.  **`System.err`:** Used exclusively for printing error messages, such as invalid menu choices, invalid input types (`InputMismatchException`), non-positive IDs, empty strings, duplicate IDs, or when a required entity (patient/doctor) is not found during booking.
 * 7.  **`System.out`:** Used for printing the menu, prompts for input, success messages, and the formatted lists of doctors, patients, appointments, and waiting lists.
 * 8.  **Class-wide exception handling with `try-catch`:**
 *     *   A main `try-catch` block is placed around the `system.run()` call in the `main` method. This acts as a top-level handler for any uncaught exceptions that might propagate up, preventing the program from crashing abruptly and providing a generic error message to `System.err`.
 *     *   Specific `try-catch` blocks are used within methods like `addDoctor`, `addPatient`, `bookAppointment`, and `viewWaitingListForDoctor` to handle expected issues, primarily `InputMismatchException` when the user enters non-integer input where a number is expected. This allows the program to recover from bad input and continue the menu loop.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Fields in `Doctor`, `Patient`, and `Appointment` are `private`. Access is provided via public constructors and getters.
 * *   **Meaningful Names:** Variables (`patientId`, `doctorWaitingLists`), methods (`addDoctor`, `bookAppointment`, `findPatientById`), and classes (`HospitalSystem`, `Appointment`) have names that clearly indicate their purpose.
 * *   **Comments:** Javadoc-style comments explain the purpose of classes and methods. Inline comments clarify specific logic points, like the waiting list implementation detail.
 * *   **Input Validation:** Checks are performed for positive IDs, non-empty strings, and the existence of doctors/patients before attempting to book appointments. Error messages are printed to `System.err`.
 * *   **Error Handling:** `try-catch` blocks handle input errors and potential runtime issues. Specific error messages guide the user. `System.err` is used for all error output.
 * *   **Clean Code Structure:** The code is divided into logical classes. The `HospitalSystem` class separates data storage (`ArrayList`, `Map`, `Queue`) from the operational logic (menu handling, adding, booking, viewing). Helper methods (`findDoctorById`, `findPatientById`, `displayList`, `printMenu`, `closeScanner`) break down complex tasks into smaller, manageable functions.
 * 
 * **Booking Logic & Waiting List:**
 * 
 * The `bookAppointment` method implements the core logic:
 * 1.  Validate Patient and Doctor existence.
 * 2.  Count existing "Booked" appointments for the requested doctor using a stream filter.
 * 3.  If the count is less than `MAX_APPOINTMENTS_PER_DOCTOR`, a new "Booked" `Appointment` object is created and added to the `appointments` `ArrayList`.
 * 4.  If the doctor is full, the patient's ID is added to the specific doctor's `Queue` in the `doctorWaitingLists` map using `offer()`. A check prevents adding the same patient ID multiple times to the waiting list for the same doctor.
 * 
 * This solution effectively integrates the required Java components to build a functional, albeit simplified, system demonstrating advanced concepts like collection usage, exception handling, and basic object-oriented design.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Map; // To map doctors to their waiting lists
import java.util.HashMap; // HashMap implements Map

// --- Data Classes ---

/**
 * Represents a Doctor in the hospital system.
 */
class Doctor {
    private int id;
    private String name;
    private String specialty;

    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
    }

    // Getters
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
        return "ID: " + id + ", Name: " + name + ", Specialty: " + specialty;
    }
}

/**
 * Represents a Patient in the hospital system.
 */
class Patient {
    private int id;
    private String name;

    public Patient(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters
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

/**
 * Represents an Appointment in the hospital system.
 */
class Appointment {
    private int patientId;
    private int doctorId;
    private String status; // e.g., "Booked", "Waiting" (though waiting list uses Queue directly)

    public Appointment(int patientId, int doctorId, String status) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.status = status;
    }

    // Getters
    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Doctor ID: " + doctorId + ", Status: " + status;
    }
}

// --- Main System Class ---

/**
 * Manages the hospital's doctors, patients, appointments, and waiting lists.
 */
public class HospitalSystem {

    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Appointment> appointments;
    // Map to hold waiting lists for each doctor. Key: Doctor ID, Value: Queue of Patient IDs
    private Map<Integer, Queue<Integer>> doctorWaitingLists;
    private Scanner scanner;

    private static final int MAX_APPOINTMENTS_PER_DOCTOR = 3;

    public HospitalSystem() {
        doctors = new ArrayList<>();
        patients = new ArrayList<>();
        appointments = new ArrayList<>();
        doctorWaitingLists = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Main method to run the hospital system.
     * Includes class-wide exception handling.
     */
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        try {
            system.run();
        } catch (Exception e) {
            // Catch any unexpected exceptions at the top level
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
            // Ensure scanner is closed
            system.closeScanner();
        }
    }

    /**
     * Runs the main menu loop.
     */
    public void run() {
        int choice;
        do {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        addDoctor();
                        break;
                    case 2:
                        addPatient();
                        break;
                    case 3:
                        bookAppointment();
                        break;
                    case 4:
                        viewDoctors();
                        break;
                    case 5:
                        viewPatients();
                        break;
                    case 6:
                        viewAppointments();
                        break;
                    case 7:
                        viewWaitingListForDoctor();
                        break;
                    case 8:
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = 0; // Set choice to a non-exit value to continue loop
            } catch (Exception e) {
                // Catch specific exceptions thrown by methods if needed,
                // or let the main try-catch handle unexpected ones.
                System.err.println("An error occurred during operation: " + e.getMessage());
            }
            System.out.println(); // Add a blank line for readability
        } while (choice != 8);
    }

    /**
     * Adds a new doctor to the system.
     */
    private void addDoctor() {
        System.out.println("\n--- Add Doctor ---");
        int id;
        String name;
        String specialty;

        try {
            System.out.print("Enter Doctor ID: ");
            id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (id <= 0) {
                System.err.println("Doctor ID must be positive.");
                return;
            }
            if (findDoctorById(id) != null) {
                System.err.println("Doctor with ID " + id + " already exists.");
                return;
            }

            System.out.print("Enter Doctor Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.err.println("Doctor name cannot be empty.");
                return;
            }

            System.out.print("Enter Doctor Specialty: ");
            specialty = scanner.nextLine().trim();
            if (specialty.isEmpty()) {
                System.err.println("Doctor specialty cannot be empty.");
                return;
            }

            Doctor newDoctor = new Doctor(id, name, specialty);
            doctors.add(newDoctor);
            // Initialize an empty waiting list for the new doctor
            doctorWaitingLists.put(id, new LinkedList<>()); // LinkedList implements Queue
            System.out.println("Doctor added successfully.");

        } catch (InputMismatchException e) {
            System.err.println("Invalid input for Doctor ID. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.err.println("An error occurred while adding doctor: " + e.getMessage());
        }
    }

    /**
     * Adds a new patient to the system.
     */
    private void addPatient() {
        System.out.println("\n--- Add Patient ---");
        int id;
        String name;

        try {
            System.out.print("Enter Patient ID: ");
            id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (id <= 0) {
                System.err.println("Patient ID must be positive.");
                return;
            }
            if (findPatientById(id) != null) {
                System.err.println("Patient with ID " + id + " already exists.");
                return;
            }

            System.out.print("Enter Patient Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.err.println("Patient name cannot be empty.");
                return;
            }

            Patient newPatient = new Patient(id, name);
            patients.add(newPatient);
            System.out.println("Patient added successfully.");

        } catch (InputMismatchException e) {
            System.err.println("Invalid input for Patient ID. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.err.println("An error occurred while adding patient: " + e.getMessage());
        }
    }

    /**
     * Books an appointment or adds the patient to the waiting list.
     */
    private void bookAppointment() {
        System.out.println("\n--- Book Appointment ---");
        int patientId;
        int doctorId;

        try {
            System.out.print("Enter Patient ID: ");
            patientId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.print("Enter Doctor ID: ");
            doctorId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Patient patient = findPatientById(patientId);
            if (patient == null) {
                System.err.println("Patient with ID " + patientId + " not found.");
                return;
            }

            Doctor doctor = findDoctorById(doctorId);
            if (doctor == null) {
                System.err.println("Doctor with ID " + doctorId + " not found.");
                return;
            }

            // Count existing appointments for this doctor
            long bookedAppointmentsCount = appointments.stream()
                    .filter(app -> app.getDoctorId() == doctorId && app.getStatus().equals("Booked"))
                    .count();

            if (bookedAppointmentsCount < MAX_APPOINTMENTS_PER_DOCTOR) {
                // Doctor has availability, book the appointment
                Appointment newAppointment = new Appointment(patientId, doctorId, "Booked");
                appointments.add(newAppointment);
                System.out.println("Appointment booked successfully for Patient " + patientId + " with Doctor " + doctorId + " (" + doctor.getName() + ").");
            } else {
                // Doctor is fully booked, add to waiting list
                Queue<Integer> waitingList = doctorWaitingLists.get(doctorId);
                if (waitingList == null) {
                    // This should not happen if doctors are added correctly, but good practice to check
                    waitingList = new LinkedList<>();
                    doctorWaitingLists.put(doctorId, waitingList);
                }
                // Check if patient is already in the waiting list for this doctor
                if (waitingList.contains(patientId)) {
                     System.out.println("Patient " + patientId + " is already in the waiting list for Doctor " + doctor.getName() + ".");
                } else {
                    waitingList.offer(patientId); // Add patient ID to the queue
                    System.out.println("Doctor " + doctor.getName() + " is fully booked. Patient " + patientId + " (" + patient.getName() + ") added to waiting list.");
                }
            }

        } catch (InputMismatchException e) {
            System.err.println("Invalid input for ID. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.err.println("An error occurred while booking appointment: " + e.getMessage());
        }
    }

    /**
     * Displays all registered doctors.
     * Uses List interface for parameter.
     */
    private void viewDoctors() {
        System.out.println("\n--- Registered Doctors ---");
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
        } else {
            displayList(doctors); // Pass ArrayList, works because it implements List
        }
    }

    /**
     * Displays all registered patients.
     * Uses List interface for parameter.
     */
    private void viewPatients() {
        System.out.println("\n--- Registered Patients ---");
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            displayList(patients); // Pass ArrayList, works because it implements List
        }
    }

    /**
     * Displays all scheduled appointments.
     * Uses List interface for parameter.
     */
    private void viewAppointments() {
        System.out.println("\n--- Scheduled Appointments ---");
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            displayList(appointments); // Pass ArrayList, works because it implements List
        }
    }

    /**
     * Displays the waiting list for a specific doctor.
     */
    private void viewWaitingListForDoctor() {
        System.out.println("\n--- Waiting List for Doctor ---");
        int doctorId;
        try {
            System.out.print("Enter Doctor ID: ");
            doctorId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Doctor doctor = findDoctorById(doctorId);
            if (doctor == null) {
                System.err.println("Doctor with ID " + doctorId + " not found.");
                return;
            }

            Queue<Integer> waitingList = doctorWaitingLists.get(doctorId);
            if (waitingList == null || waitingList.isEmpty()) {
                System.out.println("No patients in the waiting list for Doctor " + doctor.getName() + ".");
            } else {
                System.out.println("Waiting list for Doctor " + doctor.getName() + " (" + doctor.getSpecialty() + "):");
                // Iterate through the queue without removing elements
                for (Integer patientId : waitingList) {
                    Patient patient = findPatientById(patientId);
                    if (patient != null) {
                        System.out.println("  Patient ID: " + patientId + " (" + patient.getName() + ")");
                    } else {
                         System.out.println("  Patient ID: " + patientId + " (Details not found)");
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.err.println("Invalid input for Doctor ID. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
        } catch (Exception e) {
            System.err.println("An error occurred while viewing waiting list: " + e.getMessage());
        }
    }

    /**
     * Helper method to find a doctor by ID.
     * @param id The doctor ID to search for.
     * @return The Doctor object if found, otherwise null.
     */
    private Doctor findDoctorById(int id) {
        for (Doctor doc : doctors) {
            if (doc.getId() == id) {
                return doc;
            }
        }
        return null;
    }

    /**
     * Helper method to find a patient by ID.
     * @param id The patient ID to search for.
     * @return The Patient object if found, otherwise null.
     */
    private Patient findPatientById(int id) {
        for (Patient pat : patients) {
            if (pat.getId() == id) {
                return pat;
            }
        }
        return null;
    }

    /**
     * Generic helper method to display elements of a List.
     * Demonstrates using the List interface.
     * @param items The list of items to display.
     * @param <T> The type of elements in the list.
     */
    private <T> void displayList(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    /**
     * Prints the main menu options.
     */
    private void printMenu() {
        System.out.println("--- Hospital System Menu ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Book Appointment");
        System.out.println("4. View Doctors");
        System.out.println("5. View Patients");
        System.out.println("6. View Appointments");
        System.out.println("7. View Waiting List for Doctor");
        System.out.println("8. Exit");
    }

    /**
     * Closes the scanner resource.
     */
    private void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
