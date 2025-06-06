/*
 * Exam Question #186
 * Generated on: 2025-05-11 22:28:00
 * Generated by: Account 2
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Event Ticket Queue Management System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified system for managing a waiting queue for a high-demand event with limited capacity. People can join a waiting list, and when tickets become available, the system processes the next person in the queue and allocates them a ticket until the event reaches its maximum capacity.
 * 
 * **Task:**
 * 
 * Implement a Java application that simulates this system. The application should provide a command-line interface for user interaction.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a **waiting list** of potential attendees using a `java.util.Queue`. Attendees join this queue first.
 *     *   Maintain a **list of confirmed attendees** (those who have successfully received a ticket) using a `java.util.List`, specifically implemented with a `java.util.ArrayList`.
 * 2.  **Event Capacity:** The event has a fixed maximum capacity (e.g., 10 attendees). Once this capacity is reached, no more attendees can be confirmed, even if the waiting queue is not empty.
 * 3.  **User Interface:**
 *     *   Use `java.util.Scanner` to read user commands from the console.
 *     *   Present a menu of options to the user:
 *         *   `1. Join Waiting Queue`: Prompt for the attendee's name and add them to the queue.
 *         *   `2. Process Next in Queue`: Take the next person from the waiting queue and add them to the confirmed attendees list, *if* the event capacity has not been reached.
 *         *   `3. View Status`: Display the current state: the number of people in the waiting queue, the names of people in the waiting queue (in order), the number of confirmed attendees, the names of confirmed attendees, and the remaining capacity.
 *         *   `4. Exit`: Terminate the application.
 *     *   Use a `switch` statement to handle the user's menu selection.
 * 4.  **Output:**
 *     *   Use `System.out` for all normal output, including the menu, status reports, and success messages.
 *     *   Use `System.err` for all error messages (e.g., invalid input, trying to process an empty queue, trying to process when capacity is full).
 * 5.  **Error Handling:**
 *     *   Implement robust input validation (e.g., handle non-integer input for menu choices).
 *     *   Implement class-wide or main loop exception handling using `try-catch` blocks to catch potential runtime errors (like `InputMismatchException` from `Scanner`).
 *     *   Handle specific operational errors:
 *         *   Attempting to process the queue when it's empty.
 *         *   Attempting to process the queue when the confirmed attendee list is already at maximum capacity.
 * 6.  **Code Structure & Best Practices:**
 *     *   Create an `Attendee` class with appropriate private fields (e.g., name) and public methods (getter, `toString`).
 *     *   Create an `EventManager` class to encapsulate the data structures (queue, list) and the logic for managing the event (joining, processing, viewing). This class should have private fields and public methods.
 *     *   Use meaningful variable and method names.
 *     *   Include comments where necessary to explain complex logic.
 *     *   Ensure proper encapsulation.
 * 
 * **Expected Output Examples:**
 * 
 * ```
 * --- Event Ticket Management System ---
 * 1. Join Waiting Queue
 * 2. Process Next in Queue
 * 3. View Status
 * 4. Exit
 * Enter your choice: 1
 * Enter attendee name: Alice
 * 
 * Alice joined the waiting queue.
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 1
 * Enter attendee name: Bob
 * 
 * Bob joined the waiting queue.
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 3
 * 
 * --- Event Status ---
 * Waiting Queue (2 people):
 * - Alice
 * - Bob
 * Confirmed Attendees (0/10 capacity):
 * Remaining Capacity: 10
 * --------------------
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 2
 * 
 * Processing next in queue...
 * Alice confirmed for a ticket!
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 3
 * 
 * --- Event Status ---
 * Waiting Queue (1 people):
 * - Bob
 * Confirmed Attendees (1/10 capacity):
 * - Alice
 * Remaining Capacity: 9
 * --------------------
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 2 (Repeat 9 more times until capacity is full)
 * 
 * Processing next in queue...
 * Bob confirmed for a ticket!
 * ... (more confirmations)
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 2
 * 
 * Processing next in queue...
 * Error: Maximum event capacity reached. Cannot process more attendees.
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 3
 * 
 * --- Event Status ---
 * Waiting Queue (X people):
 * ...
 * Confirmed Attendees (10/10 capacity):
 * ... (10 names)
 * Remaining Capacity: 0
 * --------------------
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 5 (Invalid input)
 * Error: Invalid choice. Please enter a number between 1 and 4.
 * 
 * --- Event Ticket Management System ---
 * ...
 * Enter your choice: 2 (Queue is empty)
 * 
 * Processing next in queue...
 * Error: Waiting queue is empty. No one to process.
 * ```
 * 
 * **Constraint:** Your solution must utilize all the specified Java components as required.
 * 
 * **Grading:** Your solution will be evaluated based on correctness, adherence to all requirements (including component usage and error handling), code structure, and best practices.
 *
 * EXPLANATION:
 * This solution implements the Event Ticket Management System as required, demonstrating the use of all specified Java components and following best practices.
 * 
 * 1.  **`Attendee` Class:** A simple Plain Old Java Object (POJO) representing a person wanting a ticket. It encapsulates the attendee's `name` with a private field and a public getter, adhering to encapsulation principles. The `toString()` method is overridden for easy printing.
 * 
 * 2.  **`EventManager` Class:** This is the core logic class.
 *     *   **Data Structures:** It holds a `Queue<Attendee>` named `waitingQueue` using `LinkedList` as the concrete implementation. It also holds a `List<Attendee>` named `confirmedAttendees` using `ArrayList` as the concrete implementation. The variable type is `List`, fulfilling that requirement. A `final int capacity` stores the maximum number of attendees allowed.
 *     *   **Encapsulation:** All data fields (`waitingQueue`, `confirmedAttendees`, `capacity`) are `private`. Access and modification are done through public methods (`joinQueue`, `processNextInQueue`, `viewStatus`).
 *     *   **`joinQueue(Attendee attendee)`:** Adds an attendee to the end of the `waitingQueue` using `offer()`. `offer()` is generally preferred over `add()` for queues as it signals failure with `false` in capacity-constrained queues, though `LinkedList` is not capacity-constrained.
 *     *   **`processNextInQueue()`:**
 *         *   Checks if the `waitingQueue` is empty using `isEmpty()`. If so, it prints an error to `System.err` and returns `false`.
 *         *   Checks if the `confirmedAttendees` list has reached the `capacity` using `size()`. If so, it prints an error to `System.err` and returns `false`.
 *         *   If both checks pass, it removes the next attendee from the *front* of the `waitingQueue` using `poll()`.
 *         *   It then adds this attendee to the `confirmedAttendees` `ArrayList` using `add()`.
 *         *   It prints a success message to `System.out` and returns `true`.
 *     *   **`viewStatus()`:** Iterates through both the `waitingQueue` and `confirmedAttendees` list to print their contents and sizes. It also calculates and prints the remaining capacity. Iterating the `Queue` with a for-each loop does *not* remove elements, which is the desired behavior for viewing.
 *     *   **Input Validation:** The constructor checks for valid capacity.
 * 
 * 3.  **`EventTicketSystem` Class:** This contains the `main` method and handles the user interaction loop.
 *     *   **`Scanner`:** An instance of `Scanner` is created to read input from `System.in`.
 *     *   **Main Loop and `switch`:** A `while(running)` loop keeps the application alive until the user chooses to exit. Inside the loop, `printMenu()` displays options, `scanner.nextInt()` reads the choice, and a `switch` statement directs the flow based on the input.
 *     *   **Input Validation and `try-catch` (Specific):** A nested `try-catch(InputMismatchException e)` block specifically handles the case where the user enters non-integer input for the menu choice. It prints an error to `System.err`, consumes the invalid input using `scanner.nextLine()`, and uses `continue` to restart the loop, prompting for input again.
 *     *   **`try-catch` (Class-wide/Main Loop):** The entire `while` loop and the initialization of `Scanner` and `EventManager` are wrapped in a larger `try-catch(Exception e)` block. This serves as a general catch-all for any unexpected exceptions that might occur during the application's runtime, printing an error to `System.err` and the stack trace for debugging.
 *     *   **`finally`:** A `finally` block ensures that the `scanner.close()` method is called when the `try` block is exited (either normally or due to an exception), releasing the system resource.
 *     *   **`System.out` and `System.err`:** Used as required throughout the `EventManager` and `EventTicketSystem` classes for normal output and error messages, respectively.
 *     *   **Meaningful Names:** Classes, variables, and methods are named descriptively (e.g., `waitingQueue`, `processNextInQueue`, `confirmedAttendees`, `EVENT_CAPACITY`).
 * 
 * This solution effectively combines the required data structures and control flow mechanisms to simulate the ticket management process, including handling edge cases like empty queues, full capacity, and invalid user input, while adhering to good programming practices.
 */

