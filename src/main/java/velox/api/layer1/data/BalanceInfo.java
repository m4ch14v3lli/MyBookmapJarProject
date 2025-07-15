package velox.api.layer1.data;

import java.util.List;

/**
 * Interface for multi-account awareness functionality
 */
public interface MultiAccountAware {
    /**
     * Gets the trading account ID
     * @return the trading account ID as String
     */
    String getTradingAccountId();
}

/**
 * Information about account balance in each currency
 */
public class BalanceInfo implements MultiAccountAware {
    
    /**
     * Short name of an account, if known (displayed name)
     * @deprecated because displayed name and account id should be set with AccountInfo.
     * Use accountId instead.
     */
    @Deprecated
    public final String accountName;
    
    /**
     * Account id to identify which account this balance info belongs to.
     * Null if there is no multi-account support (only single account is supported by the data provider).
     * Should not mix nulls and specific account infos in the same data provider.
     */
    public final String accountId;
    
    /**
     * List of balances (in each currency)
     */
    public final List<BalanceInCurrency> balancesInCurrency;
    
    /**
     * @deprecated because AccountInfo should be used instead of accountName.
     * Use BalanceInfo(List, String) instead.
     * Avoid using it directly, use BalanceInfoBuilder instead
     */
    @Deprecated
    public BalanceInfo(String accountName, List<BalanceInCurrency> balancesInCurrency) {
        this.accountName = accountName;
        this.accountId = null;
        this.balancesInCurrency = balancesInCurrency;
    }
    
    /**
     * Avoid using it directly, use BalanceInfoBuilder instead
     */
    public BalanceInfo(List<BalanceInCurrency> balancesInCurrency) {
        this.accountName = null;
        this.accountId = null;
        this.balancesInCurrency = balancesInCurrency;
    }
    
    /**
     * Constructor with account ID
     */
    public BalanceInfo(List<BalanceInCurrency> balancesInCurrency, String accountId) {
        this.accountName = null;
        this.accountId = accountId;
        this.balancesInCurrency = balancesInCurrency;
    }
    
    @Override
    public String getTradingAccountId() {
        return accountId;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BalanceInfo{");
        sb.append("accountId='").append(accountId).append('\'');
        sb.append(", accountName='").append(accountName).append('\'');
        sb.append(", balancesInCurrency=").append(balancesInCurrency);
        sb.append('}');
        return sb.toString();
    }
    
    /**
     * Information about account balance in specific currency
     */
    public static class BalanceInCurrency {
        
        /**
         * Currency code (e.g., "USD", "EUR")
         */
        public final String currency;
        
        /**
         * Available balance amount
         */
        public final double balance;
        
        /**
         * Realized profit and loss
         */
        public final double realizedPnl;
        
        /**
         * Unrealized profit and loss
         */
        public final double unrealizedPnl;
        
        /**
         * Constructor for BalanceInCurrency
         */
        public BalanceInCurrency(String currency, double balance, double realizedPnl, double unrealizedPnl) {
            this.currency = currency;
            this.balance = balance;
            this.realizedPnl = realizedPnl;
            this.unrealizedPnl = unrealizedPnl;
        }
        
        @Override
        public String toString() {
            return "BalanceInCurrency{" +
                    "currency='" + currency + '\'' +
                    ", balance=" + balance +
                    ", realizedPnl=" + realizedPnl +
                    ", unrealizedPnl=" + unrealizedPnl +
                    '}';
        }
    }
}

/**
 * Builder class for creating BalanceInfo instances
 */
public class BalanceInfoBuilder {
    private String accountId;
    private List<BalanceInfo.BalanceInCurrency> balancesInCurrency;
    
    public BalanceInfoBuilder setAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }
    
    public BalanceInfoBuilder setBalancesInCurrency(List<BalanceInfo.BalanceInCurrency> balancesInCurrency) {
        this.balancesInCurrency = balancesInCurrency;
        return this;
    }
    
    public BalanceInfo build() {
        return new BalanceInfo(balancesInCurrency, accountId);
    }
}

/**
 * Account information class (referenced in documentation)
 */
public class AccountInfo {
    public final String accountId;
    public final String displayName;
    
    public AccountInfo(String accountId, String displayName) {
        this.accountId = accountId;
        this.displayName = displayName;
    }
    
    @Override
    public String toString() {
        return "AccountInfo{" +
                "accountId='" + accountId + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}