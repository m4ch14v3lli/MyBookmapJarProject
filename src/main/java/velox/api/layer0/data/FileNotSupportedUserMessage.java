package velox.api.layer0.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Should be sent if file format can not be opened by this reader.
 * This class represents a user message indicating that a file format
 * is not supported by the current reader implementation.
 * 
 * @author Velox API Team
 * @version 7.6.0
 * @since 1.0
 */
public class FileNotSupportedUserMessage implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String fileName;
    private String fileExtension;
    private String mimeType;
    private String errorMessage;
    private LocalDateTime timestamp;
    private String readerType;
    private long fileSize;
    
    /**
     * Default constructor for FileNotSupportedUserMessage.
     * Initializes timestamp to current time.
     */
    public FileNotSupportedUserMessage() {
        this.timestamp = LocalDateTime.now();
        this.errorMessage = "File format is not supported by this reader";
    }
    
    /**
     * Constructor with file name.
     * 
     * @param fileName the name of the unsupported file
     */
    public FileNotSupportedUserMessage(String fileName) {
        this();
        this.fileName = fileName;
        this.fileExtension = extractFileExtension(fileName);
    }
    
    /**
     * Constructor with file details.
     * 
     * @param fileName the name of the unsupported file
     * @param mimeType the MIME type of the file
     * @param readerType the type of reader that failed
     */
    public FileNotSupportedUserMessage(String fileName, String mimeType, String readerType) {
        this(fileName);
        this.mimeType = mimeType;
        this.readerType = readerType;
    }
    
    /**
     * Full constructor with all parameters.
     * 
     * @param fileName the name of the unsupported file
     * @param mimeType the MIME type of the file
     * @param readerType the type of reader that failed
     * @param fileSize the size of the file in bytes
     * @param customErrorMessage custom error message
     */
    public FileNotSupportedUserMessage(String fileName, String mimeType, String readerType, 
                                     long fileSize, String customErrorMessage) {
        this(fileName, mimeType, readerType);
        this.fileSize = fileSize;
        this.errorMessage = customErrorMessage != null ? customErrorMessage : this.errorMessage;
    }
    
    /**
     * Gets the file name.
     * 
     * @return the file name
     */
    public String getFileName() {
        return fileName;
    }
    
    /**
     * Sets the file name.
     * 
     * @param fileName the file name to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
        this.fileExtension = extractFileExtension(fileName);
    }
    
    /**
     * Gets the file extension.
     * 
     * @return the file extension
     */
    public String getFileExtension() {
        return fileExtension;
    }
    
    /**
     * Sets the file extension.
     * 
     * @param fileExtension the file extension to set
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
    
    /**
     * Gets the MIME type.
     * 
     * @return the MIME type
     */
    public String getMimeType() {
        return mimeType;
    }
    
    /**
     * Sets the MIME type.
     * 
     * @param mimeType the MIME type to set
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
    
    /**
     * Gets the error message.
     * 
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    
    /**
     * Sets the error message.
     * 
     * @param errorMessage the error message to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    /**
     * Gets the timestamp when the error occurred.
     * 
     * @return the timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    /**
     * Sets the timestamp.
     * 
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * Gets the reader type that failed.
     * 
     * @return the reader type
     */
    public String getReaderType() {
        return readerType;
    }
    
    /**
     * Sets the reader type.
     * 
     * @param readerType the reader type to set
     */
    public void setReaderType(String readerType) {
        this.readerType = readerType;
    }
    
    /**
     * Gets the file size.
     * 
     * @return the file size in bytes
     */
    public long getFileSize() {
        return fileSize;
    }
    
    /**
     * Sets the file size.
     * 
     * @param fileSize the file size in bytes
     */
    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
    
    /**
     * Extracts file extension from file name.
     * 
     * @param fileName the file name
     * @return the file extension or null if not found
     */
    private String extractFileExtension(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return null;
        }
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex > 0 && lastDotIndex < fileName.length() - 1) {
            return fileName.substring(lastDotIndex + 1).toLowerCase();
        }
        return null;
    }
    
    /**
     * Formats the error message for display.
     * 
     * @return formatted error message
     */
    public String getFormattedErrorMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("File Not Supported Error: ");
        
        if (fileName != null) {
            sb.append("File '").append(fileName).append("' ");
        }
        
        if (fileExtension != null) {
            sb.append("(").append(fileExtension.toUpperCase()).append(" format) ");
        }
        
        sb.append("cannot be processed by ");
        
        if (readerType != null) {
            sb.append(readerType).append(" reader");
        } else {
            sb.append("the current reader");
        }
        
        sb.append(". ").append(errorMessage);
        
        return sb.toString();
    }
    
    /**
     * Checks if this message represents a critical error.
     * 
     * @return true if this is a critical error
     */
    public boolean isCriticalError() {
        return errorMessage != null && 
               (errorMessage.toLowerCase().contains("critical") || 
                errorMessage.toLowerCase().contains("fatal"));
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        FileNotSupportedUserMessage that = (FileNotSupportedUserMessage) obj;
        return fileSize == that.fileSize &&
               Objects.equals(fileName, that.fileName) &&
               Objects.equals(fileExtension, that.fileExtension) &&
               Objects.equals(mimeType, that.mimeType) &&
               Objects.equals(errorMessage, that.errorMessage) &&
               Objects.equals(timestamp, that.timestamp) &&
               Objects.equals(readerType, that.readerType);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(fileName, fileExtension, mimeType, errorMessage, 
                          timestamp, readerType, fileSize);
    }
    
    @Override
    public String toString() {
        return "FileNotSupportedUserMessage{" +
               "fileName='" + fileName + '\'' +
               ", fileExtension='" + fileExtension + '\'' +
               ", mimeType='" + mimeType + '\'' +
               ", errorMessage='" + errorMessage + '\'' +
               ", timestamp=" + timestamp +
               ", readerType='" + readerType + '\'' +
               ", fileSize=" + fileSize +
               '}';
    }
}