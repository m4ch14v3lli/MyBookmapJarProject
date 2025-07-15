package velox.api.layer1.data;

/**
 * Information about account balance
 */
public class BalanceInfo {
    
    /**
     * Information about account balance in specific currency
     */
    public static class BalanceInCurrency {
        
        /**
         * Account balance amount
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
         * Previous day balance amount
         */
        public final double previousDayBalance;
        
        /**
         * Net liquidity value
         */
        public final double netLiquidityValue;
        
        /**
         * Currency name
         */
        public final String currency;
        
        /**
         * Conversion rate to account base currency. 
         * Null if this is a base currency.
         */
        public final Double rateToBase;
        
        /**
         * Constructor for BalanceInCurrency
         * 
         * @param balance Account balance amount
         * @param realizedPnl Realized profit and loss
         * @param unrealizedPnl Unrealized profit and loss
         * @param previousDayBalance Previous day balance amount
         * @param netLiquidityValue Net liquidity value
         * @param currency Currency name
         * @param rateToBase Conversion rate to account base currency
         */
        public BalanceInCurrency(double balance, 
                               double realizedPnl, 
                               double unrealizedPnl, 
                               double previousDayBalance, 
                               double netLiquidityValue, 
                               String currency, 
                               Double rateToBase) {
            this.balance = balance;
            this.realizedPnl = realizedPnl;
            this.unrealizedPnl = unrealizedPnl;
            this.previousDayBalance = previousDayBalance;
            this.netLiquidityValue = netLiquidityValue;
            this.currency = currency;
            this.rateToBase = rateToBase;
        }
        
        /**
         * Returns a string representation of the BalanceInCurrency object
         * 
         * @return String representation of the object
         */
        @Override
        public String toString() {
            return "BalanceInCurrency{" +
                    "balance=" + balance +
                    ", realizedPnl=" + realizedPnl +
                    ", unrealizedPnl=" + unrealizedPnl +
                    ", previousDayBalance=" + previousDayBalance +
                    ", netLiquidityValue=" + netLiquidityValue +
                    ", currency='" + currency + '\'' +
                    ", rateToBase=" + rateToBase +
                    '}';
        }
        
        /**
         * Gets the total P&L (realized + unrealized)
         * 
         * @return Total profit and loss
         */
        public double getTotalPnl() {
            return realizedPnl + unrealizedPnl;
        }
        
        /**
         * Gets the balance change from previous day
         * 
         * @return Balance change amount
         */
        public double getBalanceChange() {
            return balance - previousDayBalance;
        }
        
        /**
         * Checks if this is the base currency
         * 
         * @return true if this is base currency, false otherwise
         */
        public boolean isBaseCurrency() {
            return rateToBase == null;
        }
        
        /**
         * Converts amount to base currency using the rate
         * 
         * @param amount Amount to convert
         * @return Converted amount in base currency
         */
        public double convertToBase(double amount) {
            if (isBaseCurrency()) {
                return amount;
            }
            return amount * rateToBase;
        }
    }
}