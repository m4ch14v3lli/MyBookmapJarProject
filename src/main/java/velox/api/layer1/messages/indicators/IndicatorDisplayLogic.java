package velox.api.layer1.messages.indicators;

public class IndicatorDisplayLogic {

    public LimitsCalculator limitsCalculator;
    public ValuesFormatter valuesFormatter;

    public IndicatorDisplayLogic() {
        // Default constructor
    }

    public IndicatorDisplayLogic setLimitsCalculator(LimitsCalculator limitsCalculator) {
        this.limitsCalculator = limitsCalculator;
        return this;
    }

    public IndicatorDisplayLogic setValuesFormatter(ValuesFormatter valuesFormatter) {
        this.valuesFormatter = valuesFormatter;
        return this;
    }
}