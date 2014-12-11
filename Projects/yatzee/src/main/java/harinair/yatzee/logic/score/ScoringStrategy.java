package harinair.yatzee.logic.score;

import harinair.yatzee.model.Die;

/**
 * An interface that will be implemented by all scoring strategies. Each play
 * may be using a scoring strategy.
 * 
 * @author ugangha
 */
public interface ScoringStrategy {
    /**
     * The implementing class will calculate the score for the dice combination
     * provided.
     * 
     * @param dice the dice
     * @return the score for the dice combination
     */
    public int scoreFor(Die[] dice);
}
