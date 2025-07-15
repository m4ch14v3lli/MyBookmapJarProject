package velox.api.layer1.strategy;

import velox.api.layer1.Layer1ApiProvider;
import velox.api.layer1.Layer1ApiFinishable;
import velox.api.layer1.Layer1ApiAdminListener;
import velox.api.layer1.annotations.Layer1Attachable;
import velox.api.layer1.messages.UserMessageLayersChainCreatedTargeted;

/**
 * Example implementation of a Layer1 attachable strategy
 */
@Layer1Attachable
public class ExampleLayer1Strategy implements Layer1ApiFinishable, Layer1ApiAdminListener {
    
    private final Layer1ApiProvider apiProvider;
    private boolean isActive;
    
    /**
     * Constructor - receives Layer1ApiProvider for interaction
     * @param apiProvider the API provider instance
     */
    public ExampleLayer1Strategy(Layer1ApiProvider apiProvider) {
        this.apiProvider = apiProvider;
        this.isActive = false;
    }
    
    /**
     * Handles user messages, particularly UserMessageLayersChainCreatedTargeted
     * @param message the user message object
     */
    @Override
    public void onUserMessage(Object message) {
        if (message instanceof UserMessageLayersChainCreatedTargeted) {
            // Strategy is now correctly injected in layers chain
            this.isActive = true;
            handleLayersChainCreated((UserMessageLayersChainCreatedTargeted) message);
        }
    }
    
    /**
     * Handles the layers chain created event
     * @param message the chain created message
     */
    private void handleLayersChainCreated(UserMessageLayersChainCreatedTargeted message) {
        // Implementation for when layers chain is created
        // Can interact with apiProvider here
    }
    
    /**
     * Called when strategy is no longer in layers chain
     * Final cleanup and interaction with Layer1ApiProvider
     */
    @Override
    public void finish() {
        if (isActive) {
            // Final interactions with apiProvider before shutdown
            performCleanup();
            this.isActive = false;
        }
        // After this method completes, cannot interact with apiProvider
    }
    
    /**
     * Performs cleanup operations
     */
    private void performCleanup() {
        // Cleanup implementation using apiProvider
    }
    
    /**
     * Checks if the strategy is currently active
     * @return true if strategy is active in layers chain
     */
    public boolean isActive() {
        return isActive;
    }
}