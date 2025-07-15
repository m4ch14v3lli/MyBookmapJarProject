package velox.api.layer1.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

/**
 * User will be able to control this strategy (enable/disable) via visibility popup menu.
 * Note that this menu is intended to control only visual components present on main chart, not bottom panel.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Layer1ChartControlVisbility {
    
    /**
     * Specifies whether the chart control is visible by default.
     * 
     * @return true if visible by default, false otherwise
     */
    boolean visible() default true;
    
    /**
     * Display name for the control in the visibility popup menu.
     * 
     * @return the display name
     */
    String displayName() default "";
    
    /**
     * Priority order for displaying in the visibility menu.
     * Lower values appear first.
     * 
     * @return the priority order
     */
    int priority() default 0;
    
    /**
     * Category grouping for the visibility menu.
     * 
     * @return the category name
     */
    String category() default "Default";
}