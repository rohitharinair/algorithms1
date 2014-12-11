package harinair.yatzee.logic.score;

import harinair.yatzee.model.Die;

/**
 * A Scoring Strategy that uses the sum of the value in the dice.
 *
 * @author ugangha
 */
public class SumScoringStrategy implements ScoringStrategy {

    @Override
    public int scoreFor(Die[] dice) {
        int score = 0;
        for (Die die : dice) {
            score += die.getVal();
        }
        return score;
    }
}