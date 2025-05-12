/*
 * Exam Question #19
 * Generated on: 2025-05-11 21:38:21
 * 
 * QUESTION:
 * ## Complex Java Programming Exam Task: Hospital Appointment Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified Hospital Appointment Management System. The system needs to manage registered patients, handle appointment requests, and schedule appointments based on availability (represented by a queue of pending requests).
 * 
 * **Requirements:**
 * 
 * 1.  **Patient Management:**
 *     *   The system must maintain a list of registered patients. Each patient should have a unique ID (String), name (String), and a brief description of their ailment (String).
 *     *   Patients can be added to the system.
 * 
 * 2.  **Appointment Request:**
 *     *   Users can request an appointment for a registered patient with a specific doctor (represented by a String).
 *     *   Appointment requests are placed into a waiting queue.
 *     *   The system must validate that the requested patient ID exists in the registered patients list. If not, an error message should be displayed.
 * 
 * 3.  **Appointment Scheduling:**
 *     *   The system can schedule the next appointment from the waiting queue.
 *     *   Scheduled appointments are moved from the queue to a separate list of scheduled appointments.
 *     *   If the waiting queue is empty when scheduling is attempted, an appropriate message should be displayed.
 * 
 * 4.  **Viewing:**
 *     *   Users should be able to view the list of patients currently in the waiting queue.
 *     *   Users should be able to view the list of appointments that have been scheduled.
 * 
 * 5.  **User Interface:**
 *     *   The system should provide a command-line interface using `java.util.Scanner`.
 *     *   A menu should be displayed allowing the user to select actions:
 *         1.  Add New Patient
 *         2.  Request Appointment
 *         3.  Schedule Next Pending Appointment
 *         4.  View Pending Appointments Queue
 *         5.  View Scheduled Appointments List
 *         6.  Exit
 *     *   A `switch` statement must be used to handle the menu selections.
 * 
 * 6.  **Data Structures:**
 *     *   Use `java.util.Queue` to manage the pending appointment requests.
 *     *   Use `java.util.ArrayList` implementing the `java.util.List` interface to store registered patients and scheduled appointments.
 * 
 * 7.  **Error Handling & Output:**
 *     *   Use `System.out` for displaying the menu, success messages, and lists of patients/appointments.
 *     *   Use `System.err` for displaying error messages (e.g., patient not found, invalid input, queue empty).
 *     *   Implement class-wide exception handling using `try-catch` blocks, specifically handling potential issues like invalid user input (`InputMismatchException`) or custom application errors (like a `PatientNotFoundException`).
 * 
 * 8.  **Best Practices:**
 *     *   Use proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (at least for classes and key methods).
 *     *   Perform basic input validation where necessary.
 *     *   Maintain a clean code structure with separate classes for `Patient`, `Appointment`, and the main `AppointmentScheduler` logic.
 * 
 * **Task:**
 * 
 * Implement the complete Java program for this Hospital Appointment Management System according to the requirements above.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, displaying a menu, prompting for input based on the selection, and providing appropriate output or error messages. Examples:
 * 
 * *   Adding a patient: Prompt for ID, name, ailment; confirm addition.
 * *   Requesting an appointment: Prompt for patient ID and doctor; confirm request added to queue or display error if patient not found.
 * *   Scheduling: Confirm appointment scheduled or display error if queue is empty.
 * *   Viewing: Display contents of the queue or scheduled list, or indicate if they are empty.
 * *   Invalid input: Display error message to `System.err`.
 * *   Patient Not Found: Display error message to `System.err`.
 * 
 * **Deliverables:**
 * 
 * A single `.java` file containing all necessary classes (`Patient`, `Appointment`, `AppointmentScheduler`, and the main application class, e.g., `HospitalApp`).
 * 
 * ---
 *
 * EXPLANATION:
 * This solution implements a simplified Hospital Appointment Management System demonstrating the required Java concepts.
 * 
 * **Structure:**
 * 
 * The code is organized into four classes:
 * 
 * 1.  `Patient`: Represents a patient with basic attributes (ID, name, ailment). It includes a constructor, getters for encapsulation, and a `toString()` method for easy printing.
 * 2.  `Appointment`: Represents an appointment request or a scheduled appointment. It holds a `Patient` object, the doctor's name, and a simplified time slot. It also has a constructor, getters, and a `toString()` method.
 * 3.  `PatientNotFoundException`: A custom checked exception used to signal when a requested patient ID does not exist.
 * 4.  `AppointmentScheduler`: This is the core class managing the system's state and logic.
 *     *   It holds the data structures: `registeredPatients` (a `List<Patient>`), `pendingAppointments` (a `Queue<Appointment>`), and `scheduledAppointments` (a `List<Appointment>`). `ArrayList` is used for the `List` implementations, and `LinkedList` is used for the `Queue` (as `LinkedList` conveniently implements both `Queue` and `List`).
 *     *   It contains methods for adding patients, requesting appointments (which adds to the queue), scheduling appointments (taking from the queue and adding to the scheduled list), and listing the contents of the queue and scheduled list.
 *     *   The `findPatientById` helper method demonstrates searching within the `registeredPatients` list and throws the custom `PatientNotFoundException`.
 * 5.  `HospitalApp`: This class contains the `main` method and handles the user interaction loop.
 * 
 * **Required Components Usage:**
 * 
 * *   **`Queue` (from `java.util.Queue`):** The `pendingAppointments` field is declared as a `Queue<Appointment>` and initialized with a `LinkedList`. `offer()` is used to add new appointment requests to the tail of the queue, and `poll()` is used to retrieve and remove the appointment at the head of the queue when scheduling.
 * *   **`ArrayList` (from `java.util.ArrayList`):** The `registeredPatients` and `scheduledAppointments` fields are initialized using `new ArrayList<>()`. This provides dynamic arrays to store the lists of patients and scheduled appointments.
 * *   **`List` interface (from `java.util.List`):** The `registeredPatients` and `scheduledAppointments` fields are declared using the `List` interface type (`List<Patient>`, `List<Appointment>`), demonstrating programming to interfaces.
 * *   **`Scanner` (from `java.util.Scanner`):** A `Scanner` object is used in the `main` method of `HospitalApp` to read user input from the console (menu choices, patient details, appointment details). `scanner.nextInt()` reads integers, and `scanner.nextLine()` reads strings.
 * *   **`Switch statement`:** The `switch (choice)` block in the `main` method is used to direct the program flow based on the user's menu selection, calling the appropriate methods of the `AppointmentScheduler`.
 * *   **`System.err`:** Used to print error messages, such as "Invalid input," "Patient not found," or "No pending appointments." This distinguishes error output from normal program output.
 * *   **`System.out`:** Used for all normal program output, including the menu, prompts, confirmation messages, and the lists of patients and appointments.
 * *   **`try-catch` blocks:**
 *     *   A large `try-catch(Exception e)` block wraps the main `while` loop in `HospitalApp` to catch any unexpected runtime errors, demonstrating class-wide exception handling.
 *     *   A specific `try-catch(InputMismatchException e)` is used within the loop to handle cases where the user enters non-integer input for the menu choice.
 *     *   A `try-catch(PatientNotFoundException e)` block is used when calling `scheduler.requestAppointment()` to specifically handle the case where the user enters an invalid patient ID, printing the custom exception's message to `System.err`.
 *     *   A `finally` block ensures the `Scanner` is closed regardless of whether an exception occurred or the user exited normally.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Fields in `Patient`, `Appointment`, and `AppointmentScheduler` are `private`, and access is provided through public methods (constructors, getters, specific action methods like `addPatient`, `requestAppointment`, etc.).
 * *   **Meaningful Names:** Class names (`Patient`, `Appointment`, `AppointmentScheduler`), field names (`id`, `name`, `pendingAppointments`), and method names (`addPatient`, `scheduleNextAppointment`, `listPendingAppointments`) are descriptive of their purpose.
 * *   **Comments/Documentation:** Javadoc-style comments are used for classes and key public methods to explain their purpose, parameters, and return values or exceptions. Inline comments explain specific logic points.
 * *   **Input Validation:** Basic validation is included, such as checking for empty strings for crucial inputs (ID, name, ailment, doctor, time slot) and handling `InputMismatchException` for numeric input.
 * *   **Error Handling:** Specific exceptions (`InputMismatchException`, `PatientNotFoundException`) are caught and handled gracefully, providing informative messages to the user via `System.err`. A general `catch(Exception e)` provides a fallback for unhandled errors.
 * *   **Clean Code Structure:** The code is divided into logical classes, each with a single responsibility (representing an entity, managing the system logic, handling user interaction).
 * 
 * This solution effectively integrates all required Java components within a practical scenario, demonstrating advanced understanding of data structures, object-oriented principles, exception handling, and user interaction in Java.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue and List
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Custom exception for patient not found
class PatientNotFoundException extends Exception {
    public PatientNotFoundException(String message) {
        super(message);
    }
}

/**
 * Represents a patient in the hospital system.
 */
