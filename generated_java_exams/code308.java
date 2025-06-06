/*
 * Exam Question #308
 * Generated on: 2025-05-11 22:52:55
 * Generated by: Account 1
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Event Ticket Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a simple command-line application to manage ticket bookings and waitlists for a series of events. The system should allow users to view events, book tickets, and manage a waitlist when events are full.
 * 
 * **Requirements:**
 * 
 * 1.  **Core Functionality:**
 *     *   Display a list of available events, showing their ID, name, capacity, and current booked count.
 *     *   Allow a user to attempt to book a ticket for a specific event by providing the Event ID.
 *     *   If an event is full when a user attempts to book, prompt the user if they want to join a waitlist for that event. If they agree, add their name to the waitlist.
 *     *   Provide an option to process the waitlist for a specific event. This action should book tickets for customers on the waitlist, one by one, until the event is full or the waitlist is empty.
 *     *   Allow viewing the current waitlist for a specific event.
 *     *   Provide an option to exit the application.
 * 
 * 2.  **Required Java Components:** Your solution MUST demonstrate the use of ALL the following Java components:
 *     *   `java.util.Queue` (used for waitlists)
 *     *   `java.util.ArrayList` (used for storing the list of events)
 *     *   `java.util.List` interface (used as the type for collections where appropriate, e.g., the list of events or waitlist view)
 *     *   `java.util.Scanner` (used for reading user input from the console)
 *     *   `switch` statement (used for handling the main menu choices)
 *     *   `System.err` (used for printing error messages)
 *     *   `System.out` (used for printing normal output like menus, event lists, success messages)
 *     *   Class-wide exception handling with `try-catch` blocks (demonstrate catching various exceptions like input errors or custom application exceptions).
 * 
 * 3.  **Best Practices:**
 *     *   Use appropriate object-oriented design (e.g., separate classes for `Event` and the management logic).
 *     *   Implement proper encapsulation (private fields, public methods/getters).
 *     *   Use meaningful variable and method names.
 *     *   Include comments and basic documentation (e.g., explaining class purpose or complex logic).
 *     *   Perform input validation (e.g., ensuring integer input where expected, checking if event ID exists).
 *     *   Implement proper error handling (e.g., catching `InputMismatchException`, handling cases like event not found, empty waitlist).
 *     *   Structure the code cleanly.
 * 
 * **Implementation Details:**
 * 
 * *   Create an `Event` class with fields for ID, name, capacity, and current booked count.
 * *   Create an `EventManager` class that holds a collection of `Event` objects and a mechanism to manage waitlists for each event (Hint: A `Map` where keys are Event IDs and values are `Queue`s might be useful). This class should contain the core logic for booking, joining waitlists, and processing waitlists.
 * *   Create a main class (e.g., `ExamSystem`) with a `main` method that sets up the system, displays the menu, reads user input using `Scanner`, and uses a `switch` statement to call appropriate methods in the `EventManager`.
 * *   Initialize the system with a few dummy events.
 * *   Define a custom exception (optional but recommended) for scenarios like "Event Not Found".
 * 
 * **Expected Output:**
 * 
 * The program should present a menu to the user. Based on user input, it should perform the requested action and print relevant information or error messages to `System.out` or `System.err`.
 * 
 * Example interaction flow:
 * 
 * ```
 * --- Event Ticket Management System ---
 * Select an option:
 * 1. List Events
 * 2. Book Ticket
 * 3. Join Waitlist (Use option 2)
 * 4. Process Waitlist
 * 5. Display Waitlist
 * 6. Exit
 * Enter your choice: 1
 * 
 * --- Available Events ---
 * Event [ID=101, Name=Java Conference, Capacity=50, Booked=0]
 * Event [ID=102, Name=AI Workshop, Capacity=30, Booked=0]
 * Event [ID=103, Name=Web Dev Meetup, Capacity=100, Booked=0]
 * ------------------------
 * 
 * Select an option:
 * ... (user books tickets until Event 101 is full) ...
 * 
 * Select an option:
 * 1. List Events
 * ...
 * Enter your choice: 2
 * Enter Event ID to book a ticket: 101
 * Event 101 is currently full.
 * Would you like to join the waitlist? (yes/no): yes
 * Enter your name for the waitlist: Alice
 * Successfully added Alice to the waitlist for Event 101.
 * 
 * Select an option:
 * ...
 * Enter your choice: 5
 * Enter Event ID to display waitlist: 101
 * 
 * --- Waitlist for Event 101 ---
 * 1. Alice
 * ----------------------------
 * 
 * Select an option:
 * ... (assume some tickets for 101 become available, e.g., capacity increased or tickets released - for this exam, processing waitlist directly handles booking if space exists) ...
 * 
 * Select an option:
 * Enter your choice: 4
 * Enter Event ID to process waitlist: 101
 * Successfully booked ticket for Alice from waitlist for Event 101.
 * Waitlist for event 101 is now empty after processing.
 * Processed waitlist for Event 101. Booked 1 ticket(s).
 * 
 * Select an option:
 * ...
 * Enter your choice: 6
 * Exiting system. Goodbye!
 * ```
 * 
 * Your solution must be a single self-contained Java program (can use multiple classes within the same file or assume separate files in a package).
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correctness and completeness of implementing the required functionality.
 * *   Proper usage of ALL specified Java components.
 * *   Adherence to best practices (encapsulation, naming, comments, structure).
 * *   Robustness through input validation and exception handling.
 * *   Clear and informative output.
 *
 * EXPLANATION:
 * This solution implements a basic Event Ticket Management System adhering to all specified requirements.
 * 
 * 1.  **Structure and OOP:** The problem is broken down into three classes:
 *     *   `Event`: Represents a single event with its state (ID, name, capacity, booked count). It encapsulates its data with private fields and provides public getters and methods (`isFull`, `bookTicket`) for controlled access and state modification.
 *     *   `EventManager`: Acts as the central hub for managing multiple events and their waitlists. It holds an `ArrayList` of `Event` objects (typed as `List`) and a `HashMap` (`waitlists`) where keys are Event IDs and values are `Queue`s (specifically `LinkedList` implementations) storing customer names for waitlists. It contains the core business logic methods like `bookTicket`, `joinWaitlist`, `processWaitlist`, and `getWaitlist`.
 *     *   `ExamSystem`: Contains the `main` method, handles the user interface (menu display, input reading), and orchestrates calls to the `EventManager`.
 * 
 * 2.  **Required Components Usage:**
 *     *   `java.util.Queue`: Used within `EventManager.waitlists`. Each event's waitlist is a `Queue<String>` (implemented by `LinkedList`), correctly using `offer()` to add to the tail and `poll()` to remove from the head during waitlist processing.
 *     *   `java.util.ArrayList`: Used as the concrete implementation for the `eventList` field in `EventManager`.
 *     *   `java.util.List` interface: Used as the declared type for the `eventList` field in `EventManager` and as the return type for `EventManager.getEventList()` and `EventManager.getWaitlist()`, promoting good practice of programming to interfaces.
 *     *   `java.util.Scanner`: Used in the `ExamSystem.main` method and helper methods (`bookTicket`, `processWaitlist`, `displayWaitlist`) to read various types of user input (integers for choices/IDs, strings for names/responses).
 *     *   `switch` statement: Used prominently in the `ExamSystem.main` method to dispatch control based on the user's menu selection.
 *     *   `System.err`: Used for printing error messages, such as invalid menu choices, invalid input types (`InputMismatchException`), and messages from caught exceptions (`EventNotFoundException`, `IllegalStateException`).
 *     *   `System.out`: Used for all normal output, including the menu, event listings, success messages, waitlist contents, and informational messages during waitlist processing.
 *     *   Class-wide exception handling with `try-catch`: The `main` method has a large `try-catch` block encompassing the main loop's interaction logic. This catches common input errors (`InputMismatchException`) and custom application errors (`EventNotFoundException`) propagated from the `EventManager` methods. Helper methods like `bookTicket`, `processWaitlist`, and `displayWaitlist` declare the `EventNotFoundException` they might throw, allowing `main` to handle it centrally. A generic `catch (Exception e)` is included in `main` as a fallback for unexpected errors.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** `Event` fields are private with public getters. `EventManager` fields (`eventList`, `waitlists`) are private, and operations are exposed through public methods.
 *     *   **Meaningful Names:** Variables (`eventId`, `customerName`, `bookedCount`), methods (`bookTicket`, `processWaitlist`, `findEventById`), and classes (`Event`, `EventManager`, `ExamSystem`) have names reflecting their purpose.
 *     *   **Comments and Documentation:** Javadoc-style comments explain the purpose of classes and key methods. Inline comments clarify specific logic points.
 *     *   **Input Validation:** `try-catch (InputMismatchException)` handles cases where the user enters non-integer input when a number is expected. Checks for empty customer names are included. Event ID validation is performed by the `findEventById` helper method in `EventManager`, which throws a custom exception.
 *     *   **Error Handling:** Specific exceptions (`InputMismatchException`, `EventNotFoundException`) are caught and handled with informative messages printed to `System.err`. A custom exception (`EventNotFoundException`) improves clarity. `IllegalStateException` is handled defensively during waitlist processing.
 *     *   **Clean Code Structure:** The logic is separated into distinct classes and methods, making the code modular and easier to understand and maintain. The `main` method focuses on the user interaction loop, delegating business logic to the `EventManager`.
 * 
 * The solution effectively integrates the required Java components into a practical scenario, demonstrating key concepts like collection usage, object interaction, input handling, and robust error management within a structured program. The waitlist feature specifically highlights the use of the `Queue` interface for managing items in a First-In, First-Out order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

// Custom Exception for when an event is not found
class EventNotFoundException extends Exception {
    public EventNotFoundException(String message) {
        super(message);
    }
}

// Represents an event with capacity and booking count
class Event {
    private int id;
    private String name;
    private int capacity;
    private int bookedCount;

    public Event(int id, String name, int capacity) {
        if (capacity < 0) {
             throw new IllegalArgumentException("Capacity cannot be negative.");
        }
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.bookedCount = 0;
    }

    // --- Getters ---
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBookedCount() {
        return bookedCount;
    }

    /**
     * Checks if the event has reached its capacity.
     * @return true if full, false otherwise.
     */
    public boolean isFull() {
        return bookedCount >= capacity;
    }

    /**
     * Attempts to book a ticket. Increments booked count if not full.
     * @throws IllegalStateException if the event is already full.
     */
    public void bookTicket() {
        if (!isFull()) {
            bookedCount++;
        } else {
            // This state should ideally be checked by the caller (EventManager)
            // but keeping this check provides defensive programming.
            throw new IllegalStateException("Event " + id + " is already full.");
        }
    }

    @Override
    public String toString() {
        return "Event [ID=" + id + ", Name=" + name + ", Capacity=" + capacity + ", Booked=" + bookedCount + "]";
    }
}

