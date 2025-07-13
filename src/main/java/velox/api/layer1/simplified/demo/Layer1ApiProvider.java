package velox.api.layer1.simplified.demo;

import java.lang.AutoCloseable;
import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import velox.api.layer1.data.LoginData;
import velox.api.layer1.data.SubscribeInfo;
import velox.api.layer1.data.OrderSendParameters;
import velox.api.layer1.data.OrderUpdateParameters;

/**
 * Main Layer1 API Provider implementation that extends all provider aspect classes.
 * This is the concrete implementation that trading systems should use.
 */
public class Layer1ApiProvider extends Layer1ApiAdminProvider {

    private final Set<Layer1ApiDataListener> dataListeners = new CopyOnWriteArraySet<>();
    private final Set<Layer1ApiInstrumentListener> instrumentListeners = new CopyOnWriteArraySet<>();
    private final Set<Layer1ApiTradingListener> tradingListeners = new CopyOnWriteArraySet<>();
    private final Set<Layer1ApiMboDataListener> mboDataListeners = new CopyOnWriteArraySet<>();

    private String source;
    private Set<String> supportedFeatures;
    private boolean isLoggedIn = false;

    public Layer1ApiProvider() {
        this.source = "DefaultLayer1Provider";
        this.supportedFeatures = new HashSet<>();
        initializeSupportedFeatures();
    }

    public Layer1ApiProvider(String source) {
        this.source = source;
        this.supportedFeatures = new HashSet<>();
        initializeSupportedFeatures();
    }

    private void initializeSupportedFeatures() {
        supportedFeatures.add("MARKET_DATA");
        supportedFeatures.add("TRADING");
        supportedFeatures.add("LEVEL2_DATA");
        supportedFeatures.add("MBO_DATA");
    }

    // Implementation of Layer1ApiDataProvider methods
    public String formatPrice(String alias, double price) {
        // Default price formatting - can be overridden for specific instruments
        return String.format("%.4f", price);
    }

    public void addDataListener(Layer1ApiDataListener listener) {
        if (listener != null) {
            dataListeners.add(listener);
        }
    }

    public void removeDataListener(Layer1ApiDataListener listener) {
        dataListeners.remove(listener);
    }

    // Implementation of Layer1ApiInstrumentProvider methods
    public void subscribe(String alias, String exchange, String symbol) {
        SubscribeInfo subscribeInfo = new SubscribeInfo(alias, exchange, symbol);
        subscribe(subscribeInfo);
    }

    public void subscribe(SubscribeInfo subscribeInfo) {
        if (subscribeInfo == null) {
            throw new IllegalArgumentException("SubscribeInfo cannot be null");
        }

        // Notify all instrument listeners about subscription
        for (Layer1ApiInstrumentListener listener : instrumentListeners) {
            listener.onInstrumentSubscribed(subscribeInfo);
        }
    }

    public void unsubscribe(String alias) {
        if (alias == null || alias.trim().isEmpty()) {
            throw new IllegalArgumentException("Alias cannot be null or empty");
        }

        // Notify all instrument listeners about unsubscription
        for (Layer1ApiInstrumentListener listener : instrumentListeners) {
            listener.onInstrumentUnsubscribed(alias);
        }
    }

    public void addInstrumentListener(Layer1ApiInstrumentListener listener) {
        if (listener != null) {
            instrumentListeners.add(listener);
        }
    }

    public void removeInstrumentListener(Layer1ApiInstrumentListener listener) {
        instrumentListeners.remove(listener);
    }

    // Implementation of Layer1ApiTradingProvider methods
    public void sendOrder(OrderSendParameters parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("OrderSendParameters cannot be null");
        }

        if (!isLoggedIn) {
            throw new IllegalStateException("Must be logged in to send orders");
        }

