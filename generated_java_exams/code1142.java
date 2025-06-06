/*
 * Exam Question #1142
 * Generated on: 2025-05-12 17:30:46
 * Generated by: Account 5
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Hospital Appointment and Waiting List System
 * 
 * **Objective:** Design and implement a simple console-based hospital appointment system that allows booking, viewing, and cancelling appointments. The system should also manage a waiting list for appointment slots that are already booked.
 * 
 * **Requirements:**
 * 
 * 1.  Implement a `HospitalAppointmentSystem` class with a `main` method to run the application.
 * 2.  Create an `Appointment` class to represent an appointment with fields for patient name, doctor name, and date/time (use `String` for simplicity).
 * 3.  Create an `AppointmentSystem` class that manages the collection of appointments and waiting lists.
 * 4.  The `AppointmentSystem` class must use:
 *     *   A `java.util.List` (implemented by `java.util.ArrayList`) to store booked `Appointment` objects.
 *     *   A `java.util.Map` where keys represent appointment slots (e.g., "DoctorName@DateTime") and values are `java.util.Queue` (implemented by `java.util.LinkedList`) storing patient names waiting for that specific slot.
 * 5.  The `HospitalAppointmentSystem` (main class) must use `java.util.Scanner` to read user input from the console.
 * 6.  Implement the following functionalities via a menu in the `main` method:
 *     *   **Book Appointment:**
 *         *   Prompt for patient name, doctor name, and date/time.
 *         *   Check if the requested slot (doctor and date/time) is available.
 *         *   If available, create and add the `Appointment` to the list. Print a success message using `System.out`.
 *         *   If the slot is *not* available, inform the user and ask if they want to join the waiting list for *that specific slot*.
 *         *   If they choose yes, add the patient's name to the `Queue` associated with that slot key in the waiting list map. Print a confirmation using `System.out`.
 *         *   Handle cases where user input is empty for required fields using `System.err`.
 *     *   **View All Appointments:**
 *         *   List all booked appointments using `System.out`. If the list is empty, print a message.
 *     *   **Cancel Appointment:**
 *         *   Prompt for patient name, doctor name, and date/time to identify the appointment to cancel.
 *         *   Find and remove the matching appointment from the list.
 *         *   If the appointment is not found, throw a custom exception `AppointmentNotFoundException`.
 *         *   If the appointment is successfully cancelled, check the waiting list map using the cancelled slot's key. If a queue exists and is not empty, remove the *first* patient from the queue and print a notification message using `System.out` indicating that the slot is available and notifying the patient. Remove the key from the waiting list map if the queue becomes empty.
 *         *   Print a success message using `System.out`.
 *     *   **View Waiting Lists:**
 *         *   Iterate through the waiting list map and print each slot with the list of patients in its queue using `System.out`. If no waiting lists exist, print a message.
 *     *   **Exit:** Terminate the program.
 * 7.  Use a `switch` statement in the main loop to handle the user's menu choice.
 * 8.  Implement class-wide exception handling using `try-catch` blocks in the `main` method's loop to catch potential errors like invalid menu input (`NumberFormatException`), `AppointmentNotFoundException`, and a general `Exception` for unexpected issues. Print error messages using `System.err`.
 * 9.  Follow best practices:
 *     *   Use meaningful variable and method names.
 *     *   Employ proper encapsulation (private fields, public methods).
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Perform basic input validation (e.g., checking for empty strings).
 * 
 * **Expected Output:**
 * 
 * Your program should interact with the user via the console, presenting a menu and providing feedback on operations. Examples of interactions:
 * 
 * ```
 * --- Hospital Appointment System ---
 * 1. Book Appointment
 * 2. View All Appointments
 * 3. Cancel Appointment
 * 4. View Waiting Lists
 * 0. Exit
 * -----------------------------------
 * Enter choice: 1
 * 
 * --- Book Appointment ---
 * Enter Patient Name: Alice
 * Enter Doctor Name: Dr. Smith
 * Enter Date and Time (e.g., 2023-10-27 10:00): 2023-10-27 10:00
 * Appointment booked successfully for Alice with Dr. Smith at 2023-10-27 10:00
 * 
 * --- Hospital Appointment System ---
 * ... (menu)
 * Enter choice: 1
 * 
 * --- Book Appointment ---
 * Enter Patient Name: Bob
 * Enter Doctor Name: Dr. Smith
 * Enter Date and Time (e.g., 2023-10-27 10:00): 2023-10-27 10:00
 * Slot 2023-10-27 10:00 with Dr. Smith is already booked.
 * Join waiting list for this slot? (yes/no): yes
 * You have been added to the waiting list for this slot.
 * 
 * --- Hospital Appointment System ---
 * ... (menu)
 * Enter choice: 4
 * 
 * --- Waiting Lists ---
 * Waiting list for slot [Dr. Smith@2023-10-27 10:00]:
 *   Patients: [Bob]
 * 
 * --- Hospital Appointment System ---
 * ... (menu)
 * Enter choice: 3
 * 
 * --- Cancel Appointment ---
 * Enter Patient Name for appointment to cancel: Alice
 * Enter Doctor Name for appointment to cancel: Dr. Smith
 * Enter Date and Time for appointment to cancel (e.g., 2023-10-27 10:00): 2023-10-27 10:00
 * Appointment cancelled successfully.
 * Notification: Appointment slot 2023-10-27 10:00 with Dr. Smith is now available.
 * Notifying next patient on waiting list: Bob
 * 
 * --- Hospital Appointment System ---
 * ... (menu)
 * Enter choice: 4
 * 
 * --- Waiting Lists ---
 * No active waiting lists.
 * 
 * --- Hospital Appointment System ---
 * ... (menu)
 * Enter choice: abc
 * Invalid input. Please enter a number.
 * 
 * --- Hospital Appointment System ---
 * ... (menu)
 * Enter choice: 3
 * 
 * --- Cancel Appointment ---
 * Enter Patient Name for appointment to cancel: NonExistentPatient
 * Enter Doctor Name for appointment to cancel: Dr. Nobody
 * Enter Date and Time (e.g., 2023-10-27 10:00): 2023-10-27 12:00
 * Error cancelling appointment: Appointment not found for Patient: NonExistentPatient, Doctor: Dr. Nobody, Time: 2023-10-27 12:00
 * 
 * --- Hospital Appointment System ---
 * ... (menu)
 * Enter choice: 0
 * Exiting system. Goodbye!
 * ```
 * 
 * Implement the Java code to fulfill these requirements.
 *
 * EXPLANATION:
 * This solution implements a console-based hospital appointment system using the required Java components and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Appointment`: A simple POJO (Plain Old Java Object) class encapsulating appointment details (patient, doctor, time). Fields are `private` with public getters, demonstrating encapsulation.
 *     *   `AppointmentSystem`: This class contains the core logic for managing appointments and waiting lists. It holds the data structures (`List` and `Map` of `Queue`) and methods for booking, viewing, cancelling, and managing waiting lists.
 *     *   `HospitalAppointmentSystem`: The main class containing the `main` method. It handles user interaction, displays the menu, reads input using `Scanner`, and delegates tasks to the `AppointmentSystem`. It also contains the central `try-catch` block for exception handling.
 *     *   `AppointmentNotFoundException`: A custom checked exception used to signal that a requested appointment (e.g., for cancellation) could not be found.
 * 
 * 2.  **Data Structures (`java.util.List`, `java.util.ArrayList`, `java.util.Queue`, `java.util.LinkedList`, `java.util.Map`, `java.util.HashMap`):**
 *     *   `List<Appointment> appointments`: Declared using the `List` interface and instantiated as `ArrayList`. This list stores all successfully booked appointments. `ArrayList` is suitable here for dynamic resizing and easy iteration/removal.
 *     *   `Map<String, Queue<String>> waitingLists`: A `Map` is used to associate a specific appointment slot (represented by a `String` key "DoctorName@DateTime") with a waiting list.
 *     *   `Queue<String>`: The value in the `waitingLists` map is a `Queue`, instantiated as a `LinkedList`. `Queue` provides FIFO (First-In, First-Out) behavior, which is appropriate for a waiting list where the first person to join is the first person notified when a slot opens up. `LinkedList` is a common class that implements the `Queue` interface. `offer()` adds to the tail, `poll()` removes from the head.
 * 
 * 3.  **User Input (`java.util.Scanner`):**
 *     *   A `Scanner` object is created in the `HospitalAppointmentSystem` class to read input from `System.in`.
 *     *   `scanner.nextLine()` is used consistently to read entire lines, avoiding common pitfalls with `nextInt()` or `nextDouble()` leaving newline characters behind. `Integer.parseInt()` is used to convert the menu choice string to an integer.
 * 
 * 4.  **Control Flow (`switch` statement):**
 *     *   The `run` method in `HospitalAppointmentSystem` uses a `switch` statement based on the user's integer choice to navigate between different functionalities (book, view, cancel, waiting lists, exit).
 * 
 * 5.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` and `System.out.print()` are used for displaying the menu, prompts, successful operation messages, and lists of appointments/waiting lists.
 *     *   `System.err.println()` is used specifically for printing error messages, such as invalid user input, booking conflicts (if not joining the waiting list), or exceptions caught during execution.
 * 
 * 6.  **Exception Handling (`try-catch`, custom exception):**
 *     *   A `try-catch` block in the `HospitalAppointmentSystem.run` method surrounds the main loop logic. This provides class-wide exception handling.
 *     *   It specifically catches `NumberFormatException` for invalid menu input.
 *     *   It catches the custom `AppointmentNotFoundException` thrown by the `cancelAppointment` method if the specified appointment cannot be found.
 *     *   A general `catch (Exception e)` is included as a fallback to catch any other unexpected runtime errors, demonstrating robust handling.
 *     *   The `cancelAppointment` method in `AppointmentSystem` declares `throws AppointmentNotFoundException`, indicating that the caller (`HospitalAppointmentSystem.run`) must handle this specific potential error.
 * 
 * 7.  **Business Logic:**
 *     *   **Booking:** Checks slot availability by iterating through the `appointments` list. If taken, it offers the waiting list option and adds the patient to the relevant `Queue` in the `waitingLists` map using `joinWaitingList`.
 *     *   **Cancellation:** Finds the appointment by matching patient, doctor, and time. If found, it's removed from the `appointments` `ArrayList`. It then checks the `waitingLists` map for a `Queue` associated with the cancelled slot. If a queue exists and isn't empty, `poll()` is used to get the first patient, and a notification is printed. The queue/map entry is cleaned up if the queue becomes empty. If the appointment isn't found after iterating the list, `AppointmentNotFoundException` is thrown.
 * 
 * 8.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Appointment` and `AppointmentSystem` are private, accessed via public methods.
 *     *   **Naming:** Variable and method names are descriptive (e.g., `bookAppointment`, `waitingLists`, `patientName`).
 *     *   **Documentation:** Javadoc comments explain the purpose of classes and methods.
 *     *   **Input Validation:** Basic checks for empty input strings are performed before processing.
 *     *   **Error Handling:** Explicit exception types (`NumberFormatException`, `AppointmentNotFoundException`) and general `Exception` handling are used, with clear error messages to `System.err`.
 *     *   **Code Structure:** The logic is divided into logical classes, making the code more organized and maintainable.
 * 
 * This solution effectively integrates the required Java components to build a functional system, demonstrating understanding of data structures, object-oriented principles, user interaction, and exception handling in Java.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList; // LinkedList implements Queue
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 * Custom exception for indicating that an appointment was not found.
 */
