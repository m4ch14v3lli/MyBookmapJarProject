package velox.api.layer1;

/**
 * Interface Layer1ApiFinishable defines actions to be taken when 
 * a strategy is being unloaded, such as removing GUI elements and disposing of dialogs.
 */
public interface Layer1ApiFinishable {

    /**
     * This method will be called when the strategy is being unloaded.
     * All previously known values should be considered outdated.
     */
    void finish();
}