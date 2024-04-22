package rs.ac.bg.fon.projekatzajednickimvn.komunikacija.transfer;

import java.io.Serializable;
import rs.ac.bg.fon.projekatzajednickimvn.komunikacija.StatusOdgovora;

/**
 *
 * @author MRDAK-PC
 */
public class Odgovor implements Serializable{

    private Object podaci;
    private StatusOdgovora status;
    private Exception greska;

    public Odgovor(Object podaci, StatusOdgovora status, Exception greska) {
        this.podaci = podaci;
        this.status = status;
        this.greska = greska;
    }

    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }

    public void setGreska(Exception greska) {
        this.greska = greska;
    }

    public Object getPodaci() {
        return podaci;
    }

    public StatusOdgovora getStatus() {
        return status;
    }

    public Exception getGreska() {
        return greska;
    }

    

}
