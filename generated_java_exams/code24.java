/*
 * Exam Question #24
 * Generated on: 2025-05-11 21:43:28
 * 
 * QUESTION:
 * **Java Programming Exam Task: Event Check-in System**
 * 
 * You are tasked with developing a simple console-based system to manage attendee check-in for an event with a limited capacity. The system should handle online registrations (pre-loaded) and walk-in registrations, manage a check-in queue, and process attendees from the queue while respecting the event's capacity.
 * 
 * Your solution must demonstrate proficiency in core Java concepts and utilize specific components as listed below.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a list of all registered attendees (both online and walk-in). Use a `java.util.List` variable, implemented by `java.util.ArrayList`.
 *     *   Maintain a queue of attendee IDs waiting to be checked in. Use a `java.util.Queue` variable (you can use `java.util.LinkedList` as the implementation).
 * 2.  **Attendee Representation:**
 *     *   Create a class `Attendee` with private fields for `id` (int), `name` (String), `ticketType` (String, e.g., "Standard", "VIP", "Walk-in"), and `checkedIn` (boolean).
 *     *   Include a constructor and public getter methods for all fields.
 *     *   Include a public setter method `setCheckedIn(boolean checkedIn)`.
 *     *   Override `toString()` for easy printing.
 * 3.  **Event Manager Logic:**
 *     *   Create a class `EventManager` to encapsulate the event management logic.
 *     *   Include private fields for the attendee list, the check-in queue, maximum event capacity, and the current count of checked-in attendees.
 *     *   The constructor should initialize these fields and pre-populate the attendee list with a few sample "online" attendees.
 *     *   Implement the following public methods:
 *         *   `registerAttendee(String name, String ticketType)`: Registers a new attendee (used for pre-population and walk-ins). Assigns a unique ID. Returns the assigned ID or -1 on failure.
 *         *   `addToCheckInQueue(int attendeeId)`: Adds the ID of a registered attendee to the check-in queue if they exist, are not already checked in, and not already in the queue. Print appropriate messages using `System.out` or `System.err`.
 *         *   `processCheckInQueue()`: Processes the attendee at the front of the check-in queue.
 *             *   If the queue is empty, print a message.
 *             *   If maximum capacity is reached, print an error using `System.err` and do not process.
 *             *   Otherwise, dequeue the attendee ID, find the attendee in the list, mark them as checked in, and increment the checked-in count. Print a success message using `System.out`. Handle cases where the ID from the queue isn't found or is already checked in (shouldn't happen with perfect logic, but defensive checks are good; remove the ID from the queue in such error cases).
 *         *   `displayStatus()`: Prints the current event status: maximum capacity, checked-in count, available slots, list of attendees currently in the check-in queue (displaying name and ID), and a list of attendees who are checked in (displaying name and ID). Use `System.out`.
 * 4.  **Main Application (`EventCheckInSystem` class):**
 *     *   In the `main` method:
 *         *   Create an `EventManager` instance with a reasonable capacity (e.g., 5 or 10).
 *         *   Use `java.util.Scanner` to get user input from the console.
 *         *   Implement a menu-driven interface allowing the user to:
 *             1.  Add an attendee ID to the check-in queue.
 *             2.  Process the next attendee from the queue.
 *             3.  Display event status.
 *             4.  Register a new walk-in attendee (and optionally add them to the queue).
 *             0.  Exit the system.
 *         *   Use a `switch` statement to handle the menu choices.
 *         *   Implement input validation for menu choices (ensure it's a number within the valid range). Use `System.err` for invalid input messages.
 *         *   Use `try-catch` blocks:
 *             *   Specifically handle `InputMismatchException` when reading integer input from the `Scanner`.
 *             *   Include a general `try-catch(Exception e)` block around the core logic within the menu loop (the `switch` statement body) to demonstrate class-wide exception handling for unexpected runtime issues. Print error details using `System.err`.
 *         *   Ensure the `Scanner` is closed when the program exits.
 * 5.  **General Requirements:**
 *     *   Follow best practices: proper encapsulation, meaningful variable/method names, appropriate comments (including Javadoc for classes/methods), clean code structure.
 *     *   Use `System.out` for normal output (menu, prompts, success messages, status).
 *     *   Use `System.err` for error messages (invalid input, capacity full, attendee not found, etc.).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept user input, perform the requested actions, print status updates, success messages, and error messages appropriately using `System.out` and `System.err`. The status display should clearly show the queue and checked-in attendees.
 * 
 * **Example Interaction Flow:**
 * 
 * ```
 * --- Event Check-in System ---
 * Select an option:
 * 1. Add Attendee to Check-in Queue
 * 2. Process Next from Queue
 * 3. Display Event Status
 * 4. Register New Walk-in Attendee
 * 0. Exit
 * Enter your choice: 3
 * --- Event Status ---
 * Maximum Capacity: 5
 * Currently Checked In: 0
 * Available Slots: 5
 * 
 * Attendees in Check-in Queue (0):
 *   Queue is empty.
 * 
 * Checked-in Attendees (0):
 *   No attendees checked in yet.
 * --------------------
 * 
 * Select an option:
 * ... (user adds attendees 101, 103 to queue) ...
 * Enter your choice: 1
 * Enter Attendee ID to add to queue: 101
 * Attendee Alice Online (ID 101) added to the check-in queue.
 * 
 * Select an option:
 * Enter your choice: 1
 * Enter Attendee ID to add to queue: 103
 * Attendee Charlie Online (ID 103) added to the check-in queue.
 * 
 * Select an option:
 * Enter your choice: 3
 * --- Event Status ---
 * Maximum Capacity: 5
 * Currently Checked In: 0
 * Available Slots: 5
 * 
 * Attendees in Check-in Queue (2):
 *   1. Alice Online (ID: 101)
 *   2. Charlie Online (ID: 103)
 * 
 * Checked-in Attendees (0):
 *   No attendees checked in yet.
 * --------------------
 * 
 * Select an option:
 * Enter your choice: 2
 * Successfully checked in Attendee: Alice Online (ID 101).
 * Current checked-in count: 1/5
 * 
 * Select an option:
 * Enter your choice: 2
 * Successfully checked in Attendee: Charlie Online (ID 103).
 * Current checked-in count: 2/5
 * 
 * Select an option:
 * Enter your choice: 4
 * Enter Walk-in Attendee Name: David Walkin
 * Registered new attendee: David Walkin with ID 104
 * Add David Walkin (ID 104) to check-in queue now? (yes/no): yes
 * Attendee David Walkin (ID 104) added to the check-in queue.
 * 
 * Select an option:
 * Enter your choice: 3
 * --- Event Status ---
 * Maximum Capacity: 5
 * Currently Checked In: 2
 * Available Slots: 3
 * 
 * Attendees in Check-in Queue (1):
 *   1. David Walkin (ID: 104)
 * 
 * Checked-in Attendees (2):
 *   - Alice Online (ID: 101)
 *   - Charlie Online (ID: 103)
 * --------------------
 * 
 * Select an option:
 * ... (process more, reach capacity, try to add/process more) ...
 * Enter your choice: 2
 * Successfully checked in Attendee: David Walkin (ID 104).
 * Current checked-in count: 3/5
 * ... (process two more) ...
 * Successfully checked in Attendee: Bob Online (ID 102).
 * Current checked-in count: 4/5
 * Successfully checked in Attendee: New Walkin (ID 105).
 * Current checked-in count: 5/5
 * 
 * Select an option:
 * Enter your choice: 2
 * Error: Maximum event capacity (5) reached. Cannot process more check-ins.
 * 
 * Select an option:
 * Enter your choice: 1
 * Enter Attendee ID to add to queue: 101
 * Error: Attendee Alice Online (ID 101) is already checked in.
 * 
 * Select an option:
 * Enter your choice: 0
 * Exiting system. Goodbye!
 * ```
 *
 * EXPLANATION:
 * The solution implements a basic event check-in system, demonstrating the required Java concepts and best practices.
 * 
 * **Key Components and Their Usage:**
 * 
 * 1.  **`Queue` (`java.util.Queue`)**: The `checkInQueue` in `EventManager` is declared as a `Queue<Integer>`, implemented by `java.util.LinkedList`. It stores the IDs of attendees waiting in line to be checked in, ensuring First-In, First-Out (FIFO) processing using `offer()` to add to the end and `poll()` to remove from the front. `peek()` is used to look at the next element without removing it.
 * 2.  **`ArrayList` (`java.util.ArrayList`)**: The `attendees` list in `EventManager` is instantiated as an `ArrayList<Attendee>`. This provides a dynamic array to store all `Attendee` objects (both pre-registered and walk-ins), allowing efficient access and iteration.
 * 3.  **`List` interface (`java.util.List`)**: The `attendees` variable is declared using the `List` interface (`List<Attendee> attendees = new ArrayList<>();`). This is good practice as it allows easily switching to a different `List` implementation later if needed, without changing the code that uses the `attendees` variable.
 * 4.  **`Scanner` (`java.util.Scanner`)**: A `Scanner` object is created in the `main` method (`new Scanner(System.in)`) to read user input from the console for menu choices and attendee details.
 * 5.  **`Switch` statement**: The `switch` statement in the `main` loop is used to direct the program flow based on the user's numeric menu selection, invoking the appropriate methods in the `EventManager`.
 * 6.  **`System.err`**: Used throughout the code to print error messages, such as invalid user input, attendee not found, attendee already checked in, capacity reached, or unexpected errors caught by `try-catch` blocks. This visually distinguishes error output from normal output.
 * 7.  **`System.out`**: Used for printing the menu, prompts for input, success messages after operations (e.g., successful check-in), and the formatted event status display.
 * 8.  **`Try-catch` blocks**:
 *     *   A `try-catch(InputMismatchException e)` block is used specifically when reading integer input (`scanner.nextInt()`) to handle cases where the user enters non-numeric text, preventing the program from crashing.
 *     *   A general `try-catch(Exception e)` block wraps the `switch` statement within the main loop. This provides a form of class-wide exception handling for the core operation logic, catching any unexpected runtime exceptions that might occur during the execution of the menu options and reporting them gracefully via `System.err`.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** The `Attendee` and `EventManager` classes have private fields, accessed and modified only through public methods (getters and controlled setters).
 * *   **Meaningful Names:** Variable names (`checkInQueue`, `maxCapacity`, `checkedInCount`), method names (`addToCheckInQueue`, `processCheckInQueue`, `displayStatus`), and class names (`Attendee`, `EventManager`, `EventCheckInSystem`) are descriptive, making the code readable.
 * *   **Comments and Documentation:** Javadoc comments are used for classes and methods, explaining their purpose, parameters, and return values. Inline comments explain specific logic points.
 * *   **Input Validation:** The code checks for empty names/ticket types during registration and handles non-numeric input using `try-catch`. `EventManager` methods perform checks (e.g., attendee existence, checked-in status, queue presence) before performing actions.
 * *   **Error Handling:** Error conditions (like capacity full, attendee not found) are explicitly checked and reported using `System.err`. Exceptions are caught and handled.
 * *   **Clean Code Structure:** The logic is separated into distinct classes (`Attendee` for data, `EventManager` for business logic, `EventCheckInSystem` for the main application loop and UI). Methods are focused on single responsibilities. The main loop is clear and easy to follow. Using `Optional` in `findAttendeeById` is a modern Java practice for handling potentially absent results.
 * 
 * This solution effectively integrates the required components into a practical scenario, demonstrating core Java programming skills, data structure usage, input/output handling, flow control, and error management, fitting the criteria for a challenging exam task.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Optional;

/**
 * Represents an attendee for the event.
 */
