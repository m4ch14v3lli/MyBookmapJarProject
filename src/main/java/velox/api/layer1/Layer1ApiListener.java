package velox.api.layer1;

/**
 * Interface Layer1ApiListener extends multiple Layer1 interfaces.
 * It is capable of listening to various Layer1 API events.
 */
public interface Layer1ApiListener extends Layer1ApiAdminListener, 
                                           Layer1ApiDataListener, 
                                           Layer1ApiInstrumentListener, 
                                           Layer1ApiMboDataListener, 
                                           Layer1ApiTradingListener {

    // Inherited methods from Layer1ApiAdminListener
    void onConnectionLost(DisconnectionReason reason, String message);
    void onConnectionRestored();
    void onLoginFailed(LoginFailedReason reason, String message);
    void onLoginSuccessful();
    void onSystemTextMessage(String message, SystemTextMessageType type);
    void onUserMessage(Object message);

    // Inherited methods from Layer1ApiDataListener
    void onDepth(String alias, boolean isBid, int price, int size);
    void onMarketMode(String alias, MarketMode marketMode);
    void onTrade(String alias, double price, int size, TradeInfo tradeInfo);

    // Inherited methods from Layer1ApiInstrumentListener
    void onInstrumentAdded(String alias, InstrumentInfo instrumentInfo);
    void onInstrumentAlreadySubscribed(String symbol, String exchange, String type);
    void onInstrumentNotFound(String symbol, String exchange, String type);
    void onInstrumentRemoved(String alias);

    // Inherited methods from Layer1ApiMboDataListener
    void onMboCancel(String symbol, String exchange);
    void onMboReplace(String symbol, String exchange, int price, int size);
    void onMboSend(String symbol, String exchange, boolean isBid, int price, int size);

    // Inherited methods from Layer1ApiTradingListener
    void onBalance(BalanceInfo balanceInfo);
    void onOrderExecuted(ExecutionInfo executionInfo);
    void onOrderUpdated(OrderInfoUpdate orderInfoUpdate);
    void onStatus(StatusInfo statusInfo);
}