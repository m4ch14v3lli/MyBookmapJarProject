package velox.api.layer1.common;

/**
 * This class can be used to retrieve Bookmap Run Mode
 */
public class RunModeHelper {
    
    private static Boolean isLive = null;
    private static Boolean isRealTrading = null;
    private static boolean isSet = false;
    
    /**
     * Default constructor
     */
    public RunModeHelper() {
    }
    
    /**
     * Called by Bookmap code once to set Run Mode.
     * 
     * @param isLive indicates that Bookmap gets the data from the provider
     * @param isRealTrading indicates that all trading events will be passed to provider
     */
    public static void setRunModeOnce(boolean isLive, boolean isRealTrading) {
        if (!RunModeHelper.isSet) {
            RunModeHelper.isLive = isLive;
            RunModeHelper.isRealTrading = isRealTrading;
            RunModeHelper.isSet = true;
        }
    }
    
    /**
     * Check if the run mode has been set
     * 
     * @return true if the Run Mode is selected
     */
    public static boolean isSet() {
        return isSet;
    }
    
    /**
     * This flag indicates that Bookmap gets the data from the provider, it still
     * can be delayed or replayed by the provider. Otherwise, the data is replayed
     * by Bookmap.
     * 
     * @return true if the data live (by provider)
     */
    public static Boolean isLive() {
        return isLive;
    }
    
    /**
     * This flag indicates that all the trading events will be passed to provider,
     * it still can be simulated on provider side. Otherwise, the trading is
     * simulated by Bookmap.
     * 
     * @return true if the trading is real (by provider)
     */
    public static Boolean isRealTrading() {
        return isRealTrading;
    }
}