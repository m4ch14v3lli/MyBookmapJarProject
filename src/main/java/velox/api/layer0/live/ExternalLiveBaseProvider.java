package velox.api.layer0.live;

import velox.api.layer1.*;
import velox.api.layer1.data.*;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Base implementation for a live market-data / trading connector.
 *
 * Lifecycle:
 * 1. Zero-arg ctor called.
 * 2. Listeners added via addListener*(..).
 * 3. login(..) invoked with LoginData (UserPasswordDemoLoginData or ExtendedLoginData).
 * 4. Provider connects asynchronously:
 *      -> onLoginSuccessful()   if OK
 *      -> onLoginFailed(..)     if bad credentials / network failure
 * 5. subscribe / unsubscribe / sendOrder / updateOrder may arrive at any time.
 * 6. close() invoked when user disconnects; provider must stop callbacks and free resources.
 *
 * All callbacks are asynchronous; timestamp = call-time.
 */
public abstract class ExternalLiveBaseProvider implements Layer1ApiProvider {

    /* --------------------  Listener holders -------------------- */

    public final CopyOnWriteArrayList<Layer1ApiAdminListener>    adminListeners    = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<Layer1ApiInstrumentListener> instrumentListeners = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<Layer1ApiDataListener>     dataListeners     = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<Layer1ApiMboDataListener>  mboDataListeners  = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<Layer1ApiTradingListener>  tradingListeners  = new CopyOnWriteArrayList<>();

    /* --------------------  Listener registration -------------------- */

    public final void addListener(Layer1ApiAdminListener l)    { adminListeners.addIfAbsent(l); }
    public final void addListener(Layer1ApiInstrumentListener l) { instrumentListeners.addIfAbsent(l); }
    public final void addListener(Layer1ApiDataListener l)     { dataListeners.addIfAbsent(l); }
    public final void addListener(Layer1ApiMboDataListener l)  { mboDataListeners.addIfAbsent(l); }
    public final void addListener(Layer1ApiTradingListener l)  { tradingListeners.addIfAbsent(l); }

    public final void removeListener(Layer1ApiAdminListener l)    { adminListeners.remove(l); }
    public final void removeListener(Layer1ApiInstrumentListener l) { instrumentListeners.remove(l); }
    public final void removeListener(Layer1ApiDataListener l)     { dataListeners.remove(l); }
    public final void removeListener(Layer1ApiMboDataListener l)  { mboDataListeners.remove(l); }
    public final void removeListener(Layer1ApiTradingListener l)  { tradingListeners.remove(l); }

    /* --------------------  Utility / default helpers -------------------- */

    protected String formatPriceDefault(double pips, double price) {
        // Older Bookmap fallback; newer versions may delegate to PriceFormatHelper
        return Double.toString(price);
    }

    /**
     * Override if you support trading.
     * Default: no trading, no account info, etc.
     */
    public Layer1ApiProviderSupportedFeatures getSupportedFeatures() {
        return new Layer1ApiProviderSupportedFeatures();
    }

    /**
     * Not invoked for external providers.
     */
    public final long getCurrentTime() {
        throw new UnsupportedOperationException("External providers provide their own timestamps");
    }

    /**
     * Optional user message channel. Default: ignore.
     */
    public Object sendUserMessage(Object data) {
        return null;
    }

    /* --------------------  Abstract provider contract  -------------------- */

    // Below are the *only* methods that MUST be implemented by the concrete provider
    // (they are declared in the interfaces we extend).

    /* Layer1ApiAdminProvider */
    public abstract void login(LoginData loginData) throws Exception;
    public abstract void close();

    /* Layer1ApiInstrumentProvider */
    public abstract void subscribe(String alias, String exchange, String symbol);
    public abstract void unsubscribe(String alias);

    /* Layer1ApiDataProvider */
    // Optional override for custom price formatting:
    // public String formatPrice(String alias, double price) { ... }

    /* Layer1ApiTradingProvider (only if getSupportedFeatures().isTradingSupported == true) */
    // public void sendOrder(OrderSendParameters params)   { ... }
    // public void updateOrder(OrderUpdateParameters params) { ... }
}