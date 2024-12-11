import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue {

    public static void main(String[] args) {
        // Initialize the print queue
        Queue<String> printQueue = new LinkedList<>();

        // Add print jobs to the queue
        printQueue.offer("A1"); // User A prints document "A1"
        printQueue.offer("B1"); // User B prints photo "B1"
        printQueue.offer("A2"); // User A prints document "A2"

        System.out.println("Initial print queue: " + printQueue);

        // Process print jobs
        while (!printQueue.isEmpty()) {
            String job = printQueue.poll(); // Get the print job from the head of the queue
            System.out.println("Printing: " + job);
        }

        System.out.println("All print jobs completed.");
    }
}