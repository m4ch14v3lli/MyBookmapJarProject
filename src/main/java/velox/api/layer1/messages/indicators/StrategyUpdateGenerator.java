package velox.api.layer1.messages.indicators;

/**
 * Interface StrategyUpdateGenerator can generate custom events 
 * in response to depth/trade updates.
 */
public interface StrategyUpdateGenerator extends Layer1ApiDataAdapter, 
        Layer1ApiMboDataAdapter, Layer1ApiTradingAdapter, 
        Layer1ApiInstrumentAdapter, GeneratedUpdateConsumer {

    /**
     * Called when a user message is received. 
     * Currently only iceberg messages are passed here.
     *
     * @param data the message data
     */
    void onUserMessage(Object data);

    /**
     * Sets the time for following updates.
     *
     * @param time the time to be set
     */
    void setTime(long time);
}