package velox.api.layer1;

import velox.api.layer1.data.MarketMode;
import velox.api.layer1.data.TradeInfo;

/**
 * Listener for trading events
 * 
 * This interface defines the contract for receiving real-time market data updates
 * including trades, market depth (order book), and market mode changes.
 * 
 * @author Professional Analysis
 * @version 7.6.0
 */
public interface Layer1ApiDataListener {

    /**
     * Called when a trade occurs in the market
     * 
     * @param alias instrument alias (e.g., "EURUSD", "AAPL", "ES")
     * @param price trade price in the same units as depth update 
     *              (e.g. if pips=25 then price=1000 means 25000)
     * @param size trade size/volume
     * @param tradeInfo additional information about the trade (timestamp, aggressor side, etc.)
     */
    void onTrade(String alias, double price, int size, TradeInfo tradeInfo);

    /**
     * Called when market depth (order book) data changes
     * 
     * @param alias instrument alias
     * @param isBid true if it is for bids (buy orders), false for asks (sell orders)
     * @param price price level where size changed
     * @param size new size at this price level (0 means level is removed)
     */
    void onDepth(String alias, boolean isBid, int price, int size);

    /**
     * Called when market mode changes (e.g., trading session state)
     * 
     * @param alias instrument alias
     * @param marketMode new market mode (TRADING, CLOSED, PRE_MARKET, etc.)
     */
    void onMarketMode(String alias, MarketMode marketMode);
}

// Supporting classes that would typically be in separate files

/**
 * Enum representing different market modes/states
 */
enum MarketMode {
    TRADING,
    CLOSED,
    PRE_MARKET,
    POST_MARKET,
    HALTED,
    UNKNOWN
}

/**
 * Container for additional trade information
 */
class TradeInfo {
    private final long timestamp;
    private final boolean isAggressor;
    private final String tradeId;
    private final char aggressorSide; // 'B' for buy, 'S' for sell
    
    public TradeInfo(long timestamp, boolean isAggressor, String tradeId, char aggressorSide) {
        this.timestamp = timestamp;
        this.isAggressor = isAggressor;
        this.tradeId = tradeId;
        this.aggressorSide = aggressorSide;
    }
    
    public long getTimestamp() { return timestamp; }
    public boolean isAggressor() { return isAggressor; }
    public String getTradeId() { return tradeId; }
    public char getAggressorSide() { return aggressorSide; }
}

/**
 * Example implementation of the Layer1ApiDataListener
 * This demonstrates how to implement the interface in practice
 */
class MarketDataHandler implements Layer1ApiDataListener {
    
    @Override
    public void onTrade(String alias, double price, int size, TradeInfo tradeInfo) {
        System.out.printf("TRADE: %s @ %.5f, Size: %d, Time: %d, Aggressor: %c%n", 
                         alias, price, size, tradeInfo.getTimestamp(), tradeInfo.getAggressorSide());
        
        // Your trading logic here
        // Example: update last traded price, calculate volume, trigger alerts
        processTradeData(alias, price, size, tradeInfo);
    }
    
    @Override
    public void onDepth(String alias, boolean isBid, int price, int size) {
        String side = isBid ? "BID" : "ASK";
        System.out.printf("DEPTH: %s %s @ %d, Size: %d%n", alias, side, price, size);
        
        // Your order book logic here
        // Example: update internal order book, calculate spread, detect imbalances
        updateOrderBook(alias, isBid, price, size);
    }
    
    @Override
    public void onMarketMode(String alias, MarketMode marketMode) {
        System.out.printf("MARKET MODE: %s changed to %s%n", alias, marketMode);
        
        // Your market state logic here
        // Example: enable/disable trading, adjust risk parameters
        handleMarketStateChange(alias, marketMode);
    }
    
    // Helper methods for your business logic
    private void processTradeData(String alias, double price, int size, TradeInfo tradeInfo) {
        // Implement your trade processing logic
        // Examples:
        // - Update moving averages
        // - Check for large trades
        // - Trigger algorithmic responses
        // - Update P&L calculations
    }
    