class Patient {
    private String id;
    private String name;
    private String ailment;

    /**
     * Constructs a new Patient object.
     * @param id The unique ID of the patient.
     * @param name The name of the patient.
     * @param ailment The ailment the patient has.
     */
    public Patient(String id, String name, String ailment) {
        this.id = id;
        this.name = name;
        this.ailment = ailment;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAilment() {
        return ailment;
    }

    /**
     * Returns a string representation of the Patient.
     * @return A string describing the patient.
     */
    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Ailment=" + ailment + "]";
    }
}

/**
 * Represents a scheduled or pending appointment.
 */
class Appointment {
    private Patient patient;
    private String doctor;
    private String timeSlot; // Simplified time representation

    /**
     * Constructs a new Appointment object.
     * @param patient The patient for the appointment.
     * @param doctor The doctor the appointment is with.
     * @param timeSlot The scheduled time slot (simplified).
     */
    public Appointment(Patient patient, String doctor, String timeSlot) {
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    /**
     * Returns a string representation of the Appointment.
     * @return A string describing the appointment.
     */
    @Override
    public String toString() {
        return "Appointment [Patient=" + patient.getName() + " (ID:" + patient.getId() + "), Doctor=" + doctor + ", Time=" + timeSlot + "]";
    }
}

/**
 * Manages patients, pending appointment requests, and scheduled appointments.
 */
class AppointmentScheduler {
    private List<Patient> registeredPatients;
    private Queue<Appointment> pendingAppointments;
    private List<Appointment> scheduledAppointments;

