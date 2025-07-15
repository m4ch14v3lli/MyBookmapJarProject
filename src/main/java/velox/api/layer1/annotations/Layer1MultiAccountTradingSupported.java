package velox.api.layer1.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the marked strategy supports data from multiple trading accounts to be received.
 * With this annotation, such data is received with Layer1ApiTradingListener.onStatus(StatusInfo),
 * Layer1ApiTradingListener.onBalance(BalanceInfo), Layer1ApiTradingListener.onOrderUpdated(OrderInfoUpdate)
 * Layer1ApiTradingListener.onOrderExecuted(ExecutionInfo) methods, both from primary and non-primary
 * accounts (see AccountInfo.isPrimary). Otherwise, if strategy is not annotated
 * with this annotation, only data from a primary account is received or the data has no account specified
 * (i.e. account id is null; provider has no multi-account support).
 *
 * @see Layer1ApiTradingListener
 * @see TradingAccountsInfoMessage
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Layer1MultiAccountTradingSupported {
}