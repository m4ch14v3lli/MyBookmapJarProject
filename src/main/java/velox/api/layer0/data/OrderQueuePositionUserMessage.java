package velox.api.layer0.data;

/**
 * Allows to set order position in queue, exists for compatibility with Recorder
 * API. Will be removed in the future in favor of L2-api based solution
 * 
 * @deprecated This class is deprecated and will be removed in future versions
 */
@Deprecated
public class OrderQueuePositionUserMessage {
    
    /**
     * Order identifier
     * @deprecated This field is deprecated
     */
    @Deprecated
    public final String orderId;
    
    /**
     * Position in the queue
     * @deprecated This field is deprecated
     */
    @Deprecated
    public final int position;
    
    /**
     * Record order position in the queue
     * 
     * @param orderId order id
     * @param position number of shares to be executed before this order
     *                 
     *                 You can use TagsExt.QUEUE_POSITION_AUTO if you want to
     *                 switch back to automatic computation or
     *                 TagsExt.QUEUE_POSITION_HIDE if you want to hide order
     *                 position mark regardless of settings
     * @deprecated This constructor is deprecated
     */
    @Deprecated
    public OrderQueuePositionUserMessage(String orderId, int position) {
        this.orderId = orderId;
        this.position = position;
    }
}