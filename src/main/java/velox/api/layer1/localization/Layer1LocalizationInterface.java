package velox.api.layer1.localization;

public interface Layer1LocalizationInterface {

    /**
     * Accepts a localized bundle provider for synchronization with Bookmap locale.
     *
     * @param localizedBundleProvider the provider for localization bundles
     */
    void acceptLocalizedBundleProvider(LocalizedBundleProvider localizedBundleProvider);
}