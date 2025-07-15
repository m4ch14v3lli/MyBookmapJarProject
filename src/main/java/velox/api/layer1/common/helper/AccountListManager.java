package velox.api.layer1.common.helper;

/**
 * Provider type helper utility class
 */
public class ProviderTypeHelper {
    
    public static final String PROVIDER_TYPE_DEMO = "DEMO";
    public static final String PROVIDER_TYPE_LIVE = "LIVE";
    public static final String PROVIDER_TYPE_PAPER = "PAPER";
    
    /**
     * Checks if provider is demo type
     * @param providerProgrammaticName provider programmatic name
     * @return true if demo provider
     */
    public static boolean isDemoProvider(String providerProgrammaticName) {
        return PROVIDER_TYPE_DEMO.equals(providerProgrammaticName);
    }
    
    /**
     * Checks if provider is live type
     * @param providerProgrammaticName provider programmatic name
     * @return true if live provider
     */
    public static boolean isLiveProvider(String providerProgrammaticName) {
        return PROVIDER_TYPE_LIVE.equals(providerProgrammaticName);
    }
    
    /**
     * Checks if provider is paper type
     * @param providerProgrammaticName provider programmatic name
     * @return true if paper provider
     */
    public static boolean isPaperProvider(String providerProgrammaticName) {
        return PROVIDER_TYPE_PAPER.equals(providerProgrammaticName);
    }
}

/**
 * Helper class to manage account list, map instrument aliases to account and map orders to accounts.
 * 
 * To use this class, you need to call onUserMessage(Object) with any user message you receive in
 * Layer1ApiAdminListener.onUserMessage(Object) (needed message will be picked by this class itself)
 * 
 * To be able to map orders to accounts, you need to call onOrderUpdated(OrderInfoUpdate) with
 * any order updates you receive in Layer1ApiTradingListener.onOrderUpdated(OrderInfoUpdate).
 * 
 * This class is thread-safe.
 */
public class AccountListManager {
    
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<String, AccountInfo> accountsById = new ConcurrentHashMap<>();
    private final Map<String, Set<AccountInfo>> accountsByAlias = new ConcurrentHashMap<>();
    private final Map<String, Set<String>> aliasesByAccountId = new ConcurrentHashMap<>();
    private final Map<String, AccountInfo> accountsByOrderId = new ConcurrentHashMap<>();
    private final Map<String, AccountInfo> primaryAccountsByProvider = new ConcurrentHashMap<>();
    private final Map<String, List<AccountInfo>> accountsByProvider = new ConcurrentHashMap<>();

    /**
     * Default constructor
     */
    public AccountListManager() {
    }

