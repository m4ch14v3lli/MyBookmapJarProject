package velox.api.layer1.layers.strategies.interfaces;

import java.awt.image.BufferedImage;

public class OnlineCalculatable {

    public static class Marker {
        public final double markerY;
        public final int iconOffsetX;
        public final int iconOffsetY;
        public final BufferedImage icon;

        public Marker(double markerY, int iconOffsetX, int iconOffsetY, BufferedImage icon) {
            this.markerY = markerY;
            this.iconOffsetX = iconOffsetX;
            this.iconOffsetY = iconOffsetY;
            this.icon = icon; // Cloning can be done if needed
        }

        @Override
        public String toString() {
            return "Marker{" +
                    "markerY=" + markerY +
                    ", iconOffsetX=" + iconOffsetX +
                    ", iconOffsetY=" + iconOffsetY +
                    '}';
        }
    }
}