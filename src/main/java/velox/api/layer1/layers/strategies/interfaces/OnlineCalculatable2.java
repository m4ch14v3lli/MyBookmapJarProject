package velox.api.layer1.layers.strategies.interfaces;

import java.util.function.Consumer;

public interface OnlineCalculatable {

    interface DataCoordinateMarker {
        double getMinY();
        double getMaxY();
        double getValueY();
        Marker makeMarker(Function<Double, Integer> yDataCoordinateToPixelFunction);
    }

    void calculateValuesInRange(String indicatorName, String indicatorAlias, long t0, long intervalWidth, int intervalsNumber, CalculatedResultListener listener);

    OnlineValueCalculatorAdapter createOnlineValueCalculator(String indicatorName, String indicatorAlias, long time, Consumer<Object> listener, InvalidateInterface invalidateInterface);

    default boolean shouldRepeatCalculateValuesInRange(String indicatorName, String indicatorAlias, long intervalWidth, long timePassed) {
        return true; // Default implementation
    }

    default boolean allowPartialUpdates(String indicatorName, String alias) {
        return true; // Default implementation
    }

    interface Marker {
        // Define methods for Marker if necessary
    }
}