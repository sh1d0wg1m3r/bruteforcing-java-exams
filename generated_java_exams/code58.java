/*
 * Exam Question #58
 * Generated on: 2025-05-11 22:06:45
 * Generated by: Account 5
 * 
 * QUESTION:
 * **Java Programming Exam Task: Hospital Appointment Management System**
 * 
 * You are tasked with developing a simplified command-line application for managing patient appointments at a small clinic. The system needs to handle patients requesting appointments, maintain a waiting list, schedule appointments into available slots, and allow viewing and cancellation of scheduled appointments.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a waiting list of patients who need an appointment using a `java.util.Queue`.
 *     *   Maintain a list of scheduled appointments using a `java.util.ArrayList` and refer to it using the `java.util.List` interface.
 *     *   Represent an appointment with details like patient name, doctor name, and time slot.
 *     *   Represent a patient with at least their name.
 * 2.  **Functionality:** Implement the following menu-driven operations:
 *     *   **1. Request Appointment:** Add a patient to the waiting list queue. Prompt the user for the patient's name.
 *     *   **2. Process Waiting List:** Attempt to schedule the patient at the front of the waiting list into the *first available* appointment slot. If successful, remove the patient from the queue and add the appointment to the scheduled list. If no slots are available, inform the user and the patient remains in the queue. Assume a fixed set of available slots (e.g., Doctor A 9:00 AM, Doctor B 10:00 AM, Doctor A 11:00 AM). You can hardcode these initial slots or represent them in a way that allows checking availability.
 *     *   **3. View Appointments:** Display all scheduled appointments and the current patients in the waiting list queue.
 *     *   **4. Cancel Appointment:** Prompt the user for details (e.g., patient name, doctor, time) to identify and remove a scheduled appointment. Handle cases where the appointment is not found.
 *     *   **5. Exit:** Terminate the application.
 * 3.  **User Interaction:** Use `java.util.Scanner` to read user input for menu choices and required details.
 * 4.  **Control Flow:** Use a `switch` statement to handle the main menu selections.
 * 5.  **Error Handling:**
 *     *   Use `System.err` to output error messages (e.g., invalid menu choice, appointment not found, no available slots).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime issues (e.g., non-integer input for menu, unexpected errors).
 * 6.  **Output:** Use `System.out` for displaying menus, prompts, successful operation messages, and appointment lists.
 * 7.  **Best Practices:**
 *     *   Employ proper encapsulation (private fields, public methods) for classes.
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes/methods).
 *     *   Implement basic input validation where necessary (e.g., ensuring patient name is not empty).
 *     *   Structure the code logically into appropriate classes (`Patient`, `Appointment`, `HospitalScheduler`).
 * 
 * **Assumptions:**
 * 
 * *   You can define a simple fixed list of potential appointment slots. For simplicity, you don't need to handle complex time management or doctor schedules beyond checking if a predefined slot is taken.
 * *   Appointment cancellation requires matching patient name, doctor, and time slot exactly.
 * 
 * **Expected Output:**
 * 
 * The program should run in a loop, presenting the menu and responding to user input. Output should be clear, indicating success or failure of operations, and displaying lists correctly. Error messages should go to `System.err`.
 * 
 * **Example Interaction Flow:**
 * 
 * ```
 * --- Hospital Appointment System ---
 * 1. Request Appointment
 * 2. Process Waiting List
 * 3. View Appointments
 * 4. Cancel Appointment
 * 5. Exit
 * Enter choice: 1
 * Enter patient name: Alice
 * 
 * Alice added to waiting list.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter choice: 2
 * Processing waiting list...
 * Patient Bob scheduled with Dr. Smith at 10:00 AM.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter choice: 3
 * 
 * --- Scheduled Appointments ---
 * Patient: Bob, Doctor: Dr. Smith, Time: 10:00 AM
 * --- Waiting List ---
 * Alice
 * Charlie
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter choice: 4
 * Enter patient name to cancel: Bob
 * Enter doctor name: Dr. Smith
 * Enter time slot (e.g., 10:00 AM): 10:00 AM
 * 
 * Appointment cancelled for Bob with Dr. Smith at 10:00 AM.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter choice: 4
 * Enter patient name to cancel: David
 * Enter doctor name: Dr. Jones
 * Enter time slot (e.g., 10:00 AM): 2:00 PM
 * 
 * Error: Appointment not found for David with Dr. Jones at 2:00 PM.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter choice: 6
 * 
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * 
 * --- Hospital Appointment System ---
 * ...
 * Enter choice: 5
 * Exiting system.
 * ```
 * 
 * Implement the Java code for this system.
 *
 * EXPLANATION:
 * The solution implements a simplified hospital appointment management system as requested.
 * 
 * **Class Structure:**
 * 
 * 1.  `Patient`: A simple class to hold the patient's `name`. It follows encapsulation with a private field and a public getter. `toString()` is overridden for easy printing.
 * 2.  `Appointment`: Represents a scheduled appointment with `patientName`, `doctorName`, and `timeSlot`. It includes a constructor, public getters, `toString()`, and a `matches()` method for easy comparison during cancellation. Encapsulation is maintained.
 * 3.  `HospitalScheduler`: This is the main class that orchestrates the system.
 *     *   It holds the core data structures: `waitingList` (a `Queue<Patient>`) and `scheduledAppointments` (a `List<Appointment>`, implemented by `ArrayList`).
 *     *   It also holds a simple `List<String>` representing predefined `availableSlots`.
 *     *   The constructor initializes these lists and populates `availableSlots`.
 *     *   It contains methods for each menu option (`requestAppointment`, `processWaitingList`, `viewAppointments`, `cancelAppointment`).
 *     *   `displayMenu()` is a helper method for printing the menu.
 *     *   `run()` contains the main application loop and handles user interaction.
 *     *   `main()` is the entry point that creates a `HospitalScheduler` instance and calls `run()`.
 * 
 * **Required Components Usage:**
 * 
 * 1.  `Queue (java.util.Queue)`: Used for `waitingList`. Patients are added using `offer()` (or `add()`) and processed using `peek()` (to look) and `poll()` (to remove from the front).
 * 2.  `ArrayList (java.util.ArrayList)`: Used for `scheduledAppointments`. This provides dynamic resizing and efficient element access/removal.
 * 3.  `List interface (java.util.List)`: `scheduledAppointments` is declared as `List<Appointment>` but instantiated as `new ArrayList<>()`. This demonstrates programming to an interface, allowing flexibility if a different `List` implementation were needed later.
 * 4.  `Scanner (java.util.Scanner)`: Used in the `run()` method to read user input from `System.in`. `scanner.nextLine()` is used consistently to avoid issues with newline characters after reading numbers.
 * 5.  `Switch statement`: Used in the `run()` method to direct the program flow based on the user's menu choice.
 * 6.  `System.err`: Used to print error messages for invalid input (like non-numeric choice) or operational failures (like appointment not found, name empty, no slots available).
 * 7.  `System.out`: Used for all standard output, including the menu, prompts, success messages, and displaying the lists of appointments and waiting patients.
 * 8.  Class-wide `try-catch`: A `try-catch` block is wrapped around the main `while` loop in the `run()` method. This provides a top-level handler for any unexpected exceptions that might occur during the program's execution, preventing the application from crashing abruptly. A nested `try-catch` is also used within the loop iteration to specifically handle `NumberFormatException` from menu input and other potential exceptions during a single operation, allowing the loop to continue. The `finally` block ensures the `Scanner` is closed.
 * 
 * **Functionality Implementation:**
 * 
 * *   **Request Appointment:** Reads the patient name and adds a new `Patient` object to the `waitingList` queue. Includes basic input validation for an empty name.
 * *   **Process Waiting List:** Checks if the queue is empty. If not, it `peek()`s at the next patient. It then iterates through the `availableSlots` and the `scheduledAppointments` list to find the *first* slot that is *not* currently in `scheduledAppointments`. If an available slot is found, the patient is `poll()`ed from the queue, a new `Appointment` object is created using the patient's name and the slot details, and this appointment is added to the `scheduledAppointments` list. If no slot is found, an informative message is printed, and the patient remains in the queue.
 * *   **View Appointments:** Iterates through the `scheduledAppointments` list and prints each appointment using its `toString()` method. It then iterates through the `waitingList` queue (using a for-each loop, which iterates without removing) and prints each patient's name.
 * *   **Cancel Appointment:** Prompts the user for the details needed to identify the appointment. It then uses an `Iterator` to safely iterate through the `scheduledAppointments` list and remove the matching appointment. Using an `Iterator` for removal while iterating is crucial to avoid `ConcurrentModificationException`. Basic input validation checks if cancellation details are provided. Error messages are sent to `System.err` if the appointment isn't found.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** All class fields are private, with public methods providing controlled access.
 * *   **Naming:** Variables (`waitingList`, `scheduledAppointments`, `patientName`, `timeSlot`), methods (`requestAppointment`, `processWaitingList`, `cancelAppointment`), and classes (`Patient`, `Appointment`, `HospitalScheduler`) have meaningful names.
 * *   **Comments/Documentation:** Javadoc-style comments are used for classes and public methods explaining their purpose, parameters, and return values. Inline comments clarify specific logic points.
 * *   **Input Validation:** Checks for empty strings in patient names and cancellation details. The `try-catch` around `Integer.parseInt` handles non-numeric menu input.
 * *   **Error Handling:** `System.err` is used for errors distinct from normal output. `try-catch` blocks handle potential exceptions gracefully.
 * *   **Clean Code Structure:** The code is divided into logical classes, and the main logic is within the `HospitalScheduler` class, separating concerns. The `run()` method manages the overall application flow cleanly.
 * 
 * This solution effectively demonstrates the required Java components and concepts within a practical, albeit simplified, scenario, adhering to good programming practices.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList implements Queue and List
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Represents a patient requesting an appointment.
 */