class AppointmentNotFoundException extends Exception {
    /**
     * Constructs a new AppointmentNotFoundException with the specified detail message.
     * @param message the detail message.
     */
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}

/**
 * Represents a single appointment.
 */
class Appointment {
    private String patientName;
    private String doctorName;
    private String dateTime; // Using String for simplicity

    /**
     * Constructs a new Appointment.
     * @param patientName The name of the patient.
     * @param doctorName The name of the doctor.
     * @param dateTime The date and time of the appointment (as a String).
     */
    public Appointment(String patientName, String doctorName, String dateTime) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.dateTime = dateTime;
    }

    // Getters
    public String getPatientName() { return patientName; }
    public String getDoctorName() { return doctorName; }
    public String getDateTime() { return dateTime; }

    /**
     * Provides a string representation of the appointment.
     * @return A formatted string describing the appointment.
     */
    @Override
    public String toString() {
        return "Patient: " + patientName + ", Doctor: " + doctorName + ", Time: " + dateTime;
    }

    // Note: equals() and hashCode() are not strictly necessary for this specific
    // implementation because Appointment objects are stored in an ArrayList
    // and identified for cancellation by iterating and comparing fields,
    // and the waiting list map uses a String key ("DoctorName@DateTime").
    // However, implementing them would be good practice if Appointment objects
    // were used as keys in Maps or elements in Sets where value equality matters.
}

