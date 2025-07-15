package velox.api.layer1.messages.indicators;

/**
 * Interface LimitsCalculator for calculating display limits for indicators.
 */
public interface LimitsCalculator {
    
    /**
     * Calculates desired display limits for an indicator with given minimum and maximum values.
     *
     * @param minValue Minimum value for the indicator range, can be Double.NaN if no data is present.
     * @param maxValue Maximum value for the indicator range, can be Double.NaN if no data is present.
     * @return LimitsResponse containing the calculated limits for the indicator.
     */
    LimitsResponse getLimits(double minValue, double maxValue);
}

/**
 * Class LimitsResponse to represent the limits calculated for the indicator.
 */
public class LimitsResponse {
    // Fields to store the calculated limits can be added here.
    private double lowerLimit;
    private double upperLimit;

    public LimitsResponse(double lowerLimit, double upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public double getLowerLimit() {
        return lowerLimit;
    }

    public double getUpperLimit() {
        return upperLimit;
    }
}

/**
 * Abstract class AbstractLimitsCalculator providing base functionality for limit calculations.
 */
public abstract class AbstractLimitsCalculator implements LimitsCalculator {
    // Common functionalities or fields can be added here.
}