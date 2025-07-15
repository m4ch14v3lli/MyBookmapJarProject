package velox.api.layer1.data;

import java.util.Set;
import java.util.function.Function;

public class SymbolMappingInfo {
    public final Set<InstrumentCoreInfo> alternatives;
    public final Set<InstrumentCoreInfo> crossTradingTo;
    public final double multiplier;
    public final Function<Double, Double> pipsSupplier;

    public SymbolMappingInfo(Set<InstrumentCoreInfo> alternatives, 
                             Set<InstrumentCoreInfo> crossTradingTo, 
                             double multiplier, 
                             Function<Double, Double> pipsSupplier) {
        this.alternatives = alternatives;
        this.crossTradingTo = crossTradingTo;
        this.multiplier = multiplier;
        this.pipsSupplier = pipsSupplier;
    }
}