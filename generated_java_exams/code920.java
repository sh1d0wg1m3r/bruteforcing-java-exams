/*
 * Exam Question #920
 * Generated on: 2025-05-12 16:59:45
 * Generated by: Account 3
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Conference Workshop Management System
 * 
 * **Problem Description:**
 * 
 * Design and implement a console-based application for managing attendee registrations and waiting lists for workshops at a technical conference. The system should handle a fixed set of workshops, each with a maximum capacity. When a workshop reaches its capacity, subsequent registration requests for that workshop should add the attendee to a waiting list. If a registered attendee cancels, the first person on the waiting list (if any) should be automatically registered.
 * 
 * Your solution must demonstrate a strong understanding of core Java collections, control flow, input handling, and error management.
 * 
 * **Requirements:**
 * 
 * 1.  **Workshop Representation:** Create a `Workshop` class to model a single workshop.
 *     *   It must have fields for the workshop name, its maximum capacity, a list of registered attendees, and a queue for the waiting list.
 *     *   Use `java.util.List` for the registered attendees (implement with `java.util.ArrayList`).
 *     *   Use `java.util.Queue` for the waiting list (a `java.util.LinkedList` is a suitable implementation).
 *     *   Implement methods for registering an attendee, canceling a registration, and displaying the workshop's current status (name, capacity, registered count, registered attendees list, waiting list count, waiting list).
 *     *   Ensure proper encapsulation (private fields, public methods).
 * 2.  **System Management:** Create a main class (e.g., `ConferenceManagementSystem`) to manage a collection of `Workshop` objects.
 *     *   Store the workshops in a `java.util.List` (implement with `java.util.ArrayList`).
 *     *   Initialize the system with a few predefined workshops and capacities.
 *     *   Implement a command-line interface using `java.util.Scanner` to accept user commands.
 * 3.  **User Commands:** Support the following commands:
 *     *   `list_workshops`: Display the names of all available workshops.
 *     *   `status <workshopName>`: Display the status of a specific workshop, including registered attendees and waiting list.
 *     *   `register <workshopName> <attendeeName>`: Attempt to register an attendee for a workshop. If full, add to the waiting list. Report the outcome.
 *     *   `cancel <workshopName> <attendeeName>`: Attempt to cancel an attendee's registration. If successful and the waiting list is not empty, move the first person from the waiting list to the registered list. Report the outcome.
 *     *   `exit`: Terminate the program.
 * 4.  **Control Flow:** Use a `switch` statement to process the user commands.
 * 5.  **Input Validation & Error Handling:**
 *     *   Validate user input (e.g., correct number of arguments for commands, workshop existence).
 *     *   Use `System.err` to report all error messages (e.g., invalid command, workshop not found, attendee not found for cancellation).
 *     *   Use `System.out` for all normal output (prompts, confirmations, status displays).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle unexpected issues during program execution (e.g., issues with Scanner input, though specific logic errors should be handled by validation and `System.err`). A single `try-catch(Exception e)` around the main command processing loop is sufficient for demonstrating this requirement.
 * 6.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadocs are encouraged but not strictly required for this exam; inline comments explaining complex logic are sufficient).
 *     *   Ensure clean code structure.
 * 
 * **Predefined Workshops:**
 * 
 * *   "Java Advanced Topics" - Capacity: 2
 * *   "Python for Data Science" - Capacity: 3
 * *   "Cloud Computing Basics" - Capacity: 1
 * 
 * **Expected Output:**
 * 
 * The program should run interactively. Example interactions:
 * 
 * ```
 * Available commands: list_workshops, status <workshopName>, register <workshopName> <attendeeName>, cancel <workshopName> <attendeeName>, exit
 * Enter command: list_workshops
 * Available Workshops:
 * - Java Advanced Topics
 * - Python for Data Science
 * - Cloud Computing Basics
 * Enter command: status Java Advanced Topics
 * Workshop: Java Advanced Topics (Capacity: 2)
 * Registered (0/2): []
 * Waiting List (0): []
 * Enter command: register Java Advanced Topics Alice
 * Alice registered for Java Advanced Topics.
 * Enter command: register Java Advanced Topics Bob
 * Bob registered for Java Advanced Topics.
 * Enter command: register Java Advanced Topics Charlie
 * Workshop Java Advanced Topics is full. Charlie added to waiting list.
 * Enter command: status Java Advanced Topics
 * Workshop: Java Advanced Topics (Capacity: 2)
 * Registered (2/2): [Alice, Bob]
 * Waiting List (1): [Charlie]
 * Enter command: cancel Java Advanced Topics Alice
 * Alice cancelled registration for Java Advanced Topics.
 * Charlie moved from waiting list to registered for Java Advanced Topics.
 * Enter command: status Java Advanced Topics
 * Workshop: Java Advanced Topics (Capacity: 2)
 * Registered (2/2): [Bob, Charlie]
 * Waiting List (0): []
 * Enter command: cancel Java Advanced Topics David
 * Error: Attendee David not found in registered or waiting list for Java Advanced Topics.
 * Enter command: status NonExistentWorkshop
 * Error: Workshop NonExistentWorkshop not found.
 * Enter command: register Java Advanced Topics Bob
 * Error: Attendee Bob is already registered for Java Advanced Topics.
 * Enter command: exit
 * Exiting system.
 * ```
 * 
 * Your solution should produce similar output and handle the specified commands and error conditions correctly.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation of all required Java components (Queue, ArrayList, List, Scanner, switch, System.err, System.out, try-catch).
 * *   Correct logic for registration, cancellation, and waiting list management.
 * *   Adherence to best practices (encapsulation, naming, structure).
 * *   Effective input validation and error handling.
 * *   Clear and understandable output.
 * 
 * **Submission:**
 * 
 * Provide the complete Java code for the solution.
 *
 * EXPLANATION:
 * The solution implements a `ConferenceManagementSystem` that manages `Workshop` objects.
 * 
 * 1.  **Workshop Class:**
 *     *   `private String name;`, `private int capacity;`: Encapsulated fields for workshop details.
 *     *   `private List<String> registeredAttendees = new ArrayList<>();`: Uses the `List` interface implemented by `ArrayList` to store attendees currently registered. `ArrayList` is suitable here for dynamic resizing and easy iteration/removal by value.
 *     *   `private Queue<String> waitingList = new LinkedList<>();`: Uses the `Queue` interface implemented by `LinkedList`. `LinkedList` is efficient for adding to the end (`offer`) and removing from the beginning (`poll`), which are the core operations for a waiting list (FIFO - First-In, First-Out).
 *     *   `registerAttendee(String attendeeName)`: Checks for duplicates, then checks capacity. Adds to `registeredAttendees` if capacity is available, otherwise adds to the `waitingList` using `offer()`. Returns a status string.
 *     *   `cancelRegistration(String attendeeName)`: Attempts to remove the attendee from `registeredAttendees`. If successful, it checks if the `waitingList` is not empty. If so, it uses `poll()` to get and remove the head of the queue (the next person waiting) and adds them to `registeredAttendees`. If the attendee wasn't registered, it checks the `waitingList` and removes them if found. Returns a status string indicating the outcome.
 *     *   `displayStatus()`: Prints the workshop's details, including the size and contents of both the registered list and the waiting list, using `System.out`.
 * 
 * 2.  **ConferenceManagementSystem Class:**
 *     *   `private List<Workshop> workshops = new ArrayList<>();`: Uses the `List` interface implemented by `ArrayList` to hold multiple `Workshop` objects. `ArrayList` is good for storing and iterating through the fixed set of workshops.
 *     *   The constructor initializes this list with the predefined workshops.
 *     *   `findWorkshop(String name)`: A helper method to look up a workshop by its name within the `workshops` list.
 *     *   `run()`: This is the main loop of the application.
 *         *   It uses `Scanner` to read user input from the console.
 *         *   It splits the input line into command parts.
 *         *   A `switch` statement is used to determine which command was entered (`list_workshops`, `status`, `register`, `cancel`, `exit`).
 *         *   Inside each `case`, it validates the number of arguments (`parts.length`). If validation fails, it prints an error to `System.err`.
 *         *   If validation passes, it calls the appropriate private helper method (`listWorkshops`, `displayWorkshopStatus`, `registerAttendee`, `cancelRegistration`).
 *         *   The helper methods interact with the `Workshop` objects found using `findWorkshop`.
 *         *   Errors reported by `Workshop` methods (like attendee already exists, attendee not found) are checked (e.g., `result.startsWith("Error:")`) and printed to `System.err`, while success messages go to `System.out`.
 *         *   A `try-catch(Exception e)` block is wrapped around the core command processing logic within the loop. This demonstrates class-wide exception handling, catching any unexpected runtime errors and printing a message to `System.err`. Specific logical errors (like workshop not found) are handled by explicit checks and `System.err` calls, not by throwing exceptions.
 *     *   `listWorkshops()`, `displayWorkshopStatus()`, `registerAttendee()`, `cancelRegistration()`: These private helper methods encapsulate the logic for handling each command, finding the relevant workshop, and calling the appropriate method on the `Workshop` object. They also handle the case where the workshop is not found, reporting it to `System.err`.
 *     *   `main(String[] args)`: The entry point of the program, which creates a `ConferenceManagementSystem` instance and calls its `run()` method.
 * 
 * This solution effectively uses all the required Java components in a practical scenario, follows best practices for encapsulation and naming, includes input validation and distinct error/output streams, and demonstrates basic exception handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Iterator;

/**
 * Represents a single workshop with registration and waiting list management.
 */
