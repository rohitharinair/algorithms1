/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package harinair.yatzee.logic.game;

import harinair.yatzee.YatzeeConfig;
import harinair.yatzee.model.Die;
import harinair.yatzee.model.Player;
import harinair.yatzee.services.InteractionManager;

/**
 * This is a No Operation Game Strategy that gets invoked on error conditions.
 * This class should not be used normally.
 * 
 * @author ugangha
 */
public class NoOpGameStrategy implements GameStrategy {
    private final InteractionManager interactionManager 
            = YatzeeConfig.getInstance().getInteractionManager();

    @Override
    public void execute(Player player, Die[] dice) {
        interactionManager.handleNoGameStrategy();
    }
}
