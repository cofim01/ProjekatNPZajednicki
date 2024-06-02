package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja jednog clana biblioteke u bazi podataka. Svaki clan ima id, ime,
 * prezime, adresu, broj telefona, email, status i administratora(korisnik) koji
 * je kreirao tog clana.
 *
 * @author Filip Mrdak
 */
public class Clan implements OpstiDomenskiObjekat {

    /**
     * id clana biblioteke kao int.
     */
    private int clanId;
    /**
     * Ime clana biblioteke kao String.
     */
    private String ime;
    /**
     * Prezime clana biblioteke kao String.
     */
    private String prezime;
    /**
     * Adresa clana biblioteke kao String.
     */
    private String adresa;
    /**
     * Broj telefona clana biblioteke kao String.
     */
    private String brTelefona;
    /**
     * Email clana biblioteke kao String.
     */
    private String email;
    /**
     * Status clana biblioteke kao String.
     */
    private String status;
    /**
     * Korsnik administrator koji je kreirao clana biblioteke.
     */
    private Korisnik korisnik;

    /**
     * Podrazumevani konstruktor koji vraca novi objekat klase Clan.
     */
    public Clan() {
    }

    /**
     * Parametrizovani konstruktor koji postavlja atribute klase Clan na unete
     * vrednosti i vraca novog clana sa unetim vrednostima.
     *
     * @param clanId - id novog clana biblioteke kao int.
     * @param ime - ime novog clana biblioteke kao String.
     * @param prezime - prezime novog clana biblioteke kao String.
     * @param adresa - adresa novog clana biblioteke kao String.
     * @param brTelefona - broj telefona novog clana biblioteke kao String.
     * @param korisnik - korisnik koji je kreirao clana biblioteke.
     */
    public Clan(int clanId, String ime, String prezime, String adresa,
            String brTelefona, Korisnik korisnik) {
        setClanId(clanId);
        setIme(ime);
        setPrezime(prezime);
        setAdresa(adresa);
        setBrTelefona(brTelefona);
        setKorisnik(korisnik);
    }

    /**
     * Postavlja id clana na unetu vrednost.
     *
     * @param clanId - id clana kao int.
     */
    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    /**
     * Postavlja ime clana na unetu vrednost.
     *
     * @param ime - ime clana kao String.
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Postavlja prezime clana na unetu vrednost.
     *
     * @param prezime - prezime clana kao String.
     */
    public void setPrezime(String prezime) {
        if (prezime.isEmpty()) {
            throw new IllegalArgumentException("Prezime clana ne sme biti prazan string");
        }
        this.prezime = prezime;
    }

    /**
     * Postavlja adresu clana na unetu vrednost. Prosledjena adresa ne sme biti
     * prazan String.
     *
     * @param adresa - adresa clana kao String.
     * @throws IllegalAccessException - ako je prosledjena adresa prazan String.
     */
    public void setAdresa(String adresa) {
        if (adresa.isEmpty()) {
            throw new IllegalArgumentException("Adresa clana ne sme biti prazan string");
        }
        this.adresa = adresa;
    }

    /**
     * Postavlja broj telefona clana na unetu vrednost. Prosledjen broj telefona
     * ne sme biti prazan String.
     *
     * @param brTelefona - broj telefona clana kao String.
     * @throws IllegalAccessException - ako je prosledjen broj telefona prazan
     * String.
     */
    public void setBrTelefona(String brTelefona) {
        if (brTelefona.isEmpty()) {
            throw new IllegalArgumentException("Broj telefona clana ne sme biti prazan string");
        }
        this.brTelefona = brTelefona;
    }

    /**
     * Postavlja korisnika administratora koji je kreirao datog clana
     * biblioteke. Prosledjeni administrator ne sme biti null.
     *
     * @param korisnik - administrator koji je kreirao datog clana biblioteke.
     * @throws NullPointerException - ako je prosledjeni administrator null.
     */
    public void setKorisnik(Korisnik korisnik) {
        if (korisnik == null) {
            throw new NullPointerException("Korisnik ne sme biti null");
        }
        this.korisnik = korisnik;
    }