/**
 * Manages appointments and waiting lists.
 */
class AppointmentSystem {
    // List interface holding Appointment objects, implemented by ArrayList
    private List<Appointment> appointments;
    // Map where key is a slot string (DoctorName@DateTime) and value is a Queue of patient names
    private Map<String, Queue<String>> waitingLists;

    /**
     * Constructs a new AppointmentSystem, initializing the appointment list and waiting lists map.
     */
    public AppointmentSystem() {
        this.appointments = new ArrayList<>(); // Use ArrayList
        this.waitingLists = new HashMap<>();   // Use HashMap
    }

    /**
     * Generates a unique key string for an appointment slot based on doctor and time.
     * @param doctorName The doctor's name.
     * @param dateTime The date and time.
     * @return A string key for the slot.
     */
    private String generateAppointmentKey(String doctorName, String dateTime) {
        return doctorName.trim().toLowerCase() + "@" + dateTime.trim().toLowerCase();
    }

    /**
     * Checks if a specific appointment slot (doctor and time) is available.
     * @param doctorName The doctor's name.
     * @param dateTime The date and time.
     * @return true if the slot is available, false otherwise.
     */
    private boolean isSlotAvailable(String doctorName, String dateTime) {
        String key = generateAppointmentKey(doctorName, dateTime);
        for (Appointment appt : appointments) {
            // Compare using generated key logic for consistency
            if (generateAppointmentKey(appt.getDoctorName(), appt.getDateTime()).equals(key)) {
                return false; // Found an appointment for this doctor at this time
            }
        }
        return true; // No appointment found for this slot
    }

