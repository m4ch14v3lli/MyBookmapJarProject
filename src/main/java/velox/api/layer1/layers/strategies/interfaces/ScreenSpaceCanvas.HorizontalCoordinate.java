package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpaceCanvas {

    interface HorizontalCoordinate {
        CompositeHorizontalCoordinate compose();
    }

    class CompositeHorizontalCoordinate implements HorizontalCoordinate {
        // Implementation details can be added here if needed

        @Override
        public CompositeHorizontalCoordinate compose() {
            return this; // Example implementation
        }

        @Override
        public String toString() {
            return "CompositeHorizontalCoordinate{}"; // Example implementation
        }
    }
}