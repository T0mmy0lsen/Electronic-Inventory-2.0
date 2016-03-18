package ui.buttons;

import ui.logic.ActionHandler;
import ui.logic.Constraints;

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

public class TabCart extends JButton implements ActionListener{

    final int tab_number;
    int number = 0;
    int height;

    public TabCart(int tab_number) {
        this.tab_number = tab_number;
        this.height = ActionHandler.height();
        addActionListener(this);
        setFont(new Font("TimesRoman", Font.BOLD, (int)(height* ((double) 1/70))));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ActionHandler.tabClicked(tab_number);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        setBackground(Color.WHITE);
        g2d.setColor(Color.WHITE);
        g2d.addRenderingHints(Constraints.FontHints());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        URL url = getClass().getResource("/ui/pictures/chrome.png");
        URL url2 = getClass().getResource("/ui/pictures/cart.png");

        repaint();

        try {
            g2d.drawImage(drawImg(url), 0, 0, null);
            g2d.drawImage(drawImg(url2), (int)(height*.03), 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g2d.drawString("" + number + " items",(int) (height*0.11),(int) (height*0.025));
        g2d.drawString("1000 kr.",(int) (height*0.11),(int) (height*0.045));
        g2d.dispose();
    }

    public BufferedImage drawImg(URL url) throws IOException {
        BufferedImage img = ImageIO.read(url);

        double widthScaleFactor = getWidth() / (double)img.getWidth();
        double heightScaleFactor = getHeight() / (double)img.getHeight();
        double scaleFactor = (widthScaleFactor > heightScaleFactor)? heightScaleFactor : widthScaleFactor;

        AffineTransform at = new AffineTransform();
        at.scale(scaleFactor, scaleFactor);

        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);

        return scaleOp.filter(img, null);
    }
}
