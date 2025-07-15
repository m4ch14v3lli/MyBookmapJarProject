package velox.api.layer1.messages.indicators;

import java.awt.Color;

public interface IndicatorColorScheme {

    String getColorFor(Double value);

    static String getColorFullName(String userName, Class<?> strategyClass) {
        // Implementation goes here
        return null;  // Placeholder return
    }

    static ColorIntervalResponse getColorIntervalsList(double valueFrom, double valueTo) {
        // Implementation goes here
        return null;  // Placeholder return
    }

    ColorDescription[] getColors();

    default Color getDefaultColor() {
        return null;  // Placeholder return
    }

    default String getMainColorName() {
        return null;  // Placeholder return
    }

    interface ColorDescription {
        // Define methods for ColorDescription if necessary
    }

    class ColorIntervalResponse {
        // Define fields and methods for ColorIntervalResponse if necessary
    }
}