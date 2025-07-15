package velox.api.layer1.data;

public class SingleOrderSendParameters implements MultiAccountAware, OrderSendParameters {
    public final String accountId;
    public final String alias;
    public final String clientId;
    public final OrderDuration duration;
    public final boolean isBuy;
    public final int size;

    public SingleOrderSendParameters(String alias, boolean isBuy, int size, OrderDuration duration, String clientId) {
        this.accountId = null; // To be set if multi-account support is available
        this.alias = alias;
        this.clientId = clientId;
        this.duration = duration;
        this.isBuy = isBuy;
        this.size = size;
    }

    @Override
    public String getTradingAccountId() {
        return accountId; // Return the account ID
    }

    @Override
    public String toString() {
        return "SingleOrderSendParameters{" +
                "accountId='" + accountId + '\'' +
                ", alias='" + alias + '\'' +
                ", clientId='" + clientId + '\'' +
                ", duration=" + duration +
                ", isBuy=" + isBuy +
                ", size=" + size +
                '}';
    }
}