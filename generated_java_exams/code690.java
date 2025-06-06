/*
 * Exam Question #690
 * Generated on: 2025-05-12 16:26:12
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Airport Baggage Handling Simulation
 * 
 * **Objective:**
 * 
 * Develop a simplified simulation of an airport baggage handling system. The system manages incoming baggage items in a processing queue and tracks active flights to which baggage is assigned. Your solution must demonstrate proficiency in using various core Java components and adhere to best programming practices.
 * 
 * **System Description:**
 * 
 * Baggage items arrive at a central processing area and are placed into a queue to await scanning and sorting. Each baggage item is associated with a specific flight. The system allows operators to add new baggage to the queue, process the next available baggage, view the current items waiting in the queue, and view the list of active flights.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use `java.util.Queue` to represent the processing queue for baggage items (First-In, First-Out).
 *     *   Use `java.util.ArrayList` to store the list of active flights.
 *     *   Use `java.util.List` as the type for the collection of active flights (demonstrating polymorphism).
 * 
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user commands and input data from the console.
 *     *   Present a menu of operations to the user.
 *     *   Use a `switch` statement to handle different user menu selections.
 * 
 * 3.  **Error Handling:**
 *     *   Use `System.err` to print error messages (e.g., invalid input, trying to process an empty queue, invalid flight number).
 *     *   Use `System.out` for normal output (menu, prompts, success messages, status displays).
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle potential issues like invalid input format (`NumberFormatException`) or unexpected errors during operations.
 * 
 * 4.  **Object-Oriented Design:**
 *     *   Create separate classes for `Flight` and `Baggage`.
 *     *   Ensure proper encapsulation (private fields, public getters).
 *     *   Provide meaningful variable and method names.
 * 
 * 5.  **Functionality:**
 *     *   **Add Baggage:** Prompt the user for Baggage ID (integer), weight (double), and the associated Flight Number (string). Validate that the entered Flight Number exists in the list of active flights before adding the baggage to the queue. If validation fails or input is invalid, print an error to `System.err` and do not add the baggage.
 *     *   **Process Baggage:** Remove the next baggage item from the front of the queue. If the queue is empty, print an error message to `System.err`. Otherwise, print details of the processed baggage to `System.out`.
 *     *   **View Processing Queue:** Display all baggage items currently waiting in the queue without removing them. If the queue is empty, print a message to `System.out`.
 *     *   **View Active Flights:** Display the list of all active flights.
 *     *   **Exit:** Terminate the program.
 * 
 * 6.  **Best Practices:**
 *     *   Include appropriate comments and documentation (e.g., Javadoc for classes and methods).
 *     *   Implement input validation where necessary.
 *     *   Ensure clean code structure (separate methods for different operations).
 * 
 * **Initial Data:**
 * 
 * The system should start with a predefined list of active flights. For example:
 * *   Flight 1: BA249 to London
 * *   Flight 2: LH451 to Frankfurt
 * *   Flight 3: AF103 to Paris
 * 
 * **Expected Output:**
 * 
 * The program should run interactively, presenting a menu and responding to user commands. Output should clearly distinguish between normal information (`System.out`) and errors (`System.err`).
 * 
 * ```
 * --- Airport Baggage System Menu ---
 * 1. Add Baggage
 * 2. Process Next Baggage
 * 3. View Processing Queue
 * 4. View Active Flights
 * 5. Exit
 * -----------------------------------
 * Enter your choice: 1
 * Enter Baggage ID: 101
 * Enter Baggage Weight (kg): 25.5
 * Enter Associated Flight Number: BA249
 * Baggage 101 added to the processing queue.
 * 
 * --- Airport Baggage System Menu ---
 * ...
 * Enter your choice: 2
 * Processing baggage: Baggage ID: 101, Weight: 25.5 kg, Flight: BA249
 * 
 * --- Airport Baggage System Menu ---
 * ...
 * Enter your choice: 2
 * Error: Processing queue is empty. (Printed to System.err)
 * 
 * --- Airport Baggage System Menu ---
 * ...
 * Enter your choice: 3
 * Processing Queue:
 * Baggage ID: 102, Weight: 15.0 kg, Flight: LH451
 * Baggage ID: 103, Weight: 30.2 kg, Flight: BA249
 * 
 * --- Airport Baggage System Menu ---
 * ...
 * Enter your choice: 4
 * Active Flights:
 * Flight: BA249, Destination: London
 * Flight: LH451, Destination: Frankfurt
 * Flight: AF103, Destination: Paris
 * 
 * --- Airport Baggage System Menu ---
 * ...
 * Enter your choice: 1
 * Enter Baggage ID: 104
 * Enter Baggage Weight (kg): 20.0
 * Enter Associated Flight Number: UA789
 * Error: Invalid flight number 'UA789'. Baggage not added. (Printed to System.err)
 * 
 * --- Airport Baggage System Menu ---
 * ...
 * Enter your choice: 6
 * Error: Invalid menu choice. Please try again. (Printed to System.err)
 * 
 * --- Airport Baggage System Menu ---
 * ...
 * Enter your choice: 5
 * Exiting system.
 * ```
 * 
 * Your solution should be a single Java file containing all necessary classes.
 *
 * EXPLANATION:
 * This solution implements the Airport Baggage Handling System simulation as requested, incorporating all specified Java components and best practices.
 * 
 * 1.  **Class Structure:**
 *     *   `Flight` class: Simple class to hold flight details (`flightNumber`, `destination`). Uses private fields and public getters for encapsulation. Includes a `toString()` method for easy printing.
 *     *   `Baggage` class: Holds baggage details (`baggageId`, `weightKg`, `associatedFlightNumber`). Also uses private fields, public getters, and a `toString()` method.
 *     *   `AirportBaggageSystem` class: The main class orchestrating the simulation. It holds the core data structures (`processingQueue`, `activeFlights`) and the main application logic.
 * 
 * 2.  **Data Structures:**
 *     *   `private Queue<Baggage> processingQueue;`: Declared as a `Queue` interface type, but initialized with `new LinkedList<>()`. `LinkedList` is a common implementation of `Queue` in Java, providing FIFO behavior suitable for a processing line.
 *     *   `private List<Flight> activeFlights;`: Declared as a `List` interface type, but initialized with `new ArrayList<>()`. Using the `List` interface allows for flexibility if a different `List` implementation (like `LinkedList`) were needed later, without changing the rest of the code that uses the `List` interface. `ArrayList` is suitable here as we primarily need to store and iterate through flights.
 * 
 * 3.  **User Interaction & Flow Control:**
 *     *   `private Scanner scanner;`: Used to read input from `System.in`. It's initialized in the constructor and closed when the program exits to release system resources.
 *     *   `run()` method: Contains the main `while` loop that keeps the program running until the user chooses to exit.
 *     *   `displayMenu()`: A helper method to print the available options.
 *     *   `switch (choice)`: Inside the `run` method, a `switch` statement is used to direct execution based on the user's integer input. This is a clear way to handle multiple distinct commands from a menu.
 * 
 * 4.  **Functionality Implementation:**
 *     *   `addBaggage()`: Prompts for input, performs validation (checking if the flight number exists using the `isValidFlight` helper method), creates a `Baggage` object, and adds it to the `processingQueue` using `offer()`. `offer()` is preferred over `add()` for queues as it returns `false` if the element cannot be added (though with `LinkedList`, it typically succeeds unless memory is exhausted).
 *     *   `processBaggage()`: Removes the next item using `poll()`. `poll()` is preferred over `remove()` as it returns `null` if the queue is empty, allowing graceful handling of this condition.
 *     *   `viewProcessingQueue()`: Iterates through the `processingQueue` using an enhanced for loop (`for (Baggage bag : processingQueue)`). This iterates over the elements without removing them.
 *     *   `viewActiveFlights()`: Iterates through the `activeFlights` list and prints each `Flight` object.
 *     *   `isValidFlight()`: A private helper method to check if a given flight number exists in the `activeFlights` list. It performs a case-insensitive comparison using `equalsIgnoreCase`.
 * 
 * 5.  **Error Handling:**
 *     *   **Class-wide `try-catch`:** The `run()` method wraps the core `switch` logic within a `try-catch(Exception e)`. This catches general exceptions that might occur during the execution of the chosen operation, preventing the program from crashing and printing an error message to `System.err`.
 *     *   **Specific Input Handling:** The `addBaggage()` method uses `try-catch(NumberFormatException e)` blocks when parsing the Baggage ID and weight from strings. This handles cases where the user enters non-numeric input for these fields. Error messages are printed to `System.err`, and the method returns early, preventing the creation and addition of invalid baggage.
 *     *   **Operation-Specific Errors:**
 *         *   `processBaggage()` explicitly checks if `processingQueue.poll()` returns `null` and prints an error to `System.err` if the queue was empty.
 *         *   `addBaggage()` checks the return value of `isValidFlight()` and prints an error to `System.err` if the flight number is invalid.
 *     *   **Invalid Menu Choice:** The `default` case in the main `switch` handles invalid integer inputs for the menu choice, printing an error to `System.err`.
 * 
 * 6.  **Best Practices:**
 *     *   **Encapsulation:** Private fields and public getters in `Flight` and `Baggage`.
 *     *   **Naming:** Descriptive names like `processingQueue`, `activeFlights`, `addBaggage`, `isValidFlight`.
 *     *   **Comments/Documentation:** Javadoc comments explain the purpose of classes and methods. Inline comments clarify specific logic points.
 *     *   **Input Validation:** Checks for numeric format and valid flight numbers. Reading input using `scanner.nextLine()` and then parsing (`Integer.parseInt`, `Double.parseDouble`) within `try-catch` is a robust way to handle potential `NumberFormatException` compared to using `scanner.nextInt()` or `scanner.nextDouble()` directly, which can leave newline characters in the buffer and cause issues.
 *     *   **Clean Code:** Logic is broken down into small, focused methods (`addBaggage`, `processBaggage`, etc.).
 * 
 * This solution effectively demonstrates the required Java concepts in a practical, interactive scenario, incorporating essential error handling and good design principles.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException; // Not strictly needed with nextLine() + parsing, but good to know

/**
 * Represents a flight with a number and destination.
 */