class Workshop {
    private String name;
    private int capacity;
    private List<String> registeredAttendees; // Using ArrayList
    private Queue<String> waitingList;       // Using LinkedList for Queue

    /**
     * Constructs a Workshop object.
     * @param name The name of the workshop.
     * @param capacity The maximum number of attendees.
     */
    public Workshop(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registeredAttendees = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Registers an attendee for the workshop.
     * Adds to registered list if capacity allows, otherwise adds to waiting list.
     * @param attendeeName The name of the attendee.
     * @return A status message indicating the outcome (registered, waiting, already registered).
     */
    public String registerAttendee(String attendeeName) {
        if (registeredAttendees.contains(attendeeName) || waitingList.contains(attendeeName)) {
            return "Error: Attendee " + attendeeName + " is already registered or on waiting list for " + name + ".";
        }

        if (registeredAttendees.size() < capacity) {
            registeredAttendees.add(attendeeName);
            return attendeeName + " registered for " + name + ".";
        } else {
            waitingList.offer(attendeeName); // offer is safer than add for capacity-constrained queues, though not strictly needed here
            return "Workshop " + name + " is full. " + attendeeName + " added to waiting list.";
        }
    }

    /**
     * Cancels an attendee's registration or removes them from the waiting list.
     * If a registered attendee cancels and the waiting list is not empty,
     * the first person from the waiting list is moved to the registered list.
     * @param attendeeName The name of the attendee.
     * @return A status message indicating the outcome (cancelled, moved from waiting, not found).
     */
    public String cancelRegistration(String attendeeName) {
        boolean wasRegistered = registeredAttendees.remove(attendeeName);

        if (wasRegistered) {
            String message = attendeeName + " cancelled registration for " + name + ".";
            if (!waitingList.isEmpty()) {
                String nextAttendee = waitingList.poll(); // Get and remove the head of the queue
                registeredAttendees.add(nextAttendee);
                message += "\n" + nextAttendee + " moved from waiting list to registered for " + name + ".";
            }
            return message;
        } else {
            // Check if they are on the waiting list
            boolean wasOnWaitingList = waitingList.remove(attendeeName);
            if (wasOnWaitingList) {
                 return attendeeName + " removed from waiting list for " + name + ".";
            }
        }

        return "Error: Attendee " + attendeeName + " not found in registered or waiting list for " + name + ".";
    }

    /**
     * Displays the current status of the workshop.
     */
    public void displayStatus() {
        System.out.println("Workshop: " + name + " (Capacity: " + capacity + ")");
        System.out.println("Registered (" + registeredAttendees.size() + "/" + capacity + "): " + registeredAttendees);
        System.out.println("Waiting List (" + waitingList.size() + "): " + waitingList);
    }
}

/**
 * Manages a collection of workshops and handles user interactions.
 */
public class ConferenceManagementSystem {
    private List<Workshop> workshops; // Using ArrayList

