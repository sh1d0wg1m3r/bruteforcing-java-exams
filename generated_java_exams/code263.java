/*
 * Exam Question #263
 * Generated on: 2025-05-11 22:46:35
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Event Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simplified Event Management System. The system should allow managing multiple events, registering attendees, and handling waiting lists for events that reach their capacity.
 * 
 * **Requirements:**
 * 
 * Implement a Java program that fulfills the following:
 * 
 * 1.  **Core Data Structures:**
 *     *   Maintain a collection of `Event` objects.
 *     *   Each `Event` object must store:
 *         *   Its name (String).
 *         *   Its maximum capacity (int).
 *         *   A list of registered attendees (`List<String>`).
 *         *   A waiting list for attendees when the event is full (`Queue<String>`).
 *     *   Use `java.util.ArrayList` for the list of `Event` objects managed by the system.
 *     *   Use `java.util.ArrayList` for the attendees list within each `Event`.
 *     *   Use `java.util.Queue` (specifically, a concrete implementation like `LinkedList`) for the waiting list within each `Event`.
 *     *   Use the `java.util.List` interface type when declaring variables that can hold any List implementation (e.g., for method parameters or return types where the specific implementation doesn't matter).
 * 
 * 2.  **Functionality:**
 *     *   **Add Event:** Allow adding a new event with a name and capacity. Capacity must be a positive integer.
 *     *   **Register Attendee:** Allow registering an attendee for a specific event by name.
 *         *   If the event is not full, add the attendee to the event's attendee list.
 *         *   If the event is full, add the attendee to the event's waiting list.
 *         *   Handle cases where the event name does not exist.
 *     *   **Process Waiting List:** For a specific event, attempt to move one person from the waiting list to the attendee list *if* there is space available.
 *     *   **View Event Details:** Display the name, capacity, current number of attendees, the list of registered attendees, the number of people on the waiting list, and the list of people on the waiting list for a specific event. Handle cases where the event name does not exist.
 *     *   **Exit:** Terminate the program.
 * 
 * 3.  **User Interface:**
 *     *   Provide a simple text-based menu using `java.util.Scanner` for user interaction.
 *     *   Use a `switch` statement to handle the different menu options.
 * 
 * 4.  **Error Handling and Best Practices:**
 *     *   Implement robust input validation. For example, ensure capacity is positive, event names are not empty, and menu choices are valid integers.
 *     *   Use `System.err` to display all error messages (e.g., invalid input, event not found, operation failed).
 *     *   Use `System.out` for all normal output (menu, prompts, success messages, event details).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential runtime errors, especially related to user input parsing (`InputMismatchException`). The main application loop should continue after catching an input error.
 *     *   Follow Java best practices:
 *         *   Proper encapsulation (private fields, public methods).
 *         *   Meaningful variable and method names.
 *         *   Appropriate comments and documentation (Javadocs are a plus).
 *         *   Clean code structure (e.g., separate classes for `Event` and the main management logic).
 * 
 * **Expected Output:**
 * 
 * The program should present a menu, accept user input, perform the requested action, print results or errors, and loop until the user chooses to exit. Error messages *must* go to `System.err`.
 * 
 * Example Interaction Snippet (Illustrative):
 * 
 * ```
 * --- Event Management Menu ---
 * 1. Add Event
 * 2. Register Attendee
 * 3. Process Waiting List
 * 4. View Event Details
 * 5. Exit
 * Enter your choice: 1
 * Enter event name: Tech Conference
 * Enter capacity: 100
 * Event 'Tech Conference' added with capacity 100.
 * 
 * --- Event Management Menu ---
 * 1. Add Event
 * ...
 * Enter your choice: 2
 * Enter event name: Tech Conference
 * Enter attendee name: Alice
 * Alice registered for 'Tech Conference'.
 * 
 * --- Event Management Menu ---
 * ...
 * Enter your choice: 2
 * Enter event name: Tech Conference
 * Enter attendee name: Bob
 * Bob registered for 'Tech Conference'.
 * ... (after 100 registrations)
 * Enter your choice: 2
 * Enter event name: Tech Conference
 * Enter attendee name: Charlie
 * Event 'Tech Conference' is full. Charlie added to waiting list.
 * 
 * --- Event Management Menu ---
 * ...
 * Enter your choice: 4
 * Enter event name: Tech Conference
 * Event: Tech Conference (Capacity: 100)
 * Attendees (100): [Alice, ..., Bob]
 * Waiting List (1): [Charlie]
 * 
 * --- Event Management Menu ---
 * ...
 * Enter your choice: 3
 * Enter event name: Tech Conference
 * No space available. Cannot move from waiting list yet. (Example output if still full)
 * 
 * --- Event Management Menu ---
 * ... (Assume an attendee cancels, making space)
 * Enter your choice: 3
 * Enter event name: Tech Conference
 * Successfully moved Charlie from waiting list to attendees for 'Tech Conference'.
 * 
 * --- Event Management Menu ---
 * ...
 * Enter your choice: 4
 * Enter event name: Tech Conference
 * Event: Tech Conference (Capacity: 100)
 * Attendees (100): [Alice, ..., Bob, Charlie]
 * Waiting List (0): []
 * 
 * --- Event Management Menu ---
 * ...
 * Enter your choice: 6
 * Invalid menu choice. Please enter a number between 1 and 5. (This error goes to System.err)
 * 
 * --- Event Management Menu ---
 * ...
 * Enter your choice: 4
 * Enter event name: NonExistentEvent
 * Error: Event 'NonExistentEvent' not found. (This error goes to System.err)
 * 
 * --- Event Management Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Event Management System.
 * ```
 * 
 * **Submission:**
 * 
 * Provide the complete, runnable Java code for the Event Management System. Structure your code into appropriate classes and include necessary imports.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct usage of `Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`.
 * *   Implementation of all required functionalities.
 * *   Correct handling of event capacity and waiting list logic.
 * *   Robust input validation and error handling (using `System.err` for errors).
 * *   Adherence to best practices (encapsulation, naming, comments, code structure).
 * *   Code clarity and readability.
 *
 * EXPLANATION:
 * This solution implements the Event Management System as required, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * **Class Structure:**
 * 
 * 1.  **`Event` Class:**
 *     *   Represents a single event.
 *     *   Fields (`name`, `capacity`, `attendees`, `waitingList`) are `private` for encapsulation.
 *     *   `attendees` is declared as `List<String>` and initialized as `ArrayList<String>`, demonstrating the use of the `List` interface type and a concrete `ArrayList` implementation.
 *     *   `waitingList` is declared as `Queue<String>` and initialized as `LinkedList<String>`, demonstrating the use of the `Queue` interface type and a concrete `LinkedList` implementation (which implements `Queue`). `LinkedList` is suitable here as it provides efficient add/remove from both ends, though for a simple queue, only the head/tail operations are primarily used.
 *     *   Methods like `addAttendee` and `processWaitingList` encapsulate the logic for managing the attendees and waiting list based on capacity.
 *     *   `isFull()` provides a clear check for the event's status.
 *     *   Getter methods are provided, returning copies of the lists/queue (`ArrayList<>(attendees)`, `LinkedList<>(waitingList)`) to maintain encapsulation and prevent external modification of the internal state.
 *     *   The constructor validates that capacity is positive, throwing an `IllegalArgumentException`.
 *     *   An overridden `toString()` method provides a convenient way to display event details.
 * 
 * 2.  **`EventManagementSystem` Class:**
 *     *   Acts as the main controller for the system.
 *     *   Manages a `List<Event>` (`events`), initialized as an `ArrayList<Event>`. This fulfills the requirement of using `ArrayList` and `List` for the collection of events.
 *     *   Uses a `Scanner` (`scanner`) to handle user input.
 *     *   `findEventByName` is a helper method to locate events, promoting code reuse.
 *     *   Methods like `addEvent`, `registerAttendee`, `processWaitingList`, and `viewEventDetails` implement the core functionalities by interacting with the `Event` objects.
 *     *   `displayMenu` prints the user options.
 *     *   `run` contains the main application loop, displaying the menu and processing user choices.
 * 
 * **Component Usage:**
 * 
 * *   **`Queue` (`java.util.Queue`)**: Used for `waitingList` within the `Event` class. `LinkedList` is used as the concrete implementation. Methods like `offer()` (to add to the tail) and `poll()` (to remove from the head) are used to manage the waiting list queue.
 * *   **`ArrayList` (`java.util.ArrayList`)**: Used for the `events` list in `EventManagementSystem` and the `attendees` list in the `Event` class. Demonstrates dynamic array capabilities for storing collections of objects.
 * *   **`List` (`java.util.List`)**: Used as the type declaration for the `events` field in `EventManagementSystem` and the `attendees` field in `Event`, as well as return types for getters (`getAttendees()`). This demonstrates programming to the interface rather than the specific implementation where appropriate.
 * *   **`Scanner` (`java.util.Scanner`)**: Used in `EventManagementSystem` to read user input from `System.in`.
 * *   **`switch` Statement**: Used in the `run` method of `EventManagementSystem` to handle different menu options based on the user's integer input.
 * *   **`System.err`**: Used exclusively for printing error messages, such as invalid input, event not found, or issues during operations. This separates error output from normal program output.
 * *   **`System.out`**: Used for printing the menu, prompts, successful operation messages, and event details.
 * *   **`try-catch` Blocks**:
 *     *   A `try-catch (InputMismatchException)` block is used in the `run` method to handle cases where the user enters non-integer input for the menu choice, preventing the program from crashing and allowing the loop to continue.
 *     *   A `try-catch (InputMismatchException)` block is used in `addEvent` to handle non-integer input for event capacity.
 *     *   A `try-catch (IllegalArgumentException)` is used in `addEvent` to catch the exception thrown by the `Event` constructor if capacity is invalid.
 *     *   A general `try-catch (Exception)` is included in the `run` loop as a safety net for any other unexpected runtime errors within the loop's execution, printing the error to `System.err`.
 * 
 * **Best Practices:**
 * 
 * *   **Encapsulation:** Fields are private, access is through public methods. Copies are returned for collection getters.
 * *   **Meaningful Names:** Classes, methods, and variables have descriptive names (`EventManagementSystem`, `addAttendee`, `waitingList`, `eventName`).
 * *   **Comments/Documentation:** Javadoc-style comments explain the purpose of classes, methods, and parameters.
 * *   **Input Validation:** Checks are performed for empty names, non-positive capacity, and invalid menu choices.
 * *   **Error Handling:** Specific exceptions (`InputMismatchException`, `IllegalArgumentException`) are caught, and informative messages are printed to `System.err`. Event-not-found scenarios are handled gracefully.
 * *   **Clean Code Structure:** Logic is separated into distinct methods and classes (`Event` handles its internal state, `EventManagementSystem` handles the overall system logic and user interaction). The `main` method is minimal, simply creating the system and starting its `run` method.
 * *   **Resource Management:** The `Scanner` is closed when the program exits.
 * 
 * This solution provides a robust and well-structured implementation that meets all the specified requirements, making it a challenging but fair assessment of advanced Java concepts in a practical context.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single event with attendees and a waiting list.
 */
