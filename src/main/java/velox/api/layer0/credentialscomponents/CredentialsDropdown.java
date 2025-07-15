package velox.api.layer0.credentialscomponents;

import javax.swing.JComboBox;
import java.util.Map;
import java.util.HashMap;

/**
 * An implementation of BaseCredentialsComponent for a text drop-down menu
 */
public class CredentialsDropdown extends BaseCredentialsComponent {
    
    protected JComboBox<String> comboBox;
    
    /**
     * Contains drop down values
     */
    protected String[] values;
    
    /**
     * Constructor for CredentialsDropdown
     * @param name see BaseCredentialsComponent.name
     * @param isKey see CredentialsSerializationField.isKey
     * @param label text
     * @param values an array of drop down values
     */
    public CredentialsDropdown(String name, boolean isKey, String label, String[] values) {
        super(name, isKey);
        this.values = values;
        this.comboBox = new JComboBox<>(values);
    }
    
    /**
     * Gets values for CredentialsComponent elements.
     * Keys are names for CredentialsComponent elements.
     * While logging in, an adapter will get a ExtendedLoginData
     * object which will contain this map (values may be updated by the user)
     * @return Map of String to CredentialsSerializationField
     */
    @Override
    public Map<String, CredentialsSerializationField> getValues() {
        Map<String, CredentialsSerializationField> result = new HashMap<>();
        String selectedValue = getValue();
        CredentialsSerializationField field = new CredentialsSerializationField(selectedValue, isKey());
        result.put(getName(), field);
        return result;
    }
    
    /**
     * Sets values for CredentialsComponent elements while
     * restoring saved values.
     * @param serializedFields map of serialized field values
     */
    @Override
    public void setValues(Map<String, CredentialsSerializationField> serializedFields) {
        CredentialsSerializationField field = serializedFields.get(getName());
        if (field != null && containsValue(field.getValue())) {
            comboBox.setSelectedItem(field.getValue());
        }
    }
    
    /**
     * Checks if values contains the specified value
     * @param value the value to check
     * @return true if value is found in values array
     */
    protected boolean containsValue(String value) {
        if (values == null || value == null) {
            return false;
        }
        for (String v : values) {
            if (value.equals(v)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * A simple value getter for the JComboBox object
     * which belongs to this CredentialsDropdown.
     * @return selected item or "" if selected item not initialized.
     */
    public String getValue() {
        Object selectedItem = comboBox.getSelectedItem();
        return selectedItem != null ? selectedItem.toString() : "";
    }
}

/**
 * Base abstract class for credentials components
 */
public abstract class BaseCredentialsComponent extends MultiCredentialsComponent implements CredentialsComponent {
    
    protected boolean isKey;
    protected boolean isListening;
    protected String name;
    protected java.util.List<Runnable> settingsChangedListeners;
    
    public BaseCredentialsComponent(String name, boolean isKey) {
        this.name = name;
        this.isKey = isKey;
        this.settingsChangedListeners = new java.util.ArrayList<>();
    }
    
    public void addSettingsChangedListener(Runnable listener) {
        settingsChangedListeners.add(listener);
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isKey() {
        return isKey;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    protected void onStatusChanged() {
        for (Runnable listener : settingsChangedListeners) {
            listener.run();
        }
    }
}

/**
 * Multi credentials component base class
 */
public abstract class MultiCredentialsComponent {
    
    protected Map<String, String> aliases;
    protected java.util.List<CredentialsComponent> components;
    protected javax.swing.JPanel panel;
    
    public MultiCredentialsComponent() {
        this.aliases = new HashMap<>();
        this.components = new java.util.ArrayList<>();
    }
    
    public void addAlias(String key, String alias) {
        aliases.put(key, alias);
    }
    
    public Map<String, String> getAliases() {
        return aliases;
    }
    
    public javax.swing.JComponent getCompoundComponent() {
        return panel;
    }
}

/**
 * Interface for credentials components
 */
public interface CredentialsComponent {
    
    /**
     * Gets values for CredentialsComponent elements.
     * Keys are names for CredentialsComponent elements.
     * While logging in, an adapter will get a ExtendedLoginData
     * object which will contain this map (values may be updated by the user)
     * @return Map of component values
     */
    Map<String, CredentialsSerializationField> getValues();
    
    /**
     * Sets values for CredentialsComponent elements while
     * restoring saved values.
     * @param serializedFields map of serialized field values
     */
    void setValues(Map<String, CredentialsSerializationField> serializedFields);
    
    /**
     * Gets the name of this component
     * @return component name
     */
    String getName();
    
    /**
     * Checks if this component represents a key field
     * @return true if this is a key field
     */
    boolean isKey();
    
    /**
     * Adds a settings changed listener
     * @param listener the listener to add
     */
    void addSettingsChangedListener(Runnable listener);
}

/**
 * Credentials serialization field data holder
 */
public class CredentialsSerializationField {
    
    private String value;
    private boolean isKey;
    
    public CredentialsSerializationField(String value, boolean isKey) {
        this.value = value;
        this.isKey = isKey;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public boolean isKey() {
        return isKey;
    }
    
    public void setKey(boolean key) {
        isKey = key;
    }
}