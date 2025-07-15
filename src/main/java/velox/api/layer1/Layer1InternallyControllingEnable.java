package velox.api.layer1;

/**
 * This interface allows Bookmap to know if strategy is enabled/disabled for specific instrument
 * 
 * @deprecated This interface is deprecated
 */
@Deprecated
public interface Layer1InternallyControllingEnable {
    
    /**
     * Nested interface for invalidation callback
     * 
     * @deprecated This nested interface is deprecated
     */
    @Deprecated
    public static interface InvalidateIsEnabledCallback {
        // Callback methods would be defined here based on the actual implementation
        // Since this is from Javadoc, the method signatures are not visible
    }
    
    /**
     * Checks if the strategy is enabled for the specified instrument alias
     * 
     * @param alias the instrument alias to check
     * @return true if enabled for the given alias, false otherwise
     * @deprecated This method is deprecated
     */
    @Deprecated
    boolean isEnabledFor(String alias);
    
    /**
     * Sets the callback for invalidating the enabled state
     * 
     * @param invalidateIsEnabledCallback the callback to set for invalidation
     * @deprecated This method is deprecated
     */
    @Deprecated
    void setInvalidateIsEnabledCallback(InvalidateIsEnabledCallback invalidateIsEnabledCallback);
}