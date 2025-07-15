package velox.api.layer0.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import velox.api.layer0.credentialscomponents.CredentialsFieldManager;

/**
 * Annotate Layer0 provider with this to customize the login window. If you use
 * this annotation, your provider will obtain an instance of ExtendedLoginData
 * on Layer1ApiAdminProvider.login(LoginData)
 * 
 * @see velox.api.layer1.data.ExtendedLoginData
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layer0CredentialsFieldsManager {
    
    /**
     * The class that extends CredentialsFieldManager to handle custom login fields
     * 
     * @return the CredentialsFieldManager implementation class
     */
    Class<? extends CredentialsFieldManager> value();
}