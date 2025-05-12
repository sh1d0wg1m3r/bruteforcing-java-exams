/*
 * Exam Question #5
 * Generated on: 2025-05-11 21:23:47
 * 
 * QUESTION:
 * ## Conference Workshop Management System
 * 
 * **Problem Description:**
 * 
 * You are tasked with building a command-line application to manage attendee registrations and waiting lists for workshops at a conference. Each workshop has a fixed capacity. When an attendee registers, they are added to the registered list if space is available. If the workshop is full, they are added to a waiting list. The system should also allow administrators to process the waiting list, moving attendees to the registered list as spots open up.
 * 
 * Your solution must be written in Java and demonstrate a strong understanding of core Java collections, control flow, input/output, and error handling.
 * 
 * **Requirements:**
 * 
 * 1.  **`Workshop` Class:**
 *     *   Create a class named `Workshop` with private fields: `name` (String), `capacity` (int), `registeredAttendees` (a `List` of Strings), and `waitingList` (a `Queue` of Strings).
 *     *   Include a public constructor `Workshop(String name, int capacity)` to initialize the workshop with its name and capacity. Initialize the collections appropriately.
 *     *   Implement a public method `String registerAttendee(String attendeeName)`:
 *         *   Validate that `attendeeName` is not null or empty.
 *         *   Check if the `attendeeName` is already present in either `registeredAttendees` or `waitingList`. If so, return an error message indicating the attendee is already registered or on the waiting list.
 *         *   If the workshop is not full (i.e., `registeredAttendees.size() < capacity`), add the `attendeeName` to `registeredAttendees` and return a success message indicating successful registration.
 *         *   If the workshop is full, add the `attendeeName` to the `waitingList` (using the `Queue`'s add/offer method) and return a message indicating the attendee was added to the waiting list.
 *     *   Implement a public method `List<String> processWaitingList()`:
 *         *   While there is capacity available in `registeredAttendees` and the `waitingList` is not empty, remove the next attendee from the `waitingList` (using the `Queue`'s poll method) and add them to `registeredAttendees`.
 *         *   Return a `List` containing the names of all attendees who were moved from the waiting list during this call.
 *     *   Include public getter methods for `name`, `registeredAttendees` (returning a `List<String>`), and `waitingList` (returning a `List<String>` representation of the queue).
 *     *   Include a public boolean method `isAttendeeRegisteredOrWaiting(String attendeeName)` to check if an attendee is already listed.
 * 
 * 2.  **Main Application Class (`ConferenceManager`):**
 *     *   Create a class with a `main` method.
 *     *   Inside `main`, create an instance of `ConferenceManager` and call its `run()` method.
 *     *   The `ConferenceManager` class should have a private `List<Workshop>` to store all workshops and a private `Scanner` for user input.
 *     *   Initialize the `List<Workshop>` with a few sample workshops (e.g., "Java Deep Dive" capacity 5, "Spring Boot Basics" capacity 3, "Frontend with React" capacity 4).
 *     *   Implement a `run()` method that contains the main application loop.
 *     *   Inside the loop, display a menu of options to the user:
 *         *   1. Register Attendee
 *         *   2. View Registered Attendees
 *         *   3. View Waiting List
 *         *   4. Process Waiting List
 *         *   5. Exit
 *     *   Use a `Scanner` to read the user's choice.
 *     *   Use a `switch` statement to handle the user's choice.
 *     *   For each option (1-4):
 *         *   Prompt the user for the necessary information (e.g., attendee name, workshop name).
 *         *   Find the requested `Workshop` object from the list of workshops. If the workshop is not found, print an error message to `System.err` and continue the loop.
 *         *   Call the appropriate method on the `Workshop` object (`registerAttendee`, `getRegisteredAttendees`, `getWaitingList`, `processWaitingList`).
 *         *   Display the results to `System.out` (success messages, lists of attendees, list of moved attendees).
 *         *   Display error messages (e.g., workshop not found, attendee already exists, invalid input) to `System.err`.
 *     *   For option 5, exit the application gracefully (close `Scanner`, exit program).
 *     *   Include a `try-catch` block around the main loop body to catch potential unexpected runtime exceptions and print an error message to `System.err`. Also, handle `NumberFormatException` specifically if the user enters non-numeric input for the menu choice.
 * 
 * 3.  **General Requirements & Best Practices:**
 *     *   Use `java.util.Queue`, `java.util.ArrayList`, and `java.util.List`.
 *     *   Use `java.util.Scanner` for input.
 *     *   Use a `switch` statement for menu navigation.
 *     *   Use `System.err` for all error output.
 *     *   Use `System.out` for all normal/successful output and prompts.
 *     *   Implement class-wide exception handling with `try-catch`.
 *     *   Employ proper encapsulation (private fields, public methods).
 *     *   Use meaningful names for classes, variables, and methods.
 *     *   Add appropriate comments and documentation (e.g., Javadoc).
 *     *   Perform basic input validation (e.g., non-empty names, valid workshop).
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, presenting a menu, accepting input, and printing output or errors as described above. Examples:
 * 
 * ```
 * --- Conference Workshop Menu ---
 * 1. Register Attendee
 * 2. View Registered Attendees
 * 3. View Waiting List
 * 4. Process Waiting List
 * 5. Exit
 * Enter your choice: 1
 * Enter attendee name: Alice
 * Enter workshop name: Java Deep Dive
 * Success: 'Alice' successfully registered for 'Java Deep Dive'.
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 1
 * Enter attendee name: Bob
 * Enter workshop name: Java Deep Dive
 * Success: 'Bob' successfully registered for 'Java Deep Dive'.
 * 
 * ... (register 3 more people for Java Deep Dive)
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 1
 * Enter attendee name: Charlie
 * Enter workshop name: Java Deep Dive
 * Waiting List: 'Java Deep Dive' is full. 'Charlie' added to waiting list.
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 1
 * Enter attendee name: Alice
 * Enter workshop name: Java Deep Dive
 * Error: Attendee 'Alice' is already registered or on the waiting list for 'Java Deep Dive'.
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 2
 * Enter workshop name: Java Deep Dive
 * Registered attendees for 'Java Deep Dive': [Alice, Bob, ..., LastRegistered]
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 3
 * Enter workshop name: Java Deep Dive
 * Waiting list for 'Java Deep Dive': [Charlie, ...]
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 4
 * Enter workshop name: Java Deep Dive
 * Processed waiting list for 'Java Deep Dive'. Moved: [Charlie]
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 2
 * Enter workshop name: Java Deep Dive
 * Registered attendees for 'Java Deep Dive': [Alice, Bob, ..., LastRegistered, Charlie]
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 6
 * Invalid choice. Please enter a number between 1 and 5.
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: abc
 * Invalid input. Please enter a number.
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 1
 * Enter attendee name: David
 * Enter workshop name: Nonexistent Workshop
 * Error: Workshop 'Nonexistent Workshop' not found!
 * 
 * --- Conference Workshop Menu ---
 * ...
 * Enter your choice: 5
 * Exiting Conference Workshop Manager. Goodbye!
 * ```
 *
 * EXPLANATION:
 * The solution implements a `ConferenceWorkshopManager` system as required, demonstrating the use of various Java concepts and best practices.
 * 
 * 1.  **`Workshop` Class:**
 *     *   **Encapsulation:** Private fields (`name`, `capacity`, `registeredAttendees`, `waitingList`) protect the internal state. Public methods provide controlled access and modification.
 *     *   **Collections:** `registeredAttendees` is an `ArrayList`, chosen for efficient access by index (though not heavily used here) and dynamic resizing. `waitingList` is a `Queue`, implemented by `LinkedList`, which is suitable for FIFO (First-In, First-Out) behavior required for a waiting list where the person waiting longest gets the next spot.
 *     *   **`registerAttendee` Method:** Handles the core logic of adding an attendee, checking for duplicates using `isAttendeeRegisteredOrWaiting`, and deciding whether to add to the registered list or the waiting list based on capacity. It returns a `String` message indicating the outcome, which is then interpreted by the `ConferenceManager`.
 *     *   **`processWaitingList` Method:** Implements the waiting list processing logic. It uses a `while` loop to continue moving attendees as long as there's capacity and people are waiting. `waitingList.poll()` correctly removes the head of the queue. It returns a `List` of names that were moved.
 *     *   **`get...` Methods:** Provide read-only access to the lists/queue by returning copies (`new ArrayList<>(...)`) to prevent external code from modifying the internal state directly.
 *     *   **`isAttendeeRegisteredOrWaiting`:** A helper method to check for duplicate entries across both lists.
 * 
 * 2.  **`ConferenceManager` Class:**
 *     *   **`main` Method:** The entry point that creates a `ConferenceManager` instance and starts the application loop via the `run()` method.
 *     *   **Collections:** Uses an `ArrayList` to hold the `Workshop` objects, declared using the `List` interface (`List<Workshop> workshops = new ArrayList<>();`). This demonstrates programming to the interface.
 *     *   **`Scanner`:** Used to read user input from the console. The `scanner.nextLine()` approach is used for reading menu choices and string inputs to avoid common issues with `nextInt()` leaving a newline character.
 *     *   **Menu and `switch`:** A clear menu is displayed, and a `switch` statement handles the user's integer choice, directing execution to specific handler methods (`handleRegisterAttendee`, etc.). This fulfills the requirement for using a `switch` for flow control.
 *     *   **Input Validation and `System.err`:**
 *         *   The `findWorkshop` method validates the input name and searches the list. If a workshop isn't found, an error message is printed to `System.err`.
 *         *   The `registerAttendee` method in `Workshop` returns error messages for empty names or duplicates, which are checked by `ConferenceManager` and printed to `System.err`.
 *         *   Invalid numeric input for the menu is caught by `NumberFormatException` and an error is printed to `System.err`.
 *         *   Invalid menu numbers (outside 1-5) fall into the `default` case of the `switch`, printing an error to `System.err`.
 *     *   **`System.out`:** All successful operations, prompts, the menu, and lists of attendees/waiting lists are printed to `System.out`.
 *     *   **`try-catch` Exception Handling:**
 *         *   A `try-catch (NumberFormatException e)` block specifically handles cases where the user enters non-numeric input for the menu choice.
 *         *   A general `try-catch (Exception e)` block wraps the main loop body (inside the `while`) to catch any other unexpected runtime exceptions, providing a basic level of class-wide error handling and preventing the program from crashing abruptly. Error details are printed to `System.err`.
 *     *   **`Optional`:** The `findWorkshop` method uses `Optional<Workshop>` to clearly indicate that the result might be absent, which is a modern Java feature for handling potential null values gracefully.
 *     *   **Resource Management:** The `Scanner` is closed when the program exits (case 5).
 * 
 * This solution effectively integrates the required Java components (`Queue`, `ArrayList`, `List`, `Scanner`, `switch`, `System.err`, `System.out`, `try-catch`) into a practical, well-structured program that follows best practices for encapsulation, naming, documentation, and error handling.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Optional; // Using Optional for findWorkshop

/**
 * Represents a workshop with limited capacity, managing registered attendees and a waiting list.
 */