    /**
     * Constructs the ConferenceManagementSystem and initializes workshops.
     */
    public ConferenceManagementSystem() {
        workshops = new ArrayList<>();
        // Initialize with predefined workshops
        workshops.add(new Workshop("Java Advanced Topics", 2));
        workshops.add(new Workshop("Python for Data Science", 3));
        workshops.add(new Workshop("Cloud Computing Basics", 1));
    }

    /**
     * Finds a workshop by name (case-insensitive).
     * @param name The name of the workshop to find.
     * @return The Workshop object if found, null otherwise.
     */
    private Workshop findWorkshop(String name) {
        for (Workshop workshop : workshops) {
            if (workshop.getName().equalsIgnoreCase(name)) {
                return workshop;
            }
        }
        return null;
    }

    /**
     * Runs the main command-line interface loop.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available commands: list_workshops, status <workshopName>, register <workshopName> <attendeeName>, cancel <workshopName> <attendeeName>, exit");

        boolean running = true;
        while (running) {
            System.out.print("Enter command: ");
            String commandLine = scanner.nextLine().trim();
            String[] parts = commandLine.split("\\s+"); // Split by one or more spaces

            if (parts.length == 0 || parts[0].isEmpty()) {
                continue; // Skip empty lines
            }

            String command = parts[0].toLowerCase(); // Process command case-insensitively

            // Class-wide exception handling block
            try {
                switch (command) {
                    case "list_workshops":
                        if (parts.length == 1) {
                            listWorkshops();
                        } else {
                            System.err.println("Error: 'list_workshops' command does not take arguments.");
                        }
                        break;

                    case "status":
                        if (parts.length == 2) {
                            String workshopName = parts[1];
                            displayWorkshopStatus(workshopName);
                        } else {
                            System.err.println("Error: 'status' command requires a workshop name.");
                        }
                        break;

                    case "register":
                        if (parts.length == 3) {
                            String workshopName = parts[1];
                            String attendeeName = parts[2];
                            registerAttendee(workshopName, attendeeName);
                        } else {
                            System.err.println("Error: 'register' command requires workshop name and attendee name.");
                        }
                        break;

                    case "cancel":
                        if (parts.length == 3) {
                            String workshopName = parts[1];
                            String attendeeName = parts[2];
                            cancelRegistration(workshopName, attendeeName);
                        } else {
                             System.err.println("Error: 'cancel' command requires workshop name and attendee name.");
                        }
                        break;

                    case "exit":
                        if (parts.length == 1) {
                            System.out.println("Exiting system.");
                            running = false;
                        } else {
                             System.err.println("Error: 'exit' command does not take arguments.");
                        }
                        break;

                    default:
                        System.err.println("Error: Unknown command '" + command + "'.");
                        break;
                }
            } catch (Exception e) {
                // Catch any unexpected exceptions during command processing
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // Optional: e.printStackTrace(); // For debugging purposes
            }
        }

        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Displays the names of all available workshops.
     */
    private void listWorkshops() {
        System.out.println("Available Workshops:");
        if (workshops.isEmpty()) {
            System.out.println("  No workshops available.");
        } else {
            for (Workshop workshop : workshops) {
                System.out.println("- " + workshop.getName());
            }
        }
    }

