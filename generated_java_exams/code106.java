/*
 * Exam Question #106
 * Generated on: 2025-05-11 22:15:12
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Event Attendee Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with developing a console-based Event Attendee Management System. This system will simulate the flow of attendees at an event venue. Attendees will first join a waiting line to enter the venue and, upon being admitted, will be added to a list of people currently inside. The system must also handle attendees leaving the venue.
 * 
 * Your Java program must implement the following functionalities via a command-line interface:
 * 
 * 1.  **Add Attendee to Queue:** Prompt the user for an attendee's name and add them to the waiting queue.
 * 2.  **Admit Next Attendee:** Take the attendee at the front of the waiting queue, remove them from the queue, and add them to the list of attendees currently inside the venue.
 * 3.  **Record Attendee Departure:** Prompt the user for an attendee's name and remove them from the list of attendees currently inside the venue.
 * 4.  **View Waiting Queue:** Display the names of all attendees currently in the waiting queue, in order.
 * 5.  **View Present Attendees:** Display the names of all attendees currently inside the venue.
 * 6.  **Exit:** Terminate the application.
 * 
 * **Technical Requirements:**
 * 
 * Your solution must demonstrate proficiency in fundamental and intermediate Java concepts by incorporating **ALL** of the following elements:
 * 
 * *   Use `java.util.Queue` to represent the waiting line. You may choose an appropriate concrete implementation (e.g., `LinkedList`).
 * *   Use `java.util.ArrayList` as the concrete implementation for the list of attendees currently inside the venue.
 * *   Declare the variable holding the list of present attendees using the `java.util.List` interface type.
 * *   Use `java.util.Scanner` to read user input from the console for menu choices and attendee names.
 * *   Utilize a `switch` statement to control the program flow based on the user's menu selection.
 * *   Print error messages (e.g., invalid input, attempting to admit from an empty queue, attempting to remove a non-existent attendee) to `System.err`.
 * *   Print normal output (e.g., menu, prompts, success messages, list contents) to `System.out`.
 * *   Implement class-wide exception handling using `try-catch` blocks to manage potential runtime errors, such as invalid input formats (e.g., non-integer input for menu options). The main interaction loop should be covered.
 * 
 * **Best Practices:**
 * 
 * *   Design your solution using a class (e.g., `EventManager`) that encapsulates the data structures (queue and list) and the operations.
 * *   Ensure proper encapsulation by making data fields `private` and providing `public` methods for interacting with the system.
 * *   Use meaningful names for variables, methods, and classes.
 * *   Include appropriate comments and basic documentation (e.g., Javadoc) to explain the purpose of classes and key methods.
 * *   Implement input validation where necessary (e.g., checking for empty attendee names, checking if the queue is empty before admitting, checking if an attendee is present before recording departure).
 * *   Provide clear and informative error messages.
 * *   Structure your code cleanly.
 * 
 * **Expected Output:**
 * 
 * The program should display a menu, accept user input, perform the requested action, and provide feedback (success message or error) before showing the menu again. The output should clearly distinguish between normal output (`System.out`) and errors (`System.err`). An example interaction flow is shown in the problem description above.
 * 
 * **Evaluation Criteria:**
 * 
 * *   Correct implementation of all required functionalities.
 * *   Proper usage of `Queue`, `List`, `ArrayList`, `Scanner`, `switch`, `System.err`, `System.out`, and `try-catch`.
 * *   Adherence to best practices (encapsulation, naming, comments, validation, error handling).
 * *   Clean and readable code structure.
 * *   Correct state management between the queue and the list.
 * 
 * **Note:** You are expected to write a single Java file containing all necessary classes (if any besides the main execution class) and the main method to run the application.
 *
 * EXPLANATION:
 * This solution implements the Event Attendee Management System using the required Java components and best practices.
 * 
 * 1.  **Class Structure and Encapsulation:** The core logic is encapsulated within the `EventManagementSystem` class. The data structures (`waitingQueue` and `presentAttendees`) and the `Scanner` are declared as `private` fields, ensuring that their state can only be modified through the class's public or private methods. This promotes data integrity and modularity.
 * 
 * 2.  **Data Structures (`Queue`, `List`, `ArrayList`):**
 *     *   `waitingQueue` is declared as `Queue<String>` and initialized with `new LinkedList<>()`. `LinkedList` is a common implementation of `Queue` that efficiently supports adding to the end (`offer`) and removing from the front (`poll`), which are the primary queue operations needed for the waiting line.
 *     *   `presentAttendees` is declared using the `List<String>` interface type but initialized with `new ArrayList<>()`. This demonstrates coding to an interface, a key best practice, while using `ArrayList` for its efficient element access and removal by object (`remove(Object)`).
 *     *   String is used to represent attendee names.
 * 
 * 3.  **User Input (`Scanner`):** A `Scanner` object is used to read input from `System.in`. `scanner.nextInt()` is used for the menu choice, and `scanner.nextLine()` is used for reading attendee names. The `scanner.nextLine()` call after `scanner.nextInt()` is crucial to consume the leftover newline character, preventing issues in subsequent `nextLine()` calls.
 * 
 * 4.  **Control Flow (`switch`):** A `switch` statement in the `run()` method efficiently directs the program flow based on the user's integer input for the menu choice, mapping each choice to a specific method call.
 * 
 * 5.  **Output Streams (`System.out`, `System.err`):**
 *     *   `System.out.println()` and `System.out.print()` are used for all normal interactions, including displaying the menu, prompts, success messages, and the contents of the queue and list.
 *     *   `System.err.println()` is used specifically for printing error messages, adhering to the requirement to use the standard error stream for errors.
 * 
 * 6.  **Exception Handling (`try-catch`):**
 *     *   A `try-catch` block is placed around the core input reading and processing logic within the `run()` method. This block specifically catches `InputMismatchException`, which occurs if the user enters non-integer input when an integer is expected (for the menu choice). The `catch` block prints an informative error to `System.err` and consumes the invalid input using `scanner.nextLine()` to prevent an infinite loop.
 *     *   A broader `catch (Exception e)` is included around the entire `while` loop in `run()` as a class-wide handler for any other unexpected exceptions that might occur during execution, printing a generic error message to `System.err`.
 *     *   A `finally` block ensures that the `Scanner` resource is closed properly when the application exits, regardless of whether an exception occurred.
 * 
 * 7.  **Input Validation and Error Handling Logic:**
 *     *   In `addAttendeeToQueue` and `recordDeparture`, input validation checks if the entered name is empty using `name.isEmpty()`. An error is printed to `System.err` if it is.
 *     *   In `admitNextAttendee`, it checks if the `waitingQueue` is empty using `waitingQueue.isEmpty()` before attempting to poll. An error is printed to `System.err` if the queue is empty.
 *     *   In `recordDeparture`, it attempts to remove the attendee name from the `presentAttendees` list using `presentAttendees.remove(name)`. This method returns `true` if the element was found and removed, and `false` otherwise. The boolean return value is used to determine whether to print a success message to `System.out` or a "not found" error message to `System.err`.
 *     *   The `default` case in the `switch` statement handles invalid menu numbers, printing an error to `System.err`.
 * 
 * 8.  **Best Practices Implementation:**
 *     *   Methods like `addAttendeeToQueue`, `admitNextAttendee`, `recordDeparture`, etc., clearly define the operations.
 *     *   Private helper methods like `printMenu` keep the main `run` method cleaner.
 *     *   Variable names (`waitingQueue`, `presentAttendees`, `nextAttendee`, `choice`, etc.) are descriptive.
 *     *   Basic Javadoc comments explain the purpose of the class and key public methods.
 * 
 * This solution effectively integrates all the required Java components and demonstrates robust handling of user input, state transitions between different data structures, and error conditions within a practical scenario.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * A simple console-based Event Attendee Management System.
 * Manages attendees waiting in a queue and those currently inside the venue.
 */
