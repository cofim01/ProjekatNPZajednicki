package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Predstavlja jednog autora knjige u bazi podataka koji ima ime, prezime i id.
 *
 * @author Filip Mrdak
 */
public class Autor implements OpstiDomenskiObjekat {

    /**
     * Id autora kako int.
     */
    private int autorId;
    /**
     * Ime autora kao String.
     */
    private String ime;
    /**
     * Prezime autora kao String.
     */
    private String prezime;

    /**
     * Podrazumevani konstruktor koji vraca novi objekat klase Autor.
     *
     *
     */
    public Autor() {
    }

    /**
     * Parametrizovani konstruktor koji postavlja polja id, ime, prezime klase
     * Autor na unete vrednosti i vraca novog autora za unetim vrednostima.
     *
     * @param autorId - id novog autora kao int.
     * @param ime - ime novog autora kao String.
     * @param prezime - prezime novog autora kao String.
     */
    public Autor(int autorId, String ime, String prezime) {
        setAutorId(autorId);
        setIme(ime);
        setPrezime(prezime);

    }

    /**
     * Postavlja id autora na unetu vrednost.
     *
     * @param autorId - id novog autora kao int.
     */
    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    /**
     * Postavlja ime novog autora na unetu vrednost.
     * Prosledjeno ime autora ne sme biti prazan String.
     * 
     * @param ime - ime novog autora kao String.
     * @throws IllegalArgumentException - ako je prosledjeno ime autora prazan String.
     */
    public void setIme(String ime) {
        if(ime.isEmpty()){
            throw new IllegalArgumentException("Ime autora ne sme biti prazan string");
        }
        this.ime = ime;
    }

    /**
     * Postavlja prezime novog autora na unetu vrednost.
     * Prosledjeno prezime autora ne sme biti prazan String.
     * 
     * @param prezime - prezime novog autora kao String.
     * @throws IllegalArgumentException - ako je prosledjeno prezime autora prazan String.
     */
    public void setPrezime(String prezime) {
        if(prezime.isEmpty()){
            throw new IllegalArgumentException("Prezime autora ne sme biti prazan string");
        }
        this.prezime = prezime;
    }

    /**
     * Vraca id autora.
     *
     * @return id autora kao int.
     */
    public int getAutorId() {
        return autorId;
    }

    /**
     * Vraca ime autora.
     *
     * @return ime autora kao String.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Vraca prezime autora.
     *
     * @return prezime autora kao String.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Vraca string sa informacijama o imenu i prezimenu autora.
     *
     */
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
