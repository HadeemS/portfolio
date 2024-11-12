/*Hadeem Secka
 * 
 */

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    // Method to add a new element to the list
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to remove an element from the list
    public boolean remove(T data) {
        if (head == null) return false;
        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next == null) return false;

        current.next = current.next.next;
        return true;
    }

    // Method to display the elements of the list
    public void display() {
        Node<T> current = head;
        if (current == null) {
            System.out.println("No tasks in this list.");
            return;
        }
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
}

