package velox.api.layer0.replay;

import velox.api.layer1.*;
import velox.api.layer1.data.*;

import java.util.concurrent.CopyOnWriteArrayList;

public abstract class ExternalReaderBaseProvider implements Layer1ApiProvider {

    public final CopyOnWriteArrayList<Layer1ApiAdminListener>     adminListeners     = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<Layer1ApiInstrumentListener> instrumentListeners = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<Layer1ApiDataListener>      dataListeners      = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<Layer1ApiMboDataListener>   mboDataListeners   = new CopyOnWriteArrayList<>();
    public final CopyOnWriteArrayList<Layer1ApiTradingListener>   tradingListeners   = new CopyOnWriteArrayList<>();

    protected ExternalReaderBaseProvider() {}

    /* --------------------- Listener helpers --------------------- */

    @Override
    public void addListener(Layer1ApiAdminListener listener)        { adminListeners.add(listener); }
    @Override
    public void removeListener(Layer1ApiAdminListener listener)     { adminListeners.remove(listener); }

    @Override
    public void addListener(Layer1ApiInstrumentListener listener)   { instrumentListeners.add(listener); }
    @Override
    public void removeListener(Layer1ApiInstrumentListener listener){ instrumentListeners.remove(listener); }

    @Override
    public void addListener(Layer1ApiDataListener listener)         { dataListeners.add(listener); }
    @Override
    public void removeListener(Layer1ApiDataListener listener)      { dataListeners.remove(listener); }

    @Override
    public void addListener(Layer1ApiMboDataListener listener)      { mboDataListeners.add(listener); }
    @Override
    public void removeListener(Layer1ApiMboDataListener listener)   { mboDataListeners.remove(listener); }

    @Override
    public void addListener(Layer1ApiTradingListener listener)      { tradingListeners.add(listener); }
    @Override
    public void removeListener(Layer1ApiTradingListener listener)   { tradingListeners.remove(listener); }

    /* --------------------- Default no-ops --------------------- */

    @Override
    public void subscribe(SubscribeInfo subscribeInfo) { }

    @Override
    public void unsubscribe(String alias) { }

    @Override
    public String formatPrice(String alias, double price) { return String.valueOf(price); }

    @Override
    public void sendOrder(OrderSendParameters orderSendParameters) { }

    @Override
    public void updateOrder(OrderUpdateParameters orderUpdateParameters) { }

    @Override
    public Layer1ApiProviderSupportedFeatures getSupportedFeatures() { return new Layer1ApiProviderSupportedFeatures(); }

    @Override
    public Object sendUserMessage(Object data) { return null; }
}