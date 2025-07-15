package velox.api.layer1.messages.indicators;

public class Layer1ApiUserMessageModifyIndicator implements Layer1ApiStrategiesEchoMessagesLayer.StrategyEchoMessageFromLayer {

    public final AliasFilter aliasFilter;
    public final BoundsInfo boundsInfo;
    public final Layer1IndicatorColorInterface colorInterface;
    public final java.awt.Color defaultTooltipBackgrondColor;
    public final java.awt.Color defaultTooltipTextColor;
    public final IndicatorDisplayLogic indicatorDisplayLogic;
    public final Double indicatorMinMarginPriceOut;
    public final Double indicatorMaxMarginPriceOut;
    public final Double minLimitsRange;
    public final BoundsInfo boundsInfo;
    public final GraphType graphType;
    public final boolean isSupportWidget;
    public final boolean isShowColorSettings;
    public final boolean isEnableSettingsFromConfigPopup;
    public final OnlineCalculatable onlineCalculatable;
    public final String ownerClassName;
    public final String ownerUserName;
    public final String fullName;
    public final String userName;
    public final int graphLayerRenderPriority;
    public final IndicatorColorScheme indicatorColorScheme;
    public final HorizontalValueLinesInfo horizontalValueLinesInfo;
    public final int iconLayerRenderPriority;

    public Layer1ApiUserMessageModifyIndicator(Class<?> strategyClass, String userName, boolean isAdd, 
            IndicatorColorScheme indicatorColorScheme, Layer1IndicatorColorInterface colorInterface,
            IndicatorLineStyle indicatorLineStyle, java.awt.Color defaultTooltipBackgrondColor,
            java.awt.Color defaultTooltipTextColor, IndicatorDisplayLogic indicatorDisplayLogic,
            Double indicatorMinMarginPriceOut, Double indicatorMaxMarginPriceOut, 
            Double minLimitsRange, BoundsInfo boundsInfo, GraphType graphType, 
            Boolean isSupportWidget, Boolean isShowColorSettings,
            Boolean isEnableSettingsFromConfigPopup, OnlineCalculatable onlineCalculatable, 
            AliasFilter aliasFilter) {
        // Constructor implementation
    }

    public static class Builder {
        private final Layer1ApiUserMessageModifyIndicator message;

        public Builder(Layer1ApiUserMessageModifyIndicator message) {
            this.message = message;
        }

        public Builder setIsAdd(boolean isAdd) {
            // Implementation
            return this;
        }

        public Builder setIndicatorColorScheme(IndicatorColorScheme indicatorColorScheme) {
            // Implementation
            return this;
        }

        public Builder setColorInterface(Layer1IndicatorColorInterface colorInterface) {
            // Implementation
            return this;
        }

        public Builder build() {
            return this;
        }
    }

    public enum GraphType {
        BOTTOM,
        PRIMARY,
        NONE;
    }
}