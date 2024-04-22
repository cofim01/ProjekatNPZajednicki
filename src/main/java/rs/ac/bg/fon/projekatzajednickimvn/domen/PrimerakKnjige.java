
package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author MRDAK-PC
 */
public class PrimerakKnjige implements OpstiDomenskiObjekat{
    private int primerakId;
    private int brojPolice;
    private Izdavac izdavac;
    private Knjiga knjiga;
    private int godinaIzdanja;
    private String status;
    

    public PrimerakKnjige() {
    }

    public PrimerakKnjige(int primerakId, int brojPolice, Izdavac izdavac, int godinaIzdanja, String status) {
        this.primerakId = primerakId;
        this.brojPolice = brojPolice;
        this.izdavac = izdavac;
        this.godinaIzdanja = godinaIzdanja;
        this.status = status;
    }


    public int getPrimerakId() {
        return primerakId;
    }

    public int getBrojPolice() {
        return brojPolice;
    }


    

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public String getStatus() {
        return status;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }
    
    

    public void setPrimerakId(int primerakId) {
        this.primerakId = primerakId;
    }

    public void setBrojPolice(int brojPolice) {
        this.brojPolice = brojPolice;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }


    

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setKnjiga(Knjiga knjiga) {
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
        return  "JOIN knjiga k ON(pk.idKnjiga=k.KnjigaId)"+
                "JOIN zanr z ON(k.ZanrId=z.ZanrId)"+
                "JOIN korisnik ko ON (k.KorisnikId=ko.KorisnikId)"+
                "JOIN izdavac i ON(pk.idIzdavac=i.IzdavacId)";
                
    }

    @Override
    public String getVrednostPrimarniKljuc() {
        return "idPrimerak="+primerakId;
    }

    @Override
    public String getKriterijum() {
        return "WHERE idKnjiga="+knjiga.getKnjigaId();
    }

    @Override
    public String vrednostiZaDodavanje() {
        return "'" + knjiga.getKnjigaId() + "','" + brojPolice + "','" + godinaIzdanja + "','" + izdavac.getIzdavacId() +  "','" + status + "'";
    }

    @Override
    public String vrednostiZaAzuriranje() {
        return "status='" + status+ "'";
    }

    @Override
    public String toString() {
        return primerakId+"";
    }
    

    @Override
    public ArrayList<OpstiDomenskiObjekat> getLista(ResultSet rs) throws SQLException {
        ArrayList<OpstiDomenskiObjekat> lista=new ArrayList<>();
        while(rs.next()){
            PrimerakKnjige primerak=new PrimerakKnjige();
            primerak.setPrimerakId(rs.getInt("pk.idPrimerak"));
            primerak.setBrojPolice(rs.getInt("pk.brojPolice"));
            primerak.setGodinaIzdanja(rs.getInt("pk.godinaIzdanja"));
            primerak.setStatus(rs.getString("pk.status"));
            
            Knjiga k=new Knjiga();
            k.setKnjigaId(rs.getInt("k.KnjigaId"));
            k.setNaziv(rs.getString("k.Naziv"));
            
            Zanr z=new Zanr();
            z.setNaziv(rs.getString("z.Naziv"));
            z.setZanrId(rs.getInt("ZanrId"));
            k.setZanr(z);
            
            Izdavac i=new Izdavac();
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
