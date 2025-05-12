/*
 * Exam Question #40
 * Generated on: 2025-05-11 21:58:34
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment System
 * 
 * **Problem Description:**
 * 
 * Design and implement a simplified Hospital Appointment System in Java. The system should manage a waiting queue of patients seeking consultation with general physicians and maintain a list of available doctors. Users should interact with the system via a command-line interface to perform operations such as adding new patients, having a doctor serve the next patient in the queue, viewing the waiting queue, viewing the list of doctors, and adding new doctors.
 * 
 * **Requirements:**
 * 
 * Your solution must demonstrate advanced understanding of Java concepts by incorporating the following:
 * 
 * 1.  **Data Structures:**
 *     *   Use `java.util.Queue` to represent the patient waiting list, ensuring a First-In, First-Out (FIFO) order.
 *     *   Use `java.util.ArrayList` to store `Doctor` objects.
 *     *   Declare the collection holding `Doctor` objects using the `java.util.List` interface type.
 * 2.  **User Interface:** Implement a command-line interface using `java.util.Scanner` to receive user input for menu selections and data entry.
 * 3.  **Control Flow:** Utilize a `switch` statement to direct program flow based on the user's menu choice.
 * 4.  **Input/Output:**
 *     *   Use `System.out` for displaying the menu, confirmations, lists, and general information messages.
 *     *   Use `System.err` for displaying all error messages.
 * 5.  **Error Handling:**
 *     *   Implement class-wide exception handling using `try-catch` blocks in the main application logic (e.g., around the main menu loop) to catch and report unexpected runtime errors.
 *     *   Include specific `try-catch` blocks for handling anticipated issues like invalid input format from the `Scanner` (`InputMismatchException`).
 *     *   Gracefully handle scenarios where a doctor attempts to serve a patient from an empty waiting queue.
 *     *   Implement basic input validation (e.g., ensuring patient/doctor names are not empty).
 * 6.  **Object-Oriented Design:** Create separate classes for `Patient` and `Doctor` with appropriate private fields and public getter methods (encapsulation). The main system logic should be contained within a dedicated class (e.g., `HospitalSystem`).
 * 7.  **Best Practices:** Adhere to standard Java coding best practices, including:
 *     *   Proper encapsulation for class fields.
 *     *   Using meaningful variable and method names.
 *     *   Adding comments to explain key sections of the code.
 *     *   Ensuring proper resource management (e.g., closing the `Scanner`).
 * 
 * **Expected Output:**
 * 
 * The system should display a clear menu of options upon startup. Based on user input, it should perform the requested action and provide feedback using `System.out` or `System.err` as appropriate. Examples of expected interactions include:
 * 
 * *   Displaying the menu.
 * *   Prompting for input ("Enter your choice: ").
 * *   Prompting for patient/doctor details.
 * *   Confirmation messages (e.g., "Patient '...' added to the queue.").
 * *   Messages indicating the serving of a patient (e.g., "Doctor '...' is now serving Patient '...'.").
 * *   Messages when the queue is empty.
 * *   Listing patients in the queue (ordered).
 * *   Listing available doctors.
 * *   Displaying error messages on `System.err` for invalid choices, invalid input types, empty names, or unexpected errors.
 * *   An exit message when the user chooses to quit.
 * 
 * **Time Limit:** This task is designed to be completed within 45-60 minutes. Focus on meeting all requirements with a clean, functional implementation.
 *
 * EXPLANATION:
 * This solution implements a simplified Hospital Appointment System demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Object-Oriented Design (`Patient`, `Doctor` classes):**
 *     *   The `Patient` and `Doctor` classes represent the core entities.
 *     *   They follow encapsulation principles: fields (`name`, `patientId`, `specialization`, `doctorId`) are `private`, and access is provided through `public` getter methods (`getName()`, `getPatientId()`, etc.).
 *     *   `toString()` methods are overridden for convenient printing of object details.
 *     *   Static counters (`nextId`) are used to assign unique IDs automatically.
 * 
 * 2.  **Data Structures (`Queue`, `List`, `ArrayList`):**
 *     *   `waitingQueue`: Declared as `Queue<Patient>` and initialized with `new LinkedList<>()`. This correctly uses the `Queue` interface and a common concrete implementation (`LinkedList` provides efficient additions/removals from ends). It ensures patients are served in the order they arrive (FIFO), which is the core behavior of a waiting queue. `offer()` is used for adding (safer than `add`), and `poll()` is used for removing from the head (safer than `remove` as it returns `null` on empty queue).
 *     *   `doctors`: Declared as `List<Doctor>` and initialized with `new ArrayList<>()`. This demonstrates polymorphism by using the `List` interface type while using `ArrayList` as the underlying implementation. `ArrayList` is suitable here as we primarily need to store, iterate, and occasionally add doctors, and indexed access (`doctors.get(0)`) is simple for this basic simulation.
 * 
 * 3.  **User Interface and Control Flow (`Scanner`, `switch`):**
 *     *   `Scanner scanner`: Used to read input from the console (`System.in`). `nextLine()` is used after `nextInt()` to consume the leftover newline character, preventing input issues in subsequent `nextLine()` calls.
 *     *   `printMenu()`: A helper method to display the available options to the user using `System.out`.
 *     *   `run()` method: Contains the main application loop (`while (choice != 0)`).
 *     *   `switch (choice)`: Directs the program flow based on the integer entered by the user, calling the appropriate method for each menu option.
 * 
 * 4.  **Input/Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` and `System.out.print()` are used for all normal messages, including the menu, prompts, confirmations, and listing data.
 *     *   `System.err.println()` is exclusively used for displaying error messages, such as invalid menu choices, invalid input types, or validation failures (e.g., empty names). This clearly distinguishes errors from standard output.
 * 
 * 5.  **Error Handling (`try-catch`, Validation):**
 *     *   **Input Validation:** Methods like `addPatient()` and `addDoctor()` check if the entered names or specializations are empty or contain only whitespace using `trim().isEmpty()`. An error message is printed to `System.err`, and the method returns, preventing the creation of invalid objects.
 *     *   **Specific Exception Handling:** Inside the `run()` loop, a `try-catch(InputMismatchException e)` block is used around `scanner.nextInt()`. This handles cases where the user enters non-numeric input for the menu choice, prints an informative error message to `System.err`, and consumes the invalid input to allow the loop to continue. A `NoSuchElementException` catch is also included for robustness, though less common in simple console apps unless the input stream is closed.
 *     *   **Graceful Empty Queue Handling:** The `serveNextPatient()` method uses `waitingQueue.poll()`. If the queue is empty, `poll()` returns `null`, which is checked. A specific message ("No patients currently in the waiting queue.") is printed to `System.out` instead of throwing an exception.
 *     *   **Class-wide Exception Handling:** The entire `while` loop in `run()` is wrapped in a `try-catch(Exception e)` block. This serves as a catch-all for any unexpected `RuntimeException` or other `Exception` that might occur within the system's operation that wasn't specifically handled elsewhere. It prints an error message to `System.err` and the stack trace for debugging.
 * 
 * 6.  **Best Practices:**
 *     *   Encapsulation, meaningful names, and comments are applied as described above.
 *     *   Resource Management: The `Scanner` object is created once and closed in a `finally` block associated with the outer `try` in `run()`. This ensures the `Scanner` is closed properly when the application exits, even if an unexpected exception occurs.
 * 
 * In summary, the solution effectively integrates `Queue`, `List`/`ArrayList`, `Scanner`, `switch`, `System.out`, and `System.err` within an object-oriented structure, incorporating robust error handling and best practices to simulate a practical system scenario.
 */

