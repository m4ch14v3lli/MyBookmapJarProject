package velox.api.layer1;

/**
 * Interface Layer1ApiMboDataAdapter extends Layer1ApiMboDataListener.
 * It provides methods for handling Market By Order (MBO) data events.
 */
public interface Layer1ApiMboDataAdapter extends Layer1ApiMboDataListener {

    /**
     * Called when an MBO order is sent.
     *
     * @param alias   The instrument alias.
     * @param orderId The ID of the order.
     * @param isBid   True if the order is a bid; false if it's an ask.
     * @param price   The price of the order.
     * @param size    The size of the order.
     */
    default void onMboSend(String alias, String orderId, boolean isBid, int price, int size) {
        // Default implementation (can be overridden)
    }

    /**
     * Called when an MBO order is replaced.
     *
     * @param alias   The instrument alias.
     * @param orderId The ID of the order.
     * @param price   The new price of the order.
     * @param size    The new size of the order.
     */
    default void onMboReplace(String alias, String orderId, int price, int size) {
        // Default implementation (can be overridden)
    }

    /**
     * Called when an MBO order is canceled.
     *
     * @param alias   The instrument alias.
     * @param orderId The ID of the order.
     */
    default void onMboCancel(String alias, String orderId) {
        // Default implementation (can be overridden)
    }
}