class Attendee {
    private int id;
    private String name;
    private String ticketType; // e.g., "Standard", "VIP", "Walk-in"
    private boolean checkedIn;

    /**
     * Constructs a new Attendee.
     * @param id The unique attendee ID.
     * @param name The name of the attendee.
     * @param ticketType The type of ticket (e.g., Standard, VIP).
     */
    public Attendee(int id, String name, String ticketType) {
        this.id = id;
        this.name = name;
        this.ticketType = ticketType;
        this.checkedIn = false; // Initially not checked in
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTicketType() {
        return ticketType;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    // --- Setter ---
    /**
     * Sets the checked-in status of the attendee.
     * @param checkedIn The new checked-in status.
     */
    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    /**
     * Returns a string representation of the Attendee.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Type: " + ticketType + ", CheckedIn: " + checkedIn;
    }
}

/**
 * Manages the event registration and check-in process.
 */
class EventManager {
    private List<Attendee> attendees; // Stores all registered attendees
    private Queue<Integer> checkInQueue; // Stores IDs of attendees waiting to check in
    private int maxCapacity;
    private int checkedInCount;
    private int nextAttendeeId; // Simple counter for generating unique IDs

    /**
     * Constructs an EventManager with a specified maximum capacity.
     * Pre-populates with some online attendees.
     * @param maxCapacity The maximum number of attendees allowed at the event.
     */
    public EventManager(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.attendees = new ArrayList<>(); // Implementation of List
        this.checkInQueue = new LinkedList<>(); // Implementation of Queue
        this.checkedInCount = 0;
        this.nextAttendeeId = 101; // Start IDs from 101 for online attendees

        // Pre-populate some online attendees
        System.out.println("Pre-registering online attendees...");
        registerAttendee("Alice Online", "Standard"); // ID 101
        registerAttendee("Bob Online", "VIP");      // ID 102
        registerAttendee("Charlie Online", "Standard"); // ID 103
        System.out.println("Pre-registration complete.");
    }

    /**
     * Finds an attendee by their ID.
     * @param id The ID to search for.
     * @return An Optional containing the Attendee if found, otherwise empty.
     */
    private Optional<Attendee> findAttendeeById(int id) {
        for (Attendee attendee : attendees) {
            if (attendee.getId() == id) {
                return Optional.of(attendee);
            }
        }
        return Optional.empty();
    }

    /**
     * Registers a new attendee.
     * Assigns a unique ID and adds them to the attendee list.
     * @param name The name of the attendee.
     * @param ticketType The ticket type (e.g., "Standard", "Walk-in").
     * @return The ID of the newly registered attendee, or -1 if registration failed (e.g., invalid input).
     */
    public int registerAttendee(String name, String ticketType) {
        if (name == null || name.trim().isEmpty() || ticketType == null || ticketType.trim().isEmpty()) {
            System.err.println("Error: Attendee name and ticket type cannot be empty.");
            return -1; // Indicate failure
        }
        int id = nextAttendeeId++;
        Attendee newAttendee = new Attendee(id, name.trim(), ticketType.trim());
        attendees.add(newAttendee);
        System.out.println("Registered new attendee: " + newAttendee.getName() + " with ID " + newAttendee.getId());
        return id; // Return the new ID
    }

    /**
     * Adds a registered attendee to the check-in queue.
     * Performs checks to ensure the attendee exists and is not already checked in or in the queue.
     * @param attendeeId The ID of the attendee to add to the queue.
     */
    public void addToCheckInQueue(int attendeeId) {
        Optional<Attendee> attendeeOpt = findAttendeeById(attendeeId);

        if (!attendeeOpt.isPresent()) {
            System.err.println("Error: Attendee with ID " + attendeeId + " not found in registered attendees.");
            return;
        }

        Attendee attendee = attendeeOpt.get();

        if (attendee.isCheckedIn()) {
            System.err.println("Error: Attendee " + attendee.getName() + " (ID " + attendeeId + ") is already checked in.");
            return;
        }

        // Check if already in queue
        if (checkInQueue.contains(attendeeId)) {
             System.err.println("Error: Attendee " + attendee.getName() + " (ID " + attendeeId + ") is already in the check-in queue.");
             return;
        }

        checkInQueue.offer(attendeeId); // Add to the end of the queue
        System.out.println("Attendee " + attendee.getName() + " (ID " + attendeeId + ") added to the check-in queue.");
    }

    /**
     * Processes the next attendee from the check-in queue.
     * Checks capacity and updates attendee status.
     */
    public void processCheckInQueue() {
        if (checkInQueue.isEmpty()) {
            System.out.println("Check-in queue is empty. No one to process.");
            return;
        }

        if (checkedInCount >= maxCapacity) {
            System.err.println("Error: Maximum event capacity (" + maxCapacity + ") reached. Cannot process more check-ins.");
            // Attendee remains in queue until space is available.
            return;
        }

        // Get the ID from the front of the queue without removing it yet
        Integer attendeeIdToProcess = checkInQueue.peek();

        Optional<Attendee> attendeeOpt = findAttendeeById(attendeeIdToProcess);

        // Defensive check: Should not happen if IDs are managed correctly
        if (!attendeeOpt.isPresent()) {
            System.err.println("Error: Attendee with ID " + attendeeIdToProcess + " from queue not found in attendee list. Removing from queue.");
            checkInQueue.poll(); // Remove the bad ID from the queue
            return;
        }

        Attendee attendee = attendeeOpt.get();

        // Defensive check: Should not happen if addToCheckInQueue logic is followed
        if (attendee.isCheckedIn()) {
             System.err.println("Warning: Attendee " + attendee.getName() + " (ID " + attendeeIdToProcess + ") from queue was already marked as checked in. Removing from queue.");
             checkInQueue.poll(); // Remove from queue if already checked in somehow
             return;
        }

        // --- Successful Check-in ---
        checkInQueue.poll(); // Remove from queue
        attendee.setCheckedIn(true); // Mark as checked in
        checkedInCount++; // Increment count

        System.out.println("Successfully checked in Attendee: " + attendee.getName() + " (ID " + attendee.getId() + ").");
        System.out.println("Current checked-in count: " + checkedInCount + "/" + maxCapacity);
    }

    /**
     * Displays the current status of the event, including capacity,
     * checked-in count, queue contents, and list of checked-in attendees.
     */
    public void displayStatus() {
        System.out.println("\n--- Event Status ---");
        System.out.println("Maximum Capacity: " + maxCapacity);
        System.out.println("Currently Checked In: " + checkedInCount);
        System.out.println("Available Slots: " + (maxCapacity - checkedInCount));

        System.out.println("\nAttendees in Check-in Queue (" + checkInQueue.size() + "):");
        if (checkInQueue.isEmpty()) {
            System.out.println("  Queue is empty.");
        } else {
            // Iterate through queue without removing elements
            int position = 1;
            for (Integer attendeeId : checkInQueue) {
                 Optional<Attendee> attendeeOpt = findAttendeeById(attendeeId);
                 String attendeeInfo = attendeeOpt.map(a -> a.getName() + " (ID: " + a.getId() + ")").orElse("Unknown Attendee (ID: " + attendeeId + ")");
                 System.out.println("  " + position++ + ". " + attendeeInfo);
            }
        }

        System.out.println("\nChecked-in Attendees (" + checkedInCount + "):");
        if (checkedInCount == 0) {
             System.out.println("  No attendees checked in yet.");
        } else {
            // Iterate through all attendees to find checked-in ones
            int count = 0;
            for (Attendee attendee : attendees) {
                if (attendee.isCheckedIn()) {
                    System.out.println("  - " + attendee.getName() + " (ID: " + attendee.getId() + ")");
                    count++;
                }
            }
            // The count variable here should ideally match checkedInCount,
            // but iterating through the list ensures we print the correct ones.
        }

        System.out.println("--------------------");
    }
}

/**
 * Main class for the Event Check-in System.
 * Handles user interaction and the main application loop.
 */
public class EventCheckInSystem {

    public static void main(String[] args) {
        // Use Scanner for reading input from System.in
        Scanner scanner = new Scanner(System.in);
        // Create EventManager instance with a capacity
        EventManager eventManager = new EventManager(5); // Example capacity

        System.out.println("\n--- Event Check-in System ---");

        // Main application loop
        while (true) {
            printMenu(); // Display menu options
            int choice = -1;

            // Try-catch block for reading integer input
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

            } catch (InputMismatchException e) {
                // Handle non-integer input
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                continue; // Restart the loop to show the menu again
            } catch (Exception e) {
                 // Catch any other unexpected errors during input reading
                 System.err.println("An unexpected error occurred while reading input: " + e.getMessage());
                 // Decide if you want to exit or continue. Continuing is often better in a loop.
                 scanner.nextLine(); // Attempt to consume line to clear buffer
                 continue; // Restart the loop
            }

            // Class-wide exception handling for the main logic block
            try {
                // Use switch statement for flow control based on user choice
                switch (choice) {
                    case 1: // Add attendee to check-in queue
                        System.out.print("Enter Attendee ID to add to queue: ");
                         int idToAdd = -1;
                         try {
                             idToAdd = scanner.nextInt();
                             scanner.nextLine(); // Consume newline
                             eventManager.addToCheckInQueue(idToAdd);
                         } catch (InputMismatchException e) {
                             System.err.println("Invalid ID input. Please enter a number.");
                             scanner.nextLine(); // Consume invalid input
                         }
                        break;

                    case 2: // Process next attendee from queue
                        eventManager.processCheckInQueue();
                        break;

                    case 3: // Display Status
                        eventManager.displayStatus();
                        break;

                    case 4: // Register New Walk-in Attendee
                         System.out.print("Enter Walk-in Attendee Name: ");
                         String walkInName = scanner.nextLine();
                         // Register the walk-in attendee
                         int newWalkInId = eventManager.registerAttendee(walkInName, "Walk-in");

                         if (newWalkInId != -1) { // Check if registration was successful
                              System.out.print("Add " + walkInName + " (ID " + newWalkInId + ") to check-in queue now? (yes/no): ");
                              String addNow = scanner.nextLine().trim().toLowerCase();
                              if ("yes".equals(addNow)) {
                                   eventManager.addToCheckInQueue(newWalkInId);
                              }
                         }
                         break;

                    case 0: // Exit
                        System.out.println("Exiting system. Goodbye!");
                        scanner.close(); // Close the scanner resource
                        return; // Exit the main method and terminate the program

                    default:
                        // Handle choices outside the defined range
                        System.err.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                 // Catch any unexpected exceptions during the execution of menu options
                 System.err.println("An unexpected error occurred during operation: " + e.getMessage());
                 // e.printStackTrace(); // Uncomment for debugging purposes if needed
            }
        }
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Add Attendee to Check-in Queue");
        System.out.println("2. Process Next from Queue");
        System.out.println("3. Display Event Status");
        System.out.println("4. Register New Walk-in Attendee");
        System.out.println("0. Exit");
    }
}
