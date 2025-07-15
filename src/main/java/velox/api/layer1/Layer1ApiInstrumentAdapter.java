package velox.api.layer1;

/**
 * Interface Layer1ApiInstrumentAdapter extends Layer1ApiInstrumentListener.
 * It defines methods for handling instrument-related events.
 */
public interface Layer1ApiInstrumentAdapter extends Layer1ApiInstrumentListener {

    /**
     * Called when an instrument is successfully subscribed.
     *
     * @param alias        The instrument alias.
     * @param instrumentInfo The specifications of the instrument.
     */
    default void onInstrumentAdded(String alias, InstrumentInfo instrumentInfo) {
        // Default implementation (can be overridden)
    }

    /**
     * Called when unsubscribing from an instrument.
     *
     * @param alias The instrument alias.
     */
    default void onInstrumentRemoved(String alias) {
        // Default implementation (can be overridden)
    }

    /**
     * Called when an attempt to subscribe fails because the instrument does not exist.
     *
     * @param symbol   The instrument symbol.
     * @param exchange The exchange.
     * @param type     The type of the instrument.
     */
    default void onInstrumentNotFound(String symbol, String exchange, String type) {
        // Default implementation (can be overridden)
    }

    /**
     * Called when an attempt to subscribe fails because the subscription is already active.
     *
     * @param symbol   The instrument symbol.
     * @param exchange The exchange.
     * @param type     The type of the instrument.
     */
    default void onInstrumentAlreadySubscribed(String symbol, String exchange, String type) {
        // Default implementation (can be overridden)
    }
}