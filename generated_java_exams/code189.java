/*
 * Exam Question #189
 * Generated on: 2025-05-11 22:28:44
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment Management System
 * 
 * **Objective:** Design and implement a simplified Hospital Appointment Management System that allows managing patient waiting lists and scheduled appointments. This task requires demonstrating proficiency in core Java data structures, control flow, input/output, and exception handling.
 * 
 * **Scenario:** You are developing a console-based system for a small clinic. Patients can either be added to a waiting list (e.g., for walk-ins or triage) or scheduled for a specific appointment time. The system needs to keep track of patients waiting and those with confirmed appointments.
 * 
 * **Requirements:**
 * 
 * 1.  **Patient Representation:** Create a simple class `Patient` with a private field for the patient's name and appropriate public getter methods.
 * 2.  **Appointment Representation:** Create a simple class `Appointment` with private fields for the `Patient`, a `String` for the doctor's name, and a `String` for the appointment time (e.g., "10:00 AM"). Include appropriate public getter methods.
 * 3.  **Hospital Scheduler Class:** Create a class `HospitalScheduler` that manages the system's state and operations.
 *     *   It must contain a private `java.util.Queue<Patient>` to manage the waiting list.
 *     *   It must contain a private `java.util.List<Appointment>` (implemented using `java.util.ArrayList`) to store scheduled appointments.
 *     *   Implement the following public methods:
 *         *   `addPatientToWaitingList(Patient patient)`: Adds a patient to the waiting queue.
 *         *   `scheduleAppointment(Patient patient, String doctor, String time)`: Creates an `Appointment` and adds it to the scheduled appointments list.
 *         *   `scheduleAppointmentFromWaitingList(String doctor, String time)`: Takes the first patient from the waiting queue, creates an `Appointment` with the provided doctor and time, and adds it to the scheduled appointments list. If the waiting list is empty, it should report an error.
 *         *   `viewScheduledAppointments()`: Prints all scheduled appointments.
 *         *   `viewWaitingList()`: Prints all patients currently in the waiting list.
 *         *   `cancelAppointment(String patientName, String time)`: Finds and removes an appointment for the given patient name and time. Reports success or failure.
 *         *   A method (e.g., `run()`) to handle the main application loop, user interaction, and menu.
 * 4.  **User Interface:**
 *     *   Use `java.util.Scanner` to get user input from the console.
 *     *   Present a menu of options to the user (e.g., Add to Waitlist, Schedule New, Schedule From Waitlist, View Scheduled, View Waitlist, Cancel Appointment, Exit).
 *     *   Use a `switch` statement in the main application loop to handle the user's menu choice.
 * 5.  **Output:**
 *     *   Use `System.out.println` for displaying the menu, confirmations of successful operations, and lists of appointments/patients.
 *     *   Use `System.err.println` to display error messages (e.g., invalid menu choice, waiting list empty when scheduling from it, appointment not found for cancellation, invalid input format).
 * 6.  **Error Handling:**
 *     *   Implement robust input validation (e.g., ensure menu choices are valid numbers).
 *     *   Use `try-catch` blocks for exception handling. The main application logic (the `run()` method or the part of `main` that drives the menu) should be wrapped in a `try-catch` block to handle unexpected errors gracefully and demonstrate class-wide exception handling. Specific `try-catch` blocks might be needed for input parsing or other specific operations.
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include comments where necessary to explain complex logic.
 *     *   Ensure proper encapsulation (private fields, public methods).
 *     *   Close the `Scanner` resource properly.
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, presenting a menu, accepting user input, performing the requested operations, and displaying results or error messages.
 * 
 * Example interaction flow:
 * ```
 * --- Hospital Appointment System ---
 * 1. Add Patient to Waiting List
 * 2. Schedule New Appointment
 * 3. Schedule From Waiting List
 * 4. View Scheduled Appointments
 * 5. View Waiting List
 * 6. Cancel Appointment
 * 7. Exit
 * Enter your choice: 1
 * Enter patient name: Alice
 * Alice added to waiting list.
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: 5
 * Waiting List:
 * - Alice
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: 3
 * Enter doctor name: Dr. Smith
 * Enter appointment time (e.g., 10:00 AM): 10:00 AM
 * Scheduled appointment for Alice with Dr. Smith at 10:00 AM (from waiting list).
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: 5
 * Waiting List:
 * (Empty)
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: 4
 * Scheduled Appointments:
 * - Patient: Alice, Doctor: Dr. Smith, Time: 10:00 AM
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: 6
 * Enter patient name to cancel: Alice
 * Enter appointment time to cancel: 10:00 AM
 * Appointment for Alice at 10:00 AM cancelled.
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: 6
 * Enter patient name to cancel: Bob
 * Enter appointment time to cancel: 11:00 AM
 * Error: Appointment for Bob at 11:00 AM not found.
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: 8
 * Error: Invalid choice. Please enter a number between 1 and 7.
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: exit
 * Error: Invalid input. Please enter a number.
 * 
 * --- Hospital Appointment System ---
 * ... (menu repeats)
 * Enter your choice: 7
 * Exiting system.
 * ```
 * 
 * Your task is to provide the complete Java code for this system and a brief explanation of how it fulfills the requirements.
 *
 * EXPLANATION:
 * The provided solution implements the `HospitalAppointmentSystem` as requested, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **Classes (`Patient`, `Appointment`, `HospitalScheduler`):**
 *     *   `Patient` and `Appointment` are simple data classes with private fields and public getters, adhering to encapsulation.
 *     *   `HospitalScheduler` is the main class orchestrating the system logic. It holds the core data structures (`waitingList` and `scheduledAppointments`) and provides methods for all operations.
 * 
 * 2.  **Data Structures (`Queue`, `ArrayList`, `List`):**
 *     *   `java.util.Queue<Patient> waitingList`: A `LinkedList` is used to implement the `Queue` interface, suitable for a waiting list where patients are added to the end (`offer`) and removed from the front (`poll`).
 *     *   `java.util.List<Appointment> scheduledAppointments`: An `ArrayList` is used as the concrete implementation of the `List` interface. This provides dynamic resizing and efficient access/iteration, suitable for storing a list of scheduled appointments.
 * 
 * 3.  **User Input (`Scanner`):**
 *     *   A `java.util.Scanner` object is created to read input from `System.in`.
 *     *   `scanner.nextInt()` is used to read the menu choice, and `scanner.nextLine()` is used to read string inputs (patient names, doctor names, times). The `scanner.nextLine()` call after `nextInt()` is crucial to consume the leftover newline character.
 *     *   The `scanner` is closed using `scanner.close()` when the application exits to release system resources.
 * 
 * 4.  **Control Flow (`Switch`):**
 *     *   A `switch` statement in the `run()` method processes the integer `choice` read from the user, directing execution to the appropriate method call based on the menu selection.
 * 
 * 5.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println` is used for displaying the menu, confirmations of successful operations (e.g., patient added, appointment scheduled), and listing the contents of the waiting list and scheduled appointments.
 *     *   `System.err.println` is used specifically for error messages, such as invalid menu choices, trying to schedule from an empty waiting list, appointment not found for cancellation, or input validation errors.
 * 
 * 6.  **Exception Handling (`try-catch`):**
 *     *   A main `try-catch` block wraps the core `while` loop within the `run()` method. This demonstrates class-wide exception handling, catching potential unexpected runtime errors during the application's execution.
 *     *   A specific `catch (InputMismatchException e)` block is included *inside* the loop to handle cases where the user enters non-numeric input when the `scanner.nextInt()` call expects an integer (for the menu choice). This prevents the program from crashing and allows it to prompt the user again.
 *     *   Error messages are printed to `System.err`.
 * 
 * 7.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Patient`, `Appointment`, and `HospitalScheduler` are private, and access is provided through public methods.
 *     *   **Naming:** Variable and method names are descriptive (e.g., `waitingList`, `scheduleAppointmentFromWaitingList`, `cancelAppointment`, `patientName`).
 *     *   **Comments:** Comments explain the purpose of classes, methods, and important code sections.
 *     *   **Input Validation:** The `try-catch` for `InputMismatchException` validates that the menu input is numeric. The `scheduleAppointmentFromWaitingList` method checks if the queue is empty before attempting to poll.
 *     *   **Error Handling:** Specific error messages are printed to `System.err` for various failure conditions.
 *     *   **Clean Code Structure:** The code is organized into logical classes and methods, making it readable and maintainable.
 * 
 * This solution effectively integrates the required Java components into a functional, albeit simplified, system, addressing the problem requirements and demonstrating good programming practices.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a patient
class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Represents an appointment
class Appointment {
    private Patient patient;
    private String doctor;
    private String time;

    public Appointment(Patient patient, String doctor, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDoctor() {
        return doctor;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Patient: " + patient.getName() + ", Doctor: " + doctor + ", Time: " + time;
    }
}

// Manages hospital appointments and waiting list
public class HospitalScheduler {

    private Queue<Patient> waitingList;
    private List<Appointment> scheduledAppointments;
    private Scanner scanner;

    public HospitalScheduler() {
        // Use LinkedList as it implements the Queue interface
        waitingList = new LinkedList<>();
        // Use ArrayList as the concrete implementation of the List interface
        scheduledAppointments = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Adds a patient to the waiting list queue.
     * @param patient The patient to add.
     */
    public void addPatientToWaitingList(Patient patient) {
        waitingList.offer(patient); // offer is preferred over add as it doesn't throw exception
        System.out.println(patient.getName() + " added to waiting list.");
    }

    /**
     * Schedules a new appointment for a given patient, doctor, and time.
     * @param patient The patient for the appointment.
     * @param doctor The doctor's name.
     * @param time The appointment time.
     */
    public void scheduleAppointment(Patient patient, String doctor, String time) {
        Appointment appointment = new Appointment(patient, doctor, time);
        scheduledAppointments.add(appointment);
        System.out.println("Scheduled appointment for " + patient.getName() + " with " + doctor + " at " + time + ".");
    }

    /**
     * Schedules an appointment for the first patient in the waiting list.
     * @param doctor The doctor's name.
     * @param time The appointment time.
     */
    public void scheduleAppointmentFromWaitingList(String doctor, String time) {
        Patient patient = waitingList.poll(); // poll retrieves and removes the head of the queue
        if (patient != null) {
            Appointment appointment = new Appointment(patient, doctor, time);
            scheduledAppointments.add(appointment);
            System.out.println("Scheduled appointment for " + patient.getName() + " with " + doctor + " at " + time + " (from waiting list).");
        } else {
            System.err.println("Error: Waiting list is empty. Cannot schedule from waiting list.");
        }
    }

    /**
     * Prints all scheduled appointments to System.out.
     */
    public void viewScheduledAppointments() {
        System.out.println("\nScheduled Appointments:");
        if (scheduledAppointments.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            for (Appointment app : scheduledAppointments) {
                System.out.println("- " + app);
            }
        }
    }

    /**
     * Prints all patients in the waiting list queue to System.out.
     */
    public void viewWaitingList() {
        System.out.println("\nWaiting List:");
        if (waitingList.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            // Iterate without removing elements
            waitingList.forEach(patient -> System.out.println("- " + patient.getName()));
        }
    }

    /**
     * Cancels an appointment based on patient name and time.
     * @param patientName The name of the patient.
     * @param time The appointment time.
     */
    public void cancelAppointment(String patientName, String time) {
        // Use an iterator for safe removal while iterating
        var iterator = scheduledAppointments.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getPatient().getName().equalsIgnoreCase(patientName) &&
                appointment.getTime().equalsIgnoreCase(time)) {
                iterator.remove(); // Safely remove the current element
                System.out.println("Appointment for " + patientName + " at " + time + " cancelled.");
                found = true;
                break; // Assuming only one appointment matches name and time
            }
        }
        if (!found) {
            System.err.println("Error: Appointment for " + patientName + " at " + time + " not found.");
        }
    }

    /**
     * Runs the main application loop, handling user interaction.
     */
    public void run() {
        int choice = 0;
        while (choice != 7) {
            printMenu();
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter patient name: ");
                        String patientName = scanner.nextLine();
                        addPatientToWaitingList(new Patient(patientName));
                        break;
                    case 2:
                        System.out.print("Enter patient name: ");
                        String newAppPatientName = scanner.nextLine();
                        System.out.print("Enter doctor name: ");
                        String newAppDoctor = scanner.nextLine();
                        System.out.print("Enter appointment time (e.g., 10:00 AM): ");
                        String newAppTime = scanner.nextLine();
                        scheduleAppointment(new Patient(newAppPatientName), newAppDoctor, newAppTime);
                        break;
                    case 3:
                        System.out.print("Enter doctor name: ");
                        String waitlistDoctor = scanner.nextLine();
                        System.out.print("Enter appointment time (e.g., 10:00 AM): ");
                        String waitlistTime = scanner.nextLine();
                        scheduleAppointmentFromWaitingList(waitlistDoctor, waitlistTime);
                        break;
                    case 4:
                        viewScheduledAppointments();
                        break;
                    case 5:
                        viewWaitingList();
                        break;
                    case 6:
                        System.out.print("Enter patient name to cancel: ");
                        String cancelPatientName = scanner.nextLine();
                        System.out.print("Enter appointment time to cancel: ");
                        String cancelTime = scanner.nextLine();
                        cancelAppointment(cancelPatientName, cancelTime);
                        break;
                    case 7:
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                choice = 0; // Reset choice to prevent exiting
            } catch (Exception e) {
                // Class-wide catch for any other unexpected errors
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to error stream
            }
            System.out.println(); // Add a blank line for readability
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Prints the main menu options to System.out.
     */
    private void printMenu() {
        System.out.println("--- Hospital Appointment System ---");
        System.out.println("1. Add Patient to Waiting List");
        System.out.println("2. Schedule New Appointment");
        System.out.println("3. Schedule From Waiting List");
        System.out.println("4. View Scheduled Appointments");
        System.out.println("5. View Waiting List");
        System.out.println("6. Cancel Appointment");
        System.out.println("7. Exit");
    }

    // Main method to start the application
    public static void main(String[] args) {
        HospitalScheduler scheduler = new HospitalScheduler();
        scheduler.run();
    }
}