        // Notify all trading listeners about order sent
        for (Layer1ApiTradingListener listener : tradingListeners) {
            listener.onOrderSent(parameters);
        }
    }

    public void updateOrder(OrderUpdateParameters parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("OrderUpdateParameters cannot be null");
        }

        if (!isLoggedIn) {
            throw new IllegalStateException("Must be logged in to update orders");
        }

        // Notify all trading listeners about order update
        for (Layer1ApiTradingListener listener : tradingListeners) {
            listener.onOrderUpdated(parameters);
        }
    }

    public void addTradingListener(Layer1ApiTradingListener listener) {
        if (listener != null) {
            tradingListeners.add(listener);
        }
    }

    public void removeTradingListener(Layer1ApiTradingListener listener) {
        tradingListeners.remove(listener);
    }

    // Implementation of LayerApiListenable methods
    public void addMboDataListener(Layer1ApiMboDataListener listener) {
        if (listener != null) {
            mboDataListeners.add(listener);
        }
    }

    public void removeMboDataListener(Layer1ApiMboDataListener listener) {
        mboDataListeners.remove(listener);
    }

    // Override inherited methods from Layer1ApiAdminProvider
    @Override
    public void login(LoginData loginData) {
        super.login(loginData);
        this.isLoggedIn = true;
    }

    @Override
    public String getSource() {
        return this.source;
    }

    @Override
    public Set<String> getSupportedFeatures() {
        return new HashSet<>(supportedFeatures);
    }

    // Helper methods for subclasses
    protected void notifyDataListeners(String eventType, Object data) {
        for (Layer1ApiDataListener listener : dataListeners) {
            listener.onDataEvent(eventType, data);
        }
    }

    protected void notifyMboDataListeners(String alias, Object mboData) {
        for (Layer1ApiMboDataListener listener : mboDataListeners) {
            listener.onMboDataReceived(alias, mboData);
        }
    }

    protected boolean isLoggedIn() {
        return isLoggedIn;
    }

    protected void addSupportedFeature(String feature) {
        supportedFeatures.add(feature);
    }

    protected void removeSupportedFeature(String feature) {
        supportedFeatures.remove(feature);
    }
}

/**
 * Base admin provider class with common administrative functionality
 */
public abstract class Layer1ApiAdminProvider implements AutoCloseable {

    private final Set<Layer1ApiAdminListener> adminListeners = new CopyOnWriteArraySet<>();
    private volatile boolean isClosed = false;

    @Override
    public void close() throws Exception {
        if (!isClosed) {
            isClosed = true;
            // Notify all admin listeners about closure
            for (Layer1ApiAdminListener listener : adminListeners) {
                listener.onProviderClosed();
            }
            adminListeners.clear();
        }
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public abstract String getSource();

    public abstract Set<String> getSupportedFeatures();

    public void login(LoginData loginData) {
        if (loginData == null) {
            throw new IllegalArgumentException("LoginData cannot be null");
        }

        // Notify all admin listeners about login
        for (Layer1ApiAdminListener listener : adminListeners) {
            listener.onLoginSuccessful(loginData);
        }
    }

    public void sendUserMessage(Object message) {
        if (message == null) {
            return;
        }

        // Notify all admin listeners about user message
        for (Layer1ApiAdminListener listener : adminListeners) {
            listener.onUserMessage(message);
        }
    }

    public void addAdminListener(Layer1ApiAdminListener listener) {
        if (listener != null) {
            adminListeners.add(listener);
        }
    }

    public void removeAdminListener(Layer1ApiAdminListener listener) {
        adminListeners.remove(listener);
    }

    protected boolean isClosed() {
        return isClosed;
    }
}

/**
 * Data provider class with market data functionality
 */
public class Layer1ApiDataProvider {
    private final Set<Layer1ApiDataListener> dataListeners = new CopyOnWriteArraySet<>();

    public String formatPrice(String alias, double price) {
        return String.format("%.4f", price);
    }

    public void addDataListener(Layer1ApiDataListener listener) {
        if (listener != null) {
            dataListeners.add(listener);
        }
    }

    public void removeDataListener(Layer1ApiDataListener listener) {
        dataListeners.remove(listener);
    }

