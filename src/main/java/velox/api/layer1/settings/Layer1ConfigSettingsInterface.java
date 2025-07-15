package velox.api.layer1.settings;

/**
 * Interface Layer1ConfigSettingsInterface allows strategies to receive 
 * an interface for saving/loading settings from the Bookmap configuration.
 */
public interface Layer1ConfigSettingsInterface {

    /**
     * Accepts an interface to interact with settings.
     *
     * @param settingsAccess The interface for accessing settings.
     */
    void acceptSettingsInterface(SettingsAccess settingsAccess);
}