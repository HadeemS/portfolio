/*
 * Hadeem Secka
 */
import java.util.function.Consumer;
import java.util.function.Predicate;

class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(data);
        }
    }

    public void clear() {
        head = null;
    }

    public void forEach(Consumer<T> action) {
        Node<T> temp = head;
        while (temp != null) {
            action.accept(temp.data);
            temp = temp.next;
        }
    }

    public LinkedList<T> filter(Predicate<T> condition) {
        LinkedList<T> result = new LinkedList<>();
        Node<T> temp = head;
        while (temp != null) {
            if (condition.test(temp.data)) {
                result.add(temp.data);
            }
            temp = temp.next;
        }
        return result;
    }
}
