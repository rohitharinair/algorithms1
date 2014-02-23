import java.util.Iterator;

/**
 * Template for the RandomizedQueue in Coursera Algorithms1 / Assignment2.
 * RandomizedQueue provides a random item from the queue.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private class RandomizedQueueIterator implements Iterator<Item> {
        private RandomizedQueueIterator() {
        }

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

    public RandomizedQueue() {
    }

    private void resize(int capacity) {
    }

    private void swapItems(int source, int target) {
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 1;
    }

    public void enqueue(Item item) {
    }

    public Item dequeue() {
        return null;
    }

    public Item sample() {
        return null;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    public static void main(String[] args) {
    }
}
