package velox.api.layer1.layers.strategies.interfaces;

import java.util.function.LongSupplier;

public interface OnlineValueCalculatorAdapter extends Layer1ApiMboDataAdapter, Layer1ApiDataAdapter, Layer1ApiTradingAdapter {

    default void onIntervalsNumber(int intervalsNumber) {
        // Default implementation
    }

    default void onIntervalWidth(long intervalWidth) {
        // Default implementation
    }

    default void onLeftTimeChanged(long leftTime) {
        // Default implementation
    }

    default void onRealTimeDataStart() {
        // Default implementation
    }

    default void onTimeSourceProvided(LongSupplier timeSource) {
        // Default implementation
    }

    default void onUserMessage(Object data) {
        // Default implementation
    }
}