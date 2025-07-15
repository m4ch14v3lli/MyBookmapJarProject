package velox.api.layer1;

/**
 * Interface for managing trading listeners in the Layer1 API.
 * This interface provides methods to add and remove trading listeners
 * for monitoring trading events and activities.
 * 
 * @author Level1Api 7.6.0
 * @since 7.6.0
 */
public interface Layer1ApiTradingListenable {
    
    /**
     * Add a trading listener to monitor trading events.
     * The listener will receive notifications about trading activities,
     * order updates, position changes, and other trading-related events.
     * 
     * @param listener the Layer1ApiTradingListener to add
     * @throws IllegalArgumentException if listener is null
     */
    void addListener(Layer1ApiTradingListener listener);
    
    /**
     * Remove a previously added trading listener.
     * After removal, the listener will no longer receive trading event notifications.
     * 
     * @param listener the Layer1ApiTradingListener to remove
     * @throws IllegalArgumentException if listener is null
     */
    void removeListener(Layer1ApiTradingListener listener);
}