package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * @author wlippe
 */
public class Painel extends JPanel {

    @Override
    public void paintComponent(Graphics grafico) {
        grafico.setColor(Color.white);
        grafico.fillRect(0, 0, 800, 300);
    }

}
