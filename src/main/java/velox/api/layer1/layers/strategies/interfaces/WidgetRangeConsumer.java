package velox.api.layer1.layers.strategies.interfaces;

public interface WidgetRangeConsumer {
    boolean isWidgetVisible();

    void setForcedMaxValue(Double forcedMaxValue);

    void setForcedMinValue(Double forcedMinValue);

    void setWidgetDisplayInfo(WidgetDisplayInfo widgetDisplayInfo);

    void setWidgetVisible(boolean isWidgetVisible);
}