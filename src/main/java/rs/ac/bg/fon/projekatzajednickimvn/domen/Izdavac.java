package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja jednog izdavaca knjige u bazi podataka.
 * Izdavac ima svoj id i naziv.
 * @author Filip Mrdak
 */
public class Izdavac implements OpstiDomenskiObjekat {
    /**
     * Id izadavaca knjige kao int.
     */
    private int izdavacId;
    /**
     * Naziv izdavaca knjige kao String.
     */
    private String naziv;
    /**
     * Podrazumevani konstruktor koji kreira novog Izdavaca.
     */
    public Izdavac() {
    }
    /**
     * Parametrizovan konstruktor koji kreira novog izdavaca i postavlja vrednosti atributa (izdavacId, naziv) na unete vrednosti.
     * @param izdavacId - id izdavaca kao int.
     * @param naziv -  naziv izdavaca kao String.
     */
    public Izdavac(int izdavacId, String naziv) {
        this.izdavacId = izdavacId;
        this.naziv = naziv;
    }
    /**
     * Postavlja id izadavaca na unetu vrednost.
     * @param izdavacId - id izdavaca kao int.
     */
    public void setIzdavacId(int izdavacId) {
        this.izdavacId = izdavacId;
    }
    /**
     * Postavlja naziv izdavaca na unetu vrednost.
     * @param naziv - naziv izdavaca kao String.
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    /**
     * Vraca id izdavaca knjige.
     * @return id izdavaca kao int.
     */
    public int getIzdavacId() {
        return izdavacId;
    }
    /**
     * Vraca naziv izdavaca knjige.
     * @return naziv izdavaca kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Vraca string sa informacijama o nazivu izdavaca.
     * 
     */
    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getNazivTabele() {
        return "izdavac";
    }

    @Override
    public String getAlijas() {
        return "i";
    }

    @Override
    public String getKoloneZaDodavanje() {
        return "";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public String getKriterijum() {
        return "";
    }

    @Override
    public String vrednostiZaDodavanje() {
        return "";
    }

    @Override
    public String vrednostiZaAzuriranje() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Izdavac i = new Izdavac();
            i.setIzdavacId(rs.getInt("IzdavacId"));
            i.setNaziv(rs.getString("Naziv"));

            lista.add(i);

        }
        rs.close();
        return lista;
    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "";
    }

}
