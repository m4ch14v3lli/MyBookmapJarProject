package velox.api.layer1.data;

/**
 * Core information about a financial instrument
 */
public abstract class InstrumentCoreInfo {
    
    protected String exchange;
    protected String symbol;
    protected String type;
    
    public String getExchange() { return exchange; }
    public String getSymbol() { return symbol; }
    public String getType() { return type; }
    
    /**
     * Base builder class for InstrumentCoreInfo
     */
    public static abstract class BuilderBase<T extends BuilderBase<T>> {
        protected String exchange;
        protected String symbol;
        protected String type;
        
        protected abstract T self();
        
        public String getExchange() { return exchange; }
        public String getSymbol() { return symbol; }
        public String getType() { return type; }
        
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
        
        public T setFieldsFrom(InstrumentCoreInfo info) {
            this.exchange = info.getExchange();
            this.symbol = info.getSymbol();
            this.type = info.getType();
            return self();
        }
    }
}

/**
 * Extended instrument information with additional properties
 */
public class InstrumentInfo extends InstrumentCoreInfo {
    
    private final long dataDelay;
    private final String fullName;
    private final boolean isApiProtected;
    private final boolean isCrypto;
    private final boolean isFullDepth;
    private final boolean isNbboSupported;
    private final double multiplier;
    private final double pips;
    private final String recordingTag;
    private final String requestedSymbol;
    private final double sizeMultiplier;
    
    protected InstrumentInfo(Builder builder) {
        this.exchange = builder.exchange;
        this.symbol = builder.symbol;
        this.type = builder.type;
        this.dataDelay = builder.dataDelay;
        this.fullName = builder.fullName;
        this.isApiProtected = builder.isApiProtected;
        this.isCrypto = builder.isCrypto;
        this.isFullDepth = builder.isFullDepth;
        this.isNbboSupported = builder.isNbboSupported;
        this.multiplier = builder.multiplier;
        this.pips = builder.pips;
        this.recordingTag = builder.recordingTag;
        this.requestedSymbol = builder.requestedSymbol;
        this.sizeMultiplier = builder.sizeMultiplier;
    }
    
    public long getDataDelay() { return dataDelay; }
    public String getFullName() { return fullName; }
    public boolean isApiProtected() { return isApiProtected; }
    public boolean isCrypto() { return isCrypto; }
    public boolean isFullDepth() { return isFullDepth; }
    public boolean isNbboSupported() { return isNbboSupported; }
    public double getMultiplier() { return multiplier; }
    public double getPips() { return pips; }
    public String getRecordingTag() { return recordingTag; }
    public String getRequestedSymbol() { return requestedSymbol; }
    public double getSizeMultiplier() { return sizeMultiplier; }
    
    /**
     * Abstract base builder class for InstrumentInfo
     */
    public static abstract class BuilderBase<T extends BuilderBase<T>> extends InstrumentCoreInfo.BuilderBase<T> {
        
        protected long dataDelay;
        protected String fullName;
        protected boolean isApiProtected;
        protected boolean isCrypto;
        protected boolean isFullDepth;
        protected boolean isNbboSupported;
        protected double multiplier;
        protected double pips;
        protected String recordingTag;
        protected String requestedSymbol;
        protected double sizeMultiplier;
        
        public abstract InstrumentInfo build();
        
        public String getFullName() { return fullName; }
        public double getMultiplier() { return multiplier; }
        public double getPips() { return pips; }
        public String getRecordingTag() { return recordingTag; }
        public String getRequestedSymbol() { return requestedSymbol; }
        public double getSizeMultiplier() { return sizeMultiplier; }
        public boolean isApiProtected() { return isApiProtected; }
        public boolean isCrypto() { return isCrypto; }
        public boolean isFullDepth() { return isFullDepth; }
        public boolean isNbboSupported() { return isNbboSupported; }
        
        public T setApiProtected(boolean apiProtected) {
            this.isApiProtected = apiProtected;
            return self();
        }
        
        public T setCrypto(boolean crypto) {
            this.isCrypto = crypto;
            return self();
        }
        
        public T setDataDelay(long dataDelay) {
            this.dataDelay = dataDelay;
            return self();
        }
        
        public T setFullDepth(boolean fullDepth) {
            this.isFullDepth = fullDepth;
            return self();
        }
        
        public T setFullName(String fullName) {
            this.fullName = fullName;
            return self();
        }
        
        public T setMultiplier(double multiplier) {
            this.multiplier = multiplier;
            return self();
        }
        
        public T setNbboSupported(boolean nbboSupported) {
            this.isNbboSupported = nbboSupported;
            return self();
        }
        
        public T setPips(double pips) {
            this.pips = pips;
            return self();
        }
        
        public T setRecordingTag(String recordingTag) {
            this.recordingTag = recordingTag;
            return self();
        }
        
        public T setRequestedSymbol(String requestedSymbol) {
            this.requestedSymbol = requestedSymbol;
            return self();
        }
        
        public T setSizeMultiplier(double sizeMultiplier) {
            this.sizeMultiplier = sizeMultiplier;
            return self();
        }
        
        public T setFieldsFrom(InstrumentInfo info) {
            super.setFieldsFrom(info);
            this.dataDelay = info.getDataDelay();
            this.fullName = info.getFullName();
            this.isApiProtected = info.isApiProtected();
            this.isCrypto = info.isCrypto();
            this.isFullDepth = info.isFullDepth();
            this.isNbboSupported = info.isNbboSupported();
            this.multiplier = info.getMultiplier();
            this.pips = info.getPips();
            this.recordingTag = info.getRecordingTag();
            this.requestedSymbol = info.getRequestedSymbol();
            this.sizeMultiplier = info.getSizeMultiplier();
            return self();
        }
    }
    
    /**
     * Concrete builder implementation for InstrumentInfo
     */
    public static class Builder extends InstrumentInfo.BuilderBase<InstrumentInfo.Builder> {
        
        public Builder() {
            super();
        }
        
        @Override
        protected InstrumentInfo.Builder self() {
            return this;
        }
        
        @Override
        public InstrumentInfo build() {
            return new InstrumentInfo(this);
        }
    }
}