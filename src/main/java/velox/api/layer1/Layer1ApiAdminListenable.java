package velox.api.layer1;

/**
 * Interface for managing Layer1 API admin listeners.
 * 
 * This interface provides methods to add and remove listeners for general events
 * in the Layer1 API administrative functionality.
 * 
 * Known Subinterfaces:
 * - Layer1ApiAdminProvider
 * - Layer1ApiProvider  
 * - LayerApiListenable
 * 
 * Known Implementing Classes:
 * - ExternalLiveBaseProvider
 * - ExternalReaderBaseProvider
 * - Layer1ApiBasicListenable
 * - Layer1ApiDepthFreezer
 * - Layer1ApiInjectorRelay
 * - Layer1ApiRelay
 * - Layer1ApiStrategiesEchoMessagesLayer
 * - Layer1ApiUpstreamRelay
 */
public interface Layer1ApiAdminListenable {
    
    /**
     * Add listener for general events
     * 
     * @param listener listener to add
     */
    void addListener(Layer1ApiAdminListener listener);
    
    /**
     * Remove listener for general events
     * 
     * @param listener listener to remove
     */
    void removeListener(Layer1ApiAdminListener listener);
}