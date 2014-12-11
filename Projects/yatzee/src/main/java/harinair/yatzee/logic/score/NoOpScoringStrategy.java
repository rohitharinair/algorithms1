package harinair.yatzee.logic.score;

import harinair.yatzee.model.Die;

/**
 * An empty No Op Scoring Strategy that just awards 200 points. Not used in
 * real application. It is here only to handle error cases.
 * 
 * @author ugangha
 */
public class NoOpScoringStrategy implements ScoringStrategy {

    @Override
    public int scoreFor(Die[] dice) {
        return 200;
    }
}
