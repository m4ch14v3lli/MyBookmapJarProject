package velox.api.layer1.layers.strategies.interfaces;

public interface ScreenSpaceCanvas {

    interface VerticalCoordinate {
        CompositeVerticalCoordinate compose();
    }

    class CompositeVerticalCoordinate {
        // Implementation details can be added here

        @Override
        public String toString() {
            return "CompositeVerticalCoordinate{}"; // Example implementation
        }
    }
}