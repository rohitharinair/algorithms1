import java.util.Iterator;

/**
 * Template for the Deque in Coursera Algorithms1 / Assignment2.
 */
public class Deque<Item> implements Iterable<Item> {

    private class DequeIterator implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {
        }
    }

    public Deque() {

    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 1;
    }

    public void addFirst(Item item) {
    }

    public void addLast(Item item) {
    }

    public Item removeFirst() {
        return null;
    }

    public Item removeLast() {
        return null;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {
    }
}
