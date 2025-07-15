package velox.api.layer1.layers.strategies.interfaces;

import java.io.Serializable;

public class CustomGeneratedEventAliased implements Serializable {
    public final CustomGeneratedEvent event;
    public final String alias;

    public CustomGeneratedEventAliased(CustomGeneratedEvent event, String alias) {
        this.event = event;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return "CustomGeneratedEventAliased{" +
                "event=" + event +
                ", alias='" + alias + '\'' +
                '}';
    }
}