package velox.api.layer1.actions;

import java.awt.event.KeyEvent;
import java.util.Set;

/**
 * Represents an action on which users can set shortcuts.
 * 
 * This is the most basic entity for internal usage.
 * 
 * Strategies should use Layer1ExternalAction instead to register their actions.
 */
public interface Action {
    
    /**
     * Will be triggered when a user presses shortcut associated with this action.
     * 
     * If Layer1ExternalAction instance throws an exception when it's called,
     * strategy will be unloaded.
     * 
     * @param actionId associated with the shortcut
     * @param e is standard awt key event
     * @return true means that action is processing this event
     *         and no further event transmission is required (to the next listener in the queue)
     *         because the event is handled by this action;
     *         false if the action will not handle the event
     *         (e.g. due to the fact that the focus is not on the target window, etc.),
     *         in this case the event will be passed to the next listener in the queue
     */
    boolean performAction(String actionId, KeyEvent e);
    
    /**
     * Will be triggered when a user changes shortcuts (on add, edit or remove)
     * in the Keyboard Shortcuts window.
     * 
     * Also, known shortcuts related to this action will be sent to this method
     * after the action is registered.
     * 
     * The shortcut format is a string representation obtained from the KeyStroke,
     * using KeyStroke.getKeyStrokeForEvent(java.awt.event.KeyEvent) method.
     * 
     * If Layer1ExternalAction instance throws an exception when it's called,
     * strategy will be unloaded.
     * 
     * @param actionId for which shortcut is changed
     * @param shortcuts set of shortcuts is bound to this action
     */
    default void onShortcutChanged(String actionId, Set<String> shortcuts) {
        // Default implementation - override if needed
    }
}