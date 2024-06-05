import javax.swing.*;
import java.awt.*;

public class BotaoRedondo extends JButton {

    public BotaoRedondo(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(new Color(58, 58, 58));
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }


    public boolean contains(int x, int y) {
        return new Rectangle(0, 0, getWidth(), getHeight()).contains(x, y);
    }
}
