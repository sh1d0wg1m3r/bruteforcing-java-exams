/*
 * Exam Question #2
 * Generated on: 2025-05-11 21:20:41
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Clinic Appointment Scheduler
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified command-line application for a small clinic to manage patient appointments. The system needs to maintain a waiting list of patients who are yet to be scheduled and a list of patients who have been successfully scheduled for an appointment slot. The clinic staff will interact with the system via a simple menu.
 * 
 * **System Requirements:**
 * 
 * 1.  **Patient Management:** Patients are added to a waiting list upon arrival.
 * 2.  **Scheduling:** The system should schedule the *next* patient from the waiting list into a scheduled slot. This operation should remove the patient from the waiting list.
 * 3.  **Viewing:** The staff should be able to view both the current waiting list and the list of scheduled appointments.
 * 4.  **Interaction:** The system must interact with the user via a command-line menu.
 * 5.  **Error Handling:** The system must handle cases where the staff tries to schedule an appointment when the waiting list is empty and handle invalid user input gracefully.
 * 
 * **Technical Requirements:**
 * 
 * Your solution must demonstrate proficiency in core Java concepts by using **ALL** of the following components:
 * 
 * *   `java.util.Queue`: To manage the waiting list (FIFO - First-In, First-Out).
 * *   `java.util.ArrayList`: To store the list of scheduled appointments.
 * *   `java.util.List` interface: At least one variable must be declared using the `List` interface type.
 * *   `java.util.Scanner`: For reading user input from the console.
 * *   `switch` statement: For handling the different menu options.
 * *   `System.err`: For outputting error messages (e.g., invalid input, scheduling from empty list).
 * *   `System.out`: For outputting normal information (menu, lists, success messages).
 * *   Class-wide `try-catch` blocks: The main application loop should use a `try-catch` block to handle potential exceptions, particularly related to input processing and system operations.
 * 
 * **Best Practices:**
 * 
 * *   Implement proper encapsulation using private fields and public methods.
 * *   Use meaningful variable and method names.
 * *   Include appropriate comments and documentation (basic Javadoc-style comments are sufficient for methods/classes).
 * *   Implement input validation (e.g., ensuring menu choice is an integer within the valid range).
 * *   Handle errors gracefully and inform the user.
 * *   Structure your code cleanly with separate classes if necessary (e.g., a `Patient` class and a `ClinicScheduler` class).
 * 
 * **Execution Flow:**
 * 
 * 1.  The application starts and displays a menu.
 * 2.  The user selects an option by entering a number.
 * 3.  The application performs the requested action (add patient, schedule, view lists, exit).
 * 4.  Appropriate messages (success or error) are displayed.
 * 5.  The menu is displayed again, unless the user chooses to exit.
 * 6.  The application terminates when the user chooses to exit.
 * 
 * **Example Interaction (Illustrative):**
 * 
 * ```
 * Clinic Appointment Scheduler Menu:
 * 1. Add Patient to Waitlist
 * 2. Schedule Next Patient
 * 3. View Waitlist
 * 4. View Scheduled Appointments
 * 5. Exit
 * Enter your choice: 1
 * Enter patient name: Alice
 * 
 * Alice added to waitlist.
 * 
 * Clinic Appointment Scheduler Menu:
 * 1. Add Patient to Waitlist
 * 2. Schedule Next Patient
 * 3. View Waitlist
 * 4. View Scheduled Appointments
 * 5. Exit
 * Enter your choice: 1
 * Enter patient name: Bob
 * 
 * Bob added to waitlist.
 * 
 * Clinic Appointment Scheduler Menu:
 * ...
 * Enter your choice: 3
 * 
 * --- Waitlist ---
 * 1. Alice
 * 2. Bob
 * ----------------
 * 
 * Clinic Appointment Scheduler Menu:
 * ...
 * Enter your choice: 2
 * 
 * Scheduling next patient...
 * Successfully scheduled: Alice
 * 
 * Clinic Appointment Scheduler Menu:
 * ...
 * Enter your choice: 3
 * 
 * --- Waitlist ---
 * 1. Bob
 * ----------------
 * 
 * Clinic Appointment Scheduler Menu:
 * ...
 * Enter your choice: 4
 * 
 * --- Scheduled Appointments ---
 * 1. Alice
 * ----------------------------
 * 
 * Clinic Appointment Scheduler Menu:
 * ...
 * Enter your choice: 99
 * 
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * 
 * Clinic Appointment Scheduler Menu:
 * ...
 * Enter your choice: 2
 * 
 * Scheduling next patient...
 * Successfully scheduled: Bob
 * 
 * Clinic Appointment Scheduler Menu:
 * ...
 * Enter your choice: 2
 * 
 * Scheduling next patient...
 * Error: Cannot schedule. Waitlist is empty.
 * 
 * Clinic Appointment Scheduler Menu:
 * ...
 * Enter your choice: 5
 * 
 * Exiting system.
 * ```
 * 
 * **Your Task:**
 * 
 * Write the complete Java code for this Clinic Appointment Scheduler application.
 *
 * EXPLANATION:
 * This solution implements a simple Clinic Appointment Scheduler demonstrating the required Java concepts.
 * 
 * 1.  **`Patient` Class:** A simple class to encapsulate patient data (just the name in this case). It follows encapsulation principles with a private field and a public getter.
 * 
 * 2.  **`ClinicScheduler` Class:** This is the core class managing the clinic's lists.
 *     *   **`Queue<Patient> waitingList`**: Declared as a `Queue` interface and instantiated as a `LinkedList`. This correctly models the waiting list as a First-In, First-Out structure. `offer()` is used for adding patients, and `poll()` for removing the next patient to be scheduled.
 *     *   **`List<Patient> scheduledAppointments`**: Declared using the `List` interface and instantiated as an `ArrayList`. This list stores patients who have been moved from the waiting list. `ArrayList` is suitable here as we mainly need to add and iterate through the scheduled patients.
 *     *   **Encapsulation:** Both `waitingList` and `scheduledAppointments` are private, accessible only through public methods like `addPatientToWaitlist`, `scheduleNextPatient`, `displayWaitlist`, and `displayScheduledAppointments`.
 *     *   **`addPatientToWaitlist(String name)`**: Creates a `Patient` object and adds it to the `waitingList` using `offer()`. Includes basic input validation for the patient name.
 *     *   **`scheduleNextPatient()`**: Uses `waitingList.poll()` to get the next patient. If `poll()` returns `null` (meaning the queue was empty), it signifies that no patient could be scheduled. Otherwise, the patient is added to the `scheduledAppointments` list.
 *     *   **`displayWaitlist()` and `displayScheduledAppointments()`**: Iterate through the respective collections and print the patient names.
 * 
 * 3.  **`ClinicApp` Class (Main Application):**
 *     *   **`main` Method:** The entry point of the application.
 *     *   **`Scanner scanner = new Scanner(System.in);`**: Initializes a `Scanner` to read input from the standard input stream (`System.in`).
 *     *   **`ClinicScheduler scheduler = new ClinicScheduler();`**: Creates an instance of the scheduler.
 *     *   **Main Loop (`while (choice != 5)`)**: Controls the application flow, repeatedly displaying the menu and processing user input until the exit option (5) is chosen.
 *     *   **`displayMenu()`**: A helper method to print the menu options to `System.out`.
 *     *   **`try-catch` Blocks:**
 *         *   The outer `try-catch-finally` block wraps the entire main loop. This demonstrates a class-wide exception handling approach, ensuring that resources like the `Scanner` are closed in the `finally` block even if unexpected exceptions occur.
 *         *   An inner `try-catch (InputMismatchException e)` block specifically handles cases where the user enters non-integer input for the menu choice. It prints an error message to `System.err` and consumes the invalid input using `scanner.next()` to prevent an infinite loop.
 *         *   A general `catch (Exception e)` is included to catch any other potential runtime errors that might occur within the menu processing logic, printing the error message to `System.err`.
 *     *   **`switch (choice)`:** Processes the user's valid integer input. Each case corresponds to a menu option, calling the appropriate method on the `scheduler` object.
 *     *   **`System.out` vs. `System.err`:**
 *         *   `System.out.println()` is used for normal output: displaying the menu, success messages, and list contents.
 *         *   `System.err.println()` is used for error messages: invalid menu choice, scheduling from an empty waitlist, and input errors.
 *     *   **Input Handling:** `scanner.nextInt()` reads the integer choice. `scanner.nextLine()` is called immediately after `nextInt()` to consume the leftover newline character, which is crucial before reading the patient name using `scanner.nextLine()` in case 1.
 *     *   **Error Handling Logic (Case 2):** When scheduling, the return value of `scheduler.scheduleNextPatient()` is checked. If it's `null`, it means the waitlist was empty, and an error message is printed to `System.err`. Otherwise, a success message is printed to `System.out`.
 *     *   **`finally` Block:** Ensures `scanner.close()` is called when the application exits, releasing the system resource.
 * 
 * This solution effectively integrates all required components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) within a practical, encapsulated, and error-handled structure.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a Patient in the clinic system.
 */
