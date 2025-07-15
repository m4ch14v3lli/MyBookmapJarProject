package velox.api.layer1.data;

import java.io.Serializable;

/**
 * Instrument info with some extra data usually found in cryptocurrencies.
 * 
 * You no longer need this class, since InstrumentInfo.sizeMultiplier
 * was moved to parent class.
 * 
 * @deprecated This class is deprecated as sizeMultiplier functionality 
 *             has been moved to the parent InstrumentInfo class.
 */
@Deprecated
public class InstrumentInfoCrypto extends InstrumentInfo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor for InstrumentInfoCrypto.
     * Assumes isFullDepth = true by default.
     * 
     * @param symbol The trading symbol
     * @param exchange The exchange name
     * @param type The instrument type
     * @param pips The pip value
     * @param multiplier The price multiplier
     * @param fullName The full instrument name
     * @param sizeMultiplier The size multiplier for cryptocurrency
     */
    public InstrumentInfoCrypto(String symbol, 
                               String exchange, 
                               String type, 
                               double pips, 
                               double multiplier, 
                               String fullName, 
                               double sizeMultiplier) {
        super(symbol, exchange, type, pips, multiplier, fullName, true, sizeMultiplier);
    }
    
    /**
     * Constructor for InstrumentInfoCrypto with explicit isFullDepth parameter.
     * 
     * @param symbol The trading symbol
     * @param exchange The exchange name
     * @param type The instrument type
     * @param pips The pip value
     * @param multiplier The price multiplier
     * @param fullName The full instrument name
     * @param isFullDepth Whether full depth is supported
     * @param sizeMultiplier The size multiplier for cryptocurrency
     */
    public InstrumentInfoCrypto(String symbol, 
                               String exchange, 
                               String type, 
                               double pips, 
                               double multiplier, 
                               String fullName, 
                               boolean isFullDepth, 
                               double sizeMultiplier) {
        super(symbol, exchange, type, pips, multiplier, fullName, isFullDepth, sizeMultiplier);
    }
}