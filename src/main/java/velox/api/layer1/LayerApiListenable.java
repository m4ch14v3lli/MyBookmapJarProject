package velox.api.layer1;

/**
 * Main composite interface that aggregates all Layer1 API listener interfaces.
 * This interface serves as a central point for managing all types of listeners
 * in the Velox Layer1 API framework.
 */
public interface LayerApiListenable extends 
    Layer1ApiAdminListenable,
    Layer1ApiDataListenable,
    Layer1ApiMboDataListenable,
    Layer1ApiInstrumentListenable,
    Layer1ApiTradingListenable {
    
    // This interface inherits all methods from its parent interfaces
    // No additional methods are defined in this interface
}

/**
 * Interface for administrative event listeners in the Layer1 API.
 */
interface Layer1ApiAdminListenable {
    /**
     * Adds an administrative event listener.
     * @param listener The admin listener to add
     */
    void addListener(Layer1ApiAdminListener listener);
    
    /**
     * Removes an administrative event listener.
     * @param listener The admin listener to remove
     */
    void removeListener(Layer1ApiAdminListener listener);
}

/**
 * Interface for data event listeners in the Layer1 API.
 */
interface Layer1ApiDataListenable {
    /**
     * Adds a data event listener.
     * @param listener The data listener to add
     */
    void addListener(Layer1ApiDataListener listener);
    
    /**
     * Removes a data event listener.
     * @param listener The data listener to remove
     */
    void removeListener(Layer1ApiDataListener listener);
}

/**
 * Interface for Market By Order (MBO) data event listeners in the Layer1 API.
 */
interface Layer1ApiMboDataListenable {
    /**
     * Adds an MBO data event listener.
     * @param listener The MBO data listener to add
     */
    void addListener(Layer1ApiMboDataListener listener);
    
    /**
     * Removes an MBO data event listener.
     * @param listener The MBO data listener to remove
     */
    void removeListener(Layer1ApiMboDataListener listener);
}

/**
 * Interface for instrument event listeners in the Layer1 API.
 */
interface Layer1ApiInstrumentListenable {
    /**
     * Adds an instrument event listener.
     * @param listener The instrument listener to add
     */
    void addListener(Layer1ApiInstrumentListener listener);
    
    /**
     * Removes an instrument event listener.
     * @param listener The instrument listener to remove
     */
    void removeListener(Layer1ApiInstrumentListener listener);
}

/**
 * Interface for trading event listeners in the Layer1 API.
 */
interface Layer1ApiTradingListenable {
    /**
     * Adds a trading event listener.
     * @param listener The trading listener to add
     */
    void addListener(Layer1ApiTradingListener listener);
    
    /**
     * Removes a trading event listener.
     * @param listener The trading listener to remove
     */
    void removeListener(Layer1ApiTradingListener listener);
}

/**
 * Listener interface for administrative events.
 */
interface Layer1ApiAdminListener {
    // Admin event callback methods would be defined here
    void onAdminEvent(Object event);
}

/**
 * Listener interface for data events.
 */
interface Layer1ApiDataListener {
    // Data event callback methods would be defined here
    void onDataEvent(Object event);
}

/**
 * Listener interface for Market By Order (MBO) data events.
 */
interface Layer1ApiMboDataListener {
    // MBO data event callback methods would be defined here
    void onMboDataEvent(Object event);
}

/**
 * Listener interface for instrument events.
 */
interface Layer1ApiInstrumentListener {
    // Instrument event callback methods would be defined here
    void onInstrumentEvent(Object event);
}

/**
 * Listener interface for trading events.
 */
interface Layer1ApiTradingListener {
    // Trading event callback methods would be defined here
    void onTradingEvent(Object event);
}

/**
 * Base implementation class providing basic functionality for Layer1 API listeners.
 * This class can be extended by concrete implementations.
 */
abstract class Layer1ApiBasicListenable implements LayerApiListenable {
    
