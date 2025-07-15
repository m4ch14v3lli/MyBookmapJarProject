package velox.api.layer1.layers;

import java.util.concurrent.atomic.AtomicBoolean;

public class Layer1ApiUpstreamRelay extends Layer1ApiBasicListenable implements Layer1ApiListener {

    protected AtomicBoolean closed;

    public Layer1ApiUpstreamRelay() {
        this.closed = new AtomicBoolean(false);
    }

    public void onInstrumentAdded(String alias, InstrumentInfo instrumentInfo) {
        // Indicates successful subscription to the instrument
    }

    public void onInstrumentRemoved(String alias) {
        // Unsubscribed from instrument (user-initiated or provider initiated)
    }

    public void onInstrumentNotFound(String symbol, String exchange, String type) {
        // Indicates that attempt to subscribe failed because instrument does not exist
    }

    public void onInstrumentAlreadySubscribed(String symbol, String exchange, String type) {
        // Indicates that attempt to subscribe failed because subscription is already active
    }

    public void onTrade(String alias, double price, int size, TradeInfo tradeInfo) {
        // Trade
    }

    public void onDepth(String alias, boolean isBid, int price, int size) {
        // Depth data update
    }

    public void onMboSend(String alias, String orderId, boolean isBid, int price, int size) {
        // Send MBO data
    }

    public void onMboReplace(String alias, String orderId, int price, int size) {
        // Replace MBO data
    }

    public void onMboCancel(String alias, String orderId) {
        // Cancel MBO data
    }

    public void onMarketMode(String alias, MarketMode marketMode) {
        // Market mode update
    }

    public void onOrderUpdated(OrderInfoUpdate orderInfoUpdate) {
        // Called when order is updated
    }

    public void onOrderExecuted(ExecutionInfo executionInfo) {
        // Called when one of our orders gets executed
    }

    public void onStatus(StatusInfo statusInfo) {
        // Called when instrument status information changes
    }

    public void onBalance(BalanceInfo balanceInfo) {
        // Called when account balance information changes
    }

    public void onLoginFailed(LoginFailedReason reason, String message) {
        // Failed to login with specified credentials
    }

    public void onLoginSuccessful() {
        // Successful login
    }

    public void onConnectionLost(DisconnectionReason reason, String message) {
        // Connection to server lost
    }

    public void onConnectionRestored() {
        // Connection to server restored
    }

    public void onSystemTextMessage(String message, SystemTextMessageType messageType) {
        // Passes the message into the system
    }

    public void onUserMessage(Object data) {
        // Send an upstream event
    }

    public void close() {
        // Stop relaying data
        closed.set(true);
    }
}