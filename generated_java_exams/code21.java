/*
 * Exam Question #21
 * Generated on: 2025-05-11 21:40:36
 * 
 * QUESTION:
 * **Advanced Resource Allocation System**
 * 
 * You are tasked with developing a simplified Resource Allocation System. This system manages a queue of pending tasks that require specific resources and a pool of available resources. Users interact with the system via a command-line interface to add tasks, add resources, trigger allocation, release resources, and view the system status.
 * 
 * The system must adhere to the following design and implementation requirements:
 * 
 * 1.  **Core Components:**
 *     *   A class `ResourceAllocationSystem` to encapsulate the system logic and data.
 *     *   Use `java.util.Queue` to manage the waiting tasks (First-In, First-Out).
 *     *   Use `java.util.List` and `java.util.ArrayList` to manage available and allocated resources.
 *     *   Use `java.util.Scanner` to read user commands and input from the console.
 *     *   Use a `switch` statement to process different user commands.
 *     *   Use `System.out` for all successful operations and status reporting.
 *     *   Use `System.err` for all error messages.
 *     *   Implement class-wide exception handling using `try-catch` blocks to gracefully handle unexpected issues during command processing.
 * 
 * 2.  **System Data:**
 *     *   Tasks: Each task has a unique integer ID, a description (String), and a required resource type (String).
 *     *   Resources: Each resource has a unique String ID and a type (String). Resources are either available or allocated.
 * 
 * 3.  **User Commands:** The system should accept the following commands (case-insensitive):
 *     *   `addtask <taskId> <resourceType> <description>`: Adds a new task to the waiting queue. `taskId` must be a unique integer. `description` can be multiple words.
 *     *   `addresource <resourceId> <resourceType>`: Adds a new resource to the pool of available resources. `resourceId` must be a unique string.
 *     *   `allocate`: Attempts to allocate a resource. It should take the first task from the queue, find an available resource of the matching type, allocate the resource to the task (conceptually, move the resource from available to allocated list), and remove the task from the queue. If no task is waiting or no matching resource is available, it should report an error.
 *     *   `release <resourceId>`: Releases an allocated resource specified by `resourceId`. The resource should be moved back to the available pool. If the resource is not found in the allocated pool, it should report an error.
 *     *   `status`: Prints the current state of the system: number of tasks in the queue, list of available resources (ID and type), and list of allocated resources (ID and type).
 *     *   `quit`: Exits the application.
 * 
 * 4.  **Error Handling & Validation:**
 *     *   Handle invalid command formats or missing arguments.
 *     *   Handle cases where `taskId` or `resourceId` are not unique when adding.
 *     *   Handle attempts to `allocate` when the queue is empty or no matching resource is available.
 *     *   Handle attempts to `release` a resource that is not currently allocated or doesn't exist.
 *     *   Use `System.err` for all error output.
 *     *   The main command processing loop should have a `try-catch` block to catch any unexpected exceptions and print a generic error message to `System.err` before continuing.
 * 
 * 5.  **Best Practices:**
 *     *   Use appropriate data structures as specified.
 *     *   Implement proper encapsulation (private fields, public methods).
 *     *   Use meaningful variable and method names.
 *     *   Include basic comments where necessary to explain complex logic.
 *     *   Validate user input where applicable.
 * 
 * **Expected Output:**
 * *   Successful operations should print informative messages to `System.out`.
 * *   The `status` command should print a clear summary to `System.out`.
 * *   Error conditions should print specific error messages to `System.err`.
 * *   Any uncaught exception in the command loop should print a generic error to `System.err`.
 * 
 * Implement the `ResourceAllocationSystem` class and a `main` method to run the command-line interface.
 *
 * EXPLANATION:
 * The provided solution implements the `ResourceAllocationSystem` as required, demonstrating the use of all specified Java components and adhering to best practices.
 * 
 * 1.  **Class Structure:** The system logic is encapsulated within the `ResourceAllocationSystem` class. Separate simple classes (`Task` and `Resource`) are used to model the entities, promoting data encapsulation with private fields and public getters. `equals` and `hashCode` are overridden for correct behavior in collections like `Set`.
 * 
 * 2.  **Data Structures:**
 *     *   `java.util.Queue`: A `LinkedList` (which implements `Queue`) is used for `taskQueue`. This correctly models the FIFO behavior for tasks waiting for allocation. `peek()` is used to inspect the head without removing, and `poll()` is used to remove after successful allocation.
 *     *   `java.util.List` and `java.util.ArrayList`: `ArrayList` implementations are used for `availableResources` and `allocatedResources`. These lists allow dynamic resizing and storage of resources. Iterators are used when modifying the lists during allocation/release to safely remove elements.
 *     *   `java.util.Set`: `HashSet` is used internally (`allResourceIds`, `allTaskIds`) to efficiently check for the uniqueness of IDs when adding new items, providing O(1) average time complexity for lookups.
 * 
 * 3.  **User Input (`Scanner`) and Control Flow (`switch`):** The `main` method uses a `Scanner` to read lines from `System.in`. Each line is split to determine the command and its arguments. A `while` loop keeps the system running until the `quit` command is issued. A `switch` statement is used to dispatch control to the appropriate system method based on the command string.
 * 
 * 4.  **Output Streams (`System.out`, `System.err`):**
 *     *   `System.out.println()` is used for reporting successful actions (task added, resource added, resource allocated, resource released) and for displaying the system `status`.
 *     *   `System.err.println()` is strictly used for printing error messages, such as invalid commands, validation failures (e.g., duplicate IDs, resource not found), or allocation failures.
 * 
 * 5.  **Exception Handling (`try-catch`):**
 *     *   The main command processing loop in `main` is wrapped in a `try-catch(Exception e)` block. This fulfills the requirement for class-wide exception handling, catching any unexpected runtime errors that might occur during command execution and printing a generic error message to `System.err` before the loop continues.
 *     *   Specific validation errors (like duplicate IDs or invalid numeric input) are handled more granularly. `addTask` and `addResource` throw `IllegalArgumentException` for duplicate IDs, which are caught in the `main` loop's specific `catch(IllegalArgumentException e)` block, allowing for more specific error reporting. `NumberFormatException` is caught when parsing the task ID.
 * 
 * 6.  **Core Logic (`allocateResource`, `releaseResource`):**
 *     *   `allocateResource`: Checks if the queue is empty. If not, it peeks at the first task to get its required resource type. It then iterates through the `availableResources` list using an `Iterator` to find a matching resource. Using an `Iterator` for removal is crucial when looping and modifying an `ArrayList`. If a match is found, the resource is moved to `allocatedResources`, and the task is removed from the `taskQueue` using `poll()`. Appropriate messages are printed to `System.out` or `System.err`.
 *     *   `releaseResource`: Iterates through the `allocatedResources` list using an `Iterator` to find the resource by ID. If found, it is removed from `allocatedResources` and added back to `availableResources`. Errors are reported via `System.err` if the resource is not found in the allocated list.
 * 
 * 7.  **Input Validation:** Basic validation is performed for command arguments (checking `parts.length`) and for the uniqueness of task and resource IDs using the `Set` collections. `NumberFormatException` is handled for the task ID.
 * 
 * This solution effectively integrates the required Java components into a functional system, demonstrating understanding of data structures, control flow, exception handling, and object-oriented principles like encapsulation.
 */

