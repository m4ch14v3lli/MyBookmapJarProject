package velox.api.layer1;

/**
 * Interface for components that can accept data listeners.
 * This is part of the Layer1 API for the Velox trading platform.
 * 
 * This interface follows the Observer pattern, allowing multiple listeners
 * to be registered and notified of data events.
 * 
 * @author Velox API Team
 * @version 7.6.0
 */
public interface Layer1ApiDataListenable {
    
    /**
     * Add data listener to receive notifications about data events.
     * 
     * @param listener listener to add - must not be null
     * @throws IllegalArgumentException if listener is null
     */
    void addListener(Layer1ApiDataListener listener);
    
    /**
     * Remove data listener to stop receiving notifications.
     * If the listener was not previously added, this method has no effect.
     * 
     * @param listener listener to remove - must not be null
     * @throws IllegalArgumentException if listener is null
     */
    void removeListener(Layer1ApiDataListener listener);
}

/**
 * Base listener interface for receiving data events from Layer1 API.
 * Implementations should handle data events appropriately.
 */
interface Layer1ApiDataListener {
    
    /**
     * Called when market data is received.
     * 
     * @param data the market data object
     */
    void onMarketData(Object data);
    
    /**
     * Called when trade data is received.
     * 
     * @param data the trade data object
     */
    void onTradeData(Object data);
    
    /**
     * Called when an error occurs in data processing.
     * 
     * @param error the error that occurred
     */
    void onError(Exception error);
}

/**
 * Extended interfaces that inherit from Layer1ApiDataListenable
 */

/**
 * Interface for Layer1 API data providers.
 * Extends the basic listenable interface with data provision capabilities.
 */
interface Layer1ApiDataProvider extends Layer1ApiDataListenable {
    
    /**
     * Start providing data.
     */
    void startDataProvider();
    
    /**
     * Stop providing data.
     */
    void stopDataProvider();
    
    /**
     * Check if data provider is currently active.
     * 
     * @return true if provider is active, false otherwise
     */
    boolean isActive();
}

/**
 * Main Layer1 API provider interface.
 * Extends data provider with additional provider-specific functionality.
 */
interface Layer1ApiProvider extends Layer1ApiDataProvider {
    
    /**
     * Get the provider name.
     * 
     * @return provider name
     */
    String getProviderName();
    
    /**
     * Initialize the provider with configuration.
     * 
     * @param config configuration object
     */
    void initialize(Object config);
    
    /**
     * Cleanup resources when provider is no longer needed.
     */
    void dispose();
}

/**
 * Generic layer API listenable interface.
 */
interface LayerApiListenable extends Layer1ApiDataListenable {
    
    /**
     * Get the layer name.
     * 
     * @return layer name
     */
    String getLayerName();
}

/**
 * Basic implementation of Layer1ApiDataListenable using thread-safe collections.
 * This provides a concrete implementation that can be extended or used directly.
 */
class Layer1ApiBasicListenable implements Layer1ApiDataListenable {
    
    private final java.util.concurrent.CopyOnWriteArrayList<Layer1ApiDataListener> listeners;
    private final java.util.concurrent.locks.ReentrantReadWriteLock lock;
    
    /**
     * Constructor initializes the listener collection and lock.
     */
    public Layer1ApiBasicListenable() {
        this.listeners = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.lock = new java.util.concurrent.locks.ReentrantReadWriteLock();
    }
    
    @Override
    public void addListener(Layer1ApiDataListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        
        lock.writeLock().lock();
        try {
            if (!listeners.contains(listener)) {
                listeners.add(listener);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    @Override
    public void removeListener(Layer1ApiDataListener listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener cannot be null");
        }
        
        lock.writeLock().lock();
        try {
            listeners.remove(listener);
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    /**
     * Notify all listeners of market data.
     * 
     * @param data the market data to broadcast
     */
    protected void notifyMarketData(Object data) {
        lock.readLock().lock();
        try {
            for (Layer1ApiDataListener listener : listeners) {
                try {
                    listener.onMarketData(data);
                } catch (Exception e) {
                    // Log error but continue notifying other listeners
                    System.err.println("Error notifying listener: " + e.getMessage());
                }
            }
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * Notify all listeners of trade data.
     * 
     * @param data the trade data to broadcast
     */
    protected void notifyTradeData(Object data) {
        lock.readLock().lock();
        try {
            for (Layer1ApiDataListener listener : listeners) {
                try {
                    listener.onTradeData(data);
                } catch (Exception e) {
                    // Log error but continue notifying other listeners
                    System.err.println("Error notifying listener: " + e.getMessage());
                }
            }
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * Notify all listeners of an error.
     * 
     * @param error the error to broadcast
     */
    protected void notifyError(Exception error) {
        lock.readLock().lock();
        try {
            for (Layer1ApiDataListener listener : listeners) {
                try {
                    listener.onError(error);
                } catch (Exception e) {
                    // Log error but continue notifying other listeners
                    System.err.println("Error notifying listener of error: " + e.getMessage());
                }
            }
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * Get the current number of registered listeners.
     * 
     * @return number of listeners
     */
    public int getListenerCount() {
        lock.readLock().lock();
        try {
            return listeners.size();
        } finally {
            lock.readLock().unlock();
        }
    }
    
    /**
     * Check if any listeners are registered.
     * 
     * @return true if there are listeners, false otherwise
     */
    public boolean hasListeners() {
        lock.readLock().lock();
        try {
            return !listeners.isEmpty();
        } finally {
            lock.readLock().unlock();
        }
    }
}

/**
 * Example implementation of Layer1ApiDataListener for demonstration.
 */
class ExampleDataListener implements Layer1ApiDataListener {
    
    private final String name;
    
    public ExampleDataListener(String name) {
        this.name = name;
    }
    
    @Override
    public void onMarketData(Object data) {
        System.out.println("[" + name + "] Received market data: " + data);
    }
    
    @Override
    public void onTradeData(Object data) {
        System.out.println("[" + name + "] Received trade data: " + data);
    }
    
    @Override
    public void onError(Exception error) {
        System.err.println("[" + name + "] Error occurred: " + error.getMessage());
    }
}

/**
 * Example usage and testing class.
 */
class Layer1ApiExample {
    
    public static void main(String[] args) {
        // Create a basic listenable implementation
        Layer1ApiBasicListenable listenable = new Layer1ApiBasicListenable();
        
        // Create some listeners
        ExampleDataListener listener1 = new ExampleDataListener("Listener1");
        ExampleDataListener listener2 = new ExampleDataListener("Listener2");
        
        // Add listeners
        listenable.addListener(listener1);
        listenable.addListener(listener2);
        
        System.out.println("Added listeners. Count: " + listenable.getListenerCount());
        
        // Simulate data events
        listenable.notifyMarketData("EUR/USD: 1.0545");
        listenable.notifyTradeData("Trade executed: 100 shares @ $50.00");
        listenable.notifyError(new RuntimeException("Connection timeout"));
        
        // Remove a listener
        listenable.removeListener(listener1);
        System.out.println("Removed listener1. Count: " + listenable.getListenerCount());
        
        // Notify again
        listenable.notifyMarketData("GBP/USD: 1.2678");
    }
}