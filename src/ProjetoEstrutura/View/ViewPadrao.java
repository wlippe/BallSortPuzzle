package ProjetoEstrutura.View;

import javax.swing.JTable;
import ProjetoEstrutura.Controller.ControllerPrincipal;
import javax.swing.ImageIcon;

public abstract class ViewPadrao extends javax.swing.JFrame {
    
    ControllerPrincipal controller;

    abstract public JTable getTableTubosEnsaio();

    protected void initComponentsPadrao() {
        this.setLocationRelativeTo(null);
        this.setAppIcon();
    }

    protected void setAppIcon() {
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/ProjetoEstrutura/View/imagens/icon.png"));
        setIconImage(icon.getImage());
    }

    public void setController(ControllerPrincipal controller) {
        this.controller = controller;
    }

}