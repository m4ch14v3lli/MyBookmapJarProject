package velox.api.layer0.credentialscomponents;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComponent;

/**
 * Contains legacy field names which may be specified as aliases
 * in CredentialsComponent.getAliases() method.
 */
public class CredentialsComponentUtil {

    /**
     * Large font for a connection configuration visual element.
     */
    public static final float LARGE_FONT = 18.0f;

    /**
     * Legacy name for demo checkbox.
     */
    public static final String LEGACY_DEMO_ALIAS = "demo";

    /**
     * Legacy name for password.
     */
    public static final String LEGACY_PASSWORD_ALIAS = "password";

    /**
     * Legacy name for username.
     */
    public static final String LEGACY_USERNAME_ALIAS = "username";

    /**
     * Default constructor.
     */
    public CredentialsComponentUtil() {
        // No initialization required
    }

    /**
     * Returns typical GridBagConstraints for a JComponent which is
     * a part of CredentialsComponent compound component.
     *
     * @param gridy     The vertical grid position
     * @param component The UI component
     * @return GridBagConstraints configured for layout
     */
    public static GridBagConstraints getGridBagConstraints(int gridy, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = gridy;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(2, 2, 2, 2);
        return constraints;
    }
}
