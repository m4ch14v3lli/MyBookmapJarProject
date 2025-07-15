package velox.api.layer1.data;

import java.util.List;

public abstract class AbstractSimpleOrderSendParametersBuilder<T extends AbstractSimpleOrderSendParametersBuilder<T>> 
        extends AbstractSingleOrderSendParametersBuilder<T> {

    protected List<BracketTier> additionalStopLossTiers;
    protected List<BracketTier> additionalTakeProfitTiers;
    protected boolean closingPositionHint;
    protected boolean doNotIncrease;
    protected double limitPrice;
    protected boolean reversingPositionHint;
    protected String stopLossClientId;
    protected int stopLossOffset;
    protected int stopLossTrailingStep;
    protected double stopPrice;
    protected String takeProfitClientId;
    protected int takeProfitOffset;
    protected int trailingStep;

    public abstract SimpleOrderSendParameters build();

    public List<BracketTier> getAdditionalStopLossTiers() {
        return additionalStopLossTiers;
    }

    public T setAdditionalStopLossTiers(List<BracketTier> additionalStopLossTiers) {
        this.additionalStopLossTiers = additionalStopLossTiers;
        return (T) this;
    }

    public List<BracketTier> getAdditionalTakeProfitTiers() {
        return additionalTakeProfitTiers;
    }

    public T setAdditionalTakeProfitTiers(List<BracketTier> additionalTakeProfitTiers) {
        this.additionalTakeProfitTiers = additionalTakeProfitTiers;
        return (T) this;
    }

    public double getLimitPrice() {
        return limitPrice;
    }

    public T setLimitPrice(double limitPrice) {
        this.limitPrice = limitPrice;
        return (T) this;
    }

    public double getStopPrice() {
        return stopPrice;
    }

    public T setStopPrice(double stopPrice) {
        this.stopPrice = stopPrice;
        return (T) this;
    }

    public int getTakeProfitOffset() {
        return takeProfitOffset;
    }

    public T setTakeProfitOffset(int takeProfitOffset) {
        this.takeProfitOffset = takeProfitOffset;
        return (T) this;
    }

    public int getStopLossOffset() {
        return stopLossOffset;
    }

    public T setStopLossOffset(int stopLossOffset) {
        this.stopLossOffset = stopLossOffset;
        return (T) this;
    }

    public int getStopLossTrailingStep() {
        return stopLossTrailingStep;
    }

    public T setStopLossTrailingStep(int stopLossTrailingStep) {
        this.stopLossTrailingStep = stopLossTrailingStep;
        return (T) this;
    }

    public String getStopLossClientId() {
        return stopLossClientId;
    }

    public T setStopLossClientId(String stopLossClientId) {
        this.stopLossClientId = stopLossClientId;
        return (T) this;
    }

    public String getTakeProfitClientId() {
        return takeProfitClientId;
    }

    public T setTakeProfitClientId(String takeProfitClientId) {
        this.takeProfitClientId = takeProfitClientId;
        return (T) this;
    }

    public int getTrailingStep() {
        return trailingStep;
    }

    public T setTrailingStep(int trailingStep) {
        this.trailingStep = trailingStep;
        return (T) this;
    }

    public boolean isClosingPositionHint() {
        return closingPositionHint;
    }

    public T setClosingPositionHint(boolean closingPositionHint) {
        this.closingPositionHint = closingPositionHint;
        return (T) this;
    }

    public boolean isDoNotIncrease() {
        return doNotIncrease;
    }

    public T setDoNotIncrease(boolean doNotIncrease) {
        this.doNotIncrease = doNotIncrease;
        return (T) this;
    }

    public boolean isReversingPositionHint() {
        return reversingPositionHint;
    }

    public T setReversingPositionHint(boolean reversingPositionHint) {
        this.reversingPositionHint = reversingPositionHint;
        return (T) this;
    }

    @Override
    public String toString() {
        return "AbstractSimpleOrderSendParametersBuilder{" +
                "additionalStopLossTiers=" + additionalStopLossTiers +
                ", additionalTakeProfitTiers=" + additionalTakeProfitTiers +
                ", limitPrice=" + limitPrice +
                ", stopPrice=" + stopPrice +
                ", stopLossClientId='" + stopLossClientId + '\'' +
                ", takeProfitClientId='" + takeProfitClientId + '\'' +
                '}';
    }
}