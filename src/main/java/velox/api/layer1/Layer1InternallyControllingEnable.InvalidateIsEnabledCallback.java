package velox.api.layer1;

/**
 * This interface allows Bookmap to know if strategy is enabled/disabled for specific instrument
 * 
 * @deprecated This interface is deprecated
 */
@Deprecated
public interface Layer1InternallyControllingEnable {
    
    /**
     * Nested functional interface for invalidation callback
     * This is a functional interface and can be used as the assignment target 
     * for a lambda expression or method reference.
     * 
     * @deprecated This nested interface is deprecated
     */
    @Deprecated
    @FunctionalInterface
    public static interface InvalidateIsEnabledCallback {
        
        /**
         * Invalidates the enabled state, triggering a refresh of the strategy status
         */
        void invalidate();
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