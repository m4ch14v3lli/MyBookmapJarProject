package velox.api.layer1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Use this annotation if your strategy should only be available if the user has
 * corresponding license field set to a date ahead of current date.
 * 
 * NOTE: right now you need to contact Bookmap support to discuss how to control
 * this field. In the future there will be a way to control it directly.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layer1StrategyDateLicensed {
    
    /**
     * Your strategy ID that you received from Bookmap support
     * 
     * @return the strategy ID string
     */
    String value();
}