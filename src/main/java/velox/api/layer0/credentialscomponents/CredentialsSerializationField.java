package velox.api.layer0.credentialscomponents;

/**
 * A unified CredentialsComponent value representation
 */
public class CredentialsSerializationField {
    
    private boolean isKey;
    private boolean isHidden;
    private String stringValue;
    
    /**
     * Default constructor
     */
    public CredentialsSerializationField() {
        this.isKey = false;
        this.isHidden = false;
        this.stringValue = null;
    }
    
    /**
     * Constructor with parameters
     * @param isKey whether this field is a key field
     * @param isHidden whether this field should be hidden
     * @param stringValue the string value of this field
     */
    public CredentialsSerializationField(boolean isKey, boolean isHidden, String stringValue) {
        this.isKey = isKey;
        this.isHidden = isHidden;
        this.stringValue = stringValue;
    }
    
    /**
     * Check if this field is a key field
     * @return true if this is a key field, false otherwise
     */
    public boolean isKey() {
        return isKey;
    }
    
    /**
     * Set whether this field is a key field
     * @param isKey true if this is a key field, false otherwise
     */
    public void setKey(boolean isKey) {
        this.isKey = isKey;
    }
    
    /**
     * Check if this field should be hidden
     * @return true if this field should be hidden, false otherwise
     */
    public boolean isHidden() {
        return isHidden;
    }
    
    /**
     * Set whether this field should be hidden
     * @param isHidden true if this field should be hidden, false otherwise
     */
    public void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
    
    /**
     * Get the string value of this field
     * @return the string value
     */
    public String getStringValue() {
        return stringValue;
    }
    
    /**
     * Set the string value of this field
     * @param stringValue the string value to set
     */
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
    
    /**
     * Returns a string representation of this object
     * @return string representation of the CredentialsSerializationField
     */
    @Override
    public String toString() {
        return "CredentialsSerializationField{" +
                "isKey=" + isKey +
                ", isHidden=" + isHidden +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}