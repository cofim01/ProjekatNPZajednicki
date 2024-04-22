package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MRDAK-PC
 */


public class Autor implements OpstiDomenskiObjekat {

    private int autorId;
    private String ime;
    private String prezime;

    public Autor() {
    }

    public Autor(int autorId, String ime, String prezime) {
        this.autorId = autorId;
        this.ime = ime;
        this.prezime = prezime;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getAutorId() {
        return autorId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getNazivTabele() {
        return "autor";
    }

    @Override
    public String getAlijas() {
        return "a";
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
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Autor autor = new Autor();
            autor.setAutorId(rs.getInt("autorId"));
            autor.setIme(rs.getString("ime"));
            autor.setPrezime(rs.getString("prezime"));

            lista.add(autor);

        }
        rs.close();
        return lista;

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
    public String getVrednostPrimarniKljuc() {
        return "AutorId=" + autorId;
    }

}
