package velox.api.layer1.common;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.EnumSet;
import java.io.IOException;

/**
 * This class contains access methods to Bookmap folder structure
 */
public class DirectoryResolver {
    
    /**
     * Default constructor
     */
    public DirectoryResolver() {
    }
    
    /**
     * Allows to access Bookmap root directory
     * On windows: C:\Bookmap by default, may be changed during installation
     * On mac: ~/Library/Application Support/Bookmap
     * On linux: ~/.bookmap
     * 
     * @return Bookmap root directory
     */
    public static Path getBookmapRootDirectory() {
        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");
        
        if (os.contains("win")) {
            return Paths.get("C:", "Bookmap");
        } else if (os.contains("mac")) {
            return Paths.get(userHome, "Library", "Application Support", "Bookmap");
        } else {
            return Paths.get(userHome, ".bookmap");
        }
    }
    
    /**
     * Allows to get subfolder in Bookmap directory.
     * Can be used to create custom folders or files.
     * Example:
     * {
     *     Path myFolder = DirectoryResolver.getBookmapDirectoryByName("MyFolder");
     *     Files.createDirectories(myFolder);
     *     myFolder.resolve("myFile").toFile().createNewFile();
     * }
     * 
     * @param folderName Name of subfolder under Bookmap root directory
     * @return Path representing subfolder with name folderName under Bookmap root directory
     */
    public static Path getBookmapDirectoryByName(String folderName) {
        return getBookmapRootDirectory().resolve(folderName);
    }
    
    /**
     * Config directory is where all configuration files for Bookmap are stored.
     * Also this is working directory for Bookmap java process.
     * 
     * @return Path representing Config directory under Bookmap root directory
     */
    public static Path getConfigDirectory() {
        return getBookmapRootDirectory().resolve("Config");
    }
    
    /**
     * Gets the logs directory
     * 
     * @return Path representing logs directory
     */
    public static Path getLogsDirectory() {
        return getBookmapRootDirectory().resolve("Logs");
    }
    
    /**
     * Gets the feeds directory
     * 
     * @return Path representing feeds directory
     */
    public static Path getFeedsDirectory() {
        return getBookmapRootDirectory().resolve("Feeds");
    }
    
    /**
     * Gets the error reports directory
     * 
     * @return Path representing error reports directory
     */
    public static Path getErrorReportsDirectory() {
        return getBookmapRootDirectory().resolve("ErrorReports");
    }
    
    /**
     * Gets the screenshots directory
     * 
     * @return Path representing screenshots directory
     */
    public static Path getScreenshotsDirectory() {
        return getBookmapRootDirectory().resolve("Screenshots");
    }
    
    /**
     * Gets the diagnostic logs directory
     * 
     * @return Path representing diagnostic logs directory
     */
    public static Path getDiagnosticLogsDirectory() {
        return getBookmapRootDirectory().resolve("DiagnosticLogs");
    }
    
    /**
     * Gets the sounds directory
     * 
     * @return Path representing sounds directory
     */
    public static Path getSoundsDirectory() {
        return getBookmapRootDirectory().resolve("Sounds");
    }
    
    /**
     * Gets the Layer0 API modules directory
     * 
     * @return Path representing Layer0 API modules directory
     */
    public static Path getLayer0ApiModulesDirectory() {
        return getBookmapRootDirectory().resolve("Layer0ApiModules");
    }
    
    /**
     * Gets the Layer1 API modules directory
     * 
     * @return Path representing Layer1 API modules directory
     */
    public static Path getLayer1ApiModulesDirectory() {
        return getBookmapRootDirectory().resolve("Layer1ApiModules");
    }
    
    /**
     * Gets the local data cache directory
     * 
     * @return Path representing local data cache directory
     */
    public static Path getLocalDataCacheDirectory() {
        return getBookmapRootDirectory().resolve("LocalDataCache");
    }
    
    /**
     * Gets the remote data cache directory
     * 
     * @return Path representing remote data cache directory
     */
    public static Path getRemoteDataCacheDirectory() {
        return getBookmapRootDirectory().resolve("RemoteDataCache");
    }
    
    /**
     * Gets the data library directory
     * 
     * @return Path representing data library directory
     */
    public static Path getDataLibraryDirectory() {
        return getBookmapRootDirectory().resolve("DataLibrary");
    }
    
    /**
     * Gets the temporary directory
     * 
     * @return Path representing temporary directory
     */
    public static Path getTemporaryDirectory() {
        return getBookmapRootDirectory().resolve("Temp");
    }
    
    /**
     * Directory where JVM crash logs are stored.
     * By default, JVM stores crash logs to the process working directory.
     * It's is equal to the Config directory on Windows and Linux.
     * On Mac it could be different, but on crash we execute script to move crash logs to Config directory.
     * So it's always equal to the Config directory within the current implementation.
     * 
     * @return Path representing directory where JVM crash logs are configured.
     */
    public static Path getNativeErrorLogsDirectory() {
        return getConfigDirectory();
    }
    
    /**
     * Set permissions for a file or directory.
     * 
     * @param path represents a path in a filesystem to directory or file
     * @param permissions variable number of POSIX file permissions
     */
    public static void setPermissions(Path path, PosixFilePermission... permissions) {
        try {
            if (permissions.length == 0) {
                return;
            }
            
            Set<PosixFilePermission> permissionSet = EnumSet.noneOf(PosixFilePermission.class);
            for (PosixFilePermission permission : permissions) {
                permissionSet.add(permission);
            }
            
            Files.setPosixFilePermissions(path, permissionSet);
        } catch (IOException e) {
            // Handle the exception appropriately for your use case
            throw new RuntimeException("Failed to set permissions for path: " + path, e);
        } catch (UnsupportedOperationException e) {
            // POSIX permissions not supported on this file system (e.g., Windows)
            // You might want to handle this differently based on your needs
            System.err.println("POSIX permissions not supported on this file system: " + path);
        }
    }
}