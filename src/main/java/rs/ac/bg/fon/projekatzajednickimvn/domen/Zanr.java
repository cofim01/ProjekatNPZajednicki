package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja jedan zanr knjige u bazi podataka.
 * Zanr ima svoj id i naziv.
 * @author Filip Mrdak
 */
public class Zanr implements OpstiDomenskiObjekat {
    /**
     * Id zanra knjige kao int.
     */
    private int zanrId;
    /**
     * Naziv zanra knjige kao String.
     */
    private String naziv;
    /**
     * Podrazumevani konstrktor koji kreira novi zanr knjige.
     */
    public Zanr() {
    }
    /**
     * Parametrizovani konstruktor koji kreira novi zanr i postavlja vrednosti atributa zanra na unete vrednosti.
     * @param zanrId - id novog zanra knjige.
     * @param naziv - naziv novog zanra knjige.
     */
    public Zanr(int zanrId, String naziv) {
        this.zanrId = zanrId;
        this.naziv = naziv;
    }
    /**
     * Postavlja id zanra knjige na unetu vrednost.
     * @param zanrId - id zanra kao int.
     */
    public void setZanrId(int zanrId) {
        this.zanrId = zanrId;
    }
    /**
     * Postavlja naziv zanra na unetu vrednost.
     * @param naziv - naziv zanra kao String.
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    /**
     * Vraca id zanra knjige.
     * @return id zanra knjige kao int.
     */
    public int getZanrId() {
        return zanrId;
    }
    /**
     * Vraca naziv zanra knjige.
     * @return naziv zanra knjige kao String
     */
    public String getNaziv() {
        return naziv;
    }
    /**
     * Vraca string sa informacijom o nazivu zanra.
     * 
     */
    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getNazivTabele() {
        return "zanr";
    }

    @Override
    public String getAlijas() {
        return "z";
    }

    @Override
    public String getKoloneZaDodavanje() {
        return "(Naziv)";
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
            Zanr z = new Zanr();
            z.setZanrId(rs.getInt("ZanrId"));
            z.setNaziv(rs.getString("Naziv"));
            lista.add(z);

        }
        rs.close();
        return lista;
    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "ZanrId=" + zanrId;
    }

}
