package velox.api.layer1.layers.strategies.interfaces;

import javax.swing.JMenuItem;
import java.util.List;

public interface CanvasContextMenuProvider {

    List<JMenuItem> getMenuItems(CanvasMouseEvent e);

    default int getRightClickEventScore(CanvasMouseEvent e) {
        return 0; // Default implementation
    }

    default void onFocusGained() {
        // Default implementation
    }

    default void onFocusLost() {
        // Default implementation
    }
}