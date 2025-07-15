package velox.api.layer1;

/**
 * Interface for managing instrument event listeners in the Layer1 API.
 * This interface provides the contract for adding and removing listeners
 * that handle instrument-related events in the trading system.
 * 
 * @author Level1Api 7.6.0
 * @version 7.6.0
 */
public interface Layer1ApiInstrumentListenable {
    
    /**
     * Add an instrument events listener to receive notifications
     * about instrument-related events in the trading system.
     * 
     * @param listener the listener to add for receiving instrument events
     * @throws IllegalArgumentException if listener is null
     */
    void addListener(Layer1ApiInstrumentListener listener);
    
    /**
     * Remove an instrument events listener to stop receiving notifications
     * about instrument-related events in the trading system.
     * 
     * @param listener the listener to remove from receiving instrument events
     * @throws IllegalArgumentException if listener is null
     */
    void removeListener(Layer1ApiInstrumentListener listener);
}

/**
 * Listener interface for handling instrument events.
 * Implementations of this interface will receive callbacks
 * when instrument-related events occur in the trading system.
 */
interface Layer1ApiInstrumentListener {
    
    /**
     * Called when an instrument event occurs.
     * 
     * @param event the instrument event that occurred
     */
    void onInstrumentEvent(Object event);
    
    /**
     * Called when an instrument is added to the system.
     * 
     * @param instrumentId the unique identifier of the instrument
     * @param instrumentData the instrument data
     */
    default void onInstrumentAdded(String instrumentId, Object instrumentData) {
        // Default implementation - override if needed
    }
    
    /**
     * Called when an instrument is removed from the system.
     * 
     * @param instrumentId the unique identifier of the instrument
     */
    default void onInstrumentRemoved(String instrumentId) {
        // Default implementation - override if needed
    }
    
    /**
     * Called when an instrument's data is updated.
     * 
     * @param instrumentId the unique identifier of the instrument
     * @param updatedData the updated instrument data
     */
    default void onInstrumentUpdated(String instrumentId, Object updatedData) {
        // Default implementation - override if needed
    }
}

/**
 * Basic implementation of Layer1ApiInstrumentListenable that provides
 * a standard listener management mechanism using a concurrent collection.
 */
abstract class Layer1ApiBasicListenable implements Layer1ApiInstrumentListenable {
    
    private final java.util.concurrent.CopyOnWriteArraySet<Layer1ApiInstrumentListener> listeners 
        = new java.util.concurrent.CopyOnWriteArraySet<>();
    
    @Override
    public void addListener(Layer1ApiInstrumentListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        listeners.add(listener);
    }
    
    @Override
    public void removeListener(Layer1ApiInstrumentListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        listeners.remove(listener);
    }
    
    /**
     * Notify all registered listeners about an instrument event.
     * 
     * @param event the event to notify listeners about
     */
    protected void notifyListeners(Object event) {
        for (Layer1ApiInstrumentListener listener : listeners) {
            try {
                listener.onInstrumentEvent(event);
            } catch (Exception e) {
                // Log the exception but continue notifying other listeners
                System.err.println("Error notifying listener: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Notify all registered listeners about an instrument being added.
     * 
     * @param instrumentId the instrument identifier
     * @param instrumentData the instrument data
     */
    protected void notifyInstrumentAdded(String instrumentId, Object instrumentData) {
        for (Layer1ApiInstrumentListener listener : listeners) {
            try {
                listener.onInstrumentAdded(instrumentId, instrumentData);
            } catch (Exception e) {
                System.err.println("Error notifying listener about instrument added: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Notify all registered listeners about an instrument being removed.
     * 
     * @param instrumentId the instrument identifier
     */
    protected void notifyInstrumentRemoved(String instrumentId) {
        for (Layer1ApiInstrumentListener listener : listeners) {
            try {
                listener.onInstrumentRemoved(instrumentId);
            } catch (Exception e) {
                System.err.println("Error notifying listener about instrument removed: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Notify all registered listeners about an instrument being updated.
     * 
     * @param instrumentId the instrument identifier
     * @param updatedData the updated instrument data
     */
    protected void notifyInstrumentUpdated(String instrumentId, Object updatedData) {
        for (Layer1ApiInstrumentListener listener : listeners) {
            try {
                listener.onInstrumentUpdated(instrumentId, updatedData);
            } catch (Exception e) {
                System.err.println("Error notifying listener about instrument updated: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Get the number of currently registered listeners.
     * 
     * @return the number of listeners
     */
    public int getListenerCount() {
        return listeners.size();
    }
    
    /**
     * Remove all registered listeners.
     */
    public void clearListeners() {
        listeners.clear();
    }
}

/**
 * Example concrete implementation of the Layer1ApiInstrumentListenable interface.
 * This can serve as a template for actual implementations.
 */
class InstrumentEventManager extends Layer1ApiBasicListenable {
    
    private final String managerId;
    
    public InstrumentEventManager(String managerId) {
        this.managerId = managerId;
    }
    
    /**
     * Simulate processing an instrument event and notifying listeners.
     * 
     * @param event the event to process
     */
    public void processInstrumentEvent(Object event) {
        // Process the event here
        System.out.println("Processing instrument event in manager: " + managerId);
        
        // Notify all listeners
        notifyListeners(event);
    }
    
    /**
     * Simulate adding a new instrument and notifying listeners.
     * 
     * @param instrumentId the instrument identifier
     * @param instrumentData the instrument data
     */
    public void addInstrument(String instrumentId, Object instrumentData) {
        System.out.println("Adding instrument: " + instrumentId);
        notifyInstrumentAdded(instrumentId, instrumentData);
    }
    
    /**
     * Simulate removing an instrument and notifying listeners.
     * 
     * @param instrumentId the instrument identifier
     */
    public void removeInstrument(String instrumentId) {
        System.out.println("Removing instrument: " + instrumentId);
        notifyInstrumentRemoved(instrumentId);
    }
    
    /**
     * Simulate updating an instrument and notifying listeners.
     * 
     * @param instrumentId the instrument identifier
     * @param updatedData the updated data
     */
    public void updateInstrument(String instrumentId, Object updatedData) {
        System.out.println("Updating instrument: " + instrumentId);
        notifyInstrumentUpdated(instrumentId, updatedData);
    }
}