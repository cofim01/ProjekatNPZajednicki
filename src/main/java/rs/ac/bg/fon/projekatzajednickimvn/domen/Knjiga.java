package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MRDAK-PC
 */
public class Knjiga implements OpstiDomenskiObjekat {

    private int knjigaId;
    private String naziv;
    private Zanr zanr;
    private Korisnik korisnik;
    private ArrayList<PrimerakKnjige> primerci=new ArrayList<>();

    public Knjiga() {
    }

    public Knjiga(int knjigaId, String naziv, Zanr zanr, Korisnik korisnik) {
        this.knjigaId = knjigaId;
        this.naziv = naziv;
        this.zanr = zanr;
        this.korisnik = korisnik;
    }


    public void setKnjigaId(int knjigaId) {
        this.knjigaId = knjigaId;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setPrimerci(ArrayList<PrimerakKnjige> primerci) {
        this.primerci = primerci;
    }

    

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public int getKnjigaId() {
        return knjigaId;
    }

    public String getNaziv() {
        return naziv;
    }


    public Zanr getZanr() {
        return zanr;
    }

    public ArrayList<PrimerakKnjige> getPrimerci() {
        return primerci;
    }

    

    public Korisnik getKorisnik() {
        return korisnik;
    }

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
        return "JOIN zanr z ON(k.ZanrId=z.ZanrId)"+
               "JOIN korisnik ko ON (k.KorisnikId=ko.KorisnikId)";
              
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
