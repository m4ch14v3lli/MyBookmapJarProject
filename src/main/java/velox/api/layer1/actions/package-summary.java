package velox.api.layer1.actions;

import velox.api.layer1.messages.Layer1ApiShowShortcutPanelMessage;

/**
 * Represents an action on which users can set shortcuts.
 */
public interface Action {
    /**
     * Gets the unique identifier for this action.
     * @return the action ID
     */
    String getId();
    
    /**
     * Gets the display name for this action.
     * @return the action name
     */
    String getName();
    
    /**
     * Gets the description of this action.
     * @return the action description
     */
    String getDescription();
    
    /**
     * Executes the action.
     */
    void execute();
    
    /**
     * Checks if the action is currently enabled.
     * @return true if enabled, false otherwise
     */
    boolean isEnabled();
}

/**
 * Keys to the actions that can be used as a path in Layer1ApiShowShortcutPanelMessage.groups
 */
public class ActionConstants {
    
    public static final String TRADING_ACTIONS = "trading.actions";
    public static final String CHART_ACTIONS = "chart.actions";
    public static final String ORDER_ACTIONS = "order.actions";
    public static final String POSITION_ACTIONS = "position.actions";
    public static final String STRATEGY_ACTIONS = "strategy.actions";
    public static final String VIEW_ACTIONS = "view.actions";
    public static final String MARKET_DATA_ACTIONS = "market.data.actions";
    public static final String EXECUTION_ACTIONS = "execution.actions";
    public static final String SETTINGS_ACTIONS = "settings.actions";
    public static final String CUSTOM_ACTIONS = "custom.actions";
    
    private ActionConstants() {
        // Utility class - prevent instantiation
    }
}

/**
 * Implement this interface if a strategy wants to register external actions
 * Layer1ExternalAction in Bookmap action system.
 * 
 * Bookmap looks for this interface when loading strategies.
 */
public interface Layer1ActionMapper {
    
    /**
     * Called by Bookmap to register actions from the strategy.
     * @param container the actions container to register actions with
     */
    void registerActions(Layer1ActionsContainer container);
    
    /**
     * Gets the group name for the actions registered by this mapper.
     * @return the group name
     */
    String getActionGroup();
    
    /**
     * Called when the action mapper is being unloaded.
     */
    default void onUnload() {
        // Default implementation does nothing
    }
}

/**
 * This class is used to register strategy actions.
 */
public class Layer1ActionsContainer {
    
    private final java.util.Map<String, Layer1ExternalAction> actions;
    private final java.util.Map<String, String> actionGroups;
    
    public Layer1ActionsContainer() {
        this.actions = new java.util.HashMap<>();
        this.actionGroups = new java.util.HashMap<>();
    }
    
    /**
     * Registers an external action with the container.
     * @param action the action to register
     */
    public void registerAction(Layer1ExternalAction action) {
        if (action == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }
        actions.put(action.getId(), action);
    }
    
    /**
     * Registers an action with a specific group.
     * @param action the action to register
     * @param group the group to assign the action to
     */
    public void registerAction(Layer1ExternalAction action, String group) {
        registerAction(action);
        actionGroups.put(action.getId(), group);
    }
    
    /**
     * Unregisters an action from the container.
     * @param actionId the ID of the action to unregister
     */
    public void unregisterAction(String actionId) {
        actions.remove(actionId);
        actionGroups.remove(actionId);
    }
    
    /**
     * Gets an action by its ID.
     * @param actionId the action ID
     * @return the action, or null if not found
     */
    public Layer1ExternalAction getAction(String actionId) {
        return actions.get(actionId);
    }
    
    /**
     * Gets all registered actions.
     * @return a map of action IDs to actions
     */
    public java.util.Map<String, Layer1ExternalAction> getAllActions() {
        return new java.util.HashMap<>(actions);
    }
    
    /**
     * Gets the group for a specific action.
     * @param actionId the action ID
     * @return the group name, or null if not assigned
     */
    public String getActionGroup(String actionId) {
        return actionGroups.get(actionId);
    }
    
    /**
     * Gets all actions in a specific group.
     * @param group the group name
     * @return a list of actions in the group
     */
    public java.util.List<Layer1ExternalAction> getActionsInGroup(String group) {
        java.util.List<Layer1ExternalAction> result = new java.util.ArrayList<>();
        for (java.util.Map.Entry<String, String> entry : actionGroups.entrySet()) {
            if (group.equals(entry.getValue())) {
                Layer1ExternalAction action = actions.get(entry.getKey());
                if (action != null) {
                    result.add(action);
                }
            }
        }
        return result;
    }
    
    /**
     * Clears all registered actions.
     */
    public void clear() {
        actions.clear();
        actionGroups.clear();
    }
}

/**
 * Represents an action that will be registered in Bookmap action system.
 */
public interface Layer1ExternalAction extends Action {
    
    /**
     * Gets the category this action belongs to.
     * @return the action category
     */
    String getCategory();
    
    /**
     * Gets the keyboard shortcut for this action.
     * @return the shortcut string (e.g., "Ctrl+Alt+T")
     */
    String getShortcut();
    
    /**
     * Sets the keyboard shortcut for this action.
     * @param shortcut the shortcut string
     */
    void setShortcut(String shortcut);
    
    /**
     * Gets the icon path for this action.
     * @return the icon path, or null if no icon
     */
    String getIconPath();
    
    /**
     * Checks if this action should be visible in menus.
     * @return true if visible, false otherwise
     */
    boolean isVisibleInMenu();
    
    /**
     * Checks if this action should be visible in toolbars.
     * @return true if visible, false otherwise
     */
    boolean isVisibleInToolbar();
    
    /**
     * Gets the priority of this action for ordering purposes.
     * @return the priority value (lower values = higher priority)
     */
    int getPriority();
    
    /**
     * Called when the action is registered with Bookmap.
     */
    default void onRegister() {
        // Default implementation does nothing
    }
    
    /**
     * Called when the action is unregistered from Bookmap.
     */
    default void onUnregister() {
        // Default implementation does nothing
    }
}