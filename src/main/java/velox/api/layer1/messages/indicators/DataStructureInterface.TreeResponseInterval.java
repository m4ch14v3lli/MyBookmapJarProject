package velox.api.layer1.messages.indicators;

import java.util.Map;

public class DataStructureInterface {

    public static class TreeResponseInterval {
        public Map<String, Object> events;

        public TreeResponseInterval() {
            // Constructor logic (if needed)
        }
    }

    public enum StandardEvents {
        TRADE,
        DEPTH,
        MBO,
        ORDER
    }
}