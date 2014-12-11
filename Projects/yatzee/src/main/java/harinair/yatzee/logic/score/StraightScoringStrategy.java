package harinair.yatzee.logic.score;

import harinair.yatzee.model.Die;
import java.util.Arrays;

/**
 * A Scoring Strategy that checks all the dice have sequential value.Awards
 * 50 points if they are sequential in value.
 *
 * @author ugangha
 */
public class StraightScoringStrategy implements ScoringStrategy {

    @Override
    public int scoreFor(Die[] dice) {
        int[] values = new int[dice.length];
        for (int i = 0; i < dice.length; i++) {
            values[i] = dice[i].getVal();
        }
        Arrays.sort(values);
        int prev = values[0];
        int score = 50;
        for (int i = 1; i < values.length; i++) {
            if (values[i] == prev +1) {
                prev = values[i];
            } else {
                // not straight
                score = 0;
            }
        }
        return score;
    }
}