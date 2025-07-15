package velox.api.layer1.data;

public class SimpleOrderSendParametersBuilder extends AbstractSimpleOrderSendParametersBuilder<SimpleOrderSendParametersBuilder> {
    
    public SimpleOrderSendParametersBuilder(String alias, boolean isBuy, int size) {
        super(alias, isBuy, size);
    }

    public SimpleOrderSendParametersBuilder(String alias, boolean isBuy, int size, 
                                             OrderDuration duration, String clientId, 
                                             double limitPrice, double stopPrice, 
                                             int takeProfitOffset, int stopLossOffset, 
                                             int stopLossTrailingStep, int trailingStep, 
                                             boolean doNotIncrease) {
        super(alias, isBuy, size, duration, clientId, limitPrice, stopPrice, 
              takeProfitOffset, stopLossOffset, stopLossTrailingStep, trailingStep, doNotIncrease);
    }

    public SimpleOrderSendParametersBuilder(String alias, boolean isBuy, int size, 
                                             OrderDuration duration, String clientId, 
                                             double limitPrice, double stopPrice, 
                                             int takeProfitOffset, int stopLossOffset, 
                                             int stopLossTrailingStep, int trailingStep, 
                                             boolean doNotIncrease, boolean reversingPositionHint, 
                                             boolean closingPositionHint) {
        super(alias, isBuy, size, duration, clientId, limitPrice, stopPrice, 
              takeProfitOffset, stopLossOffset, stopLossTrailingStep, trailingStep, 
              doNotIncrease, reversingPositionHint, closingPositionHint);
    }

    @Override
    public SimpleOrderSendParameters build() {
        return new SimpleOrderSendParameters(
                alias, isBuy, size, duration, 
                clientId, limitPrice, stopPrice, 
                takeProfitOffset, stopLossOffset, 
                stopLossTrailingStep, trailingStep, 
                doNotIncrease, additionalStopLossTiers, 
                additionalTakeProfitTiers, closingPositionHint, 
                reversingPositionHint);
    }
}