package velox.api.layer1;

/**
 * Listener interface for receiving MBO (Market By Order) data events.
 * Classes that implement this interface can be registered with Layer1ApiMboDataListenable
 * to receive notifications about market data changes.
 * 
 * This interface follows the observer pattern and is designed to handle high-frequency
 * market data updates efficiently. Implementations should be thread-safe and perform
 * minimal processing in the callback methods to avoid blocking the data feed.
 * 
 * @author Velox API Team
 * @version 7.6.0
 * @since 1.0
 */
public interface Layer1ApiMboDataListener {
    
    /**
     * Called when new MBO data is available.
     * This method is invoked whenever there are updates to the order book,
     * trade executions, or other market data events.
     * 
     * Implementations should process this data quickly to avoid impacting
     * the performance of the data feed. For complex processing, consider
     * queuing the data and processing it on a separate thread.
     * 
     * @param timestamp the timestamp of the data event in nanoseconds
     * @param symbol the trading symbol/instrument identifier
     * @param data the MBO data payload containing market information
     */
    void onMboData(long timestamp, String symbol, Object data);
    
    /**
     * Called when there is an error in the MBO data feed.
     * This method allows listeners to handle error conditions gracefully
     * and take appropriate recovery actions.
     * 
     * @param error the error that occurred
     * @param symbol the symbol associated with the error, or null if global
     */
    default void onMboDataError(Throwable error, String symbol) {
        // Default implementation - can be overridden for custom error handling
    }
    
    /**
     * Called when the MBO data feed is connected and ready to receive data.
     * This notification can be used to initialize state or perform setup operations.
     * 
     * @param symbol the symbol that is now connected, or null if this is a global connection event
     */
    default void onMboDataConnected(String symbol) {
        // Default implementation - can be overridden for connection handling
    }
    
    /**
     * Called when the MBO data feed is disconnected.
     * This notification allows listeners to clean up resources or attempt reconnection.
     * 
     * @param symbol the symbol that was disconnected, or null if this is a global disconnection event
     * @param reason the reason for disconnection
     */
    default void onMboDataDisconnected(String symbol, String reason) {
        // Default implementation - can be overridden for disconnection handling
    }
}