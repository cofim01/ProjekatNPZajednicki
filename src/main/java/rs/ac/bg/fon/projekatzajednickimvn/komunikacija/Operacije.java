package rs.ac.bg.fon.projekatzajednickimvn.komunikacija;

import java.io.Serializable;

/**
 * Enumeracija koja sadrži moguće operacije koje se mogu izvršiti u sistemu biblioteke.
 * Ove operacije se koriste za komunikaciju između korisničkog interfejsa i serverske logike.
 * Svaka operacija ima svoju jedinstvenu vrednost koja se koristi za identifikaciju.
 * 
 * @author Filip Mrdak
 */
public enum Operacije implements Serializable{
    LOGOVANJE,                  // Operacija za prijavljivanje korisnika
    DODAJ_KNJIGU,               // Operacija za dodavanje nove knjige u sistem
    VRATI_SVE_KNJIGE,           // Operacija za dobijanje svih knjiga iz sistema
    OBRSI_KNJIGU,               // Operacija za brisanje knjige iz sistema
    DODAJ_CLANA,                // Operacija za dodavanje novog člana u sistem
    AZURIRAJ_CLANA,             // Operacija za ažuriranje podataka o članu
    VRATI_SVE_CLANOVE,          // Operacija za dobijanje svih članova iz sistema
    VRATI_SVE_ZANROVE,          // Operacija za dobijanje svih žanrova knjiga iz sistema
    VRATI_SVE_IZDAVACE,         // Operacija za dobijanje svih izdavača knjiga iz sistema
    VRATI_SVE_AUTORE,           // Operacija za dobijanje svih autora knjiga iz sistema
    DODAJ_ZADUZENJE,            // Operacija za dodavanje novog zaduženja (iznajmljivanje knjige)
    RAZDUZI,                    // Operacija za razduživanje (vraćanje) knjige
    DODAJ_AUTORE_KNJIGE,        // Operacija za dodavanje autora knjige
    VRATI_SVE_AUTORE_KNJIGE,    // Operacija za dobijanje svih autora knjige iz sistema
    VRATI_SVA_ZADUZENJA,        // Operacija za dobijanje svih zaduženja (iznajmljivanja) iz sistema
    VRATI_SVE_PRIMERKE,         // Operacija za dobijanje svih primeraka knjiga iz sistema
    DODAJ_PRIMERAK,             // Operacija za dodavanje novog primerka knjige u sistem
    IZMENI_PRIMERAK,            // Operacija za izmenu podataka o primerku knjige
    VRATI_CLANOVE_SA_USLOVOM,   // Operacija za pretragu članova po određenom uslovu
    VRATI_KNJIGE_SA_USLOVOM,    // Operacija za pretragu knjiga po određenom uslovu
    ODJAVA;                     // Operacija za odjavljivanje korisnika iz sistema
}
