package harinair.yatzee;

import harinair.yatzee.services.ConsoleInterationManager;
import harinair.yatzee.services.InteractionManager;

/**
 * Contains the global Yatzee Configuration Singleton.
 * 
 * @author ugangha
 */
public class YatzeeConfig {
    private static final class InstanceHolder {
        private static final YatzeeConfig INSTACE = new YatzeeConfig();
    }
    
    private final InteractionManager interactionManager = new ConsoleInterationManager();
    
    /**
     * Singleton class - constructor marked private.
     */
    private YatzeeConfig() {
    }
    

    /**
     * Returns the only instance of this class.
     * 
     * @return the only instance of the YatzeeConfig
     */
    public static YatzeeConfig getInstance() {
        return InstanceHolder.INSTACE;
    }

    /**
     * Returns the interaction manager used in this application.
     * 
     * @return the interaction manager
     */
    public InteractionManager getInteractionManager() {
        return interactionManager;
    }
}
