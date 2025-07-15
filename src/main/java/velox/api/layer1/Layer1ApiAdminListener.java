package velox.api.layer1;

import velox.api.layer1.data.DisconnectionReason;
import velox.api.layer1.data.LoginFailedReason;
import velox.api.layer1.data.SystemTextMessageType;

/**
 * Listens to general events, such as login results, disconnections, warnings,
 * etc.
 * 
 * This interface is implemented by various classes including:
 * - Layer1ApiDepthFreezer
 * - Layer1ApiInjectorRelay
 * - Layer1ApiRelay
 * - Layer1ApiStrategiesEchoMessagesLayer
 * - Layer1ApiUpstreamRelay
 * 
 * It is also extended by other interfaces:
 * - Layer1ApiAdapter
 * - Layer1ApiAdminAdapter
 * - Layer1ApiListener
 */
public interface Layer1ApiAdminListener {
    
    /**
     * Failed to login with specified credentials
     * 
     * @param reason reason code indicating why login failed
     * @param message text message associated with login fail (may be null)
     */
    void onLoginFailed(LoginFailedReason reason, String message);
    
    /**
     * Successful login.
     * Called when authentication is completed successfully.
     */
    void onLoginSuccessful();
    
    /**
     * Connection to server lost. Provider can call this method multiple times in sequence
     * if the reason was changed (i.e. from DisconnectionReason.NO_INTERNET
     * to DisconnectionReason.FATAL)
     * 
     * @param reason reason code indicating why connection was lost
     * @param message text message associated with login disconnection (may be null)
     */
    void onConnectionLost(DisconnectionReason reason, String message);
    
    /**
     * Connection to server restored. A provider should call it only if
     * it previously invoked onConnectionLost(DisconnectionReason, String)
     * 
     * This method indicates that the connection has been reestablished
     * after a previous disconnection event.
     */
    void onConnectionRestored();
    
    /**
     * Passes the message into Bookmap and shows it as a popup. It is suitable
     * for 1-time notifications, but for the general case take a look at the notifications
     * API - Layer1ApiSoundAlertMessage
     * 
     * @param message message itself - the text content to display
     * @param messageType message type indicating the nature/severity of the message
     * @see velox.api.layer1.messages.Layer1ApiSoundAlertMessage
     */
    void onSystemTextMessage(String message, SystemTextMessageType messageType);
    
    /**
     * Send an upstream event. Allows incorporating arbitrary functionality into protocol
     * 
     * This method provides a generic way to send custom data upstream,
     * enabling extensibility for protocol-specific features.
     * 
     * @param data Message content - can be any object containing custom data
     */
    void onUserMessage(Object data);
}