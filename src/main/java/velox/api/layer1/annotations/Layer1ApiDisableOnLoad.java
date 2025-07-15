package velox.api.layer1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Marks strategy that can not be auto enabled on load based on settings, 
 * no matter what it's previous state was.
 * 
 * This annotation is used to prevent automatic enabling of trading strategies
 * during system startup, regardless of their previous configuration state.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layer1ApiDisableOnLoad {
    
}