// Manages events and their associated waitlists
class EventManager {
    // Using List interface type for the collection of events
    private List<Event> eventList;
    // Using Map to link Event ID to its specific waitlist (Queue)
    private Map<Integer, Queue<String>> waitlists;

    public EventManager() {
        // Using ArrayList implementation for the event list
        eventList = new ArrayList<>();
        waitlists = new HashMap<>();

        // Initialize with some dummy events
        eventList.add(new Event(101, "Java Conference", 50));
        eventList.add(new Event(102, "AI Workshop", 30));
        eventList.add(new Event(103, "Web Dev Meetup", 100));
    }

    /**
     * Gets the list of all available events.
     * @return A List of Event objects.
     */
    public List<Event> getEventList() {
        return eventList; // Return the actual list of events
    }

    /**
     * Finds an event by its ID.
     * @param eventId The ID of the event to find.
     * @return The Event object if found.
     * @throws EventNotFoundException if no event with the given ID exists.
     */
    private Event findEventById(int eventId) throws EventNotFoundException {
        for (Event event : eventList) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        throw new EventNotFoundException("Event with ID " + eventId + " not found.");
    }

    /**
     * Attempts to book a ticket for an event.
     * If the event is full, the booking fails, and the method returns false.
     * @param eventId The ID of the event.
     * @return true if booking was successful, false if the event is full.
     * @throws EventNotFoundException if the event ID is invalid.
     */
    public boolean bookTicket(int eventId) throws EventNotFoundException {
        Event event = findEventById(eventId);
        if (!event.isFull()) {
            event.bookTicket();
            return true; // Booking successful
        } else {
            return false; // Event is full
        }
    }

