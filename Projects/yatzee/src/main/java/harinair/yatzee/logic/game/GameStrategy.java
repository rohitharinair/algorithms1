/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harinair.yatzee.logic.game;

import harinair.yatzee.model.Die;
import harinair.yatzee.model.Player;

/**
 * Defines the contract for all Game Strategies.
 * 
 * @author ugangha
 */
public interface GameStrategy {
    /**
     * Executes the game logic.
     * 
     * @param player    the player
     * @param dice      the dice
     */
    public void execute(Player player, Die[] dice);
}
