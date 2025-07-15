package velox.api.layer1.messages.indicators;

public class BoundsInfo {

    public Double initialValue;
    public Double minValue;
    public Double maxValue;

    public BoundsInfo(Double initialValue, Double minValue, Double maxValue) {
        this.initialValue = initialValue;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public String toString() {
        return "BoundsInfo{" +
                "initialValue=" + initialValue +
                ", minValue=" + minValue +
                ", maxValue=" + maxValue +
                '}';
    }
}