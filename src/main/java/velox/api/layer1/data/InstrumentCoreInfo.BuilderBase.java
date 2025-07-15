package velox.api.layer1.data;

/**
 * Core information about a financial instrument.
 * This class serves as the base for instrument information hierarchy.
 */
public abstract class InstrumentCoreInfo {
    
    protected final String symbol;
    protected final String exchange;
    protected final String type;
    
    protected InstrumentCoreInfo(String symbol, String exchange, String type) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.type = type;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public String getExchange() {
        return exchange;
    }
    
    public String getType() {
        return type;
    }
    
    /**
     * Creates a builder instance for this instrument info.
     * Subclasses should override this method to ensure the correct builder class is created,
     * otherwise you will lose some fields and receive wrong InstrumentInfo subtype.
     */
    public abstract Builder toBuilder();
    
    /**
     * Builder pattern for inheritance structures.
     * 
     * Inheritance hierarchy works like this:
     * InstrumentCoreInfo.BuilderBase <- InstrumentCoreInfo.Builder
     *              ^
     *              |
     * InstrumentInfo.BuilderBase <- InstrumentInfo.Builder
     *              ^
     *              |
     * InstrumentInfoDxfeed.Builder
     * 
     * If you want to add another builder to inheritance after last child (for example after InstrumentInfoDxfeed.Builder)
     * you should split the existing builder into concrete and abstract classes
     * (like InstrumentInfoDxfeed.BuilderBase and InstrumentInfoDxfeed.Builder), and extend your new concrete builder
     * from created abstract class.
     * 
     * Methods that you should override for everything to work correctly:
     * - self(), build() - in the concrete builder class
     * - setFieldsFrom(InstrumentCoreInfo) - in the child builder base class with correct InstrumentInfo type
     * - InstrumentCoreInfo.toBuilder() - in the InstrumentInfo subclasses to ensure the correct builder class is created
     */
    public abstract static class BuilderBase<T extends BuilderBase<T>> {
        
        protected String symbol;
        protected String exchange;
        protected String type;
        
        public BuilderBase() {
            // Default constructor
        }
        
        /**
         * Returns the concrete builder instance for method chaining.
         * Must be implemented by concrete builder classes.
         */
        protected abstract T self();
        
        /**
         * Builds the final InstrumentCoreInfo instance.
         * Must be implemented by concrete builder classes.
         */
        public abstract InstrumentCoreInfo build();
        
        /**
         * Sets fields from an existing InstrumentCoreInfo instance.
         * Child builder base classes should override this method with correct InstrumentInfo type.
         */
        public T setFieldsFrom(InstrumentCoreInfo info) {
            if (info != null) {
                this.symbol = info.getSymbol();
                this.exchange = info.getExchange();
                this.type = info.getType();
            }
            return self();
        }
        
        public String getSymbol() {
            return symbol;
        }
        
        public T setSymbol(String symbol) {
            this.symbol = symbol;
            return self();
        }
        
        public String getExchange() {
            return exchange;
        }
        
        public T setExchange(String exchange) {
            this.exchange = exchange;
            return self();
        }
        
        public String getType() {
            return type;
        }
        
        public T setType(String type) {
            this.type = type;
            return self();
        }
    }
    
    /**
     * Concrete builder class for InstrumentCoreInfo.
     * This is a direct subclass of BuilderBase.
     */
    public static class Builder extends BuilderBase<Builder> {
        
        public Builder() {
            super();
        }
        
        @Override
        protected Builder self() {
            return this;
        }
        
        @Override
        public InstrumentCoreInfo build() {
            return new ConcreteInstrumentCoreInfo(symbol, exchange, type);
        }
    }
    
    /**
     * Concrete implementation of InstrumentCoreInfo for the base Builder.
     * This is a private implementation detail.
     */
    private static class ConcreteInstrumentCoreInfo extends InstrumentCoreInfo {
        
        private ConcreteInstrumentCoreInfo(String symbol, String exchange, String type) {
            super(symbol, exchange, type);
        }
        
        @Override
        public Builder toBuilder() {
            return new Builder().setFieldsFrom(this);
        }
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        InstrumentCoreInfo that = (InstrumentCoreInfo) obj;
        
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        if (exchange != null ? !exchange.equals(that.exchange) : that.exchange != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;
    }
    
    @Override
    public int hashCode() {
        int result = symbol != null ? symbol.hashCode() : 0;
        result = 31 * result + (exchange != null ? exchange.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}