class Event {
    private String name;
    private int capacity;
    private List<String> attendees;
    private Queue<String> waitingList;

    /**
     * Constructs a new Event.
     *
     * @param name     The name of the event.
     * @param capacity The maximum number of attendees.
     * @throws IllegalArgumentException if capacity is not positive.
     */
    public Event(String name, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer.");
        }
        this.name = name;
        this.capacity = capacity;
        this.attendees = new ArrayList<>(); // Use ArrayList for attendees
        this.waitingList = new LinkedList<>(); // Use LinkedList as a Queue implementation
    }

    /**
     * Gets the name of the event.
     *
     * @return The event name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the capacity of the event.
     *
     * @return The event capacity.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the list of attendees.
     *
     * @return A read-only view of the attendees list.
     */
    public List<String> getAttendees() {
        return new ArrayList<>(attendees); // Return a copy for encapsulation
    }

    /**
     * Gets the waiting list.
     *
     * @return A read-only view of the waiting list.
     */
    public Queue<String> getWaitingList() {
        return new LinkedList<>(waitingList); // Return a copy for encapsulation
    }

    /**
     * Checks if the event is currently full.
     *
     * @return true if the number of attendees meets or exceeds capacity, false otherwise.
     */
    public boolean isFull() {
        return attendees.size() >= capacity;
    }

    /**
     * Adds an attendee to the event. If full, adds to the waiting list.
     *
     * @param attendeeName The name of the attendee to add.
     * @return A message indicating whether the attendee was registered or added to the waiting list.
     */
    public String addAttendee(String attendeeName) {
        if (attendeeName == null || attendeeName.trim().isEmpty()) {
            return "Error: Attendee name cannot be empty."; // Basic validation
        }
        if (!isFull()) {
            attendees.add(attendeeName);
            return attendeeName + " registered for '" + name + "'.";
        } else {
            waitingList.offer(attendeeName); // offer is preferred over add for queues
            return "Event '" + name + "' is full. " + attendeeName + " added to waiting list.";
        }
    }

    /**
     * Attempts to move one person from the waiting list to the attendees list
     * if there is space available.
     *
     * @return A message indicating the result of the process.
     */
    public String processWaitingList() {
        if (!isFull()) {
            String nextAttendee = waitingList.poll(); // poll removes and returns head, or null if empty
            if (nextAttendee != null) {
                attendees.add(nextAttendee);
                return "Successfully moved " + nextAttendee + " from waiting list to attendees for '" + name + "'.";
            } else {
                return "Waiting list for '" + name + "' is empty. No one to move.";
            }
        } else {
            return "Event '" + name + "' is still full. Cannot move anyone from waiting list yet.";
        }
    }

    /**
     * Returns a string representation of the event details.
     *
     * @return Detailed string of the event.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event: ").append(name).append(" (Capacity: ").append(capacity).append(")\n");
        sb.append("Attendees (").append(attendees.size()).append("): ").append(attendees).append("\n");
        sb.append("Waiting List (").append(waitingList.size()).append("): ").append(waitingList);
        return sb.toString();
    }
}

/**
 * Manages a collection of events.
 */
