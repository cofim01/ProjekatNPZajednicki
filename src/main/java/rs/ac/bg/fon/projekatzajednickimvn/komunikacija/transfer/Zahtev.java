
package rs.ac.bg.fon.projekatzajednickimvn.komunikacija.transfer;

import java.io.Serializable;
import rs.ac.bg.fon.projekatzajednickimvn.komunikacija.Operacije;

/**
 *
 * @author MRDAK-PC
 */
public class Zahtev implements Serializable{

    private Operacije operacija;
    private Object podaci;

    public Zahtev() {
    }

    public Zahtev(Operacije operacija, Object podaci) {
        this.operacija = operacija;
        this.podaci = podaci;
    }

    public Operacije getOperacija() {
        return operacija;
    }

    public Object getPodaci() {
        return podaci;
    }

    public void setOperacija(Operacije operacija) {
        this.operacija = operacija;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

}
