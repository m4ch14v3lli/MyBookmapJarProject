package velox.api.layer1.messages.indicators;

import java.util.Set;

/**
 * Interface StrategyUpdateGeneratorFilter limits events and instrument aliases 
 * that the StrategyUpdateGenerator listens to.
 */
public interface StrategyUpdateGeneratorFilter {

    /**
     * Returns a set containing all update types you wish to receive. 
     * Return null to receive all update types.
     *
     * @return Set of update types
     */
    Set<StrategyUpdateGeneratorEventType> getGeneratorUpdateTypes();

    /**
     * Returns a set containing all aliases for which you wish to receive updates. 
     * Return null to receive updates for all aliases.
     *
     * @return Set of aliases
     */
    Set<String> getGeneratorAliases();

    /**
     * Enum representing the different event types for the StrategyUpdateGeneratorFilter.
     */
    enum StrategyUpdateGeneratorEventType {
        // Define event types as needed
        TYPE1,
        TYPE2,
        TYPE3
    }
}