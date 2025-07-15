package velox.api.layer1.layers.strategies.interfaces;

import java.awt.event.MouseEvent;

public interface CanvasMouseListener {

    int getEventScore(CanvasMouseEvent e);

    default void mouseClicked(CanvasMouseEvent e) {
        // Default implementation
    }

    default void mouseDragged(CanvasMouseEvent e) {
        // Default implementation
    }

    default void mouseEntered(CanvasMouseEvent e) {
        // Default implementation
    }

    default void mouseExited(CanvasMouseEvent e) {
        // Default implementation
    }

    default void mouseMoved(CanvasMouseEvent e) {
        // Default implementation
    }

    default void mousePressed(CanvasMouseEvent e) {
        // Default implementation
    }

    default void mouseReleased(CanvasMouseEvent e) {
        // Default implementation
    }

    default void mouseWheelMoved(CanvasMouseEvent e) {
        // Default implementation
    }

    default void onFocusGained() {
        // Default implementation
    }

    default void onFocusLost() {
        // Default implementation
    }
}