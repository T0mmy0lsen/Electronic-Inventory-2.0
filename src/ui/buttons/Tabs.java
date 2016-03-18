package ui.buttons;

import ui.logic.ActionHandler;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.Buffer;

public class Tabs extends JButton implements ActionListener{

    final int tab_number;
    final String picture;

    BufferedImage scaledImage;

    public Tabs(int tab_number, String picture) {
        this.tab_number = tab_number;
        this.picture = picture;
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ActionHandler.tabClicked(tab_number);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        //g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        //g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        //g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        URL url = getClass().getResource("/ui/pictures/" + picture + ".png");
        try {
            BufferedImage img = ImageIO.read(url);

            double widthScaleFactor = getWidth() / (double)img.getWidth();
            double heightScaleFactor = getHeight() / (double)img.getHeight();
            double scaleFactor = (widthScaleFactor > heightScaleFactor)? heightScaleFactor : widthScaleFactor;

            AffineTransform at = new AffineTransform();
            at.scale(scaleFactor, scaleFactor);

            AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            scaledImage = scaleOp.filter(img, null);
            repaint();

            g2d.drawImage(scaledImage, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2d.dispose();
    }
}
