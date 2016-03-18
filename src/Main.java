import ui.logic.ActionHandler;
import ui.UIConstructor;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    private static UIConstructor ui;

    public static void main(String[] args) throws SQLException {
        initUI();
    }

    protected static void initUI() {
        if (ui == null) {
            SwingUtilities.invokeLater(() -> {
                ui = new UIConstructor();
            });
            // Set view on first tab.
            ActionHandler.getPrebuilds();
        } else {
            System.out.println("UI already running");
        }
    }
}