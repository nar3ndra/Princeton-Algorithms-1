import java.util.Iterator;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int n;
    private int lastLoc;
    private Item[] arr;

    public RandomizedQueue() {
        this.n = 0;
        this.lastLoc = 0;
        arr = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("Item can't be null");

        if (n == arr.length) {
            enlarge(2 * n);
        }
        arr[n++] = item;
        lastLoc = n;

    }

    public Item dequeue() {
        if (n == 0)
            throw new java.util.NoSuchElementException("This queue is empty");
        if (n > 0 && n <= n / 4)
            enlarge(n / 2);
        int rand = StdRandom.uniform(n);

        Item item = arr[rand];
        arr[rand] = arr[lastLoc];
        lastLoc--;
        n--;
        return item;

    }

    private void enlarge(int newSize) {
        Item[] temp = (Item[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        arr = temp;

    }

    public Item sample() {
        if (n == 0)
            throw new java.util.NoSuchElementException("This queue is empty");
        int rand = StdRandom.uniform(n);
        return arr[rand];

    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {
        int n2;
        int lastLoc2;
        Item[] arr2;

        RandomIterator() {
            n2 = n;
            lastLoc2 = lastLoc;
            arr2 = arr;
        }

        @Override
        public boolean hasNext() {

            return n2 != 0;
        }

        @Override
        public Item next() {
            if (n2 == 0)
                throw new java.util.NoSuchElementException("This is empty");
            int rand = StdRandom.uniform(n2);

            Item item = arr2[rand];
            arr2[rand] = arr2[lastLoc2];
            this.lastLoc2--;
            n2--;
            return item;

        }

        public void remove(Item item) {
            throw new UnsupportedOperationException("this is not supported");
        }

    }

    public static void main(String[] args) {
        // This method is not empty
        /* This method is not empty */

    }
}
