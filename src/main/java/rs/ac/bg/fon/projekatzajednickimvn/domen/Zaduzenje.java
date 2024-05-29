package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

/**
 * Predstavlja jedno zaduzenje knjige u biblioteci. Svako zaduzenje sadrzi broj zaduzenja, datum zaduzenja, datum razduzenja, primerak knjige koji je zaduzen, clana koji je zaduzio primerak,
 * korisnika koji je kreirao zaduzenje kao datume za filtriranje zaduzenja.
 * @author Filip Mrdak
 */
public class Zaduzenje implements OpstiDomenskiObjekat {
    /**
     * Broj zaduzenja kao int.
     */
    private int brZaduzenja;
    /**
     * Datum zaduzenja (Date).
     */
    private Date datumZaduzenja;
    /**
     * Datum razduzenja (Date).
     */
    private Date datumRazduzenja;
    /**
     * Primerak knjige koji je zaduzen.
     */
    private PrimerakKnjige primerak;
    /**
     * Clan koji je zaduzio primerak knjige.
     */
    private Clan clan;
    /**
     * Korisnik koji je kreirao zaduzenje.
     */
    private Korisnik korisnik;
    /**
     * Početni datum za filtriranje zaduzenja.
     */
    private Date datumOdFilter;
    /**
     * Krajnji datum za filtriranje zaduzenja.
     */
    private Date datumDoFilter;
    
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Podrazumevani konstruktor koji kreira novo zaduzenje.
     */
    public Zaduzenje() {
    }
    /**
     * Parametrizovani konstruktor koji kreira novo zaduzenje i postavlja vrednosti atributa na unete vrednosti.
     * @param brZaduzenja - broj novog zaduzenja kao int.
     * @param datumZaduzenja - datum zaduzenja primerka knjige.
     * @param datumRazduzenja - datum razduzenja primerka knjige.
     * @param primerak - primerak knjige koji je zaduzen.
     * @param clan - clan koji je zaduzio primerak knjige.
     * @param korisnik - korisnik koji je kreirao zaduzenje.
     */
    public Zaduzenje(int brZaduzenja, Date datumZaduzenja, Date datumRazduzenja, PrimerakKnjige primerak, Clan clan, Korisnik korisnik) {
        setBrZaduzenja(brZaduzenja);
        setDatumZaduzenja(datumZaduzenja);
        setDatumRazduzenja(datumRazduzenja);
        setPrimerak(primerak);
        setKorisnik(korisnik);
        setClan(clan);
    }

    
    /**
     * Postavlja broj zaduzenja na unetu vrednost.
     * @param brZaduzenja - broj zaduzenja kao int.
     */
    public void setBrZaduzenja(int brZaduzenja) {
        this.brZaduzenja = brZaduzenja;
    }
    /**
     * Postavlja datum zaduzenja primerka knjige na prosledjeni datum.
     * @param datumZaduzenja - datum zaduzenja primerka knjige.
     */
    public void setDatumZaduzenja(Date datumZaduzenja) {
        this.datumZaduzenja = datumZaduzenja;
    }
    /**
     * Postavlja datum razduzenja primerka knjige na prosledjeni datum.
     * @param datumRazduzenja - datum razduzenja primerka knjige.
     */
    public void setDatumRazduzenja(Date datumRazduzenja) {
        this.datumRazduzenja = datumRazduzenja;
    }
    /**
     * Postavlja clana koji je zaduzio primerak knjige.
     * @param clan - clan koji je zaduzio primerak knjige.
     */
    public void setClan(Clan clan) {
        this.clan = clan;
    }
    /**
     * Postavlja korisnika koji je kreirao zaduzenje.
     * @param korisnik - korisnik koji je kreirao zaduzenje.
     */
    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    /**
     * Postavlja primerak knjige koji je zaduzen.
     * @param primerak - primerak knjige koji je zaduzen.
     */
    public void setPrimerak(PrimerakKnjige primerak) {
        this.primerak = primerak;
    }
    /**
     * Postavlja pocetni datum za filtriranje zaduzenja.
     * @param datumDoFilter - pocetni datum za filtriranje zaduzenja.
     */
    public void setDatumDoFilter(Date datumDoFilter) {
        this.datumDoFilter = datumDoFilter;
    }
    /**
     * Postavlja krajnji datum za filtriranje zaduzenja.
     * @param datumOdFilter - krajnji datum za filtriranje zaduzenja.
     */
    public void setDatumOdFilter(Date datumOdFilter) {
        this.datumOdFilter = datumOdFilter;
    }
    /**
     * Vraca broj zaduzenja primerka knjige.
     * @return broj zaduzenja kao int.
     */
    public int getBrZaduzenja() {
        return brZaduzenja;
    }
    /**
     * Vraca primerak knjige koji je zaduzen.
     * @return primerak knjige koji je zaduzen.
     */
    public PrimerakKnjige getPrimerak() {
        return primerak;
    }
    