    /**
     * Postavlja email clana na unetu vrednost. Prosledjeni email clana ne sme
     * biti prazan String.
     *
     * @param email - email clana kao String.
     * @throws IllegalAccessException - ako je prosledjen email clana prazan
     * String.
     */
    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email clana ne sme biti prazan string");
        }
        this.email = email;
    }

    /**
     * Postavlja status clana na unetu vrednost. Prosledjeni status clana ne sme
     * biti prazan String.
     *
     * @param status - status clana kao String.
     * @throws IllegalAccessException - ako je prosledjeni status clana prazan
     * String.
     */
    public void setStatus(String status) {
        if (status.isEmpty()) {
            throw new IllegalArgumentException("Status clana ne sme biti prazan string");
        }
        this.status = status;
    }

    /**
     * Vraca id clana biblioteke.
     *
     * @return id clana kao int.
     */
    public int getClanId() {
        return clanId;
    }

    /**
     * Vraca ime clana biblioteke.
     *
     * @return ime clana kao String.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Vraca prezime clana biblioteke.
     *
     * @return prezime clana kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Vraca adresu clana biblioteke.
     *
     * @return adresa clana kao String.
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Vraca broj telefona clana biblioteke.
     *
     * @return broj telefona clana kao String.
     */
    public String getBrTelefona() {
        return brTelefona;
    }

    /**
     * Vraca korsnika koji je kreirao datog clana biblioteke.
     *
     * @return korsnik koji je kreirao clana.
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Vraca email clana biblioteke.
     *
     * @return email clana kao String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Vraca status clana biblioteke.
     *
     * @return status clana kao String.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Vraca string sa informacijama o imenu i prezimenu clana biblioteke.
     *
     */
    @Override
    public String toString() {
        return ime + prezime;
    }

    @Override
    public String getNazivTabele() {
        return "clan";
    }

    @Override
    public String getAlijas() {
        return "c";
    }

    @Override
    public String getKoloneZaDodavanje() {
        return "(Ime,Prezime,Adresa,BrojTelefona,Email,Status,KorisnikId)";
    }

    @Override
    public String join() {
        return "JOIN korisnik k ON(c.KorisnikId=k.KorisnikId)";
    }

    @Override
    public String getKriterijum() {
        return "WHERE c.Ime LIKE '%" + ime + "%' AND c.Prezime LIKE '%" + prezime + "%'";
    }

    @Override
    public String vrednostiZaDodavanje() {
        return "'" + ime + "','" + prezime + "','" + adresa + "','" + brTelefona + "','" + email + "','" + status + "','" + korisnik.getKorisnikId() + "'";
    }

    @Override
    public String vrednostiZaAzuriranje() {
        return "Adresa='" + adresa + "', BrojTelefona='" + brTelefona + "', Email='" + email + "', Status='" + status + "'";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Clan c = new Clan();
            c.setClanId(rs.getInt("c.ClanId"));
            c.setIme(rs.getString("c.Ime"));
            c.setPrezime(rs.getString("c.Prezime"));
            c.setBrTelefona(rs.getString("c.BrojTelefona"));
            c.setAdresa(rs.getString("c.Adresa"));
            c.setEmail(rs.getString("c.Email"));
            c.setStatus(rs.getString("c.Status"));

            Korisnik k = new Korisnik();
            k.setKorisnikId(rs.getInt("k.KorisnikId"));
            k.setIme(rs.getString("k.Ime"));
            k.setPrezime(rs.getString("k.Prezime"));
            k.setPassword(rs.getString("k.Password"));

            c.setKorisnik(k);
            lista.add(c);

        }
        rs.close();
        return lista;
    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "ClanId=" + clanId;
    }

}
