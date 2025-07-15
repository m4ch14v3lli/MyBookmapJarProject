package velox.api.layer1.layers.strategies.interfaces;

import java.util.List;

public class OnlineCalculatable {

    public static class ValueBundle {
        public final Object value;
        public final List<Object> additionalObjects;

        public ValueBundle(Object value, List<Object> additionalObjects) {
            this.value = value;
            this.additionalObjects = additionalObjects;
        }

        @Override
        public String toString() {
            return "ValueBundle{" +
                    "value=" + value +
                    ", additionalObjects=" + additionalObjects +
                    '}';
        }
    }
}