    /**
     * Attempts to book a new appointment.
     * If the slot is already booked, returns false.
     * @param patientName The name of the patient.
     * @param doctorName The name of the doctor.
     * @param dateTime The date and time of the appointment.
     * @return true if the appointment was successfully booked, false if the slot was taken.
     */
    public boolean bookAppointment(String patientName, String doctorName, String dateTime) {
        if (isSlotAvailable(doctorName, dateTime)) {
            Appointment newAppointment = new Appointment(patientName, doctorName, dateTime);
            appointments.add(newAppointment); // Add to ArrayList
            return true; // Successfully booked
        } else {
            return false; // Slot taken
        }
    }

    /**
     * Adds a patient to the waiting list for a specific appointment slot.
     * This is typically called when a booking attempt fails because the slot is taken.
     * @param patientName The name of the patient to add to the waiting list.
     * @param doctorName The doctor's name for the slot.
     * @param dateTime The date and time of the slot.
     */
    public void joinWaitingList(String patientName, String doctorName, String dateTime) {
        String key = generateAppointmentKey(doctorName, dateTime);
        // Get the queue for this key, or create a new LinkedList (implements Queue) if it doesn't exist
        Queue<String> waitlist = waitingLists.computeIfAbsent(key, k -> new LinkedList<>());
        waitlist.offer(patientName); // Add patient to the end of the queue (FIFO)
    }

