package velox.api.layer1.actions.annotations;

import java.lang.annotation.*;

/**
 * Mark your Layer1ExternalAction implementations with this annotation.
 * 
 * This annotation is used to provide metadata for external actions that can be
 * registered in the system and made available through keyboard shortcuts.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Layer1ActionMetadataList.class)
public @interface Layer1ActionMetadata {
    
    /**
     * Action unique identifier. It's a mandatory field.
     * 
     * @return the unique identifier for this action
     */
    String id();
    
    /**
     * Describes group hierarchy where the action will be located
     * in the Keyboard Shortcuts window.
     * 
     * The root group for all external actions is Addons/strategy_name.
     * 
     * @return array of group names forming the hierarchy
     */
    String[] groups() default {};
    
    /**
     * The action name you see in Keyboard Shortcuts.
     * If it's not present the id() field will be used instead.
     * 
     * @return the display name for this action
     */
    String name() default "";
}

/**
 * Container annotation for repeatable Layer1ActionMetadata annotations.
 * This allows multiple Layer1ActionMetadata annotations to be applied to the same class.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Layer1ActionMetadataList {
    Layer1ActionMetadata[] value();
}

/**
 * Interface that must be implemented by all external actions.
 * Classes implementing this interface should be annotated with Layer1ActionMetadata.
 */
public interface Layer1ExternalAction {
    
    /**
     * Execute the action.
     * This method is called when the action is triggered.
     */
    void execute();
    
    /**
     * Check if the action is currently enabled.
     * 
     * @return true if the action can be executed, false otherwise
     */
    default boolean isEnabled() {
        return true;
    }
    
    /**
     * Get the current state of the action.
     * This can be used for toggle actions or to show current status.
     * 
     * @return the current state description, or null if not applicable
     */
    default String getState() {
        return null;
    }
}

/**
 * Abstract base class for Layer1ExternalAction implementations.
 * Provides common functionality and default implementations.
 */
public abstract class AbstractLayer1ExternalAction implements Layer1ExternalAction {
    
    private boolean enabled = true;
    
    /**
     * Set whether this action is enabled.
     * 
     * @param enabled true to enable the action, false to disable
     */
    protected void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public boolean isEnabled() {
        return enabled;
    }
    
    /**
     * Template method for action execution.
     * Subclasses should override this method to implement their specific logic.
     */
    @Override
    public abstract void execute();
}

/**
 * Example implementation of a Layer1ExternalAction.
 * This demonstrates how to use the Layer1ActionMetadata annotation.
 */
@Layer1ActionMetadata(
    id = "example.action",
    name = "Example Action",
    groups = {"Examples", "Demo Actions"}
)
public class ExampleAction extends AbstractLayer1ExternalAction {
    
    @Override
    public void execute() {
        System.out.println("Example action executed!");
    }
    
    @Override
    public String getState() {
        return "Ready";
    }
}