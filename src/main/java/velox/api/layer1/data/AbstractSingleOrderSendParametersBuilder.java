package velox.api.layer1.data;

/**
 * Abstract builder class for single order send parameters.
 * Uses the builder pattern with fluent interface and method chaining.
 * 
 * @param <T> The concrete builder type that extends this abstract builder
 */
public abstract class AbstractSingleOrderSendParametersBuilder<T extends AbstractSingleOrderSendParametersBuilder<T>> {
    
    // Protected fields for order parameters
    protected String alias;
    protected boolean isBuy;
    protected int size;
    protected OrderDuration duration;
    protected String clientId;
    protected String accountId;
    
    /**
     * Default constructor
     */
    protected AbstractSingleOrderSendParametersBuilder() {
    }
    
    /**
     * Constructor with core order parameters (without accountId)
     * 
     * @param alias The instrument alias
     * @param isBuy Whether this is a buy order
     * @param size The order size
     * @param duration The order duration
     * @param clientId The client identifier
     */
    protected AbstractSingleOrderSendParametersBuilder(String alias, boolean isBuy, int size, 
                                                       OrderDuration duration, String clientId) {
        this.alias = alias;
        this.isBuy = isBuy;
        this.size = size;
        this.duration = duration;
        this.clientId = clientId;
    }
    
    /**
     * Constructor with all order parameters including accountId
     * 
     * @param alias The instrument alias
     * @param isBuy Whether this is a buy order
     * @param size The order size
     * @param duration The order duration
     * @param clientId The client identifier
     * @param accountId The account identifier
     */
    protected AbstractSingleOrderSendParametersBuilder(String alias, boolean isBuy, int size, 
                                                       OrderDuration duration, String clientId, String accountId) {
        this.alias = alias;
        this.isBuy = isBuy;
        this.size = size;
        this.duration = duration;
        this.clientId = clientId;
        this.accountId = accountId;
    }
    
    /**
     * Builds the final SingleOrderSendParameters object
     * 
     * @return The constructed SingleOrderSendParameters instance
     */
    public abstract SingleOrderSendParameters build();
    
    /**
     * Gets the instrument alias
     * 
     * @return The alias
     */
    public String getAlias() {
        return alias;
    }
    
    /**
     * Sets the instrument alias
     * 
     * @param alias The instrument alias
     * @return This builder instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public T setAlias(String alias) {
        this.alias = alias;
        return (T) this;
    }
    
    /**
     * Checks if this is a buy order
     * 
     * @return true if buy order, false if sell order
     */
    public boolean isBuy() {
        return isBuy;
    }
    
    /**
     * Sets the order direction (buy/sell)
     * 
     * @param isBuy true for buy order, false for sell order
     * @return This builder instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public T setBuy(boolean isBuy) {
        this.isBuy = isBuy;
        return (T) this;
    }
    
    /**
     * Gets the order size
     * 
     * @return The order size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Sets the order size
     * 
     * @param size The order size
     * @return This builder instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public T setSize(int size) {
        this.size = size;
        return (T) this;
    }
    
    /**
     * Gets the order duration
     * 
     * @return The order duration
     */
    public OrderDuration getDuration() {
        return duration;
    }
    
    /**
     * Sets the order duration
     * 
     * @param duration The order duration
     * @return This builder instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public T setDuration(OrderDuration duration) {
        this.duration = duration;
        return (T) this;
    }
    
    /**
     * Gets the client identifier
     * 
     * @return The client ID
     */
    public String getClientId() {
        return clientId;
    }
    
    /**
     * Sets the client identifier
     * 
     * @param clientId The client identifier
     * @return This builder instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public T setClientId(String clientId) {
        this.clientId = clientId;
        return (T) this;
    }
    
    /**
     * Gets the account identifier
     * 
     * @return The account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Sets the account identifier
     * 
     * @param accountId The account identifier
     * @return This builder instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public T setAccountId(String accountId) {
        this.accountId = accountId;
        return (T) this;
    }
    
    /**
     * Returns a string representation of the builder
     * 
     * @return String representation containing all field values
     */
    @Override
    public String toString() {
        return "AbstractSingleOrderSendParametersBuilder{" +
                "alias='" + alias + '\'' +
                ", isBuy=" + isBuy +
                ", size=" + size +
                ", duration=" + duration +
                ", clientId='" + clientId + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}