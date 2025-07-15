package velox.api.layer1.messages.indicators;

/**
 * Interface StrategyUpdateGeneratorSkipper allows a generator to skip part of the initial generation phase.
 */
public interface StrategyUpdateGeneratorSkipper {

    /**
     * Determines if the generator can skip to the end of the calculation.
     *
     * @return true if the generator should skip to the end; false otherwise.
     */
    boolean skipToRealtimeRequested();
}