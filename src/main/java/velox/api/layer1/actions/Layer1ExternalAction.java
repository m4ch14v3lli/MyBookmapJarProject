package velox.api.layer1.actions;

import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Represents an action that will be registered in Bookmap action system.
 * 
 * This class should be annotated with @Layer1ActionMetadata annotation(s),
 * otherwise it will be ignored.
 * 
 * External actions will be located in the Keyboard Shortcuts window
 * in Addons/strategy_name group.
 * 
 * If Layer1ExternalAction instance throws an exception when it's called,
 * strategy will be unloaded.
 */
public interface Layer1ExternalAction extends Action {
    
    /**
     * Strategy window (JComponent or JFrame) must be tagged with this property,
     * if the strategy wants to execute custom actions in the external strategy window.
     * 
     * Property value is an alias to which window belongs.
     * 
     * Usage example:
     * frame.getRootPane().putClientProperty(Layer1ExternalAction.EXTERNAL_WINDOW_ALIAS_PROPERTY, alias);
     * 
     * If your strategy doesn't have any external windows, ignore this field.
     */
    String EXTERNAL_WINDOW_ALIAS_PROPERTY = "externalWindowAlias";
    
    /**
     * Strategy window (JComponent or JFrame) must be tagged with this property,
     * if the strategy wants to execute built-in actions in the external strategy window.
     * 
     * This property works only in conjunction with EXTERNAL_WINDOW_ALIAS_PROPERTY
     * and should be set to Boolean.TRUE.
     * 
     * Trading actions will work even if an instrument is hidden.
     * 
     * Usage example:
     * frame.getRootPane().putClientProperty(Layer1ExternalAction.EXTERNAL_WINDOW_ALIAS_PROPERTY, alias);
     * frame.getRootPane().putClientProperty(Layer1ExternalAction.ALLOW_EXECUTING_BUILTIN_ACTIONS, true);
     * 
     * If your strategy doesn't have any external windows, ignore this field.
     */
    String ALLOW_EXECUTING_BUILTIN_ACTIONS = "allowExecutingBuiltinActions";
}

/**
 * Base Action interface that Layer1ExternalAction extends.
 * This interface defines the core action functionality.
 */
interface Action {
    
    /**
     * Called when the shortcut for this action is changed.
     * 
     * @param actionId The ID of the action
     * @param shortcuts Set of shortcut key combinations
     */
    void onShortcutChanged(String actionId, Set<String> shortcuts);
    
    /**
     * Performs the action when triggered.
     * 
     * @param actionId The ID of the action being performed
     * @param keyEvent The key event that triggered the action
     */
    void performAction(String actionId, KeyEvent keyEvent);
}