package velox.api.layer1.data;

public abstract class InstrumentInfo {
    
    public abstract static class BuilderBase<T extends BuilderBase<T>> extends InstrumentCoreInfo.BuilderBase<T> {
        
        protected long dataDelay;
        protected String fullName;
        protected boolean isApiProtected;
        protected boolean isCrypto;
        protected boolean isFullDepth;
        protected boolean isNbboSupported;
        protected double multiplier;
        protected double pips;
        protected String recordingTag;
        protected String requestedSymbol;
        protected double sizeMultiplier;

        public BuilderBase() {
            // Constructor implementation
        }

        public abstract InstrumentInfo build();

        public T setFieldsFrom(InstrumentInfo info) {
            // Implementation
            return (T) this;
        }

        public double getPips() {
            return pips;
        }

        public T setPips(double pips) {
            this.pips = pips;
            return (T) this;
        }

        public double getMultiplier() {
            return multiplier;
        }

        public T setMultiplier(double multiplier) {
            this.multiplier = multiplier;
            return (T) this;
        }

        public String getFullName() {
            return fullName;
        }

        public T setFullName(String fullName) {
            this.fullName = fullName;
            return (T) this;
        }

        public boolean isFullDepth() {
            return isFullDepth;
        }

        public T setFullDepth(boolean fullDepth) {
            this.isFullDepth = fullDepth;
            return (T) this;
        }

        public double getSizeMultiplier() {
            return sizeMultiplier;
        }

        public T setSizeMultiplier(double sizeMultiplier) {
            this.sizeMultiplier = sizeMultiplier;
            return (T) this;
        }

        public boolean isCrypto() {
            return isCrypto;
        }

        public T setCrypto(boolean crypto) {
            this.isCrypto = crypto;
            return (T) this;
        }

        public String getRecordingTag() {
            return recordingTag;
        }

        public T setRecordingTag(String recordingTag) {
            this.recordingTag = recordingTag;
            return (T) this;
        }

        public boolean isApiProtected() {
            return isApiProtected;
        }

        public T setApiProtected(boolean apiProtected) {
            this.isApiProtected = apiProtected;
            return (T) this;
        }

        public T setDataDelay(long dataDelay) {
            this.dataDelay = dataDelay;
            return (T) this;
        }

        public String getRequestedSymbol() {
            return requestedSymbol;
        }

        public T setRequestedSymbol(String requestedSymbol) {
            this.requestedSymbol = requestedSymbol;
            return (T) this;
        }

        public boolean isNbboSupported() {
            return isNbboSupported;
        }

        public T setNbboSupported(boolean nbboSupported) {
            this.isNbboSupported = nbboSupported;
            return (T) this;
        }
    }
}