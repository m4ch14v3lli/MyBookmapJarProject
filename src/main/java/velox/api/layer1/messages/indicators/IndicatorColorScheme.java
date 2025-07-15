package velox.api.layer1.messages.indicators;

import java.awt.Color;

public class IndicatorColorScheme {

    public static class ColorDescription {
        public final Color defaultColor;
        public final String name;
        public boolean isDisplayedInColorDialog;
        public boolean isDisplayedInIndicatorPopup;

        public ColorDescription(Class<?> strategyClass, String name, Color defaultColor, boolean isDisplayedInColorDialog) {
            if (name == null || name.isEmpty() || !name.matches("[a-zA-Z0-9 ]+")) {
                throw new IllegalArgumentException("Name must consist of a-zA-Z0-9 and spaces, and must not be empty.");
            }
            this.defaultColor = defaultColor;
            this.name = name;
            this.isDisplayedInColorDialog = isDisplayedInColorDialog;
            this.isDisplayedInIndicatorPopup = false; // Default value
        }

        public void setDisplayedInIndicatorPopup(boolean displayedInIndicatorPopup) {
            this.isDisplayedInIndicatorPopup = displayedInIndicatorPopup;
        }

        public void setDisplayedInColorDialog(boolean displayedInColorDialog) {
            this.isDisplayedInColorDialog = displayedInColorDialog;
        }
    }
}