package velox.api.layer1.actions;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Container class for managing Layer1 actions
 */
public class Layer1ActionsContainer {
    
    private final Map<String, Action> actions;
    private final Map<String, Layer1ActionMapper> mappers;
    
    public Layer1ActionsContainer() {
        this.actions = new ConcurrentHashMap<>();
        this.mappers = new ConcurrentHashMap<>();
    }
    
    /**
     * Register an action with the container
     * @param actionId the unique identifier for the action
     * @param action the action to register
     */
    public void registerAction(String actionId, Action action) {
        if (actionId == null || action == null) {
            throw new IllegalArgumentException("Action ID and action cannot be null");
        }
        actions.put(actionId, action);
    }
    
    /**
     * Get an action by its ID
     * @param actionId the action identifier
     * @return the action, or null if not found
     */
    public Action getAction(String actionId) {
        return actions.get(actionId);
    }
    
    /**
     * Register an action mapper
     * @param mapperId the unique identifier for the mapper
     * @param mapper the mapper to register
     */
    public void registerMapper(String mapperId, Layer1ActionMapper mapper) {
        if (mapperId == null || mapper == null) {
            throw new IllegalArgumentException("Mapper ID and mapper cannot be null");
        }
        mappers.put(mapperId, mapper);
    }
    
    /**
     * Get a mapper by its ID
     * @param mapperId the mapper identifier
     * @return the mapper, or null if not found
     */
    public Layer1ActionMapper getMapper(String mapperId) {
        return mappers.get(mapperId);
    }
    
    /**
     * Get all registered actions
     * @return collection of all actions
     */
    public Collection<Action> getAllActions() {
        return actions.values();
    }
    
    /**
     * Get all registered mappers
     * @return collection of all mappers
     */
    public Collection<Layer1ActionMapper> getAllMappers() {
        return mappers.values();
    }
    
    /**
     * Remove an action by its ID
     * @param actionId the action identifier
     * @return the removed action, or null if not found
     */
    public Action removeAction(String actionId) {
        return actions.remove(actionId);
    }
    
    /**
     * Remove a mapper by its ID
     * @param mapperId the mapper identifier
     * @return the removed mapper, or null if not found
     */
    public Layer1ActionMapper removeMapper(String mapperId) {
        return mappers.remove(mapperId);
    }
    
    /**
     * Clear all actions and mappers
     */
    public void clear() {
        actions.clear();
        mappers.clear();
    }
    
    /**
     * Check if an action exists
     * @param actionId the action identifier
     * @return true if the action exists, false otherwise
     */
    public boolean hasAction(String actionId) {
        return actions.containsKey(actionId);
    }
    
    /**
     * Check if a mapper exists
     * @param mapperId the mapper identifier
     * @return true if the mapper exists, false otherwise
     */
    public boolean hasMapper(String mapperId) {
        return mappers.containsKey(mapperId);
    }
    
    /**
     * Get the number of registered actions
     * @return the count of actions
     */
    public int getActionCount() {
        return actions.size();
    }
    
    /**
     * Get the number of registered mappers
     * @return the count of mappers
     */
    public int getMapperCount() {
        return mappers.size();
    }
}