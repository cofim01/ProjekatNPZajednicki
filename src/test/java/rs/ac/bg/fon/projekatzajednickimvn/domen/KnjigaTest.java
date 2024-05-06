
package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class KnjigaTest {
    
    private Knjiga knjiga;
    
    public KnjigaTest() {
        knjiga=new Knjiga();
    }
    
    @Test
    public void testKnjigaParm(){
        Zanr zanr = new Zanr(1, "Komedija");
        Korisnik korisnik = new Korisnik(1, "Nikola", "Nikolic", "nikola123");

        knjiga = new Knjiga(1, "Nova knjiga", zanr, korisnik);

        assertEquals(1, knjiga.getKnjigaId());
        assertEquals("Nova knjiga", knjiga.getNaziv());
        assertEquals(zanr, knjiga.getZanr());
        assertEquals(korisnik, knjiga.getKorisnik());
    
    }
    

    @Test
    public void testSetKnjigaId() {
        knjiga.setKnjigaId(1);
        assertEquals(1, knjiga.getKnjigaId());
    }


    @Test
    public void testSetNaziv() {
        knjiga.setNaziv("Nova knjiga");
        assertEquals("Nova knjiga", knjiga.getNaziv());
    }


    @Test
    public void testSetPrimerci() {
        PrimerakKnjige pk1=new PrimerakKnjige(1, 25, new Izdavac(2, "Laguna"), 2016, "Dostupna");
        ArrayList<PrimerakKnjige> primerci = new ArrayList<>();
        primerci.add(pk1);
        knjiga.setPrimerci(primerci);
        assertEquals(1, knjiga.getPrimerci().size());
        assertEquals(1, knjiga.getPrimerci().get(0).getPrimerakId());
        assertEquals(25, knjiga.getPrimerci().get(0).getBrojPolice());
        assertEquals(2, knjiga.getPrimerci().get(0).getIzdavac().getIzdavacId());
        assertEquals("Laguna", knjiga.getPrimerci().get(0).getIzdavac().getNaziv());
        assertEquals("Dostupna", knjiga.getPrimerci().get(0).getStatus());
    }

 
    @Test
    public void testSetZanr() {
        Zanr z=new Zanr(1, "Komedija");
        knjiga.setZanr(z);
        assertEquals(1, knjiga.getZanr().getZanrId());
        assertEquals("Komedija", knjiga.getZanr().getNaziv());
    }


    @Test
    public void testSetKorisnik() {
        Korisnik k=new Korisnik(1, "Pera", "Peric", "Pera123");
        knjiga.setKorisnik(k);
        assertEquals(1, knjiga.getKorisnik().getKorisnikId());
        assertEquals("Pera", knjiga.getKorisnik().getIme());
        assertEquals("Peric", knjiga.getKorisnik().getPrezime());
        assertEquals("Pera123", knjiga.getKorisnik().getPassword());
        
    }


    @Test
    public void testToString() {
        knjiga.setNaziv("Knjiga 1");
        String s=knjiga.toString();
        s.contains("Knjiga 1");
    }


    @Test
    public void testGetNazivTabele() {
        assertEquals("knjiga", knjiga.getNazivTabele());
    }


    @Test
    public void testGetAlijas() {
        assertEquals("k", knjiga.getAlijas());
    }

    @Test
    public void testGetKoloneZaDodavanje() {
        assertEquals("(Naziv,ZanrId,KorisnikId)", knjiga.getKoloneZaDodavanje());
    }

    @Test
    public void testJoin() {
        assertEquals("JOIN zanr z ON(k.ZanrId=z.ZanrId)JOIN korisnik ko ON (k.KorisnikId=ko.KorisnikId)", knjiga.join());
    }


    @Test
    public void testGetKriterijum() {
        knjiga.setNaziv("Nova knjiga");
        assertEquals("WHERE k.Naziv LIKE '%Nova knjiga%'", knjiga.getKriterijum());
    }


    @Test
    public void testVrednostiZaDodavanje() {
        Zanr zanr = new Zanr();
        zanr.setZanrId(1);
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnikId(1);
        knjiga.setNaziv("Nova knjiga");
        knjiga.setZanr(zanr);
        knjiga.setKorisnik(korisnik);
        assertEquals("'Nova knjiga','1','1'", knjiga.vrednostiZaDodavanje());
    }


    @Test
    public void testVrednostiZaAzuriranje() {
        assertEquals("", knjiga.vrednostiZaAzuriranje());
    }


    @Test
    public void testGetLista() throws Exception {
        ResultSet rs = mock(ResultSet.class);
        when(rs.next()).thenReturn(true, false);
        
        when(rs.getInt("k.KnjigaId")).thenReturn(1);
        when(rs.getString("k.Naziv")).thenReturn("Nova knjiga");
        when(rs.getInt("z.ZanrId")).thenReturn(1);
        when(rs.getString("z.Naziv")).thenReturn("Komedija");
        when(rs.getInt("ko.KorisnikId")).thenReturn(1);
        when(rs.getString("ko.Ime")).thenReturn("Nikola");
        when(rs.getString("ko.Prezime")).thenReturn("Nikolic");
        when(rs.getString("ko.Password")).thenReturn("nikola123");

        ArrayList<OpstiDomenskiObjekat> result = knjiga.getLista(rs);

        assertNotNull(result);
        assertEquals(1, result.size());


        Knjiga k = (Knjiga) result.get(0);
        assertEquals(1, k.getKnjigaId());
        assertEquals("Nova knjiga", k.getNaziv());
        assertEquals(1, k.getZanr().getZanrId());
        assertEquals("Komedija", k.getZanr().getNaziv());
        assertEquals(1, k.getKorisnik().getKorisnikId());
        assertEquals("Nikola", k.getKorisnik().getIme());
        assertEquals("Nikolic", k.getKorisnik().getPrezime());
        assertEquals("nikola123", k.getKorisnik().getPassword());
    }


    @Test
    public void testGetVrednostPrimarniKljuc() {
        knjiga.setKnjigaId(1);
        assertEquals("KnjigaId=1", knjiga.getVrednostPrimarniKljuc());
    }
    
}