class Patient {
    private String name;

    /**
     * Constructs a new Patient with the given name.
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
        return name;
    }
}

/**
 * Manages the waiting list and scheduled appointments for the clinic.
 */
class ClinicScheduler {
    // Using LinkedList as a Queue implementation for the waiting list (FIFO)
    private Queue<Patient> waitingList;
    // Using ArrayList for scheduled appointments
    private List<Patient> scheduledAppointments; // Declared using the List interface

    /**
     * Constructs a new ClinicScheduler, initializing the waiting and scheduled lists.
     */
    public ClinicScheduler() {
        this.waitingList = new LinkedList<>();
        this.scheduledAppointments = new ArrayList<>(); // Instantiated as ArrayList
    }

    /**
     * Adds a patient to the waiting list.
     * @param name The name of the patient to add.
     */
    public void addPatientToWaitlist(String name) {
        if (name == null || name.trim().isEmpty()) {
             System.err.println("Error: Patient name cannot be empty.");
             return;
        }
        Patient patient = new Patient(name.trim());
        waitingList.offer(patient); // offer is preferred over add in queues as it returns false instead of throwing exception if capacity is limited (not the case here, but good practice)
        System.out.println("\n" + patient.getName() + " added to waitlist.");
    }

    /**
     * Schedules the next patient from the waiting list.
     * @return The Patient who was scheduled, or null if the waitlist was empty.
     */
    public Patient scheduleNextPatient() {
        Patient nextPatient = waitingList.poll(); // poll retrieves and removes the head of the queue, returns null if empty
        if (nextPatient != null) {
            scheduledAppointments.add(nextPatient); // Add to the list of scheduled appointments
            return nextPatient;
        } else {
            // Signify that no patient was available to schedule
            return null;
        }
    }