class Patient {
    private String name;

    /**
     * Constructs a Patient object.
     * @param name The name of the patient.
     */
    public Patient(String name) {
        this.name = name;
    }

    /**
     * Gets the patient's name.
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
 * Represents a scheduled appointment.
 */
class Appointment {
    private String patientName;
    private String doctorName;
    private String timeSlot;

    /**
     * Constructs an Appointment object.
     * @param patientName The name of the patient.
     * @param doctorName The name of the doctor.
     * @param timeSlot The time slot of the appointment.
     */
    public Appointment(String patientName, String doctorName, String timeSlot) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.timeSlot = timeSlot;
    }

    /**
     * Gets the patient's name for this appointment.
     * @return The patient's name.
     */
    public String getPatientName() {
        return patientName;
    }

    /**
     * Gets the doctor's name for this appointment.
     * @return The doctor's name.
     */
    public String getDoctorName() {
        return doctorName;
    }

    /**
     * Gets the time slot for this appointment.
     * @return The time slot.
     */
    public String getTimeSlot() {
        return timeSlot;
    }

    @Override
    public String toString() {
        return "Patient: " + patientName + ", Doctor: " + doctorName + ", Time: " + timeSlot;
    }

    /**
     * Checks if this appointment matches given details.
     * @param patientName The patient name to match.
     * @param doctorName The doctor name to match.
     * @param timeSlot The time slot to match.
     * @return true if all details match, false otherwise.
     */
    public boolean matches(String patientName, String doctorName, String timeSlot) {
        return this.patientName.equalsIgnoreCase(patientName) &&
               this.doctorName.equalsIgnoreCase(doctorName) &&
               this.timeSlot.equalsIgnoreCase(timeSlot);
    }
}

