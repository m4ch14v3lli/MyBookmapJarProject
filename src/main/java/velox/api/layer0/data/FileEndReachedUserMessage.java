package velox.api.layer0.data;

/**
 * Message used to notify that file end is reached and no other callbacks will
 * be made.
 * 
 * This class serves as a notification mechanism in file processing operations
 * to indicate that the end of file has been reached and no further processing
 * callbacks will occur.
 */
public class FileEndReachedUserMessage {
    
    /**
     * Default constructor for FileEndReachedUserMessage.
     * Creates a new instance of the message indicating file end has been reached.
     */
    public FileEndReachedUserMessage() {
        // Default constructor - no initialization required
        // This message acts as a simple notification signal
    }
    
    /**
     * Returns a string representation of this message.
     * Useful for debugging and logging purposes.
     * 
     * @return A string describing this file end notification
     */
    @Override
    public String toString() {
        return "FileEndReachedUserMessage: End of file reached, no more callbacks will be made";
    }
    
    /**
     * Checks equality with another object.
     * Two FileEndReachedUserMessage instances are considered equal
     * since they represent the same notification type.
     * 
     * @param obj The object to compare with
     * @return true if the object is also a FileEndReachedUserMessage, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof FileEndReachedUserMessage;
    }
    
    /**
     * Returns the hash code for this message.
     * Since all instances represent the same notification,
     * they share the same hash code.
     * 
     * @return Hash code for this message type
     */
    @Override
    public int hashCode() {
        return FileEndReachedUserMessage.class.hashCode();
    }
}