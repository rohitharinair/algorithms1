package harinair.yatzee.model;

import harinair.yatzee.logic.game.GameStrategy;
import harinair.yatzee.logic.game.NoOpGameStrategy;

/**
 * An enum to save all the possible game types.
 * 
 * @author ugangha
 */
public enum GameType {
    UP("Up"),
    DOWN("Down"),
    RANDOM("Random"),
    CALL_BEFORE("CallBefore"),
    CALL_AFTER("CallAfter");
    private final String displayName;

    private GameType(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Creates a strategy for this game.
     *
     * @return a strategy (logic) for this game
     */
    public GameStrategy getStrategy() {
        String className = "harinair.yatzee.logic.game." + toString() + "GameStrategy";
        GameStrategy gameStrategy = null;
        try {
            Class<?> claz = Class.forName(className);
            gameStrategy = (GameStrategy) claz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            // ignore
        }
        if (gameStrategy == null) {
            gameStrategy = new NoOpGameStrategy();
        }
        return gameStrategy;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}