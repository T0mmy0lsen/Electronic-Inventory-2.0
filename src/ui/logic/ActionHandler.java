package ui.logic;

import ui.UIConstructor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import models.System;
import ui.tabs.inventory.ListViewInventory;
import ui.tabs.prebuilds.ListViewPrebuild;

public class ActionHandler {

    public static ListViewPrebuild prebuildList;
    public static ListViewInventory inventoryList;
    public static Rectangle bounds_pre;
    public static Point p_pre;
    public static ArrayList<Integer> selectedbuy;
    public static int thisindex;

    static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static int width = gd.getDisplayMode().getWidth();
    public static int height = gd.getDisplayMode().getHeight();

    public static int height(){
        return height;
    }
    public static int width() {
        return width;
    }

    public static void tabClicked(int tab_number) {
        if(tab_number == 0) {
            SwingUtilities.invokeLater(() -> {
                UIConstructor.prebuilds.setVisible(true);
                if(!(UIConstructor.inventory.getViewport().getView() == null)){
                    UIConstructor.inventory.getViewport().removeAll();
                }
                getPrebuilds();
            });
        }
        if(tab_number == 1) {
            SwingUtilities.invokeLater(() -> {
                UIConstructor.inventory.setVisible(true);
                if(!(UIConstructor.prebuilds.getViewport().getView() == null)){
                    UIConstructor.prebuilds.getViewport().removeAll();
                }
                getInventory();
            });
        }
        if(tab_number == 2) {
            SwingUtilities.invokeLater(() -> {
                UIConstructor.shoppingcart.setVisible(true);
                if(!(UIConstructor.prebuilds.getViewport().getView() == null) || !(UIConstructor.inventory.getViewport().getView() == null)){
                    UIConstructor.prebuilds.getViewport().removeAll();
                    UIConstructor.inventory.getViewport().removeAll();
                }
                UIConstructor.mainFrame.repaint();
            });
        }
    }

    public static void getPrebuilds() {
        new Thread(() -> {
            ArrayList<System> listSystem = new ArrayList<>();
            listSystem.add(new System(0,0,1,2,3));
            listSystem.add(new System(0,0,1,2,3));
            listSystem.add(new System(0,0,1,2,3));
            listSystem.add(new System(0,0,1,2,3));
            listSystem.add(new System(0,0,1,2,3));
            listSystem.add(new System(0,0,1,2,3));
            listSystem.add(new System(0,0,1,2,3));
            listSystem.add(new System(0,0,1,2,3));
            SwingUtilities.invokeLater(() -> {
                //String query = get query from query builder.
                //listSystem = get list from query.
                prebuildList = new ListViewPrebuild(listSystem);
                UIConstructor.prebuilds.setViewportView(prebuildList);
            });
        }).start();
    }

    public static void getInventory() {
        new Thread(() -> {
            ArrayList<System> listSystem = new ArrayList<>();
            listSystem.add(new System(0,0,0,0,0));
            listSystem.add(new System(0,0,0,0,0));
            listSystem.add(new System(0,0,0,0,0));
            listSystem.add(new System(0,0,0,0,0));
            listSystem.add(new System(0,0,0,0,0));
            listSystem.add(new System(0,0,0,0,0));
            SwingUtilities.invokeLater(() -> {
                //String query = get query from query builder.
                //listSystem = get list from query.
                inventoryList = new ListViewInventory(listSystem);
                UIConstructor.inventory.setViewportView(inventoryList);
            });
        }).start();
    }

    public static boolean mouseClickedPrebuild(Point point) {
        int index = prebuildList.locationToIndex(point);
        bounds_pre = prebuildList.getCellBounds(index,index);
        p_pre = bounds_pre.getLocation();
        return (point.getX() > (int) (bounds_pre.getWidth() * 0.785)) && (point.getX() < (int) (bounds_pre.getWidth() * 0.94)) && (point.getY() > p_pre.getY() + (int) (bounds_pre.getHeight() * 0.62)) && point.getY() < p_pre.getY() + (bounds_pre.getHeight() * 0.8);
    }
}
