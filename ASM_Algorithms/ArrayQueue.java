public class ArrayQueue {
    private int capacity;
    private int[] array;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = array[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;

    }
}