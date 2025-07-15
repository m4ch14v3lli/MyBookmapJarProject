package velox.api.layer1.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Items marked with this annotation are exposed as part of L1 API. Note that
 * commenting it out will still cause javadoc to be generated.
 * 
 * "@_Layer1ApiPublic" (without _) is used as a criteria for javadoc generation.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
public @interface Layer1ApiPublic {
}