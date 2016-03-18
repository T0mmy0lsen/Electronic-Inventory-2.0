package ui.tabs.prebuilds;

import ui.logic.ActionHandler;
import ui.logic.Constraints;
import models.System;
import ui.tabs.prebuilds.listmodel.*;

import javax.swing.*;
import java.awt.*;

public class ListModelPrebuild extends JPanel implements ListCellRenderer<System>{

    Picture panel_pic = new Picture("003");
    SystemName panel_name = new SystemName("Gamer Xtreme Performance");
    Stats panel_cpu = new Stats("Intel i7 - 3.4 Ghz - Quad Core");
    Stats panel_ram = new Stats("32GB - 2133 Mhz - DDR4 ram");
    Stats panel_graphic = new Stats("3 x GeForce GTX Titan 12GB");
    Stats panel_mainboard = new Stats("MSI X99A Godlike Gaming");
    JPanel panel_pad = new JPanel();
    Price panel_price = new Price("26995,-");
    Buy panel_buy = new Buy("");

    int height = (int) (ActionHandler.height() * ((double) 1/6));

    public ListModelPrebuild() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(getWidth(), height));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

        panel_buy.setBackground(Color.WHITE);
        panel_name.setBackground(Color.WHITE);
        panel_cpu.setBackground(Color.WHITE);
        panel_ram.setBackground(Color.WHITE);
        panel_graphic.setBackground(Color.WHITE);
        panel_mainboard.setBackground(Color.WHITE);
        panel_pad.setBackground(Color.WHITE);
        panel_price.setBackground(Color.WHITE);
        panel_pic.setBackground(Color.WHITE);

        Constraints.add(this, panel_pic,     0, 0, 1, 8, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.45, 1);
        Constraints.add(this, panel_name,    1, 0, 2, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.275, 0.25);
        Constraints.add(this, panel_cpu,     1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.275, 0.125);
        Constraints.add(this, panel_ram,     1, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.275, 0.125);
        Constraints.add(this, panel_graphic, 1, 4, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.275, 0.125);
        Constraints.add(this, panel_mainboard, 1, 5, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.275, 0.125);
        Constraints.add(this, panel_pad,     1, 6, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.275, 0.25);
        Constraints.add(this, panel_price,   2, 3, 1, 2, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.275, 0.25);
        Constraints.add(this, panel_buy,     2, 5, 1, 3, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.275, 0.25);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends System> list, System value, int index, boolean isSelected, boolean cellHasFocus) {
        if(isSelected){
            Buy.button.setVisible(false);
        } else {
            Buy.button.setVisible(true);
        }
        return this;
    }
}
