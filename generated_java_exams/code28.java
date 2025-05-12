/*
 * Exam Question #28
 * Generated on: 2025-05-11 21:47:12
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Walk-in Clinic Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application for managing a walk-in clinic. The clinic needs to keep track of available doctors and a waiting list of patients who arrive without appointments. The system should allow adding new doctors, adding patients to the waiting list, processing the next patient in the waiting list by assigning them to a doctor, and viewing the current lists.
 * 
 * **Requirements:**
 * 
 * Develop a Java application that implements the following functionalities via a text-based menu:
 * 
 * 1.  **Add a New Doctor:** Prompt the user for the doctor's name and specialty, then add them to a list of available doctors.
 * 2.  **Add a Walk-in Patient:** Prompt the user for the patient's name and add them to the waiting list. Patients are added to the end of the list and processed in the order they arrive.
 * 3.  **Process Next Walk-in:** Take the patient at the front of the waiting list and assign them to *any* available doctor. Print a message indicating which patient is assigned to which doctor. If there are no patients waiting or no doctors available, print an appropriate error message. The patient should be removed from the waiting list upon processing.
 * 4.  **View Waiting List:** Display the names of all patients currently in the waiting list, in order.
 * 5.  **View Available Doctors:** Display the names and specialties of all available doctors.
 * 6.  **Exit:** Terminate the application.
 * 
 * **Technical Constraints & Required Components:**
 * 
 * Your solution MUST utilize the following Java components:
 * 
 * *   `java.util.Queue`: To manage the patient waiting list (FIFO).
 * *   `java.util.ArrayList`: To store the list of available doctors.
 * *   `java.util.List`: Use `List` as the interface type when declaring the collection of doctors (`List<Doctor> doctors = new ArrayList<>();`).
 * *   `java.util.Scanner`: To handle user input from the console.
 * *   `switch` statement: To control the flow based on the user's menu selection.
 * *   `System.err`: For printing error messages (e.g., "No doctors available", "Invalid input").
 * *   `System.out`: For printing prompts, menu, success messages, and list contents.
 * *   Class-wide exception handling using `try-catch` blocks: Specifically, handle potential `InputMismatchException` when reading integer menu choices and gracefully handle other potential issues like trying to process when lists are empty.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Create separate classes for `Patient` and `Doctor` with private fields and public getters/constructors. The main management logic should be in a separate class (`HospitalScheduler`).
 * *   **Meaningful Names:** Use descriptive names for variables, methods, and classes.
 * *   **Comments & Documentation:** Include Javadoc for classes and methods, and inline comments for complex logic.
 * *   **Input Validation:** Check for empty or invalid input where appropriate (e.g., names).
 * *   **Error Handling:** Handle cases where operations cannot be performed (e.g., processing when lists are empty).
 * *   **Clean Code Structure:** Organize your code logically into classes and methods. Manage resources properly (e.g., closing the `Scanner`).
 * 
 * **Expected Output:**
 * 
 * The application should present a menu to the user, prompt for input based on the selection, and print relevant information or error messages. Examples:
 * 
 * ```
 * --- Walk-in Clinic Menu ---
 * 1. Add Doctor
 * 2. Add Patient
 * 3. Process Next Walk-in
 * 4. View Waiting List
 * 5. View Available Doctors
 * 6. Exit
 * Enter your choice: 1
 * Enter doctor's name: Dr. Smith
 * Enter doctor's specialty: General Practice
 * Dr. Smith (General Practice) added.
 * 
 * --- Walk-in Clinic Menu ---
 * ...
 * Enter your choice: 2
 * Enter patient's name: Alice
 * Alice added to waiting list.
 * 
 * --- Walk-in Clinic Menu ---
 * ...
 * Enter your choice: 3
 * Processing next patient...
 * Alice is assigned to Dr. Smith (General Practice).
 * 
 * --- Walk-in Clinic Menu ---
 * ...
 * Enter your choice: 4
 * Waiting List:
 * (Empty)
 * 
 * --- Walk-in Clinic Menu ---
 * ...
 * Enter your choice: 3
 * Processing next patient...
 * Error: No patients in the waiting list.
 * 
 * --- Walk-in Clinic Menu ---
 * ...
 * Enter your choice: 7
 * Error: Invalid choice. Please enter a number between 1 and 6.
 * 
 * --- Walk-in Clinic Menu ---
 * ...
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number.
 * 
 * --- Walk-in Clinic Menu ---
 * ...
 * Enter your choice: 6
 * Exiting system. Goodbye!
 * ```
 * 
 * Your solution should be a single, runnable Java program.
 *
 * EXPLANATION:
 * This solution implements the `Walk-in Clinic Management System` requirements by effectively utilizing the specified Java components and adhering to best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Patient` and `Doctor` classes are simple data carriers, demonstrating encapsulation with private fields (`name`, `specialty`) and public getters and constructors. Input validation is added to their constructors to prevent creation with empty names/specialties.
 *     *   `HospitalScheduler` is the main class that orchestrates the operations. It holds the collections (`waitingList`, `availableDoctors`) and the `Scanner` instance.
 * 
 * 2.  **Data Structures:**
 *     *   `java.util.Queue<Patient> waitingList = new LinkedList<>();`: A `LinkedList` is used because it implements the `Queue` interface and provides efficient FIFO operations (`offer` for adding, `poll` for removing from the front, `peek` for viewing the front without removing). This perfectly models a waiting line.
 *     *   `List<Doctor> availableDoctors = new ArrayList<>();`: An `ArrayList` is used to store doctors. It's declared using the `List` interface type, demonstrating polymorphism and good practice (coding to the interface). `ArrayList` provides efficient random access (`get(index)`) which is sufficient for our simple doctor assignment logic (always picking the first one).
 * 
 * 3.  **User Input (`Scanner`) and Flow Control (`switch`):**
 *     *   A `Scanner` instance (`scanner`) is used as a class field in `HospitalScheduler` to read input from `System.in`.
 *     *   The `run()` method contains the main application loop. Inside the loop, `displayMenu()` prints the options, and `scanner.nextInt()` reads the user's choice.
 *     *   A `switch` statement handles the different menu options, directing the program flow to the corresponding methods (`addDoctor`, `addWalkInPatient`, `processNextWalkIn`, `listWaitingPatients`, `listAvailableDoctors`).
 *     *   `scanner.nextLine()` is called after `scanner.nextInt()` to consume the leftover newline character, preventing issues in subsequent `scanner.nextLine()` calls.
 * 
 * 4.  **Input Validation and Error Handling (`System.err`, `try-catch`):**
 *     *   **Input Validation:**
 *         *   `Patient` and `Doctor` constructors check if names/specialties are null or empty using `IllegalArgumentException`. The calling methods (`addDoctor`, `addWalkInPatient`) catch this specific exception and print an informative message using `System.err`.
 *         *   The `run()` loop checks if the `choice` is within the valid range (1-6) in the `default` case of the `switch`.
 *     *   **Error Handling (`try-catch`):**
 *         *   A `try-catch (InputMismatchException e)` block is wrapped around the `scanner.nextInt()` call in the `run()` method. This catches cases where the user enters non-integer input for the menu choice. It prints an error using `System.err` and consumes the invalid input (`scanner.nextLine()`) to prevent an infinite loop.
 *         *   The `processNextWalkIn()` method explicitly checks if the `waitingList` or `availableDoctors` list is empty *before* attempting to `poll()` from the queue or `get(0)` from the list. If empty, it prints an error using `System.err` and returns, preventing `NullPointerException` or `IndexOutOfBoundsException`.
 *         *   A general `catch (Exception e)` is included in the `run()` loop to catch any other unexpected runtime errors, demonstrating a class-wide handling approach for the main execution flow. It prints the error message and stack trace to `System.err`.
 * 
 * 5.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` is used for printing the menu, prompts, confirmation messages (e.g., "Patient added"), and the contents of the lists.
 *     *   `System.err.println()` is used *specifically* for printing error messages (e.g., "Invalid choice", "No doctors available", "Error adding doctor"). This distinction is important for directing error output separately from standard output.
 * 
 * 6.  **Core Logic Implementation:**
 *     *   `addDoctor`: Creates a `Doctor` object and adds it to the `availableDoctors` `ArrayList`.
 *     *   `addWalkInPatient`: Creates a `Patient` object and adds it to the `waitingList` `Queue` using `offer()`.
 *     *   `processNextWalkIn`: Demonstrates checking list/queue state, using `waitingList.poll()` to get and remove the next patient, and using `availableDoctors.get(0)` (a simple choice) to select a doctor.
 *     *   `listWaitingPatients`: Iterates through the `waitingList` using a for-each loop (which uses the iterator, not `poll()` or `peek()`), printing each patient's name.
 *     *   `listAvailableDoctors`: Iterates through the `availableDoctors` `ArrayList` using a for-each loop, printing each doctor's details.
 * 
 * 7.  **Resource Management:** The `scanner.close()` method is called after the main loop finishes (when the user chooses option 6), releasing the system resource associated with the `Scanner`.
 * 
 * This solution effectively integrates all required components into a functional, well-structured program that simulates a practical scenario while demonstrating key Java programming concepts and best practices expected at an advanced level.
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Represents a patient in the walk-in clinic.
 */
