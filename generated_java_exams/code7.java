/*
 * Exam Question #7
 * Generated on: 2025-05-11 21:28:54
 * 
 * QUESTION:
 * ## Java Programming Exam: Advanced Hospital Appointment Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified hospital appointment management system. The system should allow users to add new appointment requests to a queue, process these requests to schedule appointments, and view the list of scheduled appointments.
 * 
 * The system will operate via a text-based menu interface.
 * 
 * **Core Functionality:**
 * 
 * 1.  **Add Appointment Request:** Allow the user to input patient details (ID, Name) and desired appointment details (e.g., a simple description or preferred time slot represented as a string). This request should be added to a queue of pending requests.
 * 2.  **Process Next Request:** Take the oldest pending appointment request from the queue, "schedule" it (by adding it to a list of scheduled appointments), and confirm the scheduling. If the queue is empty, report that there are no requests to process.
 * 3.  **List Scheduled Appointments:** Display all appointments that have been successfully scheduled. If the list is empty, report that no appointments are scheduled.
 * 4.  **Exit:** Terminate the program.
 * 
 * **Technical Requirements:**
 * 
 * Your solution must strictly adhere to the following requirements:
 * 
 * 1.  **Data Structures:**
 *     *   Use `java.util.Queue` to manage pending appointment requests.
 *     *   Use `java.util.ArrayList` to store scheduled appointments.
 *     *   Declare the scheduled appointments collection using the `java.util.List` interface type.
 * 2.  **Input:** Use `java.util.Scanner` to read user input from the console.
 * 3.  **Control Flow:** Use a `switch` statement to handle the different menu options.
 * 4.  **Output:**
 *     *   Use `System.out` for displaying the menu, confirmations, and lists of appointments.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, queue empty when processing).
 * 5.  **Exception Handling:** Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential issues, particularly related to user input (e.g., non-integer input where an integer is expected) or unexpected runtime errors during processing.
 * 6.  **Object-Oriented Design:**
 *     *   Create appropriate classes to represent core entities (e.g., `Patient`, `Appointment`, `AppointmentRequest`, `HospitalSystem`).
 *     *   Implement proper encapsulation (private fields, public methods).
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadocs where applicable).
 *     *   Implement basic input validation (e.g., ensure patient ID is positive).
 *     *   Ensure clean code structure.
 * 
 * **Classes to Create:**
 * 
 * *   `Patient`: Should have at least `patientId` (int) and `name` (String).
 * *   `AppointmentRequest`: Should encapsulate a `Patient` and a `desiredTime` (String).
 * *   `Appointment`: Should encapsulate a `Patient` and a `scheduledTime` (String).
 * *   `HospitalSystem`: This class will contain the `main` method and manage the `Queue` of requests and the `List` of scheduled appointments. It will contain methods for adding requests, processing requests, listing appointments, and running the main menu loop.
 * 
 * **Input Format (example interaction):**
 * 
 * ```
 * --- Hospital Appointment System ---
 * 1. Add Appointment Request
 * 2. Process Next Request
 * 3. List Scheduled Appointments
 * 4. Exit
 * Enter your choice: 1
 * Enter Patient ID: 101
 * Enter Patient Name: Alice Smith
 * Enter Desired Time (e.g., "2023-10-27 10:00"): 2023-10-27 10:00
 * Appointment request added to queue.
 * 
 * --- Hospital Appointment System ---
 * 1. Add Appointment Request
 * 2. Process Next Request
 * 3. List Scheduled Appointments
 * 4. Exit
 * Enter your choice: 1
 * Enter Patient ID: 102
 * Enter Patient Name: Bob Johnson
 * Enter Desired Time (e.g., "2023-10-27 11:00"): 2023-10-27 11:00
 * Appointment request added to queue.
 * 
 * --- Hospital Appointment System ---
 * 1. Add Appointment Request
 * 2. Process Next Request
 * 3. List Scheduled Appointments
 * 4. Exit
 * Enter your choice: 2
 * Processing next request...
 * Request processed. Appointment scheduled for Patient ID 101 (Alice Smith) at 2023-10-27 10:00.
 * 
 * --- Hospital Appointment System ---
 * 1. Add Appointment Request
 * 2. Process Next Request
 * 3. List Scheduled Appointments
 * 4. Exit
 * Enter your choice: 3
 * --- Scheduled Appointments ---
 * Patient ID: 101, Name: Alice Smith, Scheduled Time: 2023-10-27 10:00
 * --- End of Scheduled Appointments ---
 * 
 * --- Hospital Appointment System ---
 * 1. Add Appointment Request
 * 2. Process Next Request
 * 3. List Scheduled Appointments
 * 4. Exit
 * Enter your choice: 5
 * Invalid choice. Please enter a number between 1 and 4.
 * 
 * --- Hospital Appointment System ---
 * 1. Add Appointment Request
 * 2. Process Next Request
 * 3. List Scheduled Appointments
 * 4. Exit
 * Enter your choice: 4
 * Exiting system.
 * ```
 * 
 * **Expected Output:**
 * 
 * The output should match the example interaction, including the menu, prompts, confirmations, error messages on `System.err`, and the list of scheduled appointments.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation of all required functionality.
 * *   Proper and effective use of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.out`, `System.err`, and `try-catch`.
 * *   Adherence to object-oriented principles (encapsulation).
 * *   Code quality (naming, comments, structure).
 * *   Input validation and error handling.
 * 
 * **Time Limit:** 45-60 minutes
 *
 * EXPLANATION:
 * This solution implements a basic Hospital Appointment Management System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Patient`: A simple class encapsulating `patientId` and `name`. Includes basic validation in the constructor.
 *     *   `AppointmentRequest`: Holds a `Patient` object and the `desiredTime` as a String. Represents a request *before* it's scheduled.
 *     *   `Appointment`: Holds a `Patient` object and the `scheduledTime` as a String. Represents a request *after* it has been processed and scheduled.
 *     *   `HospitalSystem`: The main class containing the application logic, data structures, and the `main` method.
 * 
 * 2.  **Data Structures (`Queue`, `List`, `ArrayList`):**
 *     *   `pendingRequests`: Declared as `Queue<AppointmentRequest>`. A `LinkedList` is used as the concrete implementation because `LinkedList` implements the `Queue` interface and provides the necessary FIFO (First-In, First-Out) behavior for processing requests in the order they are received. `offer()` is used to add requests, and `poll()` is used to retrieve and remove the next request.
 *     *   `scheduledAppointments`: Declared as `List<Appointment>`. An `ArrayList` is used as the concrete implementation. `ArrayList` is suitable for storing scheduled appointments as it provides dynamic resizing and efficient iteration for listing. `add()` is used to add appointments.
 * 
 * 3.  **Input (`Scanner`):**
 *     *   A `Scanner` object is created in the `HospitalSystem` constructor to read input from `System.in`.
 *     *   It is used within the `addAppointmentRequest` method to read the patient ID, name, and desired time.
 *     *   It is used in the `run` method to read the user's menu choice.
 *     *   `scanner.nextLine()` is used after `scanner.nextInt()` to consume the remaining newline character, preventing issues in subsequent `nextLine()` calls.
 *     *   The `Scanner` is closed when the application exits (`scanner.close()`).
 * 
 * 4.  **Control Flow (`switch`):**
 *     *   The `run` method uses a `while` loop to keep the application running until the user chooses to exit.
 *     *   Inside the loop, after displaying the menu and reading the user's choice, a `switch` statement is used to direct the execution flow to the appropriate method (`addAppointmentRequest`, `processNextRequest`, `listScheduledAppointments`) or handle the exit case.
 * 
 * 5.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` and `System.out.print()` are used for displaying the menu, prompts, successful confirmations, and the list of scheduled appointments.
 *     *   `System.err.println()` is used specifically for error messages, such as invalid menu choices, input validation failures, or when trying to process a request when the queue is empty. This distinction helps separate normal output from error information.
 * 
 * 6.  **Exception Handling (`try-catch`):**
 *     *   A `try-catch` block is wrapped around the user input reading for the menu choice in the `run` method to catch `InputMismatchException` if the user enters non-integer input.
 *     *   A `try-catch` block is used within the `addAppointmentRequest` method to catch `InputMismatchException` when reading the patient ID and `IllegalArgumentException` if the `Patient` or `AppointmentRequest` constructors throw an exception due to invalid data (e.g., non-positive ID, empty name/time). A general `catch (Exception e)` is also included to catch any other unforeseen runtime issues during the request addition process.
 *     *   A `try-catch` block is used within the `processNextRequest` method to catch `IllegalArgumentException` if creating the `Appointment` object fails and a general `catch (Exception e)` for other potential issues during processing.
 *     *   These `try-catch` blocks ensure that the program doesn't crash due to invalid input or unexpected errors and provides informative messages using `System.err`.
 * 
 * 7.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Patient`, `AppointmentRequest`, and `Appointment` are `private`, and access is provided through `public` getter methods. The `HospitalSystem` manages its internal data structures (`pendingRequests`, `scheduledAppointments`) privately.
 *     *   **Naming:** Variable names (`patientId`, `desiredTime`, `pendingRequests`, `scheduledAppointments`), method names (`addAppointmentRequest`, `processNextRequest`, `listScheduledAppointments`, `displayMenu`, `run`), and class names are descriptive and follow Java conventions.
 *     *   **Comments/Documentation:** Basic Javadoc comments are included for classes and key methods, explaining their purpose. Inline comments clarify specific logic points.
 *     *   **Input Validation:** Basic checks are performed in the constructors (`Patient`, `AppointmentRequest`, `Appointment`) and before creating objects in `addAppointmentRequest` (e.g., checking for positive ID, non-empty strings).
 *     *   **Error Handling:** Errors caught by `try-catch` blocks or explicit checks (like `pendingRequests.poll() == null`) result in informative messages on `System.err`.
 *     *   **Clean Structure:** The code is organized into logical classes, and methods are kept relatively short and focused on a single task.
 * 
 * This solution effectively integrates all specified components within a practical scenario, demonstrating a solid understanding of core Java programming concepts and best practices suitable for an advanced exam.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Class representing a Patient
class Patient {
    private int patientId;
    private String name;

    /**
     * Constructs a new Patient.
     * @param patientId The unique identifier for the patient.
     * @param name The name of the patient.
     */
    public Patient(int patientId, String name) {
        if (patientId <= 0) {
            throw new IllegalArgumentException("Patient ID must be positive.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty.");
        }
        this.patientId = patientId;
        this.name = name.trim();
    }

    // Getters
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + name;
    }
}

