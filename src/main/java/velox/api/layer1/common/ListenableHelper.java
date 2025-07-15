package velox.api.layer1.common;

import velox.api.layer1.LayerApiListenable;
import velox.api.layer1.Layer1ApiAdminListener;
import velox.api.layer1.Layer1ApiDataListener;
import velox.api.layer1.Layer1ApiInstrumentListener;
import velox.api.layer1.Layer1ApiTradingListener;

/**
 * Utility class for managing Layer1 API listeners.
 * Provides convenience methods for adding and removing listeners from listenable objects.
 */
public class ListenableHelper {

    /**
     * Default constructor.
     */
    public ListenableHelper() {
    }

    /**
     * Subscribe as Layer1ApiAdminListener, Layer1ApiDataListener, 
     * Layer1ApiInstrumentListener, Layer1ApiTradingListener if applicable.
     * 
     * @param listenable the object that supports listeners
     * @param listener the listener object to add
     */
    public static void addListeners(Object listenable, Object listener) {
        if (listenable instanceof LayerApiListenable) {
            addListeners((LayerApiListenable) listenable, listener);
        }
    }

    /**
     * Subscribe as Layer1ApiAdminListener, Layer1ApiDataListener, 
     * Layer1ApiInstrumentListener, Layer1ApiTradingListener if applicable.
     * 
     * @param listenable the LayerApiListenable object
     * @param listener the listener object to add
     */
    public static void addListeners(LayerApiListenable listenable, Object listener) {
        if (listener instanceof Layer1ApiAdminListener) {
            listenable.addLayer1ApiAdminListener((Layer1ApiAdminListener) listener);
        }
        
        if (listener instanceof Layer1ApiDataListener) {
            listenable.addLayer1ApiDataListener((Layer1ApiDataListener) listener);
        }
        
        if (listener instanceof Layer1ApiInstrumentListener) {
            listenable.addLayer1ApiInstrumentListener((Layer1ApiInstrumentListener) listener);
        }
        
        if (listener instanceof Layer1ApiTradingListener) {
            listenable.addLayer1ApiTradingListener((Layer1ApiTradingListener) listener);
        }
    }

    /**
     * Unsubscribe as Layer1ApiAdminListener, Layer1ApiDataListener, 
     * Layer1ApiInstrumentListener, Layer1ApiTradingListener if applicable.
     * 
     * @param listenable the LayerApiListenable object
     * @param listener the listener object to remove
     */
    public static void removeListeners(LayerApiListenable listenable, Object listener) {
        if (listener instanceof Layer1ApiAdminListener) {
            listenable.removeLayer1ApiAdminListener((Layer1ApiAdminListener) listener);
        }
        
        if (listener instanceof Layer1ApiDataListener) {
            listenable.removeLayer1ApiDataListener((Layer1ApiDataListener) listener);
        }
        
        if (listener instanceof Layer1ApiInstrumentListener) {
            listenable.removeLayer1ApiInstrumentListener((Layer1ApiInstrumentListener) listener);
        }
        
        if (listener instanceof Layer1ApiTradingListener) {
            listenable.removeLayer1ApiTradingListener((Layer1ApiTradingListener) listener);
        }
    }
}