class Patient {
    private String name;

    /**
     * Constructs a new Patient object.
     * @param name The name of the patient. Must not be null or empty.
     * @throws IllegalArgumentException if the name is null or empty.
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
 * Represents a doctor in the walk-in clinic.
 */
class Doctor {
    private String name;
    private String specialty;

    /**
     * Constructs a new Doctor object.
     * @param name The name of the doctor. Must not be null or empty.
     * @param specialty The specialty of the doctor. Must not be null or empty.
     * @throws IllegalArgumentException if name or specialty is null or empty.
     */
    public Doctor(String name, String specialty) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be null or empty.");
        }
         if (specialty == null || specialty.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor specialty cannot be null or empty.");
        }
        this.name = name.trim();
        this.specialty = specialty.trim();
    }

    /**
     * Gets the name of the doctor.
     * @return The doctor's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the specialty of the doctor.
     * @return The doctor's specialty.
     */
    public String getSpecialty() {
        return specialty;
    }

    @Override
    public String toString() {
        return name + " (" + specialty + ")";
    }
}

/**
 * Manages the walk-in clinic operations, including waiting list and doctors.
 */
public class HospitalScheduler {
    // Queue for managing the waiting list (FIFO)
    private Queue<Patient> waitingList;
    // List for managing available doctors
    private List<Doctor> availableDoctors;
    // Scanner for handling user input
    private Scanner scanner;

