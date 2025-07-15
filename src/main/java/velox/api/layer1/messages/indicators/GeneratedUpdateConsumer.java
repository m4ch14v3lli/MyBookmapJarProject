package velox.api.layer1.messages.indicators;

import java.util.function.Consumer;

public interface GeneratedUpdateConsumer {

    void setGeneratedEventsConsumer(Consumer<CustomGeneratedEventAliased> consumer);

    Consumer<CustomGeneratedEventAliased> getGeneratedEventsConsumer();
}