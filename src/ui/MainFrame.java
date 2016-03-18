package ui;

import ui.logic.ActionHandler;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MainFrame extends JFrame {

    public MainFrame() throws HeadlessException {
        super("Electro™");
        URL iconURL = getClass().getResource("/ui/pictures/logo.png");
        ImageIcon img = new ImageIcon(iconURL);
        setIconImage(img.getImage());
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension((int)(ActionHandler.width()*0.4),(int)(ActionHandler.height()*0.7)));
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout());
        setResizable(false);
    }
}
