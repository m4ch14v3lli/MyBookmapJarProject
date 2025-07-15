package velox.api.layer0.credentialscomponents;

import javax.swing.JTextField;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import velox.api.layer1.gui.StatusIconTextField;
import velox.api.layer1.data.ExtendedLoginData;

/**
 * Interface for credentials components that can be checked for text input validation
 */
public interface CredentialsComponentTextCheckable {
    
    /**
     * Return StatusIconTextField to be checked for leading/trailing spaces
     * @return Array of StatusIconTextField objects for spaces validation
     */
    StatusIconTextField[] getStatusIconTextFieldSpacesCheckable();
    
    /**
     * Return StatusIconTextField to be checked for leading/trailing spaces AND caps lock
     * @return Array of StatusIconTextField objects for caps lock and spaces validation
     */
    StatusIconTextField[] getStatusIconTextFieldCapsLockSpacesCheckable();
}

/**
 * Main interface for credentials components
 */
public interface CredentialsComponent {
    
    /**
     * Gets values for CredentialsComponent elements.
     * Keys are names for CredentialsComponent elements.
     * While logging in, an adapter will get a ExtendedLoginData object
     * which will contain this map (values may be updated by the user)
     * @return Map of component names to their serialization fields
     */
    Map<String, CredentialsSerializationField> getValues();
    
    /**
     * Sets values for CredentialsComponent elements while restoring saved values.
     * @param serializedFields Map of serialized field data
     */
    void setValues(Map<String, CredentialsSerializationField> serializedFields);
    
    /**
     * Get the name of this component
     * @return Component name
     */
    String getName();
    
    /**
     * Check if this component represents a key field
     * @return true if this is a key component
     */
    boolean isKey();
}

/**
 * Serialization field for credentials data
 */
public class CredentialsSerializationField {
    private String value;
    private boolean isKey;
    private boolean isHidden;
    
    public CredentialsSerializationField(String value, boolean isKey, boolean isHidden) {
        this.value = value;
        this.isKey = isKey;
        this.isHidden = isHidden;
    }
    
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
    public boolean isKey() { return isKey; }
    public void setKey(boolean key) { isKey = key; }
    public boolean isHidden() { return isHidden; }
    public void setHidden(boolean hidden) { isHidden = hidden; }
}

/**
 * Abstract base class for multi-credentials components
 */
public abstract class MultiCredentialsComponent {
    protected Map<String, String> aliases;
    protected List<CredentialsComponent> components;
    protected Object panel; // GUI panel object
    
    public MultiCredentialsComponent() {
        this.aliases = new HashMap<>();
        this.components = new ArrayList<>();
    }
    
    /**
     * Add an alias for component mapping
     * @param alias The alias name
     * @param componentName The actual component name
     */
    public void addAlias(String alias, String componentName) {
        aliases.put(alias, componentName);
    }
    
    /**
     * Get all aliases
     * @return Map of aliases
     */
    public Map<String, String> getAliases() {
        return aliases;
    }
    
    /**
     * Get the compound component
     * @return The compound component object
     */
    public abstract Object getCompoundComponent();
}

/**
 * Base abstract class for credentials components
 */
public abstract class BaseCredentialsComponent extends MultiCredentialsComponent implements CredentialsComponent {
    protected String name;
    protected boolean isKey;
    protected boolean isListening;
    protected List<Runnable> settingsChangedListeners;
    
    public BaseCredentialsComponent(String name, boolean isKey) {
        super();
        this.name = name;
        this.isKey = isKey;
        this.isListening = false;
        this.settingsChangedListeners = new ArrayList<>();
    }
    
    /**
     * Add a listener for settings changes
     * @param listener Runnable to execute on settings change
     */
    public void addSettingsChangedListener(Runnable listener) {
        settingsChangedListeners.add(listener);
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Set the component name
     * @param name New name for the component
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean isKey() {
        return isKey;
    }
    
    /**
     * Called when component status changes
     */
    protected void onStatusChanged() {
        for (Runnable listener : settingsChangedListeners) {
            listener.run();
        }
    }
}

/**
 * An implementation of BaseCredentialsComponent for entering text (login/password)
 */
public class CredentialsTextField extends BaseCredentialsComponent implements CredentialsComponentTextCheckable {
    
    protected String defaultValue;
    protected boolean isHidden;
    protected JTextField textField;
    protected StatusIconTextField statusIconTextField;
    
