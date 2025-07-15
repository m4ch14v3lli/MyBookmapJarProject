package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpaceCanvas {

    interface CanvasShape {
        long getUniqueId();
        void setShapeListener(ScreenSpaceShapeListener listener);
        CanvasShape copy();
    }

    interface ScreenSpaceShapeListener {
        // Define methods for handling shape events
    }
}