class Workshop {
    private String name;
    private int capacity;
    private List<String> registeredAttendees; // Using ArrayList for registered attendees
    private Queue<String> waitingList; // Using LinkedList as a Queue for the waiting list

    /**
     * Constructs a new Workshop.
     *
     * @param name     The name of the workshop.
     * @param capacity The maximum number of registered attendees.
     */
    public Workshop(String name, int capacity) {
        // Basic validation for name and capacity
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Workshop name cannot be empty.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Workshop capacity must be positive.");
        }
        this.name = name.trim();
        this.capacity = capacity;
        this.registeredAttendees = new ArrayList<>();
        this.waitingList = new LinkedList<>();
    }

    /**
     * Registers an attendee for the workshop.
     * If the workshop is full, adds the attendee to the waiting list.
     *
     * @param attendeeName The name of the attendee.
     * @return A status message (success registration, success waiting list, or already exists/invalid name).
     */
    public String registerAttendee(String attendeeName) {
        // Input validation: basic check for empty name
        if (attendeeName == null || attendeeName.trim().isEmpty()) {
            return "Error: Attendee name cannot be empty."; // Indicate error status
        }
        attendeeName = attendeeName.trim(); // Trim whitespace

        // Check if attendee is already registered or on the waiting list
        if (isAttendeeRegisteredOrWaiting(attendeeName)) {
            return "Error: Attendee '" + attendeeName + "' is already registered or on the waiting list for '" + name + "'."; // Indicate error status
        }

        // Check if there is capacity
        if (registeredAttendees.size() < capacity) {
            registeredAttendees.add(attendeeName);
            return "Success: '" + attendeeName + "' successfully registered for '" + name + "'."; // Indicate success status
        } else {
            // Workshop is full, add to waiting list
            waitingList.offer(attendeeName); // offer is generally preferred over add for queues
            return "Waiting List: '" + name + "' is full. '" + attendeeName + "' added to waiting list."; // Indicate waiting list status
        }
    }

    /**
     * Checks if an attendee is already in the registered list or the waiting list.
     *
     * @param attendeeName The name of the attendee.
     * @return true if the attendee is registered or waiting, false otherwise.
     */
    public boolean isAttendeeRegisteredOrWaiting(String attendeeName) {
        // Case-insensitive check might be better in a real system, but strict match is fine for exam
        return registeredAttendees.contains(attendeeName) || waitingList.contains(attendeeName);
    }

    /**
     * Processes the waiting list, moving attendees to the registered list if capacity is available.
     *
     * @return A List of attendee names that were moved from the waiting list.
     */
    public List<String> processWaitingList() {
        List<String> movedAttendees = new ArrayList<>();
        // While there is capacity and the waiting list is not empty
        while (registeredAttendees.size() < capacity && !waitingList.isEmpty()) {
            String attendee = waitingList.poll(); // Get and remove the head of the queue
            if (attendee != null) { // poll returns null if queue is empty, although loop condition checks !waitingList.isEmpty()
                registeredAttendees.add(attendee);
                movedAttendees.add(attendee);
            }
        }
        return movedAttendees;
    }

    /**
     * Gets the name of the workshop.
     * @return The workshop name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of registered attendees.
     * @return A List of registered attendee names (a copy to prevent external modification).
     */
    public List<String> getRegisteredAttendees() {
        // Return a copy to prevent external modification of the internal list
        return new ArrayList<>(registeredAttendees);
    }

    /**
     * Gets the waiting list.
     * @return A List representation of the waiting list (Queue) (a copy).
     */
    public List<String> getWaitingList() {
        // Return a copy to prevent external modification of the internal queue
        return new ArrayList<>(waitingList);
    }

    /**
     * Checks if the workshop is full.
     * @return true if registered attendees count meets or exceeds capacity, false otherwise.
     */
    public boolean isFull() {
        return registeredAttendees.size() >= capacity;
    }

    @Override
    public String toString() {
        return "'" + name + "' (Capacity: " + capacity + ", Registered: " + registeredAttendees.size() + ", Waiting: " + waitingList.size() + ")";
    }
}

