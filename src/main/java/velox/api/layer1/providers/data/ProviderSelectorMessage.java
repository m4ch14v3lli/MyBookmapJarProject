package velox.api.layer1.providers.data;

/**
 * Class ProviderSelectorMessage specifies that the next action relates to a specific provider.
 */
public class ProviderSelectorMessage {

    public final velox.api.layer1.data.ProviderType sourceProviderType;

    /**
     * Constructor for ProviderSelectorMessage.
     *
     * @param sourceProviderType the provider type associated with this message
     */
    public ProviderSelectorMessage(velox.api.layer1.data.ProviderType sourceProviderType) {
        this.sourceProviderType = sourceProviderType;
    }

    /**
     * Creates a provider selector message of a specific type.
     *
     * @param providerType the provider type
     * @return a reusable ProviderSelectorMessage instance for the given type
     */
    public static ProviderSelectorMessage createProviderSelectorMessage(velox.api.layer1.data.ProviderType providerType) {
        // Logic to return a reusable ProviderSelectorMessage instance
        return new ProviderSelectorMessage(providerType);
    }

    /**
     * Returns the unique string representation of the provider that caused an event.
     *
     * @return the provider's programmatic name, or null if the underlying provider is null
     */
    public String getProviderProgrammaticName() {
        return sourceProviderType != null ? sourceProviderType.toString() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProviderSelectorMessage)) return false;
        ProviderSelectorMessage that = (ProviderSelectorMessage) o;
        return sourceProviderType.equals(that.sourceProviderType);
    }

    @Override
    public int hashCode() {
        return sourceProviderType.hashCode();
    }
}