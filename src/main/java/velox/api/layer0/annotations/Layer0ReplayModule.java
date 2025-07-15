package velox.api.layer0.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * This annotation allows automatic discovery of layer0 module entry points.
 * 
 * Used to mark classes or methods that serve as entry points for layer0 modules,
 * enabling automatic discovery and initialization during runtime.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Layer0ReplayModule {
    
    /**
     * Optional module name identifier
     * @return the module name, defaults to empty string
     */
    String name() default "";
    
    /**
     * Optional module version
     * @return the module version, defaults to "1.0"
     */
    String version() default "1.0";
    
    /**
     * Optional priority for module loading order
     * @return the priority value, defaults to 0
     */
    int priority() default 0;
    
    /**
     * Optional description of the module
     * @return the module description, defaults to empty string
     */
    String description() default "";
}