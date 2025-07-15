package velox.api.layer1.data;

import java.util.ArrayList;

/**
 * Builder for BalanceInfo - see corresponding javadoc for information about the fields.
 */
public class BalanceInfoBuilder {
    
    private String accountId;
    private String accountName; // deprecated field
    private ArrayList<BalanceInfo.BalanceInCurrency> balancesInCurrency;
    
    /**
     * Default constructor
     */
    public BalanceInfoBuilder() {
        this.balancesInCurrency = new ArrayList<>();
    }
    
    /**
     * Builds and returns the BalanceInfo object
     * @return BalanceInfo instance
     */
    public BalanceInfo build() {
        return new BalanceInfo(accountId, balancesInCurrency);
    }
    
    /**
     * Updates balance in currency
     * @param balanceInCurrency the balance in currency to update
     * @return this builder instance for method chaining
     */
    public BalanceInfoBuilder updateBalanceInCurrency(BalanceInfo.BalanceInCurrency balanceInCurrency) {
        if (balanceInCurrency != null) {
            // Find existing balance for same currency and update, or add new one
            boolean found = false;
            for (int i = 0; i < balancesInCurrency.size(); i++) {
                if (balancesInCurrency.get(i).getCurrency().equals(balanceInCurrency.getCurrency())) {
                    balancesInCurrency.set(i, balanceInCurrency);
                    found = true;
                    break;
                }
            }
            if (!found) {
                balancesInCurrency.add(balanceInCurrency);
            }
        }
        return this;
    }
    
    /**
     * @deprecated Use getAccountId() instead
     * @return account name (displayed account name)
     */
    @Deprecated
    public String getAccountName() {
        return this.accountName;
    }
    
    /**
     * @deprecated Use setAccountId(String) instead
     * @param accountName the account name to set
     * @return this builder instance for method chaining
     */
    @Deprecated
    public BalanceInfoBuilder setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }
    
    /**
     * @return account id of the account the balance is for. Null if there is no multi-account support
     * (only single account is supported by the data provider).
     */
    public String getAccountId() {
        return this.accountId;
    }
    
    /**
     * Indicate which account the balance is for.
     * If not set, there is no multi-account support
     * (only single account is supported by the data provider).
     * Important: Don't set to null if there is multi-account support and data is coming from multiple accounts!
     * 
     * @param accountId the account id to set
     * @return this builder instance for method chaining
     */
    public BalanceInfoBuilder setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }
    
    /**
     * @return list of balances in different currencies
     */
    public ArrayList<BalanceInfo.BalanceInCurrency> getBalancesInCurrency() {
        return this.balancesInCurrency;
    }
    
    /**
     * Sets the balances in currency
     * @param balancesInCurrency the balances in currency to set
     * @return this builder instance for method chaining
     */
    public BalanceInfoBuilder setBalancesInCurrency(ArrayList<BalanceInfo.BalanceInCurrency> balancesInCurrency) {
        this.balancesInCurrency = balancesInCurrency != null ? balancesInCurrency : new ArrayList<>();
        return this;
    }
}