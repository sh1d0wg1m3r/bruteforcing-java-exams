/*
 * Exam Question #793
 * Generated on: 2025-05-12 16:41:27
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Hospital Appointment Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simplified hospital appointment management system. The system needs to handle appointment requests from patients and manage a list of appointments that have been processed (i.e., assigned a time slot or are currently being attended).
 * 
 * The system should allow users (e.g., receptionists) to:
 * 1.  Add a new appointment request to a waiting list.
 * 2.  Process the next appointment request from the waiting list, moving it to a list of scheduled/processed appointments.
 * 3.  View the current waiting list.
 * 4.  View the list of scheduled/processed appointments.
 * 5.  View both lists.
 * 6.  Exit the application.
 * 
 * **Technical Requirements:**
 * 
 * Your solution must be a single Java program (`.java` file) that demonstrates advanced understanding of Java concepts and adheres to best practices. Specifically, you **must** use the following components:
 * 
 * 1.  `java.util.Queue`: To represent the waiting list of appointment requests. Requests should be processed in a First-In, First-Out (FIFO) manner.
 * 2.  `java.util.ArrayList`: To store the list of scheduled/processed appointments.
 * 3.  `java.util.List`: You must declare and use a variable of the `List` interface type (which will hold the `ArrayList` instance).
 * 4.  `java.util.Scanner`: To read user commands and input details (like patient name and request description).
 * 5.  `switch` statement: To handle the different user commands ('add', 'process', 'view waiting', 'view scheduled', 'view all', 'exit').
 * 6.  `System.err`: To output error messages (e.g., invalid command, invalid input during 'add', attempting to process an empty waiting list in a way that indicates an error condition or a notable status).
 * 7.  `System.out`: To output normal information (e.g., prompts, menu, successful operations, list contents).
 * 8.  Class-wide exception handling with `try-catch` blocks: Implement robust error handling, particularly for potential issues during input processing or invalid operations (like processing an empty queue). A single `try-catch` block wrapping the main command processing loop is recommended to handle unexpected runtime issues gracefully.
 * 
 * **Design and Best Practices:**
 * 
 * *   Create a class to represent an `Appointment` (or `AppointmentRequest`), holding relevant data like a unique ID, patient name, and request details. Use proper encapsulation (private fields, public getters).
 * *   Create a main class (e.g., `HospitalManagerApp`) that contains the `main` method and orchestrates the application flow.
 * *   Within the main class or a separate manager class, use private fields for the `Queue` and `List`.
 * *   Use meaningful variable and method names.
 * *   Include appropriate comments and basic documentation (e.g., Javadoc for classes/methods).
 * *   Implement basic input validation (e.g., check if patient name or request details are empty when adding).
 * *   Handle the case where the waiting list is empty when the 'process' command is issued.
 * *   Ensure resources like `Scanner` are closed properly.
 * 
 * **User Interaction and Expected Output:**
 * 
 * The program should present a menu of options to the user, read their command, and perform the corresponding action.
 * 
 * Example interaction:
 * 
 * ```
 * Hospital Appointment Management System
 * Menu:
 * add - Add new appointment request
 * process - Process next waiting request
 * view waiting - View waiting list
 * view scheduled - View scheduled appointments
 * view all - View all appointments
 * exit - Exit application
 * Enter command:
 * add
 * Enter patient name:
 * Alice Smith
 * Enter request details (e.g., "Chest pain, urgent"):
 * Chest pain, urgent
 * Request added to waiting list. ID: 1
 * 
 * Enter command:
 * add
 * Enter patient name:
 * Bob Johnson
 * Enter request details (e.g., "Follow-up appointment"):
 * Follow-up appointment
 * Request added to waiting list. ID: 2
 * 
 * Enter command:
 * view waiting
 * --- Waiting List ---
 * 1: Alice Smith - Chest pain, urgent
 * 2: Bob Johnson - Follow-up appointment
 * --------------------
 * 
 * Enter command:
 * process
 * Processed request ID 1: Alice Smith - Chest pain, urgent
 * Moved to scheduled list.
 * 
 * Enter command:
 * view waiting
 * --- Waiting List ---
 * 2: Bob Johnson - Follow-up appointment
 * --------------------
 * 
 * Enter command:
 * view scheduled
 * --- Scheduled Appointments ---
 * 1: Alice Smith - Chest pain, urgent
 * -----------------------------
 * 
 * Enter command:
 * process
 * Processed request ID 2: Bob Johnson - Follow-up appointment
 * Moved to scheduled list.
 * 
 * Enter command:
 * process
 * System.err: Waiting list is empty. No request to process.
 * 
 * Enter command:
 * view all
 * --- Waiting List ---
 * (Empty)
 * --------------------
 * --- Scheduled Appointments ---
 * 1: Alice Smith - Chest pain, urgent
 * 2: Bob Johnson - Follow-up appointment
 * -----------------------------
 * 
 * Enter command:
 * invalid_command
 * System.err: Invalid command. Please enter one of: add, process, view waiting, view scheduled, view all, exit.
 * 
 * Enter command:
 * exit
 * Exiting Hospital Appointment Management System.
 * ```
 * 
 * **Submission:**
 * 
 * Provide the complete Java source code for the solution.
 *
 * EXPLANATION:
 * This solution implements a basic Hospital Appointment Management System, fulfilling all the specified requirements and demonstrating the use of the required Java components and best practices.
 * 
 * 1.  **`AppointmentRequest` Class:**
 *     *   Represents a single request.
 *     *   Uses `private` fields (`id`, `patientName`, `requestDetails`) for encapsulation.
 *     *   Includes a static counter (`nextId`) to generate unique IDs for each request, demonstrating a simple state management pattern within the class.
 *     *   Provides public `getters` to access the data.
 *     *   Overrides `toString()` for easy printing of appointment details.
 * 
 * 2.  **`HospitalAppointmentManager` Class:**
 *     *   Manages the core data structures: `waitingList` and `scheduledAppointments`.
 *     *   `waitingList`: Declared as `private final Queue<AppointmentRequest>`. It's initialized with a `LinkedList`, which is a common implementation of the `Queue` interface, ensuring FIFO behavior for appointment requests.
 *     *   `scheduledAppointments`: Declared as `private final List<AppointmentRequest>`. It's initialized with an `ArrayList`, which is a concrete implementation of the `List` interface, used here to store processed appointments in the order they were processed (or simply as a dynamic list).
 *     *   `addRequest(AppointmentRequest request)`: Adds a request to the `waitingList` using `offer()`. `offer()` is preferred over `add()` in queues as it handles capacity constraints more gracefully (though `LinkedList` is unbounded).
 *     *   `processNextRequest()`: Retrieves and removes the head of the `waitingList` using `poll()`. `poll()` returns `null` if the queue is empty, which is handled gracefully by checking for `null` and printing an appropriate message using `System.err` (as it's an inability to perform the requested action). If successful, the request is added to the `scheduledAppointments` `List`.
 *     *   `viewWaitingList()` and `viewScheduledAppointments()`: Iterate through the respective collections and print their contents using the `toString()` method of `AppointmentRequest`. They check for emptiness and print a message if empty. Output is directed to `System.out`.
 *     *   `viewAllAppointments()`: Calls the two view methods to display both lists.
 * 
 * 3.  **`HospitalManagerApp` Class (`main` method):**
 *     *   This class contains the `main` method, which serves as the application entry point and control flow.
 *     *   `Scanner`: An instance of `Scanner` is used to read input from `System.in`.
 *     *   `HospitalAppointmentManager`: An instance of the manager class is created to handle the appointment logic and data.
 *     *   **`try-catch` Block:** The main `while` loop that processes user commands is wrapped in a `try-catch(Exception e)` block. This provides class-wide exception handling, catching any unexpected runtime errors that might occur during the execution of the command processing loop and printing an error message to `System.err` along with the stack trace for debugging.
 *     *   **`finally` Block:** A `finally` block is used to ensure that the `scanner.close()` method is called regardless of whether the loop finishes normally or an exception is caught. This is crucial for resource management.
 *     *   **`switch` Statement:** The program reads the user's command and uses a `switch` statement to direct execution to the correct logic block (`add`, `process`, `view waiting`, etc.). This effectively handles the different control flow paths based on user input.
 *     *   **Input Validation (`add` case):** Inside the 'add' case, basic validation checks if the `patientName` or `requestDetails` are empty strings. If so, an error message is printed to `System.err`, preventing the creation of an invalid request object.
 *     *   **`System.out` and `System.err`:** `System.out.println` is used for displaying the menu, prompts, successful operation confirmations, and the contents of the lists. `System.err.println` is used specifically for error conditions, such as invalid commands or attempting to process an empty queue.
 * 
 * This solution effectively combines the required data structures (`Queue`, `List`, `ArrayList`), control flow (`Scanner`, `switch`), object-oriented principles (encapsulation, classes), and error handling (`try-catch`, `System.err`) to simulate a practical scenario, providing a challenging yet solvable task for an advanced Java exam.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Represents an appointment request in the hospital system.
 */
