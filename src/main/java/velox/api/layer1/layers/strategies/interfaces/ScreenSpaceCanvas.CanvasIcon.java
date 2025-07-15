package velox.api.layer1.layers.strategies.interfaces;

public class ScreenSpaceCanvas {

    public static class CanvasIcon extends BasicCanvasShape {
        private PreparedImage image;
        private HorizontalCoordinate x1, x2;
        private VerticalCoordinate y1, y2;

        public CanvasIcon(PreparedImage image, HorizontalCoordinate x1, VerticalCoordinate y1,
                          HorizontalCoordinate x2, VerticalCoordinate y2) {
            this.image = image;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public PreparedImage getImage() {
            return image;
        }

        public HorizontalCoordinate getX1() {
            return x1;
        }

        public VerticalCoordinate getY1() {
            return y1;
        }

        public HorizontalCoordinate getX2() {
            return x2;
        }

        public VerticalCoordinate getY2() {
            return y2;
        }

        public void setImage(PreparedImage icon) {
            this.image = icon;
        }

        public void setX1(HorizontalCoordinate x1) {
            this.x1 = x1;
        }

        public void setX2(HorizontalCoordinate x2) {
            this.x2 = x2;
        }

        public void setY1(VerticalCoordinate y1) {
            this.y1 = y1;
        }

        public void setY2(VerticalCoordinate y2) {
            this.y2 = y2;
        }

        public CanvasIcon copy() {
            return new CanvasIcon(image, x1, y1, x2, y2);
        }
    }

    public static abstract class BasicCanvasShape {
        protected long uniqueId;

        public long getUniqueId() {
            return uniqueId;
        }

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

    public interface PreparedImage {
        // Define methods for PreparedImage
    }

    public interface HorizontalCoordinate {
        // Define methods for HorizontalCoordinate
    }

    public interface VerticalCoordinate {
        // Define methods for VerticalCoordinate
    }
}