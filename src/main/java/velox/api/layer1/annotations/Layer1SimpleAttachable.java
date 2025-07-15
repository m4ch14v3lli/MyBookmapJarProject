package velox.api.layer1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Marks classes that can be loaded from GUI as a strategy.
 * Simplified version of Layer1 API, for more advanced (but more complex)
 * version use {@link Layer1Attachable}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layer1SimpleAttachable {
    
}