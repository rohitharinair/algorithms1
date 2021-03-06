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
public class RandomGameStrategy extends BaseGameStrategy implements GameStrategy {

    @Override
    public void execute(Player player, Die[] dice) {
        newRoll(dice);
        changeDice(dice);
        PlayType[] allPlays = PlayType.values();
        PlayType play = allPlays[((int) (Math.random() * allPlays.length)) + 1];
        getInteractionManager().showPlay(player, play);
        int score = play.getScoringStrategy().scoreFor(dice);
        player.getScoreboard().setScore(GameType.RANDOM, play, score);
    }
}