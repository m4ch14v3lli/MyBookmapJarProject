package velox.api.layer1;

/**
 * Interface Layer1ApiInstrumentSpecificEnabledStateProvider defines methods for handling
 * the enabled state of strategies related to specific instruments.
 */
public interface Layer1ApiInstrumentSpecificEnabledStateProvider {

    /**
     * Called when the strategy checkbox is enabled or disabled.
     *
     * @param alias    The instrument alias.
     * @param isEnabled True if the checkbox is selected; false otherwise.
     */
    void onStrategyCheckboxEnabled(String alias, boolean isEnabled);

    /**
     * Checks if the strategy is currently enabled for the given alias.
     *
     * @param alias The instrument alias.
     * @return true if the strategy is enabled; false otherwise.
     */
    boolean isStrategyEnabled(String alias);

    /**
     * Sets a callback that allows the strategy to notify that the enabled state has changed.
     *
     * @param alias           The instrument alias.
     * @param recheckCallback The runnable to call if the enabled state has changed.
     */
    default void setStrategyEnabledRecheckCallback(String alias, Runnable recheckCallback) {
        // Default implementation (can be overridden)
    }
}