import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Tests the Percolation statistics.
 */
public class TestPercolationStats {
    @Test
    public void testNonNumericArguments() {
        try {
            PercolationStats.main(new String[]{"Me", "Moo"});
            Assert.fail("Should not accept non-numeric arguments.");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof IllegalArgumentException, "Should throw Illegal Argument Exception on non-numeric arguments");
        }
    }

    @Test
    public void testOutOfBoundsSize() {
        try {
            new PercolationStats(0, 5);
            Assert.fail("Should not accept size = 0.");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof IllegalArgumentException, "Should throw Illegal Argument Exception on size = 0");
        }
    }

    @Test
    public void testOutOfBoundsTimes() {
        try {
            new PercolationStats(7, 0);
            Assert.fail("Should not accept times = 0.");
        } catch (Exception ex) {
            Assert.assertTrue(ex instanceof IllegalArgumentException, "Should throw Illegal Argument Exception on times = 0");
        }
    }
}
