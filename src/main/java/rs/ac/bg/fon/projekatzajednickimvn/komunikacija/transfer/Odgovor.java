package rs.ac.bg.fon.projekatzajednickimvn.komunikacija.transfer;

import java.io.Serializable;
import rs.ac.bg.fon.projekatzajednickimvn.komunikacija.StatusOdgovora;

/**
 * Predstavlja serverski odgovor na oredjeni zahtev.
 * Sadrzi podatke koje server salje kao odgovor, status kao pokazatelj uspesnosti izvrsene operacije, kao i gresku ukoliko je doslo do nje prilikom izvrsavanja odredjene operacije.
 * @author Filip Mrdak
 */
public class Odgovor implements Serializable{
    /**
     * Podaci serverskog odgovora.
     */
    private Object podaci;
    /**
     * Status serverskog odgovora.
     */
    private StatusOdgovora status;
    /**
     * Greska prilikom izvrsavanja zahteva na serveru.
     */
    private Exception greska;
    /**
     * Parametrizovani konstruktor koji kreira novi odgovor i postavlja atribute odgvora na unete vrednosti.
     * @param podaci - podaci serverskog odgovora.
     * @param status - status serverskog odgovora.
     * @param greska - greska prilikom izvrsavanja zahteva na serveru.
     */
    public Odgovor(Object podaci, StatusOdgovora status, Exception greska) {
        this.podaci = podaci;
        this.status = status;
        this.greska = greska;
    }
    /**
     * Postavlja podatke serverskog odgvora na unetu vrednost.
     * @param podaci - podaci serverskog odgovora.
     */
    public void setPodaci(Object podaci) {
        this.podaci = podaci;
    }
    /**
     * Postavlja status serverskog odgovora na unetu vrednost.
     * @param status status serverskog odgovora.
     */
    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }
    /**
     * Postavlja gresku serverskog odgovora na unetu vrednost.
     * @param greska - greska nastala prilikom izvrsavanja zahteva na serveru.
     */
    public void setGreska(Exception greska) {
        this.greska = greska;
    }
    /**
     * Vraca podatke serverskog odgovora.
     * @return podaci serverskog odgovora.
     */
    public Object getPodaci() {
        return podaci;
    }
    /**
     * Vraca status serverskog odgovora.
     * @return status serverskog odgovora.
     */
    public StatusOdgovora getStatus() {
        return status;
    }
    /**
     * Vraca gresku serverskog odgovora.
     * @return greska nastala prilikom izvrsavanja zahteva na serveru.
     */
    public Exception getGreska() {
        return greska;
    }

    

}
