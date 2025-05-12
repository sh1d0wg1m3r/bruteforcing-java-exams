/*
 * Exam Question #3
 * Generated on: 2025-05-11 21:21:19
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Hospital Consultation System
 * 
 * **Problem Description:**
 * 
 * Design and implement a simplified Hospital Consultation System in Java. This system will manage a list of registered patients and a queue for patients waiting for a consultation with a doctor. The system should allow users to perform several actions via a command-line interface.
 * 
 * **Requirements:**
 * 
 * 1.  **Patient Management:** Maintain a list of all registered patients. Each patient should have a unique ID (an integer), a name (String), and an age (integer).
 * 2.  **Consultation Queue:** Maintain a queue of patients who are waiting for a consultation. Patients are added to the queue when they "schedule" an appointment and are processed from the front of the queue.
 * 3.  **User Interface:** Provide a command-line menu with the following options:
 *     *   Add New Patient
 *     *   Schedule Consultation (Add patient to queue by ID)
 *     *   Process Next Consultation (Remove patient from front of queue)
 *     *   List All Registered Patients
 *     *   List Patients in Consultation Queue
 *     *   Exit
 * 4.  **Data Structures:**
 *     *   Use `java.util.ArrayList` to store the list of all registered patients.
 *     *   Use `java.util.Queue` (specifically, an implementation like `java.util.LinkedList`) to manage the consultation queue.
 *     *   Use `java.util.List` interface when declaring variables that hold the `ArrayList`.
 * 5.  **Input Handling:**
 *     *   Use `java.util.Scanner` to read user input (menu choices, patient details, patient ID).
 *     *   Implement input validation (e.g., ensure patient ID is positive, handle non-integer input for choices and IDs).
 * 6.  **Control Flow:**
 *     *   Use a `switch` statement to handle the different menu options.
 *     *   Use a loop to keep the menu running until the user chooses to exit.
 * 7.  **Output:**
 *     *   Use `System.out` for normal output (menu, lists, confirmation messages).
 *     *   Use `System.err` to display error messages (e.g., patient not found, invalid input, queue is empty).
 * 8.  **Error Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks, particularly around input operations that might throw exceptions (like `InputMismatchException`) and operations that might fail (like trying to process an empty queue).
 *     *   Handle cases where a patient ID is not found when trying to schedule a consultation.
 *     *   Handle the case where the consultation queue is empty when trying to process an appointment.
 * 9.  **Best Practices:**
 *     *   Create a `Patient` class with private fields and public getter methods (proper encapsulation).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc comments for classes and methods).
 *     *   Ensure clean code structure.
 * 
 * **Expected Output:**
 * 
 * The system should display a menu, prompt the user for input, and perform the requested action. Output should clearly indicate success or failure. Error messages should be distinguishable (using `System.err`). Listing patients or the queue should show relevant details.
 * 
 * Example Interaction Flow (Illustrative):
 * 
 * ```
 * Hospital Consultation System Menu:
 * 1. Add New Patient
 * 2. Schedule Consultation
 * 3. Process Next Consultation
 * 4. List All Registered Patients
 * 5. List Patients in Consultation Queue
 * 6. Exit
 * Enter your choice: 1
 * Enter Patient ID: 101
 * Enter Patient Name: Alice
 * Enter Patient Age: 30
 * Patient added: ID 101, Name: Alice, Age: 30
 * 
 * Enter your choice: 1
 * Enter Patient ID: 102
 * Enter Patient Name: Bob
 * Enter Patient Age: 45
 * Patient added: ID 102, Name: Bob, Age: 45
 * 
 * Enter your choice: 4
 * --- Registered Patients ---
 * ID: 101, Name: Alice, Age: 30
 * ID: 102, Name: Bob, Age: 45
 * 
 * Enter your choice: 2
 * Enter Patient ID to schedule consultation: 101
 * Patient Alice (ID 101) added to consultation queue.
 * 
 * Enter your choice: 2
 * Enter Patient ID to schedule consultation: 102
 * Patient Bob (ID 102) added to consultation queue.
 * 
 * Enter your choice: 5
 * --- Patients in Consultation Queue ---
 * 1. ID: 101, Name: Alice, Age: 30
 * 2. ID: 102, Name: Bob, Age: 45
 * 
 * Enter your choice: 3
 * Processing next consultation...
 * Consultation completed for Patient: ID 101, Name: Alice, Age: 30
 * 
 * Enter your choice: 5
 * --- Patients in Consultation Queue ---
 * 1. ID: 102, Name: Bob, Age: 45
 * 
 * Enter your choice: 3
 * Processing next consultation...
 * Consultation completed for Patient: ID 102, Name: Bob, Age: 45
 * 
 * Enter your choice: 3
 * Processing next consultation...
 * Error: Consultation queue is empty.
 * 
 * Enter your choice: 2
 * Enter Patient ID to schedule consultation: 999
 * Error: Patient with ID 999 not found.
 * 
 * Enter your choice: 6
 * Exiting system.
 * ```
 * 
 * **Constraint:** You must use *all* the Java components listed in the requirements section.
 * 
 * **Time Limit:** 45-60 minutes (simulated).
 *
 * EXPLANATION:
 * This solution implements a simplified Hospital Consultation System as requested, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Patient` Class:**
 *     *   Represents the data structure for a patient.
 *     *   Uses `private` fields (`id`, `name`, `age`) for encapsulation.
 *     *   Provides `public` getter methods (`getId`, `getName`, `getAge`) to access the data.
 *     *   Includes a `toString()` method for easy printing of patient details.
 * 
 * 2.  **`HospitalSystem` Class:**
 *     *   Contains the main logic and data structures.
 *     *   `patientList`: Declared as `List<Patient>` and initialized with `new ArrayList<>()`. This fulfills the requirement of using both `List` interface and `ArrayList` implementation. It stores all registered patients.
 *     *   `consultationQueue`: Declared as `Queue<Patient>` and initialized with `new LinkedList<>()`. This fulfills the requirement of using both `Queue` interface and a `Queue` implementation (`LinkedList`). It manages patients waiting for consultation in FIFO order.
 *     *   `scanner`: An instance of `java.util.Scanner` is used to read input from `System.in`.
 *     *   **`displayMenu()`:** A private helper method to print the menu options.
 *     *   **`addPatient()`:**
 *         *   Prompts the user for patient details using `scanner`.
 *         *   Uses the `getIntInput()` helper for ID and age to handle potential `InputMismatchException`.
 *         *   Includes basic validation (checking if ID is positive, checking for duplicate IDs).
 *         *   Creates a new `Patient` object.
 *         *   Adds the new patient to the `patientList` (`ArrayList`).
 *         *   Uses `System.out` for success messages and `System.err` for validation errors.
 *     *   **`scheduleConsultation()`:**
 *         *   Prompts for a patient ID.
 *         *   Uses `getIntInput()` for ID validation.
 *         *   Iterates through the `patientList` (`ArrayList`) to find the patient by ID.
 *         *   If found, adds the `Patient` object to the `consultationQueue` using `offer()`.
 *         *   Uses `System.out` for success and `System.err` if the patient ID is not found.
 *     *   **`processNextConsultation()`:**
 *         *   Attempts to remove and return the head of the `consultationQueue` using `poll()`.
 *         *   Checks if the result is `null` (meaning the queue was empty).
 *         *   Uses `System.out` to report the processed patient or `System.err` if the queue is empty.
 *     *   **`listAllPatients()`:**
 *         *   Iterates through the `patientList` (`ArrayList`) using a for-each loop.
 *         *   Prints each patient's details using `System.out`.
 *         *   Handles the case where the list is empty.
 *     *   **`listConsultationQueue()`:**
 *         *   Checks if the `consultationQueue` is empty.
 *         *   If not empty, iterates through the `consultationQueue` using a for-each loop. This iterates over the elements without removing them, suitable for listing.
 *         *   Prints each patient's details with an index using `System.out`.
 *     *   **`getIntInput()`:** A private helper method to encapsulate integer input reading and error handling. It uses a `try-catch` block specifically for `InputMismatchException`, consumes the invalid input using `scanner.nextLine()`, and returns -1 to signal an error.
 *     *   **`run()`:**
 *         *   Contains the main application loop (`while (choice != 6)`).
 *         *   Calls `displayMenu()`.
 *         *   Reads the user's choice using the safe `getIntInput()`.
 *         *   Includes a `try-catch` block wrapping the `switch` statement to catch the `-1` error return from `getIntInput()` and potentially other unexpected exceptions (class-wide exception handling).
 *         *   Uses a `switch` statement to direct control flow based on the user's valid choice.
 *         *   Calls the appropriate methods for each case.
 *         *   Uses `System.err` for invalid choice messages.
 *         *   Closes the `scanner` before exiting the loop (good practice).
 *     *   **`main()`:** The entry point of the program. Creates a `HospitalSystem` object and calls its `run()` method.
 * 
 * 3.  **Required Components Usage:**
 *     *   `Queue`: Used for `consultationQueue` (`LinkedList` implementation).
 *     *   `ArrayList`: Used for `patientList`.
 *     *   `List` interface: Used for the declaration `List<Patient> patientList`.
 *     *   `Scanner`: Used for reading user input (`scanner` instance).
 *     *   `Switch statement`: Used in the `run()` method for menu navigation.
 *     *   `System.err`: Used for all error messages (invalid input, not found, empty queue, invalid choice, unexpected exceptions).
 *     *   `System.out`: Used for normal output (menu, prompts, success messages, lists).
 *     *   Class-wide `try-catch`: The `try-catch` block in the `run()` method handles potential exceptions during the main loop execution, including those signaled by `getIntInput()`.
 * 
 * This solution demonstrates object-oriented design with encapsulation, proper use of collection interfaces and implementations, robust input handling with validation and specific error messages using `System.err`, and structured control flow with a `switch` statement within a main application loop, all while adhering to best practices like meaningful names and comments.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a patient in the hospital system.
 */
