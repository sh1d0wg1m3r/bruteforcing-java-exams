/*
 * Exam Question #8
 * Generated on: 2025-05-11 21:29:37
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam - Hospital Appointment Scheduler
 * 
 * **Objective:** Design and implement a simple command-line hospital appointment scheduler simulation. The system manages patients waiting to be seen and a record of patients who have completed their appointments.
 * 
 * **Requirements:**
 * 
 * 1.  **Patient Management:**
 *     *   Maintain a waiting list of patients using a `Queue`. Patients are added to the end of the queue when they arrive.
 *     *   Maintain a list of patients who have completed their appointments using an `ArrayList`, referenced via the `List` interface type.
 *     *   Each patient should be represented by a simple class (`Patient`) containing at least their name. This class must use proper encapsulation (private fields, public getters).
 * 
 * 2.  **User Interaction:**
 *     *   The program must present a menu of options to the user:
 *         *   Add a new patient to the waiting list.
 *         *   Process the next patient from the waiting list (move them to the completed list).
 *         *   View the current waiting list.
 *         *   View the list of completed appointments.
 *         *   Exit the program.
 *     *   Use `Scanner` to read user input for menu choices and patient names.
 *     *   Use a `switch` statement to handle the different menu options.
 *     *   The program should run in a loop until the user chooses to exit.
 * 
 * 3.  **Output and Error Handling:**
 *     *   Use `System.out` for displaying the menu, prompts, success messages, and list contents.
 *     *   Use `System.err` for displaying error messages (e.g., invalid menu choice, trying to process a patient when the waiting list is empty, empty patient name input).
 *     *   Implement input validation for patient names (e.g., cannot be empty).
 *     *   Implement class-wide exception handling using a `try-catch` block to catch potential unexpected errors during program execution.
 * 
 * 4.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments to explain the code.
 *     *   Follow standard Java code formatting.
 * 
 * **Implementation Details:**
 * 
 * *   The `Queue` and `List` instances should be managed within the main class (e.g., `HospitalScheduler`).
 * *   The `Patient` class should be simple and focused only on storing the patient's name.
 * 
 * **Expected Output:**
 * 
 * The program should start by displaying a welcome message and the menu. It should then repeatedly prompt the user for input.
 * 
 * *   Adding a patient: Prompt for name, add to queue, print confirmation.
 * *   Processing patient: If queue is not empty, remove from queue, add to completed list, print confirmation with patient name. If queue is empty, print error to `System.err`.
 * *   Viewing lists: Print the contents of the respective list, indicating if it's empty.
 * *   Invalid input: Print error message to `System.err`.
 * *   Exit: Print a goodbye message and terminate.
 * 
 * **Example Interaction Snippet:**
 * 
 * ```
 * --- Hospital Appointment Scheduler ---
 * Please choose an option:
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Completed Appointments
 * 5. Exit
 * Enter choice: 1
 * Enter patient name: Alice
 * Alice added to the waiting list.
 * 
 * --- Hospital Appointment Scheduler ---
 * Please choose an option:
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Completed Appointments
 * 5. Exit
 * Enter choice: 1
 * Enter patient name: Bob
 * Bob added to the waiting list.
 * 
 * --- Hospital Appointment Scheduler ---
 * Please choose an option:
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Completed Appointments
 * 5. Exit
 * Enter choice: 3
 * --- Waiting List ---
 * 1. Alice
 * 2. Bob
 * --------------------
 * 
 * --- Hospital Appointment Scheduler ---
 * Please choose an option:
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Completed Appointments
 * 5. Exit
 * Enter choice: 2
 * Processing next patient: Alice
 * Alice moved to completed appointments.
 * 
 * --- Hospital Appointment Scheduler ---
 * Please choose an option:
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Completed Appointments
 * 5. Exit
 * Enter choice: 3
 * --- Waiting List ---
 * 1. Bob
 * --------------------
 * 
 * --- Hospital Appointment Scheduler ---
 * Please choose an option:
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Completed Appointments
 * 5. Exit
 * Enter choice: 4
 * --- Completed Appointments ---
 * 1. Alice
 * --------------------
 * 
 * --- Hospital Appointment Scheduler ---
 * Please choose an option:
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Completed Appointments
 * 5. Exit
 * Enter choice: 6
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * 
 * --- Hospital Appointment Scheduler ---
 * Please choose an option:
 * 1. Add Patient to Waiting List
 * 2. Process Next Patient
 * 3. View Waiting List
 * 4. View Completed Appointments
 * 5. Exit
 * Enter choice: 5
 * Exiting Hospital Appointment Scheduler. Goodbye!
 * ```
 * 
 * Your task is to write the complete Java code for this system.
 *
 * EXPLANATION:
 * This solution implements a basic hospital appointment scheduler simulation, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **`Patient` Class:**
 *     *   A simple class `Patient` is created to represent a patient.
 *     *   It has a private field `name` and a public getter `getName()`, fulfilling the encapsulation requirement.
 *     *   The `toString()` method is overridden for convenience when printing `Patient` objects directly (though in the main logic, `p.getName()` is used explicitly for clarity).
 * 
 * 2.  **Data Structures (`Queue`, `ArrayList`, `List`):**
 *     *   `waitingList`: A `Queue<Patient>` implemented using `LinkedList` (`new LinkedList<>()`) is used to store patients waiting in a FIFO (First-In, First-Out) order, which is the natural behavior for a waiting list. `offer()` is used for adding, and `poll()` for removing from the head.
 *     *   `completedAppointments`: An `ArrayList<Patient>` (`new ArrayList<>()`) is used to store patients after they have been processed. It is declared using the `List` interface type (`List<Patient> completedAppointments`), demonstrating the preference for coding to interfaces. This list maintains the order in which patients were processed.
 * 
 * 3.  **User Interaction (`Scanner`, `switch`):**
 *     *   A `Scanner` reads input from `System.in`.
 *     *   The program runs inside a `while(running)` loop.
 *     *   A `printMenu()` helper method displays the options.
 *     *   User input for the menu choice is read.
 *     *   A `switch` statement directs the program flow based on the user's integer choice, handling each case (add, process, view waiting, view completed, exit) and a `default` case for invalid input.
 * 
 * 4.  **Output and Error Handling (`System.out`, `System.err`, `try-catch`):**
 *     *   `System.out.println()` is used for standard output like the menu, prompts, success messages, and list contents.
 *     *   `System.err.println()` is used specifically for error messages, such as when the user enters an invalid menu choice, tries to process an empty queue, or provides an empty patient name.
 *     *   Input validation checks if the entered patient name is empty (`name.isEmpty()`).
 *     *   Input validation for the integer choice includes a nested `try-catch` block specifically for `InputMismatchException` when reading the integer choice, preventing crashes if the user enters non-numeric input. `scanner.next()` is used to consume the invalid token in this case.
 *     *   A large `try-catch(Exception e)` block wraps the main program loop (`while(running)`), providing a class-wide catch-all for any unexpected exceptions that might occur during execution. This demonstrates robust error handling by catching general errors and printing details (`e.getMessage()`, `e.printStackTrace(System.err)`) to `System.err`.
 *     *   A `finally` block ensures the `scanner` is closed when the program exits, whether normally or due to an exception caught by the outer `try-catch`.
 * 
 * 5.  **Best Practices:**
 *     *   Meaningful names (`waitingList`, `completedAppointments`, `processNextPatient`, `printMenu`).
 *     *   Comments explain the purpose of classes, fields, and key logic sections.
 *     *   Encapsulation is used in the `Patient` class.
 *     *   Coding to the `List` interface (`List<Patient> completedAppointments = new ArrayList<>();`).
 *     *   Proper resource management by closing the `Scanner`.
 * 
 * This solution effectively integrates the required Java components into a practical simulation while adhering to best practices and demonstrating robust error handling.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a patient in the scheduling system.
class Patient {
    private String name;

    // Constructor
    public Patient(String name) {
        this.name = name;
    }

    // Getter for name (encapsulation)
    public String getName() {
        return name;
    }

    // Optional: Override toString for easy printing
    @Override
    public String toString() {
        return name;
    }
}

// Main class for the Hospital Appointment Scheduler
public class HospitalScheduler {

    // Queue for patients waiting to be seen
    private static Queue<Patient> waitingList = new LinkedList<>();

    // List for patients who have completed their appointments
    // Using List interface type with ArrayList implementation
    private static List<Patient> completedAppointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide exception handling block
        try {
            while (running) {
                printMenu();
                System.out.print("Enter choice: ");

                int choice = -1;
                try {
                    // Read integer choice, handle non-integer input
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop iteration
                } finally {
                     // Consume the newline character left by nextInt()
                     // This is important before reading a line with nextLine()
                     scanner.nextLine();
                }


                // Use switch statement for menu control
                switch (choice) {
                    case 1:
                        // Add Patient
                        System.out.print("Enter patient name: ");
                        String name = scanner.nextLine().trim(); // Trim whitespace

                        // Input validation for patient name
                        if (name.isEmpty()) {
                            System.err.println("Error: Patient name cannot be empty.");
                        } else {
                            Patient newPatient = new Patient(name);
                            waitingList.offer(newPatient); // offer() is preferred for Queue (returns false on failure, doesn't throw)
                            System.out.println(name + " added to the waiting list.");
                        }
                        break;

                    case 2:
                        // Process Next Patient
                        // Check if the waiting list is empty
                        if (waitingList.isEmpty()) {
                            System.err.println("Error: Waiting list is empty. No patient to process.");
                        } else {
                            Patient nextPatient = waitingList.poll(); // poll() retrieves and removes the head (returns null if empty)
                            completedAppointments.add(nextPatient);
                            System.out.println("Processing next patient: " + nextPatient.getName());
                            System.out.println(nextPatient.getName() + " moved to completed appointments.");
                        }
                        break;

                    case 3:
                        // View Waiting List
                        System.out.println("\n--- Waiting List ---");
                        if (waitingList.isEmpty()) {
                            System.out.println("Waiting list is empty.");
                        } else {
                            int index = 1;
                            // Iterate through the queue (order is preserved)
                            for (Patient p : waitingList) {
                                System.out.println(index++ + ". " + p.getName());
                            }
                        }
                        System.out.println("--------------------");
                        break;

                    case 4:
                        // View Completed Appointments
                        System.out.println("\n--- Completed Appointments ---");
                        if (completedAppointments.isEmpty()) {
                            System.out.println("No appointments completed yet.");
                        } else {
                            int index = 1;
                            // Iterate through the list
                            for (Patient p : completedAppointments) {
                                System.out.println(index++ + ". " + p.getName());
                            }
                        }
                        System.out.println("--------------------");
                        break;

                    case 5:
                        // Exit
                        running = false;
                        System.out.println("Exiting Hospital Appointment Scheduler. Goodbye!");
                        break;

                    default:
                        // Handle invalid menu choices
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                        break;
                }
                System.out.println(); // Add a blank line for better readability
            }
        } catch (Exception e) {
            // Catch any unexpected exception during the program execution
            System.err.println("\nAn unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to standard error
        } finally {
            // Ensure the scanner is closed
            scanner.close();
            System.out.println("Scanner closed."); // Optional: Confirmation
        }
    }

    // Helper method to print the menu
    private static void printMenu() {
        System.out.println("--- Hospital Appointment Scheduler ---");
        System.out.println("Please choose an option:");
        System.out.println("1. Add Patient to Waiting List");
        System.out.println("2. Process Next Patient");
        System.out.println("3. View Waiting List");
        System.out.println("4. View Completed Appointments");
        System.out.println("5. Exit");
    }
}
