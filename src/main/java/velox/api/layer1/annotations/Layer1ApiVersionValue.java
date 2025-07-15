package velox.api.layer1.annotations;

/**
 * List of API versions. If you are writing a new module, you typically want the
 * latest one available in the lowest Bookmap that you are targeting. Easiest
 * way to check would be to install that version and see what is the last value
 * in this enum. If no such enum exists this means you have picked
 * pre-compatibility-system version, which is not recommended. Compatibility
 * system was added in version 7.0 during beta stage.
 * 
 * Only breaking changes are listed in comments. New features can be added at
 * any point without incrementing API version (especially while in alpha/beta),
 * so there is no guarantee that older build will run with indicator intended
 * for newer one.
 */
public enum Layer1ApiVersionValue {
    
    /**
     * API right before compatibility system was introduced. There were few small
     * changes in API before that, but presumably not many people used API at that
     * stage.
     */
    VERSION0(0),
    
    /**
     * Development started around 2018-06-12 in version 7.0.
     * Breaking changes:
     * - Removed Layer1ApiAdminListener.selectAccount. Use SelectAccountMessage instead
     * - Fixed return values in Layer1ApiProviderSupportedFeaturesBuilder
     */
    VERSION1(1),
    
    /**
     * Development started around 2018-11-20 in version 7.0.
     * Breaking changes:
     * - Changed AliasFilter from being a class to being an interface
     * - Changed IndicatorColorScheme from being a class to being an interface
     */
    VERSION2(2),
    
    /**
     * Development started around 2024-09-15 in version 7.6.
     * Breaking changes:
     * - Introduced child-first class loader.
     */
    VERSION3(3);
    
    private final int numericValue;
    
    Layer1ApiVersionValue(int numericValue) {
        this.numericValue = numericValue;
    }
    
    /**
     * Returns the numeric value of this version.
     * 
     * @return the numeric value
     */
    public int getNumericValue() {
        return numericValue;
    }
    
    /**
     * Returns the highest available version.
     * 
     * @return the highest Layer1ApiVersionValue
     */
    public static Layer1ApiVersionValue getHighestVersion() {
        Layer1ApiVersionValue[] values = values();
        return values[values.length - 1];
    }
    
    /**
     * Returns the enum constant of this class with the specified numeric value.
     * 
     * @param numericValue the numeric value of the enum constant to be returned
     * @return the enum constant with the specified numeric value
     * @throws IllegalArgumentException if this enum class has no constant with the specified numeric value
     */
    public static Layer1ApiVersionValue valueOf(int numericValue) {
        for (Layer1ApiVersionValue version : values()) {
            if (version.numericValue == numericValue) {
                return version;
            }
        }
        throw new IllegalArgumentException("No enum constant with numeric value: " + numericValue);
    }
}