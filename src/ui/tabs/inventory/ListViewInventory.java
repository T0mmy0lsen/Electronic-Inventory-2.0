package ui.tabs.inventory;

import models.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class ListViewInventory extends JList{

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        Dimension size = super.getPreferredScrollableViewportSize();
        size.setSize(new Dimension(0,0));
        return size;
    }

    public ListViewInventory(ArrayList<System> items) {
        DefaultListModel<System> list = new DefaultListModel<>();

        for (System item : items) {
            list.addElement(item);
        }

        setModel(list);
        setCellRenderer(new ListModelInventory());
    }
}
