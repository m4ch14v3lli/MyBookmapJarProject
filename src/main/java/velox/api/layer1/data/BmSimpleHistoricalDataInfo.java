package velox.api.layer1.data;

import java.util.function.Function;

/**
 * Interface for historical data information.
 * Defines the contract for historical data retrieval parameters.
 */
public interface HistoricalDataInfo {
    // Marker interface for historical data information implementations
}

/**
 * Represents subscription information for market data.
 * Contains details about the instrument and subscription parameters.
 */
public class SubscribeInfo {
    private String symbol;
    private String exchange;
    private String dataType;
    private long subscriptionId;
    
    public SubscribeInfo() {
    }
    
    public SubscribeInfo(String symbol, String exchange, String dataType) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.dataType = dataType;
        this.subscriptionId = System.currentTimeMillis();
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    
    public String getExchange() {
        return exchange;
    }
    
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
    
    public String getDataType() {
        return dataType;
    }
    
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
    public long getSubscriptionId() {
        return subscriptionId;
    }
    
    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }
    
    @Override
    public String toString() {
        return "SubscribeInfo{" +
                "symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", dataType='" + dataType + '\'' +
                ", subscriptionId=" + subscriptionId +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SubscribeInfo that = (SubscribeInfo) obj;
        return subscriptionId == that.subscriptionId &&
                symbol.equals(that.symbol) &&
                exchange.equals(that.exchange) &&
                dataType.equals(that.dataType);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(symbol, exchange, dataType, subscriptionId);
    }
}

/**
 * Describes parameters for data retrieval from Bookmap simple historical server.
 * 
 * This class implements HistoricalDataInfo interface and provides configuration
 * for connecting to historical data servers and determining import durations
 * for different instruments.
 */
public class BmSimpleHistoricalDataInfo implements HistoricalDataInfo {
    
    /**
     * URL of historical server
     */
    public final String serverUrl;
    
    /**
     * A mapping from SubscribeInfo to the Long.
     * 
     * Used for selecting default or the closest available historical import 
     * duration value in subscription dialog.
     * 
     * Returns default historical import duration in nanoseconds.
     */
    public final Function<SubscribeInfo, Long> instrumentToImportDuration;
    
    /**
     * Constructor with server URL only.
     * Uses default import duration function.
     * 
     * @param serverUrl URL of the historical data server
     */
    public BmSimpleHistoricalDataInfo(String serverUrl) {
        this.serverUrl = serverUrl;
        this.instrumentToImportDuration = this::getDefaultImportDuration;
    }
    
    /**
     * Constructor with server URL and custom import duration function.
     * 
     * @param serverUrl URL of the historical data server
     * @param instrumentToImportDuration Function to determine import duration for instruments
     */
    public BmSimpleHistoricalDataInfo(String serverUrl, 
                                    Function<SubscribeInfo, Long> instrumentToImportDuration) {
        this.serverUrl = serverUrl;
        this.instrumentToImportDuration = instrumentToImportDuration;
    }
    
    /**
     * Default implementation for determining import duration.
     * Returns default duration of 24 hours in nanoseconds.
     * 
     * @param subscribeInfo The subscription information
     * @return Default import duration in nanoseconds
     */
    private Long getDefaultImportDuration(SubscribeInfo subscribeInfo) {
        // Default to 24 hours in nanoseconds
        return 24L * 60L * 60L * 1000L * 1000L * 1000L;
    }
    
    /**
     * Gets the historical server URL.
     * 
     * @return The server URL
     */
    public String getServerUrl() {
        return serverUrl;
    }
    
    /**
     * Gets the import duration for a specific instrument.
     * 
     * @param subscribeInfo The subscription information for the instrument
     * @return Import duration in nanoseconds
     */
    public Long getImportDuration(SubscribeInfo subscribeInfo) {
        return instrumentToImportDuration.apply(subscribeInfo);
    }
    
    /**
     * Gets the instrument to import duration function.
     * 
     * @return The function mapping SubscribeInfo to import duration
     */
    public Function<SubscribeInfo, Long> getInstrumentToImportDuration() {
        return instrumentToImportDuration;
    }
    
    @Override
    public String toString() {
        return "BmSimpleHistoricalDataInfo{" +
                "serverUrl='" + serverUrl + '\'' +
                ", instrumentToImportDuration=" + instrumentToImportDuration +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BmSimpleHistoricalDataInfo that = (BmSimpleHistoricalDataInfo) obj;
        return serverUrl.equals(that.serverUrl) &&
                instrumentToImportDuration.equals(that.instrumentToImportDuration);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(serverUrl, instrumentToImportDuration);
    }
}