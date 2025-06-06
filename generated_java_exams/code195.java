/*
 * Exam Question #195
 * Generated on: 2025-05-11 22:29:53
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment Management System
 * 
 * **Objective:** Implement a simplified console-based Hospital Appointment Management System. This task requires you to demonstrate your understanding of fundamental Java data structures, control flow, input/output, and error handling.
 * 
 * **Scenario:**
 * You are developing a system for a small clinic. The system needs to manage patients, doctors, scheduled appointments, and a waiting list for patients who cannot be immediately scheduled with a busy doctor.
 * 
 * **Functionality Requirements:**
 * 
 * The system should provide the following menu-driven options to the user:
 * 
 * 1.  **Add New Patient:** Register a new patient with a unique ID, name, and age.
 * 2.  **Add New Doctor:** Register a new doctor with a unique ID, name, and specialty. Each doctor should have their own dedicated waiting list (queue) for appointment requests.
 * 3.  **Schedule Appointment Request:** Allow a patient to request an appointment with a specific doctor at a specific time slot.
 *     *   If the doctor is currently free (not assigned to a `currentAppointment`), schedule the appointment directly and assign it to the doctor.
 *     *   If the doctor is busy, add the appointment request to the *doctor's specific waiting list*.
 *     *   Validate that the patient and doctor IDs exist.
 * 4.  **Process Waiting Lists:** Attempt to schedule appointments for patients waiting in doctors' queues. Iterate through all doctors. If a doctor is not busy and their waiting queue is not empty, schedule the first request from their queue, assign the appointment to the doctor, and remove the request from the queue.
 * 5.  **List All Patients:** Display details of all registered patients.
 * 6.  **List All Doctors:** Display details of all registered doctors.
 * 7.  **List Scheduled Appointments:** Display details of all currently scheduled appointments.
 * 8.  **List Waiting List:** Display the waiting list (queue) for each doctor that has patients waiting.
 * 0.  **Exit:** Terminate the program.
 * 
 * **Technical Requirements:**
 * 
 * You **must** use the following Java components as specified:
 * 
 * *   `java.util.Queue`: To implement the waiting list for *each* doctor.
 * *   `java.util.ArrayList`: To store the main collections of patients and scheduled appointments.
 * *   `java.util.List`: Use this interface type when declaring variables that hold collections (e.g., `List<Patient> patients = new ArrayList<>();`).
 * *   `java.util.Scanner`: To read user input from the console for menu choices and data entry.
 * *   `switch` statement: To handle the main menu options.
 * *   `System.err`: To display error messages (e.g., invalid input, patient/doctor not found, scheduling issues).
 * *   `System.out`: To display menu, prompts, success messages, and list outputs.
 * *   Class-wide exception handling with `try-catch` blocks: Implement `try-catch` blocks in your main interaction loop to handle potential runtime errors, particularly related to user input parsing.
 * 
 * **Implementation Details:**
 * 
 * *   Create separate classes for `Patient`, `Doctor`, `Appointment`, and `AppointmentRequest`.
 * *   `Patient` should have fields like `id`, `name`, `age`.
 * *   `Doctor` should have fields like `id`, `name`, `specialty`, a `Queue` for its waiting list, and a field to hold its `currentAppointment` (or `null` if free).
 * *   `Appointment` should have fields like `appointmentId`, `patientId`, `doctorId`, `timeSlot` (use a simple String like "10:00-11:00").
 * *   `AppointmentRequest` should have fields like `requestId`, `patientId`, `doctorId`, `requestedTimeSlot`.
 * *   The main application logic should reside in a class (e.g., `HospitalSystem`) that manages the collections of patients, doctors, and appointments.
 * *   Use simple integer counters to generate unique IDs for patients, doctors, appointments, and requests.
 * *   Implement basic input validation (e.g., ensuring age is positive, checking if IDs exist before scheduling).
 * 
 * **Expected Output:**
 * 
 * *   The system should display a clear menu.
 * *   Upon selecting an option, it should prompt for necessary input.
 * *   Success messages should be printed using `System.out`.
 * *   Error messages (e.g., invalid choice, patient not found) should be printed using `System.err`.
 * *   Listing options should display the details of the respective entities in a readable format.
 * *   The program should exit gracefully when option 0 is selected.
 * 
 * **Constraints:**
 * 
 * *   A doctor can only handle one `currentAppointment` at a time.
 * *   Appointment time slots can be represented by simple strings; no complex time logic is required beyond matching strings.
 * 
 * **Grading Criteria:**
 * 
 * *   Correct usage of all required Java components.
 * *   Implementation of all required functionalities.
 * *   Proper data structure design and usage.
 * *   Effective use of `Scanner` for input and `switch` for control flow.
 * *   Appropriate use of `System.out` and `System.err`.
 * *   Robust error handling and input validation using `try-catch` and conditional checks.
 * *   Adherence to best practices (encapsulation, naming conventions, comments).
 * *   Code clarity and structure.
 * 
 * You are expected to write a single Java file containing all necessary classes and the `main` method to run the system.
 *
 * EXPLANATION:
 * The provided solution implements a simplified Hospital Appointment Management System based on the requirements. It demonstrates the usage of the specified Java components in a cohesive application.
 * 
 * **Class Structure:**
 * *   `Patient`, `Doctor`, `Appointment`, `AppointmentRequest`: These are simple data classes representing the core entities. They use private fields and public getters, adhering to encapsulation principles. The `Doctor` class is crucial as it contains the `Queue` for its specific waiting list and a field (`currentAppointment`) to track if it's busy.
 * *   `HospitalSystem`: This class contains the main logic for managing the system's data. It holds collections of patients (`ArrayList`), doctors (`HashMap` for easy lookup by ID, storing `Doctor` objects which contain their own queues), and scheduled appointments (`ArrayList`). It also manages ID generation and contains methods for each menu operation.
 * *   `HospitalManagementApp`: This class contains the `main` method, which serves as the entry point of the application. It sets up the `Scanner` and `HospitalSystem` instances and runs the main menu loop.
 * 
 * **Usage of Required Components:**
 * 
 * 1.  **`java.util.Queue`**: Used within the `Doctor` class (`private Queue<AppointmentRequest> waitingQueue = new LinkedList<>();`). Each doctor object maintains its own waiting list using a `LinkedList` which implements the `Queue` interface. Requests are added using `offer()` and retrieved/removed using `peek()` and `poll()` in the `processWaitingLists` method.
 * 2.  **`java.util.ArrayList`**: Used in the `HospitalSystem` class to store the main lists of `patients` (`List<Patient> patients = new ArrayList<>();`) and `scheduledAppointments` (`List<Appointment> scheduledAppointments = new ArrayList<>();`).
 * 3.  **`java.util.List` interface**: Used as the declared type for the `patients` and `scheduledAppointments` collections (`List<Patient>`, `List<Appointment>`), promoting good practice by programming to the interface rather than the specific implementation (`ArrayList`).
 * 4.  **`java.util.Scanner`**: An instance is created in the `main` method and passed to the relevant `HospitalSystem` methods (`addPatient`, `addDoctor`, `scheduleAppointmentRequest`) to read user input for different operations. `scanner.nextInt()` and `scanner.nextLine()` are used as needed, with `scanner.nextLine()` being used after `nextInt()` to consume the leftover newline character.
 * 5.  **`switch` statement**: Used in the `main` method's loop to control the program flow based on the user's menu choice. Each case corresponds to a menu option and calls the appropriate method in the `HospitalSystem` instance.
 * 6.  **`System.err`**: Used throughout the `HospitalSystem` methods (and in `main` for menu input errors) to print error messages to the standard error stream. This includes messages for invalid input, patient/doctor not found, age validation, etc.
 * 7.  **`System.out`**: Used for all normal program output, such as displaying the menu, prompts for input, success messages, and listing the contents of the collections.
 * 8.  **Class-wide exception handling with `try-catch`**: A `try-catch` block is used in the `main` method around the `scanner.nextInt()` call for reading the menu choice. This handles `InputMismatchException` if the user enters non-integer input, preventing the program from crashing and allowing it to prompt the user again. Specific input validation errors *within* the methods (like non-numeric age or non-existent IDs) are handled using conditional checks and printing to `System.err`, which is a common pattern for business logic validation versus unexpected input format errors.
 * 
 * **Functionality and Logic:**
 * *   **ID Generation:** Simple integer counters are used in `HospitalSystem` to assign unique, sequential IDs.
 * *   **Adding Entities:** `addPatient` and `addDoctor` methods handle user input and add new objects to the respective `ArrayList` or `Map`. Basic age validation is included in `addPatient`.
 * *   **Scheduling:** `scheduleAppointmentRequest` validates patient and doctor IDs. It checks the `isBusy()` status of the target `Doctor`. If busy, it creates an `AppointmentRequest` and adds it to the doctor's specific `waitingQueue` using `offer()`. If not busy, it creates an `Appointment`, adds it to the `scheduledAppointments` list (`ArrayList`), and sets the doctor's `currentAppointment`, making them busy.
 * *   **Processing Waiting Lists:** `processWaitingLists` iterates through all `Doctor` objects (obtained from the `doctorsMap.values()`). For each doctor, it checks if they are free (`!isBusy()`) and if their `waitingQueue` is not empty. If both conditions are met, it `peek()`s at the first request. It re-validates the patient/doctor exist (a robustness check) and, if valid, creates a new `Appointment`, adds it to `scheduledAppointments`, sets the doctor's `currentAppointment`, and `poll()`s the request from the queue.
 * *   **Listing:** Methods like `listPatients`, `listDoctors`, `listScheduledAppointments`, and `listWaitingList` iterate through the respective collections (`ArrayList` for patients/appointments, `Map.values()` for doctors, and the `Queue` within each doctor) and print the details using the `toString()` methods of the data classes.
 * 
 * **Best Practices:**
 * *   **Encapsulation:** Fields in data classes are `private`, accessed via `public` getters (and a setter for `currentAppointment` in `Doctor`).
 * *   **Meaningful Names:** Classes, variables, and methods have descriptive names (e.g., `waitingQueue`, `scheduleAppointmentRequest`, `findPatientById`).
 * *   **Comments and Documentation:** Basic comments explain the purpose of classes, methods, and key logic sections.
 * *   **Input Validation:** Checks are performed for positive age, existence of patient/doctor IDs, and numeric input formats using `try-catch`.
 * *   **Error Handling:** `System.err` is used for errors, and the `try-catch` in `main` handles input parsing exceptions gracefully.
 * *   **Clean Code Structure:** The code is organized into separate classes based on responsibility, making it modular and easier to understand. The `HospitalSystem` class centralizes the core logic and data management.
 * 
 * This solution effectively utilizes all the required Java components to build a functional, albeit simplified, system that demonstrates key programming concepts suitable for an advanced exam task.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// --- Data Classes ---

/**
 * Represents a patient in the hospital system.
 */
