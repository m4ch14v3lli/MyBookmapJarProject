package velox.api.layer1.common.helper;

import velox.api.layer1.data.SimpleOrderSendParameters;

/**
 * Example usage of OrderRepresentationHelper
 */
public class OrderRepresentationHelperExample {
    
    public static void main(String[] args) {
        // Create a sample order
        SimpleOrderSendParameters order = new SimpleOrderSendParameters(
            "LIMIT", 
            "BUY", 
            100.0, 
            150.75, 
            "AAPL"
        );
        
        // Create a price formatter
        OrderRepresentationHelper.PriceFormatter formatter = new OrderRepresentationHelper.PriceFormatter() {
            @Override
            public String formatPrice(double price) {
                return String.format("$%.2f", price);
            }
        };
        
        // Or using lambda expression (Java 8+)
        OrderRepresentationHelper.PriceFormatter lambdaFormatter = 
            price -> String.format("$%.2f", price);
        
        // Generate text representation
        String representation = OrderRepresentationHelper.textRepresentation(
            order, 
            formatter, 
            1.0
        );
        
        System.out.println("Order representation: " + representation);
        
        // Test with size multiplier
        String representationWithMultiplier = OrderRepresentationHelper.textRepresentation(
            order, 
            lambdaFormatter, 
            0.5
        );
        
        System.out.println("Order with size multiplier: " + representationWithMultiplier);
    }
}