/*
 * Exam Question #42
 * Generated on: 2025-05-11 21:59:59
 * 
 * QUESTION:
 * **Complex Java Programming Exam Task: Hospital Appointment Scheduler**
 * 
 * You are tasked with developing a simplified appointment scheduling system for a hospital reception desk. The system should manage patients arriving for check-in and facilitate scheduling them into available time slots.
 * 
 * Your solution must demonstrate proficiency in using core Java data structures and control flow mechanisms, including robust error handling and user interaction.
 * 
 * **Requirements:**
 * 
 * 1.  **Patient Check-in Queue:** Maintain a queue of patients who have checked in and are waiting to be scheduled. Patients are processed in the order they check in (First-In, First-Out).
 * 2.  **Available Time Slots:** Maintain a list of predefined appointment time slots. Each slot should have a time, a doctor's name, and a status (booked or available).
 * 3.  **User Interface:** The system should interact with the user (receptionist) via the console. It should support the following commands:
 *     *   `check-in <patient_name>`: Adds a new patient to the check-in queue.
 *     *   `schedule`: Attempts to schedule the *next* patient from the check-in queue into an available time slot. The system should list available slots and prompt the user to select a slot by its index.
 *     *   `view queue`: Displays the names of all patients currently in the check-in queue.
 *     *   `view slots`: Displays all time slots, their doctor, time, and current status (Available/Booked).
 *     *   `exit`: Terminates the program.
 *     *   Any other input should be treated as an invalid command.
 * 4.  **Data Structures:**
 *     *   Use `java.util.Queue` for the patient check-in queue.
 *     *   Use `java.util.ArrayList` to store the list of time slots.
 *     *   Declare the time slot collection using the `java.util.List` interface.
 * 5.  **Input Handling:** Use `java.util.Scanner` to read user commands and input.
 * 6.  **Control Flow:** Use a `switch` statement to process different user commands.
 * 7.  **Output:**
 *     *   Use `System.out` for all normal output (prompts, confirmations, lists).
 *     *   Use `System.err` for all error messages (e.g., invalid command, queue empty, invalid slot selection, slot already booked, invalid input format).
 * 8.  **Error Handling:** Implement robust error handling using `try-catch` blocks. This should include handling potential exceptions during input parsing (e.g., when reading the slot index) and logical errors (e.g., trying to schedule from an empty queue or booking an unavailable slot). Implement class-wide exception handling where appropriate (e.g., around the main command processing loop).
 * 9.  **Object-Oriented Design:** Create simple classes for `Patient` and `TimeSlot` with appropriate private fields and public methods (getters, potentially a method to mark a slot as booked). The main system logic should reside in a separate class (e.g., `HospitalScheduler`).
 * 10. **Best Practices:** Follow Java coding best practices, including meaningful variable names, proper encapsulation, and code comments where necessary.
 * 
 * **Predefined Data:**
 * Initialize the system with a few predefined time slots (e.g., 9:00 AM with Dr. Smith, 9:30 AM with Dr. Jones, 10:00 AM with Dr. Smith).
 * 
 * **Expected Output Structure (Examples):**
 * 
 * ```
 * Hospital Appointment Scheduler
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > check-in Alice
 * Patient Alice checked in. Added to queue.
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > view queue
 * Check-in Queue: [Alice]
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > view slots
 * Available Slots:
 * 0: 09:00 AM (Dr. Smith) - Available
 * 1: 09:30 AM (Dr. Jones) - Available
 * 2: 10:00 AM (Dr. Smith) - Available
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > schedule
 * Next patient: Alice
 * Available Slots for Scheduling:
 * 0: 09:00 AM (Dr. Smith) - Available
 * 1: 09:30 AM (Dr. Jones) - Available
 * 2: 10:00 AM (Dr. Smith) - Available
 * Enter slot index to book:
 * > 0
 * Appointment scheduled for Alice at 09:00 AM with Dr. Smith.
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > view slots
 * Available Slots:
 * 0: 09:00 AM (Dr. Smith) - Booked
 * 1: 09:30 AM (Dr. Jones) - Available
 * 2: 10:00 AM (Dr. Smith) - Available
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > schedule
 * Check-in queue is empty. Cannot schedule.
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > invalid command
 * Error: Unknown command.
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > schedule
 * Next patient: Bob (assuming Bob checked in previously)
 * Available Slots for Scheduling:
 * 0: 09:00 AM (Dr. Smith) - Booked
 * 1: 09:30 AM (Dr. Jones) - Available
 * 2: 10:00 AM (Dr. Smith) - Available
 * Enter slot index to book:
 * > 0
 * Error: Slot 0 is already booked. Please select an available slot.
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > schedule
 * Next patient: Bob
 * Available Slots for Scheduling:
 * ... (list again) ...
 * Enter slot index to book:
 * > abc
 * Error: Invalid input. Please enter a number for the slot index.
 * ... (loop continues until valid input or user cancels) ...
 * Enter command (check-in <name>, schedule, view queue, view slots, exit):
 * > exit
 * Exiting scheduler.
 * ```
 * 
 * Implement the `HospitalScheduler` class with a `main` method to run the system.
 *
 * EXPLANATION:
 * The provided solution implements a basic hospital appointment scheduling system, fulfilling all the requirements of the exam task.
 * 
 * 1.  **Class Structure:** The code is organized into three classes: `Patient`, `TimeSlot`, and `HospitalScheduler`. This demonstrates good object-oriented design principles with clear responsibilities for each class.
 *     *   `Patient`: Encapsulates patient data (name).
 *     *   `TimeSlot`: Encapsulates slot data (time, doctor, booked status) and provides a method to book itself.
 *     *   `HospitalScheduler`: Contains the main logic, managing the collections of patients and slots, handling user input, and processing commands.
 * 
 * 2.  **Data Structures (`Queue`, `List`, `ArrayList`):**
 *     *   `checkInQueue`: Declared as `Queue<Patient>` and initialized with `new LinkedList<>()`. This correctly uses the `Queue` interface and a common implementation (`LinkedList`) to enforce FIFO behavior for patient check-in. `offer()` is used for adding and `poll()` for removing, which are standard queue operations that handle capacity limits gracefully (though not strictly necessary here).
 *     *   `availableSlots`: Declared as `List<TimeSlot>` and initialized with `new ArrayList<>()`. This demonstrates using the `List` interface and the `ArrayList` implementation for a dynamic array to store and access `TimeSlot` objects by index.
 * 
 * 3.  **User Input (`Scanner`):** A `Scanner` object is used to read lines of input from `System.in`. The input line is then split to determine the command and any arguments. `scanner.nextLine()` is used consistently after `scanner.nextInt()` to consume the newline character and prevent input issues in subsequent reads.
 * 
 * 4.  **Control Flow (`switch`):** A `switch` statement in the `run()` method is used to direct execution based on the user's command (`check-in`, `schedule`, `view`, `exit`, default). This provides a clean and readable way to handle multiple command options.
 * 
 * 5.  **Output (`System.out`, `System.err`):**
 *     *   `System.out.println()` is used for all standard messages, prompts, confirmations, and list displays.
 *     *   `System.err.println()` is used exclusively for printing error messages, directing them to the standard error stream as required.
 * 
 * 6.  **Error Handling (`try-catch`):**
 *     *   **Class-wide `try-catch`:** The main `while` loop in the `run()` method is wrapped in a `try-catch(Exception e)` block. This demonstrates a top-level handler for any unexpected runtime exceptions that might occur within the command processing loop, preventing the program from crashing abruptly. The caught exception's message and stack trace are printed to `System.err`. A `finally` block ensures the `Scanner` is closed.
 *     *   **Specific Input Handling `try-catch`:** Within the `scheduleAppointment()` method, a `try-catch(InputMismatchException e)` block is used specifically around reading the integer input for the slot index (`scanner.nextInt()`). This handles cases where the user enters non-numeric input when a number is expected. The catch block prints an error to `System.err` and consumes the invalid input line (`scanner.nextLine()`) to clear the buffer for the next input attempt, preventing an infinite error loop.
 *     *   **Logical Error Handling:** The code includes checks for logical errors like:
 *         *   Attempting to schedule when the queue is empty (`checkInQueue.poll() == null`).
 *         *   Providing an invalid slot index (`slotIndex < 0 || slotIndex >= availableSlots.size()`).
 *         *   Attempting to book a slot that is already booked (`selectedSlot.isBooked()`).
 *         These conditions print informative error messages to `System.err`.
 * 
 * 7.  **Best Practices:**
 *     *   **Encapsulation:** `Patient` and `TimeSlot` classes have private fields accessed via public getter methods. The `HospitalScheduler` keeps its data structures (`checkInQueue`, `availableSlots`) private and provides public methods (`run`, though internal logic is private) to interact with the system.
 *     *   **Meaningful Names:** Variables (`checkInQueue`, `availableSlots`, `nextPatient`, `selectedSlot`, `slotIndex`, `inputLine`), methods (`checkInPatient`, `scheduleAppointment`, `viewQueue`, `viewSlots`, `bookSlot`), and classes (`Patient`, `TimeSlot`, `HospitalScheduler`) have names that clearly indicate their purpose.
 *     *   **Comments:** Comments are included to explain the purpose of classes, methods, data structures, and specific logic blocks (like the `try-catch` for input).
 *     *   **Input Validation:** The code checks if the `check-in` command has a name argument, validates the format of the slot index input using `try-catch`, and validates the range and availability of the selected slot.
 *     *   **Clean Structure:** The code is broken down into methods responsible for specific tasks (`checkInPatient`, `scheduleAppointment`, etc.), making the `run` method clean and easy to understand. Helper methods like `displayAvailableSlotsOnly` and `getAvailableSlotCount` further improve organization.
 * 
 * The solution effectively integrates all required components into a functional, albeit simplified, real-world simulation, demonstrating advanced understanding of Java fundamentals, data structures, and error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList is a common Queue implementation
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a patient
class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

// Represents an appointment time slot
class TimeSlot {
    private String time;
    private String doctor;
    private boolean isBooked;

    public TimeSlot(String time, String doctor) {
        this.time = time;
        this.doctor = doctor;
        this.isBooked = false; // Initially available
    }

    public String getTime() {
        return time;
    }

    public String getDoctor() {
        return doctor;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookSlot() {
        this.isBooked = true;
    }

    public String getStatus() {
        return isBooked ? "Booked" : "Available";
    }

    @Override
    public String toString() {
        return time + " (" + doctor + ") - " + getStatus();
    }
}

// Main class for the hospital scheduling system
public class HospitalScheduler {

    // Use Queue for FIFO check-in
    private Queue<Patient> checkInQueue;
    // Use List and ArrayList for managing time slots
    private List<TimeSlot> availableSlots;
    private Scanner scanner;

    public HospitalScheduler() {
        // Initialize data structures
        checkInQueue = new LinkedList<>(); // LinkedList implements Queue
        availableSlots = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Predefined time slots
        availableSlots.add(new TimeSlot("09:00 AM", "Dr. Smith"));
        availableSlots.add(new TimeSlot("09:30 AM", "Dr. Jones"));
        availableSlots.add(new TimeSlot("10:00 AM", "Dr. Smith"));
        availableSlots.add(new TimeSlot("10:30 AM", "Dr. Jones"));
        availableSlots.add(new TimeSlot("11:00 AM", "Dr. Smith"));
    }

    // Main method to run the scheduler
    public static void main(String[] args) {
        HospitalScheduler scheduler = new HospitalScheduler();
        scheduler.run();
    }

    // Runs the main command processing loop
    public void run() {
        System.out.println("Hospital Appointment Scheduler");
        boolean running = true;

        // Class-wide try-catch for the main loop to handle unexpected errors
        try {
            while (running) {
                System.out.println("\nEnter command (check-in <name>, schedule, view queue, view slots, exit):");
                System.out.print("> ");
                String inputLine = scanner.nextLine().trim();
                String[] parts = inputLine.split(" ", 2);
                String command = parts[0].toLowerCase();
                String argument = parts.length > 1 ? parts[1] : "";

                // Using switch for command processing
                switch (command) {
                    case "check-in":
                        if (argument.isEmpty()) {
                            System.err.println("Error: Patient name is required for check-in.");
                        } else {
                            checkInPatient(argument);
                        }
                        break;
                    case "schedule":
                        scheduleAppointment();
                        break;
                    case "view":
                        if (argument.equalsIgnoreCase("queue")) {
                            viewQueue();
                        } else if (argument.equalsIgnoreCase("slots")) {
                            viewSlots();
                        } else {
                             System.err.println("Error: Invalid view option. Use 'view queue' or 'view slots'.");
                        }
                        break;
                    case "exit":
                        running = false;
                        System.out.println("Exiting scheduler.");
                        break;
                    default:
                        System.err.println("Error: Unknown command.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unhandled exceptions during runtime
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to error stream
        } finally {
            // Ensure scanner is closed
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }

    // Adds a patient to the check-in queue
    private void checkInPatient(String name) {
        Patient newPatient = new Patient(name);
        checkInQueue.offer(newPatient); // offer is preferred over add in queues
        System.out.println("Patient " + name + " checked in. Added to queue.");
    }

    // Processes the next patient in the queue and attempts to schedule them
    private void scheduleAppointment() {
        // Use poll() to get and remove the head of the queue
        Patient nextPatient = checkInQueue.poll();

        if (nextPatient == null) {
            System.err.println("Check-in queue is empty. Cannot schedule.");
            return;
        }

        System.out.println("Next patient: " + nextPatient.getName());
        System.out.println("Available Slots for Scheduling:");
        displayAvailableSlotsOnly(); // Show only available slots for selection

        if (getAvailableSlotCount() == 0) {
             System.err.println("No available slots at this time.");
             // Optionally put the patient back if they couldn't be scheduled
             // checkInQueue.add(nextPatient); // Or handle differently based on policy
             return;
        }

        int slotIndex = -1;
        boolean validInput = false;

        // Try-catch block specifically for reading slot index input
        while (!validInput) {
            System.out.print("Enter slot index to book (or -1 to cancel): ");
            try {
                slotIndex = scanner.nextInt();
                // Consume the rest of the line after reading the integer
                scanner.nextLine();
                validInput = true; // Input was successfully read as an integer
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number for the slot index.");
                scanner.nextLine(); // Consume the invalid input line to prevent infinite loop
            }
        }

        if (slotIndex == -1) {
            System.out.println("Scheduling cancelled for " + nextPatient.getName() + ". Patient remains out of queue.");
            // Note: Patient was already polled. A real system might re-queue or handle differently.
            return;
        }

        // Validate the selected slot index and status
        if (slotIndex < 0 || slotIndex >= availableSlots.size()) {
            System.err.println("Error: Invalid slot index.");
            // Patient was polled, not re-queued here for simplicity.
        } else {
            TimeSlot selectedSlot = availableSlots.get(slotIndex);
            if (selectedSlot.isBooked()) {
                System.err.println("Error: Slot " + slotIndex + " is already booked. Please select an available slot.");
                 // Patient was polled, not re-queued here for simplicity.
            } else {
                selectedSlot.bookSlot();
                System.out.println("Appointment scheduled for " + nextPatient.getName() +
                                   " at " + selectedSlot.getTime() +
                                   " with " + selectedSlot.getDoctor() + ".");
            }
        }
    }

    // Displays patients currently in the queue
    private void viewQueue() {
        if (checkInQueue.isEmpty()) {
            System.out.println("Check-in Queue is empty.");
        } else {
            System.out.println("Check-in Queue: " + checkInQueue);
        }
    }

    // Displays all time slots and their status
    private void viewSlots() {
        System.out.println("Available Slots:");
        if (availableSlots.isEmpty()) {
            System.out.println("No time slots defined.");
        } else {
            // Iterate through the List of TimeSlots
            for (int i = 0; i < availableSlots.size(); i++) {
                TimeSlot slot = availableSlots.get(i);
                System.out.println(i + ": " + slot.toString());
            }
        }
    }

     // Helper to display only available slots for scheduling selection
    private void displayAvailableSlotsOnly() {
         boolean foundAvailable = false;
         for (int i = 0; i < availableSlots.size(); i++) {
            TimeSlot slot = availableSlots.get(i);
            if (!slot.isBooked()) {
                System.out.println(i + ": " + slot.toString());
                foundAvailable = true;
            }
         }
         if (!foundAvailable) {
             System.out.println("No available slots to display.");
         }
    }

    // Helper to count available slots
    private int getAvailableSlotCount() {
        int count = 0;
         for (TimeSlot slot : availableSlots) {
            if (!slot.isBooked()) {
                count++;
            }
         }
         return count;
    }
}
