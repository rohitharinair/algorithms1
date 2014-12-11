package harinair.yatzee.model;

import harinair.yatzee.logic.score.CountBasedScoringStrategy;
import harinair.yatzee.logic.score.MaxScoringStrategy;
import harinair.yatzee.logic.score.MinScoringStrategy;
import harinair.yatzee.logic.score.ScoringStrategy;
import harinair.yatzee.logic.score.StraightScoringStrategy;
import harinair.yatzee.logic.score.SumScoringStrategy;
import harinair.yatzee.logic.score.UniqueCountBasedScoringStrategy;

/**
 * An enum to represent all possible play types.
 * 
 * @author ugangha
 */
public enum PlayType {

    ONES        ("1s       ", new CountBasedScoringStrategy(1)),
    TWOS        ("2s       ", new CountBasedScoringStrategy(2)),
    THREES      ("3s       ", new CountBasedScoringStrategy(3)),
    FOURS       ("4s       ", new CountBasedScoringStrategy(4)),
    FIVES       ("5s       ", new CountBasedScoringStrategy(5)),
    SIXES       ("6s       ", new CountBasedScoringStrategy(6)),
    MIN         ("Min      ", new MinScoringStrategy()),
    MAX         ("Max      ", new MaxScoringStrategy()),
    SUM         ("Sum      ", new SumScoringStrategy()),
    STRAIGHT    ("Straight  ", new StraightScoringStrategy()),
    FULLHOUSE   ("Full House", new UniqueCountBasedScoringStrategy(2, 50)),
    YATZEE      ("Yatzhee   ", new UniqueCountBasedScoringStrategy(1, 60));
    private final String displayName;
    private final ScoringStrategy scoringStrategy;

    private PlayType(String displayName, ScoringStrategy scoringStrategy) {
        this.displayName = displayName;
        this.scoringStrategy = scoringStrategy;
    }

    /**
     * Returns the scoring strategy for this play.
     * 
     * @return the scoring strategy (logic)
     */
    public ScoringStrategy getScoringStrategy() {
        return scoringStrategy;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