    protected java.util.Set<Layer1ApiAdminListener> adminListeners = new java.util.concurrent.ConcurrentHashMap<Layer1ApiAdminListener, Boolean>().keySet();
    protected java.util.Set<Layer1ApiDataListener> dataListeners = new java.util.concurrent.ConcurrentHashMap<Layer1ApiDataListener, Boolean>().keySet();
    protected java.util.Set<Layer1ApiMboDataListener> mboDataListeners = new java.util.concurrent.ConcurrentHashMap<Layer1ApiMboDataListener, Boolean>().keySet();
    protected java.util.Set<Layer1ApiInstrumentListener> instrumentListeners = new java.util.concurrent.ConcurrentHashMap<Layer1ApiInstrumentListener, Boolean>().keySet();
    protected java.util.Set<Layer1ApiTradingListener> tradingListeners = new java.util.concurrent.ConcurrentHashMap<Layer1ApiTradingListener, Boolean>().keySet();
    
    @Override
    public void addListener(Layer1ApiAdminListener listener) {
        if (listener != null) {
            adminListeners.add(listener);
        }
    }
    
    @Override
    public void removeListener(Layer1ApiAdminListener listener) {
        if (listener != null) {
            adminListeners.remove(listener);
        }
    }
    
    @Override
    public void addListener(Layer1ApiDataListener listener) {
        if (listener != null) {
            dataListeners.add(listener);
        }
    }
    
    @Override
    public void removeListener(Layer1ApiDataListener listener) {
        if (listener != null) {
            dataListeners.remove(listener);
        }
    }
    
    @Override
    public void addListener(Layer1ApiMboDataListener listener) {
        if (listener != null) {
            mboDataListeners.add(listener);
        }
    }
    
    @Override
    public void removeListener(Layer1ApiMboDataListener listener) {
        if (listener != null) {
            mboDataListeners.remove(listener);
        }
    }
    
    @Override
    public void addListener(Layer1ApiInstrumentListener listener) {
        if (listener != null) {
            instrumentListeners.add(listener);
        }
    }
    
    @Override
    public void removeListener(Layer1ApiInstrumentListener listener) {
        if (listener != null) {
            instrumentListeners.remove(listener);
        }
    }
    
    @Override
    public void addListener(Layer1ApiTradingListener listener) {
        if (listener != null) {
            tradingListeners.add(listener);
        }
    }
    
    @Override
    public void removeListener(Layer1ApiTradingListener listener) {
        if (listener != null) {
            tradingListeners.remove(listener);
        }
    }
    
    /**
     * Notifies all registered admin listeners of an event.
     * @param event The event to notify listeners about
     */
    protected void notifyAdminListeners(Object event) {
        for (Layer1ApiAdminListener listener : adminListeners) {
            try {
                listener.onAdminEvent(event);
            } catch (Exception e) {
                // Log error but continue notifying other listeners
                System.err.println("Error notifying admin listener: " + e.getMessage());
            }
        }
    }
    
    /**
     * Notifies all registered data listeners of an event.
     * @param event The event to notify listeners about
     */
    protected void notifyDataListeners(Object event) {
        for (Layer1ApiDataListener listener : dataListeners) {
            try {
                listener.onDataEvent(event);
            } catch (Exception e) {
                System.err.println("Error notifying data listener: " + e.getMessage());
            }
        }
    }
    
    /**
     * Notifies all registered MBO data listeners of an event.
     * @param event The event to notify listeners about
     */
    protected void notifyMboDataListeners(Object event) {
        for (Layer1ApiMboDataListener listener : mboDataListeners) {
            try {
                listener.onMboDataEvent(event);
            } catch (Exception e) {
                System.err.println("Error notifying MBO data listener: " + e.getMessage());
            }
        }
    }
    
    /**
     * Notifies all registered instrument listeners of an event.
     * @param event The event to notify listeners about
     */
    protected void notifyInstrumentListeners(Object event) {
        for (Layer1ApiInstrumentListener listener : instrumentListeners) {
            try {
                listener.onInstrumentEvent(event);
            } catch (Exception e) {
                System.err.println("Error notifying instrument listener: " + e.getMessage());
            }
        }
    }
    
    /**
     * Notifies all registered trading listeners of an event.
     * @param event The event to notify listeners about
     */
    protected void notifyTradingListeners(Object event) {
        for (Layer1ApiTradingListener listener : tradingListeners) {
            try {
                listener.onTradingEvent(event);
            } catch (Exception e) {
                System.err.println("Error notifying trading listener: " + e.getMessage());
            }
        }
    }
}