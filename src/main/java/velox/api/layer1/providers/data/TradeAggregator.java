package velox.api.layer1.providers.data;

/**
 * Class TradeAggregator provides logic for trade aggregation and implements Runnable.
 */
public final class TradeAggregator implements Runnable {

    private final TradeAggregatorConsumer callback;

    /**
     * Creates a new instance of TradeAggregator.
     *
     * @param callback Callback for reporting trades upstream.
     */
    public TradeAggregator(TradeAggregatorConsumer callback) {
        this.callback = callback;
    }

    /**
     * Handles trades aggregation logic and forwards the trade.
     *
     * @param price            The trade price.
     * @param aTicketId       The ticket ID associated with the trade.
     * @param isBidAggressor   Indicates if the bid is the aggressor.
     * @param isOtc           Indicates if the trade is OTC.
     * @param size             The size of the trade.
     */
    public void onTrade(double price, String aTicketId, boolean isBidAggressor, boolean isOtc, int size) {
        // Trade aggregation logic here
    }

    /**
     * Handles trades aggregation logic with additional identifiers.
     *
     * @param price            The trade price.
     * @param aTicketId       The ticket ID associated with the trade.
     * @param isBidAggressor   Indicates if the bid is the aggressor.
     * @param isOtc           Indicates if the trade is OTC.
     * @param size             The size of the trade.
     * @param aggressorOrderId The ID of the aggressor order.
     * @param passiveOrderId   The ID of the passive order.
     */
    public void onTrade(double price, String aTicketId, boolean isBidAggressor, boolean isOtc, int size,
                        String aggressorOrderId, String passiveOrderId) {
        // Trade aggregation logic here
    }

    @Override
    public void run() {
        // Implementation of Runnable's run method
    }

    /**
     * Interface for consuming trade aggregation events.
     */
    public interface TradeAggregatorConsumer {
        void onTradeAggregated(TradeInfo tradeInfo);
    }
}