package velox.api.layer1.layers;

public class Layer1ApiRelay extends Layer1ApiUpstreamRelay implements Layer1ApiProvider, Layer1ApiListener {

    protected final Layer1ApiProvider provider;

    public Layer1ApiRelay(Layer1ApiProvider provider) {
        this.provider = provider;
    }

    public Layer1ApiRelay(Layer1ApiProvider provider, boolean subscribeToProvider) {
        this.provider = provider;
        if (subscribeToProvider) {
            this.subscribe(provider);
        }
    }

    public void close() {
        // Stop relaying data.
    }

    public String formatPrice(String alias, double price) {
        // Format price using platform capabilities if possible.
        return String.valueOf(price);
    }

    public long getCurrentTime() {
        // Returns current Unix epoch time.
        return System.currentTimeMillis();
    }

    public String getSource() {
        // Returns string representing data source.
        return "Data Source";
    }

    public Layer1ApiProviderSupportedFeatures getSupportedFeatures() {
        // Get information about features that are supported by a provider.
        return new Layer1ApiProviderSupportedFeatures();
    }

    public Layer1ApiTimeSource getTimeSource() {
        // Return the time source.
        return null; // Placeholder
    }

    public void sendUserMessage(Object data) {
        // Send a downstream event.
    }

    public void subscribe(SubscribeInfo subscribeInfo) {
        // Subscribe to specified instrument.
    }

    public void unsubscribe(String alias) {
        // Unsubscribe from the instrument.
    }

    public void sendOrder(OrderSendParameters orderSendParameters) {
        // Submit order with specified parameters.
    }

    public void updateOrder(OrderUpdateParameters orderUpdateParameters) {
        // Update order according to parameters.
    }

    public void login(LoginData loginData) {
        // Initiate login to the platform.
    }

    @Override
    public String toString() {
        // Return string representation of the object.
        return "Layer1ApiRelay{" + "provider=" + provider + '}';
    }
}