    /**
     * Constructs a new AppointmentScheduler.
     */
    public AppointmentScheduler() {
        // Use ArrayList for lists of patients and scheduled appointments
        this.registeredPatients = new ArrayList<>();
        this.scheduledAppointments = new ArrayList<>();
        // Use LinkedList as a Queue for pending appointments
        this.pendingAppointments = new LinkedList<>();
    }

    /**
     * Adds a new patient to the registered patients list.
     * @param patient The patient to add.
     */
    public void addPatient(Patient patient) {
        // Basic check for unique ID (optional but good practice)
        for (Patient p : registeredPatients) {
            if (p.getId().equals(patient.getId())) {
                System.err.println("Error: Patient with ID " + patient.getId() + " already exists.");
                return;
            }
        }
        registeredPatients.add(patient);
        System.out.println("Patient registered successfully: " + patient.getName());
    }

    /**
     * Finds a patient by their ID.
     * @param patientId The ID of the patient to find.
     * @return The Patient object if found.
     * @throws PatientNotFoundException if no patient with the given ID is found.
     */
    private Patient findPatientById(String patientId) throws PatientNotFoundException {
        for (Patient patient : registeredPatients) {
            if (patient.getId().equals(patientId)) {
                return patient;
            }
        }
        throw new PatientNotFoundException("Patient with ID " + patientId + " not found.");
    }

    /**
     * Requests an appointment for a patient. Adds the request to the pending queue.
     * @param patientId The ID of the patient requesting the appointment.
     * @param doctor The doctor for the appointment.
     * @param requestedTime A simplified representation of the requested time.
     * @throws PatientNotFoundException if the patient ID is not found.
     */
    public void requestAppointment(String patientId, String doctor, String requestedTime) throws PatientNotFoundException {
        Patient patient = findPatientById(patientId);
        Appointment appointment = new Appointment(patient, doctor, requestedTime);
        pendingAppointments.offer(appointment); // offer is preferred over add for queues (returns boolean)
        System.out.println("Appointment request added to queue for patient " + patient.getName());
    }

    /**
     * Schedules the next appointment from the pending queue.
     * Moves the appointment from pending to scheduled.
     */
    public void scheduleNextAppointment() {
        Appointment nextAppointment = pendingAppointments.poll(); // poll retrieves and removes the head, returns null if empty
        if (nextAppointment != null) {
            scheduledAppointments.add(nextAppointment);
            System.out.println("Successfully scheduled appointment: " + nextAppointment);
        } else {
            System.err.println("No pending appointments in the queue to schedule.");
        }
    }