    /**
     * Displays all currently booked appointments.
     */
    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments booked yet.");
        } else {
            // Iterate through the List and print each Appointment
            for (int i = 0; i < appointments.size(); i++) {
                System.out.println((i + 1) + ". " + appointments.get(i));
            }
        }
    }

    /**
     * Cancels a specific appointment identified by patient, doctor, and time.
     * If the appointment is found and cancelled, it checks for a waiting list for that slot
     * and notifies the next patient if one exists.
     * @param patientName The patient's name for the appointment to cancel.
     * @param doctorName The doctor's name for the appointment to cancel.
     * @param dateTime The date and time for the appointment to cancel.
     * @throws AppointmentNotFoundException if no matching appointment is found.
     */
    public void cancelAppointment(String patientName, String doctorName, String dateTime) throws AppointmentNotFoundException {
        Appointment appointmentToRemove = null;
        // Find the specific appointment to remove by matching all details
        for (Appointment appt : appointments) {
            if (appt.getPatientName().equalsIgnoreCase(patientName.trim()) &&
                appt.getDoctorName().equalsIgnoreCase(doctorName.trim()) &&
                appt.getDateTime().equals(dateTime.trim())) {
                appointmentToRemove = appt;
                break;
            }
        }

        if (appointmentToRemove == null) {
            // If not found, throw the custom exception
            throw new AppointmentNotFoundException("Appointment not found for Patient: " + patientName + ", Doctor: " + doctorName + ", Time: " + dateTime);
        }

        appointments.remove(appointmentToRemove); // Remove from the ArrayList

        // Check the waiting list for this cancelled slot
        String key = generateAppointmentKey(doctorName, dateTime);
        Queue<String> waitlist = waitingLists.get(key);

        if (waitlist != null && !waitlist.isEmpty()) {
            // Poll the first patient from the Queue
            String nextPatient = waitlist.poll();
            System.out.println("Notification: Appointment slot " + dateTime + " with " + doctorName + " is now available.");
            System.out.println("Notifying next patient on waiting list: " + nextPatient);

            // If the waiting list for this slot is now empty, remove the key from the map
            if (waitlist.isEmpty()) {
                waitingLists.remove(key);
            }
        } else {
             // If there was no waiting list or it was empty, just confirm cancellation
             // This message is handled by the caller in the main method after the successful removal
             // System.out.println("No waiting list for this cancelled slot.");
        }
    }

    /**
     * Displays the contents of all active waiting lists.
     */
    public void viewWaitingLists() {
        if (waitingLists.isEmpty()) {
            System.out.println("No active waiting lists.");
        } else {
            // Iterate through the Map entries
            for (Map.Entry<String, Queue<String>> entry : waitingLists.entrySet()) {
                String slot = entry.getKey();
                Queue<String> patients = entry.getValue(); // Get the Queue
                System.out.println("Waiting list for slot [" + slot + "]:");
                if (patients.isEmpty()) {
                     System.out.println("  (Empty)");
                } else {
                    // Print the contents of the Queue. LinkedList's toString() is helpful here.
                    System.out.println("  Patients: " + patients);
                }
            }
        }
    }
}

/**
 * Main class to run the Hospital Appointment System.
 * Handles user interaction via console menu.
 */
public class HospitalAppointmentSystem {

