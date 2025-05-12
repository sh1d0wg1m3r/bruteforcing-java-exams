/*
 * Exam Question #18
 * Generated on: 2025-05-11 21:37:39
 * 
 * QUESTION:
 * ## Advanced Java Programming Exam Task: Event Registration & Waiting List System
 * 
 * **Scenario:**
 * 
 * You are tasked with developing a simple command-line application to manage registrations for an event with limited capacity. Due to high demand, the system must handle a waiting list for attendees who register after the event reaches its maximum capacity. When spots become available (e.g., through processing the waiting list), attendees from the waiting list are automatically confirmed in the order they joined.
 * 
 * **Requirements:**
 * 
 * 1.  **Attendee Representation:** Create a class `Attendee` with private fields for `name` (String) and `status` (String, e.g., "Confirmed", "Waiting"). Include a constructor and public getter methods. Add a public method `setStatus(String status)` to change the attendee's status.
 * 2.  **Event Management Class:** Create a class `EventManager` to handle the event logic.
 *     *   It must have private fields:
 *         *   A `List` to store *all* attendees who attempted to register (both confirmed and waiting). Use the `List` interface type and initialize it with an `ArrayList`.
 *         *   A `Queue` to store attendees currently on the waiting list. Use the `Queue` interface type and initialize it with a suitable implementation (like `LinkedList`).
 *         *   An integer for `maxCapacity`.
 *         *   An integer to track the current number of `confirmedAttendees`.
 *     *   Include a constructor that takes the `maxCapacity`.
 *     *   Implement the following public methods:
 *         *   `registerAttendee(String name)`: Adds a new attendee. If `confirmedAttendees < maxCapacity`, the attendee is marked "Confirmed" and added to the main list and the confirmed count is incremented. Otherwise, the attendee is marked "Waiting" and added to the main list *and* the waiting list queue. Print the result of the registration (confirmed or waiting).
 *         *   `processWaitingList()`: Checks if there are available spots (`confirmedAttendees < maxCapacity`) and if the waiting list is not empty. If both are true, it takes the next attendee from the `waitingList` queue, changes their status to "Confirmed", adds them to the `confirmedAttendees` count, and prints a confirmation message. This process should repeat until either the capacity is reached or the waiting list is empty. If the waiting list is empty, print a message indicating so.
 *         *   `viewConfirmedAttendees()`: Prints the names of all attendees in the main list whose status is "Confirmed". Print a message if no attendees are confirmed.
 *         *   `viewWaitingList()`: Prints the names of all attendees currently in the waiting list queue. Print a message if the waiting list is empty.
 * 3.  **Main Application (`EventApp` class):**
 *     *   Use `Scanner` to get user input from the console.
 *     *   Implement a command-line menu using a `switch` statement allowing the user to:
 *         *   1. Register Attendee
 *         *   2. Process Waiting List
 *         *   3. View Confirmed Attendees
 *         *   4. View Waiting List
 *         *   5. Exit
 *     *   Initialize the `EventManager` with a reasonable `maxCapacity` (e.g., 5).
 *     *   Implement robust input handling:
 *         *   Use a `try-catch` block to handle `InputMismatchException` if the user enters non-integer input for the menu choice. Print an error message to `System.err` and consume the invalid input.
 *         *   Handle cases where the user enters an integer outside the valid menu range (1-5). Print an error message to `System.err`.
 *     *   Use `System.out` for all normal output (menu, prompts, success messages, lists).
 *     *   Use `System.err` for all error messages (invalid input, exceptions).
 *     *   The application should run in a loop until the user chooses to exit.
 * 
 * **Best Practices:**
 * 
 * *   Apply proper encapsulation (private fields, public methods).
 * *   Use meaningful variable and method names.
 * *   Add comments to explain complex parts or method functionality (basic Javadoc style is encouraged).
 * *   Ensure input validation and error handling are implemented as specified.
 * *   Structure your code logically into classes and methods.
 * 
 * **Expected Interaction (Example):**
 * 
 * ```
 * Event Management System
 * Max Capacity: 5
 * Choose an action:
 * 1. Register Attendee
 * 2. Process Waiting List
 * 3. View Confirmed Attendees
 * 4. View Waiting List
 * 5. Exit
 * Enter choice: 1
 * Enter attendee name: Alice
 * Alice registered. Status: Confirmed.
 * 
 * Enter choice: 1
 * Enter attendee name: Bob
 * Bob registered. Status: Confirmed.
 * 
 * Enter choice: 1
 * Enter attendee name: Charlie
 * Charlie registered. Status: Confirmed.
 * 
 * Enter choice: 1
 * Enter attendee name: David
 * David registered. Status: Confirmed.
 * 
 * Enter choice: 1
 * Enter attendee name: Eve
 * Eve registered. Status: Confirmed.
 * 
 * Enter choice: 1
 * Enter attendee name: Frank
 * Frank registered. Status: Waiting. Event is at max capacity.
 * 
 * Enter choice: 1
 * Enter attendee name: Grace
 * Grace registered. Status: Waiting. Event is at max capacity.
 * 
 * Enter choice: 3
 * Confirmed Attendees:
 * - Alice
 * - Bob
 * - Charlie
 * - David
 * - Eve
 * 
 * Enter choice: 4
 * Waiting List:
 * - Frank
 * - Grace
 * 
 * Enter choice: 2
 * Processing waiting list...
 * Frank has been confirmed from the waiting list.
 * Waiting list is now empty or capacity reached.
 * 
 * Enter choice: 3
 * Confirmed Attendees:
 * - Alice
 * - Bob
 * - Charlie
 * - David
 * - Eve
 * - Frank
 * 
 * Enter choice: 4
 * Waiting List:
 * - Grace (Still waiting as capacity is full)
 * 
 * Enter choice: 2
 * Processing waiting list...
 * Waiting list is empty or capacity reached. No attendees processed.
 * 
 * Enter choice: invalid
 * Error: Invalid input. Please enter a number.
 * 
 * Enter choice: 9
 * Error: Invalid choice. Please enter a number between 1 and 5.
 * 
 * Enter choice: 5
 * Exiting system.
 * ```
 * 
 * **Submission:**
 * 
 * Provide the complete Java code for the `Attendee`, `EventManager`, and `EventApp` classes.
 *
 * EXPLANATION:
 * This solution implements a simple event registration system demonstrating the required Java concepts.
 * 
 * 1.  **`Attendee` Class:** This class serves as a simple Plain Old Java Object (POJO) representing an attendee. It uses `private` fields (`name`, `status`) and `public` getter/setter methods (`getName`, `getStatus`, `setStatus`) to adhere to encapsulation principles.
 * 
 * 2.  **`EventManager` Class:** This is the core class managing the event logic.
 *     *   It uses a `List<Attendee> allRegistrations` declared with the `List` interface type but initialized with `new ArrayList<>()`. This demonstrates using the interface for flexibility while using a concrete implementation. This list holds *all* attendees who ever attempted to register, allowing us to view confirmed attendees by filtering this list.
 *     *   It uses a `Queue<Attendee> waitingList` declared with the `Queue` interface type and initialized with `new LinkedList<>()`. `LinkedList` is a common implementation of `Queue` that supports FIFO operations efficiently. This queue strictly holds attendees who are currently waiting.
 *     *   `maxCapacity` and `confirmedAttendeesCount` are private fields tracking the event's state.
 *     *   The `registerAttendee` method checks capacity and either confirms or adds the attendee to the waiting list queue, also adding all registrants to the `allRegistrations` list.
 *     *   The `processWaitingList` method uses a `while` loop to repeatedly `poll()` (get and remove) attendees from the `waitingList` queue as long as there is capacity and the queue is not empty. It updates their status and the confirmed count.
 *     *   `viewConfirmedAttendees` iterates through the `allRegistrations` list and prints attendees whose status is "Confirmed".
 *     *   `viewWaitingList` iterates through the `waitingList` queue (using a simple `for-each` loop which uses the queue's iterator, not removing elements) and prints attendee names.
 * 
 * 3.  **`EventApp` Class (Main Application):**
 *     *   This class contains the `main` method where execution begins.
 *     *   A `Scanner` is used to read user input from the console.
 *     *   An instance of `EventManager` is created.
 *     *   A `while` loop keeps the application running until the user chooses to exit.
 *     *   A `switch` statement is used to control the flow based on the user's menu choice, directing execution to the appropriate `EventManager` methods.
 *     *   **Input Validation and Exception Handling:**
 *         *   A `try-catch (InputMismatchException)` block surrounds `scanner.nextInt()`. If the user enters non-integer text, `InputMismatchException` is caught, an error message is printed to `System.err`, and `scanner.next()` is called to consume the invalid input token, preventing an infinite loop. The `continue` statement restarts the `while` loop. This demonstrates class-wide exception handling for input.
 *         *   A `finally` block is included (though not strictly necessary for cleanup in this simple case) to show understanding of its usage.
 *         *   The `default` case in the `switch` handles integer inputs that are outside the valid menu range (1-5), printing an error message to `System.err`.
 *     *   `System.out` is used for all standard information and prompts.
 *     *   `System.err` is explicitly used for printing error messages, distinguishing them from normal output.
 *     *   The `scanner.nextLine()` call after `scanner.nextInt()` is crucial to consume the newline character left in the input buffer, preventing issues with subsequent `scanner.nextLine()` calls when reading attendee names.
 *     *   The `scanner.close()` call ensures resources are released when the application exits.
 * 
 * This solution effectively integrates `Queue`, `List` (via `ArrayList`), `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch` within a practical scenario, following good object-oriented principles and error handling practices.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents an attendee for an event.
 */
