package velox.api.layer1.messages.indicators;

import java.awt.Color;

public interface IndicatorColorInterface {

    void addColorChangeListener(ColorsChangedListener listener);

    Color getOrDefault(String name, Color defaultValue);

    void set(String name, Color color);
}