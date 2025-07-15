package velox.api.layer1;

// Required imports
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Logger;
import java.util.logging.Level;

// Exception classes
class InstrumentNotDefinedException extends Exception {
    public InstrumentNotDefinedException(String message) {
        super(message);
    }
}

// Core interfaces based on the documentation

/**
 * Base interface for data listening capabilities
 */
interface Layer1ApiDataListenable {
    void addListener(Layer1ApiDataListener listener);
    void removeListener(Layer1ApiDataListener listener);
}

/**
 * Listener interface for receiving data updates
 */
interface Layer1ApiDataListener {
    void onDepthUpdate(String alias, DepthData depthData);
    void onTradeUpdate(String alias, TradeData tradeData);
    void onInstrumentUpdate(String alias, InstrumentData instrumentData);
}

/**
 * Main data provider interface
 * Class implementing this should provide trade/depth data to subscribers
 */
public interface Layer1ApiDataProvider extends Layer1ApiDataListenable {
    
    /**
     * Format price using platform capabilities if possible
     * @param alias - instrument alias/symbol
     * @param price - price value to format
     * @return formatted price string
     * @throws InstrumentNotDefinedException if instrument was not subscribed to, so pips can not be found
     */
    String formatPrice(String alias, double price) throws InstrumentNotDefinedException;
}

// Data classes for market data
class DepthData {
    private final Map<Double, Integer> bids;
    private final Map<Double, Integer> asks;
    private final long timestamp;
    
    public DepthData(Map<Double, Integer> bids, Map<Double, Integer> asks, long timestamp) {
        this.bids = new ConcurrentHashMap<>(bids);
        this.asks = new ConcurrentHashMap<>(asks);
        this.timestamp = timestamp;
    }
    
    public Map<Double, Integer> getBids() { return new ConcurrentHashMap<>(bids); }
    public Map<Double, Integer> getAsks() { return new ConcurrentHashMap<>(asks); }
    public long getTimestamp() { return timestamp; }
}

class TradeData {
    private final double price;
    private final int size;
    private final long timestamp;
    private final String side; // "BUY" or "SELL"
    
    public TradeData(double price, int size, long timestamp, String side) {
        this.price = price;
        this.size = size;
        this.timestamp = timestamp;
        this.side = side;
    }
    
    public double getPrice() { return price; }
    public int getSize() { return size; }
    public long getTimestamp() { return timestamp; }
    public String getSide() { return side; }
}

class InstrumentData {
    private final String alias;
    private final String description;
    private final double tickSize;
    private final int decimals;
    private final double multiplier;
    
    public InstrumentData(String alias, String description, double tickSize, int decimals, double multiplier) {
        this.alias = alias;
        this.description = description;
        this.tickSize = tickSize;
        this.decimals = decimals;
        this.multiplier = multiplier;
    }
    
    public String getAlias() { return alias; }
    public String getDescription() { return description; }
    public double getTickSize() { return tickSize; }
    public int getDecimals() { return decimals; }
    public double getMultiplier() { return multiplier; }
}

// Professional implementation of Layer1ApiDataProvider
class Layer1ApiDataProviderImpl implements Layer1ApiDataProvider {
    
    private static final Logger logger = Logger.getLogger(Layer1ApiDataProviderImpl.class.getName());
    
    // Thread-safe collections for listeners and instrument data
    private final List<Layer1ApiDataListener> listeners = new CopyOnWriteArrayList<>();
    private final Map<String, InstrumentData> instruments = new ConcurrentHashMap<>();
    private final Map<String, NumberFormat> priceFormatters = new ConcurrentHashMap<>();
    
    // Default constructor
    public Layer1ApiDataProviderImpl() {
        logger.info("Layer1ApiDataProvider initialized");
    }
    
    @Override
    public void addListener(Layer1ApiDataListener listener) {
        if (listener != null && !listeners.contains(listener)) {
            listeners.add(listener);
            logger.info("Added listener: " + listener.getClass().getSimpleName());
        }
    }
    
    @Override
    public void removeListener(Layer1ApiDataListener listener) {
        if (listener != null && listeners.remove(listener)) {
            logger.info("Removed listener: " + listener.getClass().getSimpleName());
        }
    }
    
    @Override
    public String formatPrice(String alias, double price) throws InstrumentNotDefinedException {
        if (alias == null || alias.trim().isEmpty()) {
            throw new IllegalArgumentException("Alias cannot be null or empty");
        }
        
        InstrumentData instrument = instruments.get(alias);
        if (instrument == null) {
            throw new InstrumentNotDefinedException("Instrument not defined for alias: " + alias);
        }
        
        // Get or create formatter for this instrument
        NumberFormat formatter = priceFormatters.computeIfAbsent(alias, k -> {
            DecimalFormat df = new DecimalFormat();
            df.setMinimumFractionDigits(instrument.getDecimals());
            df.setMaximumFractionDigits(instrument.getDecimals());
            df.setGroupingUsed(false);
            return df;
        });
        
        // Apply tick size rounding
        double roundedPrice = Math.round(price / instrument.getTickSize()) * instrument.getTickSize();
        
        return formatter.format(roundedPrice);
    }
    
