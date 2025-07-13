package velox.api.layer1.simplified.demo;

import java.io.Serializable;
import velox.api.layer1.annotations.UnrestrictedData;

/**
 * Information about the instrument
 */
public class InstrumentInfo extends InstrumentCoreInfo implements Serializable {

    /**
     * Delay value for the dataDelay field, if the delay is currently unknown, but it is known that the data is delayed.
     * Used to inform the Bookmap about some data delay.
     */
    public static final long UNKNOWN_DELAY = -1L;

    /**
     * Also known as min tick, tick size or minimal price increment. This allows
     * bookmap to translate level numbers to price that is shown to the user and
     * vice versa
     */
    public final double pips;

    /**
     * Similar to "tick value" in its meaning, with the only difference of being
     * per price unit instead of per tick (can be computed as tick value divided by
     * pips)
     *
     * Specifically, this field tells bookmap the following: "how many dollars (or
     * other currency units) will my P&L change if I have position of 1 and price
     * moves 1 dollar (or other price unit) up"
     */
    public final double multiplier;

    /**
     * Full instrument name on the platforms where it's available, null otherwise
     */
    public final String fullName;

    /**
     * True if data provided for instrument is full depth data
     */
    public final boolean isFullDepth;

    /**
     * Used when size granularity is less than 1 (for most providers it's always 1,
     * so you can ignore this field if only those are targeted). This is only a
     * visual thing, as all updates should still be performed in integer units. It
     * was introduced mostly because of cryptocurrencies - since sizes are no longer
     * integer values, you can premultiply all sizes by certain value and specify it
     * in this field. E.g. 1000 will make bookmap display size of 1 as 0.001.
     */
    public final double sizeMultiplier;

    /**
     * Allows bookmap to distinguish crypto instruments from other types. If true -
     * this instrument is a cryptocurrency or is based on cryptocurrencies in some
     * way
     */
    public final boolean isCrypto;

    /**
     * Used to distinguish local history with special modes on the per instrument basis (i.e. local history with delayed data vs live data)
     * Provider should set this field to specify special mode of this instrument,"DELAYED" for example
     *
     * Note: it is recommended to not set this field for LIVE instruments for backward compatibility of historical servers,
     * i.e. so the historical server returned "live" data to the user with the old client
     */
    public final String recordingTag;

    /**
     * If this flag is set to true, then all add-ons, except those marked with
     * UnrestrictedData annotation, will be blocked from receiving data from this instrument
     */
    public final boolean isApiProtected;

    /**
     * If this flag is set to true, then this instrument supports NBBO data,
     * and it is possible to create NBBO indicator for the instrument
     */
    public final boolean isNbboSupported;

    /**
     * Delay in nanoseconds for the data of this instrument. If delay is currently unknown, but it is known that the data is delayed,
     * then you should set this field to UNKNOWN_DELAY, to inform the Bookmap that the data is delayed
     * (so the Bookmap can apply some restrictions for delayed data instruments).
     */
    public final long dataDelay;

    /**
     * Used to correctly handle "generic" instrument substitution.
     * If your provider wants to subscribe to the instrument with a different symbol
     * than you received in subscription request (for example you received "ES" and want to subscribe to "ESH4"),
     * then you should set this field to the symbol which you received in request.
     */
    public final String requestedSymbol;

    // Deprecated constructors

    /**
     * @deprecated use InstrumentInfo.Builder instead
     */
    @Deprecated
    public InstrumentInfo(String symbol, String exchange, String type, double pips, double multiplier,
                          String fullName, boolean isFullDepth) {
        this(symbol, exchange, type, pips, multiplier, fullName, isFullDepth, 1.0, false);
    }

    /**
     * @deprecated use InstrumentInfo.Builder instead
     */
    @Deprecated
    public InstrumentInfo(String symbol, String exchange, String type, double pips, double multiplier,
                          String fullName, boolean isFullDepth, double sizeMultiplier) {
        this(symbol, exchange, type, pips, multiplier, fullName, isFullDepth, sizeMultiplier, false);
    }

    /**
     * @deprecated use InstrumentInfo.Builder instead
     */
    @Deprecated
    public InstrumentInfo(String symbol, String exchange, String type, double pips, double multiplier,
                          String fullName, boolean isFullDepth, double sizeMultiplier, boolean isCrypto) {
        super(symbol, exchange, type);
        this.pips = pips;
        this.multiplier = multiplier;
        this.fullName = fullName;
        this.isFullDepth = isFullDepth;
        this.sizeMultiplier = sizeMultiplier;
        this.isCrypto = isCrypto;
        this.recordingTag = null;
        this.isApiProtected = false;
        this.isNbboSupported = false;
        this.dataDelay = 0L;
        this.requestedSymbol = null;
    }

    /**
     * Protected constructor for use with Builder
     */
    protected InstrumentInfo(BuilderBase<?> builder) {
        super(builder.symbol, builder.exchange, builder.type);
        this.pips = builder.pips;
        this.multiplier = builder.multiplier;
        this.fullName = builder.fullName;
        this.isFullDepth = builder.isFullDepth;
        this.sizeMultiplier = builder.sizeMultiplier;
        this.isCrypto = builder.isCrypto;
        this.recordingTag = builder.recordingTag;
        this.isApiProtected = builder.isApiProtected;
        this.isNbboSupported = builder.isNbboSupported;
        this.dataDelay = builder.dataDelay;
        this.requestedSymbol = builder.requestedSymbol;
    }

