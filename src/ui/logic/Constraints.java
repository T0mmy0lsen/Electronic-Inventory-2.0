package ui.logic;

import java.awt.*;
import java.util.Map;

public class Constraints {
    private static final Insets insets = new Insets(1, 1, 1, 1);

    public static void add(Container con, Component com, int x, int y, int w, int h, int a, int f, double wx, double wy) {
        GridBagConstraints gbc = new GridBagConstraints(x, y, w, h, wx, wy, a, f, insets, 0, 0);
        con.add(com, gbc);
    }

    public static Map FontHints() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        return (Map)(tk.getDesktopProperty("awt.font.desktophints"));
    }
}
