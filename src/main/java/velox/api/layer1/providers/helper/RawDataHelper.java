package velox.api.layer1.providers.helper;

/**
 * Class RawDataHelper provides methods for recording and managing raw data.
 */
public class RawDataHelper {

    /**
     * Creates a new instance of RawDataHelper.
     */
    public RawDataHelper() {
        // Constructor implementation
    }

    /**
     * Records raw data.
     *
     * @param data           The raw data to record.
     * @param adminListeners The listeners used to send raw data.
     * @throws IllegalStateException if raw data recording is not enabled.
     */
    public static void sendRawData(String data, java.util.List<Layer1ApiAdminListener> adminListeners) {
        if (!isRawDataRecordingEnabled()) {
            throw new IllegalStateException("Raw data recording is not enabled.");
        }
        // Implementation for recording raw data
    }

    /**
     * Checks if raw data recording is enabled.
     *
     * @return true if raw data recording is enabled; false otherwise.
     */
    public static boolean isRawDataRecordingEnabled() {
        // Logic to check if raw data recording is enabled
        return true; // Placeholder implementation
    }
}