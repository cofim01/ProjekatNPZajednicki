package rs.ac.bg.fon.projekatzajednickimvn.komunikacija;

import java.io.Serializable;

/**
 * Enumeracija koja sadrzi moguce operacije koje se mogu izvrsiti u sistemu biblioteke.
 * Ove operacije se koriste za komunikaciju izmedju korisnickog interfejsa i serverske logike.
 * Svaka operacija ima svoju jedinstvenu vrednost koja se koristi za identifikaciju.
 * 
 * @author Filip Mrdak
 */
public enum Operacije implements Serializable{
    /**
    *Operacija za prijavljivanje korisnika
    */
    LOGOVANJE,
    /**
    *Operacija za dodavanje nove knjige u sistem
    */
    DODAJ_KNJIGU,
    /**
    *Operacija za dobijanje svih knjiga iz sistema
    */
    VRATI_SVE_KNJIGE,
    /**
    *Operacija za brisanje knjige iz sistema
    */
    OBRSI_KNJIGU,
    /**
    *Operacija za dodavanje novog clana u sistem
    */
    DODAJ_CLANA,
    /**
    *Operacija za azuriranje podataka o clanu
    */
    AZURIRAJ_CLANA,
    /**
    *Operacija za dobijanje svih clanova iz sistema
    */
    VRATI_SVE_CLANOVE,
    /**
    *Operacija za dobijanje svih zanrova knjiga iz sistema
    */
    VRATI_SVE_ZANROVE,
    /**
    *Operacija za dobijanje svih izdavaca knjiga iz sistema
    */
    VRATI_SVE_IZDAVACE,
    /**
    *Operacija za dobijanje svih autora knjiga iz sistema
    */
    VRATI_SVE_AUTORE,
    /**
    *Operacija za dodavanje novog zaduzenja (iznajmljivanje knjige)
    */
    DODAJ_ZADUZENJE,
    /**
    *Operacija za razduzivanje (vracanje) knjige
    */
    RAZDUZI,
    /**
    *Operacija za dodavanje autora knjige
    */
    DODAJ_AUTORE_KNJIGE,        
    /**
     *Operacija za dobijanje svih autora knjige iz sistema
     */
    VRATI_SVE_AUTORE_KNJIGE,
    /**
     * Operacija za dobijanje svih zaduzenja (iznajmljivanja) iz sistema
     */
    VRATI_SVA_ZADUZENJA,
    /**
     * Operacija za dobijanje svih primeraka knjiga iz sistema
     */
    VRATI_SVE_PRIMERKE,
    /**
     * Operacija za dodavanje novog primerka knjige u sistem
     */ 
    DODAJ_PRIMERAK,
    /**
     * Operacija za izmenu podataka o primerku knjige
     */
    IZMENI_PRIMERAK,
    /**
     * Operacija za pretragu clanova po odredjenom uslovu
     */
    VRATI_CLANOVE_SA_USLOVOM,
    /**
     * Operacija za pretragu knjiga po odredjenom uslovu
     */ 
    VRATI_KNJIGE_SA_USLOVOM,
    /**
     * Operacija za odjavljivanje korisnika iz sistema
     */
    ODJAVA;                      
}
