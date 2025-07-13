package velox.api.layer1.simplified.demo;

import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;
import velox.api.layer1.data.OrderSendParameters;
import velox.api.layer1.data.OrderUpdateParameters;

public class Layer1ApiProvider extends Layer1ApiAdminProvider {
    // ... keep as-is
}

// No longer public
abstract class Layer1ApiAdminProvider implements AutoCloseable {
    // ...
}

class Layer1ApiDataProvider {
    // ...
}

class Layer1ApiInstrumentProvider {
    // ...
}

class Layer1ApiTradingProvider {
    // ...
}

class LayerApiListenable {
    // ...
}

abstract class Layer1ApiAdminListener {
    // ...
}

abstract class Layer1ApiDataListener {
    // ...
}

abstract class Layer1ApiInstrumentListener {
    // ...
}

abstract class Layer1ApiTradingListener {
    // ...
}

abstract class Layer1ApiMboDataListener {
    // ...
}

class LoginData {
    // ...
}

class SubscribeInfo {
    // ...
}

class OrderSendParameters {
    // ...
}

class OrderUpdateParameters {
    // ...
}
