package velox.api.layer1.layers;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

public interface Layer1ApiTimeSource {
    
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public static @interface Layer1TimeSourceShortcutAllowed {
        // Marker annotation to confirm support for the shortcut in
        // Layer1ApiAdminProvider.getCurrentTime()
    }
}