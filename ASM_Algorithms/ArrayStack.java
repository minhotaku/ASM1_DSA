public class ArrayStack {
    private final int capacity;
    private final int[] array;
    private int top;

    public ArrayStack(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public void push(int data) {
        if (top == capacity - 1) {
            throw new StackOverflowError("Stack is full");
        }
        array[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        return array[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
