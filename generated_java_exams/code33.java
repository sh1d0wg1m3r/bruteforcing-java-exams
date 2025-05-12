/*
 * Exam Question #33
 * Generated on: 2025-05-11 21:50:56
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Hospital Reception System
 * 
 * **Scenario:**
 * You are tasked with developing a simplified hospital reception desk system. The system needs to manage patients arriving, keep track of those waiting, process patients when a doctor is available, and maintain a record of patients who have been processed.
 * 
 * **Requirements:**
 * 
 * Implement a Java console application that simulates this system. Your solution must adhere to the following:
 * 
 * 1.  **Patient Representation:** Create a `Patient` class with private fields for `patientId` (int), `name` (String), and `reasonForVisit` (String). Include a constructor and public getter methods for these fields. Override the `toString()` method to provide a clear representation of a patient.
 * 2.  **Hospital System Class:** Create a `HospitalSystem` class that contains the main logic.
 *     *   It must have a private field to store patients currently waiting, using a `java.util.Queue<Patient>`.
 *     *   It must have a private field to store patients who have been processed, using a `java.util.List<Patient>` initialized with `java.util.ArrayList`.
 *     *   It must have a private `java.util.Scanner` field for handling user input.
 * 3.  **Functionality:** Implement the following operations within the `HospitalSystem` class:
 *     *   **Add Patient:** Prompt the user for patient details (ID, name, reason). Validate that the ID is a positive integer. Create a `Patient` object and add it to the waiting queue.
 *     *   **Process Next Patient:** Remove the patient at the front of the waiting queue. If a patient is successfully removed, add them to the processed patients list. Handle the case where the waiting queue is empty.
 *     *   **View Waiting Queue:** Display the details of all patients currently in the waiting queue, in the order they are waiting.
 *     *   **View Processed Patients:** Display the details of all patients who have been processed.
 *     *   **Exit:** Terminate the program.
 * 4.  **User Interface:**
 *     *   Present a menu of options to the user (Add Patient, Process Next, View Waiting, View Processed, Exit).
 *     *   Use `java.util.Scanner` to read the user's choice and other input.
 *     *   Use a `switch` statement to handle the different menu options.
 * 5.  **Error Handling and Output:**
 *     *   Use `System.out` for displaying the menu, success messages, and lists of patients.
 *     *   Use `System.err` for displaying error messages (e.g., invalid input, attempting to process from an empty queue).
 *     *   Implement input validation for the patient ID and menu choice.
 *     *   Include class-wide exception handling using `try-catch` blocks within the main execution loop to catch unexpected errors.
 * 6.  **Best Practices:**
 *     *   Employ proper encapsulation (private fields, public getters).
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (JavaDocs).
 *     *   Ensure the `Scanner` is closed when the program exits.
 * 
 * **Expected Output:**
 * 
 * The program should start by displaying the menu. Based on user input, it should perform the requested action and display appropriate output or error messages.
 * 
 * Example Interaction Flow:
 * 
 * ```
 * --- Hospital Reception System ---
 * 1. Add Patient
 * 2. Process Next Patient
 * 3. View Waiting Queue
 * 4. View Processed Patients
 * 5. Exit
 * Enter your choice: 1
 * Enter Patient ID: 101
 * Enter Patient Name: Alice
 * Enter Reason for Visit: Fever
 * Patient 101 added to the waiting queue.
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 1
 * Enter Patient ID: 102
 * Enter Patient Name: Bob
 * Enter Reason for Visit: Checkup
 * Patient 102 added to the waiting queue.
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 3
 * --- Waiting Queue ---
 * Patient ID: 101, Name: Alice, Reason: Fever
 * Patient ID: 102, Name: Bob, Reason: Checkup
 * ---------------------
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 2
 * Processing patient: Patient ID: 101, Name: Alice, Reason: Fever
 * Patient 101 processed successfully.
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 3
 * --- Waiting Queue ---
 * Patient ID: 102, Name: Bob, Reason: Checkup
 * ---------------------
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 4
 * --- Processed Patients ---
 * Patient ID: 101, Name: Alice, Reason: Fever
 * --------------------------
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 2
 * Processing patient: Patient ID: 102, Name: Bob, Reason: Checkup
 * Patient 102 processed successfully.
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 2
 * Error: The waiting queue is empty. No patients to process.
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: abc
 * Error: Invalid input. Please enter a number.
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 1
 * Enter Patient ID: -5
 * Error: Patient ID must be a positive integer.
 * 
 * --- Hospital Reception System ---
 * ... (menu) ...
 * Enter your choice: 5
 * Exiting Hospital Reception System.
 * ```
 * 
 * Your solution should provide the complete Java code for the `Patient` and `HospitalSystem` classes.
 *
 * EXPLANATION:
 * The provided solution implements a simplified hospital reception system demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Patient` Class:** This is a simple Plain Old Java Object (POJO) representing a patient. It encapsulates patient data (`patientId`, `name`, `reasonForVisit`) with private fields and provides public getter methods. The `toString()` method is overridden for easy printing of patient details.
 * 
 * 2.  **`HospitalSystem` Class:** This class contains the core logic.
 *     *   **Data Structures:**
 *         *   `Queue<Patient> waitingQueue`: A `LinkedList` is used to implement the `Queue` interface. This structure is ideal for a waiting list where patients are added at the end (`offer`) and removed from the front (`poll`), following a First-In, First-Out (FIFO) principle.
 *         *   `List<Patient> processedPatients`: An `ArrayList` is used to implement the `List` interface. This stores patients after they have been processed, allowing easy addition and iteration.
 *     *   **`Scanner`:** A `Scanner` is initialized to read input from the console (`System.in`). It's declared as a private field and initialized in the constructor. A `closeScanner()` method is provided to release the resource when the program exits.
 *     *   **Methods:**
 *         *   `displayMenu()`: A helper method to print the available options to `System.out`.
 *         *   `addPatient()`: Reads patient details using the `Scanner`. It includes input validation: reading the ID as a `String` and attempting to parse it into an `int` within a `try-catch(NumberFormatException)` block. It also checks if the ID is positive. If validation passes, a `Patient` object is created and added to the `waitingQueue` using `offer()`. Success messages are printed to `System.out`, and error messages to `System.err`.
 *         *   `processNextPatient()`: Removes the patient at the head of the `waitingQueue` using `poll()`. `poll()` returns `null` if the queue is empty, which is handled by printing an error message to `System.err`. If a patient is returned, they are added to the `processedPatients` `List` using `add()`, and a success message is printed to `System.out`.
 *         *   `viewWaitingQueue()`: Iterates through the `waitingQueue` (which `LinkedList` supports) and prints each patient's details using their `toString()` method to `System.out`. It checks if the queue is empty first.
 *         *   `viewProcessedPatients()`: Iterates through the `processedPatients` `List` and prints each patient's details to `System.out`. It checks if the list is empty first.
 *         *   `run()`: This is the main loop of the application. It continuously displays the menu, reads user input, and uses a `switch` statement to call the appropriate method based on the user's choice.
 *         *   **Class-wide Exception Handling:** The `while` loop in `run()` is wrapped in a `try-catch(Exception e)` block. This demonstrates a top-level catch-all for unexpected runtime errors that might occur within the command processing loop. More specific `try-catch` blocks are used for anticipated errors like `NumberFormatException` during input parsing. Error details are printed to `System.err`.
 *         *   `main()`: The entry point of the program. It creates an instance of `HospitalSystem` and calls its `run()` method.
 * 
 * 3.  **Control Flow and Output:**
 *     *   The `switch` statement in `run()` directs execution based on the user's validated integer choice.
 *     *   `System.out` is used for standard program output (menu, successful operations, list contents).
 *     *   `System.err` is specifically used for displaying error messages, making them distinct from normal output.
 * 
 * 4.  **Best Practices:**
 *     *   **Encapsulation:** Fields in both classes are private, accessed via public methods where necessary.
 *     *   **Naming:** Variable and method names are descriptive (e.g., `waitingQueue`, `processNextPatient`, `reasonForVisit`).
 *     *   **Documentation:** Javadoc comments are included for classes and methods, explaining their purpose.
 *     *   **Input Validation:** Checks are performed for positive patient ID and valid integer menu choices.
 *     *   **Error Handling:** `try-catch` blocks handle potential exceptions during input parsing and operations (like polling an empty queue). `System.err` is used for errors.
 *     *   **Clean Structure:** The code is organized into logical methods, improving readability and maintainability.
 * 
 * This solution effectively integrates all the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) into a practical, albeit simplified, application, demonstrating key object-oriented and programming concepts.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Represents a patient in the hospital system.
 */
