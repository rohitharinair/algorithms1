package harinair.yatzee.logic.score;

import harinair.yatzee.model.Die;
import java.util.HashSet;

/**
 * A Scoring Strategy that awards given score for having a specific number of
 * unique values.
 *
 * @author ugangha
 */
public class UniqueCountBasedScoringStrategy implements ScoringStrategy {
    private final int uniqueItemCount;
    private final int scoreToAward;

    /**
     * Constructor to initialize.
     * 
     * @param uniqueItemCount   the number of unique values
     * @param scoreToAward      score to award if condition is met
     */
    public UniqueCountBasedScoringStrategy(int uniqueItemCount, int scoreToAward) {
        this.uniqueItemCount = uniqueItemCount;
        this.scoreToAward = scoreToAward;
    }

    @Override
    public int scoreFor(Die[] dice) {
        int score = 0;
        HashSet<Integer> uniqueItemSet = new HashSet<>();
        for (Die die: dice) {
            uniqueItemSet.add(die.getVal());
        }
        if (uniqueItemSet.size() == uniqueItemCount) {
            score = scoreToAward;
        }
        return score;
    }
}