    private AppointmentSystem appointmentSystem = new AppointmentSystem();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        HospitalAppointmentSystem system = new HospitalAppointmentSystem();
        system.run();
    }

    /**
     * Runs the main application loop, displaying the menu and processing user input.
     */
    public void run() {
        int choice = -1;
        while (choice != 0) {
            printMenu();
            try {
                System.out.print("Enter choice: ");
                // Use nextLine() to read the whole line and then parse,
                // avoids issues with nextInt() leaving newline characters.
                String input = scanner.nextLine();
                choice = Integer.parseInt(input);

                // Use a switch statement for menu navigation
                switch (choice) {
                    case 1:
                        bookAppointment();
                        break;
                    case 2:
                        viewAppointments();
                        break;
                    case 3:
                        cancelAppointment();
                        break;
                    case 4:
                        viewWaitingLists();
                        break;
                    case 0:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        // Handle invalid numbers not in the menu
                        System.err.println("Invalid choice. Please enter a number from the menu.");
                }
            } catch (NumberFormatException e) {
                // Handle non-integer input
                System.err.println("Invalid input. Please enter a number.");
            } catch (AppointmentNotFoundException e) {
                // Handle specific exception from cancellation
                System.err.println("Error cancelling appointment: " + e.getMessage());
            } catch (Exception e) {
                // Class-wide exception handling for any other unexpected errors
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for detailed debugging if needed
            }
            System.out.println(); // Blank line for readability between operations
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Prints the main menu options to the console.
     */
    private void printMenu() {
        System.out.println("--- Hospital Appointment System ---");
        System.out.println("1. Book Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Cancel Appointment");
        System.out.println("4. View Waiting Lists");
        System.out.println("0. Exit");
        System.out.println("-----------------------------------");
    }

    /**
     * Handles the process of booking a new appointment, including offering to join a waiting list.
     */
    private void bookAppointment() {
        System.out.println("\n--- Book Appointment ---");
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine().trim();
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine().trim();
        System.out.print("Enter Date and Time (e.g., 2023-10-27 10:00): ");
        String dateTime = scanner.nextLine().trim();

        // Basic input validation
        if (patientName.isEmpty() || doctorName.isEmpty() || dateTime.isEmpty()) {
            System.err.println("All fields must be filled.");
            return; // Exit the method if input is invalid
        }

        // Attempt to book the appointment via the AppointmentSystem
        boolean booked = appointmentSystem.bookAppointment(patientName, doctorName, dateTime);

        if (booked) {
            System.out.println("Appointment booked successfully for " + patientName + " with " + doctorName + " at " + dateTime);
        } else {
            // If not booked, the slot was taken. Offer waiting list.
            System.out.println("Slot " + dateTime + " with " + doctorName + " is already booked.");
            System.out.print("Join waiting list for this slot? (yes/no): ");
            String joinWaitlist = scanner.nextLine().trim().toLowerCase();
            if ("yes".equals(joinWaitlist)) {
                appointmentSystem.joinWaitingList(patientName, doctorName, dateTime); // Add to waiting list Queue
                System.out.println("You have been added to the waiting list for this slot.");
            } else {
                System.out.println("Appointment not booked.");
            }
        }
    }

    /**
     * Calls the AppointmentSystem to display all booked appointments.
     */
    private void viewAppointments() {
        System.out.println("\n--- All Appointments ---");
        appointmentSystem.viewAppointments();
    }

    /**
     * Handles the process of cancelling an appointment.
     * Declares that it might throw AppointmentNotFoundException, which is caught in the run() method.
     * @throws AppointmentNotFoundException if the specified appointment cannot be found.
     */
    private void cancelAppointment() throws AppointmentNotFoundException {
        System.out.println("\n--- Cancel Appointment ---");
        System.out.print("Enter Patient Name for appointment to cancel: ");
        String patientName = scanner.nextLine().trim();
        System.out.print("Enter Doctor Name for appointment to cancel: ");
        String doctorName = scanner.nextLine().trim();
        System.out.print("Enter Date and Time for appointment to cancel (e.g., 2023-10-27 10:00): ");
        String dateTime = scanner.nextLine().trim();

        // Basic input validation
        if (patientName.isEmpty() || doctorName.isEmpty() || dateTime.isEmpty()) {
            System.err.println("All fields must be filled to identify appointment.");
            return; // Exit the method if input is invalid
        }

        // Attempt to cancel the appointment via the AppointmentSystem.
        // This call might throw AppointmentNotFoundException.
        appointmentSystem.cancelAppointment(patientName, doctorName, dateTime);
        // If the call completes without throwing an exception, cancellation was successful.
        System.out.println("Appointment cancelled successfully.");
        // Note: The waiting list notification is printed inside cancelAppointment if applicable.
    }

    /**
     * Calls the AppointmentSystem to display all active waiting lists.
     */
    private void viewWaitingLists() {
        System.out.println("\n--- Waiting Lists ---");
        appointmentSystem.viewWaitingLists();
    }
}
