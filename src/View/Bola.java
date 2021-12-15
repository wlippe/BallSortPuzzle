package View;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Bola extends JPanel {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void Bola(int id) {
        
    }

    @Override
    public void paintComponent(Graphics grafico) {
        grafico.setColor(Color.red);
        grafico.fillOval(50, 50, 100, 100);
    }

}