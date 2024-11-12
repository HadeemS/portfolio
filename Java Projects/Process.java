// Hadeem Secka
// Process Scheduler Program

// Process Class
public class Process {
    private String name;
    private double completionTime;

    // Default constructor
    public Process() {
        this.name = "none";
        this.completionTime = 0.0;
    }

    // Parameterized constructor
    public Process(String name, double completionTime) {
        setName(name);
        setCompletionTime(completionTime);
    }

    // Accessor for name
    public String getName() {
        return name;
    }

    // Mutator for name
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else {
            this.name = "none";
        }
    }

    // Accessor for completionTime
    public double getCompletionTime() {
        return completionTime;
    }

    // Mutator for completionTime
    public void setCompletionTime(double completionTime) {
        if (completionTime > 0) {
            this.completionTime = completionTime;
        } else {
            this.completionTime = 0.0;
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Process Name: " + name + " Completion Time: " + completionTime;
    }
}

// QueueI Interface
interface QueueI<T> {
    void enqueue(T data);  // Method to add an element
    T dequeue();           // Method to remove and return the first element
    T peek();              // Method to return the first element without removing
    void print();          // Method to print all elements
}

// LLQueue Class
public class LLQueue<T> implements QueueI<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    // Constructor
    public LLQueue() {
        head = null;
        tail = null;
    }

    // Enqueue method - adds to the end of the queue
    @Override
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Dequeue method - removes and returns the first element
    @Override
    public T dequeue() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        return data;
    }

    // Peek method - returns the first element without removing
    @Override
    public T peek() {
        return (head != null) ? head.data : null;
    }

    // Print method - prints all elements in the queue
    @Override
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

// ProcessScheduler Class
public class ProcessScheduler {
    private LLQueue<Process> processQueue;  // Queue of processes waiting to run
    private Process currentProcess;         // Currently running process

    // Constructor
    public ProcessScheduler() {
        processQueue = new LLQueue<>();
        currentProcess = null;
    }

    // Returns the currently running process
    public Process getCurrentProcess() {
        return currentProcess;
    }

    // Adds a process to the scheduler
    public void addProcess(Process process) {
        if (currentProcess == null) {
            currentProcess = process;
        } else {
            processQueue.enqueue(process);
        }
    }

    // Runs the next process in the queue
    public void runNextProcess() {
        if (currentProcess == null) {
            currentProcess = processQueue.dequeue();
        }
    }

    // Cancels the current process and replaces it with the next in the queue
    public void cancelCurrentProcess() {
        currentProcess = processQueue.dequeue();
    }

    // Prints all elements in the process queue
    public void printProcessQueue() {
        processQueue.print();
    }
}
