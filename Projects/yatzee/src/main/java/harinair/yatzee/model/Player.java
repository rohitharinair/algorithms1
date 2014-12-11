package harinair.yatzee.model;

import harinair.yatzee.YatzeeConfig;

/**
 * An object that represents the players of Yatzee Game.
 * 
 * @author ugangha
 */
public class Player {

    private final String name;
    private GameType currentGame;
    private int nextUpPlay = 0, nextDownPlay = 11;

    private final ScoreBoard scoreboard = new ScoreBoard();

    public Player(String name) {
        this.name = name;
    }

    /**
     * Gets the next applicable plays for Down and Up Games.
     * 
     * @return the next play
     * @throws IllegalAccessError if the game is anything other than Up and Down
     */
    public PlayType nextPlay() {
        int play = 0;
        switch(currentGame) {
            case UP:
                play = nextUpPlay; nextUpPlay++; break;
            case DOWN:
                play = nextDownPlay; nextDownPlay--; break;
            default:
                throw new IllegalAccessError("Next Play not allowed");
        }
        return PlayType.values()[play];
    }

    /**
     * Sets the current game.
     * 
     * @param currentGame the current game to set to.
     */
    public void setCurrentGame(GameType currentGame) {
        this.currentGame = currentGame;
    }

    /**
     * Starts the play (player's turn).
     * 
     * @param dice the dice to play with
     */
    public void play(Die[] dice) {
        YatzeeConfig config = YatzeeConfig.getInstance();
        config.getInteractionManager().chooseGame(this);
        currentGame.getStrategy().execute(this, dice);
    }

    /**
     * Gets the player's scoreboard.
     * 
     * @return the player's scoreboard.
     */
    public ScoreBoard getScoreboard() {
        return scoreboard;
    }

    @Override
    public String toString() {
        return name;
    }
}
