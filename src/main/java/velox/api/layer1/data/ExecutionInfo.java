package velox.api.layer1.data;

import java.io.Serializable;

/**
 * Information about order execution
 */
public class ExecutionInfo extends Object implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Order ID
     */
    public final String orderId;
    
    /**
     * Size of the execution
     */
    public final int size;
    
    /**
     * Price where execution happened
     */
    public final double price;
    
    /**
     * Execution ID
     */
    public final String executionId;
    
    /**
     * Time when execution happened
     */
    public final long time;
    
    /**
     * True if execution is simulated by Bookmap.
     */
    public final boolean isSimulated;
    
    /**
     * Constructor with basic parameters (isSimulated defaults to false)
     * 
     * @param orderId The order ID
     * @param size Size of the execution
     * @param price Price where execution happened
     * @param executionId Execution ID
     * @param time Time when execution happened
     */
    public ExecutionInfo(String orderId, int size, double price, String executionId, long time) {
        this.orderId = orderId;
        this.size = size;
        this.price = price;
        this.executionId = executionId;
        this.time = time;
        this.isSimulated = false;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param orderId The order ID
     * @param size Size of the execution
     * @param price Price where execution happened
     * @param executionId Execution ID
     * @param time Time when execution happened
     * @param isSimulated True if execution is simulated by Bookmap
     */
    public ExecutionInfo(String orderId, int size, double price, String executionId, long time, boolean isSimulated) {
        this.orderId = orderId;
        this.size = size;
        this.price = price;
        this.executionId = executionId;
        this.time = time;
        this.isSimulated = isSimulated;
    }
    
    /**
     * Copy constructor
     * 
     * @param executionInfo ExecutionInfo to copy from
     */
    public ExecutionInfo(ExecutionInfo executionInfo) {
        this.orderId = executionInfo.orderId;
        this.size = executionInfo.size;
        this.price = executionInfo.price;
        this.executionId = executionInfo.executionId;
        this.time = executionInfo.time;
        this.isSimulated = executionInfo.isSimulated;
    }
    
    /**
     * Returns a string representation of the ExecutionInfo object
     * 
     * @return String representation
     */
    @Override
    public String toString() {
        return "ExecutionInfo{" +
                "orderId='" + orderId + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", executionId='" + executionId + '\'' +
                ", time=" + time +
                ", isSimulated=" + isSimulated +
                '}';
    }
    
    /**
     * Returns a builder for creating ExecutionInfo instances
     * 
     * @return ExecutionInfoBuilder instance
     */
    public ExecutionInfoBuilder toBuilder() {
        return new ExecutionInfoBuilder()
                .setOrderId(this.orderId)
                .setSize(this.size)
                .setPrice(this.price)
                .setExecutionId(this.executionId)
                .setTime(this.time)
                .setSimulated(this.isSimulated);
    }
    
    /**
     * Getter for orderId
     * 
     * @return orderId
     */
    public String getOrderId() {
        return orderId;
    }
    
    /**
     * Getter for size
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Getter for price
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Getter for executionId
     * 
     * @return executionId
     */
    public String getExecutionId() {
        return executionId;
    }
    
    /**
     * Getter for time
     * 
     * @return time
     */
    public long getTime() {
        return time;
    }
    
    /**
     * Getter for isSimulated
     * 
     * @return isSimulated
     */
    public boolean isSimulated() {
        return isSimulated;
    }
    
    /**
     * Equals method for comparing ExecutionInfo objects
     * 
     * @param obj Object to compare with
     * @return true if objects are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        ExecutionInfo that = (ExecutionInfo) obj;
        
        if (size != that.size) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (time != that.time) return false;
        if (isSimulated != that.isSimulated) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        return executionId != null ? executionId.equals(that.executionId) : that.executionId == null;
    }
    
    /**
     * Hash code method for ExecutionInfo objects
     * 
     * @return hash code
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + size;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (executionId != null ? executionId.hashCode() : 0);
        result = 31 * result + (int) (time ^ (time >>> 32));
        result = 31 * result + (isSimulated ? 1 : 0);
        return result;
    }
}