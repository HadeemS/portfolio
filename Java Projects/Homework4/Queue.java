public class Queue<T> {
    private Object[] elements;
    private int size;
    private int front;
    private int rear;

    public Queue(int capacity) {
        elements = new Object[capacity];
        size = 0;
        front = 0;
        rear = -1;
    }

    public void enqueue(T element) {
        if (size == elements.length) {
            throw new IllegalStateException("Queue is full");
        }
        rear = (rear + 1) % elements.length;
        elements[rear] = element;
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = (T) elements[front];
        front = (front + 1) % elements.length;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