class AppointmentRequest {
    private static int nextId = 1;
    private final int id;
    private final String patientName;
    private final String requestDetails;

    /**
     * Constructs a new AppointmentRequest.
     *
     * @param patientName    The name of the patient.
     * @param requestDetails Details of the appointment request.
     */
    public AppointmentRequest(String patientName, String requestDetails) {
        this.id = nextId++;
        this.patientName = patientName;
        this.requestDetails = requestDetails;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getRequestDetails() {
        return requestDetails;
    }

    @Override
    public String toString() {
        return id + ": " + patientName + " - " + requestDetails;
    }
}

/**
 * Manages the hospital appointment waiting list and scheduled appointments.
 */
class HospitalAppointmentManager {
    // Using Queue (LinkedList implementation) for FIFO waiting list
    private final Queue<AppointmentRequest> waitingList;
    // Using List (ArrayList implementation) for scheduled appointments
    private final List<AppointmentRequest> scheduledAppointments;

    /**
     * Constructs a new HospitalAppointmentManager.
     */
    public HospitalAppointmentManager() {
        this.waitingList = new LinkedList<>(); // LinkedList implements Queue
        this.scheduledAppointments = new ArrayList<>(); // ArrayList implements List
    }

    /**
     * Adds a new appointment request to the waiting list.
     *
     * @param request The AppointmentRequest to add.
     */
    public void addRequest(AppointmentRequest request) {
        waitingList.offer(request); // offer is preferred over add for queues (returns false on failure, doesn't throw exception)
        System.out.println("Request added to waiting list. ID: " + request.getId());
    }

