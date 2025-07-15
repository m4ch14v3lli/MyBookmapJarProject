package velox.api.layer1.data;

/**
 * Tells Bookmap how to get historical data. See subclasses for details.
 */
public interface HistoricalDataInfo {
    // Interface methods would be defined here based on the actual implementation
    // Since this is just the Javadoc, the actual method signatures are not visible
    // but typically would include methods for retrieving historical data
}

/**
 * Simple implementation of HistoricalDataInfo for Bookmap
 * This class provides basic historical data retrieval functionality
 */
public class BmSimpleHistoricalDataInfo implements HistoricalDataInfo {
    // Implementation details would go here
    // Constructor, fields, and method implementations
    
    public BmSimpleHistoricalDataInfo() {
        // Default constructor
    }
    
    // Implement interface methods here
}

/**
 * Per-instrument implementation of HistoricalDataInfo
 * This class provides instrument-specific historical data retrieval
 */
public class PerInstrumentHistoricalDataInfo implements HistoricalDataInfo {
    // Implementation details would go here
    // Constructor, fields, and method implementations
    
    public PerInstrumentHistoricalDataInfo() {
        // Default constructor
    }
    
    // Implement interface methods here
}