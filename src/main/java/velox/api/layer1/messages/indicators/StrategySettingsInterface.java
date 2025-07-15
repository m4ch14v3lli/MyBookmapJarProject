package velox.api.layer1.messages.indicators;

/**
 * Interface StrategySettingsInterface describes the action when a user interacts
 * with the cog icon in the strategies configuration popup.
 */
public interface StrategySettingsInterface {

    /**
     * Method called when the user clicks the cog icon in the strategies configuration popup.
     */
    void showSettings();
}