class Patient {
    private int id;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "Patient [ID=" + id + ", Name=" + name + ", Age=" + age + "]";
    }
}

/**
 * Represents a doctor in the hospital system.
 * Each doctor has a queue for waiting appointment requests.
 */
class Doctor {
    private int id;
    private String name;
    private String specialty;
    private Queue<AppointmentRequest> waitingQueue;
    private Appointment currentAppointment; // Represents the appointment the doctor is currently busy with

    public Doctor(int id, String name, String specialty) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.waitingQueue = new LinkedList<>(); // Use LinkedList as a Queue implementation
        this.currentAppointment = null; // Doctor is initially free
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }
    public Queue<AppointmentRequest> getWaitingQueue() { return waitingQueue; }
    public Appointment getCurrentAppointment() { return currentAppointment; }

    // Setter for current appointment
    public void setCurrentAppointment(Appointment currentAppointment) {
        this.currentAppointment = currentAppointment;
    }

    public boolean isBusy() {
        return this.currentAppointment != null;
    }

    @Override
    public String toString() {
        return "Doctor [ID=" + id + ", Name=" + name + ", Specialty=" + specialty + ", Busy=" + isBusy() + ", Waiting=" + waitingQueue.size() + "]";
    }
}

/**
 * Represents a scheduled appointment.
 */
