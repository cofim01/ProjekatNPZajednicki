package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Predstavlja jedan primerak knjige u bazi podataka.
 *
 * @author Filip Mrdak
 */
public class PrimerakKnjige implements OpstiDomenskiObjekat {

    /**
     * Id primerka knjige kao int.
     */
    private int primerakId;
    /**
     * Broj police na kojoj se nalazi primerak knjige kao int.
     */
    private int brojPolice;
    /**
     * Izdavac primerka knjige.
     */
    private Izdavac izdavac;
    /**
     * Knjiga za koju je vezan primerak.
     */
    private Knjiga knjiga;
    /**
     * Godina izdanja primerka knjige kao int.
     */
    private int godinaIzdanja;
    /**
     * Status primerka knjige u biblioteci.
     */
    private String status;

    /**
     * Podrazumevani konstruktor koji kreira novi primerak knjige.
     */
    public PrimerakKnjige() {
    }

    /**
     * Parametrizovani konstruktor koji kreira novi primerak knjige i postavlja
     * atribute primerka na unete vrednosti.
     *
     * @param primerakId - id primerka knjige.
     * @param brojPolice - broj police na kojoj se nalazi primerak knjige.
     * @param izdavac - izdavac primerka knjige.
     * @param godinaIzdanja - godina izdanja primerka knjige.
     * @param status - status primerka knjige u biblioteci.
     */
    public PrimerakKnjige(int primerakId, int brojPolice, Izdavac izdavac, int godinaIzdanja, String status) {
        setPrimerakId(primerakId);
        setBrojPolice(brojPolice);
        setIzdavac(izdavac);
        setGodinaIzdanja(godinaIzdanja);
        setStatus(status);
    }

    /**
     * Vraca id primerka knjige.
     *
     * @return id primerka knjige kao int.
     */
    public int getPrimerakId() {
        return primerakId;
    }

    /**
     * Vraca broj police na kojoj se nalazi primerak knjige.
     *
     * @return broj police kao int.
     */
    public int getBrojPolice() {
        return brojPolice;
    }

    /**
     * Vraca izdavaca primerka knjige.
     *
     * @return izdavac primerka knjige.
     */
    public Izdavac getIzdavac() {
        return izdavac;
    }

    /**
     * Vraca godinu izdanja primerka knjige.
     *
     * @return godina izdanja primerka knjige.
     */
    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    /**
     * Vraca status primerka knjige.
     *
     * @return status primerka knjige kao String.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Vraca knjigu za koju je vezan primerak knjige.
     *
     * @return knjiga za koju je vezan primerak knjige.
     */
    public Knjiga getKnjiga() {
        return knjiga;
    }

    /**
     * Postavlja id primerka knjige na unetu vrednost.
     *
     * @param primerakId - id primerka knjige kao int.
     */
    public void setPrimerakId(int primerakId) {
        this.primerakId = primerakId;
    }

    /**
     * Postavlja broj police na kojoj se nalazi primerak knjige na unetu
     * vrednost. Prosledjeni broj police mora biti broj veci od 0.
     *
     * @param brojPolice - broj police kao int.
     * @throws IllegalArgumentException - ukoliko je broj police manji 1.
     */
    public void setBrojPolice(int brojPolice) {
        if (brojPolice < 1) {
            throw new IllegalArgumentException("Broj police mora biti veci od 0");
        }
        this.brojPolice = brojPolice;
    }

    /**
     * Postavlja izdavaca primerka knjige na unetu vrednost. Prosledjeni izdavac
     * ne sme biti null.
     *
     * @param izdavac - izdavac primerka knjige.
     * @throws NullPointerException - ukoliko je prosledjeni izdavac null.
     */
    public void setIzdavac(Izdavac izdavac) {
        if (izdavac == null) {
            throw new NullPointerException("Izdavac primerka knjige ne sme biti null");
        }
        this.izdavac = izdavac;
    }

    /**
     * Postavlja godinu izdanja primerka knjige.
     *
     * @param godinaIzdanja - godina izdanja primerka knjige kao int.
     */
    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    /**
     * Postavlja status primerka knjige na unetu vrednost.
     *
     * @param status - status primerka knjige kao String.
     */
    public void setStatus(String status) {
        this.status = status;

    }

    /**
     * Postavlja knjigu za koju je vezan primerak na unetu knjigu. Prosledjena
     * knjiga ne sme biti null.
     *
     * @param knjiga - knjiga za koju je vezan primerak.
     * @throws NullPointerException - ukoliko je prosledjena knjiga null.
     */
    public void setKnjiga(Knjiga knjiga) {
        if (knjiga == null) {
            throw new NullPointerException("Knjiga ne sme biti null");
        }
        this.knjiga = knjiga;
    }

    @Override
    public String getNazivTabele() {
        return "primerakKnjige";
    }

    @Override
    public String getAlijas() {
        return "pk";
    }

    @Override
    public String getKoloneZaDodavanje() {
        return "(idKnjiga,brojPolice,godinaIzdanja,idIzdavac,status)";
    }

    @Override
    public String join() {
        return "JOIN knjiga k ON(pk.idKnjiga=k.KnjigaId)"
                + "JOIN zanr z ON(k.ZanrId=z.ZanrId)"
                + "JOIN korisnik ko ON (k.KorisnikId=ko.KorisnikId)"
                + "JOIN izdavac i ON(pk.idIzdavac=i.IzdavacId)";

    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "idPrimerak=" + primerakId;
    }

    @Override
    public String getKriterijum() {
        return "WHERE idKnjiga=" + knjiga.getKnjigaId();
    }

    @Override
    public String vrednostiZaDodavanje() {
        return "'" + knjiga.getKnjigaId() + "','" + brojPolice + "','" + godinaIzdanja + "','" + izdavac.getIzdavacId() + "','" + status + "'";
    }

    @Override
    public String vrednostiZaAzuriranje() {
        return "status='" + status + "'";
    }

    @Override
    public String toString() {
        return primerakId + "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            PrimerakKnjige primerak = new PrimerakKnjige();
            primerak.setPrimerakId(rs.getInt("pk.idPrimerak"));
            primerak.setBrojPolice(rs.getInt("pk.brojPolice"));
            primerak.setGodinaIzdanja(rs.getInt("pk.godinaIzdanja"));
            primerak.setStatus(rs.getString("pk.status"));

            Knjiga k = new Knjiga();
            k.setKnjigaId(rs.getInt("k.KnjigaId"));
            k.setNaziv(rs.getString("k.Naziv"));

            Zanr z = new Zanr();
            z.setNaziv(rs.getString("z.Naziv"));
            z.setZanrId(rs.getInt("ZanrId"));
            k.setZanr(z);

            Izdavac i = new Izdavac();
            i.setIzdavacId(rs.getInt("i.IzdavacId"));
            i.setNaziv(rs.getString("i.Naziv"));
            primerak.setIzdavac(i);

            Korisnik ko = new Korisnik();
            ko.setKorisnikId(rs.getInt("ko.KorisnikId"));
            ko.setIme(rs.getString("ko.Ime"));
            ko.setPrezime(rs.getString("ko.Prezime"));
            ko.setPassword(rs.getString("ko.Password"));
            k.setKorisnik(ko);
            primerak.setKnjiga(k);

            lista.add(primerak);

        }
        rs.close();
        return lista;
    }

}