    /**
     * Displays the status of a specific workshop.
     * @param workshopName The name of the workshop.
     */
    private void displayWorkshopStatus(String workshopName) {
        Workshop workshop = findWorkshop(workshopName);
        if (workshop != null) {
            workshop.displayStatus();
        } else {
            System.err.println("Error: Workshop " + workshopName + " not found.");
        }
    }

    /**
     * Registers an attendee for a workshop.
     * @param workshopName The name of the workshop.
     * @param attendeeName The name of the attendee.
     */
    private void registerAttendee(String workshopName, String attendeeName) {
        Workshop workshop = findWorkshop(workshopName);
        if (workshop != null) {
            String result = workshop.registerAttendee(attendeeName);
            // Use System.out for success messages, System.err for specific errors reported by Workshop
            if (result.startsWith("Error:")) {
                 System.err.println(result);
            } else {
                 System.out.println(result);
            }
        } else {
            System.err.println("Error: Workshop " + workshopName + " not found.");
        }
    }

    /**
     * Cancels an attendee's registration for a workshop.
     * @param workshopName The name of the workshop.
     * @param attendeeName The name of the attendee.
     */
    private void cancelRegistration(String workshopName, String attendeeName) {
        Workshop workshop = findWorkshop(workshopName);
        if (workshop != null) {
             String result = workshop.cancelRegistration(attendeeName);
             // Use System.out for success messages, System.err for specific errors reported by Workshop
            if (result.startsWith("Error:")) {
                 System.err.println(result);
            } else {
                 System.out.println(result);
            }
        } else {
            System.err.println("Error: Workshop " + workshopName + " not found.");
        }
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ConferenceManagementSystem system = new ConferenceManagementSystem();
        system.run();
    }
}