/**
 * Manages the hospital appointment scheduling system.
 */
public class HospitalScheduler {

    private Queue<Patient> waitingList;
    private List<Appointment> scheduledAppointments;
    private List<String> availableSlots; // Using String to represent slots simply

    /**
     * Constructs a HospitalScheduler and initializes data structures and available slots.
     */
    public HospitalScheduler() {
        waitingList = new LinkedList<>(); // LinkedList implements Queue
        scheduledAppointments = new ArrayList<>(); // ArrayList implements List
        availableSlots = new ArrayList<>();
        // Initialize some sample available slots
        availableSlots.add("Dr. Smith 9:00 AM");
        availableSlots.add("Dr. Jones 10:00 AM");
        availableSlots.add("Dr. Smith 11:00 AM");
        availableSlots.add("Dr. Jones 1:00 PM");
    }

    /**
     * Adds a patient to the waiting list.
     * @param patientName The name of the patient.
     */
    public void requestAppointment(String patientName) {
        if (patientName == null || patientName.trim().isEmpty()) {
            System.err.println("Error: Patient name cannot be empty.");
            return;
        }
        Patient patient = new Patient(patientName.trim());
        waitingList.offer(patient); // offer is preferred over add for capacity-constrained queues, but fine here
        System.out.println(patientName.trim() + " added to waiting list.");
    }

