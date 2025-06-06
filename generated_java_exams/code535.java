/*
 * Exam Question #535
 * Generated on: 2025-05-11 23:26:13
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment Scheduler
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application for a hospital to manage patient records and schedule appointments. The system needs to keep track of registered patients and manage appointments in a first-in, first-out (FIFO) manner for processing.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that fulfills the following requirements:
 * 
 * 1.  **Classes:**
 *     *   `Patient`: Represents a patient with a unique integer ID, name, and age. Should have a constructor and public getter methods for its fields. Use private fields for encapsulation.
 *     *   `Appointment`: Represents an appointment with a reference to the `Patient` object, a description of the medical issue, and a scheduled time (simple String for this problem). Should have a constructor and public getter methods. Use private fields.
 *     *   `HospitalScheduler`: This class will manage the list of patients and the appointment queue.
 *         *   It must contain a private `List` field to store `Patient` objects. Use `ArrayList` as the concrete implementation.
 *         *   It must contain a private `Queue` field to store `Appointment` objects. Use an appropriate `Queue` implementation (e.g., `LinkedList` or `ArrayDeque`).
 *         *   Provide methods to:
 *             *   `addPatient(Patient patient)`: Adds a new patient to the list. Perform basic validation (e.g., ID > 0, name not null/empty).
 *             *   `scheduleAppointment(int patientId, String description, String time)`: Finds the patient by ID and adds a new `Appointment` to the queue. If the patient is not found, handle this gracefully.
 *             *   `processNextAppointment()`: Removes and returns the next appointment from the queue. Handle the case where the queue is empty.
 *             *   `listAllPatients()`: Prints details of all registered patients.
 *             *   `viewAppointmentQueue()`: Prints details of all appointments currently in the queue without removing them.
 *     *   A main class (e.g., `HospitalApp`) with a `main` method to run the application.
 * 
 * 2.  **User Interface:**
 *     *   The `main` method should present a menu to the user using `System.out`.
 *     *   Use `java.util.Scanner` to read user input (menu choices, patient details, appointment details).
 *     *   Use a `switch` statement to handle the user's menu selection.
 *     *   The menu options should include:
 *         1.  Add New Patient
 *         2.  Schedule Appointment
 *         3.  Process Next Appointment
 *         4.  List All Patients
 *         5.  View Appointment Queue
 *         6.  Exit
 *     *   The application should loop until the user chooses to exit.
 * 
 * 3.  **Error Handling & Output:**
 *     *   Use `System.err` to print error messages (e.g., invalid menu choice, patient not found, queue empty when processing).
 *     *   Use `System.out` for menu display, prompts, success messages, and data listings.
 *     *   Implement class-wide or method-specific `try-catch` blocks to handle potential exceptions (e.g., `NumberFormatException` for input, or custom handling for business logic errors like patient not found).
 * 
 * 4.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include basic comments where necessary to explain complex logic (though the code should be largely self-explanatory).
 *     *   Ensure proper encapsulation (private fields, public getters/methods).
 * 
 * **Expected Output:**
 * 
 * The program should interact with the user via the console, displaying menus, prompting for input, and printing results or error messages based on the user's actions. Example interactions:
 * 
 * ```
 * --- Hospital Scheduler Menu ---
 * 1. Add New Patient
 * 2. Schedule Appointment
 * 3. Process Next Appointment
 * 4. List All Patients
 * 5. View Appointment Queue
 * 6. Exit
 * Enter your choice: 1
 * Enter Patient ID: 101
 * Enter Patient Name: Alice Smith
 * Enter Patient Age: 30
 * Patient added successfully!
 * 
 * --- Hospital Scheduler Menu ---
 * ...
 * Enter your choice: 2
 * Enter Patient ID for appointment: 101
 * Enter Appointment Description: Fever check
 * Enter Appointment Time: 10:00 AM
 * Appointment scheduled for Alice Smith.
 * 
 * --- Hospital Scheduler Menu ---
 * ...
 * Enter your choice: 3
 * Processing next appointment...
 * Appointment processed: Patient ID: 101, Name: Alice Smith, Description: Fever check, Time: 10:00 AM
 * 
 * --- Hospital Scheduler Menu ---
 * ...
 * Enter your choice: 3
 * Error: No appointments in the queue to process.
 * 
 * --- Hospital Scheduler Menu ---
 * ...
 * Enter your choice: 4
 * --- Registered Patients ---
 * ID: 101, Name: Alice Smith, Age: 30
 * ID: 102, Name: Bob Johnson, Age: 45
 * ---------------------------
 * 
 * --- Hospital Scheduler Menu ---
 * ...
 * Enter your choice: 5
 * --- Current Appointment Queue ---
 * Appointment for Patient ID: 102, Name: Bob Johnson, Description: Follow-up, Time: 11:30 AM
 * -------------------------------
 * 
 * --- Hospital Scheduler Menu ---
 * ...
 * Enter your choice: 7
 * Error: Invalid menu choice. Please enter a number between 1 and 6.
 * 
 * --- Hospital Scheduler Menu ---
 * ...
 * Enter your choice: 6
 * Exiting Hospital Scheduler. Goodbye!
 * ```
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation and usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`.
 * *   Proper class design and encapsulation.
 * *   Correct implementation of menu-driven interaction.
 * *   Effective error handling for invalid input, patient not found, and empty queue.
 * *   Adherence to best practices (naming, comments, structure).
 * 
 * **Time Allotment:** 45-60 minutes.
 *
 * EXPLANATION:
 * This solution implements a simple hospital appointment scheduling system demonstrating the required Java concepts.
 * 
 * 1.  **Class Structure:**
 *     *   `Patient` and `Appointment` classes encapsulate data using private fields and provide public getter methods. They also include basic validation in their constructors and override `toString` for easy printing.
 *     *   `HospitalScheduler` manages the core logic. It holds a `List<Patient>` (implemented as `ArrayList`) and a `Queue<Appointment>` (implemented as `LinkedList`). Using the interface types (`List`, `Queue`) promotes flexibility.
 * 
 * 2.  **Required Java Components Usage:**
 *     *   **`java.util.Queue`**: The `appointments` field is declared as `Queue<Appointment>` and instantiated with `LinkedList`. The `offer()` method is used to add appointments (safer than `add` as it doesn't throw an exception if the queue is full, though not relevant for `LinkedList`), and `poll()` is used to remove and retrieve the next appointment, returning `null` if the queue is empty, which simplifies error handling for an empty queue.
 *     *   **`java.util.ArrayList`**: The `patients` field is declared as `List<Patient>` and instantiated with `ArrayList`. `ArrayList` is used for its dynamic size and efficient element access (though we primarily iterate).
 *     *   **`java.util.List`**: The `patients` field is declared using the `List` interface type, adhering to the principle of programming to interfaces rather than concrete implementations.
 *     *   **`java.util.Scanner`**: Used in the `main` method of `HospitalApp` to read user input from the console (`System.in`). `nextLine()` is used consistently after reading numbers to consume the newline character, preventing input issues in subsequent reads.
 *     *   **`switch` statement**: Used in the `main` method to control the program flow based on the user's menu choice.
 *     *   **`System.err`**: Used to print error messages, such as invalid menu choices, patient not found errors during scheduling, errors during patient/appointment creation due to invalid data, or trying to process an empty queue. This visually distinguishes errors from normal output.
 *     *   **`System.out`**: Used for all standard output, including the menu, prompts for input, success messages, and listing patient or appointment data.
 *     *   **`try-catch` blocks**:
 *         *   A top-level `try-catch` in the `main` loop handles potential `NumberFormatException` if the user enters non-integer input for the menu choice or numeric fields (ID, age). It also catches any other unexpected exceptions.
 *         *   The `addPatient` method includes a check for duplicate IDs and uses `System.err` for the error message.
 *         *   The `Patient` and `Appointment` constructors use `IllegalArgumentException` for basic data validation, caught by the calling code (in the `switch` cases).
 *         *   The `scheduleAppointment` method uses a `try-catch` block to handle the custom `PatientNotFoundException` if the `findPatientById` helper method returns `null`. It also catches `IllegalArgumentException` from the `Appointment` constructor.
 *         *   The `processNextAppointment` method checks if the result of `poll()` is `null` to determine if the queue is empty, printing an error message using `System.err` in that case.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Patient` and `Appointment` are `private`, accessed only through public getter methods.
 *     *   **Meaningful Names:** Classes, variables, and methods have descriptive names (`HospitalScheduler`, `addPatient`, `scheduleAppointment`, `patientId`, `description`).
 *     *   **Comments:** Basic comments are included to explain the purpose of classes, methods, and specific logic points (like using `poll()` or `nextLine()`).
 *     *   **Input Validation:** Basic validation is performed in the `Patient` and `Appointment` constructors using `IllegalArgumentException`. Patient ID duplication is also checked in `addPatient`.
 *     *   **Error Handling:** Multiple layers of error handling are implemented using `try-catch`, `System.err`, and checking return values (`poll()` returning `null`). A custom exception `PatientNotFoundException` is used for a specific business logic error.
 *     *   **Clean Code Structure:** The code is organized into separate classes, each with a single responsibility. The `main` method is kept clean by delegating logic to the `HospitalScheduler` methods. A helper method `printMenu` is used to keep the main loop cleaner.
 * 
 * This solution effectively combines the required Java features within a practical scenario, demonstrating understanding of data structures, object-oriented principles, user interaction, and robust error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.NoSuchElementException; // Although we'll use poll, good to know

// Custom exception for patient not found
class PatientNotFoundException extends Exception {
    public PatientNotFoundException(String message) {
        super(message);
    }
}

// Represents a patient
class Patient {
    private int id;
    private String name;
    private int age;

    public Patient(int id, String name, int age) {
        // Basic validation
        if (id <= 0) {
            throw new IllegalArgumentException("Patient ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty.");
        }
        if (age <= 0) {
             throw new IllegalArgumentException("Patient age must be positive.");
        }
        this.id = id;
        this.name = name.trim();
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

// Represents an appointment
class Appointment {
    private Patient patient;
    private String description;
    private String time;

    public Appointment(Patient patient, String description, String time) {
        if (patient == null) {
            throw new IllegalArgumentException("Appointment must be linked to a patient.");
        }
         if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment description cannot be null or empty.");
        }
         if (time == null || time.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment time cannot be null or empty.");
        }
        this.patient = patient;
        this.description = description.trim();
        this.time = time.trim();
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment for Patient " + patient.toString() + ", Description: " + description + ", Time: " + time;
    }
}

// Manages patients and appointments
class HospitalScheduler {
    private List<Patient> patients; // Using List interface type
    private Queue<Appointment> appointments; // Using Queue interface type

    public HospitalScheduler() {
        this.patients = new ArrayList<>(); // Concrete implementation
        this.appointments = new LinkedList<>(); // Concrete implementation for Queue
    }

    // Add a new patient to the list
    public void addPatient(Patient patient) {
        // Check if patient with same ID already exists (optional but good practice)
        for (Patient p : patients) {
            if (p.getId() == patient.getId()) {
                System.err.println("Error: Patient with ID " + patient.getId() + " already exists.");
                return; // Exit method if duplicate ID found
            }
        }
        this.patients.add(patient);
        System.out.println("Patient added successfully!");
    }

    // Find patient by ID
    private Patient findPatientById(int patientId) {
        for (Patient p : patients) {
            if (p.getId() == patientId) {
                return p;
            }
        }
        return null; // Patient not found
    }

    // Schedule a new appointment
    public void scheduleAppointment(int patientId, String description, String time) {
        try {
            Patient patient = findPatientById(patientId);
            if (patient == null) {
                // Throw custom exception if patient not found
                throw new PatientNotFoundException("Patient with ID " + patientId + " not found.");
            }

            Appointment newAppointment = new Appointment(patient, description, time);
            this.appointments.offer(newAppointment); // offer is safer than add (returns false on failure, doesn't throw)
            System.out.println("Appointment scheduled for " + patient.getName() + ".");

        } catch (PatientNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
             System.err.println("Error scheduling appointment: " + e.getMessage());
        }
    }

    // Process the next appointment in the queue
    public void processNextAppointment() {
        System.out.println("Processing next appointment...");
        // poll() retrieves and removes the head of the queue, returns null if queue is empty
        Appointment nextAppointment = this.appointments.poll();

        if (nextAppointment != null) {
            System.out.println("Appointment processed: " + nextAppointment.toString());
        } else {
            System.err.println("Error: No appointments in the queue to process.");
        }
    }

    // List all registered patients
    public void listAllPatients() {
        System.out.println("--- Registered Patients ---");
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
        } else {
            for (Patient p : patients) {
                System.out.println(p);
            }
        }
        System.out.println("---------------------------");
    }

    // View appointments currently in the queue
    public void viewAppointmentQueue() {
        System.out.println("--- Current Appointment Queue ---");
        if (appointments.isEmpty()) {
            System.out.println("No appointments in the queue.");
        } else {
             // Iterate through the queue without removing elements
            for (Appointment appt : appointments) {
                System.out.println(appt);
            }
        }
        System.out.println("-------------------------------");
    }
}

// Main application class
public class HospitalApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalScheduler scheduler = new HospitalScheduler();

        int choice = 0;
        while (choice != 6) {
            printMenu();
            System.out.print("Enter your choice: ");

            try {
                // Read the entire line and then parse as int
                // This helps consume the newline character left by nextInt()
                String inputLine = scanner.nextLine();
                choice = Integer.parseInt(inputLine);

                // Use switch for flow control
                switch (choice) {
                    case 1: // Add New Patient
                        System.out.print("Enter Patient ID: ");
                        int id = Integer.parseInt(scanner.nextLine()); // Use nextLine after parsing int
                        System.out.print("Enter Patient Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Patient Age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        try {
                            Patient newPatient = new Patient(id, name, age);
                            scheduler.addPatient(newPatient);
                        } catch (IllegalArgumentException e) {
                            System.err.println("Error creating patient: " + e.getMessage());
                        }
                        break;

                    case 2: // Schedule Appointment
                        System.out.print("Enter Patient ID for appointment: ");
                        int appId = Integer.parseInt(scanner.nextLine()); // Use nextLine after parsing int
                        System.out.print("Enter Appointment Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter Appointment Time: ");
                        String time = scanner.nextLine();
                        scheduler.scheduleAppointment(appId, description, time); // scheduleAppointment handles its own errors
                        break;

                    case 3: // Process Next Appointment
                        scheduler.processNextAppointment(); // processNextAppointment handles its own errors
                        break;

                    case 4: // List All Patients
                        scheduler.listAllPatients();
                        break;

                    case 5: // View Appointment Queue
                        scheduler.viewAppointmentQueue();
                        break;

                    case 6: // Exit
                        System.out.println("Exiting Hospital Scheduler. Goodbye!");
                        break;

                    default:
                        System.err.println("Error: Invalid menu choice. Please enter a number between 1 and 6.");
                        break;
                }
            } catch (NumberFormatException e) {
                // Catch non-integer input for menu or numeric fields
                System.err.println("Error: Invalid input. Please enter a valid number.");
                choice = 0; // Reset choice to prevent accidental exit if 6 was entered invalidly
            } catch (Exception e) {
                // Catch any other unexpected exceptions at the top level
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging
            }
             System.out.println(); // Add a blank line for better readability
        }

        scanner.close(); // Close the scanner when exiting
    }

    // Helper method to print the menu
    private static void printMenu() {
        System.out.println("--- Hospital Scheduler Menu ---");
        System.out.println("1. Add New Patient");
        System.out.println("2. Schedule Appointment");
        System.out.println("3. Process Next Appointment");
        System.out.println("4. List All Patients");
        System.out.println("5. View Appointment Queue");
        System.out.println("6. Exit");
    }
}
