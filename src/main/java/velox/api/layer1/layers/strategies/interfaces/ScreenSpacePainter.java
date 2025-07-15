package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpacePainter {
    void dispose();

    void onHeatmapActivePixelsWidth(int heatmapActivePixelsWidth);

    void onHeatmapActiveTimeWidth(long heatmapActiveTimeWidth);

    void onHeatmapFullPixelsWidth(int heatmapFullPixelsWidth);

    void onHeatmapFullTimeWidth(long heatmapFullTimeWidth);

    void onHeatmapPixelsBottom(int heatmapPixelsBottom);

    void onHeatmapPixelsHeight(int heatmapPixelsHeight);

    void onHeatmapPixelsLeft(int heatmapPixelsLeft);

    void onHeatmapPriceBottom(long heatmapPriceBottom);

    void onHeatmapPriceHeight(long heatmapPriceHeight);

    void onHeatmapTimeLeft(long heatmapTimeLeft);

    void onMoveStart();

    void onMoveEnd();

    void onRightOfTimelineLeft(int rightOfTimelineLeft);

    void onRightOfTimelineWidth(int rightOfTimelineWidth);
}