package velox.api.layer1.messages.indicators;

public class Layer1ApiUserMessageModifyScreenSpacePainter {

    public static final class Builder {
        private final Layer1ApiUserMessageModifyScreenSpacePainter message;

        public Builder(Layer1ApiUserMessageModifyScreenSpacePainter message) {
            this.message = message;
        }

        public Builder setOwnerClassName(String ownerClassName) {
            // Set owner class name in the message
            return this;
        }

        public Builder setOwnerUserName(String ownerUserName) {
            // Set owner user name in the message
            return this;
        }

        public Builder setFullName(String fullName) {
            // Set full name in the message
            return this;
        }

        public Builder setUserName(String userName) {
            // Set user name in the message
            return this;
        }

        public Builder setIsAdd(boolean isAdd) {
            // Set isAdd flag in the message
            return this;
        }

        public Builder setScreenSpacePainterFactory(ScreenSpacePainterFactory screenSpacePainterFactory) {
            // Set screen space painter factory in the message
            return this;
        }

        public Builder setAliasFilter(AliasFilter aliasFilter) {
            // Set alias filter in the message
            return this;
        }

        public Layer1ApiUserMessageModifyScreenSpacePainter build() {
            return this.message;
        }
    }
}