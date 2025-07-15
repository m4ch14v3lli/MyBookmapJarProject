package velox.api.layer1.settings;

import java.util.Map;

/**
 * Interface Layer1UserLicenseFieldsInterface allows strategies to receive user license fields.
 */
public interface Layer1UserLicenseFieldsInterface {

    /**
     * Accepts user license fields related to this module.
     *
     * @param licenseFields A map of user license fields.
     */
    void acceptUserLicenseFields(Map<String, String> licenseFields);
}