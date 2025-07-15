package velox.api.layer1.data;

import java.io.Serializable;
import java.util.Map;
import velox.api.layer0.credentialscomponents.CredentialsSerializationField;

/**
 * Implementation of LoginData.
 * Contains a Map<String, CredentialsSerializationField> of extended login data.
 * Your L0 provider will obtain it on Layer1ApiAdminProvider.login(LoginData) call
 * if it is annotated with Layer0CredentialsFieldsManager
 * 
 * @see velox.api.layer0.annotations.Layer0CredentialsFieldsManager
 */
public class ExtendedLoginData implements LoginData, Serializable {
    
    /**
     * Extended login data stored as a map of field names to credential serialization fields
     */
    public final Map<String, CredentialsSerializationField> extendedData;
    
    /**
     * Constructor for ExtendedLoginData
     * 
     * @param extendedData Map containing the extended login data fields
     */
    public ExtendedLoginData(Map<String, CredentialsSerializationField> extendedData) {
        this.extendedData = extendedData;
    }
}