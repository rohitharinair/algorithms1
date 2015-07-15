import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 */
public class RandomizedQueueTest {
    @Test
    public void testRemoveEmpty() {
        RandomizedQueue<String> deque = new RandomizedQueue<String>();
        try {
            deque.dequeue();
            Assert.fail("deque() on empty deque should throw error");
        } catch (Exception ex) {
            Assert.assertTrue("NoSuchElementException expected!", ex instanceof NoSuchElementException);
        }
    }

    @Test
    public void testLots() {
        RandomizedQueue<Integer> randomQ = new RandomizedQueue<Integer>();
        for (int i = 0; i < 10000; i++) {
            randomQ.enqueue(i);
        }
        for (int i = 0; i < 9999; i++) {
            randomQ.dequeue();
        }
        Assert.assertEquals("size expected to be 1 after adding 10000 and removing 9999", 1, randomQ.size());
    }
    
    @Test
    public void testIterator() {
        RandomizedQueue<Integer> randomQ = new RandomizedQueue<Integer>();
        for (int i = 0; i < 10000; i++) {
            randomQ.enqueue(i);
        }
        int count = 0;
        for (Integer num: randomQ) {
            count++;
        }
        Assert.assertEquals("Iterator returns 10000", 10000, count);
    }
    
    @Test
    public void testRandomInsert() {
        RandomizedQueue<String> deque = new RandomizedQueue<String>();
        String[] anArray = new String[] {"Mee", "Moooo", "Mock", "Mooojo", "Muttoooo"};
        deque.enqueue(anArray[0]); // Added Mee
        deque.enqueue(anArray[1]); // Moooo, Mee
        deque.enqueue(anArray[2]); // Moooo, Mee, Mock
        deque.enqueue(anArray[4]); // Muttoooo, Moooo, Mee, Mock
        deque.enqueue(anArray[3]); // Mooojo, Muttoooo, Moooo, Mee, Mock
        Assert.assertEquals("Count expected to be 5", 5, deque.size());
        deque.dequeue(); // Mooojo (Muttoooo, Moooo, Mee, Mock)
        deque.dequeue(); // Mock (Muttoooo, Moooo, Mee)
        deque.dequeue(); // Muttooo (Moooo, Mee)
        deque.dequeue(); // Moooo (Mee)
        deque.dequeue(); // Mee ()
        Assert.assertTrue("Empty should return true", deque.isEmpty());
        try {
            deque.dequeue();
            Assert.fail("dequeue() on empty deque should throw error");
        } catch (Exception ex) {
            Assert.assertTrue("NoSuchElementException expected!", ex instanceof NoSuchElementException);
        }
    }
}