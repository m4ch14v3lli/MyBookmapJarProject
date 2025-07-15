package velox.api.layer0.credentialscomponents;

import java.awt.Container;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

public interface CredentialsComponent {

    /**
     * Add listeners to be triggered when fields state change.
     * Listener must be added to all entities that implement parts of the credential component
     * to notify UI about changes.
     * @param runnable the listener to add
     */
    void addSettingsChangedListener(Runnable runnable);

    /**
     * Returns the component itself. Compound here means that a typical CredentialsComponent will contain
     * one or more elements like a JTextField, JComboBox, JLabel, etc.
     * @return compound component
     */
    Container getCompoundComponent();

    /**
     * Gets values for CredentialsComponent elements.
     * Keys are names for each CredentialsComponent.
     * @return map of element names to their serialized field values
     */
    Map<String, CredentialsSerializationField> getValues();

    /**
     * Sets values for CredentialsComponent elements while restoring saved values.
     * @param values map of element names to their serialized field values
     */
    void setValues(Map<String, CredentialsSerializationField> values);

    /**
     * Provide pair(s) of legacy name and current name for this credentials element if there are any.
     * Used for compatibility with an older credentials element names.
     * @return list of name alias pairs
     */
    default List<Pair<String, String>> getAliases() {
        return List.of(); // default empty list
    }
}

// Assume this class exists in the same package and is referenced correctly
public class CredentialsSerializationField {
    private String value;

    public CredentialsSerializationField(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

// Implementing class example
public abstract class BaseCredentialsComponent implements CredentialsComponent {
    // Base implementation, could override common logic here
}

public class CredentialsTextField extends BaseCredentialsComponent {
    private Map<String, CredentialsSerializationField> values;

    @Override
    public void addSettingsChangedListener(Runnable runnable) {
        // Implementation
    }

    @Override
    public Container getCompoundComponent() {
        // Return actual UI component
        return null;
    }

    @Override
    public Map<String, CredentialsSerializationField> getValues() {
        return values;
    }

    @Override
    public void setValues(Map<String, CredentialsSerializationField> values) {
        this.values = values;
    }

    @Override
    public List<Pair<String, String>> getAliases() {
        return List.of(Pair.of("oldFieldName", "newFieldName"));
    }
}
