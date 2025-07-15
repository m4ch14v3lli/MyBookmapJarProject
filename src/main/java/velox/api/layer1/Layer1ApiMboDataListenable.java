package velox.api.layer1;

/**
 * Interface for managing MBO (Market By Order) data listeners.
 * This interface provides methods to add and remove listeners for market data events.
 * 
 * Known subinterfaces:
 * - Layer1ApiMboDataProvider
 * - Layer1ApiProvider  
 * - LayerApiListenable
 * 
 * Known implementing classes:
 * - ExternalLiveBaseProvider
 * - ExternalReaderBaseProvider
 * - Layer1ApiBasicListenable
 * - Layer1ApiDepthFreezer
 * - Layer1ApiInjectorRelay
 * - Layer1ApiRelay
 * - Layer1ApiStrategiesEchoMessagesLayer
 * - Layer1ApiUpstreamRelay
 */
public interface Layer1ApiMboDataListenable {

    /**
     * Add MBO data listener to receive market data events.
     * 
     * @param listener the listener to add for receiving MBO data events
     */
    void addListener(Layer1ApiMboDataListener listener);

    /**
     * Remove MBO data listener to stop receiving market data events.
     * 
     * @param listener the listener to remove from receiving MBO data events
     */
    void removeListener(Layer1ApiMboDataListener listener);
}