    /**
     * Displays all pending appointments in the queue.
     */
    public void listPendingAppointments() {
        if (pendingAppointments.isEmpty()) {
            System.out.println("No pending appointments in the queue.");
            return;
        }
        System.out.println("--- Pending Appointments ---");
        // Iterate through the queue without removing elements
        for (Appointment appt : pendingAppointments) {
            System.out.println(appt);
        }
        System.out.println("----------------------------");
    }

    /**
     * Displays all scheduled appointments.
     */
    public void listScheduledAppointments() {
        if (scheduledAppointments.isEmpty()) {
            System.out.println("No appointments have been scheduled yet.");
            return;
        }
        System.out.println("--- Scheduled Appointments ---");
        for (Appointment appt : scheduledAppointments) {
            System.out.println(appt);
        }
        System.out.println("------------------------------");
    }

    /**
     * Displays all registered patients. (Optional, but helpful for testing)
     */
    public void listRegisteredPatients() {
         if (registeredPatients.isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }
        System.out.println("--- Registered Patients ---");
        for (Patient p : registeredPatients) {
            System.out.println(p);
        }
        System.out.println("---------------------------");
    }
}

/**
 * Main application class for the Hospital Appointment Management System.
 * Contains the main loop and user interaction logic.
 */
public class HospitalApp {

    public static void main(String[] args) {
        AppointmentScheduler scheduler = new AppointmentScheduler();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Hospital Appointment Management System ---");

        // Main application loop with class-wide try-catch
        try {
            while (true) {
                printMenu();

                int choice = -1;
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input
                    continue; // Skip to the next iteration
                }

                // Use switch statement for menu control
                switch (choice) {
                    case 1: // Add New Patient
                        System.out.println("\n--- Add New Patient ---");
                        System.out.print("Enter Patient ID: ");
                        String id = scanner.nextLine();
                         if (id.trim().isEmpty()) {
                            System.err.println("Patient ID cannot be empty.");
                            break;
                        }
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();
                         if (name.trim().isEmpty()) {
                            System.err.println("Patient Name cannot be empty.");
                            break;
                        }
                        System.out.print("Enter Patient Ailment: ");
                        String ailment = scanner.nextLine();
                         if (ailment.trim().isEmpty()) {
                            System.err.println("Patient Ailment cannot be empty.");
                            break;
                        }
                        Patient newPatient = new Patient(id, name, ailment);
                        scheduler.addPatient(newPatient);
                        break;

                    case 2: // Request Appointment
                        System.out.println("\n--- Request Appointment ---");
                        System.out.print("Enter Patient ID: ");
                        String patientId = scanner.nextLine();
                         if (patientId.trim().isEmpty()) {
                            System.err.println("Patient ID cannot be empty.");
                            break;
                        }
                        System.out.print("Enter Doctor's Name: ");
                        String doctor = scanner.nextLine();
                         if (doctor.trim().isEmpty()) {
                            System.err.println("Doctor's Name cannot be empty.");
                            break;
                        }
                        System.out.print("Enter Requested Time Slot (e.g., 10:00 AM): ");
                        String timeSlot = scanner.nextLine();
                         if (timeSlot.trim().isEmpty()) {
                            System.err.println("Time Slot cannot be empty.");
                            break;
                        }
                        try {
                            scheduler.requestAppointment(patientId, doctor, timeSlot);
                        } catch (PatientNotFoundException e) {
                            System.err.println(e.getMessage());
                        }
                        break;

                    case 3: // Schedule Next Pending Appointment
                        System.out.println("\n--- Schedule Next Appointment ---");
                        scheduler.scheduleNextAppointment();
                        break;

                    case 4: // View Pending Appointments Queue
                        System.out.println("\n--- View Pending Appointments ---");
                        scheduler.listPendingAppointments();
                        break;

                    case 5: // View Scheduled Appointments List
                        System.out.println("\n--- View Scheduled Appointments ---");
                        scheduler.listScheduledAppointments();
                        break;

                    case 6: // Exit
                        System.out.println("Exiting Hospital Appointment System. Goodbye!");
                        scanner.close(); // Close the scanner
                        return; // Exit the main method

                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                }
                System.out.println(); // Add a newline for readability
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions at the top level
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure scanner is closed even if an exception occurs
            if (scanner != null) {
                 scanner.close();
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("Please select an option:");
        System.out.println("1. Add New Patient");
        System.out.println("2. Request Appointment");
        System.out.println("3. Schedule Next Pending Appointment");
        System.out.println("4. View Pending Appointments Queue");
        System.out.println("5. View Scheduled Appointments List");
        System.out.println("6. Exit");
    }
}
