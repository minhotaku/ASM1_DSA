public class LinkedListQueue {
    private Node front;
    private Node rear;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }

    public boolean isEmpty() {
        return front == null;
    }
}