class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String timeSlot; // Simple string representation

    public Appointment(int appointmentId, int patientId, int doctorId, String timeSlot) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.timeSlot = timeSlot;
    }

    // Getters
    public int getAppointmentId() { return appointmentId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getTimeSlot() { return timeSlot; }

    @Override
    public String toString() {
        return "Appointment [ID=" + appointmentId + ", PatientID=" + patientId + ", DoctorID=" + doctorId + ", Time=" + timeSlot + "]";
    }
}

/**
 * Represents a request for an appointment that might go into a waiting queue.
 */
class AppointmentRequest {
    private int requestId;
    private int patientId;
    private int doctorId;
    private String requestedTimeSlot; // Simple string representation

    public AppointmentRequest(int requestId, int patientId, int doctorId, String requestedTimeSlot) {
        this.requestId = requestId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.requestedTimeSlot = requestedTimeSlot;
    }

    // Getters
    public int getRequestId() { return requestId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getRequestedTimeSlot() { return requestedTimeSlot; }

    @Override
    public String toString() {
        return "Request [ID=" + requestId + ", PatientID=" + patientId + ", DoctorID=" + doctorId + ", Time=" + requestedTimeSlot + "]";
    }
}

// --- Main System Logic ---

/**
 * Manages the hospital's patients, doctors, appointments, and waiting lists.
 */
class HospitalSystem {
    private List<Patient> patients; // Using ArrayList
    private Map<Integer, Doctor> doctorsMap; // Using Map for easy doctor lookup by ID
    private List<Appointment> scheduledAppointments; // Using ArrayList

