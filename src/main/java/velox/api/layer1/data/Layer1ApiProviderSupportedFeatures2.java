package velox.api.layer1.data;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Layer1ApiProviderSupportedFeatures {

    public final boolean trading;
    public final boolean multiAccountTrading;
    public final boolean oco;
    public final boolean oso;
    public final boolean depth;
    public final boolean mbo;
    public final boolean trailingStopsAsIndependentOrders;
    public final boolean trailingStopsAsBracketChildren;
    public final boolean brackets;
    public final boolean bracketTiers;
    public final boolean convertOrderToMkt;
    public final boolean isBalanceSupported;
    public final boolean isDelayed;
    public final boolean isTradingSubscriptionSupported;
    public final boolean isHistoricalAggregationDisabled;
    public final boolean marketMode;
    public final boolean negativeStopLimitOffset;
    public final boolean tradingStartKnown;
    public final boolean exchangeUsedForSubscription;
    public final boolean typeUsedForSubscription;
    
    public final Set<ClientSideFeature> clientSideFeatures;
    public final List<SubscribeInfo> knownInstruments;
    public final HistoricalDataInfo historicalDataInfo;
    public final LookupInfo lookupInfo;

    // Functions
    public final Function<SubscribeInfo, DefaultAndList<Double>> pipsFunction;
    public final Function<SubscribeInfo, DefaultAndList<Double>> sizeMultiplierFunction;
    public final Function<SubscribeInfo, String> subscriptionInfoFunction;
    public final Function<Set<InstrumentCoreInfo>, SymbolMappingInfo> symbolsMappingFunction;

    public Layer1ApiProviderSupportedFeatures(boolean trading, boolean multiAccountTrading, boolean oco, 
                                              boolean oso, boolean depth, boolean mbo, 
                                              boolean trailingStopsAsIndependentOrders, 
                                              boolean trailingStopsAsBracketChildren, boolean brackets, 
                                              boolean bracketTiers, boolean convertOrderToMkt, 
                                              boolean isBalanceSupported, boolean isDelayed, 
                                              boolean isTradingSubscriptionSupported, 
                                              boolean isHistoricalAggregationDisabled, boolean marketMode, 
                                              boolean negativeStopLimitOffset, boolean tradingStartKnown, 
                                              boolean exchangeUsedForSubscription, boolean typeUsedForSubscription, 
                                              Set<ClientSideFeature> clientSideFeatures, 
                                              List<SubscribeInfo> knownInstruments, 
                                              HistoricalDataInfo historicalDataInfo, 
                                              LookupInfo lookupInfo, 
                                              Function<SubscribeInfo, DefaultAndList<Double>> pipsFunction, 
                                              Function<SubscribeInfo, DefaultAndList<Double>> sizeMultiplierFunction, 
                                              Function<SubscribeInfo, String> subscriptionInfoFunction, 
                                              Function<Set<InstrumentCoreInfo>, SymbolMappingInfo> symbolsMappingFunction) {
        this.trading = trading;
        this.multiAccountTrading = multiAccountTrading;
        this.oco = oco;
        this.oso = oso;
        this.depth = depth;
        this.mbo = mbo;
        this.trailingStopsAsIndependentOrders = trailingStopsAsIndependentOrders;
        this.trailingStopsAsBracketChildren = trailingStopsAsBracketChildren;
        this.brackets = brackets;
        this.bracketTiers = bracketTiers;
        this.convertOrderToMkt = convertOrderToMkt;
        this.isBalanceSupported = isBalanceSupported;
        this.isDelayed = isDelayed;
        this.isTradingSubscriptionSupported = isTradingSubscriptionSupported;
        this.isHistoricalAggregationDisabled = isHistoricalAggregationDisabled;
        this.marketMode = marketMode;
        this.negativeStopLimitOffset = negativeStopLimitOffset;
        this.tradingStartKnown = tradingStartKnown;
        this.exchangeUsedForSubscription = exchangeUsedForSubscription;
        this.typeUsedForSubscription = typeUsedForSubscription;
        this.clientSideFeatures = clientSideFeatures;
        this.knownInstruments = knownInstruments;
        this.historicalDataInfo = historicalDataInfo;
        this.lookupInfo = lookupInfo;
        this.pipsFunction = pipsFunction;
        this.sizeMultiplierFunction = sizeMultiplierFunction;
        this.subscriptionInfoFunction = subscriptionInfoFunction;
        this.symbolsMappingFunction = symbolsMappingFunction;
    }

    public Layer1ApiProviderSupportedFeatures getCopyWithAppliedTradingParams(Layer1ApiProviderSupportedFeatures other) {
        // Implementation for copying trading parameters from another instance
        return new Layer1ApiProviderSupportedFeatures(
            this.trading, this.multiAccountTrading, this.oco, this.oso,
            this.depth, this.mbo, this.trailingStopsAsIndependentOrders,
            this.trailingStopsAsBracketChildren, this.brackets, this.bracketTiers,
            this.convertOrderToMkt, this.isBalanceSupported, this.isDelayed,
            this.isTradingSubscriptionSupported, this.isHistoricalAggregationDisabled,
            this.marketMode, this.negativeStopLimitOffset, this.tradingStartKnown,
            this.exchangeUsedForSubscription, this.typeUsedForSubscription,
            this.clientSideFeatures, this.knownInstruments, this.historicalDataInfo,
            this.lookupInfo, this.pipsFunction, this.sizeMultiplierFunction,
            this.subscriptionInfoFunction, this.symbolsMappingFunction
        );
    }

    public Layer1ApiProviderSupportedFeaturesBuilder toBuilder() {
        return new Layer1ApiProviderSupportedFeaturesBuilder(this);
    }

    @Override
    public String toString() {
        return "Layer1ApiProviderSupportedFeatures{" +
                "trading=" + trading +
                ", multiAccountTrading=" + multiAccountTrading +
                ", oco=" + oco +
                ", oso=" + oso +
                ", depth=" + depth +
                ", mbo=" + mbo +
                ", trailingStopsAsIndependentOrders=" + trailingStopsAsIndependentOrders +
                ", trailingStopsAsBracketChildren=" + trailingStopsAsBracketChildren +
                ", brackets=" + brackets +
                ", bracketTiers=" + bracketTiers +
                ", convertOrderToMkt=" + convertOrderToMkt +
                ", isBalanceSupported=" + isBalanceSupported +
                ", isDelayed=" + isDelayed +
                ", isTradingSubscriptionSupported=" + isTradingSubscriptionSupported +
                ", isHistoricalAggregationDisabled=" + isHistoricalAggregationDisabled +
                ", marketMode=" + marketMode +
                ", negativeStopLimitOffset=" + negativeStopLimitOffset +
                ", tradingStartKnown=" + tradingStartKnown +
                ", exchangeUsedForSubscription=" + exchangeUsedForSubscription +
                ", typeUsedForSubscription=" + typeUsedForSubscription +
                ", clientSideFeatures=" + clientSideFeatures +
                ", knownInstruments=" + knownInstruments +
                ", historicalDataInfo=" + historicalDataInfo +
                ", lookupInfo=" + lookupInfo +
                '}';
    }

    public static enum ClientSideFeature {
        BRACKETS,
        OCO,
        OSO,
        TRAILING_STOPS_AS_BRACKET_CHILDREN,
        TRAILING_STOPS_AS_INDEPENDENT;

        // Additional methods if necessary
    }
}