package velox.api.layer1.layers;

public class Layer1ApiInjectorRelay extends Layer1ApiRelay {

    protected final Object upstreamInjectorLock;

    public Layer1ApiInjectorRelay(Layer1ApiProvider provider) {
        super(provider);
        this.upstreamInjectorLock = new Object();
    }

    public void sendUserMessage(Object data) {
        // Send a downstream event. Allows incorporating arbitrary functionality into the protocol.
    }

    protected void inject(Runnable r) {
        // Inject runnable into messages stream provider -> GUI. Event is handled asynchronously.
    }

    protected void injectSynchronously(Runnable r) {
        // Inject runnable into messages stream provider -> GUI from the same thread.
    }

    public void close() {
        // Stop relaying data. Will not let send new events upwards, but is not guaranteed to stop ones already in progress.
    }
}