    // ID Counters
    private int patientIdCounter = 0;
    private int doctorIdCounter = 0;
    private int appointmentIdCounter = 0;
    private int requestIdCounter = 0;

    public HospitalSystem() {
        this.patients = new ArrayList<>();
        this.doctorsMap = new HashMap<>(); // Using HashMap for Map implementation
        this.scheduledAppointments = new ArrayList<>();
    }

    /**
     * Adds a new patient to the system.
     * Handles input using the provided Scanner.
     */
    public void addPatient(Scanner scanner) {
        System.out.println("--- Add New Patient ---");
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        int age = -1;
        System.out.print("Enter patient age: ");
        try {
            age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (age <= 0) {
                System.err.println("Error: Age must be a positive number.");
                return; // Exit method on validation failure
            }
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid age input. Please enter a number.");
            scanner.nextLine(); // Consume the invalid input
            return; // Exit method on input error
        }

        int id = ++patientIdCounter;
        Patient newPatient = new Patient(id, name, age);
        patients.add(newPatient); // Add to ArrayList
        System.out.println("Patient added successfully. " + newPatient);
    }

    /**
     * Adds a new doctor to the system.
     * Handles input using the provided Scanner.
     */
    public void addDoctor(Scanner scanner) {
        System.out.println("--- Add New Doctor ---");
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor specialty: ");
        String specialty = scanner.nextLine();

        int id = ++doctorIdCounter;
        Doctor newDoctor = new Doctor(id, name, specialty);
        doctorsMap.put(id, newDoctor); // Add to Map
        System.out.println("Doctor added successfully. " + newDoctor);
    }

