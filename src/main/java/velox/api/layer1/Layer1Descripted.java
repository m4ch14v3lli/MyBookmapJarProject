package velox.api.layer1;

/**
 * Interface Layer1Descripted is implemented by strategies that wish to display a description
 * in the strategies dialog.
 */
public interface Layer1Descripted {

    /**
     * Retrieves the description of the strategy.
     *
     * @return A string representing the description of the strategy.
     */
    String getDescription();
}