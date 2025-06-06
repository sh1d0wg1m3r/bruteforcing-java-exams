/*
 * Exam Question #47
 * Generated on: 2025-05-11 22:05:00
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified Hospital Appointment Management System. This system will manage a waiting list of patients and a list of scheduled appointments. Patients arrive and are added to a general waiting queue. When a doctor in a specific department is ready, the next patient from the waiting queue is called and scheduled for an appointment in that department.
 * 
 * Your program should provide a command-line interface for interacting with the system.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to manage the waiting list of patients.
 *     *   Use a `java.util.ArrayList` to store scheduled appointments.
 *     *   Declare variables holding the `ArrayList` using the `java.util.List` interface.
 * 
 * 2.  **Classes:**
 *     *   Create a `Patient` class with private fields for `name` (String) and potentially other relevant details (keep it simple, just name for now). Include a constructor and a `toString()` method.
 *     *   Create an `Appointment` class with private fields for `patient` (Patient object) and `department` (String). Include a constructor and a `toString()` method.
 *     *   Create a main class (e.g., `HospitalScheduler`) that contains the `main` method and manages the system logic. This class should hold the waiting queue and the list of scheduled appointments.
 * 
 * 3.  **Functionality:**
 *     *   **Add Patient:** Allow the user to add a new patient to the waiting queue. Prompt for the patient's name. Basic validation: name cannot be empty.
 *     *   **Call Next Patient:** Allow a doctor (simulated) to call the next patient from the waiting queue. Prompt for the department the patient is being called to. If the waiting queue is empty, report an error. If a patient is dequeued, create an `Appointment` object and add it to the list of scheduled appointments.
 *     *   **View Appointments:** Display all scheduled appointments.
 *     *   **Exit:** Terminate the program.
 * 
 * 4.  **User Interface:**
 *     *   Use `java.util.Scanner` to read user input for commands and patient/department details.
 *     *   Present a menu of options to the user (e.g., 1. Add Patient, 2. Call Next Patient, 3. View Appointments, 4. Exit).
 *     *   Use a `switch` statement to handle the user's menu selection.
 * 
 * 5.  **Error Handling:**
 *     *   Implement input validation (e.g., non-empty patient name, handling non-integer menu input).
 *     *   Use `System.err` to print error messages (e.g., queue is empty, invalid menu option, invalid input).
 *     *   Use `System.out` for normal output (prompts, success messages, displaying lists).
 *     *   Implement class-wide exception handling using `try-catch` blocks to manage potential runtime issues, such as `InputMismatchException` from the `Scanner` or unexpected errors during operations. The main operational loop should be covered by a `try-catch` block to prevent the program from crashing on unhandled exceptions.
 * 
 * 6.  **Best Practices:**
 *     *   Adhere to encapsulation principles (private fields, public methods).
 *     *   Use meaningful names for variables, methods, and classes.
 *     *   Include comments and basic documentation where necessary.
 *     *   Structure the code logically with clear separation of concerns (data classes vs. management class).
 * 
 * **Expected Output:**
 * 
 * The program should loop, presenting the menu, accepting input, performing the requested action, and printing output or errors until the user chooses to exit.
 * 
 * Example interaction:
 * 
 * ```
 * Hospital Appointment System Menu:
 * 1. Add Patient to Waiting List
 * 2. Call Next Patient (Schedule Appointment)
 * 3. View Scheduled Appointments
 * 4. Exit
 * Enter your choice: 1
 * Enter patient name: Alice
 * Patient Alice added to the waiting list.
 * 
 * Hospital Appointment System Menu:
 * 1. Add Patient to Waiting List
 * 2. Call Next Patient (Schedule Appointment)
 * 3. View Scheduled Appointments
 * 4. Exit
 * Enter your choice: 1
 * Enter patient name: Bob
 * Patient Bob added to the waiting list.
 * 
 * Hospital Appointment System Menu:
 * 1. Add Patient to Waiting List
 * 2. Call Next Patient (Schedule Appointment)
 * 3. View Scheduled Appointments
 * 4. Exit
 * Enter your choice: 2
 * Enter department for appointment: Cardiology
 * Calling next patient...
 * Scheduled appointment for patient Alice in department Cardiology.
 * 
 * Hospital Appointment System Menu:
 * 1. Add Patient to Waiting List
 * 2. Call Next Patient (Schedule Appointment)
 * 3. View Scheduled Appointments
 * 4. Exit
 * Enter your choice: 3
 * --- Scheduled Appointments ---
 * Appointment: Patient: Alice, Department: Cardiology
 * ------------------------------
 * 
 * Hospital Appointment System Menu:
 * 1. Add Patient to Waiting List
 * 2. Call Next Patient (Schedule Appointment)
 * 3. View Scheduled Appointments
 * 4. Exit
 * Enter your choice: 4
 * Exiting Hospital Appointment System.
 * ```
 * 
 * Handle cases like calling a patient when the queue is empty gracefully using `System.err`. Handle invalid menu input using `System.err`.
 * 
 * ```
 * Hospital Appointment System Menu:
 * 1. Add Patient to Waiting List
 * 2. Call Next Patient (Schedule Appointment)
 * 3. View Scheduled Appointments
 * 4. Exit
 * Enter your choice: 2
 * Enter department for appointment: Oncology
 * Calling next patient...
 * Error: Waiting list is empty. Cannot call patient.
 * 
 * Hospital Appointment System Menu:
 * 1. Add Patient to Waiting List
 * 2. Call Next Patient (Schedule Appointment)
 * 3. View Scheduled Appointments
 * 4. Exit
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number.
 * ```
 * 
 * **Time Estimate:** 45-60 minutes
 *
 * EXPLANATION:
 * This solution implements a basic Hospital Appointment Management System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Patient` class: Simple data class holding a patient's `name`. Uses a private field and a public getter, adhering to encapsulation. `toString()` provides a convenient string representation.
 *     *   `Appointment` class: Simple data class linking a `Patient` object to a `department` string. Also uses private fields, public getters, and a `toString()` method.
 *     *   `HospitalScheduler` class: The main class orchestrating the system. It contains the `main` method and the `run` method which drives the application loop. It holds the core data structures (`waitingList` and `scheduledAppointments`) and methods for the system's operations (`addPatient`, `callNextPatient`, `viewAppointments`, `displayMenu`).
 * 
 * 2.  **Data Structures:**
 *     *   `Queue<Patient> waitingList`: Implemented using `java.util.LinkedList`. A `Queue` is used because patients are added to the back and removed from the front (First-In, First-Out - FIFO), which is the natural behavior for a waiting list. `offer()` is used for adding (returns false if failed, but rarely fails for `LinkedList`), and `poll()` is used for removing (returns null if the queue is empty).
 *     *   `List<Appointment> scheduledAppointments`: Declared using the `java.util.List` interface and instantiated as a `java.util.ArrayList`. `ArrayList` is suitable for storing scheduled appointments as we might need to iterate through them or potentially access them by index later (though not required in this specific problem), and its dynamic resizing is convenient. Using the `List` interface for the variable type promotes flexibility, allowing easy switching to another `List` implementation if needed later.
 * 
 * 3.  **User Input and Control Flow:**
 *     *   `java.util.Scanner`: Used in the `HospitalScheduler` class to read input from `System.in`.
 *     *   `displayMenu()`: Prints the options to the user using `System.out`.
 *     *   `switch (choice)`: Located within the main `run` loop, this statement efficiently directs execution based on the user's integer input. Each case corresponds to a specific operation.
 * 
 * 4.  **Error Handling:**
 *     *   `System.err`: Used for printing error messages, such as invalid menu choices, empty waiting lists, or empty patient names. This directs errors to the standard error stream, which is good practice.
 *     *   `System.out`: Used for all standard messages, prompts, and successful operation confirmations.
 *     *   **Input Validation:**
 *         *   In `addPatient()`, `name.isEmpty()` checks if the entered patient name is empty after trimming whitespace.
 *         *   In `callNextPatient()`, `department.isEmpty()` checks if the entered department name is empty.
 *     *   **Operational Error Handling:**
 *         *   In `callNextPatient()`, `waitingList.poll()` returns `null` if the queue is empty. An `if (nextPatient == null)` check is used to detect this and print an error message to `System.err`.
 *     *   **Exception Handling (`try-catch`):**
 *         *   A `try-catch(InputMismatchException e)` block is specifically used within the `run` loop around `scanner.nextInt()`. This catches cases where the user enters non-integer input for the menu choice. The `catch` block prints an error to `System.err` and importantly, consumes the invalid input using `scanner.next()` to prevent an infinite loop caused by `nextInt()` not consuming the input on failure.
 *         *   A `finally` block after the inner `try-catch` ensures that `scanner.nextLine()` is called after `scanner.nextInt()`. This consumes the newline character left by `nextInt()`, which is necessary before subsequent calls to `scanner.nextLine()` (used in `addPatient` and `callNextPatient`) to prevent them from reading an empty line immediately.
 *         *   A broad `try-catch(Exception e)` block wraps the entire `while(running)` loop in the `run` method. This provides "class-wide" or rather, "main operational loop-wide" exception handling. It catches any other unexpected runtime exceptions that might occur during the program's execution, preventing the program from crashing abruptly. It prints a generic error message and the stack trace for debugging.
 *         *   A `finally` block after the outer `try-catch` ensures `scanner.close()` is called, releasing system resources held by the `Scanner` object, regardless of whether the program exited normally or due to an exception.
 * 
 * 5.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Patient`, `Appointment`, and `HospitalScheduler` are `private`. Access is provided via constructors and public methods.
 *     *   **Meaningful Names:** Variables like `waitingList`, `scheduledAppointments`, `addPatient`, `callNextPatient`, `patient`, `department` are descriptive.
 *     *   **Comments:** Basic Javadoc-style comments are included for classes and methods, explaining their purpose. Inline comments clarify specific points like the use of `offer()` vs `add()` or consuming the newline.
 *     *   **Clean Structure:** The code is divided into logical classes. The `HospitalScheduler` class contains the main logic, keeping the `main` method simple. Methods are relatively small and focused on single tasks.
 * 
 * This solution effectively integrates all required components into a practical scenario, demonstrating understanding of data structures, object-oriented principles, user interaction, and robust error handling in Java.
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

    /**
     * Constructs a new Patient.
     * @param name The name of the patient.
     */
    public Patient(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the patient.
     * @return The patient's name.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Patient: " + name;
    }
}

