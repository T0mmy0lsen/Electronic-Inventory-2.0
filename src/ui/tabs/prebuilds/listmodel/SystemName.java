package ui.tabs.prebuilds.listmodel;

import ui.MainFrame;
import ui.logic.ActionHandler;
import ui.logic.Constraints;

import javax.swing.*;
import java.awt.*;

public class SystemName extends JPanel {

    int height = (int) (ActionHandler.height() * ((double) 1/50));

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.setSize(new Dimension(0,0));
        return size;
    }

    public SystemName(String text) {

        JLabel name = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D)g;

                g2d.setFont(new Font("TimesRoman", Font.PLAIN, height));
                g2d.addRenderingHints(Constraints.FontHints());

                g2d.drawString(text,0,(int) (height*1.15));

                super.paintComponent(g);
                g2d.dispose();
            }
        };

        setBorder(BorderFactory.createEmptyBorder(5, height, 5, 5));
        setLayout(new GridBagLayout());

        Constraints.add(this, name,      0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1, 1);
    }
}