class Attendee {
    private String name;
    private String status; // e.g., "Confirmed", "Waiting"

    /**
     * Constructs an Attendee object.
     * @param name The name of the attendee.
     * @param status The initial status of the attendee.
     */
    public Attendee(String name, String status) {
        this.name = name;
        this.status = status;
    }

    /**
     * Gets the name of the attendee.
     * @return The attendee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the status of the attendee.
     * @return The attendee's status ("Confirmed" or "Waiting").
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the attendee.
     * @param status The new status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "- " + name + " (" + status + ")";
    }
}

/**
 * Manages event registrations and the waiting list.
 */
class EventManager {
    private List<Attendee> allRegistrations; // Stores all attendees who registered
    private Queue<Attendee> waitingList; // Stores attendees currently waiting
    private int maxCapacity;
    private int confirmedAttendeesCount; // Tracks current confirmed count

    /**
     * Constructs an EventManager with a specified capacity.
     * @param maxCapacity The maximum number of confirmed attendees allowed.
     */
    public EventManager(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.allRegistrations = new ArrayList<>(); // Use ArrayList for the List interface
        this.waitingList = new LinkedList<>(); // Use LinkedList for the Queue interface
        this.confirmedAttendeesCount = 0;
    }

    /**
     * Registers a new attendee for the event.
     * @param name The name of the attendee.
     */
    public void registerAttendee(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.err.println("Error: Attendee name cannot be empty.");
            return;
        }

