package velox.api.layer1.layers.strategies.interfaces;

import java.util.function.Function;

public interface OnlineCalculatable {

    interface DataCoordinateMarker {
        
        double getMinY();
        
        double getMaxY();
        
        double getValueY();
        
        Marker makeMarker(Function<Double, Integer> yDataCoordinateToPixelFunction);
    }

    interface Marker {
        // Define relevant methods for Marker if needed
    }
}