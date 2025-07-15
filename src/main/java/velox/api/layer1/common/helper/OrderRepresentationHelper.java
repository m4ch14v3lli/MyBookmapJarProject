package velox.api.layer1.common.helper;

/**
 * Helper class for order representation functionality
 */
public class OrderRepresentationHelper {
    
    /**
     * Interface for formatting price values
     */
    public static interface PriceFormatter {
        
        /**
         * Formats a price value into a string representation
         * 
         * @param price the price value to format
         * @return formatted price as string
         */
        String format(double price);
    }
    
    // Example implementation of PriceFormatter
    public static class DefaultPriceFormatter implements PriceFormatter {
        
        @Override
        public String format(double price) {
            return String.format("%.2f", price);
        }
    }
    
    // Example usage method
    public static String formatPrice(double price, PriceFormatter formatter) {
        return formatter.format(price);
    }
    
    // Constructor
    public OrderRepresentationHelper() {
        // Default constructor
    }
}