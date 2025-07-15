package velox.api.layer1;

/**
 * Interface Layer1ApiTradingAdapter extends Layer1ApiTradingListener.
 * It provides methods to handle trading-related events.
 */
public interface Layer1ApiTradingAdapter extends Layer1ApiTradingListener {

    /**
     * Called when account balance information changes.
     *
     * @param balanceInfo Information about the account balance.
     */
    default void onBalance(BalanceInfo balanceInfo) {
        // Default implementation (can be overridden)
    }

    /**
     * Called when one of the orders gets executed.
     *
     * @param executionInfo Information about the execution.
     */
    default void onOrderExecuted(ExecutionInfo executionInfo) {
        // Default implementation (can be overridden)
    }

    /**
     * Called when an order is updated. Order creation is also considered an update.
     *
     * @param orderInfoUpdate Information about the order update.
     */
    default void onOrderUpdated(OrderInfoUpdate orderInfoUpdate) {
        // Default implementation (can be overridden)
    }

    /**
     * Called when instrument status information changes (PnL, number of open orders, position, etc.).
     *
     * @param statusInfo Information about the status.
     */
    default void onStatus(StatusInfo statusInfo) {
        // Default implementation (can be overridden)
    }
}