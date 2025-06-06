/*
 * Exam Question #196
 * Generated on: 2025-05-11 22:29:56
 * Generated by: Account 3
 * 
 * QUESTION:
 * **Java Programming Exam Task: Manufacturing Process Simulation**
 * 
 * **Scenario:**
 * You are tasked with developing a simplified simulation of a manufacturing line. Items (referred to as "Widgets") enter the line and must pass through a predefined sequence of processing stations. Widgets wait in a single queue for their next processing step. Once a Widget is processed at its current station, it moves to the next station in the sequence. If it has completed the last station, it is considered finished.
 * 
 * Your program should allow a user to interact with this simulation by adding new Widgets to the start of the line, processing the next available Widget in the queue, viewing the current status of the line, or exiting.
 * 
 * **Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Use a `java.util.Queue` to manage Widgets waiting for their next processing step.
 *     *   Use a `java.util.ArrayList` to store the sequence of station names.
 *     *   Use the `java.util.List` interface when referring to the sequence of stations or a list of finished items.
 * 2.  **User Interaction:**
 *     *   Use `java.util.Scanner` to read user commands from the console.
 *     *   Implement a menu with options:
 *         *   1: Add new Widget
 *         *   2: Process next Widget
 *         *   3: View Status
 *         *   4: Exit
 * 3.  **Control Flow:**
 *     *   Use a `switch` statement to handle the user's menu choice.
 *     *   The program should loop until the user chooses to exit.
 * 4.  **Output:**
 *     *   Use `System.out` for normal program output (menu, prompts, status updates, successful operations).
 *     *   Use `System.err` to display error messages (e.g., invalid input, trying to process when the queue is empty).
 * 5.  **Error Handling:**
 *     *   Implement class-wide exception handling (or handling around the main interaction loop) using `try-catch` blocks to gracefully manage potential runtime issues, such as invalid input format.
 *     *   Validate user input where necessary (e.g., ensuring menu choice is an integer within range).
 *     *   Handle the case where the user tries to process a Widget when the queue is empty.
 * 6.  **Object-Oriented Design:**
 *     *   Create a `WidgetItem` class to represent an item in the manufacturing line. This class should track which station it is currently waiting for or being processed at (e.g., using an index).
 *     *   Create a main class (e.g., `ManufacturingLineSimulation`) to manage the simulation state (queue, stations, finished items) and handle user interaction.
 *     *   Employ proper encapsulation (private fields, public methods).
 * 7.  **Best Practices:**
 *     *   Use meaningful variable and method names.
 *     *   Include appropriate comments and documentation (Javadocs or inline comments) explaining the purpose of classes, methods, and key logic sections.
 *     *   Ensure clean code structure.
 * 
 * **Manufacturing Line Configuration:**
 * The manufacturing line consists of the following stations in this exact sequence:
 * 1.  Cutting
 * 2.  Drilling
 * 3.  Assembly
 * 4.  Painting
 * 5.  Quality Control
 * 
 * Widgets start before the "Cutting" station (index 0). After completing "Quality Control" (index 4), they are finished.
 * 
 * **Expected Output Structure:**
 * 
 * ```
 * Manufacturing Line Simulation
 * -----------------------------
 * Stations: [Cutting, Drilling, Assembly, Painting, Quality Control]
 * 
 * Menu:
 * 1: Add new Widget
 * 2: Process next Widget
 * 3: View Status
 * 4: Exit
 * Enter choice:
 * [User Input]
 * ... Program output based on choice ...
 * Enter choice:
 * [User Input]
 * ...
 * ```
 * 
 * *   When adding a Widget: Print "Widget [ID] added to the line." (Assign a simple sequential ID).
 * *   When processing a Widget: Print "Processing Widget [ID] at station [Station Name]..."
 *     *   If it's the last station: "... Widget [ID] finished."
 *     *   If it's not the last station: "... Widget [ID] moved to queue for [Next Station Name]."
 * *   When viewing status: Print "Current Status:" followed by "Items waiting in queue: [count]" and "Finished items: [count]".
 * *   When queue is empty and processing is attempted: Print an error message to `System.err`.
 * *   When invalid input is given: Print an error message to `System.err`.
 * 
 * Your task is to write the complete Java code for this simulation.
 *
 * EXPLANATION:
 * The provided Java code implements a simplified manufacturing line simulation, fulfilling all the requirements of the exam task.
 * 
 * **Core Concepts Demonstrated:**
 * 
 * 1.  **`Queue` (`java.util.Queue`):** A `LinkedList` is used as the concrete implementation of the `Queue` interface (`processingQueue`). The `processingQueue.offer()` method is used to add items to the end of the queue (when a new widget is added or a widget finishes a station and moves to the next). The `processingQueue.poll()` method is used to retrieve and remove the item at the front of the queue (the next widget to be processed). This correctly simulates items waiting in line for their turn.
 * 2.  **`ArrayList` (`java.util.ArrayList`):** An `ArrayList` (`stations`) is used to store the sequence of station names as `String` objects. This provides an ordered, index-based collection to represent the steps in the manufacturing process.
 * 3.  **`List` interface (`java.util.List`):** The `stations` variable is declared as `List<String>` (though initialized with `ArrayList`), demonstrating the use of the interface. The `finishedItems` variable is also declared as `List<WidgetItem>`, using `ArrayList` as its implementation. Using interfaces promotes flexibility and good design practices.
 * 4.  **`Scanner` (`java.util.Scanner`):** A `Scanner` object is used in the `runSimulation` method to read integer input from `System.in` for the user's menu choice.
 * 5.  **`switch` statement:** A `switch` statement is used within the main simulation loop (`runSimulation`) to direct the program's flow based on the integer value of the user's menu choice (1, 2, 3, or 4).
 * 6.  **`System.err`:** `System.err.println()` is used specifically for printing error messages, such as when the user provides invalid input (non-integer or out of range) or attempts to process a widget when the queue is empty. This separates error output from normal program output.
 * 7.  **`System.out`:** `System.out.println()` is used for all standard program output, including the menu, prompts, status updates, and messages about successful operations (adding, processing, finishing widgets).
 * 8.  **Class-wide Exception Handling (`try-catch`):** A `try-catch` block is wrapped around the main `while` loop in the `runSimulation` method. This provides a top-level handler for potential exceptions that might occur during the user interaction and command execution phase. A specific `catch (InputMismatchException e)` is also included *inside* the loop to handle non-integer input specifically, allowing the loop to continue after consuming the bad input. A general `catch (Exception e)` is present around the entire loop for unexpected errors. A `finally` block is included to demonstrate its usage, ensuring the `Scanner` is closed.
 * 9.  **Input Validation:** The code checks if the user's menu choice is within the valid range (1-4) and uses `InputMismatchException` handling to catch non-integer input. It also checks if the `processingQueue` is empty before attempting to `poll`.
 * 10. **Proper Error Handling:** Specific error messages are printed to `System.err` for different error conditions (invalid input, empty queue).
 * 11. **Object-Oriented Design:**
 *     *   The `WidgetItem` class encapsulates the state of a single item (its ID and current station index). It has private fields and public methods (`getId`, `getCurrentStationIndex`, `moveToNextStation`).
 *     *   The `ManufacturingLineSimulation` class manages the overall simulation state (queues, lists, counter) and the simulation logic (`addNewWidget`, `processNextWidget`, `viewStatus`, `runSimulation`).
 * 12. **Best Practices:**
 *     *   Meaningful names are used for classes (`WidgetItem`, `ManufacturingLineSimulation`), variables (`processingQueue`, `stations`, `finishedItems`, `nextWidgetId`, `currentStationIndex`), and methods (`addNewWidget`, `processNextWidget`, `viewStatus`, `runSimulation`, `displayMenu`).
 *     *   Javadoc comments explain the purpose of classes and methods. Inline comments explain specific logic points.
 *     *   The code is structured logically with separate methods for distinct actions (adding, processing, viewing status, running the loop, displaying the menu).
 * 
 * This solution effectively integrates the required Java components into a functional simulation, demonstrating an understanding of data structures, control flow, object-oriented principles, and robust error handling in Java.
 */

