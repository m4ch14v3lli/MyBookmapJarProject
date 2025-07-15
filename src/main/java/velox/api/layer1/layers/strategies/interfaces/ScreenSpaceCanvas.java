package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpaceCanvas {

    long getUniqueId();

    void dispose();

    void addShape(CanvasShape canvasShape);

    void removeShape(CanvasShape canvasShape);

    void addMouseListener(CanvasMouseListener listener);

    void addContextMenuProvider(CanvasContextMenuProvider contextMenuProvider);

    interface CanvasShape {
        // Define methods for CanvasShape
    }

    interface CanvasMouseListener {
        // Define methods for CanvasMouseListener
    }

    interface CanvasContextMenuProvider {
        // Define methods for CanvasContextMenuProvider
    }
}