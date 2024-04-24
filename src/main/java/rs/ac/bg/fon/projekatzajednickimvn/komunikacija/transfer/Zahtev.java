
package rs.ac.bg.fon.projekatzajednickimvn.komunikacija.transfer;

import java.io.Serializable;
import rs.ac.bg.fon.projekatzajednickimvn.komunikacija.Operacije;

/**
 * Predstavlja zahtev koji se salje serveru.
 * Sadrzi operaciju koju server treba da izvrsi kao i podatke za izvrsavanje operacije.
 * @author Filip Mrdak
 */
public class Zahtev implements Serializable{
    /**
     * Operacija koja se zahteva od servera.
     */
    private Operacije operacija;
    /**
     * Podaci za izvrsavanje zeljene operacije.
     */
    private Object podaci;
    /**
     * Podrazumevani konstruktor koji kreira novi zahtev.
     */
    public Zahtev() {
    }
    
    /**
     * Parametrizovani konstruktor koji kreira novi zahtev i postavlja atribute zahteva na unete vrednosti.
     * @param operacija - operacija zahteva.
     * @param podaci - podaci zahteva.
     */
    public Zahtev(Operacije operacija, Object podaci) {
        this.operacija = operacija;
        this.podaci = podaci;
    }
    /**
     * Vraca operaciju zahteva koji saljemo serveru.
     * @return operacija zahteva.
     */
    public Operacije getOperacija() {
        return operacija;
    }
    /**
     * Vraca podatke zahteva koji saljemo serveru.
     * @return podaci zahteva.
     */
    public Object getPodaci() {
        return podaci;
    }
    /**
     * Postavlja operaciju zahteva na unetu vrednost.
     * @param operacija - operacija zahteva.
     */
    public void setOperacija(Operacije operacija) {
        this.operacija = operacija;
    }
    /**
     * Postavlja podatke zahteva na unetu vrednost.
     * @param podaci - podaci zahteva.
     */
    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }

}
