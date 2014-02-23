import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test Percolation class
 */
public class TestPercolation {
    @Test
    public void testInvalidSize() {
        try {
            new Percolation(0);
            Assert.fail("Should not accept size = 0");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof IllegalArgumentException, "Should throw IllegalArgumentException");
        }
    }

    private void runOpenValid(int n, int i, int j) {
        Percolation percolation = new Percolation(n);
        try {
            percolation.open(i, j);
        } catch (Exception ex) {
            Assert.fail("Should not throw Exception");
        }
    }

    private void runOpenInvalid(int n, int i, int j) {
        Percolation percolation = new Percolation(n);
        try {
            percolation.open(i, j);
            Assert.fail("Should throw IndexOutOfBounds");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof IndexOutOfBoundsException, "Should throw IllegalArgumentException");
        }
    }

    @Test
    public void testOpenOutOfBounds() {
        runOpenInvalid(10, -1, 5);
        runOpenInvalid(10, 0, 5);
        runOpenInvalid(10, 11, 5);
        runOpenInvalid(10, 5, -1);
        runOpenInvalid(10, 5, 0);
        runOpenInvalid(10, 5, 11);
    }



    @Test
    public void testOpenValid() {
        runOpenValid(10, 10, 10);
        runOpenValid(10, 1, 1);
        runOpenValid(10, 10, 1);
        runOpenValid(10, 1, 10);
        runOpenValid(10, 2, 9);
    }

    @Test
    public void testConnect() {
        Percolation percolation = new Percolation(50);
        percolation.open(24, 23);
        Assert.assertTrue(percolation.isOpen(24, 23), "Opened site should show opened");
    }

    @Test
    public void testOneNo() {
        Percolation percolation = new Percolation(1);
        Assert.assertFalse(percolation.percolates(), "No open 1 should not percolate");
    }

    @Test
    public void testOneYes() {
        Percolation percolation = new Percolation(1);
        percolation.open(1, 1);
        Assert.assertTrue(percolation.percolates(), "No open 1 should not percolate");
    }

    @Test
    public void testCaseInput2() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input2.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
    }

    @Test
    public void testCaseInput2No() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input2-no.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertFalse(percolation.percolates(), "Should not percolate when data is complete");
    }

    @Test
    public void testCaseInput3() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input3.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
    }

    @Test
    public void testCaseInput4() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input4.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
    }

    @Test
    public void testCaseInput5() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input5.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
    }

    @Test
    public void testCaseInput6() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input6.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
        Assert.assertFalse(percolation.isFull(1,1), "Should show full after 0 open on 1,1");
    }

    @Test
    public void testCaseInput7() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input7.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
    }

    @Test
    public void testCaseInput8() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input8.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
        Assert.assertFalse(percolation.isFull(1,1), "Should show full after 0 open on 1,1");
    }

    @Test
    public void testCaseInput10() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input10.txt");
        Percolation percolation = new Percolation(reader.getSize());
        int count = 0;
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
            count++;
            if (count == 56) {
                Assert.assertFalse(percolation.isFull(9, 1), "isFull(9, 1) returns wrong value [after 56 total calls to open()]");
            }
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
    }

    @Test
    public void testCaseInput20() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input20.txt");
        Percolation percolation = new Percolation(reader.getSize());
        int count = 0;
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
            count++;
            if (count == 231) {
                Assert.assertFalse(percolation.isFull(18, 1), "isFull(18, 1) returns wrong value [after 231 total calls to open()]");
            }
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
    }

    @Test
    public void testCaseInput50() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input50.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertTrue(percolation.percolates(), "Should percolate when data is complete");
    }

    @Test
    public void testCaseInput8No() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input8-no.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertFalse(percolation.percolates(), "Should not percolate when data is complete");
        Assert.assertFalse(percolation.isFull(1, 1), "Should show full after 0 open on 1,1");
    }

    @Test
    public void testCaseInput10No() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation//input10-no.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertFalse(percolation.percolates(), "Should not percolate when data is complete");
        Assert.assertFalse(percolation.isFull(1, 1), "Should show full after 0 open on 1,1");
    }

    @Test
    public void testCaseInputGreeting() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation/greeting57.txt");
        Percolation percolation = new Percolation(reader.getSize());
        Assert.assertFalse(percolation.isFull(1,1), "Should show full after 0 open on 1,1");
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertFalse(percolation.percolates(), "Should not percolate when data is complete");
    }

    @Test
    public void testCaseInputHeart() {
        DataReader reader = new DataReader("http://coursera.cs.princeton.edu/algs4/testing/percolation/heart25.txt");
        Percolation percolation = new Percolation(reader.getSize());
        while (reader.hasNext()) {
            DataReader.Site site = reader.next();
            percolation.open(site.getI(), site.getJ());
        }
        // Done
        Assert.assertFalse(percolation.percolates(), "Should not percolate when data is complete");
        Assert.assertFalse(percolation.isFull(1,1), "Should show full after 0 open on 1,1");
    }
}