    private void updateOrderBook(String alias, boolean isBid, int price, int size) {
        // Implement your order book management
        // Examples:
        // - Maintain bid/ask levels
        // - Calculate market depth
        // - Detect price level changes
        // - Update trading signals
    }
    
    private void handleMarketStateChange(String alias, MarketMode marketMode) {
        // Implement market state handling
        // Examples:
        // - Enable/disable order placement
        // - Adjust position sizes
        // - Update risk management parameters
        // - Send notifications
    }
}

/**
 * Example usage and testing class
 */
class Layer1ApiExample {
    public static void main(String[] args) {
        // Create an instance of your listener
        Layer1ApiDataListener listener = new MarketDataHandler();
        
        // Simulate some market data events
        TradeInfo tradeInfo = new TradeInfo(System.currentTimeMillis(), true, "TRD001", 'B');
        
        // Simulate trade event
        listener.onTrade("EURUSD", 1.10250, 1000000, tradeInfo);
        
        // Simulate depth updates
        listener.onDepth("EURUSD", true, 110250, 500000);   // Bid update
        listener.onDepth("EURUSD", false, 110255, 750000);  // Ask update
        
        // Simulate market mode change
        listener.onMarketMode("EURUSD", MarketMode.TRADING);
    }
}

/**
 * Advanced implementation with additional features
 */
class AdvancedMarketDataHandler implements Layer1ApiDataListener {
    private final java.util.Map<String, OrderBook> orderBooks = new java.util.concurrent.ConcurrentHashMap<>();
    private final java.util.Map<String, MarketMode> marketModes = new java.util.concurrent.ConcurrentHashMap<>();
    
    @Override
    public void onTrade(String alias, double price, int size, TradeInfo tradeInfo) {
        // Thread-safe processing
        synchronized (this) {
            // Update last trade price
            // Calculate VWAP (Volume Weighted Average Price)
            // Update trade statistics
            // Trigger any trade-based strategies
        }
    }
    
    @Override
    public void onDepth(String alias, boolean isBid, int price, int size) {
        // Get or create order book for this instrument
        OrderBook orderBook = orderBooks.computeIfAbsent(alias, k -> new OrderBook());
        
        // Update the order book
        if (isBid) {
            orderBook.updateBid(price, size);
        } else {
            orderBook.updateAsk(price, size);
        }
        
        // Calculate spread, check for opportunities
        double spread = orderBook.getSpread();
        if (spread > 0) {
            // Handle spread changes
        }
    }
    
    @Override
    public void onMarketMode(String alias, MarketMode marketMode) {
        MarketMode previousMode = marketModes.put(alias, marketMode);
        
        // Handle market mode transitions
        if (previousMode != null && previousMode != marketMode) {
            handleModeTransition(alias, previousMode, marketMode);
        }
    }
    
    private void handleModeTransition(String alias, MarketMode from, MarketMode to) {
        // Implement transition logic
        if (to == MarketMode.CLOSED) {
            // Close positions, cancel orders, etc.
        } else if (to == MarketMode.TRADING && from == MarketMode.CLOSED) {
            // Resume trading activities
        }
    }
    
    // Simple order book implementation
    private static class OrderBook {
        private final java.util.TreeMap<Integer, Integer> bids = new java.util.TreeMap<>(java.util.Collections.reverseOrder());
        private final java.util.TreeMap<Integer, Integer> asks = new java.util.TreeMap<>();
        
        public void updateBid(int price, int size) {
            if (size == 0) {
                bids.remove(price);
            } else {
                bids.put(price, size);
            }
        }
        
        public void updateAsk(int price, int size) {
            if (size == 0) {
                asks.remove(price);
            } else {
                asks.put(price, size);
            }
        }
        
        public double getSpread() {
            if (bids.isEmpty() || asks.isEmpty()) {
                return -1; // No valid spread
            }
            return asks.firstKey() - bids.firstKey();
        }
        
        public Integer getBestBid() {
            return bids.isEmpty() ? null : bids.firstKey();
        }
        
        public Integer getBestAsk() {
            return asks.isEmpty() ? null : asks.firstKey();
        }
    }
}