    /**
     * Displays the current waiting list.
     */
    public void displayWaitlist() {
        System.out.println("\n--- Waitlist ---");
        if (waitingList.isEmpty()) {
            System.out.println("Waitlist is empty.");
        } else {
            int index = 1;
            for (Patient patient : waitingList) {
                System.out.println(index++ + ". " + patient.getName());
            }
        }
        System.out.println("----------------\n");
    }

    /**
     * Displays the list of scheduled appointments.
     */
    public void displayScheduledAppointments() {
        System.out.println("\n--- Scheduled Appointments ---");
        if (scheduledAppointments.isEmpty()) {
            System.out.println("No appointments scheduled yet.");
        } else {
            int index = 1;
            for (Patient patient : scheduledAppointments) {
                System.out.println(index++ + ". " + patient.getName());
            }
        }
        System.out.println("----------------------------\n");
    }

    /**
     * Checks if the waiting list is empty.
     * @return true if the waiting list is empty, false otherwise.
     */
    public boolean isWaitlistEmpty() {
        return waitingList.isEmpty();
    }
}

/**
 * Main class for the Clinic Appointment Scheduler application.
 */
public class ClinicApp {

    /**
     * Displays the main menu options.
     */
    private static void displayMenu() {
        System.out.println("Clinic Appointment Scheduler Menu:");
        System.out.println("1. Add Patient to Waitlist");
        System.out.println("2. Schedule Next Patient");
        System.out.println("3. View Waitlist");
        System.out.println("4. View Scheduled Appointments");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Main method to run the Clinic Appointment Scheduler.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ClinicScheduler scheduler = new ClinicScheduler();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Class-wide try-catch block for handling potential exceptions during runtime
        try {
            while (choice != 5) {
                displayMenu();

                try {
                    choice = scanner.nextInt();
                    // Consume the newline character left by nextInt()
                    scanner.nextLine();

                    switch (choice) {
                        case 1:
                            System.out.print("Enter patient name: ");
                            String patientName = scanner.nextLine();
                            scheduler.addPatientToWaitlist(patientName);
                            break;
                        case 2:
                            System.out.println("\nScheduling next patient...");
                            Patient scheduledPatient = scheduler.scheduleNextPatient();
                            if (scheduledPatient != null) {
                                System.out.println("Successfully scheduled: " + scheduledPatient.getName());
                            } else {
                                System.err.println("Error: Cannot schedule. Waitlist is empty.");
                            }
                            break;
                        case 3:
                            scheduler.displayWaitlist();
                            break;
                        case 4:
                            scheduler.displayScheduledAppointments();
                            break;
                        case 5:
                            System.out.println("\nExiting system.");
                            break;
                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input for menu choice
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                    choice = -1; // Reset choice to continue loop
                } catch (Exception e) {
                    // Catch any other unexpected exceptions during operation
                    System.err.println("An unexpected error occurred: " + e.getMessage());
                    // e.printStackTrace(); // Uncomment for debugging
                }
                // Add a small pause or prompt before showing the menu again for better readability
                 if (choice != 5) {
                     //System.out.println("Press Enter to continue...");
                     //scanner.nextLine(); // Wait for user input - optional
                 }
            }
        } finally {
            // Ensure the scanner is closed regardless of how the loop exits
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