    /**
     * Constructor for CredentialsTextField
     * @param name Component name
     * @param isKey Whether this is a key field
     * @param label Label text for the field
     * @param isHidden Whether the field value should be hidden (masked)
     */
    public CredentialsTextField(String name, boolean isKey, String label, boolean isHidden) {
        super(name, isKey);
        this.isHidden = isHidden;
        this.defaultValue = "";
        initializeComponents(label);
    }
    
    /**
     * Constructor for CredentialsTextField with default value
     * @param name Component name
     * @param isKey Whether this is a key field
     * @param label Label text for the field
     * @param isHidden Whether the field value should be hidden (masked)
     * @param defaultValue Default value for the text field
     */
    public CredentialsTextField(String name, boolean isKey, String label, boolean isHidden, String defaultValue) {
        super(name, isKey);
        this.isHidden = isHidden;
        this.defaultValue = defaultValue != null ? defaultValue : "";
        initializeComponents(label);
    }
    
    /**
     * Initialize the GUI components
     * @param label Label for the text field
     */
    private void initializeComponents(String label) {
        if (isHidden) {
            // Create password field for hidden values
            textField = new JPasswordField();
        } else {
            textField = new JTextField();
        }
        
        textField.setText(defaultValue);
        statusIconTextField = new StatusIconTextField(textField, label);
    }
    
    /**
     * Get the default value
     * @return Default value string
     */
    public String getDefaultValue() {
        return defaultValue;
    }
    
    /**
     * Set the default text value
     * @param defaultValue New default value
     */
    public void setDefaultText(String defaultValue) {
        this.defaultValue = defaultValue != null ? defaultValue : "";
        if (textField != null) {
            textField.setText(this.defaultValue);
        }
    }
    
    @Override
    public Map<String, CredentialsSerializationField> getValues() {
        Map<String, CredentialsSerializationField> values = new HashMap<>();
        String currentValue = getValue();
        CredentialsSerializationField field = new CredentialsSerializationField(currentValue, isKey, isHidden);
        values.put(name, field);
        return values;
    }
    
    @Override
    public void setValues(Map<String, CredentialsSerializationField> serializedFields) {
        if (serializedFields != null && serializedFields.containsKey(name)) {
            CredentialsSerializationField field = serializedFields.get(name);
            if (field != null && textField != null) {
                textField.setText(field.getValue());
            }
        }
    }
    
    @Override
    public StatusIconTextField[] getStatusIconTextFieldSpacesCheckable() {
        return statusIconTextField != null ? new StatusIconTextField[]{statusIconTextField} : new StatusIconTextField[0];
    }
    
    @Override
    public StatusIconTextField[] getStatusIconTextFieldCapsLockSpacesCheckable() {
        return statusIconTextField != null ? new StatusIconTextField[]{statusIconTextField} : new StatusIconTextField[0];
    }
    
    /**
     * A simple value getter for the JTextField object which belongs to this CredentialsTextField.
     * @return value or "" if the text field not initialized.
     */
    public String getValue() {
        return textField != null ? textField.getText() : "";
    }
    
    /**
     * Retrieve internal text field for further customization (e.g. to forbid certain characters).
     * @return The internal JTextField component
     */
    public JTextField getTextField() {
        return textField;
    }
    
    @Override
    public Object getCompoundComponent() {
        return statusIconTextField;
    }
}

/**
 * Password field implementation extending JTextField
 */
class JPasswordField extends JTextField {
    public JPasswordField() {
        super();
        // Password field specific initialization would go here
    }
    
    @Override
    public String getText() {
        // Override to handle password masking if needed
        return super.getText();
    }
}

/**
 * Placeholder for StatusIconTextField - this would be implemented in layer1.gui
 */
class StatusIconTextField {
    private JTextField textField;
    private String label;
    
    public StatusIconTextField(JTextField textField, String label) {
        this.textField = textField;
        this.label = label;
    }
    
    public JTextField getTextField() {
        return textField;
    }
    
    public String getLabel() {
        return label;
    }
}

/**
 * Placeholder for ExtendedLoginData - this would be implemented in layer1.data
 */
class ExtendedLoginData {
    private Map<String, CredentialsSerializationField> credentials;
    
    public ExtendedLoginData() {
        this.credentials = new HashMap<>();
    }
    
    public Map<String, CredentialsSerializationField> getCredentials() {
        return credentials;
    }
    
    public void setCredentials(Map<String, CredentialsSerializationField> credentials) {
        this.credentials = credentials;
    }
}