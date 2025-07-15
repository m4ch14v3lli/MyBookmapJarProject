package velox.api.layer1;

/**
 * Interface Layer1ApiDataAdapter extends Layer1ApiDataListener
 * and provides default methods for handling data events.
 */
public interface Layer1ApiDataAdapter extends Layer1ApiDataListener {

    /**
     * Default method called for depth data updates.
     *
     * @param alias    The instrument alias.
     * @param isBid    True if the update is for bids, false for asks.
     * @param price    The price where size changed.
     * @param size     The new size.
     */
    default void onDepth(String alias, boolean isBid, int price, int size) {
        // Default implementation (can be overridden)
    }

    /**
     * Default method called for market mode updates.
     *
     * @param alias      The instrument alias.
     * @param marketMode The new market mode.
     */
    default void onMarketMode(String alias, MarketMode marketMode) {
        // Default implementation (can be overridden)
    }

    /**
     * Default method called for trade events.
     *
     * @param alias     The instrument alias.
     * @param price     The trade price.
     * @param size      The trade size.
     * @param tradeInfo Additional information about the trade.
     */
    default void onTrade(String alias, double price, int size, TradeInfo tradeInfo) {
        // Default implementation (can be overridden)
    }
}