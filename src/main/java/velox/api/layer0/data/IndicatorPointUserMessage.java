package velox.api.layer0.data;

/**
 * Allows defining indicator points similar to Recorder API. You may use it for now
 * in L0 addons, but for L1 use Indicator API or the Screen Space Painter API instead.
 * 
 * @deprecated This class is deprecated. Use Layer1ApiUserMessageModifyIndicator 
 * or Layer1ApiUserMessageModifyScreenSpacePainter for L1 implementations.
 * 
 * @see velox.api.layer1.messages.indicators.Layer1ApiUserMessageModifyIndicator
 * @see velox.api.layer1.messages.indicators.Layer1ApiUserMessageModifyScreenSpacePainter
 */
@Deprecated
public class IndicatorPointUserMessage {
    
    /**
     * Indicator identifier
     */
    public final int id;
    
    /**
     * Price level where the indicator icon will be displayed
     */
    public final double price;
    
    /**
     * Creates a new indicator point user message.
     * 
     * @param id indicator id
     * @param price new price (this is where the icon will be displayed)
     */
    public IndicatorPointUserMessage(int id, double price) {
        this.id = id;
        this.price = price;
    }
    
    /**
     * Returns the indicator ID.
     * 
     * @return the indicator identifier
     */
    public int getId() {
        return id;
    }
    
    /**
     * Returns the price level for the indicator.
     * 
     * @return the price where the indicator will be displayed
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Returns a string representation of this indicator point message.
     * 
     * @return string representation containing id and price
     */
    @Override
    public String toString() {
        return "IndicatorPointUserMessage{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }
    
    /**
     * Checks equality based on id and price.
     * 
     * @param obj object to compare with
     * @return true if objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        IndicatorPointUserMessage that = (IndicatorPointUserMessage) obj;
        return id == that.id && Double.compare(that.price, price) == 0;
    }
    
    /**
     * Generates hash code based on id and price.
     * 
     * @return hash code value
     */
    @Override
    public int hashCode() {
        int result = id;
        long temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}