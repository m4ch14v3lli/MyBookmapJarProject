package velox.api.layer1.data;

public class StatusInfo implements MultiAccountAware {
    public final String accountId;
    public final String instrumentAlias;
    public final double unrealizedPnl;
    public final double realizedPnl;
    public final String currency;
    public final int position;
    public final double averagePrice;
    public final int volume;
    public final int workingBuys;
    public final int workingSells;
    public final boolean isDuplicate;

    public StatusInfo(String instrumentAlias, double unrealizedPnl, double realizedPnl,
                      String currency, int position, double averagePrice,
                      int volume, int workingBuys, int workingSells, boolean isDuplicate) {
        this.accountId = null; // To be set if multi-account support is available
        this.instrumentAlias = instrumentAlias;
        this.unrealizedPnl = unrealizedPnl;
        this.realizedPnl = realizedPnl;
        this.currency = currency;
        this.position = position;
        this.averagePrice = averagePrice;
        this.volume = volume;
        this.workingBuys = workingBuys;
        this.workingSells = workingSells;
        this.isDuplicate = isDuplicate;
    }

    @Override
    public String getTradingAccountId() {
        return accountId;
    }

    public StatusInfoBuilder toBuilder() {
        return new StatusInfoBuilder()
                .setInstrumentAlias(instrumentAlias)
                .setUnrealizedPnl(unrealizedPnl)
                .setRealizedPnl(realizedPnl)
                .setCurrency(currency)
                .setPosition(position)
                .setAveragePrice(averagePrice)
                .setVolume(volume)
                .setWorkingBuys(workingBuys)
                .setWorkingSells(workingSells)
                .setDuplicate(isDuplicate);
    }

    @Override
    public String toString() {
        return "StatusInfo{" +
                "accountId='" + accountId + '\'' +
                ", instrumentAlias='" + instrumentAlias + '\'' +
                ", unrealizedPnl=" + unrealizedPnl +
                ", realizedPnl=" + realizedPnl +
                ", currency='" + currency + '\'' +
                ", position=" + position +
                ", averagePrice=" + averagePrice +
                ", volume=" + volume +
                ", workingBuys=" + workingBuys +
                ", workingSells=" + workingSells +
                ", isDuplicate=" + isDuplicate +
                '}';
    }
}