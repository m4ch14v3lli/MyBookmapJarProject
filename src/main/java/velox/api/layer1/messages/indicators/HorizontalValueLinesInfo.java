package velox.api.layer1.messages.indicators;

import java.util.Map;

public interface HorizontalValueLinesInfo {

    /**
     * Retrieves horizontal lines for the given alias.
     *
     * @param alias the alias for which lines are drawn
     * @return a mapping from the value of the line to the color of the line
     */
    Map<Double, String> getHorizontalLines(String alias);
}