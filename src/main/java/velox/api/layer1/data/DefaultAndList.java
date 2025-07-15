package velox.api.layer1.data;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

/**
 * A generic container class that holds a default value and a list of available options.
 * This class is immutable and thread-safe.
 *
 * @param <T> the type of the default value and options
 */
public class DefaultAndList<T> {
    
    /**
     * Default value
     */
    public final T valueDefault;
    
    /**
     * List of options (including default)
     */
    public final List<T> valueOptions;
    
    /**
     * Constructs a new DefaultAndList with the specified default value and options.
     *
     * @param valueDefault the default value
     * @param valueOptions the list of available options (including default)
     * @throws NullPointerException if valueOptions is null
     */
    public DefaultAndList(T valueDefault, List<T> valueOptions) {
        this.valueDefault = valueDefault;
        this.valueOptions = valueOptions != null ? 
            Collections.unmodifiableList(new ArrayList<>(valueOptions)) : 
            Collections.emptyList();
    }
    
    /**
     * Returns the default value.
     *
     * @return the default value
     */
    public T getValueDefault() {
        return valueDefault;
    }
    
    /**
     * Returns an unmodifiable view of the options list.
     *
     * @return the list of options
     */
    public List<T> getValueOptions() {
        return valueOptions;
    }
    
    /**
     * Checks if the given value is among the available options.
     *
     * @param value the value to check
     * @return true if the value is in the options list, false otherwise
     */
    public boolean isValidOption(T value) {
        return valueOptions.contains(value);
    }
    
    /**
     * Returns the number of available options.
     *
     * @return the size of the options list
     */
    public int getOptionsCount() {
        return valueOptions.size();
    }
    
    /**
     * Checks if the options list is empty.
     *
     * @return true if no options are available, false otherwise
     */
    public boolean isEmpty() {
        return valueOptions.isEmpty();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        DefaultAndList<?> that = (DefaultAndList<?>) obj;
        return Objects.equals(valueDefault, that.valueDefault) &&
               Objects.equals(valueOptions, that.valueOptions);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(valueDefault, valueOptions);
    }
    
    @Override
    public String toString() {
        return String.format("DefaultAndList{valueDefault=%s, valueOptions=%s}", 
                           valueDefault, valueOptions);
    }
}