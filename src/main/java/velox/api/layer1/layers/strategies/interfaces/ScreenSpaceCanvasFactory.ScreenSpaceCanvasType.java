package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpaceCanvasFactory {

    ScreenSpaceCanvas createCanvas(ScreenSpaceCanvasType canvasType);

    enum ScreenSpaceCanvasType {
        FULL_WINDOW("Entire window - does not work yet"),
        HEATMAP("Heatmap area"),
        RIGHT_OF_TIMELINE("Area right of the timeline");

        private final String description;

        ScreenSpaceCanvasType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}