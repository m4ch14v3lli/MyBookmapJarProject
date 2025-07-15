package velox.api.layer1.data;

/**
 * Core information about a financial instrument
 */
public class InstrumentCoreInfo {
    private final String exchange;
    private final String symbol;
    private final String type;
    
    private InstrumentCoreInfo(Builder builder) {
        this.exchange = builder.exchange;
        this.symbol = builder.symbol;
        this.type = builder.type;
    }
    
    public String getExchange() {
        return exchange;
    }
    
    public String getSymbol() {
        return symbol;
    }
    
    public String getType() {
        return type;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * Abstract base class for InstrumentCoreInfo builders
     */
    public abstract static class BuilderBase<T extends BuilderBase<T>> {
        protected String exchange;
        protected String symbol;
        protected String type;
        
        protected BuilderBase() {}
        
        public String getExchange() {
            return exchange;
        }
        
        public String getSymbol() {
            return symbol;
        }
        
        public String getType() {
            return type;
        }
        
        public T setExchange(String exchange) {
            this.exchange = exchange;
            return self();
        }
        
        public T setSymbol(String symbol) {
            this.symbol = symbol;
            return self();
        }
        
        public T setType(String type) {
            this.type = type;
            return self();
        }
        
        public T setFieldsFrom(InstrumentCoreInfo instrumentCoreInfo) {
            if (instrumentCoreInfo != null) {
                this.exchange = instrumentCoreInfo.getExchange();
                this.symbol = instrumentCoreInfo.getSymbol();
                this.type = instrumentCoreInfo.getType();
            }
            return self();
        }
        
        protected abstract T self();
        
        public abstract InstrumentCoreInfo build();
    }
    
    /**
     * Concrete builder implementation for InstrumentCoreInfo
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
            return new InstrumentCoreInfo(this);
        }
    }
    
    @Override
    public String toString() {
        return "InstrumentCoreInfo{" +
                "exchange='" + exchange + '\'' +
                ", symbol='" + symbol + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        InstrumentCoreInfo that = (InstrumentCoreInfo) o;
        
        if (exchange != null ? !exchange.equals(that.exchange) : that.exchange != null) return false;
        if (symbol != null ? !symbol.equals(that.symbol) : that.symbol != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;
    }
    
    @Override
    public int hashCode() {
        int result = exchange != null ? exchange.hashCode() : 0;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}