package velox.api.layer1.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Accepts integer value specifying API version that was used to write this
 * module. Only the entry point should be marked with this. When breaking
 * changes are made to the API bookmap will try to use compatibility mechanism
 * in order to keep code written for older versions running. 
 * 
 * Note: If no annotation is specified, Layer1ApiVersionValue.VERSION0 will be 
 * assumed by default, which is probably not version you want to use if you are 
 * writing a new module.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layer1ApiVersion {
    
    /**
     * The API version value
     * @return the Layer1ApiVersionValue enum value
     */
    Layer1ApiVersionValue value();
}

/**
 * Enum representing the different API version values
 */
public enum Layer1ApiVersionValue {
    VERSION0,
    VERSION1,
    VERSION2,
    VERSION3,
    VERSION4,
    VERSION5,
    VERSION6,
    VERSION7
}