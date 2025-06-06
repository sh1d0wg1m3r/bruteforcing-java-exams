/*
 * Exam Question #132
 * Generated on: 2025-05-11 22:19:17
 * Generated by: Account 4
 * 
 * QUESTION:
 * ## Java Programming Exam Task: Network Packet Processing Simulator
 * 
 * **Scenario:**
 * 
 * You are tasked with building a simplified network packet processing simulator. This system receives incoming network packets, queues them for processing, processes them based on their type, and records the results.
 * 
 * **Packet Structure:**
 * 
 * Each packet has the following attributes:
 * *   `id`: An integer identifier (unique).
 * *   `type`: A string representing the packet type (e.g., "DATA", "CONTROL", "ACK", "ERROR").
 * *   `payload`: A string containing the packet's data or command.
 * 
 * **Processing Logic:**
 * 
 * When a packet is processed from the queue, the system performs an action based on the packet's `type`:
 * *   **"DATA"**: Simulate processing by printing the packet's `id` and `payload` to `System.out`.
 * *   **"CONTROL"**: Simulate processing by printing the packet's `id` and confirming it's a "CONTROL" packet to `System.out`.
 * *   **"ACK"**: Simulate processing by printing the packet's `id` and acknowledging receipt to `System.out`.
 * *   **Any other type**: Consider this an "UNKNOWN" type. Print an error message to `System.err` indicating the unknown type for the given packet ID.
 * 
 * After processing (successfully or with an unknown type error), the system should record the outcome.
 * 
 * **System Requirements:**
 * 
 * 1.  **Data Structures:**
 *     *   Maintain a queue of incoming `Packet` objects waiting to be processed.
 *     *   Maintain a list of `ProcessedPacket` objects, storing the outcome of each processed packet.
 * 2.  **User Interface:** Implement a command-line interface using `Scanner` that allows the user to:
 *     *   Add a new packet to the incoming queue (requires input for id, type, payload).
 *     *   Process the next packet from the queue.
 *     *   Display the current status (number of packets in queue, number of processed packets).
 *     *   Display details of all processed packets.
 *     *   Exit the simulator.
 * 3.  **Processing Flow:** Use a `switch` statement to handle the different packet types during processing.
 * 4.  **Error Handling:**
 *     *   Use `System.err` to report errors, specifically for unknown packet types during processing and invalid user input (e.g., non-integer ID, empty type/payload, invalid menu choice).
 *     *   Implement robust exception handling using `try-catch` blocks. The processing of a packet should be wrapped in a try-catch to handle potential issues (e.g., unexpected data formats, although in this simplified model, focus on handling potential runtime errors or using it to structure error reporting). The main interaction loop should also consider handling input issues.
 * 5.  **Output:**
 *     *   Use `System.out` for normal output (menu, processing messages, status, processed packet details).
 *     *   Processed packet details display should include the original packet ID, the processing status ("SUCCESS" or "UNKNOWN_TYPE_ERROR"), and relevant information (e.g., "Processed DATA", "Processed CONTROL", "Processed ACK", or "Unknown type: [type]").
 * 6.  **Best Practices:**
 *     *   Create separate classes for `Packet` and `ProcessedPacket` with private fields and public getters (encapsulation).
 *     *   Create a main class (e.g., `PacketProcessorSimulator`) containing the queue and list, and methods for the simulation logic.
 *     *   Use meaningful variable and method names.
 *     *   Add comments to explain complex parts.
 *     *   Validate user input where necessary (e.g., ensure packet ID is an integer, type and payload are not empty).
 * 
 * **Required Java Components:**
 * 
 * Your solution *must* demonstrate the use of ALL of the following:
 * *   `java.util.Queue`
 * *   `java.util.ArrayList`
 * *   `java.util.List`
 * *   `java.util.Scanner`
 * *   `switch` statement
 * *   `System.err`
 * *   `System.out`
 * *   Class-wide exception handling with `try-catch` blocks (apply appropriate try-catch around processing logic and input handling).
 * 
 * **Expected Output Structure:**
 * 
 * ```
 * --- Packet Processor Menu ---
 * 1. Add Packet
 * 2. Process Next Packet
 * 3. Display Status
 * 4. Display Processed Packets
 * 5. Exit
 * Enter choice: 1
 * Enter Packet ID: 101
 * Enter Packet Type: DATA
 * Enter Packet Payload: Hello World
 * Packet 101 added to queue.
 * 
 * --- Packet Processor Menu ---
 * ...
 * Enter choice: 2
 * Processing packet ID: 101
 * Processed DATA payload: Hello World
 * Packet 101 processed. Status: SUCCESS. Info: Processed DATA.
 * 
 * --- Packet Processor Menu ---
 * ...
 * Enter choice: 3
 * Queue size: 0
 * Processed packets: 1
 * 
 * --- Packet Processor Menu ---
 * ...
 * Enter choice: 4
 * --- Processed Packets ---
 * ID: 101, Status: SUCCESS, Info: Processed DATA
 * -------------------------
 * 
 * --- Packet Processor Menu ---
 * ...
 * Enter choice: 1
 * Enter Packet ID: 102
 * Enter Packet Type: UNKNOWN_TYPE
 * Enter Packet Payload: Some data
 * Packet 102 added to queue.
 * 
 * --- Packet Processor Menu ---
 * ...
 * Enter choice: 2
 * Processing packet ID: 102
 * Error processing packet 102: Unknown type: UNKNOWN_TYPE
 * Packet 102 processed. Status: UNKNOWN_TYPE_ERROR. Info: Unknown type: UNKNOWN_TYPE.
 * 
 * --- Packet Processor Menu ---
 * ...
 * Enter choice: 4
 * --- Processed Packets ---
 * ID: 101, Status: SUCCESS, Info: Processed DATA
 * ID: 102, Status: UNKNOWN_TYPE_ERROR, Info: Unknown type: UNKNOWN_TYPE
 * -------------------------
 * ... (Exit)
 * ```
 * 
 * **Grading:** Your solution will be evaluated on:
 * *   Correctness of implementation based on requirements.
 * *   Proper usage of all specified Java components.
 * *   Adherence to best practices (encapsulation, naming, comments, clean structure).
 * *   Robustness of input validation and error handling.
 * 
 * Implement the complete Java code for this simulator.
 *
 * EXPLANATION:
 * This solution implements a `PacketProcessorSimulator` that simulates processing network packets, demonstrating the required Java concepts.
 * 
 * 1.  **Class Structure:**
 *     *   `Packet`: A simple class representing the data structure for an incoming packet. It uses private fields (`id`, `type`, `payload`) and public getters, adhering to encapsulation. It includes basic input validation in the constructor.
 *     *   `ProcessedPacket`: A class to store the outcome of processing a packet. It also uses private fields and public getters.
 *     *   `PacketProcessorSimulator`: The main class orchestrating the simulation. It holds the queue and list, and contains the methods for the simulation's functionality.
 * 
 * 2.  **Required Component Usage:**
 *     *   **`java.util.Queue`**: The `incomingQueue` is declared as `Queue<Packet>` and instantiated using `new LinkedList<>()`. `LinkedList` is a common implementation of the `Queue` interface, suitable for this purpose as it provides efficient `offer()` (add to end) and `poll()` (remove from front) operations.
 *     *   **`java.util.List`**: The `processedPackets` collection is declared as `List<ProcessedPacket>`. This promotes using the interface type rather than the concrete implementation in the declaration.
 *     *   **`java.util.ArrayList`**: The `processedPackets` list is instantiated using `new ArrayList<>()`. `ArrayList` is a standard implementation of `List` suitable for storing processed items and iterating over them.
 *     *   **`java.util.Scanner`**: A `Scanner` object is used in the `runSimulation` and `addPacket` methods to read user input from `System.in`.
 *     *   **`switch` statement**: Used in the `processNextPacket` method to perform different actions based on the `packetToProcess.getType()`. It handles "DATA", "CONTROL", "ACK", and a `default` case for unknown types. It's also used in `runSimulation` for the main menu navigation.
 *     *   **`System.err`**: Used to print error messages, specifically for invalid user input (in `addPacket` and `runSimulation`) and for unknown packet types encountered during processing (in `processNextPacket`).
 *     *   **`System.out`**: Used for all normal output, including the menu, prompts, success messages, status displays, and processed packet details.
 *     *   **`try-catch` blocks**: Exception handling is implemented in several places:
 *         *   In `addPacket` to catch `InputMismatchException` (if the user enters non-integer for ID) and `IllegalArgumentException` (thrown by the `Packet` constructor for invalid type/payload).
 *         *   In `processNextPacket` to wrap the core processing logic. Although this simple simulation doesn't have complex operations likely to throw exceptions *during* processing beyond what the switch handles, the `try-catch (Exception e)` demonstrates the pattern for catching unexpected runtime errors that might occur in a more complex processing scenario.
 *         *   In `runSimulation` around the main menu input reading and processing logic to handle potential `InputMismatchException` for the menu choice and general `Exception` for unforeseen issues within the loop, providing "class-wide" handling for the simulation's execution flow.
 * 
 * 3.  **Best Practices:**
 *     *   **Encapsulation:** Fields in `Packet` and `ProcessedPacket` are private, accessed via public getters.
 *     *   **Meaningful Names:** Variable names (`incomingQueue`, `processedPackets`, `packetToProcess`, `processingStatus`, etc.) and method names (`addPacket`, `processNextPacket`, `displayStatus`, `runSimulation`) are descriptive.
 *     *   **Comments:** Comments explain the purpose of classes, key methods, and specific logic sections (like the switch statement and try-catch blocks).
 *     *   **Input Validation:** Basic validation is performed for packet ID, type, and payload within the `Packet` constructor and handled with `try-catch` in `addPacket`. Menu input validation is done in `runSimulation` using `try-catch` for `InputMismatchException` and a `default` case in the menu switch.
 *     *   **Error Handling:** Errors are clearly reported using `System.err`, and the program attempts to recover gracefully from input errors or continues the simulation loop even if a packet processing error occurs.
 *     *   **Clean Code Structure:** The code is organized into logical methods within the main class, making it readable and maintainable. The `runSimulation` method provides the main loop and delegates specific tasks to other methods.
 * 
 * This solution effectively integrates all the required components into a functional simulation, demonstrating understanding of data structures, control flow, user interaction, and robust error handling in Java.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

// Represents a network packet
class Packet {
    private int id;
    private String type;
    private String payload;

    public Packet(int id, String type, String payload) {
        if (id <= 0) {
            throw new IllegalArgumentException("Packet ID must be positive.");
        }
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Packet type cannot be null or empty.");
        }
        if (payload == null) { // Payload can potentially be empty string, but not null
            throw new IllegalArgumentException("Packet payload cannot be null.");
        }
        this.id = id;
        this.type = type.trim();
        this.payload = payload;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Packet{" +
               "id=" + id +
               ", type='" + type + '\'' +
               ", payload='" + payload + '\'' +
               '}';
    }
}

// Represents the outcome of processing a packet
class ProcessedPacket {
    private int originalId;
    private String processingStatus; // e.g., "SUCCESS", "UNKNOWN_TYPE_ERROR"
    private String resultInfo;       // Detailed info about the outcome

    public ProcessedPacket(int originalId, String processingStatus, String resultInfo) {
        this.originalId = originalId;
        this.processingStatus = processingStatus;
        this.resultInfo = resultInfo;
    }

    public int getOriginalId() {
        return originalId;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    @Override
    public String toString() {
        return "ID: " + originalId +
               ", Status: " + processingStatus +
               ", Info: " + resultInfo;
    }
}

// The main class simulating the packet processor
public class PacketProcessorSimulator {

    // Use Queue interface, implemented by LinkedList
    private Queue<Packet> incomingQueue;
    // Use List interface, implemented by ArrayList
    private List<ProcessedPacket> processedPackets;
    private Scanner scanner;

    public PacketProcessorSimulator() {
        this.incomingQueue = new LinkedList<>(); // LinkedList implements Queue
        this.processedPackets = new ArrayList<>(); // ArrayList implements List
        this.scanner = new Scanner(System.in);
    }

    // Method to add a packet to the queue
    public void addPacket() {
        System.out.println("Enter Packet ID:");
        int id = -1;
        try {
            id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            System.out.println("Enter Packet Type:");
            String type = scanner.nextLine();

            System.out.println("Enter Packet Payload:");
            String payload = scanner.nextLine();

            // Input validation using Packet constructor
            Packet newPacket = new Packet(id, type, payload);
            incomingQueue.offer(newPacket); // Add to the end of the queue
            System.out.println("Packet " + newPacket.getId() + " added to queue.");

        } catch (InputMismatchException e) {
            System.err.println("Invalid input: Packet ID must be an integer.");
            scanner.nextLine(); // Consume the invalid input
        } catch (IllegalArgumentException e) {
            System.err.println("Input validation error: " + e.getMessage());
        } catch (Exception e) {
            // Catch any other unexpected errors during input
            System.err.println("An unexpected error occurred while adding packet: " + e.getMessage());
            // e.printStackTrace(); // For debugging
        }
    }

    // Method to process the next packet from the queue
    public void processNextPacket() {
        // try-catch block for class-wide exception handling during processing
        try {
            Packet packetToProcess = incomingQueue.poll(); // Get and remove head of queue

            if (packetToProcess == null) {
                System.out.println("No packets in the queue to process.");
                return;
            }

            System.out.println("Processing packet ID: " + packetToProcess.getId());

            String status;
            String info;

            // Switch statement for flow control based on packet type
            switch (packetToProcess.getType().toUpperCase()) {
                case "DATA":
                    System.out.println("Processed DATA payload: " + packetToProcess.getPayload());
                    status = "SUCCESS";
                    info = "Processed DATA";
                    break;
                case "CONTROL":
                    System.out.println("Processed CONTROL packet.");
                    status = "SUCCESS";
                    info = "Processed CONTROL";
                    break;
                case "ACK":
                    System.out.println("Processed ACK for ID: " + packetToProcess.getId());
                    status = "SUCCESS";
                    info = "Processed ACK";
                    break;
                default:
                    // Use System.err for error messages about unknown types
                    System.err.println("Error processing packet " + packetToProcess.getId() + ": Unknown type: " + packetToProcess.getType());
                    status = "UNKNOWN_TYPE_ERROR";
                    info = "Unknown type: " + packetToProcess.getType();
                    break;
            }

            // Record the outcome
            ProcessedPacket processed = new ProcessedPacket(packetToProcess.getId(), status, info);
            processedPackets.add(processed);
            System.out.println("Packet " + packetToProcess.getId() + " processed. Status: " + status + ".");

        } catch (Exception e) {
            // Catch any unexpected runtime exceptions during processing
            System.err.println("An unexpected error occurred during packet processing: " + e.getMessage());
            // e.printStackTrace(); // For debugging
            // Note: In a real system, you might want to re-queue or log the problematic packet
        }
    }

    // Method to display current status
    public void displayStatus() {
        System.out.println("Queue size: " + incomingQueue.size());
        System.out.println("Processed packets: " + processedPackets.size());
    }

    // Method to display details of processed packets
    public void displayProcessedPackets() {
        if (processedPackets.isEmpty()) {
            System.out.println("No packets have been processed yet.");
            return;
        }
        System.out.println("--- Processed Packets ---");
        for (ProcessedPacket pp : processedPackets) {
            System.out.println(pp); // Uses ProcessedPacket's toString()
        }
        System.out.println("-------------------------");
    }

    // Main simulation loop
    public void runSimulation() {
        int choice = -1;
        while (choice != 5) {
            printMenu();
            try {
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                // Switch statement for menu navigation
                switch (choice) {
                    case 1:
                        addPacket();
                        break;
                    case 2:
                        processNextPacket();
                        break;
                    case 3:
                        displayStatus();
                        break;
                    case 4:
                        displayProcessedPackets();
                        break;
                    case 5:
                        System.out.println("Exiting simulator. Goodbye!");
                        break;
                    default:
                        // Use System.err for invalid menu choices
                        System.err.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                // Use System.err for invalid input types in menu
                System.err.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                choice = -1; // Reset choice to stay in loop
            } catch (Exception e) {
                // Catch any other unexpected exceptions in the main loop
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // For debugging
            }
            System.out.println(); // Add a newline for better readability between actions
        }
        scanner.close(); // Close the scanner when exiting
    }

    // Helper method to print the menu
    private void printMenu() {
        System.out.println("--- Packet Processor Menu ---");
        System.out.println("1. Add Packet");
        System.out.println("2. Process Next Packet");
        System.out.println("3. Display Status");
        System.out.println("4. Display Processed Packets");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        PacketProcessorSimulator simulator = new PacketProcessorSimulator();
        simulator.runSimulation();
    }
}
