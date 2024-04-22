package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MRDAK-PC
 */
public class Izdavac implements OpstiDomenskiObjekat {

    private int izdavacId;
    private String naziv;

    public Izdavac() {
    }

    public Izdavac(int izdavacId, String naziv) {
        this.izdavacId = izdavacId;
        this.naziv = naziv;
    }

    public void setIzdavacId(int izdavacId) {
        this.izdavacId = izdavacId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getIzdavacId() {
        return izdavacId;
    }

    public String getNaziv() {
        return naziv;
    }

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
