/*
 * Exam Question #68
 * Generated on: 2025-05-11 22:08:19
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Advanced Java Programming Exam Task: Hospital Appointment Processing System**
 * 
 * **Scenario:**
 * You are tasked with developing a console-based simulation of a hospital reception desk's workflow for managing patient appointments. Patients arrive and are added to a waiting list. When a doctor becomes available, the next patient from the waiting list is called and moved to a list of processed appointments. The system needs to handle patient arrivals, processing, and allow viewing the current waiting list and the list of processed appointments.
 * 
 * **Task:**
 * Implement a Java console application named `HospitalAppointmentSystem` that simulates this workflow. Your application must provide a menu-driven interface for the receptionist.
 * 
 * **Requirements:**
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to manage the waiting list of patients. The queue should store custom `Patient` objects.
 *     *   Use a `java.util.List` (specifically implemented by `java.util.ArrayList`) to store patients whose appointments have been processed.
 * 2.  **Patient Class:** Create a simple class `Patient` with a private field for the patient's name and appropriate public methods (constructor, getter).
 * 3.  **User Interface:**
 *     *   Use `java.util.Scanner` to read user input from the console.
 *     *   Present a menu with the following options:
 *         1.  Add Patient to Waiting List
 *         2.  Process Next Patient
 *         3.  View Waiting List
 *         4.  View Processed Appointments
 *         5.  Exit
 *     *   Use a `switch` statement to handle the user's menu selection.
 * 4.  **Functionality:**
 *     *   **Add Patient:** Prompt the user for the patient's name. Create a `Patient` object and add it to the waiting queue. Validate that the name is not empty.
 *     *   **Process Next Patient:** Remove the patient at the front of the waiting queue and add them to the list of processed appointments. If the waiting queue is empty, display an error message.
 *     *   **View Waiting List:** Display all patients currently in the waiting queue, in the order they will be processed. Indicate if the list is empty.
 *     *   **View Processed Appointments:** Display all patients whose appointments have been processed. Indicate if the list is empty.
 *     *   **Exit:** Terminate the application.
 * 5.  **Error Handling:**
 *     *   Implement robust exception handling using `try-catch` blocks, specifically around the main input loop, to gracefully handle potential input errors (e.g., non-integer input for menu options).
 *     *   Use `System.err` to display error messages (e.g., invalid menu option, empty queue when processing, empty name input).
 *     *   Use `System.out` for all normal output (menu, prompts, success messages, list contents).
 * 6.  **Best Practices:**
 *     *   Apply proper encapsulation (private fields, public methods) for the `Patient` class and the main system class.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes and methods).
 *     *   Ensure input validation is performed where necessary (e.g., patient name, menu choice).
 *     *   Maintain a clean code structure.
 * 
 * **Expected Output:**
 * The application should run in a loop, displaying the menu, prompting for input, performing the requested action, and displaying results or errors using `System.out` or `System.err` as appropriate.
 * 
 * Example interaction snippets:
 * 
 * ```
 * --- Hospital Appointment System ---
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Processed Appointments
 * 5. Exit
 * Enter your choice: 1
 * Enter patient name: Alice
 * 
 * Patient 'Alice' added to the waiting list.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter your choice: 3
 * 
 * --- Waiting List ---
 * 1. Alice
 * --------------------
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter your choice: 2
 * 
 * Processing next patient...
 * Patient 'Alice' processed.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter your choice: 3
 * 
 * --- Waiting List ---
 * Waiting list is empty.
 * --------------------
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter your choice: 4
 * 
 * --- Processed Appointments ---
 * 1. Alice
 * ----------------------------
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter your choice: 2
 * 
 * Error: Waiting list is empty. Cannot process patient.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter your choice: 6
 * 
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter your choice: 5
 * 
 * Exiting Hospital Appointment System.
 * ```
 * 
 * Your solution should be a single Java file containing all necessary classes.
 * 
 * **Evaluation:** Your solution will be evaluated based on:
 * *   Correctness of implementation.
 * *   Proper use of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`.
 * *   Effective use of `System.err` and `System.out`.
 * *   Robust exception handling with `try-catch`.
 * *   Adherence to best practices (encapsulation, naming, comments, validation).
 * *   Clean and readable code.
 *
 * EXPLANATION:
 * This solution implements the `HospitalAppointmentSystem` as required, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **`Patient` Class:** A simple class representing a patient, encapsulating the `name` field as private and providing a public constructor and getter. Input validation is included in the constructor to ensure the name is not empty.
 * 
 * 2.  **`HospitalAppointmentSystem` Class:** This is the main class containing the application logic.
 *     *   **Data Structures:**
 *         *   `waitingQueue`: Declared as `Queue<Patient>` and initialized with `new LinkedList<>()`. This correctly uses the `Queue` interface and a common implementation (`LinkedList`) suitable for FIFO (First-In, First-Out) behavior. Patients are added to the end (`offer`) and removed from the front (`poll`).
 *         *   `processedPatients`: Declared as `List<Patient>` and initialized with `new ArrayList<>()`. This correctly uses the `List` interface and a dynamic array implementation (`ArrayList`) to store the processed patients in the order they were processed.
 *     *   **`Scanner`:** An instance of `Scanner` is used to read input from `System.in`. It's initialized once in the constructor and closed when the application exits to release system resources. Note the careful handling of newline characters after reading integers.
 *     *   **`run()` Method:** This method contains the main application loop (`while (choice != 5)`). It repeatedly displays the menu, reads the user's choice, and uses a `switch` statement to dispatch to the appropriate action method.
 *     *   **`switch` Statement:** Located within the `run()` method, the `switch` statement handles the different menu options, calling the corresponding private methods (`addPatientToWaitingList`, `processNextPatient`, etc.). The `default` case handles invalid integer inputs within the valid range of a number but not a menu option.
 *     *   **Exception Handling (`try-catch`):** A `try-catch` block surrounds the core input reading and `switch` logic within the `run()` loop. This is crucial for handling `InputMismatchException` if the user enters non-integer input for the menu choice, preventing the program from crashing and allowing it to prompt the user again. A general `catch (Exception e)` is included as a fallback for any other unexpected errors, printing the error to `System.err` and exiting gracefully.
 *     *   **Error Output (`System.err`):** `System.err.println()` is used specifically for displaying error messages, such as when the waiting list is empty during processing, when the user enters an invalid menu option, when patient name input is invalid, or when input is not an integer.
 *     *   **Normal Output (`System.out`):** `System.out.println()` is used for all other output, including displaying the menu, prompts, success messages (patient added, patient processed), and the contents of the waiting and processed lists.
 *     *   **Methods:** Private methods (`displayMenu`, `addPatientToWaitingList`, `processNextPatient`, `viewWaitingList`, `viewProcessedAppointments`) are used to break down the functionality, improving code organization and encapsulation.
 *     *   **Input Validation:** The `addPatientToWaitingList` method validates that the entered name is not empty by using a `try-catch` block around the `Patient` constructor call, which throws an `IllegalArgumentException` if the name is invalid. The `run` method validates the menu choice using the `switch` statement and handles non-integer input with `try-catch`. The `processNextPatient` method validates if the queue is empty before attempting to process.
 *     *   **Best Practices:** The code uses meaningful names (`waitingQueue`, `processNextPatient`), includes basic Javadoc comments, and separates concerns into methods and classes. Fields are private, and interaction is through public methods (`run`) or private helper methods called internally.
 * 
 * This solution effectively combines various core Java features and data structures to solve a practical problem, demonstrating a solid understanding of object-oriented programming principles and robust application development.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a patient in the hospital system.
 */
