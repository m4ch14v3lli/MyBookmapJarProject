package velox.api.layer1.data;

/**
 * Builder pattern implementation for AccountInfo
 */
public class AccountInfoBuilder {
    
    private String id;
    private String summary;
    private String providerProgrammaticName;
    private boolean isPrimary;
    
    public AccountInfoBuilder() {
        this.isPrimary = false;
    }
    
    /**
     * Sets the unique identifier for the account
     * @param id unique identifier for the account
     * @return this builder instance
     */
    public AccountInfoBuilder setId(String id) {
        this.id = id;
        return this;
    }
    
    /**
     * Sets the summary/display name for the account
     * @param summary display name for the account
     * @return this builder instance
     */
    public AccountInfoBuilder setSummary(String summary) {
        this.summary = summary;
        return this;
    }
    
    /**
     * Sets the programmatic name of the provider
     * @param providerProgrammaticName programmatic name of the provider
     * @return this builder instance
     */
    public AccountInfoBuilder setProviderProgrammaticName(String providerProgrammaticName) {
        this.providerProgrammaticName = providerProgrammaticName;
        return this;
    }
    
    /**
     * Sets whether this account is primary
     * @param isPrimary true if this is the primary account
     * @return this builder instance
     */
    public AccountInfoBuilder setPrimary(boolean isPrimary) {
        this.isPrimary = isPrimary;
        return this;
    }
    
    /**
     * Builds the AccountInfo instance
     * @return new AccountInfo instance
     * @throws IllegalStateException if required fields are not set
     */
    public AccountInfo build() {
        if (id == null) {
            throw new IllegalStateException("ID is required");
        }
        if (summary == null) {
            throw new IllegalStateException("Summary is required");
        }
        
        return new AccountInfo(id, summary, providerProgrammaticName, isPrimary);
    }
    
    /**
     * Creates a new builder instance
     * @return new AccountInfoBuilder
     */
    public static AccountInfoBuilder newBuilder() {
        return new AccountInfoBuilder();
    }
}