package velox.api.layer1;

import velox.api.layer1.data.OrderSendParameters;
import velox.api.layer1.data.OrderUpdateParameters;

/**
 * Interface for providing trading functionality with order management capabilities.
 * Classes implementing this interface should provide the ability to work with orders.
 * 
 * This interface extends Layer1ApiTradingListenable to support event listening
 * for trading operations.
 */
public interface Layer1ApiTradingProvider extends Layer1ApiTradingListenable {
    
    /**
     * Submit order with specified parameters.
     * 
     * @param orderSendParameters the parameters containing order details for submission
     */
    void sendOrder(OrderSendParameters orderSendParameters);
    
    /**
     * Update order according to parameters.
     * 
     * @param orderUpdateParameters the parameters containing order update details
     */
    void updateOrder(OrderUpdateParameters orderUpdateParameters);
}