import java.util.Queue;
import java.util.LinkedList; // A common Queue implementation
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException; // For Scanner input type errors
import java.util.NoSuchElementException; // For potential Scanner stream issues or queue element access (though poll is safer)

// Represents a Patient in the system
class Patient {
    private String name;
    private int patientId;
    private static int nextId = 1; // Auto-incrementing ID

    /**
     * Constructs a new Patient with a given name.
     * @param name The name of the patient.
     */
    public Patient(String name) {
        this.name = name;
        this.patientId = nextId++; // Assign and increment ID
    }

    // Getter for patient name
    public String getName() {
        return name;
    }

    // Getter for patient ID
    public int getPatientId() {
        return patientId;
    }

    /**
     * Provides a string representation of the Patient.
     * @return Formatted string with patient ID and name.
     */
    @Override
    public String toString() {
        return "Patient [ID=" + patientId + ", Name=" + name + "]";
    }
}

// Represents a Doctor in the system
class Doctor {
    private String name;
    private String specialization;
    private int doctorId;
    private static int nextId = 1; // Auto-incrementing ID

    /**
     * Constructs a new Doctor with a given name and specialization.
     * @param name The name of the doctor.
     * @param specialization The specialization of the doctor.
     */
    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.doctorId = nextId++; // Assign and increment ID
    }

    // Getter for doctor name
    public String getName() {
        return name;
    }

    // Getter for doctor specialization
    public String getSpecialization() {
        return specialization;
    }

    // Getter for doctor ID
    public int getDoctorId() {
        return doctorId;
    }

    /**
     * Provides a string representation of the Doctor.
     * @return Formatted string with doctor ID, name, and specialization.
     */
    @Override
    public String toString() {
        return "Doctor [ID=" + doctorId + ", Name=" + name + ", Specialization=" + specialization + "]";
    }
}