import java.util.*;

// Simple class to represent a Task
class Task {
    private int id;
    private String resourceType;
    private String description;

    public Task(int id, String resourceType, String description) {
        this.id = id;
        this.resourceType = resourceType;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task{" +
               "id=" + id +
               ", type='" + resourceType + '\'' +
               ", desc='" + description + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// Simple class to represent a Resource
class Resource {
    private String id;
    private String type;

    public Resource(String id, String type) {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Resource{" +
               "id='" + id + '\'' +
               ", type='" + type + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(id, resource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

// The main Resource Allocation System class
public class ResourceAllocationSystem {
    // Queue for tasks waiting for a resource
    private Queue<Task> taskQueue;
    // List for resources that are available
    private List<Resource> availableResources;
    // List for resources that are currently allocated
    private List<Resource> allocatedResources;
    // Keep track of all resources ever added to check for ID uniqueness easily
    private Set<String> allResourceIds;
    // Keep track of all tasks ever added to check for ID uniqueness easily
    private Set<Integer> allTaskIds;


    public ResourceAllocationSystem() {
        taskQueue = new LinkedList<>(); // LinkedList implements Queue
        availableResources = new ArrayList<>();
        allocatedResources = new ArrayList<>();
        allResourceIds = new HashSet<>(); // Use HashSet for efficient ID checks
        allTaskIds = new HashSet<>();
    }

    /**
     * Adds a new task to the queue.
     *
     * @param task The task to add.
     * @throws IllegalArgumentException if task ID is not unique.
     */
    public void addTask(Task task) {
        if (allTaskIds.contains(task.getId())) {
            throw new IllegalArgumentException("Task ID " + task.getId() + " already exists.");
        }
        taskQueue.add(task);
        allTaskIds.add(task.getId());
        System.out.println("Task added: " + task.getDescription());
    }

    /**
     * Adds a new resource to the available pool.
     *
     * @param resource The resource to add.
     * @throws IllegalArgumentException if resource ID is not unique.
     */
    public void addResource(Resource resource) {
        if (allResourceIds.contains(resource.getId())) {
            throw new IllegalArgumentException("Resource ID '" + resource.getId() + "' already exists.");
        }
        availableResources.add(resource);
        allResourceIds.add(resource.getId());
        System.out.println("Resource added: " + resource.getId() + " (" + resource.getType() + ")");
    }

    /**
     * Attempts to allocate a resource to the first waiting task.
     * Finds the first task in the queue, then searches for an available resource
     * of the matching type. If found, moves the resource to allocated and
     * removes the task from the queue.
     */
    public void allocateResource() {
        // Check if there are tasks waiting
        if (taskQueue.isEmpty()) {
            System.err.println("Error: No tasks waiting for allocation.");
            return;
        }

        // Get the first task without removing it yet
        Task task = taskQueue.peek();
        String requiredType = task.getResourceType();

        // Find an available resource of the required type
        Resource foundResource = null;
        Iterator<Resource> it = availableResources.iterator();
        while (it.hasNext()) {
            Resource resource = it.next();
            if (resource.getType().equalsIgnoreCase(requiredType)) {
                foundResource = resource;
                it.remove(); // Remove from available list
                break; // Found a resource, stop searching
            }
        }

        // Perform allocation if a resource was found
        if (foundResource != null) {
            allocatedResources.add(foundResource); // Move to allocated list
            taskQueue.poll(); // Remove task from queue (since allocation is successful)
            System.out.println("Allocated resource '" + foundResource.getId() + "' (" + foundResource.getType() + ") to task " + task.getId() + " (" + task.getDescription() + ")");
        } else {
            // No matching resource found
            System.err.println("Error: No available resource of type '" + requiredType + "' found for task " + task.getId() + ".");
        }
    }

    /**
     * Releases an allocated resource, moving it back to the available pool.
     *
     * @param resourceId The ID of the resource to release.
     */
    public void releaseResource(String resourceId) {
        Resource foundResource = null;
        Iterator<Resource> it = allocatedResources.iterator();
        while (it.hasNext()) {
            Resource resource = it.next();
            if (resource.getId().equals(resourceId)) {
                foundResource = resource;
                it.remove(); // Remove from allocated list
                break; // Found the resource, stop searching
            }
        }

        if (foundResource != null) {
            availableResources.add(foundResource); // Move back to available list
            System.out.println("Released resource '" + resourceId + "' (" + foundResource.getType() + ")");
        } else {
            // Resource not found in allocated list
            System.err.println("Error: Resource '" + resourceId + "' not found in allocated resources.");
        }
    }

    /**
     * Prints the current status of the system: queue, available, and allocated resources.
     */
    public void getStatus() {
        System.out.println("\n--- System Status ---");

        System.out.println("Tasks Waiting (" + taskQueue.size() + "):");
        if (taskQueue.isEmpty()) {
            System.out.println("  None");
        } else {
            // Iterate through the queue without removing elements
            for (Task task : taskQueue) {
                System.out.println("  " + task);
            }
        }

        System.out.println("Available Resources (" + availableResources.size() + "):");
        if (availableResources.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Resource res : availableResources) {
                System.out.println("  " + res);
            }
        }

        System.out.println("Allocated Resources (" + allocatedResources.size() + "):");
        if (allocatedResources.isEmpty()) {
            System.out.println("  None");
        } else {
            for (Resource res : allocatedResources) {
                System.out.println("  " + res);
            }
        }
        System.out.println("---------------------\n");
    }

    // Main method to run the command-line interface
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ResourceAllocationSystem system = new ResourceAllocationSystem();
        boolean running = true;

        System.out.println("Resource Allocation System. Type 'help' for commands.");

        while (running) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+", 4); // Split into max 4 parts: command, arg1, arg2, rest(desc)
            String command = parts[0].toLowerCase();

            // Class-wide exception handling for the command processing loop
            try {
                switch (command) {
                    case "addtask":
                        if (parts.length < 4) {
                            System.err.println("Error: addtask requires <taskId> <resourceType> <description>");
                            break;
                        }
                        try {
                            int taskId = Integer.parseInt(parts[1]);
                            String resourceType = parts[2];
                            String description = parts[3]; // The rest of the line is the description
                            system.addTask(new Task(taskId, resourceType, description));
                        } catch (NumberFormatException e) {
                            System.err.println("Error: Task ID must be an integer.");
                        }
                        break;

                    case "addresource":
                        if (parts.length < 3) {
                            System.err.println("Error: addresource requires <resourceId> <resourceType>");
                            break;
                        }
                        String resourceId = parts[1];
                        String resourceType = parts[2];
                        system.addResource(new Resource(resourceId, resourceType));
                        break;

                    case "allocate":
                        if (parts.length > 1) {
                             System.err.println("Error: allocate command takes no arguments.");
                             break;
                        }
                        system.allocateResource();
                        break;

                    case "release":
                        if (parts.length < 2) {
                            System.err.println("Error: release requires <resourceId>");
                            break;
                        }
                        String idToRelease = parts[1];
                        system.releaseResource(idToRelease);
                        break;

                    case "status":
                         if (parts.length > 1) {
                             System.err.println("Error: status command takes no arguments.");
                             break;
                         }
                        system.getStatus();
                        break;

                    case "quit":
                        running = false;
                        System.out.println("Exiting system. Goodbye!");
                        break;

                    case "help":
                        System.out.println("Available commands:");
                        System.out.println("  addtask <taskId> <resourceType> <description>");
                        System.out.println("  addresource <resourceId> <resourceType>");
                        System.out.println("  allocate");
                        System.out.println("  release <resourceId>");
                        System.out.println("  status");
                        System.out.println("  quit");
                        break;

                    case "": // Handle empty input
                         break;

                    default:
                        System.err.println("Error: Unknown command '" + command + "'. Type 'help' for commands.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                 // Catch specific validation errors thrown by methods
                 System.err.println("Validation Error: " + e.getMessage());
            } catch (Exception e) {
                // Catch any other unexpected exceptions
                System.err.println("An unexpected error occurred: " + e.getMessage());
                // e.printStackTrace(); // Uncomment for debugging
            }
        }

        scanner.close();
    }
}
