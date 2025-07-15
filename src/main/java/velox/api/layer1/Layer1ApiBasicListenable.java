package velox.api.layer1;

import java.util.List;

/**
 * Class Layer1ApiBasicListenable implements LayerApiListenable and provides
 * functionality for managing listeners for various Layer1 API events.
 */
public class Layer1ApiBasicListenable implements LayerApiListenable {

    protected final List<Layer1ApiAdminListener> adminListeners;
    protected final List<Layer1ApiDataListener> dataListeners;
    protected final List<Layer1ApiInstrumentListener> instrumentListeners;
    protected final List<Layer1ApiMboDataListener> mboDataListeners;
    protected final List<Layer1ApiTradingListener> tradingListeners;

    protected Layer1ApiAdminListener theOnlyAdminListener;
    protected Layer1ApiDataListener theOnlyDataListener;
    protected Layer1ApiInstrumentListener theOnlyInstrumentListener;
    protected Layer1ApiMboDataListener theOnlyMboDataListener;
    protected Layer1ApiTradingListener theOnlyTradingListener;

    public Layer1ApiBasicListenable() {
        // Constructor implementation
        this.adminListeners = new ArrayList<>();
        this.dataListeners = new ArrayList<>();
        this.instrumentListeners = new ArrayList<>();
        this.mboDataListeners = new ArrayList<>();
        this.tradingListeners = new ArrayList<>();
    }

    public void addListener(Layer1ApiAdminListener listener) {
        adminListeners.add(listener);
    }

    public void removeListener(Layer1ApiAdminListener listener) {
        adminListeners.remove(listener);
    }

    public void addListener(Layer1ApiDataListener listener) {
        dataListeners.add(listener);
    }

    public void removeListener(Layer1ApiDataListener listener) {
        dataListeners.remove(listener);
    }

    public void addListener(Layer1ApiInstrumentListener listener) {
        instrumentListeners.add(listener);
    }

    public void removeListener(Layer1ApiInstrumentListener listener) {
        instrumentListeners.remove(listener);
    }

    public void addListener(Layer1ApiMboDataListener listener) {
        mboDataListeners.add(listener);
    }

    public void removeListener(Layer1ApiMboDataListener listener) {
        mboDataListeners.remove(listener);
    }

    public void addListener(Layer1ApiTradingListener listener) {
        tradingListeners.add(listener);
    }

    public void removeListener(Layer1ApiTradingListener listener) {
        tradingListeners.remove(listener);
    }

    public int getUniqueListenersCount() {
        return (int) (adminListeners.stream().distinct().count() +
                      dataListeners.stream().distinct().count() +
                      instrumentListeners.stream().distinct().count() +
                      mboDataListeners.stream().distinct().count() +
                      tradingListeners.stream().distinct().count());
    }

    protected void onNoSubscribers() {
        // Implementation for when no subscribers are left
    }

    public Layer1ApiAdminListener getAdminListenerBroadcaster() {
        // Implementation to return admin listener broadcaster
        return theOnlyAdminListener;
    }

    public Layer1ApiDataListener getDataListenerBroadcaster() {
        return theOnlyDataListener;
    }

    public Layer1ApiInstrumentListener getInstrumentListenerBroadcaster() {
        return theOnlyInstrumentListener;
    }

    public Layer1ApiTradingListener getTradingListenerBroadcaster() {
        return theOnlyTradingListener;
    }
}