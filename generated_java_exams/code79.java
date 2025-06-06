/*
 * Exam Question #79
 * Generated on: 2025-05-11 22:10:02
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified Hospital Appointment Management System. The system should allow managing patients, doctors, and scheduling appointments. Due to limited resources, if an appointment cannot be immediately scheduled (e.g., the time slot is already taken by that doctor), it should be placed in a waiting list queue.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that provides the following functionalities via a command-line interface:
 * 
 * 1.  **Register Patient:** Add a new patient to the system. Patients have a unique ID (string) and a name (string).
 * 2.  **Register Doctor:** Add a new doctor to the system. Doctors have a unique ID (string), a name (string), and a specialization (string).
 * 3.  **Schedule Appointment:** Attempt to schedule an appointment for a patient with a specific doctor at a given time slot (string, e.g., "10:00 AM").
 *     *   Validate that the patient and doctor IDs exist.
 *     *   Check if the doctor is already booked for that specific time slot.
 *     *   If the slot is available, schedule the appointment.
 *     *   If the slot is *not* available, add the requested appointment to a waiting list queue.
 *     *   Prevent scheduling the *exact same* appointment (same patient, doctor, time) more than once, whether scheduled or on the waiting list.
 * 4.  **View Scheduled Appointments:** Display all currently scheduled appointments.
 * 5.  **View Waiting List:** Display all appointments currently in the waiting list queue.
 * 6.  **Exit:** Terminate the program.
 * 
 * **Technical Constraints:**
 * 
 * Your solution **must** utilize **ALL** of the following Java components:
 * 
 * *   `java.util.Queue`: To manage the appointment waiting list.
 * *   `java.util.ArrayList`: To store the registered patients and doctors.
 * *   `java.util.List`: Use `List` as the interface type when declaring collections of patients, doctors, and scheduled appointments.
 * *   `java.util.Scanner`: To read user input from the console.
 * *   `switch` statement: To handle the main menu navigation.
 * *   `System.err`: To output error messages (e.g., invalid input, patient/doctor not found, scheduling conflicts).
 * *   `System.out`: To output normal program messages (menu, successful operations, lists).
 * *   Class-wide exception handling with `try-catch` blocks: Implement robust error handling for potential issues like invalid input format or operational errors.
 * 
 * **Best Practices:**
 * 
 * *   Implement proper encapsulation (private fields, public methods/getters where appropriate).
 * *   Use meaningful variable and method names.
 * *   Include appropriate comments and documentation (Javadocs are a plus but not strictly required for every single method in an exam context, focus on clarity).
 * *   Perform input validation (e.g., checking if IDs exist, handling empty strings for IDs/names/time slots).
 * *   Structure the code clearly into appropriate classes (`Patient`, `Doctor`, `Appointment`, and a main system class).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu to the user and respond based on their input. Successful operations should be confirmed via `System.out`. Errors (like invalid IDs, booking conflicts) should be reported via `System.err`. Listing operations should print the details of the relevant objects.
 * 
 * **Example Interaction Snippet (Illustrative):**
 * 
 * ```
 * Hospital Appointment System Menu:
 * 1. Register Patient
 * 2. Register Doctor
 * 3. Schedule Appointment
 * 4. View Scheduled Appointments
 * 5. View Waiting List
 * 6. Exit
 * Enter your choice: 1
 * Enter patient ID: P001
 * Enter patient name: Alice Smith
 * Patient P001 registered successfully.
 * 
 * Enter your choice: 2
 * Enter doctor ID: D001
 * Enter doctor name: Dr. Jane Doe
 * Enter doctor specialization: Cardiology
 * Doctor D001 registered successfully.
 * 
 * Enter your choice: 3
 * Enter patient ID: P001
 * Enter doctor ID: D001
 * Enter time slot (e.g., 10:00 AM): 10:00 AM
 * Appointment scheduled for P001 with D001 at 10:00 AM.
 * 
 * Enter your choice: 3
 * Enter patient ID: P001
 * Enter doctor ID: D001
 * Enter time slot (e.g., 10:00 AM): 10:00 AM
 * Error: Doctor D001 is already booked at 10:00 AM. Appointment added to waiting list.
 * 
 * Enter your choice: 4
 * --- Scheduled Appointments ---
 * Patient: Alice Smith (P001), Doctor: Dr. Jane Doe (D001), Time: 10:00 AM
 * 
 * Enter your choice: 5
 * --- Waiting List ---
 * Patient: Alice Smith (P001), Doctor: Dr. Jane Doe (D001), Time: 10:00 AM
 * 
 * Enter your choice: 6
 * Exiting system.
 * ```
 * 
 * **Assessment Focus:**
 * 
 * *   Correct usage of all required Java components.
 * *   Implementation of the core scheduling and waiting list logic.
 * *   Robust error handling and input validation.
 * *   Adherence to object-oriented principles (encapsulation, class design).
 * *   Code clarity and maintainability.
 * 
 * Good luck!
 *
 * EXPLANATION:
 * This solution implements a basic Hospital Appointment Management System demonstrating the required Java concepts and best practices.
 * 
 * **Core Design:**
 * 
 * *   **Classes:** `Patient`, `Doctor`, and `Appointment` classes represent the core entities with private fields and public getters, adhering to encapsulation. `HospitalSystem` acts as the central manager, holding collections of these entities and implementing the system logic.
 * *   **Data Storage:**
 *     *   `List<Patient> patients`: An `ArrayList` is used to store patients. We declare it as `List` to program to the interface.
 *     *   `List<Doctor> doctors`: An `ArrayList` is used to store doctors, also declared as `List`.
 *     *   `List<Appointment> scheduledAppointments`: An `ArrayList` stores appointments that have been successfully scheduled. Declared as `List`.
 *     *   `Queue<Appointment> waitingList`: A `LinkedList` is used as the implementation for the `Queue` interface to manage appointments that couldn't be scheduled immediately. `LinkedList` is suitable as it efficiently supports queue operations (add to end, remove from front).
 * 
 * **Required Component Usage:**
 * 
 * 1.  **`Queue` (`java.util.Queue`)**: The `waitingList` is declared as `Queue<Appointment>` and instantiated as a `LinkedList`. The `offer()` method is used in `scheduleAppointment` to add an appointment to the waiting list when scheduling fails. The `viewWaitingList` method iterates through the queue using a for-each loop (which does not remove elements) to display its contents. The `contains()` method is used to check for duplicates.
 * 2.  **`ArrayList` (`java.util.ArrayList`)**: `ArrayList` is used as the concrete implementation for the `patients`, `doctors`, and `scheduledAppointments` lists. It provides dynamic resizing and efficient element access by index or iteration.
 * 3.  **`List` (`java.util.List`)**: The collections for patients, doctors, and scheduled appointments are declared using the `List` interface (`List<Patient>`, `List<Doctor>`, `List<Appointment>`). This is a best practice as it allows flexibility to change the underlying implementation (e.g., to `LinkedList`) without affecting the code that uses the interface methods.
 * 4.  **`Scanner` (`java.util.Scanner`)**: A `Scanner` object is created in the `main` method to read user input (menu choices, patient/doctor details, appointment details) from `System.in`. It is closed in the `finally` block to release resources.
 * 5.  **`switch` statement**: The `main` method uses a `switch` statement based on the user's menu choice (`int choice`) to direct the program flow to the corresponding functionality (register patient, schedule appointment, view lists, exit).
 * 6.  **`System.err`**: `System.err.println()` is used to print error messages to the standard error stream. This includes messages for invalid menu choices, `NumberFormatException` during input parsing, `HospitalSystemException` (e.g., patient/doctor not found, booking conflict, duplicate entry), and unexpected exceptions.
 * 7.  **`System.out`**: `System.out.println()` is used for all normal output, such as the menu, prompts for input, success messages (like successful registration or scheduling), and listing the contents of scheduled appointments and the waiting list.
 * 8.  **Class-wide Exception Handling (`try-catch`)**:
 *     *   The main `while` loop in the `main` method is wrapped in a `try-catch` block. This provides a top-level handler for any unexpected exceptions that might propagate up, preventing the program from crashing abruptly. It prints an error message to `System.err` and the stack trace for debugging.
 *     *   Specific `try-catch` blocks are used within the `switch` cases to handle expected errors related to user input or business logic (like `NumberFormatException` for the menu choice, and the custom `HospitalSystemException` for validation/business rules within the system methods). This allows the program to catch the error, report it using `System.err`, and continue running.
 * 
 * **Best Practices Implementation:**
 * 
 * *   **Encapsulation:** All fields in `Patient`, `Doctor`, and `Appointment` are `private`. Access is provided through public getters. The collections in `HospitalSystem` are also private, and operations are performed via public methods (`registerPatient`, `scheduleAppointment`, etc.). Helper methods like `findPatientById` are private as they are internal utilities.
 * *   **Meaningful Names:** Classes (`Patient`, `Doctor`, `Appointment`, `HospitalSystem`), variables (`patientId`, `scheduledAppointments`, `waitingList`), and methods (`registerPatient`, `scheduleAppointment`, `viewWaitingList`) have descriptive names.
 * *   **Input Validation:** Input strings are checked for null or emptiness (`trim().isEmpty()`) before creating objects or performing lookups. The menu choice input is explicitly parsed and handled with a `NumberFormatException` catch.
 * *   **Error Handling:** Custom `HospitalSystemException` is used for controlled business logic errors, providing specific messages. `System.err` is used for error output. `try-catch` blocks are strategically placed.
 * *   **Code Structure:** The code is organized into separate classes for different concerns. The `HospitalSystem` class manages the overall state and logic. The `main` method handles the user interface loop.
 * *   **Duplicate Prevention:** The `equals()` and `hashCode()` methods are overridden in `Patient`, `Doctor`, and `Appointment` classes.
 *     *   `Patient` and `Doctor` equality is based on their unique `id`.
 *     *   `Appointment` equality is based on the combination of `patient`, `doctor`, and `timeSlot`.
 *     *   The `appointmentExists` helper method uses the `contains()` method of the `List` and `Queue` (which relies on `equals()`) to check if an identical appointment is already present before scheduling or adding to the waiting list.
 * 
 * This solution effectively integrates the required Java components into a functional system while demonstrating robust error handling, input validation, and object-oriented design principles.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue and List
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Objects; // For Objects.equals and Objects.hash

// Custom exception for business logic errors
class HospitalSystemException extends Exception {
    public HospitalSystemException(String message) {
        super(message);
    }
}

class Patient {
    private String id;
    private String name;

    public Patient(String id, String name) throws HospitalSystemException {
        if (id == null || id.trim().isEmpty() || name == null || name.trim().isEmpty()) {
            throw new HospitalSystemException("Patient ID and name cannot be empty.");
        }
        this.id = id.trim();
        this.name = name.trim();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Doctor {
    private String id;
    private String name;
    private String specialization;

    public Doctor(String id, String name, String specialization) throws HospitalSystemException {
        if (id == null || id.trim().isEmpty() || name == null || name.trim().isEmpty() || specialization == null || specialization.trim().isEmpty()) {
            throw new HospitalSystemException("Doctor ID, name, and specialization cannot be empty.");
        }
        this.id = id.trim();
        this.name = name.trim();
        this.specialization = specialization.trim();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return name + " (" + id + ") [" + specialization + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String timeSlot;

    public Appointment(Patient patient, Doctor doctor, String timeSlot) throws HospitalSystemException {
        if (patient == null || doctor == null || timeSlot == null || timeSlot.trim().isEmpty()) {
             throw new HospitalSystemException("Patient, Doctor, and Time Slot cannot be null or empty.");
        }
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot.trim();
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Patient: " + patient.getName() + " (" + patient.getId() + "), Doctor: " + doctor.getName() + " (" + doctor.getId() + "), Time: " + timeSlot;
    }

    // Custom equals and hashCode based on patient, doctor, and timeSlot
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(patient, that.patient) &&
               Objects.equals(doctor, that.doctor) &&
               Objects.equals(timeSlot, that.timeSlot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, doctor, timeSlot);
    }
}

class HospitalSystem {
    // Use List interface type, implemented by ArrayList
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> scheduledAppointments;

    // Use Queue interface type, implemented by LinkedList
    private Queue<Appointment> waitingList;

    public HospitalSystem() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.scheduledAppointments = new ArrayList<>();
        this.waitingList = new LinkedList<>(); // LinkedList is a common Queue implementation
    }

    /**
     * Finds a patient by ID.
     * @param patientId The ID of the patient to find.
     * @return The Patient object if found, null otherwise.
     */
    private Patient findPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getId().equals(patientId)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Finds a doctor by ID.
     * @param doctorId The ID of the doctor to find.
     * @return The Doctor object if found, null otherwise.
     */
    private Doctor findDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getId().equals(doctorId)) {
                return d;
            }
        }
        return null;
    }

    /**
     * Checks if a doctor is already booked at a specific time slot.
     * @param doctor The doctor to check.
     * @param timeSlot The time slot to check.
     * @return true if the doctor is booked, false otherwise.
     */
    private boolean isDoctorBooked(Doctor doctor, String timeSlot) {
        for (Appointment app : scheduledAppointments) {
            if (app.getDoctor().equals(doctor) && app.getTimeSlot().equals(timeSlot)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if an identical appointment already exists (scheduled or on waiting list).
     * @param appointment The appointment to check.
     * @return true if an identical appointment exists, false otherwise.
     */
    private boolean appointmentExists(Appointment appointment) {
        // Check scheduled appointments
        if (scheduledAppointments.contains(appointment)) {
            return true;
        }
        // Check waiting list
        if (waitingList.contains(appointment)) {
            return true;
        }
        return false;
    }


    /**
     * Registers a new patient.
     * @param id Patient ID.
     * @param name Patient name.
     * @throws HospitalSystemException if ID or name is empty, or patient ID already exists.
     */
    public void registerPatient(String id, String name) throws HospitalSystemException {
         if (findPatientById(id) != null) {
            throw new HospitalSystemException("Patient with ID " + id + " already exists.");
        }
        patients.add(new Patient(id, name));
    }

    /**
     * Registers a new doctor.
     * @param id Doctor ID.
     * @param name Doctor name.
     * @param specialization Doctor specialization.
     * @throws HospitalSystemException if ID, name, or specialization is empty, or doctor ID already exists.
     */
    public void registerDoctor(String id, String name, String specialization) throws HospitalSystemException {
        if (findDoctorById(id) != null) {
            throw new HospitalSystemException("Doctor with ID " + id + " already exists.");
        }
        doctors.add(new Doctor(id, name, specialization));
    }

    /**
     * Schedules an appointment or adds it to the waiting list.
     * @param patientId Patient ID.
     * @param doctorId Doctor ID.
     * @param timeSlot Time slot for the appointment.
     * @throws HospitalSystemException if patient or doctor not found, or invalid input.
     */
    public void scheduleAppointment(String patientId, String doctorId, String timeSlot) throws HospitalSystemException {
        if (patientId == null || patientId.trim().isEmpty() || doctorId == null || doctorId.trim().isEmpty() || timeSlot == null || timeSlot.trim().isEmpty()) {
             throw new HospitalSystemException("Patient ID, Doctor ID, and Time Slot cannot be empty.");
        }

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            throw new HospitalSystemException("Patient with ID " + patientId + " not found.");
        }

        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            throw new HospitalSystemException("Doctor with ID " + doctorId + " not found.");
        }

        // Create a potential appointment object
        Appointment newAppointment = new Appointment(patient, doctor, timeSlot);

        // Check if this exact appointment already exists anywhere
        if (appointmentExists(newAppointment)) {
             throw new HospitalSystemException("Appointment for Patient " + patient.getName() + " with Doctor " + doctor.getName() + " at " + timeSlot + " already exists (scheduled or on waiting list).");
        }


        if (isDoctorBooked(doctor, timeSlot)) {
            // Doctor is booked, add to waiting list
            waitingList.offer(newAppointment); // offer is preferred over add for queues (returns false instead of exception)
            throw new HospitalSystemException("Doctor " + doctor.getName() + " is already booked at " + timeSlot + ". Appointment added to waiting list."); // Throw to signal it went to waiting list
        } else {
            // Doctor is available, schedule the appointment
            scheduledAppointments.add(newAppointment);
            System.out.println("Appointment scheduled for " + patient.getName() + " with " + doctor.getName() + " at " + timeSlot + ".");
        }
    }

    /**
     * Displays all scheduled appointments.
     */
    public void viewScheduledAppointments() {
        System.out.println("--- Scheduled Appointments ---");
        if (scheduledAppointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (int i = 0; i < scheduledAppointments.size(); i++) {
                System.out.println((i + 1) + ". " + scheduledAppointments.get(i));
            }
        }
    }

    /**
     * Displays all appointments in the waiting list.
     */
    public void viewWaitingList() {
        System.out.println("--- Waiting List ---");
        if (waitingList.isEmpty()) {
            System.out.println("Waiting list is empty.");
        } else {
            // Iterate through the queue without removing elements
            int index = 1;
            for (Appointment app : waitingList) {
                 System.out.println(index++ + ". " + app);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalSystem hospitalSystem = new HospitalSystem();
        boolean running = true;

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                System.out.println("\nHospital Appointment System Menu:");
                System.out.println("1. Register Patient");
                System.out.println("2. Register Doctor");
                System.out.println("3. Schedule Appointment");
                System.out.println("4. View Scheduled Appointments");
                System.out.println("5. View Waiting List");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                String inputChoice = scanner.nextLine();
                int choice = -1;

                // Input validation for menu choice
                try {
                    choice = Integer.parseInt(inputChoice);
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    continue; // Skip to next iteration
                }

                // Switch statement for menu navigation
                switch (choice) {
                    case 1: // Register Patient
                        try {
                            System.out.print("Enter patient ID: ");
                            String pId = scanner.nextLine();
                            System.out.print("Enter patient name: ");
                            String pName = scanner.nextLine();
                            hospitalSystem.registerPatient(pId, pName);
                            System.out.println("Patient " + pId + " registered successfully.");
                        } catch (HospitalSystemException e) {
                            System.err.println("Error registering patient: " + e.getMessage());
                        } catch (Exception e) {
                             System.err.println("An unexpected error occurred during patient registration: " + e.getMessage());
                        }
                        break;

                    case 2: // Register Doctor
                        try {
                            System.out.print("Enter doctor ID: ");
                            String dId = scanner.nextLine();
                            System.out.print("Enter doctor name: ");
                            String dName = scanner.nextLine();
                            System.out.print("Enter doctor specialization: ");
                            String dSpec = scanner.nextLine();
                            hospitalSystem.registerDoctor(dId, dName, dSpec);
                            System.out.println("Doctor " + dId + " registered successfully.");
                        } catch (HospitalSystemException e) {
                            System.err.println("Error registering doctor: " + e.getMessage());
                        } catch (Exception e) {
                             System.err.println("An unexpected error occurred during doctor registration: " + e.getMessage());
                        }
                        break;

                    case 3: // Schedule Appointment
                        try {
                            System.out.print("Enter patient ID: ");
                            String appId = scanner.nextLine();
                            System.out.print("Enter doctor ID: ");
                            String appdId = scanner.nextLine();
                            System.out.print("Enter time slot (e.g., 10:00 AM): ");
                            String appTime = scanner.nextLine();
                            hospitalSystem.scheduleAppointment(appId, appdId, appTime);
                            // Success message is printed inside scheduleAppointment if successful
                        } catch (HospitalSystemException e) {
                            // This catch block handles specific business logic errors like not found, already booked, already exists
                            System.err.println("Error scheduling appointment: " + e.getMessage());
                        } catch (Exception e) {
                             System.err.println("An unexpected error occurred during appointment scheduling: " + e.getMessage());
                        }
                        break;

                    case 4: // View Scheduled Appointments
                        hospitalSystem.viewScheduledAppointments();
                        break;

                    case 5: // View Waiting List
                        hospitalSystem.viewWaitingList();
                        break;

                    case 6: // Exit
                        running = false;
                        System.out.println("Exiting system.");
                        break;

                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 6.");
                }
            }
        } catch (Exception e) {
            // Catch any unhandled exceptions from the main loop execution
            System.err.println("An unexpected fatal error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            scanner.close(); // Ensure scanner is closed
        }
    }
}
