package Model;

import java.util.Objects;

/**
 *
 * @author wlipp
 */
public class Bola {

    private String cor;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Bola other = (Bola) obj;

        if (this.getCor() != other.getCor()) {
            return false;
        }

        return true;
    }

}
