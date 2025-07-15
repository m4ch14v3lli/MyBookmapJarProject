package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpacePainterAdapter extends ScreenSpacePainter {
    default void dispose() {
        // Implementation for disposing resources
    }

    default void onHeatmapActivePixelsWidth(int heatmapActivePixelsWidth) {
        // Update heatmap active pixels width
    }

    default void onHeatmapActiveTimeWidth(long heatmapActiveTimeWidth) {
        // Update heatmap active time width
    }

    default void onHeatmapFullPixelsWidth(int heatmapFullPixelsWidth) {
        // Update heatmap full pixels width
    }

    default void onHeatmapFullTimeWidth(long heatmapFullTimeWidth) {
        // Update heatmap full time width
    }

    default void onHeatmapPixelsBottom(int heatmapPixelsBottom) {
        // Update heatmap bottom position
    }

    default void onHeatmapPixelsHeight(int heatmapPixelsHeight) {
        // Update heatmap height
    }

    default void onHeatmapPixelsLeft(int heatmapPixelsLeft) {
        // Update heatmap left position
    }

    default void onHeatmapPriceBottom(long heatmapPriceBottom) {
        // Update heatmap price bottom
    }

    default void onHeatmapPriceHeight(long heatmapPriceHeight) {
        // Update heatmap price height
    }

    default void onHeatmapTimeLeft(long heatmapTimeLeft) {
        // Update heatmap time left
    }

    default void onMoveStart() {
        // Handle move start event
    }

    default void onMoveEnd() {
        // Handle move end event
    }

    default void onRightOfTimelineLeft(int rightOfTimelineLeft) {
        // Update right of timeline left position
    }

    default void onRightOfTimelineWidth(int rightOfTimelineWidth) {
        // Update right of timeline width
    }
}