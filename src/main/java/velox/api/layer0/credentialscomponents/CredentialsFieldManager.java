package velox.api.layer0.credentialscomponents;

import java.util.List;
import java.util.Map;
import velox.api.layer1.data.ExtendedLoginData;

/**
 * Implement this interface to manage and return extended credentials.
 * This interface is used by Bookmap to handle credential management.
 * 
 * @see ExtendedLoginData
 */
public interface CredentialsFieldManager {
    
    /**
     * Returns a list of CredentialsComponent objects so they can be further 
     * managed by Bookmap.
     * 
     * @return List of CredentialsComponent objects for credential management
     */
    List<CredentialsComponent> getCredentialsComponents();
    
    /**
     * Returns true if credentials are configured, false if not (e.g. if login or
     * password are blank the credentials and, consequently, the connection may be
     * considered not configured). Criteria are up to the developer.
     * 
     * @param values values of the fields that need to be checked. Those will
     *               normally be from the components provided in
     *               getCredentialsComponents(), but you are still
     *               encouraged to check values from this parameter instead of
     *               storing the returned components
     * @return true if credentials are properly configured, false otherwise
     */
    boolean isConfigured(Map<String, CredentialsSerializationField> values);
}

/**
 * Interface for credential components that can be managed by the system.
 */
public interface CredentialsComponent {
    // Component-specific methods would be defined here
    // This interface would contain methods for handling individual credential components
}

/**
 * Class representing a serialization field for credentials.
 * This class handles the serialization and deserialization of credential fields.
 */
public class CredentialsSerializationField {
    
    private String fieldName;
    private Object fieldValue;
    private String fieldType;
    private boolean isRequired;
    private boolean isEncrypted;
    
    /**
     * Default constructor
     */
    public CredentialsSerializationField() {
    }
    
    /**
     * Constructor with field name and value
     * 
     * @param fieldName the name of the credential field
     * @param fieldValue the value of the credential field
     */
    public CredentialsSerializationField(String fieldName, Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param fieldName the name of the credential field
     * @param fieldValue the value of the credential field
     * @param fieldType the type of the field
     * @param isRequired whether the field is required
     * @param isEncrypted whether the field should be encrypted
     */
    public CredentialsSerializationField(String fieldName, Object fieldValue, 
                                       String fieldType, boolean isRequired, 
                                       boolean isEncrypted) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.fieldType = fieldType;
        this.isRequired = isRequired;
        this.isEncrypted = isEncrypted;
    }
    
    // Getters and Setters
    public String getFieldName() {
        return fieldName;
    }
    
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
    
    public Object getFieldValue() {
        return fieldValue;
    }
    
    public void setFieldValue(Object fieldValue) {
        this.fieldValue = fieldValue;
    }
    
    public String getFieldType() {
        return fieldType;
    }
    
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }
    
    public boolean isRequired() {
        return isRequired;
    }
    
    public void setRequired(boolean required) {
        isRequired = required;
    }
    
    public boolean isEncrypted() {
        return isEncrypted;
    }
    
    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }
    
    @Override
    public String toString() {
        return "CredentialsSerializationField{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldValue=" + fieldValue +
                ", fieldType='" + fieldType + '\'' +
                ", isRequired=" + isRequired +
                ", isEncrypted=" + isEncrypted +
                '}';
    }
}

/**
 * Abstract base class for implementing CredentialsFieldManager.
 * Provides common functionality for credential field management.
 */
public abstract class AbstractCredentialsFieldManager implements CredentialsFieldManager {
    
    protected List<CredentialsComponent> components;
    
    /**
     * Constructor
     */
    public AbstractCredentialsFieldManager() {
        initializeComponents();
    }
    
    /**
     * Initialize the credential components.
     * Subclasses should override this method to set up their specific components.
     */
    protected abstract void initializeComponents();
    
    /**
     * Validates a single credential field
     * 
     * @param fieldName the name of the field to validate
     * @param field the credential field to validate
     * @return true if the field is valid, false otherwise
     */
    protected boolean validateField(String fieldName, CredentialsSerializationField field) {
        if (field == null) {
            return false;
        }
        
        if (field.isRequired() && (field.getFieldValue() == null || 
            field.getFieldValue().toString().trim().isEmpty())) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates all required fields in the provided values map
     * 
     * @param values map of field names to credential fields
     * @return true if all required fields are valid, false otherwise
     */
    protected boolean validateAllFields(Map<String, CredentialsSerializationField> values) {
        for (Map.Entry<String, CredentialsSerializationField> entry : values.entrySet()) {
            if (!validateField(entry.getKey(), entry.getValue())) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public List<CredentialsComponent> getCredentialsComponents() {
        return components;
    }
    
    @Override
    public boolean isConfigured(Map<String, CredentialsSerializationField> values) {
        return validateAllFields(values);
    }
}