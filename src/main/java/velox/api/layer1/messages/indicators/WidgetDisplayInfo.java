package velox.api.layer1.messages.indicators;

/**
 * Class WidgetDisplayInfo defines how a widget displays values.
 * It allows for a symmetric display centered around a specified value.
 */
public class WidgetDisplayInfo {

    public final double centerValue;
    public final Type type;

    /**
     * Constructor for WidgetDisplayInfo.
     *
     * @param type        the type of widget display
     * @param centerValue the center value for symmetric displays
     */
    public WidgetDisplayInfo(Type type, double centerValue) {
        this.type = type;
        this.centerValue = centerValue;
    }

    /**
     * Enum representing display types for the widget.
     */
    public enum Type {
        SYMMETRIC,
        ASYMMETRIC
    }
}