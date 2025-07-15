package velox.api.layer1.common;

import java.util.function.Function;
import java.util.function.BiConsumer;

/**
 * Global storage. Only use it if you don't have other more appropriate ways to
 * store the data. Layer1 modules should use SettingsAccess instead.
 */
public class Layer1GlobalStorage {
    
    private static Function<String, String> valuesGetter;
    private static BiConsumer<String, String> valuesSetter;
    
    /**
     * Default constructor
     */
    public Layer1GlobalStorage() {
        // Default constructor
    }
    
    /**
     * Initialize storage backend. Invoked by Bookmap. Plugins should not call this
     * method.
     * 
     * @param valuesGetter Function to retrieve values from storage
     * @param valuesSetter BiConsumer to store values in storage
     */
    public static void setStorageCallbacks(Function<String, String> valuesGetter,
                                         BiConsumer<String, String> valuesSetter) {
        Layer1GlobalStorage.valuesGetter = valuesGetter;
        Layer1GlobalStorage.valuesSetter = valuesSetter;
    }
    
    /**
     * Store value globally.
     * 
     * @param key key to use. Must be unique and identifiable (e.g. prefix it with
     *            your module name).
     * @param value value to store
     */
    public static void set(String key, String value) {
        if (valuesSetter != null) {
            valuesSetter.accept(key, value);
        }
    }
    
    /**
     * Load value from global storage
     * 
     * @param key key to use. Must be unique and identifiable (e.g. prefix it with
     *            your module name).
     * @return previously stored value or null if not found
     */
    public static String get(String key) {
        if (valuesGetter != null) {
            return valuesGetter.apply(key);
        }
        return null;
    }
}