// Represents a scheduled appointment
class Appointment {
    private Patient patient;
    private String department;

    /**
     * Constructs a new Appointment.
     * @param patient The patient for the appointment.
     * @param department The department for the appointment.
     */
    public Appointment(Patient patient, String department) {
        this.patient = patient;
        this.department = department;
    }

    /**
     * Gets the patient for the appointment.
     * @return The Patient object.
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Gets the department for the appointment.
     * @return The department name.
     */
    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Appointment: " + patient.toString() + ", Department: " + department;
    }
}

// Main class to manage the hospital scheduling system
public class HospitalScheduler {
    // Use Queue for waiting list (FIFO)
    private Queue<Patient> waitingList;
    // Use List/ArrayList for scheduled appointments
    private List<Appointment> scheduledAppointments;
    private Scanner scanner;

    /**
     * Constructs a new HospitalScheduler.
     * Initializes the waiting list, scheduled appointments list, and scanner.
     */
    public HospitalScheduler() {
        // LinkedList is a common implementation of Queue
        this.waitingList = new LinkedList<>();
        // ArrayList is a common implementation of List
        this.scheduledAppointments = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\nHospital Appointment System Menu:");
        System.out.println("1. Add Patient to Waiting List");
        System.out.println("2. Call Next Patient (Schedule Appointment)");
        System.out.println("3. View Scheduled Appointments");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a patient to the waiting list.
     */
    private void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine().trim(); // Read and trim potential whitespace

        if (name.isEmpty()) {
            System.err.println("Error: Patient name cannot be empty.");
            return; // Exit the method if validation fails
        }

        Patient patient = new Patient(name);
        waitingList.offer(patient); // offer() is generally preferred over add() for queues
        System.out.println("Patient " + name + " added to the waiting list.");
    }