class Patient {
    private int id;
    private String name;
    private int age;

    /**
     * Constructs a new Patient object.
     * @param id The unique ID of the patient.
     * @param name The name of the patient.
     * @param age The age of the patient.
     */
    public Patient(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Gets the patient's ID.
     * @return The patient ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the patient's name.
     * @return The patient name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the patient's age.
     * @return The patient age.
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}

/**
 * Manages the hospital's patient list and consultation queue.
 */
public class HospitalSystem {

    private List<Patient> patientList;
    private Queue<Patient> consultationQueue;
    private Scanner scanner;

    /**
     * Constructs a new HospitalSystem.
     * Initializes the patient list, consultation queue, and scanner.
     */
    public HospitalSystem() {
        this.patientList = new ArrayList<>(); // Use ArrayList implementing List
        this.consultationQueue = new LinkedList<>(); // Use LinkedList implementing Queue
        this.scanner = new Scanner(System.in); // Scanner for user input
    }

    /**
     * Displays the main menu options to the user.
     */
    private void displayMenu() {
        System.out.println("\nHospital Consultation System Menu:");
        System.out.println("1. Add New Patient");
        System.out.println("2. Schedule Consultation (Add patient to queue by ID)");
        System.out.println("3. Process Next Consultation (Remove patient from front of queue)");
        System.out.println("4. List All Registered Patients");
        System.out.println("5. List Patients in Consultation Queue");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new patient to the system's registered patient list.
     */
    private void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = getIntInput();
        if (id < 0) { // getIntInput returns -1 on error
             System.err.println("Error: Invalid input for Patient ID.");
             return;
        }

        // Check if patient ID already exists
        for (Patient p : patientList) {
            if (p.getId() == id) {
                System.err.println("Error: Patient with ID " + id + " already exists.");
                return;
            }
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = getIntInput();
         if (age < 0) { // getIntInput returns -1 on error
             System.err.println("Error: Invalid input for Patient Age.");
             return;
        }

        Patient newPatient = new Patient(id, name, age);
        patientList.add(newPatient); // Add to ArrayList
        System.out.println("Patient added: " + newPatient); // Use System.out for success
    }

    /**
     * Schedules a consultation by adding a patient to the consultation queue based on their ID.
     */
    private void scheduleConsultation() {
        System.out.print("Enter Patient ID to schedule consultation: ");
        int id = getIntInput();
         if (id < 0) { // getIntInput returns -1 on error
             System.err.println("Error: Invalid input for Patient ID.");
             return;
        }

        // Find the patient in the registered list
        Patient patientToSchedule = null;
        for (Patient patient : patientList) { // Iterate through ArrayList
            if (patient.getId() == id) {
                patientToSchedule = patient;
                break;
            }
        }

        if (patientToSchedule != null) {
            consultationQueue.offer(patientToSchedule); // Add to Queue
            System.out.println("Patient " + patientToSchedule.getName() + " (ID " + id + ") added to consultation queue."); // Use System.out
        } else {
            System.err.println("Error: Patient with ID " + id + " not found."); // Use System.err
        }
    }

    /**
     * Processes the next patient in the consultation queue.
     */
    private void processNextConsultation() {
        System.out.println("Processing next consultation...");
        Patient nextPatient = consultationQueue.poll(); // Remove from Queue

        if (nextPatient != null) {
            System.out.println("Consultation completed for Patient: " + nextPatient); // Use System.out
        } else {
            System.err.println("Error: Consultation queue is empty."); // Use System.err
        }
    }

    /**
     * Lists all registered patients in the system.
     */
    private void listAllPatients() {
        System.out.println("\n--- Registered Patients ---");
        if (patientList.isEmpty()) { // Check if ArrayList is empty
            System.out.println("No patients registered yet.");
        } else {
            for (Patient patient : patientList) { // Iterate through ArrayList (as List)
                System.out.println(patient); // Use System.out
            }
        }
    }

    /**
     * Lists all patients currently waiting in the consultation queue.
     */
    private void listConsultationQueue() {
        System.out.println("\n--- Patients in Consultation Queue ---");
        if (consultationQueue.isEmpty()) { // Check if Queue is empty
            System.out.println("Consultation queue is empty.");
        } else {
            int index = 1;
            // Iterate through the Queue without removing elements
            for (Patient patient : consultationQueue) {
                System.out.println(index++ + ". " + patient); // Use System.out
            }
        }
    }

    /**
     * Helper method to safely get integer input from the scanner.
     * Handles InputMismatchException and returns -1 on error.
     */
    private int getIntInput() {
        try {
            int value = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            return value;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
            return -1; // Indicate an error
        }
    }

    /**
     * Runs the main hospital system application loop.
     */
    public void run() {
        int choice = 0;
        while (choice != 6) {
            displayMenu();
            try {
                choice = getIntInput(); // Use the safe input method

                if (choice == -1) { // getIntInput returned an error
                    System.err.println("Error: Invalid input. Please enter a number."); // Use System.err
                    continue; // Skip the rest of the loop iteration
                }

                switch (choice) { // Use switch statement
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        scheduleConsultation();
                        break;
                    case 3:
                        processNextConsultation();
                        break;
                    case 4:
                        listAllPatients();
                        break;
                    case 5:
                        listConsultationQueue();
                        break;
                    case 6:
                        System.out.println("Exiting system."); // Use System.out
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 6."); // Use System.err
                }
            } catch (Exception e) { // Class-wide exception handling (catch any unexpected errors)
                System.err.println("An unexpected error occurred: " + e.getMessage()); // Use System.err
                e.printStackTrace(); // Print stack trace for debugging (optional in exam)
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the HospitalSystem.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        system.run();
    }
}
