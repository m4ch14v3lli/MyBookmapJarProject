package velox.api.layer0.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Use this annotation if your module should only be available if it user has
 * corresponding license field set to a date ahead of current date.
 * 
 * NOTE: right now you need contact Bookmap support to discuss how to control
 * this field. In the future there will be a way to control it directly.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Layer0DateLicensed {
    
    /**
     * Your module ID that you received from Bookmap support
     * 
     * @return the module ID string for license validation
     */
    String value();
}