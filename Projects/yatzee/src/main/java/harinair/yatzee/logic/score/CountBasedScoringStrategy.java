package harinair.yatzee.logic.score;

import harinair.yatzee.model.Die;

/**
 * A Scoring Strategy that scores based on counting of a particular value.
 * 
 * @author ugangha
 */
public class CountBasedScoringStrategy implements ScoringStrategy {
    private final int valueToCount;

    /**
     * Instantiates the Strategy.
     * 
     * @param valueToCount the value of the dice that shall be counted.
     */
    public CountBasedScoringStrategy(int valueToCount) {
        this.valueToCount = valueToCount;
    }

    @Override
    public int scoreFor(Die[] dice) {
        int score = 0;
        for (Die die : dice) {
            if (die.getVal() == valueToCount) {
                score += valueToCount;
            }
        }
        return score;
    }
}
