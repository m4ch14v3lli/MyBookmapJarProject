package velox.api.layer1.messages.indicators;

/**
 * Interface ValuesFormatter provides custom formatting for indicator tooltips and widget values.
 */
public interface ValuesFormatter {

    /**
     * Formats the tooltip value.
     *
     * @param value      the value to be displayed in the tooltip
     * @param minValue   the minimum value for the tooltip range
     * @param maxValue   the maximum value for the tooltip range
     * @param pixelsCount the height of the bottom panel
     * @return a formatted string for the tooltip, or null if the default formatter should be used
     */
    String formatTooltip(double value, double minValue, double maxValue, int pixelsCount);

    /**
     * Formats the tooltip value with an alias.
     *
     * @param alias      the alias of the instrument
     * @param value      the value to be displayed in the tooltip
     * @param minValue   the minimum value for the tooltip range
     * @param maxValue   the maximum value for the tooltip range
     * @param pixelsCount the height of the bottom panel
     * @return a formatted string for the tooltip, or null if the default formatter should be used
     */
    default String formatTooltip(String alias, double value, double minValue, double maxValue, int pixelsCount) {
        return formatTooltip(value, minValue, maxValue, pixelsCount);
    }

    /**
     * Formats the widget value.
     *
     * @param value the value to be displayed in the widget
     * @return a formatted string for the widget, or null if the default formatter should be used
     */
    String formatWidget(double value);

    /**
     * Formats the widget value with an alias.
     *
     * @param alias the alias of the instrument
     * @param value the value to be displayed in the widget
     * @return a formatted string for the widget, or null if the default formatter should be used
     */
    default String formatWidget(String alias, double value) {
        return formatWidget(value);
    }
}