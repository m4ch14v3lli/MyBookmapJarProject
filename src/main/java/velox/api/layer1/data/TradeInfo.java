package velox.api.layer1.data;

public class TradeInfo {
    public final String aggressorOrderId;
    public final boolean isBidAggressor;
    public final boolean isExecutionEnd;
    public final boolean isExecutionStart;
    public final boolean isOtc;
    public final String passiveOrderId;
    public final int position;

    public TradeInfo(boolean isOtc, boolean isBidAggressor, boolean isExecutionStart, boolean isExecutionEnd) {
        this.isOtc = isOtc;
        this.isBidAggressor = isBidAggressor;
        this.isExecutionStart = isExecutionStart;
        this.isExecutionEnd = isExecutionEnd;
        this.aggressorOrderId = null;
        this.passiveOrderId = null;
        this.position = 0;
    }

    public TradeInfo(boolean isOtc, boolean isBidAggressor, boolean isExecutionStart, boolean isExecutionEnd, String aggressorOrderId, String passiveOrderId) {
        this.isOtc = isOtc;
        this.isBidAggressor = isBidAggressor;
        this.isExecutionStart = isExecutionStart;
        this.isExecutionEnd = isExecutionEnd;
        this.aggressorOrderId = aggressorOrderId;
        this.passiveOrderId = passiveOrderId;
        this.position = 0;
    }

    public TradeInfo(boolean isOtc, boolean isBidAggressor, boolean isExecutionStart, boolean isExecutionEnd, String aggressorOrderId, String passiveOrderId, int position) {
        this.isOtc = isOtc;
        this.isBidAggressor = isBidAggressor;
        this.isExecutionStart = isExecutionStart;
        this.isExecutionEnd = isExecutionEnd;
        this.aggressorOrderId = aggressorOrderId;
        this.passiveOrderId = passiveOrderId;
        this.position = position;
    }

    @Override
    public String toString() {
        return "TradeInfo{" +
                "aggressorOrderId='" + aggressorOrderId + '\'' +
                ", isBidAggressor=" + isBidAggressor +
                ", isExecutionEnd=" + isExecutionEnd +
                ", isExecutionStart=" + isExecutionStart +
                ", isOtc=" + isOtc +
                ", passiveOrderId='" + passiveOrderId + '\'' +
                ", position=" + position +
                '}';
    }
}