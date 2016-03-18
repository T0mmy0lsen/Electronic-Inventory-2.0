package ui;

import ui.buttons.TabCart;
import ui.logic.Constraints;
import ui.buttons.Tabs;
import ui.tabs.inventory.Inventory;
import ui.tabs.prebuilds.PreBuilds;
import ui.tabs.shoppingcart.ShoppingCart;

import java.awt.*;

public class UIConstructor {

    public static MainFrame mainFrame = new MainFrame();
    public static PreBuilds prebuilds = new PreBuilds();
    public static Inventory inventory = new Inventory();
    public static ShoppingCart shoppingcart = new ShoppingCart();

    public UIConstructor() {

        MainJPanel mainJPanel = new MainJPanel();
        Tabs prebuilds_tab = new Tabs(0, "101");
        Tabs inventory_tab = new Tabs(1, "inventory");
        TabCart shoppingcart_tab = new TabCart(2);

        Constraints.add(mainJPanel, prebuilds_tab,      0,0,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.33,  0.08);
        Constraints.add(mainJPanel, inventory_tab,      1,0,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.33,  0.08);
        Constraints.add(mainJPanel, shoppingcart_tab,   2,0,1,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 0.33,  0.08);
        Constraints.add(mainJPanel, prebuilds,          0,1,3,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1,     0.92);
        Constraints.add(mainJPanel, inventory,          0,1,3,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1,     0.92);
        Constraints.add(mainJPanel, shoppingcart,       0,1,3,1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, 1,     0.92);

        mainFrame.add(mainJPanel);
    }
}
