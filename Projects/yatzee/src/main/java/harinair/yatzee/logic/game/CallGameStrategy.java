package harinair.yatzee.logic.game;

import harinair.yatzee.model.Die;
import harinair.yatzee.model.GameType;
import harinair.yatzee.model.PlayType;
import harinair.yatzee.model.Player;

/**
 * Contains the logic for a "Call" Game.
 * 
 * @author ugangha
 */
public class CallGameStrategy extends BaseGameStrategy implements GameStrategy {

    @Override
    public void execute(Player player, Die[] dice) {
        PlayType play = getInteractionManager().choosePlay(player);
        newRoll(dice);
        changeDice(dice);
        int score = play.getScoringStrategy().scoreFor(dice);
        player.getScoreboard().setScore(GameType.CALL, play, score);
    }
}
