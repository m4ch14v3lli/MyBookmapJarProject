package velox.api.layer1.actions.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Allows declaring multiple Layer1ActionMetadata annotations over action class.
 * This is a container annotation that holds an array of Layer1ActionMetadata annotations.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Layer1ActionMetadataList {
    
    /**
     * Array of Layer1ActionMetadata annotations.
     * @return the array of Layer1ActionMetadata annotations
     */
    Layer1ActionMetadata[] value();
}