package velox.api.layer1.actions;

/**
 * Implement this interface if a strategy wants to register external actions
 * Layer1ExternalAction in Bookmap action system.
 * 
 * Bookmap looks for this interface when loading strategies.
 * Once it is found, getActionsContainer() method will be called.
 */
public interface Layer1ActionMapper {
    
    /**
     * It's the entry point for action registration.
     * 
     * @return Layer1ActionsContainer instance that contains action list
     */
    Layer1ActionsContainer getActionsContainer();
}

/**
 * Container class that holds action list for Layer1ActionMapper
 */
public class Layer1ActionsContainer {
    
    private java.util.List<Layer1ExternalAction> actions;
    
    public Layer1ActionsContainer() {
        this.actions = new java.util.ArrayList<>();
    }
    
    /**
     * Add an external action to the container
     * 
     * @param action the external action to add
     */
    public void addAction(Layer1ExternalAction action) {
        if (action != null) {
            actions.add(action);
        }
    }
    
    /**
     * Get all actions in the container
     * 
     * @return list of external actions
     */
    public java.util.List<Layer1ExternalAction> getActions() {
        return new java.util.ArrayList<>(actions);
    }
    
    /**
     * Remove an action from the container
     * 
     * @param action the action to remove
     * @return true if action was removed, false otherwise
     */
    public boolean removeAction(Layer1ExternalAction action) {
        return actions.remove(action);
    }
    
    /**
     * Clear all actions from the container
     */
    public void clearActions() {
        actions.clear();
    }
    
    /**
     * Get the number of actions in the container
     * 
     * @return number of actions
     */
    public int getActionCount() {
        return actions.size();
    }
    
    /**
     * Check if the container is empty
     * 
     * @return true if no actions are present
     */
    public boolean isEmpty() {
        return actions.isEmpty();
    }
}

/**
 * Interface for external actions that can be registered in Bookmap action system
 */
public interface Layer1ExternalAction {
    
    /**
     * Get the name of the action
     * 
     * @return action name
     */
    String getActionName();
    
    /**
     * Execute the action
     */
    void executeAction();
    
    /**
     * Check if the action is enabled
     * 
     * @return true if action is enabled
     */
    boolean isEnabled();
    
    /**
     * Enable or disable the action
     * 
     * @param enabled true to enable, false to disable
     */
    void setEnabled(boolean enabled);
    
    /**
     * Get the action description
     * 
     * @return action description
     */
    String getDescription();
}

/**
 * Abstract base class for implementing Layer1ExternalAction
 */
public abstract class AbstractLayer1ExternalAction implements Layer1ExternalAction {
    
    private String actionName;
    private String description;
    private boolean enabled;
    
    protected AbstractLayer1ExternalAction(String actionName, String description) {
        this.actionName = actionName;
        this.description = description;
        this.enabled = true;
    }
    
    @Override
    public String getActionName() {
        return actionName;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    /**
     * Abstract method that must be implemented by subclasses
     */
    @Override
    public abstract void executeAction();
}

/**
 * Example implementation of Layer1ActionMapper
 */
public class ExampleActionMapper implements Layer1ActionMapper {
    
    private Layer1ActionsContainer container;
    
    public ExampleActionMapper() {
        this.container = new Layer1ActionsContainer();
        initializeActions();
    }
    
    private void initializeActions() {
        // Add example actions
        container.addAction(new ExampleExternalAction("Sample Action", "This is a sample action"));
    }
    
    @Override
    public Layer1ActionsContainer getActionsContainer() {
        return container;
    }
    
    /**
     * Example implementation of Layer1ExternalAction
     */
    private static class ExampleExternalAction extends AbstractLayer1ExternalAction {
        
        public ExampleExternalAction(String actionName, String description) {
            super(actionName, description);
        }
        
        @Override
        public void executeAction() {
            System.out.println("Executing action: " + getActionName());
            // Implement your action logic here
        }
    }
}