package velox.api.layer1.messages.indicators;

/**
 * Class LimitsResponse describes the calculated limits range for indicators.
 */
public class LimitsResponse {
    
    public double minValue; // Minimum value of the limits
    public double maxValue; // Maximum value of the limits

    /**
     * Constructor for LimitsResponse.
     *
     * @param minValue Minimum value for the calculated limits.
     * @param maxValue Maximum value for the calculated limits.
     */
    public LimitsResponse(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    /**
     * Returns a string representation of the limits.
     *
     * @return A string in the format "Limits[minValue, maxValue]".
     */
    @Override
    public String toString() {
        return "Limits[" + minValue + ", " + maxValue + "]";
    }
}