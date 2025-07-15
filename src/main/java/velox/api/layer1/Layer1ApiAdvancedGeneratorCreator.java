package velox.api.layer1;

/**
 * @deprecated
 * Interface Layer1ApiAdvancedGeneratorCreator is deprecated. 
 * Use Layer1ApiNotReloadedOnSettingsChange instead.
 */
@Deprecated
public interface Layer1ApiAdvancedGeneratorCreator {

    /**
     * Called when data has been changed (e.g., as new feed is being loaded) or strategy is manually added. 
     * Strategy is expected to add all required generators here.
     */
    void onAddGenerators();

    /**
     * Called when strategy is being unloaded due to data change (e.g., as new feed is being loaded) 
     * or if strategy is manually removed.
     */
    void onRemoveIndicators();

    /**
     * Called when settings have been changed. All previously added generators must be handled appropriately.
     */
    void onSettingsChanged();
}