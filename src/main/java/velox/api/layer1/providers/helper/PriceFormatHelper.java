package velox.api.layer1.providers.helper;

/**
 * Class PriceFormatHelper provides methods for formatting prices.
 */
public class PriceFormatHelper {

    /**
     * Creates a new instance of PriceFormatHelper.
     */
    public PriceFormatHelper() {
        // Constructor implementation
    }

    /**
     * Formats prices using default bookmap price formatting logic.
     *
     * @param pips  The pips value.
     * @param price The price to format.
     * @return A formatted string representation of the price.
     */
    public static String formatPriceDefault(double pips, double price) {
        // Implement formatting logic
        return String.format("%.2f", price); // Placeholder implementation
    }
}