    /**
     * Schedules an appointment request. If the doctor is busy, adds to the waiting queue.
     * Handles input using the provided Scanner.
     */
    public void scheduleAppointmentRequest(Scanner scanner) {
        System.out.println("--- Schedule Appointment Request ---");
        int patientId = -1;
        int doctorId = -1;
        String timeSlot = null;

        try {
            System.out.print("Enter Patient ID: ");
            patientId = scanner.nextInt();
            System.out.print("Enter Doctor ID: ");
            doctorId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter requested time slot (e.g., 10:00-11:00): ");
            timeSlot = scanner.nextLine();
        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid ID input. Please enter a number.");
            scanner.nextLine(); // Consume invalid input
            return;
        }

        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.err.println("Error: Patient with ID " + patientId + " not found.");
            return;
        }

        Doctor doctor = doctorsMap.get(doctorId);
        if (doctor == null) {
            System.err.println("Error: Doctor with ID " + doctorId + " not found.");
            return;
        }

        // Check if the doctor is currently busy with an appointment
        if (doctor.isBusy()) {
            // Doctor is busy, add request to waiting queue
            int reqId = ++requestIdCounter;
            AppointmentRequest request = new AppointmentRequest(reqId, patientId, doctorId, timeSlot);
            doctor.getWaitingQueue().offer(request); // Add to the doctor's specific Queue
            System.out.println("Doctor is busy. Appointment request added to waiting list. " + request);
        } else {
            // Doctor is free, schedule appointment directly
            int apptId = ++appointmentIdCounter;
            Appointment newAppointment = new Appointment(apptId, patientId, doctorId, timeSlot);
            scheduledAppointments.add(newAppointment); // Add to ArrayList
            doctor.setCurrentAppointment(newAppointment); // Set doctor as busy with this appointment
            System.out.println("Appointment scheduled successfully. " + newAppointment);
        }
    }

    /**
     * Processes the waiting lists for all doctors.
     * If a doctor is free and has requests, schedules the first one.
     */
    public void processWaitingLists() {
        System.out.println("--- Processing Waiting Lists ---");
        boolean scheduledFromQueue = false;

        // Iterate through all doctors managed in the Map
        for (Doctor doctor : doctorsMap.values()) {
            // Check if the doctor is free AND has patients waiting
            if (!doctor.isBusy() && !doctor.getWaitingQueue().isEmpty()) {
                // Peek at the first request without removing it yet
                AppointmentRequest nextRequest = doctor.getWaitingQueue().peek();

                // Validate if patient and doctor still exist (robustness)
                Patient patient = findPatientById(nextRequest.getPatientId());
                Doctor currentDoctor = doctorsMap.get(nextRequest.getDoctorId()); // Should be the same as 'doctor'

                if (patient != null && currentDoctor != null) {
                    // Found valid patient and doctor, schedule the appointment
                    Appointment scheduledAppt = new Appointment(
                            ++appointmentIdCounter,
                            patient.getId(),
                            currentDoctor.getId(),
                            nextRequest.getRequestedTimeSlot() // Use the requested time slot
                    );

                    scheduledAppointments.add(scheduledAppt); // Add to ArrayList
                    currentDoctor.setCurrentAppointment(scheduledAppt); // Set doctor as busy
                    currentDoctor.getWaitingQueue().poll(); // Remove the request from the Queue

                    System.out.println("--> Scheduled appointment from waiting list: " + scheduledAppt +
                                       " for Patient " + patient.getName() + " with Dr. " + currentDoctor.getName());
                    scheduledFromQueue = true;
                } else {
                    // Patient or Doctor not found for this request, remove request from queue
                    doctor.getWaitingQueue().poll();
                    System.err.println("--> Warning: Patient or Doctor for waiting request " + nextRequest.getRequestId() +
                                       " not found. Removing request from queue.");
                }
            }
        }

        if (!scheduledFromQueue) {
            System.out.println("No appointments scheduled from waiting lists at this time.");
        }
    }

