package Controller;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author wlipp
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
