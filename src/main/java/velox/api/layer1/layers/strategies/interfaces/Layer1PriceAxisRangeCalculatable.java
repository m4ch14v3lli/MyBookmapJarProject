package velox.api.layer1.layers.strategies.interfaces;

import java.util.Map;

public interface Layer1PriceAxisRangeCalculatable {

    Map<String, ResultPriceAxisInfo> getPriceRanges(String alias, double linesCount, 
        Map<String, InputPriceAxisInfo> inputInfo);
    
    class InputPriceAxisInfo {
        // Define fields and methods for InputPriceAxisInfo as needed
    }

    class ResultPriceAxisInfo {
        // Define fields and methods for ResultPriceAxisInfo as needed
    }
}