public class EventManagementSystem {
    // Using ArrayList to store multiple Event objects
    private List<Event> events;
    private Scanner scanner;

    /**
     * Constructs a new EventManagementSystem.
     */
    public EventManagementSystem() {
        this.events = new ArrayList<>(); // Use ArrayList for the main list of events
        this.scanner = new Scanner(System.in);
    }

    /**
     * Finds an event by its name.
     *
     * @param eventName The name of the event to find.
     * @return The Event object if found, null otherwise.
     */
    private Event findEventByName(String eventName) {
        for (Event event : events) {
            if (event.getName().equalsIgnoreCase(eventName.trim())) {
                return event;
            }
        }
        return null; // Event not found
    }

    /**
     * Adds a new event to the system.
     */
    public void addEvent() {
        System.out.print("Enter event name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.err.println("Error: Event name cannot be empty.");
            return;
        }

        // Check if event already exists (optional but good practice)
        if (findEventByName(name) != null) {
             System.err.println("Error: Event with name '" + name + "' already exists.");
             return;
        }

        System.out.print("Enter capacity: ");
        // Use try-catch for Scanner input parsing
        try {
            int capacity = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            Event newEvent = new Event(name, capacity);
            events.add(newEvent);
            System.out.println("Event '" + name + "' added with capacity " + capacity + ".");

        } catch (InputMismatchException e) {
            System.err.println("Error: Invalid capacity. Please enter a whole number.");
            scanner.nextLine(); // Consume the invalid input
        } catch (IllegalArgumentException e) {
             System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Registers an attendee for a specific event.
     */
    public void registerAttendee() {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine().trim();
        if (eventName.isEmpty()) {
            System.err.println("Error: Event name cannot be empty.");
            return;
        }

        Event event = findEventByName(eventName);

        if (event == null) {
            System.err.println("Error: Event '" + eventName + "' not found.");
            return;
        }

        System.out.print("Enter attendee name: ");
        String attendeeName = scanner.nextLine().trim();
        if (attendeeName.isEmpty()) {
            System.err.println("Error: Attendee name cannot be empty.");
            return;
        }

        String result = event.addAttendee(attendeeName);
        System.out.println(result);
    }

    /**
     * Processes the waiting list for a specific event.
     */
    public void processWaitingList() {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine().trim();
        if (eventName.isEmpty()) {
            System.err.println("Error: Event name cannot be empty.");
            return;
        }

        Event event = findEventByName(eventName);

        if (event == null) {
            System.err.println("Error: Event '" + eventName + "' not found.");
            return;
        }

        String result = event.processWaitingList();
        System.out.println(result);
    }

    /**
     * Displays details for a specific event.
     */
    public void viewEventDetails() {
        System.out.print("Enter event name: ");
        String eventName = scanner.nextLine().trim();
        if (eventName.isEmpty()) {
            System.err.println("Error: Event name cannot be empty.");
            return;
        }

        Event event = findEventByName(eventName);

        if (event == null) {
            System.err.println("Error: Event '" + eventName + "' not found.");
            return;
        }

        System.out.println(event); // Uses the overridden toString() method
    }

    /**
     * Displays the main menu.
     */
    private void displayMenu() {
        System.out.println("\n--- Event Management Menu ---");
        System.out.println("1. Add Event");
        System.out.println("2. Register Attendee");
        System.out.println("3. Process Waiting List");
        System.out.println("4. View Event Details");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Runs the main application loop.
     */
    public void run() {
        int choice = -1;
        while (choice != 5) {
            displayMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after reading the integer

                // Use switch statement for flow control
                switch (choice) {
                    case 1:
                        addEvent();
                        break;
                    case 2:
                        registerAttendee();
                        break;
                    case 3:
                        processWaitingList();
                        break;
                    case 4:
                        viewEventDetails();
                        break;
                    case 5:
                        System.out.println("Exiting Event Management System.");
                        break;
                    default:
                        // Invalid choice handling
                        System.err.println("Invalid menu choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Catch non-integer input for the menu choice
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                choice = -1; // Reset choice to ensure loop continues
            } catch (Exception e) {
                // General catch-all for unexpected errors in the loop
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(System.err); // Print stack trace to error stream
                choice = -1; // Reset choice
            }
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Main method to start the application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        EventManagementSystem system = new EventManagementSystem();
        system.run();
    }
}
