package velox.api.layer1.layers;

public class Layer1ApiDepthFreezer {

    public static class DepthFreezeRequest {
        public final String alias;
        public final boolean freeze;
        public final long freezeEndTime;

        public DepthFreezeRequest(String alias, boolean freeze) {
            this.alias = alias;
            this.freeze = freeze;
            this.freezeEndTime = Long.MAX_VALUE; // Default to no expiration
        }

        public DepthFreezeRequest(String alias, boolean freeze, long freezeEndTime) {
            this.alias = alias;
            this.freeze = freeze;
            this.freezeEndTime = freezeEndTime;
        }

        public String getAlias() {
            return alias;
        }

        public boolean isFreeze() {
            return freeze;
        }

        public long getFreezeEndTime() {
            return freezeEndTime;
        }
    }
}