// Class representing a pending Appointment Request
class AppointmentRequest {
    private Patient patient;
    private String desiredTime; // Using String for simplicity

    /**
     * Constructs a new AppointmentRequest.
     * @param patient The patient requesting the appointment.
     * @param desiredTime The desired time for the appointment (e.g., "YYYY-MM-DD HH:MM").
     */
    public AppointmentRequest(Patient patient, String desiredTime) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
         if (desiredTime == null || desiredTime.trim().isEmpty()) {
            throw new IllegalArgumentException("Desired time cannot be empty.");
        }
        this.patient = patient;
        this.desiredTime = desiredTime.trim();
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public String getDesiredTime() {
        return desiredTime;
    }

    @Override
    public String toString() {
        return "Request for " + patient.getName() + " (" + patient.getPatientId() + ") at " + desiredTime;
    }
}

// Class representing a Scheduled Appointment
class Appointment {
    private Patient patient;
    private String scheduledTime; // Using String for simplicity

    /**
     * Constructs a new Scheduled Appointment.
     * @param patient The patient for the appointment.
     * @param scheduledTime The confirmed scheduled time.
     */
    public Appointment(Patient patient, String scheduledTime) {
         if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null.");
        }
         if (scheduledTime == null || scheduledTime.trim().isEmpty()) {
            throw new IllegalArgumentException("Scheduled time cannot be empty.");
        }
        this.patient = patient;
        this.scheduledTime = scheduledTime.trim();
    }

    // Getters
    public Patient getPatient() {
        return patient;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patient.getPatientId() + ", Name: " + patient.getName() + ", Scheduled Time: " + scheduledTime;
    }
}