    /**
     * Processes the next appointment request from the waiting list,
     * moving it to the scheduled appointments list.
     *
     * @return The processed AppointmentRequest, or null if the waiting list is empty.
     */
    public AppointmentRequest processNextRequest() {
        AppointmentRequest nextRequest = waitingList.poll(); // poll retrieves and removes the head, returns null if empty
        if (nextRequest != null) {
            scheduledAppointments.add(nextRequest);
            System.out.println("Processed request ID " + nextRequest.getId() + ": " + nextRequest.getPatientName() + " - " + nextRequest.getRequestDetails());
            System.out.println("Moved to scheduled list.");
        } else {
            System.err.println("Waiting list is empty. No request to process.");
        }
        return nextRequest;
    }

    /**
     * Displays the current waiting list.
     */
    public void viewWaitingList() {
        System.out.println("--- Waiting List ---");
        if (waitingList.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            // Iterate through the queue without removing elements
            for (AppointmentRequest request : waitingList) {
                System.out.println(request);
            }
        }
        System.out.println("--------------------");
    }

    /**
     * Displays the list of scheduled appointments.
     */
    public void viewScheduledAppointments() {
        System.out.println("--- Scheduled Appointments ---");
        if (scheduledAppointments.isEmpty()) {
            System.out.println("(Empty)");
        } else {
            // Iterate through the list
            for (AppointmentRequest appointment : scheduledAppointments) {
                System.out.println(appointment);
            }
        }
        System.out.println("-----------------------------");
    }

    /**
     * Displays both the waiting list and the scheduled appointments list.
     */
    public void viewAllAppointments() {
        viewWaitingList();
        viewScheduledAppointments();
    }
}

/**
 * Main application class for the Hospital Appointment Management System.
 */
public class HospitalManagerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalAppointmentManager manager = new HospitalAppointmentManager();
        boolean running = true;

        System.out.println("Hospital Appointment Management System");
        System.out.println("Menu:");
        System.out.println("add - Add new appointment request");
        System.out.println("process - Process next waiting request");
        System.out.println("view waiting - View waiting list");
        System.out.println("view scheduled - View scheduled appointments");
        System.out.println("view all - View all appointments");
        System.out.println("exit - Exit application");

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                System.out.print("Enter command: ");
                String command = scanner.nextLine().trim().toLowerCase();

                switch (command) {
                    case "add":
                        System.out.print("Enter patient name: ");
                        String patientName = scanner.nextLine().trim();
                        System.out.print("Enter request details (e.g., \"Chest pain, urgent\"): ");
                        String requestDetails = scanner.nextLine().trim();

                        // Input validation
                        if (patientName.isEmpty() || requestDetails.isEmpty()) {
                            System.err.println("Patient name and request details cannot be empty.");
                        } else {
                            AppointmentRequest newRequest = new AppointmentRequest(patientName, requestDetails);
                            manager.addRequest(newRequest);
                        }
                        break;

                    case "process":
                        manager.processNextRequest(); // Method handles empty queue internally
                        break;

                    case "view waiting":
                        manager.viewWaitingList();
                        break;

                    case "view scheduled":
                        manager.viewScheduledAppointments();
                        break;

                    case "view all":
                        manager.viewAllAppointments();
                        break;

                    case "exit":
                        running = false;
                        System.out.println("Exiting Hospital Appointment Management System.");
                        break;

                    default:
                        System.err.println("Invalid command. Please enter one of: add, process, view waiting, view scheduled, view all, exit.");
                        break;
                }
                System.out.println(); // Add a newline for better readability between commands
            }
        } catch (Exception e) {
            // Catch any unexpected runtime exceptions during command processing
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed regardless of whether an exception occurred
            scanner.close();
            System.out.println("Scanner closed."); // Optional: confirmation
        }
    }
}
