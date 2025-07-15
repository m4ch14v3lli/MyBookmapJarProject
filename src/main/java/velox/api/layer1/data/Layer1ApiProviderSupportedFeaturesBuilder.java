package velox.api.layer1.data;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class Layer1ApiProviderSupportedFeaturesBuilder {

    private boolean exchangeUsedForSubscription;
    private HistoricalDataInfo historicalDataInfo;
    private List<SubscribeInfo> knownInstruments;
    private LookupInfo lookupInfo;
    private Function<SubscribeInfo, DefaultAndList<Double>> pipsFunction;
    private Function<SubscribeInfo, DefaultAndList<Double>> sizeMultiplierFunction;
    private Function<SubscribeInfo, String> subscriptionInfoFunction;
    private Set<ClientSideFeature> clientSideFeatures;
    private boolean tradingStartKnown;
    private boolean typeUsedForSubscription;

    // Constructor
    public Layer1ApiProviderSupportedFeaturesBuilder() {
        // Creates a new instance with all features marked as unsupported
    }

    public Layer1ApiProviderSupportedFeatures build() {
        // Implement logic to build the Layer1ApiProviderSupportedFeatures object
        return new Layer1ApiProviderSupportedFeatures(
            exchangeUsedForSubscription,
            historicalDataInfo,
            knownInstruments,
            lookupInfo,
            pipsFunction,
            sizeMultiplierFunction,
            subscriptionInfoFunction,
            clientSideFeatures,
            tradingStartKnown,
            typeUsedForSubscription
        );
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setExchangeUsedForSubscription(boolean value) {
        this.exchangeUsedForSubscription = value;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setHistoricalDataInfo(HistoricalDataInfo dataInfo) {
        this.historicalDataInfo = dataInfo;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setKnownInstruments(List<SubscribeInfo> instruments) {
        this.knownInstruments = instruments;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setLookupInfo(LookupInfo info) {
        this.lookupInfo = info;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setPipsFunction(Function<SubscribeInfo, DefaultAndList<Double>> function) {
        this.pipsFunction = function;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setSizeMultiplierFunction(Function<SubscribeInfo, DefaultAndList<Double>> function) {
        this.sizeMultiplierFunction = function;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setSubscriptionInfoFunction(Function<SubscribeInfo, String> function) {
        this.subscriptionInfoFunction = function;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setClientSideFeatures(Set<ClientSideFeature> features) {
        this.clientSideFeatures = features;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setTradingStartKnown(boolean value) {
        this.tradingStartKnown = value;
        return this;
    }

    public Layer1ApiProviderSupportedFeaturesBuilder setTypeUsedForSubscription(boolean value) {
        this.typeUsedForSubscription = value;
        return this;
    }

    public boolean isExchangeUsedForSubscription() {
        return exchangeUsedForSubscription;
    }

    public HistoricalDataInfo getHistoricalDataInfo() {
        return historicalDataInfo;
    }

    public List<SubscribeInfo> getKnownInstruments() {
        return knownInstruments;
    }

    public LookupInfo getLookupInfo() {
        return lookupInfo;
    }

    public Function<SubscribeInfo, DefaultAndList<Double>> getPipsFunction() {
        return pipsFunction;
    }

    public Function<SubscribeInfo, DefaultAndList<Double>> getSizeMultiplierFunction() {
        return sizeMultiplierFunction;
    }

    public Function<SubscribeInfo, String> getSubscriptionInfoFunction() {
        return subscriptionInfoFunction;
    }

    public Set<ClientSideFeature> getClientSideFeatures() {
        return clientSideFeatures;
    }

    public boolean isTradingStartKnown() {
        return tradingStartKnown;
    }

    public boolean isTypeUsedForSubscription() {
        return typeUsedForSubscription;
    }
}