    /**
     * Calls the next patient from the waiting list and schedules an appointment.
     */
    private void callNextPatient() {
        System.out.print("Enter department for appointment: ");
        String department = scanner.nextLine().trim();

        if (department.isEmpty()) {
             System.err.println("Error: Department name cannot be empty.");
             return;
        }

        System.out.println("Calling next patient...");
        Patient nextPatient = waitingList.poll(); // poll() retrieves and removes the head, returns null if empty

        if (nextPatient == null) {
            System.err.println("Error: Waiting list is empty. Cannot call patient.");
        } else {
            Appointment appointment = new Appointment(nextPatient, department);
            scheduledAppointments.add(appointment);
            System.out.println("Scheduled appointment for " + nextPatient.toString() + " in department " + department + ".");
        }
    }

    /**
     * Displays all scheduled appointments.
     */
    private void viewAppointments() {
        System.out.println("\n--- Scheduled Appointments ---");
        if (scheduledAppointments.isEmpty()) {
            System.out.println("No appointments scheduled yet.");
        } else {
            for (Appointment appt : scheduledAppointments) {
                System.out.println(appt); // Uses the Appointment's toString()
            }
        }
        System.out.println("------------------------------");
    }

    /**
     * Runs the main application loop.
     * Includes class-wide exception handling.
     */
    public void run() {
        boolean running = true;

        // Class-wide try-catch block for the main operational loop
        try {
            while (running) {
                displayMenu();
                int choice = -1; // Default invalid choice

                // Inner try-catch for handling non-integer input specifically
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    // Consume the invalid input to prevent infinite loop
                    scanner.next();
                    continue; // Skip to the next iteration of the while loop
                } finally {
                    // Consume the newline character left by nextInt()
                    // This is crucial before calling nextLine() in subsequent reads
                    scanner.nextLine();
                }

                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        callNextPatient();
                        break;
                    case 3:
                        viewAppointments();
                        break;
                    case 4:
                        System.out.println("Exiting Hospital Appointment System.");
                        running = false; // Set flag to exit loop
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure the scanner is closed when the application exits
            scanner.close();
            System.out.println("Scanner closed."); // Optional: confirm closure
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HospitalScheduler scheduler = new HospitalScheduler();
        scheduler.run();
    }
}
