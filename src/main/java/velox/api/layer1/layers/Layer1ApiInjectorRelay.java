package velox.api.layer1.layers;

public class Layer1ApiInjectorRelay extends Layer1ApiRelay {

    protected final Object upstreamInjectorLock;

    public Layer1ApiInjectorRelay(Layer1ApiProvider provider) {
        super(provider);
        this.upstreamInjectorLock = new Object();
    }

    protected void inject(Runnable r) {
        // Inject runnable into messages stream provider -> GUI. Event is handled asynchronously.
    }

    protected void injectSynchronously(Runnable r) {
        // Inject runnable into messages stream provider -> GUI from the same thread.
    }

    public void close() {
        // Stop relaying data. Will not let send new events upwards but is not guaranteed to stop ones already in progress.
    }

    public void onDepth(String alias, boolean isBid, int price, int size) {
        // Depth data update.
    }

    public void onUserMessage(Object data) {
        // Send an upstream event.
    }

    public void onInstrumentAdded(String alias, InstrumentInfo instrumentInfo) {
        // Indicates successful subscription to the instrument.
    }

    public void onInstrumentRemoved(String alias) {
        // Unsubscribed from instrument.
    }

    public void onInstrumentNotFound(String symbol, String exchange, String type) {
        // Indicates that attempt to subscribe failed because instrument does not exist.
    }

    public void onInstrumentAlreadySubscribed(String symbol, String exchange, String type) {
        // Indicates that attempt to subscribe failed because subscription is already active.
    }

    public void onTrade(String alias, double price, int size, TradeInfo tradeInfo) {
        // Trade event.
    }

    public void onMarketMode(String alias, MarketMode marketMode) {
        // Market mode update.
    }

    public void onBalance(BalanceInfo balanceInfo) {
        // Called when account balance information changes.
    }

    public void onLoginFailed(LoginFailedReason reason, String message) {
        // Failed to login with specified credentials.
    }

    public void onLoginSuccessful() {
        // Successful login.
    }

    public void onConnectionLost(DisconnectionReason reason, String message) {
        // Connection to server lost.
    }

    public void onConnectionRestored() {
        // Connection to server restored.
    }

    public void onSystemTextMessage(String message, SystemTextMessageType messageType) {
        // Passes the message into the system.
    }
}