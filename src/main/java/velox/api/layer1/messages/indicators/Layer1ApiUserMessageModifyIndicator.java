package velox.api.layer1.messages.indicators;

import java.util.function.Consumer;

public class Layer1ApiUserMessageModifyIndicator {

    public static final class Builder {
        private final Layer1ApiUserMessageModifyIndicator message;

        public Builder(Layer1ApiUserMessageModifyIndicator message) {
            this.message = message;
        }

        public Builder setIsAdd(boolean isAdd) {
            // Set isAdd flag in the message
            return this;
        }

        public Builder setIndicatorColorScheme(IndicatorColorScheme indicatorColorScheme) {
            // Set color scheme in the message
            return this;
        }

        public Builder setColorInterface(Layer1IndicatorColorInterface colorInterface) {
            // Set color interface in the message
            return this;
        }

        public Builder setIndicatorLineStyle(IndicatorLineStyle indicatorLineStyle) {
            // Set line style in the message
            return this;
        }

        public Builder setDefaultTooltipBackgrondColor(java.awt.Color defaultTooltipBackgrondColor) {
            // Set tooltip background color in the message
            return this;
        }

        public Builder setDefaultTooltipTextColor(java.awt.Color defaultTooltipTextColor) {
            // Set tooltip text color in the message
            return this;
        }

        public Builder setIndicatorDisplayLogic(IndicatorDisplayLogic indicatorDisplayLogic) {
            // Set display logic in the message
            return this;
        }

        public Builder setIndicatorMinMarginPriceOut(Double indicatorMinMarginPriceOut) {
            // Set minimum margin price out in the message
            return this;
        }

        public Builder setIndicatorMaxMarginPriceOut(Double indicatorMaxMarginPriceOut) {
            // Set maximum margin price out in the message
            return this;
        }

        public Builder setMinLimitsRange(Double minLimitsRange) {
            // Set minimum limits range in the message
            return this;
        }

        public Builder setBoundsInfo(BoundsInfo boundsInfo) {
            // Set bounds info in the message
            return this;
        }

        public Builder setGraphType(Layer1ApiUserMessageModifyIndicator.GraphType graphType) {
            // Set graph type in the message
            return this;
        }

        public Builder setIsSupportWidget(boolean isSupportWidget) {
            // Set support for widget in the message
            return this;
        }

        public Builder setIsShowColorSettings(boolean isShowColorSettings) {
            // Set color settings visibility in the message
            return this;
        }

        public Builder setIsEnableSettingsFromConfigPopup(boolean isEnableSettingsFromConfigPopup) {
            // Enable settings from config popup
            return this;
        }

        public Builder setOnlineCalculatable(OnlineCalculatable onlineCalculatable) {
            // Set online calculatable in the message
            return this;
        }

        public Builder setAliasFiler(AliasFilter aliasFilter) {
            // Set alias filter in the message
            return this;
        }

        public Builder setWidgetDisplayInfo(WidgetDisplayInfo widgetDisplayInfo) {
            // Set widget display info in the message
            return this;
        }

        public Builder setIsLineEnabledByDefault(boolean isLineEnabledByDefault) {
            // Set default line visibility in the message
            return this;
        }

        public Builder setIsWidgetEnabledByDefault(boolean isWidgetEnabledByDefault) {
            // Set default widget visibility in the message
            return this;
        }

        public Builder setIndicatorContextMenuInformation(IndicatorContextMenuInformation indicatorContextMenuInformation) {
            // Set context menu information in the message
            return this;
        }

        public Builder setHorizontalValueLinesInfo(HorizontalValueLinesInfo horizontalValueLinesInfo) {
            // Set horizontal value lines info in the message
            return this;
        }

        public Layer1ApiUserMessageModifyIndicator build() {
            return this.message;
        }

        public Builder extendFullName(String suffix) {
            // Extend full name with suffix
            return this;
        }

        public Builder setGraphLayerRenderPriority(int graphLayerRenderPriority) {
            // Set graph layer render priority
            return this;
        }

        public Builder setGraphLayerRenderPriority(LayerRenderPriority graphLayerRenderPriority) {
            // Set graph layer render priority using enum
            return this;
        }

        public Builder setIconLayerRanderPriotity(int iconLayerRanderPriotity) {
            // Set icon layer render priority
            return this;
        }

        public Builder setIconLayerRanderPriotity(LayerRenderPriority iconLayerRanderPriotity) {
            // Set icon layer render priority using enum
            return this;
        }

        public Builder setIndicatorColorScheme(IndicatorColorScheme indicatorColorScheme) {
            // Set indicator color scheme
            return this;
        }
    }
}