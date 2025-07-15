package velox.api.layer0.data;

import java.io.File;
import java.io.Serializable;
import velox.api.layer1.data.LoginData;

/**
 * Request to start reading specific file
 * 
 * @author Generated from JavaDoc analysis
 * @version 7.6.0
 */
public class ReadFileLoginData extends Object implements LoginData, Serializable {
    
    /**
     * Serial version UID for serialization
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * File selected by user
     */
    public final File file;
    
    /**
     * Constructor for ReadFileLoginData
     * 
     * @param file The file selected by user
     */
    public ReadFileLoginData(File file) {
        this.file = file;
    }
    
    /**
     * Gets the file selected by user
     * 
     * @return The file object
     */
    public File getFile() {
        return file;
    }
    
    @Override
    public String toString() {
        return "ReadFileLoginData{" +
                "file=" + file +
                '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        ReadFileLoginData that = (ReadFileLoginData) obj;
        return file != null ? file.equals(that.file) : that.file == null;
    }
    
    @Override
    public int hashCode() {
        return file != null ? file.hashCode() : 0;
    }
}