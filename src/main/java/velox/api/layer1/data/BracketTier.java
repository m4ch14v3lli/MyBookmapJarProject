package velox.api.layer1.data;

/**
 * Describes a single tier of the bracket.
 * 
 * This class represents a bracket tier in a trading system, containing
 * offset information, size, and client identification for order management.
 */
public class BracketTier {
    
    /**
     * Similar to SimpleOrderSendParameters.takeProfitOffset, but for a single tier.
     * Represents the price offset from the parent order price.
     */
    public final int offset;
    
    /**
     * Size of the tier.
     * Represents the quantity/volume for this specific tier.
     */
    public final int size;
    
    /**
     * Client id for the corresponding order, similar to SingleOrderSendParameters.clientId.
     * Used for tracking and identifying the order associated with this tier.
     */
    public final String clientId;
    
    /**
     * Constructs a BracketTier with the specified offset and size.
     * The clientId will be set to null when using this constructor.
     * 
     * @param offset the price offset for this tier
     * @param size the size/quantity for this tier
     */
    public BracketTier(int offset, int size) {
        this.offset = offset;
        this.size = size;
        this.clientId = null;
    }
    
    /**
     * Constructs a BracketTier with the specified offset, size, and client ID.
     * 
     * @param offset the price offset for this tier
     * @param size the size/quantity for this tier
     * @param clientId the client identifier for this tier's order
     */
    public BracketTier(int offset, int size, String clientId) {
        this.offset = offset;
        this.size = size;
        this.clientId = clientId;
    }
    
    /**
     * Returns a string representation of this BracketTier.
     * 
     * @return a string containing the offset, size, and clientId
     */
    @Override
    public String toString() {
        return "BracketTier{" +
                "offset=" + offset +
                ", size=" + size +
                ", clientId='" + clientId + '\'' +
                '}';
    }
    
    /**
     * Indicates whether some other object is "equal to" this one.
     * 
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        BracketTier that = (BracketTier) obj;
        
        if (offset != that.offset) return false;
        if (size != that.size) return false;
        return clientId != null ? clientId.equals(that.clientId) : that.clientId == null;
    }
    
    /**
     * Returns a hash code value for the object.
     * 
     * @return a hash code value for this object
     */
    @Override
    public int hashCode() {
        int result = offset;
        result = 31 * result + size;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        return result;
    }
}