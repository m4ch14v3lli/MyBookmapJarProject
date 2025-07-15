package velox.api.layer1.messages.indicators;

/**
 * Interface SettingsAccess for saving or retrieving settings from configuration.
 */
public interface SettingsAccess {

    /**
     * Retrieves settings based on the specified parameters.
     *
     * @param alias        the instrument alias for which the settings are requested, or null for global settings.
     * @param fullName     the full name of the strategy.
     * @param settingsClass the class type of the settings object.
     * @return the settings object. If no compatible saved object is found, a new object will be created with the default constructor.
     *         Note: Modifying the returned object does not change the settings. Use setSettings() to save changes.
     */
    Object getSettings(String alias, String fullName, Class<?> settingsClass);

    /**
     * Saves the specified settings object.
     *
     * @param alias        the instrument alias for which the settings are being saved, or null for global settings.
     * @param fullName     the full name of the strategy.
     * @param settings     the settings object to save.
     * @param settingsClass the class type of the settings object.
     */
    void setSettings(String alias, String fullName, Object settings, Class<?> settingsClass);
}