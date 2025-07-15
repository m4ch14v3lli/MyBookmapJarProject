package velox.api.layer1;

import velox.api.layer1.Layer1ApiInstrumentListener;
import velox.api.layer1.data.InstrumentInfo;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/**
 * Example implementation of Layer1ApiInstrumentListener
 * This demonstrates how to properly handle instrument lifecycle events
 */
public class InstrumentListenerImpl implements Layer1ApiInstrumentListener {
    
    private static final Logger logger = Logger.getLogger(InstrumentListenerImpl.class.getName());
    
    // Thread-safe storage for active instruments
    private final ConcurrentHashMap<String, InstrumentInfo> activeInstruments = new ConcurrentHashMap<>();
    
    @Override
    public void onInstrumentAdded(String alias, InstrumentInfo instrumentInfo) {
        logger.info(String.format("Instrument added: %s -> %s", alias, instrumentInfo));
        
        // Store the instrument for future reference
        activeInstruments.put(alias, instrumentInfo);
        
        // Initialize any required data structures for this instrument
        initializeInstrumentData(alias, instrumentInfo);
        
        // Notify other components about the new instrument
        notifyInstrumentAdded(alias, instrumentInfo);
    }
    
    @Override
    public void onInstrumentRemoved(String alias) {
        logger.info("Instrument removed: " + alias);
        
        InstrumentInfo removedInstrument = activeInstruments.remove(alias);
        
        if (removedInstrument != null) {
            // Clean up resources but preserve data that might be needed
            // for OnlineCalculatable operations
            cleanupInstrumentResources(alias, removedInstrument);
            
            // Notify other components
            notifyInstrumentRemoved(alias, removedInstrument);
        }
    }
    
    @Override
    public void onInstrumentNotFound(String symbol, String exchange, String type) {
        logger.warning(String.format("Instrument not found: %s@%s [%s]", symbol, exchange, type));
        
        // Handle the error appropriately
        handleInstrumentNotFound(symbol, exchange, type);
    }
    
    @Override
    public void onInstrumentAlreadySubscribed(String symbol, String exchange, String type) {
        logger.info(String.format("Instrument already subscribed: %s@%s [%s]", symbol, exchange, type));
        
        // Handle duplicate subscription attempt
        handleDuplicateSubscription(symbol, exchange, type);
    }
    
    // Helper methods
    private void initializeInstrumentData(String alias, InstrumentInfo info) {
        // Initialize data structures, caches, etc.
        // Implementation depends on your specific needs
    }
    
    private void cleanupInstrumentResources(String alias, InstrumentInfo info) {
        // Clean up resources while preserving essential data
        // Be careful with OnlineCalculatable requirements
    }
    
    private void notifyInstrumentAdded(String alias, InstrumentInfo info) {
        // Notify other system components
    }
    
    private void notifyInstrumentRemoved(String alias, InstrumentInfo info) {
        // Notify other system components
    }
    
    private void handleInstrumentNotFound(String symbol, String exchange, String type) {
        // Log error, notify user, update UI, etc.
    }
    
    private void handleDuplicateSubscription(String symbol, String exchange, String type) {
        // Handle duplicate subscription logic
    }
    
    // Utility methods for external use
    public InstrumentInfo getInstrumentInfo(String alias) {
        return activeInstruments.get(alias);
    }
    
    public boolean isInstrumentActive(String alias) {
        return activeInstruments.containsKey(alias);
    }
    
    public int getActiveInstrumentCount() {
        return activeInstruments.size();
    }
}