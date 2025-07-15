package velox.api.layer1.layers;

public interface Layer1ApiTimeSource {

    /**
     * Allows taking a shortcut when responding to
     * Layer1ApiAdminProvider.getCurrentTime().
     * See Layer1ApiRelay.getTimeSource() to understand the mechanism.
     * Even if the layer implements Layer1ApiAdminProvider.getCurrentTime(),
     * it can still allow a shortcut by implementing this interface.
     */
    Layer1ApiProvider getTimeSource();

    /**
     * Static method to retrieve the time source.
     *
     * @param provider an instance of Layer1ApiProvider
     * @return Layer1ApiProvider instance
     */
    static Layer1ApiProvider getTimeSource(Layer1ApiProvider provider) {
        // Implementation to retrieve the time source from the provider
        return provider; // Placeholder for actual implementation
    }

    // Nested annotation interface
    @interface Layer1TimeSourceShortcutAllowed {
        // Mark Layer1ApiAdminProvider.getCurrentTime() implementation 
        // to confirm support for the shortcut
    }
}

// Example implementation of Layer1ApiProvider (for context)
interface Layer1ApiProvider {
    // Define methods related to Layer1ApiProvider
}