    /**
     * Creates a new builder from this instance
     */
    @Override
    public BuilderBase<?> toBuilder() {
        return new Builder()
                .setSymbol(this.symbol)
                .setExchange(this.exchange)
                .setType(this.type)
                .setPips(this.pips)
                .setMultiplier(this.multiplier)
                .setFullName(this.fullName)
                .setIsFullDepth(this.isFullDepth)
                .setSizeMultiplier(this.sizeMultiplier)
                .setIsCrypto(this.isCrypto)
                .setRecordingTag(this.recordingTag)
                .setIsApiProtected(this.isApiProtected)
                .setIsNbboSupported(this.isNbboSupported)
                .setDataDelay(this.dataDelay)
                .setRequestedSymbol(this.requestedSymbol);
    }

    @Override
    public String toString() {
        return "InstrumentInfo{" +
                "symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", type='" + type + '\'' +
                ", pips=" + pips +
                ", multiplier=" + multiplier +
                ", fullName='" + fullName + '\'' +
                ", isFullDepth=" + isFullDepth +
                ", sizeMultiplier=" + sizeMultiplier +
                ", isCrypto=" + isCrypto +
                ", recordingTag='" + recordingTag + '\'' +
                ", isApiProtected=" + isApiProtected +
                ", isNbboSupported=" + isNbboSupported +
                ", dataDelay=" + dataDelay +
                ", requestedSymbol='" + requestedSymbol + '\'' +
                '}';
    }

    // Nested Builder Classes

    /**
     * Base builder class for InstrumentInfo
     */
    public static abstract class BuilderBase<T extends BuilderBase<T>> {
        protected String symbol;
        protected String exchange;
        protected String type;
        protected double pips;
        protected double multiplier;
        protected String fullName;
        protected boolean isFullDepth;
        protected double sizeMultiplier = 1.0;
        protected boolean isCrypto = false;
        protected String recordingTag;
        protected boolean isApiProtected = false;
        protected boolean isNbboSupported = false;
        protected long dataDelay = 0L;
        protected String requestedSymbol;

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }

        public T setSymbol(String symbol) {
            this.symbol = symbol;
            return self();
        }

        public T setExchange(String exchange) {
            this.exchange = exchange;
            return self();
        }

        public T setType(String type) {
            this.type = type;
            return self();
        }

        public T setPips(double pips) {
            this.pips = pips;
            return self();
        }

        public T setMultiplier(double multiplier) {
            this.multiplier = multiplier;
            return self();
        }

        public T setFullName(String fullName) {
            this.fullName = fullName;
            return self();
        }

        public T setIsFullDepth(boolean isFullDepth) {
            this.isFullDepth = isFullDepth;
            return self();
        }

        public T setSizeMultiplier(double sizeMultiplier) {
            this.sizeMultiplier = sizeMultiplier;
            return self();
        }

        public T setIsCrypto(boolean isCrypto) {
            this.isCrypto = isCrypto;
            return self();
        }

        public T setRecordingTag(String recordingTag) {
            this.recordingTag = recordingTag;
            return self();
        }

        public T setIsApiProtected(boolean isApiProtected) {
            this.isApiProtected = isApiProtected;
            return self();
        }

        public T setIsNbboSupported(boolean isNbboSupported) {
            this.isNbboSupported = isNbboSupported;
            return self();
        }

        public T setDataDelay(long dataDelay) {
            this.dataDelay = dataDelay;
            return self();
        }

        public T setRequestedSymbol(String requestedSymbol) {
            this.requestedSymbol = requestedSymbol;
            return self();
        }

        public abstract InstrumentInfo build();
    }

    /**
     * Concrete builder class for InstrumentInfo
     */
    public static class Builder extends BuilderBase<Builder> {

        @Override
        public InstrumentInfo build() {
            return new InstrumentInfo(this);
        }
    }
}

// Note: This would also require the parent class InstrumentCoreInfo
// Here's a basic implementation of what it might look like:

abstract class InstrumentCoreInfo {
    public final String symbol;
    public final String exchange;
    public final String type;

    public InstrumentCoreInfo(String symbol, String exchange, String type) {
        this.symbol = symbol;
        this.exchange = exchange;
        this.type = type;
    }

    public abstract InstrumentInfo.BuilderBase<?> toBuilder();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        InstrumentCoreInfo that = (InstrumentCoreInfo) obj;
        return symbol.equals(that.symbol) &&
                exchange.equals(that.exchange) &&
                type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return symbol.hashCode() * 31 + exchange.hashCode() * 31 + type.hashCode();
    }

    public InstrumentCoreInfo normalize() {
        // Implementation would depend on specific normalization logic
        return this;
    }

    @Override
    public String toString() {
        return "InstrumentCoreInfo{" +
                "symbol='" + symbol + '\'' +
                ", exchange='" + exchange + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}