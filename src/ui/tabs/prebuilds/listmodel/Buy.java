package ui.tabs.prebuilds.listmodel;

import ui.logic.ActionHandler;
import ui.logic.Constraints;
import javax.swing.*;
import java.awt.*;

public class Buy extends JPanel {

    int height = (int) (ActionHandler.height() * ((double) 1/50));
    public static ThisButton button = new ThisButton("buy");
    public static ThisButton button_remove = new ThisButton("remove");

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.setSize(new Dimension(0,0));
        return size;
    }

    public Buy(String text) {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(5, height * 2,(int) (height * 1.5), height * 2));
        setLayout(new GridBagLayout());

        Constraints.add(this, button,      0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1, 1);
        Constraints.add(this, button_remove,      0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1, 1);
    }
}
