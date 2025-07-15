package velox.api.layer1.localization;

import com.ibm.icu.util.ULocale;

public interface LocalizedBundleProvider {

    /**
     * Retrieves a localized bundle based on the specified bundle name.
     *
     * @param bundleName the base file name where the translation is stored,
     *                   without the extension and locale prefixes.
     * @return a LocalizedBundle with the current Bookmap locale.
     */
    LocalizedBundle getBundle(String bundleName);

    /**
     * Gets the current Bookmap locale.
     *
     * @return the current ULocale.
     */
    ULocale getCurrentULocale();
}