package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpaceCanvasFactory {

    ScreenSpaceCanvas createCanvas(ScreenSpaceCanvasType canvasType);

    enum ScreenSpaceCanvasType {
        // Define the areas that canvas corresponds to
        TYPE1,
        TYPE2,
        TYPE3
    }
}