    /**
     * Attempts to schedule the patient at the front of the waiting list
     * into the first available slot.
     */
    public void processWaitingList() {
        if (waitingList.isEmpty()) {
            System.out.println("Waiting list is empty. No patients to schedule.");
            return;
        }

        Patient patient = waitingList.peek(); // Peek to see who's next without removing yet
        System.out.println("Attempting to schedule patient: " + patient.getName());

        String scheduledSlot = null;

        // Find the first available slot
        for (String slot : availableSlots) {
            boolean slotTaken = false;
            for (Appointment appt : scheduledAppointments) {
                // Check if the slot (doctor + time part) is already taken
                // Simple check assuming slot string contains both doctor and time
                if (appt.getDoctorName().equalsIgnoreCase(slot.split(" ")[1]) &&
                    appt.getTimeSlot().equalsIgnoreCase(slot.substring(slot.indexOf(" ") + 1))) {
                    slotTaken = true;
                    break;
                }
            }
            if (!slotTaken) {
                scheduledSlot = slot;
                break; // Found an available slot
            }
        }

        if (scheduledSlot != null) {
            // Slot format: "Dr. Name Time"
            String[] slotParts = scheduledSlot.split(" ", 2); // Split into "Dr. Name" and "Time"
            String doctorName = slotParts[0] + " " + slotParts[1].split(" ")[0]; // Reconstruct Dr. Name
            String timeSlot = slotParts[1].split(" ", 2)[1]; // Get Time

            // Corrected parsing assuming format "Dr. Smith 9:00 AM"
             int firstSpace = scheduledSlot.indexOf(" ");
             int lastSpace = scheduledSlot.lastIndexOf(" ");
             if (firstSpace != -1 && lastSpace != -1 && firstSpace < lastSpace) {
                 doctorName = scheduledSlot.substring(0, lastSpace); // "Dr. Smith"
                 timeSlot = scheduledSlot.substring(lastSpace + 1); // "9:00 AM"
             } else {
                 // Fallback for unexpected format, though our hardcoded ones work
                 doctorName = scheduledSlot;
                 timeSlot = "Unknown Time";
             }


            Appointment newAppointment = new Appointment(patient.getName(), doctorName, timeSlot);
            scheduledAppointments.add(newAppointment);
            waitingList.poll(); // Remove patient from the queue
            System.out.println("Patient " + patient.getName() + " scheduled with " + doctorName + " at " + timeSlot + ".");
        } else {
            System.out.println("No available appointment slots at this time.");
            System.out.println("Patient " + patient.getName() + " remains in the waiting list.");
        }
    }


