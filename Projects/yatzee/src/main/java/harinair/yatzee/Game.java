package harinair.yatzee;

import harinair.yatzee.model.Die;
import harinair.yatzee.model.Player;
import harinair.yatzee.services.InteractionManager;
import java.util.ArrayList;

/**
 * The main game class. This represents the Yatzee Game.
 * 
 * @author ugangha
 */
public class Game {

    /**
     * The players in this game.
     */
    private final ArrayList<Player> players;
    
    /**
     * Global configuration singleton.
     */
    private final YatzeeConfig config = YatzeeConfig.getInstance();

    /**
     * The interaction manager is used to interact with the players.
     */
    private final InteractionManager interactionManager = config.getInteractionManager();

    /**
     * The dice used in this game. It is made up of 5 dice.
     */
    private final Die[] dice = new Die[]{
        new Die(),
        new Die(),
        new Die(),
        new Die(),
        new Die()
    };

    public Game() {
        players = new ArrayList<>();
        do {
            Player player = new Player(interactionManager.choosePlayerName(players.size()));
            players.add(player);
        } while (players.size() < 2);
    }

    public void play() {
        for (int i = 0; i < 10; i++) {
            for (Player player : players) {
                interactionManager.startPlay(player);
                player.play(dice);
                interactionManager.showScoreBoard(player);
            }
        }
    }

    public static void main(String[] args) {
        Game yahtzeeGame = new Game();
        yahtzeeGame.play();
    }

}
