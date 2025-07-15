package velox.api.layer0.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation allows automatic discovery of layer0 module entry points.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Layer0LiveModule {
    
    /**
     * Full name describing the connectivity. Value example: "ExampleExchange".
     * Ignored if localizationKey() is not empty
     */
    String fullName() default "";
    
    /**
     * Short identifier. Preferably - 2 letters. Will be used in places where names
     * have to be short. Value example: "EE".
     */
    String shortName() default "";
    
    /**
     * Key for localization of the provider name. If this key is not empty and 
     * Layer1LocalizationBundle annotation is present, then the name of the provider will
     * be taken from the specified localization bundle using this key. This localized name will be used in all displayable dialogs.
     * If the specified bundle doesn't contain the key, an exception will be thrown when the localized name is retrieved.
     * Should be empty if no localization is needed.
     */
    String localizationKey() default "";
}

/**
 * Bookmap will only trust this annotation if provider is signed.
 * 
 * Use this annotation to mark a provider type.
 * If no annotation is specified Layer0ProviderTypeValue.UNKNOWN will be assumed by default.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Layer0ProviderType {
    
    /**
     * The provider type value
     */
    Layer0ProviderTypeValue value();
}

/**
 * Enumeration of provider type values
 */
public enum Layer0ProviderTypeValue {
    UNKNOWN,
    MARKET_DATA,
    EXECUTION,
    HISTORICAL_DATA,
    NEWS,
    RISK_MANAGEMENT,
    PORTFOLIO_MANAGEMENT,
    ANALYTICS,
    CONNECTIVITY,
    CUSTOM
}