// Main class managing the hospital system
public class HospitalSystem {

    // Use Queue for pending requests (FIFO)
    private Queue<AppointmentRequest> pendingRequests;
    // Use List/ArrayList for scheduled appointments
    private List<Appointment> scheduledAppointments;
    private Scanner scanner;

    /**
     * Constructs the HospitalSystem, initializing data structures and scanner.
     */
    public HospitalSystem() {
        pendingRequests = new LinkedList<>(); // LinkedList implements Queue
        scheduledAppointments = new ArrayList<>(); // ArrayList implements List
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a new appointment request to the queue.
     * Prompts user for patient and appointment details.
     */
    public void addAppointmentRequest() {
        try {
            System.out.print("Enter Patient ID: ");
            int patientId = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            System.out.print("Enter Patient Name: ");
            String patientName = scanner.nextLine();

            System.out.print("Enter Desired Time (e.g., \"YYYY-MM-DD HH:MM\"): ");
            String desiredTime = scanner.nextLine();

            // Basic input validation
            if (patientId <= 0) {
                 System.err.println("Error: Patient ID must be a positive integer.");
                 return;
            }
             if (patientName.trim().isEmpty()) {
                 System.err.println("Error: Patient name cannot be empty.");
                 return;
            }
             if (desiredTime.trim().isEmpty()) {
                 System.err.println("Error: Desired time cannot be empty.");
                 return;
            }


            Patient patient = new Patient(patientId, patientName);
            AppointmentRequest request = new AppointmentRequest(patient, desiredTime);

            pendingRequests.offer(request); // Add to the end of the queue
            System.out.println("Appointment request added to queue.");

        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid input. Please enter a valid number for Patient ID.");
            scanner.nextLine(); // Consume the invalid input to prevent infinite loop
        } catch (IllegalArgumentException e) {
             System.err.println("Error creating patient or request: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected errors during input
            System.err.println("An unexpected error occurred while adding request: " + e.getMessage());
             e.printStackTrace(); // For debugging
        }
    }

    /**
     * Processes the next appointment request from the queue.
     * Schedules the appointment if the queue is not empty.
     */
    public void processNextRequest() {
        System.out.println("Processing next request...");
        try {
            AppointmentRequest nextRequest = pendingRequests.poll(); // Retrieve and remove the head of the queue

            if (nextRequest == null) {
                System.err.println("No pending appointment requests to process.");
            } else {
                // Create a scheduled appointment from the request
                Appointment scheduledAppt = new Appointment(nextRequest.getPatient(), nextRequest.getDesiredTime());
                scheduledAppointments.add(scheduledAppt); // Add to the list of scheduled appointments

                System.out.println("Request processed. Appointment scheduled for " +
                                   nextRequest.getPatient().getName() +
                                   " (" + nextRequest.getPatient().getPatientId() + ")" +
                                   " at " + nextRequest.getDesiredTime() + ".");
            }
        } catch (IllegalArgumentException e) {
             System.err.println("Error creating scheduled appointment: " + e.getMessage());
        }
        catch (Exception e) {
            // Catch any other unexpected errors during processing
            System.err.println("An unexpected error occurred while processing request: " + e.getMessage());
             e.printStackTrace(); // For debugging
        }
    }

    /**
     * Lists all scheduled appointments.
     */
    public void listScheduledAppointments() {
        System.out.println("--- Scheduled Appointments ---");
        if (scheduledAppointments.isEmpty()) {
            System.out.println("No appointments scheduled yet.");
        } else {
            for (Appointment appt : scheduledAppointments) {
                System.out.println(appt); // Appointment's toString() is used here
            }
        }
        System.out.println("--- End of Scheduled Appointments ---");
    }

    /**
     * Displays the main menu.
     */
    private void displayMenu() {
        System.out.println("\n--- Hospital Appointment System ---");
        System.out.println("1. Add Appointment Request");
        System.out.println("2. Process Next Request");
        System.out.println("3. List Scheduled Appointments");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                // scanner.nextLine(); // Consumed by individual methods if needed

                switch (choice) {
                    case 1:
                        scanner.nextLine(); // Consume the newline after nextInt()
                        addAppointmentRequest();
                        break;
                    case 2:
                        // No nextLine() needed here as processNextRequest doesn't read lines directly after choice
                        processNextRequest();
                        break;
                    case 3:
                        // No nextLine() needed here
                        listScheduledAppointments();
                        break;
                    case 4:
                        System.out.println("Exiting system.");
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number for your choice.");
                scanner.nextLine(); // Consume the invalid input
            } catch (Exception e) {
                // Catch any other unexpected runtime errors in the main loop
                 System.err.println("An unexpected error occurred: " + e.getMessage());
                 e.printStackTrace(); // For debugging
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        system.run();
    }
}