    // Additional utility methods for managing instruments
    
    /**
     * Subscribe to an instrument and register its metadata
     */
    public void subscribeToInstrument(String alias, String description, double tickSize, int decimals, double multiplier) {
        if (alias == null || alias.trim().isEmpty()) {
            throw new IllegalArgumentException("Alias cannot be null or empty");
        }
        
        InstrumentData instrumentData = new InstrumentData(alias, description, tickSize, decimals, multiplier);
        instruments.put(alias, instrumentData);
        
        // Notify listeners about new instrument
        for (Layer1ApiDataListener listener : listeners) {
            try {
                listener.onInstrumentUpdate(alias, instrumentData);
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error notifying listener about instrument update", e);
            }
        }
        
        logger.info("Subscribed to instrument: " + alias);
    }
    
    /**
     * Unsubscribe from an instrument
     */
    public void unsubscribeFromInstrument(String alias) {
        if (instruments.remove(alias) != null) {
            priceFormatters.remove(alias);
            logger.info("Unsubscribed from instrument: " + alias);
        }
    }
    
    /**
     * Check if instrument is subscribed
     */
    public boolean isInstrumentSubscribed(String alias) {
        return instruments.containsKey(alias);
    }
    
    /**
     * Get instrument data
     */
    public InstrumentData getInstrumentData(String alias) {
        return instruments.get(alias);
    }
    
    /**
     * Simulate depth data update
     */
    public void publishDepthUpdate(String alias, DepthData depthData) {
        if (!isInstrumentSubscribed(alias)) {
            logger.warning("Attempting to publish depth data for unsubscribed instrument: " + alias);
            return;
        }
        
        for (Layer1ApiDataListener listener : listeners) {
            try {
                listener.onDepthUpdate(alias, depthData);
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error notifying listener about depth update", e);
            }
        }
    }
    
    /**
     * Simulate trade data update
     */
    public void publishTradeUpdate(String alias, TradeData tradeData) {
        if (!isInstrumentSubscribed(alias)) {
            logger.warning("Attempting to publish trade data for unsubscribed instrument: " + alias);
            return;
        }
        
        for (Layer1ApiDataListener listener : listeners) {
            try {
                listener.onTradeUpdate(alias, tradeData);
            } catch (Exception e) {
                logger.log(Level.WARNING, "Error notifying listener about trade update", e);
            }
        }
    }
    
    /**
     * Get all subscribed instruments
     */
    public java.util.Set<String> getSubscribedInstruments() {
        return new java.util.HashSet<>(instruments.keySet());
    }
    
    /**
     * Clean up resources
     */
    public void shutdown() {
        listeners.clear();
        instruments.clear();
        priceFormatters.clear();
        logger.info("Layer1ApiDataProvider shutdown completed");
    }
}

// Example usage and test class
class Layer1ApiDataProviderExample {
    
    public static void main(String[] args) {
        // Create the data provider
        Layer1ApiDataProviderImpl dataProvider = new Layer1ApiDataProviderImpl();
        
        // Create a sample listener
        Layer1ApiDataListener sampleListener = new Layer1ApiDataListener() {
            @Override
            public void onDepthUpdate(String alias, DepthData depthData) {
                System.out.println("Depth update for " + alias + " at " + depthData.getTimestamp());
            }
            
            @Override
            public void onTradeUpdate(String alias, TradeData tradeData) {
                System.out.println("Trade update for " + alias + ": " + tradeData.getPrice() + " x " + tradeData.getSize());
            }
            
            @Override
            public void onInstrumentUpdate(String alias, InstrumentData instrumentData) {
                System.out.println("Instrument update for " + alias + ": " + instrumentData.getDescription());
            }
        };
        
        // Add listener
        dataProvider.addListener(sampleListener);
        
        // Subscribe to instruments
        dataProvider.subscribeToInstrument("EURUSD", "Euro/US Dollar", 0.00001, 5, 100000);
        dataProvider.subscribeToInstrument("GBPUSD", "British Pound/US Dollar", 0.00001, 5, 100000);
        
        // Test price formatting
        try {
            String formattedPrice = dataProvider.formatPrice("EURUSD", 1.234567);
            System.out.println("Formatted EURUSD price: " + formattedPrice);
            
            // Test with unsubscribed instrument (should throw exception)
            try {
                dataProvider.formatPrice("UNKNOWN", 1.23);
            } catch (InstrumentNotDefinedException e) {
                System.out.println("Expected exception: " + e.getMessage());
            }
            
        } catch (InstrumentNotDefinedException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Simulate market data
        Map<Double, Integer> bids = new ConcurrentHashMap<>();
        Map<Double, Integer> asks = new ConcurrentHashMap<>();
        bids.put(1.23450, 1000000);
        asks.put(1.23451, 1000000);
        
        DepthData depthData = new DepthData(bids, asks, System.currentTimeMillis());
        dataProvider.publishDepthUpdate("EURUSD", depthData);
        
        TradeData tradeData = new TradeData(1.23450, 500000, System.currentTimeMillis(), "BUY");
        dataProvider.publishTradeUpdate("EURUSD", tradeData);
        
        // Cleanup
        dataProvider.shutdown();
    }
}