    /**
     * Adds a customer to the waitlist for a specific event.
     * Creates the waitlist queue if it doesn't exist for this event.
     * @param eventId The ID of the event.
     * @param customerName The name of the customer.
     * @throws EventNotFoundException if the event ID is invalid.
     */
    public void joinWaitlist(int eventId, String customerName) throws EventNotFoundException {
        // Ensure the event exists before adding to a waitlist for it
        findEventById(eventId); // This throws EventNotFoundException if not found

        // Get or create the waitlist Queue for this event ID.
        // Using LinkedList as a common implementation of Queue.
        Queue<String> waitlist = waitlists.computeIfAbsent(eventId, k -> new LinkedList<>());

        // Add the customer name to the end of the waitlist
        waitlist.offer(customerName); // 'offer' is generally preferred for bounded queues, but good practice here too.
    }

    /**
     * Processes the waitlist for an event, booking tickets for waiting customers
     * as capacity becomes available until the event is full or the waitlist is empty.
     * @param eventId The ID of the event.
     * @return The number of tickets successfully booked from the waitlist during this process.
     * @throws EventNotFoundException if the event ID is invalid.
     */
    public int processWaitlist(int eventId) throws EventNotFoundException {
        Event event = findEventById(eventId);
        Queue<String> waitlist = waitlists.get(eventId);
        int ticketsBooked = 0;

        if (waitlist == null || waitlist.isEmpty()) {
            System.out.println("Waitlist for event " + eventId + " is empty. No tickets booked from waitlist.");
            return 0;
        }

        System.out.println("Processing waitlist for Event " + eventId + "...");

        // Process waitlist while the event is not full AND there are people waiting
        while (!event.isFull() && !waitlist.isEmpty()) {
            String customerName = waitlist.poll(); // Get and remove the head of the queue
            try {
                event.bookTicket(); // Book the ticket for the customer
                System.out.println("-> Successfully booked ticket for " + customerName + " from waitlist.");
                ticketsBooked++;
            } catch (IllegalStateException e) {
                // This catch block acts as a safeguard, though the while condition should prevent it.
                System.err.println("Error booking ticket for " + customerName + ": " + e.getMessage());
                // If booking failed unexpectedly, stop processing this waitlist
                System.err.println("Waitlist processing stopped for Event " + eventId + ".");
                break;
            }
        }

        if (ticketsBooked > 0) {
             System.out.println("Waitlist processing finished for Event " + eventId + ". Booked " + ticketsBooked + " ticket(s).");
        }

        if (!waitlist.isEmpty()) {
             System.out.println(waitlist.size() + " people remain on the waitlist for Event " + eventId + ".");
        } else if (ticketsBooked > 0) {
             System.out.println("Waitlist for Event " + eventId + " is now empty.");
        }


        return ticketsBooked;
    }

