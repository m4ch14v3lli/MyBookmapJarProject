package velox.api.layer1;

import velox.api.layer1.data.SubscribeInfo;
import velox.api.layer1.data.InstrumentCoreInfo;

/**
 * Interface for classes that provide the ability to work with instruments.
 * This interface handles instrument subscription and unsubscription operations.
 * 
 * @author Velox API
 * @version 7.6.0
 */
public interface Layer1ApiInstrumentProvider extends Layer1ApiInstrumentListenable {
    
    /**
     * Subscribe to specified instrument. Some parameters can be null depending
     * on the platform.
     * 
     * @param subscribeInfo has fields similar to {@link InstrumentCoreInfo}
     */
    void subscribe(SubscribeInfo subscribeInfo);
    
    /**
     * Subscribe to specified instrument. Some parameters can be null depending
     * on the platform.
     * 
     * @param symbol the instrument symbol
     * @param exchange the exchange identifier
     * @param type see {@link InstrumentCoreInfo#type}
     * @deprecated Default implementation forwards events to new method.
     *             Use {@link #subscribe(SubscribeInfo)} instead
     */
    @Deprecated
    default void subscribe(String symbol, String exchange, String type) {
        // Default implementation would typically create a SubscribeInfo object
        // and call the new subscribe method
        SubscribeInfo subscribeInfo = new SubscribeInfo(symbol, exchange, type);
        subscribe(subscribeInfo);
    }
    
    /**
     * Unsubscribe from the instrument
     * 
     * @param alias instrument alias
     */
    void unsubscribe(String alias);
}