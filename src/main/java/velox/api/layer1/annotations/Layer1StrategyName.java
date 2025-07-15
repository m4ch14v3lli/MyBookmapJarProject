package velox.api.layer1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Specifies a name for strategy that will be displayed in strategies dialog
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Layer1StrategyName {
    
    /**
     * Name of strategy that will be used in the settings. If localizationKey() 
     * is empty or Layer1LocalizationBundle annotation is not present, then this 
     * name will be displayed as a strategy name in the related dialogs.
     * See also localizationKey() for more details.
     */
    String value();
    
    /**
     * Key for localization of strategy name. If this key is not empty and 
     * Layer1LocalizationBundle annotation is present, then the name of the 
     * strategy will be taken from the specified localization bundle using this key. 
     * This localized name will be used in all displayable dialogs, and value() 
     * will be used in the settings. If the specified bundle doesn't contain the 
     * key, an exception will be thrown when the localized name is retrieved.
     */
    String localizationKey() default "";
}