    /**
     * Gets the current waitlist for an event.
     * Returns a copy of the waitlist contents as a List.
     * @param eventId The ID of the event.
     * @return A List of customer names on the waitlist. Returns an empty list if no waitlist or empty.
     * @throws EventNotFoundException if the event ID is invalid.
     */
    public List<String> getWaitlist(int eventId) throws EventNotFoundException {
        // Ensure the event exists
        findEventById(eventId); // This throws EventNotFoundException if not found

        Queue<String> waitlist = waitlists.get(eventId);
        if (waitlist == null || waitlist.isEmpty()) {
            return new ArrayList<>(); // Return empty list if no waitlist exists or it's empty
        }
        // Return a new ArrayList containing all elements from the queue.
        // This provides a snapshot and prevents external modification of the actual queue.
        return new ArrayList<>(waitlist); // Using ArrayList implementation
    }
}

// Main class to run the application and handle user interaction
public class ExamSystem {

    // Static instances for easy access in static main and helper methods
    private static EventManager eventManager = new EventManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("--- Event Ticket Management System ---");

        boolean running = true;
        // Class-wide exception handling loop
        while (running) {
            printMenu();
            int choice = -1;

            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character left by nextInt()

                // Switch statement for flow control based on user input
                switch (choice) {
                    case 1:
                        listEvents();
                        break;
                    case 2:
                        bookTicket();
                        break;
                    case 3:
                        // Option 3 is kept for menu structure but redirects user
                        System.out.println("Please use option 2 (Book Ticket). If the event is full, you will be prompted to join the waitlist.");
                        break;
                    case 4:
                        processWaitlist();
                        break;
                    case 5:
                        displayWaitlist();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        break;
                    default:
                        // System.err for invalid choices
                        System.err.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException e) {
                // System.err for handling non-integer input where an integer is expected
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
            } catch (EventNotFoundException e) {
                 // Catching custom exception for user-friendly error message
                 System.err.println("Operation failed: " + e.getMessage());
            } catch (Exception e) {
                // Generic catch-all for any other unexpected runtime exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                e.printStackTrace(); // Print stack trace for debugging purposes
            }
            System.out.println(); // Add a blank line for better readability between operations
        }

