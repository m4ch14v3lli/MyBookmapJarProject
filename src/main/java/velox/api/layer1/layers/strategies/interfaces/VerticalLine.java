package velox.api.layer1.layers.strategies.interfaces;

public class VerticalLine {
    public final String color;

    public VerticalLine(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "VerticalLine{" +
                "color='" + color + '\'' +
                '}';
    }
}