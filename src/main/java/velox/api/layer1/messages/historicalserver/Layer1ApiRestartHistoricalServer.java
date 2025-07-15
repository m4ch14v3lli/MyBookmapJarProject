package velox.api.layer1.messages.historicalserver;

public class Layer1ApiRestartHistoricalServer {

    private long waitBeforeRestartMs;

    public Layer1ApiRestartHistoricalServer() {
        this.waitBeforeRestartMs = 0; // Default wait time
    }

    public Layer1ApiRestartHistoricalServer(long waitBeforeRestartMs) {
        this.waitBeforeRestartMs = waitBeforeRestartMs;
    }

    public long getWaitBeforeRestartMs() {
        return waitBeforeRestartMs;
    }
}