package velox.api.layer0.annotations;

/**
 * List of provider types.
 * 
 * Bookmap will display and calculate some information (e.g. sizes based on prices and multipliers),
 * in a more convenient way that fits a particular type.
 */
public enum Layer0ProviderTypeValue {
    
    /**
     * Default type
     */
    UNKNOWN,
    
    /**
     * Crypto type
     */
    CRYPTO;
    
    /**
     * Returns an array containing the constants of this enum class, in
     * the order they are declared.
     * 
     * @return an array containing the constants of this enum class, in the order they are declared
     */
    public static Layer0ProviderTypeValue[] values() {
        return Layer0ProviderTypeValue.values();
    }
    
    /**
     * Returns the enum constant of this class with the specified name.
     * The string must match exactly an identifier used to declare an
     * enum constant in this class. (Extraneous whitespace characters are 
     * not permitted.)
     * 
     * @param name the name of the enum constant to be returned
     * @return the enum constant with the specified name
     * @throws IllegalArgumentException if this enum class has no constant with the specified name
     * @throws NullPointerException if the argument is null
     */
    public static Layer0ProviderTypeValue valueOf(String name) {
        return Layer0ProviderTypeValue.valueOf(name);
    }
}