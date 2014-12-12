package harinair.yatzee.services;

import harinair.yatzee.model.Die;
import harinair.yatzee.model.PlayType;
import harinair.yatzee.model.Player;
import java.util.Set;

/**
 * In Interface to define contracts for interaction with the players.
 * 
 * @author ugangha
 */
public interface InteractionManager {

    /**
     * Prompts the player to choose a Game viz. Up, Down, Call or Random.
     * 
     * @param player the player
     */
    void chooseGame(Player player);
    
    /**
     * Choose the play. Applicable only for the Call or Random Games.
     * 
     * @param player the player
     * @return the play chosen
     */
    PlayType choosePlay(Player player);
    
    /**
     * Prompts the players for their name.
     * @param playerNum the number of the player
     * @return the name entered by the player
     */
    String choosePlayerName(int playerNum);
    
    /**
     * Handles the cases where there is No game selected.
     */
    void handleNoGameStrategy();
    
    /**
     * Shows the die.
     * 
     * @param die the die to show
     */
    void showDie(Die die);
    
    /**
     * Let players choose the dice for rolling again.
     * 
     * @param tryCount  the count of the current try
     * @param count     the number of dice
     * @return a set of integers representing the dice chosen
     */
    Set<Integer> chooseDice(int tryCount, int count);
    
    /**
     * Starts the play by displaying the information.
     * 
     * @param player the player
     */
    void startPlay(Player player);
    
    /**
     * Shows the score board of the player.
     */
    void showScoreBoard(Player player);
    
    /**
     * Tells player what computer chose for him.
     * @param player the player
     * @param play the play chosen
     */
    void showPlay(Player player, PlayType play);
}
