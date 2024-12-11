public class LinkedListStack {
    private Node top;

    public LinkedListStack() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek into an empty stack");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}