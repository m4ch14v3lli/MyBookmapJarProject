package velox.api.layer0.data;

/**
 * Record arbitrary text information that can later be viewed via bookmap.
 * It can be used for attaching any sort of information, e.g. decisions made by
 * your strategy during a test run.
 */
public class TextDataMessage {
    
    /**
     * Alias of the instrument this data relates to (null for global data)
     */
    public final String alias;
    
    /**
     * Source of the event, can be null; Describes what is the origin of event
     * (e.g. "My Indicator 1"), shown by Bookmap when inspecting data
     */
    public final String source;
    
    /**
     * True if data is associated with bid side, false - with ask; null if none
     */
    public final Boolean isBid;
    
    /**
     * Price linked to the event, Double.NaN if not applicable
     */
    public final double price;
    
    /**
     * Size linked to the event, Double.NaN if not applicable
     */
    public final double size;
    
    /**
     * The data itself; it's not supposed to be processed programmatically,
     * so there are no requirements to it; can be null if you only need other fields;
     * please keep in mind that using excessively long strings will affect performance
     */
    public final String data;
    
    /**
     * Create a new message to record arbitrary text information that can later be viewed via bookmap.
     * It can be used for attaching any sort of information, e.g. decisions made by
     * your strategy during a test run.
     * 
     * @param alias alias of the instrument this data relates to (null for global data)
     * @param source source of the event, can be null; Describes what is the origin of event
     *               (e.g. "My Indicator 1"), shown by Bookmap when inspecting data
     * @param isBid true if data is associated with bid side, false - with ask; null if none
     * @param price price linked to the event, Double.NaN if not applicable
     * @param size size linked to the event, Double.NaN if not applicable
     * @param data the data itself; it's not supposed to be processed programmatically,
     *             so there are no requirements to it; can be null if you only need other fields;
     *             please keep in mind that using excessively long strings will affect performance
     */
    public TextDataMessage(String alias, String source, Boolean isBid, double price, double size, String data) {
        this.alias = alias;
        this.source = source;
        this.isBid = isBid;
        this.price = price;
        this.size = size;
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "TextDataMessage{" +
                "alias='" + alias + '\'' +
                ", source='" + source + '\'' +
                ", isBid=" + isBid +
                ", price=" + price +
                ", size=" + size +
                ", data='" + data + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        TextDataMessage that = (TextDataMessage) o;
        
        if (Double.compare(that.price, price) != 0) return false;
        if (Double.compare(that.size, size) != 0) return false;
        if (alias != null ? !alias.equals(that.alias) : that.alias != null) return false;
        if (source != null ? !source.equals(that.source) : that.source != null) return false;
        if (isBid != null ? !isBid.equals(that.isBid) : that.isBid != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }
    
    @Override
    public int hashCode() {
        int result;
        long temp;
        result = alias != null ? alias.hashCode() : 0;
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (isBid != null ? isBid.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(size);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}