    protected void notifyDataListeners(String eventType, Object data) {
        for (Layer1ApiDataListener listener : dataListeners) {
            listener.onDataEvent(eventType, data);
        }
    }
}

/**
 * Instrument provider class with subscription management functionality
 */
public class Layer1ApiInstrumentProvider {
    private final Set<Layer1ApiInstrumentListener> instrumentListeners = new CopyOnWriteArraySet<>();

    public void subscribe(String alias, String exchange, String symbol) {
        SubscribeInfo subscribeInfo = new SubscribeInfo(alias, exchange, symbol);
        subscribe(subscribeInfo);
    }

    public void subscribe(SubscribeInfo subscribeInfo) {
        if (subscribeInfo == null) {
            throw new IllegalArgumentException("SubscribeInfo cannot be null");
        }

        for (Layer1ApiInstrumentListener listener : instrumentListeners) {
            listener.onInstrumentSubscribed(subscribeInfo);
        }
    }

    public void unsubscribe(String alias) {
        if (alias == null || alias.trim().isEmpty()) {
            throw new IllegalArgumentException("Alias cannot be null or empty");
        }

        for (Layer1ApiInstrumentListener listener : instrumentListeners) {
            listener.onInstrumentUnsubscribed(alias);
        }
    }

    public void addInstrumentListener(Layer1ApiInstrumentListener listener) {
        if (listener != null) {
            instrumentListeners.add(listener);
        }
    }

    public void removeInstrumentListener(Layer1ApiInstrumentListener listener) {
        instrumentListeners.remove(listener);
    }
}

/**
 * Trading provider class with order management functionality
 */
public class Layer1ApiTradingProvider {
    private final Set<Layer1ApiTradingListener> tradingListeners = new CopyOnWriteArraySet<>();

    public void sendOrder(OrderSendParameters parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("OrderSendParameters cannot be null");
        }

        for (Layer1ApiTradingListener listener : tradingListeners) {
            listener.onOrderSent(parameters);
        }
    }

    public void updateOrder(OrderUpdateParameters parameters) {
        if (parameters == null) {
            throw new IllegalArgumentException("OrderUpdateParameters cannot be null");
        }

        for (Layer1ApiTradingListener listener : tradingListeners) {
            listener.onOrderUpdated(parameters);
        }
    }

    public void addTradingListener(Layer1ApiTradingListener listener) {
        if (listener != null) {
            tradingListeners.add(listener);
        }
    }

    public void removeTradingListener(Layer1ApiTradingListener listener) {
        tradingListeners.remove(listener);
    }
}

/**
 * Layer API listenable class for MBO data functionality
 */
public class LayerApiListenable {
    private final Set<Layer1ApiMboDataListener> mboDataListeners = new CopyOnWriteArraySet<>();

    public void addMboDataListener(Layer1ApiMboDataListener listener) {
        if (listener != null) {
            mboDataListeners.add(listener);
        }
    }

    public void removeMboDataListener(Layer1ApiMboDataListener listener) {
        mboDataListeners.remove(listener);
    }

    protected void notifyMboDataListeners(String alias, Object mboData) {
        for (Layer1ApiMboDataListener listener : mboDataListeners) {
            listener.onMboDataReceived(alias, mboData);
        }
    }
}

/**
 * Admin listener class for handling administrative events
 */
public abstract class Layer1ApiAdminListener {
    public abstract void onLoginSuccessful(LoginData loginData);
    public abstract void onProviderClosed();
    public abstract void onUserMessage(Object message);
    public abstract void onError(String errorMessage, Exception cause);
}

/**
 * Data listener class for handling market data events
 */
public abstract class Layer1ApiDataListener {
    public abstract void onDataEvent(String eventType, Object data);
    public abstract void onPriceUpdate(String alias, double price, long timestamp);
    public abstract void onVolumeUpdate(String alias, long volume, long timestamp);
}

/**
 * Instrument listener class for handling instrument events
 */
public abstract class Layer1ApiInstrumentListener {
    public abstract void onInstrumentSubscribed(SubscribeInfo subscribeInfo);
    public abstract void onInstrumentUnsubscribed(String alias);
    public abstract void onInstrumentStatus(String alias, String status);
}

