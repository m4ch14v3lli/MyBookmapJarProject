package velox.api.layer1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Tells bookmap that strategy will be modifying upstream data (e.g. creating
 * synthetic instruments). Such strategy will only work in live mode.
 * Significant part of API functionality won't work in this mode.
 * 
 * @see velox.api.layer1.utils.Layer1SyntheticInstrumentProvider
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Layer1UpstreamDataEditor {
    
}