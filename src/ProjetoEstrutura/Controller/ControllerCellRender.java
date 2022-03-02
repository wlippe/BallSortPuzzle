package ProjetoEstrutura.Controller;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Controlador de Renderização das Celulas da Tabela
 * @package Controller
 * @author Walter Felipe Bachmann
 * @since Dezembro/2021
 */
public class ControllerCellRender extends DefaultTableCellRenderer {

    public ControllerCellRender() {}

    @Override
    protected void setValue(Object value) {
        if (value instanceof ImageIcon) {
            if (value != null) {
                ImageIcon imagem = (ImageIcon) value;
                setIcon(imagem);
            }
            else {
                setText("");
                setIcon(null);
            }
        }
        else {
            super.setValue(value);
        }
    }

}