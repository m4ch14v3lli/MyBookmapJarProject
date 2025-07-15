package velox.api.layer1;

import java.lang.AutoCloseable;
import velox.api.layer1.data.LoginData;
import velox.api.layer1.data.SubscribeInfo;
import velox.api.layer1.data.OrderSendParameters;
import velox.api.layer1.data.OrderUpdateParameters;

/**
 * Extends all possible Layer1 provider aspect interfaces. This is what layer1
 * provider should implement
 * 
 * @version 7.6.0
 */
public interface Layer1ApiProvider extends 
    Layer1ApiInstrumentProvider,
    Layer1ApiDataProvider,
    Layer1ApiTradingProvider,
    Layer1ApiAdminProvider,
    LayerApiListenable {

    // All methods are inherited from the extended interfaces:
    
    // From Layer1ApiAdminListenable
    void addListener(Layer1ApiAdminListener listener);
    void removeListener(Layer1ApiAdminListener listener);
    
    // From Layer1ApiAdminProvider
    void close() throws Exception;
    long getCurrentTime();
    String getSource();
    String getSupportedFeatures();
    void login(LoginData loginData);
    void sendUserMessage(Object message);
    
    // From Layer1ApiDataListenable
    void addListener(Layer1ApiDataListener listener);
    void removeListener(Layer1ApiDataListener listener);
    
    // From Layer1ApiDataProvider
    String formatPrice(String instrument, double price);
    
    // From Layer1ApiInstrumentListenable
    void addListener(Layer1ApiInstrumentListener listener);
    void removeListener(Layer1ApiInstrumentListener listener);
    
    // From Layer1ApiInstrumentProvider
    void subscribe(String exchange, String instrument, String type);
    void subscribe(SubscribeInfo subscribeInfo);
    void unsubscribe(String instrument);
    
    // From Layer1ApiMboDataListenable
    void addListener(Layer1ApiMboDataListener listener);
    void removeListener(Layer1ApiMboDataListener listener);
    
    // From Layer1ApiTradingListenable
    void addListener(Layer1ApiTradingListener listener);
    void removeListener(Layer1ApiTradingListener listener);
    
    // From Layer1ApiTradingProvider
    void sendOrder(OrderSendParameters parameters);
    void updateOrder(OrderUpdateParameters parameters);
}