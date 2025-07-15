package velox.api.layer0.credentialscomponents;

import javax.swing.JCheckBox;
import java.util.HashMap;
import java.util.Map;

/**
 * An implementation of BaseCredentialsComponent for a checkBox.
 */
public class CredentialsCheckbox extends BaseCredentialsComponent implements CredentialsComponent {

    protected JCheckBox checkBox;

    /**
     * Constructor for CredentialsCheckbox.
     *
     * @param name  The name of the checkbox field.
     * @param isKey Whether the checkbox represents a key.
     * @param label The label for the checkbox.
     */
    public CredentialsCheckbox(String name, boolean isKey, String label) {
        this.name = name;
        this.isKey = isKey;
        this.checkBox = new JCheckBox(label);
    }

    /**
     * A simple value getter for the JCheckBox object.
     *
     * @return true if selected, false otherwise.
     */
    public boolean getValue() {
        return checkBox.isSelected();
    }

    /**
     * Gets values for CredentialsComponent elements.
     *
     * @return Map of field name to CredentialsSerializationField.
     */
    public Map<String, CredentialsSerializationField> getValues() {
        Map<String, CredentialsSerializationField> map = new HashMap<>();
        map.put(name, new CredentialsSerializationField(Boolean.toString(checkBox.isSelected())));
        return map;
    }

    /**
     * Sets values for CredentialsComponent elements while restoring saved values.
     *
     * @param serializedFields A map of field name to CredentialsSerializationField.
     */
    public void setValues(Map<String, CredentialsSerializationField> serializedFields) {
        CredentialsSerializationField field = serializedFields.get(name);
        if (field != null) {
            checkBox.setSelected(Boolean.parseBoolean(field.getValue()));
        }
    }
}
