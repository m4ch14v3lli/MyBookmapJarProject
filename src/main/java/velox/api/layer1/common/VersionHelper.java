package velox.api.layer1.common;

/**
 * This class can be used to retrieve Bookmap version
 */
public class VersionHelper {
    
    private static String bookmapVersion;
    private static boolean versionSet = false;
    
    /**
     * Default constructor
     */
    public VersionHelper() {
    }
    
    /**
     * Called by Bookmap code once to set version which will later become available to Layer1 API.
     * 
     * @param version current Bookmap version
     */
    public static void setBookmapVersionOnce(String version) {
        if (!versionSet) {
            bookmapVersion = version;
            versionSet = true;
        }
    }
    
    /**
     * Get string representation of bookmap version.
     * 
     * @return bookmap version, e.g. "7.1.0.42"
     */
    public static String getBookmapVersion() {
        return bookmapVersion;
    }
}