package velox.api.layer1.strategy;

import velox.api.layer1.Layer1ApiProvider;
import velox.api.layer1.Layer1ApiFinishable;
import velox.api.layer1.Layer1ApiAdminListener;
import velox.api.layer1.annotations.Layer1Injectable;
import velox.api.layer1.messages.UserMessageLayersChainCreatedTargeted;

/**
 * Example strategy implementation that can be injected into layers chain
 */
@Layer1Injectable
public class ExampleStrategy implements Layer1ApiFinishable, Layer1ApiAdminListener {
    
    private final Layer1ApiProvider apiProvider;
    private boolean isActive = false;
    
    /**
     * Constructor receives Layer1ApiProvider for interaction
     * @param apiProvider The API provider instance
     */
    public ExampleStrategy(Layer1ApiProvider apiProvider) {
        this.apiProvider = apiProvider;
    }
    
    @Override
    public void onUserMessage(Object message) {
        if (message instanceof UserMessageLayersChainCreatedTargeted) {
            // Strategy is now active and correctly injected in layers chain
            isActive = true;
            handleLayersChainCreated((UserMessageLayersChainCreatedTargeted) message);
        }
    }
    
    private void handleLayersChainCreated(UserMessageLayersChainCreatedTargeted message) {
        // Handle the layers chain creation event
        // You can now interact with apiProvider
    }
    
    @Override
    public void finish() {
        // Called when strategy is no longer in layers chain
        if (isActive) {
            // Perform cleanup operations
            // You can still interact with apiProvider here
            cleanup();
            isActive = false;
        }
        // After this method completes, apiProvider interaction will cause exceptions
    }
    
    private void cleanup() {
        // Cleanup resources and finalize operations
    }
}

/**
 * Abstract base class for Layer1Injectable strategies
 */
public abstract class AbstractLayer1Strategy implements Layer1ApiFinishable, Layer1ApiAdminListener {
    
    protected final Layer1ApiProvider apiProvider;
    protected volatile boolean isFinished = false;
    
    public AbstractLayer1Strategy(Layer1ApiProvider apiProvider) {
        this.apiProvider = apiProvider;
    }
    
    @Override
    public final void onUserMessage(Object message) {
        if (isFinished) {
            return; // Ignore messages after finish() was called
        }
        
        if (message instanceof UserMessageLayersChainCreatedTargeted) {
            onLayersChainCreated((UserMessageLayersChainCreatedTargeted) message);
        } else {
            handleUserMessage(message);
        }
    }
    
    protected abstract void onLayersChainCreated(UserMessageLayersChainCreatedTargeted message);
    
    protected abstract void handleUserMessage(Object message);
    
    @Override
    public final void finish() {
        if (isFinished) {
            return; // Prevent multiple finish() calls
        }
        
        try {
            performFinishOperations();
        } finally {
            isFinished = true;
        }
    }
    
    protected abstract void performFinishOperations();
    
    /**
     * Utility method to check if strategy is still active
     * @return true if strategy is active and can interact with apiProvider
     */
    protected final boolean isActive() {
        return !isFinished;
    }
}