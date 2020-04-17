import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private int n;
    private Node head;
    private Node tail;

    private class Node {
        Item value;
        Node next;
        Node prev;

        Node(Item val) {
            this.value = val;
        }
    }

    public Deque() {
        n = 0;
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void addFirst(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Null Item can't be added ");
        else if (n == 0) {
            Node temp = new Node(item);
            head = temp;
            tail = temp;
            n++;

        } else {
            Node node = new Node(item);
            Node current = head;
            current.prev = node;
            node.next = current;
            node.prev = null;
            head = node;
            n++;

        }

    }

    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Null Item can't be added ");
        else if (n == 0) {
            Node temp = new Node(item);
            head = temp;
            tail = temp;
            n++;

        } else {
            Node node = new Node(item);
            Node current = tail;

            current.next = node;
            node.prev = current;
            node.next = null;
            tail = node;
            n++;

        }
    }

    public Item removeFirst() {
        if (n == 0) {
            throw new java.util.NoSuchElementException("This deque is empty");
        }
        Item item = head.value;
        head = head.next;
        n--;
        return item;
    }

    public Item removeLast() {
        if (n == 0) {
            throw new java.util.NoSuchElementException("This deque is empty");
        }
        Item item = tail.value;
        tail = tail.prev;
        n--;
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ItemsIterator();
    }

    private class ItemsIterator implements Iterator<Item> {
        private Node current;

        public ItemsIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null)
                throw new java.util.NoSuchElementException();

            Item item = current.value;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException("Unsupported Operation");
        }
    }

    public static void main(String[] args) {
        // This body is not empty
        /* This method is not empty */

    }

}
