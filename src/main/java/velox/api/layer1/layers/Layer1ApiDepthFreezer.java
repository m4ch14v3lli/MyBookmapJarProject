package velox.api.layer1.layers;

public class Layer1ApiDepthFreezer extends Layer1ApiRelay {

    public Layer1ApiDepthFreezer(Layer1ApiProvider provider) {
        super(provider);
    }

    public void onDepth(String alias, boolean isBid, int price, int size) {
        // Handle depth data update
    }

    public void onUserMessage(Object data) {
        // Send an upstream event
    }

    // Additional methods can be added as needed
}