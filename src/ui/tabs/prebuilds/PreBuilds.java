package ui.tabs.prebuilds;

import javax.swing.*;

public class PreBuilds extends JScrollPane {

    public PreBuilds() {
        getViewport().setScrollMode(JViewport.BLIT_SCROLL_MODE);
        getVerticalScrollBar().setUnitIncrement(80);
    }
}
