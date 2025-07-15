package velox.api.layer1.data;

public class StatusInfoBuilder {
    private String instrumentAlias;
    private double unrealizedPnl;
    private double realizedPnl;
    private String currency;
    private int position;
    private double averagePrice;
    private int volume;
    private int workingBuys;
    private int workingSells;
    private boolean isDuplicate;
    private String accountId;

    public StatusInfoBuilder() {
    }

    public StatusInfoBuilder(StatusInfoBuilder other) {
        this.instrumentAlias = other.instrumentAlias;
        this.unrealizedPnl = other.unrealizedPnl;
        this.realizedPnl = other.realizedPnl;
        this.currency = other.currency;
        this.position = other.position;
        this.averagePrice = other.averagePrice;
        this.volume = other.volume;
        this.workingBuys = other.workingBuys;
        this.workingSells = other.workingSells;
        this.isDuplicate = other.isDuplicate;
        this.accountId = other.accountId;
    }

    public StatusInfoBuilder setInstrumentAlias(String instrumentAlias) {
        this.instrumentAlias = instrumentAlias;
        return this;
    }

    public StatusInfoBuilder setUnrealizedPnl(double unrealizedPnl) {
        this.unrealizedPnl = unrealizedPnl;
        return this;
    }

    public StatusInfoBuilder setRealizedPnl(double realizedPnl) {
        this.realizedPnl = realizedPnl;
        return this;
    }

    public StatusInfoBuilder setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public StatusInfoBuilder setPosition(int position) {
        this.position = position;
        return this;
    }

    public StatusInfoBuilder setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
        return this;
    }

    public StatusInfoBuilder setVolume(int volume) {
        this.volume = volume;
        return this;
    }

    public StatusInfoBuilder setWorkingBuys(int workingBuys) {
        this.workingBuys = workingBuys;
        return this;
    }

    public StatusInfoBuilder setWorkingSells(int workingSells) {
        this.workingSells = workingSells;
        return this;
    }

    public StatusInfoBuilder setDuplicate(boolean isDuplicate) {
        this.isDuplicate = isDuplicate;
        return this;
    }

    public StatusInfoBuilder setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    public String getAccountId() {
        return accountId;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public String getCurrency() {
        return currency;
    }

    public String getInstrumentAlias() {
        return instrumentAlias;
    }

    public int getPosition() {
        return position;
    }

    public double getRealizedPnl() {
        return realizedPnl;
    }

    public double getUnrealizedPnl() {
        return unrealizedPnl;
    }

    public int getVolume() {
        return volume;
    }

    public int getWorkingBuys() {
        return workingBuys;
    }

    public int getWorkingSells() {
        return workingSells;
    }

    public boolean isDuplicate() {
        return isDuplicate;
    }

    public StatusInfo build() {
        return new StatusInfo(instrumentAlias, unrealizedPnl, realizedPnl, currency, 
                               position, averagePrice, volume, workingBuys, 
                               workingSells, isDuplicate);
    }
}