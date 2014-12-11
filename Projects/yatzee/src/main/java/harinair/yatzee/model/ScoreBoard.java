package harinair.yatzee.model;

import java.util.HashMap;

/**
 * An object that stores the Yatzee score board.
 * 
 * @author ugangha
 */
public class ScoreBoard {

    private final HashMap<GameType, HashMap<PlayType, Integer>> scores = new HashMap<>();

    /**
     * Constructor: initializes the score board.
     */
    public ScoreBoard() {
        for (GameType game : GameType.values()) {
            HashMap<PlayType, Integer> gameScore = new HashMap<>();
            for (PlayType play : PlayType.values()) {
                gameScore.put(play, -1);
            }
            scores.put(game, gameScore);
        }
    }
    
    /**
     * Gets the score for the game and the play.
     * 
     * @param game  the game
     * @param play  the play
     * @return      the score
     */
    public int getScore(GameType game, PlayType play) {
        return scores.get(game).get(play);
    }
    
    /**
     * Sets the score for the game and the play.
     * 
     * @param game      the game
     * @param play      the play
     * @param score     the score
     */
    public void setScore(GameType game, PlayType play, int score) {
        scores.get(game).put(play, score);
    }

}
