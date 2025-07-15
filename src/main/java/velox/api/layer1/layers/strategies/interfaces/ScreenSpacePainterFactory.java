package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpacePainterFactory {
    ScreenSpacePainter createScreenSpacePainter(String indicatorName, String indicatorAlias, ScreenSpaceCanvasFactory screenSpaceCanvasFactory);
}