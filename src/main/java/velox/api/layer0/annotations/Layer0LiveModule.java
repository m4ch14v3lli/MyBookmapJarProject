package velox.api.layer0.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation allows automatic discovery of layer0 module entry points.
 * 
 * This annotation is used to mark classes that serve as entry points for Layer0 modules,
 * enabling automatic discovery and configuration of connectivity modules.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Layer0LiveModule {
    
    /**
     * Full name describing the connectivity.
     * Value example: "ExampleExchange".
     * Ignored if localizationKey() is not empty.
     * 
     * @return the full name of the module, empty string by default
     */
    String fullName() default "";
    
    /**
     * Short identifier. Preferably - 2 letters. Will be used in places where names
     * have to be short. Value example: "EE".
     * 
     * @return the short identifier for the module, empty string by default
     */
    String shortName() default "";
    
    /**
     * Key for localization of the provider name. If this key is not empty and 
     * Layer1LocalizationBundle annotation is present, then the name of the provider will
     * be taken from the specified localization bundle using this key. This localized name will be used in all displayable dialogs.
     * If the specified bundle doesn't contain the key, an exception will be thrown when the localized name is retrieved.
     * Should be empty if no localization is needed.
     * 
     * @return the localization key for the provider name, empty string by default
     */
    String localizationKey() default "";
}