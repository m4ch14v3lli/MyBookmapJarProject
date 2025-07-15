package velox.api.layer1.settings;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation interface StrategySettingsVersion defines the current version of settings 
 * and compatibility with previous versions. Any settings that wish to be saved 
 * and loaded from config should have this annotation.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface StrategySettingsVersion {

    /**
     * Defines the current settings version.
     *
     * @return the current version
     */
    int currentVersion();

    /**
     * Defines the settings versions that are compatible with the current settings version.
     *
     * @return an array of compatible versions
     */
    int[] compatibleVersions();
}