    /**
     * Lists all registered patients.
     */
    public void listPatients() {
        System.out.println("--- All Patients ---");
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
        } else {
            // Iterate through the ArrayList of patients
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    /**
     * Lists all registered doctors.
     */
    public void listDoctors() {
        System.out.println("--- All Doctors ---");
        if (doctorsMap.isEmpty()) {
            System.out.println("No doctors registered.");
        } else {
            // Iterate through the values (Doctor objects) in the Map
            for (Doctor doctor : doctorsMap.values()) {
                System.out.println(doctor);
            }
        }
    }

    /**
     * Lists all scheduled appointments.
     */
    public void listScheduledAppointments() {
        System.out.println("--- Scheduled Appointments ---");
        if (scheduledAppointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            // Iterate through the ArrayList of scheduled appointments
            for (Appointment appointment : scheduledAppointments) {
                System.out.println(appointment);
            }
        }
    }

    /**
     * Lists the waiting queue for each doctor that has waiting requests.
     */
    public void listWaitingList() {
        System.out.println("--- Waiting Lists ---");
        boolean hasWaiting = false;
        // Iterate through all doctors to check their queues
        for (Doctor doctor : doctorsMap.values()) {
            Queue<AppointmentRequest> queue = doctor.getWaitingQueue();
            if (!queue.isEmpty()) {
                hasWaiting = true;
                System.out.println("Doctor " + doctor.getName() + " (ID: " + doctor.getId() + ") Waiting List:");
                // Iterate through the Queue elements (without removing)
                for (AppointmentRequest request : queue) {
                    System.out.println("  " + request);
                }
            }
        }
        if (!hasWaiting) {
            System.out.println("No patients in any waiting list.");
        }
    }

    // --- Helper Methods ---

    /**
     * Finds a patient by their ID.
     * @param id The patient ID to search for.
     * @return The Patient object if found, null otherwise.
     */
    private Patient findPatientById(int id) {
        // Iterate through the ArrayList to find the patient
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null; // Not found
    }

    // findDoctorById is implicitly handled by doctorsMap.get(id)
}

// --- Main Application Class ---

public class HospitalManagementApp {

    private static void printMenu() {
        System.out.println("\n--- Hospital Management System Menu ---");
        System.out.println("1. Add New Patient");
        System.out.println("2. Add New Doctor");
        System.out.println("3. Schedule Appointment Request");
        System.out.println("4. Process Waiting Lists");
        System.out.println("5. List All Patients");
        System.out.println("6. List All Doctors");
        System.out.println("7. List Scheduled Appointments");
        System.out.println("8. List Waiting Lists");
        System.out.println("0. Exit");
        System.out.println("---------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalSystem hospital = new HospitalSystem();

        while (true) {
            printMenu();
            int choice = -1;
            System.out.print("Enter your choice: ");

            // Class-wide exception handling for menu input
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number between 0 and 8.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                System.out.println(); // Add a blank line for readability
                continue; // Skip the rest of the loop iteration
            }

            // Use switch statement for menu flow control
            switch (choice) {
                case 1:
                    hospital.addPatient(scanner);
                    break;
                case 2:
                    hospital.addDoctor(scanner);
                    break;
                case 3:
                    hospital.scheduleAppointmentRequest(scanner);
                    break;
                case 4:
                    hospital.processWaitingLists();
                    break;
                case 5:
                    hospital.listPatients();
                    break;
                case 6:
                    hospital.listDoctors();
                    break;
                case 7:
                    hospital.listScheduledAppointments();
                    break;
                case 8:
                    hospital.listWaitingList();
                    break;
                case 0:
                    System.out.println("Exiting Hospital Management System. Goodbye!");
                    scanner.close(); // Close the scanner
                    return; // Exit the main method, terminating the program
                default:
                    System.err.println("Invalid choice. Please select a number from the menu.");
                    break;
            }
            System.out.println(); // Add a blank line after each operation for readability
        }
    }
}
