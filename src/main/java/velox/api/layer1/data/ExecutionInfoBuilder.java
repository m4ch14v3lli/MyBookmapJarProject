package velox.api.layer1.data;

/**
 * Builder class for creating ExecutionInfo instances
 */
public class ExecutionInfoBuilder {
    
    private String orderId;
    private int size;
    private double price;
    private String executionId;
    private long time;
    private boolean isSimulated = false;
    
    /**
     * Default constructor
     */
    public ExecutionInfoBuilder() {
    }
    
    /**
     * Set the order ID
     * 
     * @param orderId Order ID
     * @return ExecutionInfoBuilder instance for chaining
     */
    public ExecutionInfoBuilder setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }
    
    /**
     * Set the execution size
     * 
     * @param size Size of the execution
     * @return ExecutionInfoBuilder instance for chaining
     */
    public ExecutionInfoBuilder setSize(int size) {
        this.size = size;
        return this;
    }
    
    /**
     * Set the execution price
     * 
     * @param price Price where execution happened
     * @return ExecutionInfoBuilder instance for chaining
     */
    public ExecutionInfoBuilder setPrice(double price) {
        this.price = price;
        return this;
    }
    
    /**
     * Set the execution ID
     * 
     * @param executionId Execution ID
     * @return ExecutionInfoBuilder instance for chaining
     */
    public ExecutionInfoBuilder setExecutionId(String executionId) {
        this.executionId = executionId;
        return this;
    }
    
    /**
     * Set the execution time
     * 
     * @param time Time when execution happened
     * @return ExecutionInfoBuilder instance for chaining
     */
    public ExecutionInfoBuilder setTime(long time) {
        this.time = time;
        return this;
    }
    
    /**
     * Set whether execution is simulated
     * 
     * @param isSimulated True if execution is simulated by Bookmap
     * @return ExecutionInfoBuilder instance for chaining
     */
    public ExecutionInfoBuilder setSimulated(boolean isSimulated) {
        this.isSimulated = isSimulated;
        return this;
    }
    
    /**
     * Build the ExecutionInfo instance
     * 
     * @return ExecutionInfo instance
     * @throws IllegalArgumentException if required fields are missing
     */
    public ExecutionInfo build() {
        if (orderId == null) {
            throw new IllegalArgumentException("OrderId cannot be null");
        }
        if (executionId == null) {
            throw new IllegalArgumentException("ExecutionId cannot be null");
        }
        
        return new ExecutionInfo(orderId, size, price, executionId, time, isSimulated);
    }
    
    /**
     * Create a new ExecutionInfoBuilder instance
     * 
     * @return New ExecutionInfoBuilder instance
     */
    public static ExecutionInfoBuilder newBuilder() {
        return new ExecutionInfoBuilder();
    }
}