        scanner.close(); // Close the scanner when the application exits
    }

    /**
     * Prints the main menu options to the console.
     * Uses System.out.
     */
    private static void printMenu() {
        System.out.println("Select an option:");
        System.out.println("1. List Events");
        System.out.println("2. Book Ticket");
        System.out.println("3. Join Waitlist (Use option 2)"); // Indicates how to join
        System.out.println("4. Process Waitlist");
        System.out.println("5. Display Waitlist");
        System.out.println("6. Exit");
    }

    /**
     * Displays all available events with their details.
     * Uses EventManager and System.out.
     */
    private static void listEvents() {
        System.out.println("\n--- Available Events ---");
        // Using List interface to iterate through events
        List<Event> events = eventManager.getEventList();
        if (events.isEmpty()) {
            System.out.println("No events available.");
        } else {
            for (Event event : events) {
                System.out.println(event); // Event's toString method is used here
            }
        }
        System.out.println("------------------------");
    }

    /**
     * Handles the process of booking a ticket.
     * Prompts user for Event ID, attempts booking, and offers waitlist if full.
     * Uses Scanner, EventManager, System.out, System.err, try-catch.
     * @throws EventNotFoundException Propagates this exception to be caught in main.
     */
    private static void bookTicket() throws EventNotFoundException {
        System.out.print("Enter Event ID to book a ticket: ");
        int eventId = -1;
        try {
            eventId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            boolean bookingSuccessful = eventManager.bookTicket(eventId);

            if (bookingSuccessful) {
                System.out.println("Successfully booked a ticket for Event " + eventId + ".");
            } else {
                // Event is full, offer waitlist
                System.out.println("Event " + eventId + " is currently full.");
                System.out.print("Would you like to join the waitlist? (yes/no): ");
                String response = scanner.nextLine().trim().toLowerCase();

                if (response.equals("yes")) {
                    System.out.print("Enter your name for the waitlist: ");
                    String customerName = scanner.nextLine().trim();
                    if (!customerName.isEmpty()) {
                         // Call EventManager method to add to waitlist (uses Queue internally)
                        eventManager.joinWaitlist(eventId, customerName);
                        System.out.println("Successfully added " + customerName + " to the waitlist for Event " + eventId + ".");
                    } else {
                         // System.err for validation error
                         System.err.println("Customer name cannot be empty. Did not join waitlist.");
                    }
                } else {
                    System.out.println("Booking failed. Did not join waitlist.");
                }
            }
        } catch (InputMismatchException e) {
            // System.err for input type mismatch
            System.err.println("Invalid input. Please enter a valid Event ID (a number).");
            scanner.nextLine(); // Consume invalid input
        }
        // EventNotFoundException is explicitly thrown by EventManager and caught in main's try-catch
    }

    /**
     * Handles processing the waitlist for a specific event.
     * Prompts user for Event ID and calls EventManager to process.
     * Uses Scanner, EventManager, System.out, System.err, try-catch.
     * @throws EventNotFoundException Propagates this exception to be caught in main.
     */
    private static void processWaitlist() throws EventNotFoundException {
        System.out.print("Enter Event ID to process waitlist: ");
        int eventId = -1;
        try {
            eventId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Call EventManager method to process the waitlist (uses Queue internally)
            int bookedCount = eventManager.processWaitlist(eventId);

            // Message about booked count is printed inside processWaitlist,
            // but we could add a summary here if needed.
            // if (bookedCount > 0) {
            //     System.out.println("Waitlist processing completed.");
            // }

        } catch (InputMismatchException e) {
            // System.err for input type mismatch
            System.err.println("Invalid input. Please enter a valid Event ID (a number).");
            scanner.nextLine(); // Consume invalid input
        }
        // EventNotFoundException is explicitly thrown by EventManager and caught in main's try-catch
    }

    /**
     * Displays the current waitlist for a specific event.
     * Prompts user for Event ID and displays the waitlist contents.
     * Uses Scanner, EventManager, System.out, System.err, try-catch.
     * @throws EventNotFoundException Propagates this exception to be caught in main.
     */
    private static void displayWaitlist() throws EventNotFoundException {
        System.out.print("Enter Event ID to display waitlist: ");
        int eventId = -1;
        try {
            eventId = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Call EventManager method to get the waitlist (returns List view of Queue)
            List<String> waitlist = eventManager.getWaitlist(eventId); // Using List interface

            System.out.println("\n--- Waitlist for Event " + eventId + " ---");
            if (waitlist.isEmpty()) {
                System.out.println("Waitlist is empty.");
            } else {
                // Iterate and print waitlist contents
                for (int i = 0; i < waitlist.size(); i++) {
                    System.out.println((i + 1) + ". " + waitlist.get(i));
                }
            }
            System.out.println("----------------------------");

        } catch (InputMismatchException e) {
            // System.err for input type mismatch
            System.err.println("Invalid input. Please enter a valid Event ID (a number).");
            scanner.nextLine(); // Consume invalid input
        }
        // EventNotFoundException is explicitly thrown by EventManager and caught in main's try-catch
    }
}
