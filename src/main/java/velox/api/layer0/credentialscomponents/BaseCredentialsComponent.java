package velox.api.layer0.credentialscomponents;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * CredentialsComponent interface - The base interface for all credential components
 */
public interface CredentialsComponent {
    /**
     * Retrieves the values from the component
     * @return Map containing field names as keys and their values
     */
    Map<String, Object> getValues();
    
    /**
     * Sets the values for the component
     * @param values Map containing field names as keys and their values to set
     */
    void setValues(Map<String, Object> values);
}

/**
 * MultiCredentialsComponent - Base class for components that can contain multiple credential fields
 */
public abstract class MultiCredentialsComponent implements CredentialsComponent {
    protected Map<String, String> aliases;
    protected List<CredentialsComponent> components;
    protected Object panel; // UI panel reference
    
    /**
     * Adds an alias mapping for field names
     * @param alias The alias name
     * @param fieldName The actual field name
     */
    public void addAlias(String alias, String fieldName) {
        if (aliases == null) {
            aliases = new java.util.HashMap<>();
        }
        aliases.put(alias, fieldName);
    }
    
    /**
     * Gets all aliases
     * @return Map of aliases
     */
    public Map<String, String> getAliases() {
        return aliases;
    }
    
    /**
     * Gets the compound component
     * @return The compound component
     */
    public abstract Object getCompoundComponent();
}

/**
 * BaseCredentialsComponent - An abstract implementation of CredentialsComponent.
 * It serves as a basis for a one-value component (like a text field or a check box)
 */
public abstract class BaseCredentialsComponent extends MultiCredentialsComponent {
    
    /**
     * A name for BaseCredentialsComponent. It will serve as a key for maps
     * in CredentialsComponent.getValues() and CredentialsComponent.setValues()
     * methods.
     * 
     * Please note, field names should be unique in the connection scope.
     * Please also note, a BaseCredentialsComponent is a one-field component
     * (a user is supposed to fill one field e.g. a textBox or pick a drop down element)
     * In any multi-field component there should be a separate name for every field
     * a user can configure.
     */
    protected String name;
    
    /**
     * see CredentialsSerializationField.isKey
     */
    protected boolean isKey;
    
    /**
     * Contains listeners to be triggered on settings change
     */
    protected List<Runnable> settingsChangedListeners;
    
    /**
     * Changing its value allows to suspend settingsChangedListeners in the onStatusChanged() method
     */
    protected boolean isListening;
    
    /**
     * Constructor for BaseCredentialsComponent
     * @param name see name field
     * @param isKey see CredentialsSerializationField.isKey
     */
    public BaseCredentialsComponent(String name, boolean isKey) {
        this.name = name;
        this.isKey = isKey;
        this.settingsChangedListeners = new ArrayList<>();
        this.isListening = true;
    }
    
    /**
     * Gets the name of this component
     * @return The component name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the name of this component
     * @param name The new name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Checks if this component represents a key field
     * @return true if this is a key field
     */
    public boolean isKey() {
        return isKey;
    }
    
    /**
     * Adds a listener to be triggered on settings change
     * @param listener The runnable listener to add
     */
    public void addSettingsChangedListener(Runnable listener) {
        if (settingsChangedListeners == null) {
            settingsChangedListeners = new ArrayList<>();
        }
        settingsChangedListeners.add(listener);
    }
    
    /**
     * Defines behavior on field change.
     * Normally, every listener of settingsChangedListeners is triggered.
     */
    protected void onStatusChanged() {
        if (isListening && settingsChangedListeners != null) {
            for (Runnable listener : settingsChangedListeners) {
                listener.run();
            }
        }
    }
}

/**
 * CredentialsCheckbox - Concrete implementation for checkbox credential component
 */
public class CredentialsCheckbox extends BaseCredentialsComponent {
    private boolean checked;
    
    public CredentialsCheckbox(String name, boolean isKey) {
        super(name, isKey);
        this.checked = false;
    }
    
    public boolean isChecked() {
        return checked;
    }
    
    public void setChecked(boolean checked) {
        this.checked = checked;
        onStatusChanged();
    }
    
    @Override
    public Map<String, Object> getValues() {
        Map<String, Object> values = new java.util.HashMap<>();
        values.put(name, checked);
        return values;
    }
    
    @Override
    public void setValues(Map<String, Object> values) {
        if (values.containsKey(name)) {
            Object value = values.get(name);
            if (value instanceof Boolean) {
                this.checked = (Boolean) value;
            }
        }
    }
    
    @Override
    public Object getCompoundComponent() {
        return this;
    }
}

/**
 * CredentialsDropdown - Concrete implementation for dropdown credential component
 */
public class CredentialsDropdown extends BaseCredentialsComponent {
    private String selectedValue;
    private List<String> options;
    
    public CredentialsDropdown(String name, boolean isKey) {
        super(name, isKey);
        this.options = new ArrayList<>();
    }
    
    public String getSelectedValue() {
        return selectedValue;
    }
    
    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
        onStatusChanged();
    }
    
    public List<String> getOptions() {
        return options;
    }
    
    public void setOptions(List<String> options) {
        this.options = options;
    }
    
    @Override
    public Map<String, Object> getValues() {
        Map<String, Object> values = new java.util.HashMap<>();
        values.put(name, selectedValue);
        return values;
    }
    
    @Override
    public void setValues(Map<String, Object> values) {
        if (values.containsKey(name)) {
            Object value = values.get(name);
            if (value instanceof String) {
                this.selectedValue = (String) value;
            }
        }
    }
    
    @Override
    public Object getCompoundComponent() {
        return this;
    }
}

/**
 * CredentialsTextField - Concrete implementation for text field credential component
 */
public class CredentialsTextField extends BaseCredentialsComponent {
    private String text;
    private boolean isPassword;
    
    public CredentialsTextField(String name, boolean isKey) {
        super(name, isKey);
        this.text = "";
        this.isPassword = false;
    }
    
    public CredentialsTextField(String name, boolean isKey, boolean isPassword) {
        super(name, isKey);
        this.text = "";
        this.isPassword = isPassword;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
        onStatusChanged();
    }
    
    public boolean isPassword() {
        return isPassword;
    }
    
    public void setPassword(boolean password) {
        this.isPassword = password;
    }
    
    @Override
    public Map<String, Object> getValues() {
        Map<String, Object> values = new java.util.HashMap<>();
        values.put(name, text);
        return values;
    }
    
    @Override
    public void setValues(Map<String, Object> values) {
        if (values.containsKey(name)) {
            Object value = values.get(name);
            if (value instanceof String) {
                this.text = (String) value;
            }
        }
    }
    
    @Override
    public Object getCompoundComponent() {
        return this;
    }
}