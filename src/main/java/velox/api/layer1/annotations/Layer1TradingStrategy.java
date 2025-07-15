package velox.api.layer1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Mark strategy as trading strategy, not allowing it to be used in non demo real trading
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layer1TradingStrategy {
    // No elements defined based on the JavaDoc
}