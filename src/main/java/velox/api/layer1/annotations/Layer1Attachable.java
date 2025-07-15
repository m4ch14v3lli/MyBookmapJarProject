package velox.api.layer1.strategies;

import velox.api.layer1.annotations.Layer1Attachable;
import velox.api.layer1.Layer1ApiProvider;
import velox.api.layer1.Layer1ApiAdminListener;
import velox.api.layer1.Layer1ApiFinishable;

/**
 * Abstract base class for Layer1 attachable strategies
 */
@Layer1Attachable
public abstract class AbstractLayer1Strategy implements Layer1ApiAdminListener, Layer1ApiFinishable {
    
    protected final Layer1ApiProvider apiProvider;
    protected volatile boolean isFinished = false;
    
    public AbstractLayer1Strategy(Layer1ApiProvider apiProvider) {
        this.apiProvider = apiProvider;
        this.apiProvider.registerListener(this);
    }
    
    protected void checkNotFinished() {
        if (isFinished) {
            throw new IllegalStateException("Cannot interact with Layer1ApiProvider after finish() was called");
        }
    }
    
    @Override
    public final void finish() {
        if (!isFinished) {
            isFinished = true;
            try {
                doFinish();
            } finally {
                apiProvider.unregisterListener(this);
            }
        }
    }
    
    /**
     * Subclasses should implement this method for cleanup logic
     */
    protected abstract void doFinish();
    
    @Override
    public abstract void onUserMessage(Object message);
}