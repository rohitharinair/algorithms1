import junit.framework.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 */
public class DequeTest {
    @Test
    public void testAddFirst() {
        Deque<String> deque = new Deque<String>();
        try {
            deque.addFirst(null);
            Assert.fail("addFirst(null) should throw error");
        } catch (Exception ex) {
            Assert.assertTrue("NPE expected!", ex instanceof NullPointerException);
        }
        try {
            deque.addLast(null);
            Assert.fail("addLast(null) should throw error");
        } catch (Exception ex) {
            Assert.assertTrue("NPE expected!", ex instanceof NullPointerException);
        }
    }

    @Test
    public void testRemoveEmpty() {
        Deque<String> deque = new Deque<String>();
        try {
            deque.removeFirst();
            Assert.fail("removeFirst() on empty deque should throw error");
        } catch (Exception ex) {
            Assert.assertTrue("NoSuchElementException expected!", ex instanceof NoSuchElementException);
        }
        try {
            deque.removeLast();
            Assert.fail("removeLast() on empty deque should throw error");
        } catch (Exception ex) {
            Assert.assertTrue("NoSuchElementException expected!", ex instanceof NoSuchElementException);
        }
    }

    @Test
    public void testInsert() {
        Deque<String> deque = new Deque<String>();
        String toAdd = "Some to add";
        deque.addFirst(toAdd);
        String removed = deque.removeFirst();
        Assert.assertEquals("Inserted on front item should be removed", toAdd, removed);
        deque.addLast(toAdd);
        removed = deque.removeFirst();
        Assert.assertEquals("Inserted on back item should be removed", toAdd, removed);
        try {
            deque.removeFirst();
            Assert.fail("removeFirst() on empty deque should throw error");
        } catch (Exception ex) {
            Assert.assertTrue("NoSuchElementException expected!", ex instanceof NoSuchElementException);
        }
    }

    @Test
    public void testRandomInsert() {
        Deque<String> deque = new Deque<String>();
        String[] anArray = new String[] {"Mee", "Moooo", "Mock", "Mooojo", "Muttoooo"};
        deque.addFirst(anArray[0]); // Added Mee
        deque.addFirst(anArray[1]); // Moooo, Mee
        deque.addLast(anArray[2]); // Moooo, Mee, Mock
        deque.addFirst(anArray[4]); // Muttoooo, Moooo, Mee, Mock
        deque.addFirst(anArray[3]); // Mooojo, Muttoooo, Moooo, Mee, Mock
        Assert.assertEquals("Count expected to be 5", deque.size(), 5);
        String[] removedArray = new String[5];
        removedArray[0] = deque.removeFirst(); // Mooojo (Muttoooo, Moooo, Mee, Mock)
        Assert.assertEquals("Expected Mooojo", removedArray[0], anArray[3]);
        removedArray[1] = deque.removeLast(); // Mock (Muttoooo, Moooo, Mee)
        Assert.assertEquals("Expected Mock", removedArray[1], anArray[2]);
        removedArray[2] = deque.removeFirst(); // Muttooo (Moooo, Mee)
        Assert.assertEquals("Expected Muttooo", removedArray[2], anArray[4]);
        removedArray[3] = deque.removeFirst(); // Moooo (Mee)
        Assert.assertEquals("Expected Mooo", removedArray[3], anArray[1]);
        removedArray[4] = deque.removeLast(); // Mee ()
        Assert.assertEquals("Expected Mee", removedArray[4], anArray[0]);
        Assert.assertTrue("Expected empty deque", deque.isEmpty());
        try {
            deque.removeLast();
            Assert.fail("removeFirst() on empty deque should throw error");
        } catch (Exception ex) {
            Assert.assertTrue("NoSuchElementException expected!", ex instanceof NoSuchElementException);
        }
    }

    @Test
    public void testIterator() {
        Deque<String> deque = new Deque<String>();
        String[] anArray = new String[] {"Mee", "Moooo", "Mock", "Mooojo", "Muttoooo"};
        for (String item: anArray) {
            deque.addLast(item);
        }
        Iterator<String> iterator1 = deque.iterator();
        Iterator<String> iterator2 = deque.iterator();
        int firstCount = 0;
        while (iterator2.hasNext()) {
            String item = iterator2.next();
            Assert.assertEquals("Not expected element", item, anArray[firstCount++]);
            if (firstCount == 3) {
                // Let us run the next iterator in middle of first
                int secondCount = 0;
                while (iterator1.hasNext()) {
                    String word = iterator1.next();
                    Assert.assertEquals("Not expected element - iterator2", word, anArray[secondCount++]);
                }
            }
        }
        try {
            iterator2.next();
            Assert.fail("Expected exception at end of iterator");
        } catch (Exception ex) {
            Assert.assertTrue("Expected NoSuchElementException", ex instanceof NoSuchElementException);
        }
        try {
            iterator1.next();
            Assert.fail("Expected exception at end of iterator");
        } catch (Exception ex) {
            Assert.assertTrue("Expected NoSuchElementException", ex instanceof NoSuchElementException);
        }
    }
}
