package velox.api.layer1.data;

import java.util.function.Function;

public class PerInstrumentHistoricalDataInfo implements HistoricalDataInfo {
    public final Function<SubscribeInfo, HistoricalDataInfo> instrumentToHistoricalDataInfo;

    public PerInstrumentHistoricalDataInfo(Function<SubscribeInfo, HistoricalDataInfo> instrumentToHistoricalDataInfo) {
        this.instrumentToHistoricalDataInfo = instrumentToHistoricalDataInfo;
    }

    @Override
    public String toString() {
        return "PerInstrumentHistoricalDataInfo{" +
                "instrumentToHistoricalDataInfo=" + instrumentToHistoricalDataInfo +
                '}';
    }
}