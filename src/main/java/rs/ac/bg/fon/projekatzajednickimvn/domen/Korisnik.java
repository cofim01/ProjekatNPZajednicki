package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *Predstavlja jednog administratora biblioteke, koji ima svoj id, ime, prezime i password.
 * @author Filip Mrdak
 */
public class Korisnik implements OpstiDomenskiObjekat {
    /**
     * Id korisnika (administratora).
     */
    private int korisnikId;
    /**
     * Ime korisnika (administratora).
     */
    private String ime;
    /**
     * Prezime korisnika (administratora).
     */
    private String prezime;
    /**
     * Sifra korisnika (administratora).
     */
    private String password;
    /**
     * Podrazumevani konstruktor koji kreira novog korisnika.
     */
    public Korisnik() {
    }
    /**
     * Parametrizovani konstruktor koji kreira novog korisnika i postavlja vrednosti atributa na unete vrednosti.
     * @param korisnikId - id novog korisnika kao int.
     * @param ime - ime novog korisnika kao String.
     * @param prezime - prezime novog korisnika kao String.
     * @param password - sifra novog korisnika kao String.
     */
    public Korisnik(int korisnikId, String ime, String prezime, String password) {
        setKorisnikId(korisnikId);
        setIme(ime);
        setPrezime(prezime);
        setPassword(password);
    }
    /**
     * Postavlja id korisnika na unetu vrednost
     * @param korisnikId - id korisnika kao int.
     */
    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }
    /**
     * Postavlja ime korisnika na unetu vrednost.
     * @param ime - ime korisnika kao String.
     */
    public void setIme(String ime) {
        this.ime = ime;
    }
    /**
     * Postavlja prezime korisnika na unetu vrednost.
     * @param prezime - prezime korisnika kao String. 
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    /**
     * Postavlja sifru korisnika na unetu vrednost.
     * @param password - sifra korisnika kao String.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Vraca id korisnika.
     * @return id korisnika kao int.
     */
    public int getKorisnikId() {
        return korisnikId;
    }
    /**
     * Vraca ime korisnika.
     * @return ime korisnika kao String.
     */
    public String getIme() {
        return ime;
    }
    /**
     * Vraca prezime korisnika.
     * @return prezime korisnika kao String.
     */
    public String getPrezime() {
        return prezime;
    }
    /**
     * Vraca sifru korisnika.
     * @return sifra korisnika kao String.
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Vraca informacije o imenu i prezimenu korisnika (administratora).
     * 
     */
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getNazivTabele() {
        return "korisnik";
    }

    @Override
    public String getAlijas() {
        return "k";
    }

    @Override
    public String getKoloneZaDodavanje() {
        return "(Ime,Prezime,Password)";
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
        return "'" + ime + "', '" + prezime + "', '" + password + "'";
    }

    @Override
    public String vrednostiZaAzuriranje() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Korisnik k = new Korisnik();
            k.setKorisnikId(rs.getInt("KorisnikId"));
            k.setIme(rs.getString("Ime"));
            k.setPrezime(rs.getString("Prezime"));
            k.setPassword(rs.getString("Password"));
            lista.add(k);

        }
        rs.close();
        return lista;
    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

}
