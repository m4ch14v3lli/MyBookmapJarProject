package velox.api.layer0.credentialscomponents;

import java.awt.Container;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Interface for credentials components that handle authentication UI elements.
 * Provides methods for managing values, aliases, and UI components.
 */
public interface CredentialsComponent {
    
    /**
     * Returns the component itself. Compound here means that a typical 
     * CredentialsComponent will contain one or more elements like a JTextField 
     * or a JComboBox and optionally a JLabel or anything else.
     * 
     * @return the UI container for this credentials component
     */
    Container getCompoundComponent();
    
    /**
     * Provide pair(s) of legacy name and current name for this credentials element
     * if there are any. Used for compatibility with an older credentials element
     * names. If "current name" (second element in a pair) does not have a
     * corresponding value stored in the settings yet, value will be taken from "legacy
     * name". There might be multiple pairs mapping to the same "current name", in
     * which case only the first matched one will have effect.
     * 
     * If an adapter is switched to extended credentials for the first time common
     * old names for login, password and demo check box are found in
     * CredentialsComponentUtil
     * 
     * @return list of pairs containing legacy name and current name mappings
     */
    List<Pair<String, String>> getAliases();
    
    /**
     * Adds a settings changed listener that will be notified when component values change.
     * 
     * @param listener the runnable to execute when settings change
     */
    void addSettingsChangedListener(Runnable listener);
    
    /**
     * Gets the current values from this credentials component.
     * 
     * @return map of field names to their current values
     */
    Map<String, String> getValues();
    
    /**
     * Sets the values for this credentials component.
     * 
     * @param values map of field names to values to set
     */
    void setValues(Map<String, String> values);
}

/**
 * An abstract implementation of CredentialsComponent.
 * It serves as a basis for a multi-value component (e.g. dependent fields).
 */
public abstract class MultiCredentialsComponent implements CredentialsComponent {
    
    /**
     * The panel typically populated and returned by getCompoundComponent() method.
     */
    protected JPanel panel;
    
    /**
     * Contains the list of instances of JComponent subclasses that make up the 
     * MultiCredentialsComponent (e.g. labels/textFields/comboBoxes etc).
     */
    protected List<JComponent> components;
    
    /**
     * The older name(s) for this CredentialsComponent.
     */
    protected List<Pair<String, String>> aliases;
    
    /**
     * Default constructor for MultiCredentialsComponent.
     */
    public MultiCredentialsComponent() {
        // Initialize collections and panel
        this.aliases = new java.util.ArrayList<>();
        this.components = new java.util.ArrayList<>();
        this.panel = new JPanel();
    }
    
    /**
     * Returns the component itself. Compound here means that a typical 
     * CredentialsComponent will contain one or more elements like a JTextField 
     * or a JComboBox and optionally a JLabel or anything else.
     * 
     * @return the UI container for this credentials component
     */
    @Override
    public Container getCompoundComponent() {
        return panel;
    }
    
    /**
     * Provide pair(s) of legacy name and current name for this credentials element
     * if there are any. Used for compatibility with an older credentials element
     * names. If "current name" (second element in a pair) does not have a
     * corresponding value stored in the settings yet, value will be taken from "legacy
     * name". There might be multiple pairs mapping to the same "current name", in
     * which case only the first matched one will have effect.
     * 
     * If an adapter is switched to extended credentials for the first time common
     * old names for login, password and demo check box are found in
     * CredentialsComponentUtil
     * 
     * @return list of pairs containing legacy name and current name mappings
     */
    @Override
    public List<Pair<String, String>> getAliases() {
        return aliases;
    }
    
    /**
     * Adds pair(s) of legacy name and actual name for this credentials element.
     * See getAliases() for details.
     * 
     * @param legacyName an older credentials element's name
     * @param actualName an actual credentials element's name
     */
    public void addAlias(String legacyName, String actualName) {
        aliases.add(Pair.of(legacyName, actualName));
    }
}

/**
 * Direct known subclass of MultiCredentialsComponent.
 * Base implementation that provides common functionality for credentials components.
 */
public abstract class BaseCredentialsComponent extends MultiCredentialsComponent {
    
    /**
     * Constructor for BaseCredentialsComponent.
     */
    public BaseCredentialsComponent() {
        super();
    }
    
    /**
     * Abstract method to be implemented by concrete subclasses.
     * This method should handle the actual value retrieval logic.
     * 
     * @return map of field names to their current values
     */
    @Override
    public abstract Map<String, String> getValues();
    
    /**
     * Abstract method to be implemented by concrete subclasses.
     * This method should handle the actual value setting logic.
     * 
     * @param values map of field names to values to set
     */
    @Override
    public abstract void setValues(Map<String, String> values);
    
    /**
     * Abstract method to be implemented by concrete subclasses.
     * This method should handle adding settings change listeners.
     * 
     * @param listener the runnable to execute when settings change
     */
    @Override
    public abstract void addSettingsChangedListener(Runnable listener);
}