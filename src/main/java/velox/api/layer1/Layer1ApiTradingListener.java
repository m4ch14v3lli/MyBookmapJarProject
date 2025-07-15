package velox.api.layer1;

import velox.api.layer1.data.BalanceInfo;
import velox.api.layer1.data.ExecutionInfo;
import velox.api.layer1.data.OrderInfoUpdate;
import velox.api.layer1.data.StatusInfo;

/**
 * Listener for order routing.
 * 
 * Multi-account support:
 * If there is a multi-account support from data provider, then account id should be specified for each
 * order update, status and balance update sent to this listener.
 * 
 * - If both data provider, and strategy has multi-account support (i.e. strategy is annotated with
 *   Layer1MultiAccountTradingSupported), then data for each account will be sent
 *   to the strategy, where each account is identified by accountId field.
 * 
 * - If data provider has multi-account support, but strategy doesn't, only data for primary account
 *   will be sent to the strategy (see AccountInfo.isPrimary).
 *   But accountId field still should be always non-null, to not mix nulls and primary account details from
 *   the same data provider and instrument.
 * 
 * - If data provider doesn't have multi-account support, then accountId field in the data sent by the data
 *   provider must be always null, and such data should relate to the single account.
 */
public interface Layer1ApiTradingListener {
    
    /**
     * Called when order is updated (order creation is also considered an update).
     * 
     * @param orderInfoUpdate information about update
     */
    void onOrderUpdated(OrderInfoUpdate orderInfoUpdate);
    
    /**
     * Called when one of our orders gets executed
     * 
     * @param executionInfo information about execution
     */
    void onOrderExecuted(ExecutionInfo executionInfo);
    
    /**
     * Called when instrument status information changes (PnL, number of open
     * orders, position, etc).
     * 
     * @param statusInfo status information
     */
    void onStatus(StatusInfo statusInfo);
    
    /**
     * Called when account balance information changes
     * 
     * @param balanceInfo account balance information
     */
    void onBalance(BalanceInfo balanceInfo);
}