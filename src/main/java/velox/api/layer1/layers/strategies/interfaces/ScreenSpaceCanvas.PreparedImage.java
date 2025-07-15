package velox.api.layer1.layers.strategies.interfaces;

import java.awt.image.BufferedImage;

public class ScreenSpaceCanvas {

    public static class PreparedImage {
        private final BufferedImage image;

        public PreparedImage(BufferedImage image) {
            this.image = image;
        }

        public BufferedImage getReadOnlyImage() {
            return image; // Returns the image; do not modify it
        }

        public int[] getReadOnlyOpenglRepresentation() {
            // Implementation for OpenGL representation
            return new int[0]; // Placeholder for actual OpenGL representation
        }
    }
}