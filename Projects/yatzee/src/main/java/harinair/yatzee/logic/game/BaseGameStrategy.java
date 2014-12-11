package harinair.yatzee.logic.game;

import harinair.yatzee.YatzeeConfig;
import harinair.yatzee.model.Die;
import harinair.yatzee.services.InteractionManager;
import java.util.Set;

/**
 * This class contains common logic used by all other Game Strategies. This is
 * the super class for all other Game Strategies.
 * 
 * @author ugangha
 */
public class BaseGameStrategy {
    private final InteractionManager interactionManager 
            = YatzeeConfig.getInstance().getInteractionManager();

    protected InteractionManager getInteractionManager() {
        return interactionManager;
    }

    /**
     * Does an new roll of the dice and display the dice.
     * 
     * @param dice 
     */
    protected void newRoll(Die[] dice) {
        for (Die die : dice) {
            die.roll();
            interactionManager.showDie(die);
        }
    }

    /**
     * Rolls the Dice selected by player.
     * 
     * @param dice 
     */
    protected void changeDice(Die[] dice) {
        Set<Integer> choices;
        int tryCount = 0;
        do {
            tryCount++;
            choices = interactionManager.chooseDice(tryCount, dice.length);
            if (choices.size() > 0) {
                for (int choice: choices) {
                    dice[choice].roll();
                }
                for (Die die : dice) {
                    interactionManager.showDie(die);
                }
            }
        } while(choices.size() > 0 && tryCount < 2);
    }
}