class Flight {
    private String flightNumber;
    private String destination;

    /**
     * Constructs a new Flight object.
     * @param flightNumber The unique flight number.
     * @param destination The destination city of the flight.
     */
    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    /**
     * Gets the flight number.
     * @return The flight number.
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Gets the destination.
     * @return The destination city.
     */
    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Flight: " + flightNumber + ", Destination: " + destination;
    }
}

/**
 * Represents a piece of baggage assigned to a specific flight.
 */
class Baggage {
    private int baggageId;
    private double weightKg;
    private String associatedFlightNumber;

    /**
     * Constructs a new Baggage object.
     * @param baggageId The unique ID for the baggage item.
     * @param weightKg The weight of the baggage in kilograms.
     * @param associatedFlightNumber The flight number this baggage is assigned to.
     */
    public Baggage(int baggageId, double weightKg, String associatedFlightNumber) {
        this.baggageId = baggageId;
        this.weightKg = weightKg;
        this.associatedFlightNumber = associatedFlightNumber;
    }

    /**
     * Gets the baggage ID.
     * @return The baggage ID.
     */
    public int getBaggageId() {
        return baggageId;
    }

    /**
     * Gets the weight in kilograms.
     * @return The weight.
     */
    public double getWeightKg() {
        return weightKg;
    }

