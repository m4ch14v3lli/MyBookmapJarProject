package velox.api.layer1.messages.indicators;

import velox.api.layer1.layers.strategies.interfaces.ScreenSpacePainterFactory;

/**
 * Describes adding or removing a screen-space painter.
 * <p>
 * <b>Important:</b> {@link #fullName} is a unique indicator name used to address
 * this indicator from any external part.  Do <b>not</b> change it directly.
 * Use {@link #applyNameModifier(String)} if you need different full names
 * for the same user name.
 */
public class Layer1ApiUserMessageModifyScreenSpacePainter
        implements velox.api.layer1.layers.Layer1ApiStrategiesEchoMessagesLayer.StrategyEchoMessageFromLayer {

    /* ==========  Public, final fields  ========== */

    /** Name of owner strategy class. */
    public final String ownerClassName;

    /** User-friendly name of owner strategy class (if provided via
     * {@code @Layer1StrategyName}). */
    public final String ownerUserName;

    /** Unique indicator name; do NOT mutate directly. */
    public String fullName;

    /** Name visible to the user (e.g., in bottom-panel context menu). */
    public final String userName;

    /** true = add painter, false = remove painter. */
    public final boolean isAdd;

    /** Factory for the painter to be added/removed. */
    public final ScreenSpacePainterFactory screenSpacePainterFactory;

    /** Optional alias filter for the painter. */
    public final AliasFilter aliasFilter;

    /* ==========  Constructor (package-private)  ========== */

    /** Only the nested Builder should instantiate this class. */
    Layer1ApiUserMessageModifyScreenSpacePainter(Builder b) {
        this.ownerClassName   = b.ownerClassName;
        this.ownerUserName    = b.ownerUserName;
        this.userName         = b.userName;
        this.isAdd            = b.isAdd;
        this.screenSpacePainterFactory = b.screenSpacePainterFactory;
        this.aliasFilter      = b.aliasFilter;
        this.fullName         = predictFullName(b.strategyClass, b.userName);
    }

    /* ==========  Public API  ========== */

    /** Applies an optional name modifier to {@link #fullName}. */
    public void applyNameModifier(String modifier) {
        this.fullName = predictFullName(ownerClassName, userName) + "_" + modifier;
    }

    /** Returns a debug-friendly string. */
    @Override
    public String toString() {
        return "Layer1ApiUserMessageModifyScreenSpacePainter{"
                + "fullName='" + fullName + '\''
                + ", userName='" + userName + '\''
                + ", isAdd=" + isAdd
                + '}';
    }

    /* ==========  Static helpers  ========== */

    /**
     * Creates a new Builder.
     */
    public static Builder builder(Class<?> strategyClass, String userName) {
        return new Builder(strategyClass, userName);
    }

    /**
     * Predicts the default full name.  <b>Not guaranteed</b> to match the
     * actual indicator name; do <b>not</b> use for strategy identification.
     */
    public static String predictFullName(Class<?> myClass, String myName) {
        return predictFullName(myClass.getName(), myName);
    }

    private static String predictFullName(String className, String userName) {
        return className + "::" + userName;
    }

    /* ==========  Nested Builder  ========== */

    /** Fluent builder for {@code Layer1ApiUserMessageModifyScreenSpacePainter}. */
    public static final class Builder {
        private final Class<?> strategyClass;
        private final String   userName;

        private String ownerClassName;
        private String ownerUserName;
        private boolean isAdd;
        private ScreenSpacePainterFactory screenSpacePainterFactory;
        private AliasFilter aliasFilter;

        private Builder(Class<?> strategyClass, String userName) {
            this.strategyClass = strategyClass;
            this.userName      = userName;
            this.ownerClassName = strategyClass.getName();
        }

        public Builder ownerUserName(String val) {
            this.ownerUserName = val;
            return this;
        }

        public Builder isAdd(boolean val) {
            this.isAdd = val;
            return this;
        }

        public Builder screenSpacePainterFactory(ScreenSpacePainterFactory val) {
            this.screenSpacePainterFactory = val;
            return this;
        }

        public Builder aliasFilter(AliasFilter val) {
            this.aliasFilter = val;
            return this;
        }

        public Layer1ApiUserMessageModifyScreenSpacePainter build() {
            return new Layer1ApiUserMessageModifyScreenSpacePainter(this);
        }
    }
}