        Attendee newAttendee;
        if (confirmedAttendeesCount < maxCapacity) {
            newAttendee = new Attendee(name, "Confirmed");
            allRegistrations.add(newAttendee);
            confirmedAttendeesCount++;
            System.out.println(name + " registered. Status: Confirmed.");
        } else {
            newAttendee = new Attendee(name, "Waiting");
            allRegistrations.add(newAttendee); // Add to main list for tracking all registrations
            waitingList.offer(newAttendee); // Add to the waiting list queue
            System.out.println(name + " registered. Status: Waiting. Event is at max capacity.");
        }
    }

    /**
     * Processes the waiting list, confirming attendees if spots are available.
     */
    public void processWaitingList() {
        System.out.println("Processing waiting list...");
        if (waitingList.isEmpty()) {
            System.out.println("Waiting list is currently empty.");
            return;
        }

        int processedCount = 0;
        while (confirmedAttendeesCount < maxCapacity && !waitingList.isEmpty()) {
            Attendee nextAttendee = waitingList.poll(); // Get and remove the head of the queue
            if (nextAttendee != null) { // Should not be null if queue is not empty, but safe check
                nextAttendee.setStatus("Confirmed");
                confirmedAttendeesCount++;
                processedCount++;
                System.out.println(nextAttendee.getName() + " has been confirmed from the waiting list.");
            }
        }

        if (processedCount == 0) {
            System.out.println("No attendees could be processed from the waiting list (either full capacity or list was empty).");
        } else {
             System.out.println("Waiting list processing complete.");
        }
    }

    /**
     * Displays all confirmed attendees.
     */
    public void viewConfirmedAttendees() {
        System.out.println("Confirmed Attendees:");
        boolean found = false;
        // Iterate through all registrations to find confirmed ones
        for (Attendee attendee : allRegistrations) {
            if ("Confirmed".equals(attendee.getStatus())) {
                System.out.println("- " + attendee.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No attendees are currently confirmed.");
        }
    }

    /**
     * Displays all attendees currently in the waiting list queue.
     */
    public void viewWaitingList() {
        System.out.println("Waiting List:");
        if (waitingList.isEmpty()) {
            System.out.println("Waiting list is currently empty.");
        } else {
            // Iterate through the queue without removing elements (using peek/iterator or streaming)
            // Simple iteration is sufficient for display
            for (Attendee attendee : waitingList) {
                 System.out.println("- " + attendee.getName());
            }
        }
    }
}

/**
 * Main application class for the Event Management System.
 */
public class EventApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager(5); // Set max capacity to 5

        System.out.println("Event Management System");
        System.out.println("Max Capacity: " + eventManager.maxCapacity); // Accessing via getter if needed, but direct access fine here

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Register Attendee");
            System.out.println("2. Process Waiting List");
            System.out.println("3. View Confirmed Attendees");
            System.out.println("4. View Waiting List");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = -1; // Default invalid choice
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
                continue; // Skip the rest of the loop iteration
            } finally {
                 // No specific cleanup needed here, but demonstrating finally
            }

            // Consume the rest of the line after the integer input
            scanner.nextLine();

            // Use a switch statement for menu control
            switch (choice) {
                case 1:
                    System.out.print("Enter attendee name: ");
                    String name = scanner.nextLine();
                    eventManager.registerAttendee(name);
                    break;
                case 2:
                    eventManager.processWaitingList();
                    break;
                case 3:
                    eventManager.viewConfirmedAttendees();
                    break;
                case 4:
                    eventManager.viewWaitingList();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.err.println("Error: Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }
}