/**
 * Manages workshops and handles user interactions for registration and waiting list processing.
 */
public class ConferenceManager {

    private List<Workshop> workshops; // Using List interface, implemented by ArrayList
    private Scanner scanner;

    /**
     * Constructs a new ConferenceManager and initializes sample workshops.
     */
    public ConferenceManager() {
        workshops = new ArrayList<>(); // Using ArrayList for the list of workshops
        // Initialize with sample workshops
        try {
            workshops.add(new Workshop("Java Deep Dive", 5));
            workshops.add(new Workshop("Spring Boot Basics", 3));
            workshops.add(new Workshop("Frontend with React", 4));
        } catch (IllegalArgumentException e) {
             // Handle potential errors during workshop initialization (e.g., invalid capacity)
             System.err.println("Error initializing workshops: " + e.getMessage());
             // Depending on requirements, might exit or continue with available workshops
        }


        scanner = new Scanner(System.in);
    }

    /**
     * Finds a workshop by its name (case-insensitive).
     *
     * @param name The name of the workshop to find.
     * @return An Optional containing the Workshop if found, otherwise empty.
     */
    private Optional<Workshop> findWorkshop(String name) {
        // Basic validation for workshop name
        if (name == null || name.trim().isEmpty()) {
            return Optional.empty();
        }
        String trimmedName = name.trim();
        // Iterate through the list of workshops
        for (Workshop workshop : workshops) {
            if (workshop.getName().equalsIgnoreCase(trimmedName)) { // Case-insensitive comparison
                return Optional.of(workshop); // Found the workshop
            }
        }
        return Optional.empty(); // Workshop not found
    }

