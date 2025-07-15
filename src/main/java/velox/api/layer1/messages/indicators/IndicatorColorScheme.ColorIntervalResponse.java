package velox.api.layer1.messages.indicators;

public class IndicatorColorScheme {

    public static class ColorIntervalResponse {
        public final String[] colors;
        public final double[] dots;

        public ColorIntervalResponse(String[] colors, double[] dots) {
            if (dots.length != colors.length - 1) {
                throw new IllegalArgumentException("Size of dots list must be one less than size of colors list.");
            }
            this.colors = colors;
            this.dots = dots;
        }
    }
}