    /**
     * Displays all scheduled appointments and the waiting list.
     */
    public void viewAppointments() {
        System.out.println("\n--- Scheduled Appointments ---");
        if (scheduledAppointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (Appointment appt : scheduledAppointments) {
                System.out.println(appt);
            }
        }

        System.out.println("\n--- Waiting List ---");
        if (waitingList.isEmpty()) {
            System.out.println("Waiting list is empty.");
        } else {
            // Iterate through the queue without removing elements
            for (Patient p : waitingList) {
                System.out.println(p.getName());
            }
        }
        System.out.println("-----------------------------");
    }

    /**
     * Cancels a scheduled appointment based on details provided.
     * @param patientName The patient's name.
     * @param doctorName The doctor's name.
     * @param timeSlot The time slot.
     */
    public void cancelAppointment(String patientName, String doctorName, String timeSlot) {
        if (patientName == null || patientName.trim().isEmpty() ||
            doctorName == null || doctorName.trim().isEmpty() ||
            timeSlot == null || timeSlot.trim().isEmpty()) {
            System.err.println("Error: All details (patient name, doctor, time) are required for cancellation.");
            return;
        }

        Iterator<Appointment> iterator = scheduledAppointments.iterator();
        boolean foundAndRemoved = false;
        while (iterator.hasNext()) {
            Appointment appt = iterator.next();
            if (appt.matches(patientName.trim(), doctorName.trim(), timeSlot.trim())) {
                iterator.remove(); // Safely remove the current element
                System.out.println("Appointment cancelled for " + patientName.trim() +
                                   " with " + doctorName.trim() + " at " + timeSlot.trim() + ".");
                foundAndRemoved = true;
                break; // Assuming unique appointments based on these details
            }
        }

        if (!foundAndRemoved) {
            System.err.println("Error: Appointment not found for " + patientName.trim() +
                               " with " + doctorName.trim() + " at " + timeSlot.trim() + ".");
        }
    }

    /**
     * Displays the main menu options.
     */
    private void displayMenu() {
        System.out.println("\n--- Hospital Appointment System ---");
        System.out.println("1. Request Appointment");
        System.out.println("2. Process Waiting List");
        System.out.println("3. View Appointments");
        System.out.println("4. Cancel Appointment");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Runs the main application loop.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Class-wide exception handling for the main loop
        try {
            while (choice != 5) {
                displayMenu();

                try {
                    choice = Integer.parseInt(scanner.nextLine()); // Read full line to avoid issues

                    switch (choice) {
                        case 1:
                            System.out.print("Enter patient name: ");
                            String patientName = scanner.nextLine();
                            requestAppointment(patientName);
                            break;
                        case 2:
                            processWaitingList();
                            break;
                        case 3:
                            viewAppointments();
                            break;
                        case 4:
                            System.out.print("Enter patient name to cancel: ");
                            String cancelPatientName = scanner.nextLine();
                            System.out.print("Enter doctor name: ");
                            String cancelDoctorName = scanner.nextLine();
                            System.out.print("Enter time slot (e.g., 9:00 AM): ");
                            String cancelTimeSlot = scanner.nextLine();
                            cancelAppointment(cancelPatientName, cancelDoctorName, cancelTimeSlot);
                            break;
                        case 5:
                            System.out.println("Exiting system.");
                            break;
                        default:
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                } catch (Exception e) {
                     // Catch any other unexpected exceptions within the loop iteration
                     System.err.println("An unexpected error occurred: " + e.getMessage());
                     // e.printStackTrace(); // Uncomment for debugging
                }
            }
        } catch (Exception mainException) {
             // Catch any critical exception that might break the outer loop
             System.err.println("A critical error occurred in the application loop: " + mainException.getMessage());
             mainException.printStackTrace(); // Print stack trace for critical errors
        } finally {
            scanner.close(); // Ensure scanner is closed
            System.out.println("Application terminated.");
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