    /**
     * Vraca datum zaduzenja primerka knjige.
     * @return datum zaduzenja primerka knjige.
     */
    public Date getDatumZaduzenja() {
        return datumZaduzenja;
    }
    /**
     * Vraca datum razduzenja primerka knjige.
     * @return datum razduzenja primerka knjige.
     */
    public Date getDatumRazduzenja() {
        return datumRazduzenja;
    }
    /**
     * Vraca clana koji je zaduzio primerak knjige.
     * @return clan koji je zaduzio primerak knjige.
     */
    public Clan getClan() {
        return clan;
    }
    /**
     * Vraca korisnika koji je kreirao zaduzenje.
     * @return korisnik koji je kreirao zaduzenje.
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    @Override
    public String getNazivTabele() {
        return "zaduzenje";
    }

    @Override
    public String getAlijas() {
        return "zd";
    }

    @Override
    public String getKoloneZaDodavanje() {
        return "(DatumZaduzenja,IdClan,IdPrimerak,KorisnikId,KnjigaId)";
    }

    @Override
    public String join() {
        return "JOIN Clan c ON(zd.IdClan=c.ClanId)"
                +"JOIN primerakKnjige pk ON (zd.IdPrimerak=pk.IdPrimerak)"
                +"JOIN knjiga k ON(pk.idKnjiga=k.KnjigaId)"
                + "JOIN  zanr z ON(k.ZanrId=z.ZanrId)"
                + "JOIN izdavac i ON(pk.idIzdavac=i.IzdavacId)"
                + "JOIN korisnik kk ON(k.KorisnikId=kk.KorisnikId)"
                + "JOIN korisnik kz ON(zd.KorisnikId=kz.KorisnikId)";
    }

    @Override
    public String getKriterijum() {
        String s1= "WHERE idClan="+clan.getClanId();
        if(datumOdFilter!=null && datumDoFilter!=null){
            s1 = s1 + " AND DatumZaduzenja >= '" + sdf.format(datumOdFilter) + "' AND DatumZaduzenja <= '" + sdf.format(datumDoFilter) + "'";
        }
        s1=s1+" ORDER BY DatumZaduzenja DESC";
        return s1;
    }

    @Override
    public String vrednostiZaDodavanje() {
        return "'" + java.sql.Date.valueOf(sdf.format(datumZaduzenja)) + "','" + clan.getClanId() + "','" + primerak.getPrimerakId() + "','" + korisnik.getKorisnikId()  + "','" + primerak.getKnjiga().getKnjigaId() + "'";
    }

    @Override
    public String vrednostiZaAzuriranje() {
        return "DatumRazduzenja='" + java.sql.Date.valueOf(sdf.format(datumRazduzenja)) + "'";
    }

    @Override
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Zaduzenje zd = new Zaduzenje();
            zd.setBrZaduzenja(rs.getInt("BrojZaduzenja"));

            Date datumZ = new Date(rs.getDate("DatumZaduzenja").getTime());
            Date datumR;
            Date datumRazduzenjaSQL = rs.getDate("DatumRazduzenja");
            if (datumRazduzenjaSQL != null) {
                datumR = new Date(datumRazduzenjaSQL.getTime());
            } else {
                datumR = null;
            }
            //podaci o datumima zaduzenja i razduzenja
            zd.setDatumZaduzenja(datumZ);
            zd.setDatumRazduzenja(datumR);

            //clan koji je zaduzio knjigu
            Clan c = new Clan();
            c.setClanId(rs.getInt("c.ClanId"));
            c.setIme(rs.getString("c.Ime"));
            c.setPrezime(rs.getString("c.Prezime"));
            c.setBrTelefona(rs.getString("c.BrojTelefona"));
            c.setAdresa(rs.getString("c.Adresa"));
            zd.setClan(c);

            //primerak knjige koji je zaduzen
            PrimerakKnjige pk=new PrimerakKnjige();
            pk.setPrimerakId(rs.getInt("pk.idPrimerak"));
            pk.setBrojPolice(rs.getInt("pk.brojPolice"));
            pk.setGodinaIzdanja(rs.getInt("pk.godinaIzdanja"));
            pk.setStatus(rs.getString("pk.status"));
            
            
            //izdavac primerka knjige
            Izdavac i = new Izdavac();
            i.setIzdavacId(rs.getInt("i.IzdavacId"));
            i.setNaziv(rs.getString("i.Naziv"));
            pk.setIzdavac(i);
            
            //knjiga za koju se vezuje primerak
            Knjiga k=new Knjiga();
            
            k.setKnjigaId(rs.getInt("k.KnjigaId"));
            k.setNaziv(rs.getString("k.Naziv"));
            //zanr knjige 
            Zanr z = new Zanr();
            z.setZanrId(rs.getInt("z.ZanrId"));
            z.setNaziv(rs.getString("z.Naziv"));
            k.setZanr(z);

            //korisnik koji je kreirao knjigu
            Korisnik ko = new Korisnik();
            ko.setKorisnikId(rs.getInt("kk.KorisnikId"));
            ko.setIme(rs.getString("kk.Ime"));
            ko.setPrezime(rs.getString("kk.Prezime"));
            ko.setPassword(rs.getString("kk.Password"));
            k.setKorisnik(ko);

            pk.setKnjiga(k);
            zd.setPrimerak(pk);
            //korisnik koji je kreirao zaduzenje
            Korisnik kz = new Korisnik();
            kz.setKorisnikId(rs.getInt("kz.KorisnikId"));
            kz.setIme(rs.getString("kz.Ime"));
            kz.setPrezime(rs.getString("kz.Prezime"));
            kz.setPassword(rs.getString("kz.Password"));
            k.setKorisnik(ko);

            zd.setKorisnik(kz);

            lista.add(zd);
        }
        rs.close();
        return lista;
    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "BrojZaduzenja=" + brZaduzenja;
    }

}
