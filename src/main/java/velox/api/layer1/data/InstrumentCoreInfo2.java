package velox.api.layer1.data;

import java.io.Serializable;
import java.util.Objects;

/**
 * Minimal sufficient amount of data to identify the instrument within any platform
 * 
 * @author Velox API Team
 * @version 7.6.0
 */
public class InstrumentCoreInfo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * The symbol identifier for the instrument
     */
    public final String symbol;
    
    /**
     * The exchange where the instrument is traded
     */
    public final String exchange;
    
    /**
     * For multiplatform mode might end with "@Platform", e.g. "@Rithmic"
     */
    public final String type;
    
    /**
     * Primary constructor for creating InstrumentCoreInfo instances
     * 
     * @param symbol The symbol identifier
     * @param exchange The exchange identifier
     * @param type The instrument type, potentially with platform suffix
     */
    public InstrumentCoreInfo(String symbol, String exchange, String type) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.type = type;
    }
    
    /**
     * Protected constructor for use by builder pattern
     * 
     * @param builder The builder instance containing the values
     */
    protected InstrumentCoreInfo(BuilderBase<?> builder) {
        this.symbol = builder.symbol;
        this.exchange = builder.exchange;
        this.type = builder.type;
    }
    
    /**
     * Create a builder instance from this InstrumentCoreInfo
     * 
     * @return A new builder instance populated with current values
     */
    public BuilderBase<?> toBuilder() {
        return new Builder()
            .setSymbol(this.symbol)
            .setExchange(this.exchange)
            .setType(this.type);
    }
    
    /**
     * Create a copy of this InstrumentCoreInfo with all null fields transformed into empty strings
     * 
     * @return A normalized copy of this instance
     */
    public InstrumentCoreInfo normalize() {
        return new InstrumentCoreInfo(
            this.symbol != null ? this.symbol : "",
            this.exchange != null ? this.exchange : "",
            this.type != null ? this.type : ""
        );
    }
    
    @Override
    public String toString() {
        return "InstrumentCoreInfo{" +
            "symbol='" + symbol + '\'' +
            ", exchange='" + exchange + '\'' +
            ", type='" + type + '\'' +
            '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        InstrumentCoreInfo that = (InstrumentCoreInfo) obj;
        return Objects.equals(symbol, that.symbol) &&
               Objects.equals(exchange, that.exchange) &&
               Objects.equals(type, that.type);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(symbol, exchange, type);
    }
    
    /**
     * Builder pattern for inheritance structures.
     * 
     * @param <T> The concrete builder type for method chaining
     */
    public static abstract class BuilderBase<T extends BuilderBase<T>> {
        protected String symbol;
        protected String exchange;
        protected String type;
        
        /**
         * Get the concrete builder instance for method chaining
         * 
         * @return The concrete builder instance
         */
        protected abstract T self();
        
        /**
         * Set the symbol for the instrument
         * 
         * @param symbol The symbol identifier
         * @return This builder instance for method chaining
         */
        public T setSymbol(String symbol) {
            this.symbol = symbol;
            return self();
        }
        
        /**
         * Set the exchange for the instrument
         * 
         * @param exchange The exchange identifier
         * @return This builder instance for method chaining
         */
        public T setExchange(String exchange) {
            this.exchange = exchange;
            return self();
        }
        
        /**
         * Set the type for the instrument
         * 
         * @param type The instrument type
         * @return This builder instance for method chaining
         */
        public T setType(String type) {
            this.type = type;
            return self();
        }
        
        /**
         * Build the InstrumentCoreInfo instance
         * 
         * @return A new InstrumentCoreInfo instance
         */
        public InstrumentCoreInfo build() {
            return new InstrumentCoreInfo(this);
        }
    }
    
    /**
     * Concrete builder implementation for InstrumentCoreInfo
     */
    public static class Builder extends BuilderBase<Builder> {
        
        @Override
        protected Builder self() {
            return this;
        }
        
        /**
         * Create a new builder instance
         * 
         * @return A new Builder instance
         */
        public static Builder create() {
            return new Builder();
        }
    }
}