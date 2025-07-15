package velox.api.layer1.data;

public class LookupSubscribeInfo extends SubscribeInfo {
    
    public final String description;
    public final boolean enabled;

    public LookupSubscribeInfo(String symbol, String exchange, String type, String description) {
        super(symbol, exchange, type);
        this.description = description;
        this.enabled = true; // Default to enabled
    }

    public LookupSubscribeInfo(String symbol, String exchange, String type, String description, boolean enabled) {
        super(symbol, exchange, type);
        this.description = description;
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEnabled() {
        return enabled;
    }
}