// Main class managing the Hospital Appointment System
public class HospitalSystem {
    // Queue for patients waiting to be seen (FIFO)
    private Queue<Patient> waitingQueue;
    // List of doctors available in the system
    private List<Doctor> doctors;
    // Scanner for reading user input
    private Scanner scanner;

    /**
     * Constructs the HospitalSystem, initializing data structures
     * and adding some initial doctors.
     */
    public HospitalSystem() {
        // LinkedList implements Queue and is suitable for this use case
        waitingQueue = new LinkedList<>();
        // ArrayList implements List and is suitable for storing doctors
        doctors = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Add some initial doctors to the system
        doctors.add(new Doctor("Dr. Alan Turing", "General Physician"));
        doctors.add(new Doctor("Dr. Grace Hopper", "General Physician"));
    }

    /**
     * Adds a new patient to the waiting queue based on user input.
     * Includes input validation.
     */
    public void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine(); // Read the full line

        // Input validation: Check if name is empty or just whitespace
        if (name == null || name.trim().isEmpty()) {
             System.err.println("Error: Patient name cannot be empty.");
             return; // Exit the method if validation fails
        }

        Patient newPatient = new Patient(name.trim()); // Create new patient
        waitingQueue.offer(newPatient); // Add patient to the end of the queue (offer is safe)
        System.out.println("Patient '" + newPatient.getName() + "' (ID: " + newPatient.getPatientId() + ") added to the waiting queue.");
    }

    /**
     * Simulates a doctor serving the next patient from the queue.
     * Removes the patient at the front of the queue.
     */
    public void serveNextPatient() {
        // Check if there are doctors available (basic check)
        if (doctors.isEmpty()) {
            System.err.println("Error: No doctors available to serve patients.");
            return;
        }

        // Retrieve and remove the patient at the head of the queue
        // poll() returns null if the queue is empty, which is safer than remove()
        Patient nextPatient = waitingQueue.poll();

        // Handle the case where the queue is empty
        if (nextPatient == null) {
            System.out.println("No patients currently in the waiting queue.");
        } else {
            // For this simplified system, we just pick the first doctor available
            // In a real system, doctor assignment logic would be more complex.
            Doctor servingDoctor = doctors.get(0); // Accessing element from the List

            System.out.println(servingDoctor.getName() + " is now serving " + nextPatient.getName() + " (ID: " + nextPatient.getPatientId() + ").");
        }
    }

    /**
     * Lists all patients currently in the waiting queue without removing them.
     * Iterates through the Queue.
     */
    public void listWaitingQueue() {
        System.out.println("\n--- Waiting Queue ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("The waiting queue is empty.");
        } else {
            // Iterate through the queue elements using a for-each loop
            int position = 1;
            for (Patient patient : waitingQueue) {
                System.out.println(position++ + ". " + patient);
            }
        }
        System.out.println("---------------------\n");
    }

    /**
     * Lists all doctors currently registered in the system.
     * Iterates through the List (ArrayList).
     */
    public void listDoctors() {
        System.out.println("\n--- Available Doctors ---");
        if (doctors.isEmpty()) {
            System.out.println("No doctors listed in the system.");
        } else {
            // Iterate through the list of doctors
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
        System.out.println("-----------------------\n");
    }

    /**
     * Adds a new doctor to the system based on user input.
     * Includes input validation.
     */
    public void addDoctor() {
         System.out.print("Enter doctor name: ");
         String name = scanner.nextLine();
         // Input validation for name
         if (name == null || name.trim().isEmpty()) {
             System.err.println("Error: Doctor name cannot be empty.");
             return;
         }

         System.out.print("Enter doctor specialization: ");
         String specialization = scanner.nextLine();
         // Input validation for specialization
          if (specialization == null || specialization.trim().isEmpty()) {
             System.err.println("Error: Doctor specialization cannot be empty.");
             return;
         }

         Doctor newDoctor = new Doctor(name.trim(), specialization.trim()); // Create new doctor
         doctors.add(newDoctor); // Add doctor to the List (ArrayList)
         System.out.println("Doctor '" + newDoctor.getName() + "' added to the system.");
    }


    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add New Patient to Queue");
        System.out.println("2. Doctor Serves Next Patient");
        System.out.println("3. View Waiting Queue");
        System.out.println("4. View Doctors");
        System.out.println("5. Add New Doctor");
        System.out.println("0. Exit");
    }

    /**
     * Runs the main application loop, handling user interaction
     * and calling appropriate methods. Includes exception handling.
     */
    public void run() {
        System.out.println("--- Hospital Appointment System ---");
        int choice = -1; // Initialize choice

        // Class-wide try-catch block to catch any unexpected runtime exceptions
        // that might occur within the main application loop.
        try {
            while (choice != 0) { // Loop until the user chooses to exit (option 0)
                printMenu(); // Display the menu
                System.out.print("Enter your choice: ");

                // Specific try-catch block for handling potential Scanner input errors
                try {
                    choice = scanner.nextInt(); // Read integer input for choice
                    scanner.nextLine(); // Consume the newline character left by nextInt()

                    // Switch statement to handle different menu options
                    switch (choice) {
                        case 1:
                            addPatient(); // Call method to add a patient
                            break;
                        case 2:
                            serveNextPatient(); // Call method to serve the next patient
                            break;
                        case 3:
                            listWaitingQueue(); // Call method to list the queue
                            break;
                        case 4:
                            listDoctors(); // Call method to list doctors
                            break;
                        case 5:
                            addDoctor(); // Call method to add a doctor
                            break;
                        case 0:
                            System.out.println("Exiting Hospital System. Goodbye!");
                            break; // Exit the loop
                        default:
                            // Handle invalid numeric input (outside of 0-5 range)
                            System.err.println("Error: Invalid choice. Please enter a number between 0 and 5.");
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input for menu choice
                    System.err.println("Error: Invalid input. Please enter a number corresponding to the menu options.");
                    scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
                    choice = -1; // Reset choice to ensure the loop continues
                } catch (NoSuchElementException e) {
                     // Handle potential issues if the input stream is closed unexpectedly
                     System.err.println("Error reading input stream. Exiting application.");
                     choice = 0; // Set choice to 0 to exit the loop
                }
                 // Note: Any other RuntimeExceptions occurring within the case blocks
                 // (like NullPointerException, IndexOutOfBoundsException if not handled)
                 // would be caught by the outer catch(Exception e).

                System.out.println(); // Add a newline for better readability between menu cycles
            }
        } catch (Exception e) {
            // Catch-all for any other unexpected exceptions during runtime
            System.err.println("An unexpected error occurred during system operation: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging purposes
        } finally {
            // Ensure the scanner resource is closed when the application exits
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Scanner closed."); // Optional: Confirmation message
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HospitalSystem system = new HospitalSystem(); // Create an instance of the system
        system.run(); // Start the main application loop
    }
}