/**
 * Trading listener class for handling trading events
 */
public abstract class Layer1ApiTradingListener {
    public abstract void onOrderSent(OrderSendParameters parameters);
    public abstract void onOrderUpdated(OrderUpdateParameters parameters);
    public abstract void onOrderFilled(String orderId, double fillPrice, long fillQuantity);
    public abstract void onOrderRejected(String orderId, String reason);
}

/**
 * MBO data listener class for handling Market By Order data events
 */
public abstract class Layer1ApiMboDataListener {
    public abstract void onMboDataReceived(String alias, Object mboData);
    public abstract void onOrderBookUpdate(String alias, Object orderBook);
}

/**
 * Login data class for authentication
 */
public class LoginData {
    private String username;
    private String password;
    private String server;
    private String apiKey;
    private long timestamp;

    public LoginData() {}

    public LoginData(String username, String password, String server) {
        this.username = username;
        this.password = password;
        this.server = server;
        this.timestamp = System.currentTimeMillis();
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getServer() { return server; }
    public void setServer(String server) { this.server = server; }

    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}

/**
 * Subscribe info class for instrument subscription
 */
public class SubscribeInfo {
    private String alias;
    private String exchange;
    private String symbol;
    private String dataType;
    private boolean isActive;

    public SubscribeInfo() {}

    public SubscribeInfo(String alias, String exchange, String symbol) {
        this.alias = alias;
        this.exchange = exchange;
        this.symbol = symbol;
        this.dataType = "MARKET_DATA";
        this.isActive = true;
    }

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }

    public String getExchange() { return exchange; }
    public void setExchange(String exchange) { this.exchange = exchange; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getDataType() { return dataType; }
    public void setDataType(String dataType) { this.dataType = dataType; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}

/**
 * Order send parameters class for order placement
 */
public class OrderSendParameters {
    private String orderId;
    private String instrument;
    private String side; // BUY/SELL
    private double quantity;
    private double price;
    private String orderType; // MARKET, LIMIT, STOP, etc.
    private long timestamp;
    private String clientOrderId;

    public OrderSendParameters() {
        this.timestamp = System.currentTimeMillis();
    }

    public OrderSendParameters(String instrument, String side, double quantity, double price, String orderType) {
        this.instrument = instrument;
        this.side = side;
        this.quantity = quantity;
        this.price = price;
        this.orderType = orderType;
        this.timestamp = System.currentTimeMillis();
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getInstrument() { return instrument; }
    public void setInstrument(String instrument) { this.instrument = instrument; }

    public String getSide() { return side; }
    public void setSide(String side) { this.side = side; }

    public double getQuantity() { return quantity; }
    public void setQuantity(double quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getOrderType() { return orderType; }
    public void setOrderType(String orderType) { this.orderType = orderType; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

    public String getClientOrderId() { return clientOrderId; }
    public void setClientOrderId(String clientOrderId) { this.clientOrderId = clientOrderId; }
}

/**
 * Order update parameters class for order modification
 */
public class OrderUpdateParameters {
    private String orderId;
    private String clientOrderId;
    private Double newPrice;
    private Double newQuantity;
    private String newOrderType;
    private long timestamp;

    public OrderUpdateParameters() {
        this.timestamp = System.currentTimeMillis();
    }

    public OrderUpdateParameters(String orderId) {
        this.orderId = orderId;
        this.timestamp = System.currentTimeMillis();
    }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getClientOrderId() { return clientOrderId; }
    public void setClientOrderId(String clientOrderId) { this.clientOrderId = clientOrderId; }

    public Double getNewPrice() { return newPrice; }
    public void setNewPrice(Double newPrice) { this.newPrice = newPrice; }

    public Double getNewQuantity() { return newQuantity; }
    public void setNewQuantity(Double newQuantity) { this.newQuantity = newQuantity; }

    public String getNewOrderType() { return newOrderType; }
    public void setNewOrderType(String newOrderType) { this.newOrderType = newOrderType; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}