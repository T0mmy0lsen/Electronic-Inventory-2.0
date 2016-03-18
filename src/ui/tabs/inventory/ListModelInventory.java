package ui.tabs.inventory;

import ui.logic.ActionHandler;
import ui.logic.Constraints;
import models.System;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ListModelInventory extends JPanel implements ListCellRenderer<System>{

    JLabel description_label = new JLabel(){
        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            size.setSize(new Dimension(0,0));
            return size;
        }

        @Override
        public void setFont(Font font) {
            font = new Font("TimesRoman", Font.BOLD, (int)(ActionHandler.height()* ((double) 1/120)));
            super.setFont(font);
        }
    };

    JLabel price_label = new JLabel() {
        @Override
        public Dimension getPreferredSize() {
            Dimension size = super.getPreferredSize();
            size.setSize(new Dimension(0,0));
            return size;
        }
    };

    JPanel panel_0 = new JPanel();
    JPanel panel_1 = new JPanel();

    int height = (int) (ActionHandler.height() * ((double) 1/40));

    public ListModelInventory() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(getWidth(), height));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        Constraints.add(this, description_label,   0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.7, 1);
        Constraints.add(this, panel_0,             1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.1, 1);
        Constraints.add(this, panel_1,             2, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.1, 1);
        Constraints.add(this, price_label,         3, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.1, 1);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends System> list, System value, int index, boolean isSelected, boolean cellHasFocus) {
        description_label.setText("     Intel i7 - 4750K      3.4 Ghz     8 Cores     20MB Cache");
        price_label.setText("" + value.getCabinet() + " kr.");
        return this;
    }
}