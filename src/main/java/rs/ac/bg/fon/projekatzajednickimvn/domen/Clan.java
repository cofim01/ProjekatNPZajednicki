package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MRDAK-PC
 */
public class Clan implements OpstiDomenskiObjekat {

    private int clanId;
    private String ime;
    private String prezime;
    private String adresa;
    private String brTelefona;
    private String email;
    private String status;
    private Korisnik korisnik;

    public Clan() {
    }

    public Clan(int clanId, String ime, String prezime, String adresa,
            String brTelefona, Korisnik korisnik) {
        this.clanId = clanId;
        this.ime = ime;
        this.prezime = prezime;
        this.adresa = adresa;
        this.brTelefona = brTelefona;
        this.korisnik = korisnik;
    }

    public void setClanId(int clanId) {
        this.clanId = clanId;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setBrTelefona(String brTelefona) {
        this.brTelefona = brTelefona;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getClanId() {
        return clanId;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getBrTelefona() {
        return brTelefona;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public String getEmail() {
        return email;
    }

    public String getStatus() {
        return status;
    }

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
        return "Adresa='" + adresa + "', BrojTelefona='" + brTelefona + "', Email='" + email + "', Status='" + status+ "'";
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
