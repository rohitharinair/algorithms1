package harinair.yatzee.logic.score;

import harinair.yatzee.model.Die;

/**
 * A Scoring Strategy that uses the max value in the dice to score.
 *
 * @author ugangha
 */
public class MaxScoringStrategy implements ScoringStrategy {

    @Override
    public int scoreFor(Die[] dice) {
        int score = 0;
        for (Die die : dice) {
            if (die.getVal() > score) {
                score = die.getVal();
            }
        }
        return score;
    }
}
