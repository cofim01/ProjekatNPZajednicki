package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author MRDAK-PC
 */
public class Korisnik implements OpstiDomenskiObjekat {

    private int korisnikId;
    private String ime;
    private String prezime;
    private String password;

    public Korisnik() {
    }

    public Korisnik(int korisnikId, String ime, String prezime, String password) {
        this.korisnikId = korisnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.password = password;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKorisnikId() {
        return korisnikId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getPassword() {
        return password;
    }
    
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
