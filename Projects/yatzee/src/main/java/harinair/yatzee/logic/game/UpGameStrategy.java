package harinair.yatzee.logic.game;

import harinair.yatzee.model.Die;
import harinair.yatzee.model.GameType;
import harinair.yatzee.model.PlayType;
import harinair.yatzee.model.Player;

/**
 * The Game Strategy for "Random" Game.
 * 
 * @author ugangha
 */
public class UpGameStrategy extends BaseGameStrategy implements GameStrategy {

    @Override
    public void execute(Player player, Die[] dice) {
        newRoll(dice);
        PlayType play = player.nextPlay();
        changeDice(dice);
        int score = play.getScoringStrategy().scoreFor(dice);
        player.getScoreboard().setScore(GameType.UP, play, score);
    }
}
