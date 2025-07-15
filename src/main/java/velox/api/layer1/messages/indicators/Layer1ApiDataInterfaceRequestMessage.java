package velox.api.layer1.messages.indicators;

import java.util.function.Consumer;

public class Layer1ApiDataInterfaceRequestMessage implements Layer1ApiStrategiesEchoMessagesLayer.StrategyEchoMessageFromLayer {

    public final Consumer<DataStructureInterface> consumer;

    public Layer1ApiDataInterfaceRequestMessage(Consumer<DataStructureInterface> consumer) {
        this.consumer = consumer;
    }
}