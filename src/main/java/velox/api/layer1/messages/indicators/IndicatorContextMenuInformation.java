package velox.api.layer1.messages.indicators;

import javax.swing.JMenuItem;

public interface IndicatorContextMenuInformation {

    JMenuItem[] getGraphContextMenuItems(long time);

    JMenuItem[] getWidgetContextMenuItems();
}