class Patient {
    private int patientId;
    private String name;
    private String reasonForVisit;

    /**
     * Constructs a new Patient object.
     * @param patientId The unique ID of the patient.
     * @param name The name of the patient.
     * @param reasonForVisit The reason for the patient's visit.
     */
    public Patient(int patientId, String name, String reasonForVisit) {
        this.patientId = patientId;
        this.name = name;
        this.reasonForVisit = reasonForVisit;
    }

    /**
     * Gets the patient's ID.
     * @return The patient ID.
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Gets the patient's name.
     * @return The patient name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the reason for the patient's visit.
     * @return The reason for visit.
     */
    public String getReasonForVisit() {
        return reasonForVisit;
    }

    /**
     * Returns a string representation of the Patient object.
     * @return A formatted string with patient details.
     */
    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Reason: " + reasonForVisit;
    }
}

/**
 * Manages the hospital reception system, including waiting queue and processed patients.
 */
public class HospitalSystem {

    private Queue<Patient> waitingQueue;
    private List<Patient> processedPatients;
    private Scanner scanner;

    /**
     * Constructs a new HospitalSystem.
     * Initializes the waiting queue, processed patients list, and scanner.
     */
    public HospitalSystem() {
        // Using LinkedList as a Queue implementation
        this.waitingQueue = new LinkedList<>();
        // Using ArrayList as a List implementation
        this.processedPatients = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Hospital Reception System ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Process Next Patient");
        System.out.println("3. View Waiting Queue");
        System.out.println("4. View Processed Patients");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Adds a new patient to the waiting queue based on user input.
     * Includes input validation for the patient ID.
     */
    private void addPatient() {
        int patientId;
        System.out.print("Enter Patient ID: ");
        String idInput = scanner.nextLine(); // Read as line to handle non-integer input gracefully

        try {
            patientId = Integer.parseInt(idInput);
            if (patientId <= 0) {
                System.err.println("Error: Patient ID must be a positive integer.");
                return; // Stop adding this patient
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input for Patient ID. Please enter a number.");
            return; // Stop adding this patient
        }

        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Reason for Visit: ");
        String reason = scanner.nextLine();

        Patient newPatient = new Patient(patientId, name, reason);
        waitingQueue.offer(newPatient); // offer is generally preferred over add for queues
        System.out.println("Patient " + patientId + " added to the waiting queue.");
    }

    /**
     * Processes the next patient from the waiting queue.
     * Removes the patient from the queue and adds them to the processed list.
     * Handles the case where the queue is empty.
     */
    private void processNextPatient() {
        Patient processed = waitingQueue.poll(); // poll returns null if queue is empty

        if (processed != null) {
            System.out.println("Processing patient: " + processed);
            processedPatients.add(processed);
            System.out.println("Patient " + processed.getPatientId() + " processed successfully.");
        } else {
            System.err.println("Error: The waiting queue is empty. No patients to process.");
        }
    }

    /**
     * Displays the list of patients currently in the waiting queue.
     */
    private void viewWaitingQueue() {
        System.out.println("\n--- Waiting Queue ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting queue is empty.");
        } else {
            // Iterate through the queue without removing elements
            for (Patient patient : waitingQueue) {
                System.out.println(patient);
            }
        }
        System.out.println("---------------------");
    }

    /**
     * Displays the list of patients who have been processed.
     */
    private void viewProcessedPatients() {
        System.out.println("\n--- Processed Patients ---");
        if (processedPatients.isEmpty()) {
            System.out.println("No patients have been processed yet.");
        } else {
            // Iterate through the list
            for (Patient patient : processedPatients) {
                System.out.println(patient);
            }
        }
        System.out.println("--------------------------");
    }

    /**
     * Runs the main application loop.
     * Displays the menu and processes user commands using a switch statement.
     * Includes class-wide exception handling.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            String choiceInput = scanner.nextLine();

            // Class-wide exception handling for the main loop operations
            try {
                int choice = Integer.parseInt(choiceInput);

                // Use switch statement for flow control
                switch (choice) {
                    case 1:
                        addPatient();
                        break;
                    case 2:
                        processNextPatient();
                        break;
                    case 3:
                        viewWaitingQueue();
                        break;
                    case 4:
                        viewProcessedPatients();
                        break;
                    case 5:
                        System.out.println("Exiting Hospital Reception System.");
                        running = false;
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (NumberFormatException e) {
                // Specific handling for non-integer menu input
                System.err.println("Error: Invalid input. Please enter a number.");
            } catch (Exception e) {
                // Catch any other unexpected exceptions during operation
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to System.err
            }
        }
        closeScanner();
    }

    /**
     * Closes the scanner resource.
     */
    private void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

    /**
     * Main method to start the HospitalSystem application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem();
        system.run();
    }
}