    /**
     * Gets the associated flight number.
     * @return The flight number.
     */
    public String getAssociatedFlightNumber() {
        return associatedFlightNumber;
    }

    @Override
    public String toString() {
        return "Baggage ID: " + baggageId + ", Weight: " + String.format("%.1f", weightKg) + " kg, Flight: " + associatedFlightNumber;
    }
}

/**
 * Simulates an airport baggage handling system.
 * Manages a queue of baggage and a list of active flights.
 */
public class AirportBaggageSystem {

    private Queue<Baggage> processingQueue;
    private List<Flight> activeFlights;
    private Scanner scanner;

    /**
     * Constructs the AirportBaggageSystem, initializing data structures
     * and populating initial flights.
     */
    public AirportBaggageSystem() {
        // Use LinkedList as a concrete implementation of Queue
        this.processingQueue = new LinkedList<>();
        // Use ArrayList as a concrete implementation of List
        this.activeFlights = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        // Populate initial active flights
        activeFlights.add(new Flight("BA249", "London"));
        activeFlights.add(new Flight("LH451", "Frankfurt"));
        activeFlights.add(new Flight("AF103", "Paris"));

        System.out.println("Airport Baggage Handling System Initialized.");
        System.out.println("Active flights loaded: " + activeFlights.size());
    }

