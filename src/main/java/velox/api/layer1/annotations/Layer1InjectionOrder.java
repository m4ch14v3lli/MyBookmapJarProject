package velox.api.layer1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * Specifies the order of injection of strategies in the layers chain.
 * 
 * The order of injection is determined by the value of the annotation.
 * The lower the value, the lower the strategy is injected in the chain compared to other strategies (closer to the data provider).
 * 
 * If two strategies have the same order number, the order of injection is determined by the alphabetical order of the
 * entry point class names.
 * 
 * The default order value is 0.
 * 
 * Note: This annotation can be used only with classes marked with Layer1Injectable and Layer1UpstreamDataEditor.
 * 
 * Example of injection order:
 * 1. Data Provider
 * 2. com.example.X1, order value = -1000
 * 3. com.example.X2, order value = -42
 * 4. com.example.A3, order value = 0
 * 5. com.example.B3, order value = 0
 * 6. com.example.C3, order value = 0
 * 7. com.example.D3, order value = 0
 * 8. com.example.X4, order value = 1
 * 9. com.example.X5, order value = 2
 * 10. com.example.A6, order value = 100
 * 11. com.example.B6, order value = 100
 * 12. com.example.C6, order value = 100
 * 13. com.example.X7, order value = 99999
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Layer1InjectionOrder {
    
    /**
     * @return the order value
     */
    int value();
}