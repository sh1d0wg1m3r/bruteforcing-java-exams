/*
 * Exam Question #238
 * Generated on: 2025-05-11 22:37:21
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Advanced Exam Task: Conference Workshop Registration System
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified system to manage registrations for workshops at a conference. The conference has several workshops, each with a limited capacity. Attendees can register for a workshop. If a workshop is full, they can be added to a waiting list. The system should allow users to register for workshops and view the current status of all workshops, including registered attendees and those on the waiting list.
 * 
 * **Requirements:**
 * 
 * Implement a Java console application that fulfills the following:
 * 
 * 1.  **Workshop Management:**
 *     *   Represent workshops using a `Workshop` class. Each workshop should have:
 *         *   A unique ID (integer).
 *         *   A name (String).
 *         *   A maximum capacity (integer).
 *         *   A list of currently registered attendees.
 *         *   A queue of attendees on the waiting list.
 *     *   The system should manage a collection of `Workshop` objects. Pre-populate this collection with at least 3 sample workshops.
 * 
 * 2.  **Attendee Management:**
 *     *   Represent attendees using an `Attendee` class (a simple class with just a name is sufficient).
 * 
 * 3.  **User Interface:**
 *     *   Provide a text-based menu for the user with the following options:
 *         *   `1. Register for Workshop`
 *         *   `2. View All Workshop Status`
 *         *   `3. Exit`
 *     *   Use `Scanner` to read user input (menu choice, attendee name, workshop ID).
 * 
 * 4.  **Functionality:**
 *     *   **Register:**
 *         *   Prompt the user for their name and the ID of the workshop they want to register for.
 *         *   Find the specified workshop.
 *         *   If the workshop exists and has capacity, add the attendee to the registered list.
 *         *   If the workshop exists but is full, add the attendee to the waiting list.
 *         *   Handle cases where the workshop ID is invalid or the attendee is already registered (either registered or on the waiting list) for that specific workshop.
 *         *   Provide appropriate feedback to the user (`System.out` for success/info, `System.err` for errors).
 *     *   **View Status:**
 *         *   Display the status of *all* workshops.
 *         *   For each workshop, show its ID, name, capacity, current registered count, list of registered attendee names, current waiting list count, and list of waiting list attendee names. Use `System.out`.
 * 
 * 5.  **Required Java Components:** Your solution *must* use and demonstrate understanding of the following:
 *     *   `java.util.Queue` (as the type for the waiting list)
 *     *   `java.util.ArrayList` (as an implementation for the registered attendees list and the main collection of workshops)
 *     *   `java.util.List` (as a type for variables holding lists, demonstrating interface usage)
 *     *   `java.util.Scanner` (for user input)
 *     *   `switch` statement (for handling menu options)
 *     *   `System.err` (for printing error messages)
 *     *   `System.out` (for printing normal output, prompts, and status)
 *     *   Class-wide exception handling with `try-catch` blocks (e.g., wrapping the main application loop or input processing to handle unexpected issues like invalid input format).
 * 
 * 6.  **Best Practices:**
 *     *   Proper encapsulation (private fields, public methods).
 *     *   Meaningful variable and method names.
 *     *   Appropriate comments and documentation (basic Javadoc or inline comments).
 *     *   Input validation (e.g., checking if workshop ID is a valid number and exists).
 *     *   Proper error handling (using `try-catch` for potential exceptions, using `System.err` for errors).
 *     *   Clean code structure (separate classes, main logic in a dedicated class/method).
 * 
 * **Expected Output Structure (Example):**
 * 
 * ```
 * --- Conference Workshop Registration ---
 * 1. Register for Workshop
 * 2. View All Workshop Status
 * 3. Exit
 * Enter your choice: 1
 * Enter your name: Alice
 * Enter Workshop ID: 101
 * Alice successfully registered for Workshop: Introduction to Java.
 * 
 * --- Conference Workshop Registration ---
 * 1. Register for Workshop
 * 2. View All Workshop Status
 * 3. Exit
 * Enter your choice: 1
 * Enter your name: Bob
 * Enter Workshop ID: 101
 * Workshop: Introduction to Java is full. Bob added to waiting list.
 * 
 * --- Conference Workshop Registration ---
 * 1. Register for Workshop
 * 2. View All Workshop Status
 * 3. Exit
 * Enter your choice: 2
 * --- Workshop Status ---
 * ID: 101, Name: Introduction to Java, Capacity: 1, Registered: 1, Waiting List: 1
 *   Registered: [Alice]
 *   Waiting List: [Bob]
 * ID: 102, Name: Advanced SQL, Capacity: 2, Registered: 0, Waiting List: 0
 *   Registered: []
 *   Waiting List: []
 * ID: 103, Name: Cloud Computing Basics, Capacity: 5, Registered: 0, Waiting List: 0
 *   Registered: []
 *   Waiting List: []
 * --- End of Status ---
 * 
 * --- Conference Workshop Registration ---
 * 1. Register for Workshop
 * 2. View All Workshop Status
 * 3. Exit
 * Enter your choice: 5
 * Invalid choice. Please enter 1, 2, or 3.
 * 
 * --- Conference Workshop Registration ---
 * 1. Register for Workshop
 * 2. View All Workshop Status
 * 3. Exit
 * Enter your choice: 1
 * Enter your name: Charlie
 * Enter Workshop ID: abc
 * Error: Invalid input. Please enter a valid number for Workshop ID.
 * 
 * --- Conference Workshop Registration ---
 * 1. Register for Workshop
 * 2. View All Workshop Status
 * 3. Exit
 * Enter your choice: 1
 * Enter your name: Alice
 * Enter Workshop ID: 101
 * Error: Alice is already registered or on the waiting list for Workshop: Introduction to Java.
 * 
 * --- Conference Workshop Registration ---
 * 1. Register for Workshop
 * 2. View All Workshop Status
 * 3. Exit
 * Enter your choice: 3
 * Exiting system. Goodbye!
 * ```
 * 
 * **Assessment:**
 * 
 * Your solution will be assessed on correctness, adherence to all requirements (especially the mandatory components), code quality, error handling, and clarity.
 *
 * EXPLANATION:
 * This solution implements a basic conference workshop registration system, demonstrating the required Java concepts and best practices.
 * 
 * 1.  **Overall Structure:** The system is organized into three classes:
 *     *   `Attendee`: A simple class to hold attendee information (just the name). It includes overridden `equals` and `hashCode` methods based on the attendee's name (case-insensitive) to correctly check for duplicates in lists and queues.
 *     *   `Workshop`: Manages the details of a single workshop, including its capacity, registered attendees, and waiting list. It contains the core logic for registering attendees.
 *     *   `ConferenceManager`: The main class that orchestrates the application. It holds the collection of workshops, handles user interaction via the menu, processes commands, and manages the `Scanner`. It also contains the `main` method and the top-level exception handling.
 * 
 * 2.  **Required Component Usage:**
 *     *   `java.util.Queue`: The `waitingList` field in the `Workshop` class is declared as a `Queue<Attendee>`. A `LinkedList` is used as the concrete implementation, which is a common choice for queues due to efficient additions/removals from ends. The `offer()` method is used to add attendees to the waiting list.
 *     *   `java.util.ArrayList`: Used as the concrete implementation for two `List` variables: `registeredAttendees` within the `Workshop` class and the `workshops` collection in the `ConferenceManager` class. `ArrayList` is suitable here for storing and iterating over elements.
 *     *   `java.util.List`: Used as the *type* for the `registeredAttendees` field in `Workshop` and the `workshops` field in `ConferenceManager`. This demonstrates programming to the interface rather than the implementation, promoting flexibility.
 *     *   `java.util.Scanner`: An instance is created in `ConferenceManager` to read user input from `System.in`. It's used to read menu choices, attendee names, and workshop IDs.
 *     *   `switch` statement: Used in the `ConferenceManager.run()` method to handle the different menu options selected by the user.
 *     *   `System.err`: Used specifically for printing error messages, such as invalid menu choices, invalid input formats, workshop not found, or attempts to register an attendee who is already listed.
 *     *   `System.out`: Used for all normal output, including displaying the menu, prompts for input, success messages, informational messages (like being added to the waiting list), and the full workshop status report.
 *     *   Class-wide exception handling (`try-catch`): A `try-catch` block is placed around the main `while` loop in the `ConferenceManager.run()` method. This provides a top-level handler for any unexpected exceptions that might occur during the program's execution, printing an error message and the stack trace to `System.err` before the program potentially terminates (or exits the loop if the exception is handled). Specific input parsing errors (`NumberFormatException`) are also handled with `try-catch` within the `handleRegistration` method.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Attendee` and `Workshop` are `private`, and access is provided through `public` getter methods. The internal structure (like the specific `Queue` or `List` implementation) is hidden from external classes.
 *     *   **Meaningful Names:** Classes (`Attendee`, `Workshop`, `ConferenceManager`), fields (`name`, `capacity`, `registeredAttendees`, `waitingList`), and methods (`registerAttendee`, `findWorkshopById`, `displayMenu`, `handleRegistration`, `handleViewStatus`, `run`) have names that clearly indicate their purpose.
 *     *   **Comments/Documentation:** Basic Javadoc-style comments are used for classes and key methods, explaining their role and parameters/return values. Inline comments clarify specific logic points.
 *     *   **Input Validation:** The code checks if the entered workshop ID is a valid integer using `try-catch` around `Integer.parseInt()`. It also checks if the parsed ID corresponds to an existing workshop. Attendee name is checked for emptiness.
 *     *   **Error Handling:** Specific errors (like invalid input format, workshop not found, or already registered) are caught and reported using `System.err`. The top-level `try-catch` handles unexpected runtime errors.
 *     *   **Clean Structure:** The logic is separated into distinct classes with clear responsibilities. The `ConferenceManager` acts as the controller, managing the application flow and user interaction, while `Workshop` and `Attendee` are data models with associated business logic.
 * 
 * The solution effectively integrates the required components into a functional system, demonstrating practical application of core Java concepts in a simulated real-world scenario.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList; // Common Queue implementation
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

    // Override equals and hashCode for proper checking if an attendee is already registered
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee attendee = (Attendee) o;
        return name.equalsIgnoreCase(attendee.name); // Case-insensitive name comparison
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode(); // Use lower case for consistency with equals
    }

    @Override
    public String toString() {
        return name;
    }
}

// Represents a workshop with limited capacity and a waiting list
class Workshop {
    private int id;
    private String name;
    private int capacity;
    private List<Attendee> registeredAttendees; // Using List interface, implemented by ArrayList
    private Queue<Attendee> waitingList; // Using Queue interface, implemented by LinkedList

    public Workshop(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.registeredAttendees = new ArrayList<>(); // ArrayList for easy access and iteration
        this.waitingList = new LinkedList<>(); // LinkedList is a common Queue implementation
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Attendee> getRegisteredAttendees() {
        // Return a copy or unmodifiable list for safety in a real system
        // For this exam, returning the direct list reference is acceptable
        return registeredAttendees;
    }

    public Queue<Attendee> getWaitingList() {
        // Return a copy or unmodifiable queue for safety in a real system
        // For this exam, returning the direct queue reference is acceptable
        return waitingList;
    }

    /**
     * Attempts to register an attendee for the workshop.
     *
     * @param attendee The attendee to register.
     * @return A status message indicating the result.
     */
    public String registerAttendee(Attendee attendee) {
        // Check if attendee is already registered or on waiting list
        if (registeredAttendees.contains(attendee) || waitingList.contains(attendee)) {
            return "Error: " + attendee.getName() + " is already registered or on the waiting list for Workshop: " + this.name + ".";
        }

        // Check if capacity allows registration
        if (registeredAttendees.size() < capacity) {
            registeredAttendees.add(attendee);
            return attendee.getName() + " successfully registered for Workshop: " + this.name + ".";
        } else {
            // Workshop is full, add to waiting list
            waitingList.offer(attendee); // offer() is preferred over add() for queues as it doesn't throw exception on failure (though LinkedList's offer doesn't fail)
            return "Workshop: " + this.name + " is full. " + attendee.getName() + " added to waiting list.";
        }
    }

    /**
     * Checks if the workshop is currently at or over capacity.
     * @return true if full, false otherwise.
     */
    public boolean isFull() {
        return registeredAttendees.size() >= capacity;
    }
}

