package velox.api.layer1.actions;

import java.util.Set;

/**
 * This class is used to register strategy actions.
 * Use it by implementing Layer1ActionMapper interface.
 */
public final class Layer1ActionsContainer {
    
    private final Set<Layer1ExternalAction> actions;
    
    /**
     * Constructor to initialize the Layer1ActionsContainer with a set of actions.
     * 
     * @param actions Set of Layer1ExternalAction objects to be registered
     */
    public Layer1ActionsContainer(Set<Layer1ExternalAction> actions) {
        this.actions = actions;
    }
    
    /**
     * Returns the set of registered actions.
     * 
     * @return Set of Layer1ExternalAction objects
     */
    public Set<Layer1ExternalAction> getActions() {
        return actions;
    }
}

/**
 * Interface for external actions that can be registered with Layer1ActionsContainer.
 * This interface should be implemented by classes that represent specific actions.
 */
public interface Layer1ExternalAction {
    // Interface methods would be defined here based on the specific requirements
    // This is a placeholder interface structure
}

/**
 * Interface for mapping Layer1 actions.
 * Implement this interface to use Layer1ActionsContainer effectively.
 */
public interface Layer1ActionMapper {
    /**
     * Maps and returns a Layer1ActionsContainer with registered actions.
     * 
     * @return Layer1ActionsContainer containing the mapped actions
     */
    Layer1ActionsContainer mapActions();
}