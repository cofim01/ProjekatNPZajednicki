package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Predstavlja jednu knjigu u bazi podataka. Svaka knjiga ima svoj id, naziv,
 * zanr, korisnika koji je kreirao tu knjigu i listu primeraka vezanih za tu
 * knjigu.
 *
 * @author Filip Mrdak
 */
public class Knjiga implements OpstiDomenskiObjekat {

    /**
     * Id knjige kao int.
     */
    private int knjigaId;
    /**
     * Naziv knjige kao String.
     */
    private String naziv;
    /**
     * Zanr knjige.
     */
    private Zanr zanr;
    /**
     * Korsnik koji je kreirao knjigu.
     */
    private Korisnik korisnik;
    /**
     * Lista primeraka knjige (ArrayList).
     */
    private ArrayList<PrimerakKnjige> primerci = new ArrayList<>();

    /**
     * Podrazumevani konstruktor koji kreira novu knjigu.
     */
    public Knjiga() {
    }

    /**
     * Parametrizovani konstruktor koji kreira novu knjigu i postavlja vrednosti
     * atributa knjige na unete vrednosti.
     *
     * @param knjigaId - id knjige kao int.
     * @param naziv - naziv knjige kao String.
     * @param zanr - zanr knjige.
     * @param korisnik - korsnik koji je kreirao knjigu.
     */
    public Knjiga(int knjigaId, String naziv, Zanr zanr, Korisnik korisnik) {
        setKnjigaId(knjigaId);
        setNaziv(naziv);
        setZanr(zanr);
        setKorisnik(korisnik);
    }

    /**
     * Postavlja id knjige na unetu vrednost.
     *
     * @param knjigaId - id knjige kao int.
     */
    public void setKnjigaId(int knjigaId) {
        this.knjigaId = knjigaId;
    }

    /**
     * Postavlja naziv knjige na unetu vrednost.
     *
     * @parm naziv - naziv nove knjige.
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Postavlja primerke knjige na unetu vrednost. Uneta vrednost ne sme biti
     * null.
     *
     * @param primerci - lista primeraka knjige (ArrayList).
     * @throws NullPointerException - ukoliko su prosledjeni primerci null.
     */
    public void setPrimerci(ArrayList<PrimerakKnjige> primerci) {
        if (primerci == null) {
            throw new NullPointerException("Primerci knjige ne smeju biti null");
        }
        this.primerci = primerci;
    }

    /**
     * Postavlja zanr knjige na unetu vrednost. Uneta vrednost ne sme biti null.
     *
     * @param zanr - zanr knjige.
     * @throws NullPointerException - ukoliko je prosledjeni zanr null.
     */
    public void setZanr(Zanr zanr) {
        if (zanr == null) {
            throw new NullPointerException("Zanr knjige ne sme biti null");
        }
        this.zanr = zanr;
    }

    /**
     * Postavlja korsnika koji je kreirao knjigu na unetog korisnika. Uneta
     * vrednost ne sme biti null.
     *
     * @param korisnik - korsnik koji je kreirao knjigu.
     * @throws NullPointerException - ukoliko je prosledjeni korisnik null.
     */
    public void setKorisnik(Korisnik korisnik) {
        if (korisnik == null) {
            throw new NullPointerException("Korisnik knjige ne sme biti null");
        }
        this.korisnik = korisnik;
    }

    /**
     * Vraca id knjige.
     *
     * @return id knjige kao int.
     */
    public int getKnjigaId() {
        return knjigaId;
    }

    /**
     * Vraca naziv knjige.
     *
     * @return naziv knjige kao String.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Vraca zanr knjige.
     *
     * @return zanr knjige.
     */
    public Zanr getZanr() {
        return zanr;
    }

    /**
     * Vraca listu primeraka knjige.
     *
     * @return lista primeraka knjige (ArrayList).
     */
    public ArrayList<PrimerakKnjige> getPrimerci() {
        return primerci;
    }

    /**
     * Vraca korisnika koji je kreirao knjigu.
     *
     * @return korisnik koji je kreirao knjigu.
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Vraca string sa informacijama o nazivu knjige.
     *
     */
    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String getNazivTabele() {
        return "knjiga";
    }

    @Override
    public String getAlijas() {
        return "k";
    }

    @Override
    public String getKoloneZaDodavanje() {
        return "(Naziv,ZanrId,KorisnikId)";
    }

    @Override
    public String join() {
        return "JOIN zanr z ON(k.ZanrId=z.ZanrId)"
                + "JOIN korisnik ko ON (k.KorisnikId=ko.KorisnikId)";

    }

    @Override
    public String getKriterijum() {
        return "WHERE k.Naziv LIKE '%" + naziv + "%'";
    }

    @Override
    public String vrednostiZaDodavanje() {
        return "'" + naziv + "','" + zanr.getZanrId() + "','" + korisnik.getKorisnikId() + "'";
    }

    @Override
    public String vrednostiZaAzuriranje() {
        return "";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Knjiga k = new Knjiga();
            k.setKnjigaId(rs.getInt("k.KnjigaId"));
            k.setNaziv(rs.getString("k.Naziv"));

            Zanr z = new Zanr();
            z.setZanrId(rs.getInt("z.ZanrId"));
            z.setNaziv(rs.getString("z.Naziv"));
            k.setZanr(z);

            Korisnik ko = new Korisnik();
            ko.setKorisnikId(rs.getInt("ko.KorisnikId"));
            ko.setIme(rs.getString("ko.Ime"));
            ko.setPrezime(rs.getString("ko.Prezime"));
            ko.setPassword(rs.getString("ko.Password"));
            k.setKorisnik(ko);

            lista.add(k);

        }
        rs.close();
        return lista;
    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "KnjigaId=" + knjigaId;
    }

}
