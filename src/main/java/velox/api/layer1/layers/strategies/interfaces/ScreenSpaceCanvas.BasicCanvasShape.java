package velox.api.layer1.layers.strategies.interfaces;

public abstract class ScreenSpaceCanvas {

    public static abstract class BasicCanvasShape implements CanvasShape {
        protected long uniqueId;

        public BasicCanvasShape() {
            // Constructor logic can be added here if needed
        }

        @Override
        public long getUniqueId() {
            return uniqueId;
        }

        @Override
        public void setShapeListener(ScreenSpaceShapeListener listener) {
            // Implementation for setting the shape listener
        }

        protected void publishChange() {
            // Logic to publish changes
        }
    }

    public interface CanvasShape {
        long getUniqueId();
        void setShapeListener(ScreenSpaceShapeListener listener);
        CanvasShape copy();
    }

    public interface ScreenSpaceShapeListener {
        // Define methods for the shape listener
    }
}