import java.util.ArrayList;
import java.util.LinkedList; // LinkedList is a common Queue implementation
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Represents a single item (Widget) moving through the manufacturing line.
 */
class WidgetItem {
    private int id;
    private int currentStationIndex; // Index of the station the widget is currently waiting for or being processed at

    /**
     * Constructs a new WidgetItem.
     * @param id The unique identifier for the widget.
     */
    public WidgetItem(int id) {
        this.id = id;
        this.currentStationIndex = 0; // Starts at the beginning, waiting for the first station
    }

    /**
     * Gets the widget's ID.
     * @return The widget ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the index of the station the widget is currently at or waiting for.
     * @return The current station index.
     */
    public int getCurrentStationIndex() {
        return currentStationIndex;
    }

    /**
     * Increments the station index, moving the widget to the next step.
     */
    public void moveToNextStation() {
        this.currentStationIndex++;
    }

    @Override
    public String toString() {
        return "Widget-" + id;
    }
}

/**
 * Simulates a simplified manufacturing line with multiple processing stations.
 */
public class ManufacturingLineSimulation {

    private Queue<WidgetItem> processingQueue;
    private List<String> stations;
    private List<WidgetItem> finishedItems;
    private int nextWidgetId; // Counter for assigning unique widget IDs

    /**
     * Constructs a new ManufacturingLineSimulation.
     * Initializes stations, queues, and the widget counter.
     */
    public ManufacturingLineSimulation() {
        // Use LinkedList as an implementation of Queue
        this.processingQueue = new LinkedList<>();
        // Use ArrayList to store the sequence of stations
        this.stations = new ArrayList<>();
        stations.add("Cutting");
        stations.add("Drilling");
        stations.add("Assembly");
        stations.add("Painting");
        stations.add("Quality Control");

        // Use ArrayList as an implementation of List for finished items
        this.finishedItems = new ArrayList<>();
        this.nextWidgetId = 1;
    }