public class EventManagementSystem {

    // Private fields encapsulating the system's state
    private Queue<String> waitingQueue; // Represents the waiting line
    private List<String> presentAttendees; // Represents attendees inside the venue
    private Scanner scanner; // For reading user input

    /**
     * Constructs a new EventManagementSystem, initializing the data structures and scanner.
     */
    public EventManagementSystem() {
        // Using LinkedList as the concrete implementation for the Queue
        this.waitingQueue = new LinkedList<>();
        // Using ArrayList as the concrete implementation for the List
        this.presentAttendees = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the main application loop, presenting the menu and handling user input.
     * Includes class-wide exception handling for the main interaction loop.
     */
    public void run() {
        int choice = -1;

        // Class-wide try-catch block wrapping the main application loop
        try {
            while (choice != 6) {
                printMenu();
                System.out.print("Enter your choice: ");

                try {
                    // Read the integer choice
                    choice = scanner.nextInt();
                    // Consume the leftover newline character after nextInt()
                    scanner.nextLine();

                    // Use a switch statement to handle different menu options
                    switch (choice) {
                        case 1:
                            addAttendeeToQueue();
                            break;
                        case 2:
                            admitNextAttendee();
                            break;
                        case 3:
                            recordDeparture();
                            break;
                        case 4:
                            displayWaitingQueue();
                            break;
                        case 5:
                            displayPresentAttendees();
                            break;
                        case 6:
                            System.out.println("Exiting system. Goodbye!");
                            break;
                        default:
                            // Handle invalid menu choices
                            System.err.println("Error: Invalid choice. Please enter a number between 1 and 6.");
                    }
                } catch (InputMismatchException e) {
                    // Handle non-integer input for the menu choice
                    System.err.println("Error: Invalid input. Please enter a number.");
                    // Consume the invalid input to prevent an infinite loop
                    scanner.nextLine();
                    choice = -1; // Reset choice to ensure the loop continues
                }
                System.out.println(); // Add a newline for better separation between actions
            }
        } catch (Exception e) {
            // Catch any other unexpected exceptions that might occur
            System.err.println("An unexpected error occurred: " + e.getMessage());
            // Optional: e.printStackTrace(); // Uncomment for detailed debugging
        } finally {
            // Ensure the scanner is closed when the program terminates
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    /**
     * Prints the main menu options to standard output.
     */
    private void printMenu() {
        System.out.println("--- Event Management Menu ---");
        System.out.println("1. Add Attendee to Queue");
        System.out.println("2. Admit Next Attendee");
        System.out.println("3. Record Attendee Departure");
        System.out.println("4. View Waiting Queue");
        System.out.println("5. View Present Attendees");
        System.out.println("6. Exit");
        System.out.println("-----------------------------");
    }

    /**
     * Prompts the user for an attendee name and adds it to the waiting queue.
     * Includes input validation for the name.
     */
    private void addAttendeeToQueue() {
        System.out.print("Enter attendee name to add to queue: ");
        String name = scanner.nextLine().trim(); // Read the full line and trim whitespace

        // Input validation: check if name is empty
        if (name.isEmpty()) {
            System.err.println("Error: Attendee name cannot be empty.");
        } else {
            // Add the name to the end of the waiting queue
            waitingQueue.offer(name); // offer() is generally preferred over add() for queues
            System.out.println("'" + name + "' added to waiting queue.");
        }
    }

    /**
     * Admits the next attendee from the waiting queue to the list of present attendees.
     * Removes the attendee from the queue and adds them to the list.
     * Handles the case where the waiting queue is empty.
     */
    private void admitNextAttendee() {
        // Check if the waiting queue is empty before attempting to admit
        if (waitingQueue.isEmpty()) {
            System.err.println("Error: Waiting queue is empty. No one to admit.");
        } else {
            // Retrieve and remove the head of the queue
            String nextAttendee = waitingQueue.poll();
            // Add the admitted attendee to the list of present attendees
            presentAttendees.add(nextAttendee);
            System.out.println("'" + nextAttendee + "' admitted to the venue.");
        }
    }

    /**
     * Prompts the user for an attendee name and removes them from the list
     * of present attendees, simulating departure.
     * Handles the case where the attendee is not found in the list.
     * Includes input validation for the name.
     */
    private void recordDeparture() {
        System.out.print("Enter attendee name who is leaving: ");
        String name = scanner.nextLine().trim(); // Read the full line and trim whitespace

        // Input validation: check if name is empty
        if (name.isEmpty()) {
            System.err.println("Error: Attendee name cannot be empty.");
            return; // Exit the method if name is empty
        }

        // Attempt to remove the attendee by name from the list
        boolean removed = presentAttendees.remove(name);

        // Check if the removal was successful
        if (removed) {
            System.out.println("'" + name + "' has left the venue.");
        } else {
            // Handle the case where the attendee was not found in the list
            System.err.println("Error: Attendee '" + name + "' not found inside the venue.");
        }
    }

    /**
     * Displays the current contents of the waiting queue to standard output.
     */
    private void displayWaitingQueue() {
        System.out.println("--- Waiting Queue (" + waitingQueue.size() + " attendees) ---");
        if (waitingQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            // Print the queue contents. LinkedList's toString provides a readable format.
            System.out.println(waitingQueue);
            // Alternatively, iterate through the queue using an enhanced for loop
            // (which uses an iterator internally and does not remove elements):
            // for (String attendee : waitingQueue) {
            //     System.out.println("- " + attendee);
            // }
        }
        System.out.println("-----------------------------");
    }

    /**
     * Displays the current contents of the list of present attendees to standard output.
     */
    private void displayPresentAttendees() {
        System.out.println("--- Present Attendees (" + presentAttendees.size() + " attendees) ---");
        if (presentAttendees.isEmpty()) {
            System.out.println("No attendees currently inside.");
        } else {
            // Print the list contents. ArrayList's toString provides a readable format.
            System.out.println(presentAttendees);
            // Alternatively, iterate through the list:
            // for (String attendee : presentAttendees) {
            //     System.out.println("- " + attendee);
            // }
        }
        System.out.println("-----------------------------");
    }

    /**
     * The main method to start the Event Management System application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        EventManagementSystem system = new EventManagementSystem();
        system.run(); // Start the main application loop
    }
}
