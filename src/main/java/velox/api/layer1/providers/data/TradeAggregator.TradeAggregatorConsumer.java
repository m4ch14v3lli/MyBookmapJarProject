package velox.api.layer1.providers.data;

/**
 * Interface TradeAggregator.TradeAggregatorConsumer defines the contract for handling trade events.
 */
public interface TradeAggregatorConsumer {

    /**
     * Handles a trade event.
     *
     * @param price     The price of the trade.
     * @param size      The size of the trade.
     * @param tradeInfo Additional information about the trade.
     */
    void onTrade(double price, int size, TradeInfo tradeInfo);
}