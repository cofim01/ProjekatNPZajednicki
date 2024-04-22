package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MRDAK-PC
 */
public class Zanr implements OpstiDomenskiObjekat {

    private int zanrId;
    private String naziv;

    public Zanr() {
    }

    public Zanr(int zanrId, String naziv) {
        this.zanrId = zanrId;
        this.naziv = naziv;
    }

    public void setZanrId(int zanrId) {
        this.zanrId = zanrId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getZanrId() {
        return zanrId;
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
