package velox.api.layer1.messages.indicators;

public interface AliasFilter {

    /**
     * Determines if the indicator should be displayed for the specified alias.
     *
     * @param alias the alias to check
     * @return true if the indicator should be displayed for this alias, false otherwise
     */
    default boolean isDisplayedForAlias(String alias) {
        return false; // Default implementation can be overridden
    }
}