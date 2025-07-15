package velox.api.layer1.data;

public enum LoginFailedReason {
    WRONG_CREDENTIALS("Server didn't accept credentials"),
    REENTER_CREDENTIALS("Enter credentials again (the same ones)"),
    NO_INTERNET_CONNECTION("Cannot login because there is no connection to server(s) through the internet"),
    NO_LOCAL_CONNECTION("Cannot login because there is no connection to server located on the same machine"),
    SIMULTANEOUS_CONNECTION_KICKABLE("Simultaneous session that can be kicked"),
    TRADING_PASSWORD_EXPIRED("Trading password expired"),
    NEW_TRADING_PASSWORD_FAILED("New trading password setup failed"),
    UNKNOWN("Unknown problem. Try to login again - probably it will work"),
    FATAL("Fatal problem. No point in trying again until issue is resolved");

    private final String description;

    LoginFailedReason(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static LoginFailedReason valueOf(String name) {
        return Enum.valueOf(LoginFailedReason.class, name);
    }

    public static LoginFailedReason[] values() {
        return LoginFailedReason.values();
    }
}