import java.util.Queue;
import java.util.LinkedList; // Common Queue implementation
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents an attendee
class Attendee {
    private String name;

    public Attendee(String name) {
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

// Manages the event queue and attendees
class EventManager {
    private Queue<Attendee> waitingQueue;
    private List<Attendee> confirmedAttendees; // Use List interface, implement with ArrayList
    private final int capacity;

    public EventManager(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.capacity = capacity;
        this.waitingQueue = new LinkedList<>(); // LinkedList is a common Queue implementation
        this.confirmedAttendees = new ArrayList<>(); // ArrayList implementation
    }

    /**
     * Adds an attendee to the waiting queue.
     * @param attendee The attendee to add.
     */
    public void joinQueue(Attendee attendee) {
        waitingQueue.offer(attendee); // offer is preferred over add for queues
        System.out.println("\n" + attendee.getName() + " joined the waiting queue.\n");
    }

    /**
     * Processes the next attendee in the queue and confirms them if capacity allows.
     * @return true if an attendee was successfully processed, false otherwise.
     */
    public boolean processNextInQueue() {
        System.out.println("\nProcessing next in queue...");

        if (waitingQueue.isEmpty()) {
            System.err.println("Error: Waiting queue is empty. No one to process.");
            return false;
        }

        if (confirmedAttendees.size() >= capacity) {
            System.err.println("Error: Maximum event capacity reached. Cannot process more attendees.");
            return false;
        }

        Attendee nextAttendee = waitingQueue.poll(); // Remove from queue
        if (nextAttendee != null) { // poll returns null if queue was empty (checked above, but good practice)
            confirmedAttendees.add(nextAttendee); // Add to confirmed list
            System.out.println(nextAttendee.getName() + " confirmed for a ticket!\n");
            return true;
        }
        return false; // Should not happen given the isEmpty check
    }

    /**
     * Displays the current status of the event queues and attendees.
     */
    public void viewStatus() {
        System.out.println("\n--- Event Status ---");

        System.out.println("Waiting Queue (" + waitingQueue.size() + " people):");
        if (waitingQueue.isEmpty()) {
            System.out.println("(empty)");
        } else {
            // Iterating over a Queue doesn't remove elements
            for (Attendee attendee : waitingQueue) {
                System.out.println("- " + attendee.getName());
            }
        }

        System.out.println("Confirmed Attendees (" + confirmedAttendees.size() + "/" + capacity + " capacity):");
        if (confirmedAttendees.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (Attendee attendee : confirmedAttendees) {
                System.out.println("- " + attendee.getName());
            }
        }

        System.out.println("Remaining Capacity: " + (capacity - confirmedAttendees.size()));
        System.out.println("--------------------\n");
    }
}

public class EventTicketSystem {

    private static final int EVENT_CAPACITY = 10; // Example capacity

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager(EVENT_CAPACITY);
        boolean running = true;

        // Class-wide exception handling for the main loop
        try {
            while (running) {
                printMenu();

                int choice = -1;
                try {
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                } catch (InputMismatchException e) {
                    System.err.println("Error: Invalid input. Please enter a number.");
                    scanner.nextLine(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop iteration
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter attendee name: ");
                        String name = scanner.nextLine();
                        if (name == null || name.trim().isEmpty()) {
                            System.err.println("Error: Attendee name cannot be empty.");
                        } else {
                            eventManager.joinQueue(new Attendee(name.trim()));
                        }
                        break;
                    case 2:
                        eventManager.processNextInQueue();
                        break;
                    case 3:
                        eventManager.viewStatus();
                        break;
                    case 4:
                        System.out.println("\nExiting Event Ticket System. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.err.println("Error: Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during execution
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(); // Print stack trace for debugging
        } finally {
            // Ensure scanner is closed
            scanner.close();
        }
    }

    private static void printMenu() {
        System.out.println("--- Event Ticket Management System ---");
        System.out.println("1. Join Waiting Queue");
        System.out.println("2. Process Next in Queue");
        System.out.println("3. View Status");
        System.out.println("4. Exit");
    }
}
