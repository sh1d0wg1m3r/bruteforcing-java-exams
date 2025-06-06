/*
 * Exam Question #496
 * Generated on: 2025-05-11 23:19:55
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment Management System
 * 
 * **Objective:** Implement a simplified hospital appointment management system that handles patient registration, doctor registration, appointment scheduling, and manages a waiting list for patients when doctors are unavailable.
 * 
 * **Requirements:**
 * 
 * 1.  **Classes:**
 *     *   `Patient`: Represents a patient with `id` (int), `name` (String), and `needsAppointment` (boolean, initially true).
 *     *   `Doctor`: Represents a doctor with `id` (int), `name` (String), `specialty` (String), and `isAvailable` (boolean, initially true).
 *     *   `Appointment`: Represents a scheduled appointment linking a `Patient` and a `Doctor`.
 *     *   `HospitalScheduler`: A central class managing lists of patients, doctors, and a waiting queue for appointments.
 * 
 * 2.  **`HospitalScheduler` Functionality:**
 *     *   Maintain a `List<Patient>` for all registered patients.
 *     *   Maintain a `List<Doctor>` for all registered doctors.
 *     *   Maintain a `Queue<Patient>` for patients waiting for an appointment because no doctor was available.
 *     *   `addPatient(String name)`: Creates a new `Patient` with a unique auto-generated ID and adds them to the patient list.
 *     *   `addDoctor(String name, String specialty)`: Creates a new `Doctor` with a unique auto-generated ID and adds them to the doctor list.
 *     *   `scheduleAppointment(int patientId)`:
 *         *   Find the patient by ID. If not found, output an error.
 *         *   If the patient is already scheduled or doesn't need an appointment (`needsAppointment` is false), output an error.
 *         *   Find the first available doctor (`isAvailable` is true).
 *         *   If a doctor is available:
 *             *   Create an `Appointment` object (you don't need to store appointments long-term for this task, just demonstrate creation).
 *             *   Mark the doctor as unavailable (`isAvailable = false`).
 *             *   Mark the patient as no longer needing an appointment (`needsAppointment = false`).
 *             *   Output a success message indicating the scheduled appointment.
 *         *   If no doctor is available:
 *             *   Add the patient to the `waitingQueue`.
 *             *   Output a message indicating the patient has been added to the waiting list.
 *     *   `releaseDoctor(int doctorId)`:
 *         *   Find the doctor by ID. If not found, output an error.
 *         *   If the doctor is already available, output an error.
 *         *   Mark the doctor as available (`isAvailable = true`).
 *         *   After releasing a doctor, immediately check the `waitingQueue`. If it's not empty, take the next patient from the queue and attempt to schedule them with this newly available doctor (call `scheduleAppointment` for the dequeued patient's ID).
 *     *   `displayPatients()`: Prints details of all registered patients.
 *     *   `displayDoctors()`: Prints details of all registered doctors.
 *     *   `displayWaitingQueue()`: Prints details of patients in the waiting queue.
 * 
 * 3.  **User Interface (in `main` method):**
 *     *   Use `Scanner` to get user input.
 *     *   Implement a menu-driven interface with the following options using a `switch` statement:
 *         1.  Add New Patient
 *         2.  Add New Doctor
 *         3.  Request Appointment (for a patient ID)
 *         4.  Release Doctor (by doctor ID)
 *         5.  Display All Patients
 *         6.  Display All Doctors
 *         7.  Display Waiting Queue
 *         8.  Exit
 *     *   The program should loop until the user chooses to exit.
 * 
 * 4.  **Error Handling and Best Practices:**
 *     *   Use `try-catch` blocks for robust error handling, especially around user input parsing (`Scanner.nextInt()`) and potential issues like patient/doctor not found.
 *     *   Output error messages to `System.err`.
 *     *   Output normal messages and menu to `System.out`.
 *     *   Implement proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include comments and documentation (simple inline or Javadoc).
 *     *   Validate user input (e.g., check if IDs are valid integers, if patients/doctors exist).
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, prompt the user for input, and perform the requested actions, providing feedback via `System.out` for successes and information, and `System.err` for errors.
 * 
 * Example interaction flow:
 * 1.  Add Patient "Alice" -> Output success.
 * 2.  Add Patient "Bob" -> Output success.
 * 3.  Add Doctor "Dr. Smith" "Cardiology" -> Output success.
 * 4.  Add Doctor "Dr. Jones" "Pediatrics" -> Output success.
 * 5.  Request Appointment for Alice (ID 1) -> Dr. Smith is available -> Output appointment scheduled with Dr. Smith. Dr. Smith is now unavailable.
 * 6.  Request Appointment for Bob (ID 2) -> Dr. Smith unavailable, Dr. Jones available -> Output appointment scheduled with Dr. Jones. Dr. Jones is now unavailable.
 * 7.  Request Appointment for Charlie (ID 3) -> Patient not found -> Output error to `System.err`.
 * 8.  Request Appointment for Alice (ID 1) -> Alice already has an appointment -> Output error to `System.err`.
 * 9.  Add Patient "Charlie" -> Output success.
 * 10. Request Appointment for Charlie (ID 3) -> Both doctors unavailable -> Output Charlie added to waiting queue.
 * 11. Display Waiting Queue -> Output Charlie is waiting.
 * 12. Release Doctor Smith (ID 1) -> Dr. Smith is released. Check waiting queue. Charlie is waiting. -> Attempt to schedule Charlie. Dr. Smith is available -> Output appointment scheduled with Dr. Smith. Dr. Smith is now unavailable again.
 * 13. Display Waiting Queue -> Output queue is empty.
 * 14. Display Doctors -> Output Dr. Jones (Unavailable), Dr. Smith (Unavailable).
 * 15. Exit -> Program ends.
 * 
 * Your solution must compile and run, demonstrating the correct usage of all specified Java components.
 * 
 * **Grading Focus:** Correctness of logic, proper use of required components, adherence to best practices, error handling, and clean code structure.
 *
 * EXPLANATION:
 * This solution implements the requested Hospital Appointment Management System, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Patient`, `Doctor`, and `Appointment` classes are simple data holders following encapsulation principles with private fields and public getters/setters where necessary. `AtomicInteger` is used to generate unique IDs safely.
 *     *   `HospitalScheduler` is the core class managing the system state (`patients`, `doctors`, `waitingQueue`) and the scheduling logic.
 * 
 * 2.  **Required Components Usage:**
 *     *   **`java.util.Queue`:** The `waitingQueue` field in `HospitalScheduler` is declared as a `Queue<Patient>` and implemented using `java.util.LinkedList`. `offer()` is used to add patients to the queue (when no doctor is available), and `poll()` is used to remove patients from the front of the queue (when a doctor is released). `peek()` is used to look at the next element without removing it.
 *     *   **`java.util.ArrayList`:** The `patients` and `doctors` lists are declared using the `List` interface and instantiated as `ArrayList<Patient>` and `ArrayList<Doctor>` respectively. `ArrayList` is suitable here as we need dynamic arrays for storing records and access elements by index or iterate.
 *     *   **`java.util.List`:** The `patients` and `doctors` fields are explicitly declared using the `List` interface type (`List<Patient>`, `List<Doctor>`). This is good practice as it allows flexibility to change the underlying implementation (e.g., to `LinkedList` or `Vector`) later if needed, without changing the code that uses the list interface methods.
 *     *   **`java.util.Scanner`:** Used in the `main` method within `HospitalApp` to read user input from `System.in` for menu choices and data entry (names, IDs, specialty).
 *     *   **`Switch statement`:** The `main` method uses a `switch` statement to handle the different menu options selected by the user, directing the program flow to the appropriate `HospitalScheduler` methods or actions.
 *     *   **`System.err`:** Used throughout the `HospitalApp` and `HospitalScheduler` classes to print error messages, such as invalid input, patient/doctor not found, or logical errors in scheduling (e.g., patient already scheduled).
 *     *   **`System.out`:** Used for printing the menu, success messages (patient/doctor added, appointment scheduled), and displaying lists of patients, doctors, and the waiting queue.
 *     *   **`try-catch` blocks:**
 *         *   A large `try-catch(Exception e)` block wraps the main `while` loop in `main` for general, top-level error handling.
 *         *   Specific `try-catch(InputMismatchException e)` blocks are used around `scanner.nextInt()` calls within the `switch` cases (for reading menu choice, patient ID, doctor ID) to handle non-integer input gracefully, preventing the program from crashing. The `finally` block is used to consume the leftover newline character after reading integers, preventing issues with subsequent `scanner.nextLine()` calls.
 *         *   Input validation checks (like null/empty names) are performed within `addPatient` and `addDoctor` methods. Checks for patient/doctor existence and scheduling conditions are done within `scheduleAppointment` and `releaseDoctor`. These logical errors result in messages printed to `System.err`.
 * 
 * 3.  **Logic and Functionality:**
 *     *   `addPatient` and `addDoctor` simply create objects and add them to their respective lists.
 *     *   `scheduleAppointment` finds the patient, validates their state, searches for an available doctor. If found, it updates states and prints success. If not, it adds the patient to the `waitingQueue`.
 *     *   `releaseDoctor` finds the doctor, validates their state, marks them available, and then calls `processWaitingQueue`.
 *     *   `processWaitingQueue` is triggered after a doctor is released. It repeatedly checks if the queue has patients AND if any doctor is available. If both conditions are true, it takes the next patient from the queue (`poll()`) and attempts to schedule them by calling `scheduleAppointment` again. This ensures waiting patients get scheduled as soon as a doctor becomes free.
 * 
 * 4.  **Best Practices:**
 *     *   **Encapsulation:** All class fields are `private`. Access and modification happen through public methods (`getters`, `setters`, or specific action methods like `scheduleAppointment`).
 *     *   **Meaningful Names:** Variable names (`patients`, `waitingQueue`, `availableDoctor`, `patientId`, `scheduleAppointment`, `releaseDoctor`) and class names clearly indicate their purpose.
 *     *   **Comments/Documentation:** Basic Javadoc comments are included for key methods in `HospitalScheduler`, explaining their function and parameters. Inline comments clarify specific code logic (like ID generation or queue processing).
 *     *   **Input Validation:** Checks for empty strings, non-numeric input, and existence of IDs are implemented.
 *     *   **Error Handling:** Specific exceptions (`InputMismatchException`) are caught, and logical errors are handled with clear messages to `System.err`. A general `try-catch` provides a fallback.
 *     *   **Clean Code Structure:** The code is organized into separate classes, each with a single responsibility. The main logic is separated from the UI/input handling in the `main` method. The `HospitalScheduler` class contains the core business logic.
 * 
 * This solution effectively integrates the required Java components into a practical scenario, demonstrating understanding of data structures, control flow, object-oriented principles, and error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger; // For unique IDs

// Represents a Patient
class Patient {
    private int id;
    private String name;
    private boolean needsAppointment;

    // Static counter for generating unique IDs
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public Patient(String name) {
        this.id = idCounter.incrementAndGet(); // Auto-generate unique ID
        this.name = name;
        this.needsAppointment = true; // Initially needs an appointment
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean needsAppointment() {
        return needsAppointment;
    }

    // Setter (only needsAppointment can be changed externally by scheduler)
    public void setNeedsAppointment(boolean needsAppointment) {
        this.needsAppointment = needsAppointment;
    }

    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Needs Appointment=" + needsAppointment + "]";
    }
}

// Represents a Doctor
class Doctor {
    private int id;
    private String name;
    private String specialty;
    private boolean isAvailable;

    // Static counter for generating unique IDs
    private static final AtomicInteger idCounter = new AtomicInteger(0);

    public Doctor(String name, String specialty) {
        this.id = idCounter.incrementAndGet(); // Auto-generate unique ID
        this.name = name;
        this.specialty = specialty;
        this.isAvailable = true; // Initially available
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

    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter (availability can be changed externally by scheduler)
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Doctor [ID=" + id + ", Name=" + name + ", Specialty=" + specialty + ", Available=" + isAvailable + "]";
    }
}

// Represents an Appointment (simple link for this task)
class Appointment {
    private Patient patient;
    private Doctor doctor;

    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "Appointment [Patient=" + patient.getName() + " (ID:" + patient.getId() + "), Doctor=" + doctor.getName() + " (ID:" + doctor.getId() + ")]";
    }
}

// Manages the hospital scheduling logic
class HospitalScheduler {
    // Use List interface, implemented by ArrayList
    private List<Patient> patients;
    private List<Doctor> doctors;
    // Use Queue interface, implemented by LinkedList
    private Queue<Patient> waitingQueue;

    public HospitalScheduler() {
        this.patients = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.waitingQueue = new LinkedList<>(); // LinkedList is a common Queue implementation
    }

    /**
     * Adds a new patient to the system.
     * @param name The name of the patient.
     */
    public void addPatient(String name) {
        if (name == null || name.trim().isEmpty()) {
             System.err.println("Error: Patient name cannot be empty.");
             return;
        }
        Patient newPatient = new Patient(name);
        patients.add(newPatient);
        System.out.println("Patient added: " + newPatient.getName() + " (ID: " + newPatient.getId() + ")");
    }

    /**
     * Adds a new doctor to the system.
     * @param name The name of the doctor.
     * @param specialty The specialty of the doctor.
     */
    public void addDoctor(String name, String specialty) {
         if (name == null || name.trim().isEmpty() || specialty == null || specialty.trim().isEmpty()) {
             System.err.println("Error: Doctor name and specialty cannot be empty.");
             return;
        }
        Doctor newDoctor = new Doctor(name, specialty);
        doctors.add(newDoctor);
        System.out.println("Doctor added: " + newDoctor.getName() + " (ID: " + newDoctor.getId() + ")");
    }

    /**
     * Finds a patient by their ID.
     * @param patientId The ID of the patient.
     * @return The Patient object, or null if not found.
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
     * @param doctorId The ID of the doctor.
     * @return The Doctor object, or null if not found.
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
     * Finds the first available doctor.
     * @return An available Doctor object, or null if none are available.
     */
    private Doctor findAvailableDoctor() {
        for (Doctor d : doctors) {
            if (d.isAvailable()) {
                return d;
            }
        }
        return null;
    }

    /**
     * Schedules an appointment for a patient.
     * If no doctor is available, the patient is added to the waiting queue.
     * @param patientId The ID of the patient requesting the appointment.
     */
    public void scheduleAppointment(int patientId) {
        Patient patient = findPatientById(patientId);

        if (patient == null) {
            System.err.println("Error: Patient with ID " + patientId + " not found.");
            return;
        }

        if (!patient.needsAppointment()) {
            System.err.println("Error: Patient " + patient.getName() + " (ID: " + patientId + ") does not currently need an appointment.");
            return;
        }

        Doctor availableDoctor = findAvailableDoctor();

        if (availableDoctor != null) {
            // Schedule the appointment
            Appointment appointment = new Appointment(patient, availableDoctor);
            availableDoctor.setAvailable(false); // Doctor becomes unavailable
            patient.setNeedsAppointment(false); // Patient no longer needs appointment for now
            System.out.println("Appointment scheduled: " + appointment);
        } else {
            // No doctor available, add to waiting queue
            // Check if already in waiting queue to prevent duplicates (optional but good)
            if (!waitingQueue.contains(patient)) {
                 waitingQueue.offer(patient); // Add to the end of the queue
                 System.out.println("No doctors available. Patient " + patient.getName() + " (ID: " + patient.getId() + ") added to waiting queue.");
            } else {
                 System.out.println("Patient " + patient.getName() + " (ID: " + patient.getId() + ") is already in the waiting queue.");
            }
        }
    }

    /**
     * Releases a doctor, making them available.
     * If the waiting queue is not empty, attempts to schedule the next waiting patient.
     * @param doctorId The ID of the doctor to release.
     */
    public void releaseDoctor(int doctorId) {
        Doctor doctor = findDoctorById(doctorId);

        if (doctor == null) {
            System.err.println("Error: Doctor with ID " + doctorId + " not found.");
            return;
        }

        if (doctor.isAvailable()) {
            System.err.println("Error: Doctor " + doctor.getName() + " (ID: " + doctorId + ") is already available.");
            return;
        }

        doctor.setAvailable(true); // Make doctor available
        System.out.println("Doctor " + doctor.getName() + " (ID: " + doctorId + ") is now available.");

        // After releasing a doctor, check the waiting queue
        processWaitingQueue();
    }

     /**
     * Processes the waiting queue, attempting to schedule the next patient if a doctor is available.
     */
    private void processWaitingQueue() {
        // Check if the queue is not empty AND there is an available doctor
        while (!waitingQueue.isEmpty() && findAvailableDoctor() != null) {
            Patient nextPatient = waitingQueue.peek(); // Get next patient without removing yet

            // Attempt to schedule the patient. scheduleAppointment handles finding the doctor and removing from queue logic implicitly
            // However, scheduleAppointment adds to queue if no doctor is found. We need to ensure we only try with the *current* available doctor or remove if successful.
            // A simpler approach: Take the patient, find *any* available doctor, schedule.
            Patient patientToSchedule = waitingQueue.poll(); // Remove from queue

            if (patientToSchedule != null) { // Should not be null if queue wasn't empty
                 System.out.println("Attempting to schedule patient from waiting queue: " + patientToSchedule.getName() + " (ID: " + patientToSchedule.getId() + ")");
                 // Call scheduleAppointment. It will find an available doctor (we know one exists because of the while condition)
                 // and mark the patient as not needing appointment.
                 scheduleAppointment(patientToSchedule.getId());
                 // Note: scheduleAppointment will print success or error if somehow no doctor is found (shouldn't happen with while condition)
            }
        }
         if (waitingQueue.isEmpty()) {
             System.out.println("Waiting queue is empty.");
         } else {
              System.out.println("Waiting queue still has patients, but no doctors are available.");
         }
    }


    /**
     * Displays all registered patients.
     */
    public void displayPatients() {
        System.out.println("\n--- Registered Patients ---");
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
        System.out.println("---------------------------\n");
    }

    /**
     * Displays all registered doctors.
     */
    public void displayDoctors() {
        System.out.println("\n--- Registered Doctors ---");
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
        } else {
            for (Doctor d : doctors) {
                System.out.println(d);
            }
        }
        System.out.println("---------------------------\n");
    }

    /**
     * Displays patients currently in the waiting queue.
     */
    public void displayWaitingQueue() {
        System.out.println("\n--- Appointment Waiting Queue ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue is empty.");
        } else {
            // Iterate without removing elements
            for (Patient p : waitingQueue) {
                System.out.println(p.getName() + " (ID: " + p.getId() + ")");
            }
        }
        System.out.println("-------------------------------\n");
    }
}

