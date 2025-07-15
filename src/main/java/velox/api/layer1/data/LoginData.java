package velox.api.layer1.data;

import java.io.Serializable;

/**
 * Interface representing login data.
 * Classes that contain login information for specific platforms extend this interface.
 */
public interface LoginData extends Serializable {
    // Define methods that implementing classes should provide
    // Example method signatures can be added here
    String getUsername();
    String getPassword();
}