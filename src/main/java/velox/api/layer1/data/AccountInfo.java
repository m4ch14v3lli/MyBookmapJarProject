package velox.api.layer1.data;

import velox.api.layer1.annotations.Layer1MultiAccountTradingSupported;
import velox.api.layer1.common.helper.ProviderTypeHelper;
import velox.api.layer1.messages.SelectAccountMessage;
import java.util.Objects;

/**
 * Information about account
 */
public class AccountInfo {
    
    /**
     * Unique identifier for the account. Must uniquely identify the account among all the providers
     * (so provider should form the id to contain provider-specific prefix or suffix).
     */
    public final String id;
    
    /**
     * Summary string, containing account name.
     * Is used as a display name for the account.
     */
    public final String summary;
    
    /**
     * Programmatic name (unique internal provider identifier) of the provider this account belongs to.
     * Unique among all the providers. Use ProviderTypeHelper to get to short name or user name by provider
     * programmatic name (e.g. EXT:velox.api.layer0.adapters.BinanceProvider -> "Binance"/"BN")
     * 
     * Note for the provider developer: this field is set by the Bookmap itself, and should not be set by the provider.
     * (if it is set by the provider, it will be overwritten by the Bookmap anyway)
     */
    public final String providerProgrammaticName;
    
    /**
     * If true used as a default account, when the strategy is not aware of multi-account data providers.
     * At least one account should be marked as primary, to be able to retrieve any data from the data provider.
     * Data for non-primary accounts is send to the strategy only if it has
     * Layer1MultiAccountTradingSupported annotation,
     * or if such data has no account specified (i.e. AccountInfo is null).
     * Usually primary account is the account selected with SelectAccountMessage -
     * decided by data provider for strategies that not aware of multi-accounts.
     */
    public final boolean isPrimary;
    
    /**
     * @deprecated use AccountInfo(String, String, String, boolean) instead. 
     * Deprecated because id is supposed to be unique and should not be used as a summary (displayed name).
     * @param id account id (unique identifier for the account). Used both for id and summary.
     */
    @Deprecated
    public AccountInfo(String id) {
        this.id = id;
        this.summary = id;
        this.providerProgrammaticName = null;
        this.isPrimary = false;
    }
    
    /**
     * Full constructor for AccountInfo
     * @param id unique identifier for the account
     * @param summary display name for the account
     * @param providerProgrammaticName programmatic name of the provider
     * @param isPrimary whether this is the primary account
     */
    public AccountInfo(String id, String summary, String providerProgrammaticName, boolean isPrimary) {
        this.id = id;
        this.summary = summary;
        this.providerProgrammaticName = providerProgrammaticName;
        this.isPrimary = isPrimary;
    }
    
    /**
     * Creates a builder for AccountInfo
     * @return AccountInfoBuilder instance
     */
    public AccountInfoBuilder toBuilder() {
        return new AccountInfoBuilder()
            .setId(this.id)
            .setSummary(this.summary)
            .setProviderProgrammaticName(this.providerProgrammaticName)
            .setPrimary(this.isPrimary);
    }
    
    @Override
    public String toString() {
        return "AccountInfo{" +
                "id='" + id + '\'' +
                ", summary='" + summary + '\'' +
                ", providerProgrammaticName='" + providerProgrammaticName + '\'' +
                ", isPrimary=" + isPrimary +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountInfo that = (AccountInfo) o;
        return isPrimary == that.isPrimary &&
                Objects.equals(id, that.id) &&
                Objects.equals(summary, that.summary) &&
                Objects.equals(providerProgrammaticName, that.providerProgrammaticName);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, summary, providerProgrammaticName, isPrimary);
    }
}