    /**
     * Returns all available accounts.
     * @return account info set
     */
    public Set<AccountInfo> getAccounts() {
        lock.readLock().lock();
        try {
            return new HashSet<>(accountsById.values());
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Returns primary account info for the provider.
     * @param providerProgrammaticName provider programmatic name for the account
     * @return primary account info for the provider or null if not found
     */
    public AccountInfo getPrimaryAccountByProvider(String providerProgrammaticName) {
        lock.readLock().lock();
        try {
            return primaryAccountsByProvider.get(providerProgrammaticName);
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Returns all accounts for the provider by the id of one of the provider accounts
     * @param accountId account id of one of the provider accounts
     * @param includePrimary whether to include primary account to the result
     * @return list of all accounts for the provider by the id of one of the provider accounts
     */
    public List<AccountInfo> getProviderOtherAccountsByAccountId(String accountId, boolean includePrimary) {
        lock.readLock().lock();
        try {
            AccountInfo account = accountsById.get(accountId);
            if (account == null) {
                return new ArrayList<>();
            }
            
            List<AccountInfo> providerAccounts = accountsByProvider.get(account.getProviderProgrammaticName());
            if (providerAccounts == null) {
                return new ArrayList<>();
            }
            
            List<AccountInfo> result = new ArrayList<>(providerAccounts);
            if (!includePrimary) {
                AccountInfo primaryAccount = primaryAccountsByProvider.get(account.getProviderProgrammaticName());
                if (primaryAccount != null) {
                    result.remove(primaryAccount);
                }
            }
            
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Returns all providers with multiple accounts (providers are represented by their programmatic name).
     * @return set of providers programmatic name for providers with multiple accounts
     */
    public Set<String> getProvidersWithMultiAccounts() {
        lock.readLock().lock();
        try {
            Set<String> result = new HashSet<>();
            for (Map.Entry<String, List<AccountInfo>> entry : accountsByProvider.entrySet()) {
                if (entry.getValue().size() > 1) {
                    result.add(entry.getKey());
                }
            }
            return result;
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Returns account info by account id.
     * @param accountId account id
     * @return account info or null if not found
     */
    public AccountInfo getAccountById(String accountId) {
        lock.readLock().lock();
        try {
            return accountsById.get(accountId);
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Returns all account infos for instrument alias.
     * @param alias instrument alias
     * @return account info set
     */
    public Set<AccountInfo> getAccountsByAlias(String alias) {
        lock.readLock().lock();
        try {
            Set<AccountInfo> accounts = accountsByAlias.get(alias);
            return accounts != null ? new HashSet<>(accounts) : new HashSet<>();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Returns the list of all currently subscribed instrument aliases for account id.
     * @param accountId account id
     * @return set of instrument aliases for given account id
     */
    public Set<String> getAliasesByAccountId(String accountId) {
        lock.readLock().lock();
        try {
            Set<String> aliases = aliasesByAccountId.get(accountId);
            return aliases != null ? new HashSet<>(aliases) : new HashSet<>();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Returns account info by order id.
     * @param orderId order id
     * @return account info or null if not found
     */
    public AccountInfo getAccountByOrderId(String orderId) {
        lock.readLock().lock();
        try {
            return accountsByOrderId.get(orderId);
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Checks if the account is primary by account id (null is considered primary).
     * If the account is not found returns null.
     * @param accountId account id
     * @return true if the account is primary, false otherwise or null if the account is not found
     */
    public Boolean isPrimaryAccountOrNull(String accountId) {
        if (accountId == null) {
            return true;
        }
        
        lock.readLock().lock();
        try {
            AccountInfo account = accountsById.get(accountId);
            if (account == null) {
                return null;
            }
            return account.isPrimary();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Checks if the account is primary by account id (null is considered primary).
     * If the account is not found returns true.
     * @param accountId account id
     * @return true if the account is primary, false otherwise
     */
    public boolean isPrimaryAccount(String accountId) {
        if (accountId == null) {
            return true;
        }
        
        lock.readLock().lock();
        try {
            AccountInfo account = accountsById.get(accountId);
            if (account == null) {
                return true;
            }
            return account.isPrimary();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Checks if the account is primary by order id. If the account or order is not found returns null.
     * @param orderId order id
     * @return true if the account is primary, false otherwise or null if the account or order is not found
     */
    public Boolean isPrimaryAccountOrderOrNull(String orderId) {
        lock.readLock().lock();
        try {
            AccountInfo account = accountsByOrderId.get(orderId);
            if (account == null) {
                return null;
            }
            return account.isPrimary();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Checks if the account is primary by order id. If the account or order is not found returns true.
     * @param orderId order id
     * @return true if the account is primary, false otherwise
     */
    public boolean isPrimaryAccountOrder(String orderId) {
        lock.readLock().lock();
        try {
            AccountInfo account = accountsByOrderId.get(orderId);
            if (account == null) {
                return true;
            }
            return account.isPrimary();
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Takes any user messages while accepts and processes only TradingAccountsInfoMessage
     * to update the account list.
     * @param message any user message received by Layer1ApiAdminListener.onUserMessage(Object)
     * @return true if the account list has any updates, false otherwise
     */
    public boolean onUserMessage(Object message) {
        if (!(message instanceof TradingAccountsInfoMessage)) {
            return false;
        }

        TradingAccountsInfoMessage accountMessage = (TradingAccountsInfoMessage) message;
        
        lock.writeLock().lock();
        try {
            boolean hasUpdates = false;
            
            if (accountMessage.isAdd()) {
                hasUpdates = addAccount(accountMessage.getAccountInfo());
            } else {
                hasUpdates = removeAccount(accountMessage.getAccountInfo());
            }
            
            return hasUpdates;
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * Generates messages from the accounts list as if they were received from the provider (with isAdd=true for each).
     * @return list of messages for each account
     */
    public List<TradingAccountsInfoMessage> generateMessagesFromAccountsList() {
        lock.readLock().lock();
        try {
            List<TradingAccountsInfoMessage> messages = new ArrayList<>();
            for (AccountInfo account : accountsById.values()) {
                messages.add(new TradingAccountsInfoMessage(account, true));
            }
            return messages;
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Takes order update messages to map orders to the accounts.
     * @param orderInfoUpdate order info update message with account id (if specified)
     */
    public void onOrderUpdated(OrderInfoUpdate orderInfoUpdate) {
        if (orderInfoUpdate.getOrderId() == null) {
            return;
        }

        lock.writeLock().lock();
        try {
            String accountId = orderInfoUpdate.getAccountId();
            if (accountId != null) {
                AccountInfo account = accountsById.get(accountId);
                if (account != null) {
                    accountsByOrderId.put(orderInfoUpdate.getOrderId(), account);
                }
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    private boolean addAccount(AccountInfo accountInfo) {
        if (accountInfo == null) {
            return false;
        }

        boolean hasUpdates = false;
        String accountId = accountInfo.getAccountId();
        
        // Add account to main map
        if (!accountsById.containsKey(accountId)) {
            accountsById.put(accountId, accountInfo);
            hasUpdates = true;
        }

        // Update provider mappings
        String provider = accountInfo.getProviderProgrammaticName();
        if (provider != null) {
            accountsByProvider.computeIfAbsent(provider, k -> new ArrayList<>()).add(accountInfo);
            
            if (accountInfo.isPrimary()) {
                primaryAccountsByProvider.put(provider, accountInfo);
            }
        }

        // Update alias mappings
        Set<String> aliases = accountInfo.getAliases();
        if (aliases != null) {
            for (String alias : aliases) {
                accountsByAlias.computeIfAbsent(alias, k -> new HashSet<>()).add(accountInfo);
                aliasesByAccountId.computeIfAbsent(accountId, k -> new HashSet<>()).add(alias);
            }
            hasUpdates = true;
        }

        return hasUpdates;
    }

    private boolean removeAccount(AccountInfo accountInfo) {
        if (accountInfo == null) {
            return false;
        }

        String accountId = accountInfo.getAccountId();
        AccountInfo removedAccount = accountsById.remove(accountId);
        
        if (removedAccount == null) {
            return false;
        }

        // Remove from provider mappings
        String provider = removedAccount.getProviderProgrammaticName();
        if (provider != null) {
            List<AccountInfo> providerAccounts = accountsByProvider.get(provider);
            if (providerAccounts != null) {
                providerAccounts.remove(removedAccount);
                if (providerAccounts.isEmpty()) {
                    accountsByProvider.remove(provider);
                }
            }
            
            if (removedAccount.isPrimary()) {
                primaryAccountsByProvider.remove(provider);
            }
        }

        // Remove alias mappings
        Set<String> aliases = aliasesByAccountId.remove(accountId);
        if (aliases != null) {
            for (String alias : aliases) {
                Set<AccountInfo> accountsForAlias = accountsByAlias.get(alias);
                if (accountsForAlias != null) {
                    accountsForAlias.remove(removedAccount);
                    if (accountsForAlias.isEmpty()) {
                        accountsByAlias.remove(alias);
                    }
                }
            }
        }

        // Remove order mappings
        accountsByOrderId.entrySet().removeIf(entry -> entry.getValue().equals(removedAccount));

        return true;
    }
}