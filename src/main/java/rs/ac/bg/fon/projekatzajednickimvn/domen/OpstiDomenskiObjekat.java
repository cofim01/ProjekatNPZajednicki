package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;


/**
 * Inteface koga nasledjuju sve domenske klase.
 * Definise metode za rad sa bazom podataka.
 * Pozivanjem odgovarajucih metoda se kreiraju upiti nad bazom podataka.
 * Nasledjuje inteface Serializable kako bi domenski objekti mogli da se salju kroz mrezu. 
 * @author Filip Mrdak
 */
public interface OpstiDomenskiObjekat extends Serializable {
    /**
     * Vraca naziv tabele u bazi podataka koji odgovara datom domenskom objektu.
     * @return naziv tabele u bazi kao String.
     */
    public String getNazivTabele();
    /**
     * Vraca alijas za tabelu u bazi podataka koji se koristi kao indetifikator u upitu.
     * @return alijas tabele kao String.
     */
    public String getAlijas();

    /**
     * Vraca nazive kolona koje se koriste prilikom dodavanja novih redova u bazi podataka.
     * @return niz kolona za dodavanje kao String.
     */
    public String getKoloneZaDodavanje();
    /**
     * Vraca deo upita koji se koristi za spajanje sa drugim tabelama u bazi.
     * @return deo upita za spajanje kao String.
     */
    public String join();
    /**
     * Vraca vrednost primeranog kljuca trenutnog objekta.
     * @return primarni kljuc objekta kao String.
     */
    public String getVrednostPrimarniKljuc();
    /**
     * Vraca kriterijum prema kom se pretrazuju podaci iz baze.
     * @return kriterijum kao String.
     */
    public String getKriterijum();
    /**
     * Vraca niz vrednosti koje se koriste prilikom dodavanja novog reda u bazi podataka. 
     * @return vrednosti za dodavanje kao String. 
     */
    public String vrednostiZaDodavanje();
    /**
     * Vraca niz vrednosti koje se koriste prilikom azuriranja odredjenog reda u bazi podataka.
     * @return vrednosti za azuriranje kao String.
     */
    public String vrednostiZaAzuriranje();
    /**
     * Vraca listu sa odredjenim domenskim objektima na osnovu prosledjenog ResultSeta.
     * @param rs - ResaltSet koji se prosledjuje.
     * @return - lista sa opstim domenskim objektima (ArrayList).
     * @throws SQLException - ukoliko dodje do greske prilikom citanja ResultSeta.
     */
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException;

}
