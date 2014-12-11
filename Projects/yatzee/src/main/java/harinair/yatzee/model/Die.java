package harinair.yatzee.model;

/**
 *
 * @author ugangha
 */
public class Die {

    private int val;

    /**
     * Rolls the Die and returns the face value.
     * 
     * @return the face value of the die
     */
    public int roll() {
        double b = Math.random();
        val = ((int) (b * 6)) + 1;
        return val;
    }

    /**
     * Gets the current face value of the die.
     * 
     * @return the face value of the die
     */
    public int getVal() {
        return val;
    }
}
