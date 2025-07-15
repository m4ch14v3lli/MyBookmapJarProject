package velox.api.layer1;

import java.lang.AutoCloseable;
import velox.api.layer1.data.Layer1ApiProviderSupportedFeatures;
import velox.api.layer1.data.LoginData;

/**
 * Class implementing this should provide general Layer1 Api functions.
 * 
 * This interface extends AutoCloseable for proper resource management and 
 * Layer1ApiAdminListenable for event handling capabilities.
 */
public interface Layer1ApiAdminProvider extends AutoCloseable, Layer1ApiAdminListenable {

    /**
     * Get information about features that are supported by a provider. Note that
     * some fields might be set differently depending on when request is made. E.g.
     * adapter might not know if trading will be there until login actually happens.
     * 
     * If you are writing a provider - take a look at MaximumSupportedFeatures as a way 
     * to declare full list of capabilities before being instantiated
     * 
     * @return object describing supported features
     * @see velox.api.layer1.annotations.MaximumSupportedFeatures
     */
    Layer1ApiProviderSupportedFeatures getSupportedFeatures();

    /**
     * Initiate login to the platform.
     * 
     * @param loginData credentials, different platforms use different subclasses
     */
    void login(LoginData loginData);

    /**
     * Returns current Unix epoch time. This method allows time distortions if
     * consumer is too slow - in this case time of the next event may be
     * returned.
     * 
     * @return current Unix epoch time in nanoseconds
     */
    long getCurrentTime();

    /**
     * Returns string representing data source.
     * 
     * @return string representing data source
     */
    String getSource();

    /**
     * Send a downstream event. Allows incorporating arbitrary functionality into protocol
     * 
     * @param data Message content
     * @return response object (implementation specific)
     */
    Object sendUserMessage(Object data);

    /**
     * Shut down and dispose. For details on the provider lifecycle, check out the
     * javadoc of ExternalLiveBaseProvider and ExternalReaderBaseProvider for Live 
     * and Replay external modules respectively.
     * 
     * Overrides AutoCloseable.close() to provide proper resource cleanup.
     */
    @Override
    void close();
}

// Related interface that this extends would be in separate file:
// velox/api/layer1/Layer1ApiAdminListenable.java

// Data classes referenced in the interface would be in separate files:
// velox/api/layer1/data/LoginData.java
// velox/api/layer1/data/Layer1ApiProviderSupportedFeatures.java

// Known implementing classes (from the documentation):
// - velox.api.layer0.live.ExternalLiveBaseProvider
// - velox.api.layer0.replay.ExternalReaderBaseProvider  
// - velox.api.layer1.layers.Layer1ApiDepthFreezer
// - velox.api.layer1.layers.Layer1ApiInjectorRelay
// - velox.api.layer1.layers.Layer1ApiRelay
// - velox.api.layer1.layers.Layer1ApiStrategiesEchoMessagesLayer

// Known subinterfaces:
// - velox.api.layer1.Layer1ApiProvider