class Patient {
    private String name;

    /**
     * Constructs a new Patient object.
     * @param name The name of the patient.
     */
    public Patient(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty.");
        }
        this.name = name.trim();
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
        return name;
    }
}

/**
 * Simulates a hospital reception desk for managing patient appointments.
 */
public class HospitalAppointmentSystem {

    private Queue<Patient> waitingQueue;
    private List<Patient> processedPatients;
    private Scanner scanner;

    /**
     * Constructs a new HospitalAppointmentSystem.
     * Initializes the waiting queue, processed list, and scanner.
     */
    public HospitalAppointmentSystem() {
        this.waitingQueue = new LinkedList<>(); // LinkedList implements Queue
        this.processedPatients = new ArrayList<>(); // ArrayList implements List
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Hospital Appointment System ---");
        System.out.println("1. Add Patient to Waiting List");
        System.out.println("2. Process Next Patient");
        System.out.println("3. View Waiting List");
        System.out.println("4. View Processed Appointments");
        System.out.println("5. Exit");
        System.out.println("-----------------------------------");
    }

    /**
     * Adds a new patient to the waiting queue.
     */
    private void addPatientToWaitingList() {
        System.out.print("Enter patient name: ");
        scanner.nextLine(); // Consume the newline character left by previous nextInt()
        String name = scanner.nextLine();

        try {
            Patient patient = new Patient(name);
            waitingQueue.offer(patient); // offer() is preferred over add() as it doesn't throw exception on capacity issues (though LinkedList is unbounded)
            System.out.println("\nPatient '" + patient.getName() + "' added to the waiting list.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Processes the next patient from the waiting queue.
     * Moves the patient to the processed list.
     */
    private void processNextPatient() {
        System.out.println("\nProcessing next patient...");
        Patient nextPatient = waitingQueue.poll(); // poll() retrieves and removes, returns null if empty

        if (nextPatient != null) {
            processedPatients.add(nextPatient);
            System.out.println("Patient '" + nextPatient.getName() + "' processed.");
        } else {
            System.err.println("Error: Waiting list is empty. Cannot process patient.");
        }
    }

    /**
     * Displays the list of patients currently in the waiting queue.
     */
    private void viewWaitingList() {
        System.out.println("\n--- Waiting List ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting list is empty.");
        } else {
            int index = 1;
            for (Patient patient : waitingQueue) { // Iterating over Queue maintains order
                System.out.println(index++ + ". " + patient.getName());
            }
        }
        System.out.println("--------------------");
    }

    /**
     * Displays the list of patients whose appointments have been processed.
     */
    private void viewProcessedAppointments() {
        System.out.println("\n--- Processed Appointments ---");
        if (processedPatients.isEmpty()) {
            System.out.println("Processed appointments list is empty.");
        } else {
            int index = 1;
            for (Patient patient : processedPatients) {
                System.out.println(index++ + ". " + patient.getName());
            }
        }
        System.out.println("----------------------------");
    }

    /**
     * Runs the main application loop.
     * Handles user input and menu navigation.
     */
    public void run() {
        int choice = -1;
        while (choice != 5) {
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                // Consume the rest of the line after reading the integer
                // scanner.nextLine(); // Moved consumption to addPatientToWaitingList

                switch (choice) {
                    case 1:
                        addPatientToWaitingList();
                        break;
                    case 2:
                        processNextPatient();
                        break;
                    case 3:
                        viewWaitingList();
                        break;
                    case 4:
                        viewProcessedAppointments();
                        break;
                    case 5:
                        System.out.println("\nExiting Hospital Appointment System.");
                        break;
                    default:
                        System.err.println("\nError: Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.err.println("\nError: Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to continue loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("\nAn unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to error stream
                choice = 5; // Exit on unexpected error
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HospitalAppointmentSystem system = new HospitalAppointmentSystem();
        system.run();
    }
}
