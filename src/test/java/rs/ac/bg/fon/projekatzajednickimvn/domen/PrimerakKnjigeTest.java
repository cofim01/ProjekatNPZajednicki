package rs.ac.bg.fon.projekatzajednickimvn.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author MRDAK-PC
 */
public class PrimerakKnjigeTest {

    PrimerakKnjige pk;

    public PrimerakKnjigeTest() {
        pk = new PrimerakKnjige();
    }

    @Test
    public void testSetPrimerakId() {
        pk.setPrimerakId(15);
        assertEquals(15, pk.getPrimerakId());
    }

    @Test
    public void testSetBrojPolice() {
        pk.setBrojPolice(25);
        assertEquals(25, pk.getBrojPolice());
    }

    @Test
    public void testSetIzdavac() {
        Izdavac i = new Izdavac(5, "Delfi");
        pk.setIzdavac(i);
        assertEquals(5, pk.getIzdavac().getIzdavacId());
        assertEquals("Delfi", pk.getIzdavac().getNaziv());

    }

    @Test
    public void testSetGodinaIzdanja() {
        pk.setGodinaIzdanja(2023);
        assertEquals(2023, pk.getGodinaIzdanja());
    }

    @Test
    public void testSetStatus() {
        pk.setStatus("Dostupan");
        assertEquals("Dostupan", pk.getStatus());
    }

    @Test
    public void testSetKnjiga() {
        Zanr zanr = new Zanr(1, "Komedija");
        Korisnik korisnik = new Korisnik(1, "Nikola", "Nikolic", "nikola123");

        Knjiga k = new Knjiga(5, "Nova knjiga", zanr, korisnik);
        pk.setKnjiga(k);
        assertEquals(1, pk.getKnjiga().getZanr().getZanrId());
        assertEquals("Komedija", pk.getKnjiga().getZanr().getNaziv());
        assertEquals(5, pk.getKnjiga().getKnjigaId());
        assertEquals("Nova knjiga", pk.getKnjiga().getNaziv());
        assertEquals(korisnik, pk.getKnjiga().getKorisnik());
    }

    @Test
    public void testGetNazivTabele() {
        assertEquals("primerakKnjige", pk.getNazivTabele());
    }

    @Test
    public void testGetAlijas() {
        assertEquals("pk", pk.getAlijas());
    }

    @Test
    public void testGetKoloneZaDodavanje() {
        assertEquals("(idKnjiga,brojPolice,godinaIzdanja,idIzdavac,status)", pk.getKoloneZaDodavanje());
    }

    @Test
    public void testJoin() {
        assertEquals("JOIN knjiga k ON(pk.idKnjiga=k.KnjigaId)JOIN zanr z ON(k.ZanrId=z.ZanrId)JOIN korisnik ko ON (k.KorisnikId=ko.KorisnikId)JOIN izdavac i ON(pk.idIzdavac=i.IzdavacId)", pk.join());
    }

    @Test
    public void testGetVrednostPrimarniKljuc() {
        pk.setPrimerakId(6);
        assertEquals("idPrimerak=6", pk.getVrednostPrimarniKljuc());
    }

    @Test
    public void testGetKriterijum() {
        Knjiga knjiga = new Knjiga();
        knjiga.setKnjigaId(11);
        pk.setKnjiga(knjiga);
        assertEquals("WHERE idKnjiga=11", pk.getKriterijum());
    }

    @Test
    public void testVrednostiZaDodavanje() {
        Izdavac izdavac = new Izdavac();
        izdavac.setIzdavacId(1);
        Knjiga knjiga = new Knjiga();
        knjiga.setKnjigaId(1);
        pk.setKnjiga(knjiga);
        pk.setIzdavac(izdavac);
        pk.setBrojPolice(25);
        pk.setGodinaIzdanja(2016);
        pk.setStatus("Dostupan");
        assertEquals("'1','25','2016','1','Dostupan'", pk.vrednostiZaDodavanje());
    }

    @Test
    public void testVrednostiZaAzuriranje() {
        pk.setStatus("Nedostupan");
        assertEquals("status='Nedostupan'", pk.vrednostiZaAzuriranje());
    }

    @Test
    public void testToString() {
        pk.setPrimerakId(4);
        assertEquals("4", pk.toString());
    }

    @Test
    public void testGetLista() throws Exception {
        ResultSet rs = mock(ResultSet.class);
        when(rs.next()).thenReturn(true, false);

        when(rs.getInt("pk.idPrimerak")).thenReturn(1);
        when(rs.getInt("pk.brojPolice")).thenReturn(25);
        when(rs.getInt("pk.godinaIzdanja")).thenReturn(2016);
        when(rs.getString("pk.status")).thenReturn("Dostupan");

        when(rs.getInt("k.KnjigaId")).thenReturn(5);
        when(rs.getString("k.Naziv")).thenReturn("Nova knjiga");

        when(rs.getInt("i.IzdavacId")).thenReturn(6);
        when(rs.getString("i.Naziv")).thenReturn("Laguna");

        when(rs.getInt("z.ZanrId")).thenReturn(8);
        when(rs.getString("z.Naziv")).thenReturn("Triler");

        when(rs.getInt("ko.KorisnikId")).thenReturn(9);
        when(rs.getString("ko.Ime")).thenReturn("Nikola");
        when(rs.getString("ko.Prezime")).thenReturn("Nikolic");
        when(rs.getString("ko.Password")).thenReturn("nikola123");
        
        ArrayList<OpstiDomenskiObjekat> lista = new PrimerakKnjige().getLista(rs);
        
        assertEquals(1, lista.size());
        
        PrimerakKnjige primerak = (PrimerakKnjige) lista.get(0);
        assertEquals(1, primerak.getPrimerakId());
        assertEquals(25, primerak.getBrojPolice());
        assertEquals(2016, primerak.getGodinaIzdanja());
        assertEquals("Dostupan", primerak.getStatus());
        assertEquals("Nova knjiga", primerak.getKnjiga().getNaziv());
        assertEquals(6, primerak.getIzdavac().getIzdavacId());
        assertEquals("Laguna", primerak.getIzdavac().getNaziv());
        assertEquals("Triler", primerak.getKnjiga().getZanr().getNaziv());
        assertEquals(9, primerak.getKnjiga().getKorisnik().getKorisnikId());
        assertEquals("Nikola", primerak.getKnjiga().getKorisnik().getIme());
        assertEquals("Nikolic", primerak.getKnjiga().getKorisnik().getPrezime());
        assertEquals("nikola123", primerak.getKnjiga().getKorisnik().getPassword());
        

    }

}