    /**
     * Displays the main menu options.
     */
    private void displayMenu() {
        System.out.println("\n--- Conference Workshop Menu ---");
        System.out.println("1. Register Attendee");
        System.out.println("2. View Registered Attendees");
        System.out.println("3. View Waiting List");
        System.out.println("4. Process Waiting List");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles the registration process based on user input.
     */
    private void handleRegisterAttendee() {
        System.out.print("Enter attendee name: ");
        String attendeeName = scanner.nextLine(); // Read full line for name

        System.out.print("Enter workshop name: ");
        String workshopName = scanner.nextLine(); // Read full line for workshop name

        Optional<Workshop> workshopOpt = findWorkshop(workshopName);

        if (workshopOpt.isPresent()) {
            Workshop workshop = workshopOpt.get();
            String result = workshop.registerAttendee(attendeeName); // Call method on Workshop object

            // Check the result string to determine output stream based on content
            if (result.startsWith("Error:")) {
                System.err.println(result); // Use System.err for error messages
            } else if (result.startsWith("Waiting List:")) {
                System.out.println(result); // Use System.out for waiting list messages
            } else if (result.startsWith("Success:")) {
                 System.out.println(result); // Use System.out for success messages
            } else {
                 // Handle unexpected results from registerAttendee if any
                 System.err.println("Unexpected result from registration: " + result);
            }

        } else {
            System.err.println("Error: Workshop '" + workshopName + "' not found!"); // Use System.err for errors
        }
    }

    /**
     * Handles viewing registered attendees for a workshop.
     */
    private void handleViewRegisteredAttendees() {
        System.out.print("Enter workshop name: ");
        String workshopName = scanner.nextLine();

        Optional<Workshop> workshopOpt = findWorkshop(workshopName);

        if (workshopOpt.isPresent()) {
            Workshop workshop = workshopOpt.get();
            List<String> registered = workshop.getRegisteredAttendees(); // Get the list
            System.out.println("Registered attendees for '" + workshop.getName() + "': " + registered); // Use System.out
        } else {
            System.err.println("Error: Workshop '" + workshopName + "' not found!"); // Use System.err
        }
    }

    /**
     * Handles viewing the waiting list for a workshop.
     */
    private void handleViewWaitingList() {
        System.out.print("Enter workshop name: ");
        String workshopName = scanner.nextLine();

        Optional<Workshop> workshopOpt = findWorkshop(workshopName);

        if (workshopOpt.isPresent()) {
            Workshop workshop = workshopOpt.get();
            List<String> waiting = workshop.getWaitingList(); // Get the list representation of the queue
            System.out.println("Waiting list for '" + workshop.getName() + "': " + waiting); // Use System.out
        } else {
            System.err.println("Error: Workshop '" + workshopName + "' not found!"); // Use System.err
        }
    }

    /**
     * Handles processing the waiting list for a workshop.
     */
    private void handleProcessWaitingList() {
        System.out.print("Enter workshop name: ");
        String workshopName = scanner.nextLine();

        Optional<Workshop> workshopOpt = findWorkshop(workshopName);

        if (workshopOpt.isPresent()) {
            Workshop workshop = workshopOpt.get();
            List<String> moved = workshop.processWaitingList(); // Process the waiting list

            if (moved.isEmpty()) {
                System.out.println("No attendees were moved from the waiting list for '" + workshop.getName() + "'."); // Use System.out
            } else {
                System.out.println("Processed waiting list for '" + workshop.getName() + "'. Moved: " + moved); // Use System.out
            }
        } else {
            System.err.println("Error: Workshop '" + workshopName + "' not found!"); // Use System.err
        }
    }

    /**
     * Runs the main application loop, handling user input and menu navigation.
     */
    public void run() {
        int choice = 0;
        // Main loop continues until the user chooses to exit (choice 5)
        while (choice != 5) {
            displayMenu(); // Show menu

            try {
                // Read the user's choice as a line first to handle non-integer input gracefully
                String choiceStr = scanner.nextLine();
                // Attempt to parse the integer choice
                choice = Integer.parseInt(choiceStr);

                // Use switch statement for flow control based on user choice
                switch (choice) {
                    case 1:
                        handleRegisterAttendee(); // Call method to handle registration
                        break;
                    case 2:
                        handleViewRegisteredAttendees(); // Call method to view registered attendees
                        break;
                    case 3:
                        handleViewWaitingList(); // Call method to view waiting list
                        break;
                    case 4:
                        handleProcessWaitingList(); // Call method to process waiting list
                        break;
                    case 5:
                        System.out.println("Exiting Conference Workshop Manager. Goodbye!"); // Exit message
                        break;
                    default:
                        // Handle invalid menu numbers
                        System.err.println("Invalid choice. Please enter a number between 1 and 5."); // Use System.err
                        break; // Continue loop
                }
            } catch (NumberFormatException e) {
                 // Catch specific exception if user input is not a valid integer
                 System.err.println("Invalid input. Please enter a number."); // Use System.err
                 choice = 0; // Reset choice to 0 to ensure the loop continues and menu is shown again
            }
            catch (Exception e) {
                // Class-wide exception handling for any other unexpected runtime errors
                System.err.println("An unexpected error occurred: " + e.getMessage()); // Use System.err
                // e.printStackTrace(); // Uncomment for debugging if needed
                choice = 0; // Reset choice to continue loop
            }
        }
        scanner.close(); // Close the scanner resource when the application exits
    }

    /**
     * Main method to start the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ConferenceManager manager = new ConferenceManager();
        manager.run(); // Start the application loop
    }
}
