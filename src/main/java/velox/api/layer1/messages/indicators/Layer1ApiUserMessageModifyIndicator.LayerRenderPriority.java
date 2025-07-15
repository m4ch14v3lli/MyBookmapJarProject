package velox.api.layer1.messages.indicators;

public class Layer1ApiUserMessageModifyIndicator {

    public static enum LayerRenderPriority {
        ABSOLUTE_TOP(1000),
        TOP(1000),
        ABOVE_BBO(500),
        ABSOLUTE_BOTTOM(0);

        public final int priority;

        LayerRenderPriority(int priority) {
            this.priority = priority;
        }

        public static LayerRenderPriority[] values() {
            return new LayerRenderPriority[]{ABSOLUTE_TOP, TOP, ABOVE_BBO, ABSOLUTE_BOTTOM};
        }

        public static LayerRenderPriority valueOf(String name) {
            return Enum.valueOf(LayerRenderPriority.class, name);
        }
    }
}