    /**
     * Adds a new widget to the start of the processing line (the queue).
     */
    public void addNewWidget() {
        WidgetItem newWidget = new WidgetItem(nextWidgetId++);
        processingQueue.offer(newWidget); // Add to the end of the queue
        System.out.println(newWidget + " added to the line, waiting for '" + stations.get(newWidget.getCurrentStationIndex()) + "'.");
    }

    /**
     * Processes the next widget from the queue.
     * Simulates processing at its current station and moves it to the next step.
     */
    public void processNextWidget() {
        // Poll the next widget from the front of the queue
        WidgetItem widgetToProcess = processingQueue.poll();

        if (widgetToProcess == null) {
            System.err.println("Error: No widgets are currently waiting in the queue to be processed.");
            return;
        }

        int currentStationIndex = widgetToProcess.getCurrentStationIndex();

        // Check if the current station index is valid
        if (currentStationIndex < 0 || currentStationIndex >= stations.size()) {
             System.err.println("Internal Error: " + widgetToProcess + " has an invalid station index: " + currentStationIndex);
             // Optionally, discard or handle this invalid state differently
             return;
        }

        String currentStationName = stations.get(currentStationIndex);
        System.out.print("Processing " + widgetToProcess + " at station '" + currentStationName + "'...");

        widgetToProcess.moveToNextStation(); // Move to the next station index

        if (widgetToProcess.getCurrentStationIndex() < stations.size()) {
            // Not finished yet, add back to the queue for the next station
            processingQueue.offer(widgetToProcess);
            String nextStationName = stations.get(widgetToProcess.getCurrentStationIndex());
            System.out.println(" " + widgetToProcess + " moved to queue for '" + nextStationName + "'.");
        } else {
            // Finished all stations
            finishedItems.add(widgetToProcess);
            System.out.println(" " + widgetToProcess + " finished.");
        }
    }

    /**
     * Displays the current status of the manufacturing line.
     */
    public void viewStatus() {
        System.out.println("\n--- Current Status ---");
        System.out.println("Stations: " + stations); // Print the list of stations
        System.out.println("Items waiting in queue: " + processingQueue.size());
        System.out.println("Finished items: " + finishedItems.size());
        // Optionally print items in queue/finished for more detail
        // System.out.println("Queue: " + processingQueue);
        // System.out.println("Finished: " + finishedItems);
        System.out.println("----------------------\n");
    }

    /**
     * Displays the main menu to the user.
     */
    private void displayMenu() {
        System.out.println("Manufacturing Line Simulation");
        System.out.println("-----------------------------");
        System.out.println("Stations: " + stations);
        System.out.println("\nMenu:");
        System.out.println("1: Add new Widget");
        System.out.println("2: Process next Widget");
        System.out.println("3: View Status");
        System.out.println("4: Exit");
        System.out.print("Enter choice: ");
    }

    /**
     * Runs the main simulation loop, handling user interaction.
     */
    public void runSimulation() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Class-wide (or main loop wide) exception handling
        try {
            while (running) {
                displayMenu();
                int choice = -1;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.err.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume the invalid input to prevent infinite loop
                    continue; // Skip the rest of the loop iteration
                } finally {
                    // No specific action needed in finally for this simple case, but included as per requirement structure
                }

                // Use a switch statement for flow control
                switch (choice) {
                    case 1:
                        addNewWidget();
                        break;
                    case 2:
                        processNextWidget();
                        break;
                    case 3:
                        viewStatus();
                        break;
                    case 4:
                        System.out.println("Exiting Simulation. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.err.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
                System.out.println(); // Add a newline for better readability between actions
            }
        } catch (Exception e) {
            // Catch any unexpected exceptions during the simulation loop
            System.err.println("An unexpected error occurred during simulation: " + e.getMessage());
            e.printStackTrace(System.err); // Print stack trace to standard error
        } finally {
            // Ensure the scanner is closed
            if (scanner != null) {
                scanner.close();
            }
            System.out.println("Simulation ended.");
        }
    }

    /**
     * Main method to start the simulation.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        ManufacturingLineSimulation simulation = new ManufacturingLineSimulation();
        simulation.runSimulation();
    }
}