// Main class to run the application
public class HospitalApp {

    private static void printMenu() {
        System.out.println("--- Hospital Appointment System ---");
        System.out.println("1. Add New Patient");
        System.out.println("2. Add New Doctor");
        System.out.println("3. Request Appointment (Enter Patient ID)");
        System.out.println("4. Release Doctor (Enter Doctor ID)");
        System.out.println("5. Display All Patients");
        System.out.println("6. Display All Doctors");
        System.out.println("7. Display Waiting Queue");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalScheduler scheduler = new HospitalScheduler();

        // Class-wide exception handling for the main loop
        try {
            while (true) {
                printMenu();

                int choice = -1;
                // Input validation for menu choice
                try {
                    choice = scanner.nextInt();
                } catch (java.util.InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Go back to the beginning of the loop
                } finally {
                     // Consume the newline character left by nextInt()
                     scanner.nextLine();
                }


                // Using switch statement for flow control
                switch (choice) {
                    case 1: // Add New Patient
                        System.out.print("Enter patient name: ");
                        String patientName = scanner.nextLine();
                        scheduler.addPatient(patientName);
                        break;

                    case 2: // Add New Doctor
                        System.out.print("Enter doctor name: ");
                        String doctorName = scanner.nextLine();
                        System.out.print("Enter doctor specialty: ");
                        String doctorSpecialty = scanner.nextLine();
                        scheduler.addDoctor(doctorName, doctorSpecialty);
                        break;

                    case 3: // Request Appointment
                        System.out.print("Enter patient ID to request appointment: ");
                        int patientId = -1;
                        try {
                            patientId = scanner.nextInt();
                            scheduler.scheduleAppointment(patientId);
                        } catch (java.util.InputMismatchException e) {
                             System.err.println("Error: Invalid patient ID input. Please enter a number.");
                        } finally {
                             scanner.nextLine(); // Consume newline
                        }
                        break;

                    case 4: // Release Doctor
                        System.out.print("Enter doctor ID to release: ");
                         int doctorId = -1;
                        try {
                            doctorId = scanner.nextInt();
                            scheduler.releaseDoctor(doctorId);
                        } catch (java.util.InputMismatchException e) {
                             System.err.println("Error: Invalid doctor ID input. Please enter a number.");
                        } finally {
                            scanner.nextLine(); // Consume newline
                        }
                        break;

                    case 5: // Display All Patients
                        scheduler.displayPatients();
                        break;

                    case 6: // Display All Doctors
                        scheduler.displayDoctors();
                        break;

                    case 7: // Display Waiting Queue
                        scheduler.displayWaitingQueue();
                        break;

                    case 8: // Exit
                        System.out.println("Exiting Hospital Appointment System. Goodbye!");
                        return; // Exit the main method, ending the program

                    default: // Invalid choice
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 8.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions at the top level
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
            // Ensure scanner is closed
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}
