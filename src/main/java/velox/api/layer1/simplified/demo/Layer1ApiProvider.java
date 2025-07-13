package velox.api.layer1.simplified.demo;

import java.util.Set;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

@Override
public void close() {
    // Add cleanup code if needed
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