    /**
     * Constructs a new HospitalScheduler.
     * Initializes the waiting list, doctor list, and scanner.
     */
    public HospitalScheduler() {
        this.waitingList = new LinkedList<>(); // LinkedList implements Queue
        this.availableDoctors = new ArrayList<>(); // ArrayList implements List
        this.scanner = new Scanner(System.in);
    }

    /**
     * Adds a new doctor to the list of available doctors.
     * @param name The doctor's name.
     * @param specialty The doctor's specialty.
     */
    public void addDoctor(String name, String specialty) {
        try {
            Doctor doctor = new Doctor(name, specialty);
            availableDoctors.add(doctor);
            System.out.println(doctor.getName() + " (" + doctor.getSpecialty() + ") added.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding doctor: " + e.getMessage());
        }
    }

    /**
     * Adds a new patient to the waiting list queue.
     * @param name The patient's name.
     */
    public void addWalkInPatient(String name) {
         try {
            Patient patient = new Patient(name);
            waitingList.offer(patient); // offer is preferred over add in queues
            System.out.println(patient.getName() + " added to waiting list.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error adding patient: " + e.getMessage());
        }
    }

    /**
     * Processes the next patient in the waiting list by assigning them to a doctor.
     */
    public void processNextWalkIn() {
        System.out.println("Processing next patient...");

        // Check if there are patients waiting
        if (waitingList.isEmpty()) {
            System.err.println("Error: No patients in the waiting list.");
            return;
        }

        // Check if there are doctors available
        if (availableDoctors.isEmpty()) {
            System.err.println("Error: No doctors available.");
            return;
        }

        // Get the next patient from the queue (and remove them)
        Patient nextPatient = waitingList.poll();

        // Assign the patient to the first available doctor (simple logic)
        Doctor assignedDoctor = availableDoctors.get(0); // Using List's get(index)

        System.out.println(nextPatient.getName() + " is assigned to " + assignedDoctor.getName() + " (" + assignedDoctor.getSpecialty() + ").");
    }

    /**
     * Displays the current list of patients waiting.
     */
    public void listWaitingPatients() {
        System.out.println("\n--- Waiting List ---");
        if (waitingList.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            // Iterate through the queue without removing elements
            int i = 1;
            for (Patient patient : waitingList) {
                System.out.println(i++ + ". " + patient.getName());
            }
        }
    }

    /**
     * Displays the current list of available doctors.
     */
    public void listAvailableDoctors() {
        System.out.println("\n--- Available Doctors ---");
        if (availableDoctors.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            // Iterate through the List
            int i = 1;
            for (Doctor doctor : availableDoctors) {
                System.out.println(i++ + ". " + doctor.getName() + " (" + doctor.getSpecialty() + ")");
            }
        }
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Walk-in Clinic Menu ---");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. Process Next Walk-in");
        System.out.println("4. View Waiting List");
        System.out.println("5. View Available Doctors");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop.
     * Handles user input and calls appropriate methods based on menu selection.
     */
    public void run() {
        int choice = -1;
        while (choice != 6) {
            displayMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading int

                // Use switch statement for flow control
                switch (choice) {
                    case 1:
                        System.out.print("Enter doctor's name: ");
                        String docName = scanner.nextLine();
                        System.out.print("Enter doctor's specialty: ");
                        String docSpecialty = scanner.nextLine();
                        addDoctor(docName, docSpecialty);
                        break;
                    case 2:
                        System.out.print("Enter patient's name: ");
                        String patientName = scanner.nextLine();
                        addWalkInPatient(patientName);
                        break;
                    case 3:
                        processNextWalkIn();
                        break;
                    case 4:
                        listWaitingPatients();
                        break;
                    case 5:
                        listAvailableDoctors();
                        break;
                    case 6:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                // Handle non-integer input for menu choice
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to stay in loop
            } catch (Exception e) {
                 // Catch any other unexpected exceptions during execution
                 System.err.println("An unexpected error occurred: " + e.getMessage());
                 e.printStackTrace(System.err); // Print stack trace to error stream
            }
        }
        // Close the scanner when the application exits
        scanner.close();
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