    /**
     * Runs the main application loop, displaying the menu and processing user input.
     * Includes class-wide exception handling.
     */
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String choiceStr = scanner.nextLine(); // Read input as a string

            try {
                int choice = Integer.parseInt(choiceStr); // Attempt to parse choice
                switch (choice) {
                    case 1:
                        addBaggage();
                        break;
                    case 2:
                        processBaggage();
                        break;
                    case 3:
                        viewProcessingQueue();
                        break;
                    case 4:
                        viewActiveFlights();
                        break;
                    case 5:
                        running = false;
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.err.println("Error: Invalid menu choice. Please try again.");
                        break;
                }
            } catch (NumberFormatException e) {
                // Handle cases where user input for choice is not an integer
                System.err.println("Error: Invalid input format for choice. Please enter a number.");
            } catch (Exception e) {
                // Catch any other unexpected exceptions during operation execution
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging
            }
            System.out.println(); // Add a blank line for better readability
        }
        scanner.close(); // Close the scanner when exiting
    }

    /**
     * Displays the main menu options to the console.
     */
    private void displayMenu() {
        System.out.println("--- Airport Baggage System Menu ---");
        System.out.println("1. Add Baggage");
        System.out.println("2. Process Next Baggage");
        System.out.println("3. View Processing Queue");
        System.out.println("4. View Active Flights");
        System.out.println("5. Exit");
        System.out.println("-----------------------------------");
    }

    /**
     * Adds a new baggage item to the processing queue based on user input.
     * Includes input validation and error handling.
     */
    private void addBaggage() {
        System.out.print("Enter Baggage ID: ");
        String idStr = scanner.nextLine();
        int baggageId;
        try {
            baggageId = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input format for Baggage ID. Please enter an integer.");
            return; // Stop processing this request
        }

        System.out.print("Enter Baggage Weight (kg): ");
        String weightStr = scanner.nextLine();
        double weightKg;
        try {
            weightKg = Double.parseDouble(weightStr);
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid input format for Weight. Please enter a number.");
            return; // Stop processing this request
        }

        System.out.print("Enter Associated Flight Number: ");
        String flightNumber = scanner.nextLine().trim().toUpperCase(); // Trim and convert to uppercase for case-insensitive check

        if (!isValidFlight(flightNumber)) {
            System.err.println("Error: Invalid flight number '" + flightNumber + "'. Baggage not added.");
            return; // Stop processing this request
        }

        Baggage newBaggage = new Baggage(baggageId, weightKg, flightNumber);
        processingQueue.offer(newBaggage); // Use offer() which is recommended for queues (returns boolean)
        System.out.println("Baggage " + baggageId + " added to the processing queue.");
    }

    /**
     * Processes (removes) the next baggage item from the front of the queue.
     * Handles the case where the queue is empty.
     */
    private void processBaggage() {
        Baggage processedBag = processingQueue.poll(); // Use poll() which returns null if queue is empty
        if (processedBag == null) {
            System.err.println("Error: Processing queue is empty.");
        } else {
            System.out.println("Processing baggage: " + processedBag);
        }
    }

    /**
     * Displays all baggage items currently waiting in the processing queue.
     */
    private void viewProcessingQueue() {
        if (processingQueue.isEmpty()) {
            System.out.println("Processing Queue is empty.");
        } else {
            System.out.println("Processing Queue:");
            // Iterate through the queue without removing elements
            for (Baggage bag : processingQueue) {
                System.out.println(bag);
            }
        }
    }

    /**
     * Displays the list of all active flights.
     */
    private void viewActiveFlights() {
        if (activeFlights.isEmpty()) {
            System.out.println("No active flights currently listed.");
        } else {
            System.out.println("Active Flights:");
            for (Flight flight : activeFlights) {
                System.out.println(flight);
            }
        }
    }

    /**
     * Checks if a given flight number exists in the list of active flights.
     * @param flightNumber The flight number to check.
     * @return true if the flight number is valid, false otherwise.
     */
    private boolean isValidFlight(String flightNumber) {
        for (Flight flight : activeFlights) {
            // Case-insensitive comparison
            if (flight.getFlightNumber().equalsIgnoreCase(flightNumber)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The main entry point of the application.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        AirportBaggageSystem system = new AirportBaggageSystem();
        system.run();
    }
}
