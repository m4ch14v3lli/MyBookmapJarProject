package velox.api.layer1.layers.strategies.interfaces;

import java.awt.Color;

public interface Layer1IndicatorColorInterface {

    void addColorChangeListener(ColorsChangedListener listener);

    Color getColor(String alias, String name);

    void setColor(String alias, String name, Color color);
}