// Main class to manage the conference and user interaction
public class ConferenceManager {

    private List<Workshop> workshops; // Using List interface, implemented by ArrayList
    private Scanner scanner;

    public ConferenceManager() {
        // Initialize workshops list using ArrayList
        this.workshops = new ArrayList<>();
        // Pre-populate with sample workshops
        workshops.add(new Workshop(101, "Introduction to Java", 1)); // Small capacity for testing waiting list
        workshops.add(new Workshop(102, "Advanced SQL", 2));
        workshops.add(new Workshop(103, "Cloud Computing Basics", 5));

        this.scanner = new Scanner(System.in);
    }

    /**
     * Finds a workshop by its ID.
     * @param id The ID to search for.
     * @return The Workshop object if found, null otherwise.
     */
    private Workshop findWorkshopById(int id) {
        for (Workshop workshop : workshops) {
            if (workshop.getId() == id) {
                return workshop;
            }
        }
        return null; // Workshop not found
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("\n--- Conference Workshop Registration ---");
        System.out.println("1. Register for Workshop");
        System.out.println("2. View All Workshop Status");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Handles the registration process.
     */
    private void handleRegistration() {
        System.out.print("Enter your name: ");
        String attendeeName = scanner.nextLine();
        if (attendeeName == null || attendeeName.trim().isEmpty()) {
            System.err.println("Error: Attendee name cannot be empty.");
            return;
        }

        System.out.print("Enter Workshop ID: ");
        int workshopId;
        try {
            workshopId = Integer.parseInt(scanner.nextLine()); // Read full line to avoid issues with nextInt() and nextLine()
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input. Please enter a valid number for Workshop ID.");
            return;
        }

        Workshop workshop = findWorkshopById(workshopId);

        if (workshop == null) {
            System.err.println("Error: Workshop with ID " + workshopId + " not found.");
            return;
        }

        Attendee newAttendee = new Attendee(attendeeName.trim());
        String result = workshop.registerAttendee(newAttendee);

        // Use System.out for success/info messages, System.err for errors (like already registered)
        if (result.startsWith("Error:")) {
             System.err.println(result);
        } else {
             System.out.println(result);
        }
    }

    /**
     * Handles displaying the status of all workshops.
     */
    private void handleViewStatus() {
        System.out.println("\n--- Workshop Status ---");
        if (workshops.isEmpty()) {
            System.out.println("No workshops available.");
            return;
        }

        for (Workshop workshop : workshops) {
            System.out.println("ID: " + workshop.getId() + ", Name: " + workshop.getName() +
                               ", Capacity: " + workshop.getCapacity() +
                               ", Registered: " + workshop.getRegisteredAttendees().size() +
                               ", Waiting List: " + workshop.getWaitingList().size());

            // Display registered attendees
            System.out.print("  Registered: [");
            List<Attendee> registered = workshop.getRegisteredAttendees(); // Use List interface variable
            for (int i = 0; i < registered.size(); i++) {
                System.out.print(registered.get(i).getName() + (i < registered.size() - 1 ? ", " : ""));
            }
            System.out.println("]");

            // Display waiting list attendees
            System.out.print("  Waiting List: [");
            // Iterating through the queue without removing elements
            // We can convert it to a List or iterate with an enhanced for loop
            List<Attendee> waiting = new ArrayList<>(workshop.getWaitingList()); // Copy to List for easy iteration and size check
             for (int i = 0; i < waiting.size(); i++) {
                System.out.print(waiting.get(i).getName() + (i < waiting.size() - 1 ? ", " : ""));
            }
            System.out.println("]");
        }
        System.out.println("--- End of Status ---");
    }

    /**
     * Runs the main application loop.
     * Includes class-wide exception handling.
     */
    public void run() {
        boolean exit = false;

        // Class-wide try-catch block for the main application loop
        try {
            while (!exit) {
                displayMenu();
                String choiceStr = scanner.nextLine(); // Read choice as string first

                int choice = -1; // Default to invalid choice
                try {
                    choice = Integer.parseInt(choiceStr); // Attempt to parse choice
                } catch (NumberFormatException e) {
                    // Handled below in the default case of the switch
                }

                // Use switch statement for menu navigation
                switch (choice) {
                    case 1:
                        handleRegistration();
                        break;
                    case 2:
                        handleViewStatus();
                        break;
                    case 3:
                        System.out.println("Exiting system. Goodbye!");
                        exit = true;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter 1, 2, or 3.");
                        break;
                }
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the main loop
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to System.err
        } finally {
            // Ensure scanner is closed
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        ConferenceManager manager = new ConferenceManager();
        manager.run();
    }
}
