package rs.ac.bg.fon.projekatzajednickimvn.komunikacija;

import java.io.Serializable;

/**
 *
 * @author MRDAK-PC
 */
public enum Operacije implements Serializable{
    LOGOVANJE,
    DODAJ_KNJIGU,
    VRATI_SVE_KNJIGE,
    OBRSI_KNJIGU,
    DODAJ_CLANA,
    AZURIRAJ_CLANA,
    VRATI_SVE_CLANOVE,
    VRATI_SVE_ZANROVE,
    VRATI_SVE_IZDAVACE,
    VRATI_SVE_AUTORE,
    DODAJ_ZADUZENJE,
    RAZDUZI,
    DODAJ_AUTORE_KNJIGE,
    VRATI_SVE_AUTORE_KNJIGE,
    VRATI_SVA_ZADUZENJA,
    VRATI_SVE_PRIMERKE,
    DODAJ_PRIMERAK,
    IZMENI_PRIMERAK,
    VRATI_CLANOVE_SA_USLOVOM,
    VRATI_KNJIGE_SA_USLOVOM,
    ODJAVA;
}
