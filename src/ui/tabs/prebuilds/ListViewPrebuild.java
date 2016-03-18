package ui.tabs.prebuilds;


import models.System;
import ui.logic.ActionHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListViewPrebuild extends JList {

    static boolean isSelected;
    static Point point;

    static boolean gS = false;
    static int in0;
    static int in1;

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        Dimension size = super.getPreferredScrollableViewportSize();
        size.setSize(new Dimension(0,0));
        return size;
    }

    public ListViewPrebuild(ArrayList<System> items) {

        DefaultListModel<System> list = new DefaultListModel<System>();

        for (System item : items) {
            list.addElement(item);
        }

        this.setSelectionModel(new DefaultListSelectionModel() {

            boolean gestureStarted = false;

            @Override
            public void setSelectionInterval(int index0, int index1) {
                gS = gestureStarted;
                in0 = index0;
                in1 = index1;

                gestureStarted = true;
            }

            @Override
            public void setValueIsAdjusting(boolean isAdjusting) {
                if (!isAdjusting) {
                    gestureStarted = false;
                }
            }

        });

        ListSelectionModel selectionModel = this.getSelectionModel();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                point = e.getPoint();
                isSelected = ActionHandler.mouseClickedPrebuild(point);

                if(!gS && isSelected){
                    if (isSelectedIndex(in0)) {
                        selectionModel.removeSelectionInterval(in0, in1);
                    } else {
                        selectionModel.addSelectionInterval(in0, in1);
                    }
                    //ActionHandler.AddOrRemoveItem(list.get(getSelectedIndex()));
                }
            }
        });

        setModel(list);
        setCellRenderer(new ListModelPrebuild());
    }
}
